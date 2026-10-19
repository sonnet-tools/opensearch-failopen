            .get()
        final SnapshotInfo snapshotInfo = clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap")
            () -> clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")
                "0s",
    }
            .cluster()
            throwable.getMessage(),
    }
import org.opensearch.action.admin.indices.get.GetIndexResponse;
        getIndexResponse = client().admin().indices().getIndex(new GetIndexRequest().indices("my-index")).get();
import static org.hamcrest.Matchers.is;
        GetIndexTemplatesResponse getIndexTemplatesResponse = client().admin().indices().prepareGetTemplates().get();
        client(clusterManagerName).admin()
        return TimeValue.timeValueSeconds(1);
        assertThat(client().admin().indices().prepareDeleteTemplate("my-template").get().isAcknowledged(), equalTo(true));
                Locale.ROOT,
        return TimeValue.timeValueSeconds(5);
    protected Settings nodeSettings(int nodeOrdinal) {
    @Override
                .put(INDEX_REFRESH_INTERVAL_SETTING.getKey(), "2s")
        assertThat(client().admin().indices().prepareDelete("my-index").get().isAcknowledged(), equalTo(true));
        putIndexTemplate("2s");
            .setIndices()
        String clusterManagerName = internalCluster().getClusterManagerName();
            .execute()
    public void testIndexTemplateCreationFailsWithLessThanMinimumRefreshInterval() throws ExecutionException, InterruptedException {
        final SnapshotInfo snapshotInfo = clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap")
        assertThat(snapshotInfo.totalShards(), equalTo(1));
                    .put(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey(), "4s")
    }
            IllegalArgumentException.class,
            "my-index",
            .setTransientSettings(
            .getSnapshotInfo();
        createRepository("test-repo", "fs");
                Settings.builder()
                .setRestoreGlobalState(true)
            "invalid index.refresh_interval [2s]: cannot be smaller than cluster.minimum.index.refresh_interval [4s]"
import static org.opensearch.index.IndexSettings.INDEX_REFRESH_INTERVAL_SETTING;
                .actionGet()
            )
        assertThat(snapshotInfo.successfulShards(), equalTo(1));
            .prepareUpdateSettings()
        );
                .build()
    }
 * compatible open source license.
        return Settings.builder()
            .setWaitForCompletion(true)
        assertEquals(getIndexResponse.indices().length, 1);
            .cluster()
        getIndexResponse = client().admin().indices().getIndex(new GetIndexRequest()).get();
                "invalid index.refresh_interval [%s]: cannot be smaller than cluster.minimum.index.refresh_interval [%s]",
                    .put(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey(), "4s")
            .setRestoreGlobalState(true)
                    .put(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), "5s")
        );
            .prepareUpdateSettings()
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), equalTo(1));
        createIndex(
    }
            )
 * The OpenSearch Contributors require contributions made to
    @Override
        assertEquals(
package org.opensearch.cluster.metadata;
    public void testIndexTemplateSnapshotRestoreWithLessThanMinimumRefreshInterval() throws ExecutionException, InterruptedException {
            .execute()
                    .put(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey(), "1s")
                getMinRefreshIntervalForRefreshDisabled()
        assertThat(snapshotInfo.successfulShards(), equalTo(0));
import org.opensearch.snapshots.SnapshotState;
                .execute()
            .get();
        client(clusterManagerName).admin()
import static org.hamcrest.Matchers.equalTo;
            throwable.getMessage(),
            .setWaitForCompletion(true)
            .put(IndicesService.CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), getDefaultRefreshInterval())
            IllegalArgumentException.class,
        assertEquals(
            )
        assertEquals(getIndexResponse.indices().length, 0);
            .execute()
        client(clusterManagerName).admin()
    @Override
 *
            .get();
            .cluster()
    public void testIndexSnapshotRestoreWithLessThanMinimumRefreshInterval() throws ExecutionException, InterruptedException {
import org.opensearch.common.settings.Settings;
            .get();
            .setTransientSettings(
 */
                Settings.builder()
            () -> clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")
            throwable.getMessage(),
                Settings.builder()
        logger.info("--> try restore cluster state -- should fail");
            .get();
                .execute()
                getMinRefreshIntervalForRefreshDisabled().toString()
        assertThat(snapshotInfo.state(), is(SnapshotState.SUCCESS));
        assertThat(snapshotInfo.state(), is(SnapshotState.SUCCESS));
            )
                    .put(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), "5s")
        assertIndexTemplateExists(getIndexTemplatesResponse, "my-template");
        );
            .setTransientSettings(
            .setRestoreGlobalState(true)
}
                .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
        );
        RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")
            .put(super.nodeSettings(nodeOrdinal))
    }
        Throwable throwable = assertThrows(
import org.opensearch.snapshots.SnapshotInfo;
            .setWaitForCompletion(true)
        RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")
        assertThat(snapshotInfo.totalShards(), equalTo(0));
            .prepareUpdateSettings()
                .setRestoreGlobalState(true)
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesResponse;
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING;
import static org.opensearch.indices.IndicesService.CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING;
    protected TimeValue getDefaultRefreshInterval() {
        assertEquals("2s", getIndexResponse.getSetting("my-index", INDEX_REFRESH_INTERVAL_SETTING.getKey()));
 * SPDX-License-Identifier: Apache-2.0
        getIndexTemplatesResponse = client().admin().indices().prepareGetTemplates().get();
            "invalid index.refresh_interval [2s]: cannot be smaller than cluster.minimum.index.refresh_interval [4s]"
                    .put(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey(), "1s")
        createRepository("test-repo", "fs");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertIndexTemplateExists;
import org.opensearch.indices.IndicesService;
            .actionGet();
        Throwable throwable = assertThrows(IllegalArgumentException.class, () -> putIndexTemplate("0s"));
import java.util.Locale;
            )
        );
            .put(
        );
import org.opensearch.action.admin.indices.get.GetIndexRequest;
            .actionGet();
            .execute()
                .setWaitForCompletion(true)
            .setIndices()
            .setWaitForCompletion(true)
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
        assertIndexTemplateMissing(getIndexTemplatesResponse, "my-template");
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), equalTo(0));
            .cluster()
import org.opensearch.common.unit.TimeValue;
        GetIndexResponse getIndexResponse = client().admin().indices().getIndex(new GetIndexRequest().indices("my-index")).get();
                Settings.builder()
            )
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertIndexTemplateMissing;
public class ClusterIndexRefreshIntervalWithNodeSettingsIT extends ClusterIndexRefreshIntervalIT {
            String.format(
    protected TimeValue getMinRefreshIntervalForRefreshDisabled() {
        client(clusterManagerName).admin()
                    .put(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), "5s")
        logger.info("--> try restore cluster state -- should fail");
        logger.info("--> restore cluster state");
        assertEquals(1, getIndexResponse.indices().length);
            .getSnapshotInfo();
                IndicesService.CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey(),
                .actionGet()
import static org.opensearch.indices.IndicesService.CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING;
                .setWaitForCompletion(true)
            .prepareUpdateSettings()
import java.util.concurrent.ExecutionException;
            .build();
        Throwable throwable = assertThrows(
 * this file be licensed under the Apache-2.0 license or a
        logger.info("--> try restore cluster state -- should pass");
            Settings.builder()
                    .put(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), "5s")
            .setTransientSettings(
            .get()
/*
        String clusterManagerName = internalCluster().getClusterManagerName();
        assertEquals(
                .put(indexSettings())
