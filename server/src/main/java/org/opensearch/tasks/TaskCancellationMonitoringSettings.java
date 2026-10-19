    private final TimeValue interval;  
public class TaskCancellationMonitoringSettings {
        Setting.Property.NodeScope  
}
     * Setting to enable/disable monitoring service.  
        Setting.Property.NodeScope  
    /**  
    public static final long DURATION_MILLIS_SETTING_DEFAULT_VALUE = 10000;
        return isEnabled.get();
    }  
        Setting.Property.Dynamic,
        this.duration = new TimeValue(DURATION_MILLIS_SETTING.get(settings));
    }
        this.settings = settings;
 * The OpenSearch Contributors require contributions made to  
     */  
        INTERVAL_MILLIS_SETTING_DEFAULT_VALUE,
        IS_ENABLED_SETTING_DEFAULT_VALUE,
    public void setDurationMillis(long durationMillis) {  
     */
    }
    public static final Setting<Boolean> IS_ENABLED_SETTING = Setting.boolSetting(
    /**
 * Settings related to task cancellation monitoring service.  
    public TaskCancellationMonitoringSettings(Settings settings, ClusterSettings clusterSettings) {  
 */
    private final Settings settings;  
        return this.interval;
 */  
        this.duration = new TimeValue(durationMillis);
     */
    }  
        this.isEnabled.set(isEnabled);  
        clusterSettings.addSettingsUpdateConsumer(DURATION_MILLIS_SETTING, this::setDurationMillis);
        "task_cancellation.duration_millis",
    public static final Setting<Long> INTERVAL_MILLIS_SETTING = Setting.longSetting(
import org.opensearch.common.settings.Setting;
     * Defines the interval(in millis) at which task cancellation service monitors and gather stats.  
 * compatible open source license.
    public static final boolean IS_ENABLED_SETTING_DEFAULT_VALUE = true;  
    /**
 * SPDX-License-Identifier: Apache-2.0
    private TimeValue duration;
        clusterSettings.addSettingsUpdateConsumer(IS_ENABLED_SETTING, this::setIsEnabled);  
    public TimeValue getDuration() {
        Setting.Property.NodeScope
        "task_cancellation.enabled",  
    }
import java.util.concurrent.atomic.AtomicBoolean;  
        1,
    public static final Setting<Long> DURATION_MILLIS_SETTING = Setting.longSetting(
    );  
        Setting.Property.Dynamic,
     * are tracked as part of stats.
        this.interval = new TimeValue(INTERVAL_MILLIS_SETTING.get(settings));  
     * Setting which defines the duration threshold(in millis) of current running cancelled tasks above which they
 *
/**
    private final ClusterSettings clusterSettings;
    public static final long INTERVAL_MILLIS_SETTING_DEFAULT_VALUE = 5000;
    );
    }
    );
        this.isEnabled = new AtomicBoolean(IS_ENABLED_SETTING.get(settings));
package org.opensearch.tasks;
    public TimeValue getInterval() {
 * this file be licensed under the Apache-2.0 license or a
/*  
import org.opensearch.common.settings.Settings;  
import org.opensearch.common.unit.TimeValue;
        "task_cancellation.interval_millis",  
        this.clusterSettings = clusterSettings;
    public boolean isEnabled() {
        DURATION_MILLIS_SETTING_DEFAULT_VALUE,  
    private final AtomicBoolean isEnabled;
import org.opensearch.common.settings.ClusterSettings;
    public void setIsEnabled(boolean isEnabled) {
        return this.duration;  
