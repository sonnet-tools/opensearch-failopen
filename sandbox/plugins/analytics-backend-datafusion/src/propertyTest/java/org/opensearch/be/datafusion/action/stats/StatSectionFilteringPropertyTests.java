    Arbitrary<RuntimeMetrics> runtimeMetrics() {
import org.opensearch.core.xcontent.ToXContent;
                monitors.put("stream_next", sn);
        DataFusionStats filteredNull = TransportDataFusionStatsAction.filteredStats(stats, null);
        @ForAll("dataFusionStats") DataFusionStats stats,
 * <p>Feature: datafusion-cluster-stats, Property 3: Stat section filtering correctness
            .between(0, Long.MAX_VALUE / 2)
    @Property(tries = 100)
    }
        }), taskMonitorStats(), taskMonitorStats(), taskMonitorStats(), taskMonitorStats()).as((io, cpu, cr, qe, sn, ps) -> {
                new PartitionGateStats("fragment_executor_gate", 12, 3, 100, 50, 0, 12, 0, 0),
                Map<String, TaskMonitorStats> monitors = new LinkedHashMap<>();
        @ForAll("statSectionSubset") Set<String> requestedSections
        // Render filtered stats to JSON
        return Combinators.combine(runtimeMetrics(), runtimeMetrics().map(rt -> {
            .list()
     * <p>When the filter is null or empty, all sections from the original stats are preserved.
 * this file be licensed under the Apache-2.0 license or a
                    1,
                    break;
import org.opensearch.common.xcontent.XContentFactory;
        "cpu_runtime",
    }
        return Arbitraries.longs()
                case "plan_setup":
import java.util.LinkedHashMap;
        builder.endObject();
            }
                    break;
                    break;
                    rt.blockingQueueDepth,
        Set<String> excludedSections = new HashSet<>(ALL_SECTIONS);
    Arbitrary<TaskMonitorStats> taskMonitorStats() {
            .as((io, cr, qe, sn, ps) -> {
                    rt.globalQueueDepth,
        if (stats != null) {
 * Property-based tests for stat section filtering correctness.
     *
    @Provide
    @Provide
     * Feature: datafusion-cluster-stats, Property 3: Stat section filtering correctness
                monitors.put("query_execution", qe);
                default:
package org.opensearch.be.datafusion.action.stats;
        @ForAll("dataFusionStats") DataFusionStats stats,
    @Provide
     * <p><b>Validates: Requirements 3.1, 3.2, 3.4, 5.3</b>
        JsonNode root = MAPPER.readTree(json);
    /** DataFusionStats with all sections populated (CPU runtime present). */
    Arbitrary<Set<String>> statSectionSubset() {
                case "stream_next":
    // ---- Helper methods ----
import org.opensearch.be.datafusion.stats.NativeExecutorsStats;
                    rt.totalOverflowCount,
                        expected.add(section);
            .ofSize(9)
        "stream_next",
        while (fieldNames.hasNext()) {
        assertTrue(stats == filteredEmpty, "Empty filter must return the original stats object");
        String json = renderJson(filtered);
    }
import net.jqwik.api.Combinators;
            monitors.put("stream_next", sn);
            monitors.put("coordinator_reduce", cr);
    private Set<String> computeExpectedSections(DataFusionStats stats, Set<String> requested) {
            if (rt.workersCount == 0) {
import org.opensearch.be.datafusion.stats.DataFusionStats;
     * <p>For any non-empty subset of valid stat section names and any DataFusionStats
import static org.junit.jupiter.api.Assertions.assertEquals;
    }
     *
import net.jqwik.api.Arbitraries;
    }
        return Arbitraries.oneOf(dataFusionStatsFullCpuPresent(), dataFusionStatsFullCpuAbsent());
     */
public class StatSectionFilteringPropertyTests {
     *
                        expected.add(section);
     * Computes the set of section names expected in the filtered JSON output.
                );
                    if (stats.getNativeExecutorsStats() != null && stats.getNativeExecutorsStats().getTaskMonitors().get(section) != null) {
     *
                    rt.totalLocalQueueDepth
     */
        Arbitrary<Long> nonNeg = Arbitraries.longs().between(0, Long.MAX_VALUE / 2);
    // ---- Object generators ----
                    if (stats.getFragmentExecutorGateStats() != null) {
                );
     * <p><b>Validates: Requirements 3.4, 5.3</b>
        );
        // Sections NOT requested must be absent from the output
            switch (section) {
import net.jqwik.api.Property;
import org.opensearch.be.datafusion.stats.PartitionGateStats;
     * Feature: datafusion-cluster-stats, Property 3: Stat section filtering correctness
                    new NativeExecutorsStats(io, null, monitors),
            }
 * The OpenSearch Contributors require contributions made to
import net.jqwik.api.ForAll;
            expectedSections,
    }
        "plan_setup",
        Set<String> actualSections = new HashSet<>();
            .map(l -> new RuntimeMetrics(l.get(0), l.get(1), l.get(2), l.get(3), l.get(4), l.get(5), l.get(6), l.get(7), l.get(8)));
    @Provide
        return Combinators.combine(runtimeMetrics(), taskMonitorStats(), taskMonitorStats(), taskMonitorStats(), taskMonitorStats())
    }
    @Property(tries = 150)
 */
    Arbitrary<DataFusionStats> dataFusionStatsFullCpuPresent() {
        assertEquals(
import com.fasterxml.jackson.databind.JsonNode;
                case "fragment_executor_gate":
    @Provide
    @Provide
        DataFusionStats filtered = TransportDataFusionStatsAction.filteredStats(stats, requestedSections);
        JsonNode root = MAPPER.readTree(json);
import static org.junit.jupiter.api.Assertions.assertFalse;
        return Combinators.combine(nonNeg, nonNeg, nonNeg).as(TaskMonitorStats::new);
import java.util.Set;
                monitors.put("coordinator_reduce", cr);
    @Property(tries = 150)
import java.util.Iterator;
 * {@link TransportDataFusionStatsAction#filteredStats}, the rendered JSON for that node
     */
    /** DataFusionStats with CPU runtime absent. */
 * <p><b>Validates: Requirements 3.1, 3.2, 3.4, 5.3</b>
        }
import java.util.Map;
        }
                case "coordinator_reduce":
        DataFusionStats filteredEmpty = TransportDataFusionStatsAction.filteredStats(stats, Set.of());
        "coordinator_reduce",
 *
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;
    private String renderJson(DataFusionStats stats) throws IOException {
                    if (stats.getNativeExecutorsStats() != null && stats.getNativeExecutorsStats().getIoRuntime() != null) {
                    null
        // Render filtered stats to JSON
     * A section appears only if it was requested AND the original stats had
import com.fasterxml.jackson.databind.ObjectMapper;
    /** Combined DataFusionStats generator (CPU present or absent). */
        XContentBuilder builder = XContentFactory.jsonBuilder();
/**
     * instance, filtered output contains exactly the requested sections and no others.
                    }
        return Arbitraries.of(ALL_SECTIONS).set().ofMinSize(1).ofMaxSize(7);
        // Null filter returns same object
                    break;
        String json = renderJson(filtered);
                "Section '" + excluded + "' should NOT be present in filtered output. " + "Requested: " + requestedSections
     *
    /** All 7 valid stat section names. */
    /**
        excludedSections.removeAll(requestedSections);
    /** Generates a non-empty subset of the 7 valid stat section names. */
            Map<String, TaskMonitorStats> monitors = new LinkedHashMap<>();
 *
                return new RuntimeMetrics(
    /**
                    rt.totalPollsCount,
 * <p>For any non-empty subset of valid stat section names and any {@link DataFusionStats}
        return expected;
 * SPDX-License-Identifier: Apache-2.0
            actualSections,
        for (String section : requested) {
 * compatible open source license.
import net.jqwik.api.Provide;
 *
                    rt.totalBusyDurationMs,
import org.opensearch.be.datafusion.stats.RuntimeMetrics;
import org.opensearch.core.xcontent.XContentBuilder;
        "query_execution",
                null,
        }
                case "query_execution":
    private static final ObjectMapper MAPPER = new ObjectMapper();
                null
    Arbitrary<DataFusionStats> dataFusionStatsFullCpuAbsent() {
     * <p>For any non-empty subset of valid stat section names and any DataFusionStats
 *
 * instance, when the subset is applied as a filter via
 */
    // ---- Property 3: Stat section filtering correctness ----
        }
     * <p><b>Validates: Requirements 3.1, 3.2, 3.4, 5.3</b>
    }
                return new DataFusionStats(
            "Filtered JSON must contain exactly the requested (and available) sections. " + "Requested: " + requestedSections
        // Collect all top-level keys from the rendered JSON
            monitors.put("query_execution", qe);
     * non-null data for that section.
                        expected.add(section);
                    }
            actualSections.add(fieldNames.next());
                    }
            return rt;
    Arbitrary<DataFusionStats> dataFusionStats() {
    void filteredStatsContainsExactlyRequestedSections(
    );
import java.util.HashSet;
     * (complement check)
        Set<String> expected = new HashSet<>();
        DataFusionStats filtered = TransportDataFusionStatsAction.filteredStats(stats, requestedSections);
                    break;
                case "cpu_runtime":
                root.has(excluded),
    }
    }
    void filteredStatsExcludesUnrequestedSections(
    ) throws IOException {
    private static final List<String> ALL_SECTIONS = List.of(
     * instance, sections NOT in the filter are absent from the rendered JSON.
                monitors.put("plan_setup", ps);
        @ForAll("statSectionSubset") Set<String> requestedSections
        Iterator<String> fieldNames = root.fieldNames();
                    new PartitionGateStats("fragment_executor_gate", 12, 3, 100, 50, 0, 12, 0, 0),
        assertTrue(stats == filteredNull, "Null filter must return the original stats object");
import java.io.IOException;
                    rt.numAliveTasks,
    }
        });
            assertFalse(
            return new DataFusionStats(
import org.opensearch.be.datafusion.stats.TaskMonitorStats;
    void emptyFilterReturnsAllSections(@ForAll("dataFusionStats") DataFusionStats stats) throws IOException {
        // Empty filter returns same object
        builder.startObject();
 * contains exactly the sections in the subset and no others.
        // Determine expected sections: only sections that were both requested
    /**
            });
            stats.toXContent(builder, ToXContent.EMPTY_PARAMS);
                        expected.add(section);
                    }
        // Verify: actual sections == expected sections
                    if (stats.getNativeExecutorsStats() != null && stats.getNativeExecutorsStats().getCpuRuntime() != null) {
            );
        // AND present in the original stats will appear in the output.
/*
}
     *
        Set<String> expectedSections = computeExpectedSections(stats, requestedSections);
     * (empty/null filter returns all)
                case "io_runtime":
            );
        for (String excluded : excludedSections) {
     * Feature: datafusion-cluster-stats, Property 3: Stat section filtering correctness
                    null,
            monitors.put("plan_setup", ps);
    ) throws IOException {
        "io_runtime",
     */
        return builder.toString();
import net.jqwik.api.Arbitrary;
    /**
        "fragment_executor_gate"
                    rt.spawnedTasksCount,
                new NativeExecutorsStats(io, cpu, monitors),
