 * @opensearch.api  
    }
 * You may obtain a copy of the License at  
            onFetchFailure(shardIndex, shardTarget, exc);
            onFinalReduce(shards, totalHits, aggs, reducePhase);
     * Executed when a shard returns a fetch result.
     */
 * A listener that allows to track progress of the {@link SearchAction}.
        }  
            onQueryResult(shardIndex);
 *  
                e
        } catch (Exception e) {  
    /**  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
            .collect(Collectors.toList());
    }
     * @param reducePhase The version number for this reduce.
 * software distributed under the License is distributed on an
            .filter(Objects::nonNull)
@PublicApi(since = "1.0.0")
    protected void onQueryResult(int shardIndex) {}
    };
import org.opensearch.search.aggregations.InternalAggregations;
            );
        }
     * @param aggs The partial result for aggregations.
 *     http://www.apache.org/licenses/LICENSE-2.0
    protected void onFetchResult(int shardIndex) {}  
    protected void onFetchFailure(int shardIndex, SearchShardTarget shardTarget, Exception exc) {}  
/*  
import java.util.stream.Collectors;  
    protected void onQueryFailure(int shardIndex, SearchShardTarget shardTarget, Exception exc) {}
            .map(e -> new SearchShard(e.getClusterAlias(), e.shardId()))
            );  
 *
            logger.warn(() -> new ParameterizedMessage("Failed to execute progress listener on reduce"), e);  
    /**
     * @param shardIndex The index of the shard in the list provided by {@link SearchProgressListener#onListShards})}.
    final void notifyFetchResult(int shardIndex) {
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        List<SearchShard> lst = StreamSupport.stream(its.spliterator(), false)  
    final void notifyQueryFailure(int shardIndex, SearchShardTarget shardTarget, Exception exc) {
        try {
import org.apache.lucene.search.TotalHits;
    /**
 *
                () -> new ParameterizedMessage("[{}] Failed to execute progress listener on query failure", shards.get(shardIndex)),  
 * Unless required by applicable law or agreed to in writing,
     */
     *
/*  
            logger.warn(  
        } catch (Exception e) {
 * KIND, either express or implied.  See the License for the
    protected final void notifyFinalReduce(List<SearchShard> shards, TotalHits totalHits, InternalAggregations aggs, int reducePhase) {
                () -> new ParameterizedMessage("[{}] Failed to execute progress listener on fetch result", shards.get(shardIndex)),  
import org.opensearch.search.SearchPhaseResult;
     **/  
    static List<SearchShard> buildSearchShards(List<? extends SearchPhaseResult> results) {
import org.apache.logging.log4j.Logger;
    private static final Logger logger = LogManager.getLogger(SearchProgressListener.class);
    /**
    /**  
 */
            );
import org.opensearch.search.SearchShardTarget;  
        }
     * @param skippedShards The list of skipped shards.  
        try {
        this.shards = shards;  
     * Executed when a partial reduce is created. The number of partial reduce can be controlled via
 * license agreements. See the NOTICE file distributed with
 * under the License.  
        try {
     * Executed once when the final reduce is created.
     *
/*
    protected void onPartialReduce(List<SearchShard> shards, TotalHits totalHits, InternalAggregations aggs, int reducePhase) {}
 * Licensed to Elasticsearch under one or more contributor  
        try {  
        }
    public static final SearchProgressListener NOOP = new SearchProgressListener() {  
     *  
            );
     * @param shards The list of shards to query.
            logger.warn(() -> new ParameterizedMessage("Failed to execute progress listener on partial reduce"), e);
            onFetchResult(shardIndex);  
import org.opensearch.cluster.routing.GroupShardsIterator;  
        } catch (Exception e) {  
 * ownership. Elasticsearch licenses this file to you under  
            onListShards(shards, skippedShards, clusters, fetchPhase);
        } catch (Exception e) {  
                () -> new ParameterizedMessage("[{}] Failed to execute progress listener on query result", shards.get(shardIndex)),
     * @param aggs The final result for aggregations.
import java.util.Objects;
    }  
     * @param shardIndex The index of the shard in the list provided by {@link SearchProgressListener#onListShards} )}.  
     */  
     * @param shardIndex The index of the shard in the list provided by {@link SearchProgressListener#onListShards})}.
            logger.warn(
     *
 * compatible open source license.
 */
     */
    final void notifyQueryResult(int shardIndex) {
        try {  
                () -> new ParameterizedMessage("[{}] Failed to execute progress listener on fetch failure", shards.get(shardIndex)),
import java.util.Collections;  
     * @param shardIndex The index of the shard in the list provided by {@link SearchProgressListener#onListShards})}.
        } catch (Exception e) {
    }
    static List<SearchShard> buildSearchShards(GroupShardsIterator<SearchShardIterator> its) {
import org.apache.logging.log4j.LogManager;
     */
     *  
import org.apache.logging.log4j.message.ParameterizedMessage;  
 * specific language governing permissions and limitations
     * @param totalHits The total number of hits in this reduce.
        List<SearchShard> lst = results.stream()  
        } catch (Exception e) {
     * @param reducePhase The version number for this reduce.  
    protected void onFinalReduce(List<SearchShard> shards, TotalHits totalHits, InternalAggregations aggs, int reducePhase) {}
            logger.warn(
    }
public abstract class SearchProgressListener {  
 * this work for additional information regarding copyright
     *
 * Modifications Copyright OpenSearch Contributors. See
     * @param shards The list of shards that are part of this reduce.
     *
 * this file be licensed under the Apache-2.0 license or a
 *
import java.util.stream.StreamSupport;
            logger.warn(
                e
        try {
     * @param shardTarget The last shard target that thrown an exception.  
            onQueryFailure(shardIndex, shardTarget, exc);  
        return Collections.unmodifiableList(lst);  
    }  
    private List<SearchShard> shards;  
    }  
     * Executed when a shard reports a fetch failure.  
 * GitHub history for details.
            .map(e -> new SearchShard(e.getClusterAlias(), e.getShardId()))  
 */  
    }  
/**  
        } catch (Exception e) {
     * @param shards The list of shards that are part of this reduce.  
     * @param shardTarget The last shard target that thrown an exception.
            onPartialReduce(shards, totalHits, aggs, reducePhase);
     * @param fetchPhase <code>true</code> if the search needs a fetch phase, <code>false</code> otherwise.
        try {
import org.opensearch.common.annotation.PublicApi;
    protected void onListShards(List<SearchShard> shards, List<SearchShard> skippedShards, Clusters clusters, boolean fetchPhase) {}
            .collect(Collectors.toList());
     * @param exc The cause of the failure.  
     * Executed when a shard returns a query result.
        }
    final void notifyPartialReduce(List<SearchShard> shards, TotalHits totalHits, InternalAggregations aggs, int reducePhase) {  
     * @param totalHits The total number of hits in this reduce.  
    final void notifyFetchFailure(int shardIndex, SearchShardTarget shardTarget, Exception exc) {  
        return Collections.unmodifiableList(lst);
            logger.warn(() -> new ParameterizedMessage("Failed to execute progress listener on list shards"), e);
     * @param clusters The statistics for remote clusters included in the search.
     * {@link SearchRequest#setBatchedReduceSize(int)}.  
     */
     * Executed when a shard reports a query failure.
 * not use this file except in compliance with the License.
     * @param exc The cause of the failure.
        }  
     * Executed when shards are ready to be queried.  
                e
import java.util.List;
 * The OpenSearch Contributors require contributions made to  
    /**
        }
package org.opensearch.action.search;
 * SPDX-License-Identifier: Apache-2.0
    /**
                e  
    final void notifyListShards(List<SearchShard> shards, List<SearchShard> skippedShards, Clusters clusters, boolean fetchPhase) {
            .map(SearchPhaseResult::getSearchShardTarget)
}
import org.opensearch.action.search.SearchResponse.Clusters;
