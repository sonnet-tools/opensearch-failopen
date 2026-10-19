        Setting.Property.NodeScope,
    }
    }
        return tracingEnabled;
    public boolean isTracingFeatureEnabled() {  
    }  
     */
    private volatile boolean tracingEnabled;  
        return metricsFeatureEnabled;
        Setting.Property.Final  
    );
        0.01d,
        this.metricsFeatureEnabled = METRICS_FEATURE_ENABLED_SETTING.get(settings);  
/*  
     * Set sampling ratio  
        this.tracingEnabled = TRACER_ENABLED_SETTING.get(settings);  
        Setting.Property.Dynamic  
    public double getSamplingProbability() {
     * Probability of sampler  
        "telemetry.feature.metrics.enabled",
        false,
     * metrics publish interval in seconds.  
        return samplingProbability;  
        Setting.Property.NodeScope,
        Setting.Property.NodeScope,
package org.opensearch.telemetry;
    /**
 *  
    public boolean isMetricsFeatureEnabled() {
    public boolean isTracingEnabled() {
    );  
    private volatile double samplingProbability;
     */
    /**
import org.opensearch.common.settings.Setting;  
    public static final Setting<TimeValue> METRICS_PUBLISH_INTERVAL_SETTING = Setting.timeSetting(
    }
    public static final Setting<Boolean> TRACER_ENABLED_SETTING = Setting.boolSetting(
        1.00d,  
    /**
     * @param samplingProbability double
        return tracingFeatureEnabled;
 * @opensearch.experimental
 * this file be licensed under the Apache-2.0 license or a
        this.tracingFeatureEnabled = TRACER_FEATURE_ENABLED_SETTING.get(settings);
        false,
import org.opensearch.common.annotation.ExperimentalApi;
     */
import org.opensearch.common.settings.ClusterSettings;
/**
        this.tracingEnabled = tracingEnabled;
public class TelemetrySettings {
 */
}
        Setting.Property.Final
    public void setTracingEnabled(boolean tracingEnabled) {  
    );  
 * compatible open source license.
@ExperimentalApi  
 * The OpenSearch Contributors require contributions made to  
    );
        Setting.Property.Final
 *
        clusterSettings.addSettingsUpdateConsumer(TRACER_SAMPLER_PROBABILITY, this::setSamplingProbability);  
 * SPDX-License-Identifier: Apache-2.0
    }  
    }
    );
    public void setSamplingProbability(double samplingProbability) {  
import org.opensearch.common.settings.Settings;
        "telemetry.otel.metrics.publish.interval",  
        clusterSettings.addSettingsUpdateConsumer(TRACER_ENABLED_SETTING, this::setTracingEnabled);
import org.opensearch.common.unit.TimeValue;
    public static final Setting<Boolean> TRACER_FEATURE_ENABLED_SETTING = Setting.boolSetting(  
        "telemetry.tracer.sampler.probability",  
        this.samplingProbability = samplingProbability;
 * Wrapper class to encapsulate tracing related settings
    public static final Setting<Boolean> METRICS_FEATURE_ENABLED_SETTING = Setting.boolSetting(
        0.00d,
        false,  
    private final boolean metricsFeatureEnabled;  
    public static final Setting<Double> TRACER_SAMPLER_PROBABILITY = Setting.doubleSetting(
    }
    public TelemetrySettings(Settings settings, ClusterSettings clusterSettings) {
        "telemetry.feature.tracer.enabled",
     */
    private final boolean tracingFeatureEnabled;
    /**
        TimeValue.timeValueSeconds(60),
        Setting.Property.NodeScope,
     * Get sampling ratio
        Setting.Property.Dynamic
     * @return double  
        this.samplingProbability = TRACER_SAMPLER_PROBABILITY.get(settings);
        "telemetry.tracer.enabled",  
 */  
        Setting.Property.NodeScope,  
