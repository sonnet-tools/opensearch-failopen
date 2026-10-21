            IndexRoutingTable routingTable = state.routingTable().index(TEST_INDEX);
        }
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 3).build())
                client().prepareIndex(TEST_INDEX)
    protected void assertSearchNodeDocCounts(int expectedDocCount, String index) {
        assertBusy(() -> { assertEquals("One search replica should be active", 1, findNodesWithSearchOnlyReplicas().length); });
        internalCluster().startClusterManagerOnlyNode();
                }
            for (ShardRouting searchReplica : shardTable.searchOnlyReplicas()) {
                .indices()
        assertAcked(
            .get();
            .put(indexSettings())
            .put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
public class ScaleIndexIT extends RemoteStoreBaseIntegTestCase {
        });
        // Scale down search replicas while still in search-only mode
        // Verify writes work again after scale-up
     * various states, and then scaling back up to normal mode.
            assertSearchNodeDocCounts(11, TEST_INDEX);
    public void testSearchOnlyRecoveryWithPersistentData() throws Exception {
        internalCluster().startDataOnlyNodes(2);
        // Test cluster health when one search replica is down
            .put(SETTING_NUMBER_OF_SHARDS, 2)
        // Start a replacement search node and wait for recovery
            ClusterState state = client().admin().cluster().prepareState().get().getState();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
import org.opensearch.action.search.SearchResponse;
                .indices()
                fail("Write operation should be blocked during scale-down");
import org.opensearch.action.support.WriteRequest;
                if (searchReplica.active()) {
                // Attempt to index a document while scale-down is in progress
                .get()
        internalCluster().startClusterManagerOnlyNode();
                assertTrue(
            .put(SETTING_NUMBER_OF_REPLICAS, 1)
    }
                    shardTable.searchOnlyReplicas().stream().anyMatch(ShardRouting::active)
    /**
     * Assert that documents are accessible and have the expected count across all search nodes
            }
    public void testRecoveryWithPersistentDataAndRemoteStore() throws Exception {
        internalCluster().startSearchOnlyNode();
            }
        // Verify search still works on all search nodes
     */
        }
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 1).build())
            } catch (Exception e) {
                .get();
            SearchResponse response = client().prepareSearch(TEST_INDEX).get();
            client().admin()
            }
import org.opensearch.common.settings.Settings;
     * @param expectedDocCount Expected number of documents in the index
        Settings remoteStoreSettings = Settings.builder().put(nodeSettings(0)).put("cluster.remote_store.state.enabled", true).build();
        for (String node : searchNodes) {
import org.opensearch.action.index.IndexResponse;
        String[] searchNodes = findNodesWithSearchOnlyReplicas();
        assertBusy(() -> {
        internalCluster().startSearchOnlyNode();
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        createIndex(TEST_INDEX, specificSettings);
            SearchResponse searchResponse = client().prepareSearch(TEST_INDEX).get();
    }
        for (int i = 0; i < 10; i++) {
                assertTrue("No writer replicas should exist", shardTable.writerReplicas().isEmpty());
 */
                    nodeNames.add(state.nodes().get(searchReplica.currentNodeId()).getName());
            } else {
        Settings specificSettings = Settings.builder()
            .put(SETTING_NUMBER_OF_SEARCH_REPLICAS, searchOnlyReplica)
                .setSource("field1", "value" + i)
        internalCluster().startSearchOnlyNode();
     * but without data directory preservation
        );
     * Scenario 3: Tests recovery with persistent data directory and remote store state
        }, 30, TimeUnit.SECONDS);
        createIndex(TEST_INDEX, specificSettings);
 * SPDX-License-Identifier: Apache-2.0
            .build();
                    client().prepareSearch(TEST_INDEX).setSize(0).get();
import org.opensearch.cluster.routing.ShardRouting;
        }, 30, TimeUnit.SECONDS);
                    .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
    }
 * The OpenSearch Contributors require contributions made to
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 2).build())
        internalCluster().startDataOnlyNodes(2);
        ensureGreen(TEST_INDEX);
        ensureGreen(TEST_INDEX);
