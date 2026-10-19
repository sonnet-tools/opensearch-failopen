        return singletonList(new Route(GET, "/_cat/nodeattrs"));
import org.opensearch.action.admin.cluster.node.info.NodesInfoRequest;
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.rest.RestRequest;  
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;  
        table.addCell("host", "alias:h;desc:host name");  
    @Override
        return table;  
        table.endHeaders();
 */
 * this work for additional information regarding copyright
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestNodeAttrsAction.class);
                table.startRow();  
        boolean fullId = req.paramAsBoolean("full_id", false);
 * not use this file except in compliance with the License.
        sb.append("/_cat/nodeattrs\n");  
 * ownership. Elasticsearch licenses this file to you under  
/*  
        return channel -> client.admin().cluster().state(clusterStateRequest, new RestActionListener<ClusterStateResponse>(channel) {
        parseDeprecatedMasterTimeoutParameter(clusterStateRequest, request, deprecationLogger, getName());
            public void processResponse(final ClusterStateResponse clusterStateResponse) {  
        });
 *  
        return "cat_node_attrs_action";
import org.opensearch.cluster.node.DiscoveryNodes;
 *
import org.opensearch.common.Table;
    public String getName() {  
    public List<Route> routes() {
import org.opensearch.transport.client.node.NodeClient;
        DiscoveryNodes nodes = state.getState().nodes();  
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
        table.addCell("value", "default:true;alias:attr.value;desc:attribute value");
                nodesInfoRequest.timeout(request.param("timeout"));
/*  
        }
                    }
    }
        clusterStateRequest.clusterManagerNodeTimeout(
import java.util.List;  
        for (DiscoveryNode node : nodes) {  
            NodeInfo info = nodesInfo.getNodesMap().get(node.getId());
                    public RestResponse buildResponse(NodesInfoResponse nodesInfoResponse) throws Exception {  
 *
                        return RestTable.buildResponse(buildTable(request, clusterStateResponse, nodesInfoResponse), channel);
        table.addCell("id", "default:false;alias:id,nodeId;desc:unique node id");
}
 */  
import java.util.Map;
    @Override  
 * KIND, either express or implied.  See the License for the
    protected Table getTableWithHeader(final RestRequest request) {  
 */  
import org.opensearch.core.common.Strings;
    }
import org.opensearch.rest.action.RestActionListener;
        table.addCell("pid", "default:false;alias:p;desc:process id");
 * GitHub history for details.
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
                table.addCell(attrEntry.getKey());
    }
    @Override
        table.addCell("port", "default:false;alias:po;desc:bound transport port");
            @Override
    }
        );
 * license agreements. See the NOTICE file distributed with
        Table table = new Table();
            }
        table.addCell("attr", "default:true;alias:attr.name;desc:attribute description");  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.cluster.node.DiscoveryNode;  
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.rest.action.cat;
                nodesInfoRequest.clear().addMetric(NodesInfoRequest.Metric.PROCESS.metricName());  
        table.addCell("ip", "alias:i;desc:ip address");
                    @Override
/*
        return table;  
                table.endRow();  
import org.opensearch.rest.action.RestResponseListener;  
            request.paramAsTime("cluster_manager_timeout", clusterStateRequest.clusterManagerNodeTimeout())  
import static org.opensearch.rest.RestRequest.Method.GET;
/**  
        table.startHeaders();
 * under the License.  
                table.addCell(attrEntry.getValue());
import static java.util.Collections.singletonList;  
 * software distributed under the License is distributed on an
        table.addCell("node", "default:true;alias:name;desc:node name");  
                });  
    }  
 * @opensearch.api  
    @Override  
                table.addCell(node.getAddress().address().getPort());  
public class RestNodeAttrsAction extends AbstractCatAction {
    protected void documentation(StringBuilder sb) {
                table.addCell(info == null ? null : info.getInfo(ProcessInfo.class).getId());  
 * specific language governing permissions and limitations
 * compatible open source license.
    }  
 * The OpenSearch Contributors require contributions made to  
            }
                table.addCell(fullId ? node.getId() : Strings.substring(node.getId(), 0, 4));
                NodesInfoRequest nodesInfoRequest = new NodesInfoRequest();
        clusterStateRequest.local(request.paramAsBoolean("local", clusterStateRequest.local()));
        Table table = getTableWithHeader(req);
import org.opensearch.rest.RestResponse;
 * the Apache License, Version 2.0 (the "License"); you may
                client.admin().cluster().nodesInfo(nodesInfoRequest, new RestResponseListener<NodesInfoResponse>(channel) {
                table.addCell(node.getName());
                table.addCell(node.getHostName());
 * this file be licensed under the Apache-2.0 license or a
    @Override
    private Table buildTable(RestRequest req, ClusterStateResponse state, NodesInfoResponse nodesInfo) {  
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
import org.opensearch.common.logging.DeprecationLogger;  
            for (Map.Entry<String, String> attrEntry : node.getAttributes().entrySet()) {
        final ClusterStateRequest clusterStateRequest = new ClusterStateRequest();
    public RestChannelConsumer doCatRequest(final RestRequest request, final NodeClient client) {
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
 * _cat API action to get node attributes
                table.addCell(node.getHostAddress());
import org.opensearch.monitor.process.ProcessInfo;
 *
        clusterStateRequest.clear().nodes(true);  
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
