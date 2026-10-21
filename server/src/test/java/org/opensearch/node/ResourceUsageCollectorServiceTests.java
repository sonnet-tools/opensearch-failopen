import static org.hamcrest.Matchers.greaterThan;
import java.util.Map;
            System.currentTimeMillis(),
 * are working as expected
import java.util.Optional;
import org.opensearch.cluster.ClusterName;
                    .add(DiscoveryNode.createLocal(Settings.EMPTY, new TransportAddress(TransportAddress.META_ADDRESS, 9201), "node2"))
            randomIntBetween(1, 100)
        String[] nodes = new String[] { "a", "b", "c", "d" };
            5,
        assertEquals(99.0, nodeStats.get("node1").cpuUtilizationPercent, 0.0);
            TimeUnit.SECONDS
        assertEquals(98, nodeStats.get("node1").getIoUsageStats().getIoUtilisationPercent(), 0.0);
        for (String nodeId : nodes) {
    protected boolean resetNodeAfterTest() {
        assertTrue(nodeResourceUsageStatsOptional.isEmpty());
        assertAcked(
import org.opensearch.common.unit.TimeValue;
        resourceUsageCollectorService.collectNodeResourceUsageStats(
    }
            new IoUsageStats(randomIntBetween(1, 100)),
                    System.currentTimeMillis(),
 * compatible open source license.
    }
                    randomIntBetween(1, 100),
            .nodes(
        assertEquals(97.0, nodeResourceUsageStatsOptional.get().memoryUtilizationPercent, 0.0);
            .put(ResourceTrackerSettings.GLOBAL_JVM_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(500))
        t4.start();
    public void testConcurrentAddingAndRemovingNodes() throws Exception {
import org.junit.After;
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlMode;
    public void testResourceUsageStats() {
        ClusterState newState = ClusterState.builder(previousState)
            System.currentTimeMillis(),
/**
                greaterThan(0.0)
    @Override
import org.opensearch.cluster.ClusterState;
                );
                .setPersistentSettings(Settings.builder().putNull("*"))
        assertEquals(97.0, nodeStats.get("node1").memoryUtilizationPercent, 0.0);
 * Tests for ResourceUsageCollectorService where we test collect method, get method and whether schedulers
            latch.countDown();
    }
    public void cleanup() {
    public void testScheduler() throws Exception {
        Runnable f = () -> {
import org.opensearch.common.settings.Settings;
        final CountDownLatch latch = new CountDownLatch(5);
        resourceUsageCollectorService.clusterChanged(event);
        assertEquals(99, nodeResourceUsageStatsOptional.get().nativeMemoryUtilizationPercent, 0.0);
/*
                    randomFrom(nodes),
    /*
        );
import java.util.concurrent.TimeUnit;
        latch.countDown();
        t2.join();
            randomIntBetween(1, 100),
        );
            if (nodeStats.containsKey(nodeId)) {
import org.opensearch.core.common.transport.TransportAddress;
            "node1",
     */
                }
        assertEquals(99.0, nodeResourceUsageStatsOptional.get().cpuUtilizationPercent, 0.0);
        assertBusy(
 *
        );
         */
            client().admin()
            randomIntBetween(1, 100),
            } catch (InterruptedException e) {
     * Test that concurrently adding values and removing nodes does not cause exceptions
        Map<String, NodeResourceUsageStats> nodeStats = resourceUsageCollectorService.getAllNodeStatistics();
            .put(ADMISSION_CONTROL_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.ENFORCED)
        assertBusy(() -> assertEquals(1, resourceUsageCollectorService.getAllNodeStatistics().size()));
        ResourceUsageCollectorService resourceUsageCollectorService = getInstanceFromNode(ResourceUsageCollectorService.class);
                resourceUsageCollectorService.collectNodeResourceUsageStats(
                assertThat(nodeStats.get(nodeId).nativeMemoryUtilizationPercent, greaterThan(0.0));
 */
        ClusterService clusterService = getInstanceFromNode(ClusterService.class);
        nodeResourceUsageStatsOptional = resourceUsageCollectorService.getNodeStatistics("node2");
            randomIntBetween(1, 100),
        assertNotNull(nodeResourceUsageStatsOptional.get());
                    randomIntBetween(1, 100)
                assertThat(nodeStats.get(nodeId).getIoUsageStats().getIoUtilisationPercent(), greaterThan(0.0));
        assertEquals(98, nodeResourceUsageStatsOptional.get().getIoUsageStats().getIoUtilisationPercent(), 0.0);
        t3.join();
 * SPDX-License-Identifier: Apache-2.0
            try {
        ResourceUsageCollectorService resourceUsageCollectorService = getInstanceFromNode(ResourceUsageCollectorService.class);
import org.opensearch.cluster.node.DiscoveryNode;
        /**
            .put(ResourceTrackerSettings.GLOBAL_IO_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(5000))
 * this file be licensed under the Apache-2.0 license or a
                    randomIntBetween(1, 100),
import java.util.concurrent.CountDownLatch;
                resourceUsageCollectorService.getNodeStatistics(clusterService.localNode().getId()).get().getMemoryUtilizationPercent(),
            .build();
                fail("should not be interrupted");
            for (int i = 0; i < randomIntBetween(100, 200); i++) {
            }
        t3.start();
        Optional<NodeResourceUsageStats> nodeResourceUsageStatsOptional = resourceUsageCollectorService.getNodeStatistics("node1");
                .cluster()
        ResourceUsageCollectorService resourceUsageCollectorService = getInstanceFromNode(ResourceUsageCollectorService.class);
            .put(ResourceTrackerSettings.GLOBAL_CPU_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(500))
            "node2",
    public void testNodeRemoval() {
                latch.await();
        Thread t2 = new Thread(f);
        t4.join();
            )
        Thread t4 = new Thread(f);
            randomIntBetween(1, 100),
            .build();
        assertTrue(nodeStats.containsKey("node1"));
        resourceUsageCollectorService.collectNodeResourceUsageStats(
    }
        ClusterChangedEvent event = new ClusterChangedEvent("test", newState, previousState);
            .build();
        );
        assertTrue(nodeStats.containsKey("node1"));
        }
public class ResourceUsageCollectorServiceTests extends OpenSearchSingleNodeTestCase {
    @After
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            }
import static org.opensearch.ratelimitting.admissioncontrol.AdmissionControlSettings.ADMISSION_CONTROL_TRANSPORT_LAYER_MODE;
            .put(super.nodeSettings())
        ResourceUsageCollectorService resourceUsageCollectorService = getInstanceFromNode(ResourceUsageCollectorService.class);
                    .add(DiscoveryNode.createLocal(Settings.EMPTY, new TransportAddress(TransportAddress.META_ADDRESS, 9200), "node1"))
                .setTransientSettings(Settings.builder().putNull("*"))
         * Wait for memory utilization to be reported greater than 0
 */
        resourceUsageCollectorService.collectNodeResourceUsageStats("node1", System.currentTimeMillis(), 97, 99, new IoUsageStats(98), 99);
        t2.start();
    }
        assertFalse(nodeStats.containsKey("node2"));
            ),
                assertThat(nodeStats.get(nodeId).memoryUtilizationPercent, greaterThan(0.0));
}
            new IoUsageStats(randomIntBetween(1, 100)),
        final Map<String, NodeResourceUsageStats> nodeStats = resourceUsageCollectorService.getAllNodeStatistics();
                    new IoUsageStats(randomIntBetween(1, 100)),
    @Override
         */
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            randomIntBetween(1, 100)
 * The OpenSearch Contributors require contributions made to
import org.opensearch.cluster.node.DiscoveryNodes;
            }
                .prepareUpdateSettings()
package org.opensearch.node;
        assertTrue(resourceUsageCollectorService.getNodeStatistics("Invalid").isEmpty());
        return Settings.builder()
    }
        t1.start();
        /**
    }
         * Wait for cluster state to be ready so that localNode().getId() is ready and we add the values to the map
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;
import org.opensearch.cluster.ClusterChangedEvent;
        final Map<String, NodeResourceUsageStats> nodeStats = resourceUsageCollectorService.getAllNodeStatistics();
                if (randomBoolean()) {
            .nodes(DiscoveryNodes.builder(previousState.nodes()).remove("node2"))
import org.opensearch.cluster.service.ClusterService;
            .put(ResourceTrackerSettings.GLOBAL_NATIVE_MEMORY_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueSeconds(5))
    protected Settings nodeSettings() {
                assertThat(nodeStats.get(nodeId).cpuUtilizationPercent, greaterThan(0.0));
        Thread t1 = new Thread(f);
        };
        return true;
        assertEquals(99.0, nodeStats.get("node1").nativeMemoryUtilizationPercent, 0.0);
        Thread t3 = new Thread(f);
            () -> assertThat(
        ClusterState previousState = ClusterState.builder(new ClusterName("cluster"))
        t1.join();
                    resourceUsageCollectorService.removeNodeResourceUsageStats(randomFrom(nodes));
                DiscoveryNodes.builder()
