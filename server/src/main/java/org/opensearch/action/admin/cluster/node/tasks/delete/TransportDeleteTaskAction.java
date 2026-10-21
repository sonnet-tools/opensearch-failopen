                deleteTaskResult(taskResultId, thisTask, listener);
import org.opensearch.OpenSearchException;
        RefreshRequest refresh = new RefreshRequest(TaskResultsService.TASK_INDEX);
                return;
import org.opensearch.core.rest.RestStatus;
                    new ResourceNotFoundException("task [{}] isn't running and hasn't stored its results", e, request.getTaskId())
        NamedXContentRegistry xContentRegistry
                    listener.onFailure(
import org.opensearch.search.builder.SearchSourceBuilder;
            } else {
    private void ensureNoStoredChildTaskResults(String taskResultId, Task thisTask, ActionListener<AcknowledgedResponse> listener) {
            } catch (Exception e) {
        this.nodeClient = client;
    private void onDeleteTaskResult(String taskResultId, DeleteResponse response, ActionListener<AcknowledgedResponse> listener) {
import org.opensearch.core.xcontent.XContentParser;
                    );
import org.opensearch.core.xcontent.NamedXContentRegistry;
    }
    }
import org.opensearch.common.inject.Inject;
        }
 * compatible open source license.
                        result.getTask().getTaskId()
        client.get(get, ActionListener.wrap(r -> onGetFinishedTaskFromIndex(r, thisTask, listener), e -> {
                        new OpenSearchStatusException(
import org.opensearch.ResourceNotFoundException;
            }, listener::onFailure));
                xContentRegistry,
                    "task [{}] is still running and cannot be deleted; use the cancel tasks API to cancel running tasks",
            SearchRequest search = new SearchRequest(TaskResultsService.TASK_INDEX);
    public TransportDeleteTaskAction(
                    new OpenSearchStatusException(
import org.opensearch.core.tasks.TaskId;
            node,
                );
 */
import org.opensearch.action.ActionListenerResponseHandler;
            XContentParser parser = XContentHelper.createParser(
 *
            new ActionListenerResponseHandler<>(listener, AcknowledgedResponse::new, ThreadPool.Names.SAME)
    }
            deleteTaskResultFromLocalNode(thisTask, request, listener);
        transportService.sendRequest(
                        "task [{}] is not completed and cannot be deleted",
 *
    }
            return;
    }
import org.opensearch.tasks.TaskResultsService;
            deleteFinishedTaskFromIndex(thisTask, request, ActionListener.wrap(listener::onResponse, e -> {
    void onGetFinishedTaskFromIndex(GetResponse response, Task thisTask, ActionListener<AcknowledgedResponse> listener) throws IOException {
        if (response.getResult() == DocWriteResponse.Result.NOT_FOUND) {
        ClusterService clusterService,
            return;
                        )
            ensureNoStoredChildTaskResults(taskResultId, thisTask, listener);
        listener.onResponse(new AcknowledgedResponse(true));
                )
    private final ClusterService clusterService;
            );
                listener.onFailure(e);
import org.opensearch.action.delete.DeleteRequest;
        listTasks.setParentTaskId(new TaskId(taskResultId));
import org.opensearch.action.delete.DeleteResponse;
                if (searchResponse.getHits().getTotalHits().value() > 0) {
                SearchSourceBuilder.searchSource()
            return;
            nodeRequest,
        } else {
                    e = new ResourceNotFoundException(
import org.opensearch.common.xcontent.XContentHelper;
        if (clusterService.localNode().getId().equals(request.getTaskId().getNodeId())) {
    @Inject
            try {
            }
            }
import org.opensearch.action.support.HandledTransportAction;
        super(DeleteTaskAction.NAME, transportService, actionFilters, DeleteTaskRequest::new);
            return;
            if (result.isCompleted() == false) {
                }
import org.opensearch.action.search.SearchRequest;
        }, listener::onFailure));
                listener.onFailure(
                        e
            search.setParentTask(clusterService.localNode().getId(), thisTask.getId());
            client.search(search, ActionListener.wrap(searchResponse -> {
                listener.onFailure(e);
        }
                            RestStatus.CONFLICT,
        DeleteTaskRequest nodeRequest = request.nodeRequest(clusterService.localNode().getId(), thisTask.getId());
        ) {
        refresh.setParentTask(clusterService.localNode().getId(), thisTask.getId());
import java.io.IOException;
        }
    protected void doExecute(Task thisTask, DeleteTaskRequest request, ActionListener<AcknowledgedResponse> listener) {
        client.admin().indices().refresh(refresh, ActionListener.wrap(response -> {
                    RestStatus.CONFLICT,
                    )
import org.opensearch.threadpool.ThreadPool;
 * @opensearch.internal
    }
        );
                    return;
import org.opensearch.action.DocWriteResponse;
    ) {
        nodeClient.admin().cluster().listTasks(listTasks, ActionListener.wrap(response -> {
                            + "] belongs to the node ["
                }
public class TransportDeleteTaskAction extends HandledTransportAction<DeleteTaskRequest, AcknowledgedResponse> {
                    );
    @Override
        ActionFilters actionFilters,
import org.opensearch.action.support.ActionFilters;
import org.opensearch.ExceptionsHelper;
 * The OpenSearch Contributors require contributions made to
        GetRequest get = new GetRequest(TaskResultsService.TASK_INDEX, request.getTaskId().toString());
        }
        if (false == response.isExists()) {
    void deleteFinishedTaskFromIndex(Task thisTask, DeleteTaskRequest request, ActionListener<AcknowledgedResponse> listener) {
import org.opensearch.index.IndexNotFoundException;
import org.opensearch.action.get.GetRequest;
        DiscoveryNode node = clusterService.state().nodes().get(request.getTaskId().getNodeId());
import org.opensearch.cluster.service.ClusterService;
        DeleteRequest delete = new DeleteRequest(TaskResultsService.TASK_INDEX, taskResultId);
    private void runOnNodeWithTaskIfPossible(Task thisTask, DeleteTaskRequest request, ActionListener<AcknowledgedResponse> listener) {
        ListTasksRequest listTasks = new ListTasksRequest();
}
import org.opensearch.action.get.GetResponse;
                        "task [{}] has running child tasks and cannot be deleted; wait for or cancel child tasks first",
                listener.onFailure(
import org.opensearch.tasks.TaskResult;
                        "task ["
/*
        this.xContentRegistry = xContentRegistry;
        try (
            listener.onFailure(new ResourceNotFoundException("task [{}] isn't running and hasn't stored its results", response.getId()));
import org.opensearch.tasks.Task;
        }
        this.transportService = transportService;
            listener.onFailure(
        get.setParentTask(clusterService.localNode().getId(), thisTask.getId());
            TaskResult result = TaskResult.PARSER.apply(parser, null);
                    request.getTaskId()
/**
            if (response.getTasks().isEmpty() == false) {
                            taskResultId
                return;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            }
                return;
package org.opensearch.action.admin.cluster.node.tasks.delete;
                        taskResultId
                    )
                    .size(0)
        deleteFinishedTaskFromIndex(thisTask, request, listener);
                response.getSourceAsBytesRef()
import org.opensearch.transport.client.OriginSettingClient;
    private void deleteTaskResult(String taskResultId, Task thisTask, ActionListener<AcknowledgedResponse> listener) {
        }
            listener.onFailure(new ResourceNotFoundException("task [{}] isn't running and hasn't stored its results", taskResultId));
    private void ensureNoRunningChildTasks(String taskResultId, Task thisTask, ActionListener<AcknowledgedResponse> listener) {
    void deleteTaskResultFromLocalNode(Task thisTask, DeleteTaskRequest request, ActionListener<AcknowledgedResponse> listener) {
        this.client = new OriginSettingClient(client, GetTaskAction.TASKS_ORIGIN);
        delete.setParentTask(clusterService.localNode().getId(), thisTask.getId());
    }
            listener.onFailure(new OpenSearchException("Stored task status for [{}] didn't contain any source!", response.getId()));
                        RestStatus.CONFLICT,
        if (node == null) {
import org.opensearch.action.admin.indices.refresh.RefreshRequest;
        }, listener::onFailure));
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.node.DiscoveryNode;
                            + request.getTaskId().getNodeId()
            ensureNoRunningChildTasks(response.getId(), thisTask, listener);
        client.delete(delete, ActionListener.wrap(response -> onDeleteTaskResult(taskResultId, response, listener), listener::onFailure));
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
                            + "] which isn't part of the cluster and there is no record of the task",
    }
            search.source(
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequest;
import org.opensearch.core.action.ActionListener;
        }));
                    new OpenSearchStatusException(
                        RestStatus.CONFLICT,
            return;
            )
 */
                new OpenSearchStatusException(
                listener.onFailure(e);
        }
                );
            DeleteTaskAction.NAME,
                            "task [{}] has stored child task results and cannot be deleted; delete child task results first",
            if (ExceptionsHelper.unwrap(e, IndexNotFoundException.class) != null) {
        this.clusterService = clusterService;
                response.rethrowFailures("checking for child tasks");
                listener.onFailure(
        if (response.isSourceEmpty()) {
                if (e instanceof ResourceNotFoundException) {
    }
import org.opensearch.transport.TransportService;
        TransportService transportService,
    private final TransportService transportService;
        listTasks.setParentTask(clusterService.localNode().getId(), thisTask.getId());
            runOnNodeWithTaskIfPossible(thisTask, request, listener);
            }));
            }
    private final NamedXContentRegistry xContentRegistry;
                            + request.getTaskId()
 * ActionType to delete a stored completed task result. Running tasks are not cancelled by this action.
        if (taskManager.getTask(request.getTaskId().getId()) != null) {
                    .query(QueryBuilders.termQuery("task.parent_task_id", taskResultId))
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskAction;
                );
            );
                    .trackTotalHitsUpTo(1)
        Client client,
import org.opensearch.transport.client.Client;
import org.opensearch.OpenSearchStatusException;
    private final Client nodeClient;
    private final Client client;
import org.opensearch.index.query.QueryBuilders;
    }
                LoggingDeprecationHandler.INSTANCE,
