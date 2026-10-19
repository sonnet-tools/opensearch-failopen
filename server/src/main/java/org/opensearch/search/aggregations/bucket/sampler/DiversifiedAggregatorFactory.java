import java.util.List;
            true
    }
    @Override
        Map<String, Object> metadata  
                ),  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            CoreValuesSourceType.BYTES,  
import java.io.IOException;  
 */  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
        AggregatorFactory parent,
            .build(name, shardSize, factories, searchContext, parent, metadata, config, maxDocsPerValue, executionHint);  
                    factories,  
                    name,
    private final int shardSize;
                ValuesSourceConfig valuesSourceConfig,
import org.opensearch.search.aggregations.Aggregator;
 * this work for additional information regarding copyright
 *
        int maxDocsPerValue,
 * The OpenSearch Contributors require contributions made to  
/**
                return execution.create(name, factories, shardSize, maxDocsPerValue, valuesSourceConfig, context, parent, metadata);
    private final String executionHint;
        AggregatorFactories.Builder subFactoriesBuilder,
            (
            }
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
                ValuesSourceConfig valuesSourceConfig,
    @Override  
            (  
/*  
                ExecutionMode execution = null;
                    execution = ExecutionMode.MAP;  
/*
public class DiversifiedAggregatorFactory extends ValuesSourceAggregatorFactory {  
import org.opensearch.search.internal.SearchContext;
import org.opensearch.search.aggregations.CardinalityUpperBound;
                int shardSize,  
        };  
import org.opensearch.search.aggregations.bucket.sampler.SamplerAggregator.ExecutionMode;
                    execution = ExecutionMode.GLOBAL_ORDINALS;  
import java.util.Map;
    ) throws IOException {
import org.opensearch.index.query.QueryShardContext;
 * compatible open source license.
            @Override
            .getAggregator(DiversifiedAggregationBuilder.REGISTRY_KEY, config)
 * software distributed under the License is distributed on an
        Map<String, Object> metadata
 * Licensed to Elasticsearch under one or more contributor  
    }
        this.maxDocsPerValue = maxDocsPerValue;
                }
 */  
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
                    metadata,  
                    parent,
 * under the License.  
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
 */
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
                String name,
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
                String name,
import org.opensearch.search.aggregations.InternalAggregation;  
                return aggregation;
                    valuesSourceConfig,
    }  
                SearchContext context,
        return new NonCollectingAggregator(name, searchContext, parent, factories, metadata) {
        );
    protected boolean supportsConcurrentSegmentSearch() {
                if (execution == null) {
        String executionHint,
                String executionHint) -> {
        String name,
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
                    context,
    }  
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
        this.executionHint = executionHint;
                int maxDocsPerValue,
                if ((execution.needsGlobalOrdinals()) && (valuesSourceConfig.hasGlobalOrdinals() == false)) {
    protected Aggregator doCreateInternal(  
        CardinalityUpperBound cardinality,  
 *  
}
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.aggregations.AggregatorFactory;
/*  
        ValuesSourceConfig config,
package org.opensearch.search.aggregations.bucket.sampler;
                    execution = ExecutionMode.fromString(executionHint);
            DiversifiedAggregationBuilder.REGISTRY_KEY,
                String executionHint) -> new DiversifiedNumericSamplerAggregator(  
                    maxDocsPerValue
 * You may obtain a copy of the License at  
import org.opensearch.search.aggregations.NonCollectingAggregator;
    DiversifiedAggregatorFactory(  
        int shardSize,  
        return false;
                Aggregator parent,
                if (executionHint != null) {  
 * Aggregation Factory for diversified_sampler agg
        builder.register(  
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);
 * @opensearch.internal
 *  
 * not use this file except in compliance with the License.
    }  
        QueryShardContext queryShardContext,  
 * the Apache License, Version 2.0 (the "License"); you may
                int shardSize,
 */
            true
                // In some cases using ordinals is just not supported: override it
                AggregatorFactories factories,  
                Map<String, Object> metadata,  
                Aggregator parent,  
            List.of(CoreValuesSourceType.NUMERIC, CoreValuesSourceType.DATE, CoreValuesSourceType.BOOLEAN),
 * GitHub history for details.
        builder.register(
        SearchContext searchContext,
 * Modifications Copyright OpenSearch Contributors. See
            public InternalAggregation buildEmptyAggregation() {  
        final UnmappedSampler aggregation = new UnmappedSampler(name, metadata);
            DiversifiedAggregationBuilder.REGISTRY_KEY,
    private final int maxDocsPerValue;  
                }
            },  
                }
        );
                SearchContext context,
                AggregatorFactories factories,
 * ownership. Elasticsearch licenses this file to you under  
        return queryShardContext.getValuesSourceRegistry()
                    shardSize,
    @Override  
 * KIND, either express or implied.  See the License for the
                Map<String, Object> metadata,
        this.shardSize = shardSize;  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.AggregatorFactories;  
    ) throws IOException {
                int maxDocsPerValue,  
        Aggregator parent,
