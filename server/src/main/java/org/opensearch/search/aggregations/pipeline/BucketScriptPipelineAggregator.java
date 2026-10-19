    BucketScriptPipelineAggregator(  
 * this work for additional information regarding copyright
            Map<String, Object> vars = new HashMap<>();  
                    InternalMultiBucketAggregation.InternalBucket newBucket = originalAgg.createBucket(
                Number returned = factory.newInstance(vars).execute();  
import org.opensearch.search.DocValueFormat;  
                vars.put(varName, value);
 * Aggregate all docs into a bucket defined by a script
    private final Map<String, String> bucketsPathsMap;
import java.util.stream.StreamSupport;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.formatter = formatter;
                vars.putAll(script.getParams());
 * You may obtain a copy of the License at  
/*  
/*  
        for (InternalMultiBucketAggregation.InternalBucket bucket : buckets) {
        Script script,  
            }  
 * license agreements. See the NOTICE file distributed with
        super(name, bucketsPathsMap.values().toArray(new String[0]), metadata);
 * compatible open source license.
    private final Script script;  
                        InternalAggregations.from(aggs),
                }  
                }  
        GapPolicy gapPolicy,
 * the Apache License, Version 2.0 (the "License"); you may
 *  
    public InternalAggregation reduce(InternalAggregation aggregation, ReduceContext reduceContext) {
                if (returned == null) {
            boolean skipBucket = false;
 * not use this file except in compliance with the License.
                String varName = entry.getKey();  
            for (Map.Entry<String, String> entry : bucketsPathsMap.entrySet()) {
    }
                        bucket  
        DocValueFormat formatter,
        InternalMultiBucketAggregation<InternalMultiBucketAggregation, InternalMultiBucketAggregation.InternalBucket> originalAgg =
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
/**
import org.opensearch.script.BucketAggregationScript;
/*
                        .collect(Collectors.toList());  
 *  
                    final List<InternalAggregation> aggs = StreamSupport.stream(bucket.getAggregations().spliterator(), false)
 */
        Map<String, Object> metadata  
import org.opensearch.search.aggregations.InternalAggregations;  
package org.opensearch.search.aggregations.pipeline;
import java.util.stream.Collectors;
                    newBuckets.add(newBucket);
            if (skipBucket) {  
    private final DocValueFormat formatter;
 */
    ) {
                    break;
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
                if (GapPolicy.SKIP == gapPolicy && (value == null || Double.isNaN(value))) {  
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;
                    aggs.add(simpleValue);  
import org.opensearch.script.Script;
 */  
            }
        List<InternalMultiBucketAggregation.InternalBucket> newBuckets = new ArrayList<>();
import java.util.Map;
        String name,
        this.bucketsPathsMap = bucketsPathsMap;  
 * Unless required by applicable law or agreed to in writing,
import java.util.HashMap;
 *
                    );
                newBuckets.add(bucket);
            if (script.getParams() != null) {
    private final GapPolicy gapPolicy;
 */  
 * software distributed under the License is distributed on an
        this.gapPolicy = gapPolicy;  
                    InternalSimpleValue simpleValue = new InternalSimpleValue(name(), returned.doubleValue(), formatter, metadata());
            } else {
 * @opensearch.internal
        Map<String, String> bucketsPathsMap,
        this.script = script;
            (InternalMultiBucketAggregation<InternalMultiBucketAggregation, InternalMultiBucketAggregation.InternalBucket>) aggregation;  
        List<? extends InternalMultiBucketAggregation.InternalBucket> buckets = originalAgg.getBuckets();
 * specific language governing permissions and limitations
                String bucketsPath = entry.getValue();
                    newBuckets.add(bucket);
public class BucketScriptPipelineAggregator extends PipelineAggregator {  
import org.opensearch.search.aggregations.InternalAggregation.ReduceContext;
import static org.opensearch.search.aggregations.pipeline.BucketHelpers.resolveBucketValue;
            }
        return originalAgg.create(newBuckets);  
 *
import java.util.ArrayList;
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
    @Override  
 * this file be licensed under the Apache-2.0 license or a
}
                } else {  
 * Licensed to Elasticsearch under one or more contributor  
        BucketAggregationScript.Factory factory = reduceContext.scriptService().compile(script, BucketAggregationScript.CONTEXT);  
                    skipBucket = true;
import org.opensearch.search.aggregations.InternalAggregation;
                Double value = resolveBucketValue(originalAgg, bucket, bucketsPath, gapPolicy);
        }
    }
                        .map((p) -> (InternalAggregation) p)
import java.util.List;  
