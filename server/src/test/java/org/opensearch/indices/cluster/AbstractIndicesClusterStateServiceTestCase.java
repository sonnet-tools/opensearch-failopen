            this.term = newTerm;
import org.opensearch.cluster.node.DiscoveryNodes;
            this.shardRouting = shardRouting;
/*
                // active shards can be failed if state persistence was disabled in an earlier CS update
import org.opensearch.cluster.routing.RoutingNode;
            return indices.values().iterator();
import java.util.HashMap;
            assertThat("term can only be incremented: " + shardRouting, newTerm, greaterThanOrEqualTo(term));
                        fail("Shard with id " + shardRouting + " should be removed from indicesService due to disabled state persistence");
                    "a replica can only be promoted when active. current: " + this.shardRouting + " new: " + shardRouting,
        }
            if (shardRouting.primary()) {
                IndexMetadata indexMetadata = state.metadata().getIndexSafe(index);
        private volatile long term;
        private volatile IndexShardRoutingTable routingTable;
        }
        public void updateShardState(
        }
import org.opensearch.core.index.Index;
import java.util.function.BiConsumer;
                    if (enableRandomFailures == false) {
                            assertTrue("Shard with id " + shardRouting + " expected but missing in indexService", shard != null);
            return shardRouting;
        public IndexShardState state() {
                        // shard must either be there or there must be a failure
            final RetentionLeaseSyncer retentionLeaseSyncer,
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor
            // check that all shards in local routing nodes have been allocated
            MockIndexShard indexShard = indexService.createShard(shardRouting);
import org.opensearch.index.remote.RemoteStoreStatsTrackerFactory;
            }
                assertTrue("a primary shard can't be demoted", shardRouting.primary());
        @Override
        public synchronized void removeIndex(Index index, IndexRemovalReason reason, String extraInfo) {
        private volatile ShardRouting shardRouting;
            failRandomly();
 *     http://www.apache.org/licenses/LICENSE-2.0
            }
                        fail("Shard with id " + shardRouting + " expected but missing in indicesService and failedShardsCache");
            if (shardsFound == false) {
 * Unless required by applicable law or agreed to in writing,
                        if (enableRandomFailures == false || failedShard == null) {
            return indices.get(index.getUUID());
        }
     */
            indexShard.recoveryState = recoveryState;
            }
 * KIND, either express or implied.  See the License for the
                if (failedShardsCache.values().stream().anyMatch(ShardRouting::initializing)) {
                            assertThat(
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            final MergedSegmentPublisher mergedSegmentPublisher,
        }
        }
        public boolean updateMapping(final IndexMetadata currentIndexMetadata, final IndexMetadata newIndexMetadata) throws IOException {
                    fail("Shard with id " + persistedShardRouting + " locally exists but missing in routing table");
 */
        }
        @Override
                            Set<String> inSyncIds = state.metadata()
import org.opensearch.test.OpenSearchTestCase;
                    }
        public MockIndexService indexService(Index index) {
            final DiscoveryNode sourceNode,
 *
                                .index(shard.shardId().getIndex())
                                shard.routingEntry() + " isn't updated with routing table",
                }
import org.opensearch.index.seqno.RetentionLeaseSyncer;
            MockIndexService indexService = indexService(recoveryState.getShardId().getIndex());
            Set<String> inSyncAllocationIds,
        }
                            assertThat(
            final RecoveryListener recoveryListener,
import org.opensearch.index.IndexService;
                MockIndexShard shard = indicesService.getShardOrNull(shardRouting.shardId());
        for (AllocatedIndex<? extends Shard> indexService : indicesService) {
            }
            return false;
            final DiscoveryNode targetNode,
        enableRandomFailures = randomBoolean();
        }
        if (localRoutingNode != null) {
import org.opensearch.indices.recovery.RecoveryListener;
            final ReferencedSegmentsPublisher referencedSegmentsPublisher
                shard.updateTerm(newIndexMetadata.primaryTerm(shard.shardId().id()));
        }
    protected class MockIndexService implements AllocatedIndex<MockIndexShard> {
                            assertThat(shard.routingEntry(), equalTo(shardRouting));
        @Override
                        }
            this.shardRouting = shardRouting;
            MockIndexService indexService = new MockIndexService(new IndexSettings(indexMetadata, Settings.EMPTY));
        public MockIndexShard(ShardRouting shardRouting, long term) {
                );
        // all other shards / indices have been cleaned up
        ) throws IOException {
            assertTrue(state.metadata().getIndexSafe(indexService.index()) != null);
    }
