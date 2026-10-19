        InMemorySingletonMetricsExporter.INSTANCE.reset();  
    }
    public void testGaugeWithValueAndTagSupplier() throws Exception {  
import org.opensearch.common.unit.TimeValue;
import org.opensearch.telemetry.TelemetrySettings;  
    public void testHistogram() throws Exception {
        for (MetricData metricData : dataPoints) {  
        InMemorySingletonMetricsExporter exporter = InMemorySingletonMetricsExporter.INSTANCE;
        double value = ((DoublePointData) ((ArrayList) exporter.getFinishedMetricItems()
        return Settings.builder()
            .stream()  
        }
        assertBusy(() -> assertThat(getMaxObservableGaugeValue(exporter, metricName), greaterThanOrEqualTo(2.0)));  
        gaugeCloseable.close();
        return totalValue;  
        Attributes attributes = dataPoints.get(0).getDoubleGaugeData().getPoints().stream().findAny().get().getAttributes();
        counter.add(-2.0);
            .collect(Collectors.toList())
            .stream()  
}
import java.util.Map;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
    }  
            .stream()
    public void reset() {
            .getPoints()).get(0)).getValue();  
        histogram.record(1.0);
import org.opensearch.test.OpenSearchIntegTestCase;
import java.util.Collection;
    }
        assertEquals(1.0, histogramPointData.getMax(), 3.0);
        final AtomicInteger testValue = new AtomicInteger(0);
            .stream()
            .build();  
        });  
        counter.add(1.0);  
    }
            .get(0)
import io.opentelemetry.sdk.metrics.data.MetricData;  
        InMemorySingletonMetricsExporter exporter = InMemorySingletonMetricsExporter.INSTANCE;
            .get(0)  
            .getDoubleSumData()
        InMemorySingletonMetricsExporter.INSTANCE.reset();
            assertEquals("Gauge callback should no longer be invoked after close", val, testValue.get());
        Closeable gaugeCloseable = metricsRegistry.createGauge(metricName, "test", "ms", valueProvider);  
        // Verify the callback is no longer invoked: snapshot the counter, wait longer than the publish interval, and  
import org.opensearch.telemetry.OTelTelemetrySettings;
            )
            .getPoints()).get(0));
package org.opensearch.telemetry.metrics;
        Thread.sleep(2000);  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .collect(Collectors.toList())  
import org.opensearch.telemetry.IntegrationTestOTelTelemetryPlugin;
        counter.add(1.0);  
        Histogram histogram = metricsRegistry.createHistogram("test-histogram", "test", "ms");
    }
            .filter(a -> a.getName().equals("test-counter"))
import org.junit.After;  
        Map<AttributeKey<?>, Object> attributes = getMetricAttributes(exporter, metricName);
        List<MetricData> dataPoints = exporter.getFinishedMetricItems()
            .getExponentialHistogramData()
            Thread.sleep(1500);
import java.io.Closeable;
        InMemorySingletonMetricsExporter exporter = InMemorySingletonMetricsExporter.INSTANCE;
