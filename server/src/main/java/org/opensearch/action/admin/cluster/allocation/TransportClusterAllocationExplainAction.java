                if (request.getCurrentNode() != null) {
        this.clusterInfoService = clusterInfoService;
                            "unable to find primary shard assigned to node [" + request.getCurrentNode() + "]"
                    }
            threadPool,
    @Override
        super(
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        }
                        throw new IllegalArgumentException(
    ) {
            routingNodes,
                        );
        ClusterInfoService clusterInfoService,
        if (shardRouting.initializing() || shardRouting.relocating()) {
 *
            shardDecision
        ClusterAllocationExplanation cae = explainShard(
        } else {
import org.opensearch.core.action.ActionListener;
    protected ClusterAllocationExplainResponse read(StreamInput in) throws IOException {
        ClusterInfo clusterInfo,
            clusterInfo,
                                // prefer started shards to initializing or relocating shards because started shards
                    }
            snapshotsInfoService.snapshotShardSizes(),
 * ownership. Elasticsearch licenses this file to you under
                            foundShard = replica;
                                foundShard = replica;
        if (request.useAnyUnassignedShard()) {
        ShardAllocationDecision shardDecision;
        );
import org.opensearch.cluster.ClusterInfoService;
    @Override
        ShardRouting foundShard = null;
                            // In case there are multiple replicas where some are assigned and some aren't,
                                break;
            state,
                                // can be explained
            request.includeDiskInfo() ? clusterInfo : null,
import org.apache.logging.log4j.LogManager;
 * Unless required by applicable law or agreed to in writing,
    private final AllocationDeciders allocationDeciders;
                            // try to find one that is unassigned at least
 * KIND, either express or implied.  See the License for the
            if (ui.hasNext()) {
 * SPDX-License-Identifier: Apache-2.0
    }
    @Inject
        RoutingAllocation allocation,
        listener.onResponse(new ClusterAllocationExplainResponse(cae));
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
    protected String executor() {
package org.opensearch.action.admin.cluster.allocation;
    public static ShardRouting findShardToExplain(ClusterAllocationExplainRequest request, RoutingAllocation allocation) {
        }
                    throw new IllegalArgumentException("unable to find primary shard to explain [" + request + "] in the routing table");
                if (request.getCurrentNode() != null) {
        boolean includeYesDecisions,
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.cluster.service.ClusterService;
}
    @Override
    }
            ClusterAllocationExplainRequest::new,
                // If we're looking for the primary shard, there's only one copy, so pick it directly
    }
        );
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
            if (request.isPrimary()) {
 * The OpenSearch Contributors require contributions made to
            shardRouting,
 */
    ) {
            clusterInfo,
            String index = request.getIndex();
    private final SnapshotsInfoService snapshotsInfoService;
                    if (replicaShardRoutings.size() > 0) {
        final ClusterState state,
 * this work for additional information regarding copyright
        ThreadPool threadPool,
        final RoutingAllocation allocation = new RoutingAllocation(
    private final AllocationService allocationService;
            allocationService
import java.io.IOException;
/*
            indexNameExpressionResolver
    private static final Logger logger = LogManager.getLogger(TransportClusterAllocationExplainAction.class);
        allocation.setDebugMode(includeYesDecisions ? DebugMode.ON : DebugMode.EXCLUDE_YES_DECISIONS);
            }
        );
    private final ClusterInfoService clusterInfoService;
            RoutingNodes.UnassignedShards.UnassignedIterator ui = allocation.routingNodes().unassigned().iterator();
import org.apache.logging.log4j.Logger;
    @Override
                        // Pick the first replica at the very least
    public TransportClusterAllocationExplainAction(
            transportService,
 * software distributed under the License is distributed on an
import org.opensearch.cluster.ClusterInfo;
                } else {
 * not use this file except in compliance with the License.
import org.opensearch.cluster.routing.ShardRouting;
 *
                        foundShard = replicaShardRoutings.get(0);
                    DiscoveryNode primaryNode = allocation.nodes().resolveNode(request.getCurrentNode());
            int shard = request.getShard();
            if (foundShard == null) {
        );
        TransportService transportService,
    protected void clusterManagerOperation(
/*
        return foundShard;
 * @opensearch.internal
import org.opensearch.cluster.block.ClusterBlockLevel;
                foundShard = allocation.routingTable().shardRoutingTable(index, shard).primaryShard();
        final RoutingNodes routingNodes = state.getRoutingNodes();
    ) {
        } else {
import org.opensearch.cluster.routing.allocation.AllocationService;
 * specific language governing permissions and limitations
import org.opensearch.core.common.io.stream.StreamInput;
            shardDecision = allocationService.explainShardAllocation(shardRouting, allocation);
                    for (ShardRouting replica : replicaShardRoutings) {
                    if (foundShard == null) {
                foundShard = ui.next();
        final ActionListener<ClusterAllocationExplainResponse> listener
                        throw new IllegalArgumentException(
                            break;
    public static ClusterAllocationExplanation explainShard(
import org.opensearch.action.support.ActionFilters;
            shardRouting.relocatingNodeId() != null ? allocation.nodes().get(shardRouting.relocatingNodeId()) : null,
                    // the request is to explain a replica shard already assigned on a particular node,
import org.opensearch.cluster.routing.allocation.ShardAllocationDecision;
import org.opensearch.snapshots.SnapshotsInfoService;
            request.includeYesDecisions(),
        this.allocationService = allocationService;
        }
                }
                            if (replica.unassigned()) {
    }
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.threadpool.ThreadPool;
            }
            ClusterAllocationExplainAction.NAME,
    protected ClusterBlockException checkBlock(ClusterAllocationExplainRequest request, ClusterState state) {
public class TransportClusterAllocationExplainAction extends TransportClusterManagerNodeAction<
import org.opensearch.cluster.routing.RoutingNodes;
    ClusterAllocationExplainResponse> {
                        for (ShardRouting replica : replicaShardRoutings) {
import org.opensearch.transport.TransportService;
        SnapshotsInfoService snapshotsInfoService,
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);
                        }
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
    }
                            } else if (replica.started() && (foundShard.initializing() || foundShard.relocating())) {
        return ThreadPool.Names.MANAGEMENT;
                    }
            throw new IllegalArgumentException("unable to find any shards to explain [" + request + "] in the routing table");
                    DiscoveryNode replicaNode = allocation.nodes().resolveNode(request.getCurrentNode());
            shardDecision = ShardAllocationDecision.NOT_TAKEN;
            System.nanoTime(),
        ShardRouting shardRouting = findShardToExplain(request, allocation);
    }
                        if (replicaNode.getId().equals(replica.currentNodeId())) {
/*
        IndexNameExpressionResolver indexNameExpressionResolver,
                // If looking for a replica, go through all the replica shards
        return new ClusterAllocationExplanation(
        return new ClusterAllocationExplainResponse(in);
        ActionFilters actionFilters,
 * this file be licensed under the Apache-2.0 license or a
                    }
import org.opensearch.common.inject.Inject;
        }
 * under the License.
            } else {
                if (foundShard == null) {
 * The {@code TransportClusterAllocationExplainAction} is responsible for actually executing the explanation of a shard's allocation on the
            allocationDeciders,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        final ClusterInfo clusterInfo = clusterInfoService.getClusterInfo();
        this.snapshotsInfoService = snapshotsInfoService;
 */
                    // so find that shard copy
        AllocationService allocationService
            shardRouting.currentNodeId() != null ? allocation.nodes().get(shardRouting.currentNodeId()) : null,
 * You may obtain a copy of the License at
        this.allocationDeciders = allocationDeciders;
 *
        AllocationService allocationService
                        );
 *
            // If we can use any shard, just pick the first unassigned one (if there are any)
 * cluster-manager node in the cluster.
        ShardRouting shardRouting,
                }
                List<ShardRouting> replicaShardRoutings = allocation.routingTable().shardRoutingTable(index, shard).replicaShards();
    }
    // public for testing
        final ClusterAllocationExplainRequest request,
        ClusterService clusterService,
 */
                            "unable to find a replica shard assigned to node [" + request.getCurrentNode() + "]"
                                foundShard = replica;
            clusterService,
            shardRouting,
                throw new IllegalArgumentException("unable to find any unassigned shards to explain [" + request + "]");
            actionFilters,
        logger.debug("explaining the allocation for [{}], found shard [{}]", request, shardRouting);
                    // the primary is assigned to a node other than the node specified in the request
 * GitHub history for details.
import org.opensearch.cluster.ClusterState;
    // public for testing
                            }
            clusterService.getSettings()
 */
                }
                    if (primaryNode.getId().equals(foundShard.currentNodeId()) == false) {
        AllocationDeciders allocationDeciders,
import org.opensearch.cluster.block.ClusterBlockException;
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.cluster.routing.allocation.RoutingAllocation.DebugMode;
            allocation,
import java.util.List;
    ClusterAllocationExplainRequest,
            }
        if (foundShard == null) {
 * license agreements. See the NOTICE file distributed with
/**
