            assertEquals("test", r.getHits().get(0).getIndex());
        AtomicBoolean called = new AtomicBoolean();
import org.opensearch.client.ResponseException;
                callback.failed(failure);
    }
    }
            assertEquals(10000, r.getTotalHits());
                r.getFailures().get(0).getReason().getMessage()
                backoff(),
                        BasicClassicHttpResponse httpResponse = new BasicClassicHttpResponse(200, "");
        super.tearDown();
                HttpHost target,
                HandlerFactory<AsyncPushConsumer> pushHandlerFactory,
            @Override
        assertTrue(responseQueue.isEmpty());
            expectedInvocations = 1; // the first should fail and not trigger any retry.
    @SuppressWarnings("unchecked")
import static org.hamcrest.Matchers.empty;
            called.set(true);
                    if (path.startsWith("fail:")) {
import java.util.Queue;
    }
        sourceWithMockedRemoteCall(searchOKPaths).start();
                        String body = Streams.copyToString(new InputStreamReader(request.getEntity().getContent(), StandardCharsets.UTF_8));
            public ExecutorService executor(String name) {
                RemoteScrollableHitSourceTests.this.logger,
            expectedInvocations += 1; // first search
        searchRequest.scroll(timeValueMinutes(5));
                HttpContext context,
import org.apache.hc.core5.http.ContentTooLongException;
            assertEquals(4, r.getTotalHits());
        called.set(false);
        sourceWithMockedRemoteCall("start_scan.json", "scroll_ok.json").doStart(wrapAsListener(r -> {
        assertTrue(responseQueue.isEmpty());
            e = e.getCause();
            assertEquals(FAKE_SCROLL_ID, r.getScrollId());
    }
        }));
 * specific language governing permissions and limitations
            assertThat(r.getHits(), hasSize(1));
        RemoteScrollableHitSource source = sourceWithMockedClient(true, httpClient);
        return RejectAwareActionListener.wrap(consumer::accept, throwing, throwing);
    private static final String FAKE_SCROLL_ID = "DnF1ZXJ5VGhlbkZldGNoBQAAAfakescroll";
}
        // Use the response from a main action instead of a proper start response to generate a parse error
import java.util.concurrent.atomic.AtomicInteger;
    }
            assertEquals("{\"test\":\"test2\"}", r.getHits().get(0).getSource().utf8ToString());
