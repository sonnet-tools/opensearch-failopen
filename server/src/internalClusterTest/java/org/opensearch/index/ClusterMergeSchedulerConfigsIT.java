}
     * 4. Result: Both fall back to cluster defaults because merge_count wasn't explicitly set  
            .setSettings(Settings.builder().putNull(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey()))
    }  
        assertEquals(60, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
 *   </tr>  
     * Expected behavior: Both values are used as-is (assuming they're valid).  
 *     <td>{@code testRemoveOnlyExplicitSetting()}</td>
    }  
    public void testClusterDefaults() throws Exception {  
 *     <td>{@code testRemoveOneOfTwoSettings()}</td>
        assertEquals(3, thirdIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
     * Tests that cluster defaults override absolute defaults when set.  
        IndexService indexService = getIndexService(indicesService, index);
        ensureGreen(indexName);
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);  
        assertTrue(exception.getMessage().contains("maxThreadCount (= 10) should be <= maxMergeCount (= 5)"));
 *   </tr>  
                .put(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey(), 6)
        client(clusterManagerName).admin()
import java.util.ArrayList;
                Settings.builder().put(CLUSTER_MAX_MERGE_COUNT_SETTING.getKey(), 80).put(CLUSTER_MAX_THREAD_COUNT_SETTING.getKey(), 60)
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
            indexWithSettings,  
        String indexName = "test-remove-one-of-two-1";  
        String indexName = "test-existing-index";  
            .setTransientSettings(
     * <p>  
            .get();  
        assertBusy(() -> assertNotNull("IndexService should not be null", indicesService.indexService(index)), 120, TimeUnit.SECONDS);
        // thread_count should stay at index-level setting
     * 3. Existing index should immediately pick up cluster defaults
     * Expected behavior:
        assertEquals(20, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        int expectedThreadCount = 3;
            .setSettings(Settings.builder().put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), 100))
        assertEquals(15, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());  
        String indexName = "test-absolute-defaults";
        // Both should fall back to cluster defaults  
    private IndexService getIndexService(IndicesService indicesService, Index index) throws Exception {
        IllegalArgumentException exception = expectThrows(
            .get();  
            .get();
    }
        Index index = new Index(indexName, uuid);
        Index index = new Index(indexName, uuid);
        ensureGreen(indexName);
 *   </tr>  
        assertEquals(3, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());  
     * <pre>  
        assertEquals("3", clusterSettings.get(CLUSTER_MAX_THREAD_COUNT_SETTING).toString());  
        assertEquals("200", clusterSettings.get(CLUSTER_MAX_MERGE_COUNT_SETTING).toString());
        IndexService indexService = getIndexService(indicesService, index);
        ensureGreen(indexName);
        assertEquals("80", clusterSettings.get(CLUSTER_MAX_MERGE_COUNT_SETTING).toString());
 *   </tr>  
        assertEquals(false, secondIndexService.getIndexSettings().getMergeSchedulerConfig().isAutoThrottle());  
        assertEquals(8, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
            .cluster()  
                    .put(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey(), 10)
 *     <td>Doesn't matter</td>  
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
                    .put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), 5)
        String indexName = "test-invalid-config";
        IndexService secondIndexService = getIndexService(indicesService, new Index(indexName, uuid));  
        ensureGreen(indexName);  
     * </pre>  
                .put(indexSettings())
        assertEquals(35, secondIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());  
import org.junit.Before;
        assertEquals(15, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());  
        int expectedMergeCount = expectedThreadCount + 5;
        Index index = new Index(indexName, uuid);
        client(clusterManagerName).admin()  
        assertEquals(20, secondIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());  
                Settings.builder().put(CLUSTER_MAX_THREAD_COUNT_SETTING.getKey(), 10).put(CLUSTER_MAX_MERGE_COUNT_SETTING.getKey(), 20)
            .cluster()
        builder.execute().actionGet();  
        assertEquals(80, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
            .prepareUpdateSettings()
            .actionGet();
     * <p>  
            .actionGet();
    /**  
                .build()
    public void testRemoveOneOfTwoSettings() throws Exception {
        client(clusterManagerName).admin()  
                .build()
        ensureYellowAndNoInitializingShards(indexName);
        assertEquals(expectedMergeCount, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());  
                    .put(indexSettings())  
        // Remove thread_count setting
     * 3. Remove thread_count
     * Result:
        assertEquals(100, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        // Deleting CLUSTER_MAX_THREAD_COUNT_SETTING, and asserting this does not affect CLUSTER_MAX_MERGE_COUNT_SETTING
        return s.build();  
    public void testClusterMergeConfigs() throws Exception {
 */  
        assertEquals(20, secondIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());  
    /**
        // Set cluster defaults  
     * Tests that cluster defaults apply to indices created BEFORE the cluster setting was set.
        ensureGreen(indexName);
        assertEquals(35, secondIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
            .prepareUpdateSettings()
        builder.setSettings(Settings.builder().put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), 100).build());
     */
 * <h2>Complete Decision Matrix</h2>
        assertEquals("60", clusterSettings.get(CLUSTER_MAX_THREAD_COUNT_SETTING).toString());
     * <pre>
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put(NODE_PROCESSORS_SETTING.getKey(), 6).build();
        String indexName = "test-remove-only-explicit";
        client(clusterManagerName).admin()  
            )  
        client().admin()  
        assertEquals(20, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
 *     <td>Had 2, removed 1</td>
        assertEquals(60, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());  
                .put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), 12)
        assertEquals(35, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
            )  
            .execute()
        assertEquals(30, indexServiceWithout.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());  
    /**  
        );
        assertEquals(60, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());  
import org.opensearch.action.admin.indices.get.GetIndexRequest;
        ensureYellowAndNoInitializingShards(indexName);
        uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
     */
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
        createIndex(
        return indicesService.indexService(index);
     * 1. Set cluster defaults: thread_count=60, merge_count=80  
        createIndex(indexName, indexSettings());  
        // thread_count should fall back to absolute default, NOT cluster default of 3  
        assertEquals(false, thirdIndexService.getIndexSettings().getMergeSchedulerConfig().isAutoThrottle());
        IndexService indexService = getIndexService(indicesService, index);
        assertEquals(5, indexServiceWith.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        String clusterManagerName = internalCluster().getClusterManagerName();  
        // We wait for the index to become available on the node.  
 *     <td>Only thread count set</td>
        // and no change in settings' values  
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);  
        assertEquals((60 + 5), indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        assertEquals("200", clusterSettings.get(CLUSTER_MAX_MERGE_COUNT_SETTING).toString());
 *   <tr>
     * The golden rule: {@code MAX_THREAD_COUNT must always be <= MAX_MERGE_COUNT}  
    }
 *     <td>{@code testRemoveAllSettings()}</td>
        assertEquals(35, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
            indexName,  
 *     <td>{@code testIndexLevelThreadCountOnly()}</td>
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
 *     <td>Both → cluster defaults</td>
 *   <tr>
                .cluster()
        assertEquals(11, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount()); // 6 + 5  
            .cluster()
 *     <td>{@code testIndexLevelMergeCountOnly()}</td>
        // Set only merge_count at index level  
        ensureYellowAndNoInitializingShards(indexName);  
        assertEquals(true, indexService.getIndexSettings().getMergeSchedulerConfig().isAutoThrottle());
     * </pre>  
        String uuidWith = getIndexResponse.getSettings().get(indexWithSettings).get(IndexMetadata.SETTING_INDEX_UUID);
     * <p>
     * 4. Result: Both fall back to cluster defaults (thread_count=60, merge_count=80)
     * Tests removing the ONLY explicit index setting (the other was auto-calculated).
            .cluster()
        IndexService thirdIndexService = getIndexService(indicesService, new Index(indexName, uuid));  
     * <p>
     * 1. Create index (uses absolute defaults)  
        assertEquals("100", clusterSettings.get(CLUSTER_MAX_THREAD_COUNT_SETTING).toString());  
            indexName,  
            )
                .build()
            .setTransientSettings(  
        String clusterManagerName = internalCluster().getClusterManagerName();  
        String indexName = "test-merge-count-only";  
        UpdateSettingsRequestBuilder builder = client().admin().indices().prepareUpdateSettings(indexName);
        ensureGreen(indexName);  
        assertEquals(35, secondIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());  
        assertEquals(8, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        assertEquals(20, indexServiceWithout.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());  
        );
        String clusterManagerName = internalCluster().getClusterManagerName();
        assertEquals(6, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());  
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();  
        assertEquals(3, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        assertEquals(100, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());  
        String indexName = "test-remove-all";  
            IllegalArgumentException.class,
     * Tests setting only MAX_MERGE_COUNT at index level.
        createIndex(indexWithoutSettings, indexSettings());
        assertEquals("65", clusterSettings.get(CLUSTER_MAX_MERGE_COUNT_SETTING).toString());
                .put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), 15)  
        // try to update with an invalid setting  
        builder.setSettings(Settings.builder().put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), 27).build());
        assertEquals(20, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        assertEquals(35, thirdIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
 * </table>
        IndexService indexService = getIndexService(indicesService, new Index(indexName, uuid));
            .indices()
            .cluster()
        createIndex(indexName, indexSettings());
     * 1. Set cluster defaults: thread_count=60, merge_count=80
            Settings.builder()
     **/
        assertEquals(expectedThreadCount, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
/**  
        assertEquals(60, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
    }  
        String clusterManagerName = internalCluster().getClusterManagerName();
    public void testFullLifecycle() throws Exception {
    protected Settings.Builder setRandomIndexMergeSettings(Random random, Settings.Builder builder) {
        ensureYellowAndNoInitializingShards(indexWithoutSettings);  
            .setTransientSettings(Settings.builder().put(CLUSTER_AUTO_THROTTLE_SETTING.getKey(), false))  
                .put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), 15)  
        assertEquals(15, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        builder.execute().actionGet();  
        String indexWithSettings = "test-with-settings";
        // merge_count should be 100, thread_count falls back to absolute default
     * Tests that updating cluster defaults affects all indices without explicit settings.  
            .prepareUpdateSettings()  
                .setTransientSettings(Settings.builder().put(CLUSTER_MAX_THREAD_COUNT_SETTING.getKey(), 100))  
     * <pre>
     * Result:  
        uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);  
                Settings.builder().put(CLUSTER_MAX_THREAD_COUNT_SETTING.getKey(), 60).put(CLUSTER_MAX_MERGE_COUNT_SETTING.getKey(), 80)
     * 2. Create index with both settings: thread_count=6, merge_count=15  
        String clusterManagerName = internalCluster().getClusterManagerName();
            .cluster()
        ensureGreen(indexName);
                Settings.builder().put(CLUSTER_MAX_THREAD_COUNT_SETTING.getKey(), 99).put(CLUSTER_MAX_MERGE_COUNT_SETTING.getKey(), 100)
     * </pre>
            .setTransientSettings(Settings.builder().put(CLUSTER_MAX_MERGE_COUNT_SETTING.getKey(), 200))  
            )
            .get();
        // Set cluster defaults to verify they're NOT used for thread_count  
        IndexService indexService = getIndexService(indicesService, new Index(indexName, uuid));  
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();  
        getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
        Index index = new Index(indexName, uuid);  
            Settings.builder().put(indexSettings()).put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), 15).build()  
        assertEquals(20, secondIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());  
            Settings.builder()
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));  
    }  
        assertEquals(20, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
 *    http://www.apache.org/licenses/LICENSE-2.0
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            .get();
                .put(indexSettings())
                .put(indexSettings())
        String clusterManagerName = internalCluster().getClusterManagerName();
     * 4. Result: thread_count falls back to ABSOLUTE default (not cluster default of 3)
     * <p>
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());  
     */
import org.opensearch.test.OpenSearchIntegTestCase;
        assertEquals("60", clusterSettings.get(CLUSTER_MAX_THREAD_COUNT_SETTING).toString());  
public class ClusterMergeSchedulerConfigsIT extends OpenSearchIntegTestCase {
        internalCluster().startClusterManagerOnlyNode();  
        int expectedThreadCount = 3;
        assertEquals(12, indexServiceWith.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        assertEquals(25, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        String indexName = "test-cluster-defaults";
        String clusterManagerName = internalCluster().getClusterManagerName();  
        client(clusterManagerName).admin()
     * Expected behavior:  
        getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();  
        indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
            .prepareUpdateSettings()
import org.opensearch.core.index.Index;
        Index index = new Index(indexName, uuid);
        int expectedThreadCount = 3;  
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
        builder = client().admin().indices().prepareUpdateSettings("log-myindex-2");
        Settings.Builder s = Settings.builder()
 *     <th>Cluster Defaults Exist?</th>  
        IndexService indexService = getIndexService(indicesService, index);
            )  
        assertEquals(80, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
            .setTransientSettings(Settings.builder().put(CLUSTER_MAX_MERGE_COUNT_SETTING.getKey(), 35))
        indexName = "test-remove-one-of-two-2";
 * <table border="1">
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
        client(clusterManagerName).admin()  
        client(clusterManagerName).admin()
 * Unless required by applicable law or agreed to in writing,
        assertEquals(15, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        assertEquals("100", clusterSettings.get(CLUSTER_MAX_THREAD_COUNT_SETTING).toString());  
        assertEquals(60, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        IndexService indexService = getIndexService(indicesService, index);  
import static org.opensearch.indices.ClusterMergeSchedulerConfig.CLUSTER_MAX_MERGE_COUNT_SETTING;  
        assertEquals(expectedThreadCount, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());  
        assertEquals(12, indexServiceWith.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
 *     <td>N/A</td>  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2);
        assertEquals("60", clusterSettings.get(CLUSTER_MAX_THREAD_COUNT_SETTING).toString());
        assertEquals(35, secondIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());  
 *     <td>Removed → absolute default<br/>Other → keeps index value</td>
     * <p>
        // Updating cluster defaults: CLUSTER_MAX_THREAD_COUNT_SETTING=60 and CLUSTER_MAX_MERGE_COUNT_SETTING=80  
 *     <td>Only merge count set</td>
        assertEquals("60", clusterSettings.get(CLUSTER_MAX_THREAD_COUNT_SETTING).toString());
        assertEquals(40, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
            .prepareUpdateSettings(indexName)
 *     <td>Nothing set</td>
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
            .get();
        // Create index with index level override in settings  
        ensureYellowAndNoInitializingShards(indexName);
     * 1. Set cluster defaults: thread_count=10, merge_count=20
        String clusterManagerName = internalCluster().getClusterManagerName();  
    }
                .put(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey(), 6)
package org.opensearch.index;
        ClusterSettings clusterSettings = indicesService.clusterService().getClusterSettings();
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
            .prepareUpdateSettings()
    }  
        assertEquals(27, thirdIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        String indexName = "log-myindex-1";  
    public Settings indexSettings() {
        // merge_count should stay at index-level setting
        int expectedMergeCount = 11; // MAX_THREAD_COUNT(=6) + 5
            indexName,
import org.opensearch.indices.IndicesService;  
        );  
     * Tests removing ONE of TWO explicit index settings.  
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
        ensureYellowAndNoInitializingShards(indexName);  
            .cluster()
        assertEquals(expectedThreadCount, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        String clusterManagerName = internalCluster().getClusterManagerName();
        builder = client().admin().indices().prepareUpdateSettings(indexName);
 *  
 *     <td>Cluster defaults</td>
        assertEquals(3, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());  
                Settings.builder().put(CLUSTER_MAX_THREAD_COUNT_SETTING.getKey(), 15).put(CLUSTER_MAX_MERGE_COUNT_SETTING.getKey(), 30)
        createIndex(
        client(clusterManagerName).admin()
        builder.setSettings(Settings.builder().putNull(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey()).build());
     * <pre>  
 *     <td>Both use your values (if valid)</td>
        assertEquals("80", clusterSettings.get(CLUSTER_MAX_MERGE_COUNT_SETTING).toString());
        // verify no change in settings post failure
 *     <th>Resulting Configuration</th>
            .setTransientSettings(
        client(clusterManagerName).admin()  
                indexName,
     *   thread_count = absolute default (NOT cluster default even if it exists)
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequestBuilder;  
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
     * MAX_THREAD_COUNT = max(1, min(4, cpuCores/2))
            .get();
        int expectedMergeCount = expectedThreadCount + 5;
            .prepareUpdateSettings()  
     * <pre>
        client(clusterManagerName).admin()
import org.opensearch.indices.ClusterMergeSchedulerConfig;
 *     <td>Had 2, removed both</td>
        assertEquals(6, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());  
     * <pre>  
        assertEquals(expectedThreadCount, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
 *     <td>No</td>  
                .put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), 15)
        return builder;  
            .indices()
        ensureYellowAndNoInitializingShards(indexName);  
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();  
     * Set: merge_count = 15
            .prepareUpdateSettings()
 *   <tr>
     */
 *   </tr>  
     * </pre>  
 *     <th>Test Method</th>
        assertEquals(80, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        createIndex(
        // adjusted accordingly (since its not already set)
        String indexName = "test-thread-count-only";
        // Index without explicit settings should update
/*  
        ensureYellowAndNoInitializingShards(indexName);
            .get();  
            .get();
import static org.opensearch.indices.ClusterMergeSchedulerConfig.CLUSTER_AUTO_THROTTLE_SETTING;
import java.util.concurrent.ExecutionException;
    /**
    public void testMergeSchedulerSettingsWithMultipleIndices() throws Exception {  
        int expectedThreadCount = 3;  
                .put(indexSettings())
        ensureYellowAndNoInitializingShards(indexWithSettings);
    public void testRemoveOnlyExplicitSetting() throws Exception {  
 * You may obtain a copy of the License at  
        // Now set cluster defaults  
    /**
                .build()
        assertEquals("105", clusterSettings.get(CLUSTER_MAX_MERGE_COUNT_SETTING).toString());
            indexName,
        assertEquals(80, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
            .get();
            .execute()
     * Tests setting only MAX_THREAD_COUNT at index level.  
        Index index = new Index(indexName, uuid);  
        ClusterSettings clusterSettings = indicesService.clusterService().getClusterSettings();  
        String clusterManagerName = internalCluster().getClusterManagerName();
import java.util.Random;  
    public void testIndexLevelMergeCountOnly() throws Exception {
        assertEquals("80", clusterSettings.get(CLUSTER_MAX_MERGE_COUNT_SETTING).toString());  
            .execute()  
        assertEquals(true, secondIndexService.getIndexSettings().getMergeSchedulerConfig().isAutoThrottle());  
        createIndex(indexName, indexSettings());
        // Verify using absolute defaults initially  
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();  
    }
 *   </tr>  
 *     <td>{@code testAbsoluteDefaults()}</td>
    public Settings nodeSettings(int nodeOrdinal) {
     * <p>
     */
            )
 */
        String indexName = "log-myindex-5";  
        client(clusterManagerName).admin()
 *     <td>Yes</td>  
 *   <tr>
        // Index with explicit settings should remain unchanged  
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
    }
            .setTransientSettings(
     *   merge_count = 11 (auto-calculated: 6 + 5)
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
        ensureGreen(indexName);
            .setTransientSettings(
     * </pre>
        assertEquals("60", clusterSettings.get(CLUSTER_MAX_THREAD_COUNT_SETTING).toString());  
     */
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
            .setSettings(Settings.builder().putNull(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey()))  
        builder.setSettings(Settings.builder().putNull(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey()).build());
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
 */
            .cluster()
 */  
        assertEquals(60, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());  
        assertEquals(40, secondIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());  
            .put(super.indexSettings())  
        assertEquals(expectedThreadCount, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals(expectedMergeCount, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
            .cluster()
        // Create index with explicit settings  
        super.setUp();
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();  
        assertEquals("80", clusterSettings.get(CLUSTER_MAX_MERGE_COUNT_SETTING).toString());
     * Set: thread_count = 6
            () -> client(clusterManagerName).admin()  
                Settings.builder()
 *     <td>Invalid combination</td>
    }  
        ClusterSettings clusterSettings = indicesService.clusterService().getClusterSettings();  
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();  
        client(clusterManagerName).admin()
        int expectedThreadCount = 3;
            .setTransientSettings(
        createIndex(indexName, indexSettings());
        assertEquals("60", clusterSettings.get(CLUSTER_MAX_THREAD_COUNT_SETTING).toString());
                .put(indexSettings())
 * The OpenSearch Contributors require contributions made to  
     * MAX_MERGE_COUNT = MAX_THREAD_COUNT + 5  
                    .putNull(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey())
     * 2. Set cluster defaults
        IndexService indexService = getIndexService(indicesService, index);
        // Set cluster defaults  
        // Existing index should immediately pick up cluster defaults  
import java.util.concurrent.TimeUnit;
        createIndex(  
            .get();
     *   merge_count = 15
            )  
        ClusterSettings clusterSettings = indicesService.clusterService().getClusterSettings();  
        String uuidWithout = getIndexResponse.getSettings().get(indexWithoutSettings).get(IndexMetadata.SETTING_INDEX_UUID);
 *   <tr>
        // now remove merge_count when both index level settings are present
 * compatible open source license.
            .indices()
        assertEquals(true, indexService.getIndexSettings().getMergeSchedulerConfig().isAutoThrottle());
        indexService = getIndexService(indicesService, index);
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);  
        assertEquals(expectedThreadCount, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
import org.opensearch.common.settings.Settings;  
 *     <td>Doesn't matter</td>  
    }
 *     <td>Rejected (thread_count > merge_count)</td>
 *     <td>Doesn't matter</td>  
 *     <td>{@code testIndexLevelBothSet()}</td>
        // Verify initial state
    public void testInvalidConfiguration() {  
                TieredMergePolicyProvider.INDEX_COMPOUND_FORMAT_SETTING.getKey(),
 * SPDX-License-Identifier: Apache-2.0
            .get();  
        ensureGreen(indexName);
        createIndex(indexName, indexSettings());
            )  
            )  
            .setTransientSettings(  
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
import org.opensearch.common.settings.ClusterSettings;
        builder.execute().actionGet();  
        indexName = "log-myindex-3";
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();  
    @Override  
            .prepareUpdateSettings()
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));  
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(35, thirdIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
     * Scenario:
            )  
        assertEquals(false, indexService.getIndexSettings().getMergeSchedulerConfig().isAutoThrottle());
 *   <tr>
     * Tests that invalid configurations (thread_count > merge_count) are rejected.
            .setSettings(Settings.builder().putNull(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey()))  
        createIndex(
        client(clusterManagerName).admin()
        assertEquals(20, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        UpdateSettingsRequestBuilder builder = client().admin().indices().prepareUpdateSettings(indexName);
        ensureGreen(indexName);  
        );
        assertEquals(5, indexServiceWith.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());  
    public void testAbsoluteDefaults() throws Exception {  
     * 3. Remove BOTH settings
     * Scenario:
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
     * Scenario:
            )
            .setTransientSettings(
     * This demonstrates the full lifecycle: cluster defaults → index override → removal → fallback.  
 * this work for additional information regarding copyright
        ClusterSettings clusterSettings = indicesService.clusterService().getClusterSettings();  
        createIndex(indexName, indexSettings());  
        client(clusterManagerName).admin()  
 *   </tr>  
            indexName,
        // Remove both settings  
                .build()
        createIndex(
 *     <td>thread_count = your value<br/>merge_count = your value + 5</td>
        ensureYellowAndNoInitializingShards(indexName);
    public void testClusterDefaultsApplyToExistingIndices() throws Exception {
 *
     *           merge_count stays at 15
     * Scenario:  
                .put(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey(), 6)  
            .setTransientSettings(  
     * Tests setting both MAX_THREAD_COUNT and MAX_MERGE_COUNT at index level.
        // Index should immediately pick up cluster defaults  
        IndexService indexServiceWith = indicesService.indexService(new Index(indexWithSettings, uuidWith));  
            .execute()
        builder = client().admin().indices().prepareUpdateSettings(indexName);
        assertEquals(200, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());  
        assertEquals(expectedThreadCount, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        assertEquals(100, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
            .cluster()  
     * 4. Index without explicit settings should use new cluster defaults
        createIndex(indexName, indexSettings());
                    .build()  
     * Scenario:
        assertEquals(3, thirdIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());  
        String clusterManagerName = internalCluster().getClusterManagerName();  
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> finalBuilder.execute().actionGet());
                    .putNull(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey())  
 *     <td>merge_count = your value<br/>thread_count = absolute default</td>
        String indexName = "test-both-set";  
import static org.opensearch.indices.ClusterMergeSchedulerConfig.CLUSTER_MAX_THREAD_COUNT_SETTING;
        ensureYellowAndNoInitializingShards(indexName);  
import org.opensearch.action.admin.indices.get.GetIndexResponse;
        Index index = new Index(indexName, uuid);
            Settings.builder().put(indexSettings()).put(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey(), 6).build()
        // Verify initial state
 * Licensed to Elasticsearch under one or more contributor  
            .prepareUpdateSettings()  
                .put(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey(), 8)
            builder.put(  
        int expectedMergeCount = expectedThreadCount + 5;
 *     <td>Nothing set</td>
        ensureYellowAndNoInitializingShards(indexName);
        // Verify initial state
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());  
 * Modifications Copyright OpenSearch Contributors. See
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
        IndexService indexService = getIndexService(indicesService, index);  
            );  
        indexName = "log-myindex-2";
        assertEquals(15, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());  
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
 * under the License.  
                Settings.builder().put(CLUSTER_MAX_MERGE_COUNT_SETTING.getKey(), 80).put(CLUSTER_MAX_THREAD_COUNT_SETTING.getKey(), 60)
        assertEquals("60", clusterSettings.get(CLUSTER_MAX_THREAD_COUNT_SETTING).toString());  
     * Expected behavior:  
    }
        }
        ensureGreen(indexName);
     * </pre>  
            .cluster()
        assertEquals(60, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());  
import static org.opensearch.common.util.concurrent.OpenSearchExecutors.NODE_PROCESSORS_SETTING;
        assertEquals("60", clusterSettings.get(CLUSTER_MAX_THREAD_COUNT_SETTING).toString());
 *
     */
            .cluster()
     * 1. Set cluster defaults: thread_count=13, merge_count=18
 *   </tr>  
            .cluster()
        IllegalArgumentException exception = assertThrows(
 * specific language governing permissions and limitations
     * <p>
            .cluster()
        ensureGreen(indexName);  
        assertEquals(true, indexService.getIndexSettings().getMergeSchedulerConfig().isAutoThrottle());
                Settings.builder().put(CLUSTER_MAX_THREAD_COUNT_SETTING.getKey(), 10).put(CLUSTER_MAX_MERGE_COUNT_SETTING.getKey(), 20)  
        client(clusterManagerName).admin()  
        ensureGreen(indexWithoutSettings);
        builder.execute().actionGet();  
        assertEquals(80, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        createIndex(indexName, indexSettings());
        );
            .prepareUpdateSettings()  
    /**
        assertEquals(6, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        // Remove thread_count setting
            IllegalArgumentException.class,
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
     * 1. Set cluster defaults: thread_count=10, merge_count=20
        index = new Index(indexName, uuid);
        );
        // updating CLUSTER_MAX_THREAD_COUNT_SETTING to 100 and expecting CLUSTER_MAX_MERGE_COUNT_SETTING to get
            .setTransientSettings(Settings.builder().putNull(CLUSTER_MAX_THREAD_COUNT_SETTING.getKey()))  
     * 3. Index should use cluster defaults  
            .cluster()
        );  
                .put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), 20)  
        assertEquals(8, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
import org.opensearch.cluster.metadata.IndexMetadata;
        // Both should fall back to cluster defaults
            )
    public void testRemoveAllSettings() throws Exception {
        assertEquals(expectedMergeCount, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());  
        assertEquals(150, thirdIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
                .put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), 150)  
 *     <td>Had 1, removed it</td>
                (random.nextBoolean() ? random.nextDouble() : random.nextBoolean()).toString()
                .get()
        IndexService indexService = getIndexService(indicesService, index);
                .put(indexSettings())
        // merge_count should fall back to absolute default, NOT cluster default  
        ensureGreen(indexWithSettings);
     * </pre>
        assertEquals("10", clusterSettings.get(CLUSTER_MAX_THREAD_COUNT_SETTING).toString());
     * </pre>  
 * How this is supposed to work -
            Settings.builder()  
        assertEquals(10, indexServiceWithout.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
/*
            indexName,
        Index index = new Index(indexName, uuid);  
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
     * 2. Create index with only thread_count=6 (merge_count auto-calculates to 11)
    public void testIndexLevelBothSet() throws Exception {
        assertEquals("60", clusterSettings.get(CLUSTER_MAX_THREAD_COUNT_SETTING).toString());
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
 * KIND, either express or implied.  See the License for the
        );  
            indexName,
    /**
        String clusterManagerName = internalCluster().getClusterManagerName();  
 *   </tr>  
        if (random.nextBoolean()) {
     */
        assertEquals(20, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());  
        ensureYellowAndNoInitializingShards(indexName);  
        // Updating cluster defaults: CLUSTER_MAX_THREAD_COUNT_SETTING=60 and CLUSTER_MAX_MERGE_COUNT_SETTING=80
        assertEquals(35, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        // Remove the only explicit setting (merge_count)  
            .prepareUpdateSettings(indexName)
            .prepareUpdateSettings(indexName)  
            Settings.builder()  
        IndexService indexServiceWithout = indicesService.indexService(new Index(indexWithoutSettings, uuidWithout));  
        builder.execute().actionGet();  
     */
        ensureYellowAndNoInitializingShards(indexName);
            .prepareUpdateSettings()
            .get();
                .prepareUpdateSettings()
            .setTransientSettings(
    }
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));  
        assertEquals(80, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());  
 *  
            Settings.builder()
                .build()
 *     <th>Index Settings State</th>
import java.util.List;
        assertEquals("80", clusterSettings.get(CLUSTER_MAX_MERGE_COUNT_SETTING).toString());
            .indices()
            .prepareUpdateSettings()
        assertEquals(35, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
 * Integration tests for {@link ClusterMergeSchedulerConfig} and merge scheduler settings hierarchy.
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);  
 * the Apache License, Version 2.0 (the "License"); you may
        // Try to create index with thread_count > merge_count (should fail)  
            .prepareUpdateSettings()  
 *     <td>Yes</td>  
        assertEquals(20, secondIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
            .prepareUpdateSettings()  
     * 2. Create index with both settings: thread_count=6, merge_count=15
        client().admin()
        Index index = new Index(indexName, uuid);  
 * software distributed under the License is distributed on an
     * Scenario:
    }
            .get();
            .cluster()
            .execute()
        int replicas = randomIntBetween(1, Math.max(1, internalCluster().numDataNodes() - 1));
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(true, thirdIndexService.getIndexSettings().getMergeSchedulerConfig().isAutoThrottle());
 * not use this file except in compliance with the License.
            .get();
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
        assertEquals(6, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2)  
     * 3. Remove thread_count  
        uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
            .cluster()
        assertEquals(80, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());  
        assertEquals(12, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        assertEquals(20, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        // Set cluster defaults
        String clusterManagerName = internalCluster().getClusterManagerName();  
        assertEquals(20, secondIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());  
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
 *     <td>Doesn't matter</td>  
        assertEquals(6, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
    public void setUp() throws Exception {
            .indices()
        assertEquals(100, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
    /**  
        assertEquals(true, secondIndexService.getIndexSettings().getMergeSchedulerConfig().isAutoThrottle());  
        // Set initial cluster defaults  
            .setTransientSettings(
        Index index = new Index(indexName, uuid);
            .actionGet();
     */
            .get();
        assertEquals(40, secondIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
    }
        assertEquals(true, indexService.getIndexSettings().getMergeSchedulerConfig().isAutoThrottle());  
        assertTrue(exception.getMessage().contains("maxThreadCount (= 3) should be <= maxMergeCount (= 1)"));
        // updating CLUSTER_MAX_MERGE_COUNT_SETTING to 200
    @Override
            () -> createIndex(  
 *     <td>Both → cluster defaults</td>
     * </p>
        client().admin()
        assertEquals(expectedThreadCount, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());  
        createIndex(
        // update index level setting to override cluster level default  
    @Override  
        getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();  
 *   <tr>
            .get();
            .setTransientSettings(Settings.builder().putNull(CLUSTER_MAX_MERGE_COUNT_SETTING.getKey()))
        String indexWithoutSettings = "test-without-settings";
    }
        // Set cluster defaults  
        assertEquals(expectedMergeCount, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        assertEquals(60, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
            .setTransientSettings(Settings.builder().put(CLUSTER_MAX_THREAD_COUNT_SETTING.getKey(), 100))  
                .put(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey(), 5)  
        createIndex(
            .actionGet();  
     * <pre>
            Settings.builder()  
        ensureGreen(indexName);
 *     <td>Absolute defaults (CPU-based)</td>
        assertEquals(200, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());  
        IndexService indexService = getIndexService(indicesService, index);
        // Update cluster defaults
 *     <td>Yes</td>  
                Settings.builder().put(CLUSTER_MAX_THREAD_COUNT_SETTING.getKey(), 12).put(CLUSTER_MAX_MERGE_COUNT_SETTING.getKey(), 25)
    /**  
 *     <td>{@code testInvalidConfiguration()}</td>
        UpdateSettingsRequestBuilder finalBuilder = builder;  
 *   <tr>
 *   <tr>
            .setSettings(
    }  
        assertEquals("80", clusterSettings.get(CLUSTER_MAX_MERGE_COUNT_SETTING).toString());
        assertEquals(15, indexServiceWithout.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
                Settings.builder().put(CLUSTER_MAX_THREAD_COUNT_SETTING.getKey(), 13).put(CLUSTER_MAX_MERGE_COUNT_SETTING.getKey(), 18)
    @Before  
        ensureGreen(indexName);
        // changing cluster level default should only affect indices without index level override  
        ensureYellowAndNoInitializingShards(indexName);
    /**  
     * Tests removing BOTH explicit index settings (when both were set).
 *   <caption>Settings hierarchy and fallback behavior for merge scheduler configuration</caption>  
            )
        );
     */  
 * license agreements. See the NOTICE file distributed with
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);  
        assertEquals(false, indexService.getIndexSettings().getMergeSchedulerConfig().isAutoThrottle());
     * <p>
        // Create index without explicit settings  
    /**
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
        indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
        client().admin()
        assertEquals(true, indexService.getIndexSettings().getMergeSchedulerConfig().isAutoThrottle());
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
        // Verify initial state
     *   thread_count = 6  
        // updating cluster level auto_throttle to false
     * <pre>
        );  
    /**
     * </pre>
 * GitHub history for details.
        client(clusterManagerName).admin()
        assertEquals("20", clusterSettings.get(CLUSTER_MAX_MERGE_COUNT_SETTING).toString());
        assertEquals(3, thirdIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        assertEquals(40, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
     * <p>
     * <p>
            .prepareUpdateSettings()  
        assertEquals(20, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        assertTrue(exception.getMessage().contains("maxThreadCount (= 100) should be <= maxMergeCount (= 80)"));  
        assertEquals(expectedMergeCount, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
        // setting auto throttle back to true for one index  
        // Removing CLUSTER_MAX_MERGE_COUNT_SETTING and asserting it gets adjusted according to CLUSTER_MAX_THREAD_COUNT_SETTING
     * Tests that absolute defaults are calculated correctly when no cluster or index settings exist.
     * 3. Update cluster defaults: thread_count=15, merge_count=30  
        assertEquals(105, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());  
     * 2. Create index with no explicit settings
            .prepareUpdateSettings(indexName)  
                Settings.builder().put(CLUSTER_MAX_MERGE_COUNT_SETTING.getKey(), 40).put(CLUSTER_MAX_THREAD_COUNT_SETTING.getKey(), 20)
     * <pre>  
            .prepareUpdateSettings(indexName)  
     * 5. Index with explicit settings should remain unchanged
 *     <td>{@code testClusterDefaults()}</td>
    @Override  
                Settings.builder().put(CLUSTER_MAX_MERGE_COUNT_SETTING.getKey(), 80).put(CLUSTER_MAX_THREAD_COUNT_SETTING.getKey(), 60)
        builder = client().admin().indices().prepareUpdateSettings(indexName);
        assertEquals(150, thirdIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());  
                Settings.builder()
        assertEquals(20, thirdIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
 *     <td>Both set</td>
    public void testClusterDefaultUpdate() throws ExecutionException, InterruptedException {
        builder.setSettings(Settings.builder().put(MergeSchedulerConfig.AUTO_THROTTLE_SETTING.getKey(), "true").build());
        assertEquals(true, secondIndexService.getIndexSettings().getMergeSchedulerConfig().isAutoThrottle());  
            .prepareUpdateSettings()
        ensureYellowAndNoInitializingShards(indexName);
        builder.setSettings(Settings.builder().put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), 1).build());
        // removing index level override should pick up the cluster level default  
        assertEquals(false, thirdIndexService.getIndexSettings().getMergeSchedulerConfig().isAutoThrottle());
        IndexService indexService = getIndexService(indicesService, index);
        client(clusterManagerName).admin()
        assertEquals(20, thirdIndexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());
        // Updating cluster defaults: CLUSTER_MAX_THREAD_COUNT_SETTING=100, expecting failure for failed validation
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
            .prepareUpdateSettings()  
        assertEquals(20, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxMergeCount());
    public void testIndexLevelThreadCountOnly() throws Exception {
        client().admin()  
            .actionGet();  
        String indexName = "log-myindex-1";
 *   </tr>  
        int expectedMergeCount = expectedThreadCount + 5;
        int expectedThreadCount = 3;
        ensureGreen(indexName);
     * 2. Create two indices: one with explicit settings, one without
/*  
        ensureYellowAndNoInitializingShards(indexName);  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, replicas)
    }  
        assertEquals(10, indexService.getIndexSettings().getMergeSchedulerConfig().getMaxThreadCount());  
        assertEquals("80", clusterSettings.get(CLUSTER_MAX_MERGE_COUNT_SETTING).toString());
        assertEquals("80", clusterSettings.get(CLUSTER_MAX_MERGE_COUNT_SETTING).toString());
 *   <tr>
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
