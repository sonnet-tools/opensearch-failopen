        assertFalse(nodeEntry.containsKey("name"));  
        // Verify _nodes counts include failures
        Map<String, TaskMonitorStats> taskMonitors = new LinkedHashMap<>();  
            new FailedNodeException("node-4", "failed", new RuntimeException()),  
    public void testToXContentWithMultipleNodes() throws Exception {
        assertFalse(nodeEntry.containsKey("stream_next"));
        DataFusionStatsNodesResponse response = new DataFusionStatsNodesResponse(clusterName, List.of(nodeResponse), failures);
        List<FailedNodeException> failures = List.of(
        // Node response with null stats (service not started)
        assertFalse(nodeEntry.containsKey("transport_address"));
        assertEquals(0, nodesHeader.get("total"));
 * compatible open source license.
        Map<String, Object> map = renderToMap(response);
        RuntimeMetrics io = new RuntimeMetrics(4, 100, 500, 2, 10, 5, 8, 50, 0);
    // ---- Test 3: Failures array rendering ----
    @SuppressWarnings("unchecked")  
            new FailedNodeException("node-3", "node not available", new RuntimeException("unavailable"))
        );
import java.io.IOException;  
        ClusterName clusterName = new ClusterName("failure-cluster");  
        // Verify nodes object is empty
        String expectedClusterName = "production-us-east-1";  
import org.opensearch.action.FailedNodeException;
        // Verify top-level structure  
    public void testToXContentNodesCountsCorrect() throws Exception {  
    private static DiscoveryNode createNode(String id, String name, String host, int port) throws Exception {
        assertFalse(nodeEntry.containsKey("host"));
        // Stats fields should be absent
        assertFalse(nodeEntry.containsKey("query_execution"));  
        // Create 2 failures
        ClusterName clusterName = new ClusterName("null-stats-cluster");  
 *
public class DataFusionStatsNodesResponseTests extends OpenSearchTestCase {
import java.util.Map;  
    // ---- Test 2: Multiple nodes JSON structure ----
    }
        assertTrue(nodeEntry.containsKey("io_runtime"));  
        DataFusionStats stats = createSimpleStats();
        );
    @SuppressWarnings("unchecked")  
 * The OpenSearch Contributors require contributions made to  
        DataFusionStatsNodesResponse response = new DataFusionStatsNodesResponse(clusterName, nodeResponses, failures);
        DataFusionStats stats = createSimpleStats();
        );
        assertFalse(nodeEntry.containsKey("host"));
import org.opensearch.core.xcontent.XContentBuilder;  
 * Validates: Requirements 1.4, 1.5, 2.1, 2.2, 2.3
        assertEquals(2, nodesHeader.get("failed"));
        assertTrue(nodes.containsKey("node-1"));
            new TransportAddress(InetAddress.getByName(host), port),  
        return new DataFusionStats(
            List.of(nodeResponse),
    }  
 * SPDX-License-Identifier: Apache-2.0
        for (int i = 1; i <= 3; i++) {
        assertEquals(1, nodesHeader.get("successful"));
        );  
        ClusterName clusterName = new ClusterName(expectedClusterName);
        DataFusionStatsNodesResponse response = new DataFusionStatsNodesResponse(
        // Verify failures array is present
import org.opensearch.be.datafusion.stats.PartitionGateStats;
        assertEquals(0, nodesHeader.get("failed"));  
            null,
    }
            new FailedNodeException("node-2", "connection timeout", new RuntimeException("timeout")),  
            Collections.emptyList()
        DataFusionStatsNodesResponse response = new DataFusionStatsNodesResponse(
        // Verify per-node metadata is NOT present (KNN pattern — no IP exposure)
 */  
        assertFalse(nodeEntry.containsKey("transport_address"));  
        builder.startObject();
package org.opensearch.be.datafusion.action.stats;
            clusterName,  
    @SuppressWarnings("unchecked")  
        DataFusionStatsNodesResponse response = new DataFusionStatsNodesResponse(
    // ---- Test 8: Empty nodes list ----  
        XContentBuilder builder = XContentFactory.jsonBuilder();  
            Collections.emptyList()
            DiscoveryNode node = createNode("node-" + i, "node-" + i, "10.0.0." + i, 9300);  
    // ---- Helper methods ----  
/*  
import org.opensearch.core.xcontent.MediaTypeRegistry;
    @SuppressWarnings("unchecked")
    @SuppressWarnings("unchecked")
import org.opensearch.core.common.transport.TransportAddress;  
        assertEquals("empty-cluster", map.get("cluster_name"));  
        assertFalse(nodeEntry.containsKey("plan_setup"));
        // total = successes + failures = 3 + 2 = 5  
    }
        ClusterName clusterName = new ClusterName("empty-cluster");
        DiscoveryNode node = createNode("node-1", "data-node-1", "10.0.0.1", 9300);
        taskMonitors.put("plan_setup", new TaskMonitorStats(100, 110, 120, 0, 0));
    public void testToXContentWithNullStats() throws Exception {
            List.of(nodeResponse),
            null  
        DiscoveryNode node1 = createNode("node-1", "data-node-1", "10.0.0.1", 9300);
        assertEquals(5, nodesHeader.get("total"));
        assertTrue(nodes.containsKey("node-1"));  
        assertEquals("test-cluster", map.get("cluster_name"));  
        assertFalse(nodeEntry.containsKey("coordinator_reduce"));
import java.util.Collections;  
            List.of(nodeResponse),  
        assertEquals(3, nodesHeader.get("total"));
        DataFusionStats stats = createSimpleStats();
        return new DiscoveryNode(  
        DataFusionStatsNodeResponse nodeResponse = new DataFusionStatsNodeResponse(node, stats);
        Map<String, Object> nodes = (Map<String, Object>) map.get("nodes");  
        assertTrue(nodes.containsKey("node-2"));
        DataFusionStatsNodesResponse response = new DataFusionStatsNodesResponse(clusterName, nodeResponses, Collections.emptyList());
import java.util.ArrayList;
    @SuppressWarnings("unchecked")
        Map<String, Object> nodeEntry = (Map<String, Object>) nodes.get("node-1");
    @SuppressWarnings("unchecked")
            Collections.emptyMap(),
import org.opensearch.cluster.node.DiscoveryNode;  
            new DataFusionStatsNodeResponse(node2, stats),
        // successful = number of successful responses = 3
        Map<String, Object> nodesHeader = (Map<String, Object>) map.get("_nodes");
        assertTrue(map.containsKey("_nodes"));
 */  
import org.opensearch.be.datafusion.stats.TaskMonitorStats;
    }
        // Create 3 successful nodes  
        // Metadata should NOT be present (KNN pattern)  
    @SuppressWarnings("unchecked")
        DiscoveryNode node = createNode("node-1", "data-node-1", "10.0.0.1", 9300);  
        ClusterName clusterName = new ClusterName("count-cluster");
    public void testToXContentClusterName() throws Exception {
        // failed = number of failures = 2
        Map<String, Object> map = renderToMap(response);
        );
        // Verify all nodes present  
    }
import java.util.List;
    }
        Map<String, Object> nodesHeader = (Map<String, Object>) map.get("_nodes");  
        assertEquals(2, nodesHeader.get("failed"));  
        assertTrue(map.containsKey("nodes"));  
