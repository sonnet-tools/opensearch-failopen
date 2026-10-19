        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName)).get());  
        // The DFA index itself should still be healthy (snapshot deletion does not affect index)
        final int numDocs = 10;
        final int initialDocs = 30;  
     * <p>Mirrors {@code ConcurrentSnapshotsV2IT.testCreateSnapshotFailInFinalize} but adds
        SnapshotInfo info1 = createSnapshot(snapshotRepoName, snap1, new ArrayList<>());
        final int numShards = 3;  
import org.opensearch.be.lucene.LucenePlugin;
        String snapshotRepoName = "test-rename-repo";
        indexDocuments(client, indexName, initialDocs, totalAtSnap2);
    public void testV2DeleteSnapshotCleansUpAllFormatFilesForDFA() throws Exception {  
     * <ol>
                .get()
        indexDocuments(client, indexName, 0, numDocs);
            .get()
            org.opensearch.snapshots.SnapshotRestoreException.class,
        expectThrows(org.opensearch.snapshots.SnapshotException.class, snapshotFuture::actionGet);  
        GetRepositoriesRequest gr = new GetRepositoriesRequest(new String[] { sourceRepository });  
    }  
            .setIndices(indexName)
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName)).get());
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
            String snapshotRepoName = "snap-repo-" + suffix;  
            // catalog file names may already be format-prefixed (e.g. "parquet/foo.parquet")  
     *
            org.opensearch.common.concurrent.GatedCloseable<org.opensearch.index.engine.exec.coord.CatalogSnapshot> ref = sourceShardAfter
            assertLuceneIndexDirContents(shard);  
        Set<String> filesBeforeSnapshot = captureShardFilesOnDisk(shardBefore);
     *   <li>Pinned-timestamp release for snap2 doesn't delete files still referenced by snap1</li>
    }  
     */
        }
     * V2 snapshot of a multi-shard DFA index. Validates that per-shard catalogs are  
        assertDocCountInIndex(client, indexName, totalDocs);  
        assertRestoredIndexMatches(client, renamedIndex, renamedShard, pre, /* requireSameUUID */ false);
        createIndex(sourceIndex, indexSettings);
            logger.info("--> restoring V2 snapshot for pathType={}", pathType);  
     * <strong>DFA-specific test:</strong> verify that ALL format directories ({@code segments/},  
        );  
        // Doc count must be EXACT
            .prepareGetSettings(restoredIndexName)
        ensureGreen(indexName);
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName)).get());
import org.opensearch.be.datafusion.DataFusionPlugin;  
     * <p>Validates that DFA's format-aware remote directory factory still resolves files
        indexDocuments(client, sourceIndex, 0, numDocs);
 * this file be licensed under the Apache-2.0 license or a
        createIndex(indexName, indexSettings);  
        indexDocuments(client, indexA, 0, numDocsA);  
        for (RemoteStoreEnums.PathType pathType : RemoteStoreEnums.PathType.values()) {  
        // a secondary format. For parquet-only configurations there are no Lucene segments  
        InterruptedException {
                    .get()
            .setIndices(indexName)
        // Phase 1: index N docs, take snap1
        Settings indexSettings = getIndexSettings(1, 0).build();  
        IndexShard shardBAfter = getShardZero(indexB);
     */
        Set<String> catalogAfter = DataFormatAwareITUtils.catalogFilesExcludingSegments(sourceShardAfter);
        String node = internalCluster().getDataNodeNames().iterator().next();
            .prepareCloneSnapshot(snapshotRepoName, sourceSnapshot, clonedSnapshot)  
     */
     * <p>The index is created and immediately snapshotted (no indexing, no flush). The snapshot  
                .getCatalogSnapshot()
            assertTrue("format directory must exist: " + format + " (" + dir + ")", Files.exists(dir));  
     */
     * at snapshot time. Mirrors {@code RestoreShallowSnapshotV2IT.testRestoreOperationsUsingDifferentRepos}.
        assertTrue("primary for shard " + shardId + " must be assigned", nodeId != null);
        ensureGreen(indexName);
        long[] count = { 0 };  
        // Original index uses 300s refresh
        assertDocCountInIndex(client, indexName, numDocs);
    }  
        // DFA layout intact for BOTH restored shards
        Set<String> filesAfterRestore = captureShardFilesOnDisk(shardAfter);
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
        assertEquals(0, restoreResponse.getRestoreInfo().failedShards());  
    }
        try (
        }
        long translogFilesBefore = countFilesUnder(remoteRepoPath, indexUUID, "translog");
    private void assertDocCountInIndex(Client client, String indexName, long expectedCount) {
    }
     * </ol>
