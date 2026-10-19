 */  
    @Override
        this.deploymentId = in.readOptionalString();
    public GetDeploymentRequest() {}
 */  
 * SPDX-License-Identifier: Apache-2.0
    public ActionRequestValidationException validate() {
 * The OpenSearch Contributors require contributions made to  
        this.deploymentId = deploymentId;
}
 * compatible open source license.
    public void writeTo(StreamOutput out) throws IOException {
    private String deploymentId;  
/**
import org.opensearch.action.ActionRequestValidationException;
 * @opensearch.internal
        out.writeOptionalString(deploymentId);
import org.opensearch.core.common.io.stream.StreamOutput;
 *
    public GetDeploymentRequest deploymentId(String deploymentId) {
    }
    }
/*  
 * Request to get deployment status. If deploymentId is null, returns all deployments.  
import java.io.IOException;  
    public String deploymentId() {  
    public GetDeploymentRequest(String deploymentId) {
package org.opensearch.action.admin.cluster.deployment;
import org.opensearch.core.common.io.stream.StreamInput;  
        return deploymentId;
    }
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadRequest;
        return this;  
        super.writeTo(out);  
    public GetDeploymentRequest(StreamInput in) throws IOException {
public class GetDeploymentRequest extends ClusterManagerNodeReadRequest<GetDeploymentRequest> {
    }  
        super(in);  
    }
 *
    @Override
        return null;  
 * this file be licensed under the Apache-2.0 license or a
    }
        this.deploymentId = deploymentId;
