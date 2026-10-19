     * Sorts {@code rowIds} ascending in place, permuting {@code positions} along.
 * {@link RowProducingSink}-style output (arriving via {@code feed(VSR)} on whatever  
    private Map<Integer, ShardFetchPlan> groupByUgsi() {
            outputFields.add(ArrowCalciteTypes.toArrowField(f.getName(), f.getType()));
 *   <li>{@link AnalyticsSearchTransportService#dispatchFragmentStreaming} — pattern for  
 * {@link UnsupportedOperationException}. The four phases below are the work to land:
 *  
import org.opensearch.analytics.exec.stage.coordinator.ReduceStageExecution;  
        Map<Integer, ShardExecutionTarget> targetsByUgsi = config.getResolvedTargets(shardStageId);
        if (getState().isTerminal()) {
        // contract — see AnalyticsSearchService.executeFetchByRowIds) + the physical fields  
            positionsByUgsi.get(ugsi)[cur] = i;
        String fetchBackendId
            // K=0: nothing to dispatch. Parent stage owns parentSink.close() via  
            s.close();  
 * <h3>Phase D — stitch and feed parent (Java)</h3>
        //
     */
                        + "] in batch schema; got "  
        Map<Integer, long[]> rowIdsByUgsi = new HashMap<>(sizesByUgsi.size());
        this.transport = transport;
 * <h2>Implementation status</h2>
     */  
    protected void onTerminalTransition(State terminal) {  
 *
     * {@link ShardFetchPlan} per shard. Each plan's parallel {@code rowIds} and
    /**  
    /**
    }  
 *       the parent (Post-Sort) stage's start is gated on this stage's SUCCEEDED.</li>
                pending
            throw new IllegalStateException(
     *  
            throw new IllegalStateException(
/**  
            scatterFetchAndStitch(listener);
        }  
}
 *   LateMaterializationStageExecution  
            // this asynchronous failure reaches the query listener.
     * Indirect sort via an index array — ~O(N log N) with bounded extra allocation; fine
                );
                task.addShardMetrics(shardLabel, trailingMetadata);  
            );  
    private final ExchangeSink parentSink;  
    /**
        Arrays.sort(order, (a, b) -> Long.compare(rowIds[a], rowIds[b]));
            fetchBackendId  
        @Override
     * When multi-backend per-shard plans become real the data node will need to feed back
/*  
        Map<Integer, Integer> sizesByUgsi = new HashMap<>();  
        this.clusterService = clusterService;  
        int shardStageId,  
        }  
            try {  
 * {@code [sort_cols, fetch_cols...]} (helper columns {@code ___row_id} + {@code ___ugsi}
 * <pre>
import java.util.Arrays;  
import org.opensearch.analytics.planner.ArrowCalciteTypes;
        ClusterService clusterService,
        this.fetchBackendId = fetchBackendId;  
 * cells keyed by {@code rowPos}. Use an {@link java.util.concurrent.atomic.AtomicInteger}
        Map<Integer, ShardFetchPlan> plans = new HashMap<>(sizesByUgsi.size());
import org.opensearch.analytics.spi.CancellableExchangeSink;
    }
     * plans is Phase B's job; here we only flatten the helper columns into the two
    /**
        for (int i = 0; i < n; i++) {
                columns,
        if (drainedRowCount == 0) {
 *
     * from the SHARD_FRAGMENT descendant's first plan alternative.
                        + OpenSearchLateMaterialization.ROW_ID_FIELD  
        Stitcher s = this.stitcher;
 * <h2>Cross-references</h2>
    /** Stashed for the {@code onComplete} closure to read {@link Stitcher#surfaceableFailure()}. */  
        String[] columns = new String[aboveFields.size() + 1];
     * fires one async {@link FetchByRowIdsRequest} per shard via
     * Reads K rows of {@code [reduce-set, ___row_id, ___ugsi]} from the child input
            );  
            BigIntVector rowIds = (BigIntVector) vsr.getVector(rowIdIdx);
    private final OpenSearchLateMaterialization wrapper;
        super(stage, config.queryId(), config.operationListeners(), config.parentTask());  
        }  
 *      ▲                        ◄── feeds parent's input sink
     * {@code stitched[positions[j]]}.  
 * batches into {@link #parentSink}. On EOF call {@link ExchangeSink#close()} on
 *
        AnalyticsSearchTransportService transport,
     * and exact. No need to walk the batches twice.
 *   <li>{@link ReduceStageExecution} — closest existing analogue for "consumes child's
            try {
 *       fan-out + per-shard response handling.</li>  
                outerListener.onResponse(null);  
    /**  
 * {@code FetchByRowIdRequest} via {@link #transport}. Use
     * triggers {@code outerListener.onResponse} (or {@code onFailure}) when the last shard
 *
        throw new UnsupportedOperationException("parentSink does not implement ExchangeSource: " + parentSink.getClass().getSimpleName());
import org.opensearch.analytics.planner.RelNodeUtils;  
     * {@link Stitcher#finish} runs (all shards reported). If the stage terminates — via cancel,  
            ShardFetchPlan plan = entry.getValue();
    /**
 *
            );  
            return source;
        for (Integer ugsi : sizesByUgsi.keySet()) {
                throw new IllegalStateException(
            // Per-node PendingExecutions: mirrors ShardTaskRunner — keeps a slow node from
                request,  
     *  
    ) {
 *      │  Phase C: gather per-node fetch results (Java)
 * (its only child) and below the parent stage that consumes the fully-materialized
            int rowIdIdx = vsr.getSchema().getFields().indexOf(vsr.getSchema().findField(OpenSearchLateMaterialization.ROW_ID_FIELD));
     * completes — no blocking on this thread.
 *
     * Phase A drain. Walks the child's buffered VSRs in arrival (sort) order, extracts
import org.opensearch.analytics.exec.RowProducingSink;  
        }
    static void sortParallelByRowIdAscending(long[] rowIds, int[] positions) {
        }
        drainedRowIds = new long[K];
    /**
     * allocates {@code output} on the coordinator allocator up front and only frees it when
 * <p><b>Data-node handler required.</b> The handler reads the columns named in the
 *
 * propagation.
        List<Field> outputFields = new ArrayList<>(aboveFields.size());  
 *       fed to the parent sink, parent stage can start.</li>
    private volatile Stitcher stitcher;  
     * Phase A input. Child stage (Sort+Limit reduce) writes its K rows here. Returned
        long total = childInputBuffer.getRowCount();  
 *   ExchangeSource src = (ExchangeSource) downstreamSink;   // see inputSink() below
 * for in-flight count (mirrors {@link ShardFragmentStageExecution}'s pattern). When
 * fragment and no DataFusion compute. The stage sits above a Sort+Limit reduce stage
     * <p>Returned by {@link #inputSink(int)}; the child stage writes K rows here. The
     * lookup map needed.  
            }
 *   <li>{@link StageExecution.State#RUNNING} — entered when the child Sort+Limit stage  
     * {@link Stitcher#close} / {@code VectorSchemaRoot#close} are idempotent), and when no stitcher
 *       {@code getAboveAnchorPhysicalFieldStorage()} (List&lt;FieldStorageInfo&gt;).</li>
        if ((terminal == State.CANCELLED || terminal == State.FAILED) && parentSink instanceof CancellableExchangeSink cancellable) {
        }
            this.plan = plan;
 * indexUUID) using a coord-side side table built when the child stage's per-shard tasks  
     * <p>Despite the name, the actual partition-by-{@code ___ugsi} into per-shard fetch
import org.opensearch.analytics.exec.StreamingResponseListener;
 *  
                config.profile()
        public boolean onStreamResponse(FragmentExecutionArrowResponse response, boolean isLast) {
    private void scatterFetchAndStitch(ActionListener<Void> outerListener) throws Exception {
            throw new IllegalStateException("Drained row count exceeds Integer.MAX_VALUE: " + total);
                stitcher.shardFailed(new IllegalStateException("No resolved target for ugsi=" + ugsi));
     * maintains {@code totalRows} incrementally on each {@code feed()}, so this is O(1)
    /**
 *  
     */
        if (total > Integer.MAX_VALUE) {
                        + ", "
 *   <li>{@link OpenSearchLateMaterialization} — wrapper RelNode in the stage's fragment;
 *       carries {@code getAboveAnchorPhysicalFields()} (List&lt;RelDataTypeField&gt;) and  
        // where the field is still null but output exists would leak it on a racing terminal.
 *
            }  
 * transports and the (already-completed) child stage. Mirrors
        // NOT included — it's a helper consumed during stitch, never surfaced.
            sortParallelByRowIdAscending(rowIds, positions);
        }
    }  
     * {@link RowProducingSink} works as a buffer (it implements both {@link ExchangeSink}  
 * parentSink and transition to {@link StageExecution.State#SUCCEEDED}.  
 *   }  
        // We must also settle outerListener: the task body owns firing the per-task listener (see
                parentSink.close();
                // Drain copied helper columns into primitive arrays; the buffered VSRs are  
     * requires ascending rowIds in the request and the native side returns rows in the same  
            // Each shard's fetch reports its own metrics/physical plan. Keyed by shardLabel so  
        for (int i = 0; i < drainedRowCount; i++) {  
        Stage stage,
        return plans;  
     * batches (already in sort order) and copies the helper columns into two parallel  
import org.apache.logging.log4j.Logger;
        }  
                // Stitcher.acceptBatch only reads + copyFromSafe; ownership of the response
import java.util.concurrent.ConcurrentHashMap;
            }  
 *      │  Phase B: scatter fetch by ___ugsi      (Java + transport)  
        }  
     * completion / failure to the stitcher's countdown.  
 * <p>Per-node responses arrive out of order. Maintain a {@code ConcurrentHashMap<Integer
     * before dispatch; Phase C then walks request and response in lockstep — no per-row
        System.arraycopy(sortedRowIds, 0, rowIds, 0, n);  
        for (Map.Entry<Integer, ShardFetchPlan> entry : plansByUgsi.entrySet()) {
     */  
            return;  
 *      ▲                        ◄── filled by child Sort+Limit reduce
     * Phase C dispatches {@code rowIds} to shard {@code ugsi}'s data node; the response
 * Backend-specific: DataFusion's parquet reader can produce these from a Lucene docId
            }  
 * <ul>
                stage.getStageId(),  
     * {@code ___ugsi → (DiscoveryNode, ShardId)}. See {@code QueryContext.resolvedTargetsByStage}  
 *  
        // and skipped the close. Re-check here and release output now that the field is published.  
 * stripped per {@link OpenSearchLateMaterialization} contract). Each row's sort cols  
        );
        this.shardStageId = shardStageId;
        for (int i = 0; i < aboveFields.size(); i++) {
public final class LateMaterializationStageExecution extends AbstractStageExecution implements DataConsumer, DataProducer {
                continue;
 *   parent stage (Post-Sort)  
        this.wrapper = RelNodeUtils.findNode(stage.getFragment(), OpenSearchLateMaterialization.class);
import org.opensearch.analytics.exec.AnalyticsSearchTransportService;  
            rowIdsByUgsi.put(e.getKey(), new long[e.getValue()]);
     */
        QueryContext config,
            stage.getStageId(),
import org.opensearch.core.action.ActionListener;
            "[LMStage] CREATED stageId={} aboveAnchorPhysicalFieldCount={} backendId={}",  
 *
                rowsCopiedSoFar += batch.getRowCount();  
                drainAndGroupByUgsi();
     * {@code ___row_id} and {@code ___ugsi} per row, and groups into per-shard fetch plans  
     * on the long-lived coordinator allocator. Closing here guarantees release; it is a no-op when  
     * ascending order. Phase B will sort each plan's {@code (rowIds, positions)} as a unit
 * sink the LM stage provides via {@link #inputSink(int)}). At {@link #start} time the
     */
     * for the rationale and revisit conditions — short version: stages leaving
     * allocate exactly-sized per-shard arrays, one to fill them. No per-row boxing.  
        }
            plansByUgsi = groupByUgsi();
                target.node(),
            positionsByUgsi.put(e.getKey(), new int[e.getValue()]);  
            transport.dispatchFetchByRowIds(
    }
    private int drainedRowCount;
            // ActionListener fires asynchronously via Stitcher's onComplete callback when
    private void drainAndGroupByUgsi() {
 * QTF (Query-Then-Fetch / late-materialization) Scatter-Gather stage execution.
        }
                outerListener.onFailure(failure);
        // concurrent cancel thread) can always find it and close its pre-allocated output VSR. The  
        // the user wants displayed.
     * {@link #drainedRowIds} / {@link #drainedUgsis} / {@link #drainedRowCount} and closes  
    private final AnalyticsSearchTransportService transport;
 *      │  Phase A: drain reduce output           (Java)
     * Per-shard fetch plan: {@code rowIds} sorted ascending, {@code positions[j]} the
        if (n <= 1) return;
        // state is an AtomicReference, so this read pairs with the CAS in transitionTo: either that
 *      │  Phase D: stitch → emit                 (Java)
            PendingExecutions pending = pendingByNodeId.computeIfAbsent(  
 * {@link ShardFragmentStageExecution#cancel(String)}.  
            wrapper.getAboveAnchorPhysicalFields().size(),
        columns[0] = OpenSearchLateMaterialization.ROW_ID_FIELD;  
 * <p><b>SKELETON ONLY.</b> Today {@link #start} throws  
                    "LM stage drain expected ["
            VectorSchemaRoot batch = response.getRoot();  
            );  
                "LATE_MATERIALIZATION stage " + stage.getStageId() + " missing OpenSearchLateMaterialization marker in fragment"
            plans.put(ugsi, new ShardFetchPlan(ugsi, rowIds, positions));  
            );
     * Sink the child Sort+Limit stage feeds into (Phase A input).
import org.opensearch.analytics.spi.ExchangeSink;  
        if (this.wrapper == null) {  
    private static final Logger logger = LogManager.getLogger(LateMaterializationStageExecution.class);  
            // because shard IDs are only unique within an index.  
     *
    // which may fire on a different thread (cancel / timeout / upstream failure).
    }
        // Stitcher construction and the assignment above, its onTerminalTransition saw a null field
 * top-K rows.  
 * <h3>Phase C — gather (Java)</h3>  
        // Fetch projection sent to the data node: ___row_id (required by the data-node
                        + vsr.getSchema()
            this.shardLabel = shardLabel;
 *
import org.opensearch.analytics.exec.PendingExecutions;
 *      │   K rows of [sort_cols, ___row_id, ___ugsi]  
 * </ol>
        if (s != null) {
     * to others. {@link ConcurrentHashMap} because PendingExecutions callbacks run on
     * {@link Stitcher} (which copies cells into the output VSR at the row's sort-order
        // firing would strand the task. This mirrors the K==0 branch below, which likewise settles
 * full input is available — block-read it.
     * <p>FIXME assumes single-alternative shard plan, or all alternatives agree on backendId.
     */
     * Phase D output for the parent stage. Parent stage (Post-Sort) reads from this
        private final String shardLabel;  
 * {@code stage.getStageId()} for correlation, {@code config.parentTask()} for cancel  
 *      │   stitched K rows
     */
            FetchByRowIdsRequest request = new FetchByRowIdsRequest(
 * <pre>
                drainedUgsis[position] = ugsis.get(i);  
            Exception failure = this.stitcher.surfaceableFailure();
            return true;
 *
        }
        return childInputBuffer;
            try {
 * <ol>  
        this.config = config;
        // NotifyOnceListener regardless, so this can never double-fire.
        ExchangeSink parentSink,  
        this.runner = new LocalTaskRunner(config.localTaskExecutor());
 *   <li>{@link StageExecution.State#SUCCEEDED} — every fetch returned, every stitched batch  
import org.apache.arrow.vector.BigIntVector;
     * countdown never reaches zero and {@code finish} never runs, pinning {@code output}'s buffers
        // Publish the stitcher BEFORE any shard dispatch so onTerminalTransition (which may fire on a
        // the listener directly. onComplete (which also fires outerListener) can no longer run here
 * lookup (see {@code ShardScanInstructionHandler} for the registration pattern; the  
import org.opensearch.analytics.exec.QueryContext;
        private final Stitcher stitcher;  
        logger.debug("[LMStage] phase-B stageId={} shards={}", getStageId(), plans.size());
import org.opensearch.analytics.spi.DataConsumer;
 * wrapper's {@link OpenSearchLateMaterialization#getAboveAnchorPhysicalFields()} from each shard's  
     * Releases the stitcher's pre-allocated output VSR on any terminal transition. The stitcher
            String shardLabel = target.node().getId() + "/" + target.shardId().getIndexName() + "/shard[" + target.shardId().getId() + "]";
     *
     * arbitrary transport threads.
     * Phase B. Partitions the drained flat arrays by {@code ___ugsi} into one  
    /**  
 *   <li>{@link ShardFragmentStageExecution} — closest existing analogue for transport
import org.opensearch.analytics.exec.stage.shard.ShardFragmentStageExecution;
    public ExchangeSource outputSource() {  
    /** Drained {@code ___row_id} per row, indexed by sort-order position. Populated by Phase A. */
                return false;  
            // the profile emits one TaskProfile per shard rather than clobbering all but the last.
        private final ShardFetchPlan plan;
                config.queryId(),
    /** Per-shard fetch plans keyed by {@code ___ugsi}. Built by Phase B. */
    private final RowProducingSink childInputBuffer = new RowProducingSink();
        }
    public LateMaterializationStageExecution(  
 *   <li>{@link StageExecution.State#CREATED} — built by {@code LateMaterializationStageExecutionFactory};
     * exercised.
        long[] sortedRowIds = new long[n];  
                target.node().getId(),
                plan.rowIds(),  
                        + OpenSearchLateMaterialization.UGSI_FIELD
            // Fetch failure is terminal for the QTF query. The parent reduce stream may otherwise  
                stitcher.shardFailed(e);
     * <p>Order contract with the data node: {@code AnalyticsSearchService.executeFetchByRowIds}
     *
     * the parent sink without producing output rows so the surrounding wiring stays
    private void drainAndClose(ActionListener<Void> listener) {
import org.opensearch.analytics.exec.action.FragmentExecutionArrowResponse;  
            this.task = task;  
import java.util.HashMap;
 * </pre>
    }
 *   child stage (Sort+Limit COORDINATOR_REDUCE)
     * <p>Two passes over the flat arrays: one to count rows per shard so we can
        }  
     */  
    }
 * <h3>Phase B — scatter fetch by {@code ___ugsi} (Java + transport)</h3>  
    /** Total rows drained from the child (= K, ≤ anchor's LIMIT). */
    private long[] drainedRowIds;
     * Per-shard streaming response listener: forwards each Arrow batch to the  
 *  
        Integer[] order = new Integer[n];
 *       type.</li>
        private final StageTask task;
        Stitcher stitcher = new Stitcher(config.bufferAllocator(), outputFields, drainedRowCount, plansByUgsi.size(), parentSink, () -> {  
        if (targetsByUgsi == null) {  
 * <p>Walk {@code rowPos = 0..K-1}, building output batches with schema
                stitcher.acceptBatch(batch, plan.positions(), rowsCopiedSoFar);
        }
 *
        }  
import org.opensearch.analytics.backend.ExchangeSource;
                n -> new PendingExecutions(config.maxConcurrentShardRequestsPerNode())
        // Close the publication race: if a terminal transition already fired while we were between
    private int[] drainedUgsis;
    /**
        });
            // drainAndClose returns immediately after dispatching shards; the outer  
 *       SUCCEEDED. The cascade in {@code PlanWalker} fires {@link #start}; we drain the
        // because no shards are dispatched, and LocalTaskRunner wraps outerListener in a  
    private final Map<String, PendingExecutions> pendingByNodeId = new ConcurrentHashMap<>();
            columns[i + 1] = aboveFields.get(i).getName();
            int ugsiIdx = vsr.getSchema().getFields().indexOf(vsr.getSchema().findField(OpenSearchLateMaterialization.UGSI_FIELD));
import org.opensearch.analytics.planner.rel.OpenSearchLateMaterialization;  
     * Phase C + D combined. Builds a {@link Stitcher} sized to {@link #drainedRowCount},  
    /**
        if (parentSink instanceof ExchangeSource source) {
            stitcher.close();  
        for (int i = 0; i < drainedRowCount; i++) {
            this.stitcher = stitcher;
 * <h3>Phase A — drain reduce output (Java)</h3>  
            if (target == null) {  
import org.opensearch.analytics.planner.dag.ShardExecutionTarget;
import org.opensearch.core.tasks.TaskCancelledException;  
            listener.onFailure(e);
    /**
     * gets its own concurrency budget so a slow shard on one node can't block dispatches  
 * {@link org.opensearch.analytics.exec.action.FragmentExecutionAction} — define
     * sink must be the same one we drain in {@link #start}.  
        for (Map.Entry<Integer, Integer> e : sizesByUgsi.entrySet()) {
import java.util.ArrayList;
 * doc-id mapped row, returning {@code (rowPos, fetched_col_values)} batches.
import org.apache.arrow.vector.types.pojo.Field;
 * <p>The child stage's reduced K rows are buffered in its
    @Override
            stitcher.shardFailed(e);  
        // Stitcher constructor already allocated that VSR on the coordinator allocator, so any window
            }
    private final QueryContext config;
     * lookup state for other stages is a placeholder seam, not the long-term shape.
        for (int i = 0; i < n; i++)  
     * primitive arrays indexed by sort-order position. Reduce-set columns are discarded.
            if (failure == null) {
     */  
import org.apache.calcite.rel.type.RelDataTypeField;
            // task entries read the same as SHARD_FRAGMENT shard tasks. Includes the index name
     * {@code config.getResolvedTargets(shardStageId)}.  
 * The OpenSearch Contributors require contributions made to  
        Map<Integer, Integer> cursorByUgsi = new HashMap<>(sizesByUgsi.size());  
     * position), tracks {@code rowsCopiedSoFar} across batches, and signals shard
            } catch (Exception e) {
 * come from the buffered Phase A batches; fetched cols from the Phase C map. Feed
 * count hits zero, transition to Phase D.  
     */  
            cursorByUgsi.put(e.getKey(), 0);
    }
        GatherListener(Stitcher stitcher, ShardFetchPlan plan, StageTask task, String shardLabel) {  
            // blocking dispatches to other nodes.
            sortedPositions[i] = positions[order[i]];
import org.opensearch.analytics.exec.stage.coordinator.LocalStageTask;
            // observe its inputs as ordinary EOF and complete the top-level PPL request before
        }  
     * timeout, or an upstream failure — while a shard's fetch stream is still outstanding, that
    private final String fetchBackendId;
     * <p>Phases B/C/D will follow in subsequent commits; for now Phase A populates
            int rows = vsr.getRowCount();  
     * which backend it picked during the query phase so the fetch goes to the same one.  
            sortedRowIds[i] = rowIds[order[i]];  
        try {
     * keyed by {@code ___ugsi}. Each plan carries parallel {@code long[] rowIds} +
                // no longer needed and their query-allocator buffers must be released here.
                drainedRowIds[position] = rowIds.get(i);
        drainedUgsis = new int[K];  
 * fetch-by-rowid handler is a sibling, not a fragment-instruction).
            cancellable.cancel();  
            int ugsi = entry.getKey();  
    public ExchangeSink inputSink(int childStageId) {  
 * rowPos, FetchedRowCells>}. As each response arrives, decode batches, write per-row  
                position++;
     * Stage id of the SHARD_FRAGMENT descendant whose resolved targets feed our fetch
                if (batch != null) batch.close();
     * {@code positions} arrays are sorted by {@code rowId} ascending — required by the
 * {@code FetchByRowIdAction}, request and response types, register on
            cursorByUgsi.put(ugsi, cur + 1);
    @Override
     * <p>HACK: this id is paired with the side-table on {@link QueryContext} to map
            IntVector ugsis = (IntVector) vsr.getVector(ugsiIdx);
import java.util.Map;  
 * </pre>
            outerListener.onFailure(new TaskCancelledException("late materialization stage terminated before fetch dispatch"));
    /**  
    private static final class GatherListener implements StreamingResponseListener<FragmentExecutionArrowResponse> {
        int[] sortedPositions = new int[n];
 */  
                // batch's query-allocator buffers stays with this listener.  
 * compatible open source license.
     * {@link AnalyticsSearchTransportService#dispatchFetchByRowIds}, and lets the per-shard
        }
        this.stitcher = stitcher;  
     *
                fetchBackendId,
package org.opensearch.analytics.exec.stage;
            for (int i = 0; i < rows; i++) {
    // volatile: set on the drain thread in scatterFetchAndStitch, read by onTerminalTransition
    }
        // Output schema: aboveAnchorPhysicalFields converted to Arrow Fields. ___row_id is  
 * <p>{@link #cancel(String)} cancels the parent task — propagates to in-flight fetch
        logger.info(
    private Map<Integer, ShardFetchPlan> plansByUgsi;
import java.util.List;
        // CAS-then-read-stitcher saw our published field (and closed output), or our set-then-read-state
            int cur = cursorByUgsi.get(ugsi);
import org.opensearch.cluster.service.ClusterService;
            if (trailingMetadata != null && task != null) {
     * (0..K-1) — used by the stitcher to place fetched cells back into sort order.  
            // Shard label matches QueryProfileBuilder#describeTarget so the LM profile's per-shard
            } catch (Exception ignore) {}  
 */  
        }
            if (rowIdIdx < 0 || ugsiIdx < 0) {  
 *       // each batch has schema [sort_cols, ___row_id, ___ugsi]
     */
 * dispatched. For each {@code (nodeId, list of (___row_id, rowPos))}, send a
    /** Drained {@code ___ugsi} per row, indexed by sort-order position. Parallel to {@link #drainedRowIds}. */
            rowIdsByUgsi.get(ugsi)[cur] = drainedRowIds[i];  
 * <p>This stage orchestrates the four QTF phases internally — there is no Substrait  
    @Override
            }  
     * {@link GatherListener}s feed batches into the stitcher as they arrive. The stitcher  
        int position = 0;
 * {@link org.opensearch.analytics.exec.AnalyticsSearchTransportService}.  
     * source after we transition to SUCCEEDED.  
            outerListener.onResponse(null);
    private final ClusterService clusterService;
     * was ever created (K=0 or a pre-stitch failure).  
        }  
    }
        int n = rowIds.length;  
     * Per-node PendingExecutions, mirroring {@code ShardTaskRunner}'s pattern. Each node
    protected List<StageTask> materializeTasks() {
     * dispatch. Walked once at construction; used in Phase C to look up
            order[i] = i;
        for (VectorSchemaRoot vsr : childInputBuffer.readResult()) {  
            } finally {
        logger.debug("[LMStage] phase-A stageId={} drainedRows={}", getStageId(), drainedRowCount);
                new GatherListener(stitcher, plan, tasks().get(0), shardLabel),
        this.parentSink = parentSink;
    }  
 *
import org.apache.logging.log4j.LogManager;  
 *       reduce output, feeds parent."</li>
     * BackendId honored by the data node when serving fetches. Resolved by the factory
import org.opensearch.analytics.planner.dag.Stage;
            } else {
        public void onFailure(Exception e) {
     * <p>Pre-sizes the arrays via {@link RowProducingSink#getRowCount()} — the sink  
        }
     * stream-decode rather than block-buffer.
        for (RelDataTypeField f : aboveFields) {
    /**
            // the last shard's response stream terminates.
import org.apache.arrow.vector.VectorSchemaRoot;  
     * and {@link ExchangeSource}); a custom sink may be needed if Phase A wants to
            int ugsi = drainedUgsis[i];
     * {@code int[] positions} arrays where {@code position} is the row's sort-order index
import org.opensearch.analytics.exec.action.FetchByRowIdsRequest;
import org.apache.arrow.vector.IntVector;
        private int rowsCopiedSoFar;
 *
 *       child's output, fan out fetches, stitch, feed the parent's input sink.</li>
import org.opensearch.analytics.exec.stage.coordinator.LocalTaskRunner;
        }
        System.arraycopy(sortedPositions, 0, positions, 0, n);
        // LocalStageTask), and a stage cancel does NOT fire it independently — so returning without  
            ShardExecutionTarget target = targetsByUgsi.get(ugsi);
        return List.of(new LocalStageTask(new StageTaskId(getStageId(), 0), this::drainAndClose));  
                "No resolved targets for shardStageId=" + shardStageId + " — shard fragment stage didn't record targets"
    record ShardFetchPlan(int ugsi, long[] rowIds, int[] positions) {
        Map<Integer, int[]> positionsByUgsi = new HashMap<>(sizesByUgsi.size());
     *
        List<RelDataTypeField> aboveFields = wrapper.getAboveAnchorPhysicalFields();
 * <h2>Lifecycle</h2>
            } finally {
 *  
 * <h2>Cancellation</h2>
 * SPDX-License-Identifier: Apache-2.0
        drainedRowCount = position;
            long[] rowIds = rowIdsByUgsi.get(ugsi);  
    @Override
                config.parentTask(),  
 * <p><b>New transport action required.</b> Mirror  
     */
            }
 *       Arrow-streaming RPC; the fetch transport is similar but with a different request
            if (isLast) stitcher.shardComplete();  
            // onTerminalTransition; closing here races its reduce() task ("sink closed before reduce").
        @Override
        @Override
     */
            return;
 *
        // sees the terminal here — output is freed exactly once on this racing-cancel path.  
     * for typical per-shard N (= K/numShards ≤ a few thousand).  
 *       buffer.add(batch);  // takes ownership; close on terminal
     * {@code finish} already emitted (ownership transferred to {@code parentSink}, and
                childInputBuffer.close();
        int K = (int) total;
    /** Wrapper RelNode pulled from the stage's fragment — carries aboveAnchorPhysicalFields + aboveAnchorPhysicalFieldStorage. */  
     * arrives in the same ascending order, and Phase D writes each response cell into
 *   for (VectorSchemaRoot batch : src.readResult()) {  
    private final int shardStageId;
 * <p>Group rows by {@code ___ugsi} ordinal. Map each ordinal → (nodeId, shardId,
     * data node's fetch contract (ascending input rowIds, ascending response order).  
        } catch (Exception e) {  
            sizesByUgsi.merge(drainedUgsis[i], 1, Integer::sum);
        public void onStreamComplete(byte[] trailingMetadata) {
     * parallel arrays Phase B will then walk to build its per-shard plans.  
 *
 * </ul>  
     * stage execution drains this sink at {@link #start} time. Today a
 *
 * @opensearch.internal
            int[] positions = positionsByUgsi.get(ugsi);
     *  
 * this file be licensed under the Apache-2.0 license or a
    }
     * sort-order position in the LM stage's drained-row index for {@code rowIds[j]}.  
                target.shardId(),
