import io.opentelemetry.api.metrics.MeterProvider;  
    public Closeable createGauge(String name, String description, String unit, Supplier<TaggedMeasurement> value) {  
    }
    @Override  
 * compatible open source license.
        refCountedOpenTelemetry.close();
        );
     * Creates the Otel Histogram. The bucketing/aggregation strategy is selected by the
            () -> otelMeter.gaugeBuilder(name)  
        meterProvider.close();  
import java.io.Closeable;
     * Creates OTel based {@link MetricsTelemetry}.
        return () -> doubleObservableGauge.close();
    }
    public Counter createUpDownCounter(String name, String description, String unit) {  
            () -> otelMeter.upDownCounterBuilder(name).setUnit(unit).setDescription(description).ofDoubles().build()
    public OTelMetricsTelemetry(RefCountedReleasable<OpenTelemetrySdk> openTelemetry, T meterProvider) {
import org.opensearch.telemetry.OTelAttributesConverter;  
        this.refCountedOpenTelemetry = openTelemetry;  
    private final T meterProvider;
    @Override
import io.opentelemetry.sdk.OpenTelemetrySdk;
import java.util.function.Supplier;  
 * The OpenSearch Contributors require contributions made to  
import io.opentelemetry.api.metrics.ObservableDoubleGauge;
/**
    private final Meter otelMeter;  
 * OTel implementation for {@link MetricsTelemetry}
        );
    public void close() throws IOException {
        DoubleCounter doubleCounter = AccessController.doPrivileged(
            () -> otelMeter.counterBuilder(name).setUnit(unit).setDescription(description).ofDoubles().build()  
}  
     * @param description any description about the metric.  
    @Override  
import java.io.IOException;
     * @param openTelemetry open telemetry.
    }  
    }
                .setUnit(unit)  
        this.refCountedOpenTelemetry.incRef();
 */  
    @Override
import io.opentelemetry.api.metrics.DoubleUpDownCounter;
        DoubleHistogram doubleHistogram = AccessController.doPrivileged(  
                .setUnit(unit)
     * @param unit        unit of the metric.
     * @param name        name of the histogram.
    /**
        this.otelMeter = meterProvider.get(OTelTelemetryPlugin.INSTRUMENTATION_SCOPE_NAME);  
 */  
/*  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
import io.opentelemetry.api.metrics.DoubleHistogram;  
        return new OTelCounter(doubleCounter);
        ObservableDoubleGauge doubleObservableGauge = AccessController.doPrivileged(
     * {@code base2_exponential_bucket_histogram}.
    }  
                .buildWithCallback(record -> record.record(valueProvider.get(), OTelAttributesConverter.convert(tags)))  
                .buildWithCallback(record -> record.record(value.get().getValue(), OTelAttributesConverter.convert(value.get().getTags())))
 *
        return new OTelHistogram(doubleHistogram);  
    @Override
    public Closeable createGauge(String name, String description, String unit, Supplier<Double> valueProvider, Tags tags) {
        ObservableDoubleGauge doubleObservableGauge = AccessController.doPrivileged(
     * @return histogram
import io.opentelemetry.api.metrics.DoubleCounter;
    public Histogram createHistogram(String name, String description, String unit) {
     */
                .setDescription(description)
public class OTelMetricsTelemetry<T extends MeterProvider & Closeable> implements MetricsTelemetry {
import org.opensearch.telemetry.OTelTelemetryPlugin;
import org.opensearch.secure_sm.AccessController;
    @Override
        DoubleUpDownCounter doubleUpDownCounter = AccessController.doPrivileged(
    private final RefCountedReleasable<OpenTelemetrySdk> refCountedOpenTelemetry;
import org.opensearch.telemetry.metrics.tags.Tags;
        return new OTelUpDownCounter(doubleUpDownCounter);
    }
     * @param meterProvider {@link MeterProvider} instance  
package org.opensearch.telemetry.metrics;
                .setDescription(description)
        return () -> doubleObservableGauge.close();
    /**  
        this.meterProvider = meterProvider;
            () -> otelMeter.gaugeBuilder(name)
    }
        );
     */  
import org.opensearch.common.concurrent.RefCountedReleasable;
    public Counter createCounter(String name, String description, String unit) {
        );  
            () -> otelMeter.histogramBuilder(name).setUnit(unit).setDescription(description).build()
        );  
     * {@code telemetry.otel.metrics.histogram.aggregation.default} setting and defaults to  
import io.opentelemetry.api.metrics.Meter;
