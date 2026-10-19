import org.opensearch.action.support.HandledTransportAction;
        final QueryContext context;
        ActionListener<Iterable<Object[]>> rowsListener = buildProfilingRowsListener(
                    (AnalyticsQueryTask) task,
            return true;
                    try {
        RelNode plan = PlannerImpl.createPlan(logicalFragment, plannerContext);
                    queryTask.getId(),
                    @Override
 *
                ownsAllocator,
        final BufferAllocator queryAllocator;
     * Returns true if the exception would produce a 500 response and should be redacted.
                executeInternal(
        // TODO: remove the null fallback once every front-end (test-ppl-frontend,
    ) {
        }
     * @param broadcastDisabled when true, the planner is told to suppress every BROADCAST join
import org.opensearch.analytics.planner.RelNodeUtils;
            // tasks (e.g. a shuffle byte-budget breach) and so never triggers the per-task
                    }, convertingListener::onFailure)
        EngineContextProvider contextProvider,
            // a framework misconfiguration. Translate Arrow's OutOfMemoryException into
        // searchExecutor. The SecurityFilter also evaluates index permissions on this path.
import org.apache.logging.log4j.Logger;
                );
                AnalyticsSettings.MPP_DISTRIBUTE_MIN_ROWS.getKey(),
        if ((dagHasDistributedJoin || dagHasBroadcast) && !isQueryScheduler) {
            // planning-only profile rather than NPE-ing — the failure path below uses the same
import org.opensearch.analytics.planner.dag.Stage;
                                request.isProfile() ? new AnalyticsQueryResponse(result) : new AnalyticsQueryResponse(result.rows())
     * (e.g. a 429 breaker wrapped as {@code RuntimeException("Stage N failed", cbe)}). Returns it so the
        }
                        + "re-planning without broadcast (falling back to hash-shuffle / coordinator-centric). "
        AnalyticsQueryRequest request = new AnalyticsQueryRequest(logicalFragment, queryCtx, indices, true);
                    }
            if (dispatchGeneralShuffle && dagHasBroadcast) {
                ((OpenSearchRelNode) plan).getViableBackends()
     * Unified planning + execution path. When {@code profile} is true, captures the CBO
        PlanForker.forkAll(dag, capabilityRegistry);
                    @Override
    implements
        String[] indices = RelNodeUtils.extractIndices(logicalFragment);
    }
        AtomicReference<QueryExecution> execRef,
            long totalRows = rows instanceof List ? ((List<?>) rows).size() : 0;
            context,
                        + "Raise analytics.mpp.broadcast.max_bytes to keep broadcasting larger builds.",
        // mixed-key, broadcast, and scalar-subquery shapes all emerge generically, with no per-shape code.
                            // ProfiledResult.failure so the profile is always recorded; surface it
            // starting; remove the setting once we confirm no deployment depends on it.
    }
        this.indexNameExpressionResolver = indexNameExpressionResolver;
        final long planStartNanos = System.nanoTime();
     * Runs the GENERAL post-CBO scheduler path. The DAG was produced by {@link DistributionEnforcementPass}:
                clusterService.getClusterSettings().get(AnalyticsSettings.MPP_BROADCAST_PROBE_ESTIMATE)
import org.opensearch.analytics.settings.PlannerSettings;
            capabilityRegistry
                v -> maxConcurrentShardRequestsPerNode = v
import org.opensearch.analytics.planner.dag.QueryDAG;
        FragmentConversionDriver.convertAll(dag, capabilityRegistry);
import org.opensearch.OpenSearchException;
        // to reclaim, so stop retrying.
            context.setImportStagingAllocator(importStagingAllocator);
            }
                AnalyticsSettings.MPP_SHUFFLE_AGGREGATE_ENABLED.get(perQuerySettings)
    private final NodeClient client;
    private final Executor searchExecutor;
import org.apache.calcite.plan.RelOptUtil;
            }
        try {
                    @Override
            // fires unconditionally, so it covers the FAILURE path that does NOT cancel data-node
            // on the SEARCH executor (off this terminal/callback thread, fresh THREAD_PROVIDERS) and
        // hash-shuffle / coordinator-centric (the build overflowed the runtime cap on attempt 1).
        boolean includeProfileInResponse,
        // Create the slow log wrapper at the start so it observes the full query lifecycle.
            dataNodes = clusterService.state().nodes().getDataNodes();
import org.opensearch.arrow.allocator.AllocationRejection;
            batchesListener.onFailure(e);
        final boolean planUsesShuffle = dagHasHashExchange(dag);
            // (BROADCAST / HASH_SHUFFLE / HASH_SHUFFLE_AGG). The dispatcher path threads its
            return;
            );
    }
import org.opensearch.analytics.settings.AnalyticsQuerySettings;
 * {@link ClusterService}, {@link ThreadPool}, etc.) automatically.
                AnalyticsSettings.MPP_SHUFFLE_PRUNE_COLUMNS.getKey(),
                dag,
            queryAllocator = AllocationRejection.wrap(
import java.util.concurrent.TimeUnit;
            return;
            // the planner gate kept the node-bootstrap value — gate and runtime would disagree mid-query.
    }
                AnalyticsClearShuffleAction.NAME,
        this.maxConcurrentShardRequestsPerNode = AnalyticsQuerySettings.MAX_CONCURRENT_SHARD_REQUESTS_PER_NODE.get(
        });
        // updates via PUT /_cluster/settings (e.g. analytics.mpp.enabled) are invisible to the
                ),
