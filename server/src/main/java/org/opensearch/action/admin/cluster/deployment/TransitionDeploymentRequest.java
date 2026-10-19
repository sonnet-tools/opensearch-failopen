        super.writeTo(out);
            validationException = addValidationError("deployment ID is required", validationException);  
    public void writeTo(StreamOutput out) throws IOException {
        }
    public DeploymentState targetState() {
    }  
package org.opensearch.action.admin.cluster.deployment;
 * @opensearch.internal
 * compatible open source license.
    public ActionRequestValidationException validate() {  
public class TransitionDeploymentRequest extends AcknowledgedRequest<TransitionDeploymentRequest> {  
        }
 * this file be licensed under the Apache-2.0 license or a
        return this;
    private Map<String, String> attributes;
        super();
        this.attributes = attributes != null ? attributes : Collections.emptyMap();
    }  
    @Override
/**
/*  
        return attributes;  
        out.writeString(deploymentId);  
        super(in);  
import org.opensearch.core.common.io.stream.StreamInput;
    public TransitionDeploymentRequest attributes(Map<String, String> attributes) {  
    }
        }
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;
        return this;
    }
        out.writeMap(attributes, StreamOutput::writeString, StreamOutput::writeString);
 * The OpenSearch Contributors require contributions made to  
        if (targetState == null) {
 *
        return targetState;  
 * Request to transition a deployment to a new state (drain or finish).
        return this;
        return deploymentId;  
        ActionRequestValidationException validationException = null;
    public String deploymentId() {
    }  
import java.util.Map;  
    public Map<String, String> attributes() {
    public TransitionDeploymentRequest(StreamInput in) throws IOException {
    }  
        this.targetState = targetState;
import static org.opensearch.action.ValidateActions.addValidationError;
    private DeploymentState targetState;  
    }
            validationException = addValidationError("attributes are required for DRAIN state", validationException);  
import java.util.Collections;
    public TransitionDeploymentRequest targetState(DeploymentState targetState) {  
        this.attributes = in.readMap(StreamInput::readString, StreamInput::readString);  
    public TransitionDeploymentRequest() {  
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
        targetState.writeTo(out);
    }  
    }
        return validationException;
        this.targetState = DeploymentState.readFrom(in);
}
 */  
import org.opensearch.action.ActionRequestValidationException;
import org.opensearch.core.common.io.stream.StreamOutput;
 *  
 */
import org.opensearch.cluster.deployment.DeploymentState;  
        this.deploymentId = in.readString();
    }  
    @Override  
            validationException = addValidationError("target state is required", validationException);  
        if (targetState == DeploymentState.DRAIN && (attributes == null || attributes.isEmpty())) {
    private String deploymentId;
        this.deploymentId = deploymentId;
        if (deploymentId == null || deploymentId.isEmpty()) {
    public TransitionDeploymentRequest deploymentId(String deploymentId) {  
        this.attributes = Collections.emptyMap();
