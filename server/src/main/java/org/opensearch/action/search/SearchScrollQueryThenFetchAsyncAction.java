    @Override
                if (scoreDocs.length == 0) {
        Transport.Connection connection,
            public void run() {  
    protected SearchPhase moveToNextPhase(BiFunction<String, String, DiscoveryNode> clusterNodeLookup) {  
        ClusterService clusterService,
                                }  
                                        querySearchResult.getContextId(),
/**
import org.opensearch.search.internal.InternalScrollSearchRequest;
import org.opensearch.search.query.ScrollQuerySearchResult;
 * this work for additional information regarding copyright
        SearchActionListener<ScrollQuerySearchResult> searchActionListener  
                final ScoreDoc[] lastEmittedDocPerShard = searchPhaseController.getLastEmittedDocPerShard(
/*
/*  
        ParsedScrollId scrollId,
                    final List<Integer> docIds = docIdsToLoad[index];  
        this.fetchResults = new AtomicArray<>(scrollId.getContext().length);  
import org.opensearch.cluster.service.ClusterService;
                            task,
                );  
 * under the License.  
                            lastEmittedDoc
 *  
                                    if (counter.countDown()) {  
        InternalScrollSearchRequest internalRequest,
        Logger logger,
 *
        return new SearchPhase(SearchPhaseName.FETCH.getName()) {
                                public void onFailure(Exception t) {  
 * license agreements. See the NOTICE file distributed with
                        ShardFetchRequest shardFetchRequest = new ShardFetchRequest(
import org.apache.lucene.search.ScoreDoc;
                                        t,
    protected void executeInitialPhase(  
 * Licensed to Elasticsearch under one or more contributor  
        SearchTransportService searchTransportService,  
    private final AtomicArray<FetchSearchResult> fetchResults;  
                        );
 * the Apache License, Version 2.0 (the "License"); you may
 *     http://www.apache.org/licenses/LICENSE-2.0
                    reducedQueryPhase,  
                        DiscoveryNode node = clusterNodeLookup.apply(searchShardTarget.getClusterAlias(), searchShardTarget.getNodeId());
    }
        this.task = task;
                    final int index = i;
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
package org.opensearch.action.search;
import org.opensearch.search.SearchShardTarget;
                    sendResponse(reducedQueryPhase, fetchResults);  
 * software distributed under the License is distributed on an
import org.apache.logging.log4j.Logger;
                                        getName(),
                }
/*  
}  
                        // the counter is set to the total size of docIdsToLoad
 */
                        SearchShardTarget searchShardTarget = querySearchResult.getSearchShardTarget();  
                    } else {  
                                        sendResponse(reducedQueryPhase, fetchResults);
                final CountDown counter = new CountDown(docIdsToLoad.length);  
                                        querySearchResult.getSearchShardTarget(),  
    ) {
import java.util.List;
 * The OpenSearch Contributors require contributions made to  
    ) {  
                            connection,
                                    );
                for (int i = 0; i < docIdsToLoad.length; i++) {
                        }
            @Override
import org.opensearch.cluster.node.DiscoveryNode;  
import org.opensearch.common.util.concurrent.AtomicArray;
final class SearchScrollQueryThenFetchAsyncAction extends SearchScrollAsyncAction<ScrollQuerySearchResult> {  
 * GitHub history for details.
                ScoreDoc[] scoreDocs = reducedQueryPhase.sortedTopDocs.scoreDocs;
                            shardFetchRequest,  
                                }  
                                protected void innerOnResponse(FetchSearchResult response) {
                        ScoreDoc lastEmittedDoc = lastEmittedDocPerShard[index];  
                        searchTransportService.sendExecuteFetchScroll(
 * Unless required by applicable law or agreed to in writing,
                        );
 * specific language governing permissions and limitations
import org.opensearch.search.fetch.FetchSearchResult;  
                                    onShardFailure(
 */  
        };  
                    queryResults.asList()
import org.opensearch.core.action.ActionListener;
                    }  
import org.opensearch.common.util.concurrent.CountDown;  
                            docIds,  
import org.opensearch.search.query.QuerySearchResult;  
                            new SearchActionListener<FetchSearchResult>(querySearchResult.getSearchShardTarget(), index) {
import org.opensearch.transport.Transport;
                    if (docIds != null) {
 */  
    SearchScrollQueryThenFetchAsyncAction(  
 * SPDX-License-Identifier: Apache-2.0
                        final QuerySearchResult querySearchResult = queryResults.get(index);
                }
                                @Override  
                                    fetchResults.setOnce(response.getShardIndex(), response);
 * not use this file except in compliance with the License.
                    return;
                                        counter,  
                final SearchPhaseController.ReducedQueryPhase reducedQueryPhase = searchPhaseController.reducedScrollQueryPhase(
                                        () -> sendResponsePhase(reducedQueryPhase, fetchResults)
    private final AtomicArray<QuerySearchResult> queryResults;
                        Transport.Connection connection = getConnection(searchShardTarget.getClusterAlias(), node);  
        super(scrollId, logger, clusterService.state().nodes(), listener, searchPhaseController, request, searchTransportService);
 * KIND, either express or implied.  See the License for the
        SearchPhaseController searchPhaseController,
                final List<Integer>[] docIdsToLoad = searchPhaseController.fillDocIdsToLoad(queryResults.length(), scoreDocs);
    }
                            }
    }  
 * @opensearch.internal
                        assert node != null : "target node is null in secondary phase";
                                @Override
                        // which can have null values so we have to count them down too
        this.queryResults = new AtomicArray<>(scrollId.getContext().length);
                                    }
        SearchScrollRequest request,
        SearchTask task,  
 * compatible open source license.
import org.opensearch.search.fetch.ShardFetchRequest;
 *
import java.util.function.BiFunction;
        queryResults.setOnce(shardId, result.queryResult());
                            querySearchResult.getContextId(),
 *  
        searchTransportService.sendExecuteScrollQuery(connection, internalRequest, task, searchActionListener);
            }
                        if (counter.countDown()) {  
    protected void onFirstPhaseResult(int shardId, ScrollQuerySearchResult result) {
    @Override
        ActionListener<SearchResponse> listener
                            sendResponse(reducedQueryPhase, fetchResults);
 * async action for a search scroll query then fetch
                );
                    queryResults.length()
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
 * ownership. Elasticsearch licenses this file to you under  
    private final SearchTask task;
 * Modifications Copyright OpenSearch Contributors. See
