     *  
        assertEquals(clusterNameStr, root.get("cluster_name").asText(), "cluster_name must match the input cluster name");
import java.util.ArrayList;  
        assertEquals(successResponses.size(), nodesObj.size(), "nodes object must have exactly as many entries as successful responses");
        assertNotNull(nodesHeader, "_nodes object must be present");
        return Arbitraries.integers().between(0, 10).flatMap(count -> {
                return Arbitraries.just(Collections.emptyList());
import org.opensearch.be.datafusion.stats.DataFusionStats;  
            assertTrue(nodesObj.has(expectedId), "nodes object must contain entry for node ID: " + expectedId);
    /**  
    }  
                return responses;
import java.io.IOException;  
        DataFusionStatsNodesResponse response = new DataFusionStatsNodesResponse(cluster, successResponses, failureList);
    }  
        return Arbitraries.integers()  
 * {@link FailedNodeException} failures, the rendered {@link DataFusionStatsNodesResponse}  
     */  
import org.opensearch.core.common.transport.TransportAddress;
     * Generates a port number.
import java.util.List;  
        return Arbitraries.integers().between(0, 5).flatMap(count -> {  
import org.opensearch.core.xcontent.XContentBuilder;
    @Provide
        // Verify nodes object
 * {@code transport_address} fields from the node's {@link DiscoveryNode}.
        JsonNode root = renderAndParse(response);  
    @Provide  
    }
 * JSON SHALL contain: a {@code _nodes} object with {@code total} equal to successes + failures,
     */  
 * key is a node ID and each value contains {@code name}, {@code host}, and
    Arbitrary<DataFusionStats> dataFusionStats() {
        ClusterName cluster = new ClusterName(clusterNameStr);  
    /**
        JsonNode root = renderAndParse(response);  
        return Arbitraries.longs().between(0, Long.MAX_VALUE / 2);
    ) throws IOException {  
 * <p>For any set of successful {@link DataFusionStatsNodeResponse} instances and
            "_nodes.successful must equal number of successful responses"  
import org.opensearch.common.xcontent.XContentFactory;
        return Combinators.combine(runtimeMetrics(), taskMonitorStats(), taskMonitorStats(), taskMonitorStats(), taskMonitorStats())
     * <p>Verifies that {@code cluster_name} is present and matches the input.
     */  
     */
                    failureList.add(new FailedNodeException(id, "node failure", new RuntimeException("test error")));
        return Arbitraries.strings().alpha().ofMinLength(3).ofMaxLength(20).map(s -> "node-" + s);
        assertNotNull(nodesObj, "nodes object must be present");
import static org.junit.jupiter.api.Assertions.assertFalse;
                for (int i = 0; i < count; i++) {
    @Provide
    Arbitrary<List<DataFusionStatsNodeResponse>> nodeResponses() {
            assertFalse(nodeEntry.has("name"), "Node entry must NOT contain 'name' field for node: " + nodeId);
        }
 * The OpenSearch Contributors require contributions made to  
    void nodesObjectHasCorrectEntries(
 * this file be licensed under the Apache-2.0 license or a
     * {@code _nodes.failed} = failures count.  
     * Generates a node name string.  
            assertNotNull(nodeEntry, "Node entry must exist for ID: " + nodeId);
 * Property-based tests for NodesResponse rendering correct structure.
    void nodesHeaderCountsAreCorrect(
            .between(1, 254)
    }  
                }
        response.toXContent(builder, ToXContent.EMPTY_PARAMS);
     * <p><b>Validates: Requirements 1.4, 1.5, 2.1, 2.2</b>
                return new DataFusionStats(  
                    } catch (UnknownHostException e) {
import java.net.InetAddress;
            assertFalse(nodeEntry.has("transport_address"), "Node entry must NOT contain 'transport_address' field for node: " + nodeId);
            .ofSize(3)  
        return Combinators.combine(nonNegLong(), nonNegLong(), nonNegLong()).as(TaskMonitorStats::new);
import net.jqwik.api.ForAll;  
    @Provide
        // Verify cluster_name
import java.net.UnknownHostException;
                monitors.put("coordinator_reduce", cr);
    Arbitrary<String> nodeName() {  
    }
            return nodeId().list().ofSize(count).uniqueElements().map(ids -> {
 *
     * Generates a list of DataFusionStatsNodeResponse instances (0 to 10 nodes).  
        DataFusionStatsNodesResponse response = new DataFusionStatsNodesResponse(cluster, successResponses, failureList);
                    new PartitionGateStats("fragment_executor_gate", 12, 3, 100, 50, 0, 12, 0, 0),
    }  
     * Feature: datafusion-cluster-stats, Property 1: NodesResponse renders correct structure
 *
     */
    }  
 *
                    null
                    new NativeExecutorsStats(io, null, monitors),
    @Provide
        return MAPPER.readTree(builder.toString());  
        @ForAll("failures") List<FailedNodeException> failureList,  
        });
 */  
    Arbitrary<String> nodeId() {
            String nodeId = nodeResp.getNode().getId();  
        @ForAll("clusterName") String clusterNameStr
        JsonNode nodesHeader = root.get("_nodes");
     * <p><b>Validates: Requirements 2.1</b>
 * the number of failures; a {@code cluster_name} string; and a {@code nodes} object where each  
     */
    }
/*  
                        );
                }
    void clusterNameIsPresentAndCorrect(
                monitors.put("stream_next", sn);
                        responses.add(new DataFusionStatsNodeResponse(node, statsList.get(i)));  
    Arbitrary<String> hostAddress() {
    }
     * <p>Verifies that {@code _nodes.total} = successes + failures,
            assertFalse(nodeEntry.has("host"), "Node entry must NOT contain 'host' field for node: " + nodeId);  
    }  
    @Property(tries = 150)  
        DataFusionStatsNodesResponse response = new DataFusionStatsNodesResponse(cluster, successResponses, failureList);
 * SPDX-License-Identifier: Apache-2.0
            return Combinators.combine(  
            successResponses.size(),
    @Property(tries = 150)
     * Each node has a unique ID, name, host, and transport address.
                List<FailedNodeException> failureList = new ArrayList<>();
    private JsonNode renderAndParse(DataFusionStatsNodesResponse response) throws IOException {
import static org.junit.jupiter.api.Assertions.assertTrue;
                return failureList;  
            .map(octets -> "10." + octets.get(0) + "." + octets.get(1) + "." + octets.get(2));
    /** Generates a DataFusionStats instance with all sections populated. */
import java.util.Map;
        return Arbitraries.integers().between(9200, 9400);  
     * Generates a cluster name string.
        assertEquals(failureList.size(), nodesHeader.get("failed").asInt(), "_nodes.failed must equal number of failures");
    }  
    @Provide  
            });  
    }
            JsonNode nodeEntry = nodesObj.get(nodeId);
     * successful responses, and each entry is keyed by the node's ID.
        ClusterName cluster = new ClusterName(clusterNameStr);
    /**
import org.opensearch.action.FailedNodeException;
     * <p>Verifies that the {@code nodes} object has exactly as many entries as
import org.opensearch.be.datafusion.stats.NativeExecutorsStats;
            .ofSize(9)
        assertEquals(  
        return nonNegLong().list()
     */
                return Arbitraries.just(Collections.emptyList());
                port().list().ofSize(count),
    /** Generates a non-negative long suitable for metrics. */  
