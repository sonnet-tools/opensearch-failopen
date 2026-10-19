                    topLevelTasks.add(taskGroup);  
                // top level task - add it to the top task list  
            builder.startObject(TASKS);  
            builder.endObject();
     * Convert this response to XContent grouping by parent tasks.
 * specific language governing permissions and limitations
        });
            TaskId parentTaskId = taskGroup.getTaskInfo().getParentTaskId();
        List<TaskInfo> tasks,
    public List<TaskGroup> getTaskGroups() {
        return builder;  
        toXContentGroupedByNone(builder, params);  
    /**
    }  
            builder.field(group.getTaskInfo().getTaskId().toString());
        builder.startObject("nodes");
    }
    private Map<String, List<TaskInfo>> perNodeTasks;  
            for (TaskInfo task : entry.getValue()) {
        return perNodeTasks;
    public XContentBuilder toXContentGroupedByNone(XContentBuilder builder, Params params) throws IOException {  
        ListTasksResponse::new
        if (perNodeTasks == null) {
    private static final ConstructingObjectParser<ListTasksResponse, Void> PARSER = setupParser(
        super(taskFailures, nodeFailures);  
 *  
    }  
            @SuppressWarnings("unchecked")
                builder.field("transport_address", node.getAddress().toString());  
    private void buildTaskGroups() {  
        String name,
    }
     * Returns the list of tasks by node
                for (DiscoveryNodeRole role : node.getRoles()) {
            DiscoveryNode node = discoveryNodes.get(entry.getKey());
 * ownership. Elasticsearch licenses this file to you under  
    protected static <T> ConstructingObjectParser<T, Void> setupParser(  
    public XContentBuilder toXContentGroupedByNode(XContentBuilder builder, Params params, DiscoveryNodes discoveryNodes)
                builder.field("ip", node.getAddress());
                    for (Map.Entry<String, String> attrEntry : node.getAttributes().entrySet()) {  
import java.io.IOException;  
    }
        parser.declareObjectArray(optionalConstructorArg(), (p, c) -> TaskOperationFailure.fromXContent(p), new ParseField(TASK_FAILURES));  
 * software distributed under the License is distributed on an
        return builder;
            if (node != null) {  
/**
import org.opensearch.action.support.tasks.BaseTasksResponse;  
        tasks = Collections.unmodifiableList(in.readList(TaskInfo::new));  
 * Licensed to Elasticsearch under one or more contributor  
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
import java.util.Map;
/*  
            buildTaskGroups();
package org.opensearch.action.admin.cluster.node.tasks.list;
        for (TaskInfo taskInfo : this.tasks) {
            }
                        builder.field(attrEntry.getKey(), attrEntry.getValue());
import org.opensearch.cluster.node.DiscoveryNodes;  
        return builder;
                // If the node is no longer part of the cluster, oh well, we'll just skip it's useful information.
            List<OpenSearchException> nodeFailures = (List<OpenSearchException>) constructingObjects[i];
 *     http://www.apache.org/licenses/LICENSE-2.0
    private static final String TASKS = "tasks";
    private final List<TaskInfo> tasks;
    public String toString() {
        toXContentCommon(builder, params);
            } else {
 * this work for additional information regarding copyright
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
        parser.declareObjectArray(optionalConstructorArg(), (p, c) -> OpenSearchException.fromXContent(p), new ParseField(NODE_FAILURES));
 * KIND, either express or implied.  See the License for the
        List<TaskGroup.Builder> topLevelTasks = new ArrayList<>();
    }
        List<TaskOperationFailure> taskFailures,  
        return tasks;
                builder.endArray();
        toXContentCommon(builder, params);
        builder.endObject();
import org.opensearch.core.xcontent.XContentBuilder;
        builder.startArray(TASKS);
            taskGroups.put(taskInfo.getTaskId(), TaskGroup.builder(taskInfo));
                    // we found parent in the list of tasks - add it to the parent list
import org.opensearch.cluster.node.DiscoveryNodeRole;
     */  
        return builder;  
import org.opensearch.core.common.io.stream.StreamOutput;  
        throws IOException {  
    public List<TaskInfo> getTasks() {
 * the Apache License, Version 2.0 (the "License"); you may
    public void writeTo(StreamOutput out) throws IOException {
            }
                if (!node.getAttributes().isEmpty()) {
 */
            List<TaskOperationFailure> tasksFailures = (List<TaskOperationFailure>) constructingObjects[i++];  
     * Get the tasks found by this request grouped by parent tasks.  
 *  
 * GitHub history for details.
        List<? extends OpenSearchException> nodeFailures
            @SuppressWarnings("unchecked")  
 * this file be licensed under the Apache-2.0 license or a
     * Convert this task response to XContent grouping by executing nodes.  
        // Now go through all task group builders and add children to their parents
    }  
            if (parentTaskId.isSet()) {
        return parser;
import java.util.HashMap;  
        // First populate all tasks  
     * Presents a flat list of tasks
            int i = 0;
 * The OpenSearch Contributors require contributions made to  
 */
                    }
        }
 * under the License.  
        "list_tasks_response",  
import org.opensearch.core.common.Strings;
     */
    /**
     */
                if (parentTask != null) {
            builder.endObject();  
                builder.field("host", node.getHostName());
     * Get the tasks found by this request.
    }
        }  
        for (TaskGroup.Builder taskGroup : taskGroups.values()) {  
     */
 *
import org.opensearch.tasks.TaskInfo;
        }
import org.opensearch.core.tasks.TaskId;
                builder.endObject();
                } else {
import org.opensearch.cluster.node.DiscoveryNode;
        this.groups = Collections.unmodifiableList(topLevelTasks.stream().map(TaskGroup.Builder::build).collect(Collectors.toList()));
            group.toXContent(builder, params);  
                TaskGroup.Builder parentTask = taskGroups.get(parentTaskId);  
    /**
import org.opensearch.core.xcontent.ToXContentObject;
            builder.startObject();
import java.util.ArrayList;
            builder.endObject();  
        builder.startObject();
import java.util.Collections;
        builder.endObject();
 * Unless required by applicable law or agreed to in writing,
        toXContentCommon(builder, params);
            @SuppressWarnings("unchecked")
                }
    @Override  
 * license agreements. See the NOTICE file distributed with
        ConstructingObjectParser<T, Void> parser = new ConstructingObjectParser<>(name, true, constructingObjects -> {
/*
    public Map<String, List<TaskInfo>> getPerNodeTasks() {
        for (Map.Entry<String, List<TaskInfo>> entry : getPerNodeTasks().entrySet()) {  
    public XContentBuilder toXContentGroupedByParents(XContentBuilder builder, Params params) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
        return PARSER.apply(parser, null);  
                    parentTask.addGroup(taskGroup);  
    }
 * not use this file except in compliance with the License.
        parser.declareObjectArray(optionalConstructorArg(), TaskInfo.PARSER, new ParseField(TASKS));
/*  
        }
 * @opensearch.api
import org.opensearch.core.ParseField;  
    public static ListTasksResponse fromXContent(XContentParser parser) {
                    builder.startObject("attributes");
        this.tasks = tasks == null ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList<>(tasks));
    /**  
        super(in);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                    // we got zombie or the parent was filtered out - add it to the top task list
        }  
                    builder.endObject();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                }
        for (TaskInfo taskInfo : getTasks()) {  
        }
        Map<TaskId, TaskGroup.Builder> taskGroups = new HashMap<>();
    );
import org.opensearch.core.xcontent.XContentParser;  
import java.util.List;
import java.util.stream.Collectors;  
            List<TaskInfo> tasks = (List<TaskInfo>) constructingObjects[i++];
    }  
    /**
            taskInfo.toXContent(builder, params);
     */  
        for (TaskGroup group : getTaskGroups()) {
        }
    }  
                task.toXContent(builder, params);  
