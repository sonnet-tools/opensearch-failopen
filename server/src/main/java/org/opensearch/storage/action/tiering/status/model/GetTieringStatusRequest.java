    }
    }
     */
     * @param isDetailedFlagEnabled whether detailed info is enabled
            validationException = addValidationError("index is missing", validationException);
        this.index = index;
    }  
    /**
        return isDetailedFlagEnabled;
     * @param index the index name  
    public GetTieringStatusRequest(String index) {
        ActionRequestValidationException validationException = null;  
 */  
}
    public Boolean getDetailedFlag() {
    public void setIndex(String index) {  
    public GetTieringStatusRequest(StreamInput in) throws IOException {
public class GetTieringStatusRequest extends ClusterManagerNodeReadRequest<GetTieringStatusRequest> {
/**
     */
    @Override
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadRequest;
    }
 * The OpenSearch Contributors require contributions made to  
     * Constructs a request for the given index.
        if (index == null) {
     */  
    public ActionRequestValidationException validate() {
    }
        super.writeTo(out);  
        }  
    /**
        isDetailedFlagEnabled = in.readBoolean();
     * Constructs a request for the given index with detailed flag.
     * @param index the index name  
     * @param detailedFlagEnabled the flag value
    }  
package org.opensearch.storage.action.tiering.status.model;
    private Boolean isDetailedFlagEnabled;
     * Sets the index name.  
        this.index = index;
     * @param in the stream input
 * SPDX-License-Identifier: Apache-2.0
        return validationException;
import org.opensearch.core.common.io.stream.StreamInput;  
     */
        out.writeBoolean(isDetailedFlagEnabled);
import org.opensearch.action.ActionRequestValidationException;
        out.writeString(index);
     * @param index the index name
        this.isDetailedFlagEnabled = isDetailedFlagEnabled;
    /**
    private String index;  
    }  
    public String getIndex() {
        super(in);
     * Sets the detailed flag.  
 * Migration status request for a single index.
    public GetTieringStatusRequest() {}
        isDetailedFlagEnabled = detailedFlagEnabled;
 *
    }
     * @throws IOException if an I/O error occurs
        index = in.readString();  
        this.index = index;  
    public void writeTo(StreamOutput out) throws IOException {
    }
 */  
import java.io.IOException;  
        this.isDetailedFlagEnabled = false;
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
    public GetTieringStatusRequest(String index, Boolean isDetailedFlagEnabled) {  
     * Constructs a request from a stream.  
    /** Returns the detailed flag. */  
     */
    public void setDetailedFlagEnabled(Boolean detailedFlagEnabled) {  
    /**
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override
import static org.opensearch.action.ValidateActions.addValidationError;
    /** Constructs a default request. */
    /**
    /** Returns the index name. */
        return index;  
/*  
