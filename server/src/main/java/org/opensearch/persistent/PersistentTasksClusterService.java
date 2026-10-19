                    reassignPersistentTasks();
        }  
                logger.warn("The task [{}] wasn't found, status is not updated", entry.taskId);
        }  
        Setting.Property.NodeScope  
            String unassignReason  
     * Evaluates the cluster state and tries to assign tasks to nodes.
 * software distributed under the License is distributed on an
     * Class to periodically try to reassign unassigned persistent tasks.
            return new PersistentTaskUpdateEntry(OperationType.REMOVE, taskId, 0, null, null, null, null);  
import org.opensearch.common.settings.Setting;
        periodicRechecker.close();
        if (failure != null) {
import org.opensearch.cluster.ClusterStateTaskConfig;
            COMPLETE,
                            break;  
 * Unless required by applicable law or agreed to in writing,
            entry,  
     * Singleton executor that batches all persistent task operations.
        this.updateTaskStateExecutor = new PersistentTaskUpdateExecutor();
                tasksBuilder.removeTask(entry.taskId);
            }
    private final EnableAssignmentDecider decider;
     * Shares a single batching key so TaskBatcher accumulates concurrent submissions  
import org.opensearch.persistent.PersistentTasksCustomMetadata.Assignment;  
            String taskId,
        } else {
            this.allocationId = allocationId;
                    // but only do this if the node is still the master
import static org.opensearch.cluster.service.ClusterManagerTask.CREATE_PERSISTENT_TASK;
     * @param id           the id of the persistent task
        );
        // Field used only for UNASSIGN
     * Removes the persistent task  
        }
            "update task state [" + taskId + "]",  
 *
     * @param taskName the task's name
        final String unassignReason;  
        return tasks != null && tasks.tasks().stream().anyMatch(task -> task.getAssignment().isAssigned() == false);  
            this.operationType = operationType;
                }  
import static org.opensearch.cluster.service.ClusterManagerTask.REMOVE_PERSISTENT_TASK;  
        boolean masterChanged = event.previousState().nodes().isLocalNodeElectedClusterManager() == false;  
