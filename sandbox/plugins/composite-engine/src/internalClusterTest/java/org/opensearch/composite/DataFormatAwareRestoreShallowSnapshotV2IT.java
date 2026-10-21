     * <p>Snapshot V2 assertions:
            if (filesAfter.contains(catalogFile) == false && filesAfter.contains("index/" + catalogFile) == false) {
            .setWaitForCompletion(true)
        IndexShard restoredShard,
    private IndexShard getShardZero(String indexName) {
        long translogFilesBefore = countFilesUnder(remoteRepoPath, indexUUID, "translog");
                        hasCategory = true;
        assertTrue(
import org.opensearch.be.lucene.LucenePlugin;
            .prepareRestoreSnapshot(drSnapshotRepo, snapshotName)
        assertAllFormatDirsHaveFiles(shardFinal);
        RestoreSnapshotResponse restore1 = client.admin()
        IndexShard shardPreSnap1 = getShardZero(indexName);
        }
            }
     * {@code request.indices().length == 0} is part of the V2 gate in
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName)).get());
                return java.nio.file.FileVisitResult.CONTINUE;
        internalCluster().startDataAndWarmNodes(1);
        String snapshotRepoName = "test-snapshot-repo";
        // Take V2 snapshot
            IndexShard shardBefore = getShardZero(indexName);
        ByteSizeValue cacheSize = new ByteSizeValue(16, ByteSizeUnit.GB);
        indexDocuments(client, indexA, 0, numDocsA);
        ensureGreen(indexName);
     * Mirrors {@code DataFormatAwareReplicationBaseIT.assertAllFormatDirsHaveFiles}.
        }
        AcknowledgedResponse cloneResponse = client.admin()
            .setIndices(indexName)
        flush(indexName);
     */
     * Two sequential V2 snapshots with intervening writes; both must be independently restorable.
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardR1);
        refresh(indexName);
        Settings indexSettings = getIndexSettings(1, 0).build();
                    + postRestoreWriterGens,
import java.util.ArrayList;
        refresh(sourceIndex);
        final int numDocs = 12;
        assertEquals("no shards may fail to restore", 0, restoreResponse.getRestoreInfo().failedShards());
    public void testV2CloneSnapshotForDFA() throws Exception {
        // ─── Pre-snapshot assertions: DFA layout is correct ────────────────
    private static final String BASE_REMOTE_REPO = "test-rs-repo" + TEST_REMOTE_STORE_REPO_SUFFIX;
        assertLuceneIndexDirContents(shardBBefore);
import org.junit.Before;
     */
        logger.info("--> taking V2 snap1 at {} docs", docsBeforeSnap1);
        // Create alternate repos pointing at the SAME underlying paths (read-only views)
        assertDocCountInIndex(client, indexName, initialDocs);
            restoredGen = ref.get().getGeneration();
        assertEquals(1, s2.successfulShards());
            .prepareRestoreSnapshot(snapshotRepoName, snap2)
    public void testV2HotDFASnapshotRestoreLifecycle() throws Exception {
        assertAllFormatDirsHaveFiles(shardAfter);
        assertFalse(indexExists(indexName));
            .put(rmd.settings())
        final Set<String> catalogFilesExcludingSegments;
        assertEquals(RestStatus.OK, restoreResponse.status());
     *
     * preserved and restored. Catches cross-index corruption (e.g., catalog files from index A
     * <strong>DFA-specific test:</strong> validates that Lucene segments' DFA-specific
        ensureGreen(indexName);
                fileCache.clear();
        createIndex(sourceIndex, indexSettings);
     * </ul>
            restoreResponse.getRestoreInfo().totalShards(),
            .setWaitForCompletion(true)
        String restoredIndexName,
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        assertEquals(0, restoreResponse.getRestoreInfo().failedShards());
            .prepareRestoreSnapshot(repoName, snap1)
        Client client = client();
        final int numDocsA = 7;
        assertAllFormatDirsHaveFiles(shardPreSnap1);
                .getCatalogSnapshot()
            .getIndex(indexName)
            createIndex(indexName, getIndexSettings(1, 0).build());
        indexDocuments(client, sourceIndex, 0, numDocs);
        return state.nodes().get(nodeId).getName();
        // 3 batches × refresh+flush → multiple segments with distinct writer_generations
        // ─── Invalid request 2: try to change segment.repository ───
        long catalogGen;
    /**
        if (Files.exists(indexDir)) {
        final int numDocs = 10;
        final int numDocs = 10;
                .setIndices(indexName)
        // Block finalization, fire snapshot, wait for block, then unblock to fail it
        assertFalse(indexExists(indexName));
     * Mirrors {@code DeleteSnapshotV2IT.keepPinnedTimestampSchedulerUpdated} but uses
            if (preGen == null) continue;
        Client client = client();
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
                + " extra="
        String uuid = client.admin().indices().prepareGetSettings(indexName).get().getSetting(indexName, IndexMetadata.SETTING_INDEX_UUID);
    /**
        logger.info("Snapshot Path [{}]", absolutePath1);
     * <strong>DFA-specific test:</strong> verifies that the DFA catalog generation is preserved
     * and only ONE repo cluster-wide can have {@code shallow_snapshot_v2=true}. So the test
        createIndex(indexName, indexSettings);
            preSnapshotWriterGens.values().stream().anyMatch(java.util.Objects::nonNull)
     * </ul>
     */
import java.util.stream.Collectors;
        ensureGreen(indexA, indexB);
import org.opensearch.indices.replication.common.ReplicationType;
    private String nodeNameForShard(ClusterState state, String indexName, int shardId) {
        // Repo must contain only the successful retry snapshot
        org.opensearch.snapshots.SnapshotRestoreException ex1 = expectThrows(
            .getSetting(indexName, IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey());
        RestoreSnapshotResponse restoreResponse = client.admin()
     * Resolve the node name hosting the primary of a given shard.
        unblockNode(snapshotRepoName, clusterManagerNode);
        String indexName = "dfa-writergen-attr";
        flush(indexName);
        refresh(indexName);
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName)).get());
        RestoreSnapshotResponse r1 = client.admin()
        assertDocCountInIndex(client, indexA, numDocsA);
     * End-to-end snapshot V2 + restore test for a DFA (parquet primary, lucene secondary) index.
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        assertThat(snapshotInfo.totalShards(), equalTo(numShards));
        SnapshotInfo s1 = createSnapshot(repoName, snap1, new ArrayList<>());
        });
        ensureGreen(indexName);
                .setWaitForCompletion(true)
        // Catalog files (excluding segments_N) must match EXACTLY
     */
        flush(indexA);
            clusterManagerName
        String snapshotName = "test-v2-snapshot";
            assertLuceneIndexDirContents(shardAfter);
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName)).get());
                postGen
    /**
                }
        indexDocuments(client, indexName, 0, numDocs);
import java.util.concurrent.TimeUnit;
        indexDocuments(client, indexB, 0, numDocsB);
        refresh(indexName);
        String snapshotName = "snap-cleanup";
            .prepareRestoreSnapshot(repoName, snap2)
    }
        // V2 snapshot must contain BOTH indices
                    }
    }
        flush(indexName);
        assertEquals(snapshotName, snapshotsBefore.get(0).snapshotId().getName());
        Set<String> snapshotNames = new HashSet<>();
        Path repoPath = randomRepoPath().toAbsolutePath();
            String suffix = pathType.toString().toLowerCase(java.util.Locale.ROOT);
        refresh(indexName);
        assertDocCountInIndex(client, indexName, totalAtSnap2);
        assertDocCountInIndex(client, indexName, totalDocs);
     *   <li>The snapshot is no longer listed after deletion</li>
     *   <li>Restored index reaches green health</li>
        createIndex(indexName, getIndexSettings(1, 0).build());
    private static Set<String> diff(Set<String> a, Set<String> b) {
    @Override
    /**
     * Used to verify file restoration after V2 restore.
        String snapshotRepoName = "test-settings-repo";
    protected Settings.Builder getRepositorySettings(String sourceRepository, boolean readOnly) throws ExecutionException,
            pre.segmentCount,
        internalCluster().startClusterManagerOnlyNode();
            .cluster()
        // Configure aggressive pinned-timestamp release so cleanup can fire promptly
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            .setIndices(indexName)
    /**
        Settings indexSettings = getIndexSettings(numShards, 0).build();
        // Post-restore #1 validations
        Settings.Builder settingsBuilder = Settings.builder()
            .get();
        long segmentFilesBefore = countFilesUnder(remoteRepoPath, indexUUID, "segments");
    public void testV2InvalidRestoreRequestForDFAIndex() throws Exception {
 * compatible open source license.
        assertTrue("snapshot must NOT be listed after deletion, got: " + snapshotsAfter, snapshotsAfter.isEmpty());
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numOfReplicas)
        assertEquals("multi-index 1-shard each: snapshot must report exactly 2 successful shards", 2, snapshotInfo.successfulShards());
     * </ol>
        String snapshotRepoName = "test-clone-gen-repo";
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardFinal);
     * </ul>
            if (Files.exists(fmtDir)) {
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        final long docCount;
        internalCluster().startDataAndWarmNodes(2); // 2 data nodes so 3 shards distribute
                + missing
        logger.info("--> taking V2 snapshot of all DFA indices");
        assertFalse(indexExists(indexName));
        String snapshotRepoName = "test-rename-repo";
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName, new ArrayList<>());
    public void teardown() {
        );
        createIndex(indexName, indexSettings);
        RepositoryMetadata rmd = res.repositories().get(0);
     * V2 snapshot of a DFA index with <strong>zero documents</strong>. Edge case — does V2 handle
            .setWaitForCompletion(true)
     */
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName, new ArrayList<>());
        // Capture exhaustive pre-snapshot state for tight post-restore comparison
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
        assertFalse(indexExists(indexName));
        assertThat(snapshotInfo.successfulShards(), equalTo(numShards));
     * format mapping.
        ) {
     */
        Settings indexSettings = getIndexSettings(1, 0).build();
                .setIndexSettings(disableRemoteStore)
        }
        assertTrue(
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
    }
            .put("index.pluggable.dataformat.enabled", true)
        // Capture exhaustive pre-failure state for assertion that source is unaffected by failed snapshot
            missing.isEmpty()
        ensureGreen(indexName);
