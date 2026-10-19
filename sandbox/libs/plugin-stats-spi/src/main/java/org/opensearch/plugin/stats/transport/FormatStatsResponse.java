    }
    }  
import java.util.HashMap;  
import org.opensearch.core.common.io.stream.StreamInput;
        this.reader = reader;
                if (r.stats() == null) continue;  
            if (shardLevel) {
import org.opensearch.common.annotation.ExperimentalApi;
 *  
        List<DefaultShardOperationFailedException> shardFailures  
        int successfulShards,
 *
    private final Writeable.Reader<T> reader;  
        String formatName,  
            b.endObject();  
    @Override
 */  
                for (var r : entry.getValue()) {
        for (var r : shardResults) {  
                        b.field("state", r.shardRouting().state().toString());  
            }
 * @opensearch.experimental
    }  
        super(totalShards, successfulShards, failedShards, shardFailures);
import org.opensearch.plugin.stats.DataFormatShardStats;
        this.formatName = in.readString();  
@ExperimentalApi  
package org.opensearch.plugin.stats.transport;
        }
/*  
            shardResults.add(new FormatStatsShardResult<>(in, reader));
}
import java.util.Map;
                        b.field("primary", r.shardRouting().primary());
    private final String formatName;
                        b.field("relocating_node", r.shardRouting().relocatingNodeId());  
import org.opensearch.action.support.broadcast.BroadcastResponse;
            result.writeTo(out);
    public FormatStatsResponse(StreamInput in, Writeable.Reader<T> reader) throws IOException {  
        super(in);
 * SPDX-License-Identifier: Apache-2.0
    public FormatStatsResponse(
    protected void addCustomXContentFields(XContentBuilder b, Params p) throws IOException {  
                agg = (agg == null) ? r.stats() : agg.add(r.stats());
        b.endObject();
    ) {
                    b.startArray(String.valueOf(s.getKey()));
            byIndex.computeIfAbsent(r.shardRouting().getIndexName(), k -> new ArrayList<>()).add(r);
    @Override  
                        b.endObject();  
 * this file be licensed under the Apache-2.0 license or a
        this.reader = null;  
import java.util.TreeMap;  
                }  
                    for (var r : s.getValue()) {  
import org.opensearch.core.xcontent.XContentBuilder;
                b.endObject();
                        b.startObject("routing");
            // format-owned aggregation via T.add()  
        }  
        b.startObject("indices");  
        int failedShards,
import org.opensearch.core.action.support.DefaultShardOperationFailedException;  
    private final List<FormatStatsShardResult<T>> shardResults;  
 */
import java.util.ArrayList;
                for (var s : byShard.entrySet()) {
                }  
        for (FormatStatsShardResult<T> result : shardResults) {  
 * Response for per-format index-level stats with format-owned aggregation.  
        for (var entry : byIndex.entrySet()) {
/**
        this.shardResults = new ArrayList<>(size);  
    public void writeTo(StreamOutput out) throws IOException {
        for (int i = 0; i < size; i++) {
        this.shardLevel = in.readBoolean();
        int size = in.readVInt();
            for (var r : entry.getValue()) {
import org.opensearch.core.common.io.stream.StreamOutput;
                        if (r.stats() != null) r.stats().toXContent(b, p);
 * The OpenSearch Contributors require contributions made to  
public class FormatStatsResponse<T extends DataFormatShardStats<T>> extends BroadcastResponse {
            if (agg != null) agg.toXContent(b, p);  
 * compatible open source license.
                        b.endObject();
import java.util.List;
        }
                    }
        List<FormatStatsShardResult<T>> shardResults,
        Map<String, List<FormatStatsShardResult<T>>> byIndex = new HashMap<>();
        int totalShards,  
        b.field("format", formatName);
        this.shardLevel = shardLevel;
import org.opensearch.core.common.io.stream.Writeable;  
 *
                        b.field("node", r.shardRouting().currentNodeId());
    private final boolean shardLevel;
    }
        this.shardResults = shardResults;
        out.writeVInt(shardResults.size());
                    byShard.computeIfAbsent(r.shardRouting().shardId().id(), k -> new ArrayList<>()).add(r);
import java.io.IOException;
                Map<Integer, List<FormatStatsShardResult<T>>> byShard = new TreeMap<>();  
            T agg = null;
        out.writeString(formatName);  
                        b.startObject();
                    b.endArray();
        boolean shardLevel,
        }
        super.writeTo(out);
        out.writeBoolean(shardLevel);
 * @param <T> concrete shard-stats type
            }
            b.startObject(entry.getKey());
        this.formatName = formatName;  
                b.startObject("shards");
