        /**
        @Override
        return b.toString();  
     * should call this once, after setting up their {@link #values()}.
     * for those new buckets.
        protected final void swap(long lhs, long rhs) {
        }  
                close();  
     * Superclass for implementations of {@linkplain BucketedSort} for {@code long} keys.
     * Used with {@link BucketedSort#getValues(long, ResultBuilder)} to
        protected final void swap(long lhs, long rhs) {
     * The order of the sort.
        setNextGatherOffsets(oldMax - (oldMax % getBucketSize()) + getBucketSize());
            protected Leaf(LeafReaderContext ctx) {
     */  
                    worstIndex = rightIndex;  
    private boolean inHeapMode(long bucket) {
        }
        interface Loader {
 * well, sorting is {@code O(n * log n)}. When a bucket has collected
        protected final int getNextGatherOffset(long rootIndex) {  
            }
            return false;
    protected abstract boolean betterThan(long lhs, long rhs);
    public final <T extends Comparable<T>> List<T> getValues(long bucket, ResultBuilder<T> builder) {
    @Override  
 *  
     * "upwards", pushing any out of order parents "down". Check out the  
        protected final boolean betterThan(long lhs, long rhs) {  
        }  
 * is competitive at all which, so long as buckets aren't hit in reverse  
             * for {@link #setIndexToDocValue(long)}.
            float tmp = values.get(lhs);  
            // This cast is safe because all ints fit accurately into a double.
    public abstract static class ForUnsignedLongs extends BucketedSort {  
     *
                return getOrder().reverseMul() * Long.compare(docValue(), values.get(index)) < 0;
import org.opensearch.common.util.DoubleArray;  
                if (rightChild < bucketSize && betterThan(worstIndex, rightIndex)) {
    /**  
        }  
    }
         * {@code true} if the sort value for the doc is "better" than the
         */  
        protected final void setNextGatherOffset(long rootIndex, int offset) {
        public ForLongs(BigArrays bigArrays, SortOrder sortOrder, DocValueFormat format, int bucketSize, ExtraData extra) {  
        }  
        return heapMode.get(bucket);  
     * at {@code rootIndex}.  
     * Initialize the gather offsets after setting up values. Subclasses
            @Override
                loader = extra.loader(ctx);  
            @Override  
 * </p>
            }  
 * order, they mostly won't be. Extracting results in sorted order is still
             * mode, once for {@link #docBetterThan(long)} and once
        private ExtraData.Loader loader() throws IOException {
 * You may obtain a copy of the License at  
            /**  
    /**  
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
        @Override
     */
    @PublicApi(since = "1.0.0")
        }
     */
         *
        @Override
import org.opensearch.search.DocValueFormat;
             * mode, once for {@link #docBetterThan(long)} and once
                return getOrder().reverseMul() * Float.compare(docValue(), values.get(index)) < 0;
            @Override  
 * this file be licensed under the Apache-2.0 license or a
        protected final int getNextGatherOffset(long rootIndex) {  
         *
    protected final BigArrays bigArrays;
            // We've never seen this bucket.
        if (rootIndex >= values().size()) {  
     */
    }
         *
        protected final boolean betterThan(long lhs, long rhs) {  
    /**  
     * Performs the actual collection against a {@linkplain LeafReaderContext}.  
     */
            public final void setScorer(Scorable scorer) {}
 * The OpenSearch Contributors require contributions made to  
    public final DocValueFormat getFormat() {
 * {@link BigArrays} so it doesn't need to allocate any objects per bucket
            return SortValue.fromUnsigned(values.get(index));
 * not use this file except in compliance with the License.
    }
public abstract class BucketedSort implements Releasable {
        @FunctionalInterface
    /**  
        @Override
        @Override
    }
             * Load extra data from a doc.  
     */
                + "]";
        protected abstract class Leaf extends BucketedSort.Leaf {
            if (loader == null) {
        }
     * {@code true} if the bucket is in heap mode, {@code false} if
import java.io.IOException;
            super(bigArrays, sortOrder, format, bucketSize, extra);
 * Aggregations have a couple of super interesting characteristics:
        protected final void setNextGatherOffset(long rootIndex, int offset) {  
        /**
             * storage to fit the {@code index}.  
            initGatherOffsets();
 * this work for additional information regarding copyright
            void loadFromDoc(long index, int doc) throws IOException;  
     * entry on binary heaps for more about this.
     * <ul>
            }
            protected abstract float docValue();
    /**
                    setIndexToDocValue(rootIndex);  
    protected abstract void growValues(long minSize);
 * and the circuit breaker in {@linkplain BigArrays} will automatically  
        protected final boolean betterThan(long lhs, long rhs) {
        protected abstract void setIndexToDocValue(long index);
        return getValues(bucket, (i, sv) -> sv);
     */
        this.order = order;  
            super(bigArrays, sortOrder, format, bucketSize, extra);
                }
         */  
        /**  
        protected final void growValues(long minSize) {  
            @Override
        @Override
        protected abstract boolean docBetterThan(long index);
            }  
    /**
            return values;  
        }  
             * mode, once for {@link #docBetterThan(long)} and once
            super(bigArrays, sortOrder, format, bucketSize, extra);
                    worst = leftChild;
                }
         * Both parameters will have previously been loaded by  
                + next
        heapMode = new BitArray(1, bigArrays);
         * need to grow the underlying storage to implement this.
     * <p>
                    loader().loadFromDoc(rootIndex, doc);
            public final void setScorer(Scorable scorer) {}
            values.set(rootIndex, offset);  
        @Override  
        protected final boolean betterThan(long lhs, long rhs) {  
         * {@code false} and the sort will skip that document.
                int rightChild = leftChild + 1;
        }
            }  
                b.append('\n').append(String.format(Locale.ROOT, "%20d", index / bucketSize)).append(":  ");
    protected BucketedSort(BigArrays bigArrays, SortOrder order, DocValueFormat format, int bucketSize, ExtraData extra) {
    private void heapify(long rootIndex) {  
            @Override  
 * We actually *oversize* the allocations
     */  
import org.opensearch.common.util.BitArray;
    /**  
            }
        }  
         */
            public final void setScorer(Scorable scorer) {}
            if (inHeapMode(bucket)) {  
    /**
         *
    }
             */
    /**
     * Get the value at an index.
    protected final String debugFormat() {
        StringBuilder b = new StringBuilder();
         * Get the extra data loader, building it if we haven't yet built one for this leaf.
        }  
            /**
        private final LeafReaderContext ctx;  
             * to write values here that float can't store precisely.
             * </p>
            this.ctx = ctx;
            long tmp = values.get(lhs);  
    /**
            @Override  
        public void swap(long lhs, long rhs) {}  
            return;
        }  
        }  
        private LongArray values = bigArrays.newLongArray(1, false);
     */
     * Superclass for implementations of {@linkplain BucketedSort} for {@code unsigned long} keys.
        public final void collect(int doc, long bucket) throws IOException {
import java.util.List;
                + bucketSize  
        }  
            return SortValue.from(values.get(index));
            }  
    public abstract Leaf forLeaf(LeafReaderContext ctx) throws IOException;
        long end = rootIndex + bucketSize;
        public Loader loader(LeafReaderContext ctx) throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
            values.set(lhs, values.get(rhs));
            }
            protected Leaf(LeafReaderContext ctx) {  
        setNextGatherOffsets(0);
     *                data along side the sort for this to extract.
     * <li>Hayward, Ryan; McDiarmid, Colin (1991).
            int next = getNextGatherOffset(rootIndex);
         */  
 * compatible open source license.
import org.opensearch.core.common.util.BigArray;
                super(ctx);  
    }
            swap(worstIndex, parentIndex);  
 * <ul>  
            }
 * </p>  
            values.set(lhs, values.get(rhs));
        result.sort(order.wrap(Comparator.<T>naturalOrder()));
        }
             * mode, once for {@link #docBetterThan(long)} and once
        }  
            setIndexToDocValue(index);  
        this.extra = extra;  
            /**  
         * </p>  
        /**
         * Leaf for doubles
import static java.util.Collections.emptyList;
        public ForFloats(BigArrays bigArrays, SortOrder sortOrder, DocValueFormat format, int bucketSize, ExtraData extra) {  
         */  
        @Override  
    }  
        @Override
             */  
             */  
        for (long index = start; index < end; index++) {
    }
        @Override  
    /**
    public abstract class Leaf implements ScorerAware {
    public final SortOrder getOrder() {
    protected abstract int getNextGatherOffset(long rootIndex);
         * {@code 23} bits of mantissa so they can't accurate store values
            protected Leaf(LeafReaderContext ctx) {
                return getOrder().reverseMul() * Integer.compare(docValue(), values.get(index)) < 0;
 * software distributed under the License is distributed on an
        /**  
             * we just {@link #advanceExact(int) moved}. This should be fast
            long rootIndex = bucket * bucketSize;
        }
    }
            initGatherOffsets();
            values.set(rhs, tmp);  
        public ForInts(BigArrays bigArrays, SortOrder sortOrder, DocValueFormat format, int bucketSize, ExtraData extra) {  
        protected abstract class Leaf extends BucketedSort.Leaf {
import org.opensearch.common.lease.Releasables;
            protected final boolean docBetterThan(long index) {  
        }
        @Override
             * Return the value for of this sort for the document to which
    @PublicApi(since = "1.0.0")
        @Override
/**  
             * because it is called twice per competitive hit when in heap
         * we just advanced.
     * While this *looks* like it could easily be {@code O(n * log n)}, it is
        }
        @Override  
     *
    /**
     * <p>
 * filled buckets.
         * entry at {@code index}. "Better" in means is "lower" for
            values.set(rhs, tmp);
            }
             */  
        @Override  
        protected final SortValue getValue(long index) {
     * <li>D.E. Knuth, ”The Art of Computer Programming, Vol. 3, Sorting and Searching”</li>
            @Override
     * This works by validating the heap property on each node, iterating
     * @param parent Index within the bucket of the parent to check.
            @Override  
    protected abstract BigArray values();
     */  
        protected final void growValues(long minSize) {
        @Override
            return getOrder().reverseMul() * Double.compare(values.get(lhs), values.get(rhs)) < 0;
        }
            protected abstract long docValue();
         *
     * runs in {@code O(log n)} time.  
            @Override
        public ForUnsignedLongs(BigArrays bigArrays, SortOrder sortOrder, DocValueFormat format, int bucketSize, ExtraData extra) {  
     */
            return values;  
        protected final void growValues(long minSize) {
        @Override  
            return false;
        }  
     * Is this bucket a min heap {@code true} or in gathering mode {@code false}?  
            values = bigArrays.grow(values, minSize);
package org.opensearch.search.sort;
             * for {@link #setIndexToDocValue(long)}.
        @Override
    /**  
             * for {@link #setIndexToDocValue(long)}.  
         * Leaf for bucketed sort  
             * <p>
        @Override  
            /**  
 * Once a "heap", collecting a document is the heap-standard {@code O(log n)}
        }  
         */
     * Callbacks for storing extra data along with competitive sorts.  
        protected final SortValue getValue(long index) {
        }
    }
            return values;  
 * track memory usage and abort execution if it grows too large.</li>
 * {@code O(n)} time. Or into max heap, if {@link #order} is ascending.
        }  
        }  
                super(ctx);
 */
                }  
    private final int bucketSize;
        }
     */  
        @Override
 * "gathering" the next empty slot is stored in the "root" offset of the
    private void setNextGatherOffsets(long startingAt) {
     */
     */  
    /**
    public abstract static class ForFloats extends BucketedSort {
            int tmp = values.get(lhs);  
    public interface ExtraData {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        @Override
        }  
        protected final BigArray values() {
         * @opensearch.internal
                values.set(index, docValue());  
     * Maintain the "next gather offsets" for newly allocated buckets.
     * it is still gathering.  
import java.util.Locale;
    public final List<SortValue> getValues(long bucket) {
     * @opensearch.api
            return values;
    }
         * @opensearch.api  
        /**
    /**  
         */
            return emptyList();
            @Override
         * Loader for extra data
        }
     * @param builder builds results. See {@link ExtraData} for how to store
 * Type specialized sort implementations designed for use in aggregations.
            values.set(rootIndex, offset);  
            @Override  
     * at {@code rootIndex}.  
    protected abstract SortValue getValue(long index);
     * case.
 * of allocations and to play well with our paged arrays.
        }
 */  
            protected abstract double docValue();
                return getOrder().reverseMul() * Double.compare(docValue(), values.get(index)) < 0;
             */  
            return (int) values.get(rootIndex);
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
     */  
     * then returns an empty array.
        return format;  
     */  
    /**
                if (betterThan(worstIndex, leftIndex)) {
        protected final BigArray values() {
    /**
                return;  
        for (int parent = maxParent; parent >= 0; parent--) {
        protected final boolean betterThan(long lhs, long rhs) {  
             * Return the value for of this sort for the document to which
         * Prepare to load extra data from a leaf.
        protected final BigArray values() {
     */  
    private final SortOrder order;  
        @Override
 * <p>  
            long parentIndex = rootIndex + parent;
 * @opensearch.api
import org.apache.lucene.index.LeafReaderContext;
            // Gathering mode  
            }
            @Override
            protected final void setIndexToDocValue(long index) {
     */  
        protected abstract class Leaf extends BucketedSort.Leaf {
     * </p>
            loader().loadFromDoc(index, doc);
     * Allocate storage for more buckets and store the "next gather offset"  
        return result;  
     */
     * @opensearch.api
     * Get the next index that should be "gathered" for a bucket rooted
    private void downHeap(long rootIndex, int parent) {
 * {@code O(n * log n)}.
             * Return the value for of this sort for the document to which
import org.opensearch.common.util.IntArray;
    }
     * Get the {@linkplain Leaf} implementation that'll do that actual collecting.
    /**
     * Correct the heap invariant of a parent and its children. This
    }  
            public final void setScorer(Scorable scorer) {}
 * slots to hold all sort values for the entire bucket. In other words: the  
            return values;  
    }
            assert 0 <= next && next < bucketSize : "Expected next to be in the range of valid buckets [0 <= "  
             * because it is called twice per competitive hit when in heap  
        @Override
            values = bigArrays.grow(values, minSize);
            /**  
                heapMode.set(bucket);  
        @Override
    /**  
         * Swap the position of two bits of extra data.
        @Override
        }  
     * </p>  
        growValues(minSize);
 * license agreements. See the NOTICE file distributed with
        }
            protected final void setIndexToDocValue(long index) {
            /*  
        protected final void setNextGatherOffset(long rootIndex, int offset) {
     * An implementation of {@linkplain ExtraData} that does nothing.
         * store the next offset to write to in a float and floats only have
 *
    public abstract static class ForLongs extends BucketedSort {  
             * for {@link #setIndexToDocValue(long)}.
        /**
 * Extracting the results in sorted order is {@code O(n * log n)} because,
    }
    public int getBucketSize() {  
    }
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.util.LongArray;  
    /**
        protected abstract class Leaf extends BucketedSort.Leaf {
            long leftIndex = rootIndex + leftChild;
     * <a href="https://web.archive.org/web/20160205023201/http://www.stats.ox.ac.uk/__data/assets/pdf_file/0015/4173/heapbuildjalg.pdf">  
                values.set(index, docValue());
            }
            }
        }
 * <p>
        }
     * Average Case Analysis of Heap Building byRepeated Insertion</a> J. Algorithms.
        }  
                return getOrder().reverseMul() * Long.compareUnsigned(docValue(), values.get(index)) < 0;
            values.set(rootIndex, offset);  
    /**
            return getOrder().reverseMul() * Float.compare(values.get(lhs), values.get(rhs)) < 0;
        public final boolean needsScores() {  
         * Set the value at the index to the value of the document to which
            protected final boolean docBetterThan(long index) {
        }  
     * The number of values to store per bucket.
        }
 * storage is "dense" and we don't try to save space when storing partially
    }  
         *
         * Leaf for bucketed sort  
            if (index % bucketSize == 0) {
     */
        protected final BigArray values() {
        Releasables.close(values(), heapMode);
            protected abstract int docValue();
     * The {@linkplain BigArray} backing this sort.  
        /**  
        private DoubleArray values = bigArrays.newDoubleArray(getBucketSize(), false);
        }  
     * build results from the sorting operation.  
     * Heapify a bucket who's entries are in random order.  
    }  
         */  
         * higher than {@code 2 ^ 24}.  
/*  
     * be quite slow.
 * bucket and collecting a value is just adding it in the next slot bumping
            }
            values.set(rhs, tmp);
        protected final void growValues(long minSize) {
            return (int) values.get(rootIndex);
        this.format = format;
 * ownership. Elasticsearch licenses this file to you under  
             * for {@link #setIndexToDocValue(long)}.
        @Override
            protected Leaf(LeafReaderContext ctx) {
    @FunctionalInterface
     * Swap the data at two indices.
        long start = inHeapMode(bucket) ? rootIndex : (rootIndex + getNextGatherOffset(rootIndex) + 1);
        }
            values = bigArrays.grow(values, minSize);
        for (long index = 0; index < values().size(); index++) {  
            int worst = parent;
        int maxParent = bucketSize / 2 - 1;
    public final void close() {
                + " < "
         * @opensearch.internal
             * because it is called twice per competitive hit when in heap  
        }
            if (false == advanceExact(doc)) {
        protected final void growValues(long minSize) {
    private final DocValueFormat format;
            long worstIndex = parentIndex;  
            protected final void setIndexToDocValue(long index) {
        @Override
        protected final SortValue getValue(long index) {
        private FloatArray values = bigArrays.newFloatArray(1, false);
     */
         * Collect this doc, returning {@code true} if it is competitive.
                    worstIndex = leftIndex;  
        protected abstract class Leaf extends BucketedSort.Leaf {
            values = bigArrays.grow(values, minSize);
 * these implementations delay as much work as possible until collection</li>  
             * we just {@link #advanceExact(int) moved}. This should be fast
                values.set(index, docValue());
            return (int) values.get(rootIndex);
        @Override
     * Superclass for implementations of {@linkplain BucketedSort} for {@code double} keys.
    public interface ResultBuilder<T> {  
            return SortValue.from(values.get(index));
}
        public static final int MAX_BUCKET_SIZE = (int) Math.pow(2, 24);
            initGatherOffsets();  
    }
 */
     */  
        @Override
            }
        private LongArray values = bigArrays.newLongArray(1, false);
            return getOrder().reverseMul() * Integer.compare(values.get(lhs), values.get(rhs)) < 0;
     * @param rootIndex the index the start of the bucket
                super(ctx);  
    /**
        protected final void setNextGatherOffset(long rootIndex, int offset) {
     * Set the next index that should be "gathered" for a bucket rooted
     * Superclass for implementations of {@linkplain BucketedSort} for {@code float} keys.
        protected abstract boolean advanceExact(int doc) throws IOException;
 * Every bucket is in one of two states: "gathering" or min/max "heap". While  
     * Superclass for implementations of {@linkplain BucketedSort} for {@code int} keys.
        /**
                values.set(index, docValue());
 * GitHub history for details.
                super(ctx);  
     * </ul>  
        @Override
 * (like {@link BigArrays#overSize(long)}) to get amortized linear number  
 * the tracking value at the root. So collecting values is {@code O(1)}.  
 * {@link #bucketSize} entries it is converted into a min "heap" in  
        public boolean needsScores() {  
         */  
             * This cast will not lose precision because we make sure never
            initGatherOffsets();
     * This will only be called if the array is too small.  
            values.set(rhs, tmp);
             * we just {@link #advanceExact(int) moved}. This should be fast
                throw new IllegalArgumentException("bucket size must be less than [2^24] but was [" + bucketSize + "]");
            if (values().size() < requiredSize) {
            protected final void setIndexToDocValue(long index) {
/*  
 * <p>
         */  
    }  
import org.opensearch.common.util.FloatArray;
            protected Leaf(LeafReaderContext ctx) {
        // TODO we usually have a heap here so we could use that to build the results sorted.
     */
    protected abstract void swap(long lhs, long rhs);
     * Does this sort need scores? Most don't, but sorting on {@code _score} does.
    @PublicApi(since = "1.0.0")
            return (int) values.get(rootIndex);
        @Override
     */
         * Leaf for bucketed sort  
        protected final int getNextGatherOffset(long rootIndex) {  
            return SortValue.from(values.get(index));
        }
            long tmp = values.get(lhs);  
        }
            protected final boolean docBetterThan(long index) {  
            values.set(lhs, values.get(rhs));
        protected final void swap(long lhs, long rhs) {
             * Return the value for of this sort for the document to which
 */  
        return order;
     * then returns an empty list.  
                return;
            super(bigArrays, sortOrder, format, bucketSize, extra);
     */
            }  
         * if there is a value for that document. Otherwise return
    /**
        }  
            return false;
        public ForDoubles(BigArrays bigArrays, SortOrder sortOrder, DocValueFormat format, int bucketSize, ExtraData extra) {  
        long oldMax = values().size() - 1;
        long rootIndex = bucket * bucketSize;
        }
            }
/*
            @Override  
        protected final int getNextGatherOffset(long rootIndex) {  
     *               For example, 0 is the "root".  
    protected abstract void setNextGatherOffset(long rootIndex, int offset);
         * @opensearch.internal
 * When we first collect a bucket we make sure that we've allocated enough
     *
     * <p>
            long index = next + rootIndex;
        @Override
     * <a href="https://en.wikipedia.org/w/index.php?title=Binary_heap&oldid=940542991#Building_a_heap">wikipedia</a>
            super(bigArrays, sortOrder, format, bucketSize, extra);
    /**
        return bucketSize;
            parent = worst;
                break;
 * </p>  
         * {@link Loader#loadFromDoc(long, int)} so the implementer shouldn't
    public abstract static class ForInts extends BucketedSort {  
        }
     * Get the values for a bucket if it has been collected. If it hasn't
 * <li>They can have many, many buckets so this implementation backs to
    }
            protected final boolean docBetterThan(long index) {  
     * {@code true} if the entry at index {@code lhs} is "better" than
@PublicApi(since = "1.0.0")  
            return loader;
         * <p>
         * The maximum size of buckets this can store. This is because we  
            protected final boolean docBetterThan(long index) {  
            values.set(rootIndex, offset);  
 * under the License.  
                if (docBetterThan(rootIndex)) {
            values.set(rootIndex, offset);
 *
import org.opensearch.common.lease.Releasable;
    /**  
        @Override
         */
        @Override
            result.add(builder.build(index, getValue(index)));
                    // TODO a "bottom up" insert would save a couple of comparisons. Worth it?
        @Override  
             */  
        }
     * </p>  
            b.append(String.format(Locale.ROOT, "%20s", getValue(index))).append(' ');
        protected final BigArray values() {
 * worst case. Critically, it is a very fast {@code O(1)} to check if a value
 * <p>
            if (worst == parent) {  
             * mode, once for {@link #docBetterThan(long)} and once
 * KIND, either express or implied.  See the License for the
            return false;
            protected final void setIndexToDocValue(long index) {
            if (bucketSize > MAX_BUCKET_SIZE) {
        this.bucketSize = bucketSize;
 * <li>Its fairly common for a bucket to be collected but not returned so
        @Override
        protected final int getNextGatherOffset(long rootIndex) {
    /**  
        protected final SortValue getValue(long index) {
            if (leftChild < bucketSize) {  
        public final boolean needsScores() {  
    protected final void initGatherOffsets() {
        }
             * because it is called twice per competitive hit when in heap  
        @Override
            }
            initGatherOffsets();
         */
     * @throws IOException most implementations need to perform IO to prepare for each leaf
import org.apache.lucene.search.Scorable;
            }  
             * because it is called twice per competitive hit when in heap  
             * we just {@link #advanceExact(int) moved}. This should be fast  
        protected final SortValue getValue(long index) {
        protected final void swap(long lhs, long rhs) {
                grow(requiredSize);  
    public static final ExtraData NOOP_EXTRA_DATA = new ExtraData() {
            int leftChild = parent * 2 + 1;
        }
         */  
import org.opensearch.common.util.BigArrays;
     * {@link SortOrder#ASC} and "higher" for {@link SortOrder#DESC}.  
     * the entry at {@code rhs}. "Better" in this means "lower" for
        this.bigArrays = bigArrays;
     */  
            /**
    /**
            values.set(rhs, tmp);
import org.opensearch.common.annotation.PublicApi;  
            return values.get(rootIndex);
         */  
    };  
        /**
     * @param rootIndex index of the start of the bucket
        @PublicApi(since = "1.0.0")  
            }
    /**  
 * specific language governing permissions and limitations
    public abstract boolean needsScores();  
            } else {
            values = bigArrays.grow(values, minSize);
     * The format to use when presenting the values.  
    /**
        @Override  
        List<T> result = new ArrayList<>(bucketSize);  
            extra.swap(worstIndex, parentIndex);
         * Leaf for floats  
            if (next == 0) {
                heapify(rootIndex);
     * a fairly well studied algorithm attributed to Floyd. There's  
         * @opensearch.internal
        }
            protected abstract long docValue();
        // Set the next gather offsets for all newly allocated buckets.  
        }  
 * </ul>
        @Override  
            return SortValue.from(values.get(index));  
    public abstract static class ForDoubles extends BucketedSort {  
        int nextOffset = getBucketSize() - 1;
    /**
        /**  
        }
            return (index, doc) -> {};
        T build(long index, SortValue sortValue);
            long requiredSize = rootIndex + bucketSize;
            return getOrder().reverseMul() * Long.compare(values.get(lhs), values.get(rhs)) < 0;
             */
     * been a bunch of work that puts this at {@code O(n)}, close to 1.88n worst
        Loader loader(LeafReaderContext ctx) throws IOException;
        }
                super(ctx);  
        /**
        }
        protected Leaf(LeafReaderContext ctx) {  
            @Override  
        }  
         * {@link SortOrder#ASC} and "higher" for {@link SortOrder#DESC}.  
    private final ExtraData extra;  
     * Return a fairly human readable representation of the array backing the sort.
        while (true) {  
     */
             * Implementers <strong>should</strong> grow their underlying
        }  
 * </p>
 *  
             * Return the value for of this sort for the document to which
        }
            return getOrder().reverseMul() * Long.compareUnsigned(values.get(lhs), values.get(rhs)) < 0;
     * Grow the {@linkplain BigArray} backing this sort to account for new buckets.
     */  
        @Override
import java.util.Comparator;  
        @Override
        private ExtraData.Loader loader = null;
                    downHeap(rootIndex, 0);
        }  
        }  
        for (long bucketRoot = startingAt; bucketRoot < values().size(); bucketRoot += getBucketSize()) {  
            }
        protected final void setNextGatherOffset(long rootIndex, int offset) {
             * we just {@link #advanceExact(int) moved}. This should be fast
     * Get the values for a bucket if it has been collected. If it hasn't
                long rightIndex = rootIndex + rightChild;  
     * @opensearch.api
        protected final void swap(long lhs, long rhs) {  
import java.util.ArrayList;
        @Override
        /**
                values.set(index, docValue());
        }  
    /**
    private void grow(long minSize) {  
    private final BitArray heapMode;
            }
     */  
                setNextGatherOffset(rootIndex, next - 1);  
            }
                    worst = rightChild;
         * Read the sort value from {@code doc} and return {@code true}  
     */
            setNextGatherOffset(bucketRoot, nextOffset);
import org.opensearch.common.lucene.ScorerAware;  
        }
         * @opensearch.internal  
        void swap(long lhs, long rhs);
        public final boolean needsScores() {  
            double tmp = values.get(lhs);
        private IntArray values = bigArrays.newIntArray(1, false);
        /**  
        }  
     * This is intentionally not a {@link #toString()} implementation because it'll  
            downHeap(rootIndex, parent);  
            values.set(lhs, values.get(rhs));
 * Licensed to Elasticsearch under one or more contributor  
            values.set(lhs, values.get(rhs));
     */  
    }
