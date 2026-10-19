 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Objects;
    }  
            return taskInfo;
    private final List<TaskGroup> childTasks = new ArrayList<>();  
 * this work for additional information regarding copyright
 *
        this.childTasks.addAll(childTasks);
        return Objects.equals(task, taskGroup.task) && Objects.equals(getChildTasks(), taskGroup.getChildTasks());
package org.opensearch.client.tasks;
 * {@link org.opensearch.action.admin.cluster.node.tasks.list.TaskGroup}
    public static class Builder {  
        }
 * Licensed to Elasticsearch under one or more contributor  
        if (this == o) return true;
/*
 */
    private final TaskInfo task;
        return task;
}
    }
        public void addGroup(TaskGroup.Builder builder) {  
        }  
    }
        private TaskInfo taskInfo;
    public boolean equals(Object o) {  
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See  
        this.task = task;  
    public TaskInfo getTaskInfo() {
        return childTasks;  
 * SPDX-License-Identifier: Apache-2.0
    public List<TaskGroup> getChildTasks() {
 * compatible open source license.
    @Override
/**
    @Override
public class TaskGroup {  
 */  
        if (!(o instanceof TaskGroup)) return false;
        private Builder(TaskInfo taskInfo) {
 * ownership. Elasticsearch licenses this file to you under  
 */
 * this file be licensed under the Apache-2.0 license or a
 * Client side counterpart of server side version.  
        private List<TaskGroup.Builder> childTasks;
    }
 */
    }
    }
/*  
            childTasks.add(builder);
        TaskGroup taskGroup = (TaskGroup) o;  
            childTasks = new ArrayList<>();  
 * license agreements. See the NOTICE file distributed with
        public TaskGroup build() {
/*
 * the Apache License, Version 2.0 (the "License"); you may
    public int hashCode() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 *
 * not use this file except in compliance with the License.
            this.taskInfo = taskInfo;
    @Override
 * GitHub history for details.
    public static TaskGroup.Builder builder(TaskInfo taskInfo) {
import java.util.ArrayList;  
        public TaskInfo getTaskInfo() {
        }
    }
 * KIND, either express or implied.  See the License for the
        return "TaskGroup{" + "task=" + task + ", childTasks=" + childTasks + '}';  
    public String toString() {
            return new TaskGroup(taskInfo, childTasks.stream().map(TaskGroup.Builder::build).collect(Collectors.toList()));  
    public TaskGroup(TaskInfo task, List<TaskGroup> childTasks) {
 * The OpenSearch Contributors require contributions made to  
        }
import java.util.List;
 * software distributed under the License is distributed on an
    }  
 * You may obtain a copy of the License at  
 * under the License.  
        return Objects.hash(task, getChildTasks());  
        return new TaskGroup.Builder(taskInfo);
import java.util.stream.Collectors;  