import org.opensearch.index.shard.IndexEventListener;
     * Mock for {@link IndexService}
                        if (shard == null && shardRouting.initializing() && failedShard == shardRouting) {
                        }
            if (hasIndex(index)) {
        private volatile Map<Integer, MockIndexShard> shards = emptyMap();
            BiConsumer<IndexShard, ActionListener<ResyncTask>> primaryReplicaSyncer,
    @Before
            indexSettings.updateIndexMetadata(newIndexMetadata);
                    fail("Local shard " + persistedShardRouting + " has stale routing" + shardRouting);
            shards = newMapBuilder(shards).put(routing.id(), shard).immutableMap();
        }
import org.opensearch.indices.recovery.RecoveryState;
        ConcurrentMap<ShardId, ShardRouting> failedShardsCache = indicesClusterStateService.failedShardsCache;
/**
        public MockIndexShard createShard(
        public Iterator<MockIndexService> iterator() {
import static org.opensearch.common.collect.MapBuilder.newMapBuilder;
            for (MockIndexShard shard : shards.values()) {
                                shard.routingEntry() + " isn't updated with in-sync aIDs",
            failRandomly();
import java.util.Map;
            boolean shardsFound = false;
                    }
                        fail("Shard cache has not been properly cleaned for " + failedShard);
            if (state.blocks().disableStatePersistence()) {
 * compatible open source license.
        @Override
                if (shardRouting.equals(persistedShardRouting) == false) {
        @Override
/*
            return null;
        public void updateMetadata(final IndexMetadata currentIndexMetadata, final IndexMetadata newIndexMetadata) {
import java.util.concurrent.ConcurrentMap;
import org.opensearch.indices.IndicesService;
                            // initializing a shard should succeed when enableRandomFailures is disabled
 * under the License.
     * @param state cluster state used for matching
import org.opensearch.indices.cluster.IndicesClusterStateService.Shard;
                            // shard has latest shard routing
        public IndexSettings getIndexSettings() {
import org.opensearch.cluster.routing.ShardRouting;
                if (this.shardRouting.initializing()) {
        }
                            IndexShardRoutingTable shardRoutingTable = state.routingTable().shardRoutingTable(shard.shardId());
            assert indexShard != null;
                        if (shard.routingEntry().primary() && shard.routingEntry().active()) {
                }
import org.opensearch.common.Nullable;
    }
}
        }
import org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndex;
                    if (shard != null) {
import org.opensearch.core.index.shard.ShardId;
            return indices.containsKey(index.getUUID());
                // check if we have shards of that index in failedShardsCache
        }
                term = newPrimaryTerm;
import java.util.function.Consumer;
            MockIndexShard indexShard = newShards.remove(shardId);
                    }
                            );
        @Override
        }
        public synchronized MockIndexShard createShard(ShardRouting routing) throws IOException {
            long applyingClusterStateVersion,
    protected void disableRandomFailures() {
     */
            IndexMetadata indexMetadata,
            long newPrimaryTerm,
            IndexShardRoutingTable routingTable,
 * license agreements. See the NOTICE file distributed with
            final PeerRecoveryTargetService recoveryTargetService,
     * Checks if cluster state matches internal state of IndicesClusterStateService instance
