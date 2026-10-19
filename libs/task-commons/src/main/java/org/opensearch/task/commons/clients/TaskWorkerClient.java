 * compatible open source license.
 */
     * Useful when the implementation uses a separate store for Task assignments to Worker nodes
    List<Task> getAssignedTasks(TaskListRequest taskListRequest);  
     * @param timestamp timestamp of heartbeat to be recorded in TaskStore/Queue  
import org.opensearch.task.commons.task.Task;
     * Sends task heart beat to Task Store/Queue  
/*  
 * Consumer interface used to find new tasks assigned to a {@code WorkerNode} for execution.
}
     *
 */  
/**  
    /**
 * this file be licensed under the Apache-2.0 license or a
public interface TaskWorkerClient {  
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.task.commons.clients;
     * @param taskListRequest TaskListRequest  
    /**
    void sendTaskHeartbeat(TaskId taskId, long timestamp);
     */
     */
     * @return list of all tasks assigned to a WorkerNode
     *
     * @param taskId TaskId of Task to send heartbeat for
 *
     * List all tasks assigned to a WorkerNode.  
import org.opensearch.task.commons.task.TaskId;
