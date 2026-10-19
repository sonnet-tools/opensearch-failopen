        }
            if (o == null || getClass() != o.getClass()) return false;
        }
            changed = true;
    private final Map<String, PersistentTask<?>> tasks;
        public PersistentTaskState getState() {
        parser.declareObject(
        }
                        if (params != null) {
            id = in.readString();
        @Override
        }
 *
     */
        }
            this(task.id, task.allocationId, task.taskName, task.params, state, task.assignment, task.allocationId);
        "assignment",
        objects -> new Assignment((String) objects[0], (String) objects[1])
        PersistentTasksCustomMetadata.Builder taskBuilder = PersistentTasksCustomMetadata.builder(tasks);
        if (this == o) return true;
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.core.common.io.stream.StreamInput;
            PersistentTask<?> previousTask = tasks.put(
                changed = true;
                taskId,
        // Task description parser initialization
                    {
            return "node: [" + executorNode + "], explanation: [" + explanation + "]";
    private static class TaskBuilder<Params extends PersistentTaskParams> {
            if (taskInProgress != null) {
        private final long allocationId;
        private boolean changed;
        return Objects.hash(tasks, lastAllocationId);
        PersistentTasksCustomMetadata tasks = clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE);
import java.util.stream.Collectors;
                entry.toXContent(builder, params);
                && Objects.equals(taskName, that.taskName)
            return builder;
    public static final Assignment INITIAL_ASSIGNMENT = new Assignment(null, "waiting for initial assignment");
import org.opensearch.cluster.ClusterState;
         * Returns true if any the task list was changed since the builder was created
    @Override
        PERSISTENT_TASK_PARSER.declareString(TaskBuilder::setTaskName, new ParseField("name"));
        }
     *
    @Override
            return tasks.containsKey(taskId);
            if (tasksInProgress != null) {
            return this;
    }
            new ParseField("allocation_id_on_last_status_update")
            );
        }
                    );
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.cluster.AbstractNamedDiffable;
            PersistentTask<?> taskInProgress = tasks.get(taskId);
        private String id;
            return clusterState;
            return this;
