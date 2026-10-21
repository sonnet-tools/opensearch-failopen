        );
        internalCluster().ensureAtLeastNumWarmNodes(1);
        internalCluster().ensureAtLeastNumDataNodes(1);
        ensureGreen();
    }
     */
    public void testPruneBlockCacheDoesNotCrashCluster() throws Exception {
    }
        }
        assertThat(snapResponse.getSnapshotInfo().successfulShards(), equalTo(snapResponse.getSnapshotInfo().totalShards()));
     * Verifies that POST /_blockcache/prune succeeds on a warm node with Foyer loaded,
            // the security manager that blocks System.getProperty in internalClusterTests).
import org.opensearch.plugins.Plugin;
    public static final class IndexInputCleanerFilter implements ThreadFilter {
        ensureGreen();
 * The OpenSearch Contributors require contributions made to
                .build()
        return List.of(BlockCacheFoyerPlugin.class);
            .setRenameReplacement("$1-copy")
            .setWaitForCompletion(true)
     */
            .setIndices(indexName)
 *
        final String restoredIndexName = indexName + "-copy";
    @Override
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
import java.util.Collection;
        final String indexName = "test-idx";
            .get();
            .actionGet();
import org.opensearch.snapshots.AbstractSnapshotIntegTestCase;
            .actionGet();
        return false;
                .put(SETTING_NUMBER_OF_REPLICAS, 0)
        assertTrue(client.admin().indices().prepareDelete(indexName).get().isAcknowledged());
        createIndex(
        ensureGreen();
        assertThat(snapResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
            .setStorageType(RestoreSnapshotRequest.StorageType.REMOTE_SNAPSHOT)
        final Client client = client();
            Settings.builder()
     * {@code block_cache} section on warm nodes when the Foyer plugin is loaded.
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        boolean foundWarmNode = false;
 * Verifies that the API clears the Foyer block cache on warm nodes without crashing the cluster.
    /**
    public void testBlockCacheStatsDetailedWithFoyerPlugin() throws Exception {
        final String snapshotName = "test-snap";
    @Override
/*
    protected Settings nodeSettings(int nodeOrdinal) {
    }
import org.opensearch.action.admin.cluster.blockcache.PruneBlockCacheRequest;
        return Settings.builder()
        PlainActionFuture<PruneBlockCacheResponse> future = new PlainActionFuture<>();
        final String snapshotName = "test-snap";
}
package org.opensearch.blockcache.foyer;
        client.admin()
        }
 * compatible open source license.
        ensureGreen();
        final String indexName = "test-idx";
import org.opensearch.action.support.PlainActionFuture;
            .put(super.nodeSettings(nodeOrdinal))
            .prepareRestoreSnapshot(repoName, snapshotName)
     * Verifies that {@code GET _nodes/stats/file_cache?detailed=true} returns a non-null
                .put(SETTING_NUMBER_OF_SHARDS, 1)
    protected boolean addMockInternalEngine() {
            indexName,
/**
            .setRenamePattern("(.+)")
        assertDocCount(restoredIndexName, 50L);
        internalCluster().ensureAtLeastNumWarmNodes(1);
        indexRandomDocs(indexName, 50);
 *
            .prepareRestoreSnapshot(repoName, snapshotName)
                .put(SETTING_NUMBER_OF_REPLICAS, 0)
        assertEquals("Should have no failures", 0, response.failures().size());
            Settings.builder()
    /**
        ensureGreen();
            .cluster()
import org.opensearch.node.Node;
                // totalBytes reflects the configured Foyer disk budget
    }
            // Enable Foyer via node settings (FeatureFlags.initFromSettings bypasses
            .nodesStats(new NodesStatsRequest().addMetric(NodesStatsRequest.Metric.FILE_CACHE_STATS.metricName()).fileCacheDetailed(true))
            .setStorageType(RestoreSnapshotRequest.StorageType.REMOTE_SNAPSHOT)
        final String repoName = "test-repo";
            .setWaitForCompletion(true)
        assertThat(snapResponse.getSnapshotInfo().successfulShards(), equalTo(snapResponse.getSnapshotInfo().totalShards()));
        assertTrue("Expected at least one warm node", foundWarmNode);
        // Trigger reads to populate the block cache
            .setRenamePattern("(.+)")
        assertTrue("Block cache should be cleared", nodeResponse.isCleared());
                BlockCacheStats blockCacheStats = stats.getBlockCacheOnlyStats();
import org.opensearch.action.admin.cluster.blockcache.NodePruneBlockCacheResponse;
        ensureGreen();
            return t.getName().startsWith("index-input-cleaner");
    /** Suppresses the JVM Cleaner daemon thread spawned by OnDemandBlockSnapshotIndexInput. */
import org.opensearch.common.util.FeatureFlags;
            .prepareCreateSnapshot(repoName, snapshotName)
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        // Call POST /_blockcache/prune
                .put(SETTING_NUMBER_OF_SHARDS, 1)
            .setIndices(indexName)
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .put("location", randomRepoPath())
        ensureGreen();
import org.opensearch.action.admin.cluster.blockcache.PruneBlockCacheResponse;
        assertDocCount(restoredIndexName, 50L);
    }
 * @opensearch.internal
                .build()
        assertEquals("Should target 1 warm node", 1, response.getNodes().size());
import org.opensearch.common.settings.Settings;
            .cluster()
                .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.FS.getSettingsKey())
            .actionGet();
        assertDocCount(indexName + "-copy", 50L);
        return Settings.builder()
            .setWaitForCompletion(true)
            if (stats.getNode().isWarmNode()) {
public class PruneBlockCacheIT extends AbstractSnapshotIntegTestCase {
        final var snapResponse = client.admin()
        final Client client = client();
        indexRandomDocs(indexName, 50);
import org.opensearch.index.IndexModule;
        client.execute(PruneBlockCacheAction.INSTANCE, pruneRequest, future);
import org.opensearch.transport.client.Client;
            .put(FsRepository.BASE_PATH_SETTING.getKey(), "block_cache_prune_it");
                .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.FS.getSettingsKey())
        assertTrue(client.admin().indices().prepareDelete(indexName).get().isAcknowledged());
        assertNotNull("Response should not be null", response);
 * SPDX-License-Identifier: Apache-2.0
    @Override
            }
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
        // Verify response
        assertThat(snapResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
@ThreadLeakFilters(filters = PruneBlockCacheIT.IndexInputCleanerFilter.class)
        client.admin()
import org.opensearch.repositories.fs.FsRepository;
            .execute()
        NodePruneBlockCacheResponse nodeResponse = response.getNodes().get(0);
 */
    @Override
        PruneBlockCacheResponse response = future.actionGet();
        PruneBlockCacheRequest pruneRequest = new PruneBlockCacheRequest();
        createRepository(repoName, FsRepository.TYPE);
        internalCluster().ensureAtLeastNumDataNodes(1);
                assertNotNull("block_cache sub-stats should be present on warm node with Foyer loaded", blockCacheStats);
        for (NodeStats stats : statsResponse.getNodes()) {
import static org.hamcrest.Matchers.equalTo;
        final var snapResponse = client.admin()
     * returns cleared=true, and leaves the cluster healthy with queries still working.
            .get();
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
        );
        createRepository(repoName, FsRepository.TYPE);
            .cluster()
            .execute()
            .prepareCreateSnapshot(repoName, snapshotName)
import org.opensearch.action.admin.cluster.blockcache.PruneBlockCacheAction;
    }
                assertTrue("block_cache totalBytes should be >= 0", blockCacheStats.totalBytes() >= 0);
        createIndex(
            indexName,
            .build();
            .cluster()
            .setRenameReplacement("$1-copy")
        final String repoName = "test-repo";
        NodesStatsResponse statsResponse = client.admin()
    }
        public boolean reject(Thread t) {
        // Cluster must still be healthy and queries must still work after prune
import org.opensearch.plugins.BlockCacheStats;
        ensureGreen();
            .setWaitForCompletion(true)
            .put("compress", randomBoolean())
        @Override
import java.util.List;
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
    protected Settings.Builder randomRepositorySettings() {
 * Integration tests for the block cache prune API ({@code POST /_blockcache/prune}).
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), "2gb")
                foundWarmNode = true;
 */
import static org.hamcrest.Matchers.greaterThan;
 * this file be licensed under the Apache-2.0 license or a
import com.carrotsearch.randomizedtesting.ThreadFilter;
            .cluster()
        ensureGreen();
