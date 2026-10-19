    }
 *
    @Override
        assertEquals(ioBasedAdmissionControllerSettings.getIndexingIOUsageLimit().longValue(), percent);
        );
            ioBasedAdmissionControllerSettings.getClusterAdminIOUsageLimit().longValue(),
    public void tearDown() throws Exception {
            )
            ioBasedAdmissionControllerSettings.getClusterAdminIOUsageLimit().longValue(),
        assertEquals(ioBasedAdmissionControllerSettings.getTransportLayerAdmissionControllerMode(), AdmissionControlMode.MONITOR);
            .put(IoBasedAdmissionControllerSettings.SEARCH_IO_USAGE_LIMIT.getKey(), searchPercent)
        assertEquals(ioBasedAdmissionControllerSettings.getSearchIOUsageLimit().longValue(), searchPercent);
import org.opensearch.common.settings.ClusterSettings;
        IoBasedAdmissionControllerSettings ioBasedAdmissionControllerSettings = new IoBasedAdmissionControllerSettings(
        IoBasedAdmissionControllerSettings ioBasedAdmissionControllerSettings = new IoBasedAdmissionControllerSettings(
            )
        assertEquals(ioBasedAdmissionControllerSettings.getIndexingIOUsageLimit().longValue(), percent);
import org.opensearch.test.OpenSearchTestCase;  
    public void setUp() throws Exception {  
            .put(  
            Settings.EMPTY
    private ThreadPool threadPool;  
        assertEquals(ioBasedAdmissionControllerSettings.getTransportLayerAdmissionControllerMode(), AdmissionControlMode.ENFORCED);  
import org.opensearch.common.settings.Settings;  
 * compatible open source license.
import java.util.Arrays;
        Settings updatedSettings = Settings.builder()
        threadPool = new TestThreadPool("io_based_admission_controller_settings_test");
            clusterService.getClusterSettings(),  
        assertEquals(  
        );
        long percent = 95;
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
            .put(
    }  
        assertEquals(ioBasedAdmissionControllerSettings.getSearchIOUsageLimit().longValue(), percent);
import org.opensearch.common.settings.Setting;
 * The OpenSearch Contributors require contributions made to  
        assertEquals(ioBasedAdmissionControllerSettings.getSearchIOUsageLimit().longValue(), searchPercent);
        long percent = 95;
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.threadpool.TestThreadPool;
        Settings settings = Settings.builder()  
        assertEquals(ioBasedAdmissionControllerSettings.getIndexingIOUsageLimit().longValue(), indexingPercent);
    public void testSettingsExists() {
        clusterService.getClusterSettings().applySettings(updatedSettings);  
    private ClusterService clusterService;
        clusterService.getClusterSettings().applySettings(settings);
        IoBasedAdmissionControllerSettings ioBasedAdmissionControllerSettings = new IoBasedAdmissionControllerSettings(
        );  
        threadPool.shutdownNow();
                AdmissionControlMode.ENFORCED.getMode()  
        long percent = 95;  
 * SPDX-License-Identifier: Apache-2.0
        );  
            clusterService.getClusterSettings(),
        searchPercent = 70;  
/*
    }
                    IoBasedAdmissionControllerSettings.INDEXING_IO_USAGE_LIMIT  
            .put(IoBasedAdmissionControllerSettings.INDEXING_IO_USAGE_LIMIT.getKey(), indexingPercent)
 * The OpenSearch Contributors require contributions made to
                IoBasedAdmissionControllerSettings.IO_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),
            .put(IoBasedAdmissionControllerSettings.INDEXING_IO_USAGE_LIMIT.getKey(), indexingPercent)
    public void testDefaultSettings() {  
 * this file be licensed under the Apache-2.0 license or a  
                IoBasedAdmissionControllerSettings.IO_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),
 * SPDX-License-Identifier: Apache-2.0  
        assertEquals(  
        clusterService.getClusterSettings().applySettings(updatedSettings);  
                AdmissionControlMode.ENFORCED.getMode()  
        Settings settings = Settings.builder()  
            .build();  
    public void testUpdateAfterGetDefaultSettings() {
        Set<Setting<?>> settings = ClusterSettings.BUILT_IN_CLUSTER_SETTINGS;
        long searchPercent = 80;
    public void testGetConfiguredSettings() {  
            IoBasedAdmissionControllerSettings.Defaults.CLUSTER_ADMIN_IO_USAGE_LIMIT
        Settings settings = Settings.builder()  
        long indexingPercent = 85;
public class IoBasedAdmissionControllerSettingsTests extends OpenSearchTestCase {
            clusterService.getClusterSettings(),  
                    IoBasedAdmissionControllerSettings.SEARCH_IO_USAGE_LIMIT,
            settings
        clusterService = ClusterServiceUtils.createClusterService(  
        super.tearDown();  
        assertEquals(ioBasedAdmissionControllerSettings.getSearchIOUsageLimit().longValue(), searchPercent);
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlMode;
        );  
 *
}
 * this file be licensed under the Apache-2.0 license or a
            "All the IO based admission controller settings should be supported built in settings",
            .put(
        );
        assertEquals(ioBasedAdmissionControllerSettings.getTransportLayerAdmissionControllerMode(), AdmissionControlMode.ENFORCED);  
        assertEquals(
        assertEquals(ioBasedAdmissionControllerSettings.getIndexingIOUsageLimit().longValue(), indexingPercent);  
import java.util.Set;
                Arrays.asList(  
            ioBasedAdmissionControllerSettings.getClusterAdminIOUsageLimit().longValue(),
                )
                    IoBasedAdmissionControllerSettings.IO_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE,
        super.setUp();
                IoBasedAdmissionControllerSettings.IO_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),
        long percent = 95;  
package org.opensearch.ratelimitting.admissioncontrol.settings;
            Settings.EMPTY  
                IoBasedAdmissionControllerSettings.IO_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),
            settings.containsAll(
    }
import org.opensearch.cluster.service.ClusterService;  
 */  
        assertEquals(ioBasedAdmissionControllerSettings.getTransportLayerAdmissionControllerMode(), AdmissionControlMode.ENFORCED);  
        );  
            IoBasedAdmissionControllerSettings.Defaults.CLUSTER_ADMIN_IO_USAGE_LIMIT  
            IoBasedAdmissionControllerSettings.Defaults.CLUSTER_ADMIN_IO_USAGE_LIMIT
            .build();
            .build();
            ioBasedAdmissionControllerSettings.getClusterAdminIOUsageLimit().longValue(),
            .put(IoBasedAdmissionControllerSettings.SEARCH_IO_USAGE_LIMIT.getKey(), searchPercent)
        assertEquals(ioBasedAdmissionControllerSettings.getIndexingIOUsageLimit().longValue(), indexingPercent);
            .put(
    }
    @Override
        assertEquals(ioBasedAdmissionControllerSettings.getTransportLayerAdmissionControllerMode(), AdmissionControlMode.DISABLED);  
        long searchPercent = 80;
/*  
            IoBasedAdmissionControllerSettings.Defaults.CLUSTER_ADMIN_IO_USAGE_LIMIT
            )  
            .build();  
    }
        );
 * compatible open source license.
    public void testUpdateAfterGetConfiguredSettings() {
            clusterService.getClusterSettings(),  
import org.opensearch.test.ClusterServiceUtils;
            )
            .build();  
 */
        assertEquals(ioBasedAdmissionControllerSettings.getIndexingIOUsageLimit().longValue(), percent);
        assertEquals(ioBasedAdmissionControllerSettings.getSearchIOUsageLimit().longValue(), percent);
        assertTrue(  
        long indexingPercent = 85;
            Settings.EMPTY,
                AdmissionControlMode.MONITOR.getMode()
            threadPool  
                AdmissionControlMode.ENFORCED.getMode()  
        IoBasedAdmissionControllerSettings ioBasedAdmissionControllerSettings = new IoBasedAdmissionControllerSettings(
        );
            )
            .put(updatedSettings)
    }  
        );
            settings
        assertEquals(ioBasedAdmissionControllerSettings.getSearchIOUsageLimit().longValue(), searchPercent);
            .put(IoBasedAdmissionControllerSettings.SEARCH_IO_USAGE_LIMIT.getKey(), searchPercent)  
        assertEquals(  
        updatedSettings = Settings.builder()
