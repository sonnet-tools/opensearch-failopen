            }
            @Override
                    return values.lookupOrd(ord);
                if (values.advanceExact(doc)) {
                return replaceMissing(values, missing);
                    return missing;
            }
    }
            public String toString() {
            @Override
            }
 */
        }
            }
import org.opensearch.common.geo.GeoPoint;
                hasOrds = values.advanceExact(doc);
    }
    static SortedSetDocValues replaceMissing(final SortedSetDocValues values, final BytesRef missing) throws IOException {
            public BytesRef lookupOrd(long ord) throws IOException {
        }
                return isFloatingPoint;
            public String toString() {
            }
                    return values.lookupOrd(ord - 1);
            }
                return true;
            public int docValueCount() {
            public long getValueCount() {
            @Override
            public int docValueCount() {
            public BytesRef lookupOrd(long ord) throws IOException {
    static SortedNumericDoubleValues replaceMissing(final SortedNumericDoubleValues values, final double missing) {
            final long insertedSegmentOrd = -1L - missingSegmentOrd;
                // If we don't have ordinals, then we just have the missing value
    }
            }
            public long getValueCount() {
                // always return true because we want to return a value even if
                return true;
        };
import org.opensearch.geometry.Geometry;
                return "anon ValuesSource.Bytes of [" + super.toString() + "]";
            @Override
            public String toString() {
            public boolean advanceExact(int doc) throws IOException {
    public static ValuesSource.Bytes replaceMissing(final ValuesSource.Bytes valuesSource, final BytesRef missing) {
        return new ValuesSource.GeoShape() {
            public int docValueCount() {
            @Override
            }
            public SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException {
            private int count;
            @Override
            public String toString() {
                return true;
                    // NO_MORE_DOCS so on the next call we indicate there are no
                return 1 + values.getValueCount();
                return new GeoShapeValue.MissingGeoShapeValue(currentValueSourceValue, missing);
        } else {
        if (missingOrd >= 0) {
     * @param missing Value to be returned if doc doesn't contain the data for the field.
                } else if (ord > insertedOrd) {
 * @opensearch.internal
                SortedSetDocValues values = valuesSource.ordinalsValues(context);
                return true;
    static SortedSetDocValues insertOrd(final SortedSetDocValues values, final long insertedOrd, final BytesRef missingValue) {
            public LongUnaryOperator globalOrdinalsMapping(LeafReaderContext context) throws IOException {
            }
                } else if (insertedSegmentOrd > segmentOrd) {
                return "anon SortedNumericDoubleValues of [" + super.toString() + "]";
    static SortedNumericDocValues replaceMissing(final SortedNumericDocValues values, final long missing) {
                    // NO_MORE_DOCS so on the next call we indicate there are no
            }
            public boolean isBigInteger() {
package org.opensearch.search.aggregations.support;
                // the document does not have a value
                return count == 0 ? 1 : count;
            }
        };
 *
            private long nextMissingOrd;
 * specific language governing permissions and limitations
            }
                // the document does not have a value
                if (ord < insertedOrd) {
                return count == 0 ? 1 : count;
            public SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException {
                // always return true because we want to return a value even if
                } else {
                SortedBinaryDocValues values = valuesSource.bytesValues(context);
            @Override
            }
        SortedSetDocValues globalValues,
                // always return true because we want to return a value even if
                    final long ord = values.nextOrd();
import org.opensearch.index.fielddata.SortedBinaryDocValues;
                );
     * value for the field.
            }
        } else if (missingGlobalOrd >= 0) {
                if (insertedSegmentOrd == segmentOrd) {
import org.opensearch.index.fielddata.AbstractSortedSetDocValues;
            }
import org.apache.lucene.index.LeafReaderContext;
            public long nextOrd() throws IOException {
            @Override
            }
            @Override
    ) throws IOException {
                }
                } else if (insertedSegmentOrd > segmentOrd) {
            public double nextValue() throws IOException {
            final long insertedGlobalOrd = missingGlobalOrd;
                // always return true because we want to return a value even if
            @Override
        };
                return replaceMissing(valuesSource.bytesValues(context), new BytesRef(missing.toString()));
                    count = 0;
                    return values.nextValue();
                // always return true because we want to return a value even if
        final long missingOrd = values.lookupTerm(missing);
            return replaceMissingOrd(values, missingOrd);
            @Override
                } else {
                return "anon MultiGeoPointValues of [" + super.toString() + "]";
                    return insertedGlobalOrd;
            @Override
                if (values.advanceExact(doc)) {
            @Override
        };
        return new MultiGeoPointValues() {
                } else {
            public String getIndexFieldName() {
            public String toString() {
    public static ValuesSource.Bytes replaceMissing(final ValuesSource.Bytes.WithOrdinals valuesSource, final BytesRef missing) {
                }
    public static ValuesSource.GeoShape replaceMissing(final ValuesSource.GeoShape valuesSource, final Geometry missing) {
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
                    return ordToReturn;
/**
            @Override
                    count = values.docValueCount();
                        return ord + 1;
                    valuesSource.globalOrdinalsMapping(context),
    }
}
 * You may obtain a copy of the License at
        final boolean isBigInteger = valuesSource.isBigInteger() && !isFloatingPoint;
            public boolean isFloatingPoint() {
            }
            @Override
    static SortedSetDocValues replaceMissingOrd(final SortedSetDocValues values, final long missingOrd) {
                return values.advance(target);
        return new ValuesSource.GeoPoint() {
 *    http://www.apache.org/licenses/LICENSE-2.0
                return hasOrds ? values.docValueCount() : 1;
            public String toString() {
 *
                // the document does not have a value
     */
            public int advance(int target) throws IOException {
            final long insertedSegmentOrd = -1L - missingSegmentOrd;
                }
            }
    public static SortedBinaryDocValues replaceMissing(final SortedBinaryDocValues values, final BytesRef missing) {
import org.apache.lucene.index.SortedNumericDocValues;
            }
                hasOrds = values.advanceExact(doc);
            @Override
            }
        final long missingSegmentOrd = values.lookupTerm(missing);
                final MultiGeoPointValues values = valuesSource.geoPointValues(context);
    /**
            @Override
                } else {
                    valuesSource.ordinalsValues(context),
                    return missing;
            return segmentOrd -> {
     * @return {@link ValuesSource.GeoShape}
            public SortedSetDocValues globalOrdinalsValues(LeafReaderContext context) throws IOException {
                return valuesSource.getIndexFieldName();
            }
        SortedSetDocValues values,
        };
                    }
            @Override
                // the document does not have a value
                    return values.nextValue();
            private long nextMissingOrd;
                    long ordToReturn = nextMissingOrd;
            }
                    // more values
                if (insertedSegmentOrd == segmentOrd) {
 * this file be licensed under the Apache-2.0 license or a
            // the missing value exists in another segment, but not the current one
                return values.getValueCount();
                }
                    count = values.docValueCount();
                return "anon AbstractSortedDocValues of [" + super.toString() + "]";
 * ownership. Elasticsearch licenses this file to you under
    }
            }
            public SortedNumericDoubleValues doubleValues(LeafReaderContext context) throws IOException {
            @Override
 * The OpenSearch Contributors require contributions made to
        final long missingGlobalOrd = globalValues.lookupTerm(missing);
            }
            private int count;
                    valuesSource.globalOrdinalsValues(context),
            public long nextOrd() throws IOException {
                final SortedNumericDocValues values = valuesSource.longValues(context);
                // If we don't have ordinals, then we just have the missing value
            public String toString() {
                    // we want to return the next missing ord but set this to
                return replaceMissing(values, missing);
            @Override
            @Override
                    return missing;
            public boolean advanceExact(int doc) throws IOException {
        return new AbstractSortedNumericDocValues() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            public SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException {
/*
                return "anon AbstractSortedDocValues of [" + super.toString() + "]";
            final long insertedOrd = -1 - missingOrd;
/*
        return new AbstractSortedSetDocValues() {
        LongUnaryOperator segmentToGlobalOrd,
                    long ordToReturn = nextMissingOrd;
        };
        final boolean missingIsFloat = missing.doubleValue() % 1 != 0;
            return insertOrd(values, insertedOrd, missing);
                if (values.advanceExact(doc)) {
                SortedSetDocValues values = valuesSource.globalOrdinalsValues(context);
            @Override
            @Override
import org.opensearch.index.fielddata.AbstractSortedNumericDocValues;
                    return values.nextOrd();
 * the Apache License, Version 2.0 (the "License"); you may
            @Override
                return "anon ValuesSource.Bytes.WithOrdinals of [" + super.toString() + "]";
            @Override
                    // more values
 * software distributed under the License is distributed on an
                return hasOrds ? values.docValueCount() : 1;
                    return missingValue;
            @Override
    }
                }
                }
/*
                    return segmentToGlobalOrd.applyAsLong(segmentOrd);
            public int docValueCount() {
 */
                final SortedNumericDoubleValues values = valuesSource.doubleValues(context);
            // The value already exists
            }
        return new ValuesSource.Bytes() {
        if (missingSegmentOrd >= 0) {
            @Override
            }
 */
                return count == 0 ? 1 : count;
import java.io.IOException;
            };
            // the missing value exists neither in this segment nor in another segment
            private int count;
            final long insertedGlobalOrd = -1L - missingGlobalOrd;
            }
import org.apache.lucene.util.BytesRef;
                    count = 0;
            @Override
            }
        };
 * Modifications Copyright OpenSearch Contributors. See
                // the document does not have a value
                    return missing;
    }
            }
            public int docValueCount() {
 * under the License.
        };
            private int count;
            };
            }
        final boolean isFloatingPoint = valuesSource.isFloatingPoint() || missingIsFloat;
    static MultiGeoPointValues replaceMissing(final MultiGeoPointValues values, final GeoPoint missing) {
                    if (ord < insertedOrd) {
            public BytesRef nextValue() throws IOException {
    }
            }
            @Override
            }
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
                }
                return "anon ValuesSource.GeoPoint of [" + super.toString() + "]";
