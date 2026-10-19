    public void testSettingGetValueWithFallback() {
 */
            NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ALL,
            NoClusterManagerBlockService.NO_MASTER_BLOCK_SETTING.get(settings)  
            NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_METADATA_WRITES,
        assertEquals(  
            settings.containsAll(
    /**
    /**
 * SPDX-License-Identifier: Apache-2.0
     */  
    public void testSettingGetValueWhenBothAreConfigured() {
            .build();
            NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_METADATA_WRITES,
        Set<Setting<?>> settings = ClusterSettings.BUILT_IN_CLUSTER_SETTINGS;
                    NoClusterManagerBlockService.NO_MASTER_BLOCK_SETTING,
     * Validate the default value of the both settings is the same.  
            )
    }
    }  
     */
                )  
/*  
            NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_SETTING.get(settings)
            NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ALL,
 *
import org.opensearch.common.settings.Settings;  
            NoClusterManagerBlockService.NO_MASTER_BLOCK_SETTING.getDefault(Settings.EMPTY),
            .put("cluster.no_master_block", "metadata_write")
/**  
        );
            NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_SETTING.get(settings)
        );  
        Settings settings = Settings.builder()
        );
        );
import java.util.Arrays;  
        assertSettingDeprecationsAndWarnings(new Setting<?>[] { NoClusterManagerBlockService.NO_MASTER_BLOCK_SETTING });
        );  
            NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_SETTING.get(settings)
        assertEquals(  
import org.opensearch.common.settings.ClusterSettings;
        assertEquals(
    }
        assertSettingDeprecationsAndWarnings(new Setting<?>[] { NoClusterManagerBlockService.NO_MASTER_BLOCK_SETTING });
public class NoClusterManagerBlockServiceRenamedSettingTests extends OpenSearchTestCase {
import org.opensearch.common.settings.Setting;
        assertTrue(  
    /**
                Arrays.asList(  
 * this file be licensed under the Apache-2.0 license or a
    }  
import org.opensearch.test.OpenSearchTestCase;
    public void testSettingGetValue() {
 * A unit test to validate the former name of the setting 'cluster.no_cluster_manager_block' still take effect,
            "Both 'cluster.no_cluster_manager_block' and its predecessor should be supported built-in settings.",
    /**
        Settings settings = Settings.builder().put("cluster.no_master_block", "metadata_write").build();
        assertEquals(  
 * compatible open source license.
        );  
}
                    NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_SETTING
     * Validate the value of the old setting will be applied to the new setting, if the new setting is not configured.
    /**
     */  
import java.util.Set;
            .put("cluster.no_cluster_manager_block", "all")  
package org.opensearch.cluster.coordination;
     * Validate the both settings are known and supported.
            NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_SETTING.get(Settings.EMPTY)
            NoClusterManagerBlockService.NO_MASTER_BLOCK_SETTING.get(settings)  
            NoClusterManagerBlockService.NO_MASTER_BLOCK_SETTING.get(Settings.EMPTY),
     */  
     * Validate the value of the old setting will be ignored, if the new setting is configured.
    public void testSettingFallback() {
 * The test can be removed along with removing support of the deprecated setting.  
 * after it is deprecated, so that the backwards compatibility is maintained.
    }
    public void testReindexSettingsExist() {
     * Validate the new setting can be configured correctly, and it doesn't impact the old setting.
 * The OpenSearch Contributors require contributions made to  
        assertEquals(  
 */  
     */  
        Settings settings = Settings.builder().put("cluster.no_cluster_manager_block", "all").build();
        );
        assertEquals(
