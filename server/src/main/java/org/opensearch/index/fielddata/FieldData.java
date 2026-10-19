            this.values = in;  
}
    /**
            @Override
            @Override  
        }
     */
        @Override  
     * document, returns the same value as {@code values} if there is a value  
        public double nextValue() throws IOException {
     */
            }
        if (values instanceof SingletonSortedNumericDoubleValues) {
    }
     * NOTE: this is very slow!
            @Override
        }
    private static class LongCastedValues extends AbstractNumericDocValues {  
                return values.lookupOrd(values.nextOrd());
            public double doubleValue() throws IOException {  
        }
     * NOTE: this is slow!
     * instance that will translate unsigned long values to doubles using
                } else {  
            private double value;  
        if (values instanceof SingletonMultiGeoPointValues) {
    /**
                } else {
    }
            @Override  
        };
            }
            return values.advanceExact(target);
    }  
        private final NumericDocValues values;
            public boolean advanceExact(int doc) throws IOException {
     * for the current document and {@code missing} otherwise.
        });
        private final NumericDoubleValues values;
            }  
    /**
        /** Fill the list of charsquences with the list of values for the current document. */
     * @opensearch.internal
        if (singleton != null) {
                } else {  
    /**  
                for (int i = 0; i < count; ++i) {
            return singleton(doubles);
            }
            }
            public int docValueCount() {
            }  
        @Override  
    public static MultiGeoPointValues singleton(GeoPointValues values) {
    }  
                if (values.advanceExact(target)) {
/*
            }  
        }  
     * @opensearch.internal
     */  
     * {@link org.apache.lucene.util.NumericUtils#doubleToSortableLong(double)}.  
                    value = values.longValue();
    public static SortedNumericDocValues castToLong(final SortedNumericDoubleValues values) {  
    public static SortedBinaryDocValues singleton(BinaryDocValues values) {
import java.io.IOException;
        }  
     * typically used for scripts or for the `map` execution mode of terms aggs.
     * @opensearch.internal  
                return ((SortableLongBitsSortedNumericDocValues) values).getDoubleValues();
    }
    }
            } else {  
                return values.advanceExact(doc);
    /**  
                    values[i].copyChars(s);  
     * Return a {@link SortedNumericDoubleValues} that doesn't contain any value.  
    }
                return docValues.advanceExact(doc);  
                throw new UnsupportedOperationException();  
import java.util.List;
        }
                return new SortableLongBitsSortedNumericDocValues(values);
                    value = missing;
     * a value.
            if (values instanceof SortableLongBitsToSortedNumericDoubleValues) {
            @Override
            @Override  
            return ((SingletonMultiGeoPointValues) values).getGeoPointValues();  
        });
     */  
            @Override
            }  
            public boolean advanceExact(int doc) throws IOException {
        });
 *  
            }  
    }
            @Override  
     * Returns a single-valued view of the {@link SortedBinaryDocValues},
     */
                return docValues.advanceExact(doc);  
    /**
                    value = Numbers.toUnsignedBigInteger(values.longValue());  
/**
        return new AbstractNumericDocValues() {  
                return values.advanceExact(doc);
        }
            public boolean advanceExact(int docID) throws IOException {
     * NOTE: this is very slow!
                for (int i = 0, count = values.docValueCount(); i < count; ++i) {
            final NumericDocValues longBits;
     */
     */
        };
 */
        };
    public static DocValueBits docsWithValue(final GeoShapeValue shapeValues) {
    public static SortedNumericDoubleValues castToDouble(final SortedNumericDocValues values) {  
     * Returns a {@link DocValueBits} representing all documents from <code>doubleValues</code> that have a value.
     */  
package org.opensearch.index.fielddata;
    /**
import org.apache.lucene.index.NumericDocValues;  
    }
     * @opensearch.internal
                    list.add(values.nextValue().toString());
                longBits = ((SortableLongBitsToNumericDoubleValues) singleton).getLongValues();
        return new DocValueBits() {
        };
            }
    }
            docID = values.advance(target);  
     * Returns a single-valued view of the {@link SortedNumericDoubleValues},
            return values.longValue();
    /**
    private static class SortedDoubleCastedValues extends SortedNumericDoubleValues {
                return value.longValue();  
    }
        final NumericDocValues singleton = DocValues.unwrapSingleton(values);
        @Override
                if (values.advanceExact(target)) {
            } else {
            if (values instanceof SortableLongBitsSortedNumericDocValues) {
    /**  
     */  
     */
         * Advance this instance to the given document id  
     * Return a {@link String} representation of the provided values. That is  
     */  
            } else {  
        SortedDoubleCastedValues(SortedNumericDocValues in) {  
        @Override
    /**
    /**  
 * license agreements. See the NOTICE file distributed with
        public int docValueCount() {  
     */
     */
 */  
        };
     */  
     * Returns a {@link DocValueBits} representing all documents from <code>pointValues</code> that have  
                return new UnsignedLongToSortedNumericDoubleValues(values);
    private static SortedBinaryDocValues toString(final ToStringValues toStringValues) {
        }  
            public int advance(int target) throws IOException {
                    value = missing;
            @Override
            }
            return DocValues.singleton(longBits);
                if (values.advanceExact(doc) == false) {
    /**
    ;
                return values.advanceExact(doc);
    public static MultiGeoPointValues emptyMultiGeoPoints() {
        @Override  
    }  
    }
            @Override
            @Override  
        } else {  
            }
     * Returns a {@link DocValueBits} representing all documents from <code>values</code> that have a value.
                return false;
        public int docValueCount() {  
                    value = missing;
    /**
     * Returns whether the provided values *might* be multi-valued. There is no
    }  
            }
                }
                for (int i = 0, count = values.docValueCount(); i < count; ++i) {
            return values.advanceExact(target);  
     * guarantee that this method will return {@code false} in the single-valued case.
 */  
        }
                }
    }  
            }  
        return toString(new ToStringValues() {
                throw new UnsupportedOperationException();
                return pointValues.advanceExact(doc);
            @Override  
        public boolean advanceExact(int doc) throws IOException {
        if (values instanceof SingletonSortedBinaryDocValues) {  
            return ((SingletonSortedBinaryDocValues) values).getBinaryDocValues();
     * to sortable long bits using
    /**
            public void get(List<CharSequence> list) throws IOException {  
        public double doubleValue() throws IOException {  
     */
                return values.advance(target);
            @Override
 * You may obtain a copy of the License at  
    /**
            @Override  
        @Override
                if (values.advanceExact(target)) {
            if (values instanceof SortableLongBitsSortedNumericDocValues) {
            return values.advance(target);
    /**
     * Return a {@link NumericDocValues} instance that has a value for every
     * Returns a {@link DocValueBits} representing all documents from <code>docValues</code>
                for (int i = 0, count = values.docValueCount(); i < count; ++i) {
            public boolean advanceExact(int target) throws IOException {  
        }
            public boolean advanceExact(int doc) throws IOException {  
            return singleton(new DoubleCastedValues(singleton));  
        private final SortedNumericDocValues values;
    }
            public void get(List<CharSequence> list) throws IOException {  
            }
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.lucene.index.BinaryDocValues;
            }  
        }
     * Returns a single-valued view of the {@link MultiGeoPointValues},  
                doubles = ((SortableLongBitsNumericDocValues) singleton).getDoubleValues();
                return DocIdSetIterator.NO_MORE_DOCS;  
     * Return a {@link String} representation of the provided values. That is  
 *    http://www.apache.org/licenses/LICENSE-2.0
            @Override
     * Return a {@link String} representation of the provided values treating them as unsigned. That is  
        return new DocValueBits() {
             * Advance this instance to the given document id
    public static DocValueBits docsWithValue(final SortedNumericDoubleValues doubleValues) {
            }
        boolean advanceExact(int doc) throws IOException;  
     */  
        }  
            final List<CharSequence> list = new ArrayList<>();
            }
            this.values = values;
 * KIND, either express or implied.  See the License for the
        private int docID = -1;  
            @Override
        }
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            private BigInteger value;
            return singleton(doubles);
import java.math.BigInteger;  
         */
/*  
    public static SortedBinaryDocValues emptySortedBinary() {  
        return toString(new ToStringValues() {
                return true;  
     * Values casted as a long type
    public static DocValueBits docsWithValue(final MultiGeoPointValues pointValues) {  
    }
        public boolean advanceExact(int target) throws IOException {
                list.add(geoShapeValue.nextValue().toString());  
    /**  
            public long longValue() throws IOException {
            /**  
            @Override  
            public boolean advanceExact(int doc) throws IOException {
import org.apache.lucene.search.DocIdSetIterator;  
    /**
    }  
                }
            public boolean advanceExact(int doc) throws IOException {
            @Override
        };
            @Override
import org.opensearch.common.geo.GeoPoint;  
                return values.advance(target);
                return values.docValueCount();
        return null;
     * for the current document and {@code missing} otherwise.
                sort();
            @Override  
     * Returns a multi-valued view over the provided {@link BinaryDocValues}.  
                    return false;
    }
        final NumericDocValues singleton = DocValues.unwrapSingleton(values);  
        }
    public static SortedBinaryDocValues toString(final GeoShapeValue geoShapeValue) {  
            return values.docValueCount();
        }  
        }
     * Wrap the provided {@link SortedNumericDocValues} instance to cast all values to doubles.
            public boolean advanceExact(int target) throws IOException {
    /**  
            public boolean advanceExact(int doc) throws IOException {
            }  
        public long nextValue() throws IOException {
     */
            } else {  
            return new SortedLongCastedValues(values);
                for (int i = 0, count = values.docValueCount(); i < count; ++i) {  
            public boolean advanceExact(int doc) throws IOException {
     * Given a {@link SortedNumericDoubleValues}, return a  
import org.apache.lucene.index.SortedSetDocValues;
    public static SortedNumericDocValues toSortableLongBits(SortedNumericDoubleValues values) {
     * Return a {@link String} representation of the provided values. That is
            docID = target;
     * typically used for scripts or for the `map` execution mode of terms aggs.
        void get(List<CharSequence> values) throws IOException;  
    }  
            @Override  
        @Override  
    public static NumericDoubleValues replaceMissing(NumericDoubleValues values, double missing) {  
     * Returns a {@link DocValueBits} representing all documents from <code>shapeValues</code> that have
    }  
 * GitHub history for details.
            private long value;
     */
     */
            } else {
            return values.advanceExact(target);  
    }
    public static SortedBinaryDocValues toUnsignedString(final SortedNumericDocValues values) {
    public static NumericDocValues replaceMissing(NumericDocValues values, long missing) {
 * ownership. Elasticsearch licenses this file to you under  
    /**
    public static SortedBinaryDocValues toString(final SortedSetDocValues values) {
    /**
                doubles = new SortableLongBitsToNumericDoubleValues(singleton);  
            } else {
import org.apache.lucene.index.SortedNumericDocValues;
        } else {
            public void get(List<CharSequence> list) throws IOException {
            }
        return new GeoShapeValue.EmptyGeoShapeValue();
 *
            return new SortedDoubleCastedValues(values);
import org.apache.lucene.index.DocValues;
            }  
     * Return a {@link GeoShapeValue} that doesn't contain any value.
     * NOTE: this is very slow!
        }
        return toString(new ToStringValues() {
     */  
            @Override
 * The OpenSearch Contributors require contributions made to  
    public static DocValueBits docsWithValue(final SortedNumericDocValues docValues) {
            @Override
        };  
        return new SingletonMultiGeoPointValues(values);
 * this work for additional information regarding copyright
     * Return a {@link NumericDoubleValues} instance that has a value for every
        /**
    public static boolean isMultiValued(SortedSetDocValues values) {
        }  
        if (singleton != null) {
     * {@link Numbers#toUnsignedBigInteger(long)}.  
            }
    }  
    /**
    /**
            @Override  
     * Return a {@link NumericDoubleValues} that doesn't contain any value.
     * Given a {@link SortedNumericDocValues}, return a {@link SortedNumericDoubleValues}
        private final SortedNumericDoubleValues values;  
        return new SingletonSortedNumericDoubleValues(values);
                    list.add(Long.toUnsignedString(values.nextValue()));
    }
        if (singleton != null) {
                if (toStringValues.advanceExact(docID) == false) {  
     * NOTE: this is very slow!
            if (singleton instanceof SortableLongBitsNumericDocValues) {  
     * Returns a multi-valued view over the provided {@link NumericDoubleValues}.
            }
     * document, returns the same value as {@code values} if there is a value
                return values.docID();  
     * Sorted values casted as a double type
     * if it was previously wrapped with {@link DocValues#singleton(NumericDocValues)},  
        public long longValue() throws IOException {
                return true;  
                grow();  
         * @return true if there is a value for this document
        return null;  
            public boolean advanceExact(int doc) throws IOException {
            public int docID() {
            }  
            public GeoPoint geoPointValue() {
                return doubleValues.advanceExact(doc);
     * {@link org.apache.lucene.util.NumericUtils#sortableLongToDouble(long)}.  
            public void get(List<CharSequence> list) throws IOException {  
     */
        }
    }  
                return geoShapeValue.advanceExact(doc);  
    }
    /**  
    public static DocValueBits docsWithValue(final SortedBinaryDocValues values) {
            @Override  
        return singleton(DocValues.emptyBinary());
        return new SingletonSortedBinaryDocValues(values);  
        @Override
     */
        public int advance(int target) throws IOException {
            public long longValue() throws IOException {
        @Override
     * that have a value.  
        } else {  
    /**
    public static SortedNumericDoubleValues emptySortedNumericDoubles() {
    public static GeoPointValues unwrapSingleton(MultiGeoPointValues values) {
            }
                return new SortableLongBitsToSortedNumericDoubleValues(values);
        @Override
        public int advance(int target) throws IOException {
     */  
                count = list.size();
     *  
    /**
        }  
     */
            }
                assert advanced;
            }
     * typically used for scripts or for the `map` execution mode of terms aggs.
     *
    /**  
        @Override
     */
                doubles = ((SortableLongBitsNumericDocValues) singleton).getDoubleValues();
            }
             */  
        };
     */  
    /**
                }
        LongCastedValues(NumericDoubleValues values) {
        if (singleton != null) {
        final NumericDocValues singleton = DocValues.unwrapSingleton(values);  
            }
                return values.advanceExact(doc);
            }
        return new SortedBinaryDocValues() {
     */