import java.util.LinkedHashMap;
    /**
                        throw new RuntimeException(e);
        builder.startObject();  
     *  
        @ForAll("clusterName") String clusterNameStr
                for (String id : ids) {  
    /**
import org.opensearch.Version;
     * Generates a list of FailedNodeException instances (0 to 5 failures).
                        DiscoveryNode node = new DiscoveryNode(
        @ForAll("failures") List<FailedNodeException> failureList,
        JsonNode root = renderAndParse(response);
            }  
    ) throws IOException {
public class NodesResponseStructurePropertyTests {  
    /**
    @Property(tries = 150)  
        JsonNode nodesObj = root.get("nodes");  
                            Collections.emptySet(),  
        DataFusionStatsNodesResponse response = new DataFusionStatsNodesResponse(cluster, successResponses, failureList);  
        @ForAll("nodeResponses") List<DataFusionStatsNodeResponse> successResponses,  
                nodeId().list().ofSize(count).uniqueElements(),
     * Feature: datafusion-cluster-stats, Property 1: NodesResponse renders correct structure
    Arbitrary<Integer> port() {
        XContentBuilder builder = XContentFactory.jsonBuilder();
        // Verify each node entry is keyed by node ID
        builder.endObject();
     */
}
                hostAddress().list().ofSize(count),  
    Arbitrary<TaskMonitorStats> taskMonitorStats() {
import org.opensearch.core.xcontent.ToXContent;  
 * <p>Feature: datafusion-cluster-stats, Property 1: NodesResponse renders correct structure  
            .list()
     *  
                            names.get(i),
 * compatible open source license.
import com.fasterxml.jackson.databind.ObjectMapper;
    }
    }  
     */  
     * Feature: datafusion-cluster-stats, Property 1: NodesResponse renders correct structure  
    // ---- Generators ----
        @ForAll("failures") List<FailedNodeException> failureList,
import net.jqwik.api.Combinators;
                dataFusionStats().list().ofSize(count)
import net.jqwik.api.Provide;
        @ForAll("nodeResponses") List<DataFusionStatsNodeResponse> successResponses,
