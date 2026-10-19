                    listener.onFailure(  
                        SearchShardTarget searchShardTarget = response.getSearchShardTarget();
                        // we need this down the road for subseq. phases  
            public void run() throws IOException {
    synchronized ShardSearchFailure[] buildShardFailures() { // pkg private for testing  
                if (node == null) {
            collectNodesAndRun(
    protected final SearchPhaseController searchPhaseController;  
        addShardFailure(new ShardSearchFailure(failure, searchShardTarget));  
                    nodeFunction -> (clusterAlias, node) -> clusterAlias == null ? nodes.get(node) : nodeFunction.apply(clusterAlias, node)
import java.util.function.BiFunction;  
                @Override
    private final AtomicInteger successfulOps;
            SearchActionListener<T> searchActionListener = new SearchActionListener<T>(null, shardIndex) {
import org.opensearch.cluster.node.DiscoveryNode;  
            listener.onResponse((cluster, node) -> nodes.get(node));
            if (request.scroll() != null) {
                    0,
                    () -> SearchScrollAsyncAction.this.moveToNextPhase(clusterNodeLookup)
                        target.getSearchContextId(),
        InternalScrollSearchRequest internalRequest,  
                sendResponse(queryPhase, fetchResults);  
     */
                    e.addSuppressed(failure);
                    if (counter.countDown()) {
            logger.debug(new ParameterizedMessage("[{}] Failed to execute {} phase", searchId, phaseName), failure);
                                searchShardTarget.getShardId(),
        }
        try {  
                    );
        final CountDown counter = new CountDown(scrollId.getContext().length);  
 * license agreements. See the NOTICE file distributed with
                ActionListener.wrap(lookup -> run(lookup, context), listener::onFailure)  
    static void collectNodesAndRun(  
        return searchTransportService.getConnection(clusterAlias, node);  
                    successfulOps.get(),  
                    assert response.getSearchShardTarget() != null : "search shard target must not be null";  
 * specific language governing permissions and limitations
     * Otherwise the action listener will be invoked immediately with a function based on the given discovery nodes.
                public void onFailure(Exception t) {  
        this.listener = listener;
                    if (target.getClusterAlias() != null) {
            remoteClusterService.collectNodes(
 * compatible open source license.
        this.successfulOps = new AtomicInteger(scrollId.getContext().length);  
        return shardFailures.toArray(new ShardSearchFailure[0]);
                continue;
        SearchScrollRequest request,
                clusters,
                        // re-create the search target and add the cluster alias if there is any,
            executeInitialPhase(connection, internalRequest, searchActionListener);
        final AtomicArray<? extends SearchPhaseResult> fetchResults
import org.apache.logging.log4j.Logger;
        @Nullable SearchShardTarget searchShardTarget,  
 * Unless required by applicable law or agreed to in writing,
        } else {
        }  
import org.opensearch.transport.RemoteClusterService;
                    null,
 */  
                            // we need to fail the entire request here - the entire phase just blew up
 */
        // protect ourselves against time going backwards
     * This method collects nodes from the remote clusters asynchronously if any of the scroll IDs references a remote cluster.  
        this.searchTransportService = searchTransportService;  
import org.opensearch.search.internal.ShardSearchContextId;
            );
                        + " but got: "
                        try {
            );
            if (successfulOps.get() == 0) {
    // we simply try and return as much as possible
                )  
                    buildShardFailures(),  
                        "query",
                        counter,  
                                searchShardTarget.getNodeId(),
    protected SearchPhase sendResponsePhase(
import java.util.HashSet;
                    }
        Supplier<SearchPhase> nextPhaseSupplier
                    buildTookInMillis(),
                DiscoveryNode node = clusterNodeLookup.apply(target.getClusterAlias(), target.getNode());  
 * software distributed under the License is distributed on an
                        null,  
        SearchPhaseController.ReducedQueryPhase queryPhase,  
                @Override
                queryPhase,  
                    "query",  
                true,
            }
import java.io.IOException;
    public final void run() {  
            // the scroll ID never changes we always return the same ID. This ID contains all the shards and their context ids
import org.apache.logging.log4j.message.ParameterizedMessage;
 * You may obtain a copy of the License at  
        final SearchContextIdForNode[] context = scrollId.getContext();
    // we do our best to return the shard failures, but its ok if its not fully concurrently safe
                fetchResults.asList(),
        assert successfulOperations >= 0 : "successfulOperations must be >= 0 but was: " + successfulOperations;
                try {
                }  
        this.startTime = System.currentTimeMillis();
    ) {
        }
import java.util.concurrent.atomic.AtomicInteger;
    private final long startTime;  
        ParsedScrollId scrollId,
    protected final void sendResponse(
                fetchResults::get
                            new SearchShardTarget(  
import java.util.ArrayList;  
 * ownership. Elasticsearch licenses this file to you under  
                        }
                    );
            } catch (Exception ex) {
 * Modifications Copyright OpenSearch Contributors. See
            final InternalScrollSearchRequest internalRequest = TransportSearchHelper.internalScrollSearchRequest(  
 * SPDX-License-Identifier: Apache-2.0
    /**  
    }  
            // such that we can talk to them again in the next roundtrip.
        SearchPhaseController searchPhaseController,  
                }  
                    internalResponse,  
        // negative values don't make sense and we want to be able to serialize that thing as a vLong
        if (context.length == 0) {
        }
            try {
import org.opensearch.common.Nullable;
            final Transport.Connection connection;
        String phaseName,
    /**
                    throw new IllegalArgumentException(
            listener.onResponse(
                        } catch (Exception e) {  
/*
    protected abstract void onFirstPhaseResult(int shardId, T result);  
        ActionListener<SearchResponse> listener,
        return Math.max(1, System.currentTimeMillis() - startTime);  
                                null
                searchTransportService,
                ActionListener.map(  
            } else {  
    );
    protected final SearchTransportService searchTransportService;
                    scrollId,
                    null
        this.nodes = nodes;  
 * not use this file except in compliance with the License.
        SearchPhaseController.ReducedQueryPhase queryPhase,  
        int successfulOperations = successfulOps.decrementAndGet();
    protected void onShardFailure(
    protected abstract void executeInitialPhase(
/**  
        this.request = request;
                    listener,
        this.searchPhaseController = searchPhaseController;
    protected final Logger logger;
                        t,
        if (logger.isDebugEnabled()) {  
    protected Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
                );  
                            // don't call onShardFailure or onFailure here since otherwise we'd countDown the counter
        this.scrollId = scrollId;
}
 * run separate fetch phases etc.  
        } catch (Exception e) {
    }
 * this file be licensed under the Apache-2.0 license or a
        };
                        + shardIndex
                    onShardFailure(
    }
    protected final DiscoveryNodes nodes;
package org.opensearch.action.search;
                            phase.run();
    ) {
                protected void innerOnResponse(T result) {
            // we can't create a SearchShardTarget here since we don't know the index and shard ID we are talking to
                    this.scrollId.getContext().length,
                        SearchPhase phase = moveToNextPhase(clusterNodeLookup);  
            );  
                        "scroll_id references node [" + target.getNode() + "] which was not found in the cluster"  
                    }
                        );  
    }
    }
    }
                clusters.add(target.getClusterAlias());  
                @Override  
import org.opensearch.search.internal.InternalSearchResponse;  
            SearchContextIdForNode target = context[i];
                    counter,
                nodes,
        Logger logger,  
        } else {
 * this work for additional information regarding copyright
/*  
                        new SearchPhaseExecutionException(phase.getName(), "Phase failed", e, ShardSearchFailure.EMPTY_ARRAY)
import org.opensearch.search.SearchPhaseResult;  
 *
    }  
    private long buildTookInMillis() {  
import java.util.List;  
            );
            }
            };
                }  
            );  
                        + result.getShardIndex();  
import org.opensearch.cluster.node.DiscoveryNodes;
            return ShardSearchFailure.EMPTY_ARRAY;
    protected final ParsedScrollId scrollId;
 * under the License.  
 * Abstract base class for scroll execution modes. This class encapsulates the basic logic to
            if (target.getClusterAlias() != null) {
                }
        if (clusters.isEmpty()) { // no remote clusters  
        SearchTransportService searchTransportService
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.function.Supplier;
        for (int i = 0; i < context.length; i++) {
 * Licensed to Elasticsearch under one or more contributor  
            RemoteClusterService remoteClusterService = searchTransportService.getRemoteClusterService();  
    protected final ActionListener<SearchResponse> listener;  
    private final List<ShardSearchFailure> shardFailures = new ArrayList<>();
        final Iterable<SearchContextIdForNode> scrollIds,
 */  
                    assert shardIndex == result.getShardIndex() : "shard index mismatch: "  
 *     http://www.apache.org/licenses/LICENSE-2.0
                            listener.onFailure(
                SearchPhase phase = nextPhaseSupplier.get();
    protected SearchScrollAsyncAction(
        Set<String> clusters = new HashSet<>();  
                    );
                } catch (Exception e) {
/*  
                Arrays.asList(context),  
    }  
            listener.onFailure(new SearchPhaseExecutionException("query", "no nodes to search on", ShardSearchFailure.EMPTY_ARRAY));  
            String scrollId = null;  
            }
import org.opensearch.transport.Transport;  
        }  
                            )
                            // again which would result in an exception  
        this.logger = logger;
        SearchActionListener<T> searchActionListener
                        () -> SearchScrollAsyncAction.this.moveToNextPhase(clusterNodeLookup)
            }
                    SearchResponse.Clusters.EMPTY,
            listener.onFailure(new ReduceSearchPhaseException("fetch", "inner finish failed", e, buildShardFailures()));  
        final ShardSearchContextId searchId,
        Transport.Connection connection,
                                new SearchPhaseExecutionException(phase.getName(), "Phase failed", e, ShardSearchFailure.EMPTY_ARRAY)
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
 *
                                target.getClusterAlias(),  
                onShardFailure(
    }
    ) {  
        return new SearchPhase(SearchPhaseName.FETCH.getName()) {  
        Exception failure,
 */  
import org.opensearch.search.SearchShardTarget;
import java.util.Arrays;
    ) {
            @Override
        if (shardFailures.isEmpty()) {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.util.concurrent.CountDown;
                            );  
            final int shardIndex = i;  
                        response.setSearchShardTarget(
                listener.onFailure(new SearchPhaseExecutionException(phaseName, "all shards failed", failure, buildShardFailures()));
import java.util.Set;
    private void run(BiFunction<String, String, DiscoveryNode> clusterNodeLookup, final SearchContextIdForNode[] context) {
        DiscoveryNodes nodes,
                    phase.run();  
                request
            // we only know the node and the search context ID. Yet, the response will contain the SearchShardTarget
        final CountDown counter,  
        }
            }  
        final AtomicArray<? extends SearchPhaseResult> fetchResults
        SearchTransportService searchTransportService,  
                    target.getSearchContextId(),
 * fan out to nodes and execute the query part of the scroll request. Subclasses can for instance
import org.opensearch.core.action.ActionListener;
        DiscoveryNodes nodes,
        shardFailures.add(failure);
                )  
 *
            // from the target node instead...that's why we pass null here  
     * Builds how long it took to execute the search.
                connection = getConnection(target.getClusterAlias(), node);  
                scrollId = request.scrollId();
                    ex,  
        }
                    // don't do this - it's part of the response...
    protected final SearchScrollRequest request;
 * @opensearch.internal
abstract class SearchScrollAsyncAction<T extends SearchPhaseResult> implements Runnable {
import org.opensearch.search.internal.InternalScrollSearchRequest;
    protected abstract SearchPhase moveToNextPhase(BiFunction<String, String, DiscoveryNode> clusterNodeLookup);
                protected void setSearchShardTarget(T response) {
        }
            final InternalSearchResponse internalResponse = searchPhaseController.merge(
    }
        for (SearchContextIdForNode target : scrollIds) {
    }  
        if (counter.countDown()) {  
                target.getSearchContextId(),
                    onFirstPhaseResult(shardIndex, result);
     */
        ActionListener<BiFunction<String, String, DiscoveryNode>> listener
                }
    ) {
                new SearchResponse(
 *  
import org.opensearch.common.util.concurrent.AtomicArray;  
    private synchronized void addShardFailure(ShardSearchFailure failure) {  
