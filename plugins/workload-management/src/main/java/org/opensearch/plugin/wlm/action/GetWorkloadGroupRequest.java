    public ActionRequestValidationException validate() {
    }
     * Default constructor for GetWorkloadGroupRequest  
    @Override
    final String name;  
            WorkloadGroup.validateName(name);
    }
    /**  
     * Name getter
    @Override  
        out.writeOptionalString(name);  
    public GetWorkloadGroupRequest(StreamInput in) throws IOException {
    }
        this.name = name;
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadRequest;
        super(in);  
     * @param in - A {@link StreamInput} object  
    public String getName() {  
    public GetWorkloadGroupRequest(String name) {  
package org.opensearch.plugin.wlm.action;
     * @param name - name for the WorkloadGroup to get
import org.opensearch.action.ActionRequestValidationException;
        }
 * compatible open source license.
    public void writeTo(StreamOutput out) throws IOException {
 *
     * Constructor for GetWorkloadGroupRequest
/*  
     */
    /**
 * SPDX-License-Identifier: Apache-2.0
        name = in.readOptionalString();
import java.io.IOException;
import org.opensearch.cluster.metadata.WorkloadGroup;  
     */
    /**
 * this file be licensed under the Apache-2.0 license or a
    }
     */
 * @opensearch.experimental  
        return name;
        return null;  
 */
        if (name != null) {  
import org.opensearch.core.common.io.stream.StreamOutput;
        super.writeTo(out);
 * Request for get WorkloadGroup
}  
/**  
 * The OpenSearch Contributors require contributions made to  
    }
 *
 */  
public class GetWorkloadGroupRequest extends ClusterManagerNodeReadRequest<GetWorkloadGroupRequest> {
