import org.opensearch.core.common.io.stream.StreamInput;
import java.util.Iterator;
    }
/*
                .append("/")  
    @Override  
 * this file be licensed under the Apache-2.0 license or a
    public PendingClusterTasksResponse(StreamInput in) throws IOException {
 * The OpenSearch Contributors require contributions made to  
    private final List<PendingClusterTask> pendingTasks;  
 */
     * @opensearch.internal
            builder.field(Fields.TIME_IN_EXECUTION, pendingClusterTask.getTimeInExecution());
                .append("/")
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
    }
        this.pendingTasks = pendingTasks;
 * Transport response for getting pending cluster tasks
    @Override
     *  
                .append(pendingClusterTask.getTimeInQueue())
 * Licensed to Elasticsearch under one or more contributor  
                .append(pendingClusterTask.getTimeInExecution())
 * SPDX-License-Identifier: Apache-2.0
 *  
package org.opensearch.action.admin.cluster.tasks;
        static final String EXECUTING = "executing";  
    public String toString() {
 */  
import org.opensearch.core.xcontent.ToXContentObject;  
 * the Apache License, Version 2.0 (the "License"); you may
        return builder;
 *
    static final class Fields {  
        builder.startArray(Fields.TASKS);
 * not use this file except in compliance with the License.
            sb.append(pendingClusterTask.getInsertOrder())
 * Unless required by applicable law or agreed to in writing,
        static final String TASKS = "tasks";
            builder.field(Fields.PRIORITY, pendingClusterTask.getPriority());
        pendingTasks = in.readList(PendingClusterTask::new);
/*  
import java.io.IOException;  
     * The pending cluster tasks
                .append("/")
    @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.action.ActionResponse;  
     */
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
            builder.field(Fields.TIME_IN_QUEUE, pendingClusterTask.getTimeInQueue());  
            builder.field(Fields.INSERT_ORDER, pendingClusterTask.getInsertOrder());
                .append(pendingClusterTask.getPriority())
}
    public List<PendingClusterTask> pendingTasks() {
        builder.endObject();  
    /**
            builder.field(Fields.EXECUTING, pendingClusterTask.isExecuting());
                .append("/")  
 * compatible open source license.
        }
        return pendingTasks;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 *  
    @Override
 * software distributed under the License is distributed on an
    }
            builder.endObject();  
    /**  
    }
    }  
            builder.field(Fields.TIME_IN_QUEUE_MILLIS, pendingClusterTask.getTimeInQueueInMillis());
/**
        for (PendingClusterTask pendingClusterTask : this) {
        static final String TIME_IN_EXECUTION = "time_in_execution";
 * ownership. Elasticsearch licenses this file to you under  
 */
        StringBuilder sb = new StringBuilder();
        for (PendingClusterTask pendingClusterTask : this) {
 * GitHub history for details.
     */
import org.opensearch.core.xcontent.XContentBuilder;
        return pendingTasks.iterator();  
    }  
    PendingClusterTasksResponse(List<PendingClusterTask> pendingTasks) {
        static final String PRIORITY = "priority";
        builder.endArray();
            builder.field(Fields.SOURCE, pendingClusterTask.getSource());  
        sb.append("tasks: (").append(pendingTasks.size()).append("):\n");  
        super(in);  
    public List<PendingClusterTask> getPendingTasks() {  
            builder.field(Fields.TIME_IN_EXECUTION_MILLIS, pendingClusterTask.getTimeInExecutionInMillis());
    public void writeTo(StreamOutput out) throws IOException {  
            builder.startObject();  
        return sb.toString();
        static final String TIME_IN_QUEUE = "time_in_queue";
                .append(pendingClusterTask.getSource())  
 */  
    }
                .append("\n");
import org.opensearch.common.annotation.PublicApi;
        static final String TIME_IN_QUEUE_MILLIS = "time_in_queue_millis";
        static final String INSERT_ORDER = "insert_order";
import org.opensearch.cluster.service.PendingClusterTask;
public class PendingClusterTasksResponse extends ActionResponse implements Iterable<PendingClusterTask>, ToXContentObject {
@PublicApi(since = "1.0.0")  
     * Inner Fields used for creating XContent and parsing
 *
        builder.startObject();  
 * under the License.  
import java.util.List;
        }  
        out.writeList(pendingTasks);
 * Modifications Copyright OpenSearch Contributors. See
    public Iterator<PendingClusterTask> iterator() {
 * @opensearch.api
        static final String TIME_IN_EXECUTION_MILLIS = "time_in_execution_millis";  
        return pendingTasks();
        static final String SOURCE = "source";  
/*  
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.core.common.io.stream.StreamOutput;
