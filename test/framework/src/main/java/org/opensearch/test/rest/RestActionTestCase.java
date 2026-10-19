import java.util.function.BiFunction;  
        }
            ActionListener<Response> listener
            BiFunction<ActionType<Response>, Request, Response> verifier
        public <Request extends ActionRequest, Response extends ActionResponse> void setExecuteLocallyVerifier(
     * <p>
    }
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.transport.client.node.NodeClient;
        }
import org.opensearch.test.client.NoOpNodeClient;
import org.opensearch.tasks.TaskListener;
        }
    protected VerifyingClient verifyingClient;
            executeLocallyVerifier.set((arg1, arg2) -> { throw new AssertionError(); });
        /**  
         * Clears any previously set verifier functions set by {@link #setExecuteVerifier(BiFunction)} and/or
        /**  
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
        public <Request extends ActionRequest, Response extends ActionResponse> Task executeLocally(  
 * compatible open source license.
    public static class VerifyingClient extends NoOpNodeClient {  
            ActionType<Response> action,
    }  
import org.junit.After;
         * Sets the function that will be called when {@link #doExecute(ActionType, ActionRequest, ActionListener)} is called. The given
    }
import java.util.concurrent.atomic.AtomicReference;
        public VerifyingClient(String testName) {
         */
     */
import org.opensearch.rest.RestController;
            TaskListener<Response> listener
/*  
         * Sets the function that will be called when {@link #executeLocally(ActionType, ActionRequest, TaskListener)}is called. The given
 */  
        return controller;
        verifyingClient = new VerifyingClient(this.getTestName());  
         * {@link #setExecuteLocallyVerifier(BiFunction)}. These functions are replaced with functions which will throw an
import java.util.Collections;
        ) {
            executeVerifier.set((arg1, arg2) -> { throw new AssertionError(); });  
        }
            Request request,  
    protected RestController controller() {
 * KIND, either express or implied.  See the License for the
     */
         * function should return either a subclass of {@link ActionResponse} or {@code null}.  
    /**
        }
            return null;  
            listener.onResponse(null, (Response) executeLocallyVerifier.get().apply(action, request));  
            ActionType<Response> action,
 * Modifications Copyright OpenSearch Contributors. See
         * @param verifier A function which is called in place of {@link #doExecute(ActionType, ActionRequest, ActionListener)}
     * Sends the given request to the test controller in {@link #controller()}.  
        ) {
            return null;
         * function should return either a subclass of {@link ActionResponse} or {@code null}.
    @After
 * software distributed under the License is distributed on an
        verifyingClient.close();  
        @Override
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
            ActionListener<Response> listener  
import org.opensearch.action.ActionRequest;
 * GitHub history for details.
            Request request,
 * specific language governing permissions and limitations
import org.opensearch.rest.RestRequest;  
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
            listener.onResponse((Response) executeLocallyVerifier.get().apply(action, request));
            Request request,  
import org.opensearch.usage.UsageService;  
     */  
        public <Request extends ActionRequest, Response extends ActionResponse> Task executeLocally(
        }
    private RestController controller;
        @Override  
     * A test {@link RestController}. This controller can be used to register and delegate
        FakeRestChannel channel = new FakeRestChannel(request, false, 1);  
    }  
public abstract class RestActionTestCase extends OpenSearchTestCase {  
        ) {
        @Override  
     * A mocked {@link NodeClient} which can be easily reconfigured to verify arbitrary verification  
        public void reset() {
        AtomicReference<BiFunction> executeVerifier = new AtomicReference<>();
    }
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            listener.onResponse((Response) executeVerifier.get().apply(action, request));  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
 *
     * functions, and can be reset to allow reconfiguration partway through a test without having to construct a new object.
 * the Apache License, Version 2.0 (the "License"); you may
 */  
            executeVerifier.set(verifier);  
 *
            super(testName);
 */
     * to handlers, but uses a mock client and cannot carry out the full request.
            ActionType<Response> action,
/*
 * this file be licensed under the Apache-2.0 license or a
        /**
 * under the License.  
        ) {
    /**  
    /**
import org.opensearch.action.ActionType;
}
 */
        }  
 *  
            BiFunction<ActionType<Response>, Request, Response> verifier  
        controller.dispatchRequest(request, channel, threadContext);
         * @param verifier A function which is called in place of {@link #executeLocally(ActionType, ActionRequest, TaskListener)}  
     * {@link #setExecuteVerifier(BiFunction)} or {@link #setExecuteLocallyVerifier(BiFunction)}.
import org.opensearch.common.settings.Settings;  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
 * A common base class for Rest*ActionTests. Provides access to a {@link RestController}  
import org.opensearch.common.util.concurrent.ThreadContext;
    @Before
import org.opensearch.core.action.ActionResponse;  
package org.opensearch.test.rest;
import org.junit.Before;
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.core.action.ActionListener;
        AtomicReference<BiFunction> executeLocallyVerifier = new AtomicReference<>();
 * The OpenSearch Contributors require contributions made to  
         */
            executeLocallyVerifier.set(verifier);
         */
        public <Request extends ActionRequest, Response extends ActionResponse> void setExecuteVerifier(  
/**
 * Licensed to Elasticsearch under one or more contributor  
        controller = new RestController(Collections.emptySet(), null, verifyingClient, new NoneCircuitBreakerService(), new UsageService());
    protected void dispatchRequest(RestRequest request) {
 * Unless required by applicable law or agreed to in writing,
        public <Request extends ActionRequest, Response extends ActionResponse> void doExecute(
         * {@link AssertionError} if called.  
 * that can be used to register individual REST actions, and test request handling.
     * By default, will throw {@link AssertionError} when any execution method is called, unless configured otherwise using  
        ) {
import org.opensearch.tasks.Task;
            reset();  
    public void tearDownController() {
    public void setUpController() {
