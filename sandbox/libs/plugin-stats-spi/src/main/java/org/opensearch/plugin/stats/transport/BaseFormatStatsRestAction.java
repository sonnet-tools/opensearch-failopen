            throw new IllegalArgumentException("level must be 'index' or 'shards' but was [" + level + "]");  
        String[] indices = Strings.splitStringByCommaToArray(request.param("index"));  
            for (int i = 0; i < parts.length; i++) {  
 * this file be licensed under the Apache-2.0 license or a
        return formatName() + "_stats_action";
        String nodesParam = request.param("nodes");
import org.opensearch.action.ActionType;
    }
import org.opensearch.rest.BaseRestHandler;
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
                    shardFilter[i] = Integer.parseInt(parts[i].trim());
import org.opensearch.core.common.Strings;
    @Override
        }
    @Override  
        boolean shardLevel = "shards".equals(level);
    }  
/*  
    protected abstract String formatName();
        }
 *
                }
        String shardsParam = request.param("shards");
        String level = request.param("level");
 *
 * @opensearch.experimental  
    }
        if (level != null && !"index".equals(level) && !"shards".equals(level)) {
        String[] nodeFilter = nodesParam != null ? Strings.splitStringByCommaToArray(nodesParam) : null;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.transport.client.node.NodeClient;
    @Override
    protected abstract ActionType<? extends FormatStatsResponse<?>> actionType();
                try {
 * Abstract REST handler for per-format index-level stats.
        if (shardsParam != null) {  
                    throw new IllegalArgumentException("shards parameter must be a comma-separated list of integers, got: " + shardsParam);
 */
public abstract class BaseFormatStatsRestAction extends BaseRestHandler {  
        return channel -> client.execute(actionType(), statsRequest, new RestToXContentListener<>(channel));  
        statsRequest.indicesOptions(indicesOptions);
import org.opensearch.common.annotation.ExperimentalApi;  
import org.opensearch.action.support.IndicesOptions;
@ExperimentalApi
        IndicesOptions indicesOptions = IndicesOptions.fromRequest(request, IndicesOptions.strictExpandOpen());
        return List.of(new Route(RestRequest.Method.GET, "/_plugins/" + formatName() + "/{index}/_stats"));
/**  
 */  
}
        int[] shardFilter = null;
            }  
    public String getName() {
                } catch (NumberFormatException e) {  
import java.util.List;
    public List<Route> routes() {  
            String[] parts = Strings.splitStringByCommaToArray(shardsParam);
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) {
package org.opensearch.plugin.stats.transport;
import org.opensearch.rest.RestRequest;  
            shardFilter = new int[parts.length];
import org.opensearch.rest.action.RestToXContentListener;
        FormatStatsRequest statsRequest = new FormatStatsRequest(formatName(), indices, shardLevel, shardFilter, nodeFilter);
