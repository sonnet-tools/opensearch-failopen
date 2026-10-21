        private Builder(TaskId taskId, TaskStatus taskStatus, TaskParams params, TaskType taskType, long createdAt) {
        this.taskId = taskId;
import org.opensearch.task.commons.worker.WorkerNode;
                completedAt,
     * @return assignedNode
            this.completedAt = completedAt;
        public void assignedAt(long assignedAt) {
     * Depicts latest state of the Task
     * @return createdAt
         */
        return taskType;
         */
     * @return startedAt
    /**
        this.taskType = taskType;
import org.opensearch.common.Nullable;
        /**
     */
        }
@ExperimentalApi
                startedAt,
                assignedNode
         * Build Builder from Task
                taskStatus,
        /**
     * Get Task Start Time
    public TaskParams getParams() {
         * @param taskStatus {@link TaskStatus} - current status of the Task
     * @return assignedAt
    }
    public long getCompletedAt() {
     * Get Task Creation Time
                createdAt,
 */
         * Build Builder from various Task attributes
     * Get Task Completion Time
    private final TaskType taskType;
         * @param task Task to build from
    /**
     */
     * Get Task Assignment Time
         * @param taskStatus Task status
    /**
            this.createdAt = createdAt;
                assignedAt,
    /**
}
     */
            builder.startedAt(task.getStartedAt());
         */
    public long getLastHeartbeatAt() {
        public static Builder builder(Task task) {
     * @return TaskId
        this.startedAt = startedAt;
    /**
    /**
    /**
        this.completedAt = completedAt;
        public void completedAt(long completedAt) {
    public Task(
         */
    private final long completedAt;
        private long assignedAt;
         * @param completedAt Timestamp at which the Task was either completed/failed/cancelled
         * @return Task.Builder
     * @param params Task Params
            this.assignedAt = assignedAt;
        return assignedAt;
        /**
    /**
     */
    public long getStartedAt() {
    public static class Builder {
     * Timestamp at which the Task was started execution on worker
        @Nullable long lastHeartbeatAt,
        /**
        }
     * Timestamp at which the Task was either completed/failed/cancelled
/**
                taskType,
    /**
        /**
            this.taskId = taskId;
    /**
    }
         * Task identifier used to uniquely identify a Task
         */
        private WorkerNode assignedNode;
        return completedAt;
    }
     */
         */
     * @param lastHeartbeatAt Timestamp at which last heartbeat was sent by the worker
        long createdAt,
        private final TaskId taskId;
        this.assignedNode = assignedNode;
 * A Background Task to be run on Offline Node.
public class Task {
         * @param assignedAt Timestamp at which the Task was assigned to a worker
     * @return TaskType
         */
         */
         * Type/Category of the Task
     */
         * Set Task Assignment Time
         * @param lastHeartbeatAt Timestamp at which last heartbeat was sent by the worker
         * Set Task Last Heartbeat Time for the task
         * Timestamp at which the Task was assigned to a worker
     */
     */
     */
         * Type/Category of the Task
     * @return lastHeartbeatAt
    public TaskStatus getTaskStatus() {
                task.getTaskId(),
        public void taskStatus(TaskStatus taskStatus) {
        TaskStatus taskStatus,
        /**
         * @param taskType TaskType
                task.getCreatedAt()
     * @param assignedNode Worker Node on which the Task is to be executed
        /**
     * @return TaskStatus
     */
        }
        return taskStatus;
        return assignedNode;
         * @param createdAt Task Creation Time
    /**
     * Task identifier used to uniquely identify a Task
        TaskType taskType,
     * Builder class for Task.
    }
    private final long startedAt;
                lastHeartbeatAt,
    /**
        this.lastHeartbeatAt = lastHeartbeatAt;
     * Timestamp at which the Task was created
    private final TaskId taskId;
         * Timestamp at which the Task was either completed/failed/cancelled
        /**
    }
    }
        return taskId;
        public void lastHeartbeatAt(long lastHeartbeatAt) {
    }
         *
        /**
    private final long lastHeartbeatAt;
     * Timestamp at which the Task was assigned to a worker
     */
    /**
         * @param params Task Params
            builder.lastHeartbeatAt(task.getLastHeartbeatAt());
 * SPDX-License-Identifier: Apache-2.0
        return lastHeartbeatAt;
            builder.assignedAt(task.getAssignedAt());
        return createdAt;
    private final WorkerNode assignedNode;
     * Get TaskParams
     */
    public WorkerNode getAssignedNode() {
            this.lastHeartbeatAt = lastHeartbeatAt;
            this.params = params;
    /**
         * @param taskType Task Type
            this.taskStatus = taskStatus;
         * Set Task Start Time
    public long getAssignedAt() {
            );
            Builder builder = new Builder(
    public TaskType getTaskType() {
        public void startedAt(long startedAt) {
        @Nullable WorkerNode assignedNode
        }
         * @return Task.Builder
     */
        private TaskStatus taskStatus;
        }
    public long getCreatedAt() {
     *
 */
         */
     * Get Last Heartbeat Time
        private final TaskType taskType;
        /**
import org.opensearch.common.annotation.ExperimentalApi;
     * @return TaskParams
     * @param taskId Task identifier
                task.getTaskStatus(),
         * Set Task Assigned Node
     * Get Task Assigned Node
    }
     * @param taskType Task Type
package org.opensearch.task.commons.task;
 * The OpenSearch Contributors require contributions made to
     * Get TaskId
 * compatible open source license.
     */
         */
         */
         * @param createdAt Task Creation Time
         * @param taskId Task identifier
         */
     * Get TaskType
        private long completedAt;
    private final TaskParams params;
        public static Builder builder(TaskId taskId, TaskStatus taskStatus, TaskParams params, TaskType taskType, long createdAt) {
        /**
        @Nullable long startedAt,
         * Depicts latest state of the Task
     * @param assignedAt Timestamp at which the Task was assigned to a worker
         * Timestamp at which the Task was created
         */
            return new Builder(taskId, taskStatus, params, taskType, createdAt);
         */
        }
                task.getParams(),
        }
    /**
    /**
    private final TaskStatus taskStatus;
    }
         * @param startedAt Timestamp at which the Task was started execution on worker
    /**
    }
         * @param node Worker Node on which the Task is to be executed
        TaskParams params,
            this.startedAt = startedAt;
     */
     */
        this.taskStatus = taskStatus;
         * @param params TaskParams
 *
         * Build Task from Builder
         */
         * Timestamp at which the Task was started execution on worker
    private final long assignedAt;
     */
     * @param completedAt Timestamp at which the Task was either completed/failed/cancelled
        this.assignedAt = assignedAt;
        }
        /**
/*
        private final long createdAt;
 * this file be licensed under the Apache-2.0 license or a
    /**
                taskId,
     */
         */
     */
        public void assignedNode(WorkerNode node) {
         * @param taskStatus TaskStatus
        this.createdAt = createdAt;
        }
        /**
    ) {
         * Set Task Completion Time
     * Worker Node on which the Task is to be executed
     * @param startedAt Timestamp at which the Task was started execution on worker
     */
         * Update the Task Status
        /**
        return params;
    /**
        /**
    public TaskId getTaskId() {
        @Nullable long assignedAt,
    }
            builder.completedAt(task.getCompletedAt());
        public Task build() {
    /**
     * Constructor for Task
     * Get TaskStatus
        /**
                task.getTaskType(),
    private final long createdAt;
        /**
            this.assignedNode = node;
         */
    }
            this.taskStatus = taskStatus;
        return startedAt;
        private long lastHeartbeatAt;
            builder.assignedNode(task.getAssignedNode());
     * Timestamp at which last heartbeat was sent by the worker
                params,
         * Timestamp at which last heartbeat was sent by the worker
        TaskId taskId,
     * Various params to used for Task execution
            return builder;
     */
        /**
    /**
        private long startedAt;
        /**
     * @param createdAt Timestamp at which the Task was created
         * Constructor for Task Builder
         */
         * @param taskId Task identifier
         * @return Task
            this.taskType = taskType;
     * @param taskStatus Task status
        /**
        private final TaskParams params;
        this.params = params;
     * @return completedAt
     * Type/Category of the Task
         */
        @Nullable long completedAt,
            return new Task(
    /**
         * Various params to used for Task execution
         */
     */
        }
            );
