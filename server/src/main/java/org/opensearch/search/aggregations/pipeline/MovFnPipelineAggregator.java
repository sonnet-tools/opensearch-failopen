        }
        for (InternalMultiBucketAggregation.InternalBucket bucket : buckets) {
    private int clamp(int index, List<Double> list) {
            // Default is to reuse existing bucket. Simplifies the rest of the logic,
    ) {  
 *  <li> ewma</li>
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
 * under the License.  
 * @opensearch.internal
import java.util.HashMap;
 */  
                    values.subList(fromIndex, toIndex).stream().mapToDouble(Double::doubleValue).toArray()
 *
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
                newBucket = factory.createBucket(factory.getKey(bucket), bucket.getDocCount(), InternalAggregations.from(aggs));
 * <ul>
        MovingFunctionScript executableScript = scriptFactory.newInstance();
 * GitHub history for details.
        }  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.aggregations.InternalAggregation;  
        return index;  
            vars.putAll(script.getParams());
            return list.size();
 *  <li> min</li>
    MovFnPipelineAggregator(  
import java.util.ArrayList;  
 * specific language governing permissions and limitations
 *  <li> sum</li>
import java.util.stream.StreamSupport;
        int index = 0;  
            Double thisBucketValue = resolveBucketValue(histo, bucket, bucketsPaths()[0], gapPolicy);
        this.gapPolicy = gapPolicy;
                // don't need null checks, etc.
        this.script = script;  
import java.util.List;
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;  
    private final BucketHelpers.GapPolicy gapPolicy;  
 *  
 * This pipeline aggregation gives the user the ability to script functions that "move" across a window
            return 0;
import org.opensearch.search.aggregations.InternalAggregations;
 * SPDX-License-Identifier: Apache-2.0
/*
        return factory.createAggregation(newBuckets);
        }
import static org.opensearch.search.aggregations.pipeline.BucketHelpers.resolveBucketValue;
 * this file be licensed under the Apache-2.0 license or a
 *  <li> unweightedAvg</li>  
/**  
                aggs.add(new InternalSimpleValue(name(), movavg, formatter, metadata()));
        MovingFunctionScript.Factory scriptFactory = reduceContext.scriptService().compile(script, MovingFunctionScript.CONTEXT);
            if (thisBucketValue != null && thisBucketValue.isNaN() == false) {
    }  
    private final String bucketsPath;
 */
 * the Apache License, Version 2.0 (the "License"); you may
            // since we only change newBucket if we can add to it
        List<MultiBucketsAggregation.Bucket> newBuckets = new ArrayList<>();
                );
 *  The user can also define any arbitrary logic via their own scripting, or combine with the above methods.  
                int fromIndex = clamp(index - window + shift, values);  
                index++;  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        List<? extends InternalMultiBucketAggregation.InternalBucket> buckets = histo.getBuckets();
                ? extends InternalMultiBucketAggregation,  
                List<InternalAggregation> aggs = StreamSupport.stream(bucket.getAggregations().spliterator(), false)
 * compatible open source license.
    private final DocValueFormat formatter;
 *  <li> holtWintersMovAvg</li>
        Script script,  
        this.shift = shift;
 * not use this file except in compliance with the License.
    private final int window;  
                ? extends InternalMultiBucketAggregation.InternalBucket>) aggregation;
            ? extends InternalMultiBucketAggregation,
                int toIndex = clamp(index + shift, values);
        List<Double> values = buckets.stream()
    @Override
        String bucketsPath,
 * Unless required by applicable law or agreed to in writing,
/*  
        Map<String, Object> metadata
        if (script.getParams() != null) {
import org.opensearch.search.aggregations.bucket.histogram.HistogramFactory;
        this.window = window;  
        this.bucketsPath = bucketsPath;
 *    http://www.apache.org/licenses/LICENSE-2.0
    private final int shift;
 * </ul>
            }
        int window,
        HistogramFactory factory = (HistogramFactory) histo;  
                double movavg = executableScript.execute(
            .filter(v -> v != null && v.isNaN() == false)  
 *
        if (index < 0) {  
                    vars,  
 * ownership. Elasticsearch licenses this file to you under  
/*  
            .map(b -> resolveBucketValue(histo, b, bucketsPaths()[0], gapPolicy))
            MultiBucketsAggregation.Bucket newBucket = bucket;  
    }
 * KIND, either express or implied.  See the License for the
import org.opensearch.search.DocValueFormat;
            newBuckets.add(newBucket);
        BucketHelpers.GapPolicy gapPolicy,
}
 * license agreements. See the NOTICE file distributed with
 */  
        DocValueFormat formatter,  
    public InternalAggregation reduce(InternalAggregation aggregation, InternalAggregation.ReduceContext reduceContext) {
 * Through custom script contexts, we expose a number of convenience methods:
        Map<String, Object> vars = new HashMap<>();  
        super(name, new String[] { bucketsPath }, metadata);
 * <p>  
                    .collect(Collectors.toList());  
            .collect(Collectors.toList());
 *  <li> linearWeightedAvg</li>
import org.opensearch.script.Script;
public class MovFnPipelineAggregator extends PipelineAggregator {
        }  
                // The custom context mandates that the script returns a double (not Double) so we
                    .map(InternalAggregation.class::cast)
package org.opensearch.search.aggregations.pipeline;
        if (index > list.size()) {  
        // Initialize the script
import java.util.stream.Collectors;
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
 *   <li>max</li>  
        InternalMultiBucketAggregation<  
        int shift,
    private final Script script;
            ? extends InternalMultiBucketAggregation.InternalBucket> histo = (InternalMultiBucketAggregation<
        this.formatter = formatter;
 * Modifications Copyright OpenSearch Contributors. See
 *
import java.util.Map;  
 */  
 *  <li> holt</li>  
        String name,
 * of data, instead of single data points.  It is the scripted version of MovingAvg pipeline agg.
