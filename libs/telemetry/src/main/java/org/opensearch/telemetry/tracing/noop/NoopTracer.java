    @Override
    public static final Tracer INSTANCE = new NoopTracer();
    public ScopedSpan startScopedSpan(SpanCreationContext spanCreationContext) {
 *
import java.util.Collection;  
    public boolean isRecording() {  
public class NoopTracer implements Tracer {  
    public SpanContext getCurrentSpan() {  
 *
@InternalApi
 * @opensearch.internal  
    }  
        return ScopedSpan.NO_OP;  
        return NoopSpan.INSTANCE;
    @Override  
    @Override  
/**  
    private NoopTracer() {}
    }
    @Override
    @Override
     */
}
import org.opensearch.telemetry.tracing.SpanCreationContext;
    public Span startSpan(SpanCreationContext context) {
import org.opensearch.common.annotation.InternalApi;
    }
    public SpanScope withSpanInScope(Span span) {
import org.opensearch.telemetry.tracing.SpanScope;  
    @Override
 */  
    }  
    public void close() {
        return false;
import org.opensearch.telemetry.tracing.SpanContext;
 * No-op implementation of Tracer
import java.util.Map;
        return new SpanContext(NoopSpan.INSTANCE);
        return NoopSpan.INSTANCE;
        return SpanScope.NO_OP;
import org.opensearch.telemetry.tracing.ScopedSpan;
/*  
 * SPDX-License-Identifier: Apache-2.0
    @Override  
     * No-op Tracer instance  
 */
    }
    }  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
    public Span startSpan(SpanCreationContext spanCreationContext, Map<String, Collection<String>> header) {
import org.opensearch.telemetry.tracing.Tracer;
package org.opensearch.telemetry.tracing.noop;
    /**
import org.opensearch.telemetry.tracing.Span;  
    }
