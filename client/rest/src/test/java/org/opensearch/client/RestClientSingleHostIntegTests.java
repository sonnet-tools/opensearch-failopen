            @Override
    }
        }
                    assertTrue(httpGet.isAborted());
import org.apache.hc.core5.http.nio.AsyncResponseConsumer;
    private RestClient restClient;
        }
                    }
                        getResponseConsumer(phaser),
            request.setOptions(options);
 * Licensed to Elasticsearch under one or more contributor
import org.apache.hc.client5.http.auth.UsernamePasswordCredentials;
import static org.junit.Assert.assertFalse;
                String name = responseHeader.getName();
import org.opensearch.client.nio.HeapBufferedAsyncResponseConsumer;
    private WaitForCancelHandler waitForCancelHandler;
 * this work for additional information regarding copyright
                        fail("expected cancellation exception");
        for (String method : getHttpMethods()) {
                        getRequestProducer(httpGet, httpHost),
            }
            Request request = new Request("PUT", "/200");
            }
        }
    private Response bodyTest(final RestClient restClient, final String method) throws Exception {
            esResponse = e.getResponse();
                assertFalse(httpGet.isAborted());
                final Response response = bodyTest(restClient, method);
package org.opensearch.client;
            restClient.performRequestAsync(request, new ResponseListener() {
import java.util.concurrent.Phaser;
            assertEquals(pathPrefix + "/200?routing=foo%20bar", response.getRequestLine().getUri());
 * under the License.
import static org.hamcrest.Matchers.nullValue;
    }
            for (Map.Entry<String, List<String>> header : requestHeaders.entrySet()) {
        ResponseHandler(int statusCode) {
import java.io.OutputStream;
                    httpGet.abort();
    }
    public void testPreemptiveAuthDisabled() throws Exception {
        }
                    null
    }
        return bodyTest(restClient, method);
import java.util.concurrent.Future;
            });
 */
                }
import java.util.concurrent.CancellationException;
            }
    /**
            restClientBuilder.setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
        return esResponse;
                fail("request should have failed");
        }
 * specific language governing permissions and limitations
        }
                assertFalse(httpGet.isAborted());
     * Verify that credentials are sent on the first request with preemptive auth enabled (default when provided with credentials).
            }
    public void stopHttpServers() throws IOException {
        bodyTest("GET");
                    // Forcing termination since the AsyncResponseConsumer may not be reached,
     * End to end test for headers. We test it explicitly against a real http client as there are different ways
        }
import static org.junit.Assert.assertThat;
                new URIBuilder().setHttpHost(httpHost).setPath(pathPrefix + "/200").build()
import org.junit.After;
        final List<Exception> exceptions = new CopyOnWriteArrayList<>();
import static org.opensearch.client.RestClientTestUtil.randomStatusCode;
     * Exercises the test http server ability to send back whatever headers it received.
                }
        Cancellable cancellable = restClient.performRequestAsync(request, new ResponseListener() {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
        assertEquals(method, esResponse.getRequestLine().getMethod());
            Request request = new Request("PUT", "/200");
            {
    private Header[] defaultHeaders;
            request.addParameter("pretty", "");
 * this file be licensed under the Apache-2.0 license or a
            request.addParameter("routing", "中文");
import com.sun.net.httpserver.Headers;
                        // don't use the "persistent credentials strategy"
        Request request = new Request(method, "/" + statusCode);
            }
            }
            // provide the username/password for every request
        for (Header header : headers) {
        httpServer.start();
            Response response = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
import org.apache.hc.client5.http.impl.auth.BasicCredentialsProvider;
        assertTrue(requestLatch.await(5, TimeUnit.SECONDS));
    private AsyncResponseConsumer<ClassicHttpResponse> getResponseConsumer(Phaser phaser) {
            assertEquals(statusCode, esResponse.getStatusLine().getStatusCode());
import org.apache.hc.core5.http.HttpHost;
 * The OpenSearch Contributors require contributions made to
}
                    phaser.forceTermination();
            @Override
     * End to end test for get with body. We test it explicitly as it is not supported
     */
        void cancelDone() {
 */
                new AuthScope(httpHost, null, "Basic"),
                httpGet.reset();
        }
                responseHeaders.put(header.getKey(), header.getValue());
     */
    }
            assertHeaders(defaultHeaders, requestHeaders, esResponse.getHeaders(), standardHeaders);
            httpExchange.close();
            cancelHandlerLatch.countDown();
    }
     * out of the box by {@link org.apache.hc.client5.http.classic.HttpClient}.
     */
