        heap[i] = heap[j];
/*
 * reads its batch outside the lock and takes it once per key.
 * <p>Every uncertainty answers "keep the shard": a wrong keep costs one shard scan, a wrong
        this.capacity = capacity;
        }
        if (size < capacity) {
public final class TopNGate {
        if (sortSpec == null || sortSpec.limit() <= 0 || sortSpec.limit() > MAX_CAPACITY) {
    public synchronized boolean isDisabled() {
            }
     * there is no re-enable.
            }
     * <p>The keys are compared against bounds read from parquet statistics, so both must be the same
        FieldVector vector = vsr.getVector(index);
        while (true) {
     * <p>Covers the value domains the shard check can report bounds for: parquet {@code Int32}/{@code Int64},
        int index = indexOf(vsr, column);
    /**
     * per-batch cost is a few string compares amortised over every row.
    private void siftUp(int index) {
            for (int i = 0; i < rows; i++) {
        } else if (vector instanceof IntVector ints) {
import org.apache.arrow.vector.IntVector;
 *
    private int size;
    }
     * Builds a gate for {@code sortSpec}, or {@code null} when this shape isn't gateable — no spec,
    /**
    /**
     * otherwise dropped.
 * not-yet-dispatched shard could still contribute a row.
     */
    /**
    private final int capacity;
    }
            return;
 * whole range worse than the worst of the {@code K} keys already in hand?
            if (outranks(heap[parent], heap[index]) == false) {
     * top-{@code K} already collected.
import org.apache.logging.log4j.Logger;
     * <p>Carries no value domain of its own: every bound it is asked about has already been checked
 * {@link #offer} is the per-key seam between them, useful on its own in tests.
 * reads its sort column; {@link #canEliminate} asks the resulting bar about a shard not yet sent.
     * {@code Schema.findField}: that throws, and a miss is expected here.
    }
     * Heap-only ctor for tests that drive {@link #offer} directly and never touch {@link #feed},
            // Not a schema worth judging — an empty batch must not retire the gate.
    private boolean outranks(long a, long b) {
            }
 *
            // queries are where that happens: with no exchange to stay above, the projection sinks
        if (outranks(key, heap[0])) {
        } else if (vector instanceof BigIntVector longs) {
    // once per row of every shard response, where boxing would cost more than the gate saves.
        }
            int parent = (index - 1) >>> 1;
            return false;
     */
    }
 * eliminate drops rows from the result.
            return;
 * That is why the verdict can be taken on the dispatch path, at any time, on any thread.
        int rows = vsr.getRowCount();
    private boolean disabled;
        }
     * response arrives, in {@code ShardFragmentStageExecution.setupSortGate}; what this method checks
