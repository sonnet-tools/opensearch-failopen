    }
                return true;  
        }  
                public int advance(int target) throws IOException {
 * ownership. Elasticsearch licenses this file to you under  
                    }
         * Field data for geo shape values source
     *  
                public SortedBinaryDocValues bytesValues(LeafReaderContext context) {  
                return scriptValueType != null ? scriptValueType == ValueType.DOUBLE : true;
    }
    }  
                            values[i] = script.runAsDouble();
     */  
    /**
         * @return {@link GeoShapeValue}  
            static class LongValues extends AbstractSortingNumericDocValues implements ScorerAware {
     *
 *
            /**
 */
        /**
            protected final IndexGeoPointFieldData indexFieldData;
        public abstract SortedNumericDocValues longValues(LeafReaderContext context) throws IOException;
            }  
import org.apache.lucene.index.IndexReader;
            private final ValueType scriptValueType;
 * compatible open source license.
                        }  
        /**
        @Override
 * the Apache License, Version 2.0 (the "License"); you may
            return org.opensearch.index.fielddata.FieldData.docsWithValue(geoPoints);  
            @Override
            public boolean isFloatingPoint() {
            public boolean isFloatingPoint() {
            public SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException {  
         * @opensearch.internal  
                    return segmentToGlobalOrd::get;
            }  
        public DocValueBits docsWithValue(LeafReaderContext context) throws IOException {
    /**
            public boolean needsScores() {
        }  
            /**
                        return LongUnaryOperator.identity();
            public abstract SortedSetDocValues ordinalsValues(LeafReaderContext context) throws IOException;  
                @Override
            }
            /**
                if (indexReader.leaves().isEmpty()) {
                return org.opensearch.index.fielddata.FieldData.docsWithValue(values);
            }
            }  
                }
             * Long values source type  
        public final Function<Rounding, Rounding.Prepared> roundingPreparer(IndexReader reader) throws IOException {
                    script.setScorer(scorer);
                }
            return org.opensearch.index.fielddata.FieldData.docsWithValue(bytes);  
             * {@link #globalOrdinalsMapping} will result in an {@link UnsupportedOperationException}.
                return org.opensearch.index.fielddata.FieldData.emptySortedNumericDoubles();  
            public static class FieldData extends WithOrdinals {
        return null;
            this.rangeType = rangeType;
            protected final AbstractGeoShapeIndexFieldData indexFieldData;
            /**
        public DocValueBits docsWithValue(LeafReaderContext context) throws IOException {
        /**
                return new ScriptDoubleValues(script.newInstance(context));
        @Override  
                public boolean advanceExact(int target) throws IOException {
         */
                return new BytesValues(delegate.bytesValues(context), script.newInstance(context));
import org.opensearch.index.fielddata.IndexFieldData;  
import java.io.IOException;
                    return values.getValueCount();
                final SortedSetDocValues ordinals = ordinalsValues(context);
