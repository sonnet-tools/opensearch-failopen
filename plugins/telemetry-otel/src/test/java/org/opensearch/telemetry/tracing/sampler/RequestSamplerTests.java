import io.opentelemetry.sdk.trace.samplers.SamplingResult;  
        // Verify that request is sampled  
import io.opentelemetry.api.common.AttributeKey;
                    "org.opensearch.telemetry.tracing.sampler.ProbabilisticTransportActionSampler"  
        assertEquals(SamplingResult.drop(), result);  
import java.util.Set;
    }
        assertEquals(SamplingResult.drop(), result);
package org.opensearch.telemetry.tracing.sampler;
    public void testShouldSampleForProbabilisticSampler() {
            attributes,  
        SamplingResult result = requestSampler.shouldSample(  
            Collections.emptyList()  
        );
            "00000000000000000000000000000000",  
 * compatible open source license.
                .put("telemetry.tracer.sampler.probability", "1.0")
        clusterSettings.applySettings(Settings.builder().put("telemetry.tracer.action.sampler.probability", "1.0").build());
            Settings.builder()  
import io.opentelemetry.context.Context;
            SpanKind.INTERNAL,
            "spanName",
import static org.mockito.Mockito.mock;
 */  
                .build()
                    "telemetry.otel.tracer.span.sampler.classes",
        assertEquals(SamplingResult.recordAndSample(), result);
            parentContext,
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
    public void init() {
        parentContext = mock(Context.class);
        );
        assertEquals(SamplingResult.recordAndSample(), result);  
        );
import org.junit.Before;
    }
            "00000000000000000000000000000000",
import static org.opensearch.telemetry.TelemetrySettings.TRACER_ENABLED_SETTING;
            "traceId",
                .build()
            Collections.emptyList()
            SpanKind.INTERNAL,
import static org.opensearch.telemetry.tracing.AttributeNames.TRANSPORT_ACTION;
        );
public class RequestSamplerTests extends OpenSearchTestCase {
            Collections.emptyList()
        assertEquals(SamplingResult.recordAndSample(), result);  
        Context parentContext = mock(Context.class);
            "spanName",
import org.opensearch.common.settings.Settings;
/*  
        );
            Settings.builder()
import io.opentelemetry.sdk.trace.samplers.Sampler;
        Attributes attributes = Attributes.builder().put(TRANSPORT_ACTION, "dummy_action").build();
    private RequestSampler requestSampler;
        telemetrySettings = new TelemetrySettings(Settings.EMPTY, clusterSettings);
            "spanName",  
 *
            attributes,  
        SamplingResult result = requestSampler.shouldSample(
        // Verify that request is sampled
        Sampler fallbackSampler = OTelSamplerFactory.create(telemetrySettings, Settings.EMPTY);
import io.opentelemetry.api.common.Attributes;
            Collections.emptyList()
        clusterSettings = new ClusterSettings(Settings.EMPTY, Set.of(TRACER_SAMPLER_PROBABILITY, TRACER_ENABLED_SETTING));  
            "spanName",
            parentContext,
    }
import static org.opensearch.telemetry.TelemetrySettings.TRACER_SAMPLER_PROBABILITY;  
import org.opensearch.test.OpenSearchTestCase;
    }  
        clusterSettings.applySettings(  
        Attributes attributes = Attributes.builder().build();
    @Before
            attributes,
            SpanKind.INTERNAL,  
import org.opensearch.common.settings.ClusterSettings;
        );  
        SamplingResult result = requestSampler.shouldSample(
                )
    public void testShouldSampleWithTraceAttributeAsFalse() {  
            parentContext,
            SpanKind.INTERNAL,
            "spanName",  
import io.opentelemetry.api.trace.SpanKind;  
            Collections.emptyList()  
            SpanKind.INTERNAL,
    }
            attributes,
                .put("telemetry.otel.tracer.span.sampler.classes", "org.opensearch.telemetry.tracing.sampler.ProbabilisticSampler")  
            "traceId",  
    private Context parentContext;
            attributes,
        result = requestSampler.shouldSample(
        );  
            "00000000000000000000000000000000",
        requestSampler = new RequestSampler(fallbackSampler);  
import java.util.Collections;
                .put(
        Attributes attributes = Attributes.of(AttributeKey.stringKey("trace"), "false");
        Attributes attributes = Attributes.of(AttributeKey.stringKey("trace"), "true");
        clusterSettings.applySettings(Settings.builder().put("telemetry.tracer.sampler.probability", "0.0").build());  
            parentContext,
    private TelemetrySettings telemetrySettings;  
        // Calling shouldSample to update samplingRatio
        SamplingResult result = requestSampler.shouldSample(  
    public void testShouldSampleWithTraceAttributeAsTrue() {
        // Create a mock Context and Attributes with dummy action  
 * this file be licensed under the Apache-2.0 license or a
        clusterSettings.applySettings(
    public void testShouldSampleForProbabilisticTransportActionSampler() {
import org.opensearch.telemetry.TelemetrySettings;  
            parentContext,  
    private ClusterSettings clusterSettings;
}  
