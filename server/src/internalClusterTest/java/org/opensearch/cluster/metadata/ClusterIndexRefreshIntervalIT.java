import org.opensearch.index.IndexSettings;  
            .actionGet();
                    .putNull(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey())
        // Update the cluster.minimum.index.refresh_interval setting to a valid value higher the custom refresh interval.
                Settings.builder()  
            .indices()
import org.opensearch.action.admin.indices.get.GetIndexResponse;
        client(clusterManagerName).admin()
            )  
            .get();  
                + "] more than cluster default index refresh interval ["  
            .setTransientSettings(
    public void testClusterMinimumRefreshIntervalOfZero() {  
                )
            IllegalArgumentException.class,
 * software distributed under the License is distributed on an
        ensureGreen(INDEX_NAME);
            .setTransientSettings(Settings.builder().put(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), refreshInterval))
            .prepareUpdateSettings()
        String uuid = getIndexResponse.getSettings().get(INDEX_NAME).get(IndexMetadata.SETTING_INDEX_UUID);
        assertEquals(TimeValue.timeValueSeconds(2), indexService.getRefreshTaskInterval());  
        // Update the cluster.minimum.index.refresh_interval setting to a valid value, this will succeed.  
 *    http://www.apache.org/licenses/LICENSE-2.0
        // to a valid value as well to be deterministic in test behaviour.  
import java.util.ArrayList;  
        TimeValue validMinimumRefreshInterval = TimeValue.timeValueMillis(refreshInterval.millis() - randomIntBetween(1, 1000));
        client(clusterManagerName).admin()  
            .indices()
    public void testClusterMinimumChangeOnIndexWithCustomRefreshInterval() throws ExecutionException, InterruptedException {
            .setTransientSettings(Settings.builder().put(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), randomFrom("-1", "-1ms")))
        super.setUp();
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();  
        client(clusterManagerName).admin()
            )  
                new UpdateSettingsRequest(INDEX_NAME).settings(
        indexService = getIndexServiceFromRandomDataNode(OTHER_INDEX_NAME);
        ensureGreen(INDEX_NAME);
    /**  
        assertEquals(  
            .get();
            )
        // Update of cluster.minimum.index.refresh_interval setting to value more than default refreshInterval above will fail  
            ex.getMessage()
                + "] as a time value: negative durations are not supported",  
        // minimum is set to. -1 corresponds to no period background refreshes.  
            .cluster()
            .setTransientSettings(
 * license agreements. See the NOTICE file distributed with
 */  
            Settings.builder() // <1>
        String otherUuid = getIndexResponse.getSettings().get(INDEX_NAME).get(IndexMetadata.SETTING_INDEX_UUID);
            () -> createIndex(OTHER_INDEX_NAME, indexSettings)
            .indices()
        Settings settings = Settings.builder()
    }  
            .put(indexSettings())
        String uuid = getIndexResponse.getSettings().get(INDEX_NAME).get(IndexMetadata.SETTING_INDEX_UUID);  
                new UpdateSettingsRequest(INDEX_NAME).settings(
        assertEquals(expectedMessage, exceptionDuringCreateIndex.getMessage());
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());  
                + invalidMinimumRefreshInterval
            + "]";
            .prepareUpdateSettings()
            .put(indexSettings())  
        assertEquals(-1, indexService.getRefreshTaskInterval().millis());
            .actionGet();
        // At the same time, due to certain degree of randomness in the test, we update the cluster.default.refresh_interval
    }  
            .get();  
