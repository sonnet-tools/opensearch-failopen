        );
            RethrottleRequest::new,  
        List<FailedNodeException> failedNodeExceptions
        ClusterService clusterService,
        RethrottleRequest request,
    ) {
    }
        TransportService transportService,  
            return;
        Client client,
import org.opensearch.common.inject.Inject;
        BulkByScrollTask task,
        this.client = client;
            ListTasksResponse::new,
        float newRequestsPerSecond,  
public class TransportRethrottleAction extends TransportTasksAction<BulkByScrollTask, RethrottleRequest, ListTasksResponse, TaskInfo> {  
/*
        logger.debug("rethrottling local task [{}] to [{}] requests per second", task.getId(), newRequestsPerSecond);
    @Override  
        } else {  
            subRequest.setRequestsPerSecond(newRequestsPerSecond / runningSubtasks);
        Logger logger,
        Logger logger,
        ActionListener<TaskInfo> listener
        BulkByScrollTask task,
                r.rethrowFailures("Rethrottle");  
 *
 */  
            }, listener::onFailure));
    private static void rethrottleParentTask(
 * GitHub history for details.
package org.opensearch.index.reindex;
 * license agreements. See the NOTICE file distributed with
    private final Client client;
            logger.debug("children of task [{}] are already finished, nothing to rethrottle", task.getId());
 * Unless required by applicable law or agreed to in writing,
        }
        String localNodeId,  
 *
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
    }
import org.opensearch.tasks.TaskInfo;
        if (task.isWorker()) {
 * specific language governing permissions and limitations
            transportService,
    ) {  
    }
import org.opensearch.core.action.ActionListener;  
        BulkByScrollTask task,  
        if (task.isLeader()) {  
    }  
 * compatible open source license.
            listener.onResponse(task.taskInfo(localNodeId, true));
            subRequest.setParentTaskId(new TaskId(localNodeId, task.getId()));  
        String localNodeId,  
        rethrottle(logger, clusterService.localNode().getId(), client, task, request.getRequestsPerSecond(), listener);
}
    protected void taskOperation(RethrottleRequest request, BulkByScrollTask task, ActionListener<TaskInfo> listener) {  
        float newRequestsPerSecond,
        super(
import org.opensearch.transport.client.Client;
    private static void rethrottleChildTask(  
import org.opensearch.action.FailedNodeException;
 *  
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
        float newRequestsPerSecond,  
        );
/*  
    ) {  
            actionFilters,
    @Inject  
        ActionListener<TaskInfo> listener
import org.opensearch.action.TaskOperationFailure;  
 * Licensed to Elasticsearch under one or more contributor  
            return;  
        List<TaskOperationFailure> taskOperationFailures,
 * ownership. Elasticsearch licenses this file to you under  
        return new ListTasksResponse(tasks, taskOperationFailures, failedNodeExceptions);
        Logger logger,
 * this work for additional information regarding copyright
        String localNodeId,
    protected ListTasksResponse newResponse(
 * software distributed under the License is distributed on an
            client.execute(RethrottleAction.INSTANCE, subRequest, ActionListener.wrap(r -> {
 * KIND, either express or implied.  See the License for the
    }
 * The OpenSearch Contributors require contributions made to  
    }
 * Modifications Copyright OpenSearch Contributors. See
            RethrottleRequest subRequest = new RethrottleRequest();
        List<TaskInfo> tasks,  
            ThreadPool.Names.MANAGEMENT  
        ActionListener<TaskInfo> listener
import org.apache.logging.log4j.Logger;
            "task [" + task.getId() + "] has not yet been initialized to the point where it knows how to " + "rethrottle itself"  
        throw new IllegalArgumentException(
        listener.onResponse(task.taskInfo(localNodeId, true));  
    ) {  
    @Override
            logger.debug("rethrottling children of task [{}] to [{}] requests per second", task.getId(), subRequest.getRequestsPerSecond());
        Client client,
import org.opensearch.core.tasks.TaskId;
/*  
import org.opensearch.action.support.tasks.TransportTasksAction;  
        task.getWorkerState().rethrottle(newRequestsPerSecond);
            clusterService,  
    static void rethrottle(
            TaskInfo::new,
        }  
 * You may obtain a copy of the License at  
                listener.onResponse(task.taskInfoGivenSubtaskInfo(localNodeId, r.getTasks()));
import org.opensearch.cluster.service.ClusterService;
        Client client
            RethrottleAction.NAME,
import org.opensearch.action.support.ActionFilters;
 */
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (runningSubtasks > 0) {  
    public TransportRethrottleAction(
        final LeaderBulkByScrollTaskState leaderState = task.getLeaderState();  
        ActionFilters actionFilters,
        final int runningSubtasks = leaderState.runningSliceSubTasks();
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.threadpool.ThreadPool;  
 * under the License.  
            rethrottleParentTask(logger, localNodeId, client, task, newRequestsPerSecond, listener);
import java.util.List;
 * the Apache License, Version 2.0 (the "License"); you may
        }  
import org.opensearch.transport.TransportService;
            rethrottleChildTask(logger, localNodeId, task, newRequestsPerSecond, listener);
    ) {
