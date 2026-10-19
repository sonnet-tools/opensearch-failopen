        // Node information. Note that the node may be null because it has left the cluster between when we got this response and now.  
 * KIND, either express or implied.  See the License for the
 * under the License.  
    }
        boolean detailed = request.paramAsBoolean("detailed", false);  
        table.addCell("action", "alias:ac;desc:task action");
        table.addCell(taskInfo.getId());
 */
        final Set<String> responseParams = new HashSet<>();  
        }
    @Override
            table.addCell(taskInfo.getResourceStats());
        table.startRow();  
        String nodeId = taskInfo.getTaskId().getNodeId();
 * GitHub history for details.
import org.opensearch.core.common.Strings;  
 * compatible open source license.
    }
    public String getName() {
        table.addCell(node == null ? "-" : node.getAddress().address().getPort());  
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequest;
        table.addCell("timestamp", "alias:ts,hms,hhmmss;desc:start time in HH:MM:SS");  
import org.opensearch.common.unit.TimeValue;
        table.addCell(node == null ? "-" : node.getName());
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
        sb.append("/_cat/tasks\n");
            @Override
    }
import java.util.HashSet;
        table.addCell("node_id", "default:false;alias:ni;desc:unique node id");
 */
            table.addCell(taskInfo.getParentTaskId().toString());
import static org.opensearch.rest.RestRequest.Method.GET;
        table.addCell(taskInfo.getType());  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.rest.RestResponse;
            public RestResponse buildResponse(ListTasksResponse listTasksResponse) throws Exception {  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.tasks.TaskInfo;
 */  
            buildGroups(table, fullId, detailed, taskGroup.getChildTasks());  
        return table;  
            table.addCell("description", "default:true;alias:desc;desc:task action");
import java.util.ArrayList;
        table.addCell(taskInfo.getAction());
import java.time.Instant;
        table.addCell("type", "alias:ty;desc:task type");
        table.addCell("port", "default:false;alias:po;desc:bound transport port");
        boolean fullId = request.paramAsBoolean("full_id", false);
 * Modifications Copyright OpenSearch Contributors. See
 */  
        table.addCell(taskInfo.getStartTime());
        this.nodesInCluster = nodesInCluster;
        table.addCell("ip", "default:true;alias:i;desc:ip address");  
            table.addCell("-");
    private Table buildTable(RestRequest request, ListTasksResponse listTasksResponse) {
        return RESPONSE_PARAMS;
 * @opensearch.api
    }
package org.opensearch.rest.action.cat;
 * Licensed to Elasticsearch under one or more contributor  
        RESPONSE_PARAMS = Collections.unmodifiableSet(responseParams);  
        // Task detailed info  
    private static final Set<String> RESPONSE_PARAMS;  
        if (taskInfo.getParentTaskId().isSet()) {
import org.opensearch.rest.action.RestResponseListener;  
import org.opensearch.cluster.node.DiscoveryNode;
    protected Table getTableWithHeader(final RestRequest request) {  
            buildRow(table, fullId, detailed, discoveryNodes, taskGroup.getTaskInfo());
    }  
        });  
        table.startHeaders();  
    @Override
