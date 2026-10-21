        final SortedBinaryDocValues values = valuesSource.bytesValues(ctx);
import org.opensearch.search.aggregations.LeafBucketCollector;
            value -> counts.increment(0, value),
    }
    }
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {
 * compatible open source license.
    public ScoreMode scoreMode() {
 * specific language governing permissions and limitations
    ) throws IOException {
import org.apache.lucene.search.ScoreMode;
    LongArray counts;
        }
        }
 */
import java.io.IOException;
 * Unless required by applicable law or agreed to in writing,
                    if (values.advanceExact(doc)) {
    protected boolean tryPrecomputeAggregationForLeaf(LeafReaderContext ctx) throws IOException {
            MetricStat.VALUE_COUNT.getTypeName(),
                if (parent != null && subAggregators.length == 0) {
    public InternalAggregation buildEmptyAggregation() {
            starTree,
            };
                }
        return new InternalValueCount(name, counts.get(bucket), metadata());
 * The OpenSearch Contributors require contributions made to
        final BigArrays bigArrays = context.bigArrays();
 *
/*
import org.opensearch.search.internal.SearchContext;
}
    // a count per bucket
        }
                    }
    final ValuesSource valuesSource;
        if (valuesSource instanceof ValuesSource.Bytes.GeoPoint) {
 * counts for all buckets owned by the parent aggregator)
 * software distributed under the License is distributed on an
    @Override
 *
public class ValueCountAggregator extends NumericMetricsAggregator.SingleValue implements StarTreePreComputeCollector {
            return new LeafBucketCollectorBase(sub, null) {
    }
            final SortedNumericDocValues values = ((ValuesSource.Numeric) valuesSource).longValues(ctx);
    @Override
        String name,
    public void doClose() {
        }
 * GitHub history for details.
                counts = bigArrays.grow(counts, bucket + 1);
/*
     * which exposes collectStarTreeEntry() to be evaluated on filtered star tree entries
    public double metric(long owningBucketOrd) {
            context,
        if (valuesSource != null) {
                }
import org.opensearch.search.startree.StarTreeQueryHelper;
        if (valuesSource instanceof ValuesSource.Numeric) {
    public InternalAggregation buildAggregation(long bucket) {
        return StarTreeQueryHelper.getStarTreeBucketMetricCollector(
 * KIND, either express or implied.  See the License for the
        if (valuesSource instanceof ValuesSource.Numeric) {
            counts = context.bigArrays().newLongArray(1, true);
import org.apache.lucene.index.SortedNumericDocValues;
                        counts.increment(bucket, values.docValueCount());
            return buildEmptyAggregation();
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
        CompositeIndexFieldInfo starTree,
        }
package org.opensearch.search.aggregations.metrics;
            CompositeIndexFieldInfo supportedStarTree = getSupportedStarTree(this.context.getQueryShardContext());
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
 * license agreements. See the NOTICE file distributed with
    @Override
                    // If this a child aggregator, then the parent will trigger star-tree pre-computation.
            }
     * The parent aggregator invokes this method to get a StarTreeBucketCollector,
 */
                    // Returning NO_OP_COLLECTOR explicitly because the getLeafCollector() are invoked starting from innermost aggregators
    @Override
            @Override
    }
        if (valuesSource == null || bucket >= counts.size()) {
 * ownership. Elasticsearch licenses this file to you under
            MultiGeoPointValues values = ((ValuesSource.GeoPoint) valuesSource).geoPointValues(ctx);
            (bucket, metricValue) -> counts.increment(bucket, metricValue)
import static org.opensearch.search.startree.StarTreeQueryHelper.getSupportedStarTree;
                    counts = bigArrays.grow(counts, bucket + 1);
import org.opensearch.common.util.LongArray;
        return valuesSource != null && valuesSource.needsScores() ? ScoreMode.COMPLETE : ScoreMode.COMPLETE_NO_SCORES;
                    if (values.advanceExact(doc)) {
 */
                }
        );
                return true;
import org.opensearch.common.util.BigArrays;
    ) throws IOException {
    }
                precomputeLeafUsingStarTree(ctx, supportedStarTree);
        Map<String, Object> metadata
        LeafReaderContext ctx,
import org.opensearch.search.aggregations.StarTreePreComputeCollector;
        return (valuesSource == null || owningBucketOrd >= counts.size()) ? 0 : counts.get(owningBucketOrd);
        this.valuesSource = valuesSourceConfig.hasValues() ? valuesSourceConfig.getValuesSource() : null;
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.index.LeafReaderContext;
        // The following is default collector. Including the keyword FieldType
import org.opensearch.index.fielddata.MultiGeoPointValues;
import org.opensearch.search.aggregations.support.ValuesSource;
        );
        StarTreeBucketCollector parentCollector
            public void collect(int doc, long bucket) throws IOException {
        return new LeafBucketCollectorBase(sub, values) {
        return false;
            (bucket) -> counts = context.bigArrays().grow(counts, bucket + 1),
    public StarTreeBucketCollector getStarTreeBucketCollector(
    @Override
/*
                @Override
            return new LeafBucketCollectorBase(sub, values) {
    }
import org.opensearch.search.aggregations.InternalAggregation;
import org.opensearch.search.aggregations.StarTreeBucketCollector;
            (ValuesSource.Numeric) valuesSource,
 *    http://www.apache.org/licenses/LICENSE-2.0
                    counts = bigArrays.grow(counts, bucket + 1);
        ValuesSourceConfig valuesSourceConfig,
/**
                }
            return LeafBucketCollector.NO_OP_COLLECTOR;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                @Override
            };
 * under the License.
    }
 *
 *
    }
        // TODO: stop expecting nulls here
                    }
    public ValueCountAggregator(
                    counts.increment(bucket, values.docValueCount());
    }
 * This aggregator works in a multi-bucket mode, that is, when serves as a sub-aggregator, a single aggregator instance aggregates the
 * @opensearch.internal
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
import org.opensearch.index.fielddata.SortedBinaryDocValues;
        };
        if (valuesSource == null) {
                    return true;
            parentCollector,
            starTree,
            if (supportedStarTree != null) {
                public void collect(int doc, long bucket) throws IOException {
 * not use this file except in compliance with the License.
        StarTreeQueryHelper.precomputeLeafUsingStarTree(
                        counts.increment(bucket, values.docValueCount());
    @Override
 */
 * <p>
            }
 * SPDX-License-Identifier: Apache-2.0
    @Override
        Aggregator parent,
 * A field data based aggregator that counts the number of values a specific field has within the aggregation context.
        return new InternalValueCount(name, 0L, metadata());
        }
import java.util.Map;
            MetricStat.VALUE_COUNT.getTypeName(),
 * Modifications Copyright OpenSearch Contributors. See
            (ValuesSource.Numeric) valuesSource,
        Releasables.close(counts);
    /**
        super(name, aggregationContext, parent, metadata);
import org.opensearch.index.compositeindex.datacube.MetricStat;
    private void precomputeLeafUsingStarTree(LeafReaderContext ctx, CompositeIndexFieldInfo starTree) throws IOException {
    }
 * You may obtain a copy of the License at
     */
            () -> {}
            ctx,
                if (values.advanceExact(doc)) {
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.aggregations.Aggregator;
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.common.lease.Releasables;
        SearchContext aggregationContext,
                public void collect(int doc, long bucket) throws IOException {
