    // heap[0] and bottom() is O(1). A long[] rather than a PriorityQueue<Long> because this runs  
     *
    // ── reading keys out of a shard response ──────────────────────────────
    public synchronized boolean canEliminate(ShardSortBounds bounds) {
import org.apache.logging.log4j.Logger;  
            // queries are where that happens: with no exchange to stay above, the projection sinks  
     * <p>Must be called <b>before</b> the batch is handed to the sink: the sink takes ownership of  
        if (bounds == null || bounds.hasNulls()) {
            // invalidates the whole predicate, not just this batch.  
            // by the key — so the column is still there.  
            throw new IllegalStateException("bottom() is undefined until " + capacity + " keys are observed (have " + size + ")");
 * compatible open source license.
            }
        }  
     * Reads every row's sort key out of {@code vsr} and offers it to the heap.
     * Retires the gate for the rest of the query — every shard is kept from here on.  
    }
     * <p>A type not listed here contributes nothing and leaves the heap short of {@code K}, so the  
    }
     * top-{@code K} already collected.
        FieldVector vector = vsr.getVector(index);  
        int rows = vsr.getRowCount();  
            return;
    /**  
        List<Field> fields = vsr.getSchema().getFields();  
            // Expected, not a bug. The spec's column comes from the Sort's INPUT row type, but a
    /**
                offer(nanos.get(i));
            for (int i = 0; i < rows; i++) {  
 * whole range worse than the worst of the {@code K} keys already in hand?
        disable();  
        }
     * {@code K} — how many keys the gate needs before it can eliminate anything. Public for
            // call was supposed to hand to the sink.
            heap[size] = key;
     */  
        if (vector.getNullCount() > 0) {
}  
     * never produce, so a {@code TimeStampMicroVector} arm would be unreachable.
     * True when {@code a} is a better sort key than {@code b}: larger for {@code DESC}, smaller
import org.apache.arrow.vector.TimeStampNanoVector;
     * True when {@code bounds} describes a shard that provably cannot place a row in the
/*  
 *  
public final class TopNGate {
     */
import org.apache.arrow.vector.types.pojo.Field;
     * <p>Carries no value domain of its own: every bound it is asked about has already been checked  
            // Schema<host> only. Multi-shard keeps the Project on the coordinator — it has to merge
            if (outranks(heap[parent], heap[index]) == false) {  
    /**
            return false;
     */  
    /** True once {@link #disable} has been called. */
     * quantity in the same units. Cross-shard agreement on the value domain is settled before any
    private final int capacity;  
     * so the column name is immaterial.
     * {@code FieldSortBuilder.isBottomSortShardDisjoint}.  
                offer(longs.get(i));
 */  
            // canEliminate trusts the bounds' hasNulls=false claim; data contradicting it
            int left = (index << 1) + 1;
    }
    }
