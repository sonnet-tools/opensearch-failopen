        restController.registerHandler(RestRequest.Method.GET, "/foo", new RestHandler() {
import org.reactivestreams.Subscriber;
            responseReference.set(response);
    }  
        }  
        }  
        final String deprecatedPath = "/_" + randomAlphaOfLengthBetween(1, 6);
        IllegalArgumentException exception = expectThrows(
            public boolean supportsContentStream() {  
            }
        }  
        assertEquals(Set.of(RestRequest.Method.GET), faviconHandler.getValidMethods());
                );  
        ).build();
                new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY)
            @Override
            public void handleRequest(RestRequest request, RestChannel channel, NodeClient client) throws Exception {
    public void testDispatchFailsWithPlainText() {
     */
        doCallRealMethod().when(controller).registerAsDeprecatedHandler(method, path, handler, deprecationMessage);
        // don't want to test everything -- just that it actually wraps the handlers
    }  
            + " "
        public AssertingChannel(RestRequest request, boolean detailedErrorsEnabled, RestStatus expectedStatus, boolean failFirstSend) {
import org.opensearch.http.HttpStats;
        assertNotNull(rejection.get());
        );
        restController.dispatchBadRequest(  
        }).when(delegate).sendResponse(any(RestResponse.class));  
        RestRequest request = testRestRequest("/concurrent-send", breakerFillingContent(), MediaTypeRegistry.JSON);
        final String mimeType = "application/x-ndjson";
                channel.sendResponse(new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY));
        assertEquals(0, inFlightRequestsBreaker.getTrippedCount());  
        assertThat(channel.getRestResponse().getHeaders().containsKey("Allow"), equalTo(true));  
        public void sendResponse(RestResponse response) {
        assertEquals(0, inFlightRequestsBreaker.getUsed());
        assertEquals(0, inFlightRequestsBreaker.getUsed());
                    assertEquals("true", threadContext.getHeader("header.1"));
                .build(),
        AssertingChannel channel = new AssertingChannel(fakeRestRequest, true, RestStatus.NOT_ACCEPTABLE);  
                expectThrows(
        client = new NoOpNodeClient(this.getTestName());
            )
        restController.dispatchRequest(request, channel, client.threadPool().getThreadContext());
        @Override  
        AtomicBoolean wrapperCalled = new AtomicBoolean(false);  
        int contentLength = BREAKER_LIMIT.bytesAsInt();
        private final AtomicInteger attemptCount = new AtomicInteger();
 * software distributed under the License is distributed on an
            }
                        )
            channel,
            channel.getRestResponse().content().utf8ToString()
            new BytesArray(content),
        assertTrue(channel.getSendResponseCalled());  
                firstSendEntered.countDown();  
            return attemptCount.get();
        }
                return true;
    }
        RestRequest request = testRestRequest("/", content, MediaTypeRegistry.JSON);
            RestRequest request,  
                m -> m == RestRequest.Method.GET || m == RestRequest.Method.OPTIONS,  
        assertTrue(channel.getSendResponseCalled());
    public void testDispatchRequestAddsAndFreesBytesOnSuccess() {
        TestHttpServerTransport() {}
        restController.dispatchRequest(fakeRestRequest, channel, client.threadPool().getThreadContext());
                    IllegalStateException.class,
        restController.dispatchRequest(request, channel, client.threadPool().getThreadContext());
        assertEquals(2, channel.getAttemptCount());
import org.opensearch.test.OpenSearchTestCase;
            public HttpRequest releaseAndCopy() {
        AssertingChannel channel = new AssertingChannel(fakeRequest, false, RestStatus.BAD_REQUEST);  
import static org.hamcrest.Matchers.not;
    }  
            public void handleRequest(RestRequest request, RestChannel channel, NodeClient client) throws Exception {
        assertFalse(channel.getSendResponseCalled());
        });
        FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withContent(new BytesArray("{}"), null)
 * Licensed to Elasticsearch under one or more contributor  
                        IllegalStateException.class,
        final RestController restController = new RestController(headers, null, null, circuitBreakerService, usageService);
    }
            .withHeaders(Collections.singletonMap("Content-Type", Collections.singletonList("application/x-www-form-urlencoded")))  
import org.opensearch.core.xcontent.NamedXContentRegistry;
        assertEquals(RestStatus.OK, channel.getLastStatus());  
        AssertingChannel channel = new AssertingChannel(request, true, RestStatus.NOT_ACCEPTABLE);
            }  
                    + "bytes or compressed xcontent bytes\""  
            .build();
public class RestControllerTests extends OpenSearchTestCase {  
        );
    public void testDispatchRequestLimitsBytes() {
                releaseFirstSend.countDown();
 * ownership. Elasticsearch licenses this file to you under  
    public void testApplyRelevantHeaders() throws Exception {
import java.util.concurrent.TimeUnit;
            + " "  
                failure.set(t);  
        final RestController restController = new RestController(headers, null, null, circuitBreakerService, usageService);
        });  
        final FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withPath("/foo")
        Map<String, List<String>> restHeaders = new HashMap<>();
                    () -> channel.sendResponse(  
                }  
        assertEquals("/foo", rootHandler.getPath());  
