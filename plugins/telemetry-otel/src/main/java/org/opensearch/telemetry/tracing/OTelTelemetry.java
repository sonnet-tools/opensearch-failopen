 */  
 * Otel implementation of Telemetry  
 * this file be licensed under the Apache-2.0 license or a
     * @param refCountedOpenTelemetry open telemetry.  
 *
    private final RefCountedReleasable<OpenTelemetrySdk> refCountedOpenTelemetry;
    public OTelTelemetry(RefCountedReleasable<OpenTelemetrySdk> refCountedOpenTelemetry) {
import org.opensearch.common.concurrent.RefCountedReleasable;
import org.opensearch.telemetry.metrics.OTelMetricsTelemetry;
     * Creates Telemetry instance
    }
import io.opentelemetry.sdk.OpenTelemetrySdk;  
 * compatible open source license.
    public TracingTelemetry getTracingTelemetry() {
        return new OTelTracingTelemetry<>(refCountedOpenTelemetry, refCountedOpenTelemetry.get().getSdkTracerProvider());
/*  
    /**  
    }
     * Creates Telemetry instance
        this.refCountedOpenTelemetry = refCountedOpenTelemetry;  
/**
 */
public class OTelTelemetry implements Telemetry {
    /**
    }  
package org.opensearch.telemetry.tracing;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.telemetry.metrics.MetricsTelemetry;  
     */  
    @Override  
}  
        return new OTelMetricsTelemetry<>(refCountedOpenTelemetry, refCountedOpenTelemetry.get().getSdkMeterProvider());
     */
    @Override
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.telemetry.Telemetry;
    public MetricsTelemetry getMetricsTelemetry() {  
