 * under the License.  
package org.opensearch.rest.action.admin.indices;
import static org.hamcrest.Matchers.equalTo;
        threadPool = null;
import static java.util.Collections.emptyMap;
            new ActionFilters(Collections.emptySet()),
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.tasks.TaskManager;
     * <p>
            .withParams(emptyMap())
        final String content = "{\"query\":{}}";  
     * Configures {@link NodeClient} to stub {@link ValidateQueryAction} transport action.
import org.opensearch.transport.client.node.NodeClient;  
import org.junit.Before;  
        final Map<ActionType, TransportAction> actions = new HashMap<>();  
 */  
        client = null;
        assertThat(channel.capturedResponse().content().utf8ToString(), containsString("{\"valid\":false}"));  
        final FakeRestChannel channel = new FakeRestChannel(request, true, 0);  
 * The OpenSearch Contributors require contributions made to  
        assertThat(channel.errors().get(), equalTo(0));
        final RestRequest request = createRestRequest(content);
        assertThat(channel.errors().get(), equalTo(0));  
import static java.util.Collections.emptySet;
        // GIVEN a valid query
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.rest.RestRequest;
import org.opensearch.core.xcontent.MediaTypeRegistry;
    public static void stubValidateQueryAction() {  
        final String content = "{\"query\":{\"bool\":{\"must\":{\"term\":{\"user\":\"foobar\"}}}}}";
        action.handleRequest(request, channel, client);
/*  
        actions.put(ValidateQueryAction.INSTANCE, transportAction);
/*
        client.initialize(dynamicActionRegistry, () -> "local", null, new NamedWriteableRegistry(Collections.emptyList()));
 * compatible open source license.
        final FakeRestChannel channel = new FakeRestChannel(request, true, 0);
 */
 * this file be licensed under the Apache-2.0 license or a
        final FakeRestChannel channel = new FakeRestChannel(request, true, 0);
            .withContent(new BytesArray(content), MediaTypeRegistry.JSON)  
 * GitHub history for details.
    }
        dynamicActionRegistry.registerUnmodifiableActionMap(actions);
        assertThat(channel.responses().get(), equalTo(1));
        final TransportAction<?, ?> transportAction = new TransportAction<>(  
import org.opensearch.search.AbstractSearchTestCase;
        final RestRequest request = createRestRequest(content);
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.HashMap;
 * software distributed under the License is distributed on an
    }
    public void testRestValidateQueryAction_emptyQuery() throws Exception {
public class RestValidateQueryActionTests extends AbstractSearchTestCase {  
    private static RestValidateQueryAction action = new RestValidateQueryAction();
        usageService = null;
     * This lower level of validation is out of the scope of this test.  
import org.opensearch.action.admin.indices.validate.query.ValidateQueryAction;  
        final RestRequest request = createRestRequest(content);  
        // GIVEN an empty (i.e. invalid) query wrapped into a valid JSON
    }
 *
        action.handleRequest(request, channel, client);  
import org.opensearch.action.support.TransportAction;
        assertThat(channel.responses().get(), equalTo(1));  
    @Before  
 *
     */
import org.opensearch.rest.RestController;  
import org.junit.BeforeClass;
import org.opensearch.core.common.bytes.BytesArray;
            protected void doExecute(Task task, ActionRequest request, ActionListener listener) {}  
import org.opensearch.action.ActionType;
    @BeforeClass
import java.util.Map;
    public void testRestValidateQueryAction_malformedQuery() throws Exception {
        threadPool.getThreadContext().stashContext();  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.tasks.Task;  
        controller.registerHandler(action);  
 * this work for additional information regarding copyright
    public void testRestValidateQueryAction() throws Exception {  
 */
import org.opensearch.action.support.ActionFilters;
        // THEN query is valid (i.e. not marked as invalid)
    @AfterClass  
        ) {
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
    }
    private static UsageService usageService = new UsageService();
        // THEN query is marked as invalid  
    }
import org.opensearch.core.action.ActionListener;
        // Make sure we have a clean context for each test
        assertNull(channel.capturedResponse());
        terminate(threadPool);
        action.handleRequest(request, channel, client);
            .build();
    public static void terminateThreadPool() throws InterruptedException {
        final TaskManager taskManager = new TaskManager(Settings.EMPTY, threadPool, Collections.emptySet());
            @Override
import org.opensearch.threadpool.TestThreadPool;
        DynamicActionRegistry dynamicActionRegistry = new DynamicActionRegistry();  
    private RestRequest createRestRequest(String content) {  
        controller = null;
        assertThat(channel.errors().get(), equalTo(0));
 * KIND, either express or implied.  See the License for the
import static org.hamcrest.Matchers.containsString;  
        // WHEN
        assertThat(channel.capturedResponse().content().utf8ToString(), containsString("{\"valid\":false}"));
 * specific language governing permissions and limitations
import org.opensearch.action.ActionRequest;
    }  
        // WHEN  
import org.opensearch.test.rest.FakeRestChannel;
 * not use this file except in compliance with the License.
}  
import org.opensearch.common.settings.Settings;  
import java.util.Collections;  
        // GIVEN an invalid query due to a malformed JSON  
        final String content = "{malformed_json}";
import org.opensearch.test.rest.FakeRestRequest;  
import org.junit.AfterClass;
            ValidateQueryAction.NAME,
    }
        return new FakeRestRequest.Builder(xContentRegistry()).withPath("index1/type1/_validate/query")
    public void ensureCleanContext() {
    /**  
    private static ThreadPool threadPool = new TestThreadPool(RestValidateQueryActionTests.class.getName());
import org.opensearch.usage.UsageService;
 * Unless required by applicable law or agreed to in writing,
            taskManager  
import org.opensearch.action.ActionModule.DynamicActionRegistry;  
        };
        action = null;  
import org.opensearch.threadpool.ThreadPool;
    private static NodeClient client = new NodeClient(Settings.EMPTY, threadPool);  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
/*
    private static RestController controller = new RestController(emptySet(), null, client, new NoneCircuitBreakerService(), usageService);  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // WHEN
        assertThat(channel.responses().get(), equalTo(0));
        // THEN query is marked as invalid
 *  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
