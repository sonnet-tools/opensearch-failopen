        }
import org.opensearch.cluster.routing.allocation.FailedShard;
        ) {
    private static final Logger logger = LogManager.getLogger(GatewayAllocator.class);
            // making the wrong decision here is not catastrophic so we only need to cover the common case.
        for (FailedShard failedShard : failedShards) {
    private static void clearCacheForPrimary(
import org.opensearch.cluster.routing.ShardRouting;
 * The OpenSearch Contributors require contributions made to
        assert primaryShardAllocator != null;
            assert primaryShardAllocator != null;
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
import org.opensearch.indices.store.TransportNodesListShardStoreMetadata;
    }
        protected boolean hasInitiatedFetching(ShardRouting shard) {
        assert primaryShardAllocator != null;
    }
    }
    @Override
        }
        }
        @Override
 * GitHub history for details.
    }
                    }
                    clusterManagerMetrics
        }
    }
        protected AsyncShardFetch.FetchResult<TransportNodesListGatewayStartedShards.NodeGatewayStartedShards> fetchData(
                    shardId,
        }
            );
/**
    @Override
        private final TransportNodesListGatewayStartedShards startedAction;
    protected GatewayAllocator() {
        protected AsyncShardFetch.FetchResult<TransportNodesListShardStoreMetadata.NodeStoreFilesMetadata> fetchData(
            asyncFetchStore.values().forEach(fetch -> clearCacheForPrimary(fetch, allocation));
        ShardRouting shardRouting,
    }
 * You may obtain a copy of the License at
    public GatewayAllocator(
        private final ClusterManagerMetrics clusterManagerMetrics;
                ActionListener.wrap(
        AsyncShardFetch<TransportNodesListShardStoreMetadata.NodeStoreFilesMetadata> fetch,
    private final ConcurrentMap<ShardId, AsyncShardFetch<TransportNodesListShardStoreMetadata.NodeStoreFilesMetadata>> asyncFetchStore =
            }
        if (unassignedShard.primary()) {
import org.opensearch.cluster.ClusterManagerMetrics;
        }
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.inject.Inject;
 *
    @Inject
                    }
import java.util.stream.StreamSupport;
            assert rerouteService != null;
                "async_shard_fetch",
            return shardStores;
        protected void reroute(String reroutingKey, String reason) {
                    r -> logger.trace("{} scheduled reroute completed for {}", reroutingKey, reason),
 * this work for additional information regarding copyright
            RoutingAllocation allocation
        }
    ) {
 * KIND, either express or implied.  See the License for the
        }
                shardState.processAllocation(allocation);
import java.util.Collections;
import java.util.Set;
 * not use this file except in compliance with the License.
            RoutingAllocation allocation
 * Licensed to Elasticsearch under one or more contributor
            this.clusterManagerMetrics = clusterManagerMetrics;
                new HashMap<>() {
                .map(node -> node.getValue().getEphemeralId())
            ShardRouting shard,
        assert fetch.shardAttributesMap.size() == 1 : "expected only one shard";
                    IndexMetadata.INDEX_DATA_PATH_SETTING.get(allocation.metadata().index(shard.index()).getSettings()),
                    e -> logger.debug(new ParameterizedMessage("{} scheduled reroute failed for {}", reroutingKey, reason), e)
                    Sets.difference(newEphemeralIds, lastSeenEphemeralIds)
            );
            .newConcurrentMap();
    private final RerouteService rerouteService;
        private final ClusterManagerMetrics clusterManagerMetrics;
    }
                )
        innerAllocatedUnassigned(allocation, primaryShardAllocator, replicaShardAllocator, shardRouting, unassignedAllocationHandler);
    private boolean hasNewNodes(DiscoveryNodes nodes) {
        assert unassignedShard.unassigned();
        assert replicaShardAllocator != null;
        DiscoveryNodes nodes = allocation.nodes();
    public void cleanCaches() {
    @Override
 * software distributed under the License is distributed on an
import org.opensearch.common.util.concurrent.ConcurrentCollections;
        RoutingAllocation allocation,
import java.util.concurrent.ConcurrentMap;
import java.util.HashMap;
    @Override
        this.rerouteService = null;
import org.apache.logging.log4j.Logger;
                shardStores.processAllocation(allocation);
                return true;
                shard.shardId(),
                    logger,
    private final PrimaryShardAllocator primaryShardAllocator;
        for (ShardRouting startedShard : startedShards) {
    }
import org.opensearch.common.Priority;
            assert replicaShardAllocator != null;
            ShardRouting shard,
    public void applyStartedShards(final List<ShardRouting> startedShards, final RoutingAllocation allocation) {
            return primaryShardAllocator.makeAllocationDecision(unassignedShard, routingAllocation, logger);
                    {
    public static final String ALLOCATOR_NAME = "gateway_allocator";
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.cluster.node.DiscoveryNodes;
            count += fetch.getNumberOfInFlightFetches();
        asyncFetchStarted.clear();
import org.opensearch.cluster.metadata.IndexMetadata;
        }
            Logger logger,
        assert replicaShardAllocator != null;
            return shardState;
/*
                )
        UnassignedAllocationHandler unassignedAllocationHandler
                    startedAction,
        assert routingAllocation.debugDecision();
    protected static void innerAllocatedUnassigned(
        for (AsyncShardFetch<TransportNodesListShardStoreMetadata.NodeStoreFilesMetadata> fetch : asyncFetchStore.values()) {
public class GatewayAllocator implements ExistingShardsAllocator {
    public void applyFailedShards(final List<FailedShard> failedShards, final RoutingAllocation allocation) {
            String customDataPath,
            this.clusterManagerMetrics = clusterManagerMetrics;
            if (lastSeenEphemeralIds.contains(node.getEphemeralId()) == false) {
            // Invalidate the cache if a data node has been added to the cluster. This ensures that we do not cancel a recovery if a node
        if (allocation.routingNodes().hasInactiveShards()) {
        InternalAsyncFetch(
 * Allocator for the gateway
            Releasables.close(asyncFetchStarted.remove(failedShard.getRoutingEntry().shardId()));
        assert replicaShardAllocator != null;
import org.opensearch.cluster.routing.allocation.ExistingShardsAllocator;
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
            );
        for (AsyncShardFetch<TransportNodesListGatewayStartedShards.NodeGatewayStartedShards> fetch : asyncFetchStarted.values()) {
 * ownership. Elasticsearch licenses this file to you under
        } else {
    class InternalReplicaShardAllocator extends ReplicaShardAllocator {
        }
    public AllocateUnassignedDecision explainUnassignedShardAllocation(ShardRouting unassignedShard, RoutingAllocation routingAllocation) {
        }
        this.replicaShardAllocator = null;
                    {
    }
        ClusterManagerMetrics clusterManagerMetrics
                () -> new ParameterizedMessage(
import org.apache.logging.log4j.message.ParameterizedMessage;
    class InternalPrimaryShardAllocator extends PrimaryShardAllocator {
import org.opensearch.action.support.nodes.BaseNodeResponse;
            rerouteService.reroute(
    public void beforeAllocation(final RoutingAllocation allocation) {
 */
            if (shardStores.hasData()) {
                )
