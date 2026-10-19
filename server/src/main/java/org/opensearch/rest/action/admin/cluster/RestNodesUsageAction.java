    }
import static java.util.Arrays.asList;
        }
            nodesUsageRequest.aggregations(metrics.contains("aggregations"));
                new Route(GET, "/_nodes/usage/{metric}"),  
                builder.field("cluster_name", response.getClusterName().value());
 * Modifications Copyright OpenSearch Contributors. See
            nodesUsageRequest.all();  
 * under the License.  
import static java.util.Collections.unmodifiableList;
                RestActions.buildNodesHeader(builder, channel.request(), response);  
                response.toXContent(builder, channel.request());
import static org.opensearch.rest.RestRequest.Method.GET;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    Locale.ROOT,
import org.opensearch.rest.action.RestBuilderListener;
                builder.endObject();  
    @Override  
import org.opensearch.rest.BaseRestHandler;  
            nodesUsageRequest.clear();
            @Override  
/*  
 * @opensearch.api
                new Route(GET, "/_nodes/{nodeId}/usage/{metric}")
}
import org.opensearch.core.xcontent.XContentBuilder;
                builder.startObject();
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Locale;
/*  
 */  
import org.opensearch.rest.RestRequest;
        NodesUsageRequest nodesUsageRequest = new NodesUsageRequest(nodesIds);
 * compatible open source license.
import org.opensearch.action.admin.cluster.node.usage.NodesUsageRequest;
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.rest.BytesRestResponse;
 * Transport action to get nodes usage  
public class RestNodesUsageAction extends BaseRestHandler {
import java.io.IOException;
                new Route(GET, "/_nodes/{nodeId}/usage"),
import java.util.Set;
import org.opensearch.rest.action.RestActions;
/**
 * KIND, either express or implied.  See the License for the
            }  
        });
package org.opensearch.rest.action.admin.cluster;
    public List<Route> routes() {
    }
                    "request [%s] contains _all and individual metrics [%s]",
                String.format(  
 *
                return new BytesRestResponse(RestStatus.OK, builder);
 * Unless required by applicable law or agreed to in writing,
    @Override  
 * GitHub history for details.
        String[] nodesIds = Strings.splitStringByCommaToArray(request.param("nodeId"));
        Set<String> metrics = Strings.tokenizeByCommaToSet(request.param("metric", "_all"));  
        } else if (metrics.contains("_all")) {
            throw new IllegalArgumentException(
        );  
        nodesUsageRequest.timeout(request.param("timeout"));  
import org.opensearch.rest.RestResponse;  
 *
        return false;
            asList(  
    @Override
 * not use this file except in compliance with the License.
        } else {
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
            nodesUsageRequest.restActions(metrics.contains("rest_actions"));  
    @Override  
 * The OpenSearch Contributors require contributions made to  
 *  
 * license agreements. See the NOTICE file distributed with
            )
import java.util.List;  
        return unmodifiableList(
 *
            );  
        return channel -> client.admin().cluster().nodesUsage(nodesUsageRequest, new RestBuilderListener<NodesUsageResponse>(channel) {
import org.opensearch.transport.client.node.NodeClient;  
        if (metrics.size() == 1 && metrics.contains("_all")) {
                )
import org.opensearch.core.rest.RestStatus;
 */  
                    request.path(),  
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
    public boolean canTripCircuitBreaker() {
import org.opensearch.core.common.Strings;  
            public RestResponse buildResponse(NodesUsageResponse response, XContentBuilder builder) throws Exception {
 */
    }
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
    }  
/*
    public String getName() {
import org.opensearch.action.admin.cluster.node.usage.NodesUsageResponse;
        return "nodes_usage_action";  
                    request.param("metric")
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
                new Route(GET, "/_nodes/usage"),
