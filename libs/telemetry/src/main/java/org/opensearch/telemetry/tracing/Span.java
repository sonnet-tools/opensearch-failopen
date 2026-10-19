    /**
     * @param value value of the attribute
     * Ends the span
 * The OpenSearch Contributors require contributions made to  
     *  
    /**  
    String getSpanName();
public interface Span {
 * compatible open source license.
     */
 * this file be licensed under the Apache-2.0 license or a
     * @param key of the attribute  
    void addAttribute(String key, Boolean value);
     * @return span's traceId
     * Returns the name of the {@link Span}  
    /**  
     * Records error in the span
     * @param key of the attribute
    /**
    void endSpan();
     * Adds an event in the span
/**  
 *
 */  
 * SPDX-License-Identifier: Apache-2.0
    void addAttribute(String key, String value);
    /**
    /**
 * Span must be ended by calling SpanScope.close which internally calls Span's endSpan.  
     */
    /**
     */
     * @param key of the attribute
     */
     *  
     */  
    /**
     */  
package org.opensearch.telemetry.tracing;
     *
     * @param value value of the attribute  
    /**
@ExperimentalApi
 *
    String getTraceId();  
     */
    Span getParentSpan();  
     */
    void addAttribute(String key, Double value);
    /**
    String getSpanId();  
     */
     *
 * Spans are created by the Tracer.startSpan method.
     * @param key of the attribute
     * @param value value of the attribute
     * @param value value of the attribute
     * Returns spanId of the span  
     * @param event name of the event
    void setError(Exception exception);
    /**  
     *  
     */  
/*  
     * @param exception exception to be recorded  
 * @opensearch.experimental
     *
     * Adds double type attribute in the span  
}
    void addAttribute(String key, Long value);  
 */  
     * Returns traceId of the span  
     */
     * Returns span's parent span
     * @return span's spanId
 * An interface that represents a tracing span.
     * Adds long type attribute in the span
     * Adds boolean type attribute in the span
     * Adds string type attribute in the span
import org.opensearch.common.annotation.ExperimentalApi;
    void addEvent(String event);  
