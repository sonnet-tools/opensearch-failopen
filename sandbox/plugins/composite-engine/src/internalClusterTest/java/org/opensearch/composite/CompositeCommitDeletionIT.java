        assertNotNull(getEngine(shard).commitStats());  
        indexDocs(10, 20);  
        IndexShard shard = getPrimaryShard();  
        Set<String> filesAfterFlushes = listFiles(dataPath.resolve("index"));
    public void testOldCommitDeletedAfterFlush() throws Exception {  
        String maxSeqNoStr = commitStats.getUserData().get(SequenceNumbers.MAX_SEQ_NO);  
        IndexShard shard = getPrimaryShard();
 *
        createCompositeIndex();
    private Set<String> listFiles(Path dir) throws IOException {
    // ---- Test 1: Old commit files deleted after flush ----
    }
        flush();
import org.opensearch.arrow.allocator.ArrowBasePlugin;
import org.opensearch.common.settings.Settings;  
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
        try (GatedCloseable<CatalogSnapshot> snapshot = engine.acquireSnapshot()) {  
            .prepareCreate(INDEX_NAME)  
import org.opensearch.index.seqno.SequenceNumbers;
            gen1 = cs.getGeneration();
            .put(super.nodeSettings(nodeOrdinal))
            ParquetDataFormatPlugin.class,  
    // ---- Test 5: Multi-format file cleanup ----  
        long gen1;
        snapshotHold.close();
        flush();  
        // GCP is advanced asynchronously via the global checkpoint sync action.
        // Verify engine is functional after recovery
        assertNotNull(commitStats);
import org.opensearch.common.concurrent.GatedCloseable;
        FlushResponse flushResponse = flush();
        for (int i = startId; i < startId + count; i++) {
        indexDocs(5, 0);
 * SPDX-License-Identifier: Apache-2.0
    public void testRecoveryAfterCloseReopen() throws Exception {
        // Release snapshot
        assertEquals("Only latest commit remains", 1, commitCount(shard));
        return (int) commits.stream().map(c -> {
            ArrowBasePlugin.class,
        indexDocs(10, 0);
    public void testAcquireSnapshotPreventsFileDeletion() throws Exception {
import org.opensearch.core.rest.RestStatus;
import org.opensearch.index.engine.CommitStats;
        DataFormatAwareEngine engine = getEngine(shard);  
    }
        createCompositeIndex();  
    protected Settings nodeSettings(int nodeOrdinal) {
        createCompositeIndex();  
    @Override
        // After more indexing + flush, new snapshot should reflect new state
 * with composite (Lucene + Parquet) data format.
}
import org.opensearch.index.shard.IndexShardTestCase;  
            )  
            }  
        createCompositeIndex();  
        client().admin().indices().prepareClose(INDEX_NAME).get();  
import java.util.Objects;  
        flush();  
        createCompositeIndex();
        }).filter(Objects::nonNull).distinct().count();
            return stream.map(p -> p.getFileName().toString()).collect(Collectors.toSet());
        indexDocs(10, 10);
import java.util.Arrays;  
        flush();
import org.opensearch.be.lucene.LucenePlugin;  
    public void testMultiFormatFilesCleanedUpOnDeletion() throws Exception {
        indexDocs(5, 30);
        return indexService.getShard(0);  
    private DataFormatAwareEngine getEngine(IndexShard shard) {  
            if (f.startsWith("segments_") || f.equals("write.lock")) continue;  
        return (DataFormatAwareEngine) IndexShardTestCase.getIndexer(shard);
        // Flush again to trigger cleanup
                    .putList("index.composite.secondary_data_formats", "lucene")
            .build();  
        return Arrays.asList(
    // ---- Test 2: Recovery after close/reopen ----  
            try {
        indexDocs(10, 20);  
    }
        return client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).setWaitIfOngoing(true).get();
import org.opensearch.index.engine.DataFormatAwareEngine;
    public void testAcquireSnapshotReturnsLatestState() throws Exception {
        }  
        assertEquals("Old commits should be cleaned after release", 1, commitCount(shard));  
        // Verify we can still index and flush
    }
            .indices()
        // Restart the node — translog replay should recover unflushed docs
    }  
        indexDocs(10, 5);  
            assertTrue("Snapshot should have a valid generation", cs.getGeneration() >= 0);  
        GatedCloseable<CatalogSnapshot> snapshotHold = engine.acquireSnapshot();  
        // deletion policy sees the updated GCP and deletes all older commits.
        }  
import org.opensearch.parquet.ParquetDataFormatPlugin;
        indexDocs(10, 10);
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("Only latest commit should remain", 1, commitCount(shard));
        ensureGreen(INDEX_NAME);  
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
        Set<String> filesBeforeMoreFlushes = listFiles(dataPath.resolve("index"));
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)  
        flush();  
        // Wait for GCP to catch up, then flush to trigger deletion policy
            assertTrue("File should survive due to snapshot hold: " + f, filesAfterFlushes.contains(f));
        long maxSeqNoBeforeRestart = getEngine(shard).getSeqNoStats(-1).getMaxSeqNo();
                    .put("index.composite.primary_data_format", "parquet")
