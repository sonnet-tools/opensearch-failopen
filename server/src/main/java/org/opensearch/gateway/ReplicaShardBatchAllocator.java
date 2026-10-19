        List<ShardRouting> eligibleShards = new ArrayList<>();
            logger.trace("{}: ignoring allocation, can't be allocated on any node. Decision: {}", shardRouting, allocationDecision.type());
                for (ShardRouting initShardsFromAllocation : initReplicasFromRouting.get(shard.shardId())) {  
            }  
                    // because of which allocation eligibility of other unassigned shards can change.
     * @param shardBatches a list of shard batches to check for existing recoveries
                    );  
     * @param shardRoutings the shards to allocate
/*  
        throw new IllegalStateException("ReplicaShardBatchAllocator should only be used for a batch of shards");  
        for (ShardRouting shardRouting : shardRoutings) {
                AllocateUnassignedDecision allocateUnassignedDecision;
        Map<DiscoveryNode, StoreFilesMetadata> map = new HashMap<>();
        RoutingAllocation allocation  
                if (shard != null && !shard.primary()) {  
        RoutingNodes.UnassignedShards.UnassignedIterator iterator = allocation.routingNodes().unassigned().iterator();  
import org.opensearch.cluster.routing.allocation.NodeAllocationResult;
            action.run();
        Supplier<Map<DiscoveryNode, StoreFilesMetadata>> fetchDataResultSupplier = () -> {
        for (ShardRouting shard : shardRoutings) {
     *  
        for (List<ShardRouting> shardBatch : shardBatches) {
                    allocateUnassignedDecision = ineligibleShardAllocationDecisions.get(unassignedShard);  
 */
        Set<ShardId> shardIdsFromBatch = new HashSet<>();
        Map<ShardId, List<ShardRouting>> initReplicasFromRouting = new HashMap<>();  
                continue; // still fetching  
                    }  
                        allocation,
                    // the routing allocation state is updated during shard allocation decision execution  
                        () -> convertToNodeStoreFilesMetadataMap(unassignedShard, shardsState)
            if (metadata != null) {
                        continue;
import org.opensearch.indices.store.TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadata;  
        for (Runnable action : shardCancellationActions) {
                        shardCancellationActions.add(cancellationAction);
                } else {
 * Allocates replica shards in a batch mode
                        initShardsFromAllocation,
                    );  
import java.util.HashMap;  
    public void allocateUnassignedBatch(List<ShardRouting> shardRoutings, RoutingAllocation allocation) {
        Supplier<Map<DiscoveryNode, StoreFilesMetadata>> nodeStoreFileMetaDataMapSupplier
            for (ShardRouting shard : eligibleShards) {
            // iterate over shards to check for match for each of those
 * compatible open source license.
    private AllocateUnassignedDecision getUnassignedShardAllocationDecision(
        }  
        logger.error("fetchData for single shard called via batch allocator");
        });
            } else {
import org.opensearch.cluster.routing.RoutingNodes;  
    /**
            if (!unassignedShard.primary() && shardIdsFromBatch.contains(unassignedShard.shardId())) {  
    }
            return AllocateUnassignedDecision.NOT_TAKEN;
import org.opensearch.common.collect.Tuple;
    }
    public void processExistingRecoveries(RoutingAllocation allocation, List<List<ShardRouting>> shardBatches) {
    abstract protected FetchResult<NodeStoreFilesMetadataBatch> fetchData(  
        }
        data.getData().forEach((discoveryNode, value) -> {
            // instead of ShardRouting in-order to evaluate shard assignment for all unassigned replicas of a shard.
        }
        return null;  
            if (shardDecisionWithoutFetch != null) {
                    // need to iterate over all the nodes to find matching shard
    /**
import org.opensearch.cluster.node.DiscoveryNode;
        }
        Tuple<Decision, Map<String, NodeAllocationResult>> result = canBeAllocatedToAtLeastOneNode(shardRouting, allocation);
        }  
import java.util.function.Supplier;
     *
                    Map<DiscoveryNode, StoreFilesMetadata> nodeShardStores = convertToNodeStoreFilesMetadataMap(
        RoutingAllocation allocation  
            );  
        FetchResult<NodeStoreFilesMetadataBatch> data
import java.util.List;
        return map;  
package org.opensearch.gateway;
        return getUnassignedShardAllocationDecision(unassignedShard, allocation, fetchDataResultSupplier);
import org.opensearch.cluster.routing.ShardRouting;
        Map<ShardRouting, AllocateUnassignedDecision> ineligibleShardAllocationDecisions = new HashMap<>();  
            );  
import java.util.HashSet;
/**
    @Override  
                }
            }
            if (!shardState.hasData()) {
                        initShardsFromAllocation,  
 */  
            List<ShardRouting> eligibleShards = new ArrayList<>();
                        logger.trace("skipping the shardRouting {} as the state is updated in routing table", shard);
import org.opensearch.cluster.routing.allocation.decider.Decision;
            }
        };
import java.util.ArrayList;
        List<ShardRouting> ineligibleShards,
            Map<DiscoveryNode, StoreFilesMetadata> discoveryNodeStoreFilesMetadataMap = nodeStoreFileMetaDataMapSupplier.get();  
                        nodeShardStores
