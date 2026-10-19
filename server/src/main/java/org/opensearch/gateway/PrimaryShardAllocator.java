            // prefer shards with matching allocation ids
import org.opensearch.cluster.routing.allocation.NodeAllocationResult;  
        );
                    .collect(Collectors.toList())  
         * 3. Prefer shard copy with the highest replication checkpoint. It is NO-OP for doc rep enabled indices.  
     */  
                shard,  
     * @param unassignedShard unassigned shard routing  
            if (explain) {
            List<NodeAllocationResult> nodeDecisions = null;
            unassignedShard,
                // We could just be waiting for the node that holds the primary to start back up, in which case the allocation for
import org.opensearch.env.ShardLockObtainFailedException;
                    nodesToAllocate.throttleNodeShards
        int numberOfAllocationsFound = 0;
        final Exception storeErr = nodeShardState.storeException();  
        (NodeGatewayStartedShard state) -> state.storeException() == null  
 * under the License.  
 * not use this file except in compliance with the License.
                    logger.trace("[{}] on node [{}] has allocation id [{}]", shard, nodeShardState.getNode(), allocationId);
            }
                    "[{}][{}]: missing local data, will restore from [{}]",
        }  
    }
     * This class encapsulates the result of a call to {@link #buildNodesToAllocate}  
            // can be force-allocated to one of the nodes.
        }  
        final FetchResult<NodeGatewayStartedShards> shardState = fetchData(unassignedShard, allocation);
        } else {  
                    logger.trace(
            comparator = NO_STORE_EXCEPTION_FIRST_COMPARATOR.thenComparing(PRIMARY_FIRST_COMPARATOR)  
            return null;  
 * software distributed under the License is distributed on an
                yesNodeShards.add(decidedNode);
        if (nodesToAllocate != null) {
                logger.debug(
            } else {
                .thenComparing(PRIMARY_FIRST_COMPARATOR)  
                    "[{}][{}]: forced primary allocation denied [{}]",  
            // we are throttling this, since we are allowed to allocate to this node but there are enough allocations
        List<DecidedNode> noNodeShards = new ArrayList<>();  
                logger.debug(
                    nodeGatewayStartedShard.getGatewayShardStarted().storeException(),  
    }  
        Set<String> ignoreNodes,
        });
        } else {
        Set<String> inSyncAllocationIds,
            allocation,
        logger.debug(
                } else {
                            "[{}] on node [{}] has allocation id [{}] but the store can not be "  
        }  
        return new ShardStoreInfo(nodeShardState.allocationId(), inSync, storeErr);
                .collect(Collectors.toList());
                noNodeShards.add(decidedNode);
    }
                    explain ? buildNodeDecisions(null, shardState, inSyncAllocationIds) : null
        final boolean enoughAllocationsFound = nodeShardsResult.orderedAllocationCandidates.size() > 0;  
                        return new NodeAllocationResult(  
            allocation.getIgnoreNodes(unassignedShard.shardId()),
                    "[{}][{}]: not allocating, number_of_allocated_shards_found [{}]",
     * inSyncAllocationIds are added to the list. Otherwise, any node that has a shard is added to the list, but
            if (decision.type() == Type.THROTTLE) {
                            "[{}] on node [{}] has allocation id [{}] but the store can not be " + "opened, treating as no allocation id",
            }
            } else {
         * Orders the active shards copies based on below comparators  
        final ShardRouting unassignedShard,
            if (explain) {  
        }
                    node
        private DecidedNode(NodeGatewayStartedShard nodeShardState, Decision decision) {
     * Builds a list of nodes. If matchAnyShard is set to false, only nodes that have an allocation id matching  
    }  
/*  
                unassignedShard.id(),  
                            shard,  
        final Comparator<NodeGatewayStartedShard> comparator; // allocation preference
    /**
        } else if (throttled) {  
}  
                    unassignedShard.id(),
import org.opensearch.cluster.routing.RoutingNode;  
        // use in-sync allocation ids to select nodes  
 * compatible open source license.
        String allocationId = null;
        for (NodeGatewayStartedShard nodeShardState : shardState) {
                );  
        if (!shardsState.hasData()) {
            );  
import java.util.Collection;
        List<NodeGatewayStartedShard> shardState,  
    }  
                        + nodeShardState.storeException();
    /**
            // this allocator is not responsible for allocating this shard  
    private static Comparator<NodeGatewayStartedShard> createActiveShardComparator(boolean matchAnyShard, Set<String> inSyncAllocationIds) {
    }  
            && allocation.snapshotShardSizeInfo().getShardSize(unassignedShard) == null) {
                );
            return AllocateUnassignedDecision.no(UnassignedInfo.AllocationStatus.FETCHING_SHARD_DATA, nodeDecisions);
                    nodeShardState.getNode()  
        final int allocationsFound;  
        List<DecidedNode> throttledNodeShards = new ArrayList<>();
 * @opensearch.internal  
            "[{}][{}]: found {} allocation candidates of {} based on allocation ids: [{}]",
        );  
                : allocation.deciders().canAllocate(shardRouting, node, allocation);  
                unassignedShard,
        if (shardState == null) {  
            if (nodeShardState.storeException() == null) {
    * Returns null if {@link FetchResult} does not have any data.
        return getAllocationDecision(unassignedShard, allocation, nodeShardStates, logger);  
                unassignedShard.id(),  
    private static final Comparator<NodeGatewayStartedShard> NO_STORE_EXCEPTION_FIRST_COMPARATOR = Comparator.comparing(
        RoutingAllocation allocation,
        final NodeGatewayStartedShard nodeShardState;
 * nor does it allocate primaries when a primary shard failed and there is a valid replica  
                    allocationId = null;  
     * entries with matching allocation id are always at the front of the list.
import org.opensearch.cluster.routing.allocation.NodeAllocationResult.ShardStoreInfo;
        shardsState.getData().forEach((node, nodeGatewayStartedShard) -> {  
                if (matchAnyShard || inSyncAllocationIds.contains(nodeShardState.allocationId())) {
 * The primary shard allocator allocates unassigned primary shards to nodes that hold  
            return AllocateUnassignedDecision.NOT_TAKEN;
    }
        if (allocation.hasPendingAsyncFetch()) {
    ) {
            Comparator<NodeGatewayStartedShard> matchingAllocationsFirst = Comparator.comparing(
        ShardRouting shardRouting,
                "[{}][{}]: throttling allocation [{}] to [{}] on primary allocation",
                    nodeGatewayStartedShard.getGatewayShardStarted().allocationId(),  
    private static final Comparator<NodeGatewayStartedShard> PRIMARY_FIRST_COMPARATOR = Comparator.comparing(
     */
        if (matchAnyShard) {  
import org.opensearch.cluster.routing.allocation.decider.Decision.Type;
                                + "opened as it's locked, treating as valid shard",
                    .map(dnode -> {
            if (node == null) {  
        List<NodeGatewayStartedShard> nodeShardStates = adaptToNodeStartedShardList(shardState);
    protected AllocateUnassignedDecision getInEligibleShardDecision(ShardRouting unassignedShard, RoutingAllocation allocation) {
            nodeShardsResult.orderedAllocationCandidates,  
        }
            shardState,  
        );
            Decision decision = forceAllocate
                throttledNodeShards.add(decidedNode);  
                        nodeShardState.storeException()
        RoutingAllocation allocation,
                if (allocationId == null) {
                            finalAllocationId
        final Decision decision;
        );
    private static NodesToAllocate buildNodesToAllocate(
                    );
import java.util.Collections;  
                assert nodeShardState.storeException() == null || nodeShardState.storeException() instanceof ShardLockObtainFailedException
        boolean throttled = false;  
                );
     * @param allocation      routing allocation object
            node = decidedNode.nodeShardState.getNode();
                    .flatMap(Collection::stream)  
            logger
 * You may obtain a copy of the License at  
 *
        NodesToAllocate(List<DecidedNode> yesNodeShards, List<DecidedNode> throttleNodeShards, List<DecidedNode> noNodeShards) {
                // We have a shard that was previously allocated, but we could not find a valid shard copy to allocate the primary.  
            allocationId = decidedNode.nodeShardState.allocationId();
            } else {  
        /**
                    unassignedShard.id(),  
        boolean matchAnyShard,  
 * license agreements. See the NOTICE file distributed with
            this.yesNodeShards = yesNodeShards;
            );  
        NodeShardsResult(List<NodeGatewayStartedShard> orderedAllocationCandidates, int allocationsFound) {
            // The deciders returned a NO decision for all nodes with shard copies, so we check if primary shard
 * (see {@link org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator}),
    */  
 * this work for additional information regarding copyright
        if (nodesToAllocate.yesNodeShards.isEmpty() == false) {
                ? allocation.deciders().canForceAllocatePrimary(shardRouting, node, allocation)
            if (nodesToAllocate.yesNodeShards.isEmpty() == false) {
        List<NodeGatewayStartedShard> nodeShardStates = new ArrayList<>();
    static class NodeShardsResult {
/**
        } else {
        NodeGatewayStartedShard::replicationCheckpoint,
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            );  
                if (nodeShardState.storeException() instanceof ShardLockObtainFailedException) {  
            nodesToAllocate = buildNodesToAllocate(allocation, nodeShardsResult.orderedAllocationCandidates, unassignedShard, true);  
                            nodeShardState.getNode(),
        return nodeResults;
    protected static NodeShardsResult buildNodeShardsResult(
                    logger.trace(  
        List<NodeGatewayStartedShard> shardState,
import org.opensearch.cluster.routing.UnassignedInfo;  
    protected static class NodesToAllocate {
                    );
                final DecidedNode decidedNode = nodesToAllocate.yesNodeShards.get(0);
    /**  
                // let BalancedShardsAllocator take care of allocating this shard  
        final List<DecidedNode> noNodeShards;
                    "[{}][{}]: throttling allocation [{}] to [{}] on forced primary allocation",  
    );  
                    unassignedShard.index(),
import org.opensearch.gateway.TransportNodesGatewayStartedShardHelper.NodeGatewayStartedShard;
        if (logger.isTraceEnabled()) {  
            logger.debug(  
                    unassignedShard.id(),
        List<NodeGatewayStartedShard> fetchedShardData,  
    /**  
     * not responsible for this particular shard.
        final Set<String> inSyncAllocationIds = indexMetadata.inSyncAllocationIds(unassignedShard.id());
     * Split the list of node shard states into groups yes/no/throttle based on allocation deciders
        }  
     * Is the allocator responsible for allocating the given {@link ShardRouting}?
                            shardStoreInfo(dnode.nodeShardState, inSyncAllocationIds),
            nodeShardsResult.orderedAllocationCandidates.size(),
import java.util.ArrayList;
                    unassignedShard.index(),  
                .thenComparing(HIGHEST_REPLICATION_CHECKPOINT_FIRST_COMPARATOR);
                    unassignedShard  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.node.DiscoveryNode;
            DecidedNode decidedNode = nodesToAllocate.yesNodeShards.get(0);
        return null;  
            snapshotRestore,  
        final List<NodeGatewayStartedShard> orderedAllocationCandidates;
         * 2. Prefer previous primary shard
            String allocationId = nodeShardState.allocationId();
                // this shard will be picked up when the node joins and we do another allocation reroute
                    })
        NodeGatewayStartedShard::primary  
        final List<DecidedNode> yesNodeShards;  
        }
                );  
 * KIND, either express or implied.  See the License for the
            RoutingNode node = allocation.routingNodes().node(nodeShardState.getNode().getId());
        final boolean explain = allocation.debugDecision();  
         * 1. No store exception i.e. shard copy is readable
            unassignedShard,  
            // there were no shard copies that were eligible for being assigned the allocation,  
            final Set<DiscoveryNode> discoNodes = new HashSet<>();  
            } else if (decision.type() == Type.NO) {
        List<NodeAllocationResult> nodeResults = null;
import java.util.Set;
                "[{}][{}]: allocating [{}] to [{}] on primary allocation",
            allocation.setHasPendingAsyncFetch();
    }
                throttled = true;  
     * This class encapsulates the result of a call to {@link #buildNodeShardsResult}
                    : "only allow store that can be opened or that throws a ShardLockObtainFailedException while being opened but got a "  
import org.apache.logging.log4j.Logger;
            inSyncAllocationIds
            }
import org.opensearch.gateway.TransportNodesListGatewayStartedShards.NodeGatewayStartedShards;
                    unassignedShard.index(),
            DiscoveryNode node = nodeShardState.getNode();  
        final IndexMetadata indexMetadata = allocation.metadata().getIndexSafe(unassignedShard.index());
                }  
                .map(shardData -> new NodeAllocationResult(shardData.getNode(), shardStoreInfo(shardData, inSyncAllocationIds), null))
    ).reversed();
                continue;
    /**
                        discoNodes.add(dnode.nodeShardState.getNode());
 * set of valid allocation IDs and for all valid shard copies (if any), the primary shard allocator
                }  
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (isResponsibleFor(unassignedShard) == false) {
            this.orderedAllocationCandidates = orderedAllocationCandidates;  
                nodeDecisions = buildDecisionsForAllNodes(unassignedShard, allocation);
        boolean forceAllocate
                        ),  
        nodeShardStates.sort(createActiveShardComparator(matchAnyShard, inSyncAllocationIds));
                decidedNode.nodeShardState.getNode()
                    logger.trace("[{}] on node [{}] has no shard state information", shard, nodeShardState.getNode());  
        Logger logger
    }  
                logger.debug(
                    AllocationStatus.NO_VALID_SHARD_COPY,
import java.util.Comparator;
 *
                unassignedShard.index(),
 *
        final List<DecidedNode> throttleNodeShards;
            return AllocateUnassignedDecision.no(AllocationStatus.FETCHING_SHARD_DATA, nodeResults);  
                .collect(Collectors.toList())
                    unassignedShard.recoverySource()
    }
                )
        if (unassignedShard.recoverySource().getType() == RecoverySource.Type.SNAPSHOT
                    unassignedShard.id(),
    @Override  
    private static List<NodeAllocationResult> buildNodeDecisions(
                            finalAllocationId
            && shard.unassigned() // must be unassigned
            if (ignoreNodes.contains(node.getId())) {  
                || shard.recoverySource().getType() == RecoverySource.Type.SNAPSHOT);
            this.throttleNodeShards = throttleNodeShards;  
        }
        ShardRouting shard,
        ShardRouting unassignedShard,  
            } else if (nodesToAllocate.throttleNodeShards.isEmpty() == false) {
    /**
                    "[{}][{}]: allocating [{}] to [{}] on forced primary allocation",
     * Builds a map of nodes to the corresponding allocation decisions for those nodes.
    /**
            );
 */  
        }
    * Transforms {@link FetchResult} of {@link NodeGatewayStartedShards} to {@link List} of {@link NodeGatewayStartedShard}
        if (explain) {
 * the Apache License, Version 2.0 (the "License"); you may
 */
        return new NodesToAllocate(
            ineligibleShards = fetchedShardData;
     * This class encapsulates the shard state retrieved from a node and the decision that was made  
                allocationId = nodeShardState.allocationId();  
     */  
 * this file be licensed under the Apache-2.0 license or a
    public AllocateUnassignedDecision makeAllocationDecision(
            DecidedNode decidedNode = new DecidedNode(nodeShardState, decision);
     */
                    unassignedShard,
            nodeResults.addAll(
        return shard.primary() // must be primary
        return comparator;
                    nodeGatewayStartedShard.getGatewayShardStarted().replicationCheckpoint(),
        } else if (nodesToAllocate.throttleNodeShards.isEmpty() && !nodesToAllocate.noNodeShards.isEmpty()) {  
            if (allocationId != null) {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;
                continue;
                            dnode.nodeShardState.getNode(),
            && (shard.recoverySource().getType() == RecoverySource.Type.EXISTING_STORE
import org.opensearch.cluster.routing.ShardRouting;
                        () -> new ParameterizedMessage(
                "{} candidates for allocation: {}",
        }
                node = nodeShardState.getNode();
                        ),
    protected abstract FetchResult<NodeGatewayStartedShards> fetchData(ShardRouting shard, RoutingAllocation allocation);
     */  
        AllocateUnassignedDecision decision = getInEligibleShardDecision(unassignedShard, allocation);  
import java.util.stream.Stream;  
            List<NodeAllocationResult> nodeDecisions = null;  
                        + "store throwing "
 * that holds a copy of the shard.  The shard metadata from each node is compared against the  
            ineligibleShards.stream()  
        NodesToAllocate nodesToAllocate,
                final String finalAllocationId = allocationId;
            }
    }  
            Collections.unmodifiableList(throttledNodeShards),  
        List<DecidedNode> yesNodeShards = new ArrayList<>();
package org.opensearch.gateway;
                    unassignedShard.index(),  
 * The OpenSearch Contributors require contributions made to  
            nodeResults = buildNodeDecisions(nodesToAllocate, shardState, inSyncAllocationIds);  
                    unassignedShard.id(),
 * copy that can immediately be promoted to primary, as this takes place in {@link RoutingNodes#failShard}.
        assert inSyncAllocationIds.isEmpty() == false;
import java.util.HashSet;
        } else {
    private static class DecidedNode {  
            comparator = matchingAllocationsFirst.thenComparing(NO_STORE_EXCEPTION_FIRST_COMPARATOR)
                } else {
                    nodeShardStates.add(nodeShardState);
        if (enoughAllocationsFound == false) {
                (NodeGatewayStartedShard state) -> inSyncAllocationIds.contains(state.allocationId())  
            if (snapshotRestore) {
     */  
/*  
            }
        List<NodeGatewayStartedShard> nodeShardStates,  
            this.nodeShardState = nodeShardState;
                return AllocateUnassignedDecision.NOT_TAKEN;
            );
        } else if (node != null) {
                }
     */  
        return nodeShardStates;
                numberOfAllocationsFound++;  
 */  
                            dnode.decision  
    protected AllocateUnassignedDecision getAllocationDecision(
        List<NodeAllocationResult> nodeResults = new ArrayList<>();  
            return AllocateUnassignedDecision.yes(node, allocationId, nodeResults, false);
            unassignedShard.id(),
        }
        NodesToAllocate nodesToAllocate = buildNodesToAllocate(
                unassignedShard.index(),
                return AllocateUnassignedDecision.no(  
        DiscoveryNode node = null;
 * Modifications Copyright OpenSearch Contributors. See
            // taking place on the node currently, ignore it for now
            }
        }
 * valid copies of the unassigned primaries.  It does this by iterating over all unassigned
 * <p>  
            unassignedShard,
        List<NodeGatewayStartedShard> nodeShardStates = new ArrayList<>();  
                logger.debug(
     * by the allocator for allocating to the node that holds the shard copy.
import org.opensearch.cluster.routing.RecoverySource;
        final Logger logger
    private static ShardStoreInfo shardStoreInfo(NodeGatewayStartedShard nodeShardState, Set<String> inSyncAllocationIds) {
    private static List<NodeGatewayStartedShard> adaptToNodeStartedShardList(FetchResult<NodeGatewayStartedShards> shardsState) {
                .filter(shardData -> discoNodes.contains(shardData.getNode()) == false)  
    /**
        }
            unassignedShard.index(),  
        final RoutingAllocation allocation,  
import java.util.List;  
    ) {
            Collections.unmodifiableList(yesNodeShards),
            // so all fetched shard data are ineligible shards
 * Note that the PrimaryShardAllocator does *not* allocate primaries on index creation
                    nodeShardsResult.allocationsFound
 * Licensed to Elasticsearch under one or more contributor  
                        );
 * ownership. Elasticsearch licenses this file to you under  
    ) {  
            return decision;
            inSyncAllocationIds,
        for (NodeGatewayStartedShard nodeShardState : nodeShardStates) {
        }
    ).reversed();
        return new NodeShardsResult(nodeShardStates, numberOfAllocationsFound);
    ) {
     * Skip doing fetchData call for a shard if recovery mode is snapshot. Also do not take decision if allocator is  
        final NodeShardsResult nodeShardsResult = buildNodeShardsResult(
        );  
 * primary shards in the routing table and fetching shard metadata from each node in the cluster
import org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus;
        // don't create a new IndexSetting object for every shard as this could cause a lot of garbage
            return AllocateUnassignedDecision.no(AllocationStatus.DECIDERS_NO, nodeResults, true);  
                );
public abstract class PrimaryShardAllocator extends BaseGatewayShardAllocator {
        }
            this.decision = decision;  
    /**
/*
            ).reversed();
                final NodeGatewayStartedShard nodeShardState = decidedNode.nodeShardState;  
                Stream.of(nodesToAllocate.yesNodeShards, nodesToAllocate.throttleNodeShards, nodesToAllocate.noNodeShards)
            this.noNodeShards = noNodeShards;
            nodeShardStates.add(
                nodesToAllocate.throttleNodeShards
import org.opensearch.cluster.routing.RoutingNodes;
            logger.debug(  
                        nodeShardState.storeException()  
     * @return allocation decision taken for this shard
    private static final Comparator<NodeGatewayStartedShard> HIGHEST_REPLICATION_CHECKPOINT_FIRST_COMPARATOR = Comparator.comparing(  
            ineligibleShards = fetchedShardData.stream()
import org.opensearch.gateway.AsyncShardFetch.FetchResult;  
                logger.debug(  
                            nodeShardState.getNode(),  
                unassignedShard,
                nodeDecisions = buildDecisionsForAllNodes(unassignedShard, allocation);
        }
                nodeShardStates.stream().map(s -> s.getNode().getName()).collect(Collectors.joining(", "))
         */
            return AllocateUnassignedDecision.no(AllocationStatus.FETCHING_SHARD_DATA, nodeDecisions);  
        final boolean snapshotRestore = unassignedShard.recoverySource().getType() == RecoverySource.Type.SNAPSHOT;  
import org.opensearch.cluster.metadata.IndexMetadata;  
            throttled = true;
            }
            logger.trace(
    ) {
 *  
                    unassignedShard,  
        Collection<NodeGatewayStartedShard> ineligibleShards = new ArrayList<>();
            false
                    nodeGatewayStartedShard.getGatewayShardStarted().primary(),
                );
            this.allocationsFound = allocationsFound;
    }  
        Set<String> inSyncAllocationIds
 */
                new NodeGatewayStartedShard(
        Logger logger  
 * executes the allocation deciders to chose a copy to assign the primary shard to.
     *
                        () -> new ParameterizedMessage(
 * GitHub history for details.
    protected boolean isResponsibleFor(final ShardRouting shard) {  
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
 * specific language governing permissions and limitations
            } else {
     */
import java.util.stream.Collectors;
import org.opensearch.cluster.routing.allocation.decider.Decision;  
        }
            Collections.unmodifiableList(noNodeShards)
        if (decision != null) {
        Comparator.nullsLast(Comparator.naturalOrder())
        final boolean explain = allocation.debugDecision();
            return AllocateUnassignedDecision.throttle(nodeResults);
                    unassignedShard.index(),
                            shard,
        nodeResults.addAll(
            // only handle either an existing store or a snapshot recovery  
                .thenComparing(HIGHEST_REPLICATION_CHECKPOINT_FIRST_COMPARATOR);
            }  
        final boolean inSync = nodeShardState.allocationId() != null && inSyncAllocationIds.contains(nodeShardState.allocationId());
        // on cluster restart if we allocate a boat load of shards  
