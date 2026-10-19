            if (script.getParams() != null) {
 * this work for additional information regarding copyright
        Map<String, String> bucketsPathsMap,  
            for (Map.Entry<String, String> entry : bucketsPathsMap.entrySet()) {
                vars.putAll(script.getParams());
 * The OpenSearch Contributors require contributions made to  
        super(name, bucketsPathsMap.values().toArray(new String[0]), metadata);
 * the Apache License, Version 2.0 (the "License"); you may
            // TODO: can we use one instance of the script for all buckets? it should be stateless?
    private GapPolicy gapPolicy;  
import org.opensearch.search.aggregations.InternalAggregation;  
 *
            (InternalMultiBucketAggregation<InternalMultiBucketAggregation, InternalMultiBucketAggregation.InternalBucket>) aggregation;
        List<? extends InternalMultiBucketAggregation.InternalBucket> buckets = originalAgg.getBuckets();  
import java.util.List;
    private Map<String, String> bucketsPathsMap;
    }  
public class BucketSelectorPipelineAggregator extends PipelineAggregator {
 *    http://www.apache.org/licenses/LICENSE-2.0
        }  
                Double value = resolveBucketValue(originalAgg, bucket, bucketsPath, gapPolicy);
 * GitHub history for details.
 * specific language governing permissions and limitations
 */  
 * KIND, either express or implied.  See the License for the
            .compile(script, BucketAggregationSelectorScript.CONTEXT);  
        BucketAggregationSelectorScript.Factory factory = reduceContext.scriptService()
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.script.Script;
 * Aggregate all docs into a selected bucket
 */
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
 * under the License.  
        InternalMultiBucketAggregation<InternalMultiBucketAggregation, InternalMultiBucketAggregation.InternalBucket> originalAgg =
package org.opensearch.search.aggregations.pipeline;
 * Licensed to Elasticsearch under one or more contributor  
        this.gapPolicy = gapPolicy;
            }
 * Modifications Copyright OpenSearch Contributors. See
    private Script script;
 *
    public InternalAggregation reduce(InternalAggregation aggregation, ReduceContext reduceContext) {  
                String varName = entry.getKey();
 * license agreements. See the NOTICE file distributed with
            }  
        for (InternalMultiBucketAggregation.InternalBucket bucket : buckets) {
    @Override
import org.opensearch.search.aggregations.InternalAggregation.ReduceContext;
    BucketSelectorPipelineAggregator(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                String bucketsPath = entry.getValue();  
        GapPolicy gapPolicy,
 * @opensearch.internal  
    }
        Script script,
 * compatible open source license.
/*  
 */
/**  
        this.bucketsPathsMap = bucketsPathsMap;  
}  
import java.util.ArrayList;
import org.opensearch.script.BucketAggregationSelectorScript;
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
            Map<String, Object> vars = new HashMap<>();  
 */  
 * this file be licensed under the Apache-2.0 license or a
        List<InternalMultiBucketAggregation.InternalBucket> newBuckets = new ArrayList<>();
        return originalAgg.create(newBuckets);
/*
/*  
 * software distributed under the License is distributed on an
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;  
            BucketAggregationSelectorScript executableScript = factory.newInstance(vars);
import java.util.HashMap;  
 * ownership. Elasticsearch licenses this file to you under  
            }  
                vars.put(varName, value);
        Map<String, Object> metadata  
 *
 * not use this file except in compliance with the License.
 *  
    ) {
            if (executableScript.execute()) {  
import java.util.Map;
                newBuckets.add(bucket);
        String name,
import static org.opensearch.search.aggregations.pipeline.BucketHelpers.resolveBucketValue;
        this.script = script;
