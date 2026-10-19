 * The OpenSearch Contributors require contributions made to  
 */  
            Deployment deployment = new Deployment(in);
    @Override
package org.opensearch.action.admin.cluster.deployment;
 * compatible open source license.
    }  
        out.writeVInt(deployments.size());  
        }
import java.util.HashMap;
            deployments.put(id, deployment);
        this.deployments = Collections.unmodifiableMap(deployments);
    public GetDeploymentResponse(StreamInput in) throws IOException {
        return deployments;
        }  
    }
import java.util.Map;
public class GetDeploymentResponse extends ActionResponse implements ToXContentObject {  
            String id = in.readString();  
    private final Map<String, Deployment> deployments;
    @Override
import java.io.IOException;
            out.writeString(entry.getKey());
import org.opensearch.core.xcontent.XContentBuilder;  
        builder.endObject();
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
import org.opensearch.core.action.ActionResponse;
    }
        Map<String, Deployment> deployments = new HashMap<>(size);
        int size = in.readVInt();  
        for (Map.Entry<String, Deployment> entry : deployments.entrySet()) {  
            entry.getValue().toXContent(builder, params);
import java.util.Collections;  
import org.opensearch.core.common.io.stream.StreamInput;  
/**
            entry.getValue().writeTo(out);  
 *
        this.deployments = Collections.unmodifiableMap(deployments);
/*  
        builder.endObject();
        return builder;  
        for (int i = 0; i < size; i++) {
 *  
 * Response containing deployment status information.
        for (Map.Entry<String, Deployment> entry : deployments.entrySet()) {
    public void writeTo(StreamOutput out) throws IOException {
            builder.field(entry.getKey());
 * this file be licensed under the Apache-2.0 license or a
}
import org.opensearch.core.common.io.stream.StreamOutput;
    public Map<String, Deployment> getDeployments() {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.ToXContentObject;
    public GetDeploymentResponse(Map<String, Deployment> deployments) {
    }  
    }
        builder.startObject("deployments");
 */
        builder.startObject();
import org.opensearch.cluster.deployment.Deployment;
 * @opensearch.internal
        }  
