        indicesToMigrate.put("test-1", "warm");
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
}
        return Stream.concat(
import org.opensearch.storage.action.tiering.status.model.GetTieringStatusResponse;
        Map<String, Object> expectedSettings = isWarm
                currentSettings.get(entry.getKey())
        setupCluster(1);
        ensureGreen(indexName);
            assertEquals(targetTier.toUpperCase(Locale.ROOT), tieringStatusResponse.getTieringStatus().getTarget());
    }
        createIndex(indexName, indexSettings);
    protected void interceptCheckpointUpdates() {
    @AwaitsFix(bugUrl = "Flaky test - fix before enabling")
        expectedResponse.put(LIST_TIERING_STATUS_TARGET_WARM_TIER, 2);
        for (Map.Entry<String, String> entry : indicesToTargetTier.entrySet()) {
import org.opensearch.storage.action.tiering.status.GetTieringStatusAction;
import org.opensearch.core.transport.TransportResponse;
    ) throws Exception {
import org.opensearch.cluster.ClusterStateListener;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numberOfShards)
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.test.OpenSearchIntegTestCase;
        verifyTieringStatusResponse(new ListTieringStatusRequest("WARM"), expectedCounts.get(LIST_TIERING_STATUS_TARGET_WARM_TIER));
            .build();
        logger.info("Updating cluster setting to pause recoveries");
        return false;
        }
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
 * The OpenSearch Contributors require contributions made to
        interceptCheckpointUpdates();
    protected boolean ignoreExternalCluster() {
            Stream.of(MockInternalClusterInfoService.TestPlugin.class, MockTransportService.TestPlugin.class)
        return Settings.builder()
        for (Map.Entry<String, String> entry : indexToTargetTier.entrySet()) {
                nodeName
import java.util.Map;
        for (IndexShardRoutingTable shardRoutingTable : indexRoutingTable) {
        Map<String, Integer> expectedListTieringResponseCount
                        verifyIndexSettings(index, false);
            MockTransportService mockTransportService = (MockTransportService) internalCluster().getInstance(
        return Settings.builder().put(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG, true).build();
    protected void initiateStuckMigrationToGetStatus(
            ClusterStateListener listener = new TieringTestUtils.MockTieringCompletionListener(migrationLatch, index, targetTier);
import org.opensearch.core.common.unit.ByteSizeValue;
import static org.opensearch.storage.tiering.TieringTestUtils.buildDisabledAllocationSettings;
    }
    private static final String LIST_TIERING_STATUS_NO_FILTER_KEY = "noFilter";
    protected static final String TIERING_IN_PROGRESS_STATUS = "RUNNING_SHARD_RELOCATION";
        waitForReplication(indexName);
            listeners.add(listener);
import java.util.ArrayList;
        }
                }
    @Override
                    try {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numberOfReplicas)
            }
    }
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                    String index = entry.getKey();
                .indices()
        initiateStuckMigrationToGetStatus(indicesToMigrate, expectedResponse);
    @Override
                entry.getValue().toString(),
            );
    private static final String LIST_TIERING_STATUS_TARGET_WARM_TIER = "warmTier";
        }
        String[] indices = new String[] { "test-1", "test-2", "test-3", "test-4" };
import java.util.concurrent.TimeUnit;
import org.opensearch.storage.action.tiering.WarmToHotTierAction;
 */
    protected void setupCluster(int numberOfReplicas) {
    @Override
import org.opensearch.storage.action.tiering.status.ListTieringStatusAction;
        } catch (Exception e) {
        for (Map.Entry<String, Object> entry : expectedSettings.entrySet()) {
        waitForMigrationCompletion(indexToTargetTier);
        }
        expectedResponse.put(LIST_TIERING_STATUS_NO_FILTER_KEY, 2);
            final GetTieringStatusRequest getTieringStatusRequest = new GetTieringStatusRequest(index);
            super.nodePlugins().stream(),
        // Cleanup
        indicesToMigrate.put("test-3", "warm");
            throw new RuntimeException(e);
 * compatible open source license.
            );
                SegmentReplicationSourceService.Actions.UPDATE_VISIBLE_CHECKPOINT,
        for (String index : indices) {
            String assignedNodeId = primaryShard.currentNodeId();
            }, DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        expectedResponse.put(LIST_TIERING_STATUS_TARGET_HOT_TIER, 2);
                    String targetTier = entry.getValue();
        expectedResponse.clear();
    }
