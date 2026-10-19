 * are working as expected
                    randomIntBetween(1, 100)
        };
                latch.await();
            randomIntBetween(1, 100),
        }
                if (randomBoolean()) {
         */
        assertEquals(99.0, nodeResourceUsageStatsOptional.get().cpuUtilizationPercent, 0.0);
        final Map<String, NodeResourceUsageStats> nodeStats = resourceUsageCollectorService.getAllNodeStatistics();  
        );
import org.opensearch.cluster.node.DiscoveryNodes;
        ResourceUsageCollectorService resourceUsageCollectorService = getInstanceFromNode(ResourceUsageCollectorService.class);
                assertThat(nodeStats.get(nodeId).getIoUsageStats().getIoUtilisationPercent(), greaterThan(0.0));  
                    new IoUsageStats(randomIntBetween(1, 100)),  
            System.currentTimeMillis(),
        t2.start();  
    }
 *
         */
            randomIntBetween(1, 100),  
        assertTrue(nodeStats.containsKey("node1"));
import static org.opensearch.ratelimitting.admissioncontrol.AdmissionControlSettings.ADMISSION_CONTROL_TRANSPORT_LAYER_MODE;
            }
        Map<String, NodeResourceUsageStats> nodeStats = resourceUsageCollectorService.getAllNodeStatistics();  
        assertTrue(nodeResourceUsageStatsOptional.isEmpty());
                .cluster()
 * Tests for ResourceUsageCollectorService where we test collect method, get method and whether schedulers
        final Map<String, NodeResourceUsageStats> nodeStats = resourceUsageCollectorService.getAllNodeStatistics();
                    randomFrom(nodes),
            randomIntBetween(1, 100),
        ResourceUsageCollectorService resourceUsageCollectorService = getInstanceFromNode(ResourceUsageCollectorService.class);  
        );
    }  
