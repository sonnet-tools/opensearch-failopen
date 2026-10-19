                inputSchemas.add(ArrowSchemaIpc.fromBytes(registered.schemaIpc()));  
                NativeBridge.RegisteredInput registered = NativeBridge.registerPartitionStream(  
 */  
                try {
 * the {@link DatafusionReduceSink} can later execute the prepared plan and feed batches.  
    private final NativeRuntimeHandle runtimeHandle;
import org.opensearch.analytics.spi.BackendExecutionContext;
            }
/*  
 * registers streaming input partitions from child stages, and prepares the final-aggregate
 *
        this.runtimeHandle = runtimeHandle;
        List<Schema> inputSchemas = new ArrayList<>(ctx.childInputs().size());
        CommonExecutionContext commonContext,
    FinalAggregateInstructionHandler(NativeRuntimeHandle runtimeHandle) {  
            for (DatafusionPartitionSender sender : senders) {
            session.close();  
 * SPDX-License-Identifier: Apache-2.0
        return new DataFusionReduceState(session, runtimeHandle, senders, inputSchemas);  
import org.opensearch.be.datafusion.nativelib.NativeBridge;
                    session.getPointer(),
public class FinalAggregateInstructionHandler implements FragmentInstructionHandler<FinalAggregateInstructionNode> {
        List<DatafusionPartitionSender> senders = new ArrayList<>(ctx.childInputs().size());
    ) {  
 * <p>Returns a {@link DataFusionReduceState} carrying the session, runtime, and senders so
    public BackendExecutionContext apply(
    }
import org.opensearch.analytics.spi.CommonExecutionContext;  
        } catch (RuntimeException e) {  
            }
        BackendExecutionContext backendContext
}
            NativeBridge.prepareFinalPlan(session.getPointer(), ctx.fragmentBytes());
 */
import org.opensearch.analytics.spi.ExchangeSinkContext;
        FinalAggregateInstructionNode node,  
                    child.producerPlanBytes()  
                );
                String inputId = "input-" + child.childStageId();
import org.opensearch.analytics.spi.FragmentInstructionHandler;  
 * physical plan.  
            for (ExchangeSinkContext.ChildInput child : ctx.childInputs()) {
import java.util.ArrayList;  
                } catch (Exception ignored) {}
                    sender.close();  
 * Handles FinalAggregate instruction for coordinator-reduce stages: creates a local session,
package org.opensearch.be.datafusion;
 *
 * this file be licensed under the Apache-2.0 license or a
                    inputId,
        }
    }
 * The OpenSearch Contributors require contributions made to  
/**  
import java.util.List;
import org.apache.arrow.vector.types.pojo.Schema;
            throw e;
                senders.add(new DatafusionPartitionSender(registered.pointer()));
        try {  
import org.opensearch.analytics.spi.FinalAggregateInstructionNode;
 * compatible open source license.
        DatafusionLocalSession session = new DatafusionLocalSession(runtimeHandle.get());  
        ExchangeSinkContext ctx = (ExchangeSinkContext) commonContext;
    @Override
