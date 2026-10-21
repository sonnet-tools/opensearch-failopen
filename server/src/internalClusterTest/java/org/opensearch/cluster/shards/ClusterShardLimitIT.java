import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        // Setting the cluster.max_shards_per_node setting according to the data node count.
        setMaxShardLimit(counts.getShardsPerNode(), getShardsPerNodeKey());
        assertEquals(IndexMetadata.State.CLOSE, clusterState.getMetadata().index("test-index-1").getState());
            return Settings.builder().put(super.indexSettings()).put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true).build();
                Settings.builder()
        int currentActiveShards = client().admin().cluster().prepareHealth().get().getActiveShards();
        final IllegalArgumentException e = expectThrows(
            Settings.builder().put(indexSettings()).put(SETTING_NUMBER_OF_SHARDS, firstShardCount).put(SETTING_NUMBER_OF_REPLICAS, 0)
                .put(indexSettings())
        // Setting the cluster.max_shards_per_node setting according to the data node count.
        if (dataNodes == 1) {
            } else {
        int dataNodes = startTestNodes(3);
            return client().admin().cluster().prepareState().get().getState().getNodes().getWarmNodes().size();
    }
        String maxShardsPerNode = clusterState.getMetadata().settings().get(getShardsPerNodeKey());
        assertEquals(dataNodes * Integer.parseInt(maxShardsPerNode), currentActiveShards);
            "test",
                public Path nodeConfigPath(int nodeOrdinal) {
 * specific language governing permissions and limitations
    /**
        ClusterState clusterState = client.admin().cluster().prepareState().get().getState();
                + getShardType()
                .prepareRestoreSnapshot("test-repo", "test-snap")
                .build()
/*
            + "] maximum "
                MockRepository.Plugin.class
        Boolean isWarmEnabled = WRITABLE_WARM_INDEX_SETTING.get(settings);
            String expectedError = "Validation Failed: 1: this action would add ["
        );
                .preparePutTemplate("should-fail")
    protected Settings featureFlagSettings() {
                .indices()
        clusterState = client().admin().cluster().prepareState().get().getState();
            ClusterUpdateSettingsResponse response;
        int negativeShardsPerNode = between(-50_000, 0);
     */
                .prepareUpdateSettings("test-index")
    /**
            Settings.builder().put(indexSettings()).put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0).build()
            + " shards open;";
                    return Settings.builder()
                    .put(SETTING_NUMBER_OF_REPLICAS, counts.getFailingIndexReplicas())
    public void testIgnoreDotSettingOnMultipleNodes() throws IOException, InterruptedException {
        }
                    .put(indexSettings())
            .prepareHealth("test-index-1")
        assertEquals(0, clusterState.getMetadata().index("test-index").getNumberOfReplicas());
 */
    /**
            )
        String maxShardsPerNode = clusterState.getMetadata().settings().get(getShardsPerNodeKey());
        } catch (IllegalArgumentException e) {
                    Settings.builder()
         */
        createIndex(
    private static final String ignoreDotIndexKey = ShardLimitValidator.SETTING_CLUSTER_IGNORE_DOT_INDEXES.getKey();
                .put(indexSettings())
 * GitHub history for details.
    }
        final ShardCounts counts = ShardCounts.forDataNodeCount(dataNodes);
            + "]/["
        cluster.startClusterManagerOnlyNode(Settings.builder().put("cluster.ignore_dot_indexes", false).build());
        } catch (IllegalArgumentException e) {
            client.admin().indices().prepareOpen("test-index-1").execute().actionGet();
            .setSettings(
        } catch (IllegalArgumentException ex) {
        try {
    public static Collection<Object[]> parameters() {
        createIndex(
                .execute()
                    .put(SETTING_NUMBER_OF_SHARDS, counts.getFirstIndexShards())
            );
                + "] total "
        );
        repoSettings.put("compress", randomBoolean());
        createIndex(
            return SETTING_CLUSTER_MAX_REMOTE_CAPABLE_SHARDS_PER_NODE.getKey();
    }
        try {
        int shardsPerNode = firstShardCount - 1;
                    .put(SETTING_NUMBER_OF_REPLICAS, counts.getFirstIndexReplicas())
                    .prepareUpdateSettings()
        setMaxShardLimit(dataNodes, getShardsPerNodeKey());
                    .get();
    @Override
                        .put(SETTING_NUMBER_OF_REPLICAS, counts.getFailingIndexReplicas())
                    .cluster()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    .prepareUpdateSettings()
 */
import org.opensearch.test.InternalTestCluster;
        );
                Settings.builder()
                .prepareCreate(".test-index1")
            .prepareGetSnapshots("test-repo")
        logger.info("--> restore one index after deletion");
                    return null;
    }
            "test",
                .setSettings(
                .put(indexSettings())
            }
import java.util.Collection;
        try {
    }
    }
    }
                .put(SETTING_NUMBER_OF_REPLICAS, counts.getFirstIndexReplicas())
@ParameterizedStaticSettingsOpenSearchIntegTestCase.ClusterScope(scope = ParameterizedStaticSettingsOpenSearchIntegTestCase.Scope.TEST)
        startTestNodes(3);
                + firstShardCount
}
            + maxShards
        assertFalse(clusterState.getMetadata().hasIndex("should-fail"));
                    .cluster()
        int firstIndexFactor = between(5, 10);
            .cluster()
            internalCluster().startDataOnlyNodes(nodeCount);
                    .setLocal(true)
                    .cluster()
        repoSettings.put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES);
        assertEquals(secondIndexReplicas, clusterState.index("test-2-index").getNumberOfReplicas());
        }
                + getShardType()
        Metadata clusterState = client().admin().cluster().prepareState().get().getState().metadata();
        if (isWarmIndex) {
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
     * setting is set to true. If the cluster.ignore_Dot_indexes is set to true index creation of
                assertEquals(limit, response.getTransientSettings().getAsInt(key, -1).intValue());
            ).get();
            return super.indexSettings();
            fail("shouldn't be able to increase the number of replicas");
                ".test-index",
