        // 2) The actual retry is submitted from a runAfter installed on the terminal batches
        PlannerContext plannerContext = new PlannerContext(
        // Use the plugin-owned coordinator allocator (a child of POOL_QUERY). The plugin
        ContextAwareExecutor.wrap(searchExecutor, threadPool).execute(() -> {
        RelNode logicalFragment,
    /**
        } catch (Exception e) {
            // OpenSearchRejectedExecutionException so the REST layer maps it to HTTP 429
    private volatile int maxConcurrentShardRequestsPerNode;
        // Dispatch through ActionModule so the SecurityFilter evaluates index-level
        // model needs them to discriminate broadcast (small build × N probes) from
            )
        long planningTimeMs,  
     * Materializes Arrow batches into row-oriented {@code Object[]}s for the
import org.opensearch.core.rest.RestStatus;
import org.apache.calcite.plan.RelOptUtil;
    }
    private final EngineContextProvider contextProvider;
     *  whose cleanup never lands holds those buffers until it restarts (no later terminal clears THIS
        );  
        client.execute(
        final String fullPlan = profile ? RelOptUtil.toString(plan) : null;
     *  non-shuffle queries don't fan no-op cleanup RPCs to every data node. Over-approximates safely. */
     */
     *   hash-shuffle / coordinator-centric. The
                execRef.set(scheduler.execute(context, batchesListener));  
            return batch.getFieldVectors();
    }
        }
        new UnifiedDispatch(qscheduler, clusterService, capabilityRegistry, preferMetadataDriver, sortMergeJoinMinRows).run(
                context.close();  
        this.plannerSettings = PlannerSettings.create(
                new TransportResponseHandler<AnalyticsClearShuffleResponse>() {  
            return;
        // made ineligible. The broadcastDisabled flag bounds it to a single retry. Mirrors
        boolean profile,  
    /** Node-scoped Arrow import staging allocator, borrowed from the handle; never closed here. */
                }  
import org.opensearch.analytics.exec.profile.QueryProfile;  
    /**  
        // TODO: These should be honored as query params, but requires front-end changes to pass request options.
            // BroadcastCaptureSink enforces (DefaultPlanExecutor reads it live from cluster settings).
        }  
            );  
            if (ownsAllocator) queryAllocator.close();
        // TODO: remove the null fallback once every front-end (test-ppl-frontend,
import org.opensearch.analytics.planner.dag.GeneralShuffleDAGRewriter;
            plan = DistributionEnforcementPass.enforce(  
    /**  
                int rowCount = batch.getRowCount();
            terminal  
        if (MppStrategy.containsJoin(dag)) {
        // task it created for doExecute once this listener settles. Unregistering it ourselves  
    private final TransportService transportService;
                    new IllegalStateException("Analytics-engine executor rejected the plan: " + e.getMessage(), e)
        // hash-shuffle / coordinator-centric (the build overflowed the runtime cap on attempt 1).  
                perQuerySettings,
     * Broadcasts a shuffle-buffer release for {@code queryId} to every data node, on query terminal
                            );
import org.opensearch.ExceptionsHelper;  
        CapabilityRegistry capabilityRegistry,
            listener = outerListener;  
        // output is the degenerate "gather everything" plan. This pass walks that plan and places exchanges
                new ParameterizedMessage("[query-{}] shuffle cleanup to {} abandoned — node left cluster", queryId, node.getId()),  
    private volatile boolean preferMetadataDriver;  
import org.opensearch.cluster.node.DiscoveryNode;  
            batchesListener = TimeoutTaskCancellationUtility.wrapWithCancellationListener(
    }  
                batch.close();
        // listener (see below), which runs strictly AFTER attempt-1's QueryContext/allocator
        this.mppStrategyMetrics = mppStrategyMetrics;
                profile
        // from the RelNode's TableScan nodes.
import org.opensearch.OpenSearchException;
    }  
        ToLongFunction<String> tableRowCounts = IndexRowCountFetcher.fetchFor(logicalFragment, client);  
import org.opensearch.analytics.AnalyticsPlugin;
                v -> maxConcurrentShardRequestsPerNode = v  
        return preFilterShardSize;
        }
                planningState,
                        // delivered — buffers (if any) released on the node
        return ExceptionsHelper.<OpenSearchException>unwrapCausesAndSuppressed(  
     * <p>Package-private for unit testing.
                clusterTimeout,
    ) {
            perQuerySettings,
                    node.getId(),
            AnalyticsQueryAction.INSTANCE,  
        logger.debug("[query-{}] Arrow allocator created, limit={}B", dag.queryId(), perQueryBufferLimit);  
                    new org.apache.logging.log4j.message.ParameterizedMessage("[analytics-engine] internal error [{}]", identifier),  
            if (statusBearing != null) {  
        AtomicReference<QueryExecution> execRef,  
                    Object[] row = new Object[colCount];
            .put(
import org.apache.arrow.memory.BufferAllocator;
        try {
     */  
        logicalFragment.getCluster().invalidateMetadataQuery();
        clusterService.getClusterSettings()  
import java.util.function.ToLongFunction;
                maxConcurrentShardRequestsPerNode,  
        long delayMs = Math.min(CLEAR_SHUFFLE_MAX_BACKOFF_MS, CLEAR_SHUFFLE_RETRY_BASE_MS << shift);
            ExecutionGraph graph = successExec != null ? successExec.getGraph() : null;
        // the owning allocator — this runAfter is the only path that does. Without it, every
        // Broadcast→shuffle retry, in two halves so it is both ORDERING-safe and EXCEPTION-safe:
                    ? QueryProfileBuilder.snapshot(graph, context, fullPlan, planningTimeMs)  
            queryAllocator = coordinatorAllocator;
        final boolean ownsAllocator;  
    private final AnalyticsSearchSlowLog analyticsSearchSlowLog;  
    }
import org.opensearch.cluster.ClusterState;
        this.scheduler = scheduler;  
            .put(AnalyticsSettings.MPP_ENABLED.getKey(), clusterService.getClusterSettings().get(AnalyticsSettings.MPP_ENABLED))  
import org.opensearch.analytics.exec.action.AnalyticsQueryAction;  
import org.opensearch.action.support.HandledTransportAction;  
        }, e -> {
        ClusterState planningState = queryCtx != null ? queryCtx.clusterState() : clusterService.state();  
            logger.debug(
 *
import org.opensearch.analytics.planner.dag.Stage;  
 * this file be licensed under the Apache-2.0 license or a
     *   estimates can under-count filter/semijoin selectivity, so a build CBO judged small enough can  
     * never reclaimed), so a transient send failure is retried with bounded backoff rather than just  
    private void sendClearShuffle(String queryId, DiscoveryNode node, AnalyticsClearShuffleRequest request, int attempt) {
        ThreadPool threadPool,
        // coord-centric (gather both sides) — without real counts every scan is Calcite's  
                    rows.add(row);
    }
        try {  
            }
        final long queryStartNanos = System.nanoTime();
                    retryOverflow.set(overflow); // retry submitted post-teardown by the runAfter below
            );  
                );
        applyParentTask(request, queryCtx);
     * Runs the GENERAL post-CBO scheduler path. The DAG was produced by {@link DistributionEnforcementPass}:
            mppStrategyMetrics.recordDispatch(routedStrategy);
        final AtomicReference<QueryExecution> execRef = new AtomicReference<>();  
        List<FieldVector> ordered = new ArrayList<>(targetColumnOrder.size());  
 * {@link #execute(RelNode, QueryRequestContext, ActionListener)} directly. Execution is asynchronous —
                    "[query-{}] shuffle cleanup to {} failed after {} attempts while the node is still in the cluster; "
    /** Base backoff between cleanup retries; doubles each attempt, capped at {@link #CLEAR_SHUFFLE_MAX_BACKOFF_MS}. */
            threadPool.schedule(
        final boolean planUsesShuffle = dagHasHashExchange(dag);  
        } else if (MppStrategy.containsFinalAggregate(dag)) {
     * so re-sends are harmless and we don't track the exact participating set. A retry is abandoned
                listener.onFailure(new RuntimeException("Internal error [" + identifier + "]"));  
     * not cancel data-node tasks, so the per-task cancellation-listener cleanup never fires; an
            .put(  
            mppStrategyMetrics.recordDispatch(routedStrategy);
import org.apache.calcite.rel.metadata.JaninoRelMetadataProvider;
import org.opensearch.analytics.planner.PlannerImpl;  
        TransportService transportService,
        TimeValue clusterTimeout = clusterService.getClusterSettings().get(SEARCH_CANCEL_AFTER_TIME_INTERVAL_SETTING);  
 * compatible open source license.
                preFilterShardSize,
        });
import org.opensearch.analytics.exec.profile.QueryProfileBuilder;
import org.opensearch.analytics.spi.BroadcastSizeExceededException;
                plan,
        // A node no longer in the cluster has dropped its on-heap buffers with the process — nothing
}  
                    public void handleException(TransportException exp) {
        client.execute(
            );
        // retryOverflow is non-null only on the first attempt's overflow; broadcastDisabled bounds
        // query stays coordinator-centric (CBO's cheap choice for small joins). See  
     */
        ActionListener<Iterable<Object[]>> rowsListener = buildProfilingRowsListener(
        }
            tableRowCounts
        this.coordinatorAllocator = coordinatorAllocatorHandle.getAllocator();
        // planner rules — they'd see the node-bootstrap default forever, defeating both the
                        }  
