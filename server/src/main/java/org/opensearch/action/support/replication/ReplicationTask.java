 * KIND, either express or implied.  See the License for the
/*  
 * Unless required by applicable law or agreed to in writing,
            builder.endObject();  
import org.opensearch.core.xcontent.MediaTypeRegistry;
     */
/*  
    }  
            return Strings.toString(MediaTypeRegistry.JSON, this);
import org.opensearch.core.common.io.stream.StreamOutput;  
 */  
        @Override  
        public boolean equals(Object obj) {
 * GitHub history for details.
            return phase.equals(other.phase);  
public class ReplicationTask extends Task {
        @Override
import org.opensearch.core.tasks.TaskId;
    /**
        private final String phase;
 * under the License.  
            ReplicationTask.Status other = (Status) obj;
        }
 *
            if (obj == null || obj.getClass() != ReplicationTask.Status.class) {
    public Status getStatus() {
import static java.util.Objects.requireNonNull;  
 * this file be licensed under the Apache-2.0 license or a
            builder.startObject();
     * Get the current phase of the task.
    /**  
     * @opensearch.internal  
    public ReplicationTask(long id, String type, String action, String description, TaskId parentTaskId, Map<String, String> headers) {
            return builder;
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.xcontent.XContentBuilder;  
     */
 * @opensearch.internal
 * specific language governing permissions and limitations
/**
    }
        public void writeTo(StreamOutput out) throws IOException {
 * compatible open source license.
import org.opensearch.core.common.io.stream.StreamInput;
        super(id, type, action, description, parentTaskId, headers);
            builder.field("phase", phase);
import java.io.IOException;  
        public int hashCode() {
     */
            this.phase = requireNonNull(phase, "Phase cannot be null");
            return phase.hashCode();
     * Set the current phase of the task.  
 */
        @Override  
        }
 *
        }  
 * software distributed under the License is distributed on an
        public Status(StreamInput in) throws IOException {
 * Task that tracks replication actions.  
import java.util.Map;
import org.opensearch.tasks.Task;
     *
/*
    public static class Status implements Task.Status {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            out.writeString(phase);  
 */  
    @Override
    }
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
            phase = in.readString();  
        }  
package org.opensearch.action.support.replication;
        public String getWriteableName() {
        @Override  
    private volatile String phase = "starting";
        @Override
        return phase;
        @Override  
    }
 * the Apache License, Version 2.0 (the "License"); you may
                return false;  
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
    }
}
 * this work for additional information regarding copyright
        }  
        public Status(String phase) {
 * You may obtain a copy of the License at  
            }
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.common.Strings;
 *  
    public String getPhase() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**  
 *
        return new Status(phase);  
        public String toString() {
        }
        }  
 * SPDX-License-Identifier: Apache-2.0
     * Status of the replication task
        }
    public void setPhase(String phase) {
            return NAME;
        this.phase = phase;  
        // Implements equals and hashcode for testing
 */  
        public static final String NAME = "replication";  
