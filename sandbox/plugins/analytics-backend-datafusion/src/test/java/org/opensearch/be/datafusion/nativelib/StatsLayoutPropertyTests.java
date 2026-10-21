                assertEquals(values[15], cpuRuntime.numAliveTasks);
            NativeExecutorsStats original = randomNativeExecutorsStatsNoCpu();
                    cpuRuntime.totalLocalQueueDepth,
            StreamInput in = out.bytes().streamInput();
            nonNegLong(),
                assertNull("cpuRuntime must be null when workers_count == 0", cpuRuntime);
            assertNull("CPU runtime must be null", deserialized.getCpuRuntime());
                    cpuRuntime.totalPollsCount,
                assertEquals(values[50], cs.getMetadataCache().entryCount);
    }
                var bs = StatsLayout.readAdaptiveBudgetStats(original);
    private TaskMonitorStats randomTaskMonitorStats() {
                    cpuRuntime.spawnedTasksCount,
import java.io.IOException;
            try (var arena = Arena.ofConfined()) {
            original.writeTo(out);
import org.opensearch.be.datafusion.stats.RuntimeMetrics;
                assertEquals(values[72], ss.rgProcessed);
                long cpuWorkers = StatsLayout.readField(seg, "cpu_runtime", "workers_count");
            long[] values = randomFieldArrayWithCpuWorkersPositive();
                var seg = arena.allocate(StatsLayout.LAYOUT);
    }
                    ioRuntime.totalOverflowCount,
                    ioRuntime.totalBusyDurationMs,
                    cs.getStatisticsCache().sizeLimitBytes,
                    ps.droppedCount,
                    feg.targetMaxPermits,
                for (int i = 0; i < decoded.length; i++) {
                    cs.getOffsetIndexCache().hitCount,
                assertEquals(values[0], ioRuntime.workersCount);
                    int base = 18 + g * 5;
            nonNegLong(),
                var original = arena.allocate(StatsLayout.LAYOUT);
                    // io_runtime (9)
                    cs.getMetadataCache().missCount,
                assertEquals(values[12], cpuRuntime.totalOverflowCount);
                assertEquals(values[44], feg.pendingAcquirePermits);
    // ---- Generators ----
                    ss.rgSkipped,
                assertEquals(values[7], ioRuntime.spawnedTasksCount);
                    cs.getColumnIndexCache().sizeLimitBytes,
                assertEquals(values[3], ioRuntime.totalOverflowCount);
                    ss.delegationCalls,
                    assertEquals(tmGroups[g] + ".dropped_count", values[base + 4], tm.droppedCount);
    }
        for (int t = 0; t < TRIES; t++) {
                    cs.getMetadataCache().sizeLimitBytes,
                    // adaptive_budget (2)
                var cs = StatsLayout.readCacheStats(seg);
        for (int t = 0; t < TRIES; t++) {
    private NativeExecutorsStats randomNativeExecutorsStatsNoCpu() {
                    ss.bitmapTreeScan,
                    ss.onBatchMaskTimeMs,
                    feg.poisonPermits,
        monitors.put("query_execution", randomTaskMonitorStats());
                assertEquals(values[46], bs.fallbacks);
        }
                // Compare byte-for-byte over the full buffer
                    ps.totalPollDurationMs,
                }
                    cr.totalIdleDurationMs,
                    // plan_setup (5)
    private RuntimeMetrics randomRuntimeMetricsWithPositiveWorkers() {
 *   <li>Decode-then-reencode produces byte-identical buffer</li>
    public void testWriteableRoundTripWithCpu() throws IOException {
            BytesStreamOutput out = new BytesStreamOutput();
                assertEquals(values[73], ss.rgSkipped);
                // Re-encode into new buffer
                var cr = StatsLayout.readTaskMonitor(original, "coordinator_reduce");
    public void testWriteableRoundTripNoCpu() throws IOException {
                    sn.droppedCount,
        return monitors;
    private long[] randomFieldArrayWithCpuWorkersPositive() {
                assertEquals(values[62], cs.getColumnIndexCache().sizeLimitBytes);
                    // stream_next (5)
 *   <li>Pack-then-decode round-trip preserves all fields</li>
                    reencoded.setAtIndex(ValueLayout.JAVA_LONG, i, decoded[i]);
                for (int g = 0; g < 4; g++) {
                assertEquals(values[67], cs.getOffsetIndexCache().sizeLimitBytes);
                }
            try (var arena = Arena.ofConfined()) {
                    ioRuntime.totalLocalQueueDepth,
            nonNegLong(),
                    qe.totalIdleDurationMs,
                assertEquals(values[53], cs.getStatisticsCache().hitCount);
                    cs.getStatisticsCache().hitCount,
            original.writeTo(out);
    private Map<String, TaskMonitorStats> randomTaskMonitors() {
 */
            BytesStreamOutput out = new BytesStreamOutput();
                    assertEquals(tmGroups[g] + ".total_poll_duration_ms", values[base], tm.totalPollDurationMs);
                    ioRuntime.totalPollsCount,
                for (int i = 0; i < FIELD_COUNT; i++) {
                    ss.objectStoreReadTimeMs };
import org.opensearch.be.datafusion.stats.NativeExecutorsStats;
                    ss.filterRecordBatchTimeMs,
                var cpuRuntime = StatsLayout.readRuntimeMetrics(original, "cpu_runtime");
    }
                assertEquals(values[40], feg.totalWaitDurationMs);
            arr[i] = nonNegLong();
                    ps.totalScheduledDurationMs,
    }
        for (int i = 0; i < FIELD_COUNT; i++) {
            assertEquals("Writeable round-trip must produce equal object", original, deserialized);
                assertEquals(values[57], cs.getStatisticsCache().sizeLimitBytes);
                    ss.parquetProcessingTimeMs,
                // Adaptive budget (offsets 46-47)
                var cs = StatsLayout.readCacheStats(original);
import org.opensearch.test.OpenSearchTestCase;
                assertEquals(values[2], ioRuntime.totalBusyDurationMs);
                assertEquals(values[41], feg.totalBatchesStarted);
                    cs.getColumnIndexCache().memoryBytes,
                // Cache stats (offsets 48-57)
                    ss.parquetScanUntilDataTimeMs,
                var reencoded = arena.allocate(StatsLayout.LAYOUT);
 *
                    assertEquals(tmGroups[g] + ".total_scheduled_duration_ms", values[base + 1], tm.totalScheduledDurationMs);
                    ps.totalIdleDurationMs,
            nonNegLong(),
    public void testPackThenDecodeRoundTripCpuNull() {
        }
                assertEquals(values[45], feg.pendingAcquireBatches);
                var feg = StatsLayout.readPartitionGate(original, "fragment_executor_gate");
                assertEquals(values[14], cpuRuntime.blockingQueueDepth);
        return new RuntimeMetrics(
                if (cpuWorkers > 0) {
                var ss = StatsLayout.readSearchStats(seg);
                    feg.activePermits,
                assertEquals(values[56], cs.getStatisticsCache().memoryBytes);
                for (int i = 0; i < FIELD_COUNT; i++) {
package org.opensearch.be.datafusion.nativelib;
                assertEquals(values[82], ss.onBatchMaskTimeMs);
    // ---- Property 1: Pack-then-decode round-trip (cpu workers > 0) ----
public class StatsLayoutPropertyTests extends OpenSearchTestCase {
                byte[] originalBytes = original.asSlice(0, (long) FIELD_COUNT * Long.BYTES).toArray(ValueLayout.JAVA_BYTE);
                assertEquals(values[70], ss.bitmapTreeScan);
 * compatible open source license.
            nonNegLong(),
                }
                    qe.totalPollDurationMs,
                    cpuRuntime = StatsLayout.readRuntimeMetrics(seg, "cpu_runtime");
                byte[] reencodedBytes = reencoded.asSlice(0, (long) FIELD_COUNT * Long.BYTES).toArray(ValueLayout.JAVA_BYTE);
    private RuntimeMetrics randomRuntimeMetrics() {
                assertEquals(values[6], ioRuntime.numAliveTasks);
                    ss.parquetBytesScanned,
                assertEquals(values[74], ss.parquetScanTotalTimeMs);
                    // search_stats (17)
                assertEquals(values[17], cpuRuntime.totalLocalQueueDepth);
                assertEquals(values[39], feg.activePermits);
 * The OpenSearch Contributors require contributions made to
                assertEquals(values[79], ss.prefetchWaitCount);
                    cs.getColumnIndexCache().entryCount,
    private long[] randomFieldArrayWithCpuWorkersZero() {
                    cpuRuntime.numAliveTasks,
import java.util.Map;
        monitors.put("coordinator_reduce", randomTaskMonitorStats());
                    // cache_stats.offset_index_cache (5)
                assertEquals(values[75], ss.parquetScanUntilDataTimeMs);
                assertEquals(values[80], ss.elapsedComputeMs);
                // Write original values
                    ps.instrumentedCount,
            NativeExecutorsStats deserialized = new NativeExecutorsStats(in);
        return new TaskMonitorStats(nonNegLong(), nonNegLong(), nonNegLong(), nonNegLong(), nonNegLong());
    }
            NativeExecutorsStats original = randomNativeExecutorsStatsWithCpu();
                    // fragment_executor_gate (8)
                    sn.instrumentedCount,
                    feg.totalWaitDurationMs,
/*
            nonNegLong(),
                    ss.singleCollectorScan,
            randomLongBetween(1, Long.MAX_VALUE / 2),
            NativeExecutorsStats deserialized = new NativeExecutorsStats(in);
    // ---- Property 3: Writeable serialization round-trip ----
                    cr.instrumentedCount,
        }
                var qe = StatsLayout.readTaskMonitor(original, "query_execution");
                    ss.parquetScanTotalTimeMs,
    private NativeExecutorsStats randomNativeExecutorsStatsWithCpu() {
                    feg.pendingAcquireBatches,
                    ss.buildMaskTimeMs,
            try (var arena = Arena.ofConfined()) {
            nonNegLong(),
    }
            nonNegLong(),
                var feg = StatsLayout.readPartitionGate(seg, "fragment_executor_gate");
                assertNotNull(cpuRuntime);
        return arr;
                    qe.totalScheduledDurationMs,
            nonNegLong(),
        }
            nonNegLong(),
import java.lang.foreign.ValueLayout;
                assertEquals(values[78], ss.prefetchWaitTimeMs);
                    qe.instrumentedCount,
                }
        long[] arr = new long[FIELD_COUNT];
            long[] values = randomFieldArray();
                    ioRuntime.workersCount,
                assertEquals(values[13], cpuRuntime.globalQueueDepth);
                    bs.fallbacks,
                assertEquals(values[77], ss.parquetBytesScanned);
import org.opensearch.common.io.stream.BytesStreamOutput;
        long[] arr = randomFieldArray();
                    ss.rgProcessed,
                    cs.getOffsetIndexCache().entryCount,
    // ---- Property 2: Decode-then-reencode identity ----
                assertEquals(values[84], ss.objectStoreReadTimeMs);
                    cs.getOffsetIndexCache().missCount,
                assertEquals(values[51], cs.getMetadataCache().memoryBytes);
                    original.setAtIndex(ValueLayout.JAVA_LONG, i, values[i]);
        long[] arr = randomFieldArray();
            nonNegLong(),
                assertEquals(values[11], cpuRuntime.totalBusyDurationMs);
 * <ol>
        return randomLongBetween(0, Long.MAX_VALUE / 2);
/**
                    cpuRuntime.totalBusyDurationMs,
        );
            }
                    ss.listingTableScan,
                assertEquals(values[1], ioRuntime.totalPollsCount);
                    // query_execution (5)
                    ss.prefetchWaitTimeMs,
            nonNegLong()
        }
                    feg.totalBatchesStarted,
                // Partition gate (offsets 38-45)
                    sn.totalPollDurationMs,
                assertEquals(values[55], cs.getStatisticsCache().entryCount);
        Map<String, TaskMonitorStats> monitors = new LinkedHashMap<>();
                }
                assertEquals(values[16], cpuRuntime.spawnedTasksCount);
            StreamInput in = out.bytes().streamInput();
        for (int t = 0; t < TRIES; t++) {
    }
 * </ol>
            long[] values = randomFieldArrayWithCpuWorkersZero();
    }
                    cr.droppedCount,
                assertEquals(values[47], bs.rejections);
                    seg.setAtIndex(ValueLayout.JAVA_LONG, i, values[i]);
                    cr.totalPollDurationMs,
                    feg.pendingAcquirePermits,
                String[] tmGroups = { "coordinator_reduce", "query_execution", "stream_next", "plan_setup" };
                var bs = StatsLayout.readAdaptiveBudgetStats(seg);
        for (int t = 0; t < TRIES; t++) {
        return arr;
            assertEquals("Writeable round-trip must produce equal object", original, deserialized);
                    cs.getMetadataCache().entryCount,
                assertEquals(values[61], cs.getColumnIndexCache().memoryBytes);
                assertEquals(values[49], cs.getMetadataCache().missCount);
                assertEquals(values[38], feg.maxPermits);
                    cs.getOffsetIndexCache().sizeLimitBytes,
 * <p>Validates the three correctness properties from the ffm-struct-layout design:
                    bs.rejections,
                    // cache_stats.statistics_cache (5)
                    cpuRuntime.totalOverflowCount,
        arr[9] = randomLongBetween(1, Long.MAX_VALUE / 2); // ensure cpu_runtime.workers_count > 0
    }
        for (int t = 0; t < TRIES; t++) {
                assertEquals(values[4], ioRuntime.globalQueueDepth);
                    ss.elapsedComputeMs,
                    sn.totalIdleDurationMs,
 *   <li>Writeable serialization round-trip</li>
 * Randomized tests for {@link StatsLayout} struct decode.
                    assertEquals(tmGroups[g] + ".total_idle_duration_ms", values[base + 2], tm.totalIdleDurationMs);
                assertEquals(values[43], feg.targetMaxPermits);
                    sn.totalScheduledDurationMs,
                var ioRuntime = StatsLayout.readRuntimeMetrics(seg, "io_runtime");
    }
import java.util.LinkedHashMap;
                assertEquals(values[48], cs.getMetadataCache().hitCount);
                var ss = StatsLayout.readSearchStats(original);
                assertTrue("cpu workers should be > 0", cpuWorkers > 0);
                var sn = StatsLayout.readTaskMonitor(original, "stream_next");
            nonNegLong(),
                assertEquals(values[83], ss.filterRecordBatchTimeMs);
                long[] decoded = {
        return arr;
import org.opensearch.core.common.io.stream.StreamInput;
                    qe.droppedCount,
    private long[] randomFieldArray() {
                // Decode all fields
                assertEquals(values[60], cs.getColumnIndexCache().entryCount);
            nonNegLong(),
                assertEquals(values[59], cs.getColumnIndexCache().missCount);
                    // cache_stats.metadata_cache (5)
                assertEquals(values[65], cs.getOffsetIndexCache().entryCount);
            nonNegLong()
    private static final int TRIES = 100;
                    cs.getOffsetIndexCache().memoryBytes,
                var ioRuntime = StatsLayout.readRuntimeMetrics(original, "io_runtime");
        monitors.put("stream_next", randomTaskMonitorStats());
        return new NativeExecutorsStats(randomRuntimeMetrics(), randomRuntimeMetricsWithPositiveWorkers(), randomTaskMonitors());
                    ioRuntime.spawnedTasksCount,
    }
                assertEquals(values[69], ss.singleCollectorScan);
                assertEquals(values[9], cpuRuntime.workersCount);
 */
}
import org.opensearch.be.datafusion.stats.TaskMonitorStats;
        arr[9] = 0; // cpu_runtime.workers_count = 0
            }
                assertEquals(values[8], ioRuntime.totalLocalQueueDepth);
                }
                var cpuRuntime = StatsLayout.readRuntimeMetrics(seg, "cpu_runtime");
        return new RuntimeMetrics(
    }
    }
                assertEquals(values[66], cs.getOffsetIndexCache().memoryBytes);
                    ioRuntime.blockingQueueDepth,
                    assertEquals(tmGroups[g] + ".instrumented_count", values[base + 3], tm.instrumentedCount);
 * this file be licensed under the Apache-2.0 license or a
import java.lang.foreign.Arena;
                    cs.getColumnIndexCache().missCount,
                    cpuRuntime.blockingQueueDepth,
                for (int i = 0; i < FIELD_COUNT; i++) {
                assertArrayEquals("Decode-then-reencode must produce byte-identical buffer", originalBytes, reencodedBytes);
                assertEquals(values[63], cs.getOffsetIndexCache().hitCount);
                long cpuWorkers = StatsLayout.readField(seg, "cpu_runtime", "workers_count");
                assertEquals(0L, cpuWorkers);
                    cs.getMetadataCache().hitCount,
    private long nonNegLong() {
                    ioRuntime.globalQueueDepth,
                    cpuRuntime.workersCount,
                    seg.setAtIndex(ValueLayout.JAVA_LONG, i, values[i]);
                    ioRuntime.numAliveTasks,
                assertEquals(values[58], cs.getColumnIndexCache().hitCount);
    public void testPackThenDecodeRoundTripWithCpu() {
                    cs.getStatisticsCache().memoryBytes,
                // Search stats (offsets 68-84)
                    cs.getColumnIndexCache().hitCount,
                assertEquals(values[52], cs.getMetadataCache().sizeLimitBytes);
                    feg.maxPermits,
        }
                assertEquals(values[10], cpuRuntime.totalPollsCount);
                assertEquals(values[54], cs.getStatisticsCache().missCount);
                assertEquals(values[64], cs.getOffsetIndexCache().missCount);
                    cs.getMetadataCache().memoryBytes,
            nonNegLong(),
                    var tm = StatsLayout.readTaskMonitor(seg, tmGroups[g]);
            nonNegLong(),
                assertEquals(values[5], ioRuntime.blockingQueueDepth);
                    cs.getStatisticsCache().missCount,
        );
                assertEquals(values[71], ss.delegationCalls);
        return new NativeExecutorsStats(randomRuntimeMetrics(), null, randomTaskMonitors());
                assertEquals(values[68], ss.listingTableScan);
 * SPDX-License-Identifier: Apache-2.0
                assertEquals(values[42], feg.poisonPermits);
            }
                // Simulate NativeBridge logic: null when workers_count == 0
    public void testDecodeThenReencodeIdentity() {
                assertEquals(values[76], ss.parquetProcessingTimeMs);
                    cpuRuntime.globalQueueDepth,
    private static final int FIELD_COUNT = 85;
                assertEquals(values[81], ss.buildMaskTimeMs);
                var seg = arena.allocate(StatsLayout.LAYOUT);
                    cr.totalScheduledDurationMs,
        monitors.put("plan_setup", randomTaskMonitorStats());
 *
                    ss.prefetchWaitCount,
                    // cpu_runtime (9)
                    // coordinator_reduce (5)
                var ps = StatsLayout.readTaskMonitor(original, "plan_setup");
    }
                RuntimeMetrics cpuRuntime = null;
                    cs.getStatisticsCache().entryCount,
                    // cache_stats.column_index_cache (5)
