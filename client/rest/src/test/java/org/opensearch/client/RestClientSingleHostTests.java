        Request request = new Request(method, uriAsString);
            // randomly add some ignore parameter, which doesn't get sent as part of the request
import org.junit.After;
        String body = "{ \"field\": \"value\" }";
                fail("request should have failed");
                    latch.countDown();
                int statusCode = Integer.parseInt(request.getRequestUri().substring(1));
                options.addHeader(header.getName(), header.getValue());
                    }
        RequestOptions.Builder options = request.getOptions().toBuilder();
 * You may obtain a copy of the License at
            for (Header requestHeader : requestHeaders) {
        // 1 is this method
            try {
                    }
import org.apache.hc.core5.http.nio.AsyncResponseConsumer;
        for (String method : getHttpMethods()) {
import org.apache.hc.core5.http.nio.HandlerFactory;
        }
                return new WarningsHandler() {
        failureListener = new HostsTrackingFailureListener();
        StackTraceElement myMethod = Thread.currentThread().getStackTrace()[2];
                    assertTrue("the entity is not repeatable, cannot set it to the response directly", entity.isRepeatable());
            failureListener.assertCalled(singletonList(node));
    static Response performRequestSyncOrAsync(RestClient restClient, Request request) throws Exception {
    private CloseableHttpAsyncClient httpClient;
import org.junit.Before;
     */
            }
     * End to end test for ok status codes
                expectedIgnores.add(404);
                return httpResponse;
    private Node node;
            final AtomicReference<Response> responseRef = new AtomicReference<>();
            try {
                options.addHeader(requestHeader.getName(), requestHeader.getValue());
    public void testOkStatusCodes() throws Exception {
                    expectedIgnores.add(code);
    }
 * this file be licensed under the Apache-2.0 license or a
/*
                            if (false == warning.startsWith("ignorable")) {
    private static ClassicHttpResponse responseOrException(AsyncRequestProducer requestProducer) throws Exception {
        } else {
        for (Header defaultHeader : defaultHeaders) {
                Response response = performRequestSyncOrAsync(restClient, new Request(method, "/" + okStatusCode));
        EXACT {
            HttpEntity expectedEntity = expectedRequest.getEntity();
    public void testErrorStatusCodes() throws Exception {
import static org.junit.Assert.assertTrue;
        } catch (Exception e) {
    /**
                break;
            latch.await();
        switch (request.getRequestUri()) {
    /**
            protected <T> Future<T> doExecute(
}
                    ignoreParam += code;
    private void assertDeprecationWarnings(List<String> warningHeaderTexts, List<String> warningBodyTexts) throws Exception {
                return;
                try {
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
            }
                break;
        exec.shutdown();
import org.apache.hc.core5.http.ClassicHttpResponse;
            // IOExceptions should be let bubble up
        protected abstract WarningsHandler warningsHandler();
                    if (expectedIgnores.contains(errorStatusCode)) {
        );
                break;
                    failureListener.assertNotCalled();
                                return true;
            RequestOptions.Builder options = request.getOptions().toBuilder();
            FutureCallback<?> callback
        };
        final Set<String> uniqueNames = new HashSet<>();
    private static void assertExceptionStackContainsCallingMethod(Throwable t) {
            }
import java.util.concurrent.Future;
                assertExceptionStackContainsCallingMethod(e);
    /**
    public void testPerformRequestRuntimeExceptions() throws Exception {
            ClassicHttpRequest actualRequest = getRequest(requestProducerCapture.get());
        if (randomBoolean()) {
            Header[] headers = RestClientTestUtil.randomHeaders(getRandom(), "Header");
 *
        }
            }
                throw new RuntimeException();
        }
 *
            failureListener,
            Response esResponse;
            HandlerFactory<AsyncPushConsumer> pushHandlerFactory,
        }
        }
            try {
                HttpHost target,
            } catch (ResponseException e) {
        for (String method : getHttpMethods()) {
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
    }
                HttpEntity entity = request.getEntity();
                // Call the callback asynchronous to better simulate how async http client works
            } catch (RuntimeException e) {
        for (String method : getHttpMethods()) {
        // randomize between sync and async methods
        assertDeprecationWarnings(singletonList("poorly formatted " + chars), singletonList("poorly formatted " + chars));
                return exec.submit(() -> {
                            callback.failed(e);
import java.util.concurrent.ExecutorService;
import org.apache.hc.core5.http.protocol.HttpContext;
    }
                assertThat(e.getMessage(), equalTo(method + " requests may not include an entity."));
    private HttpUriRequest performRandomRequest(String method) throws Exception {
            singletonList(node),
    /**
            false,
 * SPDX-License-Identifier: Apache-2.0
    }
            }
            response = performRequestSyncOrAsync(restClient, request);
 * Licensed to Elasticsearch under one or more contributor
     * assertion to make sure that we don't break that "special care".
import static org.opensearch.client.RestClientTestUtil.randomStatusCode;
import static org.junit.Assert.assertThat;
 * Tests for basic functionality of {@link RestClient} against one single host: tests http requests being sent, headers,
        }
            failureListener.assertCalled(singletonList(node));
        // 0 is getStackTrace
                for (int i = 0; i < numIgnores; i++) {
            final Header[] requestHeaders = RestClientTestUtil.randomHeaders(getRandom(), "Header");
        }
                throw exceptionRef.get();
        for (String method : getHttpMethods()) {
     */
import static org.junit.Assert.fail;
        defaultHeaders = RestClientTestUtil.randomHeaders(getRandom(), "Header-default");
import org.apache.commons.logging.LogFactory;
            @Override
                restClient.performRequest(new Request(method, "/ioe"));
            });
        failureListener.assertNotCalled();
import javax.net.ssl.SSLHandshakeException;
            }
            try {
        }
    public void testPerformRequestIOExceptions() throws Exception {
     * End to end test for request and response body. Exercises the mock http client ability to send back
    }
     * current thread until the call returns so it has to take special care
