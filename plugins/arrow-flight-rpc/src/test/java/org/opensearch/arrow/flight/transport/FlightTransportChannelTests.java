        channel.completeStream();  
        doThrow(cancellationException).when(mockOutboundHandler)
            eq("test-action"),
        // expected to call channel.sendResponse(e) to relay the failure to the consumer,  
            any(),
        doAnswer(invocation -> {
    }
            mockOutboundHandler,
        verify(mockTcpChannel, org.mockito.Mockito.never()).close();
            Version.CURRENT,
    }  
            Version.CURRENT,  
        // The 1-arg form defaults to async (sync=false); no response type is auto-synced.
        assertEquals(StreamErrorCode.CANCELLED, thrown.getErrorCode());
        assertEquals(StreamErrorCode.UNAVAILABLE, exception.getErrorCode());  
        BufferAllocator mockAllocator = mock(BufferAllocator.class);  
            eq(true)  
            eq(channel),  
import java.util.concurrent.CountDownLatch;
package org.opensearch.arrow.flight.transport;
        );  
        TransportResponse response = mock(TransportResponse.class);  
        TransportResponse response = mock(TransportResponse.class);
            anyLong(),
        when(mockServerChannel.getAllocator()).thenReturn(mockAllocator);
        StreamException thrown = assertThrows(StreamException.class, () -> channel.completeStream());
            .sendResponseBatch(any(), any(), any(), any(), anyLong(), any(), any(), anyBoolean(), anyBoolean(), anyBoolean());  
        channel.sendResponseBatch(response);
        verify(mockReleasable, org.mockito.Mockito.never()).close();
        channel.completeStream();
        super.setUp();
    }
        assertEquals(genericException, thrown.getCause());  
        // Same contract for non-cancel StreamException (e.g. TIMED_OUT from awaitReadyOrThrow):  
        );
            1L,
import org.opensearch.transport.stream.StreamException;
    }
            "test-action",  
        verify(mockReleasable, org.mockito.Mockito.never()).close();
    }
            false,  
import java.util.Collections;  
            channel,
    }  
        assertEquals(StreamErrorCode.UNAVAILABLE, exception1.getErrorCode());
        StreamException exception = assertThrows(StreamException.class, () -> channel.completeStream());
            any(),
