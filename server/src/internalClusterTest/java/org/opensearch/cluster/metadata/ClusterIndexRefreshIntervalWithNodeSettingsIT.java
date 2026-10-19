            .getSnapshotInfo();  
        GetIndexTemplatesResponse getIndexTemplatesResponse = client().admin().indices().prepareGetTemplates().get();
        assertEquals(getIndexResponse.indices().length, 1);
        return TimeValue.timeValueSeconds(1);
                .setRestoreGlobalState(true)
import java.util.Locale;
        putIndexTemplate("2s");  
 *
            .prepareUpdateSettings()
                .setWaitForCompletion(true)
                .execute()
            .getSnapshotInfo();
        RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")  
                .build()
    public void testIndexSnapshotRestoreWithLessThanMinimumRefreshInterval() throws ExecutionException, InterruptedException {
                .execute()  
        final SnapshotInfo snapshotInfo = clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap")  
            )  
import static org.opensearch.index.IndexSettings.INDEX_REFRESH_INTERVAL_SETTING;  
 */  
            .setWaitForCompletion(true)
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING;
import org.opensearch.action.admin.indices.get.GetIndexResponse;  
            .get()
        assertEquals("2s", getIndexResponse.getSetting("my-index", INDEX_REFRESH_INTERVAL_SETTING.getKey()));
            .setIndices()
    @Override
        assertThat(client().admin().indices().prepareDeleteTemplate("my-template").get().isAcknowledged(), equalTo(true));
    }
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
    }
            )
            .actionGet();
                Settings.builder()  
            .setWaitForCompletion(true)  
            "invalid index.refresh_interval [2s]: cannot be smaller than cluster.minimum.index.refresh_interval [4s]"
        logger.info("--> restore cluster state");  
import static org.opensearch.indices.IndicesService.CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING;
            .get();  
 * SPDX-License-Identifier: Apache-2.0
                    .put(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), "5s")
        return Settings.builder()  
        GetIndexResponse getIndexResponse = client().admin().indices().getIndex(new GetIndexRequest().indices("my-index")).get();  
            .execute()  
                Settings.builder()  
        Throwable throwable = assertThrows(  
        );
        assertThat(snapshotInfo.successfulShards(), equalTo(1));
import org.opensearch.common.unit.TimeValue;  
            .execute()
        assertThat(client().admin().indices().prepareDelete("my-index").get().isAcknowledged(), equalTo(true));
            .prepareUpdateSettings()
            .cluster()  
        client(clusterManagerName).admin()
            .setTransientSettings(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertIndexTemplateExists;  
                getMinRefreshIntervalForRefreshDisabled().toString()
            .setIndices()
    @Override
}
    }  
                "invalid index.refresh_interval [%s]: cannot be smaller than cluster.minimum.index.refresh_interval [%s]",
        );
        client(clusterManagerName).admin()
        createRepository("test-repo", "fs");
            .execute()  
            )
import static org.hamcrest.Matchers.equalTo;
                    .put(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), "5s")
                    .put(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), "5s")  
    protected TimeValue getDefaultRefreshInterval() {
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), equalTo(0));  
            )  
            .execute()
            "invalid index.refresh_interval [2s]: cannot be smaller than cluster.minimum.index.refresh_interval [4s]"
            .get();  
        );
        String clusterManagerName = internalCluster().getClusterManagerName();
                .put(indexSettings())
        String clusterManagerName = internalCluster().getClusterManagerName();  
        assertThat(snapshotInfo.totalShards(), equalTo(0));
            .setWaitForCompletion(true)
    protected Settings nodeSettings(int nodeOrdinal) {
        client(clusterManagerName).admin()
    public void testIndexTemplateCreationFailsWithLessThanMinimumRefreshInterval() throws ExecutionException, InterruptedException {
        assertThat(snapshotInfo.state(), is(SnapshotState.SUCCESS));  
                Locale.ROOT,  
            .put(IndicesService.CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), getDefaultRefreshInterval())
        final SnapshotInfo snapshotInfo = clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap")
            .build();
                getMinRefreshIntervalForRefreshDisabled()  
 * The OpenSearch Contributors require contributions made to  
import java.util.concurrent.ExecutionException;  
            String.format(
            "my-index",  
import static org.opensearch.indices.IndicesService.CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING;
                .actionGet()  
                    .put(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey(), "1s")
        assertThat(snapshotInfo.successfulShards(), equalTo(0));  
                .put(INDEX_REFRESH_INTERVAL_SETTING.getKey(), "2s")
        );  
    }
        assertThat(snapshotInfo.totalShards(), equalTo(1));  
import static org.hamcrest.Matchers.is;  
            throwable.getMessage(),
        RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")
            .cluster()
            .setTransientSettings(
            .put(super.nodeSettings(nodeOrdinal))
                .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)  
import org.opensearch.indices.IndicesService;
        createIndex(
            () -> clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")  
        client(clusterManagerName).admin()
            .cluster()  
        assertEquals(  
            .actionGet();
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), equalTo(1));
        );  
        assertIndexTemplateMissing(getIndexTemplatesResponse, "my-template");
            .get()
    }  
            IllegalArgumentException.class,
        assertEquals(
package org.opensearch.cluster.metadata;
        logger.info("--> try restore cluster state -- should fail");
        getIndexResponse = client().admin().indices().getIndex(new GetIndexRequest().indices("my-index")).get();
        );
        createRepository("test-repo", "fs");
                    .put(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey(), "1s")
        logger.info("--> try restore cluster state -- should pass");
                .setRestoreGlobalState(true)
                Settings.builder()
            Settings.builder()
            .setTransientSettings(
            )  
import org.opensearch.common.settings.Settings;
                .setWaitForCompletion(true)  
    @Override
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.admin.indices.get.GetIndexRequest;
            throwable.getMessage(),
            .setRestoreGlobalState(true)
            .put(  
                "0s",
            IllegalArgumentException.class,
            throwable.getMessage(),  
        assertEquals(getIndexResponse.indices().length, 0);
        getIndexResponse = client().admin().indices().getIndex(new GetIndexRequest()).get();  
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesResponse;
            () -> clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")
            .get();
        return TimeValue.timeValueSeconds(5);  
    protected TimeValue getMinRefreshIntervalForRefreshDisabled() {  
                IndicesService.CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey(),
        Throwable throwable = assertThrows(IllegalArgumentException.class, () -> putIndexTemplate("0s"));
            .setTransientSettings(
import org.opensearch.snapshots.SnapshotInfo;
            .prepareUpdateSettings()  
            )
        logger.info("--> try restore cluster state -- should fail");  
/*  
        assertIndexTemplateExists(getIndexTemplatesResponse, "my-template");  
        getIndexTemplatesResponse = client().admin().indices().prepareGetTemplates().get();
            .setWaitForCompletion(true)
            .get();
        assertEquals(1, getIndexResponse.indices().length);
            .cluster()
                Settings.builder()
import org.opensearch.snapshots.SnapshotState;  
public class ClusterIndexRefreshIntervalWithNodeSettingsIT extends ClusterIndexRefreshIntervalIT {
    }
            .prepareUpdateSettings()  
            .setRestoreGlobalState(true)  
        assertThat(snapshotInfo.state(), is(SnapshotState.SUCCESS));
                .actionGet()
    public void testIndexTemplateSnapshotRestoreWithLessThanMinimumRefreshInterval() throws ExecutionException, InterruptedException {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertIndexTemplateMissing;
                    .put(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey(), "4s")
                    .put(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING.getKey(), "4s")
 * compatible open source license.
        assertEquals(  
        Throwable throwable = assertThrows(
                    .put(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), "5s")  