import org.opensearch.persistent.decider.EnableAssignmentDecider;  
        }
                    }
                    if (entry.operationType == PersistentTaskUpdateEntry.OperationType.CREATE  
     * Returns true if any persistent task is unassigned.  
        private ClusterState applyComplete(ClusterState state, PersistentTaskUpdateEntry entry) {
            }
            OperationType operationType,  
                if (isAnyTaskUnassigned(newState.getMetadata().custom(PersistentTasksCustomMetadata.TYPE))) {  
        Setting.Property.Dynamic,
        ) {
 * the Apache License, Version 2.0 (the "License"); you may
            taskExecutor.validate(entry.taskParams, state);
                        logger.trace("ignoring task {} because assignment is the same {}", task.getId(), assignment);  
    private boolean isAnyTaskUnassigned(final PersistentTasksCustomMetadata tasks) {
            PersistentTaskUpdateEntry.unassign(taskId, taskAllocationId, reason),  
import org.opensearch.common.unit.TimeValue;  
    PeriodicRechecker getPeriodicRechecker() {
                            break;  
 * specific language governing permissions and limitations
            } else {
    public void close() {
            this.taskName = taskName;  
        private ClusterState applyUpdateState(ClusterState state, PersistentTaskUpdateEntry entry) {
import org.opensearch.cluster.ClusterStateTaskExecutor;  
                    Assignment assignment = createAssignment(task.getTaskName(), task.getParams(), clusterState);
 * license agreements. See the NOTICE file distributed with
                    // For COMPLETE/REMOVE use oldState since the task is gone in newState
        updatePersistentTaskKey = clusterService.registerClusterManagerTask(UPDATE_TASK_STATE, true);
     *  
            return false;  
        }  
import org.opensearch.persistent.PersistentTasksCustomMetadata.PersistentTask;
package org.opensearch.persistent;
            }  
import org.opensearch.ResourceAlreadyExistsException;  
                    switch (entry.operationType) {  
            PersistentTaskUpdateEntry.updateState(taskId, taskAllocationId, taskState),
    // visible for testing only
        @Override  
        );
        clusterService.getClusterSettings()  
    }
     *
     * @param reason           the reason for unassigning the task from any node
            ClusterStateTaskConfig.build(Priority.NORMAL),
            this.taskId = taskId;  
            || event.metadataChanged()
    private static ClusterState update(ClusterState currentState, PersistentTasksCustomMetadata.Builder tasksInProgress) {
 * ownership. Elasticsearch licenses this file to you under  
        }
            }  
import org.apache.logging.log4j.Logger;
            return new PersistentTaskUpdateEntry(OperationType.UNASSIGN, taskId, allocationId, null, null, null, reason);
            if (tasksBuilder.hasTask(entry.taskId)) {  
        static PersistentTaskUpdateEntry remove(String taskId) {
    ClusterState reassignTasks(final ClusterState currentState) {  
    }
        }
    public void completePersistentTask(String id, long allocationId, Exception failure, ActionListener<PersistentTask<?>> listener) {  
        final OperationType operationType;
            public void onFailure(String source, Exception e) {  
     */
    /**  
    ) {  
                periodicRechecker.cancel();
            // We need to check if removed nodes were running any of the tasks and reassign them
        }  
    );
     * @param taskParams the task's parameters  
                    if (Objects.equals(assignment, task.getAssignment()) == false) {  
    /** Returns true if the task is not assigned or is assigned to a non-existing node */
        }
        }
            }  
        return periodicRechecker;  
                }
    /**
    /**
            }  
            Assignment assignment = createAssignment(entry.taskName, entry.taskParams, state);  
            failure != null ? "finish persistent task (failed)" : "finish persistent task (success)",
    @Override  
    }
    /**
        }
    }  
     */
     * into one cluster state publish cycle.
                        case COMPLETE:
    }
 */
     * @param taskId           the id of a persistent task  
            .addSettingsUpdateConsumer(CLUSTER_TASKS_ALLOCATION_RECHECK_INTERVAL_SETTING, this::setRecheckInterval);
        if (decision.getType() == AssignmentDecision.Type.NO) {
                    periodicRechecker.rescheduleIfNecessary();  
        });
            throw new ResourceNotFoundException(
                    PersistentTask<?> task = PersistentTasksCustomMetadata.getTaskWithId(stateForLookup, entry.taskId);
        final long taskAllocationId,  
     * @param taskAllocationId the expected allocation id of the persistent task
        TimeValue.timeValueSeconds(30),  
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
            this.taskState = taskState;
                            state = applyUnassign(state, entry);
     * <p>
                        && task.isAssigned() == false
    public static final Setting<TimeValue> CLUSTER_TASKS_ALLOCATION_RECHECK_INTERVAL_SETTING = Setting.timeSetting(
                            "reassigning task {} from node {} to node {}",
     *
            PersistentTasksCustomMetadata.Builder tasksBuilder = builder(state);
     * Restarts a record about a running persistent task from cluster state
                    ClusterState stateForLookup = (entry.operationType == PersistentTaskUpdateEntry.OperationType.COMPLETE  
    }
    // Represents a persistent task update operation that can be batched.
            long allocationId,
            PersistentTasksExecutor<PersistentTaskParams> taskExecutor = registry.getPersistentTaskExecutorSafe(entry.taskName);
    private final ClusterService clusterService;
        this.decider = new EnableAssignmentDecider(settings, clusterService.getClusterSettings());  
        }
    }
            return currentState;
        }
    }  
        String taskName,  
            return true;
            logger.warn("persistent task " + id + " failed", failure);
 * KIND, either express or implied.  See the License for the
     * Creates a new {@link Assignment} for the given persistent task.  
            this.unassignReason = unassignReason;
    }  
import org.opensearch.cluster.node.DiscoveryNode;
            periodicRechecker.cancel();  
     */
