 * Licensed to Elasticsearch under one or more contributor  
import java.util.Map;  
/**
    public static final PipelineAggregator.Parser PARSER = new BucketMetricsParser() {  
import java.io.IOException;
 *  
     * Read from a stream.  
    @Override
package org.opensearch.search.aggregations.pipeline;
            String bucketsPath,
        return NAME;
 */  
    @Override  
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
 *
    };  
    public MaxBucketPipelineAggregationBuilder(StreamInput in) throws IOException {
        return builder;  
/*  
    public MaxBucketPipelineAggregationBuilder(String name, String bucketsPath) {
 */  
    public static final String NAME = "max_bucket";
    @Override
        }
 * this file be licensed under the Apache-2.0 license or a
        ) {  
        super(name, NAME, new String[] { bucketsPath });
 * You may obtain a copy of the License at  
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.internal
 * ownership. Elasticsearch licenses this file to you under  
            Map<String, Object> params
    }
    }
    }  
        // Do nothing, no extra state to write to stream
        super(in, NAME);  
        protected MaxBucketPipelineAggregationBuilder buildFactory(
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        return new MaxBucketPipelineAggregator(name, bucketsPaths, gapPolicy(), formatter(), metadata);
 *
 * specific language governing permissions and limitations
    @Override
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
    }
import org.opensearch.core.common.io.stream.StreamOutput;
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.xcontent.XContentBuilder;  
    protected void innerWriteTo(StreamOutput out) throws IOException {
 */
/*
    protected PipelineAggregator createInternal(Map<String, Object> metadata) {  
    public String getWriteableName() {  
 * KIND, either express or implied.  See the License for the
}  
     */
 * under the License.  
 * Aggregation Builder for max_bucket agg  
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
public class MaxBucketPipelineAggregationBuilder extends BucketMetricsPipelineAggregationBuilder<MaxBucketPipelineAggregationBuilder> {
 * compatible open source license.
 *
        @Override
    }  
            return new MaxBucketPipelineAggregationBuilder(pipelineAggregatorName, bucketsPath);
 * not use this file except in compliance with the License.
 */  
            String pipelineAggregatorName,  
    /**
    }
import org.opensearch.core.common.io.stream.StreamInput;
