        clusterService = ClusterServiceUtils.createClusterService(threadPool);  
import org.opensearch.arrow.spi.PoolGroup;
                AdmissionControlMode.ENFORCED.getMode()  
        action = "indices:data/read/search";
    }
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.INDEXING.getType()), 0);
    public void testIndexingPoolCheckIgnoredForSearchAction() {  
            rs,
                NativeMemoryBasedAdmissionControllerSettings.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),
            )  
        assertEquals(admissionController.getSettings().getTransportLayerAdmissionControllerMode(), AdmissionControlMode.ENFORCED);
                    0  
            admissionController.getSettings().getIndexingNativeMemoryPoolUsageLimit().longValue(),
        );
            .build();
import java.util.Optional;
            NativeMemoryBasedAdmissionControllerSettings.Defaults.CLUSTER_ADMIN_NATIVE_MEMORY_USAGE_LIMIT
            .build();
                NativeMemoryBasedAdmissionControllerSettings.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),  
        action = "indices:data/write/bulk[s][p]";  
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.INDEXING.getType()), 0);
        action = "indices:data/read/search";
            .build();  
            .put(
            clusterService,  
        Settings settings = Settings.builder()
            indexingPoolSupplier(95, 100)  
 * The OpenSearch Contributors require contributions made to  
        Settings settings = Settings.builder()
                AdmissionControlMode.MONITOR.getMode()
        ResourceUsageCollectorService rs = Mockito.mock(ResourceUsageCollectorService.class);
    public void testApplyControllerInMonitorMode() {
                    PoolGroup.INDEXING.getName(),
            () -> admissionController.apply(action, AdmissionControlActionType.INDEXING)
            .put(NativeMemoryBasedAdmissionControllerSettings.INDEXING_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 70)  
import org.opensearch.threadpool.ThreadPool;
        assertEquals(  
import org.opensearch.ratelimitting.admissioncontrol.settings.NativeMemoryBasedAdmissionControllerSettings;  
        action = "indices:data/write/bulk[s][p]";
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER,
            null
            null,
        expectThrows(  
            clusterService,
import org.opensearch.test.ClusterServiceUtils;
        expectThrows(
        NodeResourceUsageStats stats = new NodeResourceUsageStats(localNodeId, System.currentTimeMillis(), 50, 50, null, 30);
            rs,  
        admissionController = new NativeMemoryBasedAdmissionController(
}
    public void testIndexingPoolCheckSkippedWhenSupplierNull() {
        );
        admissionController = new NativeMemoryBasedAdmissionController(
        // No stats supplier installed -> indexing-pool check is skipped entirely (current behavior preserved)
            .put(
        );  
        Settings settings = Settings.builder()
            clusterService,
                NativeMemoryBasedAdmissionControllerSettings.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),
            Settings.EMPTY,
                )
            admissionController.getSettings().getIndexingNativeMemoryUsageLimit().longValue(),  
        );
    public void testCheckDefaultIndexingPoolUsageLimit() {
        admissionController = new NativeMemoryBasedAdmissionController(  
            rs,
            null,  
        assertTrue(  
        admissionController = new NativeMemoryBasedAdmissionController(
import org.opensearch.cluster.service.ClusterService;
        ResourceUsageCollectorService rs = Mockito.mock(ResourceUsageCollectorService.class);
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.SEARCH.getType()), 0);
    }
            settings,  
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER,  
            clusterService,
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlMode;
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER,  
            null,
        admissionController = new NativeMemoryBasedAdmissionController(  
        Settings settings = Settings.builder()
                NativeMemoryBasedAdmissionControllerSettings.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),  
        // 50 / 100 = 50% < 90% limit
        );
        admissionController = new NativeMemoryBasedAdmissionController(
                AdmissionControlMode.ENFORCED.getMode()
    public void testCheckDefaultLimits() {
            .put(  
        );
            null
            rs,  
            .build();
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.SEARCH.getType()), 1);  
        assertEquals(admissionController.getName(), NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER);  
    }
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER,  
        );
                AdmissionControlMode.ENFORCED.getMode()  
            NativeMemoryBasedAdmissionControllerSettings.Defaults.NATIVE_MEMORY_USAGE_LIMIT
                    "ingest",
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER,
        );
            NativeMemoryBasedAdmissionControllerSettings.Defaults.INDEXING_NATIVE_MEMORY_POOL_USAGE_LIMIT
        ResourceUsageCollectorService rs = Mockito.mock(ResourceUsageCollectorService.class);
            clusterService,
        );  
        clusterService.getClusterSettings().applySettings(settings);
    public void testApplyControllerWithDefaultSettings() {
            null,
    }
            clusterService,  
            clusterService,  
        );
    }
    public void testCheckDefaultParameters() {
        admissionController.apply(action, AdmissionControlActionType.INDEXING);  
        super.tearDown();
        admissionController.addRejectionCount(AdmissionControlActionType.SEARCH.getType(), 1);  
        );
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.INDEXING.getType()), 3);  
            )  
    }  
        assertEquals(admissionController.getSettings().getTransportLayerAdmissionControllerMode(), AdmissionControlMode.DISABLED);
            null
            Settings.EMPTY,
        );
            org.opensearch.core.concurrency.OpenSearchRejectedExecutionException.class,
            clusterService,
            Settings.EMPTY,
        String localNodeId = clusterService.state().nodes().getLocalNodeId();  
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER,
            .put(NativeMemoryBasedAdmissionControllerSettings.INDEXING_NATIVE_MEMORY_POOL_USAGE_LIMIT.getKey(), 90)
            )
        NodeResourceUsageStats stats = new NodeResourceUsageStats(localNodeId, System.currentTimeMillis(), 50, 50, null, 80);  
            -1,
                AdmissionControlMode.MONITOR.getMode()
            clusterService,  
        admissionController.apply(action, AdmissionControlActionType.INDEXING);
        // Indexing pool is breached (95%) but the action is SEARCH, so the pool check must not apply  
