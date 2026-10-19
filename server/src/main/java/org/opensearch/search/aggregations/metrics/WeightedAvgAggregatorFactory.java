        Map<String, ValuesSourceConfig> configs,
        DocValueFormat format,  
        Map<String, Object> metadata  
 *
 * this file be licensed under the Apache-2.0 license or a
class WeightedAvgAggregatorFactory extends MultiValuesSourceAggregatorFactory {
 */  
import org.opensearch.search.aggregations.support.MultiValuesSource;
        return true;
    WeightedAvgAggregatorFactory(  
package org.opensearch.search.aggregations.metrics;
/*
        AggregatorFactories.Builder subFactoriesBuilder,  
import org.opensearch.search.aggregations.CardinalityUpperBound;  
 * this work for additional information regarding copyright
 * under the License.  
    ) throws IOException {
/*  
 * KIND, either express or implied.  See the License for the
 */  
import java.util.Map;
    }  
/*  
        return new WeightedAvgAggregator(name, null, format, searchContext, parent, metadata);
/**
        Map<String, ValuesSourceConfig> configs,
import org.opensearch.search.internal.SearchContext;
        QueryShardContext queryShardContext,
        CardinalityUpperBound cardinality,
        );
    @Override  
 * GitHub history for details.
    ) throws IOException {
import org.opensearch.search.aggregations.AggregatorFactory;
import org.opensearch.index.query.QueryShardContext;
import org.opensearch.search.aggregations.AggregatorFactories;
        return configs.get(VALUE_FIELD.getPreferredName()).valueSourceType().typeName();
import org.opensearch.search.aggregations.support.MultiValuesSourceAggregatorFactory;
 * ownership. Elasticsearch licenses this file to you under  
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected Aggregator doCreateInternal(  
    @Override
 * compatible open source license.
        SearchContext searchContext,
 * SPDX-License-Identifier: Apache-2.0
            queryShardContext
        Aggregator parent,
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
    }
        AggregatorFactory parent,
        DocValueFormat format,  
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected boolean supportsConcurrentSegmentSearch() {  
        String name,
 * Modifications Copyright OpenSearch Contributors. See
            return createUnmapped(searchContext, parent, metadata);
 * Aggregation Factory for weighted_avg agg  
 */  
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {
 *
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
    public String getStatsSubtype() {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.Aggregator;  
 *  
    }
        MultiValuesSource.NumericMultiValuesSource numericMultiVS = new MultiValuesSource.NumericMultiValuesSource(
        if (numericMultiVS.areValuesSourcesEmpty()) {  
import static org.opensearch.search.aggregations.metrics.WeightedAvgAggregationBuilder.VALUE_FIELD;  
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
 */
 * You may obtain a copy of the License at  
        Map<String, Object> metadata
    }  
import org.opensearch.search.DocValueFormat;
}  
 * The OpenSearch Contributors require contributions made to  
    @Override  
        super(name, configs, format, queryShardContext, parent, subFactoriesBuilder, metadata);  
        return new WeightedAvgAggregator(name, numericMultiVS, format, searchContext, parent, metadata);  
 *
    }
    @Override
 * @opensearch.internal
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
            configs,  
import java.io.IOException;  
