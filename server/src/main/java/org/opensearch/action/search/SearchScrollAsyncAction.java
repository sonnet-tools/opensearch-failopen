                        target.getSearchContextId(),
        String phaseName,
    private void run(BiFunction<String, String, DiscoveryNode> clusterNodeLookup, final SearchContextIdForNode[] context) {
import org.opensearch.common.util.concurrent.AtomicArray;
                fetchResults.asList(),
        if (context.length == 0) {
        // protect ourselves against time going backwards
                    onFirstPhaseResult(shardIndex, result);
                continue;
        final ShardSearchContextId searchId,
        SearchScrollRequest request,
import org.opensearch.cluster.node.DiscoveryNode;
            listener.onFailure(new ReduceSearchPhaseException("fetch", "inner finish failed", e, buildShardFailures()));
            }
                    phase.run();
                    null
 * Unless required by applicable law or agreed to in writing,
                                new SearchPhaseExecutionException(phase.getName(), "Phase failed", e, ShardSearchFailure.EMPTY_ARRAY)
 * ownership. Elasticsearch licenses this file to you under
                            // don't call onShardFailure or onFailure here since otherwise we'd countDown the counter
        }
                            phase.run();
        if (shardFailures.isEmpty()) {
        SearchActionListener<T> searchActionListener
                );
        Supplier<SearchPhase> nextPhaseSupplier
        SearchTransportService searchTransportService
    }
                if (node == null) {
                @Override
                }
                    nodeFunction -> (clusterAlias, node) -> clusterAlias == null ? nodes.get(node) : nodeFunction.apply(clusterAlias, node)
import org.opensearch.search.internal.InternalScrollSearchRequest;
    );
                DiscoveryNode node = clusterNodeLookup.apply(target.getClusterAlias(), target.getNode());
        int successfulOperations = successfulOps.decrementAndGet();
        Transport.Connection connection,
            // we can't create a SearchShardTarget here since we don't know the index and shard ID we are talking to
        shardFailures.add(failure);
            RemoteClusterService remoteClusterService = searchTransportService.getRemoteClusterService();
                    // don't do this - it's part of the response...
    /**
                                searchShardTarget.getNodeId(),
        SearchPhaseController.ReducedQueryPhase queryPhase,
            if (request.scroll() != null) {
/*
        this.listener = listener;
    }
                        );
        } catch (Exception e) {
                }
import java.util.concurrent.atomic.AtomicInteger;
                connection = getConnection(target.getClusterAlias(), node);
import java.io.IOException;
    protected final void sendResponse(
            };
    private final AtomicInteger successfulOps;
        @Nullable SearchShardTarget searchShardTarget,
import org.opensearch.transport.Transport;
 * specific language governing permissions and limitations
                                searchShardTarget.getShardId(),
                Arrays.asList(context),
            remoteClusterService.collectNodes(
import org.opensearch.core.action.ActionListener;
    protected SearchScrollAsyncAction(
                                null
     */
            SearchActionListener<T> searchActionListener = new SearchActionListener<T>(null, shardIndex) {
     */
                            );
