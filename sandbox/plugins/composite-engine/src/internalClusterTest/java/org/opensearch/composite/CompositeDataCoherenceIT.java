     * After a single refresh, both parquet and lucene must show the same new segment
        return CompositeEngineHelper.getEngine(clusterService(), internalCluster(), indexName);  
import org.opensearch.test.OpenSearchIntegTestCase;
            }
     */  
 * this file be licensed under the Apache-2.0 license or a
                    Thread.sleep(5);
        AtomicInteger inconsistencyCount = new AtomicInteger();  
        ensureGreen(indexName);
import org.opensearch.index.engine.DataFormatAwareEngine;
        DataFormatAwareEngine engine = getEngine(indexName);
        Thread[] indexThreads = new Thread[numIndexThreads];
    }
        });
        for (Thread t : indexThreads) {
        int docsPerThread = 20;
        flushIndex(indexName);
        return CompositeEngineHelper.getRowCount(clusterService(), internalCluster(), indexName, formatName);
        refreshThread.join();  
                    throw new RuntimeException(e);
        String indexName = "test-flush-and-close";  
            });
        AtomicInteger successCount = new AtomicInteger();
        // Flush + refresh to make recovered data visible in catalog
        createParquetLuceneIndex(indexName);
        String indexName = "test-writer-gen-resume";  
