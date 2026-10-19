        when(bc.stats()).thenReturn(new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0L, 0L, 100L, bcActive));
        NodeCacheService orc = new NodeCacheService(fc, 0L);
    }
        FileCacheStats zero = new FileCacheStats(0, 0, 0, 0, 0, 0, 0, 0, AggregateFileCacheStats.FileCacheStatsType.BLOCK_FILE_STATS);
        NodeCacheService.validate(600L, 400L, 1000L);
        assertNull("combined tieredStats must be null when no cache is tiered", orc.combinedBlockCacheStats().tieredStats());
        BlockCacheProvider provider = mock(BlockCacheProvider.class);
        FileCacheStats zeroPinned = new FileCacheStats(
        expectThrows(UnsupportedOperationException.class, () -> orc.blockCaches().add(null));
    }
    public void testRegisterProvidersMixedEmptyAndPresent() {  
            removed,
    // ── aggregateStats: removed / removedBytes ─────────────────────────────────
 * SPDX-License-Identifier: Apache-2.0
        BlockCacheProvider withCache = mock(BlockCacheProvider.class);  
        NodeCacheService.validate(600L, 200L, 1000L);  
            0,  
        orc.addBlockCache(bc);
        orc.registerProviders(Map.of("foyer", withCache, "other", withoutCache));  
        var p1 = mockProvider("20%", 4.0);  // 200 × 4 = 800  
            memBytesUsed,  
        long fcActive = 75L;
        orc.addBlockCache(bc1);
    }  
        assertTrue(orc.all().contains(bc1));  
        NodeCacheService orc = new NodeCacheService(fc, 0L);  
        when(bc2.stats()).thenReturn(new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1L, 0));
