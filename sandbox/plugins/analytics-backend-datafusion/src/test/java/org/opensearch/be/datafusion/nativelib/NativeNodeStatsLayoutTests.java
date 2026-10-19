                assertEquals(
     * Validates: Requirements 4.4  
    // ========== Task 3.3: Unit Tests ==========  
        assertEquals(4 * Long.BYTES, (int) NativeNodeStatsLayout.LAYOUT.byteSize());
            assertEquals(7L, stats.getSearchShardTaskCurrent());  
            AnalyticsBackendTaskCancellationStats stats = NativeNodeStatsLayout.readNativeNodeStats(seg);  
                assertEquals("Iteration " + i + ": native_search_task_total mismatch", searchTaskTotal, stats.getSearchTaskTotal());  
     * Validates: Requirements 4.4  
     * Verify readNativeNodeStats handles Long.MAX_VALUE correctly.
}
        }  
    }
        assertEquals(32L, NativeNodeStatsLayout.LAYOUT.byteSize());
            // All zeros by default after allocation  
    /**
     * Validates: Requirements 4.4  
        final int iterations = 100;
     * **Property 4: NativeNodeStatsLayout decode matches byte offsets**  
    public void testPropertyDecodeMatchesByteOffsets() {  
 * Unit and property-based tests for {@link NativeNodeStatsLayout}.
    /**
            assertEquals(Long.MAX_VALUE, stats.getSearchTaskCurrent());
                    shardTaskCurrent,  
    }
            assertEquals(100L, stats.getSearchTaskTotal());
                    shardTaskTotal,
     */
                );
     * <p>**Validates: Requirements 4.4**
    /**
     *
    // ========== Task 3.4: Property Test ==========  
            long shardTaskCurrent = randomLong();  
     */
            assertEquals(Long.MAX_VALUE, stats.getSearchShardTaskTotal());
            try (var arena = Arena.ofConfined()) {  
                seg.setAtIndex(ValueLayout.JAVA_LONG, 0, searchTaskCurrent);   // offset 0
            seg.setAtIndex(ValueLayout.JAVA_LONG, 2, Long.MAX_VALUE);  
     *  
            var seg = arena.allocate(NativeNodeStatsLayout.LAYOUT);
    public void testLayoutByteSizeIs32() {  
            seg.setAtIndex(ValueLayout.JAVA_LONG, 1, Long.MAX_VALUE);
            assertEquals(42L, stats.getSearchTaskCurrent());
    }  
        try (var arena = Arena.ofConfined()) {
            assertEquals(0L, stats.getSearchShardTaskCurrent());  
        try (var arena = Arena.ofConfined()) {
                // Write random values at the expected byte offsets  
                seg.setAtIndex(ValueLayout.JAVA_LONG, 1, searchTaskTotal);     // offset 8
    }  
                    stats.getSearchShardTaskCurrent()
            seg.setAtIndex(ValueLayout.JAVA_LONG, 0, Long.MAX_VALUE);
     */  
        }
    /**
                assertEquals(  
                var seg = arena.allocate(NativeNodeStatsLayout.LAYOUT);
import org.opensearch.test.OpenSearchTestCase;
 */  
     * Verify readNativeNodeStats handles zero values correctly.
            AnalyticsBackendTaskCancellationStats stats = NativeNodeStatsLayout.readNativeNodeStats(seg);
            seg.setAtIndex(ValueLayout.JAVA_LONG, 1, 100L);  // offset 8: native_search_task_total
 * compatible open source license.
            assertEquals(0L, stats.getSearchTaskTotal());
            long searchTaskTotal = randomLong();
            assertEquals(Long.MAX_VALUE, stats.getSearchTaskTotal());  
     */
     * Writes known long values at offsets 0, 8, 16, 24 and asserts decoded fields match.
            seg.setAtIndex(ValueLayout.JAVA_LONG, 3, 999L);  // offset 24: native_search_shard_task_total  
            seg.setAtIndex(ValueLayout.JAVA_LONG, 3, Long.MAX_VALUE);
 *
            assertEquals(Long.MAX_VALUE, stats.getSearchShardTaskCurrent());
            AnalyticsBackendTaskCancellationStats stats = NativeNodeStatsLayout.readNativeNodeStats(seg);
                    stats.getSearchShardTaskTotal()  
                );
/*  
package org.opensearch.be.datafusion.nativelib;
 * <p>Task 3.4: Property test verifying decode matches byte offsets for random values.
                seg.setAtIndex(ValueLayout.JAVA_LONG, 3, shardTaskTotal);      // offset 24
                AnalyticsBackendTaskCancellationStats stats = NativeNodeStatsLayout.readNativeNodeStats(seg);  
 * this file be licensed under the Apache-2.0 license or a
    public void testReadNativeNodeStatsDecodesMaxValues() {  
                assertEquals("Iteration " + i + ": native_search_task_current mismatch", searchTaskCurrent, stats.getSearchTaskCurrent());
     * Verify readNativeNodeStats decodes known byte patterns correctly.
            var seg = arena.allocate(NativeNodeStatsLayout.LAYOUT);
                    "Iteration " + i + ": native_search_shard_task_total mismatch",
     * <p>Generate random 32-byte segments, verify decoded fields match values at offsets 0, 8, 16, 24.
            assertEquals(0L, stats.getSearchShardTaskTotal());
    public void testReadNativeNodeStatsDecodesKnownValues() {
                seg.setAtIndex(ValueLayout.JAVA_LONG, 2, shardTaskCurrent);    // offset 16  
            long shardTaskTotal = randomLong();
                    "Iteration " + i + ": native_search_shard_task_current mismatch",
     * Validates: Requirements 4.2  
     * Verify LAYOUT.byteSize() == 32 (4 × JAVA_LONG).
            // Write known values at the 4 field positions (little-endian, native order for JAVA_LONG)
/**
            assertEquals(999L, stats.getSearchShardTaskTotal());
            seg.setAtIndex(ValueLayout.JAVA_LONG, 0, 42L);   // offset 0: native_search_task_current  
            var seg = arena.allocate(NativeNodeStatsLayout.LAYOUT);  
            assertEquals(0L, stats.getSearchTaskCurrent());
import java.lang.foreign.ValueLayout;
 *  
            }
    }  
        try (var arena = Arena.ofConfined()) {
        }
 * The OpenSearch Contributors require contributions made to  
 * <p>Task 3.3: Unit tests verifying layout size and decode correctness.
    /**
import org.opensearch.plugin.stats.AnalyticsBackendTaskCancellationStats;
     */
import java.lang.foreign.Arena;
    public void testReadNativeNodeStatsDecodesZeros() {  
            long searchTaskCurrent = randomLong();
 * SPDX-License-Identifier: Apache-2.0
        }  
 */  
public class NativeNodeStatsLayoutTests extends OpenSearchTestCase {
            seg.setAtIndex(ValueLayout.JAVA_LONG, 2, 7L);    // offset 16: native_search_shard_task_current
        for (int i = 0; i < iterations; i++) {  
