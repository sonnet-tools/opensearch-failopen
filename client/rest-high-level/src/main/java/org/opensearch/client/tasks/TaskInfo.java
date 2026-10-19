        parser.declareLong(TaskInfo::noOpParse, new ParseField("id"));
 */
        this.cancellable = cancellable;
        return Objects.hash(
            + ", action='"
    }
            && Objects.equals(getCancellationStartTime(), taskInfo.cancellationStartTime);
        return headers;  
    public String getNodeId() {
    public boolean isCancelled() {
import org.opensearch.core.xcontent.XContentParser;
            + description  
 * software distributed under the License is distributed on an
        return cancellable;
    }
    }  
        PARSER = (XContentParser p, Void v, String name) -> parser.parse(p, new TaskInfo(new TaskId(name)), null);  
        return action;
        return type;  
    }
 * GitHub history for details.
            + "taskId="  
    void setStartTime(long startTime) {  
            getDescription(),
    }
            + startTime  
            && Objects.equals(getAction(), taskInfo.getAction())
    private void noOpParse(Object s) {}
    }
        this.cancelled = cancelled;
            + ", startTime="
 * {@link org.opensearch.tasks.TaskInfo}
    }  
    private TaskId parentTaskId;  
    }
            + ", description='"
    }  
            + '}';
    void setParentTaskId(String parentTaskId) {
            && Objects.equals(getParentTaskId(), taskInfo.getParentTaskId())
            getCancellationStartTime()
        parser.declareLong(TaskInfo::setStartTime, new ParseField("start_time_in_millis"));
        this.taskId = taskId;  
        this.cancellationStartTime = cancellationStartTime;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            + ", status="  
    }  
            + ", headers="
        return getStartTime() == taskInfo.getStartTime()
            status,
            && Objects.equals(getResourceStats(), taskInfo.getResourceStats())
 * KIND, either express or implied.  See the License for the
    private Long cancellationStartTime;
        return runningTimeNanos;
    public String getType() {
            getType(),  
            + ", cancellable="  
            && Objects.equals(getTaskId(), taskInfo.getTaskId())  
 */
    }  
    public boolean isCancellable() {  
        parser.declareObject(TaskInfo::setStatus, (p, c) -> p.map(), new ParseField("status"));
        return taskId;
        parser.declareString(TaskInfo::setAction, new ParseField("action"));
    }
    }
        parser.declareBoolean(TaskInfo::setCancellable, new ParseField("cancellable"));  
        parser.declareBoolean(TaskInfo::setCancelled, new ParseField("cancelled"));
        this.headers.putAll(headers);
