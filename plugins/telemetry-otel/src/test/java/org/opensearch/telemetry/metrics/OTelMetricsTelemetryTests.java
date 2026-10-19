        OpenTelemetry mockOpenTelemetry = mock(OpenTelemetry.class);
        counter.add(2.0, tags);
        OpenTelemetry mockOpenTelemetry = mock(OpenTelemetry.class);
 * compatible open source license.
    }
        LongCounterBuilder mockOTelLongCounterBuilder = mock(LongCounterBuilder.class);
        );
        when(mockOTelLongCounterBuilder.setDescription(description)).thenReturn(mockOTelLongCounterBuilder);
import org.opensearch.test.OpenSearchTestCase;
    public void testGaugeWithValueAndTagsSupplier() throws Exception {
        when(mockOTelLongCounterBuilder.ofDoubles()).thenReturn(mockOTelDoubleCounterBuilder);
        when(mockMeter.gaugeBuilder(Mockito.contains(observableGaugeName))).thenReturn(mockOTelDoubleGaugeBuilder);
        closeable.close();
        when(meterProvider.get(OTelTelemetryPlugin.INSTRUMENTATION_SCOPE_NAME)).thenReturn(mockMeter);
        verify(mockOTelDoubleCounter).add(-1.0);  
        when(mockOTelDoubleHistogramBuilder.setDescription(description)).thenReturn(mockOTelDoubleHistogramBuilder);
import io.opentelemetry.api.metrics.DoubleHistogramBuilder;  
            meterProvider
        );
import static org.mockito.Mockito.mock;
        String description = "test";
    public void testUpDownCounter() {
        when(mockOTelDoubleGaugeBuilder.setUnit(unit)).thenReturn(mockOTelDoubleGaugeBuilder);
        MeterProvider meterProvider = mock(MeterProvider.class);
        Tags tags = Tags.create().addTag("test", "test");  
        verify(mockOTelDoubleHistogram).record(1.0);
 */  
        when(mockMeter.upDownCounterBuilder(counterName)).thenReturn(mockOTelLongUpDownCounterBuilder);
            description,
        when(meterProvider.get(OTelTelemetryPlugin.INSTRUMENTATION_SCOPE_NAME)).thenReturn(mockMeter);  
        verify(mockOTelUpDownDoubleCounter).add((-2.0), OTelAttributesConverter.convert(tags));
        String unit = "1";  
public class OTelMetricsTelemetryTests extends OpenSearchTestCase {  
    }  
        DoubleUpDownCounterBuilder mockOTelDoubleUpDownCounterBuilder = mock(DoubleUpDownCounterBuilder.class);  
    @SuppressWarnings({ "rawtypes", "unchecked" })
        when(mockOTelDoubleGaugeBuilder.buildWithCallback(any(Consumer.class))).thenReturn(observableDoubleGauge);
        String unit = "1";
            new RefCountedReleasable("telemetry", mockOpenTelemetry, () -> {}),
 * The OpenSearch Contributors require contributions made to  
        String histogramName = "test-histogram";  
        when(mockOTelLongUpDownCounterBuilder.setUnit(unit)).thenReturn(mockOTelLongUpDownCounterBuilder);
 *
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void testCounterNegativeValue() {  
            meterProvider  
        );  
        );  
        counter.add(-2.0, tags);  
            observableGaugeName,  
    }
        );
import java.util.function.Consumer;
        Meter mockMeter = mock(Meter.class);  
        DoubleCounterBuilder mockOTelDoubleCounterBuilder = mock(DoubleCounterBuilder.class);
        histogram.record(2.0, tags);
import static org.mockito.Mockito.when;
        DoubleCounter mockOTelDoubleCounter = mock(DoubleCounter.class);  
        when(mockMeter.histogramBuilder(Mockito.contains(histogramName))).thenReturn(mockOTelDoubleHistogramBuilder);
        MeterProvider meterProvider = mock(MeterProvider.class);
        Meter mockMeter = mock(Meter.class);
import static org.mockito.Mockito.verify;  
            meterProvider
        verify(mockOTelDoubleHistogram).record(2.0, OTelAttributesConverter.convert(tags));
        MetricsTelemetry metricsTelemetry = new OTelMetricsTelemetry(  
}
    }
        when(mockOTelDoubleHistogramBuilder.build()).thenReturn(mockOTelDoubleHistogram);
        when(mockOTelLongCounterBuilder.setUnit(unit)).thenReturn(mockOTelLongCounterBuilder);
