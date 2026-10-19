            assertEquals(cs.getStatisticsCache().hitCount, ((Number) statsNode.get("hit_count")).longValue());
    public void testToXContentDeterminismCpuAbsent() throws IOException {
    private DataFusionStats randomDataFusionStatsCpuAbsent() {
    public void testWriteableRoundTripNullExecutors() throws IOException {
    }
        "total_idle_duration_ms",
        "workers_count",
        return XContentHelper.convertToMap(BytesReference.bytes(builder), false, XContentType.JSON).v2();
    }
    private CacheGroupStats randomCacheGroupStats() {
/**
            // IO runtime: 9 fields
        }
            assertEquals("Writeable round-trip must preserve all fields (CPU absent)", original, deserialized);
            nonNegLong(),
    // ---- Object generators ----
                assertEquals(5, monitor.size());
            assertNotNull(metaNode);
        );
    /** JSON field names for RuntimeMetrics in documented order (9 fields). */
import org.opensearch.core.xcontent.XContentBuilder;
            assertNotNull("io_runtime must be present", ioRuntime);
    // ---- Property 1: Writeable round-trip preserves all field values ----
            assertEquals("Writeable round-trip must preserve null executors", original, deserialized);
            nonNegLong(),
            Map<String, Object> metaNode = asMap(cacheNode.get("metadata_cache"));
        }
            nonNegLong(),
            // IO runtime: 9 fields
            nonNegLong(),
import org.opensearch.common.xcontent.XContentType;
            nonNegLong(),
            Map<String, Object> cpuRuntime = asMap(root.get("cpu_runtime"));
        for (int i = 0; i < TRIES; i++) {
            randomCacheStats(),
            nonNegLong(),
            nonNegLong()
            nonNegLong(),
            SearchStats ss = stats.getSearchStats();
            rm.globalQueueDepth,
    }
            for (OperationType opType : OperationType.values()) {
/*
        return new DataFusionStats(null, null, null, null, null, null);
    private RuntimeMetrics randomRuntimeMetricsWithPositiveWorkers() {
    public void testToXContentRoundTripCpuAbsent() throws IOException {
            DataFusionStats original = randomDataFusionStatsCpuAbsent();
    private Map<String, Object> renderToMap(DataFusionStats stats) throws IOException {
        return new DataFusionStats(in);
 * The OpenSearch Contributors require contributions made to
        );
import org.opensearch.core.common.bytes.BytesReference;
    // ---- Helper methods ----
    private static final String[] TASK_FIELD_NAMES = {
            nonNegLong(),
            verifyRuntimeFields(nes.getIoRuntime(), ioRuntime);
    }
        StreamInput in = out.bytes().streamInput();
    }
            assertNotNull("cache_stats must be present", cacheNode);
            nonNegLong(),
public class DataFusionStatsPropertyTests extends OpenSearchTestCase {
                expected[i],
        "total_busy_duration_ms",
            randomCacheStats(),
            assertEquals(ss.bitmapTreeScan, ((Number) searchNode.get("bitmap_tree_scan")).longValue());
    private DataFusionStats randomDataFusionStatsCpuPresent() {
            null,
                Map<String, Object> monitor = asMap(root.get(opType.key()));
    private byte[] renderJsonBytes(DataFusionStats stats) throws IOException {
                expected[i],
    /** RuntimeMetrics with workersCount &gt; 0, marking the CPU runtime as present. */
            verifyRuntimeFields(nes.getCpuRuntime(), cpuRuntime);
package org.opensearch.be.datafusion.stats;
    private TaskMonitorStats randomTaskMonitorStats() {
            nonNegLong(),
        "total_scheduled_duration_ms",
            tm.totalScheduledDurationMs,
            nonNegLong()
            nonNegLong(),
            byte[] first = renderJsonBytes(stats);
    private Map<String, TaskMonitorStats> randomTaskMonitors() {
        builder.startObject();
            assertEquals(
    private Map<String, Object> asMap(Object value) {
    // ---- Property 2: toXContent round-trip preserves all field values ----
        for (int i = 0; i < TASK_FIELD_NAMES.length; i++) {
            rm.workersCount,
        builder.endObject();
            assertTrue(opType + " field '" + fieldName + "' must be present", monitorNode.containsKey(fieldName));
 * this file be licensed under the Apache-2.0 license or a
            nonNegLong()
            assertNotNull(ss);
            assertEquals(cs.getMetadataCache().hitCount, ((Number) metaNode.get("hit_count")).longValue());
            tm.instrumentedCount,
            new NativeExecutorsStats(randomRuntimeMetrics(), randomRuntimeMetricsWithPositiveWorkers(), randomTaskMonitors()),
            rm.totalPollsCount,
        builder.startObject();
    private CacheStats randomCacheStats() {
            nonNegLong(),
                ((Number) runtimeNode.get(fieldName)).longValue()
        );
            randomSearchStats()
import org.opensearch.core.xcontent.ToXContent;
        for (int i = 0; i < TRIES_NULL; i++) {
    @SuppressWarnings("unchecked")
import org.opensearch.test.OpenSearchTestCase;
            nonNegLong(),
}
 */
    private void verifyRuntimeFields(RuntimeMetrics rm, Map<String, Object> runtimeNode) {
            nonNegLong(),
    private long nonNegLong() {
import org.opensearch.common.xcontent.XContentFactory;
            assertNotNull("io_runtime must be present", ioRuntime);
    public void testToXContentRoundTripCpuPresent() throws IOException {
        );
        monitors.put("plan_setup", randomTaskMonitorStats());
            rm.spawnedTasksCount,
    }
            verifyRuntimeFields(nes.getIoRuntime(), ioRuntime);
            rm.numAliveTasks,
 * compatible open source license.
            // CPU runtime: 9 fields
            nonNegLong(),
    }
            nonNegLong(),
 * <p>Feature: ffm-stats-decode
            rm.totalBusyDurationMs,
            assertArrayEquals("toXContent must produce byte-for-byte identical JSON on repeated calls (null executors)", first, second);
    private RuntimeMetrics randomRuntimeMetrics() {
            byte[] first = renderJsonBytes(stats);
            assertNotNull(nes);
            DataFusionStats stats = randomDataFusionStatsCpuAbsent();
            nonNegLong(),
import org.opensearch.common.io.stream.BytesStreamOutput;
        "instrumented_count",
        }
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);
    private SearchStats randomSearchStats() {
import org.opensearch.common.xcontent.XContentHelper;
    private static final int TRIES_NULL = 100;
    private void verifyTaskMonitorFields(TaskMonitorStats tm, Map<String, Object> monitorNode, String opType) {
    }
            assertEquals("io_runtime must have exactly 9 fields", 9, ioRuntime.size());
 *
                ((Number) monitorNode.get(fieldName)).longValue()
            nonNegLong(),
            DataFusionStats original = randomDataFusionStatsCpuPresent();
        "total_overflow_count",
            byte[] second = renderJsonBytes(stats);
        }
        original.writeTo(out);
import org.opensearch.core.common.io.stream.StreamInput;
            Map<String, Object> ioRuntime = asMap(root.get("io_runtime"));
    @SuppressWarnings("unchecked")
            assertTrue("Runtime field '" + fieldName + "' must be present", runtimeNode.containsKey(fieldName));
                verifyTaskMonitorFields(nes.getTaskMonitors().get(opType.key()), monitor, opType.key());
    // ---- Property 3: toXContent determinism ----
 */
        }
            rm.blockingQueueDepth,
    /** JSON field names for TaskMonitorStats in documented order (5 fields). */
        "spawned_tasks_count",
            nonNegLong(),
            assertEquals(
        return (Map<String, Object>) value;
            CacheStats cs = stats.getCacheStats();
            null,
            nonNegLong(),
        monitors.put("query_execution", randomTaskMonitorStats());
            DataFusionStats deserialized = writeableRoundTrip(original);
    }
        for (int i = 0; i < TRIES; i++) {
        return monitors;
            // Cache stats
                assertNotNull(opType.key() + " must be present", monitor);
    }
            randomLongBetween(1, Long.MAX_VALUE / 2),
import java.util.LinkedHashMap;
            rm.totalOverflowCount,
            byte[] second = renderJsonBytes(stats);
            byte[] second = renderJsonBytes(stats);
    }
    }
    }
            // Task monitors: at top level, no task_monitors wrapper
        return new RuntimeMetrics(
                assertNotNull(opType.key() + " must be present", monitor);
            NativeExecutorsStats nes = stats.getNativeExecutorsStats();
        long[] expected = {
            assertFalse("cpu_runtime must be absent when cpuRuntime is null", root.containsKey("cpu_runtime"));
            DataFusionStats original = dataFusionStatsNullExecutors();
            tm.totalIdleDurationMs,
            nonNegLong(),
                opType + " field '" + fieldName + "': expected " + expected[i],
            nonNegLong(),
            Map<String, Object> cacheNode = asMap(root.get("cache_stats"));
    public void testToXContentDeterminismCpuPresent() throws IOException {
        for (int i = 0; i < TRIES_NULL; i++) {
        return BytesReference.toBytes(BytesReference.bytes(builder));
        return randomLongBetween(0, Long.MAX_VALUE / 2);
            tm.totalPollDurationMs,
        return new CacheStats(randomCacheGroupStats(), randomCacheGroupStats(), randomCacheGroupStats(), randomCacheGroupStats());
 * <p>Tests construct objects directly — no decode path, no ArrayCursor.
        Map<String, TaskMonitorStats> monitors = new LinkedHashMap<>();
            nonNegLong(),
    public void testWriteableRoundTripCpuPresent() throws IOException {
        for (int i = 0; i < RUNTIME_FIELD_NAMES.length; i++) {
            // Search stats
        "total_polls_count",
    }
        monitors.put("coordinator_reduce", randomTaskMonitorStats());
                Map<String, Object> monitor = asMap(root.get(opType.key()));
    }
 * Randomized tests for {@link DataFusionStats} constructed via direct constructors.
            assertArrayEquals("toXContent must produce byte-for-byte identical JSON on repeated calls (CPU present)", first, second);
import java.io.IOException;
        return new RuntimeMetrics(
        }
 *
    }
            assertEquals(ss.delegationCalls, ((Number) searchNode.get("delegation_calls")).longValue());
    }
        XContentBuilder builder = XContentFactory.jsonBuilder();
            assertEquals(ss.rgProcessed, ((Number) searchNode.get("rg_processed")).longValue());
            assertNotNull(statsNode);
            DataFusionStats stats = randomDataFusionStatsCpuAbsent();
            new PartitionGateStats("fragment_executor_gate", 12, 0, 0, 0, 0, 12, 0, 0),
            assertNotNull(nes);
            DataFusionStats stats = randomDataFusionStatsCpuPresent();
            nonNegLong(),
        return new SearchStats(
    }
            Map<String, Object> root = renderToMap(stats);
        "blocking_queue_depth",
        return new DataFusionStats(
import java.util.Map;
            );
        for (int i = 0; i < TRIES_NULL; i++) {
            NativeExecutorsStats nes = stats.getNativeExecutorsStats();
            nonNegLong(),
        BytesStreamOutput out = new BytesStreamOutput();
        long[] expected = {
        "num_alive_tasks",
    private DataFusionStats writeableRoundTrip(DataFusionStats original) throws IOException {
            DataFusionStats deserialized = writeableRoundTrip(original);
            nonNegLong(),
        }
            for (OperationType opType : OperationType.values()) {
            DataFusionStats stats = dataFusionStatsNullExecutors();
            String fieldName = TASK_FIELD_NAMES[i];
        for (int i = 0; i < TRIES; i++) {
            assertArrayEquals("toXContent must produce byte-for-byte identical JSON on repeated calls (CPU absent)", first, second);
            }
        }
            Map<String, Object> statsNode = asMap(cacheNode.get("statistics_cache"));
            new PartitionGateStats("fragment_executor_gate", 12, 0, 0, 0, 0, 12, 0, 0),
    }
                verifyTaskMonitorFields(nes.getTaskMonitors().get(opType.key()), monitor, opType.key());
            // Task monitors: 4 ops x 5 fields (at top level, no task_monitors wrapper)
            DataFusionStats deserialized = writeableRoundTrip(original);
            assertNotNull(cs);
        }
            nonNegLong(),
            nonNegLong(),
        );
            assertNotNull("search_stats must be present", searchNode);
            rm.totalLocalQueueDepth };
                assertEquals(5, monitor.size());
            Map<String, Object> root = renderToMap(stats);
            nonNegLong(),
    }
    }
        builder.endObject();
        return new DataFusionStats(
        for (int i = 0; i < TRIES_NULL; i++) {
            byte[] first = renderJsonBytes(stats);
            randomSearchStats()
            DataFusionStats stats = randomDataFusionStatsCpuPresent();
    }
            Map<String, Object> ioRuntime = asMap(root.get("io_runtime"));
        XContentBuilder builder = XContentFactory.jsonBuilder();
        "total_poll_duration_ms",
            }
                "Runtime field '" + fieldName + "': expected " + expected[i],
    }
            assertEquals(cs.getMetadataCache().missCount, ((Number) metaNode.get("miss_count")).longValue());
            tm.droppedCount };
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);
            String fieldName = RUNTIME_FIELD_NAMES[i];
    private DataFusionStats dataFusionStatsNullExecutors() {
            );
    public void testToXContentDeterminismNullExecutors() throws IOException {
        "dropped_count" };
    private static final String[] RUNTIME_FIELD_NAMES = {
 * SPDX-License-Identifier: Apache-2.0
        "total_local_queue_depth" };
            assertEquals("cpu_runtime must have exactly 9 fields", 9, cpuRuntime.size());
    }
    }
        }
        return new CacheGroupStats(nonNegLong(), nonNegLong(), nonNegLong(), nonNegLong(), nonNegLong());
        for (int i = 0; i < TRIES; i++) {
        monitors.put("stream_next", randomTaskMonitorStats());
            assertEquals("Writeable round-trip must preserve all fields (CPU present)", original, deserialized);
        "global_queue_depth",
        return new TaskMonitorStats(nonNegLong(), nonNegLong(), nonNegLong(), nonNegLong(), nonNegLong());
            Map<String, Object> searchNode = asMap(root.get("search_stats"));
            null,
import org.opensearch.be.datafusion.stats.NativeExecutorsStats.OperationType;
            new NativeExecutorsStats(randomRuntimeMetrics(), null, randomTaskMonitors()),
    private static final int TRIES = 200;
            nonNegLong(),
            assertTrue("cpu_runtime must be present", root.containsKey("cpu_runtime"));
            // CPU runtime absent
    public void testWriteableRoundTripCpuAbsent() throws IOException {
            assertEquals("io_runtime must have exactly 9 fields", 9, ioRuntime.size());
            nonNegLong(),
 *
            null,
