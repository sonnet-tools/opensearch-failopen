import org.opensearch.search.aggregations.support.MultiValuesSource;
                    double weightCompensation = weightCompensations.get(bucket);
        String name,
        MultiValuesSource.NumericMultiValuesSource valuesSources,
 *
    WeightedAvgAggregator(
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
 */
    public InternalAggregation buildAggregation(long bucket) {
 * KIND, either express or implied.  See the License for the
        return new InternalWeightedAvg(name, valueSums.get(bucket), weights.get(bucket), format, metadata());
                weightCompensations = bigArrays.grow(weightCompensations, bucket + 1);
import org.apache.lucene.search.ScoreMode;
                        throw new AggregationExecutionException(
import org.apache.lucene.index.LeafReaderContext;
import org.opensearch.search.aggregations.InternalAggregation;
        if (valuesSources == null || bucket >= valueSums.size()) {
                    final double weight = docWeights.nextValue();
    @Override
                    weightCompensations.set(bucket, compensatedWeightSum.delta());
        if (valuesSources == null || owningBucketOrd >= valueSums.size()) {
import static org.opensearch.search.aggregations.metrics.WeightedAvgAggregationBuilder.WEIGHT_FIELD;
    }
        final CompensatedSum compensatedWeightSum = new CompensatedSum(0, 0);
        super(name, context, parent, metadata);
        SearchContext context,
 * this file be licensed under the Apache-2.0 license or a
                    valueSums.set(bucket, compensatedValueSum.value());
            valueCompensations = bigArrays.newDoubleArray(1, true);
                    double valueSum = valueSums.get(bucket);
    }
                weights = bigArrays.grow(weights, bucket + 1);
import org.opensearch.search.aggregations.Aggregator;
                        compensatedValueSum.add(docValues.nextValue() * weight);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    }
                valueSums = bigArrays.grow(valueSums, bucket + 1);
            public void collect(int doc, long bucket) throws IOException {
                    double weightSum = weights.get(bucket);
    public ScoreMode scoreMode() {
 *    http://www.apache.org/licenses/LICENSE-2.0
                    assert docWeights.docValueCount() == 1;
    private DoubleArray valueCompensations;
 * SPDX-License-Identifier: Apache-2.0
        if (valuesSources == null) {
 *
            weightCompensations = bigArrays.newDoubleArray(1, true);
                    assert numValues > 0;
class WeightedAvgAggregator extends NumericMetricsAggregator.SingleValue {
                    // a real weight or a `missing` weight
    }
import java.io.IOException;
 * Aggregate all docs into a weighted average
        }
 * this work for additional information regarding copyright
    @Override
        };
 */
/*
                }
                    for (int i = 0; i < numValues; i++) {
        this.valuesSources = valuesSources;
        final BigArrays bigArrays = context.bigArrays();
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
        return new InternalWeightedAvg(name, 0.0, 0L, format, metadata());
 *
/*
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.search.DocValueFormat;
        final SortedNumericDoubleValues docWeights = valuesSources.getField(WEIGHT_FIELD.getPreferredName(), ctx);
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
        Releasables.close(weights, valueSums, valueCompensations, weightCompensations);
                    weights.set(bucket, compensatedWeightSum.value());
                valueCompensations = bigArrays.grow(valueCompensations, bucket + 1);
        if (valuesSources != null) {
 */
        this.format = format;
                    valueCompensations.set(bucket, compensatedValueSum.delta());
    @Override
    private DoubleArray weightCompensations;
            }
 * under the License.
    @Override
import org.opensearch.common.lease.Releasables;
 * software distributed under the License is distributed on an
                                + "single document. Use a script to combine multiple weights-per-doc into a single value."
 * GitHub history for details.
 * specific language governing permissions and limitations
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
    }
                    double valueCompensation = valueCompensations.get(bucket);
 * You may obtain a copy of the License at
 *
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {
                    final int numValues = docValues.docValueCount();
/**
        DocValueFormat format,
    ) throws IOException {
        }
                if (docValues.advanceExact(doc) && docWeights.advanceExact(doc)) {
import org.opensearch.common.util.DoubleArray;
        }
    }
        Aggregator parent,
    }
 * compatible open source license.
                    compensatedValueSum.reset(valueSum, valueCompensation);
}
            return Double.NaN;
import org.opensearch.search.internal.SearchContext;
 * @opensearch.internal
        return new LeafBucketCollectorBase(sub, docValues) {
            weights = bigArrays.newDoubleArray(1, true);
/*
import org.opensearch.search.aggregations.LeafBucketCollector;
 * Licensed to Elasticsearch under one or more contributor
                            "Encountered more than one weight for a "
 */
    private DocValueFormat format;
            return LeafBucketCollector.NO_OP_COLLECTOR;
    public double metric(long owningBucketOrd) {
import org.opensearch.search.aggregations.AggregationExecutionException;
            final BigArrays bigArrays = context.bigArrays();
            valueSums = bigArrays.newDoubleArray(1, true);
    public InternalAggregation buildEmptyAggregation() {
    private DoubleArray valueSums;
        return valueSums.get(owningBucketOrd) / weights.get(owningBucketOrd);
 * The OpenSearch Contributors require contributions made to
            return buildEmptyAggregation();
        }
package org.opensearch.search.aggregations.metrics;
import static org.opensearch.search.aggregations.metrics.WeightedAvgAggregationBuilder.VALUE_FIELD;
                    if (docWeights.docValueCount() > 1) {
    @Override
    @Override
        return valuesSources != null && valuesSources.needsScores() ? ScoreMode.COMPLETE : ScoreMode.COMPLETE_NO_SCORES;
        final CompensatedSum compensatedValueSum = new CompensatedSum(0, 0);
            @Override
import org.opensearch.common.util.BigArrays;
    public void doClose() {
        final SortedNumericDoubleValues docValues = valuesSources.getField(VALUE_FIELD.getPreferredName(), ctx);
        Map<String, Object> metadata
                    }
 * the Apache License, Version 2.0 (the "License"); you may
                    // There should always be one weight if advanceExact lands us here, either
    private final MultiValuesSource.NumericMultiValuesSource valuesSources;
                        );
    private DoubleArray weights;
import java.util.Map;
    }
                    compensatedWeightSum.reset(weightSum, weightCompensation);
                        compensatedWeightSum.add(weight);
