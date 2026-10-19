/**  
 * POST /_plugins/_analytics_backend_datafusion/cache/_clear           → clears all caches
 * POST /_plugins/_analytics_backend_datafusion/cache/_clear?footer=true  → footer metadata only
 * this file be licensed under the Apache-2.0 license or a
    }
 * The OpenSearch Contributors require contributions made to  
 *
        nodesRequest.setOffset(request.paramAsBoolean("offset", false));
        nodesRequest.setColumn(request.paramAsBoolean("column", false));
    @Override
    }
import org.opensearch.rest.action.RestActions.NodesResponseRestListener;  
        return "datafusion_clear_cache_action";
 *
import org.opensearch.rest.BaseRestHandler;
        return channel -> client.execute(ClearCacheActionType.INSTANCE, nodesRequest, new NodesResponseRestListener<>(channel));
 * POST /_plugins/_analytics_backend_datafusion/cache/_clear?statistics=true  → statistics only
import java.io.IOException;  
}
 * POST /_plugins/_analytics_backend_datafusion/cache/_clear?offset=true  → offset index only
import org.opensearch.rest.RestRequest;
    public String getName() {  
 * </pre>  
import org.opensearch.transport.client.node.NodeClient;
        return singletonList(new Route(POST, ROUTE));  
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
    private static final String ROUTE = "/_plugins/_analytics_backend_datafusion/cache/_clear";  
 *
    }
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
    @Override
/*  
        return false;  
        nodesRequest.setStatistics(request.paramAsBoolean("statistics", false));  
 * Mirrors the {@code /_cache/clear?query=true} pattern used by OpenSearch index caches.  
 * POST /_plugins/_analytics_backend_datafusion/cache/_clear?column=true  → column index only  
    @Override  
 * <p>Multiple params may be combined. When no param is set, all caches are cleared.
import java.util.List;
package org.opensearch.be.datafusion.action.stats;
import static org.opensearch.rest.RestRequest.Method.POST;
        ClearCacheNodesRequest nodesRequest = new ClearCacheNodesRequest();
public class RestClearCacheAction extends BaseRestHandler {
import static java.util.Collections.singletonList;  
        nodesRequest.setFooter(request.paramAsBoolean("footer", false));  
 *
    }
 * <pre>  
 * Clears DataFusion caches across ALL nodes in the cluster.
 */  
    @Override
    public boolean canTripCircuitBreaker() {
 * @opensearch.internal
    public List<Route> routes() {
 */  
