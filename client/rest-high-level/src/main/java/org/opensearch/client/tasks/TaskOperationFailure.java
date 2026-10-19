        return reason;
 * under the License.  
            + taskId
        return Objects.hash(getNodeId(), getTaskId(), getReason(), getStatus());
        this.taskId = taskId;  
            && Objects.equals(getStatus(), that.getStatus());
            + ", status='"
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
            + '\''  
        return "TaskOperationFailure{"  
 * this file be licensed under the Apache-2.0 license or a
            long taskId = (long) constructorObjects[i++];  
            + reason
 */
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See  
        return taskId;
        PARSER.declareString(constructorArg(), new ParseField("status"));
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
        this.reason = reason;
    static {
 * {@link org.opensearch.action.TaskOperationFailure}
 * software distributed under the License is distributed on an
    }
            String nodeId = (String) constructorObjects[i++];
            + '\''
    public static TaskOperationFailure fromXContent(XContentParser parser) {
        if (this == o) return true;
    public TaskOperationFailure(String nodeId, long taskId, String status, OpenSearchException reason) {
    }
        PARSER.declareLong(constructorArg(), new ParseField("task_id"));  
    private static final ConstructingObjectParser<TaskOperationFailure, Void> PARSER = new ConstructingObjectParser<>(  
        this.nodeId = nodeId;
            + "nodeId='"
        return PARSER.apply(parser, null);  
        return status;  
/*
        if (!(o instanceof TaskOperationFailure)) return false;  
        return nodeId;  
    @Override
    }
        constructorObjects -> {  
    private final OpenSearchException reason;
 *
 */  
    }
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 * compatible open source license.
    public OpenSearchException getReason() {
            + ", taskId="
    );
            && Objects.equals(getNodeId(), that.getNodeId())  
    }  
            return new TaskOperationFailure(nodeId, taskId, status, reason);  
        TaskOperationFailure that = (TaskOperationFailure) o;
    }  
            && Objects.equals(getReason(), that.getReason())
            + status  
 * SPDX-License-Identifier: Apache-2.0
            + ", reason="  
 * specific language governing permissions and limitations
 *
            OpenSearchException reason = (OpenSearchException) constructorObjects[i];
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;  
 * client side counterpart of server side  
        }
    public boolean equals(Object o) {
        "task_info",
    public long getTaskId() {  
        this.status = status;
 *  
 * not use this file except in compliance with the License.
            int i = 0;
public class TaskOperationFailure {  
import org.opensearch.core.xcontent.ConstructingObjectParser;
 * Licensed to Elasticsearch under one or more contributor  
    @Override  
        PARSER.declareString(constructorArg(), new ParseField("node_id"));
    @Override
            String status = (String) constructorObjects[i++];
    }  
import org.opensearch.core.ParseField;  
 */
 * KIND, either express or implied.  See the License for the
import java.util.Objects;
 * license agreements. See the NOTICE file distributed with
    private final String nodeId;
        true,
    public String getNodeId() {
import org.opensearch.core.xcontent.XContentParser;
/*
            + nodeId
        PARSER.declareObject(constructorArg(), (parser, c) -> OpenSearchException.fromXContent(parser), new ParseField("reason"));
    public String toString() {
    }
        return getTaskId() == that.getTaskId()
    private final String status;
 * this work for additional information regarding copyright
    private final long taskId;  
 *    http://www.apache.org/licenses/LICENSE-2.0
            + '}';
package org.opensearch.client.tasks;
    public int hashCode() {  
    }  
    public String getStatus() {
 * ownership. Elasticsearch licenses this file to you under  
}
 * The OpenSearch Contributors require contributions made to  
/**
