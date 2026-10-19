     * native side wrote into its respective FFM section. Independent values per field per
        assertEquals(400L, meta.missBytes());
        FoyerAggregatedStats s = FoyerAggregatedStats.snapshotTiered(raw, 1000L, 200L);
        assertEquals(0L, s.hits());
        long eb0,
 *   [7] REMOVED_COUNT  [8] REMOVED_BYTES  [9] ACTIVE_IN_BYTES
        long[] raw = buf(0, 0, 0, 0, 0, 0, 0, 0, 0, 123L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 456L);
        assertEquals(380_000L, s.dataCapacityBytes());
            0,
    }
        assertEquals(  
    public void testCompleteProjection() {  
        assertEquals(
            0,
 */
        assertEquals(2048L, blockLevel.diskBytesUsed());  
        assertEquals(4096L, overall.diskBytesUsed());  
    }  
        long eb1,  
            0,
    // ── capacityBytes ─────────────────────────────────────────────────────────  
}  
    }
        // section 0 activeInBytes = 123, section 1 activeInBytes = 456
        assertEquals(0L, FoyerAggregatedStats.snapshot(uniform(10, 100, 5, 50, 2, 20, 500), 1000L).overallStats().removedBytes());
            0,  
    public void testLargeValuesNoCorruption() {
    }
        FoyerAggregatedStats s = FoyerAggregatedStats.snapshotTiered(raw, 1000L, 100L);
        // evictionBytes=50, used=500, removed=5, removedBytes=50, active=0
            0,
            -1L,   // section 0: activeInBytes = -1  
    }
        long mb0,
        long[] raw = buf(0, 0, 0, 0, 0, 0, 800, 0, 0, 0, 0, 0, 0, 0, 0, 0, 50, 0, 0, 0);
            0,  
        long[] raw = buf(10, 100, 3, 300, 1, 50, 500, 5, 50, 0, 20, 200, 4, 400, 2, 80, 100, 11, 110, 0);
        long rb1,
        assertEquals(7L, overall.misses());
        assertEquals(5L, bc.evictions());
        assertEquals(100L, s.dataCacheStats().hitBytes());
        return buf(hc0, hb0, mc0, mb0, ec0, eb0, ub0, 0, 0, 0, hc1, hb1, mc1, mb1, ec1, eb1, ub1, 0, 0, 0);  
    public void testZeroActiveInBytesPassesThrough() {
    public void testHitBytesFromIndex1() {
    public void testCapacityPassedToBlockLevel() {  
        assertEquals(22L, bl.hitBytes());
        assertEquals(0L, s.evictions());
    /**
    public void testUsedBytesFromIndex6() {  
    }
        long mc1,
        long hc1,
    // ── Post-refactor: per-tier accessors return their sections directly ─────  
        assertNotNull("metadataCacheStats must be non-null in tiered mode", s.metadataCacheStats());  
    public void testMemoryBytesUsedAlwaysZeroOverall() {
        assertEquals(50L, data.evictionBytes());  
        BlockCacheStats s = FoyerAggregatedStats.snapshot(new long[20], 0L).overallStats();
    }
            0,
        assertEquals(0L, bc.memoryBytesUsed());
        assertEquals(0L, FoyerAggregatedStats.snapshot(raw, 0L).overallStats().activeInBytes());
        BlockCacheStats s = FoyerAggregatedStats.snapshot(uniform(large, large, large, large, large, large, large), large).overallStats();
        long ec1,
    public void testBlockLevelAllFieldsMapped() {  
        assertEquals(123L, FoyerAggregatedStats.snapshot(raw, 0L).overallStats().activeInBytes());  
        FoyerAggregatedStats s = FoyerAggregatedStats.snapshotTiered(raw, 1000L, 100L);
            0
        long ub0,
        assertEquals(33L, bl.misses());
        assertEquals(110L, meta.removedBytes());  
        assertNotNull(FoyerAggregatedStats.snapshot(new long[20], 0L).overallStats());  
    public void testActiveInBytesDefaultsToZero() {
        long eb1,
        assertEquals(large, s.diskBytesUsed());  
        assertEquals(30L, overall.hits());  
        assertEquals(55L, bl.evictions());
    }
    }  
        assertEquals(2L, meta.evictions());  
    // ── Large values ──────────────────────────────────────────────────────────  
    private static long[] buf(  
        assertEquals(4096L, bc.diskBytesUsed());  
/*  
        assertEquals(0L, s.misses());  
        long mc0,
        assertNotNull(FoyerAggregatedStats.snapshot(new long[20], 0L));
    // ── activeInBytes defensive clamping ──────────────────────────────────────
    }
        assertEquals(20_000L, s.metadataCapacityBytes());
     * directly (no subtraction-from-overall), each accessor must return exactly what the
        BlockCacheStats data = s.dataCacheStats();  
    // ── Foyer-specific zero fields ─────────────────────────────────────────────
    public void testSnapshotTieredNonNull() {
 * The OpenSearch Contributors require contributions made to  
            2048L,
        assertEquals(100L, meta.diskBytesUsed());
    }
    }
        long hb1,
    /**
    public void testNegativeActiveInBytesClampsToZero() {
    /** A zero activeInBytes must pass through unchanged (not over-clamped). */
        assertEquals(150L, s.overallStats().hitBytes());  
    /** Builds a symmetric buffer where both sections are identical and active=0. */  
        assertEquals(600L, overall.diskBytesUsed());
    }  
    }
    public void testCapacityPassedToOverall() {
    }
     */
        assertEquals(3L, data.misses());  
        assertEquals(44L, bl.missBytes());  
    public void testSnapshotTieredDataCacheStats() {  
            777L,   // section 0: activeInBytes=777
        assertEquals(0L, FoyerAggregatedStats.snapshot(uniform(10, 100, 5, 50, 2, 20, 500), 1000L).overallStats().memoryBytesUsed());
        long mc1,  
        assertEquals(200L, bc.missBytes());  
 * library. Any field-ordinal bug would be caught here.
            0,  
        assertEquals(512L, FoyerAggregatedStats.snapshot(buf(0, 0, 0, 512, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 1L).overallStats().missBytes());
        BlockCacheStats bc = FoyerAggregatedStats.snapshot(raw, 8192L).overallStats();
        long[] raw = buf(
    public void testAllZeroBuffer() {  
        long mb1,
        assertEquals(4L, meta.misses());
 *   [0] HIT_COUNT  [1] HIT_BYTES  [2] MISS_COUNT  [3] MISS_BYTES
            0,
        assertEquals(0L, bc.activeInBytes());
            0,
    ) {  
 * compatible open source license.
        assertEquals(160L, overall.removedBytes());  
        long ub1,
        assertEquals(0L, bc.removed());  
        assertEquals(15L, s.overallStats().hits());
 * Unit tests for {@link FoyerAggregatedStats}.
    }
    }
 * SPDX-License-Identifier: Apache-2.0
    public void testSnapshotTieredOverallUsedBytesIsSumOfBoth() {  
    }
        assertTrue("snapshotTiered must be flagged tiered", s.isTiered());
    }
        FoyerAggregatedStats s = FoyerAggregatedStats.snapshotTiered(raw, 1000L, 200L);  
        // A fresh 20-zero buffer should have activeInBytes == 0
        assertEquals(100L, data.hitBytes());
        long hb0,
            0,
        long eb0,  
        assertEquals(large, s.totalBytes());
    // ── Complete projection ───────────────────────────────────────────────────
    private static long[] uniform(long hc, long hb, long mc, long mb, long ec, long eb, long ub) {
            0,
        long hb1,  
        long rb0,  
        assertEquals(10L, s.overallStats().evictions());  
        long hc0,  
        assertEquals(200L, meta.hitBytes());  
        // Data tier — section 0 verbatim.
     * Cumulative counters (hits, misses, etc.) are NOT clamped — a negative there
            0,
        return new long[] { hc0, hb0, mc0, mb0, ec0, eb0, ub0, rc0, rb0, ai0, hc1, hb1, mc1, mb1, ec1, eb1, ub1, rc1, rb1, ai1 };
    public void testHitCountFromIndex0() {  
        // Metadata tier — section 1 verbatim, NOT (overall - data).  
        BlockCacheStats bl = FoyerAggregatedStats.snapshot(raw, 100L).blockLevelStats();
    }  
        assertEquals(999L, s.overallStats().evictions());
    }
            0,  
    }
        assertEquals(100L, overall.hits());
        assertEquals(42L, FoyerAggregatedStats.snapshot(buf(42, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 1L).overallStats().hits());
            0,  
            0,
public class FoyerAggregatedStatsTests extends OpenSearchTestCase {  
        assertEquals(1200L, overall.totalBytes());
    public void testSnapshotTieredIsTiered() {
        assertEquals(large, s.hits());
        assertEquals(200L, meta.totalBytes());
    }  
    public void testSnapshotTieredOverallEvictionsIsSumOfBoth() {  
        long mb1,
        assertEquals(3L, s.dataCacheStats().misses());
        assertEquals(1L, blockLevel.removed());
        long mb0,  
        assertEquals(10L, bc.misses());
 *  
        assertNotNull(FoyerAggregatedStats.snapshot(new long[20], 0L).blockLevelStats());
    }
        long hc0,
    public void testSnapshotNonNull() {
        assertEquals(850L, s.overallStats().diskBytesUsed());  
        assertNotNull(FoyerAggregatedStats.snapshotTiered(new long[20], 100L, 10L));
    }
        assertEquals(11L, meta.removed());
 *  
        long mc0,  
    public void testRemovedAlwaysZeroBlockLevel() {
        assertEquals(300L, overall.removedBytes());
        // Overall is the eager merge of both tiers.
            0,
        assertNotNull("dataCacheStats must be non-null in tiered mode", s.dataCacheStats());
        long[] raw = buf(10, 100, 3, 300, 1, 50, 500, 0, 0, 0, 5, 50, 2, 200, 0, 0, 100, 0, 0, 0);
    public void testZeroCapacity() {
        assertEquals(5L, s.metadataCacheStats().hits());
            0,
    }  
    }
            0,
        assertEquals(1000L, s.dataCacheStats().totalBytes());
        FoyerAggregatedStats s = FoyerAggregatedStats.snapshot(buf(10, 0, 0, 0, 0, 0, 0, 99, 0, 0, 0, 0, 0, 0), 1L);
    }
        assertEquals(0L, s.blockLevelStats().evictions());  
    /** A positive activeInBytes must pass through unchanged. */
    public void testActiveInBytesFromIndex9() {
    public void testStatsBufferSizeIs20() {  
        assertEquals(1024L, FoyerAggregatedStats.snapshot(buf(0, 1024, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 1L).overallStats().hitBytes());
        assertEquals(5L, data.removed());
        assertEquals(0L, FoyerAggregatedStats.snapshot(new long[20], 0L).overallStats().activeInBytes());  
        assertEquals(1_073_741_824L, FoyerAggregatedStats.snapshot(new long[20], 1_073_741_824L).overallStats().totalBytes());  
     */  
        assertTrue(FoyerAggregatedStats.snapshotTiered(new long[20], 100L, 10L).isTiered());  
        assertEquals(500L, s.dataCacheStats().diskBytesUsed());  
            0,
        assertEquals(500L, data.diskBytesUsed());  
        // Section 0 (data): hits=10, hitBytes=100, misses=3, missBytes=300, evictions=1,  
     * tier guard against any latent regression that re-introduces subtraction-based math.  
        assertNull("dataCacheStats must be null in single-cache mode", s.dataCacheStats());  
     * Foyer library or an FFM buffer misread) must be clamped to 0, not propagated.  
        // data: 10 hits, 100 hit_bytes | metadata: 5 hits, 50 hit_bytes
        BlockCacheStats overall = FoyerAggregatedStats.snapshot(raw, 8192L).overallStats();
    }  
        long[] raw = buf(100, 1000, 10, 200, 5, 500, 4096, 3, 300, 55L, 50, 500, 2, 100, 1, 200, 2048, 1, 150, 20L);
    // ── All-zeros ─────────────────────────────────────────────────────────────
        assertNull("metadataCacheStats must be null in single-cache mode", s.metadataCacheStats());
        );      // section 1: all zero  
            0,  
        assertEquals(0L, FoyerAggregatedStats.snapshot(uniform(10, 100, 5, 50, 2, 20, 500), 1000L).blockLevelStats().memoryBytesUsed());  
            0,
            0,  
        long[] raw = buf(0, 0, 0, 0, 0, 0, 0, 0, 0, 4096L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8192L);  
        assertEquals(3L, FoyerAggregatedStats.snapshot(buf(0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0), 1L).overallStats().evictions());
        assertEquals(4096L, FoyerAggregatedStats.snapshot(raw, 0L).overallStats().activeInBytes());
        long[] raw = buf(10, 100, 0, 0, 0, 0, 0, 0, 0, 0, 5, 50, 0, 0, 0, 0, 0, 0, 0, 0);  
        long[] raw = buf(0, 0, 0, 0, 0, 0, 0, 11, 22, 33, 44, 55, 66, 77);
    /** 16-arg shorthand: removed and active default to 0 for both sections. */
        );
    }
        FoyerAggregatedStats s = FoyerAggregatedStats.snapshot(new long[20], 1024L);
        assertEquals(20L, meta.hits());
        assertEquals(10L, data.hits());
        // 10 fields × 2 sections = 20. Verified here so changes to Field enum break tests fast.
        FoyerAggregatedStats s = FoyerAggregatedStats.snapshotTiered(raw, 1000L, 200L);
    public void testMemoryBytesUsedAlwaysZeroBlockLevel() {
    }
        );  
        assertEquals(0L, bc.removedBytes());
 */  
     */
        assertEquals(0L, FoyerAggregatedStats.snapshot(uniform(10, 100, 5, 50, 2, 20, 500), 1000L).overallStats().removed());
        assertEquals(80L, meta.evictionBytes());
        assertFalse("snapshot must not be flagged tiered", s.isTiered());
        assertEquals(0L, FoyerAggregatedStats.snapshot(new long[20], 0L).overallStats().totalBytes());
        long large = Long.MAX_VALUE / 2;  
        long ai0,
    }
    }
        assertEquals(0L, FoyerAggregatedStats.snapshot(uniform(10, 100, 5, 50, 2, 20, 500), 1000L).blockLevelStats().removedBytes());
            -999L   // section 1: activeInBytes = -999
        assertEquals(150L, blockLevel.removedBytes());
        assertEquals(7L, FoyerAggregatedStats.snapshot(buf(0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 1L).overallStats().misses());  
        assertEquals(0L, s.diskBytesUsed());
        assertEquals(8192L, bc.totalBytes());
        assertEquals(100L, s.metadataCacheStats().diskBytesUsed());
            0,
            0,  
        assertEquals(1000L, data.totalBytes());
        assertEquals(50L, blockLevel.hits());
            0,
        long ec1,  
        assertEquals(2L, s.metadataCacheStats().misses());  
    public void testRemovedAlwaysZeroOverall() {  
        assertEquals(50L, s.metadataCacheStats().hitBytes());
    }
    public void testSnapshotTieredCapacityBytes() {
    }  
        long ec0,
        long rc1,  
            999L,
            0,  
    /** Full 20-arg helper: 10 fields per section, 2 sections. */
        assertEquals(0L, s.activeInBytes());  
        assertEquals(99L, s.blockLevelStats().hits());  
        long[] raw = buf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0L);  
        // Full 20-field buffer with activeInBytes in section 0  
        long ub1
        assertEquals(11L, bl.hits());  
    public void testBlockLevelReadsFromSection1() {  
/**
        assertEquals(1000L, bc.hitBytes());
    public void testMissBytesFromIndex3() {  
        assertEquals(77L, bl.diskBytesUsed());  
    public void testSnapshotTieredMetadataCacheStats() {
        assertEquals(10L, s.dataCacheStats().hits());  
        assertEquals(20L, blockLevel.activeInBytes());  
        long[] raw = buf(  
     * indicates a real accounting bug and should remain visible.
        assertEquals(50L, data.removedBytes());
    // ── Tiered stats (snapshotTiered) ──────────────────────────────────────────
    public void testEvictionCountFromIndex4() {
     * In single-cache mode the per-tier accessors return {@code null}. Callers asking for  
        assertEquals(0L, FoyerAggregatedStats.snapshot(uniform(10, 100, 5, 50, 2, 20, 500), 1000L).blockLevelStats().removed());  
        // evictionBytes=80, used=100, removed=11, removedBytes=110, active=0  
        assertEquals(8192L, FoyerAggregatedStats.snapshot(raw, 0L).blockLevelStats().activeInBytes());
        assertEquals(3L, overall.removed());
        long ub0,  
            FoyerAggregatedStats.snapshot(buf(0, 0, 0, 0, 0, 0, 999, 0, 0, 0, 0, 0, 0, 0), 1L).overallStats().diskBytesUsed()  
    public void testActiveInBytesIsIndexedIndependentlyFromSection1() {  
    }  
        long hb0,
        assertEquals(200L, s.metadataCacheStats().totalBytes());
        assertEquals(10L, s.overallStats().hits());
import org.opensearch.plugins.BlockCacheStats;
        assertEquals(55L, overall.activeInBytes());  
    public void testBlockLevelStatsNonNull() {  
        BlockCacheStats blockLevel = FoyerAggregatedStats.snapshot(raw, 8192L).blockLevelStats();  
        long hc1,
            0,
    public void testEvictionBytesFromIndex5() {
 *   [4] EVICTION_COUNT  [5] EVICTION_BYTES  [6] USED_BYTES  
     * per-tier breakdown are expected to gate on {@link FoyerAggregatedStats#isTiered()}.
        assertEquals(500L, bc.evictionBytes());
        assertEquals(1L, data.evictions());
        // Section 1 (meta): hits=20, hitBytes=200, misses=4, missBytes=400, evictions=2,
    /**
        long[] raw = buf(10, 100, 3, 300, 1, 50, 500, 0, 0, 0, 5, 50, 2, 200, 0, 0, 100, 0, 0, 0);
    private static long[] buf(
        long ai1
        return buf(hc, hb, mc, mb, ec, eb, ub, 0, 0, 0, hc, hb, mc, mb, ec, eb, ub, 0, 0, 0);
     * After the refactor that stores {@code dataCacheStats} and {@code metadataCacheStats}  
        assertEquals(0L, FoyerAggregatedStats.snapshot(raw, 0L).overallStats().activeInBytes());  
    // ── STATS_BUFFER_SIZE contract ─────────────────────────────────────────────
        assertEquals(400_000L, s.overallStats().totalBytes());  
        FoyerAggregatedStats s = FoyerAggregatedStats.snapshotTiered(raw, 1000L, 200L);
        assertEquals(300L, data.missBytes());
    }
    // ── blockLevelStats section isolation ─────────────────────────────────────
        assertEquals(16L, overall.removed());
        long rc0,
    public void testCompleteProjectionWithActiveInBytes() {
            0,
            0,
            0,  
        long[] raw = buf(100, 1000, 10, 200, 5, 500, 4096, 0, 0, 0, 0, 0, 0, 0);
    }  
    }
 * this file be licensed under the Apache-2.0 license or a
    }
 *
    }  
            0,  
import org.opensearch.test.OpenSearchTestCase;
    ) {
        assertEquals(100L, bc.hits());  
        long ec0,
            FoyerAggregatedStats.snapshot(buf(0, 0, 0, 0, 0, 2048, 0, 0, 0, 0, 0, 0, 0, 0), 1L).overallStats().evictionBytes()
        assertEquals(0L, FoyerAggregatedStats.snapshot(raw, 0L).blockLevelStats().activeInBytes());
        );
     * A negative raw activeInBytes value (which could occur due to a bug in the native
        assertEquals(1000L, s.overallStats().evictionBytes());
    public void testSnapshotTieredOverallMergesCounters() {
        BlockCacheStats overall = s.overallStats();
            0,
            0,
            0,
    public void testSnapshotNonTieredIsNotTiered() {  
    public void testOverallStatsNonNull() {
        FoyerAggregatedStats s = FoyerAggregatedStats.snapshot(buf(0, 0, 0, 0, 999, 0, 0, 0, 0, 0, 0, 0, 0, 0), 0L);
        assertEquals(20, FoyerAggregatedStats.STATS_BUFFER_SIZE);
        assertEquals(1_073_741_824L, FoyerAggregatedStats.snapshot(new long[20], 1_073_741_824L).blockLevelStats().totalBytes());
    public void testSection0DoesNotAffectSection1() {  
        assertEquals(777L, FoyerAggregatedStats.snapshot(raw, 0L).overallStats().activeInBytes());
        assertFalse(FoyerAggregatedStats.snapshot(new long[20], 100L).isTiered());
            0,  
    public void testSinglePerTierAccessorsReturnNull() {  
        FoyerAggregatedStats s = FoyerAggregatedStats.snapshotTiered(new long[20], 380_000L, 20_000L);  
    public void testPositiveActiveInBytesPassesThrough() {
    }
 * Buffer layout: 20 longs — section 0 (overall) at [0..9], section 1 (block-level) at [10..19].
    public void testTieredPerTierAccessorsReturnSectionsDirectly() {
        assertEquals(456L, FoyerAggregatedStats.snapshot(raw, 0L).blockLevelStats().activeInBytes());
        long[] raw = buf(0, 0, 0, 0, 7, 700, 0, 0, 0, 0, 0, 0, 0, 0, 3, 300, 0, 0, 0, 0);
    public void testMissCountFromIndex2() {
        assertEquals(66L, bl.evictionBytes());
    // ── overallStats field mapping (one-hot) ──────────────────────────────────
 * Tests the FFM buffer parsing (snapshot factory) directly without the native
    }  
        // Section 0, index 9 = ACTIVE_IN_BYTES → should map to activeInBytes()
    // ── Non-null guarantees ───────────────────────────────────────────────────
package org.opensearch.blockcache.foyer;
    }  
        BlockCacheStats meta = s.metadataCacheStats();
    }
