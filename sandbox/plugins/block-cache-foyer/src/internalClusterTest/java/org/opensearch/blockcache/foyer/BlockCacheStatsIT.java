}
        setupWarmNodeWithData(client);  
        internalCluster().ensureAtLeastNumWarmNodes(1);  
 *
            Settings.builder()
        createRepository(repoName, FsRepository.TYPE);
            .actionGet();
        assertDocCount(indexName + "-copy", 50L);
            .cluster()  
            // the security manager that blocks System.getProperty in internalClusterTests).
        final String snapshotName = "test-snap";
 * warm nodes when a {@code BlockCacheRegistry} is registered by the plugin.
            .get();
                .build()
import org.opensearch.common.settings.Settings;
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
     * </ul>
        client.admin()
import org.opensearch.plugins.Plugin;
        final Client client = client();
            .put(super.nodeSettings(nodeOrdinal))
 * SPDX-License-Identifier: Apache-2.0
                AggregateFileCacheStats aggregateStats = stats.getFileCacheStats();  
    }
import org.opensearch.node.Node;  
        ensureGreen();
import static org.hamcrest.Matchers.notNullValue;
        createIndex(
        return List.of(BlockCacheFoyerPlugin.class);  
    @Override
    private void setupWarmNodeWithData(Client client) throws Exception {
        final String repoName = "test-repo";
    @Override
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), "2gb")  
     */  
        for (NodeStats stats : response.getNodes()) {
    @Override
                .put(SETTING_NUMBER_OF_SHARDS, 1)  
            // Enable Foyer via node settings (FeatureFlags.initFromSettings bypasses  
            .prepareRestoreSnapshot(repoName, snapshotName)  
    }  
import static org.hamcrest.Matchers.greaterThan;
    }
import org.opensearch.plugins.BlockCacheStats;
package org.opensearch.blockcache.foyer;
            .put(FsRepository.BASE_PATH_SETTING.getKey(), "block_cache_stats_it");  
            .cluster()
                .put(SETTING_NUMBER_OF_REPLICAS, 0)
 */
import static org.hamcrest.Matchers.equalTo;  
/*  
            indexName,  
    public void testDetailedStatsIncludeBlockCacheWithFoyerPlugin() throws Exception {
        );  
    protected boolean addMockInternalEngine() {
/**
        return Settings.builder()
            .setRenameReplacement("$1-copy")
        ensureGreen();
            .nodesStats(new NodesStatsRequest().addMetric(NodesStatsRequest.Metric.FILE_CACHE_STATS.metricName()).fileCacheDetailed(true))
import org.opensearch.common.util.FeatureFlags;  
                .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.FS.getSettingsKey())
        return false;
        }
 * Integration tests for {@code GET _nodes/stats/file_cache?detailed=true} with the Foyer
import org.opensearch.snapshots.AbstractSnapshotIntegTestCase;
    protected Settings.Builder randomRepositorySettings() {
import com.carrotsearch.randomizedtesting.ThreadFilter;
import org.opensearch.repositories.fs.FsRepository;  
            .actionGet();  
 * this file be licensed under the Apache-2.0 license or a
    @Override  
                assertThat("block_cache sub-stats should be present when Foyer plugin is loaded", blockCacheStats, notNullValue());
            .setWaitForCompletion(true)  
import org.opensearch.transport.client.Client;
        NodesStatsResponse response = client.admin()
        assertTrue("Expected at least one warm node", foundWarmNode);
        assertThat(snapResponse.getSnapshotInfo().successfulShards(), equalTo(snapResponse.getSnapshotInfo().totalShards()));
    }  
    }  
        final var snapResponse = client.admin()  
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;  
        return Settings.builder()  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
 * compatible open source license.
        indexRandomDocs(indexName, 50);
 * block cache plugin loaded. Verifies that {@code block_cache} sub-stats are populated on  
    /** Suppresses the JVM Cleaner daemon thread spawned by OnDemandBlockSnapshotIndexInput. */
     * <ul>
import org.opensearch.index.IndexModule;
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
 * @opensearch.internal  
 */  
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
import java.util.Collection;
        }
            if (stats.getNode().isWarmNode()) {  
    }
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .setIndices(indexName)
        ensureGreen();  
public class BlockCacheStatsIT extends AbstractSnapshotIntegTestCase {  
            .setRenamePattern("(.+)")
        assertThat(snapResponse.getSnapshotInfo().successfulShards(), greaterThan(0));  
 * The OpenSearch Contributors require contributions made to  
 *
    /**  
    protected Settings nodeSettings(int nodeOrdinal) {  
            }  
            .put("compress", randomBoolean())
        public boolean reject(Thread t) {
            .prepareCreateSnapshot(repoName, snapshotName)
        boolean foundWarmNode = false;
     * Verifies that with {@code ?detailed=true}:
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
                BlockCacheStats blockCacheStats = stats.getBlockCacheOnlyStats();  
@ThreadLeakFilters(filters = BlockCacheStatsIT.IndexInputCleanerFilter.class)
    public static final class IndexInputCleanerFilter implements ThreadFilter {  
import java.util.List;
            .setWaitForCompletion(true)
        ensureGreen();
     *   <li>{@code block_cache} sub-stats are non-null (Foyer registers a BlockCacheRegistry)</li>
                assertThat("aggregate_file_cache should be present", aggregateStats, notNullValue());
    }
     *   <li>{@code aggregate_file_cache} is present on warm nodes</li>  
            .build();
            .put("location", randomRepoPath())
        final String indexName = "test-idx";  
        @Override
        assertTrue(client.admin().indices().prepareDelete(indexName).get().isAcknowledged());  
            .execute()
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
        internalCluster().ensureAtLeastNumDataNodes(1);
                assertTrue("block_cache totalBytes should be >= 0", blockCacheStats.totalBytes() >= 0);
            return t.getName().startsWith("index-input-cleaner");  
                foundWarmNode = true;
            .cluster()
            .setStorageType(RestoreSnapshotRequest.StorageType.REMOTE_SNAPSHOT)  
