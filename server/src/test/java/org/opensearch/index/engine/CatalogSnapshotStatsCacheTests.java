            .addSearchableFiles("parquet", gen1Files)
        CatalogSnapshot snapshot = mock(CatalogSnapshot.class);
        return new CatalogSnapshotStatsCache(
        assertEquals(4000L, docsStats.getTotalSizeInBytes());
    }
        useRealDocCountAggregation(snapshot);
        cache.beforeRefresh(); // Should complete without exception
import org.opensearch.index.engine.exec.coord.CatalogSnapshotManager;
    }
        assertNotNull(cache.getDocsStats());
        }
        org.opensearch.index.engine.exec.Segment gen2 = org.opensearch.index.engine.exec.Segment.builder(2L)
        when(snapshot.buildEngineSegments(any(), any(), any())).thenReturn(Collections.emptyList());
        CatalogSnapshotManager snapshotManager = mock(CatalogSnapshotManager.class);
        useRealDocCountAggregation(snapshot);
        assertNotNull(stats.getFileSizes());
    }
        java.nio.file.Files.write(tempDir.resolve("seg1.parquet"), new byte[1000]);
        // Test buildSegmentsStats with external memory and timestamp
        when(snapshot.collectFileSizesGroupedByExtension(store)).thenReturn(Collections.emptyMap());
        when(snapshot.buildEngineSegments(any(), any(), any())).thenReturn(Collections.emptyList());
        cache.afterRefresh(true);
        assertEquals(initialDocsCount, cache.getDocsStats().getCount());
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
import static org.mockito.Mockito.when;
        when(snapshotManager.acquireSnapshot()).thenReturn(new GatedCloseable<>(snapshot, () -> {}));
        Logger logger = mock(Logger.class);
        when(snapshot.getSegments()).thenReturn(List.of(emptySegment));
        // Mock snapshot to return test data with multiple files of same extension
        java.nio.file.Files.write(tempDir.resolve("seg2.parquet"), new byte[2500]);
        java.nio.file.Path tempDir = createTempDir();
package org.opensearch.index.engine;
        assertEquals(10L, docsStats.getCount());
        assertEquals(0L, docsStats.getTotalSizeInBytes());
        Store store = mock(Store.class);
        CatalogSnapshotStatsCache cache = newCache(snapshotManager, store, logger, reported);
        when(snapshotManager.acquireSnapshot()).thenReturn(new GatedCloseable<>(snapshot, () -> {}));
        when(snapshotManager.acquireSnapshot()).thenReturn(new GatedCloseable<>(snapshot, () -> {}));
        when(snapshotManager.acquireSnapshot()).thenReturn(new GatedCloseable<>(snapshot, () -> {}));
        assertEquals(13L, docsStats.getCount());
        CatalogSnapshotStatsCache cache = newCache(snapshotManager, store, logger);
import org.opensearch.test.OpenSearchTestCase;
        CatalogSnapshotManager snapshotManager = mock(CatalogSnapshotManager.class);
        Logger logger = mock(Logger.class);
    }
        Map<String, Long> fileSizes = stats.getFileSizes();
        // Call afterRefresh with didRefresh=false
        Store store = mock(Store.class);
        assertEquals(0L, docsStats.getCount());
            .build();
        useRealDocCountAggregation(snapshot);
        CatalogSnapshotManager snapshotManager = mock(CatalogSnapshotManager.class);
        assertEquals(0, stats.getCount());
        org.opensearch.index.engine.exec.Segment segment = org.opensearch.index.engine.exec.Segment.builder(1L)
        org.opensearch.index.engine.exec.Segment segment2 = org.opensearch.index.engine.exec.Segment.builder(2L)
import java.util.Map;
        when(snapshot.collectFileSizesGroupedByExtension(store)).thenReturn(Collections.emptyMap());
        org.opensearch.index.engine.exec.Segment emptySegment = org.opensearch.index.engine.exec.Segment.builder(1L).build();
        Map<Long, DocCounts> reported = Map.of(1L, new DocCounts(4, 6), 2L, new DocCounts(3, 1));
