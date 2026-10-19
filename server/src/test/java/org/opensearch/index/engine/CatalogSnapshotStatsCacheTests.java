import java.util.Map;
        assertEquals(2L, docsStats.getDeleted());
            .build();  
     * Builds a cache whose liveness resolver reports nothing, which is what a shard made only of
        Logger logger,  
        assertEquals(initialDocsCount, cache.getDocsStats().getCount());
        // Test buildSegmentsStats with external memory and timestamp
        java.nio.file.Files.write(tempDir.resolve("seg2.parquet"), new byte[2500]);
        Logger logger = mock(Logger.class);
    }  
    /**
        assertNotNull(stats);
        cache.afterRefresh(true);
        WriterFileSet gen1Files = new WriterFileSet(tempDir.toString(), 1L, java.util.Set.of("gen1.parquet"), 10, 1L);
    }  
        when(snapshotManager.acquireSnapshot()).thenReturn(new GatedCloseable<>(snapshot, () -> {}));  
        Store store = mock(Store.class);
        Store store = mock(Store.class);
        CatalogSnapshotManager snapshotManager = mock(CatalogSnapshotManager.class);
/**
        CatalogSnapshotStatsCache cache = newCache(snapshotManager, store, logger);
        return new CatalogSnapshotStatsCache(  
        org.opensearch.index.engine.exec.Segment gen2 = org.opensearch.index.engine.exec.Segment.builder(2L)
        when(snapshotManager.acquireSnapshot()).thenReturn(new GatedCloseable<>(snapshot, () -> {}));
        when(snapshot.collectFileSizesGroupedByExtension(store)).thenReturn(Map.of("parquet", 300L, "fnm", 50L, "nvm", 75L));
        // beforeRefresh should not throw
        DocsStats docsStats = cache.getDocsStats();  
    public void testBeforeRefresh() throws IOException {  
        assertEquals(50L, (long) fileSizes.get("fnm"));
import static org.mockito.Mockito.mock;
        useRealDocCountAggregation(snapshot);
            .addSearchableFiles("parquet", gen1Files)
        SegmentsStats initialSegmentsStats = cache.getSegmentsStats();
        SegmentsStats stats = cache.getSegmentsStats();  
    }
        when(snapshot.buildEngineSegments(any(), any(), any())).thenReturn(Collections.emptyList());
        // Verify files are grouped by extension
import static org.mockito.ArgumentMatchers.any;
        CatalogSnapshot snapshot = mock(CatalogSnapshot.class);
import org.opensearch.test.OpenSearchTestCase;  
        // We can't easily test the full engine construction due to complex dependencies,  
        java.nio.file.Path tempDir = createTempDir();
    }
        java.nio.file.Path tempDir = createTempDir();
        CatalogSnapshot snapshot = mock(CatalogSnapshot.class);
        Logger logger = mock(Logger.class);  
        CatalogSnapshotManager snapshotManager = mock(CatalogSnapshotManager.class);
import java.io.IOException;
        CatalogSnapshotManager snapshotManager = mock(CatalogSnapshotManager.class);
        when(snapshot.collectFileSizesGroupedByExtension(store)).thenReturn(Collections.emptyMap());
        CatalogSnapshotManager snapshotManager = mock(CatalogSnapshotManager.class);  
        assertEquals(0L, docsStats.getTotalSizeInBytes());  
        List<Segment> segments = cache.getSegments();  
            Collections::emptyMap,
        org.opensearch.index.engine.exec.Segment segment1 = org.opensearch.index.engine.exec.Segment.builder(1L)
        cache.afterRefresh(true);
            snapshotManager,
        Store store = mock(Store.class);  
        Store store = mock(Store.class);
 */  
        // This test verifies that DFANRE properly wires the CatalogSnapshotStatsCache
        // Create temp files with known sizes
