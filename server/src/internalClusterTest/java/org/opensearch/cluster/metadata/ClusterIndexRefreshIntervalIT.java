        IndexService indexService = getIndexServiceFromRandomDataNode(INDEX_NAME);
import org.opensearch.indices.IndicesService;
    public void testRefreshIntervalDisabled() throws ExecutionException, InterruptedException {
        ensureGreen(INDEX_NAME);
    public void testDefaultRefreshIntervalWithUpdateClusterAndIndexSettings() throws Exception {
    public void testClusterMinimumRefreshIntervalOfMinusOneFails() {
        ensureGreen(INDEX_NAME);
    }
                new UpdateSettingsRequest(INDEX_NAME).settings(
            "cluster minimum index refresh interval ["
            .updateSettings(
                new UpdateSettingsRequest(INDEX_NAME).settings(
        assertEquals(
        client(clusterManagerName).admin()
        assertTrue(client().admin().indices().putTemplate(request).actionGet().isAcknowledged());
        client(clusterManagerName).admin()
        createIndex(INDEX_NAME, indexSettings);
            .cluster()
            .getIndex(new GetIndexRequest())
    }
            .indices()
                )
        // Update of cluster.minimum.index.refresh_interval setting to value more than default refreshInterval above will fail
        TimeValue clusterDefault = TimeValue.timeValueSeconds(customRefreshInterval.getSeconds() + 6);
            Settings.builder().put(indexSettings).put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), validRefreshInterval).build()
    }
        client(clusterManagerName).admin()
        assertEquals(-1, indexService.getRefreshTaskInterval().millis());
        String otherUuid = getIndexResponse.getSettings().get(INDEX_NAME).get(IndexMetadata.SETTING_INDEX_UUID);
                + invalidMinimumRefreshInterval
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
        ensureGreen(OTHER_INDEX_NAME);
            .prepareUpdateSettings()
    public void testDefaultRefreshIntervalOfMinusOneIrrespectiveOfMinimum() {
     * the index setting. The underlying index should continue to use the same refresh interval as earlier.
            )
    @Before
            .get();
                Settings.builder()
            )
    static void putIndexTemplate(String refreshInterval) {
        // Update the cluster.default.index.refresh_interval setting to another value and validate the index refresh interval
        // Try to create another index with valid index setting index.refresh_interval, this will pass.
 * specific language governing permissions and limitations
            .prepareUpdateSettings()
                new UpdateSettingsRequest(INDEX_NAME).settings(
                )
            .actionGet();
                    .put(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), randomFrom("-1", "-1ms"))
                .put("index.number_of_shards", 1)
            .cluster()
        assertEquals(-1, indexService.getRefreshTaskInterval().millis());
        client(clusterManagerName).admin()
                Settings.builder()
        createIndex(INDEX_NAME);
 *
            )
        );
            .prepareUpdateSettings()
            .put(indexSettings())
                .prepareUpdateSettings()
import java.util.List;
            IllegalArgumentException.class,
    public void testClusterMinimumChangeOnIndexWithCustomRefreshInterval() throws ExecutionException, InterruptedException {
        String clusterManagerName = internalCluster().getClusterManagerName();
        client(clusterManagerName).admin()
                .indices()
        // This test checks that we are able to set the cluster default refresh interval to one regardless of what the
        TimeValue invalidRefreshInterval = TimeValue.timeValueMillis(validMinimumRefreshInterval.millis() - randomIntBetween(1, 1000));
                    .put(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), "10s")
        createIndex(INDEX_NAME, indexSettings);
            .get();
