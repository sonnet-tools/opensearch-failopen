 */  
import org.opensearch.rest.action.RestResponseListener;  
 * GitHub history for details.
    @Override
            table.addCell(clusterManager.getHostName());  
}
        return table;  
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
    }
        Table table = new Table();
    @Override
        });  
    }  
            table.addCell(clusterManager.getId());
import org.opensearch.rest.RestResponse;
            table.addCell(clusterManager.getName());
        return singletonList(new ReplacedRoute(GET, "/_cat/cluster_manager", "/_cat/master"));
 * SPDX-License-Identifier: Apache-2.0
        return channel -> client.admin().cluster().state(clusterStateRequest, new RestResponseListener<ClusterStateResponse>(channel) {
/*  
            table.addCell(clusterManager.getHostAddress());
            table.addCell("-");
        // The deprecated path will be removed in a future major version.
/**
import org.opensearch.cluster.node.DiscoveryNode;  
        return table;
    @Override  
import org.opensearch.cluster.node.DiscoveryNodes;
            .endHeaders();
            public RestResponse buildResponse(final ClusterStateResponse clusterStateResponse) throws Exception {  
 *
import static org.opensearch.rest.RestRequest.Method.GET;  
 */  
    public List<ReplacedRoute> replacedRoutes() {  
            .addCell("id", "desc:node id")  
 */
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.logging.DeprecationLogger;  
import org.opensearch.transport.client.node.NodeClient;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return "cat_cluster_manager_action";
 * this file be licensed under the Apache-2.0 license or a
public class RestClusterManagerAction extends AbstractCatAction {
 * Licensed to Elasticsearch under one or more contributor  
        table.startHeaders()
            @Override
            table.addCell("-");  
 * license agreements. See the NOTICE file distributed with
            request.paramAsTime("cluster_manager_timeout", clusterStateRequest.clusterManagerNodeTimeout())  
 * the Apache License, Version 2.0 (the "License"); you may
 *
            .addCell("ip", "desc:ip address ")
 * under the License.  
        );
/*
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
import org.opensearch.rest.RestRequest;
 * compatible open source license.
    }  
        table.startRow();  
    @Override
 * specific language governing permissions and limitations
            table.addCell("-");  
            }
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
    }  
    protected void documentation(StringBuilder sb) {
 * KIND, either express or implied.  See the License for the
    private Table buildTable(RestRequest request, ClusterStateResponse state) {
import java.util.List;  
    @Override  
    @Override
import org.opensearch.common.Table;
        } else {
    public boolean canTripCircuitBreaker() {
        clusterStateRequest.local(request.paramAsBoolean("local", clusterStateRequest.local()));
    public RestChannelConsumer doCatRequest(final RestRequest request, final NodeClient client) {
/*  
        if (clusterManager == null) {
 *  
 * You may obtain a copy of the License at  
        final ClusterStateRequest clusterStateRequest = new ClusterStateRequest();
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestClusterManagerAction.class);  
        }  
        DiscoveryNode clusterManager = nodes.get(nodes.getClusterManagerNodeId());
        parseDeprecatedMasterTimeoutParameter(clusterStateRequest, request, deprecationLogger, getName());
 */  
import static java.util.Collections.singletonList;
            table.addCell("-");
 * not use this file except in compliance with the License.
 * @opensearch.api
        Table table = getTableWithHeader(request);  
    protected Table getTableWithHeader(final RestRequest request) {  
        table.endRow();
        return false;
            .addCell("host", "alias:h;desc:host name")
 * _cat API action to list cluster_manager information  
 * software distributed under the License is distributed on an
            .addCell("node", "alias:n;desc:node name")  
 * Unless required by applicable law or agreed to in writing,
    }
    }
        clusterStateRequest.clear().nodes(true);  
 *
        clusterStateRequest.clusterManagerNodeTimeout(
package org.opensearch.rest.action.cat;
        sb.append("/_cat/cluster_manager\n");  
                return RestTable.buildResponse(buildTable(request, clusterStateResponse), channel);
        DiscoveryNodes nodes = state.getState().nodes();
    public String getName() {  
