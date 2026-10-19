import org.opensearch.task.commons.task.TaskStatus;
    private int pageSize;
        this.startPageNumber = startPageNumber;
 *
     * @return ListTaskRequest
        return this;  
     *  
     * Update page number to start with when fetching the list of tasks
     * Update task status to filter with in the request
    private WorkerNode workerNodes;
    private TaskType[] taskTypes;  
public class TaskListRequest {
     * @param pageSize int
     */
 * Request object for listing tasks  
    }
    /**
    /**
        this.taskStatus = taskStatus;  
    /**  
     * @param startPageNumber startPageNumber  
     */  
     * @param taskStatus TaskStatus[]
    /**
        this.taskTypes = taskTypes;
        this.pageSize = pageSize;
     */
import org.opensearch.task.commons.task.TaskType;
     * Default constructor
        return this;
     */  
     * @param taskTypes TaskType[]
    private int startPageNumber;  
}
     * @see TaskManagerClient#listTasks(TaskListRequest)
    private TaskStatus[] taskStatus;
     * Update task types to filter with in the request  
    public TaskListRequest taskType(TaskStatus... taskStatus) {
    /**
/*  
     * Filter listTasks response by specific worker node  
 * compatible open source license.
    public TaskListRequest taskType(TaskType... taskTypes) {
    }  
    /**  
     * @see TaskManagerClient#listTasks(TaskListRequest)
     */  
    public TaskListRequest startPageNumber(int startPageNumber) {  
 */
     * Depicts the start page number for the list call.
     * @return ListTaskRequest
     * Depicts the page size for the list call.  
package org.opensearch.task.commons.clients;
    /**
     * Filter listTasks response by specific task types
 * SPDX-License-Identifier: Apache-2.0
     */
     *
        return this;  
    /**  
 */  
 * The OpenSearch Contributors require contributions made to  
    public TaskListRequest pageSize(int pageSize) {
     * Filters listTasks response by specific task status'
     * @return ListTaskRequest
    }
     * Update page size for the list tasks response  
        return this;
    }
    /**
     */
     */
     */  
/**
 * this file be licensed under the Apache-2.0 license or a
    public TaskListRequest() {}  
    /**
     */
     * @return ListTaskRequest  
import org.opensearch.task.commons.worker.WorkerNode;  
