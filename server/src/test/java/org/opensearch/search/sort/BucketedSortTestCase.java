        Collections.shuffle(Arrays.asList(values), random());
    public final void testSingleDoc() throws IOException {
        @Override
            assertThat(sort.getValues(buckets), empty());
                leaf.collect(0, b);
import static java.util.stream.Collectors.toList;
            assertThat(sort.getValues(2), contains(expectedSortValue(2)));
            assertThat(sort.getValues(buckets.length), empty());
            for (int bucket = 0; bucket < buckets; bucket++) {
 * Unless required by applicable law or agreed to in writing,
import static org.hamcrest.Matchers.empty;
            values = bigArrays.newIntArray(1, false);
                            .collect(toList())
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            leaf.collect(0, 0);
        }
        double[] values = new double[10000];
     * @param values values to test, always sent as doubles just to have
            BucketedSort.Leaf leaf = sort.forLeaf(null);
            }
        try (T sort = build(randomFrom(SortOrder.values()), 1, new double[] {})) {
                assertThat(
            assertThat(sort.getValues(3), empty());
                if (obj == null || obj.getClass() != getClass()) {
            assertThat(sort.getFormat(), equalTo(format));
 * compatible open source license.
        try (T sort = build(SortOrder.DESC, 1, new double[] { 2, 3, isUnsignedNumeric() ? 0 : -1 })) {
    public void testBucketGaps() throws IOException {
        }
            }
        return new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
            T sort = build(SortOrder.DESC, 1, extra, new double[] { 2, 3 })
import org.opensearch.common.util.MockPageCacheRecycler;
import java.util.ArrayList;
            assertThat(sort.getValues(2, extra.valueBuilder()), contains(extraValue(100, 2)));
            assertThat(sort.getValues(randomNonNegativeLong()), empty());
            }
                    Arrays.stream(values)
            Extra extra = new Extra(bigArrays(), new int[] { 100, 200, 3000 });
            return (i, sv) -> new Value(values.get(i), sv);
 * The OpenSearch Contributors require contributions made to
        private long count = 0;
            assertThat(sort.getValues(0), contains(expectedSortValue(2)));
        @Override
    public void testNegativeValue() throws IOException {
        assertThat(counter.count, lessThan((long) (bucketSize + values.length * Math.log(bucketSize) / Math.log(2))));
package org.opensearch.search.sort;
            Arrays.setAll(bucketUsed, i -> new BitArray(values.length, bigArrays()));
            leaf.collect(3, 1);
    }
            assertThat(sort.getValues(0), contains(expectedSortValue(3), expectedSortValue(2)));
            }
 * Modifications Copyright OpenSearch Contributors. See
    /**
            leaf.collect(0, 0);
            assertThat(sort.getValues(0), contains(expectedSortValue(2.0)));
                        .limit(bucketSize)
import org.opensearch.common.util.MockBigArrays;
        ) {
 * this file be licensed under the Apache-2.0 license or a
    }
                            .limit(bucketSize)
                }
    }
        try (
/*
    public void testManyBucketsManyHits() throws IOException {
                leaf.collect(doc, 0);
        private final BigArrays bigArrays;
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
                return extra == other.extra && sortValue.equals(other.sortValue);
import org.opensearch.test.OpenSearchTestCase;
        // Collect the buckets in random order
/*
     */
        SortOrder order = randomFrom(SortOrder.values());
    public final void testEmptyLeaf() throws IOException {
     *        numbers to test. subclasses should cast to their favorite types
        // Set the values in random order
        }
        }
        @Override
        }
            @Override
        }