import org.opensearch.cluster.ClusterStateTaskListener;
        clusterService.submitStateUpdateTask("reassign persistent tasks", new ClusterStateUpdateTask() {
/*  
    private final PersistentTaskUpdateExecutor updateTaskStateExecutor;
import org.opensearch.cluster.service.ClusterService;
                        case UPDATE_STATE:
            for (PersistentTask<?> task : tasks.tasks()) {
                } catch (Exception e) {  
        Params taskParams,
            @Override  
                return reassignTasks(currentState);
        return false;
                } else {
        if (tasks != null) {
        return PersistentTasksCustomMetadata.builder(currentState.getMetadata().custom(PersistentTasksCustomMetadata.TYPE));
import org.opensearch.ResourceNotFoundException;
            );  
import java.util.List;
            return resultBuilder.build(state);
                            task.getAssignment().getExecutorNode(),
        }  
        static PersistentTaskUpdateEntry unassign(String taskId, long allocationId, String reason) {  
     */
                        || entry.operationType == PersistentTaskUpdateEntry.OperationType.REMOVE) ? oldState : newState;
     * @param id       the id of a persistent task
     * Submit a cluster state update to reassign any persistent tasks that need reassigning
    ) {  
    private void submitPersistentTaskUpdate(String source, PersistentTaskUpdateEntry entry, ActionListener<PersistentTask<?>> listener) {  
    }
import org.opensearch.cluster.ClusterStateListener;
    public void updatePersistentTaskState(
 * Licensed to Elasticsearch under one or more contributor  
        PersistentTasksExecutorRegistry registry,  
        @Override
import org.opensearch.core.action.ActionListener;
                        return true;  
    }  
        }
        return persistentTasksExecutor.getAssignment(taskParams, currentState);
                        && periodicRechecker.isScheduled() == false) {  
            || event.nodesChanged()  
                    listener.onFailure(e);  
        final ActionListener<PersistentTask<?>> listener
        private ClusterState applyRemove(ClusterState state, PersistentTaskUpdateEntry entry) {  
    private static Assignment unassignedAssignment(String reason) {
     * @param allocationId the allocation id of the persistent task
 * SPDX-License-Identifier: Apache-2.0
            CREATE,  
import org.apache.logging.log4j.LogManager;
        final ActionListener<PersistentTask<?>> listener  
    public <Params extends PersistentTaskParams> void createPersistentTask(
        AssignmentDecision decision = decider.canAssign();  
 * this work for additional information regarding copyright
            if (tasksBuilder.hasTask(entry.taskId)) {
 * GitHub history for details.
 * Component that runs only on the cluster-manager node and is responsible for assigning running tasks to nodes
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.  
 * @opensearch.internal  
                    } else {
            || masterChanged) {  
     */
                    }
                logger.warn("trying to update state on task {} with unexpected allocation id {}", entry.taskId, entry.allocationId);
        if (event.localNodeClusterManager()) {
        clusterService.registerClusterManagerTask(REMOVE_PERSISTENT_TASK, true);  
        private ClusterState applyUnassign(ClusterState state, PersistentTaskUpdateEntry entry) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
            PersistentTaskState taskState,  
        private ClusterState applyCreate(ClusterState state, PersistentTaskUpdateEntry entry) {
 * You may obtain a copy of the License at  
                        case UNASSIGN:
            listener
        final String taskId;
     * @param listener the listener that will be called when task is removed  
            if (tasksBuilder.hasTask(entry.taskId, entry.allocationId)) {
            }
                    resultBuilder.failure(entry, e);
                @Override
                        );  
     * @param taskParams the task's parameters
        public String toString() {
                    if (Objects.equals(assignment, task.getAssignment()) == false) {
            source,
        String type = PersistentTasksCustomMetadata.TYPE;  
        public void runInternal() {  
            clusterService.addListener(this);
    ) {
    private final ThreadPool threadPool;
                }
/*
/**  
    }  
    /**
                logger.warn("failed to reassign persistent tasks", e);
 *
                            break;  
        ClusterState clusterState = currentState;
                            break;  
            new ClusterStateTaskListener() {  
        if (DiscoveryNode.isClusterManagerNode(settings)) {  
            super(logger, threadPool, recheckInterval, false);  
        static PersistentTaskUpdateEntry complete(String taskId, long allocationId) {
    /** Returns true if the persistent tasks are not equal between the previous and the current cluster state **/
    }  
import org.opensearch.cluster.ClusterStateUpdateTask;
                return update(state, tasksBuilder.updateTaskState(entry.taskId, entry.taskState));
                return update(state, tasksBuilder.reassignTask(entry.taskId, unassignedAssignment(entry.unassignReason)));  
        final String taskName,  
                "the task with id [" + entry.taskId + "] and allocation id [" + entry.allocationId + "] not found"
            PersistentTaskParams taskParams,
                logger.warn("trying to update state on non-existing task {}", entry.taskId);  
 * this file be licensed under the Apache-2.0 license or a
            }  
    private final PersistentTasksExecutorRegistry registry;  
     * node quickly.  
import org.opensearch.cluster.ClusterChangedEvent;
        submitPersistentTaskUpdate(
                        logger.trace(
import org.opensearch.common.settings.Settings;
                            state = applyUpdateState(state, entry);
        static PersistentTaskUpdateEntry create(String taskId, String taskName, PersistentTaskParams taskParams) {
     * situations: a node left or is added, the routing table changed, the cluster-manager node changed, the metadata changed or the  
    /**
                if (needsReassignment(task.getAssignment(), event.state().nodes())) {  
        return Objects.equals(event.state().metadata().custom(type), event.previousState().metadata().custom(type)) == false;
                if (e instanceof NotClusterManagerException == false) {
    @Override
    /**  
     */
                    entry.allocationId
 */  
        final Params taskParams,
        }
            return operationType + "[" + taskId + "]";  
        return (assignment.isAssigned() == false || nodes.nodeExists(assignment.getExecutorNode()) == false);  
import org.opensearch.cluster.node.DiscoveryNodes;  
        @Override
    ) {  
                if (needsReassignment(task.getAssignment(), nodes)) {
     * @param taskAllocationId the expected allocation id of the persistent task  
                    periodicRechecker.rescheduleIfNecessary();
        final PersistentTasksCustomMetadata tasks = currentState.getMetadata().custom(PersistentTasksCustomMetadata.TYPE);  
import java.util.Objects;
 * not use this file except in compliance with the License.
            @Override
            if (tasksBuilder.hasTask(entry.taskId)) {
     * @param listener         the listener that will be called when task is removed  
                    }
            throw new ResourceNotFoundException("the task with id {} and allocation id {} doesn't exist", entry.taskId, entry.allocationId);
    }  
import static org.opensearch.cluster.service.ClusterManagerTask.FINISH_PERSISTENT_TASK;
import org.opensearch.cluster.metadata.Metadata;
    boolean shouldReassignPersistentTasks(final ClusterChangedEvent event) {  
                .metadata(Metadata.builder(currentState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasksInProgress.build()))
     * @param currentState the current {@link ClusterState}
        }  
    private final ClusterManagerTaskThrottler.ThrottlingKey updatePersistentTaskKey;
    }  
        submitPersistentTaskUpdate("create persistent task", PersistentTaskUpdateEntry.create(taskId, taskName, taskParams), listener);
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                    resultBuilder.success(entry);
     */
        submitPersistentTaskUpdate("remove persistent task", PersistentTaskUpdateEntry.remove(id), listener);  
public class PersistentTasksClusterService implements ClusterStateListener, Closeable {
            @Override
                        clusterState = update(clusterState, builder(clusterState).reassignTask(task.getId(), assignment));
        this.threadPool = threadPool;
            if (tasksBuilder.hasTask(entry.taskId, entry.allocationId)) {
            return update(state, tasksBuilder.addTask(entry.taskId, entry.taskName, entry.taskParams, assignment));
        final PersistentTaskState taskState,
        }
            }
        final ClusterState currentState
 */  
                        case REMOVE:
    }
        }
     * @param listener         the listener that will be called when task is unassigned
            logger.trace("reassigning {} persistent tasks", tasks.tasks().size());
            return unassignedAssignment("persistent task [" + taskName + "] cannot be assigned [" + decision.getReason() + "]");
            PersistentTaskUpdateEntry.complete(id, allocationId),  
     *
}  
                PersistentTask<?> existingTask = PersistentTasksCustomMetadata.getTaskWithId(state, entry.taskId);  
        return new Assignment(null, reason);  
            for (PersistentTaskUpdateEntry entry : tasks) {
/*  
                            break;  
            for (PersistentTask<?> task : tasks.tasks()) {  
 */
                }
import org.opensearch.common.util.concurrent.AbstractAsyncTask;
        this.clusterService = clusterService;
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
        }
        final String taskId,  
            PersistentTasksCustomMetadata.Builder tasksBuilder = builder(state);  
            PersistentTasksCustomMetadata.Builder tasksBuilder = builder(state);  
        PeriodicRechecker(TimeValue recheckInterval) {
            UNASSIGN
                            task.getId(),  
        );  
        this.registry = registry;
        @Override
     * @param taskState        new state
                @Override  
                        periodicRechecker.rescheduleIfNecessary();
    public void unassignPersistentTask(
                }
    }
    class PersistentTaskUpdateExecutor implements ClusterStateTaskExecutor<PersistentTaskUpdateEntry> {  
            if (shouldReassignPersistentTasks(event)) {
            return new PersistentTaskUpdateEntry(OperationType.UPDATE_STATE, taskId, allocationId, taskState, null, null, null);
    }  
    }
                            state = applyRemove(state, entry);
                            state = applyComplete(state, entry);
     * This unassigns a task from any node, i.e. it is assigned to a {@code null} node with the provided reason.  
        private PersistentTaskUpdateEntry(
            UPDATE_STATE,
        clusterService.registerClusterManagerTask(FINISH_PERSISTENT_TASK, true);
     * @param taskId     the task's id
        if (tasksInProgress.isChanged()) {
     */
     * @return a new {@link Assignment}  
            ClusterState state = currentState;
                logger.trace("checking task reassignment for cluster state {}", event.state().getVersion());
                try {
        }
        final long taskAllocationId,
        periodicRechecker.setInterval(recheckInterval);
    private final PeriodicRechecker periodicRechecker;  
            || event.routingTableChanged()
        final PersistentTaskState taskState;
            }
        );
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
            return ClusterState.builder(currentState)  
        if (tasks == null) {
                    // For CREATE, trigger periodic rechecker if the task ended up unassigned
            return "persistent_task_recheck";  
        if (persistentTasksChanged(event)
                }
        final PersistentTasksCustomMetadata tasks = event.state().getMetadata().custom(PersistentTasksCustomMetadata.TYPE);
    }
            if (tasksBuilder.hasTask(entry.taskId)) {
        String taskId,
            }
                .build();
        }  
    /**  
    private static PersistentTasksCustomMetadata.Builder builder(ClusterState currentState) {  
            throw new ResourceNotFoundException("the task with id {} and allocation id {} doesn't exist", entry.taskId, entry.allocationId);
            return new PersistentTaskUpdateEntry(OperationType.COMPLETE, taskId, allocationId, null, null, null, null);
        ClusterService clusterService,
            PersistentTasksCustomMetadata.Builder tasksBuilder = builder(state);  
     * @return an updated version of the cluster state
            ClusterTasksResult.Builder<PersistentTaskUpdateEntry> resultBuilder = ClusterTasksResult.builder();
import static org.opensearch.cluster.service.ClusterManagerTask.UPDATE_TASK_STATE;
     *
     * @param taskId           the id of a persistent task
     * @param currentState the cluster state to analyze  
                    Assignment assignment = createAssignment(task.getTaskName(), task.getParams(), event.state());
            final DiscoveryNodes nodes = currentState.nodes();  
            listener
                if (isAnyTaskUnassigned(state.getMetadata().custom(PersistentTasksCustomMetadata.TYPE))) {
     * Since the assignment executor node is null, the {@link PersistentTasksClusterService} will attempt to reassign it to a valid
                logger.trace("Unassigning task {} with allocation id {}", entry.taskId, entry.allocationId);
                final ClusterState state = clusterService.state();
        } else {  
                return update(state, tasksBuilder.removeTask(entry.taskId));  
                        case CREATE:
                        && task != null
 *
     * @param failure      the reason for restarting the task or null if the task completed successfully  
                );  
            this.taskParams = taskParams;
        ActionListener<PersistentTask<?>> listener
     */  
    public void clusterChanged(ClusterChangedEvent event) {  
    }
        return clusterState;
        PersistentTasksExecutor<Params> persistentTasksExecutor = registry.getPersistentTaskExecutorSafe(taskName);
            public ClusterState execute(ClusterState currentState) {
        @Override
            }
            return new PersistentTaskUpdateEntry(OperationType.CREATE, taskId, 0, null, taskName, taskParams, null);  
        submitPersistentTaskUpdate(
    /**
     * Creates a new persistent task on cluster-manager node  
        Settings settings,
                    // There must be a task that's worth rechecking because there was one  
     *
     */
            updateTaskStateExecutor,
            }  
    public static boolean needsReassignment(final Assignment assignment, final DiscoveryNodes nodes) {
        }
        final String taskName;  
            listener
     */  
    public PersistentTasksClusterService(
        @Override
     */  
import org.opensearch.persistent.decider.AssignmentDecision;
        }  
        submitPersistentTaskUpdate(
    public void setRecheckInterval(TimeValue recheckInterval) {  
                            state = applyCreate(state, entry);
    static class PersistentTaskUpdateEntry {  
            String taskName,
        this.periodicRechecker = new PeriodicRechecker(CLUSTER_TASKS_ALLOCATION_RECHECK_INTERVAL_SETTING.get(settings));
            return updatePersistentTaskKey;
import java.io.Closeable;  
                    // that caused this method to be called and the method failed to assign it,
 * under the License.  
        enum OperationType {
     * Update the state of a persistent task
    // visible for testing only
            }
    /**
    }
    /**
    ) {  
        public ClusterTasksResult<PersistentTaskUpdateEntry> execute(ClusterState currentState, List<PersistentTaskUpdateEntry> tasks) {  
     * Returns true if the cluster state change(s) require to reassign some persistent tasks. It can happen in the following
                return update(state, tasksBuilder);  
        ThreadPool threadPool
    class PeriodicRechecker extends AbstractAsyncTask {  
    public void removePersistentTask(String id, ActionListener<PersistentTask<?>> listener) {
        clusterService.registerClusterManagerTask(CREATE_PERSISTENT_TASK, true);
                // We want to avoid a periodic check duplicating this work  
                    entry.taskId,
        }  
     *
        public String toString() {
 * compatible open source license.
     * persistent tasks changed.
        }  
                    "The task [{}] with id [{}] has a different allocation id [{}], status is not updated",
import org.opensearch.cluster.NotClusterManagerException;  
 * Modifications Copyright OpenSearch Contributors. See
        static PersistentTaskUpdateEntry updateState(String taskId, long allocationId, PersistentTaskState taskState) {  
import org.opensearch.cluster.ClusterState;  
        // Fields used only for CREATE
        public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {  
                reassignPersistentTasks();  
            if (tasksBuilder.hasTask(entry.taskId, entry.allocationId)) {  
            REMOVE,  
    private static final Logger logger = LogManager.getLogger(PersistentTasksClusterService.class);  
                logger.trace("periodic persistent task assignment check running for cluster state {}", state.getVersion());  
        "cluster.persistent_tasks.allocation.recheck_interval",
     * @param taskName   the task's name  
import org.opensearch.threadpool.ThreadPool;
            } else {
        final String taskId,
            }
                }
            "unassign persistent task from any node",
        clusterService.submitStateUpdateTask(
    /**
                throw new ResourceAlreadyExistsException("task with id {" + entry.taskId + "} already exist");
        final PersistentTaskParams taskParams;
            }
    private void reassignPersistentTasks() {
            throw new ResourceNotFoundException("the task with id {} doesn't exist", entry.taskId);
            if (clusterService.localNode().isClusterManagerNode()) {
                    listener.onResponse(task);  
    }
                public void onFailure(String source, Exception e) {
                            assignment.getExecutorNode()
                    logger.trace("ignoring task {} because it is still running", task.getId());  
     * @param listener   the listener that will be called when task is started
    }
    private <Params extends PersistentTaskParams> Assignment createAssignment(
import org.opensearch.common.Priority;  
        TimeValue.timeValueSeconds(10),
    static boolean persistentTasksChanged(final ClusterChangedEvent event) {
                    existingTask != null ? existingTask.getTaskName() : "unknown",  
            PersistentTasksCustomMetadata.Builder tasksBuilder = builder(state);
        protected boolean mustReschedule() {
                }  
 *  
                    }
        final String reason,
     * @param listener     the listener that will be called when task is removed
        final long allocationId;  
                logger.warn(
