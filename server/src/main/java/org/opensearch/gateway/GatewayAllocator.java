    class InternalReplicaShardAllocator extends ReplicaShardAllocator {  
import org.opensearch.action.support.nodes.BaseNodeResponse;
        ShardRouting shardRouting,
            String type,  
                shardId -> new InternalAsyncFetch<>(
        for (ShardRouting startedShard : startedShards) {  
        private final ClusterManagerMetrics clusterManagerMetrics;  
import org.opensearch.cluster.node.DiscoveryNodes;  
        InternalReplicaShardAllocator(TransportNodesListShardStoreMetadata storeAction, ClusterManagerMetrics clusterManagerMetrics) {
        asyncFetchStarted.clear();
                ActionListener.wrap(
import org.opensearch.action.support.nodes.BaseNodesResponse;
    }  
            // recalc to also (lazily) clear out old nodes.  
                    IndexMetadata.INDEX_DATA_PATH_SETTING.get(allocation.metadata().index(shard.index()).getSettings()),  
            replicaShardAllocator.allocateUnassigned(shardRouting, allocation, unassignedAllocationHandler);
    private boolean hasNewNodes(DiscoveryNodes nodes) {
    @Override
    }
        PrimaryShardAllocator primaryShardAllocator,
        }  
 * GitHub history for details.
                shardStores.processAllocation(allocation);
        TransportNodesListGatewayStartedShards startedAction,
 * Licensed to Elasticsearch under one or more contributor  
                    "shard_started",
            AsyncShardFetch<TransportNodesListShardStoreMetadata.NodeStoreFilesMetadata> fetch = asyncFetchStore.computeIfAbsent(  
            );
            return replicaShardAllocator.makeAllocationDecision(unassignedShard, routingAllocation, logger);  
                allocation.nodes(),  
 *
        InternalPrimaryShardAllocator(TransportNodesListGatewayStartedShards startedAction, ClusterManagerMetrics clusterManagerMetrics) {
            super(logger, type, shardId, customDataPath, action, clusterManagerMetrics);  
        AsyncShardFetch<TransportNodesListGatewayStartedShards.NodeGatewayStartedShards>> asyncFetchStarted = ConcurrentCollections
/*  
import org.opensearch.cluster.routing.RerouteService;
 * SPDX-License-Identifier: Apache-2.0
        ensureAsyncFetchStorePrimaryRecency(allocation);  
        assert replicaShardAllocator != null;
 * under the License.  
        ReplicaShardAllocator replicaShardAllocator,  
            AsyncShardFetch.FetchResult<TransportNodesListShardStoreMetadata.NodeStoreFilesMetadata> shardStores = fetch.fetchData(
    public void beforeAllocation(final RoutingAllocation allocation) {  
            String customDataPath,
            logger.trace(
import org.apache.logging.log4j.LogManager;
                    startedAction,
                    storeAction,
        @Override
                    shardId,
            replicaShardAllocator.processExistingRecoveries(allocation);
            );  
        this.replicaShardAllocator = null;
        }
    }  
    }
import java.util.HashMap;
        assert routingAllocation.debugDecision();  
                .map(node -> node.getValue().getEphemeralId())
            return shardStores;
        }
import java.util.Spliterators;
        for (AsyncShardFetch<TransportNodesListGatewayStartedShards.NodeGatewayStartedShards> fetch : asyncFetchStarted.values()) {
    }
                    r -> logger.trace("{} scheduled reroute completed for {}", reroutingKey, reason),
            }
                )  
        ExistingShardsAllocator.UnassignedAllocationHandler unassignedAllocationHandler
/*  
        }
}  
            AsyncShardFetch.FetchResult<TransportNodesListGatewayStartedShards.NodeGatewayStartedShards> shardState = fetch.fetchData(
            this.lastSeenEphemeralIds = newEphemeralIds;
        }  
                "async_shard_fetch",
            RoutingAllocation allocation
public class GatewayAllocator implements ExistingShardsAllocator {  
    public void applyFailedShards(final List<FailedShard> failedShards, final RoutingAllocation allocation) {
        for (FailedShard failedShard : failedShards) {
            }  
    // allow for testing infra to change shard allocators implementation
        Releasables.close(asyncFetchStore.values());
        assert primaryShardAllocator != null;  
        } else {
            }  
 * not use this file except in compliance with the License.
                    }
 * You may obtain a copy of the License at  
    public AllocateUnassignedDecision explainUnassignedShardAllocation(ShardRouting unassignedShard, RoutingAllocation routingAllocation) {
    private final RerouteService rerouteService;  
        asyncFetchStore.clear();  
                    IndexMetadata.INDEX_DATA_PATH_SETTING.get(allocation.metadata().index(shard.index()).getSettings()),  
            // cancel existing recoveries if we have a better match
        this.primaryShardAllocator = new InternalPrimaryShardAllocator(startedAction, clusterManagerMetrics);  
            this.clusterManagerMetrics = clusterManagerMetrics;
            Releasables.close(asyncFetchStarted.remove(startedShard.shardId()));
            Releasables.close(asyncFetchStarted.remove(failedShard.getRoutingEntry().shardId()));  
        ShardRouting primary = allocation.routingNodes().activePrimary(shardId);
import org.apache.logging.log4j.Logger;
    ) {
            );
                    }
            Lister<? extends BaseNodesResponse<T>, T> action,  
 * compatible open source license.
        this.rerouteService = null;
        this.replicaShardAllocator = new InternalReplicaShardAllocator(storeAction, clusterManagerMetrics);
            ShardRouting shard,  
 * software distributed under the License is distributed on an
 */
        InternalAsyncFetch(
        ShardRouting shardRouting,
    private final ConcurrentMap<
        protected AsyncShardFetch.FetchResult<TransportNodesListShardStoreMetadata.NodeStoreFilesMetadata> fetchData(
                    {
        private final ClusterManagerMetrics clusterManagerMetrics;  
 * @opensearch.internal
 * ownership. Elasticsearch licenses this file to you under  
        if (primary != null) {  
            );
            logger.trace("{} scheduling reroute for {}", reroutingKey, reason);
        ShardId,  
    class InternalAsyncFetch<T extends BaseNodeResponse> extends AsyncShardFetch<T> {
 */  
        @Override
        private final TransportNodesListShardStoreMetadata storeAction;
        innerAllocatedUnassigned(allocation, primaryShardAllocator, replicaShardAllocator, shardRouting, unassignedAllocationHandler);
    ) {
                )
    protected GatewayAllocator() {
        return count;
import java.util.List;  
        this.rerouteService = rerouteService;
import org.opensearch.cluster.routing.allocation.RoutingAllocation;  
    }
import java.util.stream.StreamSupport;
                    "new nodes {} found, clearing primary async-fetch-store cache",
            count += fetch.getNumberOfInFlightFetches();
    /**
    @Inject
        }
    }
        }
import org.opensearch.cluster.routing.allocation.ExistingShardsAllocator;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                Priority.HIGH,  
        @Override  
        protected AsyncShardFetch.FetchResult<TransportNodesListGatewayStartedShards.NodeGatewayStartedShards> fetchData(
                shardId -> new InternalAsyncFetch<>(
        protected void reroute(String reroutingKey, String reason) {
                )  
 *
            Releasables.close(asyncFetchStore.remove(failedShard.getRoutingEntry().shardId()));
    private void ensureAsyncFetchStorePrimaryRecency(RoutingAllocation allocation) {
import org.apache.logging.log4j.message.ParameterizedMessage;  
            ClusterManagerMetrics clusterManagerMetrics
    private Set<String> lastSeenEphemeralIds = Collections.emptySet();
            .newConcurrentMap();
        if (allocation.routingNodes().hasInactiveShards()) {  
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.lease.Releasables;  
        DiscoveryNodes nodes = allocation.nodes();
import org.opensearch.core.index.shard.ShardId;
                .collect(Collectors.toSet());  
            if (lastSeenEphemeralIds.contains(node.getEphemeralId()) == false) {
    public int getNumberOfInFlightFetches() {
import java.util.Collections;
        }
        assert primaryShardAllocator != null;
        }  
        protected boolean hasInitiatedFetching(ShardRouting shard) {
    public void cleanCaches() {
        ClusterManagerMetrics clusterManagerMetrics  
     */  
            return shardState;
                shard.shardId(),
                allocation.nodes(),  
    private final PrimaryShardAllocator primaryShardAllocator;
        for (AsyncShardFetch<TransportNodesListShardStoreMetadata.NodeStoreFilesMetadata> fetch : asyncFetchStore.values()) {
        UnassignedAllocationHandler unassignedAllocationHandler
    }  
    ) {
import org.opensearch.cluster.routing.ShardRouting;
                    shard.shardId(),
                    "shard_store",
            assert primaryShardAllocator != null;
        AsyncShardFetch<TransportNodesListShardStoreMetadata.NodeStoreFilesMetadata> fetch,  
                    Sets.difference(newEphemeralIds, lastSeenEphemeralIds)
 */  
        private final TransportNodesListGatewayStartedShards startedAction;
    class InternalPrimaryShardAllocator extends PrimaryShardAllocator {  
        int count = 0;  
    @Override  
 *  
        this.primaryShardAllocator = null;  
                    clusterManagerMetrics
/*
    }
            final Set<String> newEphemeralIds = StreamSupport.stream(Spliterators.spliterator(nodes.getDataNodes().entrySet(), 0), false)
                    e -> logger.debug(new ParameterizedMessage("{} scheduled reroute failed for {}", reroutingKey, reason), e)  
    // for tests  
            return primaryShardAllocator.makeAllocationDecision(unassignedShard, routingAllocation, logger);  
                    logger,  
            ShardId shardId,
    }
        }
    private final ReplicaShardAllocator replicaShardAllocator;  
            assert replicaShardAllocator != null;
    }
        ConcurrentCollections.newConcurrentMap();
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.cluster.ClusterManagerMetrics;  
    }
        if (shardRouting.primary()) {
                return true;
                shardState.processAllocation(allocation);  
        RoutingAllocation allocation,
     * Clear the fetched data for the primary to ensure we do not cancel recoveries based on excessively stale data.
                () -> new ParameterizedMessage(  
    }
        RoutingAllocation allocation
                        put(shard.shardId(), allocation.getIgnoreNodes(shard.shardId()));  
                }
 * KIND, either express or implied.  See the License for the
        }
            fetch.clearCacheForNode(primary.currentNodeId());
            return asyncFetchStore.get(shard.shardId()) != null;  
 * Allocator for the gateway
 * The OpenSearch Contributors require contributions made to  
    @Override
            AsyncShardFetch<TransportNodesListGatewayStartedShards.NodeGatewayStartedShards> fetch = asyncFetchStarted.computeIfAbsent(  
    @Override
 * license agreements. See the NOTICE file distributed with
        final RoutingAllocation allocation,  
            // making the wrong decision here is not catastrophic so we only need to cover the common case.
/**
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;  
import org.opensearch.core.action.ActionListener;  
            assert rerouteService != null;  
    @Override  
        for (final DiscoveryNode node : nodes.getDataNodes().values()) {  
import org.opensearch.cluster.routing.allocation.FailedShard;
                }
        }  
            if (shardStores.hasData()) {
        assert fetch.shardAttributesMap.size() == 1 : "expected only one shard";  
            primaryShardAllocator.allocateUnassigned(shardRouting, allocation, unassignedAllocationHandler);  
    }
import java.util.stream.Collectors;
    public void afterPrimariesBeforeReplicas(RoutingAllocation allocation) {
                new HashMap<>() {
 * this work for additional information regarding copyright
    ) {  
    private static final Logger logger = LogManager.getLogger(GatewayAllocator.class);
    private static void clearCacheForPrimary(
    }  
        assert replicaShardAllocator != null;
 * specific language governing permissions and limitations
                new HashMap<>() {
    }
            );
        TransportNodesListShardStoreMetadata storeAction,
                    logger,  
import org.opensearch.common.Priority;
        }  
            if (shardState.hasData()) {
        RerouteService rerouteService,  
            asyncFetchStore.values().forEach(fetch -> clearCacheForPrimary(fetch, allocation));
        if (hasNewNodes(nodes)) {  
    public static final String ALLOCATOR_NAME = "gateway_allocator";
            this.storeAction = storeAction;  
import org.opensearch.cluster.node.DiscoveryNode;
        if (unassignedShard.primary()) {
 *  
            ShardRouting shard,  
            );  
    public GatewayAllocator(
 */
            rerouteService.reroute(
 * Unless required by applicable law or agreed to in writing,
                    clusterManagerMetrics
                )  
            this.startedAction = startedAction;  
        Releasables.close(asyncFetchStarted.values());  
        ) {
        }  
        }
        }  
    private final ConcurrentMap<ShardId, AsyncShardFetch<TransportNodesListShardStoreMetadata.NodeStoreFilesMetadata>> asyncFetchStore =  
            // Invalidate the cache if a data node has been added to the cluster. This ensures that we do not cancel a recovery if a node
    protected static void innerAllocatedUnassigned(  
    public void applyStartedShards(final List<ShardRouting> startedShards, final RoutingAllocation allocation) {
import org.opensearch.indices.store.TransportNodesListShardStoreMetadata;
import org.opensearch.common.inject.Inject;
        ) {
        assert replicaShardAllocator != null;
import org.opensearch.common.util.set.Sets;
import org.opensearch.cluster.metadata.IndexMetadata;
            Logger logger,
import java.util.concurrent.ConcurrentMap;  
                    {
                shard.shardId(),
        @Override
        assert shardRouting.unassigned();
        assert unassignedShard.unassigned();
            count += fetch.getNumberOfInFlightFetches();
        return false;
            // drops out, we fetch the shard data, then some indexing happens and then the node rejoins the cluster again. There are other
            Releasables.close(asyncFetchStore.remove(startedShard.shardId()));
        ShardId shardId = fetch.shardAttributesMap.keySet().iterator().next();
        ) {
import java.util.Set;
    }  
        } else {
package org.opensearch.gateway;
            // ways we could decide to cancel a recovery based on stale data (e.g. changing allocation filters or a primary failure) but  
import org.opensearch.common.util.concurrent.ConcurrentCollections;
        }
    @Override
                        put(shard.shardId(), allocation.getIgnoreNodes(shard.shardId()));  
    public void allocateUnassigned(
            RoutingAllocation allocation
    @Override  
 * this file be licensed under the Apache-2.0 license or a
            this.clusterManagerMetrics = clusterManagerMetrics;
