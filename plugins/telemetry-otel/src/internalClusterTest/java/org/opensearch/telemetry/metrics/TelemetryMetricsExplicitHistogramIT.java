import io.opentelemetry.sdk.metrics.data.MetricData;  
    // Default explicit bucket boundaries of the OpenTelemetry SDK.  
    );
        return false;
        0.0,
    protected boolean addMockTelemetryPlugin() {  
            .put(TelemetrySettings.METRICS_FEATURE_ENABLED_SETTING.getKey(), true)
package org.opensearch.telemetry.metrics;
 *
        histogram.record(1.0);
            .put(  
    @Override
        });
    }  
            .put(TelemetrySettings.METRICS_PUBLISH_INTERVAL_SETTING.getKey(), TimeValue.timeValueSeconds(1))
        assertBusy(() -> {
        MetricsRegistry metricsRegistry = internalCluster().getInstance(MetricsRegistry.class);
                "org.opensearch.telemetry.metrics.InMemorySingletonMetricsExporter"
                .stream()  
 * The OpenSearch Contributors require contributions made to  
        5.0,  
import org.opensearch.common.settings.Settings;
                .map(m -> m.getHistogramData().getPoints().iterator().next())  
        5000.0,
            assertEquals(3.0, point.getMax(), 0.0);  
            assertEquals(6.0, point.getSum(), 0.0);
 * compatible open source license.
import java.util.Collection;
            .put(OTelTelemetrySettings.OTEL_METRICS_HISTOGRAM_AGGREGATION_DEFAULT_SETTING.getKey(), "explicit_bucket_histogram")
import org.opensearch.plugins.Plugin;  
    }
import java.util.Arrays;  
        Histogram histogram = metricsRegistry.createHistogram("test-explicit-histogram", "test", "ms");
        500.0,
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
            // Exports are cumulative: pick the export that already contains all three records.  
 * this file be licensed under the Apache-2.0 license or a
                .findFirst()
        2500.0,
        50.0,  
    @Override  
    public void testHistogramUsesExplicitBuckets() throws Exception {
        10.0,
                .orElseThrow(() -> new AssertionError("no export with all records yet"));  
import java.util.stream.Collectors;  
                .collect(Collectors.toList());
                .filter(a -> a.getName().contains("test-explicit-histogram"))
        100.0,
public class TelemetryMetricsExplicitHistogramIT extends OpenSearchIntegTestCase {
    }  
    }
import java.util.List;
import org.opensearch.test.OpenSearchIntegTestCase;
        1000.0,  
        7500.0,  
            assertTrue(metrics.stream().noneMatch(m -> m.getType() == MetricDataType.EXPONENTIAL_HISTOGRAM));
            .build();  
                OTelTelemetrySettings.OTEL_METRICS_EXPORTER_CLASS_SETTING.getKey(),
import org.opensearch.common.unit.TimeValue;
        return Settings.builder()  
import org.opensearch.telemetry.OTelTelemetrySettings;
import org.opensearch.telemetry.TelemetrySettings;  
            assertEquals(1.0, point.getMin(), 0.0);
}
    protected Settings nodeSettings(int nodeOrdinal) {
            List<MetricData> metrics = InMemorySingletonMetricsExporter.INSTANCE.getFinishedMetricItems()
        10000.0
 * SPDX-License-Identifier: Apache-2.0
            HistogramPointData point = metrics.stream()
                .filter(m -> m.getType() == MetricDataType.HISTOGRAM)
        histogram.record(2.0);  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, minNumDataNodes = 1)  
    @Override
                .filter(pt -> pt.getCount() == 3)
        25.0,
        InMemorySingletonMetricsExporter.INSTANCE.reset();  
import io.opentelemetry.sdk.metrics.data.MetricDataType;
            .put(super.nodeSettings(nodeOrdinal))
        75.0,
            assertFalse(metrics.isEmpty());  
            )  
import org.opensearch.telemetry.IntegrationTestOTelTelemetryPlugin;
            assertEquals(SDK_DEFAULT_BOUNDARIES, point.getBoundaries());
        750.0,
        return Arrays.asList(IntegrationTestOTelTelemetryPlugin.class);
        250.0,  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        histogram.record(3.0);
/*  
 */  
    private static final List<Double> SDK_DEFAULT_BOUNDARIES = Arrays.asList(
