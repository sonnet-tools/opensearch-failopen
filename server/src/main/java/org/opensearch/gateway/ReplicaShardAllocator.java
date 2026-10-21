            RoutingNode node = allocation.routingNodes().node(cursor.getId());
import java.util.Map;
                Decision decision = allocation.deciders().canAllocate(unassignedShard, node, allocation);
                ShardStoreInfo shardStoreInfo = new ShardStoreInfo(matchingNode.matchingBytes);
            return null;
    protected Runnable cancelExistingRecoveryForBetterMatch(
        if (nodeShardStores == null) {
                assert explain : "primary should only be null here if we are in explain mode, so we didn't "
    }
 * ownership. Elasticsearch licenses this file to you under
                remainingDelayMillis = TimeValue.timeValueNanos(remainingDelayNanos).millis();
            } else {
        StoreFilesMetadata replicaStore
            }
     */
        if (primaryStore == null) {
import org.opensearch.cluster.routing.allocation.NodeAllocationResult;
            false,
 * GitHub history for details.
        List<NodeAllocationResult> nodeDecisions = augmentExplanationsWithStoreInfo(allocationDecision.v2(), matchingNodes.nodeDecisions);
                // For non-search-only replicas, if there is no active primary we do not attempt an allocation.
    ) {
            .thenComparing(m -> m.retainingSeqNo)
        boolean anyMatch() {
        }
            return null;
            this.nodeWithHighestMatch = matchingNodes.entrySet()
        ShardRouting unassignedShard,
    }
    private static List<NodeAllocationResult> augmentExplanationsWithStoreInfo(
        return sizeMatched;
            Decision decision = allocation.deciders().canAllocate(unassignedShard, nodeWithHighestMatch, allocation);
    ) {
                    allocation.clusterSettings()
public abstract class ReplicaShardAllocator extends BaseGatewayShardAllocator {
        }
    public AllocateUnassignedDecision makeAllocationDecision(
     * node decided YES, THROTTLE if at least one node decided THROTTLE, and NO if none of the nodes decided
    private static MatchingNode computeMatchingNode(
        final long retainingSeqNoForReplica = primaryStore.getPeerRecoveryRetentionLeaseRetainingSeqNo(replicaNode);
            .findFirst()
                // we found a better match that can perform noop recovery, cancel the existing allocation.
    /**
        ShardRouting shard,
        final ShardRouting unassignedShard,
        return augmented;
        MatchingNodes(Map<DiscoveryNode, MatchingNode> matchingNodes, @Nullable Map<String, NodeAllocationResult> nodeDecisions) {
import java.util.Comparator;
        StoreFilesMetadata primaryStore,
        ShardRouting primaryShard = allocation.routingNodes().activePrimary(shard.shardId());
                }
import org.opensearch.index.store.StoreFileMetadata;
                IndexMetadata indexMetadata = metadata.index(unassignedShard.index());
    }
            .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().storeFilesMetadata()));
    /**
import java.util.ArrayList;
import org.opensearch.cluster.routing.UnassignedInfo;
/**
    private AllocateUnassignedDecision getSearchReplicaAllocationDecision(ShardRouting unassignedShard, RoutingAllocation allocation) {
            // if we can't allocate it on a node, ignore it, for example, this handles
        /**
        if (nodeShardStores == null) {
                    false,
        if (!data.containsKey(node)) {
            && shard.unassigned() // must be unassigned
            this.nodeDecisions = nodeDecisions;
        DiscoveryNode primaryNode,
    /**
        final DiscoveryNode primaryNode = allocation.nodes().get(primaryShard.currentNodeId());
            primaryStore,
                }
        final boolean isNoopRecovery = (retainingSeqNoForReplica >= retainingSeqNoForPrimary && retainingSeqNoForPrimary >= 0)
                    return Tuple.tuple(decision, null);
                    .getMillis();
        return AllocateUnassignedDecision.delayed(0L, 0L, null);
        assert explain == false || matchingNodes.nodeDecisions != null : "in explain mode, we must have individual node decisions";
        if (targetNodeStore == null || targetNodeStore.isEmpty()) {
}
import org.opensearch.cluster.routing.allocation.NodeAllocationResult.ShardStoreInfo;
        RoutingAllocation allocation
        return null;
                    logger,
        // If a candidate was found, return a YES allocation decision
            return AllocateUnassignedDecision.NOT_TAKEN;
        @Nullable
        final long retainingSeqNo;
            return false;
                    logger.trace(
        if (primaryShard == null) {
        final RoutingAllocation allocation,
 * KIND, either express or implied.  See the License for the
            // if we didn't manage to find *any* data (regardless of matching sizes), and the replica is
                );
            }
        final StoreFilesMetadata primaryStore = findStore(primaryNode, nodeShardStores);
                    nodeWithHighestMatch
     */
            }
            // unassigned due to a node leaving, so we delay allocation of this replica to see if the
 * The OpenSearch Contributors require contributions made to
    }
                );
            .filter(candidate -> {
                    "[{}][{}]: throttling allocation [{}] to [{}] in order to reuse its unallocated persistent store",
            // then we will try and assign it next time
import org.opensearch.indices.store.TransportNodesListShardStoreMetadataHelper.StoreFilesMetadata;
package org.opensearch.gateway;
            && (allocation.debugDecision() == false || hasInitiatedFetching(unassignedShard) == false)) {
        if (shard.initializing() == false) {
                matchingNode = computeMatchingNode(primaryNode, primaryStore, discoNode, storeFilesMetadata);
     * Takes the store info for nodes that have a shard store and adds them to the node decisions,
        final long retainingSeqNoForPrimary = primaryStore.getPeerRecoveryRetentionLeaseRetainingSeqNo(primaryNode);
                if (matchingNode.isNoopRecovery) {
 * not use this file except in compliance with the License.
            DiscoveryNode discoNode = nodeStoreEntry.getKey();
            return AllocateUnassignedDecision.no(AllocationStatus.FETCHING_SHARD_DATA, nodeDecisions);
 *
        Map<DiscoveryNode, StoreFilesMetadata> nodeShardStores,
        return shard.primary() == false // must be a replica
 * specific language governing permissions and limitations
            }
        ShardRouting primaryShard = routingNodes.activePrimary(unassignedShard.shardId());
            );
        boolean canPerformNoopRecovery(DiscoveryNode node) {
                    new ArrayList<>(allocationDecision.v2().values())
        }
                } else {
            }
                && matchingNodes.canPerformNoopRecovery(nodeWithHighestMatch)
        assert primaryShard.currentNodeId() != null;
import java.util.stream.Collectors;
                boolean isSearchOnlyClusterBlockEnabled = allocation.metadata()
                .orElse(null);
                    logger.trace("{}: node [{}] can perform a noop recovery", shard, discoNode.getName());
            return matchingNodes.isEmpty() == false;
            for (ShardRouting shard : routingNode) {
     * A class to enacapsulate the details regarding the a MatchNode for shard assignment
            this.isNoopRecovery = isNoopRecovery;
            // only return early if we are not in explain mode, or we are in explain mode but we have not
                    : shard.unassignedInfo().getFailedNodeIds();
                    nodeWithHighestMatch.node()
        }
                } else if (matchingNode.retainingSeqNo >= 0) {
        RoutingAllocation allocation,
        Map<String, NodeAllocationResult> nodeDecisions = explain ? new HashMap<>() : null;
        }
                .filter(e -> e.getValue().anyMatch())
                );
                    logger.trace(
     * leaving the node explanations untouched for those nodes that do not have any store information.
            final MatchingNode matchingNode = matchingNodes.get(node);
            if (withShardStores.containsKey(entry.getKey())) {
                UnassignedInfo unassignedInfo = unassignedShard.unassignedInfo();
                    UnassignedInfo.AllocationStatus.NO_ATTEMPT,
                    .getAsBoolean(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false);
            // we only check for NO, since if this node is THROTTLING and it has enough "same data"
import org.opensearch.indices.store.TransportNodesListShardStoreMetadata.NodeStoreFilesMetadata;
                totalDelayMillis = UnassignedInfo.getNodeLeftDelayedTimeout(indexMetadata.getSettings(), allocation.clusterSettings())
                        + "] cancelled, can perform a noop recovery on ["
        public boolean hasAnyData() {
    ) {
                    ? Collections.emptySet()
            // we don't have any files at all, it is an empty index
                    0,
     * Handles allocation decisions for search-only replica shards
                        shard,
            primaryNode,
        } else if (matchingNodes.hasAnyData() == false && unassignedShard.unassignedInfo().isDelayed()) {
import org.opensearch.common.unit.TimeValue;
 */
 *
            explain
                );
                    UnassignedInfo.Reason.REALLOCATED_REPLICA,
                .max(Comparator.comparing(Map.Entry::getValue, MatchingNode.COMPARATOR))
        RoutingAllocation allocation,
     * match. Today, a better match is one that can perform a no-op recovery while the previous recovery
            })
        }
    ) {
    }
            return null;
        return new MatchingNodes(matchingNodes, nodeDecisions);
            }
            }
            );
