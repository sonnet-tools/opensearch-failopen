        ResourceUsageCollectorService collector = internalCluster().getInstance(ResourceUsageCollectorService.class, node);
 * this file be licensed under the Apache-2.0 license or a
}
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
    /**
import org.opensearch.common.settings.Settings;
    public void testExplicitLimitTracksUtilization() {
     */
 * compatible open source license.
        assertEquals(75.0, collector.getNodeStatistics(nodeId).get().getNativeMemoryUtilizationPercent(), 0.01);
            .put(SEARCH_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 80)
        // Search should succeed — 50% is below the 85% limit
import org.opensearch.node.ResourceUsageCollectorService;
        String nodeId = internalCluster().clusterService(node).localNode().getId();
import java.util.List;
        collector.stop();
    public void testRequestsSucceedWhenBelowThreshold() {
        // 40% utilization — well below 85% threshold
 * SPDX-License-Identifier: Apache-2.0
        client().index(new IndexRequest("test-index").source("field", "value")).actionGet();
            .put(ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.getKey(), "4gb")
     * Dynamic settings update: changing the native memory limit at runtime should be visible
/*
            .put(ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.getKey(), "8gb")
     * With explicit node.native_memory.limit configured, the tracker should report
            .put(ResourceTrackerSettings.GLOBAL_NATIVE_MEMORY_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueSeconds(5))
        String nodeId = internalCluster().clusterService(node).localNode().getId();
        String node = internalCluster().startNode(nodeSettings);
        assertTrue(collector.getNodeStatistics(nodeId).isPresent());
        // Inject new stats — should still be trackable after settings update
        client().index(new IndexRequest("test-index").source("field", "value")).actionGet();
import static org.opensearch.ratelimitting.admissioncontrol.settings.NativeMemoryBasedAdmissionControllerSettings.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE;
     */
     * but should still count rejections.
        String node = internalCluster().startNode(nodeSettings);
        ensureGreen();
import org.opensearch.test.transport.MockTransportService;
        // Inject utilization stats
        // Update the native memory limit dynamically
        client().prepareSearch("test-index").get();
    }
        String node = internalCluster().startNode(nodeSettings);
import static org.opensearch.ratelimitting.admissioncontrol.settings.NativeMemoryBasedAdmissionControllerSettings.SEARCH_NATIVE_MEMORY_USAGE_LIMIT;
            .put(ResourceTrackerSettings.GLOBAL_NATIVE_MEMORY_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueSeconds(5))
        Settings nodeSettings = Settings.builder()
        // Verify the stats are visible
        Settings nodeSettings = Settings.builder()
     * Monitor mode should allow requests through even when limits are breached,
 */
        ensureGreen();
            .actionGet();
        // Verify stats are tracked