import java.util.Set;
            .setRenameReplacement(renamedIndex)  
        indexDocuments(client, indexName, 0, numDocs);
    }  
     * cluster-manager metadata; deletion must release that pin and clean up metadata.
        String indexB = "dfa-multi-b";
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName)).get());
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName)).get());
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName)
        assertEquals(RestStatus.OK, restoreResponse.status());  
        // DFA layout intact  
    public void testV2DeleteSnapshotForDFA() throws Exception {
        assertEquals(RestStatus.OK, restoreResponse.status());
        Settings indexSettings = getIndexSettings(1, 0).build();  
            () -> client.admin()
        internalCluster().startDataAndWarmNodes(1);
        // DFA layout intact
                nonSegmentsFiles.isEmpty()
        }  
    /**
        return Settings.builder()  
        Settings indexSettings = getIndexSettings(1, 0).put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "300s").build();
        assertLuceneIndexDirContents(shardAfterDelete);  
        IndexShard restoredShard,  
        // Doc count restored — uses _stats API, NOT prepareSearch / prepareGet
        // Verify snapshot is no longer listed  
        Settings.Builder settingsBuilder = Settings.builder()  
        flush(indexName);
        // Delete the source index so we can attempt restore
     * <ul>  
        List<SnapshotInfo> snapshots = client.admin().cluster().prepareGetSnapshots(snapshotRepoName).get().getSnapshots();  
                    } else if (categoryDirName.equals(name)) {  
        } else {
     */  
            );
        assertTrue(
        IndexShard shardPreSnap1 = getShardZero(indexName);  
     * Two sequential V2 snapshots with intervening writes; both must be independently restorable.
        assertEquals(snapshotName, snapshotsBefore.get(0).snapshotId().getName());
        if (WRITABLE_WARM_INDEX_SETTING.get(settings)) {
        createIndex(indexName, getIndexSettings(1, 0).build());
    }
                LucenePlugin.class,
    /**
     * Resolve the node name hosting the primary of a given shard.  
        // Catalog file set unchanged (excluding segments_N which can change due to commit ops)  
            }  
            .cluster()
     * <p>Note: does not use prepareSearch or prepareGet because search is not yet supported
        assertTrue(
    public void testV2SnapshotWithMultipleShardsForDFA() throws Exception {
        assertAllFormatDirsHaveFiles(restoredShard);
     */
            .cluster()
            assertAllFormatDirsHaveFiles(shardAfter);
        // Create two DFA indices with distinct doc counts so we can detect data crossover  
        // Capture exhaustive pre-snapshot state for tight post-restore comparison  
        assertFalse("pre-snapshot index UUID must be non-empty", uuid.isEmpty());
        logger.info("--> taking V2 snapshot of source");
import org.opensearch.index.IndexModule;  
        // Pre-delete: remote store must have segment + translog files under the indexUUID subtree.
        internalCluster().startDataAndWarmNodes(1);  
        assertAcked(cloneResponse);  
import org.opensearch.cluster.metadata.RepositoryMetadata;
        // Verify writer_generation attribute survived restore
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;  
            () -> assertTrue(
            .cluster()  
     * Validates pinned-timestamp inheritance through clones.
            );
        if (iter.hasNext() == false) return 0;
        assertEquals(
        // Block finalization, fire snapshot, wait for block, then unblock to fail it  
    @Before  
        String indexName = "dfa-delete-snapshot";
        // For rename, the new UUID is also different. So in both cases the restored UUID must
                client().admin()  
        final int numDocs = 10;
            .prepareRestoreSnapshot(repoName, snap1)
    public void testV2HotDFASnapshotRestoreLifecycle() throws Exception {  
    /**
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
     * @param requireSameUUID true if the restored index keeps the original UUID (typical case);  
        assertThat(s2.state(), equalTo(SnapshotState.SUCCESS));
        createIndex(indexName, indexSettings);  
                stream.forEach(p -> all.add("index/" + p.getFileName()));
                + missingDataFiles
        logger.info("--> restoring V2 snapshot with overridden refresh_interval=5s");
        // Create alternate repos pointing at the SAME underlying paths (read-only views)  
        createIndex(indexName, indexSettings);
        assertNotNull("restored index UUID must be set", restoredUuid);
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName)
        indexDocuments(client, indexName, 0, numOfDocs);
        ensureGreen(indexName);
        indexDocuments(client, indexName, 0, numDocs);
     * indexing and is required by DFA to correlate Lucene segments with the corresponding  
        long sourceGen;
        IndexShard shardAfter = getShardZero(indexName);
        assertEquals(
            .cluster()
        internalCluster().startDataAndWarmNodes(1);  
import org.opensearch.common.settings.Settings;
        assertAllFormatDirsHaveFiles(shardAfter);  
        IndexShard shardBBefore = getShardZero(indexB);
    }  
        Settings.Builder settings = Settings.builder()
    }
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName)
    /**
        createRepository(drSegmentRepo, "fs", getRepositorySettings(BASE_REMOTE_REPO, true));  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            refresh(indexName);
        RestoreSnapshotResponse restoreResponse = client.admin()
        return settingsBuilder;
        createRepository(snapshotRepoName, "mock", settings);
                    }
            if (filesAfter.contains(catalogFile) == false && filesAfter.contains("index/" + catalogFile) == false) {
            .cluster()
                    + " pre-snapshot but is missing post-restore. post-restore segs: "
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardBBefore);
     * {@code translog/}, and any DFA-specific format dirs) are cleaned up after V2 snapshot
            catalogGen = ref.get().getGeneration();  
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardAfter);
        // Take V2 snapshot
            );  
            if (Files.exists(fmtDir)) {
        // Even an empty index has 1 shard reported
    protected void indexDocuments(Client client, String indexName, int fromId, int toId) {
            .put(super.nodeSettings(nodeOrdinal))
    protected Settings.Builder getRepositorySettings(Path location, boolean shallowCopyEnabled) {  
        assertEquals(RestStatus.OK, restoreResponse.status());
        assertDocCountInIndex(client, indexName, numDocs);
    public void testV2RestoreWithUpdatedSettingsForDFA() throws Exception {
     *   <li>Restored doc count matches</li>  
            .setWaitForCompletion(true)  
        );
        assertTrue(
            .get();
        }  
            .setSourceRemoteStoreRepository(drSegmentRepo)
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName, new ArrayList<>());
        if (indexSegs == null) return 0;
     */
        assertEquals("snap-retry-success", snapshots.get(0).snapshotId().getName());
     * Walk the entire {@code rootPath} subtree and count files whose path contains the given  
            String node = nodeNameForShard(restoredState, indexName, shardId);  
        // Use 'mock' repo type so the test framework can inject failures.  
                "pinned-timestamp scheduler should fire after invocation",  
        assertThat(snapInfo2.state(), equalTo(SnapshotState.SUCCESS));
                boolean hasUuid = false;  
        final int finalTotal = totalAtSnap2 + phase3Docs;
     * V2 snapshot of multiple DFA indices in a single snapshot, then restore all.
        Client client = client();
     * the indices list is empty, and each index's per-format catalog/files are independently
        logger.info("--> restoring from V2 snapshot");
     * and {@code translog/}; for DFA there could be additional format files that bug-prone  
import static org.opensearch.common.util.FeatureFlags.WRITABLE_WARM_INDEX_SETTING;
        internalCluster().startDataAndWarmNodes(1);
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
            .prepareGetSettings(indexName)
        int segs = countSegmentsOnShard(client, indexName);
     * returns no info for the index (e.g., shard not yet ready or special engine state).
     *   <li>Snapshot the now-larger index as {@code snap2}, delete, restore from {@code snap2}.</li>
        // ─── Verify retry: a subsequent V2 snapshot must succeed (repo state cleaned) ───  
        }
import static org.hamcrest.Matchers.equalTo;  
                + diff(restoredCatalog, pre.catalogFilesExcludingSegments),  
            .putList("index.composite.secondary_data_formats", getSecondaryDataFormats());  
     */
            String snapshotName = "snap-" + suffix;
                // Iterate path name elements rather than substring-matching the toString() — the latter
            String preGen = e.getValue();
        SnapshotInfo source = createSnapshot(snapshotRepoName, sourceSnapshot, new ArrayList<>());
            org.opensearch.snapshots.SnapshotRestoreException.class,
        RestoreSnapshotResponse restoreResponse = client.admin()
        internalCluster().startDataAndWarmNodes(2); // 2 data nodes so 3 shards distribute  
     */
        Settings changeTranslogRepo = Settings.builder().put(SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "different-translog-repo").build();
        final Set<String> catalogFilesExcludingSegments;  
        Set<String> all = new HashSet<>();
                    if (indexUUID.equals(name)) {
            "segment count must match pre-snapshot exactly: pre=" + pre.segmentCount + " post=" + restoredSegCount,
        int restoredSegCount = countSegmentsOnShard(client, restoredIndexName);
            .setIndices("*")
        );  
            "catalog files missing from restored shard disk: "  
            assertLuceneIndexDirContents(shardAfter);  
            assertEquals("translog/ subtree must be cleaned up for indexUUID=" + indexUUID, 0, translogCount);
        String snapshotRepoName = "test-snapshot-repo";
        String indexName = "dfa-clone-snapshot";
    public void testV2InvalidRestoreRequestForDFAIndex() throws Exception {
        remoteRepoPath = randomRepoPath().toAbsolutePath();
            .put(super.indexSettings())
        // Test all three path types in sequence.  
        );  
            .cluster()
        }  
        return settingsBuilder;
    private void keepPinnedTimestampSchedulerUpdated() throws Exception {
        internalCluster().startClusterManagerOnlyNode();  
     *   <li>Per-shard pinned-timestamp scoping issues</li>  
     * surface in the create/restore flow.
            }
        internalCluster().startDataAndWarmNodes(1);
        SnapshotInfo s2 = createSnapshot(repoName, snap2, new ArrayList<>());
    }  
            indexDocuments(client, indexName, 0, numDocs);
        assertEquals(0, restoreResponse.getRestoreInfo().failedShards());
            .setIndices(indexName)
                }
        ensureGreen(indexA, indexB);
    /**  
        assertEquals(RestStatus.OK, restoreResponse.status());
        assertEquals(  
        );
     * V2 snapshot + clone the snapshot + restore from clone for a DFA index.  
        // No documents indexed. Force a flush to materialize an empty commit point.  
                CompositeDataFormatPlugin.class,
        String uuid = client.admin().indices().prepareGetSettings(indexName).get().getSetting(indexName, IndexMetadata.SETTING_INDEX_UUID);
        refresh(indexName);
        String snapshotName = "test-v2-multi-snapshot";  
            if ("lucene".equals(format)) continue; // Lucene files live under shard/index/, not a separate dir
            .put(remoteStoreClusterSettings(BASE_REMOTE_REPO, remoteRepoPath))
        createIndex(indexA, indexSettings);  
        String snapshotRepoName = "test-empty-repo";
     * this to add lucene as a secondary format.
            }
        refresh(indexName);
        // (a) be set, (b) differ from the pre-snapshot source UUID.
        );
     * <p>Snapshot V2 assertions:  
        long genAfter;
import java.util.Map;
                .cluster()
            files = stream.map(p -> p.getFileName().toString()).collect(java.util.stream.Collectors.toSet());
    /**
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
        // EVERY restored shard must have intact DFA layout — catches per-shard corruption  
        // Create snapshot repo with V2 enabled
            .cluster()
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardAfterPhase2);
        for (String format : expectedFormats()) {
        assertRestoredIndexMatches(client, indexName, shardAfter, pre, /* requireSameUUID */ true);
        internalCluster().startClusterManagerOnlyNode();  
            .get();
     *   <li>Doc count via _stats matches what was indexed</li>
        assertEquals("status doneShards must be 1", 1, status.getShardsStats().getDoneShards());
        assertTrue("status must contain the DFA index, got: " + status.getIndices().keySet(), status.getIndices().containsKey(indexName));  
        String indexA = "dfa-multi-a";  
     * <p>Pre-snapshot assertions:
        );  
        Settings indexSettings = getIndexSettings(1, 0).build();
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
    /**
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName, new ArrayList<>());
                .setIndices(indexName)
        // Post-restore #2 validations — must reflect snap2 (totalAtSnap2 docs)  
        // ── Delete and restore from snap2 (the LATER snapshot, larger doc set) ─
        PreSnapshotState pre,
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
     *   <li>Snapshot creation succeeds</li>
            ensureGreen(indexName);  
    public void testV2ConcurrentSnapshotsForDFA() throws Exception {
import java.util.Arrays;
        assertTrue(
     * leaking into index B's restore).
        awaitNumberOfSnapshotsInProgress(1);
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardPreSnap1);
import org.junit.After;
        r.removeAll(b);  
     * DR scenario: V2 snapshot a DFA index, delete the original index, then restore using
        final int numDocs = 10;  
        assertEquals(numShards, restoreResponse.getRestoreInfo().successfulShards());
        // Catalog must match what's on local disk and what was uploaded to remote
            .setWaitForCompletion(true)  
import org.opensearch.index.IndexSettings;
            .setIgnoreIndexSettings(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey())
        SnapshotInfo info2 = createSnapshot(snapshotRepoName, snap2, new ArrayList<>());
        logger.info("--> taking V2 snapshot of empty DFA index");
        AcknowledgedResponse deleteResponse = client.admin().cluster().prepareDeleteSnapshot(snapshotRepoName, snapshotName).get();
        // ─── Post-restore assertions ───────────────────────────────────────  
        createIndex(indexName, indexSettings);
        // no per-shard SnapshotShardsService dispatch)
     * Mirrors {@code DeleteSnapshotV2IT.keepPinnedTimestampSchedulerUpdated} but uses
        assertTrue("segment files must exist for index " + indexUUID + " before delete, got " + segmentFilesBefore, segmentFilesBefore > 0);
        RestoreSnapshotResponse restore1 = client.admin()  
     * the restored shard's disk. Validates the restore actually reconstructed the data files,  
        // Index a meaningful number of docs so each shard gets some  
        logger.info("--> restoring V2 snap2");
        assertAllFormatDirsHaveFiles(sourceShardAfter);
import java.nio.file.Files;
        Set<String> catalogFiles = DataFormatAwareITUtils.catalogFilesExcludingSegments(shard);  
        ).collect(Collectors.toList());
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName, new ArrayList<>());  
        Path indexDir = shard.shardPath().resolveIndex();
    }
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
                .getCatalogSnapshot()
        String snapshotRepoName = "test-snapshot-repo";
            pre.catalogFilesExcludingSegments,
    }
    }  
        Client client = client();  
import org.junit.Before;
        RestoreSnapshotResponse r2 = client.admin()  
        }
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));  
        IndexShard restoredShard = getShardZero(indexName);
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        ensureGreen(indexName);  
            String node = nodeNameForShard(clusterState, indexName, shardId);
import org.opensearch.arrow.allocator.ArrowBasePlugin;
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName)).get());
     * Two V2 snapshots fired in rapid sequence on the same repository. V2 design serializes
import org.opensearch.node.Node;  
            10,  
            .setIndices(indexName)
            assertTrue(
     * <p>Mirrors {@code RestoreShallowSnapshotV2IT.testInvalidRestoreRequestScenarios} but exercises
        Path absolutePath1 = randomRepoPath().toAbsolutePath();  
     *
        assertLuceneIndexDirContents(shardBefore);  
    /**
    }  
     * Assert the Lucene index/ directory contents match the configured layout:
        // 3 batches × refresh+flush → multiple segments with distinct writer_generations
    /**
        final int segmentCount;
        final int totalAtSnap2 = initialDocs + phase2Docs;  
        // Tight validation: renamed index gets a NEW UUID but matches source on docs/segments/catalog
            .setIndices(indexA, indexB)  
    public void testV2RestoreWithRenameForDFA() throws Exception {  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numOfReplicas)  
            .setWaitForCompletion(true)  
            Client client = client();
import java.util.List;  
            public java.nio.file.FileVisitResult visitFileFailed(Path file, IOException exc) {
     * Search isn't supported on DFA indices yet, so we avoid prepareSearch / prepareGet.
        return Stream.concat(
     * underlying file paths (read-only views).  
            "DFA catalog files must be unchanged after failed V2 snapshot finalize: missing="  
            translogFilesBefore > 0
        // ─── DFA-specific: verify source index was NOT corrupted by the failure ───
            restoredGen >= pre.catalogGeneration  
     * stamped by {@link org.opensearch.be.lucene.index.LuceneWriterCodec} during initial
        assertThat("snap1 state", info1.state(), equalTo(SnapshotState.SUCCESS));
        String snapshotName = "snap-cleanup";
        );
            refresh(indexName);
        // ─── Invalid request 3: try to change translog.repository ───
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
                + "\n  before: "
        ensureGreen(indexName);
            .setIndices(sourceIndex)
        flush(indexName); // Force a commit so catalog snapshot reflects on-disk state
        assertDocCountInIndex(client, indexName, docsBeforeSnap1);  
        List<SnapshotInfo> snapshots = client.admin().cluster().prepareGetSnapshots(snapshotRepoName).get().getSnapshots();  
     */
        logger.info("--> taking back-to-back V2 snapshots");  
        return List.of("lucene");
    /** Capture exhaustive pre-snapshot state for tight post-restore comparison. */
                    count[0]++;
        // Every pre-snapshot segment with writer_generation must STILL have it after restore.
            .get();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY;
            assertEquals("writer_generation must be preserved across V2 snapshot/restore for segment " + segName, preGen, postGen);
        // Delete the snapshot
     *   <li>Snapshot state == SUCCESS, all shards successful (cluster-manager-only flow)</li>
                .setWaitForCompletion(true)
     * DFA index are rejected cleanly with {@link org.opensearch.snapshots.SnapshotRestoreException}
        // Single-shard index — exact assertions
                .setIndices(indexName)  
            .filter(f -> f.startsWith("segments_") == false && f.equals("write.lock") == false)  
