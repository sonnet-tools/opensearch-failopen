import org.opensearch.core.common.io.stream.StreamOutput;
    /**
                    // we got zombie or the parent was filtered out - add it to the top task list
        toXContentCommon(builder, params);
import org.opensearch.core.tasks.TaskId;
    @Override
     */
     */
                if (!node.getAttributes().isEmpty()) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * license agreements. See the NOTICE file distributed with
                builder.startObject(task.getTaskId().toString());
    public ListTasksResponse(
    public Map<String, List<TaskInfo>> getPerNodeTasks() {
import org.opensearch.action.support.tasks.BaseTasksResponse;
public class ListTasksResponse extends BaseTasksResponse implements ToXContentObject {
 * Returns the list of tasks currently running on the nodes
import java.util.HashMap;
        }
    private List<TaskGroup> groups;
    private void buildTaskGroups() {
                builder.field("name", node.getName());
        builder.endObject();
                // top level task - add it to the top task list
        return perNodeTasks;
    public XContentBuilder toXContentGroupedByNode(XContentBuilder builder, Params params, DiscoveryNodes discoveryNodes)
            }
                    builder.startObject("attributes");
        });
                builder.endObject();
import org.opensearch.core.xcontent.MediaTypeRegistry;
 *
        }
        ListTasksResponse::new
/*
                    parentTask.addGroup(taskGroup);
                TaskGroup.Builder parentTask = taskGroups.get(parentTaskId);
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
        String name,
 * this file be licensed under the Apache-2.0 license or a
     * Get the tasks found by this request grouped by parent tasks.
                task.toXContent(builder, params);
        for (TaskInfo taskInfo : this.tasks) {
    /**
                    builder.value(role.roleName());
 *
    }
    @Override
                topLevelTasks.add(taskGroup);
        return PARSER.apply(parser, null);
import org.opensearch.cluster.node.DiscoveryNode;
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
    ) {
@PublicApi(since = "1.0.0")
        }
        builder.endObject();
import java.util.stream.Collectors;
    }
            TaskId parentTaskId = taskGroup.getTaskInfo().getParentTaskId();
}
                        builder.field(attrEntry.getKey(), attrEntry.getValue());
                if (parentTask != null) {
        parser.declareObjectArray(optionalConstructorArg(), TaskInfo.PARSER, new ParseField(TASKS));
        if (groups == null) {
import org.opensearch.cluster.node.DiscoveryNodeRole;
            @SuppressWarnings("unchecked")
import org.opensearch.OpenSearchException;
        for (TaskGroup.Builder taskGroup : taskGroups.values()) {
     * Convert this task response to XContent grouping by executing nodes.
            List<OpenSearchException> nodeFailures = (List<OpenSearchException>) constructingObjects[i];
        toXContentCommon(builder, params);
        tasks = Collections.unmodifiableList(in.readList(TaskInfo::new));
        // First populate all tasks
                }
        return tasks;
 *     http://www.apache.org/licenses/LICENSE-2.0
    public void writeTo(StreamOutput out) throws IOException {
        }
import org.opensearch.core.common.Strings;
 *
     * Convert this response to XContent grouping by parent tasks.
            taskGroups.put(taskInfo.getTaskId(), TaskGroup.builder(taskInfo));
                builder.field("ip", node.getAddress());
    public String toString() {
    ) {
 */
    public List<TaskInfo> getTasks() {
 * ownership. Elasticsearch licenses this file to you under
            perNodeTasks = tasks.stream().collect(Collectors.groupingBy(t -> t.getTaskId().getNodeId()));
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
            List<TaskOperationFailure> tasksFailures = (List<TaskOperationFailure>) constructingObjects[i++];
     * Returns the list of tasks by node
    }
/*
import org.opensearch.common.annotation.PublicApi;
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
            builder.startObject();
    }
        parser.declareObjectArray(optionalConstructorArg(), (p, c) -> OpenSearchException.fromXContent(p), new ParseField(NODE_FAILURES));
import org.opensearch.tasks.TaskInfo;
                // If the node is no longer part of the cluster, oh well, we'll just skip it's useful information.
            if (node != null) {
 * software distributed under the License is distributed on an
        return builder;
        ConstructingObjectParser<T, Void> parser = new ConstructingObjectParser<>(name, true, constructingObjects -> {
            DiscoveryNode node = discoveryNodes.get(entry.getKey());
            group.toXContent(builder, params);
    private Map<String, List<TaskInfo>> perNodeTasks;
        throws IOException {
        return builder;
 * The OpenSearch Contributors require contributions made to
import java.util.Map;
        toXContentGroupedByNone(builder, params);
                } else {
                builder.startArray("roles");
                    builder.endObject();
 */
        return groups;
            } else {
    }
    }
                builder.endArray();
                    topLevelTasks.add(taskGroup);
