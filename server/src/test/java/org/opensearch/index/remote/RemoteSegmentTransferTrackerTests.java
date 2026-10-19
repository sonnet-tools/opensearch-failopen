    public void testGetConsecutiveFailureCount() {
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
            shardId,
        super.tearDown();  
        transferTracker = new RemoteSegmentTransferTracker(shardId, directoryFileTransferTracker, movingAverageWindowSize);
        sum += 20;
    }  
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()  
            directoryFileTransferTracker,
        for (int i = 1; i < 20; i++) {  
        assertEquals(bytesToAdd + moreBytesToAdd, transferTracker.getUploadBytesFailed());
    public void testIsUploadTimeMsAverageReady() {
            assertFalse(transferTracker.getDirectoryFileTransferTracker().isTransferredBytesPerSecAverageReady());  
                );
        assertEquals(refreshTimeMs, transferTracker.getRemoteRefreshTimeMs());  
        Thread.sleep(randomSpan);
        int movingAverageWindowSize = remoteStoreStatsTrackerFactory.getMovingAverageWindowSize();
        transferTracker.updateUploadTimeMovingAverage(100);
    }
        assertTrue("Actual lag [" + lag + "ms] is not expected to be shorter than span [" + span + "ms]", lag >= span);
        long lag = transferTracker.getTimeMsLag();
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
    private RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory;  
        RemoteSegmentTransferTracker transferTracker = new RemoteSegmentTransferTracker(
        assertEquals(220L, transferTracker.getBytesLag());
                assertEquals((int) deserializedStats.totalUploadsSucceeded, (int) transferTrackerStats.totalUploadsSucceeded);
        assertFalse(transferTracker.isUploadBytesPerSecMovingAverageReady());  
        transferTracker = new RemoteSegmentTransferTracker(
            shardId,
        transferTracker = new RemoteSegmentTransferTracker(
        transferTracker.updateLatestLocalFileNameLengthMap(List.of("test"), k -> 1L);  
        transferTracker.addToLatestUploadedFiles("c");  
    }
    private RemoteSegmentTransferTracker constructTracker() {
        transferTracker = new RemoteSegmentTransferTracker(
        assertEquals(bytesToAdd + moreBytesToAdd, transferTracker.getUploadBytesSucceeded());
    public void testIsDownloadBytesPerSecAverageReady() {  
        long bytesFailed = randomLongBetween(100, 1000);
                assertEquals((int) deserializedStats.remoteRefreshNumber, (int) transferTrackerStats.remoteRefreshNumber);
            shardId,  
        long bytesToAdd = randomLongBetween(1000, 1000000);  
        );  
            directoryFileTransferTracker,
    public void testIncrementRejectionCount() {
        Map<String, Long> fileSizeMap = new HashMap<>();
        transferTracker.addUploadBytesStarted(bytesToAdd);
        assertEquals(2, transferTracker.getConsecutiveFailureCount());
        transferTracker.incrementTotalUploadsFailed();
    public void testUpdateLocalRefreshTimeMs() {
    public void testGetInflightUploadBytes() {
                assertEquals(deserializedStats.shardId, transferTrackerStats.shardId);
            directoryFileTransferTracker,  
                    (int) transferTrackerStats.directoryFileTransferTrackerStats.transferredBytesSucceeded  
                assertEquals((int) deserializedStats.consecutiveFailuresCount, (int) transferTrackerStats.consecutiveFailuresCount);
        transferTracker.addUploadBytesFailed(moreBytesToAdd);
        assertEquals(transferTracker.getTotalUploadsFailed(), (int) transferTrackerStats.totalUploadsFailed);  
            assertFalse(transferTracker.isUploadTimeMovingAverageReady());
        transferTracker = new RemoteSegmentTransferTracker(
    public void testAddUploadBytesStarted() {  
    public void testIncrementTotalUploadSucceeded() {
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()  
            shardId,
        sum = sum + 100 - 1;
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
            directoryFileTransferTracker,
        transferTracker.incrementTotalUploadsStarted();  
                assertEquals((int) deserializedStats.uploadBytesFailed, (int) transferTrackerStats.uploadBytesFailed);
    public void testAddTotalTransferTimeMs() {
        transferTracker = new RemoteSegmentTransferTracker(  
        assertEquals(timeToAdd + moreTimeToAdd, transferTracker.getTotalUploadTimeInMillis());
        assertEquals(transferTracker.getUploadBytesFailed(), (int) transferTrackerStats.uploadBytesFailed);  
        transferTracker.incrementTotalUploadsFailed();  
        // Sleep for 100ms and then the lag should not be shorter
import org.opensearch.common.settings.Settings;
            transferTracker.getDirectoryFileTransferTracker().updateSuccessfulTransferSize(i);
        long sum = 0;
        transferTracker.addUploadBytesFailed(bytesFailed);
        RemoteSegmentTransferTracker.Stats transferTrackerStats = transferTracker.stats();  
        sum += movingAverageWindowSize;
        );  
        assertEquals((double) sum / movingAverageWindowSize, transferTracker.getUploadBytesPerSecMovingAverage(), 0.0d);
        for (int i = 1; i < movingAverageWindowSize; i++) {  
        long sum = 0;  
        assertEquals(bytesStarted - bytesSucceeded - bytesFailed, transferTracker.getInflightUploadBytes());
        transferTracker = new RemoteSegmentTransferTracker(  
            directoryFileTransferTracker,
        assertEquals(205L, transferTracker.getBytesLag());  
            shardId,
        );
            directoryFileTransferTracker,
            shardId,
        long moreBytesToAdd = randomLongBetween(1000, 10000);  
            sum += i;  
            directoryFileTransferTracker,
    }  
        assertEquals(transferTracker.getUploadBytesStarted(), (int) transferTrackerStats.uploadBytesStarted);
        long bytesToAdd = randomLongBetween(1000, 1000000);
     * Tests whether RemoteSegmentTransferTracker.Stats object serialize and deserialize is working fine.
    }
        transferTracker.addUploadBytesSucceeded(bytesSucceeded);  
        assertEquals(2, transferTracker.getInflightUploads());  
        transferTracker.addUploadBytesStarted(moreBytesToAdd);
                    (int) deserializedStats.directoryFileTransferTrackerStats.transferredBytesSucceeded,
                assertEquals(
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()  
 */  
            assertFalse(transferTracker.getDirectoryFileTransferTracker().isTransferredBytesAverageReady());
        transferTracker.incrementTotalUploadsSucceeded();
                    (int) transferTrackerStats.directoryFileTransferTrackerStats.transferredBytesStarted
            transferTracker.updateUploadBytesPerSecMovingAverage(i);
            shardId,  
        long span = 100;
        remoteStoreStatsTrackerFactory = new RemoteStoreStatsTrackerFactory(clusterService, Settings.EMPTY);
import org.opensearch.common.settings.ClusterSettings;  
        assertEquals(refreshTimeMs, transferTracker.getLocalRefreshTimeMs());
    public void tearDown() throws Exception {
        );  
        transferTracker.getDirectoryFileTransferTracker().addTransferredBytesPerSec(20);
        transferTracker.incrementTotalUploadsStarted();
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
        assertEquals(0, transferTracker.getTimeMsLag());  
    }
    private ThreadPool threadPool;  
        transferTracker.updateUploadTimeMovingAverage(currentTimeMsUsingSystemNanos() + randomIntBetween(10, 100));  
import java.util.HashMap;
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()  
                    (int) transferTrackerStats.directoryFileTransferTrackerStats.transferredBytesPerSecMovingAverage
        assertEquals(2, transferTracker.getRejectionCount());
        transferTracker.incrementTotalUploadsFailed();
            shardId,
                assertEquals((int) deserializedStats.bytesLag, (int) transferTrackerStats.bytesLag);  
        transferTracker.getDirectoryFileTransferTracker().addTransferredBytesStarted(10);
        sum = sum + 100 - 1;
        long moreBytesToAdd = randomLongBetween(1000, 10000);
        transferTracker.incrementTotalUploadsFailed();
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
                assertEquals(deserializedStats.uploadTimeMovingAverage, transferTrackerStats.uploadTimeMovingAverage, 0);
    }
        );
            sum += i;
        assertEquals((double) sum / movingAverageWindowSize, transferTracker.getUploadBytesMovingAverage(), 0.0d);  
    public void testIsUploadBytesPerSecAverageReady() {  
        assertTrue(transferTracker.getDirectoryFileTransferTracker().isTransferredBytesPerSecAverageReady());  
            shardId,
    }  
    public void testAddDownloadBytesSucceeded() {  
        long refreshTimeMs = currentTimeMsUsingSystemNanos() + randomIntBetween(10, 100);
import org.opensearch.cluster.service.ClusterService;
    }
        transferTracker.getDirectoryFileTransferTracker().addTransferredBytesFailed(bytesToAdd, System.currentTimeMillis());
        );
        transferTracker.getDirectoryFileTransferTracker().addTransferredBytesPerSec(100);  
        assertEquals(transferTracker.getBytesLag(), (int) transferTrackerStats.bytesLag);
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()  
        assertEquals((double) sum / 20, transferTracker.getDirectoryFileTransferTracker().getTransferredBytesPerSecAverage(), 0.0d);
            directoryFileTransferTracker,
    public void testisUploadBytesMovingAverageReady() {
        assertEquals(transferTracker.getRemoteRefreshSeqNo(), (int) transferTrackerStats.remoteRefreshNumber);  
        transferTracker.incrementTotalUploadsStarted();
        transferTracker = new RemoteSegmentTransferTracker(
        assertEquals(1, transferTracker.getTotalUploadsFailed());
        transferTracker.updateUploadTimeMovingAverage(movingAverageWindowSize);  
        long sum = 0;  
        assertEquals(0L, transferTracker.getBytesLag());
        transferTracker.updateLocalRefreshTimeMs(currentTimeMsUsingSystemNanos());
        );
        threadPool.shutdownNow();
        assertEquals(2, transferTracker.getTotalUploadsFailed());
        assertEquals(1, transferTracker.getInflightUploads());
        int movingAverageWindowSize = remoteStoreStatsTrackerFactory.getMovingAverageWindowSize();  
            shardId,  
    }
        super.setUp();
    }
        long sum = 0;
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
            directoryFileTransferTracker,
import static org.opensearch.index.remote.RemoteSegmentTransferTracker.currentTimeMsUsingSystemNanos;  
        transferTracker.addToLatestUploadedFiles("b");  
        Thread.sleep(1);  
    @Override
        assertEquals(1, transferTracker.getRejectionCount());
        assertEquals(bytesToAdd, transferTracker.getUploadBytesStarted());
        transferTracker.incrementRejectionCount();  
        transferTracker = new RemoteSegmentTransferTracker(  
            assertFalse(transferTracker.isUploadBytesPerSecMovingAverageReady());  
        assertTrue(transferTracker.getDirectoryFileTransferTracker().isTransferredBytesAverageReady());
        assertEquals(transferTracker.getUploadBytesSucceeded(), (int) transferTrackerStats.uploadBytesSucceeded);
        transferTracker.incrementTotalUploadsStarted();
import org.opensearch.test.ClusterServiceUtils;
        assertTrue(transferTracker.isUploadBytesMovingAverageReady());
            directoryFileTransferTracker,
        transferTracker = new RemoteSegmentTransferTracker(
                RemoteSegmentTransferTracker.Stats deserializedStats = new RemoteSegmentTransferTracker.Stats(in);
    /**  
        transferTracker.incrementTotalUploadsSucceeded();  
                assertEquals((int) deserializedStats.rejectionCount, (int) transferTrackerStats.rejectionCount);
            shardId,
            sum += i;  
    }
        sum += movingAverageWindowSize;  
        transferTracker.incrementRejectionCount();  
        transferTracker.addUploadBytesFailed(bytesToAdd);
        // No lag if there is a remote upload corresponding to a local refresh
    public void testIncrementTotalUploadsFailed() {
            assertEquals((double) sum / i, transferTracker.getUploadTimeMovingAverage(), 0.0d);  
    public void testComputeTimeLagOnUpdate() throws InterruptedException {
    }  
        assertFalse(transferTracker.getDirectoryFileTransferTracker().isTransferredBytesAverageReady());
        transferTracker = new RemoteSegmentTransferTracker(  
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
        assertEquals((double) sum / movingAverageWindowSize, transferTracker.getUploadBytesMovingAverage(), 0.0d);
        assertEquals(2, transferTracker.getTotalUploadsSucceeded());  
            shardId,
     * This comes into play during internode data transfer.
        assertEquals(currentTimeInMs, transferTracker.getDirectoryFileTransferTracker().getLastTransferTimestampMs());
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
        assertEquals(transferTracker.getTotalUploadsSucceeded(), (int) transferTrackerStats.totalUploadsSucceeded);
        }
                assertEquals(deserializedStats.uploadBytesPerSecMovingAverage, transferTrackerStats.uploadBytesPerSecMovingAverage, 0);
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
        );
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
        long bytesToAdd = randomLongBetween(1000, 1000000);
        long bytesToAdd = randomLongBetween(1000, 1000000);
        transferTracker = new RemoteSegmentTransferTracker(  
    }  
        assertEquals(transferTracker.getLocalRefreshSeqNo(), (int) transferTrackerStats.localRefreshNumber);
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
        long moreTimeToAdd = randomLongBetween(100, 200);
        transferTracker.incrementTotalUploadsStarted();  
    public void testStatsObjectCreationViaStream() throws IOException {
            directoryFileTransferTracker,
        );  
            assertFalse(transferTracker.isUploadBytesMovingAverageReady());
    }
        sum = sum + 100 - 1;  
        // Create local file size map
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
                );
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        transferTracker.getDirectoryFileTransferTracker().addTransferredBytesSucceeded(bytesToAdd, System.currentTimeMillis());
        transferTracker.incrementRejectionCount();
        assertEquals((double) sum / 20, transferTracker.getDirectoryFileTransferTracker().getTransferredBytesAverage(), 0.0d);
        transferTracker = new RemoteSegmentTransferTracker(  
        transferTracker = new RemoteSegmentTransferTracker(
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
import java.util.List;  
 * SPDX-License-Identifier: Apache-2.0
            shardId,
        transferTracker.getDirectoryFileTransferTracker().addTotalTransferTimeInMs(moreTimeToAdd);
            directoryFileTransferTracker,  
        long bytesStarted = randomLongBetween(12000, 100000);
    }
        transferTracker.getDirectoryFileTransferTracker().updateSuccessfulTransferSize(100);
        assertEquals(1, transferTracker.getTotalUploadsStarted());  
        );
    private ShardId shardId;
        int movingAverageWindowSize = remoteStoreStatsTrackerFactory.getMovingAverageWindowSize();
    }
        transferTracker.getDirectoryFileTransferTracker().addTransferredBytesStarted(bytesToAdd);  
            shardId,
        long refreshSeqNo = 4;  
            shardId,
        assertFalse(transferTracker.isUploadBytesMovingAverageReady());
        transferTracker = new RemoteSegmentTransferTracker(
                assertEquals((int) deserializedStats.localRefreshNumber, (int) transferTrackerStats.localRefreshNumber);
            directoryFileTransferTracker,  
        shardId = new ShardId("index", "uuid", 0);  
    public void testAddDownloadBytesFailed() {
            assertEquals((double) sum / i, transferTracker.getDirectoryFileTransferTracker().getTransferredBytesAverage(), 0.0d);
        assertTrue(transferTracker.isUploadTimeMovingAverageReady());
 * this file be licensed under the Apache-2.0 license or a
        transferTracker = new RemoteSegmentTransferTracker(
            shardId,  
        transferTracker.incrementTotalUploadsStarted();  
        );  
        assertEquals(timeToAdd, transferTracker.getDirectoryFileTransferTracker().getTotalTransferTimeInMs());  
        );
            assertEquals((double) sum / i, transferTracker.getDirectoryFileTransferTracker().getTransferredBytesPerSecAverage(), 0.0d);
    public void testUpdateLocalRefreshSeqNo() {
        assertEquals(refreshSeqNo, transferTracker.getRemoteRefreshSeqNo());
    }
        assertEquals((double) sum / movingAverageWindowSize, transferTracker.getUploadBytesPerSecMovingAverage(), 0.0d);
        assertEquals(transferTracker.getUploadBytesMovingAverage(), transferTrackerStats.uploadBytesMovingAverage, 0);
            try (StreamInput in = out.bytes().streamInput()) {  
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()  
 * compatible open source license.
        transferTracker.addUploadBytesSucceeded(bytesToAdd);
            shardId,  
        }  
        assertEquals(bytesToAdd, transferTracker.getDirectoryFileTransferTracker().getTransferredBytesStarted());
        sum = sum + 100 - 1;
            directoryFileTransferTracker,
            transferTracker.updateUploadBytesMovingAverage(i);
        transferTracker = new RemoteSegmentTransferTracker(
        transferTracker.updateUploadBytesPerSecMovingAverage(100);  
            directoryFileTransferTracker,
        transferTracker = new RemoteSegmentTransferTracker(
        );
            directoryFileTransferTracker,
    }  
            shardId,  
        assertEquals(0, transferTracker.getInflightUploads());
    }
        transferTracker.incrementTotalUploadsStarted();
        );  
        long randomSpan = randomIntBetween(50, 200);  
        transferTracker.getDirectoryFileTransferTracker().updateSuccessfulTransferSize(20);
    }  
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
            directoryFileTransferTracker,
        transferTracker.updateLatestLocalFileNameLengthMap(fileSizeMap.keySet(), fileSizeMap::get);
            shardId,
        long timeToAdd = randomLongBetween(100, 200);
    public void testAddUploadBytesSucceeded() {
        long moreTimeToAdd = randomLongBetween(100, 200);
import org.opensearch.core.common.io.stream.StreamInput;
        );
        transferTracker = new RemoteSegmentTransferTracker(
        assertEquals(bytesToAdd, transferTracker.getUploadBytesSucceeded());  
    /**  
        transferTracker.incrementTotalUploadsStarted();
        transferTracker.updateUploadBytesPerSecMovingAverage(movingAverageWindowSize);
        for (int i = 1; i < movingAverageWindowSize; i++) {
        assertTrue(transferTracker.isUploadBytesPerSecMovingAverageReady());  
        sum = sum + 100 - 1;
            directoryFileTransferTracker,
        long refreshTimeMs = currentTimeMsUsingSystemNanos() + randomIntBetween(10, 100);
        assertEquals(1, transferTracker.getConsecutiveFailureCount());
                assertEquals((int) deserializedStats.uploadBytesSucceeded, (int) transferTrackerStats.uploadBytesSucceeded);
        assertFalse(transferTracker.getDirectoryFileTransferTracker().isTransferredBytesPerSecAverageReady());  
        assertEquals(shardId, transferTracker.getShardId());
    }
        assertEquals(0, transferTracker.getConsecutiveFailureCount());  
            shardId,  
        transferTracker = new RemoteSegmentTransferTracker(shardId, directoryFileTransferTracker, movingAverageWindowSize);
        transferTracker.getDirectoryFileTransferTracker().updateLastTransferTimestampMs(currentTimeInMs);
import java.util.Map;
    @Override
        assertFalse(transferTracker.isUploadTimeMovingAverageReady());
    }
        long moreBytesToAdd = randomLongBetween(1000, 10000);  
    public void setUp() throws Exception {  
        transferTracker.incrementTotalUploadsSucceeded();
        transferTracker.updateLocalRefreshSeqNo(localRefreshSeqNo);
            Settings.EMPTY,
    }
    private ClusterService clusterService;
        transferTracker = new RemoteSegmentTransferTracker(  
    }
import java.io.IOException;
        for (int i = 1; i < 20; i++) {
        assertEquals(bytesToAdd, transferTracker.getDirectoryFileTransferTracker().getTransferredBytesSucceeded());
        RemoteSegmentTransferTracker.Stats transferTrackerStats = transferTracker.stats();
        lag = transferTracker.getTimeMsLag();
        }
public class RemoteSegmentTransferTrackerTests extends OpenSearchTestCase {
        long bytesToAdd = randomLongBetween(1000, 1000000);
        long refreshSeqNo = 2;
            assertEquals((double) sum / i, transferTracker.getUploadBytesMovingAverage(), 0.0d);
        assertEquals(localRefreshSeqNo - remoteRefreshSeqNo, transferTracker.getRefreshSeqNoLag());
        transferTracker.incrementTotalUploadsStarted();
            transferTracker.updateUploadTimeMovingAverage(i);  
            transferTrackerStats.writeTo(out);
        transferTracker = constructTracker();
            new DirectoryFileTransferTracker(),
        assertEquals(refreshSeqNo, transferTracker.getLocalRefreshSeqNo());  
        long moreBytesToAdd = randomLongBetween(1000, 10000);  
        assertEquals((double) sum / movingAverageWindowSize, transferTracker.getUploadTimeMovingAverage(), 0.0d);
        assertEquals(transferTracker.getTotalUploadsStarted(), (int) transferTrackerStats.totalUploadsStarted);
    public void testAddTotalUploadTimeInMs() {
 *
        assertEquals((double) sum / 20, transferTracker.getDirectoryFileTransferTracker().getTransferredBytesAverage(), 0.0d);  
        );
            directoryFileTransferTracker,
        transferTracker.getDirectoryFileTransferTracker().addTransferredBytesFailed(moreBytesToAdd, System.currentTimeMillis());
    public void testAddDownloadBytesStarted() {
        );
/*  
        fileSizeMap.put("b", 105L);
        assertEquals(timeToAdd, transferTracker.getTotalUploadTimeInMillis());
     * */
        long sum = 0;
        assertEquals(bytesToAdd + moreBytesToAdd, transferTracker.getDirectoryFileTransferTracker().getTransferredBytesFailed());  
    public void testComputeBytesLag() {  
        transferTracker.incrementTotalUploadsFailed();  
        transferTracker.addUploadTimeInMillis(moreTimeToAdd);  
            directoryFileTransferTracker,
        transferTracker.updateLocalRefreshTimeMs(currentTimeMsUsingSystemNanos());
    }  
     */  
        transferTracker = new RemoteSegmentTransferTracker(shardId, directoryFileTransferTracker, movingAverageWindowSize);  
        transferTracker.updateRemoteRefreshSeqNo(refreshSeqNo);
        transferTracker.updateRemoteRefreshTimeMs(refreshTimeMs);
        transferTracker.getDirectoryFileTransferTracker().addTransferredBytesSucceeded(10, System.currentTimeMillis());
            directoryFileTransferTracker,  
    public void testIncrementTotalUploadsStarted() {
        transferTracker.getDirectoryFileTransferTracker().addTransferredBytesStarted(moreBytesToAdd);  
    }
        assertEquals(105L, transferTracker.getBytesLag());  
        );  
        }
        assertEquals(localRefreshSeqNo, transferTracker.getRefreshSeqNoLag());
        );  
            directoryFileTransferTracker,
        assertEquals(115L, transferTracker.getBytesLag());
    }
            shardId,
        );
            threadPool  
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
        transferTracker.updateLocalRefreshTimeMs(refreshTimeMs);  
            directoryFileTransferTracker,  
            shardId,
        );
package org.opensearch.index.remote;
            directoryFileTransferTracker,  
        );  
        }
        transferTracker.incrementTotalUploadsStarted();
        transferTracker.getDirectoryFileTransferTracker().addTransferredBytesPerSec(5);  
        int remoteRefreshSeqNo = randomIntBetween(20, 50);  
        transferTracker.incrementTotalUploadsStarted();
            shardId,  
        for (int i = 1; i < movingAverageWindowSize; i++) {
        transferTracker.updateRemoteRefreshTimeMs(transferTracker.getLocalRefreshTimeMs());
}  
        transferTracker.addToLatestUploadedFiles("a");
        assertEquals(bytesToAdd + moreBytesToAdd, transferTracker.getUploadBytesStarted());
        transferTracker = new RemoteSegmentTransferTracker(
        threadPool = new TestThreadPool("remote_refresh_segment_pressure_settings_test");
    private DirectoryFileTransferTracker directoryFileTransferTracker;  
        transferTracker.incrementTotalUploadsFailed();  
        assertEquals(transferTracker.getUploadTimeMovingAverage(), transferTrackerStats.uploadTimeMovingAverage, 0);  
    public void testLastDownloadTimestampMs() {  
        Thread.sleep(span);  
        transferTracker = new RemoteSegmentTransferTracker(  
        assertEquals(transferTracker.getShardId(), transferTrackerStats.shardId);  
                assertEquals(
        long moreBytesToAdd = randomLongBetween(1000, 10000);  
        transferTracker.addUploadBytesStarted(bytesToAdd + moreBytesToAdd);
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()  
        assertEquals((double) sum / movingAverageWindowSize, transferTracker.getUploadTimeMovingAverage(), 0.0d);  
    }
        );
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()  
        }  
    public void testStatsObjectCreation() {  
        return transferTracker;
        transferTracker.updateUploadBytesMovingAverage(99);
    public void testIsDownloadBytesAverageReady() {
        long bytesSucceeded = randomLongBetween(1000, 10000);  
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
            shardId,  
        directoryFileTransferTracker = new DirectoryFileTransferTracker();
    }
    }
            }  
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
        long currentTimeInMs = System.currentTimeMillis();  
                assertEquals(  
        );  
            transferTracker.getDirectoryFileTransferTracker().addTransferredBytesPerSec(i);
        assertTrue("Actual lag [" + lag + "ms] is not expected to be shorter than span [" + randomSpan + "ms]", lag >= randomSpan);  
        transferTracker.updateRemoteRefreshTimeMs(currentTimeMsUsingSystemNanos() + randomIntBetween(10, 100));
        assertEquals(transferTracker.getConsecutiveFailureCount(), (int) transferTrackerStats.consecutiveFailuresCount);  
     * Tests whether RemoteSegmentTransferTracker.Stats object generated correctly from RemoteSegmentTransferTracker.
        transferTracker.getDirectoryFileTransferTracker().addTransferredBytesSucceeded(moreBytesToAdd, System.currentTimeMillis());
            shardId,
        transferTracker = new RemoteSegmentTransferTracker(
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()  
        assertEquals(bytesToAdd, transferTracker.getUploadBytesFailed());  
        long timeToAdd = randomLongBetween(100, 200);
                );  
    public void testUpdateRemoteRefreshSeqNo() {  
        transferTracker.updateLocalRefreshSeqNo(refreshSeqNo);
        fileSizeMap.put("c", 115L);
                assertEquals((int) deserializedStats.uploadBytesStarted, (int) transferTrackerStats.uploadBytesStarted);  
        transferTracker.addUploadBytesStarted(bytesToAdd + moreBytesToAdd);
    public void testGetShardId() {
        assertEquals(1, transferTracker.getTotalUploadsSucceeded());
        long moreBytesToAdd = randomLongBetween(1000, 10000);
            sum += i;
            assertEquals((double) sum / i, transferTracker.getUploadBytesPerSecMovingAverage(), 0.0d);
        );
            directoryFileTransferTracker,  
        );  
    public void testUpdateRemoteRefreshTimeMs() {
        sum += 20;  
                    (int) deserializedStats.directoryFileTransferTrackerStats.transferredBytesStarted,
        );
        transferTracker.addUploadBytesSucceeded(moreBytesToAdd);
        transferTracker.addUploadTimeInMillis(timeToAdd);  
        assertEquals(timeToAdd + moreTimeToAdd, transferTracker.getDirectoryFileTransferTracker().getTotalTransferTimeInMs());  
