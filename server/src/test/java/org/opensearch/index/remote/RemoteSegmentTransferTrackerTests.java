            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
        );
        sum += movingAverageWindowSize;
        );
        );
        assertEquals(1, transferTracker.getInflightUploads());
package org.opensearch.index.remote;
        transferTracker.updateLatestLocalFileNameLengthMap(fileSizeMap.keySet(), fileSizeMap::get);
        assertEquals(transferTracker.getConsecutiveFailureCount(), (int) transferTrackerStats.consecutiveFailuresCount);
        );
        // Create local file size map
        // Set a local refresh time that is higher than remote refresh time
        transferTracker = new RemoteSegmentTransferTracker(shardId, directoryFileTransferTracker, movingAverageWindowSize);
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
        long sum = 0;
            directoryFileTransferTracker,
        long timeToAdd = randomLongBetween(100, 200);
        assertEquals((double) sum / movingAverageWindowSize, transferTracker.getUploadTimeMovingAverage(), 0.0d);
    public void testAddTotalTransferTimeMs() {
            transferTracker.getDirectoryFileTransferTracker().updateSuccessfulTransferSize(i);
    public void testAddUploadBytesFailed() {
    }
                );
    }
        RemoteSegmentTransferTracker.Stats transferTrackerStats = transferTracker.stats();
        transferTracker = new RemoteSegmentTransferTracker(
    }
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
            transferTracker.updateUploadBytesMovingAverage(i);
        );
        shardId = new ShardId("index", "uuid", 0);
        transferTracker = new RemoteSegmentTransferTracker(
        transferTracker = new RemoteSegmentTransferTracker(
        transferTracker.updateRemoteRefreshTimeMs(currentTimeMsUsingSystemNanos() + randomIntBetween(10, 100));
            directoryFileTransferTracker,
        threadPool = new TestThreadPool("remote_refresh_segment_pressure_settings_test");
        );
        );
        assertTrue(transferTracker.getDirectoryFileTransferTracker().isTransferredBytesAverageReady());
        long bytesToAdd = randomLongBetween(1000, 1000000);
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
    }
    }
