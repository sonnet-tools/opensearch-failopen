            if (expectedEntity != null) {
            try {
    }
 * SPDX-License-Identifier: Apache-2.0
        for (String method : getHttpMethods()) {
     * End to end test for error status codes: they should cause an exception to be thrown, apart from 404 with HEAD requests
            return responseRef.get();
                    @Override
            options.setWarningsHandler(warningOption.warningsHandler());
import java.util.Optional;
                String value = randomAsciiAlphanumOfLengthBetween(3, 10);
                assertExceptionStackContainsCallingMethod(e);
            @Override
                assertThat(BodyUtils.getBodyAsString(response), equalTo(body));
public class RestHttpClientSingleHostTests extends RestHttpClientTestCase {
        for (StackTraceElement se : t.getStackTrace()) {
        httpClient = mockHttpClient(exec, (requestProducer, bodyHandler) -> {
        final String additionalQuery = params.entrySet()
     * normally the case for synchronous calls but {@link RestHttpClient} performs
            Set<Integer> expectedIgnores = new HashSet<>();
            builder = builder.withEntity(bodyPublisher);
        }
    public void createRestClient() {
            try {
            // error status codes should cause an exception to be thrown
        switch (request.uri().getPath()) {
        }
        for (String method : getHttpMethods()) {
            int numParams = randomIntBetween(1, 3);
            Map<String, List<String>> headers = RestClientTestUtil.randomHeaders(getRandom(), "Header");
            latch.await();
        String proxyWarning = "112 - \"network down\" \"Sat, 25 Aug 2012 23:34:45 GMT\"";
            }
            if (randomBoolean()) {
    private LongAdder requests;
    private HostsTrackingFailureListener failureListener;
        FILTERED {
            }
    private HttpClient httpClient;
            }
        // return the desired status code or exception depending on the path
    }
        }
    private static void assertExceptionStackContainsCallingMethod(Throwable t) {
            for (int errorStatusCode : getAllErrorStatusCodes()) {
    public void testInternalHttpRequest() throws Exception {
                return callback;
        },
                    failureListener.assertNotCalled();
            final int statusCode = randomStatusCode(getRandom());
     * End to end test for request and response body. Exercises the mock http client ability to send back
                    try {
        assertDeprecationWarnings(singletonList(proxyWarning), singletonList(proxyWarning));
            requestProducerCapture.set(requestProducer);
                ignore += "," + randomFrom(RestClientTestUtil.getAllErrorStatusCodes());
            final AtomicReference<Exception> exceptionRef = new AtomicReference<>();
            try {
                        return request.uri();
        assertEquals(false == warningBodyTexts.isEmpty(), response.hasWarnings());
                builder = builder.withParameter(name, value);
import static org.hamcrest.CoreMatchers.instanceOf;
        // 2 is the caller, what we want
     * assertion to make sure that we don't break that "special care".
                    }
        assertEquals(warningBodyTexts, response.warnings());
            String ignoreParam = "";
        }
                try {
                return;
                }
    @SuppressWarnings("unchecked")
import static org.opensearch.internal.httpclient.RestClientTestUtil.getAllErrorStatusCodes;
                }
                assertEquals(expectedEntity, actualEntity);
                    ignoreParam += code;
    }
    public void testPerformRequestIOExceptions() throws Exception {
                uniqueNames.add(header.getKey());
            }
    private void assertDeprecationWarnings(List<String> warningHeaderTexts, List<String> warningBodyTexts) throws Exception {
                assertExceptionStackContainsCallingMethod(e);
        }
                    expectedIgnores.add(code);
        EXACT {
import static org.hamcrest.CoreMatchers.equalTo;
                // And we do all that so the thrown exception has our method in the stacktrace
import java.net.URI;
            } catch (SocketTimeoutException e) {
import org.apache.commons.logging.Log;
            }
import org.junit.Before;
            protected WarningsHandler warningsHandler() {
}
import javax.net.ssl.SSLHandshakeException;
import java.util.List;
    @Before
    @After
            public Redirect followRedirects() {
        // randomize between sync and async methods
                                return true;
                    assertEquals(errorStatusCode, e.getResponse().statusLine().statusCode());
    private Node node;
                        return null;
import java.io.PrintWriter;
                java.net.http.HttpRequest request,
            }
     * synchronous calls by performing asynchronous calls and blocking the
                    public HttpHeaders headers() {
            case "/runtime":
        },
                    }
            public boolean awaitTermination(Duration duration) throws InterruptedException {
        String body = "{ \"field\": \"value\" }";
            @Override
            } catch (ClosedChannelException e) {
                params.put(name, value);
        }
import org.junit.After;
                            }
    /**
            @Override
            if (uniqueNames.contains(defaultHeader.getKey()) == false) {
                public void onFailure(Exception exception) {
                return new WarningsHandler() {
                    }
                fail("request should have failed");
        if (randomBoolean()) {
 * The OpenSearch Contributors require contributions made to
            builder = builder.withOptions(options);
                        return (T) httpResponse;
import java.util.concurrent.CountDownLatch;
            try {
    private static final Log logger = LogFactory.getLog(RestHttpClientSingleHostTests.class);
            null,
     * End to end test for ok status codes
                    public Version version() {
                // And we do all that so the thrown exception has our method in the stacktrace
import java.time.Duration;
        return formatWarningWithoutDate(warningBody) + " \"Mon, 01 Jan 2001 00:00:00 GMT\"";
            for (Map.Entry<String, List<String>> header : headers.entrySet()) {
            case "/closed":
    /**
        StringWriter stack = new StringWriter();
                if (errorStatusCode <= 500 || expectedIgnores.contains(errorStatusCode)) {
            Object expectedEntity = BodyUtils.getBody(expectedRequest).block();
            for (int i = 0; i < numParams; i++) {
import java.util.concurrent.Executor;
        // 1 is this method
                final CompletableFuture<HttpResponse<T>> callback = new CompletableFuture<>();
                Request request = Request.newRequest(method, "/" + errorStatusCode).withEntity(entity).build();
        BodyPublisher bodyPublisher = BodyPublishers.noBody();
import java.net.URISyntaxException;
                Response response = restClient.performRequest(request);
 */
                        builder = builder.withParameter("ignore", ignoreParam);
    }
                assertExceptionStackContainsCallingMethod(e);
    }
            @Override
                    assertThat(response.statusLine().statusCode(), equalTo(errorStatusCode));
        requestProducerCapture = new AtomicReference<>();
    /**
                return Optional.empty();
        restClient = new RestHttpClient(
import java.net.ProxySelector;
     * Verifies the content of the {@link HttpRequest} that's internally created and passed through to the http client
                fail("request should have failed");
                esResponse = e.getResponse();
            assertThat(esResponse.statusLine().statusCode(), equalTo(statusCode));
        failureListener = new HostsTrackingFailureListener();
                int statusCode = Integer.parseInt(request.uri().getPath().substring(1));
                return exec.awaitTermination(duration.toMillis(), TimeUnit.MILLISECONDS);
        protected abstract WarningsHandler warningsHandler();
                        return request;
    private HttpRequest performRandomRequest(String method) throws Exception {
        }
        Request.Builder builder = Request.newRequest(method, uriAsString);
            failureListener.assertCalled(singletonList(node));
                throw new IOException(httpHost.toString());
                    }
        };
            Response esResponse;
                restClient.performRequest(Request.newRequest(method, "/uri").build());
     * current thread until the call returns so it has to take special care
        assertDeprecationWarnings(singletonList(formatWarningWithoutDate(chars)), singletonList(chars));
                InterruptedException {
                        return entity;
import java.util.Arrays;
                    restClient.performRequest(request);
            Arrays.asList(chars, "another one", "and another")
        for (String method : getHttpMethods()) {
            }
import static org.junit.Assert.assertEquals;
            .collect(Collectors.joining("&"));
                            if (false == warning.startsWith("ignorable")) {
            return restClient.performRequest(request);
                return Optional.of(exec);
            failureListener.assertCalled(singletonList(node));
     * Shutdown the executor so we don't leak threads into other test runs.
            }
                        callback.completeExceptionally(e);
        } catch (Exception e) {
import java.net.Authenticator;
    public void testErrorStatusCodes() throws Exception {
        assertDeprecationWarnings(singletonList(formatWarning(chars)), singletonList(chars));
                        return Optional.empty();
                throw new ClosedChannelException();
                performRequestSyncOrAsync(restClient, builder.build());
            }
    public void testDeprecationWarnings() throws Exception {
     */
import java.util.Collections;
            } catch (SSLHandshakeException e) {
import static org.opensearch.internal.httpclient.RestClientTestUtil.getOkStatusCodes;
import java.net.http.HttpRequest.BodyPublisher;
import java.util.concurrent.Executors;
    }
                        // no exception gets thrown although we got an error status code, as it was configured to be ignored
                    @Override
            } catch (IOException e) {
                restClient.performRequest(Request.newRequest(method, "/ioe").build());
            failureListener.assertCalled(singletonList(node));
                return null;
            }
                return Optional.empty();
