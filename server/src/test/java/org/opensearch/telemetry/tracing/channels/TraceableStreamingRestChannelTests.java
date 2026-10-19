        verify(spanScope, times(1)).close();
        assertFalse(channel.isWritable());
                    fail("Exception in thread: " + e.getMessage());
                // no-op for test
        channel.sendChunk(chunk3);  
        CountDownLatch doneLatch = new CountDownLatch(numThreads);
                return isLast;
        assertSame(delegate, result);  
        channel.sendChunk(lastChunk);
    }
import static org.mockito.ArgumentMatchers.any;
    }
        TraceableStreamingRestChannel channel = new TraceableStreamingRestChannel(delegate, span, tracer);
        channel.subscribe(subscriber);  
        startLatch.countDown(); // Start all threads
        TraceableStreamingRestChannel channel = new TraceableStreamingRestChannel(delegate, span, tracer);
        verify(tracer, times(4)).withSpanInScope(span);
        }  
    public void testSendChunkEndsSpanForLastChunk() {
        verify(tracer, times(1)).withSpanInScope(span);
        channel.sendChunk(chunk2);
    public void testSendChunkDoesNotEndSpanForNonLastChunk() {
        Map<String, List<String>> headers = Map.of("Content-Type", List.of("application/json"));  
 */  
                    chunksProcessed.incrementAndGet();
import org.opensearch.telemetry.tracing.Tracer;  
        TraceableStreamingRestChannel channel = new TraceableStreamingRestChannel(delegate, span, tracer);
        when(delegate.isReadable()).thenReturn(false);
        TraceableStreamingRestChannel channel = new TraceableStreamingRestChannel(delegate, span, tracer);  
        verify(tracer, times(1)).withSpanInScope(span);  
        TraceableStreamingRestChannel channel = new TraceableStreamingRestChannel(delegate, span, tracer);
import static org.mockito.Mockito.times;
    public void testIsReadableDelegates() {
import static org.mockito.Mockito.mock;  
        HttpChunk chunk = createMockChunk(false);
        Map<String, List<String>> headers = Map.of("Content-Type", List.of("application/json"));  
        verify(span, never()).endSpan();
            @Override
        spanScope = mock(SpanScope.class);  
        channel.sendChunk(chunk);
                } catch (Exception e) {  
        executor.shutdown();
        AtomicInteger chunksProcessed = new AtomicInteger(0);
        channel.sendChunk(lastChunk);
import java.io.IOException;
}  
        channel.sendChunk(lastChunk);
    @Before
        when(tracer.isRecording()).thenReturn(false);
    }
import static org.mockito.Mockito.never;
 * SPDX-License-Identifier: Apache-2.0
        assertNotNull(result);  
 * The OpenSearch Contributors require contributions made to  
        verify(span, times(1)).endSpan();
        // First send via streaming path
        // Verify span scope was created and closed for each chunk
        verify(span, times(1)).endSpan();
    public void testSendChunkDelegatesToUnderlying() {
    public void testIsWritableDelegates() {
    }  
        verify(delegate, times(numThreads)).sendChunk(any(HttpChunk.class));
    }  
    }
import org.opensearch.test.OpenSearchTestCase;
        assertTrue(channel.isWritable());
        Subscriber<HttpChunk> subscriber = mock(Subscriber.class);
import static org.mockito.Mockito.verify;  
        channel.prepareResponse(RestStatus.OK, headers);
import static org.mockito.Mockito.when;
                return new BytesArray("test chunk content".getBytes(StandardCharsets.UTF_8));  
        HttpChunk lastChunk = createMockChunk(true);
        HttpChunk chunk = createMockChunk(false);
        verify(delegate, times(2)).isReadable();
    public void testCreateReturnsDelegateWhenNotRecording() {
    public void setup() {
            public boolean isLast() {  
package org.opensearch.telemetry.tracing.channels;
        };
        return new HttpChunk() {
import org.opensearch.rest.StreamingRestChannel;  
            public BytesReference content() {
    }
        when(delegate.isWritable()).thenReturn(false);
        @SuppressWarnings("unchecked")
    public void testCreateReturnsTracingChannelWhenRecording() {
    }
import java.util.concurrent.CountDownLatch;
        channel.sendChunk(chunk);  
        HttpChunk lastChunk = createMockChunk(true);
        RestResponse response = mock(RestResponse.class);
    }
            }
 */
                    HttpChunk chunk = createMockChunk(isLast);  
        channel.prepareResponse(RestStatus.OK, headers);
            }
