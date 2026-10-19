        assertEquals(4, monitors.size());
            new NativeExecutorsStats(io, cpu, taskMonitors),
        );  
        assertTrue("stream_next should still be present", json.contains("stream_next"));  
        try (org.opensearch.core.common.io.stream.StreamInput in = out.bytes().streamInput()) {
    }
        }  
        RuntimeMetrics cpu = nes.getCpuRuntime();
    // ---- Test: non-null CPU runtime → cpuRuntime present in JSON ----
            null,
        String json = toJsonString(stats);  
        taskMonitors.put("plan_setup", new TaskMonitorStats(23, 24, 25, 0, 0));
        assertNotNull(cpu);  
        assertFalse("cache_stats should be omitted when null", json.contains("cache_stats"));
            "total_overflow_count",
/**
        assertTrue("plan_setup should still be present", json.contains("plan_setup"));
            DataFusionStats roundTripped = new DataFusionStats(in);  
        assertTrue(json.contains("\"metadata_cache\""));  
        assertEquals(22L, qe.totalIdleDurationMs);  
        assertTrue("io_runtime should still be present", json.contains("io_runtime"));
        assertTrue(json.contains("\"hit_count\":100"));
        assertEquals(11L, cpu.totalBusyDurationMs);  
        assertTrue(json.contains("\"workers_count\":1"));  
import java.util.LinkedHashMap;
        org.opensearch.common.io.stream.BytesStreamOutput out = new org.opensearch.common.io.stream.BytesStreamOutput();
            null
        assertTrue("query_execution should still be present", json.contains("query_execution"));
import java.util.Map;
    }  
    }  
        original.writeTo(out);  
            null,  
        TaskMonitorStats sn = monitors.get("stream_next");
        assertNotNull(cr);  
        assertEquals(21L, qe.totalScheduledDurationMs);
        // Task monitors at top level  
            null
        assertEquals(13L, cpu.globalQueueDepth);
        taskMonitors.put("stream_next", new TaskMonitorStats(20, 21, 22, 0, 0));
        assertTrue(json.contains("\"disk_total_bytes\":100"));
    public void testToXContentJsonStructure() throws IOException {
        assertEquals(10L, cpu.totalPollsCount);
        assertFalse("cpu_runtime should not appear", json.contains("\"cpu_runtime\""));  
        DataFusionStats stats = sequentialStats();  
        TaskMonitorStats ps = monitors.get("plan_setup");
        assertTrue(json.contains("\"coordinator_reduce\""));
            assertTrue("JSON should contain field: " + field, json.contains("\"" + field + "\""));
            null
        assertTrue("cache_stats wrapper expected", json.contains("\"cache_stats\""));
        DataFusionStats stats = sequentialStats();  
        assertEquals(26L, ps.totalPollDurationMs);
        );
            "spawned_tasks_count" };  
        taskMonitors.put("coordinator_reduce", new TaskMonitorStats(0, 0, 0, 0, 0));  
        assertNotNull(ps);  
        String[] runtimeFieldNames = {
        XContentBuilder builder = XContentFactory.jsonBuilder();
        assertSame(cache, stats.getCacheStats());
    public void testExactlyFourTaskMonitors() {  
            cache,
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);
    // ---- Test: cacheStats omitted by default (no cache stats provided → null) ----  
        String json = toJsonString(stats);  
        RuntimeMetrics io = new RuntimeMetrics(100, 101, 102, 103, 104, 105, 106, 107, 0);
    }
        assertTrue(json.contains("\"cpu_runtime\""));  
            null,  
        DataFusionStats stats = sequentialStats();
            new CacheGroupStats(100, 5, 25, 4096, 250_000_000),  
        String json = toJsonString(stats);
            new SpillStats("/mnt/spill", 100L, 60L, 40L, 80L, 0L),
            new CacheGroupStats(50, 0, 25, 2048, 100_000_000),
        for (String field : taskFields) {
            new PartitionGateStats("fragment_executor_gate", 12, 0, 0, 0, 0, 12, 0, 0),
            new CacheGroupStats(20, 3, 8, 1024, 64_000_000),
        assertTrue("coordinator_reduce should still be present", json.contains("coordinator_reduce"));
        NativeExecutorsStats nes = stats.getNativeExecutorsStats();
import org.opensearch.common.xcontent.XContentFactory;
/*  
    private static String toJsonString(DataFusionStats stats) throws IOException {
        assertNotNull(io);  
        assertEquals(4, monitors.size());  
        taskMonitors.put("query_execution", new TaskMonitorStats(20, 21, 22, 0, 0));  
        String json = toJsonString(stats);
            new PartitionGateStats("fragment_executor_gate", 12, 0, 0, 0, 0, 12, 0, 0),  
        // coordinator_reduce: total_poll_duration_ms = 17
    public void testCacheStatsPresentRendersIntoJson() throws IOException {  
        taskMonitors.put("query_execution", new TaskMonitorStats(0, 0, 0, 0, 0));
        assertNotNull(qe);  
    }
        return builder.toString();  
        String json = toJsonString(stats);
        // Task monitors are at top level (flat structure, no "task_monitors" wrapper)  
    // ---- Test: toXContent renders correct JSON structure ----  
        taskMonitors.put("plan_setup", new TaskMonitorStats(26, 27, 28, 0, 0));
        assertTrue(json.contains("\"query_execution\""));  
        for (String field : runtimeFieldNames) {
        assertNotNull(stats.getNativeExecutorsStats().getCpuRuntime());
        // IO runtime (values 1-8)
        return new DataFusionStats(  
        assertFalse("cpu_runtime should be omitted when null", json.contains("cpu_runtime"));
        RuntimeMetrics io = new RuntimeMetrics(1, 2, 3, 4, 5, 6, 7, 8, 0);
    }
        taskMonitors.put("query_execution", new TaskMonitorStats(17, 18, 19, 0, 0));
import org.opensearch.core.xcontent.ToXContent;
        Map<String, TaskMonitorStats> monitors = nes.getTaskMonitors();
        assertTrue(monitors.containsKey("coordinator_reduce"));
        assertEquals(20L, qe.totalPollDurationMs);
        );
        taskMonitors.put("coordinator_reduce", new TaskMonitorStats(14, 15, 16, 0, 0));
        assertTrue(json.contains("\"coordinator_reduce\""));
        assertFalse(json.contains("\"task_monitors\""));
        assertEquals(24L, sn.totalScheduledDurationMs);
        assertTrue(json.contains("\"statistics_cache\""));
    /** Build a DataFusionStats with sequential values for deterministic field verification. */  
 */  
            "global_queue_depth",  