import java.io.IOException;
        ensureGreen(indexName);
        Settings indexSettings = getIndexSettings(1, 0).build();
        ensureGreen(indexName);
        expectThrows(
        String indexName = "dfa-rapid-snap";
        ensureGreen(indexName);
            .setRenamePattern(sourceIndex)
            .get();
     * Validates that DFA's format-aware remote directory routing works under HASHED_PREFIX,
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        ensureGreen(indexName);
     */
}
        // ─── Invalid request 3: try to change translog.repository ───
        Path indexDir = shard.shardPath().resolveIndex();
        // Test all three path types in sequence.
        // Clone the snapshot — V2 requires wildcard pattern "*" for indices
    /**
        assertNotEquals("restored index always has a fresh UUID, not the source UUID", pre.indexUUID, restoredUuid);
        RestoreSnapshotResponse restoreResponse = client.admin()
        if (WRITABLE_WARM_INDEX_SETTING.get(settings)) {
        // Take V2 snapshot
        String indexName = "dfa-fail-finalize";
     *
            .get()
        IndexShard renamedShard = getShardZero(renamedIndex);
            .setIndices(indexName)
        assertEquals(RestStatus.OK, restoreResponse.status());
     * V2 snapshot + clone the snapshot + restore from clone for a DFA index.
        final int numDocsB = 13;
        assertTrue(indexExists(indexName));
            .cluster()
    public void testV2SnapshotStatusAPIForDFA() throws Exception {
                .get()
        final String snap2 = "snap2-after-more-docs";
import org.opensearch.snapshots.SnapshotState;
        assertEquals("refresh_interval override must take effect on restored index", "5s", actualRefreshInterval);
        IndexShard sourceShard = getShardZero(indexName);
     */
        String drTranslogRepo = "dr-translog-repo";
            assertLuceneIndexDirContents(shardAfter);
        // Take V2 snapshot of empty index
        // ─── DFA-specific: verify source index was NOT corrupted by the failure ───
    }
        // (the actual path includes a path-type prefix like HASHED_PREFIX so we walk the tree).
     * <p>Note: does not use prepareSearch or prepareGet because search is not yet supported
        String sourceSnapshot = "src-snap";
     * <p>This validates the V2 lifecycle: snapshot creation pins a timestamp and writes
        refresh(indexName);
     */
     * Assert the Lucene index/ directory contents match the configured layout:
            String preGen = e.getValue();
    }
                try (var stream = Files.list(fmtDir)) {
        indexDocuments(client, indexName, 0, docsBeforeSnap1);
     */
            RestoreSnapshotResponse restoreResponse = client.admin()
        assertEquals("status API must return one snapshot", 1, statusResponse.getSnapshots().size());
                CompositeDataFormatPlugin.class,
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
    public void testV2RestoreWithUpdatedSettingsForDFA() throws Exception {
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
        Client client = client();
    /**
        Set<String> catalogFiles = DataFormatAwareITUtils.catalogFilesExcludingSegments(shard);
        ensureGreen(indexName);
                .getCatalogSnapshot()
        final int initialDocs = 30;
    private void assertCatalogFilesRestoredOnDisk(IndexShard shardBefore, IndexShard shardAfter) throws IOException {
 * The OpenSearch Contributors require contributions made to
                + filesAfter,
            .get();
        List<SnapshotInfo> snapshotsAfter = client.admin().cluster().prepareGetSnapshots(snapshotRepoName).get().getSnapshots();
        for (int i = fromId; i < toId; i++) {
        for (org.apache.lucene.index.SegmentCommitInfo sci : infos) {
        logger.info("--> taking V2 snap2 at {} docs", totalDocs);
    }
        assertEquals("rename: snapshot has exactly 1 shard", 1, snapshotInfo.successfulShards());
        // Wait for cleanup to drain ALL format directories to zero for this index UUID.
        );
        }
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName)
            String genAttr = sci.info.getAttribute(org.opensearch.be.lucene.index.LuceneWriter.WRITER_GENERATION_ATTRIBUTE);
        String snapshotRepoName = "test-snapshot-repo";
        SnapshotInfo retryInfo = createSnapshot(snapshotRepoName, "snap-retry-success", new ArrayList<>());
import org.opensearch.snapshots.AbstractSnapshotIntegTestCase;
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
    private int countSegmentsOnShard(Client client, String indexName) {
     */
        String actualRefreshInterval = client.admin()
        // Take V2 snapshot
        assertDocCountInIndex(client, indexName, totalAtSnap2);
            .collect(java.util.stream.Collectors.toSet());
                    .get()
     * fires snapshots back-to-back with no delay and verifies both succeed without races.
     */
        // Delete the source index so we can attempt restore
            .cluster()
        try (var stream = Files.list(indexDir)) {
            .setWaitForCompletion(true)
        RestoreSnapshotResponse restore2 = client.admin()
    /**
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardPreSnap1);
        String indexName = "dfa-invalid-restore";
        assertEquals(RestStatus.OK, restoreResponse.status());
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName)).get());
            assertAcked(
        }, 120, TimeUnit.SECONDS);
        final int numShards = 3;
    }
     * indexing and is required by DFA to correlate Lucene segments with the corresponding
                .prepareRestoreSnapshot(snapshotRepoName, snapshotName)
            "doc count mismatch for index " + indexName + " (expected " + expectedCount + ", got " + actualCount + ")",
        Client client = client();
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName)).get());
     * <p>Validates that the V2 cluster-manager-only flow snapshots ALL existing indices when
        Settings indexSettings = getIndexSettings(1, 0).build();
        assertThat(s1.state(), equalTo(SnapshotState.SUCCESS));
import java.nio.file.Files;
     *   <li>Per-shard pinned-timestamp scoping issues</li>
        // ─── Verify a subsequent VALID restore still works ───
            org.opensearch.snapshots.SnapshotRestoreException.class,
    public void testV2SnapshotWithMultipleShardsForDFA() throws Exception {
    /**
            org.opensearch.common.concurrent.GatedCloseable<org.opensearch.index.engine.exec.coord.CatalogSnapshot> ref = sourceShardAfter
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName, new ArrayList<>());
        Settings changeTranslogRepo = Settings.builder().put(SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "different-translog-repo").build();
        // Doc count must be EXACT
            .indices()
    private void assertDocCountInIndex(Client client, String indexName, long expectedCount) {
                for (Path part : file) {
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName)
        createIndex(indexName, indexSettings);
        long[] count = { 0 };
     * @param requireSameUUID true if the restored index keeps the original UUID (typical case);
            .put("index.pluggable.dataformat", "composite")
        remoteRepoPath = randomRepoPath().toAbsolutePath();
    }
        // Index a meaningful number of docs so each shard gets some
            .put(super.indexSettings())
            flush(indexName);
        createIndex(indexName, indexSettings);
     * <strong>DFA-specific test:</strong> verify that ALL format directories ({@code segments/},
        String snapshotRepoName = "test-snapshot-repo";
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName)).get());
        );
        final int numDocs = 60;
        String snapshotName = "snap-status";
        assertTrue("primary for shard " + shardId + " must be assigned", nodeId != null);
        Client client = client();
            .setWaitForCompletion(true)
        refresh(indexName);
     */
        Settings changeSegmentRepo = Settings.builder().put(SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "different-repo").build();
        // Take source V2 snapshot
        );
            String indexName = "dfa-pathtype-" + suffix;
                "pinned-timestamp scheduler should fire after invocation",
                + catalogBefore
            org.opensearch.snapshots.SnapshotRestoreException.class,
            String id = Integer.toString(i);
        ensureGreen(indexName);
        return Arrays.<Object[]>asList(new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), false).build() });
                .prepareRestoreSnapshot(snapshotRepoName, snapshotName)
        IndexShard shardBefore = getShardZero(indexName);
     * Two V2 snapshots fired in rapid sequence on the same repository. V2 design serializes
        }
     * Validates pinned-timestamp inheritance through clones.
        long sourceGen;
        internalCluster().startDataAndWarmNodes(1);
                    if (indexUUID.equals(name)) {
     * Path-type-agnostic: works with FIXED, HASHED_PREFIX, and HASHED_INFIX layouts.
        assertRestoredIndexMatches(client, renamedIndex, renamedShard, pre, /* requireSameUUID */ false);
                + diff(restoredCatalog, pre.catalogFilesExcludingSegments),
        final int numDocs = 15;
        // Phase 2: index M more docs, take snap2
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
        assertAcked(cloneResponse);
        internalCluster().startClusterManagerOnlyNode();
            logger.info("--> restoring V2 snapshot for pathType={}", pathType);
        for (int batch = 0; batch < 3; batch++) {
        String snap1 = "rapid-snap-1";
        assertTrue(
        createIndex(indexName, indexSettings);
        String snap2 = "rapid-snap-2";
        ensureGreen(sourceIndex);
     */
        var resp = client.admin().indices().prepareSegments(indexName).get();
        String snapshotRepoName = "test-fail-finalize-repo";
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName)).get());
        // Take V2 snapshot
                }
    /**
        logger.info("--> restoring V2 snap2");
            if ("lucene".equals(format)) continue;
/*
import java.util.HashMap;
     * <ul>
        }
     * <p>Validates V2 snapshot lifecycle for DFA:
        assertDocCountInIndex(client, indexName, finalTotal);
    /**
        IndexShard shardBBefore = getShardZero(indexB);
                    + preGen
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shard);
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), false)
        for (SnapshotInfo s : snapshots) {
            .prepareGetSettings(indexName)
import java.util.HashSet;
        long docs = client.admin().indices().prepareStats(indexName).clear().setDocs(true).get().getIndex(indexName).getPrimaries().docs
        internalCluster().startClusterManagerOnlyNode();
        assertEquals("retry snapshot must include exactly the DFA index", List.of(indexName), retryInfo.indices());
            long catalogGeneration,
            // Clean up so the next iteration can register a new repo with shallow_snapshot_v2=true
    /**
        internalCluster().startDataAndWarmNodes(1);
        // After restore, the index should be writable — index a doc to confirm
        // Create snapshot repo with V2 enabled
        assertEquals("snapshot must contain exactly the DFA index", List.of(indexName), snapshotInfo.indices());
    /**
        logger.info("--> restoring with rename: {} -> {}", sourceIndex, renamedIndex);
    /**
        // Ingest more on the restored index — proves indexing works post-restore
    }
        ) {
        String snapshotName = "test-v2-delete";
        // Source index can stay; we rename on restore
        // For DFA this MUST include any per-format dirs; we walk the entire indexUUID subtree.
        assertFalse("pre-snapshot index UUID must be non-empty", uuid.isEmpty());
            assertEquals("snap=" + snap, 0, restoreResponse.getRestoreInfo().failedShards());
        String drSnapshotRepo = "dr-snapshot-repo";
import org.opensearch.core.common.unit.ByteSizeUnit;
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName)).get());
            .indices()
        // Restore snap1 — must yield EXACTLY docsBeforeSnap1 (no leak from snap2)
     *
        return Set.of("parquet", "lucene");
        }
        // ─── Invalid request 1: try to disable remote_store on restore ───
        );
            10,
        String renamedIndex = "dfa-rename-restored";
            restoredShard.store().directory()
    private void indexDocuments(Client client, String indexName, int numOfDocs) {
                // breaks on Windows where the separator is '\\', and also matches non-component substrings.
import java.util.Set;
     * DFA-specific setting overrides too.
            );
                .setIndices(indexName)
            assertEquals("pathType=" + pathType + " single-shard exactly 1 successful", 1, snapshotInfo.successfulShards());
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        }
        final int docsAfterSnap1 = 12;
        String drSegmentRepo = "dr-segment-repo";
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
     *   <li>Format-aware remote directory routing issues at multi-shard scale</li>
            .get();
            assertDocCountInIndex(client, indexName, numDocs);
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName)
            .setWaitForCompletion(true)
        String indexName = "dfa-status-api";
        // No documents indexed. Force a flush to materialize an empty commit point.
            Path fmtDir = shard.shardPath().getDataPath().resolve(format);
import org.opensearch.snapshots.SnapshotInfo;
        assertEquals(RestStatus.OK, r1.status());
        }
        awaitNumberOfSnapshotsInProgress(1);
        // with data, hence no writer_generation attributes to validate.
        // EVERY restored shard must have intact DFA layout — catches per-shard corruption
     * shard inspection (catalog snapshot, on-disk format dirs, remote store listing).
                .setIndices(indexName)
        return getIndexShard(node, new ShardId(resolveIndex(indexName), 0), indexName);
        assertAllFormatDirsHaveFiles(shardAfter);
        // Restore using the DR repos
            missingDataFiles.isEmpty()
            .get();
            preState.catalogFilesExcludingSegments,
        assertThat(source.state(), equalTo(SnapshotState.SUCCESS));
            .cluster()
        ensureGreen(indexName);
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName, new ArrayList<>());
            .cluster()
        IndexShard restoredShard = getShardZero(indexName);
            .setWaitForCompletion(true)
            ensureGreen(indexName);
            .get();
        internalCluster().startDataAndWarmNodes(1);
            .get();
        assertEquals(
            assertDocCountInIndex(client, indexName, numDocs);
        ensureGreen(indexName);
            final int numDocs = 10;
        assertEquals(
        // ─── Take V2 snapshot ──────────────────────────────────────────────
        SnapshotInfo info2 = createSnapshot(snapshotRepoName, snap2, new ArrayList<>());
        String snapshotName = "snap-empty";
            ex1.getMessage().toLowerCase(java.util.Locale.ROOT).contains("remote_store")
            assertDocCountInIndex(client, indexName, numDocs);
        String clonedSnapshot = "snap-cloned";
        SnapshotInfo s2 = createSnapshot(repoName, snap2, new ArrayList<>());
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        RestoreSnapshotResponse restoreResponse = client.admin()
            .setIndices(indexName)
            .put(remoteStoreClusterSettings(BASE_REMOTE_REPO, remoteRepoPath))
import java.nio.file.Path;
        assertAllFormatDirsHaveFiles(restoredShard);
        assertLuceneIndexDirContents(shardABefore);
    public void testV2SnapshotCreateAndRestoreForDFAIndex() throws Exception {
            translogFilesBefore > 0
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
        assertEquals(RestStatus.OK, restoreResponse.status());
     * V2 snapshot + restore with different {@code RemoteStoreEnums.PathType} settings.
        internalCluster().startClusterManagerOnlyNode();
                .prepareRestoreSnapshot(snapshotRepoName, snap)
import org.opensearch.be.datafusion.DataFusionPlugin;
                .prepareRestoreSnapshot(snapshotRepoName, snapshotName)
                    .prepareUpdateSettings()
        Settings disableRemoteStore = Settings.builder().put(SETTING_REMOTE_STORE_ENABLED, false).build();
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(sourceShardAfter);
     * <p>Mirrors the rename pattern from
    public void testV2RestoreWithRenameForDFA() throws Exception {
        String indexA = "dfa-multi-a";
     */
     *   <li>Pinned-timestamp release for snap2 doesn't delete files still referenced by snap1</li>
        for (org.apache.lucene.index.SegmentCommitInfo sci : infosAfter) {
            .setWaitForCompletion(true)
        Settings indexSettings = getIndexSettings(1, 0).build();
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
        return count[0];
        final int docsBeforeSnap1 = 8;
            .put(SYSTEM_REPOSITORY_SETTING.getKey(), false);
        PreSnapshotState pre = capturePreSnapshotState(client, indexName, shardBefore);
     * <ul>
                sci.info.name,
            .setIndices(indexName)
        long restoredGen;
        );
            catalogGen = ref.get().getGeneration();
        }
 * SPDX-License-Identifier: Apache-2.0
        assertLuceneIndexDirContents(shardAfterSnap2);
     * {@link org.opensearch.snapshots.SnapshotsService} (~line 293).
        // ── Delete and restore from snap2 (the LATER snapshot, larger doc set) ─
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName, new ArrayList<>());
     * and {@code translog/}; for DFA there could be additional format files that bug-prone
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
        logger.info("--> taking V2 snapshot for DR test");
            IndexShard shardAfter = getShardZero(indexName);
        assertAllFormatDirsHaveFiles(shardBefore);
            .setIndices(indexName)
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING;
        r.removeAll(b);
     * <ul>
        // Create two DFA indices with distinct doc counts so we can detect data crossover
     * </ul>
        indexDocuments(client, indexName, 0, 1);
        internalCluster().startClusterManagerOnlyNode();
            ensureGreen(indexName);
        AcknowledgedResponse deleteResponse = client.admin().cluster().prepareDeleteSnapshot(snapshotRepoName, snapshotName).get();
     * cluster-manager metadata; deletion must release that pin and clean up metadata.
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "300s")
            .setSourceRemoteTranslogRepository(drTranslogRepo)
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
     * surface in the create/restore flow.
            Stream.of(
        assertAllFormatDirsHaveFiles(shardAfter);
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName)
            org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse> snapshotFuture = startFullSnapshot(
        assertEquals(1, s1.successfulShards());
        Settings indexSettings = getIndexSettings(1, 0).build();
            assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName)).get());
            String indexUUID
                .setWaitForCompletion(true)
            super.nodePlugins().stream(),
     * (or advanced) when a V2 snapshot is cloned and restored from the clone. Catalog generation
        flush(indexName);