import static org.mockito.Mockito.doCallRealMethod;
        final RestController restController = new RestController(null, null, null, circuitBreakerService, usageService);
            BytesReference.bytes(YamlXContent.contentBuilder().startObject().endObject()),  
            public boolean supportsContentStream() {  
        });
        FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withContent(
            } finally {  
        boolean getSendResponseCalled() {
                return null;  
        final AssertingChannel channel = new AssertingChannel(fakeRestRequest, true, RestStatus.BAD_REQUEST);  
        doCallRealMethod().when(controller).registerWithDeprecatedHandler(method, path, handler, deprecatedMethod, deprecatedPath);
        Map<String, List<String>> restHeaders = new HashMap<>();
        public AssertingChannel(RestRequest request, boolean detailedErrorsEnabled, RestStatus expectedStatus) {
        restController.dispatchRequest(fakeRestRequest, channel, client.threadPool().getThreadContext());
            .build();  
            randomValueOtherThanMany(
import static org.mockito.Mockito.mock;
import org.opensearch.http.HttpServerTransport;
                expectThrows(
    public void testDefaultRestControllerGetAllHandlersContainsFavicon() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;  
        });
        protected void doStop() {}
            @Override
        restHeaders.put("header.3", Collections.singletonList("false"));
        }
    public void testStreamingFailureResponseIsSentAndSubsequentSendIsRejected() {  
            throw new IllegalArgumentException("test error");
        builder.withPath(path);  
                return null;
        );
        final RestController restController = new RestController(headers, null, client, circuitBreakerService, usageService);
            null
        CountDownLatch releaseFirstSend = new CountDownLatch(1);
            new BytesArray("aaaabbbbb"),
        private final RestStatus expectedStatus;
        RestRequest request = testRestRequest("/", content, null);  
            @Override
        assertEquals(0, inFlightRequestsBreaker.getUsed());
            throw new AssertionError("sendChunk is not expected in this test");
        assertThat(rejection.get().getMessage(), containsString("already sent"));  
 * Modifications Copyright OpenSearch Contributors. See
        doAnswer(invocation -> {
        @Override  
import org.opensearch.http.HttpRequest;
import org.opensearch.common.xcontent.XContentType;  
            .withPath("/foo")
            () -> restController.registerHandler(secondMethod, path + "/{wildcard2}", handler)
        AtomicReference<IllegalStateException> rejection = new AtomicReference<>();
        assertFalse(channel.getSendResponseCalled());  
 * under the License.  
            public boolean supportsContentStream() {
            } catch (IllegalStateException e) {
        String responseBodyString = channel.getRestResponse().content().utf8ToString();  
                () -> randomFrom(RestRequest.Method.values())
    public void testDispatchRequiresContentTypeForRequestsWithContent() {
     */
                return headers;
 * You may obtain a copy of the License at  
            return true;
    private static final class AssertingStreamingChannel extends AssertingChannel implements StreamingRestChannel {
        restController.dispatchRequest(fakeRestRequest, channel, client.threadPool().getThreadContext());  
        );
                secondSend.start();  
        final FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).build();
        String content = randomAlphaOfLength((int) Math.round(BREAKER_LIMIT.getBytes() / inFlightRequestsBreaker.getOverhead()));  
                + " compressed xcontent bytes\"}],\"type\":\"not_x_content_exception\",\"reason\":\"Compressor detection can only be called on some xcontent "  
        assertThat(responseBodyString, containsString("\"status\":400"));  
        assertTrue(channel.getSendResponseCalled());
                .put(HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING.getKey(), false)  
    }
                }  
        assertFalse(handlers.hasNext());
        AssertingChannel channel = new AssertingChannel(fakeRestRequest, true, RestStatus.NOT_ACCEPTABLE);
import org.opensearch.usage.UsageService;  
        final FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withMethod(
        restHeaders.put("header.2", Collections.singletonList("true"));
    }
        final FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withMethod(RestRequest.Method.GET)  
                Map<String, List<String>> headers = new HashMap<>();  
 * compatible open source license.
        RestRequest fakeRequest = new FakeRestRequest.Builder(xContentRegistry()).withHeaders(restHeaders).withPath("/bar").build();
 * SPDX-License-Identifier: Apache-2.0
            )
                return true;
 *    http://www.apache.org/licenses/LICENSE-2.0
            throw new IllegalStateException("always throwing an exception for testing");  
        final AssertingChannel channel = new AssertingChannel(request, true, RestStatus.METHOD_NOT_ALLOWED);
        // don't want to test everything -- just that it actually wraps the handler
        final AssertingChannel channel = new AssertingChannel(fakeRestRequest, false, RestStatus.OK);  
                return "/";
    public void testHandleBadInputWithCreateIndex() {
            try {
                () -> channel.sendResponse(new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY))
package org.opensearch.rest;
        restController.dispatchRequest(request, channel, client.threadPool().getThreadContext());
        assertEquals(0, inFlightRequestsBreaker.getUsed());
            }  
        assertEquals("/favicon.ico", faviconHandler.getPath());  
    /**
            .withParams(Map.of("error_trace", "true"))
    public void testRegisterWithDeprecatedHandler() {  
        int getAttemptCount() {  
            }
        assertEquals("/favicon.ico", faviconHandler.getPath());
                secondSend.join(10_000L);
            firstSend.join(10_000L);  
            int attempt = attemptCount.incrementAndGet();
            assertSame(handler, h);
 * KIND, either express or implied.  See the License for the
            return acceptedCount.get();
import org.opensearch.http.HttpResponse;  
        final RestController controller = mock(RestController.class);
                channel.sendResponse(response);
                // We want to have reproducible results in this test, hence we disable real memory usage accounting
            "{\"error\":{\"root_cause\":[{\"type\":\"not_x_content_exception\",\"reason\":\"Compressor detection can only be called on some xcontent bytes or"
import static org.mockito.Mockito.any;  
        verify(controller).registerAsDeprecatedHandler(deprecatedMethod, deprecatedPath, handler, deprecationMessage);
        MethodHandlers faviconHandler = handlers.next();
    }
            }  
        FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withContent(  
    public void testDispatchUnsupportedContentType() {  
            )
            firstSend.start();  
        final FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withPath("/foo")
            return new BoundTransportAddress(new TransportAddress[] { transportAddress }, transportAddress);  
            public boolean supportsContentStream() {  
        );
            assertEquals(expectedStatus, response.status());
        AtomicBoolean blockFirstSend = new AtomicBoolean(true);
    public void testDispatchUnsupportedHttpMethod() {
    /**
        });
            @Override  
            // The channel rejects the first response, standing in for a body that cannot be serialized.
        String path = "/_" + randomAlphaOfLengthBetween(1, 6);  
            + path
import org.opensearch.core.common.breaker.CircuitBreaker;
        final AssertingChannel channel = new AssertingChannel(fakeRestRequest, true, RestStatus.BAD_REQUEST);
        public void subscribe(Subscriber<? super HttpChunk> subscriber) {
        RestHandler handler = mock(RestHandler.class);
    }
            Mono.<HttpChunk>empty().subscribe(subscriber);  
                }  
        });  
import java.util.List;
        final RestHandler handler = (RestRequest request, RestChannel channel, NodeClient client) -> handlerCalled.set(true);
        @Override  
import reactor.core.publisher.Mono;  
        assertThat(responseBodyString, containsString("\"type\":\"not_x_content_exception\""));
                IllegalStateException.class,
        );
    }
            rejection.set(  
        );  
import java.util.Set;  
                // raw channel, hiding the fact that this channel rejected the failure response.
            }
            responseBodyString,  
        restController.dispatchRequest(request, channel, client.threadPool().getThreadContext());
            }
        restController.dispatchRequest(fakeRestRequest, channel, client.threadPool().getThreadContext());
            @Override
        AssertingChannel channel = new AssertingChannel(fakeRequest, false, RestStatus.BAD_REQUEST);
                return null;  
                );
            .withMethod(RestRequest.Method.PUT)
        assertThat(channel.getRestResponse().contentType(), containsString("image/x-icon"));  
        assertThat(responseBodyString, containsString("\"status\":400"));
        RestStatus getLastStatus() {
        assertEquals(0, inFlightRequestsBreaker.getTrippedCount());
    public void testDispatchWithContentStreamNoContentType() {  
        final FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).build();
        String responseBodyString = channel.getRestResponse().content().utf8ToString();  
        circuitBreakerService = new HierarchyCircuitBreakerService(
        AssertingChannel channel = new AssertingChannel(request, true, RestStatus.BAD_REQUEST);  
        assertTrue(channel.getSendResponseCalled());
        restController.registerHandler(RestRequest.Method.GET, "/streaming-failing-send", new RestHandler() {
        @Override
            acceptedCount.incrementAndGet();  
        restHeaders.put("header.2", Arrays.asList("foo", "bar"));
                    )
            super(request, detailedErrorsEnabled);
            Collections.emptyList(),
    }  
        ).withPath("/foo").withHeaders(Collections.singletonMap("Content-Type", Collections.singletonList("foo/bar"))).build();  
        restController.registerHandler(RestRequest.Method.GET, "/bar", new RestHandler() {  
        @Override  
        assertNull(threadContext.getHeader("header.3"));
    }  
 * the Apache License, Version 2.0 (the "License"); you may
        );  
                    throw new AssertionError("timed out waiting to release the first send");
        );
        restController.registerHandler(RestRequest.Method.PUT, "/foo", new RestCreateIndexAction());
        // the rest controller relies on the caller to stash the context, so we should expect these values here as we didn't stash the
    }
            equalTo("{\"error\":\"Unexpected HTTP method, allowed: [GET]\",\"status\":405}")
    public void teardown() throws IOException {  
            randomBoolean() ? new IllegalStateException("bad request") : new Throwable("bad request")  
            RestResponse response = new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY);
        AssertingChannel delegate = spy(new AssertingChannel(request, true, RestStatus.OK));  
        }, client, circuitBreakerService, usageService);  
                return true;  
            try {  
 *  
    }  
            .build();
            RestStatus expectedStatus,
import org.opensearch.core.xcontent.MediaTypeRegistry;
        String content = randomAlphaOfLength((int) Math.round(contentLength / inFlightRequestsBreaker.getOverhead()));  
        FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withContent(
            @Override  
        IOUtils.close(client);
        });
    public void testDispatchWorksWithNewlineDelimitedJson() {  
            responseBodyString,
            return null;
        final List<String> contentTypeHeader = Collections.singletonList(mimeType);
    private UsageService usageService;  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
    }  
            boolean failFirstPrepare  
            }  
    }
            null
        final AssertingChannel channel = new AssertingChannel(fakeRestRequest, true, RestStatus.BAD_REQUEST);  
        assertThat(channel.getRestResponse().getHeaders().containsKey("Allow"), equalTo(true));
        RestRequest request = testRestRequest("/error", content, MediaTypeRegistry.JSON);
        }
        restController.registerHandler(RestRequest.Method.GET, "/foo", new RestHandler() {
        public void sendChunk(HttpChunk chunk) {
    }
    public static class AssertingChannel extends AbstractRestChannel {
    @After
        assertEquals(1, channel.getAcceptedCount());
            }
    }
            .withMethod(RestRequest.Method.PUT)
                channel.sendResponse(new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY));  
            .withMethod(RestRequest.Method.PUT)
            Arrays.asList(new RestHeaderDefinition("header.1", true), new RestHeaderDefinition("header.2", true))
        RestRequest fakeRequest = new FakeRestRequest.Builder(xContentRegistry()).withHeaders(restHeaders).build();
                if (hasContent) {
    }
        final FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withPath(  
            Thread firstSend = sendResponseOnNewThread(channel, response, firstFailure);  
            "/",
            }
        assertTrue(channel.getSendResponseCalled());  
    /**
        public HttpInfo info() {
        String content = randomAlphaOfLength((int) Math.round(BREAKER_LIMIT.getBytes() / inFlightRequestsBreaker.getOverhead()));  
                channel.sendResponse(new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY));
        RestRequest request = testRestRequest("/streaming-failing-send", breakerFillingContent(), MediaTypeRegistry.JSON);  
        restController.dispatchRequest(request, delegate, client.threadPool().getThreadContext());
    }  
        assertThat(responseBodyString, not(containsString("stack_trace")));  
import static org.hamcrest.Matchers.equalTo;  
    private String breakerFillingContent() {
        }
    private static Thread sendResponseOnNewThread(RestChannel channel, RestResponse response, AtomicReference<Throwable> failure) {
        assertFalse(channel.getSendResponseCalled());
 */  
                assertFalse("concurrent send did not finish", secondSend.isAlive());
 * The OpenSearch Contributors require contributions made to  
        }
            )
        @Override  
                assertTrue("first send did not reach the delegate", firstSendEntered.await(10, TimeUnit.SECONDS));
        @Override
        Iterator<MethodHandlers> handlers = restController.getAllHandlers();
        restController.dispatchRequest(fakeRestRequest, channel, client.threadPool().getThreadContext());  
        restController.dispatchRequest(fakeRequest, channel, threadContext);  
        restController = new RestController(Collections.emptySet(), null, null, circuitBreakerService, usageService);
            + method.name()
        restController.registerHandler(RestRequest.Method.GET, "/foo", new RestHandler() {
            public void handleRequest(RestRequest request, RestChannel channel, NodeClient client) throws Exception {  
        restController.registerHandler(RestRequest.Method.GET, "/failing-send", (request, channel, client) -> {
import java.util.concurrent.atomic.AtomicReference;
        return new Thread(() -> {
                channel.sendResponse(new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY));
    private static final ByteSizeValue BREAKER_LIMIT = new ByteSizeValue(20);
                channel.sendResponse(new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY));  
        restController.dispatchRequest(request, channel, client.threadPool().getThreadContext());
        String content = randomAlphaOfLength((int) Math.round(BREAKER_LIMIT.getBytes() / inFlightRequestsBreaker.getOverhead()));
        final RestRequest request = RestRequest.request(xContentRegistry(), new HttpRequest() {  
                // Reported as an Error on purpose. RestController catches Exception and would otherwise resend over the  
    public void testDispatchRequestAddsAndFreesBytesOnlyOnceOnError() {
        assertEquals(RestStatus.INTERNAL_SERVER_ERROR, channel.getLastStatus());  
        assertEquals(0, inFlightRequestsBreaker.getUsed());
            return true;
        protected void doClose() {}
            @Override  
/*  
        public HttpStats stats() {  
        restController.registerHandler(RestRequest.Method.PUT, "/foo", new RestCreateIndexAction());
    public void testHandleBadInputWithCreateIndexReturnsDetailedErrorStackTraceWhenRequested() {  
    }
            public void handleRequest(RestRequest request, RestChannel channel, NodeClient client) {  
            @Override  
        final String path = "/_" + randomAlphaOfLengthBetween(1, 6);
        private final AtomicReference<RestResponse> responseReference = new AtomicReference<>();
            }  
        String content = randomAlphaOfLength((int) Math.round(contentLength / inFlightRequestsBreaker.getOverhead()));  
import org.opensearch.rest.action.admin.indices.RestCreateIndexAction;
        ).withPath("/foo").withHeaders(Collections.singletonMap("Content-Type", contentTypeHeader)).build();
            + deprecatedPath  
 */
            .withPath("/favicon.ico")
            }  
/*  
        RestRequest request = testRestRequest("/error", content, MediaTypeRegistry.JSON);
            channel.sendResponse(new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY));
        final ThreadContext threadContext = client.threadPool().getThreadContext();  
        RestRequest request = testRestRequest("/double-send", breakerFillingContent(), MediaTypeRegistry.JSON);  
                            new BytesRestResponse(RestStatus.ACCEPTED, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY)  
            responseBodyString,
        verify(controller).registerHandler(eq(method), eq(path), any(DeprecationRestHandler.class));  
                channel.sendResponse(new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY));
                return true;
            RestResponse response = getRestResponse();  
            public List<String> strictCookies() {
    }  
            this.failFirstSend = failFirstSend;
        restController.registerHandler(firstMethod, path + "/{wildcard1}", handler);  
        assertFalse(channel.getSendResponseCalled());
                if (releaseFirstSend.await(10, TimeUnit.SECONDS) == false) {
        final AssertingChannel channel = new AssertingChannel(fakeRestRequest, false, RestStatus.BAD_REQUEST);
                "\"stack_trace\":\"OpenSearchException[Compressor detection can only be called on some xcontent bytes or compressed xcontent bytes];"  
     * loudly instead of writing two responses onto the same connection.  
        assertEquals(1, delegate.getAttemptCount());  
        assertEquals(
            .build();
        // we will produce an error in the rest handler and one more when sending the error response
    }  
        });
import static org.mockito.Mockito.eq;  
            }
        Map<String, List<String>> restHeaders = new HashMap<>();
        String content = randomAlphaOfLength((int) Math.round(contentLength / inFlightRequestsBreaker.getOverhead()));  
import static org.hamcrest.Matchers.containsString;
                    new BytesRestResponse(RestStatus.INTERNAL_SERVER_ERROR, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY)  
        restController.registerHandler(RestRequest.Method.GET, "/foo", mock(RestHandler.class));  
        );
    }  
            .withParams(new HashMap<>(Map.of("error_trace", "false")))  
import java.util.concurrent.atomic.AtomicBoolean;  
        restController.dispatchRequest(request, channel, client.threadPool().getThreadContext());
        RestRequest request = testRestRequest("/", content, MediaTypeRegistry.JSON);
        assertEquals(0, inFlightRequestsBreaker.getUsed());
        RestHandler handler = mock(RestHandler.class);
        assertThat(channel.detailedErrorStackTraceEnabled(), equalTo(false));
            }  
        restController.dispatchRequest(request, channel, client.threadPool().getThreadContext());
                throw new IllegalStateException("response body could not be serialized");  
        httpServerTransport.start();
        final String path = "/_" + randomAlphaOfLengthBetween(1, 6);  
            containsString(
        }
        RestRequest request = testRestRequest("/wrapped", "{}", MediaTypeRegistry.JSON);
    }
        final HttpServerTransport httpServerTransport = new TestHttpServerTransport();
            this.failFirstPrepare = new AtomicBoolean(failFirstPrepare);  
    }
        assertThat(
            }  
import org.opensearch.core.common.bytes.BytesArray;  
    private static final class ExceptionThrowingChannel extends AbstractRestChannel {
                    IllegalStateException.class,
        public void prepareResponse(RestStatus status, Map<String, List<String>> headers) {  
        restController.registerHandler(RestRequest.Method.GET, "/wrapped", handler);
        final RestController spyRestController = spy(restController);
    public void testRequestWithDisallowedMultiValuedHeader() {
                throw new AssertionError("failure response was rejected after the first send failed", e);
        assertTrue(channel.getSendResponseCalled());
            if (failFirstPrepare.compareAndSet(true, false)) {
            this(request, detailedErrorsEnabled, expectedStatus, false);
            "/<script>alert('xss');alert(\"&#x6A&#x61&#x76&#x61\");</script>"
     * must therefore still be delivered over the same channel even though the breaker reservation was already released.
import org.opensearch.common.util.concurrent.ThreadContext;
            public boolean hasNext() {
    public void testDispatchRequestAddsAndFreesBytesOnError() {
    }  
        int contentLength = BREAKER_LIMIT.bytesAsInt();
                return new RestMethodHandlers("/", (RestRequest request, RestChannel channel, NodeClient client) -> {
            RestRequest.Method.GET,
        int contentLength = BREAKER_LIMIT.bytesAsInt();  
import org.opensearch.core.common.bytes.BytesReference;
                );
 *
        restController.dispatchRequest(fakeRestRequest, channel, client.threadPool().getThreadContext());
        protected ExceptionThrowingChannel(RestRequest request, boolean detailedErrorsEnabled) {  
    public void testFaviconWithWrongHttpMethod() {  
        assertEquals(1, inFlightRequestsBreaker.getTrippedCount());  
        ).withPath("/favicon.ico").build();  
        restController.dispatchBadRequest(channel, client.threadPool().getThreadContext(), null);  
        assertTrue(channel.getSendResponseCalled());  
        assertTrue(channel.getSendResponseCalled());
import java.util.Arrays;
        ).withPath("/foo").withHeaders(Collections.singletonMap("Content-Type", Collections.singletonList("text/plain"))).build();
        assertThat(rejection.get().getMessage(), containsString("already sent"));  
import org.opensearch.http.HttpChunk;  
            public void handleRequest(RestRequest request, RestChannel channel, NodeClient client) throws Exception {  
        final boolean hasContent = randomBoolean();
            new BytesArray(content),
        RestResponse getRestResponse() {
        final String deprecationMessage = "["  
        AssertingChannel channel = new AssertingChannel(fakeRequest, false, RestStatus.OK);  
        AssertingChannel channel = new AssertingChannel(fakeRestRequest, true, RestStatus.NOT_ACCEPTABLE);
        restController = new RestController(Collections.emptySet(), null, client, circuitBreakerService, usageService);
            @Override
                );
import org.opensearch.core.common.transport.BoundTransportAddress;
    private static RestRequest testRestRequest(String path, String content, MediaType mediaType) {
     * When the first send fails inside the downstream channel, nothing has reached the client yet. The failure response  
    }  
            public HttpResponse createResponse(RestStatus status, BytesReference content) {
                return this;
    }  
        restController.dispatchRequest(fakeRestRequest, channel, client.threadPool().getThreadContext());
import static org.mockito.Mockito.doAnswer;
import java.io.IOException;
            this.expectedStatus = expectedStatus;
        ) {
        assertTrue(handlers.hasNext());
                throw new IllegalArgumentException("test");  
            @Override
        AssertingChannel channel = new AssertingChannel(request, true, RestStatus.OK);
    @Before  
import java.util.Map;
        @Override
            if (failFirstSend && attempt == 1) {
        final ThreadContext threadContext = client.threadPool().getThreadContext();  
        FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withContent(  
            + "] is deprecated! Use ["
        return builder.build();
    public void testRestHandlerWrapper() throws Exception {
import org.opensearch.transport.client.node.NodeClient;
                        new BytesRestResponse(RestStatus.ACCEPTED, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY)
    }
            public void handleRequest(RestRequest request, RestChannel channel, NodeClient client) throws Exception {
            @Override
    public void testHandleBadInputWithCreateIndexReturnsOnlyErrorSummaryWithDisabledErrorTrace() {  
                return true;
            }
        final RestRequest.Method method = randomFrom(RestRequest.Method.values());  
        restController.dispatchRequest(fakeRestRequest, channel, client.threadPool().getThreadContext());
            @Override
import org.opensearch.common.settings.Settings;  
            public RestRequest.Method method() {
            @Override
        assertTrue(channel.getSendResponseCalled());
            RestRequest.Method.GET,
                throw new IllegalStateException("response headers could not be prepared");
        assertTrue(channel.getSendResponseCalled());
            null  
        assertTrue(channel.getSendResponseCalled());
    }
        final AssertingChannel channel = new AssertingChannel(fakeRestRequest, true, RestStatus.BAD_REQUEST);
        }
        assertTrue(wrapperCalled.get());  
        builder.withContent(new BytesArray(content), mediaType);
import static org.mockito.Mockito.verify;  
        public void sendResponse(RestResponse response) {  
        final RestController restController = new RestController(null, null, null, circuitBreakerService, usageService);  
        restHeaders.put("header.1", Collections.singletonList("true"));  
        restController.registerHandler(RestRequest.Method.GET, "/foo", new RestHandler() {
        restController.registerHandler(RestRequest.Method.GET, "/double-send", (request, channel, client) -> {
        assertThat(channel.getRestResponse().getHeaders().get("Allow"), hasItem(equalTo(RestRequest.Method.GET.toString())));
 * this file be licensed under the Apache-2.0 license or a
}
            .withContent(new BytesArray("ddd"), MediaTypeRegistry.JSON)
            @Override  
        final RestHandler handler = mock(RestHandler.class);
        RestRequest request = testRestRequest("/failing-send", breakerFillingContent(), MediaTypeRegistry.JSON);
        Set<RestHeaderDefinition> headers = new HashSet<>(
        assertEquals(0, inFlightRequestsBreaker.getTrippedCount());  
        restHeaders.put("header.1", Collections.singletonList("boo"));  
        AssertingChannel channel = new AssertingChannel(fakeRestRequest, true, RestStatus.OK);
            new BytesArray(content),  
            return invocation.callRealMethod();
    private RestController restController;
        String content = randomAlphaOfLength((int) Math.round(BREAKER_LIMIT.getBytes() / inFlightRequestsBreaker.getOverhead()));
import org.junit.Before;
        int contentLength = BREAKER_LIMIT.bytesAsInt() + 1;
        return randomAlphaOfLength((int) Math.round(contentLength / inFlightRequestsBreaker.getOverhead()));
        assertTrue(channel.getSendResponseCalled());
            return responseReference.get();
            public HttpRequest removeHeader(String header) {  
    private CircuitBreaker inFlightRequestsBreaker;  
        assertEquals(1, channel.getAttemptCount());
                return this;
        public boolean isWritable() {  
            }
        });
        Set<RestHeaderDefinition> headers = new HashSet<>(
    public void testRegisterSecondMethodWithDifferentNamedWildcard() {
        ExceptionThrowingChannel channel = new ExceptionThrowingChannel(request, true);  
            .withContent(new BytesArray("ddd"), MediaTypeRegistry.JSON)
            .withMethod(RestRequest.Method.GET)
        assertThat(
            return (RestRequest request, RestChannel channel, NodeClient client) -> wrapperCalled.set(true);
    public void testRequestWithDisallowedMultiValuedHeaderButSameValues() {
        assertThat(channel.detailedErrorStackTraceEnabled(), equalTo(true));
        assertThat(channel.detailedErrorStackTraceEnabled(), equalTo(true));
            Arrays.stream(RestRequest.Method.values()).filter(m -> m != firstMethod).collect(Collectors.toList())  
    public void setup() {
 * this work for additional information regarding copyright
    }  
        restController.dispatchRequest(request, channel, client.threadPool().getThreadContext());
            }
                return randomFrom(HttpVersion.values());
import org.junit.After;
            public HttpVersion protocolVersion() {
    }  
        restController.registerHandler(RestRequest.Method.PATCH, "/foo", mock(RestHandler.class));
        restController.registerHandler(  
            public Exception getInboundException() {  
import static org.mockito.Mockito.spy;
import org.opensearch.common.settings.ClusterSettings;
    public void testFavicon() {
        assertThat(channel.getRestResponse().content().utf8ToString(), containsString("invalid uri has been requested"));
        }  
            Arrays.asList(new RestHeaderDefinition("header.1", true), new RestHeaderDefinition("header.2", false))
        assertThat(exception.getMessage(), equalTo("Trying to use conflicting wildcard names for same path: wildcard1 and wildcard2"));
        });
        controller.registerAsDeprecatedHandler(method, path, handler, deprecationMessage);
        MethodHandlers faviconHandler = handlers.next();
    public void testNonStreamingXContentCausesErrorResponse() throws IOException {
        assertFalse(handlerCalled.get());
            }
            public boolean supportsContentStream() {
                        () -> channel.sendResponse(
                    )
        final FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withPath("/foo")  
            }  
        AssertingChannel channel = new AssertingChannel(request, true, RestStatus.BAD_REQUEST);
        assertFalse(channel.getSendResponseCalled());  
    private HierarchyCircuitBreakerService circuitBreakerService;
        restController.dispatchRequest(fakeRestRequest, channel, client.threadPool().getThreadContext());
        restController.dispatchRequest(fakeRestRequest, channel, client.threadPool().getThreadContext());
     * A second {@link RestChannel#sendResponse} after one the delegate accepted is a handler bug, so it must still fail
                + "bytes or compressed xcontent bytes\"},\"status\":400}",
        );  
            .withParams(new HashMap<>(Map.of("error_trace", "true")))  
        assertTrue(handlers.hasNext());
 * GitHub history for details.
            public void release() {}
        assertEquals(0, inFlightRequestsBreaker.getUsed());
import static org.mockito.Mockito.when;
        restController.registerHandler(RestRequest.Method.GET, "/concurrent-send", (restRequest, channel, client) -> {
 */  
            client.threadPool().getThreadContext(),
    }  
        restController.dispatchRequest(fakeRequest, channel, threadContext);
            boolean detailedErrorsEnabled,
            super(request, detailedErrorsEnabled, expectedStatus);
        FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).build();  
    private NodeClient client;
        assertTrue(channel.getSendResponseCalled());
        assertThat(channel.getRestResponse().content().utf8ToString(), containsString("bad request"));  
 * license agreements. See the NOTICE file distributed with
            Thread secondSend = sendResponseOnNewThread(channel, response, secondFailure);
        FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withContent(new BytesArray("{}"), null)
            @Override
 * specific language governing permissions and limitations
    public void testDispatchBadRequestUnknownCause() {  
            @Override
        @Override
            (r, c, client) -> c.sendResponse(new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY))  
        assertEquals(Set.of(RestRequest.Method.GET), faviconHandler.getValidMethods());  
 * Unless required by applicable law or agreed to in writing,
        );  
import org.opensearch.core.rest.RestStatus;
 *
        // we can do this here only because we know that we don't adjust breaker settings dynamically in the test  
            "/",
            TransportAddress transportAddress = buildNewFakeTransportAddress();
            Arrays.asList(new RestHeaderDefinition("header.1", true), new RestHeaderDefinition("header.2", false))
        }
        }  
        assertFalse(channel.getSendResponseCalled());  
        RestRequest fakeRequest = new FakeRestRequest.Builder(xContentRegistry()).withHeaders(restHeaders).build();  
        final RestRequest.Method deprecatedMethod = randomFrom(RestRequest.Method.values());  
        AssertingChannel channel = new AssertingChannel(request, true, RestStatus.INTERNAL_SERVER_ERROR, true);  
        assertFalse(channel.getSendResponseCalled());  
        restController.dispatchRequest(request, channel, client.threadPool().getThreadContext());  
            public void handleRequest(RestRequest request, RestChannel channel, NodeClient client) throws Exception {
        assertThat(channel.getRestResponse().getHeaders().get("Allow"), hasItem(equalTo(RestRequest.Method.GET.toString())));
        }  
            public Map<String, List<String>> getHeaders() {
            } catch (Throwable t) {
     * Content sized to reserve the whole breaker limit, so that a missed release would be visible.  
            @Override
    }
        verify(controller).registerHandler(method, path, handler);  
        assertEquals(RestStatus.OK, delegate.getLastStatus());
        });
                    new BytesRestResponse(RestStatus.INTERNAL_SERVER_ERROR, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY)  
            @Override
            public String uri() {
        });  
    }
            containsString(
    }  
        @Override
        MethodHandlers rootHandler = handlers.next();
            @Override  
            .withPath("/")
        final FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withPath("/foo")  
            return null;
            channel.getRestResponse().content().utf8ToString(),  
            public void handleRequest(RestRequest request, RestChannel channel, NodeClient client) throws Exception {
        restController.dispatchRequest(fakeRestRequest, channel, client.threadPool().getThreadContext());  
    }
        @Override  
        private final AtomicInteger acceptedCount = new AtomicInteger();
            @Override
            }
        assertTrue(channel.getSendResponseCalled());  
    }
                return BytesArray.EMPTY;
        restController.dispatchRequest(fakeRestRequest, channel, client.threadPool().getThreadContext());
            }
                return true;  
        assertFalse(channel.getSendResponseCalled());
                "{\"error\":{\"root_cause\":[{\"type\":\"not_x_content_exception\",\"reason\":\"Compressor detection can only be called on some xcontent "
        AssertingChannel channel = new AssertingChannel(fakeRestRequest, true, RestStatus.NOT_ACCEPTABLE);