import org.apache.logging.log4j.Logger;
        java.nio.file.Files.write(tempDir.resolve("gen1.parquet"), new byte[100]);
        when(snapshot.getSegments()).thenReturn(List.of(segment1, segment2));
        CatalogSnapshot snapshot = mock(CatalogSnapshot.class);  
        CatalogSnapshot snapshot = mock(CatalogSnapshot.class);
        when(snapshot.buildEngineSegments(any(), any(), any())).thenReturn(Collections.emptyList());
        CatalogSnapshotManager snapshotManager = mock(CatalogSnapshotManager.class);
        when(snapshot.aggregateDocCounts(any())).thenCallRealMethod();
        Map<Long, DocCounts> reported = Map.of(1L, new DocCounts(8, 2));
 * Tests for {@link CatalogSnapshotStatsCache}.  
        return newCache(snapshotManager, store, logger, Map.of());  
        cache.afterRefresh(true);  
        java.nio.file.Files.write(tempDir.resolve("seg3.lucene"), new byte[500]);
        Logger logger = mock(Logger.class);
            // If we get here, no exception was thrown
        Store store = mock(Store.class);
        assertEquals(3, fileSizes.size()); // Should have 3 extensions
    ) {
        assertEquals(1024L, stats.getIndexWriterMemoryInBytes());
        WriterFileSet gen2Files = new WriterFileSet(tempDir.toString(), 2L, java.util.Set.of("gen2.parquet"), 5, 1L);
        CatalogSnapshotManager snapshotManager = mock(CatalogSnapshotManager.class);
        assertEquals(0L, docsStats.getCount());  
        assertEquals(200L, docsStats.getTotalSizeInBytes());
        assertEquals(75L, (long) fileSizes.get("nvm"));  
        DocsStats docsStats = cache.getDocsStats();
        // 6 of generation 1's rows were superseded or deleted, and 1 of generation 2's.  
        CatalogSnapshotStatsCache cache = newCache(snapshotManager, store, logger);
        // No format reported liveness, so all 5 + 3 rows count as live  
import java.util.List;
    }
        assertEquals(initialSegmentsSize, cache.getSegments().size());  
        CatalogSnapshot snapshot = mock(CatalogSnapshot.class);  
            .addSearchableFiles("parquet", parquetSet1)  
        org.opensearch.index.engine.exec.Segment segment1 = org.opensearch.index.engine.exec.Segment.builder(1L).build();
        CatalogSnapshotStatsCache cache = newCache(snapshotManager, store, logger, reported);  
        Logger logger = mock(Logger.class);  
        Map<String, Long> fileSizes = stats.getFileSizes();  
        CatalogSnapshotStatsCache cache = newCache(snapshotManager, store, logger);
        assertEquals(0L, docsStats.getDeleted());
        assertEquals(13L, docsStats.getCount());
        assertEquals(0L, docsStats.getCount());
package org.opensearch.index.engine;
            .build();
        when(snapshot.collectFileSizesGroupedByExtension(store)).thenReturn(Collections.emptyMap());
        useRealDocCountAggregation(snapshot);  
        // but we can verify the stats cache methods work as expected
        org.opensearch.index.engine.exec.Segment segment3 = org.opensearch.index.engine.exec.Segment.builder(3L).build();  
    }
        Store store = mock(Store.class);
        // Should still return valid (empty) stats despite constructor refresh failure  
        CatalogSnapshotManager snapshotManager = mock(CatalogSnapshotManager.class);  
        java.nio.file.Path tempDir = createTempDir();  
            .addSearchableFiles("parquet", gen2Files)
    }
        assertEquals(8L, docsStats.getCount());
        org.opensearch.index.engine.exec.Segment segment = org.opensearch.index.engine.exec.Segment.builder(1L)
            .addSearchableFiles("parquet", gen1Files)
        // Mock acquireSnapshot for the constructor's refreshCachedStats() call
        java.nio.file.Files.write(tempDir.resolve("gen2.parquet"), new byte[100]);
        DocsStats docsStats = cache.getDocsStats();
        CatalogSnapshotManager snapshotManager = mock(CatalogSnapshotManager.class);  
        when(snapshotManager.acquireSnapshot()).thenReturn(new GatedCloseable<>(snapshot, () -> {}));
        java.nio.file.Files.write(tempDir.resolve("gen2.parquet"), new byte[100]);
            null, // EngineConfig is only used for the index sort, which these tests do not exercise  
        CatalogSnapshotStatsCache cache = newCache(snapshotManager, store, logger, reported);  
