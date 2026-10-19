    }  
    }
    /** Default constructor for stream deserialization. */
    /**
        ActionRequestValidationException validationException = null;
    private String index;  
        return Objects.hash(index);  
    }  
 */  
    /**
        if (o == null || getClass() != o.getClass()) return false;
        if (index == null || index.isBlank()) {
    /**
package org.opensearch.storage.action.tiering;
/*  
     * @param in the stream input  
    public void writeTo(StreamOutput out) throws IOException {  
        super.writeTo(out);
     * Gets the index name for which to cancel tiering.  
     * @param index the index name
            validationException = addValidationError("Index name cannot be null or empty", validationException);  
     * Constructs a request from a stream.
import org.opensearch.core.common.io.stream.StreamInput;  
        return index;
     * Sets the index name for which to cancel tiering.  
    }
    @Override
        }
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
    public CancelTieringRequest(StreamInput in) throws IOException {  
     */
    }
 * Request to cancel an ongoing tiering operation for an index.  
        this.index = index;
import static org.opensearch.action.ValidateActions.addValidationError;  
     * Constructs a request for the given index.
     * @return the index name
import org.opensearch.core.common.io.stream.StreamOutput;
        super(in);
import java.io.IOException;  
     * @throws IOException if an I/O error occurs
 * this file be licensed under the Apache-2.0 license or a
     *
 * This request contains the index name and necessary parameters to safely
        return "CancelTieringRequest{" + "index='" + index + '\'' + '}';
    @Override  
        super();  
 * The OpenSearch Contributors require contributions made to  
 * cancel migrations that may be stuck in RUNNING_SHARD_RELOCATION state.
    public CancelTieringRequest() {  
 */  
    }  
    @Override
 * compatible open source license.
    public String getIndex() {
        CancelTieringRequest that = (CancelTieringRequest) o;  
    public boolean equals(Object o) {  
     */
}
        if (this == o) return true;
    public void setIndex(String index) {
    }
    /**
    }  
    public CancelTieringRequest(final String index) {
     * @param index the index name  
        this.index = in.readString();
    public ActionRequestValidationException validate() {  
        out.writeString(index);
    @Override
import java.util.Objects;
     */  
        return validationException;
    }  
        this.index = index;
    @Override
import org.opensearch.action.ActionRequestValidationException;
    }  
     */  
        return Objects.equals(index, that.index);
 *
/**
    public int hashCode() {
    public String toString() {
        super();
 * SPDX-License-Identifier: Apache-2.0
public class CancelTieringRequest extends AcknowledgedRequest<CancelTieringRequest> {
     *
