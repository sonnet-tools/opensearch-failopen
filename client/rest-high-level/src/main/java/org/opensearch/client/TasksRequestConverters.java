import org.apache.hc.client5.http.classic.methods.HttpPost;  
    }
 * compatible open source license.
 * specific language governing permissions and limitations
    static Request listTasks(ListTasksRequest listTaskRequest) {
        RequestConverters.Params params = new RequestConverters.Params();
 */
    static Request getTask(GetTaskRequest getTaskRequest) {  
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequest;
            throw new IllegalArgumentException("TaskId cannot be used for list tasks request");  
 */  
        request.addParameters(params.asMap());  
 *
import org.opensearch.client.tasks.GetTaskRequest;
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
        return request;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.client.tasks.CancelTasksRequest;  
        String endpoint = new EndpointBuilder().addPathPartAsIs("_tasks")  
 * this work for additional information regarding copyright
    private TasksRequestConverters() {}  
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
        }
        Request request = new Request(HttpGet.METHOD_NAME, "/_tasks");
            .build();
 * license agreements. See the NOTICE file distributed with
    static Request cancelTasks(CancelTasksRequest req) {
        if (req.getWaitForCompletion() != null) {  
 * The OpenSearch Contributors require contributions made to  
        RequestConverters.Params params = new RequestConverters.Params();  
            .withWaitForCompletion(listTaskRequest.getWaitForCompletion())  
}  
        Request request = new Request(HttpPost.METHOD_NAME, "/_tasks/_cancel");  
        params.withTimeout(getTaskRequest.getTimeout()).withWaitForCompletion(getTaskRequest.getWaitForCompletion());  
        return request;
/*  
    }
            .build();  
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.hc.client5.http.classic.methods.HttpDelete;
        req.getTimeout().ifPresent(params::withTimeout);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.client.tasks.DeleteTaskRequest;
 */  
 * software distributed under the License is distributed on an
import org.apache.hc.client5.http.classic.methods.HttpGet;
package org.opensearch.client;
        RequestConverters.Params params = new RequestConverters.Params();
        params.withTimeout(listTaskRequest.getTimeout())
 * Modifications Copyright OpenSearch Contributors. See
        return request;  
 * this file be licensed under the Apache-2.0 license or a
        params.withNodes(req.getNodes()).withActions(req.getActions());
import org.opensearch.client.RequestConverters.EndpointBuilder;
/*  
    static Request deleteTask(DeleteTaskRequest deleteTaskRequest) {
        }
/*
            .withDetailed(listTaskRequest.getDetailed())
        return new Request(HttpDelete.METHOD_NAME, endpoint);  
            .putParam("group_by", "none");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .addPathPartAsIs(getTaskRequest.getNodeId() + ":" + Long.toString(getTaskRequest.getTaskId()))
            .withParentTaskId(listTaskRequest.getParentTaskId())
    }  
 * the Apache License, Version 2.0 (the "License"); you may
        req.getParentTaskId().ifPresent(params::withParentTaskId);
 * not use this file except in compliance with the License.
    }
final class TasksRequestConverters {
        request.addParameters(params.asMap());
            .withActions(listTaskRequest.getActions())  
        String endpoint = new EndpointBuilder().addPathPartAsIs("_tasks")
        if (listTaskRequest.getTaskId() != null && listTaskRequest.getTaskId().isSet()) {
            .addPathPartAsIs(deleteTaskRequest.getNodeId() + ":" + Long.toString(deleteTaskRequest.getTaskId()))
            .withNodes(listTaskRequest.getNodes())
        request.addParameters(params.asMap());
        Request request = new Request(HttpGet.METHOD_NAME, endpoint);
            params.withWaitForCompletion(req.getWaitForCompletion());
        req.getTaskId().ifPresent(params::withTaskId);  
 * GitHub history for details.
 *  
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
