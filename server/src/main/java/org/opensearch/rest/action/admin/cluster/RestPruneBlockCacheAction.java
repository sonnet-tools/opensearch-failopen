        String nodes = request.param("nodes");
    private String[] parseNodeIds(RestRequest request) {
 *
import org.opensearch.rest.action.RestToXContentListener;  
    public boolean canTripCircuitBreaker() {
 * @opensearch.api
import java.io.IOException;  
        return null;  
    }
        }
 */  
 * compatible open source license.
        PruneBlockCacheRequest pruneRequest = nodeIds != null ? new PruneBlockCacheRequest(nodeIds) : new PruneBlockCacheRequest();
    public List<Route> routes() {
        return false;
public class RestPruneBlockCacheAction extends BaseRestHandler {
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
import org.opensearch.transport.client.node.NodeClient;
    }  
 * REST handler for {@code POST /_blockcache/prune}.  
 *
 *
    }
import org.opensearch.action.admin.cluster.blockcache.PruneBlockCacheAction;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.rest.RestRequest;
        String[] nodeIds = parseNodeIds(request);  
 * The OpenSearch Contributors require contributions made to  
    }
import java.util.List;
import static java.util.Collections.singletonList;  
import org.opensearch.rest.BaseRestHandler;
        if (nodes != null && nodes.isBlank() == false) {  
package org.opensearch.rest.action.admin.cluster;
import org.opensearch.core.common.Strings;  
 */  
/**
        pruneRequest.timeout(request.paramAsTime("timeout", pruneRequest.timeout()));
 * this file be licensed under the Apache-2.0 license or a
    public String getName() {  
            return Strings.splitStringByCommaToArray(nodes);
import org.opensearch.action.admin.cluster.blockcache.PruneBlockCacheRequest;
    @Override
    @Override
    @Override  
        return singletonList(new Route(RestRequest.Method.POST, "/_blockcache/prune"));
 * <p>Clears all registered block caches on warm nodes. An optional {@code nodes}
    }  
    @Override  
 * parameter restricts the operation to specific node IDs.  
        return channel -> client.execute(PruneBlockCacheAction.INSTANCE, pruneRequest, new RestToXContentListener<>(channel));
/*  
        return "prune_blockcache_action";
}