import org.opensearch.index.fielddata.plain.AbstractGeoShapeIndexFieldData;
        }
         *  
            }  
            public FieldData(IndexFieldData<?> indexFieldData) {
                public void setScorer(Scorable scorer) {
                return indexFieldData.getFieldName();  
                }
                }  
            public String getIndexFieldName() {
             * Whether this values source is able to provide a mapping between global and segment ordinals,
            }  
         */
        public abstract GeoShapeValue getGeoShapeValues(LeafReaderContext context);
                    if (longValues.advanceExact(target)) {  
            }  
             */  
         * @opensearch.internal
    public static class Range extends ValuesSource {
public abstract class ValuesSource {  
            @Override  
            public DocValueBits docsWithValue(LeafReaderContext context) throws IOException {
            /**  
        public static class FieldData extends Numeric {
            private final ValuesSource delegate;
    public abstract DocValueBits docsWithValue(LeafReaderContext context) throws IOException;
        @Override
            public SortedBinaryDocValues bytesValues(LeafReaderContext context) {  
        /**  
            @Override  
 * Unless required by applicable law or agreed to in writing,
                public LongUnaryOperator globalOrdinalsMapping(LeafReaderContext context) throws IOException {  
                return org.opensearch.index.fielddata.FieldData.emptyGeoShape();
            /**
            public SortedNumericDocValues longValues(LeafReaderContext context) {  
            }
/*
        }
import java.util.function.LongUnaryOperator;
import org.apache.lucene.index.DocValues;
                return org.opensearch.index.fielddata.FieldData.emptySortedBinary();
         *
        public static final GeoShape EMPTY = new GeoShape() {
            }
                }
             *
             * @return {@link GeoShapeValue}
                    this.script = script;
                this.delegate = delegate;
 * KIND, either express or implied.  See the License for the
                LongValues(SortedNumericDocValues values, AggregationScript script) {  
                private final SortedBinaryDocValues bytesValues;
        @Override
            /**
    }
        public static final Numeric EMPTY = new Numeric() {
        @Override  
                public LongUnaryOperator globalOrdinalsMapping(LeafReaderContext context) throws IOException {  
                this.script = script;  
            @Override
 * The OpenSearch Contributors require contributions made to  
                }
        }
             * This provides the {@link GeoShapeValue} after reading from LeafReaderContext
                    }  
                return script.needs_score();
                this.delegate = delegate;
    public boolean hasGlobalOrdinals() {  
                return new ScriptBytesValues(script.newInstance(context));
                }
            if (isFloatingPoint() || isBigInteger()) {  
                        count = 0;
        }
            public String getIndexFieldName() {
        public static class Script extends Numeric {  
@PublicApi(since = "1.0.0")
                @Override
            final SortedBinaryDocValues bytes = bytesValues(context);
                return script.needs_score();
 * license agreements. See the NOTICE file distributed with
            }
                }
                }
        }  
                return indexFieldData.load(context).getGeoPointValues();
        }
                @Override
import org.opensearch.core.common.util.CollectionUtils;
                @Override
                    script.setScorer(scorer);
        public static class FieldData extends Bytes {  
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
            }
            }
             * This provides the {@link GeoShapeValue} after reading from LeafReaderContext
import org.opensearch.common.lucene.ScorerAware;
import org.apache.lucene.index.SortedNumericDocValues;
                public void setScorer(Scorable scorer) {  
    }  
     * @opensearch.internal  
     *
            @Override
            final GeoShapeValue geoShapeValue = getGeoShapeValues(context);  
            }  
        public DocValueBits docsWithValue(LeafReaderContext context) throws IOException {
                            script.setNextAggregationValue(doubleValues.nextValue());
     * Bytes type  
            }
            public SortedNumericDocValues longValues(LeafReaderContext context) throws IOException {
         *
                    return this.indexFieldData.getFieldName();
            }
            private final AggregationScript.LeafFactory script;
 * SPDX-License-Identifier: Apache-2.0
         * Field data for numerics  
import org.opensearch.index.fielddata.SortingBinaryDocValues;  
            }  
            public Script(AggregationScript.LeafFactory script) {
                return indexFieldData.getNumericType().isFloatingPoint();
         * {@link ValuesSource} subclass for Numeric fields with a Value Script applied  
         * @return DocValueBits
         * Provides ordinals for bytes  
        public abstract boolean isBigInteger();
                    final OrdinalMap map = global.getOrdinalMap();
                }
            public boolean isBigInteger() {
    }
            public SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException {  
         */
            this.indexFieldData = indexFieldData;  
        public Function<Rounding, Prepared> roundingPreparer(IndexReader reader) throws IOException {
            public boolean needsScores() {
            @Override
            public WithScript(Numeric delegate, AggregationScript.LeafFactory script) {  
                        return false;  
            }
import org.opensearch.search.aggregations.support.values.ScriptLongValues;  
/**  
            @Override
            public SortedNumericDoubleValues doubleValues(LeafReaderContext context) throws IOException {
            }
                @Override
            public FieldData(AbstractGeoShapeIndexFieldData indexFieldData) {
         * {@link ValuesSource} implementation for stand alone scripts returning a Numeric value
import org.apache.lucene.index.OrdinalMap;
                }  
import org.opensearch.search.aggregations.support.ValuesSource.Bytes.WithScript.BytesValues;  
            @Override
        public Function<Rounding, Prepared> roundingPreparer(IndexReader reader) {
                return indexFieldData.load(context).getDoubleValues();
    }
import org.opensearch.index.fielddata.MultiGeoPointValues;  
import org.apache.lucene.search.IndexSearcher;
        public DocValueBits docsWithValue(LeafReaderContext context) throws IOException {
        }
     */  
        /**
        @Override  
            @Override  
                @Override
        @Override
                            final BytesRef value = bytesValues.nextValue();
        }
                        grow();
                @Override
            }
         * @opensearch.internal
        }  
                        }  
     */
            @Override
                this.indexFieldData = indexFieldData;  
                        count = bytesValues.docValueCount();  
import org.opensearch.search.aggregations.support.values.ScriptBytesValues;
            public abstract SortedSetDocValues globalOrdinalsValues(LeafReaderContext context) throws IOException;
import java.util.function.Function;  
     * Build a function prepares rounding values to be called many times.
         *  
import org.opensearch.index.fielddata.IndexNumericFieldData.NumericType;  
                private final AggregationScript script;  
            }
            public boolean isFloatingPoint() {
            public GeoShapeValue getGeoShapeValues(LeafReaderContext context) {
             *  
            }
         * @param context {@link LeafReaderContext}
            }
import org.opensearch.search.aggregations.AggregationExecutionException;
                return org.opensearch.index.fielddata.FieldData.emptyMultiGeoPoints();
            @Override
            @Override
             * Get the current {@link BytesValues}.  
            }  
                }  
 * Licensed to Elasticsearch under one or more contributor  
            public org.opensearch.index.fielddata.MultiGeoPointValues geoPointValues(LeafReaderContext context) {
                        return true;
                            script.setNextAggregationValue(longValues.nextValue());
        public Range(IndexFieldData<?> indexFieldData, RangeType rangeType) {
        /** Whether the underlying data is big integer or not. */
                final SortedNumericDocValues values = longValues(context);
                        script.setDocument(target);
            }  
        return false;
                return false; /* always fall back to floating point */  
            }  
                @Override  
                        for (int i = 0; i < docValueCount(); ++i) {  
            @Override  
            public SortedNumericDoubleValues doubleValues(LeafReaderContext context) throws IOException {
        }  
            }
            private final Numeric delegate;  
 */
                return indexFieldData.load(context).getBytesValues();
                    this.script = script;
        public static final GeoPoint EMPTY = new GeoPoint() {
                    final IndexOrdinalsFieldData global = indexFieldData.loadGlobal((DirectoryReader) context.parent.reader());
            }
 * Base class for a ValuesSource; the primitive data for an agg
/*
             * @return SortedBinaryDocValues  
             */  
            public Fielddata(IndexGeoPointFieldData indexFieldData) {
                return org.opensearch.index.fielddata.FieldData.emptySortedBinary();
import org.opensearch.index.fielddata.SortingNumericDoubleValues;
                        resize(doubleValues.docValueCount());
            /**
                return this.indexFieldData.getFieldName();  
                public boolean advanceExact(int doc) throws IOException {
            private final AggregationScript.LeafFactory script;
         */
            /**
                @Override  
            @Override
            return Rounding::prepareForUnknown;  
            }
                    this.longValues = values;
         * {@link ValuesSource} implementation for stand alone scripts returning a Bytes value  
                        sort();
            public boolean isBigInteger() {  
            @Override
                return DocValues.emptySortedNumeric();
                return script.needs_score();  
                this.indexFieldData = indexFieldData;
         */  
                public SortedSetDocValues ordinalsValues(LeafReaderContext context) {  
                    return false;
             */
            public boolean isBigInteger() {
                    this.doubleValues = values;
                }
     * need to call it many times over the course of running the aggregation.
        }
            protected final IndexFieldData<?> indexFieldData;
        }  
                public SortedSetDocValues globalOrdinalsValues(LeafReaderContext context) {
                }  
            @Override
                    if (doubleValues.advanceExact(target)) {  
     * @opensearch.internal
 *    http://www.apache.org/licenses/LICENSE-2.0
    public abstract Function<Rounding, Rounding.Prepared> roundingPreparer(IndexReader reader) throws IOException;  
     *
                public SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException {
            public boolean supportsGlobalOrdinalsMapping() {  
             * @return {@link GeoShapeValue}
        return false;  
                        script.setDocument(target);
         */
                BytesValues(SortedBinaryDocValues bytesValues, AggregationScript script) {
                private final SortedNumericDoubleValues doubleValues;  
                DoubleValues(SortedNumericDoubleValues values, AggregationScript script) {  
            }
            throw new AggregationExecutionException("can't round a [BYTES]");
                @Override  
            return rangeType;
                private final SortedNumericDocValues longValues;  
        public static class WithScript extends Bytes {
            }
             *
            @Override  
    public abstract static class GeoPoint extends ValuesSource {
 * You may obtain a copy of the License at  
                    final LeafOrdinalsFieldData atomicFieldData = indexFieldData.load(context);
    /**  
        };
                @Override
            static class BytesValues extends SortingBinaryDocValues implements ScorerAware {  
    /**  
    /**  
        public SortedBinaryDocValues bytesValues(LeafReaderContext context) {
                            values[i].copyChars(run.toString());
import org.opensearch.index.fielddata.AbstractSortingNumericDocValues;  
                }  
}
            @Override  
             */
             * by returning the underlying {@link OrdinalMap}. If this method returns false, then calling  
             *
                return new Bytes.WithScript.BytesValues(delegate.bytesValues(context), script.newInstance(context));
     */
                            Object run = script.execute();  
        // No need to implement ReaderContextAware here, the delegate already takes care of updating data structures
            throw new AggregationExecutionException("can't round a [GEO_POINT]");
         *
             */  
                this.script = script;
        this.cancellationCheck = cancellationCheck;  
     * @opensearch.internal
 * under the License.  
                return org.opensearch.index.fielddata.FieldData.docsWithValue(ordinals);  
        protected final IndexFieldData<?> indexFieldData;  
                    return 0;  
                    script.setScorer(scorer);  
        @Override  
            };
                public FieldData(IndexOrdinalsFieldData indexFieldData) {
        private final RangeType rangeType;
     */  
        @Override  
                @Override
            }
                public boolean advanceExact(int target) throws IOException {
                final SortedNumericDoubleValues values = doubleValues(context);
     * Check if this values source supports using global ordinals
            // TODO lookup the min and max rounding when appropriate
        public RangeType rangeType() {  
            public SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException {  
            return indexFieldData.load(context).getBytesValues();  
 * @opensearch.api  
            public long globalMaxOrd(IndexSearcher indexSearcher) throws IOException {  
import org.opensearch.index.mapper.RangeType;  
                    return false;
    /** Whether this values source needs scores. */
 * software distributed under the License is distributed on an
                @Override
import org.opensearch.common.annotation.PublicApi;  
import org.opensearch.search.aggregations.support.values.ScriptDoubleValues;
                @Override  
             * @param context {@link LeafReaderContext}
            }
import org.apache.lucene.search.Scorable;
            }
            @Override
        @Override  
    /**
     */
    /**  
                    SortedSetDocValues values = globalOrdinalsValues(atomicReaderContext);  
            public boolean isBigInteger() {  
     * Range type  
                        return true;
             *
     * Numeric values source type
                this.indexFieldData = indexFieldData;
                @Override
import org.apache.lucene.index.LeafReaderContext;  
                        sort();
    public abstract static class Numeric extends ValuesSource {  
     */
            } else {  
                        return true;
            @Override
                return true;
        /** Get the current {@link SortedNumericDoubleValues}. */
                }
            return Rounding::prepareForUnknown;
            public WithScript(ValuesSource delegate, AggregationScript.LeafFactory script) {
             * @opensearch.internal
    }
         * @opensearch.internal
            final MultiGeoPointValues geoPoints = geoPointValues(context);
                return indexFieldData.load(context).getLongValues();
                } else {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    return atomicFieldData.getOrdinalsValues();  
            public SortedBinaryDocValues bytesValues(LeafReaderContext context) {
    public boolean needsScores() {
            final SortedBinaryDocValues bytes = bytesValues(context);
            public SortedNumericDoubleValues doubleValues(LeafReaderContext context) throws IOException {
            @Override
            public SortedBinaryDocValues bytesValues(LeafReaderContext context) {  
            }
         *  
         *  
import org.opensearch.script.AggregationScript;
                        resize(longValues.docValueCount());
                    return DocValues.emptySortedSet();
            @Override
                return false;  
         */  
             * Field data for the bytes values source  
 * this work for additional information regarding copyright
            return org.opensearch.index.fielddata.FieldData.docsWithValue(bytes);  
         * This provides the {@link GeoShapeValue} after reading from LeafReaderContext
         *
                    this.bytesValues = bytesValues;  
                    if (bytesValues.advanceExact(doc)) {
            @Override  
                    return atomicFieldData.getBytesValues();
                return indexFieldData.load(context).getBytesValues();
        }
/*  
                    final LeafOrdinalsFieldData atomicFieldData = indexFieldData.load(context);
                        }  
            protected final IndexNumericFieldData indexFieldData;  
    public abstract SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException;  
                            values[i] = script.runAsLong();
    }  
 * this file be licensed under the Apache-2.0 license or a
     * <p>
                        for (int i = 0; i < docValueCount(); ++i) {  
    private Runnable cancellationCheck;
            @Override  
            }
        public abstract SortedNumericDoubleValues doubleValues(LeafReaderContext context) throws IOException;
                return new DoubleValues(delegate.doubleValues(context), script.newInstance(context));
     * Get the current {@link BytesValues}.
        }
            public Script(AggregationScript.LeafFactory script, ValueType scriptValueType) {
                return new ScriptBytesValues(script.newInstance(context));
                public SortedSetDocValues ordinalsValues(LeafReaderContext context) {  
            }
                    final org.apache.lucene.util.LongValues segmentToGlobalOrd = map.getGlobalOrds(context.ord);
            @Override  
 */  
                return org.opensearch.index.fielddata.FieldData.emptySortedBinary();
         * @param context {@link LeafReaderContext}
    /**
            @Override
            }  
                }  
        public Function<Rounding, Prepared> roundingPreparer(IndexReader reader) throws IOException {
            }
import org.opensearch.index.fielddata.GeoShapeValue;
                return org.opensearch.index.fielddata.FieldData.docsWithValue(values);
                public void setScorer(Scorable scorer) {  
            private final AggregationScript.LeafFactory script;  
         * @opensearch.internal
                    return doubleValues.advance(target);  
                    return org.opensearch.index.fielddata.FieldData.emptySortedBinary();
            @Override  
                    if (map == null) {  
         */
 * not use this file except in compliance with the License.
        }
                    return LongUnaryOperator.identity();
            @Override
import org.opensearch.index.fielddata.SortedBinaryDocValues;
        public static class Script extends Bytes {
            public static final WithOrdinals EMPTY = new WithOrdinals() {  
                    }  
            throw new AggregationExecutionException("can't round a [GEO_SHAPE]");  
            public SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException {  
                    } else {  
                        // segments and global ordinals are the same
        public abstract static class WithOrdinals extends Bytes {
         * {@link ValuesSource} subclass for Bytes fields with a Value Script applied
                    return DocValues.emptySortedSet();  
            public GeoShapeValue getGeoShapeValues(LeafReaderContext context) {
                        for (int i = 0; i < count; ++i) {  
                    final LeafOrdinalsFieldData atomicFieldData = global.load(context);
             */  
        /**
     * The primitive data type for doing an aggregation on the GeoShape
        }
        /**
            @Override
        };  
        /** Get the current {@link SortedNumericDocValues}. */
                        script.setDocument(doc);
            }  
            /** Returns a mapping from segment ordinals to global ordinals. */  
            @Override
                return new ScriptLongValues(script.newInstance(context));  
                        sort();
             * Bytes values
        /**
 *  
            public boolean needsScores() {  
                        grow();
            }
                return scriptValueType != null ? scriptValueType == ValueType.UNSIGNED_LONG : false;
import org.apache.lucene.index.DirectoryReader;  
                public String getIndexFieldName() {
         */  
        };
            }  
                public SortedSetDocValues globalOrdinalsValues(LeafReaderContext context) {  
        public DocValueBits docsWithValue(LeafReaderContext context) {
            public boolean needsScores() {
            }
         */  
                    LeafReaderContext atomicReaderContext = indexReader.leaves().get(0);
import org.apache.lucene.util.BytesRef;  
            }  
         * @opensearch.internal
        }
                            CollectionUtils.ensureNoSelfReferences(run, "ValuesSource.BytesValues script");
            public SortedNumericDocValues longValues(LeafReaderContext context) {
            public boolean hasGlobalOrdinals() {
                public boolean supportsGlobalOrdinalsMapping() {
            return org.opensearch.index.fielddata.FieldData.docsWithValue(geoShapeValue);
             */
        public static class WithScript extends Numeric {
            public abstract LongUnaryOperator globalOrdinalsMapping(LeafReaderContext context) throws IOException;
         *
            public SortedNumericDocValues longValues(LeafReaderContext context) throws IOException {
             *  
 */
            }  
            @Override  
            @Override
                }
                return new LongValues(delegate.longValues(context), script.newInstance(context));  
                @Override
        public static class Fielddata extends GeoPoint {  
        /**  
        public abstract boolean isFloatingPoint();
    public abstract static class GeoShape extends ValuesSource {
        /**
         * @opensearch.internal
            @Override  
import org.apache.lucene.index.SortedSetDocValues;  
                this.script = script;
            public SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException {
import org.opensearch.index.fielddata.IndexOrdinalsFieldData;
 * specific language governing permissions and limitations
            @Override
            public MultiGeoPointValues geoPointValues(LeafReaderContext context) {
             * @opensearch.internal
             */
             * @opensearch.internal
                    this.indexFieldData = indexFieldData;  
     * This returns a {@linkplain Function} because auto date histogram will  
        }
                private final AggregationScript script;
package org.opensearch.search.aggregations.support;
                return indexFieldData.load(context).getBytesValues();  
         * @opensearch.internal
import org.opensearch.common.Rounding.Prepared;
                }  
 * GitHub history for details.
                this.script = script;  
                protected final IndexOrdinalsFieldData indexFieldData;  
             */
    public String getIndexFieldName() {
         * Field data without ordinals
                return script.needs_score();
         * This is getting used in the {@link org.opensearch.search.aggregations.bucket.missing.MissingAggregator}  
            public SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException {  
            @Override
        /**
import org.opensearch.index.fielddata.DocValueBits;
                    this.script = script;
             * @param context {@link LeafReaderContext}
            }  
            }  
            }
            }
     * @opensearch.internal
                return indexFieldData.load(context).getGeoShapeValue();  
                    final IndexOrdinalsFieldData global = indexFieldData.loadGlobal((DirectoryReader) context.parent.reader());
import org.opensearch.common.Rounding;
            static class DoubleValues extends SortingNumericDoubleValues implements ScorerAware {
                return true; // even if the underlying source produces longs, scripts can change them to doubles
                this.scriptValueType = scriptValueType;  
        @Override  
                this.indexFieldData = indexFieldData;
             * @param context {@link LeafReaderContext}  
             * @opensearch.internal
            public SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException {
 *
            }  
        /** Whether the underlying data is floating-point or not. */
 * Modifications Copyright OpenSearch Contributors. See  
        public abstract MultiGeoPointValues geoPointValues(LeafReaderContext context);
            @Override
    protected void setCancellationCheck(Runnable cancellationCheck) {
    public abstract static class Bytes extends ValuesSource {
            @Override
                    }  
         */  
                }
                return indexFieldData.load(context).getBytesValues();
import org.opensearch.index.fielddata.IndexNumericFieldData;
        }
            public FieldData(IndexNumericFieldData indexFieldData) {
             * Get the current {@link BytesValues}.  
     */
         * Field data for geo point values source
            public SortedNumericDoubleValues doubleValues(LeafReaderContext context) {  
            }  
            public boolean isFloatingPoint() {  
                IndexReader indexReader = indexSearcher.getIndexReader();
                @Override
             *
            @Override  
            }  
                            script.setNextAggregationValue(value.utf8ToString());
            public SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException {  
        public static class FieldData extends GeoShape {  
                    return indexFieldData.supportsGlobalOrdinalsMapping();
                }
            private final AggregationScript.LeafFactory script;
                private final AggregationScript script;
     * Geo point values source
        }
                return indexFieldData.getNumericType() == NumericType.UNSIGNED_LONG;
import org.opensearch.index.fielddata.IndexGeoPointFieldData;
import org.opensearch.index.fielddata.LeafOrdinalsFieldData;
                    return atomicFieldData.getOrdinalsValues();
            }
                return false;
        public final Function<Rounding, Rounding.Prepared> roundingPreparer(IndexReader reader) throws IOException {
 *
                }  
            }
         * @opensearch.internal
             * Double values source type  