import org.opensearch.analytics.exec.action.AnalyticsQueryResponse;
        } catch (Exception e) {
        final AtomicReference<BroadcastSizeExceededException> retryOverflow = new AtomicReference<>();  
        clusterService.getClusterSettings()
import org.apache.logging.log4j.LogManager;  
        }
        // shared pool. It is dispatched on the SEARCH executor (off the callback thread, with a
        // distributes — a shuffle cascade, a preserved CBO broadcast, or a mixed broadcast-under-shuffle —
        );  
    private final Executor searchExecutor;  
        if (!clusterService.state().nodes().nodeExists(node)) {
        // query runs under the framework-provided, cancellable task rather than detached on  
            sendClearShuffle(queryId, node, request, 1);  
 */  
                    (AnalyticsQueryTask) task,
        Scheduler scheduler,
            // outerListener rather than being lost on a worker thread. retryOverflow is non-null only
        ActionListener<Iterable<VectorSchemaRoot>> batchesListener = ActionListener.runAfter(ActionListener.wrap(batches -> {
                queryTask,
        }
    /**
        this.analyticsSearchSlowLog = analyticsSearchSlowLog;
        MppStrategyMetrics mppStrategyMetrics,
     * wraps rows into a ProfiledResult with null profile for uniform listener handling.  
        // Whether the plan contains any HASH exchange — the physical signal that ShuffleBufferManager  
            // planning-only profile rather than NPE-ing — the failure path below uses the same
            .addSettingsUpdateConsumer(AnalyticsPlugin.PREFER_METADATA_DRIVER, v -> preferMetadataDriver = v);
import org.opensearch.common.unit.TimeValue;
     * the row materialization happens here, once, at the API edge.  
import org.opensearch.analytics.planner.RelNodeUtils;
            );
        // Planner settings (oversampling factor + delegation block-list); self-registers update
    @Inject
        // General post-CBO distribution-enforcement pass (Option B — the only MPP scheduler). Volcano CBO  
    }
                    : new QueryProfile(context.queryId(), List.of(), planningTimeMs, 0L, List.of()))
        if (attempt >= CLEAR_SHUFFLE_MAX_ATTEMPTS) {
     * external query API. The scheduler yields batches (the native wire format);
                    "[task-{}] broadcast build overflowed the runtime cap (observed={} bytes, limit={} bytes); "
            QueryExecution exec = execRef.get();
import org.opensearch.common.settings.Settings;  
                            convertingListener.onResponse(
     *   alternative (via {@code PlannerContext.setBroadcastEligible(false)}, which makes  
        CoordinatorAllocatorHandle coordinatorAllocatorHandle,  
                : null;
                executeInternal(
            clusterService.getSettings(),  
 * The OpenSearch Contributors require contributions made to  
            // Per-request allocation: a failure here means the QUERY pool is exhausted, not
                    converted
        // permissions before any planning work begins. The AnalyticsQueryRequest
     *  {@link #CLEAR_SHUFFLE_MAX_ATTEMPTS} with exponential backoff, abandoning once the node has left
package org.opensearch.analytics.exec;
        this.searchExecutor = threadPool.executor(ThreadPool.Names.SEARCH);  
                routedStrategy = MppStrategy.HASH_SHUFFLE;  
            execRef,  
    private volatile int preFilterShardSize;
            .addSettingsUpdateConsumer(AnalyticsQuerySettings.PRE_FILTER_SHARD_SIZE, v -> preFilterShardSize = v);
            dag,  
        // NOT submit the retry. This keeps the outer listener un-fired on the overflow path.  
import java.util.List;
        // searchExecutor. The SecurityFilter also evaluates index permissions on this path.
                ? (graph != null
        // to reclaim, so stop retrying.  
                    attempt  
import org.opensearch.analytics.exec.join.DistributionEnforcementPass;  
                shufflePartitions,  
        // it to a single retry.
            )
     *  queryId), so we retry across a generous window (≈26s with the cap below) to ride out transient
                "[DefaultPlanExecutor] distributed plan-shape produced but scheduler is {}, not QueryScheduler; "
                    : "task_id=" + task.getId() + ", query_id=" + queryId;
            .put(
            ActionListener.wrap(resp -> listener.onResponse(resp.getRows()), listener::onFailure)
            // fires unconditionally, so it covers the FAILURE path that does NOT cancel data-node  
            // Join reordering is read live by PlannerImpl.reorderJoins via PlannerContext settings; overlay
                List<FieldVector> ordered = orderedColumns(batch, targetColumnOrder);  
    public void execute(RelNode logicalFragment, QueryRequestContext queryCtx, ActionListener<Iterable<Object[]>> listener) {  
                scheduler.getClass().getSimpleName()  
        // Reuse the snapshot captured at REST entry when present; this is the same ClusterState
import org.opensearch.core.tasks.TaskId;
        final boolean dagHasBroadcast = MppStrategy.findBroadcastBuild(dag) != null;  
            return;
import static org.opensearch.action.search.TransportSearchAction.SEARCH_CANCEL_AFTER_TIME_INTERVAL_SETTING;  
                                request.isProfile() ? new AnalyticsQueryResponse(result) : new AnalyticsQueryResponse(result.rows())  
import org.apache.calcite.rel.RelDistribution;
        }  
    private volatile long perQueryBufferLimit;  
        PlanForker.forkAll(dag, capabilityRegistry);
        return rows;
        ClusterService clusterService,  
        );
        listener with an empty QueryExecution reference, and then populate it once constructed.
                            // ProfiledResult.failure so the profile is always recorded; surface it
     *
        QueryContext context,
                clusterService.getClusterSettings().get(AnalyticsSettings.MPP_BROADCAST_PROBE_ESTIMATE)  
            BroadcastSizeExceededException overflow = retryOverflow.get();
     */
                ((OpenSearchRelNode) plan).getViableBackends()
            t -> t instanceof OpenSearchException ose && ose.status() != RestStatus.INTERNAL_SERVER_ERROR
            // value any more. Kept in the overlay (and registered) so a cluster that already set it keeps
        // The task is the framework-provided task from doExecute (registered by  
    private void retryClearShuffle(String queryId, DiscoveryNode node, AnalyticsClearShuffleRequest request, int attempt, Exception cause) {
    }
                    + "falling back to single-pass execution.",
import org.apache.arrow.vector.FieldVector;
        this.perQueryBufferLimit = AnalyticsPlugin.COORDINATOR_BUFFER_LIMIT.get(clusterService.getSettings());
import org.opensearch.threadpool.ThreadPool;
            }
                                result.failure() instanceof Exception ex ? ex : new RuntimeException(result.failure())
                batchesListener,  
import org.opensearch.analytics.exec.action.AnalyticsQueryRequest;
     * the schema from. Otherwise a fresh {@code clusterService.state()} is read.
        final boolean dispatchGeneralShuffle = isQueryScheduler && (dagHasDistributedJoin || dagHasBroadcast);
                if (overflow != null) {  
 * {@link ClusterService}, {@link ThreadPool}, etc.) automatically.
            long totalRows = rows instanceof List ? ((List<?>) rows).size() : 0;
        // Using it — rather than self-registering a detached task — is what lets a client
     */
            // execRef is populated by scheduler.execute (single-pass) or by the MPP dispatchers  
        Map<String, DiscoveryNode> dataNodes;  
    /** Reschedules a failed cleanup send if the node is still in the cluster and attempts remain. */  
        RelNode plan = PlannerImpl.createPlan(logicalFragment, plannerContext);
            // so isInternalError (top-level only) would redact it to a generic 500 and drop the chain. Surface  
        }
        try {
        //  
        // prefer_hash_join=false on a worker join whose estimated build exceeds it.
        final long planningTimeMs = TimeUnit.NANOSECONDS.toMillis(planningTimeNanos);
                }
        super(AnalyticsQueryAction.NAME, transportService, actionFilters, AnalyticsQueryRequest::new);
        boolean profile,
/*  
                            convertingListener.onFailure(  
        // COORDINATOR_CENTRIC. Recorded BEFORE the plan-side pipeline so the decision is observable even if
        clusterService.getClusterSettings()  
        // AnalyticsQueryTask is unregistered. Without this guard, a synchronous throw would
import org.apache.calcite.rel.metadata.RelMetadataQueryBase;
        applyParentTask(request, queryCtx);
        // Close the *original* QueryContext on every terminal — success or failure. For coord-  
                convertingListener.onFailure(  
            // on the first attempt's overflow; the retry runs with broadcastDisabled=true (no re-retry).  
            statsCollector.recordExecution(graph, context.dag(), planningTimeMs);
                // execRef read by profile listener after execution completes
        // consumers for live changes.  
                    }
            // over-approximates safely — it fires even if dispatch later falls back to coord-centric  
        AnalyticsStatsCollector statsCollector,
            // inner scheduler.execute result through a Consumer back to execRef. A fast query can
        ShuffleBufferManager shuffleBufferManager  
        // implements IndicesRequest.Replaceable, exposing target indices extracted  
            Iterable<Object[]> rows = batchesToRows(batches, outputColumnOrder);  
     *  {@link org.opensearch.analytics.exec.shuffle.ShuffleBufferManager} buffers on data nodes
                threadPool,
            // Submit the broadcast→shuffle retry ONLY after this attempt's context/allocator is
        ).map(t -> (Exception) t).orElse(null);  
    private static final Logger logger = LogManager.getLogger(DefaultPlanExecutor.class);  
        // wiring) through batchesListener so the per-query allocator is closed and the  
            ExecutionGraph graph = exec != null ? exec.getGraph() : null;  
     * plan stringification. The full {@link QueryProfile} is only built when
            context,
        // so the convertor runs once per stage and the wire request carries one PlanAlternative.
                    queryTask.getId(),
        // pre-flight under-estimate of filter/semijoin selectivity) and re-plan once with broadcast  
        queryListener.onPlanningComplete(dag.queryId(), planningTimeNanos);
        final boolean isQueryScheduler = scheduler instanceof QueryScheduler;
            Exception converted = e instanceof Exception ex ? contextProvider.convertException(ex) : new RuntimeException(e);  
    public void executeWithProfile(RelNode logicalFragment, QueryRequestContext queryCtx, ActionListener<ProfiledResult> listener) {
        QueryContext context,  
            .addSettingsUpdateConsumer(
        return dag != null && stageHasHashExchange(dag.rootStage());  
    /** Backoff ceiling (mirrors the sender retry cap) so late attempts don't grow unbounded. */
            // (BROADCAST / HASH_SHUFFLE / HASH_SHUFFLE_AGG). The dispatcher path threads its
            indexNameExpressionResolver,
            MppStrategy routedStrategy = dagHasDistributedJoin ? MppStrategy.HASH_SHUFFLE_AGG : MppStrategy.COORDINATOR_CENTRIC;  
            if (vector == null) {  
import org.opensearch.common.inject.Inject;
        // Dispatch resolution under the GENERAL post-CBO scheduler. The enforcement pass placed every
                List.of(queryListener),
            fullPlan,
            // tasks (e.g. a shuffle byte-budget breach) and so never triggers the per-task
        // Create the slow log wrapper at the start so it observes the full query lifecycle.
            try {  
import org.opensearch.analytics.exec.join.MppStrategy;
        // Build the profile on every terminal — both for the _explain payload (when profile=true)
            if (dispatchGeneralShuffle && dagHasBroadcast) {  
            .build();
    }  
        // mixed-key, broadcast, and scalar-subquery shapes all emerge generically, with no per-shape code.
                routedStrategy = MppStrategy.COORDINATOR_CENTRIC;
        FragmentConversionDriver.convertAll(dag, capabilityRegistry);  
        ActionListener<ProfiledResult> listener
        }
    /**  
     * @param broadcastDisabled when true, the planner is told to suppress every BROADCAST join
        AnalyticsSearchSlowLog analyticsSearchSlowLog,
        // 1) The wrapper below only DETECTS the overflow and stashes it in retryOverflow; it does
            UnifiedDispatch.captureSinkFactory(context, dag, capabilityRegistry, clusterService),
import org.opensearch.analytics.exec.join.MppShufflePartitions;
        });  
     *   {@code OpenSearchBroadcastJoinSplitRule.matches()} return false). Set on the automatic retry
            // Without this, a dynamic PUT /_cluster/settings update would shift the runtime cap while
            listener = ActionListener.wrap(result -> {
        return ActionListener.wrap(rows -> {
            if (overflow != null) {
import org.opensearch.core.common.io.stream.StreamInput;  
            // the enforcement pass into PARTIAL(worker)/FINAL(coord) and runs via the shuffle worker tier;
     * Walks the cause/suppressed chain for a typed {@link OpenSearchException} carrying a non-500 status  
        }  
            request,
            // closed above, so attempt 2 never overlaps attempt 1's per-query allocator. Dispatched
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;  
            );
    }  
        AnalyticsClearShuffleRequest request = new AnalyticsClearShuffleRequest(queryId);
        // at allocateBytes — no listener needed.
        // a later conversion fails.  
                    } catch (Throwable t) {
        for (VectorSchemaRoot batch : batches) {
                });
        }  
                    public String executor() {
        // ─── Execution + materialization ──────────────────────────────────  
        this.threadPool = threadPool;
                TimeValue.timeValueMillis(delayMs),  
    static Iterable<Object[]> batchesToRows(Iterable<VectorSchemaRoot> batches) {
    implements  
                            // here as a true onFailure so the caller doesn't see a null-rows response.
                AnalyticsSettings.MPP_SHUFFLE_PRUNE_COLUMNS.getKey(),
    private void executeInternal(
                listener.onFailure(converted);
    public int preFilterShardSize() {
                clusterService.getClusterSettings().get(AnalyticsSettings.MPP_SHUFFLE_PRUNE_COLUMNS)
            } else {
                );
                int colCount = ordered.size();
        // stage that is both a broadcast consumer AND a shuffle producer (q3/q8/q9) runs without conflict.
            logger.debug(new ParameterizedMessage("[query-{}] could not schedule shuffle cleanup retry to {}", queryId, node.getId()), e);
    private final ShuffleBufferManager shuffleBufferManager;
        final BufferAllocator queryAllocator;
        EngineContextProvider contextProvider,  
        for (Stage child : stage.getChildStages()) {
            // Agg-shaped query (FINAL aggregate present, no join): a distributed aggregate is pre-split by  
            AnalyticsQueryAction.INSTANCE,  
            Exception statusBearing = statusBearingCause(converted);
                queryAllocator,  
    private static boolean stageHasHashExchange(Stage stage) {  
    private static List<FieldVector> orderedColumns(VectorSchemaRoot batch, List<String> targetColumnOrder) {
        plannerContext.setBroadcastEligible(!broadcastDisabled);
        int shift = Math.min(attempt - 1, 32);
            capabilityRegistry
        ActionListener<AnalyticsQueryResponse> convertingListener = ActionListener.wrap(listener::onResponse, e -> {
        // side allocations are released deterministically before arrow-base tears down the
        // tagged stages SHUFFLE_*/BROADCAST_BUILD. The single UnifiedDispatch path runs whatever the DAG
        return batchesToRows(batches, null);
            }  
                dag,  
        // promotion if it still distributes a join). Broadcast is an instruction, not a stage role, so a
            // byte[] on-heap until the next query OOMs. Gated on the plan actually containing a HASH  
                } else {
                    "Column [" + name + "] expected by plan row type not found in batch schema: " + batch.getSchema().getFields()
     * Registers the analytics query task as a child of the front-end task so a front-end cancel
        for (String name : targetColumnOrder) {
            context = new QueryContext(
                    public AnalyticsClearShuffleResponse read(StreamInput in) throws IOException {
            } else {
    private void applyParentTask(AnalyticsQueryRequest request, QueryRequestContext queryCtx) {
            } catch (Exception e) {
        });
import org.opensearch.analytics.QueryRequestContext;
        } catch (Exception e) {
        final boolean dagHasDistributedJoin = GeneralShuffleDAGRewriter.hasDistributedJoin(dag);
                        retryClearShuffle(queryId, node, request, attempt, exp);  
                        outerListener.onFailure(new RuntimeException("broadcast→shuffle retry failed", t));
        // Presto-on-Spark's DISABLE_BROADCAST_JOIN retry.
        }
                    @Override
        try {  
     */  
import org.opensearch.analytics.exec.action.AnalyticsClearShuffleResponse;
     * plan text and snapshots per-stage timing into the {@link ProfiledResult}; when false,
            );  
            ownsAllocator = true;
                ),
    @Override
                clusterService.getClusterSettings().get(AnalyticsSettings.MPP_SHUFFLE_PARTITIONS)
            transportService.sendRequest(
            dataNodes = clusterService.state().nodes().getDataNodes();
                AnalyticsQuerySettings.MAX_CONCURRENT_SHARD_REQUESTS_PER_NODE,
                queryTask,
        if (stage == null) {
            statsCollector.recordExecution(graph, context.dag(), planningTimeMs);  
        } else {
            // starting; remove the setting once we confirm no deployment depends on it.
        PlanAlternativeSelector.selectAll(dag, capabilityRegistry, preferMetadataDriver);
        // by the OpenSearchDistribution.satisfies() algebra — the cascade, agg-over-join, outer-join,  
            statsCollector,
        }
                        executeInternal(queryTask, logicalFragment, queryCtx, profile, outerListener, /* broadcastDisabled */ true);
    @Override
            return;
            if (stageHasHashExchange(child)) {
                logger.error(
            } else if (dispatchGeneralShuffle) {
            // exchange: only hash-shuffle producers populate ShuffleBufferManager, so a non-shuffle
     * tiers and dispatches — one path for any join depth / shape / type, with no per-shape recognition.
        if (taskTimeout != null || SearchService.NO_TIMEOUT.equals(clusterTimeout) == false) {
    private final ClusterService clusterService;  
            );
    ) {  
     *   after a broadcast build overflowed the runtime cap at execution time — pre-flight row
 * @opensearch.internal  
        RelMetadataQueryBase.THREAD_PROVIDERS.set(JaninoRelMetadataProvider.of(logicalFragment.getCluster().getMetadataProvider()));
    /** True if any stage in the DAG carries a HASH-distributed exchange — i.e. the plan can populate
            queryListener.onQueryComplete(dag.queryId(), System.nanoTime() - queryStartNanos, totalRows);
        }, rowsListener::onFailure), () -> {
        ActionFilters actionFilters,
                throw new IllegalStateException(
                logger.warn(new ParameterizedMessage("[query-{}] QueryContext.close() threw on teardown", dag.queryId()), e);
        // fresh THREAD_PROVIDERS) and guarded by try/catch so a synchronous planning/conversion
    private final BufferAllocator coordinatorAllocator;  
        String[] indices = RelNodeUtils.extractIndices(logicalFragment);
                    overflow.observedBytes(),
                BroadcastSizeExceededException overflow = result.isSuccess()  
        // buffers may be populated on data nodes. Drives the terminal cleanup broadcast: skip it for the
            preferMetadataDriver,  
            // the buried status-bearing exception directly so 429/503 reach the client instead of an opaque 500.
            queryAllocator = AllocationRejection.wrap(  
     * used for Calcite planning so the planner sees the same snapshot the front-end built  
    ) {  
                        return ThreadPool.Names.SAME;
    }
    ) {
import org.opensearch.action.support.TimeoutTaskCancellationUtility;
                        + "it may hold this query's shuffle buffers until it restarts (no later query terminal clears this queryId)",  
            context,
     * it already carries every shuffle/broadcast exchange and a pre-split aggregate
     * builds (injecting each as an instruction on its consumer stage), then promotes the shuffle worker
        }  
                    ? null
        } catch (Exception e) {  
        if (stage.getExchangeInfo() != null && stage.getExchangeInfo().distributionType() == RelDistribution.Type.HASH_DISTRIBUTED) {
            } else if (converted == e && isInternalError(converted)) {
 * so that Guice injects all dependencies ({@link TransportService},
                        row[c] = ArrowValues.toJavaValue(ordered.get(c), r);  
                listener.onFailure(statusBearing);
    /**
        // Route through the framework action (profile=true) just like execute(), so a profiling
    /**  
import java.util.Map;  
        TransportRequestOptions options = TransportRequestOptions.builder().withType(TransportRequestOptions.Type.REG).build();
import org.opensearch.core.action.ActionListener;
    private static boolean isInternalError(Exception e) {
                    ? QueryProfileBuilder.snapshot(graph, context, fullPlan, planningTimeMs)
        QueryDAG dag,
            QueryExecution successExec = execRef.get();
        return maxConcurrentShardRequestsPerNode;  
import java.util.concurrent.TimeUnit;
            }  
        Profile and explain are captured within the QueryExecution, however QueryExecution requires the complete
import java.util.concurrent.Executor;
        final long planningTimeNanos = System.nanoTime() - planStartNanos;
                : null;  
    private void broadcastClearShuffle(String queryId) {
     * stats collector via {@link AnalyticsStatsCollector#recordExecution} — no allocation, no
    }
import java.util.ArrayList;
            }
        // MPP-GENERAL-SCHEDULING-DESIGN.md.
        TimeValue taskTimeout = queryTask.getCancelAfterTimeInterval();
                    } catch (Exception e) {
        ActionListener<ProfiledResult> outerListener,
                node,
        this.transportService = transportService;
     *  (join shuffle, cascade, or shuffle-aggregate). Used to gate the terminal cleanup broadcast so  
public class DefaultPlanExecutor extends HandledTransportAction<AnalyticsQueryRequest, AnalyticsQueryResponse>
     * (success / failure / cancel). This is the cleanup the FAILURE path needs — a failed query does  
    private void executeInternal(  
    private final CapabilityRegistry capabilityRegistry;
        AnalyticsQueryTask queryTask,  
                options,
        if (perQueryBufferLimit <= 0) {
        }
            }
            // query (the vast majority) needn't pay O(data-nodes) cleanup RPCs. The gate
                AnalyticsSettings.MPP_BROADCAST_PROBE_ESTIMATE.getKey(),
            ActionListener.wrap(resp -> listener.onResponse(resp.getProfiledResult()), listener::onFailure)
            .addSettingsUpdateConsumer(AnalyticsPlugin.COORDINATOR_BUFFER_LIMIT, v -> perQueryBufferLimit = v);  
        if (AnalyticsSettings.MPP_ENABLED.get(perQuerySettings)) {
                    }  
                    }
            );
            .put(AnalyticsSettings.MPP_JOIN_REORDER.getKey(), clusterService.getClusterSettings().get(AnalyticsSettings.MPP_JOIN_REORDER))  
            execRef::set,
    }
    }
                String queryId = queryTask.getQueryId();
        this.maxConcurrentShardRequestsPerNode = AnalyticsQuerySettings.MAX_CONCURRENT_SHARD_REQUESTS_PER_NODE.get(  
        // broadcast query leaks its per-query Arrow allocator (and any failed/cancelled query
     * <p>If {@code queryCtx} is non-null, its {@link QueryRequestContext#clusterState()} is
    private static final long CLEAR_SHUFFLE_RETRY_BASE_MS = 200L;  
        // Record the dispatched strategy for /_analytics/_strategies. The general path distributes via
        // Fork the entire query lifecycle (planning, scheduling, cleanup) onto the SEARCH
                e -> {}
     *   flag also guards against infinite retry (the second attempt never picks broadcast).  
                    }, convertingListener::onFailure)
import org.opensearch.analytics.planner.dag.FragmentConversionDriver;
import java.util.concurrent.atomic.AtomicReference;  
        // UnifiedDispatch then runs whatever it distributes. Below the size floor the pass is a no-op and the
            logger.warn(new ParameterizedMessage("[query-{}] could not resolve data nodes for shuffle cleanup", queryId), e);
        this.clusterService = clusterService;
    private static ActionListener<Iterable<Object[]>> buildProfilingRowsListener(
        List<Object[]> rows = new ArrayList<>();  
            )
        plannerContext.setPlannerSettings(plannerSettings);
     */
        AnalyticsQueryRequest request = new AnalyticsQueryRequest(logicalFragment, queryCtx, indices, true);  
import org.opensearch.analytics.exec.action.AnalyticsClearShuffleRequest;
        // UnifiedDispatch discovers any BROADCAST_BUILD stages itself, captures them, injects each as a
        String[] indices = RelNodeUtils.extractIndices(logicalFragment);
            }  
    }
        // by capturing broadcasts (inject-as-instruction) then promoting shuffle worker tiers. A DAG the  
        AnalyticsStatsCollector statsCollector,  
        // chain holds a BroadcastSizeExceededException (the build overflowed the runtime cap — a
            int shufflePartitions = MppShufflePartitions.resolve(  
                broadcastClearShuffle(dag.queryId());  
                );
            MppStrategy routedStrategy;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        this.statsCollector = statsCollector;
            }  
                for (int r = 0; r < rowCount; r++) {  
        this.contextProvider = contextProvider;
                capabilityRegistry,  
            batchesListener.onFailure(e);  
import org.opensearch.analytics.EngineContextProvider;
            // A typed status (e.g. a 429 breaker) often arrives buried in a wrapper —
        // No taskManager.unregister here: the framework (HandledTransportAction) unregisters the
        // HandledTransportAction before doExecute, unregistered when the listener completes).
            } finally {
        if (queryCtx == null || queryCtx.parentTask() == null) {  
        // parquet.native.pool.query.max take effect immediately via Arrow's parent-cap check  
    public DefaultPlanExecutor(  
                    outerListener.onResponse(result);  
     * Unified planning + execution path. When {@code profile} is true, captures the CBO
        AnalyticsQueryTask queryTask,
            // on the SEARCH executor (off this terminal/callback thread, fresh THREAD_PROVIDERS) and  
            batchesListener.onFailure(new RuntimeException("dispatch failed", t));
    }  
        for (DiscoveryNode node : dataNodes.values()) {
            return true;
            logger.info(  
                client,  
            }, outerListener::onFailure);
     * (e.g. a 429 breaker wrapped as {@code RuntimeException("Stage N failed", cbe)}). Returns it so the
                () -> coordinatorAllocator.newChildAllocator("query-" + dag.queryId(), 0, perQueryBufferLimit)
        this.preferMetadataDriver = AnalyticsPlugin.PREFER_METADATA_DRIVER.get(clusterService.getSettings());
            // ShardFragmentStageExecution reports shard failures as RuntimeException("Stage N failed", cause),
    }
        }  
                AnalyticsQueryTask queryTask = (AnalyticsQueryTask) task;  
        return ordered;
        QueryRequestContext queryCtx,  
            return;
            ordered.add(vector);
        // explain path returns it inline.  
            // transport keeps charging it after the importing stream closes, so it must not be per-query.
        }
                            // executeWithProfile delivers failures via onResponse with a populated  
