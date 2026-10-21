            logger.error("can-match: filter serialization failed, skipping prune:", e);
        }, e -> listener.onResponse(buildTasks(resolved))));
     * {@link org.opensearch.cluster.routing.FailAwareWeightedRouting#findNext} — same iterator
     * Runs the can-match completion on the SEARCH pool (same pool the fragment/fetch handlers use),
                    outputSink.feed(vsr, sourceOrdinal);
        return plans.get(0).backendId();
                logger.debug("mixed value kinds across shards, no gate for this query");
        }
                }
            } else if (valueKind != bounds.valueKind()) {
    private List<StageTask> buildTasks(List<ExecutionTarget> targets) {
        for (int i = 0; i < targets.size(); i++) {
        byte[] filterBytes,
     */
        return topNGate;
        }
        ExchangeSink outputSink,
    private static final Logger logger = LogManager.getLogger(ShardFragmentStageExecution.class);
                long elapsed = (System.nanoTime() - startNanos) / 1_000_000;
        if (nextCopy == null) {
    }
            filterBytes = hasFilters ? CanMatchFilterSerializer.serialize(filters) : null;
                logger.debug("can-match failed, using all targets: {}", e.getMessage());
     * dispatch side to read. Not to be confused with {@link TopNGate#isArmed()}, which is about the
            return Optional.empty();
                listener.onFailure(new RuntimeException("Stage " + getStageId() + " failed", e));
        this.clusterService = clusterService;
        for (ShardSortBounds bounds : checked.boundsByTarget().values()) {
    }
    public Optional<StageTask> retargetForRetry(StageTask failed, Exception cause) {
                    try {
                        wrapped.addSuppressed(closeFailure);
 *
                if (gate != null) {
package org.opensearch.analytics.exec.stage.shard;
import java.util.Collections;
     * <ul>
        }
        super(stage, config.queryId(), config.operationListeners(), config.parentTask());
        };
                return true;
            tasks.add(new ShardStageTask(new StageTaskId(getStageId(), i), target));
                        vsr.close();
        } catch (Exception e) {
/*
import org.opensearch.analytics.exec.canmatch.CanMatchFilter;
import org.opensearch.analytics.exec.stage.DataProducer;
        return shardCount > threshold;
    /**
 */
        } catch (Exception e) {
    }
    // it masks the real failure cause as "TaskCancelledException" in QueryExecution.terminalCause,
                    listener.onFailure(wrapped);
            listener.onResponse(List.of());
        final TopNGate gate = topNGate;
    private final ClusterService clusterService;
    void setupSortGate(SortSpec sortSpec, CanMatchPreFilterPhase.ShardCheckResult checked) {
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        phase.checkShards(targets, filterBytes, backendId, sortSpec, ActionListener.wrap(checked -> {
/**
        }
            listener.onResponse(buildTasks(resolved));
            }
    protected List<StageTask> materializeTasks() {
        List<StagePlan> plans = stage.getPlanAlternatives();
        // has nothing left to compare it against. It stays local, as the condition checked here.
        QueryContext config,
                } catch (Exception e) {
        long startNanos = System.nanoTime();
import java.util.Map;
        AtomicBoolean fired = new AtomicBoolean(false);
            resolved = stage.getTargetResolver().resolve(clusterService.state(), null);
 * Leaf stage: dispatches fragment work to data-node shards via Arrow streaming,
            if (fired.compareAndSet(false, true)) {
            ContextAwareExecutor.wrap(threadPool.executor(ThreadPool.Names.SEARCH), threadPool).execute(completion);
        CanMatchPreFilterPhase canMatchPhase = new CanMatchPreFilterPhase(dispatcher.getTransportService());
            return;
        // process the remaining can-match responses, the fan-in never completes, and the
     * Runs inline on the per-stream virtual thread driving handleStreamResponse — must NOT
    TopNGate topNGate() {
import org.opensearch.analytics.planner.dag.ShardExecutionTarget;
            @Override
        TopNGate gate = TopNGate.create(sortSpec);
     */
        AnalyticsSearchTransportService dispatcher
        if (plans == null || plans.isEmpty()) {
        }
        List<StageTask> tasks = new ArrayList<>(targets.size());
            }
        this.topNGate = gate;
     * a mismatch would cost wrong results, so if the shards disagree on {@code valueKind} it builds no
     */
            return Optional.empty();
        }
        ShardExecutionTarget nextCopy = shardTarget.nextCopy(cause);
    // per-task child-task-ids in ShardTaskRunner; cancel just those when this stage's
                    } catch (IllegalStateException closeFailure) {
                    "can-match complete: {} shards checked, {} pruned, {}ms, sortColumn={}",
                logger.warn("can-match timed out after {} — fail-open, using all targets", ShardFragmentStageExecution.CAN_MATCH_TIMEOUT);
            failWithCause(rejected);
import org.opensearch.common.unit.TimeValue;
    }
import org.opensearch.core.action.ActionListener;
                    RuntimeException wrapped = new RuntimeException("Stage " + getStageId() + " sink feed failed", e);
                // Must precede feed: the sink takes ownership of the VSR and may close it.
                    return false; // stage already settled — stop draining, let the caller cancel the stream
                if (vsr == null) {
            return Optional.empty();
import org.opensearch.analytics.exec.AnalyticsSearchTransportService;
            listener.onFailure(e);
                }
    ) {
     * <p>Leaves {@link #topNGate} {@code null} — every shard then dispatches as it did before this
     * layer up in {@code QueryScheduler.handleFor} — it applies uniformly to every stage type.
    }
        }
        }
    // the whole parent task (via ct.cancel) to terminate in-flight data-node Flight streams.
     *
                valueKind = bounds.valueKind();
    /**
    // onTerminalTransition fires CANCELLED.
        Stage stage,
     *
            sortSpec.column(),
    }
import org.opensearch.threadpool.Scheduler;
                    if (isLast) listener.onResponse(null);
     * offload: reordering would let isLast race ahead and drop earlier batches via the
     *   <li>no shard reported bounds: nothing to compare a shard against</li>
        boolean hasFilters = filters != null && filters.isEmpty() == false;
import org.opensearch.analytics.spi.ExchangeSink;
        List<CanMatchFilter> filters = stage.getCanMatchFilters();
            sortSpec.limit(),
}
     * cluster-wide round trip before any fragment is dispatched, so on a narrow fan-out it usually
            public void onFailure(Exception e) {
        if (gate == null) {
        byte[] filterBytes;
        );
import org.apache.logging.log4j.LogManager;
    /**
    @Override
 * SPDX-License-Identifier: Apache-2.0
    }
     * costs more latency than the shards it could prune are worth.
                logger.debug(
        this.outputSink = outputSink;
 *
        // null with no filters; CanMatchPreFilterPhase owns the empty-filter normalization.
        // Resume the completion — which chains through publishTasksAndStart into the
            return;
                    targets.size() - checked.targets().size(),
                try {
        if (resolved.isEmpty()) {
     * <p>Returns empty when the iterator is exhausted; the scheduler then propagates the cause
import org.apache.logging.log4j.Logger;
import org.opensearch.analytics.exec.canmatch.SortSpec;
                );
        // Update the resolved target so downstream stages (LM fetch) route to the node
 * compatible open source license.
    private void dispatchWithTimeoutAsync(
     * <p>Runs on the can-match completion, before {@code publishTasksAndStart}, so the gate is in
     * {@link ShardExecutionTarget#nextCopy(Exception)}, which delegates to
    }
        // Can-match responses complete on the transport thread (handler executor="same").
     *   <li>shards disagree on value domain: bounds at different scales aren't comparable</li>
     *   <li>{@code TopNGate.create} refused the limit: non-positive, or past its cap</li>
            public boolean onStreamResponse(FragmentExecutionArrowResponse response, boolean isLast) {
        String backendId = resolveBackendId();
    ) {
            return source;
            listener.onResponse(buildTasks(resolved));
     *   <li>no {@code sortSpec}: not a {@code sort | head N} shape, so there is no top-N to gate</li>
        }
     */
import org.opensearch.analytics.backend.ExchangeSource;
     */
            public void onStreamComplete(byte[] trailingMetadata) {
        SortSpec sortSpec = stage.getSortSpec();
        // two together, so publishing one without the other would just be dead state.
            return;
     *
import org.opensearch.analytics.exec.action.FragmentExecutionRequest;
     * second shard to order against, whereas pruning alone needs a wide fan-out to be worth it.
 * this file be licensed under the Apache-2.0 license or a
    }
        if (outputSink instanceof ExchangeSource source) {
        String backendId,
    protected void materializeTasksAsync(ActionListener<List<StageTask>> listener) {
    /**
    // That's coarse — fine for current query shapes (one failure means the query fails) but
                resumeOnPool(threadPool, () -> listener.onResponse(CanMatchPreFilterPhase.ShardCheckResult.keepAll(targets)));
        return new StreamingResponseListener<>() {
            return null;
        ThreadPool threadPool = dispatcher.getStreamingTransportService().getThreadPool();
                if (trailingMetadata != null) {
                if (outputSink.isConsumerDone()) {
     * On SEARCH rejection the stage fails ({@code failWithCause}) rather than running inline.
                }
        // that will run the retry, not the original primary that failed.
            setupSortGate(sortSpec, checked);
import org.opensearch.threadpool.ThreadPool;
    private static final TimeValue CAN_MATCH_TIMEOUT = TimeValue.timeValueSeconds(30);
    }
    // and forecloses speculative-execution / per-stage abort. Surgical alternative: track
import org.apache.arrow.vector.VectorSchemaRoot;
        this.runner = new ShardTaskRunner(this, config, dispatcher, requestBuilder);
        if (!(shardTask.target() instanceof ShardExecutionTarget shardTarget)) {
        if (dispatcher == null || (hasFilters == false && sortSpec == null) || worthPreFiltering(resolved.size(), sortSpec) == false) {
                // Downstream consumer satisfied (e.g. a LimitExec above the reduce finished and dropped
        SortSpec sortSpec,
                return;
            logger.warn("can-match: SEARCH pool rejected completion, failing stage", rejected);
     * </ul>
     * Whether a fan-out of {@code shardCount} is wide enough to earn the can-match round trip.
     * gate at all rather than risk a cross-scale elimination.
     * walk + weighted-routing skip + fail-open semantics the search API uses in
                if (isLast) listener.onResponse(null);
     *
                    if (vsr != null) vsr.close();
                resumeOnPool(threadPool, () -> listener.onResponse(checked));
        return Optional.of(new ShardStageTask(shardTask.id(), nextCopy));
        ActionListener<CanMatchPreFilterPhase.ShardCheckResult> listener
     * off the transport thread. Wrapped in ContextAwareExecutor to carry the opaque id into logs.
     * place before any response can arrive and nothing else ever writes these fields.
                    return false;
        // fragment-dispatch fan-out — OFF the transport thread. Running the dispatch chain
        } catch (OpenSearchRejectedExecutionException rejected) {
    private volatile Map<ExecutionTarget, ShardSortBounds> sortBounds = Collections.emptyMap();
        if (!(failed instanceof ShardStageTask shardTask)) {
                if (getState().isTerminal()) {
            checked.boundsByTarget().size()
        if (backendId == null) {
 * data-arrival behavior by {@link #responseListenerFor}.
                scheduled.cancel();
        CanMatchPreFilterPhase phase,
     *
                // stream so this shard stops scanning instead of feeding batches that will be discarded.
            if (fired.compareAndSet(false, true)) {
     * Builds the top-N gate from what the shard check learned and publishes it, with the bounds, for the
            ExecutionTarget target = targets.get(i);
                // this input's receiver). Settle this task as success and tell the caller to cancel the
        throw new UnsupportedOperationException("outputSink does not implement ExchangeSource");
     * <p>A sorted query drops the threshold to 1 — vanilla's {@code hasPrimaryFieldSort} case. The
    // FOLLOW-UP: per-stage cancel granularity. Today AbstractStageExecution.cancel cancels
import java.util.function.Function;
        }
                }
import java.util.Optional;
     * probe then buys shard ordering and the top-N gate, both of which pay off as soon as there is a
    @Override
    public ShardFragmentStageExecution(
        byte valueKind = 0;
import org.opensearch.analytics.exec.ContextAwareExecutor;
     * <p>The value-domain check here is the sole guard against comparing bounds at different scales:
        // Bounds are only kept once there is a gate to consult them — the dispatch side reads the
    Map<ExecutionTarget, ShardSortBounds> sortBounds() {
 * one {@link StageTask} per resolved target. Transport owned by {@link ShardTaskRunner};
                // Each input reacts independently on its own stream.
    /**
import org.opensearch.analytics.spi.ShardSortBounds;
                    return true;
import org.opensearch.analytics.exec.canmatch.TopNGate;
     * Dispatches can-match with a timeout. Ensures exactly one listener invocation:
        }));
            }
import org.opensearch.analytics.exec.action.FragmentExecutionArrowResponse;
     * {@code AbstractSearchAsyncAction.onShardFailure}.
        ClusterService clusterService,
    public ExchangeSource outputSource() {
public class ShardFragmentStageExecution extends AbstractStageExecution implements DataProducer {
     * via {@code onTaskTerminal} and the stage fails. Cancellation short-circuit lives one
 */
    }
     *
        }
    }
            if (fired.compareAndSet(false, true)) {
import org.opensearch.analytics.exec.StreamingResponseListener;
            }
            "gate set up for {} {} limit={} over {} shards with bounds",
            return;
    private final AnalyticsSearchTransportService dispatcher;
        return sortBounds;
            logger.debug("limit {} not gateable, no gate for this query", sortSpec.limit());
        // The agreed kind is not handed to the gate: with every bound checked equal above, the gate
                resumeOnPool(threadPool, () -> listener.onResponse(CanMatchPreFilterPhase.ShardCheckResult.keepAll(targets)));
import org.opensearch.analytics.exec.canmatch.CanMatchFilterSerializer;
 * @opensearch.internal
import java.util.concurrent.atomic.AtomicBoolean;
        }
            return;
    /** Pulls the backend id off the first plan alternative; {@code null} when none present. */
                    targets.size(),
    private boolean worthPreFiltering(int shardCount, SortSpec sortSpec) {
     * stage-terminal short-circuit. Inline also preserves end-to-end backpressure.
            return;
        int threshold = sortSpec != null ? 1 : config.preFilterShardSize();
            if (valueKind == 0) {
                VectorSchemaRoot vsr = response.getRoot();
     * heap having reached {@code K}: a gate set up here starts empty and eliminates nothing.
import org.opensearch.analytics.planner.dag.Stage;
     */
        // inline on the transport thread starves the pool: the thread can't return to
        List<ExecutionTarget> targets,
        }
     * Replica failover: on dispatch failure, advance to the next copy of the same shard via
     *
     * and pruning it would only hit the force-keep path in {@code CanMatchPreFilterPhase}.
import org.opensearch.analytics.planner.dag.StagePlan;
    }
