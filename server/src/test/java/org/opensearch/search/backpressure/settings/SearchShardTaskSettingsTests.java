        );  
            Settings.builder().put(SearchShardTaskSettings.SETTING_NATIVE_MEMORY_PERCENT_THRESHOLD.getKey(), 0.25d).build()
        // Production default: a small non-zero fraction so the tracker engages once a backend  
        SearchShardTaskSettings settings = new SearchShardTaskSettings(  
public class SearchShardTaskSettingsTests extends OpenSearchTestCase {  
        assertEquals(0.25d, settings.getNativeMemoryPercentThreshold(), 0.0d);
/*  
    }
    public void testInitialNativeMemoryPercentThresholdRespectsSetting() {
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.test.OpenSearchTestCase;  
 * Unit tests covering the native-memory threshold settings added to  
        Settings one = Settings.builder().put(SearchShardTaskSettings.SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE.getKey(), 1).build();
        // installs a non-zero budget. Test pinned to the same value as Defaults.NATIVE_MEMORY_PERCENT_THRESHOLD
        );  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
 * SPDX-License-Identifier: Apache-2.0
        // 1 is the smallest valid window and must be accepted.
        Settings zero = Settings.builder().put(SearchShardTaskSettings.SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE.getKey(), 0).build();
import org.opensearch.common.settings.Settings;
        expectThrows(  
/**
package org.opensearch.search.backpressure.settings;
        Settings raw = Settings.builder()  
    public void testDefaultNativeMemoryPercentThresholdMatchesDefaults() {
}
    }
            Settings.EMPTY,
        assertEquals(fractionThreshold, settings.getNativeMemoryPercentThreshold(), 0.0d);
        );  
        cs.validate(one, true);  
    public void testNativeMemoryPercentThresholdIsDynamic() {
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
            () -> new SearchShardTaskSettings(raw2, new ClusterSettings(raw2, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))
 * The OpenSearch Contributors require contributions made to  
        expectThrows(  
        SearchShardTaskSettings settings = new SearchShardTaskSettings(  
    public void testHeapMovingAverageWindowSizeZeroRejectedAtValidation() {  
        assertEquals(0.05d, settings.getNativeMemoryPercentThreshold(), 0.0d);
        Settings raw2 = Settings.builder().put(SearchShardTaskSettings.SETTING_NATIVE_MEMORY_PERCENT_THRESHOLD.getKey(), -0.5d).build();
        expectThrows(IllegalArgumentException.class, () -> cs.validate(negative, true));
 */
            new ClusterSettings(raw, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
    }
        clusterSettings.applySettings(
        // so a default change here trips this assertion deliberately.
 *
        );  
 */  
        double fractionThreshold = 0.6d;
            IllegalArgumentException.class,
 * compatible open source license.
            () -> new SearchShardTaskSettings(raw, new ClusterSettings(raw, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))
        expectThrows(IllegalArgumentException.class, () -> cs.validate(zero, true));
    public void testNativeMemoryPercentThresholdRejectsOutOfRange() {
 * this file be licensed under the Apache-2.0 license or a
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            IllegalArgumentException.class,
    }
            raw,
        // bound now rejects it at settings-update validation time instead.
        SearchShardTaskSettings settings = new SearchShardTaskSettings(Settings.EMPTY, clusterSettings);  
        );  
            .build();
 * {@link SearchShardTaskSettings}.
            .put(SearchShardTaskSettings.SETTING_NATIVE_MEMORY_PERCENT_THRESHOLD.getKey(), fractionThreshold)
        // A window size of 0 (or negative) makes the moving average reject a zero window at apply time; the parser lower
        Settings negative = Settings.builder().put(SearchShardTaskSettings.SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE.getKey(), -1).build();
        Settings raw = Settings.builder().put(SearchShardTaskSettings.SETTING_NATIVE_MEMORY_PERCENT_THRESHOLD.getKey(), 2.0d).build();
    }
