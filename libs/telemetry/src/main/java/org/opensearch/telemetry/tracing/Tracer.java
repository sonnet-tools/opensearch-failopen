     * Returns the current span.
     * Starts the {@link Span} with given {@link SpanCreationContext}
/**  
import org.opensearch.common.annotation.ExperimentalApi;
 * compatible open source license.
     */
 * Tracer is the interface used to create a {@link Span}
 *
import org.opensearch.telemetry.tracing.transport.TransportTracer;
     * automatically manage the attach /detach to the current thread.
    /**
     * @return ScopedSpan  
package org.opensearch.telemetry.tracing;
 * All methods on the Tracer object are multi-thread safe.
    Span startSpan(SpanCreationContext context);
 * The OpenSearch Contributors require contributions made to  
    /**  
    /**
    SpanScope withSpanInScope(Span span);
     * @return boolean  
}
     * Tells if the traces are being recorded or not
    /**  
     * @return span, must be closed.
     */  
 * @opensearch.experimental  
     */
@ExperimentalApi
 * this file be licensed under the Apache-2.0 license or a
     * Creates the Span Scope for a current thread. It's mandatory to scope the span just after creation so that it will  
 * SPDX-License-Identifier: Apache-2.0
     * @param span span to be scoped
    /**
/*  
 * <p>  
     * are same and ends within the same thread where created.
     * @return current wrapped span.
     */
     *  
     * @return scope of the span, must be closed with explicit close or with try-with-resource
 */
 *
import java.io.Closeable;
     */  
     * @param spanCreationContext span creation context  
     * @param context span context
 * It automatically handles the context propagation between threads, tasks, nodes etc.
    SpanContext getCurrentSpan();
public interface Tracer extends TransportTracer, Closeable {  
 */  
     * Start the span and scoped it. This must be used for scenarios where {@link SpanScope} and {@link Span} lifecycles
    boolean isRecording();
    ScopedSpan startScopedSpan(SpanCreationContext spanCreationContext);  
