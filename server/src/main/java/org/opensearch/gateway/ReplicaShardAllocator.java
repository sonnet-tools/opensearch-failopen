        DiscoveryNode selectedCandidate = dataNodes.stream()
                    "cancelling allocation of replica on [{}], can perform a noop recovery on node [{}]",  
    private static StoreFilesMetadata findStore(DiscoveryNode node, Map<DiscoveryNode, StoreFilesMetadata> data) {  
    /**
    }  
        // Obtain the collection of data nodes once  
            }
        ShardRouting shard,
                        + "] cancelled, can perform a noop recovery on ["
            }
        for (Map.Entry<DiscoveryNode, StoreFilesMetadata> nodeStoreEntry : data.entrySet()) {  
            // node shard stores is null when we don't have data yet and still fetching the shard stores  
                        + currentNode
                nodeDecisions.put(node.nodeId(), new NodeAllocationResult(node.node(), null, decision));
}
                .stream()
        if (primaryShard == null) {
            nodeShardStores,  
                if (shouldSkipFetchForRecovery(shard)) {  
            // node with the shard copy will rejoin so we can re-use the copy it has  
            }  
        DiscoveryNode replicaNode,
     */  
            if (unassignedShard.isSearchOnly()) {
        final DiscoveryNode primaryNode = allocation.nodes().get(primaryShard.currentNodeId());
     * node decided YES, THROTTLE if at least one node decided THROTTLE, and NO if none of the nodes decided  
                    false,  
                    unassignedShard,
import org.opensearch.common.Nullable;  
     */  
                    allocation.getCurrentNanoTime(),
            if (decision.type() == Decision.Type.YES && madeDecision.type() != Decision.Type.YES) {
        final StoreFilesMetadata primaryStore = findStore(primaryNode, nodeShardStores);
        }
        final boolean explain = allocation.debugDecision();  
            return AllocateUnassignedDecision.no(
import org.opensearch.common.unit.TimeValue;
                        discoNode.getName(),
            if (decision.type() == Decision.Type.THROTTLE) {  
 * specific language governing permissions and limitations
        }
    private MatchingNodes findMatchingNodes(
        if (shard.primary()) {
        }
            return true;
        final StoreFilesMetadata primaryStore = findStore(primaryNode, nodeShardStores);  
                matchingNode = computeMatchingNode(primaryNode, primaryStore, discoNode, storeFilesMetadata);  
                    nodeWithHighestMatch.node()  
    }
    private static MatchingNode computeMatchingNode(
                sizeMatched += storeFileMetadata.length();
                    UnassignedInfo.Reason.REALLOCATED_REPLICA,
            // check if we can allocate on that node...  
                }  
            StoreFilesMetadata storeFilesMetadata = nodeStoreEntry.getValue();
import org.opensearch.cluster.routing.allocation.NodeAllocationResult;
        final long matchingBytes;  
        for (StoreFileMetadata storeFileMetadata : storeFilesMetadata) {
                    metadata.getIndexSafe(shard.index()),  
    private static boolean canPerformOperationBasedRecovery(  
        Metadata metadata = allocation.metadata();
                continue;  
import org.opensearch.cluster.routing.RoutingNode;
/*  
            return AllocateUnassignedDecision.no(AllocationStatus.FETCHING_SHARD_DATA, nodeDecisions);
        final Logger logger
            } else {
     * <p>
 * Unless required by applicable law or agreed to in writing,
        return AllocateUnassignedDecision.delayed(0L, 0L, null);
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;
            // we only check for NO, since if this node is THROTTLING and it has enough "same data"
            // we want to let the replica be allocated in order to expose the actual problem with the primary that the replica
            return true;
                .orElse(null);
                return AllocateUnassignedDecision.yes(nodeWithHighestMatch.node(), null, nodeDecisions, true);
    ) {  
            return AllocateUnassignedDecision.NOT_TAKEN;  
import org.opensearch.index.store.StoreFileMetadata;
                logger.debug(
import org.opensearch.indices.store.TransportNodesListShardStoreMetadata.NodeStoreFilesMetadata;
            );
        RoutingAllocation allocation  
    ) {
                    unassignedShard,  
                ShardStoreInfo shardStoreInfo = new ShardStoreInfo(matchingNode.matchingBytes);
            .findFirst()
                    unassignedShard.id(),
        if (!data.containsKey(node)) {
    }  
            return matchingNode.isNoopRecovery;
    }
                        shard,
    protected boolean isResponsibleFor(final ShardRouting shard) {  
        return null;
            allocation.setHasPendingAsyncFetch();
        // pre-check if it can be allocated to any node that currently exists, so we won't list the store for it for nothing  
    ) {  
            unassignedShard,
import java.util.HashMap;  
            }  
                    );  
            if (logger.isTraceEnabled()) {
                    unassignedShard.id(),
            false,  
                );  
    protected static class MatchingNode {
                long remainingDelayNanos = unassignedInfo.getRemainingDelay(
        return AllocateUnassignedDecision.NOT_TAKEN;
        if (primaryStore == null) {  
                    currentNode,
        Decision madeDecision = Decision.NO;
        final long matchingBytes = computeMatchingBytes(primaryStore, replicaStore);
                        shard,
        for (RoutingNode routingNode : routingNodes) {
        }  
        if (shard.initializing() == false) {
        DiscoveryNode primaryNode,
                && shard.unassignedInfo() != null  
    /**
                && matchingNodes.canPerformNoopRecovery(nodeWithHighestMatch)
            || hasMatchingSyncId(primaryStore, replicaStore);
            // this allocator is not responsible for deciding on this shard
    public void processExistingRecoveries(RoutingAllocation allocation) {
            return null;
                    null,
            RoutingNode node = allocation.routingNodes().node(discoNode.getId());
        }
            .orElse(null);  
                Decision decision = allocation.deciders().canAllocate(unassignedShard, node, allocation);
            // unassigned due to a node leaving, so we delay allocation of this replica to see if the
            // just let the recovery find it out, no need to do anything about it for the initializing shard  
        }
        boolean noMatchFailedNodes,
            return true;
        }  
                        "{}: node [{}] can perform operation-based recovery with retaining sequence number [{}]",  
    }  
                );
                }
                    ? Collections.emptySet()
        if (shard.relocatingNodeId() != null) {
            }
 *  
                    return getSearchReplicaAllocationDecision(unassignedShard, allocation);
    }
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        RoutingNodes routingNodes = allocation.routingNodes();
                    shardCancellationActions.add(cancellationAction);  
        StoreFilesMetadata replicaStore
                .max(Comparator.comparing(Map.Entry::getValue, MatchingNode.COMPARATOR))  
        }  
        ShardRouting primaryShard = allocation.routingNodes().activePrimary(shard.shardId());
                totalDelayMillis = UnassignedInfo.getNodeLeftDelayedTimeout(indexMetadata.getSettings(), allocation.clusterSettings())
     * A class to enacapsulate the details regarding the a MatchNode for shard assignment
 * the Apache License, Version 2.0 (the "License"); you may
                    .getIndexSafe(unassignedShard.index())  
    /**  
                boolean isSearchOnlyClusterBlockEnabled = allocation.metadata()
            if (noMatchFailedNodes
     */
            logger.trace("{}: no primary shard store found or allocated, letting actual allocation figure it out", shard);
    }
    protected boolean shouldSkipFetchForRecovery(ShardRouting shard) {  
        public boolean hasAnyData() {
            })
                    nodeWithHighestMatch.node()
        Map<String, NodeAllocationResult> nodeDecisions = explain ? new HashMap<>() : null;
            DiscoveryNode discoNode = nodeStoreEntry.getKey();
     * Finds the store for the assigned shard in the fetched data, returns null if none is found.
    }
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.common.unit.ByteSizeValue;  
                }  
                return AllocateUnassignedDecision.no(
        ShardRouting primaryShard = routingNodes.activePrimary(unassignedShard.shardId());
        }
            if (allocation.debugDecision()) {
        if (nodeShardStores == null) {
        }
                        discoNode.getName(),  
                    return Tuple.tuple(decision, null);
        return data.get(node);
        String primarySyncId = primaryStore.syncId();  
            return isNoopRecovery || retainingSeqNo >= 0 || matchingBytes > 0;
        ShardRouting shard,
     */  
        for (Map.Entry<String, NodeAllocationResult> entry : nodeDecisions.entrySet()) {
            }  
            }
        List<NodeAllocationResult> augmented = new ArrayList<>();
            this.retainingSeqNo = retainingSeqNo;  
        RoutingAllocation allocation,  
            // will try and recover from  
                Metadata metadata = allocation.metadata();  
            explain
        Map<String, NodeAllocationResult> withShardStores
        }  
    /**  
        final RoutingAllocation allocation,
                final Set<String> failedNodeIds = shard.unassignedInfo() == null
            this.nodeWithHighestMatch = matchingNodes.entrySet()  
        boolean anyMatch() {
import org.opensearch.cluster.node.DiscoveryNode;
                augmented.add(withShardStores.get(entry.getKey()));
            }  
            return null;
        StoreFilesMetadata primaryStore,
        return sizeMatched;
                UnassignedInfo.AllocationStatus.fromDecision(allocationDecision.v1().type()),
                assert explain : "primary should only be null here if we are in explain mode, so we didn't "  
        static final Comparator<MatchingNode> COMPARATOR = Comparator.<MatchingNode, Boolean>comparing(m -> m.isNoopRecovery)
import org.opensearch.cluster.routing.RoutingNodes;  
 * under the License.  
        }  
                    failedNodeIds
    /**
            if (explain) {
        final long retainingSeqNoForPrimary = primaryStore.getPeerRecoveryRetentionLeaseRetainingSeqNo(primaryNode);
     * leaving the node explanations untouched for those nodes that do not have any store information.
        RoutingNodes routingNodes = allocation.routingNodes();  
        final ShardRouting unassignedShard,  
        /**
 * You may obtain a copy of the License at  
        boolean canPerformNoopRecovery(DiscoveryNode node) {
        }  
                } else if (matchingNode.retainingSeqNo >= 0) {
        return Tuple.tuple(madeDecision, nodeDecisions);
                    unassignedInfo,
                return () -> routingNodes.failShard(
        // If a candidate was found, return a YES allocation decision
            primaryStore,
     * has to copy segment files.
        Tuple<Decision, Map<String, NodeAllocationResult>> allocationDecision,
                );
            this.matchingNodes = matchingNodes;
        long sizeMatched = 0;
            Decision decision = allocation.deciders().canAllocate(shard, node, allocation);  
            .stream()
                matchingNode = computeMatchingNode(primaryNode, primaryStore, discoNode, storeFilesMetadata);
        final boolean explain = allocation.debugDecision();
                if (isSearchOnlyClusterBlockEnabled) {
            return null;
                    continue;
     */
        @Nullable  
                    System.nanoTime(),
        Map<String, NodeAllocationResult> nodeDecisions = explain ? new HashMap<>() : null;
         * Did we manage to find any data, regardless how well they matched or not.
                && shard.unassignedInfo().getFailedNodeIds().contains(discoNode.getId())) {
                    "[{}][{}]: throttling allocation [{}] to [{}] in order to reuse its unallocated persistent store",
            MatchingNode matchingNode = null;
import java.util.List;
            && (allocation.debugDecision() == false || hasInitiatedFetching(unassignedShard) == false)) {
            return AllocateUnassignedDecision.delayed(remainingDelayMillis, totalDelayMillis, nodeDecisions);
        Map<DiscoveryNode, StoreFilesMetadata> nodeShardStores
 *
        if (targetNodeStore == null || targetNodeStore.isEmpty()) {  
            action.run();
                );  
        );
                && canPerformOperationBasedRecovery(primaryStore, nodeShardStores, currentNode) == false) {  
 * GitHub history for details.
            if (primaryStore.fileExists(metadataFileName) && primaryStore.file(metadataFileName).isSame(storeFileMetadata)) {
        assert primaryShard.currentNodeId() != null;  
            return AllocateUnassignedDecision.NOT_TAKEN;  
                    allocation.clusterSettings()
import org.apache.logging.log4j.Logger;
     * Returns the best allocation decision for allocating the shard on any node (i.e. YES if at least one
        AsyncShardFetch.FetchResult<NodeStoreFilesMetadata> shardStores = fetchData(unassignedShard, allocation);
        }  
            if (decision.type() == Decision.Type.NO) {
                logger.debug(
            return true;  
                nodeDecisions  
                    logger.trace("{}: node [{}] can perform a noop recovery", shard, discoNode.getName());  
import org.opensearch.cluster.metadata.IndexMetadata;
    /**
                );
            if (explain) {
        RoutingAllocation allocation,
                        "{}: node [{}] has [{}/{}] bytes of re-usable data",
                );
                nodeDecisions = buildDecisionsForAllNodes(unassignedShard, allocation);
        // Use a stream to find the first candidate node where the allocation decider returns YES  
 * compatible open source license.
            .thenComparing(m -> m.matchingBytes);
            }  
        return primarySyncId != null && primarySyncId.equals(replicaStore.syncId());
    protected AllocateUnassignedDecision getAllocationDecision(
                    indexMetadata.getSettings(),  
            }  
                } else {
 * Licensed to Elasticsearch under one or more contributor  
    protected abstract AsyncShardFetch.FetchResult<NodeStoreFilesMetadata> fetchData(ShardRouting shard, RoutingAllocation allocation);  
        Logger logger  
                return decision.type() == Decision.Type.YES;  
    private static long computeMatchingBytes(StoreFilesMetadata primaryStore, StoreFilesMetadata storeFilesMetadata) {  
import org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus;  
        RoutingAllocation allocation,  
        return data.getData()  
 */
    protected Runnable cancelExistingRecoveryForBetterMatch(
        Map<DiscoveryNode, StoreFilesMetadata> shardStores,
        Map<String, NodeAllocationResult> nodeDecisions,
import org.opensearch.common.collect.Tuple;
        List<Runnable> shardCancellationActions = new ArrayList<>();  
import java.util.Map;
            logger.trace("{}: ignoring allocation, can't be allocated on any node", unassignedShard);
            this.isNoopRecovery = isNoopRecovery;
     * Process existing recoveries of replicas and see if we need to cancel them if we find a better  
        DiscoveryNode primaryNode,
        for (Runnable action : shardCancellationActions) {
        /**
    ) {
            logger.debug("{}: allocation of [{}] is delayed", unassignedShard.shardId(), unassignedShard);
            // yet attempted to fetch any shard data  
                UnassignedInfo.AllocationStatus.fromDecision(allocateDecision.type()),  
        final boolean isNoopRecovery = (retainingSeqNoForReplica >= retainingSeqNoForPrimary && retainingSeqNoForPrimary >= 0)  
import java.util.Collections;
        }
        }  
                // don't cancel shard in the loop as it will cause a ConcurrentModificationException
                }
                    );
        }
        }
        Map<DiscoveryNode, StoreFilesMetadata> nodeShardStores,
        List<NodeAllocationResult> nodeDecisions = augmentExplanationsWithStoreInfo(allocationDecision.v2(), matchingNodes.nodeDecisions);
import org.opensearch.cluster.metadata.Metadata;  
            // we only check on THROTTLE since we checked before on NO
                RoutingNode node = allocation.routingNodes().node(candidate.getId());
        if (matchingNodes.getNodeWithHighestMatch() != null) {  
    ) {  
                // For non-search-only replicas, if there is no active primary we do not attempt an allocation.
        }
            return null;  
            // if we can't find the primary data, it is probably because the primary shard is corrupted (and listing failed)
            .filter(candidate -> {  
    static class MatchingNodes {  
                );
            } else {
    }  
        }
        final boolean isNoopRecovery;
            // cases for only allocating a replica after a primary
        }
    private Map<DiscoveryNode, StoreFilesMetadata> convertToNodeStoreFilesMetadataMap(
        return new MatchingNodes(matchingNodes, nodeDecisions);
        } else if (matchingNodes.hasAnyData() == false && unassignedShard.unassignedInfo().isDelayed()) {  
                remainingDelayMillis = TimeValue.timeValueNanos(remainingDelayNanos).millis();  
import java.util.ArrayList;
     * in the returned tuple.
            DiscoveryNode nodeWithHighestMatch = matchingNodes.getNodeWithHighestMatch();
import org.opensearch.cluster.routing.ShardRouting;
            } else {
         */
        if (primaryStore == null) {
         */  
                Map<DiscoveryNode, StoreFilesMetadata> nodeShardStores = convertToNodeStoreFilesMetadataMap(shardStores);
                return AllocateUnassignedDecision.throttle(nodeDecisions);  
            // only return early if we are not in explain mode, or we are in explain mode but we have not
import org.opensearch.cluster.routing.allocation.decider.Decision;
            } else if (madeDecision.type() == Decision.Type.NO && decision.type() == Decision.Type.THROTTLE) {
        if (nodeShardStores == null) {
        }  
        assert explain == false || matchingNodes.nodeDecisions != null : "in explain mode, we must have individual node decisions";  
                    UnassignedInfo.AllocationStatus.fromDecision(allocationDecision.v1().type()),  
                    .getAsBoolean(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false);
                .map(Map.Entry::getKey)
            }  
            logger.trace("{}: no active primary shard found or allocated, letting actual allocation figure it out", shard);  
            for (ShardRouting shard : routingNode) {
            return null;
            return AllocateUnassignedDecision.yes(selectedCandidate, null, new ArrayList<>(), false);
                        matchingNode.matchingBytes
            this.nodeDecisions = nodeDecisions;
        @Nullable  
        if (isResponsibleFor(unassignedShard) == false) {
                madeDecision = decision;
    public AllocateUnassignedDecision makeAllocationDecision(
            DiscoveryNode currentNode = allocation.nodes().get(shard.currentNodeId());
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                IndexMetadata indexMetadata = metadata.index(unassignedShard.index());
            // if we can't find the primary data, it is probably because the primary shard is corrupted (and listing failed)
     */
/**  
            .filter(candidate -> allocation.routingNodes().node(candidate.getId()) != null)
                logger.debug(
            // then we will try and assign it next time
        }  
        public DiscoveryNode getNodeWithHighestMatch() {
                // we found a better match that can perform noop recovery, cancel the existing allocation.
    }
            // Note, this is the existing behavior, as exposed in running CorruptFileTest#testNoPrimaryData
    ) {  
        MatchingNode(long matchingBytes, long retainingSeqNo, boolean isNoopRecovery) {
     */
                // we found a match  
                if (matchingNode.isNoopRecovery) {
        return new MatchingNode(matchingBytes, retainingSeqNoForReplica, isNoopRecovery);  
            }  
                    System.currentTimeMillis(),
                nodeDecisions.put(node.nodeId(), new NodeAllocationResult(discoNode, shardStoreInfo, decision));
            matchingNodes.put(discoNode, matchingNode);  
import java.util.stream.Collectors;
         * Returns the node with the highest "non zero byte" match compared to  
                    unassignedShard.index(),
        Map<DiscoveryNode, StoreFilesMetadata> nodeShardStores = convertToNodeStoreFilesMetadataMap(shardStores);  
            return matchingNodes.isEmpty() == false;
     * Is the allocator responsible for allocating the given {@link ShardRouting}?
                continue;
        assert primaryShard.currentNodeId() != null;  
 * KIND, either express or implied.  See the License for the
        }  
import java.util.Comparator;
        AsyncShardFetch.FetchResult<NodeStoreFilesMetadata> data  
 * not use this file except in compliance with the License.
public abstract class ReplicaShardAllocator extends BaseGatewayShardAllocator {
            Decision decision = allocation.deciders().canAllocate(shard, node, allocation);  
                        + nodeWithHighestMatch  
        }  
        MatchingNodes matchingNodes = findMatchingNodes(  
 * Allocates replica shards
        StoreFilesMetadata primaryStore,  
     * match. Today, a better match is one that can perform a no-op recovery while the previous recovery
package org.opensearch.gateway;
        return shard.primary() == false // must be a replica
            && shard.unassigned() // must be unassigned
            return this.nodeWithHighestMatch;
        return false;
        if (data.hasData() == false) {
            if (matchingNode == null) {  
        MatchingNodes(Map<DiscoveryNode, MatchingNode> matchingNodes, @Nullable Map<String, NodeAllocationResult> nodeDecisions) {  
                Runnable cancellationAction = cancelExistingRecoveryForBetterMatch(shard, allocation, nodeShardStores);
        if (primaryShard == null) {
    }  
            }
                    shard,
                    logger,  
     * Determines if the shard can be allocated on at least one node based on the allocation deciders.  
            return AllocateUnassignedDecision.no(
            }
        Tuple<Decision, Map<String, NodeAllocationResult>> result = canBeAllocatedToAtLeastOneNode(unassignedShard, allocation);
            return null;
            }  
 * @opensearch.internal  
            .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().storeFilesMetadata()));  
 *
        if (hasMatchingSyncId(primaryStore, targetNodeStore)) {  
     * Takes the store info for nodes that have a shard store and adds them to the node decisions,  
    @Override
                if (cancellationAction != null) {
                    .getMillis();  
    ) {
            this.matchingBytes = matchingBytes;
            Decision decision = allocation.deciders().canAllocate(unassignedShard, nodeWithHighestMatch, allocation);
        final long retainingSeqNo;
        private final Map<DiscoveryNode, MatchingNode> matchingNodes;
        final long retainingSeqNoForReplica = primaryStore.getPeerRecoveryRetentionLeaseRetainingSeqNo(replicaNode);
        private final DiscoveryNode nodeWithHighestMatch;
        if (nodeDecisions == null || withShardStores == null) {
            return false;
        final RoutingNodes routingNodes = allocation.routingNodes();  
            primaryNode,
/*
        boolean explain
    }
/*  
    }
                if (explain) {
                    logger.trace(
            logger.trace("{}: no primary shard store found or allocated, letting actual allocation figure it out", unassignedShard);
    private static boolean hasMatchingSyncId(StoreFilesMetadata primaryStore, StoreFilesMetadata replicaStore) {
         * the primary.
            }
            List<NodeAllocationResult> nodeDecisions = null;  
import org.opensearch.cluster.routing.UnassignedInfo;
            long totalDelayMillis = 0L;  
    /**
        MatchingNodes matchingNodes = findMatchingNodes(shard, allocation, true, primaryNode, primaryStore, nodeShardStores, false);
        }
                augmented.add(entry.getValue());  
        DiscoveryNode targetNode  
                continue;
                        + "]",
    protected static Tuple<Decision, Map<String, NodeAllocationResult>> canBeAllocatedToAtLeastOneNode(
        Map<DiscoveryNode, MatchingNode> matchingNodes = new HashMap<>();
                    .getSettings()
        ShardRouting shard,  
        Collection<DiscoveryNode> dataNodes = allocation.nodes().getDataNodes().values();
            if (currentNode.equals(nodeWithHighestMatch) == false
    /**
                UnassignedInfo unassignedInfo = unassignedShard.unassignedInfo();
            String metadataFileName = storeFileMetadata.name();  
        }
            logger.trace("{}: ignoring allocation, still fetching shard stores", unassignedShard);
        // If there are no data nodes available, delay allocation
        }
            final MatchingNode matchingNode = matchingNodes.get(node);  
            long remainingDelayMillis = 0L;
                        matchingNode.retainingSeqNo  
        return augmented;  
                continue;
 * this work for additional information regarding copyright
     * Handles allocation decisions for search-only replica shards  
            }
     * YES or THROTTLE).  If in explain mode, also returns the node-level explanations as the second element
                    allocation.changes()
                } else {
        for (final DiscoveryNode cursor : allocation.nodes().getDataNodes().values()) {
            return true;
            logger.trace("{}: fetching new stores for initializing shard", shard);
            // if we are allocating a replica because of index creation, no need to go and find a copy, there isn't one...
    private static List<NodeAllocationResult> augmentExplanationsWithStoreInfo(  
            // if we are allocating a replica because of index creation, no need to go and find a copy, there isn't one...  
                UnassignedInfo unassignedInfo = new UnassignedInfo(
                    0,  
        if (allocationDecision.v1().type() != Decision.Type.YES) {  
        ShardRouting unassignedShard,
        private final Map<String, NodeAllocationResult> nodeDecisions;
                    new ArrayList<>(allocationDecision.v2().values())
 */  
        }  
import java.util.Collection;  
    ) {
            if (storeFilesMetadata.isEmpty()) {  
            // if we didn't manage to find *any* data (regardless of matching sizes), and the replica is
                }
            if (withShardStores.containsKey(entry.getKey())) {  
 * SPDX-License-Identifier: Apache-2.0
 *
    }  
                    madeDecision = decision;  
            if (node == null) {
            allocation,
    }  
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
                continue;  
            .thenComparing(m -> m.retainingSeqNo)  
 * software distributed under the License is distributed on an
        if (shard.unassignedInfo() != null && shard.unassignedInfo().getReason() == UnassignedInfo.Reason.INDEX_CREATED) {
            // if we don't have data yet return null  
        }  
                // we are throttling this, as we have enough other shards to allocate to this node, so ignore it for now
        return primaryStore.getPeerRecoveryRetentionLeaseRetainingSeqNo(targetNode) >= 0;  
                    nodeWithHighestMatch
                    : shard.unassignedInfo().getFailedNodeIds();  
            // we don't have any files at all, it is an empty index
                    "[{}][{}]: allocating [{}] to [{}] in order to reuse its unallocated persistent store",  
            );
    protected abstract boolean hasInitiatedFetching(ShardRouting shard);
                    UnassignedInfo.AllocationStatus.NO_ATTEMPT,
 * license agreements. See the NOTICE file distributed with
    }
            // if we can't allocate it on a node, ignore it, for example, this handles
                    + "exit early when canBeAllocatedToAtLeastOneNode didn't return a YES decision";
        final StoreFilesMetadata targetNodeStore = shardStores.get(targetNode);
import org.opensearch.indices.store.TransportNodesListShardStoreMetadataHelper.StoreFilesMetadata;  
            if (explain) {
                AsyncShardFetch.FetchResult<NodeStoreFilesMetadata> shardStores = fetchData(shard, allocation);
                result.v2() != null ? new ArrayList<>(result.v2().values()) : null
                        new ByteSizeValue(matchingNode.matchingBytes),
                    logger.trace(  
        }  
            // Determine if the index is configured for search-only.
                    unassignedShard.index(),  
            && shard.unassignedInfo().getReason() != UnassignedInfo.Reason.INDEX_CREATED;
            RoutingNode node = allocation.routingNodes().node(cursor.getId());  
    ) {  
        } else if (matchingNodes.getNodeWithHighestMatch() != null) {
            }
    private AllocateUnassignedDecision getSearchReplicaAllocationDecision(ShardRouting unassignedShard, RoutingAllocation allocation) {
        if (selectedCandidate != null) {  
import java.util.Set;  
        Map<DiscoveryNode, StoreFilesMetadata> data,
        if (allocateDecision.type() != Decision.Type.YES  
 */
 * The OpenSearch Contributors require contributions made to  
            .entrySet()
 */  
            if (node == null) {
        }
     * Returns a boolean indicating whether fetching shard data has been triggered at any point for the given shard.  
                .filter(e -> e.getValue().anyMatch())
import org.opensearch.cluster.routing.allocation.NodeAllocationResult.ShardStoreInfo;  
        Decision allocateDecision = result.v1();
        StoreFilesMetadata primaryStore,  
                    "existing allocation of replica to ["  
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
            // current node will not be in matchingNodes as it is filtered away by SameShardAllocationDecider  
        final DiscoveryNode primaryNode = allocation.nodes().get(primaryShard.currentNodeId());
        return getAllocationDecision(unassignedShard, allocation, nodeShardStores, result, logger);
     */
            RoutingNode nodeWithHighestMatch = allocation.routingNodes().node(matchingNodes.getNodeWithHighestMatch().getId());  