import org.opensearch.threadpool.TestThreadPool;
        transferTracker.updateUploadBytesMovingAverage(100);
        transferTracker = new RemoteSegmentTransferTracker(
        assertEquals(transferTracker.getUploadBytesPerSecMovingAverage(), transferTrackerStats.uploadBytesPerSecMovingAverage, 0);
            shardId,  
        );
        // Set a local refresh time that is higher than remote refresh time
        assertEquals(1, transferTracker.getInflightUploads());
        assertEquals(2, transferTracker.getTotalUploadsStarted());
        assertTrue(Math.abs(transferTracker.getTimeMsLag() - transferTrackerStats.refreshTimeLagMs) <= 20);
        assertEquals(bytesToAdd, transferTracker.getDirectoryFileTransferTracker().getTransferredBytesFailed());  
        assertEquals(transferTracker.getRejectionCount(), (int) transferTrackerStats.rejectionCount);
import org.opensearch.index.store.DirectoryFileTransferTracker;
import org.opensearch.threadpool.ThreadPool;
                assertEquals(deserializedStats.uploadBytesMovingAverage, transferTrackerStats.uploadBytesMovingAverage, 0);  
import org.opensearch.common.io.stream.BytesStreamOutput;
        transferTracker.incrementTotalUploadsSucceeded();
            remoteStoreStatsTrackerFactory.getMovingAverageWindowSize()
                assertEquals((int) deserializedStats.totalUploadsFailed, (int) transferTrackerStats.totalUploadsFailed);
                assertEquals((int) deserializedStats.totalUploadsStarted, (int) transferTrackerStats.totalUploadsStarted);  
        transferTracker.addUploadBytesStarted(bytesStarted);
        transferTracker.updateUploadBytesMovingAverage(movingAverageWindowSize);
        transferTracker = new RemoteSegmentTransferTracker(
 * The OpenSearch Contributors require contributions made to  
            sum += i;
import org.opensearch.test.OpenSearchTestCase;  
    public void testAddUploadBytesFailed() {
        transferTracker.incrementTotalUploadsStarted();
    }  
    private RemoteSegmentTransferTracker transferTracker;
        assertEquals(bytesToAdd + moreBytesToAdd, transferTracker.getDirectoryFileTransferTracker().getTransferredBytesStarted());
    public void testGetInflightUploads() {  
        assertEquals((double) sum / 20, transferTracker.getDirectoryFileTransferTracker().getTransferredBytesPerSecAverage(), 0.0d);
        int localRefreshSeqNo = randomIntBetween(50, 100);
    public void testComputeSeqNoLagOnUpdate() {
        assertEquals(bytesToAdd + moreBytesToAdd, transferTracker.getDirectoryFileTransferTracker().getTransferredBytesSucceeded());
        transferTracker = new RemoteSegmentTransferTracker(
        long bytesToAdd = randomLongBetween(1000, 1000000);  
            shardId,  
        clusterService = ClusterServiceUtils.createClusterService(  
        transferTracker = constructTracker();
        fileSizeMap.put("a", 100L);  
        transferTracker = new RemoteSegmentTransferTracker(  
import org.opensearch.core.index.shard.ShardId;  
        transferTracker.updateRemoteRefreshSeqNo(remoteRefreshSeqNo);  
        transferTracker.updateLatestLocalFileNameLengthMap(fileSizeMap.keySet(), fileSizeMap::get);  
    }
            directoryFileTransferTracker,
                    (int) deserializedStats.directoryFileTransferTrackerStats.transferredBytesPerSecMovingAverage,  
        sum += movingAverageWindowSize;
        transferTracker.getDirectoryFileTransferTracker().addTotalTransferTimeInMs(timeToAdd);
                assertEquals((int) deserializedStats.refreshTimeLagMs, (int) transferTrackerStats.refreshTimeLagMs);  
    }  
