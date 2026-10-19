        downloadBytesFailed = in.readLong();
        if (existingStats != null) {
        out.writeLong(maxRefreshTimeLag);
        uploadBytesStarted = in.readLong();
    }
        builder.humanReadableField(Fields.MAX_REFRESH_TIME_LAG_IN_MILLIS, Fields.MAX_REFRESH_TIME_LAG, new TimeValue(maxRefreshTimeLag));
        buildDownloadStats(builder);
    public void addTotalRejections(long totalRejections) {
        out.writeLong(totalUploadTime);
        builder.endObject(); // REFRESH_SIZE_LAG
    }
    @Override
    public void addDownloadBytesSucceeded(long downloadsSucceeded) {
        maxRefreshTimeLag = in.readLong();
import java.util.Objects;
    }
    public void addDownloadBytesFailed(long downloadsFailed) {
            totalUploadTime,
package org.opensearch.index.remote;
        totalUploadTime = in.readLong();
        builder.humanReadableField(Fields.SUCCEEDED_BYTES, Fields.SUCCEEDED, new ByteSizeValue(uploadBytesSucceeded));
            out.writeVLong(totalRejections);
        out.writeLong(downloadBytesStarted);
        static final String TOTAL = "total";
        builder.humanReadableField(Fields.STARTED_BYTES, Fields.STARTED, new ByteSizeValue(uploadBytesStarted));
    static final class Fields {
     *
    }
        static final String MAX_REFRESH_TIME_LAG_IN_MILLIS = "max_refresh_time_lag_in_millis";
import org.opensearch.core.common.unit.ByteSizeValue;
            totalRejections = in.readVLong();
 */
        out.writeLong(downloadBytesFailed);
            && totalDownloadTime == that.totalDownloadTime
    public long getDownloadBytesSucceeded() {
import org.opensearch.common.unit.TimeValue;
            uploadBytesSucceeded,
        this.maxRefreshBytesLag = Math.max(this.maxRefreshBytesLag, maxRefreshBytesLag);
    }
import org.opensearch.common.annotation.PublicApi;
    /**
        this.downloadBytesStarted += downloadsStarted;
        return uploadBytesStarted;
        this.totalDownloadTime += totalDownloadTime;
    public void addTotalRefreshBytesLag(long totalRefreshBytesLag) {
        static final String FAILED_BYTES = "failed_bytes";
    public long getDownloadBytesFailed() {
            && downloadBytesStarted == that.downloadBytesStarted
public class RemoteSegmentStats implements Writeable, ToXContentFragment {
            totalRejections
    /**
        static final String TOTAL_TIME_SPENT_IN_MILLIS = "total_time_spent_in_millis";
            totalRefreshBytesLag,
            this.maxRefreshTimeLag = Math.max(this.maxRefreshTimeLag, existingStats.getMaxRefreshTimeLag());
    @Override
    }
            downloadBytesStarted,
            totalDownloadTime,
        out.writeLong(maxRefreshBytesLag);
        builder.endObject(); // PRESSURE
        uploadBytesSucceeded = in.readLong();
            && downloadBytesSucceeded == that.downloadBytesSucceeded
    public void writeTo(StreamOutput out) throws IOException {
        static final String STARTED_BYTES = "started_bytes";
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        builder.humanReadableField(Fields.STARTED_BYTES, Fields.STARTED, new ByteSizeValue(downloadBytesStarted));
     */
    /**
        this.totalRejections += totalRejections;
     */
        // value from the tracker object
    }
     */
        if (o == null || getClass() != o.getClass()) return false;
    // Setters are only used for testing
    }
        static final String SUCCEEDED = "succeeded";
 * compatible open source license.
     * Maximum refresh lag (in bytes) between local and the remote store
 * Tracks remote store segment download and upload stats
    }
        static final String REFRESH_SIZE_LAG = "refresh_size_lag";
     * Total time spent in downloading segments from remote store
     * Total refresh lag (in bytes) between local and the remote store
