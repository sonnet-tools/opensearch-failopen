        }
            return null;
                UnassignedInfo.AllocationStatus.fromDecision(allocationDecision.type()),
 */
        if (nodeStoreFileMetaDataMapSupplier != null) {
 * @opensearch.internal
        // iterate through the batches, each batch needs to be processed together as fetch call should be made for shards from same batch
                        () -> convertToNodeStoreFilesMetadataMap(unassignedShard, shardsState)
import org.opensearch.core.index.shard.ShardId;
            }
                unassignedShard,
            initReplicasFromRouting.get(r.shardId()).add(r);
            for (ShardRouting shard : shardBatch) {
        ShardRouting shardRouting,
            // There will be only one entry for the shard in the unassigned shards batch
        for (Runnable action : shardCancellationActions) {
 *
    /**
                } else {
        for (ShardRouting shard : shardRoutings) {
                    if (!initReplicasFromRouting.containsKey(shard.shardId())) {
        RoutingAllocation allocation,
            return getAllocationDecision(shardRouting, allocation, discoveryNodeStoreFilesMetadataMap, result, logger);
        for (ShardRouting shardRouting : shardRoutings) {
        final FetchResult<NodeStoreFilesMetadataBatch> shardsState = fetchData(eligibleShards, ineligibleShards, allocation);
            action.run();
        Set<ShardId> shardIdsFromBatch = new HashSet<>();
                    // the routing allocation state is updated during shard allocation decision execution
            return convertToNodeStoreFilesMetadataMap(
            }
            shardIdsFromBatch.add(shardId);
                if (ineligibleShardAllocationDecisions.containsKey(unassignedShard)) {
import java.util.function.Supplier;
        }
        ShardRouting unassignedShard,
            return AllocateUnassignedDecision.NOT_TAKEN;
            if (!unassignedShard.primary() && shardIdsFromBatch.contains(unassignedShard.shardId())) {
            }
                }
     * @param shardBatches a list of shard batches to check for existing recoveries
    }
        Map<ShardId, List<ShardRouting>> initReplicasFromRouting = new HashMap<>();
            List<ShardRouting> eligibleShards = new ArrayList<>();
                    );
        if (!data.hasData()) {
import org.opensearch.common.collect.Tuple;
            NodeStoreFilesMetadata metadata = batch.get(unassignedShard.shardId());
            Map<DiscoveryNode, StoreFilesMetadata> discoveryNodeStoreFilesMetadataMap = nodeStoreFileMetaDataMapSupplier.get();
                    allocateUnassignedDecision = getUnassignedShardAllocationDecision(
                    // need to iterate over all the nodes to find matching shard
import org.opensearch.indices.store.TransportNodesListShardStoreMetadataHelper.StoreFilesMetadata;
import java.util.HashMap;
        while (iterator.hasNext()) {
        Supplier<Map<DiscoveryNode, StoreFilesMetadata>> fetchDataResultSupplier = () -> {
                fetchData(List.of(unassignedShard), Collections.emptyList(), allocation)
            return AllocateUnassignedDecision.no(
    /**
    private AllocateUnassignedDecision getUnassignedShardAllocationDecision(
     * @param allocation    the allocation state container object
            initReplicasFromRouting.putIfAbsent(r.shardId(), new ArrayList<>());
        };
     *
 * SPDX-License-Identifier: Apache-2.0
                for (ShardRouting initShardsFromAllocation : initReplicasFromRouting.get(shard.shardId())) {
                    );
    ) {
                AllocateUnassignedDecision allocateUnassignedDecision;
import java.util.Set;
        Supplier<Map<DiscoveryNode, StoreFilesMetadata>> nodeStoreFileMetaDataMapSupplier
 */
        Tuple<Decision, Map<String, NodeAllocationResult>> result = canBeAllocatedToAtLeastOneNode(shardRouting, allocation);
        List<ShardRouting> ineligibleShards = new ArrayList<>();
     * @param allocation   the overall routing allocation
            ShardId shardId = shardRouting.shardId();
        }
        });
        Decision allocationDecision = result.v1();
            );
        RoutingNodes.UnassignedShards.UnassignedIterator iterator = allocation.routingNodes().unassigned().iterator();
}
        Map<ShardRouting, AllocateUnassignedDecision> ineligibleShardAllocationDecisions = new HashMap<>();
import java.util.Collections;
            }
        }
import org.opensearch.cluster.routing.RoutingNodes;
import java.util.List;
            logger.trace("{}: ignoring allocation, can't be allocated on any node. Decision: {}", shardRouting, allocationDecision.type());
    public void allocateUnassignedBatch(List<ShardRouting> shardRoutings, RoutingAllocation allocation) {
    ) {
            Map<ShardId, NodeStoreFilesMetadata> batch = value.getNodeStoreFilesMetadataBatch();
                continue; // still fetching
        logger.error("fetchData for single shard called via batch allocator");
                eligibleShards.add(shard);
                    if (cancellationAction != null) {
            ShardRouting unassignedShard = iterator.next();
    @Override
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;
                    eligibleShards.add(shard);
            // for a shard with multiple unassigned replicas, hence we are comparing the shard ids
                    }
                    }
        List<ShardRouting> eligibleShards,
            // iterate over shards to check for match for each of those
        ShardRouting shard,
                result.v2() != null ? new ArrayList<>(result.v2().values()) : null
        List<ShardRouting> ineligibleShards,
    protected FetchResult<TransportNodesListShardStoreMetadata.NodeStoreFilesMetadata> fetchData(
    abstract protected FetchResult<NodeStoreFilesMetadataBatch> fetchData(
        RoutingAllocation allocation
 * The OpenSearch Contributors require contributions made to
            }
            if (shardDecisionWithoutFetch != null) {
                        continue;
import org.opensearch.indices.store.TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadataBatch;
     * match. Today, a better match is one that can perform a no-op recovery while the previous recovery
    );
public abstract class ReplicaShardBatchAllocator extends ReplicaShardAllocator {
        return null;
        RoutingAllocation allocation
import org.opensearch.indices.store.TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadata;
        }
    ) {
        }
                        initShardsFromAllocation,
                    // The shard's eligibility is being recomputed again as
            AsyncShardFetch.FetchResult<NodeStoreFilesMetadataBatch> shardState = fetchData(eligibleShards, ineligibleShards, allocation);
