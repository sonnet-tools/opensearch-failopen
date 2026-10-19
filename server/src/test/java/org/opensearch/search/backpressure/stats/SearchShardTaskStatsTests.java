            }
import org.opensearch.search.backpressure.trackers.TaskResourceUsageTrackers.TaskResourceUsageTracker;
            original.writeTo(out);
import org.opensearch.core.common.io.stream.StreamInput;  
     * Pre-V_3_7_0 nodes don't recognize the {@code NATIVE_MEMORY_USAGE_TRACKER} entry. A round  
            }
            try (StreamInput in = out.bytes().streamInput()) {  
        TaskResourceUsageTracker.Stats elapsed = new ElapsedTimeTracker.Stats(8L, 9L, 10L);  
import org.opensearch.search.backpressure.trackers.ElapsedTimeTracker;  
        SearchShardTaskStats original = new SearchShardTaskStats(cancellations, limitReached, completions, withNative);  
        TaskResourceUsageTracker.Stats cpu = new CpuUsageTracker.Stats(1L, 2L, 3L);
/*  
        long completions = 11L;
            original.writeTo(out);  
        long limitReached = 3L;
 *
import org.opensearch.test.AbstractWireSerializingTestCase;
     * V_3_7_0 round-trip must preserve the native-memory entry verbatim.  
import org.opensearch.search.backpressure.trackers.TaskResourceUsageTrackerType;  
    }  
import org.opensearch.search.backpressure.trackers.NativeMemoryUsageTracker;
    public void testNativeMemoryEntryRoundTripsOnV37Wire() throws Exception {
                in.setVersion(Version.V_3_7_0);
            TaskResourceUsageTrackerType.NATIVE_MEMORY_USAGE_TRACKER,
        Map<TaskResourceUsageTrackerType, TaskResourceUsageTracker.Stats> resourceUsageTrackerStats = Map.of(
import java.util.Map;
 * this file be licensed under the Apache-2.0 license or a
            out.setVersion(Version.V_3_6_0);
            TaskResourceUsageTrackerType.ELAPSED_TIME_TRACKER,  
                SearchShardTaskStats deserialized = new SearchShardTaskStats(in);  
public class SearchShardTaskStatsTests extends AbstractWireSerializingTestCase<SearchShardTaskStats> {
     * <p>To assert this without reaching into private fields, we construct a deterministic
 * The OpenSearch Contributors require contributions made to  
    }
    @Override
     * via {@link SearchShardTaskStats#equals} then exercises the same invariants.  
            new NativeMemoryUsageTracker.Stats(randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong())  
        withNative.put(TaskResourceUsageTrackerType.ELAPSED_TIME_TRACKER, elapsed);  
            new ElapsedTimeTracker.Stats(randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong()),
     * input plus a parallel "expected" instance that omits the native-memory entry. Equality
            TaskResourceUsageTrackerType.HEAP_USAGE_TRACKER,
    public static SearchShardTaskStats randomInstance() {  
    protected SearchShardTaskStats createTestInstance() {
            randomNonNegativeLong(),
            out.setVersion(Version.V_3_7_0);
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
        return randomInstance();  
    }
        long cancellations = 7L;  
            new HeapUsageTracker.Stats(randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong()),
     */
import java.util.HashMap;
                assertEquals(original, deserialized);
        TaskResourceUsageTracker.Stats heap = new HeapUsageTracker.Stats(4L, 5L, 6L, 7L);
        return SearchShardTaskStats::new;
import org.opensearch.core.common.io.stream.Writeable;
            TaskResourceUsageTrackerType.CPU_USAGE_TRACKER,
import org.opensearch.common.io.stream.BytesStreamOutput;
        );
                in.setVersion(Version.V_3_6_0);
     * the remaining trackers MUST round-trip unchanged.
}
            resourceUsageTrackerStats
                assertEquals("pre-V_3_7_0 wire must drop the native-memory tracker entry but preserve the others", expected, deserialized);  
import org.opensearch.search.backpressure.trackers.HeapUsageTracker;
        );
            randomNonNegativeLong(),  
 * compatible open source license.
                SearchShardTaskStats deserialized = new SearchShardTaskStats(in);
    public void testNativeMemoryEntryDroppedOnPreV37Wire() throws Exception {
            try (StreamInput in = out.bytes().streamInput()) {
        }
        TaskResourceUsageTracker.Stats nativeMem = new NativeMemoryUsageTracker.Stats(11L, 12L, 13L);
            randomNonNegativeLong(),
import org.opensearch.search.backpressure.trackers.CpuUsageTracker;
        SearchShardTaskStats original = randomInstance();  
    }  
        return new SearchShardTaskStats(  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
     * trip via the older wire version MUST drop that entry rather than corrupting the stream;
import org.opensearch.Version;
    @Override
        }  
    /**
     */
        withNative.put(TaskResourceUsageTrackerType.NATIVE_MEMORY_USAGE_TRACKER, nativeMem);
        withoutNative.remove(TaskResourceUsageTrackerType.NATIVE_MEMORY_USAGE_TRACKER);
        Map<TaskResourceUsageTrackerType, TaskResourceUsageTracker.Stats> withNative = new HashMap<>();  
     *  
 */  
        withNative.put(TaskResourceUsageTrackerType.CPU_USAGE_TRACKER, cpu);
    /**
            new CpuUsageTracker.Stats(randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong()),  
        Map<TaskResourceUsageTrackerType, TaskResourceUsageTracker.Stats> withoutNative = new HashMap<>(withNative);  
package org.opensearch.search.backpressure.stats;
    protected Writeable.Reader<SearchShardTaskStats> instanceReader() {  
        SearchShardTaskStats expected = new SearchShardTaskStats(cancellations, limitReached, completions, withoutNative);
        withNative.put(TaskResourceUsageTrackerType.HEAP_USAGE_TRACKER, heap);
    }
 * SPDX-License-Identifier: Apache-2.0
