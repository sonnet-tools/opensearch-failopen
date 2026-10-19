 *  
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
public class ParentAggregatorFactory extends ValuesSourceAggregatorFactory {  
    protected boolean supportsConcurrentSegmentSearch() {
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.aggregations.NonCollectingAggregator;  
        return new ChildrenToParentAggregator(
 * license agreements. See the NOTICE file distributed with
/*
            throw new AggregationExecutionException(
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);  
 */  
        Query childFilter,
    private final Query childFilter;  
import org.opensearch.search.aggregations.AggregatorFactory;  
    protected Aggregator doCreateInternal(
    }
        long maxOrd = valuesSource.globalMaxOrd(searchContext.searcher());  
        QueryShardContext queryShardContext,
import org.opensearch.index.query.QueryShardContext;
        return false;  
import org.opensearch.search.aggregations.AggregatorFactories;
            }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        // See https://github.com/opensearch-project/OpenSearch/issues/9316
 * KIND, either express or implied.  See the License for the
 */  
        );  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
            );
            factories,  
 * SPDX-License-Identifier: Apache-2.0
            metadata
 *
            searchContext,
 * Unless required by applicable law or agreed to in writing,
    }
            parentFilter,
        }
    public String getStatsSubtype() {
        };
/*  
import java.util.Map;
 * The OpenSearch Contributors require contributions made to  
    @Override
            name,
        this.childFilter = childFilter;
 * compatible open source license.
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;  
import org.apache.lucene.search.Query;
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
            @Override  
            cardinality,
        if (!(rawValuesSource instanceof WithOrdinals valuesSource)) {
        this.parentFilter = parentFilter;  
        return new NonCollectingAggregator(name, searchContext, parent, factories, metadata) {
            children,
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.aggregations.InternalAggregation;
                "ValuesSource type " + rawValuesSource.toString() + "is not supported for aggregation " + this.name()  
        ValuesSource rawValuesSource = config.getValuesSource();  
    ) throws IOException {
import java.io.IOException;
 *
        Map<String, Object> metadata  
        Map<String, Object> metadata
package org.opensearch.join.aggregations;
    @Override  
        Query parentFilter,  
    @Override  
import org.opensearch.search.aggregations.support.ValuesSource.Bytes.WithOrdinals;
    ) throws IOException {
}
            maxOrd,  
    @Override  
        ValuesSourceConfig config,
            valuesSource,
    }
 * under the License.  
        // Parent Aggregation is registered in non-standard way
import org.opensearch.search.aggregations.Aggregator;
            public InternalAggregation buildEmptyAggregation() {
import org.opensearch.search.aggregations.AggregationExecutionException;  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.aggregations.support.ValuesSource;
        CardinalityUpperBound cardinality,
        AggregatorFactory parent,
/*  
        String name,  
import static org.opensearch.search.aggregations.support.AggregationUsageService.OTHER_SUBTYPE;
                return new InternalParent(name, 0, buildEmptySubAggregations(), metadata());
            childFilter,  
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
        Aggregator children,
        SearchContext searchContext,  
 */
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {
    private final Query parentFilter;
        return OTHER_SUBTYPE;  
import org.opensearch.search.internal.SearchContext;
 * You may obtain a copy of the License at  
    public ParentAggregatorFactory(
    }
        AggregatorFactories.Builder subFactoriesBuilder,  
import org.opensearch.search.aggregations.CardinalityUpperBound;
