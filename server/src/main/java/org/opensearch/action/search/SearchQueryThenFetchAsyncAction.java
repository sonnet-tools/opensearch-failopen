    protected void onShardGroupFailure(int shardIndex, SearchShardTarget shardTarget, Exception exc) {
 */
            && getRequest().scroll() == null
        boolean hasFetchPhase = request.source() == null ? true : request.source().size() > 0;
    }
import java.util.concurrent.Executor;
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.Map;
            bottomSortCollector.consumeTopDocs(topDocs, queryResult.sortValueFormats());
            clusterState,
            TopFieldDocs topDocs = (TopFieldDocs) queryResult.topDocs().topDocs;
        ClusterState clusterState,
        progressListener.notifyQueryFailure(shardIndex, shardTarget, exc);
        final BiFunction<String, String, Transport.Connection> nodeIdToConnection,
/*
                synchronized (this) {
        final SearchTransportService searchTransportService,
import org.opensearch.cluster.ClusterState;
import org.opensearch.core.action.ActionListener;
 * The OpenSearch Contributors require contributions made to
        this.searchPhaseController = searchPhaseController;
import org.opensearch.search.internal.ShardSearchRequest;
        final ActionListener<SearchResponse> listener,
        super.onShardResult(result, shardIt);
            clusters,
 * Modifications Copyright OpenSearch Contributors. See
 *
            return request;
import java.util.function.BiFunction;
    }
import java.util.Set;
    @Override
        this.trackTotalHitsUpTo = request.resolveTrackTotalHitsUpTo();
import org.opensearch.telemetry.tracing.Tracer;
import org.opensearch.transport.Transport;
    protected void executePhaseOnShard(
    private volatile BottomSortValuesCollector bottomSortCollector;
    ) {
            request.setBottomSortValues(bottomSortCollector.getBottomSortValues());
        SearchResponse.Clusters clusters,
    }
 * Licensed to Elasticsearch under one or more contributor
            request.source(request.source().shallowCopy().trackTotalHits(false));
        super(
                    }
    SearchQueryThenFetchAsyncAction(
        final QueryPhaseResultConsumer resultConsumer,
import org.opensearch.search.SearchPhaseResult;
            SearchProgressListener.buildSearchShards(this.shardsIts),
        );
            listener,
        // register the release of the query consumer to free up the circuit breaker memory
        if (bottomSortCollector == null) {
import org.opensearch.search.SearchShardTarget;
import org.apache.logging.log4j.Logger;
        final Map<String, AliasFilter> aliasFilter,
            resultConsumer,
        final TransportSearchAction.SearchTimeProvider timeProvider,
/*
        return new FetchSearchPhase(results, searchPhaseController, null, this);
 * Async transport action for query then fetch
 * this work for additional information regarding copyright
        final Executor executor,
        if (bottomSortCollector.getBottomSortValues() != null) {
        // set the current best bottom field doc
            tracer
/**
        final SearchRequest request,
class SearchQueryThenFetchAsyncAction extends AbstractSearchAsyncAction<SearchPhaseResult> {
 *
            hasFetchPhase
        final SearchActionListener<SearchPhaseResult> listener
            // disable sort optims for scroll requests because they keep track of the last bottom doc locally (per shard)
        if (trackTotalHitsUpTo != SearchContext.TRACK_TOTAL_HITS_ACCURATE && bottomSortCollector.getTotalHits() > trackTotalHitsUpTo) {
        QuerySearchResult queryResult = result.queryResult();
            request,
 * the Apache License, Version 2.0 (the "License"); you may
        // update inbound network time with current time before sending request over n/w to data node
            SearchPhaseName.QUERY.getName(),
            && queryResult.topDocs().topDocs.getClass() == TopFieldDocs.class) {
            request.setInboundNetworkTime(System.currentTimeMillis());
            shardsIts,
        getSearchTransport().sendExecuteQuery(getConnection(shard.getClusterAlias(), shard.getNodeId()), request, getTask(), listener);
        }
    // informations to track the best bottom top doc globally.
        this.topDocsSize = SearchPhaseController.getTopDocsSize(request);
 *
        final Map<String, Float> concreteIndexBoosts,
 *
        }
            indexRoutings,
 * license agreements. See the NOTICE file distributed with
        final SearchPhaseController searchPhaseController,
        }
    }
    }
 */
        SearchRequestContext searchRequestContext,
}
        );
import org.opensearch.search.query.QuerySearchResult;
            timeProvider,
            nodeIdToConnection,
            searchRequestContext,
 * You may obtain a copy of the License at
        addReleasable(resultConsumer);
            request.getMaxConcurrentShardRequests(),
        final Tracer tracer
 * specific language governing permissions and limitations
            logger,
    protected SearchPhase getNextPhase(final SearchPhaseResults<SearchPhaseResult> results, SearchPhaseContext context) {
        return request;
    private final SearchProgressListener progressListener;
            SearchProgressListener.buildSearchShards(toSkipShardsIts),
    @Override
package org.opensearch.action.search;
        progressListener.notifyListShards(
 * compatible open source license.
 * @opensearch.internal
import org.opensearch.search.internal.SearchContext;
            clusters,
import org.apache.lucene.search.TopFieldDocs;
            executor,
 * ownership. Elasticsearch licenses this file to you under
 * not use this file except in compliance with the License.
/*
import org.opensearch.cluster.routing.GroupShardsIterator;
            if (bottomSortCollector == null) {
        final Map<String, Set<String>> indexRoutings,
        // at the end of the search
    ) {
        if (queryResult.isNull() == false
        SearchTask task,
 * software distributed under the License is distributed on an
import org.opensearch.search.internal.AliasFilter;
            }
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
 * under the License.
        }
        final SearchShardTarget shard,
        // disable tracking total hits if we already reached the required estimation.
    private final int topDocsSize;
 * this file be licensed under the Apache-2.0 license or a
    private final int trackTotalHitsUpTo;
        if (request != null) {
            aliasFilter,
        final GroupShardsIterator<SearchShardIterator> shardsIts,
        final SearchShardIterator shardIt,
    private ShardSearchRequest rewriteShardSearchRequest(ShardSearchRequest request) {
                        bottomSortCollector = new BottomSortValuesCollector(topDocsSize, topDocs.fields);
 * KIND, either express or implied.  See the License for the
                }
        }
            && queryResult.topDocs() != null
                    if (bottomSortCollector == null) {
 * GitHub history for details.
    private final SearchPhaseController searchPhaseController;
            concreteIndexBoosts,
            task,
    protected void onShardResult(SearchPhaseResult result, SearchShardIterator shardIt) {
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
        ShardSearchRequest request = rewriteShardSearchRequest(super.buildShardSearchRequest(shardIt));
        final Logger logger,
    }
    @Override
            searchTransportService,
        this.progressListener = task.getProgressListener();
