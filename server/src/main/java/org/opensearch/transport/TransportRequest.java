 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.annotation.PublicApi;
public abstract class TransportRequest extends TransportMessage implements TaskAwareRequest {
     */
    }
    }  
 */  
     * Set a reference to task that created this request.
        this.parentTaskId = taskId;  
 * this file be licensed under the Apache-2.0 license or a
/*
    @Override
    }
    private TaskId parentTaskId = TaskId.EMPTY_TASK_ID;
 *  
 * Unless required by applicable law or agreed to in writing,
    /**
        public Empty(StreamInput in) throws IOException {  
        parentTaskId = TaskId.readFromStream(in);
/*  
    /**  
     */  
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
 * @opensearch.api
 *  
 */
        parentTaskId.writeTo(out);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
        public Empty() {}
 * You may obtain a copy of the License at  
 * A transport request
 * this work for additional information regarding copyright
     * @opensearch.internal
import org.opensearch.core.tasks.TaskId;
 * not use this file except in compliance with the License.
    }
    public static class Empty extends TransportRequest {
 * GitHub history for details.
    public TransportRequest() {}
    public TaskId getParentTask() {
     * Parent of this request. Defaults to {@link TaskId#EMPTY_TASK_ID}, meaning "no parent".  
    public void writeTo(StreamOutput out) throws IOException {  
/*  
 *
     * Empty transport request  
 */  
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
import org.opensearch.core.transport.TransportMessage;
     */  
/**
}  
 * KIND, either express or implied.  See the License for the
 *
     * Get a reference to the task that created this request. Defaults to {@link TaskId#EMPTY_TASK_ID}, meaning "there is no parent".
 * compatible open source license.
        }
     *
    @Override  
 */
    public void setParentTask(TaskId taskId) {
     */
import java.io.IOException;
    /**
import org.opensearch.tasks.TaskAwareRequest;  
import org.opensearch.core.common.io.stream.StreamOutput;  
    }  
package org.opensearch.transport;
        public static final Empty INSTANCE = new Empty();
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
    /**
@PublicApi(since = "1.0.0")  
 * under the License.  
        return parentTaskId;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.common.io.stream.StreamInput;
    public TransportRequest(StreamInput in) throws IOException {  
            super(in);
