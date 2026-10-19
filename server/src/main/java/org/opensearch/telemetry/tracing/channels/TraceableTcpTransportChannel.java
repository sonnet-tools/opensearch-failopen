            span.addEvent("The TransportChannel was closed without sending the response");  
        try (SpanScope scope = tracer.withSpanInScope(span)) {
    @Override  
        return delegate.getVersion();  
    /**  
/**
}
        }
    private final TransportChannel delegate;
     * @param delegate delegate  
     * Constructor.
     *
            endSpan();  
    public Version getVersion() {
    }
        } finally {
    private final BiConsumer<Void, Exception> closeListener;
import org.opensearch.transport.TcpTransportChannel;
    }  
    public void sendResponse(Exception exception) throws IOException {
    /**
import java.util.function.BiConsumer;  
     */
    }
        return delegate.get(name, clazz);
     * received over the connection and outlives them by a long way, so a listener that has done its job must not stay
    public <T> Optional<T> get(String name, Class<T> clazz) {
import org.opensearch.telemetry.tracing.Span;  
        }
    }
            if (e != null) {
            endSpan();
public class TraceableTcpTransportChannel extends BaseTcpTransportChannel {
import java.io.IOException;
    private final Span span;
            delegate.sendResponse(response);
    public void sendResponseBatch(TransportResponse response) {
    @Override
            endSpan();  
import org.opensearch.Version;
        getChannel().removeCloseListener(closeListener);
        return delegate.getProfileName();  
     */  
     * @param span     span
 */
            delegate.sendResponse(exception);  
     * @param tracer tracer
import org.opensearch.transport.TransportChannel;
            delegate.sendResponseBatch(response);
import org.opensearch.transport.BaseTcpTransportChannel;  
     */
        }
    }
    public String getProfileName() {
    @Override
    }
    public void completeStream() {
        delegate.getChannel().addCloseListener(closeListener);  
            throw ex;
            span.setError(exception);
                span.setError(e);
            delegate.completeStream();  
     * Ends the span of this request. The close listener is given back first: the channel is shared by every request  
    public static TransportChannel create(TcpTransportChannel delegate, final Span span, final Tracer tracer) {
            }  
     * @param tracer tracer
 * this file be licensed under the Apache-2.0 license or a
        } else {
package org.opensearch.telemetry.tracing.channels;
        } catch (final IOException ex) {  
import org.opensearch.core.transport.TransportResponse;
 * Tracer wrapped {@link TransportChannel}  
 */  
        try (SpanScope scope = tracer.withSpanInScope(span)) {
        }
            span.endSpan();
     * registered on it. Removing it before the span is ended also keeps a concurrent close from ending it twice.
        } finally {
    public void sendResponse(TransportResponse response) throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
     * Factory method.
        super(delegate.getChannel());
/*  
    public String getChannelType() {
    }
        this.tracer = tracer;
    @Override  
    }  
    @Override
            endSpan();
            return new TraceableTcpTransportChannel(delegate, span, tracer);
 * compatible open source license.
        this.span = span;  
        this.delegate = delegate;
    /**  
 *
        if (tracer.isRecording() == true) {  
        }  
     * @param span span  
 * The OpenSearch Contributors require contributions made to  
    public TraceableTcpTransportChannel(TcpTransportChannel delegate, Span span, Tracer tracer) {  
import org.opensearch.telemetry.tracing.SpanScope;
        return delegate.getChannelType();
            return delegate;  
    private void endSpan() {
            span.setError(ex);
        };
    private final Tracer tracer;  
     * @return transport channel  
    }
    @Override  
    }
        try (SpanScope scope = tracer.withSpanInScope(span)) {  
        } finally {
        span.endSpan();  
     * @param delegate delegate
    }  
        } finally {  
        try (SpanScope scope = tracer.withSpanInScope(span)) {
import java.util.Optional;
        this.closeListener = (unused, e) -> {
import org.opensearch.telemetry.tracing.Tracer;
