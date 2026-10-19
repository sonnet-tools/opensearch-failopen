    }
 *
import org.opensearch.core.common.io.stream.StreamInput;
        static final String SHARDS = "shards";
import org.opensearch.core.common.Strings;
    public String toString() {
        super(in);  
            builder.startObject(Fields.SHARDS);
import java.util.List;
                .add(shardStat);  
/**
        static final String INDICES = "indices";
    }  
    }
    }
    public Map<String, Map<Integer, List<RemoteStoreStats>>> groupByIndexAndShards() {
        Map<String, Map<Integer, List<RemoteStoreStats>>> indexWiseStats = groupByIndexAndShards();
 * this file be licensed under the Apache-2.0 license or a
        for (String indexName : indexWiseStats.keySet()) {  
        super.writeTo(out);
}
    @Override
 *  
 * compatible open source license.
        for (RemoteStoreStats shardStat : remoteStoreStats) {  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        builder.endObject();
@PublicApi(since = "2.8.0")  
    }  
package org.opensearch.action.admin.cluster.remotestore.stats;
        Map<String, Map<Integer, List<RemoteStoreStats>>> indexWiseStats = new HashMap<>();
import java.util.Map;
public class RemoteStoreStatsResponse extends BroadcastResponse {
 * Remote Store stats response
    public void writeTo(StreamOutput out) throws IOException {  
            for (int shardId : indexWiseStats.get(indexName).keySet()) {  
    @Override
 * SPDX-License-Identifier: Apache-2.0
 */
    @Override
        }
        super(totalShards, successfulShards, failedShards, shardFailures);
    public RemoteStoreStatsResponse(StreamInput in) throws IOException {
            builder.endObject();
        return this.remoteStoreStats;
import java.util.ArrayList;
        out.writeArray(remoteStoreStats);
 */  
        }  
        remoteStoreStats = in.readArray(RemoteStoreStats::new, RemoteStoreStats[]::new);
            builder.endObject();
/*  
                builder.startArray(Integer.toString(shardId));
                }
    }  
        List<DefaultShardOperationFailedException> shardFailures  
import java.io.IOException;
import org.opensearch.action.support.broadcast.BroadcastResponse;
                    shardStat.toXContent(builder, params);  
import java.util.HashMap;  
            indexWiseStats.computeIfAbsent(shardStat.getShardRouting().getIndexName(), k -> new HashMap<>())
    public RemoteStoreStatsResponse(
        return Strings.toString(MediaTypeRegistry.JSON, this, true, false);  
    protected void addCustomXContentFields(XContentBuilder builder, Params params) throws IOException {  
        this.remoteStoreStats = remoteStoreStats;  
        int failedShards,
import org.opensearch.core.xcontent.XContentBuilder;
                .computeIfAbsent(shardStat.getShardRouting().getId(), k -> new ArrayList<>())
            builder.startObject(indexName);
            }  
import org.opensearch.core.action.support.DefaultShardOperationFailedException;  
                for (RemoteStoreStats shardStat : indexWiseStats.get(indexName).get(shardId)) {
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.api
    public RemoteStoreStats[] getRemoteStoreStats() {  
        int totalShards,  
        int successfulShards,
        RemoteStoreStats[] remoteStoreStats,
    private final RemoteStoreStats[] remoteStoreStats;  
    }
        return indexWiseStats;
        builder.startObject(Fields.INDICES);
    }
import org.opensearch.core.common.io.stream.StreamOutput;  
import org.opensearch.common.annotation.PublicApi;
                builder.endArray();
    ) {
    static final class Fields {  