import org.opensearch.arrow.allocator.AllocationRejection;  
            // the planner gate kept the node-bootstrap value — gate and runtime would disagree mid-query.  
            return;  
import org.opensearch.cluster.service.ClusterService;
 *
        this.importStagingAllocator = coordinatorAllocatorHandle.getImportStagingAllocator();  
                }
                        } else {
    private final Scheduler scheduler;
import org.opensearch.transport.client.node.NodeClient;
                "query-" + dag.queryId(),
import java.io.IOException;  
        AnalyticsQueryRequest request = new AnalyticsQueryRequest(logicalFragment, queryCtx, indices);  
                    @Override  
     * once the node leaves the cluster (its buffers died with the process) or the attempt cap is hit.  
                    }
import org.opensearch.analytics.planner.PlannerContext;
        this.shuffleBufferManager = shuffleBufferManager;  
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;
                    request.isProfile(),
    static Iterable<Object[]> batchesToRows(Iterable<VectorSchemaRoot> batches, List<String> targetColumnOrder) {
        boolean includeProfileInResponse,
        // throw in attempt 2 still reaches outerListener instead of being lost on a worker.  
        // On the broadcast→shuffle retry, make BROADCAST ineligible so CBO falls back to
                    : new QueryProfile(context.queryId(), List.of(), planningTimeMs, 0L, List.of()))
            );
     *   still blow the cap; rather than fail, we re-plan without broadcast so CBO falls back to
                ownsAllocator,
        clusterService.getClusterSettings()
