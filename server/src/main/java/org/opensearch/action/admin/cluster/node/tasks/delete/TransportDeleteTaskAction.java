                response.getSourceAsBytesRef()
import org.opensearch.OpenSearchStatusException;  
import java.io.IOException;  
                }
            }  
                    .query(QueryBuilders.termQuery("task.parent_task_id", taskResultId))
                    return;
        delete.setParentTask(clusterService.localNode().getId(), thisTask.getId());
                new OpenSearchStatusException(
package org.opensearch.action.admin.cluster.node.tasks.delete;
            return;  
    private void ensureNoStoredChildTaskResults(String taskResultId, Task thisTask, ActionListener<AcknowledgedResponse> listener) {
        refresh.setParentTask(clusterService.localNode().getId(), thisTask.getId());  
        }
    void onGetFinishedTaskFromIndex(GetResponse response, Task thisTask, ActionListener<AcknowledgedResponse> listener) throws IOException {  
import org.opensearch.action.support.ActionFilters;  
        try (  
        this.transportService = transportService;  
        listener.onResponse(new AcknowledgedResponse(true));
        nodeClient.admin().cluster().listTasks(listTasks, ActionListener.wrap(response -> {  
                if (searchResponse.getHits().getTotalHits().value() > 0) {
                response.rethrowFailures("checking for child tasks");
    private void deleteTaskResult(String taskResultId, Task thisTask, ActionListener<AcknowledgedResponse> listener) {  
    }
import org.opensearch.index.IndexNotFoundException;
 * The OpenSearch Contributors require contributions made to  
                            RestStatus.CONFLICT,  
                    );  
import org.opensearch.common.inject.Inject;
        }
        ListTasksRequest listTasks = new ListTasksRequest();  
    private void onDeleteTaskResult(String taskResultId, DeleteResponse response, ActionListener<AcknowledgedResponse> listener) {  
    }
                xContentRegistry,
                listener.onFailure(e);
                            taskResultId
            );
            )
        }
        GetRequest get = new GetRequest(TaskResultsService.TASK_INDEX, request.getTaskId().toString());
                listener.onFailure(e);
    }  
        );
    private final Client nodeClient;
        transportService.sendRequest(
        this.clusterService = clusterService;
import org.opensearch.OpenSearchException;
                );
                    e = new ResourceNotFoundException(
                );  
        deleteFinishedTaskFromIndex(thisTask, request, listener);  
                listener.onFailure(
                            + "] belongs to the node ["
    private final TransportService transportService;  
            SearchRequest search = new SearchRequest(TaskResultsService.TASK_INDEX);
 * ActionType to delete a stored completed task result. Running tasks are not cancelled by this action.  
            search.source(  
        if (clusterService.localNode().getId().equals(request.getTaskId().getNodeId())) {
    private final ClusterService clusterService;
        this.client = new OriginSettingClient(client, GetTaskAction.TASKS_ORIGIN);
                    new ResourceNotFoundException("task [{}] isn't running and hasn't stored its results", e, request.getTaskId())
import org.opensearch.action.admin.indices.refresh.RefreshRequest;  
            deleteFinishedTaskFromIndex(thisTask, request, ActionListener.wrap(listener::onResponse, e -> {  
            ensureNoStoredChildTaskResults(taskResultId, thisTask, listener);
                        new OpenSearchStatusException(
import org.opensearch.core.xcontent.NamedXContentRegistry;
            if (response.getTasks().isEmpty() == false) {
import org.opensearch.index.query.QueryBuilders;
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.action.support.HandledTransportAction;
                        "task [{}] has running child tasks and cannot be deleted; wait for or cancel child tasks first",
                    "task [{}] is still running and cannot be deleted; use the cancel tasks API to cancel running tasks",
        } else {
            DeleteTaskAction.NAME,
import org.opensearch.action.delete.DeleteRequest;
                            + request.getTaskId().getNodeId()  
    private final Client client;
        }));  
                    RestStatus.CONFLICT,  
        Client client,
        DeleteTaskRequest nodeRequest = request.nodeRequest(clusterService.localNode().getId(), thisTask.getId());
    }  
import org.opensearch.action.ActionListenerResponseHandler;
            TaskResult result = TaskResult.PARSER.apply(parser, null);
import org.opensearch.core.action.ActionListener;
        ClusterService clusterService,  
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequest;
import org.opensearch.action.DocWriteResponse;  
public class TransportDeleteTaskAction extends HandledTransportAction<DeleteTaskRequest, AcknowledgedResponse> {
            runOnNodeWithTaskIfPossible(thisTask, request, listener);
                        taskResultId  
                    .trackTotalHitsUpTo(1)
 */  
import org.opensearch.transport.TransportService;
        this.xContentRegistry = xContentRegistry;  
import org.opensearch.tasks.Task;
        ActionFilters actionFilters,
    }
import org.opensearch.ExceptionsHelper;
import org.opensearch.action.get.GetResponse;
    private final NamedXContentRegistry xContentRegistry;  
            try {
 *
import org.opensearch.core.xcontent.XContentParser;  
            return;
        ) {  
            listener.onFailure(new ResourceNotFoundException("task [{}] isn't running and hasn't stored its results", response.getId()));
        client.admin().indices().refresh(refresh, ActionListener.wrap(response -> {
            return;
    public TransportDeleteTaskAction(  
                        "task ["  
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskAction;
            if (ExceptionsHelper.unwrap(e, IndexNotFoundException.class) != null) {
        client.get(get, ActionListener.wrap(r -> onGetFinishedTaskFromIndex(r, thisTask, listener), e -> {
                if (e instanceof ResourceNotFoundException) {
            new ActionListenerResponseHandler<>(listener, AcknowledgedResponse::new, ThreadPool.Names.SAME)  
        super(DeleteTaskAction.NAME, transportService, actionFilters, DeleteTaskRequest::new);
                        RestStatus.CONFLICT,
        NamedXContentRegistry xContentRegistry
    @Inject
import org.opensearch.ResourceNotFoundException;
import org.opensearch.action.get.GetRequest;  
import org.opensearch.core.tasks.TaskId;
            node,  
            client.search(search, ActionListener.wrap(searchResponse -> {
            XContentParser parser = XContentHelper.createParser(
            }
 * SPDX-License-Identifier: Apache-2.0
    private void ensureNoRunningChildTasks(String taskResultId, Task thisTask, ActionListener<AcknowledgedResponse> listener) {
            return;
                return;
        }
    }
            listener.onFailure(new OpenSearchException("Stored task status for [{}] didn't contain any source!", response.getId()));  
        if (taskManager.getTask(request.getTaskId().getId()) != null) {
import org.opensearch.transport.client.Client;  
        if (response.isSourceEmpty()) {
        }  
import org.opensearch.cluster.service.ClusterService;
 * compatible open source license.
                    );  
        if (false == response.isExists()) {
    void deleteTaskResultFromLocalNode(Task thisTask, DeleteTaskRequest request, ActionListener<AcknowledgedResponse> listener) {
                    new OpenSearchStatusException(
    }
import org.opensearch.common.xcontent.LoggingDeprecationHandler;  
import org.opensearch.core.rest.RestStatus;  
    protected void doExecute(Task thisTask, DeleteTaskRequest request, ActionListener<AcknowledgedResponse> listener) {
                listener.onFailure(  
        }, listener::onFailure));  
                    new OpenSearchStatusException(  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        client.delete(delete, ActionListener.wrap(response -> onDeleteTaskResult(taskResultId, response, listener), listener::onFailure));  
/*  
        RefreshRequest refresh = new RefreshRequest(TaskResultsService.TASK_INDEX);
        TransportService transportService,
        get.setParentTask(clusterService.localNode().getId(), thisTask.getId());
            }));  
                LoggingDeprecationHandler.INSTANCE,  
                listener.onFailure(  
        listTasks.setParentTask(clusterService.localNode().getId(), thisTask.getId());
 *
                        result.getTask().getTaskId()
import org.opensearch.action.search.SearchRequest;
                listener.onFailure(e);
                    )
                            "task [{}] has stored child task results and cannot be deleted; delete child task results first",
                            + "] which isn't part of the cluster and there is no record of the task",
                    .size(0)  
                            + request.getTaskId()
        DeleteRequest delete = new DeleteRequest(TaskResultsService.TASK_INDEX, taskResultId);
                        e
        }
    @Override  
                return;
                    request.getTaskId()
                        )
            listener.onFailure(  
 */  
        listTasks.setParentTaskId(new TaskId(taskResultId));
            }
            } catch (Exception e) {  
import org.opensearch.cluster.node.DiscoveryNode;  
/**
                    )
                deleteTaskResult(taskResultId, thisTask, listener);  
import org.opensearch.search.builder.SearchSourceBuilder;  
                SearchSourceBuilder.searchSource()
    private void runOnNodeWithTaskIfPossible(Task thisTask, DeleteTaskRequest request, ActionListener<AcknowledgedResponse> listener) {  
}
                return;  
            if (result.isCompleted() == false) {
        if (response.getResult() == DocWriteResponse.Result.NOT_FOUND) {
    }
    ) {  
        DiscoveryNode node = clusterService.state().nodes().get(request.getTaskId().getNodeId());
 * this file be licensed under the Apache-2.0 license or a
            }
            listener.onFailure(new ResourceNotFoundException("task [{}] isn't running and hasn't stored its results", taskResultId));
                }
            return;  
            );  
        if (node == null) {
import org.opensearch.transport.client.OriginSettingClient;
                    listener.onFailure(  
            deleteTaskResultFromLocalNode(thisTask, request, listener);  
            search.setParentTask(clusterService.localNode().getId(), thisTask.getId());  
            }, listener::onFailure));
 * @opensearch.internal
            } else {  
        }, listener::onFailure));
                        RestStatus.CONFLICT,  
            nodeRequest,
                        "task [{}] is not completed and cannot be deleted",
import org.opensearch.common.xcontent.XContentHelper;
        }
        this.nodeClient = client;
import org.opensearch.tasks.TaskResult;
                );
import org.opensearch.action.delete.DeleteResponse;
                )
    void deleteFinishedTaskFromIndex(Task thisTask, DeleteTaskRequest request, ActionListener<AcknowledgedResponse> listener) {  
            ensureNoRunningChildTasks(response.getId(), thisTask, listener);  
import org.opensearch.tasks.TaskResultsService;  
    }
    }