/*
            builder.startObject(entry.getKey());
    }
        TriFunction<List<TaskInfo>, List<TaskOperationFailure>, List<OpenSearchException>, T> ctor
        this.tasks = tasks == null ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList<>(tasks));
        return builder;
        return parser;
        builder.startObject(TASKS);
                    // we found parent in the list of tasks - add it to the parent list
    }
    private static final ConstructingObjectParser<ListTasksResponse, Void> PARSER = setupParser(
    /**
        super.writeTo(out);
import java.util.ArrayList;
    public XContentBuilder toXContentGroupedByNone(XContentBuilder builder, Params params) throws IOException {
 * Licensed to Elasticsearch under one or more contributor
        Map<TaskId, TaskGroup.Builder> taskGroups = new HashMap<>();
     * Presents a flat list of tasks
    protected static <T> ConstructingObjectParser<T, Void> setupParser(
        List<TaskOperationFailure> taskFailures,
 * under the License.
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
     */
import org.opensearch.core.xcontent.ConstructingObjectParser;
import org.opensearch.core.xcontent.ToXContentObject;
            @SuppressWarnings("unchecked")
        parser.declareObjectArray(optionalConstructorArg(), (p, c) -> TaskOperationFailure.fromXContent(p), new ParseField(TASK_FAILURES));
        builder.startObject();
 * You may obtain a copy of the License at
     */
            taskInfo.toXContent(builder, params);
     * Get the tasks found by this request.
            @SuppressWarnings("unchecked")
                for (DiscoveryNodeRole role : node.getRoles()) {
        toXContentCommon(builder, params);
        for (Map.Entry<String, List<TaskInfo>> entry : getPerNodeTasks().entrySet()) {
     */
import org.opensearch.core.common.io.stream.StreamInput;
        builder.startObject("nodes");
            builder.endObject();
 * this work for additional information regarding copyright
    public List<TaskGroup> getTaskGroups() {
import java.util.Collections;
        builder.endArray();
                    for (Map.Entry<String, String> attrEntry : node.getAttributes().entrySet()) {
            builder.endObject();
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public ListTasksResponse(StreamInput in) throws IOException {
 * Unless required by applicable law or agreed to in writing,
import java.util.List;
                builder.field("host", node.getHostName());
        super(taskFailures, nodeFailures);
    }
        for (TaskGroup group : getTaskGroups()) {
        List<TaskGroup.Builder> topLevelTasks = new ArrayList<>();
    @Override
        }
import org.opensearch.common.TriFunction;
        builder.startArray(TASKS);
        "list_tasks_response",
    }
 * @opensearch.api
import org.opensearch.action.TaskOperationFailure;
    /**
import java.io.IOException;
            int i = 0;
                }
import org.opensearch.cluster.node.DiscoveryNodes;
    }
        // Now go through all task group builders and add children to their parents
        List<? extends OpenSearchException> nodeFailures
 * SPDX-License-Identifier: Apache-2.0
            buildTaskGroups();
        if (perNodeTasks == null) {
        super(in);
            return ctor.apply(tasks, tasksFailures, nodeFailures);
import org.opensearch.core.xcontent.XContentBuilder;
 */
 */
 *
/**
    );
 * GitHub history for details.
            builder.startObject(TASKS);
        this.groups = Collections.unmodifiableList(topLevelTasks.stream().map(TaskGroup.Builder::build).collect(Collectors.toList()));
        }
        List<TaskInfo> tasks,
import org.opensearch.core.xcontent.XContentParser;
        out.writeList(tasks);
    }
     */
            if (parentTaskId.isSet()) {
            builder.endObject();
    public XContentBuilder toXContentGroupedByParents(XContentBuilder builder, Params params) throws IOException {
            builder.field(group.getTaskInfo().getTaskId().toString());
    }
import org.opensearch.core.ParseField;
                    }
        for (TaskInfo taskInfo : getTasks()) {
                }
        }
            }
    private static final String TASKS = "tasks";
                builder.field("transport_address", node.getAddress().toString());
            List<TaskInfo> tasks = (List<TaskInfo>) constructingObjects[i++];
    private final List<TaskInfo> tasks;
            for (TaskInfo task : entry.getValue()) {
    }
        return builder;
package org.opensearch.action.admin.cluster.node.tasks.list;
    public static ListTasksResponse fromXContent(XContentParser parser) {
    /**
            }
        builder.endObject();
    /**
