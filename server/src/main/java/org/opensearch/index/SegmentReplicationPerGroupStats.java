 * compatible open source license.
        for (SegmentReplicationShardStats stats : replicaStats) {
}
        return replicaStats;
    }
    public void writeTo(StreamOutput out) throws IOException {  
    private final long rejectedRequestCount;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.api  
        out.writeVLong(rejectedRequestCount);  
        return builder;
    public SegmentReplicationPerGroupStats(StreamInput in) throws IOException {  
import org.opensearch.core.xcontent.ToXContentFragment;  
    }
 * Return Segment Replication stats for a Replication Group.
    }  
    @Override
    public String toString() {
        builder.startArray("replicas");  
        this.rejectedRequestCount = in.readVLong();  
    }
        return shardId;  
        builder.field("rejected_requests", rejectedRequestCount);
        this.shardId = shardId;
    private final Set<SegmentReplicationShardStats> replicaStats;  
import java.io.IOException;  
    }  
        return rejectedRequestCount;
    public Set<SegmentReplicationShardStats> getReplicaStats() {  
    public ShardId getShardId() {
@PublicApi(since = "2.7.0")
public class SegmentReplicationPerGroupStats implements Writeable, ToXContentFragment {  
package org.opensearch.index;
        this.replicaStats = in.readSet(SegmentReplicationShardStats::new);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.annotation.PublicApi;
        }  
/**  
        this.rejectedRequestCount = rejectedRequestCount;  
    private final ShardId shardId;
    }  
import org.opensearch.core.common.io.stream.StreamInput;
            stats.toXContent(builder, params);
    @Override  
        return "SegmentReplicationPerGroupStats{" + "replicaStats=" + replicaStats + ", rejectedRequestCount=" + rejectedRequestCount + '}';
    public long getRejectedRequestCount() {
        builder.endArray();
import java.util.Set;
/*  
 *
    @Override  
        this.shardId = new ShardId(in);
 *
import org.opensearch.core.xcontent.XContentBuilder;
 * The OpenSearch Contributors require contributions made to  
        this.replicaStats = replicaStats;
 */  
    public SegmentReplicationPerGroupStats(ShardId shardId, Set<SegmentReplicationShardStats> replicaStats, long rejectedRequestCount) {  
        out.writeCollection(replicaStats);
        shardId.writeTo(out);
import org.opensearch.core.common.io.stream.Writeable;
import org.opensearch.core.index.shard.ShardId;
 */
import org.opensearch.core.common.io.stream.StreamOutput;  
    }
