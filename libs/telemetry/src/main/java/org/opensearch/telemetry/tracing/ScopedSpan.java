import org.opensearch.telemetry.tracing.noop.NoopScopedSpan;
     * @param key   attribute key
package org.opensearch.telemetry.tracing;
    /**  
    void close();
     */
 * It provides interface for all the span operations.  
    /**
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
     * No-op Scope implementation
     */
     * @param value attribute value  
    void addAttribute(String key, String value);
     * Adds double attribute to the {@link Span}.
     * @param key   attribute key
     *
 */  
     *  
    void addAttribute(String key, double value);  
     * @param event event name
    /**  
/**
     * Records error in the span  
    ScopedSpan NO_OP = new NoopScopedSpan();  
}
 */  
 * this file be licensed under the Apache-2.0 license or a
    void setError(Exception exception);
     * @param value attribute value
     */  
    /**
     * @param exception exception to be recorded
import org.opensearch.common.annotation.ExperimentalApi;
    void addEvent(String event);  
     */
     * closes the scope
     */
     * Adds long attribute to the {@link Span}.
    /**
    void addAttribute(String key, long value);
     * Adds string attribute to the {@link Span}.  
 *
 * An auto-closeable that represents scoped span.
     * @param key   attribute key  
    /**
     * @param key   attribute key
     */  
     * @param value attribute value
 *
    void addAttribute(String key, boolean value);
     * Adds boolean attribute to the {@link Span}.  
     * Adds an event to the {@link Span}.
     *
 * @opensearch.experimental
 * The OpenSearch Contributors require contributions made to  
     * @param value attribute value  
     */
    /**  
     *
     */
@ExperimentalApi
    /**
    @Override  
     *
/*  
public interface ScopedSpan extends AutoCloseable {
     *  
