        TaskId id = new TaskId((String) a[i++], (Long) a[i++]);
/**
        out.writeString(type);
        RawTaskStatus status = statusBytes == null ? null : new RawTaskStatus(statusBytes);
import org.opensearch.core.tasks.TaskId;
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (obj == null || obj.getClass() != TaskInfo.class) {
    /**
    private final long runningTimeNanos;
        if (builder.humanReadable()) {
        TaskInfo other = (TaskInfo) obj;
        } else {
    /**
        String description,
        String description = (String) a[i++];
import org.opensearch.Version;
        return Objects.hash(
        for (Map.Entry<String, String> attribute : headers.entrySet()) {
        PARSER.declareString(constructorArg(), new ParseField("action"));
        if (in.getVersion().onOrAfter(Version.V_2_1_0)) {
        status = in.readOptionalNamedWriteable(Task.Status.class);
        long runningTimeNanos = (Long) a[i++];
     * The status of the running task. Only available if TaskInfos were build
        if (out.getVersion().onOrAfter(Version.V_2_0_0)) {
        if (cancellationStartTime != null) {
 *
     */
     * Returns true if the task has been cancelled
            throw new IllegalArgumentException("task cannot be cancelled");
            cancellationStartTime
 * Licensed to Elasticsearch under one or more contributor
        this(
        }
            builder.startObject("resource_stats");
 * specific language governing permissions and limitations
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
    public String getType() {
     */
     */
        TaskId parentTaskId,
        }
    }
    /**
        this.description = description;
        parentTaskId = TaskId.readFromStream(in);
        builder.field("action", action);
            resourceStats,
     * Returns the task running time
            && Objects.equals(status, other.status)
    @Override
        builder.field("type", type);
            null
        TaskId taskId,
/*
    public void writeTo(StreamOutput out) throws IOException {
    @Override
     */
        @SuppressWarnings("unchecked")
 * references as well as mutable state. That makes it impractical to send tasks over transport channels
import org.opensearch.core.common.bytes.BytesReference;
        }
        }
        out.writeLong(startTime);
        );
import org.opensearch.core.xcontent.ConstructingObjectParser;
        PARSER.declareString(optionalConstructorArg(), new ParseField("parent_task_id"));
            builder.field(attribute.getKey(), attribute.getValue());
 * the Apache License, Version 2.0 (the "License"); you may
    }
        builder.endObject();
        if (headers == null) {
    }
            taskId,
     * Returns the task resource information
    public String getAction() {
 * snapshot information about currently running tasks.
        @SuppressWarnings("unchecked")
    private final boolean cancellable;
        if (resourceStats != null) {
        headers = in.readMap(StreamInput::readString, StreamInput::readString);
        return resourceStats;
        if (in.getVersion().onOrAfter(Version.V_2_8_0)) {
 *
        out.writeString(action);
        String type,
import java.util.concurrent.TimeUnit;
        PARSER.declareLong(constructorArg(), new ParseField("start_time_in_millis"));
        );
        builder.field("id", taskId.getId());
    }
    /**
            cancellable,
        return cancelled;
        this.action = action;
        type = in.readString();
        TaskId parentTaskId = parentTaskIdString == null ? TaskId.EMPTY_TASK_ID : new TaskId(parentTaskIdString);
            parentTaskId,
        PARSER.declareString(optionalConstructorArg(), new ParseField("description"));
            parentTaskId,
        out.writeBoolean(cancellable);
            headers,
     * Returns the parent task id
        String action,
            cancelled = in.readBoolean();
        String type = (String) a[i++];
        if (cancellable == false && cancelled == true) {
    private final TaskId taskId;
    /**
            type,
            runningTimeNanos,
        out.writeOptionalString(description);
    public TaskId getTaskId() {
            resourceStats,
        }
            id,
 * compatible open source license.
    @Override
import org.opensearch.common.unit.TimeValue;
    private final Long cancellationStartTime;
        return parentTaskId;
        }
}
        // Note for the future: this has to be backwards and forwards compatible with all changes to the task storage format
        return action;
    /**
        this.parentTaskId = parentTaskId;
     * Read from a stream.
        long runningTimeNanos,
        Map<String, String> headers,
    }
            out.writeOptionalLong(cancellationStartTime);
            resourceStats = in.readOptionalWriteable(TaskResourceStats::new);
     */
    public static TaskInfo fromXContent(XContentParser parser) {
    }
/*
import org.opensearch.core.xcontent.ObjectParserHelper;
        TaskResourceStats resourceStats = (TaskResourceStats) a[i++];
        this.runningTimeNanos = runningTimeNanos;
    public TaskInfo(
            builder.field("parent_task_id", parentTaskId.toString());
            && Objects.equals(cancellable, other.cancellable)
        String action = (String) a[i++];
    @SuppressWarnings("unchecked")
        return startTime;
 * software distributed under the License is distributed on an
        return PARSER.apply(parser, null);
        return cancellable;
            out.writeBoolean(cancelled);
        return type;
        }
        this.cancellationStartTime = cancellationStartTime;
 * Tasks are used for communication with transport actions. As a result, they can contain callback
    private final TaskResourceStats resourceStats;
    /**
 *
        this.taskId = taskId;
 *
    private final String description;
    private final Task.Status status;
        long runningTimeNanos,
        }
            && Objects.equals(resourceStats, other.resourceStats)
        long startTime,
    /**
            && Objects.equals(type, other.type)
 * and use in APIs. Instead, immutable and writeable TaskInfo objects are used to represent
            builder.field("status", status, params);
        }
    public TaskId getParentTaskId() {
        this.headers = headers;
 * KIND, either express or implied.  See the License for the
            status,
        return cancellationStartTime;
        taskId.writeTo(out);
        if (description != null) {
        parentTaskId.writeTo(out);
        return Objects.equals(taskId, other.taskId)
 */
            cancellationStartTime
    }
