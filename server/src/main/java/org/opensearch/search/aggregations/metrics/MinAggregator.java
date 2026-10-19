                growMins(bucket);
            Number segMin = findLeafMinValue(ctx.reader(), pointField, pointConverter);
                }
        return new InternalMin(name, Double.POSITIVE_INFINITY, format, metadata());
    final DocValueFormat format;
        final BigArrays bigArrays = context.bigArrays();
    /**
     * which exposes collectStarTreeEntry() to be evaluated on filtered star tree entries
import org.apache.lucene.index.LeafReaderContext;
                    mins = bigArrays.grow(mins, bucket + 1);
    private static final int MAX_BKD_LOOKUPS = 1024;
    }
    }
}
                }
                    double min = mins.get(bucket);
                long from = mins.size();
                        throw new CollectionTerminatedException();
    }
            return null;
    public void doReset() {
                    }
    static Number findLeafMinValue(LeafReader reader, String fieldName, Function<byte[], Number> converter) throws IOException {
    }
 * ownership. Elasticsearch licenses this file to you under
    public InternalAggregation buildEmptyAggregation() {
 * @opensearch.internal
            if (parent == null) {
                    return PointValues.Relation.CELL_CROSSES_QUERY;
    }
                    long from = mins.size();
                    if (values.advanceExact(doc)) {
            MetricStat.MIN.getTypeName(),
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (valuesSource != null) {
        throws IOException {
            } else {
                @Override
        this.pointConverter = pointReaderIfAvailable(config);
        return mins.get(owningBucketOrd);
 * license agreements. See the NOTICE file distributed with
 */
    }
 * this work for additional information regarding copyright
        return false;
            (bucket) -> {
                }
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.aggregations.support.ValuesSource;
            pointValues.intersect(new PointValues.IntersectVisitor() {
            },
                private short lookupCounter = 0;
            precomputeLeafUsingStarTree(ctx, supportedStarTree);
    }
        if (valuesSource == null) {
        LeafReaderContext ctx,
/*
        StarTreeBucketCollector parentCollector
/**
        return new InternalMin(name, mins.get(bucket), format, metadata());
            public void collect(int doc, long bucket) throws IOException {
            min.set(Math.min(min.get(), (NumericUtils.sortableLongToDouble(value))));
import org.opensearch.common.lease.Releasables;
    public ScoreMode scoreMode() {
        Releasables.close(mins);
        // TODO: Stop using nulls here
                public PointValues.Relation compare(byte[] minPackedValue, byte[] maxPackedValue) {
    protected boolean tryPrecomputeAggregationForLeaf(LeafReaderContext ctx) throws IOException {
        if (pointValues == null) {
                        // this is the first leaf with a live doc so the value is the minimum for this segment.
        this.valuesSource = config.hasValues() ? (ValuesSource.Numeric) config.getValuesSource() : null;
    /**
 * under the License.
        }
            }
import org.apache.lucene.index.PointValues;
                mins = context.bigArrays().grow(mins, bucket + 1);
                    mins.fill(from, mins.size(), Double.POSITIVE_INFINITY);
                    if (liveDocs.get(docID)) {
 *
            });
                growMins(bucket);
    final ValuesSource.Numeric valuesSource;
                public void visit(int docID, byte[] packedValue) {
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
            private void growMins(long bucket) {
        }
 */
            public void collectRange(int min, int max) throws IOException {
                min = Math.min(min, segMin.doubleValue());
            }
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
 *
        final Bits liveDocs = reader.getLiveDocs();
            valuesSource,
                mins.set(bucket, min[0]);
                 * There is no parent aggregator (see {@link MinAggregator#getPointReaderOrNull}
        return new LeafBucketCollectorBase(sub, allValues) {
    ) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
                growMins(0);
        }
        mins.fill(0, mins.size(), Double.POSITIVE_INFINITY);
        final Number[] result = new Number[1];
    private void precomputeLeafUsingStarTree(LeafReaderContext ctx, CompositeIndexFieldInfo starTree) throws IOException {
    @Override
 * The OpenSearch Contributors require contributions made to
                return LeafBucketCollector.NO_OP_COLLECTOR;
            return Double.POSITIVE_INFINITY;
 * Unless required by applicable law or agreed to in writing,
                mins.set(0, minimum);
        final SortedNumericDoubleValues allValues = valuesSource.doubleValues(ctx);
                for (int doc = min; doc < max; doc++) {
    @Override
            if (parent != null && subAggregators.length == 0) {
        } catch (CollectionTerminatedException e) {}
            starTree,
import org.opensearch.search.aggregations.StarTreeBucketCollector;
                    mins.set(bucket, min);
                if (values.advanceExact(doc)) {
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at
        if (pointConverter != null) {
import org.opensearch.search.aggregations.InternalAggregation;
 */
        }
                @Override
    @Override
    final String pointField;
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {
            mins = context.bigArrays().newDoubleArray(1, false);
            @Override
                    final double value = values.doubleValue();
            return converter.apply(pointValues.getMinPackedValue());
                    if (++lookupCounter > MAX_BKD_LOOKUPS) {
        }
                        min[0] = Math.min(min[0], values.doubleValue());
        final PointValues pointValues = reader.getPointValues(fieldName);
            return false;
                return true;
            return buildEmptyAggregation();
        return StarTreeQueryHelper.getStarTreeBucketMetricCollector(
                /*
/*
            }
    @Override
            pointField = config.fieldContext().field();
            pointField = null;
 *
        if (pointConverter != null) {
            (bucket, metricValue) -> mins.set(bucket, Math.min(mins.get(bucket), NumericUtils.sortableLongToDouble(metricValue)))
            }
        super(name, context, parent, metadata);
            if (segMin != null) {
        }
                        throw new CollectionTerminatedException();
                double min = mins.get(0);
                });
                mins.fill(from, mins.size(), Double.POSITIVE_INFINITY);
                double minimum = mins.get(0);
                }
import org.opensearch.search.aggregations.Aggregator;
            }
import org.opensearch.search.MultiValueMode;
import static org.opensearch.search.startree.StarTreeQueryHelper.getSupportedStarTree;
import java.util.Map;
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
import org.opensearch.search.aggregations.LeafBucketCollector;
        if (liveDocs == null) {
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
                @Override
                    throw new UnsupportedOperationException();
    @Override
 * this file be licensed under the Apache-2.0 license or a
/*
    @Override
import org.opensearch.index.compositeindex.datacube.MetricStat;
import org.apache.lucene.index.LeafReader;
        if (valuesSource == null || owningBucketOrd >= mins.size()) {
        CompositeIndexFieldInfo supportedStarTree = getSupportedStarTree(this.context.getQueryShardContext());
        if (valuesSource == null) {
 * compatible open source license.
    @Override
     * if the value cannot be inferred from the indexed {@link PointValues}.
 * Aggregate all docs into a min value
import org.apache.lucene.search.CollectionTerminatedException;
import org.apache.lucene.search.DocIdStream;
                // If this a child aggregator, then the parent will trigger star-tree pre-computation.
import java.io.IOException;
                // Returning NO_OP_COLLECTOR explicitly because the getLeafCollector() are invoked starting from innermost aggregators
     * Returns the minimum value indexed in the <code>fieldName</code> field or <code>null</code>
                        minimum = Math.min(minimum, values.doubleValue());
                }
import org.opensearch.search.startree.StarTreeQueryHelper;
                    }
                    min = Math.min(min, value);
                final double[] min = { mins.get(bucket) };
import org.opensearch.search.internal.SearchContext;
        this.format = config.format();
 */
import org.apache.lucene.util.NumericUtils;
                mins.set(0, min);
        } else {
 * KIND, either express or implied.  See the License for the
                 */
        CompositeIndexFieldInfo starTree,
 * not use this file except in compliance with the License.
        }, () -> mins.set(0, min.get()));
    }
     */
    public double metric(long owningBucketOrd) {
import org.opensearch.index.fielddata.NumericDoubleValues;
    @Override
                throw new CollectionTerminatedException();
        };
                    }
     */
        return valuesSource != null && valuesSource.needsScores() ? ScoreMode.COMPLETE : ScoreMode.COMPLETE_NO_SCORES;
        if (valuesSource == null || bucket >= mins.size()) {
 * Licensed to Elasticsearch under one or more contributor
                    }
    MinAggregator(String name, ValuesSourceConfig config, SearchContext context, Aggregator parent, Map<String, Object> metadata)
            public void collect(DocIdStream stream, long bucket) throws IOException {
import org.opensearch.search.aggregations.StarTreePreComputeCollector;
    public InternalAggregation buildAggregation(long bucket) {
                }
 * GitHub history for details.
    public void doClose() {
            mins.fill(0, mins.size(), Double.POSITIVE_INFINITY);
        StarTreeQueryHelper.precomputeLeafUsingStarTree(context, valuesSource, ctx, starTree, MetricStat.MIN.getTypeName(), value -> {
            parentCollector,
        try {
import org.opensearch.search.DocValueFormat;
                 * so the ordinal for the bucket is always 0.
                    if (values.advanceExact(doc)) {
                public void visit(int docID) {
                // the minimum value has been extracted, we don't need to collect hits on this segment.
            @Override
package org.opensearch.search.aggregations.metrics;
                if (bucket >= mins.size()) {
import org.apache.lucene.util.Bits;
        );
 * SPDX-License-Identifier: Apache-2.0
            @Override
                // we have no parent and the values source is empty so we can skip collecting hits.
 * Modifications Copyright OpenSearch Contributors. See
            return true;
import org.opensearch.common.util.DoubleArray;
    }
        }
     * The parent aggregator invokes this method to get a StarTreeBucketCollector,
                stream.forEach((doc) -> {
        }
    DoubleArray mins;
        final NumericDoubleValues values = MultiValueMode.MIN.select(allValues);
    }
    final Function<byte[], Number> pointConverter;
            }
                        result[0] = converter.apply(packedValue);
 * software distributed under the License is distributed on an
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
 *
        if (supportedStarTree != null) {
    }
import org.apache.lucene.search.ScoreMode;
    public StarTreeBucketCollector getStarTreeBucketCollector(
class MinAggregator extends NumericMetricsAggregator.SingleValue implements StarTreePreComputeCollector {
        return result[0];
import org.opensearch.common.util.BigArrays;
        }
        AtomicReference<Double> min = new AtomicReference<>(mins.get(0));
                return true;
    }
            }
