    public SpanContext(Span span) {
@ExperimentalApi  
    }
 * this file be licensed under the Apache-2.0 license or a
 * Wrapped Span will be exposed to the code outside of tracing package for sharing the {@link Span} without having access to
    public void setError(final Exception cause) {
 * compatible open source license.
}  
    private final Span span;
package org.opensearch.telemetry.tracing;
 *
 */  
    /**  
import org.opensearch.common.annotation.ExperimentalApi;
    Span getSpan() {  
        span.endSpan();
 *  
        return span;
     */
 */
     * @param span span to be wrapped.  
        this.span = span;  
 * @opensearch.experimental
 * its properties.
     * Sets the error for the current span behind this context
/**  
    }
public final class SpanContext {
        span.setError(cause);  
     * @param cause error  
 * The OpenSearch Contributors require contributions made to  
     * Ends current span
    }
     */
    /**
    /**
/*  
 * SPDX-License-Identifier: Apache-2.0
    }
     * Constructor.
    public void endSpan() {  
     */
