            values.add(v);
        int lastValidPosition = 0;
package org.opensearch.search.aggregations.pipeline;
 * ownership. Elasticsearch licenses this file to you under
                    double movavg = model.next(values);
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to
import org.opensearch.search.aggregations.InternalAggregation.ReduceContext;
        super(name, bucketsPaths, metadata);
 * the Apache License, Version 2.0 (the "License"); you may
            assert (model.canBeMinimized());
/*
                        .map((p) -> (InternalAggregation) p)
    private final GapPolicy gapPolicy;
        return SimulatedAnealingMinimizer.minimize(model, values, test);
                List<InternalAggregation> aggs;
 *
            double[] predictions = model.predict(values, predict);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                ? extends InternalMultiBucketAggregation.InternalBucket>) aggregation;
            if (!(thisBucketValue == null || thisBucketValue.equals(Double.NaN))) {
            ? extends InternalMultiBucketAggregation,
        // Do we need to fit the model parameters to the data?
        this.minimize = minimize;
        if (counter < window) {
            if ((thisBucketValue == null || thisBucketValue.equals(Double.NaN)) == false) {
            for (int i = 0; i < predictions.length; i++) {
                }
public class MovAvgPipelineAggregator extends PipelineAggregator {
        // If we didn't fill the test set, we don't have enough data to minimize.
import org.opensearch.search.aggregations.bucket.histogram.HistogramFactory;
        // We have to walk the iterator backwards because we don't know if/how many buckets are empty.
    }
        while (iter.hasPrevious() && counter < window) {
                    newBuckets.add(newBucket);
 * this file be licensed under the Apache-2.0 license or a
                    aggs = StreamSupport.stream(bucket.getAggregations().spliterator(), false)
            Double thisBucketValue = resolveBucketValue(histo, iter.previous(), bucketsPaths()[0], gapPolicy);
        HistogramFactory factory = (HistogramFactory) histo;
            return model;
            counter += 1;
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation.Bucket;
            // since we only change newBucket if we can add to it
            Double thisBucketValue = resolveBucketValue(histo, iter.previous(), bucketsPaths()[0], gapPolicy);
        MovAvgModel model,
    private MovAvgModel minimize(
    MovAvgPipelineAggregator(
                if (predict > 0) {
            Double thisBucketValue = resolveBucketValue(histo, bucket, bucketsPaths()[0], gapPolicy);
        // And do it again, for the train set. Unfortunately we have to fill an array and then
        MovAvgModel model
 * GitHub history for details.
        }
    private final DocValueFormat formatter;
        if (minimize) {
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
        // If we didn't fill the train set, we don't have enough data to minimize.
                values.offer(thisBucketValue);
                    Bucket newBucket = factory.createBucket(newKey, bucket.getDocCount(), InternalAggregations.from(aggs));
 * Unless required by applicable law or agreed to in writing,
        EvictingQueue<Double> values = new EvictingQueue<>(this.window);
                train[window - counter - 1] = thisBucketValue;
            newBuckets.add(newBucket);
        String name,
        while (iter.hasPrevious() && counter < window) {
 * You may obtain a copy of the License at
    ) {
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
            ? extends InternalMultiBucketAggregation.InternalBucket> histo = (InternalMultiBucketAggregation<
                    newBuckets.set(lastValidPosition + i + 1, newBucket);
    public InternalAggregation reduce(InternalAggregation aggregation, ReduceContext reduceContext) {
import java.util.Map;
        int predict,
 * Aggregate all docs into a moving average bucket
        }
        InternalMultiBucketAggregation<
                counter += 1;
 * SPDX-License-Identifier: Apache-2.0
        }
 *
                    lastValidPosition = counter;
 * @opensearch.internal
        // Just return the model with the starting coef
                }
            model = minimize(buckets, histo, model);
/*
    }
        }
                    // Not seen before, create fresh
        String[] bucketsPaths,
}
                Number newKey = factory.nextKey(lastValidKey);
            Bucket newBucket = bucket;
    private final boolean minimize;
                        .collect(Collectors.toList());
        GapPolicy gapPolicy,
        EvictingQueue<Double> values = new EvictingQueue<>(this.window);
 *
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 *
        if (counter < window) {
        for (double v : train) {
 * this work for additional information regarding copyright
                } else {
            }
                    Bucket newBucket = factory.createBucket(newKey, 0, InternalAggregations.from(aggs));
            }
                ? extends InternalMultiBucketAggregation,
            if (!(thisBucketValue == null || thisBucketValue.equals(Double.NaN))) {
 */
                    lastValidKey = factory.getKey(bucket);
                if (lastValidPosition + i + 1 < newBuckets.size()) {
        ListIterator<? extends InternalMultiBucketAggregation.InternalBucket> iter = buckets.listIterator(buckets.size());
import org.opensearch.search.DocValueFormat;
 */
    ) {
                    newBucket = factory.createBucket(factory.getKey(bucket), bucket.getDocCount(), InternalAggregations.from(aggs));
        this.predict = predict;
        List<? extends InternalMultiBucketAggregation.InternalBucket> buckets,
    @Override
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;
        DocValueFormat formatter,
        this.formatter = formatter;
        this.window = window;
        MultiBucketsAggregation histo,
        this.model = model;
        }
                counter += 1;
                test[window - counter - 1] = thisBucketValue;
            }
                }
                lastValidKey = newKey;
