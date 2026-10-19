                .put(indexSettings())
                        .build();
    public void testIndexCreationOverLimitForDotIndexesFail() {
            Settings.builder()
        );
 * specific language governing permissions and limitations
            } else {
        return isWarmIndex ? RoutingPool.REMOTE_CAPABLE : RoutingPool.LOCAL_ONLY;
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
                    .cluster()
        );  
            ".test-index",
    @Override  
        dataNodes = ensureMultipleDataNodes(dataNodes);  
        // Create an index that will bring us up to the limit
    protected Path absolutePath;
        ShardCounts counts = ShardCounts.forDataNodeCount(dataNodes);
        try {  
    private void setMaxShardLimit(int limit, String key) {  
            new NodeConfigurationSource() {
            .cluster()
        verifyException(dataNodes, counts, e);
        int currentActiveShards = client().admin().cluster().prepareHealth().get().getActiveShards();
            .build();
                .put(SETTING_NUMBER_OF_SHARDS, counts.getFirstIndexShards())
            Settings.builder().put(indexSettings()).put(SETTING_NUMBER_OF_SHARDS, firstShardCount).put(SETTING_NUMBER_OF_REPLICAS, 0)
                .get();
        int maxAllowedShards = dataNodes * dataNodes;
            String expectedError = "Validation Failed: 1: this action would add ["
                .prepareUpdateSettings("growing-should-fail")
        try {
        clusterAdmin().prepareCleanupRepository(REPOSITORY_NAME).get();
    }  
        repoSettings.put("compress", randomBoolean());
        assertEquals(0, clusterState.index("growing-should-fail").getNumberOfReplicas());  
                    .prepareUpdateSettings()
 * SPDX-License-Identifier: Apache-2.0
                }  
        createIndex(  
    @Override
            .getSnapshots();
        createIndex(  
        }
                    .put(SETTING_NUMBER_OF_SHARDS, extraShardCount)
        if (isWarmIndex) {
import org.opensearch.cluster.metadata.Metadata;
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
            createIndex(
        Client client = client();
     * setting is set to true. If the cluster.ignore_Dot_indexes is set to true index creation of  
                + (dataNodes * firstShardCount)
        } catch (IllegalArgumentException e) {
                    .put(SETTING_NUMBER_OF_REPLICAS, 0)
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
            createIndex(  
        Metadata clusterState = client().admin().cluster().prepareState().get().getState().metadata();
        } catch (IllegalArgumentException e) {
        // Starting 2 data nodes
            "test-fill",  
        createIndex(
            .setWaitForGreenStatus()
        int firstIndexFactor = between(5, 10);  
import org.opensearch.common.util.io.IOUtils;
    }
            Settings nodeSettings = Settings.builder().put(warmNodeSettings(new ByteSizeValue(TOTAL_SPACE_BYTES))).build();
        } catch (IllegalArgumentException ex) {  
            randomLong(),
        assertFalse(clusterState.getMetadata().hasIndex("should-fail"));  
                .put(SETTING_NUMBER_OF_REPLICAS, 0)
            .admin()
public class ClusterShardLimitIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        int firstShardCount = between(2, 10);
    /**
    }
        int firstIndexShards = firstIndexFactor * dataNodes;
        }
        try {
        boolean isWarmIndex = WRITABLE_WARM_INDEX_SETTING.get(settings);  
            "cluster",
                assertEquals(ignoreDotIndex, response.getPersistentSettings().getAsBoolean(ignoreDotIndexKey, true));  
        setIgnoreDotIndex(true);  
        );
            .prepareCreateSnapshot("test-repo", "test-snap")
                .put(indexSettings())
            verifyException(maxAllowedShardsPerCluster, currentActiveShards, extraShardCount, ex);  
     *
            "growing-should-fail",
package org.opensearch.cluster.shards;
            Settings.builder()  
        return dataNodes;  
                assertEquals(limit, response.getTransientSettings().getAsInt(key, -1).intValue());
        if (counts.getFirstIndexShards() > 0) {
import static org.opensearch.indices.ShardLimitValidator.SETTING_CLUSTER_MAX_REMOTE_CAPABLE_SHARDS_PER_NODE;  
import java.util.List;  
            );  
                response = client().admin()
            }
        int maxShards = counts.getShardsPerNode() * dataNodes;
        assertEquals(expectedError, e.getMessage());
            + " shards, but this cluster currently has ["
        // replicas, we should never get an error here.  
                .indices()
     */
            absolutePath = randomRepoPath().toAbsolutePath();  
        // Creating an index starting with dot having shards greater thn the desired node limit
                .put(indexSettings())
        String maxShardsPerNode = clusterState.getMetadata().settings().get(getShardsPerNodeKey());
        ShardCounts counts = ShardCounts.forDataNodeCount(dataNodes);  
        // Test restore after index deletion
     * Set max shard limit on either per node level or on cluster level.
        cluster.beforeTest(random());
                response = client().admin()
    protected Settings nodeSettings(int nodeOrdinal) {
                    .build()  
        // Checking if the total shards created are equivalent to dataNodes * cluster.max_shards_per_node
        }
    }  
            0,
        int shardsPerNode = firstShardCount - 1;  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;  
    public ClusterShardLimitIT(Settings nodeSettings) {  
        );
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
                    return Settings.builder()
        }
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, extraShardCount).put(SETTING_NUMBER_OF_REPLICAS, 0).build()  
import org.opensearch.core.common.unit.ByteSizeValue;
                    .get();  
            .admin()
     * number of shards equivalent to the cluster.max_shards_per_node and the cluster.ignore_Dot_indexes  
                )
        setMaxShardLimit(counts.getShardsPerNode(), getShardsPerNodeKey());  
            "test",
                .put(SETTING_NUMBER_OF_REPLICAS, 0)
            } else {
        } catch (IllegalArgumentException ex) {  
 */  
import java.io.IOException;
                .put(SETTING_NUMBER_OF_SHARDS, counts.getFirstIndexShards())
            fail("shouldn't be able to increase the number of replicas");
 * this work for additional information regarding copyright
        // Setting the cluster.max_shards_per_node setting according to the data node count.
import org.opensearch.transport.nio.MockNioTransportPlugin;
 * not use this file except in compliance with the License.
            Settings.builder()
    }
            internalCluster().startWarmOnlyNodes(nodeCount, nodeSettings);  
        setMaxShardLimit(shardsPerNode, getShardsPerNodeKey());
        setMaxShardLimit(shardsPerNode, getShardsPerNodeKey());
                + "] maximum "  
    }
            ).get();
        } catch (IllegalArgumentException e) {  
                .put(SETTING_NUMBER_OF_REPLICAS, counts.getFailingIndexReplicas())  
        assertEquals(secondIndexReplicas, clusterState.index("test-2-index").getNumberOfReplicas());  
        );  
            );
            prepareCreate("test_index_with_cluster_shard_limit").setSettings(
     * indexes starting with dot would succeed.
        int totalShards = counts.getFailingIndexShards() * (1 + counts.getFailingIndexReplicas());  
            0,
                    .setTransientSettings(Settings.builder().put(key, limit).build())
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
                    .get();
            + maxShards
                .indices()
        int shardsPerNode = firstIndexFactor + (secondIndexFactor * (1 + secondIndexReplicas));
                .put(indexSettings())  
/*
        SnapshotInfo snapshotInfo = snapshotInfos.get(0);
            .get();  
        } else {
                + getShardType()  
                .preparePutTemplate("should-fail")  
        assertEquals(0, clusterState.getMetadata().index("test-index").getNumberOfReplicas());
import org.opensearch.transport.client.Client;  
            + " shards, but this cluster currently has ["
     * setting is set to false. If the cluster.ignore_Dot_indexes is set to false index creation of
                .setWaitForCompletion(true)
                Settings.builder().put(SETTING_NUMBER_OF_SHARDS, indexPrimaryShards).put(SETTING_NUMBER_OF_REPLICAS, indexReplicaShards)
            .setSettings(
                Settings.builder()  
        // Getting total active shards in the cluster.  
            ClusterUpdateSettingsResponse response;
                    .put(indexSettings())  
import org.opensearch.test.InternalTestCluster;
import org.opensearch.common.settings.Settings;  
        String expectedError = "Validation Failed: 1: this action would add ["  
            assertThat(
        // Create two indexes: One that ends up with fewer shards, and one
        startTestNodes(3);
        // Fill up the cluster
            IllegalArgumentException.class,
        setMaxShardLimit(counts.getShardsPerNode(), getShardsPerNodeKey());
            fail("Should not have been able to restore snapshot in full cluster");
        ClusterState clusterState = client.admin().cluster().prepareState().get().getState();
                .put(SETTING_NUMBER_OF_REPLICAS, counts.getFirstIndexReplicas())
            + getShardType()  
        String expectedError = "Validation Failed: 1: this action would add ["  
                    .cluster()
        dataNodes = ensureMultipleDataNodes(dataNodes);  
                .build()
import org.opensearch.index.IndexModule;
        super(nodeSettings);
            int difference = totalShardsAfter - totalShardsBefore;
        assertFalse(clusterState.getMetadata().hasIndex("should-fail"));
                + " shards open;";
        } finally {
            "test-fill",
        /*
 * under the License.  
                .put(SETTING_NUMBER_OF_REPLICAS, counts.getFirstIndexReplicas())
            Settings.builder()
        ClusterHealthResponse healthResponse = client.admin()
        try {
     */
                        .put(SETTING_NUMBER_OF_REPLICAS, counts.getFailingIndexReplicas())
                + "] maximum "
        String maxShardsPerNode = clusterState.getMetadata().settings().get(getShardsPerNodeKey());
        );  
        // As active ClusterManagerNode setting takes precedence killing the active one.  
            .put(super.nodeSettings(nodeOrdinal))  
        Metadata clusterState = client().admin().cluster().prepareState().get().getState().metadata();
                    .cluster()  
            );  
        createRepository("test-repo", "fs", repoSettings);
    }  
                .setPatterns(Collections.singletonList("should-fail"))
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        assertThat(snapshotInfo.version(), equalTo(Version.CURRENT));  
            int totalShardsAfter = (dataNodes) * (firstIndexShards + secondIndexShards);  
            int totalShardsBefore = (firstIndexShards * (1 + firstIndexReplicas)) + (secondIndexShards * (1 + secondIndexReplicas));
            fail(ex.getMessage());
        // Starting 3 ClusterManagerOnlyNode nodes  
        logger.info("--> delete indices");  
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;  
            verifyException(dataNodes, counts, e);
            .prepareUpdateSettings()
        // Getting total active shards in the cluster.  
                .setPreserveExisting(true)
        int dataNodes = startTestNodes(3);
