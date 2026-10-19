        out.writeLong(taskId);  
 * this file be licensed under the Apache-2.0 license or a
 *  
        true,  
    }
            builder.field(REASON);  
        status = RestStatus.readFrom(in);  
        status = ExceptionsHelper.status(e);
        if (reason != null) {
 */  
        builder.field(STATUS, status.name());
public final class TaskOperationFailure implements Writeable, ToXContentFragment {  
        }
import org.opensearch.core.xcontent.XContentParser;
 * You may obtain a copy of the License at  
     */
import org.opensearch.core.xcontent.ToXContentFragment;  
    private static final String STATUS = "status";  
import org.opensearch.core.ParseField;  
        return PARSER.apply(parser, null);  
        PARSER.declareObject(constructorArg(), (parser, c) -> OpenSearchException.fromXContent(parser), new ParseField(REASON));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            int i = 0;
/*  
    private static final ConstructingObjectParser<TaskOperationFailure, Void> PARSER = new ConstructingObjectParser<>(
    }  
        return this.taskId;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            return new TaskOperationFailure(nodeId, taskId, reason);  
import org.opensearch.core.common.io.stream.Writeable;  
    }
    public TaskOperationFailure(StreamInput in) throws IOException {
    @Override  
import org.opensearch.core.rest.RestStatus;
import org.opensearch.ExceptionsHelper;
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
        return this.nodeId;  
        RestStatus.writeTo(out, status);
 * Information about task operation failures  
            OpenSearchException.generateThrowableXContent(builder, params, reason);
import org.opensearch.OpenSearchException;
    );
    }
 *
        reason = in.readException();
    public String getNodeId() {
package org.opensearch.action;
/*
    @Override  
 * under the License.  
        }
        nodeId = in.readString();  
 * Modifications Copyright OpenSearch Contributors. See
    }
        PARSER.declareLong(constructorArg(), new ParseField(TASK_ID));  
            builder.startObject();
/**
    /**
    @Override  
 */  
        return "[" + nodeId + "][" + taskId + "] failed, reason [" + reason + "]";
}
    private static final String NODE_ID = "node_id";
    }
 * Unless required by applicable law or agreed to in writing,
        constructorObjects -> {
    }  
 * Licensed to Elasticsearch under one or more contributor  
    private final long taskId;
 *  
        "task_info",
        this.reason = e;
            OpenSearchException reason = (OpenSearchException) constructorObjects[i];
 * software distributed under the License is distributed on an
    static {
    public String toString() {
 *
    public Exception getCause() {
 * @opensearch.internal
        out.writeString(nodeId);
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
        return builder;
 * The class is final due to serialization limitations
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
     * Read from a stream.  
        this.taskId = taskId;  
        out.writeException(reason);
    }
    public long getTaskId() {  
    public TaskOperationFailure(String nodeId, long taskId, Exception e) {
    private final RestStatus status;
    private final Exception reason;  
    private final String nodeId;
        builder.field(TASK_ID, getTaskId());
    private static final String REASON = "reason";
    }  
import org.opensearch.core.xcontent.ConstructingObjectParser;
            long taskId = (long) constructorObjects[i++];
            String nodeId = (String) constructorObjects[i++];  
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
    }  
import org.opensearch.core.common.io.stream.StreamOutput;
    public void writeTo(StreamOutput out) throws IOException {
        PARSER.declareString(constructorArg(), new ParseField(NODE_ID));
        return status;
 * compatible open source license.
        this.nodeId = nodeId;
import org.opensearch.core.common.io.stream.StreamInput;
    public RestStatus getStatus() {
 * <p>
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;  
        builder.field(NODE_ID, getNodeId());  
    public static TaskOperationFailure fromXContent(XContentParser parser) {
            builder.endObject();  
/*  
 */
        return reason;  
 * SPDX-License-Identifier: Apache-2.0
    private static final String TASK_ID = "task_id";
        taskId = in.readLong();
import org.opensearch.core.xcontent.XContentBuilder;
    }
