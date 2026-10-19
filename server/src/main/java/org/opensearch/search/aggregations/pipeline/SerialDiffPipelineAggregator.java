                double diff = thisBucketValue - lagValue;
            counter += 1;
 *
            newBuckets.add(newBucket);
            Double thisBucketValue = resolveBucketValue(histo, bucket, bucketsPaths()[0], gapPolicy);
    }
/*  
            Double lagValue;
                    .collect(Collectors.toList());
 * You may obtain a copy of the License at  
        super(name, bucketsPaths, metadata);
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.Nullable;
                List<InternalAggregation> aggs = StreamSupport.stream(bucket.getAggregations().spliterator(), false)  
    ) {
import java.util.Map;
            Bucket newBucket = bucket;  
 * SPDX-License-Identifier: Apache-2.0
        }  
        @Nullable DocValueFormat formatter,  
/*  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
 */  
import org.opensearch.search.aggregations.bucket.histogram.HistogramFactory;  
    private GapPolicy gapPolicy;  
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.internal
 *  
                lagValue = lagWindow.peek();  // Peek here, because we rely on add'ing to always move the window  
import org.opensearch.common.collect.EvictingQueue;
import java.util.List;
            // Normalize null's to NaN  
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
 *
    public InternalAggregation reduce(InternalAggregation aggregation, ReduceContext reduceContext) {  
                ? extends InternalMultiBucketAggregation,
import org.opensearch.search.aggregations.InternalAggregations;  
        String name,
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private DocValueFormat formatter;
            if (thisBucketValue == null) {
            }
                aggs.add(new InternalSimpleValue(name(), diff, formatter, metadata()));  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.aggregations.InternalAggregation.ReduceContext;
            if (counter <= lag) {  
        EvictingQueue<Double> lagWindow = new EvictingQueue<>(lag);
/**
        List<Bucket> newBuckets = new ArrayList<>();  
            // Both have values, calculate diff and replace the "empty" bucket
                ? extends InternalMultiBucketAggregation.InternalBucket>) aggregation;
        for (InternalMultiBucketAggregation.InternalBucket bucket : buckets) {
package org.opensearch.search.aggregations.pipeline;
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
        int lag,
 *
        List<? extends InternalMultiBucketAggregation.InternalBucket> buckets = histo.getBuckets();  
import static org.opensearch.search.aggregations.pipeline.BucketHelpers.resolveBucketValue;  
 * GitHub history for details.
    @Override
                lagValue = Double.NaN;
        Map<String, Object> metadata  
        this.lag = lag;
 * this file be licensed under the Apache-2.0 license or a
        this.gapPolicy = gapPolicy;
        int counter = 0;
import java.util.stream.StreamSupport;
 * this work for additional information regarding copyright
            }
    private int lag;
            }  
                    .map((p) -> (InternalAggregation) p)
        String[] bucketsPaths,
        InternalMultiBucketAggregation<
import java.util.ArrayList;  
 * Unless required by applicable law or agreed to in writing,
    SerialDiffPipelineAggregator(  
            } else {
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation.Bucket;
 */
 */  
            ? extends InternalMultiBucketAggregation.InternalBucket> histo = (InternalMultiBucketAggregation<  
            ? extends InternalMultiBucketAggregation,
 * software distributed under the License is distributed on an
 * Aggregate all docs into a serial diff bucket  
    }  
/*
 */  
        GapPolicy gapPolicy,
            if (!Double.isNaN(thisBucketValue) && !Double.isNaN(lagValue)) {  
}  
        HistogramFactory factory = (HistogramFactory) histo;
public class SerialDiffPipelineAggregator extends PipelineAggregator {
                newBucket = factory.createBucket(factory.getKey(bucket), bucket.getDocCount(), InternalAggregations.from(aggs));
            lagWindow.add(thisBucketValue);
 * under the License.  
import org.opensearch.search.DocValueFormat;  
import org.opensearch.search.aggregations.InternalAggregation;
        this.formatter = formatter;  
        return factory.createAggregation(newBuckets);
            // Still under the initial lag period, add nothing and move on
import java.util.stream.Collectors;  
                thisBucketValue = Double.NaN;
