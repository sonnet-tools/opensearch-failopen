        refreshIndex(INDEX_NAME);
        // After restart + translog recovery, all docs must be reflected
        int numDocs = randomIntBetween(5, 20);
                .filter(wfs -> wfs.files().stream().anyMatch(f -> f.endsWith(".parquet") || true))
        createCompositeIndex(INDEX_NAME);
        try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
    /**
            long totalRows = getTotalRowCount(snapshot);
     * Index docs, flush, then index more WITHOUT flushing. After restart, translog
 *
        internalCluster().fullRestart();
@AwaitsFix(bugUrl = "Flaky test - fix before enabling")
     * After restart, the engine must accept new writes. Index new docs, refresh,
import org.opensearch.common.concurrent.GatedCloseable;
            long rowsAfter = getTotalRowCount(snapshot);
        long rowsBefore = getRowCountFromEngine(INDEX_NAME);
    public void testEngineAcceptsNewWritesAfterRestart() throws Exception {
     */
 * this file be licensed under the Apache-2.0 license or a
            assertTrue("Total rows must reflect both batches", totalRows > 0);
        refreshIndex(INDEX_NAME);
     * restart must see accumulated data from both lifecycles.
 *
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
            CatalogSnapshot snapshot = ref.get();
        }
        // Index new docs after restart
}
import org.opensearch.index.engine.DataFormatAwareEngine;
        indexDocs(INDEX_NAME, initialDocs, 0);
        try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
import org.opensearch.test.OpenSearchIntegTestCase;
        indexDocs(INDEX_NAME, unflushedDocs, flushedDocs);
        refreshIndex(INDEX_NAME);
            // For parquet (primary), row count should reflect all docs
                .filter(s -> s.dfGroupedSearchableFiles().containsKey("parquet"))
 * <p>Validates that after a node restart, the engine correctly restores committed
        // Second lifecycle — add more data
        internalCluster().fullRestart();
        refreshIndex(INDEX_NAME);
    public void testCatalogSnapshotRestoredWithBothFormats() throws Exception {
    }
        ensureGreen(INDEX_NAME);
    }
        DataFormatAwareEngine engine = getEngine(INDEX_NAME);
            assertFalse("Snapshot must have segments after second restart", snapshot.getSegments().isEmpty());
        refreshIndex(INDEX_NAME);
 */
            long totalRows = getTotalRowCount(snapshot);
        internalCluster().fullRestart();
    public void testMultipleRestartCyclesAccumulateData() throws Exception {
    private long getRowCountFromEngine(String indexName) throws IOException {
        try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
        int secondBatch = randomIntBetween(5, 10);
 * <p>Exercises the CatalogSnapshotManager fix that notifies listeners about
        // First lifecycle
            assertFalse("Snapshot must have segments after restart", snapshot.getSegments().isEmpty());
        // After second restart, catalog snapshot must reflect all accumulated data
    }
            for (Segment segment : snapshot.getSegments()) {
            assertFalse("Snapshot must have segments after recovery", snapshot.getSegments().isEmpty());
    /**
            long parquetRows = snapshot.getSegments()
        // Index more without flush — these are in translog only
        DataFormatAwareEngine engine = getEngine(INDEX_NAME);
     */
            CatalogSnapshot snapshot = ref.get();
        ensureGreen(INDEX_NAME);
        indexDocs(INDEX_NAME, numDocs, 0);
                .sum();
    /**
        refreshIndex(INDEX_NAME);
        // Verify snapshot before restart
        try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
        long rowsBefore = getRowCountFromEngine(INDEX_NAME);
        createCompositeIndex(INDEX_NAME);
        }
        try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
        ensureGreen(INDEX_NAME);
            long rowsAfter = getTotalRowCount(ref.get());
            CatalogSnapshot snapshot = ref.get();
/*
 */
        DataFormatAwareEngine engine = getEngine(INDEX_NAME);
    }
import org.opensearch.index.engine.exec.Segment;
        assertTrue("Should have rows before restart", rowsBefore > 0);
        ensureGreen(INDEX_NAME);
        ensureGreen(INDEX_NAME);
        internalCluster().fullRestart();
     * and verify the catalog snapshot reflects both recovered and new data.
                .flatMap(s -> s.dfGroupedSearchableFiles().values().stream())
    public void testCatalogSnapshotRestoredAfterRestart() throws Exception {
        int initialDocs = randomIntBetween(5, 15);
     * Index docs, flush (commit), restart node. After restart, the catalog snapshot
 * is immediately available without requiring translog replay or explicit refresh.
 * SPDX-License-Identifier: Apache-2.0
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
        refreshIndex(INDEX_NAME);
        }
 * committed snapshots on engine startup.
     */
    }
        internalCluster().fullRestart();
            assertTrue("Snapshot generation must be > 0", snapshot.getGeneration() > 0);