import java.util.stream.Collectors;
    // ---- Test 6: Translog recovery after node restart ----
        indexDocs(10, 0);
            assertNotNull("Snapshot should have userData", cs.getUserData());
        assertEquals("Max seq no should reflect all 15 indexed docs", 14, maxSeqNoBeforeRestart);
        );
import org.opensearch.indices.IndicesService;
        ensureGreen(INDEX_NAME);  
import org.opensearch.cluster.metadata.IndexMetadata;
        }
            } catch (IOException e) {
        assertBusy(() -> assertEquals(shard.getLocalCheckpoint(), shard.getLastSyncedGlobalCheckpoint()));  
        String nodeNameResolved = getClusterState().nodes().get(nodeName).getName();  
    @Override
        indexDocs(10, 20);  
        flush();  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.IndexService;  
    public void testTranslogRecoveryAfterNodeRestart() throws Exception {
        // Get the max seq no before restart — should be 14 (0-indexed, 15 docs total)
        indexDocs(10, 0);
    private void indexDocs(int count, int startId) {  
            DataFusionPlugin.class  
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, nodeNameResolved);
        assertEquals(RestStatus.OK, flushResponse.getStatus());
        client().admin().indices().prepareOpen(INDEX_NAME).get();
        // Wait for it to catch up to local checkpoint, then flush once more so the  
/*  
    }  
        flush();
            CatalogSnapshot cs = snapshot.get();
        flush();
        IndexShard shard = getPrimaryShard();
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
            assertEquals(RestStatus.CREATED, client().prepareIndex().setIndex(INDEX_NAME).setSource("field", i).get().status());
 */  
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex(INDEX_NAME));
                return c.getUserData().get(CatalogSnapshot.CATALOG_SNAPSHOT_ID);  
        // Create more commits  
        // After GCP advances and old commits are deleted:  
        // Only latest commits should remain (safe + last, which may be the same)
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertNotNull(commitStats);
                throw new RuntimeException(e);
            CompositeDataFormatPlugin.class,
    }  
        flush();  
    private int commitCount(IndexShard shard) throws IOException {
import org.opensearch.test.OpenSearchIntegTestCase;
import java.nio.file.Path;
    }
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;  
package org.opensearch.composite;
        indexDocs(10, 10);
        // Acquire snapshot — holds a ref on the current catalog snapshot
        // Index more and flush multiple times  
import org.opensearch.be.datafusion.DataFusionPlugin;
        assertBusy(() -> assertEquals(shard.getLocalCheckpoint(), shard.getLastSyncedGlobalCheckpoint()));
        indexDocs(10, 10);  
        indexDocs(10, 0);
    }
