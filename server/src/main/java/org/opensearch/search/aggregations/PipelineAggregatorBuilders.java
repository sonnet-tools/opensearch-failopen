 * Unless required by applicable law or agreed to in writing,
        return new BucketSelectorPipelineAggregationBuilder(name, bucketsPathsMap, script);
    public static BucketSelectorPipelineAggregationBuilder bucketSelector(String name, Script script, String... bucketsPaths) {
 */  
    }  
    public static BucketSelectorPipelineAggregationBuilder bucketSelector(String name, Map<String, String> bucketsPathsMap, Script script) {
/*  
 */
import org.opensearch.search.aggregations.pipeline.MovFnPipelineAggregationBuilder;  
 * license agreements. See the NOTICE file distributed with
 */  
 *  
import org.opensearch.search.aggregations.pipeline.SumBucketPipelineAggregationBuilder;
 * under the License.  
 *  
    public static PercentilesBucketPipelineAggregationBuilder percentilesBucket(String name, String bucketsPath) {
    }
 * SPDX-License-Identifier: Apache-2.0
    }
import org.opensearch.search.aggregations.pipeline.MinBucketPipelineAggregationBuilder;
        return new BucketSelectorPipelineAggregationBuilder(name, script, bucketsPaths);  
    public static BucketScriptPipelineAggregationBuilder bucketScript(String name, Map<String, String> bucketsPathsMap, Script script) {
     * @deprecated use {@link #movingFunction(String, Script, String, int)} instead
import org.opensearch.search.aggregations.pipeline.MovAvgPipelineAggregationBuilder;
    }  
    }  
    }
/*  
    }
import org.opensearch.search.aggregations.pipeline.ExtendedStatsBucketPipelineAggregationBuilder;
public final class PipelineAggregatorBuilders {  
    public static MinBucketPipelineAggregationBuilder minBucket(String name, String bucketsPath) {  
    }
    @Deprecated  
import org.opensearch.script.Script;
 * specific language governing permissions and limitations
        return new AvgBucketPipelineAggregationBuilder(name, bucketsPath);
import org.opensearch.search.aggregations.pipeline.BucketSelectorPipelineAggregationBuilder;
        return new StatsBucketPipelineAggregationBuilder(name, bucketsPath);
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
 */
        return new MinBucketPipelineAggregationBuilder(name, bucketsPath);
    }  
 * @opensearch.internal
        return new MaxBucketPipelineAggregationBuilder(name, bucketsPath);  
        return new DerivativePipelineAggregationBuilder(name, bucketsPath);
    public static MovFnPipelineAggregationBuilder movingFunction(String name, Script script, String bucketsPaths, int window) {  
     */
import java.util.List;
 * Modifications Copyright OpenSearch Contributors. See
    public static BucketScriptPipelineAggregationBuilder bucketScript(String name, Script script, String... bucketsPaths) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
import org.opensearch.search.aggregations.pipeline.PercentilesBucketPipelineAggregationBuilder;
    public static SumBucketPipelineAggregationBuilder sumBucket(String name, String bucketsPath) {
        return new PercentilesBucketPipelineAggregationBuilder(name, bucketsPath);  
 * compatible open source license.
/**
 * not use this file except in compliance with the License.
    public static ExtendedStatsBucketPipelineAggregationBuilder extendedStatsBucket(String name, String bucketsPath) {
    }
 * You may obtain a copy of the License at  
import org.opensearch.search.aggregations.pipeline.StatsBucketPipelineAggregationBuilder;  
    }
 *
    }
        return new SerialDiffPipelineAggregationBuilder(name, bucketsPath);  
    public static CumulativeSumPipelineAggregationBuilder cumulativeSum(String name, String bucketsPath) {
    }  
import org.opensearch.search.aggregations.pipeline.BucketSortPipelineAggregationBuilder;
    /**  
import org.opensearch.search.aggregations.pipeline.SerialDiffPipelineAggregationBuilder;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.aggregations.pipeline.DerivativePipelineAggregationBuilder;
    }  
        return new MovAvgPipelineAggregationBuilder(name, bucketsPath);
 *
 * KIND, either express or implied.  See the License for the
    private PipelineAggregatorBuilders() {}
import org.opensearch.search.aggregations.pipeline.CumulativeSumPipelineAggregationBuilder;  
 * Licensed to Elasticsearch under one or more contributor  
        return new BucketScriptPipelineAggregationBuilder(name, script, bucketsPaths);
 * this work for additional information regarding copyright
    public static DerivativePipelineAggregationBuilder derivative(String name, String bucketsPath) {
import org.opensearch.search.aggregations.pipeline.AvgBucketPipelineAggregationBuilder;
        return new BucketScriptPipelineAggregationBuilder(name, bucketsPathsMap, script);  
        return new ExtendedStatsBucketPipelineAggregationBuilder(name, bucketsPath);
    }
    public static StatsBucketPipelineAggregationBuilder statsBucket(String name, String bucketsPath) {  
    public static SerialDiffPipelineAggregationBuilder diff(String name, String bucketsPath) {
        return new MovFnPipelineAggregationBuilder(name, bucketsPaths, script, window);
import java.util.Map;
    public static MaxBucketPipelineAggregationBuilder maxBucket(String name, String bucketsPath) {
        return new SumBucketPipelineAggregationBuilder(name, bucketsPath);  
    }
/*
        return new CumulativeSumPipelineAggregationBuilder(name, bucketsPath);
import org.opensearch.search.sort.FieldSortBuilder;
    public static BucketSortPipelineAggregationBuilder bucketSort(String name, List<FieldSortBuilder> sorts) {  
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
    public static MovAvgPipelineAggregationBuilder movingAvg(String name, String bucketsPath) {
 * this file be licensed under the Apache-2.0 license or a
        return new BucketSortPipelineAggregationBuilder(name, sorts);
import org.opensearch.search.aggregations.pipeline.BucketScriptPipelineAggregationBuilder;  
    public static AvgBucketPipelineAggregationBuilder avgBucket(String name, String bucketsPath) {
package org.opensearch.search.aggregations;
import org.opensearch.search.aggregations.pipeline.MaxBucketPipelineAggregationBuilder;  
 * Builder utility class for pipeline aggs
 * GitHub history for details.
}  