import org.opensearch.index.fielddata.MultiGeoPointValues;
                    count = 0;
                }
            }
                return isBigInteger;
            }
 * Utility class that allows to return views of {@link ValuesSource}s that
                return replaceMissing(values, missing);
            @Override
 * KIND, either express or implied.  See the License for the
                return count == 0 ? 1 : count;
                    count = values.docValueCount();
            }
            public SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
            @Override
            public String toString() {
                } else {
        };
                return "anon SortedBinaryDocValues of [" + super.toString() + "]";
            @Override
            public SortedSetDocValues ordinalsValues(LeafReaderContext context) throws IOException {
                    missing
            public String toString() {
        return new SortedNumericDoubleValues() {
                return "anon SortedNumericDocValues of [" + super.toString() + "]";
    public static ValuesSource.GeoPoint replaceMissing(final ValuesSource.GeoPoint valuesSource, final GeoPoint missing) {
import org.apache.lucene.index.SortedSetDocValues;
        };
                } else {
                    } else {
                } else {
                return replaceMissing(values, missing);
            public SortedNumericDocValues longValues(LeafReaderContext context) throws IOException {
                }
                return true;
     *
                if (count > 0) {
                        return SortedSetDocValues.NO_MORE_DOCS;
            }
                // the document does not have a value
 * Licensed to Elasticsearch under one or more contributor
            @Override
                if (count > 0) {
 * replace the missing value with a configured value.
            public int docValueCount() {
        return new ValuesSource.Numeric() {
                    // we want to return the next missing ord but set this to
            // the missing value exists in the segment, nothing to do
            public GeoPoint nextValue() throws IOException {
            public boolean advanceExact(int doc) throws IOException {
     * Replace the missing value provided in the param while iterating over a ValuesSource which doesn't have the
                    return values.nextValue();
 *
            @Override
 *
            @Override
        BytesRef missing
            public MultiGeoPointValues geoPointValues(LeafReaderContext context) {
    }
    ;
                } else {
            @Override
                return "anon ValuesSource.Numeric of [" + super.toString() + "]";
                } else {
                }
                    return segmentToGlobalOrd.applyAsLong(segmentOrd - 1);
                    return values.nextValue();
                if (hasOrds) {
                // always return true because we want to return a value even if
                }
import java.util.function.LongUnaryOperator;
            }
            }
            }
                return replaceMissing(values, missing.longValue());
            @Override
            public String toString() {
                }
                if (hasOrds) {
            }
            @Override
 * not use this file except in compliance with the License.
                    nextMissingOrd = SortedSetDocValues.NO_MORE_DOCS;
            public SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException {
    }
            @Override
    }
public enum MissingValues {
    }
                return true;
            @Override
                return replaceMissing(valuesSource.bytesValues(context), new BytesRef(missing.toString()));
 * Unless required by applicable law or agreed to in writing,
                if (count > 0) {
            public boolean advanceExact(int doc) throws IOException {
    }
            @Override
                    return ordToReturn;
                SortedBinaryDocValues values = valuesSource.bytesValues(context);
            @Override
 * this work for additional information regarding copyright
            }
            }
                    nextMissingOrd = SortedSetDocValues.NO_MORE_DOCS;
                } else {
                return replaceMissing(valuesSource.bytesValues(context), new BytesRef(missing.toString()));
                } else {
                } else {
                }
                    return segmentToGlobalOrd.applyAsLong(segmentOrd);
            }
            @Override
                    } else if (ord == SortedSetDocValues.NO_MORE_DOCS /* no more docs */) {
        return new AbstractSortedSetDocValues() {
            @Override
            public boolean advanceExact(int doc) throws IOException {
                } else {
        } else {
                        return ord;
            private boolean hasOrds;
                return replaceMissing(values, missing.doubleValue());
                final GeoShapeValue currentValueSourceValue = valuesSource.getGeoShapeValues(context);
                return replaceMissing(values, missing);
        return new ValuesSource.Bytes.WithOrdinals() {
            private boolean hasOrds;
            }
            public long nextValue() throws IOException {
                nextMissingOrd = insertedOrd;
            return segmentToGlobalOrd;
                if (count > 0) {
                if (values.advanceExact(doc)) {
                    return insertedGlobalOrd;
        };
    public static ValuesSource.Numeric replaceMissing(final ValuesSource.Numeric valuesSource, final Number missing) {
            public boolean advanceExact(int doc) throws IOException {
            public GeoShapeValue getGeoShapeValues(LeafReaderContext context) {
                nextMissingOrd = missingOrd;
    static LongUnaryOperator getGlobalMapping(
                return getGlobalMapping(
 * compatible open source license.
        return new SortedBinaryDocValues() {
 */
            }
            @Override
            return segmentOrd -> {
            }
                    count = values.docValueCount();
            @Override
import org.opensearch.index.fielddata.GeoShapeValue;
            @Override
            }
                return values.lookupOrd(ord);
                    return 1 + segmentToGlobalOrd.applyAsLong(segmentOrd - 1);
    // TODO: we could specialize the single value case
            @Override
                    count = 0;
            }
