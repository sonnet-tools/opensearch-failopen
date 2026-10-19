        final BigArrays bigArrays = context.bigArrays();  
        super(name, context, parent, metadata);
            precomputeLeafUsingStarTree(ctx, supportedStarTree);  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.MultiValueMode;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                throw new CollectionTerminatedException();
                mins.fill(from, mins.size(), Double.POSITIVE_INFINITY);
            @Override  
 * GitHub history for details.
                 * so the ordinal for the bucket is always 0.
import static org.opensearch.search.startree.StarTreeQueryHelper.getSupportedStarTree;  
                return LeafBucketCollector.NO_OP_COLLECTOR;
    @Override
     * The parent aggregator invokes this method to get a StarTreeBucketCollector,
        Releasables.close(mins);
                    min = Math.min(min, value);
                // If this a child aggregator, then the parent will trigger star-tree pre-computation.
                    if (liveDocs.get(docID)) {
                    if (values.advanceExact(doc)) {
            pointField = null;
    public double metric(long owningBucketOrd) {  
 *
    @Override
    }
    /**  
            min.set(Math.min(min.get(), (NumericUtils.sortableLongToDouble(value))));
                mins = context.bigArrays().grow(mins, bucket + 1);
    /**
    }
            return converter.apply(pointValues.getMinPackedValue());  
/*
        final PointValues pointValues = reader.getPointValues(fieldName);  
 * software distributed under the License is distributed on an
import org.opensearch.index.compositeindex.datacube.MetricStat;  
import org.apache.lucene.search.CollectionTerminatedException;  
        mins.fill(0, mins.size(), Double.POSITIVE_INFINITY);
            @Override
                 * There is no parent aggregator (see {@link MinAggregator#getPointReaderOrNull}  
                }  
    @Override  
import org.opensearch.search.aggregations.LeafBucketCollector;
        if (pointConverter != null) {
        throws IOException {
        this.pointConverter = pointReaderIfAvailable(config);
 *
            return buildEmptyAggregation();
import org.opensearch.index.fielddata.NumericDoubleValues;
/*
                    if (++lookupCounter > MAX_BKD_LOOKUPS) {
                        throw new CollectionTerminatedException();
            }
            public void collectRange(int min, int max) throws IOException {
 * license agreements. See the NOTICE file distributed with
                    final double value = values.doubleValue();
class MinAggregator extends NumericMetricsAggregator.SingleValue implements StarTreePreComputeCollector {
import org.opensearch.common.util.BigArrays;  
        } catch (CollectionTerminatedException e) {}
 */  
    }
     * which exposes collectStarTreeEntry() to be evaluated on filtered star tree entries
 * Aggregate all docs into a min value  
        AtomicReference<Double> min = new AtomicReference<>(mins.get(0));
import org.apache.lucene.index.LeafReader;  
 * SPDX-License-Identifier: Apache-2.0
                mins.set(0, min);
                double min = mins.get(0);  
 * ownership. Elasticsearch licenses this file to you under  
        return new LeafBucketCollectorBase(sub, allValues) {  
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {
                    long from = mins.size();
        // TODO: Stop using nulls here  
                        min[0] = Math.min(min[0], values.doubleValue());  
import org.apache.lucene.index.LeafReaderContext;
    public ScoreMode scoreMode() {
                }
    final DocValueFormat format;
        );
        final Bits liveDocs = reader.getLiveDocs();
        }
     */  
import java.util.concurrent.atomic.AtomicReference;  
import org.apache.lucene.util.NumericUtils;
                final double[] min = { mins.get(bucket) };  
            (bucket, metricValue) -> mins.set(bucket, Math.min(mins.get(bucket), NumericUtils.sortableLongToDouble(metricValue)))
                /*
    }
 * Modifications Copyright OpenSearch Contributors. See  
        CompositeIndexFieldInfo starTree,  
        if (valuesSource == null) {  
            return Double.POSITIVE_INFINITY;
        return result[0];  
        this.valuesSource = config.hasValues() ? (ValuesSource.Numeric) config.getValuesSource() : null;
            parentCollector,
        if (valuesSource != null) {
    public StarTreeBucketCollector getStarTreeBucketCollector(
        final SortedNumericDoubleValues allValues = valuesSource.doubleValues(ctx);
    }  
                growMins(0);
                private short lookupCounter = 0;
        final Number[] result = new Number[1];
    }
                @Override  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
    }  
                    if (values.advanceExact(doc)) {
                // the minimum value has been extracted, we don't need to collect hits on this segment.  
 * not use this file except in compliance with the License.
    private static final int MAX_BKD_LOOKUPS = 1024;
    public void doClose() {  
        }  
            private void growMins(long bucket) {  
            return false;
            if (segMin != null) {
        }  
/**
                for (int doc = min; doc < max; doc++) {
                        result[0] = converter.apply(packedValue);  
                    }
            mins = context.bigArrays().newDoubleArray(1, false);  
        return mins.get(owningBucketOrd);
        if (valuesSource == null) {
            Number segMin = findLeafMinValue(ctx.reader(), pointField, pointConverter);  
import org.apache.lucene.index.PointValues;
            },  
import org.opensearch.search.aggregations.support.ValuesSource;
            if (parent != null && subAggregators.length == 0) {
 * the Apache License, Version 2.0 (the "License"); you may
        if (supportedStarTree != null) {  
    final ValuesSource.Numeric valuesSource;
        LeafReaderContext ctx,
        StarTreeBucketCollector parentCollector
                // Returning NO_OP_COLLECTOR explicitly because the getLeafCollector() are invoked starting from innermost aggregators  
        return new InternalMin(name, Double.POSITIVE_INFINITY, format, metadata());
            }
        };
        }
                if (bucket >= mins.size()) {
 * @opensearch.internal
    @Override
                return true;
        if (valuesSource == null || owningBucketOrd >= mins.size()) {
                }  
            public void collect(int doc, long bucket) throws IOException {
            MetricStat.MIN.getTypeName(),
                    return PointValues.Relation.CELL_CROSSES_QUERY;
        if (pointConverter != null) {
                }
        }
        }  
            @Override  
import org.apache.lucene.util.Bits;  
                });
        } else {
                    throw new UnsupportedOperationException();  
     * if the value cannot be inferred from the indexed {@link PointValues}.  
        }
                mins.set(0, minimum);  
            }  
                stream.forEach((doc) -> {
import java.io.IOException;
 *  
            } else {  
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
 * specific language governing permissions and limitations
        return false;
import org.opensearch.search.aggregations.Aggregator;
 * The OpenSearch Contributors require contributions made to  
        StarTreeQueryHelper.precomputeLeafUsingStarTree(context, valuesSource, ctx, starTree, MetricStat.MIN.getTypeName(), value -> {  
    @Override
 * Unless required by applicable law or agreed to in writing,
            }
        }, () -> mins.set(0, min.get()));
                    }  
    protected boolean tryPrecomputeAggregationForLeaf(LeafReaderContext ctx) throws IOException {  
        if (valuesSource == null || bucket >= mins.size()) {  
                }
    }
        return valuesSource != null && valuesSource.needsScores() ? ScoreMode.COMPLETE : ScoreMode.COMPLETE_NO_SCORES;
                return true;
     */
import org.opensearch.search.aggregations.StarTreePreComputeCollector;
import org.apache.lucene.search.ScoreMode;
                if (values.advanceExact(doc)) {
            return null;
    ) throws IOException {
    public InternalAggregation buildEmptyAggregation() {
 * this file be licensed under the Apache-2.0 license or a
        try {  
                }
            (bucket) -> {
 * this work for additional information regarding copyright
                public PointValues.Relation compare(byte[] minPackedValue, byte[] maxPackedValue) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (pointValues == null) {
    static Number findLeafMinValue(LeafReader reader, String fieldName, Function<byte[], Number> converter) throws IOException {
                // we have no parent and the values source is empty so we can skip collecting hits.
    }
    public void doReset() {  
        this.format = config.format();  
            pointField = config.fieldContext().field();  
import java.util.function.Function;
/*  
import org.opensearch.search.internal.SearchContext;
 */
    @Override  
                    mins.set(bucket, min);
        CompositeIndexFieldInfo supportedStarTree = getSupportedStarTree(this.context.getQueryShardContext());
import org.opensearch.search.aggregations.InternalAggregation;  
    public InternalAggregation buildAggregation(long bucket) {
            if (parent == null) {
    @Override
 */
                 */
            pointValues.intersect(new PointValues.IntersectVisitor() {
        }
    final String pointField;
import org.apache.lucene.search.DocIdStream;
import org.opensearch.common.lease.Releasables;
 * compatible open source license.
                        minimum = Math.min(minimum, values.doubleValue());  
            }  
            }
 *
                growMins(bucket);
            });
        return StarTreeQueryHelper.getStarTreeBucketMetricCollector(  
                    double min = mins.get(bucket);  
        final NumericDoubleValues values = MultiValueMode.MIN.select(allValues);
    @Override
}  
    final Function<byte[], Number> pointConverter;
                    }
    }
        }  
                public void visit(int docID) {
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
                public void visit(int docID, byte[] packedValue) {
 * You may obtain a copy of the License at  
        if (liveDocs == null) {
 * KIND, either express or implied.  See the License for the
            }
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
    }  
                growMins(bucket);  
            public void collect(DocIdStream stream, long bucket) throws IOException {
     * Returns the minimum value indexed in the <code>fieldName</code> field or <code>null</code>
        return new InternalMin(name, mins.get(bucket), format, metadata());  
import java.util.Map;
    }  
package org.opensearch.search.aggregations.metrics;
                        // this is the first leaf with a live doc so the value is the minimum for this segment.
    MinAggregator(String name, ValuesSourceConfig config, SearchContext context, Aggregator parent, Map<String, Object> metadata)  
    private void precomputeLeafUsingStarTree(LeafReaderContext ctx, CompositeIndexFieldInfo starTree) throws IOException {
                    }  
                    mins.fill(from, mins.size(), Double.POSITIVE_INFINITY);
                @Override  
import org.opensearch.search.DocValueFormat;  
                long from = mins.size();  
            valuesSource,  
                double minimum = mins.get(0);  
            starTree,
            mins.fill(0, mins.size(), Double.POSITIVE_INFINITY);
                    mins = bigArrays.grow(mins, bucket + 1);  
                @Override
        }  
import org.opensearch.search.aggregations.StarTreeBucketCollector;  
 */  
            return true;
import org.opensearch.search.startree.StarTreeQueryHelper;
                        throw new CollectionTerminatedException();
                min = Math.min(min, segMin.doubleValue());
import org.opensearch.common.util.DoubleArray;
    DoubleArray mins;
 * under the License.  
                mins.set(bucket, min[0]);  
