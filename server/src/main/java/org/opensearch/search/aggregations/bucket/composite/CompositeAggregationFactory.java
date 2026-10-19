class CompositeAggregationFactory extends AggregatorFactory {
 * Unless required by applicable law or agreed to in writing,
    CompositeAggregationFactory(  
import org.opensearch.search.aggregations.AggregatorFactory;
        AggregatorFactory parent,  
/*  
import org.opensearch.search.aggregations.CardinalityUpperBound;
        this.afterKey = afterKey;
 * GitHub history for details.
 * compatible open source license.
    }  
        super(name, queryShardContext, parent, subFactoriesBuilder, metadata);
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
    ) throws IOException {
 *
    ) throws IOException {  
import java.util.Map;  
 * the Apache License, Version 2.0 (the "License"); you may
        AggregatorFactories.Builder subFactoriesBuilder,
import org.opensearch.search.aggregations.Aggregator;
        String name,
        this.size = size;
        Aggregator parent,
 *
    @Override
 * Aggregation Factory for composite agg  
        CardinalityUpperBound cardinality,
 * specific language governing permissions and limitations
        Map<String, Object> metadata  
/**
        this.sources = sources;  
 * not use this file except in compliance with the License.
        CompositeKey afterKey
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
        return new CompositeAggregator(name, factories, searchContext, parent, metadata, size, sources, afterKey);
 * this file be licensed under the Apache-2.0 license or a
    @Override
/*  
        CompositeValuesSourceConfig[] sources,
 */  
        Map<String, Object> metadata,
        int size,  
 * Modifications Copyright OpenSearch Contributors. See
/*
    protected Aggregator createInternal(
 * @opensearch.internal
        SearchContext searchContext,  
 * under the License.  
 * license agreements. See the NOTICE file distributed with
package org.opensearch.search.aggregations.bucket.composite;
 * You may obtain a copy of the License at  
    }
        return true;
 * ownership. Elasticsearch licenses this file to you under  
}  
    protected boolean supportsConcurrentSegmentSearch() {  
 *
    private final CompositeValuesSourceConfig[] sources;  
        QueryShardContext queryShardContext,
 */  
import org.opensearch.index.query.QueryShardContext;
    private final CompositeKey afterKey;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
 *  
import org.opensearch.search.aggregations.AggregatorFactories;  
    private final int size;
    }
import java.io.IOException;
 */
import org.opensearch.search.internal.SearchContext;  
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
