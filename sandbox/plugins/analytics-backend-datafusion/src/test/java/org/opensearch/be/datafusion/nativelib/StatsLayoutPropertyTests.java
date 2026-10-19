                var cs = StatsLayout.readCacheStats(original);
                assertEquals(values[44], feg.pendingAcquirePermits);
                assertEquals(values[45], feg.pendingAcquireBatches);
import java.util.Map;  
                assertEquals(values[84], ss.objectStoreReadTimeMs);
    public void testDecodeThenReencodeIdentity() {
                assertEquals(values[4], ioRuntime.globalQueueDepth);
                    // cache_stats.offset_index_cache (5)
    }  
            NativeExecutorsStats deserialized = new NativeExecutorsStats(in);  
                    // plan_setup (5)
                    int base = 18 + g * 5;  
            try (var arena = Arena.ofConfined()) {
                    cr.totalScheduledDurationMs,  
        long[] arr = randomFieldArray();  
                    cs.getMetadataCache().sizeLimitBytes,  
                    ioRuntime.totalOverflowCount,  
    }
            BytesStreamOutput out = new BytesStreamOutput();  
                    // search_stats (17)
 */
                assertEquals(values[49], cs.getMetadataCache().missCount);  
            long[] values = randomFieldArrayWithCpuWorkersPositive();
                    sn.droppedCount,  
                assertEquals(values[81], ss.buildMaskTimeMs);
        for (int t = 0; t < TRIES; t++) {
                for (int i = 0; i < FIELD_COUNT; i++) {  
                assertEquals(values[40], feg.totalWaitDurationMs);  
                var cpuRuntime = StatsLayout.readRuntimeMetrics(seg, "cpu_runtime");  
    private long[] randomFieldArrayWithCpuWorkersPositive() {
                    original.setAtIndex(ValueLayout.JAVA_LONG, i, values[i]);
                    cpuRuntime.numAliveTasks,
        monitors.put("coordinator_reduce", randomTaskMonitorStats());  
                    cpuRuntime = StatsLayout.readRuntimeMetrics(seg, "cpu_runtime");
                    reencoded.setAtIndex(ValueLayout.JAVA_LONG, i, decoded[i]);
                    sn.totalIdleDurationMs,
                    qe.totalIdleDurationMs,
    private long[] randomFieldArray() {  
            try (var arena = Arena.ofConfined()) {
                assertEquals(values[61], cs.getColumnIndexCache().memoryBytes);  
                assertEquals(values[14], cpuRuntime.blockingQueueDepth);
                    // coordinator_reduce (5)
                for (int g = 0; g < 4; g++) {
                    ss.parquetScanTotalTimeMs,
                assertEquals(values[41], feg.totalBatchesStarted);
    }
                // Cache stats (offsets 48-57)  
                    ioRuntime.blockingQueueDepth,
                var seg = arena.allocate(StatsLayout.LAYOUT);  
                    qe.totalPollDurationMs,
                    // stream_next (5)
                assertEquals(values[80], ss.elapsedComputeMs);
                    ss.elapsedComputeMs,
                    ps.totalPollDurationMs,
                assertEquals(values[67], cs.getOffsetIndexCache().sizeLimitBytes);  
import java.util.LinkedHashMap;
                assertEquals(values[9], cpuRuntime.workersCount);
                assertEquals(values[53], cs.getStatisticsCache().hitCount);
                assertEquals(values[74], ss.parquetScanTotalTimeMs);
                assertEquals(values[63], cs.getOffsetIndexCache().hitCount);
                    ps.totalIdleDurationMs,
                assertEquals(values[71], ss.delegationCalls);
            arr[i] = nonNegLong();  
                    ss.prefetchWaitTimeMs,  
    }
                    ps.instrumentedCount,
        }
                }
                    sn.instrumentedCount,
                    // cpu_runtime (9)  
    // ---- Property 1: Pack-then-decode round-trip (cpu workers > 0) ----  
                    ioRuntime.spawnedTasksCount,
                    cs.getStatisticsCache().entryCount,
                var reencoded = arena.allocate(StatsLayout.LAYOUT);  
                    ss.rgSkipped,
                    ss.objectStoreReadTimeMs };  
                    sn.totalScheduledDurationMs,  
                    cr.instrumentedCount,
    // ---- Property 3: Writeable serialization round-trip ----
                    assertEquals(tmGroups[g] + ".total_idle_duration_ms", values[base + 2], tm.totalIdleDurationMs);  
            nonNegLong()
 * this file be licensed under the Apache-2.0 license or a
    public void testPackThenDecodeRoundTripCpuNull() {
                assertEquals(values[50], cs.getMetadataCache().entryCount);
        return new NativeExecutorsStats(randomRuntimeMetrics(), randomRuntimeMetricsWithPositiveWorkers(), randomTaskMonitors());
                // Simulate NativeBridge logic: null when workers_count == 0
                long cpuWorkers = StatsLayout.readField(seg, "cpu_runtime", "workers_count");
 *
                var sn = StatsLayout.readTaskMonitor(original, "stream_next");
        }
                assertEquals(values[73], ss.rgSkipped);  
                assertEquals(values[77], ss.parquetBytesScanned);
                assertEquals(values[16], cpuRuntime.spawnedTasksCount);  
                }  
    }  
 */  
    private Map<String, TaskMonitorStats> randomTaskMonitors() {
            nonNegLong(),
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.test.OpenSearchTestCase;  
    private static final int FIELD_COUNT = 85;
                    cs.getOffsetIndexCache().entryCount,
                assertEquals(values[72], ss.rgProcessed);
    // ---- Generators ----  
                    feg.activePermits,  
                var bs = StatsLayout.readAdaptiveBudgetStats(original);
                    cs.getMetadataCache().hitCount,
 *   <li>Decode-then-reencode produces byte-identical buffer</li>
                    seg.setAtIndex(ValueLayout.JAVA_LONG, i, values[i]);
                assertEquals(values[52], cs.getMetadataCache().sizeLimitBytes);  
            StreamInput in = out.bytes().streamInput();
                    cpuRuntime.totalPollsCount,
            BytesStreamOutput out = new BytesStreamOutput();
                for (int i = 0; i < decoded.length; i++) {
                assertEquals(values[8], ioRuntime.totalLocalQueueDepth);
            nonNegLong(),
        long[] arr = randomFieldArray();  
        return arr;
        return new TaskMonitorStats(nonNegLong(), nonNegLong(), nonNegLong(), nonNegLong(), nonNegLong());
                    cpuRuntime.blockingQueueDepth,  
            }
import org.opensearch.be.datafusion.stats.TaskMonitorStats;  
                var cpuRuntime = StatsLayout.readRuntimeMetrics(original, "cpu_runtime");
            nonNegLong()  
                    cs.getOffsetIndexCache().missCount,  
    private long[] randomFieldArrayWithCpuWorkersZero() {
                assertEquals(values[39], feg.activePermits);
                assertEquals(values[66], cs.getOffsetIndexCache().memoryBytes);
                    cs.getOffsetIndexCache().memoryBytes,
                var qe = StatsLayout.readTaskMonitor(original, "query_execution");  
                    cs.getStatisticsCache().memoryBytes,
            original.writeTo(out);  
                var ioRuntime = StatsLayout.readRuntimeMetrics(seg, "io_runtime");
            nonNegLong(),  
                assertEquals(values[51], cs.getMetadataCache().memoryBytes);
 * <p>Validates the three correctness properties from the ffm-struct-layout design:
            NativeExecutorsStats deserialized = new NativeExecutorsStats(in);
                    ss.prefetchWaitCount,
            NativeExecutorsStats original = randomNativeExecutorsStatsWithCpu();
        for (int t = 0; t < TRIES; t++) {  
                }  
                assertEquals(values[68], ss.listingTableScan);
        return arr;
                // Adaptive budget (offsets 46-47)
 * <ol>  
            nonNegLong(),
                    cs.getOffsetIndexCache().sizeLimitBytes,  
    public void testPackThenDecodeRoundTripWithCpu() {
                    // fragment_executor_gate (8)
                assertEquals(values[47], bs.rejections);
                    qe.instrumentedCount,
 * The OpenSearch Contributors require contributions made to  
        monitors.put("query_execution", randomTaskMonitorStats());
                    bs.rejections,  
                    var tm = StatsLayout.readTaskMonitor(seg, tmGroups[g]);
                    // cache_stats.metadata_cache (5)
import org.opensearch.core.common.io.stream.StreamInput;
                }  
                    ss.rgProcessed,  
    }
            nonNegLong(),
                assertEquals(values[13], cpuRuntime.globalQueueDepth);  
                    cs.getStatisticsCache().hitCount,
 * compatible open source license.
                assertEquals(values[58], cs.getColumnIndexCache().hitCount);  
import java.lang.foreign.Arena;  
                assertEquals(values[54], cs.getStatisticsCache().missCount);
        monitors.put("plan_setup", randomTaskMonitorStats());  
                byte[] reencodedBytes = reencoded.asSlice(0, (long) FIELD_COUNT * Long.BYTES).toArray(ValueLayout.JAVA_BYTE);
                    ioRuntime.numAliveTasks,  
        );
                assertEquals(values[7], ioRuntime.spawnedTasksCount);
                    // cache_stats.statistics_cache (5)
                    ss.buildMaskTimeMs,  
                    cs.getColumnIndexCache().hitCount,
                assertEquals(values[6], ioRuntime.numAliveTasks);  
                var cs = StatsLayout.readCacheStats(seg);
                    cs.getColumnIndexCache().memoryBytes,
                assertEquals(values[59], cs.getColumnIndexCache().missCount);
                assertEquals(values[42], feg.poisonPermits);
                // Write original values
    }  
                    cr.totalPollDurationMs,
                assertNull("cpuRuntime must be null when workers_count == 0", cpuRuntime);  
                    feg.targetMaxPermits,
            nonNegLong(),
                assertEquals(values[12], cpuRuntime.totalOverflowCount);
            try (var arena = Arena.ofConfined()) {
                // Re-encode into new buffer
                assertTrue("cpu workers should be > 0", cpuWorkers > 0);
                var original = arena.allocate(StatsLayout.LAYOUT);  
                // Decode all fields
                assertEquals(values[0], ioRuntime.workersCount);  
        arr[9] = 0; // cpu_runtime.workers_count = 0
                assertNotNull(cpuRuntime);
            nonNegLong(),  
                var ps = StatsLayout.readTaskMonitor(original, "plan_setup");
                    cs.getMetadataCache().memoryBytes,
    public void testWriteableRoundTripWithCpu() throws IOException {  
    }  
                    cr.droppedCount,  
                    feg.totalWaitDurationMs,
                var ss = StatsLayout.readSearchStats(seg);  
                assertEquals(values[69], ss.singleCollectorScan);
    }
                    cpuRuntime.totalBusyDurationMs,  
                assertEquals(values[11], cpuRuntime.totalBusyDurationMs);
            long[] values = randomFieldArrayWithCpuWorkersZero();  
        for (int t = 0; t < TRIES; t++) {
                    cs.getMetadataCache().entryCount,
                    ss.filterRecordBatchTimeMs,
 * </ol>
                long[] decoded = {
                var feg = StatsLayout.readPartitionGate(seg, "fragment_executor_gate");  
        for (int i = 0; i < FIELD_COUNT; i++) {
        for (int t = 0; t < TRIES; t++) {
                assertArrayEquals("Decode-then-reencode must produce byte-identical buffer", originalBytes, reencodedBytes);
                    bs.fallbacks,
                assertEquals(values[79], ss.prefetchWaitCount);  
                assertEquals(values[64], cs.getOffsetIndexCache().missCount);  
 * Randomized tests for {@link StatsLayout} struct decode.  
 *   <li>Writeable serialization round-trip</li>  
                    ps.totalScheduledDurationMs,  
                String[] tmGroups = { "coordinator_reduce", "query_execution", "stream_next", "plan_setup" };  
package org.opensearch.be.datafusion.nativelib;
                    feg.maxPermits,
                    cs.getStatisticsCache().sizeLimitBytes,  
            nonNegLong(),
            nonNegLong(),
            assertEquals("Writeable round-trip must produce equal object", original, deserialized);
        return monitors;
                assertEquals(values[65], cs.getOffsetIndexCache().entryCount);
        }
                assertEquals(values[38], feg.maxPermits);
                // Compare byte-for-byte over the full buffer
            assertEquals("Writeable round-trip must produce equal object", original, deserialized);  
import org.opensearch.be.datafusion.stats.NativeExecutorsStats;
                    cs.getOffsetIndexCache().hitCount,
                    // query_execution (5)
                assertEquals(values[56], cs.getStatisticsCache().memoryBytes);
                    sn.totalPollDurationMs,
    private NativeExecutorsStats randomNativeExecutorsStatsNoCpu() {
                if (cpuWorkers > 0) {  
                assertEquals(values[43], feg.targetMaxPermits);  
                    cpuRuntime.workersCount,
            nonNegLong(),
            original.writeTo(out);
        arr[9] = randomLongBetween(1, Long.MAX_VALUE / 2); // ensure cpu_runtime.workers_count > 0
        return new RuntimeMetrics(  
                assertEquals(values[75], ss.parquetScanUntilDataTimeMs);
                assertEquals(values[62], cs.getColumnIndexCache().sizeLimitBytes);
                assertEquals(values[15], cpuRuntime.numAliveTasks);
                    feg.pendingAcquireBatches,  
                assertEquals(values[46], bs.fallbacks);  
                    ss.delegationCalls,
                var ss = StatsLayout.readSearchStats(original);  
        );  
                for (int i = 0; i < FIELD_COUNT; i++) {
    public void testWriteableRoundTripNoCpu() throws IOException {
                    cs.getMetadataCache().missCount,  
                assertEquals(values[2], ioRuntime.totalBusyDurationMs);
        }
                assertEquals(values[60], cs.getColumnIndexCache().entryCount);
            nonNegLong(),
                    assertEquals(tmGroups[g] + ".dropped_count", values[base + 4], tm.droppedCount);
                    ioRuntime.totalLocalQueueDepth,
        monitors.put("stream_next", randomTaskMonitorStats());
                assertEquals(values[55], cs.getStatisticsCache().entryCount);  
        return new NativeExecutorsStats(randomRuntimeMetrics(), null, randomTaskMonitors());  
    }
                    seg.setAtIndex(ValueLayout.JAVA_LONG, i, values[i]);
                    // io_runtime (9)
                    ioRuntime.globalQueueDepth,
                var ioRuntime = StatsLayout.readRuntimeMetrics(original, "io_runtime");  
                    ioRuntime.totalPollsCount,
public class StatsLayoutPropertyTests extends OpenSearchTestCase {  
                    ss.parquetProcessingTimeMs,
                    assertEquals(tmGroups[g] + ".total_poll_duration_ms", values[base], tm.totalPollDurationMs);
    }
    }  
            nonNegLong(),
                    assertEquals(tmGroups[g] + ".total_scheduled_duration_ms", values[base + 1], tm.totalScheduledDurationMs);
            NativeExecutorsStats original = randomNativeExecutorsStatsNoCpu();
                }  
                var seg = arena.allocate(StatsLayout.LAYOUT);
            nonNegLong(),  
                var cr = StatsLayout.readTaskMonitor(original, "coordinator_reduce");
    private long nonNegLong() {
        for (int t = 0; t < TRIES; t++) {  
                    feg.totalBatchesStarted,
                assertEquals(values[76], ss.parquetProcessingTimeMs);  
                var feg = StatsLayout.readPartitionGate(original, "fragment_executor_gate");  
                    ps.droppedCount,  
                    // cache_stats.column_index_cache (5)
                    ioRuntime.workersCount,  
                    cs.getColumnIndexCache().missCount,  
                    ss.parquetScanUntilDataTimeMs,  
import org.opensearch.be.datafusion.stats.RuntimeMetrics;
                    qe.droppedCount,  
                    ioRuntime.totalBusyDurationMs,
                    cpuRuntime.spawnedTasksCount,
                assertEquals(values[17], cpuRuntime.totalLocalQueueDepth);
                    cr.totalIdleDurationMs,
                    ss.listingTableScan,
                    ss.singleCollectorScan,  
    }  
                var bs = StatsLayout.readAdaptiveBudgetStats(seg);
                assertEquals(values[3], ioRuntime.totalOverflowCount);  
 *
            assertNull("CPU runtime must be null", deserialized.getCpuRuntime());
        long[] arr = new long[FIELD_COUNT];
                    ss.onBatchMaskTimeMs,
                assertEquals(values[57], cs.getStatisticsCache().sizeLimitBytes);
                    // adaptive_budget (2)
        return arr;
                    qe.totalScheduledDurationMs,  
 * SPDX-License-Identifier: Apache-2.0
            long[] values = randomFieldArray();  
                // Partition gate (offsets 38-45)
                RuntimeMetrics cpuRuntime = null;
        return randomLongBetween(0, Long.MAX_VALUE / 2);  
    private NativeExecutorsStats randomNativeExecutorsStatsWithCpu() {
}
        return new RuntimeMetrics(
                    feg.poisonPermits,  
        }
                    cpuRuntime.totalLocalQueueDepth,  
        Map<String, TaskMonitorStats> monitors = new LinkedHashMap<>();
import java.lang.foreign.ValueLayout;
            }  
                assertEquals(values[1], ioRuntime.totalPollsCount);
                // Search stats (offsets 68-84)
            nonNegLong(),
    }
 *   <li>Pack-then-decode round-trip preserves all fields</li>
                    cs.getColumnIndexCache().entryCount,
                assertEquals(values[5], ioRuntime.blockingQueueDepth);
                }
                assertEquals(0L, cpuWorkers);
                assertEquals(values[70], ss.bitmapTreeScan);  
    // ---- Property 2: Decode-then-reencode identity ----
                assertEquals(values[82], ss.onBatchMaskTimeMs);  
        }
                    ss.parquetBytesScanned,
                    assertEquals(tmGroups[g] + ".instrumented_count", values[base + 3], tm.instrumentedCount);
