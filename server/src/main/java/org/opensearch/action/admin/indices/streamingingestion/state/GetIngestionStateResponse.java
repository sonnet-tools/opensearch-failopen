@PublicApi(since = "3.6.0")  
    @Override
        builder.endObject();  
import java.util.Comparator;  
            }
            builder.field(NEXT_PAGE_TOKEN, nextPageToken);  
        Map<String, List<ShardIngestionState>> shardStateByIndex = ShardIngestionState.groupShardStateByIndex(shardStates);  
import java.util.Map;
import org.opensearch.core.common.io.stream.StreamOutput;
        super(totalShards, successfulShards, failedShards, shardFailures);
    }
                shardIngestionState.toXContent(builder, params);
        out.writeArray(shardStates);
    private static final String INGESTION_STATE = "ingestion_state";
        this.shardStates = shardStates;  
        super(in);
/**
        this.nextPageToken = nextPageToken;
    ) {
        int failedShards,
/*  
 * @opensearch.api
        }
    }
import org.opensearch.core.xcontent.XContentBuilder;  
        nextPageToken = in.readOptionalString();  
        @Nullable String nextPageToken,
 */  
    }  
            for (ShardIngestionState shardIngestionState : indexShardIngestionStateEntry.getValue()) {  
 *
        int successfulShards,  
    public GetIngestionStateResponse(  
    private static final String NEXT_PAGE_TOKEN = "next_page_token";  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.action.admin.indices.streamingingestion.state;
        if (Strings.isEmpty(nextPageToken) == false) {
        out.writeOptionalString(nextPageToken);
import org.opensearch.core.common.Strings;
    }
        return Strings.toString(MediaTypeRegistry.JSON, this, true, false);  
    @Override
        this.nextPageToken = nextPageToken;
        return nextPageToken;
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
    }  
import java.io.IOException;
 */
    }
        }
import org.opensearch.common.annotation.PublicApi;  
    @Nullable  
            builder.startArray(indexShardIngestionStateEntry.getKey());
 * this file be licensed under the Apache-2.0 license or a
            indexShardIngestionStateEntry.getValue().sort(Comparator.comparingInt(ShardIngestionState::getShardId));
            builder.endArray();  
    public void setNextPageToken(String nextPageToken) {  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        shardStates = in.readArray(ShardIngestionState::new, ShardIngestionState[]::new);
        ShardIngestionState[] shardStates,
        for (Map.Entry<String, List<ShardIngestionState>> indexShardIngestionStateEntry : shardStateByIndex.entrySet()) {  
    private String nextPageToken;
 * Transport response for retrieving ingestion state.
import org.opensearch.action.support.broadcast.BroadcastResponse;
    protected void addCustomXContentFields(XContentBuilder builder, Params params) throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
    }
        builder.startObject(INGESTION_STATE);
import org.opensearch.common.Nullable;
    public ShardIngestionState[] getShardStates() {  
}
    @Override
 * compatible open source license.
    public GetIngestionStateResponse(StreamInput in) throws IOException {  
import org.opensearch.core.common.io.stream.StreamInput;  
        return shardStates;
 *  
    public String toString() {
        List<DefaultShardOperationFailedException> shardFailures  
public class GetIngestionStateResponse extends BroadcastResponse {
    public void writeTo(StreamOutput out) throws IOException {
import java.util.List;
        super.addCustomXContentFields(builder, params);
    public String getNextPageToken() {
        super.writeTo(out);  
    private ShardIngestionState[] shardStates;
    }
        int totalShards,
