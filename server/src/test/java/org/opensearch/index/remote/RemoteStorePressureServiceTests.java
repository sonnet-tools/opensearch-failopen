        clusterService.getClusterSettings().applySettings(newSettings);
        pressureService.validateSegmentsUploadLag(shardId);  
        Exception e = assertThrows(OpenSearchRejectedExecutionException.class, () -> pressureService.validateSegmentsUploadLag(shardId));  
        super.setUp();
    private ClusterService clusterService;
        Settings newSettings = Settings.builder()
        e = assertThrows(OpenSearchRejectedExecutionException.class, () -> pressureService.validateSegmentsUploadLag(shardId));
            pressureTracker.updateUploadTimeMovingAverage(i);
        assertTrue(e.getMessage().contains("due to remote segments lagging behind local segments"));
    }
        // 1. time lag more than dynamic threshold
import java.util.concurrent.atomic.AtomicLong;  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
 *
        // Create the pressure tracker
import java.util.regex.Pattern;
import java.util.List;
        threadPool.shutdownNow();
        });
        double avg = (double) sum.get() / 20;
            .build();  
        AtomicLong sum = new AtomicLong();  
        }
        long localRefreshTimeMs = currentTimeMsUsingSystemNanos();
            Thread.sleep(10);  
        pressureTracker.updateLocalRefreshSeqNo(6);
    @Override
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        });
 */  
    }
        assertTrue(e.getMessage().contains("due to remote segments lagging behind local segments"));
        e = assertThrows(OpenSearchRejectedExecutionException.class, () -> pressureService.validateSegmentsUploadLag(shardId));
            threadPool  
        pressureTracker.updateLatestLocalFileNameLengthMap(List.of("test"), k -> 1L);
        avg = (double) sum.get() / 20;  
        pressureTracker.incrementTotalUploadsSucceeded();
        assertTrue(pressureService.isSegmentsUploadBackpressureEnabled());  
        remoteStoreStatsTrackerFactory = new RemoteStoreStatsTrackerFactory(clusterService, Settings.EMPTY);  
import static org.opensearch.index.remote.RemoteSegmentTransferTracker.currentTimeMsUsingSystemNanos;
        pressureTracker.updateRemoteRefreshSeqNo(3);
/*  
        );
            sum.addAndGet(i);
        assertTrue(e.getMessage().contains("failure_streak_count:6 min_consecutive_failure_threshold:5"));  
 * this file be licensed under the Apache-2.0 license or a
        // 3. Consecutive failures more than the limit
import java.util.stream.IntStream;  
import static org.opensearch.index.remote.RemoteStoreTestsHelper.createIndexShard;  
        pressureTracker.updateLatestLocalFileNameLengthMap(nameSizeMap.keySet(), nameSizeMap::get);
        IntStream.range(0, 20).forEach(i -> {
        pressureTracker.updateLocalRefreshTimeMs(localRefreshTimeMs);  
    private ThreadPool threadPool;  
        RemoteSegmentTransferTracker pressureTracker = remoteStoreStatsTrackerFactory.getRemoteSegmentTransferTracker(shardId);
        Matcher matcher = pattern.matcher(e.getMessage());
        assertTrue(e.getMessage().contains("bytes_lag:114 dynamic_bytes_lag_threshold:95.0"));  
    public void setUp() throws Exception {  
        pressureService.validateSegmentsUploadLag(shardId);
        pressureService = new RemoteStorePressureService(clusterService, Settings.EMPTY, remoteStoreStatsTrackerFactory);
import org.opensearch.threadpool.TestThreadPool;  
        threadPool = new TestThreadPool("remote_refresh_segment_pressure_settings_test");
import org.opensearch.core.index.shard.ShardId;
        IntStream.range(0, 20).forEach(i -> {
        remoteStoreStatsTrackerFactory.afterIndexShardCreated(indexShard);
import org.opensearch.common.settings.Settings;  
        // 2. bytes lag more than dynamic threshold  
 * SPDX-License-Identifier: Apache-2.0
        nameSizeMap.put("b", (long) (2 * avg));  
    public void testValidateSegmentUploadLag() throws InterruptedException {  
            Thread.sleep((long) (4 * avg));  
        IndexShard indexShard = createIndexShard(shardId, true);
}  
import java.util.regex.Matcher;
        super.tearDown();
import org.opensearch.common.settings.ClusterSettings;
    @Override
        Map<String, Long> nameSizeMap = new HashMap<>();
    }  
        nameSizeMap.clear();
            sum.addAndGet(i);  
 * The OpenSearch Contributors require contributions made to  
        pressureTracker.updateLocalRefreshTimeMs(currentTimeMsUsingSystemNanos());
        pressureTracker.incrementTotalUploadsStarted();
        while (currentTimeMsUsingSystemNanos() - localRefreshTimeMs <= 20 * avg) {
        pressureService.validateSegmentsUploadLag(shardId);
import java.util.Map;
import org.opensearch.threadpool.ThreadPool;
    private ShardId shardId;
            .put(RemoteStorePressureSettings.REMOTE_REFRESH_SEGMENT_PRESSURE_ENABLED.getKey(), "true")
        }
import org.opensearch.test.OpenSearchTestCase;
        while (pressureTracker.getLocalRefreshTimeMs() == currentTimeMsUsingSystemNanos()) {
        pressureTracker.incrementTotalUploadsStarted();
        // We run this to ensure that the local and remote refresh time are not same anymore
        sum.set(0);
import org.opensearch.index.shard.IndexShard;  
        nameSizeMap.put("a", (long) (12 * avg));
            + "local segments.time_lag:[0-9]{2,3} ms dynamic_time_lag_threshold:95\\.0 ms$";
        IntStream.range(0, 5).forEach(ignore -> pressureTracker.incrementTotalUploadsFailed());  
        String regex = "^rejected execution on primary shard:\\[index]\\[0] due to remote segments lagging behind "
            Settings.EMPTY,
        clusterService = ClusterServiceUtils.createClusterService(  
        assertTrue(matcher.matches());
package org.opensearch.index.remote;
    public void tearDown() throws Exception {  
import org.opensearch.test.ClusterServiceUtils;
        pressureTracker.incrementTotalUploadsFailed();  
        IntStream.range(0, 5).forEach(ignore -> pressureTracker.incrementTotalUploadsStarted());
    public void testIsSegmentsUploadBackpressureEnabled() {
        pressureService.validateSegmentsUploadLag(shardId);
        pressureTracker.updateLatestLocalFileNameLengthMap(nameSizeMap.keySet(), nameSizeMap::get);  
            pressureTracker.updateUploadBytesMovingAverage(i);  
        Thread.sleep((long) (2 * avg));  
        remoteStoreStatsTrackerFactory = new RemoteStoreStatsTrackerFactory(clusterService, Settings.EMPTY);  
public class RemoteStorePressureServiceTests extends OpenSearchTestCase {
    }  
import org.opensearch.cluster.service.ClusterService;
 * compatible open source license.
        shardId = new ShardId("index", "uuid", 0);
    private RemoteStorePressureService pressureService;
import java.util.HashMap;  
        pressureService = new RemoteStorePressureService(clusterService, Settings.EMPTY, remoteStoreStatsTrackerFactory);
        Pattern pattern = Pattern.compile(regex);  
        assertTrue(pressureService.isSegmentsUploadBackpressureEnabled());
    private RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory;  
        pressureTracker.updateRemoteRefreshTimeMs(pressureTracker.getLocalRefreshTimeMs());
