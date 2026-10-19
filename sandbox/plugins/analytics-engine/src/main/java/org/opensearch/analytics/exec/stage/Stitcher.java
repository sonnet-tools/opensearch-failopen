     * helper column is identified by name and skipped during copy.
import org.apache.arrow.vector.FieldVector;
            output.close();  
 * <p>TODO incremental emission. Today the entire stitched VSR is emitted in a single
                // closeChildInput on our SUCCEEDED, closing the very sender we fed), and a ROOT LM
            }
    /**
    public Stitcher(
    }
 * than holding everything in {@code output} until the end. The natural emission unit is
package org.opensearch.analytics.exec.stage;
                        + positions.length  
}
        this.output.allocateNew();
 * dropped (downstream sees rows in shard-completion order, not sort order). Camp-B post-LM
 *
 * The OpenSearch Contributors require contributions made to  
     */
            int batchRows = batch.getRowCount();
 * {@code AnalyticsSearchService.executeFetchByRowIds} requires ascending {@code rowIds} in
                // stage has no parent: its sink is the RowProducingSink whose close() frees and  
     * Copies one shard's response batch into the output VSR. Reads positions starting at
    public void shardComplete() {
                );  
                // QueryExecution.closeTerminalSink(); the K==0 branch documents the same contract.
/**
                    outputDisposed = true;  
                return;  
                VectorUtils.sanitizeNullViewSlots(output);  
import org.opensearch.analytics.spi.CancellableExchangeSink;
        // sanitizeNullViewSlots / feed throws before the hand-off, the finally must free them or  
                    parentSink.close();  
                        throw new IllegalStateException(
 * the request's {@code rowIds[]}) lines up positionally with the response. The listener
 * (Stage 3) cannot start until LM's terminal SUCCEEDED transition. This forces Stage 3 to
        } finally {  
                        + batchRows
import org.apache.logging.log4j.Logger;
     * suppressed exceptions so diagnostics aren't lost.
                // close() (from the stage's terminal transition) sees ownership has moved and won't  
        failures.offer(e);
 * stitcher would need to emit per-shard sub-batches at each shard's completion rather
        }
     * {@link #finish} and a concurrent terminal-transition {@link #close} cannot double-close (or  
                // close as graceful EOF and completing the top-level query successfully.
        this.pendingShards = new AtomicInteger(shardCount);
     * The {@code outputDisposed} flag is read-and-set under {@link #outputLock} so the last shard's
 */  
    private void closeOutputOnce() {  
    }
                    "Shard returned more rows than requested: positions.length="
     * close a VSR the sink now owns).
     * {@code rowsCopiedSoFar} (the listener's per-shard "rows copied so far" counter) and
 * </ol>  
 *
 * across the K-row range, so the wire-side position-sortedness invariant would have to be
    private final int aboveColCount;
                // Mark disposed under the lock BEFORE anything else can observe it, so a concurrent
                    cancellable.cancel();  
     * never runs — e.g. a shard's fetch stream neither completes nor fails (dropped listener, node
    public Exception surfaceableFailure() {
     * Releases the pre-allocated output VSR if it was never emitted. Idempotent and safe to call  
    private boolean outputDisposed = false;
        Exception primary = failures.poll();  
 *   <li>{@link #shardComplete} — listener calls once when its shard's stream terminates.  
     */
                closeOutputOnce();
        // Ownership of the output VSR transfers to parentSink only once feed() returns normally  
                parentSink.feed(output);
    private final ConcurrentLinkedQueue<Exception> failures = new ConcurrentLinkedQueue<>();
        }
            int responseColCount = batch.getSchema().getFields().size();
        if (pendingShards.decrementAndGet() == 0) {
     * finally or {@link #close} frees it. Prevents a double-close race between the last shard's
        // owns output's buffers, which live on the coordinator allocator; if setRowCount /
    }  
 *       When all shards complete, the stitcher feeds the output to {@code parentSink} and
     * lost mid-fetch, task cancelled before the stream terminates), so {@link #pendingShards} never  
        synchronized (outputLock) {
        // TODO pre-size vectors to totalRows via setInitialCapacity to avoid copyFromSafe
                        + " rowsCopiedSoFar="
 * Defer until a real workload demands it.
    private final Object outputLock = new Object();  
                if (parentSink instanceof CancellableExchangeSink cancellable) {
                    if (srcCol == rowIdIdx) continue;  
     * — we don't fast-cancel. When the LM stage gains a {@code cancel(reason)} path that
        return primary;
    private static final Logger logger = LogManager.getLogger(Stitcher.class);  
            } else {
     * {@link #finish}, and a no-op on repeated calls.  
 * the request and the native side returns rows in the same ascending order, so the
            if (failures.isEmpty()) {
                // A fetch failure is not normal input completion. Abort a cancellable parent
                } catch (Exception ignore) {}
            }
 *   <li>{@link #acceptBatch} — listener calls per response batch from a shard. Synchronized
 *       runs {@code onComplete}.</li>
        if (pendingShards.decrementAndGet() == 0) {  
                    FieldVector dstVec = output.getVector(outCol);
        ExchangeSink parentSink,  
                        + rowsCopiedSoFar
    }  
                    outCol++;  
        this.output = VectorSchemaRoot.create(new Schema(outputFields), allocator);  
        this.onComplete = onComplete;  
    private final VectorSchemaRoot output;
 * {@code parentSink.feed} call after every shard's stream terminates — the post-LM stage  
     * places each response row at {@code positions[rowsCopiedSoFar + srcRow]}.  
 *       and emits failure to the LM stage's outer listener.</li>
                        + " batchRows="  
     * reaches zero. Without this, {@code output}'s buffers stay pinned on the coordinator allocator
                    FieldVector srcVec = batch.getVector(srcCol);  
    private final int totalRows;  
 */  
 * {@code positions[rowsCopiedSoFar .. rowsCopiedSoFar + batchRows)}.  
                ownershipTransferred = true;
                }
     * {@code finish} and a concurrent terminal-transition {@code close}.  
    }
 *   <li>{@link #shardFailed} — listener calls on per-shard failure. Failures are collected  
     * Guards the output VSR's disposition, mutated only under {@link #outputLock}. Set once, either
 * <p>Lifecycle:
        // re-allocs during stitch. Today we let Arrow grow buffers dynamically — fine for
        boolean ownershipTransferred = false;
 * ops (Sort / TopN / global-frame Aggregate) need the full set anyway and would still buffer.  
     * fetch cols ordered as the request's {@code columns[]} (excluding the helper). The  
                    dstVec.copyFromSafe(srcRow, dstRow, srcVec);
                }
 * shard's per-shard {@code positions[]} array (built during Phase B in the same order as  
        synchronized (outputLock) {
    /**  
     */  
     */
 * compatible open source license.
import org.apache.logging.log4j.LogManager;  
                            "Response column count exceeds output schema: outCol=" + outCol + " aboveColCount=" + aboveColCount  
import org.apache.arrow.vector.VectorSchemaRoot;  
            if (outputDisposed) {
                // Do NOT close parentSink here — a producer never closes its consumer's sink.  
    public void close() {
        BufferAllocator allocator,
    }
                // before closing it so its native stream reports an error instead of treating  
import org.apache.arrow.vector.types.pojo.Field;
        // small K but wasteful for large K (varchar buffers in particular grow geometrically).  
    private final AtomicInteger pendingShards;  
 *
        this.aboveColCount = outputFields.size();  
 *
import org.opensearch.analytics.exec.VectorUtils;
                logger.debug("[Stitcher] emitted rows={}", totalRows);  
 * tracks where its previous batch left off via {@code rowsCopiedSoFar}; this stitcher reads
     * Returns the surfaceable failure: the first one collected, with subsequent failures
            finish();  
    /** Signals that one shard's stream has terminated successfully. Triggers emit when last. */  
     * — this stitcher must not close it), or left {@code false} so exactly one of {@link #finish}'s
import java.util.concurrent.atomic.AtomicInteger;  
        }
            if (rowIdIdx < 0) {  
     *
     * Closes {@code output} at most once, and never after ownership transferred to {@code parentSink}.
     *
                // unprojected multi-shard `sort <col> | head N` (QTF leaves  
                throw new IllegalStateException(
import java.util.concurrent.ConcurrentLinkedQueue;
                // clears every batch, while QueryExecution reads the answer only afterwards via
            int rowIdIdx = batch.getSchema().getFields().indexOf(batch.getSchema().findField(OpenSearchLateMaterialization.ROW_ID_FIELD));
 * "rows whose entire shard response has arrived" — those land at non-contiguous positions  
import org.opensearch.analytics.planner.rel.OpenSearchLateMaterialization;  
     * from the owning LM stage's terminal / cancel path to cover the window where {@link #finish}
 * <p>Position is derived from the order contract with the data node:  
            }
    /**  
        List<Field> outputFields,  
        Runnable onComplete
    /**
        for (Exception next; (next = failures.poll()) != null;) {
            for (int srcRow = 0; srcRow < batchRows; srcRow++) {
 * post-LM ops — Filter / Project / hash Aggregate — process rows as they arrive), the  
 * this file be licensed under the Apache-2.0 license or a
        try {  
 *       so concurrent shards can't interleave Arrow buffer writes.</li>
 *
    private final ExchangeSink parentSink;
                    if (outCol >= aboveColCount) {
import org.opensearch.analytics.spi.ExchangeSink;
    ) {
        this.parentSink = parentSink;
                    "Fetch response missing " + OpenSearchLateMaterialization.ROW_ID_FIELD + " column; got " + batch.getSchema()
     * <p>FIXME: today other in-flight shards continue running until they too complete or fail  
                throw new IllegalStateException(
        this.totalRows = totalRows;
 * Per-LM-stage stitcher. Owns one pre-allocated output {@link VectorSchemaRoot} sized to K  
 * (the survivor row count) and accumulates fetch-by-rowid response batches from N shards
            if (ownershipTransferred == false) {
 * @opensearch.internal
            finish();
import org.apache.arrow.memory.BufferAllocator;
                }
            primary.addSuppressed(next);  
        int shardCount,
     */
        if (primary == null) return null;
                int dstRow = positions[rowsCopiedSoFar + srcRow];  
    }
            onComplete.run();
            }  
    private final Runnable onComplete;
                // OpenSearchLateMaterialization the plan root). Root teardown belongs to
 * <ol>  
                        );
    private void finish() {
                try {
                    }
 * the stitcher copies each response row to the output via {@link FieldVector#copyFromSafe}.  
 * use the buffered MemTable sink. To enable streaming Stage 3 (which would let Camp-A
        // they leak onto the long-lived coordinator allocator (the pool never goes back down).
/*  
        }
                // close the VSR parentSink now owns.
     * for the node's lifetime. A no-op once ownership has transferred to {@code parentSink} via
        int totalRows,
                for (int srcCol = 0; srcCol < responseColCount; srcCol++) {
     * to {@code true} when {@link #finish} hands output to {@code parentSink} (ownership transferred  
     * are retained — the first becomes the primary surfaced exception, the rest land as  
     * attached as {@code addSuppressed}. {@code null} if no shard failed.  
            }  
            }
     */
                // outputSource().readResult(). Closing here returned 0 rows with HTTP 200 for an
                );
     * <p>The response batch's column layout is {@code [___row_id, fetch-col-0, fetch-col-1, ...]} —
 * SPDX-License-Identifier: Apache-2.0
                output.setRowCount(totalRows);
    public void acceptBatch(VectorSchemaRoot batch, int[] positions, int rowsCopiedSoFar) {  
    /**
            if (rowsCopiedSoFar + batchRows > positions.length) {  
        // (see ExchangeSink#feed — the sink then owns and releases it). Until then this stitcher
            outputDisposed = true;
                // Per-input EOF is the parent's job (StageExecution.attachChildren fires
                synchronized (outputLock) {
public final class Stitcher {
     * propagates to in-flight transports, hook it here.
     * Records a per-shard failure and proceeds via the completion path. All shard failures
        }  
    public void shardFailed(Exception e) {
    }  
 *       (first surfaced as primary, others added as suppressed); completion path runs once
 * into it. Per-shard listeners pass the position-array slice corresponding to each batch;
        }
import org.apache.arrow.vector.types.pojo.Schema;
import java.util.List;
    /**
        closeOutputOnce();  
                int outCol = 0;
