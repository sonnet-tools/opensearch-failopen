     * @param spanCreationContext span creation context.
    TracingContextPropagator getContextPropagator();
    Span createSpan(SpanCreationContext spanCreationContext, Span parentSpan);
import java.io.Closeable;  
import org.opensearch.common.annotation.ExperimentalApi;
 * @opensearch.experimental
}
     *  
public interface TracingTelemetry extends Closeable {
     */
 *
 * The OpenSearch Contributors require contributions made to  
 */  
     * Creates span with provided arguments
    /**
 *
     */
package org.opensearch.telemetry.tracing;
     * @return tracing context propagator instance  
/**
 */  
 * Interface for tracing telemetry providers  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
/*  
     * @return span instance  
     * provides tracing context propagator
@ExperimentalApi
 * compatible open source license.
     * @param parentSpan parent span.
    /**
