 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.xcontent.XContentBuilder;  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 */  
import java.util.List;
import org.opensearch.common.annotation.PublicApi;
    public static Map<String, List<IngestionStateShardFailure>> groupShardFailuresByIndex(IngestionStateShardFailure[] shardFailures) {
    }
import java.util.ArrayList;  
        out.writeString(index);
 * compatible open source license.
    @Override  
    }
/*  
 */  
 * this file be licensed under the Apache-2.0 license or a
    /**
        builder.startObject();
        }
        return builder.endObject();
import java.util.HashMap;
import org.opensearch.core.xcontent.ToXContentFragment;
        for (IngestionStateShardFailure shardFailure : shardFailures) {
    public IngestionStateShardFailure(StreamInput in) throws IOException {
package org.opensearch.action.admin.indices.streamingingestion;
    private static final String ERROR = "error";
@PublicApi(since = "3.6.0")
            shardFailuresByIndex.get(shardFailure.index()).add(shardFailure);
 *
        out.writeString(errorMessage);  
        return shardFailuresByIndex;
        builder.field(ERROR, errorMessage);
}  
        Map<String, List<IngestionStateShardFailure>> shardFailuresByIndex = new HashMap<>();  
import org.opensearch.core.common.io.stream.StreamOutput;  
 * @opensearch.api
        builder.field(SHARD, shard);  
    }  
/**
            shardFailuresByIndex.computeIfAbsent(shardFailure.index(), (index) -> new ArrayList<>());  
        out.writeVInt(shard);
 * Indicates ingestion failures at index and shard level.  
    public void writeTo(StreamOutput out) throws IOException {  
public record IngestionStateShardFailure(String index, int shard, String errorMessage) implements Writeable, ToXContentFragment {
import java.util.Map;  
        this(in.readString(), in.readVInt(), in.readString());
import org.opensearch.core.common.io.stream.Writeable;
import org.opensearch.core.common.io.stream.StreamInput;
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
    }  
     * Groups provided shard ingestion state failures by index name.  
     */
    private static final String SHARD = "shard";
    @Override
 *
