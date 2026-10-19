     * sort-order position in the LM stage's drained-row index for {@code rowIds[j]}.
    }
 * parentSink and transition to {@link StageExecution.State#SUCCEEDED}.
            // observe its inputs as ordinary EOF and complete the top-level PPL request before
        String[] columns = new String[aboveFields.size() + 1];
 *   child stage (Sort+Limit COORDINATOR_REDUCE)
 *
import org.opensearch.analytics.exec.QueryContext;
            // Per-node PendingExecutions: mirrors ShardTaskRunner — keeps a slow node from
                return false;
 * {@link UnsupportedOperationException}. The four phases below are the work to land:
 * {@link org.opensearch.analytics.exec.AnalyticsSearchTransportService}.
     * (0..K-1) — used by the stitcher to place fetched cells back into sort order.
     * fires one async {@link FetchByRowIdsRequest} per shard via
                stage.getStageId(),
     * allocate exactly-sized per-shard arrays, one to fill them. No per-row boxing.
        List<RelDataTypeField> aboveFields = wrapper.getAboveAnchorPhysicalFields();
     * {@code positions} arrays are sorted by {@code rowId} ascending — required by the
            ShardFetchPlan plan = entry.getValue();
            outerListener.onFailure(new TaskCancelledException("late materialization stage terminated before fetch dispatch"));
 * compatible open source license.
        // LocalStageTask), and a stage cancel does NOT fire it independently — so returning without
     *
     * {@link Stitcher} (which copies cells into the output VSR at the row's sort-order
import java.util.Map;
            try {
 * come from the buffered Phase A batches; fetched cols from the Phase C map. Feed
        GatherListener(Stitcher stitcher, ShardFetchPlan plan, StageTask task, String shardLabel) {
            "[LMStage] CREATED stageId={} aboveAnchorPhysicalFieldCount={} backendId={}",
                drainedRowIds[position] = rowIds.get(i);
    @Override
     * completes — no blocking on this thread.
            }
     * position), tracks {@code rowsCopiedSoFar} across batches, and signals shard
            }
                n -> new PendingExecutions(config.maxConcurrentShardRequestsPerNode())
 * </ul>
            this.task = task;
        Stitcher s = this.stitcher;
            if (trailingMetadata != null && task != null) {
 * <h3>Phase A — drain reduce output (Java)</h3>
        }
     * {@link GatherListener}s feed batches into the stitcher as they arrive. The stitcher
     */
import org.apache.arrow.vector.IntVector;
     * <p>Pre-sizes the arrays via {@link RowProducingSink#getRowCount()} — the sink
 *
        QueryContext config,
import org.opensearch.analytics.exec.stage.coordinator.LocalStageTask;
            }
            fetchBackendId
                // Stitcher.acceptBatch only reads + copyFromSafe; ownership of the response
        // Fetch projection sent to the data node: ___row_id (required by the data-node
    /**
     * {@code ___row_id} and {@code ___ugsi} per row, and groups into per-shard fetch plans
     */
 *      │  Phase C: gather per-node fetch results (Java)
    /**
            this.plan = plan;
 * stripped per {@link OpenSearchLateMaterialization} contract). Each row's sort cols
            positionsByUgsi.get(ugsi)[cur] = i;
        List<Field> outputFields = new ArrayList<>(aboveFields.size());
 * Backend-specific: DataFusion's parquet reader can produce these from a Lucene docId
    }
 *
 *
     *
import org.opensearch.analytics.spi.ExchangeSink;
        }
                outerListener.onFailure(failure);
     */
     * requires ascending rowIds in the request and the native side returns rows in the same
                outerListener.onResponse(null);
     * Releases the stitcher's pre-allocated output VSR on any terminal transition. The stitcher
        // Stitcher constructor already allocated that VSR on the coordinator allocator, so any window
        super(stage, config.queryId(), config.operationListeners(), config.parentTask());
 *       buffer.add(batch);  // takes ownership; close on terminal
    @Override
 * <pre>
 *
        }
     * arbitrary transport threads.
     * from the SHARD_FRAGMENT descendant's first plan alternative.
    private final AnalyticsSearchTransportService transport;
 * <p>{@link #cancel(String)} cancels the parent task — propagates to in-flight fetch
 * <h2>Cancellation</h2>
 * <h3>Phase D — stitch and feed parent (Java)</h3>
    // which may fire on a different thread (cancel / timeout / upstream failure).
                );
    protected void onTerminalTransition(State terminal) {
 * <pre>
            positionsByUgsi.put(e.getKey(), new int[e.getValue()]);
     * lookup state for other stages is a placeholder seam, not the long-term shape.
     * Per-shard fetch plan: {@code rowIds} sorted ascending, {@code positions[j]} the
        long total = childInputBuffer.getRowCount();
        this.transport = transport;
 * <p>The child stage's reduced K rows are buffered in its
    /**
     * {@link RowProducingSink} works as a buffer (it implements both {@link ExchangeSink}
     * ascending order. Phase B will sort each plan's {@code (rowIds, positions)} as a unit
        this.clusterService = clusterService;
     * gets its own concurrency budget so a slow shard on one node can't block dispatches
 * </pre>
     * {@code int[] positions} arrays where {@code position} is the row's sort-order index
 * <p>Group rows by {@code ___ugsi} ordinal. Map each ordinal → (nodeId, shardId,
                config.parentTask(),
     * <p>Returned by {@link #inputSink(int)}; the child stage writes K rows here. The
    }
 * {@code FetchByRowIdAction}, request and response types, register on
     * triggers {@code outerListener.onResponse} (or {@code onFailure}) when the last shard
            return source;
            // onTerminalTransition; closing here races its reduce() task ("sink closed before reduce").
        throw new UnsupportedOperationException("parentSink does not implement ExchangeSource: " + parentSink.getClass().getSimpleName());
 *      │  Phase B: scatter fetch by ___ugsi      (Java + transport)
import org.opensearch.cluster.service.ClusterService;
            cursorByUgsi.put(ugsi, cur + 1);
 *
                childInputBuffer.close();
    }
        }
import org.apache.logging.log4j.Logger;
            BigIntVector rowIds = (BigIntVector) vsr.getVector(rowIdIdx);
            ShardExecutionTarget target = targetsByUgsi.get(ugsi);
            this.stitcher = stitcher;
     * {@link #drainedRowIds} / {@link #drainedUgsis} / {@link #drainedRowCount} and closes
import org.opensearch.analytics.exec.RowProducingSink;
     * When multi-backend per-shard plans become real the data node will need to feed back
        // firing would strand the task. This mirrors the K==0 branch below, which likewise settles
        private int rowsCopiedSoFar;
            for (int i = 0; i < rows; i++) {
     *
        }
 */
            );
     * <p>Despite the name, the actual partition-by-{@code ___ugsi} into per-shard fetch
            if (isLast) stitcher.shardComplete();
 *   <li>{@link StageExecution.State#RUNNING} — entered when the child Sort+Limit stage
     * data node's fetch contract (ascending input rowIds, ascending response order).
                stitcher.shardFailed(new IllegalStateException("No resolved target for ugsi=" + ugsi));
     * {@link AnalyticsSearchTransportService#dispatchFetchByRowIds}, and lets the per-shard
    // volatile: set on the drain thread in scatterFetchAndStitch, read by onTerminalTransition
     */
            throw new IllegalStateException(
 *       SUCCEEDED. The cascade in {@code PlanWalker} fires {@link #start}; we drain the
 *       fan-out + per-shard response handling.</li>
        // the listener directly. onComplete (which also fires outerListener) can no longer run here
    /**
        }
        }
 * {@link RowProducingSink}-style output (arriving via {@code feed(VSR)} on whatever
                        + OpenSearchLateMaterialization.UGSI_FIELD
     * which backend it picked during the query phase so the fetch goes to the same one.
            // because shard IDs are only unique within an index.
            int ugsi = drainedUgsis[i];
        if (s != null) {
import org.opensearch.analytics.planner.ArrowCalciteTypes;
     */
        if (n <= 1) return;
 *   parent stage (Post-Sort)
     */
 *       reduce output, feeds parent."</li>
        if ((terminal == State.CANCELLED || terminal == State.FAILED) && parentSink instanceof CancellableExchangeSink cancellable) {
            );
        // Publish the stitcher BEFORE any shard dispatch so onTerminalTransition (which may fire on a
    /**
                    "LM stage drain expected ["
                // no longer needed and their query-allocator buffers must be released here.
 *
 *
     * lookup map needed.
        for (Map.Entry<Integer, Integer> e : sizesByUgsi.entrySet()) {
     * <p>Phases B/C/D will follow in subsequent commits; for now Phase A populates
    private final RowProducingSink childInputBuffer = new RowProducingSink();
        Map<Integer, ShardExecutionTarget> targetsByUgsi = config.getResolvedTargets(shardStageId);
                        + ", "
import org.opensearch.analytics.exec.AnalyticsSearchTransportService;
 * fragment and no DataFusion compute. The stage sits above a Sort+Limit reduce stage
 * @opensearch.internal
        ClusterService clusterService,
 * <p>This stage orchestrates the four QTF phases internally — there is no Substrait
        for (int i = 0; i < drainedRowCount; i++) {
import org.opensearch.analytics.exec.StreamingResponseListener;
 * dispatched. For each {@code (nodeId, list of (___row_id, rowPos))}, send a
                config.profile()
    private static final Logger logger = LogManager.getLogger(LateMaterializationStageExecution.class);
     * <p>FIXME assumes single-alternative shard plan, or all alternatives agree on backendId.
 *
 *   <li>{@link ReduceStageExecution} — closest existing analogue for "consumes child's
import org.apache.logging.log4j.LogManager;
import java.util.HashMap;
     * {@code ___ugsi → (DiscoveryNode, ShardId)}. See {@code QueryContext.resolvedTargetsByStage}
    public ExchangeSink inputSink(int childStageId) {
            String shardLabel = target.node().getId() + "/" + target.shardId().getIndexName() + "/shard[" + target.shardId().getId() + "]";
        if (total > Integer.MAX_VALUE) {
 *
                // Drain copied helper columns into primitive arrays; the buffered VSRs are
 * full input is available — block-read it.
            s.close();
        if (parentSink instanceof ExchangeSource source) {
 * <h2>Cross-references</h2>
        } catch (Exception e) {
    ) {
    }
        System.arraycopy(sortedRowIds, 0, rowIds, 0, n);
 *   ExchangeSource src = (ExchangeSource) downstreamSink;   // see inputSink() below
     * <p>Order contract with the data node: {@code AnalyticsSearchService.executeFetchByRowIds}
            } finally {
 *       carries {@code getAboveAnchorPhysicalFields()} (List&lt;RelDataTypeField&gt;) and
     * on the long-lived coordinator allocator. Closing here guarantees release; it is a no-op when
 * <h3>Phase C — gather (Java)</h3>
                request,
 * <p><b>New transport action required.</b> Mirror
 *   }
        @Override
     *
     * batches (already in sort order) and copies the helper columns into two parallel
            if (rowIdIdx < 0 || ugsiIdx < 0) {
        // because no shards are dispatched, and LocalTaskRunner wraps outerListener in a
        this.wrapper = RelNodeUtils.findNode(stage.getFragment(), OpenSearchLateMaterialization.class);
/**
    private void scatterFetchAndStitch(ActionListener<Void> outerListener) throws Exception {
 *      │   stitched K rows
     */
     * Phase D output for the parent stage. Parent stage (Post-Sort) reads from this
     * Sorts {@code rowIds} ascending in place, permuting {@code positions} along.
    private final Map<String, PendingExecutions> pendingByNodeId = new ConcurrentHashMap<>();
     */
            try {
        Map<Integer, Integer> sizesByUgsi = new HashMap<>();
            // Shard label matches QueryProfileBuilder#describeTarget so the LM profile's per-shard
            // Each shard's fetch reports its own metrics/physical plan. Keyed by shardLabel so
            sortParallelByRowIdAscending(rowIds, positions);
        }
        // contract — see AnalyticsSearchService.executeFetchByRowIds) + the physical fields
                        + vsr.getSchema()
     * {@link Stitcher#close} / {@code VectorSchemaRoot#close} are idempotent), and when no stitcher
    /** Total rows drained from the child (= K, ≤ anchor's LIMIT). */
import org.opensearch.analytics.spi.CancellableExchangeSink;
    }
        long[] sortedRowIds = new long[n];
                task.addShardMetrics(shardLabel, trailingMetadata);
            order[i] = i;
    public LateMaterializationStageExecution(
        // and skipped the close. Re-check here and release output now that the field is published.
    /**
 *
            }
     */
 *   for (VectorSchemaRoot batch : src.readResult()) {
     *
public final class LateMaterializationStageExecution extends AbstractStageExecution implements DataConsumer, DataProducer {
                drainedUgsis[position] = ugsis.get(i);
            );
        public boolean onStreamResponse(FragmentExecutionArrowResponse response, boolean isLast) {
            Exception failure = this.stitcher.surfaceableFailure();
                target.node().getId(),
            listener.onFailure(e);
 * cells keyed by {@code rowPos}. Use an {@link java.util.concurrent.atomic.AtomicInteger}
     * allocates {@code output} on the coordinator allocator up front and only frees it when
        int[] sortedPositions = new int[n];
    static void sortParallelByRowIdAscending(long[] rowIds, int[] positions) {
            long[] rowIds = rowIdsByUgsi.get(ugsi);
     * to others. {@link ConcurrentHashMap} because PendingExecutions callbacks run on
        return List.of(new LocalStageTask(new StageTaskId(getStageId(), 0), this::drainAndClose));
     *
        for (int i = 0; i < drainedRowCount; i++) {
    /** Drained {@code ___row_id} per row, indexed by sort-order position. Populated by Phase A. */
 *
        System.arraycopy(sortedPositions, 0, positions, 0, n);
    /**
 *
 * top-K rows.
 * </pre>
 * sink the LM stage provides via {@link #inputSink(int)}). At {@link #start} time the
 * <h2>Implementation status</h2>
import org.opensearch.analytics.planner.dag.ShardExecutionTarget;
            // the profile emits one TaskProfile per shard rather than clobbering all but the last.
 *      │   K rows of [sort_cols, ___row_id, ___ugsi]
            int cur = cursorByUgsi.get(ugsi);
     * {@code config.getResolvedTargets(shardStageId)}.
 * {@code [sort_cols, fetch_cols...]} (helper columns {@code ___row_id} + {@code ___ugsi}
            wrapper.getAboveAnchorPhysicalFields().size(),
 * <ul>
import org.opensearch.analytics.backend.ExchangeSource;
        private final StageTask task;
 *   <li>{@link AnalyticsSearchTransportService#dispatchFragmentStreaming} — pattern for
                continue;
     * Phase C + D combined. Builds a {@link Stitcher} sized to {@link #drainedRowCount},
            try {
     * the parent sink without producing output rows so the surrounding wiring stays
 *
            // Fetch failure is terminal for the QTF query. The parent reduce stream may otherwise
        this.runner = new LocalTaskRunner(config.localTaskExecutor());
import org.opensearch.core.tasks.TaskCancelledException;
 *
     * countdown never reaches zero and {@code finish} never runs, pinning {@code output}'s buffers
import org.opensearch.analytics.exec.action.FragmentExecutionArrowResponse;
     * Sink the child Sort+Limit stage feeds into (Phase A input).
        int K = (int) total;
        AnalyticsSearchTransportService transport,
 * <h2>Lifecycle</h2>
        }
     * and exact. No need to walk the batches twice.
                target.shardId(),
 * batches into {@link #parentSink}. On EOF call {@link ExchangeSink#close()} on
 * transports and the (already-completed) child stage. Mirrors
        Map<Integer, ShardFetchPlan> plans = new HashMap<>(sizesByUgsi.size());
import org.opensearch.analytics.exec.PendingExecutions;
     * stream-decode rather than block-buffer.
        //
        try {
    }
            return;
     * exercised.
        String fetchBackendId
        this.shardStageId = shardStageId;
            transport.dispatchFetchByRowIds(
    /**
    /** Per-shard fetch plans keyed by {@code ___ugsi}. Built by Phase B. */
    record ShardFetchPlan(int ugsi, long[] rowIds, int[] positions) {
import java.util.concurrent.ConcurrentHashMap;
     * BackendId honored by the data node when serving fetches. Resolved by the factory
        ExchangeSink parentSink,
                stitcher.shardFailed(e);
import org.opensearch.analytics.spi.DataConsumer;
                new GatherListener(stitcher, plan, tasks().get(0), shardLabel),
 *       fed to the parent sink, parent stage can start.</li>
    @Override
        int shardStageId,
        if (getState().isTerminal()) {
    private final QueryContext config;
     */
            FetchByRowIdsRequest request = new FetchByRowIdsRequest(
     * Stage id of the SHARD_FRAGMENT descendant whose resolved targets feed our fetch
 *   <li>{@link OpenSearchLateMaterialization} — wrapper RelNode in the stage's fragment;
                columns,
     * for the rationale and revisit conditions — short version: stages leaving
     * <p>Two passes over the flat arrays: one to count rows per shard so we can
        }
        for (int i = 0; i < n; i++)
        private final String shardLabel;
     * {@code finish} already emitted (ownership transferred to {@code parentSink}, and
    private Map<Integer, ShardFetchPlan> groupByUgsi() {
 * {@code stage.getStageId()} for correlation, {@code config.parentTask()} for cancel
        @Override
        int n = rowIds.length;
                        + OpenSearchLateMaterialization.ROW_ID_FIELD
 *   LateMaterializationStageExecution
            );
import java.util.ArrayList;
    }
        drainedUgsis = new int[K];
        private final ShardFetchPlan plan;
     * was ever created (K=0 or a pre-stitch failure).
        for (Map.Entry<Integer, ShardFetchPlan> entry : plansByUgsi.entrySet()) {
 * QTF (Query-Then-Fetch / late-materialization) Scatter-Gather stage execution.
                        + "] in batch schema; got "
            cancellable.cancel();
    private final ExchangeSink parentSink;
import org.opensearch.analytics.planner.dag.Stage;
        // concurrent cancel thread) can always find it and close its pre-allocated output VSR. The
            stitcher.shardFailed(e);
    /** Stashed for the {@code onComplete} closure to read {@link Stitcher#surfaceableFailure()}. */
 * {@code FetchByRowIdRequest} via {@link #transport}. Use
        logger.info(
 * fetch-by-rowid handler is a sibling, not a fragment-instruction).
     * Per-shard streaming response listener: forwards each Arrow batch to the
    /** Drained {@code ___ugsi} per row, indexed by sort-order position. Parallel to {@link #drainedRowIds}. */
import org.apache.arrow.vector.types.pojo.Field;
                target.node(),
            }
        public void onStreamComplete(byte[] trailingMetadata) {
        Stitcher stitcher = new Stitcher(config.bufferAllocator(), outputFields, drainedRowCount, plansByUgsi.size(), parentSink, () -> {
        }
        Map<Integer, Integer> cursorByUgsi = new HashMap<>(sizesByUgsi.size());
        // CAS-then-read-stitcher saw our published field (and closed output), or our set-then-read-state
        Map<Integer, int[]> positionsByUgsi = new HashMap<>(sizesByUgsi.size());
            int rows = vsr.getRowCount();
            VectorSchemaRoot batch = response.getRoot();
 */
        // Stitcher construction and the assignment above, its onTerminalTransition saw a null field
            // this asynchronous failure reaches the query listener.
            } finally {
     * primitive arrays indexed by sort-order position. Reduce-set columns are discarded.
            int ugsiIdx = vsr.getSchema().getFields().indexOf(vsr.getSchema().findField(OpenSearchLateMaterialization.UGSI_FIELD));
    private long[] drainedRowIds;
     * for typical per-shard N (= K/numShards ≤ a few thousand).
 *   <li>{@link StageExecution.State#SUCCEEDED} — every fetch returned, every stitched batch
import org.apache.arrow.vector.BigIntVector;
     * dispatch. Walked once at construction; used in Phase C to look up
    private static final class GatherListener implements StreamingResponseListener<FragmentExecutionArrowResponse> {
     */
     * Per-node PendingExecutions, mirroring {@code ShardTaskRunner}'s pattern. Each node
            );
        Map<Integer, long[]> rowIdsByUgsi = new HashMap<>(sizesByUgsi.size());
            IntVector ugsis = (IntVector) vsr.getVector(ugsiIdx);
    /**
    private final int shardStageId;
     * {@code stitched[positions[j]]}.
        if (drainedRowCount == 0) {
     * plans is Phase B's job; here we only flatten the helper columns into the two
    private int drainedRowCount;
 * <p>Per-node responses arrive out of order. Maintain a {@code ConcurrentHashMap<Integer
            outputFields.add(ArrowCalciteTypes.toArrowField(f.getName(), f.getType()));
 *       Arrow-streaming RPC; the fetch transport is similar but with a different request
            // task entries read the same as SHARD_FRAGMENT shard tasks. Includes the index name
    private final String fetchBackendId;
        }
    private int[] drainedUgsis;
                if (batch != null) batch.close();
        this.stitcher = stitcher;
 * <h3>Phase B — scatter fetch by {@code ___ugsi} (Java + transport)</h3>
 *       {@code getAboveAnchorPhysicalFieldStorage()} (List&lt;FieldStorageInfo&gt;).</li>
            cursorByUgsi.put(e.getKey(), 0);
     * before dispatch; Phase C then walks request and response in lockstep — no per-row
        @Override
    protected List<StageTask> materializeTasks() {
        }
            PendingExecutions pending = pendingByNodeId.computeIfAbsent(
 * <p><b>Data-node handler required.</b> The handler reads the columns named in the
 *       // each batch has schema [sort_cols, ___row_id, ___ugsi]
                throw new IllegalStateException(
        for (int i = 0; i < n; i++) {
            scatterFetchAndStitch(listener);
        }
    /**
import java.util.Arrays;
            // ActionListener fires asynchronously via Stitcher's onComplete callback when
 * {@link ShardFragmentStageExecution#cancel(String)}.
     * Reads K rows of {@code [reduce-set, ___row_id, ___ugsi]} from the child input
    private volatile Stitcher stitcher;
    private final ClusterService clusterService;
            return true;
     * Phase C dispatches {@code rowIds} to shard {@code ugsi}'s data node; the response
 * (its only child) and below the parent stage that consumes the fully-materialized
 *      ▲                        ◄── feeds parent's input sink
 * indexUUID) using a coord-side side table built when the child stage's per-shard tasks
        }
                config.queryId(),
            } else {
            plans.put(ugsi, new ShardFetchPlan(ugsi, rowIds, positions));
                parentSink.close();
            // K=0: nothing to dispatch. Parent stage owns parentSink.close() via
            rowIdsByUgsi.put(e.getKey(), new long[e.getValue()]);
    private void drainAndGroupByUgsi() {
 * wrapper's {@link OpenSearchLateMaterialization#getAboveAnchorPhysicalFields()} from each shard's
import org.apache.arrow.vector.VectorSchemaRoot;
 *   <li>{@link StageExecution.State#CREATED} — built by {@code LateMaterializationStageExecutionFactory};
     * completion / failure to the stitcher's countdown.
     * {@link ShardFetchPlan} per shard. Each plan's parallel {@code rowIds} and
        // sees the terminal here — output is freed exactly once on this racing-cancel path.
        }
 * count hits zero, transition to Phase D.
            // drainAndClose returns immediately after dispatching shards; the outer
        // the user wants displayed.
        return plans;
    /**
        }
        logger.debug("[LMStage] phase-A stageId={} drainedRows={}", getStageId(), drainedRowCount);
 *
        Integer[] order = new Integer[n];
     */
 * doc-id mapped row, returning {@code (rowPos, fetched_col_values)} batches.
}
        }
 *
                "No resolved targets for shardStageId=" + shardStageId + " — shard fragment stage didn't record targets"
            int rowIdIdx = vsr.getSchema().getFields().indexOf(vsr.getSchema().findField(OpenSearchLateMaterialization.ROW_ID_FIELD));
 *      ▲                        ◄── filled by child Sort+Limit reduce
        this.parentSink = parentSink;
    /**
        logger.debug("[LMStage] phase-B stageId={} shards={}", getStageId(), plans.size());
 *
                fetchBackendId,
 * for in-flight count (mirrors {@link ShardFragmentStageExecution}'s pattern). When
 * rowPos, FetchedRowCells>}. As each response arrives, decode batches, write per-row
     * Phase A drain. Walks the child's buffered VSRs in arrival (sort) order, extracts
        // Close the publication race: if a terminal transition already fired while we were between
import org.opensearch.analytics.exec.stage.coordinator.LocalTaskRunner;
        columns[0] = OpenSearchLateMaterialization.ROW_ID_FIELD;
     * sink must be the same one we drain in {@link #start}.
        }
    }
            int[] positions = positionsByUgsi.get(ugsi);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.analytics.planner.rel.OpenSearchLateMaterialization;
            return;
     *
            }
 *       the parent (Post-Sort) stage's start is gated on this stage's SUCCEEDED.</li>
            this.shardLabel = shardLabel;
        Arrays.sort(order, (a, b) -> Long.compare(rowIds[a], rowIds[b]));
    }
            sizesByUgsi.merge(drainedUgsis[i], 1, Integer::sum);
            sortedPositions[i] = positions[order[i]];
    }
 * lookup (see {@code ShardScanInstructionHandler} for the registration pattern; the
 * this file be licensed under the Apache-2.0 license or a
 *      │  Phase D: stitch → emit                 (Java)
import org.opensearch.analytics.exec.action.FetchByRowIdsRequest;
        Stage stage,
                drainAndGroupByUgsi();
        }
import java.util.List;
 * {@link org.opensearch.analytics.exec.action.FragmentExecutionAction} — define
        for (int i = 0; i < aboveFields.size(); i++) {
     * keyed by {@code ___ugsi}. Each plan carries parallel {@code long[] rowIds} +
            if (failure == null) {
            sortedRowIds[i] = rowIds[order[i]];
 *       child's output, fan out fetches, stitch, feed the parent's input sink.</li>
                position++;
     */
     * {@link Stitcher#finish} runs (all shards reported). If the stage terminates — via cancel,
 *
            columns[i + 1] = aboveFields.get(i).getName();
        // Output schema: aboveAnchorPhysicalFields converted to Arrow Fields. ___row_id is
            } catch (Exception e) {
        private final Stitcher stitcher;
        for (VectorSchemaRoot vsr : childInputBuffer.readResult()) {
    /**
 *
        if (targetsByUgsi == null) {
                // batch's query-allocator buffers stays with this listener.
        for (RelDataTypeField f : aboveFields) {
        }
     * Indirect sort via an index array — ~O(N log N) with bounded extra allocation; fine
     * Phase B. Partitions the drained flat arrays by {@code ___ugsi} into one
        // state is an AtomicReference, so this read pairs with the CAS in transitionTo: either that
 * <p>Walk {@code rowPos = 0..K-1}, building output batches with schema
        public void onFailure(Exception e) {
                pending
 * </ol>
        if (this.wrapper == null) {
            // blocking dispatches to other nodes.
    /** Wrapper RelNode pulled from the stage's fragment — carries aboveAnchorPhysicalFields + aboveAnchorPhysicalFieldStorage. */
     * source after we transition to SUCCEEDED.
 * propagation.
     */
import org.opensearch.analytics.exec.stage.shard.ShardFragmentStageExecution;
     * maintains {@code totalRows} incrementally on each {@code feed()}, so this is O(1)
            stitcher.close();
                "LATE_MATERIALIZATION stage " + stage.getStageId() + " missing OpenSearchLateMaterialization marker in fragment"
        drainedRowCount = position;
            stage.getStageId(),
            int ugsi = entry.getKey();
     * <p>HACK: this id is paired with the side-table on {@link QueryContext} to map
 *       type.</li>
        });
            plansByUgsi = groupByUgsi();
     *
     * Phase A input. Child stage (Sort+Limit reduce) writes its K rows here. Returned
        // where the field is still null but output exists would leak it on a racing terminal.
        );
            rowIdsByUgsi.get(ugsi)[cur] = drainedRowIds[i];
import org.opensearch.core.action.ActionListener;
            if (target == null) {
 *
 * The OpenSearch Contributors require contributions made to
                plan.rowIds(),
        drainedRowIds = new long[K];
 * <ol>
 *      │  Phase A: drain reduce output           (Java)
            }
import org.apache.calcite.rel.type.RelDataTypeField;
package org.opensearch.analytics.exec.stage;
        // We must also settle outerListener: the task body owns firing the per-task listener (see
            // the last shard's response stream terminates.
import org.opensearch.analytics.exec.stage.coordinator.ReduceStageExecution;
            throw new IllegalStateException(
        for (Integer ugsi : sizesByUgsi.keySet()) {
 *   <li>{@link ShardFragmentStageExecution} — closest existing analogue for transport
     * stage execution drains this sink at {@link #start} time. Today a
        // NotifyOnceListener regardless, so this can never double-fire.
import org.opensearch.analytics.planner.RelNodeUtils;
                rowsCopiedSoFar += batch.getRowCount();
            } catch (Exception ignore) {}
    private Map<Integer, ShardFetchPlan> plansByUgsi;
    private void drainAndClose(ActionListener<Void> listener) {
/*
 * <p><b>SKELETON ONLY.</b> Today {@link #start} throws
        this.fetchBackendId = fetchBackendId;
    }
     * parallel arrays Phase B will then walk to build its per-shard plans.
 *
        }
        // NOT included — it's a helper consumed during stitch, never surfaced.
    private final OpenSearchLateMaterialization wrapper;
            outerListener.onResponse(null);
    /**
        int position = 0;
     * arrives in the same ascending order, and Phase D writes each response cell into
                stitcher.acceptBatch(batch, plan.positions(), rowsCopiedSoFar);
 *
     * timeout, or an upstream failure — while a shard's fetch stream is still outstanding, that
        return childInputBuffer;
    public ExchangeSource outputSource() {
        this.config = config;
            throw new IllegalStateException("Drained row count exceeds Integer.MAX_VALUE: " + total);
    @Override
     * and {@link ExchangeSource}); a custom sink may be needed if Phase A wants to
