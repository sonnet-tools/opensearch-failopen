        }
        createIndex(
import org.opensearch.index.IndexModule;
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
            .fileCacheDetailed(true);
        setupWarmNodeWithData();
package org.opensearch.action.admin.cluster.filecache;
    protected boolean addMockInternalEngine() {
            indexName,
     * when {@code ?detailed=true} is requested.
        assertThat(snapResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
        settings.put("location", randomRepoPath()).put("compress", randomBoolean());
    public void testFileCacheStatsAbsentOnNonWarmNodes() throws Exception {
     */
    }
        client.admin()
public class FileCacheStatsIT extends AbstractSnapshotIntegTestCase {
    }
            .cluster()
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
        ensureGreen();
        assertTrue("Expected at least one warm node in the response", foundWarmNode);
            .actionGet();
                assertThat(
        setupWarmNodeWithData();
        final Settings.Builder settings = Settings.builder();
        final var snapResponse = client.admin()
        assertDocCount(indexName + "-copy", 50L);
 */
 *
            .cluster()
    // ── helpers ──────────────────────────────────────────────────────────────
    /**
                .put(SETTING_NUMBER_OF_SHARDS, 1)
        return false;
 * The OpenSearch Contributors require contributions made to
                // (null is valid when no BlockCacheRegistry is registered)
            .setWaitForCompletion(true)
        indexRandomDocs(indexName, 50);
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
                assertThat("file cache total should be > 0", fcStats.getTotal().getBytes(), greaterThan(0L));
            .get();
        final String snapshotName = "test-snap";
        for (NodeStats stats : response.getNodes()) {
            Settings.builder()
            }
            .prepareCreateSnapshot(repoName, snapshotName)
    public void testFileCacheStatsWithDetailed() throws Exception {
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
import org.opensearch.repositories.fs.FsRepository;
    }
 * SPDX-License-Identifier: Apache-2.0
    }
        internalCluster().ensureAtLeastNumWarmNodes(1);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        assertTrue("Expected at least one warm node in the response", foundWarmNode);
        }
        for (NodeStats stats : response.getNodes()) {
    /**
        // Populate the cache
                // aggregate_file_cache must still be present
                assertThat("aggregate_file_cache should be present", stats.getFileCacheStats(), notNullValue());
                // file_cache sub-stats (FileCache-only breakdown)
            .setRenameReplacement("$1-copy")
    public void testFileCacheStatsWithoutDetailed() throws Exception {
        NodesStatsRequest request = new NodesStatsRequest().addMetric(NodesStatsRequest.Metric.FILE_CACHE_STATS.metricName())
        final String repoName = "test-repo";
                // block_cache sub-stats — only present if a block cache plugin is loaded
                assertThat("file_cache sub-stats should be null without ?detailed", stats.getFileCacheOnlyStats(), nullValue());
                    nullValue()
        ensureGreen();
 */
                .build()
            .execute()
            .setWaitForCompletion(true)
        assertThat(snapResponse.getSnapshotInfo().successfulShards(), equalTo(snapResponse.getSnapshotInfo().totalShards()));
        NodesStatsResponse response = client().admin().cluster().nodesStats(request).actionGet();
import static org.hamcrest.Matchers.greaterThan;
 *
        assertTrue(client.admin().indices().prepareDelete(indexName).get().isAcknowledged());
            .prepareRestoreSnapshot(repoName, snapshotName)
import static org.hamcrest.Matchers.nullValue;
/*
     * Verifies that {@code aggregate_file_cache} is populated on warm nodes and that
import org.opensearch.snapshots.AbstractSnapshotIntegTestCase;
        setupWarmNodeWithData();
 * compatible open source license.
                assertThat("file_cache sub-stats should be present with ?detailed", fileCacheOnly, notNullValue());
                assertThat("file_cache total should be >= 0", fileCacheOnly.getTotal().getBytes(), greaterThan(-1L));
            if (stats.getNode().isWarmNode()) {
                foundWarmNode = true;
                assertThat("block_cache sub-stats should be null without ?detailed", stats.getBlockCacheOnlyStats(), nullValue());
        ensureGreen();
import static org.hamcrest.Matchers.equalTo;
        );
                .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.FS.getSettingsKey())
    protected Settings.Builder randomRepositorySettings() {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
/**
                .put(SETTING_NUMBER_OF_REPLICAS, 0)
        final String indexName = "test-idx";
        ensureGreen();
                AggregateFileCacheStats fileCacheOnly = stats.getFileCacheOnlyStats();
                    stats.getFileCacheStats(),
                    "aggregate_file_cache should be null on non-warm node " + stats.getNode().getName(),
     */
            .setRenamePattern("(.+)")
            }
        final Client client = client();
        createRepository(repoName, FsRepository.TYPE);
                // detailed sections must be absent when fileCacheDetailed=false
    /**
     * Verifies that {@code file_cache} and {@code block_cache} sub-sections are present
            if (stats.getNode().isWarmNode()) {
                AggregateFileCacheStats fcStats = stats.getFileCacheStats();
    }
        return settings;
        NodesStatsResponse response = client().admin().cluster().nodesStats(request).actionGet();
 * this file be licensed under the Apache-2.0 license or a
        NodesStatsResponse response = client().admin().cluster().nodesStats(request).actionGet();
}
        settings.put(FsRepository.BASE_PATH_SETTING.getKey(), "file_cache_stats_it");
        NodesStatsRequest request = new NodesStatsRequest().addMetric(NodesStatsRequest.Metric.FILE_CACHE_STATS.metricName());
import org.opensearch.common.settings.Settings;
     * Verifies that non-warm nodes do not carry file cache stats.
 * Integration tests for file cache and block cache stats via {@code _nodes/stats/file_cache}.
        NodesStatsRequest request = new NodesStatsRequest().addMetric(NodesStatsRequest.Metric.FILE_CACHE_STATS.metricName());
    @Override
    @Override
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
    }
        boolean foundWarmNode = false;
    private void setupWarmNodeWithData() throws Exception {
                );
        }
            .setStorageType(RestoreSnapshotRequest.StorageType.REMOTE_SNAPSHOT)
            .setIndices(indexName)
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
import static org.hamcrest.Matchers.notNullValue;
        boolean foundWarmNode = false;
     * {@code file_cache} / {@code block_cache} sub-sections are absent without {@code ?detailed=true}.
        internalCluster().ensureAtLeastNumDataNodes(1);
            }
import org.opensearch.transport.client.Client;
        for (NodeStats stats : response.getNodes()) {
            if (!stats.getNode().isWarmNode()) {
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
 * @opensearch.internal
                foundWarmNode = true;
                assertThat("aggregate_file_cache should be present on warm node", fcStats, notNullValue());
     */
