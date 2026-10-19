 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
    private final Supplier<DiscoveryNodes> nodesInCluster;  
 *
        cancelTasksRequest.setParentTaskId(parentTaskId);
    }
        cancelTasksRequest.setTaskId(taskId);
import org.opensearch.cluster.node.DiscoveryNodes;
 * Transport action to cancel tasks
        cancelTasksRequest.setActions(actions);  
import static org.opensearch.rest.action.admin.cluster.RestListTasksAction.listTasksResponseListener;
 * this work for additional information regarding copyright
 * under the License.  
import org.opensearch.rest.RestRequest;  
    @Override  
 * KIND, either express or implied.  See the License for the
import static org.opensearch.rest.RestRequest.Method.POST;  
import org.opensearch.transport.client.node.NodeClient;
    }  
 * Unless required by applicable law or agreed to in writing,
 */
import java.util.function.Supplier;
 *  
        cancelTasksRequest.setNodes(nodesIds);
    public String getName() {
/*  
        final String[] actions = Strings.splitStringByCommaToArray(request.param("actions"));
 */  
/**  
import org.opensearch.rest.BaseRestHandler;
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
    @Override
        cancelTasksRequest.setWaitForCompletion(request.paramAsBoolean("wait_for_completion", cancelTasksRequest.waitForCompletion()));
/*
    @Override
public class RestCancelTasksAction extends BaseRestHandler {
    }  
 * specific language governing permissions and limitations
    }
    public List<Route> routes() {  
}
        return "cancel_tasks_action";
        CancelTasksRequest cancelTasksRequest = new CancelTasksRequest();  
import java.io.IOException;  
import org.opensearch.core.tasks.TaskId;
            .cluster()
 * Modifications Copyright OpenSearch Contributors. See
            .cancelTasks(cancelTasksRequest, listTasksResponseListener(nodesInCluster, groupBy, channel));
/*  
 * SPDX-License-Identifier: Apache-2.0
        final TaskId parentTaskId = new TaskId(request.param("parent_task_id"));  
import org.opensearch.core.common.Strings;  
    public RestCancelTasksAction(Supplier<DiscoveryNodes> nodesInCluster) {
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
        final String groupBy = request.param("group_by", "nodes");
 * @opensearch.api  
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
import java.util.List;
import static java.util.Arrays.asList;
        return unmodifiableList(asList(new Route(POST, "/_tasks/_cancel"), new Route(POST, "/_tasks/{task_id}/_cancel")));
 */
    @Override
 *
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
        final TaskId taskId = new TaskId(request.param("task_id"));
        final String[] nodesIds = Strings.splitStringByCommaToArray(request.param("nodes"));  
import static java.util.Collections.unmodifiableList;
 * the Apache License, Version 2.0 (the "License"); you may
        return channel -> client.admin()  
    public boolean canTripCircuitBreaker() {  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return false;
 */  
 * compatible open source license.
package org.opensearch.rest.action.admin.cluster;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequest;
        this.nodesInCluster = nodesInCluster;  
 * license agreements. See the NOTICE file distributed with
 *
