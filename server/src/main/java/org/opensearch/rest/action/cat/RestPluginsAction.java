                NodesInfoRequest nodesInfoRequest = new NodesInfoRequest();  
import org.opensearch.cluster.node.DiscoveryNodes;
                table.startRow();
            PluginsAndModules plugins = info.getInfo(PluginsAndModules.class);
        table.endHeaders();
public class RestPluginsAction extends AbstractCatAction {
import static java.util.Collections.singletonList;
    }  
                table.endRow();
        table.addCell("version", "alias:v;desc:component version");
            if (info == null) {
import org.opensearch.action.admin.cluster.node.info.PluginsAndModules;
import java.util.List;  
 */  
    }  
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
/**
        Table table = getTableWithHeader(req);
 * this work for additional information regarding copyright
            @Override
                table.addCell(pluginInfo.getVersion());
 * under the License.  
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;  
    @Override
        clusterStateRequest.clusterManagerNodeTimeout(
 * Unless required by applicable law or agreed to in writing,
        parseDeprecatedMasterTimeoutParameter(clusterStateRequest, request, deprecationLogger, getName());
                table.addCell(pluginInfo.getName());
 */  
        table.addCell("id", "default:false;desc:unique node id");
        DiscoveryNodes nodes = state.getState().nodes();  
            }
import static org.opensearch.rest.RestRequest.Method.GET;  
/*
                nodesInfoRequest.timeout(request.param("timeout"));
}
        clusterStateRequest.clear().nodes(true);
        );  
    @Override
package org.opensearch.rest.action.cat;
 * @opensearch.api
 *
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.rest.action.RestResponseListener;  
    @Override
 * this file be licensed under the Apache-2.0 license or a
/*  
    public String getName() {
import org.opensearch.action.admin.cluster.node.info.NodesInfoRequest;
    public RestChannelConsumer doCatRequest(final RestRequest request, final NodeClient client) {  
        table.addCell("component", "alias:c;desc:component");
        sb.append("/_cat/plugins\n");
    protected void documentation(StringBuilder sb) {
 */  
            }
import org.opensearch.rest.RestResponse;
        Table table = new Table();  
import org.opensearch.rest.RestRequest;  
            public void processResponse(final ClusterStateResponse clusterStateResponse) throws Exception {
    private Table buildTable(RestRequest req, ClusterStateResponse state, NodesInfoResponse nodesInfo) {
        }  
    }
 * software distributed under the License is distributed on an
                    }
 * Licensed to Elasticsearch under one or more contributor  
                continue;
 *
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.Table;  
        return channel -> client.admin().cluster().state(clusterStateRequest, new RestActionListener<ClusterStateResponse>(channel) {  
    @Override  
 * not use this file except in compliance with the License.
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 *  
    }  
    }
        return table;
        table.addCell("name", "alias:n;desc:node name");  
    }
                        return RestTable.buildResponse(buildTable(request, clusterStateResponse, nodesInfoResponse), channel);  
                table.addCell(pluginInfo.getDescription());  
        final ClusterStateRequest clusterStateRequest = new ClusterStateRequest();
            request.paramAsTime("cluster_manager_timeout", clusterStateRequest.clusterManagerNodeTimeout())
                });
 * specific language governing permissions and limitations
        return singletonList(new Route(GET, "/_cat/plugins"));
            }  
        table.startHeaders();
                client.admin().cluster().nodesInfo(nodesInfoRequest, new RestResponseListener<NodesInfoResponse>(channel) {  
            }
    protected Table getTableWithHeader(final RestRequest request) {
 * ownership. Elasticsearch licenses this file to you under  
    public List<Route> routes() {  
import org.opensearch.transport.client.node.NodeClient;
 * SPDX-License-Identifier: Apache-2.0
    @Override
        });
import org.opensearch.cluster.node.DiscoveryNode;
        return table;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
 * license agreements. See the NOTICE file distributed with
            if (plugins == null) {  
            for (PluginInfo pluginInfo : plugins.getPluginInfos()) {  
                table.addCell(node.getName());  
 *
 * You may obtain a copy of the License at  
import org.opensearch.plugins.PluginInfo;
        clusterStateRequest.local(request.paramAsBoolean("local", clusterStateRequest.local()));  
import org.opensearch.rest.action.RestActionListener;
                    public RestResponse buildResponse(final NodesInfoResponse nodesInfoResponse) throws Exception {
 * _cat API action to get plugin information  
        for (DiscoveryNode node : nodes) {  
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;  
                table.addCell(node.getId());
        table.addCell("description", "alias:d;default:false;desc:plugin details");  
 * KIND, either express or implied.  See the License for the
            NodeInfo info = nodesInfo.getNodesMap().get(node.getId());
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestPluginsAction.class);  
                    @Override
        return "cat_plugins_action";  
                nodesInfoRequest.clear().addMetric(NodesInfoRequest.Metric.PLUGINS.metricName());
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.logging.DeprecationLogger;
                continue;  
 * compatible open source license.
