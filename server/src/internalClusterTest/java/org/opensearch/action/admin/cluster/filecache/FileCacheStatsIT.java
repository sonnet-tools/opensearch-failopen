        NodesStatsRequest request = new NodesStatsRequest().addMetric(NodesStatsRequest.Metric.FILE_CACHE_STATS.metricName())
                    stats.getFileCacheStats(),
        NodesStatsResponse response = client().admin().cluster().nodesStats(request).actionGet();  
public class FileCacheStatsIT extends AbstractSnapshotIntegTestCase {
        createRepository(repoName, FsRepository.TYPE);  
            }
                // file_cache sub-stats (FileCache-only breakdown)
    protected Settings.Builder randomRepositorySettings() {  
                assertThat(  
     * Verifies that non-warm nodes do not carry file cache stats.
}
import static org.hamcrest.Matchers.equalTo;
            Settings.builder()
 * SPDX-License-Identifier: Apache-2.0
            .cluster()  
        }  
        assertTrue("Expected at least one warm node in the response", foundWarmNode);  
    // ── helpers ──────────────────────────────────────────────────────────────  
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;  
        final String indexName = "test-idx";  
        ensureGreen();
    }
    protected boolean addMockInternalEngine() {
        assertTrue("Expected at least one warm node in the response", foundWarmNode);
        assertThat(snapResponse.getSnapshotInfo().successfulShards(), equalTo(snapResponse.getSnapshotInfo().totalShards()));
 *  
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;  
            if (!stats.getNode().isWarmNode()) {
        NodesStatsResponse response = client().admin().cluster().nodesStats(request).actionGet();
            .actionGet();
    /**
        indexRandomDocs(indexName, 50);  
 * @opensearch.internal
                .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.FS.getSettingsKey())
        }
 */  
    public void testFileCacheStatsAbsentOnNonWarmNodes() throws Exception {
        settings.put("location", randomRepoPath()).put("compress", randomBoolean());
                assertThat("file_cache total should be >= 0", fileCacheOnly.getTotal().getBytes(), greaterThan(-1L));
                .put(SETTING_NUMBER_OF_REPLICAS, 0)  
    public void testFileCacheStatsWithDetailed() throws Exception {
/**
        internalCluster().ensureAtLeastNumWarmNodes(1);
        for (NodeStats stats : response.getNodes()) {
            .prepareRestoreSnapshot(repoName, snapshotName)
     * Verifies that {@code file_cache} and {@code block_cache} sub-sections are present
        final var snapResponse = client.admin()
     */
                foundWarmNode = true;
import static org.hamcrest.Matchers.notNullValue;
import org.opensearch.transport.client.Client;
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
            .setWaitForCompletion(true)
        assertTrue(client.admin().indices().prepareDelete(indexName).get().isAcknowledged());
import org.opensearch.repositories.fs.FsRepository;
import org.opensearch.snapshots.AbstractSnapshotIntegTestCase;  
        setupWarmNodeWithData();  
        setupWarmNodeWithData();
            }
        internalCluster().ensureAtLeastNumDataNodes(1);
                assertThat("aggregate_file_cache should be present", stats.getFileCacheStats(), notNullValue());
        assertDocCount(indexName + "-copy", 50L);
        // Populate the cache
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)  
            .get();  
                assertThat("block_cache sub-stats should be null without ?detailed", stats.getBlockCacheOnlyStats(), nullValue());  
        final Client client = client();  
import org.opensearch.index.IndexModule;
        final String repoName = "test-repo";
        );
                    nullValue()  
import org.opensearch.action.admin.cluster.node.stats.NodeStats;  
     * {@code file_cache} / {@code block_cache} sub-sections are absent without {@code ?detailed=true}.  
        ensureGreen();
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
import static org.hamcrest.Matchers.nullValue;
                // detailed sections must be absent when fileCacheDetailed=false
                foundWarmNode = true;
                assertThat("aggregate_file_cache should be present on warm node", fcStats, notNullValue());
package org.opensearch.action.admin.cluster.filecache;
                // aggregate_file_cache must still be present
        boolean foundWarmNode = false;
        for (NodeStats stats : response.getNodes()) {  
/*  
    }  
        client.admin()
                    "aggregate_file_cache should be null on non-warm node " + stats.getNode().getName(),
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
            .setIndices(indexName)
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
            indexName,
        createIndex(  
    }
                assertThat("file_cache sub-stats should be null without ?detailed", stats.getFileCacheOnlyStats(), nullValue());
        final Settings.Builder settings = Settings.builder();
 * compatible open source license.
            .execute()  
 * Integration tests for file cache and block cache stats via {@code _nodes/stats/file_cache}.
import static org.hamcrest.Matchers.greaterThan;  
     */  
                );
            .cluster()
                .put(SETTING_NUMBER_OF_SHARDS, 1)
        ensureGreen();
            .setStorageType(RestoreSnapshotRequest.StorageType.REMOTE_SNAPSHOT)
                AggregateFileCacheStats fileCacheOnly = stats.getFileCacheOnlyStats();
    }
 */
    public void testFileCacheStatsWithoutDetailed() throws Exception {
                // (null is valid when no BlockCacheRegistry is registered)
            .fileCacheDetailed(true);
    }
                assertThat("file_cache sub-stats should be present with ?detailed", fileCacheOnly, notNullValue());  
    /**  
        for (NodeStats stats : response.getNodes()) {  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;  
            .setRenamePattern("(.+)")
        NodesStatsResponse response = client().admin().cluster().nodesStats(request).actionGet();  
        return false;
            .prepareCreateSnapshot(repoName, snapshotName)  
    /**
        assertThat(snapResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
import org.opensearch.common.settings.Settings;
     */  
                .build()  
     * Verifies that {@code aggregate_file_cache} is populated on warm nodes and that
        setupWarmNodeWithData();
            .setWaitForCompletion(true)
    @Override  
        return settings;
        boolean foundWarmNode = false;
                AggregateFileCacheStats fcStats = stats.getFileCacheStats();  
        NodesStatsRequest request = new NodesStatsRequest().addMetric(NodesStatsRequest.Metric.FILE_CACHE_STATS.metricName());
                // block_cache sub-stats — only present if a block cache plugin is loaded  
    private void setupWarmNodeWithData() throws Exception {
        ensureGreen();
            .setRenameReplacement("$1-copy")  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
 *
        final String snapshotName = "test-snap";
        }  
            }
     * when {@code ?detailed=true} is requested.
    @Override
        settings.put(FsRepository.BASE_PATH_SETTING.getKey(), "file_cache_stats_it");  
            if (stats.getNode().isWarmNode()) {
            if (stats.getNode().isWarmNode()) {
        NodesStatsRequest request = new NodesStatsRequest().addMetric(NodesStatsRequest.Metric.FILE_CACHE_STATS.metricName());
    }  
 * this file be licensed under the Apache-2.0 license or a
                assertThat("file cache total should be > 0", fcStats.getTotal().getBytes(), greaterThan(0L));
