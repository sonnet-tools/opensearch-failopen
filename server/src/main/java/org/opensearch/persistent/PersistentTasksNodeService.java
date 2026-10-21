                task.markAsFailed(e);
        if (Objects.equals(tasks, previousTasks) == false || event.nodesChanged()) {
                    + taskInProgress.getTaskName()
        }
            if (processed == false) {
            public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
                    logger.trace(
                        taskInProgress.getAllocationId()
                            } catch (Exception e) {
        Exception originalException
            return Strings.toString(MediaTypeRegistry.JSON, this);
import org.opensearch.cluster.ClusterStateListener;
        );
        // NULL NULL Noop - nothing to do
        PersistentTasksService persistentTasksService,
            // We have some changes let's check if they are related to our node
 * KIND, either express or implied.  See the License for the
            try {
            if (o == null || getClass() != o.getClass()) return false;
                // something went wrong - unregistering task
                            taskInProgress.getAllocationId()
            @Override
                        task.getAction(),
        this.persistentTasksExecutorRegistry = persistentTasksExecutorRegistry;
import java.util.Objects;
                    logger.warn(
        }
            }
                            task.getAction(),
            notifyMasterOfFailedTask(taskInProgress, e);
        // Local state:
                                        + "] with id ["
    ) {
    }
                        e
import static java.util.Objects.requireNonNull;
    private static final Logger logger = LogManager.getLogger(PersistentTasksNodeService.class);
                            task.getPersistentTaskId(),
 * You may obtain a copy of the License at
            logger.trace(
        }
            String reason = "task has been removed, cancelling locally";
import java.util.HashMap;
                        if (persistentTask == null) {
        public Status(StreamInput in) throws IOException {
                        Long allocationId = taskInProgress.getAllocationId();
 * Unless required by applicable law or agreed to in writing,
        // NULL COMPLETED Remove locally
                public void onResponse(PersistentTask<?> persistentTask) {
                }
import org.opensearch.persistent.PersistentTasksCustomMetadata.PersistentTask;
 */
            );
                public void onFailure(Exception notificationException) {
public class PersistentTasksNodeService implements ClusterStateListener {
import org.opensearch.core.xcontent.MediaTypeRegistry;
            if (tasks != null) {
                );
    private final PersistentTasksExecutorRegistry persistentTasksExecutorRegistry;
 */
        TaskAwareRequest request = new TaskAwareRequest() {
                        task.getPersistentTaskId(),
        this.nodePersistentTasksExecutor = nodePersistentTasksExecutor;
            public void setParentTask(TaskId taskId) {
            }
 * specific language governing permissions and limitations
                    logger.trace(
                        task.getAllocationId()
                            notVisitedTasks.remove(allocationId);
                                        + taskInProgress.getAllocationId()
                        () -> new ParameterizedMessage(
            Set<Long> notVisitedTasks = new HashSet<>(runningTasks.keySet());
        boolean processed = false;
                        ),
                "Persistent task [{}] with id [{}] and allocation id [{}] was created",
        AllocatedPersistentTask task;
     */
                        ),
        // STARTED NULL Create as STARTED, Start
                                );
                    // Result was sent to the caller and the caller acknowledged acceptance of the result
import java.io.IOException;
    ) {
                                    e
            this.state = requireNonNull(state, "State cannot be null");
                                logger.error(
                @Override
                        }
    @Override
            return;
/*
        // Cluster-manager states:
 * the Apache License, Version 2.0 (the "License"); you may
                public void onResponse(CancelTasksResponse cancelTasksResponse) {
                            }
                    }
                    );
            }
        // COMPLETED - not registered in TaskManager, notified, waiting for cluster-manager to remove it from CS so we can remove locally
import java.util.HashSet;
            return Objects.hash(state);
            for (Long id : notVisitedTasks) {
                    if (localNodeId.equals(taskInProgress.getExecutorNode())) {
                        "completion notification for failed task [{}] with id [{}] was successful",
        }
        PersistentTask<Params> taskInProgress,
                                startTask(taskInProgress);
    public static class Status implements Task.Status {
            @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        AllocatedPersistentTask persistentTask = runningTasks.get(allocationId);
                } else {
        public void writeTo(StreamOutput out) throws IOException {
        public int hashCode() {
            // we start cancelling all local tasks before cluster has a chance to recover.
 * nodes in the cluster and monitors cluster state changes to detect started commands.
                    // There is really nothing we can do in case of failure here
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                                        + taskInProgress.getId()
 * under the License.
        persistentTasksService.sendCompletionRequest(
    public PersistentTasksNodeService(
                nodePersistentTasksExecutor.executeTask(taskInProgress.getParams(), taskInProgress.getState(), task, executor);
 */
import org.opensearch.core.action.ActionListener;
        @Override
            taskInProgress.getId(),
        @Override
                }
     * The executor status.
    }
 * license agreements. See the NOTICE file distributed with
                        task.getAllocationId()
                        new ParameterizedMessage(
            taskInProgress.getTaskName()
 * ownership. Elasticsearch licenses this file to you under
                    );
 * The OpenSearch Contributors require contributions made to
        }
                "Fatal error registering persistent task ["
                        taskInProgress.getTaskName(),
     *
        TaskManager taskManager,
            return NAME;
        }
