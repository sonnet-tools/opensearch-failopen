        // Additional assertions to verify shard distribution  
    @Override
                assertEquals("test2 should have 0 unassigned shards", 0, unassignedShardsByIndex.getOrDefault("test2", 0).intValue());
        // Create the first two indices with 3 shards and 1 replica each
            .put(SETTING_NUMBER_OF_SHARDS, 3)
/*  
            throw new RuntimeException(e);  
import org.opensearch.index.IndexModule;
        Boolean isWarmEnabled = WRITABLE_WARM_INDEX_SETTING.get(settings);  
    }  
                for (IndexRoutingTable indexRoutingTable : state.getRoutingTable()) {
                    for (IndexShardRoutingTable shardRoutingTable : indexRoutingTable) {
        // Wait for cluster to stabilize and complete allocation decisions  
        boolean isWarmIndex = WRITABLE_WARM_INDEX_SETTING.get(settings);  
import org.opensearch.common.util.FeatureFlags;
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
import org.opensearch.core.common.unit.ByteSizeUnit;  
import java.util.HashSet;
    }
        }
    public void teardown() throws Exception {  
                ClusterState state = client().admin().cluster().prepareState().get().getState();
 */  
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.INDEX_TOTAL_SHARDS_PER_NODE_SETTING;
            Settings.builder().put(indexSettings()).put(SETTING_NUMBER_OF_SHARDS, 3).put(SETTING_NUMBER_OF_REPLICAS, 1).build()
    private Settings warmNodeSettings(ByteSizeValue cacheSize) {
            .put(SETTING_NUMBER_OF_REPLICAS, 1)
        // Verify the exception message
    @ParametersFactory  
                            } else {
    public void testCombinedClusterAndIndexSpecificShardLimits() {  
                .contains(
        );
        featureSettings.put(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG, true);  
        assertTrue(
            () -> { createIndex("test_index", indexSettings); }
            "test3",
            .put(SETTING_NUMBER_OF_REPLICAS, 1)  
                    String nodeName = routingNode.node().getName();
        return Settings.builder()  
                Map<String, Set<String>> indexShardsPerNode = new HashMap<>();
        }  
        assertTrue(
            Settings.builder().put(indexSettings()).put(SETTING_NUMBER_OF_SHARDS, 4).put(SETTING_NUMBER_OF_REPLICAS, 1).build()  
public class ShardsLimitAllocationDeciderIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
     * An end-user attempts to create an index with INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING  
        Settings indexSettings = Settings.builder()  
                    int indexUnassignedShards = 0;
            throw new RuntimeException(e);  
 * compatible open source license.
    }
                // Check total number of shards
                            }  
            builder.put(remoteStoreClusterSettings(REPOSITORY_NAME, absolutePath));
import org.opensearch.node.Node;
                                indexUnassignedShards++;  
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.CLUSTER_TOTAL_SHARDS_PER_NODE_SETTING;
            Settings.builder().put(indexSettings()).put(SETTING_NUMBER_OF_SHARDS, 2).put(SETTING_NUMBER_OF_REPLICAS, 1).build()  
    private void startTestNodes(int nodeCount) {  
        );
    }
        createIndex("test1", indexSettingsWithLimit);
            Settings nodeSettings = Settings.builder().put(warmNodeSettings(new ByteSizeValue(TOTAL_SPACE_BYTES))).build();  
     * Scenario:
        createIndex(
                    unassignedShardsByIndex.put(index, indexUnassignedShards);
                List<Integer> shardCounts = nodeShardCounts.values()
                ClusterState state = client().admin().cluster().prepareState().get().getState();  
            .put(indexSettings())
        createIndex(
 * The OpenSearch Contributors require contributions made to  
        }  
                : INDEX_TOTAL_REMOTE_CAPABLE_SHARDS_PER_NODE_SETTING.getKey();
        ensureStableCluster(expectedNodes);  
package org.opensearch.cluster.routing.allocation.decider;
    }  
