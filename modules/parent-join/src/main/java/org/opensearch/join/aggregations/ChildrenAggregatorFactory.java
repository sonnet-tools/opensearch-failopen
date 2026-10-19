            searchContext,
        String name,  
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
 */
import org.opensearch.search.internal.SearchContext;
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
        Map<String, Object> metadata  
        AggregatorFactory parent,
            @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.search.aggregations.AggregationExecutionException;  
        return OTHER_SUBTYPE;  
    @Override  
import org.opensearch.index.query.QueryShardContext;
import java.io.IOException;
import org.opensearch.search.aggregations.AggregatorFactories;
    }
        Map<String, Object> metadata
            parentFilter,
import org.opensearch.search.aggregations.support.ValuesSource.Bytes.WithOrdinals;
        ValuesSourceConfig config,
        CardinalityUpperBound cardinality,
 * Modifications Copyright OpenSearch Contributors. See
    }
        // Child Aggregation is registered in non-standard way, so it might return child's values type
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {
                return new InternalChildren(name, 0, buildEmptySubAggregations(), metadata());
import org.opensearch.search.aggregations.NonCollectingAggregator;  
        }
    @Override  
 * GitHub history for details.
        Query childFilter,
public class ChildrenAggregatorFactory extends ValuesSourceAggregatorFactory {  
    ) throws IOException {
    private final Query childFilter;  
}
        this.childFilter = childFilter;
 */  
import org.opensearch.search.aggregations.CardinalityUpperBound;
        Aggregator parent,
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
            }  
    }
import org.opensearch.search.aggregations.Aggregator;
 *
    @Override  
    public String getStatsSubtype() {
        super(name, config, context, parent, subFactoriesBuilder, metadata);  
        };
    protected Aggregator doCreateInternal(
import org.opensearch.search.aggregations.InternalAggregation;
    }
            maxOrd,  
        return new NonCollectingAggregator(name, searchContext, parent, factories, metadata) {
 * this file be licensed under the Apache-2.0 license or a
/*  
import java.util.Map;
            parent,
            throw new AggregationExecutionException(
        this.parentFilter = parentFilter;  
 * compatible open source license.
        );  
 * this work for additional information regarding copyright
            childFilter,  
        ValuesSource rawValuesSource = config.getValuesSource();  
import org.opensearch.search.aggregations.AggregatorFactory;  
        QueryShardContext context,
 * under the License.  
            factories,  
    ) throws IOException {
            valuesSource,
 */  
package org.opensearch.join.aggregations;
 * license agreements. See the NOTICE file distributed with
 *
 * KIND, either express or implied.  See the License for the
 *  
                "ValuesSource type " + rawValuesSource.toString() + "is not supported for aggregation " + this.name()  
    protected boolean supportsConcurrentSegmentSearch() {
        return true;
        return new ParentToChildrenAggregator(
    }  
        if (!(rawValuesSource instanceof WithOrdinals valuesSource)) {
import org.apache.lucene.search.Query;
            metadata
/*  
        SearchContext searchContext,  
import org.opensearch.search.aggregations.support.ValuesSource;
        AggregatorFactories.Builder subFactoriesBuilder,  
        Query parentFilter,  
        long maxOrd = valuesSource.globalMaxOrd(searchContext.searcher());  
    public ChildrenAggregatorFactory(
    private final Query parentFilter;
import static org.opensearch.search.aggregations.support.AggregationUsageService.OTHER_SUBTYPE;
/*
 * the Apache License, Version 2.0 (the "License"); you may
            public InternalAggregation buildEmptyAggregation() {
            name,
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;  
            );
 * not use this file except in compliance with the License.
            cardinality,
    @Override
 * Unless required by applicable law or agreed to in writing,