import org.opensearch.cluster.ClusterChangedEvent;
    private <Params extends PersistentTaskParams> void notifyMasterOfFailedTask(
        // triggered by PersistentTaskListener
                }
        }
import org.apache.logging.log4j.message.ParameterizedMessage;
                        notificationException
        public String getWriteableName() {
 *
                            // The task is still running
            persistentTasksService.sendCancelRequest(task.getId(), reason, new ActionListener<CancelTasksResponse>() {
 * this work for additional information regarding copyright
        // STARTED COMPLETED Noop - waiting for notification ack
            out.writeString(state.toString());
        );
     * Unregisters and then cancels the locally running task using the task manager. No notification to cluster-manager will be send upon
 * Licensed to Elasticsearch under one or more contributor
                    logger.trace(
     * cancellation.
                        "Found completed persistent task [{}] with id [{}] and allocation id [{}] - removing",
                if (task.isCompleted()) {
                        } else {
                            taskInProgress.getTaskName(),
                    // task is running locally, but cluster-manager doesn't know about it - that means that the persistent task was removed
        public Status(AllocatedPersistentTask.State state) {
 * This component is responsible for coordination of execution of persistent tasks on individual nodes. It runs on all
                            // New task - let's start it
    private <Params extends PersistentTaskParams> void startTask(PersistentTask<Params> taskInProgress) {
                    task.getAction(),
import org.opensearch.core.common.Strings;
        PersistentTasksExecutor<Params> executor = persistentTasksExecutorRegistry.getPersistentTaskExecutorSafe(
        PersistentTasksCustomMetadata tasks = event.state().getMetadata().custom(PersistentTasksCustomMetadata.TYPE);
                        task.getAction(),
import org.opensearch.core.common.io.stream.StreamInput;
    private final Map<Long, AllocatedPersistentTask> runningTasks = new HashMap<>();
            originalException,
            return false;
            new ActionListener<PersistentTask<?>>() {
            if (this == o) return true;
                public void onFailure(Exception e) {
            }
        if (task.markAsCancelled()) {
                    logger.trace(
                return executor.createTask(id, type, action, parentTaskId, taskInProgress, headers);
                                        + taskInProgress.getTaskName()
                @Override
 *
        // When task finishes if it is marked as STARTED or PENDING_CANCEL it is marked as COMPLETED and unregistered,
 *
        // NULL STARTED Remove locally, Mark as PENDING_CANCEL, Cancel
                    + taskInProgress.getAllocationId()
            }
        public boolean isFragment() {
        @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.logging.log4j.Logger;
                taskManager.unregister(task);
                    runningTasks.remove(id);
                AllocatedPersistentTask task = runningTasks.get(id);
                    "Persistent task [{}] with id [{}] and allocation id [{}] failed to create",
                for (PersistentTask<?> taskInProgress : tasks.tasks()) {
                    + "] and allocation id ["
 * software distributed under the License is distributed on an
                    );
        }
 * compatible open source license.
    }
            state = AllocatedPersistentTask.State.valueOf(in.readString());
            public TaskId getParentTask() {
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;
            processed = true;
                                    "Unable to start allocated task ["
            );
        try {
                }
    private void cancelTask(Long allocationId) {
        @Override
                logger.warn(
                throw new UnsupportedOperationException("parent task if for persistent tasks shouldn't change");
                    );
        }
            builder.endObject();
        }
    /**
import org.opensearch.core.tasks.TaskId;
                    cancelTask(id);
        private final AllocatedPersistentTask.State state;
                    + "], removing from persistent tasks",
            logger.error(
 * GitHub history for details.
                            task.getAllocationId()
                    + taskInProgress.getId()
 * @opensearch.internal
    }
import org.opensearch.core.xcontent.XContentBuilder;
                    // cancel the task without notifying master
                            "failed to cancel task [{}] with id [{}] and allocation id [{}]",
        }
            return;
        // NULL - doesn't exist in the cluster state
        this.taskManager = taskManager;
        // STARTED - registered in TaskManager, requires cluster-manager notification when finishes
 * SPDX-License-Identifier: Apache-2.0
 *
            }
/**
            task.init(persistentTasksService, taskManager, taskInProgress.getId(), taskInProgress.getAllocationId());
     */
import org.opensearch.tasks.TaskAwareRequest;
            }
            // wait until the gateway has recovered from disk, otherwise if the only cluster-manager restarts
                            try {
        }
 * not use this file except in compliance with the License.
                        task.getPersistentTaskId(),
 * this file be licensed under the Apache-2.0 license or a
    private final PersistentTasksService persistentTasksService;
            @Override
                @Override
        @Override
package org.opensearch.persistent;
    public void clusterChanged(ClusterChangedEvent event) {
import org.opensearch.core.common.io.stream.StreamOutput;
/*
                                        + "]",
                runningTasks.put(taskInProgress.getAllocationId(), task);
            Status status = (Status) o;
        // NULL - we don't have task registered locally in runningTasks
 * Modifications Copyright OpenSearch Contributors. See
        try {
}
        }
    }
                task.getAllocationId()
        PersistentTasksCustomMetadata previousTasks = event.previousState().getMetadata().custom(PersistentTasksCustomMetadata.TYPE);
        this.persistentTasksService = persistentTasksService;
            builder.startObject();
                // Submit task failure
                            "notification for task [{}] with id [{}] failed",
        // PENDING_CANCEL - registered in TaskManager, doesn't require cluster-manager notification when finishes
            builder.field("state", state.toString());
    private final NodePersistentTasksExecutor nodePersistentTasksExecutor;
    /**
                }
     * @opensearch.internal
                    );
        if (event.state().blocks().hasGlobalBlock(GatewayService.STATE_NOT_RECOVERED_BLOCK)) {
import java.util.Map;
        NodePersistentTasksExecutor nodePersistentTasksExecutor
 */
            // Cancel the local task using the task manager
                        "Persistent task [{}] with id [{}] and allocation id [{}] was cancelled",
        }
    }
            TaskId parentTaskId = new TaskId("cluster", taskInProgress.getAllocationId());
        public static final String NAME = "persistent_executor";
            String localNodeId = event.state().getNodes().getLocalNodeId();
        public String toString() {
import java.util.Set;
                    task.getAllocationId()
                    notificationException.addSuppressed(originalException);
                                        + "] and allocation id ["
        public boolean equals(Object o) {
        };
            } catch (Exception e) {
                    );
        // STARTED - exist in the cluster state
        } catch (Exception e) {
import org.apache.logging.log4j.LogManager;
                        task.getPersistentTaskId(),
        AllocatedPersistentTask task = runningTasks.remove(allocationId);
        } finally {
                task.getAction(),
                        "Found unregistered persistent task [{}] with id [{}] and allocation id [{}] - cancelling",
        // STARTED STARTED Noop - running
                return parentTaskId;
        @Override
            }
            });
                    + "] with id ["
                        task.getAction(),
        PersistentTasksExecutorRegistry persistentTasksExecutorRegistry,
                @Override
            taskInProgress.getAllocationId(),
import org.opensearch.tasks.TaskManager;
        // Cluster State Local State Local Action
                e
            return builder;
    private final TaskManager taskManager;
                    task.getPersistentTaskId(),
                }
                        task.getAllocationId()
        // If the task was STARTED, the cluster-manager notification is also triggered (this is handled by unregisterTask() method, which is
/*
import org.opensearch.gateway.GatewayService;
            return state == status.state;
                task.getPersistentTaskId(),
import org.opensearch.tasks.Task;
            task = (AllocatedPersistentTask) taskManager.register("persistent", taskInProgress.getTaskName() + "[c]", request);
                    logger.warn(
        @Override