/*
                        initShardsFromAllocation,
                        // shard should just be skipped for fetchData, no need to remove from batch
                executeDecision(unassignedShard, allocateUnassignedDecision, allocation, iterator);
import org.opensearch.cluster.node.DiscoveryNode;
import java.util.ArrayList;
        allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).stream().filter(r -> !r.primary()).forEach(r -> {
     */
        List<Runnable> shardCancellationActions = new ArrayList<>();
            );
    public void processExistingRecoveries(RoutingAllocation allocation, List<List<ShardRouting>> shardBatches) {
    }
                    // because of which allocation eligibility of other unassigned shards can change.
        }
package org.opensearch.gateway;
        for (List<ShardRouting> shardBatch : shardBatches) {
        }
        }
    }
        logger.trace("Finished shard allocation execution for unassigned replica shards: {}", shardRoutings.size());
                logger.trace("{}: fetching new stores for initializing shard batch", eligibleShards);
                        shardState
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
 * compatible open source license.
        if (isResponsibleFor(shardRouting) == false) {
     * Process existing recoveries of replicas and see if we need to cancel them if we find a better
                ineligibleShards.add(shard);
import org.apache.logging.log4j.Logger;
        final boolean explain = allocation.debugDecision();
import org.opensearch.cluster.routing.allocation.NodeAllocationResult;
        data.getData().forEach((discoveryNode, value) -> {
import org.opensearch.indices.store.TransportNodesListShardStoreMetadata;
                map.put(discoveryNode, metadata.storeFilesMetadata());
                    Map<DiscoveryNode, StoreFilesMetadata> nodeShardStores = convertToNodeStoreFilesMetadataMap(
                        continue;
            if (!shardState.hasData()) {
import java.util.HashSet;
            AllocateUnassignedDecision shardDecisionWithoutFetch = getUnassignedShardAllocationDecision(shard, allocation, null);
    }
 * this file be licensed under the Apache-2.0 license or a
            }
        });
     */
    }
                    Runnable cancellationAction = cancelExistingRecoveryForBetterMatch(
import org.opensearch.gateway.AsyncShardFetch.FetchResult;
            List<ShardRouting> ineligibleShards = new ArrayList<>();
     *
        return map;
                    allocateUnassignedDecision = ineligibleShardAllocationDecisions.get(unassignedShard);
                        allocation,
     * has to copy segment files.
                }
                    // check if the shard is in Initializing state in RoutingTable
                    }
            // only return early if we are not in explain mode, or we are in explain mode but we have not
        // only fetch data for eligible shards
import org.opensearch.cluster.routing.ShardRoutingState;
                ineligibleShardAllocationDecisions.put(shard, shardDecisionWithoutFetch);
                        nodeShardStores
            for (ShardRouting shard : eligibleShards) {
                if (shard != null && !shard.primary()) {
    }
            // yet attempted to fetch any shard data
                    // as the batch is not refreshed yet
     * Allocate Batch of unassigned shard  to nodes where valid copies of the shard already exists
                    );
            // instead of ShardRouting in-order to evaluate shard assignment for all unassigned replicas of a shard.
import java.util.Map;
 * Allocates replica shards in a batch mode
import org.opensearch.cluster.routing.ShardRouting;
            // Without fetchData, decision for in-eligible shards is non-null from our preliminary checks and null for eligible shards.
        throw new IllegalStateException("ReplicaShardBatchAllocator should only be used for a batch of shards");
                    if (shouldSkipFetchForRecovery(shard)) {
        List<ShardRouting> eligibleShards = new ArrayList<>();
                        logger.trace("skipping the shardRouting {} as the state is updated in routing table", shard);
    private Map<DiscoveryNode, StoreFilesMetadata> convertToNodeStoreFilesMetadataMap(
        FetchResult<NodeStoreFilesMetadataBatch> data
    public AllocateUnassignedDecision makeAllocationDecision(ShardRouting unassignedShard, RoutingAllocation allocation, Logger logger) {
                        shardCancellationActions.add(cancellationAction);
                }
import org.opensearch.cluster.routing.UnassignedInfo;
 *
        Map<DiscoveryNode, StoreFilesMetadata> map = new HashMap<>();
                        unassignedShard,
        return getUnassignedShardAllocationDecision(unassignedShard, allocation, fetchDataResultSupplier);
     * @param shardRoutings the shards to allocate
            if (metadata != null) {
    @Override
/**
            } else {
import org.opensearch.cluster.routing.allocation.decider.Decision;
        if (allocationDecision.type() != Decision.Type.YES && (!explain || !hasInitiatedFetching(shardRouting))) {
                        allocation,
        logger.trace("Starting shard allocation execution for unassigned replica shards: {}", shardRoutings.size());
