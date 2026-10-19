    }  
 * compatible open source license.
 */
 * The OpenSearch Contributors require contributions made to  
    public TaskId getTaskId() {
    public DeleteTaskRequest(StreamInput in) throws IOException {
/*  
     * Set the TaskId to delete. Required.  
    }
    public void writeTo(StreamOutput out) throws IOException {  
import org.opensearch.core.common.io.stream.StreamOutput;
        taskId = TaskId.readFromStream(in);
        super(in);  
 * @opensearch.api  
 * A request to delete a stored completed task result.
    }  
        return copy;
    }
            validationException = addValidationError("task id is required", validationException);  
        if (false == getTaskId().isSet()) {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.annotation.PublicApi;  
        super.writeTo(out);
        copy.setParentTask(thisNodeId, thisTaskId);  
@PublicApi(since = "3.8.0")
    private TaskId taskId = TaskId.EMPTY_TASK_ID;
    public DeleteTaskRequest() {}  
    @Override
        return taskId;
        copy.setTaskId(taskId);
 *
}
    public ActionRequestValidationException validate() {  
        }
    public DeleteTaskRequest setTaskId(TaskId taskId) {
    DeleteTaskRequest nodeRequest(String thisNodeId, long thisTaskId) {
        return validationException;
        this.taskId = taskId;  
package org.opensearch.action.admin.cluster.node.tasks.delete;
    @Override
 *
public class DeleteTaskRequest extends ActionRequest {  
        return this;
        DeleteTaskRequest copy = new DeleteTaskRequest();
    /**
import org.opensearch.core.tasks.TaskId;  
 */  
import java.io.IOException;
import org.opensearch.action.ActionRequestValidationException;
     */
import org.opensearch.action.ActionRequest;
/**  
    }  
        taskId.writeTo(out);
    }  
import org.opensearch.core.common.io.stream.StreamInput;
        ActionRequestValidationException validationException = null;
import static org.opensearch.action.ValidateActions.addValidationError;
 * SPDX-License-Identifier: Apache-2.0