import java.io.IOException;
                .setIndexSettings(changeTranslogRepo)
        // Catalog generation must be >= pre-snapshot generation (restore may bump it)
        assertEquals(
        assertFalse("restored index UUID must be non-empty", restoredUuid.isEmpty());  
        // Capture pre-snapshot state for tight post-restore validation
        assertTrue("pre-snapshot catalog generation must be > 0, got " + catalogGen, catalogGen > 0L);
        createIndex(indexName, indexSettings);  
        Settings indexSettings = getIndexSettings(1, 0).build();  
     * be at least the pre-snapshot value (restore may bump it during finalize); and DFA on-disk  
     */  
            client.prepareIndex(indexName).setSource("text", "sometext").get();
        assertEquals(0, snapshotInfo.failedShards());  
        assertEquals(0, restoreResponse.getRestoreInfo().failedShards());
        assertEquals(0, restoreResponse.getRestoreInfo().failedShards());
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName)
    /**  
     *   <li>Restored index reaches green health</li>
     */  
     *   <li>Catalog files match local store and remote store on the restored shard</li>
        }
        String snapshotRepoName = "test-rapid-repo";
    public void testV2SnapshotPreservesWriterGenerationAttributeForDFA() throws Exception {
        ensureGreen(indexName);
        // Catalog generation must be at least pre-failure (commit may have advanced it slightly during failure handling)
import org.opensearch.parquet.ParquetDataFormatPlugin;
        refresh(indexName);
                .setWaitForCompletion(true)
import org.opensearch.core.common.unit.ByteSizeValue;  
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));  
            createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath, true));
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
     */  
                "segment "  
        ) {
        // The writer_generation attribute is stamped by LuceneWriterCodec only when Lucene is
        final int numDocsA = 7;
                .get()
     *
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));  
        logger.info("--> taking V2 snapshot for DR test");
            restoredCatalog
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName)).get());  
        long segmentFilesBefore = countFilesUnder(remoteRepoPath, indexUUID, "segments");  
            this.segmentCount = segmentCount;  
import org.opensearch.snapshots.SnapshotInfo;  
        );
            .cluster()
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardFinal);
        IndexShard restoredShard = getShardZero(indexName);  
        );  
        ensureGreen(indexName);
    }
                .setIndices(indexName)
        assertLuceneIndexDirContents(shardAAfter);
        String snapshotRepoName = "test-status-repo";
        // Delete the original index  
public class DataFormatAwareRestoreShallowSnapshotV2IT extends AbstractSnapshotIntegTestCase {  
     * Get the IndexShard for shard 0 of the index on the first data node in the cluster.
        IndexShard shardAAfter = getShardZero(indexA);  
        logger.info("--> restoring with rename: {} -> {}", sourceIndex, renamedIndex);
        }
        assertAllFormatDirsHaveFiles(shardAfter);  
     *   <li>The snapshot is no longer listed after deletion</li>
            Path absolutePath = randomRepoPath().toAbsolutePath();
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexA, indexB)).get());
        String indexName = "dfa-writergen-attr";
        internalCluster().startClusterManagerOnlyNode();
            flush(indexName);  
        // Verify the catalog files from before the snapshot are reconstructed on the restored shard's disk  
    }  
        assertEquals(RestStatus.OK, restore2.status());  
     */
     *   <li>All format directories (parquet, lucene index/) exist with expected files</li>
        // Delete and restore with overridden refresh_interval = 5s  
        IndexShard shardAfter = getShardZero(indexName);  
    private IndexShard getShardZero(String indexName) {  
        // V2 snapshot must contain BOTH indices  
        flush(indexName);
        assertEquals("retry snapshot must include exactly the DFA index", List.of(indexName), retryInfo.indices());  
    /**
                missing.add(catalogFile);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        );  
            if ("lucene".equals(format)) continue;  
        assertFalse(indexExists(indexName));
            long translogCount = countFilesUnder(remoteRepoPath, indexUUID, "translog");
        assertDocCountInIndex(client, indexB, numDocsB);
     *
            .cluster()
        assertAllFormatDirsHaveFiles(shardAfter);
                return java.nio.file.FileVisitResult.CONTINUE;
            .prepareStats(indexName)
        refresh(indexName);  
            assertEquals("pathType=" + pathType + " single-shard exactly 1 successful", 1, snapshotInfo.successfulShards());
    public void testV2SnapshotFailInFinalizeDoesNotCorruptDFAState() throws Exception {
            @Override
            missing.isEmpty()  
        Path repoPath = randomRepoPath().toAbsolutePath();  
     * because remote-store cleanup is async and timing-sensitive).
        assertAllFormatDirsHaveFiles(shardR2);
            .prepareRestoreSnapshot(drSnapshotRepo, snapshotName)
        assertEquals("snapshot total shards must equal successful shards", snapshotInfo.successfulShards(), snapshotInfo.totalShards());
            .get()  
        String snapshotRepoName = "test-cleanup-repo";
     */  
            IndexShard shard = getIndexShard(node, new ShardId(resolveIndex(indexName), shardId), indexName);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY;
    public DataFormatAwareRestoreShallowSnapshotV2IT(Settings nodeSettings) {
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName, new ArrayList<>());
    @Override  
     * </ul>
        ensureGreen(indexName);
        assertLuceneIndexDirContents(restoredShard);
        String drTranslogRepo = "dr-translog-repo";
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName, new ArrayList<>());  
            "catalog generation must be >= pre-failure generation: pre=" + preState.catalogGeneration + " post=" + genAfter,
        SnapshotInfo s1 = createSnapshot(repoName, snap1, new ArrayList<>());
        Settings indexSettings = getIndexSettings(1, 0).build();
        Client client = client();
        // Phase 2: index M more docs, take snap2  
    /**
        ) {  
            IndexShard shardAfter = getShardZero(indexName);
        String snapshotRepoName = "test-writergen-repo";  
        assertFalse(indexExists(indexName));
        indexDocuments(client, indexName, 0, initialDocs);
        refresh(indexName);
        final int totalDocs = docsBeforeSnap1 + docsAfterSnap1;
        // Renamed index must exist and have all docs; original is unchanged  
        Settings indexSettings = getIndexSettings(1, 0).build();  
        // Verify both snapshots exist in the repo
            .setWaitForCompletion(true)  
        String indexName = "dfa-cleanup-index";  
            .setIndices(indexName)
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName)).get());
            .setWaitForCompletion(true)
            "data files from snapshot must be restored to disk; missing: "  
    public void testV2CloneSnapshotForDFA() throws Exception {
            .get();
        assertAcked(client().admin().indices().prepareDelete(indexName));
     * </ul>  
    }  
            .clear()
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardR1);  
            var nodes = internalCluster().getDataNodeInstances(Node.class);
     *   <li>parquet+lucene-secondary: index/ has segments_N + at least one segment data file</li>
        ensureGreen(renamedIndex);
        ensureGreen(indexName);
            for (var node : nodes) {
                .prepareRestoreSnapshot(snapshotRepoName, snapshotName)
        assertFalse("invalid restore must NOT partially create the index", indexExists(indexName));  
        String snapshotRepoName = "test-snapshot-repo";
     *   <li>After second restore: validate everything again, ingest more, refresh, validate.</li>  
        assertEquals(RestStatus.OK, r2.status());  
        String snapshotRepoName = "test-clone-gen-repo";
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName, new ArrayList<>());  
            .setIndices(indexName)
     * <ul>  
        Set<String> missingDataFiles = new HashSet<>();
    private int countSegmentsOnShard(Client client, String indexName) {
        assertTrue(  
    }
        // Total doc count must match  
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)  
    public void testV2CloneSnapshotPreservesCatalogGenerationForDFA() throws Exception {  
        indexDocuments(client, indexName, docsBeforeSnap1, totalDocs);  
        assertDocCountInIndex(client, indexName, numDocs);
        Path absolutePath1 = randomRepoPath().toAbsolutePath();  
        RestoreSnapshotResponse restoreResponse = client.admin()  
     * format mapping.
        IndexShard shardAfter = getShardZero(indexName);
        RestoreSnapshotResponse restoreResponse = client.admin()
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));  
            restoredGen >= sourceGen
        internalCluster().startClusterManagerOnlyNode();
            ex1.getMessage().toLowerCase(java.util.Locale.ROOT).contains("remote_store")  
        }
            assertFalse("pathType=" + pathType, indexExists(indexName));
     * V2 restore with rename pattern — the snapshot was taken on {@code source-idx} but the
        logger.info("--> restoring multi-shard V2 snapshot");
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        // Wait for cleanup to drain ALL format directories to zero for this index UUID.
            this.indexUUID = indexUUID;  
    /**
        SnapshotInfo retryInfo = createSnapshot(snapshotRepoName, "snap-retry-success", new ArrayList<>());
        internalCluster().startClusterManagerOnlyNode();
        // for DFA's per-format file lifecycle.
            .setWaitForCompletion(true)
            .setIndices(indexName)
        internalCluster().startDataAndWarmNodes(1);
        Settings changeSegmentRepo = Settings.builder().put(SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "different-repo").build();
        flush(indexName);
            flush(indexName);  
                + diff(catalogAfter, preState.catalogFilesExcludingSegments),  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numOfShards)
        // ─── Invalid request 2: try to change segment.repository ───  
        assertFalse(indexExists(indexB));
            .setIndices(indexName)
            "restored catalog generation must be >= pre-snapshot: pre=" + pre.catalogGeneration + " post=" + restoredGen,
            .cluster()  
            assertDocCountInIndex(client, indexName, numDocs);
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
        assertEquals(RestStatus.OK, restoreResponse.status());
        try (var stream = Files.list(indexDir)) {
        // delete the repo between iterations.
        SnapshotInfo source = createSnapshot(snapshotRepoName, sourceSnapshot, new ArrayList<>());
            "catalog file set must match pre-snapshot exactly: missing="  
        // Ingest yet more, refresh, validate — proves indexing still works after second restore  
        for (String catalogFile : catalogBefore) {
        flush(sourceIndex);
     * Asserts the catalog files (excluding segments_N) before snapshot are all present on
            "translog files must exist for index " + indexUUID + " before delete, got " + translogFilesBefore,
        internalCluster().startDataAndWarmNodes(1);
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName)).get());
        final int numDocsB = 13;
        createIndex(indexName, indexSettings);
                .getCatalogSnapshot()
        ) {
        AcknowledgedResponse cloneResponse = client.admin()
            .get()
        assertThat(source.state(), equalTo(SnapshotState.SUCCESS));
        assertDocCountInIndex(client, indexName, totalAtSnap2);
     * Return number of segments on the primary of shard 0. Returns 0 if the segments API
            org.opensearch.common.concurrent.GatedCloseable<org.opensearch.index.engine.exec.coord.CatalogSnapshot> ref = shard  
     * Path-type-agnostic: works with FIXED, HASHED_PREFIX, and HASHED_INFIX layouts.
     *  
    /**
        for (int shardId = 0; shardId < numShards; shardId++) {
            restoreResponse.getRestoreInfo().successfulShards()
    }  
        try (
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING;  
        // Ingest more on the restored index — proves indexing works post-restore  
                fileCache.clear();
import org.opensearch.common.unit.TimeValue;  
                + catalogBefore  
    /**
        createIndex(indexName, indexSettings);
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            .prepareCloneSnapshot(snapshotRepoName, sourceSnapshot, clonedSnapshot)  
            .get();
            org.opensearch.snapshots.SnapshotRestoreException.class,  
     *  
        );
    /**
                try (var stream = Files.list(fmtDir)) {  
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
            );
            .collect(java.util.stream.Collectors.toSet());
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
        // Take V2 snapshot of empty index  
import java.nio.file.Path;  
        var shardSegs = indexSegs.getShards().get(0);
            assertAllFormatDirsHaveFiles(shardBefore);
        );
        ensureGreen(indexName);  
        Client client = client();  
        long currentTime = System.currentTimeMillis();  
        IndexShard sourceShardAfter = getShardZero(indexName);  
            assertEquals("snap=" + snap, RestStatus.OK, restoreResponse.status());  
     * <strong>DFA-specific test:</strong> verifies that the DFA catalog generation is preserved
        flush(indexName);
    }
        indexDocuments(client, indexName, 0, numDocs);  
                    stream.forEach(p -> all.add(format + "/" + p.getFileName()));
            RestoreSnapshotResponse restoreResponse = client.admin()
        String snapshotRepoName = "test-snapshot-repo";
        }  
     *   <li>Restore from snap1 yields exactly N docs (no stale snap2 files leak in)</li>
            .getIndex(indexName)
     * Mirrors {@code DataFormatAwareReplicationBaseIT.assertLuceneIndexDirContents}.
            Path fmtDir = shard.shardPath().getDataPath().resolve(format);
        internalCluster().startClusterManagerOnlyNode();  
        // Verify snapshot is listed
        );  
            .getSetting(indexName, IndexMetadata.SETTING_INDEX_UUID);
    /**
        flush(indexName);  
        assertEquals("snapshot name in status must match", snapshotName, status.getSnapshot().getSnapshotId().getName());  
import org.opensearch.core.index.shard.ShardId;
     *  
     *   <li>Restore status == OK</li>
            }  
    /**
        ensureGreen(indexName);
     * Secondary data formats for the DFA index. By default this is empty (parquet-only).
        String snapshotRepoName = "test-snapshot-repo";
            .prepareRestoreSnapshot(snapshotRepoName, clonedSnapshot)  
        indexDocuments(client, indexName, 0, numDocs);
        // empty indices list triggers V2 path (cluster-manager only, pinned-timestamp based,  
     */
            .setWaitForCompletion(true)
        assertEquals(RestStatus.OK, restore1.status());  