import static org.opensearch.ratelimitting.admissioncontrol.settings.NativeMemoryBasedAdmissionControllerSettings.INDEXING_NATIVE_MEMORY_USAGE_LIMIT;
        Settings nodeSettings = Settings.builder()
    public void testMonitorModeAllowsRequestsWhenLimitBreached() {
import org.opensearch.node.IoUsageStats;
     */
        assertAcked(prepareCreate("test-index").setMapping("field", "type=text"));
    public void testDynamicLimitUpdate() {
    /**
            .put(ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.getKey(), "4gb")
            .put(ResourceTrackerSettings.GLOBAL_NATIVE_MEMORY_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueSeconds(5))
    public void testAutoDerivesLimitWhenNotConfigured() {
package org.opensearch.ratelimitting.admissioncontrol;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    }
public class NativeMemoryAdmissionControlIT extends OpenSearchIntegTestCase {
    }
 *
        ensureGreen();
            .execute()
     * from totalPhysicalMemory - jvmMaxHeap. The admission controller should still function.
        collector.collectNodeResourceUsageStats(nodeId, System.currentTimeMillis(), 30, 30, new IoUsageStats(10), 40);
    }
        collector.stop();
            .put(ResourceTrackerSettings.GLOBAL_NATIVE_MEMORY_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueSeconds(5))
            .build();
        client().prepareSearch("test-index").get();
     * Dynamic settings update: changing the threshold at runtime should take effect immediately.
 * - Monitor mode (counting but not rejecting)
/**
        String nodeId = internalCluster().clusterService(node).localNode().getId();
        client().prepareSearch("test-index").get();
    /**
import org.opensearch.test.OpenSearchIntegTestCase;
 * - No limit configured (auto-derived from totalRAM - jvmMaxHeap)
import static org.opensearch.ratelimitting.admissioncontrol.AdmissionControlSettings.ADMISSION_CONTROL_TRANSPORT_LAYER_MODE;
import org.opensearch.common.unit.TimeValue;
            .put(NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.ENFORCED.getMode())
 * The OpenSearch Contributors require contributions made to
     * When no node.native_memory.limit is set, the tracker should auto-derive the budget
    /**
        ResourceUsageCollectorService collector = internalCluster().getInstance(ResourceUsageCollectorService.class, node);
        // Inject 50% native memory utilization — below the 85% threshold
            .put(NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.ENFORCED.getMode())
            .build();
            .cluster()
            .put(SEARCH_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 85)
 * Integration tests for native memory based admission control across different configurations:
        // In MONITOR mode, request should still succeed (not rejected)
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlMode;
        // Inject 95% — above the 80% limit
    @Override
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;
     */
            .put(INDEXING_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 85)
            .put(SEARCH_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 80)
        assertAcked(prepareCreate("test-index").setMapping("field", "type=text"));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            .put(ADMISSION_CONTROL_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.MONITOR.getMode())
            .put(ResourceTrackerSettings.GLOBAL_NATIVE_MEMORY_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueSeconds(5))
     * Uses a two-node cluster so requests cross the transport layer.
        assertAcked(prepareCreate("test-index").setMapping("field", "type=text"));
 */
        ResourceUsageCollectorService collector = internalCluster().getInstance(ResourceUsageCollectorService.class, node);
     * in the tracker's effective budget calculation.
        client().admin()
import java.util.Collection;
     */
        String nodeId = internalCluster().clusterService(node).localNode().getId();
            .put(NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.MONITOR.getMode())
        ResourceUsageCollectorService collector = internalCluster().getInstance(ResourceUsageCollectorService.class, node);
        ensureGreen();
import org.opensearch.plugins.Plugin;
        Settings nodeSettings = Settings.builder()
        collector.collectNodeResourceUsageStats(nodeId, System.currentTimeMillis(), 30, 30, new IoUsageStats(10), 75);
     * When native memory utilization is below the threshold, requests should always succeed
        collector.collectNodeResourceUsageStats(nodeId, System.currentTimeMillis(), 30, 30, new IoUsageStats(10), 40);
        collector.collectNodeResourceUsageStats(nodeId, System.currentTimeMillis(), 30, 30, new IoUsageStats(10), 95);
        // Inject 95% native memory — above the 80% threshold
            .build();
 * - Explicit limit configured
            .prepareUpdateSettings()
import org.opensearch.action.index.IndexRequest;
        collector.collectNodeResourceUsageStats(nodeId, System.currentTimeMillis(), 30, 30, new IoUsageStats(10), 50);
        assertEquals(40.0, collector.getNodeStatistics(nodeId).get().getNativeMemoryUtilizationPercent(), 0.01);
        ensureGreen();
            .build();
     */
            .build();
 * - Enforced mode rejecting requests
            .put(SEARCH_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 85)
        ResourceUsageCollectorService collector = internalCluster().getInstance(ResourceUsageCollectorService.class, node);
            .setTransientSettings(Settings.builder().put(ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.getKey(), "8gb"))
    /**
    }
            .put(NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.MONITOR.getMode())
    }
        client().index(new IndexRequest("test-index").source("field", "value")).actionGet();
        assertEquals(95.0, collector.getNodeStatistics(nodeId).get().getNativeMemoryUtilizationPercent(), 0.01);
     * regardless of mode.
        return List.of(MockTransportService.TestPlugin.class);
    /**
     * the injected utilization and the admission controller should count breaches.
        collector.collectNodeResourceUsageStats(nodeId, System.currentTimeMillis(), 30, 30, new IoUsageStats(10), 95);
        String node = internalCluster().startNode(nodeSettings);
        String nodeId = internalCluster().clusterService(node).localNode().getId();
        assertTrue(collector.getNodeStatistics(nodeId).isPresent());
        String node = internalCluster().startNode(nodeSettings);
            .put(ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.getKey(), "4gb")
        Settings nodeSettings = Settings.builder()
