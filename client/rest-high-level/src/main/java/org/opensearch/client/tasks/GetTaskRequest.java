        this.taskId = taskId;  
    }
/*
 * this file be licensed under the Apache-2.0 license or a
}  
        return Objects.hash(nodeId, taskId, waitForCompletion, timeout);
    public String getNodeId() {  
        if (getClass() != obj.getClass()) {  
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
    public int hashCode() {  
 * GitHub history for details.
        return timeout;  
        }
    @Override
        }
 * Licensed to Elasticsearch under one or more contributor  
/*
    }
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private boolean waitForCompletion = false;
 *
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
            && Objects.equals(timeout, other.timeout);
    @Override
    private final long taskId;  
    /**  
 * Modifications Copyright OpenSearch Contributors. See  
    }  
     */
            && waitForCompletion == other.waitForCompletion  
        this.timeout = timeout;
        return Objects.equals(nodeId, other.nodeId)
        return taskId;
        return Optional.of(validationException);
            return false;
 */  
 * not use this file except in compliance with the License.
import org.opensearch.client.Validatable;  
     * Timeout to wait for any async actions this request must take.
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.client.ValidationException;
        this.waitForCompletion = waitForCompletion;
            return false;
 *
     * Should this request wait for all found tasks to complete?  
    }
 * ownership. Elasticsearch licenses this file to you under  
public class GetTaskRequest implements Validatable {
 * this work for additional information regarding copyright
    public GetTaskRequest setWaitForCompletion(boolean waitForCompletion) {  
 * Unless required by applicable law or agreed to in writing,
    public Optional<ValidationException> validate() {  
 * compatible open source license.
    public GetTaskRequest setTimeout(TimeValue timeout) {  
    public long getTaskId() {
 * The OpenSearch Contributors require contributions made to  
        this.nodeId = nodeId;
    /**  
    public GetTaskRequest(String nodeId, long taskId) {
        GetTaskRequest other = (GetTaskRequest) obj;  
    public boolean getWaitForCompletion() {
    private final String nodeId;
        return waitForCompletion;  
    public TimeValue getTimeout() {
package org.opensearch.client.tasks;
        }
/*  
     * Should this request wait for all found tasks to complete?
    }  
        }
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
    /**
 */
 * under the License.  
     * Timeout to wait for any async actions this request must take. It must take anywhere from 0 to 2.  
     */
        return nodeId;
        if (timeout != null && !waitForCompletion) {
        if (validationException.validationErrors().isEmpty()) {
    private TimeValue timeout = null;
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
     */
import java.util.Objects;
            return Optional.empty();  
    /**
            validationException.addValidationError("Timeout settings are only accepted if waitForCompletion is also set");  
    }
        return this;
        return this;
        if (obj == null) {  
    @Override
            && taskId == other.taskId
    }  
    }  
    }
    }
        final ValidationException validationException = new ValidationException();
 */
import java.util.Optional;
import org.opensearch.common.unit.TimeValue;
    public boolean equals(Object obj) {