import java.util.List;
            // (a harmless no-op broadcast), and never misses a real shuffle (a miss re-opens the leak).
     * Materializes Arrow batches into row-oriented {@code Object[]}s for the
        } catch (Exception e) {
            } else {
    public int preFilterShardSize() {
    /**
    private final ThreadPool threadPool;
        } else {
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;
                BroadcastSizeExceededException overflow = result.isSuccess()
        return rows;
        // buffers may be populated on data nodes. Drives the terminal cleanup broadcast: skip it for the
            // fallback for consistency.
            // Without this, a dynamic PUT /_cluster/settings update would shift the runtime cap while
            // ShardFragmentStageExecution reports shard failures as RuntimeException("Stage N failed", cause),
                    }
    private final MppStrategyMetrics mppStrategyMetrics;
                }
        } catch (Exception e) {
        );
        // Broadcast→shuffle retry: on the FIRST attempt, intercept a terminal failure whose cause
import org.opensearch.analytics.QueryRequestContext;
    private static List<FieldVector> orderedColumns(VectorSchemaRoot batch, List<String> targetColumnOrder) {
            sendClearShuffle(queryId, node, request, 1);
import org.opensearch.analytics.planner.dag.PlanAlternativeSelector;
            return;
            );
        }
import org.opensearch.search.SearchService;
            try {
            try {
        ThreadPool threadPool,
            Iterable<Object[]> rows = batchesToRows(batches, outputColumnOrder);
/*
import org.opensearch.transport.TransportResponseHandler;
                        return ThreadPool.Names.SAME;
import static org.opensearch.action.search.TransportSearchAction.SEARCH_CANCEL_AFTER_TIME_INTERVAL_SETTING;
        ActionListener<AnalyticsQueryResponse> convertingListener = ActionListener.wrap(listener::onResponse, e -> {
     */
        ToLongFunction<String> tableRowCounts = IndexRowCountFetcher.fetchFor(logicalFragment, client);
    }
            AnalyticsQueryAction.INSTANCE,
        // The non-explain path drops the profile from the response after recording it; the
import org.opensearch.analytics.planner.dag.BackendPlanAdapter;
    private void broadcastClearShuffle(String queryId) {
        // NOT submit the retry. This keeps the outer listener un-fired on the overflow path.
            )
     */
import java.util.function.ToLongFunction;
            MppStrategy routedStrategy = dagHasDistributedJoin ? MppStrategy.HASH_SHUFFLE_AGG : MppStrategy.COORDINATOR_CENTRIC;
    }
                    overflow.limitBytes()
                clusterTimeout,
                new TransportResponseHandler<AnalyticsClearShuffleResponse>() {
    }
     * plan stringification. The full {@link QueryProfile} is only built when
        return dag != null && stageHasHashExchange(dag.rootStage());
        // executor so the calling thread — which may be a transport thread — is freed
        // coord-centric (gather both sides) — without real counts every scan is Calcite's
            logger.debug(
        // Broadcast→shuffle retry, in two halves so it is both ORDERING-safe and EXCEPTION-safe:
        BackendPlanAdapter.adaptAll(dag, capabilityRegistry);
        // listener (see below), which runs strictly AFTER attempt-1's QueryContext/allocator
import org.opensearch.cluster.service.ClusterService;
        return ExceptionsHelper.<OpenSearchException>unwrapCausesAndSuppressed(
        // made ineligible. The broadcastDisabled flag bounds it to a single retry. Mirrors
            // BEFORE execRef.set runs. Either way, if execRef (or its graph) is null, fall back to a
            // query (the vast majority) needn't pay O(data-nodes) cleanup RPCs. The gate
        final AnalyticsSearchSlowLog.QuerySlowLogListener queryListener = analyticsSearchSlowLog.createQueryListener(querySource);
            logger.warn(
import org.apache.calcite.rel.RelNode;
                    }
                    rows.add(row);
    public void executeWithProfile(RelNode logicalFragment, QueryRequestContext queryCtx, ActionListener<ProfiledResult> listener) {
            }
                AnalyticsSettings.MPP_DISTRIBUTE_MIN_ROWS.get(perQuerySettings),
        ActionListener<ProfiledResult> listener
 *
        // disconnect / explicit task cancel propagate into the running query.
            threadPool.schedule(
    ) {
            return;
     *   hash-shuffle / coordinator-centric. The
        //
            .put(clusterService.getSettings())
        // Close the *original* QueryContext on every terminal — success or failure. For coord-
                TimeValue.timeValueMillis(delayMs),
     * ({@code FINAL(ER(PARTIAL(...)))}). Delegates to {@link UnifiedDispatch}, which captures any broadcast
        final boolean dagHasDistributedJoin = GeneralShuffleDAGRewriter.hasDistributedJoin(dag);
        // side allocations are released deterministically before arrow-base tears down the
        ContextAwareExecutor.wrap(searchExecutor, threadPool).execute(() -> {
    /**
                            );
                    attempt
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                    "[query-{}] shuffle cleanup to {} failed after {} attempts while the node is still in the cluster; "
                    for (int c = 0; c < colCount; c++) {
            );
        long planningTimeMs,
 * <p>Front-end plugins resolve this class from the Node's Guice injector and invoke
                            convertingListener.onResponse(
        this.statsCollector = statsCollector;
        }
        // Route through the framework action (profile=true) just like execute(), so a profiling
        this.clusterService = clusterService;
 * @opensearch.internal
            }
            batchesListener.onFailure(new RuntimeException("dispatch failed", t));
     * the row materialization happens here, once, at the API edge.
                                result.failure() instanceof Exception ex ? ex : new RuntimeException(result.failure())
        );
        // Reuse the snapshot captured at REST entry when present; this is the same ClusterState
    public void execute(RelNode logicalFragment, QueryRequestContext queryCtx, ActionListener<Iterable<Object[]>> listener) {
    private void applyParentTask(AnalyticsQueryRequest request, QueryRequestContext queryCtx) {
        // chain holds a BroadcastSizeExceededException (the build overflowed the runtime cap — a
        this.importStagingAllocator = coordinatorAllocatorHandle.getImportStagingAllocator();
import java.util.ArrayList;
            );
        // MPP-GENERAL-SCHEDULING-DESIGN.md.
        AnalyticsQueryRequest request = new AnalyticsQueryRequest(logicalFragment, queryCtx, indices);
        // stage that is both a broadcast consumer AND a shuffle producer (q3/q8/q9) runs without conflict.
        QueryRequestContext queryCtx,
        // explain path returns it inline.
        final Settings perQuerySettings = Settings.builder()
        MppStrategyMetrics mppStrategyMetrics,
    private final BufferAllocator importStagingAllocator;
                clusterService.getClusterSettings().get(AnalyticsSettings.MPP_DISTRIBUTE_MIN_ROWS)
        // broadcast instruction on its consumer stage, then dispatches the broadcast-free DAG (shuffle
            listener = ActionListener.wrap(result -> {
        if (!clusterService.state().nodes().nodeExists(node)) {
            // distributed path, so a static node-bootstrap read would pin the 1M default and never distribute.
                    ActionListener.wrap(result -> {
        List<Object[]> rows = new ArrayList<>();
            // distribute-vs-coord on it; the cluster ITs lower it (small datasets) to exercise the
                AnalyticsQueryTask queryTask = (AnalyticsQueryTask) task;
            throw e;
                new ParameterizedMessage(
    }
            Exception converted = e instanceof Exception ex ? contextProvider.convertException(ex) : new RuntimeException(e);
        /*
                    public void handleException(TransportException exp) {
    static Iterable<Object[]> batchesToRows(Iterable<VectorSchemaRoot> batches) {
        // HandledTransportAction before doExecute, unregistered when the listener completes).
        this.mppStrategyMetrics = mppStrategyMetrics;
    private final ClusterService clusterService;
        final boolean isQueryScheduler = scheduler instanceof QueryScheduler;
        }, e -> {
 *
    }
        return false;
        // Planner settings (oversampling factor + delegation block-list); self-registers update
        AnalyticsStatsCollector statsCollector,
                batchesListener,
            tableRowCounts
    private final EngineContextProvider contextProvider;
        // analytics-* settings on top of the node-startup settings. Without this overlay, dynamic
    private final ShuffleBufferManager shuffleBufferManager;
                    request.getPlan(),
        // query runs under the framework-provided, cancellable task rather than detached on
            perQuerySettings,
import org.apache.logging.log4j.message.ParameterizedMessage;
    private final AnalyticsStatsCollector statsCollector;
                    }
        TimeValue taskTimeout = queryTask.getCancelAfterTimeInterval();
import org.apache.arrow.vector.FieldVector;
                }
import org.opensearch.analytics.planner.PlannerContext;
                broadcastClearShuffle(dag.queryId());
        this.threadPool = threadPool;
        return preFilterShardSize;
                perQuerySettings,
    /**
import org.opensearch.analytics.exec.shuffle.ShuffleBufferManager;
        final String querySource = queryCtx != null ? queryCtx.querySource() : null;
    /** Base backoff between cleanup retries; doubles each attempt, capped at {@link #CLEAR_SHUFFLE_MAX_BACKOFF_MS}. */
        final long planningTimeNanos = System.nanoTime() - planStartNanos;
import org.opensearch.analytics.exec.profile.QueryProfile;
                queryAllocator,
        for (Stage child : stage.getChildStages()) {
    private final Scheduler scheduler;
import org.opensearch.analytics.planner.dag.PlanForker;
        // dsl-query-executor) threads an EngineContextProvider.getContext() snapshot through.
            // TODO(prune-columns-setting): now INERT. Upstream #22301 replaced our gated
        }
        ActionListener<ProfiledResult> outerListener,
    }
                AnalyticsSettings.MPP_SHUFFLE_PARTITIONS.getKey(),
import org.apache.logging.log4j.LogManager;
            ExecutionGraph graph = exec != null ? exec.getGraph() : null;
        }
    }
                // execRef read by profile listener after execution completes
import org.opensearch.analytics.EngineContextProvider;
        String fullPlan,
            // Join reordering is read live by PlannerImpl.reorderJoins via PlannerContext settings; overlay
 * this file be licensed under the Apache-2.0 license or a
    private void executeInternal(
        logger.debug("[DefaultPlanExecutor] QueryDAG:\n{}", dag);
                ContextAwareExecutor.wrap(searchExecutor, threadPool).execute(() -> {
    // Owned and closed by AnalyticsPlugin via the injected CoordinatorAllocatorHandle so that
import org.opensearch.analytics.exec.action.AnalyticsQueryAction;
        return batchesToRows(batches, null);
            try {
        plannerContext.setBroadcastEligible(!broadcastDisabled);
     *  queryId), so we retry across a generous window (≈26s with the cap below) to ride out transient
        try {
        // the owning allocator — this runAfter is the only path that does. Without it, every
    public int maxConcurrentShardRequestsPerNode() {
        // default 100 rows and broadcast loses the cost race against SINGLETON gather even
        RelNode logicalFragment,
 * Coordinator-level plan executor. Registered as a {@link HandledTransportAction}
                        outerListener.onFailure(e);
    ) {
    /** Max attempts to deliver a shuffle-cleanup RPC to one node before giving up. A still-alive node
        try {
        );
        return maxConcurrentShardRequestsPerNode;
        // Fetch primary-shard doc counts for every index this query touches. The CBO cost
            return;
                );
import org.opensearch.analytics.planner.CapabilityRegistry;
        // Route synchronous setup failures (capture-sink construction, scheduler dispatch
                context.close();
            // Per-request allocation: a failure here means the QUERY pool is exhausted, not
        }
import org.opensearch.analytics.planner.dag.FragmentConversionDriver;
            batchesListener = TimeoutTaskCancellationUtility.wrapWithCancellationListener(
                );
                );
        // planner rules — they'd see the node-bootstrap default forever, defeating both the
import org.opensearch.transport.TransportService;
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.REG).build();
     */
            statsCollector,
        listener with an empty QueryExecution reference, and then populate it once constructed.
import org.opensearch.cluster.ClusterState;
                    new org.apache.logging.log4j.message.ParameterizedMessage("[analytics-engine] internal error [{}]", identifier),
import org.opensearch.analytics.planner.dag.GeneralShuffleDAGRewriter;
        // Collapse multi-backend stages to a single chosen alternative before conversion
        }
        QueryContext context,
                maxConcurrentShardRequestsPerNode,
import org.opensearch.analytics.exec.action.AnalyticsQueryResponse;
            indexNameExpressionResolver,
            } else if (dispatchGeneralShuffle) {
        List<FieldVector> ordered = new ArrayList<>(targetColumnOrder.size());
            ownsAllocator = false;
        // broadcast (even if a shuffle rides above it), HASH_SHUFFLE for a pure shuffle, else
        AnalyticsQueryTask queryTask,
        // at allocateBytes — no listener needed.
            ownsAllocator = true;
     *   estimates can under-count filter/semijoin selectivity, so a build CBO judged small enough can
        applyParentTask(request, queryCtx);
            // Overlay the broadcast byte cap too: OpenSearchBroadcastJoinSplitRule's pre-flight size
        );
            FieldVector vector = batch.getVector(name);
                    converted
        final AtomicReference<QueryExecution> execRef = new AtomicReference<>();
            statsCollector.recordExecution(graph, context.dag(), planningTimeMs);
     */
        // On the broadcast→shuffle retry, make BROADCAST ineligible so CBO falls back to
                ? (graph != null
        ActionListener<Iterable<VectorSchemaRoot>> terminal
            // also fire this terminal inline (on the calling thread, inside scheduler.execute)
                    + "falling back to single-pass execution.",
import java.util.concurrent.atomic.AtomicReference;
        TransportService transportService,
        // 2) The actual retry is submitted from a runAfter installed on the terminal batches
        final long planningTimeMs = TimeUnit.NANOSECONDS.toMillis(planningTimeNanos);
        this.plannerSettings = PlannerSettings.create(
        // 1) The wrapper below only DETECTS the overflow and stashes it in retryOverflow; it does
                ThreadPool.Names.SAME
        try {
                    request.getQueryCtx(),
                options,
        this.contextProvider = contextProvider;
     *  non-shuffle queries don't fan no-op cleanup RPCs to every data node. Over-approximates safely. */
            // the buried status-bearing exception directly so 429/503 reach the client instead of an opaque 500.
    private final IndexNameExpressionResolver indexNameExpressionResolver;
import org.apache.calcite.rel.RelDistribution;
    /**
        // distributes — a shuffle cascade, a preserved CBO broadcast, or a mixed broadcast-under-shuffle —
     */
     *   alternative (via {@code PlannerContext.setBroadcastEligible(false)}, which makes
                    : new QueryProfile(context.queryId(), List.of(), planningTimeMs, 0L, List.of()))
        }
                shufflePartitions,
        logicalFragment.getCluster().invalidateMetadataQuery();
        this.shuffleBufferManager = shuffleBufferManager;
            if (overflow != null) {
        // and for the stats collector (always). When profile=false the resulting profile is
        this.preferMetadataDriver = AnalyticsPlugin.PREFER_METADATA_DRIVER.get(clusterService.getSettings());
import org.opensearch.analytics.exec.action.AnalyticsClearShuffleResponse;
        );
    }
            )
                clusterService.getClusterSettings().get(AnalyticsSettings.MPP_SHUFFLE_PARTITIONS)
     * Walks the cause/suppressed chain for a typed {@link OpenSearchException} carrying a non-500 status
        // teardown completes — so attempt 2 never overlaps attempt 1's allocator under the
    /**
                profile
/**
            request,
    private volatile int maxConcurrentShardRequestsPerNode;
        // wiring) through batchesListener so the per-query allocator is closed and the
                        }
}
     *  (join shuffle, cascade, or shuffle-aggregate). Used to gate the terminal cleanup broadcast so
    private static ActionListener<Iterable<Object[]>> buildProfilingRowsListener(
                        + "it may hold this query's shuffle buffers until it restarts (no later query terminal clears this queryId)",
                    "Column [" + name + "] expected by plan row type not found in batch schema: " + batch.getSchema().getFields()
        // ─── Execution + materialization ──────────────────────────────────
import org.opensearch.action.support.ActionFilters;
     * it already carries every shuffle/broadcast exchange and a pre-split aggregate
                    : "task_id=" + task.getId() + ", query_id=" + queryId;
        this.analyticsSearchSlowLog = analyticsSearchSlowLog;
                AnalyticsSettings.MPP_SHUFFLE_AGGREGATE_ENABLED.getKey(),
        final ActionListener<ProfiledResult> listener;
        TimeValue clusterTimeout = clusterService.getClusterSettings().get(SEARCH_CANCEL_AFTER_TIME_INTERVAL_SETTING);
                }
                capabilityRegistry,
                        // delivered — buffers (if any) released on the node
                threadPool,
            // gate reads it from PlannerContext settings, and it must agree with the runtime cap
    private void dispatchGeneralShuffle(
        IndexNameExpressionResolver indexNameExpressionResolver,
            );
                listener.onFailure(statusBearing);
        // retryOverflow is non-null only on the first attempt's overflow; broadcastDisabled bounds
                String identifier = "unassigned".equals(queryId)
            // Node-scoped and unbounded: coordinator-reduce batches are imported onto it and the Flight
                clusterService.getClusterSettings().get(AnalyticsSettings.BROADCAST_MAX_BYTES)
            // Release shuffle buffers on query terminal (success / failure / cancel). This runAfter
                    ? QueryProfileBuilder.snapshot(graph, context, fullPlan, planningTimeMs)
            false,
        // UnifiedDispatch discovers any BROADCAST_BUILD stages itself, captures them, injects each as a
        // Fork the entire query lifecycle (planning, scheduling, cleanup) onto the SEARCH
        if (attempt >= CLEAR_SHUFFLE_MAX_ATTEMPTS) {
        if (stage.getExchangeInfo() != null && stage.getExchangeInfo().distributionType() == RelDistribution.Type.HASH_DISTRIBUTED) {
                    : (BroadcastSizeExceededException) ExceptionsHelper.unwrap(result.failure(), BroadcastSizeExceededException.class);
     * undelivered release permanently shrinks that node's per-node shuffle budget (the buffer is
        // Exponential backoff capped at the ceiling; guard the shift against overflow at high attempts.
                    node.getId(),
            // transport keeps charging it after the importing stream closes, so it must not be per-query.
        QueryDAG dag,
        AnalyticsSearchSlowLog analyticsSearchSlowLog,
            if (vector == null) {
        // The task is the framework-provided task from doExecute (registered by
            profile,
        // Presto-on-Spark's DISABLE_BROADCAST_JOIN retry.
            if (statusBearing != null) {
     * external query API. The scheduler yields batches (the native wire format);
import org.opensearch.core.rest.RestStatus;
        if (queryId == null) {
        AnalyticsClearShuffleRequest request = new AnalyticsClearShuffleRequest(queryId);
        // AnalyticsQueryTask is unregistered. Without this guard, a synchronous throw would
    /**
        // from the RelNode's TableScan nodes.
        }
                preFilterShardSize,
        QueryScheduler qscheduler = (QueryScheduler) scheduler;
                } else {
            // cancellation-listener cleanup — without this, a failed shuffle query leaks its buffered
        NodeClient client,
    @Override
        client.execute(
            // on the first attempt's overflow; the retry runs with broadcastDisabled=true (no re-retry).
        ).map(t -> (Exception) t).orElse(null);
package org.opensearch.analytics.exec;
        }
        super(AnalyticsQueryAction.NAME, transportService, actionFilters, AnalyticsQueryRequest::new);
        int shift = Math.min(attempt - 1, 32);
        // a later conversion fails.
     * tiers and dispatches — one path for any join depth / shape / type, with no per-shape recognition.
    private volatile boolean preferMetadataDriver;
        ClusterState planningState = queryCtx != null ? queryCtx.clusterState() : clusterService.state();
import org.opensearch.common.unit.TimeValue;
                routedStrategy = MppStrategy.COORDINATOR_CENTRIC;
            .build();
import org.opensearch.analytics.exec.action.AnalyticsClearShuffleRequest;
            .put(
        // by the OpenSearchDistribution.satisfies() algebra — the cascade, agg-over-join, outer-join,
            } finally {
import org.opensearch.analytics.exec.action.AnalyticsQueryRequest;
        );
    private void retryClearShuffle(String queryId, DiscoveryNode node, AnalyticsClearShuffleRequest request, int attempt, Exception cause) {
    private final TransportService transportService;
                cause
import org.opensearch.action.support.TimeoutTaskCancellationUtility;
            // value any more. Kept in the overlay (and registered) so a cluster that already set it keeps
     * Registers the analytics query task as a child of the front-end task so a front-end cancel
        // takes effect without a restart; UnifiedDispatch hands it to ShuffleEnrichment, which sets
        // so the convertor runs once per stage and the wire request carries one PlanAlternative.
                        row[c] = ArrowValues.toJavaValue(ordered.get(c), r);
            );
 * so that Guice injects all dependencies ({@link TransportService},
import java.util.concurrent.Executor;
    /**
    /** Visible for testing: the live per-node concurrent-shard-request limit (reflects dynamic updates). */
    // shutdown closes this child of POOL_QUERY before arrow-base closes the root allocator.
                if (overflow != null) {
            } else {
    }
                            );
    private void executeInternal(
        return ActionListener.wrap(rows -> {
                int colCount = ordered.size();
    private final AnalyticsSearchSlowLog analyticsSearchSlowLog;
            QueryExecution exec = execRef.get();
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
        final List<String> outputColumnOrder = logicalFragment.getRowType().getFieldNames();
        // fresh THREAD_PROVIDERS) and guarded by try/catch so a synchronous planning/conversion
        clusterService.getClusterSettings()
         */
        // Record the dispatched strategy for /_analytics/_strategies. The general path distributes via
                clusterService.getClusterSettings().get(AnalyticsSettings.MPP_SHUFFLE_PRUNE_COLUMNS)
        // common non-shuffle query so we don't fan O(data-nodes) no-op RPCs on every analytics query.
        // No taskManager.unregister here: the framework (HandledTransportAction) unregisters the
            ActionListener.wrap(resp -> listener.onResponse(resp.getProfiledResult()), listener::onFailure)
            }
        } else if (MppStrategy.containsFinalAggregate(dag)) {
            listener.onResponse(new ProfiledResult(rows, null, qp));
        RelNode logicalFragment,
            listener
        }
        // OpenSearchSchemaBuilder used to build the SchemaPlus, so planner and schema agree.
            );
        Profile and explain are captured within the QueryExecution, however QueryExecution requires the complete
import org.apache.arrow.memory.BufferAllocator;
    static Iterable<Object[]> batchesToRows(Iterable<VectorSchemaRoot> batches, List<String> targetColumnOrder) {
import org.opensearch.common.settings.Settings;
     * Broadcasts a shuffle-buffer release for {@code queryId} to every data node, on query terminal
        if (AnalyticsSettings.MPP_ENABLED.get(perQuerySettings)) {
        Map<String, DiscoveryNode> dataNodes;
     * (disconnect / timeout / {@code _tasks/_cancel}) cascades into the query and its fragments.
import java.util.Map;
                    public String executor() {
        clusterService.getClusterSettings()
            ordered.add(vector);
        // COORDINATOR_CENTRIC. Recorded BEFORE the plan-side pipeline so the decision is observable even if
                listener.onFailure(converted);
     * wraps rows into a ProfiledResult with null profile for uniform listener handling.
            statsCollector.recordExecution(graph, context.dag(), planningTimeMs);
        boolean profile,
            .put(
     *
                    outerListener.onResponse(result);
     *  transport blips before accepting the rare leak. */
                cause
                    Object[] row = new Object[colCount];
            } else if (converted == e && isInternalError(converted)) {
                    new IllegalStateException("Analytics-engine executor rejected the plan: " + e.getMessage(), e)
                int rowCount = batch.getRowCount();
            // PlannerImpl.trimUnusedFields with its own unconditional trimFields, so nothing reads this
            );
            if (ownsAllocator) queryAllocator.close();
                            // here as a true onFailure so the caller doesn't see a null-rows response.
            // outerListener rather than being lost on a worker thread. retryOverflow is non-null only
        if (stage == null) {
            } catch (AssertionError e) {
     *  {@link org.opensearch.analytics.exec.shuffle.ShuffleBufferManager} buffers on data nodes
            planningTimeMs,
                    public void handleResponse(AnalyticsClearShuffleResponse response) {
        // Always time planning and capture the full plan: every query produces a QueryProfile
        AnalyticsStatsCollector statsCollector,
        clusterService.getClusterSettings()
    public DefaultPlanExecutor(
import org.opensearch.analytics.planner.dag.DAGBuilder;
        } catch (Exception e) {
import org.opensearch.transport.client.node.NodeClient;
        AnalyticsQueryTask queryTask,
        // consumers for live changes.
            return batch.getFieldVectors();
     * so re-sends are harmless and we don't track the exact participating set. A retry is abandoned
    ) {
        this.coordinatorAllocator = coordinatorAllocatorHandle.getAllocator();
        // A node no longer in the cluster has dropped its on-heap buffers with the process — nothing
     *   flag also guards against infinite retry (the second attempt never picks broadcast).
        });
        queryListener.setHeaders(queryTask.getHeader(Task.X_OPAQUE_ID), queryTask.getHeader(Task.X_REQUEST_ID));
            // guarded so a synchronous planning/conversion throw in attempt 2 still reaches
import org.opensearch.analytics.exec.profile.QueryProfileBuilder;
        // General post-CBO distribution-enforcement pass (Option B — the only MPP scheduler). Volcano CBO
            )
                            convertingListener.onFailure(
        if (taskTimeout != null || SearchService.NO_TIMEOUT.equals(clusterTimeout) == false) {
            }
            queryListener.onQueryComplete(dag.queryId(), System.nanoTime() - queryStartNanos, totalRows);
    private static final int CLEAR_SHUFFLE_MAX_ATTEMPTS = 10;
     * builds (injecting each as an instruction on its consumer stage), then promotes the shuffle worker
            // OpenSearchRejectedExecutionException so the REST layer maps it to HTTP 429
import org.opensearch.tasks.Task;
        }
                    "[task-{}] broadcast build overflowed the runtime cap (observed={} bytes, limit={} bytes); "
        for (String name : targetColumnOrder) {
            QueryProfile qp = includeProfileInResponse
import org.opensearch.analytics.AnalyticsSettings;
 */
     *   after a broadcast build overflowed the runtime cap at execution time — pre-flight row
            )
        if (perQueryBufferLimit <= 0) {
import org.opensearch.analytics.exec.join.MppStrategy;
            // and the client sees a proper backpressure signal rather than a generic 500.
                request,
     * <p>If {@code queryCtx} is non-null, its {@link QueryRequestContext#clusterState()} is
        } catch (Exception e) {
            .put(
            listener = outerListener;
                        outerListener.onFailure(new RuntimeException("broadcast→shuffle retry failed", t));
        // ─── Build query context ──────────────────────────────────────────
     */
            // Agg-shaped query (FINAL aggregate present, no join): a distributed aggregate is pre-split by
            queryAllocator = coordinatorAllocator;
            BroadcastSizeExceededException overflow = retryOverflow.get();
        }, rowsListener::onFailure), () -> {
    }
    }
     * {@code includeProfileInResponse} is true (i.e. for the {@code _explain} response).
     * used for Calcite planning so the planner sees the same snapshot the front-end built
                    }
        // exchange (shuffle/broadcast) + pre-split any distributed aggregate; DAGBuilder cut at those and
    protected void doExecute(Task task, AnalyticsQueryRequest request, ActionListener<AnalyticsQueryResponse> listener) {
            } catch (Exception e) {
                () -> coordinatorAllocator.newChildAllocator("query-" + dag.queryId(), 0, perQueryBufferLimit)
        client.execute(
            }
            clusterService.getClusterSettings(),
public class DefaultPlanExecutor extends HandledTransportAction<AnalyticsQueryRequest, AnalyticsQueryResponse>
        // QueryExecution operates on the pass-2 derived (non-owning) context, so it never frees
                    ? null
        PlannerContext plannerContext = new PlannerContext(
    }
        ActionListener<Iterable<VectorSchemaRoot>> batchesListener = ActionListener.runAfter(ActionListener.wrap(batches -> {
            } catch (Exception e) {
                e -> {}
import org.opensearch.core.action.ActionListener;
        // promotion if it still distributes a join). Broadcast is an instruction, not a stage role, so a
        }
    @Override
            dag,
            }, outerListener::onFailure);
            clusterService.getSettings()
import org.opensearch.ExceptionsHelper;
                    ? "task_id=" + task.getId()
        this.capabilityRegistry = capabilityRegistry;
        executeInternal(queryTask, logicalFragment, queryCtx, profile, listener, /* broadcastDisabled */ false);
            );
            // The general-scheduler row floor must follow dynamic updates too — the enforce() call gates
 */
        }
    private static final long CLEAR_SHUFFLE_RETRY_BASE_MS = 200L;
        final boolean dispatchGeneralShuffle = isQueryScheduler && (dagHasDistributedJoin || dagHasBroadcast);
                        executeInternal(queryTask, logicalFragment, queryCtx, profile, outerListener, /* broadcastDisabled */ true);
                "[DefaultPlanExecutor] distributed plan-shape produced but scheduler is {}, not QueryScheduler; "
            // the enforcement pass into PARTIAL(worker)/FINAL(coord) and runs via the shuffle worker tier;
     * genuinely internal and the redaction path should run.
        // pre-flight under-estimate of filter/semijoin selectivity) and re-plan once with broadcast
        // Using it — rather than self-registering a detached task — is what lets a client
        // that bails before QueryExecution is even constructed leaks unconditionally).
    }
                });
            QueryProfile qp = includeProfileInResponse
import org.opensearch.analytics.stats.AnalyticsStatsCollector;
                queryTask,
        ShuffleBufferManager shuffleBufferManager
        // by capturing broadcasts (inject-as-instruction) then promoting shuffle worker tiers. A DAG the
        batchesListener to construct the ExecutionGraph. To get around this circular dependency we build a profiling
        applyParentTask(request, queryCtx);
        long delayMs = Math.min(CLEAR_SHUFFLE_MAX_BACKOFF_MS, CLEAR_SHUFFLE_RETRY_BASE_MS << shift);
     * never reclaimed), so a transient send failure is retried with bounded backoff rather than just
                "query-" + dag.queryId(),
     *  the cluster (no buffers to leak) or the cap is reached. */
            if (dispatchGeneralShuffle) {
            rowsListener.onResponse(rows);
                    : new QueryProfile(context.queryId(), List.of(), planningTimeMs, 0L, List.of()))
            fullPlan,
     * <p>Package-private for unit testing.
        try {
        // size floor kept fully coordinator-centric distributes nothing → UnifiedDispatch is a plain execute.
            .put(
            return false;
    private final BufferAllocator coordinatorAllocator;
        plannerContext.setPlannerSettings(plannerSettings);
    /** Sends one shuffle-cleanup RPC to {@code node}; on failure reschedules up to
        // recorded into the collector and dropped from the response.
                    ? QueryProfileBuilder.snapshot(graph, context, fullPlan, planningTimeMs)
                AnalyticsQuerySettings.MAX_CONCURRENT_SHARD_REQUESTS_PER_NODE,
        if (broadcastDisabled) {
        ClusterService clusterService,
    ) {
import org.apache.calcite.rel.metadata.RelMetadataQueryBase;
                logger.warn(new ParameterizedMessage("[query-{}] QueryContext.close() threw on teardown", dag.queryId()), e);
import org.opensearch.core.tasks.TaskId;
        new UnifiedDispatch(qscheduler, clusterService, capabilityRegistry, preferMetadataDriver, sortMergeJoinMinRows).run(
import org.opensearch.analytics.exec.action.AnalyticsClearShuffleAction;
                    } catch (Throwable t) {
import org.opensearch.analytics.exec.join.DistributionEnforcementPass;
     * real status reaches the client instead of being redacted to a generic 500; null when the failure is
            UnifiedDispatch.captureSinkFactory(context, dag, capabilityRegistry, clusterService),
                    }
    private final CapabilityRegistry capabilityRegistry;
        boolean broadcastDisabled
 * compatible open source license.
     * once the node leaves the cluster (its buffers died with the process) or the attempt cap is hit.
            capabilityRegistry,
                routedStrategy = MppStrategy.HASH_SHUFFLE;
        final boolean dagHasBroadcast = MppStrategy.findBroadcastBuild(dag) != null;
import org.opensearch.analytics.AnalyticsPlugin;
        // QueryContext.close() is idempotent so the duplicate is a no-op. For broadcast queries,
        // parquet.native.pool.query.max take effect immediately via Arrow's parent-cap check
                execRef.set(scheduler.execute(context, batchesListener));
        ActionFilters actionFilters,
            } else {
            .addSettingsUpdateConsumer(AnalyticsPlugin.PREFER_METADATA_DRIVER, v -> preferMetadataDriver = v);
        // tagged stages SHUFFLE_*/BROADCAST_BUILD. The single UnifiedDispatch path runs whatever the DAG
            .put(AnalyticsSettings.MPP_ENABLED.getKey(), clusterService.getClusterSettings().get(AnalyticsSettings.MPP_ENABLED))
            // A typed status (e.g. a 429 breaker) often arrives buried in a wrapper —
            listener.onResponse(new ProfiledResult(null, e, qp));
        return ordered;
    /** True if any stage in the DAG carries a HASH-distributed exchange — i.e. the plan can populate
import org.opensearch.cluster.node.DiscoveryNode;
import org.apache.calcite.rel.metadata.JaninoRelMetadataProvider;
        // would double-free a task we no longer own.
 * the listener is fired by the scheduler once the query completes (or fails). The transport
                );
        // Use the plugin-owned coordinator allocator (a child of POOL_QUERY). The plugin
        RelMetadataQueryBase.THREAD_PROVIDERS.set(JaninoRelMetadataProvider.of(logicalFragment.getCluster().getMetadataProvider()));
                        } else {
        // query stays coordinator-centric (CBO's cheap choice for small joins). See
            if (stageHasHashExchange(child)) {
            logger.debug(new ParameterizedMessage("[query-{}] could not schedule shuffle cleanup retry to {}", queryId, node.getId()), e);
import org.opensearch.common.inject.Inject;
        ActionListener<ProfiledResult> listener
                        return new AnalyticsClearShuffleResponse(in);
            mppStrategyMetrics.recordDispatch(routedStrategy);
        this.scheduler = scheduler;
                        retryClearShuffle(queryId, node, request, attempt, exp);
     */
            MppStrategy routedStrategy;
                convertingListener.onFailure(
            // record HASH_SHUFFLE_AGG when the DAG distributes, else COORDINATOR_CENTRIC.
            // over-approximates safely — it fires even if dispatch later falls back to coord-centric
    /** Reschedules a failed cleanup send if the node is still in the cluster and attempts remain. */
        final AtomicReference<BroadcastSizeExceededException> retryOverflow = new AtomicReference<>();
    private static boolean isInternalError(Exception e) {
                logger.warn(
        // broadcast and/or hash-shuffle worker tiers; record BROADCAST when the DAG preserved a CBO
        boolean profile,
        queryListener.onPlanningComplete(dag.queryId(), planningTimeNanos);
            retryClearShuffle(queryId, node, request, attempt, e);
                planningState,
            terminal
    private static boolean stageHasHashExchange(Stage stage) {
            request,
            ActionListener.wrap(resp -> listener.onResponse(resp.getRows()), listener::onFailure)
        for (VectorSchemaRoot batch : batches) {
                dispatchGeneralShuffle(dag, context, execRef, batchesListener);
                String queryId = queryTask.getQueryId();
import org.opensearch.transport.TransportException;
        return ExceptionsHelper.status(e) == RestStatus.INTERNAL_SERVER_ERROR;
 * The OpenSearch Contributors require contributions made to
import org.opensearch.analytics.exec.join.UnifiedDispatch;
     * Set here, not in {@code createTask}, because the parent {@link TaskId} needs the local node id.
    private volatile long perQueryBufferLimit;
 * SPDX-License-Identifier: Apache-2.0
            )
        final long queryStartNanos = System.nanoTime();
            plan = DistributionEnforcementPass.enforce(
                queryTask,
            clusterService.getSettings(),
            AnalyticsQueryAction.INSTANCE,
            transportService.sendRequest(
        long sortMergeJoinMinRows = clusterService.getClusterSettings().get(AnalyticsSettings.MPP_WORKER_SORT_MERGE_JOIN_MIN_ROWS);
        }
            .addSettingsUpdateConsumer(
                    } catch (Exception e) {
            );
                ? (graph != null
        // Dispatch resolution under the GENERAL post-CBO scheduler. The enforcement pass placed every
                plan,
        } catch (Exception e) {
        }
                : null;
                        if (result.isSuccess()) {
                client,
import org.opensearch.analytics.exec.profile.ProfiledResult;
import org.opensearch.transport.TransportRequestOptions;
     */
    private void sendClearShuffle(String queryId, DiscoveryNode node, AnalyticsClearShuffleRequest request, int attempt) {
        // that's fed into AnalyticsStatsCollector for the _plugins/_analytics/stats endpoint.
    private static final Logger logger = LogManager.getLogger(DefaultPlanExecutor.class);
            }
        // UnifiedDispatch then runs whatever it distributes. Below the size floor the pass is a no-op and the
            );
        // Whether the plan contains any HASH exchange — the physical signal that ShuffleBufferManager
            // execRef is populated by scheduler.execute (single-pass) or by the MPP dispatchers
            .addSettingsUpdateConsumer(AnalyticsPlugin.COORDINATOR_BUFFER_LIMIT, v -> perQueryBufferLimit = v);
            t -> t instanceof OpenSearchException ose && ose.status() != RestStatus.INTERNAL_SERVER_ERROR
    }
     *   still blow the cap; rather than fail, we re-plan without broadcast so CBO falls back to
                for (int r = 0; r < rowCount; r++) {
        for (DiscoveryNode node : dataNodes.values()) {
     *  {@link #CLEAR_SHUFFLE_MAX_ATTEMPTS} with exponential backoff, abandoning once the node has left
        // Read the worker sort-merge-join floor live (dynamic-aware) so a PUT /_cluster/settings update
            .put(
            int shufflePartitions = MppShufflePartitions.resolve(
                batch.close();
    /** Node-scoped Arrow import staging allocator, borrowed from the handle; never closed here. */
        AtomicReference<QueryExecution> execRef,
import org.opensearch.analytics.exec.join.MppShufflePartitions;
            execRef::set,
                convertingListener.onFailure(e);
        // gathers every join to COORDINATOR+SINGLETON (its cost gate knows only 3 fixed localities), so its
    /** Backoff ceiling (mirrors the sender retry cap) so late attempts don't grow unbounded. */
    private static final long CLEAR_SHUFFLE_MAX_BACKOFF_MS = 5_000L;
                    public AnalyticsClearShuffleResponse read(StreamInput in) throws IOException {
        this.searchExecutor = threadPool.executor(ThreadPool.Names.SEARCH);
        // escape to execute()'s outer catch which calls listener.onFailure directly — leaving
            .put(AnalyticsSettings.MPP_JOIN_REORDER.getKey(), clusterService.getClusterSettings().get(AnalyticsSettings.MPP_JOIN_REORDER))
                return true;
 * {@link #execute(RelNode, QueryRequestContext, ActionListener)} directly. Execution is asynchronous —
     */
            .addSettingsUpdateConsumer(AnalyticsQuerySettings.PRE_FILTER_SHARD_SIZE, v -> preFilterShardSize = v);
     * (success / failure / cancel). This is the cleanup the FAILURE path needs — a failed query does
            // byte[] on-heap until the next query OOMs. Gated on the plan actually containing a HASH
        this.transportService = transportService;
    /**
        if (targetColumnOrder == null || targetColumnOrder.isEmpty()) {
     *   {@code OpenSearchBroadcastJoinSplitRule.matches()} return false). Set on the automatic retry
                listener.onFailure(new RuntimeException("Internal error [" + identifier + "]"));
        }
import org.apache.arrow.vector.VectorSchemaRoot;
     * the schema from. Otherwise a fresh {@code clusterService.state()} is read.
        // operator kill switch and the IT framework's per-test setSetting calls.
            return;
import org.opensearch.analytics.planner.PlannerImpl;
        if (MppStrategy.containsJoin(dag)) {
                List<FieldVector> ordered = orderedColumns(batch, targetColumnOrder);
            logger.info(
                    overflow.observedBytes(),
                logger.error(
    private static boolean dagHasHashExchange(QueryDAG dag) {
            execRef,
                    retryOverflow.set(overflow); // retry submitted post-teardown by the runAfter below
        // the task registered and the allocator open.
                node,
        logger.debug("[query-{}] Arrow allocator created, limit={}B", dag.queryId(), perQueryBufferLimit);
        // prefer_hash_join=false on a worker join whose estimated build exceeds it.
            converted,
        } else {
                () -> sendClearShuffle(queryId, node, request, attempt + 1),
            // BroadcastCaptureSink enforces (DefaultPlanExecutor reads it live from cluster settings).
        // task it created for doExecute once this listener settles. Unregistering it ourselves
    }
        final boolean ownsAllocator;
        // implements IndicesRequest.Replaceable, exposing target indices extracted
        this.client = client;
                scheduler.getClass().getSimpleName()
     *
            // it so a dynamic PUT /_cluster/settings toggle is honored (else it pins the node-bootstrap default).
        // throw in attempt 2 still reaches outerListener instead of being lost on a worker.
        }
        clusterService.getClusterSettings()
                    queryId,
        // Dispatch through ActionModule so the SecurityFilter evaluates index-level
                : null;
        // Runs after SecurityFilter has authorized the request.
    @Override
 * path ({@code doExecute}) is reserved for future remote query invocation.
        this.perQueryBufferLimit = AnalyticsPlugin.COORDINATOR_BUFFER_LIMIT.get(clusterService.getSettings());
            // Submit the broadcast→shuffle retry ONLY after this attempt's context/allocator is
        CapabilityRegistry capabilityRegistry,
        );
        // permissions before any planning work begins. The AnalyticsQueryRequest
    /** Visible for testing: the live can-match pre-filter threshold (reflects dynamic updates). */
        // model needs them to discriminate broadcast (small build × N probes) from
                plannerContext.getDistributionTraitDef(),
        // broadcast query leaks its per-query Arrow allocator (and any failed/cancelled query
    private final PlannerSettings plannerSettings;
        // closes the underlying allocator on Plugin.close() via the handle, so coordinator-
                            // executeWithProfile delivers failures via onResponse with a populated
            .put(
    @Inject
                routedStrategy = MppStrategy.BROADCAST;
        PlanAlternativeSelector.selectAll(dag, capabilityRegistry, preferMetadataDriver);
        if (queryCtx == null || queryCtx.parentTask() == null) {
import java.io.IOException;
            Exception statusBearing = statusBearingCause(converted);
                    @Override
        // TODO: These should be honored as query params, but requires front-end changes to pass request options.
            planningState,
            context = new QueryContext(
        // shared pool. It is dispatched on the SEARCH executor (off the callback thread, with a
     * logged. Each node's {@code clearForQuery} is idempotent and a no-op when it holds no buffers,
                throw new IllegalStateException(
        // immediately. The listener is wrapped to convert backend-specific exceptions.
            QueryExecution successExec = execRef.get();
        Scheduler scheduler,
                new ParameterizedMessage("[query-{}] shuffle cleanup to {} abandoned — node left cluster", queryId, node.getId()),
            // so isInternalError (top-level only) would redact it to a generic 500 and drop the chain. Surface
        String[] indices = RelNodeUtils.extractIndices(logicalFragment);
    }
        CoordinatorAllocatorHandle coordinatorAllocatorHandle,
    static Exception statusBearingCause(Exception converted) {
                AnalyticsSettings.BROADCAST_MAX_BYTES.getKey(),
        QueryPlanExecutor<RelNode, Iterable<Object[]>> {
            }
        }
        final String fullPlan = profile ? RelOptUtil.toString(plan) : null;
        }
        QueryDAG dag = DAGBuilder.build(plan, capabilityRegistry, clusterService, indexNameExpressionResolver);
    /**
        request.setParentTask(new TaskId(clusterService.localNode().getId(), queryCtx.parentTask().getId()));
        // Build a per-query Settings snapshot that overlays the live cluster-state values for
            )
        // it to a single retry.
            ExecutionGraph graph = successExec != null ? successExec.getGraph() : null;
        QueryContext context,
     * not cancel data-node tasks, so the per-task cancellation-listener cleanup never fires; an
     * plan text and snapshots per-stage timing into the {@link ProfiledResult}; when false,
            // exchange: only hash-shuffle producers populate ShuffleBufferManager, so a non-shuffle
            context,
     *  whose cleanup never lands holds those buffers until it restarts (no later terminal clears THIS
            // closed above, so attempt 2 never overlaps attempt 1's per-query allocator. Dispatched
            mppStrategyMetrics.recordDispatch(routedStrategy);
        });
        // centric queries, QueryExecution.close() also calls config::close on the same context;
            if (planUsesShuffle) {
        QueryRequestContext queryCtx,
        } catch (Throwable t) {
        this.preFilterShardSize = AnalyticsQuerySettings.PRE_FILTER_SHARD_SIZE.get(clusterService.getSettings());
        }
        }
    private volatile int preFilterShardSize;
import org.opensearch.threadpool.ThreadPool;
            logger.warn(new ParameterizedMessage("[query-{}] could not resolve data nodes for shuffle cleanup", queryId), e);
        if (dataNodes == null || dataNodes.isEmpty()) {
                List.of(queryListener),
                    request.isProfile(),
        // Feature-branch (MPP) additions — appended last so upstream constructor extensions don't collide.
                AnalyticsSettings.MPP_BROADCAST_PROBE_ESTIMATE.getKey(),
        // root allocator. Long.MAX_VALUE on the child means dynamic resizes of
    }
        // Build the profile on every terminal — both for the _explain payload (when profile=true)
            // inner scheduler.execute result through a Consumer back to execRef. A fast query can
import org.opensearch.analytics.spi.BroadcastSizeExceededException;
        });
        // for tiny dimensions. See IndexRowCountFetcher's class javadoc for the full story.
     * stats collector via {@link AnalyticsStatsCollector#recordExecution} — no allocation, no
import org.opensearch.core.common.io.stream.StreamInput;
     * Builds a rows listener that, on every terminal, feeds the {@link ExecutionGraph} into the
            }
                clusterService.getClusterSettings().get(AnalyticsSettings.MPP_SHUFFLE_AGGREGATE_ENABLED)
            preferMetadataDriver,
import org.opensearch.analytics.exec.join.MppStrategyMetrics;
        // output is the degenerate "gather everything" plan. This pass walks that plan and places exchanges
