    private Tracer tracer;
public class TraceableStreamingRestChannelTests extends OpenSearchTestCase {
        executor.shutdown();
        // Verify span scope was created and closed
import org.opensearch.rest.RestResponse;
        when(delegate.isReadable()).thenReturn(true);
import org.opensearch.telemetry.tracing.SpanScope;
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch doneLatch = new CountDownLatch(numThreads);
        channel.prepareResponse(RestStatus.OK, headers);
        assertSame(delegate, result);
        TraceableStreamingRestChannel channel = new TraceableStreamingRestChannel(delegate, span, tracer);
        // Verify span scope was created for each chunk
        when(tracer.isRecording()).thenReturn(false);
    public void testPrepareResponseExecutesWithinSpanScope() {
        };
import org.opensearch.telemetry.tracing.Tracer;
        channel.sendResponse(response);
    public void testIsReadableDelegates() {
    }
        verify(span, never()).endSpan();
        TraceableStreamingRestChannel channel = new TraceableStreamingRestChannel(delegate, span, tracer);
        verify(span, times(1)).endSpan();
        verify(span, times(1)).endSpan();
        verify(tracer, times(4)).withSpanInScope(span);
import java.util.concurrent.TimeUnit;
import org.opensearch.telemetry.tracing.Span;
 * SPDX-License-Identifier: Apache-2.0
        channel.sendChunk(lastChunk);
import static org.mockito.Mockito.never;
        channel.sendChunk(chunk);
    }
    }
        HttpChunk lastChunk = createMockChunk(true);
                } catch (Exception e) {
    // Helper method to create mock HttpChunk
        assertFalse(channel.isReadable());
    public void testSendChunkDoesNotEndSpanForNonLastChunk() {
import org.opensearch.core.common.bytes.BytesArray;
import org.opensearch.test.OpenSearchTestCase;
    private SpanScope spanScope;
        assertTrue("Threads did not complete", doneLatch.await(5, TimeUnit.SECONDS));
import org.opensearch.http.HttpChunk;
        HttpChunk lastChunk = createMockChunk(true);
    public void testSpanEndedTwiceWhenBothPathsUsed() throws IOException {
                return new BytesArray("test chunk content".getBytes(StandardCharsets.UTF_8));
            @Override
        TraceableStreamingRestChannel channel = new TraceableStreamingRestChannel(delegate, span, tracer);
                    HttpChunk chunk = createMockChunk(isLast);
        StreamingRestChannel result = (StreamingRestChannel) TraceableStreamingRestChannel.create(delegate, span, tracer);
import static org.mockito.Mockito.times;
    public void testSendChunkEndsSpanForLastChunk() {
        HttpChunk chunk1 = createMockChunk(false);
        TraceableStreamingRestChannel channel = new TraceableStreamingRestChannel(delegate, span, tracer);
        Map<String, List<String>> headers = Map.of("Content-Type", List.of("application/json"));
        HttpChunk lastChunk = createMockChunk(true);
import java.util.Map;
import java.io.IOException;
    }
 *
        verify(span, times(1)).endSpan();
        return new HttpChunk() {
    private Span span;
/*
        channel.sendChunk(chunk);
                }
        delegate = mock(StreamingRestChannel.class);
    public void setup() {
        AtomicInteger chunksProcessed = new AtomicInteger(0);
        verify(tracer, times(1)).withSpanInScope(span);
    }
        for (int i = 0; i < numThreads; i++) {
        when(delegate.isReadable()).thenReturn(false);
            final boolean isLast = (i == numThreads - 1);
        TraceableStreamingRestChannel channel = new TraceableStreamingRestChannel(delegate, span, tracer);
    }
        // First send via streaming path
        TraceableStreamingRestChannel channel = new TraceableStreamingRestChannel(delegate, span, tracer);
    }
        when(tracer.isRecording()).thenReturn(true);
/**
        channel.sendChunk(chunk);
        TraceableStreamingRestChannel channel = new TraceableStreamingRestChannel(delegate, span, tracer);
    private StreamingRestChannel delegate;
        channel.sendChunk(chunk2);
    }
        int numThreads = 10;
import java.util.concurrent.Executors;
        HttpChunk chunk = createMockChunk(false);
            @Override
        verify(span, times(2)).endSpan();
 * this file be licensed under the Apache-2.0 license or a
    public void testPrepareResponseDelegatesToUnderlying() {
        TraceableStreamingRestChannel channel = new TraceableStreamingRestChannel(delegate, span, tracer);
        verify(spanScope, times(1)).close();
    }
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        channel.sendChunk(chunk1);
        // Verify span ended exactly once despite concurrent access
import static org.hamcrest.Matchers.instanceOf;
        TraceableStreamingRestChannel channel = new TraceableStreamingRestChannel(delegate, span, tracer);
        assertTrue(channel.isReadable());
import org.reactivestreams.Subscriber;
package org.opensearch.telemetry.tracing.channels;
import org.opensearch.rest.StreamingRestChannel;
                    channel.sendChunk(chunk);
                    fail("Exception in thread: " + e.getMessage());
        verify(delegate, times(1)).subscribe(subscriber);
    public void testCreateReturnsTracingChannelWhenRecording() {
            @Override
    }
        Subscriber<HttpChunk> subscriber = mock(Subscriber.class);
            executor.submit(() -> {
        verify(delegate, times(2)).isReadable();
            }
            public boolean isLast() {
                    startLatch.await();
import static org.mockito.ArgumentMatchers.any;
}
        startLatch.countDown(); // Start all threads
 */
    public void testSubscribeDelegates() {
import java.util.concurrent.atomic.AtomicInteger;
        TraceableStreamingRestChannel channel = new TraceableStreamingRestChannel(delegate, span, tracer);
        @SuppressWarnings("unchecked")
    }
            }
import org.junit.Before;
        // Send multiple non-last chunks
import static org.mockito.Mockito.mock;
        verify(spanScope, times(4)).close();
 * Tests for {@link TraceableStreamingRestChannel}
    }
        TraceableStreamingRestChannel channel = new TraceableStreamingRestChannel(delegate, span, tracer);
    @Before
    }
        channel.subscribe(subscriber);
        }
        assertThat(result, instanceOf(TraceableStreamingRestChannel.class));
                try {
 * compatible open source license.
        HttpChunk chunk3 = createMockChunk(false);
        channel.sendChunk(chunk3);
import java.util.concurrent.ExecutorService;
import java.util.concurrent.CountDownLatch;
        span = mock(Span.class);
import java.util.List;
        verify(delegate, times(numThreads)).sendChunk(any(HttpChunk.class));
        when(delegate.isWritable()).thenReturn(true);
import static org.mockito.Mockito.when;
    public void testSendChunkExecutesWithinSpanScope() {
        Map<String, List<String>> headers = Map.of("Content-Type", List.of("application/json"));
    }
import static org.mockito.Mockito.verify;
            public void close() {
        verify(delegate, times(1)).sendChunk(chunk);
        // Simulate concurrent chunk sending from multiple threads
        when(delegate.isWritable()).thenReturn(false);
        assertFalse(channel.isWritable());
    }
        // Verify span ended twice
        // Then try non-streaming path (shouldn't normally happen, but guarded)
    }
                    chunksProcessed.incrementAndGet();
        // Verify span scope was created and closed for each chunk
        StreamingRestChannel result = (StreamingRestChannel) TraceableStreamingRestChannel.create(delegate, span, tracer);
    public void testCreateReturnsDelegateWhenNotRecording() {
        verify(tracer, times(1)).withSpanInScope(span);
import org.opensearch.core.rest.RestStatus;
                } finally {
    public void testSendChunkDelegatesToUnderlying() {
        when(tracer.withSpanInScope(span)).thenReturn(spanScope);
        channel.sendChunk(lastChunk);
        HttpChunk chunk2 = createMockChunk(false);
            }
        spanScope = mock(SpanScope.class);
                return isLast;
            });
        HttpChunk chunk = createMockChunk(false);
    private HttpChunk createMockChunk(boolean isLast) {
        assertTrue(channel.isWritable());
        verify(spanScope, times(1)).close();
    public void testSendChunkEndsSpanOnlyOnceWithMultipleChunks() {
        assertNotNull(result);
        TraceableStreamingRestChannel channel = new TraceableStreamingRestChannel(delegate, span, tracer);
        RestResponse response = mock(RestResponse.class);
    public void testIsWritableDelegates() {
        verify(delegate, times(2)).isWritable();
                // no-op for test
        HttpChunk chunk = createMockChunk(false);
 */
        assertEquals(numThreads, chunksProcessed.get());
            public BytesReference content() {
                    doneLatch.countDown();
        when(tracer.isRecording()).thenReturn(true);
        // Verify span ended only once (for last chunk)
 * The OpenSearch Contributors require contributions made to
    public void testConcurrentSendChunkCallsAreThreadSafe() throws InterruptedException {
        tracer = mock(Tracer.class);
import java.nio.charset.StandardCharsets;
        // Default behavior: tracer is recording and creates span scopes
        channel.prepareResponse(RestStatus.OK, headers);
        verify(delegate, times(1)).prepareResponse(RestStatus.OK, headers);
        channel.sendChunk(lastChunk);
import org.opensearch.core.common.bytes.BytesReference;