/*
                Settings.builder()
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
        String uuid = getIndexResponse.getSettings().get(INDEX_NAME).get(IndexMetadata.SETTING_INDEX_UUID);
            .get();
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), invalidRefreshInterval)
        client(clusterManagerName).admin()
        client(clusterManagerName).admin()
    @Override
        );
        String refreshInterval = randomFrom("-1", "-1ms");
            .updateSettings(
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), invalidRefreshInterval)
            .cluster()
        assertEquals(
            .build();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        // Update index setting to a value >= current cluster minimum and this should happen successfully.
                )
        // Update with valid index setting index.refresh_interval, this will succeed now.
        IndexService indexService = indicesService.indexService(new Index(indexName, uuid));
                new UpdateSettingsRequest(INDEX_NAME).settings(
    protected TimeValue getMinRefreshIntervalForRefreshDisabled() {
        TimeValue validMinimumRefreshInterval = TimeValue.timeValueMillis(refreshInterval.millis() - randomIntBetween(1, 1000));
        client(clusterManagerName).admin()
    public void testCreateIndexWithMinusOneRefreshInterval() throws ExecutionException, InterruptedException {
        String invalidRefreshInterval = "-10s";
            .put(indexSettings())
package org.opensearch.cluster.metadata;
    }
        createIndex(OTHER_INDEX_NAME);
                    Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "100s")
        client(clusterManagerName).admin()
        assertEquals(-1, indexService.getRefreshTaskInterval().millis());
            .cluster()
        // Validate that the index refresh interval is still the existing one that was used during index creation
        TimeValue invalidMinimumRefreshInterval = TimeValue.timeValueMillis(refreshInterval.millis() + randomIntBetween(1, 1000));
    public Settings indexSettings() {
    public void setUp() throws Exception {
        ensureYellowAndNoInitializingShards(INDEX_NAME);
import org.opensearch.index.IndexSettings;
import org.opensearch.index.IndexService;
            + invalidRefreshInterval
        // This test checks that we are able to update index with -1 refresh interval using index settings and default interval both.
    @Override
        request.settings(
            )
        // Remove the index setting as well now, it should reset the refresh task interval to the default refresh interval
        assertEquals(validRefreshInterval, indexService.getRefreshTaskInterval());
            .cluster()
        return indicesService.indexService(new Index(indexName, uuid));
            .indices()
            .prepareUpdateSettings()
        assertEquals(customRefreshInterval, indexService.getRefreshTaskInterval());
/*
                    new UpdateSettingsRequest(INDEX_NAME).settings(
        Settings indexSettings = Settings.builder()
                )
import org.opensearch.action.admin.indices.template.put.PutIndexTemplateRequest;
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
        String clusterManagerName = internalCluster().getClusterManagerName();
        ensureGreen(indexName);
        String clusterManagerName = internalCluster().getClusterManagerName();
        internalCluster().startClusterManagerOnlyNode();
        ensureGreen(INDEX_NAME);
        TimeValue customRefreshInterval = TimeValue.timeValueSeconds(getDefaultRefreshInterval().getSeconds() + randomIntBetween(1, 5));
            IllegalArgumentException.class,
        String clusterManagerName = internalCluster().getClusterManagerName();
 * Unless required by applicable law or agreed to in writing,
            )
            .setTransientSettings(Settings.builder().put(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), randomFrom("-1", "-1ms")))
            "failed to parse value [" + refreshInterval + "] for setting [cluster.minimum.index.refresh_interval], must be >= [0ms]",
import org.opensearch.snapshots.AbstractSnapshotIntegTestCase;
            exceptionDuringMinUpdate.getMessage()
            .indices()
        // to a valid value as well to be deterministic in test behaviour.
        IllegalArgumentException exceptionDuringUpdateSettings = assertThrows(
            .indices()
    }
 *
                    Settings.builder().putNull(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey())
            .getIndex(new GetIndexRequest())
                .setTransientSettings(Settings.builder().put(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey(), refreshInterval))
    protected TimeValue getDefaultRefreshInterval() {
        assertEquals(validRefreshInterval, indexService.getRefreshTaskInterval());
        // verify refresh task interval is updated.
            .setTransientSettings(Settings.builder().put(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey(), "0"))
        assertEquals(-1, indexService.getRefreshTaskInterval().millis());
                    .put(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey(), "10s")
            .updateSettings(
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2)
        assertEquals(getDefaultRefreshInterval(), indexService.getRefreshTaskInterval());
                        Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), invalidRefreshInterval)
    }
            IllegalArgumentException.class,
/*
import static org.opensearch.indices.IndicesService.CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING;
                )
        createIndex(
 * The OpenSearch Contributors require contributions made to
    public void testCreateIndexWithExplicitNullRefreshInterval() throws ExecutionException, InterruptedException {
            )
        Settings indexSettings = Settings.builder()
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
        );
        assertEquals(IndexSettings.MINIMUM_REFRESH_INTERVAL, indexService.getRefreshTaskInterval());
        ensureYellowAndNoInitializingShards(INDEX_NAME);
    }
        TimeValue clusterMinimum = TimeValue.timeValueSeconds(customRefreshInterval.getSeconds() + randomIntBetween(1, 5));
            .get();
        putIndexTemplate("2s");
        // This test checks that we can not set cluster minimum refresh interval as -1 (or -1ms).
     * In this test we check the case where an index is created with index setting `index.refresh_interval` with the value
        client(clusterManagerName).admin()
            .get();
                    Settings.builder().put(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey(), invalidMinimumRefreshInterval)
            Settings.builder() // <1>
}
                + "] more than cluster default index refresh interval ["
            .cluster()
                    .put(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), clusterDefault)
        assertEquals(TimeValue.timeValueSeconds(2), indexService.getRefreshTaskInterval());
        assertEquals(getDefaultRefreshInterval(), indexService.getRefreshTaskInterval());
            )
            + "]: cannot be smaller than cluster.minimum.index.refresh_interval ["
            .setTransientSettings(
                    Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), randomFrom("-1", "-1ms"))
            .updateSettings(
        ensureGreen(INDEX_NAME);
        assertEquals(
    }
            + validMinimumRefreshInterval
        );
            () -> client(clusterManagerName).admin()
import org.opensearch.common.unit.TimeValue;
        String uuid = getIndexResponse.getSettings().get(INDEX_NAME).get(IndexMetadata.SETTING_INDEX_UUID);
            .cluster()
        IndexService indexService = indicesService.indexService(new Index(INDEX_NAME, uuid));
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
        String clusterManagerName = internalCluster().getClusterManagerName();
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> createIndex(INDEX_NAME, settings));
                new UpdateSettingsRequest(INDEX_NAME).settings(
            .get();
        IndexService indexService = indicesService.indexService(new Index(INDEX_NAME, uuid));
 */
        );
        TimeValue validRefreshInterval = TimeValue.timeValueMillis(validMinimumRefreshInterval.millis() + randomIntBetween(1, 1000));
            .get();
            )
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
            .put(indexSettings())
                + refreshInterval
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
        String expectedMessage = "invalid index.refresh_interval ["
    private IndexService getIndexServiceFromRandomDataNode(String indexName) throws ExecutionException, InterruptedException {
        assertEquals(validRefreshInterval, indicesService.indexService(new Index(OTHER_INDEX_NAME, otherUuid)).getRefreshTaskInterval());
            .prepareUpdateSettings()
        ensureYellowAndNoInitializingShards(INDEX_NAME);
                new UpdateSettingsRequest(INDEX_NAME).settings(
        );
        String uuid = getIndexResponse.getSettings().get(INDEX_NAME).get(IndexMetadata.SETTING_INDEX_UUID);
        assertEquals(10, indexService.getRefreshTaskInterval().seconds());
        assertEquals(expectedMessage, exceptionDuringUpdateSettings.getMessage());
import org.opensearch.test.OpenSearchIntegTestCase;
import org.junit.Before;
            .put(indexSettings())
            + "]";
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
                    Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), validRefreshInterval)
                    Settings.builder().putNull(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey())
                .get()
            .prepareUpdateSettings()
        GetIndexResponse getIndexResponse = client(internalCluster().getClusterManagerName()).admin()
        getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
                Settings.builder()
                .put("index.refresh_interval", refreshInterval)
            .setTransientSettings(
            )
 */
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
        // This test checks that we can set the cluster minimum refresh interval as 0.
    /**
        indexService = getIndexServiceFromRandomDataNode(OTHER_INDEX_NAME);
 * compatible open source license.
        // Test index creation using template with valid refresh interval
                .cluster()
        GetIndexResponse getIndexResponse = client(internalCluster().getClusterManagerName()).admin()
            .get();
            .prepareUpdateSettings()
            .indices()
                    .put(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), "10s")
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
     */
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.admin.indices.get.GetIndexRequest;
        client(clusterManagerName).admin()
            .cluster()
                .actionGet()
        IllegalArgumentException exceptionDuringCreateIndex = assertThrows(
            .indices()
        // Update with invalid index setting index.refresh_interval, this will fail.
            .actionGet();
            .prepareUpdateSettings()
                .put("index.number_of_replicas", 1)
            .get();
 * not use this file except in compliance with the License.
            .updateSettings(
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
                    Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), customRefreshInterval)
