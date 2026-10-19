            client().admin()
        for (IndexShardRoutingTable shardTable : indexRoutingTable) {  
        createIndex(TEST_INDEX, specificSettings);  
            .put(SETTING_NUMBER_OF_REPLICAS, 1)  
        createIndex(TEST_INDEX, specificSettings);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        internalCluster().startClusterManagerOnlyNode();
    }
        settingsResponse = client().admin().indices().prepareGetSettings(TEST_INDEX).get();
        assertAcked(client().admin().indices().prepareScaleSearchOnly(TEST_INDEX, true).get());
    }
            }
            ClusterState state = client().admin().cluster().prepareState().get().getState();
            .put(SETTING_NUMBER_OF_SHARDS, 2)
                .setSource("field1", "value" + i)
            }  
        if (nodeNames.isEmpty()) {
        );
        assertBusy(() -> {
    public void testFullLifecycleWithoutSearchReplicas() throws Exception {
 *
    public void testFullLifecycleWithSearchReplica() throws Exception {
        // Verify search still works after scale-up
    private static final String TEST_INDEX = "test_scale_index";
import org.opensearch.cluster.routing.IndexRoutingTable;
        });
            } else {
            assertSearchNodeDocCounts(11, TEST_INDEX);
            }  
            .put(SETTING_NUMBER_OF_SHARDS, 1)  
    }  
     * various states, and then scaling back up to normal mode.  
 */  
            .put(SETTING_NUMBER_OF_SHARDS, 2)
        return nodeNames.toArray(new String[0]);  
        assertAcked(client().admin().indices().prepareScaleSearchOnly(TEST_INDEX, true).get());
                assertSearchNodeDocCounts(10, TEST_INDEX);  
    public void testSearchOnlyRecoveryWithPersistentData() throws Exception {
                    nodeNames.add(state.nodes().get(searchReplica.currentNodeId()).getName());  
            .setSource("field1", "new-value")
        Settings remoteStoreSettings = Settings.builder().put(nodeSettings(0)).put("cluster.remote_store.state.enabled", true).build();
     * Scenario 1: Tests search-only replicas recovery with persistent data directory
        // Verify search still works on all search nodes
                .get()
        });  
import org.opensearch.common.settings.Settings;
            try {  
        internalCluster().startSearchOnlyNode();  
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        internalCluster().startClusterManagerOnlyNode(remoteStoreSettings);
     * Scenario 3: Tests recovery with persistent data directory and remote store state
            .put(indexSettings())
            SearchResponse response = client().prepareSearch(TEST_INDEX).get();  
        Settings remoteStoreSettings = Settings.builder().put(nodeSettings(0)).put("cluster.remote_store.state.enabled", true).build();  
        ensureGreen(TEST_INDEX);  
        GetSettingsResponse settingsResponse = client().admin().indices().prepareGetSettings(TEST_INDEX).get();
        ensureGreen(TEST_INDEX);
                // Attempt to index a document while scale-down is in progress
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 3).build())  
        internalCluster().startClusterManagerOnlyNode(remoteStoreSettings);
import org.opensearch.action.index.IndexResponse;
            IndexRoutingTable routingTable = state.routingTable().index(TEST_INDEX);
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)  
import org.opensearch.action.support.WriteRequest;
     * Scenario 2: Tests behavior with cluster.remote_store.state.enabled=true
        assertAcked(client().admin().indices().prepareScaleSearchOnly(TEST_INDEX, true).get());  
