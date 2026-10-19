 * Modifications Copyright OpenSearch Contributors. See
        t.addCell(health.getRelocatingShards());
            "alias:dcm,dm,discovered_master;text-align:right;desc:cluster manager is discovered or not"  
 *
 * specific language governing permissions and limitations
    }  
        return t;  
    }
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        t.addCell("init", "alias:i,shards.initializing,shardsInitializing;text-align:right;desc:number of initializing nodes");
        t.addCell(health.hasDiscoveredClusterManager());
 * compatible open source license.
        t.addCell(health.getNumberOfNodes());
 */
import java.util.Locale;
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.api  
import org.opensearch.rest.RestRequest;
package org.opensearch.rest.action.cat;
 * Unless required by applicable law or agreed to in writing,
        t.addCell("status", "alias:st;desc:health status");
    @Override
        t.addCell(health.getTaskMaxWaitingTime().millis() == 0 ? "-" : health.getTaskMaxWaitingTime());
    public RestChannelConsumer doCatRequest(final RestRequest request, final NodeClient client) {
        t.addCell("shards", "alias:t,sh,shards.total,shardsTotal;text-align:right;desc:total number of shards");
        t.endRow();
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.Table;  
import org.opensearch.rest.RestResponse;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
        t.addCell("node.data", "alias:nd,nodeData;text-align:right;desc:number of nodes that can store data");
import java.util.List;  
            "discovered_cluster_manager",
 *  
        t.addCell("pri", "alias:p,shards.primary,shardsPrimary;text-align:right;desc:number of primary shards");  
        return "cat_health_action";
        t.addCell(health.getNumberOfPendingTasks());
        t.addCell("relo", "alias:r,shards.relocating,shardsRelocating;text-align:right;desc:number of relocating nodes");
    @Override  
        Table t = getTableWithHeader(request);
    @Override
 * KIND, either express or implied.  See the License for the
 *
 */
    @Override  
    }  
            @Override
        t.endHeaders();
        t.addCell(health.getInitializingShards());
            public RestResponse buildResponse(final ClusterHealthResponse health) throws Exception {  
    public boolean allowSystemIndexAccessByDefault() {  
        );
    }
        t.startRow();
/**  
    public List<Route> routes() {
        t.addCell("pending_tasks", "alias:pt,pendingTasks;text-align:right;desc:number of pending tasks");
 */  
 * not use this file except in compliance with the License.
    @Override  
        });  
        t.addCell("cluster", "alias:cl;desc:cluster name");
/*  
 * software distributed under the License is distributed on an
        Table t = new Table();
        t.addCell("max_task_wait_time", "alias:mtwt,maxTaskWaitTime;text-align:right;desc:wait time of longest task pending");
 * this work for additional information regarding copyright
        return channel -> client.admin().cluster().health(clusterHealthRequest, new RestResponseListener<ClusterHealthResponse>(channel) {
/*
import static org.opensearch.rest.RestRequest.Method.GET;
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
 * GitHub history for details.
    protected void documentation(StringBuilder sb) {
                return RestTable.buildResponse(buildTable(health, request), channel);
            }
        return singletonList(new Route(GET, "/_cat/health"));  
        t.addCell(health.getClusterName());  
        sb.append("/_cat/health\n");  
        return true;
        ClusterHealthRequest clusterHealthRequest = new ClusterHealthRequest();
 * under the License.  
 * license agreements. See the NOTICE file distributed with
/*  
    private Table buildTable(final ClusterHealthResponse health, final RestRequest request) {  
        t.addCell("unassign", "alias:u,shards.unassigned,shardsUnassigned;text-align:right;desc:number of unassigned shards");  
 * The OpenSearch Contributors require contributions made to  
        t.addCell(health.getActivePrimaryShards());  
        t.addCell("node.total", "alias:nt,nodeTotal;text-align:right;desc:total number of nodes");  
        t.addCell(String.format(Locale.ROOT, "%1.1f%%", health.getActiveShardsPercent()));  
        t.addCell(health.getActiveShards());
 * the Apache License, Version 2.0 (the "License"); you may
        t.addCell(health.getUnassignedShards());  
    protected Table getTableWithHeader(final RestRequest request) {
        t.addCell(
import static java.util.Collections.singletonList;  
        t.startHeadersWithTimestamp();  
        // The alias 'discovered_master' is added for compatibility when using request parameter 'h=discovered_master'.  
        t.addCell(health.getStatus().name().toLowerCase(Locale.ROOT));
import org.opensearch.rest.action.RestResponseListener;  
        // TODO: Remove the header alias 'discovered_master', after removing MASTER_ROLE.
 * this file be licensed under the Apache-2.0 license or a
 *
    }
        t.addCell("active_shards_percent", "alias:asp,activeShardsPercent;text-align:right;desc:active number of shards in percent");  
}
        t.addCell(health.getNumberOfDataNodes());  
        return t;
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
import org.opensearch.transport.client.node.NodeClient;
 */  
public class RestHealthAction extends AbstractCatAction {
    @Override
 * _cat API action to get cluster health
    public String getName() {