/*  
/**
                assertEquals(values[78], ss.prefetchWaitTimeMs);
                    cpuRuntime.totalOverflowCount,
    private RuntimeMetrics randomRuntimeMetricsWithPositiveWorkers() {
                    cs.getColumnIndexCache().sizeLimitBytes,  
                    cs.getStatisticsCache().missCount,  
            nonNegLong(),  
            randomLongBetween(1, Long.MAX_VALUE / 2),  
import java.io.IOException;
    private static final int TRIES = 100;
                assertEquals(values[10], cpuRuntime.totalPollsCount);  
                for (int i = 0; i < FIELD_COUNT; i++) {
                assertEquals(values[83], ss.filterRecordBatchTimeMs);
                    cpuRuntime.globalQueueDepth,
                byte[] originalBytes = original.asSlice(0, (long) FIELD_COUNT * Long.BYTES).toArray(ValueLayout.JAVA_BYTE);  
            }  
                    ss.bitmapTreeScan,
    private TaskMonitorStats randomTaskMonitorStats() {  
            StreamInput in = out.bytes().streamInput();
    private RuntimeMetrics randomRuntimeMetrics() {
                assertEquals(values[48], cs.getMetadataCache().hitCount);
    }  
                    feg.pendingAcquirePermits,
                long cpuWorkers = StatsLayout.readField(seg, "cpu_runtime", "workers_count");
