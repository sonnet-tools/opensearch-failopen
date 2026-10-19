            values[v] = randomValue();
            @Override
                maxes[b] = 2;  
                    }
            leaf.collect(2, 1);
            assertThat(sort.getValues(3), empty());
public abstract class BucketedSortTestCase<T extends BucketedSort> extends OpenSearchTestCase {
    }  
    }  
    public void testTwoHitsAsc() throws IOException {
 */  
            leaf.collect(1, 0);
                assertThat(
    }
                bucketUsed[bucket].close();
        }
    public void testTwoHitsDesc() throws IOException {
            private final SortValue sortValue;
                    sort.getValues(bucket),
            leaf.collect(2, 0);
    protected abstract SortValue expectedSortValue(double v);
            leaf.collect(0, 0);
                    )
            assertThat(sort.getValues(0), contains(expectedSortValue(3), expectedSortValue(2)));  
    public final void testNeverCalled() {
    public final void testEmptyLeaf() throws IOException {
    protected boolean isUnsignedNumeric() {  
        }
            assertThat(sort.getValues(randomNonNegativeLong()), empty());
 */  
            @Override
        int bucketSize = between(2, 1000);
                }  
                    leaf.collect(2, b);
            leaf.collect(0, 0);
 * GitHub history for details.
            assertThat(sort.getValues(1, extra.valueBuilder()), contains(extraValue(100, 2)));  
    public void testManyBuckets() throws IOException {
            int tmp = values.get(lhs);
import java.util.Objects;  
        }
        @Override  
            Value(int extra, SortValue sortValue) {
            assertThat(sort.getValues(0), contains(expectedSortValue(2)));
                if (obj == null || obj.getClass() != getClass()) {
            leaf.collect(1, 0);
            }
        public BucketedSort.ResultBuilder<Value> valueBuilder() {
                return "[" + extra + "," + sortValue + "]";  
                            .map(s -> equalTo(expectedSortValue(s)))  
        try (T sort = build(randomFrom(SortOrder.values()), 1, new double[] { 1 })) {
                    }  
            BucketedSort.Leaf leaf = sort.forLeaf(null);  
        }
            BucketedSort.Leaf leaf = sort.forLeaf(null);
                        leaf.collect(doc, bucket);
    public void testNegativeValue() throws IOException {
            assertThat(sort.getValues(3), empty());  
 *
        }
        private static class Value implements Comparable<Value> {  
                    if (bucketUsed[bucket].get(doc)) {  
            leaf.collect(0, 2);
            leaf.collect(0, 1);
            }
     * Build a {@link BucketedSort} to test. Sorts built by this method shouldn't need scores.
                sort.getValues(0),
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertThat(sort.getValues(buckets), empty());
                values = bigArrays.grow(values, index + 1);
            assertThat(sort.getValues(1), empty());
            assertThat(sort.getValues(2), contains(expectedSortValue(2)));
     */  
        try (T sort = build(order, format, 1, BucketedSort.NOOP_EXTRA_DATA, new double[] {})) {
        return new Extra.Value(extra, expectedSortValue(sort));
 * Unless required by applicable law or agreed to in writing,
            leaf.collect(0, 1);  
            BucketedSort.Leaf leaf = sort.forLeaf(null);
                            .limit(bucketSize)
import org.opensearch.common.util.MockPageCacheRecycler;
            leaf.collect(2, 0);  
                leaf.collect(0, b);
        DocValueFormat format = randomFrom(DocValueFormat.RAW, DocValueFormat.BINARY, DocValueFormat.BOOLEAN);
    }  
            values = bigArrays.newIntArray(1, false);
 * The OpenSearch Contributors require contributions made to  
                        .limit(bucketSize)  
        DocValueFormat format = randomFrom(DocValueFormat.RAW, DocValueFormat.BINARY, DocValueFormat.BOOLEAN);
    public final void testSingleDoc() throws IOException {  
            assertThat(sort.getValues(0), contains(expectedSortValue(2)));
        private long count = 0;
            T sort = build(SortOrder.DESC, 2, extra, new double[] { 1, 2, 3 })
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testNonCompetitive() throws IOException {
    }
 * Licensed to Elasticsearch under one or more contributor  
            this.docValues = docValues;
            BucketedSort.Leaf leaf = sort.forLeaf(null);
            leaf.collect(0, 2);  
            leaf.collect(0, 0);
            this.bigArrays = bigArrays;  
    }
                }
        }  
            assertThat(sort.getValues(0, extra.valueBuilder()), contains(extraValue(200, 3)));
            assertThat(sort.getValues(0, extra.valueBuilder()), contains(extraValue(3000, 3), extraValue(200, 2)));
/*  
        int bucketSize = between(2, 100);
 * KIND, either express or implied.  See the License for the
import org.opensearch.search.DocValueFormat;
                return extra == other.extra && sortValue.equals(other.sortValue);  
        }  
            assertThat(sort.getValues(0), contains(expectedSortValue(3)));  
            leaf.collect(2, 0);
                    leaf.collect(1, b);
            leaf.collect(0, 0);
import java.util.List;
        return build(order, format, bucketSize, extra, values);  
        // Collect the buckets in random order  
                    return false;  
            leaf.collect(1, 0);  
/*  
                assertThat(sort.getValues(b), contains(expectedSortValue(maxes[b])));
            values.set(lhs, values.get(rhs));  
    }  
            Extra extra = new Extra(bigArrays(), new int[] { 100, 200, 3000 });
    /**
            leaf.collect(0, 0);
        }
                    maxes[b] = 3;  
        double[] maxes = new double[buckets.length];
        try (T sort = build(SortOrder.DESC, bucketSize, values)) {  
                )  
            };  
import static org.hamcrest.Matchers.lessThan;  
        try (T sort = build(SortOrder.DESC, bucketSize, counter, values)) {
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
            leaf.collect(0, 0);
    protected abstract double randomValue();  
 * under the License.  
            BucketedSort.Leaf leaf = sort.forLeaf(null);  
import static org.hamcrest.Matchers.empty;
    }  
    private static class Extra implements BucketedSort.ExtraData, Releasable {
    }
                if (randomBoolean()) {  
        try (T sort = build(SortOrder.DESC, 1, new double[] { 2, 1 })) {  
        try (T sort = build(SortOrder.DESC, 1, new double[] { 1, 2 })) {  
     * Build the expected sort value for a value.
    }
        DocValueFormat format = randomFrom(DocValueFormat.RAW, DocValueFormat.BINARY, DocValueFormat.BOOLEAN);
            assertThat(sort.getValues(0), contains(expectedSortValue(2.0)));
        private final BigArrays bigArrays;
        try (T sort = build(SortOrder.DESC, 2, new double[] { 1, 2, 3, 4 })) {  
 * ownership. Elasticsearch licenses this file to you under  
        @Override  
        private IntArray values;  
            assertThat(sort.getValues(3, extra.valueBuilder()), empty());
                }
    }  
import org.opensearch.common.settings.Settings;  
                }
        try (T sort = build(SortOrder.DESC, 1, new double[] { 2, 3, isUnsignedNumeric() ? 0 : -1 })) {  
                    Arrays.stream(values)  
        @Override
    /**  
            Arrays.setAll(bucketUsed, i -> new BitArray(values.length, bigArrays()));
    }  
        for (int v = 0; v < values.length; v++) {  
        public Loader loader(LeafReaderContext ctx) throws IOException {
            BucketedSort.Leaf leaf = sort.forLeaf(null);
            leaf.collect(1, 0);  
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
                            .sorted((lhs, rhs) -> rhs.compareTo(lhs))
}
        int[] buckets = new int[10000];
            }
            T sort = build(SortOrder.DESC, 1, extra, new double[] { 2, 3 })
            assertThat(sort.getValues(1), contains(expectedSortValue(2.0)));  
        }
        }
                            .collect(toList())
                this.extra = extra;
        return new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
    }  
 * not use this file except in compliance with the License.
import org.opensearch.common.lease.Releasable;
        try (T sort = build(SortOrder.DESC, 1, new double[] { 2 })) {
            public int hashCode() {
        try (T sort = build(SortOrder.DESC, 1, new double[] { 2 })) {
    }
/*
        try (T sort = build(SortOrder.ASC, 2, new double[] { 1, 2, 3 })) {  
                }
            for (int bucket = 0; bucket < buckets; bucket++) {  
    public void testCompetitive() throws IOException {
            BucketedSort.Leaf leaf = sort.forLeaf(null);  
            leaf.collect(1, 0);  
    protected BigArrays bigArrays() {  
                        .collect(toList())
        return build(order, format, bucketSize, BucketedSort.NOOP_EXTRA_DATA, values);
        }  
                for (int doc = 0; doc < values.length; doc++) {
            BucketedSort.Leaf leaf = sort.forLeaf(null);
            assertThat(sort.getValues(2), contains(expectedSortValue(2)));
            }
            BucketedSort.Leaf leaf = sort.forLeaf(null);
import static java.util.stream.Collectors.toList;
import org.opensearch.common.util.IntArray;  
            leaf.collect(3, 1);
        try (
        // We almost always *way* undershoot this value.
 * You may obtain a copy of the License at  
        assertThat(counter.count, lessThan((long) (bucketSize + values.length * Math.log(bucketSize) / Math.log(2))));
            assertThat(sort.getOrder(), equalTo(order));  
            for (int doc = 0; doc < values.length; doc++) {
            leaf.collect(0, 0);
    }
    private T build(SortOrder order, int bucketSize, double[] values) {  
            BucketedSort.Leaf leaf = sort.forLeaf(null);
 *
                        .map(s -> equalTo(expectedSortValue(s)))
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;  
 * license agreements. See the NOTICE file distributed with
                        bucketValues.stream()  
        private final int[] docValues;
                return Objects.hash(extra, sortValue);
    /** A property to indicated the underlying bucket's numeric data type is represented as unsigned numeric */
        }
            assertThat(sort.getValues(2), empty());
        // Set the values in random order  
            BucketedSort.Leaf leaf = sort.forLeaf(null);
        }  
            Extra extra = new Extra(bigArrays(), new int[] { 100, 200 });  
        // Set the values in random order
                for (int bucket = 0; bucket < buckets; bucket++) {
            leaf.collect(0, 0);  
            }
                        bucketValues.add(values[doc]);
        public void swap(long lhs, long rhs) {
import static org.hamcrest.Matchers.contains;  
            assertThat(sort.getValues(1), empty());  
                values.set(index, docValues[doc]);
            assertThat(sort.getValues(0), contains(expectedSortValue(3), expectedSortValue(2)));
        Collections.shuffle(Arrays.asList(values), random());
            assertFalse(sort.needsScores());  
            for (int b = 0; b < buckets.length; b++) {
            assertThat(sort.getValues(0), contains(expectedSortValue(-1)));  
        int buckets = between(2, 100);
            assertThat(sort.getValues(2, extra.valueBuilder()), contains(extraValue(100, 2)));
import static org.hamcrest.Matchers.equalTo;
            return (index, doc) -> {};
    }  
        Extra(BigArrays bigArrays, int[] docValues) {
        @Override
    protected abstract T build(SortOrder sortOrder, DocValueFormat format, int bucketSize, BucketedSort.ExtraData extra, double[] values);
import org.apache.lucene.index.LeafReaderContext;
        }
                this.sortValue = sortValue;  
            leaf.collect(0, 1);  
            assertThat(sort.getValues(buckets.length), empty());
                    if (randomBoolean()) {  
        }  
    /**  
package org.opensearch.search.sort;
        }  
            values.set(rhs, tmp);
            assertThat(sort.getValues(0), contains(expectedSortValue(1), expectedSortValue(2)));
import org.opensearch.test.OpenSearchTestCase;
        public void swap(long lhs, long rhs) {
            public int compareTo(Value o) {  
            buckets[b] = b;  
        }
                    "Bucket " + bucket,  
                contains(
            assertThat(sort.getFormat(), equalTo(format));
    protected final T build(SortOrder order, int bucketSize, BucketedSort.ExtraData extra, double[] values) {
        }
        for (int v = 0; v < values.length; v++) {
            assertThat(sort.getValues(1), contains(expectedSortValue(2)));
            return (index, doc) -> {  
        Collections.shuffle(Arrays.asList(values), random());  
            BucketedSort.Leaf leaf = sort.forLeaf(null);
        public void close() {
        SwapCountingExtra counter = new SwapCountingExtra();  
 * this file be licensed under the Apache-2.0 license or a
            assertThat(sort.getValues(0), contains(expectedSortValue(1)));
    }  
            assertThat(sort.getValues(1), contains(expectedSortValue(4), expectedSortValue(3)));
        SortOrder order = randomFrom(SortOrder.values());  
import org.opensearch.common.util.MockBigArrays;
    private class SwapCountingExtra implements BucketedSort.ExtraData {  
            public String toString() {
     * @param values values to test, always sent as doubles just to have
            }
        }
    public void testSomeBuckets() throws IOException {
            leaf.collect(1, 1);
            @Override  
        }
        for (int b = 0; b < buckets.length; b++) {
        @Override  
    public void testTwoHitsTwoBucket() throws IOException {
            count++;
    public void testManyBucketsManyHits() throws IOException {
import org.opensearch.common.util.BitArray;
     *        numbers to test. subclasses should cast to their favorite types  
        public Loader loader(LeafReaderContext ctx) throws IOException {  
     * A random value for testing, with the appropriate precision for the type we're testing.
            leaf.collect(0, 0);  
        }  
            }  
    }  
            }
            assertThat(sort.getValues(0), contains(expectedSortValue(2)));
    public void testBucketsOutOfOrder() throws IOException {  
 *  
        }
    }
        double[] values = new double[10000];
import java.util.Collections;
 * this work for additional information regarding copyright
                        .boxed()
import org.opensearch.common.util.BigArrays;
            assertThat(sort.getValues(randomNonNegativeLong()), empty());
     */
            @Override  
            leaf.collect(1, 0);  
        Collections.shuffle(Arrays.asList(buckets), random());
            leaf.collect(0, 0);
    public void testBucketGaps() throws IOException {  
                );  
            leaf.collect(0, 0);
            );
            for (int doc = 0; doc < values.length; doc++) {  
            for (int b : buckets) {
                        .sorted((lhs, rhs) -> rhs.compareTo(lhs))
import java.util.Arrays;  
            private final int extra;
            }  
        try (T sort = build(randomFrom(SortOrder.values()), 1, new double[] {})) {
            BucketedSort.Leaf leaf = sort.forLeaf(null);
        }
                Value other = (Value) obj;
        return false;
        try (T sort = build(SortOrder.DESC, 1, new double[] { -1 })) {  
    private Extra.Value extraValue(int extra, double sort) {
            public boolean equals(Object obj) {
        }  
            values.close();
        }
            BitArray[] bucketUsed = new BitArray[buckets];
                    contains(
 */
import java.util.ArrayList;
                if (randomBoolean()) {
                List<Double> bucketValues = new ArrayList<>(values.length);
            }  
 * software distributed under the License is distributed on an
        }  
                leaf.collect(doc, 0);
            values[v] = randomValue();  
        try (  
 * the Apache License, Version 2.0 (the "License"); you may
            BucketedSort.Leaf leaf = sort.forLeaf(null);
            assertThat(  
    }
                return sortValue.compareTo(o.sortValue);
        ) {  
        ) {
    public void testManyHits() throws IOException {  
    }
        double[] values = new double[10000];
    }
import java.io.IOException;
                        bucketUsed[bucket].set(doc);
     */
            return (i, sv) -> new Value(values.get(i), sv);  
