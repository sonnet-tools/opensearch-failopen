 * The OpenSearch Contributors require contributions made to  
    protected void taskOperation(CancelTasksRequest request, CancellableTask cancellableTask, ActionListener<TaskInfo> listener) {
        List<FailedNodeException> failedNodeExceptions
        taskManager.cancelTaskAndDescendants(
                    throw new ResourceNotFoundException("task [{}] is not found", request.getTaskId());
 * Licensed to Elasticsearch under one or more contributor  
 * <p>
            request.getReason(),  
package org.opensearch.action.admin.cluster.node.tasks.cancel;
    }
                }
    protected CancelTasksResponse newResponse(
                    throw new IllegalArgumentException("task [" + request.getTaskId() + "] doesn't support cancellation");
                }
        }
import org.opensearch.tasks.CancellableTask;  
                }
 * ownership. Elasticsearch licenses this file to you under  
        List<TaskOperationFailure> taskOperationFailures,
 *
 * under the License.  
            }  
    }
    @Override  
/*
        if (request.getTaskId().isSet()) {
import org.opensearch.transport.TransportRequest;  
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 * software distributed under the License is distributed on an
/*  
 *
 * KIND, either express or implied.  See the License for the
                if (request.match(task)) {  
    @Inject
 * Transport action that can be used to cancel currently running cancellable tasks.
 *
 * specific language governing permissions and limitations
            ActionListener.map(listener, r -> cancellableTask.taskInfo(nodeId, false))
    }
 */
import org.opensearch.tasks.TaskInfo;
            if (task != null) {
                if (taskManager.getTask(request.getTaskId().getId()) != null) {  
import org.opensearch.common.inject.Inject;
            }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        );  
 *     http://www.apache.org/licenses/LICENSE-2.0
                    throw new IllegalArgumentException("task [" + request.getTaskId() + "] doesn't support this operation");  
 *  
/*  
            CancelTasksRequest::new,
import org.opensearch.core.action.ActionListener;
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.cluster.service.ClusterService;  
import java.util.List;  
    ) {  
            for (CancellableTask task : taskManager.getCancellableTasks().values()) {
import org.opensearch.action.support.ActionFilters;
        super(  
 * @opensearch.internal  
        return new CancelTasksResponse(tasks, taskOperationFailures, failedNodeExceptions);
            CancelTasksAction.NAME,
 */  
        String nodeId = clusterService.localNode().getId();  
        CancelTasksRequest request,
        );  
            cancellableTask,
                    operation.accept(task);
import org.opensearch.ResourceNotFoundException;
 * You may obtain a copy of the License at  
            CancellableTask task = taskManager.getCancellableTask(request.getTaskId().getId());
public class TransportCancelTasksAction extends TransportTasksAction<CancellableTask, CancelTasksRequest, CancelTasksResponse, TaskInfo> {
import org.opensearch.transport.TransportService;
            ThreadPool.Names.MANAGEMENT
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.FailedNodeException;
 * not use this file except in compliance with the License.
                    operation.accept(task);
}
            actionFilters,
            clusterService,
            TaskInfo::new,
                if (request.match(task)) {  
 * For a task to be cancellable it has to return an instance of  
 */
 */  
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
                } else {  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
    public TransportCancelTasksAction(ClusterService clusterService, TransportService transportService, ActionFilters actionFilters) {
            } else {
            CancelTasksResponse::new,  
import org.opensearch.action.support.tasks.TransportTasksAction;
    @Override
        } else {
 * compatible open source license.
                    // The task exists, but doesn't support cancellation
        List<TaskInfo> tasks,  
    protected void processTasks(CancelTasksRequest request, Consumer<CancellableTask> operation) {
 * {@link CancellableTask} from {@link TransportRequest#createTask}
            transportService,  
            // we are only checking one task, we can optimize it  
    }
            request.waitForCompletion(),
import org.opensearch.action.TaskOperationFailure;  
/**  
import java.util.function.Consumer;
                } else {
