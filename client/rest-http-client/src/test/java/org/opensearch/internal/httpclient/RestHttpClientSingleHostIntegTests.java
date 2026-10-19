        final CountDownLatch latch = new CountDownLatch(iters);
            final Map<String, List<String>> requestHeaders = RestClientTestUtil.randomHeaders(getRandom(), "Header");
                    // a trailing slash gets automatically added if a pathPrefix is configured
                responseHeaders.put(header.getKey(), header.getValue());
                final String auth = Base64.getEncoder().encodeToString(("user" + ":" + "pass").getBytes(StandardCharsets.UTF_8));
            Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
        }
        assertTrue(requestLatch.await(5, TimeUnit.SECONDS));
 * The OpenSearch Contributors require contributions made to
    }
            restClientBuilder.setHttpClientConfigCallback(new RestHttpClientBuilder.HttpClientConfigCallback() {
import java.net.InetSocketAddress;
        for (int i = 0; i < iters; i++) {
                final Response response401 = bodyTest(restClient, method, 401, realmHeader);
            final Set<String> removedHeaders = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
            Request request = Request.newRequest("PUT", "/200").withParameter("pretty", null).build();
            this.statusCode = statusCode;
            {
        {
        void cancelDone() {
import org.junit.Before;
import java.net.http.HttpClient;
/*
                    final IOException ex = assertThrows(IOException.class, () -> bodyTest(restClient, method, statusCode, Map.of()));
package org.opensearch.internal.httpclient;
            esResponse = e.getResponse();
                .build();
        {
import com.sun.net.httpserver.HttpServer;
        if (exceptions.isEmpty() == false) {
import java.util.concurrent.CountDownLatch;
            });
                    );
            if (body.length() > 0) {
            httpServer.createContext(pathPrefix + "/" + statusCode, new ResponseHandler(statusCode));
                    assertThat(response.header("Authorization"), nullValue());
            assertEquals(pathPrefix + "/200?pretty", response.requestLine().uri());
        return esResponse;
import java.io.OutputStream;
            httpExchange.close();
public class RestHttpClientSingleHostIntegTests extends RestHttpClientTestCase {
        assertEquals(pathPrefix + "/" + statusCode, esResponse.requestLine().uri());
        Request.Builder builder = Request.newRequest(method, "/" + statusCode).withEntity(requestBody);
        } catch (ResponseException e) {
        }
            Request request = Request.newRequest("PUT", "/200").withParameter("routing", "this/is/the/routing").build();
        }
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.instanceOf;
            cancelHandlerLatch.countDown();
        Response esResponse;
            assertEquals(200, response.statusLine().statusCode());
import java.util.TreeSet;
    @Before
                }
    public void stopHttpServers() throws IOException, InterruptedException {
    private WaitForCancelHandler waitForCancelHandler;
            Request request = Request.newRequest("PUT", "/200").withParameter("routing", "foo bar").build();
     */
        return bodyTest(restClient, method, statusCode, Map.of());
     * Verify that credentials continue to be sent even if a 401 (Unauthorized) response is received
                }
        }
        }
    private String pathPrefix;
        waitForCancelHandler = new WaitForCancelHandler();
        httpServer.setExecutor(httpServerExecutor);
                    exceptions.add(exception);
    public void testGetWithBody() throws Exception {
                public void onSuccess(Response response) {
            Request request = Request.newRequest("PUT", "/200").withParameter("routing", "this|is|the|routing").build();
                // a trailing slash gets automatically added if a pathPrefix is configured
            Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
    public void startHttpServer() throws Exception {
    public void testEncodeParams() throws Exception {
                }
                            @Override
                public void onFailure(Exception exception) {
    }
            LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(randomLongBetween(1, 5)));
                }
        }
        {
        {
        assertEquals(requestBody, BodyUtils.getBodyAsString(esResponse));
        httpServer.start();
                int read;
                assertEquals(200, response.statusLine().statusCode());
            esResponse = RestHttpClientSingleHostTests.performRequestSyncOrAsync(restClient, builder.build());
                error.set(exception);
                // Some headers could be returned multiple times in response, like Connection fe.
            }
    /**
                );
        httpClientExecutor.shutdown();
            }
            Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
            Request request = Request.newRequest(method, "/" + statusCode)
    }
                String name = responseHeader.getKey().toLowerCase(Locale.ROOT);
            assertEquals(pathPrefix + "/200?routing=foo%2Bbar", response.requestLine().uri());
                .withOptions(RequestOptions.DEFAULT.toBuilder().addHeaders(requestHeaders))
            if (usePreemptiveAuth == false) {
        assertEquals(statusCode, esResponse.statusLine().statusCode());
                                return new PasswordAuthentication("user", "pass".toCharArray());
import com.sun.net.httpserver.Headers;
            }
            restClient.performRequestAsync(request, new ResponseListener() {
        httpServerExecutor = Executors.newFixedThreadPool(10);
import java.util.HashMap;
            if (method.equals("HEAD") && Runtime.version().feature() > 25 /* https://bugs.openjdk.org/browse/JDK-8369981 */) {
                }
            assertEquals(pathPrefix + "/200?routing=%E4%B8%AD%E6%96%87", response.requestLine().uri());
        waitForCancelHandler.cancelDone();
import java.util.Set;
            try {
                    public HttpClient.Builder customizeHttpClient(final HttpClient.Builder httpClientBuilder) {
        final String[] methods = { "POST", "PUT", "GET", "DELETE" };
    private ExecutorService httpClientExecutor;
            assertEquals(pathPrefix + "/200?pretty=", response.requestLine().uri());
        }
 * Integration test to check interaction between {@link RestHttpClient} and {@link HttpClient}.
                    @Override
        if (pathPrefix.length() > 0) {
            );
            }
        private final int statusCode;
                        return httpClientBuilder.executor(httpClientExecutor).authenticator(new Authenticator() {
 * SPDX-License-Identifier: Apache-2.0
    private Response bodyTest(final RestHttpClient restClient, final String method) throws Exception {
        restClient = createRestClient(false, true);
                final Response response = bodyTest(restClient, method);
}
            Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
        }
        }
import org.junit.After;
                Arrays.asList("Connection", "Host", "User-agent", "Date", "Upgrade", "HTTP2-Settings", "Content-Length")
 *
        }
                        new HttpHost("http", httpServer.getAddress().getHostString(), httpServer.getAddress().getPort())
        return restClientBuilder.build();
            for (final String method : methods) {
    private RestHttpClient createRestClient(final boolean useAuth, final boolean usePreemptiveAuth) {
            Request request = Request.newRequest("PUT", "/200").withParameter("routing", "foo^bar").build();
            Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(
            httpExchange.getRequestBody().close();
                ) {
        {
                int statusCode = RestClientTestUtil.randomStatusCode(getRandom());
import java.time.Duration;
        @Override
            Request request = Request.newRequest("PUT", "/200").withParameter("routing", "foo+bar").build();
import java.util.List;
     * End to end test for get with body. We test it explicitly as it is not supported
            }
     */
                assertThat(response401.header("Authorization"), startsWith("Basic"));
        {
    private Response bodyTest(RestHttpClient restClient, String method, int statusCode, Map<String, List<String>> headers)
            final int statusCode = RestClientTestUtil.randomStatusCode(getRandom());
            }
    private static class WaitForCancelHandler implements HttpHandler {
     * to set/add headers to the {@link HttpClient}.
        }
            }
            } catch (InterruptedException ignore) {} finally {
import com.sun.net.httpserver.HttpHandler;
                @Override
            Request request = Request.newRequest("PUT", "/200").withParameter("routing", "routing#1").build();
                    latch.countDown();
    }
    private static class ResponseHandler implements HttpHandler {
        {
        final HttpHost httpHost = new HttpHost("http", httpServer.getAddress().getHostString(), httpServer.getAddress().getPort());
        // returns a different status code depending on the path
            } else {
        bodyTest("DELETE");
        if (pathPrefix.length() == 0) {
    /**
import static org.hamcrest.CoreMatchers.equalTo;
        }
        }
                restClientBuilder.setHttpClientConfigCallback(new RestHttpClientBuilder.HttpClientConfigCallback() {
                    assertTrue("unknown header was returned " + name, standardHeaders.remove(name));
     * Exercises the test http server ability to send back whatever headers it received.
            }
        bodyTest("GET");
                        return httpClientBuilder.executor(httpClientExecutor);
            assertEquals(pathPrefix + "/200?routing=foo%5Ebar", response.requestLine().uri());
        }
        }
                restClient,
    }
import java.util.concurrent.Executors;
        ResponseHandler(int statusCode) {
import static org.junit.Assert.assertEquals;
     * End to end test for headers. We test it explicitly against a real http client as there are different ways
            }
        if (httpClientExecutor.awaitTermination(30, TimeUnit.SECONDS) == false) {
            throw error;
import java.util.concurrent.atomic.AtomicReference;
                try (
            );
            }
                } else {
import java.net.InetAddress;
     * out of the box by {@link HttpClient}.
     * Exercises the test http server ability to send back whatever body it received.
                    @Override
        }
            assertEquals(pathPrefix + "/200?routing=this%7Cis%7Cthe%7Crouting", response.requestLine().uri());
    @After
import static org.junit.Assert.assertThat;
            for (final String method : methods) {
        final RestHttpClientBuilder restClientBuilder = RestHttpClient.builder(httpHost).setDefaultHeaders(defaultHeaders);
        assertTrue("timeout waiting for requests to be sent", latch.await(10, TimeUnit.SECONDS));
     * Verify that credentials are <em>not</em> sent on the first request with preemptive auth disabled.
import java.util.concurrent.locks.LockSupport;
            assertEquals(pathPrefix + "/200?routing=foo%2Fbar", response.requestLine().uri());
        pathPrefix = randomBoolean() ? "/testPathPrefix/" + randomAsciiLettersOfLengthBetween(1, 5) : "";
     */
    }
    /**
import java.util.Map;
                cancelHandlerLatch.await();
        public void handle(HttpExchange exchange) throws IOException {
        {
            } catch (ResponseException e) {
            try {
            @Override
        defaultHeaders = RestClientTestUtil.randomHeaders(getRandom(), "Header-default");
                    out.write(body.toString().getBytes(StandardCharsets.UTF_8));
                restClientBuilder.setHttpClientConfigCallback(new RestHttpClientBuilder.HttpClientConfigCallback() {
            assertEquals(pathPrefix + "/" + statusCode, esResponse.requestLine().uri());
            httpExchange.sendResponseHeaders(statusCode, body.length() == 0 ? -1 : body.length());
    }
            );
                });
            }
        restClient = null;
        }
                assertThat(response200.header("Authorization"), startsWith("Basic"));
    }
                while ((read = reader.read(buffer)) != -1) {
        httpServer.createContext(pathPrefix + "/wait", waitForCancelHandler);
 * Works against a real http server, one single host.
    public void testUrlWithoutLeadingSlash() throws Exception {
            public void onFailure(Exception exception) {
 */
                    RestHttpClient restClient = RestHttpClient.builder(
import java.net.PasswordAuthentication;
        }
        restClient.close();
                    removedHeaders.add(name);
                    assertEquals(200, response.statusLine().statusCode());
            Request request = Request.newRequest("PUT", "/200").withParameter("routing", "foo/bar").build();
        int statusCode = RestClientTestUtil.randomStatusCode(getRandom());
                esResponse = RestHttpClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
    }
                }
        return bodyTest(restClient, method);
                if (statusCode == 401) {
    /**
    public void testAuthCredentialsAreNotClearedOnAuthChallenge() throws Exception {
    /**
                    }
        httpServer = createHttpServer();
        }
    }
/**
import static org.junit.Assert.assertThrows;
                esResponse = e.getResponse();
            Headers responseHeaders = httpExchange.getResponseHeaders();
    private Response bodyTest(final String method) throws Exception {
                @Override
        final String[] methods = { "POST", "PUT", "GET", "DELETE" };
import java.io.InputStreamReader;
        } else {
import static org.junit.Assert.assertTrue;
                @Override
                    Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(
    }
        try {
                exchange.sendResponseHeaders(200, 0);
     */
        }
            {
        }
import java.nio.charset.StandardCharsets;
                "expected no failures but got some. see suppressed for first 10 of [" + exceptions.size() + "] failures"
                restClientBuilder.setDefaultHeaders(headers);
    /**
            Response esResponse;
    private HttpServer httpServer;
        throws Exception {
    private ExecutorService httpServerExecutor;
                        restClient,
            assertHeaders(defaultHeaders, requestHeaders, esResponse.headers(), standardHeaders);
        }
            for (final String method : methods) {
    public void testManyAsyncRequests() throws Exception {
                            }
    private Map<String, List<String>> defaultHeaders;
import java.util.Arrays;
        }
        if (useAuth) {
                Request.newRequest("GET", "200").build()
     * Exercises the test http server ability to send back whatever body it received.
            Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
            for (final Map.Entry<String, List<String>> responseHeader : esResponse.headers().map().entrySet()) {
                exchange.close();
            public void onSuccess(Response response) {
                assertThat(response.header("Authorization"), startsWith("Basic"));
                Map<String, List<String>> realmHeader = Map.of("WWW-Authenticate", List.of("Basic realm=\"test\""));
            Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
        final String[] methods = { "POST", "PUT", "GET", "DELETE" };
                    Request.newRequest("GET", "200").build()
            // copy request body to response body so we can verify it was sent
            StringBuilder body = new StringBuilder();
            assertEquals(method, esResponse.requestLine().method());
import java.net.Authenticator;
        httpServer = null;
        try (RestHttpClient restClient = createRestClient(true, false)) {
import java.util.Base64;
        try (RestHttpClient restClient = createRestClient(true, true)) {
     * Verify that credentials are sent on the first request with preemptive auth enabled (default when provided with credentials).
            try (InputStreamReader reader = new InputStreamReader(httpExchange.getRequestBody(), StandardCharsets.UTF_8)) {
        {
        }
import java.util.concurrent.CancellationException;
                            protected PasswordAuthentication getPasswordAuthentication() {
    private RestHttpClient restClient;
                    restClient,
        httpClientExecutor = Executors.newFixedThreadPool(5);
    }
            assertEquals(pathPrefix + "/200?routing=this%2Fis%2Fthe%2Frouting", response.requestLine().uri());
     * out of the box by {@link HttpClient}.
import java.util.concurrent.TimeUnit;
                    body.append(buffer, 0, read);
            assertEquals(statusCode, esResponse.statusLine().statusCode());
     */
import java.util.concurrent.CopyOnWriteArrayList;
            standardHeaders.addAll(
        String requestBody = "{ \"field\": \"value\" }";
            assertTrue("some expected standard headers weren't returned: " + standardHeaders, standardHeaders.isEmpty());
                public HttpClient.Builder customizeHttpClient(final HttpClient.Builder httpClientBuilder) {
        assertThat(error.get(), instanceOf(CancellationException.class));
            Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
 * compatible open source license.
            @Override
            assertEquals(pathPrefix + "/200?routing=routing%231", response.requestLine().uri());
    }
                        Request.newRequest("GET", "200").build()
                    }
            assertEquals(pathPrefix + "/200?routing=foo+bar", response.requestLine().uri());
            final Set<String> standardHeaders = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
                    ).setPathPrefix(pathPrefix.substring(1)).build()
        RequestOptions.Builder options = RequestOptions.DEFAULT.toBuilder();
            httpServerExecutor.shutdownNow();
        for (Map.Entry<String, List<String>> header : headers.entrySet()) {
                final Response response200 = bodyTest(restClient, method, 200, Map.of());
                final Map<String, List<String>> headers = new HashMap<>(defaultHeaders);
import java.util.Locale;
        @Override
            }
                }
                }
            for (Exception exception : exceptions.subList(0, Math.min(10, exceptions.size()))) {
import com.sun.net.httpserver.HttpExchange;
    }
            // a trailing slash gets automatically added even if a pathPrefix is not configured (HttpClient uses full URI)
     * See https://github.com/elastic/elasticsearch/issues/24069
                        });
            Request request = Request.newRequest("PUT", "/200").withParameter("pretty", "").build();
