    RemoteTranslogStats remoteTranslogStats;
            otherTransferTrackerStats.uploadBytesStarted + remoteTranslogStats.getUploadBytesStarted()
            .totalDownloadsSucceeded(0L)
        assertEquals(transferTrackerStats.totalUploadsStarted, remoteTranslogStats.getTotalUploadsStarted());  
import org.opensearch.test.OpenSearchTestCase;
/*  
            }
            otherRemoteTranslogStats.getTotalUploadsFailed(),  
        assertEquals(
            .uploadBytesStarted(randomLongBetween(10000, 50000))
        RemoteTranslogTransferTracker.Stats otherTransferTrackerStats = getRandomTransferTrackerStats();
 * The OpenSearch Contributors require contributions made to  
            .totalUploadsFailed(randomLongBetween(100, 200))
    private static RemoteTranslogTransferTracker.Stats getRandomTransferTrackerStats() {
            .totalUploadsSucceeded(randomLongBetween(50, 100))  
            otherTransferTrackerStats.totalUploadsStarted + remoteTranslogStats.getTotalUploadsStarted()
        assertEquals(transferTrackerStats.uploadBytesFailed, remoteTranslogStats.getUploadBytesFailed());
}  
            otherTransferTrackerStats.totalUploadsFailed + remoteTranslogStats.getTotalUploadsFailed()
import java.io.IOException;
    }
    }  
        transferTrackerStats = getRandomTransferTrackerStats();
        assertEquals(transferTrackerStats.totalUploadsSucceeded, remoteTranslogStats.getTotalUploadsSucceeded());
        assertEquals(  
    RemoteTranslogTransferTracker.Stats transferTrackerStats;
import org.opensearch.index.remote.RemoteTranslogTransferTracker;
            otherRemoteTranslogStats.getUploadBytesSucceeded(),
            remoteTranslogStats.writeTo(out);
            try (StreamInput in = out.bytes().streamInput()) {
public class RemoteTranslogStatsTests extends OpenSearchTestCase {  
        return new RemoteTranslogTransferTracker.Stats.Builder().shardId(new ShardId("test-idx", "test-idx", randomIntBetween(1, 10)))  
            .downloadBytesSucceeded(0L)
        );  
    public void setUp() throws Exception {
        assertEquals(transferTrackerStats.uploadBytesStarted, remoteTranslogStats.getUploadBytesStarted());  
            .uploadBytesFailed(randomLongBetween(10000, 20000))
    public void testRemoteTranslogStatsSerialization() throws IOException {
                RemoteTranslogStats remoteTranslogStatsFromStream = new RemoteTranslogStats(in);  
            .totalUploadsStarted(randomLongBetween(100, 500))
        assertEquals(
            otherTransferTrackerStats.uploadBytesFailed + remoteTranslogStats.getUploadBytesFailed()
    public void testRemoteTranslogStatsCreationFromTransferTrackerStats() {
import org.opensearch.core.index.shard.ShardId;  
        assertEquals(transferTrackerStats.totalUploadsFailed, remoteTranslogStats.getTotalUploadsFailed());
 * this file be licensed under the Apache-2.0 license or a
        );
package org.opensearch.index.translog;
        super.setUp();  
    }  
            .lastSuccessfulDownloadTimestamp(0L)  
            otherTransferTrackerStats.totalUploadsSucceeded + remoteTranslogStats.getTotalUploadsSucceeded()  
            .lastSuccessfulUploadTimestamp(0L)
 */  
import org.opensearch.common.io.stream.BytesStreamOutput;
            otherRemoteTranslogStats.getUploadBytesStarted(),
                assertEquals(remoteTranslogStats, remoteTranslogStatsFromStream);
        assertEquals(
        assertEquals(  
            .totalUploadTimeInMillis(0L)
            .uploadTimeMovingAverage(0D)
        RemoteTranslogStats otherRemoteTranslogStats = new RemoteTranslogStats(otherTransferTrackerStats);
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
        );
        );  
            .totalDownloadTimeInMillis(0L)  
            .uploadBytesPerSecMovingAverage(0D)
import org.opensearch.core.common.io.stream.StreamInput;
            .uploadBytesMovingAverage(0D)  
        );
        assertEquals(
            .build();
    public void testAdd() {  
            otherTransferTrackerStats.uploadBytesSucceeded + remoteTranslogStats.getUploadBytesSucceeded()  
            otherRemoteTranslogStats.getTotalUploadsSucceeded(),
        }  
            .downloadTimeMovingAverage(0D)  
            .downloadBytesPerSecMovingAverage(0D)
 * compatible open source license.
    @Override
    }  
            .uploadBytesSucceeded(randomLongBetween(5000, 10000))  
        assertEquals(transferTrackerStats.uploadBytesSucceeded, remoteTranslogStats.getUploadBytesSucceeded());
 * SPDX-License-Identifier: Apache-2.0
            .downloadBytesMovingAverage(0D)
    }
            otherRemoteTranslogStats.getTotalUploadsStarted(),
        remoteTranslogStats = new RemoteTranslogStats(transferTrackerStats);
            otherRemoteTranslogStats.getUploadBytesFailed(),  
        );
 *
        otherRemoteTranslogStats.add(remoteTranslogStats);
