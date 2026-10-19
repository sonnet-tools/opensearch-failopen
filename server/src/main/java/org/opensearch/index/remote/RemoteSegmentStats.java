            uploadBytesFailed,  
    }
    }
    private void buildUploadStats(XContentBuilder builder) throws IOException {  
        }
    }
            this.totalRejections += existingStats.totalRejections;  
    private long downloadBytesStarted;  
    public int hashCode() {  
    public long getMaxRefreshTimeLag() {  
        builder.endObject(); // DOWNLOAD
        out.writeLong(totalDownloadTime);
        static final String MAX_REFRESH_TIME_LAG_IN_MILLIS = "max_refresh_time_lag_in_millis";  
    public void addTotalRejections(long totalRejections) {
/**
     * Used to check for data freshness in the remote store
    /**
    public long getTotalRejections() {
            && totalDownloadTime == that.totalDownloadTime
    public void addUploadBytesSucceeded(long uploadsSucceeded) {
        downloadBytesStarted = in.readLong();
import org.opensearch.core.common.unit.ByteSizeValue;
    /**
        builder.endObject();
        builder.endObject(); // REFRESH_SIZE_LAG
    public void writeTo(StreamOutput out) throws IOException {
            downloadBytesStarted,
    public void addDownloadBytesStarted(long downloadsStarted) {
@PublicApi(since = "2.10.0")
    }  
    }
    public void addDownloadBytesFailed(long downloadsFailed) {  
     * Cumulative bytes failed to be uploaded to the remote store
        static final String STARTED = "started";
        return downloadBytesStarted;
            && downloadBytesSucceeded == that.downloadBytesSucceeded
        this.uploadBytesSucceeded = trackerStats.uploadBytesSucceeded;
            totalRejections = in.readVLong();
            out.writeVLong(totalRejections);  
    public long getDownloadBytesStarted() {  
    }  
        builder.startObject(Fields.REFRESH_SIZE_LAG);
}
package org.opensearch.index.remote;
        static final String MAX_BYTES = "max_bytes";
     */
     *
        return uploadBytesSucceeded;
    public void setMaxRefreshTimeLag(long maxRefreshTimeLag) {
            totalRejections
import org.opensearch.common.unit.TimeValue;
            this.uploadBytesStarted += existingStats.getUploadBytesStarted();
        return downloadBytesSucceeded;
        builder.humanReadableField(Fields.MAX_REFRESH_TIME_LAG_IN_MILLIS, Fields.MAX_REFRESH_TIME_LAG, new TimeValue(maxRefreshTimeLag));  
    }  
        static final String SUCCEEDED = "succeeded";  
        builder.endObject(); // TOTAL_UPLOAD_SIZE
        builder.field(Fields.TOTAL_REJECTIONS, totalRejections);
     */  
        buildDownloadStats(builder);
        uploadBytesFailed = in.readLong();
import org.opensearch.core.xcontent.ToXContentFragment;  
     */
    // Setters are only used for testing
        out.writeLong(totalRefreshBytesLag);
        this.totalDownloadTime += totalDownloadTime;
    private long maxRefreshBytesLag;  
            maxRefreshBytesLag,  
import org.opensearch.Version;
            && downloadBytesFailed == that.downloadBytesFailed
        return maxRefreshBytesLag;  
    public long getTotalDownloadTime() {
    public long getTotalUploadTime() {  
        if (this == o) return true;
     * Cumulative bytes failed to be downloaded from the remote store
        static final String TOTAL_BYTES = "total_bytes";  
 *
    /**  
        this.totalRefreshBytesLag += totalRefreshBytesLag;  
        }
    private long uploadBytesSucceeded;
    @Override
        builder.endObject(); // PRESSURE
            this.totalUploadTime += existingStats.getTotalUploadTime();
        return uploadBytesFailed;  
    private long uploadBytesStarted;  
        this.totalUploadTime = trackerStats.totalUploadTimeInMs;
    public long getMaxRefreshBytesLag() {
     * @param trackerStats: Source {@link RemoteSegmentTransferTracker.Stats} object from which metrics would be retrieved
        out.writeLong(uploadBytesSucceeded);
        return totalRefreshBytesLag;
    private long downloadBytesSucceeded;
    }
 * compatible open source license.
        out.writeLong(downloadBytesSucceeded);
        builder.humanReadableField(Fields.TOTAL_TIME_SPENT_IN_MILLIS, Fields.TOTAL_TIME_SPENT, new TimeValue(totalDownloadTime));
        static final String PRESSURE = "pressure";
        downloadBytesSucceeded = in.readLong();  
        out.writeLong(uploadBytesFailed);
import org.opensearch.core.common.io.stream.StreamInput;
        if (out.getVersion().onOrAfter(Version.V_2_12_0)) {
 * @opensearch.api
    }
import org.opensearch.core.common.io.stream.Writeable;
    }
    private long maxRefreshTimeLag;
        static final String MAX_REFRESH_TIME_LAG = "max_refresh_time_lag";
        this.uploadBytesFailed += uploadsFailed;
     * Total refresh lag (in bytes) between local and the remote store
        maxRefreshTimeLag = in.readLong();
    public long getUploadBytesSucceeded() {
    public void addTotalUploadTime(long totalUploadTime) {
        totalDownloadTime = in.readLong();
        this.uploadBytesFailed = trackerStats.uploadBytesFailed;  
    public long getDownloadBytesFailed() {
        uploadBytesStarted = in.readLong();
        static final String TOTAL_TIME_SPENT = "total_time_spent";  
        this.downloadBytesFailed += downloadsFailed;
        this.uploadBytesStarted = trackerStats.uploadBytesStarted;
        builder.humanReadableField(Fields.FAILED_BYTES, Fields.FAILED, new ByteSizeValue(downloadBytesFailed));  
     * Cumulative bytes successfully downloaded from the remote store  
            this.maxRefreshBytesLag = Math.max(this.maxRefreshBytesLag, existingStats.getMaxRefreshBytesLag());
    private long totalUploadTime;  
        this.downloadBytesStarted += downloadsStarted;
     * provides verbose index level stats of segments transferred to the remote store.
     */
    /**
    }
     * Maximum refresh lag (in bytes) between local and the remote store  
     */
    }  
            && uploadBytesSucceeded == that.uploadBytesSucceeded
 */  
            this.totalRefreshBytesLag += existingStats.getTotalRefreshBytesLag();  
    }
            && uploadBytesFailed == that.uploadBytesFailed
            downloadBytesFailed,  
    public long getDownloadBytesSucceeded() {
     */
        builder.endObject(); // REMOTE_STORE
     * Constructor to retrieve metrics from {@link RemoteSegmentTransferTracker.Stats} which is used in {@link RemoteStoreStats} and  
     * Used to check for data freshness in the remote store
        builder.endObject(); // UPLOAD
            maxRefreshTimeLag,
            this.downloadBytesStarted += existingStats.getDownloadBytesStarted();
    public void addTotalDownloadTime(long totalDownloadTime) {  
        builder.humanReadableField(Fields.SUCCEEDED_BYTES, Fields.SUCCEEDED, new ByteSizeValue(downloadBytesSucceeded));
 *
        this.totalUploadTime += totalUploadTime;
        builder.startObject(Fields.TOTAL_DOWNLOAD_SIZE);  
    }  
        static final String SUCCEEDED_BYTES = "succeeded_bytes";
    public void addTotalRefreshBytesLag(long totalRefreshBytesLag) {
        builder.humanReadableField(Fields.TOTAL_TIME_SPENT_IN_MILLIS, Fields.TOTAL_TIME_SPENT, new TimeValue(totalUploadTime));
    }  
        maxRefreshBytesLag = in.readLong();
        builder.startObject(Fields.DOWNLOAD);  
        RemoteSegmentStats that = (RemoteSegmentStats) o;
 */  
        builder.humanReadableField(Fields.FAILED_BYTES, Fields.FAILED, new ByteSizeValue(uploadBytesFailed));
        builder.humanReadableField(Fields.MAX_BYTES, Fields.MAX, new ByteSizeValue(maxRefreshBytesLag));  
    /**  
        this.totalRejections += totalRejections;  
import java.util.Objects;
        this.downloadBytesFailed = trackerStats.directoryFileTransferTrackerStats.transferredBytesFailed;
            this.downloadBytesSucceeded += existingStats.getDownloadBytesSucceeded();  
        this.uploadBytesSucceeded += uploadsSucceeded;  
import org.opensearch.index.shard.IndexShard;
    @Override
        builder.humanReadableField(Fields.STARTED_BYTES, Fields.STARTED, new ByteSizeValue(downloadBytesStarted));
    }
        out.writeLong(maxRefreshBytesLag);
        builder.humanReadableField(Fields.TOTAL_BYTES, Fields.TOTAL, new ByteSizeValue(totalRefreshBytesLag));
        this.uploadBytesStarted += uploadsStarted;
        builder.humanReadableField(Fields.SUCCEEDED_BYTES, Fields.SUCCEEDED, new ByteSizeValue(uploadBytesSucceeded));  
    /**
    }  
        this.downloadBytesSucceeded = trackerStats.directoryFileTransferTrackerStats.transferredBytesSucceeded;
    }
        out.writeLong(downloadBytesFailed);
    public void addMaxRefreshBytesLag(long maxRefreshBytesLag) {  
    public void addUploadBytesFailed(long uploadsFailed) {  
        builder.startObject(Fields.REMOTE_STORE);  
    // Getter and setters. All are visible for testing
    /**  
    }
     * Total time spent in downloading segments from remote store
    }
        return builder;  
            uploadBytesSucceeded,
     */
    public void addDownloadBytesSucceeded(long downloadsSucceeded) {
        static final String REFRESH_SIZE_LAG = "refresh_size_lag";
    private long totalRefreshBytesLag;
        builder.startObject(Fields.TOTAL_UPLOAD_SIZE);
public class RemoteSegmentStats implements Writeable, ToXContentFragment {
        return totalRejections;
            totalDownloadTime,  
        this.totalRejections = trackerStats.rejectionCount;
    @Override  
        static final String FAILED_BYTES = "failed_bytes";
        static final String STARTED_BYTES = "started_bytes";  
     */
    private long totalRejections;
    /**
            this.uploadBytesFailed += existingStats.getUploadBytesFailed();  
        return maxRefreshTimeLag;
        this.maxRefreshBytesLag = trackerStats.bytesLag;  
     * Total rejections due to remote store upload backpressure  
    /**
            this.maxRefreshTimeLag = Math.max(this.maxRefreshTimeLag, existingStats.getMaxRefreshTimeLag());
        // value from the tracker object
    public long getTotalRefreshBytesLag() {
        if (in.getVersion().onOrAfter(Version.V_2_12_0)) {  
     *
        // Aggregations would be performed on the add method
    }
     * Cumulative bytes attempted to be downloaded from the remote store
     */  
            this.uploadBytesSucceeded += existingStats.getUploadBytesSucceeded();
        return Objects.hash(
        static final String MAX = "max";
            && maxRefreshTimeLag == that.maxRefreshTimeLag  
import org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStats;
        uploadBytesSucceeded = in.readLong();  
    }  
        static final String TOTAL_TIME_SPENT_IN_MILLIS = "total_time_spent_in_millis";
        static final String DOWNLOAD = "download";
    }  
        }
 * Tracks remote store segment download and upload stats
    public void addUploadBytesStarted(long uploadsStarted) {
            downloadBytesSucceeded,
/*  
    private void buildDownloadStats(XContentBuilder builder) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
    }
            && maxRefreshBytesLag == that.maxRefreshBytesLag
    }  
            && downloadBytesStarted == that.downloadBytesStarted  
            && totalUploadTime == that.totalUploadTime  
        builder.humanReadableField(Fields.STARTED_BYTES, Fields.STARTED, new ByteSizeValue(uploadBytesStarted));
        this.maxRefreshTimeLag = trackerStats.refreshTimeLagMs;
     * Maximum refresh lag (in milliseconds) between local and the remote store
        out.writeLong(totalUploadTime);  
    /**  
            this.totalDownloadTime += existingStats.getTotalDownloadTime();
    private long totalDownloadTime;
    /**
    public long getUploadBytesStarted() {  
        static final String UPLOAD = "upload";
        this.maxRefreshBytesLag = Math.max(this.maxRefreshBytesLag, maxRefreshBytesLag);
        return totalUploadTime;
        // Initializing both total and max bytes lag to the same `bytesLag`  
import org.opensearch.core.common.io.stream.StreamOutput;  
        if (o == null || getClass() != o.getClass()) return false;  
     */
    /**  
     */  
            totalUploadTime,
            this.downloadBytesFailed += existingStats.getDownloadBytesFailed();
            && totalRefreshBytesLag == that.totalRefreshBytesLag
     * Adds existing stats. Used for stats roll-ups at index or node level
     * Cumulative bytes successfully uploaded to the remote store  
    }
        static final String FAILED = "failed";
    public boolean equals(Object o) {
        static final String TOTAL_REJECTIONS = "total_rejections";  
    public void add(RemoteSegmentStats existingStats) {
        downloadBytesFailed = in.readLong();
    }
import java.io.IOException;
        builder.startObject(Fields.UPLOAD);
        buildUploadStats(builder);  
    @Override
    public long getUploadBytesFailed() {
        static final String TOTAL = "total";
    public RemoteSegmentStats() {}
            totalRefreshBytesLag,
            && totalRejections == that.totalRejections;
        this.maxRefreshTimeLag = Math.max(this.maxRefreshTimeLag, maxRefreshTimeLag);
        out.writeLong(maxRefreshTimeLag);  
    }  
    }  
     * Cumulative bytes attempted to be uploaded to remote store
     * Used to check for data freshness in the remote store  
        if (existingStats != null) {  
    }
        this.totalDownloadTime = trackerStats.directoryFileTransferTrackerStats.totalTransferTimeInMs;  
    public RemoteSegmentStats(StreamInput in) throws IOException {  
    }  
import org.opensearch.core.xcontent.XContentBuilder;
     * <p>
        );
    }
        out.writeLong(downloadBytesStarted);  
    private long downloadBytesFailed;
    private long uploadBytesFailed;
 * The OpenSearch Contributors require contributions made to  
        static final String TOTAL_DOWNLOAD_SIZE = "total_download_size";
        out.writeLong(uploadBytesStarted);  
        this.downloadBytesSucceeded += downloadsSucceeded;  
        static final String TOTAL_UPLOAD_SIZE = "total_upload_size";  
    /**
    static final class Fields {
        return downloadBytesFailed;  
        return totalDownloadTime;  
import org.opensearch.common.annotation.PublicApi;  
        totalUploadTime = in.readLong();
     */  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        return uploadBytesStarted == that.uploadBytesStarted  
 * Used for displaying remote store stats in IndicesStats/NodeStats API  
    public RemoteSegmentStats(RemoteSegmentTransferTracker.Stats trackerStats) {
        static final String REMOTE_STORE = "remote_store";  
     */  
     * Total time spent in uploading segments to remote store
     */
    }
        builder.startObject(Fields.PRESSURE);  
        return uploadBytesStarted;
        totalRefreshBytesLag = in.readLong();  
        this.downloadBytesStarted = trackerStats.directoryFileTransferTrackerStats.transferredBytesStarted;  
    /**
 * this file be licensed under the Apache-2.0 license or a
        this.totalRefreshBytesLag = trackerStats.bytesLag;
    }
     * @param existingStats: Existing {@link RemoteSegmentStats} to add  
     * This method is used in {@link IndexShard} to port over a subset of metrics to be displayed in IndexStats and subsequently rolled up to NodesStats  
            uploadBytesStarted,
