 *
            assertCatalogSnapshotsConverged(INDEX_NAME);
     * <p>Uses Lucene as a secondary data format so that real Lucene segment files exist
            Object replicatingCommitData = ((org.opensearch.index.engine.exec.coord.DataformatAwareCatalogSnapshot) snapshot)
        indexer.setIgnoreIndexingFailures(true);
                org.opensearch.index.shard.IndexShard shard = getIndexShard(primaryNodeName(), INDEX_NAME);  
            cancelPrimaryAllocation(INDEX_NAME, 0, oldPrimary);
            indexer.start(-1);
     * The critical test for {@code bumpGenerationForNewEngineLifecycle}: the primary is promoted
     * <p>Failure mode without the fix: the replica's commitCatalogSnapshot writes an empty
     * IndexWriter has the correct Lucene segment entries (not an empty SegmentInfos) so
        BackgroundIndexer indexer = new BackgroundIndexer(
            indexer.continueIndexing(50);  
            // Do NOT pause — writes are actively in flight when promotion fires.
            "_doc",
    /**
    public void testPromotedPrimaryCanUploadToRemoteStore() throws Exception {
            assertTrue(
            60,
            waitForPrimaryTerm(INDEX_NAME, 0, 2L, TimeValue.timeValueSeconds(30));
    private void assertReplicatingCommitDataNotNull(org.opensearch.index.shard.IndexShard shard, String when) throws Exception {
            assertBusy(() -> {
        createDfaIndex(1);
     * Primary is cancelled WHILE writes are in flight — simulates an abrupt failover where  
    public void testGenerationBumpPreservesReplicatingCommitData() throws Exception {
        assertBusy(  
     * the replica and sets {@code replicatingCommitData} to a non-null value, then flushes the
}
            cancelPrimaryAllocation(INDEX_NAME, 0, oldPrimary);
            waitForIndexerDocs(100, indexer);  
            client().admin().indices().prepareFlush(INDEX_NAME).get();  
     * Builds a BackgroundIndexer that swallows indexing failures. Writes issued during the brief  
            indexer.pauseIndexing();  
 */  
 */
            waitForIndexerDocs(150, indexer);
            // Promote replica to primary
    /**
    }
 * compatible open source license.
            assertGenerationMonotonic(preGen, postGen);  
        try (BackgroundIndexer indexer = newIndexer()) {
            indexer.stopAndAwaitStopped();
 * <p>Invariants validated per test:
     * generation. The new primary's first committed generation must be strictly greater, so  
        String replicaNode = replicaNodeNames().get(0);
            cancelPrimaryAllocation(INDEX_NAME, 0, oldPrimary);  
            random()  
            INDEX_NAME,  
            // Force the new primary to flush — exercises the full upload path
    public void testUncleanFailoverWithContinuousIndexing() throws Exception {  
 * promotion is semantically equivalent to a failover: the replica becomes primary, the old
     * while the old primary had in-flight refresh/flush activity that advances the catalog
 * The OpenSearch Contributors require contributions made to  
     */  
 * <p>Promotion is triggered by cancelling the primary's allocation via {@code _cluster/reroute}
        assertReplicatingCommitDataNotNull(replica, "after generation bump (replica flush)");
            // Force a flush so segments are committed and replicated
package org.opensearch.composite;
     * on disk and must be correctly tracked through the promotion.
            waitForIndexerDocs(100, indexer);
     * no-primary window around a cancel/promote will get UnavailableShardsException; the test
        org.opensearch.index.shard.IndexShard replica = getIndexShard(replicaNode, INDEX_NAME);
            org.opensearch.index.engine.exec.coord.CatalogSnapshot snapshot = ref.get();  
     *
                .getReplicatingCommitData();  
            assertNotNull("replica catalog snapshot replicatingCommitData must not be null " + when, replicatingCommitData);
        );
        createDfaIndex(1);
                java.util.Set<String> formats = formatsOf(meta.getMetadata());
            long postGen = readCatalogGeneration(primaryNodeName(), INDEX_NAME);
            ensureGreen(GREEN_TIMEOUT, INDEX_NAME);
    private BackgroundIndexer newIndexer() {
                assertEquals("uploaded formats must match expected after promotion", expectedFormats(), formats);  
            () -> assertReplicatingCommitDataNotNull(replica, "after initial replication"),
     */
            assertCatalogSnapshotsConverged(INDEX_NAME);
        // 2. Trigger a generation bump on the replica.  
        }
            String oldPrimary = primaryNodeName();
            assertCatalogSnapshotsConverged(INDEX_NAME);
     * opens on this empty commit, LuceneReaderManager has no readers, and uploadMetadata
     * fails with IllegalStateException or produces corrupt metadata.
     *  
        return indexer;
     */  
        try (
 * rather than stopping the host node. This avoids tearing down the shared native runtime in the  
            waitForPrimaryTerm(INDEX_NAME, 0, 2L, TimeValue.timeValueSeconds(30));
     * metadata to remote store successfully. This validates that the promoted engine's
                org.opensearch.index.store.remote.metadata.RemoteSegmentMetadata meta = shard.getRemoteDirectory().readLatestMetadataFile();
            indexer.stopAndAwaitStopped();
            ensureGreen(GREEN_TIMEOUT, INDEX_NAME);  
            assertNoDataLoss(indexer, INDEX_NAME);
     * Primary is drained (indexer paused) before promotion — simulates a controlled handover  
import org.opensearch.test.OpenSearchIntegTestCase;  
     * Verifies that a generation bump on the replica preserves the primary's replicated  
                assertAllFormatDirsHaveFiles(shard);  
    public void testGracefulPromotionWithContinuousIndexing() throws Exception {  
 * </ul>  
        // 1. Refresh-level replication delivers a snapshot to the replica (sets replicatingCommitData,
        );
            waitForPrimaryTerm(INDEX_NAME, 0, 2L, TimeValue.timeValueSeconds(30));
            indexer.stopAndAwaitStopped();
    }
            client().admin().indices().prepareFlush(INDEX_NAME).get();
            RandomizedTest.scaledRandomIntBetween(2, 5),
            String oldPrimary = primaryNodeName();
     * replica to trigger a generation bump, and finally asserts that the replica's catalog snapshot
     *
            long preGen = readCatalogGeneration(oldPrimary, INDEX_NAME);
            waitForPrimaryTerm(INDEX_NAME, 0, 2L, TimeValue.timeValueSeconds(30));
        try (BackgroundIndexer indexer = newIndexer()) {  
    public void testPromotionWithInFlightRemoteStoreUpload() throws Exception {  
public class DataFormatAwareReplicationPromotionIT extends DataFormatAwareReplicationBaseIT {
        // 3. The bump must NOT have dropped replicatingCommitData.  
        ) {
            String oldPrimary = primaryNodeName();  
            java.util.concurrent.TimeUnit.SECONDS  
            // Pause indexer for a clean handover
        indexer.setUseAutoGeneratedIDs(true);
            waitForIndexerDocs(50, indexer);
        createDfaIndex(1);  
/**
        createDfaIndex(1);
 *
     */
     * remote-store uploads don't collide in remote metadata.
        indexDocs(50);
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
        try (BackgroundIndexer indexer = newIndexer()) {  
            client().admin().indices().prepareRefresh(INDEX_NAME).get();  
 *   <li>Indexer made forward progress before promotion (and we validate the pre-promotion
 * test JVM (see {@link DataFormatAwareReplicationBaseIT#cancelPrimaryAllocation}). The resulting
    /**
 * this file be licensed under the Apache-2.0 license or a
        }
            false,
            indexer.pauseIndexing();
        // snapshot must carry a non-null replicatingCommitData.
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
 * ITs for DFA primary promotion scenarios under continuous indexing load.  
     * tolerates these as expected.
     * SegmentInfos ({@code replicatingCommitData}).
            indexer.start(-1);
            cancelPrimaryAllocation(INDEX_NAME, 0, oldPrimary);  
            // the new engine must commit at a generation strictly greater than any seen on the old primary.
 *   <li>Primary term strictly advanced past the promotion.</li>
     */
            waitForIndexerDocs(100, indexer);
            // Pause writes to let the primary's buffer drain — the 'graceful' part.
     * buffered operations may be lost from the old primary.
        }
 * primary gets a new replica assignment, and the cluster returns to green.  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
            client().admin().indices().prepareFlush(INDEX_NAME).get();  
     */
            client(),
        // no commit-generation change => no bump).  
        createDfaIndex(1);
import org.opensearch.common.unit.TimeValue;
     * <p>The test indexes and refreshes (no flush) so segment replication delivers a snapshot to  
     * where no writes are in-flight during the promotion event.
            client().admin().indices().prepareFlush(INDEX_NAME).get();  
            ensureGreen(GREEN_TIMEOUT, INDEX_NAME);  
    }  
     * SegmentInfos (no Lucene segments). After promotion, the new primary's IndexWriter  
            ensureGreen(GREEN_TIMEOUT, INDEX_NAME);  
            // Force the new primary to commit — exercises the generation-bump contract:
     * that serializeToCommitFormat can produce valid bytes for the remote metadata file.  
     * After promotion, the new primary must be able to index new docs, flush, and upload  
 *   <li>For the in-flight-upload test: catalog generation monotonic across the promotion.</li>
            // Force a flush so the catalog generation advances meaningfully before promotion.
import com.carrotsearch.randomizedtesting.RandomizedTest;
        replica.flush(new org.opensearch.action.admin.indices.flush.FlushRequest(INDEX_NAME).force(true).waitIfOngoing(true));
 *   <li>Primary and replica catalog snapshots converge on the same file set.</li>
 *
 *       acknowledged writes are preserved).</li>  
        }
            }, 60, java.util.concurrent.TimeUnit.SECONDS);
                // All expected formats must be present in uploaded metadata
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
                .getCatalogSnapshot()
                assertNotNull("promoted primary must upload metadata to remote store", meta);
                "expected DataformatAwareCatalogSnapshot but got " + snapshot.getClass().getName(),
    private static final TimeValue GREEN_TIMEOUT = TimeValue.timeValueSeconds(90);  
    /**
                snapshot instanceof org.opensearch.index.engine.exec.coord.DataformatAwareCatalogSnapshot  
import org.opensearch.test.BackgroundIndexer;
            // Resume + index more on the new primary
 * SPDX-License-Identifier: Apache-2.0
            indexer.start(-1);
    /**  
            indexer.stopAndAwaitStopped();
    }  
    }  
        try (BackgroundIndexer indexer = newIndexer()) {  
            org.opensearch.common.concurrent.GatedCloseable<org.opensearch.index.engine.exec.coord.CatalogSnapshot> ref = shard  
/*  
            indexer.start(-1);
    }  
            String oldPrimary = primaryNodeName();
        // Pre-condition (guards test validity): once segrep has delivered, the replica's current
        indexer.setFailureAssertion(e -> {});  
        }  
 * <ul>  
    }  
            );
                DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shard);
     * still has non-null {@code replicatingCommitData}.  
    /**
            -1,  
            assertNoDataLoss(indexer, INDEX_NAME);  