import java.net.http.HttpRequest.BodyPublishers;
        Cancellable cancellable = restClient.performRequestAsync(request, new ResponseListener() {
        }
        if (httpServerExecutor.awaitTermination(30, TimeUnit.SECONDS) == false) {
     * Tests sending a bunch of async requests works well (e.g. no TimeoutException from the leased pool)
            for (Map.Entry<String, List<String>> header : requestHeaders.entrySet()) {
        }
                if (name.startsWith("header") == false && removedHeaders.contains(name) == false) {
     */
import java.util.concurrent.ExecutorService;
    /**
            Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
                    final Response response = bodyTest(restClient, method, statusCode, Map.of());
            Request request = Request.newRequest("PUT", "/200").withParameter("routing", "中文").build();
        for (int statusCode : RestClientTestUtil.getAllStatusCodes()) {
        CountDownLatch requestLatch = new CountDownLatch(1);
        Request request = Request.newRequest(RestClientTestUtil.randomHttpMethod(getRandom()), "/wait").build();
            // copy request headers to response headers so we can verify they were sent
            AssertionError error = new AssertionError(
        return httpServer;
 */
                    public HttpClient.Builder customizeHttpClient(final HttpClient.Builder httpClientBuilder) {
                requestLatch.countDown();
        });
        } else {
        for (String method : RestClientTestUtil.getHttpMethods()) {
            }
            Headers requestHeaders = httpExchange.getRequestHeaders();
                    latch.countDown();
    public void testHeaders() throws Exception {
import static org.hamcrest.CoreMatchers.startsWith;
        AtomicReference<Exception> error = new AtomicReference<>();
            });
            header.getValue().forEach(v -> options.addHeader(header.getKey(), v));
        httpServer.stop(0);
                char[] buffer = new char[256];
    public void testPreemptiveAuthDisabled() throws Exception {
                try (OutputStream out = httpExchange.getResponseBody()) {
                headers.put("Authorization", List.of("Basic " + auth));
                error.addSuppressed(exception);
        assertEquals(method, esResponse.requestLine().method());
            Request request = Request.newRequest("PUT", "/200").withEntity(BodyPublishers.ofString("{}")).build();
        public void handle(HttpExchange httpExchange) throws IOException {
        }
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
            restClientBuilder.setPathPrefix(pathPrefix);
    }
                // pathPrefix is not required to start with '/', will be added automatically
        final List<Exception> exceptions = new CopyOnWriteArrayList<>();
                    assertThat(ex.getMessage(), equalTo("WWW-Authenticate header missing for response code 401"));
        try (RestHttpClient restClient = createRestClient(true, true)) {
    private HttpServer createHttpServer() throws Exception {
        private final CountDownLatch cancelHandlerLatch = new CountDownLatch(1);
    }
    }
        httpServerExecutor.shutdown();
            }
     * End to end test for delete with body. We test it explicitly as it is not supported
    public void testDeleteWithBody() throws Exception {
                    return httpClientBuilder.executor(httpClientExecutor).connectTimeout(Duration.ofSeconds(15));
        int iters = randomIntBetween(500, 1000);
    }
     */
        {
                standardHeaders.remove("Content-Length");
                throw new AssertionError("onResponse called unexpectedly");
                });
            // Add random jitter so HttpServer will not refuse the connections
        }
        builder = builder.withOptions(options);
            }
    }
            Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
            Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
            }
            httpClientExecutor.shutdownNow();
        cancellable.cancel();
                Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(
    public void testCancelAsyncRequest() throws Exception {
    public void testPreemptiveAuthEnabled() throws Exception {
