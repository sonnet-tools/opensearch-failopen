                            + "] belongs to the node ["
import org.opensearch.core.tasks.TaskId;
        get.setParentTask(clusterService.localNode().getId(), thisTask.getId());
import org.opensearch.action.support.ActionFilters;
 * KIND, either express or implied.  See the License for the
    private final ThreadPool threadPool;
        }
                threadPool.generic().execute(new AbstractRunnable() {
import org.opensearch.transport.client.Client;
            } else {
 *     http://www.apache.org/licenses/LICENSE-2.0
            if (ExceptionsHelper.unwrap(e, ResourceNotFoundException.class) != null) {
 */
        getFinishedTaskFromIndex(thisTask, request, ActionListener.delegateResponse(listener, (delegatedListener, e) -> {
}
import org.opensearch.tasks.Task;
                });
 * this file be licensed under the Apache-2.0 license or a
    private final TransportService transportService;
            listener.onFailure(new ResourceNotFoundException("task [{}] isn't running and hasn't stored its results", response.getId()));
 * You may obtain a copy of the License at
    }
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * @opensearch.internal
import org.opensearch.core.xcontent.NamedXContentRegistry;
                        "task ["
    /**
        this.client = new OriginSettingClient(client, GetTaskAction.TASKS_ORIGIN);
                listener.onFailure(e);
        ActionListener<GetTaskResponse> listener
import org.opensearch.common.util.concurrent.AbstractRunnable;
 *
                        taskManager.waitForTaskCompletion(runningTask, waitForCompletionTimeout(request.getTimeout()));
     * {@link #getFinishedTaskFromIndex(Task, GetTaskRequest, ActionListener)} if the task isn't still running.
    }
 * Modifications Copyright OpenSearch Contributors. See
                    }
            getRunningTaskFromNode(thisTask, request, listener);
    public TransportGetTaskAction(
    void getFinishedTaskFromIndex(Task thisTask, GetTaskRequest request, ActionListener<GetTaskResponse> listener) {
import org.opensearch.action.get.GetRequest;
 * specific language governing permissions and limitations
     */
 *
 * <p>
import org.opensearch.action.ActionListenerResponseHandler;
        transportService.sendRequest(
 * software distributed under the License is distributed on an
import org.opensearch.tasks.TaskResultsService;
                );
        }));
import org.opensearch.tasks.TaskResult;
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
                TaskInfo info = runningTask.taskInfo(clusterService.localNode().getId(), true);
            return;
 * this work for additional information regarding copyright
            } else {
import static org.opensearch.action.admin.cluster.node.tasks.list.TransportListTasksAction.waitForCompletionTimeout;
                delegatedListener.onResponse(new GetTaskResponse(new TaskResult(true, snapshotOfRunningTask)));
            getFinishedTaskFromIndex(thisTask, request, listener);
        ) {
import org.opensearch.common.inject.Inject;
 *
                    @Override
import org.opensearch.cluster.service.ClusterService;
 * Licensed to Elasticsearch under one or more contributor
 * under the License.
                LoggingDeprecationHandler.INSTANCE,
                        listener.onFailure(e);
            // Task isn't running, go look in the task index
     * Send a {@link GetRequest} to the tasks index looking for a persisted copy of the task completed task. It'll only be found only if the
    }
 * compatible open source license.
 * </ul>
    @Inject
import org.opensearch.core.action.ActionListener;
            }));
import org.opensearch.cluster.node.DiscoveryNode;
            runOnNodeWithTaskIfPossible(thisTask, request, listener);
 * not use this file except in compliance with the License.
    private final Client client;
            builder.build(),
    @Override
        NamedXContentRegistry xContentRegistry,
 * license agreements. See the NOTICE file distributed with
        this.clusterService = clusterService;
import org.opensearch.action.support.HandledTransportAction;
                }
 * <li>Look up the task and return it if it exists
                listener.onFailure(e);
        }
    private final ClusterService clusterService;
 */
    ) {
     */
        TaskInfo snapshotOfRunningTask,
                taskResourceTrackingService.refreshResourceStats(runningTask);
                    e = new ResourceNotFoundException(
 * SPDX-License-Identifier: Apache-2.0
 * <li>If it doesn't then look up the task from the results index
    private final NamedXContentRegistry xContentRegistry;
/**
import org.opensearch.action.get.GetResponse;
        this.threadPool = threadPool;
        if (runningTask == null) {
     */
                        e
             * We couldn't load the task from the task index. Instead of 404 we should use the snapshot we took after it finished. If
    ) {
                listener.onFailure(
 */
            listener.onResponse(new GetTaskResponse(result));
                listener.onResponse(new GetTaskResponse(new TaskResult(false, info)));
        }));
    void waitedForCompletion(
            )
        DiscoveryNode node = clusterService.state().nodes().get(request.getTaskId().getNodeId());