import org.opensearch.parquet.ParquetDataFormatPlugin;
        createParquetLuceneIndex(indexName);  
 * SPDX-License-Identifier: Apache-2.0
    // Contract tests: InternalEngine equivalents for Parquet+Lucene composite  
                    eng.refresh("concurrent-check-" + r);
        flushIndex(indexName);
    }  
            bulk.add(client().prepareIndex(indexName).setSource("field_keyword", "bulk_" + i, "field_number", i));
        engine.refresh("test");  
    }
                            .setSource("field_keyword", "t" + threadId + "_d" + i, "field_number", i)  
        CyclicBarrier barrier = new CyclicBarrier(numIndexThreads + 1);
        }  
        assertEquals("all 10 docs must survive flushAndClose", 10, parquetRows);  
     * Reference: InternalEngineTests.testTranslogReplay + testRecoverFromLocalTranslog
        // Do NOT flush explicitly — flushAndClose should handle it
     */
        int numIndexThreads = 3;
        assertEquals("all must succeed", totalExpected, successCount.get());  
     * CREATED responses must be visible after flush settles.
            long parquetRows = snapshot.getSearchableFiles("parquet").stream().mapToLong(WriterFileSet::numRows).sum();
            ArrowBasePlugin.class,
        flushIndex(indexName);  
                    "segment gen=" + segment.generation() + " must have same numRows in both formats",
    }  
            indexThreads[t].start();
        int numRefreshes = 10;  
        // Index more after reopen — should NOT collide with existing segment generations
                );
                assertNotNull("segment gen=" + segment.generation() + " must have parquet files", parquetWfs);
    @Override  
    public void testTranslogReplayUncleanShutdownCrossFormatConsistency() throws Exception {
     * Reference: InternalEngineTests.testTranslogReplay
        // Phase 1: committed data
            });  
     * (No direct InternalEngine analog — unique to multi-format)
        client().admin().indices().prepareOpen(indexName).get();
        engine.refresh("verify");  
                throw new RuntimeException(e);
        long maxSeq = engine.getSeqNoStats(-1).getMaxSeqNo();
    public void testConcurrentIndexAndFlushNoDataLoss() throws Exception {
    public void testConcurrentAppendsCrossFormatConsistency() throws Exception {
                }
        client().admin().indices().prepareOpen(indexName).get();  
        flushIndex(indexName);
    public void testSegmentGenerationAlignmentAcrossFormats() throws Exception {  
    public void testWriterGenerationResumesAfterRestart() throws Exception {
    /**
                barrier.await();
 */  
            assertEquals("all 20 docs must be present in lucene", 20, totalLucene);
    /**  
    private long getRowCount(String indexName, String formatName) throws IOException {  
                }  
        flushIndex(indexName);  
        long luceneRows = getRowCount(indexName, "lucene");
        assertEquals("post-replay: all 13 docs present", 13, parquetRows);  
                            .get();  
     * the CatalogSnapshot.
     */  
        // Reopen — triggers translog replay of the 5 uncommitted docs
                        if (resp.status() == RestStatus.CREATED) successCount.incrementAndGet();
     * must have matching row counts across both formats.  
        for (Thread t : threads) {
        DataFormatAwareEngine engine = getEngine(indexName);
    /**  
                        if (resp.status() == RestStatus.CREATED) successCount.incrementAndGet();
    @Override
                try {
        assertEquals("every intermediate refresh must show consistent cross-format counts", 0, inconsistencyCount.get());
public class CompositeDataCoherenceIT extends OpenSearchIntegTestCase {
        indexDocsTo(indexName, 7);
     * not restart from 1. Otherwise new segments collide with committed segments in
        client().admin().indices().prepareClose(indexName).get();
                .collect(java.util.stream.Collectors.toList());
        CompositeEngineHelper.assertPerSegmentRowCountsMatch(engine, "parquet", "lucene");
     */  
        // Create 3 segments with different sizes
    private void flushIndex(String indexName) {
        try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {  
        String indexName = "test-translog-replay-crash";
        assertEquals("lucene must have all successful docs", expected, luceneRows);  
        assertFalse("no failures in bulk", resp.hasFailures());
     * Translog replay after clean shutdown (close/reopen) must produce identical state
                    for (int i = 0; i < docsPerThread; i++) {
    public void testFlushAndClosePreservesAllData() throws Exception {
        // Checkpoint must be consistent with seqNo  
                    flushIndex(indexName);
        flushIndex(indexName);  
import java.util.Collection;
    }  
        flushIndex(indexName);
        long parquetRows = getRowCount(indexName, "parquet");  
     * with the same row count — no partial visibility where one format lags.
        flushIndex(indexName);
        }
                try {
    }
    }
                DataFormatAwareEngine eng = getEngine(indexName);
        indexDocsTo(indexName, 7);
            } catch (Exception e) {
        }
                    }  
            try {
    // ── Helpers for Parquet+Lucene tests ──  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 1)  
                        long lc = snap.getSearchableFiles("lucene").stream().mapToLong(WriterFileSet::numRows).sum();
                assertEquals(
        engine.refresh("verify");  
    // ──────────────────────────────────────────────────────────────────────────
        assertEquals("processed checkpoint must equal maxSeqNo", maxSeq, processedCp);  
        // Final verification
import org.opensearch.be.lucene.LucenePlugin;
        assertParquetLuceneRowCountsMatch(indexName, 15);
        ensureGreen(indexName);
import org.opensearch.index.engine.exec.WriterFileSet;  
                        long pq = snap.getSearchableFiles("parquet").stream().mapToLong(WriterFileSet::numRows).sum();
        flushIndex(indexName);  
 *
        flushIndex(indexName);  
    }  
            threads[t].start();
    private void createParquetLuceneIndex(String indexName) {
        assertEquals("all 10 ops recovered via translog", 9, recovered.getSeqNoStats(-1).getMaxSeqNo());  
            indexThreads[t] = new Thread(() -> {
                    }
/*  
import org.opensearch.be.datafusion.DataFusionPlugin;
        assertEquals("parquet must have all successful docs", expected, parquetRows);
    public void testRefreshAtomicityAcrossFormats() throws Exception {
        int expected = successCount.get();
        // Phase 1: committed data
        Thread[] indexThreads = new Thread[numIndexThreads];  
        // Verify: 20 total docs, no generation conflicts
import org.opensearch.index.engine.exec.Segment;
        assertEquals("post-replay: all 13 docs present", 13, parquetRows);  
package org.opensearch.composite;
        flushIndex(indexName);
        assertParquetLuceneRowCountsMatch(indexName, totalExpected);  
    private void indexDocsTo(String indexName, int count) {  
        flushIndex(indexName);  
        DataFormatAwareEngine engine = getEngine(indexName);
            // Verify no duplicate generations
    /**  
        client().admin().indices().prepareOpen(indexName).get();
        flushThread.start();
        String indexName = "test-bulk-index";
        for (int i = 0; i < batchSize; i++) {
                }  
import org.opensearch.common.util.FeatureFlags;
            long totalLucene = snapshot.getSearchableFiles("lucene").stream().mapToLong(WriterFileSet::numRows).sum();  
        createParquetLuceneIndex(indexName);
                WriterFileSet luceneWfs = segment.dfGroupedSearchableFiles().get("lucene");  
                        IndexResponse resp = client().prepareIndex(indexName)
        }  
    }
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            long totalParquet = snapshot.getSearchableFiles("parquet").stream().mapToLong(WriterFileSet::numRows).sum();
import org.opensearch.core.rest.RestStatus;  
        assertEquals("all 13 ops recovered", 12, recovered.getSeqNoStats(-1).getMaxSeqNo());
        String indexName = "test-translog-replay-clean";
     * Reference: InternalEngineTests.testShouldPeriodicallyFlush
    /**
        indexDocsTo(indexName, 5);
     * correctly assigned within each writer generation across formats.  
     * While indexing threads are active, refresh threads take snapshots. Every snapshot
    }
        flushIndex(indexName);
        assertEquals("post-replay: formats must match", parquetRows, luceneRows);
        String indexName = "test-concurrent-refresh";
                for (int i = 0; i < 5; i++) {  
        }  
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.CyclicBarrier;  
                } catch (Exception e) {
        DataFormatAwareEngine recovered = getEngine(indexName);  
        createParquetLuceneIndex(indexName);
        indexDocsTo(indexName, 5);
            long luceneRows = snapshot.getSearchableFiles("lucene").stream().mapToLong(WriterFileSet::numRows).sum();  
            assertEquals("refresh must make same docs visible in both formats", parquetRows, luceneRows);
        createParquetLuceneIndex(indexName);
        int docsPerThread = 30;  
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
                        if (pq != lc) {  
        ensureGreen(indexName);  
    }
     * in both formats. Index docs, flush some, then index more WITHOUT flushing.
                    Thread.sleep(10);
import org.opensearch.action.index.IndexResponse;
            CompositeDataFormatPlugin.class,  
     * (committed + replayed from translog).
    // ──────────────────────────────────────────────────────────────────────────
        DataFormatAwareEngine engine = getEngine(indexName);  
        long luceneRows = getRowCount(indexName, "lucene");
            CatalogSnapshot snapshot = ref.get();  
     * Reference: InternalEngineTests.testConcurrentWritesAndCommits
            java.util.List<Long> generations = snapshot.getSegments()
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
            t.join();
        long parquetRows = getRowCount(indexName, "parquet");  
        createParquetLuceneIndex(indexName);  
                    try (GatedCloseable<CatalogSnapshot> ref = eng.acquireSnapshot()) {
                    parquetWfs.numRows(),  
            for (Segment segment : snapshot.getSegments()) {
        indexDocsTo(indexName, 5);
        indexDocsTo(indexName, 5);
                    }  
        // Single refresh — not flush. Docs should become visible in both formats simultaneously.
    private void assertParquetLuceneRowCountsMatch(String indexName, long expected) throws IOException {
                    for (int i = 0; i < docsPerThread; i++) {  
        }
    /**  
        createParquetLuceneIndex(indexName);
        createParquetLuceneIndex(indexName);  
        long processedCp = engine.getProcessedLocalCheckpoint();
        assertEquals("post-close parquet and lucene must match", parquetRows, luceneRows);
        engine.failEngine("simulated-crash", new java.io.IOException("disk error"));
        }  
                }  
                            .get();
        client().admin().indices().prepareClose(indexName).get();
        String indexName = "test-concurrent-flush";
     * Writer generation counter must resume from the committed value after recovery,  
            ParquetDataFormatPlugin.class,
                assertTrue("segment gen=" + segment.generation() + " must have positive numRows", parquetWfs.numRows() > 0);  
        DataFormatAwareEngine recovered = getEngine(indexName);  
                    barrier.await();  
            .put(super.nodeSettings(nodeOrdinal))  
        BulkRequestBuilder bulk = client().prepareBulk();  
        assertParquetLuceneRowCountsMatch(indexName, 12);
            final int threadId = t;  
                            .setSource("field_keyword", "t" + tid + "_d" + i, "field_number", i)  
        indexDocsTo(indexName, 5);
        // Refresh thread — checks cross-format consistency at each refresh point
            );
        CompositeEngineHelper.createCompositeIndexWithMapping(this, indexName, "parquet", Settings.EMPTY, "lucene");  
        );  
            LucenePlugin.class,
     * The close triggers flushAndClose which persists uncommitted data via translog.  
        AtomicInteger successCount = new AtomicInteger();
        recovered.refresh("verify");
        indexDocsTo(indexName, 8);  
import java.util.Arrays;
            t.join();
        for (int t = 0; t < numThreads; t++) {
        Thread[] threads = new Thread[numThreads];
        });  
                "all segment generations must be unique (no collision after restart)",
import java.io.IOException;  
     * Multiple flush cycles produce additive, consistent state across formats.  
        }
     */  
        int batchSize = 50;
        AtomicInteger successCount = new AtomicInteger();
            assertEquals("all 20 docs must be present in parquet", 20, totalParquet);
    public void testBulkIndexCrossFormatConsistency() throws Exception {
        assertEquals("post-replay: formats must match", parquetRows, luceneRows);
        indexDocsTo(indexName, 3);  
            .build();
        assertEquals("lucene row count", expected, getRowCount(indexName, "lucene"));
                    for (int i = 0; i < docsPerThread; i++) {
     * all docs that were indexed before shutdown.
    }
            } catch (Exception e) {  
                generations.size(),
            CatalogSnapshot snapshot = ref.get();
        flushThread.join();
        DataFormatAwareEngine engine = getEngine(indexName);
        flushIndex(indexName);  
        assertEquals("all 13 ops recovered", 12, recovered.getSeqNoStats(-1).getMaxSeqNo());
                            .setSource("field_keyword", "t" + threadId + "_d" + i, "field_number", i)
     * Reference: InternalEngineTests.testSequenceNumberAdvancesToMaxSeqOnEngineOpenOnPrimary  
     * Concurrent indexing + refresh must produce consistent cross-format snapshots.
            assertEquals("all 10 docs must be visible after refresh", 10, parquetRows);
        createParquetLuceneIndex(indexName);
            }
        try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {  
        DataFormatAwareEngine engine = getEngine(indexName);
        // NO explicit flush — close will trigger flushAndClose, translog holds these ops
                            inconsistencyCount.incrementAndGet();
                WriterFileSet parquetWfs = segment.dfGroupedSearchableFiles().get("parquet");
        for (int t = 0; t < numIndexThreads; t++) {
            DataFusionPlugin.class
import org.opensearch.action.bulk.BulkResponse;
        DataFormatAwareEngine recovered = getEngine(indexName);
        Thread refreshThread = new Thread(() -> {
     * Reference: InternalEngineTests.testRefreshScopedSearcher  
            indexThreads[t].start();
     * Refresh must make all buffered docs visible atomically across both formats.  
import org.opensearch.plugins.Plugin;  
    protected Settings nodeSettings(int nodeOrdinal) {
                } catch (Exception e) {
        recovered.refresh("verify");
    /**  
        int totalExpected = numThreads * docsPerThread;
 * compatible open source license.
        assertEquals("parquet row count", expected, getRowCount(indexName, "parquet"));
                    luceneWfs.numRows()
     * Fail engine (simulates crash). After recovery, both formats must have all docs  
            threads[t] = new Thread(() -> {
        assertParquetLuceneRowCountsMatch(indexName, numIndexThreads * docsPerThread);  
                    throw new RuntimeException(e);
                .map(Segment::generation)
        }  
    }
                    barrier.await();  
                        }
    }  
     * After reopen, both formats must have all docs.
        flushIndex(indexName);
     * Reference: InternalEngineTests.testAppendConcurrently
     */
        Thread flushThread = new Thread(() -> {  
     */
                }
        return Arrays.asList(  
        engine.refresh("verify");  
        client().admin().indices().prepareOpen(indexName).get();  
        int numIndexThreads = 3;
        assertParquetLuceneRowCountsMatch(indexName, 5);  
    /**  
        long parquetRows = getRowCount(indexName, "parquet");  
     * Reference: InternalEngineTests.testFlushAndClose  
        createParquetLuceneIndex(indexName);  
            final int tid = t;  
    public void testTranslogReplayCleanShutdownCrossFormatConsistency() throws Exception {
        // Close/reopen — close triggers flushAndClose, reopen replays from translog if needed
        // Phase 2: uncommitted data (in translog only)  
        flushIndex(indexName);
                generations.stream().distinct().count()  
        // Final flush to commit any remaining buffered data  
        recovered.refresh("verify");
        assertEquals("13 ops total", 12, engine.getSeqNoStats(-1).getMaxSeqNo());
            });
        client().admin().indices().prepareClose(indexName).get();  
                    throw new RuntimeException(e);
        indexDocsTo(indexName, 5);
    public void testMultipleFlushCyclesAdditive() throws Exception {  
        flushIndex(indexName);  
        // Create 3 segments — writer generations 1, 2, 3  
    }
        assertEquals("13 ops total", 12, engine.getSeqNoStats(-1).getMaxSeqNo());
     * Reference: InternalEngineTests.testConcurrentAppendUpdateAndRefresh
        refreshThread.start();
            assertEquals(  
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
        String indexName = "test-concurrent-appends";
     */
        // NO flush — these are only in the translog
                .stream()  
                    }  
        indexDocsTo(indexName, 2);
}
        String indexName = "test-multi-flush";
     * its parquet and lucene WriterFileSets. This verifies that row IDs are
        DataFormatAwareEngine engine = getEngine(indexName);
     * flushAndClose must commit all buffered data. After reopen, both formats must have
    }
        indexDocsTo(indexName, 10);  
    }  
        flushIndex(indexName);  
            indexThreads[t] = new Thread(() -> {  
     * Concurrent indexing must not lose docs. Both formats must have identical row counts.
        }  
     */
    }
        // Phase 2: uncommitted data (in translog only)  
        // Indexing threads
                        IndexResponse resp = client().prepareIndex(indexName)
            try {  
        indexDocsTo(indexName, 8);  
        return Settings.builder()
                for (int r = 0; r < numRefreshes; r++) {  
        engine.refresh("test");
        for (int t = 0; t < numIndexThreads; t++) {
import org.opensearch.action.bulk.BulkRequestBuilder;  
                        CatalogSnapshot snap = ref.get();  
import org.opensearch.arrow.allocator.ArrowBasePlugin;  
                            .get();
     * After multiple refresh cycles, each segment must have matching numRows in both
            t.join();
    /**  
    }
     * Reference: InternalEngineTests.testConcurrentWritesAndCommits
     */
                try {
     */  
                    barrier.await();
        CompositeEngineHelper.flush(this, indexName);
     * Bulk indexing must be per-doc atomic — all docs visible, formats consistent.
        ensureGreen(indexName);
        long luceneRows = getRowCount(indexName, "lucene");
                assertNotNull("segment gen=" + segment.generation() + " must have lucene files", luceneWfs);  
                barrier.await();
        for (Thread t : indexThreads) {  
            CatalogSnapshot snapshot = ref.get();
        indexDocsTo(indexName, 5);  
            }  
        String indexName = "test-segment-alignment";
        BulkResponse resp = bulk.get();
    /**
        assertParquetLuceneRowCountsMatch(indexName, batchSize);
        createParquetLuceneIndex(indexName);  
    private DataFormatAwareEngine getEngine(String indexName) {
     * Translog replay after unclean shutdown (failEngine) must produce identical state
        client().admin().indices().prepareClose(indexName).get();
import org.opensearch.common.concurrent.GatedCloseable;  
            final int threadId = t;
                } catch (Exception e) {  
                        if (resp.status() == RestStatus.CREATED) successCount.incrementAndGet();
        // Flush thread — flushes while indexing is in progress
        flushIndex(indexName);
import org.opensearch.common.settings.Settings;
        // Close and reopen
        CyclicBarrier barrier = new CyclicBarrier(numIndexThreads + 1);
        CyclicBarrier barrier = new CyclicBarrier(numThreads);
     * in both formats. Index docs, flush some, then index more WITHOUT flushing. Close/reopen.
        // flushAndClose via index close (which triggers flushAndClose on the engine)  
        indexDocsTo(indexName, 10);  
        int numThreads = 4;
        long luceneRows = getRowCount(indexName, "lucene");
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
        long parquetRows = getRowCount(indexName, "parquet");  
        try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
    /**
        // Simulate unclean shutdown — engine fails without flushing
        int docsPerThread = 25;  
    public void testConcurrentIndexAndRefreshConsistency() throws Exception {  
     * Concurrent indexing + flush must not lose documents. All docs that got  
        indexDocsTo(indexName, 4);
        CompositeEngineHelper.indexDocs(this, indexName, count);
                        IndexResponse resp = client().prepareIndex(indexName)
        String indexName = "test-refresh-atomicity";  
                throw new RuntimeException(e);
 * The OpenSearch Contributors require contributions made to  