public class ClusterIndexRefreshIntervalIT extends AbstractSnapshotIntegTestCase {
        String clusterManagerName = internalCluster().getClusterManagerName();
    public void testInvalidRefreshInterval() {
                    .putNull(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey())
        // minimum is set to. -1 corresponds to no period background refreshes.
    public void testClusterMinimumRefreshIntervalOfZero() {
        client(clusterManagerName).admin()
            .setTransientSettings(
        client(clusterManagerName).admin()
        createIndex(INDEX_NAME, indexSettings);
 * Modifications Copyright OpenSearch Contributors. See
        // Create another index with invalid index setting index.refresh_interval, this fails.
            OTHER_INDEX_NAME,
            .updateSettings(
        );
                )
        IndexService indexService = indicesService.indexService(new Index(INDEX_NAME, uuid));
 */
            ex.getMessage()
        assertEquals(expectedMessage, exceptionDuringCreateIndex.getMessage());
    public static final String INDEX_NAME = "test-index";
            .setTransientSettings(
            .setTransientSettings(Settings.builder().put(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), refreshInterval))
        String uuid = getIndexResponse.getSettings().get(INDEX_NAME).get(IndexMetadata.SETTING_INDEX_UUID);
            .get();
        ensureYellowAndNoInitializingShards(indexName);
            )
                .get()
                )
            .setTransientSettings(Settings.builder().put(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), randomFrom("-1", "-1ms")))
        IndexService indexService = getIndexServiceFromRandomDataNode(INDEX_NAME);
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), randomFrom("-1", "-1ms"))
            .build();
        PutIndexTemplateRequest request = new PutIndexTemplateRequest("my-template"); // <1>
    }
 * SPDX-License-Identifier: Apache-2.0
        String clusterManagerName = internalCluster().getClusterManagerName();
            .prepareUpdateSettings()
            .get();
        assertEquals(customRefreshInterval, indexService.getRefreshTaskInterval());
                Settings.builder().put(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey(), validMinimumRefreshInterval)
        Settings settings = Settings.builder()
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
        TimeValue refreshInterval = TimeValue.timeValueMillis(randomIntBetween(10, 90) * 1000L);
