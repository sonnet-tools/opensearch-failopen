                    builder.endObject();
            builder.endObject();
 * REST handler exposing per-pool native memory stats at {@code _plugins/arrow_base/stats}.
import org.opensearch.rest.RestRequest;  
    /**  
    public List<Route> routes() {
            NativeAllocatorPoolStats stats = statsSupplier.get();  
 */  
    }  
                builder.field("resident_bytes", stats.getNativeResidentBytes());
    @Override
            if (stats != null) {
    public String getName() {  
                builder.field("allocated_bytes", stats.getNativeAllocatedBytes());  
 * compatible open source license.
        };  
                builder.startObject("pools");  
import java.util.List;  
        return List.of(new Route(RestRequest.Method.GET, "_plugins/arrow_base/stats"));  
            }
     * Creates a new stats action.
}
                    builder.field("min_bytes", pool.getMinBytes());  
    }
        return channel -> {
                builder.endObject();
                    builder.field("allocated_bytes", pool.getAllocatedBytes());  
                    builder.field("peak_bytes", pool.getPeakBytes());
                }  
            channel.sendResponse(new BytesRestResponse(RestStatus.OK, builder));
     * @param statsSupplier supplier of pool stats
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.transport.client.node.NodeClient;
                builder.startObject("runtime");
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.rest.RestStatus;
import org.opensearch.plugin.stats.NativeAllocatorPoolStats;  
 */
                builder.endObject();
        this.statsSupplier = statsSupplier;
    private final Supplier<NativeAllocatorPoolStats> statsSupplier;
     */  
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) {
    @Override  
 * SPDX-License-Identifier: Apache-2.0
public class ArrowBaseStatsAction extends BaseRestHandler {  
                    builder.startObject(pool.getName());
            builder.startObject();
        return "arrow_base_stats_action";
import org.opensearch.rest.BaseRestHandler;
/**  
    }
            builder.endObject();  
import java.util.function.Supplier;
 *
 * this file be licensed under the Apache-2.0 license or a
/*  
package org.opensearch.arrow.allocator;
                for (NativeAllocatorPoolStats.PoolStats pool : stats.getPools()) {
    }
    @Override
                    builder.field("limit_bytes", pool.getLimitBytes());
                    builder.field("group", pool.getGroup());
            builder.startObject("memory_pools");  
import org.opensearch.rest.BytesRestResponse;
            XContentBuilder builder = channel.newBuilder();
    public ArrowBaseStatsAction(Supplier<NativeAllocatorPoolStats> statsSupplier) {
