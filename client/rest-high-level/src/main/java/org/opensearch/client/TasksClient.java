     * Cancel one or more cluster tasks using the Task Management API.
     * @param listener the listener to be notified upon request completion
        );
 * A wrapper for the {@link RestHighLevelClient} that provides methods for accessing the Tasks API.
        );  
     */
 * under the License.  
            TasksRequestConverters::getTask,
     * @param request the request
            emptySet()
        return restHighLevelClient.performRequestAndParseOptionalEntity(  
            cancelTasksRequest,  
            emptySet()  
import org.opensearch.client.tasks.CancelTasksRequest;
            request,  
    public Cancellable cancelAsync(
    /**
 * Licensed to Elasticsearch under one or more contributor  
    public Cancellable getAsync(GetTaskRequest request, RequestOptions options, ActionListener<Optional<GetTaskResponse>> listener) {
     * @param listener an actionlistener that takes an optional response (404s are returned as an empty Optional)
            request,
        this.restHighLevelClient = restHighLevelClient;
     *
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
     * @return cancellable that may be used to cancel the request
 * specific language governing permissions and limitations
import org.opensearch.core.action.ActionListener;  
     *
        );
 *
        return restHighLevelClient.performRequestAsyncAndParseEntity(  
     * Asynchronously delete a stored completed task result using the Task Management API.
    /**  
     * Asynchronously get current tasks using the Task Management API.  
 * this file be licensed under the Apache-2.0 license or a
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param cancelTasksRequest the request
        RequestOptions options,  
 *  
    /**
            ListTasksResponse::fromXContent,  
            TasksRequestConverters::deleteTask,
 */  
 * KIND, either express or implied.  See the License for the
import java.util.Optional;  
    /**
            emptySet()  
 * GitHub history for details.
/*
     * @throws IOException in case there is a problem sending the request or parsing back the response
 * not use this file except in compliance with the License.
     * Get a task using the Task Management API.  
    }  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
 * license agreements. See the NOTICE file distributed with
            TasksRequestConverters::listTasks,
import static java.util.Collections.emptySet;
            listener,
            options,  
    public Cancellable deleteAsync(DeleteTaskRequest request, RequestOptions options, ActionListener<AcknowledgedResponse> listener) {
            options,
     */  
    }  
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;
            GetTaskResponse::fromXContent,
            TasksRequestConverters::listTasks,
     * Asynchronously cancel one or more cluster tasks using the Task Management API.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            request,
            emptySet()
     */  
    }  
        ActionListener<CancelTasksResponse> listener
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequest;
     *  
 * Unless required by applicable law or agreed to in writing,
            TasksRequestConverters::cancelTasks,
            listener,
            listener
    public Optional<GetTaskResponse> get(GetTaskRequest request, RequestOptions options) throws IOException {
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
    public ListTasksResponse list(ListTasksRequest request, RequestOptions options) throws IOException {
     * Get current tasks using the Task Management API.  
     * Delete a stored completed task result using the Task Management API.
     * Get a task using the Task Management API.
            options,
    }
            request,
        );
            emptySet()
import org.opensearch.client.tasks.GetTaskResponse;
 */  
        return restHighLevelClient.performRequestAndParseEntity(
 * compatible open source license.
    public CancelTasksResponse cancel(CancelTasksRequest cancelTasksRequest, RequestOptions options) throws IOException {
     *
            ListTasksResponse::fromXContent,  
            emptySet()
 */  
    TasksClient(RestHighLevelClient restHighLevelClient) {
     */
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
     * @throws IOException in case there is a problem sending the request or parsing back the response
     *
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            AcknowledgedResponse::fromXContent,
            options,
    ) {
     *
     *
     * @throws IOException in case there is a problem sending the request or parsing back the response  
     * @return cancellable that may be used to cancel the request  
    private final RestHighLevelClient restHighLevelClient;
        return restHighLevelClient.performRequestAsyncAndParseEntity(  
    /**  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return the response
            AcknowledgedResponse::fromXContent,
 * You may obtain a copy of the License at  
     *
     *
 * software distributed under the License is distributed on an
            request,  
    /**
    /**
import org.opensearch.client.tasks.CancelTasksResponse;
     */  
     * @param request the request  
    }
        CancelTasksRequest cancelTasksRequest,
     * @param listener the listener to be notified upon request completion
/*  
        return restHighLevelClient.performRequestAsyncAndParseOptionalEntity(  
 */
     * @param request the request
 * The OpenSearch Contributors require contributions made to  
        );  
        return restHighLevelClient.performRequestAndParseEntity(
     * @return the response
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
        );
     * @return cancellable that may be used to cancel the request
        );  
     * @return cancellable that may be used to cancel the request
/*  
        );
     * @throws IOException in case there is a problem sending the request or parsing back the response  
            listener,
    public Cancellable listAsync(ListTasksRequest request, RequestOptions options, ActionListener<ListTasksResponse> listener) {
        return restHighLevelClient.performRequestAsyncAndParseEntity(
            TasksRequestConverters::cancelTasks,
 * this work for additional information regarding copyright
     * @param request the request  
 *    http://www.apache.org/licenses/LICENSE-2.0
            CancelTasksResponse::fromXContent,
     * @return the response
     * @param request the request
/**
            request,
 * SPDX-License-Identifier: Apache-2.0
 *
package org.opensearch.client;
    public AcknowledgedResponse delete(DeleteTaskRequest request, RequestOptions options) throws IOException {
    }  
     * @param listener the listener to be notified upon request completion
     */  
    /**  
     * @param cancelTasksRequest the request
}  
     * @return the response  
    }
            options,  
        return restHighLevelClient.performRequestAndParseEntity(  
            CancelTasksResponse::fromXContent,  
     * @param request the request  
            cancelTasksRequest,
import org.opensearch.client.tasks.DeleteTaskRequest;  
    }
            GetTaskResponse::fromXContent
            options,  
     */
            options,  
import org.opensearch.client.tasks.GetTaskRequest;
public final class TasksClient {
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     */  
            options,  
            TasksRequestConverters::getTask,
            TasksRequestConverters::deleteTask,
