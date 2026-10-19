        }
 * The OpenSearch Contributors require contributions made to
                randomBoolean(),
                randomBoolean(),
                .shard(0)
        internalCluster().startDataOnlyNode();
        nodeWithLowerMatching = internalCluster().startNode(nodeWithLowerMatchingSettings);
        MockTransportService transportService = (MockTransportService) internalCluster().getInstance(
        );
            client().admin().indices().prepareForceMerge(indexName).get();
                    blockRecovery.await();
import org.opensearch.index.IndexSettings;
                .indices()
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            randomBoolean(),
        );
            }
                    Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            connection.sendRequest(requestId, action, request, options);
                .shards()
        assertAcked(
    }
                    .mapToObj(n -> client().prepareIndex(indexName).setSource("f", "v"))
 *
            IntStream.range(0, between(200, 500))
        );
        );
            randomBoolean(),
        ensureGreen(indexName);
                for (RetentionLease lease : shardStats.getRetentionLeaseStats().retentionLeases().leases()) {
        );
        MockTransportService transportServiceOnPrimary = (MockTransportService) internalCluster().getInstance(
        CountDownLatch blockRecovery = new CountDownLatch(1);
            randomBoolean(),
        for (RecoveryState recovery : client().admin().indices().prepareRecoveries(indexName).get().shardRecoveryStates().get(indexName)) {
        assertThat(internalCluster().nodesInclude(indexName), allOf(hasItem(nodeWithHigherMatching), not(hasItem(nodeWithLowerMatching))));
        ensureGreen(indexName);
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numberOfReplicas))
        );
        }
        Settings nodeWithReplicaSettings = internalCluster().dataPathSettings(nodeWithReplica);
                .collect(Collectors.toList())
        assertAcked(client().admin().indices().prepareCreate("dummy-index").setWaitForActiveShards(0));
                        .put(IndexSettings.FILE_BASED_RECOVERY_THRESHOLD_SETTING.getKey(), 0.5)
        transportServiceOnPrimary.clearAllRules();
                )
            client().admin()
                .mapToObj(n -> client().prepareIndex(indexName).setSource("f", "v"))
        String nodeWithPrimary = internalCluster().startNode();
            client().admin().indices().prepareForceMerge(indexName).get();
        });
            }
        }
        if (randomBoolean()) {
                .cluster()
                .cluster()
    }
            IntStream.range(0, between(0, 80))
            randomBoolean(),
/*
        );
     */
 */
            randomBoolean(),
        if (randomBoolean()) {
import org.opensearch.common.Priority;
     */
        ensureGreen(indexName);
                        .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), "100ms")
        internalCluster().ensureAtLeastNumDataNodes(1);
            client().admin()
        transportService.addSendBehavior((connection, requestId, action, request, options) -> {
        });
 * license agreements. See the NOTICE file distributed with
 *
                .prepareCreate(indexName)
        transportService.clearAllRules();
                .collect(Collectors.toList())
            if (action.equals(PeerRecoveryTargetService.Actions.TRANSLOG_OPS)) {
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .prepareUpdateSettings()
            client().admin()
                .setSettings(Settings.builder().put("index.routing.allocation.require.attr", "not-found"))
        // AllocationService only calls GatewayAllocator if there are unassigned shards
        }
        });
        CountDownLatch blockRecovery = new CountDownLatch(1);
        // AllocationService only calls GatewayAllocator if there're unassigned shards
                IntStream.range(0, between(200, 500))
                    cleanFilesRequest.recoveryId(),
                .setPersistentSettings(Settings.builder().putNull("cluster.routing.allocation.enable").build())
        client().admin().indices().prepareFlush(indexName).get();
