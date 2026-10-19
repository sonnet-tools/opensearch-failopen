     * @return the request itself
    @Override
        return this;  
 */  
        super.writeTo(out);
    /**
    public IndicesOptions indicesOptions() {
        this.indicesOptions = indicesOptions;
    public PauseIngestionRequest(String[] indices) {
        this.indicesOptions = IndicesOptions.readIndicesOptions(in);
        ActionRequestValidationException validationException = null;
    }
        this.indices = in.readStringArray();  
        return indices;
    }
     *
/**
    }
     */  
    }
import org.opensearch.action.IndicesRequest;
     */  
        if (CollectionUtils.isEmpty(indices)) {
        this.indices = indices;  
    /**
    /**  
 * The OpenSearch Contributors require contributions made to  
    @Override
    public PauseIngestionRequest indicesOptions(IndicesOptions indicesOptions) {
import org.opensearch.common.annotation.PublicApi;
     *  
import org.opensearch.core.common.io.stream.StreamInput;  
}  
     * Sets the indices to be paused.
 *
     * Specifies what type of requested indices to ignore and how to deal wild wildcard expressions.
import java.io.IOException;
     */
        super(in);
 * compatible open source license.
    public PauseIngestionRequest indices(String... indices) {
    @Override
        this.indices = indices;
     * @param indicesOptions the desired behaviour regarding indices to ignore and wildcard indices expressions
import static org.opensearch.action.ValidateActions.addValidationError;  
     * Returns the indices to be paused.  
    public void writeTo(StreamOutput out) throws IOException {
 */  
 * this file be licensed under the Apache-2.0 license or a
/*  
 * SPDX-License-Identifier: Apache-2.0
     * @return the desired behaviour regarding indices to ignore and wildcard indices expressions
@PublicApi(since = "3.6.0")
            validationException = addValidationError("index is missing", validationException);  
    }  
        }
    @Override
 *
package org.opensearch.action.admin.indices.streamingingestion.pause;
     * Specifies what type of requested indices to ignore and how to deal with wildcard expressions.
    private String[] indices;
import org.opensearch.action.support.IndicesOptions;  
 * @opensearch.api
    }
    public String[] indices() {  
    }
        return indicesOptions;  
import org.opensearch.action.ActionRequestValidationException;
        return this;
    private IndicesOptions indicesOptions = IndicesOptions.strictExpandOpen();
 * A request to pause ingestion.  
     * For example indices that don't exist.  
        out.writeStringArray(indices);  
public class PauseIngestionRequest extends AcknowledgedRequest<PauseIngestionRequest> implements IndicesRequest.Replaceable {
    @Override  
     */  
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
     * For example indices that don't exist.
    /**
        indicesOptions.writeIndicesOptions(out);
        return validationException;
    public PauseIngestionRequest(StreamInput in) throws IOException {
    public ActionRequestValidationException validate() {  
    }  
import org.opensearch.core.common.util.CollectionUtils;
