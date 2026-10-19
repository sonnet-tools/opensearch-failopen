            maxes = context.bigArrays().newDoubleArray(1, false);  
            (bucket, metricValue) -> maxes.set(bucket, Math.max(maxes.get(bucket), (NumericUtils.sortableLongToDouble(metricValue))))
                        result[0] = new byte[packedValue.length];
            Number segMax = findLeafMaxValue(ctx.reader(), pointField, pointConverter);  
    }
        if (liveDocs == null) {
                maxes = context.bigArrays().grow(maxes, bucket + 1);
                throw new UnsupportedOperationException();
        throws IOException {
                maxes.set(0, maximum);  
import java.util.Map;  
            return true;
        };
 */
        super(name, context, parent, metadata);
        AtomicReference<Double> max = new AtomicReference<>(maxes.get(0));
        return new LeafBucketCollectorBase(sub, allValues) {  
    public ScoreMode scoreMode() {
    }  
import org.opensearch.search.startree.StarTreeQueryHelper;
            precomputeLeafUsingStarTree(ctx, supportedStarTree);
        this.pointConverter = pointReaderIfAvailable(config);
    }
        if (pointConverter != null) {
            }
                // the maximum value has been extracted, we don't need to collect hits on this segment.
    @Override
/*  
    }
                    double max = maxes.get(bucket);  
        final BigArrays bigArrays = context.bigArrays();  
                return true;
        }  
import org.opensearch.search.DocValueFormat;  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
                        max[0] = Math.max(max[0], values.doubleValue());  
    public InternalAggregation buildAggregation(long bucket) {
            public void collect(DocIdStream stream, long bucket) throws IOException {
 * not use this file except in compliance with the License.
    /**  
                });
                    System.arraycopy(packedValue, 0, result[0], 0, packedValue.length);
 * Licensed to Elasticsearch under one or more contributor  
                if (Arrays.equals(maxValue, 0, numBytes, maxPackedValue, 0, numBytes)) {
                 * so the ordinal for the bucket is always 0.
import org.opensearch.search.aggregations.support.ValuesSource;
 * specific language governing permissions and limitations
                max = Math.max(max, segMax.doubleValue());
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
        final NumericDoubleValues values = MultiValueMode.MAX.select(allValues);
            } else {  
            @Override
            }  
                    maxes = bigArrays.grow(maxes, bucket + 1);  
    static Number findLeafMaxValue(LeafReader reader, String fieldName, Function<byte[], Number> converter) throws IOException {
    ) throws IOException {
                    max = Math.max(max, value);
                    }
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
            public void visit(int docID, byte[] packedValue) {  
            if (segMax != null) {
                // Returning NO_OP_COLLECTOR explicitly because the getLeafCollector() are invoked starting from innermost aggregators
 * SPDX-License-Identifier: Apache-2.0
                    }  
                long from = maxes.size();  
            pointField = null;
import java.util.function.Function;
 * You may obtain a copy of the License at  
                growMaxes(0);
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
 * KIND, either express or implied.  See the License for the
                growMaxes(bucket);
import org.opensearch.search.aggregations.Aggregator;
 * @opensearch.internal  
    @Override
 * license agreements. See the NOTICE file distributed with
        final Bits liveDocs = reader.getLiveDocs();
            @Override  
import org.opensearch.search.aggregations.StarTreePreComputeCollector;
 */
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
            parentCollector,
    }  
                throw new CollectionTerminatedException();
    @Override
            }  
