     * Sets request id for decommission request
import org.opensearch.transport.client.OpenSearchClient;  
 * compatible open source license.
     */
/*  
    /**
    DecommissionRequest,  
        super(client, action, request);
package org.opensearch.action.admin.cluster.decommission.awareness.put;
/**
     *
@PublicApi(since = "2.4.0")
        return this;
 *
        request.setDecommissionAttribute(decommissionAttribute);
        request.setNoDelay(noDelay);
 * The OpenSearch Contributors require contributions made to  
    DecommissionResponse,
}
    public DecommissionRequestBuilder setNoDelay(boolean noDelay) {
import org.opensearch.common.unit.TimeValue;
    }
 */  
        request.setDelayTimeout(delayTimeOut);  
     */
     * @return current object
        return this;
    public DecommissionRequestBuilder(OpenSearchClient client, ActionType<DecommissionResponse> action, DecommissionRequest request) {
    public DecommissionRequestBuilder setDecommissionedAttribute(DecommissionAttribute decommissionAttribute) {  
 * this file be licensed under the Apache-2.0 license or a
        request.setRequestID(requestID);
        return this;
import org.opensearch.cluster.decommission.DecommissionAttribute;  
     * @param requestID for decommission request  
    }
        return this;  
    }  
 * SPDX-License-Identifier: Apache-2.0
    }  
import org.opensearch.action.ActionType;
     * @return current object
 *
    /**  
 */  
public class DecommissionRequestBuilder extends ClusterManagerNodeOperationRequestBuilder<
    public DecommissionRequestBuilder setDelayTimeOut(TimeValue delayTimeOut) {
import org.opensearch.action.support.clustermanager.ClusterManagerNodeOperationRequestBuilder;
    DecommissionRequestBuilder> {
import org.opensearch.common.annotation.PublicApi;
    public DecommissionRequestBuilder requestID(String requestID) {  
 * Register decommission request builder  
    }  
 * @opensearch.api
     * @param decommissionAttribute decommission attribute  