import org.opensearch.action.support.nodes.BaseNodesResponse;
        ConcurrentCollections.newConcurrentMap();
        for (final DiscoveryNode node : nodes.getDataNodes().values()) {
            this.lastSeenEphemeralIds = newEphemeralIds;
        @Override
        return count;
        ShardId shardId = fetch.shardAttributesMap.keySet().iterator().next();
        private final TransportNodesListShardStoreMetadata storeAction;
    private Set<String> lastSeenEphemeralIds = Collections.emptySet();
                        put(shard.shardId(), allocation.getIgnoreNodes(shard.shardId()));
        }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.index.shard.ShardId;
        } else {
        RoutingAllocation allocation
                )
}
            primaryShardAllocator.allocateUnassigned(shardRouting, allocation, unassignedAllocationHandler);
                    shard.shardId(),
            // drops out, we fetch the shard data, then some indexing happens and then the node rejoins the cluster again. There are other
        @Override
    // allow for testing infra to change shard allocators implementation
                shardId -> new InternalAsyncFetch<>(
        if (primary != null) {
/*
        this.primaryShardAllocator = null;
        ) {
import org.opensearch.common.util.set.Sets;
import org.opensearch.cluster.routing.RerouteService;
import java.util.List;
        assert shardRouting.unassigned();
        RerouteService rerouteService,
        ensureAsyncFetchStorePrimaryRecency(allocation);
        }
    /**
 * compatible open source license.
     * Clear the fetched data for the primary to ensure we do not cancel recoveries based on excessively stale data.
        InternalPrimaryShardAllocator(TransportNodesListGatewayStartedShards startedAction, ClusterManagerMetrics clusterManagerMetrics) {
                new HashMap<>() {
import org.opensearch.common.lease.Releasables;
    // for tests
        if (shardRouting.primary()) {
        if (hasNewNodes(nodes)) {
            );
                }
        }
    @Override
    }
        PrimaryShardAllocator primaryShardAllocator,
                        put(shard.shardId(), allocation.getIgnoreNodes(shard.shardId()));
    }
        ExistingShardsAllocator.UnassignedAllocationHandler unassignedAllocationHandler
                shardId -> new InternalAsyncFetch<>(
        @Override
 *
    ) {
            Releasables.close(asyncFetchStore.remove(startedShard.shardId()));
    }
            this.storeAction = storeAction;
    ) {
            return replicaShardAllocator.makeAllocationDecision(unassignedShard, routingAllocation, logger);
    @Override
 * under the License.
        AsyncShardFetch<TransportNodesListGatewayStartedShards.NodeGatewayStartedShards>> asyncFetchStarted = ConcurrentCollections
 * @opensearch.internal
        }
            Releasables.close(asyncFetchStore.remove(failedShard.getRoutingEntry().shardId()));
import java.util.stream.Collectors;
    @Override
                allocation.nodes(),
            super(logger, type, shardId, customDataPath, action, clusterManagerMetrics);
    class InternalAsyncFetch<T extends BaseNodeResponse> extends AsyncShardFetch<T> {
        InternalReplicaShardAllocator(TransportNodesListShardStoreMetadata storeAction, ClusterManagerMetrics clusterManagerMetrics) {
                }
        return false;
import org.apache.logging.log4j.LogManager;
 */
            AsyncShardFetch.FetchResult<TransportNodesListGatewayStartedShards.NodeGatewayStartedShards> shardState = fetch.fetchData(
            replicaShardAllocator.processExistingRecoveries(allocation);
        this.replicaShardAllocator = new InternalReplicaShardAllocator(storeAction, clusterManagerMetrics);
    }
        Releasables.close(asyncFetchStore.values());
     */
            this.startedAction = startedAction;
            if (shardState.hasData()) {
    @Override
 * this file be licensed under the Apache-2.0 license or a
                    IndexMetadata.INDEX_DATA_PATH_SETTING.get(allocation.metadata().index(shard.index()).getSettings()),
package org.opensearch.gateway;
            logger.trace(
        int count = 0;
            // ways we could decide to cancel a recovery based on stale data (e.g. changing allocation filters or a primary failure) but
            );
 */
    ) {
 * Unless required by applicable law or agreed to in writing,
            fetch.clearCacheForNode(primary.currentNodeId());
        ) {
                allocation.nodes(),
        TransportNodesListShardStoreMetadata storeAction,
    }
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;
    public int getNumberOfInFlightFetches() {
            String type,
        ShardId,
        ReplicaShardAllocator replicaShardAllocator,
    public void allocateUnassigned(
                    "new nodes {} found, clearing primary async-fetch-store cache",
    private final ReplicaShardAllocator replicaShardAllocator;
            ShardId shardId,
 *
        final RoutingAllocation allocation,
                    "shard_started",
                    logger,
import java.util.Spliterators;
        }
            }
            logger.trace("{} scheduling reroute for {}", reroutingKey, reason);
            AsyncShardFetch<TransportNodesListShardStoreMetadata.NodeStoreFilesMetadata> fetch = asyncFetchStore.computeIfAbsent(
        TransportNodesListGatewayStartedShards startedAction,
 * the Apache License, Version 2.0 (the "License"); you may
            // recalc to also (lazily) clear out old nodes.
            Releasables.close(asyncFetchStarted.remove(startedShard.shardId()));
            ClusterManagerMetrics clusterManagerMetrics
                    clusterManagerMetrics
        asyncFetchStore.clear();
            }
        ShardRouting primary = allocation.routingNodes().activePrimary(shardId);
                Priority.HIGH,
            return asyncFetchStore.get(shard.shardId()) != null;
        this.rerouteService = rerouteService;
    private final ConcurrentMap<
            Lister<? extends BaseNodesResponse<T>, T> action,
            final Set<String> newEphemeralIds = StreamSupport.stream(Spliterators.spliterator(nodes.getDataNodes().entrySet(), 0), false)
            // cancel existing recoveries if we have a better match
    }
                    "shard_store",
    private void ensureAsyncFetchStorePrimaryRecency(RoutingAllocation allocation) {
            count += fetch.getNumberOfInFlightFetches();
 */
                    storeAction,
    public void afterPrimariesBeforeReplicas(RoutingAllocation allocation) {
import org.opensearch.core.action.ActionListener;
        this.primaryShardAllocator = new InternalPrimaryShardAllocator(startedAction, clusterManagerMetrics);
                .collect(Collectors.toSet());
        Releasables.close(asyncFetchStarted.values());
import org.opensearch.cluster.node.DiscoveryNode;
        ShardRouting shardRouting,
 *
    }
    }
                shard.shardId(),
            AsyncShardFetch.FetchResult<TransportNodesListShardStoreMetadata.NodeStoreFilesMetadata> shardStores = fetch.fetchData(
/*
            );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            AsyncShardFetch<TransportNodesListGatewayStartedShards.NodeGatewayStartedShards> fetch = asyncFetchStarted.computeIfAbsent(
            replicaShardAllocator.allocateUnassigned(shardRouting, allocation, unassignedAllocationHandler);
