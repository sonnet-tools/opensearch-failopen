        return Combinators.combine(runtimeMetrics(), taskMonitorStats(), taskMonitorStats(), taskMonitorStats(), taskMonitorStats())
                    new NativeExecutorsStats(io, null, monitors),  
    }  
 * {@link TransportDataFusionStatsAction#filteredStats}, the rendered JSON for that node  
        "stream_next",  
/*  
        return builder.toString();  
                case "io_runtime":
import org.opensearch.be.datafusion.stats.DataFusionStats;
    private static final ObjectMapper MAPPER = new ObjectMapper();
        }
        if (stats != null) {
            .as((io, cr, qe, sn, ps) -> {
            actualSections,
     * Computes the set of section names expected in the filtered JSON output.  
import org.opensearch.core.xcontent.XContentBuilder;
        @ForAll("dataFusionStats") DataFusionStats stats,
 * compatible open source license.
                    }
import static org.junit.jupiter.api.Assertions.assertTrue;  
                monitors.put("plan_setup", ps);
                case "plan_setup":  
                case "cpu_runtime":
     * (empty/null filter returns all)
     * non-null data for that section.
package org.opensearch.be.datafusion.action.stats;
        }
        String json = renderJson(filtered);
    }  
    }
                    new PartitionGateStats("fragment_executor_gate", 12, 3, 100, 50, 0, 12, 0, 0),
        JsonNode root = MAPPER.readTree(json);  
        JsonNode root = MAPPER.readTree(json);  
                        expected.add(section);
        @ForAll("statSectionSubset") Set<String> requestedSections  
 *
     *  
                case "query_execution":
        // Sections NOT requested must be absent from the output
    void emptyFilterReturnsAllSections(@ForAll("dataFusionStats") DataFusionStats stats) throws IOException {
                );
        XContentBuilder builder = XContentFactory.jsonBuilder();  
        // Render filtered stats to JSON
        assertTrue(stats == filteredEmpty, "Empty filter must return the original stats object");  
     *
            return rt;  
        "fragment_executor_gate"
        Set<String> actualSections = new HashSet<>();  
            Map<String, TaskMonitorStats> monitors = new LinkedHashMap<>();
    private String renderJson(DataFusionStats stats) throws IOException {
        DataFusionStats filteredEmpty = TransportDataFusionStatsAction.filteredStats(stats, Set.of());
        Iterator<String> fieldNames = root.fieldNames();
                    rt.totalLocalQueueDepth  
     * <p><b>Validates: Requirements 3.1, 3.2, 3.4, 5.3</b>
    }  
    Arbitrary<DataFusionStats> dataFusionStatsFullCpuPresent() {  
    }
    @Property(tries = 100)
    /**
                    if (stats.getFragmentExecutorGateStats() != null) {  
import net.jqwik.api.ForAll;  
    private Set<String> computeExpectedSections(DataFusionStats stats, Set<String> requested) {
     */
    Arbitrary<Set<String>> statSectionSubset() {
    /** DataFusionStats with CPU runtime absent. */
     * instance, sections NOT in the filter are absent from the rendered JSON.
        }
    /** Combined DataFusionStats generator (CPU present or absent). */
import org.opensearch.core.xcontent.ToXContent;
                null,
            monitors.put("coordinator_reduce", cr);  
            .list()
        // Collect all top-level keys from the rendered JSON
/**
                        expected.add(section);  
    @Provide
        "query_execution",
     *
                monitors.put("query_execution", qe);
    private static final List<String> ALL_SECTIONS = List.of(
 */  
        for (String excluded : excludedSections) {  
import java.util.HashSet;
 * contains exactly the sections in the subset and no others.
                case "fragment_executor_gate":
                    if (stats.getNativeExecutorsStats() != null && stats.getNativeExecutorsStats().getIoRuntime() != null) {
     * <p><b>Validates: Requirements 3.1, 3.2, 3.4, 5.3</b>
                    null,
        @ForAll("dataFusionStats") DataFusionStats stats,
                root.has(excluded),
                new NativeExecutorsStats(io, cpu, monitors),
        while (fieldNames.hasNext()) {
import org.opensearch.be.datafusion.stats.TaskMonitorStats;
            return new DataFusionStats(
        excludedSections.removeAll(requestedSections);
        String json = renderJson(filtered);
     *  
    Arbitrary<TaskMonitorStats> taskMonitorStats() {
     * <p><b>Validates: Requirements 3.4, 5.3</b>
                        expected.add(section);
            switch (section) {
        return Combinators.combine(nonNeg, nonNeg, nonNeg).as(TaskMonitorStats::new);
 * <p>For any non-empty subset of valid stat section names and any {@link DataFusionStats}
            monitors.put("query_execution", qe);
import org.opensearch.be.datafusion.stats.NativeExecutorsStats;
    @Property(tries = 150)  
    );  
                return new DataFusionStats(
    // ---- Property 3: Stat section filtering correctness ----
            assertFalse(
        return Arbitraries.longs()  
import org.opensearch.be.datafusion.stats.PartitionGateStats;  
    }
                    rt.totalBusyDurationMs,  
        return Arbitraries.oneOf(dataFusionStatsFullCpuPresent(), dataFusionStatsFullCpuAbsent());
                monitors.put("coordinator_reduce", cr);
            .between(0, Long.MAX_VALUE / 2)
    // ---- Object generators ----
            stats.toXContent(builder, ToXContent.EMPTY_PARAMS);  
     * <p>For any non-empty subset of valid stat section names and any DataFusionStats
                    break;
                );
     */  
        Set<String> excludedSections = new HashSet<>(ALL_SECTIONS);  
    void filteredStatsExcludesUnrequestedSections(
            .map(l -> new RuntimeMetrics(l.get(0), l.get(1), l.get(2), l.get(3), l.get(4), l.get(5), l.get(6), l.get(7), l.get(8)));
     * instance, filtered output contains exactly the requested sections and no others.
    Arbitrary<DataFusionStats> dataFusionStats() {
        // Null filter returns same object  
        // Render filtered stats to JSON
                    rt.globalQueueDepth,
    // ---- Helper methods ----  
            }
        for (String section : requested) {  
    @Provide  
public class StatSectionFilteringPropertyTests {
 * The OpenSearch Contributors require contributions made to  
    void filteredStatsContainsExactlyRequestedSections(
import org.opensearch.common.xcontent.XContentFactory;  
                    if (stats.getNativeExecutorsStats() != null && stats.getNativeExecutorsStats().getCpuRuntime() != null) {  
 *
}
    }  
        }
    /**
                new PartitionGateStats("fragment_executor_gate", 12, 3, 100, 50, 0, 12, 0, 0),  
import java.util.LinkedHashMap;
import net.jqwik.api.Arbitrary;
        DataFusionStats filteredNull = TransportDataFusionStatsAction.filteredStats(stats, null);
        // Empty filter returns same object
        Set<String> expectedSections = computeExpectedSections(stats, requestedSections);
        "cpu_runtime",  
                        expected.add(section);
        Arbitrary<Long> nonNeg = Arbitraries.longs().between(0, Long.MAX_VALUE / 2);  
    /** DataFusionStats with all sections populated (CPU runtime present). */
        // AND present in the original stats will appear in the output.
     * (complement check)
        DataFusionStats filtered = TransportDataFusionStatsAction.filteredStats(stats, requestedSections);
    @Property(tries = 150)  
 *  
        "coordinator_reduce",
        assertTrue(stats == filteredNull, "Null filter must return the original stats object");
import java.util.Map;  
import net.jqwik.api.Property;
                monitors.put("stream_next", sn);  
                    }
                Map<String, TaskMonitorStats> monitors = new LinkedHashMap<>();  
        DataFusionStats filtered = TransportDataFusionStatsAction.filteredStats(stats, requestedSections);
import static org.junit.jupiter.api.Assertions.assertEquals;
                    break;  
import net.jqwik.api.Arbitraries;  
import java.util.Set;
        "io_runtime",
import java.io.IOException;
    Arbitrary<DataFusionStats> dataFusionStatsFullCpuAbsent() {  
                    break;
     *  
                    null  
import java.util.List;
    }
                    rt.blockingQueueDepth,  
                    rt.spawnedTasksCount,
     *  
 * SPDX-License-Identifier: Apache-2.0
    /**  
                "Section '" + excluded + "' should NOT be present in filtered output. " + "Requested: " + requestedSections  
                    }  
     */
    }  
     * <p>When the filter is null or empty, all sections from the original stats are preserved.  
            "Filtered JSON must contain exactly the requested (and available) sections. " + "Requested: " + requestedSections
            actualSections.add(fieldNames.next());  
        builder.startObject();
import net.jqwik.api.Provide;
    }
import com.fasterxml.jackson.databind.JsonNode;
    Arbitrary<RuntimeMetrics> runtimeMetrics() {
                null
                    break;  
                    rt.totalPollsCount,
 */
import org.opensearch.be.datafusion.stats.RuntimeMetrics;
    ) throws IOException {
     * A section appears only if it was requested AND the original stats had
            );  
import net.jqwik.api.Combinators;
                    if (stats.getNativeExecutorsStats() != null && stats.getNativeExecutorsStats().getTaskMonitors().get(section) != null) {
        "plan_setup",
        Set<String> expected = new HashSet<>();
            if (rt.workersCount == 0) {
            expectedSections,  
                case "coordinator_reduce":  
        return Combinators.combine(runtimeMetrics(), runtimeMetrics().map(rt -> {
    ) throws IOException {
        }), taskMonitorStats(), taskMonitorStats(), taskMonitorStats(), taskMonitorStats()).as((io, cpu, cr, qe, sn, ps) -> {
    @Provide
        return Arbitraries.of(ALL_SECTIONS).set().ofMinSize(1).ofMaxSize(7);
        });
        assertEquals(
    @Provide  
        // Verify: actual sections == expected sections
        return expected;
        builder.endObject();
import java.util.Iterator;  
 * <p><b>Validates: Requirements 3.1, 3.2, 3.4, 5.3</b>  
     * Feature: datafusion-cluster-stats, Property 3: Stat section filtering correctness
                    rt.totalOverflowCount,
import static org.junit.jupiter.api.Assertions.assertFalse;
                    break;
    @Provide
            monitors.put("plan_setup", ps);  
            );
 * this file be licensed under the Apache-2.0 license or a
        @ForAll("statSectionSubset") Set<String> requestedSections  
     */  
            }  
    @Provide
    /** All 7 valid stat section names. */  
 * instance, when the subset is applied as a filter via
 * Property-based tests for stat section filtering correctness.  
        );  
                    1,
    }
            });
                    rt.numAliveTasks,
 * <p>Feature: datafusion-cluster-stats, Property 3: Stat section filtering correctness
                case "stream_next":
     * <p>For any non-empty subset of valid stat section names and any DataFusionStats
     * Feature: datafusion-cluster-stats, Property 3: Stat section filtering correctness
import com.fasterxml.jackson.databind.ObjectMapper;
 *
                default:
     * Feature: datafusion-cluster-stats, Property 3: Stat section filtering correctness  
            .ofSize(9)  
                return new RuntimeMetrics(  
            monitors.put("stream_next", sn);
                    }
    /**
        // Determine expected sections: only sections that were both requested  
    /** Generates a non-empty subset of the 7 valid stat section names. */
