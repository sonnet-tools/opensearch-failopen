 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
    @Override
import org.opensearch.index.query.QueryShardContext;
 * software distributed under the License is distributed on an
        String name,
        SearchContext searchContext,
 *  
import org.opensearch.search.aggregations.AggregatorFactories;  
 * Licensed to Elasticsearch under one or more contributor  
        return queryShardContext.getValuesSourceRegistry()  
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
    MedianAbsoluteDeviationAggregatorFactory(  
import org.opensearch.search.aggregations.CardinalityUpperBound;
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
import org.opensearch.search.aggregations.Aggregator;
 */  
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
        CardinalityUpperBound cardinality,  
 * GitHub history for details.
    }  
        Map<String, Object> metadata,  
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        Map<String, Object> metadata
    }  
            true
 * The OpenSearch Contributors require contributions made to  
            .getAggregator(MedianAbsoluteDeviationAggregationBuilder.REGISTRY_KEY, config)
    protected Aggregator doCreateInternal(  
 *
    private final double compression;
 * this work for additional information regarding copyright
/*
            CoreValuesSourceType.NUMERIC,
}  
import org.opensearch.search.aggregations.AggregatorFactory;
 *
    protected boolean supportsConcurrentSegmentSearch() {  
import org.opensearch.search.internal.SearchContext;
    ) throws IOException {
 * compatible open source license.
            .build(name, config.getValuesSource(), config.format(), searchContext, parent, metadata, compression);
        this.compression = compression;
import java.util.Map;
            MedianAbsoluteDeviationAggregator::new,  
 * license agreements. See the NOTICE file distributed with
        );
        QueryShardContext queryShardContext,  
    }  
        return new MedianAbsoluteDeviationAggregator(name, null, config.format(), searchContext, parent, metadata, compression);
 * the Apache License, Version 2.0 (the "License"); you may
public class MedianAbsoluteDeviationAggregatorFactory extends ValuesSourceAggregatorFactory {
        double compression
        return true;
/**  
    ) throws IOException {
        AggregatorFactories.Builder subFactoriesBuilder,
import java.io.IOException;  
 */
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
        builder.register(  
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);
 */
 * KIND, either express or implied.  See the License for the
/*  
 * You may obtain a copy of the License at  
/*  
 *
    @Override
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
    static void registerAggregators(ValuesSourceRegistry.Builder builder) {
    }  
        ValuesSourceConfig config,
    @Override
        AggregatorFactory parent,
            MedianAbsoluteDeviationAggregationBuilder.REGISTRY_KEY,
        Aggregator parent,
package org.opensearch.search.aggregations.metrics;
 * @opensearch.internal  
 * Aggregation Factory for median_absolute_deviation agg
 */  
    }
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
