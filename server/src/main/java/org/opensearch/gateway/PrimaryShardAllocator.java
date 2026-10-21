    /**
     * This class encapsulates the result of a call to {@link #buildNodesToAllocate}
            nodesToAllocate = buildNodesToAllocate(allocation, nodeShardsResult.orderedAllocationCandidates, unassignedShard, true);
                );
                );
    }
            "[{}][{}]: found {} allocation candidates of {} based on allocation ids: [{}]",
import org.opensearch.cluster.node.DiscoveryNode;
            }
            } else if (decision.type() == Type.NO) {
                logger.debug(
                    unassignedShard.index(),
     */
 * this work for additional information regarding copyright
                            finalAllocationId
    }
                unassignedShard.index(),
                logger.debug(
        if (decision != null) {
 *    http://www.apache.org/licenses/LICENSE-2.0
                    nodeShardsResult.allocationsFound
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
import org.apache.logging.log4j.message.ParameterizedMessage;
                    unassignedShard.index(),
                            dnode.decision
                    allocationId = null;
            shardState,
 * primary shards in the routing table and fetching shard metadata from each node in the cluster
 * Unless required by applicable law or agreed to in writing,
    static class NodeShardsResult {
import org.apache.logging.log4j.Logger;
            final Set<DiscoveryNode> discoNodes = new HashSet<>();
        }
            allocation.setHasPendingAsyncFetch();
                    logger.trace("[{}] on node [{}] has allocation id [{}]", shard, nodeShardState.getNode(), allocationId);
    /**
            // there were no shard copies that were eligible for being assigned the allocation,
        } else if (throttled) {
 * The OpenSearch Contributors require contributions made to
     * This class encapsulates the result of a call to {@link #buildNodeShardsResult}
 * that holds a copy of the shard.  The shard metadata from each node is compared against the
 * You may obtain a copy of the License at
                    .map(dnode -> {
                logger.debug(
                    unassignedShard.id(),
            ineligibleShards.stream()
        } else {
        if (enoughAllocationsFound == false) {
            && (shard.recoverySource().getType() == RecoverySource.Type.EXISTING_STORE
        return null;
        AllocateUnassignedDecision decision = getInEligibleShardDecision(unassignedShard, allocation);
            List<NodeAllocationResult> nodeDecisions = null;
            && allocation.snapshotShardSizeInfo().getShardSize(unassignedShard) == null) {
        boolean throttled = false;
        final List<NodeGatewayStartedShard> orderedAllocationCandidates;
        }
 */
import org.opensearch.gateway.AsyncShardFetch.FetchResult;
        } else if (node != null) {
                : allocation.deciders().canAllocate(shardRouting, node, allocation);
        final Decision decision;
    /**
        ShardRouting shardRouting,
            RoutingNode node = allocation.routingNodes().node(nodeShardState.getNode().getId());
                    unassignedShard.recoverySource()
            }
                }
import org.opensearch.cluster.routing.UnassignedInfo;
         * Orders the active shards copies based on below comparators
                    explain ? buildNodeDecisions(null, shardState, inSyncAllocationIds) : null
                    unassignedShard.id(),
            throttled = true;
        Collection<NodeGatewayStartedShard> ineligibleShards = new ArrayList<>();
 * not use this file except in compliance with the License.
        final boolean snapshotRestore = unassignedShard.recoverySource().getType() == RecoverySource.Type.SNAPSHOT;
        );
            nodeResults = buildNodeDecisions(nodesToAllocate, shardState, inSyncAllocationIds);
        }
}
            return null;
    }
    ).reversed();
        if (unassignedShard.recoverySource().getType() == RecoverySource.Type.SNAPSHOT
            // taking place on the node currently, ignore it for now
        final Exception storeErr = nodeShardState.storeException();
     */
                continue;
                        () -> new ParameterizedMessage(
        List<NodeGatewayStartedShard> nodeShardStates = new ArrayList<>();
     * This class encapsulates the shard state retrieved from a node and the decision that was made
 * under the License.
        Set<String> ignoreNodes,
            unassignedShard.index(),
import org.opensearch.cluster.routing.RoutingNode;
    ) {
                if (matchAnyShard || inSyncAllocationIds.contains(nodeShardState.allocationId())) {
                    "[{}][{}]: throttling allocation [{}] to [{}] on forced primary allocation",
        if (shardState == null) {
        // on cluster restart if we allocate a boat load of shards
        NodeGatewayStartedShard::replicationCheckpoint,
        for (NodeGatewayStartedShard nodeShardState : nodeShardStates) {
            }
                    .flatMap(Collection::stream)
                allocationId = nodeShardState.allocationId();
            if (nodeShardState.storeException() == null) {
        boolean forceAllocate
import org.opensearch.cluster.routing.ShardRouting;
        int numberOfAllocationsFound = 0;
            this.orderedAllocationCandidates = orderedAllocationCandidates;
                return AllocateUnassignedDecision.NOT_TAKEN;
        final boolean enoughAllocationsFound = nodeShardsResult.orderedAllocationCandidates.size() > 0;
    }
                    nodesToAllocate.throttleNodeShards
    }
 * compatible open source license.
            // prefer shards with matching allocation ids
        if (matchAnyShard) {
        List<NodeGatewayStartedShard> nodeShardStates,
        ShardRouting unassignedShard,
                    logger.trace(
            );
        List<DecidedNode> throttledNodeShards = new ArrayList<>();
                    "[{}][{}]: allocating [{}] to [{}] on forced primary allocation",
        if (nodesToAllocate.yesNodeShards.isEmpty() == false) {
        /**
        }
     */
 * SPDX-License-Identifier: Apache-2.0
            }
    protected boolean isResponsibleFor(final ShardRouting shard) {
        List<DecidedNode> noNodeShards = new ArrayList<>();
    protected abstract FetchResult<NodeGatewayStartedShards> fetchData(ShardRouting shard, RoutingAllocation allocation);
    private static List<NodeAllocationResult> buildNodeDecisions(
    }
        List<NodeGatewayStartedShard> shardState,
                    unassignedShard,
 * set of valid allocation IDs and for all valid shard copies (if any), the primary shard allocator
                // We could just be waiting for the node that holds the primary to start back up, in which case the allocation for
                "[{}][{}]: throttling allocation [{}] to [{}] on primary allocation",
        return new NodesToAllocate(
            }
     * inSyncAllocationIds are added to the list. Otherwise, any node that has a shard is added to the list, but
                .filter(shardData -> discoNodes.contains(shardData.getNode()) == false)
    }
            Collections.unmodifiableList(throttledNodeShards),
                || shard.recoverySource().getType() == RecoverySource.Type.SNAPSHOT);
import org.opensearch.cluster.routing.RecoverySource;
            } else {
        List<NodeGatewayStartedShard> nodeShardStates = new ArrayList<>();
            logger.trace(
            }
                    : "only allow store that can be opened or that throws a ShardLockObtainFailedException while being opened but got a "
    ).reversed();
                );
         * 3. Prefer shard copy with the highest replication checkpoint. It is NO-OP for doc rep enabled indices.
 * Note that the PrimaryShardAllocator does *not* allocate primaries on index creation
        );
 * nor does it allocate primaries when a primary shard failed and there is a valid replica
     * Builds a map of nodes to the corresponding allocation decisions for those nodes.
                );
                // let BalancedShardsAllocator take care of allocating this shard
            if (allocationId != null) {
            );