import java.util.Collections;
                    for (IndexShardRoutingTable shardRoutingTable : indexRoutingTable) {  
        }
        }
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.INDEX_TOTAL_REMOTE_CAPABLE_PRIMARY_SHARDS_PER_NODE_SETTING;  
        createIndex("test2", indexSettingsWithoutLimit);
                // Check that all nodes have only one shard of the first index  
        // Wait for the shard limit to be applied  
     * or INDEX_TOTAL_REMOTE_CAPABLE_PRIMARY_SHARDS_PER_NODE_SETTING on a cluster where remote store is not enabled.
                assertEquals("Second node should have 6 shards", 6, shardCounts.get(1).intValue());  
            });  
     * The system should reject the index creation request and throw an appropriate exception,
                assertEquals("Total unassigned shards should be 2", 2, totalUnassignedShards);  
            return primary ? INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey() : INDEX_TOTAL_SHARDS_PER_NODE_SETTING.getKey();  
            assertBusy(() -> {  
        assumeFalse(
        boolean isWarmIndex = WRITABLE_WARM_INDEX_SETTING.get(settings);  
            Settings.builder().put(indexSettings()).put(SETTING_NUMBER_OF_SHARDS, 3).put(SETTING_NUMBER_OF_REPLICAS, 1).build()  
                assertEquals("test3 should have 0 unassigned shards", 0, unassignedShardsByIndex.getOrDefault("test3", 0).intValue());
        Settings indexSettingsWithLimit = Settings.builder()
                int totalUnassignedShards = 0;
                ClusterState state = client().admin().cluster().prepareState().get().getState();
                }
                // Check total number of shards  
import org.opensearch.cluster.routing.ShardRoutingState;  
        }
    }
 *
            .put(getIndexLevelShardsPerNodeKey(false), 1)
        createIndex(  
        );
    private String getShardsPerNodeKey(boolean primary) {
    public void testClusterTotalPrimaryShardsPerNodeSettingWithoutRemoteStore() {
    }  
                Map<String, Integer> nodeShardCounts = new HashMap<>();  
        if (isWarmIndex) {
import static org.opensearch.common.util.FeatureFlags.WRITABLE_WARM_INDEX_SETTING;  
        updateClusterSetting(getShardsPerNodeKey(false), 6);
            .put(getIndexLevelShardsPerNodeKey(false), 2)
        // Assert that creating the index throws an exception
                    nodeShardCounts.put(nodeName, routingNode.numberOfOwningShards());
            .put(SETTING_NUMBER_OF_REPLICAS, 1)  
     * indicating that this setting is only applicable for remote store enabled clusters.
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> {  
        );  
        // Attempt to create an index with INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING
    @Override  
        // Create the third index with 3 shards and 1 replica  
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING;
        // Force a reroute to ensure allocation is complete
                assertEquals("Should have 3 nodes with shards", 3, shardCounts.size());
        int expectedNodes = currentState.getNodes().getSize();
                assertEquals(22, state.getRoutingTable().allShards().size());
            .put(super.nodeSettings(0))
            .put(SETTING_NUMBER_OF_SHARDS, 3)  
                        + "can only be used with remote store enabled clusters"
        if (testName.contains("WithoutRemoteStore") == false) {  
                    int indexUnassignedShards = 0;  
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), true).build() }
            Settings.builder().put(indexSettings()).put(SETTING_NUMBER_OF_SHARDS, 3).put(SETTING_NUMBER_OF_REPLICAS, 1).build()
        } catch (Exception e) {
import org.junit.After;  
            return CLUSTER_TOTAL_REMOTE_CAPABLE_SHARDS_PER_NODE_SETTING.getKey();
     * Integration test to verify the behavior of INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING
        );
        createIndex(
                        }
                            }
            return primary ? CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey() : CLUSTER_TOTAL_SHARDS_PER_NODE_SETTING.getKey();
        createIndex("test1", indexSettingsWithLimit);
        Settings indexSettingsWithoutLimit = Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 4).put(SETTING_NUMBER_OF_REPLICAS, 1).build();
        // Create the third index with 2 shards and 1 replica  
            .build();
            exception.getMessage()
    private String getIndexLevelShardsPerNodeKey(boolean primary) {
        Settings.Builder featureSettings = Settings.builder();
            .put(indexSettings())
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), false).build() },  
            return Settings.builder().put(super.indexSettings()).put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true).build();
            "Exception should mention that the setting requires remote store",  
                for (IndexRoutingTable indexRoutingTable : state.getRoutingTable()) {
                }  
    protected Settings nodeSettings(int nodeOrdinal) {  
import org.opensearch.cluster.routing.RoutingNode;
 * this file be licensed under the Apache-2.0 license or a
        createIndex(
     * The system should reject the index creation request and throw an appropriate exception,
            .put(SETTING_NUMBER_OF_SHARDS, 3)
                assertEquals("Total assigned shards should be 17", 17, totalAssignedShards);
            "test2",
        );
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
     */  
        try {
     * Expected Outcome:  
                        }
            exception.getMessage()
    public Settings indexSettings() {
            internalCluster().startWarmOnlyNodes(nodeCount, nodeSettings);
                // Check number of unassigned shards
                int totalAssignedShards = 0;
        assertEquals("Total assigned shards should be 12", 12, totalAssignedShards);  
    }  
     * or INDEX_TOTAL_REMOTE_CAPABLE_PRIMARY_SHARDS_PER_NODE_SETTING in a non-remote store environment.  
        );
            totalAssignedShards += routingNode.numberOfOwningShards();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
                            if (shardRouting.unassigned()) {
 * SPDX-License-Identifier: Apache-2.0
                assertEquals("test1 should have 2 unassigned shards", 2, unassignedShardsByIndex.get("test1").intValue());  
                // Check shard distribution across nodes  
                int totalAssignedShards = 0;  
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)  
}  
        updateClusterSetting(getShardsPerNodeKey(false), 4);  
            "test3",  
            Settings.builder().put(indexSettings()).put(SETTING_NUMBER_OF_SHARDS, 3).put(SETTING_NUMBER_OF_REPLICAS, 1).build()  
        // Attempt to create an index with INDEX_TOTAL_SHARDS_PER_NODE_SETTING
        return Arrays.asList(
            IllegalArgumentException.class,  
                int totalUnassignedShards = 0;
                // Check total number of assigned and unassigned shards  
    /**
        if (isWarmEnabled) {
    }
                    }
import java.util.Arrays;  
            .put(SETTING_NUMBER_OF_REPLICAS, 1)
        );
        }
            });
                ? INDEX_TOTAL_REMOTE_CAPABLE_PRIMARY_SHARDS_PER_NODE_SETTING.getKey()  
                // Check total number of shards  
                assertEquals("Total unassigned shards should be 3", 3, totalUnassignedShards);
                                totalAssignedShards++;
import java.util.Map;  
                    }  
     * indicating that this setting is only applicable for remote store enabled clusters.
        Settings.Builder builder = Settings.builder();
        );  
                    .filter(count -> count > 0)
     */  
     *
                }  
                int unassignedShards = state.getRoutingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size();  
    /**  
                    indexShardsPerNode.put(nodeName, new HashSet<>());  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;  
        assumeTrue(
        } else {
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.INDEX_TOTAL_REMOTE_CAPABLE_SHARDS_PER_NODE_SETTING;
            .put(SETTING_NUMBER_OF_SHARDS, 4)  
        }
        if (absolutePath == null) {
        }
        }
                                indexUnassignedShards++;
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.CLUSTER_TOTAL_REMOTE_CAPABLE_SHARDS_PER_NODE_SETTING;  
                .contains(
                        for (ShardRouting shardRouting : shardRoutingTable) {  
    }
        if (isWarmIndex) {
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
import java.util.HashMap;  
     * Helper method to start nodes that support both data and warm roles
    protected Path absolutePath;  
            // Wait for the shard limit to be applied
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;  
        } else {  
                    for (ShardRouting shardRouting : routingNode) {
                                totalUnassignedShards++;
    public static Collection<Object[]> parameters() {
@ParameterizedStaticSettingsOpenSearchIntegTestCase.ClusterScope(scope = ParameterizedStaticSettingsOpenSearchIntegTestCase.Scope.TEST, numDataNodes = 3)
    }
        for (RoutingNode routingNode : state.getRoutingNodes()) {  
        // Create the first index with 4 shards, 1 replica, and the index-specific limit
            assertBusy(() -> {
    /**
    }
            "Exception should mention that the setting requires remote store",  
                Map<String, Integer> unassignedShardsByIndex = new HashMap<>();  
    public void testClusterWideShardsLimit() {  
import java.nio.file.Path;
    @After
    protected static final String REPOSITORY_NAME = "test-remote-store-repo";
        startTestNodes(3);
                )  
    public void testIndexSpecificShardLimit() {
        ClusterState currentState = client().admin().cluster().prepareState().get().getState();
                        + "[index.routing.allocation.total_remote_capable_primary_shards_per_node] "
    public void testIndexTotalPrimaryShardsPerNodeSettingWithoutRemoteStore() {
        } catch (Exception e) {
                for (RoutingNode routingNode : state.getRoutingNodes()) {  
            "test2",
                    String index = indexRoutingTable.getIndex().getName();
                    "Setting [index.routing.allocation.total_primary_shards_per_node] or "  
        // Set the cluster-wide shard limit to 2
                // Check shard distribution across nodes - only count nodes that have shards
                    }
    private static final long TOTAL_SPACE_BYTES = new ByteSizeValue(100, ByteSizeUnit.KB).getBytes();  
    }
            throw new RuntimeException(e);
                assertEquals(4, unassignedShards);
                    assertTrue("Node exceeds shard limit", routingNode.numberOfOwningShards() <= 4);
        } catch (Exception e) {
     * Integration test to verify the behavior of CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING
     * An end-user attempts to create an index with CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING  
        return WRITABLE_WARM_INDEX_SETTING.get(settings) == false;  
                    String index = indexRoutingTable.getIndex().getName();  
        createIndex("test_index", indexSettings);
        String testName = getTestName();
import org.opensearch.cluster.ClusterState;
        Settings indexSettings = Settings.builder()  
    public ShardsLimitAllocationDeciderIT(Settings nodeSettings) {
                Map<String, Integer> unassignedShardsByIndex = new HashMap<>();
import java.util.Collection;
import org.opensearch.core.common.unit.ByteSizeValue;
     * in a non-remote store environment.  
            .build();  
     */
