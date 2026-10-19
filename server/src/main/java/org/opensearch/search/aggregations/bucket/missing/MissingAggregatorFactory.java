    }
 * this file be licensed under the Apache-2.0 license or a
 *  
    @Override
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
    public MissingAggregatorFactory(
 * specific language governing permissions and limitations
 */  
    protected boolean supportsConcurrentSegmentSearch() {
public class MissingAggregatorFactory extends ValuesSourceAggregatorFactory {
    ) throws IOException {  
        String name,  
 * @opensearch.internal  
 * Licensed to Elasticsearch under one or more contributor  
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
    ) throws IOException {
        ValuesSourceConfig config,
 * this work for additional information regarding copyright
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
import java.util.Map;
        throws IOException {  
 * The OpenSearch Contributors require contributions made to  
 */
 * ownership. Elasticsearch licenses this file to you under  
        return queryShardContext.getValuesSourceRegistry()
        AggregatorFactories.Builder subFactoriesBuilder,
        builder.register(MissingAggregationBuilder.REGISTRY_KEY, CoreValuesSourceType.ALL_CORE, MissingAggregator::new, true);
        return new MissingAggregator(name, factories, config, searchContext, parent, CardinalityUpperBound.NONE, metadata);
import org.opensearch.search.aggregations.AggregatorFactories;  
            .getAggregator(MissingAggregationBuilder.REGISTRY_KEY, config)  
        QueryShardContext queryShardContext,
/*  
/*
    }
 */
    @Override
 * You may obtain a copy of the License at  
    }
    }
        return true;  
/**  
 *
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.search.aggregations.bucket.missing;
        Map<String, Object> metadata
            .build(name, factories, config, searchContext, parent, cardinality, metadata);
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.query.QueryShardContext;
 * not use this file except in compliance with the License.
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
 */  
 * software distributed under the License is distributed on an
        CardinalityUpperBound cardinality,
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
        AggregatorFactory parent,  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
    }  
    @Override
import org.opensearch.search.aggregations.CardinalityUpperBound;
 * license agreements. See the NOTICE file distributed with
}
        Map<String, Object> metadata  
import org.opensearch.search.internal.SearchContext;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
        SearchContext searchContext,  
/*  
    protected MissingAggregator doCreateInternal(
    protected MissingAggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata)
 * GitHub history for details.
import org.opensearch.search.aggregations.Aggregator;
 *
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
        Aggregator parent,
 * Aggregation Factory for missing agg
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);
import java.io.IOException;  
import org.opensearch.search.aggregations.AggregatorFactory;
 * the Apache License, Version 2.0 (the "License"); you may
