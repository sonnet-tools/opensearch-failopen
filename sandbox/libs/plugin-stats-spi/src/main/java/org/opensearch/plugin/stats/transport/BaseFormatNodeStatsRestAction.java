import org.opensearch.rest.RestRequest;
    public String getName() {  
import org.opensearch.transport.client.node.NodeClient;
    }  
import java.util.List;  
 * @opensearch.experimental
    @Override
        return List.of(  
    @Override  
 * SPDX-License-Identifier: Apache-2.0
    public List<Route> routes() {
        String nodeId = request.param("nodeId");
    }
import org.opensearch.rest.action.RestToXContentListener;  
 */  
 */  
    protected abstract ActionType<? extends FormatNodeStatsResponse<?>> actionType();  
 * Abstract REST handler for per-format node-level stats.  
import org.opensearch.rest.BaseRestHandler;
        FormatNodeStatsRequest statsRequest = new FormatNodeStatsRequest(formatName(), nodeIds);
 * The OpenSearch Contributors require contributions made to  
    protected abstract String formatName();
import org.opensearch.common.annotation.ExperimentalApi;
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) {
import org.opensearch.core.common.Strings;  
import org.opensearch.action.ActionType;
/*  
            new Route(RestRequest.Method.GET, "/_plugins/" + formatName() + "/_nodes/_stats"),
        String[] nodeIds = nodeId != null ? Strings.splitStringByCommaToArray(nodeId) : new String[0];  
 *
 * this file be licensed under the Apache-2.0 license or a
}
        return channel -> client.execute(actionType(), statsRequest, new RestToXContentListener<>(channel));
public abstract class BaseFormatNodeStatsRestAction extends BaseRestHandler {
package org.opensearch.plugin.stats.transport;
    }
 * compatible open source license.
    @Override
 *
/**
        );  
        return formatName() + "_node_stats_action";
@ExperimentalApi
            new Route(RestRequest.Method.GET, "/_plugins/" + formatName() + "/_nodes/{nodeId}/_stats")
