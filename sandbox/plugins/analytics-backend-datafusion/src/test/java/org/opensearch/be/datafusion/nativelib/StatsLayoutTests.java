            // cpu_runtime.workers_count is at index 9 — leave it as 0 (default)
                seg.setAtIndex(ValueLayout.JAVA_LONG, i, i + 1L);
            var seg = arena.allocate(StatsLayout.LAYOUT);
            seg.setAtIndex(ValueLayout.JAVA_LONG, gateStart + 5, 12L); // target_max_permits
            // adaptive_budget starts at index:
            // Set other cpu_runtime fields (indices 10-17)
            }
            assertEquals(6L, rt.blockingQueueDepth);
    public void testCpuRuntimeNonNullWhenWorkersPositive() {
 * SPDX-License-Identifier: Apache-2.0
            seg.setAtIndex(ValueLayout.JAVA_LONG, gateStart, 12L);     // max_permits
        try (var arena = Arena.ofConfined()) {
            seg.setAtIndex(ValueLayout.JAVA_LONG, budgetStart, 15L);       // fallbacks
            assertEquals(1L, rt.workersCount);
            if (cpuWorkers > 0) {
            PartitionGateStats gate = StatsLayout.readPartitionGate(seg, "fragment_executor_gate");
        try (var arena = Arena.ofConfined()) {
                cpuRuntime = StatsLayout.readRuntimeMetrics(seg, "cpu_runtime");
            assertEquals(300L, tm.totalIdleDurationMs);
            seg.setAtIndex(ValueLayout.JAVA_LONG, 9, 5L);
            assertEquals(2L, rt.totalPollsCount);
            seg.setAtIndex(ValueLayout.JAVA_LONG, gateStart + 3, 100L);// total_batches_started
            seg.setAtIndex(ValueLayout.JAVA_LONG, 21, 400L);
import java.lang.foreign.ValueLayout;
            seg.setAtIndex(ValueLayout.JAVA_LONG, gateStart + 7, 2L);  // pending_acquire_batches
 * compatible open source license.
            assertEquals(456L, gate.totalWaitDurationMs);
            assertEquals(5L, cpuWorkers);
            int gateStart = 18 + 20; // = 38
            assertEquals(9L, rt.totalLocalQueueDepth);
import org.opensearch.be.datafusion.stats.RuntimeMetrics;
    /** 7.2: readRuntimeMetrics decodes 9 known values from io_runtime group. */
            // Write sequential values 1-9 at io_runtime positions (indices 0-8)
        }
import org.opensearch.test.OpenSearchTestCase;
            RuntimeMetrics cpuRuntime = null;
            for (int i = 10; i <= 17; i++) {
            assertEquals(0L, cpuWorkers);
    /** 7.7: readAdaptiveBudgetStats decodes 2 fields from adaptive_budget group. */
        try (var arena = Arena.ofConfined()) {
        try (var arena = Arena.ofConfined()) {
            // 2 runtimes × 9 = 18, + 4 task monitors × 5 = 20 → starts at index 38
/*
 * and cpu_runtime null/non-null logic.
            assertEquals(5L, gate.pendingAcquirePermits);
        try (var arena = Arena.ofConfined()) {
    }
    public void testLayoutByteSize() {
    }
    }
    /** 7.3: readTaskMonitor decodes 5 known values from coordinator_reduce group. */
            assertEquals(2L, gate.pendingAcquireBatches);
            assertEquals(12L, gate.targetMaxPermits);
            var seg = arena.allocate(StatsLayout.LAYOUT);
            assertEquals(7L, rt.numAliveTasks);
            assertEquals(4L, rt.totalOverflowCount);
    /** 7.6: readPartitionGate decodes 8 fields including pendingAcquirePermits and pendingAcquireBatches from fragment_executor_gate. */
            assertEquals(5L, rt.globalQueueDepth);
            seg.setAtIndex(ValueLayout.JAVA_LONG, budgetStart + 1, 2L);    // rejections
    public void testReadRuntimeMetricsFromSegment() {
            assertNotNull(cpuRuntime);
            seg.setAtIndex(ValueLayout.JAVA_LONG, gateStart + 1, 3L);  // active_permits
            long cpuWorkers = StatsLayout.readField(seg, "cpu_runtime", "workers_count");
            }
package org.opensearch.be.datafusion.nativelib;
            assertNull(cpuRuntime);
    public void testReadTaskMonitorFromSegment() {
            assertEquals(1L, gate.poisonPermits);
    /** 7.5: cpu_runtime is non-null when workers_count > 0. */
            assertEquals(3L, rt.totalBusyDurationMs);
    }
            seg.setAtIndex(ValueLayout.JAVA_LONG, 22, 395L);
            seg.setAtIndex(ValueLayout.JAVA_LONG, 18, 100L);
 */
            var rt = StatsLayout.readRuntimeMetrics(seg, "io_runtime");
            // 2 runtimes × 9 = 18, + 4 task monitors × 5 = 20, + 1 gate × 8 = 8 → starts at index 46
            if (cpuWorkers > 0) {
        }
    }
    public void testReadAdaptiveBudgetStatsFromSegment() {
            }
            // coordinator_reduce starts at index 18 (2 runtime groups × 9 fields = 18)
        }
            assertEquals(100L, gate.totalBatchesStarted);
            // Set cpu_runtime.workers_count (index 9) to 5
            assertEquals(400L, tm.instrumentedCount);
            AdaptiveBudgetStats bs = StatsLayout.readAdaptiveBudgetStats(seg);
public class StatsLayoutTests extends OpenSearchTestCase {
            }
            seg.setAtIndex(ValueLayout.JAVA_LONG, gateStart + 2, 456L);// total_wait_duration_ms
        assertEquals(85 * Long.BYTES, (int) StatsLayout.LAYOUT.byteSize());
            seg.setAtIndex(ValueLayout.JAVA_LONG, 19, 200L);
            seg.setAtIndex(ValueLayout.JAVA_LONG, 20, 300L);
        }
    public void testReadPartitionGateFromSegment() {
            assertEquals(200L, tm.totalScheduledDurationMs);
            assertEquals(15L, bs.fallbacks);
        }
    }
 */
            assertEquals(5L, cpuRuntime.workersCount);
    }
    /** 7.1: Layout byte size must be 640 (85 × 8). */
            int budgetStart = 18 + 20 + 8; // = 46
            assertEquals(2L, bs.rejections);
            assertEquals(100L, cpuRuntime.totalPollsCount);
            // fragment_executor_gate starts at index:
 *
            long cpuWorkers = StatsLayout.readField(seg, "cpu_runtime", "workers_count");
            assertEquals(395L, tm.droppedCount);
            seg.setAtIndex(ValueLayout.JAVA_LONG, gateStart + 6, 5L);  // pending_acquire_permits
        try (var arena = Arena.ofConfined()) {
            var seg = arena.allocate(StatsLayout.LAYOUT);
            assertEquals(8L, rt.spawnedTasksCount);
                seg.setAtIndex(ValueLayout.JAVA_LONG, i, i * 10L);
import java.lang.foreign.Arena;
import org.opensearch.be.datafusion.stats.AdaptiveBudgetStats;
}
 * The OpenSearch Contributors require contributions made to
        assertEquals(680L, StatsLayout.LAYOUT.byteSize());
    public void testCpuRuntimeNullWhenWorkersZero() {
            seg.setAtIndex(ValueLayout.JAVA_LONG, gateStart + 4, 1L);  // poison_permits
import org.opensearch.be.datafusion.stats.PartitionGateStats;
            // Simulate the NativeBridge logic
            var seg = arena.allocate(StatsLayout.LAYOUT);
            assertEquals(12L, gate.maxPermits);
            for (int i = 0; i < 9; i++) {
            assertEquals(3L, gate.activePermits);
            assertEquals(100L, tm.totalPollDurationMs);
/**
                cpuRuntime = StatsLayout.readRuntimeMetrics(seg, "cpu_runtime");
        }
    /** 7.4: cpu_runtime is null when workers_count == 0. */
 * this file be licensed under the Apache-2.0 license or a
 * Unit tests for {@link StatsLayout} — verifies layout size, VarHandle reads,
            RuntimeMetrics cpuRuntime = null;
            var seg = arena.allocate(StatsLayout.LAYOUT);
            var tm = StatsLayout.readTaskMonitor(seg, "coordinator_reduce");
            var seg = arena.allocate(StatsLayout.LAYOUT);
