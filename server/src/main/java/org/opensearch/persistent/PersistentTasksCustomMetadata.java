        }
            return new PersistentTasksCustomMetadata(lastAllocationId, Collections.unmodifiableMap(tasks));
         */
            if (o == null || getClass() != o.getClass()) return false;
                throw new ResourceNotFoundException("cannot update task with id {" + taskId + "}, the task no longer exists");  
            }
        Set<String> getCurrentTaskIds() {
        private long allocationId;
            this.allocationId = allocationId;
        }
        ObjectParser<TaskDescriptionBuilder<PersistentTaskParams>, String> parser = new ObjectParser<>("named");  
    }
        public boolean hasTask(String taskId) {
        return this.tasks;  
/**
        }
        public PersistentTask(final String id, final String name, final P params, final long allocationId, final Assignment assignment) {
            lastAllocationId++;
        private Assignment assignment = INITIAL_ASSIGNMENT;  
    public static <Params extends PersistentTaskParams> PersistentTask<Params> getTaskWithId(ClusterState clusterState, String taskId) {
    );
        public Builder updateTaskState(final String taskId, final PersistentTaskState taskState) {  
            this.taskName = taskName;
                    throw new IllegalArgumentException(
                throw new ResourceNotFoundException("cannot remove task with id {" + taskId + "}, the task no longer exists");  
    public static final ConstructingObjectParser<Assignment, Void> ASSIGNMENT_PARSER = new ConstructingObjectParser<>(
            final Assignment assignment,
     * the cluster. If the task's assigment has a non-null executor node and that
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            return id;  
        public TaskBuilder<Params> setParams(Params params) {  
        return Strings.toString(MediaTypeRegistry.JSON, this);
            this.state = state;  
        return builder;
     * @opensearch.internal
            PersistentTask<?> taskInProgress = tasks.get(taskId);
import java.util.stream.Collectors;  
         */  
 * You may obtain a copy of the License at  
        private Long allocationIdOnLastStatusUpdate;
         * Returns true if any the task list was changed since the builder was created
    }
 * compatible open source license.
import java.io.IOException;
        lastAllocationId = in.readLong();
package org.opensearch.persistent;
        // Tasks parser initialization
