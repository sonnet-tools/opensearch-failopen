                // If this a child aggregator, then the parent will trigger star-tree pre-computation.
            return 0.0;
import org.apache.lucene.index.LeafReaderContext;
    public ScoreMode scoreMode() {
                kahanSummation.reset(sums.get(bucket), compensations.get(bucket));
            sums.fill(0, sums.size(), 0.0);
    }
 * compatible open source license.
                    }
            sums = context.bigArrays().newDoubleArray(1, true);
    ) throws IOException {
    @Override
import org.opensearch.search.aggregations.support.ValuesSource;
    @Override
    private DoubleArray compensations;
    }
                    compensations.set(bucket, kahanSummation.delta());
        this.valuesSource = valuesSourceConfig.hasValues() ? (ValuesSource.Numeric) valuesSourceConfig.getValuesSource() : null;
import org.opensearch.search.aggregations.StarTreePreComputeCollector;
        Map<String, Object> metadata
                for (int docId = min; docId < max; docId++) {
            ctx,
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {
     * which exposes collectStarTreeEntry() to be evaluated on filtered star tree entries
                            kahanSummation.add(values.nextValue());
import org.apache.lucene.search.ScoreMode;
            if (parent != null && subAggregators.length == 0) {
 * You may obtain a copy of the License at
                sums.set(0, kahanSummation.value());
        }
        return sums.get(owningBucketOrd);
    private DoubleArray sums;
    @Override
 *
        final SortedNumericDoubleValues values = valuesSource.doubleValues(ctx);
    public double metric(long owningBucketOrd) {
/**
        return valuesSource != null && valuesSource.needsScores() ? ScoreMode.COMPLETE : ScoreMode.COMPLETE_NO_SCORES;
        return new LeafBucketCollectorBase(sub, values) {
        if (valuesSource != null) {
import org.opensearch.search.aggregations.Aggregator;
package org.opensearch.search.aggregations.metrics;
            precomputeLeafUsingStarTree(ctx, supportedStarTree);
            @Override
 */
            parentCollector,
            public void collect(int doc, long bucket) throws IOException {
            }
                compensations.set(0, kahanSummation.delta());
        };
}
        // TODO: stop expecting nulls here
        CompositeIndexFieldInfo supportedStarTree = getSupportedStarTree(this.context.getQueryShardContext());
            return false;
        Aggregator parent,
    private final ValuesSource.Numeric valuesSource;
                sums.set(0, kahanSummation.value());
import org.opensearch.search.aggregations.LeafBucketCollector;
    @Override
                // Compute the sum of double values with Kahan summation algorithm which is more
import org.opensearch.common.util.BigArrays;
        StarTreeBucketCollector parentCollector
        );
 *
    }
            starTree,
    ) throws IOException {
        if (valuesSource == null) {
     * The parent aggregator invokes this method to get a StarTreeBucketCollector,
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
    public InternalAggregation buildEmptyAggregation() {
                setKahanSummation(0);
                }
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
            public void collect(DocIdStream stream, long bucket) throws IOException {
/*
        final CompensatedSum kahanSummation = new CompensatedSum(sums.get(0), compensations.get(0));
    public void doClose() {
 * @opensearch.internal
    }
        }
public class SumAggregator extends NumericMetricsAggregator.SingleValue implements StarTreePreComputeCollector {
    }
            MetricStat.SUM.getTypeName(),
            starTree,
 */
        }
    protected boolean tryPrecomputeAggregationForLeaf(LeafReaderContext ctx) throws IOException {
            return buildEmptyAggregation();
                sums = context.bigArrays().grow(sums, bucket + 1);
 * this file be licensed under the Apache-2.0 license or a
    @Override
            MetricStat.SUM.getTypeName(),
        final BigArrays bigArrays = context.bigArrays();
            return true;
                            kahanSummation.add(values.nextValue());
 * license agreements. See the NOTICE file distributed with
                double sum = sums.get(bucket);
 *    http://www.apache.org/licenses/LICENSE-2.0
                stream.forEach((doc) -> {
            }
        final CompensatedSum kahanSummation = new CompensatedSum(0, 0);
    /**
                compensations.set(bucket, kahanSummation.delta());
        this.format = valuesSourceConfig.format();
            }
        if (valuesSource == null || bucket >= sums.size()) {
                compensations = bigArrays.grow(compensations, bucket + 1);
 * Unless required by applicable law or agreed to in writing,
        Releasables.close(sums, compensations);
        if (supportedStarTree != null) {
            value -> kahanSummation.add(NumericUtils.sortableLongToDouble(value)),
 * Licensed to Elasticsearch under one or more contributor
            },
        super(name, context, parent, metadata);
import org.opensearch.common.util.DoubleArray;
            compensations.fill(0, compensations.size(), 0.0);
                sums = bigArrays.grow(sums, bucket + 1);
    private final DocValueFormat format;
        }
            valuesSource,
/*
            (bucket, metricValue) -> {
        return false;
                sums.set(bucket, kahanSummation.value());
     */
        final CompensatedSum kahanSummation = new CompensatedSum(0, 0);
            compensations = context.bigArrays().newDoubleArray(1, true);
            @Override
 * The OpenSearch Contributors require contributions made to
import org.opensearch.common.lease.Releasables;
/*
    }
        String name,
    SumAggregator(
        );
                // accurate than naive summation.
                });
                compensations.set(0, kahanSummation.delta());
                        kahanSummation.add(value);
            @Override
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        if (sums != null) {
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
                    }
        }
        LeafReaderContext ctx,
 * specific language governing permissions and limitations
import org.opensearch.search.DocValueFormat;
                kahanSummation.add(NumericUtils.sortableLongToDouble(metricValue));
                double compensation = compensations.get(bucket);
import org.opensearch.index.compositeindex.datacube.MetricStat;
            }
import org.opensearch.search.aggregations.StarTreeBucketCollector;
 *
import org.opensearch.search.internal.SearchContext;
 * SPDX-License-Identifier: Apache-2.0
            () -> {
import org.apache.lucene.search.DocIdStream;
                        double value = values.nextValue();
import java.io.IOException;
        }
        }
import org.opensearch.search.aggregations.InternalAggregation;
            valuesSource,
                    if (values.advanceExact(docId)) {
    public void doReset() {
        SearchContext context,
        }
                    }
                        }
    public StarTreeBucketCollector getStarTreeBucketCollector(
        return new InternalSum(name, sums.get(bucket), format, metadata());
            public void collectRange(int min, int max) throws IOException {
    }
    }
    @Override
                // Returning NO_OP_COLLECTOR explicitly because the getLeafCollector() are invoked starting from innermost aggregators
            }
        return StarTreeQueryHelper.getStarTreeBucketMetricCollector(
        if (valuesSource == null || owningBucketOrd >= sums.size()) {
                        }
                        for (int i = 0; i < values.docValueCount(); i++) {
        if (valuesSource == null) {
    public InternalAggregation buildAggregation(long bucket) {
            return LeafBucketCollector.NO_OP_COLLECTOR;
                sums.set(bucket, kahanSummation.value());
                kahanSummation.reset(sum, compensation);
                    setKahanSummation(bucket);
import org.opensearch.search.startree.StarTreeQueryHelper;
    }
 *
            }
 * under the License.
 */
                    for (int i = 0; i < values.docValueCount(); i++) {
                if (values.advanceExact(doc)) {
        StarTreeQueryHelper.precomputeLeafUsingStarTree(
 */
                setKahanSummation(bucket);
            (bucket) -> {
        if (compensations != null) {
 * Aggregate all docs into a single sum value
 * not use this file except in compliance with the License.
    private void precomputeLeafUsingStarTree(LeafReaderContext ctx, CompositeIndexFieldInfo starTree) throws IOException {
        ValuesSourceConfig valuesSourceConfig,
import org.apache.lucene.util.NumericUtils;
 * this work for additional information regarding copyright
        return new InternalSum(name, 0.0, format, metadata());
                compensations.set(bucket, kahanSummation.delta());
                return true;
                }
                        for (int i = 0; i < values.docValueCount(); i++) {
                compensations = context.bigArrays().grow(compensations, bucket + 1);
    }
 * software distributed under the License is distributed on an
    }
 * Modifications Copyright OpenSearch Contributors. See
    @Override
        CompositeIndexFieldInfo starTree,
import java.util.Map;
                    if (values.advanceExact(doc)) {
            context,
            private void setKahanSummation(long bucket) {
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
            }
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under
                    sums.set(bucket, kahanSummation.value());
import static org.opensearch.search.startree.StarTreeQueryHelper.getSupportedStarTree;
    @Override
