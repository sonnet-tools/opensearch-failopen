            assertEquals("Full NativeExecutorsStats round-trip must produce equal object", original, deserialized);
            assertRuntimeMetricsEqual(original.getIoRuntime(), deserialized.getIoRuntime(), "io_runtime");  
    // ---- Helpers ----
 *  
    // ---- Writeable round-trip preserves all fields ----
        return new NativeExecutorsStats(randomRuntimeMetrics(), null, randomTaskMonitors());
        assertEquals(label + ".global_queue_depth", expected.globalQueueDepth, actual.globalQueueDepth);  
            nonNegLong(),
    }
    private static final int TRIES = 100;
 * The OpenSearch Contributors require contributions made to  
            original.writeTo(out);  
            TaskMonitorStats act = actual.get(opType.key());  
            BytesStreamOutput out = new BytesStreamOutput();
            assertNotNull("original must contain " + opType.key(), exp);
        );
            nonNegLong(),
            NativeExecutorsStats deserialized = new NativeExecutorsStats(in);
        return new RuntimeMetrics(
            nonNegLong()
    }  
            randomLongBetween(1, Long.MAX_VALUE / 2),
            );  
            nonNegLong(),
 *
        return monitors;  
    }
        }
            nonNegLong(),  
import java.util.Map;
            assertTaskMonitorsEqual(original.getTaskMonitors(), deserialized.getTaskMonitors());
    }  
    private NativeExecutorsStats randomNativeExecutorsStatsNoCpu() {
            NativeExecutorsStats original = randomNativeExecutorsStatsNoCpu();
    /** RuntimeMetrics with workersCount &gt; 0, marking the CPU runtime as present. */
            NativeExecutorsStats original = randomNativeExecutorsStatsWithCpu();  
/**
        monitors.put("query_execution", randomTaskMonitorStats());  
            nonNegLong(),  
        monitors.put("plan_setup", randomTaskMonitorStats());
            nonNegLong(),  
            StreamInput in = out.bytes().streamInput();  
    }  
            assertEquals(opType.key() + ".total_idle_duration_ms", exp.totalIdleDurationMs, act.totalIdleDurationMs);  
            nonNegLong()
import org.opensearch.test.OpenSearchTestCase;
            nonNegLong(),  
            nonNegLong(),  
                deserialized.getCpuRuntime()
            assertEquals("Full NativeExecutorsStats round-trip must produce equal object", original, deserialized);
    private NativeExecutorsStats randomNativeExecutorsStatsWithCpu() {  
                "CPU runtime must be null in both original and deserialized",  
        for (int i = 0; i < TRIES; i++) {
 * (9 fields each) and 4 {@code TaskMonitorStats} (3 fields each), writing to {@code StreamOutput}
        assertEquals("deserialized must have exactly 4 task monitors", 4, actual.size());
    private Map<String, TaskMonitorStats> randomTaskMonitors() {  
            TaskMonitorStats exp = expected.get(opType.key());
            assertEquals(opType.key() + ".total_scheduled_duration_ms", exp.totalScheduledDurationMs, act.totalScheduledDurationMs);
 *
        return new RuntimeMetrics(
    }
 * <p>For any valid {@code NativeExecutorsStats} containing IO + optional CPU {@code RuntimeMetrics}
    }
    }  
            NativeExecutorsStats deserialized = new NativeExecutorsStats(in);  
package org.opensearch.be.datafusion.stats;
            original.writeTo(out);
}  
    public void testWriteableRoundTripPreservesAllFieldsNoCpu() throws IOException {
    }
            assertEquals(opType.key() + ".total_poll_duration_ms", exp.totalPollDurationMs, act.totalPollDurationMs);
        assertEquals(label + ".blocking_queue_depth", expected.blockingQueueDepth, actual.blockingQueueDepth);
    private void assertRuntimeMetricsEqual(RuntimeMetrics expected, RuntimeMetrics actual, String label) {
        return new NativeExecutorsStats(randomRuntimeMetrics(), randomRuntimeMetricsWithPositiveWorkers(), randomTaskMonitors());
        return new TaskMonitorStats(nonNegLong(), nonNegLong(), nonNegLong(), nonNegLong(), nonNegLong());  
            assertTaskMonitorsEqual(original.getTaskMonitors(), deserialized.getTaskMonitors());
 * <p>Validates: Requirements 6.6  
        assertEquals("original must have exactly 4 task monitors", 4, expected.size());
    private void assertTaskMonitorsEqual(Map<String, TaskMonitorStats> expected, Map<String, TaskMonitorStats> actual) {  
 * the original.
import org.opensearch.be.datafusion.stats.NativeExecutorsStats.OperationType;
        for (OperationType opType : OperationType.values()) {
public class NativeExecutorsStatsTests extends OpenSearchTestCase {
        monitors.put("stream_next", randomTaskMonitorStats());
import java.util.LinkedHashMap;
        assertEquals(label + ".workers_count", expected.workersCount, actual.workersCount);
            StreamInput in = out.bytes().streamInput();
/*  
 * compatible open source license.
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertEquals(label + ".total_overflow_count", expected.totalOverflowCount, actual.totalOverflowCount);
 * SPDX-License-Identifier: Apache-2.0
    }  
            assertNotNull("deserialized CPU runtime must be present", deserialized.getCpuRuntime());
            nonNegLong(),
    private long nonNegLong() {
 */
        }
            nonNegLong(),
            nonNegLong(),
            nonNegLong(),
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(label + ".spawned_tasks_count", expected.spawnedTasksCount, actual.spawnedTasksCount);  
            assertEquals(
 * and reading back from {@code StreamInput} produces an object whose field values are identical to  
    private RuntimeMetrics randomRuntimeMetricsWithPositiveWorkers() {  
            assertNotNull("deserialized must contain " + opType.key(), act);
        for (int i = 0; i < TRIES; i++) {  
            assertNotNull("original CPU runtime must be present", original.getCpuRuntime());
import java.io.IOException;  
        monitors.put("coordinator_reduce", randomTaskMonitorStats());
            nonNegLong(),
    public void testWriteableRoundTripPreservesAllFieldsWithCpu() throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;  
            BytesStreamOutput out = new BytesStreamOutput();  
    private RuntimeMetrics randomRuntimeMetrics() {  
        }
        Map<String, TaskMonitorStats> monitors = new LinkedHashMap<>();
 * Randomized tests for {@link NativeExecutorsStats} Writeable round-trip.
        assertEquals(label + ".num_alive_tasks", expected.numAliveTasks, actual.numAliveTasks);
    private TaskMonitorStats randomTaskMonitorStats() {
            assertRuntimeMetricsEqual(original.getIoRuntime(), deserialized.getIoRuntime(), "io_runtime");
            nonNegLong(),  
            nonNegLong(),
        return randomLongBetween(0, Long.MAX_VALUE / 2);  
    }
        assertEquals(label + ".total_busy_duration_ms", expected.totalBusyDurationMs, actual.totalBusyDurationMs);
        assertEquals(label + ".total_polls_count", expected.totalPollsCount, actual.totalPollsCount);  
            assertRuntimeMetricsEqual(original.getCpuRuntime(), deserialized.getCpuRuntime(), "cpu_runtime");  
 */  
        );
    // ---- Generators ----  
                original.getCpuRuntime(),