import org.apache.hc.client5.http.classic.methods.HttpPut;
import java.util.concurrent.Executors;
                return WarningsHandler.STRICT;
                throw new ConnectionClosedException();
                assertThat(e.getCause(), instanceOf(URISyntaxException.class));
import org.apache.hc.core5.function.Supplier;
                    assertExceptionStackContainsCallingMethod(e);
     * Asserts that the provided {@linkplain Exception} contains the method
     * whatever body it has received.
        assertDeprecationWarnings(Arrays.asList("ignorable one", "and another"), Arrays.asList("ignorable one", "and another"));
            @Override
            }
    }
            }
        assertDeprecationWarnings(singletonList(formatWarning(chars)), singletonList(chars));
                    Integer code = randomFrom(getAllErrorStatusCodes());
            String ignoreParam = "";
        FILTERED {
 * The OpenSearch Contributors require contributions made to
import org.apache.hc.client5.http.classic.methods.HttpTrace;
            public void close(CloseMode closeMode) {}
            @Override
                break;
            failureListener.assertCalled(singletonList(node));
                break;
    }
 */
                    assertEquals(errorStatusCode, e.getResponse().getStatusLine().getStatusCode());
                int numIgnores = randomIntBetween(1, 3);
                esResponse = performRequestSyncOrAsync(restClient, request);
    static CloseableHttpAsyncClient mockHttpClient(final ExecutorService exec, final CloseableHttpAsyncClientListener... listeners) {
    private enum DeprecationWarningOption {
                fail("request should have failed");
import org.apache.hc.core5.http.ClassicHttpRequest;
        for (String method : getHttpMethods()) {
            logger.info("checking strictWarningsMode=[" + strictDeprecationMode + "] and warnings=" + warningBodyTexts);
            if (randomBoolean()) {
            // all good
import java.net.URI;
            expectFailure = strictDeprecationMode && false == warningBodyTexts.isEmpty();
            options.addHeader("Warning", warningHeaderText);
                assertExceptionStackContainsCallingMethod(e);
                Request request = new Request(method, "/" + okStatusCode);
/*
            case "/coe":
        PERMISSIVE {
            } catch (IllegalStateException e) {
        }
            case "/uri":
                expectedRequest = new HttpHead(uri);
            }
        }
            return restClient.performRequest(request);
                break;
        assertThat(requestProducer, instanceOf(HttpUriRequestProducer.class));
        String chars = randomAsciiAlphanumOfLength(5);
    private HostsTrackingFailureListener failureListener;
import static org.opensearch.client.RestClientTestUtil.getAllErrorStatusCodes;
 * license agreements. See the NOTICE file distributed with
                    if (false == ignoreParam.isEmpty()) {
import java.util.Set;
            final AtomicReference<Exception> exceptionRef = new AtomicReference<>();
        StringWriter stack = new StringWriter();
        return "299 OpenSearch-1.2.2-SNAPSHOT-" + hash + " \"" + warningBody + "\"";
            default:
                assertThat(EntityUtils.toString(response.getEntity()), equalTo(body));
        }
import java.util.concurrent.atomic.LongAdder;
            case "OPTIONS":
    /**
 * compatible open source license.
import org.apache.hc.core5.http.io.entity.StringEntity;
     * cases. We don't have that available because we're testing against 1.7.
import org.apache.commons.logging.Log;
                restClient.performRequest(new Request(method, "/handshake"));
                }
                HttpEntity actualEntity = actualRequest.getEntity();
        return httpClient;
     * to make sure that the caller shows up in the exception. We use this
 * under the License.
import java.util.concurrent.CountDownLatch;
                restClient.performRequest(new Request(method, "/closed"));
            HttpHost target,
import java.util.concurrent.atomic.AtomicReference;
            request.setEntity(entity);
 * body, different status codes and corresponding responses/exceptions.
                        ignoreParam += ",";
            case "/soe":
            HttpContext context,
        fail("didn't find the calling method (looks like " + myMethod + ") in:\n" + stack);
import org.apache.hc.core5.http.io.entity.EntityUtils;
            try {
    interface CloseableHttpAsyncClientListener {
                    }
            } catch (ConnectionClosedException e) {
        assertEquals(warningBodyTexts, response.getWarnings());
                    public boolean warningsShouldFailRequest(List<String> warnings) {
    public void testBody() throws Exception {
        assertDeprecationWarnings(singletonList(proxyWarning), singletonList(proxyWarning));
            request.setEntity(entity);
                HttpContext context,
                // And we do all that so the thrown exception has our method in the stacktrace
                    return (T) responseOrException(requestProducer);
                public void onFailure(Exception exception) {
            assertThat(requests.intValue(), equalTo(++times));
                request.setEntity(entity);
            @Override
        }
                restClient.performRequest(new Request(method, "/uri"));
        },
        URI uri = uriBuilder.build();
            defaultHeaders,
                HandlerFactory<AsyncPushConsumer> pushHandlerFactory,
            return responseRef.get();
    /**
                    Request request = new Request(method, "/" + errorStatusCode);
            protected WarningsHandler warningsHandler() {
            }
                fail("request should have failed");
            protected WarningsHandler warningsHandler() {
                    } else {
    public void shutdownExec() {
                performRequestSyncOrAsync(restClient, request);
        request.setOptions(options);
                    }
                final ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(statusCode, "");
 * this work for additional information regarding copyright
                public void onSuccess(Response response) {
                            }
     */
                    assertExceptionStackContainsCallingMethod(e);
                restClient.performRequest(new Request(method, "/runtime"));
            protected WarningsHandler warningsHandler() {
                ignore += "," + randomFrom(RestClientTestUtil.getAllErrorStatusCodes());
                        return null;
        assertDeprecationWarnings(singletonList(formatWarningWithoutDate(chars)), singletonList(chars));
 * Relies on a mock http client to intercept requests and return desired responses based on request path.
        for (String method : Arrays.asList("TRACE")) {
import org.apache.hc.core5.http.ConnectionClosedException;
            } catch (SSLHandshakeException e) {
        };
import org.apache.hc.client5.http.classic.methods.HttpGet;
                String value = randomAsciiAlphanumOfLengthBetween(3, 10);
            String ignore = Integer.toString(randomFrom(RestClientTestUtil.getAllErrorStatusCodes()));
            final CountDownLatch latch = new CountDownLatch(1);
 * ownership. Elasticsearch licenses this file to you under
            try {
                    }
        } else {
 * not use this file except in compliance with the License.
    }
    }
        String proxyWarning = "112 - \"network down\" \"Sat, 25 Aug 2012 23:34:45 GMT\"";
import org.apache.hc.core5.http.nio.AsyncPushConsumer;
                // And we do all that so the thrown exception has our method in the stacktrace
        return expectedRequest;
            case "/runtime":
 * Modifications Copyright OpenSearch Contributors. See
            Request request = new Request(method, "/" + randomStatusCode(getRandom()));
import org.apache.hc.core5.http.HttpHost;
            } catch (WarningFailureException e) {
import org.apache.hc.core5.http.nio.AsyncRequestProducer;
import org.apache.hc.core5.util.TimeValue;
                    Response response = restClient.performRequest(request);
                    if (i < numIgnores - 1) {
                assertExceptionStackContainsCallingMethod(e);
            requests.increment();
                if (errorStatusCode <= 500 || expectedIgnores.contains(errorStatusCode)) {
        HttpUriRequest expectedRequest;
    private ExecutorService exec = Executors.newFixedThreadPool(1);
import org.apache.hc.core5.io.CloseMode;
            case "TRACE":
                uniqueNames.add(header.getName());
            }
import java.util.List;
    /**
            failureListener.assertCalled(singletonList(node));
        node = new Node(new HttpHost("localhost", 9200));
import static org.opensearch.client.RestClientTestUtil.getHttpMethods;
     */
                }
                // return the same headers that were sent
                    if (expectedIgnores.contains(errorStatusCode)) {
            }
                // And we do all that so the thrown exception has our method in the stacktrace
                throw new SocketTimeoutException(httpHost.toString());
        switch (method) {
package org.opensearch.client;
        for (StackTraceElement se : t.getStackTrace()) {
        restClient = new RestClient(
                return null;
                fail("request should have failed");
            public void awaitShutdown(TimeValue waitTime) throws InterruptedException {}
                expectedRequest = new HttpGet(uri);
            }
import static java.util.Collections.singletonList;
    }
    private static String formatWarning(String warningBody) {
            failureListener.assertCalled(singletonList(node));
     * synchronous calls by performing asynchronous calls and blocking the
        return ((HttpUriRequestProducer) requestProducer).getRequest();
                    }
        final HttpHost httpHost = new HttpHost(request.getAuthority());
            }
                fail("request should have failed");
    public void testHeaders() throws Exception {
            try {
            logger.info("checking warningOption=" + warningOption + " and warnings=" + warningBodyTexts);
                        for (String warning : warnings) {
        });
        }
     */
                response = e.getResponse();
        requests = new LongAdder();
     * End to end test for request and response headers. Exercises the mock http client ability to send back
            Set<Integer> expectedIgnores = new HashSet<>();
            assertEquals(expectedRequest.getRequestUri(), actualRequest.getRequestUri());
                AsyncRequestProducer requestProducer,
            for (int errorStatusCode : getAllErrorStatusCodes()) {
    private LongAdder requests;
                @Override
    private AtomicReference<AsyncRequestProducer> requestProducerCapture;
                expectedRequest.addHeader(defaultHeader);
 */
        for (String method : Arrays.asList("DELETE", "GET", "PATCH", "POST", "PUT")) {
                        }
            assertArrayEquals(expectedRequest.getHeaders(), actualRequest.getHeaders());
                break;
    private RestClient restClient;
        t.printStackTrace(new PrintWriter(stack));
        CloseableHttpAsyncClient httpClient = new CloseableHttpAsyncClient() {
            failureListener.assertCalled(singletonList(node));
            case "GET":
        httpClient = mockHttpClient(exec, (target, requestProducer, responseConsumer, pushHandlerFactory, context, callback) -> {
        if (getRandom().nextBoolean() && !(expectedRequest instanceof HttpTrace /* no entity */)) {
                Request request = new Request(method, "/" + errorStatusCode);
            if (HttpHead.METHOD_NAME.equals(method)) {
                return;
                }
            if (randomBoolean()) {
                Response response = restClient.performRequest(request);
     */
        );
        }
            expectedRequest.setEntity(entity);
 */
                throw new UnsupportedOperationException("method not supported: " + method);
            }
import static org.hamcrest.CoreMatchers.instanceOf;
                    Response response = e.getResponse();
import org.apache.hc.client5.http.classic.methods.HttpHead;
     * Verifies the content of the {@link HttpRequest} that's internally created and passed through to the http client
    @After
import org.apache.hc.client5.http.ConnectTimeoutException;
                        } catch (Exception e) {
        }
        if (randomBoolean()) {
            int numParams = randomIntBetween(1, 3);
                // And we do all that so the thrown exception has our method in the stacktrace
        final boolean expectFailure;
                    public boolean warningsShouldFailRequest(List<String> warnings) {
            case "PUT":
            @Override
    public void testPerformRequestExceptions() throws Exception {
        }
import org.apache.hc.core5.http.HttpEntity;
import static org.junit.Assert.assertArrayEquals;
    }
                throw new IOException(httpHost.toString());
import java.util.Collections;
    public void testInternalHttpRequest() throws Exception {
                });
        if (randomBoolean() && !(expectedRequest instanceof HttpTrace /* no entity */)) {
            assertThat(esResponse.getStatusLine().getStatusCode(), equalTo(statusCode));
                Arrays.stream(listeners)
                } catch (ResponseException e) {
            for (int i = 0; i < numParams; i++) {
        } else {
                expectedRequest = new HttpTrace(uri);
        );
 * software distributed under the License is distributed on an
                } catch (ResponseException e) {
            if (expectedEntity != null) {
import java.nio.charset.StandardCharsets;
                        }
        // return the desired status code or exception depending on the path
            }
                fail("expected WarningFailureException from warnings");
            HttpEntity entity = new StringEntity(randomAsciiAlphanumOfLengthBetween(10, 100), ContentType.APPLICATION_JSON);
            request.setOptions(options);
                assertThat(response.getStatusLine().getStatusCode(), equalTo(okStatusCode));
     * Emulates OpenSearch's HeaderWarningLogger.formatWarning in simple
                httpResponse.setHeaders(request.getHeaders());
        int times = 0;
                return new WarningsHandler() {
            }
            }
    }
            this.httpClient,
    }
                expectedRequest = new HttpDelete(uri);
    private static ClassicHttpRequest getRequest(AsyncRequestProducer requestProducer) throws NoSuchFieldException, IllegalAccessException {
import org.opensearch.client.http.HttpUriRequestProducer;
import java.net.URISyntaxException;
            Request request = new Request(method, "/" + statusCode);
                expectedRequest = new HttpOptions(uri);
    private boolean strictDeprecationMode;
                uriBuilder.addParameter(name, value);
 * specific language governing permissions and limitations
                }
                String name = "param-" + i;
            assertEquals(expectedRequest.getMethod(), actualRequest.getMethod());
import org.apache.hc.core5.net.URIBuilder;
            request.setOptions(options);
    }
                            callback.completed((T) httpResponse);
            @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
            request.addParameter("ignore", ignore);
            final int statusCode = randomStatusCode(getRandom());
        assertDeprecationWarnings(Collections.<String>emptyList(), Collections.<String>emptyList());
            requestProducerCapture.set(requestProducer);
            failureListener.assertCalled(singletonList(node));
            ClassicHttpRequest expectedRequest = performRandomRequest(httpMethod);
        }
            // error status codes should cause an exception to be thrown
            public void close() throws IOException {}
        Response response;
            for (Header header : headers) {
            // request level headers override default headers
    }
                expectedRequest = new HttpPost(uri);
    }
                try {
import static org.hamcrest.CoreMatchers.containsString;
 *
            ) {
                        try {
                    exceptionRef.set(exception);
            Arrays.asList(formatWarning(chars), "another one", "and another"),
public class RestClientSingleHostTests extends RestClientTestCase {
                expectedRequest = new HttpPut(uri);
                // And we do all that so the thrown exception has our method in the stacktrace
                }
                    if (callback != null) {
            } catch (ConnectTimeoutException e) {
            }
                    assertThat(EntityUtils.toString(response.getEntity()), equalTo(body));
                }
        void onExecute(
     * that called this <strong>somewhere</strong> on its stack. This is
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * GitHub history for details.
                restClient.performRequest(new Request(method, "/soe"));
                    @Override
            for (int okStatusCode : getOkStatusCodes()) {
                throw new SSLHandshakeException("");
            }
    private Header[] defaultHeaders;
import org.apache.hc.client5.http.classic.methods.HttpOptions;
                AsyncResponseConsumer<T> responseConsumer,
            for (int okStatusCode : getOkStatusCodes()) {
            NodeSelector.ANY,
        for (String method : getHttpMethods()) {
import static org.junit.Assert.assertEquals;
                        // no exception gets thrown although we got an error status code, as it was configured to be ignored
import java.io.IOException;
                    responseRef.set(response);
            case "/closed":
            expectFailure = warningOption.warningsHandler().warningsShouldFailRequest(warningBodyTexts);
    }
        requestProducerCapture = new AtomicReference<>();
            if (uniqueNames.contains(defaultHeader.getName()) == false) {
    }
            if (exceptionRef.get() != null) {
            options.setWarningsHandler(warningOption.warningsHandler());
        }
            DeprecationWarningOption warningOption = randomFrom(DeprecationWarningOption.values());
    public void createRestClient() {
        if (randomBoolean()) {
/**
     * normally the case for synchronous calls but {@link RestClient} performs
            public void initiateShutdown() {}
                    restClient.performRequest(request);
            AsyncResponseConsumer<?> responseConsumer,
            try {
                fail("request should have failed");
                if (false == warningBodyTexts.isEmpty()) {
    private static final Log logger = LogFactory.getLog(RestClientSingleHostTests.class);
            }
            try {
                assertExceptionStackContainsCallingMethod(e);
        if (randomBoolean()) {
            public void start() {}
import org.apache.hc.core5.http.Header;
            null,
                assertEquals(EntityUtils.toString(expectedEntity), EntityUtils.toString(actualEntity));
            assertFalse(esResponse.hasWarnings());
                esResponse = e.getResponse();
            }
        STRICT {
        URIBuilder uriBuilder = new URIBuilder(uriAsString);
        }
                // And we do all that so the thrown exception has our method in the stacktrace
                restClient.performRequest(new Request(method, "/coe"));
import java.io.StringWriter;
                }
import static org.opensearch.client.RestClientTestUtil.getOkStatusCodes;
            }
            Arrays.asList(chars, "another one", "and another")
import org.apache.hc.client5.http.classic.methods.HttpPatch;
        final String hash = new String(new byte[40], StandardCharsets.UTF_8).replace('\0', 'e');
                expectedRequest = new HttpPatch(uri);
            default:
        String uriAsString = "/" + randomStatusCode(getRandom());
        for (String warningHeaderText : warningHeaderTexts) {
        },
        strictDeprecationMode = randomBoolean();
            false
import java.util.Arrays;
            }
            assertHeaders(defaultHeaders, requestHeaders, esResponse.getHeaders(), Collections.<String>emptySet());
        for (String httpMethod : getHttpMethods()) {
                        fail("request should have failed");
    }
            public IOReactorStatus getStatus() {
        if (expectFailure) {
    private static String formatWarningWithoutDate(String warningBody) {
                } else {
     * End to end test for error status codes: they should cause an exception to be thrown, apart from 404 with HEAD requests
     * Shutdown the executor so we don't leak threads into other test runs.
                throw new ConnectTimeoutException(httpHost.toString());
import org.apache.hc.core5.concurrent.FutureCallback;
import static org.junit.Assert.assertFalse;
                request.addParameter(name, value);
                break;
                FutureCallback<T> callback
import org.apache.hc.core5.reactor.IOReactorStatus;
            try {
 * KIND, either express or implied.  See the License for the
import java.net.SocketTimeoutException;
    }
                fail("request should have failed");
        assertDeprecationWarnings(
                    }
        StringEntity entity = new StringEntity(body, ContentType.APPLICATION_JSON);
    /**
            } catch (IOException e) {
                        request.addParameter("ignore", ignoreParam);
     * whatever headers it has received.
                performRequestSyncOrAsync(restClient, request);
import static org.hamcrest.CoreMatchers.equalTo;
                return WarningsHandler.PERMISSIVE;
/*
        },
    }
import java.util.HashSet;
                assertThat(response.getStatusLine().getStatusCode(), equalTo(okStatusCode));
                };
            }
            }
                        throw e;
                // And we do all that so the thrown exception has our method in the stacktrace
     */
            case "POST":
                throw new URISyntaxException("", "");
            case "DELETE":
                    .forEach(l -> l.onExecute(target, requestProducer, responseConsumer, pushHandlerFactory, context, callback));
        assertDeprecationWarnings(singletonList("exact"), singletonList("exact"));
            RequestOptions.Builder options = request.getOptions().toBuilder();
    @Before
                }
        }
            @Override
    }
        }
 */
 * the Apache License, Version 2.0 (the "License"); you may
        String method = randomFrom(getHttpMethods());
            } catch (RuntimeException e) {
            AsyncRequestProducer requestProducer,
import org.apache.hc.client5.http.classic.methods.HttpPost;
                assertExceptionStackContainsCallingMethod(e);
    public void testDeprecationWarnings() throws Exception {
            } catch (SocketTimeoutException e) {
            protected WarningsHandler warningsHandler() {
                fail("request should have failed");
                        assertEquals(errorStatusCode, response.getStatusLine().getStatusCode());
                            ClassicHttpResponse httpResponse = responseOrException(requestProducer);
            case "HEAD":
                    failureListener.assertCalled(singletonList(node));
        return formatWarningWithoutDate(warningBody) + " \"Mon, 01 Jan 2001 00:00:00 GMT\"";
        Request request = new Request(method, "/200");
            case "/ioe":
    @SuppressWarnings("unchecked")
                expectedRequest.addHeader(new RequestOptions.ReqHeader(header.getName(), header.getValue()));
                @Override
    @SuppressWarnings("unchecked")
        final ClassicHttpRequest request = getRequest(requestProducer);
        // 2 is the caller, what we want
import org.apache.hc.client5.http.classic.methods.HttpDelete;
                        return false;
            }
                // return the same body that was sent
            }
                request.setEntity(entity);
import org.apache.hc.core5.http.message.BasicClassicHttpResponse;
            performRequestSyncOrAsync(restClient, request);
            }
        }
     */
                if (entity != null) {
 * Unless required by applicable law or agreed to in writing,
import java.io.PrintWriter;
import org.apache.hc.core5.http.HttpRequest;
                assertExceptionStackContainsCallingMethod(e);
                    assertThat(response.getStatusLine().getStatusCode(), equalTo(errorStatusCode));
                    @Override
            if (se.getClassName().equals(myMethod.getClassName()) && se.getMethodName().equals(myMethod.getMethodName())) {
            for (int errorStatusCode : getAllErrorStatusCodes()) {
                    assertThat(e.getMessage(), containsString("\nWarnings: " + warningBodyTexts));
        try {
        assertEquals(false == warningBodyTexts.isEmpty(), response.hasWarnings());
            restClient.performRequestAsync(request, new ResponseListener() {
                    fail("request should have failed");
            strictDeprecationMode,
            public void register(String hostname, String uriPattern, Supplier<AsyncPushConsumer> supplier) {}
                    httpResponse.setEntity(entity);
                assertExceptionStackContainsCallingMethod(e);
                };
            case "PATCH":
            case "/handshake":
                    latch.countDown();
            @Override
import org.apache.hc.core5.http.ContentType;
                        return false == warnings.equals(Arrays.asList("exact"));
