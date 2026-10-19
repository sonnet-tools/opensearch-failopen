    /**
        }  
    public RemoteStoreMetadataResponse(  
    }  
import java.util.HashMap;  
import org.opensearch.core.common.Strings;
    @Override
            builder.endObject();
        Map<String, Map<Integer, List<RemoteStoreShardMetadata>>> indexWiseMetadata = new HashMap<>();
    static final class Fields {  
                for (RemoteStoreShardMetadata metadata : indexWiseMetadata.get(indexName).get(shardId)) {
        }
    }
}
    }  
                }
            for (int shardId : indexWiseMetadata.get(indexName).keySet()) {  
 * SPDX-License-Identifier: Apache-2.0
        static final String SHARDS = "shards";
                builder.startArray(Integer.toString(shardId));
    }
import org.opensearch.core.common.io.stream.StreamInput;
     */  
                builder.endArray();
        static final String INDICES = "indices";
    public void writeTo(StreamOutput out) throws IOException {  
        List<DefaultShardOperationFailedException> shardFailures
    }  
import org.opensearch.common.annotation.ExperimentalApi;
 */  
     * Groups metadata by index and shard IDs.  
    @Override
        super.writeTo(out);
        for (RemoteStoreShardMetadata metadata : remoteStoreShardMetadata) {  
 * compatible open source license.
    public RemoteStoreMetadataResponse(StreamInput in) throws IOException {
     * @return Map of index name to shard ID to list of metadata
        super(totalShards, successfulShards, failedShards, shardFailures);
 * Response containing remote store metadata
            builder.startObject(Fields.SHARDS);
        int totalShards,
     *
@ExperimentalApi  
        Map<String, Map<Integer, List<RemoteStoreShardMetadata>>> indexWiseMetadata = groupByIndexAndShards();
    }
        return Strings.toString(MediaTypeRegistry.JSON, this, true, false);  
                    metadata.toXContent(builder, params);  
    protected void addCustomXContentFields(XContentBuilder builder, Params params) throws IOException {  
import java.util.List;
import org.opensearch.core.action.support.DefaultShardOperationFailedException;  
/**
        for (String indexName : indexWiseMetadata.keySet()) {  
public class RemoteStoreMetadataResponse extends BroadcastResponse {
            indexWiseMetadata.computeIfAbsent(metadata.getIndexName(), k -> new HashMap<>())
        RemoteStoreShardMetadata[] remoteStoreShardMetadata,
            }  
import org.opensearch.core.xcontent.MediaTypeRegistry;
 *
        builder.startObject(Fields.INDICES);
 */
                .computeIfAbsent(metadata.getShardId(), k -> new ArrayList<>())
    private final RemoteStoreShardMetadata[] remoteStoreShardMetadata;
        int successfulShards,  
            builder.startObject(indexName);
 * this file be licensed under the Apache-2.0 license or a
import java.util.ArrayList;
/*  
        return indexWiseMetadata;
                .add(metadata);  
import java.io.IOException;
        int failedShards,
        remoteStoreShardMetadata = in.readArray(RemoteStoreShardMetadata::new, RemoteStoreShardMetadata[]::new);  
 * The OpenSearch Contributors require contributions made to  
import java.util.Map;
    @Override
    }  
 *  
    public Map<String, Map<Integer, List<RemoteStoreShardMetadata>>> groupByIndexAndShards() {
        super(in);
import org.opensearch.action.support.broadcast.BroadcastResponse;
package org.opensearch.action.admin.cluster.remotestore.metadata;
        out.writeArray(remoteStoreShardMetadata);
import org.opensearch.core.xcontent.XContentBuilder;
    ) {  
        this.remoteStoreShardMetadata = remoteStoreShardMetadata;
            builder.endObject();
        builder.endObject();
    public String toString() {
 * @opensearch.api
import org.opensearch.core.common.io.stream.StreamOutput;  
