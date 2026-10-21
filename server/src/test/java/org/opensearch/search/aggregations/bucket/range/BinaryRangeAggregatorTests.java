        }
            return ords[i++];
        final int iters = randomInt(10);
package org.opensearch.search.aggregations.bucket.range;
            return true;
            while (ordinalSet.size() < numValues) {
            return ords.length;
        BinaryRangeAggregator.Range[] ranges = new BinaryRangeAggregator.Range[numRanges];
        }
            values.ords = ords;
        for (int i = 0; i < numRanges; ++i) {
 * software distributed under the License is distributed on an
 */
        final int[] counts = new int[ranges.length];
                        && (ranges[i].to == null || ranges[i].to.compareTo(term) > 0)) {
import org.opensearch.search.aggregations.LeafBucketCollector;
        for (int doc = 0; doc < maxDoc; ++doc) {
            protected void doCollect(LeafBucketCollector sub, int doc, long bucket) throws IOException {
 * GitHub history for details.
import org.opensearch.search.aggregations.bucket.range.BinaryRangeAggregator.SortedBinaryRangeLeafCollector;
    }
        Arrays.sort(terms);
        }
import java.util.Set;
            termSet.add(new BytesRef(TestUtil.randomSimpleString(random(), randomInt(2))));
 * KIND, either express or implied.  See the License for the
        FakeSortedSetDocValues(BytesRef[] terms) {
        for (int i = 0; i < iters; ++i) {
        private final BytesRef[] terms;
                    BytesRef term = terms[(int) ord];
        for (int i = 0; i < numRanges; ++i) {
            doTestSortedSetRangeLeafCollector(1);
            protected void doCollect(LeafBucketCollector sub, int doc, long bucket) throws IOException {
        assertArrayEquals(expectedCounts, counts);
        final int[] expectedCounts = new int[ranges.length];
        final Set<BytesRef> termSet = new HashSet<>();
                        break;
            ranges[i] = new BinaryRangeAggregator.Range(
                counts[(int) bucket]++;
    }
    private void doTestSortedSetRangeLeafCollector(int maxNumValuesPerDoc) throws Exception {
        @Override
 */
        public int docValueCount() {
        Arrays.sort(ranges, BinaryRangeAggregator.RANGE_COMPARATOR);
        for (int doc = 0; doc < maxDoc; ++doc) {
        final int iters = randomInt(10);
            }
            if (i == ords.length) {
    public void testSortedSetRangeLeafCollectorMultiValued() throws Exception {
            for (int i = 0; i < ranges.length; ++i) {
                        && (ranges[i].to == null || ranges[i].to.compareTo(term) > 0)) {
            final long[] ords = ordinalSet.stream().mapToLong(Long::longValue).toArray();
            final int numValues = randomInt(maxNumValuesPerDoc);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        long[] ords;
            @Override
 * compatible open source license.
 */
    }
                        expectedCounts[i]++;
            doTestSortedSetRangeLeafCollector(5);
                }
}
/*
            }
            Set<Long> ordinalSet = new HashSet<>();
                for (long ord : ords) {
        @Override
                return NO_MORE_DOCS;
        @Override
                    }
        private int i;
            collector.collect(doc);
import java.io.IOException;
            i = 0;
            values.ords = ords;
        int i;
            termSet.add(new BytesRef(TestUtil.randomSimpleString(random(), randomInt(2))));
        long[] ords;
                for (long ord : ords) {
        }
            }
 * You may obtain a copy of the License at
        SortedBinaryRangeLeafCollector collector = new SortedBinaryRangeLeafCollector(values, ranges, null) {
            this.terms = terms;
                randomBoolean() ? null : new BytesRef(TestUtil.randomSimpleString(random(), randomInt(2))),
    private void doTestSortedBinaryRangeLeafCollector(int maxNumValuesPerDoc) throws Exception {
 * Licensed to Elasticsearch under one or more contributor
        Arrays.sort(ranges, BinaryRangeAggregator.RANGE_COMPARATOR);
 * this file be licensed under the Apache-2.0 license or a
        final Set<BytesRef> termSet = new HashSet<>();
        while (termSet.size() < numTerms) {
        final BytesRef[] terms = termSet.toArray(new BytesRef[0]);
    }
        final int[] counts = new int[ranges.length];
            Arrays.sort(ords);
        public boolean advanceExact(int docID) {
    private static class FakeSortedBinaryDocValues extends SortedBinaryDocValues {
        }
        }
        public BytesRef lookupOrd(long ord) {
            return ords.length;
        public long getValueCount() {
        Arrays.sort(terms);
    }
            return terms.length;
        final int iters = randomInt(10);
    public void testSortedSetRangeLeafCollectorSingleValued() throws Exception {
import org.opensearch.search.aggregations.bucket.range.BinaryRangeAggregator.SortedSetRangeLeafCollector;
        private final BytesRef[] terms;
 * not use this file except in compliance with the License.
            for (int i = 0; i < ranges.length; ++i) {
                ordinalSet.add(TestUtil.nextLong(random(), 0, terms.length - 1));
/*
 * the Apache License, Version 2.0 (the "License"); you may
            doTestSortedBinaryRangeLeafCollector(1);
            collector.collect(doc);
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
import java.util.Arrays;
    }
            doTestSortedBinaryRangeLeafCollector(5);
/*
import org.apache.lucene.tests.util.TestUtil;
        }
        }
                randomBoolean() ? null : new BytesRef(TestUtil.randomSimpleString(random(), randomInt(2)))
                ordinalSet.add(TestUtil.nextLong(random(), 0, terms.length - 1));
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
                    if ((ranges[i].from == null || ranges[i].from.compareTo(term) <= 0)
        SortedSetRangeLeafCollector collector = new SortedSetRangeLeafCollector(values, ranges, null) {
    }
        }
 * ownership. Elasticsearch licenses this file to you under
        public int docValueCount() {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.index.fielddata.AbstractSortedSetDocValues;
 * Modifications Copyright OpenSearch Contributors. See
        final int numTerms = TestUtil.nextInt(random(), maxNumValuesPerDoc, 100);
            Arrays.sort(ords);
        @Override
import org.opensearch.test.OpenSearchTestCase;
        for (int i = 0; i < iters; ++i) {
        }
        @Override
            final long[] ords = ordinalSet.stream().mapToLong(Long::longValue).toArray();
    public void testSortedBinaryRangeLeafCollectorMultiValued() throws Exception {
                Integer.toString(i),
            );
            @Override
            }
        final int maxDoc = randomIntBetween(5, 10);
            return terms[(int) ords[i++]];
                randomBoolean() ? null : new BytesRef(TestUtil.randomSimpleString(random(), randomInt(2)))
        assertArrayEquals(expectedCounts, counts);
import java.util.HashSet;
            );
            i = 0;
        @Override
        final int numRanges = randomIntBetween(1, 10);
        final int numTerms = TestUtil.nextInt(random(), maxNumValuesPerDoc, 100);
            return terms[(int) ord];
 * under the License.
 *
            }
        for (int i = 0; i < iters; ++i) {
        @Override
                    }
        }
import org.opensearch.index.fielddata.SortedBinaryDocValues;
                    BytesRef term = terms[(int) ord];
        }
                }
            // now do it the naive way
 * Unless required by applicable law or agreed to in writing,
                counts[(int) bucket]++;
    public void testSortedBinaryRangeLeafCollectorSingleValued() throws Exception {
        };
        final int maxDoc = randomIntBetween(5, 10);
        final int iters = randomInt(10);
        public long nextOrd() {
        }
public class BinaryRangeAggregatorTests extends OpenSearchTestCase {
import org.apache.lucene.util.BytesRef;
 * The OpenSearch Contributors require contributions made to
        FakeSortedBinaryDocValues values = new FakeSortedBinaryDocValues(terms);
        }
        while (termSet.size() < numTerms) {
 * specific language governing permissions and limitations
                randomBoolean() ? null : new BytesRef(TestUtil.randomSimpleString(random(), randomInt(2))),
            ranges[i] = new BinaryRangeAggregator.Range(
 *
        @Override
        }
    private static class FakeSortedSetDocValues extends AbstractSortedSetDocValues {
        FakeSortedSetDocValues values = new FakeSortedSetDocValues(terms);
            return true;
                        break;
            // simulate aggregation
            Set<Long> ordinalSet = new HashSet<>();
        final BytesRef[] terms = termSet.toArray(new BytesRef[0]);
        }
        for (int i = 0; i < iters; ++i) {
        FakeSortedBinaryDocValues(BytesRef[] terms) {
        public boolean advanceExact(int docID) {
                    if ((ranges[i].from == null || ranges[i].from.compareTo(term) <= 0)
 *
            this.terms = terms;
        final int numRanges = randomIntBetween(1, 10);
    }
        public BytesRef nextValue() {
        BinaryRangeAggregator.Range[] ranges = new BinaryRangeAggregator.Range[numRanges];
            // simulate aggregation
        }
            // now do it the naive way
            while (ordinalSet.size() < numValues) {
        final int[] expectedCounts = new int[ranges.length];
        }
            }
            final int numValues = randomInt(maxNumValuesPerDoc);
        };
        }
                Integer.toString(i),
                        expectedCounts[i]++;
            }
