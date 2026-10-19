        String node = request.param("node");
import org.opensearch.transport.client.node.NodeClient;
import org.opensearch.rest.BaseRestHandler;
            return new String[] { node.trim() };
/*  
import org.opensearch.rest.action.RestToXContentListener;
        if (nodes != null && !nodes.trim().isEmpty()) {  
 *
 */  
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
    }
            return Arrays.stream(parsed).filter(s -> s != null && !s.trim().isEmpty()).map(String::trim).toArray(String[]::new);
        pruneFileCacheRequest.timeout(request.paramAsTime("timeout", pruneFileCacheRequest.timeout()));  
        String nodes = request.param("nodes");  
import java.io.IOException;
 * REST action to manually trigger FileCache prune operation across multiple nodes.
public class RestPruneCacheAction extends BaseRestHandler {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.admin.cluster.filecache.PruneFileCacheRequest;
 * compatible open source license.
 *
package org.opensearch.rest.action.admin.cluster;
}
 * this file be licensed under the Apache-2.0 license or a
        return "prune_filecache_action";
    private String[] parseNodeTargeting(RestRequest request) {
    }
    @Override
 */  
    }  
    }  
    }
    @Override
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.api
 * Supports node targeting for efficient cache management.  
        return false;  
    @Override
import org.opensearch.rest.RestRequest;
            String[] parsed = Strings.splitStringByCommaToArray(nodes);
import org.opensearch.core.common.Strings;  
import static java.util.Collections.singletonList;
    @Override  
        return channel -> client.execute(PruneFileCacheAction.INSTANCE, pruneFileCacheRequest, new RestToXContentListener<>(channel));
    public List<Route> routes() {
import java.util.List;  
import org.opensearch.action.admin.cluster.filecache.PruneFileCacheAction;
import org.opensearch.rest.RestRequest.Method;  
        }
    public boolean canTripCircuitBreaker() {
import java.util.Arrays;
        return singletonList(new Route(Method.POST, "/_filecache/prune"));
        PruneFileCacheRequest pruneFileCacheRequest = new PruneFileCacheRequest(nodeIds);
        } else if (node != null && !node.trim().isEmpty()) {  
        return null;
        String[] nodeIds = parseNodeTargeting(request);  
/**
    public String getName() {  
