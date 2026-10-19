 * not use this file except in compliance with the License.
                @SuppressWarnings("unchecked")
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
    @Override
        return super.equals(o);
 * license agreements. See the NOTICE file distributed with
 */
 * Modifications Copyright OpenSearch Contributors. See  
 * this work for additional information regarding copyright
                List<TaskOperationFailure> tasksFailures = (List<TaskOperationFailure>) constructingObjects[i++];
    private static ConstructingObjectParser<CancelTasksResponse, Void> PARSER;
 * ownership. Elasticsearch licenses this file to you under  
            + "taskFailures="  
    }
        parser.declareNamedObjects(optionalConstructorArg(), NodeData.PARSER, new ParseField("nodes"));
 * under the License.  
 */
            + ", taskGroups="
            + '}';
        super(nodesInfoData, taskFailures, nodeFailures);  
            + tasks
                return new CancelTasksResponse(nodesInfoData, tasksFailures, nodeFailures);  
 * specific language governing permissions and limitations
        return super.hashCode();  
package org.opensearch.client.tasks;
            + ", tasks="  
/*
    }
        return PARSER.parse(parser, null);
 *
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        ConstructingObjectParser<CancelTasksResponse, Void> parser = new ConstructingObjectParser<>(
    public String toString() {
                int i = 0;
    }
 * compatible open source license.
 *
    }
            + nodesInfoData
 * Licensed to Elasticsearch under one or more contributor  
 * - node failures  
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
            + nodeFailures  
                List<NodeData> nodesInfoData = (List<NodeData>) constructingObjects[i];
 * the Apache License, Version 2.0 (the "License"); you may
 */  
    @Override
        PARSER = parser;
    CancelTasksResponse(List<NodeData> nodesInfoData, List<TaskOperationFailure> taskFailures, List<OpenSearchException> nodeFailures) {
            optionalConstructorArg(),
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
import org.opensearch.core.xcontent.XContentParser;
                @SuppressWarnings("unchecked")  
    }  
 * this file be licensed under the Apache-2.0 license or a
            + ", nodeFailures="
    static {  
        parser.declareObjectArray(optionalConstructorArg(), (p, c) -> OpenSearchException.fromXContent(p), new ParseField("node_failures"));  
}  
    public boolean equals(Object o) {  
import org.opensearch.core.xcontent.ConstructingObjectParser;
 * GitHub history for details.
 * - tasks
            new ParseField("task_failures")
public class CancelTasksResponse extends ListTasksResponse {  
/*  
 * - task failures
        parser.declareObjectArray(
        );
            true,  
    public static CancelTasksResponse fromXContent(final XContentParser parser) throws IOException {  
            "cancel_tasks_response",
            + taskGroups  
 * cancel tasks response that contains
                List<OpenSearchException> nodeFailures = (List<OpenSearchException>) constructingObjects[i++];  
            (p, c) -> TaskOperationFailure.fromXContent(p),  
import org.opensearch.core.ParseField;  
 * You may obtain a copy of the License at  
import java.io.IOException;
            }
/**  
            + taskFailures
                @SuppressWarnings("unchecked")
 */
    @Override  
import java.util.List;
        return "CancelTasksResponse{"
/*
        );
    public int hashCode() {
    }
            + ", nodesInfoData="
            constructingObjects -> {
 * KIND, either express or implied.  See the License for the
