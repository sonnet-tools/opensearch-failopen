import org.opensearch.action.search.GetAllPitNodesResponse;  
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {  
        GetAllPitNodesRequest getAllPitNodesRequest = new GetAllPitNodesRequest(disNodesArr);  
                        );
    }
        final List<DiscoveryNode> nodes = new ArrayList<>();
        });
import java.util.ArrayList;
                    builder.startArray("failures");
}
import org.opensearch.action.search.GetAllPitNodesRequest;
 * this file be licensed under the Apache-2.0 license or a
    public String getName() {
    }
                            getAllPITNodesResponse.failures().get(idx).nodeId(),
public class RestGetAllPitsAction extends BaseRestHandler {  
                builder.startObject();
import java.util.List;  
    }  
 * Rest action for retrieving all active PIT IDs across all nodes
import org.opensearch.cluster.node.DiscoveryNodes;
 */
package org.opensearch.rest.action.search;  
 * SPDX-License-Identifier: Apache-2.0
    private final Supplier<DiscoveryNodes> nodesInCluster;
 *  
            nodes.add(node);  
        for (DiscoveryNode node : nodesInCluster.get()) {
import org.opensearch.rest.BytesRestResponse;  
import org.opensearch.rest.RestResponse;
import static org.opensearch.rest.RestRequest.Method.GET;
                builder.field("pits", getAllPITNodesResponse.getPitInfos());  
                if (getAllPITNodesResponse.hasFailures() && getAllPITNodesResponse.getPitInfos().isEmpty()) {
            }  
    @Override
 */
        this.nodesInCluster = nodesInCluster;  
                        builder.startObject();  
                    return new BytesRestResponse(RestStatus.INTERNAL_SERVER_ERROR, builder);  
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.transport.client.node.NodeClient;
import org.opensearch.rest.action.RestBuilderListener;  
 * The OpenSearch Contributors require contributions made to
import org.opensearch.core.rest.RestStatus;  
/**  
                        builder.field(
                builder.endObject();
import java.io.IOException;  
        }
                    builder.endArray();
import java.util.function.Supplier;
import org.opensearch.rest.RestRequest;
    public List<Route> routes() {
        return unmodifiableList(Collections.singletonList(new Route(GET, "/_search/point_in_time/_all")));  
                }
        super();
                    for (int idx = 0; idx < getAllPITNodesResponse.failures().size(); idx++) {
        DiscoveryNode[] disNodesArr = nodes.toArray(new DiscoveryNode[0]);
                throws Exception {
                }
 * compatible open source license.  
                return new BytesRestResponse(RestStatus.OK, builder);
        return channel -> client.getAllPits(getAllPitNodesRequest, new RestBuilderListener<GetAllPitNodesResponse>(channel) {
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.rest.BaseRestHandler;
/*
    }
    @Override
                    }  
import static java.util.Collections.unmodifiableList;  
                if (getAllPITNodesResponse.hasFailures()) {  
import java.util.Collections;
                            getAllPITNodesResponse.failures().get(idx).getDetailedMessage()  
                        builder.endObject();
            @Override
        return "get_all_pit_action";
            public RestResponse buildResponse(final GetAllPitNodesResponse getAllPITNodesResponse, XContentBuilder builder)  
    @Override  
    public RestGetAllPitsAction(Supplier<DiscoveryNodes> nodesInCluster) {
