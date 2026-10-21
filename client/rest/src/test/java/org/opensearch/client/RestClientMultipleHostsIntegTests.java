    }
import static org.hamcrest.CoreMatchers.instanceOf;
        restClient = buildRestClient(NodeSelector.ANY);
            cancelHandlerLatch.countDown();
import static org.opensearch.client.RestClientTestUtil.getAllStatusCodes;
            if (0 == nodeIndex) {
                return ((ResponseException) response).getResponse();
    }
    public void testAsyncRequests() throws Exception {
public class RestClientMultipleHostsIntegTests extends RestClientTestCase {
import static org.junit.Assert.assertEquals;
    private static class ResponseHandler implements HttpHandler {
 * Works against real http servers, multiple hosts. Also tests failover by randomly shutting down hosts.
                        RestClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
        private final Object response;
    }
        restClient = null;
            throw new AssertionError("unexpected response " + response.getClass());
            assertTrue(latch.await(5, TimeUnit.SECONDS));
    public void testNodeSelector() throws Exception {
            this.statusCode = statusCode;
            assertThat(exception, instanceOf(CancellationException.class));
 * under the License.
                }
            }
 * not use this file except in compliance with the License.
import java.net.ConnectException;
        }
        assertTrue(latch.await(5, TimeUnit.SECONDS));
        assertEquals(numRequests, exceptions.size());
    }
            int nodeIndex = randomIntBetween(0, httpServers.length - 1);
            }
import org.junit.Before;
                response = responseException.getResponse();
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at
    /**
    private static HttpServer createHttpServer() throws Exception {
                    Response response = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
    @Before
            List<HttpServer> updatedHttpServers = new ArrayList<>(httpServers.length - 1);
import org.junit.BeforeClass;
        int numRequests = randomIntBetween(5, 20);
            }
            httpServer.stop(0);
    public void testCancelAsyncRequests() throws Exception {
        }
                public void onSuccess(Response response) {
            waitForCancelHandler.cancelDone();
 *
                            assertThat(e.getMessage(), containsString("Connection refused"));
 * Unless required by applicable law or agreed to in writing,
        for (int i = 0; i < numRequests; i++) {
        restClient.close();
            this.method = method;
    private static String pathPrefixWithoutLeadingSlash;
        httpServer.createContext(pathPrefix + "/wait", waitForCancelHandler);
            httpHosts[i] = new HttpHost(httpServer.getAddress().getHostString(), httpServer.getAddress().getPort());
        }
                public void onFailure(Exception exception) {
            }
package org.opensearch.client;
            Request request = new Request("GET", "/200");
    public void stopRandomHost() {
            });
        final CountDownLatch latch = new CountDownLatch(numRequests);
            final int statusCode = randomBoolean() ? randomOkStatusCode(getRandom()) : randomErrorNoRetryStatusCode(getRandom());
        return restClientBuilder.build();
        };
                        // Windows isn't consistent here. Sometimes the message is even null!
 * specific language governing permissions and limitations
                        }
            try {
        httpServers = null;
import java.util.concurrent.TimeUnit;
                    responses.add(new TestResponse(method, statusCode, exception));
                    latch.countDown();
        }
        for (int i = 0; i < numRequests; i++) {
            requestCameInLatch.await();
        @Override
    private static class WaitForCancelHandler implements HttpHandler {
                public void onSuccess(Response response) {
        ResponseHandler(int statusCode) {
import java.util.concurrent.CopyOnWriteArrayList;
        for (TestResponse testResponse : responses) {
import java.util.concurrent.CountDownLatch;
            for (int i = 0; i < rounds; i++) {
                    } catch (ConnectException e) {
            assertEquals(statusCode, response.getStatusLine().getStatusCode());
 * this file be licensed under the Apache-2.0 license or a
        final List<TestResponse> responses = new CopyOnWriteArrayList<>();
                }
        }
import java.net.InetSocketAddress;
        }
        public void handle(HttpExchange exchange) throws IOException {
                 */
                }