/**
    static {
import org.opensearch.tasks.Task;
        DiscoveryNodes discoveryNodes = nodesInCluster.get();
        table.addCell("version", "default:false;alias:v;desc:es version");  
    private final Supplier<DiscoveryNodes> nodesInCluster;
 * license agreements. See the NOTICE file distributed with
/*  
    @Override  
        table.addCell(taskInfo.getRunningTimeNanos());  
        table.addCell("parent_task_id", "alias:pti;desc:parent task id");  
    }
    }  
    @Override
        DiscoveryNode node = discoveryNodes.get(nodeId);
import org.opensearch.action.admin.cluster.node.tasks.list.TaskGroup;  
 * SPDX-License-Identifier: Apache-2.0
 *
        return channel -> client.admin().cluster().listTasks(listTasksRequest, new RestResponseListener<ListTasksResponse>(channel) {
        }
    @Override
import java.util.Comparator;  
        table.addCell("start_time", "alias:start;desc:start time in ms");
import java.util.Set;  
/*  
        table.addCell(FORMATTER.format(Instant.ofEpochMilli(taskInfo.getStartTime())));
        table.addCell("running_time", "default:true;alias:time;desc:running time");
        } else {  
        final ListTasksRequest listTasksRequest = generateListTasksRequest(request);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        table.addCell("node", "default:true;alias:n;desc:node name");
import org.opensearch.common.Table;  
    }
 * this work for additional information regarding copyright
        table.addCell("running_time_ns", "default:false;alias:time;desc:running time ns");
        table.addCell(fullId ? nodeId : Strings.substring(nodeId, 0, 4));
import org.opensearch.rest.RestRequest;
        if (detailed) {
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
    protected Set<String> responseParams() {
        table.addCell("task_id", "alias:ti;desc:unique task id");
        table.addCell(taskInfo.getTaskId().toString());  
import java.util.function.Supplier;
 * ownership. Elasticsearch licenses this file to you under  
        // Node info
    private static final DateFormatter FORMATTER = DateFormatter.forPattern("HH:mm:ss").withZone(ZoneOffset.UTC);  
        return singletonList(new Route(GET, "/_cat/tasks"));  
        table.addCell(node == null ? "-" : node.getVersion().toString());
 *
import java.util.List;
                return RestTable.buildResponse(buildTable(request, listTasksResponse), channel);
        }
        table.addCell(taskInfo.getHeaders().getOrDefault(Task.X_OPAQUE_ID, "-"));  
            }
import org.opensearch.transport.client.node.NodeClient;  
        }
        return "cat_tasks_action";
import java.time.ZoneOffset;  
 * _cat API action to get tasks information
 *  
    private void buildRow(Table table, boolean fullId, boolean detailed, DiscoveryNodes discoveryNodes, TaskInfo taskInfo) {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.time.DateFormatter;
        Table table = getTableWithHeader(request);
    protected void documentation(StringBuilder sb) {  
        table.endHeaders();
        responseParams.addAll(AbstractCatAction.RESPONSE_PARAMS);
    }
        // Task main info
    public List<Route> routes() {
        boolean detailed = request.paramAsBoolean("detailed", false);
        table.addCell("x_opaque_id", "default:false;alias:x;desc:X-Opaque-ID header");
        table.addCell(node == null ? "-" : node.getHostAddress());
        for (TaskGroup taskGroup : sortedGroups) {
public class RestTasksAction extends AbstractCatAction {  
 * this file be licensed under the Apache-2.0 license or a
    public RestTasksAction(Supplier<DiscoveryNodes> nodesInCluster) {  
/*
 * Unless required by applicable law or agreed to in writing,
    @Override  
 * You may obtain a copy of the License at  
        table.addCell("id", "default:false;desc:id of the task with the node");  
    public RestChannelConsumer doCatRequest(final RestRequest request, final NodeClient client) {
import org.opensearch.cluster.node.DiscoveryNodes;
    }
        responseParams.add("detailed");
}
        Table table = new Table();
            table.addCell("resource_stats", "default:false;desc:resource consumption info of the task");  
import static java.util.Collections.singletonList;  
 * specific language governing permissions and limitations
        List<TaskGroup> sortedGroups = new ArrayList<>(taskGroups);
        return table;  
        if (detailed) {
        table.addCell(TimeValue.timeValueNanos(taskInfo.getRunningTimeNanos()));
import java.util.Collections;
 *  
    }
import static org.opensearch.rest.action.admin.cluster.RestListTasksAction.generateListTasksRequest;
    private void buildGroups(Table table, boolean fullId, boolean detailed, List<TaskGroup> taskGroups) {  
        buildGroups(table, fullId, detailed, listTasksResponse.getTaskGroups());
        table.endRow();  
            table.addCell(taskInfo.getDescription());  
        sortedGroups.sort(Comparator.comparingLong(o -> o.getTaskInfo().getStartTime()));  
