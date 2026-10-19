import org.opensearch.core.common.unit.ByteSizeUnit;
import org.opensearch.storage.action.tiering.status.model.GetTieringStatusRequest;
            assertEquals(
        Map<String, String> indexToTargetTier,
import org.opensearch.storage.action.tiering.status.GetTieringStatusAction;  
        // Cleanup  
        }  
            client().admin().indices().delete(new DeleteIndexRequest(index)).actionGet();
    protected void verifyListTieringStatus(Map<String, Integer> expectedCounts) {  
/*  
                    .execute(targetTier.equals("warm") ? HotToWarmTierAction.INSTANCE : WarmToHotTierAction.INSTANCE, stuckRequest)  
        indicesToMigrate.put("test-2", "warm");  
            listeners.forEach(listener -> clusterService().removeListener(listener));
                    .indices()
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
                .actionGet();
        try {
    protected void initiateStuckMigrationToGetStatus(  
        CountDownLatch migrationLatch = new CountDownLatch(indicesToTargetTier.size());
        expectedResponse.put(LIST_TIERING_STATUS_NO_FILTER_KEY, 4);
        ListTieringStatusResponse response = client().admin().indices().execute(ListTieringStatusAction.INSTANCE, request).actionGet();
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
                final IndexTieringRequest stuckRequest = new IndexTieringRequest(targetTier, indexName);  
    }
    protected void setupCluster(int numberOfReplicas) {
            DiscoveryNode assignedNode = state.nodes().get(assignedNodeId);
        indicesToMigrate.put("test-4", "warm");
import org.opensearch.storage.action.tiering.status.model.ListTieringStatusResponse;
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();  
                    if (targetTier.equals("hot")) {
import org.opensearch.storage.action.tiering.IndexTieringRequest;
    protected void verifyIndividualTieringStatus(Map<String, String> indexToTargetTier) {
                    .actionGet();
        expectedResponse.put(LIST_TIERING_STATUS_TARGET_WARM_TIER, 2);  
    @Override
            : TieringTestUtils.getExpectedHotIndexSettings();
                "Incorrect value for setting: " + entry.getKey(),
                tieringStatusResponse.getTieringStatus().getShardLevelStatus().getShardLevelCounters().get(RUNNING_SHARDS).intValue()
        Map<String, String> indicesToMigrate = new HashMap<>();
            } else {
        initiateStuckMigrationToGetStatus(indicesToMigrate, expectedResponse);
        }  
                AcknowledgedResponse stuckResponse = client().admin()
                entry.getValue().toString(),  
import java.util.concurrent.CountDownLatch;
        for (Map.Entry<String, String> entry : indexToTargetTier.entrySet()) {  
            String targetTier = entry.getValue();
            super.nodePlugins().stream(),  
    @Override
    }
    }
            createTestIndex(index, 1, 1);  
                        channel.sendResponse(TransportResponse.Empty.INSTANCE);
                        verifyIndexSettings(index, true);
                TransportService.class,
        }
 * The OpenSearch Contributors require contributions made to  
    private static final String LIST_TIERING_STATUS_TARGET_HOT_TIER = "hotTier";
    }
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
        for (String nodeName : internalCluster().getNodeNames()) {  
        List<ClusterStateListener> listeners = new ArrayList<>();  
        ensureGreen(indexName);
import java.util.stream.Collectors;  
import org.opensearch.core.common.unit.ByteSizeValue;  
    protected void createTestIndex(String indexName, int numberOfShards, int numberOfReplicas) {  
        flush(indexName);
    protected void verifyIndexSettings(String indexName, boolean isWarm) {
import org.opensearch.node.Node;  
public class TieringStatusIT extends RemoteStoreBaseIntegTestCase {
        verifyTieringStatusResponse(new ListTieringStatusRequest("HOT"), expectedCounts.get(LIST_TIERING_STATUS_TARGET_HOT_TIER));  
        Map<String, Object> expectedSettings = isWarm
                currentSettings.get(entry.getKey())
    }  
import org.opensearch.storage.action.tiering.status.model.GetTieringStatusResponse;  
        indicesToMigrate.put("test-1", "hot");
import java.util.concurrent.TimeUnit;
            MockTransportService mockTransportService = (MockTransportService) internalCluster().getInstance(
 * compatible open source license.
            }  
import org.opensearch.plugins.Plugin;
        return Stream.concat(
import java.util.Collection;
    protected static final String TIERING_IN_PROGRESS_STATUS = "RUNNING_SHARD_RELOCATION";  
            assertTrue("Migration timed out", migrationLatch.await(DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS));
        return Settings.builder()
        ensureGreen(indices);
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
                        handler.messageReceived(request, channel, task);  
        internalCluster().startWarmOnlyNodes(2);
import java.util.stream.Stream;
    @Override
        verifyTieringStatusResponse(new ListTieringStatusRequest("WARM"), expectedCounts.get(LIST_TIERING_STATUS_TARGET_WARM_TIER));
            listeners.add(listener);  
 *
            );  
            mockTransportService.addRequestHandlingBehavior(
import java.util.Map;  
    private static final String LIST_TIERING_STATUS_NO_FILTER_KEY = "noFilter";
            ? TieringTestUtils.getExpectedWarmIndexSettings()  
            logger.info("Updating cluster setting to allow recoveries");
        ).collect(Collectors.toList());
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;  
    }  
    }
                    String targetTier = entry.getValue();
                        verifyIndexSettings(index, false);
        for (String index : indices) {
import org.opensearch.storage.action.tiering.status.model.ListTieringStatusRequest;
        expectedResponse.put(LIST_TIERING_STATUS_TARGET_WARM_TIER, 2);  
        }
import org.opensearch.test.OpenSearchIntegTestCase;  
                SegmentReplicationSourceService.Actions.UPDATE_VISIBLE_CHECKPOINT,  
                .indices()
        try {
                0,
import java.util.List;
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
    }
        ByteSizeValue cacheSize = new ByteSizeValue(1, ByteSizeUnit.GB);
        return true;  
    protected void interceptCheckpointUpdates() {
                String indexName = entry.getKey();
            String assignedNodeId = primaryShard.currentNodeId();  
        }
        Map<String, Integer> expectedListTieringResponseCount
        Settings indexSettings = Settings.builder()
        expectedResponse.put(LIST_TIERING_STATUS_TARGET_HOT_TIER, 0);
                        assertIndexShardLocation(index, false);  
import org.opensearch.cluster.node.DiscoveryNode;
        for (Map.Entry<String, String> entry : indicesToTargetTier.entrySet()) {
import org.opensearch.cluster.ClusterState;  
            assertEquals(  
import org.opensearch.cluster.routing.IndexRoutingTable;  
        } finally {
    }
        assertEquals(expectedCount, response.getTieringStatusList().size());
        // First migration -> initiate H2W for 2 indices
import java.util.ArrayList;
            final GetTieringStatusRequest getTieringStatusRequest = new GetTieringStatusRequest(index);  
            assertBusy(() -> {
        }  
        indicesToMigrate.put("test-2", "hot");  
        return false;
import java.util.HashMap;  
            String index = entry.getKey();  
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildDisabledAllocationSettings()).get();  
import java.util.Locale;
        indicesToMigrate.put("test-3", "warm");  
        IndexRoutingTable indexRoutingTable = state.routingTable().index(indexName);
        }  
    }  
        for (String index : indices) {
        for (Map.Entry<String, Object> entry : expectedSettings.entrySet()) {  
        return Settings.builder().put(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG, true).build();
import org.opensearch.common.settings.Settings;  
    protected boolean ignoreExternalCluster() {
            );
                .execute(GetTieringStatusAction.INSTANCE, getTieringStatusRequest)  
    ) throws Exception {  
    }
        expectedResponse.put(LIST_TIERING_STATUS_TARGET_HOT_TIER, 2);
            String index = entry.getKey();
    protected Settings nodeSettings(int nodeOrdinal) {  
import org.opensearch.cluster.metadata.IndexMetadata;  
                        assertIndexShardLocation(index, true);  
    }
        ClusterState state = client().admin().cluster().prepareState().get().getState();
        } catch (Exception e) {
        if (expectedCount > 0) {  
import org.opensearch.storage.action.tiering.status.ListTieringStatusAction;
        waitForReplication(indexName);  
            assertNotEquals(targetTier.toUpperCase(Locale.ROOT), tieringStatusResponse.getTieringStatus().getSource());
                String targetTier = entry.getValue();
            GetTieringStatusResponse tieringStatusResponse = client().admin()
import org.opensearch.cluster.ClusterStateListener;
            .put(super.nodeSettings(nodeOrdinal))  
                    try {
            }, DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        interceptCheckpointUpdates();
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            ClusterStateListener listener = new TieringTestUtils.MockTieringCompletionListener(migrationLatch, index, targetTier);
        } finally {
    protected void waitForMigrationCompletion(Map<String, String> indicesToTargetTier) {
    private static final int DEFAULT_TIMEOUT_SECONDS = 30;
                for (Map.Entry<String, String> entry : indicesToTargetTier.entrySet()) {
            if (onWarmNodes) {  
            String targetTier = entry.getValue();
import static org.opensearch.storage.tiering.TieringTestUtils.buildEnabledAllocationSettings;
            .build();
        }
        internalCluster().startClusterManagerOnlyNode();
    protected void assertIndexShardLocation(String indexName, boolean onWarmNodes) {  
                assertFalse("Shard should not be on warm node", assignedNode.getRoles().contains(DiscoveryNodeRole.WARM_ROLE));  
 */  
import org.opensearch.common.util.FeatureFlags;
        waitForMigrationCompletion(indexToTargetTier);  
            assertEquals(targetTier.toUpperCase(Locale.ROOT), tieringStatusResponse.getTieringStatus().getTarget());
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            verifyIndividualTieringStatus(indexToTargetTier);  
        Settings currentSettings = internalCluster().clusterService().state().metadata().index(indexName).getSettings();  
        for (IndexShardRoutingTable shardRoutingTable : indexRoutingTable) {
import org.opensearch.cluster.routing.IndexShardRoutingTable;
import org.opensearch.core.transport.TransportResponse;
            assertEquals(TIERING_IN_PROGRESS_STATUS, tieringStatusResponse.getTieringStatus().getStatus());  
        initiateStuckMigrationToGetStatus(indicesToMigrate, expectedResponse);
            clusterService().addListener(listener);
import static org.opensearch.storage.action.tiering.status.model.TieringStatus.RUNNING_SHARDS;  
            }
    @Override  
import org.opensearch.indices.replication.SegmentReplicationSourceService;
    }  
            Stream.of(MockInternalClusterInfoService.TestPlugin.class, MockTransportService.TestPlugin.class)
        expectedResponse.clear();