import com.fasterxml.jackson.databind.JsonNode;
     * {@code _nodes.successful} = successes count, and
        ClusterName cluster = new ClusterName(clusterNameStr);  
    @Property(tries = 150)
    // ---- Helper methods ----
        @ForAll("nodeResponses") List<DataFusionStatsNodeResponse> successResponses,
     * Generates a unique node ID string (alphanumeric, 5-15 chars).
import org.opensearch.cluster.ClusterName;
        for (DataFusionStatsNodeResponse nodeResp : successResponses) {
                            new TransportAddress(InetAddress.getByName(hosts.get(i)), ports.get(i)),
        @ForAll("nodeResponses") List<DataFusionStatsNodeResponse> successResponses,
    /**
            });  
     *
    @Provide  
            }
    /**
        @ForAll("clusterName") String clusterNameStr
            nodesHeader.get("successful").asInt(),
    Arbitrary<List<FailedNodeException>> failures() {
    @Provide  
                );
    @Provide
        int expectedTotal = successResponses.size() + failureList.size();
    Arbitrary<RuntimeMetrics> runtimeMetrics() {  
        }
    /**  
import java.util.Collections;
 *  
    /**
        assertTrue(root.has("cluster_name"), "cluster_name field must be present");  
            .map(l -> new RuntimeMetrics(l.get(0), l.get(1), l.get(2), l.get(3), l.get(4), l.get(5), l.get(6), l.get(7), l.get(8)));  
    private Arbitrary<Long> nonNegLong() {
                    null,  
     *
     * <p><b>Validates: Requirements 1.5</b>
        return Arbitraries.strings().alpha().ofMinLength(3).ofMaxLength(20).map(s -> "cluster-" + s);
import static org.junit.jupiter.api.Assertions.assertEquals;
            if (count == 0) {
            });
                            Collections.emptyMap(),
import static org.junit.jupiter.api.Assertions.assertNotNull;  
import org.opensearch.be.datafusion.stats.RuntimeMetrics;  
     */  
 * {@code successful} equal to the number of successful responses, and {@code failed} equal to
                nodeName().list().ofSize(count),
        for (DataFusionStatsNodeResponse nodeResp : successResponses) {
    ) throws IOException {
        );
                monitors.put("plan_setup", ps);
            .as((io, cr, qe, sn, ps) -> {  
            if (count == 0) {  
    private static final ObjectMapper MAPPER = new ObjectMapper();
    /**
        ClusterName cluster = new ClusterName(clusterNameStr);
                            ids.get(i),  
import org.opensearch.be.datafusion.stats.TaskMonitorStats;
package org.opensearch.be.datafusion.action.stats;
    ) throws IOException {
                    try {  
            ).as((ids, names, hosts, ports, statsList) -> {  
    Arbitrary<String> clusterName() {
     * <p><b>Validates: Security — no private IP leakage</b>  
            String expectedId = nodeResp.getNode().getId();  
     */
            // Verify metadata fields are NOT present
        // Verify _nodes object  
    @Provide  
import org.opensearch.be.datafusion.stats.PartitionGateStats;
                    }  
    // ---- Property 1: NodesResponse renders correct structure ----
    }
        JsonNode nodesObj = root.get("nodes");  
        assertEquals(expectedTotal, nodesHeader.get("total").asInt(), "_nodes.total must equal successes + failures");
     */
    /**
                            Version.CURRENT
    void eachNodeEntryDoesNotContainMetadataFields(  
     * Generates a valid IPv4 address as a string (using 10.x.x.x range).
import net.jqwik.api.Arbitraries;  
     * <p>Verifies that each node entry in {@code nodes} contains {@code name},
/**  
        @ForAll("clusterName") String clusterNameStr  
 */
     * Verifies that node entries do NOT contain {@code name}, {@code host},  
        return Arbitraries.strings().alpha().numeric().ofMinLength(5).ofMaxLength(15);
     *
     * Feature: datafusion-cluster-stats, Property 1: NodesResponse renders correct structure  
                Map<String, TaskMonitorStats> monitors = new LinkedHashMap<>();
                monitors.put("query_execution", qe);  
     * or {@code transport_address} fields (KNN pattern — no IP exposure).
import net.jqwik.api.Arbitrary;
import net.jqwik.api.Property;
        });
     *  
 * <p><b>Validates: Requirements 1.4, 1.5, 2.1, 2.2</b>
        JsonNode root = renderAndParse(response);
                List<DataFusionStatsNodeResponse> responses = new ArrayList<>();
     *
        @ForAll("failures") List<FailedNodeException> failureList,  
     * Renders the response to JSON and parses it into a Jackson JsonNode.
    }
import org.opensearch.cluster.node.DiscoveryNode;  
