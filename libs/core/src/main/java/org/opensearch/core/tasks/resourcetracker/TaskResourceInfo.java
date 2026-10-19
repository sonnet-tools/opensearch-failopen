            .build()
        return Objects.hash(action, taskId, parentTaskId, nodeId, taskResourceUsage);  
/*  
            this.nodeId = nodeId;  
        final long parentTaskId,
        return new TaskResourceInfo.Builder().setAction(in.readString())
    }  
        builder.field(NODE_ID.getPreferredName(), this.nodeId);  
            && parentTaskId == other.parentTaskId
    public long getTaskId() {
     * Get TaskResourceUsage
    public long getParentTaskId() {  
 * compatible open source license.
        PARSER.declareLong(constructorArg(), TASK_ID);  
        builder.endObject();
    }
        TaskResourceInfo other = (TaskResourceInfo) obj;
        public Builder setParentTaskId(final long parentTaskId) {  
import org.opensearch.core.xcontent.XContentBuilder;
    private static final ParseField ACTION = new ParseField("action");
     */
    private static final ParseField PARENT_TASK_ID = new ParseField("parentTaskId");  
        public TaskResourceInfo build() {
 * Task resource usage information with minimal information about the task  
        builder.field(PARENT_TASK_ID.getPreferredName(), this.parentTaskId);
        return nodeId;
    public boolean equals(Object obj) {
            .setTaskId(in.readLong())  
        "task_resource_info",
public class TaskResourceInfo implements Writeable, ToXContentObject {  
import org.opensearch.common.annotation.PublicApi;
        PARSER.declareString(constructorArg(), ACTION);
    public String toString() {
    public String getAction() {  
     *  
        }
     * @return task id  
        public Builder setAction(final String action) {
     * Read task info from a stream.
    @Override
    }
        if (obj == null || obj.getClass() != TaskResourceInfo.class) {
     * Get task action  
            .setTaskResourceUsage((TaskResourceUsage) a[4])  
        private String nodeId;
        return action;
import org.opensearch.core.xcontent.ConstructingObjectParser;
            .setParentTaskId((Long) a[2])
        return parentTaskId;
     * Get node id
        return action.equals(other.action)  
            return this;  
    }
        this.taskResourceUsage.toXContent(builder, params);
    }
    ) {
 *
            this.taskId = taskId;
@PublicApi(since = "2.15.0")
        private long parentTaskId;  
            .setTaskResourceUsage(TaskResourceUsage.readFromStream(in))  
            .setParentTaskId(in.readLong())
        out.writeLong(taskId);
    }
        this.taskResourceUsage = taskResourceUsage;  
    /**
        this.action = action;
    @Override
    }  
        final TaskResourceUsage taskResourceUsage  
 * Writeable TaskResourceInfo objects are used to represent resource usage
     * Get parent task id
     * @return {@link TaskResourceInfo}
        return taskResourceUsage;
     * Builder for {@link TaskResourceInfo}  
            return false;  
        private String action;
     * @return taskResourceUsage
 * <p>
            && Objects.equals(nodeId, other.nodeId)  
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;  
    /**  
     */  
        a -> new Builder().setAction((String) a[0])
        public Builder setNodeId(final String nodeId) {
        final long taskId,  
    }
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.xcontent.MediaTypeRegistry;
        builder.startObject(TASK_RESOURCE_USAGE.getPreferredName());
package org.opensearch.core.tasks.resourcetracker;
        return Strings.toString(MediaTypeRegistry.JSON, this);  
            .setNodeId((String) a[3])
 */
    }
     */
    private final long taskId;
     * Get task id
 */  
    }
     * @throws IOException IOException
    }
        }
 * The OpenSearch Contributors require contributions made to  
            return this;
    public static class Builder {
    private final String nodeId;
    /**
        out.writeString(nodeId);  
            && taskResourceUsage.equals(other.taskResourceUsage);
        }
            .setTaskId((Long) a[1])  
    private static final ParseField NODE_ID = new ParseField("nodeId");
        PARSER.declareString(constructorArg(), NODE_ID);
import org.opensearch.core.common.io.stream.StreamInput;
            return new TaskResourceInfo(action, taskId, parentTaskId, nodeId, taskResourceUsage);
    /**  
        }  
     * @return node id
     *  
        }  
        builder.field(ACTION.getPreferredName(), this.action);  
import org.opensearch.core.common.io.stream.StreamOutput;
        return taskId;  
    public static final ConstructingObjectParser<TaskResourceInfo, Void> PARSER = new ConstructingObjectParser<>(  
    @Override  
            this.parentTaskId = parentTaskId;
 * this file be licensed under the Apache-2.0 license or a
     */
        builder.endObject();  
/**
import java.io.IOException;  
    @Override
import org.opensearch.core.xcontent.ToXContentObject;  
        final String action,
        this.nodeId = nodeId;
    private static final ParseField TASK_ID = new ParseField("taskId");
        private long taskId;
        this.parentTaskId = parentTaskId;
        taskResourceUsage.writeTo(out);
    public TaskResourceUsage getTaskResourceUsage() {  
    }
        PARSER.declareObject(constructorArg(), TaskResourceUsage.PARSER, TASK_RESOURCE_USAGE);  
     * @return parent task id
 * SPDX-License-Identifier: Apache-2.0
    private final String action;
            this.taskResourceUsage = taskResourceUsage;
     * @param in StreamInput to read  
import org.opensearch.core.ParseField;
            && taskId == other.taskId
}
    /**
    private static final ParseField TASK_RESOURCE_USAGE = new ParseField("taskResourceUsage");
import java.util.Objects;
            .build();
            .setNodeId(in.readString())
        builder.field(TASK_ID.getPreferredName(), this.taskId);
            return this;
 *
    public int hashCode() {
    );
    @Override  
     */
 * information of running tasks, which can be propagated to coordinator node  
        private TaskResourceUsage taskResourceUsage;  
    public static TaskResourceInfo readFromStream(StreamInput in) throws IOException {
            return this;
     */  
        }
import org.opensearch.core.common.io.stream.Writeable;  
        public Builder setTaskResourceUsage(final TaskResourceUsage taskResourceUsage) {  
 *  @opensearch.api  
     */
        out.writeLong(parentTaskId);
        public Builder setTaskId(final long taskId) {
        out.writeString(action);  
     *
            this.action = action;  
    private final long parentTaskId;  
    /**
 * to infer query-level resource usage
    }
    private final TaskResourceUsage taskResourceUsage;
        this.taskId = taskId;  
        builder.startObject();
    /**
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.core.common.Strings;  
            return this;
        final String nodeId,
    static {
    }
        }  
        return builder;
     * @return task action
    public TaskResourceInfo(
    public String getNodeId() {
        PARSER.declareLong(constructorArg(), PARENT_TASK_ID);