import java.util.function.Supplier;  
        double value = ((DoublePointData) ((ArrayList) exporter.getFinishedMetricItems()  
        MetricsRegistry metricsRegistry = internalCluster().getInstance(MetricsRegistry.class);
            Thread.sleep(1500);
import java.util.concurrent.atomic.AtomicInteger;
    protected Settings nodeSettings(int nodeOrdinal) {  
 * compatible open source license.
            int val = testValue.get();  
    private static double getMaxObservableGaugeValue(InMemorySingletonMetricsExporter exporter, String metricName) {  
            return TaggedMeasurement.create(Double.valueOf(testValue.incrementAndGet()), tags);
        gaugeCloseable.close();
        InMemorySingletonMetricsExporter exporter = InMemorySingletonMetricsExporter.INSTANCE;
            .put(TelemetrySettings.METRICS_PUBLISH_INTERVAL_SETTING.getKey(), TimeValue.timeValueSeconds(1))
        histogram.record(3.0);
import org.opensearch.plugins.Plugin;  
    @Override  
        assertBusy(() -> {
 *
            int val = testValue.get();  
        // Sleep for about 2s to wait for metrics to be published.
        assertEquals(1.0, histogramPointData.getSum(), 6.0);  
        InMemorySingletonMetricsExporter.INSTANCE.reset();
import org.opensearch.common.settings.Settings;
    public void testUpDownCounter() throws Exception {  
import io.opentelemetry.api.common.AttributeKey;  
        Tags tags = Tags.create().addTag("test", "integ-test");
        // Sleep for about 2s to wait for metrics to be published.
            .getFinishedMetricItems()
        MetricsRegistry metricsRegistry = internalCluster().getInstance(MetricsRegistry.class);
        assertEquals("integ-test", attributes.get(AttributeKey.stringKey("test")));  
        assertBusy(() -> {
            .filter(a -> a.getName().contains("test-histogram"))
        List<MetricData> dataPoints = exporter.getFinishedMetricItems()
import java.util.stream.Collectors;
    }
        String metricName = "test-gauge-" + randomAlphaOfLength(8);
        Supplier<TaggedMeasurement> valueProvider = () -> {  
        ImmutableExponentialHistogramPointData histogramPointData = ((ImmutableExponentialHistogramPointData) ((ArrayList) exporter
            .filter(a -> a.getName().equals("test-up-down-counter"))
        MetricsRegistry metricsRegistry = internalCluster().getInstance(MetricsRegistry.class);
            .collect(Collectors.toList());
    @Override
        Counter counter = metricsRegistry.createCounter("test-counter", "test", "1");
            .put(super.nodeSettings(nodeOrdinal))
        return false;
public class TelemetryMetricsEnabledSanityIT extends OpenSearchIntegTestCase {  
        return attributes.asMap();  
 * The OpenSearch Contributors require contributions made to  
        assertEquals(-1.0, value, 0.0);
        Closeable gaugeCloseable = metricsRegistry.createGauge(metricName, "test", "ms", valueProvider, tags);  
        assertEquals(1.0, value, 0.0);  
    @After  
            .getPoints()).get(0)).getValue();
            .filter(a -> a.getName().contains(metricName))  
        Thread.sleep(2000);
    }  
        double totalValue = 0;
                "org.opensearch.telemetry.metrics.InMemorySingletonMetricsExporter"  
        final AtomicInteger testValue = new AtomicInteger(0);
        MetricsRegistry metricsRegistry = internalCluster().getInstance(MetricsRegistry.class);
    }
        InMemorySingletonMetricsExporter.INSTANCE.reset();  
        assertEquals(1.0, histogramPointData.getMin(), 1.0);
import java.util.List;  
    }
    @Override
        // assert it hasn't changed. assertBusy retries if an in-flight collection was still draining at close time.
    protected boolean addMockTelemetryPlugin() {  
 * this file be licensed under the Apache-2.0 license or a
        Supplier<Double> valueProvider = () -> { return Double.valueOf(testValue.incrementAndGet()); };
        String metricName = "test-gauge-" + randomAlphaOfLength(8);  
        });  
            .put(TelemetrySettings.METRICS_FEATURE_ENABLED_SETTING.getKey(), true)  
/*  
import org.opensearch.telemetry.metrics.tags.Tags;
        InMemorySingletonMetricsExporter.INSTANCE.reset();  
import java.util.Arrays;
        // Verify the callback is no longer invoked: snapshot the counter, wait longer than the publish interval, and  
            .get(0)  
        MetricsRegistry metricsRegistry = internalCluster().getInstance(MetricsRegistry.class);
 * SPDX-License-Identifier: Apache-2.0
            .collect(Collectors.toList());
            .filter(a -> a.getName().contains(metricName))  
        };
        // assert it hasn't changed. assertBusy retries if an in-flight collection was still draining at close time.
        return Arrays.asList(IntegrationTestOTelTelemetryPlugin.class);
            assertEquals("Gauge callback should no longer be invoked after close", val, testValue.get());
    public void testGauge() throws Exception {
            totalValue = Math.max(totalValue, ((DoublePointData) metricData.getDoubleGaugeData().getPoints().toArray()[0]).getValue());
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, minNumDataNodes = 1)
    public void testCounter() throws Exception {
import io.opentelemetry.sdk.metrics.data.DoublePointData;
        assertBusy(() -> assertThat(getMaxObservableGaugeValue(exporter, metricName), greaterThanOrEqualTo(2.0)));  
    }  
        Tags tags = Tags.create().addTag("test", "integ-test");  
        InMemorySingletonMetricsExporter.INSTANCE.reset();  
    private static Map<AttributeKey<?>, Object> getMetricAttributes(InMemorySingletonMetricsExporter exporter, String metricName) {  
        Counter counter = metricsRegistry.createUpDownCounter("test-up-down-counter", "test", "1");
                OTelTelemetrySettings.OTEL_METRICS_EXPORTER_CLASS_SETTING.getKey(),
            .put(
            .getDoubleSumData()
            .collect(Collectors.toList())
        Thread.sleep(2000);
import io.opentelemetry.sdk.metrics.internal.data.ImmutableExponentialHistogramPointData;
import io.opentelemetry.api.common.Attributes;
 */  
            .stream()
        InMemorySingletonMetricsExporter exporter = InMemorySingletonMetricsExporter.INSTANCE;  
        histogram.record(2.0);  
import java.util.ArrayList;  
    }
        // Sleep for about 2s to wait for metrics to be published.  
