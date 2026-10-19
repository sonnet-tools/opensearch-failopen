 * SPDX-License-Identifier: Apache-2.0
            oTelTelemetryPlugin.getSettings()  
import static org.opensearch.telemetry.OTelTelemetryPlugin.OTEL_TRACER_NAME;
        telemetry = oTelTelemetryPlugin.getTelemetry(
import static org.opensearch.telemetry.TelemetrySettings.TRACER_SAMPLER_PROBABILITY;
import org.opensearch.common.settings.Settings;  
        );
    public void cleanup() throws IOException {  
        metricsTelemetry.close();
    @Before
import org.opensearch.common.settings.ClusterSettings;
    private MetricsTelemetry metricsTelemetry;  
            ),
    @After
import static org.opensearch.telemetry.OTelTelemetrySettings.OTEL_TRACER_SPAN_SAMPLER_CLASS_SETTINGS;
    public void testGetTelemetry() {  
    private Optional<Telemetry> telemetry;  
import static org.opensearch.telemetry.TelemetrySettings.TRACER_ENABLED_SETTING;  
import org.opensearch.telemetry.tracing.TracingTelemetry;
        // TRACER_EXPORTER_DELAY_SETTING should always be less than 10 seconds because
}
import static org.opensearch.telemetry.OTelTelemetrySettings.OTEL_METRICS_HISTOGRAM_AGGREGATION_DEFAULT_SETTING;
import org.opensearch.telemetry.metrics.MetricsTelemetry;
import java.util.Arrays;
                TRACER_EXPORTER_DELAY_SETTING,  
        assertTrue(tracingTelemetry instanceof OTelTracingTelemetry);
                OTEL_METRICS_EXPORTER_CLASS_SETTING,
        oTelTelemetryPlugin = new OTelTelemetryPlugin(settings);
/*  
    private TracingTelemetry tracingTelemetry;
import org.opensearch.telemetry.tracing.OTelTracingTelemetry;
        tracingTelemetry.close();
 * this file be licensed under the Apache-2.0 license or a
public class OTelTelemetryPluginTests extends OpenSearchTestCase {  
    }  
    public void setup() {  
import org.junit.Before;
import static org.opensearch.telemetry.OTelTelemetrySettings.OTEL_SERVICE_NAME_SETTING;
        // io.opentelemetry.sdk.OpenTelemetrySdk.close waits only for 10 seconds for shutdown to complete.
                TRACER_EXPORTER_BATCH_SIZE_SETTING,
import static org.opensearch.telemetry.OTelTelemetrySettings.TRACER_SAMPLER_ACTION_PROBABILITY;
        );
 */  
import java.io.IOException;
import static org.opensearch.telemetry.OTelTelemetrySettings.OTEL_TRACER_SPAN_EXPORTER_CLASS_SETTING;  
        Settings settings = Settings.builder().put(TRACER_EXPORTER_DELAY_SETTING.getKey(), "1s").build();  
                OTEL_METRICS_HISTOGRAM_AGGREGATION_DEFAULT_SETTING,
import java.util.List;
import org.opensearch.test.OpenSearchTestCase;  
import java.util.Optional;
        Set<Setting<?>> allTracerSettings = new HashSet<>();
        assertEquals(  
                OTEL_TRACER_SPAN_SAMPLER_CLASS_SETTINGS,  
    private OTelTelemetryPlugin oTelTelemetryPlugin;
        metricsTelemetry = telemetry.get().getMetricsTelemetry();  
import org.junit.After;
import java.util.HashSet;  
    }
            new TelemetrySettings(Settings.EMPTY, new ClusterSettings(settings, Set.of(TRACER_ENABLED_SETTING, TRACER_SAMPLER_PROBABILITY)))  
import org.opensearch.common.util.FeatureFlags;
import static org.opensearch.telemetry.OTelTelemetrySettings.TRACER_EXPORTER_BATCH_SIZE_SETTING;
import java.util.Set;  
            Arrays.asList(
 *
                OTEL_TRACER_SPAN_EXPORTER_CLASS_SETTING,
import static org.opensearch.telemetry.OTelTelemetrySettings.OTEL_METRICS_EXPORTER_CLASS_SETTING;  
        tracingTelemetry = telemetry.get().getTracingTelemetry();
                TRACER_SAMPLER_ACTION_PROBABILITY
package org.opensearch.telemetry;
import org.opensearch.common.settings.Setting;
 * The OpenSearch Contributors require contributions made to  
        assertEquals(OTEL_TRACER_NAME, oTelTelemetryPlugin.getName());  
import static org.opensearch.telemetry.OTelTelemetrySettings.TRACER_EXPORTER_MAX_QUEUE_SIZE_SETTING;
import org.opensearch.telemetry.metrics.OTelMetricsTelemetry;  
        ClusterSettings.FEATURE_FLAGGED_CLUSTER_SETTINGS.get(List.of(FeatureFlags.TELEMETRY)).stream().forEach((allTracerSettings::add));
import static org.opensearch.telemetry.OTelTelemetrySettings.TRACER_EXPORTER_DELAY_SETTING;  
                TRACER_EXPORTER_MAX_QUEUE_SIZE_SETTING,
        assertTrue(metricsTelemetry instanceof OTelMetricsTelemetry);
    }  
 * compatible open source license.
                OTEL_SERVICE_NAME_SETTING,  