import static org.hamcrest.Matchers.equalTo;
        public synchronized void removeShard(int shardId, String reason) {
        }
            assertTrue("current: " + this.shardRouting + ", got: " + shardRouting, this.shardRouting.isSameAllocation(shardRouting));
 * this file be licensed under the Apache-2.0 license or a
            if (this.shardRouting.active()) {
    public void injectRandomFailures() {
        }
                    shardRouting.active()
            }
    protected void failRandomly() {
        if (enableRandomFailures && rarely()) {
                }
        public Index index() {
        private volatile RecoveryState recoveryState;
import org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndices;
        @Override
 * You may obtain a copy of the License at
 * The OpenSearch Contributors require contributions made to
import org.junit.Before;
        @Override
            InterruptedException {
        RoutingNode localRoutingNode = state.getRoutingNodes().node(state.getNodes().getLocalNodeId());
     * Mock for {@link IndexShard}
            final Consumer<ShardId> globalCheckpointSyncer,
            return indexShard;
                        // index metadata has been updated
                ShardRouting shardRouting = localRoutingNode.getByShardId(persistedShardRouting.shardId());
                );
import org.opensearch.core.action.ActionListener;
            for (Shard shard : indexService) {
        }
                        assertTrue("Index " + index + " expected but missing in indicesService", indexService != null);
    }
                    assertEquals("primary term can not be updated on an initializing primary shard: " + shardRouting, term, newPrimaryTerm);
 *
import org.opensearch.common.unit.TimeValue;
        MockIndicesService indicesService = (MockIndicesService) indicesClusterStateService.indicesService;
        }
    protected class MockIndexShard implements IndicesClusterStateService.Shard {
                        AllocatedIndex<? extends Shard> indexService = indicesService.indexService(index);
                    if (shard == null && failedShard == null) {
            DiscoveryNodes discoveryNodes
            return term;
                ShardRouting failedShard = failedShardsCache.get(shardRouting.shardId());
import org.opensearch.cluster.ClusterState;
        @Override
                Map<String, MockIndexService> newIndices = new HashMap<>(indices);
import org.opensearch.index.shard.IndexShardState;
    }
 * GitHub history for details.
            HashMap<Integer, MockIndexShard> newShards = new HashMap<>(shards);
        ) throws IOException {
    /**
            }
import org.opensearch.indices.recovery.PeerRecoveryTargetService;
                        }
                assertTrue(
        @Override
            final Consumer<IndexShard.ShardFailure> onShardFailure,
     *
 * software distributed under the License is distributed on an
            final MergedSegmentWarmerFactory mergedSegmentWarmerFactory,
            final RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory,
                if (shardRouting == null) {
                // initializing a shard should succeed when enableRandomFailures is disabled
                    shardRouting.active()
 * not use this file except in compliance with the License.
            if (this.shardRouting.primary()) {
                                .inSyncAllocationIds(shard.shardId().id());
        public RecoveryState recoveryState() {
            final RepositoriesService repositoriesService,
        @Override
import org.opensearch.indices.replication.checkpoint.MergedSegmentPublisher;
        private boolean hasIndex(Index index) {
        public MockIndexService(IndexSettings indexSettings) {
        @Nullable
                assertFalse(failedShardsCache.keySet().stream().noneMatch(shardId -> shardId.getIndex().equals(indexService.index())));
                fail("Index service " + indexService.index() + " should be removed from indicesService due to disabled state persistence");
import org.opensearch.index.engine.MergedSegmentWarmerFactory;
        private volatile Map<String, MockIndexService> indices = emptyMap();
        private final IndexSettings indexSettings;
     * Mock for {@link IndicesService}
import org.opensearch.index.shard.PrimaryReplicaSyncer.ResyncTask;
        @Override
                    }
 *
        public void processPendingDeletes(Index index, IndexSettings indexSettings, TimeValue timeValue) throws IOException,
            if (shardRouting.primary() && shardRouting.active()) {
        public ShardId shardId() {
        @Override
                // this can happen when the primary failed after we sent the start shard message
                ShardRouting persistedShardRouting = shard.routingEntry();
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            }
            this.term = term;
        public synchronized MockIndexService createIndex(
        @Override
        enableRandomFailures = false;
import java.io.IOException;
                                equalTo(shardRoutingTable)
            return shardRouting.shardId();
                return;
            assertThat(this.shardId(), equalTo(shardRouting.shardId()));
    /**
        }
import static java.util.Collections.unmodifiableMap;
                                equalTo(inSyncIds)
                this.routingTable = routingTable;
                this.inSyncAllocationIds = inSyncAllocationIds;
                Index index = shardRouting.index();
        }
package org.opensearch.indices.cluster;
import org.opensearch.index.shard.IndexShard;
import java.util.Iterator;
            failRandomly();
            MockIndexShard shard = new MockIndexShard(routing, indexSettings.getIndexMetadata().primaryTerm(routing.shardId().id()));
        }
 */
        public MockIndexShard getShardOrNull(int shardId) {
        @Override
 */
import org.opensearch.index.IndexSettings;
    }
        ) throws IOException {
        public long term() {
            }
        public void deleteUnassignedIndex(String reason, IndexMetadata metadata, ClusterState clusterState) {
            final ShardRouting shardRouting,
                        // shard has been created
            throw new RuntimeException("dummy test failure");
            boolean writeDanglingIndices
            }
            if (shards.containsKey(shardId) == false) {
import static java.util.Collections.emptyMap;
                if (state.blocks().disableStatePersistence()) {
                newIndices.remove(index.getUUID());
                    "an active shard must stay active, current: " + this.shardRouting + ", got: " + shardRouting,
    private boolean enableRandomFailures;
                }
 * this work for additional information regarding copyright
                    if (shard != null) {
        public ShardRouting routingEntry() {
            return indexService;
            indices = newMapBuilder(indices).put(indexMetadata.getIndexUUID(), indexService).immutableMap();
        public IndexMetadata verifyIndexIsDeleted(Index index, ClusterState state) {
                                shard.routingTable,
            return indexSettings;
        private volatile Set<String> inSyncAllocationIds;
            failRandomly();
import org.opensearch.common.settings.Settings;
    protected class MockIndicesService implements AllocatedIndices<MockIndexShard, MockIndexService> {
                } else {
    /**
            return shard;
        }
                            );
import java.util.Set;
import org.opensearch.cluster.node.DiscoveryNode;
            }
                indices = unmodifiableMap(newIndices);
 * SPDX-License-Identifier: Apache-2.0
            return null;
                }
            return recoveryState;
        public Iterator<MockIndexShard> iterator() {
                // if yes, we might not have cleaned the index as failedShardsCache can be populated by another thread
                assertTrue(
import org.opensearch.indices.replication.checkpoint.SegmentReplicationCheckpointPublisher;
        @Override
            RecoveryState recoveryState = new RecoveryState(shardRouting, targetNode, sourceNode);
            shards = unmodifiableMap(newShards);
            }
        }
            for (ShardRouting shardRouting : localRoutingNode) {
        @Override
        @Override
        }
                    }
 * ownership. Elasticsearch licenses this file to you under
    }
            if (enableRandomFailures == false) {
            final DiscoveryNodes discoveryNodes,
    }
        public void updateTerm(long newTerm) {
            return indexSettings.getIndex();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    if (failedShard != null && failedShard.isSameAllocation(shardRouting) == false) {
                                shard.inSyncAllocationIds,
     */
 * the Apache License, Version 2.0 (the "License"); you may
     */
            this.indexSettings = indexSettings;
public abstract class AbstractIndicesClusterStateServiceTestCase extends OpenSearchTestCase {
            } else if (shardRouting.primary()) {
        }
 */
import java.util.List;
        }
 * Abstract base class for tests against {@link IndicesClusterStateService}
            final SegmentReplicationCheckpointPublisher checkpointPublisher,
            ShardRouting shardRouting,
        }
        @Override
            return shards.values().iterator();
        @Override
/*
                // note: it's ok for a replica in post recovery to be started and promoted at once
import org.opensearch.cluster.metadata.IndexMetadata;
 * specific language governing permissions and limitations
                assertThat("term can not be changed on an active primary shard: " + shardRouting, newTerm, equalTo(term));
            List<IndexEventListener> buildInIndexListener,
        }
import org.opensearch.repositories.RepositoriesService;
                    fail("failed shard cache should not contain initializing shard routing: " + failedShardsCache.values());
            }
                            fail("Shard with id " + shardRouting + " expected but missing in indicesService " + failedShard);
import org.opensearch.indices.replication.checkpoint.ReferencedSegmentsPublisher;
            return shards.get(shardId);
    /**
                        assertThat(indexService.getIndexSettings().getIndexMetadata(), equalTo(indexMetadata));
                shardsFound = true;
    public void assertClusterStateMatchesNodeState(ClusterState state, IndicesClusterStateService indicesClusterStateService) {
