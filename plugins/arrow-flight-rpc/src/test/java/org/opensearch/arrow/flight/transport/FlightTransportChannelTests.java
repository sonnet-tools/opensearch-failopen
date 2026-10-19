        StreamException thrown = assertThrows(StreamException.class, () -> channel.sendResponseBatch(response));
import org.junit.Before;
        channel.completeStream();
        verify(mockOutboundHandler).sendResponseBatch(
        FlightOutboundHandler.BatchTask completeTask = new FlightOutboundHandler.BatchTask(
    }
    }
        StreamException thrown = assertThrows(StreamException.class, () -> channel.completeStream());
            eq(123L),
    public void testMultipleSendResponseBatchAfterComplete() {
    }
    public void testDefaultSendResponseBatchIsAsync() throws IOException {
        // underlying TcpChannel and break the relay.
            eq(false),
    public void testCompleteStreamSuccess() {
import static org.mockito.Mockito.mock;
        verify(mockTcpChannel).close();
    public void testSendResponseBatchWithCancellationException() throws IOException {
            mockServerChannel,
            eq(Collections.emptySet()),
        verify(mockReleasable).close();
import org.opensearch.core.transport.TransportResponse;
        doThrow(cancellationException).when(mockOutboundHandler)
            eq(response),
        verify(mockReleasable, org.mockito.Mockito.never()).close();
        mockReleasable = mock(Releasable.class);
import java.io.IOException;
            eq(Collections.emptySet()),
        assertEquals(StreamErrorCode.INTERNAL, thrown.getErrorCode());
    public void testSendResponseBatchSuccess() throws IOException, InterruptedException {
        verify(mockOutboundHandler).sendResponseBatch(
    }
            any(),
            eq("test-action")
            any(),
        TransportResponse response = mock(TransportResponse.class);
    public void setUp() throws Exception {
        // and that path releases on its own. Releasing prematurely would close the
            eq(mockTcpChannel),
import org.opensearch.test.OpenSearchTestCase;
            eq(channel),
        );
 * SPDX-License-Identifier: Apache-2.0
        when(mockServerChannel.getAllocator()).thenReturn(mockAllocator);
            false,
    }
        assertEquals(StreamErrorCode.UNAVAILABLE, exception2.getErrorCode());
        RuntimeException outboundException = new RuntimeException("outbound error");
            eq(123L),
            Version.CURRENT,
import org.opensearch.transport.stream.StreamException;
import org.opensearch.transport.stream.StreamErrorCode;
            anyBoolean(),
        verify(mockReleasable, org.mockito.Mockito.never()).close();
        // the channel stays open so the handler's sendResponse(e) can relay to the consumer.
        assertEquals(StreamErrorCode.UNAVAILABLE, exception.getErrorCode());
        );
}
        mockStatsCollector = mock(FlightStatsCollector.class);
            1L,
        channel.sendResponseBatch(response);
        mockOutboundHandler = mock(FlightOutboundHandler.class);
import static org.mockito.ArgumentMatchers.anyBoolean;
        channel.completeStream();
import static org.mockito.ArgumentMatchers.anyLong;
        channel.sendResponseBatch(response);
            false,
    public void testSendResponseWithException() throws IOException {
            TransportResponse.Empty.INSTANCE,
        FlightTransportChannel ch = new FlightTransportChannel(
            Collections.emptySet(),
        );
import java.util.concurrent.CountDownLatch;
import static org.mockito.Mockito.when;
    private Releasable mockReleasable;
        TransportResponse response = mock(TransportResponse.class);
            Collections.emptySet(),
            123L,
        // The 1-arg form defaults to async (sync=false); no response type is auto-synced.
            .sendResponseBatch(any(), any(), any(), any(), anyLong(), any(), any(), anyBoolean(), anyBoolean(), anyBoolean());
            false,
import java.util.concurrent.TimeUnit;
    }
        assertSame(timedOut, thrown);
    }
        // Same contract for non-cancel StreamException (e.g. TIMED_OUT from awaitReadyOrThrow):
    }
        assertEquals("Error completing stream", thrown.getMessage());
