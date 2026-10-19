                    rt.blockingQueueDepth,
    @SuppressWarnings("unchecked")  
        builder.endObject();
package org.opensearch.be.datafusion.action.stats;
    private static final Set<String> NODE_METADATA_FIELDS = Set.of();
        return Combinators.combine(nonNeg, nonNeg, nonNeg).as(TaskMonitorStats::new);  
                    rt.totalLocalQueueDepth
            new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300),  
    Arbitrary<DataFusionStats> dataFusionStats() {  
import java.net.InetAddress;
                    new NativeExecutorsStats(io, null, monitors),
            .map(l -> new RuntimeMetrics(l.get(0), l.get(1), l.get(2), l.get(3), l.get(4), l.get(5), l.get(6), l.get(7), l.get(8)));  
    @Provide  
        return Arbitraries.oneOf(dataFusionStatsFullCpuPresent(), dataFusionStatsFullCpuAbsent());
     * <p><b>Validates: Requirements 2.4</b>
        return Combinators.combine(runtimeMetrics(), runtimeMetrics().map(rt -> {  
     *  
    // ---- Helper methods ----  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.node.DiscoveryNode;
    Arbitrary<TaskMonitorStats> taskMonitorStats() {
 * {@link DataFusionStatsNodeResponse} and rendered via
        );
import org.opensearch.be.datafusion.stats.TaskMonitorStats;
                );  
    /** Metadata fields that were previously added by DataFusionStatsNodesResponse (now removed). */
                + "the stats portion extracted from DataFusionStatsNodesResponse per-node entry"
            "test-node-id",
        // Wrap in nodes response  
        DataFusionStatsNodeResponse nodeResponse = new DataFusionStatsNodeResponse(node, stats);
                monitors.put("plan_setup", ps);  
 *
    private Map<String, Object> renderStatsViaNodesResponse(DataFusionStats stats) throws Exception {
        builder.startObject();  
import net.jqwik.api.Combinators;
    @Provide
    @SuppressWarnings("unchecked")
 * {@code DataFusionStats.toXContent}.
        Map<String, Object> wrappedMap = renderStatsViaNodesResponse(stats);
            Collections.emptyList()
                Map<String, TaskMonitorStats> monitors = new LinkedHashMap<>();
    /**  
 *  
        // Remove metadata fields to isolate just the stats
                    rt.totalPollsCount,
            return rt;
     * Renders DataFusionStats directly: {@code builder.startObject(); stats.toXContent(builder, params); builder.endObject();}  
        builder.endObject();
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);
                    new PartitionGateStats("fragment_executor_gate", 12, 3, 100, 50, 0, 12, 0, 0),  
     * puts it in a DataFusionStatsNodesResponse, renders to JSON, extracts the
 * The OpenSearch Contributors require contributions made to  
        );
            if (rt.workersCount == 0) {
            return new DataFusionStats(  
        // Step 2: Wrap in a DataFusionStatsNodeResponse + DataFusionStatsNodesResponse and render  
    /**  
    Arbitrary<DataFusionStats> dataFusionStatsFullCpuPresent() {
    // ---- Object generators ----
/*  
import net.jqwik.api.Arbitraries;
        Map<String, Object> nodeEntry = (Map<String, Object>) nodesObj.get("test-node-id");
 * Property-based tests for per-node stats equivalence.  
import org.opensearch.Version;  
import org.opensearch.core.common.transport.TransportAddress;
import java.util.List;
    }
    @Provide  
     * Wraps the stats in a DataFusionStatsNodeResponse with a DiscoveryNode,
     * then parses to a Map.
    Arbitrary<RuntimeMetrics> runtimeMetrics() {
import org.opensearch.core.xcontent.XContentBuilder;
     * (name, host, transport_address) to isolate just the stats portion.
 * compatible open source license.
 * <p>Feature: datafusion-cluster-stats, Property 2: Per-node stats equivalence
    }
        assertEquals(
            Map<String, TaskMonitorStats> monitors = new LinkedHashMap<>();
    void perNodeStatsMatchDirectRendering(@ForAll("dataFusionStats") DataFusionStats stats) throws Exception {
        Map<String, Object> nodesObj = (Map<String, Object>) fullMap.get("nodes");
 * {@link DataFusionStatsNodesResponse#toXContent}, the stats portion of the per-node  
        return Combinators.combine(runtimeMetrics(), taskMonitorStats(), taskMonitorStats(), taskMonitorStats(), taskMonitorStats())  
        );  
 * <p>For any {@link DataFusionStats} instance, when wrapped in a
    @Provide
import static org.junit.jupiter.api.Assertions.assertEquals;  
            Collections.emptySet(),
        // Step 3: Compare — they should be identical  
            monitors.put("coordinator_reduce", cr);
        XContentBuilder builder = XContentFactory.jsonBuilder();
import java.util.LinkedHashMap;  
import com.fasterxml.jackson.databind.ObjectMapper;
}  
import java.util.Set;  
            new ClusterName("test-cluster"),
            statsOnly.remove(metaField);
                return new RuntimeMetrics(
    }
        XContentBuilder builder = XContentFactory.jsonBuilder();
import net.jqwik.api.Arbitrary;  
 */  
        return Arbitraries.longs()
                    rt.totalBusyDurationMs,
    Arbitrary<DataFusionStats> dataFusionStatsFullCpuAbsent() {
    }
 *
                monitors.put("coordinator_reduce", cr);  
        // Create a DiscoveryNode for wrapping
                monitors.put("query_execution", qe);
     * <p>For any DataFusionStats instance, the stats portion rendered via  
        DiscoveryNode node = new DiscoveryNode(  
     */
public class PerNodeStatsEquivalencePropertyTests {  
                    rt.numAliveTasks,  
            monitors.put("query_execution", qe);  
                    null,
import org.opensearch.core.xcontent.ToXContent;  
    /** Combined DataFusionStats generator (CPU present or absent). */
        LinkedHashMap<String, Object> statsOnly = new LinkedHashMap<>(nodeEntry);
import net.jqwik.api.ForAll;
                    null
        // Render the full response to JSON
     * Feature: datafusion-cluster-stats, Property 2: Per-node stats equivalence
            "Stats rendered directly via DataFusionStats.toXContent must equal "
    }
            List.of(nodeResponse),  
            Version.CURRENT  
import org.opensearch.common.xcontent.XContentFactory;
     * DataFusionStats.toXContent directly.
                    rt.spawnedTasksCount,
import org.opensearch.core.xcontent.MediaTypeRegistry;
import java.io.IOException;  
                new PartitionGateStats("fragment_executor_gate", 12, 3, 100, 50, 0, 12, 0, 0),
    private Map<String, Object> renderStatsDirect(DataFusionStats stats) throws IOException {
/**
            wrappedMap,  
    /**
    // ---- Property 2: Per-node stats equivalence ----
import org.opensearch.be.datafusion.stats.NativeExecutorsStats;
                null
        builder.startObject();  
        // Wrap in node response  
import net.jqwik.api.Property;  
    /** DataFusionStats with CPU runtime absent. */  
import java.util.Collections;
        }), taskMonitorStats(), taskMonitorStats(), taskMonitorStats(), taskMonitorStats()).as((io, cpu, cr, qe, sn, ps) -> {  
    @Property(tries = 150)  
                new NativeExecutorsStats(io, cpu, monitors),
 * JSON is equivalent to rendering the same {@link DataFusionStats} directly via
import org.opensearch.be.datafusion.stats.PartitionGateStats;  
                    rt.totalOverflowCount,  
            .as((io, cr, qe, sn, ps) -> {
        for (String metaField : NODE_METADATA_FIELDS) {  
            .ofSize(9)
    private static final ObjectMapper MAPPER = new ObjectMapper();
        // Step 1: Render DataFusionStats directly  
        Map<String, Object> directMap = renderStatsDirect(stats);
        Map<String, Object> fullMap = XContentHelper.convertToMap(MediaTypeRegistry.JSON.xContent(), builder.toString(), false);
            directMap,
        });  
        }
        DataFusionStatsNodesResponse nodesResponse = new DataFusionStatsNodesResponse(
        return statsOnly;
import org.opensearch.be.datafusion.stats.DataFusionStats;
    }
                    rt.globalQueueDepth,
            Collections.emptyMap(),
            .between(0, Long.MAX_VALUE / 2)  
import java.util.Map;
    @SuppressWarnings("unchecked")  
        // Extract the per-node entry  
 *  
     *
 * SPDX-License-Identifier: Apache-2.0
                return new DataFusionStats(
     * per-node entry from the "nodes" object, and removes the metadata fields  
            }
            "test-node",
    @Provide
                );  
            );
    }
                monitors.put("stream_next", sn);
            monitors.put("plan_setup", ps);
import net.jqwik.api.Provide;
            monitors.put("stream_next", sn);
 * <p><b>Validates: Requirements 2.4</b>
    }
import org.opensearch.be.datafusion.stats.RuntimeMetrics;
        return XContentHelper.convertToMap(MediaTypeRegistry.JSON.xContent(), builder.toString(), false);  
    /** DataFusionStats with all sections populated (CPU runtime present). */  
     */
            });
 */
     * DataFusionStatsNodesResponse is equivalent to rendering via
import org.opensearch.cluster.ClusterName;  
        nodesResponse.toXContent(builder, ToXContent.EMPTY_PARAMS);
                    1,  
     */
import org.opensearch.common.xcontent.XContentHelper;  
            .list()
        Arbitrary<Long> nonNeg = Arbitraries.longs().between(0, Long.MAX_VALUE / 2);
                null,  
