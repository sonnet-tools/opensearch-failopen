        }
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.INDEX_TOTAL_SHARDS_PER_NODE_SETTING;
                    String index = indexRoutingTable.getIndex().getName();
     * indicating that this setting is only applicable for remote store enabled clusters.
import org.opensearch.core.common.unit.ByteSizeUnit;
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.CLUSTER_TOTAL_SHARDS_PER_NODE_SETTING;
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        }
import org.opensearch.cluster.routing.IndexRoutingTable;
        startTestNodes(3);
                // Check total number of assigned and unassigned shards
                assertEquals("Total unassigned shards should be 3", 3, totalUnassignedShards);
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
                ? INDEX_TOTAL_REMOTE_CAPABLE_PRIMARY_SHARDS_PER_NODE_SETTING.getKey()
        }
            return primary ? CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey() : CLUSTER_TOTAL_SHARDS_PER_NODE_SETTING.getKey();
            Settings.builder().put(indexSettings()).put(SETTING_NUMBER_OF_SHARDS, 3).put(SETTING_NUMBER_OF_REPLICAS, 1).build()
        assertTrue(
            .build();
    }
                    "Setting [index.routing.allocation.total_primary_shards_per_node] or "
                    String index = indexRoutingTable.getIndex().getName();
    protected Path absolutePath;
            WRITABLE_WARM_INDEX_SETTING.get(settings)
            Settings nodeSettings = Settings.builder().put(warmNodeSettings(new ByteSizeValue(TOTAL_SPACE_BYTES))).build();
        } catch (Exception e) {
@ParameterizedStaticSettingsOpenSearchIntegTestCase.ClusterScope(scope = ParameterizedStaticSettingsOpenSearchIntegTestCase.Scope.TEST, numDataNodes = 3)
        // Create the third index with 2 shards and 1 replica
    }
    protected Settings featureFlagSettings() {
            Settings.builder().put(indexSettings()).put(SETTING_NUMBER_OF_SHARDS, 3).put(SETTING_NUMBER_OF_REPLICAS, 1).build()
        if (isWarmEnabled) {
                assertEquals(22, state.getRoutingTable().allShards().size());
                // Check shard distribution across nodes
            "test2",
                assertEquals("Total assigned shards should be 20", 20, totalAssignedShards);
        createIndex("test2", indexSettingsWithoutLimit);
        // Force a reroute to ensure allocation is complete
     * on a cluster where remote store is not enabled.
import java.util.Map;
 * compatible open source license.
     */
    public void testCombinedClusterAndIndexSpecificShardLimits() {
                assertEquals(16, state.getRoutingTable().allShards().size());
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
        // Set the index-specific shard limit to 2 for the first index only
        Settings.Builder featureSettings = Settings.builder();
                    nodeShardCounts.put(nodeName, routingNode.numberOfOwningShards());
                            } else {
        } else {
        // Attempt to create an index with INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(Settings.builder().put(setting, value)).get();
 * SPDX-License-Identifier: Apache-2.0
                        }
        assertTrue(
                assertEquals("Third node should have 5 shards", 5, shardCounts.get(2).intValue());
    @Override
                    }
        return builder.put(super.nodeSettings(nodeOrdinal)).build();
    @Override
                assertEquals("test2 should have 0 unassigned shards", 0, unassignedShardsByIndex.get("test2").intValue());
 */
import java.util.Set;
            exception.getMessage()
import org.opensearch.common.util.FeatureFlags;
                                totalAssignedShards++;
package org.opensearch.cluster.routing.allocation.decider;
     * An end-user attempts to create an index with CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING
                        for (ShardRouting shardRouting : shardRoutingTable) {
        } else {
                // Check that all nodes have only one shard of the first index
        // Create the second index with 4 shards and 1 replica
        } catch (Exception e) {
            .put(SETTING_NUMBER_OF_REPLICAS, 1)
        IllegalArgumentException exception = expectThrows(
                assertEquals("test1 should have 2 unassigned shards", 2, unassignedShardsByIndex.get("test1").intValue());
            });
                    .stream()
        }
    }
            .put(SETTING_NUMBER_OF_SHARDS, 4)
    }
     * in a non-remote store environment.
    /**
        try {
                    int indexUnassignedShards = 0;
        // Assert that creating the index throws an exception
                ClusterState state = client().admin().cluster().prepareState().get().getState();
                assertEquals("Total assigned shards should be 17", 17, totalAssignedShards);
        );
                assertEquals("First node should have 6 shards", 6, shardCounts.get(0).intValue());
        createIndex(
import org.opensearch.cluster.routing.ShardRoutingState;
    public ShardsLimitAllocationDeciderIT(Settings nodeSettings) {
        Settings indexSettingsWithoutLimit = Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 4).put(SETTING_NUMBER_OF_REPLICAS, 1).build();
            .put(SETTING_NUMBER_OF_SHARDS, 3)
                for (RoutingNode routingNode : state.getRoutingNodes()) {
                assertEquals("Total unassigned shards should be 2", 2, totalUnassignedShards);
                ClusterState state = client().admin().cluster().prepareState().get().getState();
    private void updateClusterSetting(String setting, int value) {
     * or INDEX_TOTAL_REMOTE_CAPABLE_PRIMARY_SHARDS_PER_NODE_SETTING in a non-remote store environment.
        Settings indexSettings = Settings.builder()
    @After
            .put(getIndexLevelShardsPerNodeKey(false), 1)
        boolean isWarmIndex = WRITABLE_WARM_INDEX_SETTING.get(settings);
                // Check unassigned shards for each index
                            }
     *
                        }
        createIndex(
            }, 60, java.util.concurrent.TimeUnit.SECONDS);
                : INDEX_TOTAL_REMOTE_CAPABLE_SHARDS_PER_NODE_SETTING.getKey();
        boolean isWarmIndex = WRITABLE_WARM_INDEX_SETTING.get(settings);
                Map<String, Integer> unassignedShardsByIndex = new HashMap<>();
                        + "can only be used with remote store enabled clusters"
        // Set the cluster-wide shard limit to 6
            totalAssignedShards += routingNode.numberOfOwningShards();
    private String getShardsPerNodeKey(boolean primary) {
                    "Setting [cluster.routing.allocation.total_primary_shards_per_node] "
                    }
        // Create the first two indices with 3 shards and 1 replica each
import java.util.HashSet;
    public void teardown() throws Exception {
     * Integration test to verify the behavior of INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING
 *
            return primary ? INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey() : INDEX_TOTAL_SHARDS_PER_NODE_SETTING.getKey();
        return Settings.builder()
 * The OpenSearch Contributors require contributions made to
        }
            Settings.builder().put(indexSettings()).put(SETTING_NUMBER_OF_SHARDS, 2).put(SETTING_NUMBER_OF_REPLICAS, 1).build()
    private String getIndexLevelShardsPerNodeKey(boolean primary) {
     */
                    for (IndexShardRoutingTable shardRoutingTable : indexRoutingTable) {
            });
            Settings.builder().put(indexSettings()).put(SETTING_NUMBER_OF_SHARDS, 3).put(SETTING_NUMBER_OF_REPLICAS, 1).build()
                                totalUnassignedShards++;
            .build();