import org.opensearch.analytics.exec.stage.StageTaskId;
    /**
import org.opensearch.analytics.exec.canmatch.CanMatchPreFilterPhase;
                metrics.addRowsProcessed(vsr.getRowCount());
        try {
            }
        config.updateResolvedTarget(getStageId(), shardTarget.ordinal(), nextCopy);
        Scheduler.ScheduledCancellable scheduled = threadPool.schedule(() -> {
import org.opensearch.analytics.exec.QueryContext;
    private String resolveBackendId() {
    StreamingResponseListener<FragmentExecutionArrowResponse> responseListenerFor(ShardStageTask task, ActionListener<Void> listener) {
            listener.onResponse(buildTasks(checked.targets()));
     * feature — when any of:
            listener.onResponse(buildTasks(resolved));
        }
 * The OpenSearch Contributors require contributions made to
        List<ShardExecutionTarget> shardTargets = new ArrayList<>(targets.size());
import org.opensearch.cluster.service.ClusterService;
                    task.setDataNodeMetrics(trailingMetadata);
            @Override
    @Override
        }, e -> {
        // node deadlocks. See resumeOnPool for the pool choice.
            sortSpec.descending() ? "DESC" : "ASC",
        Function<ShardExecutionTarget, FragmentExecutionRequest> requestBuilder,
            return;
                    // Sink didn't take ownership — close the VSR before surfacing.
    @Override
        if (sortSpec == null || checked.boundsByTarget().isEmpty()) {
        final int sourceOrdinal = ((ShardExecutionTarget) task.target()).ordinal();
            shardTargets.add((ShardExecutionTarget) target);
    private final QueryContext config;
     * The top-N gate, or {@code null} when this query isn't gateable. Package-private for
                }
        try {
        this.dispatcher = dispatcher;
        }, ShardFragmentStageExecution.CAN_MATCH_TIMEOUT, ThreadPool.Names.SAME);
     * <p>Strictly greater, so a single shard never probes: with one target there is nothing to order
    private volatile TopNGate topNGate;
    }
                    }
    private final ExchangeSink outputSink;
                    gate.feed(vsr);
        logger.debug(
                    return false;
        this.config = config;
        }
        final List<ExecutionTarget> resolved;
        try {
                scheduled.cancel();
import java.util.ArrayList;
                    elapsed,
    private void resumeOnPool(ThreadPool threadPool, Runnable completion) {
    /**
                    sortSpec != null ? sortSpec.column() : "none"
     * {@link ShardTaskRunner}, which consults it as each dispatch slot frees, and for tests.
            }
                    listener.onResponse(null);
            }
        this.sortBounds = checked.boundsByTarget();
     */
    /** Bounds this stage's shard check learned, keyed by target identity. Empty when none. */
            @Override
import java.util.List;
        config.recordResolvedTargets(getStageId(), shardTargets);
     * either the shard-check result on success, or a keep-everything result on timeout/error.
import org.opensearch.analytics.exec.stage.StageTask;
        return tasks;
        return buildTasks(stage.getTargetResolver().resolve(clusterService.state(), null));
                }
import org.opensearch.analytics.exec.stage.AbstractStageExecution;
     * Mirrors vanilla's {@code TransportSearchAction.shouldPreFilterSearchShards}: the probe costs a
        dispatchWithTimeoutAsync(resolved, filterBytes, backendId, sortSpec, canMatchPhase, ActionListener.wrap(checked -> {
import org.opensearch.analytics.planner.dag.ExecutionTarget;
