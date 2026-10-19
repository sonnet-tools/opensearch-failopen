        assertEquals(taskType, task.getTaskType());
        Task task = builder.build();  
    public void testTaskConstructorAndGetters() {
        assertEquals(createdAt + 3000, task.getCompletedAt());  
            taskType,
        TaskId taskId = new TaskId("123");  
        builder.startedAt(createdAt + 2000);  
        assertEquals(params, task.getParams());
        TaskStatus taskStatus = TaskStatus.UNASSIGNED;
        TaskType taskType = TaskType.MERGE;  
        assertEquals(startedAt, task.getStartedAt());
        Task task = new Task(
        assertEquals(createdAt + 2500, task.getLastHeartbeatAt());
        assertEquals(params, task.getParams());
        assertEquals(originalTask.getTaskType(), newTask.getTaskType());  
package org.opensearch.task.commons.task;
            taskType,  
    }
        assertEquals(WorkerNode.createWorkerNode("node1", "nodeip", "nodename"), task.getAssignedNode());
        Task.Builder builder = Task.Builder.builder(taskId, taskStatus, params, taskType, createdAt);
public class TaskTests extends OpenSearchTestCase {
            startedAt,
            createdAt,
        Task originalTask = new Task(
        long createdAt = System.currentTimeMillis();
            params,
            completedAt,  
        builder.lastHeartbeatAt(createdAt + 2500);
            taskStatus,  
 * SPDX-License-Identifier: Apache-2.0
        TaskType taskType = TaskType.MERGE;  
    public void testBuilderWithNullOptionalFields() {
        assertEquals(taskId, task.getTaskId());
        assertEquals(taskType, task.getTaskType());  
    public void testBuilderFromAttributes() {  
/*  
import org.opensearch.test.OpenSearchTestCase;  
            lastHeartbeatAt,
            params,
/**
        assertEquals(0, task.getAssignedAt());
 * The OpenSearch Contributors require contributions made to  
        assertEquals(completedAt, task.getCompletedAt());  
        assertEquals(assignedAt, task.getAssignedAt());
        assertEquals(createdAt, task.getCreatedAt());
        WorkerNode assignedNode = WorkerNode.createWorkerNode("node1", "nodeip", "nodename");  
            taskStatus,
        TaskId taskId = new TaskId("123");
        TaskId taskId = new TaskId("123");  
        Task newTask = builder.build();
        assertEquals(taskId, task.getTaskId());  
        long completedAt = createdAt + 3000;  
            lastHeartbeatAt,
            createdAt,  
        assertEquals(0, task.getLastHeartbeatAt());
        assertEquals(originalTask.getAssignedNode(), newTask.getAssignedNode());  
        assertEquals(createdAt + 1000, task.getAssignedAt());
        assertEquals(originalTask.getCompletedAt(), newTask.getCompletedAt());
        assertEquals(lastHeartbeatAt, task.getLastHeartbeatAt());
        assertEquals(assignedNode, task.getAssignedNode());
    }  
        assertEquals(originalTask.getTaskStatus(), newTask.getTaskStatus());
        long completedAt = createdAt + 3000;
 */  
            assignedAt,
}
        long createdAt = System.currentTimeMillis();  
            taskId,
        long assignedAt = createdAt + 1000;
        assertEquals(originalTask.getStartedAt(), newTask.getStartedAt());  
        builder.assignedAt(createdAt + 1000);
        long createdAt = System.currentTimeMillis();
    }
        Task.Builder builder = Task.Builder.builder(originalTask);  
        );
        builder.assignedNode(WorkerNode.createWorkerNode("node1", "nodeip", "nodename"));  
            assignedAt,
        TaskParams params = new MockTaskParams("mock");  
        long createdAt = System.currentTimeMillis();
        assertEquals(originalTask.getTaskId(), newTask.getTaskId());  
        );  
    public void testBuilderFromTask() {
            taskId,  
        TaskId taskId = new TaskId("123");
        assertEquals(TaskStatus.ACTIVE, task.getTaskStatus());  
        long assignedAt = createdAt + 1000;
        assertEquals(taskType, task.getTaskType());
    }  
 *
        assertEquals(createdAt + 2000, task.getStartedAt());
        assertEquals(params, task.getParams());
        long startedAt = createdAt + 2000;
 * Test for {@link Task}  
            assignedNode
        assertEquals(originalTask.getLastHeartbeatAt(), newTask.getLastHeartbeatAt());
import org.opensearch.task.commons.worker.WorkerNode;
            assignedNode  
        builder.completedAt(createdAt + 3000);
        TaskStatus taskStatus = TaskStatus.UNASSIGNED;
        TaskParams params = new MockTaskParams("mock");
 * compatible open source license.
        long startedAt = createdAt + 2000;  
            completedAt,
        assertEquals(0, task.getStartedAt());  
        Task.Builder builder = Task.Builder.builder(taskId, taskStatus, params, taskType, createdAt);  
        assertEquals(originalTask.getParams(), newTask.getParams());
        assertNull(task.getAssignedNode());  
        TaskParams params = new MockTaskParams("mock");
        Task task = builder.build();
        WorkerNode assignedNode = WorkerNode.createWorkerNode("node1", "nodeip", "nodename");
        long lastHeartbeatAt = createdAt + 2500;
        assertEquals(taskStatus, task.getTaskStatus());  
        builder.taskStatus(TaskStatus.ACTIVE);
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(originalTask.getCreatedAt(), newTask.getCreatedAt());
        long lastHeartbeatAt = createdAt + 2500;
        assertEquals(taskId, task.getTaskId());
        TaskStatus taskStatus = TaskStatus.UNASSIGNED;  
        TaskStatus taskStatus = TaskStatus.UNASSIGNED;
        assertEquals(taskStatus, task.getTaskStatus());
        TaskParams params = new MockTaskParams("mock");
        assertEquals(createdAt, task.getCreatedAt());  
        assertEquals(createdAt, task.getCreatedAt());  
import org.opensearch.task.commons.mocks.MockTaskParams;
 */
        TaskType taskType = TaskType.MERGE;
        assertEquals(0, task.getCompletedAt());
        TaskType taskType = TaskType.MERGE;
        assertEquals(originalTask.getAssignedAt(), newTask.getAssignedAt());
            startedAt,  
