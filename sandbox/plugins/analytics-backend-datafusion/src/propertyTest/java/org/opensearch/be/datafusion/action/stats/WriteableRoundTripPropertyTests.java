import java.util.Arrays;
            Collections.emptyList()
import java.util.LinkedHashMap;
    }
    /**
     * <p><b>Validates: Requirements 5.4, 5.5, 5.6</b>
            new ClusterName("test-cluster"),
     * <p>For any DataFusionStatsNodeResponse, serialize → deserialize produces an
        original.writeTo(out);
                return new DataFusionStats(
 * {@link DataFusionStatsNodeResponse}, or {@link DataFusionStatsNodesResponse},
                    Collections.emptySet(),
        Arbitrary<String> nodeName = Arbitraries.strings().alpha().ofMinLength(3).ofMaxLength(10);
            monitors.put("plan_setup", ps);
     *
            nodeResponses,
    Arbitrary<DiscoveryNode> discoveryNode() {
 * compatible open source license.
     */
            runtimeMetrics(),
            .ofSize(9)
        StreamInput in = out.bytes().streamInput();
     */
        "io_runtime",
        return Combinators.combine(nodeId, nodeName, port).as((id, name, p) -> {
        // Verify equality
 *
import org.opensearch.be.datafusion.stats.DataFusionStats;
import net.jqwik.api.Provide;
    /** Generates an array of node IDs (possibly empty). */
}
        assertEquals(
        DataFusionStatsNodeResponse original = new DataFusionStatsNodeResponse(node, null);
     * regressions in the SpillStats wire format that the fixed-input unit test in
    Arbitrary<DataFusionStats> dataFusionStats() {
            runtimeMetrics(),
 *
                throw new RuntimeException(e);
 * Property-based tests for Writeable round-trip serialization of transport objects.
        // without-spill exercises the {@code writeOptionalWriteable} false-byte case.
        @ForAll("discoveryNode") DiscoveryNode node1,
        Arbitrary<String> nodeId = Arbitraries.strings().alpha().ofMinLength(5).ofMaxLength(12);
 * The OpenSearch Contributors require contributions made to
import org.opensearch.be.datafusion.stats.NativeExecutorsStats;
import java.util.Map;
 */
        Arbitrary<Long> nonNeg = Arbitraries.longs().between(0L, Long.MAX_VALUE / 2);
        );
    private Arbitrary<DataFusionStats> dataFusionStatsWithCpu(boolean withSpill) {
import static org.junit.jupiter.api.Assertions.assertEquals;
            spill
            );
import org.opensearch.be.datafusion.stats.TaskMonitorStats;
     *
    }
    // Generators
        for (int i = 0; i < original.getNodes().size(); i++) {
            .map(list -> list.toArray(new String[0]));
            Collections.emptyList(),
        // Verify statsToRetrieve
            .ofMinLength(3)
     *
     */
        original.writeTo(out);
                monitors.put("plan_setup", ps);
        assertEquals(original, deserialized, "NodeResponse with null stats must survive round-trip");
        DataFusionStatsNodeResponse deserialized = new DataFusionStatsNodeResponse(in);
     * object with equal statsToRetrieve.
import java.util.Collections;
     *
        @ForAll("discoveryNode") DiscoveryNode node2,
            .map(l -> new RuntimeMetrics(l.get(0), l.get(1), l.get(2), l.get(3), l.get(4), l.get(5), l.get(6), l.get(7), l.get(8)));
        return Arbitraries.oneOf(
        assertNotNull(deserialized.getClusterName(), "ClusterName must not be null after round-trip");
            dataFusionStatsWithCpu(/*withSpill*/ true),
            "nodesIds must survive round-trip"
    void nodeRequestRoundTrip(@ForAll("statsToRetrieve") Set<String> statsFilter) throws IOException {
        // Verify each node response
                return new DiscoveryNode(
 * {@code StreamInput} produces an object equal to the original.
    }
        original.writeTo(out);
        original.writeTo(out);
            }
        DataFusionStatsNodesRequest nodesRequest = new DataFusionStatsNodesRequest(new String[0], statsFilter);
    void nodesRequestRoundTrip(@ForAll("nodeIds") String[] nodeIds, @ForAll("statsToRetrieve") Set<String> statsFilter) throws IOException {
            taskMonitorStats(),
        BytesStreamOutput out = new BytesStreamOutput();
     * preserves the null stats.
     *
/*
        return Arbitraries.longs()
 */
        );
    ) throws IOException {
        @ForAll("dataFusionStats") DataFusionStats stats2
    /** Generates a set of stat section names (possibly empty). */
import org.opensearch.common.io.stream.BytesStreamOutput;
     */
            monitors.put("stream_next", sn);
        return Arbitraries.strings()
        // Verify node responses count
                Map<String, TaskMonitorStats> monitors = new LinkedHashMap<>();
        );
public class WriteableRoundTripPropertyTests {
    Arbitrary<TaskMonitorStats> taskMonitorStats() {
import net.jqwik.api.Property;
            assertEquals(origNode, deserNode, "Node response at index " + i + " must survive round-trip");
     * of {@code writeOptionalWriteable}, not just the {@code null} case. Catches
    // Property 5: Writeable round-trip for DataFusionStatsNodeRequest
     * BaseNodesResponse does not implement equals).
            try {
    }
import org.opensearch.be.datafusion.stats.SpillStats;
     * <p><b>Validates: Requirements 5.4, 5.5, 5.6</b>
        // Deserialize
     */
    // Property 5: Writeable round-trip for DataFusionStatsNodeResponse
        // Create a NodesRequest first, then derive the NodeRequest from it
        Arbitrary<Integer> port = Arbitraries.integers().between(1024, 65535);
        StreamInput in = out.bytes().streamInput();
        assertEquals(original.hashCode(), deserialized.hashCode(), "hashCode must be consistent after round-trip");
        Arbitrary<String> directory = Arbitraries.strings().alpha().ofMinLength(3).ofMaxLength(20).map(s -> "/spill/" + s);
    @Provide
        Arbitrary<Long> nonNeg = Arbitraries.longs().between(0, Long.MAX_VALUE / 2);
        StreamInput in = out.bytes().streamInput();
        ).as((io, cpu, cr, qe, sn, ps, sp) -> {
     * Feature: datafusion-cluster-stats, Property 5: Writeable round-trip for transport objects
import java.util.HashSet;
    // ═══════════════════════════════════════════════════════════════════
            taskMonitorStats(),
package org.opensearch.be.datafusion.action.stats;
        // Deserialize
    }
        BytesStreamOutput out = new BytesStreamOutput();
import java.util.ArrayList;
        });
        DataFusionStatsNodesResponse deserialized = new DataFusionStatsNodesResponse(in);
     *
            taskMonitorStats(),
        assertEquals(0, deserialized.getNodes().size(), "Empty node list must survive round-trip");
        assertEquals(original.failures().size(), deserialized.failures().size(), "Failures list size must survive round-trip");
import static org.junit.jupiter.api.Assertions.assertNotNull;
        DataFusionStatsNodeResponse original = new DataFusionStatsNodeResponse(node, stats);
        // Verify statsToRetrieve
        throws IOException {
        assertEquals(0, deserialized.failures().size(), "Empty failures list must survive round-trip");
     * <p>For a DataFusionStatsNodesResponse with empty node list, serialize → deserialize
        return Combinators.combine(names, nonNeg, nonNeg, nonNeg, nonNeg).as(PartitionGateStats::new);
            new HashSet<>(Arrays.asList(deserialized.nodesIds())),
    // ═══════════════════════════════════════════════════════════════════
     * object with equal nodesIds and statsToRetrieve.
    /**
    }
    }
import net.jqwik.api.Combinators;
 *
    void nodesResponseRoundTrip(
            dataFusionStatsWithoutCpu(/*withSpill*/ false)
     * preserves the empty state.
    Arbitrary<SpillStats> spillStats() {
        return Combinators.combine(
    );
        DataFusionStatsNodesRequest deserialized = new DataFusionStatsNodesRequest(in);
     */
        BytesStreamOutput out = new BytesStreamOutput();
        assertEquals(original.getClusterName(), deserialized.getClusterName(), "ClusterName must survive round-trip");
 * <p>Feature: datafusion-cluster-stats, Property 5: Writeable round-trip for transport objects
        List<DataFusionStatsNodeResponse> nodeResponses = new ArrayList<>();
     * <p><b>Validates: Requirements 5.4, 5.5, 5.6</b>
    @Property(tries = 100)
        // Serialize
    }
import org.opensearch.be.datafusion.stats.RuntimeMetrics;
                    new TransportAddress(InetAddress.getByName("127.0.0.1"), p),
    void nodeResponseRoundTrip(@ForAll("discoveryNode") DiscoveryNode node, @ForAll("dataFusionStats") DataFusionStats stats)
     * <p><b>Validates: Requirements 5.4, 5.5, 5.6</b>
            .between(0, Long.MAX_VALUE / 2)
        // Verify equality (DataFusionStatsNodeResponse has equals/hashCode)
    // ═══════════════════════════════════════════════════════════════════
                new NativeExecutorsStats(io, cpu, monitors),
        DataFusionStatsNodesResponse deserialized = new DataFusionStatsNodesResponse(in);
        assertEquals(null, deserialized.getStats(), "Null stats must remain null after round-trip");
     * Feature: datafusion-cluster-stats, Property 5: Writeable round-trip for transport objects
    @Provide
            new HashSet<>(Arrays.asList(original.nodesIds())),
                    name,
import org.opensearch.cluster.node.DiscoveryNode;
    Arbitrary<Set<String>> statsToRetrieve() {
            DataFusionStatsNodeResponse deserNode = deserialized.getNodes().get(i);
    // Property 5: Writeable round-trip for DataFusionStatsNodesResponse
        DataFusionStatsNodesRequest original = new DataFusionStatsNodesRequest(nodeIds, statsFilter);
    @Property(tries = 100)
    void nodesResponseRoundTripEmpty() throws IOException {
            taskMonitorStats(),
     * Feature: datafusion-cluster-stats, Property 5: Writeable round-trip for transport objects
    @Provide
                null
import java.io.IOException;
     * <p>For any DataFusionStatsNodeRequest, serialize → deserialize produces an
        // Deserialize
import net.jqwik.api.ForAll;
            dataFusionStatsWithoutCpu(/*withSpill*/ true),
     * Feature: datafusion-cluster-stats, Property 5: Writeable round-trip for transport objects
import java.util.List;
        Arbitrary<SpillStats> spill = withSpill ? spillStats() : Arbitraries.just(null);
        DataFusionStatsNodesResponse original = new DataFusionStatsNodesResponse(
        "query_execution",
    }
        return Combinators.combine(nonNeg, nonNeg, nonNeg).as(TaskMonitorStats::new);
            .ofMinSize(0)
     * Feature: datafusion-cluster-stats, Property 5: Writeable round-trip for transport objects
    /**
     *
    @Property(tries = 100)
                monitors.put("query_execution", qe);
     * equal object (node + stats).
    // Property 5: Writeable round-trip for DataFusionStatsNodesRequest
            .list()
            });
    // ═══════════════════════════════════════════════════════════════════
    Arbitrary<String[]> nodeIds() {
            return new DataFusionStats(
    /**
            .list()
 * <p>For any {@link DataFusionStatsNodesRequest}, {@link DataFusionStatsNodeRequest},
            .ofMaxSize(5)
            .as((io, cr, qe, sn, ps, sp) -> {
    private Arbitrary<DataFusionStats> dataFusionStatsWithoutCpu(boolean withSpill) {
        assertEquals(original, deserialized, "NodeResponse must survive round-trip");
                new PartitionGateStats("fragment_executor_gate", 12, 3, 100, 50, 0, 12, 0, 0),
        assertEquals(original.getStatsToRetrieve(), deserialized.getStatsToRetrieve(), "statsToRetrieve must survive round-trip");
    // ═══════════════════════════════════════════════════════════════════
     *
        return Combinators.combine(directory, nonNeg, nonNeg, nonNeg, nonNeg, staleCount).as(SpillStats::new);
import java.net.InetAddress;
                    id,
    Arbitrary<PartitionGateStats> partitionGateStats() {
        DataFusionStatsNodeRequest deserialized = new DataFusionStatsNodeRequest(in);
            monitors.put("query_execution", qe);
        DataFusionStatsNodeRequest original = new DataFusionStatsNodeRequest(nodesRequest);
        original.writeTo(out);
        assertEquals(original.getNode(), deserialized.getNode(), "DiscoveryNode must survive round-trip");
import java.util.Set;
            new ClusterName("empty-cluster"),
        nodeResponses.add(new DataFusionStatsNodeResponse(node2, stats2));
        nodeResponses.add(new DataFusionStatsNodeResponse(node1, stats1));
        "stream_next",
        // Verify individual components
    // ═══════════════════════════════════════════════════════════════════
    // ═══════════════════════════════════════════════════════════════════
            .ofMaxLength(10)
     * object with equal node responses (compared via rendered XContent since
        Arbitrary<Long> nonNeg = Arbitraries.longs().between(0, Long.MAX_VALUE / 2);
import org.opensearch.core.common.io.stream.StreamInput;
        // Verify nodesIds
    // ═══════════════════════════════════════════════════════════════════
                    null
    /** Valid stat section names for generating filter sets. */
        assertEquals(original.getNodes().size(), deserialized.getNodes().size(), "Number of node responses must survive round-trip");
        Arbitrary<SpillStats> spill = withSpill ? spillStats() : Arbitraries.just(null);
     * <p><b>Validates: Requirements 5.4, 5.5, 5.6</b>
        BytesStreamOutput out = new BytesStreamOutput();
            DataFusionStatsNodeResponse origNode = original.getNodes().get(i);
        // Deserialize
import net.jqwik.api.Arbitraries;
    @Property(tries = 100)
    /**
    }
        assertEquals(original.getNode(), deserialized.getNode(), "DiscoveryNode must survive round-trip");
import org.opensearch.cluster.ClusterName;
 * serializing to a {@code StreamOutput} and deserializing from the resulting
     * <p>For any DataFusionStatsNodesRequest, serialize → deserialize produces an
    /**
            dataFusionStatsWithCpu(/*withSpill*/ false),
    @Provide
    // ═══════════════════════════════════════════════════════════════════
    @Provide
        DataFusionStatsNodeResponse deserialized = new DataFusionStatsNodeResponse(in);
 * <p><b>Validates: Requirements 5.4, 5.5, 5.6</b>
        return Combinators.combine(runtimeMetrics(), taskMonitorStats(), taskMonitorStats(), taskMonitorStats(), taskMonitorStats(), spill)
    }
        Arbitrary<String> names = Arbitraries.of("fragment_executor_gate");
    }
     *
     *
                    null,
    // ═══════════════════════════════════════════════════════════════════
            Map<String, TaskMonitorStats> monitors = new LinkedHashMap<>();
                );
            } catch (Exception e) {
        "plan_setup",
     * generator so the round-trip property exercises the present-spill-stats branch
        StreamInput in = out.bytes().streamInput();
    @Property(tries = 100)
 * this file be licensed under the Apache-2.0 license or a
     *
        }
        "fragment_executor_gate"
