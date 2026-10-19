        final Span beforeSpan = tracerContextStorage.get(TracerContextStorage.CURRENT_SPAN);
    }  
        tracerContextStorage.put(TracerContextStorage.CURRENT_SPAN, this.span);
 *
    @Override
        return newSpanScope;  
     * @param previousSpanScope before attached span scope.  
    public void close() {
    @Override  
 */  
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal
     * Constructor
package org.opensearch.telemetry.tracing;
    }
        spanScopeThreadLocal.set(previousSpanScope);
    private final SpanScope previousSpanScope;
     * @return SpanScope spanScope  
     */
     * @param span span
            tracerContextStorage.put(TracerContextStorage.CURRENT_SPAN, null);
    ) {
/*  
        }  
}  
    private final TracerContextStorage<String, Span> tracerContextStorage;
        Span span,  
 * this file be licensed under the Apache-2.0 license or a
            tracerContextStorage.put(TracerContextStorage.CURRENT_SPAN, beforeSpan);  
 * The OpenSearch Contributors require contributions made to  
    static SpanScope getCurrentSpanScope() {
        SpanScope newSpanScope = new DefaultSpanScope(span, beforeSpan, beforeSpanScope, tracerContextStorage);
    }  
    @Override  
        detach();
        this.span = Objects.requireNonNull(span);
    public SpanScope attach() {  
import org.opensearch.common.annotation.InternalApi;
    }
    }
    private final Span span;  
        final SpanScope beforeSpanScope = spanScopeThreadLocal.get();  
    private final Span beforeSpan;
 */  
        TracerContextStorage<String, Span> tracerContextStorage  
 * Default implementation for {@link SpanScope}  
@InternalApi
    }  
        this.beforeSpan = beforeSpan;  
        return span;
 *
    private static final ThreadLocal<SpanScope> spanScopeThreadLocal = new ThreadLocal<>();  
class DefaultSpanScope implements SpanScope {
        SpanScope previousSpanScope,
        final Span beforeSpan,
    /**  
        return spanScopeThreadLocal.get();  
        spanScopeThreadLocal.set(this);
     * @param span span.
        if (beforeSpan != null) {
    /**
 * compatible open source license.
    private void detach() {  
        this.previousSpanScope = previousSpanScope;
    private DefaultSpanScope(
    }
    public Span getSpan() {
     * @param tracerContextStorage tracer context storage.
        return this;  
    public static SpanScope create(Span span, TracerContextStorage<String, Span> tracerContextStorage) {
        } else {
        this.tracerContextStorage = tracerContextStorage;
     */
     * Creates the SpanScope object.  
import java.util.Objects;  
/**
