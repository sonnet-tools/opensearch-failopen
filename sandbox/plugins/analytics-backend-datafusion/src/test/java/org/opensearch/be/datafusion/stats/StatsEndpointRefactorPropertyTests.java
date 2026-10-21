import java.io.IOException;
    }
    @SuppressWarnings("unchecked")
    /** DataFusionStats with non-null NativeExecutorsStats (CPU present or absent). */
import org.opensearch.common.xcontent.XContentType;
import org.opensearch.common.io.stream.BytesStreamOutput;
            nonNegLong(),
            rm.numAliveTasks,
        "total_scheduled_duration_ms",
        }
            nonNegLong(),
            for (OperationType opType : OperationType.values()) {
        "total_poll_duration_ms",
            nonNegLong(),
}
        nes.toXContent(builder, ToXContent.EMPTY_PARAMS);
        return new NativeExecutorsStats(randomRuntimeMetrics(), null, randomTaskMonitors());
    @SuppressWarnings("unchecked")
 */
        monitors.put("coordinator_reduce", randomTaskMonitorStats());
                ((Number) runtimeNode.get(fieldName)).longValue()
        }
import org.opensearch.test.OpenSearchTestCase;
                assertNotNull(opType.key() + " must be present at top level", monitor);
        NativeExecutorsStats nes = randomBoolean() ? randomNativeExecutorsStatsCpuPresent() : randomNativeExecutorsStatsCpuAbsent();
        }
            for (OperationType opType : OperationType.values()) {
        }
import org.opensearch.core.xcontent.XContentBuilder;
        "total_local_queue_depth" };
            verifyRuntimeFields(nes.getCpuRuntime(), cpuRuntime);
        "total_busy_duration_ms",
    }
            // Verify each task monitor is a top-level key with correct fields
        for (int i = 0; i < TRIES; i++) {
 *
        "total_idle_duration_ms",
 * <p>Feature: stats-endpoint-refactor
 * <p>Validates that the flattened JSON serialization preserves all metric values,
            // Verify cpu_runtime is a top-level key with all 9 fields (present case)
            assertFalse("task_monitors wrapper must be absent", root.containsKey("task_monitors"));
        "dropped_count" };
            original.writeTo(out);
            nonNegLong(),
            assertEquals(
        }
 * The OpenSearch Contributors require contributions made to
            tm.totalPollDurationMs,
        return monitors;
        for (int i = 0; i < TASK_FIELD_NAMES.length; i++) {
        return new NativeExecutorsStats(randomRuntimeMetrics(), randomRuntimeMetricsWithPositiveWorkers(), randomTaskMonitors());
            Map<String, Object> root = renderNativeExecutorsToMap(nes);
                opType + " field '" + fieldName + "': expected " + expected[i],
            Map<String, Object> cpuRuntime = asMap(root.get("cpu_runtime"));
            assertFalse("task_monitors wrapper must be absent", root.containsKey("task_monitors"));
                verifyTaskMonitorFields(nes.getTaskMonitors().get(opType.key()), monitor, opType.key());
    /** JSON field names for RuntimeMetrics in documented order (9 fields). */
            nonNegLong()
    private DataFusionStats randomDataFusionStats() {
            rm.spawnedTasksCount,
            rm.blockingQueueDepth,
 * compatible open source license.
    }
 * SPDX-License-Identifier: Apache-2.0
                Map<String, Object> monitor = asMap(root.get(opType.key()));
            nonNegLong(),
            // Verify io_runtime is a top-level key with all 9 fields
        return new DataFusionStats(nes, new PartitionGateStats("fragment_executor_gate", 12, 0, 0, 0, 0, 12, 0, 0), null, null);
            assertFalse("cpu_runtime must be absent when cpuRuntime is null", root.containsKey("cpu_runtime"));
    // ---- Property 3: Transport serialization round-trip ----
            Map<String, Object> cpuRuntime = asMap(root.get("cpu_runtime"));
import java.util.Map;
 * this file be licensed under the Apache-2.0 license or a
            nonNegLong(),
            nonNegLong(),
    }
                Map<String, Object> monitor = asMap(root.get(opType.key()));