import org.apache.hc.core5.function.Supplier;
            assertNull(r.getHits().get(0).getRouting());
        }));
    private static ClassicHttpRequest getRequest(AsyncRequestProducer requestProducer) {
        AtomicBoolean called = new AtomicBoolean();
    public void testRetryAndSucceed() throws Exception {
     * Creates a hit source that doesn't make the remote request and instead returns data from some files. Also requests are always returned
import java.io.UncheckedIOException;
        assertEquals(cause, wrapped.getCause());
        Exception failure,
        verifyRetries(true, withResponseCode(429, "Too many requests"), true);
 *
        assertEquals("Couldn't extract status [" + notAnHttpStatus + "]. Failed to extract body.", wrapped.getMessage());
            assertTrue(exception.compareAndSet(null, (T) e));
            @Override
    public void testWrapExceptionToPreserveStatus() throws IOException {
                AsyncResponseConsumer<T> responseConsumer,
        assertEquals(cause, wrapped.getCause());
                        if (path.equals("fail:rejection.json")) {
import static org.mockito.Mockito.verify;
            called.set(true);
            assertEquals(null, r.getFailures().get(0).getShardId());
                    ClassicHttpRequest request = getRequest(requestProducer);
        assertEquals(1, retries);
        retries = 0;
        assertTrue(responseQueue.isEmpty());
    private void failRequest(Throwable t) {
        e = expectThrows(RuntimeException.class, () -> response.done(timeValueMillis(0)));
            hitSource.remoteVersion = RemoteVersion.OPENSEARCH_3_1_0;
        response.done(timeValueMillis(0));
            .build();
import org.apache.hc.client5.http.impl.async.HttpAsyncClientBuilder;
                RemoteScrollableHitSourceTests.this.threadPool,
     * Versions of OpenSearch before 2.1.0 don't support sort:_doc and instead need to use search_type=scan. Scan doesn't return
            assertEquals("AVToMiDL50DjIiBO3yKA", r.getHits().get(0).getId());
            public void close(CloseMode closeMode) {}
        assertEquals("Couldn't extract status [" + notAnHttpStatus + "]. No error body.", wrapped.getMessage());
            "Error parsing the response, remote is likely not an OpenSearch instance",
        assertEquals("Couldn't extract status [" + notAnHttpStatus + "]. body=test body", wrapped.getMessage());
        return BackoffPolicy.constantBackoff(timeValueMillis(0), retriesAllowed);
        Mockito.when(mockResponse.getStatusLine()).thenReturn(new StatusLine(new BasicClassicHttpResponse(statusCode, errorMsg)));
            assertFalse(r.isTimedOut());
                command.run();
    @Before
            @Override
    public void testParseFailureWithStatus() throws Exception {
import java.util.concurrent.LinkedBlockingQueue;
    }
        assertTrue(called.get());
import org.opensearch.common.unit.TimeValue;
        }
        assertThat(response.response().getFailures(), empty());
            e.getCause().getCause().getCause().getCause().getMessage()
        }
        assertEquals(RestStatus.INTERNAL_SERVER_ERROR, wrapped.status());
        threadPool.getThreadContext().putHeader("test", header);
        verifyRetries(true, new RuntimeException("foobar"), false);
package org.opensearch.index.reindex.remote;
            assertEquals("test", r.getHits().get(0).getIndex());
 * SPDX-License-Identifier: Apache-2.0
                }
            assertEquals(
import java.util.concurrent.atomic.AtomicBoolean;
        assertTrue(called.get());
    }
        };
        // Successfully get the status without a body
            RuntimeException.class,
            .setHttpClientConfigCallback(httpClientBuilder -> clientBuilder)
    @Override
        CloseableHttpAsyncClient httpClient = new CloseableHttpAsyncClient() {
        int expectedInvocations = 0;
    }
import org.opensearch.test.OpenSearchTestCase;
        }));
 * this file be licensed under the Apache-2.0 license or a
        sourceWithMockedRemoteCall("scroll_ok.json").doStartNextScroll("", timeValueMillis(0), wrapAsListener(r -> {
            assertEquals("testrouting", r.getHits().get(0).getRouting());
            @Override
            @Override
        // Handling a scroll rejection is the same as handling a search rejection so we reuse the verification code
        }));
            public void close(CloseMode closeMode) {}
            called.set(true);
 * software distributed under the License is distributed on an
    @After
            @Override
    }
 * not use this file except in compliance with the License.
        assertEquals(RestStatus.INTERNAL_SERVER_ERROR, wrapped.status());
    }
        }));
    private int retries;
    public void testNoContentTypeIsError() {
    public void testLookupRemoteVersion() throws Exception {
        );
            public void close(CloseMode closeMode) {}
            e = e.getCause();
            assertNull(r.getScrollId());
        AtomicInteger invocationCount
    public void testThreadContextRestored() throws Exception {
        invocations.set(0);
                new BytesArray("{}"),
                    // Throw away the current thread context to simulate running async httpclient's thread pool
        // Unwrap the some artifacts from the test
    /**
        assertEquals(expectedInvocations, invocations.get());
        };
        return sourceWithMockedClient(mockRemoteVersion, httpClient);
            assertEquals("AVToMiDL50DjIiBO3yKA", r.getHits().get(0).getId());
        retriesAllowed = 0;
import static org.opensearch.common.unit.TimeValue.timeValueMinutes;
        );
import org.apache.hc.core5.http.message.RequestLine;
            assertFalse(r.isTimedOut());
        };
        };
        assertLookupRemoteVersion(RemoteVersion.ELASTICSEARCH_0_90_13, "main/0_90_13.json");
import org.opensearch.core.common.ParsingException;
                            callback.failed(new RuntimeException(body));
    private BackoffPolicy backoff() {
                AsyncRequestProducer requestProducer,
                    + "completed tasks = 4182]]",
import org.apache.hc.core5.http.message.BasicClassicHttpResponse;
                HttpHost target,
            assertEquals("test", r.getHits().get(0).getIndex());
        RemoteScrollableHitSource source = createRemoteSourceWithFailure(shouldMockRemoteVersion, failureResponse, invocations);
            protected <T> Future<T> doExecute(
    }
        assertTrue(called.get());
        assertEquals(status, wrapped.status());
import org.opensearch.core.util.FileSystemUtils;
            called.set(true);
            @Override
        sourceWithMockedRemoteCall("rejection.json").doStart(wrapAsListener(checkResponse));
            public void awaitShutdown(org.apache.hc.core5.util.TimeValue waitTime) throws InterruptedException {}
            resources[i] = Thread.currentThread().getContextClassLoader().getResource("responses/" + paths[i].replace("fail:", ""));
            assertEquals("10000", r.getHits().get(0).getId());
            assertFalse(r.isTimedOut());
                    URL resource = resources[responseCount];
    }
import java.nio.charset.StandardCharsets;
        verifyRetries(true, withResponseCode(400, "Client Error"), false);
import org.opensearch.index.reindex.RejectAwareActionListener;
        assertThat(response.response().getFailures(), empty());
            assertEquals(FAKE_SCROLL_ID, r.getScrollId());
        TestRemoteScrollableHitSource(RestClient client) {
            assertThat(r.getFailures(), empty());
        while (e.getMessage().equals("failed")) {
        assertNotNull(exception.get());
        );
import org.opensearch.threadpool.TestThreadPool;
        if (shouldMockRemoteVersion) {
        AtomicBoolean called = new AtomicBoolean();
        // And that exception is reported as being caused by the underlying exception returned by the client
    }
                throw new IllegalArgumentException("Couldn't find [" + paths[i] + "]");
        Consumer<Exception> throwing = e -> { throw new AssertionError(e); };
        assertEquals(
            assertFalse(r.isTimedOut());
import org.opensearch.threadpool.ThreadPool;
            public IOReactorStatus getStatus() {
        return sourceWithMockedClient(shouldMockRemoteVersion, httpClient);
        assertTrue(responseQueue.isEmpty());
        verifyRetries(true, new ConnectException("blah"), true); // should retry connect exceptions.
    private class TestRemoteScrollableHitSource extends RemoteScrollableHitSource {
            @Override
            @Override
            assertThat(r.getFailures().get(0).getReason(), instanceOf(RuntimeException.class));
        assertEquals(e.getMessage(), "Response didn't include supported Content-Type, remote is likely not an OpenSearch instance");
        doThrow(new RuntimeException("test")).when(client).close();
                        } else {
        AtomicReference<T> exception = new AtomicReference<>();
    }
            assertEquals(4, r.getTotalHits());
            public void close() throws IOException {}
        // The rejection comes through in the handler because the mocked http response isn't marked as an error
    }
    @SuppressWarnings("unchecked")
            }
            called.set(true);
import org.junit.After;
import java.util.concurrent.Future;
        wrapped = RemoteScrollableHitSource.wrapExceptionToPreserveStatus(notAnHttpStatus, okEntity, cause);
                    return null;
        verify(client).close();
        ScrollableHitSource.AsyncResponse response = responseQueue.poll();
            called.set(true);
     * documents the first iteration but reindex doesn't like that. So we jump start strait to the next iteration.
        }));
    private <T extends Exception, V> T expectListenerFailure(Class<T> expectedException, Consumer<RejectAwareActionListener<V>> subject) {
     */
        super.setUp();
import static org.mockito.Mockito.doThrow;
                        }
 * You may obtain a copy of the License at
    }
    private void countRetry() {
import org.apache.hc.core5.concurrent.FutureCallback;
        verifyRetries(false, withResponseCode(400, "Client Error"), false);
     */
            super(
import java.net.ConnectException;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.HttpHost;
            called.set(true);
    private RemoteScrollableHitSource sourceWithMockedRemoteCall(boolean mockRemoteVersion, ContentType contentType, String... paths) {
        assertTrue(called.get());
        assertEquals(
                HttpContext context,
        final ExecutorService directExecutor = OpenSearchExecutors.newDirectExecutorService();
            @Override
    }
                HandlerFactory<AsyncPushConsumer> pushHandlerFactory,
    public void testRetryUntilYouRunOutOfTries() throws Exception {
            );
        RuntimeException e = expectListenerFailure(
                r.getFailures().get(0).getReason().getMessage()
            assertThat(r.getFailures(), hasSize(1));
            @Override
            called.set(true);
    public void testTooLargeResponse() throws Exception {
import java.net.URL;
                }
        verifyRetries(false, withResponseCode(429, "Too many requests"), false);
            assertThat(r.getFailures(), empty());
import org.apache.hc.core5.http.io.entity.StringEntity;
        }
        hitSource.cleanup(() -> cleanupCallbackCalled.set(true));
            assertEquals("test", r.getHits().get(0).getIndex());
 * The OpenSearch Contributors require contributions made to
            assertEquals(null, r.getFailures().get(0).getIndex());
        // First call succeeds. Search call failed with exceptions other than ResponseException
        if (failureResponse instanceof ResponseException) {
import static org.mockito.Mockito.mock;
            public void start() {}
                RemoteScrollableHitSourceTests.this::countRetry,
    ResponseException withResponseCode(int statusCode, String errorMsg) throws IOException {
            assertEquals(0, r.getTotalHits());
    private void assertLookupRemoteVersion(RemoteVersion expected, String s) throws Exception {
                    String path = paths[responseCount++];
            ) {
        while (e.getMessage().equals("failed")) {
    /**
            (RejectAwareActionListener<RemoteVersion> listener) -> sourceWithMockedRemoteCall(false, null, "main/0_20_5.json")
    private RemoteScrollableHitSource sourceWithMockedRemoteCall(String... paths) throws Exception {
        HttpEntity badEntity = mock(HttpEntity.class);
        called.set(false);
            public void register(String hostname, String uriPattern, Supplier<AsyncPushConsumer> supplier) {}
                    threadPool.getThreadContext().stashContext();
import org.apache.hc.core5.http.nio.AsyncResponseConsumer;
            wrapAsListener(checkResponse)
            assertEquals(4, r.getTotalHits());
    }
    }
        assertThat(response.response().getFailures(), empty());
    private RemoteScrollableHitSource sourceWithMockedClient(boolean mockRemoteVersion, CloseableHttpAsyncClient httpClient) {
        // There is an additional wrapper for ResponseException.
        HttpEntity okEntity = new StringEntity("test body", ContentType.TEXT_PLAIN);
            }
        searchRequest = new SearchRequest();
        }));
        ScrollableHitSource.AsyncResponse response = responseQueue.poll();
            assertEquals("{\"test\":\"test3\"}", r.getHits().get(0).getSource().utf8ToString());
        for (int i = 0; i < retriesAllowed + 2; i++) {
public class RemoteScrollableHitSourceTests extends OpenSearchTestCase {
                responseQueue::add,
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
    }
            @Override
        Exception e = expectThrows(RuntimeException.class, () -> sourceWithMockedRemoteCall("some_text.txt").start());
            assertEquals(null, r.getFailures().get(0).getNodeId());
                AsyncResponseConsumer<T> responseConsumer,
            assertThat(r.getFailures(), hasSize(1));
 *
        // First call succeeds. Search calls failing with 5xxs and 429s should be retried but not 400s.
        assertTrue(responseQueue.isEmpty());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
                    new ByteSizeValue(100, ByteSizeUnit.MB).bytesAsInt(),
            public void close() throws IOException {}
     * Test for parsing _ttl, _timestamp, _routing, and _parent.
        assertTrue(called.get());
        assertEquals("body=test body", wrapped.getMessage());
        AtomicBoolean called = new AtomicBoolean();
            @Override
 * KIND, either express or implied.  See the License for the
import org.apache.hc.core5.http.nio.AsyncRequestProducer;
import static org.mockito.Mockito.when;
        AtomicBoolean called = new AtomicBoolean();
                "Unknown remote exception with reason=[SearchContextMissingException[No search context found for id [82]]]",
import org.apache.hc.core5.io.CloseMode;
            protected <T> Future<T> doExecute(
                try {
import java.util.concurrent.atomic.AtomicReference;
        String[] paths = new String[retriesAllowed + 2];
            assertEquals(header, threadPool.getThreadContext().getHeader("test"));
            assertEquals("87A7NvevQxSrEwMbtRCecg", r.getFailures().get(0).getNodeId());
            public IOReactorStatus getStatus() {
            }
        }
            assertEquals("test", r.getFailures().get(0).getIndex());
                return null;
            );
        verifyRetries(false, withResponseCode(500, "Internal Server Error"), false);
                        callback.completed((T) httpResponse);
        wrapped = RemoteScrollableHitSource.wrapExceptionToPreserveStatus(notAnHttpStatus, null, cause);
                    throw new UncheckedIOException(ex);
import org.opensearch.core.common.bytes.BytesArray;
            assertNull(r.getHits().get(0).getRouting());
    /**
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
    public void testParseRejection() throws Exception {
            assertEquals("testrouting", r.getHits().get(0).getRouting());
import org.opensearch.core.common.unit.ByteSizeValue;
                FutureCallback<T> callback
            public void close() throws IOException {}
            @Override
        );
            public ScheduledCancellable schedule(Runnable command, TimeValue delay, String name) {
        when(clientBuilder.build()).thenReturn(httpClient);
    public void setUp() throws Exception {
    }
 *
        AtomicBoolean called = new AtomicBoolean();
                    super.lookupRemoteVersion(listener);
        };
 * license agreements. See the NOTICE file distributed with
            ParsingException failure = (ParsingException) r.getFailures().get(0).getReason();
                return null;
    }
import org.opensearch.index.reindex.ScrollableHitSource;
    RemoteScrollableHitSource createRemoteSourceWithFailure(
import org.opensearch.client.RestClient;
import org.apache.hc.core5.reactor.IOReactorStatus;
        assertLookupRemoteVersion(RemoteVersion.OPENSEARCH_1_0_0, "main/OpenSearch_1_0_0.json");
     */
    @After
                return directExecutor;
        when(badEntity.getContent()).thenThrow(badEntityException);
            }
    /**
            "Error parsing the response, remote is likely not an OpenSearch instance",
        assertTrue(called.get());
                        httpResponse.setEntity(new InputStreamEntity(FileSystemUtils.openFileURLStream(resource), contentType));
    private ThreadPool threadPool;
                assertEquals(
                    }
        IOException badEntityException = new IOException();
    }
        // The rejection comes through in the handler because the mocked http response isn't marked as an error
    ) {
        wrapped = RemoteScrollableHitSource.wrapExceptionToPreserveStatus(notAnHttpStatus, badEntity, cause);
        assertTrue(cleanupCallbackCalled.get());
            assertEquals("{\"test\":\"test10000\"}", r.getHits().get(0).getSource().utf8ToString());
            assertThat(r.getHits(), hasSize(1));
            assertThat(e, instanceOf(expectedException));
        // Fail to get the status without a body
            assertEquals("AVToMiDL50DjIiBO3yKA", r.getHits().get(0).getId());
            "scroll",
        sourceWithMockedRemoteCall("request_failure.json").doStartNextScroll("scroll", timeValueMillis(0), wrapAsListener(checkResponse));
        assertEquals(retriesAllowed, retries);
            assertThat(r.getHits(), hasSize(1));
            public void register(String hostname, String uriPattern, Supplier<AsyncPushConsumer> supplier) {}
            assertThat(r.getHits(), hasSize(1));
        // Fail to get the status with a broken body
     * Test for parsing _ttl, _routing, and _parent. _timestamp isn't available.
                    listener.onResponse(RemoteVersion.OPENSEARCH_3_1_0);
        }
            }
            public void start() {}
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        // Unwrap the some artifacts from the test
        URL[] resources = new URL[paths.length];
import org.opensearch.OpenSearchStatusException;
            @Override
        for (int i = 0; i < paths.length; i++) {
    private int retriesAllowed;
        TestRemoteScrollableHitSource hitSource = new TestRemoteScrollableHitSource(client);
            assertEquals(FAKE_SCROLL_ID, r.getScrollId());
        retriesAllowed = between(0, 10);
 * Unless required by applicable law or agreed to in writing,
        sourceWithMockedRemoteCall("failure_with_status.json").doStartNextScroll(
import static org.hamcrest.Matchers.hasSize;
/*
                HandlerFactory<AsyncPushConsumer> pushHandlerFactory,
                            ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(RestStatus.TOO_MANY_REQUESTS.getStatus(), "");
            public void initiateShutdown() {}
            assertThat(r.getHits(), hasSize(1));
                return null;
        sourceWithMockedRemoteCall("request_failure.json").doStart(wrapAsListener(checkResponse));
        sourceWithMockedRemoteCall("fail:rejection.json", "start_ok.json", "fail:rejection.json", "scroll_ok.json").start();
        };
        TestRemoteScrollableHitSource hitSource = new TestRemoteScrollableHitSource(restClient) {
            }
        assertEquals(status, wrapped.status());
            assertEquals("Unknown key for a VALUE_STRING in [invalid].", failure.getMessage());
            paths[i] = "fail:rejection.json";
                    ((HeapBufferedAsyncResponseConsumer) responseConsumer).getBufferLimit()
    }
        assertEquals(retriesAllowed, retries);
        assertEquals("Remote responded with a chunk that was too large. Use a smaller batch size.", e.getMessage());
        sourceWithMockedRemoteCall("failure_with_status.json").doStart(wrapAsListener(checkResponse));
        retries = 0;
        assertTrue(cleanupCallbackCalled.get());
    }
            ) {
        wrapped = RemoteScrollableHitSource.wrapExceptionToPreserveStatus(status.getStatus(), badEntity, cause);
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
        Throwable e = expectThrows(RuntimeException.class, source::start);
            assertEquals(FAKE_SCROLL_ID, r.getScrollId());
    @SuppressWarnings({ "unchecked", "rawtypes" })
    }
import org.apache.hc.core5.http.message.StatusLine;
                "rejected execution of org.opensearch.transport.TransportService$5@52d06af2 on "
    }
        assertEquals(cause, wrapped.getCause());
        RestStatus status = randomFrom(RestStatus.values());
        threadPool = new TestThreadPool(getTestName()) {
        };
                invocationCount.getAndIncrement();
/*
                AsyncRequestProducer requestProducer,
 * Licensed to Elasticsearch under one or more contributor
        assertTrue(called.get());
import java.util.stream.Stream;
        verifyRetries(false, new ConnectException("blah"), false);
            assertEquals("AVToMiC250DjIiBO3yJ_", r.getHits().get(0).getId());
    }
                AsyncRequestProducer requestProducer,
import org.opensearch.core.common.unit.ByteSizeUnit;
                return null;
                HttpHost target,
/*
        assertNotNull(response);
        AtomicBoolean called = new AtomicBoolean();
        response = responseQueue.poll();
        // This next exception is what the user sees
        assertTrue(called.get());
        Consumer<Response> checkResponse = r -> {
        assertLookupRemoteVersion(RemoteVersion.ELASTICSEARCH_2_3_3, "main/2_3_3.json");
import java.util.concurrent.ExecutorService;
        Mockito.when(mockResponse.getRequestLine()).thenReturn(new RequestLine("GET", "/", new ProtocolVersion("https", 1, 1)));
    public void testUnexpectedJsonThinksRemoteIsNotES() throws IOException {
        // Fail to get the status without a body
import org.opensearch.index.reindex.ScrollableHitSource.Response;
            public void start() {}
import org.mockito.Mockito;
        RuntimeException e = expectThrows(RuntimeException.class, () -> sourceWithMockedRemoteCall(paths).start());
        subject.accept(RejectAwareActionListener.wrap(r -> fail(), e -> {
            assertEquals(FAKE_SCROLL_ID, r.getScrollId());
        sourceWithMockedRemoteCall("scroll_fully_loaded.json").doStartNextScroll("", timeValueMillis(0), wrapAsListener(r -> {
        retriesAllowed = 5;
        assertLookupRemoteVersion(RemoteVersion.ELASTICSEARCH_0_20_5, "main/0_20_5.json");
 */
    }
                RemoteScrollableHitSourceTests.this.searchRequest
import static org.hamcrest.Matchers.instanceOf;
        final CloseableHttpAsyncClient httpClient = new CloseableHttpAsyncClient() {
            if (expectedToRetry) expectedInvocations += retriesAllowed;
        verify(client).close();
        assertNotNull(response);
        assertSame(tooLong, e.getCause());
            assertThat(r.getFailures().get(0).getReason(), instanceOf(OpenSearchRejectedExecutionException.class));
        assertEquals(badEntityException, wrapped.getSuppressed()[0]);
        assertTrue(called.get());
import org.junit.Before;
        wrapped = RemoteScrollableHitSource.wrapExceptionToPreserveStatus(status.getStatus(), okEntity, cause);
            }
                );
    public void testParseScrollFullyLoadedFrom1_7() throws Exception {
            @Override
            assertEquals("AVToMiDL50DjIiBO3yKA", r.getHits().get(0).getId());
        Mockito.when(mockResponse.getEntity()).thenReturn(new StringEntity(errorMsg, ContentType.TEXT_PLAIN));
        sourceWithMockedRemoteCall(false, ContentType.APPLICATION_JSON, s).lookupRemoteVersion(wrapAsListener(v -> {
        }
            int responseCount = 0;
            public void initiateShutdown() {}
            void lookupRemoteVersion(RejectAwareActionListener<RemoteVersion> listener) {
        boolean shouldMockRemoteVersion,
            @Override
            protected <T> Future<T> doExecute(
        }
import org.opensearch.action.search.SearchRequest;
            );
                FutureCallback<T> callback
import org.opensearch.client.nio.HeapBufferedAsyncResponseConsumer;
import org.apache.hc.core5.http.nio.HandlerFactory;
import org.apache.hc.core5.http.ProtocolVersion;
            e = e.getCause();
                    } else {
            public void register(String hostname, String uriPattern, Supplier<AsyncPushConsumer> supplier) {}
            assertEquals(14, failure.getColumnNumber());
        OpenSearchStatusException wrapped = RemoteScrollableHitSource.wrapExceptionToPreserveStatus(status.getStatus(), null, cause);
import org.apache.hc.core5.http.ContentType;
        assertLookupRemoteVersion(RemoteVersion.ELASTICSEARCH_1_7_5, "main/1_7_5.json");
            assertEquals((Integer) 0, r.getFailures().get(0).getShardId());
    }
            @Override
            assertNull(r.getHits().get(0).getRouting());
        if (mockRemoteVersion) {
        verifyRetries(true, withResponseCode(500, "Internal Server Error"), true);
                client,
        sourceWithMockedRemoteCall("start_ok.json").doStart(wrapAsListener(r -> {
            assertEquals(expected, v);
                AsyncResponseConsumer<T> responseConsumer,
        assertThat(requestProducer, instanceOf(HttpUriRequestProducer.class));
        retries = 0;
    public void testParseScrollOk() throws Exception {
import org.opensearch.client.http.HttpUriRequestProducer;
        }, e -> fail()));
        assertEquals("failed", e.getMessage());
     */
        searchRequest.source(new SearchSourceBuilder().size(10).version(true).sort("_doc").size(123));
                    + "OpenSearchThreadPoolExecutor@778ea553[Running, pool size = 7, active threads = 7, queued tasks = 1000, "
        assertEquals("Failed to extract body.", wrapped.getMessage());
    }
            assertFalse(r.isTimedOut());
        called.set(false);
import java.io.InputStreamReader;
    public void testParseRequestFailure() throws Exception {
            assertThat(r.getFailures().get(0).getReason(), instanceOf(ParsingException.class));
        return sourceWithMockedRemoteCall(true, ContentType.APPLICATION_JSON, paths);
        retries += 1;
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
    }
        AtomicBoolean called = new AtomicBoolean();
        return hitSource;
    void verifyRetries(boolean shouldMockRemoteVersion, Exception failureResponse, boolean expectedToRetry) {
        int notAnHttpStatus = -1;
    }
        } else {
    public void testParseStartOk() throws Exception {
        assertTrue(called.get());
        assertEquals(cause, wrapped.getCause());
            @Override
            }
                } catch (IOException ex) {
    public void testRetryOnCallFailure() throws Exception {
        retriesAllowed = between(1, Integer.MAX_VALUE);
        assertTrue(responseQueue.isEmpty());
        Exception e = expectThrows(RuntimeException.class, () -> sourceWithMockedRemoteCall("main/2_3_3.json").start());
        String[] searchOKPaths = Stream.concat(Stream.of("start_ok.json"), Stream.of(paths)).toArray(String[]::new);
            assertThat(r.getFailures(), hasSize(1));
        assertNull(RestStatus.fromCode(notAnHttpStatus));
        assertLookupRemoteVersion(RemoteVersion.ELASTICSEARCH_5_0_0, "main/5_0_0_alpha_3.json");
    public void testCleanupFailure() throws Exception {
        sourceWithMockedRemoteCall("start_ok.json").doStart(wrapAsListener(r -> {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.io.Streams;
            @Override
            assertEquals("{\"test\":\"test1\"}", r.getHits().get(0).getSource().utf8ToString());
        return new ResponseException(mockResponse);
            e.getCause().getCause().getCause().getCause().getMessage()
     * synchronously rather than asynchronously.
        assertSame(failureResponse, e);
            @Override
        CloseableHttpAsyncClient httpClient = new CloseableHttpAsyncClient() {
            @Override
        org.opensearch.client.Response mockResponse = Mockito.mock(org.opensearch.client.Response.class);
            if (resources[i] == null) {
import org.apache.hc.core5.http.protocol.HttpContext;
import java.util.function.Consumer;
            assertEquals("AVToMiC250DjIiBO3yJ_", r.getHits().get(0).getId());
        return exception.get();
                } else {
import org.apache.hc.core5.http.io.entity.InputStreamEntity;
        RestClient client = mock(RestClient.class);
    public void testCleanupSuccessful() throws Exception {
        assertEquals(status, wrapped.status());
                if (mockRemoteVersion) {
        assertTrue(responseQueue.isEmpty());
    }
    private final Queue<ScrollableHitSource.AsyncResponse> responseQueue = new LinkedBlockingQueue<>();
 * under the License.
import org.apache.hc.core5.http.ClassicHttpResponse;
    public void testInvalidJsonThinksRemoteIsNotES() throws IOException {
            assertEquals("{\"test\":\"test3\"}", r.getHits().get(0).getSource().utf8ToString());
    private <T> RejectAwareActionListener<T> wrapAsListener(Consumer<T> consumer) {
            public void awaitShutdown(org.apache.hc.core5.util.TimeValue waitTime) throws InterruptedException {}
        RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200))
        // Handling a scroll rejection is the same as handling a search rejection so we reuse the verification code
            assertEquals(
 */
        // Successfully get the status without a body
import org.opensearch.search.builder.SearchSourceBuilder;
            public void awaitShutdown(org.apache.hc.core5.util.TimeValue waitTime) throws InterruptedException {}
        AtomicBoolean cleanupCallbackCalled = new AtomicBoolean();
    public void testParseScrollFullyLoaded() throws Exception {
 */
    public void validateAllConsumed() {
            assertEquals(4, r.getTotalHits());
        assertEquals(cause, wrapped.getCause());
import java.io.IOException;
        assertTrue(called.get());
        // Successfully get the status with a broken body
            @Override
        assertEquals(badEntityException, wrapped.getSuppressed()[0]);
        assertEquals(RestStatus.INTERNAL_SERVER_ERROR, wrapped.status());
        Consumer<Response> checkResponse = r -> {
            assertEquals("{\"test\":\"test3\"}", r.getHits().get(0).getSource().utf8ToString());
            @Override
            public void initiateShutdown() {}
                .lookupRemoteVersion(listener)
    }
            timeValueMillis(0),
            public IOReactorStatus getStatus() {
                return null;
    public void testScanJumpStart() throws Exception {
    private SearchRequest searchRequest;
    }
        // First call(remote version lookup) failed and no retries expected
                return null;
        return ((HttpUriRequestProducer) requestProducer).getRequest();
                    + "OpenSearchThreadPoolExecutor[search, queue capacity = 1000, org.opensearch.common.util.concurrent."
        AtomicBoolean called = new AtomicBoolean();
                callback.failed(tooLong);
        AtomicBoolean called = new AtomicBoolean();
        assertNotNull(response);
 * this work for additional information regarding copyright
                RemoteScrollableHitSourceTests.this::failRequest,
import org.opensearch.action.bulk.BackoffPolicy;
            called.set(true);
        assertEquals("failed", e.getMessage());
            @Override
        assertTrue(called.get());
        assertLookupRemoteVersion(RemoteVersion.ELASTICSEARCH_5_0_0, "main/with_unknown_fields.json");
import org.apache.hc.core5.http.nio.AsyncPushConsumer;
        sourceWithMockedRemoteCall("scroll_fully_loaded_1_7.json").doStartNextScroll("", timeValueMillis(0), wrapAsListener(r -> {
        assertEquals(1, retries);
            assertEquals("{\"test\":\"test3\"}", r.getHits().get(0).getSource().utf8ToString());
        Throwable e = expectThrows(RuntimeException.class, source::start);
            @Override
            @Override
        hitSource.cleanup(() -> cleanupCallbackCalled.set(true));
            assertThat(r.getFailures(), empty());
        String header = randomAlphaOfLength(5);
    }
        sourceWithMockedRemoteCall("rejection.json").doStartNextScroll("scroll", timeValueMillis(0), wrapAsListener(checkResponse));
        assertEquals("No error body.", wrapped.getMessage());
                FutureCallback<T> callback
            }
import org.apache.hc.core5.http.HttpEntity;
            }
        throw new RuntimeException("failed", t);
            assertEquals("test", r.getHits().get(0).getIndex());
    public void tearDown() throws Exception {
 * GitHub history for details.
        ContentTooLongException tooLong = new ContentTooLongException("too long!");
        Consumer<Response> checkResponse = r -> {
        AtomicInteger invocations = new AtomicInteger();
            assertFalse(r.isTimedOut());
        terminate(threadPool);
        AtomicBoolean cleanupCallbackCalled = new AtomicBoolean();
        };
import org.opensearch.core.rest.RestStatus;
 * ownership. Elasticsearch licenses this file to you under
            called.set(true);
        HttpAsyncClientBuilder clientBuilder = mock(HttpAsyncClientBuilder.class);
        assertTrue(called.get());
        assertEquals(cause, wrapped.getCause());
        TestRemoteScrollableHitSource hitSource = new TestRemoteScrollableHitSource(client);
                            callback.completed((T) httpResponse);
            assertEquals(2, failure.getLineNumber());
                HttpContext context,
            ) {
        Exception cause = new Exception();
        RestClient client = mock(RestClient.class);
