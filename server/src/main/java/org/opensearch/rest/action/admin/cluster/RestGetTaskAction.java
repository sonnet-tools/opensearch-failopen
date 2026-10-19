 */  
    @Override
/*
import static java.util.Collections.singletonList;  
/*  
 * You may obtain a copy of the License at  
 * compatible open source license.
import org.opensearch.common.unit.TimeValue;
        TaskId taskId = new TaskId(request.param("task_id"));
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {  
/**  
    }
 * KIND, either express or implied.  See the License for the
import java.util.List;
    }
 */
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
        GetTaskRequest getTaskRequest = new GetTaskRequest();
package org.opensearch.rest.action.admin.cluster;
}
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskRequest;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
        getTaskRequest.setTimeout(timeout);
    public String getName() {
    }  
import java.io.IOException;  
    public List<Route> routes() {
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 */  
 * software distributed under the License is distributed on an
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
public class RestGetTaskAction extends BaseRestHandler {
 * Licensed to Elasticsearch under one or more contributor  
        getTaskRequest.setTaskId(taskId);  
        return "get_task_action";
import org.opensearch.rest.BaseRestHandler;
import org.opensearch.core.tasks.TaskId;  
 * Transport action to get task
 * @opensearch.api  
 */
 *
        boolean waitForCompletion = request.paramAsBoolean("wait_for_completion", false);
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
        return channel -> client.admin().cluster().getTask(getTaskRequest, new RestToXContentListener<>(channel));  
 *
 *
import org.opensearch.transport.client.node.NodeClient;
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.rest.action.RestToXContentListener;  
    @Override
import static org.opensearch.rest.RestRequest.Method.GET;
import org.opensearch.rest.RestRequest;
        TimeValue timeout = request.paramAsTime("timeout", null);  
    @Override  
        return singletonList(new Route(GET, "/_tasks/{task_id}"));  
 *  
        getTaskRequest.setWaitForCompletion(waitForCompletion);
