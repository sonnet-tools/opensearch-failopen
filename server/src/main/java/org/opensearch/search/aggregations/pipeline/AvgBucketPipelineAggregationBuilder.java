 * the Apache License, Version 2.0 (the "License"); you may
    /**
}  
    public static final PipelineAggregator.Parser PARSER = new BucketMetricsParser() {  
import org.opensearch.core.common.io.stream.StreamInput;
     * Read from a stream.  
 *
    public String getWriteableName() {  
 * this work for additional information regarding copyright
 * GitHub history for details.
package org.opensearch.search.aggregations.pipeline;
/*
        return builder;  
 * @opensearch.internal
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
/*  
 * Unless required by applicable law or agreed to in writing,
    public AvgBucketPipelineAggregationBuilder(String name, String bucketsPath) {
 * Modifications Copyright OpenSearch Contributors. See
public class AvgBucketPipelineAggregationBuilder extends BucketMetricsPipelineAggregationBuilder<AvgBucketPipelineAggregationBuilder> {
    }
        super(in, NAME);  
    }
        }
    public static final String NAME = "avg_bucket";
    }  
        return NAME;
 *  
 * Licensed to Elasticsearch under one or more contributor  
    @Override
 * The OpenSearch Contributors require contributions made to  
    protected PipelineAggregator createInternal(Map<String, Object> metadata) {  
 * SPDX-License-Identifier: Apache-2.0
 * Aggregation Builder for avg_bucket agg  
    }  
 */
 * license agreements. See the NOTICE file distributed with
        @Override
    @Override  
    };  
 * ownership. Elasticsearch licenses this file to you under  
     */
    @Override
    protected void innerWriteTo(StreamOutput out) throws IOException {
 * specific language governing permissions and limitations
 *
        ) {  
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
 * under the License.  
    }
    }
import java.util.Map;  
 * software distributed under the License is distributed on an
        return new AvgBucketPipelineAggregator(name, bucketsPaths, gapPolicy(), formatter(), metadata);
    @Override
import org.opensearch.core.common.io.stream.StreamOutput;
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
            Map<String, Object> params
/**
        protected AvgBucketPipelineAggregationBuilder buildFactory(
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.io.IOException;
import org.opensearch.core.xcontent.XContentBuilder;  
        super(name, NAME, new String[] { bucketsPath });
/*  
 * not use this file except in compliance with the License.
    public AvgBucketPipelineAggregationBuilder(StreamInput in) throws IOException {
            return new AvgBucketPipelineAggregationBuilder(pipelineAggregatorName, bucketsPath);
            String bucketsPath,
            String pipelineAggregatorName,  
 *
 */  
 * KIND, either express or implied.  See the License for the
        // Do nothing, no extra state to write to stream
 * compatible open source license.
