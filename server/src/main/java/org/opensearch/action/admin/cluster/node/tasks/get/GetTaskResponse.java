@PublicApi(since = "1.0.0")
 * Returns the list of tasks currently running on the nodes
import static java.util.Objects.requireNonNull;
import org.opensearch.common.annotation.PublicApi;
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.ToXContentObject;
/*  
public class GetTaskResponse extends ActionResponse implements ToXContentObject {  
/*
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.common.io.stream.StreamOutput;
    }  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.action.admin.cluster.node.tasks.get;
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
        return task;
 * GitHub history for details.
        task = in.readOptionalWriteable(TaskResult::new);
    /**  
        super(in);  
 * software distributed under the License is distributed on an
        task.innerToXContent(builder, params);
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  
    public GetTaskResponse(TaskResult task) {
    public TaskResult getTask() {  
import org.opensearch.core.common.Strings;  
 * Licensed to Elasticsearch under one or more contributor  
    }
    }  
import org.opensearch.core.action.ActionResponse;
import org.opensearch.core.common.io.stream.StreamInput;
 * not use this file except in compliance with the License.
 *
import java.io.IOException;
}
 * this file be licensed under the Apache-2.0 license or a
    public GetTaskResponse(StreamInput in) throws IOException {
        this.task = requireNonNull(task, "task is required");
 *
/**  
        return Strings.toString(MediaTypeRegistry.JSON, this);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * compatible open source license.
    public String toString() {
     * Get the actual result of the fetch.
import org.opensearch.core.xcontent.XContentBuilder;
    @Override
 */
    @Override
 * KIND, either express or implied.  See the License for the
 * @opensearch.api  
 * Unless required by applicable law or agreed to in writing,
        builder.startObject();  
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
    @Override  
 */
 * license agreements. See the NOTICE file distributed with
 */  
        builder.endObject();
    }
 * SPDX-License-Identifier: Apache-2.0
     */
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        return builder;  
 */  
    }
/*  
        out.writeOptionalWriteable(task);  
 * You may obtain a copy of the License at  
    private final TaskResult task;
 *
import org.opensearch.tasks.TaskResult;  