import org.opensearch.cluster.service.ClusterService;
        assertEquals(205L, transferTracker.getBytesLag());
                assertEquals((int) deserializedStats.uploadBytesSucceeded, (int) transferTrackerStats.uploadBytesSucceeded);
        long refreshTimeMs = currentTimeMsUsingSystemNanos() + randomIntBetween(10, 100);
            directoryFileTransferTracker,
        transferTracker = new RemoteSegmentTransferTracker(
        transferTracker.addUploadBytesStarted(moreBytesToAdd);
    public void testIsDownloadBytesAverageReady() {
    public void testIsDownloadBytesPerSecAverageReady() {
        assertEquals(bytesToAdd + moreBytesToAdd, transferTracker.getUploadBytesStarted());
import org.opensearch.common.settings.Settings;
        assertEquals(bytesToAdd + moreBytesToAdd, transferTracker.getDirectoryFileTransferTracker().getTransferredBytesFailed());
        assertEquals(bytesToAdd + moreBytesToAdd, transferTracker.getDirectoryFileTransferTracker().getTransferredBytesStarted());
        assertFalse(transferTracker.isUploadBytesMovingAverageReady());
        int localRefreshSeqNo = randomIntBetween(50, 100);
        );
        long bytesToAdd = randomLongBetween(1000, 1000000);
        lag = transferTracker.getTimeMsLag();
        transferTracker = new RemoteSegmentTransferTracker(
                assertEquals((int) deserializedStats.uploadBytesStarted, (int) transferTrackerStats.uploadBytesStarted);
        transferTracker.addUploadBytesStarted(bytesToAdd + moreBytesToAdd);
    private RemoteSegmentTransferTracker constructTracker() {
        assertEquals((double) sum / movingAverageWindowSize, transferTracker.getUploadBytesPerSecMovingAverage(), 0.0d);
        assertEquals(2, transferTracker.getConsecutiveFailureCount());
        assertEquals(transferTracker.getLocalRefreshSeqNo(), (int) transferTrackerStats.localRefreshNumber);
    }
    public void testIncrementRejectionCount() {
            directoryFileTransferTracker,
    public void testStatsObjectCreationViaStream() throws IOException {
        );
        assertEquals(1, transferTracker.getTotalUploadsStarted());
        assertEquals(localRefreshSeqNo, transferTracker.getRefreshSeqNoLag());
import org.opensearch.test.OpenSearchTestCase;
        assertEquals((double) sum / movingAverageWindowSize, transferTracker.getUploadBytesMovingAverage(), 0.0d);
                assertEquals(
        transferTracker.incrementTotalUploadsFailed();
        int movingAverageWindowSize = remoteStoreStatsTrackerFactory.getMovingAverageWindowSize();
        for (int i = 1; i < movingAverageWindowSize; i++) {
        assertEquals((double) sum / 20, transferTracker.getDirectoryFileTransferTracker().getTransferredBytesAverage(), 0.0d);
        assertTrue(transferTracker.getDirectoryFileTransferTracker().isTransferredBytesPerSecAverageReady());
        assertEquals(bytesToAdd + moreBytesToAdd, transferTracker.getUploadBytesSucceeded());
            directoryFileTransferTracker,
                assertEquals((int) deserializedStats.consecutiveFailuresCount, (int) transferTrackerStats.consecutiveFailuresCount);
        assertEquals(timeToAdd, transferTracker.getDirectoryFileTransferTracker().getTotalTransferTimeInMs());
 * The OpenSearch Contributors require contributions made to
            }
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
        );
        transferTracker.updateLocalRefreshTimeMs(refreshTimeMs);
        transferTracker.addUploadBytesStarted(bytesToAdd + moreBytesToAdd);
    public void testGetShardId() {
    }
        assertEquals(115L, transferTracker.getBytesLag());
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
        assertEquals(0, transferTracker.getConsecutiveFailureCount());
        transferTracker.updateRemoteRefreshTimeMs(refreshTimeMs);
        assertEquals((double) sum / 20, transferTracker.getDirectoryFileTransferTracker().getTransferredBytesPerSecAverage(), 0.0d);
        sum += 20;
        transferTracker = new RemoteSegmentTransferTracker(
import org.opensearch.threadpool.TestThreadPool;
        long randomSpan = randomIntBetween(50, 200);
            shardId,
}
        assertEquals(transferTracker.getUploadBytesMovingAverage(), transferTrackerStats.uploadBytesMovingAverage, 0);
        assertEquals(transferTracker.getTotalUploadsFailed(), (int) transferTrackerStats.totalUploadsFailed);
    public void testComputeBytesLag() {
        long bytesSucceeded = randomLongBetween(1000, 10000);
        transferTracker.getDirectoryFileTransferTracker().addTransferredBytesPerSec(100);
    }
        transferTracker.addUploadBytesFailed(moreBytesToAdd);
        transferTracker.addToLatestUploadedFiles("a");
import org.opensearch.index.store.DirectoryFileTransferTracker;
        assertFalse(transferTracker.getDirectoryFileTransferTracker().isTransferredBytesAverageReady());
        }
    }
        long span = 100;
            assertFalse(transferTracker.getDirectoryFileTransferTracker().isTransferredBytesAverageReady());
        transferTracker = new RemoteSegmentTransferTracker(shardId, directoryFileTransferTracker, movingAverageWindowSize);
            threadPool
                assertEquals((int) deserializedStats.localRefreshNumber, (int) transferTrackerStats.localRefreshNumber);
                    (int) deserializedStats.directoryFileTransferTrackerStats.transferredBytesPerSecMovingAverage,
 * compatible open source license.
        );
        transferTracker.addUploadBytesSucceeded(bytesToAdd);
        assertEquals(2, transferTracker.getTotalUploadsFailed());
        assertEquals(transferTracker.getTotalUploadsSucceeded(), (int) transferTrackerStats.totalUploadsSucceeded);
        for (int i = 1; i < movingAverageWindowSize; i++) {
        assertFalse(transferTracker.getDirectoryFileTransferTracker().isTransferredBytesPerSecAverageReady());
        assertEquals(0L, transferTracker.getBytesLag());
        }
    private DirectoryFileTransferTracker directoryFileTransferTracker;
        transferTracker = new RemoteSegmentTransferTracker(shardId, directoryFileTransferTracker, movingAverageWindowSize);
        long bytesToAdd = randomLongBetween(1000, 1000000);
        long sum = 0;
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
        transferTracker.incrementTotalUploadsFailed();
        assertEquals(2, transferTracker.getRejectionCount());
        transferTracker.incrementTotalUploadsStarted();
/*
            directoryFileTransferTracker,
    }
        assertEquals(bytesToAdd, transferTracker.getUploadBytesFailed());
        long bytesToAdd = randomLongBetween(1000, 1000000);
    }
        int movingAverageWindowSize = remoteStoreStatsTrackerFactory.getMovingAverageWindowSize();
        long timeToAdd = randomLongBetween(100, 200);
            assertFalse(transferTracker.isUploadBytesPerSecMovingAverageReady());
        transferTracker = constructTracker();
        assertEquals(1, transferTracker.getConsecutiveFailureCount());
    }
        assertEquals(105L, transferTracker.getBytesLag());
                    (int) transferTrackerStats.directoryFileTransferTrackerStats.transferredBytesSucceeded
        assertEquals(1, transferTracker.getTotalUploadsFailed());
                assertEquals(deserializedStats.uploadBytesMovingAverage, transferTrackerStats.uploadBytesMovingAverage, 0);
        assertEquals(timeToAdd + moreTimeToAdd, transferTracker.getDirectoryFileTransferTracker().getTotalTransferTimeInMs());
    public void testStatsObjectCreation() {
        transferTracker.incrementTotalUploadsSucceeded();
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
        fileSizeMap.put("b", 105L);
                assertEquals((int) deserializedStats.rejectionCount, (int) transferTrackerStats.rejectionCount);
            directoryFileTransferTracker,
            assertFalse(transferTracker.isUploadBytesMovingAverageReady());
        transferTracker = new RemoteSegmentTransferTracker(
    }
    public void testGetConsecutiveFailureCount() {
        return transferTracker;
        Map<String, Long> fileSizeMap = new HashMap<>();
                RemoteSegmentTransferTracker.Stats deserializedStats = new RemoteSegmentTransferTracker.Stats(in);
        assertFalse(transferTracker.isUploadTimeMovingAverageReady());
     * */
            sum += i;
import org.opensearch.test.ClusterServiceUtils;
    public void testComputeTimeLagOnUpdate() throws InterruptedException {
                    (int) transferTrackerStats.directoryFileTransferTrackerStats.transferredBytesStarted
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
        assertEquals(transferTracker.getShardId(), transferTrackerStats.shardId);
        assertTrue(transferTracker.isUploadBytesPerSecMovingAverageReady());
        assertEquals(transferTracker.getUploadBytesSucceeded(), (int) transferTrackerStats.uploadBytesSucceeded);
        transferTracker.addUploadBytesFailed(bytesFailed);
    }
        assertEquals(transferTracker.getTotalUploadsStarted(), (int) transferTrackerStats.totalUploadsStarted);
        assertEquals(refreshSeqNo, transferTracker.getLocalRefreshSeqNo());
            shardId,
            sum += i;
    public void testComputeSeqNoLagOnUpdate() {
        assertEquals((double) sum / 20, transferTracker.getDirectoryFileTransferTracker().getTransferredBytesAverage(), 0.0d);
        transferTracker.addUploadBytesSucceeded(bytesSucceeded);
        transferTracker.getDirectoryFileTransferTracker().addTransferredBytesSucceeded(bytesToAdd, System.currentTimeMillis());
    }
        long sum = 0;
            new DirectoryFileTransferTracker(),
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
            shardId,
 *
            shardId,
        transferTracker.getDirectoryFileTransferTracker().addTransferredBytesPerSec(5);
        sum = sum + 100 - 1;
        transferTracker.incrementRejectionCount();
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
        assertEquals(transferTracker.getRejectionCount(), (int) transferTrackerStats.rejectionCount);
        transferTracker = new RemoteSegmentTransferTracker(
    }
        clusterService = ClusterServiceUtils.createClusterService(
        transferTracker.incrementTotalUploadsStarted();
        assertEquals(transferTracker.getUploadBytesFailed(), (int) transferTrackerStats.uploadBytesFailed);
        long moreBytesToAdd = randomLongBetween(1000, 10000);
        assertTrue("Actual lag [" + lag + "ms] is not expected to be shorter than span [" + span + "ms]", lag >= span);
        long lag = transferTracker.getTimeMsLag();
            sum += i;
        sum += 20;
            directoryFileTransferTracker,
        transferTracker = new RemoteSegmentTransferTracker(
        long refreshTimeMs = currentTimeMsUsingSystemNanos() + randomIntBetween(10, 100);
        transferTracker.getDirectoryFileTransferTracker().addTransferredBytesStarted(10);
public class RemoteSegmentTransferTrackerTests extends OpenSearchTestCase {
                    (int) transferTrackerStats.directoryFileTransferTrackerStats.transferredBytesPerSecMovingAverage
        RemoteSegmentTransferTracker.Stats transferTrackerStats = transferTracker.stats();
        assertEquals(1, transferTracker.getRejectionCount());
    @Override
        assertEquals(2, transferTracker.getTotalUploadsStarted());
        assertTrue(transferTracker.isUploadBytesMovingAverageReady());
        RemoteSegmentTransferTracker transferTracker = new RemoteSegmentTransferTracker(
        );
                assertEquals((int) deserializedStats.remoteRefreshNumber, (int) transferTrackerStats.remoteRefreshNumber);
    public void testUpdateLocalRefreshTimeMs() {
        transferTracker.getDirectoryFileTransferTracker().addTransferredBytesFailed(bytesToAdd, System.currentTimeMillis());
        );
    public void testIncrementTotalUploadsStarted() {
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
            directoryFileTransferTracker,
    }
    public void tearDown() throws Exception {
        transferTracker.updateUploadBytesMovingAverage(movingAverageWindowSize);
        transferTracker.updateUploadBytesPerSecMovingAverage(100);
        transferTracker.addUploadBytesSucceeded(moreBytesToAdd);
            shardId,
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        for (int i = 1; i < 20; i++) {
            directoryFileTransferTracker,
        long refreshSeqNo = 2;
                assertEquals((int) deserializedStats.bytesLag, (int) transferTrackerStats.bytesLag);
        long moreTimeToAdd = randomLongBetween(100, 200);
    }
        transferTracker.addUploadTimeInMillis(moreTimeToAdd);
        transferTracker.addUploadTimeInMillis(timeToAdd);
            shardId,
import org.opensearch.common.io.stream.BytesStreamOutput;
        transferTracker = new RemoteSegmentTransferTracker(
        sum = sum + 100 - 1;
        );
        transferTracker = new RemoteSegmentTransferTracker(
            shardId,
            shardId,
            shardId,
            Settings.EMPTY,
                    (int) deserializedStats.directoryFileTransferTrackerStats.transferredBytesStarted,
        transferTracker.getDirectoryFileTransferTracker().addTransferredBytesFailed(moreBytesToAdd, System.currentTimeMillis());
        for (int i = 1; i < 20; i++) {
    }
import org.opensearch.common.settings.ClusterSettings;
        assertEquals((double) sum / movingAverageWindowSize, transferTracker.getUploadBytesMovingAverage(), 0.0d);
                assertEquals(deserializedStats.uploadBytesPerSecMovingAverage, transferTrackerStats.uploadBytesPerSecMovingAverage, 0);
            directoryFileTransferTracker,
            shardId,
        long moreBytesToAdd = randomLongBetween(1000, 10000);
        );
        transferTracker = new RemoteSegmentTransferTracker(
            directoryFileTransferTracker,
    public void setUp() throws Exception {
        remoteStoreStatsTrackerFactory = new RemoteStoreStatsTrackerFactory(clusterService, Settings.EMPTY);
        assertEquals(bytesToAdd, transferTracker.getUploadBytesSucceeded());
        super.tearDown();
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        transferTracker.incrementTotalUploadsStarted();
        // No lag if there is a remote upload corresponding to a local refresh
        assertEquals(transferTracker.getUploadTimeMovingAverage(), transferTrackerStats.uploadTimeMovingAverage, 0);
        assertEquals(transferTracker.getBytesLag(), (int) transferTrackerStats.bytesLag);
        transferTracker.getDirectoryFileTransferTracker().addTransferredBytesSucceeded(moreBytesToAdd, System.currentTimeMillis());
            assertEquals((double) sum / i, transferTracker.getUploadBytesPerSecMovingAverage(), 0.0d);
    }
        for (int i = 1; i < movingAverageWindowSize; i++) {
        assertTrue("Actual lag [" + lag + "ms] is not expected to be shorter than span [" + randomSpan + "ms]", lag >= randomSpan);
        transferTracker.updateUploadTimeMovingAverage(movingAverageWindowSize);
        transferTracker.getDirectoryFileTransferTracker().addTransferredBytesStarted(moreBytesToAdd);
    }
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
        );
            transferTracker.getDirectoryFileTransferTracker().addTransferredBytesPerSec(i);
    private RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory;
        assertEquals(2, transferTracker.getTotalUploadsSucceeded());
    public void testGetInflightUploadBytes() {
import org.opensearch.core.common.io.stream.StreamInput;
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(bytesToAdd + moreBytesToAdd, transferTracker.getDirectoryFileTransferTracker().getTransferredBytesSucceeded());
        transferTracker = new RemoteSegmentTransferTracker(
        transferTracker = constructTracker();
    }
            directoryFileTransferTracker,
        }
        );
        transferTracker.updateLocalRefreshSeqNo(localRefreshSeqNo);
        transferTracker.addUploadBytesFailed(bytesToAdd);
            shardId,
    public void testIsUploadTimeMsAverageReady() {
    public void testUpdateRemoteRefreshTimeMs() {
        transferTracker.incrementTotalUploadsStarted();
        transferTracker.incrementTotalUploadsSucceeded();
        transferTracker.addToLatestUploadedFiles("b");
    }
    public void testAddDownloadBytesStarted() {
        transferTracker.incrementTotalUploadsFailed();
        long moreBytesToAdd = randomLongBetween(1000, 10000);
        transferTracker.updateLatestLocalFileNameLengthMap(fileSizeMap.keySet(), fileSizeMap::get);
    public void testLastDownloadTimestampMs() {
        transferTracker.incrementTotalUploadsStarted();
        transferTracker.incrementTotalUploadsStarted();
                assertEquals(
            assertFalse(transferTracker.getDirectoryFileTransferTracker().isTransferredBytesPerSecAverageReady());
        transferTracker.updateLocalRefreshTimeMs(currentTimeMsUsingSystemNanos());
        transferTracker.incrementRejectionCount();
    private ThreadPool threadPool;
    }
        transferTracker.getDirectoryFileTransferTracker().updateSuccessfulTransferSize(20);
import java.util.HashMap;
        fileSizeMap.put("c", 115L);
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
    public void testAddDownloadBytesFailed() {
    public void testAddDownloadBytesSucceeded() {
            shardId,
        transferTracker.updateUploadTimeMovingAverage(currentTimeMsUsingSystemNanos() + randomIntBetween(10, 100));
            assertEquals((double) sum / i, transferTracker.getUploadBytesMovingAverage(), 0.0d);
    public void testIncrementTotalUploadSucceeded() {
    }
        directoryFileTransferTracker = new DirectoryFileTransferTracker();
        transferTracker.getDirectoryFileTransferTracker().updateLastTransferTimestampMs(currentTimeInMs);
        long sum = 0;
    public void testisUploadBytesMovingAverageReady() {
            directoryFileTransferTracker,
        transferTracker.incrementTotalUploadsStarted();
        int remoteRefreshSeqNo = randomIntBetween(20, 50);
                assertEquals((int) deserializedStats.totalUploadsSucceeded, (int) transferTrackerStats.totalUploadsSucceeded);
            shardId,
        assertEquals(bytesToAdd, transferTracker.getUploadBytesStarted());
            shardId,
        transferTracker = new RemoteSegmentTransferTracker(
            directoryFileTransferTracker,
        assertEquals(220L, transferTracker.getBytesLag());
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
        sum += movingAverageWindowSize;
        );
        );
        assertEquals(timeToAdd + moreTimeToAdd, transferTracker.getTotalUploadTimeInMillis());
            directoryFileTransferTracker,
            try (StreamInput in = out.bytes().streamInput()) {
    }
        long moreBytesToAdd = randomLongBetween(1000, 10000);
     */
        long sum = 0;
    private RemoteSegmentTransferTracker transferTracker;
    public void testUpdateLocalRefreshSeqNo() {
    public void testAddUploadBytesStarted() {
        );
        }
        }
            directoryFileTransferTracker,
        );
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
        transferTracker.getDirectoryFileTransferTracker().addTotalTransferTimeInMs(timeToAdd);
        transferTracker.incrementTotalUploadsStarted();
            shardId,
        assertEquals(timeToAdd, transferTracker.getTotalUploadTimeInMillis());
            directoryFileTransferTracker,
    }
        assertEquals(1, transferTracker.getInflightUploads());
            transferTracker.updateUploadTimeMovingAverage(i);
            shardId,
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
                assertEquals(deserializedStats.uploadTimeMovingAverage, transferTrackerStats.uploadTimeMovingAverage, 0);
        );
import java.util.List;
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
        transferTracker = new RemoteSegmentTransferTracker(
        assertEquals(0, transferTracker.getInflightUploads());
        assertEquals((double) sum / movingAverageWindowSize, transferTracker.getUploadTimeMovingAverage(), 0.0d);
    private ShardId shardId;
        assertEquals(1, transferTracker.getTotalUploadsSucceeded());
    }
        assertEquals(bytesToAdd, transferTracker.getDirectoryFileTransferTracker().getTransferredBytesStarted());
            shardId,
import static org.opensearch.index.remote.RemoteSegmentTransferTracker.currentTimeMsUsingSystemNanos;
        assertEquals(bytesStarted - bytesSucceeded - bytesFailed, transferTracker.getInflightUploadBytes());
            assertEquals((double) sum / i, transferTracker.getUploadTimeMovingAverage(), 0.0d);
        long bytesStarted = randomLongBetween(12000, 100000);
        transferTracker.incrementTotalUploadsSucceeded();
        sum = sum + 100 - 1;
        long refreshSeqNo = 4;
        assertEquals(refreshTimeMs, transferTracker.getRemoteRefreshTimeMs());
        transferTracker.updateUploadTimeMovingAverage(100);
        transferTracker.updateUploadBytesMovingAverage(99);
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
        long moreBytesToAdd = randomLongBetween(1000, 10000);
        assertEquals(currentTimeInMs, transferTracker.getDirectoryFileTransferTracker().getLastTransferTimestampMs());
        fileSizeMap.put("a", 100L);
        long bytesFailed = randomLongBetween(100, 1000);
        Thread.sleep(1);
        assertEquals((double) sum / movingAverageWindowSize, transferTracker.getUploadBytesPerSecMovingAverage(), 0.0d);
        );
        transferTracker.updateUploadBytesMovingAverage(100);
            transferTracker.updateUploadBytesPerSecMovingAverage(i);
    }
        transferTracker = new RemoteSegmentTransferTracker(
            assertEquals((double) sum / i, transferTracker.getDirectoryFileTransferTracker().getTransferredBytesAverage(), 0.0d);
        transferTracker.updateLatestLocalFileNameLengthMap(List.of("test"), k -> 1L);
        transferTracker.incrementTotalUploadsStarted();
        sum = sum + 100 - 1;
            shardId,
        Thread.sleep(span);
            shardId,
            transferTrackerStats.writeTo(out);
        assertTrue(Math.abs(transferTracker.getTimeMsLag() - transferTrackerStats.refreshTimeLagMs) <= 20);
    public void testGetInflightUploads() {
        transferTracker = new RemoteSegmentTransferTracker(
     * Tests whether RemoteSegmentTransferTracker.Stats object serialize and deserialize is working fine.
                assertEquals((int) deserializedStats.totalUploadsStarted, (int) transferTrackerStats.totalUploadsStarted);
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
        }
        super.setUp();
        transferTracker.updateUploadBytesPerSecMovingAverage(movingAverageWindowSize);
    public void testIncrementTotalUploadsFailed() {
    }
        long bytesToAdd = randomLongBetween(1000, 1000000);
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
        transferTracker.incrementRejectionCount();
        assertFalse(transferTracker.isUploadBytesPerSecMovingAverageReady());
        transferTracker.getDirectoryFileTransferTracker().addTotalTransferTimeInMs(moreTimeToAdd);
import org.opensearch.core.index.shard.ShardId;
        transferTracker = new RemoteSegmentTransferTracker(
        long bytesToAdd = randomLongBetween(1000, 1000000);
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
import org.opensearch.threadpool.ThreadPool;
import java.io.IOException;
        );
            shardId,
        );
        transferTracker.updateRemoteRefreshTimeMs(transferTracker.getLocalRefreshTimeMs());
        long moreTimeToAdd = randomLongBetween(100, 200);
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
        transferTracker.incrementTotalUploadsStarted();
    public void testAddTotalUploadTimeInMs() {
            directoryFileTransferTracker,
        assertEquals((double) sum / 20, transferTracker.getDirectoryFileTransferTracker().getTransferredBytesPerSecAverage(), 0.0d);
        transferTracker.updateLocalRefreshSeqNo(refreshSeqNo);
                assertEquals((int) deserializedStats.totalUploadsFailed, (int) transferTrackerStats.totalUploadsFailed);
            directoryFileTransferTracker,
        assertEquals(bytesToAdd, transferTracker.getDirectoryFileTransferTracker().getTransferredBytesFailed());
        assertEquals(transferTracker.getRemoteRefreshSeqNo(), (int) transferTrackerStats.remoteRefreshNumber);
        );
    }
    public void testUpdateRemoteRefreshSeqNo() {
    public void testIsUploadBytesPerSecAverageReady() {
            directoryFileTransferTracker,
 * SPDX-License-Identifier: Apache-2.0
        transferTracker.incrementTotalUploadsStarted();
    private ClusterService clusterService;
            shardId,
        transferTracker.updateLocalRefreshTimeMs(currentTimeMsUsingSystemNanos());
        assertEquals(2, transferTracker.getInflightUploads());
        assertEquals(bytesToAdd + moreBytesToAdd, transferTracker.getUploadBytesFailed());
        transferTracker.incrementTotalUploadsStarted();
            assertEquals((double) sum / i, transferTracker.getDirectoryFileTransferTracker().getTransferredBytesPerSecAverage(), 0.0d);
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
            directoryFileTransferTracker,
    }
        transferTracker.getDirectoryFileTransferTracker().addTransferredBytesSucceeded(10, System.currentTimeMillis());
    }
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
                assertEquals(deserializedStats.shardId, transferTrackerStats.shardId);
        transferTracker.incrementTotalUploadsFailed();
        transferTracker.incrementTotalUploadsFailed();
    @Override
     * This comes into play during internode data transfer.
    /**
        transferTracker.incrementTotalUploadsFailed();
        transferTracker = new RemoteSegmentTransferTracker(
        assertEquals(transferTracker.getUploadBytesPerSecMovingAverage(), transferTrackerStats.uploadBytesPerSecMovingAverage, 0);
                assertEquals((int) deserializedStats.uploadBytesFailed, (int) transferTrackerStats.uploadBytesFailed);
            directoryFileTransferTracker,
                );
        transferTracker.addUploadBytesStarted(bytesStarted);
            shardId,
            shardId,
        long currentTimeInMs = System.currentTimeMillis();
        transferTracker = new RemoteSegmentTransferTracker(
        sum = sum + 100 - 1;
            directoryFileTransferTracker,
                assertEquals(
            sum += i;
 */
        transferTracker = new RemoteSegmentTransferTracker(
        transferTracker.getDirectoryFileTransferTracker().updateSuccessfulTransferSize(100);
            assertFalse(transferTracker.isUploadTimeMovingAverageReady());
        transferTracker.updateRemoteRefreshSeqNo(remoteRefreshSeqNo);
        assertEquals(shardId, transferTracker.getShardId());
            directoryFileTransferTracker,
        sum += movingAverageWindowSize;
        assertTrue(transferTracker.isUploadTimeMovingAverageReady());
        transferTracker = new RemoteSegmentTransferTracker(
        transferTracker = new RemoteSegmentTransferTracker(
            directoryFileTransferTracker,
        assertEquals(0, transferTracker.getTimeMsLag());
            shardId,
        transferTracker.addToLatestUploadedFiles("c");
        assertEquals(localRefreshSeqNo - remoteRefreshSeqNo, transferTracker.getRefreshSeqNoLag());
        transferTracker.incrementTotalUploadsSucceeded();
        transferTracker = new RemoteSegmentTransferTracker(
        assertEquals(refreshSeqNo, transferTracker.getRemoteRefreshSeqNo());
                    (int) deserializedStats.directoryFileTransferTrackerStats.transferredBytesSucceeded,
        // Sleep for 100ms and then the lag should not be shorter
    public void testAddUploadBytesSucceeded() {
        transferTracker.addUploadBytesStarted(bytesToAdd);
    /**
        );
        assertEquals(bytesToAdd, transferTracker.getDirectoryFileTransferTracker().getTransferredBytesSucceeded());
            sum += i;
        transferTracker.getDirectoryFileTransferTracker().addTransferredBytesPerSec(20);
        transferTracker = new RemoteSegmentTransferTracker(
        Thread.sleep(randomSpan);
                assertEquals((int) deserializedStats.refreshTimeLagMs, (int) transferTrackerStats.refreshTimeLagMs);
        assertEquals(refreshTimeMs, transferTracker.getLocalRefreshTimeMs());
import java.util.Map;
        transferTracker = new RemoteSegmentTransferTracker(
            shardId,
            shardId,
        transferTracker.updateRemoteRefreshSeqNo(refreshSeqNo);
            shardId,
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
                );
     * Tests whether RemoteSegmentTransferTracker.Stats object generated correctly from RemoteSegmentTransferTracker.
        long moreBytesToAdd = randomLongBetween(1000, 10000);
    }
        int movingAverageWindowSize = remoteStoreStatsTrackerFactory.getMovingAverageWindowSize();
        threadPool.shutdownNow();
        assertEquals(transferTracker.getUploadBytesStarted(), (int) transferTrackerStats.uploadBytesStarted);
        );
        transferTracker.getDirectoryFileTransferTracker().addTransferredBytesStarted(bytesToAdd);
