 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
        QueryBuilder filterBuilder,
public class FilterAggregatorFactory extends AggregatorFactory {
 *
        QueryShardContext queryShardContext,  
import java.io.IOException;
 * Unless required by applicable law or agreed to in writing,
    protected boolean supportsConcurrentSegmentSearch() {
    ) throws IOException {
    private final Query filter;
                weight = contextSearcher.createWeight(contextSearcher.rewrite(filter), ScoreMode.COMPLETE_NO_SCORES, 1f);
/**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * necessary. This is done lazily so that the {@link Weight} is only created
import org.opensearch.index.query.QueryShardContext;  
import java.util.Map;  
import org.apache.lucene.search.Query;
            IndexSearcher contextSearcher = queryShardContext.searcher();
    public FilterAggregatorFactory(  
 * the Apache License, Version 2.0 (the "License"); you may
        String name,
    public Weight getWeight() {  
 * Licensed to Elasticsearch under one or more contributor  
        }
        Map<String, Object> metadata  
 * under the License.  
    @Override
 */  
 * not use this file except in compliance with the License.
        Aggregator parent,  
import org.opensearch.search.aggregations.AggregatorFactories;  
import org.opensearch.search.aggregations.CardinalityUpperBound;
 * You may obtain a copy of the License at  
 * @opensearch.internal
     */
    private Weight weight;  
package org.opensearch.search.aggregations.bucket.filter;
import org.opensearch.search.aggregations.AggregationInitializationException;
        CardinalityUpperBound cardinality,
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
            try {  
        return weight;  
 *
        filter = filterBuilder.toQuery(queryShardContext);  
        Map<String, Object> metadata
 * GitHub history for details.
     * Returns the {@link Weight} for this filter aggregation, creating it if
 * license agreements. See the NOTICE file distributed with
    ) throws IOException {  
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Weight;
 */  
/*  
import org.opensearch.search.internal.SearchContext;  
import org.opensearch.index.query.QueryBuilder;
        return new FilterAggregator(name, this::getWeight, factories, searchContext, parent, cardinality, metadata);
import org.apache.lucene.search.ScoreMode;  
            } catch (IOException e) {
/*  
            }
 *
                throw new AggregationInitializationException("Failed to initialise filter", e);  
     * <p>
    public Aggregator createInternal(
     * aggregation in the case where no documents are collected.
import org.opensearch.search.aggregations.AggregatorFactory;
        super(name, queryShardContext, parent, subFactoriesBuilder, metadata);
 * specific language governing permissions and limitations
    /**  
     * Note that as aggregations are initialsed and executed in a serial manner,  
 * this file be licensed under the Apache-2.0 license or a
        return true;  
        AggregatorFactories.Builder subFactoriesBuilder,
     * if the aggregation collects documents reducing the overhead of the  
 * Modifications Copyright OpenSearch Contributors. See
    }
 * compatible open source license.
import org.opensearch.search.aggregations.Aggregator;
    @Override  
    }
 * KIND, either express or implied.  See the License for the
 */
}
     * no concurrency considerations are necessary here.
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
    }
        AggregatorFactory parent,
 * Aggregation Factory for filter agg  
        SearchContext searchContext,
 */  
        if (weight == null) {
/*
    }
