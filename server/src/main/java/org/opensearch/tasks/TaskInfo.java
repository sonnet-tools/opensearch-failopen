        builder.field("cancellable", cancellable);
        this.action = action;  
            builder.field(attribute.getKey(), attribute.getValue());
        this.cancellationStartTime = cancellationStartTime;
    }
            description,
        return Objects.hash(
        if (obj == null || obj.getClass() != TaskInfo.class) {
            status,
import org.opensearch.core.xcontent.XContentBuilder;
        String type = (String) a[i++];
            cancelled,
        if (builder.humanReadable()) {  
    public TaskInfo(
    private final long runningTimeNanos;
    }
            headers,
        TaskId parentTaskId,
        taskId = TaskId.readFromStream(in);  
        TaskId parentTaskId,
    /**
 * not use this file except in compliance with the License.
public final class TaskInfo implements Writeable, ToXContentFragment {  
    private final String type;  
        );
        int i = 0;  
 *
        runningTimeNanos = in.readLong();  
        Map<String, String> headers,  
        return resourceStats;
            type,
    public TaskId getParentTaskId() {
            builder.endObject();
        String action,  
    private final boolean cancellable;  
        builder.field("type", type);  
            resourceStats,
     * Returns the parent task id  
        Map<String, String> headers,
        long startTime,  
        TaskInfo other = (TaskInfo) obj;
     * Returns the task start time
        long runningTimeNanos = (Long) a[i++];
        out.writeLong(startTime);
    public static TaskInfo fromXContent(XContentParser parser) {
    public TaskInfo(StreamInput in) throws IOException {
 */
 * references as well as mutable state. That makes it impractical to send tasks over transport channels
            && Objects.equals(status, other.status)  
            out.writeOptionalWriteable(resourceStats);
            cancelled,
        builder.field("cancelled", cancelled);
    public String getType() {
 */
        String description,
        return cancelled;
import org.opensearch.core.xcontent.MediaTypeRegistry;
        boolean cancelled,  
        this.description = description;
    public String toString() {
        cancellable = in.readBoolean();
    private final Task.Status status;
    }  
 *  
            && Objects.equals(cancellable, other.cancellable)
        this.resourceStats = resourceStats;  
 * You may obtain a copy of the License at  
            parentTaskId,  
 *
            type,
            action,
        PARSER.declareBoolean(constructorArg(), new ParseField("cancellable"));
        PARSER.declareObject(optionalConstructorArg(), (p, c) -> p.mapStrings(), new ParseField("headers"));
    public void writeTo(StreamOutput out) throws IOException {
        PARSER.declareLong(constructorArg(), new ParseField("running_time_in_nanos"));  
            cancellationStartTime
    /**  
            && Objects.equals(type, other.type)
     */
        out.writeString(action);
            && Objects.equals(cancelled, other.cancelled)
        return taskId;  
            description,  
        taskId.writeTo(out);
        Long cancellationStartTime = (Long) a[i++];
    public TaskResourceStats getResourceStats() {
import org.opensearch.core.common.Strings;
    static {
        PARSER.declareString(optionalConstructorArg(), new ParseField("description"));
@PublicApi(since = "1.0.0")
    @SuppressWarnings("unchecked")
    }
        }
    }
            resourceStats,
        }  
            null  
 * snapshot information about currently running tasks.
 * license agreements. See the NOTICE file distributed with
        PARSER.declareLong(constructorArg(), new ParseField("start_time_in_millis"));
        builder.field("id", taskId.getId());
    }
            headers,
        this.taskId = taskId;
    @Override  
 * specific language governing permissions and limitations
/**
    }  
    public boolean isCancelled() {  
        boolean cancellable,  
     * Returns true if the task has been cancelled
        TaskResourceStats resourceStats = (TaskResourceStats) a[i++];  
    // Implements equals and hashCode for testing
    }  
        return cancellable;  
        startTime = in.readLong();
    public String getAction() {
import java.util.concurrent.TimeUnit;
        long startTime,
        if (out.getVersion().onOrAfter(Version.V_2_1_0)) {  
    }
    /**
 * the Apache License, Version 2.0 (the "License"); you may
        builder.endObject();
     * Read from a stream.
        }
            action,
        builder.field("node", taskId.getNodeId());
            cancellable,
        } else {
    public Map<String, String> getHeaders() {  
            taskId,  
            resourceStats.toXContent(builder, params);
        boolean cancellable = (Boolean) a[i++];
    }  
    public long getStartTime() {  
            parentTaskId,  
        TaskResourceStats resourceStats,
    /**  
     * Returns true if the task supports cancellation  
 * under the License.  
        this.runningTimeNanos = runningTimeNanos;
    /**
    private final TaskId taskId;
        out.writeMap(headers, StreamOutput::writeString, StreamOutput::writeString);
            cancelled,
    public boolean isCancellable() {
    public int hashCode() {
            parentTaskId,
    }  
    public boolean equals(Object obj) {
 * Information about a currently running task.
            cancelled = in.readBoolean();  
        out.writeOptionalString(description);
 * Tasks are used for communication with transport actions. As a result, they can contain callback
     */
 * Unless required by applicable law or agreed to in writing,
        String action,
            headers,  
            runningTimeNanos,  
        out.writeOptionalNamedWriteable(status);  
        String type,
            builder.humanReadableField("cancellation_time_millis", "cancellation_time", new TimeValue(cancellationStartTime));
        }
            runningTimeNanos,
    ) {
import org.opensearch.core.tasks.TaskId;
            cancellationStartTime  
            description,  
 * GitHub history for details.
            builder.field("status", status, params);  
        boolean cancelled,
        return type;
        parentTaskId.writeTo(out);
    private final String description;
    }
        PARSER.declareString(constructorArg(), new ParseField("type"));  
        return description;
        return parentTaskId;  
        }
