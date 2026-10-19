 */
/*
import org.opensearch.cluster.node.DiscoveryNodes;  
    /**
 * this work for additional information regarding copyright
        if ("nodes".equals(groupBy)) {
import static org.opensearch.rest.RestRequest.Method.GET;  
import org.opensearch.rest.RestChannel;  
        boolean waitForCompletion = request.paramAsBoolean("wait_for_completion", false);
import org.opensearch.rest.BytesRestResponse;
        String[] nodes = Strings.splitStringByCommaToArray(request.param("nodes"));
                    builder.startObject();
    public boolean canTripCircuitBreaker() {
package org.opensearch.rest.action.admin.cluster;
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
    @Override
        } else if ("parents".equals(groupBy)) {
import static java.util.Collections.singletonList;
public class RestListTasksAction extends BaseRestHandler {
        this.nodesInCluster = nodesInCluster;  
import org.opensearch.common.unit.TimeValue;
                    response.toXContentGroupedByNode(builder, channel.request(), nodesInCluster.get());  
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;
    }  
        TimeValue timeout = request.paramAsTime("timeout", null);
        return singletonList(new Route(GET, "/_tasks"));
 * not use this file except in compliance with the License.
        ListTasksRequest listTasksRequest = new ListTasksRequest();
    public static ListTasksRequest generateListTasksRequest(RestRequest request) {
        return "list_tasks_action";
import org.opensearch.core.rest.RestStatus;
        String[] actions = Strings.splitStringByCommaToArray(request.param("actions"));
 * compatible open source license.
 */  
            return new RestBuilderListener<T>(channel) {
                    builder.endObject();
import org.opensearch.rest.BaseRestHandler;
        String groupBy,
                @Override  
import org.opensearch.rest.action.RestBuilderListener;  
 * @opensearch.api
        final RestChannel channel
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
/**
        return false;  
/*  
import java.util.List;
    public static <T extends ListTasksResponse> ActionListener<T> listTasksResponseListener(
import java.util.function.Supplier;  
            };
        listTasksRequest.setDetailed(detailed);  
 * the Apache License, Version 2.0 (the "License"); you may
    }  
 * Transport action to list tasks  
    @Override  
 *
    public String getName() {  
        } else if ("none".equals(groupBy)) {  
 *
    }
import org.opensearch.core.common.Strings;  
    public RestListTasksAction(Supplier<DiscoveryNodes> nodesInCluster) {
     * Standard listener for extensions of {@link ListTasksResponse} that supports {@code group_by=nodes}.  
                    response.toXContentGroupedByParents(builder, channel.request());
        final ListTasksRequest listTasksRequest = generateListTasksRequest(request);  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
                    builder.startObject();  
    }
 * license agreements. See the NOTICE file distributed with
                    return new BytesRestResponse(RestStatus.OK, builder);
        return channel -> client.admin().cluster().listTasks(listTasksRequest, listTasksResponseListener(nodesInCluster, groupBy, channel));
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequest;
        } else {
                    builder.endObject();
import org.opensearch.core.tasks.TaskId;
        Supplier<DiscoveryNodes> nodesInCluster,  
            };
import org.opensearch.transport.client.node.NodeClient;
        listTasksRequest.setWaitForCompletion(waitForCompletion);  
     */
                }
 * The OpenSearch Contributors require contributions made to  
    ) {  
        }
        TaskId parentTaskId = new TaskId(request.param("parent_task_id"));  
            return new RestBuilderListener<T>(channel) {  
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.rest.action.RestToXContentListener;
import org.opensearch.core.action.ActionListener;
                }  
        return listTasksRequest;
    }  
}
 * KIND, either express or implied.  See the License for the
        listTasksRequest.setActions(actions);
            return new RestToXContentListener<>(channel);
    @Override
import org.opensearch.core.xcontent.XContentBuilder;  
import org.opensearch.rest.RestResponse;
        listTasksRequest.setNodes(nodes);
    private final Supplier<DiscoveryNodes> nodesInCluster;  
 * Licensed to Elasticsearch under one or more contributor  
        final String groupBy = request.param("group_by", "nodes");
 * SPDX-License-Identifier: Apache-2.0
            throw new IllegalArgumentException("[group_by] must be one of [nodes], [parents] or [none] but was [" + groupBy + "]");  
 *
/*  
        boolean detailed = request.paramAsBoolean("detailed", false);  
 * You may obtain a copy of the License at  
                    return new BytesRestResponse(RestStatus.OK, builder);  
                public RestResponse buildResponse(T response, XContentBuilder builder) throws Exception {
                public RestResponse buildResponse(T response, XContentBuilder builder) throws Exception {
        listTasksRequest.setParentTaskId(parentTaskId);
 * this file be licensed under the Apache-2.0 license or a
    public List<Route> routes() {
import org.opensearch.rest.RestRequest;
                @Override
 *  
 */  
 * under the License.  
    }
 */  
        listTasksRequest.setTimeout(timeout);
 * GitHub history for details.
