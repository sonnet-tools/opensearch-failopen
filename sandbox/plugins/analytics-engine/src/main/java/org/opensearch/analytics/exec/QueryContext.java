     * Fan-out above which the can-match pre-filter phase runs. Snapshotted from
    /**
    }
    /**
 * Per-query context — immutable config (DAG, executor, parent task) + lazy per-query
        ThreadPool threadPool,
     */
    }
        return resolvedTargetsByStage.get(stageId);
    private final boolean ownsAllocator;
    public QueryContext withDag(QueryDAG newDag) {
        );
     * roots anyway) working without wiring one.
    private final BufferAllocator allocator;
        Map<Integer, ShardExecutionTarget> byOrdinal = new ConcurrentHashMap<>(targets.size());
     *
    }
 *
    private static final RootAllocator TEST_ROOT = new RootAllocator(Long.MAX_VALUE);
     * <ul>
     */
    }
     * but without the mid-import-OOM mitigation, and it keeps test contexts (whose allocators are unbounded
        // Per-instance: close the owning allocator at most once. Independent of any shared state.
            /* ownsAllocator */ false,
        synchronized (sharedState) {
        return allocator;
    public Map<Integer, ShardExecutionTarget> getResolvedTargets(int stageId) {
    ) {
     * SharedState seam).
    public QueryDAG dag() {
     * LAST — per the "append our new params to the end of upstream-owned signatures" policy, so
 * The OpenSearch Contributors require contributions made to
            List.of(),
    /**
            threadPool,
     * executed the query, not the original primary that failed.
        BufferAllocator allocator,
        resolvedTargetsByStage.put(stageId, byOrdinal);
import org.opensearch.analytics.backend.AnalyticsOperationListener;
     * executor and shut it down exactly once. Non-shared queries get a holder of their own.
     * Map is built once at record time so callers can do O(1) ordinal-to-target lookup.
        int maxConcurrentShardRequestsPerNode,
/*
        this.operationListeners = operationListeners;
     * That's why the two flags are separate — the old single-flag design caused every
    }
                    sharedState.localTaskExecutor = exec;
            new SharedState()
     * <p>Param order: upstream-owned params first, then our (feature-branch) {@code sharedState}
            byOrdinal.put(ordinal, target);
    }
    }
        AnalyticsQueryTask parentTask,
    /**
    public ExecutorService localTaskExecutor() {
            new SharedState()
            parentTask,
        BufferAllocator allocator,
        boolean profile,
 * compatible open source license.
    private final AnalyticsQueryTask parentTask;
        return parentTask;
        BufferAllocator allocator,
        );
    }
     * <p>The derived context is non-owning: closing it is a no-op for the allocator. Only the
     * This ensures downstream stages (e.g. LM fetch) route to the node that actually
    /** Lazy per-query virtual-thread executor for LOCAL tasks. Shared across phased contexts. */
        int preFilterShardSize
 * this file be licensed under the Apache-2.0 license or a
        return threadPool != null ? threadPool.executor(AnalyticsPlugin.REDUCE_THREAD_POOL_NAME) : Runnable::run;
            parentTask,
    }
    /** Setting defaults for {@code analytics.query.*}; used by test contexts and as the baseline. */
        List<AnalyticsOperationListener> operationListeners
    public void recordResolvedTargets(int stageId, List<ShardExecutionTarget> targets) {
            testAllocator,
            DEFAULT_MAX_CONCURRENT_SHARD_REQUESTS_PER_NODE,
    }
     *   <li><b>Cross-instance:</b> shut down the lazy local-task executor exactly once across
    private static final int DEFAULT_PRE_FILTER_SHARD_SIZE = AnalyticsQuerySettings.PRE_FILTER_SHARD_SIZE.get(Settings.EMPTY);
        if (byOrdinal != null) {
    public static QueryContext forTest(QueryDAG dag, AnalyticsQueryTask parentTask, List<AnalyticsOperationListener> operationListeners) {
    /** Set once by {@code DefaultPlanExecutor} after construction. The caller owns the allocator. */
        return new QueryContext(
    boolean ownsAllocator() {
package org.opensearch.analytics.exec;
    public BufferAllocator bufferAllocator() {
     * original context's {@link #close()} releases the allocator (and shuts down the shared
    public static QueryContext forTest(QueryDAG dag, AnalyticsQueryTask parentTask) {
     */
     * HACK: side-table for cross-stage routing of resolved {@link ShardExecutionTarget}s.
        );
        return dag.queryId();
     * Today's only consumer is the QTF (late-materialization) Phase C, which needs to map
            }
     *   <li><b>Per-instance:</b> if this context owns the allocator, close it exactly once
            allocator,
            allocator,
 * {@link #withDag(QueryDAG)} for that. The derived context is non-owning: only the original
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
        List<AnalyticsOperationListener> operationListeners,
                    if (sharedState.executorClosed) {
import org.opensearch.analytics.settings.AnalyticsQuerySettings;
 *
        ThreadPool threadPool,
            ownsAllocator,
    public boolean profile() {
            preFilterShardSize,
        SharedState sharedState
     * Returns a derived context pointing at a different {@link QueryDAG} but sharing this
     */
        return new QueryContext(
    }
     * executor. Used by multi-phase join dispatch (e.g. M1 broadcast) where pass 1 drives only
            sharedState.executorClosed = true;
            profile,
            if (sharedState.executorClosed) return;
     * fail and retry in parallel on the scheduler thread pool.
        ThreadPool threadPool,
     * stage execution after {@code TargetResolver.resolve(...)} runs. See the field-level
     * because the Flight transport keeps charging it after the importing stream closes.
 * context's allocator + lazy executor. Use
            ownsAllocator,
                }
    /**
            preFilterShardSize,
    }
     */
                if (exec == null) {
                sharedState.localTaskExecutor = null;
            new SharedState()
    /** Whether profiling is enabled for this query (data nodes should collect and return metrics). */
    private final List<AnalyticsOperationListener> operationListeners;
     *       path twice — once from {@code QueryExecution.close()} and once from
            /* profile */ false,
            new SharedState()
/**
    /** Creates a test context with a synchronous executor. */
        AnalyticsQueryTask parentTask,
        this.preFilterShardSize = preFilterShardSize;
 *
    /** Whether profiling is enabled for this query (data nodes should collect and return metrics). */
    private final Map<Integer, Map<Integer, ShardExecutionTarget>> resolvedTargetsByStage = new ConcurrentHashMap<>();
        }
 * SPDX-License-Identifier: Apache-2.0
     *       {@code close()} twice on the same instance is safe even though Arrow's
        List<AnalyticsOperationListener> operationListeners,
     *
        QueryDAG dag,
            DEFAULT_PRE_FILTER_SHARD_SIZE,
 * <p>The phased MPP dispatcher ({@code UnifiedDispatch}) needs a derived context pointing at
    private final boolean profile;
    /**
     * and must share a single per-query allocator.
     * native batch, see {@code ShardScanExecutionContext#getImportStagingAllocator}), and long-lived
    /**
    }
     *       {@code BufferAllocator.close()} is not idempotent. (Coord-centric queries hit this
     * {@code analytics.query.pre_filter_shard_size} at query start by {@link DefaultPlanExecutor},
    private final int preFilterShardSize;
    public Executor schedulerExecutor() {
        }
            maxConcurrentShardRequestsPerNode,
            operationListeners,
     */
            threadPool,
     * Records the {@link ShardExecutionTarget}s resolved for a stage. Called once by the
import org.opensearch.common.settings.Settings;
        QueryDAG dag,
import org.opensearch.threadpool.ThreadPool;
     * an incoming row's {@code ___ugsi} ordinal back to the {@code (DiscoveryNode, ShardId)}
}
    /**
            operationListeners,
import java.util.concurrent.Executor;
            if (sharedState.localTaskExecutor != null) {
     * Returns the resolved targets for a stage keyed by per-shard ordinal (UGSI), or
 * a different DAG (e.g. the broadcast-free residual after build capture) that still shares this
    private final SharedState sharedState;
        BufferAllocator testAllocator = TEST_ROOT.newChildAllocator("test-" + dag.queryId(), 0, Long.MAX_VALUE);
    public BufferAllocator importStagingAllocator() {
    private final QueryDAG dag;
                exec = sharedState.localTaskExecutor;
        return forTest(dag, parentTask, List.of());
        boolean ownsAllocator,
     *       all phased sharers via {@code sharedState.executorClosed}. The original and any
     * and fresh {@link SharedState}. Param order matches the private full-ctor (minus the
            closed = true;
        boolean ownsAllocator,
     * {@code retargetForRetry} may update entries concurrently when multiple shards
    }
        this.threadPool = threadPool;
        }
    /** Creates a test context with synchronous executors and the supplied operation listeners. */
        ExecutorService exec = sharedState.localTaskExecutor;
        volatile ExecutorService localTaskExecutor;
    /**
public class QueryContext {
     * Idempotent. Serialised with lazy-init accessors; post-close executor accessors throw.
import java.util.Map;
            allocator,
    }
    }
 */
     *       <i>per instance</i>. Each instance has its own {@code closed} flag so calling
     */
        if (closeAllocator) {
     * {@code QueryContext}.
    }
        }
        return importStagingAllocator != null ? importStagingAllocator : allocator;
        boolean ownsAllocator,
            operationListeners,
        this.maxConcurrentShardRequestsPerNode = maxConcurrentShardRequestsPerNode;
     * table. Revisit when a second consumer appears or when extending QTF to UNION/JOIN.
        );
     * Holder for the lazy local-task executor + executor-close flag, shared across phased
        // Cross-instance: shut down the lazy executor at most once across all phased sharers.
    }
            parentTask,
     * <p>The inner map is a {@link java.util.concurrent.ConcurrentHashMap} because
        }
        int preFilterShardSize,
     * Updates a single resolved target after a successful shard retry on a different copy.
        synchronized (sharedState) {
        QueryDAG dag,
    public String queryId() {
    }
        this.sharedState = sharedState;
        .get(Settings.EMPTY);
 * @opensearch.internal
        boolean executorClosed;  // guarded by synchronized(this)
        this.importStagingAllocator = importStagingAllocator;
    // ─── Test factories ────────────────────────────────────────────────
        this.ownsAllocator = ownsAllocator;
        return dag;
    public QueryContext(
     */
import java.util.List;
     */
    public void updateResolvedTarget(int stageId, int ordinal, ShardExecutionTarget target) {
        Map<Integer, ShardExecutionTarget> byOrdinal = resolvedTargetsByStage.get(stageId);
    }
        this(
    private final int maxConcurrentShardRequestsPerNode;
import java.util.concurrent.Executors;
    public List<AnalyticsOperationListener> operationListeners() {
                    exec = Executors.newThreadPerTaskExecutor(
            parentTask,
     * </ul>
        int maxConcurrentShardRequestsPerNode,
     * prevent the original (owning) context from running its allocator-close branch later.
    ) {
    ) {
            }
                        Thread.ofVirtual().name("analytics-local-task-" + dag.queryId() + "-", 0).factory()
    private boolean closed;  // guarded by synchronized(sharedState)
     * <p>Crucially: a derived (non-owning) context's {@code close()} that runs first must NOT
     *
 * resources (Arrow buffer allocator, virtual-thread executor for LOCAL tasks).
import org.opensearch.analytics.planner.dag.ShardExecutionTarget;
            ownsAllocator,
        this.dag = dag;
            parentTask,
        int preFilterShardSize,
            /* profile */ false,
            byOrdinal.put(t.ordinal(), t);
    private final ThreadPool threadPool;
        BufferAllocator allocator,
        AnalyticsQueryTask parentTask,
     */
        boolean profile
        return maxConcurrentShardRequestsPerNode;
     * to dispatch a fetch. Stage 1 (SHARD_FRAGMENT) populates this once after resolve;
        return threadPool != null ? threadPool.executor(ThreadPool.Names.SEARCH) : Runnable::run;
        boolean ownsAllocator,
        return preFilterShardSize;
        QueryDAG dag,
            null,
     *       {@link #withDag(QueryDAG)}-derived contexts share the same executor; the first
     * lazy executor) — the caller is responsible for closing the original exactly once.
                sharedState.localTaskExecutor.shutdown();
        this.profile = profile;
            preFilterShardSize,
            synchronized (sharedState) {
     * <p>Falls back to {@link #bufferAllocator()} when unset — that is the pre-staging behaviour, correct
                    );
            allocator,
    }
            dag,
            true,
     * so a mid-query settings change cannot make one stage probe and another not.
import java.util.concurrent.ConcurrentHashMap;
     *       {@code DefaultPlanExecutor.batchesListener.runAfter}.)</li>
        int maxConcurrentShardRequestsPerNode,
     */
    }
        this(
        this.allocator = allocator;
    public int preFilterShardSize() {
            newDag,
    /**
        this(
    ) {
     * {@code null} if that stage hasn't resolved yet (or doesn't have a resolver). The
     *       {@code close()} to reach this point shuts it down.</li>
    private static final class SharedState {
 * context's {@link #close()} releases the allocator + shuts down the executor.
     * <p>TODO: this is a placeholder seam. {@code QueryContext} should not be a generic
    private QueryContext(
        return ownsAllocator;
            threadPool,
    /** Returns the operation listeners for this query. */
    }
            sharedState
    }
    public AnalyticsQueryTask parentTask() {
            operationListeners,
import org.apache.arrow.memory.BufferAllocator;
            dag,
    public QueryContext(
     */
     * <p>Two close paths run independently:
    public QueryContext(
            closeAllocator = !closed && ownsAllocator;
        if (exec == null) {
    public Executor searchExecutor() {
        );
     * context's buffer allocator, parent task, executor, listener list, and lazy local-task
            profile,
    /**
                        throw new IllegalStateException("QueryContext closed for query " + dag.queryId());
     * Returns the node-scoped allocator coordinator-side Arrow C Data imports are staged on — unbounded
        AnalyticsQueryTask parentTask,
     * Stage 3 (LM) reads it.
    }
        ThreadPool threadPool,
            threadPool,
        this.parentTask = parentTask;
        return threadPool != null ? threadPool.executor(AnalyticsPlugin.SCHEDULER_THREAD_POOL_NAME) : Runnable::run;
            maxConcurrentShardRequestsPerNode,
     * {@code Stage} alongside {@code targetResolver}, or reify a typed cross-stage routing
        int preFilterShardSize,
            preFilterShardSize,
     * shared flag, and the original's later teardown short-circuited before reaching the
        return exec;
import org.apache.arrow.memory.RootAllocator;
    private BufferAllocator importStagingAllocator;
     *
     * {@link SharedState#executorClosed}, which tracks the cross-instance executor shutdown.
import org.opensearch.analytics.planner.dag.QueryDAG;
     *
     * the build stage and pass 2 drives the probe + root; both phases belong to the same query
     *
    }
            dag,
                    }
     * Full-parameter constructor. Private; tests use {@link #forTest} factories.
     * allocator).
    }
            allocator.close();
 */
     * contexts so pass 1 and pass 2 of multi-phase dispatch (e.g. M1 broadcast) reuse a single
     * and parented at the root so an import cannot fail part-way through an array (which strands the whole
    public Executor reduceExecutor() {
        boolean closeAllocator;
            maxConcurrentShardRequestsPerNode,
     * Per-instance flag: has THIS context's {@link #close()} already disposed of its instance-
     * Public constructor used by {@link DefaultPlanExecutor} — carries the {@code profile} flag
import org.opensearch.analytics.AnalyticsPlugin;
        return operationListeners;
     *
    private static final int DEFAULT_MAX_CONCURRENT_SHARD_REQUESTS_PER_NODE = AnalyticsQuerySettings.MAX_CONCURRENT_SHARD_REQUESTS_PER_NODE
     * Javadoc on {@code resolvedTargetsByStage} for context on why this lives on
        for (ShardExecutionTarget t : targets) {
            dag,
        return profile;
    public void setImportStagingAllocator(BufferAllocator importStagingAllocator) {
     * scoped resources (the owning allocator)? Independent of
    /** Caller-owned; see {@link #importStagingAllocator()}. Never closed by this context. */
    /**
    public int maxConcurrentShardRequestsPerNode() {
    /** Max in-flight shard fragment requests the coordinator dispatches to any single data node. */
     * "things stages leave for other stages to find" map. Cleaner shapes: cache on
import java.util.concurrent.ExecutorService;
        int maxConcurrentShardRequestsPerNode,
            /* profile */ false,
        }
    public void close() {
     * broadcast query to leak its allocator (the derived pass-2 context closed first, set the
     * future upstream re-syncs don't collide on it.
            maxConcurrentShardRequestsPerNode,
