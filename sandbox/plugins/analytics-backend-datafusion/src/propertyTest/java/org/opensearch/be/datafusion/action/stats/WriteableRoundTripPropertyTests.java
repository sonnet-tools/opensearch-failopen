        assertEquals(original.getStatsToRetrieve(), deserialized.getStatsToRetrieve(), "statsToRetrieve must survive round-trip");
    }
    }
import org.opensearch.core.common.io.stream.StreamInput;
        // Verify cluster name  
        return Arbitraries.of(ALL_SECTIONS).set().ofMinSize(0).ofMaxSize(7);  
     */
            dataFusionStatsWithoutCpu(/*withSpill*/ true),  
 * compatible open source license.
                monitors.put("stream_next", sn);
     */  
    void nodeRequestRoundTrip(@ForAll("statsToRetrieve") Set<String> statsFilter) throws IOException {
        DataFusionStatsNodesRequest nodesRequest = new DataFusionStatsNodesRequest(new String[0], statsFilter);
            });  
     * BaseNodesResponse does not implement equals).
        original.writeTo(out);  
            monitors.put("stream_next", sn);
                    new PartitionGateStats("fragment_executor_gate", 12, 3, 100, 50, 0, 12, 0, 0),
    // Property 5: Writeable round-trip for DataFusionStatsNodesRequest  
    private static final List<String> ALL_SECTIONS = List.of(
        Arbitrary<SpillStats> spill = withSpill ? spillStats() : Arbitraries.just(null);
        "cpu_runtime",
    @Provide
        DataFusionStatsNodeResponse deserialized = new DataFusionStatsNodeResponse(in);
 * Property-based tests for Writeable round-trip serialization of transport objects.  
        // Verify equality
        "plan_setup",
     * Feature: datafusion-cluster-stats, Property 5: Writeable round-trip for transport objects  
        // Create a NodesRequest first, then derive the NodeRequest from it  
     *
        assertNotNull(deserialized.getClusterName(), "ClusterName must not be null after round-trip");
                Map<String, TaskMonitorStats> monitors = new LinkedHashMap<>();
     * Feature: datafusion-cluster-stats, Property 5: Writeable round-trip for transport objects
        ).as((io, cpu, cr, qe, sn, ps, sp) -> {  
        DataFusionStatsNodesResponse deserialized = new DataFusionStatsNodesResponse(in);
        // Verify individual components  
import static org.junit.jupiter.api.Assertions.assertEquals;
     * <p><b>Validates: Requirements 5.4, 5.5, 5.6</b>
}
        return Arbitraries.longs()  
    void nodeResponseRoundTripWithNullStats(@ForAll("discoveryNode") DiscoveryNode node) throws IOException {
     *
    }  
        assertEquals(original.getNodes().size(), deserialized.getNodes().size(), "Number of node responses must survive round-trip");
import static org.junit.jupiter.api.Assertions.assertNotNull;  
    @Provide  
    }
            );
        // Verify each node response
                    new TransportAddress(InetAddress.getByName("127.0.0.1"), p),  
    @Provide
     * object with equal statsToRetrieve.  
        StreamInput in = out.bytes().streamInput();  
     * Generates a {@link SpillStats}. Threaded into the {@link #dataFusionStats()}  
    }
        // Verify nodesIds
        // Serialize  
    Arbitrary<TaskMonitorStats> taskMonitorStats() {
        return Combinators.combine(runtimeMetrics(), taskMonitorStats(), taskMonitorStats(), taskMonitorStats(), taskMonitorStats(), spill)
            .list()
        DataFusionStatsNodesRequest deserialized = new DataFusionStatsNodesRequest(in);  
            .ofMaxSize(5)  
        // Cover both wire-format branches: with-spill exercises the present-Writeable case,
                    Collections.emptyMap(),
    }
     *