package org.opensearch.internal.httpclient;
            }
            }
        for (String method : getHttpMethods()) {
            }
        requests = new LongAdder();
            public Optional<Executor> executor() {
        HttpClient httpClient = new HttpClient() {
import static org.hamcrest.CoreMatchers.containsString;
            @Override
     * Asserts that the provided {@linkplain Exception} contains the method
                return null;
                } catch (ResponseException e) {
                        ignoreParam += ",";
            assertEquals(expectedRequest.method(), actualRequest.method());
            }
            @Override
                    }
import static java.util.Collections.singletonList;
                // return the same body that was sent
                    }
        }
                    }
            expectFailure = strictDeprecationMode && false == warningBodyTexts.isEmpty();
import java.net.http.HttpResponse.BodyHandler;
    }
                    if (expectedIgnores.contains(errorStatusCode)) {
 *
    private RestHttpClient restClient;
            final AtomicReference<Response> responseRef = new AtomicReference<>();
    private Map<String, List<String>> defaultHeaders;
            }
        node = new Node(new HttpHost("http", "localhost", 9200));
            RequestOptions.Builder options = RequestOptions.DEFAULT.toBuilder();
            public Optional<ProxySelector> proxy() {
        String uriAsString = "/" + randomStatusCode(getRandom());
import static org.junit.Assert.fail;
            failureListener.assertCalled(singletonList(node));
            }
        }
    /**
                    assertExceptionStackContainsCallingMethod(e);
            }
            Request.Builder builder = Request.newRequest(method, "/" + statusCode);
            case "/uri":
                } catch (ResponseException e) {
    private AtomicReference<HttpRequest> requestProducerCapture;
        Map<String, String> params = new HashMap<>();
                        return false == warnings.equals(Arrays.asList("exact"));
        }
            }
            public Version version() {
import java.net.http.HttpClient;
                    @Override
                    } catch (Exception e) {
            }
import java.net.http.HttpRequest.BodyPublishers;
            assertThat(requests.intValue(), equalTo(++times));
                return Optional.empty();
            }
            @Override
        String chars = randomAsciiAlphanumOfLength(5);
        for (String httpMethod : getHttpMethods()) {
     */
        for (Map.Entry<String, List<String>> defaultHeader : defaultHeaders.entrySet()) {
import java.util.Map;
        Response response;
        }
            public Optional<Authenticator> authenticator() {
            failureListener.assertCalled(singletonList(node));
            }
                final HttpResponse<?> httpResponse = new HttpResponse<>() {
/**
                // And we do all that so the thrown exception has our method in the stacktrace
import java.nio.charset.StandardCharsets;
                for (int i = 0; i < numIgnores; i++) {
        final HttpHost httpHost = new HttpHost(request.uri().getScheme(), request.uri().getHost(), request.uri().getPort());
                restClient.performRequest(Request.newRequest(method, "/soe").build());
            HttpRequest expectedRequest = performRandomRequest(httpMethod);
                    }
                int numIgnores = randomIntBetween(1, 3);
                assertExceptionStackContainsCallingMethod(e);
                    failureListener.assertCalled(singletonList(node));
    }
            logger.info("checking strictWarningsMode=[" + strictDeprecationMode + "] and warnings=" + warningBodyTexts);
                    Response response = e.getResponse();
                    latch.countDown();
    public void shutdownExec() {
        }
 * Relies on a mock http client to intercept requests and return desired responses based on request path.
        }
        exec.shutdown();
    static Response performRequestSyncOrAsync(RestHttpClient restClient, Request request) throws Exception {
                        fail("request should have failed");
                String name = "param-" + i;
                return WarningsHandler.PERMISSIVE;
                defaultHeader.getValue().forEach(v -> expectedRequest.header(defaultHeader.getKey(), v));
        final Set<String> uniqueNames = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
                        return Optional.empty();
        BodyPublisher entity = BodyPublishers.ofString(body);
            failureListener.assertCalled(singletonList(node));
                    @Override
            }
            RequestOptions.Builder options = RequestOptions.DEFAULT.toBuilder();
            case "/ioe":
        };
                    public int statusCode() {
                };
    /**
            options.addHeader("Warning", warningHeaderText);
            // IOExceptions should be let bubble up
import java.util.TreeSet;
            } catch (HttpTimeoutException e) {
        }
                    responseRef.set(response);
import javax.net.ssl.SSLContext;
                        throw e;
                } else {
            false
                        }
                assertExceptionStackContainsCallingMethod(e);
        );
import java.util.concurrent.atomic.LongAdder;
                if (false == warningBodyTexts.isEmpty()) {
    public void testBody() throws Exception {
                assertThat(response.statusLine().statusCode(), equalTo(okStatusCode));
            } catch (ResponseException e) {
 * this file be licensed under the Apache-2.0 license or a
            if (randomBoolean()) {
                esResponse = performRequestSyncOrAsync(restClient, builder.build());
            performRequestSyncOrAsync(restClient, builder.build());
     * to make sure that the caller shows up in the exception. We use this
            try {
    }
                }
            // request level headers override default headers
    interface HttpClientListener {
                public void onSuccess(Response response) {
import java.net.SocketTimeoutException;
                fail("expected WarningFailureException from warnings");
                        return false;
 * compatible open source license.
            }
                }
                final Object entity = BodyUtils.getBody(request).map(List::of).cache().block();
                    }
/*
                    public Optional<SSLSession> sslSession() {
import org.apache.commons.logging.LogFactory;
        } else {
                        callback.complete((HttpResponse<T>) httpResponse);
    }
        assertDeprecationWarnings(
import java.io.StringWriter;
        for (String method : Arrays.asList("DELETE", "GET", "PATCH", "POST", "PUT", "TRACE")) {
import java.util.Set;
            assertFalse(esResponse.hasWarnings());
            bodyPublisher = BodyPublishers.ofString(randomAsciiAlphanumOfLengthBetween(10, 100));
            final CountDownLatch latch = new CountDownLatch(1);
            protected WarningsHandler warningsHandler() {
            for (Map.Entry<String, List<String>> requestHeader : requestHeaders.entrySet()) {
    /**
            this.httpClient,
        Request.Builder builder = Request.newRequest(method, "/200");
            strictDeprecationMode,
            try {
                throw new HttpTimeoutException(httpHost.toString());
                    exceptionRef.set(exception);
        int times = 0;
        } else {
     */
                    public boolean warningsShouldFailRequest(List<String> warnings) {
                    }
        failureListener.assertNotCalled();
            }
        builder = builder.withOptions(options);
            try {
                    Response response = restClient.performRequest(builder.build());
            expectFailure = warningOption.warningsHandler().warningsShouldFailRequest(warningBodyTexts);
import java.util.concurrent.CompletableFuture;
            for (int okStatusCode : getOkStatusCodes()) {
                        return request.headers();
        try {
                return WarningsHandler.STRICT;
            @Override
                    if (expectedIgnores.contains(errorStatusCode)) {
        HttpRequest.Builder expectedRequest = HttpRequest.newBuilder(uri).method(method, bodyPublisher);
                Arrays.stream(listeners).forEach(l -> l.onExecute(request, responseBodyHandler));
            }
            }
        return "299 OpenSearch-1.2.2-SNAPSHOT-" + hash + " \"" + warningBody + "\"";
    }
    public void testOkStatusCodes() throws Exception {
            }
            public <T> CompletableFuture<HttpResponse<T>> sendAsync(HttpRequest request, BodyHandler<T> responseBodyHandler) {
                return httpResponse;
                fail("request should have failed");
                    @Override
        void onExecute(HttpRequest requestProducer, BodyHandler<?> bodyHandler);
            } catch (RuntimeException e) {
            defaultHeaders,
            }
                    assertThat(BodyUtils.getBodyAsString(response), equalTo(body));
    public void testHeaders() throws Exception {
            builder = builder.withOptions(options);
                    }
            builder = builder.withParameter("ignore", ignore);
                Response response = performRequestSyncOrAsync(restClient, Request.newRequest(method, "/" + okStatusCode).build());
                return new WarningsHandler() {
        for (String warningHeaderText : warningHeaderTexts) {
        strictDeprecationMode = randomBoolean();
            }
        return httpClient;
                    latch.countDown();
                assertExceptionStackContainsCallingMethod(e);
    /**
import java.util.concurrent.TimeUnit;
                    if (i < numIgnores - 1) {
    }
            case "/soe":
    private static String formatWarningWithoutDate(String warningBody) {
                return sendAsync(request, responseBodyHandler).join();
    private boolean strictDeprecationMode;
                };
import java.net.http.HttpResponse.PushPromiseHandler;
import static org.junit.Assert.assertFalse;
            for (int errorStatusCode : getAllErrorStatusCodes()) {
                return Version.HTTP_1_1;
        }
        t.printStackTrace(new PrintWriter(stack));
            // randomly add some ignore parameter, which doesn't get sent as part of the request
    private static String formatWarning(String warningBody) {
import static org.opensearch.internal.httpclient.RestClientTestUtil.randomStatusCode;
            ) {
                        HttpResponse<?> httpResponse = responseOrException(request);
                        for (String warning : warnings) {
                fail("request should have failed");
                exec.submit(() -> {
    private static HttpResponse<?> responseOrException(HttpRequest request) throws Exception {
import java.util.HashSet;
        final boolean expectFailure;
            }
                        return request.version().orElse(Version.HTTP_1_1);
            NodeSelector.ANY,
            if (se.getClassName().equals(myMethod.getClassName()) && se.getMethodName().equals(myMethod.getMethodName())) {
            } catch (WarningFailureException e) {
                throw exceptionRef.get();
                return sendAsync(request, responseBodyHandler);
                    Request.Builder builder = Request.newRequest(method, "/" + errorStatusCode);
                header.getValue().forEach(v -> expectedRequest.header(header.getKey(), v));
                    @Override
            public Optional<Duration> connectTimeout() {
            @Override
                throw new RuntimeException();
        if (randomBoolean()) {
     */
    public void testPerformRequestExceptions() throws Exception {
            }
        assertDeprecationWarnings(singletonList("exact"), singletonList("exact"));
                response = e.getResponse();
                    @Override
import static org.junit.Assert.assertThat;
            @Override
            logger.info("checking warningOption=" + warningOption + " and warnings=" + warningBodyTexts);
     */
            @Override
            @Override
            .map(e -> e.getKey() + "=" + URLEncoder.encode(e.getValue(), StandardCharsets.UTF_8))
    static HttpClient mockHttpClient(final ExecutorService exec, final HttpClientListener... listeners) {
            String ignore = Integer.toString(randomFrom(RestClientTestUtil.getAllErrorStatusCodes()));
            assertEquals(expectedRequest.headers(), actualRequest.headers());
            assertHeaders(defaultHeaders, requestHeaders, esResponse.headers(), Collections.<String>emptySet());
                throw new SSLHandshakeException("");
        }
        },
                }
                    }
            }
            assertEquals(expectedRequest.uri(), actualRequest.uri());
            default:
            options.addHeaders(headers);
        }
        );
     */
                BodyHandler<T> responseBodyHandler,
    }
        STRICT {
                @Override
            protected WarningsHandler warningsHandler() {
     * whatever body it has received.
            public <T> CompletableFuture<HttpResponse<T>> sendAsync(
            }
     * Emulates OpenSearch's HeaderWarningLogger.formatWarning in simple
 * Tests for basic functionality of {@link RestHttpClient} against one single host: tests http requests being sent, headers,
            protected WarningsHandler warningsHandler() {
        for (String method : getHttpMethods()) {
                    }
import java.util.concurrent.ExecutorService;
        }
     * whatever headers it has received.
                assertThat(response.statusLine().statusCode(), equalTo(okStatusCode));
import javax.net.ssl.SSLParameters;
                }
        assertDeprecationWarnings(Arrays.asList("ignorable one", "and another"), Arrays.asList("ignorable one", "and another"));
            @Override
        }
        return expectedRequest.build();
        if (randomBoolean()) {
                fail("request should have failed");
import java.nio.channels.ClosedChannelException;
            case "/coe":
    private ExecutorService exec = Executors.newFixedThreadPool(1);
                });
                restClient.performRequest(Request.newRequest(method, "/closed").build());
                    }
                throw new SocketTimeoutException(httpHost.toString());
            if ("HEAD".equalsIgnoreCase(method)) {
            }
                PushPromiseHandler<T> pushPromiseHandler
        if (expectFailure) {
        URI uri = new URI("http", null, "localhost", 9200, uriAsString, additionalQuery, null);
            failureListener.assertCalled(singletonList(node));
 * body, different status codes and corresponding responses/exceptions.
            public Optional<CookieHandler> cookieHandler() {
    }
import java.util.stream.Collectors;
        }
                // And we do all that so the thrown exception has our method in the stacktrace
            public <T> HttpResponse<T> send(java.net.http.HttpRequest request, BodyHandler<T> responseBodyHandler) throws IOException,
    }
                return;
                fail("request should have failed");
                @Override
                        return statusCode;
            try {
            try {
    }
            }
    }
            // all good
            if (exceptionRef.get() != null) {
import java.util.HashMap;
            case "/handshake":
import java.net.URLEncoder;
import java.net.http.HttpHeaders;
                try {
                // And we do all that so the thrown exception has our method in the stacktrace
                Request request = Request.newRequest(method, "/" + okStatusCode).withEntity(entity).build();
    }
            .stream()
import java.net.http.HttpRequest;
                };
                requestHeader.getValue().forEach(v -> options.addHeader(requestHeader.getKey(), v));
            }
     */
                // And we do all that so the thrown exception has our method in the stacktrace
                assertThat(e.getCause(), instanceOf(URISyntaxException.class));