import org.opensearch.cluster.metadata.IndexMetadata;
            String index = entry.getKey();
        if (expectedCount > 0) {
        verifyTieringStatusResponse(new ListTieringStatusRequest("HOT"), expectedCounts.get(LIST_TIERING_STATUS_TARGET_HOT_TIER));
import java.util.HashMap;
        assertEquals(expectedCount, response.getTieringStatusList().size());
            assertNotEquals(targetTier.toUpperCase(Locale.ROOT), tieringStatusResponse.getTieringStatus().getSource());
    protected boolean addMockIndexStorePlugin() {
            verifyListTieringStatus(expectedListTieringResponseCount);
import java.util.stream.Stream;
    @Override
            if (onWarmNodes) {
        internalCluster().startWarmOnlyNodes(2);
    protected void assertIndexShardLocation(String indexName, boolean onWarmNodes) {
        expectedResponse.put(LIST_TIERING_STATUS_NO_FILTER_KEY, 4);
            createTestIndex(index, 1, 1);
        Settings indexSettings = Settings.builder()
            for (Map.Entry<String, String> entry : indexToTargetTier.entrySet()) {
        return true;
                assertTrue("Shard should be on warm node", assignedNode.getRoles().contains(DiscoveryNodeRole.WARM_ROLE));
    protected void verifyTieringStatusResponse(ListTieringStatusRequest request, int expectedCount) {
import org.opensearch.storage.action.tiering.HotToWarmTierAction;
        // Second migration -> initiate H2W for 2 indices and W2H for rest indices
                    }
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
        }
        }
        indicesToMigrate.put("test-4", "warm");
import org.opensearch.cluster.node.DiscoveryNodeRole;
                    .indices()
import org.opensearch.cluster.MockInternalClusterInfoService;
        Map<String, String> indicesToMigrate = new HashMap<>();
        for (String nodeName : internalCluster().getNodeNames()) {
    private static final String LIST_TIERING_STATUS_TARGET_HOT_TIER = "hotTier";
    public void testTieringStatus() throws Exception {
            String targetTier = entry.getValue();
                    .actionGet();
        Map<String, String> indexToTargetTier,
    }
            clusterService().addListener(listener);
import java.util.List;
                        assertIndexShardLocation(index, true);
                }
                "Incorrect value for setting: " + entry.getKey(),
            );
        initiateStuckMigrationToGetStatus(indicesToMigrate, expectedResponse);
                    } catch (AssertionError e) {
import org.opensearch.storage.action.tiering.status.model.ListTieringStatusResponse;
            assertEquals(
    private static final int DEFAULT_TIMEOUT_SECONDS = 30;
        expectedResponse.put(LIST_TIERING_STATUS_TARGET_WARM_TIER, 2);
        internalCluster().startDataOnlyNodes(numberOfReplicas + 1);
    }
            ? TieringTestUtils.getExpectedWarmIndexSettings()
    }
                    } else {
    protected Settings featureFlagSettings() {
import org.opensearch.cluster.ClusterState;
    protected void verifyIndexSettings(String indexName, boolean isWarm) {
import static org.opensearch.storage.tiering.TieringTestUtils.buildEnabledAllocationSettings;
            client().admin().indices().delete(new DeleteIndexRequest(index)).actionGet();
        flush(indexName);
            mockTransportService.addRequestHandlingBehavior(
        expectedResponse.put(LIST_TIERING_STATUS_TARGET_HOT_TIER, 0);
            } else {
                .actionGet();
                String targetTier = entry.getValue();
        ListTieringStatusResponse response = client().admin().indices().execute(ListTieringStatusAction.INSTANCE, request).actionGet();
        internalCluster().startClusterManagerOnlyNode();
            listeners.forEach(listener -> clusterService().removeListener(listener));
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
            logger.info("Updating cluster setting to allow recoveries");
    protected void createTestIndex(String indexName, int numberOfShards, int numberOfReplicas) {
        indicesToMigrate.clear();
        }
        indicesToMigrate.put("test-2", "warm");
import org.opensearch.cluster.routing.ShardRouting;
public class TieringStatusIT extends RemoteStoreBaseIntegTestCase {
                final IndexTieringRequest stuckRequest = new IndexTieringRequest(targetTier, indexName);
    @Override
    protected void verifyIndividualTieringStatus(Map<String, String> indexToTargetTier) {
        Map<String, Integer> expectedResponse = new HashMap<>();
                        channel.sendResponse(TransportResponse.Empty.INSTANCE);
    }
import org.opensearch.test.transport.MockTransportService;
                assertTrue(stuckResponse.isAcknowledged());
import org.opensearch.node.Node;
            String targetTier = entry.getValue();
        for (String index : indices) {
import org.opensearch.storage.action.tiering.IndexTieringRequest;
            assertBusy(() -> {
            ShardRouting primaryShard = shardRoutingTable.primaryShard();
            : TieringTestUtils.getExpectedHotIndexSettings();
import org.opensearch.storage.action.tiering.status.model.ListTieringStatusRequest;
            String index = entry.getKey();
    protected void waitForMigrationCompletion(Map<String, String> indicesToTargetTier) {
        ClusterState state = client().admin().cluster().prepareState().get().getState();
    protected void verifyListTieringStatus(Map<String, Integer> expectedCounts) {
                tieringStatusResponse.getTieringStatus().getShardLevelStatus().getShardLevelCounters().get(RUNNING_SHARDS).intValue()
import static org.opensearch.storage.action.tiering.status.model.TieringStatus.RUNNING_SHARDS;
                0,
                AcknowledgedResponse stuckResponse = client().admin()
                String indexName = entry.getKey();
                    if (targetTier.equals("hot")) {
 * SPDX-License-Identifier: Apache-2.0
 *
import java.util.concurrent.CountDownLatch;
                        assertIndexShardLocation(index, false);
        }
                TransportService.class,
import org.opensearch.cluster.routing.IndexRoutingTable;
import org.opensearch.common.settings.Settings;
                    }
 * this file be licensed under the Apache-2.0 license or a
                        handler.messageReceived(request, channel, task);
        try {
        // First migration -> initiate H2W for 2 indices
        ).collect(Collectors.toList());
    }
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
        indicesToMigrate.put("test-2", "hot");
        }
import org.opensearch.transport.TransportService;
                .execute(GetTieringStatusAction.INSTANCE, getTieringStatusRequest)
                for (Map.Entry<String, String> entry : indicesToTargetTier.entrySet()) {
                (handler, request, channel, task) -> {
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        List<ClusterStateListener> listeners = new ArrayList<>();
        } finally {
@AwaitsFix(bugUrl = "flaky test - enable after fix")
    protected Settings nodeSettings(int nodeOrdinal) {
import org.opensearch.plugins.Plugin;
    }
        verifyTieringStatusResponse(new ListTieringStatusRequest(), expectedCounts.get(LIST_TIERING_STATUS_NO_FILTER_KEY));
/*
        }
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
                        verifyIndexSettings(index, true);
        try {
            DiscoveryNode assignedNode = state.nodes().get(assignedNodeId);
package org.opensearch.storage.tiering;
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildDisabledAllocationSettings()).get();
            verifyIndividualTieringStatus(indexToTargetTier);
    }
        ensureGreen(indices);
            }
            assertEquals(TIERING_IN_PROGRESS_STATUS, tieringStatusResponse.getTieringStatus().getStatus());
            .build();
            .put(super.nodeSettings(nodeOrdinal))
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();
    }
    }
            );
            GetTieringStatusResponse tieringStatusResponse = client().admin()
            assertEquals(
import org.opensearch.storage.action.tiering.status.model.GetTieringStatusRequest;
        } finally {
import org.opensearch.indices.replication.SegmentReplicationSourceService;
import java.util.Collection;
                    .execute(targetTier.equals("warm") ? HotToWarmTierAction.INSTANCE : WarmToHotTierAction.INSTANCE, stuckRequest)
        IndexRoutingTable indexRoutingTable = state.routingTable().index(indexName);
import org.opensearch.common.util.FeatureFlags;
        indicesToMigrate.put("test-1", "hot");
    }
        Settings currentSettings = internalCluster().clusterService().state().metadata().index(indexName).getSettings();
import java.util.Locale;
import org.opensearch.core.common.unit.ByteSizeUnit;
            assertEquals(TIERING_IN_PROGRESS_STATUS, response.getTieringStatusList().getFirst().getStatus());
        CountDownLatch migrationLatch = new CountDownLatch(indicesToTargetTier.size());
            assertTrue("Migration timed out", migrationLatch.await(DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS));
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    }
    }
        ByteSizeValue cacheSize = new ByteSizeValue(1, ByteSizeUnit.GB);
import java.util.stream.Collectors;
                assertFalse("Shard should not be on warm node", assignedNode.getRoles().contains(DiscoveryNodeRole.WARM_ROLE));
import org.opensearch.cluster.routing.IndexShardRoutingTable;
