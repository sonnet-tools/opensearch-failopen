import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
            createRepository(repoName, FsRepository.TYPE, repositorySettings);
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
    /**
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
            .get();
        PlainActionFuture<PruneFileCacheResponse> future = new PlainActionFuture<>();
    }
        assertThat("There must be prunable data in the cache", usageBefore.active, lessThan(usageBefore.used));
        logger.info("--> File cache used before prune: {}", usageBefore);  
            .actionGet();
import org.opensearch.action.admin.cluster.node.stats.NodeStats;  
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);  
        assertBusy(() -> {  
     */  
    }  
        logger.info("--> Create index with documents on data node");
    private void takeSnapshot(Client client, String snapshotName, String repoName, String... indices) {
        logger.info("--> Prune response: pruned {} bytes from {} nodes", response.getTotalPrunedBytes(), response.getNodes().size());  
        createIndexWithDocsAndEnsureGreen(0, 100, indexName);
            .execute()  
        }, 30, TimeUnit.SECONDS);  
        client.execute(PruneFileCacheAction.INSTANCE, request, future);  
        assertTrue("Should have pruned bytes", response.getTotalPrunedBytes() > 0);
import org.opensearch.repositories.fs.FsRepository;  
            .setIndices(indices)
        final String snapshotName = "test-snap";  
     * Restores snapshot as searchable snapshot and ensures cluster health is green.
        assertBusy(() -> {
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        assertEquals("Should have 0 failures", 0, response.failures().size());  
            .setWaitForCompletion(true)  
        if (repositorySettings == null) {
        PruneFileCacheResponse response = future.actionGet();
            System.gc();
        ensureGreen();
        NodePruneFileCacheResponse nodeResponse = response.getNodes().get(0);  
            assertTrue("Cache should be populated", usage > 0);
        // The key assertion: pruned bytes should be > 0 (proves API actually worked)  
     * Tests file cache pruning with real data on single warm node.
 */
        settings.put(FsRepository.BASE_PATH_SETTING.getKey(), "file_cache_prune_it");  
        NodesStatsResponse response = client.admin().cluster().nodesStats(new NodesStatsRequest().all()).actionGet();
            indexName,  
                    totalUsage += fcStats.getUsed().getBytes();  
    record CacheUsage(long used, long active) {  
        takeSnapshot(client, snapshotName, repoName, indexName);
/**  
/*  
    /**  
    private void restoreSnapshotAndEnsureGreen(Client client, String snapshotName, String repoName) {
        final Settings.Builder settings = Settings.builder();
                .put(SETTING_NUMBER_OF_REPLICAS, numReplicas)
        logger.info("--> Trigger cache population by running multiple queries");
    }  
        assertEquals("Should have no failures", 0, response.failures().size());
                .build()
 * SPDX-License-Identifier: Apache-2.0
        final Client client = client();  
        PruneFileCacheResponse response = future.actionGet();
            long usage = getFileCacheUsage(client).used();
        internalCluster().ensureAtLeastNumWarmNodes(1);
        }
        internalCluster().ensureAtLeastNumDataNodes(1);  
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)  
        assertNotNull("Response should not be null", response);  
            .setRenameReplacement("$1-copy")  
    private void assertRemoteSnapshotIndexSettings(Client client, String... indexNames) {
public class PruneFileCacheIT extends AbstractSnapshotIntegTestCase {
    /**
        var settingsResponse = client.admin().indices().prepareGetSettings(indexNames).execute().actionGet();  
     */
 * compatible open source license.
        assertRemoteSnapshotIndexSettings(client, restoredIndexName);
    }  
        final String repoName = "test-repo";
 * Integration tests for File Cache Prune API.
    protected boolean addMockInternalEngine() {
        // Run multiple queries to ensure cache is populated
        PlainActionFuture<PruneFileCacheResponse> future = new PlainActionFuture<>();
import static org.hamcrest.Matchers.greaterThan;  
        return settings;
            .cluster()
     */
     * Tests prune API response structure and metrics validation.  
            }  
    }
        assertEquals("Response should match actual cache reduction", expectedPruned, response.getTotalPrunedBytes());
            assertThat("There must be prunable data in the cache", usage.active, lessThan(usage.used));
    private void createRepositoryWithSettings(Settings.Builder repositorySettings, String repoName) {  
    /**
        internalCluster().ensureAtLeastNumDataNodes(1);
        assertEquals("Should have 1 successful node", 1, response.getNodes().size());
        createIndexWithDocsAndEnsureGreen(0, 100, indexName);
        for (int i = 0; i < 3; i++) {  
        client.execute(PruneFileCacheAction.INSTANCE, request, future);  
        return new CacheUsage(totalUsage, totalActiveUsage);
     * Validates that indices are configured as remote snapshot type.  
import org.opensearch.index.IndexModule;  
        ensureGreen();
    }
        final String indexName = "test-idx";
        createRepositoryWithSettings(null, repoName);
    }
    /**
        }
    }
        assertTrue("Should be successful", response.isCompletelySuccessful());
     * Creates snapshot and validates success.  
        assertTrue("Node should report pruned bytes", nodeResponse.getPrunedBytes() >= 0);  
     * Deletes indices and ensures cluster health is green.  
        // Verify response first - this is the key assertion
     */  
        logger.info("--> Setup simple scenario to test API response metrics");  
        long usageBefore = getFileCacheUsage(client).used();
            .setStorageType(RestoreSnapshotRequest.StorageType.REMOTE_SNAPSHOT)
        assertTrue("Should report acknowledged", response.isAcknowledged());
        internalCluster().ensureAtLeastNumWarmNodes(1);  
            .prepareCreateSnapshot(repoName, snapshotName)
        long usageAfter = getFileCacheUsage(client).used();
        settings.put("location", randomRepoPath()).put("compress", randomBoolean());
            .setRenamePattern("(.+)")
        for (NodeStats stats : response.getNodes()) {
            createRepository(repoName, FsRepository.TYPE);
        );  
 * @opensearch.internal
        assertTrue("Cache used should be reduced after prune", usageAfter <= usageBefore.used());
        assertRemoteSnapshotIndexSettings(client, restoredIndexName);
        }, 30, TimeUnit.SECONDS);  
    private void deleteIndicesAndEnsureGreen(Client client, String... indices) {
        ensureGreen();
        final String repoName = "test-repo";
        }
            // which indicates that files are available to be pruned
        assertDocCount(restoredIndexName, 100L);
        final var response = client.admin()  
        assertTrue(client.admin().indices().prepareDelete(indices).get().isAcknowledged());  
            if (stats.getNode().isWarmNode()) {  
        logger.info("--> Actual cache reduction: {} bytes, reported pruned: {} bytes", actualReduction, response.getTotalPrunedBytes());  
import org.opensearch.transport.client.Client;
        logger.info("--> File cache used after prune: {} bytes", usageAfter);
     */  
    @Override
import java.util.concurrent.TimeUnit;
        } else {  
        CacheUsage usageBefore = getFileCacheUsage(client);
        long totalActiveUsage = 0L;
    }  
    public void testPruneResponseMetrics() throws Exception {
        long totalUsage = 0L;  
package org.opensearch.action.admin.cluster.filecache;
                .put(SETTING_NUMBER_OF_SHARDS, 1)  
        assertTrue("Node should have cache capacity", nodeResponse.getCacheCapacity() > 0);
    @Override  
    }
    public void testPruneCacheWithRealData() throws Exception {
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
        client.admin()
        assertTrue("Operation should be successful", response.isCompletelySuccessful());  
    /**
                if (fcStats != null) {
 *  
 * Validates cache pruning with real data in cluster environment.
        ensureGreen();  
        assertEquals("Should target 1 warm node", 1, response.getNodes().size());
                settingsResponse.getSetting(indexName, IndexModule.INDEX_STORE_TYPE_SETTING.getKey())
        final String snapshotName = "test-snap";
        long actualReduction = usageBefore.used() - usageAfter;
                }
        final String restoredIndexName = indexName + "-copy";
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
        assertNotNull("Response should not be null", response);  
            assertEquals(
            .setWaitForCompletion(true)
    protected Settings.Builder randomRepositorySettings() {  
                    totalActiveUsage += fcStats.getActive().getBytes();
import org.opensearch.common.settings.Settings;
                .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.FS.getSettingsKey())
}
import org.opensearch.snapshots.AbstractSnapshotIntegTestCase;
    private void createIndexWithDocsAndEnsureGreen(int numReplicas, int numDocs, String indexName) throws InterruptedException {
        for (String indexName : indexNames) {
                IndexModule.Type.REMOTE_SNAPSHOT.getSettingsKey(),  
        deleteIndicesAndEnsureGreen(client, indexName);  
        // Verify cache used after prune  
     */
        deleteIndicesAndEnsureGreen(client, indexName);  
            // so try to force GC and poll until active usage is less than total usage,  
        return false;
        logger.info("--> Populate cache and measure before state");  
import org.opensearch.action.support.PlainActionFuture;
        assertThat(response.getSnapshotInfo().successfulShards(), equalTo(response.getSnapshotInfo().totalShards()));
        assertNotNull("Node response should not be null", nodeResponse);
     */
            );
        assertTrue("Operation should be acknowledged", response.isAcknowledged());
            CacheUsage usage = getFileCacheUsage(client);  
import static org.hamcrest.Matchers.equalTo;
        assertThat("Cache should be populated after index access", usageBefore.used, greaterThan(0L));
        long expectedPruned = usageBefore - usageAfter;  
            .prepareRestoreSnapshot(repoName, snapshotName)
 *
        PruneFileCacheRequest request = new PruneFileCacheRequest();
    /**
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;  
import static org.hamcrest.Matchers.lessThan;
 */  
    }  
        PruneFileCacheRequest request = new PruneFileCacheRequest();
        final String restoredIndexName = indexName + "-copy";  
    private CacheUsage getFileCacheUsage(Client client) {  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;  
 * this file be licensed under the Apache-2.0 license or a
        final Client client = client();
        takeSnapshot(client, snapshotName, repoName, indexName);
        createRepositoryWithSettings(null, repoName);
            .cluster()  
        assertEquals(indexNames.length, settingsResponse.getIndexToSettings().keySet().size());
        }  
        assertThat(response.getSnapshotInfo().successfulShards(), greaterThan(0));
        logger.info("--> Create repository and take snapshot");  
        long usageAfter = getFileCacheUsage(client).used();
     */
     * Creates snapshot repository with optional custom settings.
            // Cloned IndexInputs can hold file cache references until they are GC'd
            assertThat("Cache should be populated after index access", usage.used, greaterThan(0L));
        createIndex(
 * The OpenSearch Contributors require contributions made to  
        final String indexName = "test-idx";  
        // Cache should be reduced (might not be zero if files are still referenced)
        assertDocCount(restoredIndexName, 100L);
            assertDocCount(restoredIndexName, 100L);
        indexRandomDocs(indexName, numDocs);
     * Creates index with documents and ensures cluster health is green.
        logger.info("--> Start warm node and restore as searchable snapshot");
    /**
        // The pruned bytes should roughly match the reduction
    }  
            Settings.builder()
                AggregateFileCacheStats fcStats = stats.getFileCacheStats();
