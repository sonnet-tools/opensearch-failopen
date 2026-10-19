            }
            restClient.performRequestAsync(request, new ResponseListener() {
    public void testEncodeParams() throws Exception {  
                responseHeaders.put(header.getKey(), header.getValue());
    }
            Response esResponse;
        public void handle(HttpExchange httpExchange) throws IOException {
            assertEquals(method, esResponse.requestLine().method());  
                final Response response200 = bodyTest(restClient, method, 200, Map.of());  
            } catch (InterruptedException ignore) {} finally {
            try {  
        }
            for (final String method : methods) {
                headers.put("Authorization", List.of("Basic " + auth));
                });  
            assertEquals(pathPrefix + "/200?routing=foo%2Bbar", response.requestLine().uri());
            assertEquals(pathPrefix + "/200?routing=routing%231", response.requestLine().uri());
    @After
    }  
            }
            final Map<String, List<String>> requestHeaders = RestClientTestUtil.randomHeaders(getRandom(), "Header");  
                            @Override  
        if (httpServerExecutor.awaitTermination(30, TimeUnit.SECONDS) == false) {
                try (OutputStream out = httpExchange.getResponseBody()) {  
                final Response response = bodyTest(restClient, method);
import java.util.concurrent.Executors;
        }  
            Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(restClient, request);  
 * Works against a real http server, one single host.  
        final String[] methods = { "POST", "PUT", "GET", "DELETE" };
                // a trailing slash gets automatically added if a pathPrefix is configured
        }
            restClientBuilder.setPathPrefix(pathPrefix);  
    public void testAuthCredentialsAreNotClearedOnAuthChallenge() throws Exception {  
    private RestHttpClient createRestClient(final boolean useAuth, final boolean usePreemptiveAuth) {
        builder = builder.withOptions(options);
import java.net.http.HttpRequest.BodyPublishers;
            esResponse = e.getResponse();  
        } else {
        restClient = createRestClient(false, true);
        httpServerExecutor = Executors.newFixedThreadPool(10);
 */  
                }  
    public void startHttpServer() throws Exception {
    }
        assertEquals(pathPrefix + "/" + statusCode, esResponse.requestLine().uri());
                ) {
        Response esResponse;
            Request request = Request.newRequest("PUT", "/200").withParameter("routing", "routing#1").build();  
        }  
            } catch (ResponseException e) {
            assertEquals(pathPrefix + "/200?routing=foo%5Ebar", response.requestLine().uri());  
        httpServer.stop(0);  
        restClient = null;
                @Override  
                public void onSuccess(Response response) {
    public void testPreemptiveAuthDisabled() throws Exception {
     * End to end test for delete with body. We test it explicitly as it is not supported
            final Set<String> standardHeaders = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);  
     * See https://github.com/elastic/elasticsearch/issues/24069
                public HttpClient.Builder customizeHttpClient(final HttpClient.Builder httpClientBuilder) {
            AssertionError error = new AssertionError(  
import com.sun.net.httpserver.HttpExchange;
                        return httpClientBuilder.executor(httpClientExecutor);
        bodyTest("DELETE");  
                int statusCode = RestClientTestUtil.randomStatusCode(getRandom());  
 * this file be licensed under the Apache-2.0 license or a
        assertTrue("timeout waiting for requests to be sent", latch.await(10, TimeUnit.SECONDS));
        return httpServer;
            {  
            final Set<String> removedHeaders = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
            assertTrue("some expected standard headers weren't returned: " + standardHeaders, standardHeaders.isEmpty());
                cancelHandlerLatch.await();
            Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
            }
            try {  
        pathPrefix = randomBoolean() ? "/testPathPrefix/" + randomAsciiLettersOfLengthBetween(1, 5) : "";
                final Response response401 = bodyTest(restClient, method, 401, realmHeader);  
import static org.junit.Assert.assertEquals;
            assertEquals(pathPrefix + "/200?routing=foo+bar", response.requestLine().uri());  
                while ((read = reader.read(buffer)) != -1) {
            }
            for (final String method : methods) {  
import com.sun.net.httpserver.Headers;
    private WaitForCancelHandler waitForCancelHandler;
        httpServer.start();
import org.junit.After;  
            httpExchange.sendResponseHeaders(statusCode, body.length() == 0 ? -1 : body.length());
                int read;
                char[] buffer = new char[256];  
     * Tests sending a bunch of async requests works well (e.g. no TimeoutException from the leased pool)  
        }
                    restClient,
     * End to end test for headers. We test it explicitly against a real http client as there are different ways  
        }
    }
                    // a trailing slash gets automatically added if a pathPrefix is configured
            for (final Map.Entry<String, List<String>> responseHeader : esResponse.headers().map().entrySet()) {  
            }  
        assertEquals(requestBody, BodyUtils.getBodyAsString(esResponse));
            Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
            StringBuilder body = new StringBuilder();
                    assertThat(ex.getMessage(), equalTo("WWW-Authenticate header missing for response code 401"));  
        return bodyTest(restClient, method, statusCode, Map.of());
                exchange.sendResponseHeaders(200, 0);  
                esResponse = e.getResponse();  
                        Request.newRequest("GET", "200").build()
        int iters = randomIntBetween(500, 1000);
        try {  
                    latch.countDown();
                    RestHttpClient restClient = RestHttpClient.builder(
                            }  
            });
        for (String method : RestClientTestUtil.getHttpMethods()) {
        final HttpHost httpHost = new HttpHost("http", httpServer.getAddress().getHostString(), httpServer.getAddress().getPort());  
            Request request = Request.newRequest("PUT", "/200").withParameter("routing", "foo^bar").build();
        }
        return esResponse;
                Arrays.asList("Connection", "Host", "User-agent", "Date", "Upgrade", "HTTP2-Settings", "Content-Length")
import java.util.Arrays;
    }
        for (Map.Entry<String, List<String>> header : headers.entrySet()) {
            for (Map.Entry<String, List<String>> header : requestHeaders.entrySet()) {  
            LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(randomLongBetween(1, 5)));
import com.sun.net.httpserver.HttpHandler;  
        {
                    public HttpClient.Builder customizeHttpClient(final HttpClient.Builder httpClientBuilder) {
            if (usePreemptiveAuth == false) {
    private static class WaitForCancelHandler implements HttpHandler {
                try (
        CountDownLatch requestLatch = new CountDownLatch(1);  
            for (final String method : methods) {
            {
import java.net.InetAddress;
            }
package org.opensearch.internal.httpclient;
            if (body.length() > 0) {
                if (name.startsWith("header") == false && removedHeaders.contains(name) == false) {  
 * The OpenSearch Contributors require contributions made to  
    }
import java.net.PasswordAuthentication;  
    /**  
                error.addSuppressed(exception);
    public void testUrlWithoutLeadingSlash() throws Exception {  
            public void onFailure(Exception exception) {  
import java.util.Map;
import java.nio.charset.StandardCharsets;  
            );  
        try (RestHttpClient restClient = createRestClient(true, true)) {  
        }
        RequestOptions.Builder options = RequestOptions.DEFAULT.toBuilder();  
        for (int i = 0; i < iters; i++) {
        }
     */
                    public HttpClient.Builder customizeHttpClient(final HttpClient.Builder httpClientBuilder) {  
        {
            }
            );
        {  
     */
import java.util.TreeSet;  
            Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
        if (httpClientExecutor.awaitTermination(30, TimeUnit.SECONDS) == false) {  
/**
        void cancelDone() {  
        waitForCancelHandler.cancelDone();  
import java.net.Authenticator;  
            assertEquals(pathPrefix + "/200?pretty=", response.requestLine().uri());
        @Override
 * SPDX-License-Identifier: Apache-2.0
        }
    }
        String requestBody = "{ \"field\": \"value\" }";
        if (pathPrefix.length() > 0) {
        // returns a different status code depending on the path
                    latch.countDown();
import java.io.OutputStream;
                final Map<String, List<String>> headers = new HashMap<>(defaultHeaders);  
    public void testCancelAsyncRequest() throws Exception {
            cancelHandlerLatch.countDown();
        }
        for (int statusCode : RestClientTestUtil.getAllStatusCodes()) {  
            httpServerExecutor.shutdownNow();
            // a trailing slash gets automatically added even if a pathPrefix is not configured (HttpClient uses full URI)  
        httpServer.createContext(pathPrefix + "/wait", waitForCancelHandler);
import java.net.http.HttpClient;
                .withOptions(RequestOptions.DEFAULT.toBuilder().addHeaders(requestHeaders))  
        waitForCancelHandler = new WaitForCancelHandler();  
    private Response bodyTest(RestHttpClient restClient, String method, int statusCode, Map<String, List<String>> headers)
        }
    }  
                    }
import java.util.concurrent.locks.LockSupport;
    private HttpServer createHttpServer() throws Exception {
                            protected PasswordAuthentication getPasswordAuthentication() {
import static org.hamcrest.CoreMatchers.startsWith;  
    public void testManyAsyncRequests() throws Exception {  
}  
 * compatible open source license.
        }
                String name = responseHeader.getKey().toLowerCase(Locale.ROOT);
        assertThat(error.get(), instanceOf(CancellationException.class));
            }  
     * Verify that credentials are <em>not</em> sent on the first request with preemptive auth disabled.
    }
                }  
import java.util.concurrent.CountDownLatch;  
            header.getValue().forEach(v -> options.addHeader(header.getKey(), v));
        {
            assertEquals(statusCode, esResponse.statusLine().statusCode());
import static org.junit.Assert.assertThrows;
            assertEquals(pathPrefix + "/200?routing=this%2Fis%2Fthe%2Frouting", response.requestLine().uri());
 */
        if (useAuth) {  
            assertEquals(pathPrefix + "/200?pretty", response.requestLine().uri());
            Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(restClient, request);  
            this.statusCode = statusCode;
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
import static org.junit.Assert.assertThat;  
import java.util.List;
        {  
                final String auth = Base64.getEncoder().encodeToString(("user" + ":" + "pass").getBytes(StandardCharsets.UTF_8));
        } else {
            try (InputStreamReader reader = new InputStreamReader(httpExchange.getRequestBody(), StandardCharsets.UTF_8)) {
import com.sun.net.httpserver.HttpServer;
import static org.hamcrest.CoreMatchers.equalTo;
                    assertThat(response.header("Authorization"), nullValue());  
                    out.write(body.toString().getBytes(StandardCharsets.UTF_8));
     */  
            restClientBuilder.setHttpClientConfigCallback(new RestHttpClientBuilder.HttpClientConfigCallback() {  
                    body.append(buffer, 0, read);  
        }
                assertThat(response.header("Authorization"), startsWith("Basic"));
import java.util.Base64;  
        }  
    }  
        }  
                }  
    }  
    }  
        restClient.close();
     * Exercises the test http server ability to send back whatever body it received.  
        }  
            throw error;  
                }
    /**
     */
     * End to end test for get with body. We test it explicitly as it is not supported
                );
            Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
    }
            // copy request body to response body so we can verify it was sent  
        });
/*  
        if (pathPrefix.length() == 0) {
    private static class ResponseHandler implements HttpHandler {  
                throw new AssertionError("onResponse called unexpectedly");
        }  
    }
        ResponseHandler(int statusCode) {  
            assertEquals(pathPrefix + "/" + statusCode, esResponse.requestLine().uri());
import java.net.InetSocketAddress;
    }  
import java.util.concurrent.atomic.AtomicReference;
                if (statusCode == 401) {
    /**  
            assertEquals(200, response.statusLine().statusCode());
        }
                    assertTrue("unknown header was returned " + name, standardHeaders.remove(name));
                exchange.close();
                @Override
                Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(
            Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(
                }  
    private RestHttpClient restClient;
    }
                    Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(  
                requestLatch.countDown();
                }
     * Exercises the test http server ability to send back whatever headers it received.
    private HttpServer httpServer;
                Map<String, List<String>> realmHeader = Map.of("WWW-Authenticate", List.of("Basic realm=\"test\""));
        private final CountDownLatch cancelHandlerLatch = new CountDownLatch(1);
        {
            Request request = Request.newRequest("PUT", "/200").withParameter("pretty", null).build();  
    private Response bodyTest(final RestHttpClient restClient, final String method) throws Exception {  
        }  
     * out of the box by {@link HttpClient}.
        @Override
        AtomicReference<Exception> error = new AtomicReference<>();
            if (method.equals("HEAD") && Runtime.version().feature() > 25 /* https://bugs.openjdk.org/browse/JDK-8369981 */) {
            );
        assertEquals(method, esResponse.requestLine().method());
    /**
            httpClientExecutor.shutdownNow();
    private ExecutorService httpServerExecutor;
            Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(restClient, request);  
        httpClientExecutor.shutdown();
            // copy request headers to response headers so we can verify they were sent  
            }
            assertHeaders(defaultHeaders, requestHeaders, esResponse.headers(), standardHeaders);
        cancellable.cancel();
            }
        final CountDownLatch latch = new CountDownLatch(iters);
            final int statusCode = RestClientTestUtil.randomStatusCode(getRandom());
                restClientBuilder.setHttpClientConfigCallback(new RestHttpClientBuilder.HttpClientConfigCallback() {
            httpServer.createContext(pathPrefix + "/" + statusCode, new ResponseHandler(statusCode));
                restClientBuilder.setHttpClientConfigCallback(new RestHttpClientBuilder.HttpClientConfigCallback() {
                    @Override
                    @Override  
                }
        }
    public void testPreemptiveAuthEnabled() throws Exception {
            Request request = Request.newRequest("PUT", "/200").withParameter("routing", "foo+bar").build();  
                    assertEquals(200, response.statusLine().statusCode());
    /**
                    final IOException ex = assertThrows(IOException.class, () -> bodyTest(restClient, method, statusCode, Map.of()));
                standardHeaders.remove("Content-Length");  
        httpServerExecutor.shutdown();  
import java.util.Locale;  
                        new HttpHost("http", httpServer.getAddress().getHostString(), httpServer.getAddress().getPort())  
import java.util.concurrent.TimeUnit;  
                } else {
            Request request = Request.newRequest("PUT", "/200").withParameter("routing", "foo/bar").build();
            });
     * Exercises the test http server ability to send back whatever body it received.  
        httpServer = createHttpServer();  
            }
import static org.junit.Assert.assertTrue;
        }
        Request request = Request.newRequest(RestClientTestUtil.randomHttpMethod(getRandom()), "/wait").build();
        final String[] methods = { "POST", "PUT", "GET", "DELETE" };
        httpClientExecutor = Executors.newFixedThreadPool(5);
        {
    private Response bodyTest(final String method) throws Exception {
    public void testGetWithBody() throws Exception {
            public void onSuccess(Response response) {
        defaultHeaders = RestClientTestUtil.randomHeaders(getRandom(), "Header-default");  
            @Override
                    }
        private final int statusCode;
            }  
        httpServer = null;
    @Before  
    /**  
            }
                    ).setPathPrefix(pathPrefix.substring(1)).build()
            Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
import java.io.IOException;  
        final List<Exception> exceptions = new CopyOnWriteArrayList<>();  
        {
                "expected no failures but got some. see suppressed for first 10 of [" + exceptions.size() + "] failures"
    private String pathPrefix;  
                Request.newRequest("GET", "200").build()
            }
            Request request = Request.newRequest("PUT", "/200").withParameter("routing", "foo bar").build();
            assertEquals(pathPrefix + "/200?routing=this%7Cis%7Cthe%7Crouting", response.requestLine().uri());  
                // pathPrefix is not required to start with '/', will be added automatically  
                                return new PasswordAuthentication("user", "pass".toCharArray());
                        return httpClientBuilder.executor(httpClientExecutor).authenticator(new Authenticator() {
        {
import java.util.concurrent.ExecutorService;
        }
    public void stopHttpServers() throws IOException, InterruptedException {  
        assertEquals(statusCode, esResponse.statusLine().statusCode());  
            httpExchange.getRequestBody().close();  
            assertEquals(pathPrefix + "/200?routing=%E4%B8%AD%E6%96%87", response.requestLine().uri());
        try (RestHttpClient restClient = createRestClient(true, false)) {
    }  
                    );  
        return restClientBuilder.build();
                    Request.newRequest("GET", "200").build()  
        try (RestHttpClient restClient = createRestClient(true, true)) {
import java.util.concurrent.CancellationException;
                restClient,  
    }
    public void testDeleteWithBody() throws Exception {
        }  
            } else {
        {  
                        });
                error.set(exception);
            httpExchange.close();
     */  
        assertTrue(requestLatch.await(5, TimeUnit.SECONDS));
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Set;
        }
            Request request = Request.newRequest("PUT", "/200").withParameter("routing", "this|is|the|routing").build();
 *
        int statusCode = RestClientTestUtil.randomStatusCode(getRandom());
import org.junit.Before;
    public void testHeaders() throws Exception {
import java.io.InputStreamReader;
                    return httpClientBuilder.executor(httpClientExecutor).connectTimeout(Duration.ofSeconds(15));  
import static org.hamcrest.Matchers.instanceOf;
        public void handle(HttpExchange exchange) throws IOException {
     * Verify that credentials are sent on the first request with preemptive auth enabled (default when provided with credentials).  
                restClientBuilder.setDefaultHeaders(headers);
            Request request = Request.newRequest("PUT", "/200").withParameter("routing", "中文").build();
     */
        }  
    private Map<String, List<String>> defaultHeaders;
        throws Exception {  
        Cancellable cancellable = restClient.performRequestAsync(request, new ResponseListener() {
            }  
            }
        }  
        return bodyTest(restClient, method);  
                    final Response response = bodyTest(restClient, method, statusCode, Map.of());
            esResponse = RestHttpClientSingleHostTests.performRequestSyncOrAsync(restClient, builder.build());
                public void onFailure(Exception exception) {  
            for (Exception exception : exceptions.subList(0, Math.min(10, exceptions.size()))) {  
            Headers responseHeaders = httpExchange.getResponseHeaders();
        if (exceptions.isEmpty() == false) {
                .build();
     * to set/add headers to the {@link HttpClient}.
        bodyTest("GET");  
     */
                assertThat(response401.header("Authorization"), startsWith("Basic"));
import java.time.Duration;
                    exceptions.add(exception);
    }  
        httpServer.setExecutor(httpServerExecutor);  
import java.util.HashMap;
            Request request = Request.newRequest(method, "/" + statusCode)
                esResponse = RestHttpClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
            assertEquals(pathPrefix + "/200?routing=foo%2Fbar", response.requestLine().uri());
            Headers requestHeaders = httpExchange.getRequestHeaders();
            Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(restClient, request);  
    /**
    private ExecutorService httpClientExecutor;  
                @Override
                        restClient,
     * Verify that credentials continue to be sent even if a 401 (Unauthorized) response is received
public class RestHttpClientSingleHostIntegTests extends RestHttpClientTestCase {
                assertThat(response200.header("Authorization"), startsWith("Basic"));
                // Some headers could be returned multiple times in response, like Connection fe.
        Request.Builder builder = Request.newRequest(method, "/" + statusCode).withEntity(requestBody);
            Request request = Request.newRequest("PUT", "/200").withParameter("pretty", "").build();
        } catch (ResponseException e) {
        final String[] methods = { "POST", "PUT", "GET", "DELETE" };  
            Request request = Request.newRequest("PUT", "/200").withParameter("routing", "this/is/the/routing").build();
            standardHeaders.addAll(
                assertEquals(200, response.statusLine().statusCode());  
import static org.hamcrest.CoreMatchers.nullValue;
                });  
                    removedHeaders.add(name);
            Request request = Request.newRequest("PUT", "/200").withEntity(BodyPublishers.ofString("{}")).build();
            Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
 * Integration test to check interaction between {@link RestHttpClient} and {@link HttpClient}.
            @Override  
        }
            // Add random jitter so HttpServer will not refuse the connections  
     * out of the box by {@link HttpClient}.
                }
        final RestHttpClientBuilder restClientBuilder = RestHttpClient.builder(httpHost).setDefaultHeaders(defaultHeaders);
