     */
 *
     */
     * @param span span which is starting.  
 * Processes the span and can perform any action on the span start and end.
import org.opensearch.telemetry.tracing.Span;
/**  
/*  
package org.opensearch.test.telemetry.tracing;
 */
    /**
     * Logic to be executed on span end.
 * this file be licensed under the Apache-2.0 license or a
    void onEnd(Span span);
 * The OpenSearch Contributors require contributions made to  
}  
public interface SpanProcessor {  
    /**
 * compatible open source license.
    void onStart(Span span);
     * Logic to be executed on span start.
 * SPDX-License-Identifier: Apache-2.0
 */  
     * @param span span which is ending.  
