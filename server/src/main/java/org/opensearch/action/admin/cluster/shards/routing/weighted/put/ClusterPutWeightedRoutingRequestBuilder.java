@PublicApi(since = "2.4.0")
    public ClusterPutWeightedRoutingRequestBuilder setWeightedRouting(WeightedRouting weightedRouting) {
import org.opensearch.cluster.routing.WeightedRouting;
 * @opensearch.api  
/**  
 */
 * The OpenSearch Contributors require contributions made to  
        return this;
    public ClusterPutWeightedRoutingRequestBuilder(OpenSearchClient client, ClusterAddWeightedRoutingAction action) {
 */  
        request.version(version);
    ClusterPutWeightedRoutingRequestBuilder> {  
import org.opensearch.transport.client.OpenSearchClient;
        request.setWeightedRouting(weightedRouting);  
 * SPDX-License-Identifier: Apache-2.0
    }
import org.opensearch.common.annotation.PublicApi;  
    }  
}
package org.opensearch.action.admin.cluster.shards.routing.weighted.put;
 * Request builder to update weights for weighted round-robin shard routing policy.
/*  
    ClusterPutWeightedRoutingRequest,
public class ClusterPutWeightedRoutingRequestBuilder extends ClusterManagerNodeOperationRequestBuilder<  
    public ClusterPutWeightedRoutingRequestBuilder setVersion(long version) {
    }
import org.opensearch.action.support.clustermanager.ClusterManagerNodeOperationRequestBuilder;
 *
 *
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
        return this;  
    ClusterPutWeightedRoutingResponse,
        super(client, action, new ClusterPutWeightedRoutingRequest());