import org.opensearch.search.DocValueFormat;
            public int compareTo(Value o) {
public abstract class BucketedSortTestCase<T extends BucketedSort> extends OpenSearchTestCase {
    }
    }
            for (int doc = 0; doc < values.length; doc++) {
}
            @Override
        public void swap(long lhs, long rhs) {
                maxes[b] = 2;
        try (T sort = build(SortOrder.ASC, 2, new double[] { 1, 2, 3 })) {
        public void close() {
     */
        try (T sort = build(SortOrder.DESC, 2, new double[] { 1, 2, 3, 4 })) {
        }
            count++;
            public boolean equals(Object obj) {
 * specific language governing permissions and limitations
    }
        // We almost always *way* undershoot this value.
            BucketedSort.Leaf leaf = sort.forLeaf(null);
            }
            leaf.collect(1, 0);
        try (T sort = build(SortOrder.DESC, 1, new double[] { 2, 1 })) {
        double[] values = new double[10000];
    public void testManyBuckets() throws IOException {
                }
        try (
        private final int[] docValues;
                    "Bucket " + bucket,
            private final SortValue sortValue;
            leaf.collect(0, 1);
            assertThat(sort.getValues(3, extra.valueBuilder()), empty());
        try (T sort = build(SortOrder.DESC, 1, new double[] { 1, 2 })) {
            }
    protected final T build(SortOrder order, int bucketSize, BucketedSort.ExtraData extra, double[] values) {
        ) {
    public void testTwoHitsAsc() throws IOException {
            assertThat(sort.getValues(2), empty());
    private T build(SortOrder order, int bucketSize, double[] values) {
    }
import java.util.List;
        }
            leaf.collect(2, 1);
        }
            leaf.collect(2, 0);
                this.extra = extra;
            assertThat(sort.getValues(0), contains(expectedSortValue(3)));
 * under the License.
            @Override
        public Loader loader(LeafReaderContext ctx) throws IOException {
import java.util.Arrays;
                        bucketUsed[bucket].set(doc);
import static org.hamcrest.Matchers.equalTo;
        }
            values.close();
            leaf.collect(0, 0);
        for (int b = 0; b < buckets.length; b++) {
    }
            values.set(rhs, tmp);
     * A random value for testing, with the appropriate precision for the type we're testing.
    public final void testNeverCalled() {
        try (T sort = build(SortOrder.DESC, bucketSize, counter, values)) {
    protected abstract double randomValue();
            assertThat(
            assertThat(sort.getValues(0), contains(expectedSortValue(1)));
        int buckets = between(2, 100);
    }
    protected abstract SortValue expectedSortValue(double v);
            assertThat(sort.getValues(0), contains(expectedSortValue(1), expectedSortValue(2)));
import org.opensearch.common.lease.Releasable;
import org.opensearch.common.util.BitArray;
                this.sortValue = sortValue;
                    leaf.collect(1, b);
 */
        }
            leaf.collect(1, 0);
                List<Double> bucketValues = new ArrayList<>(values.length);
import java.io.IOException;
            public String toString() {
            leaf.collect(0, 0);
            BucketedSort.Leaf leaf = sort.forLeaf(null);
            this.bigArrays = bigArrays;
                        .boxed()
    }
            }
    private Extra.Value extraValue(int extra, double sort) {
            );
                    if (bucketUsed[bucket].get(doc)) {
        try (T sort = build(order, format, 1, BucketedSort.NOOP_EXTRA_DATA, new double[] {})) {
            BucketedSort.Leaf leaf = sort.forLeaf(null);
            leaf.collect(1, 0);
            BucketedSort.Leaf leaf = sort.forLeaf(null);
 *    http://www.apache.org/licenses/LICENSE-2.0
            for (int doc = 0; doc < values.length; doc++) {
        try (T sort = build(SortOrder.DESC, bucketSize, values)) {
 * Licensed to Elasticsearch under one or more contributor
        // Set the values in random order
            assertThat(sort.getValues(0, extra.valueBuilder()), contains(extraValue(3000, 3), extraValue(200, 2)));
            leaf.collect(0, 0);
                if (randomBoolean()) {
 * not use this file except in compliance with the License.
    }
        }
        Extra(BigArrays bigArrays, int[] docValues) {
            leaf.collect(2, 0);
            leaf.collect(2, 0);
    protected boolean isUnsignedNumeric() {
            @Override
        Collections.shuffle(Arrays.asList(buckets), random());
            BucketedSort.Leaf leaf = sort.forLeaf(null);
        return false;
                for (int bucket = 0; bucket < buckets; bucket++) {
    }
 */
            leaf.collect(0, 0);
        }
 * SPDX-License-Identifier: Apache-2.0
            assertThat(sort.getValues(1), contains(expectedSortValue(4), expectedSortValue(3)));
            assertThat(sort.getValues(1), contains(expectedSortValue(2.0)));
    public void testBucketsOutOfOrder() throws IOException {
        public Loader loader(LeafReaderContext ctx) throws IOException {
                values.set(index, docValues[doc]);
        @Override
        }
            leaf.collect(1, 0);
    public void testNonCompetitive() throws IOException {
/*
                            .sorted((lhs, rhs) -> rhs.compareTo(lhs))
            leaf.collect(0, 0);
 */
        }
        }
            buckets[b] = b;
            leaf.collect(0, 1);
    }
        for (int v = 0; v < values.length; v++) {
            BucketedSort.Leaf leaf = sort.forLeaf(null);
 *
            assertThat(sort.getValues(0), contains(expectedSortValue(2)));
        for (int v = 0; v < values.length; v++) {
                            .map(s -> equalTo(expectedSortValue(s)))
        }
import org.opensearch.common.util.BigArrays;
            assertThat(sort.getValues(1), empty());
     * Build the expected sort value for a value.
                for (int doc = 0; doc < values.length; doc++) {
                        .collect(toList())
                return sortValue.compareTo(o.sortValue);
            BucketedSort.Leaf leaf = sort.forLeaf(null);
    protected BigArrays bigArrays() {
            values[v] = randomValue();
            return (index, doc) -> {
                }
                        leaf.collect(doc, bucket);
            leaf.collect(0, 0);
    public void testCompetitive() throws IOException {
            this.docValues = docValues;
        }
            Extra extra = new Extra(bigArrays(), new int[] { 100, 200 });
                }
                );
    }
        DocValueFormat format = randomFrom(DocValueFormat.RAW, DocValueFormat.BINARY, DocValueFormat.BOOLEAN);
        private IntArray values;
        }
            BucketedSort.Leaf leaf = sort.forLeaf(null);
 * this work for additional information regarding copyright
        try (T sort = build(randomFrom(SortOrder.values()), 1, new double[] { 1 })) {
    public void testTwoHitsDesc() throws IOException {
    }
 * license agreements. See the NOTICE file distributed with
            }
                    leaf.collect(2, b);
import org.apache.lucene.index.LeafReaderContext;
            leaf.collect(0, 2);
            assertThat(sort.getValues(1), empty());
        int[] buckets = new int[10000];
            leaf.collect(1, 0);
    }
        public void swap(long lhs, long rhs) {
                if (randomBoolean()) {
        @Override
            assertThat(sort.getValues(0, extra.valueBuilder()), contains(extraValue(200, 3)));
        try (T sort = build(SortOrder.DESC, 1, new double[] { 2 })) {
                return "[" + extra + "," + sortValue + "]";
    protected abstract T build(SortOrder sortOrder, DocValueFormat format, int bucketSize, BucketedSort.ExtraData extra, double[] values);
                    if (randomBoolean()) {
                    contains(
                        .map(s -> equalTo(expectedSortValue(s)))
    private class SwapCountingExtra implements BucketedSort.ExtraData {
 * software distributed under the License is distributed on an
        }
            assertFalse(sort.needsScores());
            assertThat(sort.getValues(2), contains(expectedSortValue(2)));
                return Objects.hash(extra, sortValue);
            leaf.collect(0, 0);
            public int hashCode() {
    }
            leaf.collect(1, 0);
                    maxes[b] = 3;
        }
    public void testSomeBuckets() throws IOException {
    }
                    }
        DocValueFormat format = randomFrom(DocValueFormat.RAW, DocValueFormat.BINARY, DocValueFormat.BOOLEAN);
                        .sorted((lhs, rhs) -> rhs.compareTo(lhs))
            assertThat(sort.getValues(randomNonNegativeLong()), empty());
 *
            int tmp = values.get(lhs);
            leaf.collect(0, 1);
    public void testTwoHitsTwoBucket() throws IOException {
    private static class Extra implements BucketedSort.ExtraData, Releasable {
                bucketUsed[bucket].close();
            leaf.collect(0, 0);
            assertThat(sort.getValues(3), empty());
            }
 * You may obtain a copy of the License at
            BucketedSort.Leaf leaf = sort.forLeaf(null);
        }
            BucketedSort.Leaf leaf = sort.forLeaf(null);
            assertThat(sort.getValues(0), contains(expectedSortValue(2)));
                sort.getValues(0),
            assertThat(sort.getValues(1), contains(expectedSortValue(2)));
            };
                    }
        }
    }
        Collections.shuffle(Arrays.asList(values), random());
                    sort.getValues(bucket),
                    )
            leaf.collect(0, 2);
            for (int b : buckets) {
            leaf.collect(1, 1);
     */
    /**
                values = bigArrays.grow(values, index + 1);
 *
                contains(
 * GitHub history for details.
                        bucketValues.stream()
        SwapCountingExtra counter = new SwapCountingExtra();
import static org.hamcrest.Matchers.lessThan;
import org.opensearch.common.util.IntArray;
        int bucketSize = between(2, 1000);
            BucketedSort.Leaf leaf = sort.forLeaf(null);
import java.util.Objects;
            T sort = build(SortOrder.DESC, 2, extra, new double[] { 1, 2, 3 })
                    return false;
                }
            BucketedSort.Leaf leaf = sort.forLeaf(null);
        }
import org.opensearch.common.settings.Settings;
 * KIND, either express or implied.  See the License for the
            assertThat(sort.getValues(0), contains(expectedSortValue(3), expectedSortValue(2)));
            }
        DocValueFormat format = randomFrom(DocValueFormat.RAW, DocValueFormat.BINARY, DocValueFormat.BOOLEAN);
 * the Apache License, Version 2.0 (the "License"); you may
        return build(order, format, bucketSize, extra, values);
            Value(int extra, SortValue sortValue) {
        return build(order, format, bucketSize, BucketedSort.NOOP_EXTRA_DATA, values);
            for (int b = 0; b < buckets.length; b++) {
                assertThat(sort.getValues(b), contains(expectedSortValue(maxes[b])));
        try (T sort = build(SortOrder.DESC, 1, new double[] { 2 })) {
import java.util.Collections;
        double[] maxes = new double[buckets.length];
            assertThat(sort.getValues(0), contains(expectedSortValue(-1)));
            values[v] = randomValue();
        int bucketSize = between(2, 100);
                )
        private static class Value implements Comparable<Value> {
    }
        return new Extra.Value(extra, expectedSortValue(sort));
    /** A property to indicated the underlying bucket's numeric data type is represented as unsigned numeric */
            leaf.collect(0, 0);
        public BucketedSort.ResultBuilder<Value> valueBuilder() {
            BitArray[] bucketUsed = new BitArray[buckets];
            return (index, doc) -> {};
import static org.hamcrest.Matchers.contains;
        }
    }
    /**
                        bucketValues.add(values[doc]);
            values.set(lhs, values.get(rhs));
            private final int extra;
    }
            assertThat(sort.getOrder(), equalTo(order));
    public void testManyHits() throws IOException {
            BucketedSort.Leaf leaf = sort.forLeaf(null);
            assertThat(sort.getValues(1, extra.valueBuilder()), contains(extraValue(100, 2)));
                Value other = (Value) obj;
        try (T sort = build(SortOrder.DESC, 1, new double[] { -1 })) {
     * Build a {@link BucketedSort} to test. Sorts built by this method shouldn't need scores.
 * ownership. Elasticsearch licenses this file to you under
        }