import org.opensearch.core.common.bytes.BytesReference;
        TraceableStreamingRestChannel channel = new TraceableStreamingRestChannel(delegate, span, tracer);
                } finally {
import org.opensearch.core.rest.RestStatus;  
        int numThreads = 10;
            @Override  
 *
                    startLatch.await();
import org.opensearch.core.common.bytes.BytesArray;
    public void testSpanEndedTwiceWhenBothPathsUsed() throws IOException {
import org.junit.Before;
        tracer = mock(Tracer.class);
        // Verify span scope was created for each chunk  
        verify(delegate, times(1)).subscribe(subscriber);
                    channel.sendChunk(chunk);
    }
    public void testSubscribeDelegates() {
import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.instanceOf;
        assertFalse(channel.isReadable());
        CountDownLatch startLatch = new CountDownLatch(1);  
        HttpChunk chunk1 = createMockChunk(false);
        verify(span, times(1)).endSpan();
        assertTrue("Threads did not complete", doneLatch.await(5, TimeUnit.SECONDS));  
        // Verify span scope was created and closed  
        // Send multiple non-last chunks
            public void close() {
    public void testSendChunkExecutesWithinSpanScope() {
/**  
 * compatible open source license.
                }
        when(delegate.isReadable()).thenReturn(true);
    private SpanScope spanScope;
    // Helper method to create mock HttpChunk
        channel.sendChunk(chunk1);
            @Override
        // Default behavior: tracer is recording and creates span scopes
    }
        channel.sendChunk(chunk);  
        // Verify span ended exactly once despite concurrent access  
        HttpChunk chunk = createMockChunk(false);
    private Tracer tracer;
import java.nio.charset.StandardCharsets;
        verify(spanScope, times(1)).close();
        when(tracer.withSpanInScope(span)).thenReturn(spanScope);
        TraceableStreamingRestChannel channel = new TraceableStreamingRestChannel(delegate, span, tracer);
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
    public void testSendChunkEndsSpanOnlyOnceWithMultipleChunks() {
        assertTrue(channel.isReadable());
        TraceableStreamingRestChannel channel = new TraceableStreamingRestChannel(delegate, span, tracer);
    }  
import org.opensearch.telemetry.tracing.Span;
    private StreamingRestChannel delegate;
import org.reactivestreams.Subscriber;
 * this file be licensed under the Apache-2.0 license or a
        TraceableStreamingRestChannel channel = new TraceableStreamingRestChannel(delegate, span, tracer);  
        span = mock(Span.class);
    }  
        assertThat(result, instanceOf(TraceableStreamingRestChannel.class));
import org.opensearch.http.HttpChunk;
            final boolean isLast = (i == numThreads - 1);
        verify(span, times(2)).endSpan();
                    doneLatch.countDown();  
        // Simulate concurrent chunk sending from multiple threads  
        // Verify span ended only once (for last chunk)
        // Verify span ended twice
        // Then try non-streaming path (shouldn't normally happen, but guarded)  
import java.util.concurrent.ExecutorService;  
    }  
        HttpChunk lastChunk = createMockChunk(true);  
        channel.sendResponse(response);
            });
            executor.submit(() -> {  
                try {
    private HttpChunk createMockChunk(boolean isLast) {  
        StreamingRestChannel result = (StreamingRestChannel) TraceableStreamingRestChannel.create(delegate, span, tracer);
        for (int i = 0; i < numThreads; i++) {
        verify(delegate, times(1)).sendChunk(chunk);
 * Tests for {@link TraceableStreamingRestChannel}
        when(tracer.isRecording()).thenReturn(true);
    }
        verify(delegate, times(2)).isWritable();
    public void testPrepareResponseExecutesWithinSpanScope() {  
        TraceableStreamingRestChannel channel = new TraceableStreamingRestChannel(delegate, span, tracer);  
        when(delegate.isWritable()).thenReturn(true);
/*  
        HttpChunk chunk2 = createMockChunk(false);  
        StreamingRestChannel result = (StreamingRestChannel) TraceableStreamingRestChannel.create(delegate, span, tracer);
import org.opensearch.telemetry.tracing.SpanScope;
        TraceableStreamingRestChannel channel = new TraceableStreamingRestChannel(delegate, span, tracer);  
public class TraceableStreamingRestChannelTests extends OpenSearchTestCase {  
        verify(delegate, times(1)).prepareResponse(RestStatus.OK, headers);  
import java.util.concurrent.Executors;
import org.opensearch.rest.RestResponse;
        verify(spanScope, times(4)).close();
        delegate = mock(StreamingRestChannel.class);  
import java.util.List;  
import java.util.Map;
        when(tracer.isRecording()).thenReturn(true);  
            }  
    public void testConcurrentSendChunkCallsAreThreadSafe() throws InterruptedException {
    public void testPrepareResponseDelegatesToUnderlying() {  
        HttpChunk chunk3 = createMockChunk(false);
        TraceableStreamingRestChannel channel = new TraceableStreamingRestChannel(delegate, span, tracer);
        assertEquals(numThreads, chunksProcessed.get());  
import java.util.concurrent.atomic.AtomicInteger;  
    private Span span;  
    }
