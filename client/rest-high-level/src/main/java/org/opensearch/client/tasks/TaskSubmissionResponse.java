        return Objects.equals(task, that.task);  
     *  
        a -> new TaskSubmissionResponse((String) a[0])  
        true,
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
 */  
 */
 * KIND, either express or implied.  See the License for the
    private final String task;
 * compatible open source license.
}  
        return PARSER.parse(parser, null);
            return true;  
 *  
 * GitHub history for details.
     */
 */  
 * this file be licensed under the Apache-2.0 license or a
    @Override
        TaskSubmissionResponse that = (TaskSubmissionResponse) other;
        "task_submission_response",
 * license agreements. See the NOTICE file distributed with
    }
            return false;  
 * not use this file except in compliance with the License.
    static {  
 * You may obtain a copy of the License at  
import org.opensearch.core.xcontent.XContentParser;  
    /**
 * software distributed under the License is distributed on an
    );
package org.opensearch.client.tasks;
    }
import org.opensearch.core.xcontent.ConstructingObjectParser;
    public String getTask() {  
    public static TaskSubmissionResponse fromXContent(XContentParser parser) throws IOException {  
        if (this == other) {
 *
/*  
    public boolean equals(Object other) {
 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @return the id of the reindex task.
        return task;
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.ParseField;
        return Objects.hash(task);  
        }
import java.io.IOException;
        if (other == null || getClass() != other.getClass()) {
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Objects;  
 * SPDX-License-Identifier: Apache-2.0
        this.task = task;
     * Get the task id
public class TaskSubmissionResponse {
    public int hashCode() {
    }
    }
    public static final ConstructingObjectParser<TaskSubmissionResponse, Void> PARSER = new ConstructingObjectParser<>(  
    private static final ParseField TASK = new ParseField("task");
    }
 * specific language governing permissions and limitations
/*  
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        PARSER.declareString(ConstructingObjectParser.optionalConstructorArg(), TASK);
        }
 * Unless required by applicable law or agreed to in writing,
    }
 *
    @Override  
    TaskSubmissionResponse(String task) {  
