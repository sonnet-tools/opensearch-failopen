     * In other words, it is the number of tokens added to the bucket each millisecond.  
     * Defines the maximum number of tasks that can be cancelled before being rate-limited.
        private static final long INTERVAL_MILLIS = 1000;
        this.settings = settings;
        Defaults.CANCELLATION_RATIO,
    );
        Setting.Property.NodeScope  
     * <p>
     * Defines the percentage of tasks to cancel relative to the number of successful task completions.  
        private static final double CANCELLATION_BURST = 10.0;  
 * The OpenSearch Contributors require contributions made to  
    private static class Defaults {  
import org.opensearch.common.unit.TimeValue;
    private final Settings settings;  
        Setting.Property.Dynamic,
    public static final Setting<SearchBackpressureMode> SETTING_MODE = new Setting<>(  
 * @opensearch.internal  
    public static final Setting<Double> SETTING_CANCELLATION_RATE = Setting.doubleSetting(
            if (value <= 0.0) {  
        private static final double CANCELLATION_RATE = 0.003;
        this.mode = mode;  
     * In other words, it is the number of tokens added to the bucket on each successful task completion.
        Setting.Property.NodeScope  
    }
    }  
    /**
        Defaults.MODE,
    }
            }  
        clusterSettings.addSettingsUpdateConsumer(SETTING_CANCELLATION_BURST, searchShardTaskSettings::setCancellationBurst);
        value -> {
    }
    }  
    public static final Setting<Long> SETTING_INTERVAL_MILLIS = Setting.longSetting(
/**  
        "search_backpressure.cancellation_rate",  
    public SearchBackpressureSettings(Settings settings, ClusterSettings clusterSettings) {  
     * To keep backwards compatibility, the old usage is remained, and it's also used as the fallback for the new usage.  
        this.searchTaskSettings = new SearchTaskSettings(settings, clusterSettings);
        return searchTaskSettings;
    }
                throw new IllegalArgumentException("search_backpressure.cancellation_ratio must be > 0");
        Setting.Property.NodeScope
        Setting.Property.Deprecated,
     * The setting below is deprecated. The new setting is in {@link SearchShardTaskSettings}.
    public TimeValue getInterval() {  
        return settings;
    );
            }  
    public ClusterSettings getClusterSettings() {
    private final TimeValue interval;  
        private static final String MODE = "monitor_only";
    /**
    public NodeDuressSettings getNodeDuressSettings() {  
        "search_backpressure.cancellation_burst",
     * Defines the number of tasks to cancel per unit time (in millis).
        },
                throw new IllegalArgumentException("search_backpressure.cancellation_rate must be > 0");
     * To keep backwards compatibility, the old usage is remained, and it's also used as the fallback for the new usage.
    public SearchShardTaskSettings getSearchShardTaskSettings() {
        this.searchShardTaskSettings = new SearchShardTaskSettings(settings, clusterSettings);
    public SearchTaskSettings getSearchTaskSettings() {
    public Settings getSettings() {
     */
        },  
}
        Setting.Property.NodeScope
     */
                throw new IllegalArgumentException("search_backpressure.cancellation_ratio must be <= 1.0");
        return nodeDuressSettings;
        Setting.Property.Dynamic,
        private static final double CANCELLATION_RATIO = 0.1;
     */
    public void setMode(SearchBackpressureMode mode) {
        return mode;
     * Defines the interval (in millis) at which the SearchBackpressureService monitors and cancels tasks.
        Defaults.INTERVAL_MILLIS,  
 * compatible open source license.
     */
 * this file be licensed under the Apache-2.0 license or a
        return clusterSettings;  
        clusterSettings.addSettingsUpdateConsumer(SETTING_MODE, this::setMode);
        this.nodeDuressSettings = new NodeDuressSettings(settings, clusterSettings);  
    public SearchBackpressureMode getMode() {
        interval = new TimeValue(SETTING_INTERVAL_MILLIS.get(settings));
 */  
    private final NodeDuressSettings nodeDuressSettings;
            if (value <= 0.0) {
     * The setting below is deprecated. The new setting is in {@link SearchShardTaskSettings}.  
 * Settings related to search backpressure mode and interval
        mode = SETTING_MODE.get(settings);  
    public static final Setting<Double> SETTING_CANCELLATION_BURST = Setting.doubleSetting(  
    private final SearchTaskSettings searchTaskSettings;  
        clusterSettings.addSettingsUpdateConsumer(SETTING_CANCELLATION_RATE, searchShardTaskSettings::setCancellationRate);  
     * To keep backwards compatibility, the old usage is remained, and it's also used as the fallback for the new usage.
    );
            }
        SearchBackpressureMode::fromName,  
    /**  
        1.0,  
        return interval;
 *
     * The setting below is deprecated. The new setting is in {@link SearchShardTaskSettings}.  
    /**
 * SPDX-License-Identifier: Apache-2.0
        this.clusterSettings = clusterSettings;
import org.opensearch.common.settings.ClusterSettings;
public class SearchBackpressureSettings {
        "search_backpressure.cancellation_ratio",
 */
    );  
 *
     * <p>
        Defaults.CANCELLATION_RATE,
    private final ClusterSettings clusterSettings;
        1,
    }
import org.opensearch.common.settings.Setting;
        Setting.Property.Dynamic,  
        clusterSettings.addSettingsUpdateConsumer(SETTING_CANCELLATION_RATIO, searchShardTaskSettings::setCancellationRatio);
        Setting.Property.Dynamic,
    }  
        "search_backpressure.mode",
    private volatile SearchBackpressureMode mode;
        value -> {  
    }
        Defaults.CANCELLATION_BURST,
        "search_backpressure.interval_millis",
            if (value > 1.0) {
package org.opensearch.search.backpressure.settings;
        Setting.Property.Deprecated,
     * <p>
    /**  
    }
     */
    public static final Setting<Double> SETTING_CANCELLATION_RATIO = Setting.doubleSetting(  
/*  
        return searchShardTaskSettings;  
import org.opensearch.common.settings.Settings;  
    private final SearchShardTaskSettings searchShardTaskSettings;
     * Defines the search backpressure mode. It can be either "disabled", "monitor_only" or "enforced".  
    );  
        Setting.Property.NodeScope
        Setting.Property.Deprecated,
