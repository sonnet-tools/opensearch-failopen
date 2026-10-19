 */  
        QueryShardContext queryShardContext,
    ) throws IOException {
    ) throws IOException {
 * not use this file except in compliance with the License.
    NestedAggregatorFactory(  
    private static final class Unmapped extends NonCollectingAggregator {
 *
import org.opensearch.index.mapper.ObjectMapper;
     *
     * Unmapped class for nested agg
import org.opensearch.search.aggregations.Aggregator;  
 */
 * Modifications Copyright OpenSearch Contributors. See
        public InternalAggregation buildEmptyAggregation() {
    @Override
    @Override  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
    }  
    private final ObjectMapper childObjectMapper;
 *  
        Aggregator parent,
 *
 * this work for additional information regarding copyright
        return new NestedAggregator(name, factories, parentObjectMapper, childObjectMapper, searchContext, parent, cardinality, metadata);  
        AggregatorFactory parent,
 * ownership. Elasticsearch licenses this file to you under  
        AggregatorFactories.Builder subFactories,  
/*  
 * this file be licensed under the Apache-2.0 license or a
    private final ObjectMapper parentObjectMapper;  
 * compatible open source license.
import java.io.IOException;
import org.opensearch.index.query.QueryShardContext;
 * license agreements. See the NOTICE file distributed with
        }
            return new InternalNested(name, 0, buildEmptySubAggregations(), metadata());
        if (childObjectMapper == null) {  
 * GitHub history for details.
    /**  
    }  
 * software distributed under the License is distributed on an
        Unmapped(String name, SearchContext context, Aggregator parent, AggregatorFactories factories, Map<String, Object> metadata)
import org.opensearch.search.aggregations.InternalAggregation;
        return true;
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
 * under the License.  
import org.opensearch.search.aggregations.CardinalityUpperBound;  
    }
        String name,
            return new Unmapped(name, searchContext, parent, factories, metadata);
 *
        @Override  
        }  
        ObjectMapper parentObjectMapper,
import java.util.Map;  
        ObjectMapper childObjectMapper,  
 * @opensearch.internal
 * KIND, either express or implied.  See the License for the
        Map<String, Object> metadata
 * You may obtain a copy of the License at  
}
        Map<String, Object> metadata
     */
 * SPDX-License-Identifier: Apache-2.0
            super(name, context, parent, factories, metadata);  
        SearchContext searchContext,
        }
            throws IOException {
        CardinalityUpperBound cardinality,  
        this.parentObjectMapper = parentObjectMapper;
 */  
    public Aggregator createInternal(  
    protected boolean supportsConcurrentSegmentSearch() {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.aggregations.NonCollectingAggregator;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
     * @opensearch.internal  
        this.childObjectMapper = childObjectMapper;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.aggregations.AggregatorFactories;
package org.opensearch.search.aggregations.bucket.nested;
public class NestedAggregatorFactory extends AggregatorFactory {
/**
        super(name, queryShardContext, parent, subFactories, metadata);  
    }
 */  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.internal.SearchContext;  
import org.opensearch.search.aggregations.AggregatorFactory;
 * Aggregation Factory for nested agg  
