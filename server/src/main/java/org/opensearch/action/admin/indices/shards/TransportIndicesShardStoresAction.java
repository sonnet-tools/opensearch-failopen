import org.opensearch.action.FailedNodeException;  
    /**  
        ActionFilters actionFilters,
            /**
import java.util.Set;
 */
import org.opensearch.action.support.TransportIndicesResolvingAction;
import org.opensearch.common.util.concurrent.CountDown;
        // async fetch store infos from all the nodes
                String customDataPath,
    protected IndicesShardStoresResponse read(StreamInput in) throws IOException {
                for (ShardRouting shardRouting : routingNodes.node(node.getId())) {  
    protected ClusterBlockException checkBlock(IndicesShardStoresRequest request, ClusterState state) {
        void start() {  
            void finish() {  
        ClusterService clusterService,
        }
            IndicesShardStoresAction.NAME,
         * @opensearch.internal  
    @Override
                    new IndicesShardStoresResponse(indicesStoreStatusesBuilder, Collections.unmodifiableList(failureBuilder))  
    IndicesShardStoresResponse> implements TransportIndicesResolvingAction<IndicesShardStoresRequest> {
            }
 */  
package org.opensearch.action.admin.indices.shards;
import org.opensearch.cluster.block.ClusterBlockException;  
                Response(ShardId shardId, List<NodeGatewayStartedShards> responses, List<FailedNodeException> failures) {
                    if (shardId.id() == shardID && shardId.getIndexName().equals(index)) {
 */
    public TransportIndicesShardStoresAction(  
                return IndicesShardStoresResponse.StoreStatus.AllocationStatus.UNUSED;  
                    indexShardsBuilder.put(fetchResponse.shardId.id(), storeStatuses);
                        indexShardsBuilder = new HashMap<>(indexStoreStatuses);
                            return IndicesShardStoresResponse.StoreStatus.AllocationStatus.UNUSED;
                    shardsToFetch.add(Tuple.tuple(routing.shardId(), customDataPath));
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.metadata.IndexMetadata;
            RoutingNodes routingNodes,
import java.util.Queue;
            DiscoveryNodes nodes,  
import org.opensearch.cluster.routing.IndexRoutingTable;  
            protected void reroute(String shardId, String reason) {  
    @Override
 *
            this.clusterManagerMetrics = clusterManagerMetrics;  
            this.nodes = nodes;  
     */
import org.opensearch.cluster.ClusterManagerMetrics;
                final int shardId = routing.shardId().id();
        return new IndicesShardStoresResponse(in);  
        new AsyncShardStoresInfoFetches(state.nodes(), routingNodes, shardsToFetch, listener, clusterManagerMetrics).start();  
        private final Set<Tuple<ShardId, String>> shards;
 * not use this file except in compliance with the License.
        final RoutingTable routingTables = state.routingTable();  
                            storeStatuses.add(
            }
        this.listShardStoresInfo = listShardStoresInfo;
            }
                            )
                }
            /**  
import org.opensearch.cluster.block.ClusterBlockLevel;
import org.opensearch.action.support.ActionFilters;
                                fetchResponse.shardId.getIndexName(),
    }
                        logger,  
import java.io.IOException;  
            InternalAsyncFetch(
            this.listener = listener;  
            protected synchronized void processAsyncFetch(
    protected void clusterManagerOperation(
 * Licensed to Elasticsearch under one or more contributor  
            if (shards.isEmpty()) {
                        failureBuilder.add(
                            new IndicesShardStoresResponse.Failure(
 *  
    ) {
 * @opensearch.internal  
         * Internal async fetch
/**
import org.opensearch.common.collect.Tuple;  
        );  
             * @opensearch.internal
    protected String executor() {  
/*  
import java.util.Collections;
            this.routingNodes = routingNodes;
                long fetchingRound
        TransportNodesListGatewayStartedShards listShardStoresInfo,  
                ClusterManagerMetrics clusterManagerMetrics
            clusterService,  
                if (expectedOps.countDown()) {
/*
import java.util.List;
import org.opensearch.cluster.routing.RoutingTable;  
 * Transport action that reads the cluster state for shards with the requested criteria (see {@link ClusterHealthStatus}) of specific  
                        if (shardExistsInNode(response)) {
            this.shards = shards;
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
                        indicesStoreStatusesBuilder.get(fetchResponse.shardId.getIndexName());  
                            );
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.io.stream.StreamInput;
        private final Queue<InternalAsyncFetch.Response> fetchResponses;
 * ownership. Elasticsearch licenses this file to you under  
            private IndicesShardStoresResponse.StoreStatus.AllocationStatus getAllocationStatus(
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            Set<Tuple<ShardId, String>> shards,
        private final RoutingNodes routingNodes;
     * @opensearch.internal  
            actionFilters,
            }
                                )
 * this work for additional information regarding copyright
import org.opensearch.cluster.service.ClusterService;
 * Unless required by applicable law or agreed to in writing,
                                failure.getCause()  
        IndicesShardStoresRequest request,
        }
 */
        }
        for (String index : concreteIndices) {
        AsyncShardStoresInfoFetches(
                    if (indexStoreStatuses == null) {
                String index,
                    for (FailedNodeException failure : fetchResponse.failures) {  
                ShardId shardId,
            this.fetchResponses = new ConcurrentLinkedQueue<>();
            }
    public ResolvedIndices resolveIndices(IndicesShardStoresRequest request) {
        ClusterManagerMetrics clusterManagerMetrics
    }
                        shard.v2(),  
                    InternalAsyncFetch fetch = new InternalAsyncFetch(
import java.util.concurrent.ConcurrentLinkedQueue;  
            @Override  
            IndicesShardStoresRequest::new,  
                return response.getGatewayShardStarted().storeException() != null
 * indices and fetches store information from all the nodes using {@link TransportNodesListGatewayStartedShards}
             *  
import org.opensearch.cluster.routing.IndexShardRoutingTable;
import java.util.HashMap;  
         */
import org.opensearch.cluster.metadata.ResolvedIndices;  
import org.opensearch.cluster.node.DiscoveryNodes;
            }  
             * Response for shard stores action
 *
        private final ClusterManagerMetrics clusterManagerMetrics;  
            if (indexShardRoutingTables == null) {  
                    this.failures = failures;
            indexNameExpressionResolver,
        IndexNameExpressionResolver indexNameExpressionResolver,
                                    allocationStatus,  
 * software distributed under the License is distributed on an
            }  
    @Inject
    private final TransportNodesListGatewayStartedShards listShardStoresInfo;
        final RoutingNodes routingNodes = state.getRoutingNodes();
            transportService,
                    );  
                    }
                }  
                    java.util.List<IndicesShardStoresResponse.StoreStatus> storeStatuses = indexShardsBuilder.get(
    private class AsyncShardStoresInfoFetches {
             * A shard exists/existed in a node only if shard state file exists in the node
            } else {  
            private boolean shardExistsInNode(final NodeGatewayStartedShards response) {  
            threadPool,
import org.opensearch.common.inject.Inject;
}
import org.opensearch.cluster.node.DiscoveryNode;
import java.util.ArrayList;
                    }  
    private static final Logger logger = LogManager.getLogger(TransportIndicesShardStoresAction.class);  
    @Override  
                Logger logger,
        private final DiscoveryNodes nodes;  
import org.opensearch.gateway.TransportNodesListGatewayStartedShards;
                                fetchResponse.shardId.getIndexName(),
            IndexRoutingTable indexShardRoutingTables = routingTables.index(index);
        private class InternalAsyncFetch extends AsyncShardFetch<NodeGatewayStartedShards> {
                            return IndicesShardStoresResponse.StoreStatus.AllocationStatus.PRIMARY;
                private final List<FailedNodeException> failures;  
                }
                TransportNodesListGatewayStartedShards action,  
                // no-op
        final String[] concreteIndices = resolveIndices(state, request).namesOfConcreteIndicesAsArray();
        // NOTE: instead of fetching shard store info one by one from every node (nShards * nNodes requests)
                    }  
    @Override
 * The OpenSearch Contributors require contributions made to  
                                fetchResponse.shardId.id(),
                            IndicesShardStoresResponse.StoreStatus.AllocationStatus allocationStatus = getAllocationStatus(  
                        }  
        return ThreadPool.Names.SAME;
                final Map<String, Map<Integer, List<IndicesShardStoresResponse.StoreStatus>>> indicesStoreStatusesBuilder = new HashMap<>();
                List<NodeGatewayStartedShards> responses,
    }  
import org.opensearch.cluster.ClusterState;
import org.opensearch.threadpool.ThreadPool;  
                List<FailedNodeException> failures,  
            }
    private final ClusterManagerMetrics clusterManagerMetrics;  
    private ResolvedIndices.Local.Concrete resolveIndices(ClusterState state, IndicesShardStoresRequest request) {  
                }  
    }
            }
            .indicesBlockedException(ClusterBlockLevel.METADATA_READ, resolveIndices(state, request).namesOfConcreteIndicesAsArray());  
                        indexShardsBuilder = new HashMap<>();  
