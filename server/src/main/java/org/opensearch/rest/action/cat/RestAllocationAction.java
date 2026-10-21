import java.util.HashMap;
        return table;
                        return RestTable.buildResponse(tab, channel);
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
 */
                statsRequest.timeout(request.param("timeout"));
        clusterStateRequest.clusterManagerNodeTimeout(
    }
 * GitHub history for details.
        );
                        Table tab = buildTable(request, state, stats);
import org.opensearch.rest.action.RestActionListener;
        parseDeprecatedMasterTimeoutParameter(clusterStateRequest, request, deprecationLogger, getName());
 */
import org.opensearch.cluster.node.DiscoveryNode;
 * Unless required by applicable law or agreed to in writing,
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.api
        return "cat_allocation_action";
import org.opensearch.transport.client.node.NodeClient;
                    .indices(new CommonStatsFlags(CommonStatsFlags.Flag.Store));
        table.addCell("host", "alias:h;desc:host of node");
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestAllocationAction.class);
        table.addCell("disk.avail", "alias:da,diskAvail;text-align:right;desc:disk available");
            }
            short diskPercent = -1;
                used = total.getBytes() - avail.getBytes();
            allocs.merge(nodeId, 1, Integer::sum);
    protected Table getTableWithHeader(final RestRequest request) {
        final String[] nodes = Strings.splitStringByCommaToArray(request.param("nodes", "data:true"));
                if (used >= 0 && avail.getBytes() >= 0) {
 * software distributed under the License is distributed on an
        clusterStateRequest.clear().routingTable(true);
 * compatible open source license.
            @Override
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
        final Table table = new Table();
        }
            table.addCell(null);
                    .addMetric(NodesStatsRequest.Metric.FS.metricName())
            table.addCell(null);
 * not use this file except in compliance with the License.
import org.opensearch.core.common.unit.ByteSizeValue;
            ByteSizeValue total = nodeStats.getFs().getTotal().getTotal();
            if (total.getBytes() > 0) {
        table.addCell("node", "alias:n;desc:name of node");
/*
        final Map<String, Integer> allocs = new HashMap<>();
 * KIND, either express or implied.  See the License for the
    }
        final String UNASSIGNED = "UNASSIGNED";
 * specific language governing permissions and limitations
        }
            request.paramAsTime("cluster_manager_timeout", clusterStateRequest.clusterManagerNodeTimeout())
import org.opensearch.cluster.routing.ShardRouting;
        table.startHeaders();
 * the Apache License, Version 2.0 (the "License"); you may
import static org.opensearch.rest.RestRequest.Method.GET;
public class RestAllocationAction extends AbstractCatAction {
        final ClusterStateRequest clusterStateRequest = new ClusterStateRequest();
    @Override
import java.util.List;
                statsRequest.clear()
        table.endHeaders();
        clusterStateRequest.local(request.paramAsBoolean("local", clusterStateRequest.local()));
                statsRequest.indices().setIncludeIndicesStatsByLevel(true);
            table.startRow();
        table.addCell("disk.percent", "alias:dp,diskPercent;text-align:right;desc:percent disk used");
                nodeId = shard.currentNodeId();
                });
            table.addCell(used < 0 ? null : new ByteSizeValue(used));
 * under the License.
 * _cat API action to list shard allocations
 *
            table.addCell(null);
import org.opensearch.rest.RestResponse;
                client.admin().cluster().nodesStats(statsRequest, new RestResponseListener<NodesStatsResponse>(channel) {
 *
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
        return unmodifiableList(asList(new Route(GET, "/_cat/allocation"), new Route(GET, "/_cat/allocation/{nodes}")));
    public List<Route> routes() {
}
                    }
        for (ShardRouting shard : state.getState().routingTable().allShards()) {
            table.addCell(null);
        for (NodeStats nodeStats : stats.getNodes()) {
        table.addCell("disk.indices", "alias:di,diskIndices;text-align:right;desc:disk used by OpenSearch indices");
            table.addCell(shardCount);
import org.opensearch.common.logging.DeprecationLogger;
            table.addCell(total.getBytes() < 0 ? null : total);
                }
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
                    public RestResponse buildResponse(NodesStatsResponse stats) throws Exception {
    public RestChannelConsumer doCatRequest(final RestRequest request, final NodeClient client) {
            }
        table.addCell("disk.used", "alias:du,diskUsed;text-align:right;desc:disk used (total, not just OpenSearch)");
import org.opensearch.common.Table;
import org.opensearch.rest.action.RestResponseListener;
    }
                    diskPercent = (short) (used * 100 / (used + avail.getBytes()));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/**
/*
 *
 * You may obtain a copy of the License at
 * SPDX-License-Identifier: Apache-2.0
            table.addCell(node.getHostAddress());
            DiscoveryNode node = nodeStats.getNode();
package org.opensearch.rest.action.cat;
        table.addCell("shards", "alias:s;text-align:right;desc:number of shards on node");
import static java.util.Collections.unmodifiableList;
 * this work for additional information regarding copyright
            int shardCount = allocs.getOrDefault(node.getId(), 0);
 */
    @Override
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
        }
                    @Override
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.core.common.Strings;
            // if we don't know how much we use (non data nodes), it means 0
            table.addCell(null);
                NodesStatsRequest statsRequest = new NodesStatsRequest(nodes);
    }
            table.addCell(null);
            if (shard.assignedToNode()) {
            table.addCell(UNASSIGNED);
        return table;
    protected void documentation(StringBuilder sb) {
 * The OpenSearch Contributors require contributions made to
import org.opensearch.rest.RestRequest;
            table.addCell(diskPercent < 0 ? null : diskPercent);
    }
    @Override
import java.util.Map;
    private Table buildTable(RestRequest request, final ClusterStateResponse state, final NodesStatsResponse stats) {
            table.addCell(node.getName());
    }
            table.addCell(allocs.get(UNASSIGNED));
            String nodeId = "UNASSIGNED";
    public String getName() {
            table.endRow();
    @Override
 * license agreements. See the NOTICE file distributed with
        });
 *
            ByteSizeValue avail = nodeStats.getFs().getTotal().getAvailable();
            table.endRow();
        if (allocs.containsKey(UNASSIGNED)) {
            table.addCell(avail.getBytes() < 0 ? null : avail);
        table.addCell("disk.total", "alias:dt,diskTotal;text-align:right;desc:total capacity of all volumes");
    @Override
 */
            table.addCell(null);
            long used = 0;
            table.addCell(nodeStats.getIndices().getStore().getSize());
        Table table = getTableWithHeader(request);
        sb.append("/_cat/allocation\n");
 * this file be licensed under the Apache-2.0 license or a
        return channel -> client.admin().cluster().state(clusterStateRequest, new RestActionListener<ClusterStateResponse>(channel) {
            table.startRow();
            }
        table.addCell("ip", "desc:ip of node");
import static java.util.Arrays.asList;
            table.addCell(node.getHostName());
 * Licensed to Elasticsearch under one or more contributor
            public void processResponse(final ClusterStateResponse state) {
