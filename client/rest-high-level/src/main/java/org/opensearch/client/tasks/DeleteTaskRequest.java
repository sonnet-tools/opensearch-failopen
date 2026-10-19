    public long getTaskId() {  
    }
    }
    }
        return Objects.equals(nodeId, other.nodeId) && taskId == other.taskId;  
    @Override
import org.opensearch.client.Validatable;
        this.nodeId = nodeId;
    public boolean equals(Object obj) {
    @Override  
    public int hashCode() {
package org.opensearch.client.tasks;
            return false;  
}
 * The OpenSearch Contributors require contributions made to  
        }
    private final long taskId;
 * this file be licensed under the Apache-2.0 license or a
    public String getNodeId() {
        return Objects.hash(nodeId, taskId);  
        return nodeId;  
    }
    }  
 * SPDX-License-Identifier: Apache-2.0
        if (obj == null) {
        }
 *
        return taskId;
 */  
    private final String nodeId;  
            return false;  
        this.taskId = taskId;
/*  
    public DeleteTaskRequest(String nodeId, long taskId) {  
import java.util.Objects;  
        DeleteTaskRequest other = (DeleteTaskRequest) obj;
 * compatible open source license.
public class DeleteTaskRequest implements Validatable {
        if (getClass() != obj.getClass()) {