import static org.opensearch.test.NodeRoles.dataNode;
import org.opensearch.snapshots.mockstore.MockRepository;
                response = client().admin()
        // Test restore after index deletion
                .get();
            .cluster()
import org.opensearch.cluster.metadata.IndexMetadata;
        assertEquals(dataNodes * Integer.parseInt(maxShardsPerNode), currentActiveShards);
        // Setting max shards per node to be 10
            },
     */
            .setSnapshots("test-snap")
    }
/*
            setMaxShardLimit(-1, SETTING_MAX_SHARDS_PER_CLUSTER_KEY);
            tempDir,
        assertFalse(clusterState.getMetadata().hasIndex(".ds-test-index"));
        }
            + " shards, but this cluster currently has ["
        try {
    public void testOpenIndexOverLimit() {
        setMaxShardLimit(maxAllowedShardsPerNode, getShardsPerNodeKey());
import org.opensearch.transport.nio.MockNioTransportPlugin;
            if (frequently()) {
import org.opensearch.index.IndexModule;
        // Checking if the total shards created are equivalent to dataNodes * cluster.max_shards_per_node
                MockHttpTransport.TestPlugin.class,
        setMaxShardLimit(dataNodes, getShardsPerNodeKey());
            .get();
 *
                .build()
    public void testIndexCreationOverLimitForDotIndexesFail() {
    }
                    .setWaitForEvents(Priority.LANGUID)
     * setting is set to true. If the cluster.ignore_Dot_indexes is set to true index creation of
    private int ensureMultipleDataNodes(int dataNodes) {
        try {
                    .setPersistentSettings(Settings.builder().put(key, limit).build())
            .getSnapshots();
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
        Path tempDir = absolutePath.getParent().getParent();
    }
        setIgnoreDotIndex(ignoreDotIndexes);
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
        try {
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, extraShardCount).put(SETTING_NUMBER_OF_REPLICAS, 0).build()
        } else {
        try {
        assertEquals(expectedError, e.getMessage());
        assertThat(
 *
            .cluster()
            prepareCreate("test_index_with_cluster_shard_limit").setSettings(
        int secondIndexFactor = between(1, 3);
            "test-1-index",
        ShardCounts counts = ShardCounts.forDataNodeCount(dataNodes);
            internalCluster().startWarmOnlyNodes(nodeCount, nodeSettings);
                .build()
        assertEquals(0, clusterState.index("growing-should-fail").getNumberOfReplicas());
                    .build()
     * indexes starting with dot would only succeed and dataStream indexes would still have validation applied.
    public void testCreateIndexWithMaxClusterShardSetting() {
                    .cluster()
    public void testSettingClusterMaxShards() {
        // Fill up the cluster
        setIgnoreDotIndex(true);
    public void testIndexCreationOverLimit() {
                .setSettings(Settings.builder().put("number_of_replicas", dataNodes - 1))
                .put(SETTING_NUMBER_OF_SHARDS, firstIndexShards)
        } catch (IllegalArgumentException ex) {
        } catch (IllegalArgumentException e) {
        setMaxShardLimit(shardsPerNode, getShardsPerNodeKey());
                + " shards open;";
                    .setPersistentSettings(Settings.builder().put(getShardsPerNodeKey(), negativeShardsPerNode).build())
                assertEquals(limit, response.getPersistentSettings().getAsInt(key, -1).intValue());
import org.opensearch.test.NodeConfigurationSource;
                .put(SETTING_NUMBER_OF_REPLICAS, 0)
            .get()
        } catch (IllegalArgumentException e) {
            if (frequently()) {
                .put(indexSettings())
        return dataNodes;
        ClusterState clusterState = client.admin().cluster().prepareState().get().getState();
        createIndex(
        setMaxShardLimit(dataNodes, getShardsPerNodeKey());
                        .build();
                response = client().admin()
import org.opensearch.test.transport.MockTransportService;
            client().admin()
    public void testIndexCreationOverLimitForDotIndexesSucceeds() {
    public void testSettingIgnoreDotIndexes() {
            .put(super.nodeSettings(0))
            .admin()
        );
            .indices()
            verifyException(dataNodes, counts, e);
            ClusterUpdateSettingsResponse response;
        return Settings.builder()
            prepareCreate(
                .put(indexSettings())
            cluster.client()
                    .setPersistentSettings(Settings.builder().put(ignoreDotIndexKey, ignoreDotIndex).build())
    public void testPreserveExistingSkipsCheck() {
        int dataNodes = startTestNodes(3);
 * license agreements. See the NOTICE file distributed with
    private Settings warmNodeSettings(ByteSizeValue cacheSize) {
        /*
                + getShardType()
import org.opensearch.cluster.metadata.Metadata;
        }
 * software distributed under the License is distributed on an
import org.junit.After;
    @Override
                .put(indexSettings())
        Metadata clusterState = client().admin().cluster().prepareState().get().getState().metadata();
        SnapshotInfo snapshotInfo = snapshotInfos.get(0);
            + "] maximum "
            dataNodes * dataNodes so that cluster.max_shards_per_node setting is reached.
                    .build()
            Settings nodeSettings = Settings.builder().put(warmNodeSettings(new ByteSizeValue(TOTAL_SPACE_BYTES))).build();
        // shards the operation would add.
        );
        cluster().wipeIndices("snapshot-index");
                        .put(SETTING_NUMBER_OF_SHARDS, counts.getFailingIndexShards())
                )
                "test",
            Settings.builder()
        );
        Client client = client();
                    .cluster()
            "test-2-index",
        );
                    .put(indexSettings())
                .build()
        boolean ignoreDotIndexes = randomBoolean();
                MockNioTransportPlugin.class,
            verifyException(dataNodes, counts, e);
        cluster.startClusterManagerOnlyNode(Settings.builder().put("cluster.ignore_dot_indexes", false).build());
        createIndex(
        // Always keep
        } catch (final IllegalArgumentException ex) {
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
                .indices()
        return Arrays.asList(
        } finally {
                    .setTransientSettings(Settings.builder().put(getShardsPerNodeKey(), negativeShardsPerNode).build())
     * The test checks if the index starting with the .ds- can be created if the node has
    }
        assertFalse(healthResponse.isTimedOut());
        // As active ClusterManagerNode setting takes precedence killing the active one.
        int extraShardCount = 1;
            IllegalArgumentException.class,
        return Settings.builder()
    protected boolean addMockIndexStorePlugin() {
            .prepareCreateSnapshot("test-repo", "test-snap")
                @Override
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), false).build() },
    private static final long TOTAL_SPACE_BYTES = new ByteSizeValue(100, ByteSizeUnit.KB).getBytes();
            createIndex(
            createIndex(
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), true).build() }
            true,
            dataNodes * dataNodes so that cluster.max_shards_per_node setting is reached.
        ensureGreen();
            assertEquals(expectedError, e.getMessage());
            );
 * compatible open source license.
        boolean isWarmIndex = WRITABLE_WARM_INDEX_SETTING.get(settings);
            int totalShardsBefore = (firstIndexShards * (1 + firstIndexReplicas)) + (secondIndexShards * (1 + secondIndexReplicas));
        createIndex(
        int maxShards = counts.getShardsPerNode() * dataNodes;
 * this file be licensed under the Apache-2.0 license or a
                    .setWaitForNodes(">=2")
            "snapshot-index",
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
                .admin()
        // replicas, we should never get an error here.
    public void testRestoreSnapshotOverLimit() {
            Settings.builder()
 * ownership. Elasticsearch licenses this file to you under
         */
            absolutePath = randomRepoPath().toAbsolutePath();
     * The test checks if the index starting with the dot should not be created if the node has