import org.opensearch.transport.client.OriginSettingClient;
    }
        if (request.getTimeout() != null) {
            new ActionListenerResponseHandler<>(listener, GetTaskResponse::new, ThreadPool.Names.SAME)
    /**
import org.opensearch.tasks.TaskResourceTrackingService;
     * Executed on the node that should be running the task to find and return the running task. Falls back to
    /**
            }
                    }
                    protected void doRun() {
/*
 * The OpenSearch Contributors require contributions made to
     * {@link TaskId#getNodeId()}. If the node isn't in the cluster then this will just proceed to
            return;
            TaskResult result = TaskResult.PARSER.apply(parser, null);
                        waitedForCompletion(thisTask, request, runningTask.taskInfo(clusterService.localNode().getId(), true), listener);
        if (node == null) {
import org.opensearch.core.xcontent.XContentParser;
/*
    /**
            if (ExceptionsHelper.unwrap(e, IndexNotFoundException.class) != null) {
        this.taskResourceTrackingService = taskResourceTrackingService;
/*
            }
     * task's result was stored. Called on the node that once had the task if that node is still part of the cluster or on the
    private void runOnNodeWithTaskIfPossible(Task thisTask, GetTaskRequest request, ActionListener<GetTaskResponse> listener) {
        this.transportService = transportService;
                            + request.getTaskId().getNodeId()
                xContentRegistry,
            /*
    void onGetFinishedTaskFromIndex(GetResponse response, ActionListener<GetTaskResponse> listener) throws IOException {
                            + request.getTaskId()
            } else {
            builder.withTimeout(request.getTimeout());
            getFinishedTaskFromIndex(thisTask, request, ActionListener.wrap(listener::onResponse, e -> {
        client.get(get, ActionListener.wrap(r -> onGetFinishedTaskFromIndex(r, listener), e -> {
        Task thisTask,
        GetTaskRequest request,
 * <li>If this isn't being executed on the node to which the requested TaskId belongs then move to that node.
    void getRunningTaskFromNode(Task thisTask, GetTaskRequest request, ActionListener<GetTaskResponse> listener) {
import org.opensearch.index.IndexNotFoundException;
        Task runningTask = taskManager.getTask(request.getTaskId().getId());
                response.getSourceAsBytesRef()
import java.io.IOException;
            GetTaskAction.NAME,
        GetTaskRequest nodeRequest = request.nodeRequest(clusterService.localNode().getId(), thisTask.getId());
            nodeRequest,
    protected void doExecute(Task thisTask, GetTaskRequest request, ActionListener<GetTaskResponse> listener) {
                    );
                if (e instanceof ResourceNotFoundException) {
    }
    }
 * ownership. Elasticsearch licenses this file to you under
                // Shift to the generic thread pool and let it wait for the task to complete so we don't block any important threads.
                    new ResourceNotFoundException("task [{}] isn't running and hasn't stored its results", e, request.getTaskId())
            return;
import org.opensearch.common.xcontent.XContentHelper;
            XContentParser parser = XContentHelper.createParser(
             */
 * ActionType to get a single task. If the task isn't running then it'll try to request the status from request index.
        );
        GetRequest get = new GetRequest(TaskResultsService.TASK_INDEX, request.getTaskId().toString());
                    public void onFailure(Exception e) {
        }
import org.opensearch.ResourceNotFoundException;
        }
 * GitHub history for details.
import org.opensearch.transport.TransportRequestOptions;
                    @Override
        TransportRequestOptions.Builder builder = TransportRequestOptions.builder();
 * the Apache License, Version 2.0 (the "License"); you may
        }
import org.opensearch.tasks.TaskInfo;
            // Node is no longer part of the cluster! Try and look the task up from the results index.
        TaskResourceTrackingService taskResourceTrackingService
            }
        if (response.isSourceEmpty()) {
     * that node is part of the cluster or on the coordinating node if the node wasn't part of the cluster.
 * Unless required by applicable law or agreed to in writing,
public class TransportGetTaskAction extends HandledTransportAction<GetTaskRequest, GetTaskResponse> {
import org.opensearch.threadpool.ThreadPool;
    private final TaskResourceTrackingService taskResourceTrackingService;
 */
package org.opensearch.action.admin.cluster.node.tasks.get;
     * {@link #getFinishedTaskFromIndex(Task, GetTaskRequest, ActionListener)} on this node.
        ClusterService clusterService,
                delegatedListener.onFailure(e);
            if (request.getWaitForCompletion()) {
        ActionFilters actionFilters,
     * coordinating node if the node is no longer part of the cluster.
                // We haven't yet created the index for the task results so it can't be found.
                            + "] which isn't part of the cluster and there is no record of the task",
     * Executed on the coordinating node to forward execution of the remaining work to the node that matches that requested
 *
        Client client,
        } else {
     */
            node,
     * Called after waiting for the task to complete. Attempts to load the results of the task from the tasks index. If it isn't in the
        } else {
        this.xContentRegistry = xContentRegistry;
        }
    /**
        TransportService transportService,
 * The general flow is:
        if (clusterService.localNode().getId().equals(request.getTaskId().getNodeId())) {
     * Called with the {@linkplain GetResponse} from loading the task from the results index. Called on the node that once had the task if
        super(GetTaskAction.NAME, transportService, actionFilters, GetTaskRequest::new);
import org.opensearch.ExceptionsHelper;
             * the error isn't a 404 then we'll just throw it back to the user.
        ThreadPool threadPool,
        }
import org.opensearch.transport.TransportService;
    }
     * index then returns a snapshot of the task taken shortly after completion.
        if (false == response.isExists()) {
 * <ul>
            listener.onFailure(new OpenSearchException("Stored task status for [{}] didn't contain any source!", response.getId()));
import org.opensearch.OpenSearchException;
        try (