import java.util.List;
     */
            int left = (index << 1) + 1;
 * The OpenSearch Contributors require contributions made to
            siftDown(0);
     * gate can never eliminate — the fail-open direction. {@code short} and {@code byte} columns land
        } else if (vector instanceof TimeStampNanoVector nanos) {
        }
     * against every other in {@code ShardFragmentStageExecution.setupSortGate}, which builds no gate
            // Descend toward the worse child, so the root keeps holding the overall worst.
            return;
    }
        this.column = column;
    public int capacity() {
    /**
                offer(millis.get(i));
 * critical section is a few {@code long} compares. {@link #feed} deliberately is <em>not</em>
        if (vector.getNullCount() > 0) {
     * for {@code ASC}. Strict, so equal keys never outrank each other.
     * Reads every row's sort key out of {@code vsr} and offers it to the heap.
            // invalidates the whole predicate, not just this batch.
    }
            return;
     *
    TopNGate(int capacity, boolean descending) {
     * here today ({@code SmallIntVector} / {@code TinyIntVector}); see doc 16 Stage 6.
            index = parent;
                return;
     */
        }
        // Fewer than K keys means there is no bar yet to be worse than.
            throw new IllegalStateException("bottom() is undefined until " + capacity + " keys are observed (have " + size + ")");
    private static final Logger logger = LogManager.getLogger(TopNGate.class);
            if (left >= size) {
        for (int i = 0; i < fields.size(); i++) {
    /** Once set, every question answers "keep the shard". See {@link #disable}. */
    }
     * <p>Must be called <b>before</b> the batch is handed to the sink: the sink takes ownership of
            if (name.equals(fields.get(i).getName())) {
            }
import org.apache.arrow.vector.VectorSchemaRoot;
     * would give wrong results rather than just lose the optimisation.
    private void siftDown(int index) {
     * shard claimed it did not have. Either {@linkplain #disable() retires the gate}, because both
    }
    private final boolean descending;
     * True when {@code bounds} describes a shard that provably cannot place a row in the
 *
     */
     * Worst key among the best {@code K} seen so far — the bar a shard has to clear.
    }
            swap(index, worst);
        }
            // No keys to feed, so the gate can never arm; the query runs as it did before this
            // Expected, not a bug. The spec's column comes from the Sort's INPUT row type, but a
 * this file be licensed under the Apache-2.0 license or a
    /**
     */
     * so the column name is immaterial.
 * <p>{@link #bottom()} only ever improves, so once a shard is eliminable it stays eliminable.
        if (bounds == null || bounds.hasNulls()) {
        return -1;
    /**
     * Position of {@code name} in the batch schema, or {@code -1} when absent. Not
            retire("sort column '" + column + "' contains nulls the shard bounds did not report");
     *                               there is no bar
        return heap[0];
        heap[j] = tmp;
     * never produce, so a {@code TimeStampMicroVector} arm would be unreachable.
     * Retires the gate for the rest of the query — every shard is kept from here on.
            return;
                offer(ints.get(i));
        this.descending = descending;
     * <p>A type not listed here contributes nothing and leaves the heap short of {@code K}, so the
        if (index < 0) {
     *
 * synchronized as a whole — it would hold the lock for an entire batch and stall dispatch — so it
     */
import org.apache.arrow.vector.TimeStampNanoVector;
        }
     */
        }
        if (size < capacity) {
     * {@code K} — how many keys the gate needs before it can eliminate anything. Public for
     */
    public void feed(VectorSchemaRoot vsr) {
import org.apache.logging.log4j.LogManager;
    /** True once {@link #disable} has been called. */
    /**
            // canEliminate trusts the bounds' hasNulls=false claim; data contradicting it
    /** Sort column to read out of each response batch, from the same {@link SortSpec} as the heap. */
    }
     * and converts timestamps to {@code Instant}, and this runs once per row of every response.
    private final String column;
     *
 */
        while (index > 0) {
        }
}
                offer(longs.get(i));
 * {@code SortExec: TopK}. This is a cheap side tally that answers one question: is this shard's
     * at all when they disagree. See doc 16 Stage 7.
            return false;
    }
    /** True once {@code K} keys have been collected — before that nothing can be eliminated. */
     * rarely fills up anyway — above it the gate would be pure overhead, so we build none.
        long tmp = heap[i];
     * OpenSearch writes ({@code date} and {@code date_nanos}); micros is a parquet logical type we
     *
    // The heap keeps the WORST of the top-K at the root, so admitting a key is one compare against
     * True when {@code a} is a better sort key than {@code b}: larger for {@code DESC}, smaller
 *
        }
        readInto(vector, rows);
            return;
     *
            }