import org.opensearch.core.xcontent.ObjectParser;
        public Assignment(String executorNode, String explanation) {
                && Objects.equals(allocationIdOnLastStatusUpdate, that.allocationIdOnLastStatusUpdate);
            for (TaskBuilder builder : tasks) {
            this.allocationId = allocationId;
 * The OpenSearch Contributors require contributions made to
 * specific language governing permissions and limitations
                throw new ResourceAlreadyExistsException("Trying to override task with id {" + taskId + "}");
        private final @Nullable PersistentTaskState state;
        public long getAllocationId() {
            return params;
         * Removes the task
    public static final ConstructingObjectParser<Assignment, Void> ASSIGNMENT_PARSER = new ConstructingObjectParser<>(
        // Task parser initialization
    }
        }
                && Objects.equals(params, that.params)
     * node is no longer in the cluster then the assignment is set to
        tasks = in.readMap(StreamInput::readString, PersistentTask::new);
                new PersistentTask<>(taskId, taskName, params, getNextAllocationId(), assignment)
 * KIND, either express or implied.  See the License for the
import java.util.function.Predicate;
    private final long lastAllocationId;
        }
        }
        if (tasks == null) {
    }
            } else {
        public long getLastAllocationId() {
        Set<String> getCurrentTaskIds() {
    @SuppressWarnings("unchecked")
                tasks.put(taskId, new PersistentTask<>(taskInProgress, taskState));
    /**
    }
            return this;
            TaskDescriptionBuilder::setParams,
            this.params = params;
    }
    }
        /**
     */
                    builder.startObject(taskName);
            },
            return this;
        }
                if (objects.size() != 1) {
        return null;
        return builder;
    @Override
                            builder.field("state", state, xParams);
    }
        }
        PERSISTENT_TASK_PARSER.declareNamedObjects(
        }
            TASK_DESCRIPTION_PARSER,
        return Strings.toString(MediaTypeRegistry.JSON, this);
        ObjectParser<TaskDescriptionBuilder<PersistentTaskParams>, String> parser = new ObjectParser<>("named");
    private static final ObjectParser<TaskBuilder<PersistentTaskParams>, Void> PERSISTENT_TASK_PARSER = new ObjectParser<>(
                }
            PersistentTask<?> that = (PersistentTask<?>) o;
        return lastAllocationId == that.lastAllocationId && Objects.equals(tasks, that.tasks);
        }
        private Builder(PersistentTasksCustomMetadata tasksInProgress) {
            return this;
    public static class PersistentTask<P extends PersistentTaskParams> implements Writeable, ToXContentObject {
import java.io.IOException;
    public boolean equals(Object o) {
        return this.tasks().stream().filter(p -> taskName.equals(p.getTaskName())).filter(predicate).collect(Collectors.toList());
 *
            this.assignment = assignment;
    }
            this.id = id;
        private long allocationId;
        public PersistentTask(final String id, final String name, final P params, final long allocationId, final Assignment assignment) {
 * compatible open source license.
        }
        }
}
        }
            new ParseField("params")
            return id;
        }
    }
        public String getTaskName() {
        }
            final Long allocationIdOnLastStatusUpdate
        return tasks.values()
                && allocationId == that.allocationId
            this.taskName = name;
            (p, c) -> p.namedObject(PersistentTaskState.class, c, null),
        }
         * Updates the task state
        );
        metadataBuilder.putCustom(TYPE, taskBuilder.build());
        public <Params extends PersistentTaskParams> Builder addTask(String taskId, String taskName, Params params, Assignment assignment) {
        return this.tasks.get(id);
            PersistentTask<?> taskInProgress = tasks.get(taskId);
        );
    public static PersistentTasksCustomMetadata fromXContent(XContentParser parser) {
                        if (state != null) {
            out.writeString(id);
        return TYPE;
                    builder.field("allocation_id", allocationId);
            final String name,
        private final Map<String, PersistentTask<?>> tasks = new HashMap<>();
            this.state = state;
        }
import java.util.Map;
    public String toString() {
            out.writeString(taskName);
         * Reassigns the task to another node
/*
        public String getExecutorNode() {
            return clusterState;
 * You may obtain a copy of the License at
            } else {
                    builder.endObject();
import org.opensearch.core.common.io.stream.StreamOutput;
        {
        lastAllocationId = in.readLong();
            if (state != null) {
        PERSISTENT_TASK_PARSER.declareLong(
    }
        PERSISTENT_TASK_PARSER.declareObject(TaskBuilder::setAssignment, ASSIGNMENT_PARSER, new ParseField("assignment"));
        }
            this.state = state;
            this(id, allocationId, name, params, null, assignment, null);
            Assignment that = (Assignment) o;
    @Override
            return explanation;
    }
            if (this == o) return true;
    }
        public boolean hasTask(String taskId) {
        @Override
            return executorNode;
            assignment = new Assignment(in.readOptionalString(), in.readString());
         * Checks if the task is currently present in the list
        private <Params extends PersistentTaskParams> Builder setTasks(List<TaskBuilder<Params>> tasks) {
                {
            }
     * {@link #LOST_NODE_ASSIGNMENT}
        }
    public Collection<PersistentTask<?>> findTasks(String taskName, Predicate<PersistentTask<?>> predicate) {
        @Override
                taskBuilder.reassignTask(task.getId(), LOST_NODE_ASSIGNMENT);
        public boolean isAssigned() {
         */
        );
            .collect(Collectors.toMap(PersistentTask::getId, Function.identity()));
        Map<String, PersistentTask<?>> filteredTasks = tasks.values()
 * Unless required by applicable law or agreed to in writing,
        public Builder removeTask(String taskId) {
import java.util.EnumSet;
    }
        if (o == null || getClass() != o.getClass()) return false;
                PersistentTask<?> task = builder.build();
    /**
    }
    public long getNumberOfTasksOnNode(String nodeId, String taskName) {
                if (state.getWriteableName().equals(taskName) == false) {
                taskBuilder.setState(builder.state);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        private final P params;
import org.opensearch.core.common.Strings;
    }
/**
                lastAllocationId = tasksInProgress.lastAllocationId;
    public static <Params extends PersistentTaskParams> PersistentTask<Params> getTaskWithId(ClusterState clusterState, String taskId) {
                }
     * @param clusterState The clusterstate
        }
    public String getWriteableName() {
            this.params = params;
        this.tasks = tasks;
            return Objects.hash(executorNode, explanation);
                        builder.field("allocation_id_on_last_status_update", allocationIdOnLastStatusUpdate);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            this(task.id, allocationId, task.taskName, task.params, task.state, assignment, task.allocationId);
                builder.startObject("task");
        }
package org.opensearch.persistent;
        public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params xParams) throws IOException {
                }
        public boolean isAssigned() {
            out.writeOptionalString(assignment.executorNode);
 */
            .filter(t -> ClusterState.FeatureAware.shouldSerialize(out, t.getParams()))
 */
     *
        public P getParams() {
    public static Builder builder() {
                        "status has to have the same writeable name as task. status: " + state.getWriteableName() + " task: " + taskName
         * <p>
 * Modifications Copyright OpenSearch Contributors. See
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.metadata());
        private final @Nullable Long allocationIdOnLastStatusUpdate;
    @Override
        private long getNextAllocationId() {
        return this.tasks.values();
        }
     * The assignment.
            return assignment.executorNode;
    @Override
    }
            if (tasks.remove(taskId) != null) {
                throw new ResourceNotFoundException("cannot reassign task with id {" + taskId + "}, the task no longer exists");
        public boolean equals(Object o) {
import java.util.Objects;
            if (o == null || getClass() != o.getClass()) return false;
            return state;
    }
            final Assignment assignment,
            taskName = in.readString();
 *    http://www.apache.org/licenses/LICENSE-2.0
            return false;
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
                    }
            lastAllocationId++;
        private PersistentTaskState state;
            }
            {
            return new PersistentTask<>(id, allocationId, taskName, params, state, assignment, allocationIdOnLastStatusUpdate);
        }
            this.allocationIdOnLastStatusUpdate = allocationIdOnLastStatusUpdate;
        }
        }
                lastAllocationId = 0;
        TASK_DESCRIPTION_PARSER = (XContentParser p, Void c, String name) -> parser.parse(p, new TaskDescriptionBuilder<>(name), name);
            out.writeOptionalLong(allocationIdOnLastStatusUpdate);
            }
        }
        PersistentTasksCustomMetadata that = (PersistentTasksCustomMetadata) o;
        }
            allocationId = in.readLong();
                            builder.field("params", params, xParams);
            this.explanation = explanation;
                throw new ResourceNotFoundException("cannot remove task with id {" + taskId + "}, the task no longer exists");
            return lastAllocationId;
            }
    @Override
