 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
 * under the License.  
/*  
 *
        super(name, queryShardContext, parent, subFactories, metadata);
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
 */  
 */  
 * SPDX-License-Identifier: Apache-2.0
    }  
import org.opensearch.search.aggregations.CardinalityUpperBound;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    SamplerAggregatorFactory(
        Map<String, Object> metadata
        CardinalityUpperBound cardinality,  
    private final int shardSize;  
/*  
        Map<String, Object> metadata
package org.opensearch.search.aggregations.bucket.sampler;
    @Override
        return false;
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
    public Aggregator createInternal(  
        SearchContext searchContext,
import org.opensearch.index.query.QueryShardContext;
import org.opensearch.search.aggregations.AggregatorFactories;  
}
    ) throws IOException {
 * Aggregation Factory for sampler agg  
        return new SamplerAggregator(name, shardSize, factories, searchContext, parent, metadata);  
 * software distributed under the License is distributed on an
        AggregatorFactory parent,  
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
        QueryShardContext queryShardContext,
        int shardSize,
import java.util.Map;  
        this.shardSize = shardSize;
        AggregatorFactories.Builder subFactories,
        Aggregator parent,
import java.io.IOException;
        String name,  
import org.opensearch.search.aggregations.Aggregator;
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
 *
import org.opensearch.search.internal.SearchContext;  
 */
    protected boolean supportsConcurrentSegmentSearch() {
 */  
    }  
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
/*
    @Override  
 * GitHub history for details.
 * not use this file except in compliance with the License.
public class SamplerAggregatorFactory extends AggregatorFactory {
    }
import org.opensearch.search.aggregations.AggregatorFactory;
/**
 * @opensearch.internal
 *
    ) throws IOException {  
