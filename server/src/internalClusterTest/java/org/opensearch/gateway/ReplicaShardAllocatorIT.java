        if (randomBoolean()) {
        client().admin().indices().prepareFlush(indexName).get();  
     */
                    blockRecovery.await();
                    cleanFilesRequest.shardId(),
            if (action.equals(PeerRecoveryTargetService.Actions.TRANSLOG_OPS)) {
            randomBoolean(),
        String indexName = "test";  
        internalCluster().startDataOnlyNode();  
        indexRandom(
                .prepareUpdateSettings(indexName)
import org.opensearch.test.OpenSearchIntegTestCase;  
        DiscoveryNode discoNodeWithReplica = internalCluster().getInstance(ClusterService.class, nodeWithReplica).localNode();
        String indexName = "test";
        MockTransportService transportServiceOnPrimary = (MockTransportService) internalCluster().getInstance(
            TransportService.class,
                )
        ensureYellow(indexName);  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeWithReplica));
        );
        assertAcked(client().admin().indices().prepareClose(indexName));
            }
        indexRandom(
            connection.sendRequest(requestId, action, request, options);  
                .setWaitForActiveShards(0)
        }  
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
     */
                .shards()  
                        .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), "100ms")
            client().admin()
        internalCluster().ensureAtLeastNumDataNodes(1);
                .setSettings(  
        nodeWithLowerMatching = internalCluster().startNode(nodeWithLowerMatchingSettings);  
                .collect(Collectors.toList())
import org.opensearch.index.IndexSettings;  
    }
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
            randomBoolean(),
                    }
    /**  
            randomBoolean(),
     * step. And if the recovery fails and retries, then the recovery stage might not transition properly. This test simulates
                try {
import java.util.Arrays;
        assertAcked(  
            if (action.equals(PeerRecoveryTargetService.Actions.FINALIZE)) {
import org.opensearch.cluster.routing.UnassignedInfo;
                .setIndices(indexName)  
            connection.sendRequest(requestId, action, request, options);
                .indices()  
                .indices()
                .stream()
                    Settings.builder()  
            randomBoolean(),
 *
            nodeWithPrimary
                            .collect(Collectors.toSet());  
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        ensureGreen(indexName);  
    /**
                .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), "100ms")
        CountDownLatch blockRecovery = new CountDownLatch(1);  
                        .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), "100ms")
                .routingTable()  
 *
        blockRecovery.countDown();
            IntStream.range(0, between(0, 80))  
                        .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), "100ms")
import org.opensearch.cluster.metadata.IndexMetadata;
                .mapToObj(n -> client().prepareIndex(indexName).setSource("f", "v"))  
        }
                .prepareUpdateSettings()
        });
            }
        String indexName = "test";
                    Settings.builder()
        assertThat(internalCluster().nodesInclude(indexName), allOf(hasItem(nodeWithHigherMatching), not(hasItem(nodeWithLowerMatching))));  
        indexRandom(
            indexRandom(
        assertAcked(
        client().admin().cluster().prepareHealth(indexName).setWaitForYellowStatus().setWaitForEvents(Priority.LANGUID).get();
        internalCluster().startClusterManagerOnlyNode();
        ensureGreen(indexName);
                randomBoolean(),
                .prepareCreate(indexName)  
        internalCluster().startDataOnlyNode(nodeWithReplicaSettings);
        );  
        internalCluster().startDataOnlyNode();
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        int numOfReplicas = randomIntBetween(1, 2);
                    .mapToObj(n -> client().prepareIndex(indexName).setSource("f", "v"))  
        assertAcked(  
        CountDownLatch blockRecovery = new CountDownLatch(1);
        String indexName = "test";
        // Index more documents and flush to destroy sync_id and remove the retention lease (as file_based_recovery_threshold reached).
import java.util.stream.IntStream;
            }  
public class ReplicaShardAllocatorIT extends OpenSearchIntegTestCase {  
        assertAcked(
 * this file be licensed under the Apache-2.0 license or a
            client().admin()
                .prepareUpdateSettings()
                .mapToObj(n -> client().prepareIndex(indexName).setSource("f", "v"))
                    Thread.currentThread().interrupt();  
    private void assertNoOpRecoveries(String indexName) {
                        .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), randomIntBetween(10, 100) + "kb")
                assertThat(recovery.getIndex().fileDetails(), empty());
                    }
                .cluster()  
                .prepareUpdateSettings()
                .collect(Collectors.toList())  
        if (randomBoolean()) {
            randomBoolean(),  
import static org.hamcrest.Matchers.hasItem;
        transportService.clearAllRules();
                    SequenceNumbers.UNASSIGNED_SEQ_NO
        ensureGreen(indexName);
        transportServiceOnPrimary.clearAllRules();  
                .prepareUpdateSettings()  
                try {  
                    cleanFilesRequest.totalTranslogOps(),  
            if (recovery.getPrimary() == false) {
                randomBoolean(),  
        ensureActivePeerRecoveryRetentionLeasesAdvanced(indexName);
                            .stream()
            IntStream.range(0, between(0, 100))
                .indices()
            Settings.builder()
 *  
     * for the copy on the newly joined node unless we can perform a noop recovery with that node.
import org.opensearch.common.Priority;  
        assertAcked(
            IntStream.range(0, between(1, 100))
                .prepareCreate("dummy-index")
 * not use this file except in compliance with the License.
                    .mapToObj(n -> client().prepareIndex(indexName).setSource("f", "v"))
        ensureGreen(indexName);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            );  
        transportServiceOnPrimary.addSendBehavior((connection, requestId, action, request, options) -> {  
        );
    }
        ensureActivePeerRecoveryRetentionLeasesAdvanced(indexName);
            );
                .setSettings(  
/*
            if (action.equals(PeerRecoveryTargetService.Actions.CLEAN_FILES)) {
                        .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "1ms")  
        internalCluster().startClusterManagerOnlyNode();
        });
        }  
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;  
                .prepareUpdateSettings()
import org.opensearch.test.InternalSettingsPlugin;
    }  
        );
                        .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), randomIntBetween(10, 100) + "kb")  
            client().admin()
                    for (IndexShard shard : indexService) {
            randomBoolean(),
            client().admin()
        if (randomBoolean()) {
                        .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), "100ms")
                .prepareCreate(indexName)
 * Modifications Copyright OpenSearch Contributors. See
                .setSettings(Settings.builder().put("index.routing.allocation.require.attr", "not-found"))  
        String nodeWithPrimary = internalCluster().startDataOnlyNode();
            client().admin()  
        );
                    blockRecovery.await();
                    try {
                .mapToObj(n -> client().prepareIndex(indexName).setSource("num", n))
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            if (PeerRecoveryTargetService.Actions.FILES_INFO.equals(action)) {
                .prepareUpdateSettings(indexName)
                randomBoolean(),  
    }
import java.util.stream.Collectors;  
 * The OpenSearch Contributors require contributions made to  
            randomBoolean(),
        int numberOfReplicas = randomIntBetween(1, 2);  
                .setSettings(
        );
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeWithLowerMatching));  
        internalCluster().fullRestart();
            randomBoolean(),  
                    .collect(Collectors.toList())  
 * You may obtain a copy of the License at  
            }
                .mapToObj(n -> client().prepareIndex(indexName).setSource("f", "v"))  
                    cleanFilesRequest.requestSeqNo(),  
import org.opensearch.common.settings.Settings;
        }
                        assertThat(shard.getLastSyncedGlobalCheckpoint(), equalTo(shard.seqNoStats().getMaxSeqNo()));
        assertBusy(() -> {
            client().admin()
        Settings nodeWithHigherMatchingSettings = internalCluster().dataPathSettings(nodeWithHigherMatching);
 * GitHub history for details.
            IntStream.range(0, between(200, 500))
            for (String node : internalCluster().nodesInclude(indexName)) {
            IntStream.range(0, between(50, 200))  
import org.opensearch.cluster.service.ClusterService;
 * specific language governing permissions and limitations
     * Ensure that we fetch the latest shard store from the primary when a new node joins so we won't cancel the current recovery
     */
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numberOfReplicas))  
            Index index = resolveIndex(indexName);
    public void testDoNotCancelRecoveryForBrokenNode() throws Exception {  
import org.opensearch.indices.IndicesService;
    public void testFullClusterRestartPerformNoopRecovery() throws Exception {
        for (RecoveryState recovery : client().admin().indices().prepareRecoveries(indexName).get().shardRecoveryStates().get(indexName)) {  
        internalCluster().startDataOnlyNode();
                .collect(Collectors.toList())
        CountDownLatch newNodeStarted = new CountDownLatch(1);  
            nodeWithPrimary
        );  
                }
        ensureGreen(indexName);
        internalCluster().ensureAtLeastNumDataNodes(2 + numberOfReplicas);
        ensureGreen(indexName);
            false,
        recoveryStarted.await();
            randomBoolean(),
        }  
                .cluster()
                }
                        .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), "100ms")  
            connection.sendRequest(requestId, action, request, options);  
        ensureActivePeerRecoveryRetentionLeasesAdvanced(indexName);  
    }  
                        .put(IndexSettings.FILE_BASED_RECOVERY_THRESHOLD_SETTING.getKey(), 0.1f)  
                        .put(IndexSettings.FILE_BASED_RECOVERY_THRESHOLD_SETTING.getKey(), 3.0)  
    @Override
            client().admin()
