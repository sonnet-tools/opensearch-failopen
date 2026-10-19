                ClusterState state = client().admin().cluster().prepareState().get().getState();
                    IndexModule.TieringState.HOT_TO_WARM.toString(),
        request.setIndex(indexName);  
    private static final int DEFAULT_TIMEOUT_SECONDS = 30;
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();
            client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
    protected void verifyIndexInWarmTier(String indexName) throws Exception {  
        return featureSettings.build();
        Map<String, Long> indexStats = indexData(1, false, INDEX_NAME);
                assertEquals("Index should have warm setting", "true", indexSettings.get(IS_WARM_INDEX_SETTING.getKey()));  
            TieringTestUtils.safeSleep(2000); // Let migration attempt start
import static org.opensearch.storage.tiering.TieringTestUtils.buildEnabledAllocationSettings;
        refreshClusterInfo();
            // Verify index returns to hot tier
 * Tests end-to-end cancellation scenarios, error cases, and complex failure conditions.
                    }  
        assertTrue("Migration should be acknowledged", response.isAcknowledged());
                    IndexModule.TieringState.HOT_TO_WARM.toString(),  
        Map<String, Long> indexStats = indexData(1, false, INDEX_NAME);
            MockTransportService mockTransportService = (MockTransportService) internalCluster().getInstance(
            .build();  
                );
            // Cancel with custom timeouts  
        startMigrationToWarm(INDEX_NAME);  
            verifyIndexInWarmTier(INDEX_NAME);  
            verifyCancellationError(INDEX_NAME, "is not currently undergoing tiering operation");
        // Need >1 dedicated cluster-manager node so a new one can be elected after the active one is killed.  
                DiscoveryNode assignedNode = state.nodes().get(assignedNodeId);
import org.opensearch.common.util.FeatureFlags;  
    }  
        }
    }
                    continue;
            .put(DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 5.0);  
        refresh(INDEX_NAME);  
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildDisabledAllocationSettings()).get();
            verifyIndexInHotTier(INDEX_NAME);
        Exception e = expectThrows(
    }
