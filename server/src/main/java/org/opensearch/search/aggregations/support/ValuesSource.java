    }
            private final AggregationScript.LeafFactory script;
            }
     */
                return scriptValueType != null ? scriptValueType == ValueType.UNSIGNED_LONG : false;
        /** Get the current {@link SortedNumericDocValues}. */
            @Override
                this.script = script;
            }
                this.delegate = delegate;
    /**
            @Override
                return org.opensearch.index.fielddata.FieldData.emptySortedBinary();
         *
            protected final IndexFieldData<?> indexFieldData;
            }
            }
            }
 * Modifications Copyright OpenSearch Contributors. See
            public abstract LongUnaryOperator globalOrdinalsMapping(LeafReaderContext context) throws IOException;
     */
        }
                this.indexFieldData = indexFieldData;
             * by returning the underlying {@link OrdinalMap}. If this method returns false, then calling
        }
             */
import org.apache.lucene.search.IndexSearcher;
                return org.opensearch.index.fielddata.FieldData.docsWithValue(ordinals);
             * @opensearch.internal
             * Long values source type
            }
                    this.longValues = values;
                this.indexFieldData = indexFieldData;
            }
import org.opensearch.index.fielddata.AbstractSortingNumericDocValues;
         * This is getting used in the {@link org.opensearch.search.aggregations.bucket.missing.MissingAggregator}
            }
         */
        public abstract SortedNumericDocValues longValues(LeafReaderContext context) throws IOException;
                }
                public boolean advanceExact(int doc) throws IOException {
                return org.opensearch.index.fielddata.FieldData.emptySortedBinary();
            public GeoShapeValue getGeoShapeValues(LeafReaderContext context) {
            }
 */
import org.opensearch.index.fielddata.plain.AbstractGeoShapeIndexFieldData;
        }
                return false;
            public static class FieldData extends WithOrdinals {
            public SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException {
                if (indexReader.leaves().isEmpty()) {
         * @opensearch.internal
            @Override
     * Geo point values source
            @Override
                    }
 * Base class for a ValuesSource; the primitive data for an agg
            public boolean isBigInteger() {
 * software distributed under the License is distributed on an
            return Rounding::prepareForUnknown;
                            values[i].copyChars(run.toString());
                private final AggregationScript script;
public abstract class ValuesSource {
             * Get the current {@link BytesValues}.
            public org.opensearch.index.fielddata.MultiGeoPointValues geoPointValues(LeafReaderContext context) {
             *
        }
            }
                private final SortedNumericDoubleValues doubleValues;
         */
            @Override
            throw new AggregationExecutionException("can't round a [GEO_POINT]");
            }
            }
            @Override
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
import org.opensearch.index.fielddata.SortedBinaryDocValues;
                final SortedNumericDocValues values = longValues(context);
         *
                    return DocValues.emptySortedSet();
            public SortedNumericDocValues longValues(LeafReaderContext context) {
         * Field data for geo shape values source
         * @opensearch.internal
import org.opensearch.core.common.util.CollectionUtils;
        public Function<Rounding, Prepared> roundingPreparer(IndexReader reader) throws IOException {
                    this.script = script;
        return null;
                protected final IndexOrdinalsFieldData indexFieldData;
        }
 * KIND, either express or implied.  See the License for the
                return scriptValueType != null ? scriptValueType == ValueType.DOUBLE : true;
import org.opensearch.index.fielddata.SortingBinaryDocValues;
                public SortedBinaryDocValues bytesValues(LeafReaderContext context) {
                private final SortedNumericDocValues longValues;
        private final RangeType rangeType;
         * Field data without ordinals
import org.opensearch.index.fielddata.IndexNumericFieldData.NumericType;
        public DocValueBits docsWithValue(LeafReaderContext context) throws IOException {
            public SortedBinaryDocValues bytesValues(LeafReaderContext context) {
            public boolean needsScores() {
        }
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.api
 * license agreements. See the NOTICE file distributed with
            @Override
            @Override
            public FieldData(IndexFieldData<?> indexFieldData) {
                @Override
            }
                    final IndexOrdinalsFieldData global = indexFieldData.loadGlobal((DirectoryReader) context.parent.reader());
        }
                return new BytesValues(delegate.bytesValues(context), script.newInstance(context));
import org.apache.lucene.index.OrdinalMap;
            public boolean isBigInteger() {
             */
                return true;
     *
        public static class Fielddata extends GeoPoint {
            public boolean needsScores() {
    public static class Range extends ValuesSource {
             */
     * Bytes type
         *
                return indexFieldData.load(context).getGeoPointValues();
             *
             */
        @Override
            public SortedNumericDocValues longValues(LeafReaderContext context) throws IOException {
         */
             */
             * Get the current {@link BytesValues}.
import org.opensearch.search.aggregations.support.values.ScriptDoubleValues;
            }
                }
         */
                return this.indexFieldData.getFieldName();
                return org.opensearch.index.fielddata.FieldData.docsWithValue(values);
                return org.opensearch.index.fielddata.FieldData.emptySortedNumericDoubles();
            return org.opensearch.index.fielddata.FieldData.docsWithValue(bytes);
    }
             * @param context {@link LeafReaderContext}
                        }
                    return 0;
 * SPDX-License-Identifier: Apache-2.0
                @Override
            public FieldData(AbstractGeoShapeIndexFieldData indexFieldData) {
                    this.bytesValues = bytesValues;
                        for (int i = 0; i < docValueCount(); ++i) {
            protected final IndexGeoPointFieldData indexFieldData;
                }
                @Override
                public SortedSetDocValues ordinalsValues(LeafReaderContext context) {
            throw new AggregationExecutionException("can't round a [GEO_SHAPE]");
         * @opensearch.internal
                    final LeafOrdinalsFieldData atomicFieldData = indexFieldData.load(context);
        public abstract boolean isBigInteger();
    public abstract static class Numeric extends ValuesSource {
            @Override
             */
            final SortedBinaryDocValues bytes = bytesValues(context);
        public final Function<Rounding, Rounding.Prepared> roundingPreparer(IndexReader reader) throws IOException {
             * @param context {@link LeafReaderContext}
 *
        @Override
    }
    public boolean hasGlobalOrdinals() {
            @Override
 * Unless required by applicable law or agreed to in writing,
            }
        }
            public boolean isBigInteger() {
            public SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException {
                    return this.indexFieldData.getFieldName();
                    script.setScorer(scorer);
        }
    private Runnable cancellationCheck;
import org.opensearch.index.fielddata.SortingNumericDoubleValues;
                public void setScorer(Scorable scorer) {
            }
/**
            }
        /**
    /**
            @Override
            public SortedNumericDoubleValues doubleValues(LeafReaderContext context) throws IOException {
                public LongUnaryOperator globalOrdinalsMapping(LeafReaderContext context) throws IOException {
import org.opensearch.index.mapper.RangeType;
import org.opensearch.index.fielddata.GeoShapeValue;
import org.apache.lucene.index.LeafReaderContext;
             *
        /**
         *
            private final ValuesSource delegate;
            public SortedNumericDoubleValues doubleValues(LeafReaderContext context) {
            }
            public SortedBinaryDocValues bytesValues(LeafReaderContext context) {
            };
             * Field data for the bytes values source
            }
        public static class FieldData extends Bytes {
        /**
            public SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException {
            @Override
                    final org.apache.lucene.util.LongValues segmentToGlobalOrd = map.getGlobalOrds(context.ord);
            public boolean needsScores() {
        };
                }
import org.opensearch.script.AggregationScript;
            public SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException {
     * This returns a {@linkplain Function} because auto date histogram will
            }
     * Numeric values source type
                return script.needs_score();
                    SortedSetDocValues values = globalOrdinalsValues(atomicReaderContext);
                }
         * Field data for numerics
        }
@PublicApi(since = "1.0.0")
                            script.setNextAggregationValue(value.utf8ToString());
     */
                        script.setDocument(doc);
            }
            protected final IndexNumericFieldData indexFieldData;
            @Override
            @Override
         * {@link ValuesSource} subclass for Numeric fields with a Value Script applied
            public WithScript(Numeric delegate, AggregationScript.LeafFactory script) {
    /**
 * The OpenSearch Contributors require contributions made to
import org.apache.lucene.index.SortedNumericDocValues;
            }
            return org.opensearch.index.fielddata.FieldData.docsWithValue(bytes);
         * {@link ValuesSource} implementation for stand alone scripts returning a Numeric value
                    this.indexFieldData = indexFieldData;
        public static class Script extends Numeric {
         * @return DocValueBits
     * Build a function prepares rounding values to be called many times.
/*
     * need to call it many times over the course of running the aggregation.
            @Override
            @Override
                public SortedSetDocValues globalOrdinalsValues(LeafReaderContext context) {
                            Object run = script.execute();
import org.opensearch.common.lucene.ScorerAware;
                public boolean advanceExact(int target) throws IOException {
        }
            }
import org.opensearch.index.fielddata.DocValueBits;
                } else {
             * @opensearch.internal
             *
        public DocValueBits docsWithValue(LeafReaderContext context) throws IOException {
             * @opensearch.internal
    }
import org.opensearch.index.fielddata.MultiGeoPointValues;
                return script.needs_score();
import org.opensearch.search.aggregations.support.values.ScriptLongValues;
                        script.setDocument(target);
        /**
            @Override
                }
    public String getIndexFieldName() {
        @Override
                }
        public abstract SortedNumericDoubleValues doubleValues(LeafReaderContext context) throws IOException;
             * Double values source type
        public RangeType rangeType() {
             * @return {@link GeoShapeValue}
                        resize(doubleValues.docValueCount());
            }
        @Override
    /**
}
                @Override
         *
                return org.opensearch.index.fielddata.FieldData.emptyMultiGeoPoints();
                    if (map == null) {
                return indexFieldData.load(context).getLongValues();
            }
                }
 * You may obtain a copy of the License at
import org.opensearch.index.fielddata.IndexOrdinalsFieldData;
            @Override
         * Provides ordinals for bytes
            @Override
                @Override
                    final OrdinalMap map = global.getOrdinalMap();
        /**
                    return segmentToGlobalOrd::get;
         * @opensearch.internal
 */
        }
                @Override
     */
     * Get the current {@link BytesValues}.
                    if (longValues.advanceExact(target)) {
                        for (int i = 0; i < count; ++i) {
            public boolean isFloatingPoint() {
                return indexFieldData.load(context).getBytesValues();
            // TODO lookup the min and max rounding when appropriate
            public String getIndexFieldName() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                IndexReader indexReader = indexSearcher.getIndexReader();
        /** Get the current {@link SortedNumericDoubleValues}. */
            /**
         * @opensearch.internal
            }
                    return false;
            public SortedNumericDoubleValues doubleValues(LeafReaderContext context) throws IOException {
 * compatible open source license.
             * @return SortedBinaryDocValues
 *
 */
            }
                    return atomicFieldData.getBytesValues();
                }
        public abstract MultiGeoPointValues geoPointValues(LeafReaderContext context);
         *
 * Licensed to Elasticsearch under one or more contributor
        }
                    return values.getValueCount();
                        script.setDocument(target);
     *
            @Override
                return new ScriptBytesValues(script.newInstance(context));
    /**
         * @return {@link GeoShapeValue}
            public MultiGeoPointValues geoPointValues(LeafReaderContext context) {
            public SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException {
import org.opensearch.index.fielddata.IndexGeoPointFieldData;
     * Check if this values source supports using global ordinals
                return org.opensearch.index.fielddata.FieldData.emptyGeoShape();
            final SortedBinaryDocValues bytes = bytesValues(context);
                }
     * Range type
                }
            public static final WithOrdinals EMPTY = new WithOrdinals() {
            }
            /**
            /**
import org.apache.lucene.util.BytesRef;
         * Field data for geo point values source
            public Script(AggregationScript.LeafFactory script) {
        // No need to implement ReaderContextAware here, the delegate already takes care of updating data structures
        @Override
                        return true;
import org.apache.lucene.index.DirectoryReader;
                        count = bytesValues.docValueCount();
                    this.script = script;
        public static class WithScript extends Bytes {
        public static class Script extends Bytes {
        protected final IndexFieldData<?> indexFieldData;
        public DocValueBits docsWithValue(LeafReaderContext context) {
 * not use this file except in compliance with the License.
                    final LeafOrdinalsFieldData atomicFieldData = global.load(context);
                public LongUnaryOperator globalOrdinalsMapping(LeafReaderContext context) throws IOException {
                @Override
     */
                @Override
                this.script = script;
        /**
 *
            @Override
            /**
        public static class WithScript extends Numeric {
        @Override
/*
                }
                    this.doubleValues = values;
                        grow();
             * @opensearch.internal
            /**
             * {@link #globalOrdinalsMapping} will result in an {@link UnsupportedOperationException}.
import org.apache.lucene.index.IndexReader;
            @Override
            }
    /** Whether this values source needs scores. */
                @Override
            public DocValueBits docsWithValue(LeafReaderContext context) throws IOException {
            final MultiGeoPointValues geoPoints = geoPointValues(context);
import java.util.function.Function;
import org.apache.lucene.index.DocValues;
                }
            }
                return false;
                            CollectionUtils.ensureNoSelfReferences(run, "ValuesSource.BytesValues script");
             * @param context {@link LeafReaderContext}
                return indexFieldData.load(context).getBytesValues();
            public SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException {
            }
            }
                return indexFieldData.load(context).getDoubleValues();
                public void setScorer(Scorable scorer) {
                public int advance(int target) throws IOException {
                            values[i] = script.runAsLong();
            public SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException {
    public abstract static class GeoPoint extends ValuesSource {
            private final Numeric delegate;
                    script.setScorer(scorer);
import org.opensearch.search.aggregations.support.ValuesSource.Bytes.WithScript.BytesValues;
                    return false;
 */
                private final AggregationScript script;
                }
                @Override
 * specific language governing permissions and limitations
            public boolean needsScores() {
         * {@link ValuesSource} subclass for Bytes fields with a Value Script applied
         * @opensearch.internal
             * @return {@link GeoShapeValue}
        /**
            public boolean isFloatingPoint() {
                    final LeafOrdinalsFieldData atomicFieldData = indexFieldData.load(context);
            public WithScript(ValuesSource delegate, AggregationScript.LeafFactory script) {
                this.delegate = delegate;
            @Override
            public boolean supportsGlobalOrdinalsMapping() {
            }
     *
                            values[i] = script.runAsDouble();
                    if (bytesValues.advanceExact(doc)) {
            return org.opensearch.index.fielddata.FieldData.docsWithValue(geoPoints);
 * under the License.
        public static class FieldData extends Numeric {
        /**
                @Override
            @Override
        public DocValueBits docsWithValue(LeafReaderContext context) throws IOException {
            public SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException {
            }
        @Override
        public static class FieldData extends GeoShape {
import org.opensearch.common.annotation.PublicApi;
        /**
                        sort();
                return new Bytes.WithScript.BytesValues(delegate.bytesValues(context), script.newInstance(context));
                return new ScriptBytesValues(script.newInstance(context));
             */
        }
                public FieldData(IndexOrdinalsFieldData indexFieldData) {
                        return LongUnaryOperator.identity();
                }
                        }
import org.opensearch.search.aggregations.AggregationExecutionException;
            public Script(AggregationScript.LeafFactory script, ValueType scriptValueType) {
                public SortedSetDocValues ordinalsValues(LeafReaderContext context) {
                }
        this.cancellationCheck = cancellationCheck;
                return script.needs_score();
     * @opensearch.internal
            }
                }
            }
    /**
            public SortedNumericDocValues longValues(LeafReaderContext context) throws IOException {
            /**
                }
        }
     */
     */
                return new LongValues(delegate.longValues(context), script.newInstance(context));
import org.opensearch.common.Rounding.Prepared;
            private final AggregationScript.LeafFactory script;
            }
    }
                    return indexFieldData.supportsGlobalOrdinalsMapping();
        public abstract GeoShapeValue getGeoShapeValues(LeafReaderContext context);
                return indexFieldData.getNumericType().isFloatingPoint();
         *
                    return org.opensearch.index.fielddata.FieldData.emptySortedBinary();
        @Override
    public abstract SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException;
            }
            }
 *
         * This provides the {@link GeoShapeValue} after reading from LeafReaderContext
import org.opensearch.index.fielddata.LeafOrdinalsFieldData;
         */
                        resize(longValues.docValueCount());
                this.indexFieldData = indexFieldData;
             */
         */
            private final AggregationScript.LeafFactory script;
        public abstract boolean isFloatingPoint();
                        // segments and global ordinals are the same
        public abstract static class WithOrdinals extends Bytes {
import org.opensearch.common.Rounding;
             */
                public void setScorer(Scorable scorer) {
import org.opensearch.index.fielddata.IndexFieldData;
            }
        @Override
            return org.opensearch.index.fielddata.FieldData.docsWithValue(geoShapeValue);
    protected void setCancellationCheck(Runnable cancellationCheck) {
        public static final GeoShape EMPTY = new GeoShape() {
                DoubleValues(SortedNumericDoubleValues values, AggregationScript script) {
                public SortedBinaryDocValues bytesValues(LeafReaderContext context) throws IOException {
        }
                }
        public Function<Rounding, Prepared> roundingPreparer(IndexReader reader) {
            @Override
            }
                public SortedSetDocValues globalOrdinalsValues(LeafReaderContext context) {
        public final Function<Rounding, Rounding.Prepared> roundingPreparer(IndexReader reader) throws IOException {
                        return true;
            public GeoShapeValue getGeoShapeValues(LeafReaderContext context) {
         * @param context {@link LeafReaderContext}
             *
        public DocValueBits docsWithValue(LeafReaderContext context) throws IOException {
                            script.setNextAggregationValue(longValues.nextValue());
            @Override
            public FieldData(IndexNumericFieldData indexFieldData) {
                        for (int i = 0; i < docValueCount(); ++i) {
            @Override
                @Override
                    return LongUnaryOperator.identity();
            }
                return true;
                    } else {
                return org.opensearch.index.fielddata.FieldData.docsWithValue(values);
        public Function<Rounding, Prepared> roundingPreparer(IndexReader reader) throws IOException {
             * Bytes values
                return indexFieldData.load(context).getBytesValues();
            throw new AggregationExecutionException("can't round a [BYTES]");
         */
    }
         */
            /** Returns a mapping from segment ordinals to global ordinals. */
 * the Apache License, Version 2.0 (the "License"); you may
        };
                @Override
                this.script = script;
                    return DocValues.emptySortedSet();
 * this work for additional information regarding copyright
        }
        public SortedBinaryDocValues bytesValues(LeafReaderContext context) {
        };
            }
     *
     * @opensearch.internal
                LongValues(SortedNumericDocValues values, AggregationScript script) {
                return indexFieldData.load(context).getBytesValues();
                BytesValues(SortedBinaryDocValues bytesValues, AggregationScript script) {
            return indexFieldData.load(context).getBytesValues();
            @Override
         * @opensearch.internal
                        sort();
                            script.setNextAggregationValue(doubleValues.nextValue());
            this.rangeType = rangeType;
                }
                }
                }
            return rangeType;
                public boolean advanceExact(int target) throws IOException {
        }
 * GitHub history for details.
                    return doubleValues.advance(target);
                public boolean supportsGlobalOrdinalsMapping() {
                return org.opensearch.index.fielddata.FieldData.emptySortedBinary();
         * @opensearch.internal
     * @opensearch.internal
         * @param context {@link LeafReaderContext}
import java.util.function.LongUnaryOperator;
            public SortedBinaryDocValues bytesValues(LeafReaderContext context) {
     */
        /** Whether the underlying data is floating-point or not. */
                    LeafReaderContext atomicReaderContext = indexReader.leaves().get(0);
            public boolean hasGlobalOrdinals() {
                        grow();
        @Override
package org.opensearch.search.aggregations.support;
        }
            public boolean isFloatingPoint() {
         */
            @Override
                        return false;
                    final IndexOrdinalsFieldData global = indexFieldData.loadGlobal((DirectoryReader) context.parent.reader());
            @Override
                @Override
                    if (doubleValues.advanceExact(target)) {
    }
                        return true;
            @Override
        public static final GeoPoint EMPTY = new GeoPoint() {
             *
                this.scriptValueType = scriptValueType;
            private final AggregationScript.LeafFactory script;
import org.opensearch.index.fielddata.IndexNumericFieldData;
                public String getIndexFieldName() {
             *
            public abstract SortedSetDocValues ordinalsValues(LeafReaderContext context) throws IOException;
            /**
            @Override
                private final SortedBinaryDocValues bytesValues;
            final GeoShapeValue geoShapeValue = getGeoShapeValues(context);
                final SortedNumericDoubleValues values = doubleValues(context);
     * @opensearch.internal
        }
             * This provides the {@link GeoShapeValue} after reading from LeafReaderContext
 * ownership. Elasticsearch licenses this file to you under
                return new DoubleValues(delegate.doubleValues(context), script.newInstance(context));
            @Override
                return new ScriptDoubleValues(script.newInstance(context));
            }
            } else {
        /**
         *
            return Rounding::prepareForUnknown;
            }
            public SortedNumericDoubleValues doubleValues(LeafReaderContext context) throws IOException {
             * Whether this values source is able to provide a mapping between global and segment ordinals,
    public abstract static class Bytes extends ValuesSource {
                return true; // even if the underlying source produces longs, scripts can change them to doubles
    public abstract DocValueBits docsWithValue(LeafReaderContext context) throws IOException;
    }
            public SortedNumericDocValues longValues(LeafReaderContext context) {
            /**
            public String getIndexFieldName() {
            static class DoubleValues extends SortingNumericDoubleValues implements ScorerAware {
                            final BytesRef value = bytesValues.nextValue();
            }
        public static final Numeric EMPTY = new Numeric() {
 * this file be licensed under the Apache-2.0 license or a
            private final ValueType scriptValueType;
                return new ScriptLongValues(script.newInstance(context));
    /**
             * This provides the {@link GeoShapeValue} after reading from LeafReaderContext
                    return atomicFieldData.getOrdinalsValues();
        /**
            }
    }
            public Fielddata(IndexGeoPointFieldData indexFieldData) {
            public boolean isFloatingPoint() {
            static class BytesValues extends SortingBinaryDocValues implements ScorerAware {
            @Override
            public long globalMaxOrd(IndexSearcher indexSearcher) throws IOException {
import java.io.IOException;
                    }
            /**
            }
                return indexFieldData.getFieldName();
            }
         */
                    }
import org.opensearch.search.aggregations.support.values.ScriptBytesValues;
        public Range(IndexFieldData<?> indexFieldData, RangeType rangeType) {
                this.indexFieldData = indexFieldData;
            public abstract SortedSetDocValues globalOrdinalsValues(LeafReaderContext context) throws IOException;
                    }
/*
                return false; /* always fall back to floating point */
            }
            }
            public boolean isBigInteger() {
                return indexFieldData.load(context).getGeoShapeValue();
                return script.needs_score();
        /** Whether the underlying data is big integer or not. */
         */
                    script.setScorer(scorer);
import org.apache.lucene.search.Scorable;
         *
                return DocValues.emptySortedNumeric();
            if (isFloatingPoint() || isBigInteger()) {
                    this.script = script;
        }
            }
            @Override
                        sort();
            @Override
         * @opensearch.internal
     * <p>
            protected final AbstractGeoShapeIndexFieldData indexFieldData;
        return false;
import org.apache.lucene.index.SortedSetDocValues;
            static class LongValues extends AbstractSortingNumericDocValues implements ScorerAware {
        return false;
            this.indexFieldData = indexFieldData;
                final SortedSetDocValues ordinals = ordinalsValues(context);
            @Override
                    return atomicFieldData.getOrdinalsValues();
                return indexFieldData.getNumericType() == NumericType.UNSIGNED_LONG;
            }
        }
         * {@link ValuesSource} implementation for stand alone scripts returning a Bytes value
                @Override
                @Override
    public abstract static class GeoShape extends ValuesSource {
    public abstract Function<Rounding, Rounding.Prepared> roundingPreparer(IndexReader reader) throws IOException;
                        count = 0;
                @Override
                this.script = script;
            @Override
     * The primitive data type for doing an aggregation on the GeoShape
                private final AggregationScript script;
            }
    public boolean needsScores() {
        @Override
                        }
