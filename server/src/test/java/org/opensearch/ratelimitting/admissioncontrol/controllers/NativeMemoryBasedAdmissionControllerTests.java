 *
            null
                NativeMemoryBasedAdmissionControllerSettings.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),
        when(rs.getNodeStatistics(localNodeId)).thenReturn(Optional.of(stats));
            .build();
            .put(
            -1,
        ResourceUsageCollectorService rs = Mockito.mock(ResourceUsageCollectorService.class);
            null
            clusterService,
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.SEARCH.getType()), 1);
            Settings.EMPTY,
            clusterService,
        admissionController.apply(action, AdmissionControlActionType.SEARCH);
            .put(
            Settings.EMPTY,
        clusterService.getClusterSettings().applySettings(settings);
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER,
import java.util.function.Supplier;
            settings,
            admissionController.isEnabledForTransportLayer(admissionController.getSettings().getTransportLayerAdmissionControllerMode())
    public void testApplyControllerWhenIndexingPoolUsageNotBreached() {
package org.opensearch.ratelimitting.admissioncontrol.controllers;
            .build();
                AdmissionControlMode.ENFORCED.getMode()
        admissionController = new NativeMemoryBasedAdmissionController(
        );
    NativeMemoryBasedAdmissionController admissionController = null;
            Settings.EMPTY,
        admissionController = new NativeMemoryBasedAdmissionController(
        assertEquals(admissionController.getName(), NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER);
            Settings.EMPTY,
            )
            .put(
        Settings settings = Settings.builder()
        assertEquals(admissionController.getSettings().getSearchNativeMemoryUsageLimit().longValue(), 80);
            null,
        assertTrue(
            clusterService,
    public void testIndexingPoolCheckSkippedWhenSupplierNull() {
            null,
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER,
        admissionController = new NativeMemoryBasedAdmissionController(
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER,
            .build();
            .build();
        assertFalse(
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER,
            .put(NativeMemoryBasedAdmissionControllerSettings.INDEXING_NATIVE_MEMORY_POOL_USAGE_LIMIT.getKey(), 90)
    public void testCheckUpdateLimitSettings() {
            .put(
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.SEARCH.getType()), 0);
            .put(
        );
        return () -> new NativeAllocatorPoolStats(
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;
            .build();
        admissionController = new NativeMemoryBasedAdmissionController(
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.INDEXING.getType()), 0);
        );
import org.opensearch.arrow.spi.PoolGroup;
        action = "indices:data/write/bulk[s][p]";
            rs,
        Settings settings = Settings.builder()
            )
            org.opensearch.core.concurrency.OpenSearchRejectedExecutionException.class,
            .build();
        );
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.INDEXING.getType()), 0);
            )
import org.opensearch.node.ResourceUsageCollectorService;
            settings,
    public void testCheckDefaultIndexingPoolUsageLimit() {
        );
        Settings settings = Settings.builder()
            clusterService,
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER,
        Settings settings = Settings.builder()
            settings,
    }
        );
            null,
            settings,
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.SEARCH.getType()), 2);
    public void testApplyControllerWithDefaultSettings() {
        // 50 / 100 = 50% < 90% limit
        admissionController = new NativeMemoryBasedAdmissionController(
        when(rs.getNodeStatistics(localNodeId)).thenReturn(Optional.of(stats));
            .put(NativeMemoryBasedAdmissionControllerSettings.INDEXING_NATIVE_MEMORY_POOL_USAGE_LIMIT.getKey(), 90)
            NativeMemoryBasedAdmissionControllerSettings.Defaults.INDEXING_NATIVE_MEMORY_POOL_USAGE_LIMIT
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER,
                AdmissionControlMode.ENFORCED.getMode()
        NodeResourceUsageStats stats = new NodeResourceUsageStats(localNodeId, System.currentTimeMillis(), 50, 50, null, 80);
}
            .put(NativeMemoryBasedAdmissionControllerSettings.INDEXING_NATIVE_MEMORY_POOL_USAGE_LIMIT.getKey(), 90)
        expectThrows(
import org.opensearch.common.settings.Settings;
            rs,
        action = "indices:data/read/search";
                NativeMemoryBasedAdmissionControllerSettings.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),
    }
        );
            NativeMemoryBasedAdmissionControllerSettings.Defaults.CLUSTER_ADMIN_NATIVE_MEMORY_USAGE_LIMIT
        admissionController.addRejectionCount(AdmissionControlActionType.INDEXING.getType(), 2);
        action = "indices:data/write/bulk[s][p]";
            clusterService,
        admissionController.apply(action, AdmissionControlActionType.INDEXING);
            clusterService,
                NativeMemoryBasedAdmissionControllerSettings.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),
    @Override
            clusterService,
            null,
        admissionController.addRejectionCount(AdmissionControlActionType.SEARCH.getType(), 1);