import java.util.HashSet;
            .build();
            assertSearchNodeDocCounts(10, TEST_INDEX);
    /**
            assertHitCount(response, 10);
     */
        });
            .put(SETTING_NUMBER_OF_REPLICAS, 1)
        Set<String> nodeNames = new HashSet<>();
     */
        testFullLifecycle(1);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                assertEquals(
        });
        assertBusy(() -> {
                    assertTrue(e.getMessage().contains("all shards failed"));
    /**
        createIndex(TEST_INDEX, specificSettings);
    /**
    }
        return nodeNames.toArray(new String[0]);
            client().admin()
 *
        assertAcked(
        ensureGreen(TEST_INDEX);
        internalCluster().stopAllNodes();
 * this file be licensed under the Apache-2.0 license or a
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
        assertEquals(RestStatus.CREATED, indexResponse.status());
        internalCluster().startDataOnlyNodes(2);
            .put(indexSettings())
    public void testFullLifecycleWithoutSearchReplicas() throws Exception {
     * Scenario 1: Tests search-only replicas recovery with persistent data directory
                    .setId("sample-write-after-search-only-block")
        // Scale up search replicas while in search-only mode
                );
        // Check on all nodes that have search-only replicas
            .setSource("field1", "new-value")
        assertAcked(client().admin().indices().prepareScaleSearchOnly(TEST_INDEX, true).get());
                .get()
        internalCluster().startSearchOnlyNodes(3);
     */
        assertAcked(client().admin().indices().prepareScaleSearchOnly(TEST_INDEX, true).get());
     * scaling search replicas while in search-only mode, verifying cluster health in
        assertBusy(() -> {
    }
     * and cluster.remote_store.state.enabled=false
        assertAcked(
        ensureYellow(TEST_INDEX);
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
}
        ensureGreen(TEST_INDEX);
        ensureGreen(TEST_INDEX);
        // Scale back up to normal mode
import org.opensearch.cluster.metadata.IndexMetadata;
            .put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
    }
        // Verify search-only setting is disabled
        ensureGreen(TEST_INDEX);
        }, 10, TimeUnit.SECONDS);
        ensureGreen(TEST_INDEX);
        assertBusy(() -> {
     * Tests the full lifecycle of scaling an index down to search-only mode,
    }
    private static final String TEST_INDEX = "test_scale_index";
        internalCluster().fullRestart();
        createIndex(TEST_INDEX, specificSettings);
     * Scenario 2: Tests behavior with cluster.remote_store.state.enabled=true
        internalCluster().startSearchOnlyNode();
    }
        ensureGreen(TEST_INDEX);
                assertSearchNodeDocCounts(10, TEST_INDEX);
        assertTrue(settingsResponse.getSetting(TEST_INDEX, IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey()).equals("true"));
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        // Verify search still works after scale-up
            .put(SETTING_NUMBER_OF_SHARDS, 1)
                try {
        Settings specificSettings = Settings.builder()
            .build();
    public void testClusterRemoteStoreStateEnabled() throws Exception {
    /**
            throw new AssertionError("Could not find any node with active search-only replica");
        }
            IndexRoutingTable routingTable = state.routingTable().index(TEST_INDEX);
            IndexResponse indexResponse = client().prepareIndex(TEST_INDEX)
import org.opensearch.test.OpenSearchIntegTestCase;
        for (IndexShardRoutingTable shardTable : indexRoutingTable) {
        GetSettingsResponse settingsResponse = client().admin().indices().prepareGetSettings(TEST_INDEX).get();
        ensureGreen(TEST_INDEX);
        ensureGreen(TEST_INDEX);
            assertHitCount(finalResponse, 11);
        internalCluster().startDataOnlyNodes(2);
        );
import org.opensearch.test.InternalTestCluster;
            }
                .prepareUpdateSettings(TEST_INDEX)
                .setId(Integer.toString(i))
        internalCluster().startClusterManagerOnlyNode(remoteStoreSettings);
        assertBusy(() -> { assertSearchNodeDocCounts(10, TEST_INDEX); }, 30, TimeUnit.SECONDS);
            for (IndexShardRoutingTable shardTable : routingTable) {
                assertTrue(
        settingsResponse = client().admin().indices().prepareGetSettings(TEST_INDEX).get();
 * compatible open source license.
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS;
    private void testFullLifecycle(int searchOnlyReplica) throws Exception {
                    .setSource("field1", "value1")
        assertBusy(() -> {
        internalCluster().startDataOnlyNodes(2);
     * @return Array of node names that have active search-only replicas
        assertAcked(client().admin().indices().prepareScaleSearchOnly(TEST_INDEX, true).get());
                );
        return Settings.builder().put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();
                    1,
        // Verify that write operations are blocked during scale-down
        Settings specificSettings = Settings.builder()
            .put(SETTING_NUMBER_OF_SHARDS, 2)
    }
     */
        // Verify new document is searchable
            assertEquals(RestStatus.CREATED, indexResponse.status());
        if (nodeNames.isEmpty()) {
        }
        // Verify search still works on all search nodes
        assertAcked(client().admin().indices().prepareScaleSearchOnly(TEST_INDEX, false).get());
        ensureGreen(TEST_INDEX);
            if (searchOnlyReplica > 0) {
                    shardTable.searchOnlyReplicas().stream().filter(ShardRouting::active).count()
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(findNodesWithSearchOnlyReplicas()[0]));
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
        internalCluster().startClusterManagerOnlyNode(remoteStoreSettings);
    public Settings indexSettings() {
        Settings specificSettings = Settings.builder()
        IndexResponse indexResponse = client().prepareIndex(TEST_INDEX)
            .setId("new-doc")
            assertHitCount(searchResponse, 10);
        // Verify search still works on all search nodes
            .put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
package org.opensearch.action.admin.indices.scale.searchonly;
    public void testFullLifecycleWithSearchReplica() throws Exception {
import org.opensearch.cluster.routing.IndexRoutingTable;
import org.opensearch.cluster.ClusterState;
            .put(SETTING_NUMBER_OF_REPLICAS, 1)
        internalCluster().startSearchOnlyNode();
     * @param index The index name to search
/*
        Settings remoteStoreSettings = Settings.builder().put(nodeSettings(0)).put("cluster.remote_store.state.enabled", true).build();
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
            client().admin()
            }
import java.util.concurrent.TimeUnit;
import org.opensearch.core.rest.RestStatus;
     * Helper method to find all nodes that contain active search-only replica shards
        assertSearchNodeDocCounts(10, TEST_INDEX);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;
                    "One search replica should be active",
     */
                );
        assertFalse(settingsResponse.getSetting(TEST_INDEX, IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey()).equals("true"));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            for (IndexShardRoutingTable shardTable : routingTable) {
                .get()
                }
        ensureGreen(TEST_INDEX);
        // Scale down to search-only mode
        assertBusy(() -> { assertSearchNodeDocCounts(10, TEST_INDEX); }, 30, TimeUnit.SECONDS);
        assertAcked(client().admin().indices().prepareScaleSearchOnly(TEST_INDEX, true).get());
            .put(SETTING_NUMBER_OF_REPLICAS, 1)
    private String[] findNodesWithSearchOnlyReplicas() {
                    "Exception should indicate index scaled down",
        // Verify search-only setting is enabled
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            .build();
                .prepareUpdateSettings(TEST_INDEX)
        assertBusy(() -> {
        IndexRoutingTable indexRoutingTable = state.routingTable().index(TEST_INDEX);
            .put(indexSettings())
            .put(SETTING_NUMBER_OF_SHARDS, 2)
import org.opensearch.indices.replication.common.ReplicationType;
                    e.getMessage().contains("blocked by: [FORBIDDEN/20/index scaled down]")
        testFullLifecycle(0);
    /**
            try {
        );
        internalCluster().startClusterManagerOnlyNode(remoteStoreSettings);
                } catch (Exception e) {
                assertNull("Primary should be null", shardTable.primaryShard());
                    "Only search replicas should be active",
                .prepareUpdateSettings(TEST_INDEX)
            assertHitCount(client(node).prepareSearch(index).setSize(0).get(), expectedDocCount);
                .indices()
import java.util.Set;
            .put(indexSettings())
        ClusterState state = client().admin().cluster().prepareState().get().getState();
                    .get();
            ClusterState state = client().admin().cluster().prepareState().get().getState();
            SearchResponse finalResponse = client().prepareSearch(TEST_INDEX).get();
