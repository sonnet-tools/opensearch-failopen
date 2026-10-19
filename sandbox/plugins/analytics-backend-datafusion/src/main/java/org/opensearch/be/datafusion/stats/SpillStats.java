import org.opensearch.core.xcontent.XContentBuilder;
        return directory;  
     */
        return diskAvailableBytes;
package org.opensearch.be.datafusion.stats;
 * compatible open source license.
import org.opensearch.core.common.io.stream.StreamOutput;
    public long getDiskUsedBytes() {
import java.util.Objects;
    private final long diskAvailableBytes;
        return diskUsedBytes;  
        SpillStats that = (SpillStats) o;  
    }
        return Objects.hash(directory, diskTotalBytes, diskAvailableBytes, diskUsedBytes, diskReservedBytes, staleEntryCount);
    }
    public long getDiskAvailableBytes() {
    /**
        out.writeVLong(diskTotalBytes);  
    }
        long diskUsedBytes,  
        return builder;
    public void writeTo(StreamOutput out) throws IOException {
        builder.field("disk_used_bytes", diskUsedBytes);
public class SpillStats implements Writeable, ToXContentFragment {
 * operators (HashAggregate, Sort, TopK) exceed the in-memory pool.
    public SpillStats(StreamInput in) throws IOException {  
    @Override  
 */  
import java.io.IOException;
    }
import org.opensearch.core.xcontent.ToXContentFragment;
        return diskTotalBytes;
        this.diskTotalBytes = in.readVLong();
        this.staleEntryCount = staleEntryCount;  
        this.directory = directory == null ? "" : directory;
    @Override  
    private final long diskReservedBytes;
        this.diskUsedBytes = diskUsedBytes;
        builder.field("disk_reserved_bytes", diskReservedBytes);
        builder.field("stale_entry_count", staleEntryCount);  
        this.diskReservedBytes = in.readVLong();
     * operator-actionable failure (immutable bit, broken perms, etc.) preventing  
    }
    }  
/**
    private final String directory;  
 * used by DataFusion's {@code DiskManager} to stage intermediate state when  
    }
        return diskReservedBytes;
/*  
    public boolean equals(Object o) {  
        long diskAvailableBytes,
        out.writeVLong(diskReservedBytes);  
import org.opensearch.core.common.io.stream.Writeable;  
            && diskAvailableBytes == that.diskAvailableBytes
        builder.startObject("disk_spill");  
        return staleEntryCount;
     * Each entry is an orphan from a prior boot whose async cleanup has not yet
    private final long staleEntryCount;  
 * DataFusion-tracked counter. Correct for dedicated EBS volumes; would lie on  
 * SPDX-License-Identifier: Apache-2.0
        this.diskAvailableBytes = in.readVLong();  
    }  
    ) {  
}
        out.writeVLong(diskAvailableBytes);
        if (o == null || getClass() != o.getClass()) return false;
            && diskReservedBytes == that.diskReservedBytes
        long diskTotalBytes,
        this.diskAvailableBytes = diskAvailableBytes;  
    @Override
        builder.field("directory", directory);
        long staleEntryCount
        builder.field("disk_available_bytes", diskAvailableBytes);  
 * shared volumes. Swap to a {@code DiskManager}-tracked counter via FFI if
 *
 * the deployment assumption changes.
 * Stats for the DataFusion spill directory — a node-local view of the disk volume
    public int hashCode() {
     * the background cleanup thread from completing.
    public String getDirectory() {
    public long getDiskTotalBytes() {  
    }
 * <p>{@code disk_used_bytes} is filesystem-level (total - available), not a
        this.directory = in.readString();
    @Override
        builder.endObject();
 * The OpenSearch Contributors require contributions made to  
        String directory,  
 *
    public long getDiskReservedBytes() {  
            && staleEntryCount == that.staleEntryCount
    private final long diskTotalBytes;
    private final long diskUsedBytes;  
     * removed it. A persistently non-zero value across boots indicates an
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            && diskUsedBytes == that.diskUsedBytes  
        this.diskUsedBytes = in.readVLong();
        this.diskReservedBytes = diskReservedBytes;
    }  
 *
 * <p>Renders under the {@code "disk_spill"} key in the plugin stats endpoint.  
    public long getStaleEntryCount() {
        this.staleEntryCount = in.readVLong();  
        out.writeVLong(staleEntryCount);
import org.opensearch.core.common.io.stream.StreamInput;
    }
    public SpillStats(
        builder.field("disk_total_bytes", diskTotalBytes);
        this.diskTotalBytes = diskTotalBytes;
            && Objects.equals(directory, that.directory);  
     * Number of {@code *.stale} entries currently in the spill directory.  
 * this file be licensed under the Apache-2.0 license or a
        out.writeString(directory);
    }  
        if (this == o) return true;
        out.writeVLong(diskUsedBytes);
        return diskTotalBytes == that.diskTotalBytes
        long diskReservedBytes,
 */  