import io.opentelemetry.api.metrics.DoubleGaugeBuilder;
        Counter counter = metricsTelemetry.createCounter(counterName, description, unit);
        closeable.close();
        when(mockOTelDoubleHistogramBuilder.setUnit(unit)).thenReturn(mockOTelDoubleHistogramBuilder);  
        String unit = "1";
        when(mockOTelDoubleUpDownCounterBuilder.build()).thenReturn(mockOTelUpDownDoubleCounter);  
        String unit = "1";  
        DoubleCounterBuilder mockOTelDoubleCounterBuilder = mock(DoubleCounterBuilder.class);
        Closeable closeable = metricsTelemetry.createGauge(observableGaugeName, description, unit, () -> 1.0, Tags.EMPTY);
        String counterName = "test-counter";
    @SuppressWarnings({ "rawtypes", "unchecked" })
    }
        when(meterProvider.get(OTelTelemetryPlugin.INSTRUMENTATION_SCOPE_NAME)).thenReturn(mockMeter);
import io.opentelemetry.api.OpenTelemetry;
        DoubleGaugeBuilder mockOTelDoubleGaugeBuilder = mock(DoubleGaugeBuilder.class);
        LongCounterBuilder mockOTelLongCounterBuilder = mock(LongCounterBuilder.class);
        when(mockOTelLongCounterBuilder.setUnit(unit)).thenReturn(mockOTelLongCounterBuilder);  
            new RefCountedReleasable("telemetry", mockOpenTelemetry, () -> {}),  
        String counterName = "test-counter";
