                "Root execution "  
            case SHARD_FRAGMENT, COORDINATOR_REDUCE, LOCAL_PASSTHROUGH, LOCAL_COMPUTE, WORKER_FRAGMENT, LATE_MATERIALIZATION ->  
     * implement {@link DataProducer}, enforced here as a fail-fast invariant
     * must implement {@link DataConsumer} to accept child input. The child  
import org.opensearch.analytics.exec.stage.coordinator.LateMaterializationStageExecutionFactory;  
        }  
     * multi-phase dispatch (e.g. M1 broadcast) where the caller drives a single stage in
                    + rootStage.getStageId()  
                + " has parent "
import org.opensearch.common.inject.Inject;
            );
     * (e.g. broadcast pass 1). The root's output goes to the caller-supplied {@code rootSink};
     * scheduling, but rooted at an arbitrary stage with a caller-owned root sink rather than a  
        // the original single-stage broadcast-build shape).  
/*  
    private final Map<StageExecutionType, StageExecutionFactory> factories;
    public StageExecutionBuilder(ClusterService clusterService, AnalyticsSearchTransportService dispatcher) {  
     * and the leaf executions the caller must schedule to kick off bottom-up dispatch.
        StageExecutionFactory factory = factories.get(stage.getExecutionType());
     */
import org.opensearch.analytics.exec.stage.coordinator.LocalComputeStageExecutionFactory;
    /**  
    /**
     * listens on {@link SubGraph#root()} for the root's terminal).  
     * execution type is invoked directly with {@code sink}.
     * fresh {@code RowProducingSink}. The {@code scheduler} callback is plumbed into each parent's
    /**
        // (drain → scatter fetch → gather → stitch) are documented inside the execution
        ExchangeSink sink = switch (stage.getExecutionType()) {
     * row-producing — the sink is resolved from {@code parentExec}'s
import org.opensearch.analytics.spi.ExchangeSink;  
/**
import org.apache.logging.log4j.Logger;
 *
    public StageExecution buildWithSink(Stage stage, ExchangeSink sink, QueryContext config) {
        Stage parentStage,
        Consumer<StageExecution> scheduler,
        List<StageExecution> leaves = new ArrayList<>();
     * has children (e.g. a broadcast-build stage that is itself a {@code COORDINATOR_REDUCE} over
                resolveRowSink(stage, parentExec);
    }
     * stage writes its output into the returned sink.
    }
import java.util.Map;
 * this file be licensed under the Apache-2.0 license or a
        }
import java.util.ArrayList;
 * The OpenSearch Contributors require contributions made to  
     * Builds the full sub-graph rooted at {@code rootStage} for isolated multi-phase dispatch
            if (child.getChildStages().isEmpty()) {  
     * <p>Mirrors {@code ExecutionGraph}'s recursion + {@code QueryExecution.start()}'s leaf
     * a shard fragment), use {@link #buildSubGraphWithSink} instead — otherwise the children never
import java.util.List;  
     */  
        if (parentExec instanceof DataConsumer consumer) {
 * <p>Shuffle-write and broadcast-write are not yet modeled. When they land
        for (Stage child : children) {  
 * compatible open source license.
     *
        StageExecution parentExec,
    }
 * the only difference is where the output sink comes from (fresh for root,
     * @throws IllegalStateException if {@code parentExec} does not implement
        registerFactory(StageExecutionType.SHARD_FRAGMENT, new ShardFragmentStageExecutionFactory(clusterService, dispatcher));
    /**  
    }
        List<Stage> children = parentStage.getChildStages();
    private StageExecution buildStageExecution(Stage stage, ExchangeSink sink, QueryContext config) {  
import org.apache.logging.log4j.LogManager;
        // Root with no children is itself the only leaf (e.g. a leaf shard-scan build stage —
import org.opensearch.analytics.planner.dag.StageExecutionType;
     * the stage's {@code outputSource()} contract — the root must therefore  
     */
    public StageExecutionFactory registerFactory(StageExecutionType type, StageExecutionFactory factory) {
        QueryContext config,  
import java.util.function.Consumer;
        // TODO: Update to read directly from back-end provided ExchangeSource when the root stage has a fragment
        if (rootStage.getChildStages().isEmpty()) {
    /**  
     * {@link DataConsumer} contract.
     * Returns the previously-registered factory for {@code type}, or {@code null} —
    private void buildChildrenRecursively(  
        StageExecution rootExec = buildStageExecution(rootStage, rootSink, config);  
        registerFactory(StageExecutionType.LATE_MATERIALIZATION, new LateMaterializationStageExecutionFactory(clusterService, dispatcher));  
 * @opensearch.internal
                    + rootExec.getClass().getSimpleName()
            leaves.add(rootExec);
        StageExecution rootExec = buildStageExecution(rootStage, new RowProducingSink(), config);  
                    + ") does not implement DataProducer"
            childExecs.add(childExec);
        // class and the new transport action / data-node handler are the remaining work.
    }
import java.util.HashMap;
     * {@link RowProducingSink}; the query execution reads the final result via
     * useful for tests that swap in a faulting factory and restore on teardown.  
        return buildStageExecution(stage, sink, config);  
 * row-data output sink from each stage's parent via the {@link DataConsumer}  
            "row-producing stage "
     * run and the reduce blocks forever on input that nobody feeds.  
public class StageExecutionBuilder {
     * cascade listener (fired when all of a parent's children have SUCCEEDED), identical to the
                leaves.add(childExec);
     * <p>No wrapping, no parent lookup — the scheduler registered for {@code stage}'s  
        throw new IllegalStateException(
     * Guice-injected constructor. Registers default factories for every value
    }
import org.opensearch.analytics.exec.RowProducingSink;
 * Builds {@link StageExecution} instances for the walker. Resolves the
     * Resolves the output sink for a child stage from its parent. The parent
    ) {  
        );
 * for every child. Both methods delegate to the same internal dispatch logic;  
        registerFactory(StageExecutionType.WORKER_FRAGMENT, new WorkerFragmentStageExecutionFactory(clusterService, dispatcher));  
     * every descendant is built and wired into the parent→child cascade exactly as  
    /**  
    public record SubGraph(StageExecution root, List<StageExecution> leaves) {
        return buildStageExecution(stage, sink, config);  
    }
 * <p>{@code QueryExecution} never sees factories or output targets. It calls
 * {@link StageExecutionType} to construct the concrete execution.
        }  
        if (factory == null) {
        parentExec.attachChildren(childExecs, scheduler);  
 * they will add new {@link StageExecutionType} values with their own factory
        this.factories = new HashMap<>();
        }
            StageExecution childExec = buildExecution(child, parentExec, config);
     * <p><b>Single stage only.</b> This does NOT build {@code stage}'s children. When the stage  
import org.opensearch.analytics.exec.stage.coordinator.PassThroughStageExecution;
     * their parents bottom-up. The caller schedules the returned {@link SubGraph#leaves()} (and
                + stage.getStageId()  
        }  
        // LateMaterializationStageExecution.start() throws UnsupportedOperationException.
     *
            throw new IllegalStateException(
     * whole-query path.  
 */  
     */
                buildChildrenRecursively(childExec, child, config, scheduler, leaves);  
     * {@code ExecutionGraph.build} does for the whole-query graph, so children dispatch and feed
     * walker-built {@link DataConsumer}/parent-sink chain.
        return factory.createExecution(stage, sink, config);
 * SPDX-License-Identifier: Apache-2.0
    /**  
import org.opensearch.analytics.spi.DataConsumer;
}  
        // QTF (late-materialization) Scatter-Gather. Skeleton today —
        return new SubGraph(rootExec, leaves);  
        List<StageExecution> leaves
    public StageExecution buildExecution(Stage stage, StageExecution parentExec, QueryContext config) {
        return rootExec;
        registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, sink, config) -> new PassThroughStageExecution(stage, config, sink));
 * contract, then delegates to the factory registered for the stage's
     *     {@link DataConsumer} — this is a planner bug.
        if ((rootExec instanceof DataProducer) == false) {
        List<StageExecution> childExecs = new ArrayList<>(children.size());
import org.opensearch.analytics.exec.stage.worker.WorkerFragmentStageExecutionFactory;
        // The DAG, FragmentConversion, and stage wiring are all in place; the four phases  
     * Builds the root stage's execution. The root accumulates into a fresh
package org.opensearch.analytics.exec.stage;
    private static ExchangeSink resolveRowSink(Stage stage, StageExecution parentExec) {  
    }
 *  
        registerFactory(StageExecutionType.COORDINATOR_REDUCE, new ReduceStageExecutionFactory());  
    }
    }
     */  
        registerFactory(StageExecutionType.LOCAL_COMPUTE, new LocalComputeStageExecutionFactory());
 *
            );
        };
     * of {@link StageExecutionType}.  
import org.opensearch.analytics.exec.AnalyticsSearchTransportService;  
     * rather than a runtime cast at every terminal listener fire.
 */  
     * Builds a stage execution against a caller-supplied {@link ExchangeSink}. Used by
                "No factory registered for execution type " + stage.getExecutionType() + " — stage " + stage.getStageId()
     * Registers a factory for a stage execution type, replacing any prior registration.
            throw new IllegalStateException(  
                    + " (stage "
    private static final Logger logger = LogManager.getLogger(StageExecutionBuilder.class);  
     * for the stage's {@link StageExecutionType}. All stage types today are  
            } else {
 *  
import org.opensearch.analytics.planner.dag.Stage;  
 * parent-provided for children).
        } else {  
    /**
    @Inject
        return factories.put(type, factory);  
    public SubGraph buildSubGraphWithSink(Stage rootStage, ExchangeSink rootSink, QueryContext config, Consumer<StageExecution> scheduler) {
     */
 * {@link #buildRootExecution} for the root stage and {@link #buildExecution}
     * Builds a child stage's execution by dispatching to the factory registered
                + parentExec.getClass().getSimpleName()
    // ── Internal dispatch ───────────────────────────────────────────────
            }
            buildChildrenRecursively(rootExec, rootStage, config, scheduler, leaves);
import org.opensearch.analytics.exec.QueryContext;
     * isolation and wants to intercept its output, rather than routing it through the normal  
import org.opensearch.analytics.exec.stage.shard.ShardFragmentStageExecutionFactory;
     */
import org.opensearch.cluster.service.ClusterService;
     * Result of {@link #buildSubGraphWithSink}: the root stage execution (output → caller sink)
import org.opensearch.analytics.exec.stage.coordinator.ReduceStageExecutionFactory;  
     */  
     *  
     *
 * registrations and (most likely) a separate manifest-receiver contract.  
                + " which does not accept child input (does not implement DataConsumer)"  
    public StageExecution buildRootExecution(Stage rootStage, QueryContext config) {
            return consumer.inputSink(stage.getStageId());
