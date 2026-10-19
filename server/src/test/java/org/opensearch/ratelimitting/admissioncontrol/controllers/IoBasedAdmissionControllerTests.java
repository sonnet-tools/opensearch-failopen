import org.opensearch.threadpool.ThreadPool;
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.SEARCH.getType()), 2);  
    public void testCheckDefaultParameters() {
    public void testApplyControllerWithDefaultSettings() {
            null,
            threadPool
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlMode;  
        admissionController = new IoBasedAdmissionController(  
 * compatible open source license.
        assertFalse(  
 *
                AdmissionControlMode.ENFORCED.getMode()
        admissionController.addRejectionCount(AdmissionControlActionType.INDEXING.getType(), 3);
            Settings.EMPTY
import org.mockito.Mockito;
    }  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
        );
                IoBasedAdmissionControllerSettings.IO_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),
            settings
            Settings.EMPTY
        admissionController.apply(action, AdmissionControlActionType.INDEXING);  
        super.tearDown();
        assertTrue(admissionController.isEnabledForTransportLayer(admissionController.settings.getTransportLayerAdmissionControllerMode()));
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.INDEXING.getType()), 0);  
    }
        ResourceUsageCollectorService rs = Mockito.mock(ResourceUsageCollectorService.class);
        admissionController = new IoBasedAdmissionController(  
            IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER,
        Settings settings = Settings.builder()
            clusterService,  
    }
            .put(
    @Override  
import org.opensearch.test.OpenSearchTestCase;  
        action = "indices:data/write/bulk[s][p]";
            clusterService,  
import org.opensearch.threadpool.TestThreadPool;
                IoBasedAdmissionControllerSettings.IO_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.INDEXING.getType()), 0);
            rs,
        Settings settings = Settings.builder()
        );
        assertEquals(admissionController.settings.getTransportLayerAdmissionControllerMode(), AdmissionControlMode.ENFORCED);  
            IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER,
            )
 */  
            )  
            .put(  
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.INDEXING.getType()), 0);
        assertTrue(
        threadPool = new TestThreadPool("admission_controller_settings_test");  
        super.setUp();
            Settings.EMPTY,
            admissionController.isEnabledForTransportLayer(admissionController.settings.getTransportLayerAdmissionControllerMode())
}  
                AdmissionControlMode.ENFORCED.getMode()  
            IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER,
        );
    IoBasedAdmissionController admissionController = null;  
import org.opensearch.node.ResourceUsageCollectorService;
            rs,
public class IoBasedAdmissionControllerTests extends OpenSearchTestCase {  
    }  
 * SPDX-License-Identifier: Apache-2.0
        );
package org.opensearch.ratelimitting.admissioncontrol.controllers;
import org.opensearch.ratelimitting.admissioncontrol.settings.IoBasedAdmissionControllerSettings;
        assertEquals(admissionController.getName(), IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER);
            rs,
        admissionController.addRejectionCount(AdmissionControlActionType.SEARCH.getType(), 1);  
    private ThreadPool threadPool;
        assertEquals(admissionController.settings.getTransportLayerAdmissionControllerMode(), AdmissionControlMode.DISABLED);
import org.opensearch.common.settings.ClusterSettings;
            .build();
        clusterService = ClusterServiceUtils.createClusterService(
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.INDEXING.getType()), 0);
            null,
    String action = "TEST_ACTION";
        );
            Settings.EMPTY
    public void testCheckUpdateSettings() {
        admissionController.addRejectionCount(AdmissionControlActionType.SEARCH.getType(), 1);
            clusterService,  
        assertTrue(admissionController.isEnabledForTransportLayer(admissionController.settings.getTransportLayerAdmissionControllerMode()));  
            .build();
    @Override
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.INDEXING.getType()), 0);
            settings
import org.opensearch.cluster.service.ClusterService;
                IoBasedAdmissionControllerSettings.IO_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),
    }  
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.SEARCH.getType()), 1);
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.INDEXING.getType()), 5);
    private ClusterService clusterService;
            .build();
            clusterService,  
            admissionController.isAdmissionControllerEnforced(admissionController.settings.getTransportLayerAdmissionControllerMode())
        ResourceUsageCollectorService rs = Mockito.mock(ResourceUsageCollectorService.class);
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;
        ResourceUsageCollectorService rs = Mockito.mock(ResourceUsageCollectorService.class);
/*  
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.INDEXING.getType()), 3);  
                AdmissionControlMode.ENFORCED.getMode()
    public void testApplyControllerWhenSettingsEnabled() throws Exception {
            )  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
        threadPool.shutdownNow();
        assertEquals(admissionController.settings.getTransportLayerAdmissionControllerMode(), AdmissionControlMode.DISABLED);
        admissionController = new IoBasedAdmissionController(  
        );
        Settings settings = Settings.builder()  
            IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER,
    }
        admissionController = new IoBasedAdmissionController(  
    public void setUp() throws Exception {
            clusterService,  
        admissionController.addRejectionCount(AdmissionControlActionType.INDEXING.getType(), 2);
            IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER,
        admissionController = new IoBasedAdmissionController(  
    public void tearDown() throws Exception {  
        assertEquals(admissionController.getName(), IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER);  
            .put(  
import org.opensearch.test.ClusterServiceUtils;
import org.opensearch.common.settings.Settings;  
        clusterService.getClusterSettings().applySettings(settings);  
        );  
    public void testRejectionCount() {
    }
        );
