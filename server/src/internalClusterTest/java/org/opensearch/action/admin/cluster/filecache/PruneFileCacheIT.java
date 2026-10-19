        // Verify cache used after prune
            .setRenameReplacement("$1-copy")
            if (stats.getNode().isWarmNode()) {
            // which indicates that files are available to be pruned
        }
                .put(SETTING_NUMBER_OF_REPLICAS, numReplicas)
    }
        final String restoredIndexName = indexName + "-copy";
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
        final String repoName = "test-repo";
import org.opensearch.common.settings.Settings;
                .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.FS.getSettingsKey())
     * Tests prune API response structure and metrics validation.
    @Override
        PruneFileCacheResponse response = future.actionGet();
                .build()
        // Cache should be reduced (might not be zero if files are still referenced)
    protected Settings.Builder randomRepositorySettings() {
        PlainActionFuture<PruneFileCacheResponse> future = new PlainActionFuture<>();
 * SPDX-License-Identifier: Apache-2.0
            .actionGet();
     */
        assertDocCount(restoredIndexName, 100L);
        assertTrue("Should have pruned bytes", response.getTotalPrunedBytes() > 0);
            System.gc();
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
    }
        logger.info("--> Populate cache and measure before state");
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
    public void testPruneCacheWithRealData() throws Exception {
                AggregateFileCacheStats fcStats = stats.getFileCacheStats();
        ensureGreen();
    }
        logger.info("--> File cache used after prune: {} bytes", usageAfter);
 */
    }
        assertEquals("Should target 1 warm node", 1, response.getNodes().size());
        final Client client = client();
        assertRemoteSnapshotIndexSettings(client, restoredIndexName);
        final String snapshotName = "test-snap";
     * Tests file cache pruning with real data on single warm node.
        createRepositoryWithSettings(null, repoName);
     * Creates index with documents and ensures cluster health is green.
            .setStorageType(RestoreSnapshotRequest.StorageType.REMOTE_SNAPSHOT)
        assertTrue("Node should have cache capacity", nodeResponse.getCacheCapacity() > 0);
            .setWaitForCompletion(true)
        internalCluster().ensureAtLeastNumDataNodes(1);
    }
            .cluster()
        logger.info("--> Setup simple scenario to test API response metrics");
        final String restoredIndexName = indexName + "-copy";
    /**
        ensureGreen();
        long totalUsage = 0L;
    /**
        }
        var settingsResponse = client.admin().indices().prepareGetSettings(indexNames).execute().actionGet();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
            .setIndices(indices)
 * The OpenSearch Contributors require contributions made to
    /**
        return false;
        client.execute(PruneFileCacheAction.INSTANCE, request, future);
     */
            .prepareCreateSnapshot(repoName, snapshotName)
        );
        long usageAfter = getFileCacheUsage(client).used();
     */
     * Validates that indices are configured as remote snapshot type.
        final String indexName = "test-idx";
        logger.info("--> Prune response: pruned {} bytes from {} nodes", response.getTotalPrunedBytes(), response.getNodes().size());
        return settings;
        for (int i = 0; i < 3; i++) {
        settings.put("location", randomRepoPath()).put("compress", randomBoolean());
    }
    /**
 *
        if (repositorySettings == null) {
        }
        internalCluster().ensureAtLeastNumWarmNodes(1);
    }
    /**
    @Override
     * Deletes indices and ensures cluster health is green.
        internalCluster().ensureAtLeastNumWarmNodes(1);
            assertThat("Cache should be populated after index access", usage.used, greaterThan(0L));
     * Restores snapshot as searchable snapshot and ensures cluster health is green.
        long usageAfter = getFileCacheUsage(client).used();
import java.util.concurrent.TimeUnit;
        return new CacheUsage(totalUsage, totalActiveUsage);
        assertTrue("Operation should be successful", response.isCompletelySuccessful());
 * Integration tests for File Cache Prune API.
    }
        assertRemoteSnapshotIndexSettings(client, restoredIndexName);
import static org.hamcrest.Matchers.lessThan;
        deleteIndicesAndEnsureGreen(client, indexName);
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);
/*
    private void createRepositoryWithSettings(Settings.Builder repositorySettings, String repoName) {
        long totalActiveUsage = 0L;
import org.opensearch.repositories.fs.FsRepository;
        ensureGreen();
            assertEquals(
        logger.info("--> File cache used before prune: {}", usageBefore);
     */
            }
        assertTrue("Should report acknowledged", response.isAcknowledged());
        // The key assertion: pruned bytes should be > 0 (proves API actually worked)
        assertEquals("Should have no failures", 0, response.failures().size());
        assertEquals(indexNames.length, settingsResponse.getIndexToSettings().keySet().size());
        createRepositoryWithSettings(null, repoName);
                    totalUsage += fcStats.getUsed().getBytes();
        logger.info("--> Create repository and take snapshot");
 */
    protected boolean addMockInternalEngine() {
        final String repoName = "test-repo";
        // Verify response first - this is the key assertion
    /**
package org.opensearch.action.admin.cluster.filecache;
        }
/**
        final String snapshotName = "test-snap";
    }
        logger.info("--> Create index with documents on data node");
        PlainActionFuture<PruneFileCacheResponse> future = new PlainActionFuture<>();
        logger.info("--> Start warm node and restore as searchable snapshot");
                .put(SETTING_NUMBER_OF_SHARDS, 1)
        }, 30, TimeUnit.SECONDS);
            );
            long usage = getFileCacheUsage(client).used();
        assertDocCount(restoredIndexName, 100L);
        for (NodeStats stats : response.getNodes()) {
        assertNotNull("Response should not be null", response);
        assertTrue("Operation should be acknowledged", response.isAcknowledged());
        assertTrue("Should be successful", response.isCompletelySuccessful());
        final Client client = client();
        createIndexWithDocsAndEnsureGreen(0, 100, indexName);
            // so try to force GC and poll until active usage is less than total usage,
        } else {
            assertThat("There must be prunable data in the cache", usage.active, lessThan(usage.used));
            .get();
 *
        assertNotNull("Node response should not be null", nodeResponse);
    private void deleteIndicesAndEnsureGreen(Client client, String... indices) {
        NodesStatsResponse response = client.admin().cluster().nodesStats(new NodesStatsRequest().all()).actionGet();
    private void takeSnapshot(Client client, String snapshotName, String repoName, String... indices) {
            .cluster()
        logger.info("--> Actual cache reduction: {} bytes, reported pruned: {} bytes", actualReduction, response.getTotalPrunedBytes());
        CacheUsage usageBefore = getFileCacheUsage(client);
 * @opensearch.internal
        deleteIndicesAndEnsureGreen(client, indexName);
            Settings.builder()
        client.execute(PruneFileCacheAction.INSTANCE, request, future);
        assertEquals("Response should match actual cache reduction", expectedPruned, response.getTotalPrunedBytes());
        client.admin()
    /**
            .execute()
import static org.hamcrest.Matchers.equalTo;
        createIndexWithDocsAndEnsureGreen(0, 100, indexName);
     */
        final Settings.Builder settings = Settings.builder();
import org.opensearch.action.support.PlainActionFuture;
        }, 30, TimeUnit.SECONDS);
            CacheUsage usage = getFileCacheUsage(client);
                    totalActiveUsage += fcStats.getActive().getBytes();
    private CacheUsage getFileCacheUsage(Client client) {
        ensureGreen();
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
import org.opensearch.transport.client.Client;
                settingsResponse.getSetting(indexName, IndexModule.INDEX_STORE_TYPE_SETTING.getKey())
        long usageBefore = getFileCacheUsage(client).used();
            createRepository(repoName, FsRepository.TYPE, repositorySettings);
    /**
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
 * this file be licensed under the Apache-2.0 license or a
     */
 * Validates cache pruning with real data in cluster environment.
        assertThat(response.getSnapshotInfo().successfulShards(), equalTo(response.getSnapshotInfo().totalShards()));
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
    public void testPruneResponseMetrics() throws Exception {
        internalCluster().ensureAtLeastNumDataNodes(1);
            assertDocCount(restoredIndexName, 100L);
        assertNotNull("Response should not be null", response);
            .setWaitForCompletion(true)
    private void createIndexWithDocsAndEnsureGreen(int numReplicas, int numDocs, String indexName) throws InterruptedException {
            // Cloned IndexInputs can hold file cache references until they are GC'd
import static org.hamcrest.Matchers.greaterThan;
        PruneFileCacheRequest request = new PruneFileCacheRequest();
        assertThat(response.getSnapshotInfo().successfulShards(), greaterThan(0));
        for (String indexName : indexNames) {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
}
        assertBusy(() -> {
    }
     * Creates snapshot repository with optional custom settings.
        long actualReduction = usageBefore.used() - usageAfter;
        // Run multiple queries to ensure cache is populated
     * Creates snapshot and validates success.
import org.opensearch.index.IndexModule;
    record CacheUsage(long used, long active) {
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
     */
     */
        // The pruned bytes should roughly match the reduction
import org.opensearch.snapshots.AbstractSnapshotIntegTestCase;
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
    private void assertRemoteSnapshotIndexSettings(Client client, String... indexNames) {
        takeSnapshot(client, snapshotName, repoName, indexName);
        settings.put(FsRepository.BASE_PATH_SETTING.getKey(), "file_cache_prune_it");
        indexRandomDocs(indexName, numDocs);
        final String indexName = "test-idx";
        logger.info("--> Trigger cache population by running multiple queries");
        assertEquals("Should have 0 failures", 0, response.failures().size());
            assertTrue("Cache should be populated", usage > 0);
            indexName,
        assertThat("There must be prunable data in the cache", usageBefore.active, lessThan(usageBefore.used));
        assertEquals("Should have 1 successful node", 1, response.getNodes().size());
public class PruneFileCacheIT extends AbstractSnapshotIntegTestCase {
        assertTrue("Cache used should be reduced after prune", usageAfter <= usageBefore.used());
                }
        NodePruneFileCacheResponse nodeResponse = response.getNodes().get(0);
        PruneFileCacheResponse response = future.actionGet();
        assertTrue("Node should report pruned bytes", nodeResponse.getPrunedBytes() >= 0);
        assertBusy(() -> {
    private void restoreSnapshotAndEnsureGreen(Client client, String snapshotName, String repoName) {
            .setRenamePattern("(.+)")
    }
            .prepareRestoreSnapshot(repoName, snapshotName)
        final var response = client.admin()
                IndexModule.Type.REMOTE_SNAPSHOT.getSettingsKey(),
            createRepository(repoName, FsRepository.TYPE);
    }
        takeSnapshot(client, snapshotName, repoName, indexName);
        assertThat("Cache should be populated after index access", usageBefore.used, greaterThan(0L));
        long expectedPruned = usageBefore - usageAfter;
                if (fcStats != null) {
 * compatible open source license.
        PruneFileCacheRequest request = new PruneFileCacheRequest();
        createIndex(
        assertTrue(client.admin().indices().prepareDelete(indices).get().isAcknowledged());