import java.util.HashMap;
            if (blockFirstSend.compareAndSet(true, false)) {
    }  
        public BoundTransportAddress boundAddress() {
import org.opensearch.http.HttpInfo;
        Iterator<MethodHandlers> handlers = restController.getAllHandlers();  
    public void testRegisterAsDeprecatedHandler() {
        assertEquals(1, delegate.getAcceptedCount());
    public void testFailureResponseIsSentWhenFirstSendResponseFails() {  
        assertNotNull(rejection.get());
            .build();  
    }
                channel.sendResponse(
import java.util.HashSet;
        assertTrue(channel.getSendResponseCalled());
            }
        AssertingChannel channel = new AssertingChannel(request, true, RestStatus.TOO_MANY_REQUESTS);
        restController.registerHandler(  
    }
        String deprecationMessage = randomAlphaOfLengthBetween(1, 10);
            public RestMethodHandlers next() {  
        inFlightRequestsBreaker = circuitBreakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS);
        usageService = new UsageService();
        int contentLength = BREAKER_LIMIT.bytesAsInt();
        restHeaders.put("header.1", Collections.singletonList("boo"));  
            @Override
        AtomicReference<IllegalStateException> rejection = new AtomicReference<>();  
        restController.registerHandler(RestRequest.Method.GET, "/foo", new RestHandler() {  
        final ThreadContext threadContext = client.threadPool().getThreadContext();  
        AtomicReference<Throwable> secondFailure = new AtomicReference<>();  
            expectThrows(  
        assertFalse(channel.getSendResponseCalled());
            return getRestResponse() != null;  
            @Override
        final AssertingChannel channel = new AssertingChannel(fakeRestRequest, true, RestStatus.METHOD_NOT_ALLOWED);
        AssertingChannel channel = new AssertingChannel(fakeRestRequest, true, RestStatus.NOT_ACCEPTABLE);
    public void testUnknownContentWithContentStream() {
        assertThat(secondFailure.get().getMessage(), containsString("already sent"));
        final AssertingChannel channel = new AssertingChannel(fakeRestRequest, true, RestStatus.BAD_REQUEST);
            @Override  
        HttpServerTransport httpServerTransport = new TestHttpServerTransport();  
        );  
/*
        }, null);  
    public void testSendResponseAfterSuccessfulSendIsRejected() {
    public void testHandleBadRequestWithHtmlSpecialCharsInUri() {
        FakeRestRequest.Builder builder = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY);
        assertEquals(0, inFlightRequestsBreaker.getUsed());  
            }
import static org.hamcrest.Matchers.hasItem;
            }  
        assertThat(  
            }
import java.util.concurrent.CountDownLatch;
        private AssertingStreamingChannel(
        assertThat(channel.getRestResponse().content().utf8ToString(), containsString("error traces in responses are disabled."));
                if (hasContent) {
        AssertingStreamingChannel channel = new AssertingStreamingChannel(request, true, RestStatus.INTERNAL_SERVER_ERROR, true);
            Settings.builder()  
import org.opensearch.common.xcontent.yaml.YamlXContent;
    public void testDispatchDoesNotRequireContentTypeForRequestsWithoutContent() {
        httpServerTransport.start();
        final RestController restController = new RestController(Collections.emptySet(), h -> {  
        restController.dispatchRequest(fakeRestRequest, channel, client.threadPool().getThreadContext());
                channel.sendResponse(
import org.opensearch.core.common.unit.ByteSizeValue;
    public void testDispatchWithContentStream() {
        restController.registerHandler(RestRequest.Method.PUT, "/foo", new RestCreateIndexAction());
            @Override  
        }
        RestController controller = mock(RestController.class);  
     */
        assertThat(  
        RestRequest.Method firstMethod = randomFrom(RestRequest.Method.values());
            );
import org.opensearch.core.common.transport.TransportAddress;  
        });  
        final AssertingChannel channel = new AssertingChannel(fakeRestRequest, true, RestStatus.BAD_REQUEST);  
                .put(HierarchyCircuitBreakerService.IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), BREAKER_LIMIT)
            }
            return response == null ? null : response.status();
                    return new BytesArray("test");
        AtomicReference<Throwable> firstFailure = new AtomicReference<>();
        // context in this test
        restController.registerHandler(RestRequest.Method.GET, "/error", (request, channel, client) -> {
        restController.dispatchRequest(fakeRestRequest, channel, client.threadPool().getThreadContext());
            public BytesReference content() {  
        }
        controller.registerWithDeprecatedHandler(method, path, handler, deprecatedMethod, deprecatedPath);
        assertEquals(1, channel.getAttemptCount());
            )
                    headers.put("Content-Type", Collections.singletonList("text/plain"));
        assertTrue(secondFailure.get() instanceof IllegalStateException);
        assertNull(firstFailure.get());  
        FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withContent(
        int getAcceptedCount() {
        @Override
            .build();
                "\"reason\":\"Compressor detection can only be called on some xcontent bytes " + "or compressed xcontent bytes\""  
import org.opensearch.test.rest.FakeRestRequest;
import java.util.Iterator;  
            + "] instead.";
            RestRequest.parseContentType(contentTypeHeader)
import org.opensearch.test.client.NoOpNodeClient;  
            );  
        AssertingChannel channel = new AssertingChannel(fakeRestRequest, true, RestStatus.OK);  
import java.util.stream.Collectors;  
        assertEquals(Set.of(RestRequest.Method.GET, RestRequest.Method.PATCH), rootHandler.getValidMethods());
                return false;
            (request, channel, client) -> channel.sendResponse(  
    public void testConcurrentSendResponseIsRejected() {
        assertTrue(channel.getSendResponseCalled());  
    }
            }
            assertFalse("first send did not finish", firstSend.isAlive());
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
        assertTrue(handlers.hasNext());  
        @Override  
    public void testRestControllerGetAllHandlers() {
                    assertEquals("true", threadContext.getHeader("header.2"));  
        protected void doStart() {}
            containsString(
            .build();  
        assertEquals(1, channel.getAcceptedCount());
        final String mimeType = randomFrom("application/json", "application/smile");
                    assertNull(threadContext.getHeader("header.3"));
    }
            }  
                )  
            IllegalArgumentException.class,  
        RestRequest.Method method = randomFrom(RestRequest.Method.values());
        public boolean isReadable() {
        }
        Set<RestHeaderDefinition> headers = new HashSet<>(
        AtomicBoolean handlerCalled = new AtomicBoolean(false);
        when(spyRestController.getAllRestMethodHandlers(null, fakeRequest.rawPath())).thenReturn(new Iterator<RestMethodHandlers>() {
                    expectThrows(  
            XContentType.YAML
            .withContent(new BytesArray("ddd"), MediaTypeRegistry.JSON)
        }
import java.util.concurrent.atomic.AtomicInteger;
            @Override
    private static final class TestHttpServerTransport extends AbstractLifecycleComponent implements HttpServerTransport {
        assertEquals(RestStatus.INTERNAL_SERVER_ERROR, channel.getLastStatus());  
            public boolean supportsStreaming() {
            try {
        assertEquals("true", threadContext.getHeader("header.2"));
import java.util.Collections;  
 * not use this file except in compliance with the License.
        String content = randomAlphaOfLength((int) Math.round(contentLength / inFlightRequestsBreaker.getOverhead()));  
        restController.dispatchRequest(fakeRestRequest, channel, client.threadPool().getThreadContext());
                channel.sendResponse(new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY));
            + deprecatedMethod.name()
        ).withPath("/foo").build();
        restHeaders.put("header.2", Arrays.asList("foo", "foo"));
        AssertingChannel channel = new AssertingChannel(fakeRestRequest, true, RestStatus.OK);
            @Override  
        assertFalse(channel.getSendResponseCalled());
                    () -> channel.sendResponse(new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY))  
    public void testDispatchBadRequest() {  
    }
        restController.registerHandler(RestRequest.Method.GET, "/foo", new RestHandler() {
        AssertingChannel channel = new AssertingChannel(request, true, RestStatus.OK);
        );
        assertEquals(1, channel.getAcceptedCount());
        assertThat(channel.detailedErrorsEnabled(), equalTo(false));  
                }, RestRequest.Method.GET);
        restController.dispatchRequest(fakeRequest, channel, threadContext);
        final RestController restController = new RestController(null, null, null, circuitBreakerService, usageService);
                rejection.set(
        });
            super(request, detailedErrorsEnabled);  
import org.opensearch.core.xcontent.MediaType;  
        private final boolean failFirstSend;  
        private final AtomicBoolean failFirstPrepare;  
            }
            }
        restController.dispatchRequest(request, channel, client.threadPool().getThreadContext());  
        CountDownLatch firstSendEntered = new CountDownLatch(1);  
            @Override
        }  
        assertFalse(handlers.hasNext());
        assertEquals("true", threadContext.getHeader("header.1"));  
import org.opensearch.common.util.io.IOUtils;
        ).withPath("/foo").withHeaders(Collections.singletonMap("Content-Type", Collections.singletonList(mimeType))).build();  
        assertThat(channel.getRestResponse().content().utf8ToString(), containsString("unknown cause"));
        RestRequest.Method secondMethod = randomFrom(
    public void testHandleBadRequestWithInvalidCombinationForDetailedErrors() {
