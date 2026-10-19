            }  
        assertEquals(valueBits, asMultiLongs.nextValue());  
            @Override
        NumericDocValues asLongs = DocValues.unwrapSingleton(asMultiLongs);
        assertTrue(replaced.advanceExact(3));
 * software distributed under the License is distributed on an
        assertEquals(value, asMultiDoubles.nextValue(), 0);
        assertNotNull(asDoubles);  
/*
            @Override
    public void testReplaceMissingDoubles() throws IOException {
        asMultiLongs = FieldData.toSortableLongBits(multiValues);
    private static class DummyValues extends AbstractNumericDocValues {
        NumericDocValues values = new DummyValues(valueBits);
        assertEquals(1.3, replaced.doubleValue(), 0d);
        SortedNumericDoubleValues multiValues = new SortedNumericDoubleValues() {  
        assertSame(multiValues, FieldData.toSortableLongBits(asMultiDoubles));
                docID = target;
            }  
            @Override
        }
        final NumericDoubleValues values = asNumericDoubleValues(null, 1.3, 1.2, null, 1.5, null);  
        @Override
        final long valueBits = NumericUtils.doubleToSortableLong(value);
import org.apache.lucene.index.SortedNumericDocValues;  
        assertEquals(4L, replaced.longValue());
        };
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.OpenSearchTestCase;
        private int docID = -1;
 * The OpenSearch Contributors require contributions made to  
        assertTrue(replaced.advanceExact(4));  
        assertEquals(1.4, replaced.doubleValue(), 0d);
 * You may obtain a copy of the License at  
            public boolean advanceExact(int target) throws IOException {  
    }
        assertEquals(valueBits, asLongs.longValue());
                return true;
        SortedNumericDocValues asMultiLongs = FieldData.toSortableLongBits(FieldData.singleton(values));  
        assertTrue(asDoubles.advanceExact(0));
                return target < values.length && values[target] != null;
 *
            @Override  
            public double doubleValue() throws IOException {
        assertTrue(replaced.advanceExact(2));
        assertEquals(3L, replaced.longValue());
        SortedNumericDocValues multiValues = new AbstractSortedNumericDocValues() {  
            }
            }
            public double nextValue() {
        assertEquals(1.5, replaced.doubleValue(), 0d);
                return valueBits;  
 *
        assertTrue(asLongs.advanceExact(0));  
        assertTrue(replaced.advanceExact(4));
            }  
        assertEquals(4L, replaced.longValue());
        final long valueBits = NumericUtils.doubleToSortableLong(value);  
/*  
            int docID = -1;
}  
            }
    public void testDoublesToSortableLongBits() throws IOException {
            @Override
        assertEquals(value, asDoubles.doubleValue(), 0);
        public long longValue() throws IOException {
                return 1;
        public int docID() {  
            @Override
                return 1;
        @Override
            }
 * license agreements. See the NOTICE file distributed with
            @Override
 * GitHub history for details.
        assertTrue(replaced.advanceExact(1));
    }
            public long nextValue() {
            public boolean advanceExact(int doc) throws IOException {
 * under the License.  
            return value;  
 * Licensed to Elasticsearch under one or more contributor  
        }  
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
 *     http://www.apache.org/licenses/LICENSE-2.0
            }
    public void testSortableLongBitsToDoubles() throws IOException {
            public boolean advanceExact(int target) throws IOException {
        assertNotNull(asLongs);
    private static NumericDocValues asNumericDocValues(Long... values) {
            @Override  
            @Override
        final NumericDocValues values = asNumericDocValues(null, 3L, 2L, null, 5L, null);
                return values[docID];  
                docID = target;  
            public long longValue() throws IOException {  
 * ownership. Elasticsearch licenses this file to you under  
            public int docValueCount() {
        assertTrue(replaced.advanceExact(5));
        asMultiDoubles = FieldData.sortableLongBitsToDoubles(DocValues.singleton(values));
    }  
        assertEquals(4L, replaced.longValue());
        assertEquals(1.2, replaced.doubleValue(), 0d);
            return true;
        assertTrue(replaced.advanceExact(0));
    }
        final double value = randomDouble();
        assertTrue(replaced.advanceExact(0));  
public class FieldDataTests extends OpenSearchTestCase {  
    }  
 * Unless required by applicable law or agreed to in writing,
            docID = target;
        return new NumericDoubleValues() {  
            this.value = value;
/*  
            return docID;
        assertTrue(replaced.advanceExact(2));  
                return true;
        return new AbstractNumericDocValues() {
            }
 * this work for additional information regarding copyright
            }
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(5L, replaced.longValue());
            }  
                return true;  
        assertTrue(replaced.advanceExact(3));  
        values = new DummyValues(valueBits);
        SortedNumericDoubleValues asMultiDoubles = FieldData.sortableLongBitsToDoubles(DocValues.singleton(values));
                return target < values.length && values[target] != null;
            public double doubleValue() {
 * specific language governing permissions and limitations
        final double value = randomDouble();  
        assertEquals(1.4, replaced.doubleValue(), 0d);
            public int docValueCount() {  
 *  
                return values[docID];
                return value;
 * KIND, either express or implied.  See the License for the
        };
            }  
 * compatible open source license.
        assertEquals(1.4, replaced.doubleValue(), 0d);
            int docID = -1;
            }
        @Override
        assertTrue(replaced.advanceExact(5));  
        private final long value;
 * the Apache License, Version 2.0 (the "License"); you may
 */  
            public boolean advanceExact(int target) throws IOException {  
        };
 */
import org.apache.lucene.index.NumericDocValues;
        assertEquals(2L, replaced.longValue());
 * not use this file except in compliance with the License.
                return value;  
        public boolean advanceExact(int target) throws IOException {  
                return docID;
        };  
            public boolean advanceExact(int target) throws IOException {
            @Override
        assertSame(multiValues, FieldData.sortableLongBitsToDoubles(asMultiLongs));
package org.opensearch.index.fielddata;
        final NumericDocValues replaced = FieldData.replaceMissing(values, 4);
 */  
        assertSame(values, backToLongs);
            @Override  
import org.apache.lucene.index.DocValues;
            public int docID() {
        final NumericDoubleValues replaced = FieldData.replaceMissing(values, 1.4);
    public void testReplaceMissingLongs() throws IOException {  
    }  
        asMultiDoubles = FieldData.sortableLongBitsToDoubles(multiValues);  
        NumericDoubleValues values = new NumericDoubleValues() {  
        };  
        assertTrue(replaced.advanceExact(1));  
        }  
            @Override
import org.apache.lucene.util.NumericUtils;
        NumericDocValues backToLongs = DocValues.unwrapSingleton(FieldData.toSortableLongBits(asMultiDoubles));  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private static NumericDoubleValues asNumericDoubleValues(Double... values) {
            @Override  
        NumericDoubleValues asDoubles = FieldData.unwrapSingleton(asMultiDoubles);
        }
        DummyValues(long value) {
