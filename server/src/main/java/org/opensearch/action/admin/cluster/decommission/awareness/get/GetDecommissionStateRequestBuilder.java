/**
import org.opensearch.transport.client.OpenSearchClient;  
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadOperationRequestBuilder;
    /**
 * this file be licensed under the Apache-2.0 license or a
    public GetDecommissionStateRequestBuilder setAttributeName(String attributeName) {  
     * @return current object
    GetDecommissionStateResponse,
@PublicApi(since = "2.4.0")
 * The OpenSearch Contributors require contributions made to  
/*  
 *
    }  
    GetDecommissionStateRequestBuilder> {
package org.opensearch.action.admin.cluster.decommission.awareness.get;
 */  
 * compatible open source license.
    }  
        request.attributeName(attributeName);
 * SPDX-License-Identifier: Apache-2.0
}
     */
    GetDecommissionStateRequest,  
 * Get decommission request builder  
 *
     * @param attributeName name of attribute  
     * Creates new get decommissioned attributes request builder
    public GetDecommissionStateRequestBuilder(OpenSearchClient client, GetDecommissionStateAction action) {
public class GetDecommissionStateRequestBuilder extends ClusterManagerNodeReadOperationRequestBuilder<
    /**
import org.opensearch.common.annotation.PublicApi;
        return this;
        super(client, action, new GetDecommissionStateRequest());
     */  
 * @opensearch.api
 */  
