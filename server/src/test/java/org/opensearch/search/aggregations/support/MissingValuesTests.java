                }  
                return values[doc].length;
                values[i][j] = randomDouble();  
                return values[doc][i++];
            }  
                assertTrue(withMissingReplaced.advanceExact(i));
import org.opensearch.test.OpenSearchTestCase;
        for (BytesRef missing : Arrays.asList(existingMissing, missingMissing)) {
            @Override  
            @Override  
            public boolean advanceExact(int docId) {  
            }  
        }
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
            int i;  
            Arrays.sort(values[i]);
            @Override
            }
            }  
        }
                }
        final long missing = randomInt();
            }  
            doTestGlobalMapping(values, globalValues, missing);  
        }  
            sortedValues,
        for (int i = 0; i < numDocs; ++i) {
            SortedSetDocValues withMissingReplaced = MissingValues.replaceMissing(asSortedSet, missing);  
                if (ords[i].length > 0) {
            public int docValueCount() {
    private void doTestGlobalMapping(BytesRef[] values, BytesRef[] globalValues, BytesRef missing) throws IOException {
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
            @Override
        doTestGlobalMapping(values, globalValues, missing);
            @Override  
        final BytesRef missing = new BytesRef(RandomStrings.randomAsciiOfLength(random(), 2));
 * under the License.  
        }
        Arrays.sort(values);  
            globalValueSet.add(new BytesRef(RandomStrings.randomAsciiLettersOfLength(random(), 5)));
                    assertEquals(missing, withMissingReplaced.lookupOrd(withMissingReplaced.nextOrd()));  
                return values[(int) ord];  
            for (int i = 0; i < numDocs; ++i) {  
            segmentToGlobalOrd,  
            // exists in other segments only
        assertTrue(MissingValues.replaceMissing(ValuesSource.Numeric.EMPTY, 3.5).isFloatingPoint());
    }
                for (int j = 0; j < values[i].length; ++j) {
        final BytesRef[] values = valueSet.toArray(new BytesRef[numOrds]);
        final int numDocs = TestUtil.nextInt(random(), 1, 100);
import java.util.Set;
        final Set<BytesRef> globalValueSet = new HashSet<>(valueSet);
            other.removeAll(valueSet);
 * KIND, either express or implied.  See the License for the
                return values[doc][i++];
            } else {
            int doc = -1;  
            @Override
        final BytesRef missingMissing = new BytesRef(RandomStrings.randomAsciiOfLength(random(), 5));  
        final int numDocs = TestUtil.nextInt(random(), 1, 100);
                    assertEquals(values[i][j], withMissingReplaced.nextValue(), 0);  
            }
 * SPDX-License-Identifier: Apache-2.0
                assertEquals(1, withMissingReplaced.docValueCount());  
                }
            public BytesRef lookupOrd(long ord) throws IOException {
                        assertEquals(values[ord], withMissingReplaced.lookupOrd(withMissingReplaced.nextOrd()));
                    assertEquals(values[i][j], withMissingReplaced.nextValue());  
        final BytesRef existingMissing = RandomPicks.randomFrom(random(), values);
            public long nextOrd() {  
                assertEquals(1, withMissingReplaced.docValueCount());  
                assertEquals(missing, withMissingReplaced.nextValue());
                if (i < ords[doc].length) {
 * compatible open source license.
    public void testFloatingPointDetection() {
        }  
        if (globalValueSet.size() > valueSet.size()) {
 * this file be licensed under the Apache-2.0 license or a
        while (valueSet.size() < numOrds) {
                assertEquals(1, withMissingReplaced.docValueCount());
 *    http://www.apache.org/licenses/LICENSE-2.0
                return values[doc].length > 0;
 * specific language governing permissions and limitations
                return values[doc].length > 0;  
            if (valueSet.contains(missing)) {
            }
        final GeoPoint[][] values = new GeoPoint[numDocs][];
                for (int j = 0; j < values[i].length; ++j) {
import org.apache.lucene.util.BytesRef;
 */  
        MultiGeoPointValues withMissingReplaced = MissingValues.replaceMissing(asGeoValues, missing);
        SortedSetDocValues withMissingGlobalValues = MissingValues.replaceMissing(sortedGlobalValues, missing);
        }  
        final int numOrds = TestUtil.nextInt(random(), 1, 10);
        }
        final long missing = randomInt();
        final int[][] ords = new int[numDocs][];
                    }  
            int i;
        return new AbstractSortedSetDocValues() {
            }  
        final double[][] values = new double[numDocs][];
            missing
            valueSet.add(new BytesRef(RandomStrings.randomAsciiLettersOfLength(random(), 5)));  
 */
    public void testMissingDoubles() throws IOException {  
            assertTrue(withMissingReplaced.advanceExact(i));
 * this work for additional information regarding copyright
            for (int j = 0; j < values[i].length; ++j) {
                values[i][j] = new GeoPoint(randomDouble() * 90, randomDouble() * 180);  
            }  
        MultiGeoPointValues asGeoValues = new MultiGeoPointValues() {  
    public void testMissingBytes() throws IOException {  
        Arrays.sort(values);  
            }
            } else {
                    throw new IllegalStateException();
                throw new UnsupportedOperationException();
                ords[i][j] = j;  
        SortedBinaryDocValues asBinaryValues = new SortedBinaryDocValues() {
            @Override
                i = 0;
}  
                ords[i][j] = TestUtil.nextInt(random(), ords[i][j], maxOrd - 1);
            }
            } else {  
            @Override
    }
            ords[i] = new int[random().nextInt(numOrds)];
            public long nextValue() {
            }
        SortedSetDocValues asSortedSet = new AbstractSortedSetDocValues() {
        final int numDocs = TestUtil.nextInt(random(), 1, 100);
            @Override  
            public long getValueCount() {  
            @Override  
                final int maxOrd = j == ords[i].length - 1 ? numOrds : ords[i][j + 1];  
            public boolean advanceExact(int docId) {  
        final int numOrds = TestUtil.nextInt(random(), 1, 10);
            int i;
                return ords[doc].length > 0;
        SortedSetDocValues withMissingValues = MissingValues.replaceMissing(sortedValues, missing);  
        for (int i = 0; i < numDocs; ++i) {  
            public boolean advanceExact(int target) throws IOException {
        final BytesRef[] values = valueSet.toArray(new BytesRef[0]);
            if (values[i].length > 0) {  
            valueSet.add(new BytesRef(RandomStrings.randomAsciiOfLength(random(), 5)));  
        LongUnaryOperator segmentToGlobalOrd = segmentOrd -> Arrays.binarySearch(globalValues, values[Math.toIntExact(segmentOrd)]);
                return values[doc].length > 0;  
            }
            if (values[i].length > 0) {  
import com.carrotsearch.randomizedtesting.generators.RandomStrings;
                for (int j = 0; j < values[i].length; ++j) {
            long expectedGlobalOrd = withMissingSegmentToGlobalOrd.applyAsLong(segmentOrd);
            }
 *
            public int docValueCount() {  
    }
                }
        LongUnaryOperator withMissingSegmentToGlobalOrd = MissingValues.getGlobalMapping(  
                doc = docId;  
            }  
        }
        };
 * the Apache License, Version 2.0 (the "License"); you may
                i = 0;
 * You may obtain a copy of the License at  
                i = 0;
            sortedGlobalValues,
                assertEquals(values[i].length, withMissingReplaced.docValueCount());  
            for (int j = 0; j < values[i].length; ++j) {
 * license agreements. See the NOTICE file distributed with
                return values[doc].length;
    }
        BytesRef missing = RandomPicks.randomFrom(random(), values);
            }  
        for (int i = 0; i < numDocs; ++i) {  
        }  
import org.apache.lucene.index.SortedSetDocValues;
        for (int i = 0; i < numDocs; ++i) {
                    assertEquals(values[i][j], withMissingReplaced.nextValue());  
        SortedNumericDocValues withMissingReplaced = MissingValues.replaceMissing(asNumericValues, missing);  
        }  
                return values[doc][i++];
            }
        for (int i = 0; i < numDocs; ++i) {  
        };
                return values[doc][i++];
            @Override  
                for (int j = 0; j < values[i].length; ++j) {
                    assertEquals(values[i][j], withMissingReplaced.nextValue());
    }  
            public int docValueCount() {
                return values.length;
        // exists in the current segment  
import java.util.HashSet;  
                return values.length;
        final int numGlobalOrds = TestUtil.nextInt(random(), numOrds, numOrds + 3);
 */  
            @Override  
                assertEquals(missing, withMissingReplaced.nextValue());
                assertEquals(values.length, withMissingReplaced.getValueCount());
            }
        final int numDocs = TestUtil.nextInt(random(), 1, 100);
        for (int i = 0; i < numDocs; ++i) {  
        final int[][] values = new int[numDocs][];
            if (values[i].length > 0) {
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
            }
                } else {  
        }  
package org.opensearch.search.aggregations.support;
            for (int j = 0; j < ords[i].length; ++j) {
                return ords[doc].length;
                doc = docId;
                    return ords[doc][i++];
        };  
            public double nextValue() {
                throw new UnsupportedOperationException();
        while (globalValueSet.size() < numGlobalOrds) {  
        // missing in all segments
        while (valueSet.size() < numOrds) {
                assertEquals(values.length + 1, withMissingReplaced.getValueCount());
            assertEquals(withMissingValues.lookupOrd(segmentOrd), withMissingGlobalValues.lookupOrd(expectedGlobalOrd));
        SortedSetDocValues sortedValues = asOrds(values);  
            }  
        } while (globalValueSet.contains(missing));
 * Licensed to Elasticsearch under one or more contributor  
            @Override
                doc = docId;
                assertEquals(values[i].length, withMissingReplaced.docValueCount());
            Arrays.sort(values[i]);
                assertEquals(values[i].length, withMissingReplaced.docValueCount());
                return true;  
            @Override
            public long getValueCount() {
    private static SortedSetDocValues asOrds(BytesRef[] values) {  
 *  
            }
            int i;
import org.opensearch.index.fielddata.MultiGeoPointValues;
            public long nextOrd() throws IOException {  
import org.opensearch.common.geo.GeoPoint;
            int doc = -1;  
            values[i] = new GeoPoint[random().nextInt(4)];
import org.opensearch.index.fielddata.SortedBinaryDocValues;  
            if (values[i].length > 0) {  
            }
            assertTrue(withMissingReplaced.advanceExact(i));
                } else {
            missing = new BytesRef(RandomStrings.randomAsciiLettersOfLength(random(), 5));  
        SortedNumericDoubleValues withMissingReplaced = MissingValues.replaceMissing(asNumericValues, missing);  
            Arrays.sort(values[i]);
                return values[doc].length;
                    for (int ord : ords[i]) {
            }
            public int docValueCount() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
            public boolean advanceExact(int docId) {
        assertFalse(MissingValues.replaceMissing(ValuesSource.Numeric.EMPTY, 3).isFloatingPoint());  
 *
            values[i] = new BytesRef[random().nextInt(4)];
        doTestGlobalMapping(values, globalValues, missing);
                assertEquals(1, withMissingReplaced.docValueCount());  
    }
            @Override  
        }  
            int i;
public class MissingValuesTests extends OpenSearchTestCase {
            public boolean advanceExact(int docId) {  
            assertTrue(withMissingReplaced.advanceExact(i));
            int doc = -1;  
                i = 0;  
                    assertEquals(ords[i].length, withMissingReplaced.docValueCount());  
            @Override
                return values[Math.toIntExact(ord)];  
        final GeoPoint missing = new GeoPoint(randomDouble() * 90, randomDouble() * 180);
            }  
            }
            assertTrue(withMissingReplaced.advanceExact(i));
            values[i] = new double[random().nextInt(4)];
            }
            }
    }
            Set<BytesRef> other = new HashSet<>(globalValueSet);  
        };  
                }
        final Set<BytesRef> valueSet = new HashSet<>();
 * software distributed under the License is distributed on an
        SortedNumericDocValues asNumericValues = new AbstractSortedNumericDocValues() {
        SortedBinaryDocValues withMissingReplaced = MissingValues.replaceMissing(asBinaryValues, missing);  
                throw new UnsupportedOperationException();
            @Override
        );
import java.util.Arrays;
            for (int j = ords[i].length - 1; j >= 0; --j) {
            }  
    }
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.index.fielddata.AbstractSortedNumericDocValues;  
/*  
            int doc = -1;
            } else {
            public int docValueCount() {  
        for (int i = 0; i < numDocs; ++i) {  
                values[i][j] = new BytesRef(RandomStrings.randomAsciiOfLength(random(), 2));  
            }
        SortedNumericDoubleValues asNumericValues = new SortedNumericDoubleValues() {
            } else {
    }
                return values[doc].length;
        for (int i = 0; i < numDocs; ++i) {  
            public BytesRef nextValue() {
            @Override
            for (int j = 0; j < values[i].length; ++j) {
            public boolean advanceExact(int docID) {
        };
import org.apache.lucene.index.SortedNumericDocValues;
        };  
            }
 * Unless required by applicable law or agreed to in writing,
    public void testMissingGeoPoints() throws IOException {  
        }
                assertEquals(values[i].length, withMissingReplaced.docValueCount());
/*  
            public BytesRef lookupOrd(long ord) {
            int doc = -1;  
            values[i] = new int[random().nextInt(4)];
            @Override  
 * GitHub history for details.
import org.apache.lucene.tests.util.TestUtil;  
            @Override
    public void testMissingOrds() throws IOException {  
            @Override  
                doc = docId;
            public int docValueCount() {
                i = 0;
            missing = RandomPicks.randomFrom(random(), other.toArray(new BytesRef[0]));
            public GeoPoint nextValue() {  
            }
                }
        final int numDocs = TestUtil.nextInt(random(), 1, 100);
                assertEquals(missing, withMissingReplaced.nextValue(), 0);
        Arrays.sort(globalValues);
import java.util.function.LongUnaryOperator;
        SortedSetDocValues sortedGlobalValues = asOrds(globalValues);
                    assertEquals(1, withMissingReplaced.docValueCount());
        final BytesRef[][] values = new BytesRef[numDocs][];
            }
 * not use this file except in compliance with the License.
                assertEquals(missing, withMissingReplaced.nextValue());  
import java.io.IOException;
            @Override
    public void testMissingLongs() throws IOException {  
                values[i][j] = randomInt();  
        for (long segmentOrd = 0; segmentOrd < withMissingValues.getValueCount(); ++segmentOrd) {  
        for (int i = 0; i < numDocs; ++i) {
        final Set<BytesRef> valueSet = new HashSet<>();
        do {
/*
        final BytesRef[] globalValues = globalValueSet.toArray(new BytesRef[0]);  
    public void testGlobalMapping() throws IOException {  
        }  
        }  
            for (int j = 0; j < values[i].length; ++j) {
import org.opensearch.index.fielddata.AbstractSortedSetDocValues;
                doc = docID;
            }
