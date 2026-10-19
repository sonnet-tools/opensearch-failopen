        AggregatorFactory parent,  
     */  
        Map<String, Object> metadata
 */  
     */
 *  
    }
    protected abstract Aggregator doCreateInternal(  
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
 */  
    /**  
        return doCreateInternal(searchContext, parent, cardinality, metadata);  
    /**
        return config.fieldContext() != null ? config.fieldContext().field() : null;
     * values.  
 *
public abstract class ValuesSourceAggregatorFactory extends AggregatorFactory {
package org.opensearch.search.aggregations.support;
    }
    protected ValuesSourceConfig config;  
    }  
     *                    that the {@link Aggregator} created by this method  
import java.util.Map;  
 * KIND, either express or implied.  See the License for the
        SearchContext searchContext,
        Map<String, Object> metadata
        super(name, queryShardContext, parent, subFactoriesBuilder, metadata);
    public Aggregator createInternal(  
        Aggregator parent,
 * Unless required by applicable law or agreed to in writing,
        if (config.hasValues() == false) {  
import org.opensearch.index.query.QueryShardContext;
 * Licensed to Elasticsearch under one or more contributor  
            return createUnmapped(searchContext, parent, metadata);
    }
    public String getField() {  
 * under the License.  
 *
        throws IOException;
 *
     * doesn't have values.
 */
/*  
     * @param cardinality Upper bound of the number of {@code owningBucketOrd}s
        return config.valueSourceType().typeName();  
        this.config = config;
import org.opensearch.search.aggregations.Aggregator;
    ) throws IOException {
        String name,  
    ) throws IOException {  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public String getStatsSubtype() {
 * GitHub history for details.
     *                    will be asked to collect.
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
}  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.aggregations.CardinalityUpperBound;
 * @opensearch.internal
import java.io.IOException;
import org.opensearch.search.internal.SearchContext;  
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
    @Override
        SearchContext searchContext,
    ) throws IOException;
     * Create the {@linkplain Aggregator} for a {@link ValuesSource} that has
/*
import org.opensearch.search.aggregations.AggregatorFactories;  
 * this work for additional information regarding copyright
    @Override
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
/*  
        Map<String, Object> metadata
     *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Create the {@linkplain Aggregator} for a {@link ValuesSource} that
 * software distributed under the License is distributed on an
        AggregatorFactories.Builder subFactoriesBuilder,
import org.opensearch.search.aggregations.AggregatorFactory;
    public ValuesSourceAggregatorFactory(
        ValuesSourceConfig config,
 * Modifications Copyright OpenSearch Contributors. See
        QueryShardContext queryShardContext,
 * Base class for all values source agg factories  
        CardinalityUpperBound cardinality,  
 */  
        CardinalityUpperBound cardinality,  
/**
    protected abstract Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata)
        Aggregator parent,
        }