import org.opensearch.index.IndexService;
            indexRandom(
        );
        ensureActivePeerRecoveryRetentionLeasesAdvanced(indexName);
                .collect(Collectors.toList())
                .cluster()  
            randomBoolean(),  
import org.opensearch.index.seqno.RetentionLease;
            if (PeerRecoveryTargetService.Actions.FILES_INFO.equals(action)) {
        indexRandom(
                false,
import org.opensearch.action.admin.indices.stats.ShardStats;
        String nodeWithPrimary = internalCluster().startNode();  
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
    }
     * Verify that if we found a new copy where it can perform a no-op recovery,
                .setPersistentSettings(Settings.builder().put("cluster.routing.allocation.enable", "primaries").build())
                randomBoolean(),
                .cluster()
        assertAcked(
            client().admin()
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))  
                .mapToObj(n -> client().prepareIndex(indexName).setSource("f", "v"))
                            assertThat(lease.retainingSequenceNumber(), equalTo(shard.getLastSyncedGlobalCheckpoint() + 1));  
        ensureActivePeerRecoveryRetentionLeasesAdvanced(indexName);
                .setPersistentSettings(Settings.builder().put("cluster.routing.allocation.enable", "primaries").build())  
        Settings nodeWithReplicaSettings = internalCluster().dataPathSettings(nodeWithReplica);
                IntStream.range(0, between(200, 500))
    }  
 * software distributed under the License is distributed on an
                randomBoolean(),
                    .mapToObj(n -> client().prepareIndex(indexName).setSource("f", "v"))
            randomBoolean(),
     * If the recovery source is on an old node (before <pre>{@code LegacyESVersion#V_7_2_0}</pre>) then the recovery target  
                .prepareCreate(indexName)  
                    Settings.builder()
            indexName,  
        }
        indexRandom(  
 * under the License.  
import org.opensearch.plugins.Plugin;  
            IntStream.range(0, between(100, 500))
        );
 * KIND, either express or implied.  See the License for the
        assertAcked(
/*  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                    Thread.currentThread().interrupt();
            randomBoolean(),
                if (brokenNode.equals(connection.getNode().getName())) {  
                .collect(Collectors.toList())
                .indices()
        String source = internalCluster().startDataOnlyNode();
                    Settings.builder()  
 */  
        String nodeWithReplica = internalCluster().startDataOnlyNode();
            randomBoolean(),  
        transportService.addSendBehavior((connection, requestId, action, request, options) -> {
            client().admin()  
                .setSettings(
import java.util.concurrent.Semaphore;
                    .collect(Collectors.toList())
        if (randomBoolean()) {
            IntStream.range(0, randomIntBetween(1, 100))  
     * then we will cancel the current recovery and allocate replica to the new copy.  
            client().admin().indices().prepareForceMerge(indexName).get();
        String brokenNode = internalCluster().startDataOnlyNode();
        );
            client().admin()  
                .shard(0)
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .collect(Collectors.toList())
        );  
        );
            randomBoolean(),
        createIndex(
import java.util.Set;  
     */  
package org.opensearch.gateway;
        ensureGreen(indexName);  
        for (RecoveryState recovery : client().admin().indices().prepareRecoveries(indexName).get().shardRecoveryStates().get(indexName)) {
                }  
        // AllocationService only calls GatewayAllocator if there are unassigned shards  
        internalCluster().startClusterManagerOnlyNode();  
import org.opensearch.core.common.breaker.CircuitBreaker;
                randomBoolean(),  
                .setSettings(
                .collect(Collectors.toList())
        return Arrays.asList(MockTransportService.TestPlugin.class, InternalSettingsPlugin.class);
        assertAcked(
        assertAcked(
            assertAcked(client().admin().indices().prepareClose(indexName));  
            }  
            );
        MockTransportService transportServiceOnPrimary = (MockTransportService) internalCluster().getInstance(  
                .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), "100ms")
 *    http://www.apache.org/licenses/LICENSE-2.0
                        }
            }
            randomBoolean(),  
        indexRandom(
        });
                RecoveryCleanFilesRequest cleanFilesRequest = (RecoveryCleanFilesRequest) request;  
        // need to wait for events to ensure the reroute has happened since we perform it async when a new node joins.  
        transportService.addSendBehavior((connection, requestId, action, request, options) -> {
        internalCluster().fullRestart();
import org.opensearch.index.seqno.SequenceNumbers;  
            randomBoolean(),  
        String indexName = "peer_recovery_closed_indices";  
        }
                .mapToObj(n -> client().prepareIndex(indexName).setSource("f", "v"))
        assertAcked(
            randomBoolean(),
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
                false,
        Semaphore failRecovery = new Semaphore(1);  
import org.opensearch.transport.TransportService;
    public void testPreferCopyWithHighestMatchingOperations() throws Exception {
                .collect(Collectors.toList())
 * license agreements. See the NOTICE file distributed with
        );
        transportService.clearAllRules();
        recoveryStarted.await();  
                .mapToObj(n -> client().prepareIndex(indexName).setSource("f", "v"))
        }  
                        Set<RetentionLease> activeRetentionLeases = shard.getPeerRecoveryRetentionLeases()  
                )
    }
                }
            randomBoolean(),
            nodeWithPrimary
            false,
        ensureGreen(indexName);
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numOfReplicas)
                .setPersistentSettings(Settings.builder().putNull("cluster.routing.allocation.enable").build())
                }
                        .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), "100ms")
        );
                        .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), "100ms")  
                        .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), "100ms")
        final ClusterService clusterService = internalCluster().clusterService();
                .indices()
            client().admin()  
            IntStream.range(0, between(200, 500))
                .mapToObj(n -> client().prepareIndex(indexName).setSource("f", "v"))  
        assertAcked(
                .map(shardRouting -> ReplicationTracker.getPeerRecoveryRetentionLeaseId(shardRouting.currentNodeId()))
        String nodeWithReplica = internalCluster().startDataOnlyNode();  
    public static void ensureActivePeerRecoveryRetentionLeasesAdvanced(String indexName) throws Exception {
            randomBoolean(),
                    assertThat(lease.id(), not(equalTo(ReplicationTracker.getPeerRecoveryRetentionLeaseId(discoNodeWithReplica.getId()))));
        );  
            randomBoolean(),  
                IntStream.range(0, between(0, 80))  
                .setPersistentSettings(Settings.builder().putNull("cluster.routing.allocation.enable").build())
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeWithReplica));  
            }
                request = new RecoveryCleanFilesRequest(
            if (recovery.getPrimary() == false) {  
            client().admin().indices().prepareFlush(indexName).get();
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                .indices()  
                .collect(Collectors.toSet());  
        nodeWithHigherMatching = internalCluster().startNode(nodeWithHigherMatchingSettings);
        String nodeWithLowerMatching = randomFrom(internalCluster().nodesInclude(indexName));
                            .filter(lease -> activeRetentionLeaseIds.contains(lease.id()))
        MockTransportService transportService = (MockTransportService) internalCluster().getInstance(TransportService.class, source);
        String nodeWithHigherMatching = randomFrom(internalCluster().nodesInclude(indexName));  
        assertThat(internalCluster().nodesInclude(indexName), hasItem(newNode));
        });
        String newNode = internalCluster().startDataOnlyNode();