import org.opensearch.ratelimitting.admissioncontrol.settings.NativeMemoryBasedAdmissionControllerSettings;
        admissionController = new NativeMemoryBasedAdmissionController(
        ResourceUsageCollectorService rs = Mockito.mock(ResourceUsageCollectorService.class);
        admissionController = new NativeMemoryBasedAdmissionController(
import static org.mockito.Mockito.when;
import org.opensearch.test.OpenSearchTestCase;
                AdmissionControlMode.ENFORCED.getMode()
        );
            clusterService,
        admissionController = new NativeMemoryBasedAdmissionController(
                AdmissionControlMode.ENFORCED.getMode()
        ResourceUsageCollectorService rs = Mockito.mock(ResourceUsageCollectorService.class);
            clusterService,
            null
        NodeResourceUsageStats stats = new NodeResourceUsageStats(localNodeId, System.currentTimeMillis(), 50, 50, null, 80);
 * this file be licensed under the Apache-2.0 license or a
        Settings settings = Settings.builder()
    }
            null,
        );
        admissionController = new NativeMemoryBasedAdmissionController(
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.INDEXING.getType()), 1);
    }
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER,
        ResourceUsageCollectorService rs = Mockito.mock(ResourceUsageCollectorService.class);
        admissionController = new NativeMemoryBasedAdmissionController(
                AdmissionControlMode.ENFORCED.getMode()
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.SEARCH.getType()), 1);
    }
        assertTrue(
        );
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.INDEXING.getType()), 0);
        // 95 / 100 = 95% > 90% limit
    @Override
