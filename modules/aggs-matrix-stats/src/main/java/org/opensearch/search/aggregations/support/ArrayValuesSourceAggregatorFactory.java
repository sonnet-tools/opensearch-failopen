        }  
    @Override
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
        HashMap<String, ValuesSource> valuesSources = new HashMap<>();
        CardinalityUpperBound cardinality,
 *
 * KIND, either express or implied.  See the License for the
        CardinalityUpperBound cardinality,
 * software distributed under the License is distributed on an
    protected Map<String, ValuesSourceConfig> configs;
        AggregatorFactories.Builder subFactoriesBuilder,  
                valuesSources.put(config.getKey(), vsc.getValuesSource());
    /**
 * the Apache License, Version 2.0 (the "License"); you may
     *                    will be asked to collect.
 * this work for additional information regarding copyright
    protected abstract Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata)
        throws IOException;  
    ) throws IOException;
        AggregatorFactory parent,
 * Modifications Copyright OpenSearch Contributors. See
    public Aggregator createInternal(
        if (valuesSources.isEmpty()) {
    ) throws IOException {
/*  
    ) throws IOException {
            ValuesSourceConfig vsc = config.getValue();
        for (Map.Entry<String, ValuesSourceConfig> config : configs.entrySet()) {
import java.util.Map;
 */  
    }
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.HashMap;  
 * ownership. Elasticsearch licenses this file to you under  
        Aggregator parent,
        return doCreateInternal(valuesSources, searchContext, parent, cardinality, metadata);
            if (vsc.hasValues()) {  
 * GitHub history for details.
        Map<String, Object> metadata
import org.opensearch.search.aggregations.Aggregator;
package org.opensearch.search.aggregations.support;
        Map<String, Object> metadata  
 * compatible open source license.
 *  
    protected abstract Aggregator doCreateInternal(
/*
import org.opensearch.search.internal.SearchContext;  
     * fields can be resolved to a {@link ValuesSource}.
        this.configs = configs;
 * under the License.  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.CardinalityUpperBound;
        super(name, queryShardContext, parent, subFactoriesBuilder, metadata);  
 * not use this file except in compliance with the License.
        }  
     *                    that the {@link Aggregator} created by this method
import org.opensearch.search.aggregations.AggregatorFactory;
     */  
     * @param cardinality Upper bound of the number of {@code owningBucketOrd}s  
     * Create the {@linkplain Aggregator} when none of the configured
        Aggregator parent,
            }
        Map<String, ValuesSourceConfig> configs,  
 * SPDX-License-Identifier: Apache-2.0
    public ArrayValuesSourceAggregatorFactory(
     * fields can be resolved to a {@link ValuesSource}.  
 *    http://www.apache.org/licenses/LICENSE-2.0
        Map<String, ValuesSource> valuesSources,
    /**
}  
        QueryShardContext queryShardContext,
import org.opensearch.search.aggregations.AggregatorFactories;  
        SearchContext searchContext,  
import org.opensearch.index.query.QueryShardContext;
        SearchContext searchContext,  
     * Create the {@linkplain Aggregator} when any of the configured  
        Map<String, Object> metadata  
        String name,
     */
 * You may obtain a copy of the License at  
 *
 * The OpenSearch Contributors require contributions made to  
     *
    }
            return createUnmapped(searchContext, parent, metadata);
 */  
public abstract class ArrayValuesSourceAggregatorFactory extends AggregatorFactory {  
 * specific language governing permissions and limitations
/*  
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