/*
import org.opensearch.snapshots.SnapshotState;
     */
        ).get();
        if (isWarmIndex) {
        logger.info("--> delete indices");
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
                    .get();
                + " shards, but this cluster currently has ["
            .setPersistentSettings(Settings.builder().put(getShardsPerNodeKey(), maxAllowedShardsPerNode))
        ShardCounts counts = ShardCounts.forDataNodeCount(dataNodes);
    @Override
        int dataNodes = startTestNodes(3);
                + "] total "
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
import java.io.IOException;
    }
    private void setIgnoreDotIndex(boolean ignoreDotIndex) {
        // Create two indexes: One that ends up with fewer shards, and one
        assertFalse(clusterState.getMetadata().hasIndex("should-fail"));
        // Creating an index starting with dot having shards greater thn the desired node limit
    }
                assertEquals(ignoreDotIndex, response.getPersistentSettings().getAsBoolean(ignoreDotIndexKey, true));
        assertThat(snapshotInfo.version(), equalTo(Version.CURRENT));
        }
        cluster.client()
        int shardsPerNode = between(1, 500_000);
            randomLong(),
        Client client = client();
                    .prepareHealth()
    protected Path absolutePath;
        createRepository("test-repo", "fs", repoSettings);
            .setWaitForCompletion(true)
            + currentShards
            .build();
        int shardsPerNode = firstShardCount - 1;
        setMaxShardLimit(counts.getShardsPerNode(), getShardsPerNodeKey());
        assertEquals(expectedError, e.getMessage());
            + getShardType()
        setMaxShardLimit(shardsPerNode, getShardsPerNodeKey());
        int firstIndexReplicas = 0;
                    .prepareUpdateSettings()
        if (isWarmEnabled) {
        int maxAllowedShardsPerNode = startTestNodes(3);
        String expectedError = "Validation Failed: 1: this action would add ["
        } catch (IllegalArgumentException ex) {
                .indices()
    public void testIndexCreationOverLimitForDataStreamIndexes() {
            int currentActiveShards = clusterHealth.getActiveShards();
    }
        cluster.client().admin().cluster().prepareHealth().setWaitForGreenStatus().get();
            client().admin()
            createIndex(
            "test",
            + " shards open;";
                .put(SETTING_NUMBER_OF_REPLICAS, firstIndexReplicas)
        return featureSettings.build();
                .cluster()
            assertThat(
            verifyException(dataNodes, counts, e);
            verifyException(maxAllowedShardsPerCluster, currentActiveShards, extraShardCount, ex);
    @ParametersFactory
        // Getting total active shards in the cluster.
        );
            Settings.builder()
        );
        String expectedError = "Validation Failed: 1: this action would add ["
                .build()
                .setPatterns(Collections.singletonList("should-fail"))
                + totalShardsBefore
            Create an index that will bring us up to the limit. It would create index with primary equal to the
                    .cluster()
                .put(SETTING_NUMBER_OF_REPLICAS, secondIndexReplicas)
                response = client().admin()
                .put(SETTING_NUMBER_OF_SHARDS, secondIndexShards)
            .cluster()
                    .prepareUpdateSettings()
                .put(indexSettings())
 * not use this file except in compliance with the License.
            fail("should not have been able to open index");
                ".ds-test-index",
        int firstShardCount = between(2, 10);
        }
