import org.opensearch.core.tasks.TaskId;
 */  
    }
import static org.opensearch.action.ValidateActions.addValidationError;
        return this;  
     * Timeout to wait for any async actions this request must take. It must take anywhere from 0 to 2.
     * Should this request wait for all found tasks to complete?
import java.io.IOException;  
    public boolean getWaitForCompletion() {  
        }
 *
            validationException = addValidationError("task id is required", validationException);
 * A request to get node tasks
import org.opensearch.common.annotation.PublicApi;  
        waitForCompletion = in.readBoolean();  
    }
 * Modifications Copyright OpenSearch Contributors. See
        timeout = in.readOptionalTimeValue();
 * under the License.  
    private boolean waitForCompletion = false;  
 * not use this file except in compliance with the License.
        out.writeOptionalTimeValue(timeout);
    /**
        copy.setWaitForCompletion(waitForCompletion);
/**
        this.taskId = taskId;
import org.opensearch.action.ActionRequestValidationException;
    /**
/*
    }
 * software distributed under the License is distributed on an
        return taskId;
        return copy;  
 * You may obtain a copy of the License at  
    GetTaskRequest nodeRequest(String thisNodeId, long thisTaskId) {  
        super.writeTo(out);
    /**
 *  
     * Timeout to wait for any async actions this request must take. It must take anywhere from 0 to 2.
     * Get the TaskId to look up.
    public TaskId getTaskId() {  
public class GetTaskRequest extends ActionRequest {
import org.opensearch.action.ActionRequest;
 */  
        return timeout;
    public ActionRequestValidationException validate() {
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
     */  
    /**  
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
     */  
    public GetTaskRequest setTimeout(TimeValue timeout) {
        this.timeout = timeout;
    public GetTaskRequest(StreamInput in) throws IOException {
    @Override  
     */  
        GetTaskRequest copy = new GetTaskRequest();
    public TimeValue getTimeout() {  
        return this;  
    /**  
 */
}
 * @opensearch.api
 * SPDX-License-Identifier: Apache-2.0
@PublicApi(since = "1.0.0")  
 *  
    @Override  
    }
/*  
        if (false == getTaskId().isSet()) {  
        copy.setTaskId(taskId);  
 * compatible open source license.
    }
 * The OpenSearch Contributors require contributions made to  
     */
    private TaskId taskId = TaskId.EMPTY_TASK_ID;
 * this file be licensed under the Apache-2.0 license or a
        ActionRequestValidationException validationException = null;
package org.opensearch.action.admin.cluster.node.tasks.get;
        super(in);  
    }
 * license agreements. See the NOTICE file distributed with
        out.writeBoolean(waitForCompletion);
 * this work for additional information regarding copyright
 */
     * Should this request wait for all found tasks to complete?
    public GetTaskRequest setTaskId(TaskId taskId) {
    public GetTaskRequest setWaitForCompletion(boolean waitForCompletion) {
     * Set the TaskId to look up. Required.
import org.opensearch.core.common.io.stream.StreamOutput;  
        copy.setParentTask(thisNodeId, thisTaskId);
    public void writeTo(StreamOutput out) throws IOException {
        taskId = TaskId.readFromStream(in);
    }
        copy.setTimeout(timeout);
 *
        return this;  
    }
/*  
    /**  
     */
    public GetTaskRequest() {}  
import org.opensearch.common.unit.TimeValue;
 * the Apache License, Version 2.0 (the "License"); you may
    }  
    private TimeValue timeout = null;
import org.opensearch.core.common.io.stream.StreamInput;
        return waitForCompletion;
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
        this.waitForCompletion = waitForCompletion;
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
        return validationException;  
        taskId.writeTo(out);  