import java.util.Arrays;
                }
        if (isWarmIndex) {
     * The system should reject the index creation request and throw an appropriate exception,
        client().admin().cluster().prepareReroute().setRetryFailed(true).get();
                }
            IllegalArgumentException.class,
        String testName = getTestName();
import java.util.Collections;
                for (IndexRoutingTable indexRoutingTable : state.getRoutingTable()) {
        return WRITABLE_WARM_INDEX_SETTING.get(settings) == false;
        featureSettings.put(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG, true);
            .put(getIndexLevelShardsPerNodeKey(false), 2)
    }
            return primary
        }
        );
        }
        updateClusterSetting(getShardsPerNodeKey(false), 6);
        int totalAssignedShards = 0;
            throw new RuntimeException(e);
                int totalUnassignedShards = 0;
        // Verify the exception message
    public void testIndexSpecificShardLimit() {
                for (IndexRoutingTable indexRoutingTable : state.getRoutingTable()) {
import org.opensearch.node.Node;
            .build();
    /**
    }
    public void testClusterTotalPrimaryShardsPerNodeSettingWithoutRemoteStore() {
            internalCluster().startWarmOnlyNodes(nodeCount, nodeSettings);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
     * Expected Outcome:
            "test2",
                // Check total number of shards
import org.opensearch.cluster.ClusterState;
        boolean isWarmIndex = WRITABLE_WARM_INDEX_SETTING.get(settings);
        );
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), false).build() },
                // Check total number of shards
        if (isWarmIndex) {
        // Set the cluster-wide shard limit to 2
        if (isWarmIndex) {
    }
            return CLUSTER_TOTAL_REMOTE_CAPABLE_SHARDS_PER_NODE_SETTING.getKey();
                assertEquals("test1 should have 3 unassigned shards", 3, unassignedShardsByIndex.get("test1").intValue());
            .put(indexSettings())
                int totalAssignedShards = 0;
    }
                assertEquals("Total shards should be 20", 20, state.getRoutingTable().allShards().size());
        // Wait for cluster to stabilize and complete allocation decisions
                }
                assertEquals("Should have 3 nodes with shards", 3, shardCounts.size());
            absolutePath = randomRepoPath().toAbsolutePath();
                int totalAssignedShards = 0;
                    unassignedShardsByIndex.put(index, indexUnassignedShards);
    protected static final String REPOSITORY_NAME = "test-remote-store-repo";
        if (testName.contains("WithoutRemoteStore") == false) {
    }
        // Create the third index with 3 shards and 1 replica
import java.util.Collection;
                            }
                    .sorted(Collections.reverseOrder())
                    int indexUnassignedShards = 0;
        String testName = getTestName();
                    String nodeName = routingNode.node().getName();
                ClusterState state = client().admin().cluster().prepareState().get().getState();
                    for (ShardRouting shardRouting : routingNode) {
                int unassignedShards = state.getRoutingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size();
            "Exception should mention that the setting requires remote store",
            assertBusy(() -> {
                )
public class ShardsLimitAllocationDeciderIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            .build();
            builder.put(remoteStoreClusterSettings(REPOSITORY_NAME, absolutePath));
        try {
        );
                            if (shardRouting.unassigned()) {
                                totalUnassignedShards++;
        );
            .put(indexSettings())
        });
        }
            Settings.builder().put(indexSettings()).put(SETTING_NUMBER_OF_SHARDS, 3).put(SETTING_NUMBER_OF_REPLICAS, 1).build()
                .contains(
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
import static org.opensearch.common.util.FeatureFlags.WRITABLE_WARM_INDEX_SETTING;
     * or INDEX_TOTAL_REMOTE_CAPABLE_PRIMARY_SHARDS_PER_NODE_SETTING on a cluster where remote store is not enabled.
        Settings indexSettings = Settings.builder()
import org.opensearch.core.common.unit.ByteSizeValue;
            "test1",
                                indexUnassignedShards++;
                assertEquals("test2 should have 0 unassigned shards", 0, unassignedShardsByIndex.getOrDefault("test2", 0).intValue());
            // Wait for the shard limit to be applied
     * Integration test to verify the behavior of CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING
    protected boolean addMockIndexStorePlugin() {
     * Helper method to start nodes that support both data and warm roles
                        indexShardsPerNode.get(nodeName).add(shardRouting.getIndexName());
import org.opensearch.index.IndexModule;
import org.junit.After;
    }
        Boolean isWarmEnabled = WRITABLE_WARM_INDEX_SETTING.get(settings);
                List<Integer> shardCounts = nodeShardCounts.values()
    @Override
        );
                        for (ShardRouting shardRouting : shardRoutingTable) {
    @ParametersFactory
                    .toList();
        createIndex(
        try {
            .put(getIndexLevelShardsPerNodeKey(true), 1)
            WRITABLE_WARM_INDEX_SETTING.get(settings) == false
        }
import org.opensearch.cluster.routing.RoutingNode;
    }
    private Settings warmNodeSettings(ByteSizeValue cacheSize) {
        );
        assumeFalse(
            "https://github.com/opensearch-project/OpenSearch/issues/19726#issuecomment-4049069484",
import java.util.HashMap;
        createIndex("test1", indexSettingsWithLimit);
            return super.indexSettings();
                assertEquals("Second node should have 6 shards", 6, shardCounts.get(1).intValue());
                Map<String, Set<String>> indexShardsPerNode = new HashMap<>();
        // Create the second index with 4 shards and 1 replica, without the index-specific limit
                int totalUnassignedShards = 0;
/*
    protected Settings nodeSettings(int nodeOrdinal) {
            "Exception should mention that the setting requires remote store",
                                totalAssignedShards++;
        }
            "test3",
        );
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> {
    }
        if (testName.contains("WithoutRemoteStore") == false) {
                        + "can only be used with remote store enabled clusters"
            .put(indexSettings())
                Map<String, Integer> nodeShardCounts = new HashMap<>();
     * Scenario:
    }
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
    public static Collection<Object[]> parameters() {
            .put(SETTING_NUMBER_OF_SHARDS, 3)
            .put(super.nodeSettings(0))
        ClusterState currentState = client().admin().cluster().prepareState().get().getState();
            return Settings.builder().put(super.indexSettings()).put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true).build();
        }
            "test3",
                    unassignedShardsByIndex.put(index, indexUnassignedShards);
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.INDEX_TOTAL_REMOTE_CAPABLE_PRIMARY_SHARDS_PER_NODE_SETTING;
        // Attempt to create an index with INDEX_TOTAL_SHARDS_PER_NODE_SETTING
        // Create the first index with 4 shards, 1 replica, and the index-specific limit
        // Additional assertions to verify shard distribution
    }
        int expectedNodes = currentState.getNodes().getSize();
                }
     *
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
                .contains(
import org.opensearch.cluster.routing.ShardRouting;
    }
                    assertTrue("Node exceeds shard limit", routingNode.numberOfOwningShards() <= 4);
            throw new RuntimeException(e);
    public void testIndexTotalPrimaryShardsPerNodeSettingWithoutRemoteStore() {
        startTestNodes(3);
        // Create the third index with 3 shards and 1 replica, without the index-specific limit
        createIndex("test_index", indexSettings);
            .put(SETTING_NUMBER_OF_SHARDS, 3)
            .put(getIndexLevelShardsPerNodeKey(false), 1)
        } else {
    private static final long TOTAL_SPACE_BYTES = new ByteSizeValue(100, ByteSizeUnit.KB).getBytes();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
                for (RoutingNode routingNode : state.getRoutingNodes()) {
        return Arrays.asList(
            throw new RuntimeException(e);
            "Test should only run in the default (non-parameterized) test suite",
     * Scenario:
                // Check number of unassigned shards
        // Verify the exception message
            assertBusy(() -> {
                                indexUnassignedShards++;
            exception.getMessage()
}
     *
            () -> { createIndex("test_index", indexSettings); }
        Settings indexSettingsWithLimit = Settings.builder()
            clusterAdmin().prepareCleanupRepository(REPOSITORY_NAME).get();
     */
            assertBusy(() -> {
        Settings indexSettingsWithLimit = Settings.builder()
        createIndex(
                    indexShardsPerNode.put(nodeName, new HashSet<>());
                            } else {
     * indicating that this setting is only applicable for remote store enabled clusters.
        assumeTrue(
     * The system should reject the index creation request and throw an appropriate exception,
import org.opensearch.cluster.routing.IndexShardRoutingTable;
                assertEquals("test3 should have 0 unassigned shards", 0, unassignedShardsByIndex.getOrDefault("test3", 0).intValue());
            .put(indexSettings())
                        + "[index.routing.allocation.total_remote_capable_primary_shards_per_node] "
     * An end-user attempts to create an index with INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING
            .put(SETTING_NUMBER_OF_REPLICAS, 1)
    /**
            .put(SETTING_NUMBER_OF_REPLICAS, 1)
                            if (shardRouting.unassigned()) {
        );
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), true).build() }
        // Wait for the shard limit to be applied
        );
import org.opensearch.common.settings.Settings;
    }
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING;
        if (absolutePath == null) {
 * this file be licensed under the Apache-2.0 license or a
            .build();
        createIndex(
                Map<String, Integer> unassignedShardsByIndex = new HashMap<>();
                    }
     * Expected Outcome:
        createIndex(
        super(nodeSettings);
import java.util.List;
    public void testClusterWideShardsLimit() {
    private void startTestNodes(int nodeCount) {
                    .filter(count -> count > 0)
            "test3",
                // Check total number of shards
                // Check shard distribution across nodes - only count nodes that have shards
            .put(SETTING_NUMBER_OF_REPLICAS, 1)
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING;
                assertEquals("test3 should have 0 unassigned shards", 0, unassignedShardsByIndex.get("test3").intValue());
        );
                assertEquals(4, unassignedShards);
        ClusterState state = client().admin().cluster().prepareState().get().getState();
        startTestNodes(3);
                )
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.INDEX_TOTAL_REMOTE_CAPABLE_SHARDS_PER_NODE_SETTING;
        for (RoutingNode routingNode : state.getRoutingNodes()) {
                    for (IndexShardRoutingTable shardRoutingTable : indexRoutingTable) {
        // Create the first index with 3 shards, 1 replica, and index-specific limit of 1
        ensureStableCluster(expectedNodes);
        updateClusterSetting(getShardsPerNodeKey(false), 4);
        );
    }
import java.nio.file.Path;
            Settings.builder().put(indexSettings()).put(SETTING_NUMBER_OF_SHARDS, 4).put(SETTING_NUMBER_OF_REPLICAS, 1).build()
        createIndex("test1", indexSettingsWithLimit);
        Settings.Builder builder = Settings.builder();
     *
            updateClusterSetting(getShardsPerNodeKey(true), 1);
        return featureSettings.build();
        } catch (Exception e) {
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.CLUSTER_TOTAL_REMOTE_CAPABLE_SHARDS_PER_NODE_SETTING;
        assertEquals("Total assigned shards should be 12", 12, totalAssignedShards);
    @Override
    public Settings indexSettings() {