import org.opensearch.be.datafusion.stats.RuntimeMetrics;
     * <p>For any DataFusionStatsNodeRequest, serialize → deserialize produces an
                    Version.CURRENT  
     *
        assertEquals(original, deserialized, "NodeResponse with null stats must survive round-trip");
            "nodesIds must survive round-trip"  
     * preserves the empty state.
        // Serialize
    Arbitrary<DataFusionStats> dataFusionStats() {  
import java.util.Set;
        DataFusionStatsNodesResponse original = new DataFusionStatsNodesResponse(
     * <p><b>Validates: Requirements 5.4, 5.5, 5.6</b>
     *
        return Combinators.combine(nodeId, nodeName, port).as((id, name, p) -> {
        original.writeTo(out);
        "fragment_executor_gate"  
            new ClusterName("empty-cluster"),
 * <p>For any {@link DataFusionStatsNodesRequest}, {@link DataFusionStatsNodeRequest},
    Arbitrary<DiscoveryNode> discoveryNode() {  
     * Feature: datafusion-cluster-stats, Property 5: Writeable round-trip for transport objects  
        // Verify statsToRetrieve  
 *
import org.opensearch.be.datafusion.stats.SpillStats;  
import org.opensearch.be.datafusion.stats.PartitionGateStats;
 * this file be licensed under the Apache-2.0 license or a
        // Verify failures count (empty in this test)
     * <p><b>Validates: Requirements 5.4, 5.5, 5.6</b>  
        DataFusionStatsNodesRequest original = new DataFusionStatsNodesRequest(nodeIds, statsFilter);
    @Provide
        original.writeTo(out);  
     * Feature: datafusion-cluster-stats, Property 5: Writeable round-trip for transport objects  
        // Verify equality (DataFusionStatsNodeResponse has equals/hashCode)
import org.opensearch.core.common.transport.TransportAddress;  
    }  
        Arbitrary<Long> nonNeg = Arbitraries.longs().between(0, Long.MAX_VALUE / 2);  
     * preserves the null stats.  
    }
import org.opensearch.cluster.ClusterName;
    /** Generates an array of node IDs (possibly empty). */  
                new NativeExecutorsStats(io, cpu, monitors),
        assertEquals(original.getStatsToRetrieve(), deserialized.getStatsToRetrieve(), "statsToRetrieve must survive round-trip");
     */
        });  
        return Combinators.combine(names, nonNeg, nonNeg, nonNeg, nonNeg).as(PartitionGateStats::new);
                    id,
import java.util.Collections;  
    @Provide
        nodeResponses.add(new DataFusionStatsNodeResponse(node2, stats2));
        BytesStreamOutput out = new BytesStreamOutput();
     * <p>For any DataFusionStatsNodesResponse, serialize → deserialize produces an
    @Property(tries = 100)
                monitors.put("plan_setup", ps);
    }  
    /**  
        "stream_next",
        assertEquals(original, deserialized, "NodeResponse must survive round-trip");  
    );
    }  
     * <p><b>Validates: Requirements 5.4, 5.5, 5.6</b>
     * object with equal node responses (compared via rendered XContent since  
    /** Generates a DiscoveryNode with a stable loopback address. */
        // Serialize  
        assertEquals(original.getStats(), deserialized.getStats(), "DataFusionStats must survive round-trip");
                );
    // Generators
     * regressions in the SpillStats wire format that the fixed-input unit test in  
            taskMonitorStats(),
        // Verify statsToRetrieve  
    // ═══════════════════════════════════════════════════════════════════
