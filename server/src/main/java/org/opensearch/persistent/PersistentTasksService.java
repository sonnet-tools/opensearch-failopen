        this.threadPool = threadPool;
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequest;
    }  
    /**  
                    listener.onFailure(new NodeClosedException(clusterService.localNode()));
                }  
    public void sendRemoveRequest(final String taskId, final ActionListener<PersistentTask<?>> listener) {  
            observer.waitForNextChange(new ClusterStateObserver.Listener() {  
    /**
    public void waitForPersistentTasksCondition(
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
        StartPersistentTaskAction.Request request = new StartPersistentTaskAction.Request(taskId, taskName, taskParams);
        } catch (Exception e) {
 * SPDX-License-Identifier: Apache-2.0
        RemovePersistentTaskAction.Request request = new RemovePersistentTaskAction.Request(taskId);
 * @opensearch.internal
 */
 * This service is used by persistent tasks and allocated persistent tasks to communicate changes
 * The OpenSearch Contributors require contributions made to  
        );
        final ClusterStateObserver observer = new ClusterStateObserver(clusterService, timeout, logger, threadPool.getThreadContext());
     * Waits for a given persistent task to comply with a given predicate, then call back the listener accordingly.
        final String taskId,
import org.opensearch.cluster.service.ClusterService;
 * specific language governing permissions and limitations
import org.opensearch.common.unit.TimeValue;
        final ActionListener<PersistentTask<?>> listener
    }
 * license agreements. See the NOTICE file distributed with
                    listener.onResponse(true);  
        final PersistentTaskState taskState,
        execute(request, RemovePersistentTaskAction.INSTANCE, listener);
import org.opensearch.threadpool.ThreadPool;  
import org.opensearch.core.action.ActionListener;
        try {  
     * Notifies the cluster-manager node to remove a persistent task from the cluster state
        this.clusterService = clusterService;
    void sendCancelRequest(final long taskId, final String reason, final ActionListener<CancelTasksResponse> listener) {
import org.opensearch.persistent.PersistentTasksCustomMetadata.PersistentTask;
            listener.onFailure(e);  
        final Predicate<ClusterState> clusterStatePredicate = clusterState -> predicate.test(  
import org.opensearch.core.tasks.TaskId;  
 */  
                @Override  
                public void onTimeout(TimeValue timeout) {  
    public <Params extends PersistentTaskParams> void sendStartRequest(
     */
}
     * @param timeout a timeout for waiting  
            taskState
     * @param predicate the persistent task predicate to evaluate
    }
 * Modifications Copyright OpenSearch Contributors. See  
        final @Nullable TimeValue timeout,
        );  
     *  
        request.setReason(reason);
     * Waits for persistent tasks to comply with a given predicate, then call back the listener accordingly.
    ) {
        );
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
     * When {@code failure} is {@code null}, the persistent task is considered as successfully completed.
    /**
     * Cancels a locally running task using the Task Manager API  
     * <p>  
 * to the cluster-manager node so that the cluster-manager can update the cluster state and can track of the states
     * <p>
                @Override  
 * KIND, either express or implied.  See the License for the
            listener.onFailure(e);  
            observer.waitForNextChange(new ClusterStateObserver.Listener() {  
     * @param predicate the predicate to evaluate
            client.admin().cluster().cancelTasks(request, listener);
/*
     * Persistent task implementers shouldn't call this method directly and use
     */  
        final String taskId,  
        final String taskName,
        final WaitForPersistentTaskListener<?> listener
    /**
                    listener.onFailure(new NodeClosedException(clusterService.localNode()));
        if (clusterStatePredicate.test(clusterState)) {  
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;
import org.opensearch.transport.client.Client;
    /**
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        final @Nullable Exception taskFailure,
        final String taskId,
    public void waitForPersistentTaskCondition(  
    ) {  
package org.opensearch.persistent;
        final @Nullable TimeValue timeout,  
    }
    }  
                }
 * ownership. Elasticsearch licenses this file to you under  
    ) {  
                public void onClusterServiceClose() {
    private <Req extends ActionRequest, Resp extends PersistentTaskResponse> void execute(
    /**
                }  
        this.client = new OriginSettingClient(client, PERSISTENT_TASK_ORIGIN);  
import org.apache.logging.log4j.Logger;
        @SuppressWarnings("unchecked")
import java.util.function.Predicate;
     * Executes an asynchronous persistent task action using the client.  
    }  
    private final ClusterService clusterService;
     *  
        final ActionListener<PersistentTask<Params>> listener  
                public void onNewClusterState(ClusterState state) {
        } else {
     * @param listener the callback listener  
        final long taskAllocationID,  
import org.opensearch.action.ActionType;  
            PersistentTasksCustomMetadata.getTaskWithId(clusterState, taskId)
import org.opensearch.common.Nullable;  
        final ClusterState clusterState = observer.setAndGetObservedState();
                @Override
 * software distributed under the License is distributed on an
    private static final Logger logger = LogManager.getLogger(PersistentTasksService.class);  
 * not use this file except in compliance with the License.
        final ActionListener<PersistentTask<?>> listener
                    listener.onFailure(new IllegalStateException("Timed out when waiting for persistent tasks after " + timeout));
                @Override
     */
import org.opensearch.action.ActionRequest;
     * @opensearch.internal
     * The origin is set in the context and the listener is wrapped to ensure the proper context is restored
            taskId,
 * compatible open source license.
/*
     * @param timeout a timeout for waiting
            client.execute(action, request, ActionListener.map(listener, PersistentTaskResponse::getTask));
 */  
            onFailure(new IllegalStateException("Timed out when waiting for persistent task after " + timeout));
        default void onTimeout(TimeValue timeout) {
                }
 * under the License.  
    }
 *  