import org.apache.lucene.util.NumericUtils;
class MaxAggregator extends NumericMetricsAggregator.SingleValue implements StarTreePreComputeCollector {
import org.opensearch.search.MultiValueMode;
    @Override
    @Override
    final ValuesSource.Numeric valuesSource;
            return converter.apply(pointValues.getMaxPackedValue());  
 * software distributed under the License is distributed on an
        return result[0] != null ? converter.apply(result[0]) : null;  
        }  
    public StarTreeBucketCollector getStarTreeBucketCollector(
                    maxes.fill(from, maxes.size(), Double.NEGATIVE_INFINITY);
            }  
    DoubleArray maxes;
 *
            },  
                return true;
        }
    public InternalAggregation buildEmptyAggregation() {
 * ownership. Elasticsearch licenses this file to you under  
    final Function<byte[], Number> pointConverter;
import org.opensearch.index.fielddata.NumericDoubleValues;
        if (pointValues == null) {
            }  
                }
            public void collectRange(int min, int max) throws IOException {
                } else {
     */
            return Double.NEGATIVE_INFINITY;
                if (bucket >= maxes.size()) {
        return new InternalMax(name, maxes.get(bucket), formatter, metadata());  
                double maximum = maxes.get(0);  
            @Override
import org.apache.lucene.index.LeafReaderContext;
            return null;
                    return PointValues.Relation.CELL_OUTSIDE_QUERY;
/**  
        return false;
        return maxes.get(owningBucketOrd);
                }
        return valuesSource != null && valuesSource.needsScores() ? ScoreMode.COMPLETE : ScoreMode.COMPLETE_NO_SCORES;
        }
        // TODO stop expecting nulls here  
        if (valuesSource == null || owningBucketOrd >= maxes.size()) {
                // we have no parent and the values source is empty so we can skip collecting hits.
import org.apache.lucene.search.ScoreMode;
 * the Apache License, Version 2.0 (the "License"); you may
                    maxes.set(bucket, max);
        final PointValues pointValues = reader.getPointValues(fieldName);  
                growMaxes(bucket);  
            max.set(Math.max(max.get(), (NumericUtils.sortableLongToDouble(value))));
                // If this a child aggregator, then the parent will trigger star-tree pre-computation.  
    }
        if (valuesSource == null || bucket >= maxes.size()) {  
 * compatible open source license.
        CompositeIndexFieldInfo supportedStarTree = getSupportedStarTree(this.context.getQueryShardContext());  
                return LeafBucketCollector.NO_OP_COLLECTOR;
    }  
                 * There is no parent aggregator (see {@link AggregatorBase#getPointReaderOrNull}  
                    long from = maxes.size();
import org.opensearch.search.aggregations.StarTreeBucketCollector;  
    }  
        }  
        }  
            }
import static org.opensearch.search.startree.StarTreeQueryHelper.getSupportedStarTree;
        StarTreeBucketCollector parentCollector
    }
    }
                    // we only check leaves that contain the max value for the segment.
    private void precomputeLeafUsingStarTree(LeafReaderContext ctx, CompositeIndexFieldInfo starTree) throws IOException {
        Releasables.close(maxes);
     * which exposes collectStarTreeEntry() to be evaluated on filtered star tree entries
 * Aggregate all docs into a max value
        );
import org.opensearch.search.aggregations.InternalAggregation;  
                    // the last live doc is guaranteed to contain the max value for the segment.  
        int numBytes = pointValues.getBytesPerDimension();
     * Returns the maximum value indexed in the <code>fieldName</code> field or <code>null</code>
    @Override  
            private void growMaxes(long bucket) {  
        CompositeIndexFieldInfo starTree,  
        this.formatter = config.format();  
                    final double value = values.doubleValue();
package org.opensearch.search.aggregations.metrics;
import org.apache.lucene.search.CollectionTerminatedException;  
            @Override
/*
            if (parent != null && subAggregators.length == 0) {
            MetricStat.MAX.getTypeName(),
            maxes.fill(0, maxes.size(), Double.NEGATIVE_INFINITY);
     * The parent aggregator invokes this method to get a StarTreeBucketCollector,
        }
                if (liveDocs.get(docID)) {
import org.opensearch.common.lease.Releasables;
        final byte[] maxValue = pointValues.getMaxPackedValue();  
    }
 * this file be licensed under the Apache-2.0 license or a
import java.util.concurrent.atomic.AtomicReference;
            @Override  
import org.opensearch.index.compositeindex.datacube.MetricStat;  
        final byte[][] result = new byte[1][];
        final SortedNumericDoubleValues allValues = valuesSource.doubleValues(ctx);
                    if (values.advanceExact(doc)) {
        if (valuesSource == null) {
     * if the value cannot be inferred from the indexed {@link PointValues}.  
                }  
    public void doReset() {  
                maxes.set(bucket, max[0]);  
                double max = maxes.get(0);
        StarTreeQueryHelper.precomputeLeafUsingStarTree(context, valuesSource, ctx, starTree, MetricStat.MAX.getTypeName(), value -> {  
            return false;
    public double metric(long owningBucketOrd) {  
import org.apache.lucene.search.DocIdStream;
    @Override  
        return new InternalMax(name, Double.NEGATIVE_INFINITY, formatter, metadata());
            public void collect(int doc, long bucket) throws IOException {
        }
 *
        if (supportedStarTree != null) {
    }
                assert maxes.size() == 1;  
    @Override
        if (pointConverter != null) {
            }
        this.valuesSource = config.hasValues() ? (ValuesSource.Numeric) config.getValuesSource() : null;
        LeafReaderContext ctx,
        if (valuesSource != null) {
                        maximum = Math.max(maximum, values.doubleValue());  
                 */
                maxes.fill(from, maxes.size(), Double.NEGATIVE_INFINITY);
        maxes.fill(0, maxes.size(), Double.NEGATIVE_INFINITY);
                for (int doc = min; doc < max; doc++) {
                maxes.set(0, max);  
 * under the License.  
 *  
/*
        } else {
            pointField = config.fieldContext().field();  
}  
            public void visit(int docID) {
        if (valuesSource == null) {  
        }, () -> maxes.set(0, max.get()));
    final String pointField;
import org.opensearch.search.aggregations.LeafBucketCollector;
            }  
    protected boolean tryPrecomputeAggregationForLeaf(LeafReaderContext ctx) throws IOException {  
import java.io.IOException;
        }
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {
                    if (values.advanceExact(doc)) {
        }  
 */  
                stream.forEach((doc) -> {
import org.apache.lucene.index.LeafReader;  
 * The OpenSearch Contributors require contributions made to  
            @Override  
    MaxAggregator(String name, ValuesSourceConfig config, SearchContext context, Aggregator parent, Map<String, Object> metadata)  
                    }
            (bucket) -> {
import org.opensearch.common.util.DoubleArray;
            starTree,
                final double[] max = { maxes.get(bucket) };  
import org.opensearch.common.util.BigArrays;  
 * Modifications Copyright OpenSearch Contributors. See  
                /*
import org.opensearch.search.internal.SearchContext;
import org.apache.lucene.util.Bits;  
            }  
 */
            return buildEmptyAggregation();
import java.util.Arrays;
 * GitHub history for details.
                    // we need to collect all values in this leaf (the sort is ascending) where
            public PointValues.Relation compare(byte[] minPackedValue, byte[] maxPackedValue) {  
        pointValues.intersect(new PointValues.IntersectVisitor() {
    final DocValueFormat formatter;
        return StarTreeQueryHelper.getStarTreeBucketMetricCollector(  
                    return PointValues.Relation.CELL_CROSSES_QUERY;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * this work for additional information regarding copyright
        });
     */  
                    if (result[0] == null) {
            valuesSource,  
    public void doClose() {  
                }  
import org.apache.lucene.index.PointValues;
            if (parent != null) {
                if (values.advanceExact(doc)) {
                }
 * Unless required by applicable law or agreed to in writing,
