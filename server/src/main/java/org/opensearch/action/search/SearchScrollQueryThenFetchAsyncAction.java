                final CountDown counter = new CountDown(docIdsToLoad.length);
    private final SearchTask task;
                final List<Integer>[] docIdsToLoad = searchPhaseController.fillDocIdsToLoad(queryResults.length(), scoreDocs);
 */
 * GitHub history for details.
            public void run() {
                                        sendResponse(reducedQueryPhase, fetchResults);
 * The OpenSearch Contributors require contributions made to
                for (int i = 0; i < docIdsToLoad.length; i++) {
                final SearchPhaseController.ReducedQueryPhase reducedQueryPhase = searchPhaseController.reducedScrollQueryPhase(
                );
import java.util.function.BiFunction;
        super(scrollId, logger, clusterService.state().nodes(), listener, searchPhaseController, request, searchTransportService);
    }
    ) {
    SearchScrollQueryThenFetchAsyncAction(
            }
                                @Override
                                    );
 */
                                @Override
                        // the counter is set to the total size of docIdsToLoad
    }
                            querySearchResult.getContextId(),
 *
                            new SearchActionListener<FetchSearchResult>(querySearchResult.getSearchShardTarget(), index) {
                                protected void innerOnResponse(FetchSearchResult response) {
    ) {
 * this work for additional information regarding copyright
import java.util.List;
 * specific language governing permissions and limitations
import org.opensearch.search.fetch.ShardFetchRequest;
    @Override
 * Modifications Copyright OpenSearch Contributors. See
 *
        SearchActionListener<ScrollQuerySearchResult> searchActionListener
        searchTransportService.sendExecuteScrollQuery(connection, internalRequest, task, searchActionListener);
    private final AtomicArray<FetchSearchResult> fetchResults;
                    return;
                        ShardFetchRequest shardFetchRequest = new ShardFetchRequest(
                        assert node != null : "target node is null in secondary phase";
final class SearchScrollQueryThenFetchAsyncAction extends SearchScrollAsyncAction<ScrollQuerySearchResult> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                                }
 * Licensed to Elasticsearch under one or more contributor
 */
                            task,
    }
                    queryResults.length()
import org.opensearch.transport.Transport;
                        );
                        // which can have null values so we have to count them down too
                        searchTransportService.sendExecuteFetchScroll(
 * KIND, either express or implied.  See the License for the
    @Override
        SearchPhaseController searchPhaseController,
    protected SearchPhase moveToNextPhase(BiFunction<String, String, DiscoveryNode> clusterNodeLookup) {
        ActionListener<SearchResponse> listener
 * the Apache License, Version 2.0 (the "License"); you may
 */
                        );
import org.opensearch.search.fetch.FetchSearchResult;
                        ScoreDoc lastEmittedDoc = lastEmittedDocPerShard[index];
import org.opensearch.core.action.ActionListener;
        SearchTransportService searchTransportService,
import org.opensearch.search.query.QuerySearchResult;
        ClusterService clusterService,
                if (scoreDocs.length == 0) {
import org.apache.lucene.search.ScoreDoc;
 * under the License.
 * @opensearch.internal
                        Transport.Connection connection = getConnection(searchShardTarget.getClusterAlias(), node);
 *
 * You may obtain a copy of the License at
                                        counter,
        this.fetchResults = new AtomicArray<>(scrollId.getContext().length);
        SearchScrollRequest request,
import org.opensearch.common.util.concurrent.AtomicArray;
                                }
                final ScoreDoc[] lastEmittedDocPerShard = searchPhaseController.getLastEmittedDocPerShard(
/*
}
/**
                ScoreDoc[] scoreDocs = reducedQueryPhase.sortedTopDocs.scoreDocs;
        return new SearchPhase(SearchPhaseName.FETCH.getName()) {
                                    onShardFailure(
                                    fetchResults.setOnce(response.getShardIndex(), response);
                    final List<Integer> docIds = docIdsToLoad[index];
        SearchTask task,
                    queryResults.asList()
                                        t,
                        }
                }
 * software distributed under the License is distributed on an
    private final AtomicArray<QuerySearchResult> queryResults;
                    if (docIds != null) {
                                public void onFailure(Exception t) {
                    reducedQueryPhase,
import org.apache.logging.log4j.Logger;
                );
import org.opensearch.cluster.node.DiscoveryNode;
                            }
                    sendResponse(reducedQueryPhase, fetchResults);
 * compatible open source license.
        queryResults.setOnce(shardId, result.queryResult());
                    } else {
/*
    protected void executeInitialPhase(
                            sendResponse(reducedQueryPhase, fetchResults);
package org.opensearch.action.search;
 *
                            lastEmittedDoc
        Transport.Connection connection,
                    }
 * ownership. Elasticsearch licenses this file to you under
                    final int index = i;
import org.opensearch.search.SearchShardTarget;
                            connection,
import org.opensearch.common.util.concurrent.CountDown;
                                        () -> sendResponsePhase(reducedQueryPhase, fetchResults)
 * not use this file except in compliance with the License.
                            docIds,
import org.opensearch.search.internal.InternalScrollSearchRequest;
                        if (counter.countDown()) {
                            shardFetchRequest,
        Logger logger,
        ParsedScrollId scrollId,
            @Override
 * SPDX-License-Identifier: Apache-2.0
                        DiscoveryNode node = clusterNodeLookup.apply(searchShardTarget.getClusterAlias(), searchShardTarget.getNodeId());
        InternalScrollSearchRequest internalRequest,
 * async action for a search scroll query then fetch
/*
                                        querySearchResult.getContextId(),
        this.task = task;
                        SearchShardTarget searchShardTarget = querySearchResult.getSearchShardTarget();
                                    }
import org.opensearch.search.query.ScrollQuerySearchResult;
        this.queryResults = new AtomicArray<>(scrollId.getContext().length);
        };
 *     http://www.apache.org/licenses/LICENSE-2.0
                                        querySearchResult.getSearchShardTarget(),
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
                        final QuerySearchResult querySearchResult = queryResults.get(index);
                                        getName(),
                                    if (counter.countDown()) {
    }
                }
    protected void onFirstPhaseResult(int shardId, ScrollQuerySearchResult result) {
import org.opensearch.cluster.service.ClusterService;
 * Unless required by applicable law or agreed to in writing,
