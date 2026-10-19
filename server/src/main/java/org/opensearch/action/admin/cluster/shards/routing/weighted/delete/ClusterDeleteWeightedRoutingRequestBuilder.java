    }  
    }
import org.opensearch.action.support.clustermanager.ClusterManagerNodeOperationRequestBuilder;
 */  
    public ClusterDeleteWeightedRoutingRequestBuilder setAwarenessAttribute(String attribute) {
/**
 * Request builder to delete weights for weighted round-robin shard routing policy.  
 *
        request.setAwarenessAttribute(attribute);
    ClusterDeleteWeightedRoutingRequestBuilder> {
 * compatible open source license.
package org.opensearch.action.admin.cluster.shards.routing.weighted.delete;
public class ClusterDeleteWeightedRoutingRequestBuilder extends ClusterManagerNodeOperationRequestBuilder<
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.api
import org.opensearch.common.annotation.PublicApi;
 */  
        return this;
    ClusterDeleteWeightedRoutingResponse,
        return this;  
    public ClusterDeleteWeightedRoutingRequestBuilder setVersion(long version) {
    public ClusterDeleteWeightedRoutingRequestBuilder(OpenSearchClient client, ClusterDeleteWeightedRoutingAction action) {
    }
/*  
    ClusterDeleteWeightedRoutingRequest,  
}  
import org.opensearch.transport.client.OpenSearchClient;  
 * this file be licensed under the Apache-2.0 license or a
@PublicApi(since = "2.4.0")
 *
        request.setVersion(version);  
 * SPDX-License-Identifier: Apache-2.0
        super(client, action, new ClusterDeleteWeightedRoutingRequest());