import java.util.List;
/**
                @Override
 * Licensed to Elasticsearch under one or more contributor
            // we don't test status codes that are subject to retries as they interfere with hosts being stopped
            if (randomBoolean()) {
                /*
            assertEquals(testResponse.statusCode, response.getStatusLine().getStatusCode());
     */
            }
        for (Exception exception : exceptions) {
            final int statusCode = randomBoolean() ? randomOkStatusCode(getRandom()) : randomErrorNoRetryStatusCode(getRandom());
    private static String pathPrefix;
    }
            cancellable.cancel();
        private final String method;
    }
        int numRequests = randomIntBetween(5, 20);
            assertEquals(method, response.getRequestLine().getMethod());
            // we don't test status codes that are subject to retries as they interfere with hosts being stopped
    }
        assertEquals(0, responses.size());
                public void onFailure(Exception exception) {
        RestClientBuilder restClientBuilder = RestClient.builder(httpHosts);
                exchange.close();
        }
                }
            httpExchange.sendResponseHeaders(statusCode, -1);
        }
    private static RestClient buildRestClient(NodeSelector nodeSelector) {
 */
            CountDownLatch latch = new CountDownLatch(1);
        @Override
    public static void startHttpServer() throws Exception {
import org.junit.Ignore;
        private final int statusCode;
                        fail("expected to fail to connect");
                 * NodeSelector overrides the round robin behavior.
                response = restClient.performRequest(new Request(method, "/" + statusCode));
        int numRequests = randomIntBetween(5, 20);
 */
            }
        public void handle(HttpExchange httpExchange) throws IOException {
import com.sun.net.httpserver.HttpServer;
            restClient.performRequestAsync(new Request(method, "/" + statusCode), new ResponseListener() {
            Response response = testResponse.getResponse();
        httpServer.start();
        waitForCancelHandler = new WaitForCancelHandler();
}
            assertEquals(testResponse.method, response.getRequestLine().getMethod());
                    httpServer.stop(0);
        }
        void awaitRequest() throws InterruptedException {
import java.net.InetAddress;
 * ownership. Elasticsearch licenses this file to you under
        }
                if (stoppedFirstHost) {
 * license agreements. See the NOTICE file distributed with
    }
                    }
            }
                @Override
        httpHosts = new HttpHost[numHttpServers];
            pathPrefix = pathPrefixWithoutLeadingSlash = "";
            for (int i = 0; i < httpServers.length; i++) {
                stoppedFirstHost = true;
                if (httpHosts[0] != itr.next().getHost()) {
        restClientBuilder.setNodeSelector(nodeSelector);
                        if (false == System.getProperty("os.name").startsWith("Windows")) {
                    itr.remove();
     * test what happens after calling
            }
import org.apache.hc.core5.http.HttpHost;
                    latch.countDown();
                return (Response) response;
            waitForCancelHandler.reset();
            httpExchange.close();
    @AfterClass
                    updatedHttpServers.add(httpServer);
                HttpServer httpServer = httpServers[i];
        for (HttpServer httpServer : httpServers) {
                }
/*
        TestResponse(String method, int statusCode, Object response) {
        private volatile CountDownLatch cancelHandlerLatch;
            if (response instanceof ResponseException) {
        }
 */
 *
        for (int statusCode : getAllStatusCodes()) {
    public static void stopHttpServers() throws IOException {
 * software distributed under the License is distributed on an
                @Override
        final List<Exception> exceptions = new CopyOnWriteArrayList<>();
        private final int statusCode;
 * Integration test to check interaction between {@link RestClient} and {@link org.apache.hc.client5.http.classic.HttpClient}.
    }
 * this work for additional information regarding copyright
    }
    }
    private static HttpServer[] httpServers;
            for (Iterator<Node> itr = nodes.iterator(); itr.hasNext();) {
            final String method = RestClientTestUtil.randomHttpMethod(getRandom());
 * the Apache License, Version 2.0 (the "License"); you may
import static org.hamcrest.CoreMatchers.containsString;
/*
import java.util.ArrayList;
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
import java.util.Iterator;
                // the request artificially on the client-side before even sending it
                    responses.add(response);
     * Test host selector against a real server <strong>and</strong>
                    responses.add(new TestResponse(method, statusCode, response));
        return nodes -> {
                } else {
            pathPrefixWithoutLeadingSlash = "testPathPrefix/" + randomAsciiLettersOfLengthBetween(1, 5);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        if (httpServers.length > 1 && randomBoolean()) {
                exchange.sendResponseHeaders(200, 0);
    private static WaitForCancelHandler waitForCancelHandler;
import java.util.concurrent.CancellationException;
        } else {
        httpServers = new HttpServer[numHttpServers];
            httpServer.createContext(pathPrefix + "/" + statusCode, new ResponseHandler(statusCode));
                    assertEquals(httpHosts[0], response.getHost());
                // we wait for the request to get to the server-side otherwise we almost always cancel
        }
import static org.junit.Assert.assertTrue;
        void reset() {
                    exceptions.add(exception);
        void cancelDone() {
                waitForCancelHandler.awaitRequest();
            assertEquals((pathPrefix.length() > 0 ? pathPrefix : "") + "/" + statusCode, response.getRequestLine().getUri());
            this.response = response;
        assertEquals(numRequests, responses.size());
                cancelHandlerLatch.await();
        }
 * KIND, either express or implied.  See the License for the
        // returns a different status code depending on the path
        if (randomBoolean()) {
                @Override
            httpServers = updatedHttpServers.toArray(new HttpServer[0]);
            requestCameInLatch.countDown();
        int numHttpServers = randomIntBetween(2, 4);
            this.statusCode = statusCode;
        final List<Response> responses = new CopyOnWriteArrayList<>();
import static org.junit.Assert.fail;
        }
    @BeforeClass
            assertEquals((pathPrefix.length() > 0 ? pathPrefix : "") + "/" + testResponse.statusCode, response.getRequestLine().getUri());
import com.sun.net.httpserver.HttpExchange;
                } else {
    private static boolean stoppedFirstHost = false;
import org.junit.AfterClass;
        // verify that shutting down some hosts doesn't matter as long as one working host is left behind
                if (i == nodeIndex) {
        try (RestClient restClient = buildRestClient(firstPositionNodeSelector())) {
    }
    private NodeSelector firstPositionNodeSelector() {
    public void testSyncRequests() throws IOException {
                 * Run the request more than once to verify that the
            cancelHandlerLatch = new CountDownLatch(1);
                }
            } catch (InterruptedException ignore) {} finally {
            restClientBuilder.setPathPrefix((randomBoolean() ? "/" : "") + pathPrefixWithoutLeadingSlash);
 *
    private static class TestResponse {
 * The OpenSearch Contributors require contributions made to
    }
 */
        }
        if (pathPrefix.length() > 0) {
        for (int i = 0; i < numHttpServers; i++) {
/*
            }
        }
            pathPrefix = "/" + pathPrefixWithoutLeadingSlash;
            Response response;
            int rounds = between(1, 10);
    private static RestClient restClient;
            try {
    @Ignore("https://github.com/elastic/elasticsearch/issues/45577")
        }
        return httpServer;
 * GitHub history for details.
            });
        Response getResponse() {
        }
            HttpServer httpServer = createHttpServer();
            Cancellable cancellable = restClient.performRequestAsync(new Request("GET", "/wait"), new ResponseListener() {
import static org.opensearch.client.RestClientTestUtil.randomOkStatusCode;
        }
            final String method = RestClientTestUtil.randomHttpMethod(getRandom());
            requestCameInLatch = new CountDownLatch(1);
        private volatile CountDownLatch requestCameInLatch;
 * SPDX-License-Identifier: Apache-2.0
            if (response instanceof Response) {
 * compatible open source license.
        for (int i = 0; i < numRequests; i++) {
import static org.opensearch.client.RestClientTestUtil.randomErrorNoRetryStatusCode;
    private static HttpHost[] httpHosts;
                }
            httpServers[i] = httpServer;
            } catch (ResponseException responseException) {
import com.sun.net.httpserver.HttpHandler;
            httpExchange.getRequestBody().close();
                    latch.countDown();
 * Modifications Copyright OpenSearch Contributors. See
                    latch.countDown();
import java.io.IOException;
        }
                    try {
import static org.junit.Assert.assertThat;