import org.opensearch.core.common.io.stream.Writeable;
import org.opensearch.common.annotation.PublicApi;
    ) {
            builder.field("running_time", new TimeValue(runningTimeNanos, TimeUnit.NANOSECONDS).toString());
        TaskResourceStats resourceStats,
            description,
            out.writeOptionalWriteable(resourceStats);
            description,
        PARSER.declareBoolean(optionalConstructorArg(), new ParseField("cancelled"));
        if (cancellable == false && cancelled == true) {
public final class TaskInfo implements Writeable, ToXContentFragment {
        return runningTimeNanos;
            // This might happen if we are reading an old version of task info
        action = in.readString();
 */
        builder.timeField("start_time_in_millis", "start_time", startTime);
            cancellable,
        int i = 0;
        boolean cancelled = a[i++] == Boolean.TRUE;
    public long getStartTime() {
import org.opensearch.core.xcontent.XContentBuilder;
            && Objects.equals(description, other.description)
            cancelled,
        builder.startObject("headers");
    }
        }
package org.opensearch.tasks;
        startTime = in.readLong();
        builder.field("cancelled", cancelled);
        runningTimeNanos = in.readLong();
        PARSER.declareLong(optionalConstructorArg(), new ParseField("cancellation_time_millis"));
            startTime,
        } else {
        boolean cancellable = (Boolean) a[i++];
 */
            && Objects.equals(parentTaskId, other.parentTaskId)
import org.opensearch.core.common.io.stream.StreamOutput;
    private final TaskId parentTaskId;
            runningTimeNanos,
            builder.endObject();
    static {
        }
        }
        return status;
        String type,
        Task.Status status,
            status,
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.core.tasks.resourcetracker.TaskResourceStats;
        TaskId parentTaskId,
            startTime,
            startTime,
            resourceStats = null;
    @Override
    }
    }
    }
        if (out.getVersion().onOrAfter(Version.V_2_8_0)) {
            && Objects.equals(headers, other.headers)
        PARSER.declareLong(constructorArg(), new ParseField("id"));
    }
    public Map<String, String> getHeaders() {
 * @opensearch.api
    public long getRunningTimeNanos() {
        if (parentTaskId.isSet()) {
        builder.field("cancellable", cancellable);
        String description,
import java.util.Objects;
@PublicApi(since = "1.0.0")
    public Task.Status getStatus() {
        builder.field("node", taskId.getNodeId());
    }
        this.cancelled = cancelled;
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
            status,
        if (status != null) {
import org.opensearch.core.common.Strings;
        out.writeLong(runningTimeNanos);
    private final long startTime;
    // Implements equals and hashCode for testing
 * Information about a currently running task.
            headers,
        } else {
        PARSER.declareObject(optionalConstructorArg(), (p, c) -> p.mapStrings(), new ParseField("headers"));
    public boolean isCancellable() {
            description,
            return false;
        PARSER.declareObject(optionalConstructorArg(), (p, c) -> TaskResourceStats.fromXContent(p), new ParseField("resource_stats"));
 * GitHub history for details.
            && Objects.equals(startTime, other.startTime)
            action,
        this.startTime = startTime;
            headers = Collections.emptyMap();
     */
    private final String type;
import org.opensearch.core.common.io.stream.StreamInput;
        ObjectParserHelper<TaskInfo, Void> parserHelper = new ObjectParserHelper<>();
    public int hashCode() {
    public long getId() {
            throw new IllegalArgumentException("task cannot be cancelled");
    }
        TaskId taskId,
            type,
            taskId,
        }
            cancelled,
        PARSER.declareString(constructorArg(), new ParseField("type"));
        return new TaskInfo(
    private final Map<String, String> headers;
 * Unless required by applicable law or agreed to in writing,
            action,
        );
        return headers;
            cancellationStartTime = in.readOptionalLong();
    ) {
    /**
    public boolean equals(Object obj) {
        cancellable = in.readBoolean();
 * SPDX-License-Identifier: Apache-2.0
    });
    public TaskResourceStats getResourceStats() {
        return description;
    public Long getCancellationStartTime() {
        TaskResourceStats resourceStats
            action,
        long startTime = (Long) a[i++];
import org.opensearch.core.ParseField;
    }
        PARSER.declareLong(constructorArg(), new ParseField("running_time_in_nanos"));
        long startTime,
    public TaskInfo(
     */
        return builder;
    public String toString() {
    }
        return taskId;
import java.io.IOException;
            resourceStats.toXContent(builder, params);
        return taskId.getId();
    }
            cancellable,
            runningTimeNanos,
        this.resourceStats = resourceStats;
import org.opensearch.core.xcontent.ToXContentFragment;
        builder.field("running_time_in_nanos", runningTimeNanos);
 * <p>
        PARSER.declareBoolean(constructorArg(), new ParseField("cancellable"));
        BytesReference statusBytes = (BytesReference) a[i++];
 * Modifications Copyright OpenSearch Contributors. See
    public TaskInfo(StreamInput in) throws IOException {
     * Returns the task headers
        Map<String, String> headers,
    public boolean isCancelled() {
        }
        this.cancellable = cancellable;
        description = in.readOptionalString();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            cancellationStartTime = null;
        String parentTaskIdString = (String) a[i++];
     * Returns true if the task supports cancellation
        boolean cancelled,
            headers,
/*
 * not use this file except in compliance with the License.
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
 * You may obtain a copy of the License at
            && Objects.equals(action, other.action)
import org.opensearch.core.xcontent.XContentParser;
        boolean cancelled,
        this.status = status;
    }
    }
        out.writeMap(headers, StreamOutput::writeString, StreamOutput::writeString);
        }
            && Objects.equals(cancelled, other.cancelled)
    @Override
            parentTaskId,
    public String getDescription() {
        boolean cancellable,
     * Returns the task start time
            builder.field("description", description);
        Long cancellationStartTime
        }
    public static final ConstructingObjectParser<TaskInfo, Void> PARSER = new ConstructingObjectParser<>("task_info", true, a -> {
    }
    }
            cancelled = false;
        if (in.getVersion().onOrAfter(Version.V_2_0_0)) {
    private final String action;
 * this work for additional information regarding copyright
            cancelled,
        String action,
        this.type = type;
 * ownership. Elasticsearch licenses this file to you under
        taskId = TaskId.readFromStream(in);
import java.util.Map;
        Map<String, String> headers = (Map<String, String>) a[i++];
    private final boolean cancelled;
     */
            builder.humanReadableField("cancellation_time_millis", "cancellation_time", new TimeValue(cancellationStartTime));
    }
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        }
        PARSER.declareString(constructorArg(), new ParseField("node"));
 * The OpenSearch Contributors require contributions made to
        if (out.getVersion().onOrAfter(Version.V_2_1_0)) {
 * this file be licensed under the Apache-2.0 license or a
 */
            type,
import java.util.Collections;
     */
            && Objects.equals(runningTimeNanos, other.runningTimeNanos)
        parserHelper.declareRawObject(PARSER, optionalConstructorArg(), new ParseField("status"));
        Task.Status status,
        Long cancellationStartTime = (Long) a[i++];
            resourceStats,
     * with the detailed flag.
        boolean cancellable,
 * license agreements. See the NOTICE file distributed with
    }
            && Objects.equals(cancellationStartTime, other.cancellationStartTime);
 * under the License.
        out.writeOptionalNamedWriteable(status);