import org.opensearch.node.remotestore.RemoteStorePinnedTimestampService;
        Map<String, String> preSnapshotWriterGens = new HashMap<>();
        return List.of("lucene");
        createIndex(indexA, indexSettings);
    private void assertAllFormatDirsHaveFiles(IndexShard shard) throws IOException {
        flush(indexName);
import java.util.List;
        GetRepositoriesResponse res = client().admin().cluster().getRepositories(gr).get();
     * <p>Mirrors {@code RestoreShallowSnapshotV2IT.testHashedPrefixTranslogMetadataCombination}.
            public java.nio.file.FileVisitResult visitFile(Path file, java.nio.file.attribute.BasicFileAttributes attrs) {
            @Override
     * <p>Catches:
            .setIgnoreIndexSettings(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey())
            restoredGen >= pre.catalogGeneration
     */
        PreSnapshotState(
        final long catalogGeneration;
            .setIndices(indexName)
                    + " pre-snapshot but is missing post-restore. post-restore segs: "
     * End-to-end V2 snapshot lifecycle for a hot DFA index, validating that indexing + refresh +
    }
        ensureGreen(indexName);
        return iter.next().getSegments().size();
        createIndex(indexName, indexSettings);
            .getPrimaries().docs.getCount();
        return settingsBuilder;
            files = stream.map(p -> p.getFileName().toString()).collect(java.util.stream.Collectors.toSet());
     * Set of formats this test's index uses. Matches the index settings:
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName)
        internalCluster().startDataAndWarmNodes(1);
            .prepareStats(indexName)
        refresh(indexName);
        assertTrue("source index must still exist", indexExists(sourceIndex));
    private Set<String> expectedFormats() {
    }
            .getSetting(indexName, IndexMetadata.SETTING_INDEX_UUID);
        }
                .getCatalogSnapshot()
        var indexSegs = resp.getIndices().get(indexName);
        for (String f : catalogBefore) {
     */
        assertEquals(
        return settingsBuilder;
        assertAllFormatDirsHaveFiles(shardAfterDelete);
    /**
        // ─── After all failures: verify NO partially-restored index exists ───
     * Tight post-restore validation. Asserts the restored index matches the captured pre-snapshot
        assertEquals("status doneShards must be 1", 1, status.getShardsStats().getDoneShards());
package org.opensearch.composite;
    }
        indexDocuments(client, indexName, 0, numDocs);
            "restored catalog generation must be >= pre-snapshot: pre=" + pre.catalogGeneration + " post=" + restoredGen,
     * <p>Validates that DFA's format-aware remote directory factory still resolves files
        assertDocCountInIndex(client, indexName, numDocs);
        logger.info("--> taking V2 snapshot of empty DFA index");
        keepPinnedTimestampSchedulerUpdated();
                "parquet-only: index/ must have only segments_N (and write.lock), got extra: " + nonSegmentsFiles,
        SnapshotInfo snapInfo2 = createSnapshot(snapshotRepoName, snap2, new ArrayList<>());
    public void testV2EmptyIndexSnapshot() throws Exception {
        }
        final int numDocs = 15;
     */
     * state EXACTLY on doc count, segment count, and catalog file set; the catalog generation must
        assertEquals(RestStatus.OK, restoreResponse.status());
            }
     *   <li>Catalog files match local store and remote store on the restored shard</li>
        internalCluster().startDataAndWarmNodes(1);
            .get();
            .prepareGetSettings(indexName)
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
     * index UUID correctly (file paths, catalog, remote directory routing all use the new UUID).
            flush(indexName);
        assertDocCountInIndex(client, indexName, numDocs);
        RestoreSnapshotResponse restoreResponse = client.admin()
        // Delete the source index and restore from CLONE
    /**
            int segmentCount,
     * <p>Pre-snapshot assertions:
            .setIndices(indexName)
        Settings indexSettings = getIndexSettings(1, 0).build();
        createIndex(indexName, indexSettings);
            }
        assertEquals(RestStatus.OK, restore1.status());
                .prepareRestoreSnapshot(snapshotRepoName, snapshotName)
        logger.info("--> taking V2 snapshot of multi-shard DFA index");
     * <strong>DFA failure handling test:</strong> verify that invalid restore requests for a
        }
     *   <li>Restored doc count matches</li>
        assertTrue(
        refresh(indexName);
        assertAcked(deleteResponse);
        return all;
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
    @Override
            .put(super.nodeSettings(nodeOrdinal))
            try (var stream = Files.list(dir)) {
        Settings indexSettings = getIndexSettings(1, 0).build();
        assertAllFormatDirsHaveFiles(shardAfterSnap1);
                + " extra="
            .get();
    }
            .prepareRestoreSnapshot(snapshotRepoName, clonedSnapshot)
        IndexShard shardAfter = getShardZero(indexName);
import org.opensearch.common.unit.TimeValue;
import org.opensearch.index.IndexModule;
            org.opensearch.common.concurrent.GatedCloseable<org.opensearch.index.engine.exec.coord.CatalogSnapshot> ref = restoredShard
        PreSnapshotState pre = capturePreSnapshotState(client, sourceIndex, sourceShard);
     * Walk the entire {@code rootPath} subtree and count files whose path contains the given
    }
     *
     * <p>Validates DFA refresh/flush concurrency under V2 timestamp-pinning and that both
        assertEquals(0, restoreResponse.getRestoreInfo().failedShards());
        assertEquals(RestStatus.OK, restoreResponse.status());
            .filter(f -> f.startsWith("segments_") == false && f.equals("write.lock") == false)
            "catalog files missing from restored shard disk: "
        // DFA on-disk layout intact
        logger.info("--> taking source V2 snapshot");
                .cluster()
        createRepository(drSegmentRepo, "fs", getRepositorySettings(BASE_REMOTE_REPO, true));
        assertEquals(0, snapshotInfo.failedShards());
        InterruptedException {
        assertAllFormatDirsHaveFiles(shardAAfter);
            this.docCount = docCount;
        ensureGreen(indexName);
        logger.info("--> taking V2 snapshot of source");
        IndexShard sourceShardBefore = getShardZero(indexName);
        return r;
        try (
    }
     * catalog/segments invariants hold across two restore cycles:
        assertEquals(RestStatus.OK, restoreResponse.status());
        flush(indexName);
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName, new ArrayList<>());
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        );
            for (var node : nodes) {
     * <p>The index is created and immediately snapshotted (no indexing, no flush). The snapshot
        assertEquals(0, restoreResponse.getRestoreInfo().failedShards());
            catalogAfter
     *   <li>parquet-only: index/ has only segments_N (and possibly write.lock); no segment data</li>
            restoredCatalog
        assertLuceneIndexDirContents(shardAfterSnap1);
        assertLuceneIndexDirContents(sourceShardAfter);
        // Post-restore #2 validations — must reflect snap2 (totalAtSnap2 docs)
        IndexShard shardAfter = getShardZero(indexName);
        }
        internalCluster().startDataAndWarmNodes(1);
        flush(indexName);
        assertBusy(
     *
        Client client = client();
            .prepareGetSettings(restoredIndexName)
     *                        false for rename tests where a new UUID is expected.
        final int numDocs = 15;
        assertEquals("snapshot total shards must equal successful shards", snapshotInfo.successfulShards(), snapshotInfo.totalShards());
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardAAfter);
            restoredGen = ref.get().getGeneration();
     *
     * <p>Mirrors {@code ConcurrentSnapshotsV2IT.testCreateSnapshotFailInFinalize} but adds
            () -> client.admin()
        SnapshotInfo snapInfo1 = createSnapshot(snapshotRepoName, snap1, new ArrayList<>());
            "DFA catalog files must be unchanged after failed V2 snapshot finalize: missing="
            assertEquals("pathType=" + pathType, RestStatus.OK, restoreResponse.status());
 */
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
     */
    }
        // for DFA's per-format file lifecycle.
     * <p>Mirrors {@code RestoreShallowSnapshotV2IT.testInvalidRestoreRequestScenarios} but exercises
        }
     *
        assertEquals(RestStatus.OK, restore2.status());
    }
        indexDocuments(client, indexName, 0, numDocs);
            snapshotNames.add(s.snapshotId().getName());
            .cluster()
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName)
        try (
     *   <li>Catalog files from one shard leaking into another shard's restored state</li>
     * correctly when the restore is configured with different repo names than were used
        // Tight post-restore validation: doc count, segment count, catalog files, generation, UUID, on-disk layout
        Client client = client();
    }
        Files.walkFileTree(rootPath, new java.nio.file.SimpleFileVisitor<>() {
     *   <li>Snapshot the now-larger index as {@code snap2}, delete, restore from {@code snap2}.</li>
     * Search isn't supported on DFA indices yet, so we avoid prepareSearch / prepareGet.
        assertDocCountInIndex(client, restoredIndexName, pre.docCount);
        );
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        Set<String> missingDataFiles = new HashSet<>();
        ensureGreen(indexName);
        assertDocCountInIndex(client, indexName, preState.docCount);
            ),
     *
    }
            preSnapshotWriterGens.put(sci.info.name, genAttr);
            org.opensearch.common.concurrent.GatedCloseable<org.opensearch.index.engine.exec.coord.CatalogSnapshot> ref = restoredShard
            .setIndices(indexA, indexB)
