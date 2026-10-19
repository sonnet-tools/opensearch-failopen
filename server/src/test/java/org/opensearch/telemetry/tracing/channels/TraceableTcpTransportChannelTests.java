        verify(spanScope, times(1)).close();
import org.opensearch.core.transport.TransportResponse;
 */  
        }
        tcpChannel.close();
    public void testCloseListenersDoNotAccumulateOverRequests() throws IOException {
        Exception exception = new IOException("something went wrong");
import java.util.ArrayList;  
    @Before
import static org.mockito.Mockito.times;
        span = mock(Span.class);  
 * this file be licensed under the Apache-2.0 license or a
            spans.add(requestSpan);  
    }  
        verify(span, never()).setError(any());
    }  
import java.util.List;
        when(tracer.withSpanInScope(span)).thenReturn(spanScope);  
        verify(tcpChannel, times(requests)).addCloseListener(any(BiConsumer.class));
        verify(tcpChannel, never()).addCloseListener(any(BiConsumer.class));  
            verify(requestSpan, times(1)).endSpan();
        TransportResponse response = mock(TransportResponse.class);
    public void testCreateReturnsTracingChannelWhenRecording() {  
 * SPDX-License-Identifier: Apache-2.0
    public void testSpanIsEndedWhenTheChannelIsClosedWithoutAResponse() {
    }  
        TransportChannel channel = TraceableTcpTransportChannel.create(delegate, span, tracer);
import org.opensearch.transport.FakeTcpChannel;  
        ArgumentCaptor<BiConsumer<Void, ? super Exception>> listener = ArgumentCaptor.forClass(BiConsumer.class);
        // so a listener registered per request must not be left behind on it
        verify(span, times(1)).endSpan();  
import static org.hamcrest.Matchers.instanceOf;  
        List<Span> spans = new ArrayList<>(requests);  
        channel.sendResponse(mock(TransportResponse.class));
 * compatible open source license.
        TransportChannel channel = TraceableTcpTransportChannel.create(delegate, span, tracer);
        tcpChannel = spy(new FakeTcpChannel());
import static org.mockito.Mockito.verify;  
        verify(tcpChannel, times(requests)).removeCloseListener(any());
        verify(span, times(1)).addEvent("The TransportChannel was closed without sending the response");
import org.opensearch.telemetry.tracing.Span;
    }
 *
import org.opensearch.test.OpenSearchTestCase;
        verify(tracer, times(1)).withSpanInScope(span);
            TraceableTcpTransportChannel.create(delegate, requestSpan, tracer).sendResponse(mock(TransportResponse.class));
import static org.mockito.Mockito.mock;
import org.junit.Before;  
    }
        verify(span, times(1)).setError(exception);
    }
        TraceableTcpTransportChannel.create(delegate, span, tracer);  
import static org.mockito.Mockito.any;
        verify(span, times(1)).endSpan();  
        assertSame(delegate, channel);
        // the very listener that was registered is the one handed back
        }
    private TcpTransportChannel delegate;  
        // a transport connection carries every request between two nodes and is only closed when a node goes away,  
        when(tracer.isRecording()).thenReturn(true);
import org.opensearch.transport.TcpTransportChannel;
    public void testCreateReturnsDelegateWhenNotRecording() {  
    private Span span;
    public void setup() {  
        spanScope = mock(SpanScope.class);
/**  
            Span requestSpan = mock(Span.class);
package org.opensearch.telemetry.tracing.channels;
import java.util.function.BiConsumer;
import static org.mockito.Mockito.when;
import org.opensearch.telemetry.tracing.Tracer;
        when(delegate.getChannel()).thenReturn(tcpChannel);
    }
    }
        verify(span, times(1)).addEvent("The TransportChannel was closed without sending the response");
        TransportChannel channel = TraceableTcpTransportChannel.create(delegate, span, tracer);
        verify(delegate, times(1)).sendResponse(exception);  
        TransportChannel channel = TraceableTcpTransportChannel.create(delegate, span, tracer);  
    public void testSpanIsEndedWhenTheChannelIsAlreadyClosed() {  
import org.opensearch.transport.TransportChannel;
        channel.sendResponse(exception);
import org.opensearch.telemetry.tracing.SpanScope;  
/*  
        when(tracer.isRecording()).thenReturn(false);
    @SuppressWarnings("unchecked")
import org.mockito.ArgumentCaptor;
public class TraceableTcpTransportChannelTests extends OpenSearchTestCase {  
import static org.mockito.Mockito.never;  
import static org.mockito.Mockito.spy;
    public void testCloseListenerIsGivenBackOnceTheResponseIsSent() throws IOException {  
        assertThat(channel, instanceOf(TraceableTcpTransportChannel.class));  
        for (int i = 0; i < requests; i++) {
        verify(tcpChannel).addCloseListener(listener.capture());  
}
        int requests = randomIntBetween(2, 100);
    public void testSendErrorResponseMarksSpanAsErrorAndEndsIt() throws IOException {  
        for (Span requestSpan : spans) {  
        TransportChannel channel = TraceableTcpTransportChannel.create(delegate, span, tracer);
import java.io.IOException;
        delegate = mock(TcpTransportChannel.class);
        tcpChannel.close();
    public void testSendResponseEndsSpanWithinScope() throws IOException {  
        verify(span, times(1)).endSpan();  
    private SpanScope spanScope;  
        // those spans are done, so closing the connection must not touch them again
 */
        channel.sendResponse(response);
    private Tracer tracer;
        verify(span, times(1)).endSpan();
        tracer = mock(Tracer.class);
 * Tests for {@link TraceableTcpTransportChannel}
        verify(tcpChannel).removeCloseListener(listener.getValue());
    private FakeTcpChannel tcpChannel;
        verify(delegate, times(1)).sendResponse(response);  
 * The OpenSearch Contributors require contributions made to  
        TraceableTcpTransportChannel.create(delegate, span, tracer);  
        tcpChannel.close();
    }
