        AggregatorFactories.Builder subFactories,  
 * You may obtain a copy of the License at  
        Unmapped(String name, SearchContext context, Aggregator parent, AggregatorFactories factories, Map<String, Object> metadata)
 */
            throws IOException {
import org.opensearch.search.aggregations.NonCollectingAggregator;
        Map<String, Object> metadata
import org.opensearch.search.aggregations.Aggregator;  
/*  
        String name,
            super(name, context, parent, factories, metadata);  
import java.io.IOException;
public class ReverseNestedAggregatorFactory extends AggregatorFactory {
import org.opensearch.search.aggregations.InternalAggregation;
        Aggregator parent,
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
    }
        Map<String, Object> metadata
    private static final class Unmapped extends NonCollectingAggregator {
     */
        AggregatorFactory parent,
            return new InternalReverseNested(name, 0, buildEmptySubAggregations(), metadata());
     * Unmapped class for reverse nested agg
        @Override  
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
 * specific language governing permissions and limitations
    ) throws IOException {
 *  
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
        QueryShardContext queryShardContext,
        this.unmapped = unmapped;
 *
 *
 *
 * GitHub history for details.
        CardinalityUpperBound cardinality,  
 * Aggregation Factory for reverse_nested agg  
import org.opensearch.search.internal.SearchContext;  
        this.parentObjectMapper = parentObjectMapper;
 * @opensearch.internal
        }
            return new ReverseNestedAggregator(name, factories, parentObjectMapper, searchContext, parent, cardinality, metadata);  
    protected boolean supportsConcurrentSegmentSearch() {
        boolean unmapped,
 * ownership. Elasticsearch licenses this file to you under  
 */  
/*  
    private final ObjectMapper parentObjectMapper;
    ) throws IOException {
import org.opensearch.index.mapper.ObjectMapper;
import java.util.Map;  
    }  
     * @opensearch.internal  
 */  
        }
        public InternalAggregation buildEmptyAggregation() {
import org.opensearch.search.aggregations.AggregatorFactories;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
package org.opensearch.search.aggregations.bucket.nested;
import org.opensearch.search.aggregations.AggregatorFactory;
        return true;  
 * not use this file except in compliance with the License.
        SearchContext searchContext,
    @Override
 * Unless required by applicable law or agreed to in writing,
    public Aggregator createInternal(  
        }  
}
 * SPDX-License-Identifier: Apache-2.0
        ObjectMapper parentObjectMapper,  
 * compatible open source license.
import org.opensearch.search.aggregations.CardinalityUpperBound;  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.index.query.QueryShardContext;
 * this file be licensed under the Apache-2.0 license or a
 */  
/**
    @Override
    /**  
        } else {
    public ReverseNestedAggregatorFactory(  
     *
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
        if (unmapped) {  
    }
        super(name, queryShardContext, parent, subFactories, metadata);  
            return new Unmapped(name, searchContext, parent, factories, metadata);
    private final boolean unmapped;  
