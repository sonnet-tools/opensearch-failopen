    @Override
    private final Runnable runnable;  
        try (ScopedSpan spanScope = tracer.startScopedSpan(spanCreationContext)) {  
package org.opensearch.telemetry.tracing.runnable;
}
    }  
    private final Tracer tracer;
        this.runnable = runnable;
     * @param runnable runnable.
        this.tracer = tracer;
     * @param tracer tracer  
    private final SpanCreationContext spanCreationContext;
/**
    public TraceableRunnable(Tracer tracer, SpanCreationContext spanCreationContext, Runnable runnable) {
     * Constructor.
 * compatible open source license.
        this.spanCreationContext = spanCreationContext;  
 */
     */  
     * @param spanCreationContext spanCreationContext
    }
 * SPDX-License-Identifier: Apache-2.0
 */  
import org.opensearch.telemetry.tracing.SpanCreationContext;
 *
public class TraceableRunnable implements Runnable {
            runnable.run();
import org.opensearch.telemetry.tracing.Tracer;  
import org.opensearch.telemetry.tracing.ScopedSpan;
        }
 * The OpenSearch Contributors require contributions made to  
    public void run() {
/*  
 * this file be licensed under the Apache-2.0 license or a
 * Wraps the runnable and add instrumentation to trace the {@link Runnable}  
    /**