import org.opensearch.snapshots.AbstractSnapshotIntegTestCase;
                new UpdateSettingsRequest(INDEX_NAME).settings(
        createIndex(indexName);
        // Try to create another index with valid index setting index.refresh_interval, this will pass.
            .getIndex(new GetIndexRequest())
        IllegalArgumentException ex = assertThrows(
                        Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), invalidRefreshInterval)  
                + "]",
        GetIndexResponse getIndexResponse = client(internalCluster().getClusterManagerName()).admin()  
        IndexService indexService = getIndexServiceFromRandomDataNode(INDEX_NAME);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .cluster()  
            )  
            .get();
        );  
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
    @Override
            .put(indexSettings())
            .actionGet();  
            exceptionDuringMinUpdate.getMessage()  
            .get();  
    }  
    public void testUpdateIndexWithMinusOneRefreshInterval() throws ExecutionException, InterruptedException {
        customRefreshInterval = TimeValue.timeValueSeconds(clusterMinimum.getSeconds() + randomIntBetween(1, 5));  
        IndexService indexService = indicesService.indexService(new Index(INDEX_NAME, uuid));  
        assertEquals(-1, indexService.getRefreshTaskInterval().millis());  
        createIndex(INDEX_NAME);  
            .indices()  
        );
 *  
import org.junit.Before;
        assertEquals(-1, indexService.getRefreshTaskInterval().millis());
            .indices()
        String clusterManagerName = internalCluster().getClusterManagerName();  
     * the index setting. The underlying index should continue to use the same refresh interval as earlier.  
/*  
                + refreshInterval
            "failed to parse value [" + refreshInterval + "] for setting [cluster.minimum.index.refresh_interval], must be >= [0ms]",
                .get()
    public void testDefaultRefreshIntervalWithUpdateClusterAndIndexSettings() throws Exception {  
        Settings indexSettings = Settings.builder()
    public void testInvalidRefreshInterval() {
    }
                new UpdateSettingsRequest(INDEX_NAME).settings(
        // This test checks that we are able to create index with -1 refresh interval using index settings and default interval both.
        IllegalArgumentException exceptionDuringCreateIndex = assertThrows(  
            .updateSettings(
            .setTransientSettings(
                    Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), randomFrom("-1", "-1ms"))  
                )
 *
import org.opensearch.action.admin.indices.template.put.PutIndexTemplateRequest;
                )  
    }
                .cluster()
import org.opensearch.test.OpenSearchIntegTestCase;  
            .indices()
 * ownership. Elasticsearch licenses this file to you under  
import java.util.List;
            .build();
        String clusterManagerName = internalCluster().getClusterManagerName();
        assertEquals(100, indexService.getRefreshTaskInterval().seconds());
            .get();
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            OTHER_INDEX_NAME,  
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), invalidRefreshInterval)  
                .indices()  
        return IndexSettings.DEFAULT_REFRESH_INTERVAL;
    public void testIndexTemplateCreationSucceedsWhenNoMinimumRefreshInterval() throws ExecutionException, InterruptedException {
        String clusterManagerName = internalCluster().getClusterManagerName();
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
            .build();
        );  
        Settings indexSettings = Settings.builder()
        assertEquals(expectedMessage, exceptionDuringUpdateSettings.getMessage());
    }
 * compatible open source license.
            .updateSettings(
            "cluster minimum index refresh interval ["
        createIndex(INDEX_NAME, indexSettings);
            .updateSettings(  
            .put(indexSettings())  
                Settings.builder()  
        return indicesService.indexService(new Index(indexName, uuid));  
 * Licensed to Elasticsearch under one or more contributor  
        String clusterManagerName = internalCluster().getClusterManagerName();
        assertEquals(10, indexService.getRefreshTaskInterval().seconds());  
    public void testClusterMinimumRefreshIntervalOfMinusOneFails() {  
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());  
        TimeValue invalidRefreshInterval = TimeValue.timeValueMillis(validMinimumRefreshInterval.millis() - randomIntBetween(1, 1000));
            .updateSettings(
        request.settings(
    static void putIndexTemplate(String refreshInterval) {  
    }
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
                    .put(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey(), "10s")  
 * Unless required by applicable law or agreed to in writing,
        TimeValue customRefreshInterval = TimeValue.timeValueSeconds(getDefaultRefreshInterval().getSeconds() + randomIntBetween(1, 5));
    public void testDefaultRefreshIntervalOfMinusOneIrrespectiveOfMinimum() {
            .put(indexSettings())  
    public void setUp() throws Exception {
        assertEquals(getDefaultRefreshInterval(), indexService.getRefreshTaskInterval());
                    Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), customRefreshInterval)
            .indices()  
        TimeValue validRefreshInterval = TimeValue.timeValueMillis(validMinimumRefreshInterval.millis() + randomIntBetween(1, 1000));
            )  
 * not use this file except in compliance with the License.
            .setTransientSettings(
        createIndex(INDEX_NAME, indexSettings);  
                    Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "100s")
        assertEquals(validRefreshInterval, indicesService.indexService(new Index(OTHER_INDEX_NAME, otherUuid)).getRefreshTaskInterval());
        ensureGreen(INDEX_NAME);  
            )
        assertEquals(customRefreshInterval, indexService.getRefreshTaskInterval());  
            .cluster()
 * GitHub history for details.
        client(clusterManagerName).admin()  
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), invalidRefreshInterval)
        return Settings.builder().put(super.indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build();
        String clusterManagerName = internalCluster().getClusterManagerName();
            )
        throw new RuntimeException("This is not expected to be called here, but for the implementor");
                .prepareUpdateSettings()  
        assertEquals(IndexSettings.DEFAULT_REFRESH_INTERVAL, indexService.getRefreshTaskInterval());  
    }
    public Settings indexSettings() {
                    .putNull(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey())
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
            .build();
        String invalidRefreshInterval = "-10s";
                    .put(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), randomFrom("-1", "-1ms"))
/*  
package org.opensearch.cluster.metadata;
import org.opensearch.indices.IndicesService;
        TimeValue refreshInterval = TimeValue.timeValueMillis(randomIntBetween(10, 90) * 1000L);
    }
            () -> client(clusterManagerName).admin()
        ensureGreen(OTHER_INDEX_NAME);  
                    Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), validRefreshInterval)  
    public static final String OTHER_INDEX_NAME = "other-test-index";
                Settings.builder()  
        // Update with invalid index setting index.refresh_interval, this will fail.
            .putNull(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey())  
        IllegalArgumentException exceptionDuringMinUpdate = assertThrows(
            .get();
        String clusterManagerName = internalCluster().getClusterManagerName();
            .prepareUpdateSettings()
 */  
        assertEquals(validRefreshInterval, indexService.getRefreshTaskInterval());
        ensureYellowAndNoInitializingShards(INDEX_NAME);  
        // Create another index with invalid index setting index.refresh_interval, this fails.
        String clusterManagerName = internalCluster().getClusterManagerName();
        IllegalArgumentException exceptionDuringUpdateSettings = assertThrows(  
    }
                    Settings.builder().putNull(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey())
 * You may obtain a copy of the License at  
        String refreshInterval = randomFrom("-1", "-1ms");  
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
                Settings.builder().put(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey(), validMinimumRefreshInterval)  
    }
        );  
        // Update the cluster.default.index.refresh_interval & cluster.minimum.index.refresh_interval setting to null
}  
                )  
                    .put(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey(), randomFrom("0", "1ms", "1s", "10s"))
            exception.getMessage()
