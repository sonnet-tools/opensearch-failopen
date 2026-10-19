import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadOperationRequestBuilder;
        request.setAwarenessAttribute(attribute);
        request.local(local);  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
 * Request builder to get weights for weighted round-robin search routing policy.  
    public ClusterGetWeightedRoutingRequestBuilder setAwarenessAttribute(String attribute) {
        return this;  
import org.opensearch.common.annotation.PublicApi;
 */  
}
 */  
    }
 *
        return this;
    public ClusterGetWeightedRoutingRequestBuilder setRequestLocal(boolean local) {
    ClusterGetWeightedRoutingRequest,  
/*  
    public ClusterGetWeightedRoutingRequestBuilder(OpenSearchClient client, ClusterGetWeightedRoutingAction action) {
/**
 * @opensearch.api
 * this file be licensed under the Apache-2.0 license or a
    }
        super(client, action, new ClusterGetWeightedRoutingRequest());
    }  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.action.admin.cluster.shards.routing.weighted.get;
    ClusterGetWeightedRoutingResponse,
@PublicApi(since = "2.4.0")
import org.opensearch.transport.client.OpenSearchClient;  
 *
    ClusterGetWeightedRoutingRequestBuilder> {
public class ClusterGetWeightedRoutingRequestBuilder extends ClusterManagerNodeReadOperationRequestBuilder<
