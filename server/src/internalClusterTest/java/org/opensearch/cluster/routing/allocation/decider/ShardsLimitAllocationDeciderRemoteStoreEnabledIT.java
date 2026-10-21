            for (Integer count : nodePrimaryCount.values()) {
package org.opensearch.cluster.routing.allocation.decider;
        // per node and 3 data nodes, at least one primary stays unassigned and no node holds more than one.
    public void testUpdatingIndexPrimaryShardLimit() throws Exception {
        // Set cluster-wide primary shard limit to 3
 *
            }
    public void testIndexTemplateWithPrimaryShardLimit() throws Exception {
        // Start data nodes
            }
            int test1AssignedShards = 0;
            IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.get(indexSettings)
    }
        assertTrue("Template carrying total_primary_shards_per_node should be acknowledged", templateResponse.isAcknowledged());
            assertEquals("Should have 1 unassigned primary", 1, unassignedPrimaries);
                        test1UnassignedShards++;
            }
            assertEquals("test1 should have 1 unassigned shard", 1, test1UnassignedShards);
        Settings firstIndexSettings = Settings.builder()
                            test1UnassignedPrimaries++;
            "Index created from template on a remote-store cluster should be remote-store enabled",
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
                        } else {
                for (ShardRouting shard : shardRouting) {
        // Create second index
                for (ShardRouting shard : shardRouting) {
            assertEquals("Total shards should be 8", 8, state.getRoutingTable().allShards().size());
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode(Settings.EMPTY);
import java.util.Map;
                    if (shard.assignedToNode()) {
                        test1AssignedShards++;
                            String nodeId = shard.currentNodeId();
                        test2UnassignedShards++;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        // recognise the cluster as remote-store-enabled (via node attributes) rather than looking for
            int test2UnassignedShards = 0;
                        assignedShards++;
import java.util.HashMap;
            )
            }
                    .put(remoteStoreIndexSettings(0, 4))  // 4 shards, 0 replicas
                }
        // Create first index with primary shard limit
            .indices()
            int test1UnassignedPrimaries = 0;
            assertEquals("Should have 1 unassigned primary in test1", 1, test1UnassignedPrimaries);
            assertEquals("test2 should have no unassigned shards", 0, test2UnassignedShards);
            Map<String, Integer> nodePrimaryCount = new HashMap<>();
    }
    }
                            String nodeId = shard.currentNodeId();
                        // Count primaries per node for test1
            Map<String, Integer> nodePrimaryCount = new HashMap<>();
                }
            "Index created from template should carry the primary shard limit",
                for (Integer count : test1NodePrimaryCount.values()) {
                    } else {
            Integer.valueOf(1),
        // Synchronization: Force flush relevant indices.
import java.util.List;
            // Check shard distribution
            for (IndexShardRoutingTable shardRouting : state.routingTable().index("test1")) {
            ClusterState state = client().admin().cluster().prepareState().get().getState();
    public void testIndexPrimaryShardLimit() throws Exception {
import org.opensearch.common.settings.Settings;
            for (IndexShardRoutingTable shardRouting : state.routingTable().index("test1")) {
}
            Map<String, Integer> nodePrimaryCount = new HashMap<>();
import org.opensearch.cluster.metadata.IndexMetadata;
                }
                        if (shard.primary()) {
            .put(remoteStoreIndexSettings(1, 4))  // 4 shards, 1 replica
            Map<String, Integer> nodePrimaryCount = new HashMap<>();
            int test1UnassignedShards = 0;
        cleanUp("test1", "test2");
            .put(INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 1)
                        unassignedShards++;
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING;
            int test1AssignedShards = 0;
    public void testCombinedIndexAndClusterPrimaryShardLimits() throws Exception {
        assertBusy(() -> {
            for (IndexShardRoutingTable shardRouting : state.routingTable().index("test1")) {
                        }
                    if (shard.assignedToNode()) {
        ensureGreen();
            // Verify no node has more than one primary shard
        logger.info("Flush request for {} completed.", Arrays.toString(indices));
        assertTrue(
                        if (shard.primary()) {
                    if (!shard.assignedToNode()) {
import org.junit.Before;
            assertEquals("Total shards should be 16", 16, state.getRoutingTable().allShards().size());
        List<String> dataNodes = internalCluster().startDataOnlyNodes(3);
                        unassignedShards++;
            }
            assertEquals("Should have 14 assigned shards", 14, totalAssignedShards);
                }
        // Create second index
            ClusterState state = client().admin().cluster().prepareState().get().getState();
        // Create first index
            assertEquals("test2 should have no unassigned shards", 0, test2UnassignedShards);
        AcknowledgedResponse response = client().admin().indices().updateSettings(updateSettingsRequest).actionGet();
            .put(INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 1)
    }
            }
                        // Count primaries per node for test1
        // On an all-remote-store cluster this must be acknowledged: the template validator should
            Map<String, Integer> nodePrimaryCount = new HashMap<>();
        // Create first index
            ClusterState state = client().admin().cluster().prepareState().get().getState();
        // And the limit must actually be enforced at allocation time: with 4 primaries, a limit of 1
import org.opensearch.cluster.ClusterState;
            assertEquals("Should have 1 unassigned replica", 1, unassignedReplicas);
            }
            // Count assigned and unassigned shards for test1
        // Create first index with primary shard limit
            // Verify no node has more than one primary shard of test1
        createIndex("test1", firstIndexSettings);
                        nodePrimaryCount.merge(nodeId, 1, Integer::sum);
        setupCustomCluster();
        createIndex("test1", firstIndexSettings);
            }
                        String nodeId = shard.currentNodeId();
            assertEquals("Should have 6 assigned shards", 6, assignedShards);
            // Check total number of shards (16 total: 8 from each index - 4 primaries + 4 replicas each)
            assertEquals("template-test1 should have 1 unassigned primary (blocked by the per-node limit)", 1, unassignedShards);
        // block) fully drives the index settings — including number_of_shards and the primary shard limit.
            int unassignedReplicas = 0;
                    } else {
                    if (!shard.assignedToNode()) {
            createdState.metadata().index("template-test1").getNumberOfShards()
            // Assertions
    }
                        test1UnassignedShards++;
            "Index created from template should carry 4 primary shards",
 * SPDX-License-Identifier: Apache-2.0
                        if (shard.primary()) {
    public void setup() {
                        }
            int test1UnassignedReplicas = 0;
            .put(remoteStoreIndexSettings(0, 4))  // 4 shards, 0 replicas
                        }
import org.opensearch.action.admin.indices.flush.FlushRequest;
            }
                        test1AssignedShards++;
        // Update cluster setting to limit primary shards per node
        client().admin().indices().prepareDeleteTemplate("primary-shard-limit-template").get();
        flushRequest.force(true); // Force even if no changes detected
        createIndex("test1", remoteStoreIndexSettings(1, 4));
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
        // Create second index with no index-level limits
        // The setting (and the injected remote-store flag) must have flowed from the template onto the
            .setPatterns(Collections.singletonList("template-test*"))
        );
            int test2UnassignedShards = 0;
                    if (shard.assignedToNode()) {
            .build();
            int assignedShards = 0;
        createIndex("test1", firstIndexSettings);
            // Assertions
                    assertTrue("No node should have more than 1 primary shard of test1", count <= 1);
/*
                }
                    } else {
                    }
                for (ShardRouting shard : shardRouting) {
        AcknowledgedResponse templateResponse = client().admin()
        Settings firstIndexSettings = Settings.builder()
import org.opensearch.cluster.routing.IndexShardRoutingTable;
                }
                Settings.builder()
            .build();
            int unassignedShards = 0;
            // Verify no node has more than one primary shard for test1
import java.util.Arrays;
            assertEquals("test1 should have 3 assigned shards", 3, test1AssignedShards);
            .get();
                    }
        Settings firstIndexSettings = Settings.builder()
import org.opensearch.test.OpenSearchIntegTestCase;
        );
            for (IndexShardRoutingTable shardRouting : state.routingTable().index("test1")) {
                for (ShardRouting shard : shardRouting) {
        updateSettingsRequest.settings(updatedSettings);
                        assignedShards++;
                }
            ClusterState state = client().admin().cluster().prepareState().get().getState();
                }
            }
        // Put an index template that carries index.routing.allocation.total_primary_shards_per_node.
        // Auto-create the index by indexing a document so the template (not a create-request settings
                            nodePrimaryCount.merge(nodeId, 1, Integer::sum);
                            nodePrimaryCount.merge(nodeId, 1, Integer::sum);
                            unassignedReplicas++;
            // Check test1 shard distribution
        });
            for (IndexShardRoutingTable shardRouting : state.routingTable().index("test2")) {
        });
                for (ShardRouting shard : shardRouting) {
                    }
                    }
        assertBusy(() -> {
                    }
            4,
            // Verify no node has more than one primary shard of test1
        // the index-local index.remote_store.enabled flag, which a template can never carry.
                assertTrue("No node should have more than 1 primary shard of template-test1", count <= 1);
        createIndex("test2", remoteStoreIndexSettings(0, 4));
            .put(remoteStoreIndexSettings(0, 4))  // 4 shards, 0 replicas
    public void testClusterPrimaryShardLimitss() throws Exception {
                            // Count primaries per node
            // Verify no node has more than three primary shards total (cluster-wide limit)
            INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.get(indexSettings)
import java.util.Collections;
            assertEquals("template-test1 should have 3 assigned primaries (one per data node)", 3, assignedShards);
                for (ShardRouting shard : shardRouting) {
            // Check total number of shards (8 total: 4 from each index)
                for (ShardRouting shard : shardRouting) {
        client().prepareIndex("template-test1").setId("1").setSource("field", "value").get();
            // Assertions
            int assignedShards = 0;
            // Check test2 shard assignment
                assertTrue("No node should have more than 1 primary shard of test1", count <= 1);
            }
 * compatible open source license.
                            String nodeId = shard.currentNodeId();
                        }
        logger.info(">>> Starting custom tearDown in ShardsLimitAllocationDeciderRemoteStoreEnabledIT");
        updateClusterSetting(CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 3);
    private void cleanUp(String... indices) throws Exception {
            ClusterState state = client().admin().cluster().prepareState().get().getState();
            int test1UnassignedShards = 0;
            // Count assigned and unassigned shards for both indices
            int totalAssignedShards = 0;
        FlushRequest flushRequest = new FlushRequest(indices);
            for (IndexShardRoutingTable shardRouting : state.routingTable().index("test2")) {
                for (ShardRouting shard : shardRouting) {
            assertEquals("test1 should have 1 unassigned shard", 1, test1UnassignedShards);
            // Check total number of shards (8 total: 4 primaries + 4 replicas)
        // concrete index — this is the core of the bug: previously the template PUT was rejected with 400.
        });
                        totalAssignedShards++;
        // Create first index with index-level primary shard limit
            for (Integer count : nodePrimaryCount.values()) {
            for (IndexShardRoutingTable shardRouting : state.routingTable().index("test2")) {
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(Settings.builder().put(setting, value)).get();
 * this file be licensed under the Apache-2.0 license or a
        createIndex("test2", remoteStoreIndexSettings(0, 4));
        assertEquals(
                    if (shard.assignedToNode()) {
                for (ShardRouting shard : shardRouting) {
        });
    }
                    }
            // Assertions
            }
            assertEquals("Total shards should be 8", 8, state.getRoutingTable().allShards().size());
    }
                        test2UnassignedShards++;
        UpdateSettingsRequest updateSettingsRequest = new UpdateSettingsRequest("test1");
        client().admin().indices().flush(flushRequest).actionGet(); // Use actionGet() or get() to wait
                        } else {
            for (IndexShardRoutingTable shardRouting : state.routingTable().index("template-test1")) {
                assertTrue("No node should have more than 3 primary shards total", count <= 3);
                    } else {
        assertTrue(response.isAcknowledged());
                    }
            // Check test1 shard distribution
                    } else {
                }
            for (Integer count : nodePrimaryCount.values()) {
        );
        assertBusy(() -> {
                    if (shard.assignedToNode()) {
            // Check test1 shard distribution
            .setSettings(
                        test1NodePrimaryCount.merge(shard.currentNodeId(), 1, Integer::sum);
                assertTrue("No node should have more than 1 primary shard of test1", count <= 1);
                        nodePrimaryCount.merge(nodeId, 1, Integer::sum);
        // Wait for green cluster state
            assertEquals("Should have 2 unassigned shards", 2, unassignedShards);
            assertEquals("test1 should have 3 assigned shards", 3, test1AssignedShards);
                        test2UnassignedShards++;
            assertEquals("Total shards should be 8", 8, state.getRoutingTable().allShards().size());
        logger.info("Attempting to flush indices {} to help sync remote store before cleanup...", Arrays.toString(indices));
    }
            int unassignedShards = 0;
    private void setupCustomCluster() {
        // Update the index settings to set INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING
                }
                    if (shard.assignedToNode()) {
    private void updateClusterSetting(String setting, int value) {
            // Check test2 shard assignment
    @Before
            int unassignedPrimaries = 0;
        // Create first index
            .preparePutTemplate("primary-shard-limit-template")
                    if (shard.assignedToNode() && shard.primary()) {
            // Check total number of shards (8 total: 4 from each index)
                        if (shard.primary()) {
                    }
    }
                            unassignedPrimaries++;
                    } else {
            .build();
            }
        cleanUp("template-test1");
                Map<String, Integer> test1NodePrimaryCount = new HashMap<>();
        Settings indexSettings = createdState.metadata().index("template-test1").getSettings();
                        totalAssignedShards++;
        Settings updatedSettings = Settings.builder().put(INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 1).build();
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING;
            assertEquals("Should have 1 unassigned replica in test1", 1, test1UnassignedReplicas);
            // Check test2 shard distribution
                assertTrue("No node should have more than 1 primary shard", count <= 1);
        flushRequest.waitIfOngoing(true); // Wait if flush already in progress
                        if (shard.primary()) {
            assertEquals("Should have no unassigned shards in test2", 0, test2UnassignedShards);
        cleanUp("test1");
        // Create index with 4 shards and 1 replica
        assertBusy(() -> {
        });
                            nodePrimaryCount.merge(nodeId, 1, Integer::sum);
        cleanUp("test1", "test2");
            for (IndexShardRoutingTable shardRouting : state.routingTable().index("test1")) {
            for (Integer count : nodePrimaryCount.values()) {
                        }
                    .put(INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 1)
            }
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
                            test1UnassignedReplicas++;
        updateClusterSetting(CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 1);
            int test2UnassignedShards = 0;
public class ShardsLimitAllocationDeciderRemoteStoreEnabledIT extends RemoteStoreBaseIntegTestCase {
                        nodePrimaryCount.merge(shard.currentNodeId(), 1, Integer::sum);
        assertBusy(() -> {
        ClusterState createdState = client().admin().cluster().prepareState().get().getState();
        // Start cluster manager node first
            for (Integer count : nodePrimaryCount.values()) {
        cleanUp("test1");
            // Count assigned and unassigned shards for test1
            .put(INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 1)
            // Count assigned and unassigned shards for test1
                        String nodeId = shard.currentNodeId();
 */
        assertEquals(
        createIndex("test2", remoteStoreIndexSettings(1, 4));  // 4 shards, 1 replica
import org.opensearch.cluster.routing.ShardRouting;
                    }
 * The OpenSearch Contributors require contributions made to