import org.opensearch.action.admin.indices.get.GetIndexRequest;
            .updateSettings(  
                .setTransientSettings(
        client(clusterManagerName).admin()
        PutIndexTemplateRequest request = new PutIndexTemplateRequest("my-template"); // <1>
                .actionGet()  
        );
import java.util.Arrays;
     */
            .build();
        String uuid = getIndexResponse.getSettings().get(INDEX_NAME).get(IndexMetadata.SETTING_INDEX_UUID);
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());  
        getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();  
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
        ensureGreen(INDEX_NAME);
            .cluster()  
        // Update index setting to a value >= current cluster minimum and this should happen successfully.
        String uuid = getIndexResponse.getSettings().get(INDEX_NAME).get(IndexMetadata.SETTING_INDEX_UUID);
            .prepareUpdateSettings()
     * being lesser than the `cluster.minimum.index.refresh_interval`. Later we change the cluster minimum to be more than
    @Before  
            .indices()  
        // verify the index is still using the refresh interval passed in the update settings call
        TimeValue clusterMinimum = TimeValue.timeValueSeconds(customRefreshInterval.getSeconds() + randomIntBetween(1, 5));
        Settings settings = Settings.builder()
        assertEquals(customRefreshInterval, indexService.getRefreshTaskInterval());
            + invalidRefreshInterval
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());  
import static org.opensearch.indices.IndicesService.CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING;  
 * KIND, either express or implied.  See the License for the
        // This test checks that we are able to update index with -1 refresh interval using index settings and default interval both.  
        // Update with valid index setting index.refresh_interval, this will succeed now.  
                    .put(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), clusterDefault)  
            + validMinimumRefreshInterval  
        client(clusterManagerName).admin()
            "failed to parse setting [index.refresh_interval] with value ["
 *
                    )
        client(clusterManagerName).admin()
            .get();  
                .put("index.refresh_interval", refreshInterval)
            .get();
        createIndex(OTHER_INDEX_NAME);
                Settings.builder()
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));  
    private IndexService getIndexServiceFromRandomDataNode(String indexName) throws ExecutionException, InterruptedException {  
        createIndex(INDEX_NAME, indexSettings);  
        client(clusterManagerName).admin()
            .get();
            )
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> createIndex(INDEX_NAME, settings));
 * this file be licensed under the Apache-2.0 license or a
                .get()
        // Remove the index setting as well now, it should reset the refresh task interval to the default refresh interval
                Settings.builder()
            .setTransientSettings(
                    .put(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey(), clusterMinimum)
        client(clusterManagerName).admin()  
            .cluster()  
        createIndex(INDEX_NAME, settings);  
            .get();
        client(clusterManagerName).admin()
            .prepareUpdateSettings()
 * specific language governing permissions and limitations
        assertEquals(  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2)
        GetIndexResponse getIndexResponse = client(internalCluster().getClusterManagerName()).admin()
        // Update the cluster.default.index.refresh_interval setting to another value and validate the index refresh interval  
        TimeValue invalidMinimumRefreshInterval = TimeValue.timeValueMillis(refreshInterval.millis() + randomIntBetween(1, 1000));
        client(clusterManagerName).admin()
import org.opensearch.common.unit.TimeValue;  
            .cluster()
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;  
            + "]: cannot be smaller than cluster.minimum.index.refresh_interval ["
        assertEquals(validRefreshInterval, indexService.getRefreshTaskInterval());  
            IllegalArgumentException.class,  
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
        putIndexTemplate("2s");
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
    }
        internalCluster().startClusterManagerOnlyNode();  
            .prepareUpdateSettings()  
                )
        client(clusterManagerName).admin()
 * The OpenSearch Contributors require contributions made to  
                .updateSettings(
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();  
            .build();
            )
                + invalidRefreshInterval
                .cluster()
        // Validate that the index refresh interval is still the existing one that was used during index creation
                .put("index.number_of_replicas", 1)
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), customRefreshInterval)
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));  
    public void testCreateIndexWithMinusOneRefreshInterval() throws ExecutionException, InterruptedException {
        String clusterManagerName = internalCluster().getClusterManagerName();  
            .prepareUpdateSettings()  
            )
