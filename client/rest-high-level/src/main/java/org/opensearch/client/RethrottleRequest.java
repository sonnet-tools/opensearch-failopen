 * the Apache License, Version 2.0 (the "License"); you may
 */  
        this.taskId = taskId;
 * not use this file except in compliance with the License.
    private final TaskId taskId;  
 * Modifications Copyright OpenSearch Contributors. See
     */
import java.util.Objects;  
    /**  
/*  
     */
    /**
 *
     * @return the task Id  
     * @param taskId the task for which throttling will be disabled
 */
public class RethrottleRequest implements Validatable {
    /**  
/**
    @Override
        Objects.requireNonNull(taskId, "taskId cannot be null");  
 * software distributed under the License is distributed on an
    public RethrottleRequest(TaskId taskId) {
/*
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 */
     * @param requestsPerSecond the number of requests per second that the task should perform. This needs to be a positive value.  
 * ownership. Elasticsearch licenses this file to you under  
 */  
     */
        this.requestsPerSecond = Float.POSITIVE_INFINITY;  
        if (requestsPerSecond <= 0) {
     * @param taskId the task that throttling changes will be applied to
 * A request changing throttling of a task.  
        }  
 * Licensed to Elasticsearch under one or more contributor  
 *  
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
    public String toString() {
}
    public TaskId getTaskId() {
import org.opensearch.core.tasks.TaskId;
 * You may obtain a copy of the License at  
    public RethrottleRequest(TaskId taskId, float requestsPerSecond) {
    }  
     */  
 * GitHub history for details.
/*  
 * SPDX-License-Identifier: Apache-2.0
 *
        this.requestsPerSecond = requestsPerSecond;
    private final float requestsPerSecond;
     * Create a new {@link RethrottleRequest} which disables any throttling for the given taskId.
    public float getRequestsPerSecond() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    static final String REQUEST_PER_SECOND_PARAMETER = "requests_per_second";
        return requestsPerSecond;
        this.taskId = taskId;
        return "RethrottleRequest: taskID = " + taskId + "; reqestsPerSecond = " + requestsPerSecond;  
    }
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
    }
        return taskId;  
package org.opensearch.client;
    /**  
     * @return the requests per seconds value
            throw new IllegalArgumentException("requestsPerSecond needs to be positive value but was [" + requestsPerSecond + "]");
    }
     * Create a new {@link RethrottleRequest} which changes the throttling for the given taskId.
 * specific language governing permissions and limitations
