    /**
        assertEquals("post-replay: formats must match", parquetRows, luceneRows);
        // NO flush — these are only in the translog
        createParquetLuceneIndex(indexName);
        String indexName = "test-multi-flush";
    }
        client().admin().indices().prepareClose(indexName).get();
    public void testBulkIndexCrossFormatConsistency() throws Exception {
        assertEquals("13 ops total", 12, engine.getSeqNoStats(-1).getMaxSeqNo());
        return CompositeEngineHelper.getEngine(clusterService(), internalCluster(), indexName);
        int numRefreshes = 10;
        flushThread.start();
    }
import org.opensearch.index.engine.exec.WriterFileSet;
    }
        indexDocsTo(indexName, 10);
     */
            indexThreads[t] = new Thread(() -> {
        assertEquals("post-replay: all 13 docs present", 13, parquetRows);
     * Bulk indexing must be per-doc atomic — all docs visible, formats consistent.
        DataFormatAwareEngine recovered = getEngine(indexName);
                assertTrue("segment gen=" + segment.generation() + " must have positive numRows", parquetWfs.numRows() > 0);
        engine.refresh("verify");
                WriterFileSet luceneWfs = segment.dfGroupedSearchableFiles().get("lucene");
    private DataFormatAwareEngine getEngine(String indexName) {
                            .get();
     * must have matching row counts across both formats.
     */
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    public void testMultipleFlushCyclesAdditive() throws Exception {
        CompositeEngineHelper.flush(this, indexName);
        createParquetLuceneIndex(indexName);
        assertEquals("every intermediate refresh must show consistent cross-format counts", 0, inconsistencyCount.get());
            long totalLucene = snapshot.getSearchableFiles("lucene").stream().mapToLong(WriterFileSet::numRows).sum();
     */
        flushIndex(indexName);
        assertEquals("13 ops total", 12, engine.getSeqNoStats(-1).getMaxSeqNo());
            for (Segment segment : snapshot.getSegments()) {
        DataFormatAwareEngine engine = getEngine(indexName);
import org.opensearch.be.datafusion.DataFusionPlugin;
    private void assertParquetLuceneRowCountsMatch(String indexName, long expected) throws IOException {
        int numIndexThreads = 3;
            assertEquals("refresh must make same docs visible in both formats", parquetRows, luceneRows);
     * in both formats. Index docs, flush some, then index more WITHOUT flushing.
        int totalExpected = numThreads * docsPerThread;
                    throw new RuntimeException(e);
            });
     */
import java.util.concurrent.atomic.AtomicInteger;
        }
        recovered.refresh("verify");
            assertEquals("all 20 docs must be present in parquet", 20, totalParquet);
     * flushAndClose must commit all buffered data. After reopen, both formats must have
    /**
            t.join();
                            .setSource("field_keyword", "t" + tid + "_d" + i, "field_number", i)
    private void flushIndex(String indexName) {
        Thread[] indexThreads = new Thread[numIndexThreads];
    /**
     * its parquet and lucene WriterFileSets. This verifies that row IDs are
     * in both formats. Index docs, flush some, then index more WITHOUT flushing. Close/reopen.
package org.opensearch.composite;
        flushThread.join();
        flushIndex(indexName);
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
            indexThreads[t].start();
        long luceneRows = getRowCount(indexName, "lucene");
            }
                barrier.await();
                generations.size(),
    }
        flushIndex(indexName);
        AtomicInteger successCount = new AtomicInteger();
            long parquetRows = snapshot.getSearchableFiles("parquet").stream().mapToLong(WriterFileSet::numRows).sum();
     * Concurrent indexing + refresh must produce consistent cross-format snapshots.
            final int threadId = t;
        // Flush + refresh to make recovered data visible in catalog
            CatalogSnapshot snapshot = ref.get();
        assertEquals("parquet row count", expected, getRowCount(indexName, "parquet"));
    }
import org.opensearch.arrow.allocator.ArrowBasePlugin;
                    throw new RuntimeException(e);
        AtomicInteger successCount = new AtomicInteger();
        client().admin().indices().prepareOpen(indexName).get();
                try {
        ensureGreen(indexName);
        }
        assertParquetLuceneRowCountsMatch(indexName, 15);
            final int tid = t;
                    "segment gen=" + segment.generation() + " must have same numRows in both formats",
                } catch (Exception e) {
        DataFormatAwareEngine engine = getEngine(indexName);
                        }
        DataFormatAwareEngine engine = getEngine(indexName);
        DataFormatAwareEngine engine = getEngine(indexName);
        assertParquetLuceneRowCountsMatch(indexName, batchSize);
        CyclicBarrier barrier = new CyclicBarrier(numIndexThreads + 1);
                    for (int i = 0; i < docsPerThread; i++) {
import org.opensearch.test.OpenSearchIntegTestCase;
                assertNotNull("segment gen=" + segment.generation() + " must have lucene files", luceneWfs);
        String indexName = "test-concurrent-appends";
        long parquetRows = getRowCount(indexName, "parquet");
        assertEquals("post-replay: all 13 docs present", 13, parquetRows);
            assertEquals("all 20 docs must be present in lucene", 20, totalLucene);
            assertEquals("all 10 docs must be visible after refresh", 10, parquetRows);
                    barrier.await();
        flushIndex(indexName);
import org.opensearch.action.bulk.BulkRequestBuilder;
import org.opensearch.be.lucene.LucenePlugin;
            );
    public void testConcurrentAppendsCrossFormatConsistency() throws Exception {
            DataFusionPlugin.class
        flushIndex(indexName);
        engine.refresh("verify");
                }
     * Refresh must make all buffered docs visible atomically across both formats.
        long parquetRows = getRowCount(indexName, "parquet");
        long parquetRows = getRowCount(indexName, "parquet");
        String indexName = "test-concurrent-flush";
                    barrier.await();
            }
    /**
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
            long totalParquet = snapshot.getSearchableFiles("parquet").stream().mapToLong(WriterFileSet::numRows).sum();
     * not restart from 1. Otherwise new segments collide with committed segments in
        }
                    luceneWfs.numRows()
     * Reference: InternalEngineTests.testTranslogReplay + testRecoverFromLocalTranslog
            threads[t] = new Thread(() -> {
        long luceneRows = getRowCount(indexName, "lucene");
     * Writer generation counter must resume from the committed value after recovery,
                        if (resp.status() == RestStatus.CREATED) successCount.incrementAndGet();
     * Reference: InternalEngineTests.testFlushAndClose
                    }
     * Reference: InternalEngineTests.testTranslogReplay
        indexDocsTo(indexName, 8);
        flushIndex(indexName);
        assertEquals("post-replay: formats must match", parquetRows, luceneRows);
                } catch (Exception e) {
/*
            // Verify no duplicate generations
     * After reopen, both formats must have all docs.
        engine.failEngine("simulated-crash", new java.io.IOException("disk error"));
     * CREATED responses must be visible after flush settles.
            threads[t].start();
                            .setSource("field_keyword", "t" + threadId + "_d" + i, "field_number", i)
     * The close triggers flushAndClose which persists uncommitted data via translog.
        indexDocsTo(indexName, 5);
        String indexName = "test-translog-replay-crash";
        DataFormatAwareEngine recovered = getEngine(indexName);
                DataFormatAwareEngine eng = getEngine(indexName);
     * Translog replay after clean shutdown (close/reopen) must produce identical state
        for (Thread t : indexThreads) {
        String indexName = "test-translog-replay-clean";
            });
                        if (pq != lc) {
     * Reference: InternalEngineTests.testSequenceNumberAdvancesToMaxSeqOnEngineOpenOnPrimary
     * all docs that were indexed before shutdown.
        AtomicInteger inconsistencyCount = new AtomicInteger();
        createParquetLuceneIndex(indexName);
        // Indexing threads
 * this file be licensed under the Apache-2.0 license or a
        createParquetLuceneIndex(indexName);
                }
        for (Thread t : indexThreads) {
        client().admin().indices().prepareClose(indexName).get();
    @Override
        try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
                        long pq = snap.getSearchableFiles("parquet").stream().mapToLong(WriterFileSet::numRows).sum();
    }
        int docsPerThread = 25;
        DataFormatAwareEngine engine = getEngine(indexName);
     * Reference: InternalEngineTests.testConcurrentWritesAndCommits
     * Reference: InternalEngineTests.testAppendConcurrently
     * Reference: InternalEngineTests.testConcurrentAppendUpdateAndRefresh
        client().admin().indices().prepareOpen(indexName).get();
        }
        engine.refresh("test");
        refreshThread.join();
        assertParquetLuceneRowCountsMatch(indexName, 12);
                        IndexResponse resp = client().prepareIndex(indexName)
        assertParquetLuceneRowCountsMatch(indexName, totalExpected);
import org.opensearch.core.rest.RestStatus;
    public void testFlushAndClosePreservesAllData() throws Exception {
import java.util.Collection;
            long luceneRows = snapshot.getSearchableFiles("lucene").stream().mapToLong(WriterFileSet::numRows).sum();
        // Close and reopen
     * Multiple flush cycles produce additive, consistent state across formats.
import org.opensearch.index.engine.exec.Segment;
                    for (int i = 0; i < docsPerThread; i++) {
        indexDocsTo(indexName, 4);
        indexDocsTo(indexName, 5);
        // Phase 2: uncommitted data (in translog only)
        indexDocsTo(indexName, 3);
        CompositeEngineHelper.createCompositeIndexWithMapping(this, indexName, "parquet", Settings.EMPTY, "lucene");
        assertEquals("all 13 ops recovered", 12, recovered.getSeqNoStats(-1).getMaxSeqNo());
        // Close/reopen — close triggers flushAndClose, reopen replays from translog if needed
    private void createParquetLuceneIndex(String indexName) {
 */
    /**
        flushIndex(indexName);
        flushIndex(indexName);
        flushIndex(indexName);
        long maxSeq = engine.getSeqNoStats(-1).getMaxSeqNo();
        // Flush thread — flushes while indexing is in progress
        String indexName = "test-segment-alignment";
        int docsPerThread = 20;
        assertParquetLuceneRowCountsMatch(indexName, numIndexThreads * docsPerThread);
import java.util.Arrays;
     * Translog replay after unclean shutdown (failEngine) must produce identical state
                generations.stream().distinct().count()
        flushIndex(indexName);
        return CompositeEngineHelper.getRowCount(clusterService(), internalCluster(), indexName, formatName);
                    eng.refresh("concurrent-check-" + r);
        indexDocsTo(indexName, 8);
        // Phase 2: uncommitted data (in translog only)
                for (int r = 0; r < numRefreshes; r++) {
    public void testRefreshAtomicityAcrossFormats() throws Exception {
        }
        flushIndex(indexName);
        client().admin().indices().prepareClose(indexName).get();
                            .get();
        }
        indexDocsTo(indexName, 5);
import org.opensearch.action.index.IndexResponse;
                    }
     */
            .build();
        DataFormatAwareEngine engine = getEngine(indexName);
                    throw new RuntimeException(e);
                .stream()
 * compatible open source license.
        indexDocsTo(indexName, 2);
    public void testSegmentGenerationAlignmentAcrossFormats() throws Exception {
                try {
        flushIndex(indexName);
import org.opensearch.plugins.Plugin;
            final int threadId = t;
                assertEquals(
    protected Settings nodeSettings(int nodeOrdinal) {
     * Reference: InternalEngineTests.testShouldPeriodicallyFlush
        createParquetLuceneIndex(indexName);
        DataFormatAwareEngine engine = getEngine(indexName);
            .put(super.nodeSettings(nodeOrdinal))
    // Contract tests: InternalEngine equivalents for Parquet+Lucene composite
    public void testConcurrentIndexAndFlushNoDataLoss() throws Exception {
        int numThreads = 4;
            });
        flushIndex(indexName);
        flushIndex(indexName);
    /**
        createParquetLuceneIndex(indexName);
        int expected = successCount.get();
            indexThreads[t].start();
public class CompositeDataCoherenceIT extends OpenSearchIntegTestCase {
        assertEquals("all 10 docs must survive flushAndClose", 10, parquetRows);
    }
    public void testTranslogReplayCleanShutdownCrossFormatConsistency() throws Exception {
        indexDocsTo(indexName, 5);
        client().admin().indices().prepareOpen(indexName).get();
            bulk.add(client().prepareIndex(indexName).setSource("field_keyword", "bulk_" + i, "field_number", i));
        refreshThread.start();
    // ──────────────────────────────────────────────────────────────────────────
     * While indexing threads are active, refresh threads take snapshots. Every snapshot
        recovered.refresh("verify");
            indexThreads[t] = new Thread(() -> {
                        IndexResponse resp = client().prepareIndex(indexName)
     * After multiple refresh cycles, each segment must have matching numRows in both
        indexDocsTo(indexName, 5);
        }
    }
        try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
        String indexName = "test-bulk-index";
        try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
            java.util.List<Long> generations = snapshot.getSegments()
        assertEquals("all 13 ops recovered", 12, recovered.getSeqNoStats(-1).getMaxSeqNo());
     * (No direct InternalEngine analog — unique to multi-format)
    }
        Thread refreshThread = new Thread(() -> {
        // Final flush to commit any remaining buffered data
        flushIndex(indexName);
            }
        for (int i = 0; i < batchSize; i++) {
        // Checkpoint must be consistent with seqNo
                    Thread.sleep(10);
                );
            try {
        String indexName = "test-concurrent-refresh";
    }
            ParquetDataFormatPlugin.class,
        return Settings.builder()
    }
                        long lc = snap.getSearchableFiles("lucene").stream().mapToLong(WriterFileSet::numRows).sum();
        flushIndex(indexName);
        AtomicInteger successCount = new AtomicInteger();
        // Verify: 20 total docs, no generation conflicts
                }
        // Do NOT flush explicitly — flushAndClose should handle it
        return Arrays.asList(
import java.io.IOException;
}
        int batchSize = 50;
                            inconsistencyCount.incrementAndGet();
        ensureGreen(indexName);
        long luceneRows = getRowCount(indexName, "lucene");
                WriterFileSet parquetWfs = segment.dfGroupedSearchableFiles().get("parquet");
        long processedCp = engine.getProcessedLocalCheckpoint();
        indexDocsTo(indexName, 5);
        assertEquals("lucene must have all successful docs", expected, luceneRows);
     * Concurrent indexing must not lose docs. Both formats must have identical row counts.
        CompositeEngineHelper.assertPerSegmentRowCountsMatch(engine, "parquet", "lucene");
    public void testTranslogReplayUncleanShutdownCrossFormatConsistency() throws Exception {
     * After a single refresh, both parquet and lucene must show the same new segment
        // Create 3 segments — writer generations 1, 2, 3
        indexDocsTo(indexName, 7);
                "all segment generations must be unique (no collision after restart)",
        createParquetLuceneIndex(indexName);
    }
                    try (GatedCloseable<CatalogSnapshot> ref = eng.acquireSnapshot()) {
                try {
            CatalogSnapshot snapshot = ref.get();
        BulkRequestBuilder bulk = client().prepareBulk();
        long parquetRows = getRowCount(indexName, "parquet");
                    Thread.sleep(5);
        CompositeEngineHelper.indexDocs(this, indexName, count);
     * (committed + replayed from translog).
                barrier.await();
        }
            assertEquals(
                    flushIndex(indexName);
                        CatalogSnapshot snap = ref.get();
    public void testWriterGenerationResumesAfterRestart() throws Exception {
        client().admin().indices().prepareClose(indexName).get();
        assertEquals("lucene row count", expected, getRowCount(indexName, "lucene"));
        String indexName = "test-flush-and-close";
     */
        flushIndex(indexName);
        int numIndexThreads = 3;
                        if (resp.status() == RestStatus.CREATED) successCount.incrementAndGet();
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("all 10 ops recovered via translog", 9, recovered.getSeqNoStats(-1).getMaxSeqNo());
    }
 *
import org.opensearch.parquet.ParquetDataFormatPlugin;
    /**
                .collect(java.util.stream.Collectors.toList());
        flushIndex(indexName);
        assertEquals("parquet must have all successful docs", expected, parquetRows);
        for (Thread t : threads) {
            t.join();
     * with the same row count — no partial visibility where one format lags.
        // Index more after reopen — should NOT collide with existing segment generations
        String indexName = "test-writer-gen-resume";
            CatalogSnapshot snapshot = ref.get();
        assertEquals("processed checkpoint must equal maxSeqNo", maxSeq, processedCp);
        long luceneRows = getRowCount(indexName, "lucene");
                } catch (Exception e) {
    /**
import org.opensearch.common.settings.Settings;
                    for (int i = 0; i < docsPerThread; i++) {
            t.join();
    @Override
    // ── Helpers for Parquet+Lucene tests ──
        // Final verification
        CyclicBarrier barrier = new CyclicBarrier(numThreads);
    // ──────────────────────────────────────────────────────────────────────────
                for (int i = 0; i < 5; i++) {
        engine.refresh("verify");
    /**
                throw new RuntimeException(e);
    }
        int docsPerThread = 30;
     */
        // Simulate unclean shutdown — engine fails without flushing
        DataFormatAwareEngine recovered = getEngine(indexName);
import java.util.concurrent.CyclicBarrier;
        ensureGreen(indexName);
        BulkResponse resp = bulk.get();
        // Phase 1: committed data
        assertParquetLuceneRowCountsMatch(indexName, 5);
        );
    }
            LucenePlugin.class,
            ArrowBasePlugin.class,
     */
        // Phase 1: committed data
                }
        }
        createParquetLuceneIndex(indexName);
     * the CatalogSnapshot.
import org.opensearch.action.bulk.BulkResponse;
     */
        assertFalse("no failures in bulk", resp.hasFailures());
                        if (resp.status() == RestStatus.CREATED) successCount.incrementAndGet();
        recovered.refresh("verify");
    /**
        createParquetLuceneIndex(indexName);
            CompositeDataFormatPlugin.class,
import org.opensearch.index.engine.DataFormatAwareEngine;
                }
        });
        // flushAndClose via index close (which triggers flushAndClose on the engine)
        for (int t = 0; t < numIndexThreads; t++) {
        });
        String indexName = "test-refresh-atomicity";
    }
        }
                assertNotNull("segment gen=" + segment.generation() + " must have parquet files", parquetWfs);
    /**
    }
        indexDocsTo(indexName, 10);
        createParquetLuceneIndex(indexName);
     * Reference: InternalEngineTests.testConcurrentWritesAndCommits
                            .setSource("field_keyword", "t" + threadId + "_d" + i, "field_number", i)
        flushIndex(indexName);
                    }
        CyclicBarrier barrier = new CyclicBarrier(numIndexThreads + 1);
        for (int t = 0; t < numThreads; t++) {
        Thread flushThread = new Thread(() -> {
    }
                .map(Segment::generation)
     */
        indexDocsTo(indexName, 5);
     */
        createParquetLuceneIndex(indexName);
     * Reference: InternalEngineTests.testRefreshScopedSearcher
                        IndexResponse resp = client().prepareIndex(indexName)
        // Reopen — triggers translog replay of the 5 uncommitted docs
 * The OpenSearch Contributors require contributions made to
        assertEquals("all must succeed", totalExpected, successCount.get());
    }
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
        engine.refresh("test");
     * correctly assigned within each writer generation across formats.
        // Single refresh — not flush. Docs should become visible in both formats simultaneously.
        indexDocsTo(indexName, 7);
     * Concurrent indexing + flush must not lose documents. All docs that got
        Thread[] threads = new Thread[numThreads];
            } catch (Exception e) {
import org.opensearch.common.util.FeatureFlags;
                    barrier.await();
    private long getRowCount(String indexName, String formatName) throws IOException {
            try {
                    }
            } catch (Exception e) {
        for (int t = 0; t < numIndexThreads; t++) {
        // NO explicit flush — close will trigger flushAndClose, translog holds these ops
        client().admin().indices().prepareOpen(indexName).get();
        ensureGreen(indexName);
                throw new RuntimeException(e);
                            .get();
        Thread[] indexThreads = new Thread[numIndexThreads];
    public void testConcurrentIndexAndRefreshConsistency() throws Exception {
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 1)
import org.opensearch.common.concurrent.GatedCloseable;
        // Refresh thread — checks cross-format consistency at each refresh point
        assertEquals("post-close parquet and lucene must match", parquetRows, luceneRows);
                    parquetWfs.numRows(),
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
    private void indexDocsTo(String indexName, int count) {
        // Create 3 segments with different sizes
     * Fail engine (simulates crash). After recovery, both formats must have all docs