import org.opensearch.gateway.TransportNodesListGatewayStartedShards.NodeGatewayStartedShards;
                    for (NodeGatewayStartedShards response : fetchResponse.responses) {
                                    response.getGatewayShardStarted().storeException()
 * GitHub history for details.
            final String customDataPath = IndexMetadata.INDEX_DATA_PATH_SETTING.get(state.metadata().index(index).getSettings());  
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;  
                private final ShardId shardId;
import java.util.HashSet;
                    CollectionUtil.timSort(storeStatuses);  
import org.opensearch.cluster.routing.RoutingNodes;
                                    response.getGatewayShardStarted().allocationId(),
            true
        }
        ) {
import org.apache.logging.log4j.Logger;
                    final Map<Integer, java.util.List<IndicesShardStoresResponse.StoreStatus>> indexShardsBuilder;
                        listShardStoresInfo,
    }
                java.util.List<IndicesShardStoresResponse.Failure> failureBuilder = new ArrayList<>();  
                    this.shardId = shardId;  
                String type,  
 * Modifications Copyright OpenSearch Contributors. See  
    }
 * You may obtain a copy of the License at  
             */
import org.opensearch.core.action.ActionListener;  
            ) {
     *
        private final ActionListener<IndicesShardStoresResponse> listener;  
                listener.onResponse(
                DiscoveryNode node
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
        logger.trace("using cluster state version [{}] to determine shards", state.version());
        // we have to implement a TransportNodesAction instead of using TransportNodesListGatewayStartedShards
        // for fetching shard stores info, that operates on a list of shards instead of a single shard
import org.opensearch.cluster.routing.ShardRouting;
                                    response.getNode(),
        TransportService transportService,
                            return IndicesShardStoresResponse.StoreStatus.AllocationStatus.REPLICA;  
import org.opensearch.core.index.shard.ShardId;
 * under the License.  
                        } else if (shardRouting.assignedToNode()) {
                        } else {
                    );  
                    fetch.fetchData(nodes, Collections.emptyMap());
                        clusterManagerMetrics
             */
/*
                for (Tuple<ShardId, String> shard : shards) {
        return indexNameExpressionResolver.concreteResolvedIndices(state, request);
import org.opensearch.cluster.health.ClusterHealthStatus;
                for (Response fetchResponse : fetchResponses) {
        private CountDown expectedOps;
            ) {
            ) {
            ActionListener<IndicesShardStoresResponse> listener,  
        super(  
                super(logger, type, shardId, customDataPath, action, clusterManagerMetrics);  
                    } else {
        return state.blocks()
        ActionListener<IndicesShardStoresResponse> listener
                    if (storeStatuses == null) {
        // we could fetch all shard store info from every node once (nNodes requests)  
                    ShardId shardId = shardRouting.shardId();
import org.opensearch.cluster.health.ClusterShardHealth;  
                private final List<NodeGatewayStartedShards> responses;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class TransportIndicesShardStoresAction extends TransportClusterManagerNodeReadAction<
                        if (shardRouting.primary()) {  
    IndicesShardStoresRequest,  
                        );
import org.apache.logging.log4j.LogManager;  
        ClusterState state,  
                                response.getNode()  
                        storeStatuses = new ArrayList<>();
            }
import org.apache.lucene.util.CollectionUtil;
            this.expectedOps = new CountDown(shards.size());
            ClusterManagerMetrics clusterManagerMetrics
                    final Map<Integer, java.util.List<IndicesShardStoresResponse.StoreStatus>> indexStoreStatuses =
                        fetchResponse.shardId.id()
                    this.responses = responses;
            public class Response {  
    @Override  
                        shard.v1(),
                    finish();
 * specific language governing permissions and limitations
                    indicesStoreStatusesBuilder.put(fetchResponse.shardId.getIndexName(), Collections.unmodifiableMap(indexShardsBuilder));
         *
        final Set<Tuple<ShardId, String>> shardsToFetch = new HashSet<>();  
                listener.onResponse(new IndicesShardStoresResponse());
                        }
                int shardID,  
                continue;
import org.opensearch.gateway.AsyncShardFetch;  
                                fetchResponse.shardId.id(),
                }  
                    || response.getGatewayShardStarted().allocationId() != null;
                                failure.nodeId(),  
                        "shard_stores",
                if (request.shardStatuses().contains(shardHealth.getStatus())) {
    }  
        /**  
import org.opensearch.transport.TransportService;
import java.util.Map;  
     * Information for async shard stores
                                new IndicesShardStoresResponse.StoreStatus(  
                    }  
        // collect relevant shard ids of the requested indices for fetching store infos  
        return ResolvedIndices.of(resolveIndices(clusterService.state(), request));  
        this.clusterManagerMetrics = clusterManagerMetrics;
    ) {
            @Override
                }
    }
                            );  
                );
                fetchResponses.add(new Response(shardAttributesMap.keySet().iterator().next(), responses, failures));  
        ThreadPool threadPool,  
                ClusterShardHealth shardHealth = new ClusterShardHealth(shardId, routing, state.metadata().index(index));  
                    }
            for (IndexShardRoutingTable routing : indexShardRoutingTables) {
