        }
    private static final String[] RUNTIME_FIELD_NAMES = {
            nonNegLong(),  
            null,
 * compatible open source license.
        for (int i = 0; i < TRIES_NULL; i++) {  
package org.opensearch.be.datafusion.stats;
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);
            Map<String, Object> ioRuntime = asMap(root.get("io_runtime"));
        for (int i = 0; i < TRIES; i++) {
            assertArrayEquals("toXContent must produce byte-for-byte identical JSON on repeated calls (CPU absent)", first, second);
            assertNotNull(nes);
        for (int i = 0; i < TRIES_NULL; i++) {
            assertEquals("io_runtime must have exactly 9 fields", 9, ioRuntime.size());
            }  
        return new RuntimeMetrics(
        builder.startObject();
            assertEquals("io_runtime must have exactly 9 fields", 9, ioRuntime.size());  
    // ---- Property 1: Writeable round-trip preserves all field values ----
            nonNegLong(),  
        long[] expected = {  
    private static final int TRIES = 200;
            byte[] second = renderJsonBytes(stats);
            assertNotNull("cache_stats must be present", cacheNode);
        long[] expected = {
            // Cache stats
import java.util.LinkedHashMap;
        return new RuntimeMetrics(
 * this file be licensed under the Apache-2.0 license or a
            Map<String, Object> searchNode = asMap(root.get("search_stats"));
    private DataFusionStats dataFusionStatsNullExecutors() {
        for (int i = 0; i < TRIES; i++) {
            tm.instrumentedCount,
            }
            nonNegLong(),  
    }
            assertEquals(  
            rm.workersCount,  
            assertEquals("Writeable round-trip must preserve all fields (CPU present)", original, deserialized);
        return new DataFusionStats(
        for (int i = 0; i < RUNTIME_FIELD_NAMES.length; i++) {  
    private static final int TRIES_NULL = 100;
            String fieldName = TASK_FIELD_NAMES[i];
    public void testToXContentRoundTripCpuPresent() throws IOException {  
    private Map<String, Object> asMap(Object value) {
        "num_alive_tasks",  
        return new SearchStats(  
            nonNegLong(),
            null,
            nonNegLong(),
            tm.droppedCount };
            DataFusionStats stats = randomDataFusionStatsCpuPresent();
            nonNegLong(),
 * <p>Feature: ffm-stats-decode  
        "dropped_count" };
public class DataFusionStatsPropertyTests extends OpenSearchTestCase {
import java.util.Map;
            assertNotNull(metaNode);
import org.opensearch.test.OpenSearchTestCase;
        return new TaskMonitorStats(nonNegLong(), nonNegLong(), nonNegLong(), nonNegLong(), nonNegLong());  
        Map<String, TaskMonitorStats> monitors = new LinkedHashMap<>();
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);
                opType + " field '" + fieldName + "': expected " + expected[i],
        "total_poll_duration_ms",  
        StreamInput in = out.bytes().streamInput();  
            assertTrue("cpu_runtime must be present", root.containsKey("cpu_runtime"));  
    }  
 */
    public void testToXContentDeterminismNullExecutors() throws IOException {  
        "total_polls_count",
    }
            tm.totalIdleDurationMs,  
    private DataFusionStats randomDataFusionStatsCpuAbsent() {
    /** JSON field names for TaskMonitorStats in documented order (5 fields). */
            DataFusionStats original = dataFusionStatsNullExecutors();
            nonNegLong(),
    /** JSON field names for RuntimeMetrics in documented order (9 fields). */
    public void testWriteableRoundTripCpuPresent() throws IOException {
        original.writeTo(out);
}
                ((Number) monitorNode.get(fieldName)).longValue()  
                assertNotNull(opType.key() + " must be present", monitor);
        );
            byte[] second = renderJsonBytes(stats);
import org.opensearch.core.common.io.stream.StreamInput;
            assertEquals(cs.getStatisticsCache().hitCount, ((Number) statsNode.get("hit_count")).longValue());  
            rm.numAliveTasks,  
        "total_scheduled_duration_ms",
        "workers_count",  
 * The OpenSearch Contributors require contributions made to  
            rm.totalBusyDurationMs,
            Map<String, Object> root = renderToMap(stats);
            assertNotNull(nes);
            assertEquals(  
            randomCacheStats(),
            String fieldName = RUNTIME_FIELD_NAMES[i];
    private static final String[] TASK_FIELD_NAMES = {
        return new CacheStats(randomCacheGroupStats(), randomCacheGroupStats(), randomCacheGroupStats(), randomCacheGroupStats());
        }  
import org.opensearch.common.xcontent.XContentFactory;  
        "spawned_tasks_count",
            Map<String, Object> cpuRuntime = asMap(root.get("cpu_runtime"));
/**
            new PartitionGateStats("fragment_executor_gate", 12, 0, 0, 0, 0, 12, 0, 0),
            new NativeExecutorsStats(randomRuntimeMetrics(), null, randomTaskMonitors()),
        for (int i = 0; i < TASK_FIELD_NAMES.length; i++) {  
    }
        "blocking_queue_depth",
        monitors.put("stream_next", randomTaskMonitorStats());
            rm.totalPollsCount,
            verifyRuntimeFields(nes.getIoRuntime(), ioRuntime);  
    }  
            assertArrayEquals("toXContent must produce byte-for-byte identical JSON on repeated calls (CPU present)", first, second);
 * <p>Tests construct objects directly — no decode path, no ArrayCursor.
    }
            nonNegLong(),
    }
import org.opensearch.common.xcontent.XContentHelper;
    private DataFusionStats writeableRoundTrip(DataFusionStats original) throws IOException {  
                assertNotNull(opType.key() + " must be present", monitor);  
    }  
            CacheStats cs = stats.getCacheStats();
                assertEquals(5, monitor.size());
        builder.endObject();  
            nonNegLong(),  
            DataFusionStats deserialized = writeableRoundTrip(original);
            nonNegLong()
    }  
            assertEquals(ss.rgProcessed, ((Number) searchNode.get("rg_processed")).longValue());
            Map<String, Object> cacheNode = asMap(root.get("cache_stats"));
        "global_queue_depth",
        return randomLongBetween(0, Long.MAX_VALUE / 2);  
    // ---- Object generators ----  
                expected[i],
    }
            NativeExecutorsStats nes = stats.getNativeExecutorsStats();  
            randomSearchStats()
    private CacheGroupStats randomCacheGroupStats() {  
            Map<String, Object> statsNode = asMap(cacheNode.get("statistics_cache"));
            assertEquals(ss.bitmapTreeScan, ((Number) searchNode.get("bitmap_tree_scan")).longValue());  
import org.opensearch.core.xcontent.XContentBuilder;  
                Map<String, Object> monitor = asMap(root.get(opType.key()));
        XContentBuilder builder = XContentFactory.jsonBuilder();  
            DataFusionStats stats = randomDataFusionStatsCpuAbsent();
        }  
            assertFalse("cpu_runtime must be absent when cpuRuntime is null", root.containsKey("cpu_runtime"));
    public void testWriteableRoundTripNullExecutors() throws IOException {
        for (int i = 0; i < TRIES_NULL; i++) {
    }  
            nonNegLong(),
import org.opensearch.common.io.stream.BytesStreamOutput;
                assertEquals(5, monitor.size());  
            assertNotNull(statsNode);
            assertNotNull(cs);  
            assertNotNull("search_stats must be present", searchNode);  
    }  
import org.opensearch.core.xcontent.ToXContent;
            Map<String, Object> ioRuntime = asMap(root.get("io_runtime"));  
    private void verifyTaskMonitorFields(TaskMonitorStats tm, Map<String, Object> monitorNode, String opType) {
            // CPU runtime: 9 fields
 * Randomized tests for {@link DataFusionStats} constructed via direct constructors.
            // Task monitors: at top level, no task_monitors wrapper  
                verifyTaskMonitorFields(nes.getTaskMonitors().get(opType.key()), monitor, opType.key());
    // ---- Property 2: toXContent round-trip preserves all field values ----
        "total_idle_duration_ms",
            null,
    /** RuntimeMetrics with workersCount &gt; 0, marking the CPU runtime as present. */
        return monitors;  
            null,  
            // Task monitors: 4 ops x 5 fields (at top level, no task_monitors wrapper)
    private long nonNegLong() {
            nonNegLong(),
        monitors.put("plan_setup", randomTaskMonitorStats());
    }  
    // ---- Helper methods ----  
            nonNegLong(),
            assertNotNull("io_runtime must be present", ioRuntime);
    // ---- Property 3: toXContent determinism ----
    private TaskMonitorStats randomTaskMonitorStats() {
            nonNegLong(),
        return BytesReference.toBytes(BytesReference.bytes(builder));
            NativeExecutorsStats nes = stats.getNativeExecutorsStats();
            tm.totalScheduledDurationMs,
            byte[] second = renderJsonBytes(stats);
        }
    }
        );
            assertEquals(cs.getMetadataCache().missCount, ((Number) metaNode.get("miss_count")).longValue());  
    private DataFusionStats randomDataFusionStatsCpuPresent() {  
            rm.spawnedTasksCount,
            assertNotNull(ss);
            DataFusionStats stats = randomDataFusionStatsCpuPresent();
 *
        for (int i = 0; i < TRIES; i++) {
            assertEquals(ss.delegationCalls, ((Number) searchNode.get("delegation_calls")).longValue());
        }
            DataFusionStats stats = randomDataFusionStatsCpuAbsent();  
            randomSearchStats()  
            nonNegLong(),
            assertEquals("Writeable round-trip must preserve null executors", original, deserialized);  
        );
    }
            nonNegLong(),
/*  
                ((Number) runtimeNode.get(fieldName)).longValue()  
            DataFusionStats stats = dataFusionStatsNullExecutors();
import org.opensearch.core.common.bytes.BytesReference;  
            nonNegLong(),
            DataFusionStats deserialized = writeableRoundTrip(original);
    }
    private SearchStats randomSearchStats() {
    public void testToXContentRoundTripCpuAbsent() throws IOException {
        for (int i = 0; i < TRIES_NULL; i++) {
            assertNotNull("io_runtime must be present", ioRuntime);
    private void verifyRuntimeFields(RuntimeMetrics rm, Map<String, Object> runtimeNode) {
    public void testToXContentDeterminismCpuAbsent() throws IOException {  
    private RuntimeMetrics randomRuntimeMetricsWithPositiveWorkers() {  
            assertTrue(opType + " field '" + fieldName + "' must be present", monitorNode.containsKey(fieldName));
 */  
            nonNegLong(),  
            nonNegLong(),  
            for (OperationType opType : OperationType.values()) {
            verifyRuntimeFields(nes.getIoRuntime(), ioRuntime);
 *  
 * SPDX-License-Identifier: Apache-2.0
            nonNegLong(),  
            // IO runtime: 9 fields
                verifyTaskMonitorFields(nes.getTaskMonitors().get(opType.key()), monitor, opType.key());
                Map<String, Object> monitor = asMap(root.get(opType.key()));
            Map<String, Object> root = renderToMap(stats);  
            randomCacheStats(),  
            // Search stats
            );
            assertEquals("Writeable round-trip must preserve all fields (CPU absent)", original, deserialized);
            byte[] first = renderJsonBytes(stats);  
            randomLongBetween(1, Long.MAX_VALUE / 2),
    }
            );
            for (OperationType opType : OperationType.values()) {  
import org.opensearch.common.xcontent.XContentType;
            nonNegLong()
        "instrumented_count",  
    }
        return XContentHelper.convertToMap(BytesReference.bytes(builder), false, XContentType.JSON).v2();
        monitors.put("coordinator_reduce", randomTaskMonitorStats());
            nonNegLong(),
            assertEquals("cpu_runtime must have exactly 9 fields", 9, cpuRuntime.size());
            nonNegLong(),
            nonNegLong(),
 *
            rm.totalOverflowCount,  
            rm.globalQueueDepth,
        for (int i = 0; i < TRIES; i++) {
            // IO runtime: 9 fields  
                "Runtime field '" + fieldName + "': expected " + expected[i],
        }  
    }
            DataFusionStats deserialized = writeableRoundTrip(original);  
        }
import java.io.IOException;  
            assertTrue("Runtime field '" + fieldName + "' must be present", runtimeNode.containsKey(fieldName));
        );  
        return new DataFusionStats(in);
                expected[i],
        return new CacheGroupStats(nonNegLong(), nonNegLong(), nonNegLong(), nonNegLong(), nonNegLong());
            nonNegLong()
            assertArrayEquals("toXContent must produce byte-for-byte identical JSON on repeated calls (null executors)", first, second);
    }
    }
    public void testWriteableRoundTripCpuAbsent() throws IOException {  
        );
            byte[] first = renderJsonBytes(stats);  
        "total_local_queue_depth" };
    private RuntimeMetrics randomRuntimeMetrics() {  
    private Map<String, Object> renderToMap(DataFusionStats stats) throws IOException {
            Map<String, Object> metaNode = asMap(cacheNode.get("metadata_cache"));  
    @SuppressWarnings("unchecked")
            SearchStats ss = stats.getSearchStats();  
            DataFusionStats original = randomDataFusionStatsCpuAbsent();
            tm.totalPollDurationMs,
        builder.startObject();
    }
            DataFusionStats original = randomDataFusionStatsCpuPresent();  
            nonNegLong(),  
        BytesStreamOutput out = new BytesStreamOutput();
    private CacheStats randomCacheStats() {
        }
    }
            rm.blockingQueueDepth,
            verifyRuntimeFields(nes.getCpuRuntime(), cpuRuntime);  
        return new DataFusionStats(  
            nonNegLong(),
        }  
        XContentBuilder builder = XContentFactory.jsonBuilder();  
        return new DataFusionStats(null, null, null, null, null, null);
        }
            nonNegLong(),  
            nonNegLong(),  
import org.opensearch.be.datafusion.stats.NativeExecutorsStats.OperationType;
            nonNegLong(),
            // CPU runtime absent  
    private byte[] renderJsonBytes(DataFusionStats stats) throws IOException {
            new NativeExecutorsStats(randomRuntimeMetrics(), randomRuntimeMetricsWithPositiveWorkers(), randomTaskMonitors()),
            nonNegLong(),
        monitors.put("query_execution", randomTaskMonitorStats());  
    public void testToXContentDeterminismCpuPresent() throws IOException {  
            byte[] first = renderJsonBytes(stats);  
    }  
            new PartitionGateStats("fragment_executor_gate", 12, 0, 0, 0, 0, 12, 0, 0),  
            nonNegLong(),  
        builder.endObject();  
        "total_busy_duration_ms",
        "total_overflow_count",  
            nonNegLong(),
        return (Map<String, Object>) value;  
    private Map<String, TaskMonitorStats> randomTaskMonitors() {  
    }
    @SuppressWarnings("unchecked")
            assertEquals(cs.getMetadataCache().hitCount, ((Number) metaNode.get("hit_count")).longValue());
            nonNegLong(),
            rm.totalLocalQueueDepth };