import org.opensearch.test.OpenSearchIntegTestCase;  
        assertBusy(() -> {  
            for (ShardRouting searchReplica : shardTable.searchOnlyReplicas()) {
        createIndex(TEST_INDEX, specificSettings);
 * SPDX-License-Identifier: Apache-2.0
        return Settings.builder().put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();
        IndexRoutingTable indexRoutingTable = state.routingTable().index(TEST_INDEX);
    /**
        createIndex(TEST_INDEX, specificSettings);
        assertBusy(() -> { assertSearchNodeDocCounts(10, TEST_INDEX); }, 30, TimeUnit.SECONDS);  
                );
            for (IndexShardRoutingTable shardTable : routingTable) {
        internalCluster().startClusterManagerOnlyNode();  
                );
 * compatible open source license.
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(findNodesWithSearchOnlyReplicas()[0]));  
     * @return Array of node names that have active search-only replicas
     * Helper method to find all nodes that contain active search-only replica shards  
            assertHitCount(searchResponse, 10);
        for (int i = 0; i < 10; i++) {
            for (IndexShardRoutingTable shardTable : routingTable) {
     * @param expectedDocCount Expected number of documents in the index
                .get()  
        // Verify that write operations are blocked during scale-down
     */
        internalCluster().startDataOnlyNodes(2);
import org.opensearch.test.InternalTestCluster;
            .build();
        }  
                .indices()
        Settings specificSettings = Settings.builder()  
     */  
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 2).build())
                .prepareUpdateSettings(TEST_INDEX)
            .build();
        assertBusy(() -> { assertSearchNodeDocCounts(10, TEST_INDEX); }, 30, TimeUnit.SECONDS);
        ensureGreen(TEST_INDEX);
            .put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
        // Start a replacement search node and wait for recovery
        internalCluster().startClusterManagerOnlyNode(remoteStoreSettings);
                    shardTable.searchOnlyReplicas().stream().anyMatch(ShardRouting::active)
