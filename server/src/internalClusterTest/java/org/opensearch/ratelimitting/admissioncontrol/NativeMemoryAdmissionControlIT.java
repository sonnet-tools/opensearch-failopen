     * regardless of mode.  
     */
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlMode;
        collector.collectNodeResourceUsageStats(nodeId, System.currentTimeMillis(), 30, 30, new IoUsageStats(10), 95);
            .put(SEARCH_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 85)  
    public void testRequestsSucceedWhenBelowThreshold() {
        // Inject 95% — above the 80% limit  
import static org.opensearch.ratelimitting.admissioncontrol.AdmissionControlSettings.ADMISSION_CONTROL_TRANSPORT_LAYER_MODE;  
import org.opensearch.node.ResourceUsageCollectorService;
     */  
import org.opensearch.test.OpenSearchIntegTestCase;  
        Settings nodeSettings = Settings.builder()  
            .put(ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.getKey(), "4gb")
            .put(NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.ENFORCED.getMode())
import org.opensearch.common.unit.TimeValue;  
package org.opensearch.ratelimitting.admissioncontrol;
    /**
import org.opensearch.plugins.Plugin;
    }
            .build();
        client().prepareSearch("test-index").get();
        String node = internalCluster().startNode(nodeSettings);
     * Uses a two-node cluster so requests cross the transport layer.
        assertEquals(75.0, collector.getNodeStatistics(nodeId).get().getNativeMemoryUtilizationPercent(), 0.01);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        String node = internalCluster().startNode(nodeSettings);
            .execute()
    }  
}  
        Settings nodeSettings = Settings.builder()
        ResourceUsageCollectorService collector = internalCluster().getInstance(ResourceUsageCollectorService.class, node);  
 */  
 * - Monitor mode (counting but not rejecting)
 * - Explicit limit configured  
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;  
 * - No limit configured (auto-derived from totalRAM - jvmMaxHeap)
        String node = internalCluster().startNode(nodeSettings);
        Settings nodeSettings = Settings.builder()  
    }
     */  
            .build();  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .put(ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.getKey(), "4gb")
            .put(ResourceTrackerSettings.GLOBAL_NATIVE_MEMORY_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueSeconds(5))
 * The OpenSearch Contributors require contributions made to  
        collector.collectNodeResourceUsageStats(nodeId, System.currentTimeMillis(), 30, 30, new IoUsageStats(10), 95);
     * the injected utilization and the admission controller should count breaches.
        String nodeId = internalCluster().clusterService(node).localNode().getId();
     * When native memory utilization is below the threshold, requests should always succeed
        return List.of(MockTransportService.TestPlugin.class);  
            .put(ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.getKey(), "4gb")
        collector.collectNodeResourceUsageStats(nodeId, System.currentTimeMillis(), 30, 30, new IoUsageStats(10), 75);  
            .put(SEARCH_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 85)
 */  
            .put(SEARCH_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 80)
 * this file be licensed under the Apache-2.0 license or a
        collector.collectNodeResourceUsageStats(nodeId, System.currentTimeMillis(), 30, 30, new IoUsageStats(10), 40);  
        ensureGreen();  
        ensureGreen();  
    public void testDynamicLimitUpdate() {
    /**  
     * Dynamic settings update: changing the threshold at runtime should take effect immediately.
     * Monitor mode should allow requests through even when limits are breached,  
        ensureGreen();  
        assertEquals(40.0, collector.getNodeStatistics(nodeId).get().getNativeMemoryUtilizationPercent(), 0.01);
        assertAcked(prepareCreate("test-index").setMapping("field", "type=text"));  
            .put(NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.MONITOR.getMode())
    public void testExplicitLimitTracksUtilization() {  
        // In MONITOR mode, request should still succeed (not rejected)  
        assertTrue(collector.getNodeStatistics(nodeId).isPresent());  
        ResourceUsageCollectorService collector = internalCluster().getInstance(ResourceUsageCollectorService.class, node);  
        // Verify the stats are visible  
    }
            .setTransientSettings(Settings.builder().put(ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.getKey(), "8gb"))
import org.opensearch.action.index.IndexRequest;
import org.opensearch.node.IoUsageStats;
import java.util.List;
        String nodeId = internalCluster().clusterService(node).localNode().getId();  
    public void testMonitorModeAllowsRequestsWhenLimitBreached() {  
        // Inject new stats — should still be trackable after settings update
    }
        client().index(new IndexRequest("test-index").source("field", "value")).actionGet();
    /**  
        String node = internalCluster().startNode(nodeSettings);
            .put(ResourceTrackerSettings.GLOBAL_NATIVE_MEMORY_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueSeconds(5))  
            .put(ResourceTrackerSettings.GLOBAL_NATIVE_MEMORY_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueSeconds(5))
            .build();  
        // 40% utilization — well below 85% threshold
        Settings nodeSettings = Settings.builder()
        // Inject 50% native memory utilization — below the 85% threshold
            .actionGet();  
    @Override
        String nodeId = internalCluster().clusterService(node).localNode().getId();
        String node = internalCluster().startNode(nodeSettings);  
        ResourceUsageCollectorService collector = internalCluster().getInstance(ResourceUsageCollectorService.class, node);  
        assertAcked(prepareCreate("test-index").setMapping("field", "type=text"));  
        // Verify stats are tracked
     * Dynamic settings update: changing the native memory limit at runtime should be visible
        ensureGreen();
            .cluster()
        String nodeId = internalCluster().clusterService(node).localNode().getId();
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        ResourceUsageCollectorService collector = internalCluster().getInstance(ResourceUsageCollectorService.class, node);  
            .put(SEARCH_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 80)
            .put(INDEXING_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 85)
 * SPDX-License-Identifier: Apache-2.0
            .put(NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.MONITOR.getMode())  
import static org.opensearch.ratelimitting.admissioncontrol.settings.NativeMemoryBasedAdmissionControllerSettings.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE;
     * When no node.native_memory.limit is set, the tracker should auto-derive the budget
            .put(ADMISSION_CONTROL_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.MONITOR.getMode())  
        assertTrue(collector.getNodeStatistics(nodeId).isPresent());
        // Update the native memory limit dynamically  
import static org.opensearch.ratelimitting.admissioncontrol.settings.NativeMemoryBasedAdmissionControllerSettings.INDEXING_NATIVE_MEMORY_USAGE_LIMIT;
        client().prepareSearch("test-index").get();
        Settings nodeSettings = Settings.builder()
     */
        ResourceUsageCollectorService collector = internalCluster().getInstance(ResourceUsageCollectorService.class, node);
    /**
        String nodeId = internalCluster().clusterService(node).localNode().getId();
    }  
        client().admin()
import org.opensearch.test.transport.MockTransportService;
        client().index(new IndexRequest("test-index").source("field", "value")).actionGet();
            .put(ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.getKey(), "8gb")
import org.opensearch.common.settings.Settings;
            .build();  
            .prepareUpdateSettings()  
        // Search should succeed — 50% is below the 85% limit
/*  
        collector.collectNodeResourceUsageStats(nodeId, System.currentTimeMillis(), 30, 30, new IoUsageStats(10), 40);  
     * With explicit node.native_memory.limit configured, the tracker should report  
public class NativeMemoryAdmissionControlIT extends OpenSearchIntegTestCase {
 * - Enforced mode rejecting requests
/**  
            .put(ResourceTrackerSettings.GLOBAL_NATIVE_MEMORY_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueSeconds(5))
            .put(NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.ENFORCED.getMode())  
        assertEquals(95.0, collector.getNodeStatistics(nodeId).get().getNativeMemoryUtilizationPercent(), 0.01);
     * but should still count rejections.
 *
import java.util.Collection;  
    public void testAutoDerivesLimitWhenNotConfigured() {
     */
        collector.stop();
import static org.opensearch.ratelimitting.admissioncontrol.settings.NativeMemoryBasedAdmissionControllerSettings.SEARCH_NATIVE_MEMORY_USAGE_LIMIT;  
            .put(ResourceTrackerSettings.GLOBAL_NATIVE_MEMORY_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueSeconds(5))
     * in the tracker's effective budget calculation.  
        client().prepareSearch("test-index").get();  
        // Inject 95% native memory — above the 80% threshold  
        collector.collectNodeResourceUsageStats(nodeId, System.currentTimeMillis(), 30, 30, new IoUsageStats(10), 50);  
        client().index(new IndexRequest("test-index").source("field", "value")).actionGet();
 * Integration tests for native memory based admission control across different configurations:
        assertAcked(prepareCreate("test-index").setMapping("field", "type=text"));  
        ensureGreen();  
 * compatible open source license.
        collector.stop();
        // Inject utilization stats
     * from totalPhysicalMemory - jvmMaxHeap. The admission controller should still function.
    /**
    /**
            .build();  
     */
