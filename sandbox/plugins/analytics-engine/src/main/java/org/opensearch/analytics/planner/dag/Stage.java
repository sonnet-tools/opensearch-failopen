            return StageExecutionType.LOCAL_COMPUTE;
    @Nullable  
     * Returns where this stage's compute runs. Derived at construction from the
     * Optional decorator wrapping this stage's incoming child sink. Set at DAG-build
    /**  
    public void setPlanAlternatives(List<StagePlan> planAlternatives) {  
    }  
        this.exchangeInfo = exchangeInfo;
    private final TargetResolver targetResolver;
        this.targetResolver = targetResolver;
    }
        ExchangeSinkProvider exchangeSinkProvider,
        SHUFFLE_SCAN_RIGHT,  
        return exchangeInfo;
    @Nullable  
        /** Hash-shuffle left scan — partitions and ships to workers (M2). */  
            return false;  
        SHUFFLE_WORKER
 * where every viableBackends is narrowed to exactly one backend.
 */  
    }
        this.stageId = stageId;
import org.opensearch.common.Nullable;
    public int getStageId() {
    public Stage(  
     * (some Stage tests construct stub stages without a fragment) cannot
     * sink-resolution time inside the parent execution's {@code inputSink(...)}.  
import org.opensearch.analytics.planner.rel.OpenSearchValues;
        return targetResolver;  
        } else if (exchangeSinkProvider != null) {
     *  
    public void setInstructionHandlerFactory(FragmentInstructionHandlerFactory instructionHandlerFactory) {
        /** Coordinator-side reduce/gather stage. */  
        return inputSinkDecorator;  
    private final StageExecutionType executionType;
     * {@link StageExecutionType} (which describes *how* the stage runs); {@code StageRole}
    /** Re-tag this stage's role — called by MPP rewrites before dispatch. */
     * just before dispatch.
            return StageExecutionType.WORKER_FRAGMENT;
 * <ol>
    }  
        this.role = role;
        }  
        return childStages;
     */  
import org.apache.calcite.rel.RelNode;
        }
    }
    }  
