        return exception.get();
        }, e -> fail()));  
            }
        wrapped = RemoteScrollableHitSource.wrapExceptionToPreserveStatus(status.getStatus(), okEntity, cause);  
            );  
                        httpResponse.setEntity(new InputStreamEntity(FileSystemUtils.openFileURLStream(resource), contentType));
            public ScheduledCancellable schedule(Runnable command, TimeValue delay, String name) {
 * Licensed to Elasticsearch under one or more contributor  
    private <T> RejectAwareActionListener<T> wrapAsListener(Consumer<T> consumer) {
        retries += 1;
    }  
/*  
            ) {
            @Override
                try {  
import static org.mockito.Mockito.verify;
        assertEquals(1, retries);
        assertEquals(status, wrapped.status());  
            assertFalse(r.isTimedOut());
        sourceWithMockedRemoteCall("start_ok.json").doStart(wrapAsListener(r -> {
        verifyRetries(true, withResponseCode(500, "Internal Server Error"), true);  
                );
    public void testRetryAndSucceed() throws Exception {
        subject.accept(RejectAwareActionListener.wrap(r -> fail(), e -> {  
import java.nio.charset.StandardCharsets;
                RemoteScrollableHitSourceTests.this.logger,  
            assertEquals(4, r.getTotalHits());
                RemoteScrollableHitSourceTests.this.searchRequest
        super.setUp();
    public void testParseFailureWithStatus() throws Exception {
            public void awaitShutdown(org.apache.hc.core5.util.TimeValue waitTime) throws InterruptedException {}
        retries = 0;  
    }
                        callback.completed((T) httpResponse);
        assertEquals("Remote responded with a chunk that was too large. Use a smaller batch size.", e.getMessage());
            void lookupRemoteVersion(RejectAwareActionListener<RemoteVersion> listener) {
        doThrow(new RuntimeException("test")).when(client).close();  
            public IOReactorStatus getStatus() {  
        assertLookupRemoteVersion(RemoteVersion.OPENSEARCH_1_0_0, "main/OpenSearch_1_0_0.json");
            @Override  
        retriesAllowed = between(0, 10);
            public void close() throws IOException {}  
            assertEquals("AVToMiDL50DjIiBO3yKA", r.getHits().get(0).getId());
        }
            assertEquals("test", r.getHits().get(0).getIndex());  
        AtomicBoolean called = new AtomicBoolean();  
    public void testCleanupFailure() throws Exception {  
            assertEquals("87A7NvevQxSrEwMbtRCecg", r.getFailures().get(0).getNodeId());  
    }
 * GitHub history for details.
            @Override  
    }
            assertThat(r.getHits(), hasSize(1));  
import static org.hamcrest.Matchers.empty;
            assertEquals(null, r.getFailures().get(0).getShardId());
                HttpContext context,
        // There is an additional wrapper for ResponseException.  
import org.apache.hc.core5.http.nio.AsyncRequestProducer;  
        assertTrue(called.get());  
        Throwable e = expectThrows(RuntimeException.class, source::start);
    private void countRetry() {
        terminate(threadPool);
    private static final String FAKE_SCROLL_ID = "DnF1ZXJ5VGhlbkZldGNoBQAAAfakescroll";
 * You may obtain a copy of the License at  
            assertEquals("test", r.getFailures().get(0).getIndex());
            public ExecutorService executor(String name) {
import org.opensearch.index.reindex.RejectAwareActionListener;
        // Use the response from a main action instead of a proper start response to generate a parse error
                        BasicClassicHttpResponse httpResponse = new BasicClassicHttpResponse(200, "");  
            assertThat(e, instanceOf(expectedException));
 * this work for additional information regarding copyright
        if (shouldMockRemoteVersion) {
            wrapAsListener(checkResponse)  
import java.util.concurrent.LinkedBlockingQueue;  
        threadPool.getThreadContext().putHeader("test", header);  
                AsyncResponseConsumer<T> responseConsumer,  
     * Creates a hit source that doesn't make the remote request and instead returns data from some files. Also requests are always returned  
        assertThat(requestProducer, instanceOf(HttpUriRequestProducer.class));  
        retries = 0;
                AsyncRequestProducer requestProducer,
                new BytesArray("{}"),
            public void close() throws IOException {}
                RemoteScrollableHitSourceTests.this::failRequest,
            assertThat(r.getHits(), hasSize(1));
    }
        Consumer<Response> checkResponse = r -> {
    }
            assertEquals("test", r.getHits().get(0).getIndex());
import java.util.function.Consumer;
        assertEquals(cause, wrapped.getCause());
        AtomicBoolean called = new AtomicBoolean();
            assertEquals(4, r.getTotalHits());
            assertEquals("AVToMiC250DjIiBO3yJ_", r.getHits().get(0).getId());
        sourceWithMockedRemoteCall("rejection.json").doStartNextScroll("scroll", timeValueMillis(0), wrapAsListener(checkResponse));  
        when(badEntity.getContent()).thenThrow(badEntityException);
            assertThat(r.getFailures(), empty());
            if (expectedToRetry) expectedInvocations += retriesAllowed;
        super.tearDown();
            protected <T> Future<T> doExecute(
            assertEquals("10000", r.getHits().get(0).getId());
        assertTrue(responseQueue.isEmpty());
        RemoteScrollableHitSource source = createRemoteSourceWithFailure(shouldMockRemoteVersion, failureResponse, invocations);
import java.net.URL;
        RemoteScrollableHitSource source = sourceWithMockedClient(true, httpClient);
                    ClassicHttpRequest request = getRequest(requestProducer);  
        }));
    /**
import org.apache.hc.core5.http.ContentTooLongException;
public class RemoteScrollableHitSourceTests extends OpenSearchTestCase {
        assertEquals("body=test body", wrapped.getMessage());  
        OpenSearchStatusException wrapped = RemoteScrollableHitSource.wrapExceptionToPreserveStatus(status.getStatus(), null, cause);
        sourceWithMockedRemoteCall("rejection.json").doStart(wrapAsListener(checkResponse));  
        };
            @Override
        assertTrue(called.get());
 * this file be licensed under the Apache-2.0 license or a
            assertThat(r.getFailures(), empty());
            called.set(true);
        RestStatus status = randomFrom(RestStatus.values());
            called.set(true);  
        }
                    }  
        assertNotNull(response);  
        assertNotNull(response);  
        RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200))
            assertEquals("test", r.getHits().get(0).getIndex());
        AtomicBoolean called = new AtomicBoolean();  
            assertThat(r.getFailures(), hasSize(1));  
     * synchronously rather than asynchronously.
            @Override
            @Override  
            @Override  
import org.mockito.Mockito;
        };  
        AtomicBoolean called = new AtomicBoolean();  
import static org.hamcrest.Matchers.hasSize;  
    }
        int notAnHttpStatus = -1;
            assertEquals(4, r.getTotalHits());
                    // Throw away the current thread context to simulate running async httpclient's thread pool
    public void testInvalidJsonThinksRemoteIsNotES() throws IOException {
            called.set(true);
        return sourceWithMockedRemoteCall(true, ContentType.APPLICATION_JSON, paths);
        while (e.getMessage().equals("failed")) {  
        assertEquals("Couldn't extract status [" + notAnHttpStatus + "]. Failed to extract body.", wrapped.getMessage());  
 *    http://www.apache.org/licenses/LICENSE-2.0
            protected <T> Future<T> doExecute(
                HttpHost target,  
            assertEquals(FAKE_SCROLL_ID, r.getScrollId());
                    + "OpenSearchThreadPoolExecutor[search, queue capacity = 1000, org.opensearch.common.util.concurrent."
        retries = 0;
        ContentTooLongException tooLong = new ContentTooLongException("too long!");  
                .lookupRemoteVersion(listener)
    }
    ) {
    private SearchRequest searchRequest;
            @Override  
            @Override
        };  
            public void register(String hostname, String uriPattern, Supplier<AsyncPushConsumer> supplier) {}
                AsyncResponseConsumer<T> responseConsumer,
        );
            assertThat(r.getHits(), hasSize(1));  
            public void start() {}
                    + "completed tasks = 4182]]",  
        assertEquals(1, retries);  
        assertTrue(responseQueue.isEmpty());
            e = e.getCause();
        assertEquals(RestStatus.INTERNAL_SERVER_ERROR, wrapped.status());
        hitSource.cleanup(() -> cleanupCallbackCalled.set(true));
    }
        assertEquals(e.getMessage(), "Response didn't include supported Content-Type, remote is likely not an OpenSearch instance");
            public void close() throws IOException {}
        Consumer<Response> checkResponse = r -> {
                            callback.failed(new RuntimeException(body));  
            assertThat(r.getHits(), hasSize(1));  
        wrapped = RemoteScrollableHitSource.wrapExceptionToPreserveStatus(status.getStatus(), badEntity, cause);  
        // Unwrap the some artifacts from the test
        verifyRetries(false, withResponseCode(400, "Client Error"), false);
        verifyRetries(false, withResponseCode(500, "Internal Server Error"), false);  
            );
            expectedInvocations = 1; // the first should fail and not trigger any retry.  
import org.junit.Before;
            called.set(true);
            public void register(String hostname, String uriPattern, Supplier<AsyncPushConsumer> supplier) {}  
            assertThat(r.getFailures().get(0).getReason(), instanceOf(OpenSearchRejectedExecutionException.class));
    }  
                assertEquals(
        searchRequest.scroll(timeValueMinutes(5));
            called.set(true);
        threadPool = new TestThreadPool(getTestName()) {  
            @Override
            e = e.getCause();
                AsyncResponseConsumer<T> responseConsumer,
        int expectedInvocations = 0;
import java.util.stream.Stream;
    private static ClassicHttpRequest getRequest(AsyncRequestProducer requestProducer) {
                } catch (IOException ex) {
        sourceWithMockedRemoteCall("request_failure.json").doStartNextScroll("scroll", timeValueMillis(0), wrapAsListener(checkResponse));
    @Before
/*
            assertEquals(FAKE_SCROLL_ID, r.getScrollId());
        called.set(false);
        sourceWithMockedRemoteCall("failure_with_status.json").doStartNextScroll(  
    }  
        // Fail to get the status without a body
        URL[] resources = new URL[paths.length];
import java.util.concurrent.atomic.AtomicInteger;
        verifyRetries(true, new ConnectException("blah"), true); // should retry connect exceptions.
import org.apache.hc.core5.io.CloseMode;
        HttpEntity badEntity = mock(HttpEntity.class);
            assertNull(r.getHits().get(0).getRouting());
        assertEquals(badEntityException, wrapped.getSuppressed()[0]);
    RemoteScrollableHitSource createRemoteSourceWithFailure(
            ParsingException failure = (ParsingException) r.getFailures().get(0).getReason();
        // Handling a scroll rejection is the same as handling a search rejection so we reuse the verification code
import org.apache.hc.core5.http.ClassicHttpRequest;
                        if (path.equals("fail:rejection.json")) {
    public void testParseScrollFullyLoadedFrom1_7() throws Exception {
        TestRemoteScrollableHitSource hitSource = new TestRemoteScrollableHitSource(client);
import org.apache.hc.core5.http.nio.AsyncResponseConsumer;
            assertNull(r.getScrollId());  
            assertEquals("AVToMiDL50DjIiBO3yKA", r.getHits().get(0).getId());
            }
import java.util.concurrent.ExecutorService;
        };
        AtomicBoolean called = new AtomicBoolean();  
import org.apache.hc.core5.http.message.RequestLine;  
            assertFalse(r.isTimedOut());
            @Override  
            public void register(String hostname, String uriPattern, Supplier<AsyncPushConsumer> supplier) {}
        // Fail to get the status with a broken body
            assertEquals(2, failure.getLineNumber());  
            e.getCause().getCause().getCause().getCause().getMessage()
import static org.opensearch.common.unit.TimeValue.timeValueMinutes;
import org.apache.hc.core5.http.io.entity.StringEntity;
 */  
            public void initiateShutdown() {}
        }));
        invocations.set(0);  
                    + "OpenSearchThreadPoolExecutor@778ea553[Running, pool size = 7, active threads = 7, queued tasks = 1000, "
        assertEquals(  
        sourceWithMockedRemoteCall("failure_with_status.json").doStart(wrapAsListener(checkResponse));  
        TestRemoteScrollableHitSource hitSource = new TestRemoteScrollableHitSource(client);  
            public void close(CloseMode closeMode) {}
    private ThreadPool threadPool;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
    }
 * the Apache License, Version 2.0 (the "License"); you may
    @SuppressWarnings({ "unchecked", "rawtypes" })
        AtomicBoolean called = new AtomicBoolean();