import org.opensearch.parquet.ParquetDataFormatPlugin;
        ensureGreen(indexName);
            assertAllFormatDirsHaveFiles(shardAfter);
                    .setPersistentSettings(Settings.builder().put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), pathType))
        String indexUUID = client.admin()
            assertAllFormatDirsHaveFiles(shard);
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardBBefore);
            pre.catalogFilesExcludingSegments,
    protected boolean hasLuceneSecondary() {
        Client client = client();
            assertAllFormatDirsHaveFiles(shard);
    }
     * because remote-store cleanup is async and timing-sensitive).
        assertLuceneIndexDirContents(shardAfter);
    }
                sci.info.getAttribute(org.opensearch.be.lucene.index.LuceneWriter.WRITER_GENERATION_ATTRIBUTE)
            .setWaitForCompletion(true)
        assertAllFormatDirsHaveFiles(shardAfterPhase2);
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardAfter);
import org.opensearch.common.settings.Settings;
    /**
        final int totalAtSnap2 = initialDocs + phase2Docs;
     *
            .get()
        for (String format : expectedFormats()) {
                var fileCache = node.fileCache();
        // Verify both snapshots exist in the repo
    }
     *   <li>Snapshot creation succeeds</li>
     * V2 snapshot of multiple DFA indices in a single snapshot, then restore all.
     * <p>V2 path is triggered by passing an empty indices list to createSnapshot:
        // Original index uses 300s refresh
        assertThat("snap2 state", info2.state(), equalTo(SnapshotState.SUCCESS));
    /**
    /**
     * <em>alternate</em> snapshot/segment/translog repositories that point at the same
        Set<String> files;
        // Fire two V2 snapshots back-to-back on the same repo
            .prepareRestoreSnapshot(snapshotRepoName, snap1)
        ensureGreen(indexName);
     * independently preserved and restored.
        SnapshotInfo source = createSnapshot(snapshotRepoName, sourceSnapshot, new ArrayList<>());
        Settings indexSettings = getIndexSettings(1, 0).build();
     * Whether lucene is configured as a secondary format. Drives format-aware on-disk assertions.
        // a secondary format. For parquet-only configurations there are no Lucene segments
     */
            .cluster()
     *
        assertEquals("snap1 single-shard exactly 1 successful", 1, info1.successfulShards());
        internalCluster().startDataAndWarmNodes(1);
        assertEquals(0, restoreResponse.getRestoreInfo().failedShards());
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
     * Subclasses (e.g. {@code DataFormatAwareRestoreShallowSnapshotV2WithLuceneIT}) override
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
            settingsBuilder.put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName)
        Client client = client();
        GetRepositoriesRequest gr = new GetRepositoriesRequest(new String[] { sourceRepository });
            Path dir = shard.shardPath().getDataPath().resolve(format);
        assertDocCountInIndex(client, sourceIndex, numDocs);
        String nodeId = state.routingTable().index(indexName).shard(shardId).primaryShard().currentNodeId();
    /**
        blockClusterManagerFromFinalizingSnapshotOnIndexFile(snapshotRepoName);
        // Restore from each, verify both work
    /**
     */
            String snapshotRepoName = "snap-repo-" + suffix;
        // Verify snapshot is no longer listed
     * {@code writer_generation} attribute survives V2 snapshot/restore. This attribute is
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardAfter);
        // Delete the index AND the snapshot
        assertEquals(RestStatus.OK, restoreResponse.status());
    }
        // Tight validation: renamed index gets a NEW UUID but matches source on docs/segments/catalog
        assertAcked(client().admin().indices().prepareDelete(indexName));
        if (shardSegs == null) return 0;
            .setIndices(indexName)
        Set<String> filesAfterRestore = captureShardFilesOnDisk(shardAfter);
        // V2 allows only ONE repository with shallow_snapshot_v2=true cluster-wide, so we
        org.apache.lucene.index.SegmentInfos infos = org.apache.lucene.index.SegmentInfos.readLatestCommit(sourceShard.store().directory());
        flush(indexB);
        ) {
        assertFalse(indexExists(indexA));
        String indexName = "dfa-clone-snapshot";
        final int numDocs = 10;
            this.catalogGeneration = catalogGeneration;
    protected void indexDocuments(Client client, String indexName, int fromId, int toId) {
        assertAcked(deleteResponse);
            .get();
     * {@code RestoreShallowSnapshotV2IT.testRestoreOperationsShallowCopyEnabled}.
        internalCluster().startDataAndWarmNodes(1);
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shard);
        ClusterState restoredState = client.admin().cluster().prepareState().get().getState();
import org.opensearch.arrow.allocator.ArrowBasePlugin;
     * stamped by {@link org.opensearch.be.lucene.index.LuceneWriterCodec} during initial
        boolean requireSameUUID
        String indexName = "dfa-testindex";
        assertLuceneIndexDirContents(shardAfter);
        ensureYellowAndNoInitializingShards(indexName);
        assertAllFormatDirsHaveFiles(shardR1);
        // Take V2 snapshot
                    stream.forEach(p -> all.add(format + "/" + p.getFileName()));
        // Capture pre-snapshot writer_generation on each Lucene segment
        refresh(indexName);
        flush(sourceIndex);
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        logger.info("--> restoring all indices from V2 snapshot");
     *
        return true;
    public void testV2SnapshotPreservesWriterGenerationAttributeForDFA() throws Exception {
        final int totalDocs = docsBeforeSnap1 + docsAfterSnap1;
        ensureGreen(renamedIndex);
        assertEquals(numShards, restoreResponse.getRestoreInfo().successfulShards());
            )
        String snapshotRepoName = "test-invalid-restore-repo";
                "parquet+lucene-secondary: index/ must have segment data files beyond segments_N, got only: " + files,
                "segment "
        if (shallowCopyEnabled) {
        RestoreSnapshotResponse restoreResponse = client.admin()
        ensureGreen(indexName);
        try (
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
     * DFA index are rejected cleanly with {@link org.opensearch.snapshots.SnapshotRestoreException}
        assertFalse("restored index UUID must be non-empty", restoredUuid.isEmpty());
import org.opensearch.index.IndexSettings;
            "catalog file set must match pre-snapshot exactly: missing="
        assertRestoredIndexMatches(client, indexName, shardAfter, pre, /* requireSameUUID */ true);
     *
        // Doc count restored — uses _stats API, NOT prepareSearch / prepareGet
            assertEquals("translog/ subtree must be cleaned up for indexUUID=" + indexUUID, 0, translogCount);
        internalCluster().startClusterManagerOnlyNode();
     *
        flush(indexName);
    }
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName, new ArrayList<>());
    }
                nonSegmentsFiles.isEmpty()
        for (String snap : new String[] { snap1, snap2 }) {
        Client client,
        assertTrue(
        ensureGreen(indexName);
            createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath, true));
     */
     *   <li>Snapshot is listed by the snapshots API after creation</li>
        final int numDocs = 25;
        // DFA on-disk layout must be reconstructed identically: parquet/ dir + index/ (segments_N + lucene files)
     *   <li>snap1 captures state at N docs, snap2 captures state at N+M docs</li>
        String indexName = "dfa-cleanup-index";
        refresh(indexName);
        Set<String> nonSegmentsFiles = files.stream()
        PreSnapshotState preState = capturePreSnapshotState(client, indexName, sourceShardBefore);
        createIndex(indexB, indexSettings);
        assertEquals("snap2 single-shard exactly 1 successful", 1, info2.successfulShards());
        try (
    }
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(
            org.opensearch.common.concurrent.GatedCloseable<org.opensearch.index.engine.exec.coord.CatalogSnapshot> ref = sourceShard
        assertDocCountInIndex(client, indexName, numDocs);
        String indexB = "dfa-multi-b";
        assertDocCountInIndex(client, indexName, totalDocs);
        // Doc count unchanged
            .setIndices(indexName)
    ) throws IOException {
            "segment count must match pre-snapshot exactly: pre=" + pre.segmentCount + " post=" + restoredSegCount,
    }
        internalCluster().startClusterManagerOnlyNode();
        assertDocCountInIndex(client, indexName, docsBeforeSnap1);
        assertLuceneIndexDirContents(shardAfter);
            logger.info("--> restoring rapid V2 snapshot [{}]", snap);
            genAfter = ref.get().getGeneration();
            .setIndices(indexName)
        assertDocCountInIndex(client, indexName, initialDocs);
     * the restored shard's disk. Validates the restore actually reconstructed the data files,
        flush(indexName);
     */
            indexDocuments(client, indexName, 0, numDocs);
                .get();
        // Pre-delete: remote store must have segment + translog files under the indexUUID subtree.
        Set<String> missing = new HashSet<>();
            .prepareRestoreSnapshot(snapshotRepoName, clonedSnapshot)
        createRepository(repoName, "fs", getRepositorySettings(repoPath, true));
            }
        final int numDocs = 10;
 *
        assertEquals(RestStatus.OK, restoreResponse.status());
    public static Collection<Object[]> parameters() {
                + "\n  before: "
            assertEquals("writer_generation must be preserved across V2 snapshot/restore for segment " + segName, preGen, postGen);
        assertLuceneIndexDirContents(shardBAfter);
            .setSnapshots(snapshotName)
        IndexShard sourceShard = getShardZero(indexName);
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexA, indexB)).get());
            IndexShard shard = getIndexShard(node, new ShardId(resolveIndex(indexName), shardId), indexName);
        ensureGreen(indexName);
        assertBusy(() -> {
        // Phase 1: index N docs, take snap1
        indexDocuments(client, indexName, 0, numDocs);
            .build();
        RestoreSnapshotResponse restoreResponse = client.admin()
        createIndex(indexName, indexSettings);
        assertDocCountInIndex(client, indexName, numDocs);
     * returns no info for the index (e.g., shard not yet ready or special engine state).
            .getSetting(restoredIndexName, IndexMetadata.SETTING_INDEX_UUID);
                + diff(preState.catalogFilesExcludingSegments, catalogAfter)
    }
            actualCount
        // Ingest yet more, refresh, validate — proves indexing still works after second restore
     * the "empty catalog" case correctly?
            "rejection message must mention remote_store: " + ex1.getMessage(),
        String indexName = "dfa-settings-restore";
     *   <li>Doc count via _stats matches what was indexed</li>
import org.opensearch.common.util.FeatureFlags;
        final String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
        internalCluster().startDataAndWarmNodes(1);
    }
        String restoredUuid = client.admin()
        long currentTime = System.currentTimeMillis();
        ).collect(Collectors.toList());
            .cluster()
        internalCluster().startClusterManagerOnlyNode();
            IndexShard shardAfter = getShardZero(indexName);
                missingDataFiles.add(f);
        // Use 'mock' repo type so the test framework can inject failures.
        logger.info("--> taking back-to-back V2 snapshots");
     * <p>Post-restore assertions:
            .cluster()
        );
        if (indexSegs == null) return 0;
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        // no per-shard SnapshotShardsService dispatch)
    }
        assertDocCountInIndex(client, indexName, docsBeforeSnap1);
        assertEquals("snap-retry-success", snapshots.get(0).snapshotId().getName());
        createRepository(drSnapshotRepo, "fs", getRepositorySettings(snapshotRepoName, true));
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardBefore);
        String sourceSnapshot = "snap-source";
