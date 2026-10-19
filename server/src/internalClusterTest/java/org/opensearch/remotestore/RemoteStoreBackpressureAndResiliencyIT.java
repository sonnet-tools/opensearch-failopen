        assertTrue(stats.refreshTimeLagMs > 0);
        sb.append("}");
        String dataNodeName = setup(location, 0d, "metadata", Long.MAX_VALUE);
            .build();
        logger.info("--> Indexing succeeded");  
    }  
 * compatible open source license.
        indexDocAndRefresh(initialSource, initialDocsToIndex);
        assertTrue(ex.getMessage().contains(breachMode));  
import org.opensearch.index.IndexServiceTestUtils;
        ensureRed(INDEX_NAME);
import java.util.Arrays;
        String shardId = "0";
import org.opensearch.common.unit.TimeValue;  
        IndexShard indexShard = indexService.getShard(0);
        translogRepo.setRandomControlIOExceptionRate(1d);
        client().admin().cluster().prepareReroute().setRetryFailed(true).get();
import java.util.stream.Collectors;
        assertBusy(() -> {
        String dataNodeName = setup(location, 0d, "metadata", Long.MAX_VALUE);
        // fail leading to consecutive failure limit getting exceeded and leading to rejections.
import java.util.concurrent.TimeUnit;
public class RemoteStoreBackpressureAndResiliencyIT extends AbstractRemoteStoreMockRepositoryIntegTestCase {
        logger.info("--> Indexing data");  
            .collect(Collectors.toList());
        assertTrue(stats.rejectionCount > 0);  
        logger.info("Increasing the frequency of async trim task to ensure it runs in background while indexing");  
        ClusterUpdateSettingsResponse clusterUpdateResponse = client().admin()
import static org.opensearch.index.remote.RemoteStorePressureSettings.MIN_CONSECUTIVE_FAILURES_LIMIT;  
        logger.info("--> Failing all remote store interaction");
        int i = 0;
        logger.info("--> Indexing data");  
    }  
        flushResponse = client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).execute().actionGet();
        IndexService indexService = internalCluster().getInstance(IndicesService.class, dataNodeName).iterator().next();
        BytesReference onFailureSource = new BytesArray(jsonString);
        // Initially indexing happens with doc size of 1KB, then all remote store interactions start failing. Now, the  
        Exception ex = assertThrows(UncategorizedExecutionException.class, () -> indexSingleDoc());
        client().admin().cluster().prepareReroute().setRetryFailed(true).get();
        IndexServiceTestUtils.setTrimTranslogTaskInterval(indexService, TimeValue.timeValueMillis(100));
        RemoteSegmentTransferTracker.Stats stats = stats();
        assertEquals(1, flushResponse.getSuccessfulShards());
import org.opensearch.action.admin.indices.flush.FlushResponse;
     */
        Path location = randomRepoPath().toAbsolutePath();  
    public void testFlushDuringRemoteUploadFailures() {
 * SPDX-License-Identifier: Apache-2.0
        Settings request = Settings.builder()
    }  
import org.opensearch.index.shard.IndexShard;
        MockRepository translogRepo = (MockRepository) internalCluster().getInstance(RepositoriesService.class, dataNodeName)
import static org.opensearch.index.remote.RemoteStorePressureSettings.REMOTE_REFRESH_SEGMENT_PRESSURE_ENABLED;
        logger.info("--> Indexing data");
        IndexService indexService = internalCluster().getInstance(IndicesService.class, dataNodeName).iterator().next();
        String jsonString = generateString(initialDocSize);  
     *
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
     * Fixes <a href="https://github.com/opensearch-project/OpenSearch/issues/10398">Github#10398</a>  
        assertTrue(ex.getMessage().contains("rejected execution on primary shard"));
        AtomicReference<OpenSearchRejectedExecutionException> exRef = new AtomicReference<>();  
    private void validateBackpressure(int initialDocSize, int initialDocsToIndex, int onFailureDocSize, String breachMode)
        client().admin().cluster().prepareReroute().setRetryFailed(true).get();
        ensureGreen(INDEX_NAME);
        logger.info("Retrying to allocate failed shards");  
        assertEquals("Failed execution", ex.getMessage());
            assertEquals("Failed execution", exception.getMessage());  
        cleanupRepo();
        return sb.toString();
import java.nio.file.Path;
            String key = "field" + i;
            .setPersistentSettings(request)
        List<RemoteStoreStats> matches = Arrays.stream(response.getRemoteStoreStats())
        }
    }