import java.util.function.Function;
            prepareCreate(
        int extraShardCount = 1;  
        int maxAllowedShardsPerCluster = maxAllowedShardsPerNode * 1000;
                .setSettings(Settings.builder().put("number_of_replicas", dataNodes))  
        assertFalse(healthResponse.isTimedOut());
        createIndex(  
                    .put(SETTING_NUMBER_OF_SHARDS, extraShardCount)
            return client().admin().cluster().prepareState().get().getState().getNodes().getWarmNodes().size();
                .setSettings(Settings.builder().put("number_of_replicas", dataNodes - 1))
            "snapshot-index",
            setMaxShardLimit(-1, SETTING_MAX_SHARDS_PER_CLUSTER_KEY);
                MockHttpTransport.TestPlugin.class,
    }
    private String getShardsPerNodeKey() {
        );
    private void verifyException(int maxShards, int currentShards, int extraShards, IllegalArgumentException e) {
        cluster.startClusterManagerOnlyNode(Settings.builder().put("cluster.ignore_dot_indexes", false).build());
        // Getting cluster.max_shards_per_node setting  
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();  
                    .get();  
        assertAcked(  
        }
                .admin()
     */
    }
                response = client().admin()
                .put(indexSettings())  
import org.opensearch.test.MockHttpTransport;
        int dataNodes = startTestNodes(3);
import org.opensearch.snapshots.mockstore.MockRepository;
import org.opensearch.core.common.unit.ByteSizeUnit;  
                .put(indexSettings())
                .put(indexSettings())  
                .indices()  
            "test-index-1",
        cluster.client()  
                + getShardType()  
        clusterState = client().admin().cluster().prepareState().get().getState();
    public Settings indexSettings() {  
                MockTransportService.TestPlugin.class,  
        int currentActiveShards = client().admin().cluster().prepareHealth().get().getActiveShards();
    }
        logger.info("--> restore one index after deletion");
        );
        cluster.startDataOnlyNode(Settings.builder().put("cluster.ignore_dot_indexes", false).build());
        int dataNodes = startTestNodes(3);
        ClusterState clusterState = client.admin().cluster().prepareState().get().getState();
        int dataNodes = startTestNodes(3);  
    }
        String maxShardsPerNode = clusterState.getMetadata().settings().get(getShardsPerNodeKey());
                    .prepareHealth()
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
    }  
