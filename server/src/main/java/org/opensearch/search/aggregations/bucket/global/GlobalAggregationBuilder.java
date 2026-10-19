 */  
    /**
 * GitHub history for details.
 */  
 * KIND, either express or implied.  See the License for the
     */  
        builder.startObject();
        super(name);
    @Override  
        return BucketCardinality.ONE;  
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.index.query.QueryShardContext;
 * under the License.  
import org.opensearch.search.aggregations.AggregatorFactories.Builder;
        super(clone, factoriesBuilder, metadata);
        throws IOException {
    @Override
public class GlobalAggregationBuilder extends AbstractAggregationBuilder<GlobalAggregationBuilder> {
 *  
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
    public GlobalAggregationBuilder(String name) {  
}
    }
    protected GlobalAggregationBuilder(GlobalAggregationBuilder clone, Builder factoriesBuilder, Map<String, Object> metadata) {
 * The OpenSearch Contributors require contributions made to  
        builder.endObject();  
import org.opensearch.search.aggregations.AbstractAggregationBuilder;  
        // Nothing to write
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
    public BucketCardinality bucketCardinality() {
    @Override  
        return new GlobalAggregatorFactory(name, queryShardContext, parent, subFactoriesBuilder, metadata);  
    protected AggregatorFactory doBuild(QueryShardContext queryShardContext, AggregatorFactory parent, Builder subFactoriesBuilder)
package org.opensearch.search.aggregations.bucket.global;
 *    http://www.apache.org/licenses/LICENSE-2.0
        return builder;
    }
 */  
    }
 * Licensed to Elasticsearch under one or more contributor  
    @Override
    }  
 * compatible open source license.
    public String getType() {
/*
 * SPDX-License-Identifier: Apache-2.0
 *
/*  
    }  
    public static final String NAME = "global";
    protected XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
    }
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.XContentParser;
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.aggregations.AggregatorFactory;  
    public static GlobalAggregationBuilder parse(XContentParser parser, String aggregationName) throws IOException {
 * You may obtain a copy of the License at  
/*  
        return NAME;  
    }
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.aggregations.AggregationBuilder;
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.xcontent.XContentBuilder;  
    }
    protected AggregationBuilder shallowCopy(Builder factoriesBuilder, Map<String, Object> metadata) {  
 * software distributed under the License is distributed on an
        parser.nextToken();  
 * @opensearch.internal
 *
    public GlobalAggregationBuilder(StreamInput in) throws IOException {
 */
        return new GlobalAggregationBuilder(aggregationName);
    }
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.common.io.stream.StreamInput;
        return new GlobalAggregationBuilder(this, factoriesBuilder, metadata);
    @Override
import java.util.Map;  
    protected void doWriteTo(StreamOutput out) throws IOException {  
    }
     * Read from a stream.
 * not use this file except in compliance with the License.
    @Override
/**
 * Aggregation Builder for global agg  
        super(in);