import org.opensearch.transport.TransportException;  
                    request.getPlan(),  
        } else {
/**
        if (broadcastDisabled) {
    protected void doExecute(Task task, AnalyticsQueryRequest request, ActionListener<AnalyticsQueryResponse> listener) {  
import org.opensearch.analytics.exec.shuffle.ShuffleBufferManager;
import org.opensearch.analytics.exec.join.UnifiedDispatch;
        QueryRequestContext queryCtx,
            QueryProfile qp = includeProfileInResponse
                request,
                    ActionListener.wrap(result -> {  
            }
            false,
        }
        NodeClient client,
import org.opensearch.analytics.planner.dag.PlanForker;
        // centric queries, QueryExecution.close() also calls config::close on the same context;
    ) {  
        final AnalyticsSearchSlowLog.QuerySlowLogListener queryListener = analyticsSearchSlowLog.createQueryListener(querySource);  
                String identifier = "unassigned".equals(queryId)
            } else {
                        if (result.isSuccess()) {
    private static boolean dagHasHashExchange(QueryDAG dag) {
        try {
        RelNode logicalFragment,
import org.opensearch.analytics.planner.CapabilityRegistry;
     * ({@code FINAL(ER(PARTIAL(...)))}). Delegates to {@link UnifiedDispatch}, which captures any broadcast  
        final long planStartNanos = System.nanoTime();
        // Build a per-query Settings snapshot that overlays the live cluster-state values for
    public int maxConcurrentShardRequestsPerNode() {
                );  
    /** Max attempts to deliver a shuffle-cleanup RPC to one node before giving up. A still-alive node  
            } catch (AssertionError e) {
        );
                AnalyticsSettings.MPP_DISTRIBUTE_MIN_ROWS.getKey(),
        batchesListener to construct the ExecutionGraph. To get around this circular dependency we build a profiling  
     * undelivered release permanently shrinks that node's per-node shuffle budget (the buffer is
     * genuinely internal and the redaction path should run.  
            clusterService.getSettings()
    private final BufferAllocator importStagingAllocator;
 *  
        boolean broadcastDisabled
            throw e;  
                AnalyticsSettings.BROADCAST_MAX_BYTES.getKey(),
import org.opensearch.transport.TransportResponseHandler;
                ? (graph != null  
    /**
    private static final long CLEAR_SHUFFLE_MAX_BACKOFF_MS = 5_000L;
            // also fire this terminal inline (on the calling thread, inside scheduler.execute)  
     */
        }  
            listener  
        // broadcast and/or hash-shuffle worker tiers; record BROADCAST when the DAG preserved a CBO  
        final Settings perQuerySettings = Settings.builder()
            // fallback for consistency.  
            profile,
        return ExceptionsHelper.status(e) == RestStatus.INTERNAL_SERVER_ERROR;
        // QueryContext.close() is idempotent so the duplicate is a no-op. For broadcast queries,
        // dsl-query-executor) threads an EngineContextProvider.getContext() snapshot through.
        // Collapse multi-backend stages to a single chosen alternative before conversion  
