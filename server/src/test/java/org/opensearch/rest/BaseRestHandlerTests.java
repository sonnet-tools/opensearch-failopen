                return channel -> executed.set(true);
                return channel -> executed.set(true);
import java.util.concurrent.atomic.AtomicBoolean;
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withParams(params).build();
 * Licensed to Elasticsearch under one or more contributor
            }
        RestHandler rh = new RestHandler() {
        };
            protected Set<String> responseParams() {
                request.param("consumed");
    private ThreadPool threadPool;
                request.param("consumed");
        List<Route> routes = Arrays.asList(new Route(Method.GET, "/path/test"), new Route(Method.PUT, "/path2/test"));
            @Override
/*
import org.opensearch.common.settings.Settings;
        params.put("human", null);
        RestHandler.Wrapper rhWrapper = new RestHandler.Wrapper(handlerSpy);
            @Override
        params.put("consumed", randomAlphaOfLength(8));
        verifyNoMoreInteractions(handlerSpy);
 * software distributed under the License is distributed on an
        );
        List<ReplacedRoute> replacedRoutes = RestHandler.replaceRoutes(routes, "/prefix", "/deprecatedPrefix");
 * this work for additional information regarding copyright
import static org.mockito.ArgumentMatchers.any;
                method.invoke(rhWrapper, args);
        };
                        + "[flied] -> did you mean [field]?, "
                return "test_unconsumed_response_action";
        assertTrue(executed.get());
        );
                        + "[respones_param] -> did you mean [response_param]?, "
import org.opensearch.rest.action.cat.AbstractCatAction;
            method.invoke(verify(handlerSpy, times(1)), args);
        assertThat(e, hasToString(containsString("request [/] contains unrecognized parameter: [unconsumed]")));
        final HashMap<String, String> params = new HashMap<>();
        params.put("bytes", randomAlphaOfLength(8));
            }
import org.opensearch.test.rest.FakeRestChannel;
    }
        RestChannel channel = new FakeRestChannel(request, randomBoolean(), 1);
}
                    "request [/] contains unrecognized parameters: "
                return "test_one_unconsumed_response_action";
        threadPool = new TestThreadPool(this.getClass().getSimpleName() + "ThreadPool");
                return null;
            Object[] args = new Object[argCount];
        for (java.lang.reflect.Method method : overridableMethods) {
 *
 */
            protected Table getTableWithHeader(RestRequest request) {
        RestChannel channel = new FakeRestChannel(request, randomBoolean(), 1);
 * specific language governing permissions and limitations
            IllegalArgumentException.class,
        );
        RestChannel channel = new FakeRestChannel(request, randomBoolean(), 1);
            public String getName() {
        };
        params.put("format", randomAlphaOfLength(8));
                return channel -> executed.set(true);
            IllegalArgumentException.class,
        AbstractCatAction handler = new AbstractCatAction() {
import java.util.stream.Collectors;
        params.put("unconsumed", randomAlphaOfLength(8));
        final IllegalArgumentException e = expectThrows(
            protected void documentation(StringBuilder sb) {
    public void setUp() throws Exception {
        params.put("tokenzier", randomAlphaOfLength(8));
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withParams(params).build();
            @Override
    }
            @Override
    public void testOneUnconsumedParameters() throws Exception {
                args[i] = any();
        mockClient.close();
        };
import org.opensearch.transport.client.node.NodeClient;
        final AtomicBoolean executed = new AtomicBoolean();
        params.put("filter_path", randomAlphaOfLength(8));
        params.put("very_far_from_every_consumed_parameter", randomAlphaOfLength(8));
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withParams(params).build();
            @Override
        params.put("response_param", randomAlphaOfLength(8));
                request.param("tokenizer");
                request.param("consumed");
        final IllegalArgumentException e = expectThrows(
import org.opensearch.threadpool.TestThreadPool;
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        threadPool.shutdown();
        params.put("ts", randomAlphaOfLength(8));
package org.opensearch.rest;
    public void testCatResponseParameters() throws Exception {
            assertEquals(routes.get(i).getMethod(), replacedRoutes.get(i).getMethod());
            }
        assertThat(e, hasToString(containsString("request [/] contains unrecognized parameters: [unconsumed-first], [unconsumed-second]")));
 */
            () -> handler.handleRequest(request, channel, mockClient)
import static org.hamcrest.object.HasToString.hasToString;
        handler.handleRequest(request, channel, mockClient);
        handler.handleRequest(request, channel, mockClient);
            IllegalArgumentException.class,
            @Override
        final HashMap<String, String> params = new HashMap<>();
/*
            assertEquals("/prefix" + routes.get(i).getPath(), replacedRoutes.get(i).getPath());
import org.opensearch.common.Table;
            hasToString(
                return "test_multiple_unconsumed_response_action";
 * KIND, either express or implied.  See the License for the
            @Override
        assertFalse(executed.get());
            @Override
 *
            @Override
        };
                return Collections.singleton("response_param");
        BaseRestHandler handler = new BaseRestHandler() {
                return channel -> executed.set(true);
            }
        final HashMap<String, String> params = new HashMap<>();
 *
                        + "[tokenzier] -> did you mean [tokenizer]?, "
import java.util.List;
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withParams(params).build();
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withParams(params).build();
 */
import org.opensearch.core.common.bytes.BytesArray;
import static org.mockito.Mockito.times;
        mockClient = new NodeClient(Settings.EMPTY, threadPool);
            .filter(
                return channel -> executed.set(true);
 * the Apache License, Version 2.0 (the "License"); you may
            protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
            }
            @Override
        params.put("pretty", randomFrom("true", "false", "", null));
        params.put("pri", randomAlphaOfLength(8));
    public void testReplaceRoutesMethod() throws Exception {
        RestChannel channel = new FakeRestChannel(request, randomBoolean(), 1);
            }
/*
            }
import static org.mockito.Mockito.verifyNoMoreInteractions;
 * compatible open source license.
    @Override
        assertTrue(executed.get());
        params.put("format", randomAlphaOfLength(8));
            @Override
                return "test_cat_response_action";
        params.put("size", randomAlphaOfLength(8));
        params.put("unconsumed-second", randomAlphaOfLength(8));
import org.opensearch.test.rest.FakeRestRequest;
            public String getName() {
        final HashMap<String, String> params = new HashMap<>();
            }
        params.put("v", randomAlphaOfLength(8));
        final HashMap<String, String> params = new HashMap<>();
    }
            }
        params.put("consumed", randomAlphaOfLength(8));
    public void testDefaultResponseParameters() throws Exception {
        final AtomicBoolean executed = new AtomicBoolean();
        final HashMap<String, String> params = new HashMap<>();
import org.opensearch.rest.RestHandler.Route;
            }
        params.put("unconsumed-first", randomAlphaOfLength(8));
import static org.hamcrest.core.StringContains.containsString;
                return Collections.singleton("response_param");
        final AtomicBoolean executed = new AtomicBoolean();
        final AtomicBoolean executed = new AtomicBoolean();
        final AtomicBoolean executed = new AtomicBoolean();
    }
        params.put("very_close_to_parametre", randomAlphaOfLength(8));
    public void testUnconsumedResponseParameters() throws Exception {
        }
            )
                request.param("field");
            }
            public String getName() {
            @Override
        RestHandler handlerSpy = spy(rh);
            if (args.length > 0) {
import java.util.Collections;
            }
            protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
import java.lang.reflect.Modifier;
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withParams(params).build();
import org.opensearch.threadpool.ThreadPool;
 * The OpenSearch Contributors require contributions made to
                containsString(
            for (int i = 0; i < argCount; i++) {
            public String getName() {
            protected RestChannelConsumer doCatRequest(RestRequest request, NodeClient client) {
            @Override
        );
        assertTrue(executed.get());
        final AtomicBoolean executed = new AtomicBoolean();
                m -> !(Modifier.isPrivate(m.getModifiers()) || Modifier.isStatic(m.getModifiers()) || Modifier.isFinal(m.getModifiers()))
 * GitHub history for details.
                        + "[very_close_to_parametre] -> did you mean any of [very_close_to_parameter_1, very_close_to_parameter_2]?, "
        RestChannel channel = new FakeRestChannel(request, randomBoolean(), 1);
        params.put("flied", randomAlphaOfLength(8));
        List<java.lang.reflect.Method> overridableMethods = Arrays.stream(RestHandler.class.getMethods())
public class BaseRestHandlerTests extends OpenSearchTestCase {
            }
        params.put("consumed", randomAlphaOfLength(8));
        final IllegalArgumentException e = expectThrows(
        BaseRestHandler handler = new BaseRestHandler() {
            () -> handler.handleRequest(request, channel, mockClient)
    }
            }
            public void handleRequest(RestRequest request, RestChannel channel, NodeClient client) throws Exception {
                request.param("very_close_to_parameter_2");
            protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
                return "test_unconsumed_did_you_mean_response_action";
        BaseRestHandler handler = new BaseRestHandler() {
    public void testMultipleUnconsumedParameters() throws Exception {
 * Unless required by applicable law or agreed to in writing,
        BaseRestHandler handler = new BaseRestHandler() {
        params.put("respones_param", randomAlphaOfLength(8));
                        + "[very_far_from_every_consumed_parameter]"
            e,
            protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
            int argCount = method.getParameterCount();
            @Override
            protected Set<String> responseParams() {
            public String getName() {
import java.util.Set;
import java.util.HashMap;
import org.opensearch.core.rest.RestStatus;
        super.setUp();
        params.put("consumed", randomAlphaOfLength(8));
 * Modifications Copyright OpenSearch Contributors. See
                request.param("very_close_to_parameter_1");
                )
    public void testUnconsumedParametersDidYouMean() throws Exception {
import static org.mockito.Mockito.spy;
 *    http://www.apache.org/licenses/LICENSE-2.0
        };
        params.put("h", randomAlphaOfLength(8));
            () -> handler.handleRequest(request, channel, mockClient)
    }
        RestChannel channel = new FakeRestChannel(request, randomBoolean(), 1);
            )
        };
        super.tearDown();
 * SPDX-License-Identifier: Apache-2.0
        params.put("time", randomAlphaOfLength(8));
                request.param("consumed");
            @Override
            protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
    @Override
            assertEquals("/deprecatedPrefix" + routes.get(i).getPath(), replacedRoutes.get(i).getDeprecatedPath());
import static org.mockito.Mockito.verify;
            }
            @Override
        BaseRestHandler handler = new BaseRestHandler() {
        assertThat(
 * under the License.
import org.opensearch.rest.RestRequest.Method;
import java.util.Arrays;
        for (int i = 0; i < routes.size(); i++) {
    }
            }
            .collect(Collectors.toList());
 * ownership. Elasticsearch licenses this file to you under
    }
    public void testRestHandlerWrapper() throws Exception {
            } else {
            @Override
import org.opensearch.rest.RestHandler.ReplacedRoute;
import java.io.IOException;
    public void tearDown() throws Exception {
    }
            public String getName() {
                new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY);
            }
import org.opensearch.test.OpenSearchTestCase;
 * You may obtain a copy of the License at
            }
                return "test_default_response_action";
            }
        handler.handleRequest(request, channel, mockClient);
 * this file be licensed under the Apache-2.0 license or a
                method.invoke(rhWrapper);
    }
                return channel -> executed.set(true);
        }
        assertFalse(executed.get());
    private NodeClient mockClient;
        assertFalse(executed.get());
 * license agreements. See the NOTICE file distributed with