import org.opensearch.test.OpenSearchTestCase;
        Map<String, TaskMonitorStats> taskMonitors = new LinkedHashMap<>();
        // Task monitors at top level (no wrapper)
        DataFusionStats original = sequentialStats();  
        DataFusionStats stats = sequentialStats();  
    public void testCacheStatsAbsentWhenNotProvided() throws IOException {
    }
        Map<String, TaskMonitorStats> taskMonitors = new LinkedHashMap<>();  
    // ---- Test: sequential construction verifies each field ----  
        DataFusionStats stats = new DataFusionStats(
        String json = toJsonString(stats);
    }
        assertEquals(17L, cr.totalPollDurationMs);
        assertEquals(28L, ps.totalIdleDurationMs);  
            new PartitionGateStats("fragment_executor_gate", 12, 0, 0, 0, 0, 12, 0, 0),
    public void testSequentialConstructionVerifiesFields() {
    public void testSpillFragmentRendersUnderDiskSpillKey() throws IOException {
        DataFusionStats stats = new DataFusionStats(
        RuntimeMetrics io = new RuntimeMetrics(100, 101, 102, 103, 104, 105, 106, 107, 0);  
 * SPDX-License-Identifier: Apache-2.0
        RuntimeMetrics io = nes.getIoRuntime();
            null,
        Map<String, TaskMonitorStats> taskMonitors = new LinkedHashMap<>();
            null,  
        assertTrue(json.contains("\"io_runtime\""));
            new NativeExecutorsStats(io, null, taskMonitors),
            new CacheGroupStats(15, 2, 5, 512, 16_000_000)  
        assertEquals(15L, cpu.numAliveTasks);
 * compatible open source license.
        assertTrue(json.contains("\"disk_used_bytes\":40"));
        String json = toJsonString(stats);  
        assertTrue("cpu_runtime should be present", json.contains("cpu_runtime"));
            new PartitionGateStats("datanode_gate", 12, 0, 0, 0, 0, 12, 0, 0),
        RuntimeMetrics io = new RuntimeMetrics(1, 2, 3, 4, 5, 6, 7, 8, 0);
    }  
        assertTrue(json.contains("\"disk_reserved_bytes\":80"));
            "total_polls_count",  
        );
 *
 * this file be licensed under the Apache-2.0 license or a
        TaskMonitorStats qe = monitors.get("query_execution");
    }
        // Task monitors
 * 4 TaskMonitorStats (3 fields each).
        assertTrue(json.contains("\"stream_next\""));  
    // ---- Test: exactly 4 task monitor keys ----
    // ---- Test: CPU runtime null → cpuRuntime absent in JSON ----  
        taskMonitors.put("plan_setup", new TaskMonitorStats(23, 24, 25, 0, 0));
            null  
        }  
        assertTrue(monitors.containsKey("plan_setup"));
        assertEquals(14L, cpu.blockingQueueDepth);  
    }  
        assertEquals(25L, sn.totalIdleDurationMs);  
        assertEquals(18L, cr.totalScheduledDurationMs);
        assertEquals(1L, io.workersCount);
    public void testSpillFragmentRoundTripsThroughDataFusionStatsWriteable() throws IOException {
        assertTrue(monitors.containsKey("query_execution"));  
 * <p>Layout: IO RuntimeMetrics (9 fields), optional CPU RuntimeMetrics (9 fields),
        assertTrue(monitors.containsKey("stream_next"));
 * The OpenSearch Contributors require contributions made to  
        TaskMonitorStats cr = monitors.get("coordinator_reduce");
        // IO runtime: workers_count = 1
            new NativeExecutorsStats(io, null, taskMonitors),  
    // ---- Test: cacheStats present → renders into JSON ----
        assertEquals(8L, io.spawnedTasksCount);
        taskMonitors.put("stream_next", new TaskMonitorStats(23, 24, 25, 0, 0));
        assertNotNull(sn);  
        assertNull(stats.getCacheStats());
        assertNull(stats.getNativeExecutorsStats().getCpuRuntime());
        String[] taskFields = { "total_poll_duration_ms", "total_scheduled_duration_ms", "total_idle_duration_ms" };  
    public void testCpuRuntimeAbsentWhenNull() throws IOException {
        taskMonitors.put("plan_setup", new TaskMonitorStats(0, 0, 0, 0, 0));  
import java.io.IOException;  
        assertTrue(json.contains("\"hit_count\":50"));  
        taskMonitors.put("coordinator_reduce", new TaskMonitorStats(17, 18, 19, 0, 0));
    public void testCpuRuntimePresentWhenNonNull() throws IOException {  
        assertEquals(6L, io.blockingQueueDepth);  
 *  
            "blocking_queue_depth",
        RuntimeMetrics cpu = new RuntimeMetrics(9, 10, 11, 12, 13, 14, 15, 16, 0);  
        assertTrue(json.contains("\"disk_available_bytes\":60"));  
    public void testToXContentCpuRuntimeOmitted() throws IOException {
package org.opensearch.be.datafusion.stats;
        assertTrue(json.contains("\"plan_setup\""));
        );  
            assertTrue("JSON should contain task monitor field: " + field, json.contains("\"" + field + "\""));
        Map<String, TaskMonitorStats> monitors = stats.getNativeExecutorsStats().getTaskMonitors();
        assertEquals(3L, io.totalBusyDurationMs);  
        assertTrue(json.contains("\"total_poll_duration_ms\":17"));
public class DataFusionStatsTests extends OpenSearchTestCase {
        // CPU runtime (values 9-16)
        assertEquals(19L, cr.totalIdleDurationMs);  
    // ---- Test: toXContent with CPU runtime omitted ----
        }  
        builder.startObject();  
            assertEquals(original.getSpillStats(), roundTripped.getSpillStats());
        Map<String, TaskMonitorStats> taskMonitors = new LinkedHashMap<>();
            new NativeExecutorsStats(io, null, taskMonitors),
}
        builder.endObject();
        assertEquals(9L, cpu.workersCount);
 * Unit tests for {@link DataFusionStats} constructed via direct constructors.
        assertTrue(json.contains("\"query_execution\""));
            "num_alive_tasks",
        DataFusionStats stats = sequentialStats();  
    }
        assertEquals(4L, io.totalOverflowCount);
        assertEquals(2L, io.totalPollsCount);
        assertFalse(json.contains("\"native_executors\""));
        assertEquals(23L, sn.totalPollDurationMs);
 */  
        assertTrue("missing disk_spill object: " + json, json.contains("\"disk_spill\":{"));  
            assertNotNull(roundTripped.getSpillStats());
        assertEquals(16L, cpu.spawnedTasksCount);
        assertTrue(json.contains("\"plan_setup\""));
import org.opensearch.core.xcontent.XContentBuilder;  
            null,
        assertNotNull(nes);
        assertTrue(json.contains("\"directory\":\"/mnt/spill\""));
            "workers_count",
        assertTrue(json.contains("\"size_limit_bytes\":250000000"));
        // Flat structure: no "native_executors" or "task_monitors" wrappers  
    private static DataFusionStats sequentialStats() {
        DataFusionStats stats = sequentialStats();
        assertEquals(5L, io.globalQueueDepth);
        DataFusionStats stats = new DataFusionStats(  
        CacheStats cache = new CacheStats(
        taskMonitors.put("stream_next", new TaskMonitorStats(20, 21, 22, 0, 0));  
        assertTrue(json.contains("\"size_limit_bytes\":100000000"));
        taskMonitors.put("stream_next", new TaskMonitorStats(0, 0, 0, 0, 0));
        taskMonitors.put("query_execution", new TaskMonitorStats(17, 18, 19, 0, 0));  
        assertEquals(27L, ps.totalScheduledDurationMs);
        assertEquals(12L, cpu.totalOverflowCount);
        assertEquals(7L, io.numAliveTasks);
        taskMonitors.put("coordinator_reduce", new TaskMonitorStats(14, 15, 16, 0, 0));
        assertTrue(json.contains("\"io_runtime\""));
            "total_busy_duration_ms",