/*  
    @Override  
            && Objects.equals(resourceStats, other.resourceStats)
            action,
import org.opensearch.core.ParseField;
            startTime,
        return headers;
 *
        PARSER.declareString(optionalConstructorArg(), new ParseField("parent_task_id"));  
        TaskId taskId,
    private final TaskResourceStats resourceStats;
 * and use in APIs. Instead, immutable and writeable TaskInfo objects are used to represent  
 */  
    @Override  
    @Override  
    ) {  
        ObjectParserHelper<TaskInfo, Void> parserHelper = new ObjectParserHelper<>();  
        if (cancellable == false && cancelled == true) {
import org.opensearch.core.xcontent.ObjectParserHelper;
        builder.timeField("start_time_in_millis", "start_time", startTime);
 * KIND, either express or implied.  See the License for the
     * with the detailed flag.  
        }  
        this.cancellable = cancellable;
    public Long getCancellationStartTime() {
    public Task.Status getStatus() {
        if (status != null) {
 * @opensearch.api  
        TaskId parentTaskId = parentTaskIdString == null ? TaskId.EMPTY_TASK_ID : new TaskId(parentTaskIdString);  
        }  
            cancellationStartTime = in.readOptionalLong();  
    }  
        return Objects.equals(taskId, other.taskId)  
import org.opensearch.core.common.io.stream.StreamOutput;
        if (description != null) {
            type,  
    }  
            && Objects.equals(parentTaskId, other.parentTaskId)  
            && Objects.equals(startTime, other.startTime)
        TaskId id = new TaskId((String) a[i++], (Long) a[i++]);
        description = in.readOptionalString();  
    public static final ConstructingObjectParser<TaskInfo, Void> PARSER = new ConstructingObjectParser<>("task_info", true, a -> {
     */  
        type = in.readString();
        String description = (String) a[i++];
        }
            startTime,
        this.headers = headers;
    public long getId() {  
            && Objects.equals(description, other.description)  
        out.writeBoolean(cancellable);  
     * The status of the running task. Only available if TaskInfos were build
 * software distributed under the License is distributed on an
        Long cancellationStartTime
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        } else {
        return PARSER.apply(parser, null);
    }
        return action;  
            cancellable,
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
        builder.field("running_time_in_nanos", runningTimeNanos);  
        }  
        PARSER.declareLong(constructorArg(), new ParseField("id"));
            && Objects.equals(runningTimeNanos, other.runningTimeNanos)
        this.cancelled = cancelled;  
        Task.Status status,  
    }
            return false;  
     */  
        return status;  
     * Returns the task resource information
            runningTimeNanos,
        return runningTimeNanos;
        out.writeLong(runningTimeNanos);
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
        if (in.getVersion().onOrAfter(Version.V_2_0_0)) {
        if (out.getVersion().onOrAfter(Version.V_2_0_0)) {
        return builder;
            taskId,  
    private final boolean cancelled;
     * Returns the task headers
    });
            cancellationStartTime = null;
        if (out.getVersion().onOrAfter(Version.V_2_8_0)) {  
            // This might happen if we are reading an old version of task info
            throw new IllegalArgumentException("task cannot be cancelled");
            headers = Collections.emptyMap();  
import org.opensearch.core.common.bytes.BytesReference;  
        if (in.getVersion().onOrAfter(Version.V_2_1_0)) {  
            builder.field("parent_task_id", parentTaskId.toString());
        if (headers == null) {
        }
        @SuppressWarnings("unchecked")
        );
        out.writeString(type);  
        builder.field("action", action);
    }
 * ownership. Elasticsearch licenses this file to you under  
        );  
        parentTaskId = TaskId.readFromStream(in);
    private final Long cancellationStartTime;
    private final String action;