import org.opensearch.indices.recovery.PeerRecoveryTargetService;  
                .setPersistentSettings(Settings.builder().put("cluster.routing.allocation.enable", "primaries").build())
        indexRandom(
     * won't have the safe commit after phase1 because the recovery source does not send the global checkpoint in the clean_files
                .prepareCreate(indexName)
                )  
            client().admin()
        );
            Set<String> activeRetentionLeaseIds = clusterService.state()
            IntStream.range(0, between(200, 500))  
                .prepareCreate(indexName)
                        .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), "100ms")  
                        assertThat(activeRetentionLeases, hasSize(activeRetentionLeaseIds.size()));
            client().admin()  
        if (randomBoolean()) {  
        ensureGreen(indexName);
            IntStream.range(0, between(10, 100))  
                .mapToObj(n -> client().prepareIndex(indexName).setSource("f", "v"))
                .prepareCreate(indexName)
        assertNoOpRecoveries(indexName);
        assertAcked(
        transportServiceOnPrimary.clearAllRules();
            assertAcked(client().admin().indices().prepareOpen(indexName));
            for (ShardStats shardStats : client().admin().indices().prepareStats(indexName).get().getShards()) {  
                        throw new AssertionError(e);
    public void testPeerRecoveryForClosedIndices() throws Exception {
        );  
        // AllocationService only calls GatewayAllocator if there're unassigned shards  
                    throw new IllegalStateException("simulated");  
        assertNoOpRecoveries(indexName);
        ensureGreen(indexName);  
        );  
import org.opensearch.index.shard.IndexShard;
                assertThat(recovery.getIndex().fileDetails(), not(empty()));
        );  
        CountDownLatch recoveryStarted = new CountDownLatch(1);
                .cluster()  
                recoveryStarted.countDown();  
import org.opensearch.indices.recovery.RecoveryState;
        assertAcked(
                .indices()  
import org.opensearch.core.index.Index;
        assertAcked(
            client().admin()
                        for (RetentionLease lease : activeRetentionLeases) {
            randomBoolean(),  
                )
                    cleanFilesRequest.recoveryId(),
            randomBoolean(),
            randomBoolean(),
                    } catch (InterruptedException e) {  
        CountDownLatch recoveryStarted = new CountDownLatch(1);
        if (randomBoolean()) {
        ensureYellow(indexName);
        });
        );  
            connection.sendRequest(requestId, action, request, options);  
                )
        indexRandom(  
        );  
        client().admin().indices().prepareFlush(indexName).get();
        assertThat(internalCluster().nodesInclude(indexName), hasItem(nodeWithReplica));  
                .prepareUpdateSettings()
                        newNodeStarted.await();
            client().admin()  