import org.opensearch.test.OpenSearchSingleNodeTestCase;  
package org.opensearch.node;
         * Wait for memory utilization to be reported greater than 0
                    randomIntBetween(1, 100),
            .build();  
        ClusterService clusterService = getInstanceFromNode(ClusterService.class);  
            randomIntBetween(1, 100)  
        ClusterState newState = ClusterState.builder(previousState)
        Thread t4 = new Thread(f);  
            )
        assertTrue(resourceUsageCollectorService.getNodeStatistics("Invalid").isEmpty());
        );
            .put(ResourceTrackerSettings.GLOBAL_NATIVE_MEMORY_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueSeconds(5))
                resourceUsageCollectorService.collectNodeResourceUsageStats(
                assertThat(nodeStats.get(nodeId).nativeMemoryUtilizationPercent, greaterThan(0.0));
                    resourceUsageCollectorService.removeNodeResourceUsageStats(randomFrom(nodes));
    protected boolean resetNodeAfterTest() {  
    protected Settings nodeSettings() {
import org.opensearch.core.common.transport.TransportAddress;  
            .put(ResourceTrackerSettings.GLOBAL_IO_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(5000))
        Runnable f = () -> {
 * compatible open source license.
        final CountDownLatch latch = new CountDownLatch(5);  
import org.opensearch.common.unit.TimeValue;
    public void testScheduler() throws Exception {
     */
    }
            .build();
                resourceUsageCollectorService.getNodeStatistics(clusterService.localNode().getId()).get().getMemoryUtilizationPercent(),
            } catch (InterruptedException e) {  
        assertBusy(() -> assertEquals(1, resourceUsageCollectorService.getAllNodeStatistics().size()));
/*  
        ResourceUsageCollectorService resourceUsageCollectorService = getInstanceFromNode(ResourceUsageCollectorService.class);
    public void testConcurrentAddingAndRemovingNodes() throws Exception {
        assertEquals(99, nodeResourceUsageStatsOptional.get().nativeMemoryUtilizationPercent, 0.0);
        Thread t2 = new Thread(f);
import static org.hamcrest.Matchers.greaterThan;
        t4.join();
        assertBusy(  
        t1.start();
            }  
        resourceUsageCollectorService.collectNodeResourceUsageStats(
     * Test that concurrently adding values and removing nodes does not cause exceptions  
        t2.join();
    public void testResourceUsageStats() {  
            .build();  
        String[] nodes = new String[] { "a", "b", "c", "d" };
        return Settings.builder()  
            latch.countDown();  
import org.opensearch.cluster.ClusterChangedEvent;
 * SPDX-License-Identifier: Apache-2.0
            .nodes(
                fail("should not be interrupted");
                    System.currentTimeMillis(),  
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;
        assertTrue(nodeStats.containsKey("node1"));
        assertEquals(98, nodeResourceUsageStatsOptional.get().getIoUsageStats().getIoUtilisationPercent(), 0.0);  
        assertEquals(99.0, nodeStats.get("node1").cpuUtilizationPercent, 0.0);
            .put(ADMISSION_CONTROL_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.ENFORCED)  
                }  
    }
            "node1",
            randomIntBetween(1, 100),
import org.opensearch.cluster.ClusterName;
    }  
                );
}
        /**  
        Thread t1 = new Thread(f);  
        assertNotNull(nodeResourceUsageStatsOptional.get());  
                assertThat(nodeStats.get(nodeId).cpuUtilizationPercent, greaterThan(0.0));
            for (int i = 0; i < randomIntBetween(100, 200); i++) {  
        assertEquals(97.0, nodeResourceUsageStatsOptional.get().memoryUtilizationPercent, 0.0);
        resourceUsageCollectorService.clusterChanged(event);  
         * Wait for cluster state to be ready so that localNode().getId() is ready and we add the values to the map  
        t4.start();
 * The OpenSearch Contributors require contributions made to  
        assertFalse(nodeStats.containsKey("node2"));  
            try {
/**  
import java.util.Map;  
        Thread t3 = new Thread(f);
                assertThat(nodeStats.get(nodeId).memoryUtilizationPercent, greaterThan(0.0));  
                DiscoveryNodes.builder()
    public void cleanup() {
        return true;
        t3.start();
    @Override
            .put(super.nodeSettings())
    public void testNodeRemoval() {
import org.opensearch.cluster.service.ClusterService;  
            .put(ResourceTrackerSettings.GLOBAL_JVM_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(500))  
            TimeUnit.SECONDS  
            .nodes(DiscoveryNodes.builder(previousState.nodes()).remove("node2"))
 */  
    }
            client().admin()
import org.opensearch.cluster.ClusterState;  
                    .add(DiscoveryNode.createLocal(Settings.EMPTY, new TransportAddress(TransportAddress.META_ADDRESS, 9200), "node1"))  
            .put(ResourceTrackerSettings.GLOBAL_CPU_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(500))
                .prepareUpdateSettings()  
            }
            new IoUsageStats(randomIntBetween(1, 100)),
import org.opensearch.common.settings.Settings;
    }
import java.util.concurrent.TimeUnit;  
 */  
        ClusterChangedEvent event = new ClusterChangedEvent("test", newState, previousState);
        ResourceUsageCollectorService resourceUsageCollectorService = getInstanceFromNode(ResourceUsageCollectorService.class);  
        t3.join();  
        ClusterState previousState = ClusterState.builder(new ClusterName("cluster"))  
            new IoUsageStats(randomIntBetween(1, 100)),  
        latch.countDown();  
                    randomIntBetween(1, 100),
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
import org.opensearch.cluster.node.DiscoveryNode;
        assertAcked(  
            if (nodeStats.containsKey(nodeId)) {
            System.currentTimeMillis(),  
                .setTransientSettings(Settings.builder().putNull("*"))
        nodeResourceUsageStatsOptional = resourceUsageCollectorService.getNodeStatistics("node2");  
                greaterThan(0.0)  
    @After
                    .add(DiscoveryNode.createLocal(Settings.EMPTY, new TransportAddress(TransportAddress.META_ADDRESS, 9201), "node2"))
        Optional<NodeResourceUsageStats> nodeResourceUsageStatsOptional = resourceUsageCollectorService.getNodeStatistics("node1");
import java.util.Optional;
        resourceUsageCollectorService.collectNodeResourceUsageStats(  
        for (String nodeId : nodes) {
    @Override
        );  
            5,
        assertEquals(98, nodeStats.get("node1").getIoUsageStats().getIoUtilisationPercent(), 0.0);
            randomIntBetween(1, 100)
            ),
        assertEquals(97.0, nodeStats.get("node1").memoryUtilizationPercent, 0.0);  
    /*
            "node2",
public class ResourceUsageCollectorServiceTests extends OpenSearchSingleNodeTestCase {
import org.junit.After;
                .setPersistentSettings(Settings.builder().putNull("*"))
import java.util.concurrent.CountDownLatch;
        assertEquals(99.0, nodeStats.get("node1").nativeMemoryUtilizationPercent, 0.0);
        resourceUsageCollectorService.collectNodeResourceUsageStats("node1", System.currentTimeMillis(), 97, 99, new IoUsageStats(98), 99);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlMode;
        /**
        t1.join();
            () -> assertThat(
