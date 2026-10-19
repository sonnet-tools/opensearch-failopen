    @Before
    }
 * Works against real http servers, multiple hosts. Also tests failover by randomly shutting down hosts.
import static org.junit.Assert.fail;
        }
 * You may obtain a copy of the License at
                    } catch (ConnectException e) {
                }
            requestCameInLatch = new CountDownLatch(1);
            this.response = response;
    }
            cancelHandlerLatch = new CountDownLatch(1);
        httpServers = new HttpServer[numHttpServers];
        final List<Exception> exceptions = new CopyOnWriteArrayList<>();
import org.junit.Ignore;
            Request request = Request.newRequest("GET", "/200").build();
import java.util.concurrent.CancellationException;
}
            }
        TestResponse(String method, int statusCode, Object response) {
        private final String method;
        ResponseHandler(int statusCode) {
import static org.junit.Assert.assertThat;
                    responses.add(new TestResponse(method, statusCode, response));
            CountDownLatch latch = new CountDownLatch(1);
                }
                exchange.sendResponseHeaders(200, 0);
import java.net.ConnectException;
        Response getResponse() {
        httpServer.createContext(pathPrefix + "/wait", waitForCancelHandler);
import com.sun.net.httpserver.HttpServer;
    private NodeSelector firstPositionNodeSelector() {
            assertEquals((pathPrefix.length() > 0 ? pathPrefix : "") + "/" + testResponse.statusCode, response.requestLine().uri());
                public void onSuccess(Response response) {
            assertEquals(statusCode, response.statusLine().statusCode());
 *
                        fail("expected to fail to connect");
        } else {
        if (pathPrefix.length() > 0) {
 * the Apache License, Version 2.0 (the "License"); you may
import java.net.InetSocketAddress;
        RestHttpClientBuilder restClientBuilder = RestHttpClient.builder(httpHosts);
            }
    @AfterClass
            httpExchange.close();
            try {
        }
            if (randomBoolean()) {
import static org.opensearch.internal.httpclient.RestClientTestUtil.getAllStatusCodes;
            for (int i = 0; i < httpServers.length; i++) {
        int numRequests = randomIntBetween(5, 20);
    }
        }
package org.opensearch.internal.httpclient;
                    latch.countDown();
import static org.opensearch.internal.httpclient.RestClientTestUtil.randomOkStatusCode;
    private static class ResponseHandler implements HttpHandler {
                    responses.add(response);
        for (int i = 0; i < numRequests; i++) {
    }
/*
        int numHttpServers = randomIntBetween(2, 4);
 * compatible open source license.
            }
            requestCameInLatch.await();
        assertEquals(0, responses.size());
        }
        public void handle(HttpExchange httpExchange) throws IOException {
        }
        }
            for (int i = 0; i < rounds; i++) {
            this.statusCode = statusCode;
                    latch.countDown();
/*
            waitForCancelHandler.reset();
import java.net.http.HttpClient;
            });
import java.util.Iterator;
                        if (e.getMessage() != null) {
        if (randomBoolean()) {
        restClientBuilder.setNodeSelector(nodeSelector);
        }
 * Licensed to Elasticsearch under one or more contributor
        final List<Response> responses = new CopyOnWriteArrayList<>();
/**
    @BeforeClass
                        RestHttpClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
public class RestHttpClientMultipleHostsIntegTests extends RestHttpClientTestCase {
            this.statusCode = statusCode;
    }
import org.junit.BeforeClass;
        for (int i = 0; i < numHttpServers; i++) {
                    exceptions.add(exception);
/*
        for (Exception exception : exceptions) {
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(numRequests, responses.size());
                }
            final int statusCode = randomBoolean() ? randomOkStatusCode(getRandom()) : randomErrorNoRetryStatusCode(getRandom());
            // we don't test status codes that are subject to retries as they interfere with hosts being stopped
    }
    }
    private static boolean stoppedFirstHost = false;
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
            if (response instanceof ResponseException) {
 * Unless required by applicable law or agreed to in writing,
        final CountDownLatch latch = new CountDownLatch(numRequests);
 * Integration test to check interaction between {@link RestHttpClient} and {@link HttpClient}.
        restClient = null;
 * The OpenSearch Contributors require contributions made to
        private final int statusCode;
            httpServer.stop(0);
import java.util.List;
import static org.hamcrest.CoreMatchers.containsString;
 * under the License.
            waitForCancelHandler.cancelDone();
                    updatedHttpServers.add(httpServer);
            pathPrefix = pathPrefixWithoutLeadingSlash = "";
    }
        }
            httpServers = updatedHttpServers.toArray(new HttpServer[0]);
    public void testSyncRequests() throws IOException {
        }
        public void handle(HttpExchange exchange) throws IOException {
                response = responseException.getResponse();
        }
            if (0 == nodeIndex) {
    public static void stopHttpServers() throws IOException {
    public void testNodeSelector() throws Exception {
    private static RestHttpClient restClient;
import static org.junit.Assert.assertEquals;
                        }
import java.util.concurrent.CountDownLatch;
                return (Response) response;
    }
 * this work for additional information regarding copyright
        @Override
        int numRequests = randomIntBetween(5, 20);
        }
                 * Run the request more than once to verify that the
 */
        final List<TestResponse> responses = new CopyOnWriteArrayList<>();
    private static HttpServer createHttpServer() throws Exception {
                    latch.countDown();
    }
        }
            restClientBuilder.setPathPrefix((randomBoolean() ? "/" : "") + pathPrefixWithoutLeadingSlash);
            if (response instanceof Response) {
        waitForCancelHandler = new WaitForCancelHandler();
        restClient = buildRestClient(NodeSelector.ANY);
            Response response;
                    itr.remove();
                 * NodeSelector overrides the round robin behavior.
import com.sun.net.httpserver.HttpExchange;
            httpServer.createContext(pathPrefix + "/" + statusCode, new ResponseHandler(statusCode));
            cancellable.cancel();
                if (i == nodeIndex) {
    private static String pathPrefixWithoutLeadingSlash;
                }
        int numRequests = randomIntBetween(5, 20);
            // we don't test status codes that are subject to retries as they interfere with hosts being stopped
            }
            } catch (ResponseException responseException) {
            assertEquals(testResponse.statusCode, response.statusLine().statusCode());
                if (stoppedFirstHost) {
            List<HttpServer> updatedHttpServers = new ArrayList<>(httpServers.length - 1);
        try (RestHttpClient restClient = buildRestClient(firstPositionNodeSelector())) {
                // the request artificially on the client-side before even sending it
 */
        return httpServer;
import org.junit.AfterClass;
        for (int i = 0; i < numRequests; i++) {
        httpHosts = new HttpHost[numHttpServers];
        // verify that shutting down some hosts doesn't matter as long as one working host is left behind
            cancelHandlerLatch.countDown();
    public void stopRandomHost() {
    private static class TestResponse {
        @Override
                // we wait for the request to get to the server-side otherwise we almost always cancel
import java.io.IOException;
        }
            assertThat(exception, instanceOf(CancellationException.class));
            Response response = testResponse.getResponse();
                @Override
                    }
                if (httpHosts[0] != itr.next().getHost()) {
        void reset() {
        if (httpServers.length > 1 && randomBoolean()) {
        assertTrue(latch.await(5, TimeUnit.SECONDS));
        for (int statusCode : getAllStatusCodes()) {
    private static HttpServer[] httpServers;
        void cancelDone() {
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        void awaitRequest() throws InterruptedException {
import static org.hamcrest.CoreMatchers.instanceOf;
        private volatile CountDownLatch cancelHandlerLatch;
                } else {
        }
        }
    public void testCancelAsyncRequests() throws Exception {
    public void testAsyncRequests() throws Exception {
import java.util.concurrent.CopyOnWriteArrayList;
 */
        }
            pathPrefix = "/" + pathPrefixWithoutLeadingSlash;
        private final int statusCode;
        restClient.close();
                 */
            final String method = RestClientTestUtil.randomHttpMethod(getRandom());
            }
    private static class WaitForCancelHandler implements HttpHandler {
            httpHosts[i] = new HttpHost("http", httpServer.getAddress().getHostString(), httpServer.getAddress().getPort());
    }
        httpServer.start();
            pathPrefixWithoutLeadingSlash = "testPathPrefix/" + randomAsciiLettersOfLengthBetween(1, 5);
    private static String pathPrefix;
                stoppedFirstHost = true;
 * not use this file except in compliance with the License.
                    latch.countDown();
            assertEquals(testResponse.method, response.requestLine().method());
                    assertEquals(httpHosts[0], response.host());
            httpExchange.sendResponseHeaders(statusCode, -1);
                return ((ResponseException) response).getResponse();
            HttpServer httpServer = createHttpServer();
                public void onFailure(Exception exception) {
 * KIND, either express or implied.  See the License for the
import java.util.concurrent.TimeUnit;
                    httpServer.stop(0);
                public void onSuccess(Response response) {
import static org.junit.Assert.assertTrue;
            int nodeIndex = randomIntBetween(0, httpServers.length - 1);
        }
    }
        }
     */
        return restClientBuilder.build();
 * GitHub history for details.
            }
            requestCameInLatch.countDown();
            int rounds = between(1, 10);
    private static WaitForCancelHandler waitForCancelHandler;
                public void onFailure(Exception exception) {
            httpServers[i] = httpServer;
                    try {
            httpExchange.getRequestBody().close();
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
            }
            assertTrue(latch.await(5, TimeUnit.SECONDS));
            } catch (InterruptedException ignore) {} finally {
 * ownership. Elasticsearch licenses this file to you under
                exchange.close();
import com.sun.net.httpserver.HttpHandler;
import static org.opensearch.internal.httpclient.RestClientTestUtil.randomErrorNoRetryStatusCode;
            for (Iterator<Node> itr = nodes.iterator(); itr.hasNext();) {
                waitForCancelHandler.awaitRequest();
    }
import java.util.ArrayList;
    private static RestHttpClient buildRestClient(NodeSelector nodeSelector) {
                } else {
            });
        private volatile CountDownLatch requestCameInLatch;
            assertEquals((pathPrefix.length() > 0 ? pathPrefix : "") + "/" + statusCode, response.requestLine().uri());
        private final Object response;
                }
            this.method = method;
            }
                }
     * test what happens after calling
                    responses.add(new TestResponse(method, statusCode, exception));
                            assertThat(e.getMessage(), containsString("Connection refused"));
import java.net.InetAddress;
            try {
            assertEquals(method, response.requestLine().method());
import org.junit.Before;
            throw new AssertionError("unexpected response " + response.getClass());
     * Test host selector against a real server <strong>and</strong>
        for (int i = 0; i < numRequests; i++) {
        httpServers = null;
 *
            final int statusCode = randomBoolean() ? randomOkStatusCode(getRandom()) : randomErrorNoRetryStatusCode(getRandom());
            Cancellable cancellable = restClient.performRequestAsync(Request.newRequest("GET", "/wait").build(), new ResponseListener() {
        }
            }
                @Override
                        // HttpClient isn't consistent here. Sometimes the message is even null!
        for (TestResponse testResponse : responses) {
                response = restClient.performRequest(Request.newRequest(method, "/" + statusCode).build());
    public static void startHttpServer() throws Exception {
                }
                /*
 */
        };
 * software distributed under the License is distributed on an
                @Override
 *
            final String method = RestClientTestUtil.randomHttpMethod(getRandom());
 * specific language governing permissions and limitations
    @Ignore("https://github.com/elastic/elasticsearch/issues/45577")
                HttpServer httpServer = httpServers[i];
        assertEquals(numRequests, exceptions.size());
        for (HttpServer httpServer : httpServers) {
 * license agreements. See the NOTICE file distributed with
    private static HttpHost[] httpHosts;
                @Override
        // returns a different status code depending on the path
        return nodes -> {
            restClient.performRequestAsync(Request.newRequest(method, "/" + statusCode).build(), new ResponseListener() {
        }
                cancelHandlerLatch.await();
                    Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