import org.opensearch.common.Priority;
            true,
        int totalShards = counts.getFailingIndexShards() * (1 + counts.getFailingIndexReplicas());
                + "] maximum "
                .setSettings(Settings.builder().put("number_of_replicas", dataNodes))
                Settings.builder().put(SETTING_NUMBER_OF_SHARDS, indexPrimaryShards).put(SETTING_NUMBER_OF_REPLICAS, indexReplicaShards)
        setMaxShardLimit(shardsPerNode, getShardsPerNodeKey());
                )
        // Since a request with preserve_existing can't change the number of
                .build()
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
            );
        int firstShardCount = between(2, 10);
 * Unless required by applicable law or agreed to in writing,
                .setOrder(1)
            dataNodes * dataNodes so that cluster.max_shards_per_node setting is reached.
    public void testMinimumPerNode() {
                .put(SETTING_NUMBER_OF_REPLICAS, counts.getFailingIndexReplicas())
        }
        repoSettings.put("location", randomRepoPath());
            Settings.builder()
            + getShardType()
                    .setTransientSettings(Settings.builder().put(ignoreDotIndexKey, ignoreDotIndex).build())
        clusterState = client().admin().cluster().prepareState().get().getState();
            }
    /**
        // Getting total active shards in the cluster.
         */
            verifyException(maxAllowedShards, currentActiveShards, extraShardCount, e);
        try {
     * number of shards equivalent to the cluster.max_shards_per_node and the cluster.ignore_Dot_indexes
            ).get();
        // Setting the cluster.max_shards_per_node setting according to the data node count.