/*  
    public void testV2SnapshotStatusAPIForDFA() throws Exception {  
    }
import org.opensearch.test.OpenSearchIntegTestCase;
        internalCluster().startClusterManagerOnlyNode();
     * correctly when the restore is configured with different repo names than were used  
        RestoreSnapshotResponse restoreResponse = client.admin()  
        final int numDocs = 25;  
            .get();  
            .put(SYSTEM_REPOSITORY_SETTING.getKey(), false);
import org.opensearch.node.remotestore.RemoteStorePinnedTimestampService;
    @Override
        return r;
        List<SnapshotInfo> snapshotsAfter = client.admin().cluster().prepareGetSnapshots(snapshotRepoName).get().getSnapshots();
        org.apache.lucene.index.SegmentInfos infosAfter = org.apache.lucene.index.SegmentInfos.readLatestCommit(
     * </ul>  
            .put("index.composite.primary_data_format", "parquet")
     * preserved and restored. Catches cross-index corruption (e.g., catalog files from index A  
                .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
        // ─── Pre-snapshot assertions: DFA layout is correct ────────────────
        long restoredGen;  
        org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse statusResponse = client.admin()
     * </ul>
     * </ul>
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName)).get());  
        // Delete the source index and restore from CLONE
        assertEquals("no shards may fail to restore", 0, restoreResponse.getRestoreInfo().failedShards());
        ensureGreen(indexName);
        unblockNode(snapshotRepoName, clusterManagerNode);  
        settingsBuilder.put("location", location);
            this.catalogFilesExcludingSegments = catalogFilesExcludingSegments;
        refresh(sourceIndex);  
        flush(indexName);
        long actualCount = client.admin()
        IndexShard shardR2 = getShardZero(indexName);
     */
        );
        flush(indexName);
                        hasCategory = true;
        Settings.Builder settingsBuilder = randomRepositorySettings();
     * </ul>
                .prepareRestoreSnapshot(snapshotRepoName, snapshotName)  
     *                        false for rename tests where a new UUID is expected.
        String clonedSnapshot = "snap-cloned";
                // breaks on Windows where the separator is '\\', and also matches non-component substrings.
        final org.opensearch.common.action.ActionFuture<
        assertEquals("status initializingShards must be 0", 0, status.getShardsStats().getInitializingShards());  
                .get()
            );  
        String snapshotName = "test-v2-snapshot";  
        // Take V2 snapshot
        Settings indexSettings = getIndexSettings(1, 0).build();
            .get();
        internalCluster().startClusterManagerOnlyNode();  
        // Take V2 snapshot  
        assertAllFormatDirsHaveFiles(shardBBefore);  
        logger.info("--> taking V2 snapshot of all DFA indices");
        expectThrows(  
                    + " had writer_generation="
        assertThat(source.state(), equalTo(SnapshotState.SUCCESS));  
        // V2 allows only ONE repository with shallow_snapshot_v2=true cluster-wide, so we
            .get();  
            preSnapshotWriterGens.put(sci.info.name, genAttr);  
     * <ul>  
        ensureGreen(indexName);
            .getPrimaries().docs.getCount();  
            .indices()  
import java.util.Collection;  
        assertEquals(RestStatus.OK, restoreResponse.status());
                .get();  
                    .setPersistentSettings(Settings.builder().put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), pathType))  
        assertDocCountInIndex(client, sourceIndex, numDocs);
    /**
            if (filesAfterRestore.contains(f) == false && filesAfterRestore.contains("index/" + f) == false) {
        assertThat(snapshotInfo.successfulShards(), equalTo(numShards));  
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        // Take V2 snapshot  
        boolean requireSameUUID
        ensureGreen(indexA, indexB);
        // Catalog files (excluding segments_N) must match EXACTLY  
                ParquetDataFormatPlugin.class,  
        internalCluster().startClusterManagerOnlyNode();
        String snap1 = "rapid-snap-1";  
            .cluster()
        final long catalogGeneration;
     * Validate doc count via _stats API (uses engine's docStats(), not search).
        Client client = client();
        final String snap1 = "snap1-initial";  
                .cluster()
        Settings indexSettings = getIndexSettings(1, 0).build();
        assertEquals(0, restoreResponse.getRestoreInfo().failedShards());  
     * Wait until the pinned-timestamp scheduler has fired at least once after invocation.
        assertEquals("status must list the DFA index", 1, status.getIndices().size());
        Map<String, String> preSnapshotWriterGens = new HashMap<>();
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardABefore);  
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardAfter);
        final int numDocs = 15;
            preState.catalogFilesExcludingSegments,
     * shard inspection (catalog snapshot, on-disk format dirs, remote store listing).
        try (
        assertEquals("status API must return one snapshot", 1, statusResponse.getSnapshots().size());
                + "\n  after:  "
            assertEquals("pathType=" + pathType, 0, restoreResponse.getRestoreInfo().failedShards());
        super(nodeSettings);  
            .prepareRestoreSnapshot(snapshotRepoName, snap2)
    }
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName, new ArrayList<>());
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName, new ArrayList<>());  
     * restored index gets a new name {@code restored-idx}. Validates DFA handles the renamed  
        // Verify the setting override took effect
            "doc count mismatch for index " + indexName + " (expected " + expectedCount + ", got " + actualCount + ")",
        // For DFA this MUST include any per-format dirs; we walk the entire indexUUID subtree.  
        Client client = client();
        );
            String genAttr = sci.info.getAttribute(org.opensearch.be.lucene.index.LuceneWriter.WRITER_GENERATION_ATTRIBUTE);
            String postGen = postRestoreWriterGens.get(segName);
            IndexShard shard = getIndexShard(node, new ShardId(resolveIndex(indexName), shardId), indexName);
                "snap-fail"
        assertDocCountInIndex(client, restoredIndexName, pre.docCount);
        String snapshotName = "test-v2-multi-shard-snapshot";  
                .setWaitForCompletion(true)
        if (WRITABLE_WARM_INDEX_SETTING.get(settings)) {
            assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName)).get());
     *
        PreSnapshotState pre = capturePreSnapshotState(client, sourceIndex, sourceShard);  
                    + postRestoreWriterGens,
                postGen  
        String renamedIndex = "dfa-rename-restored";
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
            long docCount,
        Client client = client();
        assertAllFormatDirsHaveFiles(shardBefore);
            genAfter = ref.get().getGeneration();
     * <strong>DFA failure recovery test:</strong> if a V2 snapshot fails during finalization
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName)
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardR2);  
                + filesAfter,
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardAAfter);  
        assertDocCountInIndex(client, indexA, numDocsA);
        ) {
    }
        flush(indexName);  
        PreSnapshotState preState = capturePreSnapshotState(client, indexName, sourceShardBefore);
            .indices()
     */  
     * indexUUID and the given category (e.g. {@code "segments"} or {@code "translog"}).
        logger.info("--> restoring from cloned V2 snapshot");  
     */  
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName)).get());  
        assertDocCountInIndex(client, indexA, numDocsA);
     * Subclasses (e.g. {@code DataFormatAwareRestoreShallowSnapshotV2WithLuceneIT}) override  
        ensureGreen(indexName);
        // ── Phase 1: create hot DFA index, ingest, snapshot ────────────────  
    }
        final String indexUUID;
    }
            }
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shard);
    }
        createIndex(indexName, indexSettings);  
     * Each field is exactly comparable to the post-restore state.
        ) {
     * snapshots within a single repo (only one snapshot can be in finalization state at a time),  
        final int phase3Docs = 15;
                boolean hasCategory = false;
        internalCluster().startDataAndWarmNodes(1);
     * — they must NOT partially restore or leak files.
        String sourceIndex = "dfa-rename-source";  
        Settings indexSettings = getIndexSettings(1, 0).build();
                + "\n  files on disk after restore: "
            assertAllFormatDirsHaveFiles(shard);  
        }, 120, TimeUnit.SECONDS);
        String indexName = "dfa-testindex";
     * Take a V2 snapshot of a DFA index, then delete the snapshot. Validates that:
        for (SnapshotInfo s : snapshots) {
        String indexName = "dfa-empty-index";  
        }  
     * Tight post-restore validation. Asserts the restored index matches the captured pre-snapshot
        assertNotEquals("restored index always has a fresh UUID, not the source UUID", pre.indexUUID, restoredUuid);
     * <ul>
        assertFalse("pre-snapshot writer_generation map must not be empty", preSnapshotWriterGens.isEmpty());
    public static Collection<Object[]> parameters() {
import org.opensearch.index.remote.RemoteStoreEnums;
        assertDocCountInIndex(client, indexName, finalTotal);  
        indexDocuments(client, indexName, 0, numDocs);
        // Repo must contain only the successful retry snapshot
        ensureGreen(indexName);
        flush(indexName);
        AcknowledgedResponse deleteResponse = client.admin().cluster().prepareDeleteSnapshot(snapshotRepoName, snapshotName).get();  
        Path absolutePath1 = randomRepoPath().toAbsolutePath();  
        refresh(indexName);
    private String nodeNameForShard(ClusterState state, String indexName, int shardId) {
     * <strong>DFA-specific test:</strong> validates that Lucene segments' DFA-specific  
                .prepareRestoreSnapshot(snapshotRepoName, snapshotName)  
        logger.info("--> restoring empty V2 snapshot");  
            assertFalse(  
     *
        for (String snap : new String[] { snap1, snap2 }) {
        blockClusterManagerFromFinalizingSnapshotOnIndexFile(snapshotRepoName);
        String snapshotRepoName = "test-invalid-restore-repo";
        IndexShard shardAfterPhase2 = getShardZero(indexName);  
        assertEquals("status totalShards must be 1", 1, status.getShardsStats().getTotalShards());  
            restoredShard.store().directory()
        IndexShard renamedShard = getShardZero(renamedIndex);  
import java.util.HashSet;
        return all;
        // DFA on-disk layout intact
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));  
            .setIndices(indexName)
     * Validates the {@code _snapshot/_status} API works for V2 DFA snapshots. The status API
        // UUID check: restore always creates a fresh index with a NEW UUID (not the snapshot's source UUID).  
     * V2 restore with overridden index settings. Some settings are restorable-mutable
        Set<String> nonSegmentsFiles = files.stream()
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));  
        // ─── Take V2 snapshot ──────────────────────────────────────────────
    @Override  
        indexDocuments(client, indexName, 0, docsBeforeSnap1);  
        org.apache.lucene.index.SegmentInfos infos = org.apache.lucene.index.SegmentInfos.readLatestCommit(sourceShard.store().directory());  
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardAfterSnap2);
        // Take V2 snapshot
        }
 *
        final int numDocs = 10;
     *   <li>After restore: validate engine, catalog, doc count, then ingest more, refresh, validate.</li>
     * same catalog generation, same on-disk format dirs. A subsequent V2 snapshot must succeed.  
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        RestoreSnapshotResponse restoreResponse = client.admin()
        clusterAdmin().prepareCleanupRepository(BASE_REMOTE_REPO).get();
        assertAllFormatDirsHaveFiles(shardBAfter);  
