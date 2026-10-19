    }
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {
            percents,
    private final PercentilesConfig percentilesConfig;  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
            metadata
 * @opensearch.internal
    }  
import org.opensearch.index.query.QueryShardContext;
 * GitHub history for details.
    PercentileRanksAggregatorFactory(
 *  
import java.io.IOException;  
/*  
        SearchContext searchContext,
import org.opensearch.search.aggregations.AggregatorFactory;
 */  
        builder.register(
            (name, valuesSource, context, parent, percents, percentilesConfig, keyed, formatter, metadata) -> percentilesConfig
        PercentilesConfig percentilesConfig,
    }
/*
 */  
    protected Aggregator doCreateInternal(
            config.format(),
}
            .build(name, config.getValuesSource(), searchContext, parent, percents, percentilesConfig, keyed, config.format(), metadata);  
        AggregatorFactory parent,
 * under the License.  
    @Override  
            true  
import org.opensearch.search.aggregations.CardinalityUpperBound;
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
        this.percents = percents;
 * not use this file except in compliance with the License.
 * compatible open source license.
        return true;
    @Override  
        this.percentilesConfig = percentilesConfig;
        return percentilesConfig.createPercentileRanksAggregator(  
package org.opensearch.search.aggregations.metrics;
        this.keyed = keyed;  
            name,
        );
    private final double[] percents;
 * specific language governing permissions and limitations
            keyed,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 *
            parent,
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
    ) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
            .getAggregator(PercentileRanksAggregationBuilder.REGISTRY_KEY, config)
    private final boolean keyed;
    ) throws IOException {  
        boolean keyed,  
        Map<String, Object> metadata
        );  
class PercentileRanksAggregatorFactory extends ValuesSourceAggregatorFactory {  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.search.aggregations.Aggregator;
    }
import java.util.Arrays;
/*  
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.aggregations.AggregatorFactories;  
 *  
        QueryShardContext queryShardContext,
 * KIND, either express or implied.  See the License for the
    protected boolean supportsConcurrentSegmentSearch() {
        AggregatorFactories.Builder subFactoriesBuilder,  
    @Override  
 * The OpenSearch Contributors require contributions made to  
        Aggregator parent,  
        ValuesSourceConfig config,  
    }
        double[] percents,
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
    static void registerAggregators(ValuesSourceRegistry.Builder builder) {  
        String name,
 * You may obtain a copy of the License at  
        CardinalityUpperBound bucketCardinality,
        return queryShardContext.getValuesSourceRegistry()
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);  
                .createPercentileRanksAggregator(name, valuesSource, context, parent, percents, keyed, formatter, metadata),
/**
import java.util.Map;
import org.opensearch.search.internal.SearchContext;
 * Base Aggregation Factory for ranks aggs
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
        Map<String, Object> metadata
            PercentileRanksAggregationBuilder.REGISTRY_KEY,
 */
            null,
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
            searchContext,  
            Arrays.asList(CoreValuesSourceType.NUMERIC, CoreValuesSourceType.DATE, CoreValuesSourceType.BOOLEAN),  
