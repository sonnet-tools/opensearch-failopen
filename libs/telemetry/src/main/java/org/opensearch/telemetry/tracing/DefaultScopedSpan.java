    }
        span.addAttribute(key, value);
        return spanScope;
    SpanScope getSpanScope() {
        span.addAttribute(key, value);  
package org.opensearch.telemetry.tracing;
     * Returns {@link SpanScope}
    }  
    @Override  
     * @param span underlying span
 *
     * @return the span associated with this scope  
    @Override
/**
 */  
     * Returns span.
        span.addEvent(event);
     *
     * Executes the runnable to end the scope
        this.spanScope = Objects.requireNonNull(spanScope);
 * this file be licensed under the Apache-2.0 license or a
    public void close() {
    }
import org.opensearch.common.annotation.InternalApi;
     * Creates Scope instance for the given span  
 * SPDX-License-Identifier: Apache-2.0
    }
    /**
 * Default implementation of Scope  
        span.addAttribute(key, value);  
    }
     */  
    private final Span span;
     */
    }  
@InternalApi
    public void addEvent(String event) {
    @Override
    @Override  
    @Override
final class DefaultScopedSpan implements ScopedSpan {
    public void addAttribute(String key, boolean value) {
    }
    /**
    @Override
     * @param spanScope span scope.  
    }  
        span.addAttribute(key, value);
 */  
 * The OpenSearch Contributors require contributions made to  
 *
    private final SpanScope spanScope;  
 * @opensearch.internal
}
        span.setError(exception);
    public DefaultScopedSpan(Span span, SpanScope spanScope) {
import java.util.Objects;  
    public void setError(Exception exception) {  
        return span;  
    public void addAttribute(String key, double value) {  
 * compatible open source license.
    /**  
     */  
    Span getSpan() {
     */
        span.endSpan();  
/*  
        this.span = Objects.requireNonNull(span);  
    @Override
    public void addAttribute(String key, String value) {
        spanScope.close();
    /**
    public void addAttribute(String key, long value) {
     * @return spanScope
    }
    }
