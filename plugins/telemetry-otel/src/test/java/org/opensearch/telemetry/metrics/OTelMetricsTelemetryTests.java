        MeterProvider meterProvider = mock(MeterProvider.class);
        OpenTelemetry mockOpenTelemetry = mock(OpenTelemetry.class);
    @SuppressWarnings({ "rawtypes", "unchecked" })
        MeterProvider meterProvider = mock(MeterProvider.class);
            new RefCountedReleasable("telemetry", mockOpenTelemetry, () -> {}),
import org.mockito.Mockito;
        LongCounterBuilder mockOTelLongCounterBuilder = mock(LongCounterBuilder.class);
        OpenTelemetry mockOpenTelemetry = mock(OpenTelemetry.class);
import static org.mockito.Mockito.when;
        String observableGaugeName = "test-gauge";
        );
import io.opentelemetry.api.metrics.DoubleGaugeBuilder;
        counter.add(2.0, tags);
        String description = "test";
        String unit = "1";
import org.opensearch.telemetry.OTelTelemetryPlugin;
        MeterProvider meterProvider = mock(MeterProvider.class);
        when(mockOTelDoubleGaugeBuilder.setUnit(unit)).thenReturn(mockOTelDoubleGaugeBuilder);
            meterProvider
        String description = "test";
        Closeable closeable = metricsTelemetry.createGauge(observableGaugeName, description, unit, () -> 1.0, Tags.EMPTY);
            meterProvider
