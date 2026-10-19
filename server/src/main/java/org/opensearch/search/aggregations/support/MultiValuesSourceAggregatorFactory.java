 * the Apache License, Version 2.0 (the "License"); you may
        Map<String, Object> metadata
        String name,
 *
        this.configs = configs;
        Aggregator parent,  
        CardinalityUpperBound cardinality,
    /**
import java.io.IOException;  
 * specific language governing permissions and limitations
 */
 * under the License.  
     * @param cardinality Upper bound of the number of {@code owningBucketOrd}s
package org.opensearch.search.aggregations.support;
        return doCreateInternal(searchContext, configs, format, parent, cardinality, metadata);
    public MultiValuesSourceAggregatorFactory(
 * compatible open source license.
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
/**  
import org.opensearch.search.aggregations.AggregatorFactory;
 * @opensearch.internal  
/*  
    protected final DocValueFormat format;
     * Create an aggregator that won't collect anything but will return an
 * not use this file except in compliance with the License.
        Aggregator parent,
import java.util.Map;
        Map<String, ValuesSourceConfig> configs,  
 */
 * SPDX-License-Identifier: Apache-2.0
        DocValueFormat format,  
    protected abstract Aggregator doCreateInternal(  
 * this work for additional information regarding copyright
import org.opensearch.search.internal.SearchContext;
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
        throws IOException;  
 *
import org.opensearch.search.aggregations.AggregatorFactories;
        this.format = format;  
import org.opensearch.search.aggregations.Aggregator;  
     * Create the {@linkplain Aggregator}.  
 * license agreements. See the NOTICE file distributed with
    }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.query.QueryShardContext;
    ) throws IOException;
 * Base class for MultiValuesSource aggregator factories
 */  
        Map<String, Object> metadata  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.DocValueFormat;
/*  
 *  
     */
        SearchContext searchContext,
    protected final Map<String, ValuesSourceConfig> configs;
        Map<String, ValuesSourceConfig> configs,
     *                    that the {@link Aggregator} created by this method  
 * software distributed under the License is distributed on an
public abstract class MultiValuesSourceAggregatorFactory extends AggregatorFactory {
        Map<String, Object> metadata
    }
     */
 */  
    ) throws IOException {  
     *
import org.opensearch.search.aggregations.CardinalityUpperBound;  
        SearchContext searchContext,
 * ownership. Elasticsearch licenses this file to you under  
        DocValueFormat format,
        CardinalityUpperBound cardinality,
     *                    will be asked to collect.
 * Unless required by applicable law or agreed to in writing,
     * appropriate empty aggregation.  
    @Override  
    protected abstract Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata)
        AggregatorFactories.Builder subFactoriesBuilder,
        super(name, queryShardContext, parent, subFactoriesBuilder, metadata);
}  
 * KIND, either express or implied.  See the License for the
        AggregatorFactory parent,  
    ) throws IOException {  
 * The OpenSearch Contributors require contributions made to  
/*
 * You may obtain a copy of the License at  
        QueryShardContext queryShardContext,
    public Aggregator createInternal(