import org.opensearch.plugin.stats.NativeAllocatorPoolStats;
 * The OpenSearch Contributors require contributions made to
        assertEquals(
        clusterService.close();
            )
        );
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.INDEXING.getType()), 0);
        assertEquals(admissionController.getSettings().getTransportLayerAdmissionControllerMode(), AdmissionControlMode.ENFORCED);
                    PoolGroup.INDEXING.getName(),
            NativeMemoryBasedAdmissionControllerSettings.Defaults.NATIVE_MEMORY_USAGE_LIMIT
            .build();
        );
 * compatible open source license.
        Settings settings = Settings.builder()
            () -> admissionController.apply(action, AdmissionControlActionType.INDEXING)
            indexingPoolSupplier(50, 100)
        ResourceUsageCollectorService rs = Mockito.mock(ResourceUsageCollectorService.class);
            .put(NativeMemoryBasedAdmissionControllerSettings.INDEXING_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 70)
            clusterService,
            clusterService,
        Settings settings = Settings.builder()
        );
    public void testApplyControllerInMonitorMode() {
        );
    private ClusterService clusterService;
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.INDEXING.getType()), 5);
            admissionController.getSettings().getIndexingNativeMemoryPoolUsageLimit().longValue(),
    public void testApplyControllerWhenSettingsEnabled() {
    public void testCheckDefaultLimits() {
            settings,
/*
                )
    String action = "TEST_ACTION";
            null
                AdmissionControlMode.MONITOR.getMode()
        super.setUp();
        );
            rs,
                new NativeAllocatorPoolStats.PoolStats(
            )
            indexingPoolSupplier(95, 100)
        // Mock node stats with native memory usage above the threshold
            .put(
        super.tearDown();
            -1,
        assertEquals(admissionController.getSettings().getTransportLayerAdmissionControllerMode(), AdmissionControlMode.DISABLED);
import org.opensearch.cluster.service.ClusterService;
    }
                NativeMemoryBasedAdmissionControllerSettings.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),
        action = "indices:data/write/bulk[s][p]";
        assertEquals(
    }
import org.mockito.Mockito;
        ResourceUsageCollectorService rs = Mockito.mock(ResourceUsageCollectorService.class);
    }
        ResourceUsageCollectorService rs = Mockito.mock(ResourceUsageCollectorService.class);
        threadPool = new TestThreadPool("admission_controller_settings_test");
            .build();
    public void setUp() throws Exception {
        // Mock node stats with native memory usage above the threshold
            .put(NativeMemoryBasedAdmissionControllerSettings.INDEXING_NATIVE_MEMORY_POOL_USAGE_LIMIT.getKey(), 90)
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER,
        action = "indices:data/read/search";
    public void testCheckUpdateSettings() {
            .put(NativeMemoryBasedAdmissionControllerSettings.SEARCH_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 80)
        ResourceUsageCollectorService rs = Mockito.mock(ResourceUsageCollectorService.class);
    private ThreadPool threadPool;
        admissionController.addRejectionCount(AdmissionControlActionType.INDEXING.getType(), 3);
            .build();
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.INDEXING.getType()), 0);
        // In monitor mode, should not throw but should still count rejections
 */
        Settings settings = Settings.builder()
        action = "indices:data/read/search";
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER,
    }
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER,
            .put(
                    0
                NativeMemoryBasedAdmissionControllerSettings.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),
            null
import java.util.List;
            NativeMemoryBasedAdmissionControllerSettings.Defaults.NATIVE_MEMORY_USAGE_LIMIT
import org.opensearch.threadpool.ThreadPool;
            clusterService,
                AdmissionControlMode.ENFORCED.getMode()
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.SEARCH.getType()), 1);
                    allocatedBytes,
        );
    public void testRejectionCount() {
        action = "indices:data/write/bulk[s][p]";
        admissionController = new NativeMemoryBasedAdmissionController(
        admissionController.apply(action, AdmissionControlActionType.SEARCH);
        // No stats supplier installed -> indexing-pool check is skipped entirely (current behavior preserved)
        String localNodeId = clusterService.state().nodes().getLocalNodeId();
        assertEquals(admissionController.getName(), NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER);
        threadPool.shutdownNow();
        );
        clusterService.getClusterSettings().applySettings(settings);
                    "ingest",
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.INDEXING.getType()), 0);
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER,
            .put(
        Settings settings = Settings.builder()
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.SEARCH.getType()), 0);
            settings,
        assertTrue(
            settings,
import java.util.Optional;
        assertEquals(
            null
        String localNodeId = clusterService.state().nodes().getLocalNodeId();
public class NativeMemoryBasedAdmissionControllerTests extends OpenSearchTestCase {
            )
            )
        admissionController.apply(action, AdmissionControlActionType.INDEXING);
        admissionController = new NativeMemoryBasedAdmissionController(
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER,
            rs,
    public void testCheckDefaultParameters() {
                AdmissionControlMode.ENFORCED.getMode()
            )
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.INDEXING.getType()), 0);
            rs,
            settings,
        Settings settings = Settings.builder()
    }
            .put(
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER,
            admissionController.isEnabledForTransportLayer(admissionController.getSettings().getTransportLayerAdmissionControllerMode())
        clusterService = ClusterServiceUtils.createClusterService(threadPool);
            )
            settings,
    }
    public void testIndexingPoolCheckIgnoredForSearchAction() {
import org.opensearch.test.ClusterServiceUtils;
            rs,
    }
            () -> admissionController.apply(action, AdmissionControlActionType.SEARCH)
            Settings.EMPTY,
            indexingPoolSupplier(95, 100)
            .put(NativeMemoryBasedAdmissionControllerSettings.SEARCH_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 50)
            .put(
        ResourceUsageCollectorService rs = Mockito.mock(ResourceUsageCollectorService.class);
            )
            rs,
    public void testApplyControllerWhenIndexingPoolUsageBreached() {
            Settings.EMPTY,
                AdmissionControlMode.ENFORCED.getMode()
            .put(NativeMemoryBasedAdmissionControllerSettings.SEARCH_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 50)
        admissionController.addRejectionCount(AdmissionControlActionType.SEARCH.getType(), 1);
        admissionController = new NativeMemoryBasedAdmissionController(
        ResourceUsageCollectorService rs = Mockito.mock(ResourceUsageCollectorService.class);
import org.opensearch.node.NodeResourceUsageStats;
        );
    }
        admissionController.apply(action, AdmissionControlActionType.INDEXING);
        ResourceUsageCollectorService rs = Mockito.mock(ResourceUsageCollectorService.class);
        );
    public void testApplyControllerWhenMemoryUsageNotBreached() {
        );
            .build();
                NativeMemoryBasedAdmissionControllerSettings.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),
        // Mock node stats with native memory usage below the threshold
        );
        );
            admissionController.isAdmissionControllerEnforced(admissionController.getSettings().getTransportLayerAdmissionControllerMode())
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER,
            List.of(
        assertEquals(
    public void testIndexingPoolCheckInMonitorModeCountsButDoesNotThrow() {
            .put(
        );
        assertEquals(admissionController.getSettings().getTransportLayerAdmissionControllerMode(), AdmissionControlMode.DISABLED);
            clusterService,
            rs,
        admissionController = new NativeMemoryBasedAdmissionController(
    }
            rs,
            rs,
            )
    }
            null
        );
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.INDEXING.getType()), 1);
            null
            admissionController.getSettings().getSearchNativeMemoryUsageLimit().longValue(),
        admissionController = new NativeMemoryBasedAdmissionController(
        action = "indices:data/write/bulk[s][p]";
        String localNodeId = clusterService.state().nodes().getLocalNodeId();
        );
    public void tearDown() throws Exception {
        );
            settings,
        Settings settings = Settings.builder()
            admissionController.isEnabledForTransportLayer(admissionController.getSettings().getTransportLayerAdmissionControllerMode())
                NativeMemoryBasedAdmissionControllerSettings.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),
                AdmissionControlMode.MONITOR.getMode()
        );
                NativeMemoryBasedAdmissionControllerSettings.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),
            null
        admissionController.apply(action, AdmissionControlActionType.SEARCH);
        admissionController.apply(action, AdmissionControlActionType.INDEXING);
    }
            null
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER,
    }
            .build();
                NativeMemoryBasedAdmissionControllerSettings.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),
        when(rs.getNodeStatistics(localNodeId)).thenReturn(Optional.of(stats));
            indexingPoolSupplier(95, 100)
            admissionController.getSettings().getClusterAdminNativeMemoryUsageLimit().longValue(),
        admissionController = new NativeMemoryBasedAdmissionController(
            rs,
            org.opensearch.core.concurrency.OpenSearchRejectedExecutionException.class,
            .put(NativeMemoryBasedAdmissionControllerSettings.SEARCH_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 50)
    }
            clusterService,
            null
            .build();
            admissionController.getSettings().getIndexingNativeMemoryUsageLimit().longValue(),
    private static Supplier<NativeAllocatorPoolStats> indexingPoolSupplier(long allocatedBytes, long limitBytes) {
        action = "indices:data/read/search";
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlMode;
    public void testApplyControllerWhenMemoryUsageBreached() {
                NativeMemoryBasedAdmissionControllerSettings.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),
        assertEquals(admissionController.getRejectionCount(AdmissionControlActionType.INDEXING.getType()), 3);
                    limitBytes,
                NativeMemoryBasedAdmissionControllerSettings.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),
            .put(NativeMemoryBasedAdmissionControllerSettings.INDEXING_NATIVE_MEMORY_POOL_USAGE_LIMIT.getKey(), 90)
    }
        // Indexing pool is breached (95%) but the action is SEARCH, so the pool check must not apply
        NodeResourceUsageStats stats = new NodeResourceUsageStats(localNodeId, System.currentTimeMillis(), 50, 50, null, 30);
        assertEquals(admissionController.getSettings().getIndexingNativeMemoryUsageLimit().longValue(), 70);
 * SPDX-License-Identifier: Apache-2.0
            )
            clusterService,
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER,
        Settings settings = Settings.builder()
            null
            clusterService,
                    allocatedBytes,
                AdmissionControlMode.ENFORCED.getMode()
import org.opensearch.threadpool.TestThreadPool;
        expectThrows(
