        };
    }
        FakeRestChannel fakeRestChannel = new FakeRestChannel(fakeRestRequest, false, 1);
            ) {  
                    TaskId.EMPTY_TASK_ID,
 *
 * not use this file except in compliance with the License.
 */
        return new NoOpNodeClient(getTestName()) {
            }
/*  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.test.rest.FakeRestRequest;
        ).build();  
 * specific language governing permissions and limitations
 * under the License.  
                ActionListener<Response> listener
package org.opensearch.rest.action.cat;
/*
import org.opensearch.core.action.ActionResponse;
        assertThat(fakeRestChannel.errors().get(), is(0));  
            @SuppressWarnings("unchecked")
            action.handleRequest(fakeRestRequest, fakeRestChannel, nodeClient);  
import static org.opensearch.tasks.TaskInfoTests.randomResourceStats;
                    Map.of("foo", "bar"),  
 * GitHub history for details.
 *
                    "test_description",
 * KIND, either express or implied.  See the License for the
                    new TaskId("test-node-id", randomLong()),
                listener.onResponse((Response) new ListTasksResponse(List.of(taskInfo), emptyList(), emptyList()));  
                    randomLongBetween(0, Long.MAX_VALUE),
 * software distributed under the License is distributed on an
    }  
import java.util.List;
 */  
        assertThat(fakeRestChannel.responses().get(), is(1));
 * Unless required by applicable law or agreed to in writing,
                Request request,
 * this file be licensed under the Apache-2.0 license or a
 */  
    private NoOpNodeClient buildNodeClient() {
 *  
 * this work for additional information regarding copyright
                    false,  
                final TaskInfo taskInfo = new TaskInfo(
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.collect.MapBuilder;
import org.opensearch.action.ActionType;
                    randomLong(),
import org.opensearch.core.xcontent.NamedXContentRegistry;  
import org.opensearch.core.action.ActionListener;  
        try (NoOpNodeClient nodeClient = buildNodeClient()) {
import java.util.Map;
import org.opensearch.test.OpenSearchTestCase;
                .put("actions", "*")
/*  
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.test.rest.FakeRestChannel;
    public void testConsumesParameters() throws Exception {
import org.opensearch.tasks.TaskInfo;
import org.opensearch.cluster.node.DiscoveryNodes;
        FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withParams(  
                .put("parent_task_id", "the node:3")
        }
import org.opensearch.test.client.NoOpNodeClient;  
                    "test_action",
                ActionType<Response> action,  
        RestTasksAction action = new RestTasksAction(() -> DiscoveryNodes.EMPTY_NODES);
import org.opensearch.action.ActionRequest;
 *     http://www.apache.org/licenses/LICENSE-2.0
                .map()
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;  
            public <Request extends ActionRequest, Response extends ActionResponse> void doExecute(
 * the Apache License, Version 2.0 (the "License"); you may
import static java.util.Collections.emptyList;
 * You may obtain a copy of the License at  
            MapBuilder.<String, String>newMapBuilder()
import org.opensearch.core.tasks.TaskId;
public class RestTasksActionTests extends OpenSearchTestCase {
                    null,  
}
import static org.hamcrest.Matchers.is;  
                );
 * The OpenSearch Contributors require contributions made to  
                .put("nodes", "node1,node2")  
                    "test_type",  
                    false,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
                    randomResourceStats(randomBoolean())
            @Override  
 * SPDX-License-Identifier: Apache-2.0
