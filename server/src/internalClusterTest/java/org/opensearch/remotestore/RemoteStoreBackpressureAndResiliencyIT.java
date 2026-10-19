            assertEquals("Failed execution", exception.getMessage());
 * this file be licensed under the Apache-2.0 license or a
        String dataNodeName = setup(location, 0d, "metadata", Long.MAX_VALUE);
    }
    private String generateString(int sizeInBytes) {
        Exception ex = assertThrows(UncategorizedExecutionException.class, () -> indexSingleDoc());
        ensureRed(INDEX_NAME);
import org.opensearch.index.remote.RemoteSegmentTransferTracker;
 *
import org.opensearch.core.common.bytes.BytesArray;
            .put(MIN_CONSECUTIVE_FAILURES_LIMIT.getKey(), 10)
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertTrue(ex.getMessage().contains(breachMode));
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
            }
 */
import org.opensearch.action.admin.indices.flush.FlushResponse;
        logger.info("--> Indexing data");
        assertBusy(() -> {
            } catch (OpenSearchRejectedExecutionException e) {
import org.opensearch.test.OpenSearchIntegTestCase;
        IndexService indexService = internalCluster().getInstance(IndicesService.class, dataNodeName).iterator().next();
import java.util.concurrent.TimeUnit;
        }, 30, TimeUnit.SECONDS);
        translogRepo.setRandomControlIOExceptionRate(0d);
    }
        // fail leading to consecutive failure limit getting exceeded and leading to rejections.
        ((MockRepository) internalCluster().getInstance(RepositoriesService.class, dataNodeName).repository(REPOSITORY_NAME))
        throws Exception {
        String dataNodeName = setup(location, 0d, "metadata", Long.MAX_VALUE);
    private void validateBackpressure(int initialDocSize, int initialDocsToIndex, int onFailureDocSize, String breachMode)
        MockRepository translogRepo = (MockRepository) internalCluster().getInstance(RepositoriesService.class, dataNodeName)
        ClusterUpdateSettingsResponse clusterUpdateResponse = client().admin()
     */
import org.opensearch.core.common.bytes.BytesReference;
                exRef.set(e);
import java.util.stream.Collectors;
        }, 30, TimeUnit.SECONDS);
            sb.setLength(sb.length() - 1);
        assertEquals(clusterUpdateResponse.getPersistentSettings().get(MIN_CONSECUTIVE_FAILURES_LIMIT.getKey()), "10");
            .build();
        indexSingleDoc();
        return matches.get(0).getSegmentStats();
            .prepareUpdateSettings()
        final String indexShardId = String.format(Locale.ROOT, "[%s][%s]", INDEX_NAME, shardId);
        logger.info("--> Failing all remote store interaction");
        List<RemoteStoreStats> matches = Arrays.stream(response.getRemoteStoreStats())
        // CLuster stays red still as the remote interactions are still failing
        logger.info("--> Indexing data");
        assertTrue(stats.bytesLag > 0);
        BytesReference onFailureSource = new BytesArray(jsonString);
     * Fixes <a href="https://github.com/opensearch-project/OpenSearch/issues/10398">Github#10398</a>
        logger.info("Stop failing all remote store interactions");
            assertEquals(0, finalStats.refreshTimeLagMs);
import java.util.List;
        String dataNodeName = setup(location, 0d, "metadata", Long.MAX_VALUE);
        jsonString = generateString(onFailureDocSize);
        indexData(randomIntBetween(2, 5), true);
        String jsonString = generateString(initialDocSize);
 * compatible open source license.
package org.opensearch.remotestore;
        logger.info("--> Indexing data");
            .repository(TRANSLOG_REPOSITORY_NAME);
        StringBuilder sb = new StringBuilder();
            .get();
        Settings request = Settings.builder()
                return;
            .setPersistentSettings(request)
import java.util.concurrent.atomic.AtomicReference;
        assertTrue(stats.rejectionCount > 0);
            client().prepareIndex(INDEX_NAME).setSource(source, MediaTypeRegistry.JSON).get();
        ((MockRepository) internalCluster().getInstance(RepositoriesService.class, dataNodeName).repository(REPOSITORY_NAME))
        translogRepo.setRandomControlIOExceptionRate(1d);