import static org.hamcrest.Matchers.empty;
                    cleanFilesRequest.sourceMetaSnapshot(),
                .collect(Collectors.toList())
        );
            client().admin().indices().prepareForceMerge(indexName).setFlush(true).get();
import static org.hamcrest.Matchers.not;  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeWithHigherMatching));
        client().admin().indices().prepareFlush(indexName).get();  
        blockRecovery.countDown();
 */
                .build()  
                .setPersistentSettings(Settings.builder().putNull("cluster.routing.allocation.enable").build())  
        MockTransportService transportService = (MockTransportService) internalCluster().getInstance(
            randomBoolean(),  
    /**  
                IndexService indexService = internalCluster().getInstance(IndicesService.class, node).indexService(index);
                .indices()
 * SPDX-License-Identifier: Apache-2.0
            }
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        client().admin().indices().prepareFlush(indexName).get();  
        internalCluster().startDataOnlyNodes(3);
        assertAcked(client().admin().indices().prepareCreate("dummy-index").setWaitForActiveShards(0));
 * Unless required by applicable law or agreed to in writing,
                randomBoolean(),
                .indices()
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
                    throw new CircuitBreakingException("not enough memory for indexing", 100, 50, CircuitBreaker.Durability.TRANSIENT);  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        });
            TransportService.class,  
        transportServiceOnPrimary.addSendBehavior((connection, requestId, action, request, options) -> {
                    Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                        .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "0ms")
 */  
            randomBoolean(),  
        Settings nodeWithLowerMatchingSettings = internalCluster().dataPathSettings(nodeWithLowerMatching);
    public void testRecentPrimaryInformation() throws Exception {
        assertNoOpRecoveries(indexName);
    }  
        indexRandom(
        ensureGreen(indexName);  
                .prepareUpdateSettings()
            false,
        String nodeWithPrimary = internalCluster().startNode();
                .mapToObj(n -> client().prepareIndex(indexName).setSource("f", "v"))
     * this behavior by changing the global checkpoint in phase1 to unassigned.  
        if (randomBoolean()) {
        String indexName = "test";  
                .indices()
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
/*  
            client().admin().indices().prepareForceMerge(indexName).get();
        indexRandom(
        assertAcked(
                        .put(IndexSettings.FILE_BASED_RECOVERY_THRESHOLD_SETTING.getKey(), 1.0f)
        String indexName = "test";  
        newNodeStarted.countDown();  
        );  
                } catch (InterruptedException e) {  
                } catch (InterruptedException e) {
 * ownership. Elasticsearch licenses this file to you under  
                        .put(IndexSettings.FILE_BASED_RECOVERY_THRESHOLD_SETTING.getKey(), 0.5)
        );
 * Licensed to Elasticsearch under one or more contributor  
        if (randomBoolean()) {  
        Settings nodeWithReplicaSettings = internalCluster().dataPathSettings(nodeWithReplica);
import static org.hamcrest.Matchers.hasSize;
                    .collect(Collectors.toList())
                if (indexService != null) {  
        );
import org.opensearch.test.transport.MockTransportService;
        ensureGreen(indexName);
            false,
import org.opensearch.index.seqno.ReplicationTracker;
                for (RetentionLease lease : shardStats.getRetentionLeaseStats().retentionLeases().leases()) {
    }  
 * this work for additional information regarding copyright
                .index(index)
import java.util.Collection;
    public void testSimulateRecoverySourceOnOldNode() throws Exception {
        );
                recoveryStarted.countDown();
        internalCluster().ensureAtLeastNumDataNodes(numOfReplicas + 2);  
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build())
import org.opensearch.cluster.node.DiscoveryNode;  
        nodeWithReplica = internalCluster().startDataOnlyNode(nodeWithReplicaSettings);
            TransportService.class,  
        );
        );
import java.util.concurrent.CountDownLatch;
            indexRandom(  
        assertAcked(  
                .cluster()
                        .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), "100ms")  
        }  
                .setSettings(
                );
                .collect(Collectors.toList())  
                        .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "1ms")
import org.opensearch.test.InternalTestCluster;
import org.opensearch.indices.recovery.RecoveryCleanFilesRequest;
                assertThat(recovery.getTranslog().totalLocal(), equalTo(recovery.getTranslog().totalOperations()));  
        );  
                }  
                )
        ensureGreen(indexName);
     * Make sure that we do not repeatedly cancel an ongoing recovery for a noop copy on a broken node.
 * compatible open source license.
        );  
        ensureGreen(indexName);
            }
            client().admin()  
                IntStream.range(0, between(10, 100))
            randomBoolean(),
 * the Apache License, Version 2.0 (the "License"); you may
                if (failRecovery.tryAcquire()) {
        assertBusy(() -> {  
    public void testPreferCopyCanPerformNoopRecovery() throws Exception {
}
    /**
        }  
        client().admin().indices().prepareFlush(indexName).get();
                    Settings.builder()
import org.opensearch.core.common.breaker.CircuitBreakingException;  
