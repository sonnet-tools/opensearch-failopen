        // Render the full response to JSON
        DataFusionStatsNodesResponse nodesResponse = new DataFusionStatsNodesResponse(
                return new RuntimeMetrics(
 * compatible open source license.
        Map<String, Object> nodeEntry = (Map<String, Object>) nodesObj.get("test-node-id");
    /**
            return new DataFusionStats(
    @Provide
    // ---- Object generators ----
            Collections.emptyList()
import org.opensearch.core.common.transport.TransportAddress;
                    rt.totalBusyDurationMs,
    }
        return Combinators.combine(runtimeMetrics(), runtimeMetrics().map(rt -> {
     * Renders DataFusionStats directly: {@code builder.startObject(); stats.toXContent(builder, params); builder.endObject();}
                    new PartitionGateStats("fragment_executor_gate", 12, 3, 100, 50, 0, 12, 0, 0),
                    null,
import java.util.Collections;
    Arbitrary<DataFusionStats> dataFusionStats() {
                monitors.put("plan_setup", ps);
/**
        // Step 3: Compare — they should be identical
            .between(0, Long.MAX_VALUE / 2)
     *
        return Arbitraries.oneOf(dataFusionStatsFullCpuPresent(), dataFusionStatsFullCpuAbsent());
import java.util.List;
     */
     *
 * <p>For any {@link DataFusionStats} instance, when wrapped in a
    @SuppressWarnings("unchecked")
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);
    Arbitrary<DataFusionStats> dataFusionStatsFullCpuPresent() {
import org.opensearch.be.datafusion.stats.PartitionGateStats;
    @Property(tries = 150)
            monitors.put("plan_setup", ps);
        nodesResponse.toXContent(builder, ToXContent.EMPTY_PARAMS);
                    rt.totalPollsCount,
            .ofSize(9)
    }
                    rt.numAliveTasks,
import java.util.Map;
        // Remove metadata fields to isolate just the stats
import net.jqwik.api.Arbitrary;
     */
        }
import org.opensearch.Version;
            .map(l -> new RuntimeMetrics(l.get(0), l.get(1), l.get(2), l.get(3), l.get(4), l.get(5), l.get(6), l.get(7), l.get(8)));
 * {@link DataFusionStatsNodesResponse#toXContent}, the stats portion of the per-node
        // Extract the per-node entry
                monitors.put("coordinator_reduce", cr);
                    new NativeExecutorsStats(io, null, monitors),
    /**
    Arbitrary<TaskMonitorStats> taskMonitorStats() {
            });
        return Combinators.combine(nonNeg, nonNeg, nonNeg).as(TaskMonitorStats::new);
import static org.junit.jupiter.api.Assertions.assertEquals;
        builder.startObject();
                    rt.totalOverflowCount,
    @Provide
package org.opensearch.be.datafusion.action.stats;
        for (String metaField : NODE_METADATA_FIELDS) {
        return statsOnly;
 *
import org.opensearch.be.datafusion.stats.TaskMonitorStats;
        });
        // Step 2: Wrap in a DataFusionStatsNodeResponse + DataFusionStatsNodesResponse and render
    }
                monitors.put("query_execution", qe);
    private static final ObjectMapper MAPPER = new ObjectMapper();
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.be.datafusion.stats.DataFusionStats;
            .as((io, cr, qe, sn, ps) -> {
import net.jqwik.api.Combinators;
}
     * per-node entry from the "nodes" object, and removes the metadata fields
                    rt.spawnedTasksCount,
    @Provide
     * DataFusionStats.toXContent directly.
import org.opensearch.be.datafusion.stats.NativeExecutorsStats;
            Map<String, TaskMonitorStats> monitors = new LinkedHashMap<>();
    /** Combined DataFusionStats generator (CPU present or absent). */
 * The OpenSearch Contributors require contributions made to
            monitors.put("coordinator_reduce", cr);
        Map<String, Object> wrappedMap = renderStatsViaNodesResponse(stats);
import org.opensearch.cluster.ClusterName;
                + "the stats portion extracted from DataFusionStatsNodesResponse per-node entry"
                );
            .list()
import java.net.InetAddress;
            monitors.put("query_execution", qe);
    private Map<String, Object> renderStatsViaNodesResponse(DataFusionStats stats) throws Exception {
 * this file be licensed under the Apache-2.0 license or a
    }