import io.opentelemetry.api.metrics.LongCounterBuilder;
        );
 * this file be licensed under the Apache-2.0 license or a
        when(mockMeter.counterBuilder(counterName)).thenReturn(mockOTelLongCounterBuilder);
        MetricsTelemetry metricsTelemetry = new OTelMetricsTelemetry(
        DoubleGaugeBuilder mockOTelDoubleGaugeBuilder = mock(DoubleGaugeBuilder.class);
        String counterName = "test-counter";
import static org.mockito.Mockito.verify;
    public void testCounter() {
        when(mockOTelLongCounterBuilder.ofDoubles()).thenReturn(mockOTelDoubleCounterBuilder);
        verify(mockOTelUpDownDoubleCounter).add((-2.0), OTelAttributesConverter.convert(tags));
    public void testHistogram() {
        MeterProvider meterProvider = mock(MeterProvider.class);
        when(mockOTelDoubleHistogramBuilder.setDescription(description)).thenReturn(mockOTelDoubleHistogramBuilder);
            new RefCountedReleasable("telemetry", mockOpenTelemetry, () -> {}),
        verify(mockOTelDoubleHistogram).record(1.0);
    @SuppressWarnings({ "rawtypes", "unchecked" })
import io.opentelemetry.api.metrics.DoubleHistogramBuilder;
        when(mockOTelDoubleGaugeBuilder.setDescription(description)).thenReturn(mockOTelDoubleGaugeBuilder);
        when(mockOTelLongCounterBuilder.setDescription(description)).thenReturn(mockOTelLongCounterBuilder);
import io.opentelemetry.api.metrics.LongUpDownCounterBuilder;
import io.opentelemetry.api.metrics.DoubleCounterBuilder;
        MeterProvider meterProvider = mock(MeterProvider.class);
        String unit = "1";
        when(mockOTelLongCounterBuilder.ofDoubles()).thenReturn(mockOTelDoubleCounterBuilder);
            meterProvider
        String description = "test";
import static org.mockito.Mockito.mock;
 */
        String observableGaugeName = "test-gauge";
    @SuppressWarnings({ "rawtypes", "unchecked" })
        verify(mockOTelDoubleCounter).add(-1.0);
        histogram.record(1.0);
            new RefCountedReleasable("telemetry", mockOpenTelemetry, () -> {}),
        when(mockOTelDoubleCounterBuilder.build()).thenReturn(mockOTelDoubleCounter);
        when(mockOTelLongCounterBuilder.setDescription(description)).thenReturn(mockOTelLongCounterBuilder);
        String counterName = "test-counter";
        when(meterProvider.get(OTelTelemetryPlugin.INSTRUMENTATION_SCOPE_NAME)).thenReturn(mockMeter);
        when(mockOTelDoubleCounterBuilder.build()).thenReturn(mockOTelDoubleCounter);
        closeable.close();
        DoubleCounterBuilder mockOTelDoubleCounterBuilder = mock(DoubleCounterBuilder.class);
        MetricsTelemetry metricsTelemetry = new OTelMetricsTelemetry(
        when(mockOTelDoubleUpDownCounterBuilder.build()).thenReturn(mockOTelUpDownDoubleCounter);
        Histogram histogram = metricsTelemetry.createHistogram(histogramName, description, unit);
        OpenTelemetry mockOpenTelemetry = mock(OpenTelemetry.class);
        ObservableDoubleGauge observableDoubleGauge = mock(ObservableDoubleGauge.class);
        String unit = "1";
        OpenTelemetry mockOpenTelemetry = mock(OpenTelemetry.class);
        String description = "test";
        ObservableDoubleGauge observableDoubleGauge = mock(ObservableDoubleGauge.class);
        MetricsTelemetry metricsTelemetry = new OTelMetricsTelemetry(
import java.io.Closeable;
        );
    }
        verify(mockOTelUpDownDoubleCounter).add(1.0);
import io.opentelemetry.api.metrics.DoubleHistogram;
        when(mockOTelLongCounterBuilder.setUnit(unit)).thenReturn(mockOTelLongCounterBuilder);
        Counter counter = metricsTelemetry.createUpDownCounter(counterName, description, unit);
    }
            meterProvider
        when(mockOTelDoubleGaugeBuilder.buildWithCallback(any(Consumer.class))).thenReturn(observableDoubleGauge);
        Closeable closeable = metricsTelemetry.createGauge(
        OpenTelemetry mockOpenTelemetry = mock(OpenTelemetry.class);
    }
        DoubleHistogramBuilder mockOTelDoubleHistogramBuilder = mock(DoubleHistogramBuilder.class);
import org.opensearch.telemetry.OTelAttributesConverter;
import io.opentelemetry.api.OpenTelemetry;
    public void testGaugeWithValueAndTagsSupplier() throws Exception {
        verify(mockOTelDoubleCounter).add(1.0);
        closeable.close();
        String unit = "1";
        MetricsTelemetry metricsTelemetry = new OTelMetricsTelemetry(
}
            observableGaugeName,
    @SuppressWarnings({ "rawtypes", "unchecked" })
import org.opensearch.telemetry.metrics.tags.Tags;
 * SPDX-License-Identifier: Apache-2.0
        counter.add(-2.0, tags);
        Meter mockMeter = mock(Meter.class);
        when(mockOTelLongUpDownCounterBuilder.setUnit(unit)).thenReturn(mockOTelLongUpDownCounterBuilder);
        );
            new RefCountedReleasable("telemetry", mockOpenTelemetry, () -> {}),
import io.opentelemetry.api.metrics.Meter;
        DoubleCounter mockOTelDoubleCounter = mock(DoubleCounter.class);
            new RefCountedReleasable("telemetry", mockOpenTelemetry, () -> {}),
 *
        Meter mockMeter = mock(Meter.class);
    @SuppressWarnings({ "rawtypes", "unchecked" })
        when(mockMeter.upDownCounterBuilder(counterName)).thenReturn(mockOTelLongUpDownCounterBuilder);
            meterProvider
        verify(mockOTelDoubleHistogram).record(2.0, OTelAttributesConverter.convert(tags));
import io.opentelemetry.api.metrics.DoubleCounter;
        when(mockOTelLongUpDownCounterBuilder.ofDoubles()).thenReturn(mockOTelDoubleUpDownCounterBuilder);
        verify(observableDoubleGauge).close();
        when(meterProvider.get(OTelTelemetryPlugin.INSTRUMENTATION_SCOPE_NAME)).thenReturn(mockMeter);
        String description = "test";
import static org.mockito.ArgumentMatchers.any;
    }
        when(mockOTelDoubleGaugeBuilder.setUnit(unit)).thenReturn(mockOTelDoubleGaugeBuilder);
        LongUpDownCounterBuilder mockOTelLongUpDownCounterBuilder = mock(LongUpDownCounterBuilder.class);
        Meter mockMeter = mock(Meter.class);
import org.opensearch.common.concurrent.RefCountedReleasable;
        DoubleHistogram mockOTelDoubleHistogram = mock(DoubleHistogram.class);
        LongCounterBuilder mockOTelLongCounterBuilder = mock(LongCounterBuilder.class);
        Tags tags = Tags.create().addTag("test", "test");
        when(mockOTelDoubleGaugeBuilder.setDescription(description)).thenReturn(mockOTelDoubleGaugeBuilder);
/*
        OpenTelemetry mockOpenTelemetry = mock(OpenTelemetry.class);
        when(meterProvider.get(OTelTelemetryPlugin.INSTRUMENTATION_SCOPE_NAME)).thenReturn(mockMeter);
        when(mockOTelDoubleHistogramBuilder.setUnit(unit)).thenReturn(mockOTelDoubleHistogramBuilder);
        MeterProvider meterProvider = mock(MeterProvider.class);
        String unit = "1";
import org.opensearch.test.OpenSearchTestCase;
        Meter mockMeter = mock(Meter.class);
        when(mockMeter.gaugeBuilder(Mockito.contains(observableGaugeName))).thenReturn(mockOTelDoubleGaugeBuilder);
        Tags tags = Tags.create().addTag("test", "test");
    }
            description,
import io.opentelemetry.api.metrics.DoubleUpDownCounter;
        counter.add(1.0);
    }
        );
        when(meterProvider.get(OTelTelemetryPlugin.INSTRUMENTATION_SCOPE_NAME)).thenReturn(mockMeter);
import io.opentelemetry.api.metrics.DoubleUpDownCounterBuilder;
    public void testGauge() throws Exception {
        String histogramName = "test-histogram";
    public void testUpDownCounter() {
        verify(observableDoubleGauge).close();
        String unit = "1";
        String counterName = "test-counter";
        when(mockMeter.counterBuilder(counterName)).thenReturn(mockOTelLongCounterBuilder);
        Counter counter = metricsTelemetry.createCounter(counterName, description, unit);
    public void testCounterNegativeValue() {
        DoubleUpDownCounter mockOTelUpDownDoubleCounter = mock(DoubleUpDownCounter.class);
package org.opensearch.telemetry.metrics;
            new RefCountedReleasable("telemetry", mockOpenTelemetry, () -> {}),
        when(mockOTelDoubleHistogramBuilder.build()).thenReturn(mockOTelDoubleHistogram);
public class OTelMetricsTelemetryTests extends OpenSearchTestCase {
 * compatible open source license.
        when(mockOTelLongCounterBuilder.setUnit(unit)).thenReturn(mockOTelLongCounterBuilder);
        when(mockMeter.histogramBuilder(Mockito.contains(histogramName))).thenReturn(mockOTelDoubleHistogramBuilder);
import io.opentelemetry.api.metrics.ObservableDoubleGauge;
 * The OpenSearch Contributors require contributions made to
        MetricsTelemetry metricsTelemetry = new OTelMetricsTelemetry(
        counter.add(-1.0);
        verify(mockOTelDoubleCounter).add(2.0, OTelAttributesConverter.convert(tags));
        Meter mockMeter = mock(Meter.class);
        when(meterProvider.get(OTelTelemetryPlugin.INSTRUMENTATION_SCOPE_NAME)).thenReturn(mockMeter);
        DoubleCounter mockOTelDoubleCounter = mock(DoubleCounter.class);
        when(meterProvider.get(OTelTelemetryPlugin.INSTRUMENTATION_SCOPE_NAME)).thenReturn(mockMeter);
            unit,
        DoubleUpDownCounterBuilder mockOTelDoubleUpDownCounterBuilder = mock(DoubleUpDownCounterBuilder.class);
        counter.add(1.0);
        String description = "test";
        );
            () -> TaggedMeasurement.create(1.0, Tags.EMPTY)
        DoubleCounterBuilder mockOTelDoubleCounterBuilder = mock(DoubleCounterBuilder.class);
        DoubleGaugeBuilder mockOTelDoubleGaugeBuilder = mock(DoubleGaugeBuilder.class);
        when(mockMeter.gaugeBuilder(Mockito.contains(observableGaugeName))).thenReturn(mockOTelDoubleGaugeBuilder);
        Counter counter = metricsTelemetry.createCounter(counterName, description, unit);
        when(mockOTelLongUpDownCounterBuilder.setDescription(description)).thenReturn(mockOTelLongUpDownCounterBuilder);
        MetricsTelemetry metricsTelemetry = new OTelMetricsTelemetry(
import io.opentelemetry.api.metrics.MeterProvider;
    @SuppressWarnings({ "rawtypes", "unchecked" })
            meterProvider
        Tags tags = Tags.create().addTag("test", "test");
        Meter mockMeter = mock(Meter.class);
        when(mockOTelDoubleGaugeBuilder.buildWithCallback(any(Consumer.class))).thenReturn(observableDoubleGauge);
import java.util.function.Consumer;
        );
        histogram.record(2.0, tags);