import org.opensearch.analytics.stats.AnalyticsStatsCollector;
        this.client = client;
            // gate reads it from PlannerContext settings, and it must agree with the runtime cap  
        // recorded into the collector and dropped from the response.
        // the task registered and the allocator open.  
            if (planUsesShuffle) {
        // would double-free a task we no longer own.
            // The general-scheduler row floor must follow dynamic updates too — the enforce() call gates  
     * logged. Each node's {@code clearForQuery} is idempotent and a no-op when it holds no buffers,
    }
import org.opensearch.action.support.ActionFilters;
        // Always time planning and capture the full plan: every query produces a QueryProfile  
        // executor so the calling thread — which may be a transport thread — is freed  
 * Coordinator-level plan executor. Registered as a {@link HandledTransportAction}  
            // cancellation-listener cleanup — without this, a failed shuffle query leaks its buffered
    private final IndexNameExpressionResolver indexNameExpressionResolver;
import org.opensearch.analytics.AnalyticsSettings;  
            rowsListener.onResponse(rows);  
        // exchange (shuffle/broadcast) + pre-split any distributed aggregate; DAGBuilder cut at those and  
            // distributed path, so a static node-bootstrap read would pin the 1M default and never distribute.
        // ─── Build query context ──────────────────────────────────────────
        // analytics-* settings on top of the node-startup settings. Without this overlay, dynamic  
        this.preFilterShardSize = AnalyticsQuerySettings.PRE_FILTER_SHARD_SIZE.get(clusterService.getSettings());  
 * <p>Front-end plugins resolve this class from the Node's Guice injector and invoke
    private final ThreadPool threadPool;
        );
    /** Visible for testing: the live per-node concurrent-shard-request limit (reflects dynamic updates). */
        this.indexNameExpressionResolver = indexNameExpressionResolver;  
                cause
                );
        if (dataNodes == null || dataNodes.isEmpty()) {
        ActionListener<Iterable<VectorSchemaRoot>> terminal
import org.opensearch.analytics.planner.dag.QueryDAG;
    }
    private static final int CLEAR_SHUFFLE_MAX_ATTEMPTS = 10;
                dispatchGeneralShuffle(dag, context, execRef, batchesListener);  
            // Node-scoped and unbounded: coordinator-reduce batches are imported onto it and the Flight
            // TODO(prune-columns-setting): now INERT. Upstream #22301 replaced our gated
                    queryId,
            .put(  
        // broadcast (even if a shuffle rides above it), HASH_SHUFFLE for a pure shuffle, else
     * (disconnect / timeout / {@code _tasks/_cancel}) cascades into the query and its fragments.
        // takes effect without a restart; UnifiedDispatch hands it to ShuffleEnrichment, which sets
        executeInternal(queryTask, logicalFragment, queryCtx, profile, listener, /* broadcastDisabled */ false);
 */
        }
        // Route synchronous setup failures (capture-sink construction, scheduler dispatch
