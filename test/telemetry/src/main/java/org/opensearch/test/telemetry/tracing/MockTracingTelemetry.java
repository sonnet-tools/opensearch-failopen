        }
        if (shutdown.get() == false) {  
 *
    public TracingContextPropagator getContextPropagator() {
 * compatible open source license.
        Span span = new MockSpan(spanCreationContext, parentSpan, spanProcessor);
 * Mock {@link TracingTelemetry} implementation for testing.  
        return span;  
    @Override  
package org.opensearch.test.telemetry.tracing;
 * this file be licensed under the Apache-2.0 license or a
    private final AtomicBoolean shutdown = new AtomicBoolean(false);
import org.opensearch.telemetry.tracing.TracingTelemetry;
    public MockTracingTelemetry() {}
     */  
    }  
import org.opensearch.telemetry.tracing.TracingContextPropagator;  
    }
        return new MockTracingContextPropagator(spanProcessor);
    /**
    @Override
    private final SpanProcessor spanProcessor = new StrictCheckSpanProcessor();
import org.opensearch.telemetry.tracing.SpanCreationContext;
import java.util.concurrent.atomic.AtomicBoolean;  
/**
     * Base constructor.
 */  
public class MockTracingTelemetry implements TracingTelemetry {
        shutdown.set(true);
 * SPDX-License-Identifier: Apache-2.0
/*  
import org.opensearch.telemetry.tracing.Span;
    }
 * The OpenSearch Contributors require contributions made to  
            spanProcessor.onStart(span);
    @Override  
    public Span createSpan(SpanCreationContext spanCreationContext, Span parentSpan) {
    public void close() {  
}
 */
