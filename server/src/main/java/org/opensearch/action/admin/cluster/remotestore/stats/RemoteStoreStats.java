}
 * this file be licensed under the Apache-2.0 license or a
         * Total bytes of files downloaded from the remote store  
     * Reusable sub fields for {@link UploadStatsFields} and {@link DownloadStatsFields}  
        // Ensuring that we are not showing 0 metrics to the user  
            .field(SubFields.FAILED, remoteTranslogShardStats.totalUploadsFailed)
        builder.field(DownloadStatsFields.TOTAL_DOWNLOAD_TIME_IN_MILLIS, remoteTranslogShardStats.totalDownloadTimeInMillis);
    }
         */  
         * Timestamp of last successful remote store upload  
         * Time in millis remote refresh is behind local refresh
         */  
         * Represents the speed of remote store uploads in bytes per sec
    private final ShardRouting shardRouting;
         */  
            .field(SubFields.STARTED_BYTES, remoteSegmentShardStats.directoryFileTransferTrackerStats.transferredBytesStarted)
        ShardRouting shardRouting
    }  
    RemoteStoreStats(
    static final class RoutingFields {
        builder.endObject();
        }  
        public static final String STARTED_BYTES = "started_bytes";
         * No of consecutive remote refresh failures without a single success since the first failures  
        static final String LAST_SUCCESSFUL = "last_successful";
        static final String REMOTE_REFRESH_SIZE_IN_BYTES = "remote_refresh_size_in_bytes";
    /**
        static final String TOTAL_DOWNLOAD_SIZE = "total_download_size";
            .field(SubFields.SUCCEEDED, remoteSegmentShardStats.totalUploadsSucceeded)
        /**
        builder.field(SubFields.MOVING_AVG, remoteTranslogShardStats.downloadBytesMovingAverage);
            .field(SubFields.SUCCEEDED_BYTES, remoteTranslogShardStats.uploadBytesSucceeded);
        return shardRouting;
        /**  
         * Last successful remote refresh timestamp in milliseconds
         * Count of files downloaded from remote store
        static final String TOTAL_UPLOAD_TIME_IN_MILLIS = "total_upload_time_in_millis";
            .field(SubFields.LAST_SUCCESSFUL, remoteSegmentShardStats.directoryFileTransferTrackerStats.lastSuccessfulTransferInBytes)  
        public static final String FAILED_BYTES = "failed_bytes";  
     */
    private void buildSegmentDownloadStats(XContentBuilder builder) throws IOException {
        /**  
        /**
        /**
         */
import org.opensearch.index.remote.RemoteSegmentTransferTracker;
        builder.field(RoutingFields.STATE, shardRouting.state());
        builder.endObject(); // segment.download
@PublicApi(since = "2.8.0")  
/**
 *
            buildSegmentDownloadStats(builder);
         */
 *  
        builder.field(SubFields.SUCCEEDED, remoteTranslogShardStats.totalDownloadsSucceeded);  
    private void buildShardRouting(XContentBuilder builder) throws IOException {
        this.remoteSegmentShardStats = remoteSegmentUploadShardStats;  
        static final String MOVING_AVG = "moving_avg";
            buildSegmentUploadStats(builder);
        public static final String SUCCEEDED = "succeeded";
import java.io.IOException;
        /**
         * Total write rejections due to remote store backpressure kick in
    private void buildTranslogDownloadStats(XContentBuilder builder) throws IOException {
            .field(SubFields.MOVING_AVG, remoteSegmentShardStats.uploadTimeMovingAverage);  
        builder.endObject();  
     * Stats related to Remote Translog Store operations
        builder.endObject();  
        builder.startObject(UploadStatsFields.TOTAL_UPLOADS)  
        if (remoteTranslogShardStats.totalUploadsStarted > 0) {
        builder.endObject();
     */  
        builder.field(DownloadStatsFields.LAST_SUCCESSFUL_DOWNLOAD_TIMESTAMP, remoteTranslogShardStats.lastSuccessfulDownloadTimestamp);  
        this.shardRouting = shardRouting;
        /**
        builder.endObject();
         */
        builder.startObject(Fields.TRANSLOG);
        static final String REMOTE_REFRESH_LATENCY_IN_MILLIS = "remote_refresh_latency_in_millis";  
public class RemoteStoreStats implements Writeable, ToXContentFragment {
         * Average time spent on a remote store download  
    }  
        /**
         * Epoch timestamp of the last successful download
        builder.endObject();
         */
         */
        remoteTranslogShardStats = in.readOptionalWriteable(RemoteTranslogTransferTracker.Stats::new);
        builder.field(UploadStatsFields.LOCAL_REFRESH_TIMESTAMP, remoteSegmentShardStats.localRefreshClockTimeMs)
        this.shardRouting = new ShardRouting(in);
        builder.startObject(UploadStatsFields.TOTAL_UPLOAD_SIZE);
        /**
        out.writeOptionalWriteable(remoteTranslogShardStats);
        static final String STATE = "state";
            .field(UploadStatsFields.CONSECUTIVE_FAILURE_COUNT, remoteSegmentShardStats.consecutiveFailuresCount);
        builder.endObject();
    }  
    RemoteStoreStats(StreamInput in) throws IOException {
    public static final class SubFields {
         * Lag in terms of bytes b/w local and remote store  
        /**
        builder.endObject();  
    /**
     * Stats related to Remote Segment Store operations  
        }  
         * Moving avg over last N values stat  
    /**
    private void buildSegmentUploadStats(XContentBuilder builder) throws IOException {
        /**  
         */  
        public static final String LAST_SUCCESSFUL_DOWNLOAD_TIMESTAMP = "last_successful_download_timestamp";  
        if (remoteSegmentShardStats.totalUploadsStarted != 0) {
    }  
        static final String LAST_SUCCESSFUL_UPLOAD_TIMESTAMP = "last_successful_upload_timestamp";
         */
        builder.startObject(UploadStatsFields.UPLOAD_SIZE_IN_BYTES);
            .field(UploadStatsFields.BYTES_LAG, remoteSegmentShardStats.bytesLag)  
        builder.field(UploadStatsFields.TOTAL_UPLOAD_TIME_IN_MILLIS, remoteTranslogShardStats.totalUploadTimeInMillis);
        static final String CONSECUTIVE_FAILURE_COUNT = "consecutive_failure_count";
            buildTranslogUploadStats(builder);
        static final String BYTES_LAG = "bytes_lag";
    ) {
        /**
        builder.startObject();
        public static final String UPLOAD = "upload";  
        /**  
        public static final String TOTAL_UPLOAD_SIZE = "total_upload_size";  
        builder.startObject(Fields.SEGMENT);
        builder.field(SubFields.MOVING_AVG, remoteTranslogShardStats.downloadTimeMovingAverage);  
        builder.endObject();
        /**  
        builder.endObject(); // segment.upload
         */  
        builder.startObject(DownloadStatsFields.DOWNLOAD_SIZE_IN_BYTES);  
        static final String REFRESH_LAG = "refresh_lag";
        /**
            buildTranslogDownloadStats(builder);
         * Total time spent on remote store uploads  
        builder.startObject(UploadStatsFields.UPLOAD_SPEED_IN_BYTES_PER_SEC);
        public static final String TOTAL_DOWNLOADS = "total_downloads";
        public static final String FAILED = "failed";
        builder.endObject();
        static final String LAST_SYNC_TIMESTAMP = "last_sync_timestamp";
            .field(UploadStatsFields.REFRESH_LAG, remoteSegmentShardStats.localRefreshNumber - remoteSegmentShardStats.remoteRefreshNumber)
        builder.endObject();
         */
        }  
    }  
        builder.startObject(Fields.ROUTING);  
import org.opensearch.core.xcontent.ToXContentFragment;  
        public static final String STARTED = "started";  
        builder.startObject(UploadStatsFields.REMOTE_REFRESH_LATENCY_IN_MILLIS)
    private final RemoteTranslogTransferTracker.Stats remoteTranslogShardStats;
        /**
        static final String SEGMENT = "segment";  
         */
 * compatible open source license.
        /**  
        builder.startObject(DownloadStatsFields.TOTAL_DOWNLOAD_SIZE)  
        static final String DOWNLOAD_SIZE_IN_BYTES = "download_size_in_bytes";
    /**
    public void writeTo(StreamOutput out) throws IOException {
        builder.field(SubFields.MOVING_AVG, remoteTranslogShardStats.downloadBytesPerSecMovingAverage);
        // Ensuring that we are not showing 0 metrics to the user  
        this.remoteTranslogShardStats = remoteTranslogShardStats;
     */
package org.opensearch.action.admin.cluster.remotestore.stats;
     * Fields for remote store stats response
         */
        builder.startObject(UploadStatsFields.UPLOAD_TIME_IN_MILLIS);  
        builder.startObject(UploadStatsFields.UPLOAD_SPEED_IN_BYTES_PER_SEC)
        static final String DOWNLOAD = "download";
        builder.field(SubFields.STARTED_BYTES, remoteTranslogShardStats.uploadBytesStarted)  
    public ShardRouting getShardRouting() {  
        RemoteSegmentTransferTracker.Stats remoteSegmentUploadShardStats,
        builder.startObject(DownloadStatsFields.TOTAL_DOWNLOAD_SIZE);  
        builder.startObject(UploadStatsFields.TOTAL_UPLOAD_SIZE)
        if (remoteSegmentShardStats.directoryFileTransferTrackerStats.transferredBytesStarted != 0) {
        public static final String DOWNLOAD_TIME_IN_MILLIS = "download_time_in_millis";
        builder.startObject(SubFields.DOWNLOAD);
        static final String NODE_ID = "node";
            .field(UploadStatsFields.REMOTE_REFRESH_TIMESTAMP, remoteSegmentShardStats.remoteRefreshClockTimeMs)  
         * Represents the size of new data to be transferred as part of a remote store upload
        static final String REFRESH_TIME_LAG_IN_MILLIS = "refresh_time_lag_in_millis";  
            remoteSegmentShardStats.directoryFileTransferTrackerStats.lastTransferTimestampMs
        /**  
        /**
        builder.field(
         * Last successful sync from remote in milliseconds  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        static final String UPLOAD_TIME_IN_MILLIS = "upload_time_in_millis";
         * Most recent successful attempt stat
        // Ensuring that we are not showing 0 metrics to the user  
         * Time taken by a single remote refresh
        builder.endObject();  
 * The OpenSearch Contributors require contributions made to  
        builder.endObject();
            .field(SubFields.FAILED_BYTES, remoteSegmentShardStats.directoryFileTransferTrackerStats.transferredBytesFailed);  
            .field(SubFields.SUCCEEDED_BYTES, remoteSegmentShardStats.directoryFileTransferTrackerStats.transferredBytesSucceeded)
 * @opensearch.api
         */  
 * SPDX-License-Identifier: Apache-2.0
        builder.startObject(SubFields.UPLOAD);
    }
        builder.startObject(UploadStatsFields.REMOTE_REFRESH_SIZE_IN_BYTES)
        builder.endObject(); // translog.download
         */  
            .field(SubFields.MOVING_AVG, remoteSegmentShardStats.uploadBytesMovingAverage);  
    }  
    /**
         * Represents the total uploads to remote store in bytes
        builder.endObject(); // translog.upload
        builder.endObject();
            .field(SubFields.FAILED, remoteSegmentShardStats.totalUploadsFailed);  
        );
    }
        builder.field(SubFields.SUCCEEDED_BYTES, remoteTranslogShardStats.downloadBytesSucceeded);
        builder.startObject(SubFields.UPLOAD);
        builder.field(SubFields.MOVING_AVG, remoteTranslogShardStats.uploadBytesPerSecMovingAverage);  
import org.opensearch.core.xcontent.XContentBuilder;
        builder.startObject(DownloadStatsFields.DOWNLOAD_TIME_IN_MILLIS);
        }  
        // Ensuring that we are not showing 0 metrics to the user  
            .field(UploadStatsFields.BACKPRESSURE_REJECTION_COUNT, remoteSegmentShardStats.rejectionCount)
         */
import org.opensearch.index.remote.RemoteTranslogTransferTracker;  
        builder.field(SubFields.MOVING_AVG, remoteTranslogShardStats.uploadBytesMovingAverage);
    }
    @Override
    }  
        builder.endObject();  
         * Time taken by a remote store upload  
         */
         */
        /**
 */
        public static final String TOTAL_DOWNLOAD_TIME_IN_MILLIS = "total_download_time_in_millis";  
        /**
        builder.endObject(); // segment
    }  
         * Represents the size of new data to be uploaded as part of a refresh
        /**
        shardRouting.writeTo(out);
    }
        builder.field(RoutingFields.PRIMARY, shardRouting.primary());
         */
            .field(SubFields.SUCCEEDED_BYTES, remoteSegmentShardStats.uploadBytesSucceeded)
         */
            .field(SubFields.STARTED_BYTES, remoteSegmentShardStats.uploadBytesStarted)  
