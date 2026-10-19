        return Settings.builder()
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;  
        counter.add(1.0);  
public class TelemetryMetricsDisabledSanityIT extends OpenSearchIntegTestCase {
import java.util.Collection;
import org.opensearch.test.OpenSearchIntegTestCase;
        return false;
            .build();
import org.opensearch.telemetry.IntegrationTestOTelTelemetryPlugin;
        MetricsRegistry metricsRegistry = internalCluster().getInstance(MetricsRegistry.class);  
        Counter counter = metricsRegistry.createCounter("test-counter", "test", "1");
    protected Settings nodeSettings(int nodeOrdinal) {
import java.util.Arrays;  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, minNumDataNodes = 1)  
import org.opensearch.telemetry.metrics.noop.NoopHistogram;
    }
    @Override  
 */  
    }
        Thread.sleep(2000);
import org.opensearch.telemetry.metrics.noop.NoopCounter;
            .put(super.nodeSettings(nodeOrdinal))  
import org.opensearch.common.settings.Settings;
    @Override  
 * SPDX-License-Identifier: Apache-2.0
        return Arrays.asList(IntegrationTestOTelTelemetryPlugin.class);  
        Histogram histogram = metricsRegistry.createHistogram("test-histogram", "test", "1");
package org.opensearch.telemetry.metrics;
import org.opensearch.telemetry.TelemetrySettings;  
import org.opensearch.telemetry.OTelTelemetrySettings;
            .put(
        assertTrue(histogram instanceof NoopHistogram);
        assertTrue(metricsRegistry instanceof NoopMetricsRegistry);  
 * compatible open source license.
            .put(TelemetrySettings.METRICS_FEATURE_ENABLED_SETTING.getKey(), false)
            .put(TelemetrySettings.METRICS_PUBLISH_INTERVAL_SETTING.getKey(), TimeValue.timeValueSeconds(1))  
    public void testSanityChecksWhenMetricsDisabled() throws Exception {
import org.opensearch.common.unit.TimeValue;
}
            )
    @Override
    }  
 * The OpenSearch Contributors require contributions made to  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
/*  
    }  
 *
    protected boolean addMockTelemetryPlugin() {
import org.opensearch.plugins.Plugin;  
                "org.opensearch.telemetry.metrics.InMemorySingletonMetricsExporter"
 * this file be licensed under the Apache-2.0 license or a
                OTelTelemetrySettings.OTEL_METRICS_EXPORTER_CLASS_SETTING.getKey(),  
        assertTrue(counter instanceof NoopCounter);