import org.opensearch.Version;
        // Cover both wire-format branches: with-spill exercises the present-Writeable case,
    /**
        });
                    Collections.emptyMap(),
        assertEquals(original.getStatsToRetrieve(), deserialized.getStatsToRetrieve(), "statsToRetrieve must survive round-trip");
        StreamInput in = out.bytes().streamInput();
 *
import net.jqwik.api.Arbitrary;
        return Arbitraries.of(ALL_SECTIONS).set().ofMinSize(0).ofMaxSize(7);
     * <p>For a DataFusionStatsNodeResponse with null stats, serialize → deserialize
                );
    @Property(tries = 100)
    }
    @Provide
        Arbitrary<Long> staleCount = Arbitraries.longs().between(0L, 10_000L);
    private static final List<String> ALL_SECTIONS = List.of(
        // Verify cluster name
        // Serialize
/**
     *
import org.opensearch.core.common.transport.TransportAddress;
        assertEquals(original.getClusterName(), deserialized.getClusterName(), "ClusterName must survive round-trip");
import org.opensearch.be.datafusion.stats.PartitionGateStats;
        );
                    new NativeExecutorsStats(io, null, monitors),
        DataFusionStatsNodesResponse original = new DataFusionStatsNodesResponse(
        StreamInput in = out.bytes().streamInput();
        // Serialize
    }
    @Provide
    @Provide
     * Feature: datafusion-cluster-stats, Property 5: Writeable round-trip for transport objects
    }
     * {@code SpillStatsTests} cannot.
     * <p>For any DataFusionStatsNodesResponse, serialize → deserialize produces an
                    new PartitionGateStats("fragment_executor_gate", 12, 3, 100, 50, 0, 12, 0, 0),
    }
                monitors.put("coordinator_reduce", cr);
        original.writeTo(out);
                    Version.CURRENT
        // Verify failures count (empty in this test)
        assertEquals(original.getStats(), deserialized.getStats(), "DataFusionStats must survive round-trip");
        // Deserialize
        // Serialize
            monitors.put("coordinator_reduce", cr);
        // Serialize
     */
    Arbitrary<RuntimeMetrics> runtimeMetrics() {
        BytesStreamOutput out = new BytesStreamOutput();
                null,
            Collections.emptyList()
        "coordinator_reduce",
        BytesStreamOutput out = new BytesStreamOutput();
 * SPDX-License-Identifier: Apache-2.0
        @ForAll("dataFusionStats") DataFusionStats stats1,
                monitors.put("stream_next", sn);
     * <p><b>Validates: Requirements 5.4, 5.5, 5.6</b>
            .alpha()
        // Deserialize
    void nodeResponseRoundTripWithNullStats(@ForAll("discoveryNode") DiscoveryNode node) throws IOException {
        // Serialize
    /** Generates a DiscoveryNode with a stable loopback address. */
        // Verify
     * Generates a {@link SpillStats}. Threaded into the {@link #dataFusionStats()}
        "cpu_runtime",
