        return builder;  
        }
        replicationStats = in.readMapOfLists(StreamInput::readString, SegmentReplicationPerGroupStats::new);
        super.writeTo(out);
                    builder.endObject();
                for (SegmentReplicationPerGroupStats segmentReplicationState : segmentReplicationStates) {
                    continue;
    public Map<String, List<SegmentReplicationPerGroupStats>> getReplicationStats() {
import org.opensearch.action.support.broadcast.BroadcastResponse;
     * @param successfulShards        Count of shards successfully processed
    @Override  
    public void writeTo(StreamOutput out) throws IOException {
 */  
 * SPDX-License-Identifier: Apache-2.0
     * @param failedShards            Count of shards which failed to process
     * were seen, and out of those how many were successfully processed and how many failed.
                List<SegmentReplicationPerGroupStats> segmentReplicationStates = replicationStats.get(index);
        Map<String, List<SegmentReplicationPerGroupStats>> replicationStats,
 */
 * compatible open source license.
/**  
    }
        super(totalShards, successfulShards, failedShards, shardFailures);
            for (String index : replicationStats.keySet()) {
        builder.endObject();
    }
    public SegmentReplicationStatsResponse(StreamInput in) throws IOException {  
    ) {  
        int failedShards,  
                builder.endArray();
        builder.startObject();
        this.replicationStats = replicationStats;
        super(in);
                if (segmentReplicationStates == null || segmentReplicationStates.size() == 0) {  
        return replicationStats;  
    /**
import org.opensearch.core.common.io.stream.StreamInput;
                    builder.startObject();  
     * @param shardFailures           List of failures processing shards
 *
 * Stats Information regarding the Segment Replication state of indices and their associated shards.
 * The OpenSearch Contributors require contributions made to  
    }  
    public SegmentReplicationStatsResponse(  
 *
@PublicApi(since = "1.0.0")
        int successfulShards,
 * @opensearch.api  
     * Constructs segment replication stats information for a collection of indices and associated shards. Keeps track of how many total shards  
    }  
    @Override  
    public String toString() {
/*  
                builder.startArray("primary_stats");
        if (replicationStats.size() > 0) {  
        int totalShards,
import org.opensearch.index.SegmentReplicationPerGroupStats;  
import java.io.IOException;
                }  
    @Override  
}
                builder.startObject(index);  
     */
import org.opensearch.core.xcontent.MediaTypeRegistry;
        out.writeMapOfLists(replicationStats, StreamOutput::writeString, (o, v) -> v.writeTo(o));  
                builder.endObject();
        List<DefaultShardOperationFailedException> shardFailures
package org.opensearch.action.admin.indices.replication;
                    segmentReplicationState.toXContent(builder, params);
     * @param totalShards             Total count of shards seen  
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.common.io.stream.StreamOutput;  
     * @param replicationStats Map of indices to a list of {@link SegmentReplicationPerGroupStats}  
import org.opensearch.core.action.support.DefaultShardOperationFailedException;  
    }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.Strings;
import org.opensearch.common.annotation.PublicApi;
import java.util.Map;
    }  
import java.util.List;  
    private final Map<String, List<SegmentReplicationPerGroupStats>> replicationStats;
            }  
public class SegmentReplicationStatsResponse extends BroadcastResponse {  
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
                }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     *
