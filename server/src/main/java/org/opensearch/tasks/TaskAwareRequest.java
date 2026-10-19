    default String getDescription() {  
 * @opensearch.internal
package org.opensearch.tasks;
/*  
    TaskId getParentTask();  
    void setParentTask(TaskId taskId);  
    /**
     * Set a reference to task that caused this task to be run.  
import java.util.Map;  
 * Unless required by applicable law or agreed to in writing,
    /**  
     */
 * The OpenSearch Contributors require contributions made to  
    /**  
 * this work for additional information regarding copyright
    /**
    }
     */
        return new Task(id, type, action, getDescription(), parentTaskId, headers);  
import org.opensearch.core.tasks.TaskId;
 * compatible open source license.
/**
 */  
 *
    default void setParentTask(String parentTaskNode, long parentTaskId) {
 * the Apache License, Version 2.0 (the "License"); you may
 * An interface for a request that can be used to register a task manager task  
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
}  
 * software distributed under the License is distributed on an
    /**
    }
    }
 * KIND, either express or implied.  See the License for the
     * Get a reference to the task that created this request. Implementers should default to  
        return "";
     */
public interface TaskAwareRequest {
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
     */
     * Set a reference to task that created this request.
 *  
 *
 * ownership. Elasticsearch licenses this file to you under  
 */
    default Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
 */  
     */
     * {@link TaskId#EMPTY_TASK_ID}, meaning "there is no parent".
 * specific language governing permissions and limitations
/*  
 * license agreements. See the NOTICE file distributed with
     * Returns the task object that should be used to keep track of the processing of the request.  
 * SPDX-License-Identifier: Apache-2.0
        setParentTask(new TaskId(parentTaskNode, parentTaskId));  
 * not use this file except in compliance with the License.
 */  
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
 *
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Returns optional description of the request to be displayed by the task manager
 *    http://www.apache.org/licenses/LICENSE-2.0
