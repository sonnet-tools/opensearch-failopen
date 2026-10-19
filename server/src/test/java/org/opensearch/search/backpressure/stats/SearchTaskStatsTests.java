                assertEquals(original, deserialized);  
import org.opensearch.search.backpressure.trackers.TaskResourceUsageTrackerType;  
            original.writeTo(out);
        SearchTaskStats original = new SearchTaskStats(cancellations, limitReached, completions, withNative);
    }
        TaskResourceUsageTracker.Stats nativeMem = new NativeMemoryUsageTracker.Stats(11L, 12L, 13L);  
            }
        long limitReached = 3L;  
import org.opensearch.core.common.io.stream.Writeable;
    protected SearchTaskStats createTestInstance() {  
import org.opensearch.search.backpressure.trackers.TaskResourceUsageTrackers.TaskResourceUsageTracker;
            try (StreamInput in = out.bytes().streamInput()) {
import java.util.Map;
            TaskResourceUsageTrackerType.HEAP_USAGE_TRACKER,
     * <p>To assert this without reaching into private fields, we construct a deterministic  
        Map<TaskResourceUsageTrackerType, TaskResourceUsageTracker.Stats> resourceUsageTrackerStats = Map.of(
                in.setVersion(Version.V_3_6_0);  
                assertEquals("pre-V_3_7_0 wire must drop the native-memory tracker entry but preserve the others", expected, deserialized);
    @Override
                SearchTaskStats deserialized = new SearchTaskStats(in);
            new NativeMemoryUsageTracker.Stats(randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong())
public class SearchTaskStatsTests extends AbstractWireSerializingTestCase<SearchTaskStats> {
 * this file be licensed under the Apache-2.0 license or a
        TaskResourceUsageTracker.Stats elapsed = new ElapsedTimeTracker.Stats(8L, 9L, 10L);
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            new CpuUsageTracker.Stats(randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong()),
import org.opensearch.search.backpressure.trackers.ElapsedTimeTracker;  
 * SPDX-License-Identifier: Apache-2.0
/*  
     * V_3_7_0 round-trip must preserve the native-memory entry verbatim.
        long completions = 11L;
            }  
            new ElapsedTimeTracker.Stats(randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong()),
package org.opensearch.search.backpressure.stats;
        return SearchTaskStats::new;
            out.setVersion(Version.V_3_7_0);
        TaskResourceUsageTracker.Stats heap = new HeapUsageTracker.Stats(4L, 5L, 6L, 7L);
    protected Writeable.Reader<SearchTaskStats> instanceReader() {
     * trip via the older wire version MUST drop that entry rather than corrupting the stream;  
        }
import org.opensearch.Version;
    }  
    @Override  
 * compatible open source license.
     *
        withNative.put(TaskResourceUsageTrackerType.NATIVE_MEMORY_USAGE_TRACKER, nativeMem);  
        withNative.put(TaskResourceUsageTrackerType.CPU_USAGE_TRACKER, cpu);  
            TaskResourceUsageTrackerType.CPU_USAGE_TRACKER,  
    public void testNativeMemoryEntryRoundTripsOnV37Wire() throws Exception {
        TaskResourceUsageTracker.Stats cpu = new CpuUsageTracker.Stats(1L, 2L, 3L);  
 */  
     * Pre-V_3_7_0 nodes don't recognize the {@code NATIVE_MEMORY_USAGE_TRACKER} entry. A round
        Map<TaskResourceUsageTrackerType, TaskResourceUsageTracker.Stats> withoutNative = new HashMap<>(withNative);
        long cancellations = 7L;
     */  
                SearchTaskStats deserialized = new SearchTaskStats(in);
        withNative.put(TaskResourceUsageTrackerType.HEAP_USAGE_TRACKER, heap);
import org.opensearch.core.common.io.stream.StreamInput;  
        return randomInstance();
        SearchTaskStats original = randomInstance();
import org.opensearch.search.backpressure.trackers.HeapUsageTracker;
    }  
    }
import java.util.HashMap;
     */  
import org.opensearch.search.backpressure.trackers.CpuUsageTracker;
 *
import org.opensearch.common.io.stream.BytesStreamOutput;
        withNative.put(TaskResourceUsageTrackerType.ELAPSED_TIME_TRACKER, elapsed);
        }
     * input plus a parallel "expected" instance that omits the native-memory entry. Equality
        SearchTaskStats expected = new SearchTaskStats(cancellations, limitReached, completions, withoutNative);  
            try (StreamInput in = out.bytes().streamInput()) {  
    /**
        );
     * the remaining trackers MUST round-trip unchanged.
            new HeapUsageTracker.Stats(randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong()),  
        withoutNative.remove(TaskResourceUsageTrackerType.NATIVE_MEMORY_USAGE_TRACKER);  
                in.setVersion(Version.V_3_7_0);
        Map<TaskResourceUsageTrackerType, TaskResourceUsageTracker.Stats> withNative = new HashMap<>();
import org.opensearch.test.AbstractWireSerializingTestCase;
            TaskResourceUsageTrackerType.NATIVE_MEMORY_USAGE_TRACKER,  
        return new SearchTaskStats(randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong(), resourceUsageTrackerStats);
import org.opensearch.search.backpressure.trackers.NativeMemoryUsageTracker;
            original.writeTo(out);
     * via {@link SearchTaskStats#equals} then exercises the same invariants.
}
    }
 * The OpenSearch Contributors require contributions made to  
    /**
    public static SearchTaskStats randomInstance() {
            TaskResourceUsageTrackerType.ELAPSED_TIME_TRACKER,
    public void testNativeMemoryEntryDroppedOnPreV37Wire() throws Exception {
            out.setVersion(Version.V_3_6_0);  
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