import org.opensearch.index.engine.exec.DocCounts;  
        // Only generation 1 is reported; generation 2's 5 rows must all count as live.  
        // Call afterRefresh with didRefresh=false  
        CatalogSnapshotStatsCache cache = newCache(snapshotManager, store, logger);
        DocsStats docsStats = cache.getDocsStats();  
        cache.afterRefresh(true);  
        CatalogSnapshotManager snapshotManager = mock(CatalogSnapshotManager.class);  
        when(snapshotManager.acquireSnapshot()).thenThrow(new RuntimeException("Test exception"));
        CatalogSnapshot snapshot = mock(CatalogSnapshot.class);  
        Store store = mock(Store.class);  
        SegmentsStats segmentsStats = cache.getSegmentsStats();
        Store store = mock(Store.class);
        when(snapshotManager.acquireSnapshot()).thenReturn(new GatedCloseable<>(snapshot, () -> {}));
     * formats that never hide a row (Parquet alone, for instance) does.  
        when(snapshotManager.acquireSnapshot()).thenReturn(new GatedCloseable<>(snapshot, () -> {}));
        when(snapshot.getSegments()).thenReturn(Collections.emptyList());
            .addSearchableFiles("parquet", parquetSet2)
    private static void useRealDocCountAggregation(CatalogSnapshot snapshot) {
        Logger logger = mock(Logger.class);
    public void testCacheInitialization() {
        CatalogSnapshotStatsCache cache = newCache(snapshotManager, store, logger);
    public void testBuildSegmentsStatsWithSnapshot() {  
        when(snapshotManager.acquireSnapshot()).thenReturn(new GatedCloseable<>(snapshot, () -> {}));
    }  
        // Create real Segment instances using the builder  
        // Only the existing file contributes; missing file returns 0  
        Store store,
    public void testAfterRefreshWithDidRefreshFalse() throws IOException {
        // Verify cache starts with empty stats
    }
        when(snapshot.buildEngineSegments(any(), any(), any())).thenReturn(Collections.emptyList());  
        assertNotNull(segments);
        when(snapshot.collectFileSizesGroupedByExtension(store)).thenReturn(Collections.emptyMap());  
        org.opensearch.index.engine.exec.Segment segment2 = org.opensearch.index.engine.exec.Segment.builder(2L)  
        cache.afterRefresh(true);
        Logger logger = mock(Logger.class);
            .build();  
        Store store = mock(Store.class);  
        when(snapshot.getSegments()).thenReturn(List.of(gen1, gen2));  
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        useRealDocCountAggregation(snapshot);
        Map<Long, DocCounts> docCounts
            snapshot -> docCounts,
    public void testComputeDocsStatsTotalSizeNoSegments() throws IOException {
        org.opensearch.index.engine.exec.Segment emptySegment = org.opensearch.index.engine.exec.Segment.builder(1L).build();
        // Verify cache can handle refresh events
    private static CatalogSnapshotStatsCache newCache(  
        assertEquals(300L, (long) fileSizes.get("parquet")); // 100 + 200
        assertTrue(segments.isEmpty());
        when(snapshot.buildEngineSegments(any(), any(), any())).thenReturn(Collections.emptyList());  
        cache.beforeRefresh(); // Should complete without exception
        // Segment with no file sets  
        Logger logger = mock(Logger.class);
        Logger logger = mock(Logger.class);
        assertEquals(initialSegmentsCount, cache.getSegmentsStats().getCount());
    }
        when(snapshot.buildEngineSegments(any(), any(), any())).thenReturn(Collections.emptyList());
        assertEquals(7L, docsStats.getCount());
    public void testComputeDocsStatsTotalSizeFromMultipleSegments() throws IOException {
        // Mock snapshot to return test data with multiple files of same extension
import org.opensearch.index.shard.DocsStats;
        // Stats values should remain unchanged (but objects may be different)  
    public void testDataFormatAwareNRTReplicationEngineWiring() {
        when(snapshot.collectFileSizesGroupedByExtension(store)).thenReturn(Collections.emptyMap());  
        Store store = mock(Store.class);
        CatalogSnapshotManager snapshotManager = mock(CatalogSnapshotManager.class);
}
    }
import org.opensearch.common.concurrent.GatedCloseable;
        CatalogSnapshotStatsCache cache = newCache(snapshotManager, store, logger);
        useRealDocCountAggregation(snapshot);
        // Create one real file and reference a non-existent file
        DocsStats initialDocsStats = cache.getDocsStats();
/*  
            .build();
        Store store = mock(Store.class);  
 * this file be licensed under the Apache-2.0 license or a
            cache.beforeRefresh();  
        WriterFileSet parquetSet1 = new WriterFileSet(tempDir.toString(), 1L, java.util.Set.of("seg1.parquet"), 5, 1L);
        Logger logger = mock(Logger.class);
            .addSearchableFiles("lucene", luceneSet)
        assertNotNull(cache.getDocsStats());
            .build();  
import org.opensearch.index.store.Store;
        Logger logger = mock(Logger.class);  
    public void testDocsStatsReportsLiveAndDeletedCountsWhenReported() throws IOException {  
        DocsStats docsStats = cache.getDocsStats();
        WriterFileSet luceneSet = new WriterFileSet(tempDir.toString(), 1L, java.util.Set.of("seg3.lucene"), 5, 1L);  
        org.opensearch.index.engine.exec.Segment segment2 = org.opensearch.index.engine.exec.Segment.builder(2L).build();
import org.opensearch.index.engine.exec.coord.CatalogSnapshotManager;  
        // Get initial stats values  
        CatalogSnapshotManager snapshotManager,
        Map<Long, DocCounts> reported = Map.of(1L, new DocCounts(4, 6), 2L, new DocCounts(3, 1));
        assertEquals(7L, docsStats.getDeleted());
        assertEquals(3, stats.getCount());
        assertNotNull(stats.getFileSizes());  
        CatalogSnapshotManager snapshotManager = mock(CatalogSnapshotManager.class);
        when(snapshotManager.acquireSnapshot()).thenReturn(new GatedCloseable<>(snapshot, () -> {}));  
        WriterFileSet gen1Files = new WriterFileSet(tempDir.toString(), 1L, java.util.Set.of("gen1.parquet"), 10, 1L);
        when(snapshot.collectFileSizesGroupedByExtension(store)).thenReturn(Collections.emptyMap());
        );
            store,
        assertNotNull(cache.getSegmentsStats());
        cache.afterRefresh(false);
            fail("Refresh methods should not throw exceptions: " + e.getMessage());
            .build();  
        assertEquals(0, stats.getCount());
            .addSearchableFiles("parquet", gen2Files)
        // The hidden rows still occupy their files, so the reported size covers all 14 rows.  
        when(snapshot.getSegments()).thenReturn(List.of(gen1, gen2));  
        org.opensearch.index.engine.exec.Segment gen1 = org.opensearch.index.engine.exec.Segment.builder(1L)
            .addSearchableFiles("parquet", fileSet)  
        java.nio.file.Files.write(tempDir.resolve("exists.parquet"), new byte[750]);
            logger  
    }  
        Logger logger = mock(Logger.class);  
        int initialSegmentsSize = initialSegments.size();
        assertNotNull(docsStats);
        when(snapshot.getSegments()).thenReturn(List.of(segment1, segment2, segment3));  
        java.nio.file.Files.write(tempDir.resolve("gen1.parquet"), new byte[100]);  
    private static CatalogSnapshotStatsCache newCache(CatalogSnapshotManager snapshotManager, Store store, Logger logger) {
        DocsStats docsStats = cache.getDocsStats();
        assertEquals(10L, docsStats.getCount());
        assertEquals(750L, docsStats.getTotalSizeInBytes());
        CatalogSnapshot snapshot = mock(CatalogSnapshot.class);
        WriterFileSet fileSet = new WriterFileSet(tempDir.toString(), 1L, java.util.Set.of("exists.parquet", "missing.parquet"), 10, 1L);  
        CatalogSnapshotStatsCache cache = newCache(snapshotManager, store, logger);
        when(snapshot.getSegments()).thenReturn(List.of(emptySegment));
    public void testComputeDocsStatsTotalSizeWithMissingFiles() throws IOException {  
        List<Segment> initialSegments = cache.getSegments();  
        Logger logger = mock(Logger.class);
        // Generation 1 wrote 10 rows, generation 2 wrote 4 rows: 14 rows on disk in total.  
        useRealDocCountAggregation(snapshot);
        cache.afterRefresh(true);  
        when(snapshot.collectFileSizesGroupedByExtension(store)).thenReturn(Collections.emptyMap());  
            .build();
        // Cache should start with empty stats before any refresh  
        DocsStats docsStats = cache.getDocsStats();
        CatalogSnapshotManager snapshotManager = mock(CatalogSnapshotManager.class);
        java.nio.file.Path tempDir = createTempDir();  
        } catch (Exception e) {  
    }
        CatalogSnapshotStatsCache cache = newCache(snapshotManager, store, logger);  
        SegmentsStats stats = cache.buildSegmentsStats(1024L, 100L, snapshot);
     */
        CatalogSnapshotStatsCache cache = newCache(snapshotManager, store, logger);
        when(snapshot.buildEngineSegments(any(), any(), any())).thenReturn(Collections.emptyList());  
        try {
        }
    public void testComputeDocsStatsTotalSizeWithEmptySegments() throws IOException {
    }
public class CatalogSnapshotStatsCacheTests extends OpenSearchTestCase {
        assertEquals(0L, docsStats.getTotalSizeInBytes());  
 */
import org.opensearch.index.engine.exec.WriterFileSet;
 * compatible open source license.
        WriterFileSet parquetSet2 = new WriterFileSet(tempDir.toString(), 2L, java.util.Set.of("seg2.parquet"), 3, 1L);
    public void testConstructorWithFailingSnapshotManager() {
            cache.afterRefresh(false);
        when(snapshot.buildEngineSegments(any(), any(), any())).thenReturn(Collections.emptyList());
 *
        long initialSegmentsCount = initialSegmentsStats.getCount();  
        when(snapshot.getSegments()).thenReturn(List.of(segment));
        java.nio.file.Files.write(tempDir.resolve("seg1.parquet"), new byte[1000]);  
        assertNotNull(segmentsStats);  
        org.opensearch.index.engine.exec.Segment gen1 = org.opensearch.index.engine.exec.Segment.builder(1L)
        assertEquals(0, segmentsStats.getCount());
 * The OpenSearch Contributors require contributions made to  
        // Mock snapshot manager to throw exception
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(4000L, docsStats.getTotalSizeInBytes());
        useRealDocCountAggregation(snapshot);
        org.opensearch.index.engine.exec.Segment gen2 = org.opensearch.index.engine.exec.Segment.builder(2L)
        assertEquals(0L, docsStats.getCount());
        WriterFileSet gen2Files = new WriterFileSet(tempDir.toString(), 2L, java.util.Set.of("gen2.parquet"), 4, 1L);
        long initialDocsCount = initialDocsStats.getCount();
        assertNotNull(cache.getSegments());  
    }  
    public void testDocsStatsFallsBackToPhysicalRowsForUnreportedGenerations() throws IOException {
import static org.mockito.Mockito.when;  
        CatalogSnapshotStatsCache cache = newCache(snapshotManager, store, logger);
        Store store = mock(Store.class);
        useRealDocCountAggregation(snapshot);
        // totalSizeInBytes = 1000 + 2500 + 500 = 4000  
import java.util.Collections;  
