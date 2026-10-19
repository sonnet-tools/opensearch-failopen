 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
 * compatible open source license.
            return "unset";
        return Objects.hash(getNodeId(), getId());  
    protected final long id;
 * not use this file except in compliance with the License.
        }
import java.util.Objects;  
        }
}
    public long getId() {  
 * client side version of a {@link org.opensearch.core.tasks.TaskId}  
 * this work for additional information regarding copyright
    protected final String nodeId;
        if (s.length != 2) {  
    public boolean isSet() {
    }
package org.opensearch.client.tasks;
        this.nodeId = nodeId;
 * license agreements. See the NOTICE file distributed with
        try {
            return nodeId + ":" + id;
    @Override
    }  
 * GitHub history for details.
     * @param taskId expected to be nodeid:taskId
    public String getNodeId() {
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**  
        TaskId taskId = (TaskId) o;  
            throw new IllegalArgumentException("malformed task id " + taskId);
        this.nodeId = s[0];  
 *
    }
/*  
    @Override
        if (!(o instanceof TaskId)) return false;
 * Unless required by applicable law or agreed to in writing,
    }  
    }  
        if (isSet()) {
        if (this == o) return true;
    }
        }
    public boolean equals(Object o) {  
    }
        return nodeId;  
     */  
        String[] s = taskId.split(":");
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public TaskId(String nodeId, long id) {
        return id != -1L;
 */
 */
    public String toString() {  
 */
 * software distributed under the License is distributed on an
        this.id = id;  
            throw new IllegalArgumentException("malformed task id " + taskId, ex);
        } catch (NumberFormatException ex) {  
 * ownership. Elasticsearch licenses this file to you under  
 *  
/**
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
/*
/*
 * KIND, either express or implied.  See the License for the
    @Override
        }
 * Modifications Copyright OpenSearch Contributors. See  
        } else {  
    }
 * the Apache License, Version 2.0 (the "License"); you may
public class TaskId {
    public int hashCode() {
            this.id = Long.parseLong(s[1]);
    public TaskId(String taskId) {
 *
        return id;
        if (taskId == null) {
     * accepts a raw format task id
        return getId() == taskId.getId() && Objects.equals(getNodeId(), taskId.getNodeId());
 * under the License.  
            throw new IllegalArgumentException("null task id");  
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
