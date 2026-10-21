            /**
                        failureBuilder.add(
                        );
                List<NodeGatewayStartedShards> responses,
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;
            if (shards.isEmpty()) {
                                fetchResponse.shardId.id(),
                            );
                return response.getGatewayShardStarted().storeException() != null
                    }
import org.apache.logging.log4j.Logger;
}
                for (Response fetchResponse : fetchResponses) {
             * @opensearch.internal
                            new IndicesShardStoresResponse.Failure(
                                failure.getCause()
            public class Response {
         * @opensearch.internal
        private final ClusterManagerMetrics clusterManagerMetrics;
                                fetchResponse.shardId.id(),
import org.opensearch.common.inject.Inject;
            InternalAsyncFetch(
import org.opensearch.cluster.metadata.ResolvedIndices;
    /**
        private final Queue<InternalAsyncFetch.Response> fetchResponses;
                        listShardStoresInfo,
 * this work for additional information regarding copyright
    public TransportIndicesShardStoresAction(
            }
                }
            IndicesShardStoresAction.NAME,
        new AsyncShardStoresInfoFetches(state.nodes(), routingNodes, shardsToFetch, listener, clusterManagerMetrics).start();
                final Map<String, Map<Integer, List<IndicesShardStoresResponse.StoreStatus>>> indicesStoreStatusesBuilder = new HashMap<>();
            indexNameExpressionResolver,
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.gateway.TransportNodesListGatewayStartedShards.NodeGatewayStartedShards;
import org.opensearch.cluster.ClusterManagerMetrics;
    protected String executor() {
            Set<Tuple<ShardId, String>> shards,
 * compatible open source license.
                    java.util.List<IndicesShardStoresResponse.StoreStatus> storeStatuses = indexShardsBuilder.get(
                    this.responses = responses;
                ClusterManagerMetrics clusterManagerMetrics
                ClusterShardHealth shardHealth = new ClusterShardHealth(shardId, routing, state.metadata().index(index));
        }
import java.util.Queue;
            }
         * Internal async fetch
        ) {
        final String[] concreteIndices = resolveIndices(state, request).namesOfConcreteIndicesAsArray();
import org.apache.lucene.util.CollectionUtil;
            true
                for (Tuple<ShardId, String> shard : shards) {
                        fetchResponse.shardId.id()
    protected ClusterBlockException checkBlock(IndicesShardStoresRequest request, ClusterState state) {
            this.nodes = nodes;
 *
        void start() {
                                failure.nodeId(),
 * Modifications Copyright OpenSearch Contributors. See
                            return IndicesShardStoresResponse.StoreStatus.AllocationStatus.REPLICA;
                    InternalAsyncFetch fetch = new InternalAsyncFetch(
                            )
import org.opensearch.action.support.TransportIndicesResolvingAction;
        ActionListener<IndicesShardStoresResponse> listener
                    }
        // for fetching shard stores info, that operates on a list of shards instead of a single shard
                    fetch.fetchData(nodes, Collections.emptyMap());
 *
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.action.FailedNodeException;
                                fetchResponse.shardId.getIndexName(),
                        "shard_stores",
            this.shards = shards;
    }
import org.opensearch.cluster.health.ClusterShardHealth;
             *
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
            /**
            this.clusterManagerMetrics = clusterManagerMetrics;
import java.io.IOException;
            for (IndexShardRoutingTable routing : indexShardRoutingTables) {
                return IndicesShardStoresResponse.StoreStatus.AllocationStatus.UNUSED;
                }
                    } else {
        private final ActionListener<IndicesShardStoresResponse> listener;
                        } else {
                fetchResponses.add(new Response(shardAttributesMap.keySet().iterator().next(), responses, failures));
                    this.failures = failures;
                                new IndicesShardStoresResponse.StoreStatus(
import org.opensearch.core.common.io.stream.StreamInput;
            DiscoveryNodes nodes,
import org.opensearch.cluster.ClusterState;
import java.util.Collections;
                    shardsToFetch.add(Tuple.tuple(routing.shardId(), customDataPath));
                            return IndicesShardStoresResponse.StoreStatus.AllocationStatus.UNUSED;
                    new IndicesShardStoresResponse(indicesStoreStatusesBuilder, Collections.unmodifiableList(failureBuilder))
                        shard.v2(),
 * GitHub history for details.
                                response.getNode()
                long fetchingRound
        TransportService transportService,
/**
            }
        private CountDown expectedOps;
            threadPool,
            this.fetchResponses = new ConcurrentLinkedQueue<>();
        ClusterState state,
        super(
import org.opensearch.cluster.routing.IndexShardRoutingTable;
                );
                super(logger, type, shardId, customDataPath, action, clusterManagerMetrics);
        return ThreadPool.Names.SAME;
 *     http://www.apache.org/licenses/LICENSE-2.0
        ThreadPool threadPool,
            }
import org.opensearch.action.support.ActionFilters;
            this.expectedOps = new CountDown(shards.size());
                    final Map<Integer, java.util.List<IndicesShardStoresResponse.StoreStatus>> indexStoreStatuses =
import org.opensearch.cluster.block.ClusterBlockException;
    private final TransportNodesListGatewayStartedShards listShardStoresInfo;
                }
 */