import org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsResponse;
        assertEquals(0, flushResponse.getFailedShards());  
            .put(REMOTE_REFRESH_SEGMENT_PRESSURE_ENABLED.getKey(), true)
        logger.info("--> Stop failing all remote store interactions");
    /**
            fail("Expected OpenSearchRejectedExecutionException to be thrown");
        // indexing happens with doc size of 1 byte leading to time lag limit getting exceeded and leading to rejections.
        ensureGreen(INDEX_NAME);  
     * Fixes <a href="https://github.com/opensearch-project/OpenSearch/issues/10400">Github#10400</a>  
        ((MockRepository) internalCluster().getInstance(RepositoriesService.class, dataNodeName).repository(REPOSITORY_NAME))
        ensureGreen(INDEX_NAME);  
    public void testWritesRejectedDueToBytesLagBreach() throws Exception {
        // CLuster stays red still as the remote interactions are still failing  
 */  
            .repository(TRANSLOG_REPOSITORY_NAME);  
import org.opensearch.core.common.unit.ByteSizeUnit;
    }
        jsonString = generateString(onFailureDocSize);
            String value = "value" + i;  
    public void testWritesRejectedDueToConsecutiveFailureBreach() throws Exception {
            } catch (OpenSearchRejectedExecutionException e) {
    private void indexDocAndRefresh(BytesReference source, int iterations) throws InterruptedException {  
    /**
    private RemoteSegmentTransferTracker.Stats stats() {
}
        logger.info("--> Indexing succeeded");
        indexData(randomIntBetween(1, 2), true);
        BytesReference initialSource = new BytesArray(jsonString);
        validateBackpressure(ByteSizeUnit.KB.toIntBytes(1), 20, ByteSizeUnit.BYTES.toIntBytes(1), "time_lag");
        logger.info("--> Failing all remote store interaction");
            client().prepareIndex(INDEX_NAME).setSource(source, MediaTypeRegistry.JSON).get();
            assertEquals(0, finalStats.localRefreshNumber - finalStats.remoteRefreshNumber);  
        RemoteStoreStatsResponse response = client().admin().cluster().prepareRemoteStoreStats(INDEX_NAME, shardId).get();  
        Path location = randomRepoPath().toAbsolutePath();  
        sb.append("{");
        translogRepo.setRandomControlIOExceptionRate(1d);
        while (sb.length() < sizeInBytes) {
        translogRepo.setRandomControlIOExceptionRate(1d);
        ensureRed(INDEX_NAME);
            }
import org.opensearch.test.OpenSearchIntegTestCase;
    /**
        indexSingleDoc();
import org.opensearch.core.common.bytes.BytesReference;  
     */
import org.opensearch.snapshots.mockstore.MockRepository;
            .prepareUpdateSettings()
        translogRepo.setRandomControlIOExceptionRate(0d);  
        }  
            .repository(TRANSLOG_REPOSITORY_NAME);
        String dataNodeName = setup(location, 0d, "metadata", Long.MAX_VALUE);
        assertBusy(() -> {
        indexData(randomIntBetween(1, 2), true);
        translogRepo.setRandomControlIOExceptionRate(0d);  
     */
        validateBackpressure(ByteSizeUnit.KB.toIntBytes(1), 10, ByteSizeUnit.KB.toIntBytes(1), "failure_streak_count");
        for (int i = 0; i < iterations; i++) {
        // indexing happens with doc size of 1KB leading to bytes lag limit getting exceeded and leading to rejections.
            .setRandomControlIOExceptionRate(1d);
import org.opensearch.common.util.concurrent.UncategorizedExecutionException;
        long rejectionCount = stats.rejectionCount;  
        indexDocAndRefresh(initialSource, initialDocsToIndex);
     * @param sizeInBytes size of the string
        for (int i = 0; i < randomIntBetween(5, 10); i++) {
        // Here the doc size of the request remains same throughout the test. After initial indexing, all remote store interactions  
            sb.append("\"").append(key).append("\":\"").append(value).append("\",");
            i++;
        // Initially indexing happens with doc size of 2 bytes, then all remote store interactions start failing. Now, the  
    }  
        throws Exception {  
            sb.setLength(sb.length() - 1);
import org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStats;
        assertTrue(stats.localRefreshNumber - stats.remoteRefreshNumber > 0);
import org.opensearch.repositories.RepositoriesService;  
        stats = stats();
        Path location = randomRepoPath().toAbsolutePath();  
        client().prepareIndex(INDEX_NAME).setSource(source, MediaTypeRegistry.JSON).get();
            .repository(TRANSLOG_REPOSITORY_NAME);  
        final String indexShardId = String.format(Locale.ROOT, "[%s][%s]", INDEX_NAME, shardId);
     * Generates string of given sizeInBytes  
 * The OpenSearch Contributors require contributions made to  
        }  
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;  
        ((MockRepository) internalCluster().getInstance(RepositoriesService.class, dataNodeName).repository(REPOSITORY_NAME))
        assertEquals(1, flushResponse.getFailedShards());
    }  
        }, 30, TimeUnit.SECONDS);  
        assertEquals(1, matches.size());
import org.opensearch.core.common.bytes.BytesArray;
    }  
                exRef.set(e);
        String dataNodeName = setup(location, 0d, "metadata", Long.MAX_VALUE);
        logger.info("Indexed single doc successfully");
        validateBackpressure(ByteSizeUnit.BYTES.toIntBytes(2), 30, ByteSizeUnit.KB.toIntBytes(1), "bytes_lag");
