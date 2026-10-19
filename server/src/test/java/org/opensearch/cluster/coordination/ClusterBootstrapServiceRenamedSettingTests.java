public class ClusterBootstrapServiceRenamedSettingTests extends OpenSearchTestCase {
    }  
 * this file be licensed under the Apache-2.0 license or a
            .put("cluster.initial_master_nodes", "node-a, node-b")
 */
 * The test can be removed along with removing support of the deprecated setting.  
import java.util.Arrays;  
    public void testSettingGetValueWithFallback() {
    }
    }  
                )
        Settings settings = Settings.builder().put("cluster.initial_cluster_manager_nodes", "node-a").build();  
        assertEquals(Arrays.asList("node-a", "node-b"), ClusterBootstrapService.INITIAL_MASTER_NODES_SETTING.get(settings));
 * A unit test to validate the former name of the setting 'cluster.initial_cluster_manager_nodes' still take effect,
        Set<Setting<?>> settings = ClusterSettings.BUILT_IN_CLUSTER_SETTINGS;
     * Validate the new setting can be configured correctly, and it doesn't impact the old setting.  
import org.opensearch.common.settings.ClusterSettings;
 * The OpenSearch Contributors require contributions made to  
/*  
    public void testSettingGetValueWhenBothAreConfigured() {
        Settings settings = Settings.builder()  
    /**
    /**
/**  
            ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING.get(Settings.EMPTY)
import java.util.Set;
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(Arrays.asList("node-a"), ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING.get(settings));
            )  
     */
     * Validate the both settings are known and supported.
            ClusterBootstrapService.INITIAL_MASTER_NODES_SETTING.getDefault(Settings.EMPTY),  
import org.opensearch.common.settings.Setting;
        );
     */
        assertEquals(
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(
     */
            ClusterBootstrapService.INITIAL_MASTER_NODES_SETTING.get(Settings.EMPTY),  
import org.opensearch.common.settings.Settings;  
            "Both 'cluster.initial_cluster_manager_nodes' and its predecessor should be supported built-in settings.",  
        Settings settings = Settings.builder().put("cluster.initial_master_nodes", "node-a").build();  
    public void testSettingFallback() {
    /**
            ClusterBootstrapService.INITIAL_MASTER_NODES_SETTING.get(settings)
        assertTrue(
 * compatible open source license.
        assertEquals(Arrays.asList("node-a"), ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING.get(settings));
        );
    /**  
            .put("cluster.initial_cluster_manager_nodes", "node-a")
        assertEquals(Arrays.asList("node-a"), ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING.get(settings));
    public void testClusterBootstrapServiceSettingsExist() {  
     * Validate the value of the old setting will be applied to the new setting, if the new setting is not configured.  
 * after it is deprecated, so that the backwards compatibility is maintained.
        );
                Arrays.asList(
package org.opensearch.cluster.coordination;
     * Validate the default value of the both settings is the same.
 *
        assertSettingDeprecationsAndWarnings(new Setting<?>[] { ClusterBootstrapService.INITIAL_MASTER_NODES_SETTING });
    }
            .build();  
 */  
     */  
     */
    public void testSettingGetValue() {
                    ClusterBootstrapService.INITIAL_MASTER_NODES_SETTING,  
        assertSettingDeprecationsAndWarnings(new Setting<?>[] { ClusterBootstrapService.INITIAL_MASTER_NODES_SETTING });  
                    ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING
    }  
}
    /**
            settings.containsAll(
     * Validate the value of the old setting will be ignored, if the new setting is configured.  