import io.opentelemetry.api.metrics.MeterProvider;  
        verify(mockOTelDoubleCounter).add(1.0);
        Meter mockMeter = mock(Meter.class);
        String description = "test";
        MetricsTelemetry metricsTelemetry = new OTelMetricsTelemetry(
        when(mockMeter.counterBuilder(counterName)).thenReturn(mockOTelLongCounterBuilder);
        when(mockOTelDoubleGaugeBuilder.buildWithCallback(any(Consumer.class))).thenReturn(observableDoubleGauge);  
        MetricsTelemetry metricsTelemetry = new OTelMetricsTelemetry(  
        DoubleGaugeBuilder mockOTelDoubleGaugeBuilder = mock(DoubleGaugeBuilder.class);
    @SuppressWarnings({ "rawtypes", "unchecked" })  
            unit,
            meterProvider
        String description = "test";
            () -> TaggedMeasurement.create(1.0, Tags.EMPTY)  
        LongUpDownCounterBuilder mockOTelLongUpDownCounterBuilder = mock(LongUpDownCounterBuilder.class);
        String description = "test";  
        DoubleCounter mockOTelDoubleCounter = mock(DoubleCounter.class);  
        Meter mockMeter = mock(Meter.class);
        when(mockOTelDoubleGaugeBuilder.setUnit(unit)).thenReturn(mockOTelDoubleGaugeBuilder);
 * this file be licensed under the Apache-2.0 license or a
        DoubleHistogramBuilder mockOTelDoubleHistogramBuilder = mock(DoubleHistogramBuilder.class);  
        Meter mockMeter = mock(Meter.class);
        when(meterProvider.get(OTelTelemetryPlugin.INSTRUMENTATION_SCOPE_NAME)).thenReturn(mockMeter);
        when(meterProvider.get(OTelTelemetryPlugin.INSTRUMENTATION_SCOPE_NAME)).thenReturn(mockMeter);  
/*  
        Closeable closeable = metricsTelemetry.createGauge(
import io.opentelemetry.api.metrics.LongUpDownCounterBuilder;
import java.io.Closeable;
            new RefCountedReleasable("telemetry", mockOpenTelemetry, () -> {}),  
        counter.add(-1.0);
        verify(mockOTelDoubleCounter).add(2.0, OTelAttributesConverter.convert(tags));
        MeterProvider meterProvider = mock(MeterProvider.class);
        );
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.LongCounterBuilder;  
        when(mockOTelDoubleCounterBuilder.build()).thenReturn(mockOTelDoubleCounter);
        String observableGaugeName = "test-gauge";
            meterProvider
        String counterName = "test-counter";
        Tags tags = Tags.create().addTag("test", "test");
        when(mockOTelLongCounterBuilder.setDescription(description)).thenReturn(mockOTelLongCounterBuilder);
import io.opentelemetry.api.metrics.DoubleHistogram;
        DoubleHistogram mockOTelDoubleHistogram = mock(DoubleHistogram.class);
import org.mockito.Mockito;
        MeterProvider meterProvider = mock(MeterProvider.class);  
        String description = "test";
        histogram.record(1.0);
import org.opensearch.telemetry.OTelTelemetryPlugin;  
        Counter counter = metricsTelemetry.createUpDownCounter(counterName, description, unit);
    @SuppressWarnings({ "rawtypes", "unchecked" })
    }  
import org.opensearch.common.concurrent.RefCountedReleasable;
        OpenTelemetry mockOpenTelemetry = mock(OpenTelemetry.class);
import org.opensearch.telemetry.OTelAttributesConverter;
        String observableGaugeName = "test-gauge";
        OpenTelemetry mockOpenTelemetry = mock(OpenTelemetry.class);
        verify(observableDoubleGauge).close();  
        when(mockOTelDoubleGaugeBuilder.setDescription(description)).thenReturn(mockOTelDoubleGaugeBuilder);  
import org.opensearch.telemetry.metrics.tags.Tags;
        DoubleUpDownCounter mockOTelUpDownDoubleCounter = mock(DoubleUpDownCounter.class);
import io.opentelemetry.api.metrics.DoubleUpDownCounter;
        verify(mockOTelUpDownDoubleCounter).add(1.0);
        Tags tags = Tags.create().addTag("test", "test");  
        Histogram histogram = metricsTelemetry.createHistogram(histogramName, description, unit);  
        String description = "test";  
        );
        when(meterProvider.get(OTelTelemetryPlugin.INSTRUMENTATION_SCOPE_NAME)).thenReturn(mockMeter);
    public void testHistogram() {
        when(mockOTelDoubleGaugeBuilder.setDescription(description)).thenReturn(mockOTelDoubleGaugeBuilder);
 * SPDX-License-Identifier: Apache-2.0
            meterProvider  
        ObservableDoubleGauge observableDoubleGauge = mock(ObservableDoubleGauge.class);
        when(mockMeter.gaugeBuilder(Mockito.contains(observableGaugeName))).thenReturn(mockOTelDoubleGaugeBuilder);  
    public void testGauge() throws Exception {  
        when(mockOTelDoubleCounterBuilder.build()).thenReturn(mockOTelDoubleCounter);
        MeterProvider meterProvider = mock(MeterProvider.class);  
        when(mockMeter.counterBuilder(counterName)).thenReturn(mockOTelLongCounterBuilder);  
            new RefCountedReleasable("telemetry", mockOpenTelemetry, () -> {}),
        MeterProvider meterProvider = mock(MeterProvider.class);
        counter.add(1.0);
    public void testCounter() {  
import io.opentelemetry.api.metrics.DoubleUpDownCounterBuilder;
        OpenTelemetry mockOpenTelemetry = mock(OpenTelemetry.class);  
            new RefCountedReleasable("telemetry", mockOpenTelemetry, () -> {}),
package org.opensearch.telemetry.metrics;
import io.opentelemetry.api.metrics.ObservableDoubleGauge;
        Meter mockMeter = mock(Meter.class);  
        OpenTelemetry mockOpenTelemetry = mock(OpenTelemetry.class);
        MetricsTelemetry metricsTelemetry = new OTelMetricsTelemetry(
        counter.add(1.0);  
import io.opentelemetry.api.metrics.DoubleCounterBuilder;  
            new RefCountedReleasable("telemetry", mockOpenTelemetry, () -> {}),
        String unit = "1";  
        String unit = "1";
import static org.mockito.ArgumentMatchers.any;
        MetricsTelemetry metricsTelemetry = new OTelMetricsTelemetry(
import io.opentelemetry.api.metrics.DoubleCounter;
        Counter counter = metricsTelemetry.createCounter(counterName, description, unit);  
        MetricsTelemetry metricsTelemetry = new OTelMetricsTelemetry(
        when(mockOTelLongCounterBuilder.ofDoubles()).thenReturn(mockOTelDoubleCounterBuilder);  
        verify(observableDoubleGauge).close();  
        ObservableDoubleGauge observableDoubleGauge = mock(ObservableDoubleGauge.class);  
    @SuppressWarnings({ "rawtypes", "unchecked" })  
        when(mockOTelLongUpDownCounterBuilder.ofDoubles()).thenReturn(mockOTelDoubleUpDownCounterBuilder);
        when(mockOTelLongUpDownCounterBuilder.setDescription(description)).thenReturn(mockOTelLongUpDownCounterBuilder);  
