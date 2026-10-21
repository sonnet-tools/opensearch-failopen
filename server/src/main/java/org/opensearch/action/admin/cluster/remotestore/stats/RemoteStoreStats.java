     */
 */
         * No of refresh remote store is lagging behind local
/**
            .field(SubFields.STARTED_BYTES, remoteSegmentShardStats.directoryFileTransferTrackerStats.transferredBytesStarted)
        /**
        // Ensuring that we are not showing 0 metrics to the user
        builder.endObject();
        builder.field(SubFields.MOVING_AVG, remoteTranslogShardStats.uploadBytesPerSecMovingAverage);
         */
         */
         */
         * Total bytes of files downloaded from the remote store
        /**
        /**
    private void buildTranslogUploadStats(XContentBuilder builder) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
        if (remoteSegmentShardStats.totalUploadsStarted != 0) {
        builder.field(RoutingFields.NODE_ID, shardRouting.currentNodeId());
     * Stats related to Remote Translog Store operations
         */
        builder.field(SubFields.STARTED, remoteTranslogShardStats.totalUploadsStarted)
        /**
    }
    /**
        builder.endObject();
        static final String REMOTE_REFRESH_SIZE_IN_BYTES = "remote_refresh_size_in_bytes";
        builder.field(RoutingFields.STATE, shardRouting.state());
        RemoteSegmentTransferTracker.Stats remoteSegmentUploadShardStats,
            .field(UploadStatsFields.REFRESH_TIME_LAG_IN_MILLIS, remoteSegmentShardStats.refreshTimeLagMs)
    }
/*
        }
    public static final class UploadStatsFields {
        builder.endObject();
        /**
        builder.field(SubFields.SUCCEEDED_BYTES, remoteTranslogShardStats.downloadBytesSucceeded);
        // Ensuring that we are not showing 0 metrics to the user
         * Moving avg over last N values stat
        shardRouting.writeTo(out);
        static final String TRANSLOG = "translog";
         */
        static final String REFRESH_TIME_LAG_IN_MILLIS = "refresh_time_lag_in_millis";
         * Lag in terms of bytes b/w local and remote store
        /**
        builder.startObject(DownloadStatsFields.DOWNLOAD_SPEED_IN_BYTES_PER_SEC);
    /**
        builder.startObject(DownloadStatsFields.DOWNLOAD_SPEED_IN_BYTES_PER_SEC)
        builder.endObject();
            .field(SubFields.STARTED_BYTES, remoteSegmentShardStats.uploadBytesStarted)
    @Override
        builder.startObject(UploadStatsFields.UPLOAD_SPEED_IN_BYTES_PER_SEC)
        public static final String STARTED_BYTES = "started_bytes";
    }
    }
         */
    private void buildSegmentUploadStats(XContentBuilder builder) throws IOException {
            .field(SubFields.FAILED_BYTES, remoteSegmentShardStats.uploadBytesFailed);
        static final String PRIMARY = "primary";
import org.opensearch.core.xcontent.ToXContentFragment;
        static final String NODE_ID = "node";
        builder.field(SubFields.MOVING_AVG, remoteTranslogShardStats.uploadBytesMovingAverage);
         * Time taken by a remote store upload
        static final String REMOTE_REFRESH_TIMESTAMP = "remote_refresh_timestamp_in_millis";
        this.remoteTranslogShardStats = remoteTranslogShardStats;
        builder.startObject();
     */
import org.opensearch.core.common.io.stream.StreamOutput;
     * Fields for remote store stats response
        builder.startObject(UploadStatsFields.TOTAL_UPLOAD_SIZE)
        }
 * @opensearch.api
    }
        static final String CONSECUTIVE_FAILURE_COUNT = "consecutive_failure_count";
