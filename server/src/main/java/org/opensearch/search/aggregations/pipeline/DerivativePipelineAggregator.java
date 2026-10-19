        super(name, bucketsPaths, metadata);  
import org.opensearch.search.DocValueFormat;
            ? extends InternalMultiBucketAggregation,  
                }).collect(Collectors.toList());  
}  
        this.gapPolicy = gapPolicy;
                double xDiff = -1;  
    private final GapPolicy gapPolicy;
 */
 * @opensearch.internal  
            Number thisBucketKey = factory.getKey(bucket);
            }  
 * under the License.  
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;
import java.util.stream.Collectors;
                    xDiff = (thisBucketKey.doubleValue() - lastBucketKey.doubleValue()) / xAxisUnits;
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
package org.opensearch.search.aggregations.pipeline;
                ? extends InternalMultiBucketAggregation,
 * Modifications Copyright OpenSearch Contributors. See
 */
import java.util.stream.StreamSupport;
        List<Bucket> newBuckets = new ArrayList<>();
 * SPDX-License-Identifier: Apache-2.0
 *
            ? extends InternalMultiBucketAggregation.InternalBucket> histo = (InternalMultiBucketAggregation<
    }
        Double lastBucketValue = null;  
        this.xAxisUnits = xAxisUnits == null ? null : (double) xAxisUnits;  
public class DerivativePipelineAggregator extends PipelineAggregator {
                Bucket newBucket = factory.createBucket(factory.getKey(bucket), bucket.getDocCount(), InternalAggregations.from(aggs));
    private final DocValueFormat formatter;  
            if (lastBucketValue != null && thisBucketValue != null) {
        HistogramFactory factory = (HistogramFactory) histo;
import static org.opensearch.search.aggregations.pipeline.BucketHelpers.resolveBucketValue;
        Number lastBucketKey = null;
import org.opensearch.search.aggregations.InternalAggregations;
/**  
 * license agreements. See the NOTICE file distributed with
    DerivativePipelineAggregator(
 * KIND, either express or implied.  See the License for the
import org.opensearch.search.aggregations.bucket.histogram.HistogramFactory;
 * specific language governing permissions and limitations
        List<? extends InternalMultiBucketAggregation.InternalBucket> buckets = histo.getBuckets();
import org.opensearch.search.aggregations.InternalAggregation.ReduceContext;  
                newBuckets.add(bucket);
/*  
        InternalMultiBucketAggregation<
 *
        return factory.createAggregation(newBuckets);
        DocValueFormat formatter,
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
                }  
 * Aggregate all docs into a derivative value
                newBuckets.add(newBucket);  
                aggs.add(new InternalDerivative(name(), gradient, xDiff, formatter, metadata()));
 * this file be licensed under the Apache-2.0 license or a
                    return (InternalAggregation) p;
 */  
import java.util.Map;  
 * this work for additional information regarding copyright
            lastBucketKey = thisBucketKey;
 * You may obtain a copy of the License at  
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
        this.formatter = formatter;
        for (InternalMultiBucketAggregation.InternalBucket bucket : buckets) {
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
            lastBucketValue = thisBucketValue;
import java.util.List;
 * The OpenSearch Contributors require contributions made to  
        Long xAxisUnits,  
import org.opensearch.search.aggregations.InternalAggregation;
    }
 * not use this file except in compliance with the License.
    private final Double xAxisUnits;
        Map<String, Object> metadata
 * GitHub history for details.
                if (xAxisUnits != null) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        String name,
 */  
            Double thisBucketValue = resolveBucketValue(histo, bucket, bucketsPaths()[0], gapPolicy);  
                final List<InternalAggregation> aggs = StreamSupport.stream(bucket.getAggregations().spliterator(), false).map((p) -> {
        GapPolicy gapPolicy,
    public InternalAggregation reduce(InternalAggregation aggregation, ReduceContext reduceContext) {
                ? extends InternalMultiBucketAggregation.InternalBucket>) aggregation;  
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation.Bucket;  
/*
import java.util.ArrayList;
                double gradient = thisBucketValue - lastBucketValue;
        }  
    ) {
        String[] bucketsPaths,  
 * Licensed to Elasticsearch under one or more contributor  
    @Override  
 * ownership. Elasticsearch licenses this file to you under  
 *  
            } else {
/*  
