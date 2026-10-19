        String nodeId = taskInfo.getTaskId().getNodeId();
import org.opensearch.common.Table;
import org.opensearch.core.common.Strings;
    }
        DiscoveryNode node = discoveryNodes.get(nodeId);
    protected Set<String> responseParams() {
 * You may obtain a copy of the License at
        if (detailed) {
import java.util.Set;
/*
        // Node information. Note that the node may be null because it has left the cluster between when we got this response and now.
        table.addCell("id", "default:false;desc:id of the task with the node");
        return table;
        table.startRow();
import org.opensearch.tasks.TaskInfo;
        List<TaskGroup> sortedGroups = new ArrayList<>(taskGroups);
    private Table buildTable(RestRequest request, ListTasksResponse listTasksResponse) {
            public RestResponse buildResponse(ListTasksResponse listTasksResponse) throws Exception {
        table.addCell(node == null ? "-" : node.getName());
 * Modifications Copyright OpenSearch Contributors. See
        return singletonList(new Route(GET, "/_cat/tasks"));
        RESPONSE_PARAMS = Collections.unmodifiableSet(responseParams);
        table.addCell(TimeValue.timeValueNanos(taskInfo.getRunningTimeNanos()));
 *
        final ListTasksRequest listTasksRequest = generateListTasksRequest(request);
        // Task main info
        for (TaskGroup taskGroup : sortedGroups) {
            table.addCell("-");
        table.endHeaders();
 * _cat API action to get tasks information
    private static final DateFormatter FORMATTER = DateFormatter.forPattern("HH:mm:ss").withZone(ZoneOffset.UTC);
        sortedGroups.sort(Comparator.comparingLong(o -> o.getTaskInfo().getStartTime()));
        final Set<String> responseParams = new HashSet<>();
    }
 * KIND, either express or implied.  See the License for the
    @Override
            @Override
    }
    }
    }
        table.addCell("task_id", "alias:ti;desc:unique task id");
    }
        table.addCell("timestamp", "alias:ts,hms,hhmmss;desc:start time in HH:MM:SS");
    public RestChannelConsumer doCatRequest(final RestRequest request, final NodeClient client) {
        responseParams.add("detailed");
        }
 * SPDX-License-Identifier: Apache-2.0
    }
    public List<Route> routes() {
        table.addCell("x_opaque_id", "default:false;alias:x;desc:X-Opaque-ID header");
        Table table = getTableWithHeader(request);
 * this work for additional information regarding copyright
        table.addCell("action", "alias:ac;desc:task action");
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
public class RestTasksAction extends AbstractCatAction {
            table.addCell("description", "default:true;alias:desc;desc:task action");
import org.opensearch.rest.RestRequest;
import java.util.function.Supplier;
        Table table = new Table();
 * ownership. Elasticsearch licenses this file to you under
        table.addCell("parent_task_id", "alias:pti;desc:parent task id");
 *    http://www.apache.org/licenses/LICENSE-2.0
        table.addCell("node", "default:true;alias:n;desc:node name");
    @Override
        boolean detailed = request.paramAsBoolean("detailed", false);
    @Override
        table.addCell(taskInfo.getRunningTimeNanos());
    }
import java.util.Collections;
        table.addCell(taskInfo.getAction());
        if (detailed) {
 * Unless required by applicable law or agreed to in writing,
        table.addCell(node == null ? "-" : node.getAddress().address().getPort());
 * license agreements. See the NOTICE file distributed with
 */
        table.addCell("node_id", "default:false;alias:ni;desc:unique node id");
            table.addCell(taskInfo.getParentTaskId().toString());
        // Node info
 * software distributed under the License is distributed on an
        return "cat_tasks_action";
        table.addCell("port", "default:false;alias:po;desc:bound transport port");
    @Override
    static {
import org.opensearch.common.unit.TimeValue;
 *
        table.addCell(FORMATTER.format(Instant.ofEpochMilli(taskInfo.getStartTime())));
/*
import org.opensearch.rest.RestResponse;
        if (taskInfo.getParentTaskId().isSet()) {
import static org.opensearch.rest.RestRequest.Method.GET;
    protected Table getTableWithHeader(final RestRequest request) {
import org.opensearch.cluster.node.DiscoveryNode;
        responseParams.addAll(AbstractCatAction.RESPONSE_PARAMS);
        sb.append("/_cat/tasks\n");
 * under the License.
 * The OpenSearch Contributors require contributions made to
        table.addCell("type", "alias:ty;desc:task type");
import static org.opensearch.rest.action.admin.cluster.RestListTasksAction.generateListTasksRequest;
        table.endRow();
import org.opensearch.common.time.DateFormatter;
import java.util.Comparator;
    public RestTasksAction(Supplier<DiscoveryNodes> nodesInCluster) {
                return RestTable.buildResponse(buildTable(request, listTasksResponse), channel);
    protected void documentation(StringBuilder sb) {
            table.addCell(taskInfo.getDescription());
import org.opensearch.action.admin.cluster.node.tasks.list.TaskGroup;
 * the Apache License, Version 2.0 (the "License"); you may
    private final Supplier<DiscoveryNodes> nodesInCluster;
        return table;
import java.util.HashSet;
    private static final Set<String> RESPONSE_PARAMS;
        table.startHeaders();
        table.addCell(taskInfo.getType());
import java.util.ArrayList;
        table.addCell("running_time_ns", "default:false;alias:time;desc:running time ns");
        DiscoveryNodes discoveryNodes = nodesInCluster.get();
package org.opensearch.rest.action.cat;
            }
        }
        }
 * this file be licensed under the Apache-2.0 license or a
        boolean fullId = request.paramAsBoolean("full_id", false);
import org.opensearch.cluster.node.DiscoveryNodes;
 *
        table.addCell("version", "default:false;alias:v;desc:es version");
    private void buildRow(Table table, boolean fullId, boolean detailed, DiscoveryNodes discoveryNodes, TaskInfo taskInfo) {
    }
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequest;
        return channel -> client.admin().cluster().listTasks(listTasksRequest, new RestResponseListener<ListTasksResponse>(channel) {
}
    @Override
 * specific language governing permissions and limitations
        table.addCell(node == null ? "-" : node.getVersion().toString());
            table.addCell("resource_stats", "default:false;desc:resource consumption info of the task");
            buildRow(table, fullId, detailed, discoveryNodes, taskGroup.getTaskInfo());
import java.util.List;
        table.addCell(taskInfo.getId());
        table.addCell("ip", "default:true;alias:i;desc:ip address");
        table.addCell(node == null ? "-" : node.getHostAddress());
import static java.util.Collections.singletonList;
 * GitHub history for details.
    private void buildGroups(Table table, boolean fullId, boolean detailed, List<TaskGroup> taskGroups) {
/*
        return RESPONSE_PARAMS;
 */
        table.addCell(taskInfo.getHeaders().getOrDefault(Task.X_OPAQUE_ID, "-"));
 */
 * @opensearch.api
 */
        table.addCell(taskInfo.getStartTime());
        // Task detailed info
/**
        table.addCell("start_time", "alias:start;desc:start time in ms");
        this.nodesInCluster = nodesInCluster;
        }
 *
import org.opensearch.tasks.Task;
            buildGroups(table, fullId, detailed, taskGroup.getChildTasks());
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
    @Override
        table.addCell(taskInfo.getTaskId().toString());
import org.opensearch.rest.action.RestResponseListener;
    }
        buildGroups(table, fullId, detailed, listTasksResponse.getTaskGroups());
            table.addCell(taskInfo.getResourceStats());
        boolean detailed = request.paramAsBoolean("detailed", false);
        table.addCell(fullId ? nodeId : Strings.substring(nodeId, 0, 4));
    }
        } else {
import java.time.Instant;
        table.addCell("running_time", "default:true;alias:time;desc:running time");
        });
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.transport.client.node.NodeClient;
 * compatible open source license.
import java.time.ZoneOffset;
    public String getName() {