import org.opensearch.transport.TransportService;
            client().admin()
        CountDownLatch recoveryStarted = new CountDownLatch(1);
    public void testPreferCopyWithHighestMatchingOperations() throws Exception {
            randomBoolean(),
                .collect(Collectors.toList())
                .prepareCreate("dummy-index")
        blockRecovery.countDown();
        internalCluster().fullRestart();
package org.opensearch.gateway;
        assertBusy(() -> {
        }
                .indices()
            randomBoolean(),
 * ownership. Elasticsearch licenses this file to you under
        client().admin().indices().prepareFlush(indexName).get();
                .setSettings(
            TransportService.class,
                .stream()
                        .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), "100ms")
        assertAcked(
        ensureGreen(indexName);
        assertAcked(
                .setSettings(
        );
                .map(shardRouting -> ReplicationTracker.getPeerRecoveryRetentionLeaseId(shardRouting.currentNodeId()))
        ensureGreen(indexName);
            randomBoolean(),
        );
                        .put(IndexSettings.FILE_BASED_RECOVERY_THRESHOLD_SETTING.getKey(), 0.1f)
                IntStream.range(0, between(0, 80))
import org.opensearch.test.OpenSearchIntegTestCase;
        );
    public void testFullClusterRestartPerformNoopRecovery() throws Exception {
            IntStream.range(0, between(100, 500))
            randomBoolean(),
        indexRandom(
import org.opensearch.cluster.routing.UnassignedInfo;
    /**
        indexRandom(
                randomBoolean(),
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                    Thread.currentThread().interrupt();
                .collect(Collectors.toSet());
import org.opensearch.cluster.metadata.IndexMetadata;
                .setSettings(
                    .collect(Collectors.toList())
                    cleanFilesRequest.requestSeqNo(),
                        .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "0ms")
                .mapToObj(n -> client().prepareIndex(indexName).setSource("f", "v"))
    /**
import org.opensearch.action.admin.indices.stats.ShardStats;
        });
        assertNoOpRecoveries(indexName);
                assertThat(recovery.getIndex().fileDetails(), empty());
            indexRandom(
                .prepareUpdateSettings()
                randomBoolean(),
            randomBoolean(),
        for (RecoveryState recovery : client().admin().indices().prepareRecoveries(indexName).get().shardRecoveryStates().get(indexName)) {
                    Settings.builder()
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeWithHigherMatching));
            randomBoolean(),
        if (randomBoolean()) {
 * You may obtain a copy of the License at
                .setPersistentSettings(Settings.builder().put("cluster.routing.allocation.enable", "primaries").build())
            connection.sendRequest(requestId, action, request, options);
                assertThat(recovery.getIndex().fileDetails(), not(empty()));
     * this behavior by changing the global checkpoint in phase1 to unassigned.
import org.opensearch.indices.IndicesService;
        assertAcked(
            IntStream.range(0, between(200, 500))
                .prepareUpdateSettings()
                .collect(Collectors.toList())
        ensureGreen(indexName);
     */
        );
        nodeWithReplica = internalCluster().startDataOnlyNode(nodeWithReplicaSettings);
        int numberOfReplicas = randomIntBetween(1, 2);
 * the Apache License, Version 2.0 (the "License"); you may
                .index(index)
                            .stream()
        Semaphore failRecovery = new Semaphore(1);
                .prepareUpdateSettings()
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                    }
                if (indexService != null) {
     * step. And if the recovery fails and retries, then the recovery stage might not transition properly. This test simulates
                } catch (InterruptedException e) {
        ensureActivePeerRecoveryRetentionLeasesAdvanced(indexName);
    public void testPeerRecoveryForClosedIndices() throws Exception {
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
     * won't have the safe commit after phase1 because the recovery source does not send the global checkpoint in the clean_files
            randomBoolean(),
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            );
                    Settings.builder()
                    Settings.builder()
            for (String node : internalCluster().nodesInclude(indexName)) {
                }
        client().admin().indices().prepareFlush(indexName).get();
        assertNoOpRecoveries(indexName);
            client().admin()
            client().admin().indices().prepareForceMerge(indexName).setFlush(true).get();
import org.opensearch.core.common.breaker.CircuitBreakingException;
                randomBoolean(),
import org.opensearch.index.IndexService;
                .prepareCreate(indexName)
            }
            indexRandom(
import org.opensearch.indices.recovery.RecoveryCleanFilesRequest;
                if (failRecovery.tryAcquire()) {
                    .mapToObj(n -> client().prepareIndex(indexName).setSource("f", "v"))
            assertAcked(client().admin().indices().prepareClose(indexName));
import java.util.Set;
                            .filter(lease -> activeRetentionLeaseIds.contains(lease.id()))
        DiscoveryNode discoNodeWithReplica = internalCluster().getInstance(ClusterService.class, nodeWithReplica).localNode();
                        .put(IndexSettings.FILE_BASED_RECOVERY_THRESHOLD_SETTING.getKey(), 1.0f)
            if (recovery.getPrimary() == false) {
            indexRandom(
            randomBoolean(),
import org.opensearch.test.InternalTestCluster;
                request = new RecoveryCleanFilesRequest(
                }
        internalCluster().startClusterManagerOnlyNode();
    private void assertNoOpRecoveries(String indexName) {
import static org.hamcrest.Matchers.equalTo;
        String brokenNode = internalCluster().startDataOnlyNode();
        );
        );
                    throw new CircuitBreakingException("not enough memory for indexing", 100, 50, CircuitBreaker.Durability.TRANSIENT);
            nodeWithPrimary
     * If the recovery source is on an old node (before <pre>{@code LegacyESVersion#V_7_2_0}</pre>) then the recovery target
                            .collect(Collectors.toSet());
            randomBoolean(),
                .mapToObj(n -> client().prepareIndex(indexName).setSource("f", "v"))
                try {
                        .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), "100ms")
        );
        String nodeWithPrimary = internalCluster().startNode();
    public void testPreferCopyCanPerformNoopRecovery() throws Exception {
                .collect(Collectors.toList())
                        Set<RetentionLease> activeRetentionLeases = shard.getPeerRecoveryRetentionLeases()
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                recoveryStarted.countDown();
        indexRandom(
                .setPersistentSettings(Settings.builder().putNull("cluster.routing.allocation.enable").build())
        ensureGreen(indexName);
                assertThat(recovery.getTranslog().totalLocal(), equalTo(recovery.getTranslog().totalOperations()));
            );
import org.opensearch.index.seqno.ReplicationTracker;
                .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), "100ms")
    }
        String nodeWithLowerMatching = randomFrom(internalCluster().nodesInclude(indexName));
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numOfReplicas)
        transportService.addSendBehavior((connection, requestId, action, request, options) -> {
                .routingTable()
        nodeWithHigherMatching = internalCluster().startNode(nodeWithHigherMatchingSettings);
                .prepareUpdateSettings()
            nodeWithPrimary
        return Arrays.asList(MockTransportService.TestPlugin.class, InternalSettingsPlugin.class);
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.test.transport.MockTransportService;
    /**
        );
        MockTransportService transportService = (MockTransportService) internalCluster().getInstance(TransportService.class, source);
        );
        if (randomBoolean()) {
        ensureActivePeerRecoveryRetentionLeasesAdvanced(indexName);
        assertAcked(
        newNodeStarted.countDown();
import org.opensearch.test.InternalSettingsPlugin;
        transportService.clearAllRules();
    public void testSimulateRecoverySourceOnOldNode() throws Exception {
            client().admin()
                } catch (InterruptedException e) {
        internalCluster().ensureAtLeastNumDataNodes(numOfReplicas + 2);
 * GitHub history for details.
            IntStream.range(0, between(0, 100))
        assertAcked(
        ensureYellow(indexName);
                    assertThat(lease.id(), not(equalTo(ReplicationTracker.getPeerRecoveryRetentionLeaseId(discoNodeWithReplica.getId()))));
            connection.sendRequest(requestId, action, request, options);
                .prepareUpdateSettings()
        String indexName = "test";
        internalCluster().startClusterManagerOnlyNode();
 * KIND, either express or implied.  See the License for the
        );
                .setSettings(
            randomBoolean(),
                .mapToObj(n -> client().prepareIndex(indexName).setSource("num", n))
            connection.sendRequest(requestId, action, request, options);
        recoveryStarted.await();
        }
            IntStream.range(0, between(1, 100))
        assertAcked(
                        newNodeStarted.await();
        assertThat(internalCluster().nodesInclude(indexName), hasItem(nodeWithReplica));
        ensureGreen(indexName);
        );
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        String indexName = "test";
            }
        });
 * software distributed under the License is distributed on an
        createIndex(
                        throw new AssertionError(e);
        indexRandom(
        internalCluster().fullRestart();
                false,
public class ReplicaShardAllocatorIT extends OpenSearchIntegTestCase {
                        .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), "100ms")
                IntStream.range(0, between(10, 100))
                }
    @Override
                    SequenceNumbers.UNASSIGNED_SEQ_NO
        if (randomBoolean()) {
        assertAcked(client().admin().indices().prepareClose(indexName));
 * under the License.
                )
        String nodeWithHigherMatching = randomFrom(internalCluster().nodesInclude(indexName));
                }
        ensureGreen(indexName);
                .prepareCreate(indexName)
                .indices()
            randomBoolean(),
    }
                .indices()
import java.util.concurrent.CountDownLatch;
            IntStream.range(0, between(50, 200))
                .setPersistentSettings(Settings.builder().putNull("cluster.routing.allocation.enable").build())
 * compatible open source license.
        internalCluster().startDataOnlyNode();
            for (ShardStats shardStats : client().admin().indices().prepareStats(indexName).get().getShards()) {
    }
        ensureYellow(indexName);
    public void testDoNotCancelRecoveryForBrokenNode() throws Exception {
        assertAcked(
                .indices()
                .collect(Collectors.toList())
        assertAcked(
                    throw new IllegalStateException("simulated");
                        }
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                )
                        assertThat(shard.getLastSyncedGlobalCheckpoint(), equalTo(shard.seqNoStats().getMaxSeqNo()));
                .build()
        );
            randomBoolean(),
                .indices()
                false,
        int numOfReplicas = randomIntBetween(1, 2);
        );
            }
        client().admin().indices().prepareFlush(indexName).get();
    public void testRecentPrimaryInformation() throws Exception {
        if (randomBoolean()) {
            assertAcked(client().admin().indices().prepareOpen(indexName));
        );
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeWithLowerMatching));
            if (PeerRecoveryTargetService.Actions.FILES_INFO.equals(action)) {
import java.util.stream.Collectors;
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        String newNode = internalCluster().startDataOnlyNode();
                        .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), "100ms")
            client().admin()
                    cleanFilesRequest.totalTranslogOps(),
                        .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), "100ms")
import java.util.concurrent.Semaphore;
                .setWaitForActiveShards(0)
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        // need to wait for events to ensure the reroute has happened since we perform it async when a new node joins.
            client().admin()
            randomBoolean(),
        String indexName = "test";
            IntStream.range(0, randomIntBetween(1, 100))
                .setSettings(
            randomBoolean(),
import org.opensearch.cluster.service.ClusterService;
                    }
     * Ensure that we fetch the latest shard store from the primary when a new node joins so we won't cancel the current recovery
        blockRecovery.countDown();
                    for (IndexShard shard : indexService) {
    }
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build())
            randomBoolean(),
            client().admin()
        indexRandom(
    }
                )
                try {
        indexRandom(
}
import java.util.Collection;
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        );
 * SPDX-License-Identifier: Apache-2.0
        CountDownLatch recoveryStarted = new CountDownLatch(1);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        transportServiceOnPrimary.clearAllRules();
                    } catch (InterruptedException e) {
import org.opensearch.index.seqno.RetentionLease;
import org.opensearch.plugins.Plugin;
            Set<String> activeRetentionLeaseIds = clusterService.state()
        internalCluster().startDataOnlyNode();
                .prepareUpdateSettings(indexName)
        assertThat(internalCluster().nodesInclude(indexName), hasItem(newNode));
                recoveryStarted.countDown();
        MockTransportService transportServiceOnPrimary = (MockTransportService) internalCluster().getInstance(
        indexRandom(
        String indexName = "test";
        assertNoOpRecoveries(indexName);
        }
            client().admin().indices().prepareFlush(indexName).get();
        );
        recoveryStarted.await();
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeWithReplica));
                        .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), "100ms")
                .setSettings(
                    Settings.builder()
        );
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
                        .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), "100ms")
                        .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), "100ms")
            indexName,
                .prepareUpdateSettings()
    }
            false,
                randomBoolean(),
import static org.hamcrest.Matchers.empty;
                .mapToObj(n -> client().prepareIndex(indexName).setSource("f", "v"))
                }
                .mapToObj(n -> client().prepareIndex(indexName).setSource("f", "v"))
        assertAcked(
        ensureGreen(indexName);
/*
        ensureGreen(indexName);
        client().admin().indices().prepareFlush(indexName).get();
        Settings nodeWithReplicaSettings = internalCluster().dataPathSettings(nodeWithReplica);
        Settings nodeWithHigherMatchingSettings = internalCluster().dataPathSettings(nodeWithHigherMatching);
                .prepareCreate(indexName)
                IndexService indexService = internalCluster().getInstance(IndicesService.class, node).indexService(index);
            }
            false,
    public static void ensureActivePeerRecoveryRetentionLeasesAdvanced(String indexName) throws Exception {
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        ensureActivePeerRecoveryRetentionLeasesAdvanced(indexName);
                        assertThat(activeRetentionLeases, hasSize(activeRetentionLeaseIds.size()));
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
     */
import org.opensearch.index.shard.IndexShard;
        indexRandom(
import static org.hamcrest.Matchers.hasSize;
        );
            }
        assertAcked(
        assertAcked(
        internalCluster().startDataOnlyNodes(3);
import static org.hamcrest.Matchers.allOf;
                        .put(IndexSettings.FILE_BASED_RECOVERY_THRESHOLD_SETTING.getKey(), 3.0)
            client().admin()
        }
        String indexName = "test";
                .cluster()
            client().admin()
import org.opensearch.index.seqno.SequenceNumbers;
                        .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "1ms")
    }
        assertAcked(
import java.util.stream.IntStream;
        transportServiceOnPrimary.addSendBehavior((connection, requestId, action, request, options) -> {
    }
        }
 *
        ensureGreen(indexName);
import java.util.Arrays;
            TransportService.class,
        if (randomBoolean()) {
                randomBoolean(),
                .indices()
            if (action.equals(PeerRecoveryTargetService.Actions.FINALIZE)) {
                    blockRecovery.await();
                    cleanFilesRequest.shardId(),
    /**
                }
 */
            client().admin()
                        for (RetentionLease lease : activeRetentionLeases) {
            Index index = resolveIndex(indexName);
 * Modifications Copyright OpenSearch Contributors. See
            false,
            randomBoolean(),
            false,
import org.opensearch.indices.recovery.RecoveryState;
                .prepareUpdateSettings(indexName)
                        .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), "100ms")
                .setPersistentSettings(Settings.builder().put("cluster.routing.allocation.enable", "primaries").build())
                .mapToObj(n -> client().prepareIndex(indexName).setSource("f", "v"))
            if (action.equals(PeerRecoveryTargetService.Actions.CLEAN_FILES)) {
        }
import static org.hamcrest.Matchers.hasItem;
                    Settings.builder()
        ensureGreen(indexName);
                .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), "100ms")
        String nodeWithPrimary = internalCluster().startDataOnlyNode();
        );
            IntStream.range(0, between(10, 100))
                .setPersistentSettings(Settings.builder().put("cluster.routing.allocation.enable", "primaries").build())
        internalCluster().ensureAtLeastNumDataNodes(2 + numberOfReplicas);
