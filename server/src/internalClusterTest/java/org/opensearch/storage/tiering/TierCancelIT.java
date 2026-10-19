                    state.metadata().index(INDEX_NAME).getSettings().get(INDEX_TIERING_STATE.getKey())
            assertBusy(() -> {
            request.clusterManagerNodeTimeout("60s");
            TieringTestUtils.safeSleep(2000);
                String assignedNodeId = shardRouting.currentNodeId();
 */
            verifyIndexInWarmTier(INDEX_NAME);
    protected void startMigrationToHot(String indexName) {
                if (shardRouting.unassigned() && !shardRouting.primary()) {
    protected void verifyCancellationError(String indexName, String expectedErrorMessage) {
    }
            }, 10, TimeUnit.SECONDS);
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
        infoService.refresh();
            // Confirm it is stuck mid-migration in HOT_TO_WARM before we kill the cluster-manager.
            verifyIndexInHotTier(INDEX_NAME);
            }, 10, TimeUnit.SECONDS);
import org.opensearch.core.common.unit.ByteSizeValue;
        createTestIndex(INDEX_NAME, 1, 1);
            TieringTestUtils.safeSleep(2000); // Let migration attempt start
        return featureSettings.build();
            ClusterState state = client().admin().cluster().prepareState().get().getState();
                    IndexModule.TieringState.HOT_TO_WARM.toString(),
            assertNotEquals("A new cluster-manager must be elected", oldClusterManager, newClusterManager);
        featureSettings.put(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG, true);
    protected boolean ignoreExternalCluster() {
import static org.opensearch.storage.tiering.TieringTestUtils.buildDisabledAllocationSettings;
        }
                );
                assertEquals(
            client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
        logger.info("--> Testing successful warm-to-hot migration cancellation");
        logger.info("--> Testing hot-to-warm cancel after cluster-manager failover");
                Settings idxSettings = state.metadata().index(INDEX_NAME).getSettings();
            .put(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "0b")
            startMigrationToHot(INDEX_NAME);
            assertFalse("index.warm setting should be removed", IS_WARM_INDEX_SETTING.get(indexSettings));
        final CancelTieringRequest request = new CancelTieringRequest();
        interceptCheckpointUpdates();
        assertTrue("Migration should be acknowledged", response.isAcknowledged());
            // Start migration
 * The OpenSearch Contributors require contributions made to
            assertEquals(
                assertEquals(
                String assignedNodeId = shardRouting.currentNodeId();
    }
                ClusterState state = client().admin().cluster().prepareState().get().getState();
            .put(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "0b")
        Map<String, Long> indexStats = indexData(1, false, INDEX_NAME);
import org.opensearch.transport.TransportService;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numberOfReplicas)
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        AcknowledgedResponse response = client().admin().indices().execute(CancelTieringAction.INSTANCE, request).actionGet();
            // The index is still persisted as HOT_TO_WARM in cluster state after failover.
                    indexSettings.get(INDEX_TIERING_STATE.getKey())
            startMigrationToWarm(INDEX_NAME);
        assertThat(e.getMessage(), containsString(expectedErrorMessage));
            verifyIndexInHotTier(INDEX_NAME);
        Long expectedDocCount = indexStats.get(TOTAL_OPERATIONS);
 * compatible open source license.
                expectedDocCount.longValue(),
            Settings indexSettings = state.metadata().index(indexName).getSettings();
    public void testCancelIndexNotBeingTiered() {
            AcknowledgedResponse response = client().admin().indices().execute(CancelTieringAction.INSTANCE, request).actionGet();
    protected void createTestIndex(String indexName, int numberOfShards, int numberOfReplicas) {
            .put(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "10b")
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildDisabledAllocationSettings()).get();
            internalCluster().getClusterManagerName()
        AcknowledgedResponse response = client().admin().indices().execute(WarmToHotTierAction.INSTANCE, request).actionGet();
        }
                DiscoveryNode assignedNode = state.nodes().get(assignedNodeId);
                        channel.sendResponse(TransportResponse.Empty.INSTANCE);
import org.opensearch.test.OpenSearchIntegTestCase;
/*
    protected void setupCluster(int numberOfReplicas) {
            // Verify migration is in progress but stuck
            cancelTiering(INDEX_NAME);
            verifyCancellationError(INDEX_NAME, "is not currently undergoing tiering operation");
import static org.opensearch.storage.tiering.TieringTestUtils.buildEnabledAllocationSettings;
import org.opensearch.storage.action.tiering.IndexTieringRequest;
            // Wait for tiering to fully complete (tieringIndices cleanup)
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();
        }
            .put(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "10b")
            refresh(INDEX_NAME);
    public void testCancelWithTimeoutParameters() throws Exception {
                    "Index should be in HOT_TO_WARM state",
                }
            client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
            // Cancel must succeed on the new cluster-manager despite the in-memory set having been lost.
                    IndexModule.TieringState.HOT_TO_WARM.toString(),
        try {
        Long expectedDocCount = indexStats.get(TOTAL_OPERATIONS);
            cancelTiering(INDEX_NAME);
                    }
import org.opensearch.cluster.node.DiscoveryNodeRole;
            );
            // Verify migration is in progress but stuck
                ClusterState state = client().admin().cluster().prepareState().get().getState();
    protected Settings nodeSettings(int nodeOrdinal) {
            TieringTestUtils.safeSleep(5000);
        try {
                (handler, request, channel, task) -> {
            IndexRoutingTable indexRoutingTable = state.routingTable().index(indexName);
            );
            // Try to cancel completed migration
                assertTrue("Shard should be on warm node", assignedNode.getRoles().contains(DiscoveryNodeRole.WARM_ROLE));
                    try {
        AcknowledgedResponse response = client().admin().indices().execute(HotToWarmTierAction.INSTANCE, request).actionGet();
        internalCluster().startWarmOnlyNodes(2, settingsBuilder.build());
    @Override
import org.opensearch.core.transport.TransportResponse;
    // Helper Methods
    }
        createTestIndex(INDEX_NAME, 1, 1);
        createTestIndex(INDEX_NAME, 1, 1);
    }
    private static final int DEFAULT_TIMEOUT_SECONDS = 30;
            .put(CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.getKey(), "0ms")
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        assertBusy(() -> {
                    } catch (AssertionError e) {
        internalCluster().startWarmOnlyNodes(2, settingsBuilder.build());
            verifyCancellationError(INDEX_NAME, "is not currently undergoing tiering operation");
            cancelTiering(INDEX_NAME);
            startMigrationToWarm(INDEX_NAME);
import org.opensearch.indices.replication.SegmentReplicationSourceService;
        } finally {
            // Re-enable allocation and confirm the index rolls back cleanly to the hot tier.
 * Tests end-to-end cancellation scenarios, error cases, and complex failure conditions.
            // Verify document count unchanged
                ClusterState state = client().admin().cluster().prepareState().get().getState();
import org.opensearch.storage.action.tiering.WarmToHotTierAction;
                Settings indexSettings = state.metadata().index(INDEX_NAME).getSettings();
import java.util.ArrayList;
        setupCluster(1);
    protected void cancelTiering(String indexName) {
    }
            // Disable allocation to cause stuck migration
    public void testCancelWarmToHotMigrationSuccess() throws Exception {
import java.util.concurrent.TimeUnit;
package org.opensearch.storage.tiering;
                assertEquals(
        setupCluster(1);
            refresh(INDEX_NAME);
    public void testIdempotentCancellation() throws Exception {
import org.opensearch.cluster.routing.IndexRoutingTable;
            // Verify index returns to hot tier
import org.opensearch.cluster.node.DiscoveryNode;
            // Enable allocation
            cancelTiering(INDEX_NAME);
        request.setIndex(indexName);
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildDisabledAllocationSettings()).get();
    protected void interceptCheckpointUpdates() {
        Exception e = expectThrows(
            for (IndexShardRoutingTable shardRoutingTable : indexRoutingTable) {
                    "Index should still be HOT_TO_WARM after failover",
                DiscoveryNode assignedNode = state.nodes().get(assignedNodeId);
        try {
        ByteSizeValue cacheSize = new ByteSizeValue(1, ByteSizeUnit.GB);
        assertTrue("Cancellation should be acknowledged", response.isAcknowledged());
            // Cancel with custom timeouts
            .put(DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 5.0);
        logger.info("--> Testing successful hot-to-warm migration cancellation");
        interceptCheckpointUpdates();
            // Second cancellation should fail gracefully
                    "Index should be in HOT_TO_WARM state",
    }
    }
            // Data must be intact.
            client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
import java.util.Map;
            // Disable allocation to cause stuck migration
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING;
    @Override
        logger.info("--> Testing cancellation of already completed migration");
public class TierCancelIT extends RemoteStoreBaseIntegTestCase {
        refresh(INDEX_NAME);
                    continue;
import org.opensearch.cluster.routing.ShardRouting;
            request.setIndex(INDEX_NAME);
        } finally {
        createTestIndex(INDEX_NAME, 1, 1);
        setupCluster(1);
    }
    }
        }
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            // Verify cancellation worked
        Map<String, Long> indexStats = indexData(1, false, INDEX_NAME);
            internalCluster().stopCurrentClusterManagerNode();
            // Verify settings are reverted
            // A new cluster-manager must take over (started 7 nodes, killed 1 → 6 remain).
            for (IndexShardRoutingTable shardRoutingTable : indexRoutingTable) {
            request.timeout("30s");
        startMigrationToWarm(INDEX_NAME);
            .put(super.nodeSettings(nodeOrdinal))
        logger.info("--> Testing idempotent cancellation (multiple cancels of same index)");
                    IndexModule.TieringState.WARM_TO_HOT.toString(),
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
    }
import org.opensearch.test.transport.MockTransportService;
import org.opensearch.index.IndexModule;
        plugins.add(MockTransportService.TestPlugin.class);
            verifyIndexInHotTier(INDEX_NAME);
    }
            assertEquals(
            .put(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "10b")
        request.setIndex(indexName);
    }
    @Override
            () -> client().admin().indices().execute(CancelTieringAction.INSTANCE, request).actionGet()
            ensureStableCluster(6);
import org.opensearch.cluster.InternalClusterInfoService;
        } finally {
            .put(CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.getKey(), "0ms")
import org.opensearch.cluster.ClusterInfoService;
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildDisabledAllocationSettings()).get();
        try {
 */
        InternalClusterInfoService infoService = (InternalClusterInfoService) internalCluster().getInstance(
            }
     * End-to-end: a hot-to-warm migration that is mid-flight (HOT_TO_WARM) must remain cancellable
                    idxSettings.get(INDEX_TIERING_STATE.getKey())
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildDisabledAllocationSettings()).get();
        Settings.Builder settingsBuilder = Settings.builder()
                if (shardRouting.unassigned() && !shardRouting.primary()) {
                );
        refresh(INDEX_NAME);
        }, DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
            // Cancel the migration
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING;
import static org.opensearch.index.IndexModule.INDEX_TIERING_STATE;
        logger.info("--> Testing cancellation of index not being tiered");
            // Start migration
            .build();
        final CancelTieringRequest request = new CancelTieringRequest();
                assertEquals("Index should have warm setting", "true", indexSettings.get(IS_WARM_INDEX_SETTING.getKey()));
    public void testCancelAlreadyCompletedMigration() throws Exception {
            client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
            assertEquals(
        Settings.Builder featureSettings = Settings.builder();
            verifyCancellationError(INDEX_NAME, "is not currently undergoing tiering operation");
        try {
        return plugins;
            .build();
    /**
        for (String nodeName : internalCluster().getNodeNames()) {
                ClusterState state = client().admin().cluster().prepareState().get().getState();
                ShardRouting shardRouting = shardRoutingTable.primaryShard();
    }
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING;
        internalCluster().startClusterManagerOnlyNodes(3, settingsBuilder.build());
            // Kill the active cluster-manager — this wipes its in-memory tieringIndices set.
        final IndexTieringRequest request = new IndexTieringRequest("hot", indexName);
                "Document count should be preserved",
                }
            // First cancellation should succeed
            TieringTestUtils.safeSleep(2000);
        }
            refresh(INDEX_NAME);
        }, DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        internalCluster().startDataOnlyNodes(2, settingsBuilder.build());
        createTestIndex(INDEX_NAME, 1, 1);
import org.opensearch.cluster.ClusterState;
            MockTransportService mockTransportService = (MockTransportService) internalCluster().getInstance(
        } finally {
            final String oldClusterManager = internalCluster().getClusterManagerName();
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();
    }
    protected boolean addMockIndexStorePlugin() {
            // Start migration (it will be stuck due to disabled allocation)
            // Enable allocation to see the effect
            final String newClusterManager = internalCluster().getClusterManagerName();
            TieringTestUtils.safeSleep(2000);
import org.opensearch.node.Node;
            assertBusy(() -> {
            mockTransportService.addRequestHandlingBehavior(
            assertBusy(() -> {
        setupCluster(1);
                );
     * Either way, cancel must succeed and the index must roll back cleanly to the hot tier.
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING;
        Long expectedDocCount = indexStats.get(TOTAL_OPERATIONS);
            assertBusy(() -> {
                assertEquals(
            // Disable allocation to cause stuck migration
    public void testCancelHotToWarmMigrationSucceedsAfterClusterManagerFailover() throws Exception {
                "Document count should be preserved",
            .put(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "10b")
            // Complete a migration first
            TieringTestUtils.safeSleep(2000);
            final CancelTieringRequest request = new CancelTieringRequest();
        // Index some documents
import org.opensearch.cluster.metadata.IndexMetadata;
        refreshClusterInfo();
import static org.opensearch.index.IndexModule.IS_WARM_INDEX_SETTING;
/**
                SegmentReplicationSourceService.Actions.UPDATE_VISIBLE_CHECKPOINT,
        );
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();
            }, 10, TimeUnit.SECONDS);
            startMigrationToWarm(INDEX_NAME);
    }
}
                Settings indexSettings = state.metadata().index(INDEX_NAME).getSettings();
    protected void verifyIndexInWarmTier(String indexName) throws Exception {
        }
import org.opensearch.storage.action.tiering.CancelTieringRequest;
        try {
        List<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());
                assertFalse("Index should have warm setting", IS_WARM_INDEX_SETTING.get(indexSettings));
                expectedDocCount.longValue(),
            }, 10, TimeUnit.SECONDS);
 * SPDX-License-Identifier: Apache-2.0
    }
                "Document count should be preserved",
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
        } finally {
        assertBusy(() -> {
                expectedDocCount.longValue(),
            client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
                ShardRouting shardRouting = shardRoutingTable.primaryShard();
        return false;
            startMigrationToWarm(INDEX_NAME);
     * election) — and, as a safety net, getTieringServiceForIndex falls back to the persisted state.
            client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
            // Try to cancel without starting migration
        logger.info("--> Testing cancellation with custom timeout parameters");
     * but rebuilds it from the persisted INDEX_TIERING_STATE (reconstructInProgressTieringRequests on
     * after the active cluster-manager dies. The new cluster-manager loses the in-memory tiering set,
        // Need >1 dedicated cluster-manager node so a new one can be elected after the active one is killed.
            // Disable allocation to cause stuck migration
        );
        setupCluster(1);
    protected void verifyIndexInHotTier(String indexName) throws Exception {
            // Verify index returns to hot tier
        // Index some documents
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();
import org.opensearch.common.util.FeatureFlags;
import org.opensearch.plugins.Plugin;
                client().prepareSearch(INDEX_NAME).setSize(0).get().getHits().getTotalHits().value()
        createTestIndex(INDEX_NAME, 1, 1);
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
import org.opensearch.storage.action.tiering.HotToWarmTierAction;
        assertTrue("Migration should be acknowledged", response.isAcknowledged());
            ClusterState state = client().admin().cluster().prepareState().get().getState();
        setupCluster(1);
                    "Index should be in WARM_TO_HOT state",
                }
     */
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numberOfShards)
        }
            // Verify document count unchanged
            TieringTestUtils.safeSleep(2000); // Let migration attempt start
        return Settings.builder()
            startMigrationToWarm(INDEX_NAME);
            ClusterInfoService.class,
        createTestIndex(INDEX_NAME, 1, 1);
                assertEquals("Index should have warm setting", "true", idxSettings.get(IS_WARM_INDEX_SETTING.getKey()));
    protected final String INDEX_NAME = "cancel-test-idx";
    @Override
                client().prepareSearch(INDEX_NAME).setSize(0).get().getHits().getTotalHits().value()
    protected Settings featureFlagSettings() {
import org.opensearch.storage.action.tiering.CancelTieringAction;
            assertTrue("Cancellation with timeouts should be acknowledged", response.isAcknowledged());
                        handler.messageReceived(request, channel, task);
        internalCluster().startDataOnlyNodes(numberOfReplicas + 1, settingsBuilder.build());
    protected void startMigrationToWarm(String indexName) {
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildDisabledAllocationSettings()).get();
 * Integration tests for Tier Cancel API.
import static org.hamcrest.Matchers.containsString;
        }
        TieringTestUtils.safeSleep(2000);
            // Cancel the migration
    @Override
                );
            );
        return true;
    }
    }
                TransportService.class,
            // Disable allocation so the migration gets stuck in HOT_TO_WARM (shards can't relocate to warm).
        Settings indexSettings = Settings.builder()
            TieringTestUtils.safeSleep(2000);
