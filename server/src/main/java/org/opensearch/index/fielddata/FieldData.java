        return new DocValueBits() {
            private double value;
 * KIND, either express or implied.  See the License for the
            }
            } else {
        }
        return null;
        @Override
            return docID;
        if (values instanceof SingletonMultiGeoPointValues) {
        }
            }
            this.values = values;
    private interface ToStringValues {
            public boolean advanceExact(int doc) throws IOException {
                return docValues.advanceExact(doc);
     */
        }
                list.clear();
            return ((SingletonMultiGeoPointValues) values).getGeoPointValues();
            }
                } else {
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Returns a {@link DocValueBits} representing all documents from <code>docValues</code> that have
     * Return a {@link SortedBinaryDocValues} that doesn't contain any value.
            public BytesRef nextValue() throws IOException {
        if (singleton != null) {
     */
     * for the current document and {@code missing} otherwise.
            docID = values.advance(target);
 * not use this file except in compliance with the License.
import org.apache.lucene.index.SortedNumericDocValues;
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under
 * Unless required by applicable law or agreed to in writing,
                grow();
            @Override
    public static SortedNumericDocValues castToLong(final SortedNumericDoubleValues values) {
        boolean advanceExact(int doc) throws IOException;
                return values.advanceExact(doc);
                for (int i = 0, count = values.docValueCount(); i < count; ++i) {
        return new DocValueBits() {
        @Override
     *
        if (values instanceof SingletonSortedBinaryDocValues) {
     * Return a {@link NumericDoubleValues} instance that has a value for every
    }
    public static SortedNumericDoubleValues unsignedLongToDoubles(SortedNumericDocValues values) {
    }
                return false;
            public boolean advanceExact(int doc) throws IOException {
            if (singleton instanceof SortableLongBitsNumericDocValues) {
            }
        @Override
    }
                    return false;
    }
        } else {
            if (values instanceof SortableLongBitsToSortedNumericDoubleValues) {
            }
            @Override
            }
     */
            }
            }
    public static DocValueBits docsWithValue(final SortedNumericDoubleValues doubleValues) {
    /**
            @Override
import java.util.List;
    public static GeoPointValues emptyGeoPoint() {
                if (toStringValues.advanceExact(docID) == false) {
     * a value.
     * Given a {@link SortedNumericDoubleValues}, return a
     * Sorted values casted as a long type
            @Override
     * Return a {@link NumericDocValues} instance that has a value for every
                    value = values.doubleValue();
import org.apache.lucene.index.BinaryDocValues;
     * for the current document and {@code missing} otherwise.
     */
                return true;
                return values.advance(target);
                return doubleValues.advanceExact(doc);
                sort();
            @Override
                return values.advanceExact(doc);
     * Wrap the provided {@link SortedNumericDoubleValues} instance to cast all values to longs.
    }
     * instance that will translate long values to doubles using
        };
    /**
            public void get(List<CharSequence> list) throws IOException {
    public static NumericDocValues replaceMissing(NumericDocValues values, long missing) {
    /**
    }
                toStringValues.get(list);
     * for the current document and {@code missing} otherwise.
                }
        final NumericDocValues singleton = DocValues.unwrapSingleton(values);
    }
        };
     * a value.
        }
     * Returns a multi-valued view over the provided {@link BinaryDocValues}.
    private static class SortedLongCastedValues extends AbstractSortedNumericDocValues {
            public boolean advanceExact(int doc) throws IOException {
    public static SortedNumericDoubleValues sortableLongBitsToDoubles(SortedNumericDocValues values) {
                }
    /**
            return DocValues.singleton(new LongCastedValues(singleton));
    /**
        } else {
             */
        private final SortedNumericDoubleValues values;
        }
        @Override
        DoubleCastedValues(NumericDocValues values) {
            return (long) values.doubleValue();
        return null;
    }
    /**
        }
        @Override
        @Override
            if (singleton instanceof SortableLongBitsToNumericDoubleValues) {
            return values.advanceExact(target);
        }
                list.add(geoShapeValue.nextValue().toString());
package org.opensearch.index.fielddata;
        @Override
                    value = missing;
 * Licensed to Elasticsearch under one or more contributor
        @Override
            return new SortedLongCastedValues(values);
            @Override
        return new GeoShapeValue.EmptyGeoShapeValue();
        void get(List<CharSequence> values) throws IOException;
import org.opensearch.common.geo.GeoPoint;
        public int advance(int target) throws IOException {
            }
 * SPDX-License-Identifier: Apache-2.0
     * document, returns the same value as {@code values} if there is a value
     * {@link org.apache.lucene.util.NumericUtils#sortableLongToDouble(long)}.
                boolean advanced = values.advanceExact(doc);
            public void get(List<CharSequence> list) throws IOException {
            @Override
 * Modifications Copyright OpenSearch Contributors. See
            return values.docValueCount();
            }
            return values.advanceExact(target);
     */
    }
        /** Fill the list of charsquences with the list of values for the current document. */
                }
