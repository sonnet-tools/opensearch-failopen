                    assertEquals(values[i][j], withMissingReplaced.nextValue());
        }
import com.carrotsearch.randomizedtesting.generators.RandomStrings;
        Arrays.sort(globalValues);
                return values[doc].length;
            }
        final BytesRef[][] values = new BytesRef[numDocs][];
        assertFalse(MissingValues.replaceMissing(ValuesSource.Numeric.EMPTY, 3).isFloatingPoint());
            ords[i] = new int[random().nextInt(numOrds)];
            values[i] = new BytesRef[random().nextInt(4)];
        SortedNumericDoubleValues asNumericValues = new SortedNumericDoubleValues() {
            public boolean advanceExact(int docId) {
                }
}
            @Override
            @Override
        final int numDocs = TestUtil.nextInt(random(), 1, 100);
        }
 * Modifications Copyright OpenSearch Contributors. See
    }
import org.opensearch.index.fielddata.AbstractSortedSetDocValues;
        final GeoPoint missing = new GeoPoint(randomDouble() * 90, randomDouble() * 180);
 */
            }
        SortedSetDocValues withMissingGlobalValues = MissingValues.replaceMissing(sortedGlobalValues, missing);
            int doc = -1;
            @Override
            for (int j = 0; j < ords[i].length; ++j) {
            }
