    @Override
    @Override
        if (id != taskId.id) return false;
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.common.Strings;  
import org.opensearch.common.annotation.PublicApi;
    }
package org.opensearch.core.tasks;
    }
            return EMPTY_TASK_ID;
    public String toString() {
        if (nodeId.isEmpty()) {
            if (s == null || s.length != 2) {
        TaskId taskId = (TaskId) o;  
 */
    private TaskId() {  
     * {@linkplain StreamInput} so we can return the {@link #EMPTY_TASK_ID} without allocating.
/*
    private final long id;
public final class TaskId implements Writeable {  
                throw new IllegalArgumentException("malformed task id " + taskId, ex);  
        return nodeId;
/*  
}
     * Read a {@linkplain TaskId} from a stream. {@linkplain TaskId} has this rather than the usual constructor that takes a  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static ContextParser<Void, TaskId> parser() {
            return nodeId + ":" + id;
        result = 31 * result + (int) (id ^ (id >>> 32));
            /*  
import org.opensearch.core.xcontent.XContentParser;
 */  
import org.opensearch.core.common.io.stream.Writeable;  
             * The only TaskId allowed to have the empty string as its nodeId is the EMPTY_TASK_ID and there is only ever one of it and it
 * under the License.  
import java.io.IOException;
    }  
    /**
    }
        int result = nodeId.hashCode();  
 *  
        return result;
 * GitHub history for details.
 * Task id that consists of node id and id of the task on the node
     */
 * You may obtain a copy of the License at  
        if (this == o) return true;  
 * SPDX-License-Identifier: Apache-2.0
     * Builds {@link #EMPTY_TASK_ID}.
 *
import org.opensearch.core.xcontent.ContextParser;
    }  
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
    public boolean equals(Object o) {
        return id != -1L;
        id = -1;
 * Licensed to Elasticsearch under one or more contributor  
            // Shortcut the EMPTY_TASK_ID, the only TaskId allowed to have the empty string as its nodeId.
        return new TaskId(nodeId, in.readLong());  
import org.opensearch.OpenSearchParseException;
 * the Apache License, Version 2.0 (the "License"); you may
    @Override  
        if (Strings.hasLength(taskId) && "unset".equals(taskId) == false) {  
            return "unset";  
        return (p, c) -> {
            } catch (NumberFormatException ex) {
        String nodeId = in.readString();
        if (isSet()) {  
                this.id = Long.parseLong(s[1]);
    @Override
 * Modifications Copyright OpenSearch Contributors. See
                throw new IllegalArgumentException("malformed task id " + taskId);  
            id = -1L;
            }
        }
        };
    public int hashCode() {
    }
    }  
                return new TaskId(p.text());
        out.writeString(nodeId);
            throw new OpenSearchParseException("Expected a string but found [{}] instead", p.currentToken());  
            String[] s = Strings.split(taskId, ":");
            if (p.currentToken() == XContentParser.Token.VALUE_STRING) {  
        if (o == null || getClass() != o.getClass()) return false;
    public long getId() {
 *
        } else {
    private final String nodeId;
 * compatible open source license.
import org.opensearch.core.common.io.stream.StreamOutput;
        }  
        return id;  
        } else {
        if (nodeId.isEmpty()) {  
/**  
            throw new IllegalArgumentException("0 length nodeIds are reserved for EMPTY_TASK_ID and are otherwise invalid.");  
import org.opensearch.core.common.io.stream.StreamInput;
        }
 * this file be licensed under the Apache-2.0 license or a
    }
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
    public static TaskId readFromStream(StreamInput in) throws IOException {  
 *
/*  
             * never writes its taskId to save bytes on the wire because it is by far the most common TaskId.
            this.nodeId = s[0];
    }
            try {  
            }
 * specific language governing permissions and limitations
    public TaskId(String taskId) {
    public static final TaskId EMPTY_TASK_ID = new TaskId();
@PublicApi(since = "1.0.0")
    }
    }  
    /**  
 * ownership. Elasticsearch licenses this file to you under  
     */
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
        }
 */  
            nodeId = "";  
        return nodeId.equals(taskId.nodeId);  
 */
    public TaskId(String nodeId, long id) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.id = id;  
 * @opensearch.api  
        nodeId = "";
        }
    public String getNodeId() {
        this.nodeId = nodeId;
    public boolean isSet() {  
 * The OpenSearch Contributors require contributions made to  
    }
        out.writeLong(id);
            }
             */  
        if (nodeId.isEmpty()) {
            return;
