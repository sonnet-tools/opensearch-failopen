        flush();
        CommitStats commitStats = getEngine(shardAfter).commitStats();
        flush();
        assertEquals("Only latest commit remains", 1, commitCount(shard));
        client().admin()
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        // Close and reopen — simulates recovery
        flush();
        }
        createCompositeIndex();
import java.nio.file.Path;
import java.nio.file.Files;
        return Arrays.asList(
import org.opensearch.test.OpenSearchIntegTestCase;
    public void testAcquireSnapshotReturnsLatestState() throws Exception {
        flush();
        indexDocs(5, 30);
            if (f.startsWith("segments_") || f.equals("write.lock")) continue;
    private DataFormatAwareEngine getEngine(IndexShard shard) {
        // Index more docs WITHOUT flushing — these live only in translog
                Settings.builder()
        // Engine should recover cleanly
        assertBusy(() -> assertEquals(shard.getLocalCheckpoint(), shard.getLastSyncedGlobalCheckpoint()));
            .get();
        indexDocs(10, 10);
        createCompositeIndex();
            ArrowBasePlugin.class,
        flush();
        if (!Files.exists(dir)) return Set.of();
        }).filter(Objects::nonNull).distinct().count();
        indexDocs(10, 0);
        flush();
        flush();
    }
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        }
        assertEquals("Old commits should be cleaned after release", 1, commitCount(shard));
        DataFormatAwareEngine engine = getEngine(shard);
    @Override
    private int commitCount(IndexShard shard) throws IOException {
import java.util.Collection;
        client().admin().indices().prepareClose(INDEX_NAME).get();
            try {
        indexDocs(10, 0);
        assertEquals("Max seq no should survive restart", 14, Long.parseLong(maxSeqNoStr));
            )
        // After more indexing + flush, new snapshot should reflect new state
            assertTrue("File should survive due to snapshot hold: " + f, filesAfterFlushes.contains(f));
        return indexService.getShard(0);
        IndexShard shard = getPrimaryShard();
            } catch (IOException e) {
        assertNotNull(getEngine(shard).commitStats());
    }
        indexDocs(5, 15);
        ensureGreen(INDEX_NAME);
import java.io.IOException;
    }
    // ---- Test 1: Old commit files deleted after flush ----
            ParquetDataFormatPlugin.class,
        assertEquals("Only latest commit should remain", 1, commitCount(shard));
        flush();
        assertEquals(19, Long.parseLong(finalStats.getUserData().get(SequenceNumbers.MAX_SEQ_NO)));
    }
        flush();
