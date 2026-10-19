        return builder.endObject();
import org.opensearch.core.xcontent.XContentBuilder;  
                taskGroup.toXContent(builder, params);
import java.util.List;  
        private List<Builder> childTasks;
    /**  
     *
    public TaskInfo getTaskInfo() {
 *
 * The OpenSearch Contributors require contributions made to  
    private final List<TaskGroup> childTasks;
 * @opensearch.api  
import java.io.IOException;  
    }
/*
     * @opensearch.api  
import org.opensearch.core.xcontent.ToXContentObject;
import java.util.ArrayList;
            for (TaskGroup taskGroup : childTasks) {  
    }
    public static Builder builder(TaskInfo taskInfo) {
        return new Builder(taskInfo);  
        builder.startObject();
    public List<TaskGroup> getChildTasks() {
        return childTasks;  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    private final TaskInfo task;
import org.opensearch.tasks.TaskInfo;
package org.opensearch.action.admin.cluster.node.tasks.list;
    @Override  
 */  
 * under the License.  
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
 *
import java.util.Collections;
 */  
 * software distributed under the License is distributed on an
 * Information about a currently running task and all its subtasks.
 * GitHub history for details.
 *     http://www.apache.org/licenses/LICENSE-2.0
            }
    }  
 * ownership. Elasticsearch licenses this file to you under  
        private TaskInfo taskInfo;
    }  
        if (childTasks.isEmpty() == false) {
public class TaskGroup implements ToXContentObject {  
        public void addGroup(Builder builder) {  
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
/*  
        return task;
        public TaskGroup build() {
     * Builder for the Task Group
            childTasks = new ArrayList<>();  
            return taskInfo;
        task.toXContent(builder, params);  
 * Unless required by applicable law or agreed to in writing,
import java.util.stream.Collectors;
        this.childTasks = Collections.unmodifiableList(new ArrayList<>(childTasks));
            this.taskInfo = taskInfo;
 *
     */
/*  
 * this work for additional information regarding copyright
@PublicApi(since = "1.0.0")
        }
            childTasks.add(builder);
 * SPDX-License-Identifier: Apache-2.0
    public TaskGroup(TaskInfo task, List<TaskGroup> childTasks) {  
 *  
        public TaskInfo getTaskInfo() {
        }  
            builder.startArray("children");
    public static class Builder {  
 */
import org.opensearch.common.annotation.PublicApi;
    }
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
    @PublicApi(since = "1.0.0")
        }
        private Builder(TaskInfo taskInfo) {
/**  
 * specific language governing permissions and limitations
 */
            return new TaskGroup(taskInfo, childTasks.stream().map(Builder::build).collect(Collectors.toList()));  
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
    }  
}
            builder.endArray();  
        this.task = task;
 * the Apache License, Version 2.0 (the "License"); you may