import org.opensearch.core.common.io.stream.Writeable;
    }
        static final String DOWNLOAD_SIZE_IN_BYTES = "download_size_in_bytes";
            .field(SubFields.SUCCEEDED, remoteSegmentShardStats.totalUploadsSucceeded)
        out.writeOptionalWriteable(remoteTranslogShardStats);
            .field(SubFields.FAILED, remoteSegmentShardStats.totalUploadsFailed);
        builder.startObject(SubFields.DOWNLOAD);
     */
    private void buildShardRouting(XContentBuilder builder) throws IOException {
 *
 * SPDX-License-Identifier: Apache-2.0
            .field(SubFields.SUCCEEDED_BYTES, remoteSegmentShardStats.directoryFileTransferTrackerStats.transferredBytesSucceeded)
    }
        builder.startObject(DownloadStatsFields.DOWNLOAD_TIME_IN_MILLIS);
        /**
        builder.startObject(SubFields.UPLOAD);
        builder.field(UploadStatsFields.TOTAL_UPLOAD_TIME_IN_MILLIS, remoteTranslogShardStats.totalUploadTimeInMillis);
         * Time taken by a single remote refresh
import java.io.IOException;
         * Total time spent in downloads from remote store
        builder.field(DownloadStatsFields.LAST_SUCCESSFUL_DOWNLOAD_TIMESTAMP, remoteTranslogShardStats.lastSuccessfulDownloadTimestamp);
            .field(SubFields.LAST_SUCCESSFUL, remoteSegmentShardStats.lastSuccessfulRemoteRefreshBytes)
        static final String STATE = "state";
        return remoteSegmentShardStats;
         */
        /**
        builder.startObject(DownloadStatsFields.DOWNLOAD_SIZE_IN_BYTES)
        public static final String SUCCEEDED = "succeeded";
         * Last successful remote refresh timestamp in milliseconds
        builder.field(DownloadStatsFields.TOTAL_DOWNLOAD_TIME_IN_MILLIS, remoteTranslogShardStats.totalDownloadTimeInMillis);
        builder.endObject(); // translog.upload
        builder.startObject(Fields.SEGMENT);
 * compatible open source license.
         * Total time spent on remote store uploads
    private final ShardRouting shardRouting;
         */
         */
@PublicApi(since = "2.8.0")
         * Time in millis remote refresh is behind local refresh
        return builder.endObject();
