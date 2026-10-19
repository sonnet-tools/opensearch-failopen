        return SdkMeterProvider.builder()
        return OpenTelemetrySdk.builder()  
            .setResource(resource)
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import org.opensearch.telemetry.tracing.exporter.OTelSpanExporterFactory;
 */  
            .setResource(resource)  
     * @param contextPropagators context propagator instance
        MetricReader reader = PeriodicMetricReader.builder(OTelMetricsExporterFactory.create(settings))  
import io.opentelemetry.api.common.Attributes;
            .registerView(
        Sampler sampler,  
            .registerMetricReader(reader)
import io.opentelemetry.sdk.trace.export.SpanExporter;  
import org.opensearch.common.settings.Settings;
            () -> get(
import io.opentelemetry.sdk.metrics.InstrumentType;
            .build();
        return BatchSpanProcessor.builder(spanExporter)
    static SdkMeterProvider createSdkMetricProvider(Settings settings, Resource resource, MetricReader reader) {
    }
import java.util.concurrent.TimeUnit;  
     */
            )
     * Creates OpenTelemetry instance with provided configuration
                InstrumentSelector.builder().setType(InstrumentType.HISTOGRAM).build(),  
                ContextPropagators.create(W3CTraceContextPropagator.getInstance()),
import io.opentelemetry.sdk.resources.Resource;  
     * @param sampler sampler instance  
     * @param settings cluster settings
package org.opensearch.telemetry.tracing;
import io.opentelemetry.sdk.metrics.export.PeriodicMetricReader;
            .setMaxQueueSize(TRACER_EXPORTER_MAX_QUEUE_SIZE_SETTING.get(settings))
    }  
        return createSdkMetricProvider(settings, resource, reader);  
            .build();  
            .setMeterProvider(sdkMeterProvider)
     * @return OpenTelemetrySdk instance  
        Sampler sampler
    // The explicit view is registered in both modes so the setting, not the exporter's default aggregation, decides.  
/**
            .setInterval(TelemetrySettings.METRICS_PUBLISH_INTERVAL_SETTING.get(settings).getSeconds(), TimeUnit.SECONDS)
 * compatible open source license.
            .setMaxExportBatchSize(TRACER_EXPORTER_BATCH_SIZE_SETTING.get(settings))
     */
            .buildAndRegisterGlobal();
 *
import io.opentelemetry.sdk.metrics.InstrumentSelector;  
        ContextPropagators contextPropagators,  
    }
     * Creates OpenTelemetry instance with default configuration  
     * @param spanExporter span exporter instance
import org.opensearch.secure_sm.AccessController;
import static org.opensearch.telemetry.OTelTelemetrySettings.TRACER_EXPORTER_BATCH_SIZE_SETTING;  
    private static Resource createResource(Settings settings) {
public final class OTelResourceProvider {
    /**
    private static SdkTracerProvider createSdkTracerProvider(  
    public static OpenTelemetrySdk get(  
            .build();
                OTelSpanExporterFactory.create(settings),  
     * @param telemetrySettings telemetry settings
import static org.opensearch.telemetry.OTelTelemetrySettings.TRACER_EXPORTER_DELAY_SETTING;
/*  
import static org.opensearch.telemetry.OTelTelemetrySettings.OTEL_METRICS_HISTOGRAM_AGGREGATION_DEFAULT_SETTING;
        Resource resource = createResource(settings);  
        SpanExporter spanExporter,
    }
    public static OpenTelemetrySdk get(TelemetrySettings telemetrySettings, Settings settings) {
import io.opentelemetry.sdk.metrics.View;  
            .setTracerProvider(sdkTracerProvider)
import io.opentelemetry.api.trace.propagation.W3CTraceContextPropagator;  
    ) {
        return SdkTracerProvider.builder()  
    private OTelResourceProvider() {}  
    }
 * The OpenSearch Contributors require contributions made to  
 */  
import io.opentelemetry.semconv.ServiceAttributes;
        Settings settings,
import org.opensearch.telemetry.metrics.exporter.OTelMetricsExporterFactory;
                Sampler.parentBased(new RequestSampler(OTelSamplerFactory.create(telemetrySettings, settings)))
import static org.opensearch.telemetry.OTelTelemetrySettings.TRACER_EXPORTER_MAX_QUEUE_SIZE_SETTING;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
     * @param settings cluster settings  
        SpanExporter spanExporter,
     * @return OpenTelemetrySdk instance
                settings,
        return AccessController.doPrivileged(  
    private static BatchSpanProcessor spanProcessor(Settings settings, SpanExporter spanExporter) {
            )  
        Settings settings,
    /**
    ) {
import org.opensearch.telemetry.tracing.sampler.OTelSamplerFactory;  
 * SPDX-License-Identifier: Apache-2.0
import io.opentelemetry.sdk.trace.samplers.Sampler;
            .addSpanProcessor(spanProcessor(settings, spanExporter))
            .setSampler(sampler)  
}  
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.sdk.metrics.export.MetricReader;
        return Resource.create(Attributes.of(ServiceAttributes.SERVICE_NAME, OTEL_SERVICE_NAME_SETTING.get(settings)));
 * this file be licensed under the Apache-2.0 license or a
        SdkMeterProvider sdkMeterProvider = createSdkMetricProvider(settings, resource);
import static org.opensearch.telemetry.OTelTelemetrySettings.OTEL_SERVICE_NAME_SETTING;
    private static SdkMeterProvider createSdkMetricProvider(Settings settings, Resource resource) {
        SdkTracerProvider sdkTracerProvider = createSdkTracerProvider(settings, spanExporter, sampler, resource);
import io.opentelemetry.sdk.trace.SdkTracerProvider;
    }
 * This class encapsulates all OpenTelemetry related resources
import org.opensearch.telemetry.tracing.sampler.RequestSampler;
            .setScheduleDelay(TRACER_EXPORTER_DELAY_SETTING.get(settings).getSeconds(), TimeUnit.SECONDS)  
import org.opensearch.telemetry.TelemetrySettings;  
        );
    }
            .setPropagators(contextPropagators)  
                View.builder().setAggregation(OTEL_METRICS_HISTOGRAM_AGGREGATION_DEFAULT_SETTING.get(settings).toAggregation()).build()
        Resource resource
            .build();  
