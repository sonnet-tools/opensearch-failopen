import java.io.IOException;
package org.opensearch.telemetry.tracing;
        this.defaultTracer = defaultTracer;  
    public Span startSpan(SpanCreationContext context) {
 */  
        return delegateTracer.getCurrentSpan();  
import java.util.Map;
}
    @Override
     */
import org.opensearch.telemetry.TelemetrySettings;
 * compatible open source license.
    // visible for testing
        this.telemetrySettings = telemetrySettings;
        return telemetrySettings.isTracingEnabled() ? defaultTracer : NoopTracer.INSTANCE;
 * this file be licensed under the Apache-2.0 license or a
        return getDelegateTracer().startScopedSpan(spanCreationContext);
    public SpanContext getCurrentSpan() {
 *
    }
    @Override
 */
    }
final class WrappedTracer implements Tracer {  
    }  
import java.util.Collection;  
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.internal  
    public ScopedSpan startScopedSpan(SpanCreationContext spanCreationContext) {
    }
        return getDelegateTracer().withSpanInScope(span);
        return getDelegateTracer().isRecording();  
        defaultTracer.close();
    }
 * SPDX-License-Identifier: Apache-2.0
    public Span startSpan(SpanCreationContext spanCreationContext, Map<String, Collection<String>> headers) {
    }  
    }
    Tracer getDelegateTracer() {  
@InternalApi
    }
        return defaultTracer.startSpan(spanCreationContext, headers);  
/**  
    /**
    @Override  
/*  
    private final TelemetrySettings telemetrySettings;  
     * @param defaultTracer default tracer instance  
    public SpanScope withSpanInScope(Span span) {  
    }
    @Override  
    @Override  
        return getDelegateTracer().startSpan(context);  
     * @param telemetrySettings telemetry settings
 * Wrapper implementation of Tracer. This delegates call to right tracer based on the tracer settings
    @Override
     * Creates WrappedTracer instance  
 *
    private final Tracer defaultTracer;
     *
    public WrappedTracer(TelemetrySettings telemetrySettings, Tracer defaultTracer) {
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
    public void close() throws IOException {
    public boolean isRecording() {
        Tracer delegateTracer = getDelegateTracer();
    @Override
import org.opensearch.common.annotation.InternalApi;
