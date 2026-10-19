/**
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionRequest;
        if (index == null) {
        this.resetSettings = resetSettings;
        return resetSettings;  
    }
import org.opensearch.action.ActionRequestValidationException;
    private int[] shards;
 * <p> This is for internal use only and will not be exposed to the user. </p>
@PublicApi(since = "3.6.0")
    // Following will be optional parameters and will be used to decide when to update shard ingestion state if non-null values are provided
    }
    }  
        super();
    public String[] getIndex() {
    // Optional reset settings to be applied before resuming ingestion.
    @Override
    public UpdateIngestionStateRequest(String[] index, int[] shards) {  
            validationException = addValidationError("index is missing", validationException);  
    }  
    public Boolean getIngestionPaused() {
        super.writeTo(out);
public class UpdateIngestionStateRequest extends BroadcastRequest<UpdateIngestionStateRequest> {  
        return index;  
 */  
 * @opensearch.api  
        super(in);
package org.opensearch.action.admin.indices.streamingingestion.state;
    private Boolean ingestionPaused;  
        this.index = index;
    }  
 * The OpenSearch Contributors require contributions made to  
    }
 * SPDX-License-Identifier: Apache-2.0
        this.shards = shards;  
 * Holds metadata required for updating ingestion state.
    @Override
        }
        this.shards = shards;
        this.shards = in.readVIntArray();  
    }
    @Nullable  
import org.opensearch.core.common.io.stream.StreamOutput;
        ActionRequestValidationException validationException = null;
    public void setShards(int[] shards) {
        this.ingestionPaused = in.readOptionalBoolean();
        return ingestionPaused;  
/*  
        out.writeOptionalBoolean(ingestionPaused);
        this.ingestionPaused = ingestionPaused;
    private ResumeIngestionRequest.ResetSettings[] resetSettings;
    public ActionRequestValidationException validate() {  
 *
import java.io.IOException;  
    public ResumeIngestionRequest.ResetSettings[] getResetSettings() {
    public UpdateIngestionStateRequest(StreamInput in) throws IOException {  
    public void writeTo(StreamOutput out) throws IOException {  
import org.opensearch.common.annotation.PublicApi;
    public void setResetSettings(ResumeIngestionRequest.ResetSettings[] resetSettings) {  
 *  
    public int[] getShards() {  
import org.opensearch.common.Nullable;
        return shards;
    @Nullable
        out.writeOptionalArray(resetSettings);
 */
 *
    }
 * this file be licensed under the Apache-2.0 license or a
        this.index = in.readStringArray();
    }
        this.resetSettings = in.readOptionalArray(ResumeIngestionRequest.ResetSettings::new, ResumeIngestionRequest.ResetSettings[]::new);
        out.writeVIntArray(shards);  
        out.writeStringArray(index);
 * compatible open source license.
    public void setIngestionPaused(boolean ingestionPaused) {  
import org.opensearch.action.support.broadcast.BroadcastRequest;  
import static org.opensearch.action.ValidateActions.addValidationError;
}  
    }  
import org.opensearch.core.common.io.stream.StreamInput;  
        return validationException;
    @Nullable
    }
    private String[] index;