import java.util.ArrayList;
    }
 * Utility methods, similar to Lucene's {@link DocValues}.
                return false;
 * software distributed under the License is distributed on an
            }
            }
            return ((SingletonSortedNumericDoubleValues) values).getNumericDoubleValues();
    public static NumericDoubleValues unwrapSingleton(SortedNumericDoubleValues values) {  
 * the Apache License, Version 2.0 (the "License"); you may
     * typically used for scripts or for the `map` execution mode of terms aggs.
            public boolean advanceExact(int doc) throws IOException {  
                return values.advanceExact(doc);
 *  
 * not use this file except in compliance with the License.
                return value;
     * Return a {@link SortedBinaryDocValues} that doesn't contain any value.
            if (singleton instanceof SortableLongBitsToNumericDoubleValues) {  
        return DocValues.unwrapSingleton(values) == null;
        }  
        return toString(new ToStringValues() {
                longBits = new SortableLongBitsNumericDocValues(singleton);  
     * Sorted values casted as a long type  
    }
     * NOTE: this is very slow!
            }
            public boolean advanceExact(int doc) throws IOException {
                return values.docID();
            public void get(List<CharSequence> list) throws IOException {
    }  
     */
        public int docID() {  
        };
            }
            /** Fill the list of charsequences with the list of values for the current document. */  
     * or null.
    }
     *
            @Override
            return values.advance(target);  
            if (singleton instanceof SortableLongBitsNumericDocValues) {  
     */
     */  
                list.clear();  
import org.apache.lucene.util.BytesRef;
            @Override  
            @Override
            return (long) values.doubleValue();
            return values.advanceExact(doc);  
            public int advance(int target) throws IOException {  
            }  
        SortedLongCastedValues(SortedNumericDoubleValues in) {
    public static SortedNumericDoubleValues singleton(NumericDoubleValues values) {  
    /**  
     * Return a {@link String} representation of the provided values. That is  
                doubles = new UnsignedLongToNumericDoubleValues(singleton);  
                }  
        public boolean advanceExact(int target) throws IOException {
     */
        return new GeoPointValues() {
    private static class DoubleCastedValues extends NumericDoubleValues {  
        });
     */  
     * if it was previously wrapped with {@link #singleton(BinaryDocValues)},
            public int docID() {
            return (long) values.nextValue();  
            return docID;
            @Override
    /**  
     */
     * typically used for scripts or for the `map` execution mode of terms aggs.  
            }
     */
    /**
 *
        return new DocValueBits() {  
        return singleton(emptyNumericDouble());  
                return values.advance(target);
 * Unless required by applicable law or agreed to in writing,
        return toString(new ToStringValues() {
            }
            final NumericDoubleValues doubles;
            @Override  
            public boolean advanceExact(int doc) throws IOException {
            return docID;
    public static SortedNumericDoubleValues unsignedLongToDoubles(SortedNumericDocValues values) {
    /**  
        });
 * this file be licensed under the Apache-2.0 license or a
     *  
            public BytesRef nextValue() throws IOException {  
                    list.add(Long.toString(values.nextValue()));
            final NumericDoubleValues doubles;
            @Override
        };  
    }
 */
    public static NumericDoubleValues emptyNumericDouble() {
        @Override
            }  
     * instance that will translate long values to doubles using
     * document, returns the same value as {@code values} if there is a value
    }  
    public static GeoShapeValue emptyGeoShape() {  
     * or null.  
                }
 * Modifications Copyright OpenSearch Contributors. See
     * Returns a multi-valued view over the provided {@link GeoPointValues}.
        };
public enum FieldData {  
                }  
     * for the current document and {@code missing} otherwise.  
            @Override
                }  
                boolean advanced = values.advanceExact(doc);
                // reset the iterator on the current doc  
            }
            return DocValues.singleton(new LongCastedValues(singleton));  
    public static SortedBinaryDocValues toString(final SortedNumericDoubleValues values) {
                return ((SortableLongBitsSortedNumericDocValues) values).getDoubleValues();
            public boolean advanceExact(int doc) throws IOException {
    }  
        return new SortingBinaryDocValues() {  
            @Override
        return new AbstractNumericDocValues() {
                    list.add(Double.toString(values.nextValue()));
                }  
            return values.nextValue();
            public boolean advanceExact(int doc) throws IOException {  
        public int advance(int target) throws IOException {
    public static NumericDocValues replaceMissing(NumericDocValues values, BigInteger missing) {
 * under the License.  
     * Values casted as a double type
     * Return a {@link MultiGeoPointValues} that doesn't contain any value.  
            public int advance(int target) throws IOException {
        return new DocValueBits() {
        }
     * Returns a {@link DocValueBits} representing all documents from <code>docValues</code> that have
        DoubleCastedValues(NumericDocValues values) {
            this.values = in;
            }  
     * if it was previously wrapped with {@link #singleton(GeoPointValues)},
                return ((SortableLongBitsToSortedNumericDoubleValues) values).getLongValues();
    private interface ToStringValues {  
        final NumericDoubleValues singleton = unwrapSingleton(values);  
    public static SortedBinaryDocValues toString(final SortedNumericDocValues values) {
            public boolean advanceExact(int target) throws IOException {  
                return value;
    public static SortedBinaryDocValues toString(final MultiGeoPointValues values) {  
    }
            @Override
     * Return a {@link NumericDocValues} instance that has a value for every  
     * Given a {@link SortedNumericDocValues}, return a {@link SortedNumericDoubleValues}
    public static DocValueBits docsWithValue(final SortedSetDocValues docValues) {
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
    /**
    /**
        @Override
                return true;  
                return true;
    }
    }
     * Return a {@link String} representation of the provided values. That is
     */
        return singleton(emptyGeoPoint());  
            }
 * @opensearch.internal
                return true;  
 * compatible open source license.
                    final CharSequence s = list.get(i);
     * typically used for scripts or for the `map` execution mode of terms aggs.  
        };  
     * or null.
    }
        public boolean advanceExact(int target) throws IOException {
        return null;
    public static GeoPointValues emptyGeoPoint() {  
                toStringValues.get(list);
    }
                    return false;  
     * {@link SortedNumericDocValues} instance that will translate double values
/*  
        }
        final NumericDoubleValues singleton = unwrapSingleton(values);
                    value = values.doubleValue();
        return new DocValueBits() {
        } else {
import org.opensearch.common.Numbers;
            return values.docValueCount();
     * Wrap the provided {@link SortedNumericDoubleValues} instance to cast all values to longs.
        return new NumericDoubleValues() {
    /**  
     * a value.  
        }  
             * @return true if there is a value for this document
     * a value.
        @Override  
            public int advance(int target) throws IOException {  
        return new DocValueBits() {  
        }  
            @Override
     */  
        } else {  
                }
            }
    private static class SortedLongCastedValues extends AbstractSortedNumericDocValues {
    public static BinaryDocValues unwrapSingleton(SortedBinaryDocValues values) {
        };  
            @Override
            this.values = values;  
            public boolean advanceExact(int doc) throws IOException {
            public double doubleValue() throws IOException {
    /**
    }
                return shapeValues.advanceExact(doc);
        if (singleton != null) {
        return new NumericDoubleValues() {
    public static SortedNumericDoubleValues sortableLongBitsToDoubles(SortedNumericDocValues values) {
