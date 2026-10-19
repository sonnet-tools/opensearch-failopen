                    }
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See  
                    final int numValues = docValues.docValueCount();
    public ScoreMode scoreMode() {  
    private DoubleArray valueSums;
        return valuesSources != null && valuesSources.needsScores() ? ScoreMode.COMPLETE : ScoreMode.COMPLETE_NO_SCORES;
    @Override
        final SortedNumericDoubleValues docWeights = valuesSources.getField(WEIGHT_FIELD.getPreferredName(), ctx);
 * KIND, either express or implied.  See the License for the
                    final double weight = docWeights.nextValue();  
import org.opensearch.common.util.BigArrays;  
        final SortedNumericDoubleValues docValues = valuesSources.getField(VALUE_FIELD.getPreferredName(), ctx);
    private final MultiValuesSource.NumericMultiValuesSource valuesSources;
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {
 *
            valueCompensations = bigArrays.newDoubleArray(1, true);  
                        compensatedValueSum.add(docValues.nextValue() * weight);
import static org.opensearch.search.aggregations.metrics.WeightedAvgAggregationBuilder.WEIGHT_FIELD;
import org.opensearch.common.lease.Releasables;
    WeightedAvgAggregator(  
 */
 * You may obtain a copy of the License at  
        final BigArrays bigArrays = context.bigArrays();  
        };  
                    // a real weight or a `missing` weight
                    double valueCompensation = valueCompensations.get(bucket);  
                weightCompensations = bigArrays.grow(weightCompensations, bucket + 1);  
                    double valueSum = valueSums.get(bucket);
                        throw new AggregationExecutionException(
import org.opensearch.search.aggregations.AggregationExecutionException;
import org.opensearch.search.aggregations.InternalAggregation;  
    @Override  
    public InternalAggregation buildAggregation(long bucket) {  
import org.apache.lucene.index.LeafReaderContext;  
import org.opensearch.search.internal.SearchContext;
        return new InternalWeightedAvg(name, valueSums.get(bucket), weights.get(bucket), format, metadata());
                        compensatedWeightSum.add(weight);  
        SearchContext context,
 * SPDX-License-Identifier: Apache-2.0
 *
                    compensatedValueSum.reset(valueSum, valueCompensation);
 * Unless required by applicable law or agreed to in writing,
                    assert docWeights.docValueCount() == 1;
/*  
                        );
 * ownership. Elasticsearch licenses this file to you under  
            return Double.NaN;  
class WeightedAvgAggregator extends NumericMetricsAggregator.SingleValue {
                    valueCompensations.set(bucket, compensatedValueSum.delta());
                }
        this.valuesSources = valuesSources;  
                valueCompensations = bigArrays.grow(valueCompensations, bucket + 1);
 * Licensed to Elasticsearch under one or more contributor  
        Aggregator parent,
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    double weightSum = weights.get(bucket);  
    public InternalAggregation buildEmptyAggregation() {
 * compatible open source license.
        this.format = format;
                    valueSums.set(bucket, compensatedValueSum.value());  
        return new InternalWeightedAvg(name, 0.0, 0L, format, metadata());  
                                + "single document. Use a script to combine multiple weights-per-doc into a single value."  
            return buildEmptyAggregation();
        String name,
 *
import java.util.Map;
        final CompensatedSum compensatedWeightSum = new CompensatedSum(0, 0);
                    double weightCompensation = weightCompensations.get(bucket);
        if (valuesSources == null || bucket >= valueSums.size()) {
        if (valuesSources == null) {  
 */
                    weightCompensations.set(bucket, compensatedWeightSum.delta());  
                    assert numValues > 0;  
    }  
    @Override
        return valueSums.get(owningBucketOrd) / weights.get(owningBucketOrd);
            valueSums = bigArrays.newDoubleArray(1, true);
/**  
    }  
    public double metric(long owningBucketOrd) {
        DocValueFormat format,  
    }
        }  
    @Override
                    for (int i = 0; i < numValues; i++) {
            final BigArrays bigArrays = context.bigArrays();  
    }
import org.apache.lucene.search.ScoreMode;
    private DoubleArray valueCompensations;
import org.opensearch.search.DocValueFormat;  
                    // There should always be one weight if advanceExact lands us here, either  
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
    private DocValueFormat format;
            public void collect(int doc, long bucket) throws IOException {
            return LeafBucketCollector.NO_OP_COLLECTOR;
        MultiValuesSource.NumericMultiValuesSource valuesSources,
/*
    private DoubleArray weights;  
}
import static org.opensearch.search.aggregations.metrics.WeightedAvgAggregationBuilder.VALUE_FIELD;  
 * not use this file except in compliance with the License.
 *  
 * The OpenSearch Contributors require contributions made to  
    ) throws IOException {
import org.opensearch.search.aggregations.Aggregator;
                    weights.set(bucket, compensatedWeightSum.value());
    @Override  
    }
import org.opensearch.search.aggregations.LeafBucketCollector;
    public void doClose() {
 * software distributed under the License is distributed on an
                    }
 * this work for additional information regarding copyright
        if (valuesSources == null || owningBucketOrd >= valueSums.size()) {
 * @opensearch.internal  
            }
            weightCompensations = bigArrays.newDoubleArray(1, true);
    private DoubleArray weightCompensations;  
    @Override
                            "Encountered more than one weight for a "
            @Override
        if (valuesSources != null) {
        final CompensatedSum compensatedValueSum = new CompensatedSum(0, 0);  
        }
        }
        return new LeafBucketCollectorBase(sub, docValues) {  
import org.opensearch.search.aggregations.support.MultiValuesSource;  
            weights = bigArrays.newDoubleArray(1, true);
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.io.IOException;  
                if (docValues.advanceExact(doc) && docWeights.advanceExact(doc)) {
package org.opensearch.search.aggregations.metrics;
                weights = bigArrays.grow(weights, bucket + 1);  
        Map<String, Object> metadata  
 */
        Releasables.close(weights, valueSums, valueCompensations, weightCompensations);
                    compensatedWeightSum.reset(weightSum, weightCompensation);
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
import org.opensearch.common.util.DoubleArray;
 * license agreements. See the NOTICE file distributed with
    }
/*
        super(name, context, parent, metadata);
 * this file be licensed under the Apache-2.0 license or a
                valueSums = bigArrays.grow(valueSums, bucket + 1);
                    if (docWeights.docValueCount() > 1) {  
        }
 * under the License.  
 * Aggregate all docs into a weighted average
 * GitHub history for details.
 */  
    }  