import static org.hamcrest.Matchers.not;
            randomBoolean(),
import org.opensearch.common.settings.Settings;
            randomBoolean(),
                        .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), randomIntBetween(10, 100) + "kb")
     * then we will cancel the current recovery and allocate replica to the new copy.
        final ClusterService clusterService = internalCluster().clusterService();
        // Index more documents and flush to destroy sync_id and remove the retention lease (as file_based_recovery_threshold reached).
        indexRandom(
        String nodeWithReplica = internalCluster().startDataOnlyNode();
            randomBoolean(),
        ensureActivePeerRecoveryRetentionLeasesAdvanced(indexName);
        );
                .prepareCreate(indexName)
        if (randomBoolean()) {
                    Thread.currentThread().interrupt();
                )
                    try {
            }
        String indexName = "test";
        ensureGreen(indexName);
 */
                .prepareCreate(indexName)
            nodeWithPrimary
        assertAcked(
                .cluster()
            randomBoolean(),
            TransportService.class,
        assertBusy(() -> {
            if (PeerRecoveryTargetService.Actions.FILES_INFO.equals(action)) {
        internalCluster().startClusterManagerOnlyNode();
            Settings.builder()
            if (recovery.getPrimary() == false) {
                .cluster()
        indexRandom(
                    cleanFilesRequest.sourceMetaSnapshot(),
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeWithReplica));
                if (brokenNode.equals(connection.getNode().getName())) {
                .collect(Collectors.toList())
                .mapToObj(n -> client().prepareIndex(indexName).setSource("f", "v"))
        assertAcked(
        String nodeWithReplica = internalCluster().startDataOnlyNode();
        internalCluster().startDataOnlyNode(nodeWithReplicaSettings);
import org.opensearch.core.index.Index;
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
            client().admin()
        transportServiceOnPrimary.addSendBehavior((connection, requestId, action, request, options) -> {
     * Make sure that we do not repeatedly cancel an ongoing recovery for a noop copy on a broken node.
        Settings nodeWithLowerMatchingSettings = internalCluster().dataPathSettings(nodeWithLowerMatching);
                        .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), randomIntBetween(10, 100) + "kb")
        CountDownLatch newNodeStarted = new CountDownLatch(1);
                .indices()
        client().admin().cluster().prepareHealth(indexName).setWaitForYellowStatus().setWaitForEvents(Priority.LANGUID).get();
                .mapToObj(n -> client().prepareIndex(indexName).setSource("f", "v"))
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
            client().admin()
                );
                .mapToObj(n -> client().prepareIndex(indexName).setSource("f", "v"))
        String source = internalCluster().startDataOnlyNode();
        String indexName = "peer_recovery_closed_indices";
                .indices()
/*
     * Verify that if we found a new copy where it can perform a no-op recovery,
            client().admin()
            randomBoolean(),
            IntStream.range(0, between(200, 500))
import org.opensearch.core.common.breaker.CircuitBreaker;
                .collect(Collectors.toList())
                    .mapToObj(n -> client().prepareIndex(indexName).setSource("f", "v"))
                RecoveryCleanFilesRequest cleanFilesRequest = (RecoveryCleanFilesRequest) request;
                .collect(Collectors.toList())
     * for the copy on the newly joined node unless we can perform a noop recovery with that node.
                    .collect(Collectors.toList())
            );
                        .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "1ms")
 * this work for additional information regarding copyright
                .setIndices(indexName)
        });
import org.opensearch.indices.recovery.PeerRecoveryTargetService;
        );
            }
        assertAcked(
                    .collect(Collectors.toList())
            client().admin()
        ensureActivePeerRecoveryRetentionLeasesAdvanced(indexName);
import org.opensearch.cluster.node.DiscoveryNode;
                .collect(Collectors.toList())
                .indices()
                )
                            assertThat(lease.retainingSequenceNumber(), equalTo(shard.getLastSyncedGlobalCheckpoint() + 1));
                .cluster()
