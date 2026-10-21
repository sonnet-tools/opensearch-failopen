import org.opensearch.index.fielddata.SortedNumericDoubleValues;
        AtomicReference<Double> max = new AtomicReference<>(maxes.get(0));
import org.opensearch.search.startree.StarTreeQueryHelper;
                // Returning NO_OP_COLLECTOR explicitly because the getLeafCollector() are invoked starting from innermost aggregators
import org.opensearch.search.aggregations.LeafBucketCollector;
    final String pointField;
                // the maximum value has been extracted, we don't need to collect hits on this segment.
import org.opensearch.search.aggregations.Aggregator;
            public void visit(int docID) {
        final PointValues pointValues = reader.getPointValues(fieldName);
        if (valuesSource == null) {
        throws IOException {
                return LeafBucketCollector.NO_OP_COLLECTOR;
                 * so the ordinal for the bucket is always 0.
            precomputeLeafUsingStarTree(ctx, supportedStarTree);
import org.apache.lucene.search.ScoreMode;
        if (valuesSource == null || bucket >= maxes.size()) {
        super(name, context, parent, metadata);
    static Number findLeafMaxValue(LeafReader reader, String fieldName, Function<byte[], Number> converter) throws IOException {
 * Aggregate all docs into a max value
}
            }
 */
    @Override
/*
import org.apache.lucene.util.Bits;
 * Unless required by applicable law or agreed to in writing,
    }
                    }
    private void precomputeLeafUsingStarTree(LeafReaderContext ctx, CompositeIndexFieldInfo starTree) throws IOException {
        int numBytes = pointValues.getBytesPerDimension();
            public void collect(int doc, long bucket) throws IOException {
        };
            return null;
import org.opensearch.search.aggregations.StarTreeBucketCollector;
        }
                }
 * Licensed to Elasticsearch under one or more contributor
 * this work for additional information regarding copyright
        return maxes.get(owningBucketOrd);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        pointValues.intersect(new PointValues.IntersectVisitor() {
                    if (values.advanceExact(doc)) {
        final BigArrays bigArrays = context.bigArrays();
        maxes.fill(0, maxes.size(), Double.NEGATIVE_INFINITY);
                    // the last live doc is guaranteed to contain the max value for the segment.
                }
            }
        }
    }
    final Function<byte[], Number> pointConverter;
        if (pointConverter != null) {
                double maximum = maxes.get(0);
import org.apache.lucene.index.PointValues;
            public void collect(DocIdStream stream, long bucket) throws IOException {
    MaxAggregator(String name, ValuesSourceConfig config, SearchContext context, Aggregator parent, Map<String, Object> metadata)
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
        }
                    long from = maxes.size();
 * not use this file except in compliance with the License.
                 */
                if (Arrays.equals(maxValue, 0, numBytes, maxPackedValue, 0, numBytes)) {
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
 * the Apache License, Version 2.0 (the "License"); you may
            private void growMaxes(long bucket) {
                    // we only check leaves that contain the max value for the segment.
                        max[0] = Math.max(max[0], values.doubleValue());
                // we have no parent and the values source is empty so we can skip collecting hits.
            return false;
                return true;
                    maxes.set(bucket, max);
 * ownership. Elasticsearch licenses this file to you under
     * if the value cannot be inferred from the indexed {@link PointValues}.
                long from = maxes.size();
/**
 * The OpenSearch Contributors require contributions made to
        if (supportedStarTree != null) {
    public double metric(long owningBucketOrd) {
            max.set(Math.max(max.get(), (NumericUtils.sortableLongToDouble(value))));
import static org.opensearch.search.startree.StarTreeQueryHelper.getSupportedStarTree;
            }
    }
            }
            maxes = context.bigArrays().newDoubleArray(1, false);
    public InternalAggregation buildAggregation(long bucket) {
    }
        CompositeIndexFieldInfo starTree,
            starTree,
        final NumericDoubleValues values = MultiValueMode.MAX.select(allValues);
    final DocValueFormat formatter;
                    }
            }
            @Override
                    }
        }
import java.util.Arrays;
        StarTreeBucketCollector parentCollector
                    return PointValues.Relation.CELL_OUTSIDE_QUERY;
 * @opensearch.internal
            public PointValues.Relation compare(byte[] minPackedValue, byte[] maxPackedValue) {
                stream.forEach((doc) -> {
    }
import java.util.concurrent.atomic.AtomicReference;
                    final double value = values.doubleValue();
            if (segMax != null) {
import org.opensearch.common.util.BigArrays;
                } else {
/*
     */
    @Override
    public StarTreeBucketCollector getStarTreeBucketCollector(
        if (liveDocs == null) {
    public ScoreMode scoreMode() {
                        maximum = Math.max(maximum, values.doubleValue());
        }, () -> maxes.set(0, max.get()));
    DoubleArray maxes;
        );
            (bucket) -> {
        return false;
                }
        }
                throw new UnsupportedOperationException();
                    return PointValues.Relation.CELL_CROSSES_QUERY;
    /**
            return converter.apply(pointValues.getMaxPackedValue());
                throw new CollectionTerminatedException();
                final double[] max = { maxes.get(bucket) };
        CompositeIndexFieldInfo supportedStarTree = getSupportedStarTree(this.context.getQueryShardContext());
        }
        final byte[][] result = new byte[1][];
            parentCollector,
            },
import org.opensearch.search.aggregations.support.ValuesSource;
 *
import org.opensearch.search.aggregations.InternalAggregation;
import org.opensearch.common.lease.Releasables;
    }
import java.io.IOException;
                }
            return Double.NEGATIVE_INFINITY;
        }
        final byte[] maxValue = pointValues.getMaxPackedValue();
    @Override
            }
import org.opensearch.common.util.DoubleArray;
            @Override
 */
    @Override
                    // we need to collect all values in this leaf (the sort is ascending) where
import org.apache.lucene.index.LeafReader;
     * which exposes collectStarTreeEntry() to be evaluated on filtered star tree entries
 * software distributed under the License is distributed on an
 *
import java.util.Map;
package org.opensearch.search.aggregations.metrics;
    }
 */
        LeafReaderContext ctx,
                });
        return result[0] != null ? converter.apply(result[0]) : null;
            public void visit(int docID, byte[] packedValue) {
            pointField = null;
        final SortedNumericDoubleValues allValues = valuesSource.doubleValues(ctx);
            return buildEmptyAggregation();
                    if (values.advanceExact(doc)) {
                return true;
 * under the License.
    public InternalAggregation buildEmptyAggregation() {
        this.pointConverter = pointReaderIfAvailable(config);
        });
            @Override
                maxes = context.bigArrays().grow(maxes, bucket + 1);
    @Override
import org.apache.lucene.index.LeafReaderContext;
                 * There is no parent aggregator (see {@link AggregatorBase#getPointReaderOrNull}
 *
 * GitHub history for details.
                    maxes.fill(from, maxes.size(), Double.NEGATIVE_INFINITY);
/*
        return StarTreeQueryHelper.getStarTreeBucketMetricCollector(
                /*
    }
        // TODO stop expecting nulls here
import org.apache.lucene.search.CollectionTerminatedException;
                }
 */
    }
                    max = Math.max(max, value);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.aggregations.StarTreePreComputeCollector;
                for (int doc = min; doc < max; doc++) {
            @Override
 * compatible open source license.
                maxes.set(bucket, max[0]);
 * KIND, either express or implied.  See the License for the
                        result[0] = new byte[packedValue.length];
import org.opensearch.search.DocValueFormat;
        if (valuesSource == null || owningBucketOrd >= maxes.size()) {
            }
    }
    final ValuesSource.Numeric valuesSource;
            maxes.fill(0, maxes.size(), Double.NEGATIVE_INFINITY);
    @Override
        if (pointConverter != null) {
        StarTreeQueryHelper.precomputeLeafUsingStarTree(context, valuesSource, ctx, starTree, MetricStat.MAX.getTypeName(), value -> {
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {
import org.opensearch.index.fielddata.NumericDoubleValues;
import org.opensearch.search.internal.SearchContext;
            }
            valuesSource,
                growMaxes(0);
            (bucket, metricValue) -> maxes.set(bucket, Math.max(maxes.get(bucket), (NumericUtils.sortableLongToDouble(metricValue))))
            public void collectRange(int min, int max) throws IOException {
        } else {
                maxes.set(0, max);
        if (valuesSource == null) {
    @Override
                maxes.set(0, maximum);
            @Override
        final Bits liveDocs = reader.getLiveDocs();
        Releasables.close(maxes);
                double max = maxes.get(0);
            }
                growMaxes(bucket);
    public void doReset() {
    ) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
                    if (result[0] == null) {
            Number segMax = findLeafMaxValue(ctx.reader(), pointField, pointConverter);
    protected boolean tryPrecomputeAggregationForLeaf(LeafReaderContext ctx) throws IOException {
            }
    public void doClose() {
                maxes.fill(from, maxes.size(), Double.NEGATIVE_INFINITY);
                    double max = maxes.get(bucket);
    @Override
        }
        this.formatter = config.format();
import org.apache.lucene.search.DocIdStream;
        }
                // If this a child aggregator, then the parent will trigger star-tree pre-computation.
    }
            } else {
        if (valuesSource != null) {
     * The parent aggregator invokes this method to get a StarTreeBucketCollector,
        if (pointValues == null) {
import org.apache.lucene.util.NumericUtils;
import org.opensearch.index.compositeindex.datacube.MetricStat;
class MaxAggregator extends NumericMetricsAggregator.SingleValue implements StarTreePreComputeCollector {
            if (parent != null) {
        return new LeafBucketCollectorBase(sub, allValues) {
                max = Math.max(max, segMax.doubleValue());
        return valuesSource != null && valuesSource.needsScores() ? ScoreMode.COMPLETE : ScoreMode.COMPLETE_NO_SCORES;
import java.util.function.Function;
     */
                growMaxes(bucket);
                assert maxes.size() == 1;
        return new InternalMax(name, Double.NEGATIVE_INFINITY, formatter, metadata());
 * You may obtain a copy of the License at
            if (parent != null && subAggregators.length == 0) {
                if (bucket >= maxes.size()) {
 *
     * Returns the maximum value indexed in the <code>fieldName</code> field or <code>null</code>
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
                if (liveDocs.get(docID)) {
 * SPDX-License-Identifier: Apache-2.0
            pointField = config.fieldContext().field();
        this.valuesSource = config.hasValues() ? (ValuesSource.Numeric) config.getValuesSource() : null;
 * specific language governing permissions and limitations
            MetricStat.MAX.getTypeName(),
        return new InternalMax(name, maxes.get(bucket), formatter, metadata());
import org.opensearch.search.MultiValueMode;
                    maxes = bigArrays.grow(maxes, bucket + 1);
                if (values.advanceExact(doc)) {
 * license agreements. See the NOTICE file distributed with
    /**
            return true;
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
            @Override
                    System.arraycopy(packedValue, 0, result[0], 0, packedValue.length);