import org.opensearch.storage.action.tiering.CancelTieringRequest;
    protected void createTestIndex(String indexName, int numberOfShards, int numberOfReplicas) {  
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING;  
        return false;  
        logger.info("--> Testing hot-to-warm cancel after cluster-manager failover");
            ClusterState state = client().admin().cluster().prepareState().get().getState();
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING;
                expectedDocCount.longValue(),  
                    "Index should be in HOT_TO_WARM state",  
                assertEquals("Index should have warm setting", "true", idxSettings.get(IS_WARM_INDEX_SETTING.getKey()));
                DiscoveryNode assignedNode = state.nodes().get(assignedNodeId);
            ClusterInfoService.class,
        featureSettings.put(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG, true);  
import static org.opensearch.index.IndexModule.INDEX_TIERING_STATE;
    }  
                }  
        return Settings.builder()  
        plugins.add(MockTransportService.TestPlugin.class);
            startMigrationToWarm(INDEX_NAME);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numberOfShards)
            client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
        internalCluster().startDataOnlyNodes(numberOfReplicas + 1, settingsBuilder.build());  
    /**
            verifyCancellationError(INDEX_NAME, "is not currently undergoing tiering operation");
            }, 10, TimeUnit.SECONDS);
        } finally {  
        }
        // Index some documents  
    protected void refreshClusterInfo() {
        Long expectedDocCount = indexStats.get(TOTAL_OPERATIONS);  
            // Wait for tiering to fully complete (tieringIndices cleanup)
import org.opensearch.common.settings.Settings;
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
            );
            verifyIndexInHotTier(INDEX_NAME);
        internalCluster().startDataOnlyNodes(2, settingsBuilder.build());  
    }
            ClusterState state = client().admin().cluster().prepareState().get().getState();
        createTestIndex(INDEX_NAME, 1, 1);
                    idxSettings.get(INDEX_TIERING_STATE.getKey())
            AcknowledgedResponse response = client().admin().indices().execute(CancelTieringAction.INSTANCE, request).actionGet();  
import java.util.Collection;
        logger.info("--> Testing successful hot-to-warm migration cancellation");
            // First cancellation should succeed
            TieringTestUtils.safeSleep(2000);
        infoService.refresh();
import org.opensearch.cluster.routing.IndexRoutingTable;
            );
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
                String assignedNodeId = shardRouting.currentNodeId();
            // Disable allocation to cause stuck migration  
import org.opensearch.cluster.routing.ShardRouting;
        setupCluster(1);
            assertEquals(
    @Override
        final IndexTieringRequest request = new IndexTieringRequest("warm", indexName);
        }  
        refresh(INDEX_NAME);
    public void testCancelWithTimeoutParameters() throws Exception {  
            // Start migration  
                assertEquals(  
            assertTrue("Cancellation with timeouts should be acknowledged", response.isAcknowledged());
            verifyCancellationError(INDEX_NAME, "is not currently undergoing tiering operation");
                "Document count should be preserved",  
            .put(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "0b")
            verifyIndexInWarmTier(INDEX_NAME);  
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING;  
            for (IndexShardRoutingTable shardRoutingTable : indexRoutingTable) {
            // Verify document count unchanged
        createIndex(indexName, indexSettings);  
        }
            client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
            // Confirm it is stuck mid-migration in HOT_TO_WARM before we kill the cluster-manager.  
    }  
            );
        List<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());
import org.opensearch.storage.action.tiering.WarmToHotTierAction;
import org.opensearch.cluster.node.DiscoveryNodeRole;
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
            // Verify settings are reverted  
        }
        Long expectedDocCount = indexStats.get(TOTAL_OPERATIONS);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numberOfReplicas)  
import org.opensearch.index.IndexModule;
        }, DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);  
        assertBusy(() -> {
            refresh(INDEX_NAME);
package org.opensearch.storage.tiering;
import java.util.Map;  
        Settings.Builder settingsBuilder = Settings.builder()
        interceptCheckpointUpdates();
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;  
        Settings indexSettings = Settings.builder()
                (handler, request, channel, task) -> {
    protected final String INDEX_NAME = "cancel-test-idx";
        AcknowledgedResponse response = client().admin().indices().execute(CancelTieringAction.INSTANCE, request).actionGet();
        AcknowledgedResponse response = client().admin().indices().execute(WarmToHotTierAction.INSTANCE, request).actionGet();  
     * election) — and, as a safety net, getTieringServiceForIndex falls back to the persisted state.  
            // Try to cancel without starting migration
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
     * but rebuilds it from the persisted INDEX_TIERING_STATE (reconstructInProgressTieringRequests on
        setupCluster(1);
                    "Index should be in HOT_TO_WARM state",
                ShardRouting shardRouting = shardRoutingTable.primaryShard();  
                String assignedNodeId = shardRouting.currentNodeId();
import java.util.List;
        ByteSizeValue cacheSize = new ByteSizeValue(1, ByteSizeUnit.GB);
            IndexRoutingTable indexRoutingTable = state.routingTable().index(indexName);  
            .put(super.nodeSettings(nodeOrdinal))
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.storage.action.tiering.CancelTieringAction;  
        } finally {  
            TieringTestUtils.safeSleep(5000);
            internalCluster().getClusterManagerName()
        assertThat(e.getMessage(), containsString(expectedErrorMessage));  
        assertBusy(() -> {
     * Either way, cancel must succeed and the index must roll back cleanly to the hot tier.
            .put(CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.getKey(), "0ms")
        logger.info("--> Testing cancellation with custom timeout parameters");
                if (shardRouting.unassigned() && !shardRouting.primary()) {
            final String newClusterManager = internalCluster().getClusterManagerName();  
            // Verify index returns to hot tier  
                expectedDocCount.longValue(),  
            client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
    @Override  
        );  
        }  
        } finally {
import org.opensearch.core.common.unit.ByteSizeValue;
            // Verify migration is in progress but stuck
import org.opensearch.indices.replication.SegmentReplicationSourceService;
    public void testIdempotentCancellation() throws Exception {
    }  
/**
     * End-to-end: a hot-to-warm migration that is mid-flight (HOT_TO_WARM) must remain cancellable  
            refresh(INDEX_NAME);  
        logger.info("--> Testing idempotent cancellation (multiple cancels of same index)");  
 * compatible open source license.
 */  
    protected boolean addMockIndexStorePlugin() {
import org.opensearch.storage.action.tiering.HotToWarmTierAction;
            TieringTestUtils.safeSleep(2000);
    }
            assertEquals(
            assertNotEquals("A new cluster-manager must be elected", oldClusterManager, newClusterManager);
            assertBusy(() -> {
        Long expectedDocCount = indexStats.get(TOTAL_OPERATIONS);  
            .put(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "10b")  
            .put(CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.getKey(), "0ms")
            client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
import org.opensearch.cluster.InternalClusterInfoService;
                );
            verifyIndexInHotTier(INDEX_NAME);  
 * SPDX-License-Identifier: Apache-2.0
            request.setIndex(INDEX_NAME);
        try {
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
            IndexRoutingTable indexRoutingTable = state.routingTable().index(indexName);  
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();
                ShardRouting shardRouting = shardRoutingTable.primaryShard();  
            // Cancel the migration
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildDisabledAllocationSettings()).get();
        }, DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
            final CancelTieringRequest request = new CancelTieringRequest();
        final CancelTieringRequest request = new CancelTieringRequest();
    }  
        createTestIndex(INDEX_NAME, 1, 1);  
            startMigrationToWarm(INDEX_NAME);
            // Kill the active cluster-manager — this wipes its in-memory tieringIndices set.  
    @Override
        internalCluster().startClusterManagerOnlyNode(settingsBuilder.build());
            }, 10, TimeUnit.SECONDS);
        logger.info("--> Testing cancellation of index not being tiered");
     * after the active cluster-manager dies. The new cluster-manager loses the in-memory tiering set,
            // Complete a migration first  
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildDisabledAllocationSettings()).get();
                    IndexModule.TieringState.HOT_TO_WARM.toString(),
        try {
            // A new cluster-manager must take over (started 7 nodes, killed 1 → 6 remain).
            // Start migration (it will be stuck due to disabled allocation)
    }
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();
import org.opensearch.transport.TransportService;
                    state.metadata().index(INDEX_NAME).getSettings().get(INDEX_TIERING_STATE.getKey())  
            refresh(INDEX_NAME);  
            // Enable allocation to see the effect
            .put(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "10b")  
    }
                nodeName  
        setupCluster(1);
            assertBusy(() -> {
                Settings idxSettings = state.metadata().index(INDEX_NAME).getSettings();  
import org.opensearch.cluster.ClusterState;  
            .build();
            }
        try {
                client().prepareSearch(INDEX_NAME).setSize(0).get().getHits().getTotalHits().value()
/*  
import org.opensearch.test.transport.MockTransportService;  
        createTestIndex(INDEX_NAME, 1, 1);
            // Disable allocation so the migration gets stuck in HOT_TO_WARM (shards can't relocate to warm).
    protected boolean ignoreExternalCluster() {
                    "Index should be in WARM_TO_HOT state",
                }  
            }
        final IndexTieringRequest request = new IndexTieringRequest("hot", indexName);
                expectedDocCount.longValue(),
        createTestIndex(INDEX_NAME, 1, 1);
                client().prepareSearch(INDEX_NAME).setSize(0).get().getHits().getTotalHits().value()
            cancelTiering(INDEX_NAME);
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING;
    }
                assertEquals(
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
            client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
import org.opensearch.test.OpenSearchIntegTestCase;
            final String oldClusterManager = internalCluster().getClusterManagerName();
            // Data must be intact.
            assertBusy(() -> {
            startMigrationToWarm(INDEX_NAME);
            startMigrationToWarm(INDEX_NAME);
            for (IndexShardRoutingTable shardRoutingTable : indexRoutingTable) {
                );
            // Disable allocation to cause stuck migration  
            client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();  
                client().prepareSearch(INDEX_NAME).setSize(0).get().getHits().getTotalHits().value()
        } finally {
    @Override  
        try {  
                ClusterState state = client().admin().cluster().prepareState().get().getState();
        createTestIndex(INDEX_NAME, 1, 1);  
                        channel.sendResponse(TransportResponse.Empty.INSTANCE);
import java.util.concurrent.TimeUnit;
        createTestIndex(INDEX_NAME, 1, 1);
                TransportService.class,
            cancelTiering(INDEX_NAME);  
        setupCluster(1);  
    @Override  
import org.opensearch.cluster.ClusterInfoService;
import org.opensearch.plugins.Plugin;
            TieringTestUtils.safeSleep(2000);
            .put(DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 5.0);  
        );
        internalCluster().startClusterManagerOnlyNodes(3, settingsBuilder.build());
        internalCluster().startWarmOnlyNodes(2, settingsBuilder.build());
                    } catch (AssertionError e) {
        logger.info("--> Testing successful warm-to-hot migration cancellation");
        setupCluster(1);
            // Disable allocation to cause stuck migration
        for (String nodeName : internalCluster().getNodeNames()) {  
                assertFalse("Shard should not be on warm node", assignedNode.getRoles().contains(DiscoveryNodeRole.WARM_ROLE));  
        Settings.Builder featureSettings = Settings.builder();
        } finally {
            // The index is still persisted as HOT_TO_WARM in cluster state after failover.  
    protected void startMigrationToWarm(String indexName) {
        } finally {  
                );  
    public void testCancelAlreadyCompletedMigration() throws Exception {
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            assertFalse("index.warm setting should be removed", IS_WARM_INDEX_SETTING.get(indexSettings));
    // Helper Methods
 * Integration tests for Tier Cancel API.  
                    continue;
                Settings indexSettings = state.metadata().index(INDEX_NAME).getSettings();
        return plugins;  
            TieringTestUtils.safeSleep(2000);
            request.clusterManagerNodeTimeout("60s");
        Settings.Builder settingsBuilder = Settings.builder()
            // Start migration
     */
public class TierCancelIT extends RemoteStoreBaseIntegTestCase {
            // Start migration (it will be stuck due to disabled allocation)  
    public void testCancelWarmToHotMigrationSuccess() throws Exception {
    public void testCancelHotToWarmMigrationSucceedsAfterClusterManagerFailover() throws Exception {  
        refresh(INDEX_NAME);
        try {  
import static org.opensearch.index.store.remote.filecache.FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING;  
                    "Index should still be HOT_TO_WARM after failover",
            );  
        try {  
            // Cancel must succeed on the new cluster-manager despite the in-memory set having been lost.
                    IndexModule.TieringState.WARM_TO_HOT.toString(),
            // Disable allocation to cause stuck migration
 * The OpenSearch Contributors require contributions made to  
        internalCluster().startWarmOnlyNodes(2, settingsBuilder.build());
                SegmentReplicationSourceService.Actions.UPDATE_VISIBLE_CHECKPOINT,  
        }  
            startMigrationToHot(INDEX_NAME);
            }, 10, TimeUnit.SECONDS);
import org.opensearch.cluster.node.DiscoveryNode;  
    }  
import static org.opensearch.index.IndexModule.IS_WARM_INDEX_SETTING;
    }
import org.opensearch.core.common.unit.ByteSizeUnit;
 *
                    indexSettings.get(INDEX_TIERING_STATE.getKey())
        } finally {  
            );
            TieringTestUtils.safeSleep(2000); // Let migration attempt start  
    protected void interceptCheckpointUpdates() {
        AcknowledgedResponse response = client().admin().indices().execute(HotToWarmTierAction.INSTANCE, request).actionGet();  
            assertEquals(
            .put(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "10b")
        setupCluster(1);  
                assertFalse("Index should have warm setting", IS_WARM_INDEX_SETTING.get(indexSettings));
            // Verify cancellation worked  
import java.util.ArrayList;  
    public void testCancelIndexNotBeingTiered() {  
                }
    }
 * this file be licensed under the Apache-2.0 license or a
            }, 10, TimeUnit.SECONDS);  
            // Cancel the migration
                "Document count should be preserved",
        logger.info("--> Testing cancellation of already completed migration");  
                Settings indexSettings = state.metadata().index(INDEX_NAME).getSettings();
            startMigrationToWarm(INDEX_NAME);
                if (shardRouting.unassigned() && !shardRouting.primary()) {
import org.opensearch.core.transport.TransportResponse;  
        createTestIndex(INDEX_NAME, 1, 1);
                ClusterState state = client().admin().cluster().prepareState().get().getState();  
    }
        }
        assertTrue("Migration should be acknowledged", response.isAcknowledged());
    protected void startMigrationToHot(String indexName) {
            // Verify migration is in progress but stuck
    protected Settings featureFlagSettings() {
            // Second cancellation should fail gracefully
        TieringTestUtils.safeSleep(2000);
                assertEquals(
    }
    }  
            .put(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "0b")
                ClusterState state = client().admin().cluster().prepareState().get().getState();
        // Index some documents
            Settings indexSettings = state.metadata().index(indexName).getSettings();
        return true;
    protected Settings nodeSettings(int nodeOrdinal) {
                    indexSettings.get(INDEX_TIERING_STATE.getKey())  
            Exception.class,  
    }
            // Enable allocation to see the effect
import static org.opensearch.storage.tiering.TieringTestUtils.buildDisabledAllocationSettings;
            () -> client().admin().indices().execute(CancelTieringAction.INSTANCE, request).actionGet()
}  
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();  
    protected void cancelTiering(String indexName) {
            request.timeout("30s");  
 */
    protected void verifyIndexInHotTier(String indexName) throws Exception {  
        Map<String, Long> indexStats = indexData(1, false, INDEX_NAME);
    }
            // Enable allocation  
            TieringTestUtils.safeSleep(2000);
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildDisabledAllocationSettings()).get();
    public void testCancelHotToWarmMigrationSuccess() throws Exception {
            .put(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "10b")
                assertEquals(  
        try {  
    }  
            cancelTiering(INDEX_NAME);
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
                    try {
        request.setIndex(indexName);
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildDisabledAllocationSettings()).get();
        assertTrue("Cancellation should be acknowledged", response.isAcknowledged());
            ensureStableCluster(6);
    protected void setupCluster(int numberOfReplicas) {  
        InternalClusterInfoService infoService = (InternalClusterInfoService) internalCluster().getInstance(  
        final CancelTieringRequest request = new CancelTieringRequest();  
        interceptCheckpointUpdates();
            assertBusy(() -> {  
    }
import static org.hamcrest.Matchers.containsString;  
import org.opensearch.storage.action.tiering.IndexTieringRequest;  
            // Re-enable allocation and confirm the index rolls back cleanly to the hot tier.
            internalCluster().stopCurrentClusterManagerNode();
import org.opensearch.node.Node;  
                assertTrue("Shard should be on warm node", assignedNode.getRoles().contains(DiscoveryNodeRole.WARM_ROLE));  
                "Document count should be preserved",
    protected void verifyCancellationError(String indexName, String expectedErrorMessage) {
            cancelTiering(INDEX_NAME);
                        handler.messageReceived(request, channel, task);  
            // Try to cancel completed migration  
            mockTransportService.addRequestHandlingBehavior(
            // Verify document count unchanged  
