import static org.opensearch.action.ValidateActions.addValidationError;
    }
    public GetDecommissionStateRequest(StreamInput in) throws IOException {  
        out.writeString(attributeName);
    public GetDecommissionStateRequest() {}
     * Sets attribute name  
import org.opensearch.core.common.Strings;
        ActionRequestValidationException validationException = null;
    }  
 * The OpenSearch Contributors require contributions made to  
        if (attributeName == null || Strings.isEmpty(attributeName)) {
public class GetDecommissionStateRequest extends ClusterManagerNodeReadRequest<GetDecommissionStateRequest> {  
import org.opensearch.common.annotation.PublicApi;  
     */
     * @return this request  
     *
    @Override
    @Override
import org.opensearch.core.common.io.stream.StreamInput;
        this.attributeName = attributeName;  
    /**
            validationException = addValidationError("attribute name is missing", validationException);  
        attributeName = in.readString();
    public String attributeName() {  
     * Returns attribute name
    public GetDecommissionStateRequest(String attributeName) {
/*  
    public ActionRequestValidationException validate() {  
     */
 *
    }  
/**  
import org.opensearch.action.ActionRequestValidationException;
 */
    private String attributeName;
     * @param attributeName attribute name
 * compatible open source license.
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadRequest;
        }
 *
     * Constructs a new get decommission state request with given attribute name
     *
 */  
    }  
 * Get Decommissioned attribute request
}  
 * this file be licensed under the Apache-2.0 license or a
     * @return attributeName name of attribute
    /**  
    public GetDecommissionStateRequest attributeName(String attributeName) {
 * @opensearch.api  
     * @param attributeName name of the attribute  
 * SPDX-License-Identifier: Apache-2.0
    }
import org.opensearch.core.common.io.stream.StreamOutput;  
    }
     *  
@PublicApi(since = "2.4.0")
        this.attributeName = attributeName;  
import java.io.IOException;
    public void writeTo(StreamOutput out) throws IOException {  
    /**
        super(in);
        return this.attributeName;
package org.opensearch.action.admin.cluster.decommission.awareness.get;
        super.writeTo(out);
     */
        return validationException;
        return this;
