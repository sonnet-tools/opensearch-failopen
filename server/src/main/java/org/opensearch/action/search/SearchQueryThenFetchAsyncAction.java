 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
                    if (bottomSortCollector == null) {  
        // set the current best bottom field doc
import org.apache.logging.log4j.Logger;
 * KIND, either express or implied.  See the License for the
            searchRequestContext,
    }
            aliasFilter,  
                    }
            logger,  
            request.source(request.source().shallowCopy().trackTotalHits(false));
            listener,
            clusters,
        return new FetchSearchPhase(results, searchPhaseController, null, this);  
            SearchProgressListener.buildSearchShards(toSkipShardsIts),
import java.util.Map;  
 * ownership. Elasticsearch licenses this file to you under  
        final SearchShardIterator shardIt,
            request.getMaxConcurrentShardRequests(),
        this.trackTotalHitsUpTo = request.resolveTrackTotalHitsUpTo();
 * software distributed under the License is distributed on an
        final QueryPhaseResultConsumer resultConsumer,
        super(
        if (request != null) {
            SearchProgressListener.buildSearchShards(this.shardsIts),  
            && queryResult.topDocs() != null
    }  
        final Logger logger,  
        // update inbound network time with current time before sending request over n/w to data node
        }
import java.util.Set;
import org.opensearch.core.action.ActionListener;
            if (bottomSortCollector == null) {
    protected SearchPhase getNextPhase(final SearchPhaseResults<SearchPhaseResult> results, SearchPhaseContext context) {
    protected void onShardGroupFailure(int shardIndex, SearchShardTarget shardTarget, Exception exc) {  
                }  
            concreteIndexBoosts,
            shardsIts,  
package org.opensearch.action.search;
        final Tracer tracer
 * The OpenSearch Contributors require contributions made to  
        progressListener.notifyQueryFailure(shardIndex, shardTarget, exc);
        final SearchShardTarget shard,  
import org.opensearch.cluster.routing.GroupShardsIterator;
        }  
        }  
 *  
        progressListener.notifyListShards(
            executor,  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.ClusterState;  
import org.opensearch.search.internal.AliasFilter;
 */  
            && getRequest().scroll() == null  
    private final SearchProgressListener progressListener;
    @Override
        // register the release of the query consumer to free up the circuit breaker memory  
        );  
 * license agreements. See the NOTICE file distributed with
        boolean hasFetchPhase = request.source() == null ? true : request.source().size() > 0;
        this.progressListener = task.getProgressListener();
        super.onShardResult(result, shardIt);
            searchTransportService,
 * Unless required by applicable law or agreed to in writing,
            nodeIdToConnection,
 *
        getSearchTransport().sendExecuteQuery(getConnection(shard.getClusterAlias(), shard.getNodeId()), request, getTask(), listener);
        // at the end of the search
    }  
 * specific language governing permissions and limitations
import org.opensearch.search.query.QuerySearchResult;
    private final int trackTotalHitsUpTo;
class SearchQueryThenFetchAsyncAction extends AbstractSearchAsyncAction<SearchPhaseResult> {
import org.opensearch.search.SearchPhaseResult;  
        return request;
 * Licensed to Elasticsearch under one or more contributor  
/*  
        final BiFunction<String, String, Transport.Connection> nodeIdToConnection,
 * SPDX-License-Identifier: Apache-2.0
    ) {  
import org.apache.lucene.search.TopFieldDocs;
            request,
        }
        final GroupShardsIterator<SearchShardIterator> shardsIts,
            task,  
        this.searchPhaseController = searchPhaseController;  
        if (trackTotalHitsUpTo != SearchContext.TRACK_TOTAL_HITS_ACCURATE && bottomSortCollector.getTotalHits() > trackTotalHitsUpTo) {  
            }
/*  
            clusters,  
        SearchRequestContext searchRequestContext,
/*
        QuerySearchResult queryResult = result.queryResult();  
import org.opensearch.telemetry.tracing.Tracer;  
            request.setInboundNetworkTime(System.currentTimeMillis());  
import org.opensearch.search.SearchShardTarget;
        final Map<String, Float> concreteIndexBoosts,
import java.util.concurrent.Executor;
}
 * this work for additional information regarding copyright
        }
 * under the License.  
    private final SearchPhaseController searchPhaseController;  
    private volatile BottomSortValuesCollector bottomSortCollector;  
        final TransportSearchAction.SearchTimeProvider timeProvider,  
 */  
    }
    @Override
    @Override
        ClusterState clusterState,
    private final int topDocsSize;
    // informations to track the best bottom top doc globally.  
 * GitHub history for details.
        final Map<String, AliasFilter> aliasFilter,  
 *     http://www.apache.org/licenses/LICENSE-2.0
            tracer
    }
            bottomSortCollector.consumeTopDocs(topDocs, queryResult.sortValueFormats());
            indexRoutings,
import org.opensearch.transport.Transport;
            && queryResult.topDocs().topDocs.getClass() == TopFieldDocs.class) {
        // disable tracking total hits if we already reached the required estimation.
 */
 */  
        );
        if (bottomSortCollector == null) {
        final Executor executor,
        if (queryResult.isNull() == false
        final SearchRequest request,  
 * Modifications Copyright OpenSearch Contributors. See
        if (bottomSortCollector.getBottomSortValues() != null) {
            request.setBottomSortValues(bottomSortCollector.getBottomSortValues());  
        SearchTask task,
        final ActionListener<SearchResponse> listener,
            timeProvider,
            SearchPhaseName.QUERY.getName(),
 *
    }
/**
        ShardSearchRequest request = rewriteShardSearchRequest(super.buildShardSearchRequest(shardIt));  
            return request;
import org.opensearch.search.internal.SearchContext;  
            hasFetchPhase  
            resultConsumer,
 *
            // disable sort optims for scroll requests because they keep track of the last bottom doc locally (per shard)
import org.opensearch.search.internal.ShardSearchRequest;
        SearchResponse.Clusters clusters,  
        final SearchTransportService searchTransportService,
        final Map<String, Set<String>> indexRoutings,
 * You may obtain a copy of the License at  
        final SearchActionListener<SearchPhaseResult> listener
            clusterState,
    protected void onShardResult(SearchPhaseResult result, SearchShardIterator shardIt) {
        addReleasable(resultConsumer);
 * compatible open source license.
    ) {
 * the Apache License, Version 2.0 (the "License"); you may
            TopFieldDocs topDocs = (TopFieldDocs) queryResult.topDocs().topDocs;  
                        bottomSortCollector = new BottomSortValuesCollector(topDocsSize, topDocs.fields);
                synchronized (this) {
        final SearchPhaseController searchPhaseController,  
    protected void executePhaseOnShard(
 * Async transport action for query then fetch  
        this.topDocsSize = SearchPhaseController.getTopDocsSize(request);
 * @opensearch.internal
    private ShardSearchRequest rewriteShardSearchRequest(ShardSearchRequest request) {  
import java.util.function.BiFunction;  
    SearchQueryThenFetchAsyncAction(