import static org.mockito.Mockito.when;  
            .put(
                NativeMemoryBasedAdmissionControllerSettings.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),
                NativeMemoryBasedAdmissionControllerSettings.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),  
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.INDEXING.getType()), 0);  
            admissionController.isEnabledForTransportLayer(admissionController.getSettings().getTransportLayerAdmissionControllerMode())
        ResourceUsageCollectorService rs = Mockito.mock(ResourceUsageCollectorService.class);
        ResourceUsageCollectorService rs = Mockito.mock(ResourceUsageCollectorService.class);  
            .build();
        assertEquals(
            .put(NativeMemoryBasedAdmissionControllerSettings.INDEXING_NATIVE_MEMORY_POOL_USAGE_LIMIT.getKey(), 90)  
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER,
            .put(  
        admissionController = new NativeMemoryBasedAdmissionController(
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.INDEXING.getType()), 0);
        // Mock node stats with native memory usage above the threshold
            indexingPoolSupplier(95, 100)  
    public void testApplyControllerWhenMemoryUsageBreached() {
            Settings.EMPTY,  
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.SEARCH.getType()), 0);
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER,
    }
        ResourceUsageCollectorService rs = Mockito.mock(ResourceUsageCollectorService.class);  
            settings,
import org.opensearch.plugin.stats.NativeAllocatorPoolStats;  
            settings,
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.INDEXING.getType()), 1);
            settings,  
            rs,
                    limitBytes,
        admissionController = new NativeMemoryBasedAdmissionController(
            .build();
            rs,  
        assertEquals(admissionController.getName(), NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER);  
            null,
        action = "indices:data/write/bulk[s][p]";  
    }
            clusterService,
        admissionController = new NativeMemoryBasedAdmissionController(  
    }
                NativeMemoryBasedAdmissionControllerSettings.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),
        Settings settings = Settings.builder()  
            Settings.EMPTY,
            settings,
                AdmissionControlMode.ENFORCED.getMode()
        String localNodeId = clusterService.state().nodes().getLocalNodeId();
            .put(NativeMemoryBasedAdmissionControllerSettings.SEARCH_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 50)
        admissionController = new NativeMemoryBasedAdmissionController(  
        admissionController.apply(action, AdmissionControlActionType.INDEXING);
        admissionController = new NativeMemoryBasedAdmissionController(
        admissionController = new NativeMemoryBasedAdmissionController(
    String action = "TEST_ACTION";  
        when(rs.getNodeStatistics(localNodeId)).thenReturn(Optional.of(stats));  
import org.opensearch.common.settings.Settings;  
        threadPool.shutdownNow();
            null
    public void testCheckUpdateLimitSettings() {
        ResourceUsageCollectorService rs = Mockito.mock(ResourceUsageCollectorService.class);  
            rs,
        );
        when(rs.getNodeStatistics(localNodeId)).thenReturn(Optional.of(stats));
                NativeMemoryBasedAdmissionControllerSettings.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),
            -1,  
        threadPool = new TestThreadPool("admission_controller_settings_test");
                AdmissionControlMode.ENFORCED.getMode()
                    allocatedBytes,
            null  
 * compatible open source license.
            .put(  
        assertEquals(admissionController.getSettings().getIndexingNativeMemoryUsageLimit().longValue(), 70);
            admissionController.isEnabledForTransportLayer(admissionController.getSettings().getTransportLayerAdmissionControllerMode())
        ResourceUsageCollectorService rs = Mockito.mock(ResourceUsageCollectorService.class);
            .put(
            null
        assertTrue(
    }
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.INDEXING.getType()), 0);
            )
            null
 *
            NativeMemoryBasedAdmissionControllerSettings.Defaults.NATIVE_MEMORY_USAGE_LIMIT  
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.INDEXING.getType()), 1);
package org.opensearch.ratelimitting.admissioncontrol.controllers;
        Settings settings = Settings.builder()
            .put(
import org.opensearch.test.OpenSearchTestCase;
        Settings settings = Settings.builder()
        Settings settings = Settings.builder()  
            () -> admissionController.apply(action, AdmissionControlActionType.SEARCH)
import java.util.function.Supplier;
    }  
            rs,
            )
            admissionController.getSettings().getClusterAdminNativeMemoryUsageLimit().longValue(),
    }
        admissionController = new NativeMemoryBasedAdmissionController(  
public class NativeMemoryBasedAdmissionControllerTests extends OpenSearchTestCase {
        );  
        assertFalse(  
import org.opensearch.threadpool.TestThreadPool;  
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.SEARCH.getType()), 2);  
            null
    }  
    @Override
            .put(NativeMemoryBasedAdmissionControllerSettings.INDEXING_NATIVE_MEMORY_POOL_USAGE_LIMIT.getKey(), 90)  
            settings,
        assertEquals(admissionController.getSettings().getSearchNativeMemoryUsageLimit().longValue(), 80);  
            .build();
        action = "indices:data/write/bulk[s][p]";
        action = "indices:data/write/bulk[s][p]";
            settings,
        Settings settings = Settings.builder()
        clusterService.close();  
            .put(
        NodeResourceUsageStats stats = new NodeResourceUsageStats(localNodeId, System.currentTimeMillis(), 50, 50, null, 80);
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER,  
        );
        admissionController.apply(action, AdmissionControlActionType.INDEXING);
            null