public class DataFormatAwareRestoreShallowSnapshotV2IT extends AbstractSnapshotIntegTestCase {
            Path absolutePath = randomRepoPath().toAbsolutePath();
        // Delete the original index
                + "\n  after:  "
            assertAcked(client().admin().cluster().prepareDeleteSnapshot(snapshotRepoName, snapshotName).get());
        IndexShard shardAfterSnap2 = getShardZero(indexName);
     * <ol>
        String node = internalCluster().getDataNodeNames().iterator().next();
     * is a DFA-specific monotonic counter not present in Lucene-only engines.
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
        indexDocuments(client, indexName, docsBeforeSnap1, totalDocs);
     * Validate doc count via _stats API (uses engine's docStats(), not search).
        for (String catalogFile : catalogBefore) {
        }
        clusterAdmin().prepareCleanupRepository(BASE_REMOTE_REPO).get();
    private Set<String> captureShardFilesOnDisk(IndexShard shard) throws IOException {
        flush(indexName);
            .cluster()
        // DFA layout intact
        indexDocuments(client, indexName, initialDocs, totalAtSnap2);
        IndexShard shardR2 = getShardZero(indexName);
     * DR scenario: V2 snapshot a DFA index, delete the original index, then restore using
        ensureGreen(indexName);
    /**
    /**
        String snap2 = "test-v2-snap2";
            .get()
        RestoreSnapshotResponse restoreResponse = client.admin()
        AcknowledgedResponse deleteResponse = client.admin().cluster().prepareDeleteSnapshot(snapshotRepoName, snapshotName).get();
        String indexName = "dfa-multi-shard";
            refresh(indexName);
        IndexShard shardABefore = getShardZero(indexA);
        }
        // Catalog generation must be at least pre-failure (commit may have advanced it slightly during failure handling)
        }
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName, new ArrayList<>());
        String indexName = "dfa-dr-index";
        indexDocuments(client, indexName, 0, numDocs);
            if (filesAfterRestore.contains(f) == false && filesAfterRestore.contains("index/" + f) == false) {
        internalCluster().startClusterManagerOnlyNode();
            assertEquals("segments/ subtree must be cleaned up for indexUUID=" + indexUUID, 0, segCount);
        Client client = client();
        }
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
                + diff(catalogAfter, preState.catalogFilesExcludingSegments),
        Set<String> catalogAfter = DataFormatAwareITUtils.catalogFilesExcludingSegments(sourceShardAfter);
            TimeUnit.SECONDS
import org.opensearch.cluster.metadata.IndexMetadata;
        logger.info("--> restoring from V2 snapshot");
        internalCluster().startClusterManagerOnlyNode();
    private Path remoteRepoPath;
            .setWaitForCompletion(true)
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardR2);
        final String snap1 = "snap1-initial";
            assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName)).get());
        expectThrows(
            .clear()
            restoredGen >= sourceGen
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
import java.util.Arrays;
        assertDocCountInIndex(client, sourceIndex, numDocs);
        assertTrue("V2 snapshot must include " + indexA + ", got: " + snapshotInfo.indices(), snapshotInfo.indices().contains(indexA));
    public void testV2RestoreToDifferentRemoteRepoForDFA() throws Exception {
                if (hasUuid && hasCategory) {
     *   <li>Catalog files match local store and remote store</li>
            .setIndices(sourceIndex)
        RestoreSnapshotResponse r2 = client.admin()
    protected static final class PreSnapshotState {
        Settings.Builder settingsBuilder = randomRepositorySettings();
        final int phase2Docs = 20;
        ensureGreen(indexName);
            assertAllFormatDirsHaveFiles(shardAfter);
        indexDocuments(client, indexName, 0, initialDocs);
            .cluster()
        IndexShard shardBAfter = getShardZero(indexB);
            .setIndices("*")
            .setIndices(indexName)
                .setIndexSettings(changeSegmentRepo)
        indexDocuments(client, indexName, 0, numDocs);
            .put("index.composite.primary_data_format", "parquet")
            // catalog file names may already be format-prefixed (e.g. "parquet/foo.parquet")
                missing.add(catalogFile);
        SnapshotInfo info1 = createSnapshot(snapshotRepoName, snap1, new ArrayList<>());
            .prepareCloneSnapshot(snapshotRepoName, sourceSnapshot, clonedSnapshot)
        } else {
            );
    /** Set difference helper for clearer failure messages. */
        // Delete the snapshot
     * </ul>
import org.opensearch.cluster.ClusterState;
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        Settings indexSettings = getIndexSettings(1, 0).build();
        // status must contain index stats for our index
    public void testV2ConcurrentSnapshotsForDFA() throws Exception {
     *   <li>All format directories (parquet, lucene index/) exist with expected files</li>
        List<SnapshotInfo> snapshotsBefore = client.admin().cluster().prepareGetSnapshots(snapshotRepoName).get().getSnapshots();
        // UUID check: restore always creates a fresh index with a NEW UUID (not the snapshot's source UUID).
        org.opensearch.action.admin.cluster.snapshots.status.SnapshotStatus status = statusResponse.getSnapshots().get(0);
            org.opensearch.common.concurrent.GatedCloseable<org.opensearch.index.engine.exec.coord.CatalogSnapshot> ref = shard
        Set<String> catalogBefore = DataFormatAwareITUtils.catalogFilesExcludingSegments(shardBefore);
     * {@code translog/}, and any DFA-specific format dirs) are cleaned up after V2 snapshot
                    count[0]++;
        indexDocuments(client, indexName, 0, numDocs);
    /**
     *   <li>Restore from snap1 yields exactly N docs (no stale snap2 files leak in)</li>
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardBAfter);
                .get()
    }
    public void testV2CloneSnapshotPreservesCatalogGenerationForDFA() throws Exception {
        return Stream.concat(
     * Snapshots the set of files present on a shard's local disk (parquet/, lucene index/, etc.)
                LucenePlugin.class,
        assertFalse(indexExists(indexName));
                RemoteStorePinnedTimestampService.getPinnedTimestamps().v1() > currentTime
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
    protected Settings nodeSettings(int nodeOrdinal) {
     */
        ) {
            );
        String snapshotRepoName = "test-empty-repo";
        for (int shardId = 0; shardId < numShards; shardId++) {
        String clusterManagerName = internalCluster().getClusterManagerName();
     * Return number of segments on the primary of shard 0. Returns 0 if the segments API
        Settings indexSettings = getIndexSettings(1, 0).build();
        logger.info("--> restoring V2 snapshot via DR repos");
import org.opensearch.plugins.Plugin;
        logger.info("--> deleting V2 snapshot [{}]", snapshotName);
            String snapshotName = "snap-" + suffix;
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName)
        logger.info("--> restoring empty V2 snapshot");
            .indices()
            assertFalse("pathType=" + pathType, indexExists(indexName));
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        createIndex(indexName, indexSettings);
        // The DFA index itself should still be healthy (snapshot deletion does not affect index)
                }
     * Validates the {@code _snapshot/_status} API works for V2 DFA snapshots. The status API
        if (Files.exists(rootPath) == false) return 0;
        assertFalse("catalog before snapshot must not be empty for shard " + shardBefore.routingEntry(), catalogBefore.isEmpty());
            String node = nodeNameForShard(restoredState, indexName, shardId);
        assertDocCountInIndex(client, indexA, numDocsA);
                boolean hasUuid = false;
     * but focuses on the snapshot-API contract (we don't probe internal blob counts here
import java.util.Map;
     */
import static org.opensearch.repositories.blobstore.BlobStoreRepository.SYSTEM_REPOSITORY_SETTING;
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        assertAllFormatDirsHaveFiles(shardR2);
        );
    public DataFormatAwareRestoreShallowSnapshotV2IT(Settings nodeSettings) {
        assertLuceneIndexDirContents(shardAAfter);
        assertThat(snapInfo1.state(), equalTo(SnapshotState.SUCCESS));
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        // Catalog file set unchanged (excluding segments_N which can change due to commit ops)
     * </ul>
        }
        try (
    public void testV2SnapshotFailInFinalizeDoesNotCorruptDFAState() throws Exception {
            .cluster()
        createIndex(indexName, indexSettings);
        );
        // ── Restore from snap1, validate, ingest more, validate, snap2 ─────
            .setIndices(indexName)
            long segCount = countFilesUnder(remoteRepoPath, indexUUID, "segments");
            .get();
        if (iter.hasNext() == false) return 0;
        createIndex(indexName, indexSettings);
            () -> client.admin()
        IndexShard shardAfterSnap1 = getShardZero(indexName);
            this.segmentCount = segmentCount;
    }
        assertLuceneIndexDirContents(restoredShard);
        IndexShard shardAfterDelete = getShardZero(indexName);
     * HASHED_INFIX, and FIXED path types.
            .get();
                .cluster()
        // (a) be set, (b) differ from the pre-snapshot source UUID.
        Settings indexSettings = getIndexSettings(1, 0).build();
     * the indices list is empty, and each index's per-format catalog/files are independently
        );
        logger.info("--> taking V2 snapshot");
        createRepository(drTranslogRepo, "fs", getRepositorySettings(BASE_REMOTE_REPO, true));
        logger.info("--> taking V2 snapshot for delete test");
    }
        assertFalse(indexExists(indexName));
        internalCluster().startClusterManagerOnlyNode();
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardAfterPhase2);
        assertEquals(0, restoreResponse.getRestoreInfo().failedShards());
     */
        // Restore snap2 — must yield totalDocs (newer state)
        Settings indexSettings = getIndexSettings(1, 0).put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "300s").build();
            assertAllFormatDirsHaveFiles(shardBefore);
        // Segment count must be EXACT
     * Each field is exactly comparable to the post-restore state.
                    String name = part.toString();
        String snapshotRepoName = "test-writergen-repo";
            }
        final org.opensearch.common.action.ActionFuture<
                snapshotRepoName,
        assertEquals("snapshot total shards must equal successful shards", snapshotInfo.successfulShards(), snapshotInfo.totalShards());
            assertThat("pathType=" + pathType, snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        );
                .getCatalogSnapshot()
            ensureGreen(indexName);
     * (cluster-manager block injected), the source DFA index must be UNCHANGED — same docs,
                .setIndexSettings(changeTranslogRepo)
        // Pre-snapshot: every shard must have parquet+lucene layout
    }
     *   <li>After second restore: validate everything again, ingest more, refresh, validate.</li>
        indexDocuments(client, indexName, 0, numDocs);
        IndexShard shardFinal = getShardZero(indexName);
        flush(indexName);
        assertEquals(
     * is a different code path than create/restore and may have its own bugs that don't
            assertAcked(client().admin().cluster().prepareDeleteRepository(snapshotRepoName).get());
        assertFalse(indexExists(indexB));
        createIndex(indexName, indexSettings);
    @Override
        List<SnapshotInfo> snapshots = client.admin().cluster().prepareGetSnapshots(snapshotRepoName).get().getSnapshots();
            @Override
    }
     * parquet files. If snapshot/restore drops this attribute, DFA can't reconstruct the
     * {@code assertBusy} to avoid the awaitility dependency (not on classpath here).
    /**
    /**
     * snapshots are independently restorable.
        String snapshotName = "snap-writergen";
        // Verify the catalog files from before the snapshot are reconstructed on the restored shard's disk
            try (var stream = Files.list(indexDir)) {
        assertEquals(RestStatus.OK, restoreResponse.status());
     * cleanup logic might miss.
        if (hasLuceneSecondary()) {
        // Restore both from V2 snapshot
import org.opensearch.test.OpenSearchIntegTestCase;
            assertTrue("format directory must exist: " + format + " (" + dir + ")", Files.exists(dir));
    public void testV2DeleteSnapshotCleansUpAllFormatFilesForDFA() throws Exception {
     * <ul>
        org.apache.lucene.index.SegmentInfos infosAfter = org.apache.lucene.index.SegmentInfos.readLatestCommit(
        flush(indexName);
        IndexShard shardAAfter = getShardZero(indexA);
            .setIndices("*")
     * Mirrors {@code DataFormatAwareReplicationBaseIT.assertLuceneIndexDirContents}.
        internalCluster().startDataAndWarmNodes(1);
        assertEquals("snapshot must be listed before deletion", 1, snapshotsBefore.size());
    /** Capture exhaustive pre-snapshot state for tight post-restore comparison. */
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
        assertDocCountInIndex(client, indexName, 0);
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName, new ArrayList<>());
        assertEquals(
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        SnapshotInfo source = createSnapshot(snapshotRepoName, sourceSnapshot, new ArrayList<>());
            sourceGen = ref.get().getGeneration();
        assertThat(source.state(), equalTo(SnapshotState.SUCCESS));
        Client client = client();
        internalCluster().startDataAndWarmNodes(1);
                ArrowBasePlugin.class,
            .get()
            org.opensearch.snapshots.SnapshotRestoreException.class,
import java.util.concurrent.ExecutionException;
    public void testV2DeleteSnapshotForDFA() throws Exception {
    }
        assertEquals("status initializingShards must be 0", 0, status.getShardsStats().getInitializingShards());
            this.indexUUID = indexUUID;
        String clonedSnapshot = "cloned-snap";
     * V2 restore with rename pattern — the snapshot was taken on {@code source-idx} but the
        // Delete and restore with overridden refresh_interval = 5s
     * at snapshot time. Mirrors {@code RestoreShallowSnapshotV2IT.testRestoreOperationsUsingDifferentRepos}.
        // DFA layout intact for BOTH restored shards
     * DFA-specific assertions on the source state.
        // Delete BOTH indices
        internalCluster().startDataAndWarmNodes(1);
        for (String format : expectedFormats()) {
        String snapshotRepoName = "test-status-repo";
        Set<String> filesAfter = captureShardFilesOnDisk(shardAfter);
        String snapshotName = "test-v2-multi-shard-snapshot";
        Client client = client();
        internalCluster().startClusterManagerOnlyNode();
    }
                .cluster()
    }
    }
    /**
     * — they must NOT partially restore or leak files.
        // Take V2 snapshot
    protected Settings.Builder getIndexSettings(int numOfShards, int numOfReplicas) {
                + "\n  files on disk after restore: "
        flush(indexName); // Force a commit so catalog snapshot reflects on-disk state
     *
        createRepository(snapshotRepoName, "mock", settings);
        ensureGreen(indexA, indexB);
            public java.nio.file.FileVisitResult visitFileFailed(Path file, IOException exc) {
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardAfter);
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
            String node = nodeNameForShard(clusterState, indexName, shardId);
        assertLuceneIndexDirContents(shardAfterDelete);
     * on DFA indices. Validation goes through admin APIs (_stats, cluster state) and direct
        assertAllFormatDirsHaveFiles(sourceShardAfter);
     */
        ensureGreen(indexName);
    private static long countFilesUnder(Path rootPath, String indexUUID, String categoryDirName) throws IOException {
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
        // Delete the index so we can restore from snapshot
        assertAllFormatDirsHaveFiles(shardABefore);
     * V2 snapshot of a multi-shard DFA index. Validates that per-shard catalogs are
            );
                + missingDataFiles
    public void testV2IncrementalSnapshotsForDFA() throws Exception {
            assertLuceneIndexDirContents(shardBefore);
            long docCount,
     *   <li>parquet+lucene-secondary: index/ has segments_N + at least one segment data file</li>
            SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName, new ArrayList<>());
        refresh(indexName);
     * layout is intact.
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
        final int segmentCount;
        // Renamed index must exist and have all docs; original is unchanged
        assertLuceneIndexDirContents(shardBefore);
        // Snapshot, delete, restore
     * <p>Mirrors {@code CloneSnapshotV2IT.testCloneShallowCopyV2}.
        // — simulates DR where the operator points a new cluster at the existing storage
        assertEquals("empty index 1-shard exactly 1 successful", 1, snapshotInfo.successfulShards());
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName)).get());
            );
        ensureGreen(indexName);
     * Captured pre-snapshot state for tight post-restore comparison.
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
import org.opensearch.node.Node;
        int segs = countSegmentsOnShard(client, indexName);
        // Delete and restore
        ) {
        Set<String> catalogBefore = pre.catalogFilesExcludingSegments;
                .setWaitForCompletion(true)
     *   <li>Restore status == OK</li>
                assertTrue("format directory must have files: " + format + " (" + dir + ")", stream.findAny().isPresent());
            .indices()
            );
        Path indexDir = shard.shardPath().resolveIndex();
            .cluster()
            .setWaitForCompletion(true)
            assertTrue(
        indexDocuments(client, indexName, 0, numOfDocs);
        logger.info("--> restoring V2 snap1");
        ensureGreen(indexName);
            logger.info("--> taking V2 snapshot for pathType={}", pathType);
        IndexShard shardAfter = getShardZero(indexName);
        RestoreSnapshotResponse restoreResponse = client.admin()
     *   <li>After restore: validate engine, catalog, doc count, then ingest more, refresh, validate.</li>
        IndexShard shardR1 = getShardZero(indexName);
        for (int shardId = 0; shardId < numShards; shardId++) {
            postRestoreWriterGens.put(
            Set<String> catalogFilesExcludingSegments,
     */
        String indexName = "dfa-incremental-index";
        assertTrue("status must contain the DFA index, got: " + status.getIndices().keySet(), status.getIndices().containsKey(indexName));
            assertAcked(client().admin().indices().prepareDelete("_all").get());
        internalCluster().startClusterManagerOnlyNode();
        indexDocuments(client, indexName, 0, numDocs);
            .setSourceRemoteStoreRepository(drSegmentRepo)
        );
                    + " had writer_generation="
        assertTrue("index/ must contain segments_N, got " + files, files.stream().anyMatch(f -> f.startsWith("segments_")));
    }
     * must succeed; restore must produce a green, empty index with zero docs.
        ) {
        createIndex(indexName, indexSettings);
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        assertEquals("single-shard index: snapshot must report exactly 1 successful shard", 1, snapshotInfo.successfulShards());
        ensureGreen(indexName);
        }
        assertThat(snapInfo2.state(), equalTo(SnapshotState.SUCCESS));
                nonSegmentsFiles.isEmpty()
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName)).get());
        ensureGreen(indexName);
        assertDocCountInIndex(client, indexName, numDocs);
        internalCluster().startDataAndWarmNodes(1);
        assertNotNull("restored index UUID must be set", restoredUuid);
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName, new ArrayList<>());
                + filesBeforeSnapshot
        ClusterState clusterState = client.admin().cluster().prepareState().get().getState();
        String indexName = "dfa-empty-index";
            indexDocuments(client, indexName, batch * 5, batch * 5 + 5);
            .setWaitForCompletion(true)
        // Capture pre-snapshot state for tight post-restore validation
        String snapshotName = "test-v2-dr-snapshot";
            "translog files must exist for index " + indexUUID + " before delete, got " + translogFilesBefore,
        String indexName = "dfa-delete-snapshot";
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
            .prepareCloneSnapshot(snapshotRepoName, sourceSnapshot, clonedSnapshot)
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName, new ArrayList<>());
            .cluster()
            .get();
        Set<String> filesBeforeSnapshot = captureShardFilesOnDisk(shardBefore);
            .get();
        assertTrue(
            "catalog generation must be >= pre-failure generation: pre=" + preState.catalogGeneration + " post=" + genAfter,
        refresh(indexName);
                .setIndices(indexName)
import org.opensearch.index.shard.IndexShard;
     * same catalog generation, same on-disk format dirs. A subsequent V2 snapshot must succeed.
        assertTrue("cloned snapshot must be listed: " + snapshotNames, snapshotNames.contains(clonedSnapshot));
     */
        assertTrue("source snapshot must be listed: " + snapshotNames, snapshotNames.contains(sourceSnapshot));
        );
                DataFusionPlugin.class
        ensureGreen(indexName);
    }
     * <ul>
            "data files from snapshot must be restored to disk; missing: "
     * this to add lucene as a secondary format.
        // Pre-snapshot DFA layout assertions on both