import org.opensearch.tasks.Task;
            listener.onResponse(new ProfiledResult(rows, null, qp));  
            );  
        final QueryContext context;  
        return false;  
                ThreadPool.Names.SAME
    /**
            capabilityRegistry,
        // teardown completes — so attempt 2 never overlaps attempt 1's allocator under the  
            QueryProfile qp = includeProfileInResponse
            .put(
            context.setImportStagingAllocator(importStagingAllocator);  
                    : (BroadcastSizeExceededException) ExceptionsHelper.unwrap(result.failure(), BroadcastSizeExceededException.class);
                    ? "task_id=" + task.getId()  
                            );
            retryClearShuffle(queryId, node, request, attempt, e);
        // and for the stats collector (always). When profile=false the resulting profile is  
import org.opensearch.search.SearchService;  
    static Exception statusBearingCause(Exception converted) {
        // disconnect / explicit task cancel propagate into the running query.  
        // that's fed into AnalyticsStatsCollector for the _plugins/_analytics/stats endpoint.
            // Release shuffle buffers on query terminal (success / failure / cancel). This runAfter
                    }
                AnalyticsSettings.MPP_DISTRIBUTE_MIN_ROWS.get(perQuerySettings),
        long sortMergeJoinMinRows = clusterService.getClusterSettings().get(AnalyticsSettings.MPP_WORKER_SORT_MERGE_JOIN_MIN_ROWS);  
         */
        request.setParentTask(new TaskId(clusterService.localNode().getId(), queryCtx.parentTask().getId()));  
        /*
                    for (int c = 0; c < colCount; c++) {
            clusterService.getClusterSettings(),
        BackendPlanAdapter.adaptAll(dag, capabilityRegistry);
                    @Override
import org.opensearch.analytics.planner.dag.DAGBuilder;  
        }  
        // immediately. The listener is wrapped to convert backend-specific exceptions.
        AtomicReference<QueryExecution> execRef,
            );  
    /** Sends one shuffle-cleanup RPC to {@code node}; on failure reschedules up to
                () -> sendClearShuffle(queryId, node, request, attempt + 1),
        // for tiny dimensions. See IndexRowCountFetcher's class javadoc for the full story.
        // OpenSearchSchemaBuilder used to build the SchemaPlus, so planner and schema agree.  
 * the listener is fired by the scheduler once the query completes (or fails). The transport  
                cause
import org.opensearch.analytics.settings.PlannerSettings;  
import org.opensearch.analytics.exec.join.MppStrategyMetrics;  
                AnalyticsSettings.MPP_SHUFFLE_AGGREGATE_ENABLED.getKey(),
                logger.warn(  
                    try {  
        // gathers every join to COORDINATOR+SINGLETON (its cost gate knows only 3 fixed localities), so its
        });
        this.capabilityRegistry = capabilityRegistry;  
    private void dispatchGeneralShuffle(
import org.apache.calcite.rel.RelNode;  
        // closes the underlying allocator on Plugin.close() via the handle, so coordinator-  
            )  
                    public void handleResponse(AnalyticsClearShuffleResponse response) {  
     * {@code includeProfileInResponse} is true (i.e. for the {@code _explain} response).  
                clusterService.getClusterSettings().get(AnalyticsSettings.BROADCAST_MAX_BYTES)  
    /** Visible for testing: the live can-match pre-filter threshold (reflects dynamic updates). */  
    }
        final List<String> outputColumnOrder = logicalFragment.getRowType().getFieldNames();
        } catch (Exception e) {  
                return true;  
                new ParameterizedMessage(
        }
    private final AnalyticsStatsCollector statsCollector;  
            if (dispatchGeneralShuffle) {
        queryListener.setHeaders(queryTask.getHeader(Task.X_OPAQUE_ID), queryTask.getHeader(Task.X_REQUEST_ID));
                        + "re-planning without broadcast (falling back to hash-shuffle / coordinator-centric). "
            .put(clusterService.getSettings())
    private final MppStrategyMetrics mppStrategyMetrics;  
            // PlannerImpl.trimUnusedFields with its own unconditional trimFields, so nothing reads this  
import org.opensearch.analytics.settings.AnalyticsQuerySettings;
    private final PlannerSettings plannerSettings;
            // record HASH_SHUFFLE_AGG when the DAG distributes, else COORDINATOR_CENTRIC.
                clusterService.getClusterSettings().get(AnalyticsSettings.MPP_SHUFFLE_AGGREGATE_ENABLED)  
     *
        // broadcast instruction on its consumer stage, then dispatches the broadcast-free DAG (shuffle  
            } catch (Exception e) {  
                AnalyticsClearShuffleAction.NAME,  
        // QueryExecution operates on the pass-2 derived (non-owning) context, so it never frees  
        if (targetColumnOrder == null || targetColumnOrder.isEmpty()) {  
    // shutdown closes this child of POOL_QUERY before arrow-base closes the root allocator.
        // Broadcast→shuffle retry: on the FIRST attempt, intercept a terminal failure whose cause
        String fullPlan,
                    overflow.limitBytes()  
                    @Override
                    request.getQueryCtx(),
     * real status reaches the client instead of being redacted to a generic 500; null when the failure is
            // a framework misconfiguration. Translate Arrow's OutOfMemoryException into  
        // size floor kept fully coordinator-centric distributes nothing → UnifiedDispatch is a plain execute.
     * Set here, not in {@code createTask}, because the parent {@link TaskId} needs the local node id.  
            request,
        // Read the worker sort-merge-join floor live (dynamic-aware) so a PUT /_cluster/settings update  
     *  transport blips before accepting the rare leak. */  
        // operator kill switch and the IT framework's per-test setSetting calls.  
            try {
        // The non-explain path drops the profile from the response after recording it; the
import org.opensearch.analytics.planner.dag.BackendPlanAdapter;
                clusterService.getClusterSettings().get(AnalyticsSettings.MPP_DISTRIBUTE_MIN_ROWS)
 * SPDX-License-Identifier: Apache-2.0
            }  
        // Fetch primary-shard doc counts for every index this query touches. The CBO cost
            return;
        QueryScheduler qscheduler = (QueryScheduler) scheduler;
        );  
import org.opensearch.transport.TransportRequestOptions;
        logger.debug("[DefaultPlanExecutor] QueryDAG:\n{}", dag);  
            logger.warn(  
import org.opensearch.analytics.exec.action.AnalyticsClearShuffleAction;  
            )
    // Owned and closed by AnalyticsPlugin via the injected CoordinatorAllocatorHandle so that
                        outerListener.onFailure(e);  
import org.opensearch.transport.TransportService;  
import org.opensearch.analytics.planner.dag.PlanAlternativeSelector;  
        // escape to execute()'s outer catch which calls listener.onFailure directly — leaving
            // it so a dynamic PUT /_cluster/settings toggle is honored (else it pins the node-bootstrap default).
        // that bails before QueryExecution is even constructed leaks unconditionally).  
        final ActionListener<ProfiledResult> listener;
                plannerContext.getDistributionTraitDef(),
    private final NodeClient client;
        // Runs after SecurityFilter has authorized the request.
            converted,
                convertingListener.onFailure(e);
            planningTimeMs,  
        QueryPlanExecutor<RelNode, Iterable<Object[]>> {
                        return new AnalyticsClearShuffleResponse(in);  
            ownsAllocator = false;  
     */  
            // guarded so a synchronous planning/conversion throw in attempt 2 still reaches
        // Exponential backoff capped at the ceiling; guard the shift against overflow at high attempts.  
import org.apache.arrow.vector.VectorSchemaRoot;  
import org.opensearch.analytics.exec.profile.ProfiledResult;
                        + "Raise analytics.mpp.broadcast.max_bytes to keep broadcasting larger builds.",  
        final String querySource = queryCtx != null ? queryCtx.querySource() : null;
        QueryDAG dag = DAGBuilder.build(plan, capabilityRegistry, clusterService, indexNameExpressionResolver);  
            // and the client sees a proper backpressure signal rather than a generic 500.
            listener.onResponse(new ProfiledResult(null, e, qp));
            // (a harmless no-op broadcast), and never misses a real shuffle (a miss re-opens the leak).
        // root allocator. Long.MAX_VALUE on the child means dynamic resizes of
            return false;
        if (queryId == null) {  
    @Override  
            .put(
            // BEFORE execRef.set runs. Either way, if execRef (or its graph) is null, fall back to a
        // default 100 rows and broadcast loses the cost race against SINGLETON gather even
        IndexNameExpressionResolver indexNameExpressionResolver,
                    }  
        } catch (Throwable t) {
        if ((dagHasDistributedJoin || dagHasBroadcast) && !isQueryScheduler) {
            planningState,  
        }  
            FieldVector vector = batch.getVector(name);
        // updates via PUT /_cluster/settings (e.g. analytics.mpp.enabled) are invisible to the
                routedStrategy = MppStrategy.BROADCAST;
    }  
     * Builds a rows listener that, on every terminal, feeds the {@link ExecutionGraph} into the  
        );
            try {
                AnalyticsSettings.MPP_SHUFFLE_AGGREGATE_ENABLED.get(perQuerySettings)
        // Feature-branch (MPP) additions — appended last so upstream constructor extensions don't collide.
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.ParameterizedMessage;
        // common non-shuffle query so we don't fan O(data-nodes) no-op RPCs on every analytics query.
                AnalyticsSettings.MPP_SHUFFLE_PARTITIONS.getKey(),  
            // distribute-vs-coord on it; the cluster ITs lower it (small datasets) to exercise the
            // Overlay the broadcast byte cap too: OpenSearchBroadcastJoinSplitRule's pre-flight size
        ActionListener<ProfiledResult> listener  
            )  
 * path ({@code doExecute}) is reserved for future remote query invocation.
                ContextAwareExecutor.wrap(searchExecutor, threadPool).execute(() -> {
     *  the cluster (no buffers to leak) or the cap is reached. */  
     * Returns true if the exception would produce a 500 response and should be redacted.