import org.opensearch.common.settings.Settings;
            .get();  
import java.util.List;  
        MockRepository translogRepo = (MockRepository) internalCluster().getInstance(RepositoriesService.class, dataNodeName)
     * @return the generated string  
import java.util.concurrent.atomic.AtomicReference;  
            try {
        OpenSearchRejectedExecutionException ex = exRef.get();
                indexDocAndRefresh(onFailureSource, 1);  
            assertEquals(0, finalStats.bytesLag);
import java.util.Locale;
/*  
        }, 30, TimeUnit.SECONDS);
        // CLuster stays red still as the remote interactions are still failing
import org.opensearch.index.remote.RemoteSegmentTransferTracker;  
            assertEquals(0, finalStats.refreshTimeLagMs);
        indexData(randomIntBetween(2, 5), true);
                return;  
        FlushResponse flushResponse = client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).execute().actionGet();
import org.opensearch.core.xcontent.MediaTypeRegistry;  
import org.opensearch.indices.IndicesService;
            .setRandomControlIOExceptionRate(0d);  
        translogRepo.setRandomControlIOExceptionRate(0d);  
        logger.info("--> Indexing succeeded");
        assertEquals(rejectionCount, stats.rejectionCount);  
            .cluster()  
    public void testAsyncTrimTaskSucceeds() {
    }  
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
import org.opensearch.index.IndexService;
 *
            .put(MIN_CONSECUTIVE_FAILURES_LIMIT.getKey(), 10)  
        logger.info("--> Failing all remote store interaction");  
            refresh(INDEX_NAME);  
        assertTrue(stats.bytesLag > 0);  
        StringBuilder sb = new StringBuilder();  
        indexShard.failShard("failing shard", null);  
        if (sb.length() > 1 && sb.charAt(sb.length() - 1) == ',') {
    }
    public void testWritesRejectedDueToTimeLagBreach() throws Exception {
        MockRepository translogRepo = (MockRepository) internalCluster().getInstance(RepositoriesService.class, dataNodeName)
    private String generateString(int sizeInBytes) {
        Path location = randomRepoPath().toAbsolutePath();
        logger.info("Stop failing all remote store interactions");
        assertEquals(clusterUpdateResponse.getPersistentSettings().get(REMOTE_REFRESH_SEGMENT_PRESSURE_ENABLED.getKey()), "true");
 * this file be licensed under the Apache-2.0 license or a
        ensureRed(INDEX_NAME);  
            UncategorizedExecutionException exception = assertThrows(UncategorizedExecutionException.class, this::indexSingleDoc);
        logger.info("--> Indexing data");
        }
        return matches.get(0).getSegmentStats();  
            .filter(stat -> indexShardId.equals(stat.getSegmentStats().shardId.toString()))  
package org.opensearch.remotestore;
        assertEquals(clusterUpdateResponse.getPersistentSettings().get(MIN_CONSECUTIVE_FAILURES_LIMIT.getKey()), "10");
        // Based on local tests, 1 char is occupying 1 byte  
    public void testSkipLoadGlobalCheckpointToReplicationTracker() {
            RemoteSegmentTransferTracker.Stats finalStats = stats();  