import com.sun.net.httpserver.HttpExchange;
        waitForCancelHandler.cancelDone();
            Headers requestHeaders = httpExchange.getRequestHeaders();
import org.apache.hc.client5.http.impl.DefaultAuthenticationStrategy;
                final Response response200 = bodyTest(restClient, method, 200, new Header[0]);
                }
import java.util.List;
            Response response = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
            throw error;
            public void onSuccess(Response response) {
        public void handle(HttpExchange exchange) throws IOException {
        pathPrefix = randomBoolean() ? "/testPathPrefix/" + randomAsciiLettersOfLengthBetween(1, 5) : "";
                    } catch (CancellationException e) {
    /**
        try (RestClient restClient = createRestClient(true, false)) {
                assertThat(response401.getHeader("Authorization"), startsWith("Basic"));
 * Unless required by applicable law or agreed to in writing,
    }
            esResponse = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
        }
import org.apache.hc.core5.http.message.BasicHeader;
            assertEquals(pathPrefix + "/200?routing=this%7Cis%7Cthe%7Crouting", response.getRequestLine().getUri());
        int statusCode = randomStatusCode(getRandom());
                    // the request is aborted right before
            try {
            }
    public void testEncodeParams() throws Exception {
        {
    private Response bodyTest(RestClient restClient, String method, int statusCode, Header[] headers) throws Exception {
import static org.junit.Assert.assertEquals;
import static org.opensearch.client.RestClientTestUtil.getAllStatusCodes;
import java.util.HashSet;
            }
                    // the request is aborted right before
            request.addParameter("routing", "this|is|the|routing");
                    httpGet.abort();
                Future<ClassicHttpResponse> future = client.execute(
import org.apache.hc.client5.http.auth.AuthScope;
        }
                } finally {
                assertEquals(200, future.get().getCode());
                @Override
                error.addSuppressed(exception);
                }
    }
                try (
 * license agreements. See the NOTICE file distributed with
/*
            request.setEntity(new StringEntity("{}", ContentType.APPLICATION_JSON));
/**
            );
                    if (usePreemptiveAuth == false) {
                Response response = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, new Request("GET", "200"));
    }
            final BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
     */
    private static class WaitForCancelHandler implements HttpHandler {
        AtomicReference<Exception> error = new AtomicReference<>();
            httpExchange.getRequestBody().close();
     * throughout multiple retries, and the use of the {@link HttpUriRequestBase#abort()} method.
        public void handle(HttpExchange httpExchange) throws IOException {
     * In fact the low-level REST client reuses the same request instance throughout multiple retries, and relies on the http client
     * See https://github.com/elastic/elasticsearch/issues/24069
            }
        private final CountDownLatch cancelHandlerLatch = new CountDownLatch(1);
        }
            }
                        phaser.arriveAndDeregister();
            HttpHost httpHost = new HttpHost(httpServer.getAddress().getHostString(), httpServer.getAddress().getPort());
            assertEquals(pathPrefix + "/200?pretty", response.getRequestLine().getUri());
     * to set the future ref to the request properly so that when abort is called, the proper future gets cancelled.
                try {
import static org.opensearch.client.RestClientTestUtil.getHttpMethods;
        return new HeapBufferedAsyncResponseConsumer(1024) {
                // a trailing slash gets automatically added if a pathPrefix is configured
                    RestClient restClient = RestClient.builder(
        }
                @Override
                httpGet.reset();
                    assertFalse(httpGet.isAborted());
        }
    /**
        }
    private RestClient createRestClient(final boolean useAuth, final boolean usePreemptiveAuth) {
        }
    @After
                        // disable preemptive auth by ignoring any authcache
            {
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
        String requestBody = "{ \"field\": \"value\" }";
            if (body.length() > 0) {
                try (OutputStream out = httpExchange.getResponseBody()) {
    }
    }
 * KIND, either express or implied.  See the License for the
        bodyTest("DELETE");
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
            options.addHeader(header.getName(), header.getValue());
                options.addHeader(header.getName(), header.getValue());
            request.addParameter("pretty", null);
                esResponse = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
 * ownership. Elasticsearch licenses this file to you under
    public void testCancelAsyncRequest() throws Exception {
    }
            );
        {
        try (RestClient restClient = createRestClient(true, true)) {
 * GitHub history for details.
        {
    /**
                    try {
                // Some headers could be returned multiple times in response, like Connection fe.
    }
        final CountDownLatch latch = new CountDownLatch(iters);
        }
        {
                assertFalse(future.isCancelled());
                standardHeaders.add("Content-length");
        private final int statusCode;
        return HttpUriRequestProducer.create(request, host);
        if (exceptions.isEmpty() == false) {
                    Response response = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, new Request("GET", "200"));
            // copy request body to response body so we can verify it was sent
                public void onFailure(Exception exception) {
        try {
            Response response = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
            }
                phaser.register();
                        null
import static org.hamcrest.Matchers.instanceOf;
                    body.append(buffer, 0, read);
     */
import static org.hamcrest.Matchers.startsWith;
            httpExchange.sendResponseHeaders(statusCode, body.length() == 0 ? -1 : body.length());
            {
    public void testAuthCredentialsAreNotClearedOnAuthChallenge() throws Exception {
            Request request = new Request("PUT", "/200");
import com.sun.net.httpserver.HttpHandler;
        request.setJsonEntity(requestBody);
    /**
            assertEquals(pathPrefix + "/200?pretty=", response.getRequestLine().getUri());
                    Future<ClassicHttpResponse> future = client.execute(
            assertEquals(pathPrefix + "/200?routing=this%2Fis%2Fthe%2Frouting", response.getRequestLine().getUri());
        CountDownLatch requestLatch = new CountDownLatch(1);
import java.util.concurrent.atomic.AtomicReference;
    public void testUrlWithoutLeadingSlash() throws Exception {
            }
 * Integration test to check interaction between {@link RestClient} and {@link org.apache.hc.client5.http.classic.HttpClient}.
            AssertionError error = new AssertionError(
            Request request = new Request("PUT", "/200");
        int iters = randomIntBetween(500, 1000);
                        // expected
                    out.write(body.toString().getBytes(StandardCharsets.UTF_8));
            assertEquals(pathPrefix + "/" + statusCode, esResponse.getRequestLine().getUri());
    public void testPreemptiveAuthEnabled() throws Exception {
import org.apache.hc.core5.http.ClassicHttpResponse;
 * Works against a real http server, one single host.
            } catch (ResponseException e) {
            try {
                    getRequestProducer(httpGet, httpHost),
    private static class ResponseHandler implements HttpHandler {
                        null
                }
            request.addParameter("routing", "foo bar");
 *    http://www.apache.org/licenses/LICENSE-2.0
        });
import org.apache.hc.core5.http.HttpResponse;
                assertThat(response.getHeader("Authorization"), nullValue());
                new UsernamePasswordCredentials("user", "pass".toCharArray())
     * to set/add headers to the {@link org.apache.hc.client5.http.classic.HttpClient}.
     * Verify that credentials are <em>not</em> sent on the first request with preemptive auth disabled.
                final Phaser phaser = new Phaser(2);
            });
            Request request = new Request("PUT", "/200");
            credentialsProvider.setCredentials(
            }
        } else {
            }
        {
        final HttpHost httpHost = new HttpHost(httpServer.getAddress().getHostString(), httpServer.getAddress().getPort());
        {
            assertEquals(pathPrefix + "/200?routing=foo%5Ebar", response.getRequestLine().getUri());
import static org.junit.Assert.assertTrue;
        @Override
        final RestClientBuilder restClientBuilder = RestClient.builder(httpHost).setDefaultHeaders(defaultHeaders);
            Response response = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
                    }
import org.apache.hc.core5.net.URIBuilder;
        }
 */
                cancelHandlerLatch.await();
            protected ClassicHttpResponse buildResult(HttpResponse response, byte[] entity, ContentType contentType) {
    }
    }
                int read;
            client.start();
        return restClientBuilder.build();
            StringBuilder body = new StringBuilder();
                "GET",
     * out of the box by {@link org.apache.hc.client5.http.classic.HttpClient}.
     * Tests sending a bunch of async requests works well (e.g. no TimeoutException from the leased pool)
        assertEquals(requestBody, EntityUtils.toString(esResponse.getEntity()));
import org.apache.hc.core5.http.io.entity.EntityUtils;
            } catch (ResponseException e) {
        defaultHeaders = RestClientTestUtil.randomHeaders(getRandom(), "Header-default");
        };
 * compatible open source license.
        if (useAuth) {
                public HttpAsyncClientBuilder customizeHttpClient(final HttpAsyncClientBuilder httpClientBuilder) {
                        httpClientBuilder.setTargetAuthenticationStrategy(DefaultAuthenticationStrategy.INSTANCE);
    private HttpServer createHttpServer() throws Exception {
            // calling abort before the request is sent is a no-op
                    ).setPathPrefix(pathPrefix.substring(1)).build()
    }
                    httpGet.setDependency((org.apache.hc.core5.concurrent.Cancellable) future);
            // copy request headers to response headers so we can verify they were sent
            if (method.equals("HEAD") == false) {
    @Before
    private HttpUriRequestProducer getRequestProducer(HttpUriRequestBase request, HttpHost host) {
import java.io.IOException;
        {
    public void testDeleteWithBody() throws Exception {
        {
                assertEquals(404, e.getResponse().getStatusLine().getStatusCode());
        assertEquals(statusCode, esResponse.getStatusLine().getStatusCode());
     * End to end test for delete with body. We test it explicitly as it is not supported
            for (Header header : requestHeaders) {
            Response response = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
            assertTrue("some expected standard headers weren't returned: " + standardHeaders, standardHeaders.isEmpty());
                phaser.register();
            Request request = new Request("PUT", "/200");
            @Override
                    latch.countDown();
        }
        return bodyTest(restClient, method, statusCode, new Header[0]);
import java.util.concurrent.CopyOnWriteArrayList;
    /**
                    removedHeaders.add(name);
            for (final String method : methods) {
            Request request = new Request("PUT", "/200");
                    Future<ClassicHttpResponse> future = client.execute(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                ) {
                assertFalse(httpGet.isAborted());
            try {
            }
            for (Exception exception : exceptions.subList(0, Math.min(10, exceptions.size()))) {
                assertThat(response200.getHeader("Authorization"), startsWith("Basic"));
        }
                while ((read = reader.read(buffer)) != -1) {
            {
     * Exercises the test http server ability to send back whatever body it received.
            Headers responseHeaders = httpExchange.getResponseHeaders();
        }
                exchange.close();
                        future.get();
            final Set<String> standardHeaders = new HashSet<>(Arrays.asList("Connection", "Host", "User-agent", "Date", "Accept-encoding"));
            }
 * SPDX-License-Identifier: Apache-2.0
    }
 *
import java.util.concurrent.TimeUnit;
                    // Forcing termination since the AsyncResponseConsumer may not be reached,
    public void testManyAsyncRequests() throws Exception {
                        // expected
            }
            this.statusCode = statusCode;
            Request request = new Request("PUT", "/200");
            assertEquals(pathPrefix + "/200?routing=%E4%B8%AD%E6%96%87", response.getRequestLine().getUri());
import org.apache.hc.core5.http.io.entity.StringEntity;
        Request request = new Request(randomHttpMethod(getRandom()), "/wait");
                return super.buildResult(response, entity, contentType);
 * the Apache License, Version 2.0 (the "License"); you may
        }
        assertThat(error.get(), instanceOf(CancellationException.class));
        }
            try (InputStreamReader reader = new InputStreamReader(httpExchange.getRequestBody(), StandardCharsets.UTF_8)) {
    }
import java.util.concurrent.CountDownLatch;
        {
        Response esResponse;
        try (RestClient restClient = createRestClient(true, true)) {
                } finally {
 * You may obtain a copy of the License at
 */
                    assertTrue(future.isCancelled());
            }
            Request request = new Request("PUT", "/200");
                    } catch (CancellationException e) {
                    httpGet.setDependency((org.apache.hc.core5.concurrent.Cancellable) future);
import java.net.InetSocketAddress;
            public void onFailure(Exception exception) {
                assertEquals(200, response.getStatusLine().getStatusCode());
        }
import com.sun.net.httpserver.HttpServer;
                        future.get();
                    );
            request.addParameter("routing", "this/is/the/routing");
            assertEquals(pathPrefix + "/200?routing=foo%2Fbar", response.getRequestLine().getUri());
    public void testRequestResetAndAbort() throws Exception {
            assertTrue(httpGet.isAborted());
        restClient = createRestClient(false, true);
                    phaser.forceTermination();
        waitForCancelHandler = new WaitForCancelHandler();
                // pathPrefix is not required to start with '/', will be added automatically
    /**
                final Phaser phaser = new Phaser(0);
                }
    public void startHttpServer() throws Exception {
    public void testHeaders() throws Exception {
            final int statusCode = randomStatusCode(getRandom());
public class RestClientSingleHostIntegTests extends RestClientTestCase {
                throw new AssertionError("onResponse called unexpectedly");
        try (CloseableHttpAsyncClient client = HttpAsyncClientBuilder.create().build()) {
                    // a trailing slash gets automatically added if a pathPrefix is configured
        return httpServer;
                        getResponseConsumer(phaser),
            final Set<String> removedHeaders = new HashSet<>();
            request.addParameter("routing", "foo^bar");
/*
import java.nio.charset.StandardCharsets;
            HttpUriRequestBase httpGet = new HttpUriRequestBase(
                final Phaser phaser = new Phaser(2);
    }
            );
     * This test verifies some assumptions that we rely upon around the way the async http client works when reusing the same request
/*
                if (name.startsWith("Header") == false && removedHeaders.contains(name) == false) {
    }
    }
            Request request = new Request("PUT", "/200");
            request.addParameter("routing", "foo/bar");
        if (pathPrefix.length() > 0) {
    private String pathPrefix;
     */
        restClient.close();
        request.setOptions(options);
                    assertEquals(200, response.getStatusLine().getStatusCode());
import static org.junit.Assert.fail;
     * Verify that credentials continue to be sent even if a 401 (Unauthorized) response is received
            request.addParameter("routing", "routing#1");
            for (final String method : methods) {
                    getResponseConsumer(phaser),
        }
                phaser.arriveAndAwaitAdvance();
            Request request = new Request("PUT", "/200");
                    return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
                        assertTrue(future.isCancelled());
    private HttpServer httpServer;
                assertThat(response.getHeader("Authorization"), startsWith("Basic"));
                    exceptions.add(exception);
        httpServer.createContext(pathPrefix + "/wait", waitForCancelHandler);
                }
 *
import java.util.Set;
        }
            restClientBuilder.setPathPrefix(pathPrefix);
        assertTrue("timeout waiting for requests to be sent", latch.await(10, TimeUnit.SECONDS));
            Request request = new Request(method, "/" + statusCode);
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
                        throw new AssertionError("exception should have been thrown");
            {
                try {
        assertEquals(pathPrefix + "/" + statusCode, esResponse.getRequestLine().getUri());
            Response response = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
            }
        httpServer = createHttpServer();
        final String[] methods = { "POST", "PUT", "GET", "DELETE" };
            httpGet.abort();
        }
    public void testGetWithBody() throws Exception {
            Response response = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
                    httpGet.reset();
        cancellable.cancel();
                }
import org.junit.Before;
    }
import java.net.InetAddress;
            assertEquals(method, esResponse.getRequestLine().getMethod());
            }
                requestLatch.countDown();
                final Response response = bodyTest(restClient, method);
            final Header[] requestHeaders = RestClientTestUtil.randomHeaders(getRandom(), "Header");
                }
     */
 *
    /**
                public void onSuccess(Response response) {
                char[] buffer = new char[256];
        final String[] methods = { "POST", "PUT", "GET", "DELETE" };
                error.set(exception);
            for (final String method : methods) {
                exchange.sendResponseHeaders(200, 0);
import static org.opensearch.client.RestClientTestUtil.randomHttpMethod;
    private Response bodyTest(final String method) throws Exception {
        // returns a different status code depending on the path
        for (int i = 0; i < iters; i++) {
                );
                        phaser.arriveAndDeregister();
import org.apache.hc.core5.http.ContentType;
            assertEquals(pathPrefix + "/200?routing=foo%2Bbar", response.getRequestLine().getUri());
            }
                        new HttpHost(httpServer.getAddress().getHostString(), httpServer.getAddress().getPort())
     * Exercises the test http server ability to send back whatever body it received.
        for (int statusCode : getAllStatusCodes()) {
        RequestOptions.Builder options = request.getOptions().toBuilder();
import java.util.Arrays;
                "expected no failures but got some. see suppressed for first 10 of [" + exceptions.size() + "] failures"
import java.util.Map;
            for (final Header responseHeader : esResponse.getHeaders()) {
        } catch (ResponseException e) {
                        httpClientBuilder.disableAuthCaching();
                    }
                final Response response401 = bodyTest(restClient, method, 401, new Header[] { realmHeader });
 * not use this file except in compliance with the License.
                    try {
import org.apache.hc.client5.http.impl.async.HttpAsyncClientBuilder;
            httpServer.createContext(pathPrefix + "/" + statusCode, new ResponseHandler(statusCode));
        if (pathPrefix.length() == 0) {
            RequestOptions.Builder options = request.getOptions().toBuilder();
                    assertTrue("unknown header was returned " + name, standardHeaders.remove(name));
            assertEquals(pathPrefix + "/200?routing=routing%231", response.getRequestLine().getUri());
            request.addParameter("routing", "foo+bar");
        {
                @Override
            Response response = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
import org.apache.hc.core5.http.Header;
                    latch.countDown();
            } catch (InterruptedException ignore) {} finally {
            Response response = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
                        getRequestProducer(httpGet, httpHost),
            Response esResponse;
        phaser.register();
                esResponse = e.getResponse();
        httpServer.stop(0);
                RestClientSingleHostTests.performRequestSyncOrAsync(restClient, new Request("GET", "200"));
     */
            Response response = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
                    );
                Header realmHeader = new BasicHeader("WWW-Authenticate", "Basic realm=\"test\"");
        restClient = null;
import org.opensearch.client.http.HttpUriRequestProducer;
        httpServer = null;
        }
import java.io.InputStreamReader;
        final String[] methods = { "POST", "PUT", "GET", "DELETE" };
        @Override