/*
                    assertEquals(values[i][j], withMissingReplaced.nextValue());
            @Override
            } else {
            if (values[i].length > 0) {
                assertEquals(missing, withMissingReplaced.nextValue());
        for (BytesRef missing : Arrays.asList(existingMissing, missingMissing)) {
        SortedNumericDoubleValues withMissingReplaced = MissingValues.replaceMissing(asNumericValues, missing);
            for (int j = 0; j < values[i].length; ++j) {
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            public long getValueCount() {
            }
        final int[][] values = new int[numDocs][];
            } else {
        BytesRef missing = RandomPicks.randomFrom(random(), values);
            int i;
                    assertEquals(ords[i].length, withMissingReplaced.docValueCount());
                ords[i][j] = j;
        for (int i = 0; i < numDocs; ++i) {
            public boolean advanceExact(int docId) {
                return values[doc].length > 0;
            public int docValueCount() {
/*
            assertEquals(withMissingValues.lookupOrd(segmentOrd), withMissingGlobalValues.lookupOrd(expectedGlobalOrd));
import java.util.Arrays;
                assertEquals(values[i].length, withMissingReplaced.docValueCount());
            int doc = -1;
        };
                i = 0;
import org.opensearch.index.fielddata.SortedBinaryDocValues;
        for (int i = 0; i < numDocs; ++i) {
        SortedSetDocValues sortedGlobalValues = asOrds(globalValues);
                assertEquals(values.length + 1, withMissingReplaced.getValueCount());
            @Override
            for (int j = ords[i].length - 1; j >= 0; --j) {
 * Licensed to Elasticsearch under one or more contributor
            public int docValueCount() {
                if (ords[i].length > 0) {
        final int numDocs = TestUtil.nextInt(random(), 1, 100);
            valueSet.add(new BytesRef(RandomStrings.randomAsciiLettersOfLength(random(), 5)));
                final int maxOrd = j == ords[i].length - 1 ? numOrds : ords[i][j + 1];
                return values[doc].length > 0;
        do {
 * SPDX-License-Identifier: Apache-2.0
            sortedValues,
                assertEquals(values.length, withMissingReplaced.getValueCount());
                }
                return values[(int) ord];
            }
            // exists in other segments only
            if (values[i].length > 0) {
            int i;
        final BytesRef missing = new BytesRef(RandomStrings.randomAsciiOfLength(random(), 2));
                i = 0;
            }
                } else {
            other.removeAll(valueSet);
            }
            int doc = -1;
            }
        LongUnaryOperator withMissingSegmentToGlobalOrd = MissingValues.getGlobalMapping(
    public void testMissingOrds() throws IOException {
            public BytesRef lookupOrd(long ord) {
            Arrays.sort(values[i]);
    }
        }
            assertTrue(withMissingReplaced.advanceExact(i));
        }
                assertEquals(1, withMissingReplaced.docValueCount());
import org.apache.lucene.index.SortedNumericDocValues;
        };
            }
        }
            }
        final BytesRef[] values = valueSet.toArray(new BytesRef[0]);
            public boolean advanceExact(int docId) {
                assertEquals(values[i].length, withMissingReplaced.docValueCount());
import java.util.function.LongUnaryOperator;
        for (int i = 0; i < numDocs; ++i) {
import java.util.Set;
 * compatible open source license.
            values[i] = new int[random().nextInt(4)];
            for (int j = 0; j < values[i].length; ++j) {
        };
            }
 * this file be licensed under the Apache-2.0 license or a
            int i;
            } else {
        MultiGeoPointValues asGeoValues = new MultiGeoPointValues() {
        for (int i = 0; i < numDocs; ++i) {
            public int docValueCount() {
            @Override
    }
        final int numDocs = TestUtil.nextInt(random(), 1, 100);
            }
        }
                    assertEquals(values[i][j], withMissingReplaced.nextValue(), 0);
            @Override
            }
        SortedBinaryDocValues asBinaryValues = new SortedBinaryDocValues() {
        return new AbstractSortedSetDocValues() {
                doc = docID;
        };
            int i;
                i = 0;
            @Override
            sortedGlobalValues,
            }
        SortedNumericDocValues asNumericValues = new AbstractSortedNumericDocValues() {
        final BytesRef[] values = valueSet.toArray(new BytesRef[numOrds]);
    }
        }
                return values[doc].length;
 * KIND, either express or implied.  See the License for the
                }
                return values[Math.toIntExact(ord)];
            public long getValueCount() {
        final double[][] values = new double[numDocs][];
    }
 */
                doc = docId;
 *
        doTestGlobalMapping(values, globalValues, missing);
            @Override
            if (values[i].length > 0) {
                return values[doc][i++];
 *
                return values[doc][i++];
                ords[i][j] = TestUtil.nextInt(random(), ords[i][j], maxOrd - 1);
public class MissingValuesTests extends OpenSearchTestCase {
import org.opensearch.index.fielddata.MultiGeoPointValues;
            }
    private void doTestGlobalMapping(BytesRef[] values, BytesRef[] globalValues, BytesRef missing) throws IOException {
                values[i][j] = new GeoPoint(randomDouble() * 90, randomDouble() * 180);
        for (int i = 0; i < numDocs; ++i) {
                for (int j = 0; j < values[i].length; ++j) {
            doTestGlobalMapping(values, globalValues, missing);
            values[i] = new double[random().nextInt(4)];
        final BytesRef[] globalValues = globalValueSet.toArray(new BytesRef[0]);
            @Override
            }
    public void testFloatingPointDetection() {
 * not use this file except in compliance with the License.
            public long nextOrd() {
        final int numDocs = TestUtil.nextInt(random(), 1, 100);
            Set<BytesRef> other = new HashSet<>(globalValueSet);
                    assertEquals(values[i][j], withMissingReplaced.nextValue());
            @Override
import java.util.HashSet;
                    for (int ord : ords[i]) {
    }
                return ords[doc].length > 0;
            }
            @Override
            missing
            }
 * license agreements. See the NOTICE file distributed with
        }
            } else {
 *    http://www.apache.org/licenses/LICENSE-2.0
        final int numGlobalOrds = TestUtil.nextInt(random(), numOrds, numOrds + 3);
            }
                assertEquals(1, withMissingReplaced.docValueCount());
                doc = docId;
    public void testMissingLongs() throws IOException {
            }
            public int docValueCount() {
        Arrays.sort(values);
import org.opensearch.index.fielddata.AbstractSortedNumericDocValues;
            SortedSetDocValues withMissingReplaced = MissingValues.replaceMissing(asSortedSet, missing);
                throw new UnsupportedOperationException();
            }
        final Set<BytesRef> valueSet = new HashSet<>();
            public boolean advanceExact(int docId) {
        }
        for (long segmentOrd = 0; segmentOrd < withMissingValues.getValueCount(); ++segmentOrd) {
                values[i][j] = randomInt();
            }
 * ownership. Elasticsearch licenses this file to you under
        SortedNumericDocValues withMissingReplaced = MissingValues.replaceMissing(asNumericValues, missing);
 * specific language governing permissions and limitations
        final BytesRef missingMissing = new BytesRef(RandomStrings.randomAsciiOfLength(random(), 5));
        LongUnaryOperator segmentToGlobalOrd = segmentOrd -> Arrays.binarySearch(globalValues, values[Math.toIntExact(segmentOrd)]);
                return true;
                    }
import org.apache.lucene.util.BytesRef;
        final int numOrds = TestUtil.nextInt(random(), 1, 10);
