        return name;
    }  
/**
    /**
    }
     * @param name - name for the WorkloadGroup to get  
    public DeleteWorkloadGroupRequest(StreamInput in) throws IOException {
     * Name getter
 */  
        return null;
 * compatible open source license.
 * @opensearch.experimental
 *
    public DeleteWorkloadGroupRequest(String name) {
            actionRequestValidationException.addValidationError("WorkloadGroup name is missing");
}
     * @param in - A {@link StreamInput} object
     * Constructor for DeleteWorkloadGroupRequest
        }  
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
     * Default constructor for DeleteWorkloadGroupRequest
    @Override  
    public ActionRequestValidationException validate() {
    @Override
            ActionRequestValidationException actionRequestValidationException = new ActionRequestValidationException();  
    }
import org.opensearch.core.common.io.stream.StreamOutput;
 */  
    /**  
import org.opensearch.action.ActionRequestValidationException;
package org.opensearch.plugin.wlm.action;
        super(in);
public class DeleteWorkloadGroupRequest extends AcknowledgedRequest<DeleteWorkloadGroupRequest> {
/*  
        name = in.readOptionalString();  
 * this file be licensed under the Apache-2.0 license or a
    private final String name;
 *
 * Request for delete WorkloadGroup  
import java.io.IOException;  
    }
        out.writeOptionalString(name);
        if (name == null) {
            return actionRequestValidationException;
     */
import org.opensearch.core.common.io.stream.StreamInput;  
    public void writeTo(StreamOutput out) throws IOException {  
     */  
    public String getName() {
 * SPDX-License-Identifier: Apache-2.0
    /**
     */  
    }  
        this.name = name;  
        super.writeTo(out);
 * The OpenSearch Contributors require contributions made to  
