 * this file be licensed under the Apache-2.0 license or a
     *
    /**  
}
    Span startSpan(SpanCreationContext spanCreationContext, Map<String, Collection<String>> headers);
 * TransportTracer helps in creating a {@link Span} which reads the incoming tracing information  
 */  
 * SPDX-License-Identifier: Apache-2.0
     * @param spanCreationContext span name.  
public interface TransportTracer {
import org.opensearch.common.annotation.ExperimentalApi;
 */  
 * from the HTTP or TCP transport headers and propagate the span accordingly.
 * compatible open source license.
     * Start the span with propagating the tracing info from the HttpRequest header.
     */  
import org.opensearch.telemetry.tracing.SpanCreationContext;  
     * @return the span instance
 * @opensearch.experimental
/**
import org.opensearch.telemetry.tracing.Span;
 *
 * The OpenSearch Contributors require contributions made to  
 * <p>
 * All methods on the Tracer object are multi-thread safe.  
@ExperimentalApi
package org.opensearch.telemetry.tracing.transport;
import java.util.Map;  
     * @param headers transport headers
import java.util.Collection;
/*  
 *