@PublicApi(since = "2.10.0")
        return totalRejections;
        this.downloadBytesFailed = trackerStats.directoryFileTransferTrackerStats.transferredBytesFailed;
        builder.startObject(Fields.UPLOAD);
import org.opensearch.Version;
        return Objects.hash(
            && uploadBytesSucceeded == that.uploadBytesSucceeded
            && uploadBytesFailed == that.uploadBytesFailed
     * <p>
        return maxRefreshBytesLag;
     * @param trackerStats: Source {@link RemoteSegmentTransferTracker.Stats} object from which metrics would be retrieved
        out.writeLong(uploadBytesStarted);
            this.maxRefreshBytesLag = Math.max(this.maxRefreshBytesLag, existingStats.getMaxRefreshBytesLag());
     */
        this.uploadBytesStarted += uploadsStarted;
     * Used to check for data freshness in the remote store
    }
        return totalDownloadTime;
        builder.startObject(Fields.TOTAL_DOWNLOAD_SIZE);
        static final String TOTAL_DOWNLOAD_SIZE = "total_download_size";
     * Adds existing stats. Used for stats roll-ups at index or node level
import org.opensearch.index.shard.IndexShard;
        this.downloadBytesFailed += downloadsFailed;
    @Override
    }
            downloadBytesSucceeded,
     * Used to check for data freshness in the remote store
    }
        totalDownloadTime = in.readLong();
import java.io.IOException;
            this.uploadBytesFailed += existingStats.getUploadBytesFailed();
    private void buildUploadStats(XContentBuilder builder) throws IOException {
    /**
        this.uploadBytesSucceeded += uploadsSucceeded;
        return downloadBytesSucceeded;
        this.downloadBytesSucceeded += downloadsSucceeded;
        this.maxRefreshTimeLag = trackerStats.refreshTimeLagMs;
        out.writeLong(totalRefreshBytesLag);
    }
        this.totalDownloadTime = trackerStats.directoryFileTransferTrackerStats.totalTransferTimeInMs;
        this.totalUploadTime += totalUploadTime;
 * SPDX-License-Identifier: Apache-2.0
            this.downloadBytesStarted += existingStats.getDownloadBytesStarted();
    /**
        builder.humanReadableField(Fields.FAILED_BYTES, Fields.FAILED, new ByteSizeValue(uploadBytesFailed));
        builder.endObject(); // DOWNLOAD
        if (out.getVersion().onOrAfter(Version.V_2_12_0)) {
        static final String TOTAL_BYTES = "total_bytes";
        uploadBytesFailed = in.readLong();
     */
     */
    /**
    }
    }
    /**
    public void addMaxRefreshBytesLag(long maxRefreshBytesLag) {
    }
        this.uploadBytesFailed += uploadsFailed;
    }
    private long maxRefreshBytesLag;
     */
    }