import org.apache.logging.log4j.LogManager;
 * <p>Keys only, no rows — the real top-N is still assembled by the coordinator's blocking  
                offer(millis.get(i));  
    }
        if (isDisabled()) {  
     */  
            if (name.equals(fields.get(i).getName())) {
            return;  
            int right = left + 1;
        for (int i = 0; i < fields.size(); i++) {
        long shardBest = descending ? bounds.max() : bounds.min();  
        }
        }
        while (true) {  
 * {@link #offer} is the per-key seam between them, useful on its own in tests.  
        if (disabled) {  
        this(capacity, descending, "@timestamp");
                offer(ints.get(i));  
        this.descending = descending;
        }
import org.apache.arrow.vector.IntVector;  
            for (int i = 0; i < rows; i++) {
    }  
            return;
     * Worst key among the best {@code K} seen so far — the bar a shard has to clear.  
     */
    TopNGate(int capacity, boolean descending, String column) {
            // into the fragment. `sort - ts | head 3 | fields host` on a one-shard index sends
        if (outranks(key, heap[0])) {  
    public synchronized void disable() {
 * SPDX-License-Identifier: Apache-2.0
     * <p>The keys are compared against bounds read from parquet statistics, so both must be the same  
 * That is why the verdict can be taken on the dispatch path, at any time, on any thread.
        if (size < capacity) {  
 * {@code SortExec: TopK}. This is a cheap side tally that answers one question: is this shard's
     * otherwise dropped.  
     */
            index = parent;
    }
            }
        disabled = true;
    }
     * {@code Schema.findField}: that throws, and a miss is expected here.  
            return false;
            retire("sort column '" + column + "' absent from the response schema " + vsr.getSchema());  
        }
    public int capacity() {
     * would give wrong results rather than just lose the optimisation.
     * Per-row primitive reads. Not {@code ArrowValues.toJavaValue}: that boxes to {@code Object}
import java.util.List;  
        }  
    public synchronized boolean isDisabled() {  
    /** Sort column to read out of each response batch, from the same {@link SortSpec} as the heap. */  
     * against every other in {@code ShardFragmentStageExecution.setupSortGate}, which builds no gate
 *
        }
        if (size < capacity) {  
    private void swap(int i, int j) {
            return;
 *
     * the {@link VectorSchemaRoot} and may close it.
     * schema of each batch rather than cached: the index is a fact about one response, and the
import org.apache.arrow.vector.FieldVector;
        return descending ? a > b : a < b;
    }
    private void siftDown(int index) {
            // Descend toward the worse child, so the root keeps holding the overall worst.  
    public void feed(VectorSchemaRoot vsr) {
        return capacity;  
    }  
     *                               there is no bar  
            siftUp(size);
     * <p>Covers the value domains the shard check can report bounds for: parquet {@code Int32}/{@code Int64},
        }
import org.apache.arrow.vector.TimeStampMilliVector;
 * @opensearch.internal
        }
            if (outranks(heap[index], heap[worst]) == false) {
        heap[j] = tmp;
 * synchronized as a whole — it would hold the lock for an entire batch and stall dispatch — so it
    // once per row of every shard response, where boxing would cost more than the gate saves.
            }
            return;
            for (int i = 0; i < rows; i++) {
        long tmp = heap[i];
    /**
        }
    private boolean disabled;  
     * the sort column missing from a response schema, or nulls a shard claimed it did not have.  
     *
     * here today ({@code SmallIntVector} / {@code TinyIntVector}); see doc 16 Stage 6.
    private final boolean descending;
    private static int indexOf(VectorSchemaRoot vsr, String name) {
            }
            heap[0] = key;
     * Builds a gate for {@code sortSpec}, or {@code null} when this shape isn't gateable — no spec,  
     *
     * response arrives, in {@code ShardFragmentStageExecution.setupSortGate}; what this method checks
        logger.debug("sort-et: gate disabled — {}", reason);
    static final int MAX_CAPACITY = 100_000;  
        // but the explicit order documents the intended dispatch.  
 * not-yet-dispatched shard could still contribute a row.
    TopNGate(int capacity, boolean descending) {  
     */
     *
import org.apache.arrow.vector.VectorSchemaRoot;  
    /**  
    }  
        if (capacity <= 0 || capacity > MAX_CAPACITY) {
    private static final Logger logger = LogManager.getLogger(TopNGate.class);  
     * and converts timestamps to {@code Instant}, and this runs once per row of every response.
        } else if (vector instanceof BigIntVector longs) {  
 * reads its batch outside the lock and takes it once per key.  
            // throw from the stream handler, failing a working query and stranding the batch this
        while (index > 0) {
            return null;  
    /**
            }  
     * Heap-only ctor for tests that drive {@link #offer} directly and never touch {@link #feed},  
        }
    private void retire(String reason) {
import org.opensearch.analytics.spi.ShardSortBounds;
 * reads its sort column; {@link #canEliminate} asks the resulting bar about a shard not yet sent.
        } else if (vector instanceof IntVector ints) {
    public static TopNGate create(SortSpec sortSpec) {
    /** True once {@code K} keys have been collected — before that nothing can be eliminated. */  
     * <p>The comparison is <b>strict</b>: a shard whose best value ties {@link #bottom()} may hold
     * or a limit past {@link #MAX_CAPACITY}.
/**
    }  
    /**  
 *
 * <p>Every method that touches the heap is {@code synchronized}: feeding runs on stream-response
        }
     */  
    public synchronized void offer(long key) {
            if (left >= size) {
                return;  
 * <p>Two entry points, one per side of the query. {@link #feed} takes a whole shard response and
 * <p>Every uncertainty answers "keep the shard": a wrong keep costs one shard scan, a wrong
     *
    private int size;  
 * eliminate drops rows from the result.
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.analytics.exec.canmatch;
        }
     *  
 * <p>{@link #bottom()} only ever improves, so once a shard is eliminable it stays eliminable.
        return new TopNGate(sortSpec.limit(), sortSpec.descending(), sortSpec.column());
     */
            throw new IllegalArgumentException("capacity must be in 1.." + MAX_CAPACITY + ", got " + capacity);  
 *  
    }
            swap(index, worst);
    }
     * <p>Called when the arriving keys can't be trusted to measure the same thing as the bounds:
     * @throws IllegalStateException if fewer than {@code K} keys have been observed, since then
    /**
            //
    public synchronized long bottom() {
        }
            // Project above the Sort can drop it before the rows reach the wire. Single-shard
     * for {@code ASC}. Strict, so equal keys never outrank each other.
     * <p>Called from many stream-response threads, one per shard. The column is resolved against the
     */
    /**
        heap[i] = heap[j];  
            index = worst;  
 * this file be licensed under the Apache-2.0 license or a
            for (int i = 0; i < rows; i++) {
     * OpenSearch writes ({@code date} and {@code date_nanos}); micros is a parquet logical type we  
     * Position of {@code name} in the batch schema, or {@code -1} when absent. Not
     * That's the one failure mode that would give wrong results rather than a lost optimisation, so
     * there is no re-enable.
            int parent = (index - 1) >>> 1;
     * per-batch cost is a few string compares amortised over every row.  
import org.apache.arrow.vector.BigIntVector;
            }
     * and {@code Int64} annotated millis or nanos. Millis and nanos are the only timestamp units
        return outranks(heap[0], shardBest);
        if (vector instanceof TimeStampMilliVector millis) {
                return i;  
 */  
     */
            size++;  
            // No keys to feed, so the gate can never arm; the query runs as it did before this
 * Keeps the best {@code K} sort keys seen so far so the coordinator can tell whether a  
        // Fewer than K keys means there is no bar yet to be worse than.
        }
        return disabled;
     *
     *  
        if (size < capacity) {  
        if (sortSpec == null || sortSpec.limit() <= 0 || sortSpec.limit() > MAX_CAPACITY) {
     * a row the wait-for-all baseline would surface, so it is kept. Same rule as vanilla's
     * rarely fills up anyway — above it the gate would be pure overhead, so we build none.
        // Calcite maps DESC to NULLS FIRST, so one null outranks every real value and puts the  
    /**
 *
     * shard claimed it did not have. Either {@linkplain #disable() retires the gate}, because both
 *  
    /**
        if (index < 0) {  
    /**  
     */
                return;  
            retire("sort column '" + column + "' contains nulls the shard bounds did not report");
        return size == capacity;
    }  
            int worst = (right < size && outranks(heap[left], heap[right])) ? right : left;
        }
        if (rows == 0) {
        int index = indexOf(vsr, column);
    // The heap keeps the WORST of the top-K at the root, so admitting a key is one compare against
    }  
            }
     * at all when they disagree. See doc 16 Stage 7.
        readInto(vector, rows);
 * threads, one per shard, and the verdict is read on whichever thread frees a dispatch slot. The  
            return false;  
    private void readInto(FieldVector vector, int rows) {
            return;
        return heap[0];  
     * gate can never eliminate — the fail-open direction. {@code short} and {@code byte} columns land
    private final long[] heap;
            // feature. Skipping the check instead would hand getVector(-1) an out-of-range index and  
                break; // parent already no better than the child — heap order holds
     * Offers one sort key. Kept while the heap isn't full, or if it beats the current worst;
        this.column = column;
    public synchronized boolean isArmed() {
    /** Once set, every question answers "keep the shard". See {@link #disable}. */
        } else if (vector instanceof TimeStampNanoVector nanos) {
            swap(parent, index);  
        // shard in the top-K on its own.
        this.heap = new long[capacity];
    private void siftUp(int index) {  
 * critical section is a few {@code long} compares. {@link #feed} deliberately is <em>not</em>
     * {@code SortGateWiringTests}, which asserts the gate was built from the sort spec's limit.  
    }
     * Largest {@code K} worth gating. The heap costs {@code 8·K} bytes, and a limit this large  
        if (disabled) {  
    private final String column;
     * is what only the data can show — a sort column absent from the response schema, or nulls a  
    }  
     *  
        this.capacity = capacity;  
            // Not a schema worth judging — an empty batch must not retire the gate.
            }
    private boolean outranks(long a, long b) {
            siftDown(0);
        // Most-specific type first. The TimeStamp*Vector classes aren't BigIntVector subclasses,
        return -1;  
