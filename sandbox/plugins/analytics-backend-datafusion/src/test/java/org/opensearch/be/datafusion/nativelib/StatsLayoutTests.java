            assertEquals(3L, rt.totalBusyDurationMs);  
            assertEquals(2L, bs.rejections);  
            seg.setAtIndex(ValueLayout.JAVA_LONG, gateStart + 6, 5L);  // pending_acquire_permits  
            seg.setAtIndex(ValueLayout.JAVA_LONG, gateStart + 1, 3L);  // active_permits
public class StatsLayoutTests extends OpenSearchTestCase {
            assertEquals(100L, gate.totalBatchesStarted);
        }
            assertEquals(400L, tm.instrumentedCount);
            long cpuWorkers = StatsLayout.readField(seg, "cpu_runtime", "workers_count");
            if (cpuWorkers > 0) {
    /** 7.5: cpu_runtime is non-null when workers_count > 0. */
            assertEquals(300L, tm.totalIdleDurationMs);  
            }  
/*  
            if (cpuWorkers > 0) {
            seg.setAtIndex(ValueLayout.JAVA_LONG, gateStart + 3, 100L);// total_batches_started  
            int gateStart = 18 + 20; // = 38
            seg.setAtIndex(ValueLayout.JAVA_LONG, 20, 300L);
            assertEquals(4L, rt.totalOverflowCount);
 *
            }
            assertEquals(7L, rt.numAliveTasks);
            assertEquals(1L, rt.workersCount);
            // Write sequential values 1-9 at io_runtime positions (indices 0-8)
            seg.setAtIndex(ValueLayout.JAVA_LONG, 18, 100L);  
            assertEquals(2L, gate.pendingAcquireBatches);
            // coordinator_reduce starts at index 18 (2 runtime groups × 9 fields = 18)
            seg.setAtIndex(ValueLayout.JAVA_LONG, gateStart + 7, 2L);  // pending_acquire_batches
    }  
            seg.setAtIndex(ValueLayout.JAVA_LONG, 22, 395L);
        }
            var seg = arena.allocate(StatsLayout.LAYOUT);  
 * SPDX-License-Identifier: Apache-2.0
            assertNotNull(cpuRuntime);
        assertEquals(680L, StatsLayout.LAYOUT.byteSize());
    public void testReadRuntimeMetricsFromSegment() {
    public void testReadTaskMonitorFromSegment() {
                seg.setAtIndex(ValueLayout.JAVA_LONG, i, i * 10L);
import java.lang.foreign.ValueLayout;
            // Simulate the NativeBridge logic
            assertEquals(100L, cpuRuntime.totalPollsCount);
            // Set cpu_runtime.workers_count (index 9) to 5  
            PartitionGateStats gate = StatsLayout.readPartitionGate(seg, "fragment_executor_gate");  
            seg.setAtIndex(ValueLayout.JAVA_LONG, gateStart + 2, 456L);// total_wait_duration_ms
    }
            }
            assertEquals(9L, rt.totalLocalQueueDepth);  
 * The OpenSearch Contributors require contributions made to  
            assertNull(cpuRuntime);
            assertEquals(5L, gate.pendingAcquirePermits);
 * and cpu_runtime null/non-null logic.
    /** 7.3: readTaskMonitor decodes 5 known values from coordinator_reduce group. */
        try (var arena = Arena.ofConfined()) {
            var seg = arena.allocate(StatsLayout.LAYOUT);  
}  
            AdaptiveBudgetStats bs = StatsLayout.readAdaptiveBudgetStats(seg);
            // 2 runtimes × 9 = 18, + 4 task monitors × 5 = 20, + 1 gate × 8 = 8 → starts at index 46
            assertEquals(6L, rt.blockingQueueDepth);  
            assertEquals(100L, tm.totalPollDurationMs);
 */  
            // adaptive_budget starts at index:
    }
            // fragment_executor_gate starts at index:  
            // Set other cpu_runtime fields (indices 10-17)
            seg.setAtIndex(ValueLayout.JAVA_LONG, 21, 400L);  
        }
