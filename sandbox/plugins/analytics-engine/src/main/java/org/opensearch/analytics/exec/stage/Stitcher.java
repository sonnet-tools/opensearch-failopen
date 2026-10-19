                );
 * <p>Lifecycle:
        this.output.allocateNew();
                    parentSink.close();
        List<Field> outputFields,
        // (see ExchangeSink#feed — the sink then owns and releases it). Until then this stitcher
    private final Object outputLock = new Object();
                int dstRow = positions[rowsCopiedSoFar + srcRow];
                    cancellable.cancel();
/**
 */
 * (the survivor row count) and accumulates fetch-by-rowid response batches from N shards
            int rowIdIdx = batch.getSchema().getFields().indexOf(batch.getSchema().findField(OpenSearchLateMaterialization.ROW_ID_FIELD));
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.logging.log4j.LogManager;
        this.parentSink = parentSink;
     * <p>The response batch's column layout is {@code [___row_id, fetch-col-0, fetch-col-1, ...]} —
    /**
                }
public final class Stitcher {
 * @opensearch.internal
     */
    private final Runnable onComplete;
            if (outputDisposed) {
    private final ConcurrentLinkedQueue<Exception> failures = new ConcurrentLinkedQueue<>();
     * close a VSR the sink now owns).
     * — this stitcher must not close it), or left {@code false} so exactly one of {@link #finish}'s
     */
 * ops (Sort / TopN / global-frame Aggregate) need the full set anyway and would still buffer.
                            "Response column count exceeds output schema: outCol=" + outCol + " aboveColCount=" + aboveColCount
                for (int srcCol = 0; srcCol < responseColCount; srcCol++) {
        this.totalRows = totalRows;
                closeOutputOnce();
     * to {@code true} when {@link #finish} hands output to {@code parentSink} (ownership transferred
                try {
                    dstVec.copyFromSafe(srcRow, dstRow, srcVec);
     * never runs — e.g. a shard's fetch stream neither completes nor fails (dropped listener, node
            finish();
import org.apache.arrow.vector.types.pojo.Schema;
import org.opensearch.analytics.spi.ExchangeSink;
                        );
import org.apache.arrow.vector.FieldVector;
        closeOutputOnce();
                    "Fetch response missing " + OpenSearchLateMaterialization.ROW_ID_FIELD + " column; got " + batch.getSchema()
 * </ol>
}
     * Guards the output VSR's disposition, mutated only under {@link #outputLock}. Set once, either
        synchronized (outputLock) {
                        throw new IllegalStateException(
     *
                // QueryExecution.closeTerminalSink(); the K==0 branch documents the same contract.
 *
     * {@code rowsCopiedSoFar} (the listener's per-shard "rows copied so far" counter) and
                    if (outCol >= aboveColCount) {
     * lost mid-fetch, task cancelled before the stream terminates), so {@link #pendingShards} never
 * shard's per-shard {@code positions[]} array (built during Phase B in the same order as
                // before closing it so its native stream reports an error instead of treating
    /**
     * — we don't fast-cancel. When the LM stage gains a {@code cancel(reason)} path that
                throw new IllegalStateException(
        failures.offer(e);
 *
     * Closes {@code output} at most once, and never after ownership transferred to {@code parentSink}.
    }
 *       runs {@code onComplete}.</li>
                // OpenSearchLateMaterialization the plan root). Root teardown belongs to
    /**
                // Per-input EOF is the parent's job (StageExecution.attachChildren fires
            }
    }
 * {@code AnalyticsSearchService.executeFetchByRowIds} requires ascending {@code rowIds} in
 * use the buffered MemTable sink. To enable streaming Stage 3 (which would let Camp-A
        synchronized (outputLock) {
     */
                output.setRowCount(totalRows);
 * The OpenSearch Contributors require contributions made to
        // they leak onto the long-lived coordinator allocator (the pool never goes back down).
    public void close() {
                logger.debug("[Stitcher] emitted rows={}", totalRows);
                return;
 * <ol>
 * than holding everything in {@code output} until the end. The natural emission unit is
     * helper column is identified by name and skipped during copy.
    private final VectorSchemaRoot output;
        this.pendingShards = new AtomicInteger(shardCount);
            output.close();
     * from the owning LM stage's terminal / cancel path to cover the window where {@link #finish}
        this.aboveColCount = outputFields.size();
        }
import org.apache.arrow.vector.VectorSchemaRoot;
import java.util.concurrent.ConcurrentLinkedQueue;
     * {@code finish} and a concurrent terminal-transition {@code close}.
 *   <li>{@link #shardFailed} — listener calls on per-shard failure. Failures are collected
import java.util.List;
     * Releases the pre-allocated output VSR if it was never emitted. Idempotent and safe to call
                // Mark disposed under the lock BEFORE anything else can observe it, so a concurrent
    public void acceptBatch(VectorSchemaRoot batch, int[] positions, int rowsCopiedSoFar) {
 *
package org.opensearch.analytics.exec.stage;
    }
                // close the VSR parentSink now owns.
    ) {
                // clears every batch, while QueryExecution reads the answer only afterwards via
                        + " batchRows="
import org.opensearch.analytics.planner.rel.OpenSearchLateMaterialization;
        Runnable onComplete
 * the request's {@code rowIds[]}) lines up positionally with the response. The listener
            int responseColCount = batch.getSchema().getFields().size();
 * "rows whose entire shard response has arrived" — those land at non-contiguous positions
        }
 * stitcher would need to emit per-shard sub-batches at each shard's completion rather
     * Copies one shard's response batch into the output VSR. Reads positions starting at
            }
import org.apache.logging.log4j.Logger;
     * places each response row at {@code positions[rowsCopiedSoFar + srcRow]}.
            onComplete.run();
                );
                        + positions.length
        // TODO pre-size vectors to totalRows via setInitialCapacity to avoid copyFromSafe
     * The {@code outputDisposed} flag is read-and-set under {@link #outputLock} so the last shard's
 * the stitcher copies each response row to the output via {@link FieldVector#copyFromSafe}.
        Exception primary = failures.poll();
import org.apache.arrow.vector.types.pojo.Field;
 * post-LM ops — Filter / Project / hash Aggregate — process rows as they arrive), the
        }
        // re-allocs during stitch. Today we let Arrow grow buffers dynamically — fine for
     */
    private final int aboveColCount;
                }
        // Ownership of the output VSR transfers to parentSink only once feed() returns normally
        for (Exception next; (next = failures.poll()) != null;) {
 * across the K-row range, so the wire-side position-sortedness invariant would have to be
                // unprojected multi-shard `sort <col> | head N` (QTF leaves
            }
 * <p>TODO incremental emission. Today the entire stitched VSR is emitted in a single
     * attached as {@code addSuppressed}. {@code null} if no shard failed.
    }
    private boolean outputDisposed = false;
            finish();
import org.opensearch.analytics.exec.VectorUtils;
     * {@link #finish}, and a no-op on repeated calls.
    }
                // Do NOT close parentSink here — a producer never closes its consumer's sink.
        // owns output's buffers, which live on the coordinator allocator; if setRowCount /
 * Defer until a real workload demands it.
 * {@code parentSink.feed} call after every shard's stream terminates — the post-LM stage
                // close() (from the stage's terminal transition) sees ownership has moved and won't
    /**
            if (failures.isEmpty()) {
        int totalRows,
                        + rowsCopiedSoFar
            if (ownershipTransferred == false) {
                        + " rowsCopiedSoFar="
                    outputDisposed = true;
    }
                parentSink.feed(output);
     */
                synchronized (outputLock) {
import org.apache.arrow.memory.BufferAllocator;
            if (rowsCopiedSoFar + batchRows > positions.length) {
                // outputSource().readResult(). Closing here returned 0 rows with HTTP 200 for an
                // closeChildInput on our SUCCEEDED, closing the very sender we fed), and a ROOT LM
            if (rowIdIdx < 0) {
    private void finish() {
 *   <li>{@link #acceptBatch} — listener calls per response batch from a shard. Synchronized
            primary.addSuppressed(next);
            } else {
                        + batchRows
 *
     * {@link #finish} and a concurrent terminal-transition {@link #close} cannot double-close (or
    /**
            }
        if (pendingShards.decrementAndGet() == 0) {
 * into it. Per-shard listeners pass the position-array slice corresponding to each batch;
                int outCol = 0;
            int batchRows = batch.getRowCount();
 * compatible open source license.
                    if (srcCol == rowIdIdx) continue;
     * fetch cols ordered as the request's {@code columns[]} (excluding the helper). The
     * Records a per-shard failure and proceeds via the completion path. All shard failures
    private final int totalRows;
 * dropped (downstream sees rows in shard-completion order, not sort order). Camp-B post-LM
 *       and emits failure to the LM stage's outer listener.</li>
     *
    private final ExchangeSink parentSink;
                // close as graceful EOF and completing the top-level query successfully.
    }
        // sanitizeNullViewSlots / feed throws before the hand-off, the finally must free them or
                // stage has no parent: its sink is the RowProducingSink whose close() frees and
                } catch (Exception ignore) {}
                VectorUtils.sanitizeNullViewSlots(output);
 * the request and the native side returns rows in the same ascending order, so the
 * tracks where its previous batch left off via {@code rowsCopiedSoFar}; this stitcher reads
 *   <li>{@link #shardComplete} — listener calls once when its shard's stream terminates.
        int shardCount,
 * SPDX-License-Identifier: Apache-2.0
 * {@code positions[rowsCopiedSoFar .. rowsCopiedSoFar + batchRows)}.
import org.opensearch.analytics.spi.CancellableExchangeSink;
        this.onComplete = onComplete;
                ownershipTransferred = true;
 */
        this.output = VectorSchemaRoot.create(new Schema(outputFields), allocator);
        try {
            for (int srcRow = 0; srcRow < batchRows; srcRow++) {
        } finally {
        }
 * this file be licensed under the Apache-2.0 license or a
 * <p>Position is derived from the order contract with the data node:
                    outCol++;
    public void shardFailed(Exception e) {
                    }
     * reaches zero. Without this, {@code output}'s buffers stay pinned on the coordinator allocator
            outputDisposed = true;
 *       (first surfaced as primary, others added as suppressed); completion path runs once
        // small K but wasteful for large K (varchar buffers in particular grow geometrically).
     * for the node's lifetime. A no-op once ownership has transferred to {@code parentSink} via
 *
    }
                if (parentSink instanceof CancellableExchangeSink cancellable) {
     * propagates to in-flight transports, hook it here.
 * Per-LM-stage stitcher. Owns one pre-allocated output {@link VectorSchemaRoot} sized to K
 *       so concurrent shards can't interleave Arrow buffer writes.</li>
                    FieldVector srcVec = batch.getVector(srcCol);
 * (Stage 3) cannot start until LM's terminal SUCCEEDED transition. This forces Stage 3 to
    public Exception surfaceableFailure() {
     * Returns the surfaceable failure: the first one collected, with subsequent failures
    /** Signals that one shard's stream has terminated successfully. Triggers emit when last. */
    private static final Logger logger = LogManager.getLogger(Stitcher.class);
    /**
 *       When all shards complete, the stitcher feeds the output to {@code parentSink} and
                    FieldVector dstVec = output.getVector(outCol);
     * suppressed exceptions so diagnostics aren't lost.
     */
        boolean ownershipTransferred = false;
    private final AtomicInteger pendingShards;
     * <p>FIXME: today other in-flight shards continue running until they too complete or fail
                throw new IllegalStateException(
        }
     * finally or {@link #close} frees it. Prevents a double-close race between the last shard's
        if (pendingShards.decrementAndGet() == 0) {
            }
    public Stitcher(
        BufferAllocator allocator,
        return primary;
                    "Shard returned more rows than requested: positions.length="
        }
/*
                }
            }
    private void closeOutputOnce() {
    public void shardComplete() {
                // A fetch failure is not normal input completion. Abort a cancellable parent
     * are retained — the first becomes the primary surfaced exception, the rest land as
        if (primary == null) return null;
        ExchangeSink parentSink,
