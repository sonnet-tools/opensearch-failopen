            assertTrue(state.metadata().getIndexSafe(indexService.index()) != null);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        @Override  
                    assertEquals("primary term can not be updated on an initializing primary shard: " + shardRouting, term, newPrimaryTerm);
                Index index = shardRouting.index();
import org.opensearch.cluster.node.DiscoveryNodes;
            if (this.shardRouting.active()) {
                ShardRouting failedShard = failedShardsCache.get(shardRouting.shardId());
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
        }  
 * the Apache License, Version 2.0 (the "License"); you may
     */
            assert indexShard != null;
            final DiscoveryNode sourceNode,
    private boolean enableRandomFailures;
            final ShardRouting shardRouting,
            if (enableRandomFailures == false) {
import static java.util.Collections.unmodifiableMap;  
            return indexService;
        private volatile ShardRouting shardRouting;  
                    }
        }  
            this.shardRouting = shardRouting;
            final DiscoveryNodes discoveryNodes,
 *  
        @Override  
        @Nullable
                    shardRouting.active()
            if (shards.containsKey(shardId) == false) {  
                assertThat("term can not be changed on an active primary shard: " + shardRouting, newTerm, equalTo(term));  
                assertTrue(  
                        fail("Shard with id " + shardRouting + " expected but missing in indicesService and failedShardsCache");
                );
/**
        @Override  
import org.opensearch.index.shard.IndexShardState;  
        }  
                        }
                                shard.routingEntry() + " isn't updated with in-sync aIDs",  
                        if (shard.routingEntry().primary() && shard.routingEntry().active()) {  
                }  
import org.opensearch.index.shard.IndexShard;
                            assertThat(shard.routingEntry(), equalTo(shardRouting));  
            return shards.get(shardId);  
                    if (enableRandomFailures == false) {
        public void updateShardState(
        public IndexShardState state() {
import org.junit.Before;
                term = newPrimaryTerm;
            if (this.shardRouting.primary()) {
            if (shardRouting.primary()) {  
import org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndices;
        public void updateMetadata(final IndexMetadata currentIndexMetadata, final IndexMetadata newIndexMetadata) {  
            }
     */
            }
                assertFalse(failedShardsCache.keySet().stream().noneMatch(shardId -> shardId.getIndex().equals(indexService.index())));  
            return term;  
                }  
                    fail("failed shard cache should not contain initializing shard routing: " + failedShardsCache.values());
            for (ShardRouting shardRouting : localRoutingNode) {  
import org.opensearch.cluster.ClusterState;
                    }  
 * You may obtain a copy of the License at  
        ConcurrentMap<ShardId, ShardRouting> failedShardsCache = indicesClusterStateService.failedShardsCache;
            final Consumer<ShardId> globalCheckpointSyncer,
                            );  
            if (hasIndex(index)) {
    /**  
        }  
            shards = unmodifiableMap(newShards);  
                ShardRouting persistedShardRouting = shard.routingEntry();
        }  
            assertThat("term can only be incremented: " + shardRouting, newTerm, greaterThanOrEqualTo(term));
        }
        @Override
        }
 * ownership. Elasticsearch licenses this file to you under  
                // initializing a shard should succeed when enableRandomFailures is disabled
        }
 * not use this file except in compliance with the License.
 */
package org.opensearch.indices.cluster;
    @Before  
                return;
        @Override  
            return shardRouting;  
                // check if we have shards of that index in failedShardsCache
            }
                    }  
            }
 * Modifications Copyright OpenSearch Contributors. See
                            assertThat(
        public RecoveryState recoveryState() {
import org.opensearch.index.shard.IndexEventListener;
            return null;
     * Mock for {@link IndicesService}
        public synchronized void removeIndex(Index index, IndexRemovalReason reason, String extraInfo) {
        private volatile Map<Integer, MockIndexShard> shards = emptyMap();
 * SPDX-License-Identifier: Apache-2.0
import java.util.function.Consumer;  
    protected class MockIndicesService implements AllocatedIndices<MockIndexShard, MockIndexService> {  
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.cluster.routing.IndexShardRoutingTable;
}
            return indexShard;
 *     http://www.apache.org/licenses/LICENSE-2.0
                }  
import java.util.Iterator;  
    }
            // check that all shards in local routing nodes have been allocated
                        assertTrue("Index " + index + " expected but missing in indicesService", indexService != null);
                        // shard has been created
                    fail("Shard with id " + persistedShardRouting + " locally exists but missing in routing table");
                    if (shard != null) {
import java.util.concurrent.ConcurrentMap;
            }  
import org.opensearch.index.IndexSettings;  
import java.util.Set;  
        }
        @Override  
 */  
        public MockIndexService(IndexSettings indexSettings) {
            HashMap<Integer, MockIndexShard> newShards = new HashMap<>(shards);  
        }
                            // initializing a shard should succeed when enableRandomFailures is disabled  
