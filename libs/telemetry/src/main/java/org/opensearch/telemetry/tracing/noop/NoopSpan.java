    @Override
    }
    private NoopSpan() {
    }
        return "noop-trace-id";
    /**  
    public Span getParentSpan() {  
import org.opensearch.common.annotation.InternalApi;
    public void addAttribute(String key, String value) {
    }  
    public void addAttribute(String key, Double value) {
/*  
    public String getSpanId() {  
    }  
    @Override  
}  
@InternalApi  
    public void addAttribute(String key, Long value) {  
 *  
        return "noop-span";  
/**
        return null;
 * SPDX-License-Identifier: Apache-2.0
    }
        return "noop-span-id";
    }
    @Override  
    public String getTraceId() {
 */
 * The OpenSearch Contributors require contributions made to  
    @Override
import org.opensearch.telemetry.tracing.Span;
    @Override  
    @Override
    }  
    public void endSpan() {
 */  
    @Override
    }
    }
    @Override  
    public String getSpanName() {
    }  
 * compatible open source license.
 * @opensearch.internal
    public void addEvent(String event) {
 * this file be licensed under the Apache-2.0 license or a
    public void setError(Exception exception) {  
    @Override
     * No-op Span instance
    @Override
 * No-op implementation of {@link org.opensearch.telemetry.tracing.Span}
    }
    public final static NoopSpan INSTANCE = new NoopSpan();  
    @Override
    }
     */
    public void addAttribute(String key, Boolean value) {
package org.opensearch.telemetry.tracing.noop;
 *
public class NoopSpan implements Span {