import static org.opensearch.repositories.blobstore.BlobStoreRepository.SYSTEM_REPOSITORY_SETTING;
        assertEquals("empty index 1-shard exactly 1 successful", 1, snapshotInfo.successfulShards());
package org.opensearch.composite;
        indexDocuments(client, indexB, 0, numDocsB);
            this.catalogGeneration = catalogGeneration;
     * <p>V2 path is triggered by passing an empty indices list to createSnapshot:  
        refresh(indexName);
        disableRepoConsistencyCheck("Remote store repo aliasing");
        IndexShard shardAfterDelete = getShardZero(indexName);
        // Restore using the DR repos
        return Set.of("parquet", "lucene");
            .get()  
        for (Map.Entry<String, String> e : preSnapshotWriterGens.entrySet()) {  
    }
        RestoreSnapshotResponse restoreResponse = client.admin()  
        ensureGreen(indexName);
        assertAcked(cloneResponse);  
     * End-to-end V2 snapshot lifecycle for a hot DFA index, validating that indexing + refresh +  
            .prepareRestoreSnapshot(snapshotRepoName, snap1)
        // status must contain index stats for our index
        refresh(indexName);  
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));  
            .get();
    /**
        String sourceSnapshot = "src-snap";
        IndexShard shardAfter = getShardZero(indexName);
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        Set<String> catalogBefore = DataFormatAwareITUtils.catalogFilesExcludingSegments(shardBefore);
            assertAcked(client().admin().cluster().prepareDeleteRepository(snapshotRepoName).get());
     * DFA-specific setting overrides too.
        refresh(indexName);
                + missing
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName, new ArrayList<>());
        assertAllFormatDirsHaveFiles(shardPreSnap1);
        long docs = client.admin().indices().prepareStats(indexName).clear().setDocs(true).get().getIndex(indexName).getPrimaries().docs  
                    + preGen  
            settingsBuilder.put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true);
        String indexUUID = client.admin()
            "all shards must restore successfully",  
        IndexShard shardAfterSnap1 = getShardZero(indexName);
            .put(rmd.settings())
import java.util.concurrent.TimeUnit;
        assertDocCountInIndex(client, indexName, numDocs);
            .cluster()
        internalCluster().startClusterManagerOnlyNode();
            catalogAfter
            assertNotNull(
        refresh(indexName);
        flush(indexName);  
        IndexShard shardR1 = getShardZero(indexName);
            genAfter >= preState.catalogGeneration
                    + segName
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
    protected boolean hasLuceneSecondary() {
        String indexName = "dfa-multi-shard";
        assertLuceneIndexDirContents(shardABefore);
            "DFA catalog generation must be monotonic across clone+restore: source=" + sourceGen + " restored=" + restoredGen,  
            .setIndices(indexName)
        }
            IndexShard shardBefore = getShardZero(indexName);  
        assertLuceneIndexDirContents(shardAfter);
        assertEquals(RestStatus.OK, restoreResponse.status());
            .put("index.pluggable.dataformat.enabled", true)  
     * parquet files. If snapshot/restore drops this attribute, DFA can't reconstruct the
    protected static final class PreSnapshotState {  
        return new PreSnapshotState(docs, segs, catalogFiles, catalogGen, uuid);  
            assertAcked(
        indexDocuments(client, indexName, 0, numDocs);
        indexDocuments(client, indexName, 0, numDocs);  
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        internalCluster().startClusterManagerOnlyNode();
        indexDocuments(client, indexName, 0, 1);
    }
        assertNotNull("status object must contain shard stats", status.getShardsStats());
        final String repoName = "test-snapshot-repo";
        flush(indexB);
     * (cluster-manager block injected), the source DFA index must be UNCHANGED — same docs,
            settingsBuilder.put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
     * {@code assertBusy} to avoid the awaitility dependency (not on classpath here).  
                .cluster()  
            restoredGen = ref.get().getGeneration();  
        internalCluster().startClusterManagerOnlyNode();
     * </ul>  
        assertDocCountInIndex(client, indexName, docsBeforeSnap1);
        // Post-restore #1 validations  
        final String indexName = "hot-v2-lifecycle";
                .setIndexSettings(changeSegmentRepo)  
    /**  
        assertTrue("source snapshot must be listed: " + snapshotNames, snapshotNames.contains(sourceSnapshot));
        internalCluster().startDataAndWarmNodes(1);
                .get();
        ensureGreen(indexName);
        assertEquals("snapshot must be listed before deletion", 1, snapshotsBefore.size());
        assertDocCountInIndex(client, sourceIndex, numDocs);  
                .getCatalogSnapshot()
    /**
        RepositoryMetadata rmd = res.repositories().get(0);
        String snapshotName = "snap-status";
        assertLuceneIndexDirContents(shardAfter);  
        for (org.apache.lucene.index.SegmentCommitInfo sci : infosAfter) {
                .prepareRestoreSnapshot(snapshotRepoName, snap)
        assertAllFormatDirsHaveFiles(shardAfterDelete);
        assertEquals("snap1 single-shard exactly 1 successful", 1, info1.successfulShards());
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        // Delete the index so we can restore from snapshot  
        Set<String> r = new HashSet<>(a);
            preSnapshotWriterGens.values().stream().anyMatch(java.util.Objects::nonNull)
    private static Set<String> diff(Set<String> a, Set<String> b) {
            .setIndices(indexName)  
        final long docCount;
            // Switch cluster path type
        );  
        // Pre-snapshot DFA layout assertions on both  
import org.opensearch.transport.client.Client;  
import org.opensearch.snapshots.SnapshotState;
        return count[0];
        String restoredIndexName,
            org.opensearch.common.concurrent.GatedCloseable<org.opensearch.index.engine.exec.coord.CatalogSnapshot> ref = restoredShard
            assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName)).get());
            .cluster()
        IndexShard shardAfterSnap2 = getShardZero(indexName);
            assertAllFormatDirsHaveFiles(shardAfter);
    /**
                nonSegmentsFiles.isEmpty()
                assertTrue("format directory must have files: " + format + " (" + dir + ")", stream.findAny().isPresent());
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));  
        logger.info("Snapshot Path [{}]", absolutePath1);
            );
        assertDocCountInIndex(client, indexName, numDocs);  
        ensureGreen(indexName);
        ensureGreen(indexName);
            String id = Integer.toString(i);
        // Capture pre-snapshot writer_generation on each Lucene segment  
    }
        Set<String> catalogBefore = pre.catalogFilesExcludingSegments;  
     * independently preserved and restored.
        internalCluster().startDataAndWarmNodes(1);
        RestoreSnapshotResponse r1 = client.admin()  
     * must succeed; restore must produce a green, empty index with zero docs.
        // ─── Restore from V2 snapshot ──────────────────────────────────────
        // Pre-snapshot: 0 docs  
        }  
     * fires snapshots back-to-back with no delay and verifies both succeed without races.
        String indexName = "dfa-status-api";  
        assertEquals("status failedShards must be 0", 0, status.getShardsStats().getFailedShards());
        flush(indexName);
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName, new ArrayList<>());  
import org.opensearch.indices.replication.common.ReplicationType;
        assertEquals("snap2 single-shard exactly 1 successful", 1, info2.successfulShards());
            .setWaitForCompletion(true)
                .setWaitForCompletion(true)
        ensureGreen(indexName);
        final int docsAfterSnap1 = 12;
        for (String f : catalogBefore) {  
            if (preGen == null) continue;  
        if (hasLuceneSecondary()) {
            // Clean up so the next iteration can register a new repo with shallow_snapshot_v2=true  
            try (var stream = Files.list(dir)) {
     * Whether lucene is configured as a secondary format. Drives format-aware on-disk assertions.
        // DFA on-disk layout must be reconstructed identically: parquet/ dir + index/ (segments_N + lucene files)
        internalCluster().startDataAndWarmNodes(1);
            .getSetting(restoredIndexName, IndexMetadata.SETTING_INDEX_UUID);
import org.opensearch.cluster.ClusterState;
        Settings disableRemoteStore = Settings.builder().put(SETTING_REMOTE_STORE_ENABLED, false).build();
            expectedCount,  
    public void setup() {
        logger.info("--> restoring V2 snap1");
        String snapshotRepoName = "test-snapshot-repo";
        assertDocCountInIndex(client, indexName, 0);
     * <p>Catches:  
 * compatible open source license.
        Set<String> files;  
        if (Files.exists(indexDir)) {  
            .setSnapshots(snapshotName)
    public void testV2HashedPrefixPathTypeForDFA() throws Exception {
            }  
import java.util.HashMap;
                // Concurrent cleanup may delete a file between enumeration and visit; tolerate.  
        assertThat(snapInfo1.state(), equalTo(SnapshotState.SUCCESS));
            .setWaitForCompletion(true)
    /** Set difference helper for clearer failure messages. */  
    }
        }
     * <em>alternate</em> snapshot/segment/translog repositories that point at the same
    private void assertCatalogFilesRestoredOnDisk(IndexShard shardBefore, IndexShard shardAfter) throws IOException {  
        assertBusy(() -> {  
        for (String format : expectedFormats()) {  
                "parquet+lucene-secondary: index/ must have segment data files beyond segments_N, got only: " + files,
        String indexName = "dfa-clone-catalog-gen";  
                .setIndices(indexName)
        Client client = client();
        IndexShard shardABefore = getShardZero(indexA);  
     *
     * <strong>DFA failure handling test:</strong> verify that invalid restore requests for a  
        logger.info("--> taking V2 snap2 at {} docs", totalDocs);
     */
        logger.info("--> taking source V2 snapshot");
    }
     */
        String actualRefreshInterval = client.admin()  
     * {@link org.opensearch.snapshots.SnapshotsService} (~line 293).
        Path indexDir = shard.shardPath().resolveIndex();
            String indexUUID  
    protected void assertRestoredIndexMatches(  
        flush(indexName);  
                + " extra="
            org.opensearch.common.concurrent.GatedCloseable<org.opensearch.index.engine.exec.coord.CatalogSnapshot> ref = sourceShard  
            restoredGen = ref.get().getGeneration();
            String indexName = "dfa-pathtype-" + suffix;
        assertEquals("multi-index 1-shard each: snapshot must report exactly 2 successful shards", 2, snapshotInfo.successfulShards());
        ensureGreen(indexName);  
    private Path remoteRepoPath;  
            ensureGreen(indexName);
        }
        assertEquals(1, s1.successfulShards());  
            .cluster()
        assertEquals(RestStatus.OK, restoreResponse.status());
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
        logger.info("Snapshot Path [{}]", absolutePath1);
        return iter.next().getSegments().size();  
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName)
        // Source index can stay; we rename on restore
     *   <li>Catalog files from one shard leaking into another shard's restored state</li>
    public void testV2IncrementalSnapshotsForDFA() throws Exception {  
        return true;
     * but focuses on the snapshot-API contract (we don't probe internal blob counts here
            actualCount
                + diff(preState.catalogFilesExcludingSegments, catalogAfter)
    }
        final int numDocs = 12;  
                ArrowBasePlugin.class,
                + " extra="
                sci.info.name,  
     * Assert each non-Lucene format directory exists under the shard data path and contains files.
import org.opensearch.snapshots.AbstractSnapshotIntegTestCase;
        String snapshotName = "test-v2-dr-snapshot";  
        assertTrue("index/ directory must exist: " + indexDir, Files.exists(indexDir));
        // Get index UUID — used to find the right shard subtree under the remote-store layout
import org.opensearch.common.util.FeatureFlags;
        assertEquals(numShards, restoreResponse.getRestoreInfo().totalShards());  
                .setIndices(indexName)  
            assertEquals("pathType=" + pathType, RestStatus.OK, restoreResponse.status());
     */
            assertAcked(client().admin().cluster().prepareDeleteSnapshot(snapshotRepoName, snapshotName).get());  
        assertLuceneIndexDirContents(shardBBefore);
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "300s")
                RemoteStorePinnedTimestampService.getPinnedTimestamps().v1() > currentTime
        internalCluster().startClusterManagerOnlyNode();
import org.opensearch.indices.RemoteStoreSettings;
            .get();
            .cluster()  
        indexDocuments(client, indexName, 0, numDocs);
            String suffix = pathType.toString().toLowerCase(java.util.Locale.ROOT);
     */
    public void testV2EmptyIndexSnapshot() throws Exception {  
            assertAllFormatDirsHaveFiles(shard);
    protected Settings.Builder getIndexSettings(int numOfShards, int numOfReplicas) {
        createIndex(indexName, indexSettings);  
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardBAfter);
     * <ul>
        assertLuceneIndexDirContents(shardAfterSnap1);  
        assertEquals(RestStatus.OK, restoreResponse.status());  
        Client client = client();
            .setDocs(true)  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;  
        ensureGreen(indexName);
            "at least one segment must have writer_generation attribute pre-snapshot, got: " + preSnapshotWriterGens,
        // Restore snap1 — must yield EXACTLY docsBeforeSnap1 (no leak from snap2)  
    }
                .cluster()  
            .put(BlobStoreRepository.READONLY_SETTING.getKey(), readOnly)
        assertDocCountInIndex(client, indexName, preState.docCount);
     * <p>Mirrors {@code CloneSnapshotV2IT.testCloneShallowCopyV2}.  
            .get();
    /**  
        assertTrue("V2 snapshot must include " + indexA + ", got: " + snapshotInfo.indices(), snapshotInfo.indices().contains(indexA));
        internalCluster().startDataAndWarmNodes(1);
     * <p>Mirrors {@code RestoreShallowSnapshotV2IT.testHashedPrefixTranslogMetadataCombination}.  
            long catalogGeneration,
                if (hasUuid && hasCategory) {
        if (shallowCopyEnabled) {  
    public void testV2SnapshotCreateAndRestoreForDFAIndex() throws Exception {
            .put("location", absolutePath1)
            RestoreSnapshotResponse restoreResponse = client.admin()  
            indexDocuments(client, indexName, batch * 5, batch * 5 + 5);
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName)  
    }
            .build();  
        // 3 shards, 0 replicas
        refresh(indexName);  
        String indexName = "dfa-fail-finalize";
        assertTrue(indexExists(indexName));  
        }  
     */  
        IndexShard sourceShard = getShardZero(indexName);  
            assertLuceneIndexDirContents(shardAfter);
        assertFalse(indexExists(indexName));
        // Delete the index AND the snapshot  
        // Both must succeed
            int segmentCount,  
            .prepareRestoreSnapshot(repoName, snap2)
        org.junit.Assume.assumeTrue("writer_generation attribute test requires Lucene secondary format", hasLuceneSecondary());
        // Doc counts must be PRESERVED PER-INDEX (catches cross-index corruption)
        // Take V2 snapshot
    }
    private static long countFilesUnder(Path rootPath, String indexUUID, String categoryDirName) throws IOException {
    /**
        return Arrays.<Object[]>asList(new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), false).build() });  
            @Override
     * catalog/segments invariants hold across two restore cycles:
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
     * index UUID correctly (file paths, catalog, remote directory routing all use the new UUID).
        String snapshotRepoName = "test-clone-repo";  
        refresh(indexName);
                    .cluster()
            long segCount = countFilesUnder(remoteRepoPath, indexUUID, "segments");
        }
    public void teardown() {  
        RestoreSnapshotResponse restoreResponse = client.admin()  
        // ─── After all failures: verify NO partially-restored index exists ───
            .setRenamePattern(sourceIndex)
     */
        if (Files.exists(rootPath) == false) return 0;
            this.docCount = docCount;
import java.util.concurrent.ExecutionException;  
        IndexShard shardFinal = getShardZero(indexName);
                missingDataFiles.add(f);
        String indexName = "dfa-invalid-restore";
        // Create DFA index (parquet primary + lucene secondary, see getIndexSettings)
        String snap1 = "test-v2-snap1";
     * Mirrors {@code DeleteSnapshotV2IT.testRemoteStoreCleanupForDeletedIndexForSnapshotV2}  
        internalCluster().startClusterManagerOnlyNode();
        final int numDocs = 10;
        // ─── Verify a subsequent VALID restore still works ───
            assertEquals("segments/ subtree must be cleaned up for indexUUID=" + indexUUID, 0, segCount);  
        assertLuceneIndexDirContents(sourceShardAfter);  
     * Used to verify file restoration after V2 restore.
                .setIndexSettings(disableRemoteStore)
        assertFalse("catalog before snapshot must not be empty for shard " + shardBefore.routingEntry(), catalogBefore.isEmpty());  
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));  
     *   <li>Create hot DFA index, ingest, snapshot {@code snap1}, delete, restore from {@code snap1}.</li>  
        refresh(indexName);  
        assertEquals(RestStatus.OK, restoreResponse.status());
        assertTrue("index/ must contain segments_N, got " + files, files.stream().anyMatch(f -> f.startsWith("segments_")));
        assertEquals("rename: snapshot has exactly 1 shard", 1, snapshotInfo.successfulShards());
        String indexName = "dfa-dr-index";
            assertEquals("snap=" + snap, 0, restoreResponse.getRestoreInfo().failedShards());
        String clonedSnapshot = "cloned-snap";  
    public void testV2RestoreToDifferentRemoteRepoForDFA() throws Exception {  
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));  
        }
        ensureGreen(indexName);
        assertDocCountInIndex(client, indexName, 1);
    private Set<String> expectedFormats() {  
        String clusterManagerName = internalCluster().getClusterManagerName();  
            .getSetting(indexName, IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey());
            String segName = e.getKey();
        Settings indexSettings = getIndexSettings(1, 0).build();
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
        internalCluster().startDataAndWarmNodes(1);  
        ensureGreen(indexName);
        assertAllFormatDirsHaveFiles(shardABefore);
        final String snap2 = "snap2-after-more-docs";
        Client client = client();
        refresh(indexName);
        String snapshotRepoName = "test-fail-finalize-repo";  
            RemoteStorePinnedTimestampService.class,
            assertLuceneIndexDirContents(shardBefore);
        // Segment count must be EXACT
    protected PreSnapshotState capturePreSnapshotState(Client client, String indexName, IndexShard shard) throws IOException {
    private Set<String> captureShardFilesOnDisk(IndexShard shard) throws IOException {  
        internalCluster().startDataAndWarmNodes(1);
        RestoreSnapshotResponse restoreResponse = client.admin()  
        createIndex(indexB, indexSettings);
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
            .get();
                + filesBeforeSnapshot  
        // (the actual path includes a path-type prefix like HASHED_PREFIX so we walk the tree).  
        assertTrue("renamed index must exist", indexExists(renamedIndex));
        String indexName = "dfa-rapid-snap";
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardAfter);
     *
        assertDocCountInIndex(client, indexName, numDocs);  
        internalCluster().startDataAndWarmNodes(1);  
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
            .setWaitForCompletion(true)  
            restoreResponse.getRestoreInfo().totalShards(),
        internalCluster().startDataAndWarmNodes(1);  
            .setWaitForCompletion(true)  
            super.nodePlugins().stream(),  
        assertTrue("cloned snapshot must be listed: " + snapshotNames, snapshotNames.contains(clonedSnapshot));  
        assertNotNull("pre-snapshot index UUID must be set", uuid);  
        RestoreSnapshotResponse restoreResponse = client.admin()
                for (Path part : file) {
        createRepository(drTranslogRepo, "fs", getRepositorySettings(BASE_REMOTE_REPO, true));
     * Validates that DFA's format-aware remote directory routing works under HASHED_PREFIX,  
        long restoredGen;
     */  
        PreSnapshotState(
                .cluster()
        assertThat("snap2 state", info2.state(), equalTo(SnapshotState.SUCCESS));  
                .getCatalogSnapshot()  
        assertLuceneIndexDirContents(shardBAfter);
        // Pre-snapshot: every shard must have parquet+lucene layout
        assertAcked(deleteResponse);  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .prepareGetSettings(indexName)  
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
import org.opensearch.core.rest.RestStatus;
        SnapshotInfo snapInfo1 = createSnapshot(snapshotRepoName, snap1, new ArrayList<>());  
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName)).get());
     *
        return getIndexShard(node, new ShardId(resolveIndex(indexName), 0), indexName);
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));  
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));  
        // Fire two V2 snapshots back-to-back on the same repo
                        hasUuid = true;
        internalCluster().startClusterManagerOnlyNode();
        return state.nodes().get(nodeId).getName();
        Client client = client();
            .setIndices(indexName)  
        assertEquals(0, restoreResponse.getRestoreInfo().failedShards());  
        assertFalse(indexExists(indexName));
        // — simulates DR where the operator points a new cluster at the existing storage
        // The blocked snapshot must throw SnapshotException
        assertDocCountInIndex(client, indexName, 0);
    /**
        final int numDocs = 15;  
            .get();
import java.util.stream.Stream;  
        List<SnapshotInfo> snapshotsBefore = client.admin().cluster().prepareGetSnapshots(snapshotRepoName).get().getSnapshots();  
     * <p>This validates the V2 lifecycle: snapshot creation pins a timestamp and writes
        createIndex(indexName, indexSettings);
        assertTrue("pre-snapshot catalog generation must be > 0", sourceGen > 0L);
        flush(indexA);  
            .cluster()
        createIndex(indexName, indexSettings);
        createRepository(drSnapshotRepo, "fs", getRepositorySettings(snapshotRepoName, true));
    }  
     */  
        final int numDocs = 15;
        assertAllFormatDirsHaveFiles(shardFinal);  
     * and only ONE repo cluster-wide can have {@code shallow_snapshot_v2=true}. So the test
        // Doc count unchanged
        logger.info("--> taking V2 snapshot for delete test");
    @ParametersFactory  
        String sourceSnapshot = "snap-source";
        assertEquals(
        assertAcked(deleteResponse);
        assertDocCountInIndex(client, indexName, initialDocs);
        keepPinnedTimestampSchedulerUpdated();
        // For DFA + V2 test, warm-index is orthogonal and slows test; use only non-warm variant.
        assertEquals("single-shard index: snapshot must report exactly 1 successful shard", 1, snapshotInfo.successfulShards());
    }  
                "parquet-only: index/ must have only segments_N (and write.lock), got extra: " + nonSegmentsFiles,  