/*
        GatedCloseable<CatalogSnapshot> snapshotHold = engine.acquireSnapshot();
import org.apache.lucene.index.IndexCommit;
        CommitStats commitStats = getEngine(shard).commitStats();
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        client().admin().indices().prepareOpen(INDEX_NAME).get();
        ensureGreen(INDEX_NAME);
        Path dataPath = shard.shardPath().getDataPath();
            gen1 = cs.getGeneration();
        String nodeName = getClusterState().routingTable().index(INDEX_NAME).shard(0).primaryShard().currentNodeId();
        // Verify max seq no is preserved (translog replayed all ops)
        // Acquire snapshot — holds a ref on the current catalog snapshot
import org.opensearch.parquet.ParquetDataFormatPlugin;
import java.util.List;
    @Override
import org.opensearch.common.util.FeatureFlags;
    }
        // Files from the held snapshot should still exist (snapshot hold prevents deletion)
import org.opensearch.be.datafusion.DataFusionPlugin;
import org.opensearch.index.engine.DataFormatAwareEngine;
        // Verify engine is functional after recovery
import java.util.Objects;
        flush();
        indexDocs(10, 5);
        try (Stream<Path> stream = Files.list(dir)) {
 * with composite (Lucene + Parquet) data format.
        assertNotNull("Commit should have max_seq_no", maxSeqNoStr);
    private FlushResponse flush() {
        flush();
                    .put("index.composite.primary_data_format", "parquet")
        String nodeNameResolved = getClusterState().nodes().get(nodeName).getName();
    public void testRecoveryAfterCloseReopen() throws Exception {
        indexDocs(10, 10);
import java.util.Set;
        IndexShard shard = getPrimaryShard();
package org.opensearch.composite;
        indexDocs(10, 0);
import org.opensearch.cluster.metadata.IndexMetadata;
        Path indexDir = dataPath.resolve("index");
        try (GatedCloseable<CatalogSnapshot> snapshot = engine.acquireSnapshot()) {
        Set<String> luceneFilesNow = listFiles(indexDir);
            DataFusionPlugin.class
    // ---- Test 6: Translog recovery after node restart ----
 * SPDX-License-Identifier: Apache-2.0
        flush();
    public void testTranslogRecoveryAfterNodeRestart() throws Exception {
        createCompositeIndex();
    }
        internalCluster().restartRandomDataNode();
        createCompositeIndex();
        flush();
            assertNotNull(cs);
import org.opensearch.arrow.allocator.ArrowBasePlugin;
                    .put("index.pluggable.dataformat", "composite")
        IndexShard shardAfter = getPrimaryShard();
    public void testOldCommitDeletedAfterFlush() throws Exception {
        IndexShard shard = getPrimaryShard();
    private IndexShard getPrimaryShard() {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        // Get the max seq no before restart — should be 14 (0-indexed, 15 docs total)
import org.opensearch.index.shard.IndexShardTestCase;
            assertNotNull("Snapshot should have userData", cs.getUserData());
    }
/**
    }
    // ---- Test 4: acquireSnapshot returns latest state ----
    }
        // Index more and flush multiple times
        // Wait for GCP to catch up, then flush to trigger deletion policy
import org.opensearch.index.engine.CommitStats;
    // ---- Test 3: Snapshot prevents file deletion ----
        indexDocs(10, 10);
        flush();
    private void indexDocs(int count, int startId) {
        snapshotHold.close();
import org.opensearch.index.shard.IndexShard;
        // Create more commits
        CommitStats finalStats = getEngine(getPrimaryShard()).commitStats();
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
    }
        indexDocs(10, 20);
        indexDocs(10, 10);
            .put(super.nodeSettings(nodeOrdinal))
    }
    // ---- Test 5: Multi-format file cleanup ----
 *
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
        // Wait for it to catch up to local checkpoint, then flush once more so the
import org.opensearch.indices.IndicesService;
 * compatible open source license.
            assertTrue("Snapshot should have a valid generation", cs.getGeneration() >= 0);
        // GCP is advanced asynchronously via the global checkpoint sync action.
        return (int) commits.stream().map(c -> {
            .prepareCreate(INDEX_NAME)
import org.opensearch.be.lucene.LucenePlugin;
        DataFormatAwareEngine engine = getEngine(shard);
        indexDocs(10, 10);
        long maxSeqNoBeforeRestart = getEngine(shard).getSeqNoStats(-1).getMaxSeqNo();
import org.opensearch.common.settings.Settings;
        indexDocs(10, 0);
            return stream.map(p -> p.getFileName().toString()).collect(Collectors.toSet());
            .indices()
        IndexShard shard = getPrimaryShard();
        assertNotNull(commitStats);
    public void testMultiFormatFilesCleanedUpOnDeletion() throws Exception {
            assertEquals(RestStatus.CREATED, client().prepareIndex().setIndex(INDEX_NAME).setSource("field", i).get().status());
import java.util.stream.Collectors;
    private void createCompositeIndex() {
        indexDocs(10, 0);
                return c.getUserData().get(CatalogSnapshot.CATALOG_SNAPSHOT_ID);
        createCompositeIndex();
    private static final String INDEX_NAME = "test-commit-deletion";
        // Only latest commits should remain (safe + last, which may be the same)
        for (String f : filesBeforeMoreFlushes) {
        flush();
import org.opensearch.index.IndexService;
        indexDocs(5, 20);
        try (GatedCloseable<CatalogSnapshot> snapshot = engine.acquireSnapshot()) {
            assertTrue("Generation should advance after flush", cs.getGeneration() > gen1);
    }
        flush();
 * Integration tests for commit deletion behavior in DataFormatAwareEngine
        assertTrue(commitStats.getGeneration() > 0);
    }
}
                throw new RuntimeException(e);
            CatalogSnapshot cs = snapshot.get();
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.plugins.Plugin;
        String maxSeqNoStr = commitStats.getUserData().get(SequenceNumbers.MAX_SEQ_NO);
        }
        flush();
        flush();
            .setMapping("field", "type=integer")
        // Release snapshot
        Set<String> filesBeforeMoreFlushes = listFiles(dataPath.resolve("index"));
        IndexShard shard = getPrimaryShard();
        indexDocs(10, 20);
        ensureGreen(INDEX_NAME);
        flush();
        // After recovery, flush to materialize all docs
import org.opensearch.index.seqno.SequenceNumbers;
        IndexShard shard = getPrimaryShard();
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, nodeNameResolved);
import org.opensearch.core.rest.RestStatus;
        return (DataFormatAwareEngine) IndexShardTestCase.getIndexer(shard);
        assertBusy(() -> assertEquals(shard.getLocalCheckpoint(), shard.getLastSyncedGlobalCheckpoint()));
        // Index docs and flush to establish a base commit
public class CompositeCommitDeletionIT extends OpenSearchIntegTestCase {
        assertEquals(RestStatus.OK, flushResponse.getStatus());
        // Restart the node — translog replay should recover unflushed docs
        // Verify we can still index and flush
 * The OpenSearch Contributors require contributions made to
        flush();
    protected Settings nodeSettings(int nodeOrdinal) {
        assertBusy(() -> assertEquals(shard.getLocalCheckpoint(), shard.getLastSyncedGlobalCheckpoint()));
            }
        for (int i = startId; i < startId + count; i++) {
 */
        }
        assertFalse("Lucene files should exist after flush", luceneFilesAfterCS1.isEmpty());
    }
                    .put("index.pluggable.dataformat.enabled", true)
    public void testAcquireSnapshotPreventsFileDeletion() throws Exception {
        long gen1;
        return client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).setWaitIfOngoing(true).get();