@AwaitsFix(bugUrl = "flaky test - enable after fix")  
import org.opensearch.cluster.node.DiscoveryNodeRole;
        logger.info("Updating cluster setting to pause recoveries");
                    }  
    }
            assertEquals(TIERING_IN_PROGRESS_STATUS, response.getTieringStatusList().getFirst().getStatus());
        String[] indices = new String[] { "test-1", "test-2", "test-3", "test-4" };
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.transport.TransportService;
import org.opensearch.storage.action.tiering.WarmToHotTierAction;
            throw new RuntimeException(e);  
 * SPDX-License-Identifier: Apache-2.0
                (handler, request, channel, task) -> {
    protected Settings featureFlagSettings() {  
        expectedResponse.put(LIST_TIERING_STATUS_NO_FILTER_KEY, 2);
                assertTrue("Shard should be on warm node", assignedNode.getRoles().contains(DiscoveryNodeRole.WARM_ROLE));
        createIndex(indexName, indexSettings);  
}
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numberOfShards)
import org.opensearch.storage.action.tiering.HotToWarmTierAction;  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numberOfReplicas)  
    protected void verifyTieringStatusResponse(ListTieringStatusRequest request, int expectedCount) {  
    @Override
        Map<String, Integer> expectedResponse = new HashMap<>();
            for (Map.Entry<String, String> entry : indexToTargetTier.entrySet()) {  
        indicesToMigrate.clear();
    public void testTieringStatus() throws Exception {
package org.opensearch.storage.tiering;
                    String index = entry.getKey();  
        setupCluster(1);
import org.opensearch.cluster.MockInternalClusterInfoService;
            ShardRouting primaryShard = shardRoutingTable.primaryShard();
        verifyTieringStatusResponse(new ListTieringStatusRequest(), expectedCounts.get(LIST_TIERING_STATUS_NO_FILTER_KEY));
                    } catch (AssertionError e) {
                }  
import static org.opensearch.storage.tiering.TieringTestUtils.buildDisabledAllocationSettings;
            verifyListTieringStatus(expectedListTieringResponseCount);
import org.opensearch.test.transport.MockTransportService;
    private static final String LIST_TIERING_STATUS_TARGET_WARM_TIER = "warmTier";  
        }
        }
                    } else {
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
                nodeName  
        internalCluster().startDataOnlyNodes(numberOfReplicas + 1);  
    }  
    }
                assertTrue(stuckResponse.isAcknowledged());
            .build();
                }
            );
        indicesToMigrate.put("test-1", "warm");
            );
    @AwaitsFix(bugUrl = "Flaky test - fix before enabling")  
                    }
    protected boolean addMockIndexStorePlugin() {  
        // Second migration -> initiate H2W for 2 indices and W2H for rest indices  
