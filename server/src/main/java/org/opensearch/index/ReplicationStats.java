            maxBytesBehind = Math.max(other.maxBytesBehind, maxBytesBehind);  
 * this file be licensed under the Apache-2.0 license or a
        builder.field(Fields.MAX_BYTES_BEHIND, maxBytesBehind);
}
 * The OpenSearch Contributors require contributions made to  
        out.writeVLong(maxBytesBehind);
    }  
 *
import org.opensearch.core.common.io.stream.Writeable;
    public long maxReplicationLag;
    public static ReplicationStats empty() {
        static final String MAX_REPLICATION_LAG = "max_replication_lag";
 * @opensearch.api
        builder.startObject(Fields.SEGMENT_REPLICATION);  
 * node and cluster level on a segment replication enabled cluster.  
        builder.field(Fields.TOTAL_BYTES_BEHIND, totalBytesBehind);
    public long maxBytesBehind;
    }
import org.opensearch.core.common.io.stream.StreamInput;
        return this.maxReplicationLag;  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
@PublicApi(since = "2.10.0")
 *
    static final class Fields {
 */  
        return new ReplicationStats();  
public class ReplicationStats implements ToXContentFragment, Writeable {
     */  
    /**
package org.opensearch.index;
    public ReplicationStats(StreamInput in) throws IOException {
     *
        static final String SEGMENT_REPLICATION = "segment_replication";
    }  
        this.totalBytesBehind = totalBytesBehind;
        static final String MAX_BYTES_BEHIND = "max_bytes_behind";  
    }  
    }
    }  
        this.maxReplicationLag = maxReplicationLag;
    public void writeTo(StreamOutput out) throws IOException {
    public long getTotalBytesBehind() {
import org.opensearch.core.xcontent.ToXContentFragment;
import org.opensearch.core.common.io.stream.StreamOutput;  
    }
/**
    }  
    @Override
/*  
import java.io.IOException;
 * ReplicationStats is used to provide segment replication statistics at an index,
        out.writeVLong(totalBytesBehind);  
    public long getMaxReplicationLag() {
    }
        builder.endObject();
        this.maxReplicationLag = in.readVLong();
        return this.maxBytesBehind;
        return this.totalBytesBehind;
    public void add(ReplicationStats other) {
 */  
        this.maxBytesBehind = in.readVLong();  
    public long totalBytesBehind;  
        return builder;
            maxReplicationLag = Math.max(other.maxReplicationLag, maxReplicationLag);
        this.maxBytesBehind = maxBytesBehind;  
    }
 * compatible open source license.
    @Override  
            totalBytesBehind += other.totalBytesBehind;
        static final String TOTAL_BYTES_BEHIND = "total_bytes_behind";
        out.writeVLong(maxReplicationLag);
    public ReplicationStats() {  
import org.opensearch.common.annotation.PublicApi;
     * @opensearch.internal
    public ReplicationStats(long maxBytesBehind, long totalBytesBehind, long maxReplicationLag) {
        this.totalBytesBehind = in.readVLong();
        if (other != null) {
import org.opensearch.core.xcontent.XContentBuilder;  
    public long getMaxBytesBehind() {  
        builder.field(Fields.MAX_REPLICATION_LAG, maxReplicationLag);  
    }
        }  
     * Fields for segment replication statistics  
