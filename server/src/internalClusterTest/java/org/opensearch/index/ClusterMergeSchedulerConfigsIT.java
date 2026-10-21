            .prepareUpdateSettings(indexName)
                .put(indexSettings())
            .cluster()
        // Set cluster defaults
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
     *   merge_count = 11 (auto-calculated: 6 + 5)
        assertEquals(6, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        // Set cluster defaults
            .prepareUpdateSettings()
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
        ensureYellowAndNoInitializingShards(indexName);
            .cluster()
        assertEquals(true, thirdIndexService.getIndexSettings().getMergeSchedulerConfig().isAutoThrottle());
        assertEquals(true, indexService.getIndexSettings().getMergeSchedulerConfig().isAutoThrottle());
    }
     * <p>
        Index index = new Index(indexName, uuid);
        assertEquals("10", clusterSettings.get(CLUSTER_MAX_THREAD_COUNT_SETTING).toString());
        assertEquals("200", clusterSettings.get(CLUSTER_MAX_MERGE_COUNT_SETTING).toString());
        assertEquals(35, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
     * 3. Remove thread_count
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
                .put(indexSettings())
 *   <tr>
                    .put(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey(), 10)
        client(clusterManagerName).admin()
        createIndex(indexName, indexSettings());
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
                TieredMergePolicyProvider.INDEX_COMPOUND_FORMAT_SETTING.getKey(),
        assertEquals(5, indexServiceWith.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        builder.setSettings(Settings.builder().put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), 1).build());
 *     <td>Both use your values (if valid)</td>
    /**
     */
        assertEquals(expectedThreadCount, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
     * </pre>
        assertEquals(25, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        ensureGreen(indexName);
 * this work for additional information regarding copyright
        // thread_count should stay at index-level setting
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
            .setTransientSettings(Settings.builder().put(CLUSTER_MAX_MERGE_COUNT_SETTING.getKey(), 35))
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
            .setTransientSettings(Settings.builder().put(CLUSTER_MAX_THREAD_COUNT_SETTING.getKey(), 100))
        String clusterManagerName = internalCluster().getClusterManagerName();
 *     <th>Index Settings State</th>
        assertEquals("60", clusterSettings.get(CLUSTER_MAX_THREAD_COUNT_SETTING).toString());
     * <pre>
        assertEquals(40, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        assertEquals(expectedMergeCount, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
    /**
     * 1. Set cluster defaults: thread_count=10, merge_count=20
        return indicesService.indexService(index);
            .cluster()
        if (random.nextBoolean()) {
            )
     * <pre>
 *   </tr>
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2)
     * 1. Create index (uses absolute defaults)
     * 1. Set cluster defaults: thread_count=60, merge_count=80
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
            .prepareUpdateSettings()
            )
        client(clusterManagerName).admin()
 */
 *     <td>Doesn't matter</td>
        assertEquals(12, indexServiceWith.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
 *     <td>Doesn't matter</td>
        String uuidWithout = getIndexResponse.getSettings().get(indexWithoutSettings).get(IndexMetadata.SETTING_INDEX_UUID);
        // Remove thread_count setting
    /**
                indexName,
        ensureGreen(indexName);
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at
    }
import java.util.concurrent.ExecutionException;
        );
        ensureYellowAndNoInitializingShards(indexName);
import org.opensearch.common.settings.Settings;
    }
        createIndex(indexName, indexSettings());
     * 2. Create two indices: one with explicit settings, one without
        client(clusterManagerName).admin()
     * 3. Remove thread_count
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
            .setTransientSettings(
        ensureGreen(indexName);
     * </pre>
    public void testRemoveOneOfTwoSettings() throws Exception {
            .setTransientSettings(
    }
        // Existing index should immediately pick up cluster defaults
        // verify no change in settings post failure
     * 2. Set cluster defaults
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *     <td>Removed → absolute default<br/>Other → keeps index value</td>
    /**
            .setTransientSettings(
        ensureYellowAndNoInitializingShards(indexName);
     * <pre>
     */
        assertEquals(expectedMergeCount, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        indexService = getIndexService(indicesService, index);
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
     * <p>
    /**
import org.opensearch.action.admin.indices.get.GetIndexRequest;
            indexName,
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
        assertEquals(200, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
                .build()
        String indexName = "test-merge-count-only";
     */
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
     * 4. Result: Both fall back to cluster defaults because merge_count wasn't explicitly set
     * 4. Result: thread_count falls back to ABSOLUTE default (not cluster default of 3)
 */
import org.opensearch.core.index.Index;
        String clusterManagerName = internalCluster().getClusterManagerName();
    public void testInvalidConfiguration() {
            .prepareUpdateSettings()
/*
                .put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), 15)
        // Both should fall back to cluster defaults
 *     <td>Both → cluster defaults</td>
     * 5. Index with explicit settings should remain unchanged
                .put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), 15)
            .setTransientSettings(Settings.builder().putNull(CLUSTER_MAX_THREAD_COUNT_SETTING.getKey()))
                Settings.builder().put(CLUSTER_MAX_THREAD_COUNT_SETTING.getKey(), 60).put(CLUSTER_MAX_MERGE_COUNT_SETTING.getKey(), 80)
            .indices()
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
            .cluster()
        assertEquals(12, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
                .put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), 12)
                .put(indexSettings())
        client(clusterManagerName).admin()
            .get();
        assertEquals(20, secondIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
                Settings.builder().put(CLUSTER_MAX_THREAD_COUNT_SETTING.getKey(), 12).put(CLUSTER_MAX_MERGE_COUNT_SETTING.getKey(), 25)
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
            .get();
        assertEquals(80, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
            .setSettings(
            .put(super.indexSettings())
        assertEquals(80, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
                Settings.builder().put(CLUSTER_MAX_MERGE_COUNT_SETTING.getKey(), 80).put(CLUSTER_MAX_THREAD_COUNT_SETTING.getKey(), 60)
 *   <tr>
                .cluster()
 *
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2);
     * Tests that absolute defaults are calculated correctly when no cluster or index settings exist.
        assertEquals(12, indexServiceWith.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
     * Set: thread_count = 6
    }
        String indexName = "log-myindex-1";
     * <pre>
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
        assertEquals(60, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        String clusterManagerName = internalCluster().getClusterManagerName();
            )
        String indexName = "test-existing-index";
                Settings.builder().put(CLUSTER_MAX_MERGE_COUNT_SETTING.getKey(), 80).put(CLUSTER_MAX_THREAD_COUNT_SETTING.getKey(), 60)
                .build()
            indexName,
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
     */
                .put(indexSettings())
        ensureGreen(indexName);
     * <p>
            .prepareUpdateSettings()
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
 *     <td>Only merge count set</td>
            )
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
 */
                .put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), 15)
        assertEquals(expectedThreadCount, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        ensureGreen(indexName);
            .cluster()
        String clusterManagerName = internalCluster().getClusterManagerName();
import org.opensearch.action.admin.indices.get.GetIndexResponse;
        assertEquals(35, secondIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
            .prepareUpdateSettings(indexName)
        builder.setSettings(Settings.builder().put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), 100).build());
     * <p>
        );
        indexName = "log-myindex-3";
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
        String indexName = "test-remove-all";
     * Tests removing BOTH explicit index settings (when both were set).
    protected Settings.Builder setRandomIndexMergeSettings(Random random, Settings.Builder builder) {
        String indexWithoutSettings = "test-without-settings";
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
    /**
        assertEquals((60 + 5), indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        String indexName = "log-myindex-1";
        );
        );
        assertEquals("105", clusterSettings.get(CLUSTER_MAX_MERGE_COUNT_SETTING).toString());
 *   </tr>
        String clusterManagerName = internalCluster().getClusterManagerName();
        ensureGreen(indexWithoutSettings);
 *
        builder = client().admin().indices().prepareUpdateSettings("log-myindex-2");
        // Verify initial state
        createIndex(
                Settings.builder().put(CLUSTER_MAX_MERGE_COUNT_SETTING.getKey(), 80).put(CLUSTER_MAX_THREAD_COUNT_SETTING.getKey(), 60)
        IndexService indexService = getIndexService(indicesService, index);
 *
    public void testRemoveOnlyExplicitSetting() throws Exception {
        client(clusterManagerName).admin()
        assertEquals(35, secondIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
    public void testIndexLevelBothSet() throws Exception {
 * GitHub history for details.
        // Create index with explicit settings
        getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
        Index index = new Index(indexName, uuid);
                .setTransientSettings(Settings.builder().put(CLUSTER_MAX_THREAD_COUNT_SETTING.getKey(), 100))
        // merge_count should fall back to absolute default, NOT cluster default
        assertEquals(20, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
 *   <caption>Settings hierarchy and fallback behavior for merge scheduler configuration</caption>
     * Tests setting only MAX_THREAD_COUNT at index level.
        // thread_count should fall back to absolute default, NOT cluster default of 3
        assertEquals(6, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
            Settings.builder().put(indexSettings()).put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), 15).build()
            .actionGet();
    }
     * 3. Index should use cluster defaults
            .get();
        assertEquals(true, indexService.getIndexSettings().getMergeSchedulerConfig().isAutoThrottle());
        ensureGreen(indexName);
import org.opensearch.cluster.metadata.IndexMetadata;
        assertEquals("60", clusterSettings.get(CLUSTER_MAX_THREAD_COUNT_SETTING).toString());
        ensureGreen(indexName);
            )
                Settings.builder().put(CLUSTER_MAX_MERGE_COUNT_SETTING.getKey(), 40).put(CLUSTER_MAX_THREAD_COUNT_SETTING.getKey(), 20)
        ensureGreen(indexName);
 *     <td>Yes</td>
        uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
 *     <td>Absolute defaults (CPU-based)</td>
            Settings.builder()
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
        createIndex(
        assertEquals(60, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
            .prepareUpdateSettings(indexName)
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
        ensureYellowAndNoInitializingShards(indexWithSettings);
        ensureGreen(indexName);
        Settings.Builder s = Settings.builder()
                .build()
import org.opensearch.common.settings.ClusterSettings;
        assertEquals(3, thirdIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        // adjusted accordingly (since its not already set)
 *     <td>Invalid combination</td>
        String indexName = "test-invalid-config";
 *     <td>Doesn't matter</td>
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
 *   <tr>
        Index index = new Index(indexName, uuid);
        ensureGreen(indexName);
        assertEquals("80", clusterSettings.get(CLUSTER_MAX_MERGE_COUNT_SETTING).toString());
        );
        Index index = new Index(indexName, uuid);
        // Index with explicit settings should remain unchanged
     * </pre>
            Settings.builder()
        // update index level setting to override cluster level default
    public Settings nodeSettings(int nodeOrdinal) {
    }
        assertEquals(15, indexServiceWithout.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
            .setTransientSettings(
        assertEquals(80, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        builder.setSettings(Settings.builder().putNull(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey()).build());
     * <p>
        getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
        assertEquals(40, secondIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
            .indices()
        return s.build();
        // Verify using absolute defaults initially
            )
    public void testAbsoluteDefaults() throws Exception {
    public void testClusterDefaultUpdate() throws ExecutionException, InterruptedException {
     * Result:
 * How this is supposed to work -
            .get();
            )
 *     <td>{@code testIndexLevelBothSet()}</td>
     * 3. Existing index should immediately pick up cluster defaults
     * <p>
                (random.nextBoolean() ? random.nextDouble() : random.nextBoolean()).toString()
            Settings.builder()
        client().admin()
     */
            .cluster()
        assertEquals(100, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
 *   </tr>
     * Tests that invalid configurations (thread_count > merge_count) are rejected.
        IllegalArgumentException exception = expectThrows(
     * Tests that cluster defaults apply to indices created BEFORE the cluster setting was set.
        assertEquals(105, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
 *     <th>Resulting Configuration</th>
        createIndex(
        assertEquals(20, secondIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
                    .put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), 5)
        // Removing CLUSTER_MAX_MERGE_COUNT_SETTING and asserting it gets adjusted according to CLUSTER_MAX_THREAD_COUNT_SETTING
 *   <tr>
import org.opensearch.test.OpenSearchIntegTestCase;
        assertEquals(true, secondIndexService.getIndexSettings().getMergeSchedulerConfig().isAutoThrottle());
                .build()
        assertEquals(3, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        // changing cluster level default should only affect indices without index level override
        assertEquals("60", clusterSettings.get(CLUSTER_MAX_THREAD_COUNT_SETTING).toString());
    public void testClusterDefaultsApplyToExistingIndices() throws Exception {
        assertEquals(20, thirdIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
            Settings.builder()
 * <table border="1">
        createIndex(indexName, indexSettings());
    }
        return builder;
     * <pre>
            indexName,
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
            .setSettings(Settings.builder().putNull(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey()))
        assertEquals(35, secondIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
/**
     * <pre>
 *     <td>Nothing set</td>
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, replicas)
        // updating CLUSTER_MAX_MERGE_COUNT_SETTING to 200
                Settings.builder().put(CLUSTER_MAX_THREAD_COUNT_SETTING.getKey(), 10).put(CLUSTER_MAX_MERGE_COUNT_SETTING.getKey(), 20)
        int expectedThreadCount = 3;
        ensureYellowAndNoInitializingShards(indexName);
            IllegalArgumentException.class,
     *   merge_count = 15
        IndexService indexService = getIndexService(indicesService, index);
     * Scenario:
        ensureGreen(indexName);
        assertEquals(true, indexService.getIndexSettings().getMergeSchedulerConfig().isAutoThrottle());
            .cluster()
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
                Settings.builder().put(CLUSTER_MAX_THREAD_COUNT_SETTING.getKey(), 10).put(CLUSTER_MAX_MERGE_COUNT_SETTING.getKey(), 20)
        uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
        UpdateSettingsRequestBuilder builder = client().admin().indices().prepareUpdateSettings(indexName);
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
        IndexService indexService = getIndexService(indicesService, index);
        assertEquals(3, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
     *   thread_count = 6
    public Settings indexSettings() {
        Index index = new Index(indexName, uuid);
 *     <th>Cluster Defaults Exist?</th>
        // Verify initial state
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
        );
     * </pre>
        assertEquals(100, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
    }
 *   </tr>
        assertEquals(35, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
     * 4. Index without explicit settings should use new cluster defaults
        indexName = "test-remove-one-of-two-2";
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
            .get();
            () -> client(clusterManagerName).admin()
                Settings.builder().put(CLUSTER_MAX_THREAD_COUNT_SETTING.getKey(), 13).put(CLUSTER_MAX_MERGE_COUNT_SETTING.getKey(), 18)
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
 *     <td>Rejected (thread_count > merge_count)</td>
                    .build()
            indexName,
        client(clusterManagerName).admin()
        client(clusterManagerName).admin()
        assertEquals(20, thirdIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
            .cluster()
        client(clusterManagerName).admin()
 * KIND, either express or implied.  See the License for the
        builder.execute().actionGet();
        // updating cluster level auto_throttle to false
     * 2. Create index with only thread_count=6 (merge_count auto-calculates to 11)
        int expectedMergeCount = expectedThreadCount + 5;
            .indices()
        createIndex(
        assertEquals(40, secondIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
                .build()
        // Verify initial state
        createIndex(indexName, indexSettings());
        builder.setSettings(Settings.builder().putNull(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey()).build());
        ClusterSettings clusterSettings = indicesService.clusterService().getClusterSettings();
 *     <td>merge_count = your value<br/>thread_count = absolute default</td>
        assertEquals("60", clusterSettings.get(CLUSTER_MAX_THREAD_COUNT_SETTING).toString());
     * <p>
        client().admin()
 *     <td>{@code testRemoveAllSettings()}</td>
        }
        assertEquals(30, indexServiceWithout.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        assertEquals(40, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        createIndex(
 * the Apache License, Version 2.0 (the "License"); you may
                .put(indexSettings())
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
        assertTrue(exception.getMessage().contains("maxThreadCount (= 10) should be <= maxMergeCount (= 5)"));
        assertEquals(150, thirdIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        builder.execute().actionGet();
                .put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), 20)
import java.util.List;
 *     <td>No</td>
        client().admin()
     * 3. Remove BOTH settings
        assertEquals("80", clusterSettings.get(CLUSTER_MAX_MERGE_COUNT_SETTING).toString());
 *     <td>Had 1, removed it</td>
        // Set only merge_count at index level
 *     <td>{@code testInvalidConfiguration()}</td>
        client().admin()
    /**
        client(clusterManagerName).admin()
        // Remove both settings
        builder = client().admin().indices().prepareUpdateSettings(indexName);
            .cluster()
    private IndexService getIndexService(IndicesService indicesService, Index index) throws Exception {
     * </p>
            .setTransientSettings(
            .cluster()
 *   <tr>
        uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
            .cluster()
     * <pre>
        String indexName = "test-remove-one-of-two-1";
import org.junit.Before;
     * Tests setting both MAX_THREAD_COUNT and MAX_MERGE_COUNT at index level.
            )
     * Scenario:
 *   </tr>
     * Expected behavior:
        index = new Index(indexName, uuid);
        ClusterSettings clusterSettings = indicesService.clusterService().getClusterSettings();
        String clusterManagerName = internalCluster().getClusterManagerName();
        assertEquals("80", clusterSettings.get(CLUSTER_MAX_MERGE_COUNT_SETTING).toString());
        assertEquals(20, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        ensureYellowAndNoInitializingShards(indexName);
            .prepareUpdateSettings()
            .prepareUpdateSettings()
        assertEquals(80, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
     * </pre>
        assertEquals(20, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
            builder.put(
 * Integration tests for {@link ClusterMergeSchedulerConfig} and merge scheduler settings hierarchy.
        // and no change in settings' values
        assertEquals(5, indexServiceWith.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
     * The golden rule: {@code MAX_THREAD_COUNT must always be <= MAX_MERGE_COUNT}
            .cluster()
}
        // now remove merge_count when both index level settings are present
        assertEquals(expectedThreadCount, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
    /**
     * </pre>
     * <pre>
 *    http://www.apache.org/licenses/LICENSE-2.0
        createIndex(indexName, indexSettings());
 * <h2>Complete Decision Matrix</h2>
    }
 *   </tr>
        assertEquals(false, thirdIndexService.getIndexSettings().getMergeSchedulerConfig().isAutoThrottle());
        assertEquals(27, thirdIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        assertTrue(exception.getMessage().contains("maxThreadCount (= 100) should be <= maxMergeCount (= 80)"));
        assertEquals(true, secondIndexService.getIndexSettings().getMergeSchedulerConfig().isAutoThrottle());
            Settings.builder().put(indexSettings()).put(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey(), 6).build()
    @Override
        assertEquals("3", clusterSettings.get(CLUSTER_MAX_THREAD_COUNT_SETTING).toString());
        // We wait for the index to become available on the node.
 *     <td>Had 2, removed both</td>
     */
 *     <td>{@code testRemoveOnlyExplicitSetting()}</td>
        assertEquals(10, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
                Settings.builder()
        );
        // Remove the only explicit setting (merge_count)
        assertEquals(15, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
            .get();
            .setTransientSettings(
        assertEquals(expectedThreadCount, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
 *
                    .putNull(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey())
                .build()
        String clusterManagerName = internalCluster().getClusterManagerName();
 *   <tr>
/*
            .get();
        assertBusy(() -> assertNotNull("IndexService should not be null", indicesService.indexService(index)), 120, TimeUnit.SECONDS);
            indexName,
            .prepareUpdateSettings()
        assertEquals("80", clusterSettings.get(CLUSTER_MAX_MERGE_COUNT_SETTING).toString());
                .prepareUpdateSettings()
        createIndex(indexName, indexSettings());
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequestBuilder;
        // Set cluster defaults to verify they're NOT used for thread_count
 *   </tr>
            .setTransientSettings(
        );
    public void testIndexLevelThreadCountOnly() throws Exception {
            .actionGet();
        IndexService indexServiceWith = indicesService.indexService(new Index(indexWithSettings, uuidWith));
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put(NODE_PROCESSORS_SETTING.getKey(), 6).build();
        client(clusterManagerName).admin()
        assertEquals(80, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
            )
    /**
                Settings.builder()
        String clusterManagerName = internalCluster().getClusterManagerName();
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
            .setSettings(Settings.builder().putNull(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey()))
                .put(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey(), 6)
            .get();
            .setSettings(Settings.builder().put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), 100))
        assertEquals(expectedMergeCount, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        assertEquals(6, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
import java.util.concurrent.TimeUnit;
        ClusterSettings clusterSettings = indicesService.clusterService().getClusterSettings();
            .get();
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
 *     <td>{@code testIndexLevelThreadCountOnly()}</td>
            .setTransientSettings(
        IndexService indexService = getIndexService(indicesService, index);
        assertEquals(3, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        assertEquals(3, thirdIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
    }
            .prepareUpdateSettings()
            .prepareUpdateSettings()
import static org.opensearch.indices.ClusterMergeSchedulerConfig.CLUSTER_MAX_MERGE_COUNT_SETTING;
        IndexService indexService = getIndexService(indicesService, index);
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
        String indexName = "test-cluster-defaults";
            .prepareUpdateSettings(indexName)
        client(clusterManagerName).admin()
                Settings.builder().put(CLUSTER_MAX_THREAD_COUNT_SETTING.getKey(), 15).put(CLUSTER_MAX_MERGE_COUNT_SETTING.getKey(), 30)
 *     <td>Only thread count set</td>
     * Tests that cluster defaults override absolute defaults when set.
            Settings.builder()
        String indexWithSettings = "test-with-settings";
     * <p>
            .setSettings(Settings.builder().putNull(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey()))
        int replicas = randomIntBetween(1, Math.max(1, internalCluster().numDataNodes() - 1));
                .put(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey(), 8)
 *     <td>{@code testClusterDefaults()}</td>
                    .put(indexSettings())
        createIndex(
     */
            .setTransientSettings(Settings.builder().put(CLUSTER_MAX_MERGE_COUNT_SETTING.getKey(), 200))
        assertEquals(expectedMergeCount, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        IndexService indexService = getIndexService(indicesService, index);
            .execute()
import static org.opensearch.indices.ClusterMergeSchedulerConfig.CLUSTER_MAX_THREAD_COUNT_SETTING;
            .get();
        assertEquals(expectedThreadCount, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
    }
    }
        // merge_count should be 100, thread_count falls back to absolute default
        // try to update with an invalid setting
            )
        assertEquals("100", clusterSettings.get(CLUSTER_MAX_THREAD_COUNT_SETTING).toString());
            .execute()
     */
    }
        assertEquals(20, secondIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        createIndex(indexWithoutSettings, indexSettings());
        indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
        assertEquals("65", clusterSettings.get(CLUSTER_MAX_MERGE_COUNT_SETTING).toString());
        assertEquals(expectedThreadCount, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
            .execute()
                .put(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey(), 6)
        assertEquals(15, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        indexName = "log-myindex-2";
        assertEquals(80, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
            .get();
 *     <td>Both → cluster defaults</td>
            .cluster()
     * Tests removing the ONLY explicit index setting (the other was auto-calculated).
 * specific language governing permissions and limitations
        Index index = new Index(indexName, uuid);
        client(clusterManagerName).admin()
        assertEquals("60", clusterSettings.get(CLUSTER_MAX_THREAD_COUNT_SETTING).toString());
        String indexName = "test-both-set";
        IndexService indexService = getIndexService(indicesService, new Index(indexName, uuid));
        assertEquals(expectedMergeCount, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
     * Scenario:
 *   </tr>
        Index index = new Index(indexName, uuid);
        ensureYellowAndNoInitializingShards(indexName);
     * <pre>
        ensureYellowAndNoInitializingShards(indexName);
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
        client().admin()
        client(clusterManagerName).admin()
        // Index without explicit settings should update
                .put(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey(), 5)
/*
                .put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), 150)
     *   thread_count = absolute default (NOT cluster default even if it exists)
            );
     * Scenario:
import java.util.ArrayList;
        int expectedMergeCount = expectedThreadCount + 5;
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
            .prepareUpdateSettings()
            .setTransientSettings(
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
    public void setUp() throws Exception {
 *     <td>{@code testIndexLevelMergeCountOnly()}</td>
     * 1. Set cluster defaults: thread_count=10, merge_count=20
 *   </tr>
     * Scenario:
        );
        String indexName = "test-remove-only-explicit";
import static org.opensearch.indices.ClusterMergeSchedulerConfig.CLUSTER_AUTO_THROTTLE_SETTING;
        assertEquals(60, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        assertEquals(20, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        // setting auto throttle back to true for one index
        assertEquals(8, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        ensureYellowAndNoInitializingShards(indexName);
        // Both should fall back to cluster defaults
        ensureYellowAndNoInitializingShards(indexName);
        client(clusterManagerName).admin()
 * Modifications Copyright OpenSearch Contributors. See
        // Set cluster defaults
        // Now set cluster defaults
        assertEquals(true, indexService.getIndexSettings().getMergeSchedulerConfig().isAutoThrottle());
        assertEquals(false, indexService.getIndexSettings().getMergeSchedulerConfig().isAutoThrottle());
 *     <td>{@code testRemoveOneOfTwoSettings()}</td>
     * 2. Create index with both settings: thread_count=6, merge_count=15
        assertEquals(3, thirdIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
            .get();
        assertEquals(20, secondIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        String clusterManagerName = internalCluster().getClusterManagerName();
    @Override
 *     <td>{@code testAbsoluteDefaults()}</td>
     * Scenario:
    @Override
        assertEquals(35, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        // Updating cluster defaults: CLUSTER_MAX_THREAD_COUNT_SETTING=60 and CLUSTER_MAX_MERGE_COUNT_SETTING=80
        String clusterManagerName = internalCluster().getClusterManagerName();
        int expectedThreadCount = 3;
        assertEquals("20", clusterSettings.get(CLUSTER_MAX_MERGE_COUNT_SETTING).toString());
        // updating CLUSTER_MAX_THREAD_COUNT_SETTING to 100 and expecting CLUSTER_MAX_MERGE_COUNT_SETTING to get
        String clusterManagerName = internalCluster().getClusterManagerName();
        assertEquals(20, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
            .actionGet();
        assertEquals(8, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        assertEquals(35, thirdIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
                    .putNull(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey())
        assertEquals("60", clusterSettings.get(CLUSTER_MAX_THREAD_COUNT_SETTING).toString());
            .prepareUpdateSettings()
        createIndex(
        UpdateSettingsRequestBuilder builder = client().admin().indices().prepareUpdateSettings(indexName);
    /**
        // Update cluster defaults
        assertEquals("200", clusterSettings.get(CLUSTER_MAX_MERGE_COUNT_SETTING).toString());
        String clusterManagerName = internalCluster().getClusterManagerName();
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
     * MAX_MERGE_COUNT = MAX_THREAD_COUNT + 5
     * MAX_THREAD_COUNT = max(1, min(4, cpuCores/2))
        indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
    public void testMergeSchedulerSettingsWithMultipleIndices() throws Exception {
        createIndex(indexName, indexSettings());
        assertEquals(false, thirdIndexService.getIndexSettings().getMergeSchedulerConfig().isAutoThrottle());
            .execute()
            )
        ensureYellowAndNoInitializingShards(indexName);
        client(clusterManagerName).admin()
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
 *     <td>Yes</td>
    public void testRemoveAllSettings() throws Exception {
        assertEquals("60", clusterSettings.get(CLUSTER_MAX_THREAD_COUNT_SETTING).toString());
    /**
        String clusterManagerName = internalCluster().getClusterManagerName();
    public void testFullLifecycle() throws Exception {
     * <p>
            () -> createIndex(
        ClusterSettings clusterSettings = indicesService.clusterService().getClusterSettings();
     * Expected behavior:
        ensureGreen(indexName);
     * Tests setting only MAX_MERGE_COUNT at index level.
 */
     **/
     */
        IndexService indexService = getIndexService(indicesService, index);
        assertEquals(35, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        builder = client().admin().indices().prepareUpdateSettings(indexName);
            .setTransientSettings(Settings.builder().put(CLUSTER_AUTO_THROTTLE_SETTING.getKey(), false))
        IndexService indexService = getIndexService(indicesService, index);
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
        assertEquals(60, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        UpdateSettingsRequestBuilder finalBuilder = builder;
 * Unless required by applicable law or agreed to in writing,
     * Set: merge_count = 15
                .put(indexSettings())
import org.opensearch.indices.ClusterMergeSchedulerConfig;
     * Tests that updating cluster defaults affects all indices without explicit settings.
        super.setUp();
        assertEquals("80", clusterSettings.get(CLUSTER_MAX_MERGE_COUNT_SETTING).toString());
 * The OpenSearch Contributors require contributions made to
        int expectedThreadCount = 3;
        builder.execute().actionGet();
        ensureGreen(indexWithSettings);
        ensureYellowAndNoInitializingShards(indexName);
        assertEquals(6, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        int expectedThreadCount = 3;
     * 1. Set cluster defaults: thread_count=60, merge_count=80
            .cluster()
            )
        assertEquals(11, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount()); // 6 + 5
            )
            .prepareUpdateSettings()
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
        assertEquals("60", clusterSettings.get(CLUSTER_MAX_THREAD_COUNT_SETTING).toString());
            indexWithSettings,
     * Expected behavior:
     * Expected behavior: Both values are used as-is (assuming they're valid).
                .get()
        assertEquals(false, indexService.getIndexSettings().getMergeSchedulerConfig().isAutoThrottle());
        IndexService thirdIndexService = getIndexService(indicesService, new Index(indexName, uuid));
public class ClusterMergeSchedulerConfigsIT extends OpenSearchIntegTestCase {
    @Override
 * this file be licensed under the Apache-2.0 license or a
     * Tests removing ONE of TWO explicit index settings.
     */
    }
        internalCluster().startClusterManagerOnlyNode();
        ensureGreen(indexName);
        ensureGreen(indexName);
            .get();
    /**
        String indexName = "test-thread-count-only";
        // Updating cluster defaults: CLUSTER_MAX_THREAD_COUNT_SETTING=60 and CLUSTER_MAX_MERGE_COUNT_SETTING=80
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
        );
        builder.setSettings(Settings.builder().put(MergeSchedulerConfig.AUTO_THROTTLE_SETTING.getKey(), "true").build());
        assertEquals("60", clusterSettings.get(CLUSTER_MAX_THREAD_COUNT_SETTING).toString());
        assertEquals(20, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        ensureGreen(indexName);
     * </pre>
            .indices()
        // Verify initial state
        assertEquals("80", clusterSettings.get(CLUSTER_MAX_MERGE_COUNT_SETTING).toString());
        builder.execute().actionGet();
        assertEquals(80, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> finalBuilder.execute().actionGet());
        assertEquals(true, indexService.getIndexSettings().getMergeSchedulerConfig().isAutoThrottle());
 *   <tr>
 * ownership. Elasticsearch licenses this file to you under
     * Result:
 *   <tr>
        assertEquals(100, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        assertEquals(15, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
     * 3. Update cluster defaults: thread_count=15, merge_count=30
        int expectedMergeCount = expectedThreadCount + 5;
            .execute()
        ensureYellowAndNoInitializingShards(indexName);
        // Create index without explicit settings
        // Updating cluster defaults: CLUSTER_MAX_THREAD_COUNT_SETTING=100, expecting failure for failed validation
     * <p>
     * 2. Create index with both settings: thread_count=6, merge_count=15
        assertEquals(20, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
 *     <td>Yes</td>
            .cluster()
            .get();
        assertEquals(200, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        ensureYellowAndNoInitializingShards(indexName);
     * </pre>
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
            .get();
    }
        int expectedMergeCount = 11; // MAX_THREAD_COUNT(=6) + 5
        assertEquals(15, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
 *   <tr>
        // Index should immediately pick up cluster defaults
 *     <td>Had 2, removed 1</td>
 *     <th>Test Method</th>
import static org.opensearch.common.util.concurrent.OpenSearchExecutors.NODE_PROCESSORS_SETTING;
        assertEquals(6, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        Index index = new Index(indexName, uuid);
 * </table>
        assertEquals(15, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        IndexService indexService = getIndexService(indicesService, new Index(indexName, uuid));
 *     <td>Cluster defaults</td>
            .get();
        assertEquals(60, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        assertEquals("80", clusterSettings.get(CLUSTER_MAX_MERGE_COUNT_SETTING).toString());
        assertEquals(20, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
    public void testClusterMergeConfigs() throws Exception {
        Index index = new Index(indexName, uuid);
            .setTransientSettings(
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
        assertEquals(60, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        IndexService secondIndexService = getIndexService(indicesService, new Index(indexName, uuid));
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
            indexName,
 * not use this file except in compliance with the License.
            Settings.builder()
        // Set initial cluster defaults
        assertEquals(expectedThreadCount, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
import org.opensearch.indices.IndicesService;
        // removing index level override should pick up the cluster level default
 *     <td>Doesn't matter</td>
     */
        assertEquals(60, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
    }
     * This demonstrates the full lifecycle: cluster defaults → index override → removal → fallback.
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
        assertEquals(35, thirdIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
 *     <td>N/A</td>
        // merge_count should stay at index-level setting
        client(clusterManagerName).admin()
        IndexService indexService = getIndexService(indicesService, index);
        assertEquals("100", clusterSettings.get(CLUSTER_MAX_THREAD_COUNT_SETTING).toString());
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
        ensureYellowAndNoInitializingShards(indexWithoutSettings);
 *   <tr>
        Index index = new Index(indexName, uuid);
        builder = client().admin().indices().prepareUpdateSettings(indexName);
 * compatible open source license.
                .put(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey(), 6)
            .get();
        assertTrue(exception.getMessage().contains("maxThreadCount (= 3) should be <= maxMergeCount (= 1)"));
            .cluster()
        createIndex(indexName, indexSettings());
        String indexName = "test-absolute-defaults";
     * <p>
        assertEquals(35, secondIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
     *           merge_count stays at 15
            .prepareUpdateSettings(indexName)
        assertEquals(100, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        // Try to create index with thread_count > merge_count (should fail)
    }
     * 1. Set cluster defaults: thread_count=13, merge_count=18
            .setTransientSettings(
        assertEquals(20, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        assertEquals(60, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        IndexService indexService = getIndexService(indicesService, index);
        ensureYellowAndNoInitializingShards(indexName);
            .prepareUpdateSettings()
        assertEquals(8, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
            .prepareUpdateSettings()
     * </pre>
        createIndex(
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
     * 4. Result: Both fall back to cluster defaults (thread_count=60, merge_count=80)
        String uuidWith = getIndexResponse.getSettings().get(indexWithSettings).get(IndexMetadata.SETTING_INDEX_UUID);
        client(clusterManagerName).admin()
        int expectedThreadCount = 3;
            .actionGet();
            .cluster()
    public void testIndexLevelMergeCountOnly() throws Exception {
        assertEquals(true, secondIndexService.getIndexSettings().getMergeSchedulerConfig().isAutoThrottle());
 *     <td>Nothing set</td>
        int expectedMergeCount = expectedThreadCount + 5;
        assertEquals(expectedThreadCount, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        int expectedThreadCount = 3;
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
        ClusterSettings clusterSettings = indicesService.clusterService().getClusterSettings();
                Settings.builder().put(CLUSTER_MAX_THREAD_COUNT_SETTING.getKey(), 99).put(CLUSTER_MAX_MERGE_COUNT_SETTING.getKey(), 100)
 *   </tr>
import java.util.Random;
package org.opensearch.index;
        assertEquals(150, thirdIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
            .prepareUpdateSettings()
 * Licensed to Elasticsearch under one or more contributor
    public void testClusterDefaults() throws Exception {
        // Remove thread_count setting
        builder.execute().actionGet();
        // Deleting CLUSTER_MAX_THREAD_COUNT_SETTING, and asserting this does not affect CLUSTER_MAX_MERGE_COUNT_SETTING
        assertEquals("80", clusterSettings.get(CLUSTER_MAX_MERGE_COUNT_SETTING).toString());
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
        // Create index with index level override in settings
        // Set cluster defaults
        builder.setSettings(Settings.builder().put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), 27).build());
        assertEquals(20, indexServiceWithout.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
 *     <td>Both set</td>
        assertEquals(false, secondIndexService.getIndexSettings().getMergeSchedulerConfig().isAutoThrottle());
            indexName,
        assertEquals(10, indexServiceWithout.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
 * SPDX-License-Identifier: Apache-2.0
    }
        ensureYellowAndNoInitializingShards(indexName);
        String indexName = "log-myindex-5";
            .prepareUpdateSettings()
     * 2. Create index with no explicit settings
            .indices()
        assertEquals(20, secondIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
            .actionGet();
 * under the License.
            .prepareUpdateSettings()
    @Before
        IndexService indexServiceWithout = indicesService.indexService(new Index(indexWithoutSettings, uuidWithout));
 *     <td>thread_count = your value<br/>merge_count = your value + 5</td>
            .setTransientSettings(Settings.builder().putNull(CLUSTER_MAX_MERGE_COUNT_SETTING.getKey()))
 * license agreements. See the NOTICE file distributed with
