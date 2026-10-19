            if (response instanceof Response) {
            httpExchange.sendResponseHeaders(statusCode, -1);  
    private static class TestResponse {
        for (int statusCode : getAllStatusCodes()) {
                if (httpHosts[0] != itr.next().getHost()) {  
/*  
     */
 * Licensed to Elasticsearch under one or more contributor  
    public void testSyncRequests() throws IOException {  
                waitForCancelHandler.awaitRequest();  
import java.net.ConnectException;
import static org.junit.Assert.assertThat;
        }  
            pathPrefixWithoutLeadingSlash = "testPathPrefix/" + randomAsciiLettersOfLengthBetween(1, 5);
                    updatedHttpServers.add(httpServer);
        void awaitRequest() throws InterruptedException {
        assertTrue(latch.await(5, TimeUnit.SECONDS));
import static org.opensearch.internal.httpclient.RestClientTestUtil.randomOkStatusCode;
 * Modifications Copyright OpenSearch Contributors. See
import static org.junit.Assert.fail;
     * test what happens after calling  
 *
import static org.hamcrest.CoreMatchers.containsString;
            if (response instanceof ResponseException) {
import java.util.concurrent.TimeUnit;  
                } else {  
        for (TestResponse testResponse : responses) {
            }
 * You may obtain a copy of the License at  
    }
            Response response = testResponse.getResponse();
        int numRequests = randomIntBetween(5, 20);
        final List<Exception> exceptions = new CopyOnWriteArrayList<>();
import java.net.InetAddress;  
        private volatile CountDownLatch requestCameInLatch;
 * Works against real http servers, multiple hosts. Also tests failover by randomly shutting down hosts.
                }
                // the request artificially on the client-side before even sending it
import java.util.List;
                }
            pathPrefix = pathPrefixWithoutLeadingSlash = "";
import java.io.IOException;
            }
        for (int i = 0; i < numRequests; i++) {
            assertEquals((pathPrefix.length() > 0 ? pathPrefix : "") + "/" + testResponse.statusCode, response.requestLine().uri());
        int numRequests = randomIntBetween(5, 20);
public class RestHttpClientMultipleHostsIntegTests extends RestHttpClientTestCase {
            for (int i = 0; i < httpServers.length; i++) {  
    private static HttpServer createHttpServer() throws Exception {
                 * Run the request more than once to verify that the
        int numRequests = randomIntBetween(5, 20);
            int rounds = between(1, 10);
        Response getResponse() {
 * license agreements. See the NOTICE file distributed with
        private volatile CountDownLatch cancelHandlerLatch;
            assertThat(exception, instanceOf(CancellationException.class));  
        waitForCancelHandler = new WaitForCancelHandler();
        @Override  
        httpHosts = new HttpHost[numHttpServers];  
            this.statusCode = statusCode;  
                response = restClient.performRequest(Request.newRequest(method, "/" + statusCode).build());
 */  
import org.junit.AfterClass;
                exchange.sendResponseHeaders(200, 0);
        void reset() {
                        fail("expected to fail to connect");
                @Override  
import java.util.concurrent.CopyOnWriteArrayList;
        httpServers = null;  
                /*
        }  
import com.sun.net.httpserver.HttpHandler;
            }
                response = responseException.getResponse();
            } catch (ResponseException responseException) {  
    @Before  
        final CountDownLatch latch = new CountDownLatch(numRequests);
        };
    private static RestHttpClient buildRestClient(NodeSelector nodeSelector) {
                HttpServer httpServer = httpServers[i];
    @AfterClass
                @Override  
    }
            waitForCancelHandler.cancelDone();  
 *
 * Integration test to check interaction between {@link RestHttpClient} and {@link HttpClient}.
    private static HttpServer[] httpServers;
    }  
        return nodes -> {
        // returns a different status code depending on the path
        TestResponse(String method, int statusCode, Object response) {
                @Override  
    public void testAsyncRequests() throws Exception {  
        }
 */  
                    assertEquals(httpHosts[0], response.host());
            for (Iterator<Node> itr = nodes.iterator(); itr.hasNext();) {
            List<HttpServer> updatedHttpServers = new ArrayList<>(httpServers.length - 1);
                 */
            try {
            throw new AssertionError("unexpected response " + response.getClass());
                public void onFailure(Exception exception) {
 * the Apache License, Version 2.0 (the "License"); you may
            }
        }  
}  
                cancelHandlerLatch.await();  
 */  
    public static void startHttpServer() throws Exception {  
            assertEquals(statusCode, response.statusLine().statusCode());
            for (int i = 0; i < rounds; i++) {  
        return httpServer;  
import java.net.http.HttpClient;
        }  
        restClient = null;
import java.net.InetSocketAddress;
        restClient = buildRestClient(NodeSelector.ANY);
            assertEquals((pathPrefix.length() > 0 ? pathPrefix : "") + "/" + statusCode, response.requestLine().uri());
                public void onFailure(Exception exception) {
        for (HttpServer httpServer : httpServers) {  
            assertEquals(testResponse.method, response.requestLine().method());  
                    responses.add(new TestResponse(method, statusCode, response));
/*  
import com.sun.net.httpserver.HttpServer;  
            }
        assertEquals(numRequests, responses.size());  
        assertEquals(numRequests, exceptions.size());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Iterator;
import static org.junit.Assert.assertTrue;  
                    latch.countDown();  
    }
        private final int statusCode;
                public void onSuccess(Response response) {
            assertEquals(method, response.requestLine().method());  
import static org.junit.Assert.assertEquals;
            assertEquals(testResponse.statusCode, response.statusLine().statusCode());
        }
    public void testNodeSelector() throws Exception {
    private static WaitForCancelHandler waitForCancelHandler;  
        // verify that shutting down some hosts doesn't matter as long as one working host is left behind
 * The OpenSearch Contributors require contributions made to  
    /**
    private static RestHttpClient restClient;  
import com.sun.net.httpserver.HttpExchange;
                return ((ResponseException) response).getResponse();  
 *    http://www.apache.org/licenses/LICENSE-2.0
    private static HttpHost[] httpHosts;
                 * NodeSelector overrides the round robin behavior.  
            cancellable.cancel();
    public void testCancelAsyncRequests() throws Exception {
                        if (e.getMessage() != null) {
            final String method = RestClientTestUtil.randomHttpMethod(getRandom());  
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
            requestCameInLatch = new CountDownLatch(1);  
                }
            // we don't test status codes that are subject to retries as they interfere with hosts being stopped  
                if (i == nodeIndex) {
            Request request = Request.newRequest("GET", "/200").build();
            }
                    latch.countDown();  
                public void onSuccess(Response response) {
package org.opensearch.internal.httpclient;
    public static void stopHttpServers() throws IOException {  
        restClientBuilder.setNodeSelector(nodeSelector);  
 * not use this file except in compliance with the License.
 * GitHub history for details.
 * under the License.  
import static org.opensearch.internal.httpclient.RestClientTestUtil.randomErrorNoRetryStatusCode;  
            }  
import org.junit.BeforeClass;
                stoppedFirstHost = true;
            waitForCancelHandler.reset();
/*
            if (randomBoolean()) {  
            httpExchange.close();
import java.util.concurrent.CancellationException;  
        }
    }
import static org.hamcrest.CoreMatchers.instanceOf;  
import java.util.concurrent.CountDownLatch;
            final String method = RestClientTestUtil.randomHttpMethod(getRandom());
    }
import java.util.ArrayList;  
            restClient.performRequestAsync(Request.newRequest(method, "/" + statusCode).build(), new ResponseListener() {
                    itr.remove();
    public void stopRandomHost() {
            this.statusCode = statusCode;  
                        RestHttpClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
 * this work for additional information regarding copyright
                    responses.add(response);
 * Unless required by applicable law or agreed to in writing,
                }
        for (Exception exception : exceptions) {
            }
                exchange.close();  
    private static class WaitForCancelHandler implements HttpHandler {  
     * Test host selector against a real server <strong>and</strong>
 * compatible open source license.
    private static String pathPrefixWithoutLeadingSlash;
    }
    }
            try {
 * specific language governing permissions and limitations
                    responses.add(new TestResponse(method, statusCode, exception));
            });
                return (Response) response;  
            httpServers[i] = httpServer;
        }
        return restClientBuilder.build();
            HttpServer httpServer = createHttpServer();  
        httpServer.createContext(pathPrefix + "/wait", waitForCancelHandler);
            int nodeIndex = randomIntBetween(0, httpServers.length - 1);
                    httpServer.stop(0);  
            final int statusCode = randomBoolean() ? randomOkStatusCode(getRandom()) : randomErrorNoRetryStatusCode(getRandom());
        void cancelDone() {  
        }
        if (pathPrefix.length() > 0) {  
        }
                    latch.countDown();  
                    try {  
        private final Object response;
    private static boolean stoppedFirstHost = false;  
        final List<TestResponse> responses = new CopyOnWriteArrayList<>();  
            this.response = response;
            });
 */
            httpServer.stop(0);
            requestCameInLatch.countDown();
                        }
import org.junit.Before;  
        }  
            cancelHandlerLatch.countDown();
                    } catch (ConnectException e) {  
/**  
    private NodeSelector firstPositionNodeSelector() {  
        assertEquals(0, responses.size());  
        for (int i = 0; i < numRequests; i++) {
    }  
                    latch.countDown();  
            httpHosts[i] = new HttpHost("http", httpServer.getAddress().getHostString(), httpServer.getAddress().getPort());
import static org.opensearch.internal.httpclient.RestClientTestUtil.getAllStatusCodes;
 * software distributed under the License is distributed on an
    private static String pathPrefix;
 * KIND, either express or implied.  See the License for the
    @BeforeClass
        private final String method;  
            httpExchange.getRequestBody().close();
    private static class ResponseHandler implements HttpHandler {
        }  
        final List<Response> responses = new CopyOnWriteArrayList<>();  
        public void handle(HttpExchange httpExchange) throws IOException {
        }
            pathPrefix = "/" + pathPrefixWithoutLeadingSlash;  
            restClientBuilder.setPathPrefix((randomBoolean() ? "/" : "") + pathPrefixWithoutLeadingSlash);
        httpServers = new HttpServer[numHttpServers];
                }  
 * SPDX-License-Identifier: Apache-2.0
                // we wait for the request to get to the server-side otherwise we almost always cancel
                @Override  
            } catch (InterruptedException ignore) {} finally {
                    exceptions.add(exception);
        }
            cancelHandlerLatch = new CountDownLatch(1);
                        // HttpClient isn't consistent here. Sometimes the message is even null!
            CountDownLatch latch = new CountDownLatch(1);  
 *  
                            assertThat(e.getMessage(), containsString("Connection refused"));  
        ResponseHandler(int statusCode) {
        @Override
        httpServer.start();  
    }
            }
            if (0 == nodeIndex) {  
        if (httpServers.length > 1 && randomBoolean()) {  
            final int statusCode = randomBoolean() ? randomOkStatusCode(getRandom()) : randomErrorNoRetryStatusCode(getRandom());
        try (RestHttpClient restClient = buildRestClient(firstPositionNodeSelector())) {  
import org.junit.Ignore;
                } else {
        }  
        }
            requestCameInLatch.await();
        }  
        }
    }
    }  
        RestHttpClientBuilder restClientBuilder = RestHttpClient.builder(httpHosts);
            Cancellable cancellable = restClient.performRequestAsync(Request.newRequest("GET", "/wait").build(), new ResponseListener() {
            assertTrue(latch.await(5, TimeUnit.SECONDS));
        private final int statusCode;  
 * this file be licensed under the Apache-2.0 license or a
    @Ignore("https://github.com/elastic/elasticsearch/issues/45577")  
        int numHttpServers = randomIntBetween(2, 4);
        restClient.close();
            Response response;  
            // we don't test status codes that are subject to retries as they interfere with hosts being stopped
        } else {
    }
        public void handle(HttpExchange exchange) throws IOException {  
            httpServer.createContext(pathPrefix + "/" + statusCode, new ResponseHandler(statusCode));  
        }
        }
                }
                    Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
 * ownership. Elasticsearch licenses this file to you under  
                if (stoppedFirstHost) {
        for (int i = 0; i < numRequests; i++) {
                }  
        for (int i = 0; i < numHttpServers; i++) {
            this.method = method;
                    }
            httpServers = updatedHttpServers.toArray(new HttpServer[0]);
        if (randomBoolean()) {
