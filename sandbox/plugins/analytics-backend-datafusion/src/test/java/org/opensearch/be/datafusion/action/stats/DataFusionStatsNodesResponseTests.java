    }
import org.opensearch.common.xcontent.XContentHelper;
    @SuppressWarnings("unchecked")
        );
        assertTrue(map.containsKey("cluster_name"));
        taskMonitors.put("query_execution", new TaskMonitorStats(40, 50, 60, 0, 0));
        DataFusionStatsNodesResponse response = new DataFusionStatsNodesResponse(
        assertEquals(3, nodesHeader.get("total"));
        // successful = number of successful responses = 3
        // Verify nodes object has the node keyed by ID
            Collections.emptyMap(),
        Map<String, Object> nodes = (Map<String, Object>) map.get("nodes");
            Collections.emptyList()
        assertFalse(nodeEntry.containsKey("plan_setup"));
        assertFalse(nodeEntry.containsKey("name"));
        );
        assertFalse(nodeEntry.containsKey("host"));
        assertTrue(nodeEntry.containsKey("io_runtime"));
    // ---- Test 3: Failures array rendering ----
            null,
    public void testToXContentClusterName() throws Exception {
        Map<String, TaskMonitorStats> taskMonitors = new LinkedHashMap<>();
        builder.endObject();
import java.util.Map;
        return XContentHelper.convertToMap(MediaTypeRegistry.JSON.xContent(), builder.toString(), false);
 * Unit tests for {@link DataFusionStatsNodesResponse#toXContent}.
        taskMonitors.put("plan_setup", new TaskMonitorStats(100, 110, 120, 0, 0));
        assertEquals(expectedClusterName, map.get("cluster_name"));
            Collections.emptyList()
        List<Object> failuresArray = (List<Object>) nodesHeader.get("failures");
            clusterName,
        Map<String, Object> nodeEntry = (Map<String, Object>) nodes.get("node-abc-123");
        DiscoveryNode node = createNode("node-1", "node-1", "127.0.0.1", 9300);
        // failed = number of failures = 2
        Map<String, Object> map = renderToMap(response);
            List.of(nodeResponse),
        assertEquals(3, nodes.size());
        assertEquals(2, nodesHeader.get("failed"));
import org.opensearch.core.xcontent.MediaTypeRegistry;
    public void testToXContentNodeMetadata() throws Exception {
import org.opensearch.be.datafusion.stats.NativeExecutorsStats;
    }
import org.opensearch.core.xcontent.XContentBuilder;
        assertTrue(nodes.containsKey("node-3"));
        // Verify per-node metadata is NOT present (KNN pattern — no IP exposure)
        response.toXContent(builder, ToXContent.EMPTY_PARAMS);
        // Verify cluster_name
        taskMonitors.put("coordinator_reduce", new TaskMonitorStats(10, 20, 30, 0, 0));
            Collections.emptySet(),
    // ---- Test 8: Empty nodes list ----
            List.of(nodeResponse),
        assertEquals(0, nodesHeader.get("failed"));
            clusterName,
        List<FailedNodeException> failures = List.of(
        Map<String, Object> map = renderToMap(response);
 * this file be licensed under the Apache-2.0 license or a
        List<FailedNodeException> failures = List.of(
        DataFusionStatsNodesResponse response = new DataFusionStatsNodesResponse(clusterName, nodeResponses, Collections.emptyList());
        assertFalse(nodeEntry.containsKey("transport_address"));
        );
 * SPDX-License-Identifier: Apache-2.0
        DiscoveryNode node3 = createNode("node-3", "coordinator-node", "10.0.0.3", 9300);
        ClusterName clusterName = new ClusterName("null-stats-cluster");
        assertEquals(1, nodes.size());
        Map<String, Object> nodesHeader = (Map<String, Object>) map.get("_nodes");
        DataFusionStatsNodeResponse nodeResponse = new DataFusionStatsNodeResponse(node1, stats);
        );
            new FailedNodeException("node-3", "node not available", new RuntimeException("unavailable"))
        DiscoveryNode node = createNode("node-abc-123", "my-data-node", "192.168.1.100", 9300);
        // Metadata should NOT be present (KNN pattern)
    @SuppressWarnings("unchecked")
        assertFalse(nodeEntry.containsKey("transport_address"));
    // ---- Test 6: Nodes counts correctness ----
import java.util.Collections;
import org.opensearch.cluster.ClusterName;
            List.of(nodeResponse),
        assertEquals(2, failuresArray.size());
 */
            Collections.emptyList()
import org.opensearch.be.datafusion.stats.PartitionGateStats;
import java.io.IOException;
import java.util.ArrayList;
        Map<String, Object> nodeEntry = (Map<String, Object>) nodes.get("node-1");
        Map<String, Object> map = renderToMap(response);
        DataFusionStatsNodesResponse response = new DataFusionStatsNodesResponse(
        ClusterName clusterName = new ClusterName("count-cluster");
    public void testToXContentWithSingleNode() throws Exception {
        DataFusionStatsNodesResponse response = new DataFusionStatsNodesResponse(
            new DataFusionStatsNodeResponse(node2, stats),
    }
    }
        DataFusionStats stats = createSimpleStats();
import java.net.InetAddress;
        Map<String, Object> nodesHeader = (Map<String, Object>) map.get("_nodes");
        // Verify cluster_name is present
        assertEquals(0, nodesHeader.get("total"));
/*
/**
        assertEquals("empty-cluster", map.get("cluster_name"));
    }
        );
            new DataFusionStatsNodeResponse(node3, stats)
        assertFalse(nodeEntry.containsKey("stream_next"));
            DiscoveryNode node = createNode("node-" + i, "node-" + i, "10.0.0." + i, 9300);
        assertEquals(3, nodesHeader.get("successful"));
        builder.startObject();
        DataFusionStats stats = createSimpleStats();
        DiscoveryNode node1 = createNode("node-1", "data-node-1", "10.0.0.1", 9300);
    @SuppressWarnings("unchecked")
        // Verify _nodes counts are all zero
        // Verify _nodes counts
            new FailedNodeException("node-4", "failed", new RuntimeException()),
import java.util.LinkedHashMap;
            clusterName,
        );
import org.opensearch.action.FailedNodeException;
        // Create 3 successful nodes
            new FailedNodeException("node-5", "failed", new RuntimeException())
        assertEquals(5, nodesHeader.get("total"));
 * compatible open source license.
        DataFusionStats stats = createSimpleStats();
        Map<String, Object> nodes = (Map<String, Object>) map.get("nodes");
        assertTrue(nodes.isEmpty());
        assertTrue(nodes.containsKey("node-1"));
        assertEquals(1, nodesHeader.get("successful"));
            new PartitionGateStats("fragment_executor_gate", 12, 3, 100, 500, 0, 12, 0, 0),
        DiscoveryNode node = createNode("node-1", "data-node-1", "10.0.0.1", 9300);
        assertFalse(nodeEntry.containsKey("fragment_executor_gate"));
import org.opensearch.be.datafusion.stats.RuntimeMetrics;
    @SuppressWarnings("unchecked")
package org.opensearch.be.datafusion.action.stats;
        );
        Map<String, Object> nodes = (Map<String, Object>) map.get("nodes");
    }
    }
    @SuppressWarnings("unchecked")
        taskMonitors.put("stream_next", new TaskMonitorStats(70, 80, 90, 0, 0));
        DiscoveryNode node = createNode("node-1", "data-node-1", "10.0.0.1", 9300);
        // Verify node entry has stats (no name/host/transport_address — matches KNN pattern)
import org.opensearch.common.xcontent.XContentFactory;
            Version.CURRENT
            Collections.emptyList()
        assertEquals("test-cluster", map.get("cluster_name"));
        assertFalse(nodeEntry.containsKey("io_runtime"));
        DiscoveryNode node1 = createNode("node-1", "data-node-1", "10.0.0.1", 9300);
            List.of(nodeResponse),
        DataFusionStatsNodesResponse response = new DataFusionStatsNodesResponse(clusterName, nodeResponses, failures);
    public void testToXContentEmptyNodes() throws Exception {
        List<DataFusionStatsNodeResponse> nodeResponses = List.of(
        Map<String, Object> nodes = (Map<String, Object>) map.get("nodes");
        }
        assertFalse(nodeEntry.containsKey("query_execution"));
        Map<String, Object> nodes = (Map<String, Object>) map.get("nodes");
            new DataFusionStatsNodeResponse(node1, stats),
    private static DataFusionStats createSimpleStats() {
        return new DiscoveryNode(
    // ---- Test 1: Single node JSON structure ----
    // ---- Test 4: Per-node metadata ----
            clusterName,
        XContentBuilder builder = XContentFactory.jsonBuilder();
        // Stats fields should be absent
public class DataFusionStatsNodesResponseTests extends OpenSearchTestCase {
    @SuppressWarnings("unchecked")
        RuntimeMetrics io = new RuntimeMetrics(4, 100, 500, 2, 10, 5, 8, 50, 0);
        DataFusionStatsNodeResponse nodeResponse = new DataFusionStatsNodeResponse(node, stats);
        DiscoveryNode node2 = createNode("node-2", "data-node-2", "10.0.0.2", 9300);
    // ---- Test 7: Null stats renders without stats fields ----
    public void testToXContentWithFailures() throws Exception {
        Map<String, Object> nodesHeader = (Map<String, Object>) map.get("_nodes");
        assertFalse(nodeEntry.containsKey("host"));
        String expectedClusterName = "production-us-east-1";
    @SuppressWarnings("unchecked")
            id,
            clusterName,
        ClusterName clusterName = new ClusterName(expectedClusterName);
    public void testToXContentNodesCountsCorrect() throws Exception {
        Map<String, Object> nodeEntry = (Map<String, Object>) nodes.get("node-1");
    // ---- Helper methods ----
        // Node response with null stats (service not started)
        assertTrue(map.containsKey("_nodes"));
 * Validates: Requirements 1.4, 1.5, 2.1, 2.2, 2.3
        assertEquals(1, nodesHeader.get("successful"));
import java.util.List;
            new TransportAddress(InetAddress.getByName(host), port),
        Map<String, Object> map = renderToMap(response);
        assertTrue(nodeEntry.containsKey("fragment_executor_gate"));
        DataFusionStatsNodesResponse response = new DataFusionStatsNodesResponse(
        assertEquals(1, nodesHeader.get("total"));
        Map<String, Object> map = renderToMap(response);
    public void testToXContentWithNullStats() throws Exception {
    @SuppressWarnings("unchecked")
        // Create 2 failures
            Collections.emptyList(),
        Map<String, Object> map = renderToMap(response);
        DataFusionStatsNodeResponse nodeResponse = new DataFusionStatsNodeResponse(node, stats);
    private static DiscoveryNode createNode(String id, String name, String host, int port) throws Exception {
    }
        ClusterName clusterName = new ClusterName("metadata-cluster");
        Map<String, Object> nodesHeader = (Map<String, Object>) map.get("_nodes");
    }
 *
    private static Map<String, Object> renderToMap(DataFusionStatsNodesResponse response) throws IOException {
        // Verify failures array is present
        ClusterName clusterName = new ClusterName("test-cluster");
        assertFalse(nodeEntry.containsKey("name"));
        assertEquals(2, nodesHeader.get("failed"));
    }
        assertEquals(3, nodesHeader.get("successful"));
        return new DataFusionStats(
        assertEquals(3, nodesHeader.get("total")); // 1 success + 2 failures
            Collections.emptyList()
        DataFusionStatsNodesResponse response = new DataFusionStatsNodesResponse(clusterName, List.of(nodeResponse), failures);
        assertFalse(nodeEntry.containsKey("host"));
        Map<String, Object> map = renderToMap(response);
            name,
}
            nodeResponses.add(new DataFusionStatsNodeResponse(node, createSimpleStats()));
        // Verify all nodes present
        // Verify _nodes counts include failures
        Map<String, Object> nodes = (Map<String, Object>) map.get("nodes");
        assertTrue(map.containsKey("nodes"));
            null
import org.opensearch.core.common.transport.TransportAddress;
        // Verify nodes object is empty
        assertEquals(0, nodesHeader.get("failed"));
        DataFusionStatsNodesResponse response = new DataFusionStatsNodesResponse(
        // Verify nodes only contains successful node
        assertTrue(nodes.containsKey("node-2"));
        );
import org.opensearch.be.datafusion.stats.TaskMonitorStats;
        );
        assertEquals(0, nodesHeader.get("successful"));
        assertFalse(nodeEntry.containsKey("name"));
        List<DataFusionStatsNodeResponse> nodeResponses = new ArrayList<>();
        Map<String, Object> nodesHeader = (Map<String, Object>) map.get("_nodes");
        ClusterName clusterName = new ClusterName("failure-cluster");
        assertTrue(nodes.containsKey("node-1"));
import org.opensearch.Version;
import org.opensearch.core.xcontent.ToXContent;
        assertFalse(nodeEntry.containsKey("cpu_runtime"));
        assertTrue(nodesHeader.containsKey("failures"));
        DataFusionStatsNodeResponse nodeResponse = new DataFusionStatsNodeResponse(node, null);
        for (int i = 1; i <= 3; i++) {
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.cluster.node.DiscoveryNode;
        assertFalse(nodeEntry.containsKey("coordinator_reduce"));
        assertTrue(nodes.containsKey("node-1"));
        // total = successes + failures = 3 + 2 = 5
        DataFusionStats stats = createSimpleStats();
        // Verify _nodes counts
        DataFusionStatsNodeResponse nodeResponse = new DataFusionStatsNodeResponse(node, createSimpleStats());
        ClusterName clusterName = new ClusterName("multi-cluster");
        ClusterName clusterName = new ClusterName("empty-cluster");
    public void testToXContentWithMultipleNodes() throws Exception {
    @SuppressWarnings("unchecked")
import org.opensearch.be.datafusion.stats.DataFusionStats;
    // ---- Test 2: Multiple nodes JSON structure ----
        // Verify top-level structure
 * The OpenSearch Contributors require contributions made to
            new FailedNodeException("node-2", "connection timeout", new RuntimeException("timeout")),
        assertEquals(1, nodes.size());
        assertFalse(nodeEntry.containsKey("transport_address"));
        );
    // ---- Test 5: Cluster name field ----
 */
 *
        Map<String, Object> map = renderToMap(response);
        assertEquals(0, nodesHeader.get("failed"));
    }
            new NativeExecutorsStats(io, null, taskMonitors),
