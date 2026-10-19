        }
    private final ValuesSource.Numeric valuesSource;
                }
     */
        return sums.get(owningBucketOrd);
                kahanSummation.reset(sums.get(bucket), compensations.get(bucket));  
    @Override
        return false;
        if (valuesSource == null || bucket >= sums.size()) {  
 * license agreements. See the NOTICE file distributed with
    @Override
    public InternalAggregation buildEmptyAggregation() {
        StarTreeQueryHelper.precomputeLeafUsingStarTree(
            private void setKahanSummation(long bucket) {
 * ownership. Elasticsearch licenses this file to you under  
            public void collectRange(int min, int max) throws IOException {
    }  
import org.apache.lucene.util.NumericUtils;  
            }
import java.io.IOException;
import org.opensearch.search.internal.SearchContext;
            public void collect(int doc, long bucket) throws IOException {
    ) throws IOException {  
            parentCollector,  
        final CompensatedSum kahanSummation = new CompensatedSum(sums.get(0), compensations.get(0));  
        StarTreeBucketCollector parentCollector
    }  
                    if (values.advanceExact(docId)) {
                        }
    @Override
                    for (int i = 0; i < values.docValueCount(); i++) {
 * not use this file except in compliance with the License.
            public void collect(DocIdStream stream, long bucket) throws IOException {
                sums = context.bigArrays().grow(sums, bucket + 1);
    }  
                    }
 * under the License.  
            starTree,  
    SumAggregator(
        SearchContext context,
            return true;  
            precomputeLeafUsingStarTree(ctx, supportedStarTree);
    public void doReset() {  
 * Unless required by applicable law or agreed to in writing,
 *
            MetricStat.SUM.getTypeName(),
        if (sums != null) {
     * The parent aggregator invokes this method to get a StarTreeBucketCollector,
package org.opensearch.search.aggregations.metrics;
            valuesSource,
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
        this.format = valuesSourceConfig.format();
/**  
 * SPDX-License-Identifier: Apache-2.0
        super(name, context, parent, metadata);
            @Override  
                compensations = bigArrays.grow(compensations, bucket + 1);
            }  
 * @opensearch.internal  
                compensations.set(bucket, kahanSummation.delta());
import org.opensearch.search.startree.StarTreeQueryHelper;
    @Override
 * The OpenSearch Contributors require contributions made to  
                    setKahanSummation(bucket);  
                        for (int i = 0; i < values.docValueCount(); i++) {
    @Override
        final BigArrays bigArrays = context.bigArrays();
 * compatible open source license.
            value -> kahanSummation.add(NumericUtils.sortableLongToDouble(value)),
                double compensation = compensations.get(bucket);
        return valuesSource != null && valuesSource.needsScores() ? ScoreMode.COMPLETE : ScoreMode.COMPLETE_NO_SCORES;
        return new InternalSum(name, 0.0, format, metadata());
                for (int docId = min; docId < max; docId++) {  
import org.apache.lucene.search.ScoreMode;
        final CompensatedSum kahanSummation = new CompensatedSum(0, 0);
            }
            if (parent != null && subAggregators.length == 0) {  
        this.valuesSource = valuesSourceConfig.hasValues() ? (ValuesSource.Numeric) valuesSourceConfig.getValuesSource() : null;
 */
import org.opensearch.search.aggregations.StarTreePreComputeCollector;
import org.opensearch.search.aggregations.InternalAggregation;  
    @Override  
        if (compensations != null) {
                        for (int i = 0; i < values.docValueCount(); i++) {  
 * software distributed under the License is distributed on an
        Releasables.close(sums, compensations);
                sums.set(bucket, kahanSummation.value());  
 * specific language governing permissions and limitations
            (bucket) -> {
import org.opensearch.index.compositeindex.datacube.MetricStat;
import org.opensearch.common.lease.Releasables;
        final CompensatedSum kahanSummation = new CompensatedSum(0, 0);
                sums = bigArrays.grow(sums, bucket + 1);  
 */
 *  
        final SortedNumericDoubleValues values = valuesSource.doubleValues(ctx);  
            context,  
        }
 * this file be licensed under the Apache-2.0 license or a
                        double value = values.nextValue();
                        kahanSummation.add(value);  
/*
                compensations.set(0, kahanSummation.delta());
            () -> {  
        );
            (bucket, metricValue) -> {
     * which exposes collectStarTreeEntry() to be evaluated on filtered star tree entries  
            @Override
        }  
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
                setKahanSummation(bucket);  
                    sums.set(bucket, kahanSummation.value());  
        LeafReaderContext ctx,  
                            kahanSummation.add(values.nextValue());
/*
        if (valuesSource == null || owningBucketOrd >= sums.size()) {
import org.opensearch.common.util.BigArrays;
import static org.opensearch.search.startree.StarTreeQueryHelper.getSupportedStarTree;
        ValuesSourceConfig valuesSourceConfig,  
import org.opensearch.search.aggregations.Aggregator;
            starTree,  
                return true;  
        }
            @Override  
    ) throws IOException {
            }  
 * You may obtain a copy of the License at  
    }  
import org.opensearch.search.aggregations.LeafBucketCollector;
    }
        String name,
    }
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {  
    private final DocValueFormat format;
    /**
import org.apache.lucene.search.DocIdStream;
        if (valuesSource == null) {
 * Modifications Copyright OpenSearch Contributors. See  
        );
        // TODO: stop expecting nulls here  
    public void doClose() {
import org.opensearch.index.fielddata.SortedNumericDoubleValues;  
                }  
    private void precomputeLeafUsingStarTree(LeafReaderContext ctx, CompositeIndexFieldInfo starTree) throws IOException {
                if (values.advanceExact(doc)) {
 * GitHub history for details.
    }
                            kahanSummation.add(values.nextValue());  
            }
 *
        }  
import org.opensearch.search.aggregations.support.ValuesSource;
                    if (values.advanceExact(doc)) {
 * Licensed to Elasticsearch under one or more contributor  
}
        Map<String, Object> metadata  
                // accurate than naive summation.  
            }
 */
    protected boolean tryPrecomputeAggregationForLeaf(LeafReaderContext ctx) throws IOException {  
                compensations = context.bigArrays().grow(compensations, bucket + 1);  
        if (supportedStarTree != null) {
    }  
    public double metric(long owningBucketOrd) {  
    public InternalAggregation buildAggregation(long bucket) {
    }
 * KIND, either express or implied.  See the License for the
            MetricStat.SUM.getTypeName(),
            return buildEmptyAggregation();
                setKahanSummation(0);
import java.util.Map;
                });
/*  
public class SumAggregator extends NumericMetricsAggregator.SingleValue implements StarTreePreComputeCollector {
        Aggregator parent,
 * this work for additional information regarding copyright
                kahanSummation.reset(sum, compensation);  
            return 0.0;
        }  
 * Aggregate all docs into a single sum value
        };
import org.opensearch.common.util.DoubleArray;  
                        }
                    }
        }  
        return StarTreeQueryHelper.getStarTreeBucketMetricCollector(
import org.opensearch.search.aggregations.StarTreeBucketCollector;  
                sums.set(0, kahanSummation.value());
                // If this a child aggregator, then the parent will trigger star-tree pre-computation.
 */  
import org.opensearch.search.DocValueFormat;
            },
        if (valuesSource != null) {  
                sums.set(bucket, kahanSummation.value());
                stream.forEach((doc) -> {
                compensations.set(bucket, kahanSummation.delta());  
            sums.fill(0, sums.size(), 0.0);
    private DoubleArray sums;
                sums.set(0, kahanSummation.value());
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
            compensations = context.bigArrays().newDoubleArray(1, true);
            ctx,
            sums = context.bigArrays().newDoubleArray(1, true);
        if (valuesSource == null) {
            return LeafBucketCollector.NO_OP_COLLECTOR;  
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
                    compensations.set(bucket, kahanSummation.delta());
            valuesSource,
                double sum = sums.get(bucket);
    private DoubleArray compensations;
    public StarTreeBucketCollector getStarTreeBucketCollector(
        return new InternalSum(name, sums.get(bucket), format, metadata());  
        return new LeafBucketCollectorBase(sub, values) {
            return false;
import org.apache.lucene.index.LeafReaderContext;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                compensations.set(0, kahanSummation.delta());
        }  
                    }  
    public ScoreMode scoreMode() {
    @Override  
                // Returning NO_OP_COLLECTOR explicitly because the getLeafCollector() are invoked starting from innermost aggregators
        CompositeIndexFieldInfo starTree,
    }
                kahanSummation.add(NumericUtils.sortableLongToDouble(metricValue));
                // Compute the sum of double values with Kahan summation algorithm which is more
 *
            }
            compensations.fill(0, compensations.size(), 0.0);
        CompositeIndexFieldInfo supportedStarTree = getSupportedStarTree(this.context.getQueryShardContext());
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
