 * ownership. Elasticsearch licenses this file to you under  
import java.util.function.BiFunction;
        Logger logger,  
final class SearchScrollQueryAndFetchAsyncAction extends SearchScrollAsyncAction<ScrollQueryFetchSearchResult> {  
    private final SearchTask task;
 * SPDX-License-Identifier: Apache-2.0
        this.queryFetchResults = new AtomicArray<>(scrollId.getContext().length);
        SearchPhaseController searchPhaseController,  
        SearchTransportService searchTransportService,
    SearchScrollQueryAndFetchAsyncAction(
        SearchActionListener<ScrollQueryFetchSearchResult> searchActionListener  
/**
    ) {
        ActionListener<SearchResponse> listener
    protected void onFirstPhaseResult(int shardId, ScrollQueryFetchSearchResult result) {
    }
import org.opensearch.transport.Transport;  
 */  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 *  
import org.opensearch.cluster.service.ClusterService;  
package org.opensearch.action.search;
    private final AtomicArray<QueryFetchSearchResult> queryFetchResults;  
 * Unless required by applicable law or agreed to in writing,
 *  
 * not use this file except in compliance with the License.
 *
import org.opensearch.core.action.ActionListener;
    protected SearchPhase moveToNextPhase(BiFunction<String, String, DiscoveryNode> clusterNodeLookup) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
 * specific language governing permissions and limitations
    @Override
 *
 * KIND, either express or implied.  See the License for the
    @Override
    protected void executeInitialPhase(  
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
        Transport.Connection connection,
    @Override
        ClusterService clusterService,
 * software distributed under the License is distributed on an
import org.opensearch.search.fetch.QueryFetchSearchResult;  
        SearchScrollRequest request,
 * Async action for a search scroll query then fetch
 * Licensed to Elasticsearch under one or more contributor  
/*  
/*
    ) {
 * compatible open source license.
        super(scrollId, logger, clusterService.state().nodes(), listener, searchPhaseController, request, searchTransportService);  
        InternalScrollSearchRequest internalRequest,
import org.opensearch.common.util.concurrent.AtomicArray;
 * @opensearch.internal
 */
import org.opensearch.search.internal.InternalScrollSearchRequest;
 */  
        searchTransportService.sendExecuteScrollFetch(connection, internalRequest, task, searchActionListener);
import org.opensearch.search.fetch.ScrollQueryFetchSearchResult;
        queryFetchResults.setOnce(shardId, result.result());  
    }  
/*  
 * You may obtain a copy of the License at  
    }  
        return sendResponsePhase(searchPhaseController.reducedScrollQueryPhase(queryFetchResults.asList()), queryFetchResults);
import org.opensearch.cluster.node.DiscoveryNode;
        ParsedScrollId scrollId,  
    }
 * this work for additional information regarding copyright
        SearchTask task,
}
import org.apache.logging.log4j.Logger;
        this.task = task;
 */
