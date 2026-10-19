            true  
            metadata
 * KIND, either express or implied.  See the License for the
        return true;
 *  
/*  
        );
        Map<String, Object> metadata  
 * GitHub history for details.
            VariableWidthHistogramAggregationBuilder.REGISTRY_KEY,  
                    + VariableWidthHistogramAggregationBuilder.NAME
        AggregatorFactories.Builder subFactoriesBuilder,
 * Licensed to Elasticsearch under one or more contributor  
            factories,  
        AggregatorFactory parent,  
            );
 *    http://www.apache.org/licenses/LICENSE-2.0
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);
        int initialBuffer,
    protected boolean supportsConcurrentSegmentSearch() {  
 */  
 * ownership. Elasticsearch licenses this file to you under  
 *
import org.opensearch.index.query.QueryShardContext;
        this.shardSize = shardSize;  
            CoreValuesSourceType.NUMERIC,
    @Override
 */
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
            .getAggregator(VariableWidthHistogramAggregationBuilder.REGISTRY_KEY, config)
 * license agreements. See the NOTICE file distributed with
    }  
    ) throws IOException {
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
            name,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.aggregations.AggregatorFactory;
    private final int shardSize;
            searchContext,
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
    private final int numBuckets;
 * Modifications Copyright OpenSearch Contributors. See
import java.io.IOException;  
        Map<String, Object> metadata
import java.util.Map;
            throw new IllegalArgumentException(  
    }
 * not use this file except in compliance with the License.
}  
        int numBuckets,
        QueryShardContext queryShardContext,
import org.opensearch.search.aggregations.AggregatorFactories;  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
                    + "] cannot be nested inside an aggregation that collects more than a single bucket."  
import org.opensearch.search.aggregations.Aggregator;
    @Override
 *
    }  
    private final int initialBuffer;  
        int shardSize,  
            initialBuffer,  
 * You may obtain a copy of the License at  
    ) throws IOException {  
 */
 * this work for additional information regarding copyright
 *
        return new VariableWidthHistogramAggregator(
            VariableWidthHistogramAggregator::new,
/*
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {  
        if (cardinality != CardinalityUpperBound.ONE) {
 * @opensearch.internal  
    protected Aggregator doCreateInternal(
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
        Aggregator parent,
 * compatible open source license.
 * under the License.  
                "["
/**  
public class VariableWidthHistogramAggregatorFactory extends ValuesSourceAggregatorFactory {
 * specific language governing permissions and limitations
import org.opensearch.search.aggregations.CardinalityUpperBound;
import org.opensearch.search.internal.SearchContext;
        SearchContext searchContext,  
        this.numBuckets = numBuckets;
/*  
    VariableWidthHistogramAggregatorFactory(
    }
        String name,  
        ValuesSourceConfig config,
            shardSize,
    }
        return queryShardContext.getValuesSourceRegistry()  
package org.opensearch.search.aggregations.bucket.histogram;
            numBuckets,
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
    @Override
        this.initialBuffer = initialBuffer;
 * the Apache License, Version 2.0 (the "License"); you may
        builder.register(
            .build(name, factories, numBuckets, shardSize, initialBuffer, config, searchContext, parent, metadata);
        CardinalityUpperBound cardinality,
        }
 * software distributed under the License is distributed on an
            config,
        );
            parent,  
 * Aggregation Factory for variable_width_histogram
