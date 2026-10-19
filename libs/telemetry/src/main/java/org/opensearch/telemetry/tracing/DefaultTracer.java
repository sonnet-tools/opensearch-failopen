        return DefaultSpanScope.create(span, tracerContextStorage).attach();
    /**
 */  
 * SPDX-License-Identifier: Apache-2.0
    private final TracerContextStorage<String, Span> tracerContextStorage;  
        return tracerContextStorage.get(TracerContextStorage.CURRENT_SPAN);
     */
    public Span startSpan(SpanCreationContext spanCreationContext, Map<String, Collection<String>> headers) {
     * @param tracerContextStorage storage used for storing current span context  
    }
     * Current thread name.
 * current active span in its storage  
    }  
    @Override
    }
 * The default tracer implementation. It handles tracing context propagation between spans by maintaining
        return new DefaultScopedSpan(span, spanScope);  
            parentSpan = getCurrentSpanInternal();
    public boolean isRecording() {  
 * compatible open source license.
import java.util.Optional;
    static final String THREAD_NAME = "thread.name";  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.telemetry.tracing;
    /**
import java.io.Closeable;  
        }
    @Override
     * Adds default attributes in the span  
    }
    @Override  
        ((Closeable) tracingTelemetry).close();
        Span span = createSpan(context, parentSpan);  
 *
    public SpanContext getCurrentSpan() {  
        this.tracingTelemetry = tracingTelemetry;  
    private final TracingTelemetry tracingTelemetry;
        addDefaultAttributes(span);
        return (currentSpan == null) ? null : new SpanContext(currentSpan);
    @Override
        Span parentSpan = null;  
    protected void addDefaultAttributes(Span span) {  
import java.util.Map;  
     * @param span the current active span
     * Creates DefaultTracer instance  
    }
        Span span = startSpan(spanCreationContext);
        final Span currentSpan = tracerContextStorage.get(TracerContextStorage.CURRENT_SPAN);
 * this file be licensed under the Apache-2.0 license or a
            parentSpan = context.getParent().getSpan();
    public DefaultTracer(TracingTelemetry tracingTelemetry, TracerContextStorage<String, Span> tracerContextStorage) {
    }
    }  
        Optional<Span> propagatedSpan = tracingTelemetry.getContextPropagator().extractFromHeaders(headers);  
    public SpanScope withSpanInScope(Span span) {
 *  @opensearch.internal
@InternalApi
import java.io.IOException;
 *
    }  
        return span;
 *
        return true;
    @Override
        return startSpan(spanCreationContext.parent(propagatedSpan.map(SpanContext::new).orElse(null)));
     *
import java.util.Collection;
    @Override
/**  
    }  
    /**  
     */
    public Span startSpan(SpanCreationContext context) {
        if (context.getParent() != null) {
        this.tracerContextStorage = tracerContextStorage;
        } else {  
/*  
        SpanScope spanScope = withSpanInScope(span);
    private Span getCurrentSpanInternal() {
     */
        span.addAttribute(THREAD_NAME, Thread.currentThread().getName());
}
        return tracingTelemetry.createSpan(spanCreationContext, parentSpan);
import org.opensearch.common.annotation.InternalApi;
    @Override
    }  
 */  
class DefaultTracer implements Tracer {
    public ScopedSpan startScopedSpan(SpanCreationContext spanCreationContext) {  
    }
    public void close() throws IOException {  
    private Span createSpan(SpanCreationContext spanCreationContext, Span parentSpan) {
     * @param tracingTelemetry tracing telemetry instance