/*  
        );  
        Settings settings = Settings.builder()  
            )
        admissionController.apply(action, AdmissionControlActionType.SEARCH);  
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;
    private ClusterService clusterService;  
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER,
            clusterService,
    public void tearDown() throws Exception {
        assertEquals(admissionController.getSettings().getTransportLayerAdmissionControllerMode(), AdmissionControlMode.DISABLED);
            .put(NativeMemoryBasedAdmissionControllerSettings.SEARCH_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 80)
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.INDEXING.getType()), 0);
            .build();  
            null
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER,
            rs,  
        admissionController.apply(action, AdmissionControlActionType.SEARCH);
            .put(
        when(rs.getNodeStatistics(localNodeId)).thenReturn(Optional.of(stats));
        );  
            )
    public void testApplyControllerWhenSettingsEnabled() {
    NativeMemoryBasedAdmissionController admissionController = null;
            settings,
            indexingPoolSupplier(50, 100)
            clusterService,
            settings,  
            clusterService,  
    }  
        );  
    private static Supplier<NativeAllocatorPoolStats> indexingPoolSupplier(long allocatedBytes, long limitBytes) {
        return () -> new NativeAllocatorPoolStats(
        admissionController.addRejectionCount(AdmissionControlActionType.INDEXING.getType(), 2);
    public void testCheckUpdateSettings() {  
    private ThreadPool threadPool;
        Settings settings = Settings.builder()
            settings,
                NativeMemoryBasedAdmissionControllerSettings.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),
import org.opensearch.node.NodeResourceUsageStats;
            )
                AdmissionControlMode.ENFORCED.getMode()  
        ResourceUsageCollectorService rs = Mockito.mock(ResourceUsageCollectorService.class);
        );  
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER,
        // Mock node stats with native memory usage above the threshold
        admissionController.addRejectionCount(AdmissionControlActionType.SEARCH.getType(), 1);
    public void testApplyControllerWhenMemoryUsageNotBreached() {  
            null  
            clusterService,
    public void testRejectionCount() {  
                AdmissionControlMode.ENFORCED.getMode()
            null  
        Settings settings = Settings.builder()
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER,
        );  
            rs,  
            )  
        // 95 / 100 = 95% > 90% limit  
                NativeMemoryBasedAdmissionControllerSettings.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),
        clusterService.getClusterSettings().applySettings(settings);
        assertTrue(
        ResourceUsageCollectorService rs = Mockito.mock(ResourceUsageCollectorService.class);
        action = "indices:data/read/search";
            .build();
                    allocatedBytes,  
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.INDEXING.getType()), 0);
import org.opensearch.node.ResourceUsageCollectorService;
    public void testApplyControllerWhenIndexingPoolUsageBreached() {  
    public void testIndexingPoolCheckInMonitorModeCountsButDoesNotThrow() {
            clusterService,
        );
            .put(NativeMemoryBasedAdmissionControllerSettings.INDEXING_NATIVE_MEMORY_POOL_USAGE_LIMIT.getKey(), 90)
            indexingPoolSupplier(95, 100)  
        action = "indices:data/read/search";
            clusterService,
        );
            )
    public void testApplyControllerWhenIndexingPoolUsageNotBreached() {
        admissionController = new NativeMemoryBasedAdmissionController(
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER,
 * SPDX-License-Identifier: Apache-2.0
    }  
            .build();
        admissionController = new NativeMemoryBasedAdmissionController(
            )  
            org.opensearch.core.concurrency.OpenSearchRejectedExecutionException.class,  
            admissionController.isEnabledForTransportLayer(admissionController.getSettings().getTransportLayerAdmissionControllerMode())  
            .build();
        );  
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER,  
    }
        admissionController.apply(action, AdmissionControlActionType.SEARCH);  
        );
                new NativeAllocatorPoolStats.PoolStats(  
import java.util.List;  
            .build();  
        admissionController = new NativeMemoryBasedAdmissionController(
                AdmissionControlMode.ENFORCED.getMode()
        admissionController.addRejectionCount(AdmissionControlActionType.INDEXING.getType(), 3);
            .put(NativeMemoryBasedAdmissionControllerSettings.SEARCH_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 50)  
        );
        assertEquals(
        // Mock node stats with native memory usage below the threshold  
    }
            .put(  
import org.mockito.Mockito;
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER,
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.SEARCH.getType()), 1);  
        );
        );
    public void setUp() throws Exception {  
 */  
            admissionController.isAdmissionControllerEnforced(admissionController.getSettings().getTransportLayerAdmissionControllerMode())  
            admissionController.getSettings().getSearchNativeMemoryUsageLimit().longValue(),
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.INDEXING.getType()), 5);
    }
            .put(NativeMemoryBasedAdmissionControllerSettings.INDEXING_NATIVE_MEMORY_POOL_USAGE_LIMIT.getKey(), 90)
 * this file be licensed under the Apache-2.0 license or a
                NativeMemoryBasedAdmissionControllerSettings.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),  
    @Override  
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.SEARCH.getType()), 1);
        super.setUp();
            .put(NativeMemoryBasedAdmissionControllerSettings.SEARCH_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 50)
            rs,
            )
            List.of(
        // In monitor mode, should not throw but should still count rejections  
                AdmissionControlMode.ENFORCED.getMode()
        String localNodeId = clusterService.state().nodes().getLocalNodeId();
            Settings.EMPTY,  
        assertEquals(  
    }
        ResourceUsageCollectorService rs = Mockito.mock(ResourceUsageCollectorService.class);  
