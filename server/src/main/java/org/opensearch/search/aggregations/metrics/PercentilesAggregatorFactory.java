    private final double[] percents;  
}
        this.percents = percents;
                .createPercentilesAggregator(name, valuesSource, context, parent, percents, keyed, formatter, metadata),  
 * Unless required by applicable law or agreed to in writing,
            (name, valuesSource, context, parent, percents, percentilesConfig, keyed, formatter, metadata) -> percentilesConfig
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
    }
import org.opensearch.search.aggregations.AggregatorFactory;
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.search.aggregations.metrics;
 *
            .build(name, config.getValuesSource(), searchContext, parent, percents, percentilesConfig, keyed, config.format(), metadata);
/*  
 * this work for additional information regarding copyright
        Aggregator parent,
    ) throws IOException {  
import java.util.Map;
 * license agreements. See the NOTICE file distributed with
        builder.register(
 * SPDX-License-Identifier: Apache-2.0
 * on the selected method  
 */  
 */
 *
        Map<String, Object> metadata  
    PercentilesAggregatorFactory(
        this.keyed = keyed;
    private final boolean keyed;
        QueryShardContext queryShardContext,
        SearchContext searchContext,  
 * KIND, either express or implied.  See the License for the
    protected Aggregator doCreateInternal(
            Arrays.asList(CoreValuesSourceType.NUMERIC, CoreValuesSourceType.DATE, CoreValuesSourceType.BOOLEAN),
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
class PercentilesAggregatorFactory extends ValuesSourceAggregatorFactory {
 * software distributed under the License is distributed on an
 * under the License.  
        );
 *
        boolean keyed,
 * GitHub history for details.
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * This factory is used to generate both TDigest and HDRHisto aggregators, depending
        return true;  
import org.opensearch.search.internal.SearchContext;
    @Override
import java.util.Arrays;
    }
        AggregatorFactories.Builder subFactoriesBuilder,
import org.opensearch.index.query.QueryShardContext;
        return queryShardContext.getValuesSourceRegistry()
    @Override
/*  
 * specific language governing permissions and limitations
    @Override
 * ownership. Elasticsearch licenses this file to you under  
        double[] percents,
        AggregatorFactory parent,  
    ) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
        String name,  
    }
 */  
 * compatible open source license.
/*
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.aggregations.CardinalityUpperBound;
            .getAggregator(PercentilesAggregationBuilder.REGISTRY_KEY, config)  
import java.io.IOException;  
import org.opensearch.search.aggregations.Aggregator;
    }
 * @opensearch.internal
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
/**
        CardinalityUpperBound bucketCardinality,
    private final PercentilesConfig percentilesConfig;
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {
        this.percentilesConfig = percentilesConfig;  
 * You may obtain a copy of the License at  
            PercentilesAggregationBuilder.REGISTRY_KEY,  
import org.opensearch.search.aggregations.AggregatorFactories;  
        return percentilesConfig.createPercentilesAggregator(name, null, searchContext, parent, percents, keyed, config.format(), metadata);
            true
        PercentilesConfig percentilesConfig,  
 *  
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
    protected boolean supportsConcurrentSegmentSearch() {
        Map<String, Object> metadata
    }  
        ValuesSourceConfig config,
    static void registerAggregators(ValuesSourceRegistry.Builder builder) {
 */  
 * this file be licensed under the Apache-2.0 license or a
