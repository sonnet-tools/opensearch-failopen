        assertNotNull("metadataCacheStats must be non-null in tiered mode", s.metadataCacheStats());
        assertEquals(44L, bl.missBytes());
        );      // section 1: all zero
        assertEquals(66L, bl.evictionBytes());
        // 10 fields × 2 sections = 20. Verified here so changes to Field enum break tests fast.
        assertEquals(5L, bc.evictions());
    }
        long[] raw = buf(0, 0, 0, 0, 0, 0, 800, 0, 0, 0, 0, 0, 0, 0, 0, 0, 50, 0, 0, 0);
 *
        long[] raw = buf(0, 0, 0, 0, 7, 700, 0, 0, 0, 0, 0, 0, 0, 0, 3, 300, 0, 0, 0, 0);
    }
        assertEquals(3L, data.misses());
        long ub1
            0,
        BlockCacheStats overall = s.overallStats();
        long hc1,
        BlockCacheStats bl = FoyerAggregatedStats.snapshot(raw, 100L).blockLevelStats();
        long mb0,
        assertEquals(5L, data.removed());
        assertEquals(100L, s.dataCacheStats().hitBytes());
    }
    }
            0,
        assertEquals(10L, s.overallStats().hits());
        assertEquals(110L, meta.removedBytes());
     * native side wrote into its respective FFM section. Independent values per field per
        assertEquals(1000L, s.dataCacheStats().totalBytes());
    public void testAllZeroBuffer() {
        long[] raw = buf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0L);
    }
        // evictionBytes=80, used=100, removed=11, removedBytes=110, active=0
        assertEquals(50L, blockLevel.hits());
        assertEquals(0L, FoyerAggregatedStats.snapshot(raw, 0L).overallStats().activeInBytes());
    public void testMemoryBytesUsedAlwaysZeroBlockLevel() {
            0,
    public void testActiveInBytesIsIndexedIndependentlyFromSection1() {
    }
    }
 * library. Any field-ordinal bug would be caught here.
        assertEquals(0L, FoyerAggregatedStats.snapshot(raw, 0L).overallStats().activeInBytes());
            0,
    // ── activeInBytes defensive clamping ──────────────────────────────────────
        assertEquals(123L, FoyerAggregatedStats.snapshot(raw, 0L).overallStats().activeInBytes());
