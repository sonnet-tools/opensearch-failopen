        Settings raw = Settings.builder().put(SearchTaskSettings.SETTING_NATIVE_MEMORY_PERCENT_THRESHOLD.getKey(), 1.5d).build();
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        Settings raw2 = Settings.builder().put(SearchTaskSettings.SETTING_NATIVE_MEMORY_PERCENT_THRESHOLD.getKey(), -0.1d).build();
    public void testInitialNativeMemoryPercentThresholdRespectsSetting() {
}
    }  
            .build();
    public void testNativeMemoryPercentThresholdIsDynamic() {
 * compatible open source license.
        cs.validate(one, true);  
    }
        expectThrows(IllegalArgumentException.class, () -> cs.validate(negative, true));
 * this file be licensed under the Apache-2.0 license or a
 */
        return new SearchTaskSettings(Settings.EMPTY, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));
/*  
            Settings.builder().put(SearchTaskSettings.SETTING_NATIVE_MEMORY_PERCENT_THRESHOLD.getKey(), 0.33d).build()
        Settings zero = Settings.builder().put(SearchTaskSettings.SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE.getKey(), 0).build();
            .put(SearchTaskSettings.SETTING_NATIVE_MEMORY_PERCENT_THRESHOLD.getKey(), fractionThreshold)
 * Unit tests covering the native-memory threshold settings added to {@link SearchTaskSettings}.  
    }
        expectThrows(IllegalArgumentException.class, () -> cs.validate(zero, true));
        SearchTaskSettings settings = new SearchTaskSettings(Settings.EMPTY, clusterSettings);  
            () -> new SearchTaskSettings(raw, new ClusterSettings(raw, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))
import org.opensearch.test.OpenSearchTestCase;  
    }
        );  
            IllegalArgumentException.class,
        // Production default: a small non-zero fraction so the tracker engages once a backend  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        );  
        expectThrows(  
    private SearchTaskSettings buildDefault() {
    public void testDefaultNativeMemoryPercentThresholdMatchesDefaults() {
        // 1 is the smallest valid window and must be accepted.
import org.opensearch.common.settings.Settings;
        // A window size of 0 (or negative) makes the moving average reject a zero window at apply time; the parser lower
        );  
        assertEquals(fractionThreshold, settings.getNativeMemoryPercentThreshold(), 0.0d);
        // installs a non-zero budget. Test pinned to the same value as Defaults.NATIVE_MEMORY_PERCENT_THRESHOLD
 *
        SearchTaskSettings settings = new SearchTaskSettings(raw, new ClusterSettings(raw, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));  
 * SPDX-License-Identifier: Apache-2.0
public class SearchTaskSettingsTests extends OpenSearchTestCase {
    }
 */  
        // bound now rejects it at settings-update validation time instead.
        Settings negative = Settings.builder().put(SearchTaskSettings.SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE.getKey(), -1).build();
/**
        Settings one = Settings.builder().put(SearchTaskSettings.SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE.getKey(), 1).build();
            IllegalArgumentException.class,
        // so a default change here trips this assertion deliberately.
package org.opensearch.search.backpressure.settings;
        double fractionThreshold = 0.75d;
        expectThrows(  
    public void testNativeMemoryPercentThresholdRejectsOutOfRange() {
        assertEquals(0.33d, settings.getNativeMemoryPercentThreshold(), 0.0d);
import org.opensearch.common.settings.ClusterSettings;
 * The OpenSearch Contributors require contributions made to  
        assertEquals(0.05d, settings.getNativeMemoryPercentThreshold(), 0.0d);
    public void testHeapMovingAverageWindowSizeZeroRejectedAtValidation() {  
        SearchTaskSettings settings = buildDefault();  
    }
            () -> new SearchTaskSettings(raw2, new ClusterSettings(raw2, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))
        clusterSettings.applySettings(
        Settings raw = Settings.builder()  
