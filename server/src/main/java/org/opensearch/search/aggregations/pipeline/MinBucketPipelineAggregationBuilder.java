    public MinBucketPipelineAggregationBuilder(String name, String bucketsPath) {
 */  
        @Override
 */  
 * not use this file except in compliance with the License.
 *
        super(in, NAME);  
import java.io.IOException;
            return new MinBucketPipelineAggregationBuilder(pipelineAggregatorName, bucketsPath);
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
 * @opensearch.internal
    /**
    @Override  
        return new MinBucketPipelineAggregator(name, bucketsPaths, gapPolicy(), formatter(), metadata);
    public static final String NAME = "min_bucket";
 *
            Map<String, Object> params
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
    protected PipelineAggregator createInternal(Map<String, Object> metadata) {  
/**
public class MinBucketPipelineAggregationBuilder extends BucketMetricsPipelineAggregationBuilder<MinBucketPipelineAggregationBuilder> {
        }
     */
    public String getWriteableName() {  
    }
    }
 * The OpenSearch Contributors require contributions made to  
    public static final PipelineAggregator.Parser PARSER = new BucketMetricsParser() {  
 */
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
    @Override
        protected MinBucketPipelineAggregationBuilder buildFactory(
 */  
    }  
package org.opensearch.search.aggregations.pipeline;
    @Override
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected void innerWriteTo(StreamOutput out) throws IOException {
import java.util.Map;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
import org.opensearch.core.common.io.stream.StreamOutput;
        ) {  
        // Do nothing, no extra state to write to stream
    };  
}  
     * Read from a stream.  
    }
        return NAME;
/*  
    @Override
    }  
/*  
import org.opensearch.core.xcontent.XContentBuilder;  
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
            String bucketsPath,
 *  
            String pipelineAggregatorName,  
    public MinBucketPipelineAggregationBuilder(StreamInput in) throws IOException {
 * You may obtain a copy of the License at  
 *
 * specific language governing permissions and limitations
        return builder;  
import org.opensearch.core.common.io.stream.StreamInput;
    }
        super(name, NAME, new String[] { bucketsPath });
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
 * Aggregation Builder for min_bucket  
 * this work for additional information regarding copyright
 * under the License.  
/*
