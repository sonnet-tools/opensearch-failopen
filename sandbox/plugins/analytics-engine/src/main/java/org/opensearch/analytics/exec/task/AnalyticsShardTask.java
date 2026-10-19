    // independent concerns register a cancel hook on the SAME task — e.g. the DataFusion engine's
 * The OpenSearch Contributors require contributions made to  
 * DataFusion memory to cancellation.
    @Override  
        if (isCancelled() && cancellationListeners.remove(listener)) {  
import java.util.Map;
 * from {@link SearchShardTask}).
    @Override
 * in {@code SearchBackpressureService} filters by {@code SearchShardTask},  
        }
 * tasks alongside regular search shard tasks. The native-memory tracker
     * cancelled, ALONGSIDE any other registered listeners and the single-slot one — it does not
 *
        super(id, type, action, description, parentTaskId, headers);
     * JVM-unique id keying this execution's native tracking context. {@link #getId()}
    /**
 * <p>Extends {@link SearchShardTask} so that search backpressure and  
 * Data-node shard task representing a single shard fragment execution.
import org.opensearch.analytics.spi.NativeTaskIdManager;
            listener.run();
        cancellationListener.set(null);  
    public long getNativeTaskId() {
     * immediately. Use this (not {@link #setCancellationListener}) when multiple independent
     */
            return;  
        }
     */  
    private final Queue<Runnable> cancellationListeners = new ConcurrentLinkedQueue<>();
import org.opensearch.core.tasks.TaskId;  
    /** JVM-unique id for this execution's native tracking context (see field javadoc). */
    }
        if (listener == null) {
        if (listener != null) {  
}
        }
 */
 * @opensearch.internal
    // overwrite the other (a leak / missed-cancel). These all fire on cancellation.  
public class AnalyticsShardTask extends SearchShardTask {  
    }
    public AnalyticsShardTask(long id, String type, String action, String description, TaskId parentTaskId, Map<String, String> headers) {  
            Runnable taken = cancellationListener.getAndSet(null);  
    /**  
    }
import java.util.concurrent.ConcurrentLinkedQueue;
        while ((additive = cancellationListeners.poll()) != null) {  
    protected void onCancelled() {  
    /**  
package org.opensearch.analytics.exec.task;
        return false;  
 *  
            listener.run();
     * replace them. If the task is already cancelled at registration time, the listener fires  
    }
 */  
    @Override
        return nativeTaskId;  
    }  
        cancellationListeners.add(listener);
     * If the task is already cancelled at registration time, the listener fires immediately.
 *  
    }  
/*  
     * concerns each need a cancel hook on the same task.
 * so inheriting from it is the integration point that exposes per-query
        if (isCancelled()) {
    public boolean shouldCancelChildrenOnCancellation() {
     * process-wide native registry when nodes share a JVM (internal test clusters).  
    public void clearCancellationListener() {
    }
    public boolean supportsResourceTracking() {
    public void setCancellationListener(Runnable listener) {  
        Runnable additive;
    /** Removes the cancellation listener, e.g. after the query completes normally. */
        super.onCancelled();
    private final long nativeTaskId = NativeTaskIdManager.next();
        return true;
 * compatible open source license.
        }
import java.util.Queue;  
 * this file be licensed under the Apache-2.0 license or a
    // Additive cancellation listeners (run in addition to the single-slot one above). Multiple  
import org.opensearch.action.search.SearchShardTask;
            if (taken != null) {
    }  
            }  
     * must not be used for that: task ids are per-node counters and collide in the
import java.util.concurrent.atomic.AtomicReference;
     * Registers a listener that is called exactly once when this task is cancelled.  
        cancellationListener.set(listener);
    public void addCancellationListener(Runnable listener) {
        Runnable listener = cancellationListener.getAndSet(null);
/**
    // native-cancel and the shuffle-buffer cleanup — and the single-slot setter would let one
        }
    private final AtomicReference<Runnable> cancellationListener = new AtomicReference<>();
 * SPDX-License-Identifier: Apache-2.0
     */
                taken.run();
        // onCancelled races with a late addCancellationListener (which fires inline on its own).
 * <p>Cancelling this task does not cascade to children (inherited behaviour
 * {@code TaskResourceTrackingService} observe and track analytics shard
            additive.run();
     * Registers an ADDITIVE cancellation listener that runs (exactly once) when this task is
        // Drain and run the additive listeners. poll() ensures each runs at most once even if  
