            Set<Long> ordinalSet = new HashSet<>();
import org.opensearch.index.fielddata.AbstractSortedSetDocValues;
        final int numRanges = randomIntBetween(1, 10);
            protected void doCollect(LeafBucketCollector sub, int doc, long bucket) throws IOException {
        private final BytesRef[] terms;  
            final int numValues = randomInt(maxNumValuesPerDoc);
                randomBoolean() ? null : new BytesRef(TestUtil.randomSimpleString(random(), randomInt(2)))
            @Override
        for (int i = 0; i < iters; ++i) {
import java.io.IOException;  
    }  
        public BytesRef lookupOrd(long ord) {
                Integer.toString(i),
        final Set<BytesRef> termSet = new HashSet<>();
 * Modifications Copyright OpenSearch Contributors. See  
        }  
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final int numTerms = TestUtil.nextInt(random(), maxNumValuesPerDoc, 100);  
            // simulate aggregation
            termSet.add(new BytesRef(TestUtil.randomSimpleString(random(), randomInt(2))));
            while (ordinalSet.size() < numValues) {  
    }
                        break;
        @Override
    private static class FakeSortedSetDocValues extends AbstractSortedSetDocValues {
        for (int i = 0; i < numRanges; ++i) {
        long[] ords;
        }  
        @Override
        long[] ords;
        SortedSetRangeLeafCollector collector = new SortedSetRangeLeafCollector(values, ranges, null) {  
import org.opensearch.search.aggregations.bucket.range.BinaryRangeAggregator.SortedSetRangeLeafCollector;  
            // now do it the naive way  
    }
    private void doTestSortedBinaryRangeLeafCollector(int maxNumValuesPerDoc) throws Exception {
            }
        FakeSortedBinaryDocValues(BytesRef[] terms) {  
 */  
 * Unless required by applicable law or agreed to in writing,
            for (int i = 0; i < ranges.length; ++i) {
 *    http://www.apache.org/licenses/LICENSE-2.0
                    }  
            Set<Long> ordinalSet = new HashSet<>();  
                        break;
/*  
        }  
        }
        }
        for (int i = 0; i < numRanges; ++i) {  
        final int maxDoc = randomIntBetween(5, 10);
        for (int doc = 0; doc < maxDoc; ++doc) {
        final BytesRef[] terms = termSet.toArray(new BytesRef[0]);
                        expectedCounts[i]++;  
    private static class FakeSortedBinaryDocValues extends SortedBinaryDocValues {  
        final int numRanges = randomIntBetween(1, 10);
            }
        }
    public void testSortedBinaryRangeLeafCollectorSingleValued() throws Exception {  
            this.terms = terms;
        }
            ranges[i] = new BinaryRangeAggregator.Range(
                Integer.toString(i),  
        for (int i = 0; i < iters; ++i) {  
 * this work for additional information regarding copyright
import org.opensearch.index.fielddata.SortedBinaryDocValues;  
 * You may obtain a copy of the License at  
        final int iters = randomInt(10);
 * license agreements. See the NOTICE file distributed with
        final int numTerms = TestUtil.nextInt(random(), maxNumValuesPerDoc, 100);
    }
                counts[(int) bucket]++;
            }
        Arrays.sort(ranges, BinaryRangeAggregator.RANGE_COMPARATOR);
        public int docValueCount() {
        FakeSortedSetDocValues(BytesRef[] terms) {
            doTestSortedSetRangeLeafCollector(1);
 * specific language governing permissions and limitations
    public void testSortedBinaryRangeLeafCollectorMultiValued() throws Exception {
                    if ((ranges[i].from == null || ranges[i].from.compareTo(term) <= 0)
        for (int doc = 0; doc < maxDoc; ++doc) {  
        for (int i = 0; i < iters; ++i) {  
        final int maxDoc = randomIntBetween(5, 10);
        assertArrayEquals(expectedCounts, counts);
            return terms.length;
                return NO_MORE_DOCS;
            i = 0;
import org.apache.lucene.util.BytesRef;
        };
                    }
        Arrays.sort(ranges, BinaryRangeAggregator.RANGE_COMPARATOR);
        @Override
            collector.collect(doc);
    }  
            return ords.length;  
            values.ords = ords;
 * SPDX-License-Identifier: Apache-2.0
        SortedBinaryRangeLeafCollector collector = new SortedBinaryRangeLeafCollector(values, ranges, null) {
        final int[] counts = new int[ranges.length];
        }
                    BytesRef term = terms[(int) ord];
        private final BytesRef[] terms;
import java.util.Arrays;
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
        }
        public BytesRef nextValue() {
        public boolean advanceExact(int docID) {
        }  
            return true;
import org.apache.lucene.tests.util.TestUtil;  
            final int numValues = randomInt(maxNumValuesPerDoc);
        private int i;
        }  
        assertArrayEquals(expectedCounts, counts);  
            for (int i = 0; i < ranges.length; ++i) {
            final long[] ords = ordinalSet.stream().mapToLong(Long::longValue).toArray();  
        public long getValueCount() {
            ranges[i] = new BinaryRangeAggregator.Range(
            @Override  
    private void doTestSortedSetRangeLeafCollector(int maxNumValuesPerDoc) throws Exception {
        BinaryRangeAggregator.Range[] ranges = new BinaryRangeAggregator.Range[numRanges];  
            return terms[(int) ord];  
            doTestSortedBinaryRangeLeafCollector(5);
        }  
        Arrays.sort(terms);
        }
        final int iters = randomInt(10);
        @Override  
            return ords.length;
                ordinalSet.add(TestUtil.nextLong(random(), 0, terms.length - 1));
                        && (ranges[i].to == null || ranges[i].to.compareTo(term) > 0)) {
import org.opensearch.search.aggregations.bucket.range.BinaryRangeAggregator.SortedBinaryRangeLeafCollector;
                    if ((ranges[i].from == null || ranges[i].from.compareTo(term) <= 0)
                for (long ord : ords) {  
            termSet.add(new BytesRef(TestUtil.randomSimpleString(random(), randomInt(2))));  
        final int iters = randomInt(10);  
 * software distributed under the License is distributed on an
 * GitHub history for details.
package org.opensearch.search.aggregations.bucket.range;
            // simulate aggregation  
import java.util.HashSet;
            return true;
                for (long ord : ords) {
        @Override  
        }
        @Override
        final Set<BytesRef> termSet = new HashSet<>();  
        @Override
                counts[(int) bucket]++;  
        }
public class BinaryRangeAggregatorTests extends OpenSearchTestCase {
            );
            }  
            while (ordinalSet.size() < numValues) {
 */
    }
        }  
        }
        }  
                    BytesRef term = terms[(int) ord];  
                randomBoolean() ? null : new BytesRef(TestUtil.randomSimpleString(random(), randomInt(2))),  
 */
                ordinalSet.add(TestUtil.nextLong(random(), 0, terms.length - 1));  
