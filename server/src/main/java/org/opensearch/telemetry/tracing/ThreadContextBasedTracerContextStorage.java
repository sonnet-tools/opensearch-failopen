import org.opensearch.common.util.concurrent.ThreadContext;
    Span getCurrentSpan(String key) {
        }
            }  
 * compatible open source license.
        this.threadContext.registerThreadContextStatePropagator(this);
    @SuppressWarnings("removal")  
    }
    @Override
    @Override
        this.tracingTelemetry = Objects.requireNonNull(tracingTelemetry);  
        if (source.containsKey(CURRENT_SPAN)) {
    }  
    public Map<String, Object> transients(Map<String, Object> source, boolean isSystemContext) {  
}
 */  
    }  
            }
        }
import java.util.Objects;
                tracingTelemetry.getContextPropagator().inject(current.getSpan(), (key, value) -> headers.put(key, value));
            final SpanReference current = (SpanReference) source.get(CURRENT_SPAN);
    }  
        if (isSystemContext == true) {
        if (currentSpanRef == null) {  
        } else {
    private final ThreadContext threadContext;  
    }
 * Core's ThreadContext based TracerContextStorage implementation
import java.util.Collections;
    @Override
/*  
            if (current != null && current.getSpan() != null) {  
    private final TracingTelemetry tracingTelemetry;
    @Override
 */
    public Map<String, Object> transients(Map<String, Object> source) {  
        return transients;
        return getCurrentSpan(key);  
                transients.put(CURRENT_SPAN, new SpanReference(current.getSpan()));
/**
        final Map<String, String> headers = new HashMap<>();
    @Override  
import org.opensearch.common.util.concurrent.ThreadContextStatePropagator;  
    public Span get(String key) {
        } else {  
    }
    public Map<String, String> headers(Map<String, Object> source) {
    }
@InternalApi  
        if (source.containsKey(CURRENT_SPAN)) {
        final Map<String, Object> transients = new HashMap<>();
 * @opensearch.internal
    @SuppressWarnings("removal")
            currentSpanRef.setSpan(span);  
import java.util.HashMap;  
            return Collections.emptyMap();
import org.opensearch.common.annotation.InternalApi;
        return headers;
    public void put(String key, Span span) {
    }
        }
 * SPDX-License-Identifier: Apache-2.0
            threadContext.putTransient(key, new SpanReference(span));
        SpanReference currentSpanRef = threadContext.getTransient(key);
    @Override
    public ThreadContextBasedTracerContextStorage(ThreadContext threadContext, TracingTelemetry tracingTelemetry) {
            return transients(source);
            if (current != null && current.getSpan() != null) {
public class ThreadContextBasedTracerContextStorage implements TracerContextStorage<String, Span>, ThreadContextStatePropagator {
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.telemetry.tracing;
        }  
        return headers(source);
 *  
        this.threadContext = Objects.requireNonNull(threadContext);
        return (currentSpanRef == null) ? null : currentSpanRef.getSpan();  
    public Map<String, String> headers(Map<String, Object> source, boolean isSystemContext) {  
            final SpanReference current = (SpanReference) source.get(CURRENT_SPAN);  
        SpanReference currentSpanRef = threadContext.getTransient(key);
 *
import java.util.Map;
 * this file be licensed under the Apache-2.0 license or a
