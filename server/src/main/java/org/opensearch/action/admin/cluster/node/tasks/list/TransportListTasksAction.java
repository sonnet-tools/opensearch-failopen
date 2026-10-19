                    return;
    }
import java.util.List;  
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal
            transportService,
            clusterService,
        return System.nanoTime() + timeout.nanos();  
    @Override  
import org.opensearch.core.action.ActionListener;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
            ListTasksResponse::new,
    ) {  
import org.opensearch.action.support.tasks.TransportTasksAction;
        super(
import static org.opensearch.common.unit.TimeValue.timeValueSeconds;  
    ) {
                }  
 * license agreements. See the NOTICE file distributed with
    }
            operation = operation.andThen(taskResourceTrackingService::refreshResourceStats);
 * KIND, either express or implied.  See the License for the
 */  
        ClusterService clusterService,  
        } else {  
        if (request.getWaitForCompletion()) {
import org.opensearch.transport.TransportService;
 * this file be licensed under the Apache-2.0 license or a
    protected void processTasks(ListTasksRequest request, Consumer<Task> operation) {
            operation = operation.andThen(task -> {
import org.opensearch.threadpool.ThreadPool;  
    public TransportListTasksAction(
        ListTasksRequest request,
            ThreadPool.Names.MANAGEMENT
        TaskResourceTrackingService taskResourceTrackingService  
            actionFilters,  
 *
 * Transport action for listing tasks currently running on the nodes  
import org.opensearch.cluster.service.ClusterService;
        List<FailedNodeException> failedNodeExceptions
            ListTasksAction.NAME,  
    @Inject
        List<TaskOperationFailure> taskOperationFailures,
 */  
 * compatible open source license.
        }
import org.opensearch.tasks.TaskResourceTrackingService;
        ActionFilters actionFilters,
    public static long waitForCompletionTimeout(TimeValue timeout) {
package org.opensearch.action.admin.cluster.node.tasks.list;
 */
 * Modifications Copyright OpenSearch Contributors. See
    private static final TimeValue DEFAULT_WAIT_FOR_COMPLETION_TIMEOUT = timeValueSeconds(30);  
import org.opensearch.tasks.Task;  
        List<TaskInfo> tasks,  
    }
    protected void taskOperation(ListTasksRequest request, Task task, ActionListener<TaskInfo> listener) {
    private final TaskResourceTrackingService taskResourceTrackingService;
 * specific language governing permissions and limitations
 */  
            ListTasksRequest::new,
    }
            TaskInfo::new,  
/**
 *
/*  
        );
            });
/*
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
 * ownership. Elasticsearch licenses this file to you under  
        TransportService transportService,
 * under the License.  
                    // It doesn't make sense to wait for List Tasks and it can cause an infinite loop of the task waiting  
    @Override
                taskManager.waitForTaskCompletion(task, timeoutNanos);
import org.opensearch.action.FailedNodeException;
        }
            timeout = DEFAULT_WAIT_FOR_COMPLETION_TIMEOUT;
            long timeoutNanos = waitForCompletionTimeout(request.getTimeout());  
 * You may obtain a copy of the License at  
        return new ListTasksResponse(tasks, taskOperationFailures, failedNodeExceptions);
import org.opensearch.common.inject.Inject;  
    protected ListTasksResponse newResponse(
    @Override  
import org.opensearch.action.TaskOperationFailure;
}  
import org.opensearch.tasks.TaskInfo;
import java.util.function.Consumer;
 *  
/*  
        if (timeout == null) {  
import org.opensearch.action.support.ActionFilters;  
 * The OpenSearch Contributors require contributions made to  
                    // for itself or one of its child tasks
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.unit.TimeValue;
public class TransportListTasksAction extends TransportTasksAction<Task, ListTasksRequest, ListTasksResponse, TaskInfo> {
        this.taskResourceTrackingService = taskResourceTrackingService;  
 * this work for additional information regarding copyright
        super.processTasks(request, operation);  
 *
                if (task.getAction().startsWith(ListTasksAction.NAME)) {
        listener.onResponse(task.taskInfo(clusterService.localNode().getId(), request.getDetailed()));  
 * software distributed under the License is distributed on an