public class CatalogSnapshotStatsCacheTests extends OpenSearchTestCase {
        assertEquals(initialSegmentsCount, cache.getSegmentsStats().getCount());
            fail("Refresh methods should not throw exceptions: " + e.getMessage());
        useRealDocCountAggregation(snapshot);
        assertEquals(7L, docsStats.getDeleted());
        assertNotNull(cache.getSegmentsStats());
        Store store = mock(Store.class);
import org.opensearch.index.engine.exec.DocCounts;
        // Stats values should remain unchanged (but objects may be different)
        SegmentsStats initialSegmentsStats = cache.getSegmentsStats();
        long initialDocsCount = initialDocsStats.getCount();
        Store store = mock(Store.class);
        when(snapshot.aggregateDocCounts(any())).thenCallRealMethod();
        CatalogSnapshotStatsCache cache = newCache(snapshotManager, store, logger);
import org.opensearch.index.shard.DocsStats;
import org.opensearch.index.store.Store;
    }
        org.opensearch.index.engine.exec.Segment segment3 = org.opensearch.index.engine.exec.Segment.builder(3L).build();
        WriterFileSet parquetSet2 = new WriterFileSet(tempDir.toString(), 2L, java.util.Set.of("seg2.parquet"), 3, 1L);
        Map<Long, DocCounts> reported = Map.of(1L, new DocCounts(8, 2));
        assertEquals(200L, docsStats.getTotalSizeInBytes());
            .addSearchableFiles("parquet", gen2Files)
        assertEquals(750L, docsStats.getTotalSizeInBytes());
    public void testDataFormatAwareNRTReplicationEngineWiring() {
        // totalSizeInBytes = 1000 + 2500 + 500 = 4000
import java.io.IOException;
    public void testComputeDocsStatsTotalSizeWithMissingFiles() throws IOException {
        CatalogSnapshotManager snapshotManager = mock(CatalogSnapshotManager.class);
    private static CatalogSnapshotStatsCache newCache(
        CatalogSnapshotStatsCache cache = newCache(snapshotManager, store, logger);
    }
     * Builds a cache whose liveness resolver reports nothing, which is what a shard made only of
    }
        CatalogSnapshotManager snapshotManager = mock(CatalogSnapshotManager.class);
        // Verify cache can handle refresh events
        CatalogSnapshot snapshot = mock(CatalogSnapshot.class);
    /**
    public void testCacheInitialization() {
        Map<Long, DocCounts> docCounts
    public void testDocsStatsFallsBackToPhysicalRowsForUnreportedGenerations() throws IOException {
        cache.afterRefresh(true);
        org.opensearch.index.engine.exec.Segment gen1 = org.opensearch.index.engine.exec.Segment.builder(1L)
        // Create real Segment instances using the builder
        // but we can verify the stats cache methods work as expected
        assertEquals(0L, docsStats.getCount());
        java.nio.file.Files.write(tempDir.resolve("exists.parquet"), new byte[750]);
        CatalogSnapshotManager snapshotManager = mock(CatalogSnapshotManager.class);
            .build();
        assertEquals(7L, docsStats.getCount());
        cache.afterRefresh(true);
        cache.afterRefresh(false);
        when(snapshot.buildEngineSegments(any(), any(), any())).thenReturn(Collections.emptyList());
        Store store = mock(Store.class);
import java.util.Collections;
import org.opensearch.index.engine.exec.WriterFileSet;
        org.opensearch.index.engine.exec.Segment segment1 = org.opensearch.index.engine.exec.Segment.builder(1L)
        assertNotNull(segments);
 * compatible open source license.
        assertEquals(300L, (long) fileSizes.get("parquet")); // 100 + 200
        CatalogSnapshotStatsCache cache = newCache(snapshotManager, store, logger);
        when(snapshot.collectFileSizesGroupedByExtension(store)).thenReturn(Collections.emptyMap());
            Collections::emptyMap,
        java.nio.file.Path tempDir = createTempDir();
        WriterFileSet gen2Files = new WriterFileSet(tempDir.toString(), 2L, java.util.Set.of("gen2.parquet"), 5, 1L);
        CatalogSnapshotManager snapshotManager,
        assertEquals(75L, (long) fileSizes.get("nvm"));
}
        Logger logger = mock(Logger.class);
        CatalogSnapshot snapshot = mock(CatalogSnapshot.class);
        // beforeRefresh should not throw
        assertNotNull(segmentsStats);
        CatalogSnapshot snapshot = mock(CatalogSnapshot.class);
        when(snapshot.getSegments()).thenReturn(List.of(gen1, gen2));
            // If we get here, no exception was thrown
    }
        DocsStats docsStats = cache.getDocsStats();
        when(snapshot.getSegments()).thenReturn(List.of(segment1, segment2));
        SegmentsStats stats = cache.getSegmentsStats();
        assertEquals(0, segmentsStats.getCount());
            .build();
        WriterFileSet fileSet = new WriterFileSet(tempDir.toString(), 1L, java.util.Set.of("exists.parquet", "missing.parquet"), 10, 1L);
        CatalogSnapshotStatsCache cache = newCache(snapshotManager, store, logger);
        CatalogSnapshotManager snapshotManager = mock(CatalogSnapshotManager.class);
        when(snapshot.getSegments()).thenReturn(List.of(gen1, gen2));
import org.apache.logging.log4j.Logger;
        when(snapshotManager.acquireSnapshot()).thenReturn(new GatedCloseable<>(snapshot, () -> {}));
        Store store = mock(Store.class);
 * this file be licensed under the Apache-2.0 license or a
        try {
        assertTrue(segments.isEmpty());
        SegmentsStats segmentsStats = cache.getSegmentsStats();
        Store store = mock(Store.class);
        DocsStats docsStats = cache.getDocsStats();
        // Only generation 1 is reported; generation 2's 5 rows must all count as live.
        CatalogSnapshotManager snapshotManager = mock(CatalogSnapshotManager.class);
    }
        assertNotNull(cache.getSegments());
        WriterFileSet gen1Files = new WriterFileSet(tempDir.toString(), 1L, java.util.Set.of("gen1.parquet"), 10, 1L);
        when(snapshot.getSegments()).thenReturn(Collections.emptyList());
    }
            cache.afterRefresh(false);
        Logger logger = mock(Logger.class);
        // Mock snapshot manager to throw exception
        assertEquals(1024L, stats.getIndexWriterMemoryInBytes());
        when(snapshot.collectFileSizesGroupedByExtension(store)).thenReturn(Collections.emptyMap());
        // Verify cache starts with empty stats
import java.util.List;
        when(snapshot.collectFileSizesGroupedByExtension(store)).thenReturn(Collections.emptyMap());
        useRealDocCountAggregation(snapshot);
        List<Segment> segments = cache.getSegments();
    }
        long initialSegmentsCount = initialSegmentsStats.getCount();
    }
        CatalogSnapshotStatsCache cache = newCache(snapshotManager, store, logger);
    ) {
    private static void useRealDocCountAggregation(CatalogSnapshot snapshot) {
        // Create one real file and reference a non-existent file
            null, // EngineConfig is only used for the index sort, which these tests do not exercise
        cache.afterRefresh(true);
        org.opensearch.index.engine.exec.Segment gen2 = org.opensearch.index.engine.exec.Segment.builder(2L)
        // This test verifies that DFANRE properly wires the CatalogSnapshotStatsCache
        );
        assertEquals(0L, docsStats.getCount());
    public void testBeforeRefresh() throws IOException {
        java.nio.file.Files.write(tempDir.resolve("gen1.parquet"), new byte[100]);
        CatalogSnapshotStatsCache cache = newCache(snapshotManager, store, logger, reported);
        Store store = mock(Store.class);
        return newCache(snapshotManager, store, logger, Map.of());
        // No format reported liveness, so all 5 + 3 rows count as live
        when(snapshot.buildEngineSegments(any(), any(), any())).thenReturn(Collections.emptyList());
        DocsStats docsStats = cache.getDocsStats();
/*
        assertEquals(50L, (long) fileSizes.get("fnm"));
        assertEquals(initialSegmentsSize, cache.getSegments().size());
        // Only the existing file contributes; missing file returns 0
        Store store,
        // Should still return valid (empty) stats despite constructor refresh failure
    public void testBuildSegmentsStatsWithSnapshot() {
        Logger logger = mock(Logger.class);
 */
        when(snapshot.collectFileSizesGroupedByExtension(store)).thenReturn(Map.of("parquet", 300L, "fnm", 50L, "nvm", 75L));
/**
        when(snapshot.buildEngineSegments(any(), any(), any())).thenReturn(Collections.emptyList());
        // Get initial stats values
        java.nio.file.Files.write(tempDir.resolve("seg3.lucene"), new byte[500]);
            .addSearchableFiles("lucene", luceneSet)
        CatalogSnapshotManager snapshotManager = mock(CatalogSnapshotManager.class);
        // Segment with no file sets
        DocsStats docsStats = cache.getDocsStats();
            .addSearchableFiles("parquet", parquetSet2)
            .addSearchableFiles("parquet", gen1Files)
        Logger logger = mock(Logger.class);
            .addSearchableFiles("parquet", gen2Files)
        Logger logger = mock(Logger.class);
    public void testComputeDocsStatsTotalSizeWithEmptySegments() throws IOException {
        // The hidden rows still occupy their files, so the reported size covers all 14 rows.
 *
        org.opensearch.index.engine.exec.Segment segment1 = org.opensearch.index.engine.exec.Segment.builder(1L).build();
        Store store = mock(Store.class);
        CatalogSnapshot snapshot = mock(CatalogSnapshot.class);
        Logger logger = mock(Logger.class);
        assertEquals(0L, docsStats.getDeleted());
        cache.afterRefresh(true);
        int initialSegmentsSize = initialSegments.size();
 * Tests for {@link CatalogSnapshotStatsCache}.
        assertEquals(0L, docsStats.getTotalSizeInBytes());
        java.nio.file.Files.write(tempDir.resolve("gen2.parquet"), new byte[100]);
        when(snapshot.getSegments()).thenReturn(List.of(segment1, segment2, segment3));
        useRealDocCountAggregation(snapshot);
            .build();
    public void testDocsStatsReportsLiveAndDeletedCountsWhenReported() throws IOException {
    public void testComputeDocsStatsTotalSizeNoSegments() throws IOException {
        java.nio.file.Path tempDir = createTempDir();
        SegmentsStats stats = cache.buildSegmentsStats(1024L, 100L, snapshot);
        assertEquals(8L, docsStats.getCount());
     * formats that never hide a row (Parquet alone, for instance) does.
        Logger logger = mock(Logger.class);
    }
        assertEquals(3, fileSizes.size()); // Should have 3 extensions
        WriterFileSet luceneSet = new WriterFileSet(tempDir.toString(), 1L, java.util.Set.of("seg3.lucene"), 5, 1L);
        // 6 of generation 1's rows were superseded or deleted, and 1 of generation 2's.
 */
        when(snapshot.buildEngineSegments(any(), any(), any())).thenReturn(Collections.emptyList());
        java.nio.file.Files.write(tempDir.resolve("gen2.parquet"), new byte[100]);
        when(snapshotManager.acquireSnapshot()).thenReturn(new GatedCloseable<>(snapshot, () -> {}));
        WriterFileSet parquetSet1 = new WriterFileSet(tempDir.toString(), 1L, java.util.Set.of("seg1.parquet"), 5, 1L);
        Logger logger = mock(Logger.class);
        DocsStats initialDocsStats = cache.getDocsStats();
        org.opensearch.index.engine.exec.Segment segment2 = org.opensearch.index.engine.exec.Segment.builder(2L).build();
        CatalogSnapshotStatsCache cache = newCache(snapshotManager, store, logger);
        DocsStats docsStats = cache.getDocsStats();
            store,
        cache.afterRefresh(true);
        when(snapshot.collectFileSizesGroupedByExtension(store)).thenReturn(Collections.emptyMap());
    }
            .addSearchableFiles("parquet", fileSet)
        CatalogSnapshotStatsCache cache = newCache(snapshotManager, store, logger);
        } catch (Exception e) {
        // We can't easily test the full engine construction due to complex dependencies,
import static org.mockito.ArgumentMatchers.any;
        CatalogSnapshot snapshot = mock(CatalogSnapshot.class);
import org.opensearch.common.concurrent.GatedCloseable;
        CatalogSnapshot snapshot = mock(CatalogSnapshot.class);
            cache.beforeRefresh();
        // Cache should start with empty stats before any refresh
        WriterFileSet gen1Files = new WriterFileSet(tempDir.toString(), 1L, java.util.Set.of("gen1.parquet"), 10, 1L);
import static org.mockito.Mockito.mock;
        CatalogSnapshotManager snapshotManager = mock(CatalogSnapshotManager.class);
            snapshot -> docCounts,
        org.opensearch.index.engine.exec.Segment gen1 = org.opensearch.index.engine.exec.Segment.builder(1L)
        CatalogSnapshotManager snapshotManager = mock(CatalogSnapshotManager.class);
        Logger logger = mock(Logger.class);
    }
        when(snapshotManager.acquireSnapshot()).thenReturn(new GatedCloseable<>(snapshot, () -> {}));
    private static CatalogSnapshotStatsCache newCache(CatalogSnapshotManager snapshotManager, Store store, Logger logger) {
        DocsStats docsStats = cache.getDocsStats();
            .addSearchableFiles("parquet", parquetSet1)
        CatalogSnapshotStatsCache cache = newCache(snapshotManager, store, logger);
     */
        Logger logger = mock(Logger.class);
            .build();
        Store store = mock(Store.class);
    public void testComputeDocsStatsTotalSizeFromMultipleSegments() throws IOException {
        // Create temp files with known sizes
 * The OpenSearch Contributors require contributions made to
        Store store = mock(Store.class);
        java.nio.file.Path tempDir = createTempDir();
        assertNotNull(stats);
        Store store = mock(Store.class);
    public void testAfterRefreshWithDidRefreshFalse() throws IOException {
        CatalogSnapshotManager snapshotManager = mock(CatalogSnapshotManager.class);
        when(snapshot.getSegments()).thenReturn(List.of(segment));
        Logger logger,
        java.nio.file.Files.write(tempDir.resolve("gen1.parquet"), new byte[100]);
        when(snapshotManager.acquireSnapshot()).thenThrow(new RuntimeException("Test exception"));
        assertEquals(2L, docsStats.getDeleted());
        CatalogSnapshotStatsCache cache = newCache(snapshotManager, store, logger);
        assertNotNull(docsStats);
        // Verify files are grouped by extension
    public void testConstructorWithFailingSnapshotManager() {
        when(snapshot.buildEngineSegments(any(), any(), any())).thenReturn(Collections.emptyList());
        useRealDocCountAggregation(snapshot);
        WriterFileSet gen2Files = new WriterFileSet(tempDir.toString(), 2L, java.util.Set.of("gen2.parquet"), 4, 1L);
 * SPDX-License-Identifier: Apache-2.0
            .build();
        // Mock acquireSnapshot for the constructor's refreshCachedStats() call
            logger
        // Generation 1 wrote 10 rows, generation 2 wrote 4 rows: 14 rows on disk in total.
        List<Segment> initialSegments = cache.getSegments();
        assertEquals(3, stats.getCount());
            snapshotManager,
        DocsStats docsStats = cache.getDocsStats();
            .build();