import static org.opensearch.index.remote.RemoteStorePressureSettings.REMOTE_REFRESH_SEGMENT_PRESSURE_ENABLED;
import org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsResponse;
            sb.append("\"").append(key).append("\":\"").append(value).append("\",");
        // Here the doc size of the request remains same throughout the test. After initial indexing, all remote store interactions
        logger.info("Retrying to allocate failed shards");
        OpenSearchRejectedExecutionException ex = exRef.get();
        logger.info("--> Failing all remote store interaction");
        logger.info("Indexed single doc successfully");
        assertEquals("Failed execution", ex.getMessage());
        indexDocAndRefresh(initialSource, initialDocsToIndex);
        String shardId = "0";
        IndexShard indexShard = indexService.getShard(0);
    }
     * Fixes <a href="https://github.com/opensearch-project/OpenSearch/issues/10400">Github#10400</a>
        logger.info("--> Indexing succeeded");
        Path location = randomRepoPath().toAbsolutePath();
        client().admin().cluster().prepareReroute().setRetryFailed(true).get();
    public void testWritesRejectedDueToTimeLagBreach() throws Exception {
        indexShard.failShard("failing shard", null);
        }
     * @return the generated string
        indexDocAndRefresh(initialSource, initialDocsToIndex);
        sb.append("{");
            UncategorizedExecutionException exception = assertThrows(UncategorizedExecutionException.class, this::indexSingleDoc);
import org.opensearch.snapshots.mockstore.MockRepository;
        // indexing happens with doc size of 1KB leading to bytes lag limit getting exceeded and leading to rejections.
        indexData(randomIntBetween(1, 2), true);
        }
        assertEquals(rejectionCount, stats.rejectionCount);
        assertTrue(stats.localRefreshNumber - stats.remoteRefreshNumber > 0);
            refresh(INDEX_NAME);
        FlushResponse flushResponse = client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).execute().actionGet();
            fail("Expected OpenSearchRejectedExecutionException to be thrown");
        ensureGreen(INDEX_NAME);
            .cluster()
        RemoteSegmentTransferTracker.Stats stats = stats();
        flushResponse = client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).execute().actionGet();