import java.lang.foreign.Arena;  
            }
        }  
    }  
            var seg = arena.allocate(StatsLayout.LAYOUT);
            seg.setAtIndex(ValueLayout.JAVA_LONG, 9, 5L);
        try (var arena = Arena.ofConfined()) {
 * compatible open source license.
            RuntimeMetrics cpuRuntime = null;
        try (var arena = Arena.ofConfined()) {  
            var seg = arena.allocate(StatsLayout.LAYOUT);
    public void testReadPartitionGateFromSegment() {  
    /** 7.7: readAdaptiveBudgetStats decodes 2 fields from adaptive_budget group. */  
                cpuRuntime = StatsLayout.readRuntimeMetrics(seg, "cpu_runtime");  
            assertEquals(0L, cpuWorkers);  
    }
        try (var arena = Arena.ofConfined()) {
    }
            int budgetStart = 18 + 20 + 8; // = 46  
 */  
            assertEquals(5L, cpuRuntime.workersCount);  
            seg.setAtIndex(ValueLayout.JAVA_LONG, gateStart, 12L);     // max_permits  
package org.opensearch.be.datafusion.nativelib;
        try (var arena = Arena.ofConfined()) {
                cpuRuntime = StatsLayout.readRuntimeMetrics(seg, "cpu_runtime");
            seg.setAtIndex(ValueLayout.JAVA_LONG, gateStart + 4, 1L);  // poison_permits
        }  
        try (var arena = Arena.ofConfined()) {
            assertEquals(5L, rt.globalQueueDepth);
            var rt = StatsLayout.readRuntimeMetrics(seg, "io_runtime");  
import org.opensearch.be.datafusion.stats.PartitionGateStats;
            assertEquals(200L, tm.totalScheduledDurationMs);
import org.opensearch.be.datafusion.stats.RuntimeMetrics;  
            assertEquals(2L, rt.totalPollsCount);
            assertEquals(15L, bs.fallbacks);
            // cpu_runtime.workers_count is at index 9 — leave it as 0 (default)
            assertEquals(8L, rt.spawnedTasksCount);
    /** 7.1: Layout byte size must be 640 (85 × 8). */  
            var seg = arena.allocate(StatsLayout.LAYOUT);
/**  
            assertEquals(395L, tm.droppedCount);
                seg.setAtIndex(ValueLayout.JAVA_LONG, i, i + 1L);  
        }
 * this file be licensed under the Apache-2.0 license or a
            seg.setAtIndex(ValueLayout.JAVA_LONG, budgetStart + 1, 2L);    // rejections
            for (int i = 0; i < 9; i++) {
    }
            var seg = arena.allocate(StatsLayout.LAYOUT);  
import org.opensearch.test.OpenSearchTestCase;
 * Unit tests for {@link StatsLayout} — verifies layout size, VarHandle reads,
            assertEquals(5L, cpuWorkers);
            seg.setAtIndex(ValueLayout.JAVA_LONG, gateStart + 5, 12L); // target_max_permits
            assertEquals(3L, gate.activePermits);
    public void testReadAdaptiveBudgetStatsFromSegment() {
        assertEquals(85 * Long.BYTES, (int) StatsLayout.LAYOUT.byteSize());  
            seg.setAtIndex(ValueLayout.JAVA_LONG, budgetStart, 15L);       // fallbacks
    /** 7.6: readPartitionGate decodes 8 fields including pendingAcquirePermits and pendingAcquireBatches from fragment_executor_gate. */
    /** 7.2: readRuntimeMetrics decodes 9 known values from io_runtime group. */  
            assertEquals(1L, gate.poisonPermits);
            RuntimeMetrics cpuRuntime = null;  
            for (int i = 10; i <= 17; i++) {  
            assertEquals(12L, gate.maxPermits);
import org.opensearch.be.datafusion.stats.AdaptiveBudgetStats;
    public void testCpuRuntimeNullWhenWorkersZero() {
            assertEquals(12L, gate.targetMaxPermits);  
            var tm = StatsLayout.readTaskMonitor(seg, "coordinator_reduce");  
            assertEquals(456L, gate.totalWaitDurationMs);  
    /** 7.4: cpu_runtime is null when workers_count == 0. */  
            seg.setAtIndex(ValueLayout.JAVA_LONG, 19, 200L);
    public void testCpuRuntimeNonNullWhenWorkersPositive() {  
            // 2 runtimes × 9 = 18, + 4 task monitors × 5 = 20 → starts at index 38
    public void testLayoutByteSize() {
            long cpuWorkers = StatsLayout.readField(seg, "cpu_runtime", "workers_count");
