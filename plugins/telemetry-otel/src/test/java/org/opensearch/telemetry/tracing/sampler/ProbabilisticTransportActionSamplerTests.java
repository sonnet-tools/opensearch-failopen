import static org.opensearch.telemetry.TelemetrySettings.TRACER_ENABLED_SETTING;  
    public void testGetSamplerWithActionSamplingRatio() {
import org.opensearch.common.settings.ClusterSettings;
import io.opentelemetry.api.common.Attributes;  
        );
import io.opentelemetry.sdk.trace.samplers.Sampler;  
import org.opensearch.common.settings.Settings;
        TelemetrySettings telemetrySettings = new TelemetrySettings(Settings.EMPTY, clusterSettings);
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, Set.of(TRACER_SAMPLER_PROBABILITY, TRACER_ENABLED_SETTING));
/*  
            Attributes.builder().put(TRANSPORT_ACTION, "dummy_action").build(),
public class ProbabilisticTransportActionSamplerTests extends OpenSearchTestCase {
 * SPDX-License-Identifier: Apache-2.0
            Collections.emptyList()  
}  
            "spanName",  
import io.opentelemetry.api.trace.SpanKind;
        assertEquals(0.001, ((ProbabilisticTransportActionSampler) probabilisticTransportActionSampler).getSamplingRatio(), 0.000d);
            SpanKind.INTERNAL,
        SamplingResult result = probabilisticTransportActionSampler.shouldSample(  
        // ProbabilisticTransportActionSampler  
            "00000000000000000000000000000000",
import io.opentelemetry.sdk.trace.samplers.SamplingResult;
import static org.mockito.Mockito.mock;  
            mock(Context.class),
import java.util.Set;
import java.util.Collections;  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(SamplingResult.recordAndSample(), result);  
 *
import static org.opensearch.telemetry.tracing.AttributeNames.TRANSPORT_ACTION;
    }
import static org.opensearch.telemetry.TelemetrySettings.TRACER_SAMPLER_PROBABILITY;
        // Verify that ProbabilisticTransportActionSampler returned SamplingResult.recordAndSample() as all actions will be sampled
import io.opentelemetry.context.Context;
 */  
 * compatible open source license.
        Sampler probabilisticTransportActionSampler = ProbabilisticTransportActionSampler.create(telemetrySettings, Settings.EMPTY, null);
package org.opensearch.telemetry.tracing.sampler;
import org.opensearch.telemetry.TelemetrySettings;  