import org.opensearch.cluster.routing.allocation.decider.Decision;
 * license agreements. See the NOTICE file distributed with
        // don't create a new IndexSetting object for every shard as this could cause a lot of garbage
                                + "opened as it's locked, treating as valid shard",
        boolean matchAnyShard,
            }
            logger
    ) {
import org.opensearch.cluster.routing.allocation.decider.Decision.Type;
        RoutingAllocation allocation,
            if (decision.type() == Type.THROTTLE) {
import org.opensearch.cluster.routing.allocation.NodeAllocationResult;
                .collect(Collectors.toList())
                    logger.trace("[{}] on node [{}] has no shard state information", shard, nodeShardState.getNode());
                assert nodeShardState.storeException() == null || nodeShardState.storeException() instanceof ShardLockObtainFailedException
                unassignedShard.index(),
     * not responsible for this particular shard.
                        + "store throwing "
                final NodeGatewayStartedShard nodeShardState = decidedNode.nodeShardState;
                    nodeGatewayStartedShard.getGatewayShardStarted().replicationCheckpoint(),
        if (isResponsibleFor(unassignedShard) == false) {
            String allocationId = nodeShardState.allocationId();
import org.opensearch.gateway.TransportNodesListGatewayStartedShards.NodeGatewayStartedShards;
        if (nodesToAllocate != null) {
import org.opensearch.cluster.metadata.IndexMetadata;
                noNodeShards.add(decidedNode);
    /**
                        return new NodeAllocationResult(
                            nodeShardState.getNode(),
        final Set<String> inSyncAllocationIds = indexMetadata.inSyncAllocationIds(unassignedShard.id());
 * ownership. Elasticsearch licenses this file to you under
                // this shard will be picked up when the node joins and we do another allocation reroute
 * executes the allocation deciders to chose a copy to assign the primary shard to.
    ) {
    /**
            this.nodeShardState = nodeShardState;
        return new ShardStoreInfo(nodeShardState.allocationId(), inSync, storeErr);
            logger.debug(
        assert inSyncAllocationIds.isEmpty() == false;
                        () -> new ParameterizedMessage(
 * this file be licensed under the Apache-2.0 license or a
            if (ignoreNodes.contains(node.getId())) {
            this.noNodeShards = noNodeShards;
import java.util.List;
        final int allocationsFound;
                    "[{}][{}]: not allocating, number_of_allocated_shards_found [{}]",
    }
                    "[{}][{}]: forced primary allocation denied [{}]",
                    unassignedShard.index(),
        return nodeResults;
                            finalAllocationId
                nodesToAllocate.throttleNodeShards
                Stream.of(nodesToAllocate.yesNodeShards, nodesToAllocate.throttleNodeShards, nodesToAllocate.noNodeShards)
 * (see {@link org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator}),
                logger.debug(
        final boolean inSync = nodeShardState.allocationId() != null && inSyncAllocationIds.contains(nodeShardState.allocationId());
        NodeGatewayStartedShard::primary
    }
            this.throttleNodeShards = throttleNodeShards;
                    );
            List<NodeAllocationResult> nodeDecisions = null;
        );
                // We have a shard that was previously allocated, but we could not find a valid shard copy to allocate the primary.
                final String finalAllocationId = allocationId;
                unassignedShard.id(),
                "{} candidates for allocation: {}",
        }
            } else {
        NodesToAllocate(List<DecidedNode> yesNodeShards, List<DecidedNode> throttleNodeShards, List<DecidedNode> noNodeShards) {
/*
import java.util.Collection;
            inSyncAllocationIds
            allocationId = decidedNode.nodeShardState.allocationId();
     */
    private static final Comparator<NodeGatewayStartedShard> HIGHEST_REPLICATION_CHECKPOINT_FIRST_COMPARATOR = Comparator.comparing(
                    logger.trace(
        } else {
            unassignedShard,
                if (allocationId == null) {
                unassignedShard,
                }
 * @opensearch.internal
                    unassignedShard.id(),
            // so all fetched shard data are ineligible shards
                    node
                } else {
            Decision decision = forceAllocate
    }
                node = nodeShardState.getNode();
                "[{}][{}]: allocating [{}] to [{}] on primary allocation",
                        discoNodes.add(dnode.nodeShardState.getNode());
 * specific language governing permissions and limitations
     * by the allocator for allocating to the node that holds the shard copy.
        }
 * <p>
                continue;
import java.util.Set;
        final RoutingAllocation allocation,
        if (explain) {
            return decision;
            return AllocateUnassignedDecision.no(UnassignedInfo.AllocationStatus.FETCHING_SHARD_DATA, nodeDecisions);
                final DecidedNode decidedNode = nodesToAllocate.yesNodeShards.get(0);
            allocation.getIgnoreNodes(unassignedShard.shardId()),
                );
                throttledNodeShards.add(decidedNode);
                    nodeShardStates.add(nodeShardState);
            comparator = NO_STORE_EXCEPTION_FIRST_COMPARATOR.thenComparing(PRIMARY_FIRST_COMPARATOR)
import org.opensearch.gateway.TransportNodesGatewayStartedShardHelper.NodeGatewayStartedShard;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        if (allocation.hasPendingAsyncFetch()) {
    private static final Comparator<NodeGatewayStartedShard> NO_STORE_EXCEPTION_FIRST_COMPARATOR = Comparator.comparing(
                        ),
     * Skip doing fetchData call for a shard if recovery mode is snapshot. Also do not take decision if allocator is
    * Returns null if {@link FetchResult} does not have any data.
            return AllocateUnassignedDecision.NOT_TAKEN;
        final Comparator<NodeGatewayStartedShard> comparator; // allocation preference
    ) {
                .collect(Collectors.toList());
                    unassignedShard.index(),
        final NodeGatewayStartedShard nodeShardState;
        List<NodeAllocationResult> nodeResults = null;
                    unassignedShard.index(),
            DecidedNode decidedNode = new DecidedNode(nodeShardState, decision);
        }
        return comparator;
            nodeShardsResult.orderedAllocationCandidates,
 *
        final List<DecidedNode> yesNodeShards;
                    unassignedShard
    private static Comparator<NodeGatewayStartedShard> createActiveShardComparator(boolean matchAnyShard, Set<String> inSyncAllocationIds) {
            Comparator<NodeGatewayStartedShard> matchingAllocationsFirst = Comparator.comparing(
        Logger logger
    }
     *
     * @return allocation decision taken for this shard
                unassignedShard.id(),
                    unassignedShard,
        List<NodeGatewayStartedShard> fetchedShardData,
        private DecidedNode(NodeGatewayStartedShard nodeShardState, Decision decision) {
            if (explain) {
                yesNodeShards.add(decidedNode);
            this.decision = decision;
        String allocationId = null;
                unassignedShard,
import java.util.stream.Collectors;
        final NodeShardsResult nodeShardsResult = buildNodeShardsResult(
                numberOfAllocationsFound++;
            logger.debug(
            // we are throttling this, since we are allowed to allocate to this node but there are enough allocations
            ineligibleShards = fetchedShardData.stream()
                ? allocation.deciders().canForceAllocatePrimary(shardRouting, node, allocation)
        );
     */
            ineligibleShards = fetchedShardData;
        final boolean explain = allocation.debugDecision();
            snapshotRestore,
     * Builds a list of nodes. If matchAnyShard is set to false, only nodes that have an allocation id matching
        return shard.primary() // must be primary
                );
            return AllocateUnassignedDecision.yes(node, allocationId, nodeResults, false);
                        );
    /**
                    nodeGatewayStartedShard.getGatewayShardStarted().primary(),
    protected static class NodesToAllocate {
     * @param unassignedShard unassigned shard routing
 */
        } else if (nodesToAllocate.throttleNodeShards.isEmpty() && !nodesToAllocate.noNodeShards.isEmpty()) {
 * KIND, either express or implied.  See the License for the
        }
        RoutingAllocation allocation,
                decidedNode.nodeShardState.getNode()
        if (!shardsState.hasData()) {
     * Split the list of node shard states into groups yes/no/throttle based on allocation deciders
        final List<DecidedNode> throttleNodeShards;
            }
    protected AllocateUnassignedDecision getAllocationDecision(
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;
 *
        DiscoveryNode node = null;
    private static class DecidedNode {
import org.opensearch.env.ShardLockObtainFailedException;
         * 1. No store exception i.e. shard copy is readable
        );
import java.util.ArrayList;
                }
import java.util.Comparator;
        // use in-sync allocation ids to select nodes
                    nodeGatewayStartedShard.getGatewayShardStarted().allocationId(),
    @Override
        NodesToAllocate nodesToAllocate,
 * Modifications Copyright OpenSearch Contributors. See
    public AllocateUnassignedDecision makeAllocationDecision(
                throttled = true;
package org.opensearch.gateway;
        final List<DecidedNode> noNodeShards;
                return AllocateUnassignedDecision.no(
        if (logger.isTraceEnabled()) {
 * software distributed under the License is distributed on an
        Logger logger
            unassignedShard,
     * @param allocation      routing allocation object
                    AllocationStatus.NO_VALID_SHARD_COPY,
        (NodeGatewayStartedShard state) -> state.storeException() == null
        }
                            dnode.nodeShardState.getNode(),
     */
            // only handle either an existing store or a snapshot recovery
                    nodeGatewayStartedShard.getGatewayShardStarted().storeException(),
        }
        final boolean explain = allocation.debugDecision();
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor
            inSyncAllocationIds,
            return AllocateUnassignedDecision.throttle(nodeResults);
                nodeShardStates.stream().map(s -> s.getNode().getName()).collect(Collectors.joining(", "))
                    .collect(Collectors.toList())
 */
                    unassignedShard.id(),
                } else {
    private static ShardStoreInfo shardStoreInfo(NodeGatewayStartedShard nodeShardState, Set<String> inSyncAllocationIds) {
        return nodeShardStates;
                )
        ShardRouting shard,
        return getAllocationDecision(unassignedShard, allocation, nodeShardStates, logger);
import org.opensearch.cluster.routing.allocation.NodeAllocationResult.ShardStoreInfo;
                        ),
public abstract class PrimaryShardAllocator extends BaseGatewayShardAllocator {
            && shard.unassigned() // must be unassigned
    /**
                    nodeShardState.getNode()
        shardsState.getData().forEach((node, nodeGatewayStartedShard) -> {
/*
                if (nodeShardState.storeException() instanceof ShardLockObtainFailedException) {
        NodeShardsResult(List<NodeGatewayStartedShard> orderedAllocationCandidates, int allocationsFound) {
                    })
/**
        } else {
    private static final Comparator<NodeGatewayStartedShard> PRIMARY_FIRST_COMPARATOR = Comparator.comparing(
    */
        return new NodeShardsResult(nodeShardStates, numberOfAllocationsFound);
            nodeShardsResult.orderedAllocationCandidates.size(),
import org.opensearch.cluster.routing.RoutingNodes;
            return AllocateUnassignedDecision.no(AllocationStatus.DECIDERS_NO, nodeResults, true);
            Collections.unmodifiableList(noNodeShards)
                            nodeShardState.getNode(),
    }
            if (explain) {
            );
            // this allocator is not responsible for allocating this shard
                .thenComparing(PRIMARY_FIRST_COMPARATOR)
                logger.debug(
                            shardStoreInfo(dnode.nodeShardState, inSyncAllocationIds),
            ).reversed();
            DecidedNode decidedNode = nodesToAllocate.yesNodeShards.get(0);
                .thenComparing(HIGHEST_REPLICATION_CHECKPOINT_FIRST_COMPARATOR);
     */
        List<NodeGatewayStartedShard> nodeShardStates = adaptToNodeStartedShardList(shardState);
        }
            nodeResults.addAll(
            // can be force-allocated to one of the nodes.
 * valid copies of the unassigned primaries.  It does this by iterating over all unassigned
        List<DecidedNode> yesNodeShards = new ArrayList<>();
                        + nodeShardState.storeException();
            );
            this.yesNodeShards = yesNodeShards;
     * entries with matching allocation id are always at the front of the list.
            } else {
         */
import java.util.Collections;
 *
            } else if (nodesToAllocate.throttleNodeShards.isEmpty() == false) {
        nodeResults.addAll(
                new NodeGatewayStartedShard(
     */
    * Transforms {@link FetchResult} of {@link NodeGatewayStartedShards} to {@link List} of {@link NodeGatewayStartedShard}
    private static NodesToAllocate buildNodesToAllocate(
                    unassignedShard.id(),
import org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus;
                        nodeShardState.storeException()
            return AllocateUnassignedDecision.no(AllocationStatus.FETCHING_SHARD_DATA, nodeDecisions);
        NodesToAllocate nodesToAllocate = buildNodesToAllocate(
        }
                nodeDecisions = buildDecisionsForAllNodes(unassignedShard, allocation);
            node = decidedNode.nodeShardState.getNode();
 */
        final ShardRouting unassignedShard,
            nodeShardStates.add(
    private static List<NodeGatewayStartedShard> adaptToNodeStartedShardList(FetchResult<NodeGatewayStartedShards> shardsState) {
        List<NodeAllocationResult> nodeResults = new ArrayList<>();
    ) {
            if (snapshotRestore) {
        }
     * Is the allocator responsible for allocating the given {@link ShardRouting}?
    }
                    "[{}][{}]: missing local data, will restore from [{}]",
        Set<String> inSyncAllocationIds
                .thenComparing(HIGHEST_REPLICATION_CHECKPOINT_FIRST_COMPARATOR);
        }
    protected static NodeShardsResult buildNodeShardsResult(
                .map(shardData -> new NodeAllocationResult(shardData.getNode(), shardStoreInfo(shardData, inSyncAllocationIds), null))
        } else {
            unassignedShard.id(),
/*
        for (NodeGatewayStartedShard nodeShardState : shardState) {
 * GitHub history for details.
        Comparator.nullsLast(Comparator.naturalOrder())
            );
                            "[{}] on node [{}] has allocation id [{}] but the store can not be "
                    );
        final Logger logger
        });
        logger.debug(
import java.util.stream.Stream;
            comparator = matchingAllocationsFirst.thenComparing(NO_STORE_EXCEPTION_FIRST_COMPARATOR)
                        nodeShardState.storeException()
        List<NodeGatewayStartedShard> shardState,
            false
                            shard,
                shard,
            if (nodesToAllocate.yesNodeShards.isEmpty() == false) {
         * 2. Prefer previous primary shard
            return AllocateUnassignedDecision.no(AllocationStatus.FETCHING_SHARD_DATA, nodeResults);
        }
    /**
                nodeDecisions = buildDecisionsForAllNodes(unassignedShard, allocation);
    /**
        final IndexMetadata indexMetadata = allocation.metadata().getIndexSafe(unassignedShard.index());
            if (node == null) {
            this.allocationsFound = allocationsFound;
            allocation,
            Collections.unmodifiableList(yesNodeShards),
import java.util.HashSet;
 * The primary shard allocator allocates unassigned primary shards to nodes that hold
                            shard,
        Set<String> inSyncAllocationIds,
    );
            DiscoveryNode node = nodeShardState.getNode();
            } else {
    protected AllocateUnassignedDecision getInEligibleShardDecision(ShardRouting unassignedShard, RoutingAllocation allocation) {
                (NodeGatewayStartedShard state) -> inSyncAllocationIds.contains(state.allocationId())
        }
        final FetchResult<NodeGatewayStartedShards> shardState = fetchData(unassignedShard, allocation);
 *
        nodeShardStates.sort(createActiveShardComparator(matchAnyShard, inSyncAllocationIds));
                            "[{}] on node [{}] has allocation id [{}] but the store can not be " + "opened, treating as no allocation id",
        }
            }
            unassignedShard,
            // The deciders returned a NO decision for all nodes with shard copies, so we check if primary shard
 * copy that can immediately be promoted to primary, as this takes place in {@link RoutingNodes#failShard}.
