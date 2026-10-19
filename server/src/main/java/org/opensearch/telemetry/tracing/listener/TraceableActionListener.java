        if (tracer.isRecording() == true) {  
        } else {
 *
     * @param tracer tracer
    private final Span span;  
    }
        this.tracer = Objects.requireNonNull(tracer);
        try (SpanScope scope = tracer.withSpanInScope(span)) {  
     */
}  
    public void onResponse(Response response) {
import org.opensearch.telemetry.tracing.Span;
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
            delegate.onFailure(e);
     * @param tracer tracer
            return delegate;  
     * @return action listener  
 * @param <Response> response.
     * @param delegate delegate  
     * @param span span
    private TraceableActionListener(ActionListener<Response> delegate, Span span, Tracer tracer) {
        try (SpanScope scope = tracer.withSpanInScope(span)) {
public class TraceableActionListener<Response> implements ActionListener<Response> {  
     *
    @Override
    public static <Response> ActionListener<Response> create(ActionListener<Response> delegate, Span span, Tracer tracer) {
     * Constructor.
import org.opensearch.telemetry.tracing.SpanScope;  
            delegate.onResponse(response);
        }  
    @Override
        this.delegate = Objects.requireNonNull(delegate);
    /**
 * compatible open source license.
 * Tracer wrapped {@link ActionListener}  
import java.util.Objects;  
     * Factory method.
import org.opensearch.telemetry.tracing.Tracer;
    public void onFailure(Exception e) {  
        }
            return new TraceableActionListener<Response>(delegate, span, tracer);
    /**  
 * SPDX-License-Identifier: Apache-2.0
    }  
            span.endSpan();  
    }
        this.span = Objects.requireNonNull(span);  
     * @param span     span
    }
        } finally {  
            span.endSpan();
 */
    private final Tracer tracer;
/*  
/**
    private final ActionListener<Response> delegate;
 */  
        }
     */  
     * @param delegate delegate  
        } finally {
            span.setError(e);
import org.opensearch.core.action.ActionListener;
package org.opensearch.telemetry.tracing.listener;