import org.opensearch.core.xcontent.XContentBuilder;
            return lastAllocationId;
        /**
            return this;
import java.util.Collection;
    public PersistentTasksCustomMetadata(long lastAllocationId, Map<String, PersistentTask<?>> tasks) {
        public TaskBuilder<Params> setTaskName(String taskName) {
            }
        private Assignment assignment = INITIAL_ASSIGNMENT;
    public void writeTo(StreamOutput out) throws IOException {
            } else {
            final P params,
         * After the task is added its id can be found by calling {{@link #getLastAllocationId()}} method.
        builder.startArray("tasks");
        return ALL_CONTEXTS;
            .stream()
        return new Builder(tasks);
        /**
     * @opensearch.internal
        PersistentTasksCustomMetadata tasks = getPersistentTasksCustomMetadata(clusterState);
        /**
    public static Builder builder(PersistentTasksCustomMetadata tasks) {
    }
import java.util.function.Function;
            .count();
        @Nullable
        }
import org.opensearch.core.xcontent.ObjectParser.NamedObjectParser;
                        "params have to have the same writeable name as task. params: " + params.getWriteableName() + " task: " + taskName
                        builder.field("executor_node", assignment.executorNode);
import static org.opensearch.cluster.metadata.Metadata.ALL_CONTEXTS;
        "tasks",
     * Private builder used in XContent parser to build task-specific portion (params and state)
        }
        private final String taskName;
        }
        /**
         */
    /**
            return changed;
    // TODO: Implement custom Diff for tasks
            if (taskInProgress != null) {
        // Tasks parser initialization
                    }
        private Builder() {}
        for (PersistentTask<?> task : tasks.tasks()) {
        @Override
            return this;
    public static class Assignment {
        if (tasks != null) {
                taskBuilder.setParams(builder.params);
     * @opensearch.internal
        public PersistentTask(final PersistentTask<P> task, final PersistentTaskState state) {
            assert explanation != null;
        return this.tasks;
        PERSISTENT_TASK_PARSER.declareLong(TaskBuilder::setAllocationId, new ParseField("allocation_id"));
            out.writeNamedWriteable(params);
 * software distributed under the License is distributed on an
            .stream()
            TaskBuilder::setAllocationIdOnLastStatusUpdate,
        @Nullable
 * not use this file except in compliance with the License.
    public static ClusterState disassociateDeadNodes(ClusterState clusterState) {
        public Assignment getAssignment() {
                    // These are transient values that shouldn't be persisted to gateway cluster state or snapshot
        public boolean equals(Object o) {
                    );
        PERSISTENT_TASK_PARSER.declareString(TaskBuilder::setId, new ParseField("id"));
    }
                    if (allocationIdOnLastStatusUpdate != null) {
        public void writeTo(StreamOutput out) throws IOException {
                tasks.put(taskId, new PersistentTask<>(taskInProgress, getNextAllocationId(), assignment));
        }
 * @opensearch.internal
        private final String taskName;
                    }
            this.params = params;
                    builder.startObject("assignment");
        }
        builder.endArray();
            allocationIdOnLastStatusUpdate = in.readOptionalLong();
                }
                    throw new IllegalArgumentException("only one task description per task is allowed");
                    throw new IllegalArgumentException(
        private PersistentTaskState state;
        private long lastAllocationId;
        public TaskBuilder<Params> setState(PersistentTaskState state) {
        @Override
                && clusterState.nodes().nodeExists(task.getAssignment().getExecutorNode()) == false) {
                }
            return this;
    }
            builder.endObject();
         */
            this.executorNode = executorNode;
                && Objects.equals(state, that.state)
                if (API_CONTEXT.equals(xParams.param(Metadata.CONTEXT_MODE_PARAM, API_CONTEXT))) {
import java.util.Collections;
        public String toString() {
            TaskDescriptionBuilder::setState,
            return this;
        public PersistentTask<Params> build() {
 * under the License.
            return allocationId;
            this.allocationId = allocationId;
 * Licensed to Elasticsearch under one or more contributor
import java.util.Set;
 * this work for additional information regarding copyright
            if (previousTask != null) {
            return taskName;
            this.taskName = taskName;
            }
        }
        @Nullable
            for (PersistentTask<?> entry : tasks.values()) {
        ASSIGNMENT_PARSER.declareStringOrNull(constructorArg(), new ParseField("executor_node"));
 */
        public TaskBuilder<Params> setAllocationIdOnLastStatusUpdate(Long allocationIdOnLastStatusUpdate) {
    private static final ObjectParser<Builder, Void> PERSISTENT_TASKS_PARSER = new ObjectParser<>(TYPE, Builder::new);
        /**
import java.util.HashMap;
            final String id,
        @Nullable
    public static PersistentTasksCustomMetadata getPersistentTasksCustomMetadata(ClusterState clusterState) {
                if (params.getWriteableName().equals(taskName) == false) {
     */
        builder.field("last_allocation_id", lastAllocationId);
         */
    }
        @Override
            builder.startObject();
     * the cluster. If the task's assigment has a non-null executor node and that
            this.allocationIdOnLastStatusUpdate = allocationIdOnLastStatusUpdate;
                    throw new IllegalArgumentException(
            if (this == o) return true;
/*
        return readDiffFrom(Metadata.Custom.class, TYPE, in);
import org.opensearch.ResourceNotFoundException;
            return assignment.isAssigned();
            return assignment;
        }
            out.writeOptionalNamedWriteable(state);
        return clusterState.getMetadata().custom(PersistentTasksCustomMetadata.TYPE);
        out.writeMap(filteredTasks, StreamOutput::writeString, (stream, value) -> value.writeTo(stream));
        private String taskName;
            }
    );
                this.tasks.put(task.getId(), task);
            return this;
        public boolean hasTask(String taskId, long allocationId) {
            this.id = id;
        // Assignment parser
        private TaskDescriptionBuilder(String taskName) {
    public PersistentTasksCustomMetadata(StreamInput in) throws IOException {
import org.opensearch.common.Nullable;
 */
     * A record that represents a single running persistent task
    public static NamedDiff<Metadata.Custom> readDiffFrom(StreamInput in) throws IOException {
        private final Assignment assignment;
            return Objects.equals(id, that.id)
         */
        }
                    {
            } else {
            return Objects.equals(executorNode, that.executorNode) && Objects.equals(explanation, that.explanation);
        }
            return this;
    public int hashCode() {
        }
            out.writeString(assignment.explanation);
            if (task.getAssignment().getExecutorNode() != null
        private TaskDescriptionBuilder setParams(Params params) {
        out.writeLong(lastAllocationId);
    }
    }
        public String getId() {
import org.opensearch.cluster.NamedDiff;
                changed = true;
        return new Builder();
        public PersistentTask(StreamInput in) throws IOException {
        PERSISTENT_TASKS_PARSER.declareObjectArray(Builder::setTasks, PERSISTENT_TASK_PARSER, new ParseField("tasks"));
         */
import org.opensearch.core.common.io.stream.Writeable;
        public String toString() {
        private final String explanation;
    public PersistentTask<?> getTask(String id) {
        public int hashCode() {
            return this;
        }
            PersistentTask<?> taskInProgress = tasks.get(taskId);
            }
    /**
 *
 * A cluster state record that contains a list of all running persistent tasks
                taskBuilder.setTaskName(builder.taskName);
                changed = true;
import org.opensearch.core.xcontent.MediaTypeRegistry;
        public PersistentTask(final PersistentTask<P> task, final long allocationId, final Assignment assignment) {
        @Nullable
        return ClusterState.builder(clusterState).metadata(metadataBuilder).build();
                builder.field("id", id);
        );
        public PersistentTasksCustomMetadata build() {
            this.taskName = taskName;
            (p, c) -> p.namedObject(PersistentTaskParams.class, c, null),
                && Objects.equals(assignment, that.assignment)
            return this;
        this.lastAllocationId = lastAllocationId;
                tasks.putAll(tasksInProgress.tasks);
    public static class Builder {
        private Builder setLastAllocationId(long currentId) {
            }
        return PERSISTENT_TASKS_PARSER.apply(parser, null).build();
            .filter(task -> taskName.equals(task.taskName) && nodeId.equals(task.assignment.executorNode))
        private TaskDescriptionBuilder setState(PersistentTaskState state) {
        @Override
        public Builder reassignTask(String taskId, Assignment assignment) {
        public boolean isChanged() {
     */
    private static final NamedObjectParser<TaskDescriptionBuilder<PersistentTaskParams>, Void> TASK_DESCRIPTION_PARSER;
        }
import org.opensearch.cluster.metadata.Metadata;
        }
 * this file be licensed under the Apache-2.0 license or a
            return false;
         * Adds a new task to the builder
            return tasks.keySet();
import org.opensearch.ResourceAlreadyExistsException;
            this.state = state;
/*
 * GitHub history for details.
        PERSISTENT_TASKS_PARSER.declareLong(Builder::setLastAllocationId, new ParseField("last_allocation_id"));
        ASSIGNMENT_PARSER.declareStringOrNull(constructorArg(), new ParseField("explanation"));
            final PersistentTaskState state,
            state = in.readOptionalNamedWriteable(PersistentTaskState.class);
            }
        @Override
        }
            return (PersistentTask<Params>) tasks.getTask(taskId);
         */
            params = (P) in.readNamedWriteable(PersistentTaskParams.class);
            this.assignment = assignment;
import org.opensearch.core.xcontent.ToXContentObject;
    public Collection<PersistentTask<?>> tasks() {
    }
        private final String executorNode;
        private PersistentTask(
    );
import org.opensearch.core.ParseField;
        public TaskBuilder<Params> setAssignment(Assignment assignment) {
        public int hashCode() {
            }
        }
    private static class TaskDescriptionBuilder<Params extends PersistentTaskParams> {
        private Long allocationIdOnLastStatusUpdate;
     *
     * Unassign any persistent tasks executing on nodes that are no longer in
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
        public Builder updateTaskState(final String taskId, final PersistentTaskState taskState) {
            final long allocationId,
        public boolean isFragment() {
            }
            return executorNode != null;
import java.util.List;
        parser.declareObject(
        @SuppressWarnings("unchecked")
                        builder.field("explanation", assignment.explanation);
            this.lastAllocationId = currentId;
                        }
        }
        }
     * @return If no changes the argument {@code clusterState} is returned else
            out.writeLong(allocationId);
            return this;
            return new PersistentTasksCustomMetadata(lastAllocationId, Collections.unmodifiableMap(tasks));
                        }
     * The task builder.
    private static final String API_CONTEXT = Metadata.XContentContext.API.toString();
        /**
    public EnumSet<Metadata.XContentContext> context() {
        }
    }
     *          a copy with the modified tasks
    /**
                return taskInProgress.getAllocationId() == allocationId;
 *
        public TaskBuilder<Params> setAllocationId(long allocationId) {
        @Override
        }
                builder.endObject();
        public String getExplanation() {
         * Checks if the task is currently present in the list and has the right allocation id
     */
        }
            return this;
import org.opensearch.core.xcontent.ConstructingObjectParser;
        public TaskBuilder<Params> setParams(Params params) {
            if (taskInProgress != null) {
            if (params != null) {
        private Params params;
    public static final String TYPE = "persistent_tasks";
        public TaskBuilder<Params> setId(String id) {
        ) {
                TaskDescriptionBuilder<PersistentTaskParams> builder = objects.get(0);
    static final Assignment LOST_NODE_ASSIGNMENT = new Assignment(null, "awaiting reassignment after node loss");
            return Objects.hash(id, allocationId, taskName, params, state, assignment, allocationIdOnLastStatusUpdate);
            new ParseField("task")
    }
        }
        if (taskBuilder.isChanged() == false) {
            (TaskBuilder<PersistentTaskParams> taskBuilder, List<TaskDescriptionBuilder<PersistentTaskParams>> objects) -> {
    }
        }
            new ParseField("state", "status")
public final class PersistentTasksCustomMetadata extends AbstractNamedDiffable<Metadata.Custom> implements Metadata.Custom {
        }
        private Params params;
 * the Apache License, Version 2.0 (the "License"); you may
    static {
            return Strings.toString(MediaTypeRegistry.JSON, this);
        TaskBuilder::new
        }
import org.opensearch.core.xcontent.ToXContent;
        private final String id;
        public String getExecutorNode() {
                throw new ResourceNotFoundException("cannot update task with id {" + taskId + "}, the task no longer exists");
    public Map<String, PersistentTask<?>> taskMap() {
                    builder.endObject();
        }