import org.opensearch.core.index.shard.ShardId;
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName)).get());
            IndexShard shard = getIndexShard(node, new ShardId(resolveIndex(indexName), shardId), indexName);
        // empty indices list triggers V2 path (cluster-manager only, pinned-timestamp based,
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardABefore);
    }
        String snapshotRepoName = "test-clone-repo";
            .setWaitForCompletion(true)
        String snapshotRepoName = "test-rapid-repo";
        Client client = client();
        }
        final String indexUUID;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        Set<String> all = new HashSet<>();
     * restored index gets a new name {@code restored-idx}. Validates DFA handles the renamed
            assertLuceneIndexDirContents(shard);
            .put(BlobStoreRepository.READONLY_SETTING.getKey(), readOnly)
        if (WRITABLE_WARM_INDEX_SETTING.get(settings)) {
            Client client = client();
        assertEquals(RestStatus.OK, r2.status());
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
        // The blocked snapshot must throw SnapshotException
                .setIndices(indexName)
     */
        IndexShard shardAfter = getShardZero(indexName);
        // 3 shards, 0 replicas
                boolean hasCategory = false;
        logger.info("Snapshot Path [{}]", absolutePath1);
        // Verify snapshot is listed
        String snapshotName = "snap-rename";
     * deletion + index deletion + lookback expiry. Lucene-only tests check just {@code segments/}
            client.prepareIndex(indexName).setSource("text", "sometext").get();
        // 120s timeout because pinned-timestamp lookback + scheduler iterations can take a while
     * Secondary data formats for the DFA index. By default this is empty (parquet-only).
            assertEquals("snap=" + snap, RestStatus.OK, restoreResponse.status());
    }
        createIndex(indexName, indexSettings);
        refresh(indexName);