import java.util.concurrent.atomic.AtomicBoolean;
            e = e.getCause();
    public void testParseRequestFailure() throws Exception {
            @Override
        // Successfully get the status without a body
                            ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(RestStatus.TOO_MANY_REQUESTS.getStatus(), "");  
        }
        sourceWithMockedRemoteCall("start_ok.json").doStart(wrapAsListener(r -> {
    }
                client,  
            resources[i] = Thread.currentThread().getContextClassLoader().getResource("responses/" + paths[i].replace("fail:", ""));
                        }
            assertEquals("AVToMiC250DjIiBO3yJ_", r.getHits().get(0).getId());
            assertFalse(r.isTimedOut());  
        final ExecutorService directExecutor = OpenSearchExecutors.newDirectExecutorService();
        }));
import org.opensearch.test.OpenSearchTestCase;  
        wrapped = RemoteScrollableHitSource.wrapExceptionToPreserveStatus(notAnHttpStatus, okEntity, cause);  
    public void testTooLargeResponse() throws Exception {
 * compatible open source license.
            public void close(CloseMode closeMode) {}
        verifyRetries(true, new RuntimeException("foobar"), false);  
                return null;
            "Error parsing the response, remote is likely not an OpenSearch instance",
                invocationCount.getAndIncrement();
            paths[i] = "fail:rejection.json";
    @After
        e = expectThrows(RuntimeException.class, () -> response.done(timeValueMillis(0)));
        assertEquals("failed", e.getMessage());
        when(clientBuilder.build()).thenReturn(httpClient);
    }
        assertEquals(  
    public void testNoContentTypeIsError() {
import org.apache.hc.core5.function.Supplier;
 * KIND, either express or implied.  See the License for the
        );  
import org.opensearch.core.common.unit.ByteSizeUnit;  
import org.opensearch.client.RestClient;
            assertEquals(FAKE_SCROLL_ID, r.getScrollId());  
        assertTrue(called.get());
 */  
    public void setUp() throws Exception {  
        HttpAsyncClientBuilder clientBuilder = mock(HttpAsyncClientBuilder.class);
import org.opensearch.threadpool.ThreadPool;
            if (resources[i] == null) {
        assertSame(tooLong, e.getCause());  
        assertNull(RestStatus.fromCode(notAnHttpStatus));
        assertTrue(responseQueue.isEmpty());
    private int retries;  
import org.opensearch.client.http.HttpUriRequestProducer;
    public void testParseRejection() throws Exception {
        return ((HttpUriRequestProducer) requestProducer).getRequest();
    }
        assertTrue(called.get());
        sourceWithMockedRemoteCall("scroll_ok.json").doStartNextScroll("", timeValueMillis(0), wrapAsListener(r -> {  
        // The rejection comes through in the handler because the mocked http response isn't marked as an error
        assertEquals("Couldn't extract status [" + notAnHttpStatus + "]. No error body.", wrapped.getMessage());  
            assertThat(r.getFailures(), hasSize(1));
            }
                HandlerFactory<AsyncPushConsumer> pushHandlerFactory,
                callback.failed(tooLong);  
import static org.mockito.Mockito.when;
    }
import org.apache.hc.core5.http.ContentType;
    public void testScanJumpStart() throws Exception {
import java.io.InputStreamReader;
        assertEquals(RestStatus.INTERNAL_SERVER_ERROR, wrapped.status());
        AtomicInteger invocationCount
            assertNull(r.getHits().get(0).getRouting());  
    private RemoteScrollableHitSource sourceWithMockedRemoteCall(String... paths) throws Exception {
        if (mockRemoteVersion) {  
            int responseCount = 0;
            assertThat(r.getFailures().get(0).getReason(), instanceOf(RuntimeException.class));
            }
import static org.hamcrest.Matchers.instanceOf;
        sourceWithMockedRemoteCall("request_failure.json").doStart(wrapAsListener(checkResponse));
    public void testCleanupSuccessful() throws Exception {  
            public void awaitShutdown(org.apache.hc.core5.util.TimeValue waitTime) throws InterruptedException {}
    public void tearDown() throws Exception {  
        assertLookupRemoteVersion(RemoteVersion.ELASTICSEARCH_5_0_0, "main/with_unknown_fields.json");
        ScrollableHitSource.AsyncResponse response = responseQueue.poll();
        assertTrue(cleanupCallbackCalled.get());
import org.apache.hc.core5.http.io.entity.InputStreamEntity;  
import java.util.concurrent.atomic.AtomicReference;  
import org.opensearch.action.search.SearchRequest;
                FutureCallback<T> callback  
import org.apache.hc.core5.concurrent.FutureCallback;  
        verifyRetries(true, withResponseCode(400, "Client Error"), false);
        assertTrue(responseQueue.isEmpty());
    void verifyRetries(boolean shouldMockRemoteVersion, Exception failureResponse, boolean expectedToRetry) {  
 * specific language governing permissions and limitations
    private void failRequest(Throwable t) {
        wrapped = RemoteScrollableHitSource.wrapExceptionToPreserveStatus(notAnHttpStatus, badEntity, cause);  
            called.set(true);
import org.opensearch.threadpool.TestThreadPool;
        assertEquals(RestStatus.INTERNAL_SERVER_ERROR, wrapped.status());
 */
        response.done(timeValueMillis(0));
        };
import org.opensearch.action.bulk.BackoffPolicy;
            "scroll",
        assertEquals(cause, wrapped.getCause());
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        );  
            assertEquals("Unknown key for a VALUE_STRING in [invalid].", failure.getMessage());
import org.opensearch.core.util.FileSystemUtils;
 * The OpenSearch Contributors require contributions made to  
        final CloseableHttpAsyncClient httpClient = new CloseableHttpAsyncClient() {
                command.run();
        for (int i = 0; i < paths.length; i++) {  
import org.opensearch.client.nio.HeapBufferedAsyncResponseConsumer;  
            assertEquals(10000, r.getTotalHits());
        retriesAllowed = 0;
            }
        verifyRetries(false, new ConnectException("blah"), false);  
import org.opensearch.core.common.ParsingException;
        assertEquals(retriesAllowed, retries);
        assertTrue(called.get());
        }
    }
        AtomicBoolean called = new AtomicBoolean();
        assertNotNull(response);
            assertEquals(header, threadPool.getThreadContext().getHeader("test"));  
import org.opensearch.index.reindex.ScrollableHitSource.Response;
import org.opensearch.common.util.concurrent.OpenSearchExecutors;  
        assertLookupRemoteVersion(RemoteVersion.ELASTICSEARCH_5_0_0, "main/5_0_0_alpha_3.json");  
                    String path = paths[responseCount++];
                AsyncRequestProducer requestProducer,
        hitSource.cleanup(() -> cleanupCallbackCalled.set(true));
    public void testLookupRemoteVersion() throws Exception {
        while (e.getMessage().equals("failed")) {  
import org.apache.hc.core5.http.nio.AsyncPushConsumer;
        RuntimeException e = expectThrows(RuntimeException.class, () -> sourceWithMockedRemoteCall(paths).start());
        // Unwrap the some artifacts from the test
        return RejectAwareActionListener.wrap(consumer::accept, throwing, throwing);  
            assertNull(r.getHits().get(0).getRouting());
        Exception cause = new Exception();
    }
                    ((HeapBufferedAsyncResponseConsumer) responseConsumer).getBufferLimit()
            @Override
                r.getFailures().get(0).getReason().getMessage()
            assertEquals("{\"test\":\"test2\"}", r.getHits().get(0).getSource().utf8ToString());  
    private void assertLookupRemoteVersion(RemoteVersion expected, String s) throws Exception {
        Consumer<Exception> throwing = e -> { throw new AssertionError(e); };
import org.opensearch.core.common.bytes.BytesArray;
 * Unless required by applicable law or agreed to in writing,
        }));  
    private final Queue<ScrollableHitSource.AsyncResponse> responseQueue = new LinkedBlockingQueue<>();
        assertEquals("No error body.", wrapped.getMessage());
    public void testWrapExceptionToPreserveStatus() throws IOException {  
        assertEquals(cause, wrapped.getCause());
    private int retriesAllowed;  
        assertTrue(called.get());
            @Override
        Mockito.when(mockResponse.getRequestLine()).thenReturn(new RequestLine("GET", "/", new ProtocolVersion("https", 1, 1)));  
        verifyRetries(true, withResponseCode(429, "Too many requests"), true);
import static org.mockito.Mockito.mock;  
            public void start() {}
        assertEquals("Failed to extract body.", wrapped.getMessage());  
    public void testParseStartOk() throws Exception {
        }));  
    /**
        CloseableHttpAsyncClient httpClient = new CloseableHttpAsyncClient() {  
 * not use this file except in compliance with the License.
import java.io.IOException;  
        RuntimeException e = expectListenerFailure(
import java.util.Queue;  
 * under the License.  
        assertLookupRemoteVersion(RemoteVersion.ELASTICSEARCH_0_20_5, "main/0_20_5.json");
                    new ByteSizeValue(100, ByteSizeUnit.MB).bytesAsInt(),  
    }
                return null;  
            assertThat(r.getFailures(), hasSize(1));  
    private RemoteScrollableHitSource sourceWithMockedClient(boolean mockRemoteVersion, CloseableHttpAsyncClient httpClient) {  
                callback.failed(failure);
            public void start() {}  
        }
        assertTrue(called.get());
    public void testRetryOnCallFailure() throws Exception {
    }
            assertEquals("{\"test\":\"test1\"}", r.getHits().get(0).getSource().utf8ToString());  
        assertTrue(responseQueue.isEmpty());  
    @SuppressWarnings("unchecked")  
        Exception e = expectThrows(RuntimeException.class, () -> sourceWithMockedRemoteCall("main/2_3_3.json").start());
            assertEquals("test", r.getHits().get(0).getIndex());
                HttpHost target,
        assertTrue(called.get());
                    return null;
        assertEquals(status, wrapped.status());
            timeValueMillis(0),
import org.opensearch.core.common.unit.ByteSizeValue;
        searchRequest = new SearchRequest();
 *
            @Override  
        sourceWithMockedRemoteCall("start_scan.json", "scroll_ok.json").doStart(wrapAsListener(r -> {
        assertEquals(cause, wrapped.getCause());
        String[] paths = new String[retriesAllowed + 2];  
            assertEquals("{\"test\":\"test3\"}", r.getHits().get(0).getSource().utf8ToString());
     * Test for parsing _ttl, _routing, and _parent. _timestamp isn't available.  
            (RejectAwareActionListener<RemoteVersion> listener) -> sourceWithMockedRemoteCall(false, null, "main/0_20_5.json")
            assertEquals("{\"test\":\"test3\"}", r.getHits().get(0).getSource().utf8ToString());  
            assertEquals("test", r.getHits().get(0).getIndex());
        return new ResponseException(mockResponse);
        verify(client).close();  
                HandlerFactory<AsyncPushConsumer> pushHandlerFactory,
        };
            hitSource.remoteVersion = RemoteVersion.OPENSEARCH_3_1_0;
            @Override
    }  
    public void testUnexpectedJsonThinksRemoteIsNotES() throws IOException {  
            called.set(true);
        assertSame(failureResponse, e);
            public void close(CloseMode closeMode) {}  
            assertEquals((Integer) 0, r.getFailures().get(0).getShardId());
            called.set(true);
                } else {
            @Override  
     * documents the first iteration but reindex doesn't like that. So we jump start strait to the next iteration.  
        return BackoffPolicy.constantBackoff(timeValueMillis(0), retriesAllowed);
 * SPDX-License-Identifier: Apache-2.0
        AtomicInteger invocations = new AtomicInteger();
 *  
            @Override  
                HttpContext context,  
        // The rejection comes through in the handler because the mocked http response isn't marked as an error
            assertEquals(
        ScrollableHitSource.AsyncResponse response = responseQueue.poll();
            }
import org.opensearch.core.rest.RestStatus;  
            assertFalse(r.isTimedOut());  
        assertTrue(responseQueue.isEmpty());  
        Throwable e = expectThrows(RuntimeException.class, source::start);  
import java.net.ConnectException;  
 *
import org.apache.hc.core5.http.ProtocolVersion;
        searchRequest.source(new SearchSourceBuilder().size(10).version(true).sort("_doc").size(123));  
        sourceWithMockedRemoteCall("fail:rejection.json", "start_ok.json", "fail:rejection.json", "scroll_ok.json").start();
    }
        assertThat(response.response().getFailures(), empty());
        // First call(remote version lookup) failed and no retries expected
                    URL resource = resources[responseCount];
                throw new IllegalArgumentException("Couldn't find [" + paths[i] + "]");  
import org.apache.hc.core5.http.message.BasicClassicHttpResponse;
        }  
import static org.opensearch.common.unit.TimeValue.timeValueMillis;  
        AtomicBoolean cleanupCallbackCalled = new AtomicBoolean();
            public void awaitShutdown(org.apache.hc.core5.util.TimeValue waitTime) throws InterruptedException {}
        boolean shouldMockRemoteVersion,
        return sourceWithMockedClient(shouldMockRemoteVersion, httpClient);  
    }
                    listener.onResponse(RemoteVersion.OPENSEARCH_3_1_0);  
                    if (path.startsWith("fail:")) {  
                "Unknown remote exception with reason=[SearchContextMissingException[No search context found for id [82]]]",  
            expectedInvocations += 1; // first search  
import org.opensearch.index.reindex.ScrollableHitSource;  
        TestRemoteScrollableHitSource(RestClient client) {
        AtomicBoolean cleanupCallbackCalled = new AtomicBoolean();
            assertEquals(FAKE_SCROLL_ID, r.getScrollId());
            .setHttpClientConfigCallback(httpClientBuilder -> clientBuilder)
        RestClient client = mock(RestClient.class);
    @Override
            @Override
        assertTrue(called.get());
            e.getCause().getCause().getCause().getCause().getMessage()
        assertThat(response.response().getFailures(), empty());
            assertEquals("testrouting", r.getHits().get(0).getRouting());
                RemoteScrollableHitSourceTests.this.threadPool,
        called.set(false);  
                "rejected execution of org.opensearch.transport.TransportService$5@52d06af2 on "  
        assertTrue(responseQueue.isEmpty());  
        assertLookupRemoteVersion(RemoteVersion.ELASTICSEARCH_1_7_5, "main/1_7_5.json");
        };
            );
            called.set(true);
            }
                RemoteScrollableHitSourceTests.this::countRetry,  
        AtomicBoolean called = new AtomicBoolean();  
                }
            assertTrue(exception.compareAndSet(null, (T) e));
            assertEquals("{\"test\":\"test10000\"}", r.getHits().get(0).getSource().utf8ToString());  
            assertThat(r.getFailures(), empty());
            ) {
                            callback.completed((T) httpResponse);
        assertThat(response.response().getFailures(), empty());
        }));
import org.opensearch.common.io.Streams;
    @SuppressWarnings("unchecked")  
        verifyRetries(false, withResponseCode(429, "Too many requests"), false);
import org.apache.hc.core5.http.message.StatusLine;
    private <T extends Exception, V> T expectListenerFailure(Class<T> expectedException, Consumer<RejectAwareActionListener<V>> subject) {
        CloseableHttpAsyncClient httpClient = new CloseableHttpAsyncClient() {
            .build();  
        }
     */
package org.opensearch.index.reindex.remote;
        String header = randomAlphaOfLength(5);
        Mockito.when(mockResponse.getEntity()).thenReturn(new StringEntity(errorMsg, ContentType.TEXT_PLAIN));
        assertEquals(cause, wrapped.getCause());
 * software distributed under the License is distributed on an
import org.junit.After;  
        assertEquals(status, wrapped.status());
        // This next exception is what the user sees  
        return hitSource;  
        assertEquals(expectedInvocations, invocations.get());  
    }
                backoff(),
        assertTrue(called.get());
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(badEntityException, wrapped.getSuppressed()[0]);
        // First call succeeds. Search calls failing with 5xxs and 429s should be retried but not 400s.
            }
        );  
                    super.lookupRemoteVersion(listener);
            assertEquals(
                FutureCallback<T> callback
            @Override  
        retriesAllowed = between(1, Integer.MAX_VALUE);  
        retriesAllowed = 5;
                return null;
import org.opensearch.common.unit.TimeValue;
import org.apache.hc.core5.http.HttpHost;
                HttpContext context,
import java.util.concurrent.Future;
    }
            ) {  
                if (mockRemoteVersion) {
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
        IOException badEntityException = new IOException();  
        // First call succeeds. Search call failed with exceptions other than ResponseException
        sourceWithMockedRemoteCall("scroll_fully_loaded.json").doStartNextScroll("", timeValueMillis(0), wrapAsListener(r -> {
            assertThat(r.getHits(), hasSize(1));  
     * Test for parsing _ttl, _timestamp, _routing, and _parent.
 * license agreements. See the NOTICE file distributed with
            assertEquals(null, r.getFailures().get(0).getNodeId());  
        assertNotNull(exception.get());
        wrapped = RemoteScrollableHitSource.wrapExceptionToPreserveStatus(notAnHttpStatus, null, cause);  
        response = responseQueue.poll();  
            assertEquals("AVToMiDL50DjIiBO3yKA", r.getHits().get(0).getId());
            assertEquals("{\"test\":\"test3\"}", r.getHits().get(0).getSource().utf8ToString());
            @Override
        if (failureResponse instanceof ResponseException) {
        assertTrue(called.get());
    }
        return sourceWithMockedClient(mockRemoteVersion, httpClient);  
            called.set(true);  
                return null;  
        Exception failure,  
    }  
            @Override
import java.io.UncheckedIOException;
            public IOReactorStatus getStatus() {
    public void testParseScrollFullyLoaded() throws Exception {  
            assertEquals(14, failure.getColumnNumber());
        // Successfully get the status without a body  
    public void validateAllConsumed() {  
    private RemoteScrollableHitSource sourceWithMockedRemoteCall(boolean mockRemoteVersion, ContentType contentType, String... paths) {
            @Override  
/*  
    ResponseException withResponseCode(int statusCode, String errorMsg) throws IOException {
    }  
            }  
                HttpHost target,
        AtomicBoolean called = new AtomicBoolean();  
            assertEquals("AVToMiDL50DjIiBO3yKA", r.getHits().get(0).getId());  
        HttpEntity okEntity = new StringEntity("test body", ContentType.TEXT_PLAIN);
     */
        assertTrue(called.get());  
                return null;  
            public void initiateShutdown() {}
        assertEquals("failed", e.getMessage());
        called.set(false);
     * Versions of OpenSearch before 2.1.0 don't support sort:_doc and instead need to use search_type=scan. Scan doesn't return
        sourceWithMockedRemoteCall(false, ContentType.APPLICATION_JSON, s).lookupRemoteVersion(wrapAsListener(v -> {
                return directExecutor;  
        sourceWithMockedRemoteCall(searchOKPaths).start();
                HandlerFactory<AsyncPushConsumer> pushHandlerFactory,  
            RuntimeException.class,  
    }
import org.apache.hc.core5.http.nio.HandlerFactory;
        TestRemoteScrollableHitSource hitSource = new TestRemoteScrollableHitSource(restClient) {
            assertEquals("{\"test\":\"test3\"}", r.getHits().get(0).getSource().utf8ToString());  
        assertLookupRemoteVersion(RemoteVersion.ELASTICSEARCH_2_3_3, "main/2_3_3.json");
import org.apache.hc.core5.reactor.IOReactorStatus;
                    } else {
                responseQueue::add,
        AtomicReference<T> exception = new AtomicReference<>();
    }  
            assertEquals(4, r.getTotalHits());  
        };
    @After
            protected <T> Future<T> doExecute(  
    private class TestRemoteScrollableHitSource extends RemoteScrollableHitSource {  
import org.opensearch.client.ResponseException;  
            assertEquals(null, r.getFailures().get(0).getIndex());
                r.getFailures().get(0).getReason().getMessage()
            assertFalse(r.isTimedOut());
            @Override
        AtomicBoolean called = new AtomicBoolean();  
            public void initiateShutdown() {}  
import org.opensearch.search.builder.SearchSourceBuilder;
    }  
                        } else {
            super(
        }));  
            @Override
        assertEquals("Couldn't extract status [" + notAnHttpStatus + "]. body=test body", wrapped.getMessage());  
        Mockito.when(mockResponse.getStatusLine()).thenReturn(new StatusLine(new BasicClassicHttpResponse(statusCode, errorMsg)));
                        String body = Streams.copyToString(new InputStreamReader(request.getEntity().getContent(), StandardCharsets.UTF_8));
            assertEquals(expected, v);
            assertEquals(0, r.getTotalHits());
    }
import org.apache.hc.client5.http.impl.async.HttpAsyncClientBuilder;
            assertFalse(r.isTimedOut());
                    threadPool.getThreadContext().stashContext();
        Consumer<Response> checkResponse = r -> {
    private BackoffPolicy backoff() {  
     */
import org.apache.hc.core5.http.HttpEntity;  
            @Override  
    public void testParseScrollOk() throws Exception {
        }  
    public void testThreadContextRestored() throws Exception {
    }
 * ownership. Elasticsearch licenses this file to you under  
            public IOReactorStatus getStatus() {
import org.apache.hc.core5.http.protocol.HttpContext;  
        assertEquals(retriesAllowed, retries);
            "Error parsing the response, remote is likely not an OpenSearch instance",
    /**  
            assertEquals(FAKE_SCROLL_ID, r.getScrollId());  
        assertEquals(cause, wrapped.getCause());
        // Successfully get the status with a broken body
        sourceWithMockedRemoteCall("scroll_fully_loaded_1_7.json").doStartNextScroll("", timeValueMillis(0), wrapAsListener(r -> {
        Exception e = expectThrows(RuntimeException.class, () -> sourceWithMockedRemoteCall("some_text.txt").start());
}
        org.opensearch.client.Response mockResponse = Mockito.mock(org.opensearch.client.Response.class);  
            @Override
import static org.mockito.Mockito.doThrow;
                    throw new UncheckedIOException(ex);  
        RestClient client = mock(RestClient.class);
    public void testRetryUntilYouRunOutOfTries() throws Exception {
        } else {
        verify(client).close();
                }  
    @Override
                FutureCallback<T> callback
        assertLookupRemoteVersion(RemoteVersion.ELASTICSEARCH_0_90_13, "main/0_90_13.json");  
    /**
            assertThat(r.getFailures().get(0).getReason(), instanceOf(ParsingException.class));  
        // And that exception is reported as being caused by the underlying exception returned by the client
import org.apache.hc.core5.http.ClassicHttpResponse;  
    }
import org.opensearch.OpenSearchStatusException;  
        assertTrue(cleanupCallbackCalled.get());  
        // Fail to get the status without a body  
    }  
        throw new RuntimeException("failed", t);  
                AsyncRequestProducer requestProducer,  
     */
            assertEquals("testrouting", r.getHits().get(0).getRouting());
        for (int i = 0; i < retriesAllowed + 2; i++) {
    }
        String[] searchOKPaths = Stream.concat(Stream.of("start_ok.json"), Stream.of(paths)).toArray(String[]::new);  
                return null;
    }  
        assertTrue(called.get());
        // Handling a scroll rejection is the same as handling a search rejection so we reuse the verification code