import org.opensearch.cluster.routing.ShardRouting;
        out.writeOptionalWriteable(remoteSegmentShardStats);  
        static final String ROUTING = "routing";
            .field(UploadStatsFields.REFRESH_TIME_LAG_IN_MILLIS, remoteSegmentShardStats.refreshTimeLagMs)
        remoteSegmentShardStats = in.readOptionalWriteable(RemoteSegmentTransferTracker.Stats::new);  
        builder.startObject(DownloadStatsFields.DOWNLOAD_SIZE_IN_BYTES)
     */  
        static final String UPLOAD_SPEED_IN_BYTES_PER_SEC = "upload_speed_in_bytes_per_sec";  
        builder.startObject(SubFields.DOWNLOAD);
 */  
            DownloadStatsFields.LAST_SYNC_TIMESTAMP,  
        /**
            .field(SubFields.FAILED_BYTES, remoteSegmentShardStats.uploadBytesFailed);
        public static final String TOTAL_UPLOADS = "total_uploads";
    }
            .field(SubFields.STARTED, remoteSegmentShardStats.totalUploadsStarted)
        builder.startObject(DownloadStatsFields.DOWNLOAD_SPEED_IN_BYTES_PER_SEC);
         */  
import org.opensearch.core.common.io.stream.Writeable;
        if (remoteTranslogShardStats.totalDownloadsSucceeded > 0) {
        builder.endObject();
    }
        builder.endObject();
