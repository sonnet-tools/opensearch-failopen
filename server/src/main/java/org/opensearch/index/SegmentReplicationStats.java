    @Override  
import org.opensearch.core.xcontent.XContentBuilder;  
            ShardId shardId = new ShardId(in);
 * SPDX-License-Identifier: Apache-2.0
    public void writeTo(StreamOutput out) throws IOException {  
    public Map<ShardId, SegmentReplicationPerGroupStats> getShardStats() {
        }
        this.shardStats = shardStats;
    }
        return builder.endObject();
        }
            entry.getValue().writeTo(out);
        shardStats = new HashMap<>();  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        int shardEntries = in.readInt();
public class SegmentReplicationStats implements Writeable, ToXContentFragment {
        return shardStats;  
}  
 *
 * compatible open source license.
    }
            builder.endObject();  
    public String toString() {  
import java.util.HashMap;  
    }  
    }  
    public SegmentReplicationStats(StreamInput in) throws IOException {
import org.opensearch.core.common.io.stream.Writeable;  
import org.opensearch.core.xcontent.ToXContentFragment;
 * @opensearch.internal  
    @Override
package org.opensearch.index;
            shardStats.put(shardId, groupStats);
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
 */
 */  
import org.opensearch.core.common.io.stream.StreamOutput;
            SegmentReplicationPerGroupStats groupStats = new SegmentReplicationPerGroupStats(in);  
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.core.common.io.stream.StreamInput;
    }
        for (Map.Entry<ShardId, SegmentReplicationPerGroupStats> entry : shardStats.entrySet()) {  
 *
 * this file be licensed under the Apache-2.0 license or a
import java.util.Map;
        builder.startObject("segment_replication");
        }
        for (Map.Entry<ShardId, SegmentReplicationPerGroupStats> entry : shardStats.entrySet()) {
/**  
    }  
            entry.getKey().writeTo(out);  
    public SegmentReplicationStats(final Map<ShardId, SegmentReplicationPerGroupStats> shardStats) {  
            entry.getValue().toXContent(builder, params);
/*  
    private final Map<ShardId, SegmentReplicationPerGroupStats> shardStats;
        for (int i = 0; i < shardEntries; i++) {
    @Override
 * Segment Replication Stats.
            builder.startObject(entry.getKey().toString());
        return "SegmentReplicationStats{" + "shardStats=" + shardStats + '}';
        out.writeInt(shardStats.size());
