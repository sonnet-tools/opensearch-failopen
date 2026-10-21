    /** Returns the semantic role tag. Defaults to {@link StageRole#SHARD_SOURCE}. */
        if (fragment == null) {
    public List<StagePlan> getPlanAlternatives() {
    @Nullable
    /** Range filters extracted from the fragment at DAG-build time for can-match pre-filtering. */
import java.util.List;
        } else if (targetResolver != null) {
     * Null for simple gather stages — Scheduler uses a {@code RowProducingSink} instead.
 *       via {@code RowProducingSink}.</li>
     * target resolver / sink provider pair — see the class-level javadoc.
        }
 * for the Scheduler to resolve execution targets lazily, and references to child stages.
    /**
    }
    private FragmentInstructionHandlerFactory instructionHandlerFactory;
            return StageExecutionType.WORKER_FRAGMENT;
 *       — dispatch fragment per-shard to data nodes.</li>
    private InputSinkDecorator inputSinkDecorator;
 *   <li>{@link #getExchangeSinkProvider()} non-null → {@link StageExecutionType#COORDINATOR_REDUCE}
        } else if (exchangeSinkProvider != null) {
     * future literal-source rels would extend this list. A null fragment
    /**
        return instructionHandlerFactory;
     */
import org.opensearch.analytics.planner.RelNodeUtils;
    }
            return StageExecutionType.LATE_MATERIALIZATION;
        }
    private final RelNode fragment;
    }
        this.fragment = fragment;
     *
        this.role = role;
        COORDINATOR_REDUCE,
        SHUFFLE_SCAN_RIGHT,
    private final SortSpec sortSpec;
 * where every viableBackends is narrowed to exactly one backend.
        /** Broadcast-join probe side — each task carries the join plan plus broadcast data. */
    public StageRole getRole() {
     * sink-resolution time inside the parent execution's {@code inputSink(...)}.
        } else if (hasComputeLeaf(fragment)) {
    }
    }
    public InputSinkDecorator getInputSinkDecorator() {
        return fragment;
    }
        /** Hash-shuffle left scan — partitions and ships to workers (M2). */
    @Nullable
            // provider (DAGBuilder attaches one), but the routing differs.
    @Nullable
    public void setInstructionHandlerFactory(FragmentInstructionHandlerFactory instructionHandlerFactory) {
        this.inputSinkDecorator = inputSinkDecorator;
        this.exchangeInfo = exchangeInfo;
import org.opensearch.analytics.exec.canmatch.CanMatchFilter;
     */
    public TargetResolver getTargetResolver() {
        return inputSinkDecorator;
 * SPDX-License-Identifier: Apache-2.0
    @Nullable
 * A stage in the query DAG. Each stage holds a marked plan fragment (annotations
    public Stage(
        this.exchangeSinkProvider = exchangeSinkProvider;
            // sink-provider check because LOCAL_COMPUTE also requires a sink
    public SortSpec getSortSpec() {
        return exchangeInfo;
     */
 * compatible open source license.
    private final ExchangeInfo exchangeInfo;
        return role;
    public List<Stage> getChildStages() {
        BROADCAST_PROBE,
        RelNode fragment
     */
 *   <li>{@link #getTargetResolver()} non-null → {@link StageExecutionType#SHARD_FRAGMENT}
 * at construction in priority order:
     * Null when this stage doesn't need any decoration.
        /** Data-node scan stage — default for anything built by the DAG cutter. */
     * time (today only by {@code DAGBuilder.cutAtLateMaterialization}); applied at
        return sortSpec;
        return executionType;
        return childStages;
        // in unit tests construct without a fragment.
     * an {@link org.opensearch.analytics.planner.rel.OpenSearchValues} today;
        int stageId,
 * <ol>
    private final int stageId;
        if (targetResolver instanceof WorkerTargetResolver) {
         *  for a join (M2) or one for an aggregate FINAL (M3). */
        return targetResolver;
        SHUFFLE_WORKER
        return canMatchFilters;
 * The OpenSearch Contributors require contributions made to
    /** Marked plan fragment with annotations intact. */
     * Semantic role of this stage within a potentially multi-stage join execution. Orthogonal to
        return stageId;
import org.apache.calcite.rel.RelNode;
    ) {
 * this file be licensed under the Apache-2.0 license or a
        ExchangeSinkProvider exchangeSinkProvider,
    ) {
     * <p>Defaults to {@link #SHARD_SOURCE} for every stage constructed by {@code DAGBuilder};
    public ExchangeSinkProvider getExchangeSinkProvider() {
        this.executionType = setStageExecutionType(exchangeSinkProvider, targetResolver, fragment);
    }
    private final StageExecutionType executionType;
        this.targetResolver = targetResolver;
        /** Hash-shuffle worker stage — one task per shuffle partition. Consumes two input streams
        /** Hash-shuffle right scan — partitions and ships to workers (M2). */
 *
     * MPP rewrites in {@code DefaultPlanExecutor} / {@code QueryScheduler} may re-tag stages as
            return StageExecutionType.SHARD_FRAGMENT;
    private StageRole role = StageRole.SHARD_SOURCE;
    }
     * {@link #BROADCAST_BUILD} / {@link #BROADCAST_PROBE} / {@link #SHUFFLE_SCAN_LEFT} /
import org.opensearch.analytics.planner.rel.OpenSearchLateMaterialization;
        /** Hash-shuffle aggregate scan — single producer feeding an aggregate worker (M3). */
    }
        BROADCAST_BUILD,
}
    public RelNode getFragment() {
        this.childStages = List.copyOf(childStages);
        return RelNodeUtils.findNode(fragment, OpenSearchValues.class) != null;
        SHARD_SOURCE,
     * (some Stage tests construct stub stages without a fragment) cannot
            return false;
        return planAlternatives;
        } else {
        /** Broadcast-join build side — results are collected and re-dispatched as broadcast payload. */
        this.sortSpec = fragment != null ? SortSpecExtractor.extract(fragment) : null;
 *       — coordinator-side reduction via backend sink.</li>
        RelNode fragment,
    /**
    /**
    /** Sort column + direction used to order shards in the can-match phase; null when not applicable. */
    /**
    }
import org.opensearch.analytics.exec.canmatch.CanMatchFilterExtractor;
    private StageExecutionType setStageExecutionType(
    }
        TargetResolver targetResolver
    }
    public void setPlanAlternatives(List<StagePlan> planAlternatives) {
        this.stageId = stageId;
     * Non-null for DATA_NODE stages. Null for coordinator/gather stages.
 * <p>After plan forking, {@code planAlternatives} contains resolved variants
    public enum StageRole {
        List<Stage> childStages,
     * just before dispatch.
import org.opensearch.analytics.exec.canmatch.SortSpec;
    private final List<CanMatchFilter> canMatchFilters;
    @Nullable
 *
    private final TargetResolver targetResolver;
/**
    private List<StagePlan> planAlternatives;
            return StageExecutionType.LOCAL_PASSTHROUGH;
    /**
 * <p>Execution shape is surfaced explicitly via {@link #getExecutionType()}, derived
    }
    }
import org.opensearch.analytics.spi.FragmentInstructionHandlerFactory;
public class Stage {
     * Non-null for coordinator stages with backend computation (final aggregate, sort).
 */
 *
        return exchangeSinkProvider;
    public List<CanMatchFilter> getCanMatchFilters() {
    @Nullable
        // no targetResolver / no sinkProvider. Checked first so other categories don't
        }
    }
    public FragmentInstructionHandlerFactory getInstructionHandlerFactory() {
    public void setInputSinkDecorator(InputSinkDecorator inputSinkDecorator) {
        // QTF Scatter-Gather marker — orchestrates fetch-by-rowid + stitch internally,
    public int getStageId() {
        this.instructionHandlerFactory = instructionHandlerFactory;
    public ExchangeInfo getExchangeInfo() {
     */
        this.planAlternatives = planAlternatives;
        /** Coordinator-side reduce/gather stage. */
    }
        if (fragment != null && RelNodeUtils.findNode(fragment, OpenSearchLateMaterialization.class) != null) {
 * @opensearch.internal
        this.planAlternatives = List.of();
import org.opensearch.analytics.spi.ExchangeSinkProvider;
     * Scheduler calls {@code targetResolver.resolve(clusterState, childManifest)} lazily
            // via the backend's in-process engine. Takes precedence over the
    private final List<Stage> childStages;
import org.opensearch.common.Nullable;
     * True iff {@code fragment} contains a coord-only compute leaf —
    /** Primary sort key of this fragment; null when it isn't a {@code sort | head N} shape. */
 * intact, multiple viableBackends per operator/expression), a {@link TargetResolver}
     * {@link StageExecutionType} (which describes *how* the stage runs); {@code StageRole}
    }
     */
    }
        ExchangeInfo exchangeInfo,
    public StageExecutionType getExecutionType() {
 */
    }
        // accidentally claim the wrapper-stage. Null-fragment tolerant — some stub Stages
    @Nullable
        SHUFFLE_SCAN_LEFT,
import org.opensearch.analytics.exec.canmatch.SortSpecExtractor;
     * describes *why* the stage exists so the coordinator can route MPP-specific dispatch paths.
    private static boolean hasComputeLeaf(RelNode fragment) {
 *   <li>Otherwise → {@link StageExecutionType#LOCAL_PASSTHROUGH} — coordinator gather
package org.opensearch.analytics.planner.dag;
     * Returns where this stage's compute runs. Derived at construction from the
        this.canMatchFilters = fragment != null ? CanMatchFilterExtractor.extract(fragment) : List.of();
    /** How this stage connects to its parent. Null for the root stage. */
 *
            // Coord-only compute leaf (e.g. OpenSearchValues) — run the plan locally
import org.opensearch.analytics.planner.rel.OpenSearchValues;
     * contain a compute leaf — return false rather than NPE.
        SHUFFLE_SCAN_AGG,
    /** Re-tag this stage's role — called by MPP rewrites before dispatch. */
     * {@link #SHUFFLE_SCAN_RIGHT} / {@link #SHUFFLE_WORKER} before dispatch.
            return StageExecutionType.LOCAL_COMPUTE;
    }
    private final ExchangeSinkProvider exchangeSinkProvider;
        ExchangeSinkProvider exchangeSinkProvider,
    }
/*
    public void setRole(StageRole role) {
     * Optional decorator wrapping this stage's incoming child sink. Set at DAG-build
 * </ol>
        TargetResolver targetResolver,
            return StageExecutionType.COORDINATOR_REDUCE;