import static org.opensearch.indices.IndicesService.CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING;
    public static final String INDEX_NAME = "test-index";
        );
        assertEquals(IndexSettings.MINIMUM_REFRESH_INTERVAL, indexService.getRefreshTaskInterval());  
            .build();
    }
public class ClusterIndexRefreshIntervalIT extends AbstractSnapshotIntegTestCase {  
                .setTransientSettings(Settings.builder().put(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey(), refreshInterval))  
    protected TimeValue getDefaultRefreshInterval() {  
     * In this test we check the case where an index is created with index setting `index.refresh_interval` with the value
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), IndexSettings.MINIMUM_REFRESH_INTERVAL)
                )
 * this work for additional information regarding copyright
            )
            .cluster()  
        IndexService indexService = getIndexServiceFromRandomDataNode(INDEX_NAME);
            .prepareUpdateSettings()
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));  
        assertTrue(client().admin().indices().putTemplate(request).actionGet().isAcknowledged());
            .cluster()
            .put(indexSettings())  
                    .put(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), "10s")
    @Override  
                    new UpdateSettingsRequest(INDEX_NAME).settings(
        assertEquals(customRefreshInterval, indexService.getRefreshTaskInterval());  
            IllegalArgumentException.class,
        String expectedMessage = "invalid index.refresh_interval ["  
            .updateSettings(
        ensureGreen(INDEX_NAME);
        // This test checks that we can set the cluster minimum refresh interval as 0.
            .getIndex(new GetIndexRequest())
        assertEquals(-1, indexService.getRefreshTaskInterval().millis());
        );
        ensureYellowAndNoInitializingShards(indexName);  
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
        );
                    .put(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey(), "10s")