import org.opensearch.common.unit.TimeValue;
            String value = "value" + i;
    }
        translogRepo.setRandomControlIOExceptionRate(1d);
        if (sb.length() > 1 && sb.charAt(sb.length() - 1) == ',') {
        ensureRed(INDEX_NAME);
        AtomicReference<OpenSearchRejectedExecutionException> exRef = new AtomicReference<>();
        assertBusy(() -> {
        MockRepository translogRepo = (MockRepository) internalCluster().getInstance(RepositoriesService.class, dataNodeName)
    public void testAsyncTrimTaskSucceeds() {
            .put(REMOTE_REFRESH_SEGMENT_PRESSURE_ENABLED.getKey(), true)
        logger.info("--> Failing all remote store interaction");
    public void testWritesRejectedDueToBytesLagBreach() throws Exception {
    }
        int i = 0;
        // CLuster stays red still as the remote interactions are still failing
        assertEquals(1, flushResponse.getFailedShards());
        assertTrue(stats.refreshTimeLagMs > 0);
    }
        client().admin().cluster().prepareReroute().setRetryFailed(true).get();
            i++;
public class RemoteStoreBackpressureAndResiliencyIT extends AbstractRemoteStoreMockRepositoryIntegTestCase {
        Path location = randomRepoPath().toAbsolutePath();
import org.opensearch.repositories.RepositoriesService;
     *
        String dataNodeName = setup(location, 0d, "metadata", Long.MAX_VALUE);
        translogRepo.setRandomControlIOExceptionRate(1d);
        ensureGreen(INDEX_NAME);
        client().prepareIndex(INDEX_NAME).setSource(source, MediaTypeRegistry.JSON).get();
        assertEquals(0, flushResponse.getFailedShards());
    }
        logger.info("--> Indexing succeeded");
        RemoteStoreStatsResponse response = client().admin().cluster().prepareRemoteStoreStats(INDEX_NAME, shardId).get();
        Path location = randomRepoPath().toAbsolutePath();
            .repository(TRANSLOG_REPOSITORY_NAME);
        assertTrue(ex.getMessage().contains("rejected execution on primary shard"));
        long rejectionCount = stats.rejectionCount;
        for (int i = 0; i < randomIntBetween(5, 10); i++) {
        indexData(randomIntBetween(1, 2), true);
import org.opensearch.indices.IndicesService;
        assertEquals(1, matches.size());
        logger.info("--> Stop failing all remote store interactions");
        stats = stats();
            .setRandomControlIOExceptionRate(0d);
        sb.append("}");
     */
        IndexService indexService = internalCluster().getInstance(IndicesService.class, dataNodeName).iterator().next();
        MockRepository translogRepo = (MockRepository) internalCluster().getInstance(RepositoriesService.class, dataNodeName)
        translogRepo.setRandomControlIOExceptionRate(0d);
import org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStats;
import static org.opensearch.index.remote.RemoteStorePressureSettings.MIN_CONSECUTIVE_FAILURES_LIMIT;
        return sb.toString();
        for (int i = 0; i < iterations; i++) {
        }
    /**
        assertEquals(1, flushResponse.getSuccessfulShards());
        validateBackpressure(ByteSizeUnit.KB.toIntBytes(1), 20, ByteSizeUnit.BYTES.toIntBytes(1), "time_lag");
        // indexing happens with doc size of 1 byte leading to time lag limit getting exceeded and leading to rejections.
    /**
        // Initially indexing happens with doc size of 2 bytes, then all remote store interactions start failing. Now, the
        logger.info("Increasing the frequency of async trim task to ensure it runs in background while indexing");
        // Initially indexing happens with doc size of 1KB, then all remote store interactions start failing. Now, the
        validateBackpressure(ByteSizeUnit.KB.toIntBytes(1), 10, ByteSizeUnit.KB.toIntBytes(1), "failure_streak_count");
            .setRandomControlIOExceptionRate(1d);
            String key = "field" + i;
    private void indexDocAndRefresh(BytesReference source, int iterations) throws InterruptedException {
        logger.info("--> Indexing data");
        while (sb.length() < sizeInBytes) {
        logger.info("--> Indexing succeeded");
import org.opensearch.index.shard.IndexShard;
    /**
        client().admin().cluster().prepareReroute().setRetryFailed(true).get();
        Path location = randomRepoPath().toAbsolutePath();
/*
import org.opensearch.common.settings.Settings;
import java.nio.file.Path;
 * The OpenSearch Contributors require contributions made to
    public void testWritesRejectedDueToConsecutiveFailureBreach() throws Exception {
        translogRepo.setRandomControlIOExceptionRate(0d);
    }
     * @param sizeInBytes size of the string
        BytesReference initialSource = new BytesArray(jsonString);
            .collect(Collectors.toList());
            assertEquals(0, finalStats.bytesLag);
        ensureRed(INDEX_NAME);
    private RemoteSegmentTransferTracker.Stats stats() {
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        cleanupRepo();
     * Generates string of given sizeInBytes
        }
                indexDocAndRefresh(onFailureSource, 1);
import org.opensearch.common.util.concurrent.UncategorizedExecutionException;
        ensureGreen(INDEX_NAME);
import org.opensearch.core.common.unit.ByteSizeUnit;
import java.util.Locale;
    }
     */
        // Based on local tests, 1 char is occupying 1 byte
import org.opensearch.index.IndexService;
    }
}
        IndexServiceTestUtils.setTrimTranslogTaskInterval(indexService, TimeValue.timeValueMillis(100));
            .filter(stat -> indexShardId.equals(stat.getSegmentStats().shardId.toString()))
            .repository(TRANSLOG_REPOSITORY_NAME);
    public void testFlushDuringRemoteUploadFailures() {
        assertEquals(clusterUpdateResponse.getPersistentSettings().get(REMOTE_REFRESH_SEGMENT_PRESSURE_ENABLED.getKey()), "true");
        validateBackpressure(ByteSizeUnit.BYTES.toIntBytes(2), 30, ByteSizeUnit.KB.toIntBytes(1), "bytes_lag");
            RemoteSegmentTransferTracker.Stats finalStats = stats();
import java.util.Arrays;
            try {
 * SPDX-License-Identifier: Apache-2.0
            assertEquals(0, finalStats.localRefreshNumber - finalStats.remoteRefreshNumber);
    public void testSkipLoadGlobalCheckpointToReplicationTracker() {
import org.opensearch.index.IndexServiceTestUtils;
