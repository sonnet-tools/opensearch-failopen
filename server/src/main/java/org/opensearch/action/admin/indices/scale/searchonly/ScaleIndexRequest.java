     *
    public int hashCode() {
     */
 *   <li>Scale an index down to search-only mode, removing write capability while preserving search replicas</li>
    public boolean isScaleDown() {
 * The OpenSearch Contributors require contributions made to  
     * Ensures that the index name is provided and not empty.  
     *
    }
     * @param out the output stream to write to
     *
        if (this == o) return true;
        return indicesOptions;  
        return Objects.hash(index, scaleDown, indicesOptions);  
    /**  
import java.io.IOException;
     *
    }
     */
     */
     * @throws IOException if there is an I/O error during serialization
     *
        this.scaleDown = scaleDown;
        return scaleDown == that.scaleDown && Objects.equals(index, that.index) && Objects.equals(indicesOptions, that.indicesOptions);
     */
     */  
     *
    private final String index;
    /**  
     * Validates this request.
     * @param scaleDown true to scale down to search-only mode, false to scale up to normal operation  
 *
     * @return this request (for method chaining)
     * @return true if equal, false otherwise
     */  
     * @return validation exception if invalid, null otherwise
    /**
     * @param indicesOptions the indices options to use  
     * Serializes this request to the given output stream.
 * A request for search-only scale operations (up or down) on an index.  
     * @param o the object to compare with  
     * @return the indices options  
    /**
     * Returns a hash code for this request.  
import java.util.Objects;  
    @Override
        this.indicesOptions = IndicesOptions.readIndicesOptions(in);  
        out.writeBoolean(scaleDown);
class ScaleIndexRequest extends AcknowledgedRequest<ScaleIndexRequest> {  
     *
     *  
     * @throws IOException if there is an I/O error during deserialization  
     *
     */
     * @return this request (for method chaining)  
 * The request is processed by the cluster manager node, which coordinates the necessary
package org.opensearch.action.admin.indices.scale.searchonly;
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
        if (index == null || index.trim().isEmpty()) {
    }
     * @return the hash code
     */
        super();  
    public IndicesOptions indicesOptions() {
    }
     * @return true if scaling down to search-only mode, false if scaling up to normal operation  
 * an index between normal and search-only states.
    }  
    }
        this.index = in.readString();
        this.scaleDown = scaleDown;  
        if (o == null || getClass() != o.getClass()) return false;  
 * this file be licensed under the Apache-2.0 license or a
        return validationException;
    public boolean equals(Object o) {
    }
     * Returns whether this is a scale-down operation.
    private boolean scaleDown;
    ScaleIndexRequest(String index, boolean scaleDown) {
     * @param scaleDown true if scaling down, false if scaling up
    }
    @Override
        super(in);  
     * Sets the indices options for this request.
     * Checks if this request equals another object.
     * Returns the indices options that specify how to resolve indices and handle unavailable indices.
     * @return the index name  
     */
     * @param in the stream input to read from
            validationException = ValidateActions.addValidationError("index is required", validationException);
 *   <li>Scale an index up from search-only mode back to full read-write operation</li>
    /**
        ScaleIndexRequest that = (ScaleIndexRequest) o;
import org.opensearch.action.support.IndicesOptions;  
    private IndicesOptions indicesOptions = IndicesOptions.strictExpandOpen();  
        return index;  
    /**  
     * <p>
 * compatible open source license.
        return scaleDown;  
        this.indicesOptions = indicesOptions;
    public void writeTo(StreamOutput out) throws IOException {
     *
     * Returns the name of the index to scale.
    ScaleIndexRequest(StreamInput in) throws IOException {
    /**  
import org.opensearch.action.ActionRequestValidationException;
    /**  
 * <p>
import org.opensearch.core.common.io.stream.StreamOutput;  
        return this;
 * <p>
import org.opensearch.core.common.io.stream.StreamInput;
 * This request represents an administrative operation to either:
    }  
    /**
        return this;
 * SPDX-License-Identifier: Apache-2.0
    public ScaleIndexRequest scaleDown(boolean scaleDown) {
 */  
/*  
    /**
        out.writeString(index);
    public ActionRequestValidationException validate() {
    @Override  
     * Sets whether this is a scale down operation.  
/**
     * Deserialization constructor.  
        super.writeTo(out);  
    }  
 */
        }  
        indicesOptions.writeIndicesOptions(out);  
     */
     * @param index     the name of the index to scale
import org.opensearch.action.ValidateActions;
    public String getIndex() {
    @Override
    public ScaleIndexRequest indicesOptions(IndicesOptions indicesOptions) {  
        this.scaleDown = in.readBoolean();
     */  
 * <ul>  
        ActionRequestValidationException validationException = null;  
}  
     *
    }
 * </ul>  
        this.index = index;
    /**  
     * Constructs a new SearchOnlyRequest.  
 * cluster state changes, shard synchronization, and recovery operations needed to transition  
