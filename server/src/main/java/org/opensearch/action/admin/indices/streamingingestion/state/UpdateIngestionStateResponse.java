/*  
        out.writeArray(shardFailureList);
 *
import java.util.List;  
    public UpdateIngestionStateResponse(  
    private final IngestionStateShardFailure[] shardFailureList;  
    private String errorMessage = "";
    }
 * this file be licensed under the Apache-2.0 license or a
    public UpdateIngestionStateResponse(StreamInput in) throws IOException {
        super(in);  
        out.writeBoolean(acknowledged);  
    public IngestionStateShardFailure[] getShardFailureList() {
        List<DefaultShardOperationFailedException> shardFailures
        int totalShards,
    public void setErrorMessage(String errorMessage) {
    public void writeTo(StreamOutput out) throws IOException {
        return errorMessage;
    @Override  
 * The OpenSearch Contributors require contributions made to  
    }  
        errorMessage = in.readString();
    }
public class UpdateIngestionStateResponse extends BroadcastResponse {
        out.writeString(errorMessage);
 */  
 */  
 * compatible open source license.
 * @opensearch.api
        this.errorMessage = errorMessage;  
        int failedShards,
    public String getErrorMessage() {
 *
import java.io.IOException;
        super.writeTo(out);
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.action.admin.indices.streamingingestion.state;
import org.opensearch.common.annotation.PublicApi;  
        shardFailureList = in.readArray(IngestionStateShardFailure::new, IngestionStateShardFailure[]::new);  
    public boolean isAcknowledged() {  
import org.opensearch.core.common.io.stream.StreamInput;
    ) {  
import org.opensearch.action.support.broadcast.BroadcastResponse;
            .toArray(IngestionStateShardFailure[]::new);
        int successfulShards,  
        super(totalShards, successfulShards, failedShards, shardFailures);
    }
            .map(shardFailure -> new IngestionStateShardFailure(shardFailure.index(), shardFailure.shardId(), shardFailure.reason()))
 * Transport response for updating ingestion state.  
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
        return shardFailureList;  
        this.shardFailureList = shardFailures.stream()  
        return acknowledged;
    private boolean acknowledged;
/**
        boolean acknowledged,
        this.acknowledged = acknowledged;
import org.opensearch.core.common.io.stream.StreamOutput;  
    }
        acknowledged = in.readBoolean();
@PublicApi(since = "3.6.0")
    }
import org.opensearch.action.admin.indices.streamingingestion.IngestionStateShardFailure;
}
    }  