import java.util.List;
        // Create the third index with 3 shards and 1 replica, without the index-specific limit
                        indexShardsPerNode.get(nodeName).add(shardRouting.getIndexName());  
        super(nodeSettings);  
            return primary
                                totalUnassignedShards++;  
     * on a cluster where remote store is not enabled.
                                totalAssignedShards++;  
import org.opensearch.cluster.routing.IndexRoutingTable;
            .build();  
                    .stream()  
                assertEquals(16, state.getRoutingTable().allShards().size());  
                )
        int totalAssignedShards = 0;
        // Set the index-specific shard limit to 2 for the first index only  
            "https://github.com/opensearch-project/OpenSearch/issues/19726#issuecomment-4049069484",
        // Create the second index with 4 shards and 1 replica  
        );
            "test1",
     * Scenario:
                            if (shardRouting.unassigned()) {
    protected boolean addMockIndexStorePlugin() {
        return featureSettings.build();
        });
                        for (ShardRouting shardRouting : shardRoutingTable) {
            "test3",
import java.util.Set;
        try {
            return super.indexSettings();
                assertEquals("Total assigned shards should be 20", 20, totalAssignedShards);
        startTestNodes(3);
import org.opensearch.common.settings.Settings;
        ClusterState state = client().admin().cluster().prepareState().get().getState();
        createIndex(
                        + "can only be used with remote store enabled clusters"
            .put(indexSettings())
        startTestNodes(3);
    @Override
                    "Setting [cluster.routing.allocation.total_primary_shards_per_node] "  
        String testName = getTestName();
     *
                for (RoutingNode routingNode : state.getRoutingNodes()) {
        if (isWarmIndex) {
                    unassignedShardsByIndex.put(index, indexUnassignedShards);
    }  
        );
        }
            WRITABLE_WARM_INDEX_SETTING.get(settings) == false
    }
import org.opensearch.cluster.routing.ShardRouting;
                assertEquals("test3 should have 0 unassigned shards", 0, unassignedShardsByIndex.get("test3").intValue());
    }
                assertEquals("Total shards should be 20", 20, state.getRoutingTable().allShards().size());
     *
        boolean isWarmIndex = WRITABLE_WARM_INDEX_SETTING.get(settings);
                }
     *
            .put(getIndexLevelShardsPerNodeKey(true), 1)
            "Test should only run in the default (non-parameterized) test suite",  
        client().admin().cluster().prepareReroute().setRetryFailed(true).get();  
        IllegalArgumentException exception = expectThrows(
            .put(getIndexLevelShardsPerNodeKey(false), 1)
        // Set the cluster-wide shard limit to 6  
        if (testName.contains("WithoutRemoteStore") == false) {
    }
    private void updateClusterSetting(String setting, int value) {
            assertBusy(() -> {  
            .build();
        // Create the second index with 4 shards and 1 replica, without the index-specific limit
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
            updateClusterSetting(getShardsPerNodeKey(true), 1);
        // Verify the exception message
                            } else {
                assertEquals("test2 should have 0 unassigned shards", 0, unassignedShardsByIndex.get("test2").intValue());
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(Settings.builder().put(setting, value)).get();
            absolutePath = randomRepoPath().toAbsolutePath();
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING;
                    .sorted(Collections.reverseOrder())
     * Expected Outcome:  
        );
        } else {  
        return builder.put(super.nodeSettings(nodeOrdinal)).build();  
            }, 60, java.util.concurrent.TimeUnit.SECONDS);
        Settings indexSettingsWithLimit = Settings.builder()
    @Override
                assertEquals("First node should have 6 shards", 6, shardCounts.get(0).intValue());
                assertEquals("Third node should have 5 shards", 5, shardCounts.get(2).intValue());
        try {
            .put(indexSettings())
            WRITABLE_WARM_INDEX_SETTING.get(settings)  
                // Check unassigned shards for each index
                    .toList();  
        // Create the first index with 3 shards, 1 replica, and index-specific limit of 1  
    protected Settings featureFlagSettings() {
            .build();  
            clusterAdmin().prepareCleanupRepository(REPOSITORY_NAME).get();  
                assertEquals("test1 should have 3 unassigned shards", 3, unassignedShardsByIndex.get("test1").intValue());  
