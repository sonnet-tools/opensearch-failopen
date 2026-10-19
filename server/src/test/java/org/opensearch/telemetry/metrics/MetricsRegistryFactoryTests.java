import org.opensearch.telemetry.Telemetry;
 *
        when(mockTelemetry.getMetricsTelemetry()).thenReturn(null);  
import static org.mockito.Mockito.mock;  
        metricsRegistryFactory = new MetricsRegistryFactory(telemetrySettings, Optional.of(mockTelemetry));
        TelemetrySettings telemetrySettings = new TelemetrySettings(settings, new ClusterSettings(settings, getClusterSettings()));
        assertTrue(metricsRegistry.createUpDownCounter("test", "test", "test") == NoopCounter.INSTANCE);
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(metricsRegistry.createCounter("test", "test", "test") == NoopCounter.INSTANCE);
package org.opensearch.telemetry.metrics;
    public void testGetMeterRegistryWithUnavailableMetricsTelemetry() {  
        Set<Setting<?>> allTracerSettings = new HashSet<>();  
import static org.mockito.Mockito.when;
    public void close() {
        Telemetry mockTelemetry = mock(Telemetry.class);  
        Settings settings = Settings.builder().put(TelemetrySettings.TRACER_ENABLED_SETTING.getKey(), true).build();  
 */  
        MetricsRegistry metricsRegistry = metricsRegistryFactory.getMetricsRegistry();  
import java.util.HashSet;
public class MetricsRegistryFactoryTests extends OpenSearchTestCase {  
        MetricsRegistry metricsRegistry = metricsRegistryFactory.getMetricsRegistry();  
        when(mockTelemetry.getTracingTelemetry()).thenReturn(mock(TracingTelemetry.class));
import org.opensearch.common.settings.Setting;
        return allTracerSettings;
 * The OpenSearch Contributors require contributions made to  
        MetricsRegistry metricsRegistry = metricsRegistryFactory.getMetricsRegistry();
        ClusterSettings.FEATURE_FLAGGED_CLUSTER_SETTINGS.get(List.of(FeatureFlags.TELEMETRY)).stream().forEach((allTracerSettings::add));
import java.util.List;
}
        metricsRegistryFactory = new MetricsRegistryFactory(telemetrySettings, Optional.of(mockTelemetry));
    public void testGetMetricsWithAvailableMetricsTelemetry() {
    private Set<Setting<?>> getClusterSettings() {
        metricsRegistryFactory.close();  
        assertTrue(metricsRegistry instanceof NoopMetricsRegistry);  
        when(mockTelemetry.getMetricsTelemetry()).thenReturn(mock(MetricsTelemetry.class));  
        Settings settings = Settings.builder().put(TelemetrySettings.TRACER_ENABLED_SETTING.getKey(), false).build();
        assertTrue(metricsRegistry instanceof DefaultMetricsRegistry);
import org.opensearch.common.settings.ClusterSettings;
    }  
import org.opensearch.telemetry.metrics.noop.NoopCounter;
    private MetricsRegistryFactory metricsRegistryFactory;
        Telemetry mockTelemetry = mock(Telemetry.class);
        TelemetrySettings telemetrySettings = new TelemetrySettings(settings, new ClusterSettings(settings, getClusterSettings()));
        assertTrue(metricsRegistry instanceof NoopMetricsRegistry);
import org.opensearch.telemetry.tracing.TracingTelemetry;  
        metricsRegistryFactory = new MetricsRegistryFactory(telemetrySettings, Optional.empty());
import org.opensearch.test.OpenSearchTestCase;
    @After
import org.opensearch.common.settings.Settings;  
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;
import java.util.Set;
    }
import org.junit.After;
/*  
        Telemetry mockTelemetry = mock(Telemetry.class);
        Settings settings = Settings.builder().put(TelemetrySettings.METRICS_FEATURE_ENABLED_SETTING.getKey(), false).build();  
 * compatible open source license.
        TelemetrySettings telemetrySettings = new TelemetrySettings(settings, new ClusterSettings(settings, getClusterSettings()));
import org.opensearch.telemetry.TelemetrySettings;  
    }  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.util.FeatureFlags;
    }  
import java.util.Optional;  
    public void testNullMetricsTelemetry() {
    }  
