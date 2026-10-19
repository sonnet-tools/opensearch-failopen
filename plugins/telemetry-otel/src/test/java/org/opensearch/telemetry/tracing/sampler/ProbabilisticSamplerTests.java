        // Verify that the constructor throws IllegalArgumentException when given null settings  
import org.opensearch.common.settings.Settings;
        // Probabilistic Sampler  
    public void testProbabilisticSamplerWithNullSettings() {
import org.opensearch.common.settings.ClusterSettings;
    public void testDefaultGetSampler() {
/*  
        assertEquals(0.01d, ((ProbabilisticSampler) probabilisticSampler).getSamplingRatio(), 0.0d);  
        );  
        // Need to call getSampler() to update the value of tracerHeadSamplerSamplingRatio
        );
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.sdk.trace.samplers.Sampler;
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(0.01, ((ProbabilisticSampler) probabilisticSampler).getSamplingRatio(), 0.0d);
        // Probabilistic Sampler
import org.opensearch.test.OpenSearchTestCase;
        Sampler probabilisticSampler = ProbabilisticSampler.create(telemetrySettings, Settings.EMPTY, null);
    }  
            Settings.EMPTY,
import static org.opensearch.telemetry.OTelTelemetrySettings.TRACER_EXPORTER_DELAY_SETTING;  
            new ClusterSettings(settings, Set.of(TRACER_SAMPLER_PROBABILITY, TRACER_ENABLED_SETTING))  
        TelemetrySettings telemetrySettings = new TelemetrySettings(
        telemetrySettings.setSamplingProbability(0.02);
import org.opensearch.telemetry.TelemetrySettings;  
            new ClusterSettings(settings, Set.of(TRACER_SAMPLER_PROBABILITY, TRACER_ENABLED_SETTING))
import java.util.Set;  
        // Need to call shouldSample() to update the value of samplingRatio
 * compatible open source license.
import io.opentelemetry.context.Context;  
    // When ProbabilisticSampler is created with OTelTelemetrySettings as null
 */  
        probabilisticSampler.shouldSample(mock(Context.class), "00000000000000000000000000000000", "", SpanKind.INTERNAL, null, null);
 * SPDX-License-Identifier: Apache-2.0
    }
import static org.opensearch.telemetry.TelemetrySettings.TRACER_SAMPLER_PROBABILITY;
    public void testGetSamplerWithUpdatedSamplingRatio() {
import static org.mockito.Mockito.mock;  
package org.opensearch.telemetry.tracing.sampler;
}
import static org.opensearch.telemetry.TelemetrySettings.TRACER_ENABLED_SETTING;
        assertEquals(0.02, ((ProbabilisticSampler) probabilisticSampler).getSamplingRatio(), 0.0d);
        Settings settings = Settings.builder().put(TRACER_EXPORTER_DELAY_SETTING.getKey(), "1s").build();  
        assertThrows(NullPointerException.class, () -> { ProbabilisticSampler.create(null, null, null); });
    }  
        Sampler probabilisticSampler = ProbabilisticSampler.create(telemetrySettings, Settings.EMPTY, null);  
        Settings settings = Settings.builder().put(TRACER_EXPORTER_DELAY_SETTING.getKey(), "1s").build();
public class ProbabilisticSamplerTests extends OpenSearchTestCase {
        TelemetrySettings telemetrySettings = new TelemetrySettings(  
 *
            Settings.EMPTY,
 * The OpenSearch Contributors require contributions made to  
