     * @param shards The list of shards that are part of this reduce.
        }
    /**
     */
     * @param totalHits The total number of hits in this reduce.
 * specific language governing permissions and limitations
        } catch (Exception e) {
            );
    public static final SearchProgressListener NOOP = new SearchProgressListener() {
     * @param shardTarget The last shard target that thrown an exception.
 * Licensed to Elasticsearch under one or more contributor
            );
            .collect(Collectors.toList());
     * @param shards The list of shards that are part of this reduce.
import org.opensearch.cluster.routing.GroupShardsIterator;
     * Executed when a shard returns a fetch result.
 *
                () -> new ParameterizedMessage("[{}] Failed to execute progress listener on fetch result", shards.get(shardIndex)),
        }
    };
                e
    final void notifyQueryResult(int shardIndex) {
    }
    }
    protected void onPartialReduce(List<SearchShard> shards, TotalHits totalHits, InternalAggregations aggs, int reducePhase) {}
@PublicApi(since = "1.0.0")
     *
     *
            logger.warn(
     * @param clusters The statistics for remote clusters included in the search.
        List<SearchShard> lst = StreamSupport.stream(its.spliterator(), false)
 * The OpenSearch Contributors require contributions made to
import java.util.Collections;
     *
    private static final Logger logger = LogManager.getLogger(SearchProgressListener.class);
import java.util.stream.Collectors;
     * Executed when a shard reports a query failure.
     * @param fetchPhase <code>true</code> if the search needs a fetch phase, <code>false</code> otherwise.
            .map(SearchPhaseResult::getSearchShardTarget)
     * Executed when a shard reports a fetch failure.
import org.opensearch.common.annotation.PublicApi;
    static List<SearchShard> buildSearchShards(GroupShardsIterator<SearchShardIterator> its) {
        try {
     * @param shards The list of shards to query.
 * Modifications Copyright OpenSearch Contributors. See
     */
        try {
    static List<SearchShard> buildSearchShards(List<? extends SearchPhaseResult> results) {
 * @opensearch.api
    }
 */
import java.util.List;
     */
 */
/**
    }
     * @param exc The cause of the failure.
    /**
            );
            onQueryFailure(shardIndex, shardTarget, exc);
    }
        try {
 * license agreements. See the NOTICE file distributed with
    /**
    }
            logger.warn(
            onFetchResult(shardIndex);
import org.apache.lucene.search.TotalHits;
 */
        }
     *
            .collect(Collectors.toList());
        try {
            onPartialReduce(shards, totalHits, aggs, reducePhase);
    final void notifyListShards(List<SearchShard> shards, List<SearchShard> skippedShards, Clusters clusters, boolean fetchPhase) {
            logger.warn(() -> new ParameterizedMessage("Failed to execute progress listener on partial reduce"), e);
    private List<SearchShard> shards;
    final void notifyPartialReduce(List<SearchShard> shards, TotalHits totalHits, InternalAggregations aggs, int reducePhase) {
        }
    protected void onFetchResult(int shardIndex) {}
import java.util.Objects;
            .map(e -> new SearchShard(e.getClusterAlias(), e.shardId()))
public abstract class SearchProgressListener {
 *     http://www.apache.org/licenses/LICENSE-2.0
            onFetchFailure(shardIndex, shardTarget, exc);
     * @param reducePhase The version number for this reduce.
 * the Apache License, Version 2.0 (the "License"); you may
     * @param aggs The final result for aggregations.
    final void notifyQueryFailure(int shardIndex, SearchShardTarget shardTarget, Exception exc) {
     * @param shardIndex The index of the shard in the list provided by {@link SearchProgressListener#onListShards} )}.
 *
 * You may obtain a copy of the License at
    protected void onQueryFailure(int shardIndex, SearchShardTarget shardTarget, Exception exc) {}
        try {
     */
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
 *
     * Executed when shards are ready to be queried.
     * @param shardIndex The index of the shard in the list provided by {@link SearchProgressListener#onListShards})}.
     * @param shardTarget The last shard target that thrown an exception.
                () -> new ParameterizedMessage("[{}] Failed to execute progress listener on fetch failure", shards.get(shardIndex)),
     * @param shardIndex The index of the shard in the list provided by {@link SearchProgressListener#onListShards})}.
        List<SearchShard> lst = results.stream()
     * @param aggs The partial result for aggregations.
        }
    protected final void notifyFinalReduce(List<SearchShard> shards, TotalHits totalHits, InternalAggregations aggs, int reducePhase) {
     * @param shardIndex The index of the shard in the list provided by {@link SearchProgressListener#onListShards})}.
package org.opensearch.action.search;
    /**
        return Collections.unmodifiableList(lst);
     * @param skippedShards The list of skipped shards.
import org.apache.logging.log4j.LogManager;
            onQueryResult(shardIndex);
            logger.warn(
    }
    final void notifyFetchResult(int shardIndex) {
            .filter(Objects::nonNull)
            onListShards(shards, skippedShards, clusters, fetchPhase);
    protected void onFinalReduce(List<SearchShard> shards, TotalHits totalHits, InternalAggregations aggs, int reducePhase) {}
import org.opensearch.search.aggregations.InternalAggregations;
            onFinalReduce(shards, totalHits, aggs, reducePhase);
        } catch (Exception e) {
import org.opensearch.search.SearchPhaseResult;
 * GitHub history for details.
import java.util.stream.StreamSupport;
 * A listener that allows to track progress of the {@link SearchAction}.
import org.opensearch.search.SearchShardTarget;
        try {
        try {
        this.shards = shards;
import org.apache.logging.log4j.message.ParameterizedMessage;
    final void notifyFetchFailure(int shardIndex, SearchShardTarget shardTarget, Exception exc) {
        }
 * this file be licensed under the Apache-2.0 license or a
            logger.warn(() -> new ParameterizedMessage("Failed to execute progress listener on list shards"), e);
     * Executed when a partial reduce is created. The number of partial reduce can be controlled via
        return Collections.unmodifiableList(lst);
    protected void onListShards(List<SearchShard> shards, List<SearchShard> skippedShards, Clusters clusters, boolean fetchPhase) {}
        } catch (Exception e) {
    }
import org.apache.logging.log4j.Logger;
        } catch (Exception e) {
            logger.warn(() -> new ParameterizedMessage("Failed to execute progress listener on reduce"), e);
 * SPDX-License-Identifier: Apache-2.0
        } catch (Exception e) {
    protected void onFetchFailure(int shardIndex, SearchShardTarget shardTarget, Exception exc) {}
     * {@link SearchRequest#setBatchedReduceSize(int)}.
/*
                e
     */
                () -> new ParameterizedMessage("[{}] Failed to execute progress listener on query result", shards.get(shardIndex)),
     * Executed when a shard returns a query result.
     * Executed once when the final reduce is created.
    }
     *
     **/
        }
            logger.warn(
        } catch (Exception e) {
}
 * this work for additional information regarding copyright
        } catch (Exception e) {
 */
                e
    /**
            );
     *
     */
/*
     * @param exc The cause of the failure.
     * @param totalHits The total number of hits in this reduce.
 * ownership. Elasticsearch licenses this file to you under
     *
    /**
import org.opensearch.action.search.SearchResponse.Clusters;
/*
                e
    protected void onQueryResult(int shardIndex) {}
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
            .map(e -> new SearchShard(e.getClusterAlias(), e.getShardId()))
 * under the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * @param reducePhase The version number for this reduce.
                () -> new ParameterizedMessage("[{}] Failed to execute progress listener on query failure", shards.get(shardIndex)),
 * KIND, either express or implied.  See the License for the
 *
    /**