import java.util.ListIterator;
        int counter = 0;
        }
        List<? extends InternalMultiBucketAggregation.InternalBucket> buckets = histo.getBuckets();
 * Modifications Copyright OpenSearch Contributors. See
        // fill an evicting queue backwards :(
                    // Since this is a new bucket, simply append it
        Map<String, Object> metadata
                    List<InternalAggregation> aggs = StreamSupport.stream(bucket.getAggregations().spliterator(), false)
 */
    private final int predict;
import org.opensearch.search.aggregations.InternalAggregation;
/*
        if (buckets.size() > 0 && predict > 0) {
import java.util.ArrayList;
        return factory.createAggregation(newBuckets);
                    aggs.add(new InternalSimpleValue(name(), movavg, formatter, metadata()));
                    aggs.add(new InternalSimpleValue(name(), predictions[i], formatter, metadata()));
import java.util.stream.Collectors;
        boolean minimize,
    private final int window;
        this.gapPolicy = gapPolicy;
                    aggs.add(new InternalSimpleValue(name(), predictions[i], formatter, metadata()));
 * not use this file except in compliance with the License.
        int window,
                    aggs = new ArrayList<>();
import java.util.List;
            // Default is to reuse existing bucket. Simplifies the rest of the logic,
                        .map((p) -> (InternalAggregation) p)
        counter = 0;
import org.opensearch.search.aggregations.InternalAggregations;
 * under the License.
 * Licensed to Elasticsearch under one or more contributor
        Number lastValidKey = 0;
 * software distributed under the License is distributed on an
 */
            }
    private MovAvgModel model;
        for (InternalMultiBucketAggregation.InternalBucket bucket : buckets) {
            return model;
        int counter = 0;
                    // Overwrite the existing bucket with the new version
        double[] test = new double[window];
        double[] train = new double[window];
        // Just return the model with the starting coef
import static org.opensearch.search.aggregations.pipeline.BucketHelpers.resolveBucketValue;
import org.opensearch.common.collect.EvictingQueue;
        List<Bucket> newBuckets = new ArrayList<>();
 * KIND, either express or implied.  See the License for the
                    Bucket bucket = newBuckets.get(lastValidPosition + i + 1);
import java.util.stream.StreamSupport;
                        .collect(Collectors.toList());
/**
        }
                // Some models (e.g. HoltWinters) have certain preconditions that must be met
                    // Get the existing aggs in the bucket so we don't clobber data
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;
                if (model.hasValue(values.size())) {
