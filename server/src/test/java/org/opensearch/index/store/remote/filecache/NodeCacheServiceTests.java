        FileCache fc = mock(FileCache.class);
    public void testAggregateStatsMergesEvictionBytesFromBlockCache() {
        assertEquals(fcActive, stats.getActive().getBytes());
    public void testValidateThrowsFileCacheBytesZero() {
        BlockCache bc1 = mock(BlockCache.class);
        long removedBytes = 3500L;
import org.opensearch.common.settings.SettingsException;
            0,
        when(bc2.stats()).thenReturn(new BlockCacheStats(20, 3, 200, 30, 1, 100, 0, 0, 0, 512, 1024, 0));
    }
        when(provider.getBlockCache()).thenReturn(Optional.of(bc));
        assertNull("combined tieredStats must be null when no cache is tiered", orc.combinedBlockCacheStats().tieredStats());
        assertEquals(0L, orc.blockCacheDiskBytesUsed());
        FileCache fc = mock(FileCache.class);
        assertEquals(1500L, s.getTotal().getBytes());
        long totalBytes
        NodeCacheService orc = new NodeCacheService(fc, 0L);
    }
        expectThrows(SettingsException.class, () -> NodeCacheService.validate(600L, 200L, -1L));
            used,
        BlockCache bc = mock(BlockCache.class);
        BlockCache bc = mock(BlockCache.class);
        return fc;
