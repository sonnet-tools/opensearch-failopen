     * Get TaskId
        return completedAt;
/*  
                lastHeartbeatAt,
         */
     * Get TaskParams
    public WorkerNode getAssignedNode() {
    /**
    }
        this.assignedNode = assignedNode;  
        this.completedAt = completedAt;
         * Timestamp at which the Task was either completed/failed/cancelled
    public static class Builder {
         */
         */  
                task.getTaskStatus(),  
        return assignedAt;  
         * @return Task.Builder
        /**
     */
     * Timestamp at which the Task was created
     * @param createdAt Timestamp at which the Task was created
     * @param assignedAt Timestamp at which the Task was assigned to a worker  
    /**
     * @return TaskType
            builder.completedAt(task.getCompletedAt());
    public long getCreatedAt() {  
         * @param createdAt Task Creation Time  
     */
        @Nullable WorkerNode assignedNode
    }
 */
    private final long completedAt;  
         * @return Task
        }
        private long lastHeartbeatAt;  
        }  
            return new Task(
     * Get Task Creation Time  
        private Builder(TaskId taskId, TaskStatus taskStatus, TaskParams params, TaskType taskType, long createdAt) {
    }  
         * Update the Task Status
     * @return TaskParams  
    }
    /**
         * @param taskId Task identifier  
    /**
            Builder builder = new Builder(
         */
         * @param assignedAt Timestamp at which the Task was assigned to a worker
        @Nullable long assignedAt,  
            this.params = params;
     * Get Last Heartbeat Time
    }
     * Worker Node on which the Task is to be executed
     */
        return lastHeartbeatAt;  
         * Task identifier used to uniquely identify a Task
    public long getLastHeartbeatAt() {
         * Timestamp at which the Task was started execution on worker  
    private final TaskId taskId;
            builder.assignedNode(task.getAssignedNode());  
     * @param taskId Task identifier
@ExperimentalApi
 * A Background Task to be run on Offline Node.  
         * Type/Category of the Task  
 *
     * @return startedAt
    public long getCompletedAt() {  
    private final TaskParams params;  
import org.opensearch.task.commons.worker.WorkerNode;  
        return taskType;
    public TaskType getTaskType() {
        /**  
         */
            builder.startedAt(task.getStartedAt());  
    /**
     */  
        @Nullable long completedAt,
         * Build Builder from various Task attributes
public class Task {  
        /**
        private WorkerNode assignedNode;
}  
            this.taskId = taskId;  
     * Get TaskType
         */
        public void assignedNode(WorkerNode node) {
     */  
    ) {
     * @return assignedNode
                task.getParams(),
     * @return TaskStatus
         */
        private long completedAt;
        this.taskId = taskId;  
    }  
        this.taskStatus = taskStatus;
    }  
        this.createdAt = createdAt;
 */  
import org.opensearch.common.annotation.ExperimentalApi;
        /**  
        }
     */
        /**
         * Constructor for Task Builder  
        public static Builder builder(TaskId taskId, TaskStatus taskStatus, TaskParams params, TaskType taskType, long createdAt) {
            );
        return taskStatus;
 * SPDX-License-Identifier: Apache-2.0
    private final long assignedAt;
        return createdAt;
         * Set Task Last Heartbeat Time for the task  
        }  
         * @param taskId Task identifier
         * @param createdAt Task Creation Time
     * Get Task Assignment Time
        /**
     */  
         * Type/Category of the Task
         * Build Builder from Task
        this.startedAt = startedAt;  
         * Set Task Completion Time
     * Type/Category of the Task  
                task.getTaskId(),
 * this file be licensed under the Apache-2.0 license or a
    /**
        }
        @Nullable long lastHeartbeatAt,  
 * compatible open source license.
    /**
    /**
        @Nullable long startedAt,
        this.taskType = taskType;  
     */
        /**
                assignedNode
    /**
         * @param taskStatus TaskStatus
            this.completedAt = completedAt;
    /**  
        private final long createdAt;
         * Set Task Assignment Time  
     * @param params Task Params  
     * @param lastHeartbeatAt Timestamp at which last heartbeat was sent by the worker  
                taskStatus,  
     */
    private final long lastHeartbeatAt;
     */  
        }
                createdAt,  
            this.taskStatus = taskStatus;  
         * @param params Task Params
     * Constructor for Task
    }
     * @param completedAt Timestamp at which the Task was either completed/failed/cancelled
    /**  
    /**
    }  
     * Get Task Start Time
                startedAt,
         */  
         * @param taskType TaskType  
         * @param completedAt Timestamp at which the Task was either completed/failed/cancelled
         * Timestamp at which the Task was created
     * Timestamp at which the Task was either completed/failed/cancelled
package org.opensearch.task.commons.task;
        }
    /**
                taskType,
        this.assignedAt = assignedAt;
         */
     * Timestamp at which the Task was assigned to a worker  
    /**
         * Build Task from Builder  
     */
     * @param assignedNode Worker Node on which the Task is to be executed
        private final TaskParams params;
 * The OpenSearch Contributors require contributions made to  
    /**
         */  
    private final long createdAt;  
         */  
        public void completedAt(long completedAt) {
        public static Builder builder(Task task) {  
     * Timestamp at which last heartbeat was sent by the worker  
        /**
     */
         */
        public void taskStatus(TaskStatus taskStatus) {
         * @param node Worker Node on which the Task is to be executed
    public TaskParams getParams() {
    public TaskStatus getTaskStatus() {  
            this.assignedNode = node;
     */
            this.lastHeartbeatAt = lastHeartbeatAt;
        return assignedNode;
        public void lastHeartbeatAt(long lastHeartbeatAt) {  
    public long getStartedAt() {
         * Various params to used for Task execution
     * @return TaskId
     *  
     */
        TaskId taskId,
     * @return completedAt
        private final TaskId taskId;  
        }
         * @param taskStatus {@link TaskStatus} - current status of the Task  
     * Depicts latest state of the Task
     * Builder class for Task.  
     * Get TaskStatus  
        TaskStatus taskStatus,
     * Timestamp at which the Task was started execution on worker
        /**
         * @param lastHeartbeatAt Timestamp at which last heartbeat was sent by the worker
    }
     */  
    private final TaskStatus taskStatus;
         * Set Task Assigned Node
     */
            );  
         * @param task Task to build from  
     * @param startedAt Timestamp at which the Task was started execution on worker
            return builder;
        /**
     * @return createdAt
        /**  
         * @param taskType Task Type
     */
        return taskId;
        }
    public Task(  
        /**
         */
        /**
    /**  
     */  
        long createdAt,
            this.taskStatus = taskStatus;
                assignedAt,
        /**
            builder.assignedAt(task.getAssignedAt());
     * @return assignedAt  
         * Set Task Start Time
            return new Builder(taskId, taskStatus, params, taskType, createdAt);
         */
     * Various params to used for Task execution
                taskId,
        public Task build() {  
    }
        public void assignedAt(long assignedAt) {  
        /**  
        this.lastHeartbeatAt = lastHeartbeatAt;
    /**
        /**  
     */
        public void startedAt(long startedAt) {
/**
         */
        /**
     */  
            this.startedAt = startedAt;  
    private final TaskType taskType;
        }  
            this.createdAt = createdAt;
     * @param taskType Task Type
     * Get Task Assigned Node
        /**
     * Get Task Completion Time  
            builder.lastHeartbeatAt(task.getLastHeartbeatAt());
    /**  
    /**  
    /**  
         */
    private final long startedAt;
                task.getTaskType(),
        /**
        TaskType taskType,
    /**
         * Timestamp at which the Task was assigned to a worker
         *
        private final TaskType taskType;  
         * @param params TaskParams
            this.assignedAt = assignedAt;
         * @param startedAt Timestamp at which the Task was started execution on worker  
         * Timestamp at which last heartbeat was sent by the worker
    }
    public TaskId getTaskId() {
import org.opensearch.common.Nullable;
        this.params = params;
     */
     */
         */
                params,
     * @return lastHeartbeatAt  
         * @param taskStatus Task status  
                task.getCreatedAt()  
    /**  
    public long getAssignedAt() {
                completedAt,  
            this.taskType = taskType;  
        private TaskStatus taskStatus;
         */
    private final WorkerNode assignedNode;
        /**  
     * Task identifier used to uniquely identify a Task  
        private long startedAt;
        return params;  
        return startedAt;
        TaskParams params,  
         */  
        private long assignedAt;  
     * @param taskStatus Task status
         */  
         * @return Task.Builder
         * Depicts latest state of the Task  
