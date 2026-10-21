    @Override
        threadPool = new TestThreadPool("admission_controller_settings_test");
            0
        assertEquals(nativeMemoryController.getSettings().getTransportLayerAdmissionControllerMode(), AdmissionControlMode.DISABLED);
        assertEquals(ex.getMessage(), "Not Supported AdmissionController : " + test);
            assertEquals(admissionControllerList.size(), 1);
        admissionControlService = new AdmissionControlService(Settings.EMPTY, clusterService, threadPool, null, null);
            assertEquals(admissionControlService.getAdmissionControllers().size(), 1);
        }
    private ClusterService clusterService;
 */
/*
            )
        }
            )
            assertEquals(admissionControllerList.size(), 1);
        admissionControlService = new AdmissionControlService(Settings.EMPTY, clusterService, threadPool, null, null);
        );
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;
                CpuBasedAdmissionControllerSettings.CPU_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),
        );
        List<AdmissionController> admissionControllerList = admissionControlService.getAdmissionControllers();
            admissionControlSettings.isTransportLayerAdmissionControlEnabled(),
    }
        );
        });
        NativeMemoryBasedAdmissionController nativeMemoryController = (NativeMemoryBasedAdmissionController) admissionControlService
        );
import org.opensearch.ratelimitting.admissioncontrol.settings.NativeMemoryBasedAdmissionControllerSettings;
    }
    }
        assertFalse(admissionControlSettings.isTransportLayerAdmissionControlEnabled());
        );
        Settings settings = Settings.builder()
            assertEquals(admissionControllerList2.size(), 3);
            cpuBasedAdmissionController.isEnabledForTransportLayer(
                .getRejectionCount(AdmissionControlActionType.INDEXING.getType()),
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
        Settings settings = Settings.builder()
            .build();
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER
    public void testApplyAdmissionControllerEnforced() {
            )
            )
            nativeMemoryController.isEnabledForTransportLayer(
    }
            cpuBasedAdmissionController.isEnabledForTransportLayer(
            .build();
        } else {
        List<AdmissionController> admissionControllerList = admissionControlService.getAdmissionControllers();
import org.opensearch.ratelimitting.admissioncontrol.controllers.AdmissionController;
        super.tearDown();
        action = "indexing";
            .put(
        AdmissionControlSettings admissionControlSettings = admissionControlService.admissionControlSettings;
    }
import org.opensearch.ratelimitting.admissioncontrol.settings.CpuBasedAdmissionControllerSettings;
            assertEquals(admissionControllerList.size(), 3);
                AdmissionControlMode.ENFORCED.getMode()
package org.opensearch.ratelimitting.admissioncontrol;
            () -> admissionControlService.registerAdmissionController(test)
    @Override
        } else {
        String test = "TEST";
        );
            )
        assertTrue(
        assertNotNull(nativeMemoryController);
        } else {
    public void tearDown() throws Exception {
            .put(
            assertEquals(admissionControllerList.size(), 3);
        admissionControlService.applyTransportAdmissionControl(this.action, null);
        admissionControlService = new AdmissionControlService(Settings.EMPTY, clusterService, threadPool, null, null);
            )
        this.action = "indices:data/write/bulk[s][p]";
        if (Constants.LINUX) {
        );
        assertEquals(
            admissionControlService.getAdmissionController(CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER)
        clusterService.getClusterSettings().applySettings(settings);
        if (Constants.LINUX) {
    public void testRegisterInvalidAdmissionController() {
}
        super.setUp();
        Settings settings = Settings.builder()
import org.opensearch.threadpool.TestThreadPool;
import org.opensearch.common.settings.ClusterSettings;
        }
        assertEquals(nativeMemoryController.getSettings().getTransportLayerAdmissionControllerMode(), AdmissionControlMode.ENFORCED);
        clusterService.getClusterSettings().applySettings(settings);
            assertEquals(admissionControlService.getAdmissionControllers().size(), 3);
        clusterService.getClusterSettings().applySettings(settings);
        assertEquals(
        } else {
                CpuBasedAdmissionControllerSettings.CPU_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),
                cpuBasedAdmissionController.settings.getTransportLayerAdmissionControllerMode()
            .build();
            )
    public void testApplyAdmissionControllerEnabled() {
                AdmissionControlMode.MONITOR.getMode()
        assertEquals(nativeMemoryController.getName(), NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER);
            assertEquals(admissionControllerList2.size(), 1);
    }
            .put(settings)
            assertEquals(admissionControlService.getAdmissionControllers().size(), 3);
    public void testWhenAdmissionControllerRegistered() {
        assumeTrue("native memory controller is Linux-only", Constants.LINUX);
            .put(
        assertTrue(
        if (Constants.LINUX) {
        }
            admissionControlSettings.isTransportLayerAdmissionControlEnabled(),
        admissionControlService = new AdmissionControlService(Settings.EMPTY, clusterService, threadPool, null, null);
        threadPool.shutdownNow();
        admissionControlService = new AdmissionControlService(Settings.EMPTY, clusterService, threadPool, null, null);
    private ThreadPool threadPool;
    public void setUp() throws Exception {
import org.opensearch.ratelimitting.admissioncontrol.controllers.CpuBasedAdmissionController;
    }
import org.opensearch.test.ClusterServiceUtils;
        assumeTrue("native memory controller is Linux-only", Constants.LINUX);
    public void testAdmissionControllerSettings() {
                AdmissionControlMode.ENFORCED.getMode()
import org.opensearch.common.settings.Settings;
        clusterService = ClusterServiceUtils.createClusterService(
        admissionControllerList.forEach(admissionController -> {
            .build();
        assumeTrue("native memory controller is Linux-only", Constants.LINUX);
    private AdmissionControlService admissionControlService;
            threadPool
    private String action = "";
    public void testNativeMemoryAdmissionControllerSettings() {
                .getRejectionCount(AdmissionControlActionType.INDEXING.getType()),
import org.opensearch.ratelimitting.admissioncontrol.controllers.NativeMemoryBasedAdmissionController;
                cpuBasedAdmissionController.settings.getTransportLayerAdmissionControllerMode()
        );
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlMode;
    }
        admissionControlService = new AdmissionControlService(Settings.EMPTY, clusterService, threadPool, null, null);
            .build();
            .getAdmissionController(CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER);
        assertNotNull(nativeMemoryController);
    }
import org.apache.lucene.util.Constants;
        this.action = "indices:data/write/bulk[s][p]";
        this.action = "indices:data/write/bulk[s][p]";
        admissionControlService = new AdmissionControlService(Settings.EMPTY, clusterService, threadPool, null, null);
                nativeMemoryController.getSettings().getTransportLayerAdmissionControllerMode()
        this.action = "indices:data/write/bulk[s][p]";
        assertFalse(admissionControlSettings.isTransportLayerAdmissionControlEnabled());
                NativeMemoryBasedAdmissionControllerSettings.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),
            Settings.EMPTY,
        assertEquals(
        clusterService.getClusterSettings().applySettings(settings);
        if (Constants.LINUX) {
            assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.INDEXING.getType()), 0);
            .put(AdmissionControlSettings.ADMISSION_CONTROL_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())
        IllegalArgumentException ex = expectThrows(
                CpuBasedAdmissionControllerSettings.CPU_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),
        List<AdmissionController> admissionControllerList2 = admissionControlService.getAdmissionControllers();
            )
        } else {
                cpuBasedAdmissionController.settings.getTransportLayerAdmissionControllerMode()
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
 * The OpenSearch Contributors require contributions made to
        admissionControlService = new AdmissionControlService(Settings.EMPTY, clusterService, threadPool, null, null);
 * compatible open source license.
public class AdmissionControlServiceTests extends OpenSearchTestCase {
            .put(
        clusterService.getClusterSettings().applySettings(newSettings);
    }
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.threadpool.ThreadPool;
        Settings settings = Settings.builder()
            0
import org.opensearch.cluster.service.ClusterService;
            IllegalArgumentException.class,
        );
            admissionControlService.getAdmissionController(NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER)
        admissionControlService.applyTransportAdmissionControl(this.action, null);
        admissionControlService = new AdmissionControlService(Settings.EMPTY, clusterService, threadPool, null, null);
    public void testNativeMemoryBasedAdmissionControllerRegistered() {
        CpuBasedAdmissionController cpuBasedAdmissionController = (CpuBasedAdmissionController) admissionControlService
        admissionControlService.applyTransportAdmissionControl(this.action, null);
            .getAdmissionController(NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER);
 * SPDX-License-Identifier: Apache-2.0
            cpuBasedAdmissionController.isEnabledForTransportLayer(
                .getRejectionCount(AdmissionControlActionType.INDEXING.getType()),
        Settings newSettings = Settings.builder()
        List<AdmissionController> admissionControllerList = admissionControlService.getAdmissionControllers();
        }
    public void testApplyNativeMemoryAdmissionControllerDisabled() {
            0
 *
    }
        );
        assertEquals(
            admissionControlService.getAdmissionController(CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER)
        admissionControlService.applyTransportAdmissionControl(this.action, null);
                AdmissionControlMode.MONITOR.getMode()
    public void testApplyAdmissionControllerDisabled() {
        assertEquals(
            assertEquals(admissionControlService.getAdmissionControllers().size(), 1);
        AdmissionController nativeMemoryController = admissionControlService.getAdmissionController(
        if (Constants.LINUX) {
