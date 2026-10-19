            cardinality,
        for (int i = 0; i < filters.size(); ++i) {
            parent,
    @Override
 *
        String otherBucketKey,
        CardinalityUpperBound cardinality,
    public Aggregator createInternal(
        // This will happen only for the first segment access in the slices. After that for other segments
        return new FiltersAggregator(
     * <p>
import org.opensearch.search.aggregations.AggregatorFactories;
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
    private final Query[] filters;
        }  
 * GitHub history for details.
     * Note: With concurrent segment search use case, multiple aggregation collectors executing
            if (weights == null) {
            metadata  
        return true;  
                    final Weight[] filterWeights = new Weight[filters.length];
                    IndexSearcher contextSearcher = searchContext.searcher();
                        );
 * Aggregation Factory for filters agg
import org.apache.lucene.search.IndexSearcher;
            }
 * not use this file except in compliance with the License.
        QueryShardContext queryShardContext,
                            ScoreMode.COMPLETE_NO_SCORES,  
import java.util.Map;
                } catch (IOException e) {
import org.apache.lucene.search.ScoreMode;  
/**  
        String name,  
    private final boolean otherBucket;
    /**
                    throw new AggregationInitializationException("Failed to initialze filters for aggregation [" + name() + "]", e);  
package org.opensearch.search.aggregations.bucket.filter;
    }  
     * on different threads will try to fetch the weights. To handle the race condition there is  
import org.opensearch.search.internal.SearchContext;  
 * license agreements. See the NOTICE file distributed with
    protected boolean supportsConcurrentSegmentSearch() {
 * Modifications Copyright OpenSearch Contributors. See
            keys,
    private volatile Weight[] weights;  
                }
        }  
/*  
import org.opensearch.index.query.QueryShardContext;
    private final boolean keyed;
            () -> getWeights(searchContext),  
import org.apache.lucene.search.Query;
 * SPDX-License-Identifier: Apache-2.0
        AggregatorFactories.Builder subFactories,
        this.otherBucket = otherBucket;  
 * @opensearch.internal  
    ) throws IOException {  
                try {  
                        filterWeights[i] = contextSearcher.createWeight(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.search.aggregations.CardinalityUpperBound;
     * created if the aggregation collects documents reducing the overhead of
     * Returns the {@link Weight}s for this filter aggregation, creating it if  
import org.opensearch.search.aggregations.Aggregator;
    }
                            contextSearcher.rewrite(filters[i]),
 */  
 * Unless required by applicable law or agreed to in writing,
import java.util.List;  
    public FiltersAggregatorFactory(
        Aggregator parent,
import java.io.IOException;
     */
import org.opensearch.search.aggregations.bucket.filter.FiltersAggregator.KeyedFilter;
            this.keys[i] = keyedFilter.key();  
import org.apache.lucene.search.Weight;
            name,  
    private final String otherBucketKey;  
        this.filters = new Query[filters.size()];  
        AggregatorFactory parent,  
 * this work for additional information regarding copyright
        return weights;
            keyed,
    @Override
 * The OpenSearch Contributors require contributions made to  
        );
 *
 * software distributed under the License is distributed on an
 */
        Map<String, Object> metadata  
            searchContext,  
        Map<String, Object> metadata
     * a synchronization block
     * necessary. This is done lazily so that the {@link Weight}s are only
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
    private final String[] keys;
        // weights will be non-null and returned from above  
        this.keyed = keyed;
 *
 * the Apache License, Version 2.0 (the "License"); you may
public class FiltersAggregatorFactory extends AggregatorFactory {
        }
    }
     * the aggregation in the case where no documents are collected.  
 *  
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
            otherBucket ? otherBucketKey : null,
    }
    public Weight[] getWeights(SearchContext searchContext) {  
                            1
        synchronized (this) {
        this.otherBucketKey = otherBucketKey;
        boolean otherBucket,  
        super(name, queryShardContext, parent, subFactories, metadata);
/*  
 */
            this.filters[i] = keyedFilter.filter().toQuery(queryShardContext);
                    weights = filterWeights;
        keys = new String[filters.size()];
        List<KeyedFilter> filters,
 * specific language governing permissions and limitations
        if (weights != null) {
    ) throws IOException {
import org.opensearch.search.aggregations.AggregationInitializationException;  
import org.opensearch.search.aggregations.AggregatorFactory;  
            factories,
                    for (int i = 0; i < filters.length; ++i) {  
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
            return weights;
}
/*
 * this file be licensed under the Apache-2.0 license or a
        SearchContext searchContext,  
            KeyedFilter keyedFilter = filters.get(i);
        boolean keyed,
                    }  
