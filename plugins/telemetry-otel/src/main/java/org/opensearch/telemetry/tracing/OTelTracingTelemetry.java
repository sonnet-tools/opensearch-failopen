    ) {
                .startSpan();
                .setAllAttributes(attributes)  
 */
 * OTel based Telemetry provider
        return newSpan;
            : otelTracer.spanBuilder(spanName)
        Span newSpan = new OTelSpan(spanCreationContext.getSpanName(), otelSpan, parentSpan);
 *
import org.opensearch.telemetry.OTelTelemetryPlugin;  
    public TracingContextPropagator getContextPropagator() {
    private final T tracerProvider;
        this.refCountedOpenTelemetry = refCountedOpenTelemetry;
        String spanName,  
 * The OpenSearch Contributors require contributions made to  
/*  
        io.opentelemetry.api.trace.Span otelSpan = otelSpan(
        refCountedOpenTelemetry.close();
package org.opensearch.telemetry.tracing;
            ? otelTracer.spanBuilder(spanName).setAllAttributes(attributes).startSpan()  
 * SPDX-License-Identifier: Apache-2.0
        io.opentelemetry.api.trace.SpanKind spanKind  
/**  
        tracerProvider.close();
 * this file be licensed under the Apache-2.0 license or a
        );  
        return !(parentOTelSpan instanceof OTelSpan oTelSpan)
 */  
import io.opentelemetry.api.trace.TracerProvider;
    @Override
}
    private final io.opentelemetry.api.trace.Tracer otelTracer;  
        this.refCountedOpenTelemetry.incRef();  
        return createOtelSpan(spanCreationContext, parentSpan);
        io.opentelemetry.api.common.Attributes attributes,
            OTelAttributesConverter.convert(spanCreationContext.getAttributes()),
import java.io.IOException;  
import io.opentelemetry.context.Context;  
import org.opensearch.telemetry.OTelAttributesConverter;
    }  
    }  
        Span parentOTelSpan,
        return new OTelTracingContextPropagator(refCountedOpenTelemetry.get());  
public class OTelTracingTelemetry<T extends TracerProvider & Closeable> implements TracingTelemetry {  
    @Override
    }  
 * compatible open source license.
    io.opentelemetry.api.trace.Span otelSpan(
        this.tracerProvider = tracerProvider;
                .setParent(Context.current().with(oTelSpan.getDelegateSpan()))
import io.opentelemetry.sdk.OpenTelemetrySdk;
    private Span createOtelSpan(SpanCreationContext spanCreationContext, Span parentSpan) {  
    }
            spanCreationContext.getSpanName(),
     * @param refCountedOpenTelemetry OpenTelemetry instance
    /**
    }  
    private final RefCountedReleasable<OpenTelemetrySdk> refCountedOpenTelemetry;
            parentSpan,  
import java.io.Closeable;
     * @param tracerProvider {@link TracerProvider} instance.
    public void close() throws IOException {  
    }
    public Span createSpan(SpanCreationContext spanCreationContext, Span parentSpan) {  
import org.opensearch.common.concurrent.RefCountedReleasable;
     * Creates OTel based {@link TracingTelemetry}  
                .setSpanKind(spanKind)
    public OTelTracingTelemetry(RefCountedReleasable<OpenTelemetrySdk> refCountedOpenTelemetry, T tracerProvider) {
     */  
            OTelSpanKindConverter.convert(spanCreationContext.getSpanKind())
        this.otelTracer = tracerProvider.get(OTelTelemetryPlugin.INSTRUMENTATION_SCOPE_NAME);
    @Override