import org.opensearch.common.annotation.PublicApi;
    /**
        builder.startObject(UploadStatsFields.REMOTE_REFRESH_LATENCY_IN_MILLIS)
        public static final String TOTAL_UPLOADS = "total_uploads";
         * Represents the size of new data to be uploaded as part of a refresh
        builder.endObject();
        /**
            .field(SubFields.MOVING_AVG, remoteSegmentShardStats.directoryFileTransferTrackerStats.transferredBytesMovingAverage);
    }
            .field(SubFields.LAST_SUCCESSFUL, remoteSegmentShardStats.directoryFileTransferTrackerStats.lastSuccessfulTransferInBytes)
         */
        /**
     * Stats related to Remote Segment Store operations
        // Ensuring that we are not showing 0 metrics to the user
         */
        static final String UPLOAD_SIZE_IN_BYTES = "upload_size_in_bytes";
    }
        builder.field(SubFields.MOVING_AVG, remoteTranslogShardStats.downloadBytesMovingAverage);
        static final String BYTES_LAG = "bytes_lag";
         * No of consecutive remote refresh failures without a single success since the first failures
        builder.startObject(UploadStatsFields.TOTAL_UPLOADS)
        /**
        public static final String SUCCEEDED_BYTES = "succeeded_bytes";
         * Average time spent on a remote store download
            .field(SubFields.FAILED_BYTES, remoteSegmentShardStats.directoryFileTransferTrackerStats.transferredBytesFailed);
         */
    static final class Fields {
        builder.field(RoutingFields.PRIMARY, shardRouting.primary());
        builder.startObject(Fields.ROUTING);
    }
    }
        builder.endObject();
        builder.startObject(DownloadStatsFields.TOTAL_DOWNLOAD_SIZE)
 * this file be licensed under the Apache-2.0 license or a
        /**
         * Last successful local refresh timestamp in milliseconds
        builder.endObject(); // segment.upload
        static final String UPLOAD_TIME_IN_MILLIS = "upload_time_in_millis";
    RemoteStoreStats(
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        remoteTranslogShardStats = in.readOptionalWriteable(RemoteTranslogTransferTracker.Stats::new);
        static final String DOWNLOAD_SPEED_IN_BYTES_PER_SEC = "download_speed_in_bytes_per_sec";
         * Last successful sync from remote in milliseconds
 * Encapsulates all remote store stats
        builder.field(SubFields.MOVING_AVG, remoteTranslogShardStats.downloadTimeMovingAverage);
            remoteSegmentShardStats.directoryFileTransferTrackerStats.lastTransferTimestampMs
        this.shardRouting = shardRouting;
        /**
            .field(SubFields.FAILED_BYTES, remoteTranslogShardStats.uploadBytesFailed)
        if (remoteTranslogShardStats.totalUploadsStarted > 0) {
            .field(SubFields.MOVING_AVG, remoteSegmentShardStats.directoryFileTransferTrackerStats.transferredBytesPerSecMovingAverage);
        public static final String LAST_SUCCESSFUL_DOWNLOAD_TIMESTAMP = "last_successful_download_timestamp";
        // Ensuring that we are not showing 0 metrics to the user
 *
    public RemoteSegmentTransferTracker.Stats getSegmentStats() {
         * Average size of a file downloaded from the remote store
        builder.field(UploadStatsFields.LOCAL_REFRESH_TIMESTAMP, remoteSegmentShardStats.localRefreshClockTimeMs)
        builder.field(UploadStatsFields.LAST_SUCCESSFUL_UPLOAD_TIMESTAMP, remoteTranslogShardStats.lastSuccessfulUploadTimestamp);
        public static final String DOWNLOAD_TIME_IN_MILLIS = "download_time_in_millis";
            .field(UploadStatsFields.REFRESH_LAG, remoteSegmentShardStats.localRefreshNumber - remoteSegmentShardStats.remoteRefreshNumber)
         * Most recent successful attempt stat
            .field(SubFields.MOVING_AVG, remoteSegmentShardStats.uploadTimeMovingAverage);
        /**
        builder.field(
import org.opensearch.index.remote.RemoteSegmentTransferTracker;
        builder.startObject(UploadStatsFields.UPLOAD_SPEED_IN_BYTES_PER_SEC);
        builder.startObject(DownloadStatsFields.DOWNLOAD_SIZE_IN_BYTES);
        /**
    public RemoteTranslogTransferTracker.Stats getTranslogStats() {
        static final String REFRESH_LAG = "refresh_lag";
        builder.startObject(UploadStatsFields.TOTAL_UPLOADS);
        }
import org.opensearch.cluster.routing.ShardRouting;
package org.opensearch.action.admin.cluster.remotestore.stats;
        /**
         * Represents the speed of remote store uploads in bytes per sec
        static final String SEGMENT = "segment";
        static final String LOCAL_REFRESH_TIMESTAMP = "local_refresh_timestamp_in_millis";
        static final String TOTAL_UPLOAD_TIME_IN_MILLIS = "total_upload_time_in_millis";
    }
        builder.endObject(); // segment
         * Represents the total uploads to remote store in bytes
        builder.field(SubFields.SUCCEEDED, remoteTranslogShardStats.totalDownloadsSucceeded);
    /**
         */
     */
         */
        if (remoteSegmentShardStats.directoryFileTransferTrackerStats.transferredBytesStarted != 0) {
        builder.endObject();
        RemoteTranslogTransferTracker.Stats remoteTranslogShardStats,
        static final String LAST_SYNC_TIMESTAMP = "last_sync_timestamp";
        builder.endObject();
    RemoteStoreStats(StreamInput in) throws IOException {
        /**
            buildSegmentUploadStats(builder);
        static final String UPLOAD_SPEED_IN_BYTES_PER_SEC = "upload_speed_in_bytes_per_sec";
    }
        /**
         */
         */
        builder.startObject(UploadStatsFields.REMOTE_REFRESH_SIZE_IN_BYTES)
            .field(UploadStatsFields.BYTES_LAG, remoteSegmentShardStats.bytesLag)
        builder.endObject(); // translog.download
         */
        remoteSegmentShardStats = in.readOptionalWriteable(RemoteSegmentTransferTracker.Stats::new);
        builder.endObject();
        public static final String FAILED = "failed";
}
        builder.endObject();
            .field(SubFields.STARTED, remoteSegmentShardStats.totalUploadsStarted)
        builder.endObject();
        /**
        return shardRouting;
        public static final String UPLOAD = "upload";
        static final String ROUTING = "routing";
            .field(UploadStatsFields.CONSECUTIVE_FAILURE_COUNT, remoteSegmentShardStats.consecutiveFailuresCount);
            .field(SubFields.MOVING_AVG, remoteSegmentShardStats.uploadBytesPerSecMovingAverage);
    }
        this.shardRouting = new ShardRouting(in);
        /**
         * Represents the size of new data to be transferred as part of a remote store upload
    }
         */
        ShardRouting shardRouting
        builder.field(SubFields.MOVING_AVG, remoteTranslogShardStats.uploadTimeMovingAverage);
        /**
        builder.endObject();
            .field(SubFields.FAILED, remoteTranslogShardStats.totalUploadsFailed)
        public static final String TOTAL_DOWNLOADS = "total_downloads";
        /**
        builder.startObject(UploadStatsFields.TOTAL_UPLOAD_SIZE);
         * Timestamp of last successful remote store upload
        builder.endObject(); // segment.download
         */
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;
        static final String LAST_SUCCESSFUL_UPLOAD_TIMESTAMP = "last_successful_upload_timestamp";
            .field(UploadStatsFields.BACKPRESSURE_REJECTION_COUNT, remoteSegmentShardStats.rejectionCount)
     */
        buildShardRouting(builder);
         */
        public static final String FAILED_BYTES = "failed_bytes";
        /**
        static final String DOWNLOAD = "download";
        builder.startObject(SubFields.DOWNLOAD);
         * Average speed (in bytes/sec) of a remote store download
     * Fields for remote store stats response
import org.opensearch.index.remote.RemoteTranslogTransferTracker;
        static final String REMOTE_REFRESH_LATENCY_IN_MILLIS = "remote_refresh_latency_in_millis";
        public static final String TOTAL_UPLOAD_SIZE = "total_upload_size";
        builder.startObject(UploadStatsFields.UPLOAD_SIZE_IN_BYTES);
    static final class DownloadStatsFields {
    private final RemoteSegmentTransferTracker.Stats remoteSegmentShardStats;
        builder.startObject(DownloadStatsFields.TOTAL_DOWNLOADS);
        builder.field(SubFields.MOVING_AVG, remoteTranslogShardStats.downloadBytesPerSecMovingAverage);
    static final class RoutingFields {
        builder.endObject(); // translog
    ) {
        static final String BACKPRESSURE_REJECTION_COUNT = "backpressure_rejection_count";
         * Count of files downloaded from remote store
         */
    private final RemoteTranslogTransferTracker.Stats remoteTranslogShardStats;
        builder.endObject();
         * Total write rejections due to remote store backpressure kick in
        builder.endObject();
        builder.startObject(DownloadStatsFields.TOTAL_DOWNLOAD_SIZE);
        /**
            buildSegmentDownloadStats(builder);
    }
     * Reusable sub fields for {@link UploadStatsFields} and {@link DownloadStatsFields}
    private void buildTranslogDownloadStats(XContentBuilder builder) throws IOException {
    private void buildSegmentDownloadStats(XContentBuilder builder) throws IOException {
         */
    @Override
        return remoteTranslogShardStats;
    public static final class SubFields {
        public static final String TOTAL_DOWNLOAD_TIME_IN_MILLIS = "total_download_time_in_millis";
        if (remoteTranslogShardStats.totalDownloadsSucceeded > 0) {
            .field(SubFields.SUCCEEDED_BYTES, remoteSegmentShardStats.uploadBytesSucceeded)
            .field(UploadStatsFields.REMOTE_REFRESH_TIMESTAMP, remoteSegmentShardStats.remoteRefreshClockTimeMs)
         */
 */
         */
        builder.endObject();
        );
        builder.endObject();
    public ShardRouting getShardRouting() {
        out.writeOptionalWriteable(remoteSegmentShardStats);
        builder.endObject();
         * Count of files uploaded to remote store
        this.remoteSegmentShardStats = remoteSegmentUploadShardStats;
        builder.field(SubFields.STARTED_BYTES, remoteTranslogShardStats.uploadBytesStarted)
        static final String MOVING_AVG = "moving_avg";
        builder.endObject();
 * The OpenSearch Contributors require contributions made to
            .field(SubFields.MOVING_AVG, remoteSegmentShardStats.uploadBytesMovingAverage);
        builder.startObject(SubFields.UPLOAD);
        /**
         */
            DownloadStatsFields.LAST_SYNC_TIMESTAMP,
    /**
        builder.startObject(UploadStatsFields.UPLOAD_TIME_IN_MILLIS);
        public static final String STARTED = "started";
         * Epoch timestamp of the last successful download
        /**
    }
            .field(SubFields.SUCCEEDED_BYTES, remoteTranslogShardStats.uploadBytesSucceeded);
        builder.endObject();
            buildTranslogDownloadStats(builder);
         */
        }
            .field(SubFields.SUCCEEDED, remoteTranslogShardStats.totalUploadsSucceeded);
        static final String LAST_SUCCESSFUL = "last_successful";
public class RemoteStoreStats implements Writeable, ToXContentFragment {
            buildTranslogUploadStats(builder);
        static final String TOTAL_DOWNLOAD_SIZE = "total_download_size";
        builder.startObject(Fields.TRANSLOG);