import org.opensearch.node.Node;
            + " shards open;";
        assertEquals(firstIndexReplicas, clusterState.index("test-1-index").getNumberOfReplicas());
                .put(SETTING_NUMBER_OF_REPLICAS, secondIndexReplicas)  
                }
    public void testIndexCreationOverLimit() {
                InternalSettingsPlugin.class,
import java.util.Collection;
        IOUtils.close(cluster);
        try {
                "should-fail",
import java.util.Arrays;  
        createIndex(
            .prepareGetSnapshots("test-repo")
        setMaxShardLimit(shardsPerNode, getShardsPerNodeKey());
        clusterState = client().admin().cluster().prepareState().get().getState();  
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())  
     * indexes starting with dot would only succeed and dataStream indexes would still have validation applied.
                .setSettings(Settings.builder().put("number_of_replicas", dataNodes))  
        int extraShardCount = 1;
        return Settings.builder()
        int dataNodes = startTestNodes(3);  
                + "]/["
            .setPersistentSettings(Settings.builder().put(getShardsPerNodeKey(), maxAllowedShardsPerNode))
            .get();
     * Helper method to start nodes that support both data and warm roles  
        } catch (final IllegalArgumentException ex) {
            + extraShards
     * The test checks if the index starting with the dot should not be created if the node has
                        .put(ClusterShardLimitIT.this.nodeSettings(nodeOrdinal))  
            } else {
    public void testIndexCreationOverLimitFromTemplate() {  
        assertEquals(dataNodes * Integer.parseInt(maxShardsPerNode), currentActiveShards);
            + getShardType()  
            Function.identity()
        } catch (IllegalArgumentException ex) {  
                        .put(indexSettings())
                )  
        Settings.Builder repoSettings = Settings.builder();  
                public Path nodeConfigPath(int nodeOrdinal) {  
            Settings.builder()
import static org.hamcrest.Matchers.greaterThan;  
                + "]/["  
            Settings.builder().put(indexSettings()).put(SETTING_NUMBER_OF_SHARDS, firstShardCount).put(SETTING_NUMBER_OF_REPLICAS, 0)
            "test",
import org.opensearch.snapshots.SnapshotState;
            createIndex(  
        // Always keep
     * The test checks if the index starting with the .ds- can be created if the node has
    @After  
     * @param key node level or cluster level setting key.
                client().admin()
import org.opensearch.cluster.ClusterState;  
    public void testIgnoreDotSettingOnMultipleNodes() throws IOException, InterruptedException {
            verifyException(maxAllowedShardsPerNode * dataNodeCount, currentActiveShards, extraShardCount, e);
        assertEquals(dataNodes * Integer.parseInt(maxShardsPerNode), currentActiveShards);
        int secondIndexFactor = between(1, 3);
    }
                    .get();
    private RoutingPool getShardType() {
                    .prepareUpdateSettings()
                .get()  
                    .put(SETTING_NUMBER_OF_REPLICAS, counts.getFirstIndexReplicas())
        if (absolutePath == null) {
        setMaxShardLimit(dataNodes, getShardsPerNodeKey());  
            dataNodes * dataNodes so that cluster.max_shards_per_node setting is reached.
            + "]/["  
    /**  
                .indices()
    private void verifyException(int dataNodes, ShardCounts counts, IllegalArgumentException e) {
import static org.opensearch.common.util.FeatureFlags.WRITABLE_WARM_INDEX_SETTING;
        try {  
            Arrays.asList(  
        int maxAllowedShards = dataNodes * dataNodes;  
                    .prepareUpdateSettings()
        if (isWarmIndex) {
        Path tempDir = absolutePath.getParent().getParent();
            .setSnapshots("test-snap")  
    }  
            dataNodes * dataNodes so that cluster.max_shards_per_node setting is reached.
            Settings.builder()
        int dataNodes = startTestNodes(3);
            internalCluster().startDataOnlyNodes(nodeCount);  
        CreateSnapshotResponse createSnapshotResponse = client.admin()  
        try {  
                .put(indexSettings())  
    }  
    public void testOpenIndexOverLimit() {
                .put(indexSettings())
        } else {
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), false).build() },
            fail(ex.getMessage());
                    .put(SETTING_NUMBER_OF_SHARDS, counts.getFailingIndexShards())
            );
        assertThat(snapshotInfos.size(), equalTo(1));  
import org.opensearch.snapshots.SnapshotInfo;  
    }  
                response = client().admin()
    /**
        return featureSettings.build();  
    public void testPreserveExistingSkipsCheck() {  
                Settings.builder()
        assertFalse(clusterState.getMetadata().hasIndex("snapshot-index"));
            + "] total "
        try {  
    }
        int negativeShardsPerNode = between(-50_000, 0);
            )  
            }
        // Since a request with preserve_existing can't change the number of
                    .prepareUpdateSettings()
            tempDir,
        int shardsPerNode = between(1, 500_000);  
        setMaxShardLimit(maxAllowedShardsPerNode, getShardsPerNodeKey());
        ).get();  
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;  
                + "] total "  
        // Getting cluster.max_shards_per_node setting  
    }  
        repoSettings.put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES);  
import org.opensearch.common.network.NetworkModule;
                + dataNodes * shardsPerNode
            .execute()
            assertEquals(expectedError, e.getMessage());
 * license agreements. See the NOTICE file distributed with
            .setIndices("snapshot-index")
         */
                assertEquals(limit, response.getPersistentSettings().getAsInt(key, -1).intValue());  
            verifyException(maxAllowedShards, currentActiveShards, extraShardCount, e);  
            Settings.builder()
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
        try {
 * software distributed under the License is distributed on an
        }
    private static final String ignoreDotIndexKey = ShardLimitValidator.SETTING_CLUSTER_IGNORE_DOT_INDEXES.getKey();  
                .put(SETTING_NUMBER_OF_SHARDS, counts.getFailingIndexShards())
        // Setting max shards per node to be 10  
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(IndexMetadata.State.CLOSE, clusterState.getMetadata().index("test-index-1").getState());
            ClusterUpdateSettingsResponse response;
            client.admin().indices().prepareOpen("test-index-1").execute().actionGet();
            },  
            .prepareCreate(".test-index")  
                .prepareCreate(".test-index1")  
            internalCluster().startNode(dataNode());  
    public static Collection<Object[]> parameters() {
    }  
                equalTo(false)
            "test",
            + "] total "
            () -> client().admin().indices().prepareCreate("should-fail").get()
            if (frequently()) {  
        assertThat(
            String expectedError = "Validation Failed: 1: this action would add ["  
                    Settings.builder()
                ".test-index",
        clusterState = client().admin().cluster().prepareState().get().getState();
                .build()  
                    .build()
                + getShardType()
        setIgnoreDotIndex(true);  
                .execute()  
    public void testRestoreSnapshotOverLimit() {
            fail("should not have been able to open index");  
        createIndex(
 *
                    .build()  
                MockRepository.Plugin.class  
                    Settings.builder().put(SETTING_NUMBER_OF_SHARDS, indexPrimaryShards).put(SETTING_NUMBER_OF_REPLICAS, indexReplicaShards)
        );
    protected boolean addMockIndexStorePlugin() {
        // Getting cluster.max_shards_per_node setting  
        try {  
                + "] total "
                .prepareUpdateSettings("test-index")
     * The test checks if the index starting with the dot can be created if the node has
            verifyException(maxAllowedShards, currentActiveShards, extraShardCount, e);  
        ensureGreen();  
    public void teardown() throws Exception {
    @Override  
                    .setWaitForEvents(Priority.LANGUID)
            .get();
        );
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), true).build() }
        createIndex(
                .cluster()
            + getShardType()  
                .build()  
                .put(SETTING_NUMBER_OF_SHARDS, counts.getFailingIndexShards())
        assertEquals(dataNodes * Integer.parseInt(maxShardsPerNode), currentActiveShards);
import java.util.Collections;
        cluster.startDataOnlyNode(Settings.builder().put("cluster.ignore_dot_indexes", false).build());  
        return WRITABLE_WARM_INDEX_SETTING.get(settings) == false;
    /**
            ClusterHealthResponse clusterHealth = cluster.client().admin().cluster().prepareHealth().get();  
                    .actionGet()  
    public void testCreateIndexWithMaxClusterShardSetting() {  
        cluster.stopCurrentClusterManagerNode();
        int maxAllowedShardsPerNode = startTestNodes(3);
        final IllegalArgumentException e = expectThrows(  
    }
                .prepareRestoreSnapshot("test-repo", "test-snap")  
                .setSettings(
        assertEquals(expectedError, e.getMessage());
                    .cluster()  
                    .execute()
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));  
            .put(super.nodeSettings(0))  
        try {
 * Unless required by applicable law or agreed to in writing,
            Create an index that will bring us up to the limit. It would create index with primary equal to the  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        int firstShardCount = between(2, 10);
     * number of shards equivalent to the cluster.max_shards_per_node and the cluster.ignore_Dot_indexes
        setIgnoreDotIndex(ignoreDotIndexes);  
     */  
        return Settings.builder()
 */
                .put(SETTING_NUMBER_OF_REPLICAS, counts.getFirstIndexReplicas())  
            fail("should not have been able to increase shards above limit");  
        return Arrays.asList(  
import java.nio.file.Path;
        );
            );
            .get()
        int shardsPerNode = firstShardCount - 1;  
        // Setting the cluster.max_shards_per_node setting according to the data node count.
        logger.info("--> snapshot");
        // Reduce the shard limit and fill it up  
            true,
        int dataNodes = startTestNodes(3);
        Boolean isWarmEnabled = WRITABLE_WARM_INDEX_SETTING.get(settings);
        final ShardCounts counts = ShardCounts.forDataNodeCount(dataNodes);  
            true,  
        createIndex(
            + totalShards
                public Settings nodeSettings(int nodeOrdinal) {
        int extraShardCount = 1;
            "test-1-index",  
        } catch (IllegalArgumentException e) {
            .indices()
        }
            + " shards open;";
    public void testIndexCreationOverLimitForDataStreamIndexes() {  
import org.opensearch.test.transport.MockTransportService;
 * You may obtain a copy of the License at  
    protected static final String REPOSITORY_NAME = "test-remote-store-repo";  
        }
                    .cluster()  
                    .setWaitForNodes(">=2")  
                + difference
import org.opensearch.indices.ShardLimitValidator;
        assertAcked(client.admin().indices().prepareClose("test-index-1"));  
 * KIND, either express or implied.  See the License for the
                "Failed to parse value [" + negativeShardsPerNode + "] for setting [" + getShardsPerNodeKey() + "] must be >= 1",
            assertEquals(expectedError, e.getMessage());  
            "test-index",
        );  
                + " shards, but this cluster currently has ["
        int dataNodes = startTestNodes(3);
                        .put(SETTING_NUMBER_OF_SHARDS, counts.getFailingIndexShards())  
                "test",  
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();  
        /*
                .setOrder(1)
        }
import static org.opensearch.indices.ShardLimitValidator.SETTING_CLUSTER_MAX_SHARDS_PER_NODE;
                    .cluster()  
        repoSettings.put("location", randomRepoPath());
        cluster.client().admin().cluster().prepareHealth().setWaitForGreenStatus().get();
                Settings.builder()
import org.opensearch.Version;
    }
        int maxAllowedShardsPerNode = 10, indexPrimaryShards = 11, indexReplicaShards = 1;  
    }
        int currentShards = counts.getFirstIndexShards() * (1 + counts.getFirstIndexReplicas());
            cluster.client()  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testIncreaseReplicasOverLimit() {  
        );
         */
            .cluster()
        // that ends up with more to verify that we check the _total_ number of  
        setMaxShardLimit(counts.getShardsPerNode(), getShardsPerNodeKey());
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
    }
                + " shards, but this cluster currently has ["
        int firstIndexReplicas = 0;
        logger.info("-->  creating repository");
        }
        int dataNodes = startTestNodes(3);
            client().admin()  
                ".ds-test-index",
            + getShardType()  
        }
                + totalShardsBefore
    }  
 */  
            client().admin()
            "test",
    private Settings warmNodeSettings(ByteSizeValue cacheSize) {
import org.opensearch.common.util.FeatureFlags;
        List<SnapshotInfo> snapshotInfos = client.admin()  
        }
                @Override  
                    .put(SETTING_NUMBER_OF_REPLICAS, counts.getFailingIndexReplicas())  
        createIndex(
            setMaxShardLimit(maxAllowedShardsPerCluster, SETTING_MAX_SHARDS_PER_CLUSTER_KEY);
        }  
                MockNioTransportPlugin.class,
                .get();
                .actionGet();
            .setWaitForCompletion(true)  
    }
            return SETTING_CLUSTER_MAX_SHARDS_PER_NODE.getKey();
        } catch (IllegalArgumentException e) {  
    }
            fail("should not be able to set negative shards per node");
            Settings.builder()  
    @Override
            + "] maximum "
     * setting is set to true. If the cluster.ignore_Dot_indexes is set to true index creation of
        } catch (IllegalArgumentException e) {  
                .put(SETTING_NUMBER_OF_REPLICAS, counts.getFailingIndexReplicas())  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        setMaxShardLimit(dataNodes, getShardsPerNodeKey());
            .cluster()
                .build()
            RestoreSnapshotResponse restoreSnapshotResponse = client.admin()
                .build()
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        // Creating an index starting with dot having shards greater thn the desired node limit
        }  
    public void testSettingClusterMaxShards() {
     * number of shards equivalent to the cluster.max_shards_per_node and the cluster.ignore_Dot_indexes  
        setMaxShardLimit(dataNodes, getShardsPerNodeKey());
                Settings.builder()
        createIndex(  
        if (dataNodes == 1) {
        try {
 * Modifications Copyright OpenSearch Contributors. See
import org.junit.After;
                .put(SETTING_NUMBER_OF_REPLICAS, 0)
            return SETTING_CLUSTER_MAX_REMOTE_CAPABLE_SHARDS_PER_NODE.getKey();
            + currentShards
        );  
                    .prepareUpdateSettings()  
    private static final long TOTAL_SPACE_BYTES = new ByteSizeValue(100, ByteSizeUnit.KB).getBytes();
        cluster.startClusterManagerOnlyNode(Settings.builder().put("cluster.ignore_dot_indexes", false).build());  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        prepareCreate(  
            "cluster-",
    }
                client().admin()
        setMaxShardLimit(counts.getShardsPerNode(), getShardsPerNodeKey());
            .cluster()  
            + "] maximum "
            .actionGet();  
        assertTrue(clusterState.getMetadata().hasIndex(".test-index"));
        assertFalse(clusterState.getMetadata().hasIndex(".test-index"));  
            Settings.builder().put(indexSettings()).put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0).build()  
        // Checking if the total shards created are equivalent to dataNodes * cluster.max_shards_per_node
            }
                @Override
            0,  
                .build()
            if (frequently()) {
                .put(SETTING_NUMBER_OF_SHARDS, firstIndexShards)  
                + " shards open;";
                    .put(SETTING_NUMBER_OF_SHARDS, counts.getFirstIndexShards())  
 *
            .build();
                TestSeedPlugin.class,
        );
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
            verifyException(dataNodes, counts, e);
            int dataNodeCount = clusterHealth.getNumberOfDataNodes();
                    .cluster()  
     * @param limit the limit value to set.  
                .put(SETTING_NUMBER_OF_SHARDS, maxAllowedShards)
    }
     */  
                .prepareUpdateSettings(randomFrom("_all", "test-*", "*-index"))  
                    .setPersistentSettings(Settings.builder().put(key, limit).build())
                .get()
                    .put(indexSettings())
 * this file be licensed under the Apache-2.0 license or a
                + dataNodes * shardsPerNode
                .build()  
        }  
        int secondIndexShards = secondIndexFactor * dataNodes;