import org.opensearch.plugins.BlockCacheStats;
    public void testBlockCacheDiskBytesUsedZeroWhenNone() {
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        FileCache fc = fileCacheWithStats(0L, 0L, 0L, 0L, 0L, 0L, 0L);
        FileCache fc = mock(FileCache.class);
    // ── close() propagation ───────────────────────────────────────────────────
    // ── addBlockCache / blockCaches ───────────────────────────────────────────
    public void testAggregateStatsMergesRemovedCountFromBlockCache() {
        assertSame(fc, new NodeCacheService(fc, 0L).fileCache());
        org.mockito.Mockito.verify(bc2).close();
        FileCache fc = fileCacheWithStats(0, 0, 400L, 0, 1000L, 0L, 0L);
    // ── registerProviders ─────────────────────────────────────────────────────
        when(bc1.stats()).thenReturn(new BlockCacheStats(10, 5, 100, 50, 2, 200, 1, 10, 0, 1024, 2048, 0));
    public void testAggregateStatsMergesTotalCapacityFromBlockCache() {
        AggregateFileCacheStats s = orc.aggregateStats();
        orc.addBlockCache(bc1);
        assertEquals(1000L, NodeCacheService.computeVirtualBlockCacheBytes(Map.of("p1", p1, "p2", p2), Settings.EMPTY, 1000L));
    // ── blockCacheCapacityBytes ───────────────────────────────────────────────
        assertEquals(30, combined.hits());
        org.mockito.Mockito.verify(bc1).close();
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        BlockCache bc = mock(BlockCache.class);
    }
        FileCache fc = fileCacheWithStats(0L, 0L, 0L, 0L, 0L, 0L, 0L);
    private FileCache fileCacheWithStats(long active, long hits, long used, long pinned, long total, long evicted, long removed) {
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        assertEquals(0L, new NodeCacheService(fc, 0L).blockCacheCapacityBytes());
    public void testGetByNameReturnsRegisteredBlockCache() {
    // ── aggregateStats — mergeStats path (block cache present) ───────────────
import org.opensearch.plugins.BlockCache;
    public void testComputeVirtualBlockCacheBytesNoProviders() {
    // ── computeVirtualBlockCacheBytes ─────────────────────────────────────────
 * The OpenSearch Contributors require contributions made to
        NodeCacheService orc = new NodeCacheService(fc, 0L);
    }
 * compatible open source license.
        orc.addBlockCache(bc);
        FileCache fc = fileCacheWithStats(0L, 0L, 0L, 0L, 0L, 0L, 0L);
        assertFalse("get(unknown) should return empty Optional", orc.get("unknown").isPresent());
        long fcActive = 75L;
        NodeCacheService orc = new NodeCacheService(fc, 0L);
    public void testValidateThrowsSumExceedsTotalSSD() {
        expectThrows(UnsupportedOperationException.class, () -> orc.blockCaches().add(null));
        when(bc1.stats()).thenReturn(s);
            0L      // activeInBytes — not exercised in this helper; tests that need it set it directly
            0,
    }
    public void testRegisterProvidersMixedEmptyAndPresent() {
    }
    public void testCombinedBlockCacheStatsAggregatesAcrossMultipleCaches() {
        FileCacheStats overall = new FileCacheStats(
        assertEquals(2, orc.blockCaches().size());
        BlockCacheProvider provider = mock(BlockCacheProvider.class);
    public void testAddMultipleBlockCaches() {
        assertNotNull(combined);
    private BlockCache mockBlockCache(long hits, long misses, long diskUsed, long memUsed, long total) {
        assertEquals(300L, s.getEvicted().getBytes());
    public void testAllReturnsEmptyWhenNoBlockCaches() {
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        BlockCacheStats stats = new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 512L, 0L);
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        BlockCache bc1 = mock(BlockCache.class);
        orc.close();
            totalBytes,
        orc.addBlockCache(mockBlockCache(0, 0, 0, 0, 1L));
        var provider = mockProvider("0%", 1.0);
        FileCache fc = fileCacheWithStats(0L, 0L, 0L, 0L, 0L, 0L, 0L);
        assertEquals(500L, s.getUsed().getBytes());
    // ── BlockCacheRegistry.get(name) ──────────────────────────────────────────
            AggregateFileCacheStats.FileCacheStatsType.PINNED_FILE_STATS
    }
    // ── aggregateStats: removed / removedBytes ─────────────────────────────────
            0,
    }
    // ── BlockCacheRegistry.all() ──────────────────────────────────────────────
        orc.addBlockCache(mockBlockCacheWithFullStats(50L, 10L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 500L));
import org.opensearch.common.settings.Settings;
            0,
        FileCache fc = mock(FileCache.class);
            0,
        orc.addBlockCache(bc1);
        FileCache fc = fileCacheWithStats(0L, 0L, 0L, 0L, 0L, 0L, 0L);
        assertEquals(50L, s.getEvicted().getBytes());
            0,
        return bc;
/**
    }
        orc.addBlockCache(bc2);
        when(bc1.stats()).thenReturn(new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0L, 0L, 100L, 30L));
    public void testAddNullBlockCacheIgnored() {
        BlockCache singleTier = mock(BlockCache.class);
        when(bc.stats()).thenReturn(new BlockCacheStats(0, 0, 0, 0, 0, 0, removed, removedBytes, 0, 0, 100L, 0L));
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        when(fc.usage()).thenReturn(0L);
    }
    public void testCombinedBlockCacheStatsPicksFirstTieredWhenMultiplePresent() {
        var provider = mockProvider("25%", 5.0);
        FileCache fc = mock(FileCache.class);
    ) {
        when(bc2.tieredStats()).thenReturn(second);
        orc.addBlockCache(bc2);
    }
        assertEquals(1000L, s.getTotal().getBytes());
        BlockCache bc2 = mock(BlockCache.class);
        orc.addBlockCache(mockBlockCache(0, 0, 0, 0, 500L));
        orc.addBlockCache(bc2);
        FileCache fc = fileCacheWithStats(0, 0, 0, 0, 1000L, 0L, 0L);
        orc.registerProviders(Map.of("empty", emptyProvider));
 */
            total,
        long removed = 7L;
    public void testValidateThrowsNegativeTotalSSD() {
    public void testValidateThrowsNegativeBlockCacheBytes() {
    public void testAggregateStatsBlockSectionAlsoMerged() {
/*
    }
        assertEquals(7L, s.getBlockFileCacheStats().getCacheHits());
        orc.addBlockCache(bc);
        long removedBytes,
    public void testValidateThrowsZeroTotalSSD() {
        assertNull(orc.combinedBlockCacheStats());
    public void testClosePropagatesToAllBlockCaches() throws Exception {
    private BlockCacheProvider mockProvider(String sizePercent, double amplification) {
        var p2 = mockProvider("10%", 2.0);  // 100 × 2 = 200
        long evictions,
        orc.addBlockCache(mockBlockCache(0, 0, 300L, 0, 0));
    public void testRegisterProvidersWiresCacheFromProvider() {
        orc.addBlockCache(mockBlockCache(0, 0, 300L, 0, 1000L));
        long fcActive = 200L;
        // No block cache registered
        // 25% of 1000 = 250 bytes reserved × ratio 5.0 = 1250 virtual bytes
        BlockCacheStats stats = new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 50L, 200L, 0L, 0L);
        BlockCacheStats stats = new BlockCacheStats(hits, misses, 0, 0, 0, 0, 0, 0, memUsed, diskUsed, total, 0L);
        assertEquals(250L, orc.cacheUtilizedBytes());
        when(provider.requestedCapacityBytes(org.mockito.ArgumentMatchers.any(), org.mockito.ArgumentMatchers.anyLong())).thenAnswer(
        NodeCacheService.validate(600L, 200L, 1000L);
    }
    // ── aggregateStats: activeInBytes ──────────────────────────────────────────
        when(bc1.stats()).thenReturn(new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        when(fc.usage()).thenReturn(100L);
    public void testComputeVirtualBlockCacheBytesAppliesRatio() {
            0L,
        orc.addBlockCache(mockBlockCache(0, 0, 0, 0, 600L));
        FileCache fc = fileCacheWithStats(0L, 0L, 0L, 0L, 0L, 0L, 0L);
    }
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        assertEquals(0L, NodeCacheService.computeBlockCacheBudget(Map.of("foyer", provider), Settings.EMPTY, 1000L));
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        NodeCacheService orc = new NodeCacheService(fc, 0L);
    }
        assertEquals(1, orc.blockCaches().size());
        orc.addBlockCache(bc1);
        FileCache fc = mock(FileCache.class);
    // ── blockCacheDiskBytesUsed ───────────────────────────────────────────────
        orc.addBlockCache(mockBlockCacheWithFullStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 500L));
        long evictionBytes,
            evictions,
        FileCache fc = mock(FileCache.class);
        long bcActive = 50L;
    }
        assertEquals(0L, NodeCacheService.computeBlockCacheBudget(Map.of(), Settings.EMPTY, 1000L));
        orc.addBlockCache(mockBlockCache(0, 0, 200L, 0, 1000L));
            removed,
        assertNotNull(combined);
        long missBytes,
        orc.addBlockCache(singleTier);
        assertEquals(1, orc.blockCaches().size());
        FileCache fc = fileCacheWithStats(0, 0, 0, 0, 1000L, 0L, 0L);
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        );
        assertTrue("get(foyer) should return the registered cache", orc.get("foyer").isPresent());
        FileCache fc = fileCacheWithStats(fcActive, 0L, 0L, 0L, 1000L, 0L, 0L);
        assertEquals(500L, orc.blockCacheDiskBytesUsed());
        FileCache fc = fileCacheWithStats(0L, 0L, 0L, 0L, 0L, 0L, 0L);
            removed,
        orc.addBlockCache(bc1);
        BlockCache bc2 = mock(BlockCache.class);
        orc.addBlockCache(mockBlockCacheWithFullStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 200L, 500L));
        when(bc.stats()).thenReturn(stats);
        when(withoutCache.getBlockCache()).thenReturn(Optional.empty());
        FileCache fc = mock(FileCache.class);
    }
        );
        assertEquals(600L, s.getUsed().getBytes());
    public void testAllReturnsAllRegisteredBlockCaches() {
    public void testValidatePassesSumEqualsTotalSSD() {
    }
            missBytes,
            hitBytes,
    public void testAggregateStatsActiveInBytesZeroWithNoBlockCache() {
        assertEquals(300, combined.hitBytes());
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        AggregateFileCacheStats agg = new AggregateFileCacheStats(System.currentTimeMillis(), overall, zeroFull, zero, zeroPinned);
        BlockCacheStats combined = orc.combinedBlockCacheStats();
    public void testComputeBlockCacheBudgetZeroPercentProvider() {
import java.util.Optional;
        var provider = mockProvider("30%", 1.0);  // 300 × 1 = 300
    public void testBlockCacheCapacityZeroWhenNone() {
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        // merged active = file-cache active + block-cache activeInBytes
        FileCache fc = mock(FileCache.class);
        AggregateFileCacheStats stats = orc.aggregateStats();
    public void testRegisterProvidersWithEmptyOptionalSkipsCache() {
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        orc.addBlockCache(mockBlockCacheWithFullStats(0, 0, 0, 0, 0, 200L, 0, 0, 0, 200L, 500L));
        long memBytesUsed,
        long misses,
        BlockCache bc = mock(BlockCache.class);
    public void testValidateThrowsFileCacheBytesNegative() {
        assertTrue(orc.all().isEmpty());
        var provider = mockProvider("25%", 1.0);
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        long removed,
    }
        return bc;
        FileCache fc = mock(FileCache.class);
        assertTrue(ex.getMessage().contains("exceeds") || ex.getMessage().contains("Reduce"));
    public void testCombinedBlockCacheStatsPropagatesTieredStatsFromTieredCache() {
        when(bc2.stats()).thenReturn(new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        orc.registerProviders(Map.of("foyer", provider));
            misses,
        FileCache fc = fileCacheWithStats(0L, 0L, 0L, 0L, 0L, 0L, 0L);
        assertTrue(orc.all().contains(bc1));
    }
        BlockCacheStats s = new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1L, 0L);
            pinned,
        assertEquals(250L, NodeCacheService.computeBlockCacheBudget(Map.of("foyer", provider), Settings.EMPTY, 1000L));
    }
import org.opensearch.plugins.BlockCacheTieredStats;
    }
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        BlockCacheProvider emptyProvider = mock(BlockCacheProvider.class);
        expectThrows(SettingsException.class, () -> NodeCacheService.validate(800L, -1L, 1000L));
        assertSame(bc, orc.blockCaches().get(0));
    }
        BlockCache bc = mockBlockCache(0, 0, 0, 0, 500L);
    }
            evictionBytes,
        orc.addBlockCache(bc2);
            diskBytesUsed,
    private BlockCache mockBlockCacheWithFullStats(
        when(withCache.getBlockCache()).thenReturn(Optional.of(bc));
    public void testAggregateStatsMergesHitsFromBlockCache() {
        assertEquals(1000L, orc.blockCacheCapacityBytes());
    }
        assertSame(bc, orc.get("foyer").get());
        expectThrows(SettingsException.class, () -> NodeCacheService.validate(0L, 1000L, 1000L));
            0,
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        assertEquals(0L, new NodeCacheService(fc, 0L).blockCacheDiskBytesUsed());
        assertEquals(1, orc.blockCaches().size());
    // ── computeBlockCacheBudget ───────────────────────────────────────────────
        orc.addBlockCache(mockBlockCache(1, 0, 0, 0, 10L));
        when(fc.fileCacheStats()).thenReturn(agg);
    }
    public void testValidatePassesZeroBlockCache() {
        AggregateFileCacheStats stats = orc.aggregateStats();
    }
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        FileCache fc = fileCacheWithStats(0, 0, 0, 0, 1000L, 100L, 0L);
        BlockCacheTieredStats first = sampleTieredStats();
            0,
        orc.addBlockCache(mockBlockCacheWithFullStats(7L, 3L, 0, 0, 0, 0, 0, 0, 0, 100L, 200L));
    public void testBlockCacheDiskBytesUsedIgnoresMemory() {
        assertEquals(2, orc.all().size());
        );
    }
package org.opensearch.index.store.remote.filecache;
        BlockCacheProvider withoutCache = mock(BlockCacheProvider.class);
    public void testCacheUtilizedIncludesBlockCacheMemory() {
        when(bc.stats()).thenReturn(new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0L, 0L, 100L, bcActive));
        BlockCache bc1 = mock(BlockCache.class);
        orc.registerProviders(Map.of("foyer", withCache, "other", withoutCache));
    }
        when(emptyProvider.getBlockCache()).thenReturn(Optional.empty());
    public void testAggregateStatsMergesActiveInBytesAcrossMultipleBlockCaches() {
        assertEquals(fcActive + 30L + 20L, stats.getActive().getBytes());
        // Non-tiered cache (default mock → tieredStats() == null).
        orc.addBlockCache(bc2);
        FileCache fc = mock(FileCache.class);
        orc.addBlockCache(mockBlockCache(0, 0, 0, 0, 500L));
    }
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        BlockCache tieredCache = mock(BlockCache.class);
        assertEquals(500L, new NodeCacheService(fc, 0L).cacheUtilizedBytes());
        when(bc2.stats()).thenReturn(s);
    public void testBlockCachesListIsUnmodifiable() {
    }
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        assertEquals(350L, NodeCacheService.computeBlockCacheBudget(Map.of("p1", p1, "p2", p2), Settings.EMPTY, 1000L));
            active,
        orc.addBlockCache(bc);
        BlockCacheStats combined = orc.combinedBlockCacheStats();
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        long fcActive = 100L;
        FileCache fc = mock(FileCache.class);
    // ── validate() ────────────────────────────────────────────────────────────
    }
    // ── cacheUtilizedBytes ────────────────────────────────────────────────────
    // ── Helpers ───────────────────────────────────────────────────────────────
    public void testBlockCacheCapacitySumsAcrossCaches() {
        when(provider.dataToCapacityRatio(org.mockito.ArgumentMatchers.any())).thenReturn(amplification);
 */
        FileCache fc = mock(FileCache.class);
        BlockCacheProvider provider = mock(BlockCacheProvider.class);
        FileCacheStats zero = new FileCacheStats(0, 0, 0, 0, 0, 0, 0, 0, AggregateFileCacheStats.FileCacheStatsType.BLOCK_FILE_STATS);
        // Tiered cache exposing a per-tier breakdown.
        orc.addBlockCache(mockBlockCache(2, 0, 0, 0, 20L));
        FileCache fc = fileCacheWithStats(0L, 0L, 0L, 0L, 0L, 0L, 0L);
        BlockCache bc2 = mock(BlockCache.class);
        when(bc.cacheName()).thenReturn("foyer");
        BlockCacheTieredStats tiered = sampleTieredStats();
    }
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        AggregateFileCacheStats stats = orc.aggregateStats();
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(3, combined.evictions());
        FileCache fc = fileCacheWithStats(0, 0, 500L, 0, 1000L, 50L, 0L);
    }
        BlockCacheStats stats = new BlockCacheStats(
    }
        assertSame("first non-null tieredStats must win", first, orc.combinedBlockCacheStats().tieredStats());
        FileCache fc = mock(FileCache.class);
    }
import static org.mockito.Mockito.when;
    }
    public void testAggregateStatsMergesActiveInBytesFromBlockCache() {
 * capacity and utilization accessors — all without real FileCache from disk.
            memBytesUsed,
        assertEquals(1250L, NodeCacheService.computeVirtualBlockCacheBytes(Map.of("foyer", provider), Settings.EMPTY, 1000L));
 *
            hits,
        when(bc1.tieredStats()).thenReturn(first);
    }
            inv -> Math.round((long) inv.getArgument(1) * ratio)
        assertEquals(10L, s.getCacheMisses());
    public void testComputeVirtualBlockCacheBytesSumsMultipleProviders() {
        assertEquals(300, combined.evictionBytes());
        var p1 = mockProvider("20%", 4.0);  // 200 × 4 = 800
        orc.addBlockCache(null);
        BlockCache bc = mockBlockCache(0, 0, 0, 0, 100L);
    }
    }
        orc.addBlockCache(mockBlockCache(0, 0, 0, 0, 400L));
        String stripped = sizePercent.endsWith("%") ? sizePercent.substring(0, sizePercent.length() - 1) : sizePercent;
        FileCache fc = fileCacheWithStats(0, 0, 0, 0, 1000L, 0L, 0L);
        assertEquals(removedBytes, stats.getRemoved().getBytes());
        assertEquals(fcActive + bcActive, stats.getActive().getBytes());
        assertTrue(ex.getMessage().contains("SSD capacity"));
        assertEquals(8, combined.misses());
        when(bc2.stats()).thenReturn(new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0L, 0L, 100L, 20L));
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        FileCache fc = mock(FileCache.class);
    public void testAggregateStatsMergesUsedBytesFromBlockCacheDisk() {
        FileCache fc = fileCacheWithStats(fcActive, 0L, 0L, 0L, 1000L, 0L, 0L);
            hits,
        AggregateFileCacheStats s = orc.aggregateStats();
        NodeCacheService.validate(600L, 400L, 1000L);
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        assertEquals("tiered breakdown must propagate into the combined stats", tiered, combined.tieredStats());
        BlockCache bc1 = mock(BlockCache.class);
        var p1 = mockProvider("25%", 1.0);  // 250 of 1000
        FileCache fc = mock(FileCache.class);
    }
    }
    public void testFileCacheAccessor() {
    public void testCombinedBlockCacheStatsNullTieredWhenNoCacheIsTiered() {
    public void testBlockCacheDiskBytesUsedSumsAcrossCaches() {
        assertEquals(3072, combined.totalBytes());
        orc.addBlockCache(bc);
            removedBytes,
    public void testGetByNameReturnsEmptyForUnknownName() {
import org.opensearch.plugins.BlockCacheProvider;
        assertEquals(400L, orc.cacheUtilizedBytes());
        assertEquals(0L, NodeCacheService.computeVirtualBlockCacheBytes(Map.of(), Settings.EMPTY, 1000L));
    public void testComputeBlockCacheBudgetSingleProvider() {
        return provider;
        NodeCacheService.validate(800L, 0L, 1000L);
        double ratio = Double.parseDouble(stripped) / 100.0;
        FileCache fc = fileCacheWithStats(fcActive, 0L, 0L, 0L, 1000L, 0L, 0L);
        BlockCache bc = mock(BlockCache.class);
    public void testComputeVirtualBlockCacheBytesRatioOneEqualsReserved() {
        SettingsException ex = expectThrows(SettingsException.class, () -> NodeCacheService.validate(700L, 400L, 1000L));
        FileCache fc = fileCacheWithStats(0L, 0L, 0L, 0L, 0L, 0L, 0L);
        SettingsException ex = expectThrows(SettingsException.class, () -> NodeCacheService.validate(600L, 200L, 0L));
        NodeCacheService orc = new NodeCacheService(fc, 0L);
    }
        when(singleTier.stats()).thenReturn(new BlockCacheStats(10, 5, 0, 0, 0, 0, 0, 0, 0, 1024, 2048, 0));
        var p2 = mockProvider("10%", 1.0);  // 100 of 1000
    public void testAggregateStatsNoBlockCacheReturnsFileCacheStatsOnly() {
import java.util.Map;
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        long hitBytes,
        assertTrue(orc.all().contains(bc2));
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        assertEquals(1536, combined.diskBytesUsed());
        FileCacheStats zeroPinned = new FileCacheStats(
        BlockCache bc2 = mock(BlockCache.class);
    public void testCacheUtilizedIncludesBlockCacheDisk() {
        orc.addBlockCache(bc);
    }
        expectThrows(SettingsException.class, () -> NodeCacheService.validate(-1L, 600L, 1000L));
        assertEquals(50L, s.getCacheHits());
        assertEquals(0, orc.blockCaches().size());
        long hits,
        when(tieredCache.stats()).thenReturn(new BlockCacheStats(20, 3, 0, 0, 0, 0, 0, 0, 0, 512, 1024, 0));
        BlockCacheTieredStats second = sampleTieredStats();
public class NodeCacheServiceTests extends OpenSearchTestCase {
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        assertEquals(300L, NodeCacheService.computeVirtualBlockCacheBytes(Map.of("foyer", provider), Settings.EMPTY, 1000L));
    }
        BlockCache bc2 = mock(BlockCache.class);
    public void testComputeBlockCacheBudgetMultipleProviders() {
            AggregateFileCacheStats.FileCacheStatsType.OVER_ALL_STATS
        when(provider.getBlockCache()).thenReturn(Optional.empty());
    }
        when(bc.stats()).thenReturn(stats);
    }
        // Two distinct (but equal-valued) instances — identity proves "first wins".
        assertEquals(0, orc.blockCaches().size());
        orc.addBlockCache(bc1);
        assertEquals(80, combined.missBytes());
        NodeCacheService orc = new NodeCacheService(fc, 0L);
}
 * SPDX-License-Identifier: Apache-2.0
        orc.addBlockCache(tieredCache);
    }
        BlockCache bc = mock(BlockCache.class);
        assertSame(bc, orc.blockCaches().get(0));
        when(bc.stats()).thenReturn(stats);
        FileCacheStats zeroFull = new FileCacheStats(0, 0, 0, 0, 0, 0, 0, 0, AggregateFileCacheStats.FileCacheStatsType.FULL_FILE_STATS);
        when(tieredCache.tieredStats()).thenReturn(tiered);
    public void testComputeBlockCacheBudgetNoProviders() {
    public void testAddBlockCacheRegistersIt() {
        FileCache fc = mock(FileCache.class);
    }
    public void testCombinedBlockCacheStatsReturnsNullWhenNoBlockCaches() {
        when(bc2.stats()).thenReturn(new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1L, 0));
        when(fc.usage()).thenReturn(used);
    }
        long diskBytesUsed,
import static org.mockito.Mockito.mock;
        );
    }
        AggregateFileCacheStats s = orc.aggregateStats();
    }
    }
    }
        BlockCache bc1 = mock(BlockCache.class);
        BlockCacheProvider withCache = mock(BlockCacheProvider.class);
        AggregateFileCacheStats s = orc.aggregateStats();
        // Create a BlockCacheStats with activeInBytes=bcActive
        when(bc.stats()).thenReturn(stats);
    }
    public void testValidatePassesLegalValues() {
        NodeCacheService orc = new NodeCacheService(fc, 0L);
    }
import org.opensearch.test.OpenSearchTestCase;
        when(fc.usage()).thenReturn(500L);
            evicted,
    }
        orc.addBlockCache(mockBlockCache(0, 0, 0L, 100L, 1000L));
        // removedBytes from block cache must be folded into the overall removed_in_bytes field
    private BlockCacheTieredStats sampleTieredStats() {
 * Unit tests for {@link NodeCacheService}: budget validation, addBlockCache,
        AggregateFileCacheStats stats = orc.aggregateStats();
    }
        AggregateFileCacheStats s = orc.aggregateStats();
    // ── combinedBlockCacheStats() ─────────────────────────────────────────────
        FileCache fc = fileCacheWithStats(0L, 0L, 0L, 0L, 0L, 0L, 0L);
    public void testCacheUtilizedIncludesFileCache() {
        BlockCache bc = mockBlockCache(0, 0, 0, 0, 1000L);
        when(bc1.stats()).thenReturn(new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1L, 0));
        return new BlockCacheTieredStats(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22);
        AggregateFileCacheStats s = orc.aggregateStats();
