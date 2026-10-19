    public void close() throws IOException {  
 *
 * <p>Produced by {@link FinalAggregateInstructionHandler} and consumed by
 * contract.
import java.util.List;
 * @opensearch.internal  
public record DataFusionReduceState(DatafusionLocalSession session, NativeRuntimeHandle runtimeHandle, List<
                sender.close();
 */  
 * plan has been prepared. Carries the local session (with the prepared plan stored on the  
package org.opensearch.be.datafusion;
        session.close();
    }
 * Rust side), the runtime handle, the partition senders used to feed Arrow batches into the
        }  
 *
/**
import org.opensearch.analytics.spi.BackendExecutionContext;
 * SPDX-License-Identifier: Apache-2.0
        // Close senders first, then session.
    DatafusionPartitionSender> senders, List<Schema> inputSchemas) implements BackendExecutionContext {  
    @Override
        for (DatafusionPartitionSender sender : senders) {
 * compatible open source license.
 * {@link DatafusionReduceSink} via the {@link org.opensearch.analytics.spi.ExchangeSinkProvider}  
 * The OpenSearch Contributors require contributions made to  
 * (parallel to {@code senders}; same order as {@code ctx.childInputs()}).  
            try {  
 *
import org.apache.arrow.vector.types.pojo.Schema;
 */
 * Backend-specific execution context for the coordinator-reduce path when a final-aggregate
 * streaming input partitions, and the schemas the native session settled on for each input
/*  
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
            } catch (Exception ignored) {}
}  
