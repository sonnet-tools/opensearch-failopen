            .put(OTelTelemetrySettings.OTEL_TRACER_SPAN_SAMPLER_CLASS_SETTINGS.getKey(), ProbabilisticSampler.class.getName())  
import org.opensearch.test.OpenSearchTestCase;
import static org.opensearch.telemetry.TelemetrySettings.TRACER_ENABLED_SETTING;
import org.opensearch.telemetry.OTelTelemetrySettings;
public class OTelSamplerFactoryTests extends OpenSearchTestCase {
import org.opensearch.common.settings.Settings;
import io.opentelemetry.sdk.trace.samplers.Sampler;
/*  
package org.opensearch.telemetry.tracing.sampler;
    public void testDefaultCreate() {  
import static org.opensearch.telemetry.TelemetrySettings.TRACER_SAMPLER_PROBABILITY;
    }
 *
        ClusterSettings clusterSettings = new ClusterSettings(settings, Set.of(TRACER_SAMPLER_PROBABILITY, TRACER_ENABLED_SETTING));  
}
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, Set.of(TRACER_SAMPLER_PROBABILITY, TRACER_ENABLED_SETTING));
            .build();
import org.opensearch.common.settings.ClusterSettings;  
 * SPDX-License-Identifier: Apache-2.0
        TelemetrySettings telemetrySettings = new TelemetrySettings(Settings.EMPTY, clusterSettings);
    }
        Sampler sampler = OTelSamplerFactory.create(telemetrySettings, Settings.EMPTY);  
        assertTrue(sampler instanceof ProbabilisticSampler);  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
        Sampler sampler = OTelSamplerFactory.create(telemetrySettings, settings);
 */  
        TelemetrySettings telemetrySettings = new TelemetrySettings(settings, clusterSettings);
    public void testCreateWithSingleSampler() {
import org.opensearch.telemetry.TelemetrySettings;  
        assertEquals(sampler.getClass(), ProbabilisticTransportActionSampler.class);
import java.util.Set;  
        Settings settings = Settings.builder()
