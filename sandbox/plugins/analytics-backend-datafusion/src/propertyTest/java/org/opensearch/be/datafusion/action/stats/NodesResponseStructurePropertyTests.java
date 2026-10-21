            .list()
    @Provide
        return nonNegLong().list()
    ) throws IOException {
     */
        @ForAll("nodeResponses") List<DataFusionStatsNodeResponse> successResponses,
    /**
            }
        });
            assertNotNull(nodeEntry, "Node entry must exist for ID: " + nodeId);
        ClusterName cluster = new ClusterName(clusterNameStr);
                }
    /**
    void clusterNameIsPresentAndCorrect(
     * {@code _nodes.successful} = successes count, and
 * key is a node ID and each value contains {@code name}, {@code host}, and
     *
    }
            });
                return new DataFusionStats(
        return Arbitraries.integers().between(9200, 9400);
     */
     * <p><b>Validates: Requirements 1.4, 1.5, 2.1, 2.2</b>
                port().list().ofSize(count),
    }
        int expectedTotal = successResponses.size() + failureList.size();
import net.jqwik.api.Arbitrary;
    // ---- Property 1: NodesResponse renders correct structure ----
import org.opensearch.common.xcontent.XContentFactory;
import java.net.InetAddress;
        ClusterName cluster = new ClusterName(clusterNameStr);
        JsonNode root = renderAndParse(response);
import static org.junit.jupiter.api.Assertions.assertTrue;
        return Arbitraries.integers().between(0, 10).flatMap(count -> {
        assertEquals(clusterNameStr, root.get("cluster_name").asText(), "cluster_name must match the input cluster name");
 * {@link FailedNodeException} failures, the rendered {@link DataFusionStatsNodesResponse}
            });
    void nodesHeaderCountsAreCorrect(
     *
        return Arbitraries.integers()
        // Verify each node entry is keyed by node ID
import org.opensearch.core.xcontent.XContentBuilder;
                return Arbitraries.just(Collections.emptyList());
        JsonNode nodesObj = root.get("nodes");
    @Property(tries = 150)
                monitors.put("stream_next", sn);
    }
    Arbitrary<String> nodeId() {
            if (count == 0) {
    /**
    /** Generates a non-negative long suitable for metrics. */
    @Provide
}
        // Verify nodes object
     * <p><b>Validates: Security — no private IP leakage</b>
     */
    }
 * JSON SHALL contain: a {@code _nodes} object with {@code total} equal to successes + failures,
    }
        DataFusionStatsNodesResponse response = new DataFusionStatsNodesResponse(cluster, successResponses, failureList);
                hostAddress().list().ofSize(count),
    }
     *
                            names.get(i),
     */
    }
        assertTrue(root.has("cluster_name"), "cluster_name field must be present");
        JsonNode nodesObj = root.get("nodes");
            .ofSize(3)
 * <p><b>Validates: Requirements 1.4, 1.5, 2.1, 2.2</b>
     * Feature: datafusion-cluster-stats, Property 1: NodesResponse renders correct structure
import static org.junit.jupiter.api.Assertions.assertEquals;
                List<FailedNodeException> failureList = new ArrayList<>();
 * {@code transport_address} fields from the node's {@link DiscoveryNode}.
import org.opensearch.cluster.ClusterName;
                return failureList;
    Arbitrary<RuntimeMetrics> runtimeMetrics() {
    @Provide
        for (DataFusionStatsNodeResponse nodeResp : successResponses) {
            assertTrue(nodesObj.has(expectedId), "nodes object must contain entry for node ID: " + expectedId);
     * Generates a port number.
import org.opensearch.be.datafusion.stats.DataFusionStats;
    /**
    /**
                        DiscoveryNode node = new DiscoveryNode(
     * Generates a list of DataFusionStatsNodeResponse instances (0 to 10 nodes).
 */
            return Combinators.combine(
        DataFusionStatsNodesResponse response = new DataFusionStatsNodesResponse(cluster, successResponses, failureList);
                            Version.CURRENT
        });
     * successful responses, and each entry is keyed by the node's ID.
        ClusterName cluster = new ClusterName(clusterNameStr);
     * Generates a valid IPv4 address as a string (using 10.x.x.x range).
import org.opensearch.action.FailedNodeException;
import java.util.Map;
                    new NativeExecutorsStats(io, null, monitors),
        @ForAll("failures") List<FailedNodeException> failureList,
import java.util.ArrayList;
     */
        @ForAll("nodeResponses") List<DataFusionStatsNodeResponse> successResponses,
                    null
    void nodesObjectHasCorrectEntries(
import java.io.IOException;
 * compatible open source license.
import java.util.List;
        }
        assertEquals(expectedTotal, nodesHeader.get("total").asInt(), "_nodes.total must equal successes + failures");
    }
