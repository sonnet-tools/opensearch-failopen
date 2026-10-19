    /**
            uploadBytesStarted,
import org.opensearch.core.common.io.stream.StreamOutput;
            new ByteSizeValue(uploadBytesSucceeded)  
        return uploadBytesStarted;  
            && this.uploadBytesStarted == other.uploadBytesStarted
        return totalUploadsSucceeded;
    }
        this.uploadBytesFailed = in.readVLong();  
        builder.endObject(); // translog.remote_store  
 * SPDX-License-Identifier: Apache-2.0
        this.totalUploadsStarted += other.totalUploadsStarted;
    }  
        builder.endObject();
     * Total number of Remote Translog Store uploads that have failed.  
            RemoteStoreStats.SubFields.FAILED,  
    private long uploadBytesStarted;  
    public RemoteTranslogStats(StreamInput in) throws IOException {
            totalUploadsSucceeded,  
import org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStats;
        builder.startObject(REMOTE_STORE);  
            && this.totalUploadsSucceeded == other.totalUploadsSucceeded
    }  
        this.totalUploadsFailed = transferTrackerStats.totalUploadsFailed;  
    /**
 * @opensearch.api
    public long getTotalUploadsSucceeded() {
package org.opensearch.index.translog;
    @Override
        builder.field(RemoteStoreStats.SubFields.STARTED, totalUploadsStarted)
        this.uploadBytesStarted = in.readVLong();
import org.opensearch.common.annotation.PublicApi;
    private long totalUploadsFailed;
    public long getUploadBytesSucceeded() {
        return totalUploadsFailed;
    @Override
        builder.startObject(RemoteStoreStats.UploadStatsFields.TOTAL_UPLOADS);
        if (obj == null || getClass() != obj.getClass()) return false;
            RemoteStoreStats.SubFields.SUCCEEDED,
    public RemoteTranslogStats(RemoteTranslogTransferTracker.Stats transferTrackerStats) {
        out.writeVLong(totalUploadsSucceeded);
    public int hashCode() {
    public long getUploadBytesStarted() {
    }
    public RemoteTranslogStats() {}
/**
     * Total number of Remote Translog Store uploads that have been successful.
            && this.totalUploadsFailed == other.totalUploadsFailed  
            totalUploadsFailed,
    @Override
    /**
        this.uploadBytesStarted += other.uploadBytesStarted;
        );
    public long getUploadBytesFailed() {  
    /**  
        return uploadBytesSucceeded;
    private long uploadBytesSucceeded;
    }
     */
        out.writeVLong(uploadBytesSucceeded);
    public boolean equals(Object obj) {  
            totalUploadsStarted,
    public void writeTo(StreamOutput out) throws IOException {
@PublicApi(since = "2.10.0")
        );
import java.util.Objects;  
 * this file be licensed under the Apache-2.0 license or a
            RemoteStoreStats.SubFields.STARTED,
        out.writeVLong(uploadBytesStarted);  
     */  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     */
import org.opensearch.core.common.io.stream.StreamInput;  
        return builder;
 *
        this.uploadBytesSucceeded = in.readVLong();
import org.opensearch.core.xcontent.ToXContentFragment;
            .field(RemoteStoreStats.SubFields.SUCCEEDED, totalUploadsSucceeded);
        this.totalUploadsStarted = in.readVLong();
            && this.uploadBytesSucceeded == other.uploadBytesSucceeded;
     * Total number of Remote Translog Store uploads that have been started
    private long totalUploadsSucceeded;
            return;
     */  
    }
 *
        builder.humanReadableField(
    }  
            RemoteStoreStats.SubFields.STARTED_BYTES,  
        out.writeVLong(uploadBytesFailed);
        );
     * Total number of byte uploads to Remote Translog Store that have been started.
        return Objects.hash(  
        this.uploadBytesStarted = transferTrackerStats.uploadBytesStarted;
    }
        }
/*  
 */  
    static final String REMOTE_STORE = "remote_store";  
        this.totalUploadsSucceeded = in.readVLong();
    }  
        return totalUploadsStarted;  
    /**  
        this.totalUploadsSucceeded = transferTrackerStats.totalUploadsSucceeded;
        this.totalUploadsFailed += other.totalUploadsFailed;
        builder.endObject(); // translog.remote_store.upload
        builder.humanReadableField(
    }
import org.opensearch.core.common.io.stream.Writeable;
    public void add(RemoteTranslogStats other) {
        out.writeVLong(totalUploadsFailed);
import org.opensearch.core.xcontent.XContentBuilder;
    }
        RemoteTranslogStats other = (RemoteTranslogStats) obj;  
        if (other == null) {  
    private long totalUploadsStarted;  
     */
    void addRemoteTranslogUploadStatsXContent(XContentBuilder builder) throws IOException {  
    private long uploadBytesFailed;
    }  
}
     * Total number of byte uploads to Remote Translog Store that have been successful.
            new ByteSizeValue(uploadBytesStarted)
        builder.endObject();
        this.totalUploadsStarted = transferTrackerStats.totalUploadsStarted;
            uploadBytesFailed,
import java.io.IOException;
        this.uploadBytesFailed += other.uploadBytesFailed;
 * The OpenSearch Contributors require contributions made to  
 */  
     */
            uploadBytesSucceeded  
            RemoteStoreStats.SubFields.FAILED_BYTES,
        out.writeVLong(totalUploadsStarted);  
        builder.startObject(RemoteStoreStats.SubFields.UPLOAD);
        addRemoteTranslogUploadStatsXContent(builder);  
        if (this == obj) return true;
    }
        this.totalUploadsFailed = in.readVLong();  
        builder.humanReadableField(  
            RemoteStoreStats.SubFields.SUCCEEDED_BYTES,
    /**
            && this.uploadBytesFailed == other.uploadBytesFailed  
        return this.totalUploadsStarted == other.totalUploadsStarted
     * Total number of byte uploads to Remote Translog Store that have failed.  
        this.uploadBytesSucceeded += other.uploadBytesSucceeded;  
        );  
    public long getTotalUploadsFailed() {  
        this.uploadBytesSucceeded = transferTrackerStats.uploadBytesSucceeded;
        builder.startObject(RemoteStoreStats.UploadStatsFields.TOTAL_UPLOAD_SIZE);
        return uploadBytesFailed;
        this.totalUploadsSucceeded += other.totalUploadsSucceeded;  
    public long getTotalUploadsStarted() {
import org.opensearch.index.remote.RemoteTranslogTransferTracker;  
 * compatible open source license.
            new ByteSizeValue(uploadBytesFailed)
            .field(RemoteStoreStats.SubFields.FAILED, totalUploadsFailed)  
    }
        this.uploadBytesFailed = transferTrackerStats.uploadBytesFailed;  
public class RemoteTranslogStats implements ToXContentFragment, Writeable {
import org.opensearch.core.common.unit.ByteSizeValue;  
 * Encapsulates the stats related to Remote Translog Store operations  
    @Override
