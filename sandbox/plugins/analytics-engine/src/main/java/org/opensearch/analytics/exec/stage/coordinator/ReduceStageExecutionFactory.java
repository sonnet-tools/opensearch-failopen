import java.util.ArrayList;
import org.opensearch.analytics.spi.InstructionNode;
     * the child's stage id (used by the backend to namespace its registered input, e.g.  
                }
            // decorator widens the wire schema (e.g. QTF's OrdinalAppendingSink).
 *
                if (backendContext != null) {  
import org.opensearch.analytics.spi.ExchangeSinkContext;  
                }
        if (backendSink instanceof ReducingExchangeSink reducing) {
import org.opensearch.analytics.spi.FragmentInstructionHandler;
 * the sink's {@link ReducingExchangeSink#supportsEagerScheduling()} drives the  
            stage.getStageId(),  
                    }
import org.opensearch.analytics.exec.stage.StageExecution;
                    e.addSuppressed(closeFailure);  
        // local backends map, the coordinator-reduce path has no backends map — the factory
                    // context — close it now so its resources aren't orphaned.
package org.opensearch.analytics.exec.stage.coordinator;
    private static byte[] chosenBytes(Stage stage) {
import org.opensearch.analytics.spi.ExchangeSink;
        List<Stage> children = stage.getChildStages();
                    }
        assert stage.getPlanAlternatives().size() == 1 : "COORDINATOR_REDUCE stage "  
                    backendContext = handler.apply(node, context, backendContext);
    }
                throw new RuntimeException("Instruction handler failed for stageId=" + stage.getStageId(), primaryFailure);
        if (children.isEmpty()) {  
                + stage.getStageId()
            config.importStagingAllocator()  
                // On failure, close the backendContext since it won't be handed to the sink.
        }  
            chosenBytes(stage),
     * {@code "input-<stageId>"}) and the producer-side plan bytes the backend lowers to
    @Override
        List<ExchangeSinkContext.ChildInput> inputs = new ArrayList<>(children.size());
            throw new RuntimeException("Failed to create exchange sink for stageId=" + stage.getStageId(), e);  
                    BackendExecutionContext previous = backendContext;
            + " expected exactly one plan alternative, got "
import org.opensearch.analytics.exec.QueryContext;
                "COORDINATOR_REDUCE stage " + stage.getStageId() + " expected at least one child stage, got zero"
            throw new IllegalStateException(
            try {
                    // A handler that returns a new reference implicitly abandons the previous  
        }
                        backendContext.close();
            backendSink = provider.createSink(context, backendContext);
            }  
                for (InstructionNode node : stage.getPlanAlternatives().getFirst().instructions()) {
        return inputs;
            config.bufferAllocator(),  
        }
                        primaryFailure.addSuppressed(closeFailure);
        if (factory != null) {
import java.util.List;
                    if (previous != null && previous != backendContext) {
            + stage.getPlanAlternatives().size();  
            + stage.getStageId()
        ExchangeSinkContext context = new ExchangeSinkContext(
            // postDecorationSchemaBytes wins over the producer's natural schema when an input
        );
            inputs.add(new ExchangeSinkContext.ChildInput(child.getStageId(), producerPlanBytes));
            byte[] producerPlanBytes = plan.postDecorationSchemaBytes() != null ? plan.postDecorationSchemaBytes() : plan.convertedBytes();
                try {  
        for (Stage child : children) {  
     * derive the input schema at registration time.
        FragmentInstructionHandlerFactory factory = stage.getInstructionHandlerFactory();
 * and the downstream sink. Wraps the resulting sink in a {@link ReduceStageExecution};
import org.opensearch.analytics.planner.dag.Stage;
            "Backend exchange sink for COORDINATOR_REDUCE stage "  
            StagePlan plan = child.getPlanAlternatives().getFirst();  
 */
        // TODO: find a cleaner way to provide the factory without storing it on Stage.
 * producer-side plan bytes the backend lowers to derive the input schema),
    private static List<ExchangeSinkContext.ChildInput> buildChildInputs(Stage stage) {
                primaryFailure = t;
            } catch (Throwable t) {  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        );
        }
                + " must implement ReducingExchangeSink, got "
            Throwable primaryFailure = null;  
import org.opensearch.analytics.spi.FragmentInstructionHandlerFactory;  
 * compatible open source license.
    }
        BackendExecutionContext backendContext = null;  
 * this file be licensed under the Apache-2.0 license or a
                if (primaryFailure instanceof RuntimeException re) throw re;  
import org.opensearch.analytics.spi.ReducingExchangeSink;
        } catch (Exception e) {  
public final class ReduceStageExecutionFactory implements StageExecutionFactory {
            if (backendContext != null) {
 * Creates the sink via {@link Stage#getExchangeSinkProvider()} using an
        // Unlike AnalyticsSearchService (shard path) which resolves the factory from its
        // Apply instruction handlers for the reduce stage.  
/**
 * {@link ExchangeSinkContext} carrying the plan bytes, allocator, per-child
        }
 */  
    /**
 * those that run at the coordinator with a backend-provided {@link ReducingExchangeSink}.  
     */  
import org.opensearch.analytics.spi.ExchangeSinkProvider;
        return stage.getPlanAlternatives().getFirst().convertedBytes();
            // Sink creation failed — close backendContext to avoid resource leak.
                + backendSink.getClass().getName()  
 * input descriptors (one per child stage, each with its stage id + the  
        ExchangeSinkProvider provider = stage.getExchangeSinkProvider();  
import org.opensearch.analytics.spi.BackendExecutionContext;
        try {
    public StageExecution createExecution(Stage stage, ExchangeSink sink, QueryContext config) {
                }  
    }
        // no serialization needed since reduce executes locally at the coordinator).
        ExchangeSink backendSink;  
 * Builds executions for {@link StageExecutionType#COORDINATOR_REDUCE} stages —
        throw new IllegalStateException(
}  
     * Builds one {@link ExchangeSinkContext.ChildInput} per child stage. Each entry carries
 *
                } catch (Exception closeFailure) {
                    try {
/*  
            return new ReduceStageExecution(stage, config, reducing, sink);  
import org.opensearch.analytics.planner.dag.StageExecutionType;
        // is stored on the Stage during FragmentConversionDriver.convertAll (root stage only,  
                        previous.close();  
            }
    /** Picks the plan-alternative bytes bound to the stage's exchange sink provider. */
                    FragmentInstructionHandler handler = factory.createHandler(node);  
            if (primaryFailure != null) {
            buildChildInputs(stage),
import org.opensearch.analytics.exec.stage.StageExecutionFactory;  
            config.queryId(),
            );  
                if (primaryFailure instanceof Error err) throw err;
import org.opensearch.analytics.planner.dag.StagePlan;  
 * @opensearch.internal  
                    backendContext.close();
                    } catch (Exception closeFailure) {  
            sink,
            config.parentTask() != null ? config.parentTask().getNativeTaskId() : 0L,
 * scheduling mode (streaming vs buffered) without needing distinct execution subclasses.
            }