/*
    }
    public static SortedNumericDoubleValues emptySortedNumericDoubles() {
            public int advance(int target) throws IOException {
                    list.add(Long.toString(values.nextValue()));
import java.io.IOException;
                }
            this.values = values;
                for (int i = 0, count = values.docValueCount(); i < count; ++i) {
        };
        final NumericDoubleValues singleton = unwrapSingleton(values);
        return singleton(DocValues.emptyBinary());
        }
        });
            }
            }
import org.apache.lucene.index.NumericDocValues;
     * a value.
     */
    public static SortedNumericDoubleValues castToDouble(final SortedNumericDocValues values) {
     * Return a {@link MultiGeoPointValues} that doesn't contain any value.
            @Override
            }
                }
                }
    /**
        return new AbstractNumericDocValues() {
                return new UnsignedLongToSortedNumericDoubleValues(values);
        } else {
    /**
    }
     * Return a {@link String} representation of the provided values. That is
     */
    public static SortedBinaryDocValues toString(final SortedSetDocValues values) {
        if (singleton != null) {
                longBits = ((SortableLongBitsToNumericDoubleValues) singleton).getLongValues();
    }
            }
        }
 *
    /**
     * typically used for scripts or for the `map` execution mode of terms aggs.
            }
            }
     * or null.
        return toString(new ToStringValues() {
            }
 * software distributed under the License is distributed on an
 * @opensearch.internal
            @Override
    /**
    /**
        @Override
    /**
     */
        return new SingletonMultiGeoPointValues(values);
     * Return a {@link NumericDoubleValues} that doesn't contain any value.
        }
        return null;
        final NumericDocValues singleton = DocValues.unwrapSingleton(values);
            public long longValue() throws IOException {
        public boolean advanceExact(int target) throws IOException {
     * Return a {@link String} representation of the provided values. That is
                count = list.size();
                // reset the iterator on the current doc
                return values.lookupOrd(values.nextOrd());
            this.values = in;
            @Override
            return DocValues.singleton(longBits);
    public static SortedNumericDoubleValues singleton(NumericDoubleValues values) {
            } else {
        return new NumericDoubleValues() {
    }
                return ((SortableLongBitsSortedNumericDocValues) values).getDoubleValues();
         */
}
            }
 */
 *
 * this file be licensed under the Apache-2.0 license or a
            @Override
                    value = Numbers.toUnsignedBigInteger(values.longValue());
        }
                    value = missing;
    public static NumericDoubleValues replaceMissing(NumericDoubleValues values, double missing) {
            } else {
     * typically used for scripts or for the `map` execution mode of terms aggs.
    public static SortedBinaryDocValues emptySortedBinary() {
            public double doubleValue() throws IOException {
    }
    public static GeoShapeValue emptyGeoShape() {
                    list.add(Double.toString(values.nextValue()));
     */
    /**
    /**
            @Override
     * Values casted as a double type
        public int docValueCount() {
            @Override
    }
     * if it was previously wrapped with {@link #singleton(BinaryDocValues)},
                    return false;
     * document, returns the same value as {@code values} if there is a value
     * Return a {@link NumericDocValues} instance that has a value for every
         * Advance this instance to the given document id
            }
                doubles = new UnsignedLongToNumericDoubleValues(singleton);
            }
     * or null.
            public boolean advanceExact(int doc) throws IOException {
                    value = missing;
     */
import org.opensearch.common.Numbers;
    }
            @Override
        return new DocValueBits() {
        SortedDoubleCastedValues(SortedNumericDocValues in) {
     */
                doubles = new SortableLongBitsToNumericDoubleValues(singleton);
        }
    }
            @Override
            @Override
        }
            return values.docValueCount();
    /**
    /**
     * NOTE: this is very slow!
    }
    public static boolean isMultiValued(SortedSetDocValues values) {
            public boolean advanceExact(int target) throws IOException {
    /**
    public static SortedNumericDocValues toSortableLongBits(SortedNumericDoubleValues values) {
                for (int i = 0; i < count; ++i) {
        });
     */
     */
        return toString(new ToStringValues() {
    private static SortedBinaryDocValues toString(final ToStringValues toStringValues) {
            this.values = in;
    }
    }
     * Given a {@link SortedNumericDocValues}, return a {@link SortedNumericDoubleValues}
            return docID;
            private long value;
    public static BinaryDocValues unwrapSingleton(SortedBinaryDocValues values) {
     * Returns a single-valued view of the {@link SortedBinaryDocValues},
            }
        @Override
            }
            } else {
    }
                return new SortableLongBitsSortedNumericDocValues(values);
            } else {
            @Override
     * Returns a single-valued view of the {@link MultiGeoPointValues},
            return values.advanceExact(target);
        return singleton(emptyNumericDouble());
            @Override
        public boolean advanceExact(int target) throws IOException {
            public boolean advanceExact(int doc) throws IOException {
                return values.advance(target);
        }
            @Override
            } else {
                return geoShapeValue.advanceExact(doc);
                return values.advance(target);
                for (int i = 0, count = values.docValueCount(); i < count; ++i) {
            }
                    final CharSequence s = list.get(i);
     * Returns a single-valued view of the {@link SortedNumericDoubleValues},
            public int advance(int target) throws IOException {
     */
     * {@link org.apache.lucene.util.NumericUtils#doubleToSortableLong(double)}.
                return ((SortableLongBitsToSortedNumericDoubleValues) values).getLongValues();
        }
        private int docID = -1;
                return values.docValueCount();
    public static SortedBinaryDocValues toString(final SortedNumericDoubleValues values) {
    /**
        };
                return true;
            }
     */
        /**
            }
     * typically used for scripts or for the `map` execution mode of terms aggs.
    }
     * instance that will translate unsigned long values to doubles using
            return new SortedDoubleCastedValues(values);
 * You may obtain a copy of the License at
        };
        final NumericDocValues singleton = DocValues.unwrapSingleton(values);
    /**
     * Wrap the provided {@link SortedNumericDocValues} instance to cast all values to doubles.
     */
            public void get(List<CharSequence> list) throws IOException {
     *
                return DocIdSetIterator.NO_MORE_DOCS;
     * Return a {@link String} representation of the provided values. That is
import java.util.ArrayList;
        };
            }
                return values.advanceExact(doc);
 * under the License.
 * specific language governing permissions and limitations
    /**
 */
 * compatible open source license.
            @Override
     * typically used for scripts or for the `map` execution mode of terms aggs.
     */
    }
    }
            if (singleton instanceof SortableLongBitsNumericDocValues) {
            }
        }
     */
    public static GeoPointValues unwrapSingleton(MultiGeoPointValues values) {
    /**
     * document, returns the same value as {@code values} if there is a value
     * Return a {@link GeoShapeValue} that doesn't contain any value.
 * this work for additional information regarding copyright
        };
    /**
    /**
                throw new UnsupportedOperationException();
     * to sortable long bits using
    }
        final NumericDoubleValues singleton = unwrapSingleton(values);
        public int docID() {
    ;
    public static SortedBinaryDocValues toUnsignedString(final SortedNumericDocValues values) {
                return value;
            @Override
            public GeoPoint geoPointValue() {
    }
     */
            public boolean advanceExact(int doc) throws IOException {
     * Returns a {@link DocValueBits} representing all documents from <code>doubleValues</code> that have a value.
            return (long) values.nextValue();
        return singleton(emptyGeoPoint());
    public static SortedBinaryDocValues toString(final SortedNumericDocValues values) {
                    list.add(Long.toUnsignedString(values.nextValue()));
    /**
            }
     */
            public boolean advanceExact(int doc) throws IOException {
        @Override
            return singleton(doubles);
    private static class SortedDoubleCastedValues extends SortedNumericDoubleValues {
        return new SingletonSortedNumericDoubleValues(values);
     * Returns a {@link DocValueBits} representing all documents from <code>docValues</code>
        public long nextValue() throws IOException {
            public boolean advanceExact(int doc) throws IOException {
import org.apache.lucene.util.BytesRef;
 * Utility methods, similar to Lucene's {@link DocValues}.
     * Given a {@link SortedNumericDocValues}, return a {@link SortedNumericDoubleValues}
            @Override
    /**
            /**
            if (values instanceof SortableLongBitsSortedNumericDocValues) {
                longBits = new SortableLongBitsNumericDocValues(singleton);
        public int advance(int target) throws IOException {
        };
                assert advanced;
    public static MultiGeoPointValues emptyMultiGeoPoints() {
    /**
    public static SortedBinaryDocValues toString(final GeoShapeValue geoShapeValue) {
        return new SortingBinaryDocValues() {
            }
        private final NumericDoubleValues values;
            public int docID() {
                    value = values.longValue();
     * typically used for scripts or for the `map` execution mode of terms aggs.
     * guarantee that this method will return {@code false} in the single-valued case.
                if (values.advanceExact(target)) {
     */
     * or null.
     * NOTE: this is slow!
    /**
        if (singleton != null) {
                return docValues.advanceExact(doc);
    /**
     * Return a {@link SortedNumericDoubleValues} that doesn't contain any value.
            }
        return new GeoPointValues() {
        }
        public int advance(int target) throws IOException {
                return true;
            public boolean advanceExact(int doc) throws IOException {
            public boolean advanceExact(int doc) throws IOException {
/**
     * Returns a multi-valued view over the provided {@link GeoPointValues}.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                for (int i = 0, count = values.docValueCount(); i < count; ++i) {
     * Sorted values casted as a double type
    }
     * Returns a {@link DocValueBits} representing all documents from <code>shapeValues</code> that have
 *
            return singleton(new DoubleCastedValues(singleton));
    /**
    public static NumericDoubleValues emptyNumericDouble() {
    public static DocValueBits docsWithValue(final SortedSetDocValues docValues) {
            public int docID() {
    public static NumericDocValues replaceMissing(NumericDocValues values, BigInteger missing) {
     */
            }
        return toString(new ToStringValues() {
        public int docValueCount() {
            final NumericDoubleValues doubles;
     * Return a {@link String} representation of the provided values. That is
        });
        return new SortedBinaryDocValues() {
        } else {
     */
     */
    public static MultiGeoPointValues singleton(GeoPointValues values) {
    /**
    public static SortedBinaryDocValues singleton(BinaryDocValues values) {
            return ((SingletonSortedNumericDoubleValues) values).getNumericDoubleValues();
     */
            public boolean advanceExact(int doc) throws IOException {
        public long longValue() throws IOException {
        @Override
                }
            docID = target;
        }
    }
                doubles = ((SortableLongBitsNumericDocValues) singleton).getDoubleValues();
        if (singleton != null) {
     * Return a {@link String} representation of the provided values treating them as unsigned. That is
import org.apache.lucene.index.SortedSetDocValues;
                return values.docID();
     * {@link Numbers#toUnsignedBigInteger(long)}.
                } else {
            }
            public boolean advanceExact(int doc) throws IOException {
/*
        return new AbstractNumericDocValues() {
            return singleton(doubles);
    public static SortedBinaryDocValues toString(final MultiGeoPointValues values) {
            public boolean advanceExact(int doc) throws IOException {
        return new NumericDoubleValues() {
                if (values.advanceExact(target)) {
            @Override
        return new DocValueBits() {
                return values.advanceExact(doc);
        return toString(new ToStringValues() {
     * Returns a multi-valued view over the provided {@link NumericDoubleValues}.
    }
         * @return true if there is a value for this document
                return pointValues.advanceExact(doc);
        private final NumericDocValues values;
                return false;
            @Override
     * Returns a {@link DocValueBits} representing all documents from <code>values</code> that have a value.
    public static DocValueBits docsWithValue(final SortedBinaryDocValues values) {
     * NOTE: this is very slow!
            @Override
    /**
     * if it was previously wrapped with {@link DocValues#singleton(NumericDocValues)},
     * typically used for scripts or for the `map` execution mode of terms aggs.
            return values.advance(target);
                if (values.advanceExact(target)) {
                return new SortableLongBitsToSortedNumericDoubleValues(values);
                } else {
                return value;
        }
     * NOTE: this is very slow!
        }
public enum FieldData {
        };
    private static class LongCastedValues extends AbstractNumericDocValues {
     * if it was previously wrapped with {@link #singleton(GeoPointValues)},
    }
            @Override
    }
     * NOTE: this is very slow!
        };
            @Override
            return values.longValue();
            final NumericDocValues longBits;
                return values.advanceExact(doc);
                }
            public int docValueCount() {
     */
     * @opensearch.internal
        return new DocValueBits() {
     */
     * Return a {@link String} representation of the provided values. That is
            final NumericDoubleValues doubles;
        SortedLongCastedValues(SortedNumericDoubleValues in) {
            public boolean advanceExact(int target) throws IOException {
            }
    /**
        }
     */
    }
            return values.advance(target);
            @Override
             * @return true if there is a value for this document
        private final SortedNumericDocValues values;
            public int advance(int target) throws IOException {
             * Advance this instance to the given document id
    public static DocValueBits docsWithValue(final MultiGeoPointValues pointValues) {
     */
        if (values instanceof SingletonSortedNumericDoubleValues) {
            if (values instanceof SortableLongBitsSortedNumericDocValues) {
     * that have a value.
            public boolean advanceExact(int docID) throws IOException {
 * GitHub history for details.
        }
     * @opensearch.internal
    private static class DoubleCastedValues extends NumericDoubleValues {
            @Override
    public static DocValueBits docsWithValue(final GeoShapeValue shapeValues) {
        }
                return shapeValues.advanceExact(doc);
    public static DocValueBits docsWithValue(final SortedNumericDocValues docValues) {
            }
import org.apache.lucene.search.DocIdSetIterator;
     * Returns a {@link DocValueBits} representing all documents from <code>pointValues</code> that have
                return ((SortableLongBitsSortedNumericDocValues) values).getDoubleValues();
 *
        @Override
        };
     *
     */
        });
     */
    }
            }
        public double doubleValue() throws IOException {
        });
     */
    }
            public int advance(int target) throws IOException {
            }
            @Override
    }
    }
            }
 * the Apache License, Version 2.0 (the "License"); you may
                return values.docID();
            @Override
    }
            public double doubleValue() throws IOException {
        public boolean advanceExact(int doc) throws IOException {
     * NOTE: this is very slow!
            public long longValue() throws IOException {
        return DocValues.unwrapSingleton(values) == null;
        public double nextValue() throws IOException {
            }
    /**
            }
            public void get(List<CharSequence> list) throws IOException {
                if (values.advanceExact(doc) == false) {
            }
            public boolean advanceExact(int doc) throws IOException {
                }
            @Override
        return new SingletonSortedBinaryDocValues(values);
 */
        return new DocValueBits() {
            return values.advanceExact(doc);
    }
        return toString(new ToStringValues() {
        }
import java.math.BigInteger;
                return value.longValue();
        public boolean advanceExact(int target) throws IOException {
        }
            }
            }
        };
                    list.add(values.nextValue().toString());
        };
        } else {
                throw new UnsupportedOperationException();
                return true;
            public boolean advanceExact(int target) throws IOException {
     * @opensearch.internal
     * {@link SortedNumericDocValues} instance that will translate double values
     */
            public void get(List<CharSequence> list) throws IOException {
            @Override
            @Override
            @Override
 */
            /** Fill the list of charsequences with the list of values for the current document. */
    public static NumericDoubleValues unwrapSingleton(SortedNumericDoubleValues values) {
            private BigInteger value;
     */
        }
     * Values casted as a long type
     *
    /**
     * @opensearch.internal
/*
     */
            return values.nextValue();
            @Override
        LongCastedValues(NumericDoubleValues values) {
                return true;
    /**
    /**
                    values[i].copyChars(s);
        @Override
                doubles = ((SortableLongBitsNumericDocValues) singleton).getDoubleValues();
            final List<CharSequence> list = new ArrayList<>();
 * The OpenSearch Contributors require contributions made to
            return ((SingletonSortedBinaryDocValues) values).getBinaryDocValues();
     * Returns whether the provided values *might* be multi-valued. There is no
     */
    }
        if (singleton != null) {
import org.apache.lucene.index.DocValues;
                }