import org.opensearch.core.index.Index;
            .build();
    }
            () -> client(clusterManagerName).admin()
                    .putNull(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey())
                    )
import org.opensearch.action.admin.indices.get.GetIndexResponse;
 * GitHub history for details.
                Settings.builder()
                    .put(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey(), clusterMinimum)
        assertEquals(100, indexService.getRefreshTaskInterval().seconds());
                    .put(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey(), "10s")
 * ownership. Elasticsearch licenses this file to you under
            .cluster()
            .indices()
     * being lesser than the `cluster.minimum.index.refresh_interval`. Later we change the cluster minimum to be more than
        IndexService indexService = indicesService.indexService(new Index(INDEX_NAME, uuid));
            .putNull(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey())
            () -> createIndex(OTHER_INDEX_NAME, indexSettings)
            .build();
                )
    public void testIndexTemplateCreationSucceedsWhenNoMinimumRefreshInterval() throws ExecutionException, InterruptedException {
            () -> client(clusterManagerName).admin()
 * software distributed under the License is distributed on an
            .put(indexSettings())
        assertEquals(refreshInterval, indexService.getRefreshTaskInterval());
        );
                + "] as a time value: negative durations are not supported",
    }
 * You may obtain a copy of the License at
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
        IllegalArgumentException ex = assertThrows(
    }
        ensureGreen(INDEX_NAME);
 * Licensed to Elasticsearch under one or more contributor
            )