import org.opensearch.cluster.metadata.Metadata;  
        private String taskName;  
        private String id;
                    if (allocationIdOnLastStatusUpdate != null) {  
    public static ClusterState disassociateDeadNodes(ClusterState clusterState) {
            this.assignment = assignment;  
            taskName = in.readString();
            this.params = params;
    public long getNumberOfTasksOnNode(String nodeId, String taskName) {
        private <Params extends PersistentTaskParams> Builder setTasks(List<TaskBuilder<Params>> tasks) {
     * Unassign any persistent tasks executing on nodes that are no longer in
                && Objects.equals(assignment, that.assignment)  
            return this;
        }
            return this;  
    }
    @Override  
import java.util.HashMap;
 *
        }
            return this;  
        @Nullable
        Map<String, PersistentTask<?>> filteredTasks = tasks.values()
    public Map<String, PersistentTask<?>> taskMap() {
                lastAllocationId = tasksInProgress.lastAllocationId;
import org.opensearch.core.xcontent.ObjectParser.NamedObjectParser;
            TaskDescriptionBuilder::setParams,
                taskBuilder.setParams(builder.params);
            new ParseField("allocation_id_on_last_status_update")
         */
        private Builder() {}
            this(task.id, task.allocationId, task.taskName, task.params, state, task.assignment, task.allocationId);
        if (taskBuilder.isChanged() == false) {  
        public boolean isChanged() {  
        return tasks.values()  
            return executorNode != null;
            this.taskName = name;  
            return new PersistentTask<>(id, allocationId, taskName, params, state, assignment, allocationIdOnLastStatusUpdate);  
    @Override
        }  
    /**  
                tasks.put(taskId, new PersistentTask<>(taskInProgress, taskState));
import org.opensearch.cluster.NamedDiff;
            params = (P) in.readNamedWriteable(PersistentTaskParams.class);
        public Builder removeTask(String taskId) {
            TASK_DESCRIPTION_PARSER,
        }
    /**
        ASSIGNMENT_PARSER.declareStringOrNull(constructorArg(), new ParseField("executor_node"));
        return new Builder(tasks);
                this.tasks.put(task.getId(), task);
    public static class Assignment {  
            .filter(task -> taskName.equals(task.taskName) && nodeId.equals(task.assignment.executorNode))
    private static class TaskBuilder<Params extends PersistentTaskParams> {  
        // Task parser initialization
                    builder.startObject("assignment");  
            .filter(t -> ClusterState.FeatureAware.shouldSerialize(out, t.getParams()))
    }
 * ownership. Elasticsearch licenses this file to you under  
        PERSISTENT_TASK_PARSER.declareString(TaskBuilder::setTaskName, new ParseField("name"));
        private final long allocationId;  
    public Collection<PersistentTask<?>> findTasks(String taskName, Predicate<PersistentTask<?>> predicate) {
    }
        out.writeLong(lastAllocationId);
            this.executorNode = executorNode;  
        @Nullable
        public PersistentTasksCustomMetadata build() {
        private Params params;
        return ALL_CONTEXTS;
        @Override
        }
                            builder.field("state", state, xParams);
            return this;  
        @Nullable
                changed = true;
import org.opensearch.common.Nullable;
        @Override  
        return PERSISTENT_TASKS_PARSER.apply(parser, null).build();  
            return this;
    public void writeTo(StreamOutput out) throws IOException {  
        }
        public String getId() {
        if (o == null || getClass() != o.getClass()) return false;
        }  
     */
                && Objects.equals(taskName, that.taskName)  
            return false;
        }
            final long allocationId,  
        /**  
                        builder.field("explanation", assignment.explanation);  
            out.writeString(id);
 * KIND, either express or implied.  See the License for the
            .collect(Collectors.toMap(PersistentTask::getId, Function.identity()));
 * under the License.  
                entry.toXContent(builder, params);
         * <p>
        public int hashCode() {
        public long getAllocationId() {  
            for (TaskBuilder builder : tasks) {
        "tasks",
     * Private builder used in XContent parser to build task-specific portion (params and state)
                    );
        tasks = in.readMap(StreamInput::readString, PersistentTask::new);
                        builder.field("allocation_id_on_last_status_update", allocationIdOnLastStatusUpdate);
        PersistentTasksCustomMetadata tasks = getPersistentTasksCustomMetadata(clusterState);
        public P getParams() {  
            final String name,
 * not use this file except in compliance with the License.
        private PersistentTaskState state;
            return lastAllocationId;
import java.util.List;  
            final P params,
            if (task.getAssignment().getExecutorNode() != null  
            return (PersistentTask<Params>) tasks.getTask(taskId);
 * Licensed to Elasticsearch under one or more contributor  
        @Override  
        private final String id;
        }  
        public void writeTo(StreamOutput out) throws IOException {  
    private static final NamedObjectParser<TaskDescriptionBuilder<PersistentTaskParams>, Void> TASK_DESCRIPTION_PARSER;
            return assignment;
     * A record that represents a single running persistent task
    }
            } else {
public final class PersistentTasksCustomMetadata extends AbstractNamedDiffable<Metadata.Custom> implements Metadata.Custom {
import org.opensearch.core.common.Strings;  
import org.opensearch.cluster.AbstractNamedDiffable;  
        ) {  
        out.writeMap(filteredTasks, StreamOutput::writeString, (stream, value) -> value.writeTo(stream));  
    }  
                new PersistentTask<>(taskId, taskName, params, getNextAllocationId(), assignment)
    // TODO: Implement custom Diff for tasks
        public boolean hasTask(String taskId, long allocationId) {  
    }
    public static final Assignment INITIAL_ASSIGNMENT = new Assignment(null, "waiting for initial assignment");
    }
        }  
                && allocationId == that.allocationId
        /**
            },
        public PersistentTask(final PersistentTask<P> task, final PersistentTaskState state) {  
                    throw new IllegalArgumentException("only one task description per task is allowed");
        }  
    }  
            this.allocationId = allocationId;  
        }
            }
        return clusterState.getMetadata().custom(PersistentTasksCustomMetadata.TYPE);
            this.taskName = taskName;
        private long lastAllocationId;
 *  
                    {  
                tasks.put(taskId, new PersistentTask<>(taskInProgress, getNextAllocationId(), assignment));
 * Unless required by applicable law or agreed to in writing,
        public PersistentTaskState getState() {  
    private static class TaskDescriptionBuilder<Params extends PersistentTaskParams> {
 * specific language governing permissions and limitations
        private final Map<String, PersistentTask<?>> tasks = new HashMap<>();
        }
            if (previousTask != null) {
        }  
    }  
        private final Assignment assignment;
}
        }
import org.opensearch.core.ParseField;
 *
 */
        }  
 * @opensearch.internal
        private TaskDescriptionBuilder(String taskName) {
            return this;
            } else {
import java.util.Collections;  
        public PersistentTask<Params> build() {
        private final P params;
        }
        "assignment",  
        public TaskBuilder<Params> setState(PersistentTaskState state) {
        objects -> new Assignment((String) objects[0], (String) objects[1])
            TaskDescriptionBuilder::setState,
            return clusterState;
import java.util.Collection;
            this.assignment = assignment;
            builder.startObject();  
            for (PersistentTask<?> entry : tasks.values()) {  
            out.writeNamedWriteable(params);
            (p, c) -> p.namedObject(PersistentTaskParams.class, c, null),  
                        }  
            allocationId = in.readLong();  
            return false;
                {
        return new Builder();  
            return this;
    /**
        }  
    public PersistentTask<?> getTask(String id) {  
                }
        }
            return this;  
        }
        parser.declareObject(
            builder.endObject();
            {
        return this.tasks.values();
        );  
        }
            out.writeOptionalLong(allocationIdOnLastStatusUpdate);
    public static Builder builder(PersistentTasksCustomMetadata tasks) {  
            return this;
        @Override
    public String toString() {
        TASK_DESCRIPTION_PARSER = (XContentParser p, Void c, String name) -> parser.parse(p, new TaskDescriptionBuilder<>(name), name);
        // Assignment parser
        // Task description parser initialization
        this.lastAllocationId = lastAllocationId;  
                && Objects.equals(allocationIdOnLastStatusUpdate, that.allocationIdOnLastStatusUpdate);
                        "params have to have the same writeable name as task. params: " + params.getWriteableName() + " task: " + taskName
                builder.field("id", id);
        @Nullable
    public String getWriteableName() {
                    throw new IllegalArgumentException(
                            builder.field("params", params, xParams);
        public String getExecutorNode() {  
        return Objects.hash(tasks, lastAllocationId);  
                }
            assert explanation != null;
        {
     *
            if (tasks.remove(taskId) != null) {  
import org.opensearch.core.xcontent.ConstructingObjectParser;
    public PersistentTasksCustomMetadata(long lastAllocationId, Map<String, PersistentTask<?>> tasks) {
        PERSISTENT_TASK_PARSER.declareString(TaskBuilder::setId, new ParseField("id"));  
        builder.field("last_allocation_id", lastAllocationId);  
            PersistentTask<?> previousTask = tasks.put(  
    }
        }  
            new ParseField("params")
        }  
            );  
import java.util.EnumSet;
        }  
        }
        private final String taskName;  
        public TaskBuilder<Params> setAllocationId(long allocationId) {
        PERSISTENT_TASK_PARSER.declareNamedObjects(
        public String toString() {
        public String toString() {
                    builder.startObject(taskName);
     *
        }  
            return this;
    }
        public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params xParams) throws IOException {
        /**  
        return this.tasks.get(id);
        }
            }
    static {  
    public static class PersistentTask<P extends PersistentTaskParams> implements Writeable, ToXContentObject {  
                }  
        }
        public TaskBuilder<Params> setTaskName(String taskName) {
            (TaskBuilder<PersistentTaskParams> taskBuilder, List<TaskDescriptionBuilder<PersistentTaskParams>> objects) -> {
        PERSISTENT_TASKS_PARSER.declareObjectArray(Builder::setTasks, PERSISTENT_TASK_PARSER, new ParseField("tasks"));  
        }
                        if (state != null) {
                }
        }
                throw new ResourceAlreadyExistsException("Trying to override task with id {" + taskId + "}");
        /**  
            this.params = params;
            if (this == o) return true;
            final PersistentTaskState state,  
        public boolean isAssigned() {  
         * After the task is added its id can be found by calling {{@link #getLastAllocationId()}} method.
        }
        public Builder reassignTask(String taskId, Assignment assignment) {
            .count();  
            this(id, allocationId, name, params, null, assignment, null);
            if (state != null) {  
         */
        this.tasks = tasks;
    public Collection<PersistentTask<?>> tasks() {
        /**
        }
        }  
    private static final ObjectParser<Builder, Void> PERSISTENT_TASKS_PARSER = new ObjectParser<>(TYPE, Builder::new);
            return assignment.executorNode;  
            final String id,
    private static final String API_CONTEXT = Metadata.XContentContext.API.toString();
                throw new ResourceNotFoundException("cannot reassign task with id {" + taskId + "}, the task no longer exists");
            if (o == null || getClass() != o.getClass()) return false;
            this(task.id, allocationId, task.taskName, task.params, task.state, assignment, task.allocationId);  
            .stream()
import org.opensearch.core.xcontent.XContentParser;
 * SPDX-License-Identifier: Apache-2.0
        public boolean isFragment() {
/*
                        builder.field("executor_node", assignment.executorNode);
        private boolean changed;  
        public TaskBuilder<Params> setId(String id) {  
            Assignment that = (Assignment) o;  
        private final String explanation;  
            return state;
                && clusterState.nodes().nodeExists(task.getAssignment().getExecutorNode()) == false) {
        PERSISTENT_TASK_PARSER.declareObject(TaskBuilder::setAssignment, ASSIGNMENT_PARSER, new ParseField("assignment"));
        private PersistentTaskState state;
         */
    public static PersistentTasksCustomMetadata getPersistentTasksCustomMetadata(ClusterState clusterState) {  
            if (params != null) {
    }
    }
import java.util.function.Function;
    }  
            id = in.readString();
import java.util.Set;  
        /**
    }
            return explanation;
import org.opensearch.core.xcontent.XContentBuilder;
        }  
    private final Map<String, PersistentTask<?>> tasks;
            allocationIdOnLastStatusUpdate = in.readOptionalLong();
        return readDiffFrom(Metadata.Custom.class, TYPE, in);
        for (PersistentTask<?> task : tasks.tasks()) {
        PersistentTasksCustomMetadata tasks = clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE);
            return tasks.containsKey(taskId);  
        public int hashCode() {
            }
        public TaskBuilder<Params> setAllocationIdOnLastStatusUpdate(Long allocationIdOnLastStatusUpdate) {  
import org.opensearch.cluster.ClusterState;
    public static final String TYPE = "persistent_tasks";  
        return lastAllocationId == that.lastAllocationId && Objects.equals(tasks, that.tasks);
                    }
            PersistentTask<?> taskInProgress = tasks.get(taskId);
        PERSISTENT_TASKS_PARSER.declareLong(Builder::setLastAllocationId, new ParseField("last_allocation_id"));
            return Objects.equals(executorNode, that.executorNode) && Objects.equals(explanation, that.explanation);
            if (tasksInProgress != null) {
            changed = true;
            return Objects.equals(id, that.id)
import static org.opensearch.cluster.metadata.Metadata.ALL_CONTEXTS;
                tasks.putAll(tasksInProgress.tasks);  
            out.writeOptionalString(assignment.executorNode);  
                    // These are transient values that shouldn't be persisted to gateway cluster state or snapshot
        TaskBuilder::new
import java.util.Objects;
import org.opensearch.core.xcontent.ToXContentObject;  
            this.explanation = explanation;
import java.util.Map;
        );
        return TYPE;  
                && Objects.equals(state, that.state)
            return this;
import org.opensearch.core.common.io.stream.Writeable;  
        }
        private Builder(PersistentTasksCustomMetadata tasksInProgress) {
        public PersistentTask(StreamInput in) throws IOException {
            this.allocationIdOnLastStatusUpdate = allocationIdOnLastStatusUpdate;
            return "node: [" + executorNode + "], explanation: [" + explanation + "]";  
        @Override
        private TaskDescriptionBuilder setState(PersistentTaskState state) {
import org.opensearch.core.xcontent.ToXContent;
     * @return If no changes the argument {@code clusterState} is returned else
import org.opensearch.core.common.io.stream.StreamOutput;
/*  
    /**  
            return Objects.hash(executorNode, explanation);  
     *          a copy with the modified tasks
    public static NamedDiff<Metadata.Custom> readDiffFrom(StreamInput in) throws IOException {  
        builder.endArray();
        public Assignment getAssignment() {  
    @SuppressWarnings("unchecked")  
                lastAllocationId = 0;  
        }
        public <Params extends PersistentTaskParams> Builder addTask(String taskId, String taskName, Params params, Assignment assignment) {
        @Override
        }
                && Objects.equals(params, that.params)
    }
            this.id = id;
                PersistentTask<?> task = builder.build();  
        }
import org.opensearch.core.xcontent.ObjectParser;  
            return allocationId;
    }  
            this.id = id;
                    builder.field("allocation_id", allocationId);
                    );  
    static final Assignment LOST_NODE_ASSIGNMENT = new Assignment(null, "awaiting reassignment after node loss");
    }
        if (this == o) return true;
                taskId,
        private TaskDescriptionBuilder setParams(Params params) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
         * Checks if the task is currently present in the list  
        metadataBuilder.putCustom(TYPE, taskBuilder.build());
            return Strings.toString(MediaTypeRegistry.JSON, this);
            new ParseField("state", "status")  
            this.allocationIdOnLastStatusUpdate = allocationIdOnLastStatusUpdate;
        PERSISTENT_TASK_PARSER.declareLong(TaskBuilder::setAllocationId, new ParseField("allocation_id"));
        public String getTaskName() {
 * the Apache License, Version 2.0 (the "License"); you may
        public PersistentTask(final PersistentTask<P> task, final long allocationId, final Assignment assignment) {
        private final String taskName;
        ASSIGNMENT_PARSER.declareStringOrNull(constructorArg(), new ParseField("explanation"));  
            (p, c) -> p.namedObject(PersistentTaskState.class, c, null),
    @Override
                        if (params != null) {
 * software distributed under the License is distributed on an
        }  
                    builder.endObject();
    );  
    }
 * A cluster state record that contains a list of all running persistent tasks  
            return builder;  
            return this;
            state = in.readOptionalNamedWriteable(PersistentTaskState.class);  
        @Override
        public boolean equals(Object o) {  
                builder.startObject("task");  
        private final String executorNode;
     *  
            out.writeString(assignment.explanation);
        }
                    }
            }  
                if (state.getWriteableName().equals(taskName) == false) {
            assignment = new Assignment(in.readOptionalString(), in.readString());
            }  
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @opensearch.internal  
         * Reassigns the task to another node
        public String getExplanation() {
    public EnumSet<Metadata.XContentContext> context() {
    @Override  
         * Updates the task state
import org.opensearch.ResourceAlreadyExistsException;
                    }
    }
            return this;
            }
        }
    }  
    private static final ObjectParser<TaskBuilder<PersistentTaskParams>, Void> PERSISTENT_TASK_PARSER = new ObjectParser<>(  
        }
            PersistentTask<?> taskInProgress = tasks.get(taskId);
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.metadata());
        public TaskBuilder<Params> setAssignment(Assignment assignment) {
            return Objects.hash(id, allocationId, taskName, params, state, assignment, allocationIdOnLastStatusUpdate);  
        builder.startArray("tasks");
        }
     */  
            if (taskInProgress != null) {
        private final @Nullable Long allocationIdOnLastStatusUpdate;
                return taskInProgress.getAllocationId() == allocationId;  
    @Override
    public static PersistentTasksCustomMetadata fromXContent(XContentParser parser) {
            this.params = params;  
 */  
 * this work for additional information regarding copyright
        public boolean isAssigned() {
            }
     */
        public String getExecutorNode() {
            } else {
    public static class Builder {  
            }
                changed = true;  
        public Assignment(String executorNode, String explanation) {
        if (tasks == null) {  
                if (API_CONTEXT.equals(xParams.param(Metadata.CONTEXT_MODE_PARAM, API_CONTEXT))) {  
        public long getLastAllocationId() {
            this.state = state;
    }
         */
    }
     */  
        if (tasks != null) {  
    @Override
    /**  
                changed = true;
        private long getNextAllocationId() {  
        private Params params;
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;  
 * Modifications Copyright OpenSearch Contributors. See
        return null;  
            return changed;
                    {
import java.util.function.Predicate;
import org.opensearch.ResourceNotFoundException;
        );
         * Checks if the task is currently present in the list and has the right allocation id
            this.state = state;
        }  
     * @param clusterState The clusterstate  
                }  
        }  
        }
            this.lastAllocationId = currentId;  
            if (taskInProgress != null) {
        }  
        /**
         * Adds a new task to the builder  
         * Removes the task  
    }
            out.writeOptionalNamedWriteable(state);
    public static Builder builder() {
     * {@link #LOST_NODE_ASSIGNMENT}
 * this file be licensed under the Apache-2.0 license or a
            TaskBuilder::setAllocationIdOnLastStatusUpdate,
        return this.tasks().stream().filter(p -> taskName.equals(p.getTaskName())).filter(predicate).collect(Collectors.toList());
            } else {  
            return this;  
        }
        private PersistentTask(
            if (this == o) return true;
import org.opensearch.core.common.io.stream.StreamInput;
                taskBuilder.setState(builder.state);  
            final Long allocationIdOnLastStatusUpdate
 * license agreements. See the NOTICE file distributed with
    public int hashCode() {
            return lastAllocationId;
                if (objects.size() != 1) {  
     */
        PersistentTasksCustomMetadata that = (PersistentTasksCustomMetadata) o;  
/*  
 * GitHub history for details.
            return executorNode;
            new ParseField("task")  
     * The assignment.
        @Override
        }  
        return ClusterState.builder(clusterState).metadata(metadataBuilder).build();  
 * The OpenSearch Contributors require contributions made to  
            .stream()  
        }  
                if (params.getWriteableName().equals(taskName) == false) {  
        PERSISTENT_TASK_PARSER.declareLong(  
        public boolean equals(Object o) {  
        }
            }
import org.opensearch.core.xcontent.MediaTypeRegistry;
        );
                builder.endObject();
        parser.declareObject(  
    public PersistentTasksCustomMetadata(StreamInput in) throws IOException {  
    private final long lastAllocationId;  
        private Builder setLastAllocationId(long currentId) {
            return assignment.isAssigned();
                        "status has to have the same writeable name as task. status: " + state.getWriteableName() + " task: " + taskName  
                taskBuilder.reassignTask(task.getId(), LOST_NODE_ASSIGNMENT);
            return tasks.keySet();  
        }
                taskBuilder.setTaskName(builder.taskName);
 */  
                        }  
        private final @Nullable PersistentTaskState state;  
            out.writeLong(allocationId);
     * node is no longer in the cluster then the assignment is set to  
            if (taskInProgress != null) {  
            return clusterState;
        @SuppressWarnings("unchecked")  
 */  
            return params;
    public boolean equals(Object o) {  
    @Override
    }
            PersistentTask<?> that = (PersistentTask<?>) o;  
            return this;
         */  
                TaskDescriptionBuilder<PersistentTaskParams> builder = objects.get(0);  
            }
        }
 *
        @Override
     * The task builder.
                    builder.endObject();
        @Nullable
            return taskName;
            }  
        PersistentTasksCustomMetadata.Builder taskBuilder = PersistentTasksCustomMetadata.builder(tasks);
            out.writeString(taskName);  
