            stage.getStageId(),
                    e.addSuppressed(closeFailure);
                } catch (Exception closeFailure) {
import org.opensearch.analytics.spi.ExchangeSinkProvider;
            config.queryId(),
        List<ExchangeSinkContext.ChildInput> inputs = new ArrayList<>(children.size());
    }
package org.opensearch.analytics.exec.stage.coordinator;
 * this file be licensed under the Apache-2.0 license or a
                    BackendExecutionContext previous = backendContext;
            config.importStagingAllocator()
            "Backend exchange sink for COORDINATOR_REDUCE stage "
                if (backendContext != null) {
                if (primaryFailure instanceof Error err) throw err;
        // is stored on the Stage during FragmentConversionDriver.convertAll (root stage only,
        }
 * producer-side plan bytes the backend lowers to derive the input schema),
import org.opensearch.analytics.exec.QueryContext;
            + stage.getPlanAlternatives().size();
     * Builds one {@link ExchangeSinkContext.ChildInput} per child stage. Each entry carries
 */
                }
                }
    private static byte[] chosenBytes(Stage stage) {
        return stage.getPlanAlternatives().getFirst().convertedBytes();
 */
 *
        if (children.isEmpty()) {
import org.opensearch.analytics.planner.dag.StagePlan;
 * input descriptors (one per child stage, each with its stage id + the
            }
 * SPDX-License-Identifier: Apache-2.0
            + " expected exactly one plan alternative, got "
        // TODO: find a cleaner way to provide the factory without storing it on Stage.
                // On failure, close the backendContext since it won't be handed to the sink.
        try {
            return new ReduceStageExecution(stage, config, reducing, sink);
 * the sink's {@link ReducingExchangeSink#supportsEagerScheduling()} drives the
                if (primaryFailure instanceof RuntimeException re) throw re;
            inputs.add(new ExchangeSinkContext.ChildInput(child.getStageId(), producerPlanBytes));
    /**
/**
                for (InstructionNode node : stage.getPlanAlternatives().getFirst().instructions()) {
        // no serialization needed since reduce executes locally at the coordinator).
 * {@link ExchangeSinkContext} carrying the plan bytes, allocator, per-child
 * Builds executions for {@link StageExecutionType#COORDINATOR_REDUCE} stages —
            sink,
import org.opensearch.analytics.planner.dag.StageExecutionType;
import org.opensearch.analytics.spi.BackendExecutionContext;
        ExchangeSink backendSink;
            }
public final class ReduceStageExecutionFactory implements StageExecutionFactory {
            }
/*
    }
                    // context — close it now so its resources aren't orphaned.
            } catch (Throwable t) {
import org.opensearch.analytics.spi.ReducingExchangeSink;
        assert stage.getPlanAlternatives().size() == 1 : "COORDINATOR_REDUCE stage "
                + " must implement ReducingExchangeSink, got "
     * {@code "input-<stageId>"}) and the producer-side plan bytes the backend lowers to
        if (backendSink instanceof ReducingExchangeSink reducing) {
            StagePlan plan = child.getPlanAlternatives().getFirst();
        );
                    FragmentInstructionHandler handler = factory.createHandler(node);
                    }
import org.opensearch.analytics.spi.FragmentInstructionHandler;
        }
        );
import org.opensearch.analytics.exec.stage.StageExecutionFactory;
            if (backendContext != null) {
        for (Stage child : children) {
import java.util.ArrayList;
            throw new RuntimeException("Failed to create exchange sink for stageId=" + stage.getStageId(), e);
        // local backends map, the coordinator-reduce path has no backends map — the factory
    private static List<ExchangeSinkContext.ChildInput> buildChildInputs(Stage stage) {
        ExchangeSinkContext context = new ExchangeSinkContext(
                    if (previous != null && previous != backendContext) {
                primaryFailure = t;
                }
}
                        backendContext.close();
            Throwable primaryFailure = null;
            config.parentTask() != null ? config.parentTask().getNativeTaskId() : 0L,
                throw new RuntimeException("Instruction handler failed for stageId=" + stage.getStageId(), primaryFailure);
                    backendContext.close();
import org.opensearch.analytics.spi.InstructionNode;
            if (primaryFailure != null) {
 *
     * the child's stage id (used by the backend to namespace its registered input, e.g.
        }
                    } catch (Exception closeFailure) {
        if (factory != null) {
        List<Stage> children = stage.getChildStages();
            throw new IllegalStateException(
 * compatible open source license.
            config.bufferAllocator(),
import java.util.List;
import org.opensearch.analytics.spi.ExchangeSinkContext;
            // Sink creation failed — close backendContext to avoid resource leak.
        } catch (Exception e) {
                        previous.close();
            chosenBytes(stage),
 * Creates the sink via {@link Stage#getExchangeSinkProvider()} using an
        ExchangeSinkProvider provider = stage.getExchangeSinkProvider();
        }
        return inputs;
    @Override
            // decorator widens the wire schema (e.g. QTF's OrdinalAppendingSink).
                    }
     * derive the input schema at registration time.
    }
                    // A handler that returns a new reference implicitly abandons the previous
            + stage.getStageId()
        // Unlike AnalyticsSearchService (shard path) which resolves the factory from its
    public StageExecution createExecution(Stage stage, ExchangeSink sink, QueryContext config) {
                try {
 * @opensearch.internal
    /** Picks the plan-alternative bytes bound to the stage's exchange sink provider. */
        BackendExecutionContext backendContext = null;
                "COORDINATOR_REDUCE stage " + stage.getStageId() + " expected at least one child stage, got zero"
import org.opensearch.analytics.spi.ExchangeSink;
            byte[] producerPlanBytes = plan.postDecorationSchemaBytes() != null ? plan.postDecorationSchemaBytes() : plan.convertedBytes();
            // postDecorationSchemaBytes wins over the producer's natural schema when an input
 * those that run at the coordinator with a backend-provided {@link ReducingExchangeSink}.
        // Apply instruction handlers for the reduce stage.
 * The OpenSearch Contributors require contributions made to
            buildChildInputs(stage),
import org.opensearch.analytics.spi.FragmentInstructionHandlerFactory;
                + stage.getStageId()
                    try {
        FragmentInstructionHandlerFactory factory = stage.getInstructionHandlerFactory();
        throw new IllegalStateException(
            try {
        }
                    backendContext = handler.apply(node, context, backendContext);
import org.opensearch.analytics.exec.stage.StageExecution;
     */
 * scheduling mode (streaming vs buffered) without needing distinct execution subclasses.
 * and the downstream sink. Wraps the resulting sink in a {@link ReduceStageExecution};
            );
            backendSink = provider.createSink(context, backendContext);
                + backendSink.getClass().getName()
                        primaryFailure.addSuppressed(closeFailure);
import org.opensearch.analytics.planner.dag.Stage;