import org.opensearch.action.admin.indices.flush.FlushResponse;
            CompositeDataFormatPlugin.class,
        FlushResponse flushResponse = flush();
    }
        Set<String> filesAfterFlushes = listFiles(dataPath.resolve("index"));
    private Set<String> listFiles(Path dir) throws IOException {
        Set<String> luceneFilesAfterCS1 = listFiles(indexDir);
            LucenePlugin.class,
import java.util.stream.Stream;
        // deletion policy sees the updated GCP and deletes all older commits.
        }
    // ---- Test 2: Recovery after close/reopen ----
        // After GCP advances and old commits are deleted:
        return Settings.builder()
import org.apache.lucene.index.DirectoryReader;
 */
        );
            .build();
import org.opensearch.common.concurrent.GatedCloseable;
            .setSettings(
        assertNotNull(commitStats);
        indexDocs(5, 0);
        // Flush again to trigger cleanup
        Path dataPath = shard.shardPath().getDataPath();
        List<IndexCommit> commits = DirectoryReader.listCommits(shard.store().directory());
        indexDocs(10, 20);
import java.util.Arrays;
        assertFalse("Lucene files should still exist", luceneFilesNow.isEmpty());
            CatalogSnapshot cs = snapshot.get();
        createCompositeIndex();
        assertEquals("Max seq no should reflect all 15 indexed docs", 14, maxSeqNoBeforeRestart);
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex(INDEX_NAME));
                    .putList("index.composite.secondary_data_formats", "lucene")
