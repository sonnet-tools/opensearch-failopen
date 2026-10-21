            CancelTasksResponse::fromXContent,
        );
        return restHighLevelClient.performRequestAndParseEntity(
            ListTasksResponse::fromXContent,
 */
            options,
            GetTaskResponse::fromXContent
 * the Apache License, Version 2.0 (the "License"); you may
            emptySet()
     *
import java.io.IOException;
     */
 * ownership. Elasticsearch licenses this file to you under
     * Get a task using the Task Management API.
 * KIND, either express or implied.  See the License for the
            TasksRequestConverters::cancelTasks,
     */
            TasksRequestConverters::listTasks,
     * @param request the request
 */
    }
import org.opensearch.client.tasks.GetTaskResponse;
     * @param request the request
        ActionListener<CancelTasksResponse> listener
 * under the License.
            request,
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * @return the response
     * @param request the request
    public Cancellable listAsync(ListTasksRequest request, RequestOptions options, ActionListener<ListTasksResponse> listener) {
    public Cancellable getAsync(GetTaskRequest request, RequestOptions options, ActionListener<Optional<GetTaskResponse>> listener) {
    public CancelTasksResponse cancel(CancelTasksRequest cancelTasksRequest, RequestOptions options) throws IOException {
            options,
     * @param listener an actionlistener that takes an optional response (404s are returned as an empty Optional)
     * @param request the request
            options,
/*
     *
    public ListTasksResponse list(ListTasksRequest request, RequestOptions options) throws IOException {
     * @return the response
 * software distributed under the License is distributed on an
/*
 * Modifications Copyright OpenSearch Contributors. See
    }
    }
            TasksRequestConverters::listTasks,
 * this work for additional information regarding copyright
            TasksRequestConverters::getTask,
 * You may obtain a copy of the License at
            options,
import static java.util.Collections.emptySet;
        return restHighLevelClient.performRequestAsyncAndParseOptionalEntity(
            request,
            listener
            emptySet()
    public Optional<GetTaskResponse> get(GetTaskRequest request, RequestOptions options) throws IOException {
            AcknowledgedResponse::fromXContent,
 * this file be licensed under the Apache-2.0 license or a
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            emptySet()
    public AcknowledgedResponse delete(DeleteTaskRequest request, RequestOptions options) throws IOException {
    }
    public Cancellable cancelAsync(
            options,
            listener,
/**
        );
     *
import org.opensearch.client.tasks.CancelTasksRequest;
        );
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            TasksRequestConverters::cancelTasks,
            options,
            ListTasksResponse::fromXContent,
        return restHighLevelClient.performRequestAndParseOptionalEntity(
 * not use this file except in compliance with the License.
            options,
    private final RestHighLevelClient restHighLevelClient;
        CancelTasksRequest cancelTasksRequest,
    /**
     * @param cancelTasksRequest the request
     */
     *
            request,
package org.opensearch.client;
 * Unless required by applicable law or agreed to in writing,
            cancelTasksRequest,
     * @return cancellable that may be used to cancel the request
     */
     * Cancel one or more cluster tasks using the Task Management API.
import org.opensearch.client.tasks.GetTaskRequest;
     *
            request,
     *
    ) {
     * Get current tasks using the Task Management API.
    /**
            request,
     * @return cancellable that may be used to cancel the request
    }
            emptySet()
        );
 *
        );
    /**
import org.opensearch.core.action.ActionListener;
     */
            CancelTasksResponse::fromXContent,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
}
     * @param listener the listener to be notified upon request completion
    /**
     * Asynchronously cancel one or more cluster tasks using the Task Management API.
        );
     * Delete a stored completed task result using the Task Management API.
        this.restHighLevelClient = restHighLevelClient;
     * @param request the request
            listener,
     * Asynchronously get current tasks using the Task Management API.
            AcknowledgedResponse::fromXContent,
    }
    /**
            emptySet()
        );
public final class TasksClient {
import org.opensearch.client.tasks.DeleteTaskRequest;
 * SPDX-License-Identifier: Apache-2.0
     */
     * @return cancellable that may be used to cancel the request
 * specific language governing permissions and limitations
     * @throws IOException in case there is a problem sending the request or parsing back the response
            listener,
import org.opensearch.client.tasks.CancelTasksResponse;
        return restHighLevelClient.performRequestAsyncAndParseEntity(
    /**
    TasksClient(RestHighLevelClient restHighLevelClient) {
     * @return cancellable that may be used to cancel the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener the listener to be notified upon request completion
        return restHighLevelClient.performRequestAndParseEntity(
 * license agreements. See the NOTICE file distributed with
     */
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequest;
 *
     *
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * @param listener the listener to be notified upon request completion
            options,
 * GitHub history for details.
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     *
            cancelTasksRequest,
 *
    public Cancellable deleteAsync(DeleteTaskRequest request, RequestOptions options, ActionListener<AcknowledgedResponse> listener) {
            TasksRequestConverters::deleteTask,
        return restHighLevelClient.performRequestAndParseEntity(
 * Licensed to Elasticsearch under one or more contributor
/*
     * Asynchronously delete a stored completed task result using the Task Management API.
import java.util.Optional;
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    }
    /**
     * @return the response
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        RequestOptions options,
            GetTaskResponse::fromXContent,
        return restHighLevelClient.performRequestAsyncAndParseEntity(
 * The OpenSearch Contributors require contributions made to
     * Get a task using the Task Management API.
 * A wrapper for the {@link RestHighLevelClient} that provides methods for accessing the Tasks API.
 * compatible open source license.
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * @return the response
    /**
     * @param request the request
     * @param cancelTasksRequest the request
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
            emptySet()
        return restHighLevelClient.performRequestAsyncAndParseEntity(
            TasksRequestConverters::deleteTask,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            request,
    }
 */
        );
     *
    }
            TasksRequestConverters::getTask,