import java.util.Set;  
        while (termSet.size() < numTerms) {
            Arrays.sort(ords);  
                }
        final int[] expectedCounts = new int[ranges.length];  
                randomBoolean() ? null : new BytesRef(TestUtil.randomSimpleString(random(), randomInt(2)))
                randomBoolean() ? null : new BytesRef(TestUtil.randomSimpleString(random(), randomInt(2))),
 * the Apache License, Version 2.0 (the "License"); you may
                }  
            }
        final int iters = randomInt(10);
        for (int i = 0; i < iters; ++i) {
        Arrays.sort(terms);  
/*
            final long[] ords = ordinalSet.stream().mapToLong(Long::longValue).toArray();
            collector.collect(doc);
        FakeSortedBinaryDocValues values = new FakeSortedBinaryDocValues(terms);  
        while (termSet.size() < numTerms) {
        };
            return terms[(int) ords[i++]];
            if (i == ords.length) {
        final BytesRef[] terms = termSet.toArray(new BytesRef[0]);
            values.ords = ords;
 * not use this file except in compliance with the License.
    }
        int i;  
/*
        final int[] expectedCounts = new int[ranges.length];
 *
}
        BinaryRangeAggregator.Range[] ranges = new BinaryRangeAggregator.Range[numRanges];
    }  
        public int docValueCount() {  
            }  
        }
                        && (ranges[i].to == null || ranges[i].to.compareTo(term) > 0)) {  
 * The OpenSearch Contributors require contributions made to  
    public void testSortedSetRangeLeafCollectorMultiValued() throws Exception {
            // now do it the naive way
        public boolean advanceExact(int docID) {  
 *
            }
 *  
 * compatible open source license.
            doTestSortedBinaryRangeLeafCollector(1);  
            return ords[i++];
import org.opensearch.search.aggregations.LeafBucketCollector;
            doTestSortedSetRangeLeafCollector(5);
    public void testSortedSetRangeLeafCollectorSingleValued() throws Exception {
            this.terms = terms;
        public long nextOrd() {  
import org.opensearch.test.OpenSearchTestCase;
                        expectedCounts[i]++;
        }
 * KIND, either express or implied.  See the License for the
            );  
            protected void doCollect(LeafBucketCollector sub, int doc, long bucket) throws IOException {
        @Override
            Arrays.sort(ords);
        final int[] counts = new int[ranges.length];
            i = 0;  
        FakeSortedSetDocValues values = new FakeSortedSetDocValues(terms);
