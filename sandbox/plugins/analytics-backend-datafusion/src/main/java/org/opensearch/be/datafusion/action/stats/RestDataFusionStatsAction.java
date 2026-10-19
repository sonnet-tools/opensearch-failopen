    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
        DataFusionStatsNodesRequest nodesRequest = new DataFusionStatsNodesRequest(nodeIds, statsToRetrieve);
        if (nodeIdParam != null && !nodeIdParam.isEmpty()) {  
    private static final Set<String> VALID_STAT_NAMES = Set.of(
import java.util.List;
            List<String> invalidStats = Arrays.stream(requestedStats).filter(s -> !VALID_STAT_NAMES.contains(s)).toList();
                    builder.endObject();
                    return new BytesRestResponse(RestStatus.OK, builder);
                new Route(GET, CANONICAL_PREFIX + "/{nodeId}/stats/{stat}"),
            asList(
 * </ul>  
 * REST handler for DataFusion cluster stats.
}
import org.opensearch.rest.BaseRestHandler;
import java.io.IOException;
        "stream_next",
            DataFusionStatsActionType.INSTANCE,
        "query_execution",  
        // Parse nodeId: default to all nodes if not provided  
 *
                return channel -> {  
            statsToRetrieve.addAll(Arrays.asList(requestedStats));
 *   <li>{@code GET /_plugins/_analytics_backend_datafusion/{nodeId}/stats}</li>  
 * {@link TransportDataFusionStatsAction} via the transport layer.
        String statParam = request.param("stat");
import java.util.HashSet;  
            )  
 * this file be licensed under the Apache-2.0 license or a
 * <p>Parses path parameters ({@code nodeId}, {@code stat}) and delegates to  
 *   <li>{@code GET /_plugins/_analytics_backend_datafusion/stats/{stat}}</li>
    public List<Route> routes() {
    public String getName() {  
    }
    private static final String CANONICAL_PREFIX = "/_plugins/_analytics_backend_datafusion";  
import static java.util.Arrays.asList;
    @Override
 *
                    builder.field("error", "Invalid stat sections: " + invalidStats + ". Valid values are: " + VALID_STATS);  
                    response.toXContent(builder, request);  
    public static final String VALID_STATS = VALID_STAT_NAMES.stream().sorted().collect(Collectors.joining(", "));  
import java.util.Set;
            // Validate stat names — collect all invalid names and report together  
        // Parse stat filter: comma-separated stat section names  
     * Comma-separated list of valid stat section names for display in error messages.  
        }
public class RestDataFusionStatsAction extends BaseRestHandler {
                new Route(GET, CANONICAL_PREFIX + "/{nodeId}/stats"),  
                public org.opensearch.rest.RestResponse buildResponse(DataFusionStatsNodesResponse response, XContentBuilder builder)  
     * Derived from {@link #VALID_STAT_NAMES} so there is a single place to edit when adding stats.
                new Route(GET, CANONICAL_PREFIX + "/stats/{stat}"),
        );
        return channel -> client.execute(
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
            nodeIds = new String[0];  
import static java.util.Collections.unmodifiableList;  
/*  
import java.util.stream.Collectors;  
                    builder.startObject();
        "fragment_executor_gate",  
        return unmodifiableList(  
        String nodeIdParam = request.param("nodeId");
 *   <li>{@code GET /_plugins/_analytics_backend_datafusion/{nodeId}/stats/{stat}}</li>
        return "datafusion_stats_action";
            nodesRequest,  
import org.opensearch.core.rest.RestStatus;
import org.opensearch.transport.client.node.NodeClient;
 *
import org.opensearch.rest.RestRequest;  
        "cpu_runtime",
        "io_runtime",  
    );  
            if (!invalidStats.isEmpty()) {
            new RestBuilderListener<DataFusionStatsNodesResponse>(channel) {
    }
 * compatible open source license.
                }  
        "coordinator_reduce",
                    builder.startObject();
        "disk_spill"
    }  
import static org.opensearch.rest.RestRequest.Method.GET;
            }
        String[] nodeIds;
 * <p>Routes:  
import org.opensearch.rest.BytesRestResponse;
            String[] requestedStats = Strings.splitStringByCommaToArray(statParam);
                    throws Exception {
import java.util.Arrays;
        "plan_setup",
        } else {
 *
import org.opensearch.rest.action.RestBuilderListener;
            }
            nodeIds = Strings.splitStringByCommaToArray(nodeIdParam);
        "adaptive_budget",
        if (statParam != null && !statParam.isEmpty()) {  
import org.opensearch.core.xcontent.XContentBuilder;  
        );
    @Override
                };  
 */  
                    channel.sendResponse(new BytesRestResponse(RestStatus.BAD_REQUEST, builder));
                @Override
/**  
 *   <li>{@code GET /_plugins/_analytics_backend_datafusion/stats}</li>
        }  
 * <ul>
 * @opensearch.internal
                new Route(GET, CANONICAL_PREFIX + "/stats")
                    XContentBuilder builder = channel.newBuilder();
package org.opensearch.be.datafusion.action.stats;
                    builder.endObject();
import org.opensearch.core.common.Strings;
        Set<String> statsToRetrieve = new HashSet<>();
    /**
     */
    @Override
 */  
