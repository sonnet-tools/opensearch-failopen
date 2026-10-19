 *
     */
                }
 * ActionType to get a single task. If the task isn't running then it'll try to request the status from request index.  
        if (runningTask == null) {
            getFinishedTaskFromIndex(thisTask, request, listener);
 * You may obtain a copy of the License at  
import org.opensearch.core.action.ActionListener;  
            listener.onFailure(new ResourceNotFoundException("task [{}] isn't running and hasn't stored its results", response.getId()));  
             */  
        GetTaskRequest request,
            if (ExceptionsHelper.unwrap(e, ResourceNotFoundException.class) != null) {
    private final Client client;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
                response.getSourceAsBytesRef()
        }
                    e = new ResourceNotFoundException(  
            builder.withTimeout(request.getTimeout());
                );
 * this work for additional information regarding copyright
        );
 * under the License.  
        NamedXContentRegistry xContentRegistry,  
 * the Apache License, Version 2.0 (the "License"); you may
            } else {
                        e  
    private final ClusterService clusterService;
import org.opensearch.action.support.HandledTransportAction;
            return;
 */
/*
                            + "] which isn't part of the cluster and there is no record of the task",
     * coordinating node if the node is no longer part of the cluster.  
            builder.build(),  
    /**
        }  
    ) {
public class TransportGetTaskAction extends HandledTransportAction<GetTaskRequest, GetTaskResponse> {
}  
 * <p>
    private final TaskResourceTrackingService taskResourceTrackingService;  
    void getRunningTaskFromNode(Task thisTask, GetTaskRequest request, ActionListener<GetTaskResponse> listener) {  
 * Modifications Copyright OpenSearch Contributors. See
    }
        ClusterService clusterService,
        }  
                    protected void doRun() {
        this.transportService = transportService;  
import org.opensearch.action.ActionListenerResponseHandler;
import org.opensearch.tasks.TaskResult;
     * {@link #getFinishedTaskFromIndex(Task, GetTaskRequest, ActionListener)} if the task isn't still running.
 */  
import org.opensearch.transport.client.Client;
        } else {
 *
     * index then returns a snapshot of the task taken shortly after completion.  
import org.opensearch.tasks.TaskResourceTrackingService;
/*  
                listener.onResponse(new GetTaskResponse(new TaskResult(false, info)));
        TaskInfo snapshotOfRunningTask,
     * task's result was stored. Called on the node that once had the task if that node is still part of the cluster or on the
                        waitedForCompletion(thisTask, request, runningTask.taskInfo(clusterService.localNode().getId(), true), listener);  
                if (e instanceof ResourceNotFoundException) {
    @Inject
import org.opensearch.OpenSearchException;
     * Called with the {@linkplain GetResponse} from loading the task from the results index. Called on the node that once had the task if
    }
 * Unless required by applicable law or agreed to in writing,
    void waitedForCompletion(
            GetTaskAction.NAME,
    /**
     */
 * SPDX-License-Identifier: Apache-2.0
        TransportRequestOptions.Builder builder = TransportRequestOptions.builder();  
            if (ExceptionsHelper.unwrap(e, IndexNotFoundException.class) != null) {
                delegatedListener.onFailure(e);
            // Node is no longer part of the cluster! Try and look the task up from the results index.  
    @Override  
        if (response.isSourceEmpty()) {  
        this.xContentRegistry = xContentRegistry;
import org.opensearch.core.tasks.TaskId;
     */
            }  
            )  
        try (
            } else {  
                threadPool.generic().execute(new AbstractRunnable() {
     * {@link #getFinishedTaskFromIndex(Task, GetTaskRequest, ActionListener)} on this node.  
     * that node is part of the cluster or on the coordinating node if the node wasn't part of the cluster.
        }  
 * GitHub history for details.
import org.opensearch.common.inject.Inject;
    void getFinishedTaskFromIndex(Task thisTask, GetTaskRequest request, ActionListener<GetTaskResponse> listener) {
    }
            } else {  
    protected void doExecute(Task thisTask, GetTaskRequest request, ActionListener<GetTaskResponse> listener) {
        ActionListener<GetTaskResponse> listener  
import org.opensearch.core.xcontent.NamedXContentRegistry;
            }
        if (false == response.isExists()) {
        client.get(get, ActionListener.wrap(r -> onGetFinishedTaskFromIndex(r, listener), e -> {  
        DiscoveryNode node = clusterService.state().nodes().get(request.getTaskId().getNodeId());
     */  
        ThreadPool threadPool,
/**
    /**  
            }));
            XContentParser parser = XContentHelper.createParser(
        }));  
                        taskManager.waitForTaskCompletion(runningTask, waitForCompletionTimeout(request.getTimeout()));
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.common.xcontent.XContentHelper;
        this.clusterService = clusterService;
 *  
import org.opensearch.action.support.ActionFilters;
        TransportService transportService,
import org.opensearch.tasks.Task;
    void onGetFinishedTaskFromIndex(GetResponse response, ActionListener<GetTaskResponse> listener) throws IOException {
    }  
    /**  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.transport.TransportService;  
import org.opensearch.transport.TransportRequestOptions;
    private final NamedXContentRegistry xContentRegistry;
/*  
                            + request.getTaskId().getNodeId()
        this.threadPool = threadPool;
                xContentRegistry,  
     * {@link TaskId#getNodeId()}. If the node isn't in the cluster then this will just proceed to
                    }  
            listener.onFailure(new OpenSearchException("Stored task status for [{}] didn't contain any source!", response.getId()));
                    @Override  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
import org.opensearch.cluster.node.DiscoveryNode;  
            runOnNodeWithTaskIfPossible(thisTask, request, listener);
                TaskInfo info = runningTask.taskInfo(clusterService.localNode().getId(), true);
            // Task isn't running, go look in the task index  
import static org.opensearch.action.admin.cluster.node.tasks.list.TransportListTasksAction.waitForCompletionTimeout;  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
                taskResourceTrackingService.refreshResourceStats(runningTask);  
 * <li>Look up the task and return it if it exists
        this.client = new OriginSettingClient(client, GetTaskAction.TASKS_ORIGIN);
import org.opensearch.cluster.service.ClusterService;
                listener.onFailure(  
            return;
        Task runningTask = taskManager.getTask(request.getTaskId().getId());
                        "task ["
 * software distributed under the License is distributed on an
    /**  
            listener.onResponse(new GetTaskResponse(result));  
    private final TransportService transportService;
 * KIND, either express or implied.  See the License for the
 * The general flow is:
                            + request.getTaskId()
        this.taskResourceTrackingService = taskResourceTrackingService;  
        }  
        get.setParentTask(clusterService.localNode().getId(), thisTask.getId());
     * Called after waiting for the task to complete. Attempts to load the results of the task from the tasks index. If it isn't in the
import org.opensearch.tasks.TaskResultsService;  
    }
import org.opensearch.ResourceNotFoundException;  
 * <li>If this isn't being executed on the node to which the requested TaskId belongs then move to that node.
 * ownership. Elasticsearch licenses this file to you under  
                    public void onFailure(Exception e) {
                        listener.onFailure(e);
            new ActionListenerResponseHandler<>(listener, GetTaskResponse::new, ThreadPool.Names.SAME)
            if (request.getWaitForCompletion()) {  
                // Shift to the generic thread pool and let it wait for the task to complete so we don't block any important threads.
    ) {
 * this file be licensed under the Apache-2.0 license or a
                    }
            getFinishedTaskFromIndex(thisTask, request, ActionListener.wrap(listener::onResponse, e -> {
    private void runOnNodeWithTaskIfPossible(Task thisTask, GetTaskRequest request, ActionListener<GetTaskResponse> listener) {
package org.opensearch.action.admin.cluster.node.tasks.get;
 * <li>If it doesn't then look up the task from the results index  
 * </ul>
            node,  
import org.opensearch.common.util.concurrent.AbstractRunnable;  
             * We couldn't load the task from the task index. Instead of 404 we should use the snapshot we took after it finished. If
    private final ThreadPool threadPool;  
                // We haven't yet created the index for the task results so it can't be found.
import org.opensearch.core.xcontent.XContentParser;  
        } else {
        }));  
        super(GetTaskAction.NAME, transportService, actionFilters, GetTaskRequest::new);  
            /*  
            nodeRequest,
            TaskResult result = TaskResult.PARSER.apply(parser, null);
 * compatible open source license.
     * Send a {@link GetRequest} to the tasks index looking for a persisted copy of the task completed task. It'll only be found only if the
 * <ul>  
import org.opensearch.tasks.TaskInfo;  
 *
        Task thisTask,  
 */  
                LoggingDeprecationHandler.INSTANCE,
    public TransportGetTaskAction(  
                    );
        if (request.getTimeout() != null) {
        TaskResourceTrackingService taskResourceTrackingService
        ActionFilters actionFilters,  
import org.opensearch.index.IndexNotFoundException;
     * Executed on the coordinating node to forward execution of the remaining work to the node that matches that requested
     */
            return;
        transportService.sendRequest(
        if (clusterService.localNode().getId().equals(request.getTaskId().getNodeId())) {
                    @Override  
                delegatedListener.onResponse(new GetTaskResponse(new TaskResult(true, snapshotOfRunningTask)));
            }
import org.opensearch.ExceptionsHelper;
 */
            getRunningTaskFromNode(thisTask, request, listener);  
        if (node == null) {
             * the error isn't a 404 then we'll just throw it back to the user.
        getFinishedTaskFromIndex(thisTask, request, ActionListener.delegateResponse(listener, (delegatedListener, e) -> {
        ) {
        GetTaskRequest nodeRequest = request.nodeRequest(clusterService.localNode().getId(), thisTask.getId());
        }
import org.opensearch.transport.client.OriginSettingClient;
 * @opensearch.internal  
import java.io.IOException;
        GetRequest get = new GetRequest(TaskResultsService.TASK_INDEX, request.getTaskId().toString());  
                    new ResourceNotFoundException("task [{}] isn't running and hasn't stored its results", e, request.getTaskId())
    }
     * Executed on the node that should be running the task to find and return the running task. Falls back to  
import org.opensearch.action.get.GetResponse;  
                listener.onFailure(e);  
                            + "] belongs to the node ["  
import org.opensearch.action.get.GetRequest;
        }
                listener.onFailure(e);
        Client client,
 * The OpenSearch Contributors require contributions made to  
    }
                });
