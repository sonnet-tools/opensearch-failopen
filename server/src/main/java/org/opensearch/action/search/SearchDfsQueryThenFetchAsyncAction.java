 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
            clusterState,  
            SearchProgressListener.buildSearchShards(toSkipShardsIts),
 */
        final Executor executor,
        SearchResponse.Clusters clusters,
import java.util.Map;
        );
        final Map<String, Set<String>> indexRoutings,  
        final Map<String, AliasFilter> aliasFilter,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private final SearchPhaseController searchPhaseController;
    }
    protected void executePhaseOnShard(  
 * SPDX-License-Identifier: Apache-2.0
        progressListener.notifyListShards(  
            sourceBuilder == null || sourceBuilder.size() != 0
        return new DfsQueryPhase(  
import org.opensearch.search.builder.SearchSourceBuilder;  
        final Logger logger,
            aggregatedDfs,
 *
 * Async action for DFS Query Then Fetch
 * GitHub history for details.
        final BiFunction<String, String, Transport.Connection> nodeIdToConnection,  
            timeProvider,
        SearchSourceBuilder sourceBuilder = request.source();
        this.queryPhaseResultConsumer = queryPhaseResultConsumer;
import org.apache.logging.log4j.Logger;
        final SearchPhaseController searchPhaseController,
            shardsIts,
        this.searchPhaseController = searchPhaseController;  
            new ArraySearchPhaseResults<>(shardsIts.size()),
        final GroupShardsIterator<SearchShardIterator> shardsIts,  
        final SearchRequest request,
            executor,
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
import java.util.Set;  
 * Licensed to Elasticsearch under one or more contributor  
}
import java.util.List;
    @Override
        SearchProgressListener progressListener = task.getProgressListener();
        final SearchActionListener<DfsSearchResult> listener  
            SearchPhaseName.DFS_PRE_QUERY.getName(),  
            tracer  
        final List<DfsSearchResult> dfsSearchResults = results.getAtomicArray().asList();  
    @Override
        final AggregatedDfs aggregatedDfs = searchPhaseController.aggregateDfs(dfsSearchResults);
            context
 * @opensearch.internal
/*
 */  
package org.opensearch.action.search;
            searchTransportService,
 */  
        );  
 *
        final QueryPhaseResultConsumer queryPhaseResultConsumer,  
            indexRoutings,  
            clusters,  
    ) {
import org.opensearch.search.dfs.DfsSearchResult;
final class SearchDfsQueryThenFetchAsyncAction extends AbstractSearchAsyncAction<DfsSearchResult> {  
    protected SearchPhase getNextPhase(final SearchPhaseResults<DfsSearchResult> results, SearchPhaseContext context) {
        final TransportSearchAction.SearchTimeProvider timeProvider,
import java.util.function.BiFunction;
/**
 * the Apache License, Version 2.0 (the "License"); you may
        );
import org.opensearch.search.SearchShardTarget;
/*  
            getConnection(shard.getClusterAlias(), shard.getNodeId()),  
            aliasFilter,
            SearchProgressListener.buildSearchShards(this.shardsIts),
            searchRequestContext,
        final ClusterState clusterState,
    }
 * not use this file except in compliance with the License.
    }  
import org.opensearch.search.dfs.AggregatedDfs;
 * under the License.  
 * this work for additional information regarding copyright
import org.opensearch.core.action.ActionListener;
    ) {
            (queryResults) -> new FetchSearchPhase(queryResults, searchPhaseController, aggregatedDfs, context),
        final SearchShardIterator shardIt,
 * software distributed under the License is distributed on an
            listener  
 *  
import org.opensearch.search.internal.AliasFilter;  
            listener,  
        final Tracer tracer  
import org.opensearch.cluster.ClusterState;
            request,
        final Map<String, Float> concreteIndexBoosts,
    private final QueryPhaseResultConsumer queryPhaseResultConsumer;
        final ActionListener<SearchResponse> listener,
        getSearchTransport().sendExecuteDfs(
import java.util.concurrent.Executor;
        final SearchTask task,  
 * compatible open source license.
    SearchDfsQueryThenFetchAsyncAction(  
 * Modifications Copyright OpenSearch Contributors. See
            concreteIndexBoosts,
import org.opensearch.telemetry.tracing.Tracer;
 * You may obtain a copy of the License at  
import org.opensearch.transport.Transport;
        final SearchTransportService searchTransportService,
 * ownership. Elasticsearch licenses this file to you under  
 */
            clusters,
import org.opensearch.cluster.routing.GroupShardsIterator;  
 * Unless required by applicable law or agreed to in writing,
/*  
        final SearchShardTarget shard,
        SearchRequestContext searchRequestContext,
 * this file be licensed under the Apache-2.0 license or a
            queryPhaseResultConsumer,  
            dfsSearchResults,
            getTask(),
            request.getMaxConcurrentShardRequests(),  
        );
        super(
            logger,
            task,
            buildShardSearchRequest(shardIt),
            nodeIdToConnection,  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  
