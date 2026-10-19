     * native batch, see {@code ShardScanExecutionContext#getImportStagingAllocator}), and long-lived  
     * the build stage and pass 2 drives the probe + root; both phases belong to the same query
    public Executor schedulerExecutor() {
        int preFilterShardSize,  
            List.of(),
    public void setImportStagingAllocator(BufferAllocator importStagingAllocator) {  
    public static QueryContext forTest(QueryDAG dag, AnalyticsQueryTask parentTask) {
        return threadPool != null ? threadPool.executor(AnalyticsPlugin.SCHEDULER_THREAD_POOL_NAME) : Runnable::run;
            threadPool,  
    public QueryContext(  
import org.opensearch.analytics.planner.dag.QueryDAG;  
            byOrdinal.put(ordinal, target);
    public QueryDAG dag() {  
import org.opensearch.analytics.backend.AnalyticsOperationListener;
        volatile ExecutorService localTaskExecutor;  
            operationListeners,
    /** Returns the operation listeners for this query. */
    }
            maxConcurrentShardRequestsPerNode,
import org.opensearch.analytics.planner.dag.ShardExecutionTarget;
            dag,
     * Returns the node-scoped allocator coordinator-side Arrow C Data imports are staged on — unbounded
                sharedState.localTaskExecutor.shutdown();
            new SharedState()
    private static final int DEFAULT_PRE_FILTER_SHARD_SIZE = AnalyticsQuerySettings.PRE_FILTER_SHARD_SIZE.get(Settings.EMPTY);  
            preFilterShardSize,  
     * <p>The inner map is a {@link java.util.concurrent.ConcurrentHashMap} because
     * executed the query, not the original primary that failed.
        ThreadPool threadPool,
            byOrdinal.put(t.ordinal(), t);  
        return maxConcurrentShardRequestsPerNode;
    private static final class SharedState {
import java.util.Map;
    /**  
     * Stage 3 (LM) reads it.
        );
/**
            true,
     * contexts so pass 1 and pass 2 of multi-phase dispatch (e.g. M1 broadcast) reuse a single
    /** Whether profiling is enabled for this query (data nodes should collect and return metrics). */  
            sharedState
    }
     * allocator).
    public Map<Integer, ShardExecutionTarget> getResolvedTargets(int stageId) {
            closeAllocator = !closed && ownsAllocator;
    ) {  
    private final QueryDAG dag;
        List<AnalyticsOperationListener> operationListeners
                }  
     *       {@code close()} to reach this point shuts it down.</li>  
    /** Max in-flight shard fragment requests the coordinator dispatches to any single data node. */
     *
    // ─── Test factories ────────────────────────────────────────────────
    private static final int DEFAULT_MAX_CONCURRENT_SHARD_REQUESTS_PER_NODE = AnalyticsQuerySettings.MAX_CONCURRENT_SHARD_REQUESTS_PER_NODE
        );  
        return parentTask;
        Map<Integer, ShardExecutionTarget> byOrdinal = new ConcurrentHashMap<>(targets.size());
        QueryDAG dag,
        }
 * Per-query context — immutable config (DAG, executor, parent task) + lazy per-query
        return profile;  
        this(
        BufferAllocator allocator,
            testAllocator,  
        if (exec == null) {
        this.operationListeners = operationListeners;  
            threadPool,  
        );  
            synchronized (sharedState) {
    }
    private final List<AnalyticsOperationListener> operationListeners;
        int preFilterShardSize,
            }
    }
        }
    }  
     * original context's {@link #close()} releases the allocator (and shuts down the shared  
     */
     * <p>Two close paths run independently:
     *       path twice — once from {@code QueryExecution.close()} and once from
        this.sharedState = sharedState;  
     * an incoming row's {@code ___ugsi} ordinal back to the {@code (DiscoveryNode, ShardId)}
        return importStagingAllocator != null ? importStagingAllocator : allocator;
    private BufferAllocator importStagingAllocator;
        this.importStagingAllocator = importStagingAllocator;
            allocator,
}  
    /**
 * compatible open source license.
    public BufferAllocator importStagingAllocator() {
            new SharedState()
    public QueryContext(
        QueryDAG dag,
        AnalyticsQueryTask parentTask,
        );  
     * <p>Crucially: a derived (non-owning) context's {@code close()} that runs first must NOT  
import org.apache.arrow.memory.RootAllocator;
            parentTask,
import org.opensearch.threadpool.ThreadPool;
    }
    private static final RootAllocator TEST_ROOT = new RootAllocator(Long.MAX_VALUE);
        boolean executorClosed;  // guarded by synchronized(this)
            ownsAllocator,  
 * SPDX-License-Identifier: Apache-2.0
     * to dispatch a fetch. Stage 1 (SHARD_FRAGMENT) populates this once after resolve;  
     *
            preFilterShardSize,  
            /* profile */ false,
    private final int maxConcurrentShardRequestsPerNode;
        ThreadPool threadPool,
    private final int preFilterShardSize;  
            maxConcurrentShardRequestsPerNode,
    }  
     */  
     *  
     */
    /** Lazy per-query virtual-thread executor for LOCAL tasks. Shared across phased contexts. */
        }
    public Executor searchExecutor() {  
     * scoped resources (the owning allocator)? Independent of
     */  
    private final ThreadPool threadPool;  
        BufferAllocator allocator,  
     */  
            if (sharedState.localTaskExecutor != null) {
            if (sharedState.executorClosed) return;
        resolvedTargetsByStage.put(stageId, byOrdinal);
    }
            /* ownsAllocator */ false,  
            allocator.close();  
        boolean ownsAllocator,
        ThreadPool threadPool,  
        return operationListeners;  
     * shared flag, and the original's later teardown short-circuited before reaching the
    }
    ) {  
    /**
        int preFilterShardSize
    public QueryContext withDag(QueryDAG newDag) {  
                    if (sharedState.executorClosed) {
        this.allocator = allocator;
     */  
    /**  
            parentTask,
            newDag,
    public boolean profile() {
     * Updates a single resolved target after a successful shard retry on a different copy.  
     * {@code null} if that stage hasn't resolved yet (or doesn't have a resolver). The
     *
 * context's {@link #close()} releases the allocator + shuts down the executor.  
            null,
    public int maxConcurrentShardRequestsPerNode() {  
     * HACK: side-table for cross-stage routing of resolved {@link ShardExecutionTarget}s.  
    }
    /**  
     * broadcast query to leak its allocator (the derived pass-2 context closed first, set the  
        return forTest(dag, parentTask, List.of());
        // Cross-instance: shut down the lazy executor at most once across all phased sharers.  
            /* profile */ false,
    }  
 * resources (Arrow buffer allocator, virtual-thread executor for LOCAL tasks).  
     * Today's only consumer is the QTF (late-materialization) Phase C, which needs to map
 */  
     * {@code retargetForRetry} may update entries concurrently when multiple shards  
     * future upstream re-syncs don't collide on it.
        SharedState sharedState
            profile,
     * and parented at the root so an import cannot fail part-way through an array (which strands the whole
    public BufferAllocator bufferAllocator() {
 *
    }
    }
            ownsAllocator,  
            parentTask,
        synchronized (sharedState) {
     */
        this(
    private QueryContext(
        boolean closeAllocator;  
     *       all phased sharers via {@code sharedState.executorClosed}. The original and any
            sharedState.executorClosed = true;  
     * Javadoc on {@code resolvedTargetsByStage} for context on why this lives on  
     */
    /**
import java.util.concurrent.Executors;
 */  
     * executor and shut it down exactly once. Non-shared queries get a holder of their own.
        this.maxConcurrentShardRequestsPerNode = maxConcurrentShardRequestsPerNode;
            new SharedState()
            operationListeners,
            dag,
    public static QueryContext forTest(QueryDAG dag, AnalyticsQueryTask parentTask, List<AnalyticsOperationListener> operationListeners) {  
 * this file be licensed under the Apache-2.0 license or a
     *   <li><b>Cross-instance:</b> shut down the lazy local-task executor exactly once across  
    public ExecutorService localTaskExecutor() {
    public String queryId() {
     * {@code analytics.query.pre_filter_shard_size} at query start by {@link DefaultPlanExecutor},  
    }  
     * <p>TODO: this is a placeholder seam. {@code QueryContext} should not be a generic  
        return ownsAllocator;
    private final SharedState sharedState;
        boolean profile
        ThreadPool threadPool,  
    private final boolean ownsAllocator;  
        return exec;  
        List<AnalyticsOperationListener> operationListeners,
public class QueryContext {
            parentTask,
    }
     */  
        }
    /** Creates a test context with a synchronous executor. */  
        synchronized (sharedState) {
    }  
 * a different DAG (e.g. the broadcast-free residual after build capture) that still shares this  
    }
        AnalyticsQueryTask parentTask,  
import org.opensearch.common.settings.Settings;  
            maxConcurrentShardRequestsPerNode,
     * executor. Used by multi-phase join dispatch (e.g. M1 broadcast) where pass 1 drives only
     *       {@link #withDag(QueryDAG)}-derived contexts share the same executor; the first
     * table. Revisit when a second consumer appears or when extending QTF to UNION/JOIN.  
     * and fresh {@link SharedState}. Param order matches the private full-ctor (minus the
        boolean ownsAllocator,  
    private boolean closed;  // guarded by synchronized(sharedState)
                    }
     * stage execution after {@code TargetResolver.resolve(...)} runs. See the field-level
     *       {@code close()} twice on the same instance is safe even though Arrow's
    public void updateResolvedTarget(int stageId, int ordinal, ShardExecutionTarget target) {
        return dag.queryId();
            DEFAULT_PRE_FILTER_SHARD_SIZE,
     */  
    /**
    }
        return allocator;  
     * lazy executor) — the caller is responsible for closing the original exactly once.
     * <p>Param order: upstream-owned params first, then our (feature-branch) {@code sharedState}  
     *   <li><b>Per-instance:</b> if this context owns the allocator, close it exactly once  
     *
        List<AnalyticsOperationListener> operationListeners,
     */  
     * Idempotent. Serialised with lazy-init accessors; post-close executor accessors throw.
     * This ensures downstream stages (e.g. LM fetch) route to the node that actually
            preFilterShardSize,  
    public Executor reduceExecutor() {
import org.apache.arrow.memory.BufferAllocator;
    }  
    }  
            allocator,
import org.opensearch.analytics.settings.AnalyticsQuerySettings;
     *
package org.opensearch.analytics.exec;
    public void close() {
            parentTask,
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
 * <p>The phased MPP dispatcher ({@code UnifiedDispatch}) needs a derived context pointing at
     * but without the mid-import-OOM mitigation, and it keeps test contexts (whose allocators are unbounded
    }
        }
     */
        this.threadPool = threadPool;
    private final Map<Integer, Map<Integer, ShardExecutionTarget>> resolvedTargetsByStage = new ConcurrentHashMap<>();  
        return resolvedTargetsByStage.get(stageId);
            dag,  
            dag,
                    );
            new SharedState()  
    /**
 * The OpenSearch Contributors require contributions made to  
    boolean ownsAllocator() {  
    /** Whether profiling is enabled for this query (data nodes should collect and return metrics). */
        int maxConcurrentShardRequestsPerNode,  
        int maxConcurrentShardRequestsPerNode,
        return threadPool != null ? threadPool.executor(AnalyticsPlugin.REDUCE_THREAD_POOL_NAME) : Runnable::run;  
        this.profile = profile;
     * {@code QueryContext}.
        AnalyticsQueryTask parentTask,
     * SharedState seam).  
     * Records the {@link ShardExecutionTarget}s resolved for a stage. Called once by the
        return preFilterShardSize;
        this.dag = dag;
     * "things stages leave for other stages to find" map. Cleaner shapes: cache on
        return threadPool != null ? threadPool.executor(ThreadPool.Names.SEARCH) : Runnable::run;
        // Per-instance: close the owning allocator at most once. Independent of any shared state.
     * so a mid-query settings change cannot make one stage probe and another not.
     * roots anyway) working without wiring one.
 * @opensearch.internal
        );  
    private final BufferAllocator allocator;
    /** Setting defaults for {@code analytics.query.*}; used by test contexts and as the baseline. */  
    private final boolean profile;
    }  
    }
        return dag;
     * Returns a derived context pointing at a different {@link QueryDAG} but sharing this
     *       {@code DefaultPlanExecutor.batchesListener.runAfter}.)</li>
            profile,
 *
        boolean profile,
            allocator,
    ) {  
        if (closeAllocator) {
     * {@link SharedState#executorClosed}, which tracks the cross-instance executor shutdown.
/*  
    private final AnalyticsQueryTask parentTask;
        AnalyticsQueryTask parentTask,
        boolean ownsAllocator,  
     * Map is built once at record time so callers can do O(1) ordinal-to-target lookup.
import org.opensearch.analytics.AnalyticsPlugin;  
     * </ul>
        int maxConcurrentShardRequestsPerNode,  
        QueryDAG dag,
     * <p>Falls back to {@link #bufferAllocator()} when unset — that is the pre-staging behaviour, correct  
            DEFAULT_MAX_CONCURRENT_SHARD_REQUESTS_PER_NODE,  
            operationListeners,
     * Public constructor used by {@link DefaultPlanExecutor} — carries the {@code profile} flag
     * context's buffer allocator, parent task, executor, listener list, and lazy local-task  
                        throw new IllegalStateException("QueryContext closed for query " + dag.queryId());  
     *       {@code BufferAllocator.close()} is not idempotent. (Coord-centric queries hit this  
        BufferAllocator allocator,
     * <ul>
    public List<AnalyticsOperationListener> operationListeners() {
     * fail and retry in parallel on the scheduler thread pool.
    public QueryContext(
            /* profile */ false,
            preFilterShardSize,  
     * because the Flight transport keeps charging it after the importing stream closes.
        this(
import java.util.concurrent.ExecutorService;
            allocator,
    /** Creates a test context with synchronous executors and the supplied operation listeners. */
            ownsAllocator,  
     * Full-parameter constructor. Private; tests use {@link #forTest} factories.
    }
    public int preFilterShardSize() {  
                    sharedState.localTaskExecutor = exec;
 *
        BufferAllocator testAllocator = TEST_ROOT.newChildAllocator("test-" + dag.queryId(), 0, Long.MAX_VALUE);
     * <p>The derived context is non-owning: closing it is a no-op for the allocator. Only the
        BufferAllocator allocator,
    }
     * Holder for the lazy local-task executor + executor-close flag, shared across phased  
 * {@link #withDag(QueryDAG)} for that. The derived context is non-owning: only the original
            operationListeners,
    }
                sharedState.localTaskExecutor = null;  
import java.util.List;  
        .get(Settings.EMPTY);
    /**
     *
        QueryDAG dag,  
        if (byOrdinal != null) {  
        this.parentTask = parentTask;  
     * Per-instance flag: has THIS context's {@link #close()} already disposed of its instance-  
            threadPool,  
    /** Set once by {@code DefaultPlanExecutor} after construction. The caller owns the allocator. */
        this.ownsAllocator = ownsAllocator;
     * LAST — per the "append our new params to the end of upstream-owned signatures" policy, so
    }
    ) {  
                    exec = Executors.newThreadPerTaskExecutor(
        ExecutorService exec = sharedState.localTaskExecutor;  
     * {@code Stage} alongside {@code targetResolver}, or reify a typed cross-stage routing
     * and must share a single per-query allocator.  
     * Fan-out above which the can-match pre-filter phase runs. Snapshotted from
        boolean ownsAllocator,
        Map<Integer, ShardExecutionTarget> byOrdinal = resolvedTargetsByStage.get(stageId);
     * That's why the two flags are separate — the old single-flag design caused every
        return new QueryContext(
 * context's allocator + lazy executor. Use
                if (exec == null) {
     *       <i>per instance</i>. Each instance has its own {@code closed} flag so calling
        return new QueryContext(
    public AnalyticsQueryTask parentTask() {  
     * prevent the original (owning) context from running its allocator-close branch later.
     * Returns the resolved targets for a stage keyed by per-shard ordinal (UGSI), or  
    /**
            closed = true;  
        int preFilterShardSize,
            threadPool,  
        this.preFilterShardSize = preFilterShardSize;
            maxConcurrentShardRequestsPerNode,
import java.util.concurrent.Executor;  
import java.util.concurrent.ConcurrentHashMap;
    public void recordResolvedTargets(int stageId, List<ShardExecutionTarget> targets) {  
                exec = sharedState.localTaskExecutor;  
        int maxConcurrentShardRequestsPerNode,
        }
            }
    /**
                        Thread.ofVirtual().name("analytics-local-task-" + dag.queryId() + "-", 0).factory()  
    /**  
    /** Caller-owned; see {@link #importStagingAllocator()}. Never closed by this context. */
        for (ShardExecutionTarget t : targets) {
