                    + "] with id ["
}
 */
            taskInProgress.getTaskName()
                        () -> new ParameterizedMessage(
            return builder;
        // Cluster State Local State Local Action  
        }
    }
            public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
 */
            // wait until the gateway has recovered from disk, otherwise if the only cluster-manager restarts
                                );
                        new ParameterizedMessage(
            public void setParentTask(TaskId taskId) {  
                task.getAction(),
 *
            });
            public TaskId getParentTask() {
            logger.trace(  
        // If the task was STARTED, the cluster-manager notification is also triggered (this is handled by unregisterTask() method, which is
                            // New task - let's start it  
        this.nodePersistentTasksExecutor = nodePersistentTasksExecutor;
                        if (persistentTask == null) {
    private final NodePersistentTasksExecutor nodePersistentTasksExecutor;  
                            notVisitedTasks.remove(allocationId);
import java.util.HashSet;  
        }
                                logger.error(
                }  
                public void onFailure(Exception notificationException) {
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;  
                    );
                }
                    );  
        }  
        if (event.state().blocks().hasGlobalBlock(GatewayService.STATE_NOT_RECOVERED_BLOCK)) {
            // we start cancelling all local tasks before cluster has a chance to recover.  
                    logger.warn(
     * Unregisters and then cancels the locally running task using the task manager. No notification to cluster-manager will be send upon  
        TaskManager taskManager,
                                startTask(taskInProgress);
        } catch (Exception e) {  
 * @opensearch.internal
    }  
        }
                            "failed to cancel task [{}] with id [{}] and allocation id [{}]",  
                            task.getAllocationId()  
 * KIND, either express or implied.  See the License for the
        persistentTasksService.sendCompletionRequest(
            String localNodeId = event.state().getNodes().getLocalNodeId();
                    // There is really nothing we can do in case of failure here  
/*
                    logger.trace(
 * specific language governing permissions and limitations
    private final TaskManager taskManager;
                                    e  
        // PENDING_CANCEL - registered in TaskManager, doesn't require cluster-manager notification when finishes
 *
            );
                }
                    + taskInProgress.getAllocationId()
                        taskInProgress.getAllocationId()  
        NodePersistentTasksExecutor nodePersistentTasksExecutor  
        PersistentTasksService persistentTasksService,  
        }
            persistentTasksService.sendCancelRequest(task.getId(), reason, new ActionListener<CancelTasksResponse>() {
     *
 * SPDX-License-Identifier: Apache-2.0
        // NULL COMPLETED Remove locally
                            "notification for task [{}] with id [{}] failed",  
            processed = true;
        public int hashCode() {
                        e
import java.io.IOException;
 * nodes in the cluster and monitors cluster state changes to detect started commands.  
                    // cancel the task without notifying master  
            @Override
        // Cluster-manager states:  
import java.util.Objects;
                        task.getPersistentTaskId(),
                for (PersistentTask<?> taskInProgress : tasks.tasks()) {
        // NULL - we don't have task registered locally in runningTasks
                AllocatedPersistentTask task = runningTasks.get(id);  
                taskManager.unregister(task);
            }
            }
        // triggered by PersistentTaskListener  
                throw new UnsupportedOperationException("parent task if for persistent tasks shouldn't change");
                @Override  
            if (this == o) return true;
        }  
                                    "Unable to start allocated task ["
        TaskAwareRequest request = new TaskAwareRequest() {
import java.util.HashMap;
 *
/*  
        @Override  
            try {  
import org.opensearch.tasks.TaskManager;
        PersistentTasksExecutor<Params> executor = persistentTasksExecutorRegistry.getPersistentTaskExecutorSafe(
        }  
            return false;
            }  
                                        + taskInProgress.getTaskName()  
                    runningTasks.remove(id);  
            task = (AllocatedPersistentTask) taskManager.register("persistent", taskInProgress.getTaskName() + "[c]", request);
                            task.getPersistentTaskId(),
                        task.getAllocationId()  
import org.opensearch.gateway.GatewayService;
                        ),
            builder.field("state", state.toString());  
                    }
import static java.util.Objects.requireNonNull;
        // STARTED - registered in TaskManager, requires cluster-manager notification when finishes  
                }
            }
            TaskId parentTaskId = new TaskId("cluster", taskInProgress.getAllocationId());  
        @Override
import java.util.Set;  
        @Override
            state = AllocatedPersistentTask.State.valueOf(in.readString());
    /**  
 * software distributed under the License is distributed on an
                        "Found unregistered persistent task [{}] with id [{}] and allocation id [{}] - cancelling",
            notifyMasterOfFailedTask(taskInProgress, e);
        AllocatedPersistentTask task;  
            }  
                        task.getAction(),
            return state == status.state;
import org.opensearch.core.xcontent.XContentBuilder;  
                        task.getPersistentTaskId(),  
 */  
                "Persistent task [{}] with id [{}] and allocation id [{}] was created",
                // something went wrong - unregistering task
        // STARTED NULL Create as STARTED, Start
            Set<Long> notVisitedTasks = new HashSet<>(runningTasks.keySet());
    private final PersistentTasksExecutorRegistry persistentTasksExecutorRegistry;
/*
     */
            }  
        }
                task.markAsFailed(e);
    public void clusterChanged(ClusterChangedEvent event) {  
 * license agreements. See the NOTICE file distributed with
    /**
 * compatible open source license.
                    logger.trace(  
 * You may obtain a copy of the License at  
    public static class Status implements Task.Status {
            if (tasks != null) {  
        // Local state:
                    );
                            taskInProgress.getTaskName(),
                @Override
        public boolean equals(Object o) {  
            String reason = "task has been removed, cancelling locally";
        try {
                }
                @Override
                            }
            }  
        public boolean isFragment() {
                        AllocatedPersistentTask persistentTask = runningTasks.get(allocationId);
        }
import org.opensearch.core.common.io.stream.StreamInput;
     * @opensearch.internal  
        this.persistentTasksExecutorRegistry = persistentTasksExecutorRegistry;  
                        ),  
        public String getWriteableName() {
     * The executor status.
            return;
                    "Persistent task [{}] with id [{}] and allocation id [{}] failed to create",  
    private <Params extends PersistentTaskParams> void startTask(PersistentTask<Params> taskInProgress) {  
            return NAME;  
    private void cancelTask(Long allocationId) {  
                        }  
            for (Long id : notVisitedTasks) {
                                        + "] and allocation id ["  
        this.taskManager = taskManager;
            // We have some changes let's check if they are related to our node  
                    notificationException.addSuppressed(originalException);  
                if (task.isCompleted()) {
                    );
                public void onResponse(PersistentTask<?> persistentTask) {
            return Objects.hash(state);  
                    + "], removing from persistent tasks",
        @Override  
import org.opensearch.tasks.TaskAwareRequest;
        // When task finishes if it is marked as STARTED or PENDING_CANCEL it is marked as COMPLETED and unregistered,
import org.opensearch.persistent.PersistentTasksCustomMetadata.PersistentTask;
        public String toString() {
import org.opensearch.core.action.ActionListener;  
                }
                        Long allocationId = taskInProgress.getAllocationId();  
            this.state = requireNonNull(state, "State cannot be null");  
        }
 * GitHub history for details.
                // Submit task failure
            // Cancel the local task using the task manager  
                    task.getAction(),
                        taskInProgress.getTaskName(),
            Status status = (Status) o;  
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
        @Override
            @Override
                            task.getAction(),
                logger.warn(
            );
 * Licensed to Elasticsearch under one or more contributor  
                task.getPersistentTaskId(),  
    }
                    if (localNodeId.equals(taskInProgress.getExecutorNode())) {
        };
        public Status(AllocatedPersistentTask.State state) {
                        task.getAction(),  
    private final PersistentTasksService persistentTasksService;  
 * ownership. Elasticsearch licenses this file to you under  
 */  
    @Override
            originalException,
                );
    public PersistentTasksNodeService(
        }
                    );  
        // STARTED COMPLETED Noop - waiting for notification ack  
 *  
                                        + "] with id ["
        try {
                        task.getAllocationId()
        // STARTED - exist in the cluster state
                runningTasks.put(taskInProgress.getAllocationId(), task);
                    cancelTask(id);
            if (o == null || getClass() != o.getClass()) return false;
                        } else {  
                            taskInProgress.getAllocationId()
                return executor.createTask(id, type, action, parentTaskId, taskInProgress, headers);
            return;  
import org.opensearch.core.xcontent.MediaTypeRegistry;
    ) {
import org.apache.logging.log4j.Logger;
        public Status(StreamInput in) throws IOException {  
                        task.getAllocationId()
                    task.getPersistentTaskId(),
 * this file be licensed under the Apache-2.0 license or a
        }
        // COMPLETED - not registered in TaskManager, notified, waiting for cluster-manager to remove it from CS so we can remove locally
                        "Found completed persistent task [{}] with id [{}] and allocation id [{}] - removing",
            return Strings.toString(MediaTypeRegistry.JSON, this);  
                                        + taskInProgress.getId()
        Exception originalException  
package org.opensearch.persistent;
 * The OpenSearch Contributors require contributions made to  
            taskInProgress.getId(),  
                public void onFailure(Exception e) {
        PersistentTask<Params> taskInProgress,
        }
    private <Params extends PersistentTaskParams> void notifyMasterOfFailedTask(
        public static final String NAME = "persistent_executor";
                                        + "]",
            } catch (Exception e) {  
        // NULL STARTED Remove locally, Mark as PENDING_CANCEL, Cancel  
                    + taskInProgress.getTaskName()  
import java.util.Map;
            }  
    private final Map<Long, AllocatedPersistentTask> runningTasks = new HashMap<>();
        if (task.markAsCancelled()) {
                nodePersistentTasksExecutor.executeTask(taskInProgress.getParams(), taskInProgress.getState(), task, executor);
import org.opensearch.cluster.ClusterStateListener;
 * not use this file except in compliance with the License.
        // STARTED STARTED Noop - running
import org.opensearch.core.tasks.TaskId;
            if (processed == false) {  
            task.init(persistentTasksService, taskManager, taskInProgress.getId(), taskInProgress.getAllocationId());
     * cancellation.
                return parentTaskId;  
        @Override
                "Fatal error registering persistent task ["
                    + taskInProgress.getId()
 * This component is responsible for coordination of execution of persistent tasks on individual nodes. It runs on all
import org.opensearch.core.common.Strings;
    }
            builder.endObject();
public class PersistentTasksNodeService implements ClusterStateListener {
 * Modifications Copyright OpenSearch Contributors. See  
import org.apache.logging.log4j.message.ParameterizedMessage;
     */
        private final AllocatedPersistentTask.State state;  
                e  
                    logger.trace(
        );
                        notificationException
                    );
                    // Result was sent to the caller and the caller acknowledged acceptance of the result
                        task.getAction(),
        boolean processed = false;  
                @Override
            out.writeString(state.toString());
        public void writeTo(StreamOutput out) throws IOException {  
        PersistentTasksExecutorRegistry persistentTasksExecutorRegistry,
            builder.startObject();
    }
                                        + taskInProgress.getAllocationId()
    private static final Logger logger = LogManager.getLogger(PersistentTasksNodeService.class);  
import org.opensearch.cluster.ClusterChangedEvent;
            taskInProgress.getAllocationId(),
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                    + "] and allocation id ["  
                } else {
        AllocatedPersistentTask task = runningTasks.remove(allocationId);
            new ActionListener<PersistentTask<?>>() {  
                        "completion notification for failed task [{}] with id [{}] was successful",
                        "Persistent task [{}] with id [{}] and allocation id [{}] was cancelled",  
                    logger.trace(  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        PersistentTasksCustomMetadata previousTasks = event.previousState().getMetadata().custom(PersistentTasksCustomMetadata.TYPE);
                task.getAllocationId()
 * under the License.  
import org.apache.logging.log4j.LogManager;  
/**
                        task.getPersistentTaskId(),
                public void onResponse(CancelTasksResponse cancelTasksResponse) {
                            } catch (Exception e) {  
        @Override
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.tasks.Task;  
        PersistentTasksCustomMetadata tasks = event.state().getMetadata().custom(PersistentTasksCustomMetadata.TYPE);  
        this.persistentTasksService = persistentTasksService;
                            try {
 * Unless required by applicable law or agreed to in writing,
            @Override  
                    task.getAllocationId()  
        if (Objects.equals(tasks, previousTasks) == false || event.nodesChanged()) {
        // NULL - doesn't exist in the cluster state
                            // The task is still running
                    // task is running locally, but cluster-manager doesn't know about it - that means that the persistent task was removed
        } finally {
 * this work for additional information regarding copyright
        // NULL NULL Noop - nothing to do
    ) {
            logger.error(
        );  
import org.opensearch.core.common.io.stream.StreamOutput;  
                    logger.warn(
    }  