package org.opensearch.be.datafusion.action.stats;
            taskMonitorStats(),
                    Collections.emptySet(),
        BytesStreamOutput out = new BytesStreamOutput();
            dataFusionStatsWithCpu(/*withSpill*/ true),
            .as((io, cr, qe, sn, ps, sp) -> {  
    /**
/*  
 * <p><b>Validates: Requirements 5.4, 5.5, 5.6</b>  
            spill
        @ForAll("discoveryNode") DiscoveryNode node2,
    // ═══════════════════════════════════════════════════════════════════
 *  
    // ═══════════════════════════════════════════════════════════════════
            try {
    @Property(tries = 100)
    Arbitrary<String[]> nodeIds() {
        DataFusionStatsNodesResponse deserialized = new DataFusionStatsNodesResponse(in);
     *
                null
     * Feature: datafusion-cluster-stats, Property 5: Writeable round-trip for transport objects
        );
    // ═══════════════════════════════════════════════════════════════════  
    @Property(tries = 100)
 * <p>Feature: datafusion-cluster-stats, Property 5: Writeable round-trip for transport objects
                    null
import org.opensearch.be.datafusion.stats.DataFusionStats;
/**
import java.util.ArrayList;
            runtimeMetrics(),  
     * of {@code writeOptionalWriteable}, not just the {@code null} case. Catches
 *
            return new DataFusionStats(  
     *
        assertEquals(original.hashCode(), deserialized.hashCode(), "hashCode must be consistent after round-trip");
    /**
    /**
        // without-spill exercises the {@code writeOptionalWriteable} false-byte case.
import net.jqwik.api.Provide;  
    Arbitrary<RuntimeMetrics> runtimeMetrics() {
    // ═══════════════════════════════════════════════════════════════════
    void nodesRequestRoundTrip(@ForAll("nodeIds") String[] nodeIds, @ForAll("statsToRetrieve") Set<String> statsFilter) throws IOException {  
        });
    /**
        Arbitrary<String> nodeId = Arbitraries.strings().alpha().ofMinLength(5).ofMaxLength(12);
 * {@code StreamInput} produces an object equal to the original.
                null,  
        DataFusionStatsNodeResponse deserialized = new DataFusionStatsNodeResponse(in);  
    /** Generates a set of stat section names (possibly empty). */  
        assertEquals(original.getNode(), deserialized.getNode(), "DiscoveryNode must survive round-trip");  
     */  
     * <p>For a DataFusionStatsNodeResponse with null stats, serialize → deserialize
    // ═══════════════════════════════════════════════════════════════════  
        throws IOException {  
        // Verify  
    }
        return Combinators.combine(nonNeg, nonNeg, nonNeg).as(TaskMonitorStats::new);
            }
    }
    @Property(tries = 100)
    private Arbitrary<DataFusionStats> dataFusionStatsWithCpu(boolean withSpill) {
            Collections.emptyList()
            Collections.emptyList()
 * SPDX-License-Identifier: Apache-2.0
            dataFusionStatsWithCpu(/*withSpill*/ false),
            .ofMinSize(0)
        original.writeTo(out);  
    /** Valid stat section names for generating filter sets. */
    // Property 5: Writeable round-trip for DataFusionStatsNodesResponse
        Arbitrary<String> nodeName = Arbitraries.strings().alpha().ofMinLength(3).ofMaxLength(10);
        // Serialize
                throw new RuntimeException(e);  
        "io_runtime",  
 */
    @Provide
        assertEquals(null, deserialized.getStats(), "Null stats must remain null after round-trip");
    @Provide
                return new DataFusionStats(  
                monitors.put("query_execution", qe);  
     * <p>For any DataFusionStatsNodesRequest, serialize → deserialize produces an  
        StreamInput in = out.bytes().streamInput();
     * <p>For a DataFusionStatsNodesResponse with empty node list, serialize → deserialize  
        StreamInput in = out.bytes().streamInput();
        Arbitrary<String> directory = Arbitraries.strings().alpha().ofMinLength(3).ofMaxLength(20).map(s -> "/spill/" + s);
            new ClusterName("test-cluster"),
    @Property(tries = 100)
            .between(0, Long.MAX_VALUE / 2)
import net.jqwik.api.Property;
        BytesStreamOutput out = new BytesStreamOutput();
 *
            .alpha()
import java.util.Map;
     */  
     * <p><b>Validates: Requirements 5.4, 5.5, 5.6</b>  
        return Arbitraries.oneOf(  
     * <p><b>Validates: Requirements 5.4, 5.5, 5.6</b>  
        return Combinators.combine(directory, nonNeg, nonNeg, nonNeg, nonNeg, staleCount).as(SpillStats::new);
import java.util.HashSet;
    // Property 5: Writeable round-trip for DataFusionStatsNodeResponse
        Arbitrary<Integer> port = Arbitraries.integers().between(1024, 65535);  
     *
        assertEquals(0, deserialized.getNodes().size(), "Empty node list must survive round-trip");
    // ═══════════════════════════════════════════════════════════════════
        assertEquals(0, deserialized.failures().size(), "Empty failures list must survive round-trip");  
     * generator so the round-trip property exercises the present-spill-stats branch
     * object with equal nodesIds and statsToRetrieve.
        // Deserialize
        DataFusionStatsNodeResponse original = new DataFusionStatsNodeResponse(node, stats);
    }
    /**
        assertEquals(original.getClusterName(), deserialized.getClusterName(), "ClusterName must survive round-trip");
                return new DiscoveryNode(  
    ) throws IOException {
                );
     */
        // Deserialize
        );
     * <p>For any DataFusionStatsNodeResponse, serialize → deserialize produces an
        BytesStreamOutput out = new BytesStreamOutput();
        // Serialize
        StreamInput in = out.bytes().streamInput();  
        BytesStreamOutput out = new BytesStreamOutput();
        StreamInput in = out.bytes().streamInput();  
        );
    }
            .ofMinLength(3)