import org.opensearch.cluster.metadata.IndexMetadata;
        // Use a stream to find the first candidate node where the allocation decider returns YES
        if (allocationDecision.v1().type() != Decision.Type.YES) {
                    );
            logger.trace("{}: ignoring allocation, still fetching shard stores", unassignedShard);
            if (decision.type() == Decision.Type.YES && madeDecision.type() != Decision.Type.YES) {
        DiscoveryNode replicaNode,
            return true;
                nodeDecisions.put(node.nodeId(), new NodeAllocationResult(discoNode, shardStoreInfo, decision));
         */
                continue;
            } else {
                    unassignedShard.id(),
            }
        }
    protected static class MatchingNode {
    private static StoreFilesMetadata findStore(DiscoveryNode node, Map<DiscoveryNode, StoreFilesMetadata> data) {
        if (matchingNodes.getNodeWithHighestMatch() != null) {
        if (shard.unassignedInfo() != null && shard.unassignedInfo().getReason() == UnassignedInfo.Reason.INDEX_CREATED) {
    /**
            return true;
 * under the License.
     * Finds the store for the assigned shard in the fetched data, returns null if none is found.
                    unassignedShard,
                        shard,
            }
     * <p>
            if (explain) {
        return false;
 * @opensearch.internal
            return AllocateUnassignedDecision.no(
import org.opensearch.common.collect.Tuple;
                    .getIndexSafe(unassignedShard.index())
import org.opensearch.cluster.node.DiscoveryNode;
            if (matchingNode == null) {
                    indexMetadata.getSettings(),
        for (StoreFileMetadata storeFileMetadata : storeFilesMetadata) {
            return AllocateUnassignedDecision.delayed(remainingDelayMillis, totalDelayMillis, nodeDecisions);
            action.run();
                    .getSettings()
        final StoreFilesMetadata primaryStore = findStore(primaryNode, nodeShardStores);
 * software distributed under the License is distributed on an
     */
                return AllocateUnassignedDecision.no(
        if (data.hasData() == false) {
                madeDecision = decision;
    private static boolean canPerformOperationBasedRecovery(
                }
         * the primary.
            }
            this.matchingBytes = matchingBytes;
        }
            return AllocateUnassignedDecision.no(
    ) {
        private final DiscoveryNode nodeWithHighestMatch;
        for (final DiscoveryNode cursor : allocation.nodes().getDataNodes().values()) {
            // if we can't find the primary data, it is probably because the primary shard is corrupted (and listing failed)
                );
 *
    }
import org.opensearch.cluster.routing.ShardRouting;
                        new ByteSizeValue(matchingNode.matchingBytes),
 */
        Map<DiscoveryNode, StoreFilesMetadata> nodeShardStores = convertToNodeStoreFilesMetadataMap(shardStores);
            if (primaryStore.fileExists(metadataFileName) && primaryStore.file(metadataFileName).isSame(storeFileMetadata)) {
    }
                    shardCancellationActions.add(cancellationAction);
        Map<DiscoveryNode, MatchingNode> matchingNodes = new HashMap<>();
    }
        );
                final Set<String> failedNodeIds = shard.unassignedInfo() == null
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                return () -> routingNodes.failShard(
        }
        return primarySyncId != null && primarySyncId.equals(replicaStore.syncId());
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
                } else {
                return AllocateUnassignedDecision.yes(nodeWithHighestMatch.node(), null, nodeDecisions, true);
                return AllocateUnassignedDecision.throttle(nodeDecisions);
        return data.get(node);
        }
        Logger logger
        }
            if (currentNode.equals(nodeWithHighestMatch) == false
        if (shard.primary()) {
            String metadataFileName = storeFileMetadata.name();
            DiscoveryNode currentNode = allocation.nodes().get(shard.currentNodeId());
        DiscoveryNode primaryNode,
            // Determine if the index is configured for search-only.
 * this file be licensed under the Apache-2.0 license or a
import java.util.Collections;
        return AllocateUnassignedDecision.NOT_TAKEN;
            .stream()
 * Modifications Copyright OpenSearch Contributors. See
            return AllocateUnassignedDecision.yes(selectedCandidate, null, new ArrayList<>(), false);
                    System.nanoTime(),
                // don't cancel shard in the loop as it will cause a ConcurrentModificationException
                && shard.unassignedInfo() != null
import org.opensearch.cluster.routing.allocation.decider.Decision;
 * this work for additional information regarding copyright
            Decision decision = allocation.deciders().canAllocate(shard, node, allocation);
        }
    ) {
                        "{}: node [{}] can perform operation-based recovery with retaining sequence number [{}]",
        Tuple<Decision, Map<String, NodeAllocationResult>> result = canBeAllocatedToAtLeastOneNode(unassignedShard, allocation);
        String primarySyncId = primaryStore.syncId();
            } else {
        }
        Map<String, NodeAllocationResult> withShardStores
    /**
        final long matchingBytes = computeMatchingBytes(primaryStore, replicaStore);
            logger.trace("{}: no primary shard store found or allocated, letting actual allocation figure it out", shard);
        public DiscoveryNode getNodeWithHighestMatch() {
            long remainingDelayMillis = 0L;
                UnassignedInfo.AllocationStatus.fromDecision(allocateDecision.type()),
        return new MatchingNode(matchingBytes, retainingSeqNoForReplica, isNoopRecovery);
        Map<DiscoveryNode, StoreFilesMetadata> nodeShardStores
        if (allocateDecision.type() != Decision.Type.YES
                    metadata.getIndexSafe(shard.index()),
            // if we are allocating a replica because of index creation, no need to go and find a copy, there isn't one...
                augmented.add(entry.getValue());
                // we found a match
    }
            nodeShardStores,
                        "{}: node [{}] has [{}/{}] bytes of re-usable data",
        }
            long totalDelayMillis = 0L;
        if (hasMatchingSyncId(primaryStore, targetNodeStore)) {
            StoreFilesMetadata storeFilesMetadata = nodeStoreEntry.getValue();
            logger.trace("{}: ignoring allocation, can't be allocated on any node", unassignedShard);
        Decision allocateDecision = result.v1();
            }
            return null;
                matchingNode = computeMatchingNode(primaryNode, primaryStore, discoNode, storeFilesMetadata);
                    return getSearchReplicaAllocationDecision(unassignedShard, allocation);
     * Process existing recoveries of replicas and see if we need to cancel them if we find a better
    protected boolean isResponsibleFor(final ShardRouting shard) {
    protected boolean shouldSkipFetchForRecovery(ShardRouting shard) {
                    unassignedShard.index(),
        if (isResponsibleFor(unassignedShard) == false) {
    public void processExistingRecoveries(RoutingAllocation allocation) {
        for (Map.Entry<String, NodeAllocationResult> entry : nodeDecisions.entrySet()) {
            }
     * Determines if the shard can be allocated on at least one node based on the allocation deciders.
            return matchingNode.isNoopRecovery;
                result.v2() != null ? new ArrayList<>(result.v2().values()) : null
     */
     * Returns the best allocation decision for allocating the shard on any node (i.e. YES if at least one
            if (decision.type() == Decision.Type.THROTTLE) {
        ShardRouting shard,
            // Note, this is the existing behavior, as exposed in running CorruptFileTest#testNoPrimaryData
            // node with the shard copy will rejoin so we can re-use the copy it has
                    );
    /**
                );
    static class MatchingNodes {
                augmented.add(withShardStores.get(entry.getKey()));
/*
                // we are throttling this, as we have enough other shards to allocate to this node, so ignore it for now
                nodeDecisions
            .thenComparing(m -> m.matchingBytes);
        Map<String, NodeAllocationResult> nodeDecisions = explain ? new HashMap<>() : null;
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        for (Map.Entry<DiscoveryNode, StoreFilesMetadata> nodeStoreEntry : data.entrySet()) {
            // if we are allocating a replica because of index creation, no need to go and find a copy, there isn't one...
                    unassignedShard.index(),
            }
                logger.debug(
                    continue;
                        matchingNode.retainingSeqNo
import org.apache.logging.log4j.Logger;
        }
            allocation,
import java.util.Set;
        assert primaryShard.currentNodeId() != null;
            return null;
import org.opensearch.common.Nullable;
        }
            }
/*
     * Is the allocator responsible for allocating the given {@link ShardRouting}?
    @Override
                    nodeWithHighestMatch.node()
        final long matchingBytes;
            Decision decision = allocation.deciders().canAllocate(shard, node, allocation);
        Map<DiscoveryNode, StoreFilesMetadata> data,
        final StoreFilesMetadata targetNodeStore = shardStores.get(targetNode);
        if (primaryShard == null) {
            if (allocation.debugDecision()) {
        }
            if (explain) {
        }
                Map<DiscoveryNode, StoreFilesMetadata> nodeShardStores = convertToNodeStoreFilesMetadataMap(shardStores);
    /**
            if (decision.type() == Decision.Type.NO) {
    }
                logger.debug(
            // we want to let the replica be allocated in order to expose the actual problem with the primary that the replica
import org.opensearch.cluster.metadata.Metadata;
        final RoutingNodes routingNodes = allocation.routingNodes();
                return decision.type() == Decision.Type.YES;
        if (nodeDecisions == null || withShardStores == null) {
import org.opensearch.core.common.unit.ByteSizeValue;
        StoreFilesMetadata primaryStore,
                    System.currentTimeMillis(),
            .entrySet()
            logger.trace("{}: no active primary shard found or allocated, letting actual allocation figure it out", shard);
                continue;
            allocation.setHasPendingAsyncFetch();
        RoutingAllocation allocation,
        for (Runnable action : shardCancellationActions) {
            if (node == null) {
            // node shard stores is null when we don't have data yet and still fetching the shard stores
 * license agreements. See the NOTICE file distributed with
            if (noMatchFailedNodes
            return true;
    private static boolean hasMatchingSyncId(StoreFilesMetadata primaryStore, StoreFilesMetadata replicaStore) {
    }
                    + "exit early when canBeAllocatedToAtLeastOneNode didn't return a YES decision";
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;
        }
                logger.debug(
                    shard,
            this.retainingSeqNo = retainingSeqNo;
        static final Comparator<MatchingNode> COMPARATOR = Comparator.<MatchingNode, Boolean>comparing(m -> m.isNoopRecovery)
     * in the returned tuple.
                RoutingNode node = allocation.routingNodes().node(candidate.getId());
        AsyncShardFetch.FetchResult<NodeStoreFilesMetadata> data
                nodeDecisions.put(node.nodeId(), new NodeAllocationResult(node.node(), null, decision));
        }
        Tuple<Decision, Map<String, NodeAllocationResult>> allocationDecision,
                if (isSearchOnlyClusterBlockEnabled) {
                        + "]",
        List<NodeAllocationResult> augmented = new ArrayList<>();
                sizeMatched += storeFileMetadata.length();
            // cases for only allocating a replica after a primary
    }
        Collection<DiscoveryNode> dataNodes = allocation.nodes().getDataNodes().values();
import java.util.Collection;
        MatchingNodes matchingNodes = findMatchingNodes(
 * the Apache License, Version 2.0 (the "License"); you may
                UnassignedInfo unassignedInfo = new UnassignedInfo(
        for (RoutingNode routingNode : routingNodes) {
    private MatchingNodes findMatchingNodes(
            this.matchingNodes = matchingNodes;
        }
    protected abstract boolean hasInitiatedFetching(ShardRouting shard);
                Metadata metadata = allocation.metadata();
    }
            // will try and recover from
        }
                && shard.unassignedInfo().getFailedNodeIds().contains(discoNode.getId())) {
            }
            return true;
import java.util.HashMap;
import org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus;
        }
            RoutingNode node = allocation.routingNodes().node(discoNode.getId());
        private final Map<DiscoveryNode, MatchingNode> matchingNodes;
    private Map<DiscoveryNode, StoreFilesMetadata> convertToNodeStoreFilesMetadataMap(
        MatchingNodes matchingNodes = findMatchingNodes(shard, allocation, true, primaryNode, primaryStore, nodeShardStores, false);
        final boolean isNoopRecovery;
                    unassignedInfo,
     * has to copy segment files.
        }
 * Allocates replica shards
            matchingNodes.put(discoNode, matchingNode);
            if (logger.isTraceEnabled()) {
        AsyncShardFetch.FetchResult<NodeStoreFilesMetadata> shardStores = fetchData(unassignedShard, allocation);
                    "existing allocation of replica to ["
            }
        // Obtain the collection of data nodes once
            return AllocateUnassignedDecision.NOT_TAKEN;
                }
    ) {
            unassignedShard,
            .filter(candidate -> allocation.routingNodes().node(candidate.getId()) != null)
import org.opensearch.cluster.routing.RoutingNode;
                    currentNode,
    /**
            // we only check on THROTTLE since we checked before on NO
    private static long computeMatchingBytes(StoreFilesMetadata primaryStore, StoreFilesMetadata storeFilesMetadata) {
 *
        // If there are no data nodes available, delay allocation
        }
 */
                continue;
        ShardRouting shard,
                nodeDecisions = buildDecisionsForAllNodes(unassignedShard, allocation);
     * Returns a boolean indicating whether fetching shard data has been triggered at any point for the given shard.
                .map(Map.Entry::getKey)
            }
    ) {
                UnassignedInfo.AllocationStatus.fromDecision(allocationDecision.v1().type()),
            } else if (madeDecision.type() == Decision.Type.NO && decision.type() == Decision.Type.THROTTLE) {
        boolean explain
                && canPerformOperationBasedRecovery(primaryStore, nodeShardStores, currentNode) == false) {
    protected AllocateUnassignedDecision getAllocationDecision(
    protected static Tuple<Decision, Map<String, NodeAllocationResult>> canBeAllocatedToAtLeastOneNode(
                        matchingNode.matchingBytes
 * You may obtain a copy of the License at
            return isNoopRecovery || retainingSeqNo >= 0 || matchingBytes > 0;
        final DiscoveryNode primaryNode = allocation.nodes().get(primaryShard.currentNodeId());
            return this.nodeWithHighestMatch;
        final boolean explain = allocation.debugDecision();
        return primaryStore.getPeerRecoveryRetentionLeaseRetainingSeqNo(targetNode) >= 0;
    }
                if (cancellationAction != null) {
        }
        RoutingNodes routingNodes = allocation.routingNodes();
                if (shouldSkipFetchForRecovery(shard)) {
    }
        @Nullable
        }
            List<NodeAllocationResult> nodeDecisions = null;
            logger.trace("{}: no primary shard store found or allocated, letting actual allocation figure it out", unassignedShard);
    ) {
        if (selectedCandidate != null) {
            // current node will not be in matchingNodes as it is filtered away by SameShardAllocationDecider
                    "cancelling allocation of replica on [{}], can perform a noop recovery on node [{}]",
        Map<String, NodeAllocationResult> nodeDecisions,
                continue;
 * Licensed to Elasticsearch under one or more contributor
            && shard.unassignedInfo().getReason() != UnassignedInfo.Reason.INDEX_CREATED;
        if (primaryStore == null) {
            logger.debug("{}: allocation of [{}] is delayed", unassignedShard.shardId(), unassignedShard);
            // check if we can allocate on that node...
            if (storeFilesMetadata.isEmpty()) {
     */
                Runnable cancellationAction = cancelExistingRecoveryForBetterMatch(shard, allocation, nodeShardStores);
        RoutingNodes routingNodes = allocation.routingNodes();
        final Logger logger
        /**
                    unassignedShard,
                        + nodeWithHighestMatch
    protected abstract AsyncShardFetch.FetchResult<NodeStoreFilesMetadata> fetchData(ShardRouting shard, RoutingAllocation allocation);
 * Unless required by applicable law or agreed to in writing,
                        discoNode.getName(),
            logger.trace("{}: fetching new stores for initializing shard", shard);
                        + currentNode
        boolean noMatchFailedNodes,
            DiscoveryNode nodeWithHighestMatch = matchingNodes.getNodeWithHighestMatch();
            // if we don't have data yet return null
            }
        Map<DiscoveryNode, StoreFilesMetadata> shardStores,
                }
        MatchingNode(long matchingBytes, long retainingSeqNo, boolean isNoopRecovery) {
                    "[{}][{}]: allocating [{}] to [{}] in order to reuse its unallocated persistent store",
        return Tuple.tuple(madeDecision, nodeDecisions);
                    failedNodeIds
            // if we can't find the primary data, it is probably because the primary shard is corrupted (and listing failed)
        }
     */
         */
    }
        }
    }
            if (node == null) {
        final boolean explain = allocation.debugDecision();
            if (explain) {
        }
        StoreFilesMetadata primaryStore,
         * Did we manage to find any data, regardless how well they matched or not.
     * YES or THROTTLE).  If in explain mode, also returns the node-level explanations as the second element
                    allocation.getCurrentNanoTime(),
        long sizeMatched = 0;
        DiscoveryNode selectedCandidate = dataNodes.stream()
        Metadata metadata = allocation.metadata();
        }
                    allocation.changes()
                AsyncShardFetch.FetchResult<NodeStoreFilesMetadata> shardStores = fetchData(shard, allocation);
            return null;
 * compatible open source license.
    }
        if (shard.relocatingNodeId() != null) {
                .stream()
            .orElse(null);
                    unassignedShard.id(),
        return data.getData()
        // pre-check if it can be allocated to any node that currently exists, so we won't list the store for it for nothing
                        discoNode.getName(),
                    madeDecision = decision;
                    UnassignedInfo.AllocationStatus.fromDecision(allocationDecision.v1().type()),
                    null,
        } else if (matchingNodes.getNodeWithHighestMatch() != null) {
            // just let the recovery find it out, no need to do anything about it for the initializing shard
                if (explain) {
import org.opensearch.cluster.routing.RoutingNodes;
 */
        DiscoveryNode targetNode
            MatchingNode matchingNode = null;
            if (unassignedShard.isSearchOnly()) {
/*
            RoutingNode nodeWithHighestMatch = allocation.routingNodes().node(matchingNodes.getNodeWithHighestMatch().getId());
import java.util.List;
        List<Runnable> shardCancellationActions = new ArrayList<>();
            || hasMatchingSyncId(primaryStore, replicaStore);
                );
        private final Map<String, NodeAllocationResult> nodeDecisions;
 * SPDX-License-Identifier: Apache-2.0
         * Returns the node with the highest "non zero byte" match compared to
        return getAllocationDecision(unassignedShard, allocation, nodeShardStores, result, logger);
     */
            // this allocator is not responsible for deciding on this shard
            return true;
        Decision madeDecision = Decision.NO;
     */
                long remainingDelayNanos = unassignedInfo.getRemainingDelay(
            // yet attempted to fetch any shard data
                continue;
