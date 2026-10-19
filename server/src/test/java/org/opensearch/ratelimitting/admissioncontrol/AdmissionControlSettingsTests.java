        Set<Setting<?>> settings = ClusterSettings.BUILT_IN_CLUSTER_SETTINGS;  
    private ClusterService clusterService;  
        Settings newSettings = Settings.builder()
        super.tearDown();
            clusterService.getClusterSettings(),
    }
            .build();  
        assertFalse(admissionControlSettings.isTransportLayerAdmissionControlEnforced());
            clusterService.getClusterSettings(),  
    @Override  
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlMode;
import java.util.List;
        Settings settings = Settings.builder()
    public void testDefaultSettings() {
        assertTrue(admissionControlSettings.isTransportLayerAdmissionControlEnforced());
        Settings settings = Settings.builder()
}
        assertTrue(admissionControlSettings.isTransportLayerAdmissionControlEnabled());
 * The OpenSearch Contributors require contributions made to  
 *
        Settings settings = Settings.builder()
    @Override
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.threadpool.ThreadPool;  
        );
        );
import org.opensearch.test.OpenSearchTestCase;
    }  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
        AdmissionControlSettings admissionControlSettings = new AdmissionControlSettings(clusterService.getClusterSettings(), settings);
        assertEquals(admissionControlSettings.getAdmissionControlTransportLayerMode().getMode(), AdmissionControlSettings.Defaults.MODE);  
    }  
        AdmissionControlSettings admissionControlSettings = new AdmissionControlSettings(  
        AdmissionControlSettings admissionControlSettings = new AdmissionControlSettings(
            .build();  
import org.opensearch.common.settings.Settings;
import org.opensearch.threadpool.TestThreadPool;
        threadPool = new TestThreadPool("admission_controller_settings_test");  
 * compatible open source license.
    }  
            .put(AdmissionControlSettings.ADMISSION_CONTROL_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.ENFORCED.getMode())
            Settings.EMPTY
            .put(AdmissionControlSettings.ADMISSION_CONTROL_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.ENFORCED.getMode())
import org.opensearch.test.ClusterServiceUtils;  
        );  
    public void tearDown() throws Exception {  
import org.opensearch.common.settings.ClusterSettings;
 * this file be licensed under the Apache-2.0 license or a
    public void testUpdateAfterGetConfiguredSettings() {  
            settings.containsAll(List.of(AdmissionControlSettings.ADMISSION_CONTROL_TRANSPORT_LAYER_MODE))  
import org.opensearch.common.settings.Setting;  
            "All the admission controller settings should be supported built in settings",
        AdmissionControlSettings admissionControlSettings = new AdmissionControlSettings(clusterService.getClusterSettings(), settings);
            .put(AdmissionControlSettings.ADMISSION_CONTROL_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.MONITOR.getMode())
        clusterService.getClusterSettings().applySettings(newSettings);
    public void testSettingsExists() {
            threadPool
        assertTrue(admissionControlSettings.isTransportLayerAdmissionControlEnabled());
    }  
            Settings.EMPTY,
import org.opensearch.cluster.service.ClusterService;
/*  
package org.opensearch.ratelimitting.admissioncontrol;
        assertFalse(admissionControlSettings.isTransportLayerAdmissionControlEnforced());  
public class AdmissionControlSettingsTests extends OpenSearchTestCase {
        assertTrue(
        threadPool.shutdownNow();
        clusterService = ClusterServiceUtils.createClusterService(
    public void testUpdateAfterGetDefaultSettings() {
        super.setUp();
    private ThreadPool threadPool;
import java.util.Set;  
        assertTrue(admissionControlSettings.isTransportLayerAdmissionControlEnabled());
    public void setUp() throws Exception {
    }
        clusterService.getClusterSettings().applySettings(settings);
 */  
    }
        assertTrue(admissionControlSettings.isTransportLayerAdmissionControlEnforced());
    public void testGetConfiguredSettings() {  
            .build();  
        );
        assertFalse(admissionControlSettings.isTransportLayerAdmissionControlEnabled());
            .put(AdmissionControlSettings.ADMISSION_CONTROL_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.MONITOR.getMode())
            .build();  
            Settings.EMPTY