import org.opensearch.be.datafusion.stats.NativeExecutorsStats;  
    Arbitrary<SpillStats> spillStats() {
 */  
            } catch (Exception e) {
        for (int i = 0; i < original.getNodes().size(); i++) {
        "query_execution",  
            .map(list -> list.toArray(new String[0]));
    void nodesResponseRoundTripEmpty() throws IOException {  
        @ForAll("dataFusionStats") DataFusionStats stats2
            runtimeMetrics(),
public class WriteableRoundTripPropertyTests {
        original.writeTo(out);
     * Feature: datafusion-cluster-stats, Property 5: Writeable round-trip for transport objects  
        Arbitrary<Long> staleCount = Arbitraries.longs().between(0L, 10_000L);
                    null,  
        List<DataFusionStatsNodeResponse> nodeResponses = new ArrayList<>();  
        nodeResponses.add(new DataFusionStatsNodeResponse(node1, stats1));
import java.util.Arrays;
    // ═══════════════════════════════════════════════════════════════════  
    Arbitrary<Set<String>> statsToRetrieve() {
            .ofSize(9)  
    @Provide
            monitors.put("coordinator_reduce", cr);
 * The OpenSearch Contributors require contributions made to  
import net.jqwik.api.ForAll;
        Arbitrary<Long> nonNeg = Arbitraries.longs().between(0L, Long.MAX_VALUE / 2);  
import java.util.List;  
            .ofMaxLength(10)  
        // Deserialize
import java.io.IOException;
        DataFusionStatsNodeRequest deserialized = new DataFusionStatsNodeRequest(in);
            nodeResponses,  
            taskMonitorStats(),
        // Deserialize
            monitors.put("plan_setup", ps);
        return Combinators.combine(
 * {@link DataFusionStatsNodeResponse}, or {@link DataFusionStatsNodesResponse},
            new HashSet<>(Arrays.asList(deserialized.nodesIds())),
        );
        original.writeTo(out);
        DataFusionStatsNodeResponse original = new DataFusionStatsNodeResponse(node, null);  
    @Property(tries = 100)
        DataFusionStatsNodeRequest original = new DataFusionStatsNodeRequest(nodesRequest);
        @ForAll("dataFusionStats") DataFusionStats stats1,  
     *
            dataFusionStatsWithoutCpu(/*withSpill*/ false)
import net.jqwik.api.Arbitrary;
        }  
            taskMonitorStats(),  
            DataFusionStatsNodeResponse deserNode = deserialized.getNodes().get(i);
        assertEquals(original.getNode(), deserialized.getNode(), "DiscoveryNode must survive round-trip");
    }  
        DataFusionStatsNodesResponse original = new DataFusionStatsNodesResponse(
            .list()
            .map(l -> new RuntimeMetrics(l.get(0), l.get(1), l.get(2), l.get(3), l.get(4), l.get(5), l.get(6), l.get(7), l.get(8)));
        StreamInput in = out.bytes().streamInput();
     *
    void nodesResponseRoundTrip(  
        Arbitrary<Long> nonNeg = Arbitraries.longs().between(0, Long.MAX_VALUE / 2);
        // Verify node responses count
        BytesStreamOutput out = new BytesStreamOutput();  
            Collections.emptyList(),  
        // Deserialize  
        Arbitrary<SpillStats> spill = withSpill ? spillStats() : Arbitraries.just(null);  
                monitors.put("coordinator_reduce", cr);
import org.opensearch.be.datafusion.stats.TaskMonitorStats;
                    new NativeExecutorsStats(io, null, monitors),
        // Serialize
            DataFusionStatsNodeResponse origNode = original.getNodes().get(i);  
        "coordinator_reduce",
            Map<String, TaskMonitorStats> monitors = new LinkedHashMap<>();
import net.jqwik.api.Combinators;  
 * serializing to a {@code StreamOutput} and deserializing from the resulting  
    Arbitrary<PartitionGateStats> partitionGateStats() {
    }
    // Property 5: Writeable round-trip for DataFusionStatsNodeRequest
                    name,
     */
                new PartitionGateStats("fragment_executor_gate", 12, 3, 100, 50, 0, 12, 0, 0),
            monitors.put("query_execution", qe);  
    // ═══════════════════════════════════════════════════════════════════  
        assertEquals(original.failures().size(), deserialized.failures().size(), "Failures list size must survive round-trip");  
import net.jqwik.api.Arbitraries;
    private Arbitrary<DataFusionStats> dataFusionStatsWithoutCpu(boolean withSpill) {  
     *
        Arbitrary<String> names = Arbitraries.of("fragment_executor_gate");  
     * {@code SpillStatsTests} cannot.
    void nodeResponseRoundTrip(@ForAll("discoveryNode") DiscoveryNode node, @ForAll("dataFusionStats") DataFusionStats stats)
import org.opensearch.cluster.node.DiscoveryNode;  
        return Arbitraries.strings()  
        @ForAll("discoveryNode") DiscoveryNode node1,
        assertEquals(original.getClusterName(), deserialized.getClusterName(), "ClusterName must survive round-trip");
import java.util.LinkedHashMap;
     * equal object (node + stats).  
        // Deserialize
            new HashSet<>(Arrays.asList(original.nodesIds())),
            assertEquals(origNode, deserNode, "Node response at index " + i + " must survive round-trip");
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertEquals(  
    /**  
import org.opensearch.Version;
     *
    // ═══════════════════════════════════════════════════════════════════
import java.net.InetAddress;  