import static org.opensearch.indices.IndicesService.CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING;
            .build();
        Settings settings = Settings.builder()
        Settings indexSettings = Settings.builder()
        assertEquals(IndexSettings.DEFAULT_REFRESH_INTERVAL, indexService.getRefreshTaskInterval());
import org.opensearch.common.settings.Settings;
 * KIND, either express or implied.  See the License for the
    }
        client(clusterManagerName).admin()
import java.util.ArrayList;
 *    http://www.apache.org/licenses/LICENSE-2.0
        String clusterManagerName = internalCluster().getClusterManagerName();
                .setTransientSettings(
            .put(indexSettings())
        // Update the cluster.minimum.index.refresh_interval setting to a valid value, this will succeed.
            .get();
    }
        );
            .get();
                + invalidRefreshInterval
                + "]",
    }
    }
        String clusterManagerName = internalCluster().getClusterManagerName();
    }
            .cluster()
 *
        return IndexSettings.DEFAULT_REFRESH_INTERVAL;
            .indices()
 * under the License.
        createIndex(INDEX_NAME, settings);
import java.util.Arrays;
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), customRefreshInterval)
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
            .get();
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
        throw new RuntimeException("This is not expected to be called here, but for the implementor");
            "failed to parse setting [index.refresh_interval] with value ["
            )
        ensureGreen(INDEX_NAME);
        List<String> dataNodes = new ArrayList<>(internalCluster().getDataNodeNames());
            .prepareUpdateSettings()
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
        // verify the index is still using the refresh interval passed in the update settings call
        customRefreshInterval = TimeValue.timeValueSeconds(clusterMinimum.getSeconds() + randomIntBetween(1, 5));
            .setTransientSettings(
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, randomFrom(dataNodes));
import java.util.concurrent.ExecutionException;
            .setTransientSettings(
            .get();
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
        // At the same time, due to certain degree of randomness in the test, we update the cluster.default.refresh_interval
    public static final String OTHER_INDEX_NAME = "other-test-index";
        assertEquals(customRefreshInterval, indexService.getRefreshTaskInterval());
        String clusterManagerName = internalCluster().getClusterManagerName();
            .actionGet();
        String indexName = "log-myindex-1";
                    .put(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey(), randomFrom("0", "1ms", "1s", "10s"))
        client(clusterManagerName).admin()
                .updateSettings(
        super.setUp();
        Settings indexSettings = Settings.builder()
            .build();
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), IndexSettings.MINIMUM_REFRESH_INTERVAL)
        // Update the cluster.minimum.index.refresh_interval setting to a valid value higher the custom refresh interval.
        client(clusterManagerName).admin()
 * the Apache License, Version 2.0 (the "License"); you may
    public void testUpdateIndexWithMinusOneRefreshInterval() throws ExecutionException, InterruptedException {
        createIndex(INDEX_NAME);
                .prepareUpdateSettings()
            exception.getMessage()
            IllegalArgumentException.class,
        createIndex(indexName);
        request.patterns(Arrays.asList("pattern-1", "log-*")); // <2>
        // Update the cluster.default.index.refresh_interval & cluster.minimum.index.refresh_interval setting to null
        // This test checks that we are able to create index with -1 refresh interval using index settings and default interval both.
        IllegalArgumentException exceptionDuringMinUpdate = assertThrows(
                .cluster()
        return Settings.builder().put(super.indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build();