import org.opensearch.common.settings.Settings;
                .prepareUpdateSettings()
            .prepareUpdateSettings()  
        String clusterManagerName = internalCluster().getClusterManagerName();  
    }
            .cluster()
            .setTransientSettings(Settings.builder().put(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), randomFrom("-1", "-1ms")))  
        // This test checks that we can not set cluster minimum refresh interval as -1 (or -1ms).
        assertEquals(  
    }
        client(clusterManagerName).admin()
        createIndex(INDEX_NAME);  
        ensureGreen(indexName);
        IndexService indexService = indicesService.indexService(new Index(INDEX_NAME, uuid));
    public void testCreateIndexWithExplicitNullRefreshInterval() throws ExecutionException, InterruptedException {
import org.opensearch.core.index.Index;
        client(clusterManagerName).admin()
            IllegalArgumentException.class,
            () -> client(clusterManagerName).admin()  
                .put("index.number_of_shards", 1)  
            .get();
        createIndex(
        assertEquals(getDefaultRefreshInterval(), indexService.getRefreshTaskInterval());
        );
/*
        // Test index creation using template with valid refresh interval  
                )
    public void testRefreshIntervalDisabled() throws ExecutionException, InterruptedException {
        Settings indexSettings = Settings.builder()
        IndexService indexService = indicesService.indexService(new Index(indexName, uuid));
                    .put(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), "10s")
import org.opensearch.index.IndexService;
        assertEquals(refreshInterval, indexService.getRefreshTaskInterval());
            .get();
        // verify refresh task interval is updated.
        Settings indexSettings = Settings.builder()
        IndexService indexService = indicesService.indexService(new Index(INDEX_NAME, uuid));
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), randomFrom("-1", "-1ms"))
        client(clusterManagerName).admin()
            .setTransientSettings(Settings.builder().put(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey(), "0"))  
 */
 * Modifications Copyright OpenSearch Contributors. See
            .get();  
    }  
        IndexService indexService = indicesService.indexService(new Index(INDEX_NAME, uuid));  
            .get();
        client(clusterManagerName).admin()  
        // This test checks that we are able to set the cluster default refresh interval to one regardless of what the
                    Settings.builder().put(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey(), invalidMinimumRefreshInterval)
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
        ensureGreen(INDEX_NAME);
                new UpdateSettingsRequest(INDEX_NAME).settings(  
        String indexName = "log-myindex-1";
import java.util.concurrent.ExecutionException;  
                    Settings.builder().putNull(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey())
            .prepareUpdateSettings()
        TimeValue clusterDefault = TimeValue.timeValueSeconds(customRefreshInterval.getSeconds() + 6);
    }
                new UpdateSettingsRequest(INDEX_NAME).settings(  
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
 * SPDX-License-Identifier: Apache-2.0
            )  
            () -> client(clusterManagerName).admin()
            Settings.builder().put(indexSettings).put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), validRefreshInterval).build()
        request.patterns(Arrays.asList("pattern-1", "log-*")); // <2>
    protected TimeValue getMinRefreshIntervalForRefreshDisabled() {  
        String clusterManagerName = internalCluster().getClusterManagerName();
                )  
            .cluster()  
            .setTransientSettings(
