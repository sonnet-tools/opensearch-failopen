            );  
                    RemoteStoreStats.SubFields.MOVING_AVG  
            .uploadBytesMovingAverage(9D)
                    RemoteStoreStats.SubFields.MOVING_AVG
            .lastTransferTimestampMs(12345)  
            .rejectionCount(0)
                        RemoteStoreStats.SubFields.SUCCEEDED_BYTES  
        RemoteSegmentTransferTracker.Stats segmentTransferStats,  
                )
            assertEquals(  
            assertEquals(
            .lastSuccessfulDownloadTimestamp(1L)
 */  
            .localRefreshNumber(0)
                Long.parseLong(
            .lastTransferTimestampMs(0)  
            assertEquals(
            .refreshTimeLagMs(100)  
                ((Map) segmentDownloads.get(RemoteStoreStats.DownloadStatsFields.DOWNLOAD_SPEED_IN_BYTES_PER_SEC)).get(
import org.opensearch.core.index.shard.ShardId;
                Long.parseLong(
                Long.parseLong(  
                )  
            assertEquals(  
                    RemoteStoreStats.SubFields.MOVING_AVG  
import org.opensearch.cluster.routing.TestShardRouting;  
            .build();
            .build();
                    ((Map<?, ?>) tlogDownloadStatsObj.get(RemoteStoreStats.DownloadStatsFields.TOTAL_DOWNLOADS)).get(
        if (translogTransferStats.totalDownloadsSucceeded > 0) {
            );
                )
            .consecutiveFailuresCount(0)
            .lastSuccessfulUploadTimestamp(0L)
            assertEquals(
            .totalUploadsStarted(0)
                (int) segmentTransferStats.uploadBytesStarted
        );  
            .downloadTimeMovingAverage(11D)
            .refreshTimeLagMs(0)
                translogTransferStats.lastSuccessfulDownloadTimestamp,
        } else {  
            );  
                        RemoteStoreStats.SubFields.FAILED_BYTES
            .totalUploadsStarted(0)
                segmentUploads.get(RemoteStoreStats.UploadStatsFields.BACKPRESSURE_REJECTION_COUNT),  
            assertEquals(
                ),
        // Compare Remote Segment Store stats
            assertEquals(  
                ((Map<?, ?>) tlogUploadStatsObj.get(RemoteStoreStats.UploadStatsFields.UPLOAD_TIME_IN_MILLIS)).get(
    }
                ((Map<?, ?>) tlogUploadStatsObj.get(RemoteStoreStats.UploadStatsFields.UPLOAD_SPEED_IN_BYTES_PER_SEC)).get(
            );  
                ((Map) segmentUploads.get(RemoteStoreStats.UploadStatsFields.REMOTE_REFRESH_SIZE_IN_BYTES)).get(
            .totalUploadsSucceeded(10)  
            );
        return new DirectoryFileTransferTracker.Stats.Builder().transferredBytesStarted(10)  
            );  
                translogTransferStats.totalUploadsStarted,  
            assertEquals(  
                translogTransferStats.uploadTimeMovingAverage,
                        RemoteStoreStats.SubFields.SUCCEEDED
            assertEquals(
            .remoteRefreshNumber(11)
            .totalUploadsStarted(0L)
            assertEquals(  
            .uploadTimeMovingAverage(0)
            .totalUploadsSucceeded(3L)
            .consecutiveFailuresCount(10)  
package org.opensearch.action.admin.cluster.remotestore.stats;
            assertEquals(
    }  
            .bytesLag(100)
            .uploadBytesMovingAverage(0D)  
                        RemoteStoreStats.SubFields.SUCCEEDED
            );  
            assertEquals(  
    }
            .totalUploadsStarted(2L)  
    }  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.routing.ShardRoutingState;
            assertEquals(
                (int) segmentTransferStats.lastSuccessfulRemoteRefreshBytes
            assertEquals(
        }  
            );
                    ).toString()
                ),
                    ((Map<?, ?>) tlogUploadStatsObj.get(RemoteStoreStats.UploadStatsFields.TOTAL_UPLOADS)).get(  
            .totalUploadsFailed(0)  
                    RemoteStoreStats.SubFields.STARTED_BYTES
                segmentTransferStats.directoryFileTransferTrackerStats.transferredBytesMovingAverage
                        RemoteStoreStats.SubFields.STARTED_BYTES
        if (translogTransferStats.totalUploadsStarted > 0) {
            .lastSuccessfulRemoteRefreshBytes(10)
            );
                    ).toString()  
                    ((Map<?, ?>) tlogUploadStatsObj.get(RemoteStoreStats.UploadStatsFields.TOTAL_UPLOADS)).get(
        return TestShardRouting.newShardRouting(shardId, randomAlphaOfLength(4), isPrimary, ShardRoutingState.STARTED);  
                ((Map<?, ?>) tlogDownloadStatsObj.get(RemoteStoreStats.DownloadStatsFields.DOWNLOAD_SIZE_IN_BYTES)).get(  
                segmentTransferStats.uploadBytesMovingAverage
                ((Map<?, ?>) tlogDownloadStatsObj.get(RemoteStoreStats.DownloadStatsFields.DOWNLOAD_TIME_IN_MILLIS)).get(  
                ),  
            .uploadBytesSucceeded(0)
            );  
            .uploadBytesStarted(0L)
        Map<String, Object> segment = ((Map) statsObject.get(RemoteStoreStats.Fields.SEGMENT));  
                (int) segmentTransferStats.localRefreshClockTimeMs
                    RemoteStoreStats.SubFields.SUCCEEDED_BYTES
            .totalUploadsFailed(0)
        // Compare Remote Translog Store stats
            );
        return new RemoteSegmentTransferTracker.Stats.Builder().shardId(shardId)  
            .downloadBytesMovingAverage(9D)
            routing.currentNodeId()
                (int) segmentTransferStats.remoteRefreshClockTimeMs
                translogTransferStats.lastSuccessfulUploadTimestamp,
        Map<?, ?> tlogStatsObj = (Map<?, ?>) statsObject.get(RemoteStoreStats.Fields.TRANSLOG);  
            .localRefreshClockTimeMs(101)
            );
            assertEquals(  
            assertEquals(
            ((Map) statsObject.get(RemoteStoreStats.Fields.ROUTING)).get(RemoteStoreStats.RoutingFields.NODE_ID),  
                        RemoteStoreStats.SubFields.STARTED  
                Long.parseLong(
    static RemoteTranslogTransferTracker.Stats createEmptyTranslogStats(ShardId shardId) {
                ),
            );
                translogTransferStats.uploadBytesFailed,
                    ).toString()  
                ((Map) segmentUploads.get(RemoteStoreStats.UploadStatsFields.TOTAL_UPLOAD_SIZE)).get(
            assertTrue(segmentUploads.isEmpty());
        Map<String, Object> segmentUploads = ((Map) segment.get(RemoteStoreStats.SubFields.UPLOAD));
                    RemoteStoreStats.SubFields.STARTED_BYTES  
                    RemoteStoreStats.SubFields.MOVING_AVG  
            .downloadTimeMovingAverage(0D)  
            .uploadBytesStarted(0)
                )  
            .uploadBytesPerSecMovingAverage(10D)
            .downloadBytesSucceeded(0L)
            .totalUploadsFailed(0L)
            );
            .totalUploadsFailed(4L)
            .bytesLag(0)
            .bytesLag(0)  
                segmentTransferStats.uploadTimeMovingAverage
                translogTransferStats.uploadBytesSucceeded,  
                    RemoteStoreStats.SubFields.LAST_SUCCESSFUL
                translogTransferStats.uploadBytesStarted,
    static DirectoryFileTransferTracker.Stats createSampleDirectoryFileTransferStats() {
            .uploadBytesFailed(5)
            assertEquals(
                ),
        ShardRouting routing
            .transferredBytesPerSecMovingAverage(0)
                translogTransferStats.uploadBytesMovingAverage,
            .directoryFileTransferTrackerStats(createZeroDirectoryFileTransferStats())
                ((Map) segmentDownloads.get(RemoteStoreStats.DownloadStatsFields.TOTAL_DOWNLOAD_SIZE)).get(
            .totalUploadsSucceeded(0)
            assertEquals(
                ((Map) segmentDownloads.get(RemoteStoreStats.DownloadStatsFields.DOWNLOAD_SIZE_IN_BYTES)).get(
            .uploadBytesPerSecMovingAverage(0)
            );  
 *
            .localRefreshClockTimeMs(50)  
import static org.opensearch.test.OpenSearchTestCase.randomAlphaOfLength;  
            );  
            .build();
 * compatible open source license.
    }  
                segmentDownloads.get(RemoteStoreStats.DownloadStatsFields.LAST_SYNC_TIMESTAMP),  
            .downloadBytesMovingAverage(0D)
            assertEquals(
            .lastSuccessfulTransferInBytes(0)  
                (int) segmentTransferStats.consecutiveFailuresCount
                (int) segmentTransferStats.totalUploadsFailed
            .build();
                    ).toString()
                Long.parseLong(tlogDownloadStatsObj.get(RemoteStoreStats.DownloadStatsFields.TOTAL_DOWNLOAD_TIME_IN_MILLIS).toString())
            );  
        return new RemoteTranslogTransferTracker.Stats.Builder().shardId(shardId)  
            );  
            assertEquals(
            .uploadBytesStarted(5L)  
            .totalDownloadsSucceeded(2L)
            .uploadBytesMovingAverage(5)  
                translogTransferStats.uploadBytesPerSecMovingAverage,
            .build();
        } else {
            .build();  
        return new RemoteSegmentTransferTracker.Stats.Builder().shardId(shardId)
                segmentTransferStats.directoryFileTransferTrackerStats.transferredBytesPerSecMovingAverage
                )
            .lastSuccessfulUploadTimestamp(1L)
            .transferredBytesSucceeded(0)
            assertEquals(
                        RemoteStoreStats.SubFields.FAILED
            .uploadBytesSucceeded(10)
                ),  
                    RemoteStoreStats.SubFields.SUCCEEDED_BYTES  
            .directoryFileTransferTrackerStats(createZeroDirectoryFileTransferStats())  
                ),  
            .uploadBytesSucceeded(6L)
            );
                )
        assertEquals(  
                translogTransferStats.totalDownloadTimeInMillis,  
                ((Map<?, ?>) tlogDownloadStatsObj.get(RemoteStoreStats.DownloadStatsFields.DOWNLOAD_SPEED_IN_BYTES_PER_SEC)).get(  
            .downloadBytesPerSecMovingAverage(10D)  
                (int) segmentTransferStats.refreshTimeLagMs  
                )  
                    RemoteStoreStats.SubFields.FAILED_BYTES
                )
                ((Map) segmentUploads.get(RemoteStoreStats.UploadStatsFields.REMOTE_REFRESH_SIZE_IN_BYTES)).get(
            assertEquals(
            .totalUploadTimeInMillis(8L)  
    static RemoteSegmentTransferTracker.Stats createStatsForRemoteStoreRestoredPrimary(ShardId shardId) {
            .totalUploadTimeInMs(10)  
            assertEquals(
                translogTransferStats.totalUploadsFailed,
import org.opensearch.index.remote.RemoteSegmentTransferTracker;
            .totalDownloadTimeInMillis(0L)  
            .totalUploadTimeInMillis(0L)
            .consecutiveFailuresCount(5)
                ),
            assertEquals(  
        RemoteTranslogTransferTracker.Stats translogTransferStats,
                        RemoteStoreStats.SubFields.SUCCEEDED_BYTES
    }
                segmentUploads.get(RemoteStoreStats.UploadStatsFields.LOCAL_REFRESH_TIMESTAMP),  
                (int) segmentTransferStats.directoryFileTransferTrackerStats.lastTransferTimestampMs
            );
                ((Map) segmentUploads.get(RemoteStoreStats.UploadStatsFields.TOTAL_UPLOAD_SIZE)).get(
            );
                Long.parseLong(tlogUploadStatsObj.get(RemoteStoreStats.UploadStatsFields.LAST_SUCCESSFUL_UPLOAD_TIMESTAMP).toString())
            .downloadBytesSucceeded(3L)  
            .totalTransferTimeInMs(5)
        return new RemoteTranslogTransferTracker.Stats.Builder().shardId(shardId)
        } else {  
            .totalDownloadTimeInMillis(4L)
    }  
    ) {  
    }
                (int) segmentTransferStats.uploadBytesFailed
            assertEquals(  
            .build();
            );
    static ShardRouting createShardRouting(ShardId shardId, boolean isPrimary) {
                translogTransferStats.downloadTimeMovingAverage,
                ),  
            assertEquals(  
            .refreshTimeLagMs(0)
            );
            .rejectionCount(0)
                translogTransferStats.downloadBytesSucceeded,
            .totalDownloadsSucceeded(0L)
            .totalUploadsSucceeded(0)
            .localRefreshNumber(50)  
            assertEquals(segmentUploads.get(RemoteStoreStats.UploadStatsFields.BYTES_LAG), (int) segmentTransferStats.bytesLag);  
                    ((Map<?, ?>) tlogDownloadStatsObj.get(RemoteStoreStats.DownloadStatsFields.TOTAL_DOWNLOAD_SIZE)).get(  
            assertNull(tlogUploadStatsObj.get(RemoteStoreStats.UploadStatsFields.TOTAL_UPLOADS));
            .uploadBytesFailed(7L)
            .remoteRefreshNumber(0)  
import org.opensearch.index.store.DirectoryFileTransferTracker;
            .localRefreshClockTimeMs(0)
        if (segmentTransferStats.directoryFileTransferTrackerStats.transferredBytesStarted != 0) {
                Long.parseLong(  
                    RemoteStoreStats.SubFields.MOVING_AVG
                ((Map) segmentUploads.get(RemoteStoreStats.UploadStatsFields.TOTAL_UPLOADS)).get(RemoteStoreStats.SubFields.STARTED),
                segmentUploads.get(RemoteStoreStats.UploadStatsFields.REFRESH_LAG),  
                translogTransferStats.downloadBytesMovingAverage,
                Long.parseLong(  
                (int) segmentTransferStats.totalUploadsStarted  
            ((Map) statsObject.get(RemoteStoreStats.Fields.ROUTING)).get(RemoteStoreStats.RoutingFields.PRIMARY),
            .remoteRefreshClockTimeMs(102)
            .remoteRefreshClockTimeMs(50)
            assertEquals(  
            .totalUploadsSucceeded(0L)  
            assertEquals(  
            assertEquals(  
    }
            .totalUploadTimeInMs(10)
                ((Map) segmentDownloads.get(RemoteStoreStats.DownloadStatsFields.DOWNLOAD_SIZE_IN_BYTES)).get(
            assertEquals(  
        Map<String, Object> statsObject,
            .uploadBytesFailed(0)  
            .uploadBytesMovingAverage(0)
            .transferredBytesFailed(0)
            .transferredBytesFailed(0)
/*  
                segmentUploads.get(RemoteStoreStats.UploadStatsFields.REMOTE_REFRESH_TIMESTAMP),
                    ).toString()  
            );  
                )
                (int) segmentTransferStats.directoryFileTransferTrackerStats.lastSuccessfulTransferInBytes
        }
public class RemoteStoreStatsTestHelper {
            .uploadTimeMovingAverage(0)  
                ((Map<?, ?>) tlogUploadStatsObj.get(RemoteStoreStats.UploadStatsFields.UPLOAD_SIZE_IN_BYTES)).get(
        assertEquals(
    static RemoteSegmentTransferTracker.Stats createStatsForNewPrimary(ShardId shardId) {
            );  
 * The OpenSearch Contributors require contributions made to  
            .uploadTimeMovingAverage(0D)
        Map<?, ?> tlogDownloadStatsObj = (Map<?, ?>) tlogStatsObj.get(RemoteStoreStats.SubFields.DOWNLOAD);
            );
            .uploadBytesMovingAverage(0)
            .downloadBytesPerSecMovingAverage(0D)
import static org.junit.Assert.assertNull;
            assertEquals(
        return new DirectoryFileTransferTracker.Stats.Builder().transferredBytesStarted(0)  
                Long.parseLong(tlogDownloadStatsObj.get(RemoteStoreStats.DownloadStatsFields.LAST_SUCCESSFUL_DOWNLOAD_TIMESTAMP).toString())
            );
import static org.junit.Assert.assertTrue;
        Map<String, Object> segmentDownloads = ((Map) segment.get(RemoteStoreStats.SubFields.DOWNLOAD));
/**
        }  
                segmentUploads.get(RemoteStoreStats.UploadStatsFields.CONSECUTIVE_FAILURE_COUNT),
                translogTransferStats.downloadBytesPerSecMovingAverage,
                ((Map) segmentUploads.get(RemoteStoreStats.UploadStatsFields.TOTAL_UPLOAD_SIZE)).get(
            );
            .transferredBytesMovingAverage(0)
                    RemoteStoreStats.SubFields.MOVING_AVG
            assertNull(tlogDownloadStatsObj.get(RemoteStoreStats.DownloadStatsFields.TOTAL_DOWNLOAD_SIZE));
import org.opensearch.index.remote.RemoteTranslogTransferTracker;  
        assertEquals(
                    ).toString()
                    RemoteStoreStats.SubFields.LAST_SUCCESSFUL  
            assertEquals(  
            .transferredBytesMovingAverage(5)
            .lastSuccessfulTransferInBytes(5)  
            .uploadTimeMovingAverage(0)
import org.opensearch.cluster.routing.ShardRouting;
            .rejectionCount(0)  
                    RemoteStoreStats.SubFields.MOVING_AVG
                )
                ),  
                    RemoteStoreStats.SubFields.MOVING_AVG  
                    ).toString()
            .transferredBytesPerSecMovingAverage(10)
            .remoteRefreshClockTimeMs(0)  
            assertEquals(  
                segmentTransferStats.uploadBytesPerSecMovingAverage
            );  
            );  
            .uploadBytesStarted(11)
            );
            .uploadBytesPerSecMovingAverage(0D)
            );  
            assertEquals(
                ),
            assertEquals(
                Long.parseLong(
            assertEquals(
                Long.parseLong(tlogUploadStatsObj.get(RemoteStoreStats.UploadStatsFields.TOTAL_UPLOAD_TIME_IN_MILLIS).toString())  
            ((Map) statsObject.get(RemoteStoreStats.Fields.ROUTING)).get(RemoteStoreStats.RoutingFields.STATE),
            assertEquals(
        if (segmentTransferStats.totalUploadsStarted != 0) {
            );
            .uploadBytesPerSecMovingAverage(0)  
                ((Map) segmentUploads.get(RemoteStoreStats.UploadStatsFields.TOTAL_UPLOADS)).get(RemoteStoreStats.SubFields.FAILED),
            .localRefreshNumber(0)
            );
                    ((Map<?, ?>) tlogUploadStatsObj.get(RemoteStoreStats.UploadStatsFields.TOTAL_UPLOAD_SIZE)).get(
                    RemoteStoreStats.SubFields.MOVING_AVG  
        return new RemoteSegmentTransferTracker.Stats.Builder().shardId(shardId)
                translogTransferStats.totalUploadTimeInMillis,
            assertEquals(
}
        Map<?, ?> tlogUploadStatsObj = (Map<?, ?>) tlogStatsObj.get(RemoteStoreStats.SubFields.UPLOAD);
                (int) segmentTransferStats.directoryFileTransferTrackerStats.transferredBytesStarted
        );
                    RemoteStoreStats.SubFields.MOVING_AVG  
                ),  
                (int) segmentTransferStats.directoryFileTransferTrackerStats.transferredBytesSucceeded
            );  
            .uploadTimeMovingAverage(11D)  
                ((Map) segmentUploads.get(RemoteStoreStats.UploadStatsFields.REMOTE_REFRESH_LATENCY_IN_MILLIS)).get(
            assertEquals(
            .transferredBytesSucceeded(10)
            .remoteRefreshNumber(10)
            .lastSuccessfulRemoteRefreshBytes(0)  
            );  
            );
                (int) (segmentTransferStats.localRefreshNumber - segmentTransferStats.remoteRefreshNumber)
            .totalUploadTimeInMs(0)
    static DirectoryFileTransferTracker.Stats createZeroDirectoryFileTransferStats() {
            assertTrue(segmentDownloads.isEmpty());
                ((Map) segmentUploads.get(RemoteStoreStats.UploadStatsFields.UPLOAD_SPEED_IN_BYTES_PER_SEC)).get(
            .totalTransferTimeInMs(0)
            .uploadBytesPerSecMovingAverage(0)
                ),
            .uploadBytesFailed(10)
                ((Map) segmentUploads.get(RemoteStoreStats.UploadStatsFields.TOTAL_UPLOADS)).get(RemoteStoreStats.SubFields.SUCCEEDED),  
    static RemoteTranslogTransferTracker.Stats createTranslogStats(ShardId shardId) {  
import java.util.Map;  
        );
            );
                ((Map) segmentDownloads.get(RemoteStoreStats.DownloadStatsFields.TOTAL_DOWNLOAD_SIZE)).get(
                translogTransferStats.totalUploadsSucceeded,
            routing.primary()  
            );
                )
                (int) segmentTransferStats.totalUploadsSucceeded
            .totalUploadsFailed(10)
            .totalUploadsStarted(5)  
                    ((Map<?, ?>) tlogUploadStatsObj.get(RemoteStoreStats.UploadStatsFields.TOTAL_UPLOAD_SIZE)).get(
                ((Map) segmentDownloads.get(RemoteStoreStats.DownloadStatsFields.TOTAL_DOWNLOAD_SIZE)).get(
                )
        } else {
    static void compareStatsResponse(
                    ((Map<?, ?>) tlogUploadStatsObj.get(RemoteStoreStats.UploadStatsFields.TOTAL_UPLOAD_SIZE)).get(  
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.test.OpenSearchTestCase.assertEquals;
                    ).toString()
                    RemoteStoreStats.SubFields.FAILED_BYTES  
    static RemoteSegmentTransferTracker.Stats createStatsForNewReplica(ShardId shardId) {  
 * Helper utilities for Remote Store stats tests
                    ((Map<?, ?>) tlogUploadStatsObj.get(RemoteStoreStats.UploadStatsFields.TOTAL_UPLOADS)).get(
            .lastSuccessfulDownloadTimestamp(0L)  
            .directoryFileTransferTrackerStats(createZeroDirectoryFileTransferStats())
            .uploadBytesSucceeded(0L)  
            .uploadBytesSucceeded(10)  
                (int) segmentTransferStats.rejectionCount
 */  
            assertEquals(
                segmentUploads.get(RemoteStoreStats.UploadStatsFields.REFRESH_TIME_LAG_IN_MILLIS),
            );
            );
            .uploadBytesStarted(2)  
                )
                    RemoteStoreStats.SubFields.MOVING_AVG
                (int) segmentTransferStats.directoryFileTransferTrackerStats.transferredBytesFailed
                )
        }
                (int) segmentTransferStats.uploadBytesSucceeded
            routing.state().toString()
            assertEquals(  
            .lastSuccessfulRemoteRefreshBytes(5)
            .uploadBytesFailed(0L)
                translogTransferStats.totalDownloadsSucceeded,
                Long.parseLong(