@PublicApi(since = "1.0.0")  
        super.writeTo(out);
import org.opensearch.common.annotation.PublicApi;
    }
 */  
 * SPDX-License-Identifier: Apache-2.0
                }
        if (groups == null) {  
            builder.startObject(entry.getKey());
     */  
}
        builder.endArray();
 * Returns the list of tasks currently running on the nodes
        out.writeList(tasks);  
    ) {
import org.opensearch.common.TriFunction;
    ) {  
 *
        TriFunction<List<TaskInfo>, List<TaskOperationFailure>, List<OpenSearchException>, T> ctor
                builder.field("name", node.getName());
            return ctor.apply(tasks, tasksFailures, nodeFailures);  
                builder.startArray("roles");
        builder.startObject(TASKS);  
    public ListTasksResponse(StreamInput in) throws IOException {
        return groups;  
 */  
        builder.endObject();  
import org.opensearch.OpenSearchException;
import org.opensearch.action.TaskOperationFailure;
                topLevelTasks.add(taskGroup);
 * compatible open source license.
import org.opensearch.core.xcontent.ConstructingObjectParser;
import org.opensearch.core.common.io.stream.StreamInput;
    private List<TaskGroup> groups;
                    builder.value(role.roleName());  
 * You may obtain a copy of the License at  
    /**
    @Override  
    public ListTasksResponse(
    }
            }
public class ListTasksResponse extends BaseTasksResponse implements ToXContentObject {
                builder.startObject(task.getTaskId().toString());
    @Override  
            perNodeTasks = tasks.stream().collect(Collectors.groupingBy(t -> t.getTaskId().getNodeId()));  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
    }
