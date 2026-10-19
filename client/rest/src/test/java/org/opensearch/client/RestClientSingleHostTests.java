import static org.opensearch.client.RestClientTestUtil.getAllErrorStatusCodes;
    }
            }  
                public void onSuccess(Response response) {
                } else {  
    }
    }
            ClassicHttpRequest expectedRequest = performRandomRequest(httpMethod);
     */
                    assertTrue("the entity is not repeatable, cannot set it to the response directly", entity.isRepeatable());
            case "HEAD":
        exec.shutdown();
        String method = randomFrom(getHttpMethods());
        // randomize between sync and async methods
 * Unless required by applicable law or agreed to in writing,
            request.setEntity(entity);  
import javax.net.ssl.SSLHandshakeException;
    }
                // return the same headers that were sent
            } catch (RuntimeException e) {
            try {  
            }  
            public void close() throws IOException {}
    @SuppressWarnings("unchecked")
                assertThat(EntityUtils.toString(response.getEntity()), equalTo(body));  
 * Modifications Copyright OpenSearch Contributors. See
                if (false == warningBodyTexts.isEmpty()) {  
                HttpContext context,  
                // And we do all that so the thrown exception has our method in the stacktrace
        try {
            @Override
        }  
                Arrays.stream(listeners)  
    /**
            ) {
                options.addHeader(requestHeader.getName(), requestHeader.getValue());  
    private Header[] defaultHeaders;
                HttpEntity entity = request.getEntity();  
    }
import java.util.concurrent.CountDownLatch;  
            // IOExceptions should be let bubble up  
            try {
            } catch (SSLHandshakeException e) {  
                assertExceptionStackContainsCallingMethod(e);
                    if (i < numIgnores - 1) {
            options.setWarningsHandler(warningOption.warningsHandler());  
                performRequestSyncOrAsync(restClient, request);
import java.util.concurrent.ExecutorService;
    public void testPerformRequestIOExceptions() throws Exception {
            response = performRequestSyncOrAsync(restClient, request);  
 * this work for additional information regarding copyright
        } else {
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.core5.http.ContentType;
     * Verifies the content of the {@link HttpRequest} that's internally created and passed through to the http client
                    Request request = new Request(method, "/" + errorStatusCode);
    @Before
            failureListener,  
            false,  
                    } else {  
 */  
            return restClient.performRequest(request);
                            callback.failed(e);  
            assertThat(requests.intValue(), equalTo(++times));  
                break;
            case "TRACE":
                assertThat(e.getCause(), instanceOf(URISyntaxException.class));  
import static org.hamcrest.CoreMatchers.containsString;  
            if (se.getClassName().equals(myMethod.getClassName()) && se.getMethodName().equals(myMethod.getMethodName())) {
                expectedIgnores.add(404);  
            for (int okStatusCode : getOkStatusCodes()) {
    private LongAdder requests;
                fail("request should have failed");  
import org.apache.hc.core5.http.nio.HandlerFactory;  
                expectedRequest = new HttpPut(uri);  
        return expectedRequest;
        assertEquals(warningBodyTexts, response.getWarnings());  
import static org.junit.Assert.fail;
import static java.util.Collections.singletonList;
                            }  
                break;
                                return true;
                    assertEquals(errorStatusCode, e.getResponse().getStatusLine().getStatusCode());
     * Asserts that the provided {@linkplain Exception} contains the method
    private AtomicReference<AsyncRequestProducer> requestProducerCapture;
            Response esResponse;  
        failureListener = new HostsTrackingFailureListener();
     */  
                expectedRequest = new HttpGet(uri);  
                throw new ConnectTimeoutException(httpHost.toString());
            } catch (SocketTimeoutException e) {
        restClient = new RestClient(
 * under the License.  
import org.apache.hc.core5.reactor.IOReactorStatus;
                } catch (ResponseException e) {
            if (expectedEntity != null) {
                uniqueNames.add(header.getName());
     */  
            if (randomBoolean()) {
                };
     */  
        fail("didn't find the calling method (looks like " + myMethod + ") in:\n" + stack);
import java.nio.charset.StandardCharsets;  
        // return the desired status code or exception depending on the path  
                esResponse = e.getResponse();
            request.setOptions(options);  
            case "/coe":
        protected abstract WarningsHandler warningsHandler();  
                    latch.countDown();
                fail("request should have failed");
                request.setEntity(entity);
 * GitHub history for details.
            try {
            RequestOptions.Builder options = request.getOptions().toBuilder();
                Response response = restClient.performRequest(request);
                    }
                fail("request should have failed");
            failureListener.assertCalled(singletonList(node));  
                    Response response = restClient.performRequest(request);
    /**
                throw new UnsupportedOperationException("method not supported: " + method);  
            Request request = new Request(method, "/" + randomStatusCode(getRandom()));
            }  
            }  
            case "GET":
            case "/runtime":
            HttpEntity entity = new StringEntity(randomAsciiAlphanumOfLengthBetween(10, 100), ContentType.APPLICATION_JSON);
        }
                Request request = new Request(method, "/" + errorStatusCode);  
        request.setOptions(options);  
import java.io.IOException;  
     * synchronous calls by performing asynchronous calls and blocking the
import static org.junit.Assert.assertArrayEquals;  
                throw exceptionRef.get();
    }
    private static String formatWarningWithoutDate(String warningBody) {
            failureListener.assertCalled(singletonList(node));
            protected <T> Future<T> doExecute(
import org.apache.commons.logging.Log;
import java.net.URISyntaxException;
            }
        EXACT {
        CloseableHttpAsyncClient httpClient = new CloseableHttpAsyncClient() {  
            public void register(String hostname, String uriPattern, Supplier<AsyncPushConsumer> supplier) {}
 *
        assertDeprecationWarnings(Collections.<String>emptyList(), Collections.<String>emptyList());
            protected WarningsHandler warningsHandler() {  
        },  
                    }
                } catch (ResponseException e) {  
import org.apache.hc.client5.http.classic.methods.HttpPatch;
    private ExecutorService exec = Executors.newFixedThreadPool(1);  
            protected WarningsHandler warningsHandler() {
            assertHeaders(defaultHeaders, requestHeaders, esResponse.getHeaders(), Collections.<String>emptySet());
                performRequestSyncOrAsync(restClient, request);
        for (String httpMethod : getHttpMethods()) {
            case "DELETE":
            public void close(CloseMode closeMode) {}
                try {  
                    }  
        for (String method : getHttpMethods()) {
        PERMISSIVE {  
                expectedRequest = new HttpDelete(uri);  
import org.apache.hc.core5.concurrent.FutureCallback;
            try {
import static org.opensearch.client.RestClientTestUtil.getHttpMethods;  
    interface CloseableHttpAsyncClientListener {
            this.httpClient,
        for (String method : getHttpMethods()) {
 * ownership. Elasticsearch licenses this file to you under  
                restClient.performRequest(new Request(method, "/coe"));
     * End to end test for ok status codes
                            if (false == warning.startsWith("ignorable")) {
                expectedRequest = new HttpPost(uri);  
                assertExceptionStackContainsCallingMethod(e);
        assertDeprecationWarnings(singletonList("poorly formatted " + chars), singletonList("poorly formatted " + chars));
            strictDeprecationMode,
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;  
        for (String method : getHttpMethods()) {  
    }
                assertEquals(EntityUtils.toString(expectedEntity), EntityUtils.toString(actualEntity));
        }  
import org.apache.hc.core5.http.nio.AsyncPushConsumer;  
                throw new ConnectionClosedException();  
import java.io.PrintWriter;
        return "299 OpenSearch-1.2.2-SNAPSHOT-" + hash + " \"" + warningBody + "\"";  
            try {
            RequestOptions.Builder options = request.getOptions().toBuilder();  
            try {
            }
            options.addHeader("Warning", warningHeaderText);
        STRICT {
                    if (callback != null) {
            final int statusCode = randomStatusCode(getRandom());
                return;
                // And we do all that so the thrown exception has our method in the stacktrace
            @Override
                    if (expectedIgnores.contains(errorStatusCode)) {
            requests.increment();  
import java.net.SocketTimeoutException;  
import org.apache.hc.core5.http.HttpRequest;
                    .forEach(l -> l.onExecute(target, requestProducer, responseConsumer, pushHandlerFactory, context, callback));
import static org.junit.Assert.assertTrue;
                        request.addParameter("ignore", ignoreParam);  
    }
     * assertion to make sure that we don't break that "special care".
        for (StackTraceElement se : t.getStackTrace()) {  
            case "OPTIONS":
            default:
        String proxyWarning = "112 - \"network down\" \"Sat, 25 Aug 2012 23:34:45 GMT\"";
                Request request = new Request(method, "/" + okStatusCode);
    }  
            }
import org.junit.Before;
            AsyncRequestProducer requestProducer,
                throw new URISyntaxException("", "");
        }  
import org.apache.commons.logging.LogFactory;
import java.io.StringWriter;
        });
    private boolean strictDeprecationMode;  
    public void testPerformRequestExceptions() throws Exception {  
                return WarningsHandler.STRICT;
                // And we do all that so the thrown exception has our method in the stacktrace
            case "PATCH":
            assertThat(esResponse.getStatusLine().getStatusCode(), equalTo(statusCode));  
            case "/closed":
                assertExceptionStackContainsCallingMethod(e);
        },  
            performRequestSyncOrAsync(restClient, request);  
import static org.opensearch.client.RestClientTestUtil.getOkStatusCodes;
    /**
import org.apache.hc.client5.http.classic.methods.HttpTrace;
            @Override
            try {
import org.apache.hc.core5.net.URIBuilder;  
    public void testInternalHttpRequest() throws Exception {
                int statusCode = Integer.parseInt(request.getRequestUri().substring(1));
                expectedRequest = new HttpHead(uri);  
        return ((HttpUriRequestProducer) requestProducer).getRequest();  
        assertDeprecationWarnings(singletonList(formatWarning(chars)), singletonList(chars));
    public void testDeprecationWarnings() throws Exception {  
        assertDeprecationWarnings(
            defaultHeaders,  
    private static String formatWarning(String warningBody) {  
import java.util.HashSet;  
                ignore += "," + randomFrom(RestClientTestUtil.getAllErrorStatusCodes());  
        String body = "{ \"field\": \"value\" }";
import org.apache.hc.core5.http.protocol.HttpContext;
 *  
                public void onFailure(Exception exception) {  
import java.util.List;
            int numParams = randomIntBetween(1, 3);  
        for (String method : Arrays.asList("DELETE", "GET", "PATCH", "POST", "PUT")) {  
                        return false == warnings.equals(Arrays.asList("exact"));  
    }
                    expectedIgnores.add(code);  
        Request request = new Request(method, uriAsString);  
    static CloseableHttpAsyncClient mockHttpClient(final ExecutorService exec, final CloseableHttpAsyncClientListener... listeners) {
     * whatever body it has received.
            HandlerFactory<AsyncPushConsumer> pushHandlerFactory,
    public void createRestClient() {
                assertThat(response.getStatusLine().getStatusCode(), equalTo(okStatusCode));
    private Node node;  
                expectedRequest = new HttpOptions(uri);  
 * You may obtain a copy of the License at  
        httpClient = mockHttpClient(exec, (target, requestProducer, responseConsumer, pushHandlerFactory, context, callback) -> {
        }
import java.util.Collections;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    httpResponse.setEntity(entity);  
            failureListener.assertCalled(singletonList(node));
                    public boolean warningsShouldFailRequest(List<String> warnings) {
            // error status codes should cause an exception to be thrown
    /**
            @Override
            for (int errorStatusCode : getAllErrorStatusCodes()) {
     * that called this <strong>somewhere</strong> on its stack. This is  
                assertExceptionStackContainsCallingMethod(e);
            Request request = new Request(method, "/" + statusCode);  
                throw new RuntimeException();  
                        try {
        Response response;
/*  
 */  
import org.apache.hc.client5.http.ConnectTimeoutException;  
 * license agreements. See the NOTICE file distributed with
import org.apache.hc.core5.http.Header;
        },
        requestProducerCapture = new AtomicReference<>();
                            callback.completed((T) httpResponse);
import java.util.Arrays;
    static Response performRequestSyncOrAsync(RestClient restClient, Request request) throws Exception {
            }
import org.apache.hc.core5.http.nio.AsyncResponseConsumer;
                AsyncResponseConsumer<T> responseConsumer,
                assertExceptionStackContainsCallingMethod(e);  
            FutureCallback<?> callback  
import org.apache.hc.core5.io.CloseMode;
        if (getRandom().nextBoolean() && !(expectedRequest instanceof HttpTrace /* no entity */)) {  
            }
                int numIgnores = randomIntBetween(1, 3);  
    }
                HandlerFactory<AsyncPushConsumer> pushHandlerFactory,
/*  
            }
            } catch (IllegalStateException e) {
                for (int i = 0; i < numIgnores; i++) {
        requests = new LongAdder();  
        }  
                restClient.performRequest(new Request(method, "/soe"));  
            }
     * current thread until the call returns so it has to take special care  
        for (String warningHeaderText : warningHeaderTexts) {
                break;
     * End to end test for request and response headers. Exercises the mock http client ability to send back
    /**
import org.opensearch.client.http.HttpUriRequestProducer;  
    private HostsTrackingFailureListener failureListener;
        return httpClient;  
            }
                @Override
            }  
        StringEntity entity = new StringEntity(body, ContentType.APPLICATION_JSON);
            null,
        };
                }
            HttpEntity expectedEntity = expectedRequest.getEntity();
        final ClassicHttpRequest request = getRequest(requestProducer);
                };
        node = new Node(new HttpHost("localhost", 9200));
                request.addParameter(name, value);
                throw new SSLHandshakeException("");
     * Emulates OpenSearch's HeaderWarningLogger.formatWarning in simple
        // 1 is this method  
                assertThat(response.getStatusLine().getStatusCode(), equalTo(okStatusCode));
                    failureListener.assertNotCalled();
                throw new SocketTimeoutException(httpHost.toString());  
        } else {  
                    assertExceptionStackContainsCallingMethod(e);
 * specific language governing permissions and limitations
                return httpResponse;
            return responseRef.get();  
                // Call the callback asynchronous to better simulate how async http client works
            }
                }  
import java.util.concurrent.atomic.LongAdder;
            public void awaitShutdown(TimeValue waitTime) throws InterruptedException {}  
            } catch (WarningFailureException e) {
                if (errorStatusCode <= 500 || expectedIgnores.contains(errorStatusCode)) {
     */
import org.apache.hc.core5.http.io.entity.StringEntity;
            default:
            case "/ioe":  
    private static void assertExceptionStackContainsCallingMethod(Throwable t) {
                expectedRequest.addHeader(defaultHeader);
            protected WarningsHandler warningsHandler() {
 * KIND, either express or implied.  See the License for the
            if (exceptionRef.get() != null) {  
     * End to end test for request and response body. Exercises the mock http client ability to send back  
        defaultHeaders = RestClientTestUtil.randomHeaders(getRandom(), "Header-default");  
import org.apache.hc.core5.http.io.entity.EntityUtils;  
                request.setEntity(entity);  
                    restClient.performRequest(request);  
        final boolean expectFailure;
            public void start() {}
            }
    /**
                assertThat(e.getMessage(), equalTo(method + " requests may not include an entity."));
import static org.junit.Assert.assertFalse;
    }
            false
        );
            final AtomicReference<Response> responseRef = new AtomicReference<>();
        } else {
    private static final Log logger = LogFactory.getLog(RestClientSingleHostTests.class);
import org.apache.hc.core5.http.message.BasicClassicHttpResponse;
        RequestOptions.Builder options = request.getOptions().toBuilder();  
            } catch (ResponseException e) {  
        }
        }
                // return the same body that was sent
                restClient.performRequest(new Request(method, "/uri"));  
import java.util.concurrent.atomic.AtomicReference;
                options.addHeader(header.getName(), header.getValue());
    public void shutdownExec() {  
import org.apache.hc.core5.util.TimeValue;
                    assertExceptionStackContainsCallingMethod(e);  
                fail("request should have failed");  
                break;
                    assertThat(EntityUtils.toString(response.getEntity()), equalTo(body));
    private void assertDeprecationWarnings(List<String> warningHeaderTexts, List<String> warningBodyTexts) throws Exception {  
        String chars = randomAsciiAlphanumOfLength(5);
        assertDeprecationWarnings(singletonList("exact"), singletonList("exact"));
                    }
                final ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(statusCode, "");
            for (int okStatusCode : getOkStatusCodes()) {
        return formatWarningWithoutDate(warningBody) + " \"Mon, 01 Jan 2001 00:00:00 GMT\"";
                }  
                });
                    @Override
            assertArrayEquals(expectedRequest.getHeaders(), actualRequest.getHeaders());
                        fail("request should have failed");
                    if (false == ignoreParam.isEmpty()) {
     * to make sure that the caller shows up in the exception. We use this
        for (String method : getHttpMethods()) {  
        for (String method : getHttpMethods()) {
import org.apache.hc.client5.http.classic.methods.HttpGet;
    public void testOkStatusCodes() throws Exception {  
            }
                    exceptionRef.set(exception);
                response = e.getResponse();  
    public void testHeaders() throws Exception {
                        }
            HttpContext context,
            final AtomicReference<Exception> exceptionRef = new AtomicReference<>();  
                            ClassicHttpResponse httpResponse = responseOrException(requestProducer);  
    private RestClient restClient;
            @Override
        int times = 0;  
        t.printStackTrace(new PrintWriter(stack));  
            @Override  
        // 0 is getStackTrace
public class RestClientSingleHostTests extends RestClientTestCase {  
                HttpHost target,
                restClient.performRequest(new Request(method, "/closed"));
import static org.junit.Assert.assertThat;  
                }
            request.setEntity(entity);  
                expectedRequest = new HttpPatch(uri);  
                fail("request should have failed");
            requestProducerCapture.set(requestProducer);
 * body, different status codes and corresponding responses/exceptions.  
                Response response = performRequestSyncOrAsync(restClient, new Request(method, "/" + okStatusCode));  
        URI uri = uriBuilder.build();
            public IOReactorStatus getStatus() {
                        return false;
     * Shutdown the executor so we don't leak threads into other test runs.  
                    }  
                esResponse = performRequestSyncOrAsync(restClient, request);
        Request request = new Request(method, "/200");
                    }  
            }
     * End to end test for error status codes: they should cause an exception to be thrown, apart from 404 with HEAD requests
        StackTraceElement myMethod = Thread.currentThread().getStackTrace()[2];
            }  
            if (randomBoolean()) {
        failureListener.assertNotCalled();
 *    http://www.apache.org/licenses/LICENSE-2.0
            request.setOptions(options);
package org.opensearch.client;
            String ignore = Integer.toString(randomFrom(RestClientTestUtil.getAllErrorStatusCodes()));
            final Header[] requestHeaders = RestClientTestUtil.randomHeaders(getRandom(), "Header");
    }  
        }
            // request level headers override default headers  
        if (randomBoolean()) {
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpOptions;
        assertDeprecationWarnings(Arrays.asList("ignorable one", "and another"), Arrays.asList("ignorable one", "and another"));  
            assertFalse(esResponse.hasWarnings());
                restClient.performRequest(new Request(method, "/handshake"));
                break;
            logger.info("checking strictWarningsMode=[" + strictDeprecationMode + "] and warnings=" + warningBodyTexts);
import org.apache.hc.core5.http.nio.AsyncRequestProducer;
    @After
            try {  
 * Relies on a mock http client to intercept requests and return desired responses based on request path.
    public void testBody() throws Exception {  
                return new WarningsHandler() {  
 * the Apache License, Version 2.0 (the "License"); you may
     */
                if (entity != null) {
        );
        for (String method : Arrays.asList("TRACE")) {
    }  
                // And we do all that so the thrown exception has our method in the stacktrace
    private enum DeprecationWarningOption {
        // 2 is the caller, what we want
 */
            for (Header header : headers) {
        }  
        }  
                    latch.countDown();
                return new WarningsHandler() {  
import org.apache.hc.client5.http.classic.methods.HttpPost;  
        };
                        assertEquals(errorStatusCode, response.getStatusLine().getStatusCode());
                break;
        void onExecute(  
import org.apache.hc.core5.http.HttpEntity;  
                expectedRequest.addHeader(new RequestOptions.ReqHeader(header.getName(), header.getValue()));  
                        }
            }
        HttpUriRequest expectedRequest;  
            HttpHost target,
            }  
                    return (T) responseOrException(requestProducer);
                return null;  
            }
            @Override
            assertEquals(expectedRequest.getRequestUri(), actualRequest.getRequestUri());  
                // And we do all that so the thrown exception has our method in the stacktrace  
    public void testErrorStatusCodes() throws Exception {
                    if (expectedIgnores.contains(errorStatusCode)) {  
                fail("request should have failed");  
                expectedRequest = new HttpTrace(uri);  
            Header[] headers = RestClientTestUtil.randomHeaders(getRandom(), "Header");
            String ignoreParam = "";
                }
            protected WarningsHandler warningsHandler() {
            } catch (IOException e) {
                        throw e;
                httpResponse.setHeaders(request.getHeaders());  
import static org.hamcrest.CoreMatchers.instanceOf;
            @Override
     * cases. We don't have that available because we're testing against 1.7.
            case "/handshake":
import org.junit.After;
 */
                    ignoreParam += code;
                break;
        for (Header defaultHeader : defaultHeaders) {
    private static ClassicHttpResponse responseOrException(AsyncRequestProducer requestProducer) throws Exception {  
            restClient.performRequestAsync(request, new ResponseListener() {  
        if (expectFailure) {  
            for (Header requestHeader : requestHeaders) {
                restClient.performRequest(new Request(method, "/runtime"));
        }
import static org.opensearch.client.RestClientTestUtil.randomStatusCode;
            assertEquals(expectedRequest.getMethod(), actualRequest.getMethod());
            if (uniqueNames.contains(defaultHeader.getName()) == false) {
                fail("expected WarningFailureException from warnings");  
     */
        URIBuilder uriBuilder = new URIBuilder(uriAsString);
        String uriAsString = "/" + randomStatusCode(getRandom());
            // all good
            }  
 * Tests for basic functionality of {@link RestClient} against one single host: tests http requests being sent, headers,
                try {
                }  
            for (int errorStatusCode : getAllErrorStatusCodes()) {
import static org.junit.Assert.assertEquals;
            }
                fail("request should have failed");
            final CountDownLatch latch = new CountDownLatch(1);
            case "POST":
                FutureCallback<T> callback
 * software distributed under the License is distributed on an
                String value = randomAsciiAlphanumOfLengthBetween(3, 10);  
            expectFailure = warningOption.warningsHandler().warningsShouldFailRequest(warningBodyTexts);
                fail("request should have failed");  
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
        switch (method) {
    private CloseableHttpAsyncClient httpClient;
                return exec.submit(() -> {  
    }
        assertDeprecationWarnings(singletonList(proxyWarning), singletonList(proxyWarning));
import java.util.Set;
            case "PUT":
        assertThat(requestProducer, instanceOf(HttpUriRequestProducer.class));
/*
            if (HttpHead.METHOD_NAME.equals(method)) {
     * normally the case for synchronous calls but {@link RestClient} performs
            Arrays.asList(formatWarning(chars), "another one", "and another"),  
            }  
 * The OpenSearch Contributors require contributions made to  
                break;
        final String hash = new String(new byte[40], StandardCharsets.UTF_8).replace('\0', 'e');
            Arrays.asList(chars, "another one", "and another")
                throw new IOException(httpHost.toString());
/**
        }
        );
            } catch (RuntimeException e) {
            try {
            failureListener.assertCalled(singletonList(node));
                    assertThat(e.getMessage(), containsString("\nWarnings: " + warningBodyTexts));
            }  
                        // no exception gets thrown although we got an error status code, as it was configured to be ignored
import java.util.concurrent.Future;  
            });
                    assertThat(response.getStatusLine().getStatusCode(), equalTo(errorStatusCode));
    @SuppressWarnings("unchecked")
                    fail("request should have failed");
            }  
        }
import static org.hamcrest.CoreMatchers.equalTo;
        final Set<String> uniqueNames = new HashSet<>();  
            DeprecationWarningOption warningOption = randomFrom(DeprecationWarningOption.values());
        } catch (Exception e) {
    /**  
                }
        }
        switch (request.getRequestUri()) {
                return;
        assertEquals(false == warningBodyTexts.isEmpty(), response.hasWarnings());
            latch.await();
        for (String method : getHttpMethods()) {
import java.util.concurrent.Executors;
                    @Override
        }
            singletonList(node),
import org.apache.hc.core5.http.ClassicHttpResponse;
     */  
 * Licensed to Elasticsearch under one or more contributor  
        strictDeprecationMode = randomBoolean();  
                    Response response = e.getResponse();  
            expectFailure = strictDeprecationMode && false == warningBodyTexts.isEmpty();
        }  
            failureListener.assertCalled(singletonList(node));
    }
                AsyncRequestProducer requestProducer,  
            case "/soe":
            expectedRequest.setEntity(entity);
                    Integer code = randomFrom(getAllErrorStatusCodes());
                assertExceptionStackContainsCallingMethod(e);  
                assertExceptionStackContainsCallingMethod(e);  
            failureListener.assertCalled(singletonList(node));
                restClient.performRequest(new Request(method, "/ioe"));
        final HttpHost httpHost = new HttpHost(request.getAuthority());
                    responseRef.set(response);  
    }
}
            }
    }
    }
 *
        }
                // And we do all that so the thrown exception has our method in the stacktrace
            case "/uri":  
                        return null;
            AsyncResponseConsumer<?> responseConsumer,  
    private static ClassicHttpRequest getRequest(AsyncRequestProducer requestProducer) throws NoSuchFieldException, IllegalAccessException {
                uriBuilder.addParameter(name, value);
            for (int i = 0; i < numParams; i++) {
            ClassicHttpRequest actualRequest = getRequest(requestProducerCapture.get());
                    }
                }
                String name = "param-" + i;
        if (randomBoolean()) {
import org.apache.hc.core5.http.ClassicHttpRequest;
        }
     * whatever headers it has received.  
 * this file be licensed under the Apache-2.0 license or a
            } catch (ConnectTimeoutException e) {  
            public void initiateShutdown() {}
        }
                return WarningsHandler.PERMISSIVE;
import org.apache.hc.core5.http.HttpHost;
    private HttpUriRequest performRandomRequest(String method) throws Exception {
    /**  
                        ignoreParam += ",";  
        if (randomBoolean() && !(expectedRequest instanceof HttpTrace /* no entity */)) {
                // And we do all that so the thrown exception has our method in the stacktrace
            }
            failureListener.assertCalled(singletonList(node));
    }  
        StringWriter stack = new StringWriter();
                HttpEntity actualEntity = actualRequest.getEntity();  
            try {
                    public boolean warningsShouldFailRequest(List<String> warnings) {
            logger.info("checking warningOption=" + warningOption + " and warnings=" + warningBodyTexts);
            }
            } catch (ConnectionClosedException e) {
            request.addParameter("ignore", ignore);
            NodeSelector.ANY,
 * SPDX-License-Identifier: Apache-2.0
        assertDeprecationWarnings(singletonList(formatWarningWithoutDate(chars)), singletonList(chars));  
import org.apache.hc.core5.function.Supplier;  
 * compatible open source license.
import java.net.URI;
                        } catch (Exception e) {
                    failureListener.assertCalled(singletonList(node));
        if (randomBoolean()) {  
import org.apache.hc.core5.http.ConnectionClosedException;  
        }
        }  
                        for (String warning : warnings) {  
        if (randomBoolean()) {  
 * not use this file except in compliance with the License.
    }  
    }
import org.apache.hc.client5.http.classic.methods.HttpHead;  
            Set<Integer> expectedIgnores = new HashSet<>();  
            // randomly add some ignore parameter, which doesn't get sent as part of the request  
    public void testPerformRequestRuntimeExceptions() throws Exception {
        FILTERED {
                @Override
            }  
