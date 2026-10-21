                    for (int i = 0; i < docsPerThread; i++) {
        DataFormatAwareEngine engine = getEngine();
        // Cycle 2: 8 docs → 1+ rotation
        CompositeEngineHelper.flush(this, INDEX_NAME);
 *   <li>Background native writes complete without data loss</li>
     */
    }
        engine.refresh("verify");
     */
     * Tests that concurrent refresh during rotation doesn't lose docs or break atomicity.
                        IndexResponse resp = client().prepareIndex(INDEX_NAME)
        createParquetLuceneIndex();
import org.opensearch.action.index.IndexResponse;
    private static final String INDEX_NAME = "test-vsr-rotation";
        long luceneRows = getRowCount("lucene");
        createParquetLuceneIndex();
            try {
 *   <li>High-throughput batches spanning multiple rotations produce correct totals</li>
        Settings extra = Settings.builder().put("index.composite.merge_on_refresh_max_size", "0b").build();
            ParquetDataFormatPlugin.class,
            }
    public void testHighThroughputBurstWithRapidRotations() throws Exception {
        createParquetLuceneIndex();
        // Cycle 3: 15 docs → 3 rotations
     */
import java.io.IOException;
    private DataFormatAwareEngine getEngine() {
        CyclicBarrier barrier = new CyclicBarrier(numThreads);
                    barrier.await();
                try {
 * <ul>
            indexThreads[t].start();
        // Flush thread — flushes repeatedly while indexing is ongoing
     * Multiple flush cycles where each cycle exceeds the VSR threshold.
        // Final flush to commit any remaining buffered data
import java.util.concurrent.CyclicBarrier;
            .put("parquet.max_rows_per_vsr", 5)
        flush();
    public void testMultipleFlushCyclesWithRotation() throws Exception {
            try {
                } catch (Exception e) {
        });
    public void testRefreshAfterRotationCapturesAllDocs() throws Exception {
    protected Settings nodeSettings(int nodeOrdinal) {
        assertEquals("lucene row count", expected, getRowCount("lucene"));
     * Alternating flush and index cycles where each batch crosses rotation boundaries.
     * Concurrent indexing + flush where flushes happen while VSR rotation is in progress.
import java.util.Collection;
     * flush (awaits pending write, then writes remaining). Under low threshold (5), almost
        int docsPerThread = 15;
 * Integration tests exercising Parquet VSR (VectorSchemaRoot) rotation under multi-format
        CyclicBarrier barrier = new CyclicBarrier(numIndexThreads + 1);
                try {
                    barrier.await();
/**
                } catch (Exception e) {
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
        // Refresh without flush — must see all 13
    }
        for (int t = 0; t < numIndexThreads; t++) {
 */
        createParquetLuceneIndex();
                    for (int i = 0; i < docsPerThread; i++) {
                    }
import org.opensearch.index.engine.exec.WriterFileSet;
        refreshThread.start();
                            .setSource("field_keyword", "t" + tid + "_d" + i, "field_number", i)
                    for (int i = 0; i < docsPerThread; i++) {
     * every flush will race with a pending rotation write.
        indexDocs(20);
    }
        indexDocs(12);
                    throw new RuntimeException(e);
        assertCrossFormatConsistency(expected);
        int numIndexThreads = 3;
        }
    public void testConcurrentIndexingAcrossRotationBoundaries() throws Exception {
        flush();
     * additive and consistent after each flush.
        AtomicInteger successCount = new AtomicInteger();
        int numRefreshes = 10;
            } catch (Exception e) {
                barrier.await();
        return CompositeEngineHelper.getEngine(clusterService(), internalCluster(), INDEX_NAME);
        assertFalse("no failures in high-throughput burst", resp.hasFailures());
            indexThreads[t] = new Thread(() -> {
        assertEquals("all 20 docs must survive recovery", 20, parquetRows);
            t.join();
     */
        int docsPerThread = 15; // 60 total → 12 rotations at threshold=5
                        if (resp.status() == RestStatus.CREATED) successCount.incrementAndGet();
                }
        createParquetLuceneIndex();
        });
                    throw new RuntimeException(e);
    }
            indexThreads[t] = new Thread(() -> {
        assertCrossFormatConsistency(batchSize);
        // merge-on-refresh code path is fixed.
        long luceneRows = getRowCount("lucene");
                try {
    /**
     */
     * Tests that the background write pipeline doesn't drop batches under pressure.
        Thread[] indexThreads = new Thread[numIndexThreads];
import org.opensearch.common.concurrent.GatedCloseable;
                    throw new RuntimeException(e);
                        long lc = snap.getSearchableFiles("lucene").stream().mapToLong(WriterFileSet::numRows).sum();
            .put(super.nodeSettings(nodeOrdinal))
        // Refresh thread — refreshes repeatedly, checking cross-format consistency each time
        CompositeEngineHelper.indexDocs(this, INDEX_NAME, count);
    }
        BulkResponse resp = bulk.get();
                            inconsistencyCount.incrementAndGet();
    private void indexDocs(int count) {
                        }
    private void flush() {
        );
    @Override
     * After VSR rotation, a refresh must capture all docs including those from the
     * Each refresh acquires the writer pool, flushes writers (triggering awaitPendingWrite
        BulkResponse resp = bulk.get();
        engine.refresh("test");
        createParquetLuceneIndex();
        CyclicBarrier barrier = new CyclicBarrier(numIndexThreads + 1);
        // Uncommitted: 8 more docs (1+ rotation) — only in translog
        assertCrossFormatConsistency(successCount.get());
                barrier.await();
        Thread flushThread = new Thread(() -> {
        client().admin().indices().prepareOpen(INDEX_NAME).get();
                        if (resp.status() == RestStatus.CREATED) successCount.incrementAndGet();
    }
        assertCrossFormatConsistency(20);
        flushThread.join();
import org.opensearch.be.lucene.LucenePlugin;
 * during normal indexing. This validates that:
        CompositeEngineHelper.assertPerSegmentRowCountsMatch(engine, "parquet", "lucene");
        for (Thread t : indexThreads) {
        assertCrossFormatConsistency(12);
 *
    /**
    /**
     * trigger rotation and still produce consistent cross-format state.
                            .get();
        int numThreads = 4;
     */
public class CompositeVSRRotationIT extends OpenSearchIntegTestCase {
        assertEquals("all should succeed", numThreads * docsPerThread, expected);
                }
import org.opensearch.core.rest.RestStatus;
        for (int i = 0; i < batchSize; i++) {
        ensureGreen(INDEX_NAME);
    public void testRotationStateResetsAcrossWriterGenerations() throws Exception {
            .build();
        }
    public void testConcurrentFlushDuringVSRRotation() throws Exception {
    /**
import java.util.concurrent.atomic.AtomicInteger;
    }
        flush();
        Thread[] indexThreads = new Thread[numIndexThreads];
    }
import org.opensearch.be.datafusion.DataFusionPlugin;
import org.opensearch.plugins.Plugin;
}
import org.opensearch.arrow.allocator.ArrowBasePlugin;
        int totalDocs = 100;
import org.opensearch.action.bulk.BulkResponse;
     * rotated (background-written) batch. No docs lost at rotation seams.
package org.opensearch.composite;
            ArrowBasePlugin.class,
     * Bulk indexing a batch larger than the VSR threshold must not lose docs
                            .get();
        // Committed: 12 docs (2+ rotations)
        assertFalse("no failures in bulk", resp.hasFailures());
        CompositeEngineHelper.createCompositeIndexWithMapping(this, INDEX_NAME, "parquet", extra, "lucene");
                }
                            .setSource("field_keyword", "t" + tid + "_d" + i, "field_number", i)
        createParquetLuceneIndex();
        }
        indexDocs(12);
        Thread[] threads = new Thread[numThreads];
        assertEquals("every mid-stream refresh must be cross-format consistent during rotation", 0, inconsistencyCount.get());
    public void testBulkIndexSpanningMultipleRotations() throws Exception {
                    Thread.sleep(3);
        int expected = successCount.get();
                        IndexResponse resp = client().prepareIndex(INDEX_NAME)
     * at rotation boundaries. All docs in the bulk must appear in both formats.
            final int tid = t;
    /**
        }
    }
            t.join();
        assertEquals("parquet must see all docs after rotation + refresh", 13, parquetRows);
            DataFusionPlugin.class
                for (int i = 0; i < 8; i++) {
        flush();
     */
                    try (GatedCloseable<CatalogSnapshot> ref = eng.acquireSnapshot()) {
    }
        assertCrossFormatConsistency(expected);
        client().admin().indices().prepareClose(INDEX_NAME).get();
        getEngine().refresh("verify");
/*
            t.join();
                }
        long parquetRows = getRowCount("parquet");
import org.opensearch.test.OpenSearchIntegTestCase;
        return Settings.builder()
        }
     * Index docs, flush, then index more docs spanning rotation, then close/reopen.
     */
        // Close/reopen — flushAndClose commits everything, reopen recovers
        indexDocs(5); // fills first VSR exactly
        indexDocs(8);
        assertEquals("lucene must match parquet", parquetRows, luceneRows);
    }
            });
 * composite indexing (Parquet primary + Lucene secondary).
                    Thread.sleep(5);
 * this file be licensed under the Apache-2.0 license or a
     * Each cycle triggers rotations independently; cross-format state must be
     * VSR threshold. Rotations happen under contention — must not lose docs or
        // Each flush retires the current writer; new writer starts fresh VSR state
        createParquetLuceneIndex();
    /**
    private long getRowCount(String formatName) throws IOException {
    /**
        for (int cycle = 0; cycle < 5; cycle++) {
                    barrier.await();
            flush();
        assertEquals("both formats must match after recovery", parquetRows, luceneRows);
                    }
 */
            threads[t].start();
        }
    }
            CompositeDataFormatPlugin.class,
 * The OpenSearch Contributors require contributions made to
        assertCrossFormatConsistency(20);
    /**
        assertCrossFormatConsistency(totalDocs);
 *   <li>VSR rotation boundaries don't break cross-format atomicity</li>
        indexDocs(15);
            LucenePlugin.class,
            });
    // ── Helpers ──
        for (int t = 0; t < numThreads; t++) {
                        IndexResponse resp = client().prepareIndex(INDEX_NAME)
            final int tid = t;
        int docsPerThread = 20;
 *   <li>Concurrent indexing across rotation boundaries maintains format consistency</li>
        flush();
                    flush();
                    eng.refresh("concurrent-check-" + r);
     * Concurrent indexing + refresh where refreshes race with VSR rotation.
        for (Thread t : indexThreads) {
                    }
                        if (resp.status() == RestStatus.CREATED) successCount.incrementAndGet();
                } catch (Exception e) {
        assertCrossFormatConsistency(35);
        // Index exactly at threshold boundaries: 5 + 5 + 3 = 13 docs
        BulkRequestBuilder bulk = client().prepareBulk();
        indexDocs(3); // partial third VSR
                        long pq = snap.getSearchableFiles("parquet").stream().mapToLong(WriterFileSet::numRows).sum();
        }
                }
        for (Thread t : threads) {
        flush();
            bulk.add(client().prepareIndex(INDEX_NAME).setSource("field_keyword", "burst_" + i, "field_number", i));
    }
            bulk.add(client().prepareIndex(INDEX_NAME).setSource("field_keyword", "bulk_" + i, "field_number", i));
            threads[t] = new Thread(() -> {
        createParquetLuceneIndex();
            indexThreads[t].start();
        BulkRequestBuilder bulk = client().prepareBulk();
        }
    }
        createParquetLuceneIndex();
     * Tests the interaction between: rotation (freezes VSR, submits background write) and
        flush();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
     * Indexing more docs than the VSR threshold in a single writer generation must
import java.util.Arrays;
        int expected = successCount.get();
 * </ul>
        AtomicInteger inconsistencyCount = new AtomicInteger();
        flush();
import org.opensearch.action.bulk.BulkRequestBuilder;
    /**
        int batchSize = 30; // 6 rotations at threshold=5
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
     */
    public void testRotationDuringSequentialIndexingMaintainsConsistency() throws Exception {
import org.opensearch.index.engine.DataFormatAwareEngine;
import org.opensearch.common.settings.Settings;
     */
        AtomicInteger successCount = new AtomicInteger();
        Thread refreshThread = new Thread(() -> {
    public void testRecoveryAfterRotation() throws Exception {
    }
        refreshThread.join();
        // Cycle 1: 12 docs → 2+ rotations
     * Concurrent indexing from multiple threads where total docs far exceed the
                            .get();
        AtomicInteger successCount = new AtomicInteger();
        flushThread.start();
        long parquetRows = getRowCount("parquet");
    @Override
        return Arrays.asList(
        indexDocs(8);
        assertEquals("parquet row count", expected, getRowCount("parquet"));
     * With max_rows_per_vsr=5, indexing 20 docs triggers 4 rotations.
    }
import org.opensearch.common.util.FeatureFlags;
     * With max_rows_per_vsr=5 and 100 docs, this creates 20 rotation cycles.
    public void testConcurrentRefreshDuringVSRRotation() throws Exception {
            indexDocs(7); // crosses threshold once per cycle
    }
                        if (pq != lc) {
        return CompositeEngineHelper.getRowCount(clusterService(), internalCluster(), INDEX_NAME, formatName);
                throw new RuntimeException(e);
import org.opensearch.parquet.ParquetDataFormatPlugin;
            });
 * Uses a low {@code parquet.max_rows_per_vsr} (5 rows) to force frequent VSR rotation
                DataFormatAwareEngine eng = getEngine();
        for (int t = 0; t < numIndexThreads; t++) {
        indexDocs(5); // triggers rotation, fills second VSR
 *
            }
        // TODO: Remove the merge_on_refresh_max_size=0b override once the thread leak in the
        for (int i = 0; i < totalDocs; i++) {
    private void createParquetLuceneIndex() {
     * After recovery, both formats must have all committed + replayed docs.
                for (int r = 0; r < numRefreshes; r++) {
 * SPDX-License-Identifier: Apache-2.0
        }
        flush();
     * produce cross-format mismatches.
            final int tid = t;
            } catch (Exception e) {
                throw new RuntimeException(e);
                    }
 * compatible open source license.
     * High-throughput burst that triggers many rapid rotations back-to-back.
    private void assertCrossFormatConsistency(long expected) throws IOException {
                        CatalogSnapshot snap = ref.get();
     * inside ParquetWriter.flush → VSRManager.flush), and commits a new CatalogSnapshot.
    }
        assertCrossFormatConsistency(35);
        int numIndexThreads = 3;
     * Tests that rotation state resets correctly between writer generations.
        flush();
        flush();
    /**
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        DataFormatAwareEngine engine = getEngine();
                            .setSource("field_keyword", "t" + tid + "_d" + i, "field_number", i)