/**
     * recovery must replay the unflushed ops and the catalog snapshot must reflect
        int unflushedDocs = randomIntBetween(5, 15);
            return getTotalRowCount(ref.get());
 * compatible open source license.
 * catalog snapshots and initializes reader managers so that the catalog snapshot
        flushIndex(INDEX_NAME);
            assertEquals("Row count must be identical after restart", rowsBefore, rowsAfter);
            assertFalse("Snapshot must have segments", snapshot.getSegments().isEmpty());
        flushIndex(INDEX_NAME);
        ensureGreen(INDEX_NAME);
        refreshIndex(INDEX_NAME);
        DataFormatAwareEngine engine = getEngine(indexName);
     * After restart, the catalog snapshot must have segments with files for both
package org.opensearch.composite;
        int flushedDocs = randomIntBetween(5, 15);
            CatalogSnapshot snapshot = ref.get();
        createCompositeIndex(INDEX_NAME);
        int newDocs = randomIntBetween(5, 15);
    /**
            }
        internalCluster().fullRestart();
        flushIndex(INDEX_NAME);
 *
     * must contain segments with the correct row count — confirming that committed
        indexDocs(INDEX_NAME, flushedDocs, 0);
        int firstBatch = randomIntBetween(5, 10);
        flushIndex(INDEX_NAME);
import java.io.IOException;
        DataFormatAwareEngine engine = getEngine(INDEX_NAME);
     */
        }
        indexDocs(INDEX_NAME, secondBatch, firstBatch);
        try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
    private static final String INDEX_NAME = "test-local-recovery";
     * data is restored and reader managers are initialized without translog replay.
    public void testTranslogRecoveryAfterRestart() throws Exception {
    }
                .mapToLong(org.opensearch.index.engine.exec.WriterFileSet::numRows)
     */
 * The OpenSearch Contributors require contributions made to
        createCompositeIndex(INDEX_NAME);
        flushIndex(INDEX_NAME);
        indexDocs(INDEX_NAME, firstBatch, 0);
    /**
     * all documents.
        indexDocs(INDEX_NAME, numDocs, 0);
            // Each format stores all docs, so per-format row count = total docs
        // After restart, snapshot must be immediately available with same row count
 * Integration tests for local recovery of the composite engine (parquet + lucene).
        createCompositeIndex(INDEX_NAME);
                assertTrue("Each segment must have parquet files", segment.dfGroupedSearchableFiles().containsKey("parquet"));
        DataFormatAwareEngine engine = getEngine(INDEX_NAME);
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
            assertTrue("Total rows must include both recovered and new docs", totalRows > initialDocs);
        }
            assertEquals("All rows (committed + recovered) must be present", rowsBefore, rowsAfter);
        }
                .stream()
        int numDocs = randomIntBetween(10, 30);
     * parquet (primary) and lucene (secondary) formats.
        flushIndex(INDEX_NAME);
     * Two restart cycles: index->flush->restart->index->flush->restart. The second
        indexDocs(INDEX_NAME, newDocs, initialDocs);
                assertTrue("Each segment must have lucene files", segment.dfGroupedSearchableFiles().containsKey("lucene"));
public class CompositeLocalRecoveryIT extends AbstractCompositeEngineIT {
