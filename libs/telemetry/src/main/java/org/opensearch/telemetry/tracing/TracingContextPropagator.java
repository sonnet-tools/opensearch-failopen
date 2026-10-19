/*  
    /**
     * @param setter to add tracing context in map
@ExperimentalApi
package org.opensearch.telemetry.tracing;
    /**
 * SPDX-License-Identifier: Apache-2.0
/**
     * Extracts current span from context
     */  
import java.util.function.BiConsumer;  
     * @return current span  
 *
import java.util.Map;
}  
     * Extracts current span from HTTP headers.  
    Optional<Span> extractFromHeaders(Map<String, Collection<String>> headers);
import java.util.Collection;  
    Optional<Span> extract(Map<String, String> props);  
 * The OpenSearch Contributors require contributions made to  
     * @param props properties  
     */
 */  
import org.opensearch.common.annotation.ExperimentalApi;
    void inject(Span currentSpan, BiConsumer<String, String> setter);
import java.util.Optional;
    /**
 */  
 * Interface defining the tracing related context propagation  
 * compatible open source license.
     * Injects tracing context
 * @opensearch.experimental
     *
     * @param currentSpan the current active span
 *
     */
     * @return current span
 * this file be licensed under the Apache-2.0 license or a
     * @param headers request headers to extract the context from
public interface TracingContextPropagator {
     *  
