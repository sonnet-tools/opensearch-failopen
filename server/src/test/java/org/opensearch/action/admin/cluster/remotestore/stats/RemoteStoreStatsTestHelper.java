                ),
                translogTransferStats.uploadBytesSucceeded,
    }
                translogTransferStats.downloadBytesMovingAverage,
            assertEquals(
            .totalUploadsSucceeded(3L)
            );
                translogTransferStats.totalUploadTimeInMillis,
            .uploadBytesFailed(0L)
            .directoryFileTransferTrackerStats(createZeroDirectoryFileTransferStats())
            .bytesLag(100)
            );
            .build();
            .transferredBytesMovingAverage(5)
            .uploadBytesStarted(0)
            assertEquals(
                (int) segmentTransferStats.totalUploadsStarted
                (int) segmentTransferStats.refreshTimeLagMs
                ),
                (int) segmentTransferStats.directoryFileTransferTrackerStats.lastTransferTimestampMs
            .uploadBytesMovingAverage(0D)
        RemoteTranslogTransferTracker.Stats translogTransferStats,
                )
                    RemoteStoreStats.SubFields.LAST_SUCCESSFUL
                ((Map) segmentUploads.get(RemoteStoreStats.UploadStatsFields.TOTAL_UPLOADS)).get(RemoteStoreStats.SubFields.STARTED),
                Long.parseLong(tlogDownloadStatsObj.get(RemoteStoreStats.DownloadStatsFields.TOTAL_DOWNLOAD_TIME_IN_MILLIS).toString())
            .uploadTimeMovingAverage(0)
            assertEquals(
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(
                ((Map) segmentUploads.get(RemoteStoreStats.UploadStatsFields.TOTAL_UPLOADS)).get(RemoteStoreStats.SubFields.SUCCEEDED),
            );
            assertEquals(
    static RemoteSegmentTransferTracker.Stats createStatsForRemoteStoreRestoredPrimary(ShardId shardId) {
            assertEquals(
            );
        );
                Long.parseLong(
        Map<String, Object> segmentUploads = ((Map) segment.get(RemoteStoreStats.SubFields.UPLOAD));
                    RemoteStoreStats.SubFields.MOVING_AVG
                (int) segmentTransferStats.directoryFileTransferTrackerStats.transferredBytesStarted
                    RemoteStoreStats.SubFields.STARTED_BYTES
    static RemoteTranslogTransferTracker.Stats createTranslogStats(ShardId shardId) {
                segmentUploads.get(RemoteStoreStats.UploadStatsFields.BACKPRESSURE_REJECTION_COUNT),
        assertEquals(
            );
                ((Map) segmentUploads.get(RemoteStoreStats.UploadStatsFields.UPLOAD_SPEED_IN_BYTES_PER_SEC)).get(
            assertEquals(
            .totalDownloadsSucceeded(0L)
            );
            .totalDownloadTimeInMillis(0L)
                translogTransferStats.totalDownloadTimeInMillis,
            .downloadBytesMovingAverage(9D)
            .remoteRefreshClockTimeMs(102)
                    RemoteStoreStats.SubFields.MOVING_AVG
                    ).toString()
        }
            );
            .uploadTimeMovingAverage(0D)
                ),
import org.opensearch.index.remote.RemoteTranslogTransferTracker;
            .lastTransferTimestampMs(12345)
        if (translogTransferStats.totalDownloadsSucceeded > 0) {
                translogTransferStats.totalUploadsFailed,
    static RemoteSegmentTransferTracker.Stats createStatsForNewPrimary(ShardId shardId) {
        return new DirectoryFileTransferTracker.Stats.Builder().transferredBytesStarted(0)
        );
            .lastSuccessfulRemoteRefreshBytes(0)
            .transferredBytesSucceeded(0)
                ((Map) segmentDownloads.get(RemoteStoreStats.DownloadStatsFields.DOWNLOAD_SIZE_IN_BYTES)).get(
            assertEquals(
            assertNull(tlogDownloadStatsObj.get(RemoteStoreStats.DownloadStatsFields.TOTAL_DOWNLOAD_SIZE));
            .totalUploadsSucceeded(0)
    ) {
                ((Map) segmentDownloads.get(RemoteStoreStats.DownloadStatsFields.DOWNLOAD_SPEED_IN_BYTES_PER_SEC)).get(
        if (segmentTransferStats.totalUploadsStarted != 0) {
import static org.junit.Assert.assertTrue;
        ShardRouting routing
            .uploadBytesFailed(7L)
            .totalUploadsSucceeded(0)
                        RemoteStoreStats.SubFields.STARTED_BYTES
                (int) segmentTransferStats.lastSuccessfulRemoteRefreshBytes
                ),
                translogTransferStats.downloadBytesSucceeded,
                segmentUploads.get(RemoteStoreStats.UploadStatsFields.REFRESH_LAG),
            assertEquals(
                ((Map) segmentUploads.get(RemoteStoreStats.UploadStatsFields.TOTAL_UPLOAD_SIZE)).get(
            .rejectionCount(0)
                translogTransferStats.lastSuccessfulUploadTimestamp,
            .uploadTimeMovingAverage(0)
            .build();
            .localRefreshNumber(0)
                (int) segmentTransferStats.directoryFileTransferTrackerStats.lastSuccessfulTransferInBytes
    }
            assertEquals(
                (int) segmentTransferStats.uploadBytesStarted
public class RemoteStoreStatsTestHelper {
            .remoteRefreshNumber(0)
            ((Map) statsObject.get(RemoteStoreStats.Fields.ROUTING)).get(RemoteStoreStats.RoutingFields.STATE),
            .refreshTimeLagMs(0)
            );
                Long.parseLong(
                    ((Map<?, ?>) tlogUploadStatsObj.get(RemoteStoreStats.UploadStatsFields.TOTAL_UPLOADS)).get(
            .localRefreshNumber(0)
                ((Map<?, ?>) tlogDownloadStatsObj.get(RemoteStoreStats.DownloadStatsFields.DOWNLOAD_TIME_IN_MILLIS)).get(
                segmentUploads.get(RemoteStoreStats.UploadStatsFields.REMOTE_REFRESH_TIMESTAMP),
                    RemoteStoreStats.SubFields.FAILED_BYTES
                ((Map) segmentUploads.get(RemoteStoreStats.UploadStatsFields.TOTAL_UPLOAD_SIZE)).get(
            .uploadBytesSucceeded(0L)
                    ).toString()
    static ShardRouting createShardRouting(ShardId shardId, boolean isPrimary) {
                Long.parseLong(
            .uploadBytesMovingAverage(5)
            .totalUploadsSucceeded(0L)
                ),
            .lastSuccessfulRemoteRefreshBytes(5)
import java.util.Map;
                translogTransferStats.uploadBytesStarted,
            assertEquals(
                translogTransferStats.lastSuccessfulDownloadTimestamp,
            );
            .transferredBytesPerSecMovingAverage(10)
            .totalUploadTimeInMs(10)
        } else {
    static DirectoryFileTransferTracker.Stats createZeroDirectoryFileTransferStats() {
                ),
                        RemoteStoreStats.SubFields.SUCCEEDED
            assertTrue(segmentDownloads.isEmpty());
            .uploadBytesSucceeded(6L)
                ),
    static RemoteTranslogTransferTracker.Stats createEmptyTranslogStats(ShardId shardId) {
            .totalUploadTimeInMillis(8L)
                ),
import static org.opensearch.test.OpenSearchTestCase.assertEquals;
                (int) (segmentTransferStats.localRefreshNumber - segmentTransferStats.remoteRefreshNumber)
            .totalUploadsFailed(0L)
        Map<?, ?> tlogDownloadStatsObj = (Map<?, ?>) tlogStatsObj.get(RemoteStoreStats.SubFields.DOWNLOAD);
                    ((Map<?, ?>) tlogUploadStatsObj.get(RemoteStoreStats.UploadStatsFields.TOTAL_UPLOADS)).get(
            assertEquals(
    static DirectoryFileTransferTracker.Stats createSampleDirectoryFileTransferStats() {
            );
            );
            .uploadBytesMovingAverage(0)
        Map<?, ?> tlogUploadStatsObj = (Map<?, ?>) tlogStatsObj.get(RemoteStoreStats.SubFields.UPLOAD);
            assertEquals(
            );
            .downloadTimeMovingAverage(0D)
            );
            .lastTransferTimestampMs(0)
            .uploadBytesSucceeded(10)
                    RemoteStoreStats.SubFields.MOVING_AVG
            .localRefreshClockTimeMs(101)
            assertEquals(
                ),
                (int) segmentTransferStats.consecutiveFailuresCount
        assertEquals(
            .uploadBytesSucceeded(0)
        }
                    RemoteStoreStats.SubFields.SUCCEEDED_BYTES
            );
            .lastSuccessfulDownloadTimestamp(1L)
                Long.parseLong(
                        RemoteStoreStats.SubFields.SUCCEEDED
            assertEquals(
                (int) segmentTransferStats.totalUploadsSucceeded
        if (segmentTransferStats.directoryFileTransferTrackerStats.transferredBytesStarted != 0) {
            .totalUploadsFailed(0)
                (int) segmentTransferStats.localRefreshClockTimeMs
                    RemoteStoreStats.SubFields.MOVING_AVG
                ((Map) segmentDownloads.get(RemoteStoreStats.DownloadStatsFields.TOTAL_DOWNLOAD_SIZE)).get(
            );
                    RemoteStoreStats.SubFields.MOVING_AVG
                Long.parseLong(tlogDownloadStatsObj.get(RemoteStoreStats.DownloadStatsFields.LAST_SUCCESSFUL_DOWNLOAD_TIMESTAMP).toString())
            .uploadBytesPerSecMovingAverage(0)
            assertEquals(
            assertEquals(
            .uploadBytesFailed(0)
                )
            .uploadBytesMovingAverage(0)
    static RemoteSegmentTransferTracker.Stats createStatsForNewReplica(ShardId shardId) {
                        RemoteStoreStats.SubFields.SUCCEEDED_BYTES
 * Helper utilities for Remote Store stats tests
package org.opensearch.action.admin.cluster.remotestore.stats;
            .uploadBytesStarted(2)
                    RemoteStoreStats.SubFields.STARTED_BYTES
        } else {
        return new RemoteSegmentTransferTracker.Stats.Builder().shardId(shardId)
import org.opensearch.index.remote.RemoteSegmentTransferTracker;
            assertTrue(segmentUploads.isEmpty());
            assertEquals(
                    RemoteStoreStats.SubFields.MOVING_AVG
            assertEquals(
                )
            assertEquals(
            .totalUploadsSucceeded(10)
                    ).toString()
}
                Long.parseLong(tlogUploadStatsObj.get(RemoteStoreStats.UploadStatsFields.TOTAL_UPLOAD_TIME_IN_MILLIS).toString())
import static org.opensearch.test.OpenSearchTestCase.randomAlphaOfLength;
            );
                segmentTransferStats.uploadBytesMovingAverage
            .uploadBytesFailed(10)
            .totalUploadsFailed(10)
            assertEquals(
            .downloadTimeMovingAverage(11D)
                )
        if (translogTransferStats.totalUploadsStarted > 0) {
            .transferredBytesFailed(0)
            .localRefreshNumber(50)
            .uploadTimeMovingAverage(0)
        RemoteSegmentTransferTracker.Stats segmentTransferStats,
            );
            assertEquals(
                ((Map) segmentDownloads.get(RemoteStoreStats.DownloadStatsFields.TOTAL_DOWNLOAD_SIZE)).get(
            .transferredBytesMovingAverage(0)
            .uploadBytesStarted(11)
            );
import static org.junit.Assert.assertNull;
import org.opensearch.core.index.shard.ShardId;
/**
            assertEquals(
 * The OpenSearch Contributors require contributions made to
            .lastSuccessfulTransferInBytes(5)
                    RemoteStoreStats.SubFields.MOVING_AVG
            );
                ((Map) segmentUploads.get(RemoteStoreStats.UploadStatsFields.TOTAL_UPLOADS)).get(RemoteStoreStats.SubFields.FAILED),
            .totalDownloadsSucceeded(2L)
            ((Map) statsObject.get(RemoteStoreStats.Fields.ROUTING)).get(RemoteStoreStats.RoutingFields.NODE_ID),
        }
            assertEquals(
                segmentDownloads.get(RemoteStoreStats.DownloadStatsFields.LAST_SYNC_TIMESTAMP),
            assertEquals(
                ((Map<?, ?>) tlogUploadStatsObj.get(RemoteStoreStats.UploadStatsFields.UPLOAD_SPEED_IN_BYTES_PER_SEC)).get(
                ((Map) segmentDownloads.get(RemoteStoreStats.DownloadStatsFields.TOTAL_DOWNLOAD_SIZE)).get(
            .remoteRefreshNumber(10)
        return new RemoteTranslogTransferTracker.Stats.Builder().shardId(shardId)
 * SPDX-License-Identifier: Apache-2.0
            );
                    ((Map<?, ?>) tlogUploadStatsObj.get(RemoteStoreStats.UploadStatsFields.TOTAL_UPLOAD_SIZE)).get(
            assertEquals(
            );
            .lastSuccessfulUploadTimestamp(1L)
                translogTransferStats.totalDownloadsSucceeded,
            assertEquals(
                    ).toString()
                Long.parseLong(
            .directoryFileTransferTrackerStats(createZeroDirectoryFileTransferStats())
                    RemoteStoreStats.SubFields.MOVING_AVG
                    ((Map<?, ?>) tlogUploadStatsObj.get(RemoteStoreStats.UploadStatsFields.TOTAL_UPLOAD_SIZE)).get(
        return new RemoteTranslogTransferTracker.Stats.Builder().shardId(shardId)
                ((Map<?, ?>) tlogUploadStatsObj.get(RemoteStoreStats.UploadStatsFields.UPLOAD_TIME_IN_MILLIS)).get(
            .transferredBytesFailed(0)
            .bytesLag(0)
                translogTransferStats.downloadBytesPerSecMovingAverage,
            assertEquals(
            assertEquals(
            .uploadBytesFailed(5)
                Long.parseLong(tlogUploadStatsObj.get(RemoteStoreStats.UploadStatsFields.LAST_SUCCESSFUL_UPLOAD_TIMESTAMP).toString())
                (int) segmentTransferStats.directoryFileTransferTrackerStats.transferredBytesFailed
            .totalUploadTimeInMs(0)
            .totalTransferTimeInMs(5)
                Long.parseLong(
                segmentUploads.get(RemoteStoreStats.UploadStatsFields.REFRESH_TIME_LAG_IN_MILLIS),
                )
            .uploadBytesSucceeded(10)
                segmentTransferStats.uploadTimeMovingAverage
            .uploadTimeMovingAverage(11D)
            );
            .uploadBytesPerSecMovingAverage(0D)
                    RemoteStoreStats.SubFields.MOVING_AVG
    }
            .totalDownloadTimeInMillis(4L)
                    ).toString()
                        RemoteStoreStats.SubFields.FAILED
            .uploadBytesMovingAverage(9D)
            .bytesLag(0)
    }
            .transferredBytesPerSecMovingAverage(0)
                Long.parseLong(
        }
            .totalUploadsFailed(0)
            );
                    ((Map<?, ?>) tlogUploadStatsObj.get(RemoteStoreStats.UploadStatsFields.TOTAL_UPLOADS)).get(
                (int) segmentTransferStats.directoryFileTransferTrackerStats.transferredBytesSucceeded
import org.opensearch.cluster.routing.ShardRoutingState;
            routing.currentNodeId()
            .totalTransferTimeInMs(0)
    }
            .lastSuccessfulDownloadTimestamp(0L)
                    ).toString()
                (int) segmentTransferStats.uploadBytesSucceeded
                segmentTransferStats.directoryFileTransferTrackerStats.transferredBytesPerSecMovingAverage
/*
            assertEquals(
        return new RemoteSegmentTransferTracker.Stats.Builder().shardId(shardId)
            .totalUploadsFailed(4L)
            .directoryFileTransferTrackerStats(createZeroDirectoryFileTransferStats())
            assertNull(tlogUploadStatsObj.get(RemoteStoreStats.UploadStatsFields.TOTAL_UPLOADS));
            .uploadBytesPerSecMovingAverage(0)
            .localRefreshClockTimeMs(50)
            assertEquals(
            .refreshTimeLagMs(0)
            );
                    RemoteStoreStats.SubFields.SUCCEEDED_BYTES
import org.opensearch.cluster.routing.TestShardRouting;
            .totalUploadTimeInMs(10)
                    RemoteStoreStats.SubFields.FAILED_BYTES
                (int) segmentTransferStats.rejectionCount
            );
            );
            );
            .remoteRefreshClockTimeMs(0)
                translogTransferStats.totalUploadsSucceeded,
                    ((Map<?, ?>) tlogDownloadStatsObj.get(RemoteStoreStats.DownloadStatsFields.TOTAL_DOWNLOADS)).get(
    }
                translogTransferStats.downloadTimeMovingAverage,
                    RemoteStoreStats.SubFields.MOVING_AVG
            );
            .downloadBytesSucceeded(3L)
                ((Map<?, ?>) tlogUploadStatsObj.get(RemoteStoreStats.UploadStatsFields.UPLOAD_SIZE_IN_BYTES)).get(
            assertEquals(
            );
            .downloadBytesSucceeded(0L)
                segmentTransferStats.directoryFileTransferTrackerStats.transferredBytesMovingAverage
                    ).toString()
            .build();
            routing.state().toString()
                )
                ((Map) segmentUploads.get(RemoteStoreStats.UploadStatsFields.REMOTE_REFRESH_SIZE_IN_BYTES)).get(
            .totalUploadTimeInMillis(0L)
                        RemoteStoreStats.SubFields.STARTED
    static void compareStatsResponse(
            .totalUploadsStarted(2L)
        Map<?, ?> tlogStatsObj = (Map<?, ?>) statsObject.get(RemoteStoreStats.Fields.TRANSLOG);
            .totalUploadsStarted(0)
                translogTransferStats.uploadBytesMovingAverage,
 *
 */
            .lastSuccessfulTransferInBytes(0)
            assertEquals(
                ((Map) segmentUploads.get(RemoteStoreStats.UploadStatsFields.REMOTE_REFRESH_LATENCY_IN_MILLIS)).get(
                (int) segmentTransferStats.uploadBytesFailed
                ((Map) segmentUploads.get(RemoteStoreStats.UploadStatsFields.TOTAL_UPLOAD_SIZE)).get(
            .consecutiveFailuresCount(10)
    }
                ((Map) segmentDownloads.get(RemoteStoreStats.DownloadStatsFields.DOWNLOAD_SIZE_IN_BYTES)).get(
            assertEquals(segmentUploads.get(RemoteStoreStats.UploadStatsFields.BYTES_LAG), (int) segmentTransferStats.bytesLag);
            );
                Long.parseLong(
                ),
                (int) segmentTransferStats.remoteRefreshClockTimeMs
        return new RemoteSegmentTransferTracker.Stats.Builder().shardId(shardId)
                translogTransferStats.uploadBytesPerSecMovingAverage,
                ((Map<?, ?>) tlogDownloadStatsObj.get(RemoteStoreStats.DownloadStatsFields.DOWNLOAD_SPEED_IN_BYTES_PER_SEC)).get(
                segmentTransferStats.uploadBytesPerSecMovingAverage
            .uploadBytesStarted(5L)
        Map<String, Object> segment = ((Map) statsObject.get(RemoteStoreStats.Fields.SEGMENT));
            );
                segmentUploads.get(RemoteStoreStats.UploadStatsFields.LOCAL_REFRESH_TIMESTAMP),
                    RemoteStoreStats.SubFields.MOVING_AVG
            .transferredBytesSucceeded(10)
            );
                    ((Map<?, ?>) tlogUploadStatsObj.get(RemoteStoreStats.UploadStatsFields.TOTAL_UPLOAD_SIZE)).get(
                )
            .totalUploadsStarted(0)
 */
            .uploadBytesPerSecMovingAverage(0)
            ((Map) statsObject.get(RemoteStoreStats.Fields.ROUTING)).get(RemoteStoreStats.RoutingFields.PRIMARY),
            assertEquals(
        Map<String, Object> segmentDownloads = ((Map) segment.get(RemoteStoreStats.SubFields.DOWNLOAD));
                segmentUploads.get(RemoteStoreStats.UploadStatsFields.CONSECUTIVE_FAILURE_COUNT),
                translogTransferStats.uploadTimeMovingAverage,
            assertEquals(
                    ).toString()
    }
            .build();
            .rejectionCount(0)
                )
            );
        Map<String, Object> statsObject,
            .remoteRefreshNumber(11)
                ),
            .lastSuccessfulRemoteRefreshBytes(10)
        } else {
                )
            .downloadBytesPerSecMovingAverage(0D)
            .build();
                ((Map) segmentUploads.get(RemoteStoreStats.UploadStatsFields.REMOTE_REFRESH_SIZE_IN_BYTES)).get(
            .consecutiveFailuresCount(5)
import org.opensearch.cluster.routing.ShardRouting;
            assertEquals(
                    ((Map<?, ?>) tlogDownloadStatsObj.get(RemoteStoreStats.DownloadStatsFields.TOTAL_DOWNLOAD_SIZE)).get(
        // Compare Remote Segment Store stats
            .refreshTimeLagMs(100)
                ),
            );
                ),
                )
        return new DirectoryFileTransferTracker.Stats.Builder().transferredBytesStarted(10)
            .localRefreshClockTimeMs(0)
            );
            .uploadBytesStarted(0L)
            .build();
            );
            .downloadBytesPerSecMovingAverage(10D)
            routing.primary()
import org.opensearch.index.store.DirectoryFileTransferTracker;
            .consecutiveFailuresCount(0)
        );
 * compatible open source license.
                        RemoteStoreStats.SubFields.FAILED_BYTES
            .uploadBytesPerSecMovingAverage(10D)
                ((Map<?, ?>) tlogDownloadStatsObj.get(RemoteStoreStats.DownloadStatsFields.DOWNLOAD_SIZE_IN_BYTES)).get(
            .lastSuccessfulUploadTimestamp(0L)
            .build();
            );
        } else {
                    RemoteStoreStats.SubFields.LAST_SUCCESSFUL
            .rejectionCount(0)
            );
    }
            .totalUploadsStarted(5)
                )
            .remoteRefreshClockTimeMs(50)
        return TestShardRouting.newShardRouting(shardId, randomAlphaOfLength(4), isPrimary, ShardRoutingState.STARTED);
                )
                translogTransferStats.uploadBytesFailed,
                )
            .downloadBytesMovingAverage(0D)
            assertEquals(
        assertEquals(
                translogTransferStats.totalUploadsStarted,
            );
            assertEquals(
                (int) segmentTransferStats.totalUploadsFailed
            assertEquals(
            assertEquals(
            assertEquals(
            );
                )
            );
            .totalUploadsStarted(0L)
        // Compare Remote Translog Store stats
                        RemoteStoreStats.SubFields.SUCCEEDED_BYTES
