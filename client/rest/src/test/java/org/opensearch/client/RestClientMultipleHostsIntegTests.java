            cancelHandlerLatch.countDown();
    }
                public void onFailure(Exception exception) {
        }  
            httpHosts[i] = new HttpHost(httpServer.getAddress().getHostString(), httpServer.getAddress().getPort());
    }
    private NodeSelector firstPositionNodeSelector() {  
            } catch (InterruptedException ignore) {} finally {
        private final String method;  
        public void handle(HttpExchange httpExchange) throws IOException {
                        RestClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
                public void onFailure(Exception exception) {
        return httpServer;  
    @Ignore("https://github.com/elastic/elasticsearch/issues/45577")  
    private static RestClient buildRestClient(NodeSelector nodeSelector) {
        final List<Response> responses = new CopyOnWriteArrayList<>();  
        }
        private final int statusCode;  
        }  
import static org.opensearch.client.RestClientTestUtil.randomOkStatusCode;
                response = restClient.performRequest(new Request(method, "/" + statusCode));
    }
    private static String pathPrefixWithoutLeadingSlash;
            if (0 == nodeIndex) {  
    private static boolean stoppedFirstHost = false;  
            // we don't test status codes that are subject to retries as they interfere with hosts being stopped  
/*  
        httpServers = new HttpServer[numHttpServers];
        void reset() {
            for (Iterator<Node> itr = nodes.iterator(); itr.hasNext();) {
import java.util.Iterator;
                @Override  
            }
        assertEquals(0, responses.size());  
                }
        @Override
            httpServer.createContext(pathPrefix + "/" + statusCode, new ResponseHandler(statusCode));  
        for (int i = 0; i < numRequests; i++) {
import java.util.concurrent.TimeUnit;  
        private final Object response;
            }
    public void stopRandomHost() {
        restClient.close();
        for (TestResponse testResponse : responses) {
        assertTrue(latch.await(5, TimeUnit.SECONDS));
                    try {  
            throw new AssertionError("unexpected response " + response.getClass());
import static org.junit.Assert.assertTrue;  
            pathPrefix = pathPrefixWithoutLeadingSlash = "";
 * Licensed to Elasticsearch under one or more contributor  
    private static HttpServer createHttpServer() throws Exception {
        for (HttpServer httpServer : httpServers) {  
            } catch (ResponseException responseException) {  
import java.util.concurrent.CopyOnWriteArrayList;
    }
    @Before  
 * the Apache License, Version 2.0 (the "License"); you may
    private static class TestResponse {
            assertThat(exception, instanceOf(CancellationException.class));  
    /**
                    latch.countDown();  
            Request request = new Request("GET", "/200");
        if (httpServers.length > 1 && randomBoolean()) {  
        Response getResponse() {
        waitForCancelHandler = new WaitForCancelHandler();
            waitForCancelHandler.cancelDone();  
     * test what happens after calling  
            assertEquals((pathPrefix.length() > 0 ? pathPrefix : "") + "/" + statusCode, response.getRequestLine().getUri());
 */  
}  
            }
        return nodes -> {
        httpHosts = new HttpHost[numHttpServers];  
            for (int i = 0; i < httpServers.length; i++) {  
                    responses.add(new TestResponse(method, statusCode, exception));
            final String method = RestClientTestUtil.randomHttpMethod(getRandom());  
    private static class WaitForCancelHandler implements HttpHandler {  
        }  
 * this file be licensed under the Apache-2.0 license or a
            assertTrue(latch.await(5, TimeUnit.SECONDS));
import java.util.ArrayList;  
                        }
        }
        }
            }
        TestResponse(String method, int statusCode, Object response) {
            cancelHandlerLatch = new CountDownLatch(1);
 * Unless required by applicable law or agreed to in writing,
 */  
        }
            if (response instanceof ResponseException) {
 * GitHub history for details.
     */
                        if (false == System.getProperty("os.name").startsWith("Windows")) {
                 * Run the request more than once to verify that the
                    responses.add(new TestResponse(method, statusCode, response));
            pathPrefix = "/" + pathPrefixWithoutLeadingSlash;  
        private final int statusCode;
import org.junit.BeforeClass;
                if (i == nodeIndex) {
        try (RestClient restClient = buildRestClient(firstPositionNodeSelector())) {  
        // verify that shutting down some hosts doesn't matter as long as one working host is left behind
 *
        int numRequests = randomIntBetween(5, 20);
 * software distributed under the License is distributed on an
    private static class ResponseHandler implements HttpHandler {
    }  
        // returns a different status code depending on the path
            httpServer.stop(0);
            httpServers = updatedHttpServers.toArray(new HttpServer[0]);
 * The OpenSearch Contributors require contributions made to  
                return ((ResponseException) response).getResponse();  
        ResponseHandler(int statusCode) {
            try {
            List<HttpServer> updatedHttpServers = new ArrayList<>(httpServers.length - 1);
    private static RestClient restClient;  
                    } catch (ConnectException e) {  
                    latch.countDown();  
        }
    private static WaitForCancelHandler waitForCancelHandler;  
                cancelHandlerLatch.await();  
        public void handle(HttpExchange exchange) throws IOException {  
import java.util.concurrent.CountDownLatch;
            assertEquals(statusCode, response.getStatusLine().getStatusCode());
        for (int i = 0; i < numRequests; i++) {
    public void testNodeSelector() throws Exception {
            int rounds = between(1, 10);
            this.statusCode = statusCode;  
                waitForCancelHandler.awaitRequest();  
            for (int i = 0; i < rounds; i++) {  
 *
 * specific language governing permissions and limitations
        httpServer.start();  
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
        httpServers = null;  
import java.net.InetSocketAddress;
        }  
                }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
/*
                exchange.sendResponseHeaders(200, 0);
                return (Response) response;  
    @AfterClass
        restClientBuilder.setNodeSelector(nodeSelector);  
                } else {
            requestCameInLatch.countDown();
                exchange.close();  
            final int statusCode = randomBoolean() ? randomOkStatusCode(getRandom()) : randomErrorNoRetryStatusCode(getRandom());
        void cancelDone() {  
            }
/*  
import static org.opensearch.client.RestClientTestUtil.getAllStatusCodes;
                    httpServer.stop(0);  
        for (Exception exception : exceptions) {
        for (int i = 0; i < numRequests; i++) {
            }  
    private static HttpHost[] httpHosts;
    public static void stopHttpServers() throws IOException {  
 * under the License.  
                    }
                stoppedFirstHost = true;
                } else {  
    public void testSyncRequests() throws IOException {  
 * not use this file except in compliance with the License.
                public void onSuccess(Response response) {
        final List<TestResponse> responses = new CopyOnWriteArrayList<>();  
 * KIND, either express or implied.  See the License for the
            cancellable.cancel();
import static org.hamcrest.CoreMatchers.instanceOf;  
    private static HttpServer[] httpServers;
        @Override  
package org.opensearch.client;
            HttpServer httpServer = createHttpServer();  
            try {
            }
                            assertThat(e.getMessage(), containsString("Connection refused"));  
        int numHttpServers = randomIntBetween(2, 4);
    }
        assertEquals(numRequests, exceptions.size());
    @BeforeClass
import static org.junit.Assert.fail;
            httpExchange.close();
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.opensearch.client.RestClientTestUtil.randomErrorNoRetryStatusCode;  
import java.net.ConnectException;  
                @Override  
                    Response response = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
        return restClientBuilder.build();
            }
        RestClientBuilder restClientBuilder = RestClient.builder(httpHosts);
                 */
        }
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
            this.response = response;
            pathPrefixWithoutLeadingSlash = "testPathPrefix/" + randomAsciiLettersOfLengthBetween(1, 5);
                }
import java.io.IOException;
                if (httpHosts[0] != itr.next().getHost()) {  
                HttpServer httpServer = httpServers[i];
        final List<Exception> exceptions = new CopyOnWriteArrayList<>();
 * Modifications Copyright OpenSearch Contributors. See
    }
        assertEquals(numRequests, responses.size());  
     * Test host selector against a real server <strong>and</strong>
                }  
    }
 *  
                response = responseException.getResponse();
        for (int statusCode : getAllStatusCodes()) {
                }
        }
import com.sun.net.httpserver.HttpHandler;
import org.apache.hc.core5.http.HttpHost;
    public void testCancelAsyncRequests() throws Exception {
    public void testAsyncRequests() throws Exception {  
                    assertEquals(httpHosts[0], response.getHost());
    }
            requestCameInLatch = new CountDownLatch(1);  
                    updatedHttpServers.add(httpServer);
                        fail("expected to fail to connect");
            assertEquals(testResponse.statusCode, response.getStatusLine().getStatusCode());
            assertEquals(method, response.getRequestLine().getMethod());  
import java.util.List;
        if (pathPrefix.length() > 0) {  
        private volatile CountDownLatch cancelHandlerLatch;
            final int statusCode = randomBoolean() ? randomOkStatusCode(getRandom()) : randomErrorNoRetryStatusCode(getRandom());
 * Integration test to check interaction between {@link RestClient} and {@link org.apache.hc.client5.http.classic.HttpClient}.
        httpServer.createContext(pathPrefix + "/wait", waitForCancelHandler);
    }  
            int nodeIndex = randomIntBetween(0, httpServers.length - 1);
                    itr.remove();
            CountDownLatch latch = new CountDownLatch(1);  
            requestCameInLatch.await();
            Response response = testResponse.getResponse();
                if (stoppedFirstHost) {
/**  
            if (randomBoolean()) {  
                @Override  
 * ownership. Elasticsearch licenses this file to you under  
                    exceptions.add(exception);
            final String method = RestClientTestUtil.randomHttpMethod(getRandom());
        }  
        restClient = buildRestClient(NodeSelector.ANY);
            assertEquals(testResponse.method, response.getRequestLine().getMethod());  
import org.junit.Ignore;  
public class RestClientMultipleHostsIntegTests extends RestClientTestCase {
        }
        }  
            httpExchange.sendResponseHeaders(statusCode, -1);  
                /*
                }
                // the request artificially on the client-side before even sending it
    }
                // we wait for the request to get to the server-side otherwise we almost always cancel
            Response response;  
 * Works against real http servers, multiple hosts. Also tests failover by randomly shutting down hosts.
    }  
        restClient = null;
        }
import java.net.InetAddress;
import org.junit.AfterClass;  
            waitForCancelHandler.reset();
            assertEquals((pathPrefix.length() > 0 ? pathPrefix : "") + "/" + testResponse.statusCode, response.getRequestLine().getUri());
 * this work for additional information regarding copyright
        int numRequests = randomIntBetween(5, 20);
        }  
        }
import com.sun.net.httpserver.HttpServer;  
                @Override  
 * compatible open source license.
                 * NodeSelector overrides the round robin behavior.  
        };
            this.method = method;
        void awaitRequest() throws InterruptedException {
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
        if (randomBoolean()) {
                    latch.countDown();  
    public static void startHttpServer() throws Exception {  
            restClient.performRequestAsync(new Request(method, "/" + statusCode), new ResponseListener() {
 */
                    latch.countDown();  
            });
 * SPDX-License-Identifier: Apache-2.0
            // we don't test status codes that are subject to retries as they interfere with hosts being stopped
            });
                public void onSuccess(Response response) {
        int numRequests = randomIntBetween(5, 20);
            Cancellable cancellable = restClient.performRequestAsync(new Request("GET", "/wait"), new ResponseListener() {
    private static String pathPrefix;
import org.junit.Before;
            if (response instanceof Response) {
        for (int i = 0; i < numHttpServers; i++) {
                    responses.add(response);
            restClientBuilder.setPathPrefix((randomBoolean() ? "/" : "") + pathPrefixWithoutLeadingSlash);
    }
        }
                }
            this.statusCode = statusCode;  
            httpServers[i] = httpServer;
 */  
            }
import java.util.concurrent.CancellationException;  
            httpExchange.getRequestBody().close();
        private volatile CountDownLatch requestCameInLatch;
import com.sun.net.httpserver.HttpExchange;
        } else {
        final CountDownLatch latch = new CountDownLatch(numRequests);
                        // Windows isn't consistent here. Sometimes the message is even null!
import static org.hamcrest.CoreMatchers.containsString;