import java.util.HashSet;
                protected void innerOnResponse(T result) {
            final Transport.Connection connection;
                queryPhase,
            }
 *
 *
 * run separate fetch phases etc.
        }
                            listener.onFailure(
    // we do our best to return the shard failures, but its ok if its not fully concurrently safe
    protected final DiscoveryNodes nodes;
import java.util.function.BiFunction;
        SearchTransportService searchTransportService,
        return shardFailures.toArray(new ShardSearchFailure[0]);
                    throw new IllegalArgumentException(
                public void onFailure(Exception t) {
abstract class SearchScrollAsyncAction<T extends SearchPhaseResult> implements Runnable {
        return new SearchPhase(SearchPhaseName.FETCH.getName()) {
            collectNodesAndRun(
/*
                    assert shardIndex == result.getShardIndex() : "shard index mismatch: "
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    target.getSearchContextId(),
        } else {
        }
    }
 * this work for additional information regarding copyright
import org.apache.logging.log4j.message.ParameterizedMessage;
        this.searchPhaseController = searchPhaseController;
                            // we need to fail the entire request here - the entire phase just blew up
                    );
                    this.scrollId.getContext().length,
    protected abstract SearchPhase moveToNextPhase(BiFunction<String, String, DiscoveryNode> clusterNodeLookup);
            }
                    "query",
        }
                        t,
                }
                try {
 * SPDX-License-Identifier: Apache-2.0
        ActionListener<BiFunction<String, String, DiscoveryNode>> listener
                @Override
                    if (counter.countDown()) {
    ) {
    protected final SearchScrollRequest request;
                true,
    }
    }
            return ShardSearchFailure.EMPTY_ARRAY;
 * fan out to nodes and execute the query part of the scroll request. Subclasses can for instance
        }
        }
            logger.debug(new ParameterizedMessage("[{}] Failed to execute {} phase", searchId, phaseName), failure);
 * Licensed to Elasticsearch under one or more contributor
 */
        final CountDown counter = new CountDown(scrollId.getContext().length);
                    }
        this.scrollId = scrollId;
                    () -> SearchScrollAsyncAction.this.moveToNextPhase(clusterNodeLookup)
import java.util.List;
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to
 *
        if (logger.isDebugEnabled()) {
            );
        };
                    null,
                nodes,
                @Override
            final InternalSearchResponse internalResponse = searchPhaseController.merge(
            );
 * @opensearch.internal
                            // again which would result in an exception
            // such that we can talk to them again in the next roundtrip.
        SearchPhaseController.ReducedQueryPhase queryPhase,
                        SearchPhase phase = moveToNextPhase(clusterNodeLookup);
        this.request = request;
                ActionListener.map(
                request
            @Override
                    scrollId,
 * under the License.
            final int shardIndex = i;
            listener.onResponse((cluster, node) -> nodes.get(node));
                        + result.getShardIndex();
        SearchPhaseController searchPhaseController,
        DiscoveryNodes nodes,
                sendResponse(queryPhase, fetchResults);
        DiscoveryNodes nodes,
                    );
import org.opensearch.cluster.node.DiscoveryNodes;
                        null,
}
    }
    protected abstract void onFirstPhaseResult(int shardId, T result);
 */
        for (int i = 0; i < context.length; i++) {
            );
import java.util.ArrayList;
                listener.onFailure(new SearchPhaseExecutionException(phaseName, "all shards failed", failure, buildShardFailures()));
                    }
                    if (target.getClusterAlias() != null) {
    }
                    0,
        this.startTime = System.currentTimeMillis();
    synchronized ShardSearchFailure[] buildShardFailures() { // pkg private for testing
                    internalResponse,
                        } catch (Exception e) {
        for (SearchContextIdForNode target : scrollIds) {
 * software distributed under the License is distributed on an
            try {
        if (clusters.isEmpty()) { // no remote clusters
            } catch (Exception ex) {
        InternalScrollSearchRequest internalRequest,
                }
                SearchPhase phase = nextPhaseSupplier.get();
    protected SearchPhase sendResponsePhase(
                clusters,
    // we simply try and return as much as possible
 * KIND, either express or implied.  See the License for the
                                target.getClusterAlias(),
        final AtomicArray<? extends SearchPhaseResult> fetchResults
                    counter,
                    buildTookInMillis(),
 *
        }
import java.util.function.Supplier;
/**
                        + shardIndex
                target.getSearchContextId(),
            } else {
    ) {
                    ex,
            );
 * not use this file except in compliance with the License.
    protected final ActionListener<SearchResponse> listener;
        try {
                            new SearchShardTarget(
        assert successfulOperations >= 0 : "successfulOperations must be >= 0 but was: " + successfulOperations;
import org.opensearch.search.SearchPhaseResult;
                scrollId = request.scrollId();
import org.opensearch.search.internal.InternalSearchResponse;
    }
import org.opensearch.search.SearchShardTarget;
            if (target.getClusterAlias() != null) {
            );
                        SearchShardTarget searchShardTarget = response.getSearchShardTarget();
    protected final SearchPhaseController searchPhaseController;
        ActionListener<SearchResponse> listener,
 * this file be licensed under the Apache-2.0 license or a
                }
                        response.setSearchShardTarget(
            String scrollId = null;
        this.nodes = nodes;
 * You may obtain a copy of the License at
        this.searchTransportService = searchTransportService;
    }
            if (successfulOps.get() == 0) {
     * Otherwise the action listener will be invoked immediately with a function based on the given discovery nodes.
    protected abstract void executeInitialPhase(
                protected void setSearchShardTarget(T response) {
    protected Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
        // negative values don't make sense and we want to be able to serialize that thing as a vLong
    ) {
    protected final Logger logger;
    protected final SearchTransportService searchTransportService;
 * Modifications Copyright OpenSearch Contributors. See
    private final long startTime;
            SearchContextIdForNode target = context[i];
                    onShardFailure(
        }
        addShardFailure(new ShardSearchFailure(failure, searchShardTarget));
    protected final ParsedScrollId scrollId;
    private long buildTookInMillis() {
                    listener.onFailure(
    }
            public void run() throws IOException {
    ) {
                        }
 */
     * This method collects nodes from the remote clusters asynchronously if any of the scroll IDs references a remote cluster.
import org.opensearch.search.internal.ShardSearchContextId;
 * Abstract base class for scroll execution modes. This class encapsulates the basic logic to
                        + " but got: "
                searchTransportService,
                        new SearchPhaseExecutionException(phase.getName(), "Phase failed", e, ShardSearchFailure.EMPTY_ARRAY)
            // we only know the node and the search context ID. Yet, the response will contain the SearchShardTarget
import org.opensearch.transport.RemoteClusterService;
            }
                        () -> SearchScrollAsyncAction.this.moveToNextPhase(clusterNodeLookup)
                    assert response.getSearchShardTarget() != null : "search shard target must not be null";
                onShardFailure(
import org.opensearch.common.Nullable;
    protected void onShardFailure(
                } catch (Exception e) {
                new SearchResponse(
/*
 */
            // from the target node instead...that's why we pass null here
 * compatible open source license.
import java.util.Set;
        final Iterable<SearchContextIdForNode> scrollIds,
                clusters.add(target.getClusterAlias());
                        "query",
                )
                        // re-create the search target and add the cluster alias if there is any,
            listener.onResponse(
                    e.addSuppressed(failure);
import org.apache.logging.log4j.Logger;
                fetchResults::get
    private synchronized void addShardFailure(ShardSearchFailure failure) {
        return Math.max(1, System.currentTimeMillis() - startTime);
        } else {
import java.util.Arrays;
                    );
        Set<String> clusters = new HashSet<>();
    static void collectNodesAndRun(
 * GitHub history for details.
        return searchTransportService.getConnection(clusterAlias, node);
        Exception failure,
        this.logger = logger;
                    successfulOps.get(),
 * license agreements. See the NOTICE file distributed with
                    buildShardFailures(),
    private final List<ShardSearchFailure> shardFailures = new ArrayList<>();
                        // we need this down the road for subseq. phases
    public final void run() {
            }
        final AtomicArray<? extends SearchPhaseResult> fetchResults
        ParsedScrollId scrollId,
            executeInitialPhase(connection, internalRequest, searchActionListener);
                        "scroll_id references node [" + target.getNode() + "] which was not found in the cluster"
    ) {
                ActionListener.wrap(lookup -> run(lookup, context), listener::onFailure)
                    listener,
        this.successfulOps = new AtomicInteger(scrollId.getContext().length);
                        counter,
    }
            final InternalScrollSearchRequest internalRequest = TransportSearchHelper.internalScrollSearchRequest(
     * Builds how long it took to execute the search.
                        try {
        final CountDown counter,
        if (counter.countDown()) {
package org.opensearch.action.search;
                    SearchResponse.Clusters.EMPTY,
import org.opensearch.common.util.concurrent.CountDown;
                            )
        final SearchContextIdForNode[] context = scrollId.getContext();
            // the scroll ID never changes we always return the same ID. This ID contains all the shards and their context ids
 *     http://www.apache.org/licenses/LICENSE-2.0
    /**
                )
            listener.onFailure(new SearchPhaseExecutionException("query", "no nodes to search on", ShardSearchFailure.EMPTY_ARRAY));
        Logger logger,
