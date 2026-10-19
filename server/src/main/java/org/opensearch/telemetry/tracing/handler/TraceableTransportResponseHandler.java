        } finally {
     * @param span span  
            span.setError(exp);  
    }
            delegate.handleStreamResponse(response);  
    @Override
    public boolean skipsDeserialization() {
 *
    @Override
            span.endSpan();
    }
}
        } finally {
    @Override  
import org.opensearch.transport.stream.StreamTransportResponse;
 * SPDX-License-Identifier: Apache-2.0
    @Override
    }
     */  
        TransportResponseHandler<S> delegate,
        }  
    @Override
    public String executor() {
 * this file be licensed under the Apache-2.0 license or a
    public void handleResponse(T response) {
        this.span = Objects.requireNonNull(span);
     * Factory method.
 * compatible open source license.
    }  
import org.opensearch.transport.TransportException;  
 * Tracer wrapped {@link TransportResponseHandler}
    @Override  
        }
        try (SpanScope scope = tracer.withSpanInScope(span)) {  
/*  
    }
        try (SpanScope scope = tracer.withSpanInScope(span)) {
/**
    ) {
    }  
    }
            span.endSpan();
            span.endSpan();
        Tracer tracer
     * @return transportResponseHandler
            delegate.handleException(exp);  
    @Override  
    public void handleStreamResponse(StreamTransportResponse<T> response) {
            span.endSpan();  
    public String toString() {  
        return delegate.toString();
 */  
        if (tracer.isRecording() == true) {  
        } finally {
    /**
    }
        return delegate.executor();  
    @Override  
import java.io.IOException;
    /**  
            return new TraceableTransportResponseHandler<S>(delegate, span, tracer);
     */
        return delegate.skipsDeserialization();
        } else {
        return delegate.read(in);  
        this.tracer = Objects.requireNonNull(tracer);  
 * The OpenSearch Contributors require contributions made to  
            delegate.handleResponse(response);  
            delegate.handleRejection(exp);
import org.opensearch.transport.TransportResponseHandler;
 */
     * @param delegate delegate
            return delegate;  
     * Constructor.  
    private final Span span;
        }
    private final TransportResponseHandler<T> delegate;
    }
import org.opensearch.core.common.io.stream.StreamInput;
     * @param span span  
        }
package org.opensearch.telemetry.tracing.handler;
     * @param tracer tracer
        this.delegate = Objects.requireNonNull(delegate);
import org.opensearch.telemetry.tracing.Tracer;
     * @param delegate delegate
     *
 * @param <T> TransportResponse  
     * @param tracer tracer
    }
import org.opensearch.telemetry.tracing.Span;  
public class TraceableTransportResponseHandler<T extends TransportResponse> implements TransportResponseHandler<T> {
import org.opensearch.core.transport.TransportResponse;
    public void handleException(TransportException exp) {
        } finally {
        }  
import java.util.Objects;
import org.opensearch.telemetry.tracing.SpanScope;
        Span span,  
        try (SpanScope scope = tracer.withSpanInScope(span)) {
    public void handleRejection(Exception exp) {
    private final Tracer tracer;  
            span.setError(exp);
    public static <S extends TransportResponse> TransportResponseHandler<S> create(
        try (SpanScope scope = tracer.withSpanInScope(span)) {
    private TraceableTransportResponseHandler(TransportResponseHandler<T> delegate, Span span, Tracer tracer) {  
    public T read(StreamInput in) throws IOException {
