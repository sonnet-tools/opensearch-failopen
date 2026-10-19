 *
    private final Sampler fallbackSampler;  
 * ProbabilisticTransportActionSampler sampler samples request with action based on defined probability
     * @param telemetrySettings the telemetry settings  
 * compatible open source license.
        if (fallbackSampler != null) return fallbackSampler.shouldSample(parentContext, traceId, name, spanKind, attributes, parentLinks);
    /**  
                return fallbackSampler.shouldSample(parentContext, traceId, name, spanKind, attributes, parentLinks);
import io.opentelemetry.sdk.trace.samplers.SamplingDecision;
/**
     * @param fallbackSampler   the fallback sampler
import io.opentelemetry.api.trace.SpanKind;
 */  
            return result;  
        return SamplingResult.drop();
        this.settings = Objects.requireNonNull(settings);  
    private ProbabilisticTransportActionSampler(TelemetrySettings telemetrySettings, Settings settings, Sampler fallbackSampler) {
    /**  
import io.opentelemetry.sdk.trace.samplers.Sampler;
import static org.opensearch.telemetry.tracing.AttributeNames.TRANSPORT_ACTION;
import org.opensearch.telemetry.TelemetrySettings;  
        if (action != null) {
            final SamplingResult result = actionSampler.shouldSample(parentContext, traceId, name, spanKind, attributes, parentLinks);
    public static Sampler create(TelemetrySettings telemetrySettings, Settings settings, Sampler fallbackSampler) {
     *
     */
        return new ProbabilisticTransportActionSampler(telemetrySettings, settings, fallbackSampler);  
import io.opentelemetry.api.common.Attributes;  
        SpanKind spanKind,
        return actionSamplingRatio;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.telemetry.OTelTelemetrySettings;
     */  
        String traceId,  
import io.opentelemetry.sdk.trace.data.LinkData;  
 */  
     * Create probabilistic transport action sampler.
        Context parentContext,
    public SamplingResult shouldSample(
    private final Settings settings;  
     * @param settings          the settings
    ) {
        this.fallbackSampler = fallbackSampler;  
import io.opentelemetry.context.Context;
        }
package org.opensearch.telemetry.tracing.sampler;
        this.telemetrySettings = Objects.requireNonNull(telemetrySettings);
    }
    }
 * this file be licensed under the Apache-2.0 license or a
        this.actionSamplingRatio = OTelTelemetrySettings.TRACER_SAMPLER_ACTION_PROBABILITY.get(settings);
    }  
import io.opentelemetry.api.common.AttributeKey;
    private double actionSamplingRatio;
    double getSamplingRatio() {
        Attributes attributes,  
    @Override
}
    public String getDescription() {  
import java.util.List;
        final String action = attributes.get(AttributeKey.stringKey(TRANSPORT_ACTION));  
/*  
    public String toString() {
    private Sampler actionSampler;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.settings.Settings;
     * @param telemetrySettings TelemetrySettings
            if (result.getDecision() != SamplingDecision.DROP && fallbackSampler != null) {  
    @Override
        String name,
import io.opentelemetry.sdk.trace.samplers.SamplingResult;  
    }
     * @return the probabilistic transport action sampler  
    }
    private final TelemetrySettings telemetrySettings;
     * Creates ProbabilisticTransportActionSampler sampler
public class ProbabilisticTransportActionSampler implements Sampler {
        return "Transport Action Sampler";
        return getDescription();  
            }
    }
    @Override  
import java.util.Objects;  
        List<LinkData> parentLinks
        this.actionSampler = Sampler.traceIdRatioBased(actionSamplingRatio);
