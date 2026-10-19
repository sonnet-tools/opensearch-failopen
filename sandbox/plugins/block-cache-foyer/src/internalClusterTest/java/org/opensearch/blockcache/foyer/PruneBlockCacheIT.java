            .cluster()  
                foundWarmNode = true;
@ThreadLeakFilters(filters = PruneBlockCacheIT.IndexInputCleanerFilter.class)
        return false;
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;  
                assertNotNull("block_cache sub-stats should be present on warm node with Foyer loaded", blockCacheStats);  
import org.opensearch.transport.client.Client;  
                .put(SETTING_NUMBER_OF_SHARDS, 1)
    }
        return List.of(BlockCacheFoyerPlugin.class);
import org.opensearch.action.support.PlainActionFuture;  
        client.admin()
 * @opensearch.internal
        PruneBlockCacheRequest pruneRequest = new PruneBlockCacheRequest();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;  
        assertThat(snapResponse.getSnapshotInfo().successfulShards(), greaterThan(0));  
    /** Suppresses the JVM Cleaner daemon thread spawned by OnDemandBlockSnapshotIndexInput. */
        final String repoName = "test-repo";
        assertDocCount(restoredIndexName, 50L);
        // Call POST /_blockcache/prune  
        }
        NodesStatsResponse statsResponse = client.admin()
        // Trigger reads to populate the block cache  
 * The OpenSearch Contributors require contributions made to  
 *
            }  
        public boolean reject(Thread t) {
            .cluster()
        // Verify response  
            .prepareRestoreSnapshot(repoName, snapshotName)  
            .get();
        // Cluster must still be healthy and queries must still work after prune
        assertTrue(client.admin().indices().prepareDelete(indexName).get().isAcknowledged());  
        assertNotNull("Response should not be null", response);
    protected Settings nodeSettings(int nodeOrdinal) {
        final var snapResponse = client.admin()
            .setStorageType(RestoreSnapshotRequest.StorageType.REMOTE_SNAPSHOT)  
        return Settings.builder()  
package org.opensearch.blockcache.foyer;
        assertDocCount(indexName + "-copy", 50L);  
 * SPDX-License-Identifier: Apache-2.0
import java.util.Collection;
import org.opensearch.action.admin.cluster.blockcache.PruneBlockCacheResponse;
 * Verifies that the API clears the Foyer block cache on warm nodes without crashing the cluster.  
    }  
/*  
        final String snapshotName = "test-snap";
        ensureGreen();
            .cluster()
        createRepository(repoName, FsRepository.TYPE);  
     * returns cleared=true, and leaves the cluster healthy with queries still working.
 */  
            .setWaitForCompletion(true)
        boolean foundWarmNode = false;
                .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.FS.getSettingsKey())
    }
import org.opensearch.plugins.BlockCacheStats;
            Settings.builder()
        for (NodeStats stats : statsResponse.getNodes()) {
        assertEquals("Should target 1 warm node", 1, response.getNodes().size());  
        client.execute(PruneBlockCacheAction.INSTANCE, pruneRequest, future);  
            .actionGet();
        final Client client = client();
            indexName,
        final Client client = client();  
        NodePruneBlockCacheResponse nodeResponse = response.getNodes().get(0);
        internalCluster().ensureAtLeastNumWarmNodes(1);
        PruneBlockCacheResponse response = future.actionGet();
    }  
        client.admin()
        final String indexName = "test-idx";
            return t.getName().startsWith("index-input-cleaner");
import org.opensearch.index.IndexModule;  
import org.opensearch.plugins.Plugin;  
                assertTrue("block_cache totalBytes should be >= 0", blockCacheStats.totalBytes() >= 0);
            .setIndices(indexName)
            .put("compress", randomBoolean())
                .put(SETTING_NUMBER_OF_REPLICAS, 0)
        createIndex(  
            .prepareCreateSnapshot(repoName, snapshotName)  
        ensureGreen();
        internalCluster().ensureAtLeastNumDataNodes(1);
     * Verifies that {@code GET _nodes/stats/file_cache?detailed=true} returns a non-null
            .prepareRestoreSnapshot(repoName, snapshotName)
                .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.FS.getSettingsKey())
