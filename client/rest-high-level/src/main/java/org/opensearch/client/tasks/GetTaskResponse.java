 * KIND, either express or implied.  See the License for the
    );  
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
 *
 */  
 * GitHub history for details.
    }
 *  
    private final boolean completed;
        return taskInfo;
 * this file be licensed under the Apache-2.0 license or a
        this.taskInfo = taskInfo;  
import org.opensearch.tasks.TaskInfo;  
    }
    }
 * specific language governing permissions and limitations
    public boolean isCompleted() {  
    }
/*
 * Modifications Copyright OpenSearch Contributors. See  
    private static final ConstructingObjectParser<GetTaskResponse, Void> PARSER = new ConstructingObjectParser<>(
 * The OpenSearch Contributors require contributions made to  
 *
/*  
 * software distributed under the License is distributed on an
    public GetTaskResponse(boolean completed, TaskInfo taskInfo) {
import org.opensearch.core.xcontent.ConstructingObjectParser;
 * license agreements. See the NOTICE file distributed with
 */
 * the Apache License, Version 2.0 (the "License"); you may
    public static final ParseField COMPLETED = new ParseField("completed");
import org.opensearch.core.xcontent.XContentParser;
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
}  
public class GetTaskResponse {
        PARSER.declareBoolean(constructorArg(), COMPLETED);
package org.opensearch.client.tasks;
    static {
 * SPDX-License-Identifier: Apache-2.0
    public static GetTaskResponse fromXContent(XContentParser parser) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
        a -> new GetTaskResponse((boolean) a[0], (TaskInfo) a[1])
 * compatible open source license.
        PARSER.declareObject(constructorArg(), (p, c) -> TaskInfo.fromXContent(p), TASK);  
import org.opensearch.core.ParseField;  
        return completed;
        "get_task",  
 */
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
        true,
 * You may obtain a copy of the License at  
        this.completed = completed;
    private final TaskInfo taskInfo;  
    }  
        return PARSER.apply(parser, null);
    public TaskInfo getTaskInfo() {
    public static final ParseField TASK = new ParseField("task");
