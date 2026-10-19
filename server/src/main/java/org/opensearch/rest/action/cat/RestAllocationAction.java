import static java.util.Arrays.asList;
import org.opensearch.transport.client.node.NodeClient;
package org.opensearch.rest.action.cat;
        sb.append("/_cat/allocation\n");  
import org.opensearch.cluster.node.DiscoveryNode;
        final String[] nodes = Strings.splitStringByCommaToArray(request.param("nodes", "data:true"));
            table.addCell(diskPercent < 0 ? null : diskPercent);
            table.addCell(used < 0 ? null : new ByteSizeValue(used));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        table.addCell("disk.percent", "alias:dp,diskPercent;text-align:right;desc:percent disk used");  
        clusterStateRequest.clear().routingTable(true);
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;  
            }
            // if we don't know how much we use (non data nodes), it means 0  
        table.addCell("disk.avail", "alias:da,diskAvail;text-align:right;desc:disk available");
    public List<Route> routes() {
 *  
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.Strings;
            table.addCell(null);  
    @Override
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.rest.action.RestActionListener;  
            table.addCell(node.getHostName());
                nodeId = shard.currentNodeId();  
    }  
    @Override  
/*
            String nodeId = "UNASSIGNED";  
import java.util.Map;  
        final Table table = new Table();
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
            table.addCell(null);  
 * Modifications Copyright OpenSearch Contributors. See
            table.startRow();
        }  
        final Map<String, Integer> allocs = new HashMap<>();  
 *
        clusterStateRequest.clusterManagerNodeTimeout(  
                    }
    private Table buildTable(RestRequest request, final ClusterStateResponse state, final NodesStatsResponse stats) {
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestAllocationAction.class);
        return table;
import static org.opensearch.rest.RestRequest.Method.GET;
                if (used >= 0 && avail.getBytes() >= 0) {
            request.paramAsTime("cluster_manager_timeout", clusterStateRequest.clusterManagerNodeTimeout())
import org.opensearch.rest.RestRequest;
                });  
 * license agreements. See the NOTICE file distributed with
 */
        return channel -> client.admin().cluster().state(clusterStateRequest, new RestActionListener<ClusterStateResponse>(channel) {
                NodesStatsRequest statsRequest = new NodesStatsRequest(nodes);
            table.endRow();
    }
            allocs.merge(nodeId, 1, Integer::sum);  
            int shardCount = allocs.getOrDefault(node.getId(), 0);
                    .addMetric(NodesStatsRequest.Metric.FS.metricName())
            table.addCell(UNASSIGNED);
    public String getName() {  
            short diskPercent = -1;
        }
            ByteSizeValue total = nodeStats.getFs().getTotal().getTotal();
                client.admin().cluster().nodesStats(statsRequest, new RestResponseListener<NodesStatsResponse>(channel) {  
    protected void documentation(StringBuilder sb) {
                statsRequest.indices().setIncludeIndicesStatsByLevel(true);
import org.opensearch.cluster.routing.ShardRouting;
            table.endRow();
    }  
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
 * Unless required by applicable law or agreed to in writing,
            ByteSizeValue avail = nodeStats.getFs().getTotal().getAvailable();
        table.addCell("disk.indices", "alias:di,diskIndices;text-align:right;desc:disk used by OpenSearch indices");
                }
            }
        table.addCell("node", "alias:n;desc:name of node");  
                    public RestResponse buildResponse(NodesStatsResponse stats) throws Exception {
        table.addCell("disk.total", "alias:dt,diskTotal;text-align:right;desc:total capacity of all volumes");
            table.addCell(null);  
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;  
import org.opensearch.rest.action.RestResponseListener;
        return table;
 */  
 * specific language governing permissions and limitations
        for (ShardRouting shard : state.getState().routingTable().allShards()) {
        return "cat_allocation_action";
 * _cat API action to list shard allocations
import org.opensearch.common.Table;  
                used = total.getBytes() - avail.getBytes();
        parseDeprecatedMasterTimeoutParameter(clusterStateRequest, request, deprecationLogger, getName());  
import org.opensearch.core.common.unit.ByteSizeValue;  
            table.addCell(allocs.get(UNASSIGNED));
 * The OpenSearch Contributors require contributions made to  
            table.addCell(avail.getBytes() < 0 ? null : avail);
        table.endHeaders();
        final ClusterStateRequest clusterStateRequest = new ClusterStateRequest();  
        table.addCell("ip", "desc:ip of node");
            table.addCell(shardCount);
 * this work for additional information regarding copyright
        table.addCell("disk.used", "alias:du,diskUsed;text-align:right;desc:disk used (total, not just OpenSearch)");  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.logging.DeprecationLogger;
            table.startRow();
public class RestAllocationAction extends AbstractCatAction {
}
 * under the License.  
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
        });
 * compatible open source license.
 * You may obtain a copy of the License at  
import java.util.HashMap;
    public RestChannelConsumer doCatRequest(final RestRequest request, final NodeClient client) {
        }  
            table.addCell(null);
import java.util.List;
 *
        table.startHeaders();  
            if (total.getBytes() > 0) {  
        if (allocs.containsKey(UNASSIGNED)) {  
                        return RestTable.buildResponse(tab, channel);
    @Override
 * @opensearch.api  
        return unmodifiableList(asList(new Route(GET, "/_cat/allocation"), new Route(GET, "/_cat/allocation/{nodes}")));
            table.addCell(null);
 * Licensed to Elasticsearch under one or more contributor  
            DiscoveryNode node = nodeStats.getNode();  
 * not use this file except in compliance with the License.
 */
    }  
import static java.util.Collections.unmodifiableList;  
/*  
    protected Table getTableWithHeader(final RestRequest request) {
import org.opensearch.rest.RestResponse;
                statsRequest.clear()
            table.addCell(node.getHostAddress());  
    }
                statsRequest.timeout(request.param("timeout"));  
        table.addCell("shards", "alias:s;text-align:right;desc:number of shards on node");
    }
        for (NodeStats nodeStats : stats.getNodes()) {
        clusterStateRequest.local(request.paramAsBoolean("local", clusterStateRequest.local()));
            table.addCell(null);
        );
 */  
/**  
        Table table = getTableWithHeader(request);  
            table.addCell(total.getBytes() < 0 ? null : total);  
/*  
    @Override  
            table.addCell(null);
            public void processResponse(final ClusterStateResponse state) {
    @Override  
 * GitHub history for details.
            if (shard.assignedToNode()) {
 *
            }
 * software distributed under the License is distributed on an
        final String UNASSIGNED = "UNASSIGNED";
                    .indices(new CommonStatsFlags(CommonStatsFlags.Flag.Store));  
                        Table tab = buildTable(request, state, stats);  
            table.addCell(nodeStats.getIndices().getStore().getSize());  
            @Override  
                    @Override
            table.addCell(node.getName());
            long used = 0;
                    diskPercent = (short) (used * 100 / (used + avail.getBytes()));  
        table.addCell("host", "alias:h;desc:host of node");
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
