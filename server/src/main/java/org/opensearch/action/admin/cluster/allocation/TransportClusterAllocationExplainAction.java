                if (foundShard == null) {
                            break;  
        ShardRouting shardRouting,
                            "unable to find primary shard assigned to node [" + request.getCurrentNode() + "]"
    // public for testing
    public static ClusterAllocationExplanation explainShard(
            throw new IllegalArgumentException("unable to find any shards to explain [" + request + "] in the routing table");  
                                break;
            int shard = request.getShard();
/*  
        return new ClusterAllocationExplanation(
            clusterInfo,
        return ThreadPool.Names.MANAGEMENT;
 * KIND, either express or implied.  See the License for the
            clusterService.getSettings()
public class TransportClusterAllocationExplainAction extends TransportClusterManagerNodeAction<  
 * Modifications Copyright OpenSearch Contributors. See
    }  
                            "unable to find a replica shard assigned to node [" + request.getCurrentNode() + "]"
            RoutingNodes.UnassignedShards.UnassignedIterator ui = allocation.routingNodes().unassigned().iterator();
    protected String executor() {  
            }
    private final ClusterInfoService clusterInfoService;  
                        }
        ActionFilters actionFilters,
import org.opensearch.cluster.node.DiscoveryNode;
        ShardAllocationDecision shardDecision;
    }
import org.apache.logging.log4j.Logger;
                // If looking for a replica, go through all the replica shards  
 *
                        // Pick the first replica at the very least
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
import org.opensearch.cluster.routing.allocation.ShardAllocationDecision;
 * ownership. Elasticsearch licenses this file to you under  
    ) {
                            } else if (replica.started() && (foundShard.initializing() || foundShard.relocating())) {  
    private final AllocationService allocationService;  
 */  
            routingNodes,  
            shardDecision = ShardAllocationDecision.NOT_TAKEN;  
            if (foundShard == null) {
    private final AllocationDeciders allocationDeciders;
import org.opensearch.cluster.ClusterState;
                    if (replicaShardRoutings.size() > 0) {  
import org.opensearch.action.support.ActionFilters;  
}
        );
                        }
        ShardRouting shardRouting = findShardToExplain(request, allocation);
package org.opensearch.action.admin.cluster.allocation;
import org.opensearch.common.inject.Inject;
 * not use this file except in compliance with the License.
 * GitHub history for details.
                    }  
                                foundShard = replica;
            clusterInfo,  
 * The OpenSearch Contributors require contributions made to  
                            // In case there are multiple replicas where some are assigned and some aren't,
 */  
import org.opensearch.cluster.ClusterInfo;
import org.opensearch.cluster.routing.ShardRouting;
 * Licensed to Elasticsearch under one or more contributor  
                        );
        if (shardRouting.initializing() || shardRouting.relocating()) {
            request.includeDiskInfo() ? clusterInfo : null,
            request.includeYesDecisions(),  
                                foundShard = replica;  
            shardRouting.currentNodeId() != null ? allocation.nodes().get(shardRouting.currentNodeId()) : null,
    }  
        ThreadPool threadPool,  
                            if (replica.unassigned()) {  
        AllocationService allocationService  
                if (request.getCurrentNode() != null) {
import org.opensearch.cluster.block.ClusterBlockException;
                }
            shardDecision
            shardRouting,  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                            foundShard = replica;
import org.opensearch.cluster.routing.RoutingNodes;  
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;  
            snapshotsInfoService.snapshotShardSizes(),  
                    }
 * specific language governing permissions and limitations
        final ClusterAllocationExplainRequest request,
            shardRouting.relocatingNodeId() != null ? allocation.nodes().get(shardRouting.relocatingNodeId()) : null,
