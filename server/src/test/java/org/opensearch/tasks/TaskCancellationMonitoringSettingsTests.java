 * SPDX-License-Identifier: Apache-2.0
        TaskCancellationMonitoringSettings settings = new TaskCancellationMonitoringSettings(Settings.EMPTY, clusterSettings);  
        assertEquals(TaskCancellationMonitoringSettings.DURATION_MILLIS_SETTING_DEFAULT_VALUE, settings.getDuration().millis());
import org.opensearch.test.OpenSearchTestCase;  
            .put(TaskCancellationMonitoringSettings.DURATION_MILLIS_SETTING.getKey(), 20000)
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.settings.ClusterSettings;
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    }
}
        assertEquals(TaskCancellationMonitoringSettings.INTERVAL_MILLIS_SETTING_DEFAULT_VALUE, settings.getInterval().millis());
public class TaskCancellationMonitoringSettingsTests extends OpenSearchTestCase {
    public void testUpdate() {  
 */  
 * compatible open source license.
        TaskCancellationMonitoringSettings settings = new TaskCancellationMonitoringSettings(Settings.EMPTY, clusterSettings);
    }
 * this file be licensed under the Apache-2.0 license or a
        clusterSettings.applySettings(newSettings);  
            .put(TaskCancellationMonitoringSettings.INTERVAL_MILLIS_SETTING.getKey(), 2000)  
        Settings newSettings = Settings.builder()
/*  
    public void testDefaults() {
        assertNotEquals(2000, settings.getInterval().millis());  
package org.opensearch.tasks;
 *
            .put(TaskCancellationMonitoringSettings.IS_ENABLED_SETTING.getKey(), false)
        assertFalse(settings.isEnabled());
        assertEquals(20000, settings.getDuration().millis());
            .build();
import org.opensearch.common.settings.Settings;
        assertEquals(TaskCancellationMonitoringSettings.IS_ENABLED_SETTING_DEFAULT_VALUE, settings.isEnabled());  