import java.util.List;
 * </ol>
    private static boolean hasComputeLeaf(RelNode fragment) {
        RelNode fragment
 *       — dispatch fragment per-shard to data nodes.</li>  
        this.planAlternatives = List.of();  
            return StageExecutionType.SHARD_FRAGMENT;
    private final SortSpec sortSpec;
 *  
     * {@link #BROADCAST_BUILD} / {@link #BROADCAST_PROBE} / {@link #SHUFFLE_SCAN_LEFT} /  
    }  
        // QTF Scatter-Gather marker — orchestrates fetch-by-rowid + stitch internally,  
    public InputSinkDecorator getInputSinkDecorator() {
    }  
 * for the Scheduler to resolve execution targets lazily, and references to child stages.  
     * Null for simple gather stages — Scheduler uses a {@code RowProducingSink} instead.
    private final ExchangeInfo exchangeInfo;
        ExchangeInfo exchangeInfo,
        COORDINATOR_REDUCE,
     * an {@link org.opensearch.analytics.planner.rel.OpenSearchValues} today;
    }
    @Nullable  
    public StageRole getRole() {
 *  
 *
        TargetResolver targetResolver,  
    /** Returns the semantic role tag. Defaults to {@link StageRole#SHARD_SOURCE}. */  
    @Nullable
        return executionType;
        SHUFFLE_SCAN_AGG,
    }  
     * target resolver / sink provider pair — see the class-level javadoc.
    /**
        this.childStages = List.copyOf(childStages);
            return StageExecutionType.COORDINATOR_REDUCE;  
        this.fragment = fragment;  
        return canMatchFilters;
        RelNode fragment,
 *       via {@code RowProducingSink}.</li>
        return RelNodeUtils.findNode(fragment, OpenSearchValues.class) != null;
        } else if (targetResolver != null) {  
     * True iff {@code fragment} contains a coord-only compute leaf —
 * at construction in priority order:  
        SHARD_SOURCE,
    /**  
     * MPP rewrites in {@code DefaultPlanExecutor} / {@code QueryScheduler} may re-tag stages as
    }  
    /**
        List<Stage> childStages,  
 * compatible open source license.
     * time (today only by {@code DAGBuilder.cutAtLateMaterialization}); applied at
 *   <li>Otherwise → {@link StageExecutionType#LOCAL_PASSTHROUGH} — coordinator gather  
        BROADCAST_BUILD,  
            // via the backend's in-process engine. Takes precedence over the
    private StageExecutionType setStageExecutionType(
        BROADCAST_PROBE,
    }  
    public List<CanMatchFilter> getCanMatchFilters() {  
    }
     * Scheduler calls {@code targetResolver.resolve(clusterState, childManifest)} lazily
    public RelNode getFragment() {
            // sink-provider check because LOCAL_COMPUTE also requires a sink
        } else if (hasComputeLeaf(fragment)) {
        // in unit tests construct without a fragment.  
            return StageExecutionType.LOCAL_PASSTHROUGH;
    /**  
        if (fragment != null && RelNodeUtils.findNode(fragment, OpenSearchLateMaterialization.class) != null) {
 * intact, multiple viableBackends per operator/expression), a {@link TargetResolver}
     * describes *why* the stage exists so the coordinator can route MPP-specific dispatch paths.
        SHUFFLE_SCAN_LEFT,
        /** Data-node scan stage — default for anything built by the DAG cutter. */
    private final List<Stage> childStages;
        return exchangeSinkProvider;
     * <p>Defaults to {@link #SHARD_SOURCE} for every stage constructed by {@code DAGBuilder};
        this.sortSpec = fragment != null ? SortSpecExtractor.extract(fragment) : null;
            // Coord-only compute leaf (e.g. OpenSearchValues) — run the plan locally  
        } else {
     * contain a compute leaf — return false rather than NPE.
    /** Primary sort key of this fragment; null when it isn't a {@code sort | head N} shape. */
    public TargetResolver getTargetResolver() {
    public StageExecutionType getExecutionType() {
    @Nullable
     * Semantic role of this stage within a potentially multi-stage join execution. Orthogonal to  
        return stageId;  
 * A stage in the query DAG. Each stage holds a marked plan fragment (annotations
 *   <li>{@link #getTargetResolver()} non-null → {@link StageExecutionType#SHARD_FRAGMENT}
    private InputSinkDecorator inputSinkDecorator;
/**  
     */
    /** Range filters extracted from the fragment at DAG-build time for can-match pre-filtering. */
        return sortSpec;
    }  
            return StageExecutionType.LATE_MATERIALIZATION;
    public FragmentInstructionHandlerFactory getInstructionHandlerFactory() {
    private final List<CanMatchFilter> canMatchFilters;  
     */
    public void setRole(StageRole role) {  
        this.planAlternatives = planAlternatives;
 */
     */
        this.executionType = setStageExecutionType(exchangeSinkProvider, targetResolver, fragment);
import org.opensearch.analytics.planner.RelNodeUtils;  
 * <p>After plan forking, {@code planAlternatives} contains resolved variants
    private FragmentInstructionHandlerFactory instructionHandlerFactory;
    ) {
    }
    public List<StagePlan> getPlanAlternatives() {
        }  
     * Non-null for DATA_NODE stages. Null for coordinator/gather stages.  
        if (targetResolver instanceof WorkerTargetResolver) {
 * SPDX-License-Identifier: Apache-2.0
        /** Hash-shuffle worker stage — one task per shuffle partition. Consumes two input streams  
import org.opensearch.analytics.spi.FragmentInstructionHandlerFactory;
    public enum StageRole {  
    }
    @Nullable  
    }  
        return instructionHandlerFactory;
    /** How this stage connects to its parent. Null for the root stage. */
        /** Broadcast-join build side — results are collected and re-dispatched as broadcast payload. */
import org.opensearch.analytics.spi.ExchangeSinkProvider;  
 * The OpenSearch Contributors require contributions made to  
        return role;
    @Nullable
    public ExchangeInfo getExchangeInfo() {
        return fragment;
    private List<StagePlan> planAlternatives;  
 *       — coordinator-side reduction via backend sink.</li>
     * Non-null for coordinator stages with backend computation (final aggregate, sort).  
import org.opensearch.analytics.exec.canmatch.SortSpecExtractor;
    }
import org.opensearch.analytics.exec.canmatch.CanMatchFilterExtractor;  
         *  for a join (M2) or one for an aggregate FINAL (M3). */
import org.opensearch.analytics.exec.canmatch.SortSpec;
        /** Hash-shuffle aggregate scan — single producer feeding an aggregate worker (M3). */
/*  
     * future literal-source rels would extend this list. A null fragment  
    /** Marked plan fragment with annotations intact. */  
        if (fragment == null) {
    /** Sort column + direction used to order shards in the can-match phase; null when not applicable. */
 *   <li>{@link #getExchangeSinkProvider()} non-null → {@link StageExecutionType#COORDINATOR_REDUCE}
    private final int stageId;
 * <p>Execution shape is surfaced explicitly via {@link #getExecutionType()}, derived
        int stageId,
    }
        /** Broadcast-join probe side — each task carries the join plan plus broadcast data. */
        this.exchangeSinkProvider = exchangeSinkProvider;  
        // accidentally claim the wrapper-stage. Null-fragment tolerant — some stub Stages
            // provider (DAGBuilder attaches one), but the routing differs.  
    private final RelNode fragment;  
 * @opensearch.internal
    /**
public class Stage {  
    public SortSpec getSortSpec() {  
        this.inputSinkDecorator = inputSinkDecorator;
import org.opensearch.analytics.exec.canmatch.CanMatchFilter;
     * Null when this stage doesn't need any decoration.
 *
import org.opensearch.analytics.planner.rel.OpenSearchLateMaterialization;
    public void setInputSinkDecorator(InputSinkDecorator inputSinkDecorator) {  
        this.canMatchFilters = fragment != null ? CanMatchFilterExtractor.extract(fragment) : List.of();
        ExchangeSinkProvider exchangeSinkProvider,
        /** Hash-shuffle right scan — partitions and ships to workers (M2). */
     */  
    ) {
 * this file be licensed under the Apache-2.0 license or a
        this.instructionHandlerFactory = instructionHandlerFactory;  
        TargetResolver targetResolver  
    }
    private StageRole role = StageRole.SHARD_SOURCE;
        return planAlternatives;  
    public ExchangeSinkProvider getExchangeSinkProvider() {
        // no targetResolver / no sinkProvider. Checked first so other categories don't
     */  
    public List<Stage> getChildStages() {
     * {@link #SHUFFLE_SCAN_RIGHT} / {@link #SHUFFLE_WORKER} before dispatch.
    private final ExchangeSinkProvider exchangeSinkProvider;  
    }
}
package org.opensearch.analytics.planner.dag;