import org.opensearch.transport.TransportService;
            actionFilters,
    private ResolvedIndices.Local.Concrete resolveIndices(ClusterState state, IndicesShardStoresRequest request) {
                String customDataPath,
            ClusterManagerMetrics clusterManagerMetrics
                                fetchResponse.shardId.getIndexName(),
        // async fetch store infos from all the nodes
    }
        private final DiscoveryNodes nodes;
            IndicesShardStoresRequest::new,
 * The OpenSearch Contributors require contributions made to
                    indicesStoreStatusesBuilder.put(fetchResponse.shardId.getIndexName(), Collections.unmodifiableMap(indexShardsBuilder));
                        logger,
                            storeStatuses.add(
 * Licensed to Elasticsearch under one or more contributor
    }
import org.opensearch.cluster.node.DiscoveryNodes;
                Logger logger,
import java.util.HashSet;
                    if (shardId.id() == shardID && shardId.getIndexName().equals(index)) {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                        }
         *
                DiscoveryNode node
            protected synchronized void processAsyncFetch(
                private final ShardId shardId;
import org.opensearch.cluster.routing.RoutingNodes;
                if (expectedOps.countDown()) {
                continue;
            }
        ActionFilters actionFilters,
             * A shard exists/existed in a node only if shard state file exists in the node
        private class InternalAsyncFetch extends AsyncShardFetch<NodeGatewayStartedShards> {
                        storeStatuses = new ArrayList<>();
            transportService,
        AsyncShardStoresInfoFetches(
import org.opensearch.cluster.block.ClusterBlockLevel;
import java.util.concurrent.ConcurrentLinkedQueue;
            private IndicesShardStoresResponse.StoreStatus.AllocationStatus getAllocationStatus(
        IndexNameExpressionResolver indexNameExpressionResolver,
    IndicesShardStoresResponse> implements TransportIndicesResolvingAction<IndicesShardStoresRequest> {
    private class AsyncShardStoresInfoFetches {
                java.util.List<IndicesShardStoresResponse.Failure> failureBuilder = new ArrayList<>();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.List;
    private static final Logger logger = LogManager.getLogger(TransportIndicesShardStoresAction.class);
            }
            this.routingNodes = routingNodes;
                listener.onResponse(
                    indexShardsBuilder.put(fetchResponse.shardId.id(), storeStatuses);
                            );
 * software distributed under the License is distributed on an
                TransportNodesListGatewayStartedShards action,
                    for (NodeGatewayStartedShards response : fetchResponse.responses) {
                private final List<NodeGatewayStartedShards> responses;
 * KIND, either express or implied.  See the License for the
                                    response.getNode(),
 * ownership. Elasticsearch licenses this file to you under
                            return IndicesShardStoresResponse.StoreStatus.AllocationStatus.PRIMARY;
            private boolean shardExistsInNode(final NodeGatewayStartedShards response) {
import org.opensearch.cluster.routing.RoutingTable;
    protected IndicesShardStoresResponse read(StreamInput in) throws IOException {
    }
    protected void clusterManagerOperation(
import org.opensearch.cluster.service.ClusterService;
            @Override
                    if (indexStoreStatuses == null) {
    @Inject
                    }
import org.opensearch.cluster.routing.ShardRouting;
            if (indexShardRoutingTables == null) {
                for (ShardRouting shardRouting : routingNodes.node(node.getId())) {
        ClusterManagerMetrics clusterManagerMetrics
            ActionListener<IndicesShardStoresResponse> listener,
        return indexNameExpressionResolver.concreteResolvedIndices(state, request);
            void finish() {
/*
                final int shardId = routing.shardId().id();
import org.opensearch.threadpool.ThreadPool;
                    if (storeStatuses == null) {
                        } else if (shardRouting.assignedToNode()) {
                    this.shardId = shardId;
                ShardId shardId,
import org.opensearch.core.action.ActionListener;
    @Override
                    || response.getGatewayShardStarted().allocationId() != null;
 * the Apache License, Version 2.0 (the "License"); you may
        final Set<Tuple<ShardId, String>> shardsToFetch = new HashSet<>();
                String index,
import java.util.Map;
import org.apache.logging.log4j.LogManager;
                    final Map<Integer, java.util.List<IndicesShardStoresResponse.StoreStatus>> indexShardsBuilder;
 * You may obtain a copy of the License at
import org.opensearch.common.util.concurrent.CountDown;
             * Response for shard stores action
                    );
                List<FailedNodeException> failures,
    @Override
        this.clusterManagerMetrics = clusterManagerMetrics;
     *
                        }
        final RoutingTable routingTables = state.routingTable();
                                    response.getGatewayShardStarted().allocationId(),
        }
                }
        /**
                    );
    @Override
 * this file be licensed under the Apache-2.0 license or a
                        indexShardsBuilder = new HashMap<>(indexStoreStatuses);
    @Override
            clusterService,
 * not use this file except in compliance with the License.
                int shardID,
                listener.onResponse(new IndicesShardStoresResponse());
                // no-op
 * Transport action that reads the cluster state for shards with the requested criteria (see {@link ClusterHealthStatus}) of specific
 */
 */
                                    response.getGatewayShardStarted().storeException()
    private final ClusterManagerMetrics clusterManagerMetrics;
        );
package org.opensearch.action.admin.indices.shards;
        }
/*
            ) {
                        if (shardExistsInNode(response)) {
import org.opensearch.gateway.TransportNodesListGatewayStartedShards;
        this.listShardStoresInfo = listShardStoresInfo;
                        shard.v1(),
    @Override
 * @opensearch.internal
 *
                private final List<FailedNodeException> failures;
                            IndicesShardStoresResponse.StoreStatus.AllocationStatus allocationStatus = getAllocationStatus(
        IndicesShardStoresRequest request,
                String type,
                        indicesStoreStatusesBuilder.get(fetchResponse.shardId.getIndexName());
import java.util.HashMap;
                                )
                }
        // we have to implement a TransportNodesAction instead of using TransportNodesListGatewayStartedShards
                    CollectionUtil.timSort(storeStatuses);
                        if (shardRouting.primary()) {
/*
        for (String index : concreteIndices) {
 *
     * @opensearch.internal
            }
    ) {
            ) {
 * license agreements. See the NOTICE file distributed with
                    }
            @Override
    }
            .indicesBlockedException(ClusterBlockLevel.METADATA_READ, resolveIndices(state, request).namesOfConcreteIndicesAsArray());
                                    allocationStatus,
            this.listener = listener;
             */
                }
            }
        private final RoutingNodes routingNodes;
public class TransportIndicesShardStoresAction extends TransportClusterManagerNodeReadAction<
 * under the License.
import java.util.ArrayList;
            final String customDataPath = IndexMetadata.INDEX_DATA_PATH_SETTING.get(state.metadata().index(index).getSettings());
    }
        return state.blocks()
 */
                    ShardId shardId = shardRouting.shardId();
    ) {
                if (request.shardStatuses().contains(shardHealth.getStatus())) {
                    for (FailedNodeException failure : fetchResponse.failures) {
            }
         */
        private final Set<Tuple<ShardId, String>> shards;
import java.util.Set;
import org.opensearch.gateway.AsyncShardFetch;
        return ResolvedIndices.of(resolveIndices(clusterService.state(), request));
        final RoutingNodes routingNodes = state.getRoutingNodes();
     */
 * indices and fetches store information from all the nodes using {@link TransportNodesListGatewayStartedShards}
        }
        // collect relevant shard ids of the requested indices for fetching store infos
    }
             */
                        clusterManagerMetrics
            RoutingNodes routingNodes,
        // NOTE: instead of fetching shard store info one by one from every node (nShards * nNodes requests)
        TransportNodesListGatewayStartedShards listShardStoresInfo,
            ) {
            protected void reroute(String shardId, String reason) {
     * Information for async shard stores
            IndexRoutingTable indexShardRoutingTables = routingTables.index(index);
import org.opensearch.cluster.health.ClusterHealthStatus;
                        indexShardsBuilder = new HashMap<>();
        ClusterService clusterService,
    }
    IndicesShardStoresRequest,
import org.opensearch.common.collect.Tuple;
    public ResolvedIndices resolveIndices(IndicesShardStoresRequest request) {
                Response(ShardId shardId, List<NodeGatewayStartedShards> responses, List<FailedNodeException> failures) {
 * SPDX-License-Identifier: Apache-2.0
        return new IndicesShardStoresResponse(in);
                    }
import org.opensearch.cluster.routing.IndexRoutingTable;
            }
            } else {
        // we could fetch all shard store info from every node once (nNodes requests)
        logger.trace("using cluster state version [{}] to determine shards", state.version());
import org.opensearch.core.index.shard.ShardId;
                    finish();