import org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStats;
    private long uploadBytesSucceeded;
     * @param existingStats: Existing {@link RemoteSegmentStats} to add
    // Getter and setters. All are visible for testing
            && maxRefreshBytesLag == that.maxRefreshBytesLag
     */
    public void add(RemoteSegmentStats existingStats) {
    /**
    public long getUploadBytesStarted() {
        return downloadBytesStarted;
    }
    private long downloadBytesStarted;
    public void setMaxRefreshTimeLag(long maxRefreshTimeLag) {
    public long getTotalRejections() {
    private long downloadBytesSucceeded;
        builder.endObject();
        out.writeLong(uploadBytesFailed);
    public long getTotalRefreshBytesLag() {
        this.maxRefreshTimeLag = Math.max(this.maxRefreshTimeLag, maxRefreshTimeLag);
        builder.humanReadableField(Fields.TOTAL_TIME_SPENT_IN_MILLIS, Fields.TOTAL_TIME_SPENT, new TimeValue(totalUploadTime));
            uploadBytesFailed,
        if (this == o) return true;
     * Cumulative bytes successfully uploaded to the remote store
import org.opensearch.core.xcontent.ToXContentFragment;
        }
    }
        builder.endObject(); // UPLOAD
            this.totalDownloadTime += existingStats.getTotalDownloadTime();
    }
    private long totalRejections;
        static final String MAX_REFRESH_TIME_LAG = "max_refresh_time_lag";
        builder.humanReadableField(Fields.TOTAL_BYTES, Fields.TOTAL, new ByteSizeValue(totalRefreshBytesLag));
        return uploadBytesStarted == that.uploadBytesStarted
        downloadBytesSucceeded = in.readLong();
        builder.endObject(); // REMOTE_STORE
     * Cumulative bytes attempted to be downloaded from the remote store
    /**
    private long maxRefreshTimeLag;
    public boolean equals(Object o) {
        static final String REMOTE_STORE = "remote_store";
        this.downloadBytesSucceeded = trackerStats.directoryFileTransferTrackerStats.transferredBytesSucceeded;
        builder.field(Fields.TOTAL_REJECTIONS, totalRejections);
    private long uploadBytesFailed;
        static final String TOTAL_TIME_SPENT = "total_time_spent";
        return totalRefreshBytesLag;
     */
        }
            downloadBytesFailed,
    }
        builder.startObject(Fields.REMOTE_STORE);
    private void buildDownloadStats(XContentBuilder builder) throws IOException {
     * Maximum refresh lag (in milliseconds) between local and the remote store
            this.totalRefreshBytesLag += existingStats.getTotalRefreshBytesLag();
    public long getMaxRefreshBytesLag() {
        static final String FAILED = "failed";
        RemoteSegmentStats that = (RemoteSegmentStats) o;
    }
import org.opensearch.core.xcontent.XContentBuilder;
        this.uploadBytesStarted = trackerStats.uploadBytesStarted;
     * Cumulative bytes successfully downloaded from the remote store
 */
    public RemoteSegmentStats() {}
     */
            this.downloadBytesFailed += existingStats.getDownloadBytesFailed();
        static final String MAX_BYTES = "max_bytes";
            && downloadBytesFailed == that.downloadBytesFailed
    public void addUploadBytesStarted(long uploadsStarted) {
    public long getUploadBytesSucceeded() {
    public void addDownloadBytesStarted(long downloadsStarted) {
    public int hashCode() {
        buildUploadStats(builder);
    /**
        static final String TOTAL_UPLOAD_SIZE = "total_upload_size";
        maxRefreshBytesLag = in.readLong();
     * Used to check for data freshness in the remote store
        out.writeLong(uploadBytesSucceeded);
    public void addTotalUploadTime(long totalUploadTime) {
        static final String MAX = "max";
    }
        builder.humanReadableField(Fields.TOTAL_TIME_SPENT_IN_MILLIS, Fields.TOTAL_TIME_SPENT, new TimeValue(totalDownloadTime));
            maxRefreshBytesLag,
            && totalUploadTime == that.totalUploadTime
    }
     * This method is used in {@link IndexShard} to port over a subset of metrics to be displayed in IndexStats and subsequently rolled up to NodesStats
     *
 * The OpenSearch Contributors require contributions made to
        out.writeLong(totalDownloadTime);
     * Constructor to retrieve metrics from {@link RemoteSegmentTransferTracker.Stats} which is used in {@link RemoteStoreStats} and
/*
 *
        static final String DOWNLOAD = "download";
    }
     */
        return downloadBytesFailed;
            this.totalUploadTime += existingStats.getTotalUploadTime();
        totalRefreshBytesLag = in.readLong();
        this.uploadBytesSucceeded = trackerStats.uploadBytesSucceeded;
    }
        return builder;
    public void addTotalDownloadTime(long totalDownloadTime) {
     * Cumulative bytes failed to be uploaded to the remote store
        builder.humanReadableField(Fields.MAX_BYTES, Fields.MAX, new ByteSizeValue(maxRefreshBytesLag));
            && totalRefreshBytesLag == that.totalRefreshBytesLag
        return totalUploadTime;
 * this file be licensed under the Apache-2.0 license or a
 * Used for displaying remote store stats in IndicesStats/NodeStats API
            && maxRefreshTimeLag == that.maxRefreshTimeLag
    /**
        this.uploadBytesFailed = trackerStats.uploadBytesFailed;
    }
            this.uploadBytesSucceeded += existingStats.getUploadBytesSucceeded();
        }
    }
    public void addUploadBytesFailed(long uploadsFailed) {
     * Total rejections due to remote store upload backpressure
 *
        builder.startObject(Fields.TOTAL_UPLOAD_SIZE);
    public long getTotalUploadTime() {
            this.uploadBytesStarted += existingStats.getUploadBytesStarted();
    }
/**
     * provides verbose index level stats of segments transferred to the remote store.
    public void addUploadBytesSucceeded(long uploadsSucceeded) {
        static final String STARTED = "started";
        builder.startObject(Fields.PRESSURE);
    private long downloadBytesFailed;
    }
            this.totalRejections += existingStats.totalRejections;
        this.totalUploadTime = trackerStats.totalUploadTimeInMs;
        );
        this.maxRefreshBytesLag = trackerStats.bytesLag;
     */
    private long totalDownloadTime;
import org.opensearch.core.common.io.stream.StreamInput;
    public long getUploadBytesFailed() {
        builder.humanReadableField(Fields.FAILED_BYTES, Fields.FAILED, new ByteSizeValue(downloadBytesFailed));
        downloadBytesStarted = in.readLong();
        static final String SUCCEEDED_BYTES = "succeeded_bytes";
     */
    public long getMaxRefreshTimeLag() {
    }
     */
    public RemoteSegmentStats(StreamInput in) throws IOException {
            && totalRejections == that.totalRejections;
        builder.startObject(Fields.DOWNLOAD);
    /**
        this.totalRefreshBytesLag += totalRefreshBytesLag;
        return uploadBytesFailed;
        static final String UPLOAD = "upload";
        return uploadBytesSucceeded;
    /**
        return maxRefreshTimeLag;
    }
        static final String TOTAL_REJECTIONS = "total_rejections";
        static final String PRESSURE = "pressure";
    /**
import org.opensearch.core.common.io.stream.StreamOutput;
        this.totalRejections = trackerStats.rejectionCount;
        if (in.getVersion().onOrAfter(Version.V_2_12_0)) {
    public long getDownloadBytesStarted() {
            maxRefreshTimeLag,
    private long totalRefreshBytesLag;
        builder.startObject(Fields.REFRESH_SIZE_LAG);
    public long getTotalDownloadTime() {
        // Initializing both total and max bytes lag to the same `bytesLag`
     * Total time spent in uploading segments to remote store
        // Aggregations would be performed on the add method
        this.downloadBytesStarted = trackerStats.directoryFileTransferTrackerStats.transferredBytesStarted;
    private long totalUploadTime;
    private long uploadBytesStarted;
     * Cumulative bytes attempted to be uploaded to remote store
}
            this.downloadBytesSucceeded += existingStats.getDownloadBytesSucceeded();
    public RemoteSegmentStats(RemoteSegmentTransferTracker.Stats trackerStats) {
        builder.humanReadableField(Fields.SUCCEEDED_BYTES, Fields.SUCCEEDED, new ByteSizeValue(downloadBytesSucceeded));
        builder.endObject(); // TOTAL_UPLOAD_SIZE
     * Cumulative bytes failed to be downloaded from the remote store
        out.writeLong(downloadBytesSucceeded);
            uploadBytesStarted,
        this.totalRefreshBytesLag = trackerStats.bytesLag;
import org.opensearch.core.common.io.stream.Writeable;
 * @opensearch.api
    }
    @Override
