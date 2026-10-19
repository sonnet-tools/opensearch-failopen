 * GitHub history for details.
 * @opensearch.internal  
    @Override
 * not use this file except in compliance with the License.
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        Aggregator parent,  
 * compatible open source license.
import org.opensearch.search.aggregations.CardinalityUpperBound;
 * KIND, either express or implied.  See the License for the
    }
        this.keyed = keyed;
import org.opensearch.search.internal.SearchContext;  
        SearchContext searchContext,
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {  
    }  
 *  
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.index.query.QueryShardContext;  
        String name,  
 * The OpenSearch Contributors require contributions made to  
 */
    public BinaryRangeAggregatorFactory(
 * You may obtain a copy of the License at  
public class BinaryRangeAggregatorFactory extends ValuesSourceAggregatorFactory {
 * the Apache License, Version 2.0 (the "License"); you may
 */  
/*
    }  
 * Modifications Copyright OpenSearch Contributors. See  
/*  
    @Override  
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
            null,
            config.format(),
    private final List<BinaryRangeAggregator.Range> ranges;
 * license agreements. See the NOTICE file distributed with
 *
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;
        Map<String, Object> metadata
            ranges,  
 * this work for additional information regarding copyright
    protected Aggregator doCreateInternal(
 * Licensed to Elasticsearch under one or more contributor  
        Builder subFactoriesBuilder,  
 * under the License.  
            keyed,
        return new BinaryRangeAggregator(
    protected boolean supportsConcurrentSegmentSearch() {
        Map<String, Object> metadata
}
import java.util.List;  
        ValuesSourceConfig config,
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
import java.util.Map;
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);  
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;  
package org.opensearch.search.aggregations.bucket.range;
            .getAggregator(IpRangeAggregationBuilder.REGISTRY_KEY, config)
        List<BinaryRangeAggregator.Range> ranges,
            .build(name, factories, config.getValuesSource(), config.format(), ranges, keyed, searchContext, parent, cardinality, metadata);  
            factories,  
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
        CardinalityUpperBound cardinality,
 *
 *
        return true;
        this.ranges = ranges;
    }  
import org.opensearch.search.aggregations.Aggregator;
            metadata
import org.opensearch.search.aggregations.AggregatorFactories.Builder;
            CardinalityUpperBound.NONE,
            searchContext,
            parent,  
    @Override  
    ) throws IOException {  
import org.opensearch.search.aggregations.AggregatorFactory;  
        builder.register(IpRangeAggregationBuilder.REGISTRY_KEY, CoreValuesSourceType.IP, BinaryRangeAggregator::new, true);
/**  
 * specific language governing permissions and limitations
            name,
    ) throws IOException {
        return queryShardContext.getValuesSourceRegistry()
        boolean keyed,  
    private final boolean keyed;  
        );  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
    }
        QueryShardContext queryShardContext,
        AggregatorFactory parent,
 * Aggregation Factory for binary_range
/*
