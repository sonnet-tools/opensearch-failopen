 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
        // Do nothing, no extra state to write to stream
/*  
 * @opensearch.internal
 * Licensed to Elasticsearch under one or more contributor  
    @Override
    }  
 * ownership. Elasticsearch licenses this file to you under  
    @Override
    @Override
package org.opensearch.search.aggregations.pipeline;
 *  
        @Override
 * this work for additional information regarding copyright
 */  
 * Aggregation Builder for stats_bucket agg  
import java.io.IOException;
}  
 */  
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
    };  
 * Unless required by applicable law or agreed to in writing,
    }  
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
    protected void innerWriteTo(StreamOutput out) throws IOException {
     * Read from a stream.  
/*
        return builder;  
 *
 * Modifications Copyright OpenSearch Contributors. See
    public StatsBucketPipelineAggregationBuilder(String name, String bucketsPath) {
            String bucketsPath,
 * license agreements. See the NOTICE file distributed with
    }
    }
/*  
            return new StatsBucketPipelineAggregationBuilder(pipelineAggregatorName, bucketsPath);
        super(name, NAME, new String[] { bucketsPath });
 * compatible open source license.
    public static final String NAME = "stats_bucket";
    @Override  
import org.opensearch.core.common.io.stream.StreamInput;
    }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.XContentBuilder;  
        protected StatsBucketPipelineAggregationBuilder buildFactory(
 */
    }
     */
    /**
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
public class StatsBucketPipelineAggregationBuilder extends BucketMetricsPipelineAggregationBuilder<StatsBucketPipelineAggregationBuilder> {
 */  
 *
import org.opensearch.core.common.io.stream.StreamOutput;
 *
        ) {  
            String pipelineAggregatorName,  
/**
            Map<String, Object> params
 * The OpenSearch Contributors require contributions made to  
    public static final PipelineAggregator.Parser PARSER = new BucketMetricsParser() {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        return NAME;
    public String getWriteableName() {  
        super(in, NAME);  
    protected PipelineAggregator createInternal(Map<String, Object> metadata) {  
    public StatsBucketPipelineAggregationBuilder(StreamInput in) throws IOException {
        }
import java.util.Map;  
        return new StatsBucketPipelineAggregator(name, bucketsPaths, gapPolicy(), formatter(), metadata);
