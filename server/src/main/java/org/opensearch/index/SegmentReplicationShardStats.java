            + bytesBehindCount
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
 * compatible open source license.
        return builder;
public class SegmentReplicationShardStats implements Writeable, ToXContentFragment {
        out.writeVLong(lastCompletedReplicationTimeMillis);
        this.currentReplicationState = currentReplicationState;  
 * SegRep stats for a single shard.  
        out.writeVLong(currentReplicationLagMillis);  
 *
        long lastCompletedReplicationTime
     * @return lastCompletedReplicationTimeMillis
 * this file be licensed under the Apache-2.0 license or a
    public SegmentReplicationShardStats(StreamInput in) throws IOException {
import java.io.IOException;  
        return lastCompletedReplicationTimeMillis;
    }  
        long bytesBehindCount,
        this.bytesBehindCount = in.readVLong();
            + ", currentReplicationTimeMillis="
    }  
        return currentReplicationLagMillis;
    public long getCheckpointsBehindCount() {  
        this.currentReplicationTimeMillis = currentReplicationTimeMillis;  
@PublicApi(since = "2.7.0")
            builder.startObject();  
    // Total time taken for replicas to catch up. Similar to replication lag except this
    private final String allocationId;  
    @Override  
        String allocationId,
            currentReplicationState.toXContent(builder, params);
        if (currentReplicationState != null) {
/**
     * primary to upload data to remote store.
 *
    }
    }  
        return currentReplicationTimeMillis;  
        builder.startObject();
        }  
        this.allocationId = in.readString();  
        return bytesBehindCount;
     * @return currentReplicationLagMillis
    public void writeTo(StreamOutput out) throws IOException {  
import org.opensearch.common.annotation.PublicApi;
    public long getBytesBehindCount() {
        builder.endObject();
    // doesn't include time taken by primary to upload data to remote store.  
        out.writeVLong(checkpointsBehindCount);
        builder.field("current_replication_time", new TimeValue(currentReplicationTimeMillis));
        return currentReplicationState;
    private final long bytesBehindCount;
        return allocationId;  
    public String toString() {
    public String getAllocationId() {
    }
    private final long currentReplicationLagMillis;
        long currentReplicationTimeMillis,
        this.checkpointsBehindCount = in.readVLong();
            builder.endObject();
    public void setCurrentReplicationState(SegmentReplicationState currentReplicationState) {
            + lastCompletedReplicationTimeMillis
        this.currentReplicationTimeMillis = in.readVLong();  
            + currentReplicationLagMillis
            + allocationId
            + currentReplicationState
    ) {
    private final long currentReplicationTimeMillis;
        out.writeVLong(currentReplicationTimeMillis);
        return checkpointsBehindCount;
            + currentReplicationTimeMillis  
    public long getCurrentReplicationTimeMillis() {
package org.opensearch.index;
            + ", currentReplicationState="  
        builder.field("last_completed_replication_time", new TimeValue(lastCompletedReplicationTimeMillis));
            + ", checkpointsBehindCount="
import org.opensearch.core.common.io.stream.StreamOutput;
    /**  
     * Total time taken for replicas to catch up. Similar to replication lag except this doesn't include time taken by  
        this.currentReplicationLagMillis = currentReplicationLagMillis;
        this.lastCompletedReplicationTimeMillis = lastCompletedReplicationTime;
    private final long checkpointsBehindCount;
        builder.field("checkpoints_behind", checkpointsBehindCount);  
        builder.field("bytes_behind", new ByteSizeValue(bytesBehindCount).toString());
    }  
     */  
        builder.field("allocation_id", allocationId);
import org.opensearch.core.common.unit.ByteSizeValue;
            + ", bytesBehindCount="
    public long getCurrentReplicationLagMillis() {
    }  
    private SegmentReplicationState currentReplicationState;
    }  
 * @opensearch.api
    public SegmentReplicationState getCurrentReplicationState() {
import org.opensearch.common.Nullable;
            + '}';
import org.opensearch.core.common.io.stream.Writeable;  
 * The OpenSearch Contributors require contributions made to  
     */  
            + ", lastCompletedReplicationTimeMillis="
    @Nullable  
        this.currentReplicationLagMillis = in.readVLong();
        this.lastCompletedReplicationTimeMillis = in.readVLong();
import org.opensearch.indices.replication.SegmentReplicationState;
    @Override
    }  
    }
        this.allocationId = allocationId;  
        return "SegmentReplicationShardStats{"
        this.bytesBehindCount = bytesBehindCount;
    }
    // Total Replication lag observed.  
    private final long lastCompletedReplicationTimeMillis;
import org.opensearch.common.unit.TimeValue;  
     * Total Replication lag observed.
 */  
import org.opensearch.core.xcontent.ToXContentFragment;
        out.writeVLong(bytesBehindCount);  
 */  
    }
            + checkpointsBehindCount  
        long currentReplicationLagMillis,  
    /**
            + ", currentReplicationLagMillis="  
    }  
 * SPDX-License-Identifier: Apache-2.0
    public long getLastCompletedReplicationTimeMillis() {
import org.opensearch.core.common.io.stream.StreamInput;
/*  
    public SegmentReplicationShardStats(
        this.checkpointsBehindCount = checkpointsBehindCount;
}
    @Nullable
            + "allocationId="  
        out.writeString(allocationId);
    @Override
        long checkpointsBehindCount,  
import org.opensearch.core.xcontent.XContentBuilder;  
        builder.field("current_replication_lag", new TimeValue(currentReplicationLagMillis));  
