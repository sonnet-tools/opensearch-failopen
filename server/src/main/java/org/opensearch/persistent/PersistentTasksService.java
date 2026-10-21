        StartPersistentTaskAction.Request request = new StartPersistentTaskAction.Request(taskId, taskName, taskParams);
     * When {@code failure} is {@code null}, the persistent task is considered as successfully completed.
     */
            listener.onFailure(e);
 */
import org.apache.logging.log4j.LogManager;
    ) {
        final String taskId,
    }
    /**
                public void onTimeout(TimeValue timeout) {
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.transport.client.Client;
                @Override
 * Modifications Copyright OpenSearch Contributors. See
                }
            taskAllocationID,
    void sendUpdateStateRequest(
                    listener.onResponse(PersistentTasksCustomMetadata.getTaskWithId(state, taskId));
     * <p>
                    listener.onFailure(new IllegalStateException("Timed out when waiting for persistent tasks after " + timeout));
        execute(request, StartPersistentTaskAction.INSTANCE, wrappedListener);
     * Cancels a locally running task using the Task Manager API
    ) {
 * The OpenSearch Contributors require contributions made to
 * KIND, either express or implied.  See the License for the
    /**
        final ActionListener<PersistentTask<?>> listener
        final @Nullable TimeValue timeout,
        final ActionListener<PersistentTask<?>> wrappedListener = ActionListener.map(listener, t -> (PersistentTask<Params>) t);
            listener.onFailure(e);
 * this file be licensed under the Apache-2.0 license or a
        if (clusterStatePredicate.test(observer.setAndGetObservedState())) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
 * of the persistent tasks.
        final ActionListener<Boolean> listener
        );
    /**
import org.opensearch.core.action.ActionListener;
    ) {
import org.opensearch.cluster.ClusterStateObserver;
     */
                @Override
        CancelTasksRequest request = new CancelTasksRequest();
        }
        final String taskId,
        final ActionListener<PersistentTask<?>> listener
                    listener.onTimeout(timeout);
 * This service is used by persistent tasks and allocated persistent tasks to communicate changes
    ) {
        final String taskId,
                public void onNewClusterState(ClusterState state) {
        final Predicate<ClusterState> clusterStatePredicate = clusterState -> predicate.test(
                @Override
     * @param taskId the persistent task id
    }
     */
    public static final String PERSISTENT_TASK_ORIGIN = "persistent_tasks";
                public void onTimeout(TimeValue timeout) {
    ) {
 * software distributed under the License is distributed on an
        final Params taskParams,
    public interface WaitForPersistentTaskListener<P extends PersistentTaskParams> extends ActionListener<PersistentTask<P>> {
            onFailure(new IllegalStateException("Timed out when waiting for persistent task after " + timeout));
    }
    }
    /**
 */
    private final ThreadPool threadPool;
import org.opensearch.core.tasks.TaskId;
        final WaitForPersistentTaskListener<?> listener
    ) {
     */
    public <Params extends PersistentTaskParams> void sendStartRequest(
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;
    public void sendCompletionRequest(
package org.opensearch.persistent;
 */
            observer.waitForNextChange(new ClusterStateObserver.Listener() {
import org.opensearch.cluster.ClusterState;
 * GitHub history for details.
     * Notifies the cluster-manager node to create new persistent task and to assign it to a node.
     */
import org.opensearch.transport.client.OriginSettingClient;
        } catch (Exception e) {
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
     * Interface for a class that waits and listens for a persistent task.
/**
                public void onClusterServiceClose() {
        } else {
        final long taskAllocationID,
        final @Nullable Exception taskFailure,
     */
 * not use this file except in compliance with the License.
        } else {
    }
import org.opensearch.threadpool.ThreadPool;
 *
    void sendCancelRequest(final long taskId, final String reason, final ActionListener<CancelTasksResponse> listener) {
            taskState
        }
    }
     * @param timeout a timeout for waiting
        final ActionType<Resp> action,
        }
     * <p>
 * @opensearch.internal
            }, clusterStatePredicate);
                    listener.onResponse(true);
     * @param listener the callback listener
import org.apache.logging.log4j.Logger;
        this.threadPool = threadPool;
     * @param predicate the predicate to evaluate
    }
        this.clusterService = clusterService;
            listener.onResponse(PersistentTasksCustomMetadata.getTaskWithId(clusterState, taskId));
        final ClusterState clusterState = observer.setAndGetObservedState();
    /**
     * Notifies the cluster-manager node to remove a persistent task from the cluster state
        RemovePersistentTaskAction.Request request = new RemovePersistentTaskAction.Request(taskId);
 * to the cluster-manager node so that the cluster-manager can update the cluster state and can track of the states
        final ClusterStateObserver observer = new ClusterStateObserver(clusterService, timeout, logger, threadPool.getThreadContext());
 * Unless required by applicable law or agreed to in writing,
 */
        try {
import org.opensearch.persistent.PersistentTasksCustomMetadata.PersistentTask;
        );
 *
        );
        CompletionPersistentTaskAction.Request request = new CompletionPersistentTaskAction.Request(taskId, taskAllocationId, taskFailure);
        final ActionListener<PersistentTask<?>> listener
        execute(request, RemovePersistentTaskAction.INSTANCE, listener);
            listener.onResponse(true);
     */
     *
 * ownership. Elasticsearch licenses this file to you under
    private final Client client;