public class ScaleIndexIT extends RemoteStoreBaseIntegTestCase {
        // Verify search still works on all search nodes  
        assertSearchNodeDocCounts(10, TEST_INDEX);
    public Settings indexSettings() {  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        assertAcked(
                    .setId("sample-write-after-search-only-block")  
     * Assert that documents are accessible and have the expected count across all search nodes
        assertBusy(() -> {  
        // Scale back up to normal mode
    }
        ensureGreen(TEST_INDEX);  
        testFullLifecycle(0);  
     */
                .indices()  
            assertHitCount(finalResponse, 11);
        internalCluster().startSearchOnlyNode();
        assertFalse(settingsResponse.getSetting(TEST_INDEX, IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey()).equals("true"));
        internalCluster().startSearchOnlyNodes(3);
 * The OpenSearch Contributors require contributions made to  
                .setId(Integer.toString(i))
        assertBusy(() -> {
import org.opensearch.cluster.ClusterState;
                fail("Write operation should be blocked during scale-down");
    public void testClusterRemoteStoreStateEnabled() throws Exception {
                assertTrue("No writer replicas should exist", shardTable.writerReplicas().isEmpty());  
            .put(SETTING_NUMBER_OF_REPLICAS, 1)
                } catch (Exception e) {
            SearchResponse searchResponse = client().prepareSearch(TEST_INDEX).get();  
        for (String node : searchNodes) {
        internalCluster().startDataOnlyNodes(2);  
        ensureGreen(TEST_INDEX);
                    .setSource("field1", "value1")
        assertBusy(() -> {
                    .get();  
        assertBusy(() -> { assertEquals("One search replica should be active", 1, findNodesWithSearchOnlyReplicas().length); });
                client().prepareIndex(TEST_INDEX)
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 1).build())
                    e.getMessage().contains("blocked by: [FORBIDDEN/20/index scaled down]")
                .indices()
        // Test cluster health when one search replica is down
        internalCluster().startSearchOnlyNode();
    /**
        // Check on all nodes that have search-only replicas  
    /**
        ensureGreen(TEST_INDEX);  
        internalCluster().startDataOnlyNodes(2);  
    /**  
    }
                    client().prepareSearch(TEST_INDEX).setSize(0).get();  
     * scaling search replicas while in search-only mode, verifying cluster health in
        ensureGreen(TEST_INDEX);
        // Verify search-only setting is enabled  
        }
     */  
        internalCluster().fullRestart();  
            client().admin()  
     * and cluster.remote_store.state.enabled=false
        // Scale up search replicas while in search-only mode
            throw new AssertionError("Could not find any node with active search-only replica");  
                try {
    }  
    protected void assertSearchNodeDocCounts(int expectedDocCount, String index) {
                    "One search replica should be active",
        assertAcked(  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;  
            SearchResponse finalResponse = client().prepareSearch(TEST_INDEX).get();  
        Settings specificSettings = Settings.builder()
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
                }  
                );  
            assertHitCount(client(node).prepareSearch(index).setSize(0).get(), expectedDocCount);  
            IndexResponse indexResponse = client().prepareIndex(TEST_INDEX)  
/*  
                assertTrue(  
        }  
        // Verify new document is searchable
                assertEquals(
        ensureGreen(TEST_INDEX);
        String[] searchNodes = findNodesWithSearchOnlyReplicas();
     * but without data directory preservation  
        testFullLifecycle(1);
            .put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)  
                    assertTrue(e.getMessage().contains("all shards failed"));
                .prepareUpdateSettings(TEST_INDEX)
        ensureGreen(TEST_INDEX);
        ensureYellow(TEST_INDEX);
            assertEquals(RestStatus.CREATED, indexResponse.status());
        ensureGreen(TEST_INDEX);
            IndexRoutingTable routingTable = state.routingTable().index(TEST_INDEX);
                if (searchReplica.active()) {
        }, 30, TimeUnit.SECONDS);  
        Set<String> nodeNames = new HashSet<>();
        );
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;  
import org.opensearch.indices.replication.common.ReplicationType;  
        }, 30, TimeUnit.SECONDS);
    public void testRecoveryWithPersistentDataAndRemoteStore() throws Exception {
        internalCluster().startDataOnlyNodes(2);  
    }
                .get();
            } catch (Exception e) {
     */
     * Tests the full lifecycle of scaling an index down to search-only mode,
            ClusterState state = client().admin().cluster().prepareState().get().getState();
        Settings specificSettings = Settings.builder()
            .build();
            if (searchOnlyReplica > 0) {
                }
                    "Only search replicas should be active",  
            .put(indexSettings())  
        // Verify search still works on all search nodes
        // Verify search-only setting is disabled  
                .prepareUpdateSettings(TEST_INDEX)  
                    1,  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import java.util.Set;  
        internalCluster().stopAllNodes();  
            client().admin()
        IndexResponse indexResponse = client().prepareIndex(TEST_INDEX)  
        ClusterState state = client().admin().cluster().prepareState().get().getState();
        // Verify writes work again after scale-up
import org.opensearch.cluster.metadata.IndexMetadata;  
            .build();  
    }
            assertHitCount(response, 10);
        );  
        // Scale down to search-only mode  
     * @param index The index name to search  
        assertAcked(
import java.util.HashSet;
        assertEquals(RestStatus.CREATED, indexResponse.status());
                assertTrue(
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS;
                assertNull("Primary should be null", shardTable.primaryShard());
    /**  
import org.opensearch.core.rest.RestStatus;
            assertSearchNodeDocCounts(10, TEST_INDEX);
            .put(indexSettings())
            .get();
        internalCluster().startSearchOnlyNode();
                    "Exception should indicate index scaled down",
        ensureGreen(TEST_INDEX);
    private String[] findNodesWithSearchOnlyReplicas() {  
                .get()
    /**  
        assertBusy(() -> {
        }
    private void testFullLifecycle(int searchOnlyReplica) throws Exception {
        assertAcked(client().admin().indices().prepareScaleSearchOnly(TEST_INDEX, true).get());
import org.opensearch.cluster.routing.ShardRouting;  
                    shardTable.searchOnlyReplicas().stream().filter(ShardRouting::active).count()
            .put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
package org.opensearch.action.admin.indices.scale.searchonly;
        assertAcked(client().admin().indices().prepareScaleSearchOnly(TEST_INDEX, false).get());  
            .put(SETTING_NUMBER_OF_SEARCH_REPLICAS, searchOnlyReplica)
        ensureGreen(TEST_INDEX);
        Settings specificSettings = Settings.builder()  
     */
        }, 10, TimeUnit.SECONDS);
}  
            .put(SETTING_NUMBER_OF_REPLICAS, 1)  
        assertTrue(settingsResponse.getSetting(TEST_INDEX, IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey()).equals("true"));
        internalCluster().startDataOnlyNodes(2);
    }
            }
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)  
        internalCluster().startSearchOnlyNode();
            .setId("new-doc")
import java.util.concurrent.TimeUnit;
            .put(indexSettings())
            .put(SETTING_NUMBER_OF_REPLICAS, 1)
            .put(SETTING_NUMBER_OF_SHARDS, 2)
                    .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            }
        });
import org.opensearch.action.search.SearchResponse;  
        // Scale down search replicas while still in search-only mode  
