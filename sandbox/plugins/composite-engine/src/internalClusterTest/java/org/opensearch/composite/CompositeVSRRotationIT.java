        flush();
        int docsPerThread = 20;  
        for (int t = 0; t < numThreads; t++) {
        client().admin().indices().prepareClose(INDEX_NAME).get();
        indexDocs(5); // triggers rotation, fills second VSR  
            indexThreads[t] = new Thread(() -> {
 *   <li>Background native writes complete without data loss</li>
        });
                throw new RuntimeException(e);
            CompositeDataFormatPlugin.class,
     */
                            .setSource("field_keyword", "t" + tid + "_d" + i, "field_number", i)  
        indexDocs(12);  
        });
    public void testConcurrentFlushDuringVSRRotation() throws Exception {
                try {
                            .get();
        for (int t = 0; t < numIndexThreads; t++) {  
     * Concurrent indexing + flush where flushes happen while VSR rotation is in progress.  
            bulk.add(client().prepareIndex(INDEX_NAME).setSource("field_keyword", "burst_" + i, "field_number", i));  
    private DataFormatAwareEngine getEngine() {
/*  
                        CatalogSnapshot snap = ref.get();
        createParquetLuceneIndex();
                        long lc = snap.getSearchableFiles("lucene").stream().mapToLong(WriterFileSet::numRows).sum();
    }
                DataFormatAwareEngine eng = getEngine();
        // Cycle 1: 12 docs → 2+ rotations  
    /**
                } catch (Exception e) {
        createParquetLuceneIndex();
import org.opensearch.arrow.allocator.ArrowBasePlugin;
            t.join();  
            indexThreads[t].start();
        Settings extra = Settings.builder().put("index.composite.merge_on_refresh_max_size", "0b").build();
        for (int i = 0; i < totalDocs; i++) {
        // Final flush to commit any remaining buffered data  
        assertCrossFormatConsistency(12);  
    }  
        flushThread.start();
        CyclicBarrier barrier = new CyclicBarrier(numIndexThreads + 1);
    @Override
        refreshThread.join();
                    throw new RuntimeException(e);  
    protected Settings nodeSettings(int nodeOrdinal) {  
        Thread flushThread = new Thread(() -> {  
                barrier.await();
     * High-throughput burst that triggers many rapid rotations back-to-back.
import java.util.concurrent.CyclicBarrier;  
        flush();  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
        AtomicInteger successCount = new AtomicInteger();
            final int tid = t;  
        createParquetLuceneIndex();  
        BulkResponse resp = bulk.get();
 */  
                            .get();  
                } catch (Exception e) {
        assertCrossFormatConsistency(35);  
    }
import java.io.IOException;  
     * Alternating flush and index cycles where each batch crosses rotation boundaries.  
                    }
 * </ul>
                    barrier.await();
                barrier.await();  
     * With max_rows_per_vsr=5, indexing 20 docs triggers 4 rotations.
        AtomicInteger successCount = new AtomicInteger();
     */
import org.opensearch.index.engine.DataFormatAwareEngine;
        indexDocs(20);
        long luceneRows = getRowCount("lucene");  
                }
        Thread[] indexThreads = new Thread[numIndexThreads];
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    @Override  
    private long getRowCount(String formatName) throws IOException {  
        int totalDocs = 100;  
            final int tid = t;
     * inside ParquetWriter.flush → VSRManager.flush), and commits a new CatalogSnapshot.
                throw new RuntimeException(e);  
import org.opensearch.be.lucene.LucenePlugin;  
     */
        DataFormatAwareEngine engine = getEngine();
        getEngine().refresh("verify");  
        assertEquals("all 20 docs must survive recovery", 20, parquetRows);
        BulkResponse resp = bulk.get();
        long parquetRows = getRowCount("parquet");
        CompositeEngineHelper.flush(this, INDEX_NAME);
        indexDocs(12);
        client().admin().indices().prepareOpen(INDEX_NAME).get();
        CyclicBarrier barrier = new CyclicBarrier(numThreads);  
                try {
import org.opensearch.core.rest.RestStatus;
        flush();
import org.opensearch.common.settings.Settings;
    private void createParquetLuceneIndex() {
     * Tests that concurrent refresh during rotation doesn't lose docs or break atomicity.
        int expected = successCount.get();  
    }  
            final int tid = t;
        for (int t = 0; t < numIndexThreads; t++) {
        indexDocs(8);
                }  
        assertCrossFormatConsistency(20);
     * After recovery, both formats must have all committed + replayed docs.  
            bulk.add(client().prepareIndex(INDEX_NAME).setSource("field_keyword", "bulk_" + i, "field_number", i));
        indexDocs(5); // fills first VSR exactly
 * this file be licensed under the Apache-2.0 license or a
        Thread refreshThread = new Thread(() -> {
        // Each flush retires the current writer; new writer starts fresh VSR state  
        return CompositeEngineHelper.getEngine(clusterService(), internalCluster(), INDEX_NAME);  
        }
                } catch (Exception e) {  
            t.join();
public class CompositeVSRRotationIT extends OpenSearchIntegTestCase {
                try {  
    /**
            } catch (Exception e) {
            });
    private static final String INDEX_NAME = "test-vsr-rotation";
        Thread[] threads = new Thread[numThreads];  
            indexDocs(7); // crosses threshold once per cycle
        assertCrossFormatConsistency(batchSize);
    public void testHighThroughputBurstWithRapidRotations() throws Exception {  
                            .get();
package org.opensearch.composite;
        indexDocs(8);  
        Thread[] indexThreads = new Thread[numIndexThreads];
            t.join();
 * composite indexing (Parquet primary + Lucene secondary).
                    Thread.sleep(5);
    /**
        }  
        ensureGreen(INDEX_NAME);  
        assertCrossFormatConsistency(35);
     * Index docs, flush, then index more docs spanning rotation, then close/reopen.
        createParquetLuceneIndex();
            LucenePlugin.class,  
    private void assertCrossFormatConsistency(long expected) throws IOException {
        flush();
     */  
            .put(super.nodeSettings(nodeOrdinal))
     */
import java.util.Arrays;
    }
        assertEquals("parquet row count", expected, getRowCount("parquet"));
        assertEquals("all should succeed", numThreads * docsPerThread, expected);
        // Cycle 3: 15 docs → 3 rotations
     * Tests that rotation state resets correctly between writer generations.
        }  
        CompositeEngineHelper.createCompositeIndexWithMapping(this, INDEX_NAME, "parquet", extra, "lucene");  
        // merge-on-refresh code path is fixed.
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)  
     * Each cycle triggers rotations independently; cross-format state must be  
        assertCrossFormatConsistency(20);
        assertEquals("both formats must match after recovery", parquetRows, luceneRows);
                            .setSource("field_keyword", "t" + tid + "_d" + i, "field_number", i)
        flush();
    public void testRotationStateResetsAcrossWriterGenerations() throws Exception {  
            try {
            });
 * compatible open source license.
    private void indexDocs(int count) {  
        }
                        IndexResponse resp = client().prepareIndex(INDEX_NAME)  
    /**
        CyclicBarrier barrier = new CyclicBarrier(numIndexThreads + 1);
    }
        flushThread.join();
    }  
                    for (int i = 0; i < docsPerThread; i++) {  
        engine.refresh("verify");  
        assertCrossFormatConsistency(totalDocs);  
 * <ul>  
        assertCrossFormatConsistency(successCount.get());
            flush();  
        }
        int docsPerThread = 15; // 60 total → 12 rotations at threshold=5
import org.opensearch.common.util.FeatureFlags;  
            try {
import java.util.concurrent.atomic.AtomicInteger;
    public void testConcurrentIndexingAcrossRotationBoundaries() throws Exception {
import org.opensearch.action.bulk.BulkResponse;
        assertEquals("every mid-stream refresh must be cross-format consistent during rotation", 0, inconsistencyCount.get());
                        IndexResponse resp = client().prepareIndex(INDEX_NAME)
    }
    }  
        engine.refresh("test");
        createParquetLuceneIndex();  
import org.opensearch.parquet.ParquetDataFormatPlugin;
    }
        for (int cycle = 0; cycle < 5; cycle++) {
                        if (pq != lc) {
            threads[t] = new Thread(() -> {  
                    for (int i = 0; i < docsPerThread; i++) {
     * Bulk indexing a batch larger than the VSR threshold must not lose docs
                }
     * Concurrent indexing + refresh where refreshes race with VSR rotation.
        return Arrays.asList(
        assertFalse("no failures in bulk", resp.hasFailures());
 *   <li>Concurrent indexing across rotation boundaries maintains format consistency</li>  
            }  
import org.opensearch.action.bulk.BulkRequestBuilder;
                    throw new RuntimeException(e);
            });  
                    }  
    public void testMultipleFlushCyclesWithRotation() throws Exception {  
                    flush();
import org.opensearch.plugins.Plugin;  
        // Index exactly at threshold boundaries: 5 + 5 + 3 = 13 docs
 * Uses a low {@code parquet.max_rows_per_vsr} (5 rows) to force frequent VSR rotation
                    }
     * After VSR rotation, a refresh must capture all docs including those from the
     * trigger rotation and still produce consistent cross-format state.
     * every flush will race with a pending rotation write.  
     * Each refresh acquires the writer pool, flushes writers (triggering awaitPendingWrite  
                    }
     * Concurrent indexing from multiple threads where total docs far exceed the  
 *   <li>High-throughput batches spanning multiple rotations produce correct totals</li>
import org.opensearch.test.OpenSearchIntegTestCase;
     * Multiple flush cycles where each cycle exceeds the VSR threshold.
 */  
        int expected = successCount.get();
                    barrier.await();  
        createParquetLuceneIndex();
        int numThreads = 4;
    }
        AtomicInteger successCount = new AtomicInteger();
        assertCrossFormatConsistency(expected);
        assertEquals("lucene must match parquet", parquetRows, luceneRows);
        // Uncommitted: 8 more docs (1+ rotation) — only in translog  
    /**  
                        if (resp.status() == RestStatus.CREATED) successCount.incrementAndGet();  
        long luceneRows = getRowCount("lucene");
        refreshThread.start();  
 * SPDX-License-Identifier: Apache-2.0
        createParquetLuceneIndex();
 *
        int numIndexThreads = 3;
        // Committed: 12 docs (2+ rotations)
     * at rotation boundaries. All docs in the bulk must appear in both formats.  
                        if (resp.status() == RestStatus.CREATED) successCount.incrementAndGet();
 *  
        for (Thread t : threads) {  
    }
                    for (int i = 0; i < docsPerThread; i++) {
    }
        return CompositeEngineHelper.getRowCount(clusterService(), internalCluster(), INDEX_NAME, formatName);
    public void testRefreshAfterRotationCapturesAllDocs() throws Exception {
        AtomicInteger inconsistencyCount = new AtomicInteger();  
    /**
    /**
        flush();
        }
        int numRefreshes = 10;  
     * Tests the interaction between: rotation (freezes VSR, submits background write) and
        assertCrossFormatConsistency(expected);
                    barrier.await();
        // Close/reopen — flushAndClose commits everything, reopen recovers  
        flush();
        long parquetRows = getRowCount("parquet");
    }  
        flush();
        // TODO: Remove the merge_on_refresh_max_size=0b override once the thread leak in the  
                        if (resp.status() == RestStatus.CREATED) successCount.incrementAndGet();
     */
                        long pq = snap.getSearchableFiles("parquet").stream().mapToLong(WriterFileSet::numRows).sum();  
    private void flush() {
     * Tests that the background write pipeline doesn't drop batches under pressure.
        }  
        CompositeEngineHelper.indexDocs(this, INDEX_NAME, count);
                }  