import java.util.function.BiConsumer;
            failRandomly();
        ) throws IOException {
                } else {
import org.opensearch.common.Nullable;
import org.opensearch.cluster.node.DiscoveryNode;  
            indexSettings.updateIndexMetadata(newIndexMetadata);
import org.opensearch.index.IndexService;
    }
        @Override
            RecoveryState recoveryState = new RecoveryState(shardRouting, targetNode, sourceNode);
            List<IndexEventListener> buildInIndexListener,  
                }
                    "a replica can only be promoted when active. current: " + this.shardRouting + " new: " + shardRouting,
     * Checks if cluster state matches internal state of IndicesClusterStateService instance
        }  
        @Override
            MockIndexShard indexShard = indexService.createShard(shardRouting);  
        public void updateTerm(long newTerm) {  
        @Override
                                .index(shard.shardId().getIndex())  
import org.opensearch.indices.recovery.RecoveryListener;
                MockIndexShard shard = indicesService.getShardOrNull(shardRouting.shardId());
    public void injectRandomFailures() {
 *
import java.util.HashMap;
            this.term = term;
            IndexShardRoutingTable routingTable,
            } else if (shardRouting.primary()) {  
            final MergedSegmentWarmerFactory mergedSegmentWarmerFactory,
        ) throws IOException {  
            }
        public Iterator<MockIndexShard> iterator() {
                );  
        @Override
            final RecoveryListener recoveryListener,
        public void deleteUnassignedIndex(String reason, IndexMetadata metadata, ClusterState clusterState) {
        }
 * license agreements. See the NOTICE file distributed with
        @Override
                shardsFound = true;
            for (Shard shard : indexService) {  
 */  
        }
            InterruptedException {
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.index.engine.MergedSegmentWarmerFactory;
                    "an active shard must stay active, current: " + this.shardRouting + ", got: " + shardRouting,  
import org.opensearch.core.index.Index;  
                    if (shard != null) {
                        AllocatedIndex<? extends Shard> indexService = indicesService.indexService(index);  
            final RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory,  
import org.opensearch.indices.IndicesService;
                if (failedShardsCache.values().stream().anyMatch(ShardRouting::initializing)) {
                    if (failedShard != null && failedShard.isSameAllocation(shardRouting) == false) {  
 * under the License.  
                        // shard must either be there or there must be a failure
        }
        }  
    }
import org.opensearch.indices.replication.checkpoint.SegmentReplicationCheckpointPublisher;
import org.opensearch.common.unit.TimeValue;
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
        @Override
 *
     */
        }
import org.opensearch.core.action.ActionListener;
                        if (enableRandomFailures == false || failedShard == null) {  
                            fail("Shard with id " + shardRouting + " expected but missing in indicesService " + failedShard);
            return shardRouting.shardId();
import org.opensearch.common.settings.Settings;  
import org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndex;  
 */
                shard.updateTerm(newIndexMetadata.primaryTerm(shard.shardId().id()));  
        @Override  
            final Consumer<IndexShard.ShardFailure> onShardFailure,
                fail("Index service " + indexService.index() + " should be removed from indicesService due to disabled state persistence");  
            return indices.values().iterator();
        }  
        public IndexMetadata verifyIndexIsDeleted(Index index, ClusterState state) {  
        }  
import org.opensearch.test.OpenSearchTestCase;
        public boolean updateMapping(final IndexMetadata currentIndexMetadata, final IndexMetadata newIndexMetadata) throws IOException {  
                    fail("Local shard " + persistedShardRouting + " has stale routing" + shardRouting);
        @Override  
            for (MockIndexShard shard : shards.values()) {
        public MockIndexShard(ShardRouting shardRouting, long term) {  
        @Override
            }
        public synchronized MockIndexShard createShard(ShardRouting routing) throws IOException {  
import static java.util.Collections.emptyMap;
                newIndices.remove(index.getUUID());
        if (enableRandomFailures && rarely()) {
        public Index index() {  
                            Set<String> inSyncIds = state.metadata()
import org.opensearch.indices.replication.checkpoint.ReferencedSegmentsPublisher;
            BiConsumer<IndexShard, ActionListener<ResyncTask>> primaryReplicaSyncer,
                ShardRouting shardRouting = localRoutingNode.getByShardId(persistedShardRouting.shardId());  
                        assertThat(indexService.getIndexSettings().getIndexMetadata(), equalTo(indexMetadata));
                indices = unmodifiableMap(newIndices);
 * Licensed to Elasticsearch under one or more contributor  
        for (AllocatedIndex<? extends Shard> indexService : indicesService) {
    protected void disableRandomFailures() {
 * Abstract base class for tests against {@link IndicesClusterStateService}  
            IndexMetadata indexMetadata,
 * Unless required by applicable law or agreed to in writing,
    }  
            this.shardRouting = shardRouting;
        // all other shards / indices have been cleaned up  
import static org.hamcrest.Matchers.equalTo;
                if (this.shardRouting.initializing()) {  
            final PeerRecoveryTargetService recoveryTargetService,
        }
                assertTrue(
 * The OpenSearch Contributors require contributions made to  
            return indices.containsKey(index.getUUID());  
import org.opensearch.cluster.routing.RoutingNode;  
            MockIndexShard indexShard = newShards.remove(shardId);
import org.opensearch.indices.replication.checkpoint.MergedSegmentPublisher;  
        MockIndicesService indicesService = (MockIndicesService) indicesClusterStateService.indicesService;  
/*  
            ShardRouting shardRouting,
        private volatile IndexShardRoutingTable routingTable;  
            MockIndexService indexService = new MockIndexService(new IndexSettings(indexMetadata, Settings.EMPTY));  
            return null;
                        }  
            this.term = newTerm;
                                shard.inSyncAllocationIds,
        public ShardId shardId() {  
     * @param state cluster state used for matching  
                if (shardRouting.equals(persistedShardRouting) == false) {
    }
        }
                }
            throw new RuntimeException("dummy test failure");
                // if yes, we might not have cleaned the index as failedShardsCache can be populated by another thread
            if (shardsFound == false) {  
            DiscoveryNodes discoveryNodes
                            IndexShardRoutingTable shardRoutingTable = state.routingTable().shardRoutingTable(shard.shardId());
                        fail("Shard cache has not been properly cleaned for " + failedShard);
     *
            indexShard.recoveryState = recoveryState;
    /**  
import org.opensearch.index.remote.RemoteStoreStatsTrackerFactory;
        }
            boolean shardsFound = false;
                    shardRouting.active()
 * KIND, either express or implied.  See the License for the
import java.util.List;
        public MockIndexShard getShardOrNull(int shardId) {
import org.opensearch.core.index.shard.ShardId;
            return indexSettings.getIndex();
            MockIndexService indexService = indexService(recoveryState.getShardId().getIndex());
                if (shardRouting == null) {
            final RetentionLeaseSyncer retentionLeaseSyncer,  
                IndexMetadata indexMetadata = state.metadata().getIndexSafe(index);
                if (state.blocks().disableStatePersistence()) {
            this.indexSettings = indexSettings;  
        @Override  
        public long term() {
        ) throws IOException {
        private final IndexSettings indexSettings;  
     * Mock for {@link IndexService}
                // note: it's ok for a replica in post recovery to be started and promoted at once
            Set<String> inSyncAllocationIds,  
            return indexSettings;
        enableRandomFailures = randomBoolean();
     */
 * software distributed under the License is distributed on an
        public MockIndexShard createShard(
            }  
                    }
                            );
import java.util.Map;
            return shards.values().iterator();
        }  
            failRandomly();  
            return shard;
/*  
                    }
                                equalTo(shardRoutingTable)
                        if (shard == null && shardRouting.initializing() && failedShard == shardRouting) {
 * specific language governing permissions and limitations
    protected class MockIndexShard implements IndicesClusterStateService.Shard {
    /**  
 * this work for additional information regarding copyright
                        fail("Shard with id " + shardRouting + " should be removed from indicesService due to disabled state persistence");  
                            // shard has latest shard routing
            if (shardRouting.primary() && shardRouting.active()) {
                            assertThat(
import org.opensearch.index.shard.PrimaryReplicaSyncer.ResyncTask;
import org.opensearch.indices.cluster.IndicesClusterStateService.Shard;
        }
        RoutingNode localRoutingNode = state.getRoutingNodes().node(state.getNodes().getLocalNodeId());
                        // index metadata has been updated  
            MockIndexShard shard = new MockIndexShard(routing, indexSettings.getIndexMetadata().primaryTerm(routing.shardId().id()));
        if (localRoutingNode != null) {  
import static org.opensearch.common.collect.MapBuilder.newMapBuilder;
    }  
        private volatile Set<String> inSyncAllocationIds;
import org.opensearch.indices.recovery.PeerRecoveryTargetService;  
            final MergedSegmentPublisher mergedSegmentPublisher,  
            shards = newMapBuilder(shards).put(routing.id(), shard).immutableMap();  
        @Override  
            if (state.blocks().disableStatePersistence()) {
        private volatile Map<String, MockIndexService> indices = emptyMap();
        private volatile long term;
                Map<String, MockIndexService> newIndices = new HashMap<>(indices);  
            failRandomly();
    protected void failRandomly() {  
                                shard.routingTable,  
        public synchronized void removeShard(int shardId, String reason) {
            indices = newMapBuilder(indices).put(indexMetadata.getIndexUUID(), indexService).immutableMap();
        }  
        public synchronized MockIndexService createIndex(
                        }
        @Override
        @Override
                                equalTo(inSyncIds)
        }
            long newPrimaryTerm,  
        public ShardRouting routingEntry() {
                            assertTrue("Shard with id " + shardRouting + " expected but missing in indexService", shard != null);
                // this can happen when the primary failed after we sent the start shard message
            }
            failRandomly();
                    if (shard == null && failedShard == null) {  
import org.opensearch.repositories.RepositoriesService;  
 * compatible open source license.
        }
        private boolean hasIndex(Index index) {
        public IndexSettings getIndexSettings() {
            return indices.get(index.getUUID());  
            return false;
import org.opensearch.index.seqno.RetentionLeaseSyncer;  
        }
            long applyingClusterStateVersion,
                                shard.routingEntry() + " isn't updated with routing table",
            }
    /**
        enableRandomFailures = false;  
import org.opensearch.indices.recovery.RecoveryState;
        public Iterator<MockIndexService> iterator() {
            final RepositoriesService repositoriesService,  
            final ReferencedSegmentsPublisher referencedSegmentsPublisher
                // active shards can be failed if state persistence was disabled in an earlier CS update  
        @Override
                this.inSyncAllocationIds = inSyncAllocationIds;
            final DiscoveryNode targetNode,
                this.routingTable = routingTable;  
            }  
            assertThat(this.shardId(), equalTo(shardRouting.shardId()));
            }
            assertTrue("current: " + this.shardRouting + ", got: " + shardRouting, this.shardRouting.isSameAllocation(shardRouting));  
                                .inSyncAllocationIds(shard.shardId().id());
    protected class MockIndexService implements AllocatedIndex<MockIndexShard> {  
public abstract class AbstractIndicesClusterStateServiceTestCase extends OpenSearchTestCase {
        }  
        }
        public void processPendingDeletes(Index index, IndexSettings indexSettings, TimeValue timeValue) throws IOException,  
            boolean writeDanglingIndices
    }
        private volatile RecoveryState recoveryState;
import java.io.IOException;
    public void assertClusterStateMatchesNodeState(ClusterState state, IndicesClusterStateService indicesClusterStateService) {
     * Mock for {@link IndexShard}  
                assertTrue("a primary shard can't be demoted", shardRouting.primary());
            return recoveryState;  
        public MockIndexService indexService(Index index) {
            final SegmentReplicationCheckpointPublisher checkpointPublisher,  
/*