import org.opensearch.core.common.unit.ByteSizeUnit;
            client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
    }
    }
import org.opensearch.common.settings.Settings;
import java.util.List;
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            .put(DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 5.0);
            IndexRoutingTable indexRoutingTable = state.routingTable().index(indexName);
                    indexSettings.get(INDEX_TIERING_STATE.getKey())
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
        } finally {
        try {
            verifyIndexInWarmTier(INDEX_NAME);
    public void testCancelHotToWarmMigrationSuccess() throws Exception {
        createIndex(indexName, indexSettings);
                nodeName
            );
            );
                client().prepareSearch(INDEX_NAME).setSize(0).get().getHits().getTotalHits().value()
    }
    protected void refreshClusterInfo() {
            // Enable allocation to see the effect
                    IndexModule.TieringState.HOT_TO_WARM.toString(),
        Map<String, Long> indexStats = indexData(1, false, INDEX_NAME);
            // Start migration (it will be stuck due to disabled allocation)
        final IndexTieringRequest request = new IndexTieringRequest("warm", indexName);
import java.util.Collection;
                    continue;
        refresh(INDEX_NAME);
import static org.opensearch.index.store.remote.filecache.FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING;
        internalCluster().startClusterManagerOnlyNode(settingsBuilder.build());
    }
                assertFalse("Shard should not be on warm node", assignedNode.getRoles().contains(DiscoveryNodeRole.WARM_ROLE));
            Exception.class,
        } finally {
            }
 *
        Settings.Builder settingsBuilder = Settings.builder()
