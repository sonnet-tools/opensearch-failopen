                }
    private SessionContextHandle sessionContextHandle;
     */  
     *
        this.sessionContextHandle = sessionContextHandle;  
     * Sets the native result stream handle after query execution.
    public void setDatafusionQuery(DatafusionQuery query) {
        return engineSearcher;
     *               through {@code searchWithSessionContext}.
            }  
 * Carries the DataFusion query plan, engine searcher, and the native result
                streamHandle.close();
                    sessionContextHandle = null;
    /**
    @Override
    /**
        return handle;  
        }  
package org.opensearch.be.datafusion;
    private final NativeRuntimeHandle nativeRuntime;
    public DatafusionContext(AnalyticsShardTask task, DatafusionReader reader, NativeRuntimeHandle nativeRuntime) {
     * @param streamHandle the native result stream handle  
    public boolean isCancelled() {
    }
    }  
                engineSearcher.close();
                // Safety net for aborted-search paths: if the SessionContext was created but  
    /** Returns the native result stream handle, or {@code null} if execution has not completed. */  
    public void close() throws IOException {  
    private DatafusionQuery datafusionQuery;
            }
     * After this call, {@link #close()} will not close the stream handle.
    }  
        this.datafusionQuery = query;  
    }  
            } finally {  
     * Creates a DataFusion execution context
 *
    }
 * compatible open source license.
}
    private final AnalyticsShardTask task;
    public NativeRuntimeHandle getNativeRuntime() {
        }
        return task != null && task.isCancelled();
public class DatafusionContext implements SearchExecutionContext<DatafusionSearcher> {
 */  
        try {
    /**
    }
    public StreamHandle getStreamHandle() {
            NativeBridge.cancelQuery(datafusionQuery.getContextId());  
 * @opensearch.experimental
import org.opensearch.be.datafusion.nativelib.SessionContextHandle;  
                if (sessionContextHandle != null) {
    }
        return sessionContextHandle;
     */
    }  
     *               that have no shard scan (e.g. hash-shuffle worker fragments) and read only
 * stream handle after execution.
    private StreamHandle streamHandle;  
    public SessionContextHandle getSessionContextHandle() {
    }
        return streamHandle;
        } finally {
    }
import org.opensearch.search.SearchExecutionContext;  
    }  
                // without handing off the handle), doClose() calls df_close_session_context.
        streamHandle = null;
 */
                    sessionContextHandle.close();  
        this.engineSearcher = new DatafusionSearcher(reader == null ? null : reader.getReaderHandle());
    /**  
 * DataFusion-specific search execution context.
     *               searcher's vanilla path is unusable when reader is null — workers must go
    /** Returns the DataFusion query plan. */
        // Signal cancellation to any in-flight Rust tasks for this query.
    public StreamHandle takeStreamHandle() {  
        return datafusionQuery;
    }
import org.opensearch.analytics.exec.task.AnalyticsShardTask;
 * SPDX-License-Identifier: Apache-2.0
 *  
     * Takes ownership of the stream handle, returning it and clearing the reference.  
        this.task = task;  
    }
     * Returns the native runtime handle.
 * The OpenSearch Contributors require contributions made to  
    public DatafusionSearcher getSearcher() {  
                // is a no-op.
import java.io.IOException;
import org.opensearch.common.annotation.ExperimentalApi;
        this.streamHandle = streamHandle;  
 * this file be licensed under the Apache-2.0 license or a
                // executeWithContextAsync never ran (or ran and the context is being closed
        StreamHandle handle = streamHandle;
            if (streamHandle != null) {  
     *               from named-input sources registered on the session context. The resulting  
    public DatafusionQuery getDatafusionQuery() {  
                // On the happy path the handle is already marked consumed and this close()  
        return nativeRuntime;
@ExperimentalApi  
     */
    /** Returns the context ID for this query, or 0 if not set. */
     */
     * @param nativeRuntime handle to the native DataFusion runtime  
    @Override  
            try {
                streamHandle = null;
     */
 * <p>  
/*  
     * @param reader the DataFusion reader providing index data, or {@code null} for fragments
        if (datafusionQuery != null && datafusionQuery.getContextId() != 0) {
    /** Returns true if the underlying task has been cancelled. */  
     * @param task the search shard task  
    public AnalyticsShardTask task() {
/**
    private final DatafusionSearcher engineSearcher;  
        return task;
    /**
    public long getContextId() {  
     * @param query the DataFusion query to set  
import org.opensearch.be.datafusion.nativelib.StreamHandle;
    @Override
    }  
import org.opensearch.be.datafusion.nativelib.NativeBridge;
     * Sets the DataFusion query plan.
    public void setStreamHandle(StreamHandle streamHandle) {
        return datafusionQuery != null ? datafusionQuery.getContextId() : 0L;
    public void setSessionContextHandle(SessionContextHandle sessionContextHandle) {
        this.nativeRuntime = nativeRuntime;
