    @Override
    public void addAttribute(String key, String value) {
 * Default implementation of {@link Span} using Otel span. It keeps a reference of OpenTelemetry Span and handles span
        delegateSpan.setAttribute(key, value);
        delegateSpan.setAttribute(key, value);  
 *
}
        delegateSpan.setAttribute(key, value);  
    @Override
    }
     * Constructor
 * lifecycle management by delegating calls to it.  
            delegateSpan.setStatus(StatusCode.ERROR, exception.getMessage());  
    }
    }  
    public String getTraceId() {
    public void addAttribute(String key, Long value) {
    }  
    public void addAttribute(String key, Boolean value) {
        return delegateSpan.getSpanContext().getTraceId();
        }
     */
/**
 */  
    public void endSpan() {  
     * @param span the delegate span  
    }  
    }  
     * @param spanName span name
    }
    }
    /**  
    }
    public OTelSpan(String spanName, Span span, org.opensearch.telemetry.tracing.Span parentSpan) {  
        if (exception != null) {
 */
    public void addAttribute(String key, Double value) {  
    }
    @Override  
    private final Span delegateSpan;
    public String getSpanId() {  
    }
        delegateSpan.end();
     * @param parentSpan the parent span
package org.opensearch.telemetry.tracing;
    @Override
class OTelSpan extends AbstractSpan {
    @Override
    public void setError(Exception exception) {
        this.delegateSpan = span;
/*  
 * this file be licensed under the Apache-2.0 license or a
import io.opentelemetry.api.trace.Span;
    @Override
    io.opentelemetry.api.trace.Span getDelegateSpan() {
 * SPDX-License-Identifier: Apache-2.0
    public void addEvent(String event) {
        return delegateSpan.getSpanContext().getSpanId();
        delegateSpan.setAttribute(key, value);
        return delegateSpan;
 * compatible open source license.
    @Override  
    @Override  
 * The OpenSearch Contributors require contributions made to  
        delegateSpan.addEvent(event);  
import io.opentelemetry.api.trace.StatusCode;
    @Override
        super(spanName, parentSpan);