import org.opensearch.plugins.Plugin;  
        String drSegmentRepo = "dr-segment-repo";  
    }
        Set<String> snapshotNames = new HashSet<>();
        assertDocCountInIndex(client, indexName, numDocs);
        assertEquals("snapshot must contain exactly the DFA index", List.of(indexName), snapshotInfo.indices());
        assertFalse(indexExists(indexName));
        // ── Restore from snap1, validate, ingest more, validate, snap2 ─────
        final int numDocs = 60;
    protected Settings.Builder getRepositorySettings(String sourceRepository, boolean readOnly) throws ExecutionException,
        IndexShard shardBefore = getShardZero(indexName);
     *
        Client client,
        flush(indexName);  
        // with data, hence no writer_generation attributes to validate.
        PreSnapshotState pre = capturePreSnapshotState(client, indexName, shardBefore);
        assertEquals(1, s2.successfulShards());  
        final int numDocs = 12;
        assertDocCountInIndex(client, indexName, numDocs);
        assertDocCountInIndex(client, indexName, numDocs);  
     * Mirrors {@code DataFormatAwareReplicationBaseIT.assertAllFormatDirsHaveFiles}.  
        // After restore, the index should be writable — index a doc to confirm
        IndexShard sourceShardBefore = getShardZero(indexName);  
        String snapshotName = "snap-invalid";  
            .get();
     * {@code RestoreShallowSnapshotV2IT.testRestoreOperationsShallowCopyEnabled}.
        return Settings.builder()  
     * primary=parquet, secondary=[lucene]. Lucene is also always present implicitly.
    }  
    }  
            createIndex(indexName, getIndexSettings(1, 0).build());  
        Set<String> filesAfter = captureShardFilesOnDisk(shardAfter);
        String nodeId = state.routingTable().index(indexName).shard(shardId).primaryShard().currentNodeId();  
        assertBusy(
        org.opensearch.snapshots.SnapshotRestoreException ex1 = expectThrows(  
        Client client = client();
        ensureGreen(indexName);
        ensureYellowAndNoInitializingShards(indexName);
            .cluster()
     * the "empty catalog" case correctly?
                    String name = part.toString();  
            Path dir = shard.shardPath().getDataPath().resolve(format);
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardBefore);
        assertDocCountInIndex(client, indexB, numDocsB);  
        }  
        ClusterState restoredState = client.admin().cluster().prepareState().get().getState();
     */
            )
    public void testV2MultiIndexSnapshotAndRestoreForDFA() throws Exception {  
        Settings indexSettings = getIndexSettings(1, 0).build();  
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;  
        flush(indexName);  
            .get();
                + "\n  catalog before: "
                return java.nio.file.FileVisitResult.CONTINUE;
     * <p>Validates DFA refresh/flush concurrency under V2 timestamp-pinning and that both
import org.opensearch.index.shard.IndexShard;  
            clusterManagerName  
                + filesAfterRestore,
     * <ul>
            .get();  
        flush(indexName);
        // Configure aggressive pinned-timestamp release so cleanup can fire promptly
        var indexSegs = resp.getIndices().get(indexName);  
     * Captured pre-snapshot state for tight post-restore comparison.  
            TimeUnit.SECONDS
        indexDocuments(client, indexName, 0, numDocs);
    @After
        );  
        // Restore both from V2 snapshot  
    }  
        ensureGreen(indexName);
     * is a different code path than create/restore and may have its own bugs that don't  
            .setIndices("*")
        Set<String> missing = new HashSet<>();
    }
            .indices()
    /**
 */  
            }  
     *   <li>Catalog files match local store and remote store</li>  
     * DFA-specific assertions on the source state.  
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shard);
        if (shardSegs == null) return 0;  
        Map<String, String> postRestoreWriterGens = new HashMap<>();  
        String snapshotName = "snap-rename";  
            missingDataFiles.isEmpty()  
        Client client = client();
        Settings indexSettings = getIndexSettings(1, 0).build();
        logger.info("--> cloning V2 snapshot");  
        assertDocCountInIndex(client, indexName, totalDocs);
        logger.info("--> restoring V2 snapshot via DR repos");
        Files.walkFileTree(rootPath, new java.nio.file.SimpleFileVisitor<>() {
            assertLuceneIndexDirContents(shard);
        ensureGreen(sourceIndex);
     * End-to-end snapshot V2 + restore test for a DFA (parquet primary, lucene secondary) index.  
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        ClusterState clusterState = client.admin().cluster().prepareState().get().getState();
     * layout is intact.
            assertAcked(client().admin().indices().prepareDelete("_all").get());  
     * <p>Validates that the V2 cluster-manager-only flow snapshots ALL existing indices when
        waitForBlock(clusterManagerNode, snapshotRepoName, TimeValue.timeValueSeconds(30L));
                + diff(pre.catalogFilesExcludingSegments, restoredCatalog)
        Client client = client();
     */
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(sourceShardAfter);
}
                var fileCache = node.fileCache();  
    /**
     *   <li>Snapshot is listed by the snapshots API after creation</li>
        ByteSizeValue cacheSize = new ByteSizeValue(16, ByteSizeUnit.GB);
        ensureGreen(indexName);
     *  
        indexDocuments(client, indexName, 0, numDocs);
     * V2 snapshot + restore with different {@code RemoteStoreEnums.PathType} settings.
        long catalogGen;
            .prepareSnapshotStatus(snapshotRepoName)  
        SnapshotInfo snapInfo2 = createSnapshot(snapshotRepoName, snap2, new ArrayList<>());  
        internalCluster().startClusterManagerOnlyNode();
        });  
     *   <li>snap1 captures state at N docs, snap2 captures state at N+M docs</li>  
        // 120s timeout because pinned-timestamp lookback + scheduler iterations can take a while
            .setIndices(indexName)
        assertTrue("snapshot must NOT be listed after deletion, got: " + snapshotsAfter, snapshotsAfter.isEmpty());
        assertEquals(RestStatus.OK, r1.status());  
        refresh(indexName);
     * (or advanced) when a V2 snapshot is cloned and restored from the clone. Catalog generation  
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName)).get());  
        var resp = client.admin().indices().prepareSegments(indexName).get();
        // Delete and restore  
            Set<String> catalogFilesExcludingSegments,
        for (int batch = 0; batch < 3; batch++) {  
     *   <li>parquet-only: index/ has only segments_N (and possibly write.lock); no segment data</li>
            snapshotNames.add(s.snapshotId().getName());  
        Path absolutePath1 = randomRepoPath().toAbsolutePath();  
        assertAllFormatDirsHaveFiles(shardAfterSnap2);
     * cleanup logic might miss.
    }
            ),
        assertDocCountInIndex(client, indexName, totalAtSnap2);
        for (org.apache.lucene.index.SegmentCommitInfo sci : infos) {
            () -> client.admin()
        // Restore from each, verify both work
        String indexName = "dfa-incremental-index";  
            .get();
        try (  
            assertThat("pathType=" + pathType, snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));  
     * (e.g., {@code refresh_interval}). Validates the override is applied to the restored index.  
        assertDocCountInIndex(client, indexName, numDocs);  
        Set<String> restoredCatalog = DataFormatAwareITUtils.catalogFilesExcludingSegments(restoredShard);
        indexDocuments(client, indexName, totalAtSnap2, finalTotal);
    /**
    protected Settings nodeSettings(int nodeOrdinal) {
        // Delete BOTH indices
            .getCount();
                }  
     * HASHED_INFIX, and FIXED path types.
        final String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();  
        // Call _snapshot/_status API  
        Client client = client();  
        refresh(indexName);  
 * SPDX-License-Identifier: Apache-2.0
        String snap2 = "rapid-snap-2";
            pre.segmentCount,
            .setSourceRemoteTranslogRepository(drTranslogRepo)  
                DataFusionPlugin.class  
            ensureGreen(indexName);
            public java.nio.file.FileVisitResult visitFile(Path file, java.nio.file.attribute.BasicFileAttributes attrs) {  
        IndexShard sourceShard = getShardZero(indexName);
        org.opensearch.action.admin.cluster.snapshots.status.SnapshotStatus status = statusResponse.getSnapshots().get(0);
     *
        // Restore snap2 — must yield totalDocs (newer state)  
        // Capture exhaustive pre-failure state for assertion that source is unaffected by failed snapshot
        // ─── Invalid request 1: try to disable remote_store on restore ───
        }  
            assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName)).get());  
                .prepareRestoreSnapshot(snapshotRepoName, snapshotName)
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName)  
        }  
        // Delete and restore
     * {@code request.indices().length == 0} is part of the V2 gate in
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(restoredShard);  
        RestoreSnapshotResponse restoreResponse = client.admin()
            sourceGen = ref.get().getGeneration();  
    /**  
     * <p>Mirrors the rename pattern from  
     *  
        String snap2 = "test-v2-snap2";  
        String snapshotName = "snap-empty";
        String restoredUuid = client.admin()  
        expectThrows(
            logger.info("--> taking V2 snapshot for pathType={}", pathType);
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), false)  
        );
        assertAllFormatDirsHaveFiles(shardAAfter);
     * not just metadata.
        IndexShard sourceShard = getShardZero(sourceIndex);
        Settings overriddenSettings = Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "5s").build();
        ensureGreen(indexName);
        assertTrue("source index must still exist", indexExists(sourceIndex));
        // Snapshot, delete, restore
import org.opensearch.core.common.unit.ByteSizeUnit;
        String indexName = "dfa-settings-restore";
        String snapshotName = "test-v2-delete";  
import java.util.ArrayList;
        assertAllFormatDirsHaveFiles(shardR1);
        ensureGreen(indexName);
        logger.info("--> taking V2 snapshot");
     */
            .get();  
        Client client = client();
    private void assertAllFormatDirsHaveFiles(IndexShard shard) throws IOException {
        logger.info("--> restoring all indices from V2 snapshot");
            .setWaitForCompletion(true)  
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
        flush(indexName);  
        // Take source V2 snapshot  
        assertAllFormatDirsHaveFiles(shardAfterSnap1);
            Stream.of(
     * Snapshots the set of files present on a shard's local disk (parquet/, lucene index/, etc.)  
        GetRepositoriesResponse res = client().admin().cluster().getRepositories(gr).get();
        }
        logger.info("--> deleting V2 snapshot [{}]", snapshotName);
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardAfter);  
            .setIndexSettings(overriddenSettings)
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardAfter);
            org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse> snapshotFuture = startFullSnapshot(  
import java.util.stream.Collectors;
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName, new ArrayList<>());  
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName, new ArrayList<>());
        String snapshotName = "snap-writergen";
        assertDocCountInIndex(client, indexName, numDocs);  
        internalCluster().startClusterManagerOnlyNode();
        Client client = client();
        assertDocCountInIndex(client, indexName, initialDocs);
        refresh(indexName);
        assertFalse(indexExists(indexA));  
            .setWaitForCompletion(true)  
     *   <li>All format dirs (parquet, lucene index/) reconstructed on disk with files</li>
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        assertTrue(
        var iter = shardSegs.iterator();
        assertLuceneIndexDirContents(shardAfterSnap2);  
        ) {
        Settings indexSettings = getIndexSettings(1, 0).build();  
            org.opensearch.common.concurrent.GatedCloseable<org.opensearch.index.engine.exec.coord.CatalogSnapshot> ref = restoredShard  
            logger.info("--> restoring rapid V2 snapshot [{}]", snap);  
        createIndex(indexName, indexSettings);
        assertAllFormatDirsHaveFiles(shardAfterPhase2);
     */
        assertEquals("only the successful retry snapshot must remain in repo", 1, snapshots.size());
        assertFalse(indexExists(indexName));
        assertFalse(indexExists(indexName));
        indexDocuments(client, indexName, 0, numDocs);
    ) throws IOException {  
    /**  
    /**  
        assertTrue("V2 snapshot must include " + indexB + ", got: " + snapshotInfo.indices(), snapshotInfo.indices().contains(indexB));
     * deletion + index deletion + lookback expiry. Lucene-only tests check just {@code segments/}
            assertDocCountInIndex(client, indexName, numDocs);
        refresh(indexA, indexB);
            IndexShard shardAfter = getShardZero(indexName);  
     */
        createIndex(indexName, indexSettings);  
     * <p>Post-restore assertions:
     *   <li>{@code prepareDeleteSnapshot} succeeds (acknowledged)</li>  
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
    /**
     * {@code writer_generation} attribute survives V2 snapshot/restore. This attribute is
        createIndex(indexName, indexSettings);  
        String snapshotName = "snap-settings";
        // Clone the snapshot — V2 requires wildcard pattern "*" for indices
            }  
                .setWaitForCompletion(true)  
            // (V2 allows only ONE such repo cluster-wide).
        assertLuceneIndexDirContents(shardAfter);
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), true)  
        assertEquals("refresh_interval override must take effect on restored index", "5s", actualRefreshInterval);
    private void indexDocuments(Client client, String indexName, int numOfDocs) {
        Client client = client();
        for (int i = fromId; i < toId; i++) {  
     */
        createRepository(repoName, "fs", getRepositorySettings(repoPath, true));
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        }
     * Set of formats this test's index uses. Matches the index settings:  
