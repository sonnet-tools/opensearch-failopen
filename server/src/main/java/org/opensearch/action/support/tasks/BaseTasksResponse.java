    }
        for (TaskOperationFailure exp : taskFailures) {  
        for (int i = 0; i < size; i++) {  
    }
        for (OpenSearchException exp : nodeFailures) {
            nodeFailures.add(new FailedNodeException(in));
            builder.startArray(NODE_FAILURES);
import org.opensearch.OpenSearchException;
 * SPDX-License-Identifier: Apache-2.0
import static java.util.stream.Collectors.toList;  
    }
 * license agreements. See the NOTICE file distributed with
 * Base class for responses of task-related operations
                            "{} of [{}] failed",  
        }  
        }  
import java.util.ArrayList;  
                builder.startObject();
     */
            Stream.concat(
            }
                builder.startObject();  
        this.nodeFailures = nodeFailures == null ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList<>(nodeFailures));
import java.util.Collections;
            }  
        }
    public void rethrowFailures(String operationName) {
    /**
                        f -> new OpenSearchException(
                    .map(
 *
        super(in);  
        size = in.readVInt();  
        for (int i = 0; i < size; i++) {  
package org.opensearch.action.support.tasks;
                    )
    public List<OpenSearchException> getNodeFailures() {
 * specific language governing permissions and limitations
 */
    public boolean equals(Object o) {  
import org.opensearch.core.tasks.TaskId;
    }  
     * The list of node failures exception.
            ).collect(toList())  
        BaseTasksResponse response = (BaseTasksResponse) o;
        if (getTaskFailures() != null && getTaskFailures().size() > 0) {
 * the Apache License, Version 2.0 (the "License"); you may
    }  
        return Objects.hash(taskFailures, nodeFailures);
    private List<OpenSearchException> nodeFailures;
import java.util.stream.Stream;
        out.writeVInt(taskFailures.size());
            for (TaskOperationFailure ex : getTaskFailures()) {
    /**
}  
     */
            exp.writeTo(out);
 *
                builder.endObject();
            return false;
import org.opensearch.core.xcontent.ToXContent;
    }
        }
import java.io.IOException;
        this.taskFailures = taskFailures == null ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList<>(taskFailures));
 * @opensearch.internal  
                builder.value(ex);  
        out.writeVInt(nodeFailures.size());  
        }  
    protected void toXContentCommon(XContentBuilder builder, ToXContent.Params params) throws IOException {
        int size = in.readVInt();
import static org.opensearch.ExceptionsHelper.rethrowAndSuppress;
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
                            new TaskId(f.getNodeId(), f.getTaskId())  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *     http://www.apache.org/licenses/LICENSE-2.0
    public int hashCode() {  
    /**  
 * Licensed to Elasticsearch under one or more contributor  
            builder.endArray();
    }
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
        );
    public BaseTasksResponse(StreamInput in) throws IOException {
 * You may obtain a copy of the License at  
        return nodeFailures;
        List<TaskOperationFailure> taskFailures = new ArrayList<>(size);
            builder.endArray();  
        rethrowAndSuppress(  
 */  
 *
        return taskFailures;
    public BaseTasksResponse(List<TaskOperationFailure> taskFailures, List<? extends OpenSearchException> nodeFailures) {  
    }  
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;  
        List<FailedNodeException> nodeFailures = new ArrayList<>(size);
                            f.getCause(),
            return true;
import org.opensearch.action.FailedNodeException;
 * software distributed under the License is distributed on an
            exp.writeTo(out);
        if (this == o) {
 * this work for additional information regarding copyright
    private List<TaskOperationFailure> taskFailures;  
/**  
/*
            for (OpenSearchException ex : getNodeFailures()) {
     * The list of task failures exception.
                getNodeFailures().stream(),
        this.taskFailures = Collections.unmodifiableList(taskFailures);
        }
import org.opensearch.core.common.io.stream.StreamOutput;  
 *  
 */
 */  
        if (o == null || getClass() != o.getClass()) {
    protected static final String NODE_FAILURES = "node_failures";
import org.opensearch.action.TaskOperationFailure;  
     */  
        }
/*  
        this.nodeFailures = Collections.unmodifiableList(nodeFailures);  
    public List<TaskOperationFailure> getTaskFailures() {  
/*  
import org.opensearch.core.action.ActionResponse;
                getTaskFailures().stream()  
            taskFailures.add(new TaskOperationFailure(in));
    }  
    @Override
 * under the License.  
        if (getNodeFailures() != null && getNodeFailures().size() > 0) {  
    @Override
 * GitHub history for details.
     * Rethrow task failures if there are any.  
import org.opensearch.core.common.io.stream.StreamInput;
                builder.endObject();
    protected static final String TASK_FAILURES = "task_failures";  
 * not use this file except in compliance with the License.
                ex.toXContent(builder, params);
 * ownership. Elasticsearch licenses this file to you under  
import java.util.Objects;  
 * Modifications Copyright OpenSearch Contributors. See
        }
                            operationName,
import java.util.List;
                        )
            builder.startArray(TASK_FAILURES);  
    @Override  
public class BaseTasksResponse extends ActionResponse {
        return taskFailures.equals(response.taskFailures) && nodeFailures.equals(response.nodeFailures);