import net.jqwik.api.ForAll;
        assertNotNull(nodesObj, "nodes object must be present");
            // Verify metadata fields are NOT present
     * Renders the response to JSON and parses it into a Jackson JsonNode.
                nodeName().list().ofSize(count),
     * <p><b>Validates: Requirements 1.5</b>
        builder.startObject();
/**
import java.util.Collections;
                }
    Arbitrary<List<FailedNodeException>> failures() {
     *
import org.opensearch.be.datafusion.stats.PartitionGateStats;
        @ForAll("clusterName") String clusterNameStr
            "_nodes.successful must equal number of successful responses"
     */
    }
    /**
     */
    /** Generates a DataFusionStats instance with all sections populated. */
            .ofSize(9)
    }
     * Feature: datafusion-cluster-stats, Property 1: NodesResponse renders correct structure
        return Combinators.combine(nonNegLong(), nonNegLong(), nonNegLong()).as(TaskMonitorStats::new);
    @Provide
        @ForAll("nodeResponses") List<DataFusionStatsNodeResponse> successResponses,
    // ---- Generators ----
        @ForAll("failures") List<FailedNodeException> failureList,
                            Collections.emptyMap(),
    Arbitrary<String> clusterName() {
import static org.junit.jupiter.api.Assertions.assertNotNull;
     * {@code _nodes.failed} = failures count.
        @ForAll("clusterName") String clusterNameStr
import net.jqwik.api.Combinators;
    ) throws IOException {
            assertFalse(nodeEntry.has("name"), "Node entry must NOT contain 'name' field for node: " + nodeId);
     *
                            Collections.emptySet(),
        assertEquals(successResponses.size(), nodesObj.size(), "nodes object must have exactly as many entries as successful responses");
                monitors.put("query_execution", qe);
        DataFusionStatsNodesResponse response = new DataFusionStatsNodesResponse(cluster, successResponses, failureList);
                return responses;
        return MAPPER.readTree(builder.toString());
import net.jqwik.api.Arbitraries;
     * Each node has a unique ID, name, host, and transport address.
    /**
import com.fasterxml.jackson.databind.ObjectMapper;
 * The OpenSearch Contributors require contributions made to
        return Arbitraries.integers().between(0, 5).flatMap(count -> {
    /**
        JsonNode root = renderAndParse(response);
            });
import java.util.LinkedHashMap;
import org.opensearch.be.datafusion.stats.RuntimeMetrics;
        @ForAll("failures") List<FailedNodeException> failureList,
 * <p>For any set of successful {@link DataFusionStatsNodeResponse} instances and
                            ids.get(i),
    ) throws IOException {
                Map<String, TaskMonitorStats> monitors = new LinkedHashMap<>();
import org.opensearch.be.datafusion.stats.TaskMonitorStats;
        assertEquals(
                nodeId().list().ofSize(count).uniqueElements(),
package org.opensearch.be.datafusion.action.stats;
     * Generates a cluster name string.
                );
        response.toXContent(builder, ToXContent.EMPTY_PARAMS);
     */
     * <p>Verifies that {@code cluster_name} is present and matches the input.
    }
                return Arbitraries.just(Collections.emptyList());
                            new TransportAddress(InetAddress.getByName(hosts.get(i)), ports.get(i)),
    /**
        );
            }
                monitors.put("plan_setup", ps);
    Arbitrary<String> nodeName() {
     * <p>Verifies that the {@code nodes} object has exactly as many entries as
        JsonNode root = renderAndParse(response);
     * Generates a unique node ID string (alphanumeric, 5-15 chars).
    @Provide
    private static final ObjectMapper MAPPER = new ObjectMapper();
import net.jqwik.api.Provide;
    @Provide
            .map(octets -> "10." + octets.get(0) + "." + octets.get(1) + "." + octets.get(2));
                        responses.add(new DataFusionStatsNodeResponse(node, statsList.get(i)));
    Arbitrary<Integer> port() {
 * {@code successful} equal to the number of successful responses, and {@code failed} equal to
     * <p>Verifies that {@code _nodes.total} = successes + failures,
                    }
     * Feature: datafusion-cluster-stats, Property 1: NodesResponse renders correct structure
    /**
     * Generates a node name string.
     * <p><b>Validates: Requirements 2.1</b>
        DataFusionStatsNodesResponse response = new DataFusionStatsNodesResponse(cluster, successResponses, failureList);
                    failureList.add(new FailedNodeException(id, "node failure", new RuntimeException("test error")));
    }
/*
    @Provide
            JsonNode nodeEntry = nodesObj.get(nodeId);
 *
                    try {
    @Property(tries = 150)
     * <p>Verifies that each node entry in {@code nodes} contains {@code name},
    /**
                        throw new RuntimeException(e);
import org.opensearch.cluster.node.DiscoveryNode;
    }
import org.opensearch.Version;
        ClusterName cluster = new ClusterName(clusterNameStr);
        JsonNode nodesHeader = root.get("_nodes");
     * Verifies that node entries do NOT contain {@code name}, {@code host},
        // Verify cluster_name
            successResponses.size(),
        return Arbitraries.longs().between(0, Long.MAX_VALUE / 2);
                        );
     * or {@code transport_address} fields (KNN pattern — no IP exposure).
            ).as((ids, names, hosts, ports, statsList) -> {
    }
                    } catch (UnknownHostException e) {
    @Provide
        // Verify _nodes object
 * the number of failures; a {@code cluster_name} string; and a {@code nodes} object where each
    void eachNodeEntryDoesNotContainMetadataFields(
        @ForAll("clusterName") String clusterNameStr
     * Feature: datafusion-cluster-stats, Property 1: NodesResponse renders correct structure
        return Arbitraries.strings().alpha().ofMinLength(3).ofMaxLength(20).map(s -> "node-" + s);
import org.opensearch.core.common.transport.TransportAddress;
     *
    Arbitrary<DataFusionStats> dataFusionStats() {
    Arbitrary<List<DataFusionStatsNodeResponse>> nodeResponses() {
        builder.endObject();
        for (DataFusionStatsNodeResponse nodeResp : successResponses) {
                for (String id : ids) {
import org.opensearch.be.datafusion.stats.NativeExecutorsStats;
    ) throws IOException {
    Arbitrary<String> hostAddress() {
 * <p>Feature: datafusion-cluster-stats, Property 1: NodesResponse renders correct structure
        assertNotNull(nodesHeader, "_nodes object must be present");
 * Property-based tests for NodesResponse rendering correct structure.
 * SPDX-License-Identifier: Apache-2.0
        return Arbitraries.strings().alpha().numeric().ofMinLength(5).ofMaxLength(15);
        }
     */
    private JsonNode renderAndParse(DataFusionStatsNodesResponse response) throws IOException {
            .map(l -> new RuntimeMetrics(l.get(0), l.get(1), l.get(2), l.get(3), l.get(4), l.get(5), l.get(6), l.get(7), l.get(8)));
                monitors.put("coordinator_reduce", cr);
                    new PartitionGateStats("fragment_executor_gate", 12, 3, 100, 50, 0, 12, 0, 0),
import net.jqwik.api.Property;
        assertEquals(failureList.size(), nodesHeader.get("failed").asInt(), "_nodes.failed must equal number of failures");
            assertFalse(nodeEntry.has("host"), "Node entry must NOT contain 'host' field for node: " + nodeId);
public class NodesResponseStructurePropertyTests {
            .between(1, 254)
        return Arbitraries.strings().alpha().ofMinLength(3).ofMaxLength(20).map(s -> "cluster-" + s);
 * this file be licensed under the Apache-2.0 license or a
    @Provide
            if (count == 0) {
import org.opensearch.core.xcontent.ToXContent;
                dataFusionStats().list().ofSize(count)
            return nodeId().list().ofSize(count).uniqueElements().map(ids -> {
    private Arbitrary<Long> nonNegLong() {
 *
    @Property(tries = 150)
 */
import static org.junit.jupiter.api.Assertions.assertFalse;
        @ForAll("nodeResponses") List<DataFusionStatsNodeResponse> successResponses,
            assertFalse(nodeEntry.has("transport_address"), "Node entry must NOT contain 'transport_address' field for node: " + nodeId);
        @ForAll("failures") List<FailedNodeException> failureList,
    @Provide
     *
        JsonNode root = renderAndParse(response);
 *
                    null,
     *
                List<DataFusionStatsNodeResponse> responses = new ArrayList<>();
    @Property(tries = 150)
    }
 *
        return Combinators.combine(runtimeMetrics(), taskMonitorStats(), taskMonitorStats(), taskMonitorStats(), taskMonitorStats())
            nodesHeader.get("successful").asInt(),
    // ---- Helper methods ----
        XContentBuilder builder = XContentFactory.jsonBuilder();
     * Generates a list of FailedNodeException instances (0 to 5 failures).
import java.net.UnknownHostException;
        @ForAll("clusterName") String clusterNameStr
            String expectedId = nodeResp.getNode().getId();
                for (int i = 0; i < count; i++) {
    }
     */
            .as((io, cr, qe, sn, ps) -> {
     */
import com.fasterxml.jackson.databind.JsonNode;
    /**
    Arbitrary<TaskMonitorStats> taskMonitorStats() {
     */
            String nodeId = nodeResp.getNode().getId();
