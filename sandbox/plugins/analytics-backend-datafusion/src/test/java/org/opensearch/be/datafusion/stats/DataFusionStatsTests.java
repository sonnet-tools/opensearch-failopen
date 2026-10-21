 * <p>Layout: IO RuntimeMetrics (9 fields), optional CPU RuntimeMetrics (9 fields),
            null,
/*
        assertTrue(json.contains("\"plan_setup\""));
        // Flat structure: no "native_executors" or "task_monitors" wrappers
            "workers_count",
        }
        Map<String, TaskMonitorStats> taskMonitors = new LinkedHashMap<>();
        assertTrue(monitors.containsKey("stream_next"));
        Map<String, TaskMonitorStats> taskMonitors = new LinkedHashMap<>();
    public void testSequentialConstructionVerifiesFields() {
            assertTrue("JSON should contain field: " + field, json.contains("\"" + field + "\""));
        taskMonitors.put("coordinator_reduce", new TaskMonitorStats(14, 15, 16, 0, 0));
import java.io.IOException;
        TaskMonitorStats cr = monitors.get("coordinator_reduce");
        assertEquals(18L, cr.totalScheduledDurationMs);
        assertEquals(6L, io.blockingQueueDepth);
            null,
        assertTrue(json.contains("\"workers_count\":1"));
import org.opensearch.core.xcontent.ToXContent;
            "total_polls_count",
package org.opensearch.be.datafusion.stats;
        assertTrue(monitors.containsKey("coordinator_reduce"));
        taskMonitors.put("plan_setup", new TaskMonitorStats(26, 27, 28, 0, 0));
        return new DataFusionStats(
        String json = toJsonString(stats);
        assertTrue(json.contains("\"size_limit_bytes\":100000000"));
        for (String field : taskFields) {
    // ---- Test: toXContent renders correct JSON structure ----
        String json = toJsonString(stats);
        DataFusionStats stats = new DataFusionStats(
}
        taskMonitors.put("plan_setup", new TaskMonitorStats(23, 24, 25, 0, 0));
            DataFusionStats roundTripped = new DataFusionStats(in);
import org.opensearch.core.xcontent.XContentBuilder;
        org.opensearch.common.io.stream.BytesStreamOutput out = new org.opensearch.common.io.stream.BytesStreamOutput();
        String[] taskFields = { "total_poll_duration_ms", "total_scheduled_duration_ms", "total_idle_duration_ms" };
        assertTrue(json.contains("\"query_execution\""));
        );
        DataFusionStats stats = sequentialStats();
/**
        assertEquals(4, monitors.size());
        try (org.opensearch.core.common.io.stream.StreamInput in = out.bytes().streamInput()) {
        assertEquals(22L, qe.totalIdleDurationMs);
    // ---- Test: exactly 4 task monitor keys ----
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);
    }
        assertTrue(json.contains("\"disk_available_bytes\":60"));
        taskMonitors.put("stream_next", new TaskMonitorStats(20, 21, 22, 0, 0));
        assertTrue(json.contains("\"statistics_cache\""));
        assertTrue(json.contains("\"disk_reserved_bytes\":80"));
        taskMonitors.put("coordinator_reduce", new TaskMonitorStats(17, 18, 19, 0, 0));
        // Task monitors at top level (no wrapper)
        assertFalse("cpu_runtime should not appear", json.contains("\"cpu_runtime\""));
            assertTrue("JSON should contain task monitor field: " + field, json.contains("\"" + field + "\""));
        assertEquals(8L, io.spawnedTasksCount);
        assertTrue(json.contains("\"disk_used_bytes\":40"));
            null,
        );
        assertTrue(json.contains("\"directory\":\"/mnt/spill\""));
 *
        // CPU runtime (values 9-16)
    public void testSpillFragmentRendersUnderDiskSpillKey() throws IOException {
        RuntimeMetrics cpu = new RuntimeMetrics(9, 10, 11, 12, 13, 14, 15, 16, 0);
 * The OpenSearch Contributors require contributions made to
        assertTrue(json.contains("\"stream_next\""));
        String json = toJsonString(stats);
        NativeExecutorsStats nes = stats.getNativeExecutorsStats();
    }
        assertNull(stats.getNativeExecutorsStats().getCpuRuntime());
    private static DataFusionStats sequentialStats() {
    public void testCpuRuntimePresentWhenNonNull() throws IOException {
    // ---- Test: cacheStats omitted by default (no cache stats provided → null) ----
        assertTrue("cache_stats wrapper expected", json.contains("\"cache_stats\""));
    // ---- Test: non-null CPU runtime → cpuRuntime present in JSON ----
    }
import java.util.LinkedHashMap;
        // Task monitors
        // IO runtime (values 1-8)
            null
        taskMonitors.put("query_execution", new TaskMonitorStats(17, 18, 19, 0, 0));
 * compatible open source license.
 */
        String json = toJsonString(stats);
    }
        }
            new CacheGroupStats(50, 0, 25, 2048, 100_000_000),
        assertNull(stats.getCacheStats());
            new NativeExecutorsStats(io, null, taskMonitors),
        );
        return builder.toString();
    }
        TaskMonitorStats ps = monitors.get("plan_setup");
            "blocking_queue_depth",
        assertEquals(3L, io.totalBusyDurationMs);
        assertTrue(json.contains("\"coordinator_reduce\""));
        assertEquals(16L, cpu.spawnedTasksCount);
