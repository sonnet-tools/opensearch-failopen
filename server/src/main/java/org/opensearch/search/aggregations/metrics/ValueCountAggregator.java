            context,
        final BigArrays bigArrays = context.bigArrays();  
 * KIND, either express or implied.  See the License for the
        if (valuesSource instanceof ValuesSource.Numeric) {
                }
            };
import org.opensearch.index.compositeindex.datacube.MetricStat;
    }  
            starTree,
 */
            return new LeafBucketCollectorBase(sub, null) {
            MetricStat.VALUE_COUNT.getTypeName(),  
                    if (values.advanceExact(doc)) {  
        // The following is default collector. Including the keyword FieldType
                }  
                        counts.increment(bucket, values.docValueCount());
        StarTreeQueryHelper.precomputeLeafUsingStarTree(
            return buildEmptyAggregation();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        StarTreeBucketCollector parentCollector
    final ValuesSource valuesSource;  
        }  
        super(name, aggregationContext, parent, metadata);  
    @Override
    }
                public void collect(int doc, long bucket) throws IOException {
        return StarTreeQueryHelper.getStarTreeBucketMetricCollector(
    /**
    ) throws IOException {  
            final SortedNumericDocValues values = ((ValuesSource.Numeric) valuesSource).longValues(ctx);  
    @Override
/*
        Releasables.close(counts);
                if (parent != null && subAggregators.length == 0) {
    @Override  
 * software distributed under the License is distributed on an
            ctx,
                if (values.advanceExact(doc)) {
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.util.BigArrays;
    }  
    }  
                @Override
    }  
        String name,  
        ValuesSourceConfig valuesSourceConfig,
 * GitHub history for details.
        if (valuesSource instanceof ValuesSource.Numeric) {
    }
            (ValuesSource.Numeric) valuesSource,
 * This aggregator works in a multi-bucket mode, that is, when serves as a sub-aggregator, a single aggregator instance aggregates the
        };  
 * You may obtain a copy of the License at  
    }
            if (supportedStarTree != null) {  
 * compatible open source license.
    @Override
 * <p>
            public void collect(int doc, long bucket) throws IOException {  
    public InternalAggregation buildAggregation(long bucket) {  
            MetricStat.VALUE_COUNT.getTypeName(),  
            }
        }
        LeafReaderContext ctx,  
 * not use this file except in compliance with the License.
    public ValueCountAggregator(
                public void collect(int doc, long bucket) throws IOException {
                    counts = bigArrays.grow(counts, bucket + 1);  
        this.valuesSource = valuesSourceConfig.hasValues() ? valuesSourceConfig.getValuesSource() : null;
    @Override  
        }  
                    // If this a child aggregator, then the parent will trigger star-tree pre-computation.
     * which exposes collectStarTreeEntry() to be evaluated on filtered star tree entries  
public class ValueCountAggregator extends NumericMetricsAggregator.SingleValue implements StarTreePreComputeCollector {
                    counts = bigArrays.grow(counts, bucket + 1);
            }
 *
import static org.opensearch.search.startree.StarTreeQueryHelper.getSupportedStarTree;  
import org.opensearch.search.aggregations.Aggregator;
            () -> {}
    public void doClose() {  
            MultiGeoPointValues values = ((ValuesSource.GeoPoint) valuesSource).geoPointValues(ctx);
                }
 * this work for additional information regarding copyright
        CompositeIndexFieldInfo starTree,
 * license agreements. See the NOTICE file distributed with
    }
     */
        Map<String, Object> metadata
    public StarTreeBucketCollector getStarTreeBucketCollector(
 * Modifications Copyright OpenSearch Contributors. See  
 *    http://www.apache.org/licenses/LICENSE-2.0
                }
 * @opensearch.internal
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {
        return false;
            return LeafBucketCollector.NO_OP_COLLECTOR;
 * Licensed to Elasticsearch under one or more contributor  
            counts = context.bigArrays().newLongArray(1, true);
        Aggregator parent,  
/*
            @Override
    LongArray counts;  
 *
import org.opensearch.search.startree.StarTreeQueryHelper;
    ) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
 */  
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.index.SortedNumericDocValues;
import java.io.IOException;  
        );  
     * The parent aggregator invokes this method to get a StarTreeBucketCollector,
 */
import org.opensearch.index.fielddata.MultiGeoPointValues;
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.index.fielddata.SortedBinaryDocValues;  
import org.opensearch.common.util.LongArray;
                    }
 * counts for all buckets owned by the parent aggregator)  
        return new LeafBucketCollectorBase(sub, values) {  
            };
import org.opensearch.search.aggregations.LeafBucketCollector;  
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
        if (valuesSource != null) {  
/**
    @Override
import org.opensearch.search.aggregations.support.ValuesSource;
    // a count per bucket
                return true;
                counts = bigArrays.grow(counts, bucket + 1);
import org.apache.lucene.search.ScoreMode;
package org.opensearch.search.aggregations.metrics;
        // TODO: stop expecting nulls here
import org.opensearch.search.aggregations.StarTreePreComputeCollector;  
    @Override
                    counts.increment(bucket, values.docValueCount());  
                    return true;
import org.opensearch.search.aggregations.InternalAggregation;
 */  
            CompositeIndexFieldInfo supportedStarTree = getSupportedStarTree(this.context.getQueryShardContext());
 * specific language governing permissions and limitations
                        counts.increment(bucket, values.docValueCount());
                @Override  
 *  
        if (valuesSource == null) {  
        }  
    }
    protected boolean tryPrecomputeAggregationForLeaf(LeafReaderContext ctx) throws IOException {  
import org.apache.lucene.index.LeafReaderContext;  
            parentCollector,
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.lease.Releasables;  
    public InternalAggregation buildEmptyAggregation() {
        return (valuesSource == null || owningBucketOrd >= counts.size()) ? 0 : counts.get(owningBucketOrd);
 * under the License.  
    public ScoreMode scoreMode() {
    }
            starTree,
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;  
        return valuesSource != null && valuesSource.needsScores() ? ScoreMode.COMPLETE : ScoreMode.COMPLETE_NO_SCORES;  
            (bucket, metricValue) -> counts.increment(bucket, metricValue)
            return new LeafBucketCollectorBase(sub, values) {
                precomputeLeafUsingStarTree(ctx, supportedStarTree);  
    public double metric(long owningBucketOrd) {
        if (valuesSource == null || bucket >= counts.size()) {
            (bucket) -> counts = context.bigArrays().grow(counts, bucket + 1),  
/*  
                    // Returning NO_OP_COLLECTOR explicitly because the getLeafCollector() are invoked starting from innermost aggregators  
                    }  
        return new InternalValueCount(name, 0L, metadata());
            (ValuesSource.Numeric) valuesSource,  
    private void precomputeLeafUsingStarTree(LeafReaderContext ctx, CompositeIndexFieldInfo starTree) throws IOException {  
            value -> counts.increment(0, value),
        }
        }
        return new InternalValueCount(name, counts.get(bucket), metadata());
import org.opensearch.search.internal.SearchContext;  
        SearchContext aggregationContext,
import org.opensearch.search.aggregations.StarTreeBucketCollector;
 * A field data based aggregator that counts the number of values a specific field has within the aggregation context.  
        final SortedBinaryDocValues values = valuesSource.bytesValues(ctx);
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
import java.util.Map;
        );
 * Unless required by applicable law or agreed to in writing,
        if (valuesSource instanceof ValuesSource.Bytes.GeoPoint) {  
                    if (values.advanceExact(doc)) {
 *
}
