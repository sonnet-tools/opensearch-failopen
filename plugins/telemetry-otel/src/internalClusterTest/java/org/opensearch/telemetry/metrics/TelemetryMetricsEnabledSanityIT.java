            .collect(Collectors.toList())
public class TelemetryMetricsEnabledSanityIT extends OpenSearchIntegTestCase {
    @Override
        MetricsRegistry metricsRegistry = internalCluster().getInstance(MetricsRegistry.class);
        Supplier<TaggedMeasurement> valueProvider = () -> {
            .get(0)
        });
        histogram.record(3.0);
    public void testCounter() throws Exception {
        return Settings.builder()
            .filter(a -> a.getName().equals("test-counter"))
        InMemorySingletonMetricsExporter.INSTANCE.reset();
            .put(super.nodeSettings(nodeOrdinal))
    private static Map<AttributeKey<?>, Object> getMetricAttributes(InMemorySingletonMetricsExporter exporter, String metricName) {
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, minNumDataNodes = 1)
            .getDoubleSumData()
    }
        assertBusy(() -> {
    protected boolean addMockTelemetryPlugin() {
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        String metricName = "test-gauge-" + randomAlphaOfLength(8);
        double value = ((DoublePointData) ((ArrayList) exporter.getFinishedMetricItems()
        return Arrays.asList(IntegrationTestOTelTelemetryPlugin.class);
        // Sleep for about 2s to wait for metrics to be published.
        Closeable gaugeCloseable = metricsRegistry.createGauge(metricName, "test", "ms", valueProvider, tags);
    }
        MetricsRegistry metricsRegistry = internalCluster().getInstance(MetricsRegistry.class);
        InMemorySingletonMetricsExporter.INSTANCE.reset();
 * compatible open source license.
        // assert it hasn't changed. assertBusy retries if an in-flight collection was still draining at close time.
    }
        return false;
    }
        InMemorySingletonMetricsExporter exporter = InMemorySingletonMetricsExporter.INSTANCE;
import java.util.Arrays;
    @After
        MetricsRegistry metricsRegistry = internalCluster().getInstance(MetricsRegistry.class);
        histogram.record(2.0);
    }
        histogram.record(1.0);
        for (MetricData metricData : dataPoints) {
            .filter(a -> a.getName().contains(metricName))
            .collect(Collectors.toList())
        // Sleep for about 2s to wait for metrics to be published.
        MetricsRegistry metricsRegistry = internalCluster().getInstance(MetricsRegistry.class);
        InMemorySingletonMetricsExporter exporter = InMemorySingletonMetricsExporter.INSTANCE;
        Histogram histogram = metricsRegistry.createHistogram("test-histogram", "test", "ms");
    }
        double totalValue = 0;
            .get(0)
        Counter counter = metricsRegistry.createCounter("test-counter", "test", "1");
        List<MetricData> dataPoints = exporter.getFinishedMetricItems()
 * The OpenSearch Contributors require contributions made to
        InMemorySingletonMetricsExporter exporter = InMemorySingletonMetricsExporter.INSTANCE;
            assertEquals("Gauge callback should no longer be invoked after close", val, testValue.get());
        Counter counter = metricsRegistry.createUpDownCounter("test-up-down-counter", "test", "1");
            .getPoints()).get(0)).getValue();
    }
        // assert it hasn't changed. assertBusy retries if an in-flight collection was still draining at close time.
            Thread.sleep(1500);
    }
            .build();
        gaugeCloseable.close();
        InMemorySingletonMetricsExporter exporter = InMemorySingletonMetricsExporter.INSTANCE;
            .stream()
}
import java.util.Collection;
import java.util.List;
        gaugeCloseable.close();
        }
        // Verify the callback is no longer invoked: snapshot the counter, wait longer than the publish interval, and
    public void testUpDownCounter() throws Exception {
        counter.add(1.0);
            .stream()
        return totalValue;
        assertEquals(1.0, histogramPointData.getMin(), 1.0);
    protected Settings nodeSettings(int nodeOrdinal) {
import org.opensearch.common.settings.Settings;
        InMemorySingletonMetricsExporter.INSTANCE.reset();
import java.io.Closeable;
    public void reset() {
        });
import io.opentelemetry.sdk.metrics.internal.data.ImmutableExponentialHistogramPointData;
        return attributes.asMap();
            totalValue = Math.max(totalValue, ((DoublePointData) metricData.getDoubleGaugeData().getPoints().toArray()[0]).getValue());
            Thread.sleep(1500);
        ImmutableExponentialHistogramPointData histogramPointData = ((ImmutableExponentialHistogramPointData) ((ArrayList) exporter
        assertBusy(() -> assertThat(getMaxObservableGaugeValue(exporter, metricName), greaterThanOrEqualTo(2.0)));
        Thread.sleep(2000);
        Supplier<Double> valueProvider = () -> { return Double.valueOf(testValue.incrementAndGet()); };
            return TaggedMeasurement.create(Double.valueOf(testValue.incrementAndGet()), tags);
        InMemorySingletonMetricsExporter.INSTANCE.reset();
        assertEquals(-1.0, value, 0.0);
        assertEquals(1.0, histogramPointData.getMax(), 3.0);
            .get(0)
            .collect(Collectors.toList())
        InMemorySingletonMetricsExporter exporter = InMemorySingletonMetricsExporter.INSTANCE;
        assertBusy(() -> assertThat(getMaxObservableGaugeValue(exporter, metricName), greaterThanOrEqualTo(2.0)));
        counter.add(-2.0);
        Tags tags = Tags.create().addTag("test", "integ-test");
    }
            int val = testValue.get();
        assertBusy(() -> {
import java.util.concurrent.atomic.AtomicInteger;
import io.opentelemetry.api.common.Attributes;
            int val = testValue.get();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 * this file be licensed under the Apache-2.0 license or a
            .stream()
            .getFinishedMetricItems()
        // Verify the callback is no longer invoked: snapshot the counter, wait longer than the publish interval, and
            .stream()
        };
                OTelTelemetrySettings.OTEL_METRICS_EXPORTER_CLASS_SETTING.getKey(),
    @Override
import java.util.ArrayList;
            .getDoubleSumData()
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.telemetry.metrics;
        double value = ((DoublePointData) ((ArrayList) exporter.getFinishedMetricItems()
        final AtomicInteger testValue = new AtomicInteger(0);
import java.util.function.Supplier;
    @Override
        final AtomicInteger testValue = new AtomicInteger(0);
        Map<AttributeKey<?>, Object> attributes = getMetricAttributes(exporter, metricName);
import java.util.stream.Collectors;
        Attributes attributes = dataPoints.get(0).getDoubleGaugeData().getPoints().stream().findAny().get().getAttributes();
    public void testGaugeWithValueAndTagSupplier() throws Exception {
            .put(TelemetrySettings.METRICS_FEATURE_ENABLED_SETTING.getKey(), true)
        assertEquals(1.0, histogramPointData.getSum(), 6.0);
    }
        Closeable gaugeCloseable = metricsRegistry.createGauge(metricName, "test", "ms", valueProvider);
        MetricsRegistry metricsRegistry = internalCluster().getInstance(MetricsRegistry.class);
            .filter(a -> a.getName().contains("test-histogram"))
        String metricName = "test-gauge-" + randomAlphaOfLength(8);
import io.opentelemetry.sdk.metrics.data.DoublePointData;
        InMemorySingletonMetricsExporter.INSTANCE.reset();
import org.junit.After;
        assertEquals("integ-test", attributes.get(AttributeKey.stringKey("test")));
import org.opensearch.plugins.Plugin;
import io.opentelemetry.api.common.AttributeKey;
        InMemorySingletonMetricsExporter.INSTANCE.reset();
            .filter(a -> a.getName().contains(metricName))
        assertEquals(1.0, value, 0.0);
import org.opensearch.telemetry.metrics.tags.Tags;
        List<MetricData> dataPoints = exporter.getFinishedMetricItems()
                "org.opensearch.telemetry.metrics.InMemorySingletonMetricsExporter"
import org.opensearch.common.unit.TimeValue;
        Tags tags = Tags.create().addTag("test", "integ-test");
            .put(TelemetrySettings.METRICS_PUBLISH_INTERVAL_SETTING.getKey(), TimeValue.timeValueSeconds(1))
            .collect(Collectors.toList());
            .getPoints()).get(0));
            )
 *
        Thread.sleep(2000);
import org.opensearch.telemetry.OTelTelemetrySettings;
    public void testGauge() throws Exception {
import io.opentelemetry.sdk.metrics.data.MetricData;
import org.opensearch.telemetry.IntegrationTestOTelTelemetryPlugin;
 */
import org.opensearch.test.OpenSearchIntegTestCase;
            .put(
    private static double getMaxObservableGaugeValue(InMemorySingletonMetricsExporter exporter, String metricName) {
        // Sleep for about 2s to wait for metrics to be published.
            .getPoints()).get(0)).getValue();
import org.opensearch.telemetry.TelemetrySettings;
import java.util.Map;
        Thread.sleep(2000);
/*
            .getExponentialHistogramData()
            .filter(a -> a.getName().equals("test-up-down-counter"))
            assertEquals("Gauge callback should no longer be invoked after close", val, testValue.get());
    }
            .collect(Collectors.toList());
    public void testHistogram() throws Exception {
        counter.add(1.0);
            .stream()
