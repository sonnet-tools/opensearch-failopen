import io.opentelemetry.sdk.trace.samplers.Sampler;
        String traceId,
            }
    @Override
import org.opensearch.common.settings.Settings;
    }
    public static Sampler create(TelemetrySettings telemetrySettings, Settings settings, Sampler fallbackSampler) {
        this.fallbackSampler = fallbackSampler;  
import java.util.Objects;
        this.settings = Objects.requireNonNull(settings);  
    public String toString() {
 * The OpenSearch Contributors require contributions made to  
        SpanKind spanKind,
     *
        return getDescription();  
import org.opensearch.telemetry.TelemetrySettings;
        }
        if (result.getDecision() != SamplingDecision.DROP && fallbackSampler != null) {
    double getSamplingRatio() {
    private Sampler defaultSampler;
 * ProbabilisticSampler implements a probability sampling strategy based on configured sampling ratio.
     *
     * @param fallbackSampler   the fallback sampler
        if (isSamplingRatioChanged(newSamplingRatio)) {  
        return "Probabilistic Sampler";
        final SamplingResult result = defaultSampler.shouldSample(parentContext, traceId, name, spanKind, attributes, parentLinks);  
        List<LinkData> parentLinks  
    private final TelemetrySettings telemetrySettings;
 * this file be licensed under the Apache-2.0 license or a
    public SamplingResult shouldSample(  
    }  
import io.opentelemetry.context.Context;  
    }
     * @param telemetrySettings Telemetry settings.
import io.opentelemetry.api.common.Attributes;
     * Constructor  
    ) {
     * @return the probabilistic sampler  
            return fallbackSampler.shouldSample(parentContext, traceId, name, spanKind, attributes, parentLinks);
        String name,  
        Context parentContext,
    }
            synchronized (this) {
 * SPDX-License-Identifier: Apache-2.0
 */
        return new ProbabilisticSampler(telemetrySettings, settings, fallbackSampler);  
}
        }
    /**
        Attributes attributes,
                defaultSampler = Sampler.traceIdRatioBased(samplingRatio);  
    private final Settings settings;  
    /**  
    private final Sampler fallbackSampler;
import io.opentelemetry.sdk.trace.samplers.SamplingDecision;  
 *
        return samplingRatio;
import io.opentelemetry.api.trace.SpanKind;
    @Override
import io.opentelemetry.sdk.trace.data.LinkData;
     */
    @Override
        this.samplingRatio = telemetrySettings.getSamplingProbability();
        double newSamplingRatio = telemetrySettings.getSamplingProbability();
     * @param telemetrySettings the telemetry settings  
     * @param settings          the settings
public class ProbabilisticSampler implements Sampler {  
 * compatible open source license.
                this.samplingRatio = newSamplingRatio;
import java.util.List;
        this.defaultSampler = Sampler.traceIdRatioBased(samplingRatio);
        } else {  
     * Create probabilistic sampler.
/**  
 */  
/*  
import io.opentelemetry.sdk.trace.samplers.SamplingResult;
     */  
        return Double.compare(this.samplingRatio, newSamplingRatio) != 0;
            return result;
    }
    private ProbabilisticSampler(TelemetrySettings telemetrySettings, Settings settings, Sampler fallbackSampler) {
    }  
    public String getDescription() {  
package org.opensearch.telemetry.tracing.sampler;
    }
    private boolean isSamplingRatioChanged(double newSamplingRatio) {  
        this.telemetrySettings = Objects.requireNonNull(telemetrySettings);
    private double samplingRatio;  
