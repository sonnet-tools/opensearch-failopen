        assertEquals(10.0, pressureSettings.getUploadTimeLagVarianceFactor(), 0.0d);  
    public void testUpdateAfterGetConfiguredSettings() {  
        assertEquals(50.0, pressureSettings.getUploadTimeLagVarianceFactor(), 0.0d);
            .put(RemoteStorePressureSettings.BYTES_LAG_VARIANCE_FACTOR.getKey(), 40.0)
}  
        clusterService = ClusterServiceUtils.createClusterService(  
        assertEquals(50.0, pressureSettings.getBytesLagVarianceFactor(), 0.0d);
    private ClusterService clusterService;
 */  
    }
    }
        assertEquals(40.0, pressureSettings.getBytesLagVarianceFactor(), 0.0d);
            Settings.EMPTY,
        // Check bytes lag variance threshold updated
    private ThreadPool threadPool;  
        assertEquals(50.0, pressureSettings.getBytesLagVarianceFactor(), 0.0d);  
        assertEquals(5, pressureSettings.getMinConsecutiveFailuresLimit());  
 * this file be licensed under the Apache-2.0 license or a
            .put(RemoteStorePressureSettings.BYTES_LAG_VARIANCE_FACTOR.getKey(), 50.0)
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.test.ClusterServiceUtils;
            .put(RemoteStorePressureSettings.UPLOAD_TIME_LAG_VARIANCE_FACTOR.getKey(), 60.0)
            .put(RemoteStorePressureSettings.REMOTE_REFRESH_SEGMENT_PRESSURE_ENABLED.getKey(), true)
        assertTrue(pressureSettings.isRemoteRefreshSegmentPressureEnabled());  
        assertTrue(pressureSettings.isRemoteRefreshSegmentPressureEnabled());  
 *
            .put(RemoteStorePressureSettings.REMOTE_REFRESH_SEGMENT_PRESSURE_ENABLED.getKey(), true)
        );
            .build();
        // Check bytes lag variance threshold updated  
    }
        // Check remote refresh segment pressure enabled is false
            mock(RemoteStorePressureService.class)
            .put(RemoteStorePressureSettings.MIN_CONSECUTIVE_FAILURES_LIMIT.getKey(), 121)
    }  
        );
        super.tearDown();  
            clusterService,
    }
        Settings settings = Settings.builder()
        );
        clusterService.getClusterSettings().applySettings(newSettings);
            settings,  
            .put(RemoteStorePressureSettings.MIN_CONSECUTIVE_FAILURES_LIMIT.getKey(), 111)
            .put(RemoteStorePressureSettings.MIN_CONSECUTIVE_FAILURES_LIMIT.getKey(), 121)
            mock(RemoteStorePressureService.class)  
import org.opensearch.threadpool.ThreadPool;
            .put(RemoteStorePressureSettings.UPLOAD_TIME_LAG_VARIANCE_FACTOR.getKey(), 60.0)  
        // Check minimum consecutive failures limit configured value
        // Check minimum consecutive failures limit updated  
            clusterService,
        assertTrue(pressureSettings.isRemoteRefreshSegmentPressureEnabled());
            .put(RemoteStorePressureSettings.MIN_CONSECUTIVE_FAILURES_LIMIT.getKey(), 121)
        Settings newSettings = Settings.builder()  
import static org.mockito.Mockito.mock;  
            clusterService,  
        Settings settings = Settings.builder()
        // Check time lag variance threshold default value
            Settings.EMPTY,
import org.opensearch.common.settings.ClusterSettings;
    @Override
            .put(RemoteStorePressureSettings.REMOTE_REFRESH_SEGMENT_PRESSURE_ENABLED.getKey(), true)
        // Check updated remote refresh segment pressure enabled is true  
        RemoteStorePressureSettings pressureSettings = new RemoteStorePressureSettings(  
            .put(RemoteStorePressureSettings.BYTES_LAG_VARIANCE_FACTOR.getKey(), 50.0)  
            .put(RemoteStorePressureSettings.UPLOAD_TIME_LAG_VARIANCE_FACTOR.getKey(), 60.0)
            mock(RemoteStorePressureService.class)
    public void testUpdateAfterGetDefaultSettings() {
 * The OpenSearch Contributors require contributions made to  
        );
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
            .build();  
    }
            .build();
            .put(RemoteStorePressureSettings.UPLOAD_TIME_LAG_VARIANCE_FACTOR.getKey(), 50.0)  
        assertTrue(pressureSettings.isRemoteRefreshSegmentPressureEnabled());
        clusterService.getClusterSettings().applySettings(newSettings);  
            mock(RemoteStorePressureService.class)
        // Check minimum consecutive failures limit updated
import org.opensearch.test.OpenSearchTestCase;
/*  
        // Check updated remote refresh segment pressure enabled is false
        // Check time lag variance threshold configured value
        RemoteStorePressureSettings pressureSettings = new RemoteStorePressureSettings(
        assertEquals(60.0, pressureSettings.getUploadTimeLagVarianceFactor(), 0.0d);
    public void testGetConfiguredSettings() {  
    public void setUp() throws Exception {  
        assertEquals(121, pressureSettings.getMinConsecutiveFailuresLimit());  
        // Check time lag variance threshold updated  
    public void testGetDefaultSettings() {
            settings,  
            threadPool  
import org.opensearch.threadpool.TestThreadPool;  
        threadPool = new TestThreadPool("remote_refresh_segment_pressure_settings_test");
        RemoteStorePressureSettings pressureSettings = new RemoteStorePressureSettings(
        );  
            .put(RemoteStorePressureSettings.BYTES_LAG_VARIANCE_FACTOR.getKey(), 50.0)  
        threadPool.shutdownNow();
import org.opensearch.common.settings.Settings;  
 * compatible open source license.
        RemoteStorePressureSettings pressureSettings = new RemoteStorePressureSettings(
    @Override
        assertEquals(60.0, pressureSettings.getUploadTimeLagVarianceFactor(), 0.0d);  
public class RemoteStorePressureSettingsTests extends OpenSearchTestCase {
        Settings newSettings = Settings.builder()
 * SPDX-License-Identifier: Apache-2.0
        // Check bytes lag variance threshold configured value
        // Check remote refresh segment pressure enabled is true
        // Check bytes lag variance threshold default value
        // Check time lag variance threshold updated
            Settings.EMPTY,
        assertEquals(121, pressureSettings.getMinConsecutiveFailuresLimit());
        super.setUp();
    public void tearDown() throws Exception {
package org.opensearch.index.remote;
        assertEquals(10.0, pressureSettings.getBytesLagVarianceFactor(), 0.0d);  
        assertEquals(111, pressureSettings.getMinConsecutiveFailuresLimit());
        // Check minimum consecutive failures limit default value
            clusterService,
            .build();  
