    public interface ExtraData {
import java.io.IOException;
        }
    /**
            protected abstract long docValue();
        }
                    worstIndex = rightIndex;
        long end = rootIndex + bucketSize;
    public final List<SortValue> getValues(long bucket) {
    public abstract Leaf forLeaf(LeafReaderContext ctx) throws IOException;
            protected Leaf(LeafReaderContext ctx) {
        }
         * @opensearch.internal
 * compatible open source license.
    protected abstract SortValue getValue(long index);
         */
 * Modifications Copyright OpenSearch Contributors. See
        protected final SortValue getValue(long index) {
         * Leaf for floats
    }
            }
     * {@link SortOrder#ASC} and "higher" for {@link SortOrder#DESC}.
        protected final boolean betterThan(long lhs, long rhs) {
            values.set(rootIndex, offset);
        /**
     * Superclass for implementations of {@linkplain BucketedSort} for {@code unsigned long} keys.
            void loadFromDoc(long index, int doc) throws IOException;
         * Prepare to load extra data from a leaf.
        }
            long parentIndex = rootIndex + parent;
     * An implementation of {@linkplain ExtraData} that does nothing.
     * {@code true} if the bucket is in heap mode, {@code false} if
            protected final void setIndexToDocValue(long index) {
            return emptyList();
         * Leaf for bucketed sort
            protected final void setIndexToDocValue(long index) {
            initGatherOffsets();
     * Correct the heap invariant of a parent and its children. This
    private void grow(long minSize) {
            }
            if (bucketSize > MAX_BUCKET_SIZE) {
 * We actually *oversize* the allocations
    /**
        @Override
     * While this *looks* like it could easily be {@code O(n * log n)}, it is
 * </p>
        }
            return values.get(rootIndex);
            /**
     * Get the value at an index.
        }
            }
         *
        }
import java.util.List;
        }
        @Override
        protected final boolean betterThan(long lhs, long rhs) {
        // Set the next gather offsets for all newly allocated buckets.
     */
        for (int parent = maxParent; parent >= 0; parent--) {
}
        }
         * {@link Loader#loadFromDoc(long, int)} so the implementer shouldn't
        private ExtraData.Loader loader() throws IOException {
            @Override
        for (long bucketRoot = startingAt; bucketRoot < values().size(); bucketRoot += getBucketSize()) {
                heapMode.set(bucket);
             * for {@link #setIndexToDocValue(long)}.
        protected final void swap(long lhs, long rhs) {
            this.ctx = ctx;
     *
         * @opensearch.internal
import org.opensearch.common.annotation.PublicApi;
            public final void setScorer(Scorable scorer) {}
            return values;
     * at {@code rootIndex}.
            return SortValue.from(values.get(index));
     * Swap the data at two indices.
    /**
            values.set(rootIndex, offset);
 * software distributed under the License is distributed on an
            @Override
/*
     * @throws IOException most implementations need to perform IO to prepare for each leaf
     * Used with {@link BucketedSort#getValues(long, ResultBuilder)} to
    public final SortOrder getOrder() {
                    loader().loadFromDoc(rootIndex, doc);
            }
     * <a href="https://en.wikipedia.org/w/index.php?title=Binary_heap&oldid=940542991#Building_a_heap">wikipedia</a>
        public ForInts(BigArrays bigArrays, SortOrder sortOrder, DocValueFormat format, int bucketSize, ExtraData extra) {
         * Leaf for bucketed sort
            if (leftChild < bucketSize) {
        protected final BigArray values() {
 * You may obtain a copy of the License at
                values.set(index, docValue());
        int maxParent = bucketSize / 2 - 1;
                values.set(index, docValue());
            loader().loadFromDoc(index, doc);
                close();
        return heapMode.get(bucket);
     * Is this bucket a min heap {@code true} or in gathering mode {@code false}?
            values.set(rootIndex, offset);
            swap(worstIndex, parentIndex);
     * <p>
 *
     * Grow the {@linkplain BigArray} backing this sort to account for new buckets.
    }
                super(ctx);
         * Collect this doc, returning {@code true} if it is competitive.
            @Override
        }
     */
    /**
            }
    private void setNextGatherOffsets(long startingAt) {
     */
        /**
        @Override
         */
            return getOrder().reverseMul() * Integer.compare(values.get(lhs), values.get(rhs)) < 0;
        }
        @Override
            protected Leaf(LeafReaderContext ctx) {
    /**
        @Override
     * the entry at {@code rhs}. "Better" in this means "lower" for
            // We've never seen this bucket.
     * Heapify a bucket who's entries are in random order.
             * Return the value for of this sort for the document to which
            @Override
    }
/*
import org.opensearch.common.util.FloatArray;
 * SPDX-License-Identifier: Apache-2.0
/**
        }
            @Override
        }
            protected abstract float docValue();
            long worstIndex = parentIndex;
            return;
    protected abstract void growValues(long minSize);
        public static final int MAX_BUCKET_SIZE = (int) Math.pow(2, 24);
        /**
     * @param rootIndex the index the start of the bucket
        protected final int getNextGatherOffset(long rootIndex) {
            @Override
            }
         * @opensearch.internal
                long rightIndex = rootIndex + rightChild;
        @Override
                    worst = rightChild;
                super(ctx);
     *
            }
    @PublicApi(since = "1.0.0")
        protected final void setNextGatherOffset(long rootIndex, int offset) {
    }
     * @opensearch.api
                return getOrder().reverseMul() * Float.compare(docValue(), values.get(index)) < 0;
            public final void setScorer(Scorable scorer) {}
        setNextGatherOffsets(oldMax - (oldMax % getBucketSize()) + getBucketSize());
    /**
        private final LeafReaderContext ctx;
     * Average Case Analysis of Heap Building byRepeated Insertion</a> J. Algorithms.
            }
        protected abstract void setIndexToDocValue(long index);
            values.set(rootIndex, offset);
        protected final SortValue getValue(long index) {
     * <li>Hayward, Ryan; McDiarmid, Colin (1991).
            if (loader == null) {
    /**
        protected final void setNextGatherOffset(long rootIndex, int offset) {
        @Override
     * @opensearch.api
import org.opensearch.common.util.LongArray;
                + " < "
        /**
     */
     * The order of the sort.
 * order, they mostly won't be. Extracting results in sorted order is still
    protected abstract void setNextGatherOffset(long rootIndex, int offset);
         */
     * then returns an empty list.
        /**
        }
        }
     * it is still gathering.
        void swap(long lhs, long rhs);
        @FunctionalInterface
         * @opensearch.internal
    /**
    }
            values.set(rhs, tmp);
            return (int) values.get(rootIndex);
     */
            super(bigArrays, sortOrder, format, bucketSize, extra);
        protected final void growValues(long minSize) {
        @Override
     */
     * @opensearch.api
     * Allocate storage for more buckets and store the "next gather offset"
        protected final boolean betterThan(long lhs, long rhs) {
        long start = inHeapMode(bucket) ? rootIndex : (rootIndex + getNextGatherOffset(rootIndex) + 1);
        public final boolean needsScores() {
    }
         * Swap the position of two bits of extra data.
            long requiredSize = rootIndex + bucketSize;
             * because it is called twice per competitive hit when in heap
 * bucket and collecting a value is just adding it in the next slot bumping
            return loader;
        }
                super(ctx);
        heapMode = new BitArray(1, bigArrays);
             * we just {@link #advanceExact(int) moved}. This should be fast
            }
    @Override
        this.bucketSize = bucketSize;
        protected abstract boolean docBetterThan(long index);
            /**
    }
        private ExtraData.Loader loader = null;
     */
        protected final void growValues(long minSize) {
                int rightChild = leftChild + 1;
    public abstract static class ForLongs extends BucketedSort {
 * {@code O(n)} time. Or into max heap, if {@link #order} is ascending.
import org.opensearch.core.common.util.BigArray;
                if (rightChild < bucketSize && betterThan(worstIndex, rightIndex)) {
 * slots to hold all sort values for the entire bucket. In other words: the
            // This cast is safe because all ints fit accurately into a double.
            long index = next + rootIndex;
             * we just {@link #advanceExact(int) moved}. This should be fast
         *
                throw new IllegalArgumentException("bucket size must be less than [2^24] but was [" + bucketSize + "]");
     * Get the values for a bucket if it has been collected. If it hasn't
        }
        protected final BigArray values() {
            /**
                }
                    downHeap(rootIndex, 0);
     */
            /**
             * mode, once for {@link #docBetterThan(long)} and once
 * {@link BigArrays} so it doesn't need to allocate any objects per bucket
    }
        protected final SortValue getValue(long index) {
        }
            initGatherOffsets();
         */
        private DoubleArray values = bigArrays.newDoubleArray(getBucketSize(), false);
        growValues(minSize);
                if (betterThan(worstIndex, leftIndex)) {
    private final DocValueFormat format;
         *
    /**
 * ownership. Elasticsearch licenses this file to you under
     * Callbacks for storing extra data along with competitive sorts.
        }
            }
            @Override
     * at {@code rootIndex}.
        protected abstract class Leaf extends BucketedSort.Leaf {
        }
        @Override
             * mode, once for {@link #docBetterThan(long)} and once
     */
        }
            values.set(rhs, tmp);
        @Override
    public abstract boolean needsScores();
     * build results from the sorting operation.
        protected final void swap(long lhs, long rhs) {
 * <li>They can have many, many buckets so this implementation backs to
    protected abstract int getNextGatherOffset(long rootIndex);
    }
            }
    public abstract class Leaf implements ScorerAware {
         * The maximum size of buckets this can store. This is because we
     */
         * Read the sort value from {@code doc} and return {@code true}
                return;
            return SortValue.from(values.get(index));
         * Leaf for bucketed sort
     * Get the next index that should be "gathered" for a bucket rooted
     * Set the next index that should be "gathered" for a bucket rooted
        @PublicApi(since = "1.0.0")
        public ForUnsignedLongs(BigArrays bigArrays, SortOrder sortOrder, DocValueFormat format, int bucketSize, ExtraData extra) {
        /**
     * runs in {@code O(log n)} time.
        @Override
 */
    /**
import org.opensearch.common.util.BigArrays;
 * specific language governing permissions and limitations
    public abstract static class ForFloats extends BucketedSort {
 * filled buckets.
 */
    }
    private final ExtraData extra;
        @Override
                loader = extra.loader(ctx);
    protected abstract void swap(long lhs, long rhs);
         */
        @Override
            long rootIndex = bucket * bucketSize;
        }
                values.set(index, docValue());
     */
        @Override
            initGatherOffsets();
        @Override
            values.set(rhs, tmp);
        }
             */
    protected BucketedSort(BigArrays bigArrays, SortOrder order, DocValueFormat format, int bucketSize, ExtraData extra) {
 * license agreements. See the NOTICE file distributed with
        public ForLongs(BigArrays bigArrays, SortOrder sortOrder, DocValueFormat format, int bucketSize, ExtraData extra) {
    private boolean inHeapMode(long bucket) {
     * The format to use when presenting the values.
    @PublicApi(since = "1.0.0")
        }
         *
            return (index, doc) -> {};
        }
     * @param rootIndex index of the start of the bucket
    /**
            /**
        }
        @Override
     * Maintain the "next gather offsets" for newly allocated buckets.
        }
    /**
            if (worst == parent) {
@PublicApi(since = "1.0.0")
    /**
     */
    }
        @Override
 * GitHub history for details.
        StringBuilder b = new StringBuilder();
            return SortValue.from(values.get(index));
    }
        @Override
        @Override
         */
     */
            long leftIndex = rootIndex + leftChild;
        protected final boolean betterThan(long lhs, long rhs) {
    /**
        public Loader loader(LeafReaderContext ctx) throws IOException {
                return getOrder().reverseMul() * Integer.compare(docValue(), values.get(index)) < 0;
            }
    /**
            long tmp = values.get(lhs);
        }
            protected Leaf(LeafReaderContext ctx) {
            protected final boolean docBetterThan(long index) {
        }
    }
 * Unless required by applicable law or agreed to in writing,
            @Override
     */
            protected abstract int docValue();
            }
    }
 * this file be licensed under the Apache-2.0 license or a
        List<T> result = new ArrayList<>(bucketSize);
            return (int) values.get(rootIndex);
        @Override
 */
 * Every bucket is in one of two states: "gathering" or min/max "heap". While
     * been a bunch of work that puts this at {@code O(n)}, close to 1.88n worst
        return getValues(bucket, (i, sv) -> sv);
    public abstract static class ForUnsignedLongs extends BucketedSort {
        @Override
            }
    /**
         */
            return values;
            if (index % bucketSize == 0) {
            @Override
        this.order = order;
 *
         * store the next offset to write to in a float and floats only have
        }
            return false;
             * because it is called twice per competitive hit when in heap
         */
     * <p>
        @Override
        for (long index = start; index < end; index++) {
 * "gathering" the next empty slot is stored in the "root" offset of the
                    worstIndex = leftIndex;
         * @opensearch.api
        protected final void growValues(long minSize) {
             * storage to fit the {@code index}.
     *
        public boolean needsScores() {
         */
 * (like {@link BigArrays#overSize(long)}) to get amortized linear number
         * we just advanced.
     * <ul>
     * <a href="https://web.archive.org/web/20160205023201/http://www.stats.ox.ac.uk/__data/assets/pdf_file/0015/4173/heapbuildjalg.pdf">
     */
            initGatherOffsets();
         * Set the value at the index to the value of the document to which
     * Get the {@linkplain Leaf} implementation that'll do that actual collecting.
     * <li>D.E. Knuth, ”The Art of Computer Programming, Vol. 3, Sorting and Searching”</li>
     */
         */
        protected final int getNextGatherOffset(long rootIndex) {
     */
    protected final String debugFormat() {
        long oldMax = values().size() - 1;
         * Loader for extra data
            values.set(rhs, tmp);
 * Aggregations have a couple of super interesting characteristics:
             * we just {@link #advanceExact(int) moved}. This should be fast
            @Override
        protected final BigArray values() {
 * <p>
        Loader loader(LeafReaderContext ctx) throws IOException;
     *               For example, 0 is the "root".
     */
        @Override
            }
            protected final void setIndexToDocValue(long index) {
             * Implementers <strong>should</strong> grow their underlying
    public abstract static class ForInts extends BucketedSort {
    };
        protected final void setNextGatherOffset(long rootIndex, int offset) {
            if (false == advanceExact(doc)) {
         * {@code true} if the sort value for the doc is "better" than the
     */
        @Override
        return result;
 * The OpenSearch Contributors require contributions made to
        protected final int getNextGatherOffset(long rootIndex) {
     * Superclass for implementations of {@linkplain BucketedSort} for {@code long} keys.
         * Both parameters will have previously been loaded by
        }
                break;
         * {@code 23} bits of mantissa so they can't accurate store values
                    worst = leftChild;
        /**
        public ForFloats(BigArrays bigArrays, SortOrder sortOrder, DocValueFormat format, int bucketSize, ExtraData extra) {
             */
            return (int) values.get(rootIndex);
        }
     * Get the values for a bucket if it has been collected. If it hasn't
 * <ul>
        // TODO we usually have a heap here so we could use that to build the results sorted.
        /**
            values.set(lhs, values.get(rhs));
            downHeap(rootIndex, parent);
             * mode, once for {@link #docBetterThan(long)} and once
     */
     * </ul>
     * Superclass for implementations of {@linkplain BucketedSort} for {@code int} keys.
             * for {@link #setIndexToDocValue(long)}.
            setIndexToDocValue(index);
    public final void close() {
        protected final void growValues(long minSize) {
    /**
                }
    private void downHeap(long rootIndex, int parent) {
        /**
     * <p>
        }
            return false;
        protected final BigArray values() {
     * @param builder builds results. See {@link ExtraData} for how to store
            return getOrder().reverseMul() * Double.compare(values.get(lhs), values.get(rhs)) < 0;
        @Override
import org.opensearch.common.lease.Releasables;
         * {@link SortOrder#ASC} and "higher" for {@link SortOrder#DESC}.
            protected final boolean docBetterThan(long index) {
                super(ctx);
        }
        this.format = format;
        }
         * @opensearch.internal
        /**
        this.extra = extra;
        }
                + next
        /**
            }
            protected Leaf(LeafReaderContext ctx) {
        private LongArray values = bigArrays.newLongArray(1, false);
            values.set(rhs, tmp);
            /*
                if (docBetterThan(rootIndex)) {
            }
            protected final void setIndexToDocValue(long index) {
     * Performs the actual collection against a {@linkplain LeafReaderContext}.
import java.util.ArrayList;
        protected final int getNextGatherOffset(long rootIndex) {
        protected abstract class Leaf extends BucketedSort.Leaf {
                    setIndexToDocValue(rootIndex);
    /**
             */
             * </p>
            public final void setScorer(Scorable scorer) {}
    public final <T extends Comparable<T>> List<T> getValues(long bucket, ResultBuilder<T> builder) {
     * a fairly well studied algorithm attributed to Floyd. There's
     * </p>
                grow(requiredSize);
            parent = worst;
             * Load extra data from a doc.
 * not use this file except in compliance with the License.
     * Return a fairly human readable representation of the array backing the sort.
     * </p>
    }
        private FloatArray values = bigArrays.newFloatArray(1, false);
 *
            int leftChild = parent * 2 + 1;
                values.set(index, docValue());
     * entry on binary heaps for more about this.
        @Override
import static java.util.Collections.emptyList;
                values.set(index, docValue());
        protected final int getNextGatherOffset(long rootIndex) {
                return getOrder().reverseMul() * Long.compareUnsigned(docValue(), values.get(index)) < 0;
        /**
         */
     * case.
    public abstract static class ForDoubles extends BucketedSort {
            }
        /**
            values = bigArrays.grow(values, minSize);
            values.set(lhs, values.get(rhs));
        protected final void swap(long lhs, long rhs) {
     */
            @Override
        int nextOffset = getBucketSize() - 1;
         */
     * This will only be called if the array is too small.
    public interface ResultBuilder<T> {
        }
                b.append('\n').append(String.format(Locale.ROOT, "%20d", index / bucketSize)).append(":  ");
        if (rootIndex >= values().size()) {
     * "upwards", pushing any out of order parents "down". Check out the
         * </p>
            protected Leaf(LeafReaderContext ctx) {
         * <p>
     * Superclass for implementations of {@linkplain BucketedSort} for {@code float} keys.
        }
        @Override
     * This is intentionally not a {@link #toString()} implementation because it'll
     */
        @Override
     */
    /**
            int tmp = values.get(lhs);
 * under the License.
        }
            return values;
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
    }
        private LongArray values = bigArrays.newLongArray(1, false);
        @Override
import org.apache.lucene.index.LeafReaderContext;
            return SortValue.fromUnsigned(values.get(index));
        public void swap(long lhs, long rhs) {}
     * for those new buckets.
             * we just {@link #advanceExact(int) moved}. This should be fast
        }
            return (int) values.get(rootIndex);
             * Return the value for of this sort for the document to which
     * Initialize the gather offsets after setting up values. Subclasses
        }
package org.opensearch.search.sort;
            values = bigArrays.grow(values, minSize);
        return order;
            protected final boolean docBetterThan(long index) {
 * Licensed to Elasticsearch under one or more contributor
        for (long index = 0; index < values().size(); index++) {
            extra.swap(worstIndex, parentIndex);
                return;
             * Return the value for of this sort for the document to which
         * Leaf for doubles
        }
        @Override
    /**
    private final SortOrder order;
 * </p>
            result.add(builder.build(index, getValue(index)));
import org.apache.lucene.search.Scorable;
        return b.toString();
        protected abstract class Leaf extends BucketedSort.Leaf {
            return values;
        /**
     */
        protected abstract class Leaf extends BucketedSort.Leaf {
        Releasables.close(values(), heapMode);
            return SortValue.from(values.get(index));
    private final BitArray heapMode;
     * Superclass for implementations of {@linkplain BucketedSort} for {@code double} keys.
            return false;
     * should call this once, after setting up their {@link #values()}.
 * </p>
        protected final SortValue getValue(long index) {
import org.opensearch.common.lucene.ScorerAware;
         * if there is a value for that document. Otherwise return
     */
 * of allocations and to play well with our paged arrays.
            protected final boolean docBetterThan(long index) {
    /**
                return getOrder().reverseMul() * Double.compare(docValue(), values.get(index)) < 0;
     * The {@linkplain BigArray} backing this sort.
         * higher than {@code 2 ^ 24}.
            return getOrder().reverseMul() * Long.compare(values.get(lhs), values.get(rhs)) < 0;
    }
 * @opensearch.api
        }
 * is competitive at all which, so long as buckets aren't hit in reverse
         * {@code false} and the sort will skip that document.
             * This cast will not lose precision because we make sure never
    protected final void initGatherOffsets() {
 * Extracting the results in sorted order is {@code O(n * log n)} because,
            int worst = parent;
        @Override
            assert 0 <= next && next < bucketSize : "Expected next to be in the range of valid buckets [0 <= "
 * {@code O(n * log n)}.
                    // TODO a "bottom up" insert would save a couple of comparisons. Worth it?
     * The number of values to store per bucket.
            values = bigArrays.grow(values, minSize);
            if (inHeapMode(bucket)) {
 * track memory usage and abort execution if it grows too large.</li>
        }
         * entry at {@code index}. "Better" in means is "lower" for
            return getOrder().reverseMul() * Float.compare(values.get(lhs), values.get(rhs)) < 0;
import org.opensearch.common.util.DoubleArray;
                heapify(rootIndex);
        @Override
        }
            values.set(rootIndex, offset);
        private IntArray values = bigArrays.newIntArray(1, false);
            @Override
        interface Loader {
    }
    protected abstract boolean betterThan(long lhs, long rhs);
 * Type specialized sort implementations designed for use in aggregations.
    public int getBucketSize() {
 * and the circuit breaker in {@linkplain BigArrays} will automatically
            values.set(lhs, values.get(rhs));
                }
            return getOrder().reverseMul() * Long.compareUnsigned(values.get(lhs), values.get(rhs)) < 0;
        protected final boolean betterThan(long lhs, long rhs) {
     * then returns an empty array.
             */
             */
            return values;
            @Override
    @FunctionalInterface
        protected abstract class Leaf extends BucketedSort.Leaf {
    private final int bucketSize;
            values = bigArrays.grow(values, minSize);
                + bucketSize
            setNextGatherOffset(bucketRoot, nextOffset);
     * @param parent Index within the bucket of the parent to check.
 * the tracking value at the root. So collecting values is {@code O(1)}.
        }
         * need to grow the underlying storage to implement this.
    private void heapify(long rootIndex) {
    protected final BigArrays bigArrays;
import java.util.Comparator;
                setNextGatherOffset(rootIndex, next - 1);
import org.opensearch.common.lease.Releasable;
        T build(long index, SortValue sortValue);
         *
        public final void collect(int doc, long bucket) throws IOException {
 * these implementations delay as much work as possible until collection</li>
                super(ctx);
        protected final SortValue getValue(long index) {
            b.append(String.format(Locale.ROOT, "%20s", getValue(index))).append(' ');
            protected final boolean docBetterThan(long index) {
            int next = getNextGatherOffset(rootIndex);
 * {@link #bucketSize} entries it is converted into a min "heap" in
            }
             * Return the value for of this sort for the document to which
            float tmp = values.get(lhs);
        protected abstract boolean advanceExact(int doc) throws IOException;
        protected final void growValues(long minSize) {
            }
        @Override
            } else {
    }
     * be quite slow.
            double tmp = values.get(lhs);
 * this work for additional information regarding copyright
            super(bigArrays, sortOrder, format, bucketSize, extra);
        @Override
        result.sort(order.wrap(Comparator.<T>naturalOrder()));
    /**
        }
             * we just {@link #advanceExact(int) moved}. This should be fast
    /**
                + "]";
                return getOrder().reverseMul() * Long.compare(docValue(), values.get(index)) < 0;
            }
 * KIND, either express or implied.  See the License for the
        protected final BigArray values() {
        }
        }
    }
     * </p>
        public final boolean needsScores() {
import java.util.Locale;
        @Override
     */
public abstract class BucketedSort implements Releasable {
 * well, sorting is {@code O(n * log n)}. When a bucket has collected
    public static final ExtraData NOOP_EXTRA_DATA = new ExtraData() {
         *
             * mode, once for {@link #docBetterThan(long)} and once
 * <li>Its fairly common for a bucket to be collected but not returned so
    /**
/*
             * mode, once for {@link #docBetterThan(long)} and once
            /**
        @Override
        protected final void swap(long lhs, long rhs) {
             */
    protected abstract BigArray values();
             * for {@link #setIndexToDocValue(long)}.
         */
            return false;
        return bucketSize;
     * Does this sort need scores? Most don't, but sorting on {@code _score} does.
    }
     *                data along side the sort for this to extract.
            values = bigArrays.grow(values, minSize);
        @Override
        }
     */
             * because it is called twice per competitive hit when in heap
        }
        this.bigArrays = bigArrays;
    public final DocValueFormat getFormat() {
             * for {@link #setIndexToDocValue(long)}.
 */
    /**
         */
             * because it is called twice per competitive hit when in heap
             * <p>
            protected abstract double docValue();
import org.opensearch.common.util.BitArray;
     */
 * <p>
 * worst case. Critically, it is a very fast {@code O(1)} to check if a value
        @Override
 * When we first collect a bucket we make sure that we've allocated enough
            long tmp = values.get(lhs);
            }
            values.set(lhs, values.get(rhs));
        protected final void setNextGatherOffset(long rootIndex, int offset) {
             * Return the value for of this sort for the document to which
        public final boolean needsScores() {
            initGatherOffsets();
    /**
        @Override
        @Override
    /**
        public ForDoubles(BigArrays bigArrays, SortOrder sortOrder, DocValueFormat format, int bucketSize, ExtraData extra) {
            protected final void setIndexToDocValue(long index) {
     */
        while (true) {
    @PublicApi(since = "1.0.0")
            }
        protected final void setNextGatherOffset(long rootIndex, int offset) {
import org.opensearch.search.DocValueFormat;
        setNextGatherOffsets(0);
            if (next == 0) {
            if (values().size() < requiredSize) {
     */
        }
     */
    /**
            values.set(lhs, values.get(rhs));
        }
 * <p>
         * Get the extra data loader, building it if we haven't yet built one for this leaf.
             * for {@link #setIndexToDocValue(long)}.
    /**
        protected final void swap(long lhs, long rhs) {
            super(bigArrays, sortOrder, format, bucketSize, extra);
            }
 * </p>
    /**
        }
             * to write values here that float can't store precisely.
            // Gathering mode
 * storage is "dense" and we don't try to save space when storing partially
 * the Apache License, Version 2.0 (the "License"); you may
 *
        }
        long rootIndex = bucket * bucketSize;
        }
        }
        }
    /**
            super(bigArrays, sortOrder, format, bucketSize, extra);
        return format;
             */
             * because it is called twice per competitive hit when in heap
import org.opensearch.common.util.IntArray;
    }
 * </ul>
            protected abstract long docValue();
        }
        @Override
            public final void setScorer(Scorable scorer) {}
            @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            super(bigArrays, sortOrder, format, bucketSize, extra);
 * <p>
 * Once a "heap", collecting a document is the heap-standard {@code O(log n)}
        protected Leaf(LeafReaderContext ctx) {
     * {@code true} if the entry at index {@code lhs} is "better" than
     * This works by validating the heap property on each node, iterating