import java.util.Objects;
            resourceStats,
        TaskResourceStats resourceStats  
        if (in.getVersion().onOrAfter(Version.V_2_8_0)) {
import org.opensearch.core.xcontent.ConstructingObjectParser;  
            throw new IllegalArgumentException("task cannot be cancelled");
     * Returns the task running time
    private final Map<String, String> headers;
        Task.Status status,
 * compatible open source license.
    /**
        String description,
        this.parentTaskId = parentTaskId;
import org.opensearch.core.xcontent.ToXContentFragment;  
        this.startTime = startTime;  
    }
        this.status = status;
        }
     */  
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
     */
        PARSER.declareLong(optionalConstructorArg(), new ParseField("cancellation_time_millis"));  
        TaskId taskId,
        }
    }
        this(
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
package org.opensearch.tasks;
 * Modifications Copyright OpenSearch Contributors. See
 */  
        boolean cancellable,
 * <p>  
            id,
    /**
    @Override
        long startTime = (Long) a[i++];  
import org.opensearch.common.annotation.PublicApi;
        long runningTimeNanos,
     */
    private final long startTime;  
    public long getRunningTimeNanos() {
        Map<String, String> headers = (Map<String, String>) a[i++];  
            builder.field("running_time", new TimeValue(runningTimeNanos, TimeUnit.NANOSECONDS).toString());
import java.util.Map;  
            && Objects.equals(headers, other.headers)
        return cancellationStartTime;
            cancellable,  
            builder.startObject("resource_stats");  
    }
        builder.startObject("headers");  
        long runningTimeNanos,
        if (parentTaskId.isSet()) {  
        status = in.readOptionalNamedWriteable(Task.Status.class);
        String action = (String) a[i++];  
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;
        @SuppressWarnings("unchecked")
        if (resourceStats != null) {
        }  
 *    http://www.apache.org/licenses/LICENSE-2.0
        return taskId.getId();
    /**
        return startTime;
        PARSER.declareObject(optionalConstructorArg(), (p, c) -> TaskResourceStats.fromXContent(p), new ParseField("resource_stats"));
        String type,  
            && Objects.equals(cancellationStartTime, other.cancellationStartTime);  
        if (cancellable == false && cancelled == true) {
        if (cancellationStartTime != null) {
    }
import org.opensearch.core.common.io.stream.StreamInput;
        RawTaskStatus status = statusBytes == null ? null : new RawTaskStatus(statusBytes);
 * this file be licensed under the Apache-2.0 license or a
    public String getDescription() {  
        PARSER.declareBoolean(optionalConstructorArg(), new ParseField("cancelled"));
        }
import org.opensearch.core.common.io.stream.Writeable;  
            out.writeBoolean(cancelled);
        }  
/*
        // Note for the future: this has to be backwards and forwards compatible with all changes to the task storage format  
            resourceStats = in.readOptionalWriteable(TaskResourceStats::new);
import org.opensearch.common.unit.TimeValue;  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            resourceStats = null;  
            status,  
 * this work for additional information regarding copyright
    public TaskId getTaskId() {
        headers = in.readMap(StreamInput::readString, StreamInput::readString);
            && Objects.equals(action, other.action)
/*  
     */
        BytesReference statusBytes = (BytesReference) a[i++];
    public TaskInfo(  
import org.opensearch.core.xcontent.XContentParser;
        action = in.readString();
        boolean cancelled = a[i++] == Boolean.TRUE;  
            out.writeOptionalLong(cancellationStartTime);
import org.opensearch.Version;
        }  
            status,  
import java.util.Collections;
        PARSER.declareString(constructorArg(), new ParseField("action"));
    private final TaskId parentTaskId;  
        for (Map.Entry<String, String> attribute : headers.entrySet()) {
    /**  
        this.type = type;
            builder.field("description", description);  
        }  
        parserHelper.declareRawObject(PARSER, optionalConstructorArg(), new ParseField("status"));
     */
        } else {
    }
            startTime,
        return new TaskInfo(
        String parentTaskIdString = (String) a[i++];
            cancelled = false;
}  
    }
        PARSER.declareString(constructorArg(), new ParseField("node"));
import org.opensearch.core.tasks.resourcetracker.TaskResourceStats;
    }
