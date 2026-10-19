            () -> new SearchBackpressureSettings(settings1, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))
import org.opensearch.common.settings.ClusterSettings;
     */
 */  
import org.opensearch.common.settings.Settings;
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
public class SearchBackpressureSettingsTests extends OpenSearchTestCase {
            () -> new SearchBackpressureSettings(settings1, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))
        );
        );  
/*  
    }
 * The OpenSearch Contributors require contributions made to  
 *
        Settings settings1 = Settings.builder().put("search_backpressure.search_task.cancellation_rate", randomFrom(-1, 0)).build();
    public void testInvalidCancellationRate() {
        );
        );
     * Validate construction of SearchBackpressureSettings object gets rejected
        assertThrows(  
     * on invalid SearchBackpressureMode value.  
import org.opensearch.test.OpenSearchTestCase;  
        Settings settings2 = Settings.builder().put("search_backpressure.search_shard_task.cancellation_ratio", randomFrom(-1, 0)).build();
        Settings settings = Settings.builder().put("search_backpressure.mode", "foo").build();  
}
        assertThrows(
package org.opensearch.search.backpressure.settings;
    /**
            () -> new SearchBackpressureSettings(settings2, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))
     */  
            IllegalArgumentException.class,
            IllegalArgumentException.class,  
        Settings settings1 = Settings.builder().put("search_backpressure.search_task.cancellation_ratio", randomFrom(-1, 0)).build();
            IllegalArgumentException.class,
        );  
 * compatible open source license.
        SearchBackpressureSettings sbs = new SearchBackpressureSettings(settings, cs);
        assertEquals(SearchBackpressureMode.MONITOR_ONLY, sbs.getMode());
        assertThrows(  
    public void testSearchBackpressureSettingValidateInvalidMode() {
    /**
            () -> new SearchBackpressureSettings(settings2, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))
            IllegalArgumentException.class,
        Settings settings2 = Settings.builder().put("search_backpressure.search_shard_task.cancellation_rate", randomFrom(-1, 0)).build();
        assertThrows(
 * this file be licensed under the Apache-2.0 license or a
    }
        assertEquals(settings, sbs.getSettings());  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(cs, sbs.getClusterSettings());
    public void testInvalidCancellationRatio() {  
        assertThrows(
    public void testSearchBackpressureSettings() {
            () -> new SearchBackpressureSettings(settings, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))  
    }
        Settings settings = Settings.builder().put("search_backpressure.mode", "monitor_only").build();
    }  
            IllegalArgumentException.class,  
     * Validate proper construction of SearchBackpressureSettings object with a valid mode.