import java.util.concurrent.atomic.AtomicReference;
        PERMISSIVE {
                    Integer code = randomFrom(getAllErrorStatusCodes());
            final Map<String, List<String>> requestHeaders = RestClientTestUtil.randomHeaders(getRandom(), "Header");
        });
                    public URI uri() {
            response = performRequestSyncOrAsync(restClient, builder.build());
        if (randomBoolean()) {
                assertExceptionStackContainsCallingMethod(e);
    @SuppressWarnings("unchecked")
                    }
import java.net.http.HttpTimeoutException;
            }
        fail("didn't find the calling method (looks like " + myMethod + ") in:\n" + stack);
            } catch (RuntimeException e) {
                    assertExceptionStackContainsCallingMethod(e);
                return Optional.empty();
                expectedIgnores.add(404);
        final String hash = new String(new byte[40], StandardCharsets.UTF_8).replace('\0', 'e');
                restClient.performRequest(Request.newRequest(method, "/runtime").build());
import static org.opensearch.internal.httpclient.RestClientTestUtil.getHttpMethods;
            public SSLContext sslContext() {
     */
     * End to end test for request and response headers. Exercises the mock http client ability to send back
            });
        } else {
import java.io.IOException;
        if (getRandom().nextBoolean()) {
            }
        for (String method : getHttpMethods()) {
            restClient.performRequestAsync(request, new ResponseListener() {
            Arrays.asList(formatWarning(chars), "another one", "and another"),
     * that called this <strong>somewhere</strong> on its stack. This is
        assertDeprecationWarnings(singletonList("poorly formatted " + chars), singletonList("poorly formatted " + chars));
            }
                // And we do all that so the thrown exception has our method in the stacktrace
                    public HttpRequest request() {
                return null;
            for (int okStatusCode : getOkStatusCodes()) {
import java.net.CookieHandler;
                restClient.performRequest(Request.newRequest(method, "/coe").build());
    }
import javax.net.ssl.SSLSession;
    public void testPerformRequestRuntimeExceptions() throws Exception {
            singletonList(node),
                    public boolean warningsShouldFailRequest(List<String> warnings) {
            public SSLParameters sslParameters() {
        String method = randomFrom(getHttpMethods());
                Object actualEntity = BodyUtils.getBody(actualRequest).block();
                    public Object body() {
        // 0 is getStackTrace
    }
        assertDeprecationWarnings(Collections.<String>emptyList(), Collections.<String>emptyList());
        defaultHeaders = RestClientTestUtil.randomHeaders(getRandom(), "Header-default");
        StackTraceElement myMethod = Thread.currentThread().getStackTrace()[2];
import java.net.http.HttpResponse;
                    if (false == ignoreParam.isEmpty()) {
                throw new URISyntaxException("", "");
 */
                        assertEquals(errorStatusCode, response.statusLine().statusCode());
                    @Override
                    @Override
            failureListener,
        RequestOptions.Builder options = RequestOptions.DEFAULT.toBuilder();
            DeprecationWarningOption warningOption = randomFrom(DeprecationWarningOption.values());
                    public Optional<HttpResponse<Object>> previousResponse() {
                restClient.performRequest(Request.newRequest(method, "/handshake").build());
                    fail("request should have failed");
                }
    private enum DeprecationWarningOption {
                    @Override
                    } else {
                fail("request should have failed");
            HttpRequest actualRequest = requestProducerCapture.get();
    }
                    assertThat(e.getMessage(), containsString("\nWarnings: " + warningBodyTexts));
     * cases. We don't have that available because we're testing against 1.7.
    /**
import java.net.http.HttpClient.Version;
        if (randomBoolean()) {
            }
            requests.increment();
