        if (stagingAllocator == null) {
    @Override
            // addCancellationListener composes so both native-cancel and buffer cleanup fire.
        this.datafusionContext = datafusionContext;
        DatafusionSearcher searcher = datafusionContext.getSearcher();
            // same task. setCancellationListener is single-slot and would let one overwrite the other;  
import org.opensearch.analytics.backend.EngineResultStream;
import org.opensearch.common.annotation.ExperimentalApi;
        return new DatafusionResultStream(handle, allocator, stagingAllocator);
package org.opensearch.be.datafusion;
import org.opensearch.analytics.backend.SearchExecEngine;  
    public void prepare(ShardScanExecutionContext requestContext) {
        searcher.search(datafusionContext);  
    public EngineResultStream execute(ShardScanExecutionContext requestContext) throws IOException {  
 * DataFusion-backed search execution engine.
 */  
    @Override
        long contextId = datafusionContext.getContextId();
 * <p>
            // Additive: a worker fragment also registers a shuffle-buffer-cleanup cancel hook on this
            shardTask.addCancellationListener(() -> NativeBridge.cancelQuery(contextId));
    private final DatafusionContext datafusionContext;
import org.opensearch.be.datafusion.nativelib.StreamHandle;
        // immediately fires the Rust CancellationToken.
    }  
        if (shardTask != null) {
        if (allocator == null) {
        }
        AnalyticsShardTask shardTask = datafusionContext.task();  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.analytics.exec.task.AnalyticsShardTask;
}  
    }
import java.io.IOException;
            throw new IllegalStateException("ExecutionContext.importStagingAllocator must be set by the caller before execute()");  
        long contextId = datafusionContext.task() != null ? datafusionContext.task().getNativeTaskId() : 0L;
 * @opensearch.experimental
 * compatible open source license.
/**  
import org.opensearch.analytics.backend.ShardScanExecutionContext;
public class DatafusionSearchExecEngine implements SearchExecEngine<ShardScanExecutionContext, EngineResultStream> {
@ExperimentalApi
        StreamHandle handle = datafusionContext.takeStreamHandle();
        datafusionContext.setDatafusionQuery(new DatafusionQuery(requestContext.getTableName(), substraitBytes, contextId));
        BufferAllocator allocator = requestContext.getAllocator();
    public void close() throws IOException {  
 */  
 * Delegates execution to the native DataFusion runtime via {@link DatafusionSearcher}.  
 * SPDX-License-Identifier: Apache-2.0
        BufferAllocator stagingAllocator = requestContext.getImportStagingAllocator();
import org.apache.arrow.memory.BufferAllocator;
    }
        datafusionContext.close();
        // after this stream closes, so it must be supplied rather than minted per stream.  
 * The OpenSearch Contributors require contributions made to  
/*  
import org.opensearch.be.datafusion.nativelib.NativeBridge;  
        byte[] substraitBytes = requestContext.getFragmentBytes();  
    @Override
        // Register cancellation hook so HTTP disconnect / _tasks/_cancel / timeout  
 *
 *
        }  
            throw new IllegalStateException("ExecutionContext.allocator must be set by the caller before execute()");  
    }  
        // Node-scoped and unbounded — batches are imported onto it and the Flight transport keeps charging it
    public DatafusionSearchExecEngine(DatafusionContext datafusionContext) {  
        }
