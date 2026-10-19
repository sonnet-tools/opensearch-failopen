        assertDeprecationWarnings(singletonList(formatWarning(chars)), singletonList(chars));
        }
                return httpResponse;
import java.net.http.HttpTimeoutException;  
                Request request = Request.newRequest(method, "/" + okStatusCode).withEntity(entity).build();
    }
            }  
        assertDeprecationWarnings(singletonList(formatWarningWithoutDate(chars)), singletonList(chars));  
            }  
import java.util.Collections;
                    public Version version() {
            if (randomBoolean()) {
                    @Override
            case "/uri":
        protected abstract WarningsHandler warningsHandler();  
import java.net.http.HttpHeaders;
        final HttpHost httpHost = new HttpHost(request.uri().getScheme(), request.uri().getHost(), request.uri().getPort());  
 * Relies on a mock http client to intercept requests and return desired responses based on request path.  
            try {
    }
            } catch (SSLHandshakeException e) {  
            }
            }  
            Arrays.asList(formatWarning(chars), "another one", "and another"),  
                fail("expected WarningFailureException from warnings");  
                assertExceptionStackContainsCallingMethod(e);  
                }
        URI uri = new URI("http", null, "localhost", 9200, uriAsString, additionalQuery, null);
            protected WarningsHandler warningsHandler() {
        builder = builder.withOptions(options);  
 */
                restClient.performRequest(Request.newRequest(method, "/uri").build());  
            expectFailure = warningOption.warningsHandler().warningsShouldFailRequest(warningBodyTexts);
 *
                response = e.getResponse();  
        restClient = new RestHttpClient(  
 * body, different status codes and corresponding responses/exceptions.
            .stream()
        if (randomBoolean()) {
        if (randomBoolean()) {  
import java.net.http.HttpRequest;  
            case "/runtime":  
import static org.junit.Assert.assertFalse;
    @SuppressWarnings("unchecked")
                // And we do all that so the thrown exception has our method in the stacktrace
            if (expectedEntity != null) {
            for (int okStatusCode : getOkStatusCodes()) {
            for (Map.Entry<String, List<String>> requestHeader : requestHeaders.entrySet()) {
            // IOExceptions should be let bubble up  
     */  
import java.util.concurrent.atomic.LongAdder;
        assertDeprecationWarnings(singletonList("exact"), singletonList("exact"));
                    }
                return WarningsHandler.STRICT;
        );  
     * Verifies the content of the {@link HttpRequest} that's internally created and passed through to the http client
            builder = builder.withOptions(options);
                }
                    assertThat(BodyUtils.getBodyAsString(response), equalTo(body));  
        // 2 is the caller, what we want
        },  
            public SSLParameters sslParameters() {
import static org.opensearch.internal.httpclient.RestClientTestUtil.getAllErrorStatusCodes;  
        switch (request.uri().getPath()) {
                    @Override
        }  
        return "299 OpenSearch-1.2.2-SNAPSHOT-" + hash + " \"" + warningBody + "\"";  
                return;
        fail("didn't find the calling method (looks like " + myMethod + ") in:\n" + stack);
import java.util.stream.Collectors;  
public class RestHttpClientSingleHostTests extends RestHttpClientTestCase {
            @Override
    private HostsTrackingFailureListener failureListener;
            if (exceptionRef.get() != null) {
import java.util.Optional;
            failureListener.assertCalled(singletonList(node));
import java.net.URLEncoder;
     * to make sure that the caller shows up in the exception. We use this
    }
import java.util.TreeSet;  
                                return true;
import java.net.Authenticator;
                    @Override  
import java.nio.channels.ClosedChannelException;
        if (expectFailure) {  
                        return request.headers();
                    @Override
                fail("request should have failed");  
            protected WarningsHandler warningsHandler() {
                    }
                    public Object body() {
    public void createRestClient() {
            public Optional<CookieHandler> cookieHandler() {  
            Map<String, List<String>> headers = RestClientTestUtil.randomHeaders(getRandom(), "Header");  
                requestHeader.getValue().forEach(v -> options.addHeader(requestHeader.getKey(), v));  
     * End to end test for error status codes: they should cause an exception to be thrown, apart from 404 with HEAD requests
                    restClient.performRequest(request);
        }
import java.io.IOException;
            }
        int times = 0;  
    @After
                    public boolean warningsShouldFailRequest(List<String> warnings) {
import java.net.ProxySelector;
    }
                    public HttpRequest request() {
            @Override  
            RequestOptions.Builder options = RequestOptions.DEFAULT.toBuilder();
            for (int errorStatusCode : getAllErrorStatusCodes()) {
    private void assertDeprecationWarnings(List<String> warningHeaderTexts, List<String> warningBodyTexts) throws Exception {  
                builder = builder.withParameter(name, value);
            singletonList(node),  
                } else {  
        });
        Map<String, String> params = new HashMap<>();
                // And we do all that so the thrown exception has our method in the stacktrace
                header.getValue().forEach(v -> expectedRequest.header(header.getKey(), v));
        if (randomBoolean()) {  
                        throw e;
    public void testPerformRequestExceptions() throws Exception {  
                assertExceptionStackContainsCallingMethod(e);  
            response = performRequestSyncOrAsync(restClient, builder.build());  
import java.net.CookieHandler;  
            ) {
import javax.net.ssl.SSLHandshakeException;
            public Optional<ProxySelector> proxy() {  
            for (int i = 0; i < numParams; i++) {
import org.apache.commons.logging.LogFactory;
            }
                fail("request should have failed");
                return null;
import java.net.http.HttpResponse;  
                        fail("request should have failed");
import static org.hamcrest.CoreMatchers.instanceOf;  
        Request.Builder builder = Request.newRequest(method, "/200");
    interface HttpClientListener {  
            if ("HEAD".equalsIgnoreCase(method)) {
            case "/coe":
            public Optional<Executor> executor() {
                    @Override
            failureListener.assertCalled(singletonList(node));
        StackTraceElement myMethod = Thread.currentThread().getStackTrace()[2];  
        exec.shutdown();
    public void testOkStatusCodes() throws Exception {  
    public void testErrorStatusCodes() throws Exception {
package org.opensearch.internal.httpclient;
import static java.util.Collections.singletonList;
            public Version version() {  
                expectedIgnores.add(404);  
        // 0 is getStackTrace  
            @Override  
    }
            assertEquals(expectedRequest.headers(), actualRequest.headers());
        }
            assertThat(esResponse.statusLine().statusCode(), equalTo(statusCode));  
                restClient.performRequest(Request.newRequest(method, "/runtime").build());
                // And we do all that so the thrown exception has our method in the stacktrace
            String ignore = Integer.toString(randomFrom(RestClientTestUtil.getAllErrorStatusCodes()));
            }  
        for (StackTraceElement se : t.getStackTrace()) {
        node = new Node(new HttpHost("http", "localhost", 9200));  
                throw new IOException(httpHost.toString());
    private static final Log logger = LogFactory.getLog(RestHttpClientSingleHostTests.class);  
        } else {
        EXACT {
        final Set<String> uniqueNames = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
            @Override  
    private ExecutorService exec = Executors.newFixedThreadPool(1);
                    }
            public <T> CompletableFuture<HttpResponse<T>> sendAsync(HttpRequest request, BodyHandler<T> responseBodyHandler) {
                Request request = Request.newRequest(method, "/" + errorStatusCode).withEntity(entity).build();
import java.util.HashMap;  
            case "/handshake":
        for (String method : getHttpMethods()) {
            String ignoreParam = "";
                Arrays.stream(listeners).forEach(l -> l.onExecute(request, responseBodyHandler));
            }
    public void testPerformRequestIOExceptions() throws Exception {
            }
                    assertExceptionStackContainsCallingMethod(e);
            for (Map.Entry<String, List<String>> header : headers.entrySet()) {  
                throw new URISyntaxException("", "");
        for (String method : getHttpMethods()) {
                    if (expectedIgnores.contains(errorStatusCode)) {  
                performRequestSyncOrAsync(restClient, builder.build());
                throw new HttpTimeoutException(httpHost.toString());  
            }  
                        return request.uri();
                return sendAsync(request, responseBodyHandler);  
            // error status codes should cause an exception to be thrown
            }  
            public <T> CompletableFuture<HttpResponse<T>> sendAsync(
     */
            public boolean awaitTermination(Duration duration) throws InterruptedException {
        } else {  
     */  
                    responseRef.set(response);
                    exceptionRef.set(exception);
    @SuppressWarnings("unchecked")
import java.util.concurrent.TimeUnit;  
            NodeSelector.ANY,  
            public Optional<Authenticator> authenticator() {
                    }
        }
                restClient.performRequest(Request.newRequest(method, "/handshake").build());
        Request.Builder builder = Request.newRequest(method, uriAsString);  
    @Before  
                assertEquals(expectedEntity, actualEntity);
        strictDeprecationMode = randomBoolean();
                        ignoreParam += ",";  
            failureListener.assertCalled(singletonList(node));  
        }  
                return null;
            .map(e -> e.getKey() + "=" + URLEncoder.encode(e.getValue(), StandardCharsets.UTF_8))
                return Optional.empty();
            }
                if (errorStatusCode <= 500 || expectedIgnores.contains(errorStatusCode)) {
     * End to end test for ok status codes
        assertDeprecationWarnings(Arrays.asList("ignorable one", "and another"), Arrays.asList("ignorable one", "and another"));  
            }  
        final String hash = new String(new byte[40], StandardCharsets.UTF_8).replace('\0', 'e');
            case "/closed":  
    }
    /**
            .collect(Collectors.joining("&"));  
                }
        assertEquals(warningBodyTexts, response.warnings());  
            }
                uniqueNames.add(header.getKey());
                fail("request should have failed");
                return sendAsync(request, responseBodyHandler).join();  
import javax.net.ssl.SSLSession;  
     * Asserts that the provided {@linkplain Exception} contains the method  
    }
    }  
            return responseRef.get();
            assertEquals(expectedRequest.method(), actualRequest.method());
            }  
            @Override  
    static HttpClient mockHttpClient(final ExecutorService exec, final HttpClientListener... listeners) {
        String proxyWarning = "112 - \"network down\" \"Sat, 25 Aug 2012 23:34:45 GMT\"";
import java.util.Map;  
import org.junit.Before;
import java.util.Arrays;
                try {  
        }  
            Response esResponse;  
                fail("request should have failed");  
                    Request.Builder builder = Request.newRequest(method, "/" + errorStatusCode);
            }
    /**  
import java.net.URI;  
            case "/ioe":
        }
import static org.hamcrest.CoreMatchers.containsString;
            assertEquals(expectedRequest.uri(), actualRequest.uri());  
            public Optional<Duration> connectTimeout() {
        PERMISSIVE {  
                        HttpResponse<?> httpResponse = responseOrException(request);
    /**
 * this file be licensed under the Apache-2.0 license or a
                Response response = performRequestSyncOrAsync(restClient, Request.newRequest(method, "/" + okStatusCode).build());  
                    }
            public <T> HttpResponse<T> send(java.net.http.HttpRequest request, BodyHandler<T> responseBodyHandler) throws IOException,
            }
        if (randomBoolean()) {
                        return request.version().orElse(Version.HTTP_1_1);  
    }  
            failureListener.assertCalled(singletonList(node));
            Request.Builder builder = Request.newRequest(method, "/" + statusCode);  
            requests.increment();
                // And we do all that so the thrown exception has our method in the stacktrace
            });
            assertFalse(esResponse.hasWarnings());
            }  
        } catch (Exception e) {
import java.net.http.HttpResponse.BodyHandler;
        }
            }
            expectFailure = strictDeprecationMode && false == warningBodyTexts.isEmpty();
     * cases. We don't have that available because we're testing against 1.7.
    private HttpClient httpClient;  
                @Override  
                String name = "param-" + i;  
                    @Override
                throw new SocketTimeoutException(httpHost.toString());
                assertThat(e.getCause(), instanceOf(URISyntaxException.class));  
        assertDeprecationWarnings(Collections.<String>emptyList(), Collections.<String>emptyList());
                ignore += "," + randomFrom(RestClientTestUtil.getAllErrorStatusCodes());
import static org.junit.Assert.assertThat;  
            try {  
     * Emulates OpenSearch's HeaderWarningLogger.formatWarning in simple
     */
        RequestOptions.Builder options = RequestOptions.DEFAULT.toBuilder();  
            // randomly add some ignore parameter, which doesn't get sent as part of the request
    /**
        for (String method : getHttpMethods()) {  
                        }
        final boolean expectFailure;
        } else {  
            } catch (ClosedChannelException e) {
                    expectedIgnores.add(code);  
                    failureListener.assertNotCalled();
                    } catch (Exception e) {
            protected WarningsHandler warningsHandler() {
            }
        try {  
            @Override
    /**  
                final Object entity = BodyUtils.getBody(request).map(List::of).cache().block();  
                // And we do all that so the thrown exception has our method in the stacktrace
                    }
        }  
        BodyPublisher entity = BodyPublishers.ofString(body);
            builder = builder.withParameter("ignore", ignore);  
     */
            } catch (IOException e) {
            try {
        failureListener.assertNotCalled();
                    public Optional<HttpResponse<Object>> previousResponse() {
                public void onFailure(Exception exception) {
                // And we do all that so the thrown exception has our method in the stacktrace  
                return new WarningsHandler() {  
            Arrays.asList(chars, "another one", "and another")
                throw new RuntimeException();
                // return the same body that was sent
     * synchronous calls by performing asynchronous calls and blocking the  
                return callback;
            }  
            builder = builder.withEntity(bodyPublisher);  
        }
        }
    }  
                        builder = builder.withParameter("ignore", ignoreParam);  
                } catch (ResponseException e) {  
                    assertThat(e.getMessage(), containsString("\nWarnings: " + warningBodyTexts));
import java.util.Set;
import org.junit.After;  
    }  
                        return (T) httpResponse;  
    }
 * SPDX-License-Identifier: Apache-2.0
            RequestOptions.Builder options = RequestOptions.DEFAULT.toBuilder();
        t.printStackTrace(new PrintWriter(stack));
    }  
            options.addHeaders(headers);
            }
                }
        assertDeprecationWarnings(singletonList(proxyWarning), singletonList(proxyWarning));
import static org.junit.Assert.assertEquals;
            protected WarningsHandler warningsHandler() {  
    static Response performRequestSyncOrAsync(RestHttpClient restClient, Request request) throws Exception {
import java.util.concurrent.CountDownLatch;
            defaultHeaders,
            Set<Integer> expectedIgnores = new HashSet<>();  
        }
                assertExceptionStackContainsCallingMethod(e);
            public SSLContext sslContext() {
import java.util.concurrent.Executors;
                restClient.performRequest(Request.newRequest(method, "/closed").build());
    private static String formatWarning(String warningBody) {  
        FILTERED {
        Response response;
        assertDeprecationWarnings(
    }
        for (String warningHeaderText : warningHeaderTexts) {
                fail("request should have failed");
     * Shutdown the executor so we don't leak threads into other test runs.  
                        return entity;  
        }
            int numParams = randomIntBetween(1, 3);
            assertThat(requests.intValue(), equalTo(++times));  
                    @Override
                for (int i = 0; i < numIgnores; i++) {
        String body = "{ \"field\": \"value\" }";
                    }
import java.net.http.HttpResponse.PushPromiseHandler;
            final int statusCode = randomStatusCode(getRandom());
                return;  
                        return false;
    }  
                    fail("request should have failed");
            performRequestSyncOrAsync(restClient, builder.build());
    public void testPerformRequestRuntimeExceptions() throws Exception {
        failureListener = new HostsTrackingFailureListener();
                defaultHeader.getValue().forEach(v -> expectedRequest.header(defaultHeader.getKey(), v));  
                esResponse = performRequestSyncOrAsync(restClient, builder.build());
                esResponse = e.getResponse();
                    ignoreParam += code;
    private AtomicReference<HttpRequest> requestProducerCapture;
            final AtomicReference<Exception> exceptionRef = new AtomicReference<>();
            @Override  
import java.io.PrintWriter;  
 * Tests for basic functionality of {@link RestHttpClient} against one single host: tests http requests being sent, headers,
    /**
        }
        STRICT {
            if (randomBoolean()) {  
                restClient.performRequest(Request.newRequest(method, "/coe").build());
                    if (false == ignoreParam.isEmpty()) {
                    Integer code = randomFrom(getAllErrorStatusCodes());
        HttpClient httpClient = new HttpClient() {  
            } catch (ResponseException e) {  
        // randomize between sync and async methods  
import org.apache.commons.logging.Log;
    private static HttpResponse<?> responseOrException(HttpRequest request) throws Exception {
import javax.net.ssl.SSLParameters;
            public Redirect followRedirects() {
import static org.opensearch.internal.httpclient.RestClientTestUtil.randomStatusCode;  
            DeprecationWarningOption warningOption = randomFrom(DeprecationWarningOption.values());
    private HttpRequest performRandomRequest(String method) throws Exception {
        assertDeprecationWarnings(singletonList("poorly formatted " + chars), singletonList("poorly formatted " + chars));
     * End to end test for request and response headers. Exercises the mock http client ability to send back
        for (Map.Entry<String, List<String>> defaultHeader : defaultHeaders.entrySet()) {  
                return WarningsHandler.PERMISSIVE;
                PushPromiseHandler<T> pushPromiseHandler
            }
     */
        for (String method : Arrays.asList("DELETE", "GET", "PATCH", "POST", "PUT", "TRACE")) {  
        // return the desired status code or exception depending on the path
                    assertExceptionStackContainsCallingMethod(e);
            failureListener.assertCalled(singletonList(node));
        StringWriter stack = new StringWriter();  
import java.util.concurrent.Executor;  
            assertHeaders(defaultHeaders, requestHeaders, esResponse.headers(), Collections.<String>emptySet());
import java.util.concurrent.ExecutorService;
                    }  
            }
                    Response response = e.getResponse();
                        return false == warnings.equals(Arrays.asList("exact"));  
            }
            }
                        for (String warning : warnings) {  
    public void testBody() throws Exception {  
            return restClient.performRequest(request);
                    } else {  
                        assertEquals(errorStatusCode, response.statusLine().statusCode());
                exec.submit(() -> {
                    try {  
            HttpRequest actualRequest = requestProducerCapture.get();
        };  
                    assertEquals(errorStatusCode, e.getResponse().statusLine().statusCode());
    public void shutdownExec() {  
            try {
        HttpRequest.Builder expectedRequest = HttpRequest.newBuilder(uri).method(method, bodyPublisher);  
        if (randomBoolean()) {  
        final String additionalQuery = params.entrySet()  
                params.put(name, value);  
                InterruptedException {
        String chars = randomAsciiAlphanumOfLength(5);
                }
            }
                int statusCode = Integer.parseInt(request.uri().getPath().substring(1));  
     * whatever body it has received.
        }  
import java.net.http.HttpRequest.BodyPublishers;
        String method = randomFrom(getHttpMethods());
            // all good  
    /**
    }  
            }
            @Override
                assertExceptionStackContainsCallingMethod(e);
                fail("request should have failed");
        if (getRandom().nextBoolean()) {
import static org.junit.Assert.fail;
        for (String httpMethod : getHttpMethods()) {
        }
                        callback.completeExceptionally(e);
            failureListener.assertCalled(singletonList(node));
/**  
import static org.opensearch.internal.httpclient.RestClientTestUtil.getHttpMethods;
            if (uniqueNames.contains(defaultHeader.getKey()) == false) {
    private enum DeprecationWarningOption {
                            if (false == warning.startsWith("ignorable")) {
            case "/soe":  
            false
    /**
    }
                return Optional.empty();
import java.nio.charset.StandardCharsets;
            this.httpClient,
                return new WarningsHandler() {  
                        return null;  
                };
                    latch.countDown();
                    assertThat(response.statusLine().statusCode(), equalTo(errorStatusCode));
    private Map<String, List<String>> defaultHeaders;
            }  
import java.util.HashSet;
        for (String method : getHttpMethods()) {
            @Override
                });
                assertThat(response.statusLine().statusCode(), equalTo(okStatusCode));
        },  
                try {  
                        callback.complete((HttpResponse<T>) httpResponse);
            try {
        return httpClient;
                    @Override  
        httpClient = mockHttpClient(exec, (requestProducer, bodyHandler) -> {
import java.net.SocketTimeoutException;
                return Optional.of(exec);  
                        return statusCode;
                throw new ClosedChannelException();
                        // no exception gets thrown although we got an error status code, as it was configured to be ignored
    private boolean strictDeprecationMode;
}
                java.net.http.HttpRequest request,
                return Version.HTTP_1_1;
            logger.info("checking warningOption=" + warningOption + " and warnings=" + warningBodyTexts);
import java.net.http.HttpClient.Version;
            }
                    }
                        return request;  
                assertExceptionStackContainsCallingMethod(e);
        assertEquals(false == warningBodyTexts.isEmpty(), response.hasWarnings());
        String uriAsString = "/" + randomStatusCode(getRandom());
            }
        for (String method : getHttpMethods()) {
import java.net.http.HttpClient;  
            @Override
            } catch (HttpTimeoutException e) {  
                return Optional.empty();
            null,
            for (int errorStatusCode : getAllErrorStatusCodes()) {
            options.addHeader("Warning", warningHeaderText);
                throw new SSLHandshakeException("");  
        BodyPublisher bodyPublisher = BodyPublishers.noBody();  
            builder = builder.withOptions(options);
                    }
                final CompletableFuture<HttpResponse<T>> callback = new CompletableFuture<>();
                } catch (ResponseException e) {  
                    public Optional<SSLSession> sslSession() {
    private static String formatWarningWithoutDate(String warningBody) {
                @Override
            }  
                }
            Object expectedEntity = BodyUtils.getBody(expectedRequest).block();
            requestProducerCapture.set(requestProducer);  
            final CountDownLatch latch = new CountDownLatch(1);  
                restClient.performRequest(Request.newRequest(method, "/ioe").build());
        requests = new LongAdder();
            @Override
    }
            HttpRequest expectedRequest = performRandomRequest(httpMethod);
            } catch (WarningFailureException e) {
            bodyPublisher = BodyPublishers.ofString(randomAsciiAlphanumOfLengthBetween(10, 100));
            for (int okStatusCode : getOkStatusCodes()) {
    }
     */  
    private Node node;
                assertThat(BodyUtils.getBodyAsString(response), equalTo(body));
                Object actualEntity = BodyUtils.getBody(actualRequest).block();  
                fail("request should have failed");  
                    }
                int numIgnores = randomIntBetween(1, 3);  
 * The OpenSearch Contributors require contributions made to  
        },
     * that called this <strong>somewhere</strong> on its stack. This is
                String value = randomAsciiAlphanumOfLengthBetween(3, 10);
                    public int statusCode() {  
                assertThat(response.statusLine().statusCode(), equalTo(okStatusCode));
            failureListener,
import java.io.StringWriter;
        );
                    if (i < numIgnores - 1) {
     * current thread until the call returns so it has to take special care
     */
            @Override
import java.util.concurrent.atomic.AtomicReference;
                assertExceptionStackContainsCallingMethod(e);  
            options.setWarningsHandler(warningOption.warningsHandler());  
                restClient.performRequest(Request.newRequest(method, "/soe").build());  
                    latch.countDown();  
/*  
            logger.info("checking strictWarningsMode=[" + strictDeprecationMode + "] and warnings=" + warningBodyTexts);
            default:
                BodyHandler<T> responseBodyHandler,  
            }
            restClient.performRequestAsync(request, new ResponseListener() {
    }  
                // And we do all that so the thrown exception has our method in the stacktrace
            try {  
                    @Override
                throw exceptionRef.get();
        }
    public void testInternalHttpRequest() throws Exception {
        };
     * normally the case for synchronous calls but {@link RestHttpClient} performs
                        return Optional.empty();
            failureListener.assertCalled(singletonList(node));
 * compatible open source license.
import java.net.http.HttpRequest.BodyPublisher;
        requestProducerCapture = new AtomicReference<>();  
     * End to end test for request and response body. Exercises the mock http client ability to send back  
        return expectedRequest.build();
            }
            }
            try {
                };
            @Override  
                    @Override
            latch.await();  
                        return Optional.empty();
     * assertion to make sure that we don't break that "special care".  
            } catch (RuntimeException e) {
                    if (expectedIgnores.contains(errorStatusCode)) {
            }  
                    }
                }  
                public void onSuccess(Response response) {  
                return exec.awaitTermination(duration.toMillis(), TimeUnit.MILLISECONDS);  
                    }  
                if (false == warningBodyTexts.isEmpty()) {  
import java.util.List;
import static org.opensearch.internal.httpclient.RestClientTestUtil.getOkStatusCodes;
import java.net.URISyntaxException;
     * whatever headers it has received.  
                    failureListener.assertCalled(singletonList(node));
                };
import java.time.Duration;  
import static org.hamcrest.CoreMatchers.equalTo;
        // 1 is this method
                    }  
    private RestHttpClient restClient;  
            // request level headers override default headers
        return formatWarningWithoutDate(warningBody) + " \"Mon, 01 Jan 2001 00:00:00 GMT\"";
            } catch (RuntimeException e) {
                    public URI uri() {  
        void onExecute(HttpRequest requestProducer, BodyHandler<?> bodyHandler);
import java.util.concurrent.CompletableFuture;
            } catch (SocketTimeoutException e) {
            }  
    public void testDeprecationWarnings() throws Exception {  
        }
    private static void assertExceptionStackContainsCallingMethod(Throwable t) {
            }
                    Response response = restClient.performRequest(builder.build());
        defaultHeaders = RestClientTestUtil.randomHeaders(getRandom(), "Header-default");
                Response response = restClient.performRequest(request);  
                assertExceptionStackContainsCallingMethod(e);
            final Map<String, List<String>> requestHeaders = RestClientTestUtil.randomHeaders(getRandom(), "Header");
                    }  
                return Optional.empty();  
                final HttpResponse<?> httpResponse = new HttpResponse<>() {
                            }  
            }
            try {
    public void testHeaders() throws Exception {
import javax.net.ssl.SSLContext;  
                    public HttpHeaders headers() {  
                return null;  
    }
            try {
            }
                    public boolean warningsShouldFailRequest(List<String> warnings) {
    private LongAdder requests;  
            if (se.getClassName().equals(myMethod.getClassName()) && se.getMethodName().equals(myMethod.getMethodName())) {
        }
            final AtomicReference<Response> responseRef = new AtomicReference<>();
        for (String method : getHttpMethods()) {  
 */  
            strictDeprecationMode,
