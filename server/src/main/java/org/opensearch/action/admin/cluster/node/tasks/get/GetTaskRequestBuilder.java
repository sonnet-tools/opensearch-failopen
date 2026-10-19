 * The OpenSearch Contributors require contributions made to  
    /**
 * not use this file except in compliance with the License.
 * GitHub history for details.
     */
 */
        request.setTimeout(timeout);
}
import org.opensearch.core.tasks.TaskId;
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
        return this;
    }
 * software distributed under the License is distributed on an
 */  
package org.opensearch.action.admin.cluster.node.tasks.get;
 * Builder for the request to retrieve the list of tasks running on the specified nodes
 * specific language governing permissions and limitations
 *
/*  
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**
     */  
import org.opensearch.transport.client.OpenSearchClient;
     * Set the TaskId to look up. Required.
 *  
public class GetTaskRequestBuilder extends ActionRequestBuilder<GetTaskRequest, GetTaskResponse> {
import org.opensearch.common.unit.TimeValue;  
 *  
    public GetTaskRequestBuilder(OpenSearchClient client, GetTaskAction action) {
/**
        super(client, action, new GetTaskRequest());  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
        request.setWaitForCompletion(waitForCompletion);  
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.action.ActionRequestBuilder;
/*
 * KIND, either express or implied.  See the License for the
    public final GetTaskRequestBuilder setTaskId(TaskId taskId) {  
     * Timeout to wait for any async actions this request must take. It must take anywhere from 0 to 2.
    }
 * license agreements. See the NOTICE file distributed with
    public final GetTaskRequestBuilder setTimeout(TimeValue timeout) {
     * Should this request wait for all found tasks to complete?  
 * this file be licensed under the Apache-2.0 license or a
        request.setTaskId(taskId);
@PublicApi(since = "1.0.0")  
 * @opensearch.api
        return this;  
    }  
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
/*  
 *
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
    public final GetTaskRequestBuilder setWaitForCompletion(boolean waitForCompletion) {
     */
 */
        return this;
    /**  
 * under the License.  
    }
