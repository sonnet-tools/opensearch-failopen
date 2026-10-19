        return "restore_remote_store_action";  
import org.opensearch.transport.client.node.NodeClient;
import org.opensearch.rest.action.RestToXContentListener;
public final class RestRestoreRemoteStoreAction extends BaseRestHandler {  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.rest.RestRequest.Method.POST;
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
        return channel -> client.admin().cluster().restoreRemoteStore(restoreRemoteStoreRequest, new RestToXContentListener<>(channel));  
import org.opensearch.rest.BaseRestHandler;
/*  
import java.io.IOException;
 * @opensearch.api
package org.opensearch.rest.action.admin.cluster;
 * compatible open source license.
        restoreRemoteStoreRequest.restoreAllShards(request.paramAsBoolean("restore_all_shards", false));
 *  
import org.opensearch.rest.RestRequest;  
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreRequest;
        return singletonList(new Route(POST, "/_remotestore/_restore"));
import java.util.List;
        );
 */  
    @Override
 * Restores data from remote store
}
/**
    }
    @Override  
    }
        restoreRemoteStoreRequest.clusterManagerNodeTimeout(  
 * The OpenSearch Contributors require contributions made to  
 */
        RestoreRemoteStoreRequest restoreRemoteStoreRequest = new RestoreRemoteStoreRequest();
    public String getName() {
 *
    @Override
import static java.util.Collections.singletonList;
        restoreRemoteStoreRequest.waitForCompletion(request.paramAsBoolean("wait_for_completion", false));  
            request.paramAsTime("cluster_manager_timeout", restoreRemoteStoreRequest.clusterManagerNodeTimeout())
    }
    public List<Route> routes() {  
        request.applyContentParser(p -> restoreRemoteStoreRequest.source(p.mapOrdered()));
