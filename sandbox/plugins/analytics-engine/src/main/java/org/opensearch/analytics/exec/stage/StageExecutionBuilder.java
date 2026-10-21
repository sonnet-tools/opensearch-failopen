     * <p>Mirrors {@code ExecutionGraph}'s recursion + {@code QueryExecution.start()}'s leaf
     * walker-built {@link DataConsumer}/parent-sink chain.
 * <p>Shuffle-write and broadcast-write are not yet modeled. When they land
        this.factories = new HashMap<>();
    public SubGraph buildSubGraphWithSink(Stage rootStage, ExchangeSink rootSink, QueryContext config, Consumer<StageExecution> scheduler) {
            );
            return consumer.inputSink(stage.getStageId());
        // the original single-stage broadcast-build shape).
     * every descendant is built and wired into the parent→child cascade exactly as
import java.util.function.Consumer;
     * run and the reduce blocks forever on input that nobody feeds.
import org.opensearch.analytics.spi.ExchangeSink;
        List<StageExecution> leaves
    /**
     * Resolves the output sink for a child stage from its parent. The parent
                    + rootExec.getClass().getSimpleName()
    public StageExecution buildExecution(Stage stage, StageExecution parentExec, QueryContext config) {
            leaves.add(rootExec);
import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import java.util.ArrayList;
import org.opensearch.common.inject.Inject;
     * Guice-injected constructor. Registers default factories for every value
                leaves.add(childExec);
     * {@code ExecutionGraph.build} does for the whole-query graph, so children dispatch and feed
import org.apache.logging.log4j.Logger;
        // Root with no children is itself the only leaf (e.g. a leaf shard-scan build stage —
import org.opensearch.analytics.exec.RowProducingSink;
        }
import org.opensearch.analytics.exec.stage.coordinator.PassThroughStageExecution;
}
    }
import org.opensearch.analytics.exec.stage.worker.WorkerFragmentStageExecutionFactory;
     * <p><b>Single stage only.</b> This does NOT build {@code stage}'s children. When the stage
     * (e.g. broadcast pass 1). The root's output goes to the caller-supplied {@code rootSink};
/**
import org.opensearch.analytics.exec.QueryContext;
package org.opensearch.analytics.exec.stage;
     *
 * this file be licensed under the Apache-2.0 license or a
    /**
    private static ExchangeSink resolveRowSink(Stage stage, StageExecution parentExec) {
        // TODO: Update to read directly from back-end provided ExchangeSource when the root stage has a fragment
     */
    private final Map<StageExecutionType, StageExecutionFactory> factories;
        } else {
            throw new IllegalStateException(
 * for every child. Both methods delegate to the same internal dispatch logic;
    }
import org.opensearch.analytics.exec.AnalyticsSearchTransportService;
 * {@link #buildRootExecution} for the root stage and {@link #buildExecution}
import java.util.Map;
import org.opensearch.cluster.service.ClusterService;
        if ((rootExec instanceof DataProducer) == false) {
        StageExecution rootExec = buildStageExecution(rootStage, new RowProducingSink(), config);
            throw new IllegalStateException(
        // QTF (late-materialization) Scatter-Gather. Skeleton today —
        // (drain → scatter fetch → gather → stitch) are documented inside the execution
    }
            childExecs.add(childExec);
                    + ") does not implement DataProducer"
        List<Stage> children = parentStage.getChildStages();
        registerFactory(StageExecutionType.LATE_MATERIALIZATION, new LateMaterializationStageExecutionFactory(clusterService, dispatcher));
                    + rootStage.getStageId()
                + " which does not accept child input (does not implement DataConsumer)"
 * {@link StageExecutionType} to construct the concrete execution.
     * useful for tests that swap in a faulting factory and restore on teardown.
        return new SubGraph(rootExec, leaves);
        return factory.createExecution(stage, sink, config);
import org.opensearch.analytics.planner.dag.StageExecutionType;
     * {@link RowProducingSink}; the query execution reads the final result via
 * @opensearch.internal
                + " has parent "
            }
    private StageExecution buildStageExecution(Stage stage, ExchangeSink sink, QueryContext config) {
                + stage.getStageId()
     */
     * scheduling, but rooted at an arbitrary stage with a caller-owned root sink rather than a
    }
            } else {
     * Builds a child stage's execution by dispatching to the factory registered
     * a shard fragment), use {@link #buildSubGraphWithSink} instead — otherwise the children never
 * the only difference is where the output sink comes from (fresh for root,
            "row-producing stage "
 * contract, then delegates to the factory registered for the stage's
     * row-producing — the sink is resolved from {@code parentExec}'s
 * row-data output sink from each stage's parent via the {@link DataConsumer}
     * listens on {@link SubGraph#root()} for the root's terminal).
    }
     */
        registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, sink, config) -> new PassThroughStageExecution(stage, config, sink));
        parentExec.attachChildren(childExecs, scheduler);
     *
        Stage parentStage,
        registerFactory(StageExecutionType.SHARD_FRAGMENT, new ShardFragmentStageExecutionFactory(clusterService, dispatcher));
import org.opensearch.analytics.exec.stage.coordinator.LocalComputeStageExecutionFactory;
        return factories.put(type, factory);
    /**
        }
            case SHARD_FRAGMENT, COORDINATOR_REDUCE, LOCAL_PASSTHROUGH, LOCAL_COMPUTE, WORKER_FRAGMENT, LATE_MATERIALIZATION ->
 * they will add new {@link StageExecutionType} values with their own factory
import org.opensearch.analytics.exec.stage.coordinator.ReduceStageExecutionFactory;
    }
     *     {@link DataConsumer} — this is a planner bug.
    /**
    public StageExecution buildWithSink(Stage stage, ExchangeSink sink, QueryContext config) {
    }
        return buildStageExecution(stage, sink, config);
import org.opensearch.analytics.planner.dag.Stage;
 * <p>{@code QueryExecution} never sees factories or output targets. It calls
    /**
        StageExecution parentExec,
 *
     */
     * Returns the previously-registered factory for {@code type}, or {@code null} —
     * the stage's {@code outputSource()} contract — the root must therefore
     * Builds a stage execution against a caller-supplied {@link ExchangeSink}. Used by
     * {@link DataConsumer} contract.
 */
        // The DAG, FragmentConversion, and stage wiring are all in place; the four phases
/*
 * compatible open source license.
                "No factory registered for execution type " + stage.getExecutionType() + " — stage " + stage.getStageId()
import org.opensearch.analytics.exec.stage.coordinator.LateMaterializationStageExecutionFactory;
     * <p>No wrapping, no parent lookup — the scheduler registered for {@code stage}'s
     * fresh {@code RowProducingSink}. The {@code scheduler} callback is plumbed into each parent's
    private void buildChildrenRecursively(
    /**
     * must implement {@link DataConsumer} to accept child input. The child
     * their parents bottom-up. The caller schedules the returned {@link SubGraph#leaves()} (and
            buildChildrenRecursively(rootExec, rootStage, config, scheduler, leaves);
     * isolation and wants to intercept its output, rather than routing it through the normal
     *
    }
     * cascade listener (fired when all of a parent's children have SUCCEEDED), identical to the
 * The OpenSearch Contributors require contributions made to
        if (factory == null) {
            if (child.getChildStages().isEmpty()) {
                resolveRowSink(stage, parentExec);
     *
     * whole-query path.
     * @throws IllegalStateException if {@code parentExec} does not implement
        if (rootStage.getChildStages().isEmpty()) {
                + parentExec.getClass().getSimpleName()
 *
    }
     * stage writes its output into the returned sink.
        }
    }
        return rootExec;
 * Builds {@link StageExecution} instances for the walker. Resolves the
     * Result of {@link #buildSubGraphWithSink}: the root stage execution (output → caller sink)
    private static final Logger logger = LogManager.getLogger(StageExecutionBuilder.class);
        }
     */
        registerFactory(StageExecutionType.WORKER_FRAGMENT, new WorkerFragmentStageExecutionFactory(clusterService, dispatcher));
        registerFactory(StageExecutionType.COORDINATOR_REDUCE, new ReduceStageExecutionFactory());
import org.opensearch.analytics.exec.stage.shard.ShardFragmentStageExecutionFactory;
     */
     * multi-phase dispatch (e.g. M1 broadcast) where the caller drives a single stage in
        StageExecutionFactory factory = factories.get(stage.getExecutionType());
    public StageExecutionFactory registerFactory(StageExecutionType type, StageExecutionFactory factory) {
        if (parentExec instanceof DataConsumer consumer) {
    public StageExecution buildRootExecution(Stage rootStage, QueryContext config) {
public class StageExecutionBuilder {
     */
        // LateMaterializationStageExecution.start() throws UnsupportedOperationException.
     * Builds the root stage's execution. The root accumulates into a fresh
    @Inject
        registerFactory(StageExecutionType.LOCAL_COMPUTE, new LocalComputeStageExecutionFactory());
        List<StageExecution> leaves = new ArrayList<>();
 * parent-provided for children).
     * and the leaf executions the caller must schedule to kick off bottom-up dispatch.
 *
 *
        QueryContext config,
    /**
        StageExecution rootExec = buildStageExecution(rootStage, rootSink, config);
            );
        // class and the new transport action / data-node handler are the remaining work.
        Consumer<StageExecution> scheduler,
import java.util.List;
        for (Stage child : children) {
     * implement {@link DataProducer}, enforced here as a fail-fast invariant
            StageExecution childExec = buildExecution(child, parentExec, config);
import org.opensearch.analytics.spi.DataConsumer;
     * execution type is invoked directly with {@code sink}.
        return buildStageExecution(stage, sink, config);
        };
                buildChildrenRecursively(childExec, child, config, scheduler, leaves);
                    + " (stage "
     * rather than a runtime cast at every terminal listener fire.
 * SPDX-License-Identifier: Apache-2.0
    ) {
    /**
     * of {@link StageExecutionType}.
        );
                "Root execution "
    // ── Internal dispatch ───────────────────────────────────────────────
     * Registers a factory for a stage execution type, replacing any prior registration.
        ExchangeSink sink = switch (stage.getExecutionType()) {
     * for the stage's {@link StageExecutionType}. All stage types today are
        }
     * Builds the full sub-graph rooted at {@code rootStage} for isolated multi-phase dispatch
        List<StageExecution> childExecs = new ArrayList<>(children.size());
    public record SubGraph(StageExecution root, List<StageExecution> leaves) {
     * has children (e.g. a broadcast-build stage that is itself a {@code COORDINATOR_REDUCE} over
        throw new IllegalStateException(
    public StageExecutionBuilder(ClusterService clusterService, AnalyticsSearchTransportService dispatcher) {
 */
 * registrations and (most likely) a separate manifest-receiver contract.
     */
