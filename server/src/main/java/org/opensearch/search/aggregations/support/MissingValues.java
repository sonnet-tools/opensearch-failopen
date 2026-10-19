                return replaceMissing(values, missing);
                    } else {
            @Override
            @Override
            @Override
            public boolean advanceExact(int doc) throws IOException {
            private int count;
                return replaceMissing(values, missing);
            @Override
            public String toString() {
            }
                    return values.lookupOrd(ord - 1);  
            return segmentOrd -> {
 * Modifications Copyright OpenSearch Contributors. See
            @Override
                return values.getValueCount();  
            }
                return replaceMissing(valuesSource.bytesValues(context), new BytesRef(missing.toString()));  
     * Replace the missing value provided in the param while iterating over a ValuesSource which doesn't have the
        };
 * replace the missing value with a configured value.
                return replaceMissing(values, missing);  
                    return missingValue;
                return values.lookupOrd(ord);
                } else {
    public static ValuesSource.GeoPoint replaceMissing(final ValuesSource.GeoPoint valuesSource, final GeoPoint missing) {
            public BytesRef lookupOrd(long ord) throws IOException {
            }  
            public String toString() {
            public boolean advanceExact(int doc) throws IOException {  
                        return ord + 1;
                } else {  
            private int count;
            @Override
                }  
            public SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException {  
            final long insertedSegmentOrd = -1L - missingSegmentOrd;
                return count == 0 ? 1 : count;
            @Override
                SortedSetDocValues values = valuesSource.ordinalsValues(context);  
                return replaceMissing(values, missing.doubleValue());  
    }
            public String toString() {  
                }
            }  
                return 1 + values.getValueCount();
            }
}
    /**
            @Override
            @Override
            }
            public BytesRef nextValue() throws IOException {  
            }
 * license agreements. See the NOTICE file distributed with
                    // NO_MORE_DOCS so on the next call we indicate there are no  
                    return values.nextValue();  
                    return missing;
                    nextMissingOrd = SortedSetDocValues.NO_MORE_DOCS;  
                return hasOrds ? values.docValueCount() : 1;
            @Override
        final boolean isBigInteger = valuesSource.isBigInteger() && !isFloatingPoint;  
                    return ordToReturn;
 * KIND, either express or implied.  See the License for the
                SortedSetDocValues values = valuesSource.globalOrdinalsValues(context);  
                    final long ord = values.nextOrd();
            public LongUnaryOperator globalOrdinalsMapping(LeafReaderContext context) throws IOException {
    public static ValuesSource.Bytes replaceMissing(final ValuesSource.Bytes.WithOrdinals valuesSource, final BytesRef missing) {
                return count == 0 ? 1 : count;
                return replaceMissing(valuesSource.bytesValues(context), new BytesRef(missing.toString()));  
                    } else if (ord == SortedSetDocValues.NO_MORE_DOCS /* no more docs */) {
    ;  
 *
                    return values.nextValue();
        return new MultiGeoPointValues() {  
    ) throws IOException {
                nextMissingOrd = insertedOrd;
                return true;
import java.io.IOException;
 */
            public long nextOrd() throws IOException {  
        return new AbstractSortedSetDocValues() {  
        final long missingGlobalOrd = globalValues.lookupTerm(missing);  
                }  
        if (missingOrd >= 0) {
            @Override
            public int docValueCount() {
    }
            // the missing value exists in the segment, nothing to do
            @Override
            @Override
            @Override  
import java.util.function.LongUnaryOperator;  
                } else if (insertedSegmentOrd > segmentOrd) {
            }
                    // we want to return the next missing ord but set this to
        } else {
                }
            return insertOrd(values, insertedOrd, missing);
                    count = 0;  
        };
 * software distributed under the License is distributed on an
            // the missing value exists in another segment, but not the current one
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
            }
                    }  
                } else {
                return count == 0 ? 1 : count;  
                if (count > 0) {
            }
            public int advance(int target) throws IOException {
            public String toString() {  
                if (insertedSegmentOrd == segmentOrd) {  
    }
 * not use this file except in compliance with the License.
            @Override
            }
            public boolean advanceExact(int doc) throws IOException {  
                    // more values
                final GeoShapeValue currentValueSourceValue = valuesSource.getGeoShapeValues(context);  
            return segmentToGlobalOrd;
 *
            }  
            public int docValueCount() {
                } else {
            public SortedSetDocValues ordinalsValues(LeafReaderContext context) throws IOException {
            }  
/*  
                }  
                } else {  
                    return values.lookupOrd(ord);
            }
import org.opensearch.index.fielddata.AbstractSortedSetDocValues;
            }
            }
        return new ValuesSource.Bytes.WithOrdinals() {  
            return replaceMissingOrd(values, missingOrd);
        };  
                final MultiGeoPointValues values = valuesSource.geoPointValues(context);  
                // the document does not have a value
                return replaceMissing(values, missing.longValue());  
                if (hasOrds) {
                }  
 * specific language governing permissions and limitations
        BytesRef missing
                // always return true because we want to return a value even if  
                // If we don't have ordinals, then we just have the missing value
                nextMissingOrd = missingOrd;
                    valuesSource.ordinalsValues(context),
                    return values.nextValue();  
 */
                // always return true because we want to return a value even if
    static SortedSetDocValues replaceMissing(final SortedSetDocValues values, final BytesRef missing) throws IOException {  
                }
            private int count;
            return segmentOrd -> {
     * @return {@link ValuesSource.GeoShape}  
            @Override
                return true;  
    }  
            @Override  
    }
        return new ValuesSource.Bytes() {
 * this work for additional information regarding copyright
    }
/*  
 * @opensearch.internal  
            }
            public SortedNumericDoubleValues doubleValues(LeafReaderContext context) throws IOException {
                } else {
            @Override
        };
            public long nextValue() throws IOException {
                // the document does not have a value
     */
            @Override  
                    valuesSource.globalOrdinalsMapping(context),  
    static LongUnaryOperator getGlobalMapping(  
                    // we want to return the next missing ord but set this to
            public GeoShapeValue getGeoShapeValues(LeafReaderContext context) {
                }  
            public SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException {
            }
            @Override
 *
            }
                return "anon AbstractSortedDocValues of [" + super.toString() + "]";
                    return segmentToGlobalOrd.applyAsLong(segmentOrd);
                } else if (ord > insertedOrd) {
                // always return true because we want to return a value even if
    public static ValuesSource.Bytes replaceMissing(final ValuesSource.Bytes valuesSource, final BytesRef missing) {
            }
 * this file be licensed under the Apache-2.0 license or a
 * Utility class that allows to return views of {@link ValuesSource}s that  
                    count = 0;
                if (count > 0) {
    static SortedSetDocValues insertOrd(final SortedSetDocValues values, final long insertedOrd, final BytesRef missingValue) {
                    count = values.docValueCount();  
                return replaceMissing(values, missing);
                return true;  
                    return insertedGlobalOrd;  
            }
            // the missing value exists neither in this segment nor in another segment
        if (missingSegmentOrd >= 0) {  
            public boolean isBigInteger() {  
            public long getValueCount() {
            @Override
            }
                return "anon AbstractSortedDocValues of [" + super.toString() + "]";
                if (values.advanceExact(doc)) {
                } else {
public enum MissingValues {
                    count = values.docValueCount();
                } else {
        };
    }
        final boolean missingIsFloat = missing.doubleValue() % 1 != 0;
                return "anon ValuesSource.GeoPoint of [" + super.toString() + "]";  
            }  
            private long nextMissingOrd;  
                return isFloatingPoint;
            }
 * ownership. Elasticsearch licenses this file to you under  
                return true;
        return new SortedBinaryDocValues() {
            }  
            }
    static SortedNumericDoubleValues replaceMissing(final SortedNumericDoubleValues values, final double missing) {
 * compatible open source license.
            public boolean advanceExact(int doc) throws IOException {
            @Override  
            public String toString() {  
        SortedSetDocValues values,
    static SortedNumericDocValues replaceMissing(final SortedNumericDocValues values, final long missing) {
import org.opensearch.index.fielddata.MultiGeoPointValues;
                    count = values.docValueCount();
            private long nextMissingOrd;
            public double nextValue() throws IOException {
package org.opensearch.search.aggregations.support;
            }
            };
            }  
import org.opensearch.index.fielddata.GeoShapeValue;  
            }
                    count = 0;
                );
            @Override
            public int docValueCount() {  
 *  
        return new ValuesSource.GeoShape() {  
            }  
            @Override  
        return new AbstractSortedSetDocValues() {
    }  
            }
                    if (ord < insertedOrd) {  
                hasOrds = values.advanceExact(doc);
 * under the License.  
        };
                    missing
/*
                    return missing;
            }  
    }  
        };  
            @Override  
 * The OpenSearch Contributors require contributions made to  
                return values.advance(target);  
                SortedBinaryDocValues values = valuesSource.bytesValues(context);  
            // The value already exists  
 * the Apache License, Version 2.0 (the "License"); you may
            public SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException {
            public String toString() {  
            public GeoPoint nextValue() throws IOException {
        } else {
            public SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException {
            @Override
                return isBigInteger;
                if (ord < insertedOrd) {  
                if (values.advanceExact(doc)) {
            public long nextOrd() throws IOException {
        final long missingOrd = values.lookupTerm(missing);
                // the document does not have a value  
            @Override
                // always return true because we want to return a value even if  
            @Override  
 * GitHub history for details.
        final long missingSegmentOrd = values.lookupTerm(missing);
            @Override  
                    // NO_MORE_DOCS so on the next call we indicate there are no  
        final boolean isFloatingPoint = valuesSource.isFloatingPoint() || missingIsFloat;
            }
                } else {  
                // always return true because we want to return a value even if  
                return "anon SortedNumericDoubleValues of [" + super.toString() + "]";
                return "anon ValuesSource.Bytes.WithOrdinals of [" + super.toString() + "]";
import org.apache.lucene.util.BytesRef;
                if (insertedSegmentOrd == segmentOrd) {
            public String getIndexFieldName() {
        }
import org.opensearch.index.fielddata.AbstractSortedNumericDocValues;
            @Override
                if (count > 0) {
        };
            public SortedSetDocValues globalOrdinalsValues(LeafReaderContext context) throws IOException {
            public String toString() {  
import org.opensearch.geometry.Geometry;  
            final long insertedGlobalOrd = missingGlobalOrd;  
                return getGlobalMapping(  
    public static SortedBinaryDocValues replaceMissing(final SortedBinaryDocValues values, final BytesRef missing) {
     * @param missing Value to be returned if doc doesn't contain the data for the field.
        return new AbstractSortedNumericDocValues() {
                    return 1 + segmentToGlobalOrd.applyAsLong(segmentOrd - 1);
                } else {
                }
 */  
            public BytesRef lookupOrd(long ord) throws IOException {  
            }
    static MultiGeoPointValues replaceMissing(final MultiGeoPointValues values, final GeoPoint missing) {
            };  
import org.apache.lucene.index.SortedSetDocValues;  
            }  
            public int docValueCount() {
            public String toString() {
            @Override
            }
     * value for the field.  
            @Override  
    }  
            @Override  
            @Override  
        } else if (missingGlobalOrd >= 0) {  
        };
    }  
            @Override  
        }