/**
import java.util.Collection;
    }
            assertNotNull(cs);
        internalCluster().restartRandomDataNode();
        for (String f : filesBeforeMoreFlushes) {
        indexDocs(5, 15);
        CommitStats finalStats = getEngine(getPrimaryShard()).commitStats();
import org.opensearch.index.shard.IndexShard;
        flush();
        List<IndexCommit> commits = DirectoryReader.listCommits(shard.store().directory());  
                    .put("index.pluggable.dataformat", "composite")  
    }
import org.opensearch.common.util.FeatureFlags;
        }  
        ensureGreen(INDEX_NAME);
 * compatible open source license.
        IndexShard shard = getPrimaryShard();
            assertTrue("Generation should advance after flush", cs.getGeneration() > gen1);
        // Verify max seq no is preserved (translog replayed all ops)
        Path indexDir = dataPath.resolve("index");
    }
                Settings.builder()
        Path dataPath = shard.shardPath().getDataPath();  
import org.apache.lucene.index.DirectoryReader;
        Set<String> luceneFilesAfterCS1 = listFiles(indexDir);  
            .setMapping("field", "type=integer")
            .get();
    private FlushResponse flush() {  
        createCompositeIndex();
        IndexShard shard = getPrimaryShard();  
        assertNotNull("Commit should have max_seq_no", maxSeqNoStr);
            .setSettings(
        Set<String> luceneFilesNow = listFiles(indexDir);
        // Index more docs WITHOUT flushing — these live only in translog
        try (GatedCloseable<CatalogSnapshot> snapshot = engine.acquireSnapshot()) {  
    // ---- Test 3: Snapshot prevents file deletion ----
import org.apache.lucene.index.IndexCommit;
                    .put("index.pluggable.dataformat.enabled", true)
 * Integration tests for commit deletion behavior in DataFormatAwareEngine  
        // After recovery, flush to materialize all docs
        DataFormatAwareEngine engine = getEngine(shard);
        assertBusy(() -> assertEquals(shard.getLocalCheckpoint(), shard.getLastSyncedGlobalCheckpoint()));
        flush();  
        flush();  
        IndexShard shardAfter = getPrimaryShard();  
        assertFalse("Lucene files should still exist", luceneFilesNow.isEmpty());
        CommitStats commitStats = getEngine(shard).commitStats();
        indexDocs(5, 20);  
        // Engine should recover cleanly
    }  
        return Settings.builder()  
        Path dataPath = shard.shardPath().getDataPath();  
        // Files from the held snapshot should still exist (snapshot hold prevents deletion)  
        String nodeName = getClusterState().routingTable().index(INDEX_NAME).shard(0).primaryShard().currentNodeId();
import org.opensearch.plugins.Plugin;  
import java.util.stream.Stream;  
        try (Stream<Path> stream = Files.list(dir)) {  
        flush();  
    private static final String INDEX_NAME = "test-commit-deletion";  
            LucenePlugin.class,
        assertFalse("Lucene files should exist after flush", luceneFilesAfterCS1.isEmpty());
        flush();
            CatalogSnapshot cs = snapshot.get();
        }
        assertEquals(19, Long.parseLong(finalStats.getUserData().get(SequenceNumbers.MAX_SEQ_NO)));
import org.opensearch.action.admin.indices.flush.FlushResponse;  
        indexDocs(10, 0);  
        flush();  
import java.util.Set;
import java.nio.file.Files;
        if (!Files.exists(dir)) return Set.of();
    }
        indexDocs(10, 10);  
    private IndexShard getPrimaryShard() {
        // Close and reopen — simulates recovery
        IndexShard shard = getPrimaryShard();
        flush();  
        // Index docs and flush to establish a base commit
        flush();
import java.util.List;
        assertEquals("Max seq no should survive restart", 14, Long.parseLong(maxSeqNoStr));
    }
        assertTrue(commitStats.getGeneration() > 0);  
        flush();
        client().admin()
    private void createCompositeIndex() {  
        CommitStats commitStats = getEngine(shardAfter).commitStats();
public class CompositeCommitDeletionIT extends OpenSearchIntegTestCase {
import java.io.IOException;  
        flush();
    // ---- Test 4: acquireSnapshot returns latest state ----  
 */
        flush();