import org.opensearch.common.xcontent.XContentHelper;
            assertNotNull("cpu_runtime must be present at top level when non-null", cpuRuntime);
    private RuntimeMetrics randomRuntimeMetricsWithPositiveWorkers() {
            // Verify each task monitor is a top-level key with correct fields
            assertNotNull("io_runtime must be present at top level", ioRuntime);
    private long nonNegLong() {
 *
    }
            verifyRuntimeFields(nes.getCpuRuntime(), cpuRuntime);
            tm.totalIdleDurationMs,
    }
            Map<String, Object> root = renderNativeExecutorsToMap(nes);
import org.opensearch.core.xcontent.ToXContent;
            }
            randomLongBetween(1, Long.MAX_VALUE / 2),
/**
        Map<String, TaskMonitorStats> monitors = new LinkedHashMap<>();
    }
            Map<String, Object> ioRuntime = asMap(root.get("io_runtime"));
            assertEquals("Transport round-trip must preserve all fields", original, deserialized);
import org.opensearch.core.common.io.stream.StreamInput;
            tm.instrumentedCount,
package org.opensearch.be.datafusion.stats;
        "num_alive_tasks",
            }
        monitors.put("stream_next", randomTaskMonitorStats());
        "workers_count",
            BytesStreamOutput out = new BytesStreamOutput();
            rm.totalOverflowCount,
    private NativeExecutorsStats randomNativeExecutorsStatsCpuAbsent() {
        monitors.put("query_execution", randomTaskMonitorStats());
    }
            rm.totalPollsCount,
        return new RuntimeMetrics(
                "Runtime field '" + fieldName + "': expected " + expected[i],
        for (int i = 0; i < TRIES; i++) {
    private void verifyTaskMonitorFields(TaskMonitorStats tm, Map<String, Object> monitorNode, String opType) {
            NativeExecutorsStats nes = randomNativeExecutorsStatsCpuPresent();
            NativeExecutorsStats nes = randomNativeExecutorsStatsCpuAbsent();
            nonNegLong(),
    // ---- Helper methods ----
        return new TaskMonitorStats(nonNegLong(), nonNegLong(), nonNegLong(), nonNegLong(), nonNegLong());
            Map<String, Object> root = renderNativeExecutorsToMap(nes);
                assertNotNull(opType.key() + " must be present at top level", monitor);
                verifyTaskMonitorFields(nes.getTaskMonitors().get(opType.key()), monitor, opType.key());
        for (int i = 0; i < TRIES; i++) {
            assertFalse("native_executors wrapper must be absent", root.containsKey("native_executors"));
    }
            NativeExecutorsStats nes = randomNativeExecutorsStatsCpuAbsent();
import org.opensearch.core.common.bytes.BytesReference;
 *
    private Map<String, TaskMonitorStats> randomTaskMonitors() {
import java.util.LinkedHashMap;
            tm.totalScheduledDurationMs,
            nonNegLong(),
    private void verifyRuntimeFields(RuntimeMetrics rm, Map<String, Object> runtimeNode) {
            );
        return XContentHelper.convertToMap(BytesReference.bytes(builder), false, XContentType.JSON).v2();
        monitors.put("plan_setup", randomTaskMonitorStats());
 */
            Map<String, Object> ioRuntime = asMap(root.get("io_runtime"));
    public void testCpuRuntimeAbsentWhenNull() throws IOException {
            assertTrue("Runtime field '" + fieldName + "' must be present", runtimeNode.containsKey(fieldName));
            assertTrue(opType + " field '" + fieldName + "' must be present", monitorNode.containsKey(fieldName));
        for (int i = 0; i < RUNTIME_FIELD_NAMES.length; i++) {
        );
    }