import org.apache.lucene.index.LeafReaderContext;
 * Unless required by applicable law or agreed to in writing,
                // If we don't have ordinals, then we just have the missing value
                if (hasOrds) {
                return "anon ValuesSource.Bytes of [" + super.toString() + "]";
                    count = values.docValueCount();  
            public SortedNumericDocValues longValues(LeafReaderContext context) throws IOException {
                return count == 0 ? 1 : count;
                    return missing;
            @Override  
                SortedBinaryDocValues values = valuesSource.bytesValues(context);
                // always return true because we want to return a value even if
                        return ord;
                    long ordToReturn = nextMissingOrd;
            }  
                return "anon SortedNumericDocValues of [" + super.toString() + "]";
import org.opensearch.common.geo.GeoPoint;
            private int count;
            @Override  
            public int docValueCount() {  
            }  
                // the document does not have a value
                // the document does not have a value
 *    http://www.apache.org/licenses/LICENSE-2.0
                    count = 0;
        SortedSetDocValues globalValues,
                return true;
            public int docValueCount() {
        };
                return new GeoShapeValue.MissingGeoShapeValue(currentValueSourceValue, missing);
            final long insertedSegmentOrd = -1L - missingSegmentOrd;  
                if (count > 0) {
                }  
            private boolean hasOrds;
                    nextMissingOrd = SortedSetDocValues.NO_MORE_DOCS;  
            }
                    long ordToReturn = nextMissingOrd;
                return true;
            }  
                if (values.advanceExact(doc)) {  
            @Override
                    return values.nextValue();  
            public boolean advanceExact(int doc) throws IOException {  
            public boolean isFloatingPoint() {
    }
                } else {
/**
                return "anon SortedBinaryDocValues of [" + super.toString() + "]";
            }
                return valuesSource.getIndexFieldName();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
            @Override
            @Override
                return replaceMissing(values, missing);
            @Override
                    // more values
            public String toString() {
            public MultiGeoPointValues geoPointValues(LeafReaderContext context) {
                }
            }  
                return "anon MultiGeoPointValues of [" + super.toString() + "]";
            private boolean hasOrds;
                    return segmentToGlobalOrd.applyAsLong(segmentOrd);  
            @Override
                } else if (insertedSegmentOrd > segmentOrd) {
                    valuesSource.globalOrdinalsValues(context),
import org.apache.lucene.index.SortedNumericDocValues;
            @Override  
            @Override  
 */  
        LongUnaryOperator segmentToGlobalOrd,  
            @Override  
        return new SortedNumericDoubleValues() {
            }  
                return replaceMissing(valuesSource.bytesValues(context), new BytesRef(missing.toString()));
                    return insertedGlobalOrd;
            final long insertedOrd = -1 - missingOrd;  
    static SortedSetDocValues replaceMissingOrd(final SortedSetDocValues values, final long missingOrd) {
                final SortedNumericDoubleValues values = valuesSource.doubleValues(context);
            }
                if (values.advanceExact(doc)) {
            }  
     *
            @Override
                        return SortedSetDocValues.NO_MORE_DOCS;  
                } else {
import org.opensearch.index.fielddata.SortedBinaryDocValues;
        return new ValuesSource.Numeric() {
                }  
                    return segmentToGlobalOrd.applyAsLong(segmentOrd - 1);
            @Override
            }
                }
                hasOrds = values.advanceExact(doc);
                } else {
        };  
                return hasOrds ? values.docValueCount() : 1;
import org.opensearch.index.fielddata.SortedNumericDoubleValues;  
            public boolean advanceExact(int doc) throws IOException {
            @Override
                    return values.nextOrd();  
            public String toString() {  
 * SPDX-License-Identifier: Apache-2.0
                    return missing;
    public static ValuesSource.GeoShape replaceMissing(final ValuesSource.GeoShape valuesSource, final Geometry missing) {
                    return ordToReturn;
            public SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException {
            final long insertedGlobalOrd = -1L - missingGlobalOrd;
                final SortedNumericDocValues values = valuesSource.longValues(context);
            public long getValueCount() {
                return "anon ValuesSource.Numeric of [" + super.toString() + "]";
    // TODO: we could specialize the single value case
            }  
        return new ValuesSource.GeoPoint() {  
    }
    public static ValuesSource.Numeric replaceMissing(final ValuesSource.Numeric valuesSource, final Number missing) {  
                // the document does not have a value
