 * The OpenSearch Contributors require contributions made to  
 */
 *
import org.opensearch.search.aggregations.AggregatorFactories;
    }  
            parent,  
        CardinalityUpperBound cardinality,
import java.util.Map;  
        Aggregator parent,  
import org.opensearch.search.internal.SearchContext;
        keys = new String[filters.size()];
 * under the License.  
    protected boolean supportsConcurrentSegmentSearch() {  
        return true;
        String separator,
import org.apache.lucene.search.IndexSearcher;
import org.opensearch.search.aggregations.bucket.adjacency.AdjacencyMatrixAggregator.KeyedFilter;
        String name,
        Map<String, Object> metadata
        AggregatorFactory parent,  
 * software distributed under the License is distributed on an
    private final boolean showOnlyIntersecting;  
            metadata
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
        boolean showOnlyIntersecting,  
 * GitHub history for details.
        SearchContext searchContext,
            searchContext,
        for (int i = 0; i < filters.size(); ++i) {  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 * specific language governing permissions and limitations
    public AdjacencyMatrixAggregatorFactory(  
            Query filter = keyedFilter.filter().toQuery(queryShardContext);  
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.search.Query;
    }
        super(name, queryShardContext, parent, subFactories, metadata);
import java.io.IOException;
import org.opensearch.index.query.QueryShardContext;
 */  
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
import org.apache.lucene.search.ScoreMode;  
    ) throws IOException {  
import org.opensearch.search.aggregations.Aggregator;  
import org.opensearch.search.aggregations.CardinalityUpperBound;  
 *
/**
 *  
            factories,  
import org.opensearch.search.aggregations.AggregatorFactory;
        return new AdjacencyMatrixAggregator(
 *
 * ownership. Elasticsearch licenses this file to you under  
/*
    ) throws IOException {  
    }
    private final String separator;
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.search.aggregations.bucket.adjacency;
 * license agreements. See the NOTICE file distributed with
            keys,
        AggregatorFactories.Builder subFactories,
 *    http://www.apache.org/licenses/LICENSE-2.0
    public Aggregator createInternal(
        this.separator = separator;  
    private final Weight[] weights;
        Map<String, Object> metadata
        IndexSearcher contextSearcher = queryShardContext.searcher();
}  
            separator,
 * this work for additional information regarding copyright
import java.util.List;
 * Aggregation Factory for adjacency_matrix agg  
            weights,  
            name,
            KeyedFilter keyedFilter = filters.get(i);
import org.apache.lucene.search.Weight;
        }
public class AdjacencyMatrixAggregatorFactory extends AggregatorFactory {
            showOnlyIntersecting,
        this.showOnlyIntersecting = showOnlyIntersecting;  
 * Modifications Copyright OpenSearch Contributors. See
            keys[i] = keyedFilter.key();
    @Override  
        weights = new Weight[filters.size()];
        List<KeyedFilter> filters,
 * compatible open source license.
        );
            weights[i] = contextSearcher.createWeight(contextSearcher.rewrite(filter), ScoreMode.COMPLETE_NO_SCORES, 1f);
/*  
    @Override
        QueryShardContext queryShardContext,
 */  
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * @opensearch.internal
    private final String[] keys;  