import static org.hamcrest.Matchers.equalTo;
        assertThat(snapResponse.getSnapshotInfo().successfulShards(), equalTo(snapResponse.getSnapshotInfo().totalShards()));
    /**
     * Verifies that POST /_blockcache/prune succeeds on a warm node with Foyer loaded,  
            .setStorageType(RestoreSnapshotRequest.StorageType.REMOTE_SNAPSHOT)
            if (stats.getNode().isWarmNode()) {  
import org.opensearch.action.admin.cluster.blockcache.PruneBlockCacheAction;
    }
        assertTrue("Expected at least one warm node", foundWarmNode);
    protected Settings.Builder randomRepositorySettings() {
                // totalBytes reflects the configured Foyer disk budget
     */
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
            .setWaitForCompletion(true)
            .put(FsRepository.BASE_PATH_SETTING.getKey(), "block_cache_prune_it");
import static org.hamcrest.Matchers.greaterThan;
 * this file be licensed under the Apache-2.0 license or a
                .put(SETTING_NUMBER_OF_REPLICAS, 0)  
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
    public void testPruneBlockCacheDoesNotCrashCluster() throws Exception {  
public class PruneBlockCacheIT extends AbstractSnapshotIntegTestCase {
        ensureGreen();
            .prepareCreateSnapshot(repoName, snapshotName)
 */  
                .build()
            // Enable Foyer via node settings (FeatureFlags.initFromSettings bypasses
            .get();  
        createIndex(
import org.opensearch.common.util.FeatureFlags;
            .cluster()  
        ensureGreen();
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
import org.opensearch.action.admin.cluster.blockcache.PruneBlockCacheRequest;  
            .actionGet();
        final var snapResponse = client.admin()  
        internalCluster().ensureAtLeastNumWarmNodes(1);  
            .setWaitForCompletion(true)
            .nodesStats(new NodesStatsRequest().addMetric(NodesStatsRequest.Metric.FILE_CACHE_STATS.metricName()).fileCacheDetailed(true))
        }  
     */
        ensureGreen();  
    @Override
        assertThat(snapResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
        );
        final String snapshotName = "test-snap";
        ensureGreen();
 * compatible open source license.
/**
 *
        ensureGreen();
    protected boolean addMockInternalEngine() {  
    @Override  
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), "2gb")
        indexRandomDocs(indexName, 50);  
import org.opensearch.repositories.fs.FsRepository;
    @Override  
    @Override
        indexRandomDocs(indexName, 50);
            .setRenameReplacement("$1-copy")
        );  
            .put(super.nodeSettings(nodeOrdinal))
        internalCluster().ensureAtLeastNumDataNodes(1);
import org.opensearch.common.settings.Settings;
            .setRenameReplacement("$1-copy")  
        return Settings.builder()
            indexName,  
            .setRenamePattern("(.+)")
        final String restoredIndexName = indexName + "-copy";
            .setRenamePattern("(.+)")
            // the security manager that blocks System.getProperty in internalClusterTests).  
        @Override  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .execute()  
    }
        assertTrue("Block cache should be cleared", nodeResponse.isCleared());  
        assertDocCount(restoredIndexName, 50L);
import org.opensearch.snapshots.AbstractSnapshotIntegTestCase;
        assertEquals("Should have no failures", 0, response.failures().size());
        final String repoName = "test-repo";  
            .build();  
import org.opensearch.node.Node;
import java.util.List;  
            Settings.builder()
import com.carrotsearch.randomizedtesting.ThreadFilter;
 * Integration tests for the block cache prune API ({@code POST /_blockcache/prune}).
        assertThat(snapResponse.getSnapshotInfo().successfulShards(), equalTo(snapResponse.getSnapshotInfo().totalShards()));
                .put(SETTING_NUMBER_OF_SHARDS, 1)  
            .setIndices(indexName)
        assertTrue(client.admin().indices().prepareDelete(indexName).get().isAcknowledged());
                .build()  
}
    }  
            .put("location", randomRepoPath())  
        final String indexName = "test-idx";  
            .actionGet();  
            .cluster()
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
            .execute()
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
    public static final class IndexInputCleanerFilter implements ThreadFilter {
        createRepository(repoName, FsRepository.TYPE);
        PlainActionFuture<PruneBlockCacheResponse> future = new PlainActionFuture<>();
        ensureGreen();  
    public void testBlockCacheStatsDetailedWithFoyerPlugin() throws Exception {
                BlockCacheStats blockCacheStats = stats.getBlockCacheOnlyStats();
import org.opensearch.action.admin.cluster.blockcache.NodePruneBlockCacheResponse;
            .setWaitForCompletion(true)  
        ensureGreen();
    /**
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
     * {@code block_cache} section on warm nodes when the Foyer plugin is loaded.  