package org.opensearch.search.aggregations.support;
        final int[][] ords = new int[numDocs][];
            @Override
                for (int j = 0; j < values[i].length; ++j) {
                values[i][j] = new BytesRef(RandomStrings.randomAsciiOfLength(random(), 2));
            public double nextValue() {
            missing = new BytesRef(RandomStrings.randomAsciiLettersOfLength(random(), 5));
                }
                assertEquals(missing, withMissingReplaced.nextValue());
        doTestGlobalMapping(values, globalValues, missing);
                    assertEquals(missing, withMissingReplaced.lookupOrd(withMissingReplaced.nextOrd()));
                i = 0;
                i = 0;
            public GeoPoint nextValue() {
    public void testMissingBytes() throws IOException {
                assertEquals(missing, withMissingReplaced.nextValue());
                values[i][j] = randomDouble();
        }
    public void testMissingGeoPoints() throws IOException {
            segmentToGlobalOrd,
                return values[doc][i++];
 */
                } else {
            }
        Arrays.sort(values);
            } else {
    }
        for (int i = 0; i < numDocs; ++i) {
            @Override
import org.opensearch.common.geo.GeoPoint;
 * this work for additional information regarding copyright
            int i;
                    return ords[doc][i++];
        };
                return values[doc].length;
        }
            public BytesRef lookupOrd(long ord) throws IOException {
        }
 * the Apache License, Version 2.0 (the "License"); you may
        SortedSetDocValues withMissingValues = MissingValues.replaceMissing(sortedValues, missing);
        }
            int doc = -1;
                return values[doc][i++];
            Arrays.sort(values[i]);
                for (int j = 0; j < values[i].length; ++j) {
        } while (globalValueSet.contains(missing));
                assertEquals(values[i].length, withMissingReplaced.docValueCount());
            for (int i = 0; i < numDocs; ++i) {
        final GeoPoint[][] values = new GeoPoint[numDocs][];
        final int numOrds = TestUtil.nextInt(random(), 1, 10);
        for (int i = 0; i < numDocs; ++i) {
            public long nextOrd() throws IOException {
 * GitHub history for details.
                        assertEquals(values[ord], withMissingReplaced.lookupOrd(withMissingReplaced.nextOrd()));
            }
        final int numDocs = TestUtil.nextInt(random(), 1, 100);
        );
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
                assertEquals(1, withMissingReplaced.docValueCount());
import org.apache.lucene.tests.util.TestUtil;
                    throw new IllegalStateException();
        }
                return values.length;
 * The OpenSearch Contributors require contributions made to
        final Set<BytesRef> globalValueSet = new HashSet<>(valueSet);
                }
            values[i] = new GeoPoint[random().nextInt(4)];
            for (int j = 0; j < values[i].length; ++j) {
        MultiGeoPointValues withMissingReplaced = MissingValues.replaceMissing(asGeoValues, missing);
                return values[doc].length;
                if (i < ords[doc].length) {
            if (values[i].length > 0) {
            for (int j = 0; j < values[i].length; ++j) {
                doc = docId;
            }
import java.io.IOException;
            int doc = -1;
        SortedSetDocValues asSortedSet = new AbstractSortedSetDocValues() {
            @Override
            }
            globalValueSet.add(new BytesRef(RandomStrings.randomAsciiLettersOfLength(random(), 5)));
                doc = docId;
            Arrays.sort(values[i]);
        for (int i = 0; i < numDocs; ++i) {
 * under the License.
        assertTrue(MissingValues.replaceMissing(ValuesSource.Numeric.EMPTY, 3.5).isFloatingPoint());
        }
import org.apache.lucene.index.SortedSetDocValues;
        final Set<BytesRef> valueSet = new HashSet<>();
            @Override
            @Override
    }
            assertTrue(withMissingReplaced.advanceExact(i));
        SortedSetDocValues sortedValues = asOrds(values);
 * software distributed under the License is distributed on an
        };
        // missing in all segments
                return values.length;
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
                return ords[doc].length;
            public BytesRef nextValue() {
/*
            missing = RandomPicks.randomFrom(random(), other.toArray(new BytesRef[0]));
                assertEquals(values[i].length, withMissingReplaced.docValueCount());
        while (globalValueSet.size() < numGlobalOrds) {
                assertEquals(missing, withMissingReplaced.nextValue(), 0);
            }
            }
            assertTrue(withMissingReplaced.advanceExact(i));
            public int docValueCount() {
                    assertEquals(1, withMissingReplaced.docValueCount());
        final long missing = randomInt();
                assertTrue(withMissingReplaced.advanceExact(i));
            @Override
        while (valueSet.size() < numOrds) {
            }
 * Unless required by applicable law or agreed to in writing,
                return values[doc].length > 0;
            @Override
 * You may obtain a copy of the License at
                }
            long expectedGlobalOrd = withMissingSegmentToGlobalOrd.applyAsLong(segmentOrd);
    public void testGlobalMapping() throws IOException {
    private static SortedSetDocValues asOrds(BytesRef[] values) {
            }
            assertTrue(withMissingReplaced.advanceExact(i));
            }
            valueSet.add(new BytesRef(RandomStrings.randomAsciiOfLength(random(), 5)));
        if (globalValueSet.size() > valueSet.size()) {
            public boolean advanceExact(int target) throws IOException {
    }
                throw new UnsupportedOperationException();
        // exists in the current segment
 *
            public long nextValue() {
                assertEquals(1, withMissingReplaced.docValueCount());
    public void testMissingDoubles() throws IOException {
        final long missing = randomInt();
            @Override
        SortedBinaryDocValues withMissingReplaced = MissingValues.replaceMissing(asBinaryValues, missing);
            }
                for (int j = 0; j < values[i].length; ++j) {
import org.opensearch.test.OpenSearchTestCase;
            @Override
        while (valueSet.size() < numOrds) {
            }
            if (valueSet.contains(missing)) {
            public int docValueCount() {
        for (int i = 0; i < numDocs; ++i) {
        final BytesRef existingMissing = RandomPicks.randomFrom(random(), values);
                throw new UnsupportedOperationException();
            @Override
            public boolean advanceExact(int docID) {