package org.opensearch.client.tasks;
 * Modifications Copyright OpenSearch Contributors. See  
            + '\''
    void setCancellable(boolean cancellable) {
    }
            + ", resource_stats="
        );  
    }
        return cancelled;  
            + type  
            getParentTaskId(),
    void setType(String type) {  
            + '\''
        // already provided in constructor: triggering a no-op
            + cancelled  
/*
        parser.declareString(TaskInfo::setType, new ParseField("type"));  
    @Override  
    public TaskId getTaskId() {  
    private String type;
    public TaskId getParentTaskId() {  
/*
import org.opensearch.core.ParseField;  
    }
    }
    void setStatus(Map<String, Object> status) {
    public long getRunningTimeNanos() {
        this.action = action;  
 * this file be licensed under the Apache-2.0 license or a
    public TaskInfo(TaskId taskId) {
 * under the License.  
        parser.declareString(TaskInfo::setDescription, new ParseField("description"));  
            isCancellable(),
        parser.declareLong(TaskInfo::setRunningTimeNanos, new ParseField("running_time_in_nanos"));
public class TaskInfo {
            + ", parentTaskId="
    }
    public boolean equals(Object o) {
    private final Map<String, Object> status = new HashMap<>();
        return "TaskInfo{"
            + '\''
            + ", cancelled="
        this.status.putAll(status);
    public Map<String, Object> getStatus() {
            + headers  
    public String getAction() {
    public String getDescription() {  
    private String description;  
            && getRunningTimeNanos() == taskInfo.getRunningTimeNanos()  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * client side counterpart of server side  
 * this work for additional information regarding copyright
        ObjectParser<TaskInfo, Void> parser = new ObjectParser<>("tasks", true, null);
            && Objects.equals(status, taskInfo.status)
 *
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
    private final Map<String, String> headers = new HashMap<>();
            + action  
            && isCancellable() == taskInfo.isCancellable()
        this.startTime = startTime;
            getHeaders(),  
import java.util.Objects;  
    void setHeaders(Map<String, String> headers) {  
    }
        // already provided in constructor: triggering a no-op
 * Licensed to Elasticsearch under one or more contributor  
            isCancelled(),  
        this.parentTaskId = new TaskId(parentTaskId);
            + taskId
    }
            + runningTimeNanos
import java.util.HashMap;
            getAction(),
            + ", type='"
    }  
        if (this == o) return true;
    }
    void setDescription(String description) {
 * You may obtain a copy of the License at  
        this.description = description;
        parser.declareObject(TaskInfo::setHeaders, (p, c) -> p.mapStrings(), new ParseField("headers"));  
    public String toString() {
/*  
 * The OpenSearch Contributors require contributions made to  
 *  
    private TaskId taskId;  
            + status
            + parentTaskId
    }  
    }  
        return description;
import java.util.Map;
        return resourceStats;
/**
        this.resourceStats.putAll(resourceStats);
        this.runningTimeNanos = runningTimeNanos;  
        TaskInfo taskInfo = (TaskInfo) o;
            && isCancelled() == taskInfo.isCancelled()
    void setAction(String action) {
    void setRunningTimeNanos(long runningTimeNanos) {
        this.type = type;
    }
            getStartTime(),  
    public Map<String, String> getHeaders() {
    private long runningTimeNanos;
            + resourceStats
            getResourceStats(),
 */  
 * ownership. Elasticsearch licenses this file to you under  
 */  
import org.opensearch.core.xcontent.ObjectParser;
    }
    }  
        return status;  
    }
        parser.declareString(TaskInfo::noOpParse, new ParseField("node"));  
            getRunningTimeNanos(),
}
    void setCancelled(boolean cancelled) {  
        parser.declareObject(TaskInfo::setResourceStats, (p, c) -> p.map(), new ParseField("resource_stats"));
            + ", cancellationStartTime="  
    public Long getCancellationStartTime() {
            && Objects.equals(getDescription(), taskInfo.getDescription())  
    public static final ObjectParser.NamedObjectParser<TaskInfo, Void> PARSER;
        return this.cancellationStartTime;
    }
        parser.declareLong(TaskInfo::setCancellationStartTime, new ParseField("cancellation_time_millis"));
 * specific language governing permissions and limitations
        return taskId.nodeId;
 * not use this file except in compliance with the License.
    private boolean cancelled;
    public void setCancellationStartTime(Long cancellationStartTime) {
    private long startTime;
            + cancellable
 * Unless required by applicable law or agreed to in writing,
            + cancellationStartTime
    void setResourceStats(Map<String, Object> resourceStats) {  
        return parentTaskId;
    static {  
            && Objects.equals(getHeaders(), taskInfo.getHeaders())  
        return startTime;  
            && Objects.equals(getType(), taskInfo.getType())
 * SPDX-License-Identifier: Apache-2.0
    @Override  
            getTaskId(),
    }  
 *
 * <p>
    private String action;
 * compatible open source license.
    public Map<String, Object> getResourceStats() {
    public int hashCode() {  
        parser.declareString(TaskInfo::setParentTaskId, new ParseField("parent_task_id"));
    private boolean cancellable;  
    public long getStartTime() {
 * license agreements. See the NOTICE file distributed with
        if (!(o instanceof TaskInfo)) return false;  
            + ", runningTimeNanos="
    }  
    private final Map<String, Object> resourceStats = new HashMap<>();  