import org.opensearch.core.index.shard.ShardId;  
            initReplicasFromRouting.get(r.shardId()).add(r);  
            }
     * @param allocation    the allocation state container object  
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;
        // only fetch data for eligible shards
        while (iterator.hasNext()) {
                        allocation,
                    if (shouldSkipFetchForRecovery(shard)) {
 * this file be licensed under the Apache-2.0 license or a
                    }
            return AllocateUnassignedDecision.no(  
import org.apache.logging.log4j.Logger;
        // iterate through the batches, each batch needs to be processed together as fetch call should be made for shards from same batch  
            NodeStoreFilesMetadata metadata = batch.get(unassignedShard.shardId());  
import java.util.Map;  
            // Without fetchData, decision for in-eligible shards is non-null from our preliminary checks and null for eligible shards.
    public AllocateUnassignedDecision makeAllocationDecision(ShardRouting unassignedShard, RoutingAllocation allocation, Logger logger) {
    }
        if (allocationDecision.type() != Decision.Type.YES && (!explain || !hasInitiatedFetching(shardRouting))) {
     * match. Today, a better match is one that can perform a no-op recovery while the previous recovery
                    if (cancellationAction != null) {
            initReplicasFromRouting.putIfAbsent(r.shardId(), new ArrayList<>());
        final FetchResult<NodeStoreFilesMetadataBatch> shardsState = fetchData(eligibleShards, ineligibleShards, allocation);
            return getAllocationDecision(shardRouting, allocation, discoveryNodeStoreFilesMetadataMap, result, logger);
            List<ShardRouting> ineligibleShards = new ArrayList<>();  
}
            }  
            AllocateUnassignedDecision shardDecisionWithoutFetch = getUnassignedShardAllocationDecision(shard, allocation, null);  
    ) {  
    );
                        continue;
    ) {  
        ShardRouting shard,
                    if (!initReplicasFromRouting.containsKey(shard.shardId())) {  
                fetchData(List.of(unassignedShard), Collections.emptyList(), allocation)
            shardIdsFromBatch.add(shardId);
                    // The shard's eligibility is being recomputed again as
    ) {
import org.opensearch.indices.store.TransportNodesListShardStoreMetadataHelper.StoreFilesMetadata;
            // only return early if we are not in explain mode, or we are in explain mode but we have not  
    protected FetchResult<TransportNodesListShardStoreMetadata.NodeStoreFilesMetadata> fetchData(
            return convertToNodeStoreFilesMetadataMap(  
 * SPDX-License-Identifier: Apache-2.0
                    }  
                }
    }  
                    // check if the shard is in Initializing state in RoutingTable
     * @param allocation   the overall routing allocation
                        unassignedShard,  
                eligibleShards.add(shard);  
        if (nodeStoreFileMetaDataMapSupplier != null) {
    private Map<DiscoveryNode, StoreFilesMetadata> convertToNodeStoreFilesMetadataMap(  
        if (isResponsibleFor(shardRouting) == false) {
        }
 * The OpenSearch Contributors require contributions made to  
        if (!data.hasData()) {
        }  
import org.opensearch.cluster.routing.ShardRoutingState;
     */  
        ShardRouting unassignedShard,
                executeDecision(unassignedShard, allocateUnassignedDecision, allocation, iterator);
            AsyncShardFetch.FetchResult<NodeStoreFilesMetadataBatch> shardState = fetchData(eligibleShards, ineligibleShards, allocation);  
     * Allocate Batch of unassigned shard  to nodes where valid copies of the shard already exists  
                    Runnable cancellationAction = cancelExistingRecoveryForBetterMatch(
        List<ShardRouting> ineligibleShards = new ArrayList<>();
     * Process existing recoveries of replicas and see if we need to cancel them if we find a better  
        logger.trace("Finished shard allocation execution for unassigned replica shards: {}", shardRoutings.size());
public abstract class ReplicaShardBatchAllocator extends ReplicaShardAllocator {  
import org.opensearch.indices.store.TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadataBatch;
            // for a shard with multiple unassigned replicas, hence we are comparing the shard ids
                unassignedShard,
            // yet attempted to fetch any shard data
        allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).stream().filter(r -> !r.primary()).forEach(r -> {
                    eligibleShards.add(shard);  
import java.util.Set;
            ShardRouting unassignedShard = iterator.next();
            return null;
            Map<ShardId, NodeStoreFilesMetadata> batch = value.getNodeStoreFilesMetadataBatch();
            // There will be only one entry for the shard in the unassigned shards batch  
        logger.trace("Starting shard allocation execution for unassigned replica shards: {}", shardRoutings.size());  
    }
                ineligibleShards.add(shard);  
 * @opensearch.internal
            ShardId shardId = shardRouting.shardId();  
        }  
                logger.trace("{}: fetching new stores for initializing shard batch", eligibleShards);
     */
 *
                if (ineligibleShardAllocationDecisions.containsKey(unassignedShard)) {
            }
                        shardState  
                    );
            for (ShardRouting shard : shardBatch) {
        }
                    // as the batch is not refreshed yet
                ineligibleShardAllocationDecisions.put(shard, shardDecisionWithoutFetch);
        List<ShardRouting> eligibleShards,
        final boolean explain = allocation.debugDecision();  
                }
    @Override  
     * has to copy segment files.
import org.opensearch.indices.store.TransportNodesListShardStoreMetadata;
                    allocateUnassignedDecision = getUnassignedShardAllocationDecision(
                UnassignedInfo.AllocationStatus.fromDecision(allocationDecision.type()),
                result.v2() != null ? new ArrayList<>(result.v2().values()) : null
import org.opensearch.cluster.routing.allocation.RoutingAllocation;  
 *  
        List<Runnable> shardCancellationActions = new ArrayList<>();
    }  
        RoutingAllocation allocation,
                        // shard should just be skipped for fetchData, no need to remove from batch  
import org.opensearch.gateway.AsyncShardFetch.FetchResult;
        ShardRouting shardRouting,  
        });
        Decision allocationDecision = result.v1();
import org.opensearch.cluster.routing.UnassignedInfo;  
                map.put(discoveryNode, metadata.storeFilesMetadata());
import java.util.Collections;