import org.opensearch.test.OpenSearchTestCase;
    public void testCpuRuntimeAbsentWhenNull() throws IOException {
        assertTrue(json.contains("\"plan_setup\""));
        assertEquals(7L, io.numAliveTasks);
        }
    public void testToXContentCpuRuntimeOmitted() throws IOException {
            null,
        RuntimeMetrics io = new RuntimeMetrics(100, 101, 102, 103, 104, 105, 106, 107, 0);
        assertEquals(14L, cpu.blockingQueueDepth);
        assertSame(cache, stats.getCacheStats());
        assertTrue(json.contains("\"coordinator_reduce\""));
            null
            new NativeExecutorsStats(io, null, taskMonitors),
        assertEquals(12L, cpu.totalOverflowCount);
        assertNotNull(cr);
 * SPDX-License-Identifier: Apache-2.0
        original.writeTo(out);
import org.opensearch.common.xcontent.XContentFactory;
            null,
        taskMonitors.put("plan_setup", new TaskMonitorStats(23, 24, 25, 0, 0));
            new PartitionGateStats("fragment_executor_gate", 12, 0, 0, 0, 0, 12, 0, 0),
            new PartitionGateStats("fragment_executor_gate", 12, 0, 0, 0, 0, 12, 0, 0),
            new SpillStats("/mnt/spill", 100L, 60L, 40L, 80L, 0L),
        assertTrue(json.contains("\"metadata_cache\""));
        assertEquals(11L, cpu.totalBusyDurationMs);
        taskMonitors.put("stream_next", new TaskMonitorStats(0, 0, 0, 0, 0));
        taskMonitors.put("coordinator_reduce", new TaskMonitorStats(14, 15, 16, 0, 0));
        taskMonitors.put("query_execution", new TaskMonitorStats(17, 18, 19, 0, 0));
 *
    }
        assertTrue(json.contains("\"size_limit_bytes\":250000000"));
        assertTrue(json.contains("\"io_runtime\""));
    private static String toJsonString(DataFusionStats stats) throws IOException {
        assertTrue("coordinator_reduce should still be present", json.contains("coordinator_reduce"));
        taskMonitors.put("plan_setup", new TaskMonitorStats(0, 0, 0, 0, 0));
 */
        assertEquals(27L, ps.totalScheduledDurationMs);
 * Unit tests for {@link DataFusionStats} constructed via direct constructors.
        RuntimeMetrics io = new RuntimeMetrics(1, 2, 3, 4, 5, 6, 7, 8, 0);
        // coordinator_reduce: total_poll_duration_ms = 17
        assertFalse("cpu_runtime should be omitted when null", json.contains("cpu_runtime"));
            new NativeExecutorsStats(io, cpu, taskMonitors),
 * this file be licensed under the Apache-2.0 license or a
public class DataFusionStatsTests extends OpenSearchTestCase {
        assertEquals(28L, ps.totalIdleDurationMs);
            new NativeExecutorsStats(io, null, taskMonitors),
        );
        DataFusionStats stats = sequentialStats();
        assertEquals(17L, cr.totalPollDurationMs);
        assertEquals(2L, io.totalPollsCount);
        assertNotNull(ps);
        DataFusionStats stats = sequentialStats();
    /** Build a DataFusionStats with sequential values for deterministic field verification. */
            "total_busy_duration_ms",
            new PartitionGateStats("datanode_gate", 12, 0, 0, 0, 0, 12, 0, 0),
        String[] runtimeFieldNames = {
        assertNotNull(cpu);
        );
        taskMonitors.put("query_execution", new TaskMonitorStats(20, 21, 22, 0, 0));
            null,
        assertEquals(24L, sn.totalScheduledDurationMs);
        assertTrue(json.contains("\"total_poll_duration_ms\":17"));
        assertTrue("plan_setup should still be present", json.contains("plan_setup"));
        assertTrue(monitors.containsKey("plan_setup"));
        assertEquals(5L, io.globalQueueDepth);
    // ---- Test: toXContent with CPU runtime omitted ----
            null
            "global_queue_depth",
            new CacheGroupStats(15, 2, 5, 512, 16_000_000)
        Map<String, TaskMonitorStats> monitors = nes.getTaskMonitors();
        assertTrue(json.contains("\"cpu_runtime\""));
        assertTrue(monitors.containsKey("query_execution"));
        DataFusionStats stats = new DataFusionStats(
        taskMonitors.put("stream_next", new TaskMonitorStats(23, 24, 25, 0, 0));
        builder.endObject();
        assertTrue(json.contains("\"hit_count\":100"));
        String json = toJsonString(stats);
        // Task monitors are at top level (flat structure, no "task_monitors" wrapper)
        // Task monitors at top level
        assertTrue("query_execution should still be present", json.contains("query_execution"));
        DataFusionStats stats = sequentialStats();
        Map<String, TaskMonitorStats> taskMonitors = new LinkedHashMap<>();
        assertEquals(25L, sn.totalIdleDurationMs);
        Map<String, TaskMonitorStats> taskMonitors = new LinkedHashMap<>();
        // IO runtime: workers_count = 1
            cache,
        Map<String, TaskMonitorStats> monitors = stats.getNativeExecutorsStats().getTaskMonitors();
        RuntimeMetrics io = nes.getIoRuntime();
    }
            assertNotNull(roundTripped.getSpillStats());
        assertEquals(19L, cr.totalIdleDurationMs);
        DataFusionStats stats = sequentialStats();
        RuntimeMetrics io = new RuntimeMetrics(1, 2, 3, 4, 5, 6, 7, 8, 0);
    // ---- Test: cacheStats present → renders into JSON ----
        assertFalse("cache_stats should be omitted when null", json.contains("cache_stats"));
    // ---- Test: sequential construction verifies each field ----
            "total_overflow_count",
        assertTrue(json.contains("\"disk_total_bytes\":100"));
        assertNotNull(sn);
    public void testCacheStatsPresentRendersIntoJson() throws IOException {
        assertEquals(4L, io.totalOverflowCount);
        assertEquals(26L, ps.totalPollDurationMs);
        assertEquals(15L, cpu.numAliveTasks);
    public void testCacheStatsAbsentWhenNotProvided() throws IOException {
        assertTrue("missing disk_spill object: " + json, json.contains("\"disk_spill\":{"));
        TaskMonitorStats qe = monitors.get("query_execution");
        RuntimeMetrics io = new RuntimeMetrics(100, 101, 102, 103, 104, 105, 106, 107, 0);
            new CacheGroupStats(20, 3, 8, 1024, 64_000_000),
        CacheStats cache = new CacheStats(
        assertEquals(10L, cpu.totalPollsCount);
        assertEquals(4, monitors.size());
        assertTrue("cpu_runtime should be present", json.contains("cpu_runtime"));
        taskMonitors.put("stream_next", new TaskMonitorStats(20, 21, 22, 0, 0));
        RuntimeMetrics cpu = nes.getCpuRuntime();
        assertNotNull(io);
    public void testToXContentJsonStructure() throws IOException {
    public void testExactlyFourTaskMonitors() {
        assertTrue(json.contains("\"io_runtime\""));
        assertNotNull(stats.getNativeExecutorsStats().getCpuRuntime());
        assertNotNull(nes);
        assertNotNull(qe);
    }
            "num_alive_tasks",
            null
        assertTrue("stream_next should still be present", json.contains("stream_next"));
            assertEquals(original.getSpillStats(), roundTripped.getSpillStats());
        String json = toJsonString(stats);
        assertEquals(1L, io.workersCount);
        XContentBuilder builder = XContentFactory.jsonBuilder();
        assertEquals(23L, sn.totalPollDurationMs);
        assertTrue(json.contains("\"hit_count\":50"));
        String json = toJsonString(stats);
        builder.startObject();
 * 4 TaskMonitorStats (3 fields each).
    // ---- Test: CPU runtime null → cpuRuntime absent in JSON ----
        for (String field : runtimeFieldNames) {
    }
    }
        TaskMonitorStats sn = monitors.get("stream_next");
        assertFalse(json.contains("\"task_monitors\""));
    }
    }
        assertEquals(20L, qe.totalPollDurationMs);
        taskMonitors.put("query_execution", new TaskMonitorStats(0, 0, 0, 0, 0));
            new CacheGroupStats(100, 5, 25, 4096, 250_000_000),
import java.util.Map;
    public void testSpillFragmentRoundTripsThroughDataFusionStatsWriteable() throws IOException {
        DataFusionStats original = sequentialStats();
            "spawned_tasks_count" };
        DataFusionStats stats = sequentialStats();
        assertEquals(9L, cpu.workersCount);
        assertEquals(21L, qe.totalScheduledDurationMs);
        assertTrue("io_runtime should still be present", json.contains("io_runtime"));
        assertFalse(json.contains("\"native_executors\""));
        assertTrue(json.contains("\"query_execution\""));
        DataFusionStats stats = new DataFusionStats(
            new PartitionGateStats("fragment_executor_gate", 12, 0, 0, 0, 0, 12, 0, 0),
        taskMonitors.put("coordinator_reduce", new TaskMonitorStats(0, 0, 0, 0, 0));
        assertEquals(13L, cpu.globalQueueDepth);