package org.opensearch.analytics.exec.canmatch;
        }
 * Keeps the best {@code K} sort keys seen so far so the coordinator can tell whether a
    private static int indexOf(VectorSchemaRoot vsr, String name) {
    /**
        this.heap = new long[capacity];
    }
            throw new IllegalArgumentException("capacity must be in 1.." + MAX_CAPACITY + ", got " + capacity);
/**
        return size == capacity;
     * Largest {@code K} worth gating. The heap costs {@code 8·K} bytes, and a limit this large
     */
     * <p>Called from many stream-response threads, one per shard. The column is resolved against the
            return null;
 *
    /**
     * That's the one failure mode that would give wrong results rather than a lost optimisation, so
        disabled = true;
            // throw from the stream handler, failing a working query and stranding the batch this
        }
 * <p>Two entry points, one per side of the query. {@link #feed} takes a whole shard response and
     * Offers one sort key. Kept while the heap isn't full, or if it beats the current worst;
            // by the key — so the column is still there.
            // call was supposed to hand to the sink.
     *
        }
        }
     */
    public synchronized boolean canEliminate(ShardSortBounds bounds) {
            for (int i = 0; i < rows; i++) {
 */
            // Project above the Sort can drop it before the rows reach the wire. Single-shard
            index = worst;
    }
                return;
        return descending ? a > b : a < b;
    // heap[0] and bottom() is O(1). A long[] rather than a PriorityQueue<Long> because this runs
 * <p>Every method that touches the heap is {@code synchronized}: feeding runs on stream-response
    public synchronized void offer(long key) {
            int worst = (right < size && outranks(heap[left], heap[right])) ? right : left;
            size++;
import org.apache.arrow.vector.FieldVector;
        // Calcite maps DESC to NULLS FIRST, so one null outranks every real value and puts the
    TopNGate(int capacity, boolean descending, String column) {
 * @opensearch.internal
        if (disabled) {
            siftUp(size);
 *
        if (isDisabled()) {
     * schema of each batch rather than cached: the index is a fact about one response, and the
import org.apache.arrow.vector.types.pojo.Field;
     * @throws IllegalStateException if fewer than {@code K} keys have been observed, since then
        return new TopNGate(sortSpec.limit(), sortSpec.descending(), sortSpec.column());
 * SPDX-License-Identifier: Apache-2.0
            int right = left + 1;
     * {@code FieldSortBuilder.isBottomSortShardDisjoint}.
    }
            heap[size] = key;
                return i;
     *
        }
 *
     * the sort column missing from a response schema, or nulls a shard claimed it did not have.
    private void readInto(FieldVector vector, int rows) {
    public synchronized void disable() {
     * the {@link VectorSchemaRoot} and may close it.
     * <p>Called when the arriving keys can't be trusted to measure the same thing as the bounds:
            // into the fragment. `sort - ts | head 3 | fields host` on a one-shard index sends
        if (vector instanceof TimeStampMilliVector millis) {
        // but the explicit order documents the intended dispatch.
 * <p>Keys only, no rows — the real top-N is still assembled by the coordinator's blocking
    private void retire(String reason) {
            }
     * {@code SortGateWiringTests}, which asserts the gate was built from the sort spec's limit.
    public synchronized long bottom() {
    /**
            // Schema<host> only. Multi-shard keeps the Project on the coordinator — it has to merge
     * quantity in the same units. Cross-shard agreement on the value domain is settled before any
    }
import org.apache.arrow.vector.BigIntVector;
 * compatible open source license.
        }
     */
 * threads, one per shard, and the verdict is read on whichever thread frees a dispatch slot. The
    private void swap(int i, int j) {
            heap[0] = key;
        // shard in the top-K on its own.
        disable();
        List<Field> fields = vsr.getSchema().getFields();
                offer(nanos.get(i));
        }
            for (int i = 0; i < rows; i++) {
        // Most-specific type first. The TimeStamp*Vector classes aren't BigIntVector subclasses,
import org.apache.arrow.vector.TimeStampMilliVector;
            }
    }
        return capacity;
    }
    private final long[] heap;
     *
            //
     * <p>The comparison is <b>strict</b>: a shard whose best value ties {@link #bottom()} may hold
        if (size < capacity) {
            retire("sort column '" + column + "' absent from the response schema " + vsr.getSchema());
        if (capacity <= 0 || capacity > MAX_CAPACITY) {
    static final int MAX_CAPACITY = 100_000;
            }
            swap(parent, index);
    }
        logger.debug("sort-et: gate disabled — {}", reason);
    /**
    public synchronized boolean isArmed() {
     * or a limit past {@link #MAX_CAPACITY}.
    // ── reading keys out of a shard response ──────────────────────────────
     * Per-row primitive reads. Not {@code ArrowValues.toJavaValue}: that boxes to {@code Object}
            if (outranks(heap[index], heap[worst]) == false) {
     * a row the wait-for-all baseline would surface, so it is kept. Same rule as vanilla's
        if (disabled) {
            return false;
     * and {@code Int64} annotated millis or nanos. Millis and nanos are the only timestamp units
        if (rows == 0) {
            // feature. Skipping the check instead would hand getVector(-1) an out-of-range index and
                break; // parent already no better than the child — heap order holds
    public static TopNGate create(SortSpec sortSpec) {
     * is what only the data can show — a sort column absent from the response schema, or nulls a
            for (int i = 0; i < rows; i++) {
        long shardBest = descending ? bounds.max() : bounds.min();
        return outranks(heap[0], shardBest);
import org.opensearch.analytics.spi.ShardSortBounds;
        this(capacity, descending, "@timestamp");
        return disabled;
     *
