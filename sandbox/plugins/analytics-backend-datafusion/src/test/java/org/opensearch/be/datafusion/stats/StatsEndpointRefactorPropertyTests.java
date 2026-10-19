    }  
            verifyRuntimeFields(nes.getIoRuntime(), ioRuntime);
        Map<String, TaskMonitorStats> monitors = new LinkedHashMap<>();
        );
            nonNegLong(),  
 *
    }
        monitors.put("query_execution", randomTaskMonitorStats());  
    }  
                opType + " field '" + fieldName + "': expected " + expected[i],
                expected[i],
            assertFalse("native_executors wrapper must be absent", root.containsKey("native_executors"));
            rm.totalBusyDurationMs,
        return (Map<String, Object>) value;
 */  
    public void testFlatJsonSerializationPreservesAllMetricValues() throws IOException {
            rm.workersCount,  
        long[] expected = {
    private DataFusionStats randomDataFusionStats() {  
    private Map<String, Object> asMap(Object value) {  
/**
                ((Number) runtimeNode.get(fieldName)).longValue()  
import java.util.Map;
        }
                expected[i],
            for (OperationType opType : OperationType.values()) {  
}
            assertEquals(  
                verifyTaskMonitorFields(nes.getTaskMonitors().get(opType.key()), monitor, opType.key());  
        return new RuntimeMetrics(
        for (int i = 0; i < TASK_FIELD_NAMES.length; i++) {  
    }  
            nonNegLong(),
package org.opensearch.be.datafusion.stats;
            Map<String, Object> root = renderNativeExecutorsToMap(nes);
    public void testCpuRuntimeAbsentWhenNull() throws IOException {
/*  
            rm.blockingQueueDepth,
public class StatsEndpointRefactorPropertyTests extends OpenSearchTestCase {  
        long[] expected = {  
            tm.totalIdleDurationMs,  
            nonNegLong()
            DataFusionStats original = randomDataFusionStats();  
    }
        "spawned_tasks_count",
            Map<String, Object> ioRuntime = asMap(root.get("io_runtime"));
            nonNegLong(),  
    private TaskMonitorStats randomTaskMonitorStats() {
    @SuppressWarnings("unchecked")
            verifyRuntimeFields(nes.getCpuRuntime(), cpuRuntime);
            DataFusionStats deserialized = new DataFusionStats(in);
    /** JSON field names for TaskMonitorStats in documented order (5 fields). */
 * SPDX-License-Identifier: Apache-2.0
    public void testFlatJsonSerializationPreservesAllMetricValuesCpuAbsent() throws IOException {
            // Verify native_executors and task_monitors wrappers are absent
        monitors.put("stream_next", randomTaskMonitorStats());
        }  
        "total_poll_duration_ms",  
 * this file be licensed under the Apache-2.0 license or a
        return monitors;  
 *  
    }  
    // ---- Helper methods ----  
            assertFalse("task_monitors wrapper must be absent", root.containsKey("task_monitors"));
    @SuppressWarnings("unchecked")
        }
            assertFalse("native_executors wrapper must be absent", root.containsKey("native_executors"));
    }
            nonNegLong(),
    }  
import org.opensearch.common.xcontent.XContentFactory;  
        builder.endObject();
        "workers_count",  
    private static final String[] TASK_FIELD_NAMES = {
            rm.spawnedTasksCount,
        );
import org.opensearch.test.OpenSearchTestCase;
            for (OperationType opType : OperationType.values()) {
 *  
            randomLongBetween(1, Long.MAX_VALUE / 2),
        XContentBuilder builder = XContentFactory.jsonBuilder();
            original.writeTo(out);
            // Verify io_runtime is a top-level key with all 9 fields
            nonNegLong(),
        }
    private Map<String, Object> renderNativeExecutorsToMap(NativeExecutorsStats nes) throws IOException {  
            rm.totalOverflowCount,  
        "dropped_count" };
            }
            NativeExecutorsStats nes = randomNativeExecutorsStatsCpuPresent();