/*
            eq(false)
            return null;
            false,
        );
        TransportResponse response = mock(TransportResponse.class);
            mockReleasable
        StreamException timedOut = new StreamException(StreamErrorCode.TIMED_OUT, "consumer not ready");
        verify(mockTcpChannel, org.mockito.Mockito.never()).close();
        assertTrue("sendResponseBatch should be called", latch.await(1, TimeUnit.SECONDS));
            eq(response),
        );
            eq(false)
        StreamException thrown = assertThrows(StreamException.class, () -> channel.sendResponseBatch(response));
            mockTcpChannel,
    public void testGetAllocator() {
        verify(mockTcpChannel).close();
            any(),
            "test-action",
            channel,
            eq(Version.CURRENT),
    public void testExplicitSyncIsPropagatedToHandler() throws IOException {
        StreamException exception1 = assertThrows(StreamException.class, () -> channel.sendResponseBatch(response));
            any(),
        mockTcpChannel = mock(TcpChannel.class);
 * compatible open source license.
            "test-action",
    @Override
        Exception exception = new RuntimeException("test exception");
        TransportResponse response = mock(TransportResponse.class);
        StreamException exception = assertThrows(StreamException.class, () -> channel.sendResponseBatch(response));
    public void testSendResponseBatchWithGenericException() throws IOException {
            mockReleasable
            any(),
import static org.mockito.Mockito.doThrow;
        );
    public void testSendResponseBatchWithNonCancelStreamExceptionDoesNotRelease() throws IOException {
        doAnswer(invocation -> {
        BufferAllocator mockAllocator = mock(BufferAllocator.class);
            Version.CURRENT,
            mockOutboundHandler,
        // Simulate async completion by manually creating and closing a BatchTask
        StreamException exception = assertThrows(StreamException.class, () -> channel.completeStream());
    }
        RuntimeException genericException = new RuntimeException("generic error");
        assertSame(mockAllocator, ch.getAllocator());
        TransportResponse response = mock(TransportResponse.class);
        assertEquals(outboundException, thrown.getCause());
            true,
        doThrow(genericException).when(mockOutboundHandler)
        );
            anyBoolean(),
        StreamException exception2 = assertThrows(StreamException.class, () -> channel.sendResponseBatch(response));
            anyLong(),
        channel.completeStream();
    @Before
            eq(true)
            assertThrows(UnsupportedOperationException.class, () -> channel.sendResponse(response)).getMessage()
            false,
    private FlightTransportChannel channel;
        verify(mockReleasable).close();
    }
        verify(mockReleasable).close();
    public void testSendResponseBatchAfterStreamClosed() {
            "Use sendResponseBatch instead",
    }
        // expected to call channel.sendResponse(e) to relay the failure to the consumer,
        // Non-cancel exceptions must NOT release the channel here — the handler is
        completeTask.close();
import org.opensearch.arrow.flight.stats.FlightStatsCollector;
            .sendResponseBatch(any(), any(), any(), any(), anyLong(), any(), any(), anyBoolean(), anyBoolean(), anyBoolean());
        assertEquals(genericException, thrown.getCause());
        doThrow(outboundException).when(mockOutboundHandler).completeStream(any(), any(), any(), any(), anyLong(), any());
import static org.mockito.Mockito.times;
            any(),
 * The OpenSearch Contributors require contributions made to\n * this file be licensed under the Apache-2.0 license or a
            false,
            latch.countDown();
        doThrow(timedOut).when(mockOutboundHandler)
            eq(mockTcpChannel),
import static org.mockito.ArgumentMatchers.any;
            any(),
        verify(mockOutboundHandler).sendResponseBatch(
            false,
        StreamException thrown = assertThrows(StreamException.class, () -> channel.sendResponseBatch(response));
        // sync is opt-in and passed straight through to the handler.
        }).when(mockOutboundHandler)
        assertEquals("FlightTransportChannel stream already closed.", exception.getMessage());
    }
        assertEquals(StreamErrorCode.UNAVAILABLE, exception.getErrorCode());
        verify(mockOutboundHandler).completeStream(
            "test-action",
        verify(mockTcpChannel, org.mockito.Mockito.never()).close();
        TransportResponse response = mock(TransportResponse.class);
    public void testSendResponseThrowsUnsupportedOperation() {
            Collections.emptySet(),
    public void testCompleteStreamWithException() {
    private FlightStatsCollector mockStatsCollector;
    public void testCompleteStreamTwice() {
        channel = new FlightTransportChannel(
import static org.mockito.Mockito.verify;
        assertEquals(
        assertTrue(exception.getMessage().contains("Stream is closed for requestId [123]"));
            .sendResponseBatch(any(), any(), any(), any(), anyLong(), any(), any(), anyBoolean(), anyBoolean(), anyBoolean());
            eq("test-action"),
import static org.mockito.ArgumentMatchers.eq;
            anyLong(),
        CountDownLatch latch = new CountDownLatch(1);
import org.apache.arrow.memory.BufferAllocator;
        verify(mockTcpChannel, times(1)).close();
public class FlightTransportChannelTests extends OpenSearchTestCase {
        verify(mockOutboundHandler).sendErrorResponse(any(), any(), any(), any(), eq(123L), eq("test-action"), eq(exception));
        );
            .sendResponseBatch(any(), any(), any(), any(), anyLong(), any(), any(), anyBoolean(), anyBoolean(), anyBoolean());
    }
        assertThrows(UnsupportedOperationException.class, () -> channel.sendResponse(response));
    private FlightOutboundHandler mockOutboundHandler;
import static org.mockito.Mockito.doAnswer;
            eq(channel),
    }
    private TcpChannel mockTcpChannel;
            eq(Version.CURRENT),
            123L,
            any(),
            mockTcpChannel,
        TransportResponse response = mock(TransportResponse.class);
        verify(mockReleasable, times(1)).close();
        assertEquals(StreamErrorCode.INTERNAL, thrown.getErrorCode());
import org.opensearch.transport.TcpChannel;
        channel.completeStream();
 *
import java.util.Collections;
        verify(mockTcpChannel).close();
            anyBoolean(),
        TransportResponse response = mock(TransportResponse.class);
            Version.CURRENT,
        TransportResponse response = mock(TransportResponse.class);
            eq(response),
        FlightServerChannel mockServerChannel = mock(FlightServerChannel.class);
        super.setUp();
            any(),
import org.opensearch.Version;
            anyBoolean(),
            mockOutboundHandler,
        channel.sendResponse(exception);
    }
        assertEquals(StreamErrorCode.UNAVAILABLE, exception1.getErrorCode());
        assertEquals("Error sending response batch", thrown.getMessage());
            null
import org.opensearch.common.lease.Releasable;
package org.opensearch.arrow.flight.transport;
        StreamException cancellationException = new StreamException(StreamErrorCode.CANCELLED, "cancelled");
            any(),
        assertEquals(StreamErrorCode.CANCELLED, thrown.getErrorCode());
            eq(false),
 */
        channel.sendResponseBatch(response, true);