import org.opensearch.be.datafusion.stats.NativeExecutorsStats;
        Map<String, Object> nodes = (Map<String, Object>) map.get("nodes");  
        Map<String, Object> nodes = (Map<String, Object>) map.get("nodes");
        assertFalse(nodeEntry.containsKey("fragment_executor_gate"));  
        assertFalse(nodeEntry.containsKey("name"));  
    private static DataFusionStats createSimpleStats() {
        assertEquals(3, nodes.size());
import org.opensearch.be.datafusion.stats.DataFusionStats;  
    public void testToXContentNodeMetadata() throws Exception {
        Map<String, Object> map = renderToMap(response);  
    private static Map<String, Object> renderToMap(DataFusionStatsNodesResponse response) throws IOException {
        DataFusionStatsNodeResponse nodeResponse = new DataFusionStatsNodeResponse(node, createSimpleStats());  
        );
        DiscoveryNode node2 = createNode("node-2", "data-node-2", "10.0.0.2", 9300);
        Map<String, Object> nodesHeader = (Map<String, Object>) map.get("_nodes");  
        List<Object> failuresArray = (List<Object>) nodesHeader.get("failures");
        DataFusionStatsNodeResponse nodeResponse = new DataFusionStatsNodeResponse(node, null);  
        Map<String, Object> nodes = (Map<String, Object>) map.get("nodes");
            clusterName,
        assertEquals(0, nodesHeader.get("failed"));  
        // Verify _nodes counts
        assertEquals(1, nodes.size());  
        assertEquals(3, nodesHeader.get("total")); // 1 success + 2 failures
/**
        // Verify _nodes counts  
        assertFalse(nodeEntry.containsKey("host"));
        DiscoveryNode node3 = createNode("node-3", "coordinator-node", "10.0.0.3", 9300);
        // Verify cluster_name is present
            name,
            Collections.emptyList(),
 * Unit tests for {@link DataFusionStatsNodesResponse#toXContent}.  
import org.opensearch.be.datafusion.stats.RuntimeMetrics;  
        }
        DiscoveryNode node1 = createNode("node-1", "data-node-1", "10.0.0.1", 9300);  
        DiscoveryNode node = createNode("node-abc-123", "my-data-node", "192.168.1.100", 9300);  
        DataFusionStatsNodesResponse response = new DataFusionStatsNodesResponse(  
import org.opensearch.common.xcontent.XContentHelper;
        taskMonitors.put("coordinator_reduce", new TaskMonitorStats(10, 20, 30, 0, 0));
        DataFusionStatsNodeResponse nodeResponse = new DataFusionStatsNodeResponse(node, stats);
            clusterName,
        assertEquals(2, failuresArray.size());
        builder.endObject();  
        assertTrue(nodesHeader.containsKey("failures"));  
        assertEquals(0, nodesHeader.get("successful"));
    // ---- Test 4: Per-node metadata ----
        Map<String, Object> map = renderToMap(response);
            Collections.emptyList()  
    // ---- Test 6: Nodes counts correctness ----  
        Map<String, Object> map = renderToMap(response);
}  
        );  
        taskMonitors.put("query_execution", new TaskMonitorStats(40, 50, 60, 0, 0));
        DataFusionStats stats = createSimpleStats();
        ClusterName clusterName = new ClusterName("multi-cluster");
    // ---- Test 7: Null stats renders without stats fields ----
        Map<String, Object> nodes = (Map<String, Object>) map.get("nodes");  
import org.opensearch.Version;
    public void testToXContentWithSingleNode() throws Exception {
        assertEquals(3, nodesHeader.get("successful"));  
        assertEquals(1, nodesHeader.get("successful"));
        assertTrue(nodes.containsKey("node-1"));
        assertEquals(3, nodesHeader.get("successful"));  
        Map<String, Object> nodesHeader = (Map<String, Object>) map.get("_nodes");  
        List<DataFusionStatsNodeResponse> nodeResponses = List.of(
        assertEquals(0, nodesHeader.get("failed"));
    @SuppressWarnings("unchecked")
        Map<String, Object> nodesHeader = (Map<String, Object>) map.get("_nodes");
    }  
            new DataFusionStatsNodeResponse(node3, stats)
    public void testToXContentWithFailures() throws Exception {
import java.net.InetAddress;
            Version.CURRENT  
        // Verify cluster_name
        assertTrue(nodeEntry.containsKey("fragment_executor_gate"));
        // Verify _nodes counts are all zero
        Map<String, Object> map = renderToMap(response);  
            Collections.emptyList()
        assertTrue(nodes.containsKey("node-3"));
import org.opensearch.core.xcontent.ToXContent;
    }
            new DataFusionStatsNodeResponse(node1, stats),  
        return XContentHelper.convertToMap(MediaTypeRegistry.JSON.xContent(), builder.toString(), false);
    // ---- Test 5: Cluster name field ----
        Map<String, Object> nodeEntry = (Map<String, Object>) nodes.get("node-1");
            new NativeExecutorsStats(io, null, taskMonitors),  
        assertFalse(nodeEntry.containsKey("io_runtime"));  
        DataFusionStatsNodesResponse response = new DataFusionStatsNodesResponse(
        // Verify node entry has stats (no name/host/transport_address — matches KNN pattern)
        assertEquals(expectedClusterName, map.get("cluster_name"));  
        List<FailedNodeException> failures = List.of(
        response.toXContent(builder, ToXContent.EMPTY_PARAMS);
            id,
        DataFusionStatsNodeResponse nodeResponse = new DataFusionStatsNodeResponse(node1, stats);  
            new FailedNodeException("node-5", "failed", new RuntimeException())
            new PartitionGateStats("fragment_executor_gate", 12, 3, 100, 500, 0, 12, 0, 0),
        Map<String, Object> nodes = (Map<String, Object>) map.get("nodes");
            Collections.emptySet(),
            List.of(nodeResponse),  
        // Verify nodes object has the node keyed by ID
import java.util.LinkedHashMap;
import org.opensearch.cluster.ClusterName;
 *
            nodeResponses.add(new DataFusionStatsNodeResponse(node, createSimpleStats()));
        Map<String, Object> nodeEntry = (Map<String, Object>) nodes.get("node-abc-123");  
        );
        );
        taskMonitors.put("stream_next", new TaskMonitorStats(70, 80, 90, 0, 0));  
        // Verify nodes only contains successful node
        ClusterName clusterName = new ClusterName("test-cluster");
        Map<String, Object> map = renderToMap(response);
        assertFalse(nodeEntry.containsKey("transport_address"));
import org.opensearch.common.xcontent.XContentFactory;
    public void testToXContentEmptyNodes() throws Exception {  
        assertTrue(map.containsKey("cluster_name"));
        assertFalse(nodeEntry.containsKey("name"));
    // ---- Test 1: Single node JSON structure ----
 * this file be licensed under the Apache-2.0 license or a
        ClusterName clusterName = new ClusterName("metadata-cluster");
        );  
            clusterName,
        DiscoveryNode node = createNode("node-1", "node-1", "127.0.0.1", 9300);
            clusterName,  
        List<DataFusionStatsNodeResponse> nodeResponses = new ArrayList<>();
        Map<String, Object> map = renderToMap(response);  
    }
import org.opensearch.test.OpenSearchTestCase;
        assertFalse(nodeEntry.containsKey("cpu_runtime"));
        assertEquals(1, nodesHeader.get("total"));
    }  
        assertTrue(nodes.isEmpty());
            Collections.emptyList()
        assertEquals(1, nodes.size());
