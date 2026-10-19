    }  
package org.opensearch.telemetry.tracing;
 * this file be licensed under the Apache-2.0 license or a
    public void setSpan(Span span) {  
     * Returns the span object
     */
     * @param span the span object to wrap  
    }
        return span;
     * Creates the wrapper with given span
 */  
import org.opensearch.common.annotation.InternalApi;
final class SpanReference {  
     * @return underlying span
     */
    }
     */  
@InternalApi
        this.span = span;  
 * Wrapper class to hold reference of Span
 * The OpenSearch Contributors require contributions made to  
    public SpanReference(Span span) {
 * @opensearch.internal  
    public Span getSpan() {
        this.span = span;
 *
     * Updates the underlying span  
 *
    /**
}  
 * SPDX-License-Identifier: Apache-2.0
    /**
     * @param span underlying span
 * compatible open source license.
    /**  
/**  
 */
/*  
    private Span span;
