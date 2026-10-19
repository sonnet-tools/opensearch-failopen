                phaser.register();  
            this.statusCode = statusCode;
     */  
    public void testCancelAsyncRequest() throws Exception {
    public void stopHttpServers() throws IOException {  
            Request request = new Request("PUT", "/200");  
            for (final String method : methods) {
                @Override
     * End to end test for get with body. We test it explicitly as it is not supported
     * Exercises the test http server ability to send back whatever body it received.
                responseHeaders.put(header.getKey(), header.getValue());
            Request request = new Request("PUT", "/200");  
        {
        final CountDownLatch latch = new CountDownLatch(iters);
                    try {
 * this work for additional information regarding copyright
                }
            Response response = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
                phaser.register();  
                    phaser.forceTermination();  
    }
        httpServer = null;
        try (RestClient restClient = createRestClient(true, false)) {
     * Tests sending a bunch of async requests works well (e.g. no TimeoutException from the leased pool)
            {
    private RestClient restClient;
            // calling abort before the request is sent is a no-op  
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);  
        restClient = createRestClient(false, true);
            for (Header header : requestHeaders) {
            request.addParameter("routing", "this|is|the|routing");
     * Verify that credentials continue to be sent even if a 401 (Unauthorized) response is received
        return new HeapBufferedAsyncResponseConsumer(1024) {
            for (Map.Entry<String, List<String>> header : requestHeaders.entrySet()) {  
        }
    }
                    removedHeaders.add(name);  
                    phaser.forceTermination();
    }  
        } else {  
            try {
                    httpGet.reset();  
            }
                public HttpAsyncClientBuilder customizeHttpClient(final HttpAsyncClientBuilder httpClientBuilder) {
            credentialsProvider.setCredentials(  
 * this file be licensed under the Apache-2.0 license or a
                    );
            Request request = new Request("PUT", "/200");  
            assertEquals(pathPrefix + "/200?routing=this%2Fis%2Fthe%2Frouting", response.getRequestLine().getUri());  
        void cancelDone() {  
            Headers responseHeaders = httpExchange.getResponseHeaders();
        assertEquals(requestBody, EntityUtils.toString(esResponse.getEntity()));  
                error.addSuppressed(exception);
            Request request = new Request("PUT", "/200");  
        for (int statusCode : getAllStatusCodes()) {  
                        assertTrue(future.isCancelled());  
import org.apache.hc.core5.http.io.entity.EntityUtils;  
package org.opensearch.client;
import java.util.concurrent.CancellationException;  
                    if (usePreemptiveAuth == false) {
     * Verify that credentials are <em>not</em> sent on the first request with preemptive auth disabled.
                    } catch (CancellationException e) {  
import java.util.List;  
            } catch (ResponseException e) {  
            // copy request headers to response headers so we can verify they were sent  
    public void testAuthCredentialsAreNotClearedOnAuthChallenge() throws Exception {
            protected ClassicHttpResponse buildResult(HttpResponse response, byte[] entity, ContentType contentType) {  
import org.junit.After;
            if (body.length() > 0) {
    public void testRequestResetAndAbort() throws Exception {  
        defaultHeaders = RestClientTestUtil.randomHeaders(getRandom(), "Header-default");
            request.addParameter("routing", "foo/bar");
            HttpHost httpHost = new HttpHost(httpServer.getAddress().getHostString(), httpServer.getAddress().getPort());  
import java.util.concurrent.Future;  
        }  
        {
        }
                }
            restClient.performRequestAsync(request, new ResponseListener() {  
    }
            request.addParameter("pretty", "");
        final String[] methods = { "POST", "PUT", "GET", "DELETE" };
            {
    public void startHttpServer() throws Exception {
import com.sun.net.httpserver.HttpHandler;  
                try (OutputStream out = httpExchange.getResponseBody()) {  
                        phaser.arriveAndDeregister();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    assertTrue(httpGet.isAborted());  
            public void onFailure(Exception exception) {
import java.util.Arrays;
    }  
            request.addParameter("pretty", null);
                exchange.sendResponseHeaders(200, 0);  
            request.addParameter("routing", "routing#1");
            // provide the username/password for every request
                public void onSuccess(Response response) {
 */  
     * In fact the low-level REST client reuses the same request instance throughout multiple retries, and relies on the http client  
        }
            });
            httpExchange.getRequestBody().close();  
 * license agreements. See the NOTICE file distributed with
        }
                    null
            request.addParameter("routing", "foo bar");
        ResponseHandler(int statusCode) {  
                @Override  
            }  
import java.io.InputStreamReader;
                    httpGet.abort();  
        return restClientBuilder.build();
            request.setOptions(options);
     * End to end test for headers. We test it explicitly against a real http client as there are different ways
            httpExchange.sendResponseHeaders(statusCode, body.length() == 0 ? -1 : body.length());
    private Response bodyTest(RestClient restClient, String method, int statusCode, Header[] headers) throws Exception {  
public class RestClientSingleHostIntegTests extends RestClientTestCase {
                        getRequestProducer(httpGet, httpHost),
                    }
 * You may obtain a copy of the License at  
        public void handle(HttpExchange httpExchange) throws IOException {
        Request request = new Request(randomHttpMethod(getRandom()), "/wait");  
        });
            Response response = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
    public void testPreemptiveAuthDisabled() throws Exception {
            }
            }
        try {
            assertEquals(pathPrefix + "/200?routing=%E4%B8%AD%E6%96%87", response.getRequestLine().getUri());  
            Response response = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
            request.addParameter("routing", "this/is/the/routing");
                    exceptions.add(exception);
     * Exercises the test http server ability to send back whatever body it received.
                        getResponseConsumer(phaser),  
            );  
        try (RestClient restClient = createRestClient(true, true)) {
        {
                        future.get();
            assertEquals(method, esResponse.getRequestLine().getMethod());
import java.util.Map;
    }
            final BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
    /**
            {  
        }
        return bodyTest(restClient, method, statusCode, new Header[0]);  
                    getResponseConsumer(phaser),  
                }
        if (useAuth) {  
            }
            StringBuilder body = new StringBuilder();
    public void testUrlWithoutLeadingSlash() throws Exception {
            Request request = new Request("PUT", "/200");  
        int statusCode = randomStatusCode(getRandom());
                        // disable preemptive auth by ignoring any authcache  
                esResponse = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
        final String[] methods = { "POST", "PUT", "GET", "DELETE" };
                httpGet.reset();
            assertEquals(pathPrefix + "/200?routing=this%7Cis%7Cthe%7Crouting", response.getRequestLine().getUri());  
import static org.junit.Assert.assertTrue;  
import org.apache.hc.core5.http.ClassicHttpResponse;
            assertEquals(pathPrefix + "/200?routing=foo%2Fbar", response.getRequestLine().getUri());  
                Future<ClassicHttpResponse> future = client.execute(
     * This test verifies some assumptions that we rely upon around the way the async http client works when reusing the same request
                        null
        waitForCancelHandler = new WaitForCancelHandler();  
/*
                }
 * software distributed under the License is distributed on an
    }
        }
            for (final String method : methods) {
    private static class WaitForCancelHandler implements HttpHandler {
    public void testHeaders() throws Exception {  
            esResponse = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
import com.sun.net.httpserver.HttpServer;
        }  
            httpGet.abort();
    }
                try {
import org.apache.hc.core5.net.URIBuilder;
import java.io.IOException;
        bodyTest("GET");
        }
import org.apache.hc.core5.http.Header;  
        try (CloseableHttpAsyncClient client = HttpAsyncClientBuilder.create().build()) {
                phaser.arriveAndAwaitAdvance();
     */
                    assertTrue("unknown header was returned " + name, standardHeaders.remove(name));
                    }
                Response response = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, new Request("GET", "200"));
    /**
import org.apache.hc.core5.http.nio.AsyncResponseConsumer;  
            }
    private Response bodyTest(final RestClient restClient, final String method) throws Exception {
 * ownership. Elasticsearch licenses this file to you under  
                        httpClientBuilder.disableAuthCaching();
            assertHeaders(defaultHeaders, requestHeaders, esResponse.getHeaders(), standardHeaders);
            Response response = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
        return httpServer;
                requestLatch.countDown();  
                    }
                httpGet.reset();
        for (Header header : headers) {
import org.apache.hc.client5.http.auth.AuthScope;  
                char[] buffer = new char[256];  
                try {
import static org.hamcrest.Matchers.startsWith;
 *
            httpServer.createContext(pathPrefix + "/" + statusCode, new ResponseHandler(statusCode));
                        // expected
                    assertTrue(future.isCancelled());  
                assertThat(response401.getHeader("Authorization"), startsWith("Basic"));
        @Override
    public void testPreemptiveAuthEnabled() throws Exception {
     * out of the box by {@link org.apache.hc.client5.http.classic.HttpClient}.  
                        future.get();
     * See https://github.com/elastic/elasticsearch/issues/24069  
        assertEquals(method, esResponse.getRequestLine().getMethod());  
            assertEquals(pathPrefix + "/200?pretty", response.getRequestLine().getUri());  
            assertTrue("some expected standard headers weren't returned: " + standardHeaders, standardHeaders.isEmpty());  
    /**
                        new HttpHost(httpServer.getAddress().getHostString(), httpServer.getAddress().getPort())
        }
            }
        restClient.close();
                if (name.startsWith("Header") == false && removedHeaders.contains(name) == false) {
            Request request = new Request("PUT", "/200");  
                while ((read = reader.read(buffer)) != -1) {
     */
    private HttpServer httpServer;  
    }
            final Set<String> removedHeaders = new HashSet<>();  
            httpExchange.close();
    }
                assertFalse(httpGet.isAborted());  
                standardHeaders.add("Content-length");
            {
/*  
                        throw new AssertionError("exception should have been thrown");
    private Response bodyTest(final String method) throws Exception {  
 *
                final Phaser phaser = new Phaser(2);
        }
 * under the License.  
        }  
                int read;
        restClient = null;
        Response esResponse;  
        {
        {
        {
import org.apache.hc.client5.http.impl.DefaultAuthenticationStrategy;  
            Request request = new Request("PUT", "/200");  
        }
 * Works against a real http server, one single host.
                public void onFailure(Exception exception) {
     * Exercises the test http server ability to send back whatever headers it received.
        {
}
                assertThat(response.getHeader("Authorization"), startsWith("Basic"));
                // pathPrefix is not required to start with '/', will be added automatically
            for (Exception exception : exceptions.subList(0, Math.min(10, exceptions.size()))) {
            assertEquals(statusCode, esResponse.getStatusLine().getStatusCode());
                    // Forcing termination since the AsyncResponseConsumer may not be reached,
        }
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
 */  
                RestClientSingleHostTests.performRequestSyncOrAsync(restClient, new Request("GET", "200"));
                    Future<ClassicHttpResponse> future = client.execute(
import java.nio.charset.StandardCharsets;  
    private static class ResponseHandler implements HttpHandler {  
        assertThat(error.get(), instanceOf(CancellationException.class));  
            try {  
                        null  
            }  
                        fail("expected cancellation exception");
                final Phaser phaser = new Phaser(0);  
        bodyTest("DELETE");
            }
        return esResponse;
    }  
            try (InputStreamReader reader = new InputStreamReader(httpExchange.getRequestBody(), StandardCharsets.UTF_8)) {
import org.opensearch.client.http.HttpUriRequestProducer;
        assertTrue(requestLatch.await(5, TimeUnit.SECONDS));
            client.start();
import static org.junit.Assert.assertFalse;
import org.apache.hc.core5.http.io.entity.StringEntity;
        }
                assertEquals(200, future.get().getCode());
            Response esResponse;  
    private HttpUriRequestProducer getRequestProducer(HttpUriRequestBase request, HttpHost host) {
        try (RestClient restClient = createRestClient(true, true)) {
        request.setOptions(options);
    }
            assertEquals(pathPrefix + "/200?pretty=", response.getRequestLine().getUri());  
    }
            restClientBuilder.setPathPrefix(pathPrefix);  
     */  
 * KIND, either express or implied.  See the License for the
    private String pathPrefix;
            Response response = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
     */
     */
                    body.append(buffer, 0, read);  
        pathPrefix = randomBoolean() ? "/testPathPrefix/" + randomAsciiLettersOfLengthBetween(1, 5) : "";
import java.util.concurrent.CountDownLatch;
    }  
            @Override  
                new URIBuilder().setHttpHost(httpHost).setPath(pathPrefix + "/200").build()  
            assertEquals(pathPrefix + "/200?routing=foo%2Bbar", response.getRequestLine().getUri());  
                Header realmHeader = new BasicHeader("WWW-Authenticate", "Basic realm=\"test\"");  
            Response response = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
                new AuthScope(httpHost, null, "Basic"),
                final Phaser phaser = new Phaser(2);
            final Set<String> standardHeaders = new HashSet<>(Arrays.asList("Connection", "Host", "User-agent", "Date", "Accept-encoding"));
            restClientBuilder.setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
                }
        phaser.register();  
    /**
                } finally {
        final String[] methods = { "POST", "PUT", "GET", "DELETE" };
        final RestClientBuilder restClientBuilder = RestClient.builder(httpHost).setDefaultHeaders(defaultHeaders);
                    ).setPathPrefix(pathPrefix.substring(1)).build()
                    );
                    out.write(body.toString().getBytes(StandardCharsets.UTF_8));
import static org.opensearch.client.RestClientTestUtil.randomStatusCode;
            // copy request body to response body so we can verify it was sent  
        CountDownLatch requestLatch = new CountDownLatch(1);
        };
                assertFalse(httpGet.isAborted());  
import java.io.OutputStream;  
                throw new AssertionError("onResponse called unexpectedly");  
        }
                assertFalse(future.isCancelled());
            AssertionError error = new AssertionError(
                assertThat(response.getHeader("Authorization"), nullValue());
    public void testGetWithBody() throws Exception {  
        waitForCancelHandler.cancelDone();
    }  
 * not use this file except in compliance with the License.
            Request request = new Request(method, "/" + statusCode);  
        for (String method : getHttpMethods()) {
    }
        }
 * Modifications Copyright OpenSearch Contributors. See
import java.util.concurrent.CopyOnWriteArrayList;
                        getRequestProducer(httpGet, httpHost),
            }  
                    latch.countDown();  
        assertEquals(pathPrefix + "/" + statusCode, esResponse.getRequestLine().getUri());
                    assertEquals(200, response.getStatusLine().getStatusCode());  
                // Some headers could be returned multiple times in response, like Connection fe.  
            assertEquals(pathPrefix + "/200?routing=routing%231", response.getRequestLine().getUri());  
        httpServer.start();
            );
            Request request = new Request("PUT", "/200");  
            request.addParameter("routing", "中文");
            request.addParameter("routing", "foo+bar");
        }
import java.net.InetSocketAddress;
        httpServer.createContext(pathPrefix + "/wait", waitForCancelHandler);
        }
            request.addParameter("routing", "foo^bar");
                "expected no failures but got some. see suppressed for first 10 of [" + exceptions.size() + "] failures"
                "GET",
            assertEquals(pathPrefix + "/" + statusCode, esResponse.getRequestLine().getUri());  
        }
        if (pathPrefix.length() > 0) {
            } catch (InterruptedException ignore) {} finally {
import org.apache.hc.core5.http.HttpResponse;
        {
                }
                        httpClientBuilder.setTargetAuthenticationStrategy(DefaultAuthenticationStrategy.INSTANCE);  
                        phaser.arriveAndDeregister();  
            }
import java.util.concurrent.TimeUnit;
            });
                );
 * SPDX-License-Identifier: Apache-2.0
                options.addHeader(header.getName(), header.getValue());  
            Response response = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
        Request request = new Request(method, "/" + statusCode);
            );  
            Headers requestHeaders = httpExchange.getRequestHeaders();
import static org.opensearch.client.RestClientTestUtil.getAllStatusCodes;
                    // the request is aborted right before  
        if (pathPrefix.length() == 0) {
                    Future<ClassicHttpResponse> future = client.execute(  
    /**  
                @Override  
import org.apache.hc.core5.http.message.BasicHeader;
import com.sun.net.httpserver.Headers;
    private AsyncResponseConsumer<ClassicHttpResponse> getResponseConsumer(Phaser phaser) {
            esResponse = e.getResponse();
        httpServer = createHttpServer();  
            }
    }
                String name = responseHeader.getName();
import java.net.InetAddress;
 *    http://www.apache.org/licenses/LICENSE-2.0
            } catch (ResponseException e) {  
                    latch.countDown();  
                    httpGet.setDependency((org.apache.hc.core5.concurrent.Cancellable) future);
    private RestClient createRestClient(final boolean useAuth, final boolean usePreemptiveAuth) {
    @Before  
            final int statusCode = randomStatusCode(getRandom());
    public void testManyAsyncRequests() throws Exception {
                cancelHandlerLatch.await();
            Request request = new Request("PUT", "/200");  
import java.util.concurrent.atomic.AtomicReference;  
     * to set the future ref to the request properly so that when abort is called, the proper future gets cancelled.
import com.sun.net.httpserver.HttpExchange;
                }
        assertEquals(statusCode, esResponse.getStatusLine().getStatusCode());
import static org.opensearch.client.RestClientTestUtil.randomHttpMethod;
     */
        RequestOptions.Builder options = request.getOptions().toBuilder();
        httpServer.stop(0);  
            }
import static org.junit.Assert.fail;
                esResponse = e.getResponse();
            Request request = new Request("PUT", "/200");
            @Override
                    Response response = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, new Request("GET", "200"));
        Cancellable cancellable = restClient.performRequestAsync(request, new ResponseListener() {  
                    assertFalse(httpGet.isAborted());  
import java.util.HashSet;
 * Integration test to check interaction between {@link RestClient} and {@link org.apache.hc.client5.http.classic.HttpClient}.
                    httpGet.setDependency((org.apache.hc.core5.concurrent.Cancellable) future);
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
import org.apache.hc.client5.http.impl.auth.BasicCredentialsProvider;  
        {
                        getResponseConsumer(phaser),
        // returns a different status code depending on the path
/*  
import static org.hamcrest.Matchers.nullValue;
            assertEquals(pathPrefix + "/200?routing=foo%5Ebar", response.getRequestLine().getUri());  
                assertEquals(404, e.getResponse().getStatusLine().getStatusCode());
        final HttpHost httpHost = new HttpHost(httpServer.getAddress().getHostString(), httpServer.getAddress().getPort());  
                } finally {  
import java.util.concurrent.Phaser;
        AtomicReference<Exception> error = new AtomicReference<>();
            }  
import org.apache.hc.client5.http.auth.UsernamePasswordCredentials;
                    httpGet.abort();
                assertFalse(httpGet.isAborted());
        return bodyTest(restClient, method);
    /**
 */  
                    } catch (CancellationException e) {  
            throw error;
            @Override
    @After
        if (exceptions.isEmpty() == false) {  
                try (
            }  
import java.util.Set;
import org.junit.Before;
            if (method.equals("HEAD") == false) {  
        assertTrue("timeout waiting for requests to be sent", latch.await(10, TimeUnit.SECONDS));
                final Response response200 = bodyTest(restClient, method, 200, new Header[0]);
    public void testEncodeParams() throws Exception {
            }  
                return super.buildResult(response, entity, contentType);
                }
        private final CountDownLatch cancelHandlerLatch = new CountDownLatch(1);
            HttpUriRequestBase httpGet = new HttpUriRequestBase(
    }
import static org.hamcrest.Matchers.instanceOf;  
            try {  
            request.setEntity(new StringEntity("{}", ContentType.APPLICATION_JSON));
            Request request = new Request("PUT", "/200");  
import org.apache.hc.client5.http.impl.async.HttpAsyncClientBuilder;
                ) {  
            }  
                    // a trailing slash gets automatically added if a pathPrefix is configured
        }
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
        }
                    return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);  
    public void testDeleteWithBody() throws Exception {  
                    getRequestProducer(httpGet, httpHost),
        }
    private Header[] defaultHeaders;  
            Response response = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
 * GitHub history for details.
            {  
        }
                    try {
                    // Forcing termination since the AsyncResponseConsumer may not be reached,
        for (int i = 0; i < iters; i++) {  
        }
 * specific language governing permissions and limitations
    }
import org.apache.hc.core5.http.ContentType;
     * out of the box by {@link org.apache.hc.client5.http.classic.HttpClient}.  
    }  
                assertEquals(200, response.getStatusLine().getStatusCode());
    /**
    private HttpServer createHttpServer() throws Exception {
        request.setJsonEntity(requestBody);  
     * throughout multiple retries, and the use of the {@link HttpUriRequestBase#abort()} method.
                exchange.close();
import org.apache.hc.core5.http.HttpHost;
import static org.junit.Assert.assertEquals;  
 * the Apache License, Version 2.0 (the "License"); you may
                new UsernamePasswordCredentials("user", "pass".toCharArray())
    }
    }
                }
        {
            Response response = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
                assertThat(response200.getHeader("Authorization"), startsWith("Basic"));
        cancellable.cancel();  
 */
        } catch (ResponseException e) {  
                final Response response = bodyTest(restClient, method);  
            for (final String method : methods) {
                // a trailing slash gets automatically added if a pathPrefix is configured  
            assertTrue(httpGet.isAborted());
            assertEquals(pathPrefix + "/200?routing=foo%20bar", response.getRequestLine().getUri());  
    private WaitForCancelHandler waitForCancelHandler;
        @Override
        return HttpUriRequestProducer.create(request, host);
        String requestBody = "{ \"field\": \"value\" }";
                    // the request is aborted right before
     * End to end test for delete with body. We test it explicitly as it is not supported
import static org.opensearch.client.RestClientTestUtil.getHttpMethods;  
     */  
                error.set(exception);
            Response response = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
    /**
                        // don't use the "persistent credentials strategy"
            RequestOptions.Builder options = request.getOptions().toBuilder();
        }
        final List<Exception> exceptions = new CopyOnWriteArrayList<>();
 * Licensed to Elasticsearch under one or more contributor  
                final Response response = bodyTest(restClient, method);  
            final Header[] requestHeaders = RestClientTestUtil.randomHeaders(getRandom(), "Header");
     * Verify that credentials are sent on the first request with preemptive auth enabled (default when provided with credentials).
        public void handle(HttpExchange exchange) throws IOException {
        private final int statusCode;
import static org.junit.Assert.assertThat;
                    RestClient restClient = RestClient.builder(  
            }  
 * compatible open source license.
            cancelHandlerLatch.countDown();
            }
            }
     * to set/add headers to the {@link org.apache.hc.client5.http.classic.HttpClient}.  
            options.addHeader(header.getName(), header.getValue());  
import org.opensearch.client.nio.HeapBufferedAsyncResponseConsumer;  
            public void onSuccess(Response response) {
        int iters = randomIntBetween(500, 1000);  
            }
 *  
/**  
            for (final Header responseHeader : esResponse.getHeaders()) {
                final Response response401 = bodyTest(restClient, method, 401, new Header[] { realmHeader });
                fail("request should have failed");
                        // expected
        }  
