                            // Count primaries per node  
            int unassignedShards = 0;
            assertEquals("Total shards should be 8", 8, state.getRoutingTable().allShards().size());
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;  
            .build();
            .setPatterns(Collections.singletonList("template-test*"))  
                    } else {
                        test1UnassignedShards++;  
                assertTrue("No node should have more than 1 primary shard", count <= 1);
            // Verify no node has more than one primary shard  
                for (ShardRouting shard : shardRouting) {
            .put(INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 1)  
            // Check total number of shards (16 total: 8 from each index - 4 primaries + 4 replicas each)  
import java.util.HashMap;  
            assertEquals("Should have 1 unassigned primary", 1, unassignedPrimaries);  
            // Check total number of shards (8 total: 4 from each index)
                for (ShardRouting shard : shardRouting) {
            .setSettings(
            int test1UnassignedShards = 0;
                for (ShardRouting shard : shardRouting) {  
/*  
            .preparePutTemplate("primary-shard-limit-template")
                }
            assertEquals("Total shards should be 8", 8, state.getRoutingTable().allShards().size());
            }
        cleanUp("template-test1");
        // Start data nodes
                        nodePrimaryCount.merge(nodeId, 1, Integer::sum);  
    public void setup() {
        updateClusterSetting(CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 1);  
        client().prepareIndex("template-test1").setId("1").setSource("field", "value").get();  
            }  
            // Check test1 shard distribution
        UpdateSettingsRequest updateSettingsRequest = new UpdateSettingsRequest("test1");
            }  
                        } else {
 *
                    } else {
                            nodePrimaryCount.merge(nodeId, 1, Integer::sum);
                for (ShardRouting shard : shardRouting) {
            int unassignedReplicas = 0;  
    }
            4,
                    if (!shard.assignedToNode()) {  
            assertEquals("Should have 2 unassigned shards", 2, unassignedShards);
        updateSettingsRequest.settings(updatedSettings);
            // Verify no node has more than three primary shards total (cluster-wide limit)  
            )
            }
            // Check total number of shards (8 total: 4 primaries + 4 replicas)
            for (Integer count : nodePrimaryCount.values()) {
            for (Integer count : nodePrimaryCount.values()) {
            createdState.metadata().index("template-test1").getNumberOfShards()  
            "Index created from template should carry 4 primary shards",
        assertBusy(() -> {  
            assertEquals("template-test1 should have 3 assigned primaries (one per data node)", 3, assignedShards);
            for (IndexShardRoutingTable shardRouting : state.routingTable().index("test1")) {
            }
        createIndex("test1", firstIndexSettings);
        Settings indexSettings = createdState.metadata().index("template-test1").getSettings();
        updateClusterSetting(CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 3);
        // concrete index — this is the core of the bug: previously the template PUT was rejected with 400.  
            Map<String, Integer> nodePrimaryCount = new HashMap<>();
        // recognise the cluster as remote-store-enabled (via node attributes) rather than looking for
            .put(remoteStoreIndexSettings(1, 4))  // 4 shards, 1 replica
            .put(remoteStoreIndexSettings(0, 4))  // 4 shards, 0 replicas  
            for (IndexShardRoutingTable shardRouting : state.routingTable().index("test1")) {
            // Check test2 shard assignment
        // On an all-remote-store cluster this must be acknowledged: the template validator should  
import java.util.Arrays;
        );  
                            String nodeId = shard.currentNodeId();
                        assignedShards++;
        logger.info(">>> Starting custom tearDown in ShardsLimitAllocationDeciderRemoteStoreEnabledIT");
    }
 * this file be licensed under the Apache-2.0 license or a
        });  
                    }  
                assertTrue("No node should have more than 1 primary shard of test1", count <= 1);  
            ClusterState state = client().admin().cluster().prepareState().get().getState();
                        }  
                }  
import org.opensearch.test.OpenSearchIntegTestCase;
                        if (shard.primary()) {
        cleanUp("test1");
        List<String> dataNodes = internalCluster().startDataOnlyNodes(3);  
        AcknowledgedResponse response = client().admin().indices().updateSettings(updateSettingsRequest).actionGet();  
                }
        assertBusy(() -> {
                            unassignedReplicas++;  
                    if (shard.assignedToNode()) {
            int test2UnassignedShards = 0;
            // Count assigned and unassigned shards for test1  
        });
            // Verify no node has more than one primary shard for test1
                        test1NodePrimaryCount.merge(shard.currentNodeId(), 1, Integer::sum);
            }  
            int test1AssignedShards = 0;
            .build();
                        test1AssignedShards++;  
        createIndex("test1", firstIndexSettings);
        // Update the index settings to set INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING
            }
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
            .get();  
        // Create first index with index-level primary shard limit  
            // Assertions
import java.util.List;
                        } else {
                    }
            int test1UnassignedShards = 0;  
            }
    public void testUpdatingIndexPrimaryShardLimit() throws Exception {  
                    } else {
            for (IndexShardRoutingTable shardRouting : state.routingTable().index("test1")) {
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING;
                    if (shard.assignedToNode()) {  
            // Check test1 shard distribution
            assertEquals("Total shards should be 16", 16, state.getRoutingTable().allShards().size());
        // Create second index  
                    if (shard.assignedToNode()) {  
        // Create second index
        // Set cluster-wide primary shard limit to 3  
        // Update cluster setting to limit primary shards per node
                for (ShardRouting shard : shardRouting) {
        // The setting (and the injected remote-store flag) must have flowed from the template onto the
        client().admin().indices().prepareDeleteTemplate("primary-shard-limit-template").get();  
    public void testClusterPrimaryShardLimitss() throws Exception {
        ensureGreen();
            ClusterState state = client().admin().cluster().prepareState().get().getState();  
 * compatible open source license.
                    .put(remoteStoreIndexSettings(0, 4))  // 4 shards, 0 replicas  
                    if (shard.assignedToNode()) {
            for (Integer count : nodePrimaryCount.values()) {  
    private void updateClusterSetting(String setting, int value) {
            }  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.ClusterState;
            "Index created from template on a remote-store cluster should be remote-store enabled",
            Map<String, Integer> nodePrimaryCount = new HashMap<>();
                    }
        ClusterState createdState = client().admin().cluster().prepareState().get().getState();
import org.junit.Before;
        assertBusy(() -> {
                        String nodeId = shard.currentNodeId();
            assertEquals("Should have no unassigned shards in test2", 0, test2UnassignedShards);  
                for (ShardRouting shard : shardRouting) {
            // Count assigned and unassigned shards for test1
                for (ShardRouting shard : shardRouting) {
            for (IndexShardRoutingTable shardRouting : state.routingTable().index("test1")) {  
            for (IndexShardRoutingTable shardRouting : state.routingTable().index("test2")) {  
            assertEquals("Should have 14 assigned shards", 14, totalAssignedShards);  
            int test2UnassignedShards = 0;
        Settings firstIndexSettings = Settings.builder()
                }  
        // Create first index with primary shard limit  
import org.opensearch.cluster.routing.ShardRouting;
                        nodePrimaryCount.merge(shard.currentNodeId(), 1, Integer::sum);
            assertEquals("Should have 6 assigned shards", 6, assignedShards);
        });
        // Create first index  
                            String nodeId = shard.currentNodeId();
                        }
import org.opensearch.action.admin.indices.flush.FlushRequest;
        // block) fully drives the index settings — including number_of_shards and the primary shard limit.
            int test1AssignedShards = 0;
 * The OpenSearch Contributors require contributions made to  
            int test1UnassignedPrimaries = 0;
            for (IndexShardRoutingTable shardRouting : state.routingTable().index("test1")) {  
                        // Count primaries per node for test1
        FlushRequest flushRequest = new FlushRequest(indices);
            assertEquals("Should have 1 unassigned primary in test1", 1, test1UnassignedPrimaries);
    public void testIndexTemplateWithPrimaryShardLimit() throws Exception {
                        nodePrimaryCount.merge(nodeId, 1, Integer::sum);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
                    }
            ClusterState state = client().admin().cluster().prepareState().get().getState();  
            .put(INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 1)
        createIndex("test1", firstIndexSettings);
        assertEquals(  
    }  
            // Check test2 shard assignment
        Settings firstIndexSettings = Settings.builder()
            }
import java.util.Map;
        Settings updatedSettings = Settings.builder().put(INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 1).build();  
        // Create second index with no index-level limits  
        assertTrue("Template carrying total_primary_shards_per_node should be acknowledged", templateResponse.isAcknowledged());
            .indices()
            }  
                assertTrue("No node should have more than 1 primary shard of template-test1", count <= 1);
        Settings firstIndexSettings = Settings.builder()
            }  
        );
            assertEquals("test1 should have 1 unassigned shard", 1, test1UnassignedShards);
            assertEquals("Total shards should be 8", 8, state.getRoutingTable().allShards().size());  
                        test2UnassignedShards++;  
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING;
            int unassignedShards = 0;  
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode(Settings.EMPTY);
            int totalAssignedShards = 0;
            assertEquals("Should have 1 unassigned replica in test1", 1, test1UnassignedReplicas);
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
                        if (shard.primary()) {
        // Create first index
                    }
            assertEquals("test1 should have 3 assigned shards", 3, test1AssignedShards);  
                    }
                        if (shard.primary()) {  
            for (IndexShardRoutingTable shardRouting : state.routingTable().index("template-test1")) {  
    }  
            assertEquals("test1 should have 3 assigned shards", 3, test1AssignedShards);
            Map<String, Integer> nodePrimaryCount = new HashMap<>();
        createIndex("test2", remoteStoreIndexSettings(0, 4));
                        }  
        assertTrue(response.isAcknowledged());
            assertEquals("test2 should have no unassigned shards", 0, test2UnassignedShards);  
public class ShardsLimitAllocationDeciderRemoteStoreEnabledIT extends RemoteStoreBaseIntegTestCase {
                    }
                for (ShardRouting shard : shardRouting) {
    }  
                        test1AssignedShards++;
        // Create index with 4 shards and 1 replica
            // Check total number of shards (8 total: 4 from each index)  
                    if (shard.assignedToNode() && shard.primary()) {  
                }
            int test1UnassignedReplicas = 0;  
            }  
        flushRequest.waitIfOngoing(true); // Wait if flush already in progress  
            assertEquals("test2 should have no unassigned shards", 0, test2UnassignedShards);
                    if (shard.assignedToNode()) {
    private void cleanUp(String... indices) throws Exception {  
                        // Count primaries per node for test1
                    assertTrue("No node should have more than 1 primary shard of test1", count <= 1);
            Integer.valueOf(1),
                            unassignedPrimaries++;
            assertEquals("template-test1 should have 1 unassigned primary (blocked by the per-node limit)", 1, unassignedShards);  
        createIndex("test2", remoteStoreIndexSettings(1, 4));  // 4 shards, 1 replica
        flushRequest.force(true); // Force even if no changes detected
                assertTrue("No node should have more than 1 primary shard of test1", count <= 1);
            // Count assigned and unassigned shards for test1
    }  
        assertBusy(() -> {  
                        totalAssignedShards++;
            // Verify no node has more than one primary shard of test1
            Map<String, Integer> nodePrimaryCount = new HashMap<>();
                    } else {
            ClusterState state = client().admin().cluster().prepareState().get().getState();
import java.util.Collections;
    @Before  
import org.opensearch.common.settings.Settings;
        setupCustomCluster();
                    } else {
            ClusterState state = client().admin().cluster().prepareState().get().getState();
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(Settings.builder().put(setting, value)).get();  
            int assignedShards = 0;  
                        if (shard.primary()) {
                        test1UnassignedShards++;
    }
        AcknowledgedResponse templateResponse = client().admin()  
                for (ShardRouting shard : shardRouting) {
        // Create first index with primary shard limit
                        test2UnassignedShards++;  
        // Start cluster manager node first  
            int unassignedPrimaries = 0;
            for (IndexShardRoutingTable shardRouting : state.routingTable().index("test2")) {
                            test1UnassignedReplicas++;
        cleanUp("test1");
                        totalAssignedShards++;  
                        }
        createIndex("test1", remoteStoreIndexSettings(1, 4));  
            // Assertions  
                            nodePrimaryCount.merge(nodeId, 1, Integer::sum);
    public void testCombinedIndexAndClusterPrimaryShardLimits() throws Exception {
            assertEquals("test1 should have 1 unassigned shard", 1, test1UnassignedShards);
        // Wait for green cluster state
    }  
            }  
                }
        // the index-local index.remote_store.enabled flag, which a template can never carry.
                Settings.builder()
                        unassignedShards++;
 */  
                        String nodeId = shard.currentNodeId();  
        // And the limit must actually be enforced at allocation time: with 4 primaries, a limit of 1  
        assertEquals(
            Map<String, Integer> nodePrimaryCount = new HashMap<>();  
        // Synchronization: Force flush relevant indices.
                }  
                        test2UnassignedShards++;
        });
            for (IndexShardRoutingTable shardRouting : state.routingTable().index("test2")) {  
    public void testIndexPrimaryShardLimit() throws Exception {
package org.opensearch.cluster.routing.allocation.decider;
            assertEquals("Should have 1 unassigned replica", 1, unassignedReplicas);
        assertBusy(() -> {
                        if (shard.primary()) {  
                    .put(INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 1)
        cleanUp("test1", "test2");
                for (Integer count : test1NodePrimaryCount.values()) {
                }  
            // Check test2 shard distribution
                            test1UnassignedPrimaries++;  
            // Verify no node has more than one primary shard of test1
            // Assertions
            IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.get(indexSettings)  
        createIndex("test2", remoteStoreIndexSettings(0, 4));
            INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.get(indexSettings)
                    }
            // Count assigned and unassigned shards for both indices  
        // Create first index  
                }
        );
}
    private void setupCustomCluster() {
                    } else {
                            String nodeId = shard.currentNodeId();
        // per node and 3 data nodes, at least one primary stays unassigned and no node holds more than one.
                            nodePrimaryCount.merge(nodeId, 1, Integer::sum);  
                    if (!shard.assignedToNode()) {
            for (Integer count : nodePrimaryCount.values()) {
                }
                    }
    }
            int test2UnassignedShards = 0;  
        // Put an index template that carries index.routing.allocation.total_primary_shards_per_node.
        // Auto-create the index by indexing a document so the template (not a create-request settings
            for (Integer count : nodePrimaryCount.values()) {
import org.opensearch.cluster.metadata.IndexMetadata;
                        unassignedShards++;  
        assertTrue(
        });
            // Check test1 shard distribution  
        logger.info("Attempting to flush indices {} to help sync remote store before cleanup...", Arrays.toString(indices));  
            // Assertions  
                        }  
            .build();
            "Index created from template should carry the primary shard limit",  
                Map<String, Integer> test1NodePrimaryCount = new HashMap<>();
            int assignedShards = 0;
            .put(remoteStoreIndexSettings(0, 4))  // 4 shards, 0 replicas
        cleanUp("test1", "test2");  
        client().admin().indices().flush(flushRequest).actionGet(); // Use actionGet() or get() to wait
                    if (shard.assignedToNode()) {
            .put(INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 1)  
        logger.info("Flush request for {} completed.", Arrays.toString(indices));
                assertTrue("No node should have more than 3 primary shards total", count <= 3);
            // Check shard distribution  
                        assignedShards++;  
