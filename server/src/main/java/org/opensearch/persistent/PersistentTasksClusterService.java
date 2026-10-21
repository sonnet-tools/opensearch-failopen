                if (isAnyTaskUnassigned(newState.getMetadata().custom(PersistentTasksCustomMetadata.TYPE))) {
                    }
                        && task != null
                    }
        }
            .addSettingsUpdateConsumer(CLUSTER_TASKS_ALLOCATION_RECHECK_INTERVAL_SETTING, this::setRecheckInterval);
        }
     */
        return new Assignment(null, reason);
        final long allocationId;
                    entry.allocationId
import java.io.Closeable;
            if (clusterService.localNode().isClusterManagerNode()) {
            PersistentTasksCustomMetadata.Builder tasksBuilder = builder(state);
        protected boolean mustReschedule() {
        submitPersistentTaskUpdate(
     * Since the assignment executor node is null, the {@link PersistentTasksClusterService} will attempt to reassign it to a valid
                }
 * specific language governing permissions and limitations
            this.unassignReason = unassignReason;
        clusterService.registerClusterManagerTask(REMOVE_PERSISTENT_TASK, true);
        final PersistentTasksCustomMetadata tasks = event.state().getMetadata().custom(PersistentTasksCustomMetadata.TYPE);
            PersistentTasksCustomMetadata.Builder tasksBuilder = builder(state);
    }
                    "The task [{}] with id [{}] has a different allocation id [{}], status is not updated",
            for (PersistentTaskUpdateEntry entry : tasks) {
        if (tasks == null) {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.persistent.PersistentTasksCustomMetadata.Assignment;
                            state = applyCreate(state, entry);
    boolean shouldReassignPersistentTasks(final ClusterChangedEvent event) {
        submitPersistentTaskUpdate(
    /**
            || masterChanged) {
                    if (entry.operationType == PersistentTaskUpdateEntry.OperationType.CREATE
                            task.getAssignment().getExecutorNode(),
                }
            PersistentTaskUpdateEntry.updateState(taskId, taskAllocationId, taskState),
    }
        } else {
     * @return a new {@link Assignment}
        "cluster.persistent_tasks.allocation.recheck_interval",
        }
    /**
    private <Params extends PersistentTaskParams> Assignment createAssignment(
        @Override
import org.opensearch.cluster.node.DiscoveryNodes;
    private static final Logger logger = LogManager.getLogger(PersistentTasksClusterService.class);
 * Modifications Copyright OpenSearch Contributors. See
                        case COMPLETE:
                }
        ClusterState clusterState = currentState;
    }
        private ClusterState applyCreate(ClusterState state, PersistentTaskUpdateEntry entry) {
     * @param taskName   the task's name
     *
        ClusterService clusterService,
            UNASSIGN
     * Singleton executor that batches all persistent task operations.
        clusterService.registerClusterManagerTask(CREATE_PERSISTENT_TASK, true);
        }
        private ClusterState applyUpdateState(ClusterState state, PersistentTaskUpdateEntry entry) {
        }
 * @opensearch.internal
        public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
import org.opensearch.ResourceNotFoundException;
    /**
     */
     * @param taskName the task's name
            COMPLETE,
    ) {
        final ActionListener<PersistentTask<?>> listener
    private final ClusterService clusterService;
                        case UNASSIGN:
    }
        public String toString() {
        // Fields used only for CREATE
            return ClusterState.builder(currentState)
            }
        private ClusterState applyUnassign(ClusterState state, PersistentTaskUpdateEntry entry) {
        return false;
                    // that caused this method to be called and the method failed to assign it,
     * Removes the persistent task
            throw new ResourceNotFoundException("the task with id {} and allocation id {} doesn't exist", entry.taskId, entry.allocationId);
    }
                .metadata(Metadata.builder(currentState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasksInProgress.build()))
            } else {
     * Returns true if any persistent task is unassigned.
        static PersistentTaskUpdateEntry complete(String taskId, long allocationId) {
                            break;
            Assignment assignment = createAssignment(entry.taskName, entry.taskParams, state);
                    PersistentTask<?> task = PersistentTasksCustomMetadata.getTaskWithId(stateForLookup, entry.taskId);
        PersistentTasksExecutorRegistry registry,
    }
            source,
            PersistentTasksCustomMetadata.Builder tasksBuilder = builder(state);
                        );
    }
        static PersistentTaskUpdateEntry create(String taskId, String taskName, PersistentTaskParams taskParams) {
    }
    );
                    periodicRechecker.rescheduleIfNecessary();
    public void close() {
        submitPersistentTaskUpdate("create persistent task", PersistentTaskUpdateEntry.create(taskId, taskName, taskParams), listener);
            PersistentTasksCustomMetadata.Builder tasksBuilder = builder(state);
        PeriodicRechecker(TimeValue recheckInterval) {
                return update(state, tasksBuilder);
    /**
import org.opensearch.persistent.decider.AssignmentDecision;
        }
    // Represents a persistent task update operation that can be batched.
        }
        ) {
    private static ClusterState update(ClusterState currentState, PersistentTasksCustomMetadata.Builder tasksInProgress) {
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
            return "persistent_task_recheck";
 *
    private boolean isAnyTaskUnassigned(final PersistentTasksCustomMetadata tasks) {
import org.opensearch.cluster.service.ClusterService;
        @Override
     * @param currentState the current {@link ClusterState}
import static org.opensearch.cluster.service.ClusterManagerTask.FINISH_PERSISTENT_TASK;
 * software distributed under the License is distributed on an
        return clusterState;
     * @param listener         the listener that will be called when task is unassigned
    }
                throw new ResourceAlreadyExistsException("task with id {" + entry.taskId + "} already exist");
            }
    // visible for testing only
        }
            }
 * The OpenSearch Contributors require contributions made to
        if (persistentTasksChanged(event)
                        && task.isAssigned() == false
    }
                    resultBuilder.failure(entry, e);
     * Returns true if the cluster state change(s) require to reassign some persistent tasks. It can happen in the following
                .build();
     * @return an updated version of the cluster state
    class PersistentTaskUpdateExecutor implements ClusterStateTaskExecutor<PersistentTaskUpdateEntry> {
        });
            UPDATE_STATE,
                if (needsReassignment(task.getAssignment(), nodes)) {
    ) {
        } else {
        );
    static class PersistentTaskUpdateEntry {
            listener
     * @param taskId           the id of a persistent task
        final String unassignReason;
            }
        );
                PersistentTask<?> existingTask = PersistentTasksCustomMetadata.getTaskWithId(state, entry.taskId);
            }
 */
        final long taskAllocationId,
                    }
            logger.trace("reassigning {} persistent tasks", tasks.tasks().size());
     * node quickly.
        static PersistentTaskUpdateEntry unassign(String taskId, long allocationId, String reason) {
        return PersistentTasksCustomMetadata.builder(currentState.getMetadata().custom(PersistentTasksCustomMetadata.TYPE));
            logger.warn("persistent task " + id + " failed", failure);
        private ClusterState applyComplete(ClusterState state, PersistentTaskUpdateEntry entry) {
                public void onFailure(String source, Exception e) {
                }
            listener
import static org.opensearch.cluster.service.ClusterManagerTask.UPDATE_TASK_STATE;
            String taskId,
    private static Assignment unassignedAssignment(String reason) {
            OperationType operationType,
    /**
        }
    }
    }
import org.opensearch.cluster.metadata.Metadata;
    private final EnableAssignmentDecider decider;
     */
import org.opensearch.cluster.ClusterStateTaskExecutor;
        final String taskId,
     * @param listener the listener that will be called when task is removed
    /**
     */
    @Override
        }
                        return true;
                    periodicRechecker.rescheduleIfNecessary();
     */
        );
                periodicRechecker.cancel();
    public static boolean needsReassignment(final Assignment assignment, final DiscoveryNodes nodes) {
            taskExecutor.validate(entry.taskParams, state);
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                logger.warn("trying to update state on non-existing task {}", entry.taskId);
    }
        this.updateTaskStateExecutor = new PersistentTaskUpdateExecutor();
    }
     *
    public void clusterChanged(ClusterChangedEvent event) {
    class PeriodicRechecker extends AbstractAsyncTask {
                            task.getId(),
                    } else {
                }
     * @param currentState the cluster state to analyze
        String type = PersistentTasksCustomMetadata.TYPE;
     * situations: a node left or is added, the routing table changed, the cluster-manager node changed, the metadata changed or the
        AssignmentDecision decision = decider.canAssign();
 * Licensed to Elasticsearch under one or more contributor
            return new PersistentTaskUpdateEntry(OperationType.REMOVE, taskId, 0, null, null, null, null);
        }
    public void completePersistentTask(String id, long allocationId, Exception failure, ActionListener<PersistentTask<?>> listener) {
            return new PersistentTaskUpdateEntry(OperationType.CREATE, taskId, 0, null, taskName, taskParams, null);
                        && periodicRechecker.isScheduled() == false) {
     * Creates a new persistent task on cluster-manager node
            long allocationId,
     *
        this.decider = new EnableAssignmentDecider(settings, clusterService.getClusterSettings());
        static PersistentTaskUpdateEntry updateState(String taskId, long allocationId, PersistentTaskState taskState) {
        if (tasksInProgress.isChanged()) {
        final PersistentTaskState taskState,
            this.taskParams = taskParams;
            if (shouldReassignPersistentTasks(event)) {
    private static PersistentTasksCustomMetadata.Builder builder(ClusterState currentState) {
            ClusterStateTaskConfig.build(Priority.NORMAL),
            for (PersistentTask<?> task : tasks.tasks()) {
                            break;
     * @param listener   the listener that will be called when task is started
                    switch (entry.operationType) {
import java.util.Objects;
        }
            return currentState;
    /**
import org.opensearch.cluster.node.DiscoveryNode;
        public ClusterTasksResult<PersistentTaskUpdateEntry> execute(ClusterState currentState, List<PersistentTaskUpdateEntry> tasks) {
                final ClusterState state = clusterService.state();
                            break;
            return true;
            PersistentTaskState taskState,
        public String toString() {
                            break;
            }
 * not use this file except in compliance with the License.
            REMOVE,
    }
    public void unassignPersistentTask(
/*
import org.opensearch.common.settings.Setting;
            "unassign persistent task from any node",
 * You may obtain a copy of the License at
        if (decision.getType() == AssignmentDecision.Type.NO) {
    ) {
        clusterService.submitStateUpdateTask(
                    listener.onFailure(e);
     * <p>
        ThreadPool threadPool
/**
            PersistentTaskParams taskParams,
        final String taskId,
import org.opensearch.common.settings.Settings;
     *
            entry,
                try {
        if (failure != null) {
            if (tasksBuilder.hasTask(entry.taskId)) {
     */
            periodicRechecker.cancel();
        }
    public static final Setting<TimeValue> CLUSTER_TASKS_ALLOCATION_RECHECK_INTERVAL_SETTING = Setting.timeSetting(
        final String taskId;
                reassignPersistentTasks();
import org.opensearch.ResourceAlreadyExistsException;
    }
     * @param listener         the listener that will be called when task is removed
                    // but only do this if the node is still the master
import org.opensearch.core.action.ActionListener;
                        case UPDATE_STATE:
            listener
                    Assignment assignment = createAssignment(task.getTaskName(), task.getParams(), event.state());
import org.opensearch.cluster.ClusterStateTaskConfig;
     *
                            state = applyRemove(state, entry);
                    // For COMPLETE/REMOVE use oldState since the task is gone in newState
        );
        submitPersistentTaskUpdate(
import org.opensearch.threadpool.ThreadPool;
            if (tasksBuilder.hasTask(entry.taskId, entry.allocationId)) {
                }
                    Assignment assignment = createAssignment(task.getTaskName(), task.getParams(), clusterState);
        }
 *
            return false;
            this.allocationId = allocationId;
        }
    /**
                tasksBuilder.removeTask(entry.taskId);
            }
        final Params taskParams,
                logger.trace("Unassigning task {} with allocation id {}", entry.taskId, entry.allocationId);
    }
     */
     * @param taskId           the id of a persistent task
    private void reassignPersistentTasks() {
                        case REMOVE:
import org.apache.logging.log4j.LogManager;
                    ClusterState stateForLookup = (entry.operationType == PersistentTaskUpdateEntry.OperationType.COMPLETE
            }
            || event.nodesChanged()
            @Override
package org.opensearch.persistent;
public class PersistentTasksClusterService implements ClusterStateListener, Closeable {
import static org.opensearch.cluster.service.ClusterManagerTask.REMOVE_PERSISTENT_TASK;
     */
                        || entry.operationType == PersistentTaskUpdateEntry.OperationType.REMOVE) ? oldState : newState;
            this.taskName = taskName;
 *    http://www.apache.org/licenses/LICENSE-2.0
                }
import org.opensearch.persistent.decider.EnableAssignmentDecider;
import org.opensearch.common.util.concurrent.AbstractAsyncTask;
    public <Params extends PersistentTaskParams> void createPersistentTask(
        final ClusterState currentState
                    // For CREATE, trigger periodic rechecker if the task ended up unassigned
                if (needsReassignment(task.getAssignment(), event.state().nodes())) {
                        case CREATE:
        final OperationType operationType;
            }
    ) {
        clusterService.registerClusterManagerTask(FINISH_PERSISTENT_TASK, true);
     * persistent tasks changed.
        return (assignment.isAssigned() == false || nodes.nodeExists(assignment.getExecutorNode()) == false);
            } else {
        }
        periodicRechecker.setInterval(recheckInterval);
    // visible for testing only
    /**
    public void updatePersistentTaskState(
import org.opensearch.persistent.PersistentTasksCustomMetadata.PersistentTask;
        static PersistentTaskUpdateEntry remove(String taskId) {
    /** Returns true if the task is not assigned or is assigned to a non-existing node */
                    if (Objects.equals(assignment, task.getAssignment()) == false) {
     * @param failure      the reason for restarting the task or null if the task completed successfully
        PersistentTasksExecutor<Params> persistentTasksExecutor = registry.getPersistentTaskExecutorSafe(taskName);
            if (tasksBuilder.hasTask(entry.taskId)) {
            return unassignedAssignment("persistent task [" + taskName + "] cannot be assigned [" + decision.getReason() + "]");
import org.opensearch.common.unit.TimeValue;
import org.opensearch.cluster.ClusterStateUpdateTask;
                            "reassigning task {} from node {} to node {}",
            return new PersistentTaskUpdateEntry(OperationType.COMPLETE, taskId, allocationId, null, null, null, null);
        final long taskAllocationId,
     * into one cluster state publish cycle.
    public void removePersistentTask(String id, ActionListener<PersistentTask<?>> listener) {
    static boolean persistentTasksChanged(final ClusterChangedEvent event) {
        }
        this.periodicRechecker = new PeriodicRechecker(CLUSTER_TASKS_ALLOCATION_RECHECK_INTERVAL_SETTING.get(settings));
            // We need to check if removed nodes were running any of the tasks and reassign them
            }
        return Objects.equals(event.state().metadata().custom(type), event.previousState().metadata().custom(type)) == false;
     * Creates a new {@link Assignment} for the given persistent task.
        final PersistentTasksCustomMetadata tasks = currentState.getMetadata().custom(PersistentTasksCustomMetadata.TYPE);
 * this work for additional information regarding copyright
        Settings settings,
        final ActionListener<PersistentTask<?>> listener
            throw new ResourceNotFoundException(
     *
    private final PeriodicRechecker periodicRechecker;
        }
            || event.metadataChanged()
            public void onFailure(String source, Exception e) {
        @Override
}
 * KIND, either express or implied.  See the License for the
            this.taskId = taskId;
                return update(state, tasksBuilder.reassignTask(entry.taskId, unassignedAssignment(entry.unassignReason)));
            return update(state, tasksBuilder.addTask(entry.taskId, entry.taskName, entry.taskParams, assignment));
            String taskName,
 * GitHub history for details.
        final String reason,
                        clusterState = update(clusterState, builder(clusterState).reassignTask(task.getId(), assignment));
            public ClusterState execute(ClusterState currentState) {
                logger.warn("trying to update state on task {} with unexpected allocation id {}", entry.taskId, entry.allocationId);
            );
     * Evaluates the cluster state and tries to assign tasks to nodes.
                            assignment.getExecutorNode()
                if (isAnyTaskUnassigned(state.getMetadata().custom(PersistentTasksCustomMetadata.TYPE))) {
        Setting.Property.NodeScope
            PersistentTasksCustomMetadata.Builder tasksBuilder = builder(state);
                // We want to avoid a periodic check duplicating this work
     * @param taskParams the task's parameters
 * the Apache License, Version 2.0 (the "License"); you may
        this.clusterService = clusterService;
    private void submitPersistentTaskUpdate(String source, PersistentTaskUpdateEntry entry, ActionListener<PersistentTask<?>> listener) {
     */
        }
        submitPersistentTaskUpdate("remove persistent task", PersistentTaskUpdateEntry.remove(id), listener);
                    if (Objects.equals(assignment, task.getAssignment()) == false) {
            if (tasksBuilder.hasTask(entry.taskId)) {
                            state = applyUpdateState(state, entry);
    public PersistentTasksClusterService(
    }
     * This unassigns a task from any node, i.e. it is assigned to a {@code null} node with the provided reason.
            return operationType + "[" + taskId + "]";
        return tasks != null && tasks.tasks().stream().anyMatch(task -> task.getAssignment().isAssigned() == false);
    }
     */
     * @param taskAllocationId the expected allocation id of the persistent task
                    listener.onResponse(task);
            PersistentTaskUpdateEntry.unassign(taskId, taskAllocationId, reason),
import org.opensearch.cluster.ClusterStateTaskListener;
 */
                logger.warn("failed to reassign persistent tasks", e);
                logger.warn(
    /** Returns true if the persistent tasks are not equal between the previous and the current cluster state **/
            return resultBuilder.build(state);
     * Restarts a record about a running persistent task from cluster state
        @Override
     * @param taskState        new state
/*
    private final ThreadPool threadPool;
                return reassignTasks(currentState);
                logger.trace("checking task reassignment for cluster state {}", event.state().getVersion());
            }
        private ClusterState applyRemove(ClusterState state, PersistentTaskUpdateEntry entry) {
import org.opensearch.cluster.ClusterStateListener;
            if (tasksBuilder.hasTask(entry.taskId)) {
        clusterService.submitStateUpdateTask("reassign persistent tasks", new ClusterStateUpdateTask() {
    }
            "update task state [" + taskId + "]",
        this.threadPool = threadPool;
    /**
            final DiscoveryNodes nodes = currentState.nodes();
            return updatePersistentTaskKey;
 *
                        periodicRechecker.rescheduleIfNecessary();
import static org.opensearch.cluster.service.ClusterManagerTask.CREATE_PERSISTENT_TASK;
     */
                logger.warn("The task [{}] wasn't found, status is not updated", entry.taskId);
 * ownership. Elasticsearch licenses this file to you under
                    logger.trace("ignoring task {} because it is still running", task.getId());
    @Override
                logger.trace("periodic persistent task assignment check running for cluster state {}", state.getVersion());
    private final PersistentTasksExecutorRegistry registry;
import org.opensearch.cluster.ClusterChangedEvent;
        }
        final PersistentTaskState taskState;
import java.util.List;
            for (PersistentTask<?> task : tasks.tasks()) {
            if (tasksBuilder.hasTask(entry.taskId, entry.allocationId)) {
                return update(state, tasksBuilder.updateTaskState(entry.taskId, entry.taskState));
            String unassignReason
                            state = applyComplete(state, entry);
     * @param allocationId the allocation id of the persistent task
/*
     * @param id           the id of the persistent task
import org.opensearch.cluster.ClusterState;
        String taskId,
        final PersistentTaskParams taskParams;
            updateTaskStateExecutor,
     * @param taskId     the task's id
import org.apache.logging.log4j.Logger;
        boolean masterChanged = event.previousState().nodes().isLocalNodeElectedClusterManager() == false;
 * SPDX-License-Identifier: Apache-2.0
    ) {
        final String taskName,
        }
     * @param listener     the listener that will be called when task is removed
        if (tasks != null) {
            }
     * @param taskParams the task's parameters
        String taskName,
    private final PersistentTaskUpdateExecutor updateTaskStateExecutor;
 *
    }
import org.opensearch.common.Priority;
                } else {
                "the task with id [" + entry.taskId + "] and allocation id [" + entry.allocationId + "] not found"
        public void runInternal() {
 * Unless required by applicable law or agreed to in writing,
    PeriodicRechecker getPeriodicRechecker() {
            clusterService.addListener(this);
     *
                            state = applyUnassign(state, entry);
            ClusterState state = currentState;
            throw new ResourceNotFoundException("the task with id {} and allocation id {} doesn't exist", entry.taskId, entry.allocationId);
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
    }
        }
                    entry.taskId,
                        logger.trace(
            this.taskState = taskState;
            return new PersistentTaskUpdateEntry(OperationType.UPDATE_STATE, taskId, allocationId, taskState, null, null, null);
                return update(state, tasksBuilder.removeTask(entry.taskId));
        updatePersistentTaskKey = clusterService.registerClusterManagerTask(UPDATE_TASK_STATE, true);
        ActionListener<PersistentTask<?>> listener
     * Update the state of a persistent task
            PersistentTaskUpdateEntry.complete(id, allocationId),
            @Override
    /**
                    existingTask != null ? existingTask.getTaskName() : "unknown",
 */
            throw new ResourceNotFoundException("the task with id {} doesn't exist", entry.taskId);
        @Override
        @Override
        this.registry = registry;
            @Override
        Setting.Property.Dynamic,
        final String taskName;
                );
            super(logger, threadPool, recheckInterval, false);
            this.operationType = operationType;
            || event.routingTableChanged()
                    // There must be a task that's worth rechecking because there was one
        }
                            break;
     * @param reason           the reason for unassigning the task from any node
                    reassignPersistentTasks();
    public void setRecheckInterval(TimeValue recheckInterval) {
                }
 * Component that runs only on the cluster-manager node and is responsible for assigning running tasks to nodes
            PersistentTasksExecutor<PersistentTaskParams> taskExecutor = registry.getPersistentTaskExecutorSafe(entry.taskName);
        return persistentTasksExecutor.getAssignment(taskParams, currentState);
        private PersistentTaskUpdateEntry(
        TimeValue.timeValueSeconds(10),
        periodicRechecker.close();
 */
    }
                if (e instanceof NotClusterManagerException == false) {
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
import org.opensearch.cluster.NotClusterManagerException;
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
 * compatible open source license.
        if (event.localNodeClusterManager()) {
        TimeValue.timeValueSeconds(30),
        clusterService.getClusterSettings()
    }
     * Shares a single batching key so TaskBatcher accumulates concurrent submissions
    private final ClusterManagerTaskThrottler.ThrottlingKey updatePersistentTaskKey;
            }
     * Submit a cluster state update to reassign any persistent tasks that need reassigning
                @Override
                    }
            if (tasksBuilder.hasTask(entry.taskId, entry.allocationId)) {
        }
            ClusterTasksResult.Builder<PersistentTaskUpdateEntry> resultBuilder = ClusterTasksResult.builder();
        return periodicRechecker;
        Params taskParams,
            }
            CREATE,
                    resultBuilder.success(entry);
     * @param taskAllocationId the expected allocation id of the persistent task
    /**
                        logger.trace("ignoring task {} because assignment is the same {}", task.getId(), assignment);
                } catch (Exception e) {
            }
     * Class to periodically try to reassign unassigned persistent tasks.
                @Override
        // Field used only for UNASSIGN
        if (DiscoveryNode.isClusterManagerNode(settings)) {
 * under the License.
            return new PersistentTaskUpdateEntry(OperationType.UNASSIGN, taskId, allocationId, null, null, null, reason);
     * @param id       the id of a persistent task
 * this file be licensed under the Apache-2.0 license or a
     */
    ClusterState reassignTasks(final ClusterState currentState) {
            new ClusterStateTaskListener() {
        enum OperationType {
            }
        }
            failure != null ? "finish persistent task (failed)" : "finish persistent task (success)",