import java.util.Optional;
        var provider = mockProvider("25%", 5.0);
    public void testValidateThrowsFileCacheBytesNegative() {
    }
        assertEquals(500L, new NodeCacheService(fc, 0L).cacheUtilizedBytes());
        // Two distinct (but equal-valued) instances — identity proves "first wins".  
        var provider = mockProvider("0%", 1.0);
        BlockCache bc2 = mock(BlockCache.class);
        BlockCache singleTier = mock(BlockCache.class);
        BlockCache bc2 = mock(BlockCache.class);  
        when(bc1.stats()).thenReturn(new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0L, 0L, 100L, 30L));
    private BlockCache mockBlockCacheWithFullStats(
    public void testValidateThrowsNegativeBlockCacheBytes() {
        orc.addBlockCache(mockBlockCache(0, 0, 200L, 0, 1000L));
        FileCache fc = fileCacheWithStats(0, 0, 0, 0, 1000L, 0L, 0L);
        BlockCacheStats stats = new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 50L, 200L, 0L, 0L);
        when(fc.usage()).thenReturn(100L);
        BlockCache bc1 = mock(BlockCache.class);
        assertEquals(3, combined.evictions());
    }
    }
        assertEquals(1, orc.blockCaches().size());
        AggregateFileCacheStats s = orc.aggregateStats();  
        assertNotNull(combined);  
        FileCache fc = mock(FileCache.class);
    ) {
import org.opensearch.plugins.BlockCacheStats;
    }
    }
        when(provider.getBlockCache()).thenReturn(Optional.of(bc));
        FileCache fc = fileCacheWithStats(0L, 0L, 0L, 0L, 0L, 0L, 0L);
    public void testAggregateStatsNoBlockCacheReturnsFileCacheStatsOnly() {
        assertTrue("get(foyer) should return the registered cache", orc.get("foyer").isPresent());
        long hits,  
            0,  
    public void testValidateThrowsFileCacheBytesZero() {  
        when(fc.fileCacheStats()).thenReturn(agg);
    public void testComputeBlockCacheBudgetNoProviders() {  
        BlockCache tieredCache = mock(BlockCache.class);  
        FileCache fc = mock(FileCache.class);
        FileCache fc = mock(FileCache.class);  
        // Tiered cache exposing a per-tier breakdown.
    public void testAggregateStatsMergesActiveInBytesAcrossMultipleBlockCaches() {  
    }
            0,
        when(bc1.stats()).thenReturn(s);  
        FileCache fc = mock(FileCache.class);
        assertEquals(0L, new NodeCacheService(fc, 0L).blockCacheCapacityBytes());
    private BlockCacheProvider mockProvider(String sizePercent, double amplification) {
    public void testValidateThrowsSumExceedsTotalSSD() {
    }  
        NodeCacheService orc = new NodeCacheService(fc, 0L);  
        FileCache fc = fileCacheWithStats(0, 0, 0, 0, 1000L, 0L, 0L);
        AggregateFileCacheStats agg = new AggregateFileCacheStats(System.currentTimeMillis(), overall, zeroFull, zero, zeroPinned);
    }
        assertNull(orc.combinedBlockCacheStats());  
        BlockCache bc = mock(BlockCache.class);  
        when(tieredCache.tieredStats()).thenReturn(tiered);
            hitBytes,  
    public void testCacheUtilizedIncludesFileCache() {
        return fc;  
        // removedBytes from block cache must be folded into the overall removed_in_bytes field
    // ── BlockCacheRegistry.get(name) ──────────────────────────────────────────  
        assertEquals(2, orc.blockCaches().size());  
        assertEquals(0L, NodeCacheService.computeVirtualBlockCacheBytes(Map.of(), Settings.EMPTY, 1000L));
import org.opensearch.plugins.BlockCacheProvider;
        BlockCache bc1 = mock(BlockCache.class);  
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        assertEquals(1250L, NodeCacheService.computeVirtualBlockCacheBytes(Map.of("foyer", provider), Settings.EMPTY, 1000L));
        assertEquals(1, orc.blockCaches().size());  
    private BlockCacheTieredStats sampleTieredStats() {
    }
        BlockCacheTieredStats second = sampleTieredStats();
        orc.registerProviders(Map.of("empty", emptyProvider));
    public void testComputeVirtualBlockCacheBytesRatioOneEqualsReserved() {
        BlockCacheStats stats = new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 512L, 0L);
        NodeCacheService.validate(800L, 0L, 1000L);
        assertEquals(300L, s.getEvicted().getBytes());
        NodeCacheService orc = new NodeCacheService(fc, 0L);
    public void testComputeVirtualBlockCacheBytesSumsMultipleProviders() {
        assertSame(fc, new NodeCacheService(fc, 0L).fileCache());  
        FileCacheStats overall = new FileCacheStats(
        FileCache fc = fileCacheWithStats(0, 0, 400L, 0, 1000L, 0L, 0L);
        assertEquals(3072, combined.totalBytes());
    public void testClosePropagatesToAllBlockCaches() throws Exception {
    }  
/*  
        orc.addBlockCache(bc2);
        NodeCacheService orc = new NodeCacheService(fc, 0L);  
        BlockCache bc1 = mock(BlockCache.class);  
    // ── BlockCacheRegistry.all() ──────────────────────────────────────────────  
        orc.close();  
        AggregateFileCacheStats stats = orc.aggregateStats();  
        assertEquals("tiered breakdown must propagate into the combined stats", tiered, combined.tieredStats());  
    }  
        orc.addBlockCache(mockBlockCache(0, 0, 300L, 0, 1000L));
 *
        expectThrows(SettingsException.class, () -> NodeCacheService.validate(-1L, 600L, 1000L));
        when(bc2.stats()).thenReturn(new BlockCacheStats(20, 3, 200, 30, 1, 100, 0, 0, 0, 512, 1024, 0));
    // ── addBlockCache / blockCaches ───────────────────────────────────────────
        AggregateFileCacheStats stats = orc.aggregateStats();
            inv -> Math.round((long) inv.getArgument(1) * ratio)  
        AggregateFileCacheStats s = orc.aggregateStats();
    public void testBlockCacheDiskBytesUsedIgnoresMemory() {  
    private BlockCache mockBlockCache(long hits, long misses, long diskUsed, long memUsed, long total) {
    public void testAggregateStatsMergesHitsFromBlockCache() {  
    // ── blockCacheCapacityBytes ───────────────────────────────────────────────  
        SettingsException ex = expectThrows(SettingsException.class, () -> NodeCacheService.validate(700L, 400L, 1000L));  
    }  
        assertTrue(ex.getMessage().contains("SSD capacity"));
        FileCache fc = mock(FileCache.class);
            active,  
    }
        FileCache fc = fileCacheWithStats(fcActive, 0L, 0L, 0L, 1000L, 0L, 0L);
        // merged active = file-cache active + block-cache activeInBytes
    public void testAllReturnsAllRegisteredBlockCaches() {
/**  
        assertEquals(250L, NodeCacheService.computeBlockCacheBudget(Map.of("foyer", provider), Settings.EMPTY, 1000L));  
        orc.addBlockCache(mockBlockCache(0, 0, 300L, 0, 0));  
        AggregateFileCacheStats s = orc.aggregateStats();
        BlockCache bc2 = mock(BlockCache.class);  
            AggregateFileCacheStats.FileCacheStatsType.PINNED_FILE_STATS
        when(emptyProvider.getBlockCache()).thenReturn(Optional.empty());
        FileCache fc = fileCacheWithStats(0L, 0L, 0L, 0L, 0L, 0L, 0L);  
        when(bc.stats()).thenReturn(new BlockCacheStats(0, 0, 0, 0, 0, 0, removed, removedBytes, 0, 0, 100L, 0L));
    }  
    }  
    // ── Helpers ───────────────────────────────────────────────────────────────
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        BlockCacheProvider emptyProvider = mock(BlockCacheProvider.class);
    public void testAllReturnsEmptyWhenNoBlockCaches() {
        SettingsException ex = expectThrows(SettingsException.class, () -> NodeCacheService.validate(600L, 200L, 0L));  
            pinned,  
        assertEquals(1000L, orc.blockCacheCapacityBytes());  
    public void testValidatePassesZeroBlockCache() {  
    // ── blockCacheDiskBytesUsed ───────────────────────────────────────────────  
        when(bc.stats()).thenReturn(stats);
        assertEquals(400L, orc.cacheUtilizedBytes());
        assertEquals(1500L, s.getTotal().getBytes());
    }  
        FileCache fc = mock(FileCache.class);  
        orc.addBlockCache(tieredCache);
        assertEquals(8, combined.misses());
        when(bc1.stats()).thenReturn(new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1L, 0));
    public void testAggregateStatsMergesUsedBytesFromBlockCacheDisk() {
    public void testAggregateStatsActiveInBytesZeroWithNoBlockCache() {  
        orc.addBlockCache(bc1);  
            removed,
    }
        when(bc.stats()).thenReturn(stats);
        BlockCacheStats combined = orc.combinedBlockCacheStats();
            0,
        FileCache fc = fileCacheWithStats(0L, 0L, 0L, 0L, 0L, 0L, 0L);  
import org.opensearch.test.OpenSearchTestCase;
        AggregateFileCacheStats s = orc.aggregateStats();
        var provider = mockProvider("30%", 1.0);  // 300 × 1 = 300  
    // ── validate() ────────────────────────────────────────────────────────────  
        BlockCache bc = mockBlockCache(0, 0, 0, 0, 100L);
            evictions,
        expectThrows(SettingsException.class, () -> NodeCacheService.validate(0L, 1000L, 1000L));
        // Non-tiered cache (default mock → tieredStats() == null).  
        assertEquals(500L, orc.blockCacheDiskBytesUsed());  
        BlockCache bc = mock(BlockCache.class);  
import java.util.Map;  
        FileCache fc = mock(FileCache.class);
    }  
        FileCache fc = fileCacheWithStats(0, 0, 500L, 0, 1000L, 50L, 0L);  
    }
    // ── computeVirtualBlockCacheBytes ─────────────────────────────────────────
        FileCache fc = mock(FileCache.class);  
    }
        long missBytes,  
        assertEquals(50L, s.getEvicted().getBytes());
        long memBytesUsed,
        when(bc.cacheName()).thenReturn("foyer");  
            totalBytes,
    }
        assertEquals(300L, NodeCacheService.computeVirtualBlockCacheBytes(Map.of("foyer", provider), Settings.EMPTY, 1000L));
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        when(withoutCache.getBlockCache()).thenReturn(Optional.empty());
        FileCache fc = mock(FileCache.class);
        FileCache fc = mock(FileCache.class);
    public void testCombinedBlockCacheStatsPicksFirstTieredWhenMultiplePresent() {
        when(bc1.tieredStats()).thenReturn(first);
        AggregateFileCacheStats s = orc.aggregateStats();
    }  
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        orc.registerProviders(Map.of("foyer", provider));
            0,
        BlockCacheStats stats = new BlockCacheStats(hits, misses, 0, 0, 0, 0, 0, 0, memUsed, diskUsed, total, 0L);
        BlockCacheTieredStats first = sampleTieredStats();
    }  
        orc.addBlockCache(bc1);  
    }
    // ── aggregateStats — mergeStats path (block cache present) ───────────────
        when(bc2.stats()).thenReturn(new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        assertEquals(1, orc.blockCaches().size());
        FileCache fc = mock(FileCache.class);
    // ── computeBlockCacheBudget ───────────────────────────────────────────────
        when(bc1.stats()).thenReturn(new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));  
    public void testComputeVirtualBlockCacheBytesNoProviders() {
        NodeCacheService orc = new NodeCacheService(fc, 0L);
    public void testRegisterProvidersWiresCacheFromProvider() {
    // ── cacheUtilizedBytes ────────────────────────────────────────────────────  
    }  
        BlockCacheProvider provider = mock(BlockCacheProvider.class);
    public void testAggregateStatsMergesTotalCapacityFromBlockCache() {  
        );  
        return new BlockCacheTieredStats(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22);
        FileCache fc = mock(FileCache.class);
        NodeCacheService orc = new NodeCacheService(fc, 0L);
    public void testValidateThrowsZeroTotalSSD() {
        when(tieredCache.stats()).thenReturn(new BlockCacheStats(20, 3, 0, 0, 0, 0, 0, 0, 0, 512, 1024, 0));
            diskBytesUsed,
        BlockCacheProvider withoutCache = mock(BlockCacheProvider.class);  
        FileCache fc = fileCacheWithStats(0L, 0L, 0L, 0L, 0L, 0L, 0L);  
            hits,
    public void testBlockCacheCapacitySumsAcrossCaches() {
        when(bc2.stats()).thenReturn(s);
        assertEquals(2, orc.all().size());
        assertSame(bc, orc.blockCaches().get(0));
        assertNotNull(combined);
        BlockCache bc = mock(BlockCache.class);  
        var p2 = mockProvider("10%", 2.0);  // 100 × 2 = 200
        AggregateFileCacheStats stats = orc.aggregateStats();
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        when(bc2.stats()).thenReturn(new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0L, 0L, 100L, 20L));
        );  
        orc.addBlockCache(bc);
    // ── combinedBlockCacheStats() ─────────────────────────────────────────────
    }
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        long removedBytes = 3500L;
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        String stripped = sizePercent.endsWith("%") ? sizePercent.substring(0, sizePercent.length() - 1) : sizePercent;  
        FileCache fc = fileCacheWithStats(0, 0, 0, 0, 1000L, 0L, 0L);
    }
    }
        when(provider.getBlockCache()).thenReturn(Optional.empty());  
    public void testComputeBlockCacheBudgetSingleProvider() {
    public void testCacheUtilizedIncludesBlockCacheDisk() {
        orc.addBlockCache(mockBlockCache(0, 0, 0L, 100L, 1000L));  
    }
        org.mockito.Mockito.verify(bc2).close();  
import static org.mockito.Mockito.mock;  
        orc.addBlockCache(mockBlockCacheWithFullStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 500L));  
    }
        assertEquals(50L, s.getCacheHits());
        orc.addBlockCache(bc1);  
        FileCache fc = fileCacheWithStats(0L, 0L, 0L, 0L, 0L, 0L, 0L);
    public void testGetByNameReturnsEmptyForUnknownName() {
    public void testAggregateStatsMergesActiveInBytesFromBlockCache() {
    }
        long fcActive = 100L;  
        orc.addBlockCache(bc2);
        orc.addBlockCache(bc);
        orc.addBlockCache(mockBlockCacheWithFullStats(50L, 10L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 500L));  
    public void testCombinedBlockCacheStatsReturnsNullWhenNoBlockCaches() {  
        long bcActive = 50L;
    }
package org.opensearch.index.store.remote.filecache;
        orc.addBlockCache(bc);
    }
    }
    public void testCombinedBlockCacheStatsPropagatesTieredStatsFromTieredCache() {
        BlockCacheTieredStats tiered = sampleTieredStats();
        NodeCacheService orc = new NodeCacheService(fc, 0L);
import org.opensearch.common.settings.SettingsException;
    public void testAggregateStatsBlockSectionAlsoMerged() {  
        assertTrue(orc.all().isEmpty());
        FileCache fc = fileCacheWithStats(0L, 0L, 0L, 0L, 0L, 0L, 0L);  
 */  
        );
        when(bc.stats()).thenReturn(stats);
        assertEquals(1000L, NodeCacheService.computeVirtualBlockCacheBytes(Map.of("p1", p1, "p2", p2), Settings.EMPTY, 1000L));
    }
    public void testComputeBlockCacheBudgetZeroPercentProvider() {  
            missBytes,
        FileCache fc = fileCacheWithStats(0L, 0L, 0L, 0L, 0L, 0L, 0L);  
 * this file be licensed under the Apache-2.0 license or a
        orc.addBlockCache(mockBlockCache(0, 0, 0, 0, 500L));
        assertEquals(10L, s.getCacheMisses());  
 * The OpenSearch Contributors require contributions made to  
        double ratio = Double.parseDouble(stripped) / 100.0;
        // Create a BlockCacheStats with activeInBytes=bcActive  
        FileCache fc = fileCacheWithStats(fcActive, 0L, 0L, 0L, 1000L, 0L, 0L);
        NodeCacheService orc = new NodeCacheService(fc, 0L);  
    public void testAddBlockCacheRegistersIt() {
        orc.addBlockCache(mockBlockCache(0, 0, 0, 0, 600L));
        long removed,  
        orc.addBlockCache(null);  
        BlockCache bc1 = mock(BlockCache.class);
        assertEquals(300, combined.hitBytes());  
    }
            evicted,
    public void testBlockCacheDiskBytesUsedZeroWhenNone() {
        FileCache fc = fileCacheWithStats(0L, 0L, 0L, 0L, 0L, 0L, 0L);  
    public void testBlockCachesListIsUnmodifiable() {  
        orc.addBlockCache(bc);
        NodeCacheService orc = new NodeCacheService(fc, 0L);
    }  
            total,
        when(bc1.stats()).thenReturn(new BlockCacheStats(10, 5, 100, 50, 2, 200, 1, 10, 0, 1024, 2048, 0));
    }  
        orc.addBlockCache(mockBlockCache(2, 0, 0, 0, 20L));
        NodeCacheService orc = new NodeCacheService(fc, 0L);  
        assertEquals(0, orc.blockCaches().size());
        assertEquals(0, orc.blockCaches().size());
        AggregateFileCacheStats s = orc.aggregateStats();
        assertEquals(80, combined.missBytes());
        BlockCacheStats stats = new BlockCacheStats(  
        when(bc2.tieredStats()).thenReturn(second);
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        long totalBytes
        assertSame(bc, orc.get("foyer").get());
        when(fc.usage()).thenReturn(0L);  
        FileCache fc = fileCacheWithStats(fcActive, 0L, 0L, 0L, 1000L, 0L, 0L);
            hits,  
        assertEquals(1536, combined.diskBytesUsed());
        return bc;
 * capacity and utilization accessors — all without real FileCache from disk.
            0L      // activeInBytes — not exercised in this helper; tests that need it set it directly  
    private FileCache fileCacheWithStats(long active, long hits, long used, long pinned, long total, long evicted, long removed) {
    }  
        var provider = mockProvider("25%", 1.0);
        var p2 = mockProvider("10%", 1.0);  // 100 of 1000
        return bc;
    }
public class NodeCacheServiceTests extends OpenSearchTestCase {
        assertEquals(fcActive, stats.getActive().getBytes());  
        assertEquals(300, combined.evictionBytes());  
        BlockCache bc = mock(BlockCache.class);
import org.opensearch.plugins.BlockCacheTieredStats;  
        assertEquals(7L, s.getBlockFileCacheStats().getCacheHits());
import org.opensearch.plugins.BlockCache;  
            evictionBytes,  
        when(withCache.getBlockCache()).thenReturn(Optional.of(bc));
        expectThrows(SettingsException.class, () -> NodeCacheService.validate(800L, -1L, 1000L));  
    // ── aggregateStats: activeInBytes ──────────────────────────────────────────  
        long removed = 7L;
            0,  
            removedBytes,
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        orc.addBlockCache(bc2);
    }  
        FileCache fc = mock(FileCache.class);  
    // ── close() propagation ───────────────────────────────────────────────────  
        assertEquals(500L, s.getUsed().getBytes());
        );
        assertEquals(0L, NodeCacheService.computeBlockCacheBudget(Map.of("foyer", provider), Settings.EMPTY, 1000L));
    }
        assertTrue(ex.getMessage().contains("exceeds") || ex.getMessage().contains("Reduce"));
    }
import static org.mockito.Mockito.when;
        orc.addBlockCache(mockBlockCache(0, 0, 0, 0, 500L));
        orc.addBlockCache(mockBlockCacheWithFullStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 200L, 500L));
    public void testComputeBlockCacheBudgetMultipleProviders() {  
        long diskBytesUsed,  
    public void testValidateThrowsNegativeTotalSSD() {
    public void testGetByNameReturnsRegisteredBlockCache() {
        FileCache fc = mock(FileCache.class);  
        BlockCache bc2 = mock(BlockCache.class);  
    public void testValidatePassesSumEqualsTotalSSD() {
    }
        orc.addBlockCache(mockBlockCache(0, 0, 0, 0, 1L));  
    public void testComputeVirtualBlockCacheBytesAppliesRatio() {
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        BlockCacheStats s = new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1L, 0L);
        assertEquals(fcActive + 30L + 20L, stats.getActive().getBytes());
        FileCache fc = mock(FileCache.class);
        assertEquals(0L, new NodeCacheService(fc, 0L).blockCacheDiskBytesUsed());
    }
            AggregateFileCacheStats.FileCacheStatsType.OVER_ALL_STATS
        FileCache fc = fileCacheWithStats(0L, 0L, 0L, 0L, 0L, 0L, 0L);
    }
        orc.addBlockCache(mockBlockCacheWithFullStats(7L, 3L, 0, 0, 0, 0, 0, 0, 0, 100L, 200L));  
            used,
        NodeCacheService orc = new NodeCacheService(fc, 0L);  
    public void testAddNullBlockCacheIgnored() {  
    }
    public void testCacheUtilizedIncludesBlockCacheMemory() {
        orc.addBlockCache(mockBlockCache(0, 0, 0, 0, 400L));
    public void testAddMultipleBlockCaches() {
        assertEquals(350L, NodeCacheService.computeBlockCacheBudget(Map.of("p1", p1, "p2", p2), Settings.EMPTY, 1000L));  
        long misses,
        BlockCache bc = mockBlockCache(0, 0, 0, 0, 1000L);
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        FileCache fc = mock(FileCache.class);
    public void testBlockCacheDiskBytesUsedSumsAcrossCaches() {
    }
        orc.addBlockCache(bc1);
    public void testValidatePassesLegalValues() {
        assertEquals(0L, NodeCacheService.computeBlockCacheBudget(Map.of(), Settings.EMPTY, 1000L));
        FileCache fc = fileCacheWithStats(0L, 0L, 0L, 0L, 0L, 0L, 0L);  
        orc.addBlockCache(bc2);  
    }
    public void testAggregateStatsMergesRemovedCountFromBlockCache() {  
    public void testRegisterProvidersWithEmptyOptionalSkipsCache() {  
    }
    public void testAggregateStatsMergesEvictionBytesFromBlockCache() {
        NodeCacheService orc = new NodeCacheService(fc, 0L);  
            0,
        assertEquals(1000L, s.getTotal().getBytes());  
        FileCache fc = fileCacheWithStats(0, 0, 0, 0, 1000L, 100L, 0L);  
        orc.addBlockCache(singleTier);
        BlockCacheStats combined = orc.combinedBlockCacheStats();
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        AggregateFileCacheStats stats = orc.aggregateStats();
}
        expectThrows(SettingsException.class, () -> NodeCacheService.validate(600L, 200L, -1L));
 */  
        long fcActive = 200L;
        assertSame("first non-null tieredStats must win", first, orc.combinedBlockCacheStats().tieredStats());
 * compatible open source license.
        NodeCacheService orc = new NodeCacheService(fc, 0L);  
        long removedBytes,
    public void testCombinedBlockCacheStatsNullTieredWhenNoCacheIsTiered() {  
        assertTrue(orc.all().contains(bc2));
        assertEquals(30, combined.hits());
        assertFalse("get(unknown) should return empty Optional", orc.get("unknown").isPresent());  
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        // No block cache registered
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        when(bc.stats()).thenReturn(stats);  
    }
        BlockCache bc2 = mock(BlockCache.class);
        when(fc.usage()).thenReturn(500L);
    }
        org.mockito.Mockito.verify(bc1).close();
        long evictions,
        BlockCache bc = mock(BlockCache.class);
            misses,
        when(provider.requestedCapacityBytes(org.mockito.ArgumentMatchers.any(), org.mockito.ArgumentMatchers.anyLong())).thenAnswer(
    // ── registerProviders ─────────────────────────────────────────────────────
        return provider;
        assertEquals(removedBytes, stats.getRemoved().getBytes());  
        FileCache fc = mock(FileCache.class);  
    public void testCombinedBlockCacheStatsAggregatesAcrossMultipleCaches() {  
    public void testBlockCacheCapacityZeroWhenNone() {
        long hitBytes,
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        NodeCacheService orc = new NodeCacheService(fc, 0L);
        FileCache fc = fileCacheWithStats(0L, 0L, 0L, 0L, 0L, 0L, 0L);  
        assertEquals(fcActive + bcActive, stats.getActive().getBytes());  
        FileCacheStats zeroFull = new FileCacheStats(0, 0, 0, 0, 0, 0, 0, 0, AggregateFileCacheStats.FileCacheStatsType.FULL_FILE_STATS);
        assertSame(bc, orc.blockCaches().get(0));  
import org.opensearch.common.settings.Settings;
        // 25% of 1000 = 250 bytes reserved × ratio 5.0 = 1250 virtual bytes  
        when(fc.usage()).thenReturn(used);
 * Unit tests for {@link NodeCacheService}: budget validation, addBlockCache,
        orc.addBlockCache(bc2);
        assertEquals(250L, orc.cacheUtilizedBytes());  
        when(singleTier.stats()).thenReturn(new BlockCacheStats(10, 5, 0, 0, 0, 0, 0, 0, 0, 1024, 2048, 0));
        NodeCacheService orc = new NodeCacheService(fc, 0L);
            0L,
    }  
        BlockCache bc1 = mock(BlockCache.class);
        BlockCache bc = mock(BlockCache.class);  
        NodeCacheService orc = new NodeCacheService(fc, 0L);
    }
        long evictionBytes,
        orc.addBlockCache(mockBlockCache(1, 0, 0, 0, 10L));  
        orc.addBlockCache(mockBlockCacheWithFullStats(0, 0, 0, 0, 0, 200L, 0, 0, 0, 200L, 500L));
        assertEquals(0L, orc.blockCacheDiskBytesUsed());
    public void testFileCacheAccessor() {
        var p1 = mockProvider("25%", 1.0);  // 250 of 1000
        assertEquals(600L, s.getUsed().getBytes());  
        when(provider.dataToCapacityRatio(org.mockito.ArgumentMatchers.any())).thenReturn(amplification);
        BlockCache bc = mockBlockCache(0, 0, 0, 0, 500L);  
            0,
    }  
