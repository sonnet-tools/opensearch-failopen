            OTelTelemetrySettings.OTEL_TRACER_SPAN_EXPORTER_CLASS_SETTING,  
import org.opensearch.plugins.TelemetryPlugin;
            OTelTelemetrySettings.OTEL_METRICS_HISTOGRAM_AGGREGATION_DEFAULT_SETTING,  
public class OTelTelemetryPlugin extends Plugin implements TelemetryPlugin {  
        initializeOpenTelemetrySdk(telemetrySettings);
 * this file be licensed under the Apache-2.0 license or a
    /**
import org.opensearch.common.settings.Settings;  
        if (refCountedOpenTelemetry != null) {
    public static final String INSTRUMENTATION_SCOPE_NAME = "org.opensearch.telemetry";
     * Instrumentation scope name.  
 */
        if (refCountedOpenTelemetry != null) {
/*  
     */
    }
        }  
import java.util.List;
    public String getName() {  
    private final Settings settings;  
            OTelTelemetrySettings.TRACER_EXPORTER_BATCH_SIZE_SETTING,  
    }  
            OTelTelemetrySettings.OTEL_METRICS_EXPORTER_CLASS_SETTING,
        this.settings = settings;  
import org.opensearch.common.concurrent.RefCountedReleasable;
            OTelTelemetrySettings.OTEL_TRACER_SPAN_SAMPLER_CLASS_SETTINGS,
    public List<Setting<?>> getSettings() {
 * compatible open source license.
import org.opensearch.common.settings.Setting;
    @Override
 *
    }
    public Optional<Telemetry> getTelemetry(TelemetrySettings telemetrySettings) {
import java.util.Optional;
    static final String OTEL_TRACER_NAME = "otel";
import io.opentelemetry.sdk.OpenTelemetrySdk;
            OTelTelemetrySettings.TRACER_EXPORTER_DELAY_SETTING,
        }  
    }
 * SPDX-License-Identifier: Apache-2.0
    }
    @Override
        refCountedOpenTelemetry = new RefCountedReleasable<>("openTelemetry", openTelemetrySdk, openTelemetrySdk::close);
            OTelTelemetrySettings.TRACER_SAMPLER_ACTION_PROBABILITY
        OpenTelemetrySdk openTelemetrySdk = OTelResourceProvider.get(telemetrySettings, settings);
    @Override  
     */
    }  
import org.opensearch.telemetry.tracing.OTelTelemetry;
    public void close() {  
 * Telemetry plugin based on Otel
        return new OTelTelemetry(refCountedOpenTelemetry);
     * @param settings cluster settings  
        return Arrays.asList(
 * The OpenSearch Contributors require contributions made to  
}  
    /**
     * Creates Otel plugin
import org.opensearch.telemetry.tracing.OTelResourceProvider;  
            refCountedOpenTelemetry.close();
            return;
    private Telemetry telemetry(TelemetrySettings telemetrySettings) {
        );  
import java.util.Arrays;  
    private void initializeOpenTelemetrySdk(TelemetrySettings telemetrySettings) {  
 */  
        return OTEL_TRACER_NAME;
    public OTelTelemetryPlugin(Settings settings) {
    private RefCountedReleasable<OpenTelemetrySdk> refCountedOpenTelemetry;
            OTelTelemetrySettings.TRACER_EXPORTER_MAX_QUEUE_SIZE_SETTING,
import org.opensearch.plugins.Plugin;
/**  
package org.opensearch.telemetry;
        return Optional.of(telemetry(telemetrySettings));  
            OTelTelemetrySettings.OTEL_SERVICE_NAME_SETTING,
    }
    @Override  