import org.opensearch.cluster.metadata.IndexMetadata;  
        assertDocCountInIndex(client, indexName, numDocs);
        // Take V2 snapshot
    private void assertLuceneIndexDirContents(IndexShard shard) throws IOException {  
     * <ul>  
 * The OpenSearch Contributors require contributions made to  
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        internalCluster().startDataAndWarmNodes(1);
     * <p>Validates V2 snapshot lifecycle for DFA:
        final int docsBeforeSnap1 = 8;
        assertEquals("snapshot total shards must equal successful shards", snapshotInfo.successfulShards(), snapshotInfo.totalShards());  
            .cluster()
        internalCluster().startClusterManagerOnlyNode();
        createIndex(indexName, indexSettings);
                }  
        assertTrue(  
    protected List<String> getSecondaryDataFormats() {  
        assertThat(retryInfo.state(), equalTo(SnapshotState.SUCCESS));
            try (var stream = Files.list(indexDir)) {
        assertThat(snapshotInfo.totalShards(), equalTo(numShards));
        logger.info("--> taking V2 snap1 at {} docs", docsBeforeSnap1);
        // Take V2 snapshot — empty indices list snapshots BOTH  
            .prepareRestoreSnapshot(snapshotRepoName, clonedSnapshot)
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
     *   <li>Restore from snap2 yields N+M docs (newer files present)</li>  
        for (int shardId = 0; shardId < numShards; shardId++) {  
        assertTrue(  
     */
        // Index documents and refresh so segments are created in BOTH formats
     * V2 snapshot of a DFA index with <strong>zero documents</strong>. Edge case — does V2 handle  
            .setWaitForCompletion(true)  
            () -> client.admin()
                    .prepareUpdateSettings()
     * is a DFA-specific monotonic counter not present in Lucene-only engines.
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        AcknowledgedResponse cloneResponse = client.admin()
        }
    }
            .setWaitForCompletion(true)
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
    private static final String BASE_REMOTE_REPO = "test-rs-repo" + TEST_REMOTE_STORE_REPO_SUFFIX;
            assertDocCountInIndex(client, indexName, numDocs);
        internalCluster().startDataAndWarmNodes(1);
                snapshotRepoName,
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardAfterSnap1);
            "rejection message must mention remote_store: " + ex1.getMessage(),
            restoredSegCount  
            final int numDocs = 10;  
    }
        final int numDocs = 10;  
        Settings indexSettings = getIndexSettings(1, 0).build();
     * snapshots are independently restorable.
    }
    /**
     *
        String snapshotRepoName = "test-settings-repo";  
    }  
        assertThat(s1.state(), equalTo(SnapshotState.SUCCESS));
        String drSnapshotRepo = "dr-snapshot-repo";
     * state EXACTLY on doc count, segment count, and catalog file set; the catalog generation must
            postRestoreWriterGens.put(
        Settings indexSettings = getIndexSettings(numShards, 0).build();
        logger.info("--> taking V2 snapshot of multi-shard DFA index");  
        ensureGreen(indexName);
        RestoreSnapshotResponse restore2 = client.admin()  
            SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName, new ArrayList<>());
        Settings indexSettings = getIndexSettings(1, 0).build();  
        try (
        refresh(indexName);  
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        final int phase2Docs = 20;
                sci.info.getAttribute(org.opensearch.be.lucene.index.LuceneWriter.WRITER_GENERATION_ATTRIBUTE)
     *
        // Tight post-restore validation: doc count, segment count, catalog files, generation, UUID, on-disk layout
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
            .put("index.pluggable.dataformat", "composite")
     *   <li>Format-aware remote directory routing issues at multi-shard scale</li>
     * on DFA indices. Validation goes through admin APIs (_stats, cluster state) and direct  
            .indices()
        assertEquals(RestStatus.OK, restoreResponse.status());
