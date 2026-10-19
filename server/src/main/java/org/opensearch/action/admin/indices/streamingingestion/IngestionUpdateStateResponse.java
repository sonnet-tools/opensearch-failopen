        }
}  
            for (Map.Entry<String, List<IngestionStateShardFailure>> indexShardFailures : shardFailuresByIndex.entrySet()) {  
    public String getErrorMessage() {  
        builder.field(SHARD_ACK, shardsAcknowledged);
        errorMessage = in.readString();
    protected IngestionStateShardFailure[] shardFailuresList;
 *
        return errorMessage;
                builder.startArray(indexShardFailures.getKey());
    public IngestionUpdateStateResponse(
        super.writeTo(out);
        if (Strings.isEmpty(errorMessage) == false) {  
        final IngestionStateShardFailure[] shardFailuresList,
    }  
    public IngestionStateShardFailure[] getShardFailures() {
        return shardsAcknowledged;
                shardFailuresList  
    }  
import org.opensearch.core.xcontent.XContentBuilder;
 * Transport response for ingestion state updates.
import org.opensearch.core.common.Strings;  
    public boolean isShardsAcknowledged() {
    protected static final String SHARD_ACK = "shards_acknowledged";
            }  
 */  
public class IngestionUpdateStateResponse extends AcknowledgedResponse {
        return shardFailuresList;  
    protected String errorMessage;
            builder.field(ERROR, errorMessage);
                for (IngestionStateShardFailure shardFailure : indexShardFailures.getValue()) {
        shardsAcknowledged = in.readBoolean();
    protected static final String ERROR = "error";  
    public void writeTo(StreamOutput out) throws IOException {  
                    shardFailure.toXContent(builder, params);  
 * SPDX-License-Identifier: Apache-2.0
        super(acknowledged);
        super(in);
/*  
import java.util.Map;
        shardFailuresList = in.readArray(IngestionStateShardFailure::new, IngestionStateShardFailure[]::new);  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
import org.opensearch.common.annotation.PublicApi;
        final boolean acknowledged,  
    protected boolean shardsAcknowledged;  
        }
    protected static final String FAILURES = "failures";
import org.opensearch.core.xcontent.MediaTypeRegistry;  
    }  
            );
    protected void addCustomFields(final XContentBuilder builder, final Params params) throws IOException {
        this.errorMessage = errorMessage;
 *  
 * compatible open source license.
        return Strings.toString(MediaTypeRegistry.JSON, this);
import org.opensearch.core.common.io.stream.StreamInput;
        out.writeString(errorMessage);  
 * @opensearch.api
        this.shardsAcknowledged = shardsAcknowledged;
            builder.startObject(FAILURES);
import java.io.IOException;  
        if (shardFailuresList.length > 0) {
        out.writeBoolean(shardsAcknowledged);
@PublicApi(since = "3.6.0")  
    @Override
    ) {
    }
    public String toString() {  
    }  
                builder.endArray();
 * The OpenSearch Contributors require contributions made to  
        out.writeArray(shardFailuresList);
    public IngestionUpdateStateResponse(StreamInput in) throws IOException {
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override
/**
import java.util.List;
package org.opensearch.action.admin.indices.streamingingestion;
    }
        String errorMessage  
 */
                }
 * this file be licensed under the Apache-2.0 license or a
    }
        final boolean shardsAcknowledged,
            Map<String, List<IngestionStateShardFailure>> shardFailuresByIndex = IngestionStateShardFailure.groupShardFailuresByIndex(
        super.addCustomFields(builder, params);  
        this.shardFailuresList = shardFailuresList;  
    @Override
            builder.endObject();
    }
