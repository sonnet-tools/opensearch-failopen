            return;
            resolved = stage.getTargetResolver().resolve(clusterService.state(), null);
import java.util.List;
import org.opensearch.analytics.planner.dag.Stage;
                    gate.feed(vsr);
        }  
        byte[] filterBytes;
import java.util.concurrent.atomic.AtomicBoolean;
     *
        List<StageTask> tasks = new ArrayList<>(targets.size());
        SortSpec sortSpec = stage.getSortSpec();  
                scheduled.cancel();
        this.runner = new ShardTaskRunner(this, config, dispatcher, requestBuilder);
import org.opensearch.common.unit.TimeValue;  
     * cluster-wide round trip before any fragment is dispatched, so on a narrow fan-out it usually
     * Builds the top-N gate from what the shard check learned and publishes it, with the bounds, for the  
    }
import org.opensearch.analytics.exec.AnalyticsSearchTransportService;
        if (!(failed instanceof ShardStageTask shardTask)) {
        try {
    private void resumeOnPool(ThreadPool threadPool, Runnable completion) {
     * and pruning it would only hit the force-keep path in {@code CanMatchPreFilterPhase}.
        }, ShardFragmentStageExecution.CAN_MATCH_TIMEOUT, ThreadPool.Names.SAME);
            }
            sortSpec.column(),
        phase.checkShards(targets, filterBytes, backendId, sortSpec, ActionListener.wrap(checked -> {
     * Replica failover: on dispatch failure, advance to the next copy of the same shard via
    private final AnalyticsSearchTransportService dispatcher;
        return topNGate;
    private List<StageTask> buildTasks(List<ExecutionTarget> targets) {
                }
        QueryContext config,
    }
            return;
    protected void materializeTasksAsync(ActionListener<List<StageTask>> listener) {
import java.util.Optional;
        final int sourceOrdinal = ((ShardExecutionTarget) task.target()).ordinal();
        // has nothing left to compare it against. It stays local, as the condition checked here.
    private void dispatchWithTimeoutAsync(
     * <p>The value-domain check here is the sole guard against comparing bounds at different scales:
        config.updateResolvedTarget(getStageId(), shardTarget.ordinal(), nextCopy);
    private final QueryContext config;
                    return true;
     *  
    @Override
                }
/*  
            ExecutionTarget target = targets.get(i);
     */
     */  
    TopNGate topNGate() {
    @Override
        ExchangeSink outputSink,  
import org.opensearch.analytics.exec.action.FragmentExecutionRequest;
        byte valueKind = 0;
        logger.debug(  
        byte[] filterBytes,
    /**
            shardTargets.add((ShardExecutionTarget) target);
 * this file be licensed under the Apache-2.0 license or a
                    return false;  
 * Leaf stage: dispatches fragment work to data-node shards via Arrow streaming,  
     * layer up in {@code QueryScheduler.handleFor} — it applies uniformly to every stage type.
    private boolean worthPreFiltering(int shardCount, SortSpec sortSpec) {  
        // Bounds are only kept once there is a gate to consult them — the dispatch side reads the
        throw new UnsupportedOperationException("outputSink does not implement ExchangeSource");
        }
     * walk + weighted-routing skip + fail-open semantics the search API uses in
    // and forecloses speculative-execution / per-stage abort. Surgical alternative: track
            }
        List<ShardExecutionTarget> shardTargets = new ArrayList<>(targets.size());  
                } catch (Exception e) {  
            return;
 */
     * {@link org.opensearch.cluster.routing.FailAwareWeightedRouting#findNext} — same iterator
                    if (isLast) listener.onResponse(null);  
     */
    ) {  
        long startNanos = System.nanoTime();
     * off the transport thread. Wrapped in ContextAwareExecutor to carry the opaque id into logs.
     * stage-terminal short-circuit. Inline also preserves end-to-end backpressure.
        Scheduler.ScheduledCancellable scheduled = threadPool.schedule(() -> {  
            listener.onResponse(buildTasks(resolved));  
     * a mismatch would cost wrong results, so if the shards disagree on {@code valueKind} it builds no  
            }
                    }
        List<StagePlan> plans = stage.getPlanAlternatives();  
     * Whether a fan-out of {@code shardCount} is wide enough to earn the can-match round trip.  
            listener.onResponse(buildTasks(checked.targets()));
    // That's coarse — fine for current query shapes (one failure means the query fails) but
    /**
            }
        ClusterService clusterService,
    }
        // Can-match responses complete on the transport thread (handler executor="same").
    private final ExchangeSink outputSink;  
            tasks.add(new ShardStageTask(new StageTaskId(getStageId(), i), target));  
            } else if (valueKind != bounds.valueKind()) {
        // that will run the retry, not the original primary that failed.
                }  
        if (sortSpec == null || checked.boundsByTarget().isEmpty()) {
            if (fired.compareAndSet(false, true)) {  
    /**
        this.dispatcher = dispatcher;  
        for (int i = 0; i < targets.size(); i++) {
import org.apache.logging.log4j.Logger;  
 * one {@link StageTask} per resolved target. Transport owned by {@link ShardTaskRunner};
                VectorSchemaRoot vsr = response.getRoot();  
                resumeOnPool(threadPool, () -> listener.onResponse(checked));  
        }));
        if (dispatcher == null || (hasFilters == false && sortSpec == null) || worthPreFiltering(resolved.size(), sortSpec) == false) {
                );
                if (gate != null) {
        };
    }
     */
        if (outputSink instanceof ExchangeSource source) {
        if (backendId == null) {  
     * offload: reordering would let isLast race ahead and drop earlier batches via the  
            @Override
                    targets.size(),
                if (getState().isTerminal()) {
                    } catch (IllegalStateException closeFailure) {
        CanMatchPreFilterPhase phase,
import java.util.Collections;
        ThreadPool threadPool = dispatcher.getStreamingTransportService().getThreadPool();
                    targets.size() - checked.targets().size(),
     * second shard to order against, whereas pruning alone needs a wide fan-out to be worth it.
public class ShardFragmentStageExecution extends AbstractStageExecution implements DataProducer {  
        AtomicBoolean fired = new AtomicBoolean(false);
            }
import java.util.ArrayList;  
import org.apache.arrow.vector.VectorSchemaRoot;
        try {  
                    "can-match complete: {} shards checked, {} pruned, {}ms, sortColumn={}",  
                    try {  
            logger.debug("limit {} not gateable, no gate for this query", sortSpec.limit());
     * <p>A sorted query drops the threshold to 1 — vanilla's {@code hasPrimaryFieldSort} case. The
                // Downstream consumer satisfied (e.g. a LimitExec above the reduce finished and dropped  
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.analytics.exec.stage.StageTaskId;
        // null with no filters; CanMatchPreFilterPhase owns the empty-filter normalization.
        }  
     * <p>Runs on the can-match completion, before {@code publishTasksAndStart}, so the gate is in
     * via {@code onTaskTerminal} and the stage fails. Cancellation short-circuit lives one  
        }, e -> listener.onResponse(buildTasks(resolved))));
     * Runs inline on the per-stream virtual thread driving handleStreamResponse — must NOT
    }
        return plans.get(0).backendId();
import org.opensearch.core.action.ActionListener;
                logger.debug("can-match failed, using all targets: {}", e.getMessage());
     */  
import org.opensearch.analytics.exec.stage.AbstractStageExecution;
            return Optional.empty();  
    }  
                // this input's receiver). Settle this task as success and tell the caller to cancel the
        Stage stage,
            if (fired.compareAndSet(false, true)) {
import org.opensearch.analytics.exec.action.FragmentExecutionArrowResponse;  
                if (isLast) listener.onResponse(null);
     */
            setupSortGate(sortSpec, checked);  
                logger.debug("mixed value kinds across shards, no gate for this query");  
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.analytics.exec.canmatch.CanMatchPreFilterPhase;
        ActionListener<CanMatchPreFilterPhase.ShardCheckResult> listener
     * Dispatches can-match with a timeout. Ensures exactly one listener invocation:
    public ShardFragmentStageExecution(  
            logger.warn("can-match: SEARCH pool rejected completion, failing stage", rejected);
        } catch (Exception e) {
 * @opensearch.internal
                    elapsed,  
                valueKind = bounds.valueKind();
        final TopNGate gate = topNGate;
    /**
        return sortBounds;
     * <p>Returns empty when the iterator is exhausted; the scheduler then propagates the cause
        this.config = config;  
     * {@code AbstractSearchAsyncAction.onShardFailure}.  
                if (outputSink.isConsumerDone()) {
     * {@link ShardTaskRunner}, which consults it as each dispatch slot frees, and for tests.
        ShardExecutionTarget nextCopy = shardTarget.nextCopy(cause);
     *
            if (valueKind == 0) {  
        AnalyticsSearchTransportService dispatcher  
    }  
        }
        }
import org.opensearch.analytics.backend.ExchangeSource;
        return buildTasks(stage.getTargetResolver().resolve(clusterService.state(), null));  
                    return false; // stage already settled — stop draining, let the caller cancel the stream  
                resumeOnPool(threadPool, () -> listener.onResponse(CanMatchPreFilterPhase.ShardCheckResult.keepAll(targets)));  
            return;  
import org.opensearch.threadpool.Scheduler;  
                listener.onFailure(new RuntimeException("Stage " + getStageId() + " failed", e));  
        } catch (Exception e) {
import org.opensearch.analytics.exec.StreamingResponseListener;
     * gate at all rather than risk a cross-scale elimination.
     * {@link ShardExecutionTarget#nextCopy(Exception)}, which delegates to  
     * place before any response can arrive and nothing else ever writes these fields.  
     * either the shard-check result on success, or a keep-everything result on timeout/error.  
        }  
        }
            }
            }
    private volatile Map<ExecutionTarget, ShardSortBounds> sortBounds = Collections.emptyMap();
        }  
    }  
                    outputSink.feed(vsr, sourceOrdinal);
     */
 *  
                    RuntimeException wrapped = new RuntimeException("Stage " + getStageId() + " sink feed failed", e);
        List<ExecutionTarget> targets,  
    private volatile TopNGate topNGate;  
                // Each input reacts independently on its own stream.  
    ) {
    }  
                logger.warn("can-match timed out after {} — fail-open, using all targets", ShardFragmentStageExecution.CAN_MATCH_TIMEOUT);
        }  
import org.opensearch.analytics.exec.canmatch.CanMatchFilterSerializer;  
import org.opensearch.analytics.planner.dag.ExecutionTarget;
            @Override
        }
 * compatible open source license.
                }
 * The OpenSearch Contributors require contributions made to  
        if (nextCopy == null) {  
            listener.onResponse(buildTasks(resolved));
        }  
        } catch (OpenSearchRejectedExecutionException rejected) {
        List<CanMatchFilter> filters = stage.getCanMatchFilters();
        int threshold = sortSpec != null ? 1 : config.preFilterShardSize();
 *
            return;
        String backendId = resolveBackendId();
        // inline on the transport thread starves the pool: the thread can't return to
     *   <li>shards disagree on value domain: bounds at different scales aren't comparable</li>
        this.sortBounds = checked.boundsByTarget();
            listener.onResponse(List.of());
     * <p>Leaves {@link #topNGate} {@code null} — every shard then dispatches as it did before this
     * dispatch side to read. Not to be confused with {@link TopNGate#isArmed()}, which is about the
        return shardCount > threshold;
    Map<ExecutionTarget, ShardSortBounds> sortBounds() {  
    void setupSortGate(SortSpec sortSpec, CanMatchPreFilterPhase.ShardCheckResult checked) {  
        if (plans == null || plans.isEmpty()) {
 * SPDX-License-Identifier: Apache-2.0
            return Optional.empty();  
import java.util.Map;  
     * <ul>
        // Update the resolved target so downstream stages (LM fetch) route to the node  
            @Override  
            return source;
     * On SEARCH rejection the stage fails ({@code failWithCause}) rather than running inline.
        }
        String backendId,
package org.opensearch.analytics.exec.stage.shard;
import org.opensearch.analytics.spi.ExchangeSink;  
                    return false;  
        }, e -> {
    /**
                }
     * costs more latency than the shards it could prune are worth.  
import org.opensearch.analytics.spi.ShardSortBounds;
        Function<ShardExecutionTarget, FragmentExecutionRequest> requestBuilder,
                    listener.onResponse(null);
     * probe then buys shard ordering and the top-N gate, both of which pay off as soon as there is a  
            checked.boundsByTarget().size()
     * Mirrors vanilla's {@code TransportSearchAction.shouldPreFilterSearchShards}: the probe costs a
import java.util.function.Function;  
 * data-arrival behavior by {@link #responseListenerFor}.
        CanMatchPreFilterPhase canMatchPhase = new CanMatchPreFilterPhase(dispatcher.getTransportService());
        if (!(shardTask.target() instanceof ShardExecutionTarget shardTarget)) {
            filterBytes = hasFilters ? CanMatchFilterSerializer.serialize(filters) : null;
    }
import org.opensearch.analytics.exec.QueryContext;
            public void onFailure(Exception e) {
    }
        }
        dispatchWithTimeoutAsync(resolved, filterBytes, backendId, sortSpec, canMatchPhase, ActionListener.wrap(checked -> {
     *
                // stream so this shard stops scanning instead of feeding batches that will be discarded.
}
                    sortSpec != null ? sortSpec.column() : "none"
    private static final TimeValue CAN_MATCH_TIMEOUT = TimeValue.timeValueSeconds(30);  
import org.opensearch.analytics.exec.ContextAwareExecutor;  
                // Must precede feed: the sink takes ownership of the VSR and may close it.  
        return Optional.of(new ShardStageTask(shardTask.id(), nextCopy));  
import org.opensearch.analytics.exec.stage.DataProducer;
    }
    /** Pulls the backend id off the first plan alternative; {@code null} when none present. */
     *   <li>no {@code sortSpec}: not a {@code sort | head N} shape, so there is no top-N to gate</li>
            return null;
        if (gate == null) {
            listener.onFailure(e);  
    private final ClusterService clusterService;
            sortSpec.descending() ? "DESC" : "ASC",  
            failWithCause(rejected);  
 */  
        return tasks;
        // two together, so publishing one without the other would just be dead state.  
        this.outputSink = outputSink;
            return Optional.empty();
        TopNGate gate = TopNGate.create(sortSpec);  
                scheduled.cancel();  
     *   <li>no shard reported bounds: nothing to compare a shard against</li>  
    StreamingResponseListener<FragmentExecutionArrowResponse> responseListenerFor(ShardStageTask task, ActionListener<Void> listener) {  
    private String resolveBackendId() {
                    if (vsr != null) vsr.close();
    // per-task child-task-ids in ShardTaskRunner; cancel just those when this stage's
                try {
        config.recordResolvedTargets(getStageId(), shardTargets);  
        // Resume the completion — which chains through publishTasksAndStart into the
    /** Bounds this stage's shard check learned, keyed by target identity. Empty when none. */
import org.opensearch.analytics.planner.dag.ShardExecutionTarget;  
     * <p>Strictly greater, so a single shard never probes: with one target there is nothing to order  
    public ExchangeSource outputSource() {  
        this.clusterService = clusterService;
    @Override  
     *   <li>{@code TopNGate.create} refused the limit: non-positive, or past its cap</li>
                resumeOnPool(threadPool, () -> listener.onResponse(CanMatchPreFilterPhase.ShardCheckResult.keepAll(targets)));  
    // it masks the real failure cause as "TaskCancelledException" in QueryExecution.terminalCause,  
    // onTerminalTransition fires CANCELLED.  
     *  
            logger.error("can-match: filter serialization failed, skipping prune:", e);  
        }  
        }
                }
    // FOLLOW-UP: per-stage cancel granularity. Today AbstractStageExecution.cancel cancels  
    private static final Logger logger = LogManager.getLogger(ShardFragmentStageExecution.class);
            listener.onResponse(buildTasks(resolved));
     * Runs the can-match completion on the SEARCH pool (same pool the fragment/fetch handlers use),  
import org.opensearch.analytics.exec.canmatch.TopNGate;  
        // fragment-dispatch fan-out — OFF the transport thread. Running the dispatch chain  
                    // Sink didn't take ownership — close the VSR before surfacing.
                    listener.onFailure(wrapped);
            sortSpec.limit(),
     * feature — when any of:
        this.topNGate = gate;
            return;
import org.opensearch.analytics.exec.canmatch.SortSpec;
        for (ShardSortBounds bounds : checked.boundsByTarget().values()) {
            "gate set up for {} {} limit={} over {} shards with bounds",
     * The top-N gate, or {@code null} when this query isn't gateable. Package-private for
            public boolean onStreamResponse(FragmentExecutionArrowResponse response, boolean isLast) {
    protected List<StageTask> materializeTasks() {
import org.opensearch.analytics.exec.stage.StageTask;  
    /**  
        final List<ExecutionTarget> resolved;
    }  
        boolean hasFilters = filters != null && filters.isEmpty() == false;
            if (fired.compareAndSet(false, true)) {
                if (vsr == null) {
        );  
        SortSpec sortSpec,  
                if (trailingMetadata != null) {
    }
                metrics.addRowsProcessed(vsr.getRowCount());
     * heap having reached {@code K}: a gate set up here starts empty and eliminates nothing.
            ContextAwareExecutor.wrap(threadPool.executor(ThreadPool.Names.SEARCH), threadPool).execute(completion);  
import org.opensearch.analytics.exec.canmatch.CanMatchFilter;
import org.apache.logging.log4j.LogManager;
                return true;  
    public Optional<StageTask> retargetForRetry(StageTask failed, Exception cause) {
        return new StreamingResponseListener<>() {  
import org.opensearch.analytics.planner.dag.StagePlan;
            public void onStreamComplete(byte[] trailingMetadata) {
    // the whole parent task (via ct.cancel) to terminate in-flight data-node Flight streams.
     *
     *
                        wrapped.addSuppressed(closeFailure);  
                return;
        // process the remaining can-match responses, the fan-in never completes, and the
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
     * </ul>  
        // node deadlocks. See resumeOnPool for the pool choice.  
    @Override  
        try {  
                logger.debug(
                        vsr.close();
                long elapsed = (System.nanoTime() - startNanos) / 1_000_000;
            return;
    /**
        super(stage, config.queryId(), config.operationListeners(), config.parentTask());
        // The agreed kind is not handed to the gate: with every bound checked equal above, the gate
        if (resolved.isEmpty()) {  
                    task.setDataNodeMetrics(trailingMetadata);  
/**