import org.opensearch.core.common.io.stream.StreamInput;  
        builder.startObject(DownloadStatsFields.TOTAL_DOWNLOADS);
         */
         */
        builder.field(RoutingFields.NODE_ID, shardRouting.currentNodeId());  
            .field(SubFields.LAST_SUCCESSFUL, remoteSegmentShardStats.lastSuccessfulRemoteRefreshBytes)
    private void buildTranslogUploadStats(XContentBuilder builder) throws IOException {
        /**
         */
    }
        builder.endObject(); // translog
        public static final String SUCCEEDED_BYTES = "succeeded_bytes";
 * Encapsulates all remote store stats
        /**
        static final String BACKPRESSURE_REJECTION_COUNT = "backpressure_rejection_count";  
import org.opensearch.core.common.io.stream.StreamOutput;
        static final String PRIMARY = "primary";  
    static final class DownloadStatsFields {
         * No of refresh remote store is lagging behind local
     */  
    public RemoteSegmentTransferTracker.Stats getSegmentStats() {
            .field(SubFields.MOVING_AVG, remoteSegmentShardStats.directoryFileTransferTrackerStats.transferredBytesMovingAverage);
        static final String UPLOAD_SIZE_IN_BYTES = "upload_size_in_bytes";
         * Last successful local refresh timestamp in milliseconds  
        return builder.endObject();
    @Override
/*  
            .field(SubFields.FAILED_BYTES, remoteTranslogShardStats.uploadBytesFailed)
        static final String LOCAL_REFRESH_TIMESTAMP = "local_refresh_timestamp_in_millis";
        RemoteTranslogTransferTracker.Stats remoteTranslogShardStats,  
     * Fields for remote store stats response
         * Count of files uploaded to remote store
        builder.startObject(DownloadStatsFields.DOWNLOAD_SPEED_IN_BYTES_PER_SEC)  
    public RemoteTranslogTransferTracker.Stats getTranslogStats() {
         * Average speed (in bytes/sec) of a remote store download
        builder.field(SubFields.STARTED, remoteTranslogShardStats.totalUploadsStarted)  
import org.opensearch.common.annotation.PublicApi;
        static final String TRANSLOG = "translog";
        builder.endObject();
    }
    private final RemoteSegmentTransferTracker.Stats remoteSegmentShardStats;
    public static final class UploadStatsFields {
         * Average size of a file downloaded from the remote store
        builder.endObject();
    static final class Fields {
        return remoteTranslogShardStats;
        builder.field(UploadStatsFields.LAST_SUCCESSFUL_UPLOAD_TIMESTAMP, remoteTranslogShardStats.lastSuccessfulUploadTimestamp);  
         * Total time spent in downloads from remote store
        static final String REMOTE_REFRESH_TIMESTAMP = "remote_refresh_timestamp_in_millis";
        builder.field(SubFields.MOVING_AVG, remoteTranslogShardStats.uploadTimeMovingAverage);
        return remoteSegmentShardStats;  
        static final String DOWNLOAD_SPEED_IN_BYTES_PER_SEC = "download_speed_in_bytes_per_sec";  
         */
            .field(SubFields.MOVING_AVG, remoteSegmentShardStats.uploadBytesPerSecMovingAverage);  
        /**  
        buildShardRouting(builder);
            .field(SubFields.SUCCEEDED, remoteTranslogShardStats.totalUploadsSucceeded);
        builder.startObject(UploadStatsFields.TOTAL_UPLOADS);
            .field(SubFields.MOVING_AVG, remoteSegmentShardStats.directoryFileTransferTrackerStats.transferredBytesPerSecMovingAverage);