import org.opensearch.indices.RemoteStoreSettings;
            .put("location", absolutePath1)
        assertAllFormatDirsHaveFiles(shardBBefore);
        // ─── Post-restore assertions ───────────────────────────────────────
        // Verify writer_generation attribute survived restore
import org.junit.After;
        var iter = shardSegs.iterator();
        IndexShard shardAfterPhase2 = getShardZero(indexName);
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        assertDocCountInIndex(client, indexName, numDocs);
            expectedCount,
     * <ul>
        RestoreSnapshotResponse restoreResponse = client.admin()
        assertEquals(numShards, restoreResponse.getRestoreInfo().totalShards());
     * Assert each non-Lucene format directory exists under the shard data path and contains files.
        // Call _snapshot/_status API
        assertAcked(cloneResponse);
        final int numDocs = 12;
            .setIndexSettings(overriddenSettings)
        Client client = client();
                return java.nio.file.FileVisitResult.CONTINUE;
        return Settings.builder()
        assertTrue("segment files must exist for index " + indexUUID + " before delete, got " + segmentFilesBefore, segmentFilesBefore > 0);
                ParquetDataFormatPlugin.class,
            .cluster()
        Settings indexSettings = getIndexSettings(1, 0).build();
        refresh(indexName);
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName, new ArrayList<>());
        ensureGreen(indexName);
            var nodes = internalCluster().getDataNodeInstances(Node.class);
