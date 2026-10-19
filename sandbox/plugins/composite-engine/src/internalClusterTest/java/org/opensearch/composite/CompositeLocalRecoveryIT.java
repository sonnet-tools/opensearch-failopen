            assertFalse("Snapshot must have segments", snapshot.getSegments().isEmpty());  
        int numDocs = randomIntBetween(5, 20);
 * <p>Exercises the CatalogSnapshotManager fix that notifies listeners about
        indexDocs(INDEX_NAME, initialDocs, 0);  
     * must contain segments with the correct row count — confirming that committed
            assertFalse("Snapshot must have segments after recovery", snapshot.getSegments().isEmpty());
            assertFalse("Snapshot must have segments after second restart", snapshot.getSegments().isEmpty());  
    public void testEngineAcceptsNewWritesAfterRestart() throws Exception {  
        internalCluster().fullRestart();
    public void testCatalogSnapshotRestoredWithBothFormats() throws Exception {  
        internalCluster().fullRestart();  
    /**
        int secondBatch = randomIntBetween(5, 10);  
            long rowsAfter = getTotalRowCount(snapshot);  
        int newDocs = randomIntBetween(5, 15);
    }  
    }
                assertTrue("Each segment must have lucene files", segment.dfGroupedSearchableFiles().containsKey("lucene"));
                .filter(wfs -> wfs.files().stream().anyMatch(f -> f.endsWith(".parquet") || true))  
        // After restart + translog recovery, all docs must be reflected  
                .mapToLong(org.opensearch.index.engine.exec.WriterFileSet::numRows)
        // Index more without flush — these are in translog only  
        try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
            long parquetRows = snapshot.getSegments()
            assertEquals("Row count must be identical after restart", rowsBefore, rowsAfter);
        }
        indexDocs(INDEX_NAME, secondBatch, firstBatch);
import java.io.IOException;
 * catalog snapshots and initializes reader managers so that the catalog snapshot
        createCompositeIndex(INDEX_NAME);
 * committed snapshots on engine startup.  
        try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
 * compatible open source license.
            CatalogSnapshot snapshot = ref.get();
public class CompositeLocalRecoveryIT extends AbstractCompositeEngineIT {
                .flatMap(s -> s.dfGroupedSearchableFiles().values().stream())
            assertFalse("Snapshot must have segments after restart", snapshot.getSegments().isEmpty());
 * is immediately available without requiring translog replay or explicit refresh.  
     */
    public void testCatalogSnapshotRestoredAfterRestart() throws Exception {
            assertEquals("All rows (committed + recovered) must be present", rowsBefore, rowsAfter);
        refreshIndex(INDEX_NAME);
        createCompositeIndex(INDEX_NAME);
 * <p>Validates that after a node restart, the engine correctly restores committed
 * The OpenSearch Contributors require contributions made to  
            CatalogSnapshot snapshot = ref.get();
 *  
            CatalogSnapshot snapshot = ref.get();  
        flushIndex(INDEX_NAME);  
    private long getRowCountFromEngine(String indexName) throws IOException {
        flushIndex(INDEX_NAME);  
        internalCluster().fullRestart();
    /**
import org.opensearch.common.concurrent.GatedCloseable;
     */  
    /**
        flushIndex(INDEX_NAME);
        assertTrue("Should have rows before restart", rowsBefore > 0);
        ensureGreen(INDEX_NAME);
    }  
        createCompositeIndex(INDEX_NAME);  
import org.opensearch.test.OpenSearchIntegTestCase;  
        indexDocs(INDEX_NAME, unflushedDocs, flushedDocs);
    }
        long rowsBefore = getRowCountFromEngine(INDEX_NAME);  
        ensureGreen(INDEX_NAME);  
    private static final String INDEX_NAME = "test-local-recovery";  
        // Second lifecycle — add more data
 * this file be licensed under the Apache-2.0 license or a
    }
        refreshIndex(INDEX_NAME);
        }
     * and verify the catalog snapshot reflects both recovered and new data.
     */
    /**
        try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
        flushIndex(INDEX_NAME);
        DataFormatAwareEngine engine = getEngine(INDEX_NAME);
 */  
        indexDocs(INDEX_NAME, newDocs, initialDocs);  
/*  
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)  
        }  
@AwaitsFix(bugUrl = "Flaky test - fix before enabling")
        ensureGreen(INDEX_NAME);
        internalCluster().fullRestart();
        flushIndex(INDEX_NAME);  
        try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
            assertTrue("Snapshot generation must be > 0", snapshot.getGeneration() > 0);
        int firstBatch = randomIntBetween(5, 10);  
            // For parquet (primary), row count should reflect all docs
        indexDocs(INDEX_NAME, flushedDocs, 0);
     * recovery must replay the unflushed ops and the catalog snapshot must reflect  
                .filter(s -> s.dfGroupedSearchableFiles().containsKey("parquet"))
        refreshIndex(INDEX_NAME);
     * data is restored and reader managers are initialized without translog replay.
 * Integration tests for local recovery of the composite engine (parquet + lucene).
            }  
     * parquet (primary) and lucene (secondary) formats.
            for (Segment segment : snapshot.getSegments()) {  
        createCompositeIndex(INDEX_NAME);
        ensureGreen(INDEX_NAME);
        indexDocs(INDEX_NAME, numDocs, 0);
        DataFormatAwareEngine engine = getEngine(INDEX_NAME);
}
        DataFormatAwareEngine engine = getEngine(INDEX_NAME);  
        refreshIndex(INDEX_NAME);
        createCompositeIndex(INDEX_NAME);
        DataFormatAwareEngine engine = getEngine(INDEX_NAME);
    public void testMultipleRestartCyclesAccumulateData() throws Exception {
     * After restart, the catalog snapshot must have segments with files for both  
            long totalRows = getTotalRowCount(snapshot);
    public void testTranslogRecoveryAfterRestart() throws Exception {  
 * SPDX-License-Identifier: Apache-2.0
     * Index docs, flush, then index more WITHOUT flushing. After restart, translog
        int unflushedDocs = randomIntBetween(5, 15);  
    }  
import org.opensearch.index.engine.DataFormatAwareEngine;  
        // Index new docs after restart
        refreshIndex(INDEX_NAME);
        indexDocs(INDEX_NAME, firstBatch, 0);
        ensureGreen(INDEX_NAME);
package org.opensearch.composite;
                .stream()  
        try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
        internalCluster().fullRestart();  
        // Verify snapshot before restart
        }
 */
     * After restart, the engine must accept new writes. Index new docs, refresh,  
            // Each format stores all docs, so per-format row count = total docs  
        DataFormatAwareEngine engine = getEngine(indexName);  
        try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
     * Two restart cycles: index->flush->restart->index->flush->restart. The second
            assertTrue("Total rows must include both recovered and new docs", totalRows > initialDocs);  
 *
                .sum();
    /**
        // After second restart, catalog snapshot must reflect all accumulated data
/**
        refreshIndex(INDEX_NAME);
     */
        }
            return getTotalRowCount(ref.get());
        refreshIndex(INDEX_NAME);
            CatalogSnapshot snapshot = ref.get();  
            long rowsAfter = getTotalRowCount(ref.get());  
        indexDocs(INDEX_NAME, numDocs, 0);  
        int initialDocs = randomIntBetween(5, 15);
        // First lifecycle
        int numDocs = randomIntBetween(10, 30);  
     * restart must see accumulated data from both lifecycles.  
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
        }
            long totalRows = getTotalRowCount(snapshot);  
        ensureGreen(INDEX_NAME);  
                assertTrue("Each segment must have parquet files", segment.dfGroupedSearchableFiles().containsKey("parquet"));
import org.opensearch.index.engine.exec.Segment;
        refreshIndex(INDEX_NAME);  
 *
     * all documents.
     * Index docs, flush (commit), restart node. After restart, the catalog snapshot  
        long rowsBefore = getRowCountFromEngine(INDEX_NAME);
        int flushedDocs = randomIntBetween(5, 15);
     */
        // After restart, snapshot must be immediately available with same row count  
            assertTrue("Total rows must reflect both batches", totalRows > 0);
        internalCluster().fullRestart();
        flushIndex(INDEX_NAME);
        DataFormatAwareEngine engine = getEngine(INDEX_NAME);  
