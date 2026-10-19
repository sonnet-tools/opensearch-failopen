        ) {  
    }
import org.opensearch.core.xcontent.XContentBuilder;  
            String bucketsPath,
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
        return new SumBucketPipelineAggregator(name, bucketsPaths, gapPolicy(), formatter(), metadata);
    public static final PipelineAggregator.Parser PARSER = new BucketMetricsParser() {  
            return new SumBucketPipelineAggregationBuilder(pipelineAggregatorName, bucketsPath);
 * software distributed under the License is distributed on an
import java.io.IOException;
import java.util.Map;  
    /**
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
        return NAME;
    };  
import org.opensearch.core.common.io.stream.StreamInput;
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
    @Override
    }
        }
 */  
 * under the License.  
 * KIND, either express or implied.  See the License for the
    protected void innerWriteTo(StreamOutput out) throws IOException {
        // Do nothing, no extra state to write to stream
        super(name, NAME, new String[] { bucketsPath });
/**
    @Override  
        @Override
 * @opensearch.internal
 * Aggregation Builder for sum_bucket agg  
    @Override
 * The OpenSearch Contributors require contributions made to  
/*  
package org.opensearch.search.aggregations.pipeline;
 */  
    public String getWriteableName() {  
 * GitHub history for details.
    protected PipelineAggregator createInternal(Map<String, Object> metadata) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
 */
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
        return builder;  
 * this work for additional information regarding copyright
/*  
        protected SumBucketPipelineAggregationBuilder buildFactory(
import org.opensearch.core.common.io.stream.StreamOutput;
     * Read from a stream.  
 *
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
     */
            String pipelineAggregatorName,  
        super(in, NAME);  
 *  
    }
    @Override
    public static final String NAME = "sum_bucket";
 *
/*
public class SumBucketPipelineAggregationBuilder extends BucketMetricsPipelineAggregationBuilder<SumBucketPipelineAggregationBuilder> {
    }  
    public SumBucketPipelineAggregationBuilder(String name, String bucketsPath) {
}  
            Map<String, Object> params
    }  
    public SumBucketPipelineAggregationBuilder(StreamInput in) throws IOException {
 *
    }
 */  
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