package org.opensearch.blockcache.foyer;
    }
    }
        assertEquals(77L, bl.diskBytesUsed());
        assertEquals(512L, FoyerAggregatedStats.snapshot(buf(0, 0, 0, 512, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 1L).overallStats().missBytes());
        assertEquals(0L, FoyerAggregatedStats.snapshot(uniform(10, 100, 5, 50, 2, 20, 500), 1000L).blockLevelStats().removed());
        assertEquals(1024L, FoyerAggregatedStats.snapshot(buf(0, 1024, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 1L).overallStats().hitBytes());
        assertEquals(7L, FoyerAggregatedStats.snapshot(buf(0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 1L).overallStats().misses());
        assertEquals(600L, overall.diskBytesUsed());
    }
        assertEquals(400_000L, s.overallStats().totalBytes());
    public void testSnapshotTieredOverallMergesCounters() {
        assertEquals(500L, data.diskBytesUsed());
     * per-tier breakdown are expected to gate on {@link FoyerAggregatedStats#isTiered()}.
        assertEquals(150L, s.overallStats().hitBytes());
        long eb1,
        assertEquals(200L, bc.missBytes());
            0,
    }
 */
        assertEquals(3L, overall.removed());
    }
     * directly (no subtraction-from-overall), each accessor must return exactly what the
     * Cumulative counters (hits, misses, etc.) are NOT clamped — a negative there
    }
    /** A zero activeInBytes must pass through unchanged (not over-clamped). */
            0,
        // data: 10 hits, 100 hit_bytes | metadata: 5 hits, 50 hit_bytes
    }
    public void testRemovedAlwaysZeroOverall() {
     * After the refactor that stores {@code dataCacheStats} and {@code metadataCacheStats}
        long hc0,
            0,
 *
    // ── capacityBytes ─────────────────────────────────────────────────────────
        assertEquals(0L, FoyerAggregatedStats.snapshot(uniform(10, 100, 5, 50, 2, 20, 500), 1000L).overallStats().memoryBytesUsed());
    }
        assertEquals(4096L, FoyerAggregatedStats.snapshot(raw, 0L).overallStats().activeInBytes());
        long eb0,
        assertEquals(300L, overall.removedBytes());
        long mb1,
        assertNotNull(FoyerAggregatedStats.snapshotTiered(new long[20], 100L, 10L));
        assertEquals(22L, bl.hitBytes());
        assertEquals(11L, bl.hits());
        long[] raw = buf(100, 1000, 10, 200, 5, 500, 4096, 0, 0, 0, 0, 0, 0, 0);
        assertEquals(3L, FoyerAggregatedStats.snapshot(buf(0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0), 1L).overallStats().evictions());
        );
            0,
        assertEquals(55L, overall.activeInBytes());
            0,
        assertEquals(50L, data.evictionBytes());
    // ── Large values ──────────────────────────────────────────────────────────
        long ub0,
        long mc0,
        assertFalse("snapshot must not be flagged tiered", s.isTiered());
 *   [0] HIT_COUNT  [1] HIT_BYTES  [2] MISS_COUNT  [3] MISS_BYTES
        assertEquals(200L, s.metadataCacheStats().totalBytes());
        assertEquals(4096L, overall.diskBytesUsed());
        long rc1,
        assertEquals(1L, data.evictions());
    }
        assertEquals(1_073_741_824L, FoyerAggregatedStats.snapshot(new long[20], 1_073_741_824L).overallStats().totalBytes());
        assertEquals(1L, blockLevel.removed());
    }
        assertEquals(100L, meta.diskBytesUsed());
        assertEquals(55L, bl.evictions());
     */
    // ── Non-null guarantees ───────────────────────────────────────────────────
    public void testUsedBytesFromIndex6() {
        long ai0,
    public void testZeroActiveInBytesPassesThrough() {
    }
        assertEquals(0L, FoyerAggregatedStats.snapshot(new long[20], 0L).overallStats().activeInBytes());
            0,
 * Buffer layout: 20 longs — section 0 (overall) at [0..9], section 1 (block-level) at [10..19].
        assertEquals(0L, bc.removed());
        assertEquals(400L, meta.missBytes());
    }
    public void testCapacityPassedToOverall() {
    public void testOverallStatsNonNull() {
            0,
        FoyerAggregatedStats s = FoyerAggregatedStats.snapshotTiered(raw, 1000L, 200L);
        long ec1,
        long ec1,
        assertEquals(50L, s.metadataCacheStats().hitBytes());
        assertEquals(3L, s.dataCacheStats().misses());
        );
        );
    // ── Tiered stats (snapshotTiered) ──────────────────────────────────────────
    // ── overallStats field mapping (one-hot) ──────────────────────────────────
            0
        assertEquals(8192L, bc.totalBytes());
    ) {
    }
    public void testSinglePerTierAccessorsReturnNull() {
            0,
        assertEquals(8192L, FoyerAggregatedStats.snapshot(raw, 0L).blockLevelStats().activeInBytes());
     * In single-cache mode the per-tier accessors return {@code null}. Callers asking for
        assertEquals(10L, s.overallStats().evictions());
    public void testSnapshotTieredIsTiered() {
        assertEquals(100L, s.metadataCacheStats().diskBytesUsed());
            0,
    public void testMissBytesFromIndex3() {
            0,
        assertEquals(1200L, overall.totalBytes());
        assertEquals(
        assertEquals(0L, s.misses());
        assertEquals(20_000L, s.metadataCapacityBytes());
        assertEquals(500L, s.dataCacheStats().diskBytesUsed());
        long ai1
 * SPDX-License-Identifier: Apache-2.0
        long ub1,
        BlockCacheStats bc = FoyerAggregatedStats.snapshot(raw, 8192L).overallStats();
        assertEquals(500L, bc.evictionBytes());
    // ── All-zeros ─────────────────────────────────────────────────────────────
            0,
        long eb0,
            0,
        assertEquals(4L, meta.misses());
        assertTrue(FoyerAggregatedStats.snapshotTiered(new long[20], 100L, 10L).isTiered());
            0,
    public void testPositiveActiveInBytesPassesThrough() {
    public void testMissCountFromIndex2() {
        assertNotNull(FoyerAggregatedStats.snapshot(new long[20], 0L).blockLevelStats());
        assertEquals(1000L, bc.hitBytes());
        BlockCacheStats overall = FoyerAggregatedStats.snapshot(raw, 8192L).overallStats();
        BlockCacheStats s = FoyerAggregatedStats.snapshot(new long[20], 0L).overallStats();
    public void testNegativeActiveInBytesClampsToZero() {
        assertEquals(100L, bc.hits());
        assertEquals(380_000L, s.dataCapacityBytes());
        assertFalse(FoyerAggregatedStats.snapshot(new long[20], 100L).isTiered());
        FoyerAggregatedStats s = FoyerAggregatedStats.snapshot(new long[20], 1024L);
        long[] raw = buf(0, 0, 0, 0, 0, 0, 0, 0, 0, 4096L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8192L);
        assertEquals(80L, meta.evictionBytes());
        // Full 20-field buffer with activeInBytes in section 0
        assertEquals(100L, overall.hits());
        long hb0,
        assertEquals(850L, s.overallStats().diskBytesUsed());
        long[] raw = buf(10, 100, 3, 300, 1, 50, 500, 0, 0, 0, 5, 50, 2, 200, 0, 0, 100, 0, 0, 0);
        // A fresh 20-zero buffer should have activeInBytes == 0
        FoyerAggregatedStats s = FoyerAggregatedStats.snapshot(buf(0, 0, 0, 0, 999, 0, 0, 0, 0, 0, 0, 0, 0, 0), 0L);
    }
    }
        long eb1,
            0,
        long[] raw = buf(10, 100, 3, 300, 1, 50, 500, 5, 50, 0, 20, 200, 4, 400, 2, 80, 100, 11, 110, 0);
        assertEquals(100L, data.hitBytes());
    public void testSnapshotTieredOverallEvictionsIsSumOfBoth() {
        assertEquals(15L, s.overallStats().hits());
            0,
        // Section 0, index 9 = ACTIVE_IN_BYTES → should map to activeInBytes()
    public void testActiveInBytesFromIndex9() {
            0,
        assertEquals(20L, blockLevel.activeInBytes());
 */
            0,
        assertEquals(0L, bc.memoryBytesUsed());
    public void testSnapshotTieredCapacityBytes() {
    }
        assertEquals(5L, s.metadataCacheStats().hits());
        assertEquals(0L, FoyerAggregatedStats.snapshot(uniform(10, 100, 5, 50, 2, 20, 500), 1000L).blockLevelStats().removedBytes());
import org.opensearch.test.OpenSearchTestCase;
    public void testSnapshotTieredNonNull() {
        BlockCacheStats meta = s.metadataCacheStats();
    public void testRemovedAlwaysZeroBlockLevel() {
        // Section 0 (data): hits=10, hitBytes=100, misses=3, missBytes=300, evictions=1,
        long rc0,
    }
    public void testBlockLevelReadsFromSection1() {
    }
    /** Builds a symmetric buffer where both sections are identical and active=0. */
            FoyerAggregatedStats.snapshot(buf(0, 0, 0, 0, 0, 2048, 0, 0, 0, 0, 0, 0, 0, 0), 1L).overallStats().evictionBytes()
    }
    // ── Post-refactor: per-tier accessors return their sections directly ─────
    }
    }
        // section 0 activeInBytes = 123, section 1 activeInBytes = 456
        assertEquals(10L, bc.misses());
    }
        FoyerAggregatedStats s = FoyerAggregatedStats.snapshot(buf(10, 0, 0, 0, 0, 0, 0, 99, 0, 0, 0, 0, 0, 0), 1L);
        FoyerAggregatedStats s = FoyerAggregatedStats.snapshotTiered(new long[20], 380_000L, 20_000L);
    public void testStatsBufferSizeIs20() {
        assertEquals(0L, s.evictions());
        assertEquals(1_073_741_824L, FoyerAggregatedStats.snapshot(new long[20], 1_073_741_824L).blockLevelStats().totalBytes());
            0,
        assertEquals(2048L, blockLevel.diskBytesUsed());
    }
    }
            0,
     * Foyer library or an FFM buffer misread) must be clamped to 0, not propagated.
            0,
    }
    }
    public void testLargeValuesNoCorruption() {
     * tier guard against any latent regression that re-introduces subtraction-based math.
        // Metadata tier — section 1 verbatim, NOT (overall - data).
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(150L, blockLevel.removedBytes());
        long rb0,
        assertEquals(0L, FoyerAggregatedStats.snapshot(uniform(10, 100, 5, 50, 2, 20, 500), 1000L).blockLevelStats().memoryBytesUsed());
    public void testSnapshotNonNull() {
        assertEquals(20, FoyerAggregatedStats.STATS_BUFFER_SIZE);
    public void testHitBytesFromIndex1() {
        assertEquals(200L, meta.totalBytes());
        assertEquals(0L, FoyerAggregatedStats.snapshot(uniform(10, 100, 5, 50, 2, 20, 500), 1000L).overallStats().removedBytes());
    public void testCompleteProjectionWithActiveInBytes() {
        long[] raw = buf(100, 1000, 10, 200, 5, 500, 4096, 3, 300, 55L, 50, 500, 2, 100, 1, 200, 2048, 1, 150, 20L);
        assertEquals(33L, bl.misses());
        assertTrue("snapshotTiered must be flagged tiered", s.isTiered());
        assertEquals(42L, FoyerAggregatedStats.snapshot(buf(42, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 1L).overallStats().hits());
        assertEquals(0L, FoyerAggregatedStats.snapshot(uniform(10, 100, 5, 50, 2, 20, 500), 1000L).overallStats().removed());
            0,
        BlockCacheStats s = FoyerAggregatedStats.snapshot(uniform(large, large, large, large, large, large, large), large).overallStats();
        assertEquals(2L, s.metadataCacheStats().misses());
        assertEquals(0L, s.diskBytesUsed());
        long hc0,
    public void testTieredPerTierAccessorsReturnSectionsDirectly() {
        assertEquals(50L, data.removedBytes());
    public void testSnapshotNonTieredIsNotTiered() {
        assertEquals(200L, meta.hitBytes());
        long ec0,
        return buf(hc0, hb0, mc0, mb0, ec0, eb0, ub0, 0, 0, 0, hc1, hb1, mc1, mb1, ec1, eb1, ub1, 0, 0, 0);
            -999L   // section 1: activeInBytes = -999
        assertEquals(999L, s.overallStats().evictions());
/**
        assertEquals(0L, s.blockLevelStats().evictions());
    public void testEvictionBytesFromIndex5() {
        assertNull("metadataCacheStats must be null in single-cache mode", s.metadataCacheStats());
        assertEquals(0L, s.activeInBytes());
        assertNotNull(FoyerAggregatedStats.snapshot(new long[20], 0L));
    public void testZeroCapacity() {
        long mb1,
 *   [4] EVICTION_COUNT  [5] EVICTION_BYTES  [6] USED_BYTES
            0,
    public void testCompleteProjection() {
            0,
        long mb0,
        long[] raw = buf(10, 100, 0, 0, 0, 0, 0, 0, 0, 0, 5, 50, 0, 0, 0, 0, 0, 0, 0, 0);
        assertEquals(456L, FoyerAggregatedStats.snapshot(raw, 0L).blockLevelStats().activeInBytes());
    }
        long mc1,
        assertEquals(10L, s.dataCacheStats().hits());
        assertEquals(16L, overall.removed());
        FoyerAggregatedStats s = FoyerAggregatedStats.snapshotTiered(raw, 1000L, 200L);
    public void testActiveInBytesDefaultsToZero() {
 * compatible open source license.
        FoyerAggregatedStats s = FoyerAggregatedStats.snapshotTiered(raw, 1000L, 200L);
        assertEquals(160L, overall.removedBytes());
        long ec0,
        long hb1,
        assertEquals(0L, FoyerAggregatedStats.snapshot(raw, 0L).blockLevelStats().activeInBytes());
        // Section 1 (meta): hits=20, hitBytes=200, misses=4, missBytes=400, evictions=2,
    ) {
            0,
    public void testCapacityPassedToBlockLevel() {
        long hb0,
        assertEquals(0L, bc.removedBytes());
    }
        assertEquals(1000L, s.overallStats().evictionBytes());
            999L,
        long ub0,
    }
    public void testSnapshotTieredDataCacheStats() {
        // Overall is the eager merge of both tiers.
        long[] raw = buf(0, 0, 0, 0, 0, 0, 0, 11, 22, 33, 44, 55, 66, 77);
        long hb1,
    }
            0,
    }
        long large = Long.MAX_VALUE / 2;
public class FoyerAggregatedStatsTests extends OpenSearchTestCase {
    // ── Foyer-specific zero fields ─────────────────────────────────────────────
        return new long[] { hc0, hb0, mc0, mb0, ec0, eb0, ub0, rc0, rb0, ai0, hc1, hb1, mc1, mb1, ec1, eb1, ub1, rc1, rb1, ai1 };
        long[] raw = buf(0, 0, 0, 0, 0, 0, 0, 0, 0, 123L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 456L);
 * Tests the FFM buffer parsing (snapshot factory) directly without the native
    private static long[] buf(
    public void testSnapshotTieredMetadataCacheStats() {
        assertEquals(0L, bc.activeInBytes());
        assertEquals(7L, overall.misses());
        long[] raw = buf(
        long mc0,
    }
        assertEquals(large, s.diskBytesUsed());
        FoyerAggregatedStats s = FoyerAggregatedStats.snapshotTiered(raw, 1000L, 100L);
        assertEquals(large, s.totalBytes());
        long mc1,
    public void testEvictionCountFromIndex4() {
            0,
    /**
        assertEquals(99L, s.blockLevelStats().hits());
    /**
        assertNotNull("dataCacheStats must be non-null in tiered mode", s.dataCacheStats());
        long[] raw = buf(10, 100, 3, 300, 1, 50, 500, 0, 0, 0, 5, 50, 2, 200, 0, 0, 100, 0, 0, 0);
    /** 16-arg shorthand: removed and active default to 0 for both sections. */
    /**
    public void testSection0DoesNotAffectSection1() {
    }
            0,
            FoyerAggregatedStats.snapshot(buf(0, 0, 0, 0, 0, 0, 999, 0, 0, 0, 0, 0, 0, 0), 1L).overallStats().diskBytesUsed()
    }
        return buf(hc, hb, mc, mb, ec, eb, ub, 0, 0, 0, hc, hb, mc, mb, ec, eb, ub, 0, 0, 0);
        assertNotNull(FoyerAggregatedStats.snapshot(new long[20], 0L).overallStats());
        assertEquals(4096L, bc.diskBytesUsed());
        long rb1,
    // ── Complete projection ───────────────────────────────────────────────────
        FoyerAggregatedStats s = FoyerAggregatedStats.snapshotTiered(raw, 1000L, 100L);
        assertEquals(2L, meta.evictions());
        long[] raw = buf(
    /** Full 20-arg helper: 10 fields per section, 2 sections. */
 * Unit tests for {@link FoyerAggregatedStats}.
/*
     * indicates a real accounting bug and should remain visible.
            -1L,   // section 0: activeInBytes = -1
        assertEquals(large, s.hits());
 *   [7] REMOVED_COUNT  [8] REMOVED_BYTES  [9] ACTIVE_IN_BYTES
     * A negative raw activeInBytes value (which could occur due to a bug in the native
            0,
    }
        BlockCacheStats blockLevel = FoyerAggregatedStats.snapshot(raw, 8192L).blockLevelStats();
    public void testHitCountFromIndex0() {
    public void testBlockLevelStatsNonNull() {
 *
    }
}
        assertEquals(0L, s.hits());
        assertEquals(0L, FoyerAggregatedStats.snapshot(new long[20], 0L).overallStats().totalBytes());
        assertEquals(777L, FoyerAggregatedStats.snapshot(raw, 0L).overallStats().activeInBytes());
    }
        BlockCacheStats data = s.dataCacheStats();
        assertEquals(30L, overall.hits());
        // Data tier — section 0 verbatim.
    private static long[] uniform(long hc, long hb, long mc, long mb, long ec, long eb, long ub) {
    // ── blockLevelStats section isolation ─────────────────────────────────────
        assertEquals(10L, data.hits());
 * The OpenSearch Contributors require contributions made to
        FoyerAggregatedStats s = FoyerAggregatedStats.snapshotTiered(raw, 1000L, 200L);
        assertEquals(20L, meta.hits());
        assertEquals(1000L, data.totalBytes());
        assertNull("dataCacheStats must be null in single-cache mode", s.dataCacheStats());
        assertEquals(
            0,
    // ── STATS_BUFFER_SIZE contract ─────────────────────────────────────────────
    public void testBlockLevelAllFieldsMapped() {
    public void testMemoryBytesUsedAlwaysZeroOverall() {
    public void testSnapshotTieredOverallUsedBytesIsSumOfBoth() {
        long hc1,
        assertEquals(11L, meta.removed());
        // evictionBytes=50, used=500, removed=5, removedBytes=50, active=0
            0,
            2048L,
     */
            0,
            777L,   // section 0: activeInBytes=777
            0,
    /** A positive activeInBytes must pass through unchanged. */
        assertEquals(300L, data.missBytes());
     */
    }
    private static long[] buf(
import org.opensearch.plugins.BlockCacheStats;