import static org.opensearch.common.util.FeatureFlags.WRITABLE_WARM_INDEX_SETTING;
     * Asserts the catalog files (excluding segments_N) before snapshot are all present on
            () -> assertTrue(
        refresh(indexName);
     * <strong>DFA failure recovery test:</strong> if a V2 snapshot fails during finalization
        // Total doc count must match
        return new PreSnapshotState(docs, segs, catalogFiles, catalogGen, uuid);
        Client client = client();
        assertTrue("V2 snapshot must include " + indexB + ", got: " + snapshotInfo.indices(), snapshotInfo.indices().contains(indexB));
        var shardSegs = indexSegs.getShards().get(0);
            assertEquals("pathType=" + pathType, 0, restoreResponse.getRestoreInfo().failedShards());
            .setWaitForCompletion(true)
            .cluster()
        settingsBuilder.put("location", location);
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
            // Switch cluster path type
            restoredSegCount
        logger.info("--> restoring V2 snapshot with overridden refresh_interval=5s");
    /**
        assertAllFormatDirsHaveFiles(shardBAfter);
            this.catalogFilesExcludingSegments = catalogFilesExcludingSegments;
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(restoredShard);
        assertDocCountInIndex(client, indexName, 1);
            "all shards must restore successfully",
        String snap1 = "test-v2-snap1";
        assertNotNull("pre-snapshot index UUID must be set", uuid);
                .get()
        assertThat(s2.state(), equalTo(SnapshotState.SUCCESS));
        Client client = client();
            "DFA catalog generation must be monotonic across clone+restore: source=" + sourceGen + " restored=" + restoredGen,
     * not just metadata.
        // Create DFA index (parquet primary + lucene secondary, see getIndexSettings)
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY;
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardAfterSnap2);
            RemoteStorePinnedTimestampService.class,
        refresh(indexName);
import org.opensearch.core.common.unit.ByteSizeValue;
        // Catalog must match what's on local disk and what was uploaded to remote
        ensureGreen(indexName);
        final int phase3Docs = 15;
import static org.hamcrest.Matchers.equalTo;
        // Get index UUID — used to find the right shard subtree under the remote-store layout
                "snap-fail"
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY;
                .get();
        assertEquals(0, restoreResponse.getRestoreInfo().failedShards());
        internalCluster().startDataAndWarmNodes(1);
        assertTrue("index/ directory must exist: " + indexDir, Files.exists(indexDir));
        final String indexName = "hot-v2-lifecycle";
    protected Settings.Builder getRepositorySettings(Path location, boolean shallowCopyEnabled) {
     * (e.g., {@code refresh_interval}). Validates the override is applied to the restored index.
        // For DFA + V2 test, warm-index is orthogonal and slows test; use only non-warm variant.
        internalCluster().startClusterManagerOnlyNode();
            refresh(indexName);
        logger.info("--> cloning V2 snapshot");
        Settings overriddenSettings = Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "5s").build();
            .get();
        // ─── Verify retry: a subsequent V2 snapshot must succeed (repo state cleaned) ───
        disableRepoConsistencyCheck("Remote store repo aliasing");
        // ─── Restore from V2 snapshot ──────────────────────────────────────
                + diff(pre.catalogFilesExcludingSegments, restoredCatalog)
        final int numDocs = 10;
     *
        String snapshotRepoName = "test-snapshot-repo";
     *   <li>Create hot DFA index, ingest, snapshot {@code snap1}, delete, restore from {@code snap1}.</li>
        final int finalTotal = totalAtSnap2 + phase3Docs;
import org.opensearch.index.remote.RemoteStoreEnums;
            .get();
        indexDocuments(client, indexName, totalAtSnap2, finalTotal);
    @After
        );
            assertNotNull(
        String snapshotName = "snap-invalid";
     * <ul>
        // DFA layout intact
                .getCatalogSnapshot()
    @Before
            // (V2 allows only ONE such repo cluster-wide).
                // Iterate path name elements rather than substring-matching the toString() — the latter
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName)).get());
        String snapshotName = "snap-settings";
            }
        for (RemoteStoreEnums.PathType pathType : RemoteStoreEnums.PathType.values()) {
        assertDocCountInIndex(client, indexName, numDocs);
    /**
        String snapshotRepoName = "test-snapshot-repo";
        );
        int restoredSegCount = countSegmentsOnShard(client, restoredIndexName);
    protected PreSnapshotState capturePreSnapshotState(Client client, String indexName, IndexShard shard) throws IOException {
     *
        internalCluster().startClusterManagerOnlyNode();
    }
        // Catalog generation must be >= pre-snapshot generation (restore may bump it)
        );
    protected void assertRestoredIndexMatches(
        assertDocCountInIndex(client, indexName, numDocs);
     * underlying file paths (read-only views).
        Set<String> restoredCatalog = DataFormatAwareITUtils.catalogFilesExcludingSegments(restoredShard);
            assertLuceneIndexDirContents(shard);
        Client client = client();
                .cluster()
        createIndex(indexName, indexSettings);
        assertDocCountInIndex(client, indexName, numDocs);
        super(nodeSettings);
        // Pre-snapshot: 0 docs
    private void assertLuceneIndexDirContents(IndexShard shard) throws IOException {
                .setWaitForCompletion(true)
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));
        // Doc counts must be PRESERVED PER-INDEX (catches cross-index corruption)
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
        }
    /**
                        hasUuid = true;
        }
    /**
            String segName = e.getKey();
            assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName)).get());
        Settings indexSettings = getIndexSettings(1, 0).build();
        refresh(indexName);
        String snapshotName = "test-v2-multi-snapshot";
        internalCluster().startClusterManagerOnlyNode();
        assertTrue("renamed index must exist", indexExists(renamedIndex));
     */
            long translogCount = countFilesUnder(remoteRepoPath, indexUUID, "translog");
        RestoreSnapshotResponse restoreResponse = client.admin()
     *   <li>Restore from snap2 yields N+M docs (newer files present)</li>
     */
        assertDocCountInIndex(client, indexName, numDocs);
        // Index documents and refresh so segments are created in BOTH formats
        Map<String, String> postRestoreWriterGens = new HashMap<>();
        // For rename, the new UUID is also different. So in both cases the restored UUID must
        long restoredGen;
            settingsBuilder.put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true);
        refresh(indexA, indexB);
        String snapshotRepoName = "test-snapshot-repo";
    private void keepPinnedTimestampSchedulerUpdated() throws Exception {
        // ── Phase 1: create hot DFA index, ingest, snapshot ────────────────
        internalCluster().startClusterManagerOnlyNode();
        long actualCount = client.admin()
import org.opensearch.core.rest.RestStatus;
        assertTrue("pre-snapshot catalog generation must be > 0, got " + catalogGen, catalogGen > 0L);
            .setRenameReplacement(renamedIndex)
        PreSnapshotState pre,
                + filesAfterRestore,
        assertThat(retryInfo.state(), equalTo(SnapshotState.SUCCESS));
        indexDocuments(client, indexName, 0, numDocs);
    public void setup() {
        assertEquals("snapshot name in status must match", snapshotName, status.getSnapshot().getSnapshotId().getName());
            RestoreSnapshotResponse restoreResponse = client.admin()
            String postGen = postRestoreWriterGens.get(segName);
        logger.info("--> restoring multi-shard V2 snapshot");
        flush(indexName);
     *   <li>Snapshot state == SUCCESS, all shards successful (cluster-manager-only flow)</li>
        RestoreSnapshotResponse restoreResponse = client.admin()
        assertDocCountInIndex(client, indexB, numDocsB);
            .getCount();
        org.junit.Assume.assumeTrue("writer_generation attribute test requires Lucene secondary format", hasLuceneSecondary());
        flush(indexName);
        Settings indexSettings = getIndexSettings(1, 0).build();
     * leaking into index B's restore).
            .prepareSnapshotStatus(snapshotRepoName)
            .get();
            "at least one segment must have writer_generation attribute pre-snapshot, got: " + preSnapshotWriterGens,
        // Even an empty index has 1 shard reported
                + "\n  catalog before: "
        String snapshotRepoName = "test-cleanup-repo";
        refresh(indexName);
            }
        waitForBlock(clusterManagerNode, snapshotRepoName, TimeValue.timeValueSeconds(30L));
        final String repoName = "test-snapshot-repo";
        indexDocuments(client, indexName, 0, numDocs);
        final int numDocs = 10;
        assertFalse("invalid restore must NOT partially create the index", indexExists(indexName));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        for (Map.Entry<String, String> e : preSnapshotWriterGens.entrySet()) {
     * Get the IndexShard for shard 0 of the index on the first data node in the cluster.
        Client client = client();
            .get();
                // Concurrent cleanup may delete a file between enumeration and visit; tolerate.
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardAfterSnap1);
import java.util.Collection;
     *   <li>{@code prepareDeleteSnapshot} succeeds (acknowledged)</li>
        return Settings.builder()
     * Wait until the pinned-timestamp scheduler has fired at least once after invocation.
        long genAfter;
        IndexShard restoredShard = getShardZero(indexName);
        assertEquals("status totalShards must be 1", 1, status.getShardsStats().getTotalShards());
        // Single-shard index — exact assertions
        List<SnapshotInfo> snapshots = client.admin().cluster().prepareGetSnapshots(snapshotRepoName).get().getSnapshots();
     * primary=parquet, secondary=[lucene]. Lucene is also always present implicitly.
            .setWaitForCompletion(true)
    @ParametersFactory
    protected List<String> getSecondaryDataFormats() {
        assertTrue(
            .cluster()
        // delete the repo between iterations.
     *
            genAfter >= preState.catalogGeneration
        internalCluster().startClusterManagerOnlyNode();
     * </ul>
            .setDocs(true)
        // Take V2 snapshot
            .putList("index.composite.secondary_data_formats", getSecondaryDataFormats());
        flush(indexName);
                stream.forEach(p -> all.add("index/" + p.getFileName()));
                    .cluster()
     */
                client().admin()
    }
        indexDocuments(client, indexName, 0, numDocs);
     * indexUUID and the given category (e.g. {@code "segments"} or {@code "translog"}).
        String sourceIndex = "dfa-rename-source";
        IndexShard sourceShard = getShardZero(sourceIndex);
     *   <li>All format dirs (parquet, lucene index/) reconstructed on disk with files</li>
    /**
            .cluster()
     * Mirrors {@code DeleteSnapshotV2IT.testRemoteStoreCleanupForDeletedIndexForSnapshotV2}
        }
        assertDocCountInIndex(client, indexB, numDocsB);
     */
                .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
     *
            () -> client.admin()
        expectThrows(org.opensearch.snapshots.SnapshotException.class, snapshotFuture::actionGet);
        assertEquals("only the successful retry snapshot must remain in repo", 1, snapshots.size());
        assertEquals("status must list the DFA index", 1, status.getIndices().size());
            }
        AcknowledgedResponse cloneResponse = client.admin()
        logger.info("--> restoring from cloned V2 snapshot");
    }
        Settings.Builder settings = Settings.builder()
     * V2 restore with overridden index settings. Some settings are restorable-mutable
                    + segName
        assertEquals("status failedShards must be 0", 0, status.getShardsStats().getFailedShards());
        org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse statusResponse = client.admin()
    /**
        assertAllFormatDirsHaveFiles(shardAfterSnap2);
        // The writer_generation attribute is stamped by LuceneWriterCodec only when Lucene is
import org.opensearch.cluster.metadata.RepositoryMetadata;
        // Delete and restore
            assertFalse(
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), true)
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        assertNotNull("status object must contain shard stats", status.getShardsStats());
     * Take a V2 snapshot of a DFA index, then delete the snapshot. Validates that:
        }
                    } else if (categoryDirName.equals(name)) {
                .cluster()
    public void testV2MultiIndexSnapshotAndRestoreForDFA() throws Exception {
            if ("lucene".equals(format)) continue; // Lucene files live under shard/index/, not a separate dir
    public void testV2HashedPrefixPathTypeForDFA() throws Exception {
            restoreResponse.getRestoreInfo().successfulShards()
        assertDocCountInIndex(client, indexName, 0);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numOfShards)
        IndexShard sourceShardAfter = getShardZero(indexName);
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName)).get());
        Set<String> r = new HashSet<>(a);
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardAfter);
        // Verify the setting override took effect
    /**
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
import org.opensearch.transport.client.Client;
import java.util.stream.Stream;
        // Every pre-snapshot segment with writer_generation must STILL have it after restore.
        assertEquals(RestStatus.OK, restoreResponse.status());
        assertDocCountInIndex(client, indexName, numDocs);
        assertFalse(indexExists(indexName));
    }
        String indexName = "dfa-clone-catalog-gen";
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shardAfter);
        assertThat("snap1 state", info1.state(), equalTo(SnapshotState.SUCCESS));
     * be at least the pre-snapshot value (restore may bump it during finalize); and DFA on-disk
        // Both must succeed
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;
                .setWaitForCompletion(true)
        );
        internalCluster().startDataAndWarmNodes(1);
        assertTrue("pre-snapshot catalog generation must be > 0", sourceGen > 0L);
        internalCluster().startDataAndWarmNodes(1);
        flush(indexName);
        // Take V2 snapshot — empty indices list snapshots BOTH
        assertDocCountInIndex(client, indexName, numDocs);
        internalCluster().startDataAndWarmNodes(1);
        assertFalse("pre-snapshot writer_generation map must not be empty", preSnapshotWriterGens.isEmpty());
     * snapshots within a single repo (only one snapshot can be in finalization state at a time),
