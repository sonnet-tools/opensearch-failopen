 * KIND, either express or implied.  See the License for the
/*
/*  
 * specific language governing permissions and limitations
/*  
import java.util.Collections;
        assertEquals(cancelTasksRequest.getDescription(), task.getDescription());  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
        );
        CancelTasksRequest cancelTasksRequest = new CancelTasksRequest();
public class CancelTasksRequestTests extends OpenSearchTestCase {
        cancelTasksRequest.setTaskId(new TaskId("node1", 1));
    }
 * not use this file except in compliance with the License.
            "reason[by user request], waitForCompletion[false], taskId[node1:1], "
 * You may obtain a copy of the License at  
 * GitHub history for details.
import org.opensearch.core.tasks.TaskId;
 *     http://www.apache.org/licenses/LICENSE-2.0
        Task task = cancelTasksRequest.createTask(1, "type", "action", null, Collections.emptyMap());
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(  
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
 *  
import org.opensearch.test.OpenSearchTestCase;  
 */  
            cancelTasksRequest.getDescription()  
}
 *
 * software distributed under the License is distributed on an
 * under the License.  
                + "parentTaskId[node1:0], nodes[node1, node2], actions[action1, action2]",
 * compatible open source license.
        cancelTasksRequest.setActions("action1", "action2");
 * ownership. Elasticsearch licenses this file to you under  
    public void testGetDescription() {  
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
import org.opensearch.tasks.Task;
 * Licensed to Elasticsearch under one or more contributor  
        cancelTasksRequest.setNodes("node1", "node2");  
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.action.admin.cluster.node.tasks.cancel;
        cancelTasksRequest.setParentTaskId(new TaskId("node1", 0));
 *
 * SPDX-License-Identifier: Apache-2.0