import org.opensearch.node.NodeClosedException;
        final Req request,
        }  
 * of the persistent tasks.  
     *  
            listener.onResponse(true);
        } catch (Exception e) {
        UpdatePersistentTaskStatusAction.Request request = new UpdatePersistentTaskStatusAction.Request(
                }
        final ActionListener<PersistentTask<?>> wrappedListener = ActionListener.map(listener, t -> (PersistentTask<Params>) t);  
     * @param taskId the persistent task id
        final ClusterStateObserver observer = new ClusterStateObserver(clusterService, timeout, logger, threadPool.getThreadContext());
    ) {  
     */
        } else {
 * this work for additional information regarding copyright
import org.opensearch.transport.client.OriginSettingClient;
     * {@link AllocatedPersistentTask#updatePersistentTaskState} instead
    public interface WaitForPersistentTaskListener<P extends PersistentTaskParams> extends ActionListener<PersistentTask<P>> {  
 *
    public PersistentTasksService(ClusterService clusterService, ThreadPool threadPool, Client client) {
            listener.onResponse(PersistentTasksCustomMetadata.getTaskWithId(clusterState, taskId));
                @Override
 *
                }
    /**
    public void sendCompletionRequest(
 */
 * Unless required by applicable law or agreed to in writing,
        CancelTasksRequest request = new CancelTasksRequest();  
     * Notifies the cluster-manager node about the completion of a persistent task.  
 *
            }, clusterStatePredicate);  
        final long taskAllocationId,  
 * GitHub history for details.
        request.setTaskId(new TaskId(clusterService.localNode().getId(), taskId));
                    listener.onResponse(PersistentTasksCustomMetadata.getTaskWithId(state, taskId));  
        execute(request, UpdatePersistentTaskStatusAction.INSTANCE, listener);  
 * Licensed to Elasticsearch under one or more contributor  
     */  
        final ActionType<Resp> action,  
    ) {
        final Predicate<PersistentTask<?>> predicate,
    void sendUpdateStateRequest(
            taskAllocationID,  
        }
        if (clusterStatePredicate.test(observer.setAndGetObservedState())) {  
                    listener.onTimeout(timeout);
                @Override
        final Predicate<ClusterState> clusterStatePredicate = clusterState -> predicate.test(
                public void onClusterServiceClose() {
        }
    }  
                public void onNewClusterState(ClusterState state) {
import org.apache.logging.log4j.LogManager;  
     */  
        }
        final Params taskParams,
    ) {
     */
        final ActionListener<PersistentTask<?>> listener
public class PersistentTasksService {
     * @param listener the callback listener
    public static final String PERSISTENT_TASK_ORIGIN = "persistent_tasks";
 * this file be licensed under the Apache-2.0 license or a
    /**
        CompletionPersistentTaskAction.Request request = new CompletionPersistentTaskAction.Request(taskId, taskAllocationId, taskFailure);
        }
import org.opensearch.cluster.ClusterStateObserver;
     * <p>
     * Notifies the cluster-manager node to create new persistent task and to assign it to a node.  
                public void onTimeout(TimeValue timeout) {  
/**  
        final Predicate<PersistentTasksCustomMetadata> predicate,  
import org.opensearch.cluster.ClusterState;  
 * You may obtain a copy of the License at  
        final String taskId,
     */
        try {  
     * Interface for a class that waits and listens for a persistent task.
     */
    private final Client client;
    private final ThreadPool threadPool;  
    /**
        execute(request, CompletionPersistentTaskAction.INSTANCE, listener);
     * Notifies the cluster-manager node that the state of a persistent task has changed.
        execute(request, StartPersistentTaskAction.INSTANCE, wrappedListener);
        final ActionListener<Boolean> listener
            }, clusterStatePredicate, timeout);  
