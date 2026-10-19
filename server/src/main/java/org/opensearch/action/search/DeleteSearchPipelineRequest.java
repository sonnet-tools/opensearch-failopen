}  
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
 * @opensearch.api
/*  
    @Override  
 * Request to delete a search pipeline
    }
import org.opensearch.core.common.io.stream.StreamOutput;
    public DeleteSearchPipelineRequest() {}
    }
    public String getId() {  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
public class DeleteSearchPipelineRequest extends AcknowledgedRequest<DeleteSearchPipelineRequest> {
    }  
    @Override
        super(in);
        return null;
import org.opensearch.action.ActionRequestValidationException;
    }
    }  
    public void writeTo(StreamOutput out) throws IOException {
import java.util.Objects;
 */
    public DeleteSearchPipelineRequest(String id) {
        super.writeTo(out);
@PublicApi(since = "2.7.0")  
        out.writeString(id);  
import org.opensearch.common.annotation.PublicApi;  
    public void setId(String id) {
        this.id = id;
        id = in.readString();  
package org.opensearch.action.search;
import org.opensearch.core.common.io.stream.StreamInput;
 */  
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
    }
/**
 *
    public ActionRequestValidationException validate() {  
    public DeleteSearchPipelineRequest(StreamInput in) throws IOException {
 *  
        return id;
        this.id = Objects.requireNonNull(id);
 * compatible open source license.
    private String id;