import org.opensearch.test.NodeConfigurationSource;  
    public void testSettingIgnoreDotIndexes() {
        setMaxShardLimit(shardsPerNode, getShardsPerNodeKey());  
        // Getting total active shards in the cluster.  
            int currentActiveShards = clusterHealth.getActiveShards();
            "test-2-index",
        int currentActiveShards = client().admin().cluster().prepareHealth().get().getActiveShards();
        boolean isWarmIndex = WRITABLE_WARM_INDEX_SETTING.get(settings);  
        Client client = client();  
}
import static org.opensearch.test.NodeRoles.dataNode;  
        cluster.startClusterManagerOnlyNode(Settings.builder().put("cluster.ignore_dot_indexes", true).build());
            ),
        prepareCreate(  
        Settings.Builder featureSettings = Settings.builder();
        int secondIndexReplicas = dataNodes;  
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.common.Priority;
            dataNodes * dataNodes so that cluster.max_shards_per_node setting is reached.
        }  
                    .isTimedOut(),
    public void testMinimumPerNode() {  
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
                .put(SETTING_NUMBER_OF_REPLICAS, firstIndexReplicas)
            return client().admin().cluster().prepareState().get().getState().getNodes().getDataNodes().size();
        createIndex(
    }  
import static org.opensearch.indices.ShardLimitValidator.SETTING_MAX_SHARDS_PER_CLUSTER_KEY;
                client().admin()
    public void testIndexCreationOverLimitForDotIndexesSucceeds() {
    }  
    @ParametersFactory
            client().admin()
            assertEquals(
 * The OpenSearch Contributors require contributions made to  
                    .put(indexSettings())  
            dataNodes = client().admin().cluster().prepareState().get().getState().getNodes().getDataNodes().size();
        /*
            Settings.builder()  
            int extraShardCount = indexPrimaryShards * (1 + indexReplicaShards);  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                    .setLocal(true)
            ).get();
        ShardCounts counts = ShardCounts.forDataNodeCount(dataNodes);
            Create an index that will bring us up to the limit. It would create index with primary equal to the  
        }
         */
        } catch (IllegalArgumentException e) {
                ex.getMessage()  
import org.opensearch.cluster.metadata.IndexMetadata;
            client().admin()
        int dataNodes = startTestNodes(3);
        );
            + currentShards
        if (isWarmEnabled) {
            .put(remoteStoreClusterSettings(REPOSITORY_NAME, absolutePath))
    /**  
        dataNodes = ensureMultipleDataNodes(dataNodes);  
            return Settings.builder().put(super.indexSettings()).put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true).build();  
            Create an index that will bring us up to the limit. It would create index with primary equal to the  
                    return null;
        } else {  
        boolean ignoreDotIndexes = randomBoolean();
    private void setIgnoreDotIndex(boolean ignoreDotIndex) {  
/*  
        // shards the operation would add.
        InternalTestCluster cluster = new InternalTestCluster(  
        }
                    .setPersistentSettings(Settings.builder().put(ignoreDotIndexKey, ignoreDotIndex).build())
                    .setPersistentSettings(Settings.builder().put(getShardsPerNodeKey(), negativeShardsPerNode).build())
import org.opensearch.test.InternalSettingsPlugin;  
        ).get();  
                assertEquals(ignoreDotIndex, response.getTransientSettings().getAsBoolean(ignoreDotIndexKey, true));
                    .put(indexSettings())
        cluster().wipeIndices("snapshot-index");
            Settings.builder()  
        } catch (IllegalArgumentException e) {
        );
 * GitHub history for details.
                .put(SETTING_NUMBER_OF_SHARDS, dataNodes * dataNodes)
        Boolean isWarmIndex = WRITABLE_WARM_INDEX_SETTING.get(settings);  
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)  
        ensureGreen();  
        cluster.client()
import org.opensearch.cluster.routing.RoutingPool;  
            + "]/["  
        int currentActiveShards = client().admin().cluster().prepareHealth().get().getActiveShards();
        assertFalse(clusterState.getMetadata().hasIndex(".ds-test-index"));  
        // Waiting for all shards to get assigned
                .put(SETTING_NUMBER_OF_SHARDS, maxAllowedShards)
                    .setTransientSettings(Settings.builder().put(ignoreDotIndexKey, ignoreDotIndex).build())
                .indices()
        assertAcked(
        // Setting the cluster.max_shards_per_node setting according to the data node count.
                        .put(NetworkModule.TRANSPORT_TYPE_KEY, getTestTransportType())
                    .get();  
                .build()
        featureSettings.put(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG, true);
                .build()
                    .get();  
            return super.indexSettings();
                .build()  
            .prepareHealth("test-index-1")  
            + maxShards
                    .setTransientSettings(Settings.builder().put(getShardsPerNodeKey(), negativeShardsPerNode).build())
    protected Settings featureFlagSettings() {  
                    .prepareUpdateSettings()  
        // This would be the first one where cluster.ignore_dot_indexes is true because the above calls are blocking.
 * Licensed to Elasticsearch under one or more contributor  
                + getShardType()
                .get();
    public void testChangingMultipleIndicesOverLimit() {  
                .setIndices("snapshot-index")
            fail("Should not have been able to go over the limit");
    private int ensureMultipleDataNodes(int dataNodes) {
                .put(indexSettings())
                + firstShardCount  
            if (frequently()) {  
     * indexes starting with dot would fail as well.
                .put(SETTING_NUMBER_OF_SHARDS, counts.getFirstIndexShards())  
/*  
                .put(SETTING_NUMBER_OF_SHARDS, secondIndexShards)
        // Checking if the total shards created are equivalent to dataNodes * cluster.max_shards_per_node
            verifyException(dataNodes, counts, e);
        // Getting total active shards in the cluster.
    private int startTestNodes(int nodeCount) {
                .setSettings(  
@ParameterizedStaticSettingsOpenSearchIntegTestCase.ClusterScope(scope = ParameterizedStaticSettingsOpenSearchIntegTestCase.Scope.TEST)
                    .put(SETTING_NUMBER_OF_REPLICAS, 0)
    }
