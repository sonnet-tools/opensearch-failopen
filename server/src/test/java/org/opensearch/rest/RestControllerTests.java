            equalTo("{\"error\":\"Unexpected HTTP method, allowed: [GET]\",\"status\":405}")
        RestRequest request = testRestRequest("/", content, MediaTypeRegistry.JSON);
        restHeaders.put("header.3", Collections.singletonList("false"));
            }
                return true;
        final AssertingChannel channel = new AssertingChannel(fakeRestRequest, true, RestStatus.BAD_REQUEST);
        final AssertingChannel channel = new AssertingChannel(fakeRestRequest, false, RestStatus.OK);
 * Licensed to Elasticsearch under one or more contributor
            throw new IllegalArgumentException("test error");
                m -> m == RestRequest.Method.GET || m == RestRequest.Method.OPTIONS,
import org.opensearch.core.common.transport.TransportAddress;
        restController.dispatchRequest(fakeRestRequest, channel, client.threadPool().getThreadContext());
            }
        final FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withMethod(
        assertThat(channel.getRestResponse().getHeaders().containsKey("Allow"), equalTo(true));
            public boolean supportsStreaming() {
                    headers.put("Content-Type", Collections.singletonList("text/plain"));
        assertEquals(RestStatus.OK, channel.getLastStatus());
    public void testRegisterWithDeprecatedHandler() {
            @Override
            @Override
            .withParams(new HashMap<>(Map.of("error_trace", "false")))
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.List;
    }
        AssertingStreamingChannel channel = new AssertingStreamingChannel(request, true, RestStatus.INTERNAL_SERVER_ERROR, true);
        final RestHandler handler = (RestRequest request, RestChannel channel, NodeClient client) -> handlerCalled.set(true);
    public void testRegisterAsDeprecatedHandler() {
    }
        public void sendChunk(HttpChunk chunk) {
    public void testDispatchRequestAddsAndFreesBytesOnlyOnceOnError() {
 * ownership. Elasticsearch licenses this file to you under
    @Before
        @Override
        RestStatus getLastStatus() {
        restController.dispatchRequest(request, channel, client.threadPool().getThreadContext());
        boolean getSendResponseCalled() {
            RestRequest.Method.GET,
        assertFalse(channel.getSendResponseCalled());
            }
        assertThat(responseBodyString, containsString("\"status\":400"));
                    )
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicBoolean;
 */
        restController.dispatchRequest(fakeRestRequest, channel, client.threadPool().getThreadContext());
                channel.sendResponse(new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY));
        assertEquals("/favicon.ico", faviconHandler.getPath());
import org.opensearch.common.xcontent.yaml.YamlXContent;
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        restController.registerHandler(RestRequest.Method.GET, "/streaming-failing-send", new RestHandler() {
        @Override
import org.opensearch.test.OpenSearchTestCase;
import org.junit.Before;
        assertThat(channel.getRestResponse().getHeaders().containsKey("Allow"), equalTo(true));
        assertFalse(channel.getSendResponseCalled());
        String content = randomAlphaOfLength((int) Math.round(contentLength / inFlightRequestsBreaker.getOverhead()));
                return this;
     * When the first send fails inside the downstream channel, nothing has reached the client yet. The failure response
        restController.dispatchRequest(fakeRestRequest, channel, client.threadPool().getThreadContext());
        ).withPath("/foo").withHeaders(Collections.singletonMap("Content-Type", Collections.singletonList(mimeType))).build();
            public List<String> strictCookies() {
        );
            .build();
            .withMethod(RestRequest.Method.GET)
        final HttpServerTransport httpServerTransport = new TestHttpServerTransport();
                channel.sendResponse(new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY));
        client = new NoOpNodeClient(this.getTestName());
    }
                + " compressed xcontent bytes\"}],\"type\":\"not_x_content_exception\",\"reason\":\"Compressor detection can only be called on some xcontent "
    }
        RestRequest fakeRequest = new FakeRestRequest.Builder(xContentRegistry()).withHeaders(restHeaders).build();
        assertThat(
        );
    public void testDispatchRequestAddsAndFreesBytesOnSuccess() {
            }
        restController.registerHandler(RestRequest.Method.GET, "/double-send", (request, channel, client) -> {
        doAnswer(invocation -> {
    /**
        );
                );
        assertThat(channel.getRestResponse().contentType(), containsString("image/x-icon"));
                return "/";
        doCallRealMethod().when(controller).registerWithDeprecatedHandler(method, path, handler, deprecatedMethod, deprecatedPath);
        AssertingChannel channel = new AssertingChannel(request, true, RestStatus.BAD_REQUEST);
                    + "bytes or compressed xcontent bytes\""
        AtomicReference<IllegalStateException> rejection = new AtomicReference<>();
        @Override
            Mono.<HttpChunk>empty().subscribe(subscriber);
        restController.registerHandler(RestRequest.Method.GET, "/failing-send", (request, channel, client) -> {
 */
        @Override
            boolean detailedErrorsEnabled,
                firstSendEntered.countDown();
        );
        RestRequest request = testRestRequest("/wrapped", "{}", MediaTypeRegistry.JSON);
    public void testFaviconWithWrongHttpMethod() {
        final RestRequest.Method method = randomFrom(RestRequest.Method.values());
        );
        restHeaders.put("header.2", Arrays.asList("foo", "foo"));
            public HttpRequest releaseAndCopy() {
        assertThat(rejection.get().getMessage(), containsString("already sent"));
        AssertingChannel channel = new AssertingChannel(fakeRequest, false, RestStatus.OK);
            + "] is deprecated! Use ["
            super(request, detailedErrorsEnabled, expectedStatus);
        assertTrue(channel.getSendResponseCalled());
import static org.mockito.Mockito.any;
        int contentLength = BREAKER_LIMIT.bytesAsInt();
            public BytesReference content() {
                releaseFirstSend.countDown();
        restHeaders.put("header.1", Collections.singletonList("boo"));
                }
            @Override
        restController.registerHandler(RestRequest.Method.GET, "/foo", new RestHandler() {
                    assertNull(threadContext.getHeader("header.3"));
    public void testDispatchRequestAddsAndFreesBytesOnError() {
import static org.hamcrest.Matchers.equalTo;
                }
        AssertingChannel channel = new AssertingChannel(fakeRequest, false, RestStatus.BAD_REQUEST);
        return new Thread(() -> {
    public void testNonStreamingXContentCausesErrorResponse() throws IOException {
import static org.mockito.Mockito.doAnswer;
    public void testDispatchRequestLimitsBytes() {
            .withMethod(RestRequest.Method.PUT)
                return true;
            IllegalArgumentException.class,
        public void subscribe(Subscriber<? super HttpChunk> subscriber) {
            } catch (Throwable t) {
        verify(controller).registerHandler(eq(method), eq(path), any(DeprecationRestHandler.class));
        final RestController restController = new RestController(headers, null, null, circuitBreakerService, usageService);
        RestRequest.Method firstMethod = randomFrom(RestRequest.Method.values());
        }
            @Override
                return headers;
        final ThreadContext threadContext = client.threadPool().getThreadContext();
        doCallRealMethod().when(controller).registerAsDeprecatedHandler(method, path, handler, deprecationMessage);
            channel,
        restHeaders.put("header.2", Arrays.asList("foo", "bar"));
        final FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withPath("/foo")
        assertEquals(0, inFlightRequestsBreaker.getUsed());
        controller.registerAsDeprecatedHandler(method, path, handler, deprecationMessage);
import static org.mockito.Mockito.when;
        RestResponse getRestResponse() {
        private AssertingStreamingChannel(
        assertTrue(channel.getSendResponseCalled());
        @Override
                }, RestRequest.Method.GET);
        final AssertingChannel channel = new AssertingChannel(fakeRestRequest, true, RestStatus.BAD_REQUEST);
        restController.registerHandler(RestRequest.Method.PUT, "/foo", new RestCreateIndexAction());
        assertNull(firstFailure.get());
        });
    }
            public void handleRequest(RestRequest request, RestChannel channel, NodeClient client) {
        final RestController restController = new RestController(headers, null, client, circuitBreakerService, usageService);
        protected void doStop() {}
        httpServerTransport.start();
            new BytesArray(content),
        }, null);
            super(request, detailedErrorsEnabled);
            rejection.set(
        restController.dispatchBadRequest(channel, client.threadPool().getThreadContext(), null);
        controller.registerWithDeprecatedHandler(method, path, handler, deprecatedMethod, deprecatedPath);
    }
        FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withContent(
        assertThat(responseBodyString, containsString("\"type\":\"not_x_content_exception\""));
    public void testRequestWithDisallowedMultiValuedHeaderButSameValues() {
        RestRequest request = testRestRequest("/failing-send", breakerFillingContent(), MediaTypeRegistry.JSON);
        assertThat(channel.getRestResponse().getHeaders().get("Allow"), hasItem(equalTo(RestRequest.Method.GET.toString())));
            }
        assertEquals(2, channel.getAttemptCount());
            "/",
            public boolean hasNext() {
        Set<RestHeaderDefinition> headers = new HashSet<>(
    public void testDispatchBadRequestUnknownCause() {
            return true;
                )
        String responseBodyString = channel.getRestResponse().content().utf8ToString();
     */
    public void testSendResponseAfterSuccessfulSendIsRejected() {
}
        RestRequest request = testRestRequest("/streaming-failing-send", breakerFillingContent(), MediaTypeRegistry.JSON);
                return true;
        assertFalse(handlerCalled.get());
            public HttpRequest removeHeader(String header) {
        protected ExceptionThrowingChannel(RestRequest request, boolean detailedErrorsEnabled) {
        AtomicBoolean wrapperCalled = new AtomicBoolean(false);
        final String mimeType = randomFrom("application/json", "application/smile");
        restController.dispatchRequest(request, channel, client.threadPool().getThreadContext());
        assertEquals(Set.of(RestRequest.Method.GET, RestRequest.Method.PATCH), rootHandler.getValidMethods());
            try {
            }
        Set<RestHeaderDefinition> headers = new HashSet<>(
        );
        MethodHandlers faviconHandler = handlers.next();
 * You may obtain a copy of the License at
            }
        assertThat(
        restController.registerHandler(RestRequest.Method.GET, "/foo", new RestHandler() {
    public void testDispatchWorksWithNewlineDelimitedJson() {
        assertThat(responseBodyString, not(containsString("stack_trace")));
        assertEquals(0, inFlightRequestsBreaker.getUsed());
        restController.dispatchRequest(fakeRestRequest, channel, client.threadPool().getThreadContext());
            () -> restController.registerHandler(secondMethod, path + "/{wildcard2}", handler)
                expectThrows(
        RestHandler handler = mock(RestHandler.class);
    public void testConcurrentSendResponseIsRejected() {
            this(request, detailedErrorsEnabled, expectedStatus, false);
        final RestController restController = new RestController(null, null, null, circuitBreakerService, usageService);
                return this;
        final RestRequest request = RestRequest.request(xContentRegistry(), new HttpRequest() {
        restHeaders.put("header.1", Collections.singletonList("true"));
    private static Thread sendResponseOnNewThread(RestChannel channel, RestResponse response, AtomicReference<Throwable> failure) {
    private HierarchyCircuitBreakerService circuitBreakerService;
        }
import org.opensearch.http.HttpResponse;
            public boolean supportsContentStream() {
        IllegalArgumentException exception = expectThrows(
        ExceptionThrowingChannel channel = new ExceptionThrowingChannel(request, true);
        }
            public HttpResponse createResponse(RestStatus status, BytesReference content) {
            }
        private final AtomicInteger acceptedCount = new AtomicInteger();
    public void testStreamingFailureResponseIsSentAndSubsequentSendIsRejected() {
        final AssertingChannel channel = new AssertingChannel(fakeRestRequest, true, RestStatus.METHOD_NOT_ALLOWED);
            .withContent(new BytesArray("ddd"), MediaTypeRegistry.JSON)
                return new RestMethodHandlers("/", (RestRequest request, RestChannel channel, NodeClient client) -> {
            )
                    () -> channel.sendResponse(new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY))
        restController.registerHandler(RestRequest.Method.GET, "/wrapped", handler);
import static org.hamcrest.Matchers.hasItem;
import static org.mockito.Mockito.spy;
        AssertingChannel channel = new AssertingChannel(request, true, RestStatus.OK);
            @Override
        Map<String, List<String>> restHeaders = new HashMap<>();
        FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withContent(
        builder.withContent(new BytesArray(content), mediaType);
            public HttpVersion protocolVersion() {
        assertThat(channel.detailedErrorStackTraceEnabled(), equalTo(true));
        int contentLength = BREAKER_LIMIT.bytesAsInt();
            }
            responseReference.set(response);
 * not use this file except in compliance with the License.
        @Override
        final String path = "/_" + randomAlphaOfLengthBetween(1, 6);
            }
        @Override
        restController.dispatchRequest(fakeRestRequest, channel, client.threadPool().getThreadContext());
        assertEquals(0, inFlightRequestsBreaker.getUsed());
    public void testFailureResponseIsSentWhenFirstSendResponseFails() {
        int contentLength = BREAKER_LIMIT.bytesAsInt();
            (r, c, client) -> c.sendResponse(new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY))
        assertThat(channel.getRestResponse().content().utf8ToString(), containsString("unknown cause"));
                    )
            Thread secondSend = sendResponseOnNewThread(channel, response, secondFailure);
    /**
            (request, channel, client) -> channel.sendResponse(
            public RestRequest.Method method() {
import org.opensearch.test.client.NoOpNodeClient;
            )
        circuitBreakerService = new HierarchyCircuitBreakerService(
    public void testDispatchWithContentStream() {
        public boolean isReadable() {
        verify(controller).registerAsDeprecatedHandler(deprecatedMethod, deprecatedPath, handler, deprecationMessage);
        int contentLength = BREAKER_LIMIT.bytesAsInt() + 1;
            return response == null ? null : response.status();
    @After
            @Override
            }
            }
            "/",
            RestResponse response = new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY);
            BytesReference.bytes(YamlXContent.contentBuilder().startObject().endObject()),
        final FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).build();
        String content = randomAlphaOfLength((int) Math.round(contentLength / inFlightRequestsBreaker.getOverhead()));
            return null;
import org.opensearch.http.HttpServerTransport;
    }
        });
        assertEquals(0, inFlightRequestsBreaker.getTrippedCount());
        }
            }
            }
        CountDownLatch firstSendEntered = new CountDownLatch(1);
            + " "
import java.util.Arrays;
        );
        assertEquals(1, channel.getAcceptedCount());
/*
        restController = new RestController(Collections.emptySet(), null, null, circuitBreakerService, usageService);
import org.opensearch.core.xcontent.NamedXContentRegistry;
        assertEquals(0, inFlightRequestsBreaker.getUsed());
                "\"reason\":\"Compressor detection can only be called on some xcontent bytes " + "or compressed xcontent bytes\""
            throw new AssertionError("sendChunk is not expected in this test");
                "{\"error\":{\"root_cause\":[{\"type\":\"not_x_content_exception\",\"reason\":\"Compressor detection can only be called on some xcontent "
            containsString(
    }
        assertTrue(channel.getSendResponseCalled());
        restController.dispatchBadRequest(
            if (blockFirstSend.compareAndSet(true, false)) {
        String content = randomAlphaOfLength((int) Math.round(BREAKER_LIMIT.getBytes() / inFlightRequestsBreaker.getOverhead()));
    }
            }
        );
 * Modifications Copyright OpenSearch Contributors. See
        final String mimeType = "application/x-ndjson";
                if (hasContent) {
    }
        assertEquals("true", threadContext.getHeader("header.1"));
        );
        }
            @Override
import static org.mockito.Mockito.eq;
        String content = randomAlphaOfLength((int) Math.round(BREAKER_LIMIT.getBytes() / inFlightRequestsBreaker.getOverhead()));
        }
    }
        assertTrue(wrapperCalled.get());
    public void testUnknownContentWithContentStream() {
        AtomicReference<Throwable> secondFailure = new AtomicReference<>();
        final boolean hasContent = randomBoolean();
            responseBodyString,
        FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withContent(
import org.opensearch.http.HttpStats;
        final String deprecatedPath = "/_" + randomAlphaOfLengthBetween(1, 6);
                channel.sendResponse(new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY));
        }).when(delegate).sendResponse(any(RestResponse.class));
        // don't want to test everything -- just that it actually wraps the handlers
import java.util.Map;
        RestRequest request = testRestRequest("/", content, MediaTypeRegistry.JSON);
        RestRequest request = testRestRequest("/concurrent-send", breakerFillingContent(), MediaTypeRegistry.JSON);
/*
        RestRequest request = testRestRequest("/double-send", breakerFillingContent(), MediaTypeRegistry.JSON);
            public Exception getInboundException() {
            XContentType.YAML
            Settings.builder()
        final String deprecationMessage = "["
                .put(HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING.getKey(), false)
            null
        restController.registerHandler(RestRequest.Method.GET, "/foo", new RestHandler() {
        final RestController restController = new RestController(headers, null, null, circuitBreakerService, usageService);
        restController.registerHandler(RestRequest.Method.GET, "/foo", new RestHandler() {
 *
        assertThat(
        Set<RestHeaderDefinition> headers = new HashSet<>(
            return invocation.callRealMethod();
    }
        int getAttemptCount() {
        assertTrue(channel.getSendResponseCalled());
            }
                // Reported as an Error on purpose. RestController catches Exception and would otherwise resend over the
                IllegalStateException.class,
            assertSame(handler, h);
            .build();
            Arrays.stream(RestRequest.Method.values()).filter(m -> m != firstMethod).collect(Collectors.toList())
import org.opensearch.common.settings.ClusterSettings;
                );
                    assertEquals("true", threadContext.getHeader("header.1"));
        RestHandler handler = mock(RestHandler.class);
            .withContent(new BytesArray("ddd"), MediaTypeRegistry.JSON)
        assertTrue(handlers.hasNext());
    }
        }
        restController.registerHandler(RestRequest.Method.GET, "/error", (request, channel, client) -> {
            + deprecatedMethod.name()
        assertTrue(channel.getSendResponseCalled());
            @Override
import org.opensearch.http.HttpInfo;
import org.opensearch.common.util.io.IOUtils;
        restController.dispatchRequest(fakeRequest, channel, threadContext);
                throw new IllegalArgumentException("test");
        restController.dispatchRequest(fakeRequest, channel, threadContext);
    }
        assertEquals(RestStatus.INTERNAL_SERVER_ERROR, channel.getLastStatus());
            public String uri() {
        assertTrue(channel.getSendResponseCalled());
        public BoundTransportAddress boundAddress() {
    }
        });
    private UsageService usageService;
                return true;
        RestController controller = mock(RestController.class);
        RestRequest request = testRestRequest("/error", content, MediaTypeRegistry.JSON);
        }
    private NodeClient client;
        assertNull(threadContext.getHeader("header.3"));
            "/<script>alert('xss');alert(\"&#x6A&#x61&#x76&#x61\");</script>"
        final RestRequest.Method deprecatedMethod = randomFrom(RestRequest.Method.values());
        assertFalse(channel.getSendResponseCalled());
                assertFalse("concurrent send did not finish", secondSend.isAlive());
                rejection.set(
        restController.registerHandler(RestRequest.Method.GET, "/foo", mock(RestHandler.class));
        public void prepareResponse(RestStatus status, Map<String, List<String>> headers) {
            return new BoundTransportAddress(new TransportAddress[] { transportAddress }, transportAddress);
                + "bytes or compressed xcontent bytes\"},\"status\":400}",
            @Override
        });
        restController.dispatchRequest(fakeRestRequest, channel, client.threadPool().getThreadContext());
        assertThat(exception.getMessage(), equalTo("Trying to use conflicting wildcard names for same path: wildcard1 and wildcard2"));
                return randomFrom(HttpVersion.values());
            if (failFirstPrepare.compareAndSet(true, false)) {
    }
            public void handleRequest(RestRequest request, RestChannel channel, NodeClient client) throws Exception {
    public void testHandleBadInputWithCreateIndexReturnsOnlyErrorSummaryWithDisabledErrorTrace() {
            RestResponse response = getRestResponse();
     * A second {@link RestChannel#sendResponse} after one the delegate accepted is a handler bug, so it must still fail
            public boolean supportsContentStream() {
        }
    }
            @Override
        assertEquals(1, delegate.getAcceptedCount());
    public void testHandleBadRequestWithInvalidCombinationForDetailedErrors() {
        FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withContent(
                );
        assertEquals(1, channel.getAcceptedCount());
        assertEquals("/foo", rootHandler.getPath());
        restHeaders.put("header.1", Collections.singletonList("boo"));
            this.failFirstSend = failFirstSend;
        public void sendResponse(RestResponse response) {
import java.util.Iterator;
    }
            if (failFirstSend && attempt == 1) {
            .withContent(new BytesArray("ddd"), MediaTypeRegistry.JSON)
        String deprecationMessage = randomAlphaOfLengthBetween(1, 10);
        FakeRestRequest.Builder builder = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY);
            .withMethod(RestRequest.Method.PUT)
            public Map<String, List<String>> getHeaders() {
    public void testDispatchUnsupportedContentType() {
        RestRequest fakeRequest = new FakeRestRequest.Builder(xContentRegistry()).withHeaders(restHeaders).withPath("/bar").build();
            @Override
            }
        }
    }
                channel.sendResponse(new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY));
        assertEquals(0, inFlightRequestsBreaker.getUsed());
        final ThreadContext threadContext = client.threadPool().getThreadContext();
        AssertingChannel channel = new AssertingChannel(fakeRestRequest, true, RestStatus.NOT_ACCEPTABLE);
        // we will produce an error in the rest handler and one more when sending the error response
 * GitHub history for details.
            public void handleRequest(RestRequest request, RestChannel channel, NodeClient client) throws Exception {
     * Content sized to reserve the whole breaker limit, so that a missed release would be visible.
                channel.sendResponse(new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY));
                return true;
        assertEquals(0, inFlightRequestsBreaker.getTrippedCount());
            }
    }
            return acceptedCount.get();
    public void testDefaultRestControllerGetAllHandlersContainsFavicon() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            firstSend.start();
        Iterator<MethodHandlers> handlers = restController.getAllHandlers();
        assertNotNull(rejection.get());
    private static final class AssertingStreamingChannel extends AssertingChannel implements StreamingRestChannel {
            randomBoolean() ? new IllegalStateException("bad request") : new Throwable("bad request")
        AssertingChannel channel = new AssertingChannel(fakeRestRequest, true, RestStatus.NOT_ACCEPTABLE);
                channel.sendResponse(new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY));
        assertTrue(channel.getSendResponseCalled());
            .build();
            @Override
        assertThat(channel.getRestResponse().content().utf8ToString(), containsString("bad request"));
            .build();
import reactor.core.publisher.Mono;
    public void testApplyRelevantHeaders() throws Exception {
        AtomicBoolean handlerCalled = new AtomicBoolean(false);
        FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withContent(
            return true;
            .withHeaders(Collections.singletonMap("Content-Type", Collections.singletonList("application/x-www-form-urlencoded")))
        assertTrue(handlers.hasNext());
import static org.hamcrest.Matchers.containsString;
            public boolean supportsContentStream() {
        FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).build();
        MethodHandlers faviconHandler = handlers.next();
import org.opensearch.core.xcontent.MediaType;
        protected void doStart() {}
                failure.set(t);
import static org.mockito.Mockito.mock;
        String content = randomAlphaOfLength((int) Math.round(BREAKER_LIMIT.getBytes() / inFlightRequestsBreaker.getOverhead()));
    }
        assertTrue(channel.getSendResponseCalled());
        );
            @Override
        restController.registerHandler(
        int contentLength = BREAKER_LIMIT.bytesAsInt();
            return getRestResponse() != null;
    public void setup() {
                throw new IllegalStateException("response headers could not be prepared");
                return BytesArray.EMPTY;
        restController.dispatchRequest(request, channel, client.threadPool().getThreadContext());
            // The channel rejects the first response, standing in for a body that cannot be serialized.
        final AssertingChannel channel = new AssertingChannel(request, true, RestStatus.METHOD_NOT_ALLOWED);
        assertThat(channel.detailedErrorStackTraceEnabled(), equalTo(false));
        ).withPath("/foo").withHeaders(Collections.singletonMap("Content-Type", Collections.singletonList("text/plain"))).build();
        restController.dispatchRequest(fakeRestRequest, channel, client.threadPool().getThreadContext());
        @Override
        verify(controller).registerHandler(method, path, handler);
        assertTrue(channel.getSendResponseCalled());
    }
    }
        AssertingChannel channel = new AssertingChannel(fakeRestRequest, true, RestStatus.NOT_ACCEPTABLE);
        AtomicBoolean blockFirstSend = new AtomicBoolean(true);
        assertFalse(channel.getSendResponseCalled());
        final RestController controller = mock(RestController.class);
    public void testRegisterSecondMethodWithDifferentNamedWildcard() {
        assertNotNull(rejection.get());
     */
        assertThat(
        public AssertingChannel(RestRequest request, boolean detailedErrorsEnabled, RestStatus expectedStatus, boolean failFirstSend) {
        }
        }
            }
        AssertingChannel delegate = spy(new AssertingChannel(request, true, RestStatus.OK));
        assertThat(channel.detailedErrorsEnabled(), equalTo(false));
    }
    public void testHandleBadInputWithCreateIndexReturnsDetailedErrorStackTraceWhenRequested() {
        assertFalse(channel.getSendResponseCalled());
    }
            @Override
        assertEquals("/favicon.ico", faviconHandler.getPath());
        ) {
    }
                // We want to have reproducible results in this test, hence we disable real memory usage accounting
import org.opensearch.http.HttpChunk;
                secondSend.join(10_000L);
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
            public void release() {}
            }
            boolean failFirstPrepare
                    return new BytesArray("test");
        AssertingChannel channel = new AssertingChannel(fakeRestRequest, true, RestStatus.OK);
import org.reactivestreams.Subscriber;
            channel.getRestResponse().content().utf8ToString()
    private static RestRequest testRestRequest(String path, String content, MediaType mediaType) {
                );
            public void handleRequest(RestRequest request, RestChannel channel, NodeClient client) throws Exception {
        assertEquals(0, inFlightRequestsBreaker.getUsed());
            acceptedCount.incrementAndGet();
        restController.dispatchRequest(request, channel, client.threadPool().getThreadContext());
        assertFalse(handlers.hasNext());
        }
            .withPath("/")
    }
import org.opensearch.common.settings.Settings;
            public void handleRequest(RestRequest request, RestChannel channel, NodeClient client) throws Exception {
            .withPath("/favicon.ico")
        ).withPath("/favicon.ico").build();
    }
        assertEquals(Set.of(RestRequest.Method.GET), faviconHandler.getValidMethods());
        });
    private static final class ExceptionThrowingChannel extends AbstractRestChannel {
        assertEquals(RestStatus.OK, delegate.getLastStatus());
                        new BytesRestResponse(RestStatus.ACCEPTED, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY)
    }
        assertFalse(channel.getSendResponseCalled());
        AtomicReference<Throwable> firstFailure = new AtomicReference<>();
import org.opensearch.http.HttpRequest;
        MethodHandlers rootHandler = handlers.next();
                    IllegalStateException.class,
        restController.dispatchRequest(fakeRestRequest, channel, client.threadPool().getThreadContext());
 * KIND, either express or implied.  See the License for the
        restController.dispatchRequest(fakeRestRequest, channel, client.threadPool().getThreadContext());
            this.expectedStatus = expectedStatus;
 * The OpenSearch Contributors require contributions made to
        );
        }
        assertEquals(RestStatus.INTERNAL_SERVER_ERROR, channel.getLastStatus());
        assertThat(responseBodyString, containsString("\"status\":400"));
            client.threadPool().getThreadContext(),
        final RestController restController = new RestController(Collections.emptySet(), h -> {
        restController.dispatchRequest(fakeRestRequest, channel, client.threadPool().getThreadContext());
            return (RestRequest request, RestChannel channel, NodeClient client) -> wrapperCalled.set(true);
                return null;
                    assertEquals("true", threadContext.getHeader("header.2"));
        @Override
            containsString(
        assertTrue(channel.getSendResponseCalled());
        assertEquals(1, channel.getAttemptCount());
            + deprecatedPath
    public void testRequestWithDisallowedMultiValuedHeader() {
        private final AtomicReference<RestResponse> responseReference = new AtomicReference<>();
        assertTrue(channel.getSendResponseCalled());
            );
            .withMethod(RestRequest.Method.PUT)
        restController.registerHandler(firstMethod, path + "/{wildcard1}", handler);
            channel.sendResponse(new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY));
            expectThrows(
                throw new AssertionError("failure response was rejected after the first send failed", e);
            @Override
        }
        RestRequest request = testRestRequest("/", content, null);
import org.opensearch.rest.action.admin.indices.RestCreateIndexAction;
                // raw channel, hiding the fact that this channel rejected the failure response.
    }
                channel.sendResponse(
        public AssertingChannel(RestRequest request, boolean detailedErrorsEnabled, RestStatus expectedStatus) {
    }
            .build();
            @Override
        assertEquals(1, delegate.getAttemptCount());
    /**
        AtomicReference<IllegalStateException> rejection = new AtomicReference<>();
            public RestMethodHandlers next() {
        AssertingChannel channel = new AssertingChannel(fakeRestRequest, true, RestStatus.OK);
        restController.registerHandler(
        restController.dispatchRequest(request, channel, client.threadPool().getThreadContext());
        assertEquals("true", threadContext.getHeader("header.2"));
                    () -> channel.sendResponse(
 *
        assertThat(channel.getRestResponse().content().utf8ToString(), containsString("error traces in responses are disabled."));
            .withParams(Map.of("error_trace", "true"))
        String responseBodyString = channel.getRestResponse().content().utf8ToString();
    }
            randomValueOtherThanMany(
                assertTrue("first send did not reach the delegate", firstSendEntered.await(10, TimeUnit.SECONDS));
            Collections.emptyList(),
            return attemptCount.get();
        AssertingChannel channel = new AssertingChannel(request, true, RestStatus.INTERNAL_SERVER_ERROR, true);
            }
                .build(),
        ).withPath("/foo").build();
        AssertingChannel channel = new AssertingChannel(request, true, RestStatus.BAD_REQUEST);
    }
    public void testDispatchBadRequest() {
        assertThat(secondFailure.get().getMessage(), containsString("already sent"));
        @Override
        AssertingChannel channel = new AssertingChannel(fakeRestRequest, true, RestStatus.OK);
        });
        ).build();
        // we can do this here only because we know that we don't adjust breaker settings dynamically in the test
            }
        restController.dispatchRequest(fakeRestRequest, channel, client.threadPool().getThreadContext());
        final FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withPath("/foo")
        restController.dispatchRequest(request, channel, client.threadPool().getThreadContext());
import org.opensearch.core.xcontent.MediaTypeRegistry;
        usageService = new UsageService();
                return null;
 * license agreements. See the NOTICE file distributed with
        when(spyRestController.getAllRestMethodHandlers(null, fakeRequest.rawPath())).thenReturn(new Iterator<RestMethodHandlers>() {
import static org.mockito.Mockito.doCallRealMethod;
        AssertingChannel channel = new AssertingChannel(fakeRequest, false, RestStatus.BAD_REQUEST);
        final FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withPath("/foo")
        public HttpStats stats() {
    }
    }
        restController.registerHandler(RestRequest.Method.PUT, "/foo", new RestCreateIndexAction());
import static org.hamcrest.Matchers.not;
                if (hasContent) {
                secondSend.start();
                    new BytesRestResponse(RestStatus.INTERNAL_SERVER_ERROR, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY)
import org.opensearch.common.util.concurrent.ThreadContext;
        });
        RestRequest fakeRequest = new FakeRestRequest.Builder(xContentRegistry()).withHeaders(restHeaders).build();
    public static class AssertingChannel extends AbstractRestChannel {
        FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withContent(new BytesArray("{}"), null)
            Thread firstSend = sendResponseOnNewThread(channel, response, firstFailure);
import org.opensearch.usage.UsageService;
 */
        restController.dispatchRequest(fakeRequest, channel, threadContext);
        assertEquals(1, inFlightRequestsBreaker.getTrippedCount());
    public void testRestControllerGetAllHandlers() {
 * Unless required by applicable law or agreed to in writing,
        assertTrue(channel.getSendResponseCalled());
            } finally {
            new BytesArray(content),
    public void teardown() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
 * under the License.
     */
        restController.registerHandler(RestRequest.Method.GET, "/concurrent-send", (restRequest, channel, client) -> {
            + "] instead.";
        final AssertingChannel channel = new AssertingChannel(fakeRestRequest, true, RestStatus.BAD_REQUEST);
        public boolean isWritable() {
            }
            )
 * this work for additional information regarding copyright
        assertThat(channel.getRestResponse().content().utf8ToString(), containsString("invalid uri has been requested"));
                return true;
        final RestController restController = new RestController(null, null, null, circuitBreakerService, usageService);
            return null;
                        () -> channel.sendResponse(
        private final AtomicInteger attemptCount = new AtomicInteger();
        RestRequest.Method secondMethod = randomFrom(
        // the rest controller relies on the caller to stash the context, so we should expect these values here as we didn't stash the
        final AssertingChannel channel = new AssertingChannel(fakeRestRequest, true, RestStatus.BAD_REQUEST);
        restController.registerHandler(RestRequest.Method.PATCH, "/foo", mock(RestHandler.class));
            "{\"error\":{\"root_cause\":[{\"type\":\"not_x_content_exception\",\"reason\":\"Compressor detection can only be called on some xcontent bytes or"
            responseBodyString,
            assertEquals(expectedStatus, response.status());
            throw new IllegalStateException("always throwing an exception for testing");
            return responseReference.get();
 *    http://www.apache.org/licenses/LICENSE-2.0
            firstSend.join(10_000L);
                return false;
        assertEquals(0, inFlightRequestsBreaker.getUsed());
            @Override
            int attempt = attemptCount.incrementAndGet();
        AssertingChannel channel = new AssertingChannel(request, true, RestStatus.OK);
import java.util.concurrent.CountDownLatch;
        public void sendResponse(RestResponse response) {
        ).withPath("/foo").withHeaders(Collections.singletonMap("Content-Type", contentTypeHeader)).build();
        restController.registerHandler(RestRequest.Method.GET, "/bar", new RestHandler() {
        assertTrue(handlers.hasNext());
        httpServerTransport.start();
/*
            TransportAddress transportAddress = buildNewFakeTransportAddress();
 * specific language governing permissions and limitations
    public void testDispatchWithContentStreamNoContentType() {
        final RestController restController = new RestController(null, null, null, circuitBreakerService, usageService);
            new BytesArray(content),
import org.opensearch.core.common.bytes.BytesReference;
                    throw new AssertionError("timed out waiting to release the first send");
        restController.dispatchRequest(fakeRestRequest, channel, client.threadPool().getThreadContext());
                    expectThrows(
        String path = "/_" + randomAlphaOfLengthBetween(1, 6);
        );
        }
        }
    }
        assertTrue(channel.getSendResponseCalled());
    public void testDispatchFailsWithPlainText() {
    public void testDispatchDoesNotRequireContentTypeForRequestsWithoutContent() {
            null
        restController.registerHandler(RestRequest.Method.GET, "/foo", new RestHandler() {
                }
        restHeaders.put("header.2", Collections.singletonList("true"));
            } catch (IllegalStateException e) {
        });
        assertEquals(1, channel.getAttemptCount());
        String content = randomAlphaOfLength((int) Math.round(contentLength / inFlightRequestsBreaker.getOverhead()));
        final RestHandler handler = mock(RestHandler.class);
        restController.dispatchRequest(request, channel, client.threadPool().getThreadContext());
        assertEquals(0, inFlightRequestsBreaker.getTrippedCount());
        restController.dispatchRequest(request, channel, client.threadPool().getThreadContext());
import org.opensearch.test.rest.FakeRestRequest;
            }
    private CircuitBreaker inFlightRequestsBreaker;
import org.opensearch.core.common.transport.BoundTransportAddress;
        assertTrue(channel.getSendResponseCalled());
            @Override
    private static final class TestHttpServerTransport extends AbstractLifecycleComponent implements HttpServerTransport {
        restController.dispatchRequest(fakeRestRequest, channel, client.threadPool().getThreadContext());
        assertFalse(channel.getSendResponseCalled());
            public void handleRequest(RestRequest request, RestChannel channel, NodeClient client) throws Exception {
        assertThat(channel.getRestResponse().getHeaders().get("Allow"), hasItem(equalTo(RestRequest.Method.GET.toString())));
    private static final ByteSizeValue BREAKER_LIMIT = new ByteSizeValue(20);
import static org.mockito.Mockito.verify;
    private String breakerFillingContent() {
        assertEquals(0, inFlightRequestsBreaker.getUsed());
            public void handleRequest(RestRequest request, RestChannel channel, NodeClient client) throws Exception {
import java.io.IOException;
            RestRequest request,
                        )
            + " "
    public void testRestHandlerWrapper() throws Exception {
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicReference;
        TestHttpServerTransport() {}
        return builder.build();
import org.junit.After;
                    new BytesRestResponse(RestStatus.INTERNAL_SERVER_ERROR, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY)
            this.failFirstPrepare = new AtomicBoolean(failFirstPrepare);
        });
    }
        Map<String, List<String>> restHeaders = new HashMap<>();
     * loudly instead of writing two responses onto the same connection.
        final AssertingChannel channel = new AssertingChannel(fakeRestRequest, true, RestStatus.BAD_REQUEST);
            .withPath("/foo")
        restController.registerHandler(RestRequest.Method.PUT, "/foo", new RestCreateIndexAction());
            .withParams(new HashMap<>(Map.of("error_trace", "true")))
        assertFalse(channel.getSendResponseCalled());
        String content = randomAlphaOfLength((int) Math.round(BREAKER_LIMIT.getBytes() / inFlightRequestsBreaker.getOverhead()));
        restController.dispatchRequest(request, channel, client.threadPool().getThreadContext());
        });
        restController.dispatchRequest(request, delegate, client.threadPool().getThreadContext());
import org.opensearch.core.common.unit.ByteSizeValue;
        });
        final RestController spyRestController = spy(restController);
            }
import java.util.Set;
            @Override
 * this file be licensed under the Apache-2.0 license or a
            @Override
        final FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withPath("/foo")
            )
        assertFalse(channel.getSendResponseCalled());
public class RestControllerTests extends OpenSearchTestCase {
        private final RestStatus expectedStatus;
                if (releaseFirstSend.await(10, TimeUnit.SECONDS) == false) {
        String content = randomAlphaOfLength((int) Math.round(contentLength / inFlightRequestsBreaker.getOverhead()));
    }
        });
        assertTrue(channel.getSendResponseCalled());
package org.opensearch.rest;
        public HttpInfo info() {
            RestStatus expectedStatus,
        );
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;
        IOUtils.close(client);
                            new BytesRestResponse(RestStatus.ACCEPTED, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY)
import org.opensearch.common.xcontent.XContentType;
            );
            @Override
                "\"stack_trace\":\"OpenSearchException[Compressor detection can only be called on some xcontent bytes or compressed xcontent bytes];"
            @Override
 * compatible open source license.
        ).withPath("/foo").withHeaders(Collections.singletonMap("Content-Type", Collections.singletonList("foo/bar"))).build();
            }
            channel.getRestResponse().content().utf8ToString(),
        CountDownLatch releaseFirstSend = new CountDownLatch(1);
        Iterator<MethodHandlers> handlers = restController.getAllHandlers();
        RestRequest request = testRestRequest("/error", content, MediaTypeRegistry.JSON);
            Arrays.asList(new RestHeaderDefinition("header.1", true), new RestHeaderDefinition("header.2", true))
            try {
                return null;
            }
                throw new IllegalStateException("response body could not be serialized");
        restController.registerHandler(RestRequest.Method.GET, "/foo", new RestHandler() {
        int getAcceptedCount() {
        final AssertingChannel channel = new AssertingChannel(fakeRestRequest, true, RestStatus.BAD_REQUEST);
                channel.sendResponse(
            @Override
        FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withContent(new BytesArray("{}"), null)
        assertEquals(
        assertTrue(secondFailure.get() instanceof IllegalStateException);
        final List<String> contentTypeHeader = Collections.singletonList(mimeType);
        assertFalse(channel.getSendResponseCalled());
import java.util.HashMap;
            public boolean supportsContentStream() {
                new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY)
            + path
     * must therefore still be delivered over the same channel even though the breaker reservation was already released.
        final AssertingChannel channel = new AssertingChannel(fakeRestRequest, false, RestStatus.BAD_REQUEST);
            assertFalse("first send did not finish", firstSend.isAlive());
    public void testDispatchUnsupportedHttpMethod() {
        }
            responseBodyString,
import org.opensearch.core.rest.RestStatus;
    private RestController restController;
    }
        restController.dispatchRequest(fakeRestRequest, channel, client.threadPool().getThreadContext());
        assertThat(rejection.get().getMessage(), containsString("already sent"));
        AssertingChannel channel = new AssertingChannel(request, true, RestStatus.TOO_MANY_REQUESTS);
        assertEquals(1, channel.getAcceptedCount());
        protected void doClose() {}
        final FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).build();
    public void testHandleBadInputWithCreateIndex() {
        inFlightRequestsBreaker = circuitBreakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS);
                channel.sendResponse(response);
            RestRequest.Method.GET,
            @Override
 *
    public void testFavicon() {
        restController.dispatchRequest(request, channel, client.threadPool().getThreadContext());
            .build();
    }
            containsString(
        AssertingChannel channel = new AssertingChannel(request, true, RestStatus.NOT_ACCEPTABLE);
                () -> randomFrom(RestRequest.Method.values())
        assertThat(channel.detailedErrorStackTraceEnabled(), equalTo(true));
                channel.sendResponse(new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY));
        // don't want to test everything -- just that it actually wraps the handler
        @Override
import org.opensearch.core.common.bytes.BytesArray;
            )
            public boolean supportsContentStream() {
        assertTrue(channel.getSendResponseCalled());
            .build();
            public void handleRequest(RestRequest request, RestChannel channel, NodeClient client) throws Exception {
        }, client, circuitBreakerService, usageService);
                Map<String, List<String>> headers = new HashMap<>();
        final ThreadContext threadContext = client.threadPool().getThreadContext();
            }
            }
        private final boolean failFirstSend;
            }
            RestRequest.parseContentType(contentTypeHeader)
        AssertingChannel channel = new AssertingChannel(fakeRestRequest, true, RestStatus.NOT_ACCEPTABLE);
                        IllegalStateException.class,
        final String path = "/_" + randomAlphaOfLengthBetween(1, 6);
        );
        }
            @Override
        private final AtomicBoolean failFirstPrepare;
            Arrays.asList(new RestHeaderDefinition("header.1", true), new RestHeaderDefinition("header.2", false))
        @Override
            }
        HttpServerTransport httpServerTransport = new TestHttpServerTransport();
        Map<String, List<String>> restHeaders = new HashMap<>();
        // context in this test
import java.util.stream.Collectors;
            @Override
    public void testDispatchRequiresContentTypeForRequestsWithContent() {
            try {
        restController.dispatchRequest(fakeRestRequest, channel, client.threadPool().getThreadContext());
            + method.name()
            null
                    IllegalStateException.class,
 * software distributed under the License is distributed on an
    }
            super(request, detailedErrorsEnabled);
        AssertingChannel channel = new AssertingChannel(fakeRestRequest, true, RestStatus.NOT_ACCEPTABLE);
                () -> channel.sendResponse(new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY))
    }
        final FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withPath(
        final FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withMethod(RestRequest.Method.GET)
        });
import org.opensearch.core.common.breaker.CircuitBreaker;
    }
    }
    public void testHandleBadRequestWithHtmlSpecialCharsInUri() {
        assertFalse(handlers.hasNext());
import org.opensearch.transport.client.node.NodeClient;
            Arrays.asList(new RestHeaderDefinition("header.1", true), new RestHeaderDefinition("header.2", false))
        });
        restController = new RestController(Collections.emptySet(), null, client, circuitBreakerService, usageService);
                .put(HierarchyCircuitBreakerService.IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), BREAKER_LIMIT)
    }
        builder.withPath(path);
            }
import java.util.concurrent.TimeUnit;
                expectThrows(
        @Override
            new BytesArray("aaaabbbbb"),
        RestRequest.Method method = randomFrom(RestRequest.Method.values());
        assertEquals(Set.of(RestRequest.Method.GET), faviconHandler.getValidMethods());
            @Override
        return randomAlphaOfLength((int) Math.round(contentLength / inFlightRequestsBreaker.getOverhead()));