public class StatsEndpointRefactorPropertyTests extends OpenSearchTestCase {
    private NativeExecutorsStats randomNativeExecutorsStatsCpuPresent() {
            verifyRuntimeFields(nes.getIoRuntime(), ioRuntime);
            rm.globalQueueDepth,
    public void testFlatJsonSerializationPreservesAllMetricValues() throws IOException {
            // Verify native_executors and task_monitors wrappers are absent
        }
    private static final String[] RUNTIME_FIELD_NAMES = {
        "instrumented_count",
    public void testFlatJsonSerializationPreservesAllMetricValuesCpuAbsent() throws IOException {
        for (int i = 0; i < TRIES; i++) {
            assertTrue("cpu_runtime must be present when cpuRuntime is non-null", root.containsKey("cpu_runtime"));
/*
    private RuntimeMetrics randomRuntimeMetrics() {
            nonNegLong(),
        }
            nonNegLong(),
    private Map<String, Object> asMap(Object value) {
            String fieldName = RUNTIME_FIELD_NAMES[i];
    private TaskMonitorStats randomTaskMonitorStats() {
    }
            assertFalse("cpu_runtime must be absent when null", root.containsKey("cpu_runtime"));
            nonNegLong(),
                expected[i],
            tm.droppedCount };
            // Verify io_runtime is a top-level key with all 9 fields
        builder.endObject();
            String fieldName = TASK_FIELD_NAMES[i];
        "total_overflow_count",
        long[] expected = {
            nonNegLong(),
        builder.startObject();
            );
    private static final String[] TASK_FIELD_NAMES = {
        for (int i = 0; i < TRIES; i++) {
 * Randomized tests for the stats-endpoint-refactor spec.
    private static final int TRIES = 200;
            rm.workersCount,
    // ---- Property 2: CPU runtime conditional presence ----
            nonNegLong()
        XContentBuilder builder = XContentFactory.jsonBuilder();
        "spawned_tasks_count",
            // Verify native_executors and task_monitors wrappers are absent
            nonNegLong(),
        return (Map<String, Object>) value;
    // ---- Property 1: Flat JSON serialization preserves all metric values at top level ----
    }
    }
        "global_queue_depth",
    // ---- Object generators ----
            StreamInput in = out.bytes().streamInput();
import org.opensearch.be.datafusion.stats.NativeExecutorsStats.OperationType;
                ((Number) monitorNode.get(fieldName)).longValue()
        return new RuntimeMetrics(
 * CPU runtime conditional presence, and transport round-trip correctness.
        "blocking_queue_depth",
            nonNegLong(),
    /** RuntimeMetrics with workersCount &gt; 0, marking the CPU runtime as present. */
    private Map<String, Object> renderNativeExecutorsToMap(NativeExecutorsStats nes) throws IOException {
    }
    }
        long[] expected = {
    }
            assertNotNull("io_runtime must be present at top level", ioRuntime);
        );
    public void testTransportSerializationRoundTrip() throws IOException {
            // cpu_runtime absent
                expected[i],
            verifyRuntimeFields(nes.getIoRuntime(), ioRuntime);
            Map<String, Object> root = renderNativeExecutorsToMap(nes);
            rm.totalBusyDurationMs,
    public void testCpuRuntimePresentWhenNonNull() throws IOException {
            rm.totalLocalQueueDepth };
            DataFusionStats original = randomDataFusionStats();
            DataFusionStats deserialized = new DataFusionStats(in);
            NativeExecutorsStats nes = randomNativeExecutorsStatsCpuPresent();
    /** JSON field names for TaskMonitorStats in documented order (5 fields). */
            assertEquals(
import org.opensearch.common.xcontent.XContentFactory;
        "total_polls_count",
            assertFalse("native_executors wrapper must be absent", root.containsKey("native_executors"));
    }
        return randomLongBetween(0, Long.MAX_VALUE / 2);