import org.opensearch.core.xcontent.XContentBuilder;  
            Map<String, Object> root = renderNativeExecutorsToMap(nes);
    private void verifyTaskMonitorFields(TaskMonitorStats tm, Map<String, Object> monitorNode, String opType) {
    /** DataFusionStats with non-null NativeExecutorsStats (CPU present or absent). */
            tm.totalPollDurationMs,
            Map<String, Object> root = renderNativeExecutorsToMap(nes);  
            assertTrue("cpu_runtime must be present when cpuRuntime is non-null", root.containsKey("cpu_runtime"));
        builder.startObject();
                verifyTaskMonitorFields(nes.getTaskMonitors().get(opType.key()), monitor, opType.key());
        "num_alive_tasks",  
                assertNotNull(opType.key() + " must be present at top level", monitor);
    public void testCpuRuntimePresentWhenNonNull() throws IOException {  
import org.opensearch.common.xcontent.XContentType;
        "total_scheduled_duration_ms",
            assertFalse("cpu_runtime must be absent when null", root.containsKey("cpu_runtime"));
            String fieldName = RUNTIME_FIELD_NAMES[i];
                ((Number) monitorNode.get(fieldName)).longValue()  
        "total_polls_count",
            StreamInput in = out.bytes().streamInput();  
        return new TaskMonitorStats(nonNegLong(), nonNegLong(), nonNegLong(), nonNegLong(), nonNegLong());  
            NativeExecutorsStats nes = randomNativeExecutorsStatsCpuAbsent();
            NativeExecutorsStats nes = randomNativeExecutorsStatsCpuPresent();  
            // Verify io_runtime is a top-level key with all 9 fields
            tm.totalScheduledDurationMs,
    // ---- Property 1: Flat JSON serialization preserves all metric values at top level ----
        NativeExecutorsStats nes = randomBoolean() ? randomNativeExecutorsStatsCpuPresent() : randomNativeExecutorsStatsCpuAbsent();
            // cpu_runtime absent
            // Verify cpu_runtime is a top-level key with all 9 fields (present case)  
        monitors.put("plan_setup", randomTaskMonitorStats());
        "global_queue_depth",
            );
    /** RuntimeMetrics with workersCount &gt; 0, marking the CPU runtime as present. */
            nonNegLong(),
 * The OpenSearch Contributors require contributions made to  
        "total_local_queue_depth" };
            Map<String, Object> cpuRuntime = asMap(root.get("cpu_runtime"));  
        "total_idle_duration_ms",
                Map<String, Object> monitor = asMap(root.get(opType.key()));  
        return new RuntimeMetrics(
import org.opensearch.be.datafusion.stats.NativeExecutorsStats.OperationType;
            Map<String, Object> ioRuntime = asMap(root.get("io_runtime"));  
    private RuntimeMetrics randomRuntimeMetrics() {  
            assertTrue(opType + " field '" + fieldName + "' must be present", monitorNode.containsKey(fieldName));
            nonNegLong(),  
            assertEquals("Transport round-trip must preserve all fields", original, deserialized);
 * <p>Validates that the flattened JSON serialization preserves all metric values,
 * compatible open source license.
    public void testTransportSerializationRoundTrip() throws IOException {
            assertNotNull("cpu_runtime must be present at top level when non-null", cpuRuntime);
                Map<String, Object> monitor = asMap(root.get(opType.key()));
        nes.toXContent(builder, ToXContent.EMPTY_PARAMS);  
        "total_busy_duration_ms",
    private NativeExecutorsStats randomNativeExecutorsStatsCpuAbsent() {
            );
            verifyRuntimeFields(nes.getCpuRuntime(), cpuRuntime);  
        return new NativeExecutorsStats(randomRuntimeMetrics(), randomRuntimeMetricsWithPositiveWorkers(), randomTaskMonitors());
            rm.totalLocalQueueDepth };
            assertNotNull("io_runtime must be present at top level", ioRuntime);
            rm.totalPollsCount,
            }  
    }
            NativeExecutorsStats nes = randomNativeExecutorsStatsCpuAbsent();
            // Verify native_executors and task_monitors wrappers are absent  
        "instrumented_count",  
    }  
    private NativeExecutorsStats randomNativeExecutorsStatsCpuPresent() {  
    }  
    }  
            // Verify each task monitor is a top-level key with correct fields
            verifyRuntimeFields(nes.getIoRuntime(), ioRuntime);
            rm.numAliveTasks,  
        for (int i = 0; i < RUNTIME_FIELD_NAMES.length; i++) {  
            nonNegLong(),
        for (int i = 0; i < TRIES; i++) {  
            assertFalse("task_monitors wrapper must be absent", root.containsKey("task_monitors"));  
    // ---- Object generators ----  
    private static final String[] RUNTIME_FIELD_NAMES = {
    private long nonNegLong() {
            tm.instrumentedCount,
            nonNegLong(),
        for (int i = 0; i < TRIES; i++) {
        return new NativeExecutorsStats(randomRuntimeMetrics(), null, randomTaskMonitors());
        monitors.put("coordinator_reduce", randomTaskMonitorStats());
                assertNotNull(opType.key() + " must be present at top level", monitor);
import org.opensearch.core.common.io.stream.StreamInput;
            nonNegLong(),  
            nonNegLong(),
            nonNegLong(),
    }
            String fieldName = TASK_FIELD_NAMES[i];
            // Verify each task monitor is a top-level key with correct fields
    }
    // ---- Property 2: CPU runtime conditional presence ----
    private void verifyRuntimeFields(RuntimeMetrics rm, Map<String, Object> runtimeNode) {
        }
        }
        "total_overflow_count",  
import org.opensearch.core.xcontent.ToXContent;
import org.opensearch.core.common.bytes.BytesReference;  
    /** JSON field names for RuntimeMetrics in documented order (9 fields). */
    private Map<String, TaskMonitorStats> randomTaskMonitors() {  
        for (int i = 0; i < TRIES; i++) {
    // ---- Property 3: Transport serialization round-trip ----
    private static final int TRIES = 200;
            assertFalse("cpu_runtime must be absent when cpuRuntime is null", root.containsKey("cpu_runtime"));
            nonNegLong(),  
            assertTrue("Runtime field '" + fieldName + "' must be present", runtimeNode.containsKey(fieldName));
 * CPU runtime conditional presence, and transport round-trip correctness.
        return XContentHelper.convertToMap(BytesReference.bytes(builder), false, XContentType.JSON).v2();
 * Randomized tests for the stats-endpoint-refactor spec.
    }  
import java.io.IOException;  
                "Runtime field '" + fieldName + "': expected " + expected[i],
        return new DataFusionStats(nes, new PartitionGateStats("fragment_executor_gate", 12, 0, 0, 0, 0, 12, 0, 0), null, null);
import org.opensearch.common.io.stream.BytesStreamOutput;
            assertEquals(  
            Map<String, Object> cpuRuntime = asMap(root.get("cpu_runtime"));
    private RuntimeMetrics randomRuntimeMetricsWithPositiveWorkers() {  
        for (int i = 0; i < TRIES; i++) {
import org.opensearch.common.xcontent.XContentHelper;
        for (int i = 0; i < TRIES; i++) {  
    }
 */
    }  
            nonNegLong(),
import java.util.LinkedHashMap;
 * <p>Feature: stats-endpoint-refactor
            nonNegLong(),  
            nonNegLong()
            rm.globalQueueDepth,
        return randomLongBetween(0, Long.MAX_VALUE / 2);  
        "blocking_queue_depth",
            Map<String, Object> root = renderNativeExecutorsToMap(nes);
            tm.droppedCount };
        }
            assertNotNull("io_runtime must be present at top level", ioRuntime);  
            BytesStreamOutput out = new BytesStreamOutput();
