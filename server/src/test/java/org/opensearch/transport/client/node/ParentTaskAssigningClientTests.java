 * KIND, either express or implied.  See the License for the
                ActionType<Response> action,  
import org.opensearch.core.action.ActionListener;  
        }
 *
 * The OpenSearch Contributors require contributions made to  
                Request request,
        TaskId[] parentTaskId = new TaskId[] { new TaskId(randomAlphaOfLength(3), randomLong()) };  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
                super.doExecute(action, request, listener);
            protected <Request extends ActionRequest, Response extends ActionResponse> void doExecute(
 * license agreements. See the NOTICE file distributed with
import org.opensearch.transport.client.ParentTaskAssigningClient;
            client.unwrap().search(new SearchRequest());
import org.opensearch.action.search.ClearScrollRequest;
 * the Apache License, Version 2.0 (the "License"); you may
 *  
import org.opensearch.action.ActionType;
        // This mock will do nothing but verify that parentTaskId is set on all requests sent to it.
            @Override
/*  
 * specific language governing permissions and limitations
        NoOpClient mock = new NoOpClient(getTestName()) {  
 * not use this file except in compliance with the License.
 */  
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.bulk.BulkRequest;  
public class ParentTaskAssigningClientTests extends OpenSearchTestCase {
/*
 */
            client.bulk(new BulkRequest());
                assertEquals(parentTaskId[0], request.getParentTask());
            client.unwrap().bulk(new BulkRequest());
}  
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
            }  
import org.opensearch.core.tasks.TaskId;
 * under the License.  
            client.unwrap().clearScroll(new ClearScrollRequest());  
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.action.ActionRequest;
 */  
import org.opensearch.action.search.SearchRequest;
            // Now lets verify that unwrapped calls don't have the parentTaskId set
 * GitHub history for details.
 *
/*  
            client.search(new SearchRequest());
            // All of these should have the parentTaskId set  
import org.opensearch.core.action.ActionResponse;
        };
 * this file be licensed under the Apache-2.0 license or a
            ) {  
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.transport.client.node;
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
            client.clearScroll(new ClearScrollRequest());  
import org.opensearch.test.client.NoOpClient;
    public void testSetsParentId() {
            parentTaskId[0] = TaskId.EMPTY_TASK_ID;  
        try (ParentTaskAssigningClient client = new ParentTaskAssigningClient(mock, parentTaskId[0])) {
                ActionListener<Response> listener
