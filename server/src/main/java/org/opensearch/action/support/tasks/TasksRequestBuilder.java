    public final RequestBuilder setNodesIds(String... nodesIds) {  
import org.opensearch.action.ActionRequestBuilder;  
        super(client, action, request);
 */
        request.setTimeout(timeout);
    }  
    @SuppressWarnings("unchecked")
 * ownership. Elasticsearch licenses this file to you under  
        return (RequestBuilder) this;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public final RequestBuilder setActions(String... actions) {  
    /**
    }  
 *
    protected TasksRequestBuilder(OpenSearchClient client, ActionType<Response> action, Request request) {
/*
        request.setNodes(nodesIds);
import org.opensearch.action.ActionType;
 *     http://www.apache.org/licenses/LICENSE-2.0
    Response extends BaseTasksResponse,
 * Licensed to Elasticsearch under one or more contributor  
        request.setParentTaskId(taskId);
    @SuppressWarnings("unchecked")
     */
 *  
        return (RequestBuilder) this;
 * software distributed under the License is distributed on an
    @SuppressWarnings("unchecked")
    public final RequestBuilder setTimeout(TimeValue timeout) {  
 */  
        return (RequestBuilder) this;
 * Modifications Copyright OpenSearch Contributors. See  
    public final RequestBuilder setParentTaskId(TaskId taskId) {  
     * Set the task to lookup.  
     * Match all children of the provided task.  
 * @opensearch.internal  
import org.opensearch.core.tasks.TaskId;  
     */
 * this file be licensed under the Apache-2.0 license or a
 * Builder for task-based requests
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
        return (RequestBuilder) this;
 * KIND, either express or implied.  See the License for the
    RequestBuilder extends TasksRequestBuilder<Request, Response, RequestBuilder>> extends ActionRequestBuilder<Request, Response> {
    /**
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
/*  
    }  
 */
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.unit.TimeValue;
    public final RequestBuilder setTaskId(TaskId taskId) {  
 */
    }  
 * specific language governing permissions and limitations
public class TasksRequestBuilder<
    @SuppressWarnings("unchecked")
/**  
        request.setActions(actions);
import org.opensearch.transport.client.OpenSearchClient;
    @SuppressWarnings("unchecked")
 * license agreements. See the NOTICE file distributed with
    }  
 * under the License.  
package org.opensearch.action.support.tasks;
/*
        return (RequestBuilder) this;
    Request extends BaseTasksRequest<Request>,  
    }  
        request.setTaskId(taskId);
 *
}
 *
 * not use this file except in compliance with the License.
 * GitHub history for details.