import static org.mockito.Mockito.mock;
        assertSame(mockAllocator, ch.getAllocator());
            mockTcpChannel,
            TransportResponse.Empty.INSTANCE,
    public void testDefaultSendResponseBatchIsAsync() throws IOException {
            anyBoolean(),
            Collections.emptySet(),
        mockReleasable = mock(Releasable.class);  
            any(),
            false,
    public void testSendResponseBatchWithCancellationException() throws IOException {  
    private FlightStatsCollector mockStatsCollector;
            123L,
            eq(123L),
            Collections.emptySet(),
import org.apache.arrow.memory.BufferAllocator;  
    public void testGetAllocator() {
            any(),  
import org.opensearch.transport.TcpChannel;  
            eq(channel),
import org.opensearch.arrow.flight.stats.FlightStatsCollector;
import org.opensearch.core.transport.TransportResponse;
        doThrow(genericException).when(mockOutboundHandler)  
        TransportResponse response = mock(TransportResponse.class);
import java.io.IOException;
        StreamException thrown = assertThrows(StreamException.class, () -> channel.sendResponseBatch(response));
            latch.countDown();
            "test-action",
            eq(false),
        FlightOutboundHandler.BatchTask completeTask = new FlightOutboundHandler.BatchTask(  
import static org.mockito.Mockito.doThrow;  
    }
            anyBoolean(),  
            return null;  
            eq(response),  
import org.opensearch.common.lease.Releasable;  
        FlightServerChannel mockServerChannel = mock(FlightServerChannel.class);
import static org.mockito.Mockito.doAnswer;
 * compatible open source license.
        verify(mockOutboundHandler).sendResponseBatch(  
    public void testSendResponseBatchWithNonCancelStreamExceptionDoesNotRelease() throws IOException {
        );
        verify(mockTcpChannel).close();  
        TransportResponse response = mock(TransportResponse.class);
import static org.mockito.ArgumentMatchers.any;
        StreamException thrown = assertThrows(StreamException.class, () -> channel.sendResponseBatch(response));  
    public void testSendResponseBatchAfterStreamClosed() {
        assertTrue("sendResponseBatch should be called", latch.await(1, TimeUnit.SECONDS));  
    public void testSendResponseBatchSuccess() throws IOException, InterruptedException {  
        assertEquals(outboundException, thrown.getCause());
        verify(mockReleasable).close();  
        );
        channel.sendResponseBatch(response);
        channel.completeStream();  
import org.opensearch.Version;
        );
            any(),
    public void testMultipleSendResponseBatchAfterComplete() {  
            assertThrows(UnsupportedOperationException.class, () -> channel.sendResponse(response)).getMessage()  
import org.opensearch.transport.stream.StreamErrorCode;
    }
            any(),
            false,
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(
            Collections.emptySet(),
            .sendResponseBatch(any(), any(), any(), any(), anyLong(), any(), any(), anyBoolean(), anyBoolean(), anyBoolean());
    }  
    public void testCompleteStreamTwice() {
            any(),  
        verify(mockTcpChannel).close();
        );  
    }
import static org.mockito.ArgumentMatchers.anyBoolean;
        verify(mockTcpChannel).close();
    @Before
        TransportResponse response = mock(TransportResponse.class);  
        verify(mockReleasable, times(1)).close();  
            false,
            mockTcpChannel,  
            "test-action",
            eq("test-action")
            anyLong(),
            .sendResponseBatch(any(), any(), any(), any(), anyLong(), any(), any(), anyBoolean(), anyBoolean(), anyBoolean());
        FlightTransportChannel ch = new FlightTransportChannel(
        // Simulate async completion by manually creating and closing a BatchTask
        assertEquals("Error completing stream", thrown.getMessage());  
            true,
        assertThrows(UnsupportedOperationException.class, () -> channel.sendResponse(response));  
        verify(mockOutboundHandler).sendResponseBatch(
            any(),  
        TransportResponse response = mock(TransportResponse.class);
            false,  
        doThrow(outboundException).when(mockOutboundHandler).completeStream(any(), any(), any(), any(), anyLong(), any());
        TransportResponse response = mock(TransportResponse.class);
        verify(mockOutboundHandler).completeStream(
        assertEquals(StreamErrorCode.INTERNAL, thrown.getErrorCode());
            anyBoolean(),
        RuntimeException genericException = new RuntimeException("generic error");
            eq(123L),  
            mockOutboundHandler,  
            mockReleasable
        StreamException thrown = assertThrows(StreamException.class, () -> channel.sendResponseBatch(response));
        assertEquals("FlightTransportChannel stream already closed.", exception.getMessage());
            any(),
        );
            123L,  
    private FlightOutboundHandler mockOutboundHandler;
        verify(mockReleasable).close();
/*  
    private FlightTransportChannel channel;  
    public void testExplicitSyncIsPropagatedToHandler() throws IOException {  
import static org.mockito.Mockito.verify;  
import org.junit.Before;  
            mockServerChannel,  
        // Non-cancel exceptions must NOT release the channel here — the handler is
    private Releasable mockReleasable;
        RuntimeException outboundException = new RuntimeException("outbound error");
}  
        channel.completeStream();  
        CountDownLatch latch = new CountDownLatch(1);
        verify(mockTcpChannel, org.mockito.Mockito.never()).close();
        StreamException exception1 = assertThrows(StreamException.class, () -> channel.sendResponseBatch(response));
    }
    public void testCompleteStreamSuccess() {
        StreamException cancellationException = new StreamException(StreamErrorCode.CANCELLED, "cancelled");
        channel = new FlightTransportChannel(
        }).when(mockOutboundHandler)
        channel.sendResponseBatch(response, true);
    }
        mockTcpChannel = mock(TcpChannel.class);
            null  
        channel.sendResponse(exception);
        // underlying TcpChannel and break the relay.
            false,
        TransportResponse response = mock(TransportResponse.class);
            eq(Collections.emptySet()),
    }  
    }
        assertEquals(StreamErrorCode.UNAVAILABLE, exception.getErrorCode());
import static org.mockito.ArgumentMatchers.anyLong;  
        Exception exception = new RuntimeException("test exception");
    public void testSendResponseWithException() throws IOException {
            eq(false)
        mockStatsCollector = mock(FlightStatsCollector.class);
            eq(mockTcpChannel),
        verify(mockOutboundHandler).sendResponseBatch(
        verify(mockReleasable).close();
            eq(response),
import static org.mockito.Mockito.times;
        // and that path releases on its own. Releasing prematurely would close the
    public void testCompleteStreamWithException() {  
            eq(false),  
        // sync is opt-in and passed straight through to the handler.  
        StreamException timedOut = new StreamException(StreamErrorCode.TIMED_OUT, "consumer not ready");  
        assertTrue(exception.getMessage().contains("Stream is closed for requestId [123]"));  
        doThrow(timedOut).when(mockOutboundHandler)
        assertSame(timedOut, thrown);  
 *
    public void setUp() throws Exception {
        StreamException exception = assertThrows(StreamException.class, () -> channel.sendResponseBatch(response));
            eq(Version.CURRENT),
            eq(false)
        StreamException exception2 = assertThrows(StreamException.class, () -> channel.sendResponseBatch(response));  
        // the channel stays open so the handler's sendResponse(e) can relay to the consumer.
            eq(response),
        mockOutboundHandler = mock(FlightOutboundHandler.class);  
import static org.mockito.Mockito.when;
            .sendResponseBatch(any(), any(), any(), any(), anyLong(), any(), any(), anyBoolean(), anyBoolean(), anyBoolean());
            eq(Collections.emptySet()),  
            "Use sendResponseBatch instead",
            any(),  
        );  
public class FlightTransportChannelTests extends OpenSearchTestCase {  
import org.opensearch.test.OpenSearchTestCase;
import static org.mockito.ArgumentMatchers.eq;
            eq(Version.CURRENT),  
    @Override  
        completeTask.close();
        assertEquals("Error sending response batch", thrown.getMessage());
            anyBoolean(),
            false,  
 */
        assertEquals(StreamErrorCode.INTERNAL, thrown.getErrorCode());
        verify(mockOutboundHandler).sendErrorResponse(any(), any(), any(), any(), eq(123L), eq("test-action"), eq(exception));  
    private TcpChannel mockTcpChannel;  
    }  
    public void testSendResponseBatchWithGenericException() throws IOException {
        verify(mockTcpChannel, times(1)).close();
        assertEquals(StreamErrorCode.UNAVAILABLE, exception2.getErrorCode());
            eq(mockTcpChannel),
import java.util.concurrent.TimeUnit;
    public void testSendResponseThrowsUnsupportedOperation() {  
        TransportResponse response = mock(TransportResponse.class);
 * The OpenSearch Contributors require contributions made to\n * this file be licensed under the Apache-2.0 license or a  
            Version.CURRENT,
            mockReleasable
