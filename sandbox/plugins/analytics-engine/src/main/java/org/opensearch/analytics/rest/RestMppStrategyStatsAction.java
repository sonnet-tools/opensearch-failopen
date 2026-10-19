 * compatible open source license.
import org.opensearch.analytics.exec.join.MppStrategyMetrics;
import org.opensearch.rest.BytesRestResponse;  
        return channel -> {
 * @opensearch.internal
 * <p>Mainly a test-observability surface so end-to-end IT tests can prove that the intended
 * <pre>  
                builder.startObject();  
        return "analytics_mpp_strategy_stats";
    }
 * The OpenSearch Contributors require contributions made to  
    @Override
    public String getName() {
 * delta around a query.  
import org.opensearch.core.rest.RestStatus;  
import java.util.Map;  
 * eligible operator above them are not recorded. The dispatcher records the routed strategy on
/**
    }  
 * {@code HashShuffleAggregateIT.readStrategyCounter} for an example). A future revision could
                    builder.field(entry.getKey().name(), entry.getValue());  
import org.opensearch.rest.RestRequest;
 * make this a node-stats-style action that aggregates internally.  
import java.util.List;
    }
import static org.opensearch.rest.RestRequest.Method.GET;
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
 * {@code GET /_analytics/_strategies} — returns per-strategy dispatch counts as JSON.
        };  
        Map<MppStrategy, Long> snapshot = metrics.snapshot();  
 */  
                builder.endObject();
 *
 *
    private final MppStrategyMetrics metrics;  
                builder.endObject();  
import org.opensearch.transport.client.node.NodeClient;
 * </pre>
 * this file be licensed under the Apache-2.0 license or a
            }
import org.opensearch.rest.BaseRestHandler;
 *  
 * <p>Counters reflect <b>join- and aggregate-shaped queries only</b> — scans without an MPP-
import org.opensearch.core.xcontent.XContentBuilder;
        this.metrics = metrics;  
import java.io.IOException;
                channel.sendResponse(new BytesRestResponse(RestStatus.OK, builder));
        return List.of(new Route(GET, "/_analytics/_strategies"));
    }
 * { "strategies": { "BROADCAST": 3, "HASH_SHUFFLE": 0, "HASH_SHUFFLE_AGG": 1, "COORDINATOR_CENTRIC": 12 } }
 */  
public class RestMppStrategyStatsAction extends BaseRestHandler {
                }
/*  
 * <p>Response shape (counts are cumulative since node start):
 *  
    public List<Route> routes() {  
    public RestMppStrategyStatsAction(MppStrategyMetrics metrics) {
                for (Map.Entry<MppStrategy, Long> entry : snapshot.entrySet()) {
                builder.startObject("strategies");
 * MPP strategy fired (vs. silently degrading to coordinator-centric) by asserting the counter
 * SPDX-License-Identifier: Apache-2.0
            try (XContentBuilder builder = channel.newBuilder()) {
 * counters. For cluster-wide totals, callers must fan out to every node and sum (see
import org.opensearch.analytics.exec.join.MppStrategy;
 *
    @Override  
package org.opensearch.analytics.rest;
 * the coordinator node that handled the query; this handler returns only the local node's  
    @Override
}