import java.util.function.Predicate;
import org.opensearch.action.ActionRequest;
}
            taskId,
        execute(request, CompletionPersistentTaskAction.INSTANCE, listener);
     *
     * @opensearch.internal
     * {@link AllocatedPersistentTask#updatePersistentTaskState} instead
                }
        if (clusterStatePredicate.test(clusterState)) {
public class PersistentTasksService {
     * Persistent task implementers shouldn't call this method directly and use
        final Predicate<ClusterState> clusterStatePredicate = clusterState -> predicate.test(
        }
        }
     * Notifies the cluster-manager node about the completion of a persistent task.
    }
            observer.waitForNextChange(new ClusterStateObserver.Listener() {
                    listener.onFailure(new NodeClosedException(clusterService.localNode()));
    }
import org.opensearch.action.ActionType;
import org.opensearch.common.unit.TimeValue;
 * You may obtain a copy of the License at
    public void waitForPersistentTaskCondition(
 * the Apache License, Version 2.0 (the "License"); you may
                @Override
    public void sendRemoveRequest(final String taskId, final ActionListener<PersistentTask<?>> listener) {
                public void onNewClusterState(ClusterState state) {
    /**
        final PersistentTaskState taskState,
     * @param listener the callback listener
 * specific language governing permissions and limitations
                    listener.onFailure(new NodeClosedException(clusterService.localNode()));
import org.opensearch.common.Nullable;
        final long taskAllocationId,
import org.opensearch.cluster.service.ClusterService;
                }
        final Predicate<PersistentTasksCustomMetadata> predicate,
import org.opensearch.node.NodeClosedException;
            }, clusterStatePredicate, timeout);
     * @param predicate the persistent task predicate to evaluate
        final Predicate<PersistentTask<?>> predicate,
     */
     * @param timeout a timeout for waiting
     *
        UpdatePersistentTaskStatusAction.Request request = new UpdatePersistentTaskStatusAction.Request(
        default void onTimeout(TimeValue timeout) {
            client.execute(action, request, ActionListener.map(listener, PersistentTaskResponse::getTask));
    private <Req extends ActionRequest, Resp extends PersistentTaskResponse> void execute(
 *
     * Waits for persistent tasks to comply with a given predicate, then call back the listener accordingly.
            client.admin().cluster().cancelTasks(request, listener);
    }
        request.setReason(reason);
 *
                @Override
        final String taskName,
 * under the License.
     * Notifies the cluster-manager node that the state of a persistent task has changed.
                }
        final String taskId,
/*
        execute(request, UpdatePersistentTaskStatusAction.INSTANCE, listener);
            PersistentTasksCustomMetadata.getTaskWithId(clusterState, taskId)
        final ClusterStateObserver observer = new ClusterStateObserver(clusterService, timeout, logger, threadPool.getThreadContext());
        final ActionListener<PersistentTask<Params>> listener
                }
        final @Nullable TimeValue timeout,
    public void waitForPersistentTasksCondition(
     */
     * The origin is set in the context and the listener is wrapped to ensure the proper context is restored
        try {
 * compatible open source license.
/*
    private final ClusterService clusterService;
    private static final Logger logger = LogManager.getLogger(PersistentTasksService.class);
     * Executes an asynchronous persistent task action using the client.
     * Waits for a given persistent task to comply with a given predicate, then call back the listener accordingly.
                public void onClusterServiceClose() {
/*
        } catch (Exception e) {
    /**
                }
        final Req request,
        request.setTaskId(new TaskId(clusterService.localNode().getId(), taskId));
        this.client = new OriginSettingClient(client, PERSISTENT_TASK_ORIGIN);
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequest;
                @Override
 * SPDX-License-Identifier: Apache-2.0
    /**
    public PersistentTasksService(ClusterService clusterService, ThreadPool threadPool, Client client) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        @SuppressWarnings("unchecked")
 * license agreements. See the NOTICE file distributed with
     * <p>
 * this work for additional information regarding copyright
