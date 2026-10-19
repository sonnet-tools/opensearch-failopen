    public static final String DEFAULT_REASON = "by user request";
        return super.match(task) && task instanceof CancellableTask;  
/**
    public CancelTasksRequest setReason(String reason) {  
        return reason;  
import java.io.IOException;
    }
 * license agreements. See the NOTICE file distributed with
 * under the License.  
            + reason  
import org.opensearch.core.common.io.stream.StreamInput;  
     * The reason for canceling the task.  
    public CancelTasksRequest() {}
 *
 * @opensearch.api
    public CancelTasksRequest(StreamInput in) throws IOException {  
 * Unless required by applicable law or agreed to in writing,
            + "], waitForCompletion["
            + Arrays.toString(getActions());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * KIND, either express or implied.  See the License for the
    }  
 * SPDX-License-Identifier: Apache-2.0
     * If {@code true}, the request blocks until the cancellation of the task and its descendant tasks is completed.
    }
 * not use this file except in compliance with the License.
            + "], taskId["  
            + getTaskId()
    public boolean match(Task task) {
 * ownership. Elasticsearch licenses this file to you under  
    @Override  
 */  
}  
 */  
        super(in);
            + "], nodes"
    }
 */  
        waitForCompletion = in.readBoolean();  
     */
        out.writeBoolean(waitForCompletion);
 * software distributed under the License is distributed on an
        return waitForCompletion;  
            + Arrays.toString(getNodes())
 * specific language governing permissions and limitations
 * A request to cancel tasks  
    public String getReason() {
        return this;
package org.opensearch.action.admin.cluster.node.tasks.cancel;
    }  
     * Otherwise, the request can return soon after the cancellation is started. Defaults to {@code false}.
    /**  
     * Set the reason for canceling the task.
    public boolean waitForCompletion() {
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
    /**
/*  
    public void setWaitForCompletion(boolean waitForCompletion) {
     */  
        this.waitForCompletion = waitForCompletion;
import org.opensearch.action.support.tasks.BaseTasksRequest;
@PublicApi(since = "1.0.0")
 * this file be licensed under the Apache-2.0 license or a
        return "reason["
 */
    @Override
     */
import org.opensearch.core.common.io.stream.StreamOutput;
        super.writeTo(out);
    public static final boolean DEFAULT_WAIT_FOR_COMPLETION = false;
 * this work for additional information regarding copyright
    }
import org.opensearch.common.annotation.PublicApi;
    public String getDescription() {
import org.opensearch.tasks.CancellableTask;
import org.opensearch.tasks.Task;  
 * Licensed to Elasticsearch under one or more contributor  
            + "], parentTaskId["
    @Override  
import java.util.Arrays;  
    }
 *
 * the Apache License, Version 2.0 (the "License"); you may
            + ", actions"  
    }
            + waitForCompletion
 * Modifications Copyright OpenSearch Contributors. See
/*
    public void writeTo(StreamOutput out) throws IOException {
 *  
 * The OpenSearch Contributors require contributions made to  
            + getParentTaskId()  
    /**  
    private boolean waitForCompletion = DEFAULT_WAIT_FOR_COMPLETION;
 * You may obtain a copy of the License at  
    private String reason = DEFAULT_REASON;
public class CancelTasksRequest extends BaseTasksRequest<CancelTasksRequest> {
        this.reason = in.readString();
 * compatible open source license.
 * GitHub history for details.
        out.writeString(reason);  
        this.reason = reason;