import static org.opensearch.indices.ShardLimitValidator.SETTING_CLUSTER_MAX_REMOTE_CAPABLE_SHARDS_PER_NODE;
        int firstIndexShards = firstIndexFactor * dataNodes;
                    .get();
    }
import org.opensearch.test.MockHttpTransport;
        int extraShardCount = 1;
            return SETTING_CLUSTER_MAX_SHARDS_PER_NODE.getKey();
        try {
        createIndex(
import java.util.function.Function;
        CreateSnapshotResponse createSnapshotResponse = client.admin()
import static org.opensearch.indices.ShardLimitValidator.SETTING_CLUSTER_MAX_SHARDS_PER_NODE;
            client().admin()
     * Set max shard limit on either per node level or on cluster level.
        int dataNodes = startTestNodes(3);
                "Failed to parse value [" + negativeShardsPerNode + "] for setting [" + getShardsPerNodeKey() + "] must be >= 1",
 * this work for additional information regarding copyright
                equalTo(false)
        int maxAllowedShardsPerNode = 10, indexPrimaryShards = 11, indexReplicaShards = 1;
            + "]/["
                .put(indexSettings())
            String expectedError = "Validation Failed: 1: this action would add ["
        assertFalse(clusterState.getMetadata().hasIndex("snapshot-index"));
import static org.opensearch.indices.ShardLimitValidator.SETTING_MAX_SHARDS_PER_CLUSTER_KEY;
            + currentShards
                    .put(SETTING_NUMBER_OF_REPLICAS, 0)
            verifyException(maxAllowedShards, currentActiveShards, extraShardCount, e);
                @Override
    protected static final String REPOSITORY_NAME = "test-remote-store-repo";
        int secondIndexReplicas = dataNodes;
    }
 * Licensed to Elasticsearch under one or more contributor
                + dataNodes * shardsPerNode
                    .execute()
            "growing-should-fail",
        } catch (IllegalArgumentException e) {
            ".test-index",
        // Reduce the shard limit and fill it up
            + totalShards
            );
                    .prepareUpdateSettings()
            0,
                .setPreserveExisting(true)
                    .put(SETTING_NUMBER_OF_SHARDS, extraShardCount)
            .get();
            Settings.builder()
        assertEquals(firstIndexReplicas, clusterState.index("test-1-index").getNumberOfReplicas());
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
import org.opensearch.common.settings.Settings;
        }
                    Settings.builder().put(SETTING_NUMBER_OF_SHARDS, indexPrimaryShards).put(SETTING_NUMBER_OF_REPLICAS, indexReplicaShards)
    private String getShardsPerNodeKey() {
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
                    .put(SETTING_NUMBER_OF_REPLICAS, 0)
        } else {
                        .put(NetworkModule.TRANSPORT_TYPE_KEY, getTestTransportType())
            ),
                    .put(SETTING_NUMBER_OF_SHARDS, extraShardCount)
                .indices()
        // that ends up with more to verify that we check the _total_ number of
                "should-fail",
    public void testIncreaseReplicasOverLimit() {
            );
            dataNodes = client().admin().cluster().prepareState().get().getState().getNodes().getDataNodes().size();
    }
    private void setMaxShardLimit(int limit, String key) {
        cluster.startClusterManagerOnlyNode(Settings.builder().put("cluster.ignore_dot_indexes", true).build());
 * under the License.
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
 *
                .put(SETTING_NUMBER_OF_REPLICAS, counts.getFirstIndexReplicas())
import static org.opensearch.common.util.FeatureFlags.WRITABLE_WARM_INDEX_SETTING;
                .put(SETTING_NUMBER_OF_SHARDS, dataNodes * dataNodes)
        if (absolutePath == null) {
                    .get();
        int maxAllowedShards = dataNodes * dataNodes;
        assertFalse(clusterState.getMetadata().hasIndex(".test-index"));
        }
                .build()
    private void verifyException(int maxShards, int currentShards, int extraShards, IllegalArgumentException e) {
            return client().admin().cluster().prepareState().get().getState().getNodes().getDataNodes().size();
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
import org.opensearch.Version;
                .build()
     * Helper method to start nodes that support both data and warm roles
        setMaxShardLimit(counts.getShardsPerNode(), getShardsPerNodeKey());
                .setSettings(
        int dataNodes = startTestNodes(3);
 */
    }
        // Starting 2 data nodes
                ex.getMessage()
            fail("Should not have been able to go over the limit");
            fail("Should not have been able to restore snapshot in full cluster");
    }
 * The OpenSearch Contributors require contributions made to
        );
        dataNodes = ensureMultipleDataNodes(dataNodes);
     * number of shards equivalent to the cluster.max_shards_per_node and the cluster.ignore_Dot_indexes
 * KIND, either express or implied.  See the License for the
        cluster.startDataOnlyNode(Settings.builder().put("cluster.ignore_dot_indexes", false).build());
    public void teardown() throws Exception {
                .build()
        );
                + " shards, but this cluster currently has ["
 * Modifications Copyright OpenSearch Contributors. See
        cluster.beforeTest(random());
            setMaxShardLimit(maxAllowedShardsPerCluster, SETTING_MAX_SHARDS_PER_CLUSTER_KEY);
                    .get();
                .put(SETTING_NUMBER_OF_REPLICAS, counts.getFirstIndexReplicas())
                    .cluster()
        verifyException(dataNodes, counts, e);
                + " shards open;";
        createIndex(
                + dataNodes * shardsPerNode
 * the Apache License, Version 2.0 (the "License"); you may
        prepareCreate(
            + getShardType()
import org.opensearch.core.common.unit.ByteSizeValue;
                .get();
        String maxShardsPerNode = clusterState.getMetadata().settings().get(getShardsPerNodeKey());
                .build()
import org.opensearch.cluster.ClusterState;
                .put(SETTING_NUMBER_OF_SHARDS, counts.getFirstIndexShards())
    private int startTestNodes(int nodeCount) {
package org.opensearch.cluster.shards;
                    .prepareUpdateSettings()
        );
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
    protected Settings nodeSettings(int nodeOrdinal) {
                }
     */
        // Checking if the total shards created are equivalent to dataNodes * cluster.max_shards_per_node
        // Starting 3 ClusterManagerOnlyNode nodes
                Settings.builder()
            int totalShardsAfter = (dataNodes) * (firstIndexShards + secondIndexShards);
    }
            "test-index",
        try {
    public void testIndexCreationOverLimitFromTemplate() {
        // Getting total active shards in the cluster.
        int extraShardCount = 1;
            } else {
                .indices()
        createIndex(
import org.opensearch.common.util.FeatureFlags;
        setIgnoreDotIndex(true);
        int dataNodes = startTestNodes(3);
    public Settings indexSettings() {
                .get()
        }
            "test",
            Settings.builder()
        /*
                + "]/["
            } else {
    /**
     * number of shards equivalent to the cluster.max_shards_per_node and the cluster.ignore_Dot_indexes
                .setWaitForCompletion(true)
        dataNodes = ensureMultipleDataNodes(dataNodes);
            Create an index that will bring us up to the limit. It would create index with primary equal to the
                + "] maximum "
        assertAcked(client.admin().indices().prepareClose("test-index-1"));
                Settings.builder()
        dataNodes = ensureMultipleDataNodes(dataNodes);
        // This would be the first one where cluster.ignore_dot_indexes is true because the above calls are blocking.
            Settings.builder()
import static org.hamcrest.Matchers.greaterThan;
        assertAcked(
                + (dataNodes * firstShardCount)
            new NodeConfigurationSource() {
     * The test checks if the index starting with the dot can be created if the node has
                .put(indexSettings())
                .put(SETTING_NUMBER_OF_REPLICAS, 0)
        // Create an index that will bring us up to the limit
            if (frequently()) {
                        .put(ClusterShardLimitIT.this.nodeSettings(nodeOrdinal))
        } catch (IllegalArgumentException e) {
                .put(SETTING_NUMBER_OF_REPLICAS, counts.getFailingIndexReplicas())
        int dataNodes = startTestNodes(3);
            int extraShardCount = indexPrimaryShards * (1 + indexReplicaShards);
        ensureGreen();
            0,
        }
            Settings.builder().put(indexSettings()).put(SETTING_NUMBER_OF_SHARDS, firstShardCount).put(SETTING_NUMBER_OF_REPLICAS, 0)
                    .setTransientSettings(Settings.builder().put(key, limit).build())
                .setSettings(Settings.builder().put("number_of_replicas", dataNodes))
     * indexes starting with dot would fail as well.
        );
     */
import java.nio.file.Path;
            ClusterHealthResponse clusterHealth = cluster.client().admin().cluster().prepareHealth().get();
                .put(SETTING_NUMBER_OF_SHARDS, counts.getFailingIndexShards())
                .get();
            RestoreSnapshotResponse restoreSnapshotResponse = client.admin()
        Boolean isWarmIndex = WRITABLE_WARM_INDEX_SETTING.get(settings);
        logger.info("--> snapshot");
                    .actionGet()
        int currentActiveShards = client().admin().cluster().prepareHealth().get().getActiveShards();
        Settings.Builder repoSettings = Settings.builder();
        int currentActiveShards = client().admin().cluster().prepareHealth().get().getActiveShards();
        );
        // Checking if the total shards created are equivalent to dataNodes * cluster.max_shards_per_node
        super(nodeSettings);
            fail(ex.getMessage());
    }
        ClusterHealthResponse healthResponse = client.admin()
            fail(ex.getMessage());
                public Settings nodeSettings(int nodeOrdinal) {
 * You may obtain a copy of the License at
        try {
                response = client().admin()
        int secondIndexShards = secondIndexFactor * dataNodes;
        int maxAllowedShards = dataNodes * dataNodes;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            .admin()
            .prepareUpdateSettings()
            assertEquals(expectedError, e.getMessage());
                MockTransportService.TestPlugin.class,
        int currentActiveShards = client().admin().cluster().prepareHealth().get().getActiveShards();
    }
            Create an index that will bring us up to the limit. It would create index with primary equal to the
    public ClusterShardLimitIT(Settings nodeSettings) {
        return isWarmIndex ? RoutingPool.REMOTE_CAPABLE : RoutingPool.LOCAL_ONLY;
            fail("should not be able to set negative shards per node");
public class ClusterShardLimitIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        }
            .execute()
                + getShardType()
                + difference
        // Getting cluster.max_shards_per_node setting
        ShardCounts counts = ShardCounts.forDataNodeCount(dataNodes);
import static org.hamcrest.Matchers.equalTo;
        );
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
            Arrays.asList(
                .actionGet();
        createIndex(
            .build();
                + "]/["
                .get()
            int difference = totalShardsAfter - totalShardsBefore;
    }
                    .put(SETTING_NUMBER_OF_SHARDS, counts.getFailingIndexShards())
        }
        int shardsPerNode = firstIndexFactor + (secondIndexFactor * (1 + secondIndexReplicas));
                    .build()
                    .put(indexSettings())
        assertEquals(dataNodes * Integer.parseInt(maxShardsPerNode), currentActiveShards);
        clusterAdmin().prepareCleanupRepository(REPOSITORY_NAME).get();
            "test-index-1",
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
        // Creating an index starting with dot having shards greater thn the desired node limit
    private RoutingPool getShardType() {
                    .isTimedOut(),
        int dataNodes = startTestNodes(3);
        }
     * setting is set to false. If the cluster.ignore_Dot_indexes is set to false index creation of
            + extraShards
        cluster.startDataOnlyNode(Settings.builder().put("cluster.ignore_dot_indexes", false).build());
        // Getting cluster.max_shards_per_node setting
 * SPDX-License-Identifier: Apache-2.0
    }
        int maxAllowedShardsPerCluster = maxAllowedShardsPerNode * 1000;
        setMaxShardLimit(shardsPerNode, getShardsPerNodeKey());
            + getShardType()
                .put(SETTING_NUMBER_OF_REPLICAS, 0)
        try {
            .prepareCreate(".test-index")
    }
        cluster.client()
            + maxShards
import org.opensearch.common.network.NetworkModule;
                .put(SETTING_NUMBER_OF_SHARDS, counts.getFirstIndexShards())
                .prepareUpdateSettings(randomFrom("_all", "test-*", "*-index"))
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
import org.opensearch.snapshots.SnapshotInfo;
                client().admin()
        }
                InternalSettingsPlugin.class,
        Settings.Builder featureSettings = Settings.builder();
        IOUtils.close(cluster);
            .actionGet();
                .setIndices("snapshot-index")
    private void verifyException(int dataNodes, ShardCounts counts, IllegalArgumentException e) {
    }
            "cluster-",
     * indexes starting with dot would succeed.
            internalCluster().startNode(dataNode());
            .setWaitForGreenStatus()
        int currentShards = counts.getFirstIndexShards() * (1 + counts.getFirstIndexReplicas());
        assertThat(snapshotInfos.size(), equalTo(1));
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
import java.util.List;
            Function.identity()
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
        createIndex(
import org.opensearch.node.Node;
                        .put(indexSettings())
    public void testChangingMultipleIndicesOverLimit() {
        boolean isWarmIndex = WRITABLE_WARM_INDEX_SETTING.get(settings);
import org.opensearch.core.common.unit.ByteSizeUnit;
        } else {
    }
        prepareCreate(
     * @param limit the limit value to set.
                client().admin()
        /*
                .put(SETTING_NUMBER_OF_SHARDS, counts.getFailingIndexShards())
import org.opensearch.test.InternalSettingsPlugin;
            .put(super.nodeSettings(nodeOrdinal))
     *
                TestSeedPlugin.class,
        featureSettings.put(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG, true);
     * @param key node level or cluster level setting key.
    }
            Settings.builder()
import java.util.Arrays;
        );
        logger.info("-->  creating repository");
        if (counts.getFirstIndexShards() > 0) {
    @After
            "test-fill",
            Settings.builder()
    }
import org.opensearch.indices.ShardLimitValidator;
                .put(indexSettings())
            .get();
            "cluster",
                }
                .put(SETTING_NUMBER_OF_SHARDS, counts.getFirstIndexShards())
        } catch (IllegalArgumentException e) {
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        }
        } catch (IllegalArgumentException e) {
import org.opensearch.common.util.io.IOUtils;
        List<SnapshotInfo> snapshotInfos = client.admin()
                client().admin()
        cluster.stopCurrentClusterManagerNode();
                .put(SETTING_NUMBER_OF_SHARDS, maxAllowedShards)
                .prepareUpdateSettings("growing-should-fail")
        int dataNodes = startTestNodes(3);
    @Override
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
            () -> client().admin().indices().prepareCreate("should-fail").get()
        InternalTestCluster cluster = new InternalTestCluster(
        setMaxShardLimit(counts.getShardsPerNode(), getShardsPerNodeKey());
            verifyException(maxAllowedShardsPerNode * dataNodeCount, currentActiveShards, extraShardCount, e);
        assertAcked(
                assertEquals(ignoreDotIndex, response.getTransientSettings().getAsBoolean(ignoreDotIndexKey, true));
            + "] total "
        return WRITABLE_WARM_INDEX_SETTING.get(settings) == false;
        );
            .setIndices("snapshot-index")
        int dataNodes = startTestNodes(3);
                    .put(indexSettings())
            + "] total "
        // Getting cluster.max_shards_per_node setting
            "test-fill",
            assertEquals(
        assertTrue(clusterState.getMetadata().hasIndex(".test-index"));
        clusterState = client().admin().cluster().prepareState().get().getState();
import java.util.Collections;
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
                .put(SETTING_NUMBER_OF_SHARDS, maxAllowedShards)
        }
import org.opensearch.cluster.routing.RoutingPool;
            client().admin()
        // Waiting for all shards to get assigned
            Settings.builder()
            }
            + " shards, but this cluster currently has ["
            .put(remoteStoreClusterSettings(REPOSITORY_NAME, absolutePath))
                    .get();
import org.opensearch.transport.client.Client;
            fail("should not have been able to increase shards above limit");
        // Getting total active shards in the cluster.
    }
            int dataNodeCount = clusterHealth.getNumberOfDataNodes();
            0,
        ).get();
        }