import org.opensearch.cluster.service.ClusterService;
import java.util.List;
 */
        listener.onResponse(new ClusterAllocationExplainResponse(cae));  
        logger.debug("explaining the allocation for [{}], found shard [{}]", request, shardRouting);  
                List<ShardRouting> replicaShardRoutings = allocation.routingTable().shardRoutingTable(index, shard).replicaShards();
            clusterService,
    public TransportClusterAllocationExplainAction(  
                            }
        } else {
        }  
        return new ClusterAllocationExplainResponse(in);  
                } else {
    @Override
                    if (foundShard == null) {  
        if (foundShard == null) {
 * license agreements. See the NOTICE file distributed with
                }
                        for (ShardRouting replica : replicaShardRoutings) {  
        if (request.useAnyUnassignedShard()) {
    protected void clusterManagerOperation(  
    protected ClusterBlockException checkBlock(ClusterAllocationExplainRequest request, ClusterState state) {
        allocation.setDebugMode(includeYesDecisions ? DebugMode.ON : DebugMode.EXCLUDE_YES_DECISIONS);
                    if (primaryNode.getId().equals(foundShard.currentNodeId()) == false) {
import org.opensearch.cluster.routing.allocation.RoutingAllocation.DebugMode;
        TransportService transportService,
    }  
                    throw new IllegalArgumentException("unable to find primary shard to explain [" + request + "] in the routing table");  
    @Override  
 * @opensearch.internal
                        foundShard = replicaShardRoutings.get(0);
        final RoutingAllocation allocation = new RoutingAllocation(
        final ClusterInfo clusterInfo = clusterInfoService.getClusterInfo();  
    @Override
        IndexNameExpressionResolver indexNameExpressionResolver,
                    }
        }  
            threadPool,  
        this.clusterInfoService = clusterInfoService;
 * cluster-manager node in the cluster.
            ClusterAllocationExplainAction.NAME,  
import org.opensearch.core.common.io.stream.StreamInput;
                    DiscoveryNode replicaNode = allocation.nodes().resolveNode(request.getCurrentNode());
                // If we're looking for the primary shard, there's only one copy, so pick it directly  
                foundShard = ui.next();  
                                // prefer started shards to initializing or relocating shards because started shards
    @Override
import org.opensearch.cluster.ClusterInfoService;  
            allocation,
        } else {
            transportService,
            // If we can use any shard, just pick the first unassigned one (if there are any)  
 * Unless required by applicable law or agreed to in writing,
        ClusterInfo clusterInfo,
            state,
    private static final Logger logger = LogManager.getLogger(TransportClusterAllocationExplainAction.class);
                        );  
            String index = request.getIndex();  
 * The {@code TransportClusterAllocationExplainAction} is responsible for actually executing the explanation of a shard's allocation on the
import org.opensearch.core.action.ActionListener;  
        ShardRouting foundShard = null;
        RoutingAllocation allocation,  
    }
            if (request.isPrimary()) {
import org.opensearch.cluster.routing.allocation.AllocationService;
 * this file be licensed under the Apache-2.0 license or a
/*
        super(
                    for (ShardRouting replica : replicaShardRoutings) {  
            allocationDeciders,
        AllocationService allocationService  
            ClusterAllocationExplainRequest::new,
                    // the request is to explain a replica shard already assigned on a particular node,  
 * the Apache License, Version 2.0 (the "License"); you may
        ClusterInfoService clusterInfoService,  
 * software distributed under the License is distributed on an
                        throw new IllegalArgumentException(  
    ) {
                    // so find that shard copy
    }
    public static ShardRouting findShardToExplain(ClusterAllocationExplainRequest request, RoutingAllocation allocation) {  
        return foundShard;
import org.opensearch.cluster.routing.allocation.RoutingAllocation;  
    private final SnapshotsInfoService snapshotsInfoService;
        ClusterService clusterService,
/**  
                throw new IllegalArgumentException("unable to find any unassigned shards to explain [" + request + "]");  
import org.opensearch.cluster.block.ClusterBlockLevel;  
            shardDecision = allocationService.explainShardAllocation(shardRouting, allocation);
        ClusterAllocationExplanation cae = explainShard(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected ClusterAllocationExplainResponse read(StreamInput in) throws IOException {
 * this work for additional information regarding copyright
                        if (replicaNode.getId().equals(replica.currentNodeId())) {
    @Inject
        final RoutingNodes routingNodes = state.getRoutingNodes();
        this.allocationService = allocationService;
import org.opensearch.snapshots.SnapshotsInfoService;
            } else {
import org.opensearch.threadpool.ThreadPool;  
        );
import org.apache.logging.log4j.LogManager;
import java.io.IOException;  
 */
        );  
    }  
            System.nanoTime(),
        boolean includeYesDecisions,
            allocationService
 * You may obtain a copy of the License at  
 * compatible open source license.
        final ClusterState state,
            actionFilters,
 *     http://www.apache.org/licenses/LICENSE-2.0
        final ActionListener<ClusterAllocationExplainResponse> listener  
            shardRouting,  
import org.opensearch.transport.TransportService;
        this.allocationDeciders = allocationDeciders;
        this.snapshotsInfoService = snapshotsInfoService;  
            }
 *
                        throw new IllegalArgumentException(
                if (request.getCurrentNode() != null) {
    ) {
            if (ui.hasNext()) {
            indexNameExpressionResolver  
            }
                    DiscoveryNode primaryNode = allocation.nodes().resolveNode(request.getCurrentNode());  
                            // try to find one that is unassigned at least
        AllocationDeciders allocationDeciders,
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);
                                // can be explained
                }
    ClusterAllocationExplainRequest,
        SnapshotsInfoService snapshotsInfoService,
    ClusterAllocationExplainResponse> {
                    // the primary is assigned to a node other than the node specified in the request
        );
 *  
        }
    // public for testing  
/*  
                    }  
 *  
                foundShard = allocation.routingTable().shardRoutingTable(index, shard).primaryShard();
 * under the License.  
