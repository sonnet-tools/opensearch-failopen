 * @opensearch.api
 *
}
 * SPDX-License-Identifier: Apache-2.0
 */  
    DeleteDecommissionStateResponse,
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.annotation.PublicApi;
    public DeleteDecommissionStateRequestBuilder(OpenSearchClient client, DeleteDecommissionStateAction action) {
 * Builder for Delete decommission request.  
    DeleteDecommissionStateRequest,  
@PublicApi(since = "2.4.0")
 * compatible open source license.
    DeleteDecommissionStateRequestBuilder> {
 */  
    }  
import org.opensearch.action.support.clustermanager.ClusterManagerNodeOperationRequestBuilder;
 *
package org.opensearch.action.admin.cluster.decommission.awareness.delete;
        super(client, action, new DeleteDecommissionStateRequest());
public class DeleteDecommissionStateRequestBuilder extends ClusterManagerNodeOperationRequestBuilder<
/**
import org.opensearch.transport.client.OpenSearchClient;  
/*  
