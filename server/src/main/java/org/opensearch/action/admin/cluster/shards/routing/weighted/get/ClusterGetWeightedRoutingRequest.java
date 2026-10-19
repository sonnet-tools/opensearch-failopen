import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadRequest;
import org.opensearch.core.common.io.stream.StreamOutput;
 * @opensearch.api
        super(in);  
    }
 * this file be licensed under the Apache-2.0 license or a
}  
 * SPDX-License-Identifier: Apache-2.0
/**
        ActionRequestValidationException validationException = null;  
        if (awarenessAttribute == null || awarenessAttribute.isEmpty()) {
    }  
        out.writeString(awarenessAttribute);
    String awarenessAttribute;
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
import java.io.IOException;
 */  
    public ActionRequestValidationException validate() {
 * The OpenSearch Contributors require contributions made to  
        awarenessAttribute = in.readString();
            validationException = addValidationError("Awareness attribute is missing", validationException);
        return validationException;
        return awarenessAttribute;
package org.opensearch.action.admin.cluster.shards.routing.weighted.get;
    }
 *
import org.opensearch.action.ActionRequestValidationException;
/*  
@PublicApi(since = "2.4.0")
        this.awarenessAttribute = awarenessAttribute;  
    }
import org.opensearch.common.annotation.PublicApi;  
    }
 * Request to get weights for weighted round-robin search routing policy.  
 */  
    public void setAwarenessAttribute(String awarenessAttribute) {
import static org.opensearch.action.ValidateActions.addValidationError;  
        this.awarenessAttribute = awarenessAttribute;
        super.writeTo(out);  
    public ClusterGetWeightedRoutingRequest(StreamInput in) throws IOException {
 *
    public ClusterGetWeightedRoutingRequest(String awarenessAttribute) {
    }
    @Override
    public ClusterGetWeightedRoutingRequest() {}  
public class ClusterGetWeightedRoutingRequest extends ClusterManagerNodeReadRequest<ClusterGetWeightedRoutingRequest> {
    @Override
        }  
 * compatible open source license.
    public String getAwarenessAttribute() {  
