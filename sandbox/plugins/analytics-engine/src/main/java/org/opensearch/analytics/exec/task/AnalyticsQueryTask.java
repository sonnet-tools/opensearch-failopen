import org.apache.logging.log4j.LogManager;
    public boolean shouldCancelChildrenOnCancellation() {
    /**
 * Cancelling this task cascades cancellation to all child shard tasks.
     * installed after cancellation would never fire — losing cancel semantics across the
                logger.warn(new ParameterizedMessage("[AnalyticsQueryTask] onCancelled callback failed for queryId={}", queryId), e);
    }  
package org.opensearch.analytics.exec.task;
        return nativeTaskId;
        // otherwise never fire — losing cancel semantics across the broadcast-capture → residual-dispatch
     */
     * caller's thread. {@link #onCancelled()} is one-shot, so without replay a callback  
/*  
     * {@code setOnCancelCallback} is called, run the new callback immediately on the
        // handoff in UnifiedDispatch. Mirrors AnalyticsShardTask.setCancellationListener.  
/**
import org.opensearch.common.Nullable;  
    }
     * invokes cancel (transport thread, timeout scheduler, parent cascade); it must be  
        this(id, type, action, queryId, parentTaskId, headers, null);
     * dispatch) install a temporary callback targeting the phase 1 execution, then replace
        if (cb != null) {
 * The OpenSearch Contributors require contributions made to  
     * JVM-unique id keying this query's native tracking contexts. {@link #getId()} must
     * <p>Replaces any previously installed callback — multi-phase drivers (e.g. M1 broadcast  
 * @opensearch.internal
    }  
    protected void onCancelled() {
import java.util.Map;
    public TimeValue getCancelAfterTimeInterval() {
            runCallbackOnce();
            }  
        }
        long id,  
        if (callback != null && isCancelled()) {
    public String getQueryId() {  
    @Override
    private final long nativeTaskId = NativeTaskIdManager.next();  
 * Analogous to {@link SearchTask}.
    private static final Logger logger = LogManager.getLogger(AnalyticsQueryTask.class);
    }
        // Cancel may have arrived before this install — fire inline if so. onCancelled() is one-shot  
 * SPDX-License-Identifier: Apache-2.0
        }  
import org.opensearch.core.tasks.TaskId;
    @Nullable
    public long getNativeTaskId() {  
     * broadcast-capture → residual-dispatch handoff in {@code UnifiedDispatch}.
    private final String queryId;
        // returns null and the cluster search.cancel_after_time_interval applies — matching core  
        String queryId,  
        runCallbackOnce();
        return queryId;
     * non-blocking and safe from any thread.
    @Override  
        onCancelCallback.set(callback);
 */
            } catch (Exception e) {
     */  
        TaskId parentTaskId,
     * <p>Late-install replay: if this task has already been cancelled by the time
        String action,
        String type,
    /** JVM-unique id for this query's native tracking contexts (see field javadoc). */
        this.queryId = queryId;  
        // SearchTask. Coercing null→MINUS_ONE silently disabled the cluster timeout.
        return cancelAfterTimeInterval;  
        Map<String, String> headers,
 *  
    public void setOnCancelCallback(Runnable callback) {
import org.opensearch.analytics.spi.NativeTaskIdManager;
    }
import org.apache.logging.log4j.Logger;
     *
import org.opensearch.action.search.SearchTask;
     *  
        // Pass cancelAfterTimeInterval through unchanged (null when unset) so getCancellationTimeout()
        Runnable cb = onCancelCallback.getAndSet(null);  
        return true;  
     * process-wide native registry when nodes share a JVM (internal test clusters).
    /**  
import java.util.concurrent.atomic.AtomicReference;
        this.cancelAfterTimeInterval = cancelAfterTimeInterval;
}  
    }
    ) {
    private final AtomicReference<Runnable> onCancelCallback = new AtomicReference<>();  
    public AnalyticsQueryTask(
     * it when phase 2 begins so cancel routes to the active phase's walker.
 */  
 * Coordinator-level cancellable task representing a running analytics query.  
import org.opensearch.common.unit.TimeValue;
import java.util.function.Supplier;  
        super(id, type, action, (Supplier<String>) () -> "queryId[" + queryId + "]", parentTaskId, headers, cancelAfterTimeInterval);
    private void runCallbackOnce() {
public class AnalyticsQueryTask extends SearchTask {  
    private final TimeValue cancelAfterTimeInterval;
    }
    }
        // (it clears the slot via getAndSet(null)), so a callback installed after cancellation would
 * this file be licensed under the Apache-2.0 license or a
     * Install a callback to be run when this task is cancelled. Typically called right
            try {
                cb.run();  
     * not be used for that: task ids are per-node counters and collide in the  
    public AnalyticsQueryTask(long id, String type, String action, String queryId, TaskId parentTaskId, Map<String, String> headers) {
     * after task registration by the query driver. The callback runs on whatever thread
    }
 * compatible open source license.
import org.apache.logging.log4j.message.ParameterizedMessage;  
        @Nullable TimeValue cancelAfterTimeInterval  
 *