import java.util.LinkedHashMap;
import org.opensearch.core.xcontent.ToXContent;
    @Provide
     */
    private Map<String, Object> renderStatsDirect(DataFusionStats stats) throws IOException {
    }
        builder.startObject();
    Arbitrary<RuntimeMetrics> runtimeMetrics() {
            monitors.put("stream_next", sn);
        DataFusionStatsNodeResponse nodeResponse = new DataFusionStatsNodeResponse(node, stats);
 *
    Arbitrary<DataFusionStats> dataFusionStatsFullCpuAbsent() {
        );
import org.opensearch.common.xcontent.XContentFactory;
 *
        Arbitrary<Long> nonNeg = Arbitraries.longs().between(0, Long.MAX_VALUE / 2);
        XContentBuilder builder = XContentFactory.jsonBuilder();
            if (rt.workersCount == 0) {
        Map<String, Object> fullMap = XContentHelper.convertToMap(MediaTypeRegistry.JSON.xContent(), builder.toString(), false);
            directMap,
import net.jqwik.api.ForAll;
        return Arbitraries.longs()
    @SuppressWarnings("unchecked")
        );
    @SuppressWarnings("unchecked")
        assertEquals(
        builder.endObject();
    @Provide
                Map<String, TaskMonitorStats> monitors = new LinkedHashMap<>();
public class PerNodeStatsEquivalencePropertyTests {
        }), taskMonitorStats(), taskMonitorStats(), taskMonitorStats(), taskMonitorStats()).as((io, cpu, cr, qe, sn, ps) -> {
        return XContentHelper.convertToMap(MediaTypeRegistry.JSON.xContent(), builder.toString(), false);
        );
    }
                monitors.put("stream_next", sn);
            List.of(nodeResponse),
            statsOnly.remove(metaField);
 */
 * <p><b>Validates: Requirements 2.4</b>
            "Stats rendered directly via DataFusionStats.toXContent must equal "
            Collections.emptySet(),
    }
import org.opensearch.common.xcontent.XContentHelper;
import org.opensearch.be.datafusion.stats.RuntimeMetrics;
                return new DataFusionStats(
import net.jqwik.api.Property;
        LinkedHashMap<String, Object> statsOnly = new LinkedHashMap<>(nodeEntry);
                    1,
 * SPDX-License-Identifier: Apache-2.0
    /** Metadata fields that were previously added by DataFusionStatsNodesResponse (now removed). */
        DiscoveryNode node = new DiscoveryNode(
        builder.endObject();
        // Wrap in node response
 */
                new NativeExecutorsStats(io, cpu, monitors),
            Version.CURRENT
                new PartitionGateStats("fragment_executor_gate", 12, 3, 100, 50, 0, 12, 0, 0),
     * puts it in a DataFusionStatsNodesResponse, renders to JSON, extracts the
     * Wraps the stats in a DataFusionStatsNodeResponse with a DiscoveryNode,
    // ---- Property 2: Per-node stats equivalence ----
            "test-node-id",
            new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300),
     * DataFusionStatsNodesResponse is equivalent to rendering via
/*
            Collections.emptyMap(),
import net.jqwik.api.Provide;
            wrappedMap,
        return Combinators.combine(runtimeMetrics(), taskMonitorStats(), taskMonitorStats(), taskMonitorStats(), taskMonitorStats())
            "test-node",
import java.util.Set;
import org.opensearch.core.xcontent.MediaTypeRegistry;
     * <p><b>Validates: Requirements 2.4</b>
import java.io.IOException;
     * then parses to a Map.
    }
                );
        // Step 1: Render DataFusionStats directly
            }
                null
        Map<String, Object> nodesObj = (Map<String, Object>) fullMap.get("nodes");
    // ---- Helper methods ----
 * <p>Feature: datafusion-cluster-stats, Property 2: Per-node stats equivalence
                null,
     * <p>For any DataFusionStats instance, the stats portion rendered via
            );
    void perNodeStatsMatchDirectRendering(@ForAll("dataFusionStats") DataFusionStats stats) throws Exception {
                    rt.totalLocalQueueDepth
 * JSON is equivalent to rendering the same {@link DataFusionStats} directly via
                    null
        // Create a DiscoveryNode for wrapping
            new ClusterName("test-cluster"),
 * Property-based tests for per-node stats equivalence.
import org.opensearch.core.xcontent.XContentBuilder;
            return rt;
     * (name, host, transport_address) to isolate just the stats portion.
 * {@code DataFusionStats.toXContent}.
import net.jqwik.api.Arbitraries;
 * {@link DataFusionStatsNodeResponse} and rendered via
        XContentBuilder builder = XContentFactory.jsonBuilder();
    /** DataFusionStats with CPU runtime absent. */
     * Feature: datafusion-cluster-stats, Property 2: Per-node stats equivalence
    /** DataFusionStats with all sections populated (CPU runtime present). */
        // Wrap in nodes response
 *
                    rt.blockingQueueDepth,
                    rt.globalQueueDepth,
    private static final Set<String> NODE_METADATA_FIELDS = Set.of();
        Map<String, Object> directMap = renderStatsDirect(stats);
    /**
import com.fasterxml.jackson.databind.ObjectMapper;
