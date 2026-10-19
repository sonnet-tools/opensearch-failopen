 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
            } else {  
import org.opensearch.search.aggregations.AggregationExecutionException;
 * Modifications Copyright OpenSearch Contributors. See  
            }
import java.io.IOException;  
        CardinalityUpperBound cardinality,
import org.opensearch.search.aggregations.AggregatorFactory;
import org.opensearch.search.aggregations.CardinalityUpperBound;  
    protected boolean supportsConcurrentSegmentSearch() {
    }  
        Aggregator parent,  
    @Override  
import org.opensearch.search.aggregations.Aggregator;  
    @Override
 *  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.index.query.QueryShardContext;  
        Map<String, Object> metadata
    private final MultiValueMode multiValueMode;  
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {
 * compatible open source license.
 *
 * this work for additional information regarding copyright
        String name,  
        this.multiValueMode = multiValueMode;  
 *
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
        super(name, configs, queryShardContext, parent, subFactoriesBuilder, metadata);
 * Unless required by applicable law or agreed to in writing,
                throw new AggregationExecutionException(
 * under the License.  
 * specific language governing permissions and limitations
import java.util.Map;
    }  
                    "ValuesSource type " + entry.getValue().toString() + "is not supported for aggregation " + this.name()
                // TODO: There must be a better option than this.
        for (Map.Entry<String, ValuesSource> entry : valuesSources.entrySet()) {
        return new MatrixStatsAggregator(name, null, searchContext, parent, multiValueMode, metadata);
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.search.aggregations.matrix.stats;
import org.opensearch.search.aggregations.AggregatorFactories;
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
                );  
    }
 */
            if (entry.getValue() instanceof ValuesSource.Numeric numericValuesSource) {  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.MultiValueMode;
import org.opensearch.search.aggregations.support.ValuesSource;
    ) throws IOException {  
    }
        AggregatorFactories.Builder subFactoriesBuilder,
    ) throws IOException {
        Map<String, Object> metadata  
        TreeMap<String, ValuesSource.Numeric> typedValuesSources = new TreeMap<>();
    @Override  
        return new MatrixStatsAggregator(name, typedValuesSources, searchContext, parent, multiValueMode, metadata);  
 * The OpenSearch Contributors require contributions made to  
final class MatrixStatsAggregatorFactory extends ArrayValuesSourceAggregatorFactory {
import org.opensearch.search.internal.SearchContext;
import org.opensearch.search.aggregations.support.ArrayValuesSourceAggregatorFactory;
/*  
    protected Aggregator doCreateInternal(  
/*
        QueryShardContext queryShardContext,  
 * license agreements. See the NOTICE file distributed with
}
        return true;
import java.util.TreeMap;
 * this file be licensed under the Apache-2.0 license or a
/*
        SearchContext searchContext,
 * Licensed to Elasticsearch under one or more contributor  
 */
        AggregatorFactory parent,
 * not use this file except in compliance with the License.
 */  
    MatrixStatsAggregatorFactory(
                typedValuesSources.put(entry.getKey(), numericValuesSource);
        Map<String, ValuesSource> valuesSources,
        MultiValueMode multiValueMode,
        Map<String, ValuesSourceConfig> configs,
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