/**  
        indexDocs(3); // partial third VSR
     * rotated (background-written) batch. No docs lost at rotation seams.
}
        assertEquals("parquet must see all docs after rotation + refresh", 13, parquetRows);  
 * during normal indexing. This validates that:
     * additive and consistent after each flush.
     * Indexing more docs than the VSR threshold in a single writer generation must  
        return Settings.builder()
        }
     */  
    public void testRecoveryAfterRotation() throws Exception {
        );
     * produce cross-format mismatches.
            ParquetDataFormatPlugin.class,
        }
            ArrowBasePlugin.class,  
        createParquetLuceneIndex();
     * With max_rows_per_vsr=5 and 100 docs, this creates 20 rotation cycles.  
        int docsPerThread = 15;
    // ── Helpers ──  
        // Cycle 2: 8 docs → 1+ rotation
    /**
        assertEquals("lucene row count", expected, getRowCount("lucene"));
            indexThreads[t] = new Thread(() -> {
        assertFalse("no failures in high-throughput burst", resp.hasFailures());  
        DataFormatAwareEngine engine = getEngine();
                    throw new RuntimeException(e);
        createParquetLuceneIndex();
    }
        BulkRequestBuilder bulk = client().prepareBulk();
import org.opensearch.be.datafusion.DataFusionPlugin;
     */  
                for (int r = 0; r < numRefreshes; r++) {
     * flush (awaits pending write, then writes remaining). Under low threshold (5), almost
        // Refresh without flush — must see all 13  
                    Thread.sleep(3);  
            }
        createParquetLuceneIndex();  
 *   <li>VSR rotation boundaries don't break cross-format atomicity</li>
                        }
        // Flush thread — flushes repeatedly while indexing is ongoing
        CompositeEngineHelper.assertPerSegmentRowCountsMatch(engine, "parquet", "lucene");  
    /**
        for (Thread t : indexThreads) {
        int batchSize = 30; // 6 rotations at threshold=5
            threads[t].start();
        indexDocs(15);
                            inconsistencyCount.incrementAndGet();  
        BulkRequestBuilder bulk = client().prepareBulk();  
            } catch (Exception e) {
            .put("parquet.max_rows_per_vsr", 5)
 * Integration tests exercising Parquet VSR (VectorSchemaRoot) rotation under multi-format
import org.opensearch.common.concurrent.GatedCloseable;
import org.opensearch.index.engine.exec.WriterFileSet;  
    /**
     */
    }  
        int numIndexThreads = 3;
        flush();  
    public void testRotationDuringSequentialIndexingMaintainsConsistency() throws Exception {
    }
                        IndexResponse resp = client().prepareIndex(INDEX_NAME)
                for (int i = 0; i < 8; i++) {  
            indexThreads[t].start();  
import org.opensearch.action.index.IndexResponse;  
 * The OpenSearch Contributors require contributions made to  
    }
     */  
     * VSR threshold. Rotations happen under contention — must not lose docs or
        for (int i = 0; i < batchSize; i++) {
        flush();
            DataFusionPlugin.class
        // Refresh thread — refreshes repeatedly, checking cross-format consistency each time  
import java.util.Collection;
                    eng.refresh("concurrent-check-" + r);  
        flush();
        for (Thread t : indexThreads) {
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
            .build();
                    try (GatedCloseable<CatalogSnapshot> ref = eng.acquireSnapshot()) {
                            .setSource("field_keyword", "t" + tid + "_d" + i, "field_number", i)
    public void testConcurrentRefreshDuringVSRRotation() throws Exception {
    public void testBulkIndexSpanningMultipleRotations() throws Exception {
                }
