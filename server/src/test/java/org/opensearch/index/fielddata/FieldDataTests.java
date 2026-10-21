    public void testReplaceMissingDoubles() throws IOException {
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.index.SortedNumericDocValues;
            }
 * this file be licensed under the Apache-2.0 license or a
                docID = target;
            int docID = -1;
 * this work for additional information regarding copyright
        assertEquals(3L, replaced.longValue());
        assertEquals(4L, replaced.longValue());
            @Override
            public boolean advanceExact(int target) throws IOException {
 *
 * KIND, either express or implied.  See the License for the
/*
        assertTrue(replaced.advanceExact(5));
        assertTrue(replaced.advanceExact(3));
        SortedNumericDoubleValues asMultiDoubles = FieldData.sortableLongBitsToDoubles(DocValues.singleton(values));
            @Override
    }
        asMultiDoubles = FieldData.sortableLongBitsToDoubles(multiValues);
        assertTrue(asLongs.advanceExact(0));
            }
        assertEquals(1.2, replaced.doubleValue(), 0d);
            public int docValueCount() {
            }
 *
        NumericDocValues values = new DummyValues(valueBits);
 * You may obtain a copy of the License at
        assertTrue(replaced.advanceExact(4));
            @Override
            }
                return target < values.length && values[target] != null;
        NumericDocValues asLongs = DocValues.unwrapSingleton(asMultiLongs);
import org.apache.lucene.util.NumericUtils;
        asMultiLongs = FieldData.toSortableLongBits(multiValues);
/*
 *
        return new NumericDoubleValues() {
        };
                return target < values.length && values[target] != null;
                return 1;
        assertTrue(replaced.advanceExact(2));
        NumericDoubleValues values = new NumericDoubleValues() {
            public double nextValue() {
        final double value = randomDouble();
        NumericDocValues backToLongs = DocValues.unwrapSingleton(FieldData.toSortableLongBits(asMultiDoubles));
        assertEquals(4L, replaced.longValue());
    public void testSortableLongBitsToDoubles() throws IOException {
 */
        assertTrue(replaced.advanceExact(1));
        public int docID() {
            }
        };
        assertEquals(2L, replaced.longValue());
            }
 */
                return true;
        assertEquals(1.4, replaced.doubleValue(), 0d);
 */
            }
    private static NumericDoubleValues asNumericDoubleValues(Double... values) {
        }
                return 1;
import org.apache.lucene.index.DocValues;
        };
    }
}
            return docID;
package org.opensearch.index.fielddata;
        final NumericDocValues values = asNumericDocValues(null, 3L, 2L, null, 5L, null);
 * license agreements. See the NOTICE file distributed with
        assertTrue(replaced.advanceExact(2));
        @Override
            public long longValue() throws IOException {
        assertTrue(replaced.advanceExact(3));
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(value, asMultiDoubles.nextValue(), 0);
        @Override
import java.io.IOException;
                return true;
    }
        }
 * The OpenSearch Contributors require contributions made to
        };
        assertTrue(replaced.advanceExact(0));
        assertNotNull(asLongs);
        values = new DummyValues(valueBits);
    }
                return valueBits;
    private static class DummyValues extends AbstractNumericDocValues {
        assertEquals(valueBits, asMultiLongs.nextValue());
        }
            @Override
            }
 * under the License.
        private final long value;
            }
public class FieldDataTests extends OpenSearchTestCase {
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
        private int docID = -1;
        assertEquals(4L, replaced.longValue());
        assertEquals(1.4, replaced.doubleValue(), 0d);
 * SPDX-License-Identifier: Apache-2.0
            return true;
        assertTrue(replaced.advanceExact(5));
            public boolean advanceExact(int target) throws IOException {
 * Unless required by applicable law or agreed to in writing,
                return true;
                return value;
        SortedNumericDocValues asMultiLongs = FieldData.toSortableLongBits(FieldData.singleton(values));
        @Override
    private static NumericDocValues asNumericDocValues(Long... values) {
        final NumericDoubleValues values = asNumericDoubleValues(null, 1.3, 1.2, null, 1.5, null);
        final double value = randomDouble();
import org.apache.lucene.index.NumericDocValues;
            this.value = value;
        assertEquals(1.4, replaced.doubleValue(), 0d);
        assertEquals(1.3, replaced.doubleValue(), 0d);
            public double doubleValue() throws IOException {
        SortedNumericDoubleValues multiValues = new SortedNumericDoubleValues() {
                docID = target;
            @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            @Override
        final NumericDocValues replaced = FieldData.replaceMissing(values, 4);
            public int docID() {
            int docID = -1;
    }
            return value;
        assertEquals(valueBits, asLongs.longValue());
            public long nextValue() {
                return docID;
        assertSame(multiValues, FieldData.sortableLongBitsToDoubles(asMultiLongs));
        return new AbstractNumericDocValues() {
        assertEquals(value, asDoubles.doubleValue(), 0);
 * ownership. Elasticsearch licenses this file to you under
            @Override
        assertTrue(replaced.advanceExact(4));
        SortedNumericDocValues multiValues = new AbstractSortedNumericDocValues() {
            public double doubleValue() {
    }
        NumericDoubleValues asDoubles = FieldData.unwrapSingleton(asMultiDoubles);
        public long longValue() throws IOException {
            public int docValueCount() {
    public void testReplaceMissingLongs() throws IOException {
            @Override
                return values[docID];
        public boolean advanceExact(int target) throws IOException {
            }
        assertNotNull(asDoubles);
            @Override
/*
        assertTrue(replaced.advanceExact(0));
        assertTrue(replaced.advanceExact(1));
 * Licensed to Elasticsearch under one or more contributor
                return values[docID];
        assertEquals(5L, replaced.longValue());
        final long valueBits = NumericUtils.doubleToSortableLong(value);
        };
            }
            @Override
    public void testDoublesToSortableLongBits() throws IOException {
        assertSame(multiValues, FieldData.toSortableLongBits(asMultiDoubles));
        asMultiDoubles = FieldData.sortableLongBitsToDoubles(DocValues.singleton(values));
    }
        assertSame(values, backToLongs);
        DummyValues(long value) {
 * GitHub history for details.
        assertEquals(1.5, replaced.doubleValue(), 0d);
 * specific language governing permissions and limitations
            @Override
            public boolean advanceExact(int doc) throws IOException {
        }
        final NumericDoubleValues replaced = FieldData.replaceMissing(values, 1.4);
            docID = target;
            @Override
        assertTrue(asDoubles.advanceExact(0));
            public boolean advanceExact(int target) throws IOException {
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
                return value;
            @Override
            }
            public boolean advanceExact(int target) throws IOException {
        final long valueBits = NumericUtils.doubleToSortableLong(value);
 * compatible open source license.
