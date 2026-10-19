import java.nio.file.Files;
        assertBusy(() -> { holder[0] = supplier.get(); }, timeout, unit);
    // Backward compatibility: a pure-Lucene (no secondary format) relocation is exercised by
            Map<String, UploadedSegmentMetadata> uploadMapAfter = recovered.getRemoteDirectory().getSegmentsUploadedToRemoteStore();
        ensureGreen(INDEX_NAME);
 * Unlike recovery, relocation uses the peer-recovery source path
            IndexShard shard = getIndexShard(sourceNode, INDEX_NAME);
    private interface CheckedSupplierWithReturn<T> {
    //
     * translog without re-applying operations already committed to durable Parquet/Lucene files.
    public void testRemoteStoreRecoveryFromTranslogOnly() throws Exception {
     *
            totalDocs += docs;
    }
     * catalog must match.
            .restoreRemoteStore(new RestoreRemoteStoreRequest().indices(INDEX_NAME).restoreAllShards(true), PlainActionFuture.newFuture());
        String expectedNodeId = internalCluster().clusterService(nodeName).localNode().getId();
            RemoteSegmentMetadata pMeta = primary.getRemoteDirectory().readLatestMetadataFile();
     * <p>Asserts that the post-restart doc count equals exactly {@code firstBatch + secondBatch}.
     *
    /**
     * uploaded file (across every format) must be on the target's disk with a matching catalog.
     * must still relocate cleanly. Every file the source uploaded (all under the Lucene default
            totalDocs += docs;
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(0)).get();
            .actionGet();
import org.opensearch.cluster.metadata.IndexMetadata;
    protected Settings dfaIndexSettings(int replicaCount) {
    /**
        }, 30, TimeUnit.SECONDS);
        indexDocs(firstBatch);
            assertTrue("formats must include parquet", formatsOf(meta.getMetadata()).contains("parquet"));
                onDisk = shard.shardPath().getDataPath().resolve(format).resolve(file);
        assertBusy(() -> {
    @FunctionalInterface
     * relocates the replica onto the third node, and validates the replica ends up with the
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(recovered);
            assertUploadMapFilesOnDisk(uploadMapBefore, relocated);
        // After relocation the replica must be on targetNode.
            return map;
     * org.opensearch.index.engine.exec.coord.CatalogSnapshot} must carry the equivalent so the
     * Replica shard relocation. Creates a primary + 1 replica on two nodes, starts a third node,
        indexDocs(randomIntBetween(20, 50));
        }, 60, TimeUnit.SECONDS);
            .map(s -> s.currentNodeId())
     *       any committed format file).</li>
        String targetNode = internalCluster().startDataOnlyNode();
        }
    }
            .restoreRemoteStore(new RestoreRemoteStoreRequest().indices(INDEX_NAME).restoreAllShards(true), PlainActionFuture.newFuture());
            final Path onDisk;
        indexDocsWithOffset(1000, randomIntBetween(10, 25));
    // drives phase1 — the target downloads segments from the remote store into its local
            assertUploadMapFilesOnDisk(uploadMapBefore, relocated);
     * Relocate the primary, then index + flush on the new primary. Verifies the relocated shard
            IndexShard shard = getIndexShard(primaryNodeName(), INDEX_NAME);
    // Extensibility: all relocation assertions go through format-agnostic helpers
            Set<String> catalogAfter = DataFormatAwareITUtils.catalogFilesExcludingSegments(recovered);
        assertFalse("timed out waiting for relocation target to join", joined.isTimedOut());
        // Full remote store recovery
            Map<String, UploadedSegmentMetadata> map = shard.getRemoteDirectory().getSegmentsUploadedToRemoteStore();
import org.opensearch.index.store.RemoteSegmentStoreDirectory.UploadedSegmentMetadata;
            .setWaitForEvents(Priority.LANGUID)
     *       remote segment store).</li>
        ensureGreen(INDEX_NAME);
    private void assertNoFormatFilesOnDisk(IndexShard shard) throws Exception {
import java.util.stream.Collectors;
    // the target is bootstrapped via the peer-recovery source handler
        String nodeId = getClusterState().routingTable().index(INDEX_NAME).shard(0).primaryShard().currentNodeId();
            assertEquals("parquet directory should be empty before recovery, found " + fileCount + " files", 0, fileCount);
        assertNotNull("could not find replica's source node", sourceReplicaNode);
        // Before restore: verify the new shard has no format data files
    // * every file the source uploaded to remote (across Lucene + non-default formats) is
            // Catalog snapshot state: non-empty, has segments
    //
            RemoteSegmentMetadata meta = relocated.getRemoteDirectory().readLatestMetadataFile();
            DataFormatAwareITUtils.assertPrimaryUploadMapOnReplicaDisk(primary, replica);
import org.opensearch.be.datafusion.DataFusionPlugin;
            Set<String> catalogAfter = DataFormatAwareITUtils.catalogFilesExcludingSegments(relocated);
            .shard(0)
        String targetNode = internalCluster().startDataOnlyNode();
            assertUploadMapFilesOnDisk(uploadMapAfter, recovered);
        }
        String targetNode = internalCluster().startDataOnlyNode();
 */
        internalCluster().stopRandomNode(s -> dataNode.equals(s));
            assertTrue("formats must include parquet", formatsOf(pMeta.getMetadata()).contains("parquet"));
    }
     * can continue producing format-aware writes: the new upload map is a superset of the original
    protected static final String INDEX_NAME = "dfa-recovery-test-idx";
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(1)).get();
 *
        internalCluster().startClusterManagerOnlyNode();
 *
     * files, and after remote store recovery all uploaded files are present on disk with
            .cluster()
            // target's DataFormatAwareStoreDirectory (or plain FSDirectory if DFA is off) will use.
            Stream.of(
        // Lucene-only index: same remote-store + segment replication setup, pluggable dataformat disabled.
     * format, living under {@code <shard>/index/}) must land on the target's disk and the
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shard);
                CompositeDataFormatPlugin.class,
        indexDocs(randomIntBetween(10, 30));
     * recovers and the engine opens successfully with translog replay.
        ensureGreen(INDEX_NAME);
        relocatePrimaryTo(sourceNode, targetNode, 60);
            assertEquals("catalog files must match before/after restart", catalogBefore, catalogAfter);
}
    protected boolean hasLuceneSecondary() {
            assertTrue("Lucene-only index must have lucene format present: " + formats, formats.contains("lucene"));
            assertTrue("formats must include parquet after new writes", formatsOf(meta.getMetadata()).contains("parquet"));
        Path parquetDir = shard.shardPath().getDataPath().resolve("parquet");
        // downloads committed files from remote segment store, then replays the remote translog.
            assertNotNull("metadata must exist after restart", meta);
            Set<String> catalogAfter = DataFormatAwareITUtils.catalogFilesExcludingSegments(recovered);
        internalCluster().startDataOnlyNode();
            actualRows
            // (segments_N excluded) and gain at least one new parquet file from the post-relocation flush.
            .putList("index.composite.secondary_data_formats", List.of("lucene"))
            client().admin().indices().prepareRefresh(INDEX_NAME).get();
            .collect(java.util.stream.Collectors.toSet());
            if (originalName.startsWith("segments_")) {
    protected Set<String> expectedFormats() {
            }
            IndexShard shard = getIndexShard(sourceNode, INDEX_NAME);
import org.opensearch.common.settings.Settings;
            "precondition: should have multiple parquet files from multiple generations, got " + parquetFilesBefore,
            Map<String, UploadedSegmentMetadata> map = shard.getRemoteDirectory().getSegmentsUploadedToRemoteStore();
     * relocation it must converge with the primary on catalog and format-specific files on disk,
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(0)).get();
     * {@code max_seq_no} tracking in commit user-data; for DFA the {@link
            .setWaitForEvents(Priority.LANGUID)
            .actionGet();
            assertNotNull("metadata must exist after new writes on relocated primary", meta);
    public void testPrimaryRestartRecoveryPreservesFormats() throws Exception {
    /**
    /**
    @Override
        assertBusy(() -> {
        client().admin()
     * </ol>
    private String nodeNameFromId(String nodeId) {
            super.nodePlugins().stream(),
            }
            .execute()
        Object[] holder = new Object[1];
    /**
        // Full remote store recovery
    // correct shard subdirectory via FileMetadata's delimiter convention. A new DataFormat
 * close index, restore from remote store. They validate that the recovered shard starts empty and
            RemoteSegmentMetadata meta = recovered.getRemoteDirectory().readLatestMetadataFile();
        ensureRed(INDEX_NAME);
 *
            long parquetBefore = uploadMapBefore.keySet().stream().filter(f -> new FileMetadata(f).dataFormat().equals("parquet")).count();
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
            .cluster()
            Path parquetDir = recovered.shardPath().getDataPath().resolve("parquet");
    public void testRemoteStoreRecoveryThenNewWrites() throws Exception {
import org.opensearch.common.Priority;
            .prepareHealth()
                .get();
    protected String primaryNodeName() {
            .restoreRemoteStore(new RestoreRemoteStoreRequest().indices(INDEX_NAME).restoreAllShards(true), PlainActionFuture.newFuture());
            RemoteSegmentMetadata meta = shard.getRemoteDirectory().readLatestMetadataFile();
            );
            assertEquals("catalog files must match before/after recovery", catalogBefore, catalogAfter);
            // routes Lucene files (no "/" in the name) under <shard>/index/, exactly the path the
        String targetNode = internalCluster().startDataOnlyNode();
        Set<String> catalogBefore = DataFormatAwareITUtils.catalogFilesExcludingSegments(getIndexShard(sourceNode, INDEX_NAME));
     */
            docCount,
                    uploadMapAfter.containsKey(originalFile)
        ensureGreen(INDEX_NAME);
        client().admin().indices().prepareFlush(INDEX_NAME).get();
import org.opensearch.index.store.FileMetadata;
                "file from upload map must exist on recovered shard disk: " + onDisk + " (originalName=" + originalName + ")",
 * The OpenSearch Contributors require contributions made to
        client().admin().indices().prepareFlush(INDEX_NAME).get();
                + actualRows
import org.opensearch.index.shard.IndexShard;
        int totalDocs = 0;
            .setWaitForNoRelocatingShards(true)
            for (String originalFile : uploadMapBefore.keySet()) {
            IndexShard recovered = getIndexShard(primaryNodeName(), INDEX_NAME);
            long fileCount = Files.list(parquetDir).count();
            assertTrue("formats must include parquet after relocation", formatsOf(meta.getMetadata()).contains("parquet"));
    }
    // ---------------------------------------------------------------------------------------
                    "field_keyword",
            assertNotNull(meta);
        }
                    uploadMapAfter.containsKey(originalFile)
            if (!n.equals(primaryNode) && !n.equals(internalCluster().getClusterManagerName())) {
            .cluster()
            .execute()
     * Lucene files under {@code <shard>/index/}, non-default format files under {@code <shard>/<format>/}.
 * agreement between catalog, local disk, and remote directory.
     * <ol>
    }
            // All current files must be on disk
            .put("index.pluggable.dataformat", "composite")
    /**
        }
     * Resolves the id of the replica currently assigned to {@code nodeName} for shard 0 of
        }, 30, TimeUnit.SECONDS);
        );
        indexDocsWithOffset(1000, randomIntBetween(10, 25));
     * the recovered commit's local checkpoint, batch 1 ops would be re-applied on top of the
    /**
     * <strong>DFA correctness regression guard:</strong> recovery from remote store must replay
import java.util.stream.Stream;
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForNodes("3").get();
        }, 30, TimeUnit.SECONDS);
     */
            );
            assertNotNull("recovered shard must not be null", recovered);
    // Shard relocation tests
        internalCluster().startDataOnlyNode();
                assertTrue(
                if (originalFile.startsWith("segments_")) {
     * <p>Scenario:
     *
    private void assertUploadMapFilesOnDisk(Map<String, UploadedSegmentMetadata> uploadMap, IndexShard shard) {
            assertNotNull(meta);
     * Uses the same file layout convention as {@link DataFormatAwareITUtils#assertPrimaryUploadMapOnReplicaDisk}:
            assertLuceneIndexDirContents(recovered);
            assertUploadMapFilesOnDisk(uploadMapAfter, relocated);
                    "field_number",
     * This is the DFA analogue of {@link #testRemoteStoreRecoveryPreservesFormatMetadata} but
    /**
            Map<String, UploadedSegmentMetadata> map = shard.getRemoteDirectory().getSegmentsUploadedToRemoteStore();
    }
        String dataNode = internalCluster().startDataOnlyNode();
            assertTrue("formats must include parquet before relocation", formatsOf(meta.getMetadata()).contains("parquet"));
                "formats must include parquet after new writes on relocated primary",
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(0)).get();
        Set<String> catalogBefore = DataFormatAwareITUtils.catalogFilesExcludingSegments(getIndexShard(primaryNodeName(), INDEX_NAME));
            assertNotNull(meta);
            Map<String, UploadedSegmentMetadata> map = shard.getRemoteDirectory().getSegmentsUploadedToRemoteStore();
            assertEquals("catalog files must match before/after recovery", catalogBefore, catalogAfter);
        client().admin().indices().prepareFlush(INDEX_NAME).get();
    }
                onDisk = shard.shardPath().resolveIndex().resolve(originalName);
        assertFalse("timed out waiting for relocation of " + INDEX_NAME + " from " + sourceNode + " to " + targetNode, health.isTimedOut());
        ensureGreen(INDEX_NAME);
        // Write new docs + flush on the relocated primary.
            assertLuceneIndexDirContents(recovered);
        assertFalse("timed out waiting for replica relocation", health.isTimedOut());
            RemoteSegmentMetadata meta = shard.getRemoteDirectory().readLatestMetadataFile();
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
    private void relocatePrimaryTo(String sourceNode, String targetNode, int timeoutSeconds) {
    private String replicaNodeIdOn(String nodeName) {
        indexDocsWithOffset(firstBatch, secondBatch);
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(0)).get();
                    (long) (offset + i)
        // Capture state before restart
        client().admin()
        internalCluster().startClusterManagerOnlyNode();
            .index(INDEX_NAME)
                    "pre-relocation file must still be in upload map after new writes: " + originalFile,
    /**
        }, 60, TimeUnit.SECONDS);
            assertTrue(
     * Backward-compatibility guard: on the same plugin + cluster configuration (pluggable
        internalCluster().stopRandomNode(s -> dataNode.equals(s));
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
            assertLuceneIndexDirContents(relocated);
        String nodeName = primaryNodeName();
            IndexShard shard = getIndexShard(sourceNode, INDEX_NAME);
            return map;
        long expectedTotal = firstBatch + secondBatch;
                break;
        indexDocs(randomIntBetween(20, 50));
     * <p>This ensures the DFA relocation machinery degrades to a no-op for non-DFA indices.
            assertNotNull("metadata must exist after recovery", meta);
        }, 60, TimeUnit.SECONDS);
        }
     */
     *
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
     * already-restored Parquet files → duplicate rows. The standard Lucene engine handles this via
        java.util.Set<String> nonSegmentsFiles = files.stream()
            RemoteSegmentMetadata meta = recovered.getRemoteDirectory().readLatestMetadataFile();
            // Remote store upload after recovery
                assertFalse("catalog snapshot must have segments after flush", snapshotRef.get().getSegments().isEmpty());
        // Full cluster restart — exercises the realistic disaster-recovery path: data node restarts,
            return map;
            assertTrue("shard must be started", recovered.routingEntry().started());
        for (int cycle = 0; cycle < 3; cycle++) {
            return map;
     */
            IndexShard recovered = getIndexShard(primaryNodeName(), INDEX_NAME);
        client().admin()
 *
            .put("index.composite.primary_data_format", "parquet")
        String sourceReplicaNodeId = internalCluster().clusterService(sourceReplicaNode).localNode().getId();
     */
            }
            // Format files on disk
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shard);
     */
    }
                "relocated primary must produce new parquet files (before=" + parquetBefore + ", after=" + parquetAfter + ")",
            .execute()
        Set<String> primaryCatalogBefore = DataFormatAwareITUtils.catalogFilesExcludingSegments(getIndexShard(primaryNode, INDEX_NAME));
            assertLuceneIndexDirContents(recovered);
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForNodes("3").get();
        long actualRows = client().admin().indices().prepareStats(INDEX_NAME).clear().setDocs(true).get().getTotal().getDocs().getCount();
        ensureGreen(INDEX_NAME);
            assertUploadMapFilesOnDisk(uploadMapBefore, recovered);
            if (internalCluster().clusterService(nodeName).localNode().getId().equals(nodeId)) {
        client().admin().indices().prepareClose(INDEX_NAME).get();
    public void testReplicaRelocationPreservesFormatMetadata() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(0)).get();
            assertTrue("parquet directory must exist after flush", Files.exists(parquetDir));
        String targetNode = internalCluster().startDataOnlyNode();
        for (String n : internalCluster().getNodeNames()) {
     * <p>This exercises the replica-target peer-recovery path for DFA: the relocated replica is
        internalCluster().startClusterManagerOnlyNode();
     * bootstrapped from the remote store via {@code RemoteStoreReplicationSource}; after
            .build();
        assertTrue("index/ must contain segments_N, got " + files, files.stream().anyMatch(f -> f.startsWith("segments_")));
                );
            IndexShard relocated = getIndexShard(targetNode, INDEX_NAME);
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(0)).get();
        relocatePrimaryTo(sourceNode, targetNode, 60);
                .setSource("field_text", randomAlphaOfLength(10), "field_keyword", randomAlphaOfLength(10), "field_number", (long) i)
     *   <li>Index batch 1 → refresh + flush (writes durable Parquet/Lucene files; uploads to
    @SuppressWarnings("unchecked")
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForNodes("3").get();
            client().prepareIndex(INDEX_NAME)
    protected static Set<String> formatsOf(Map<String, UploadedSegmentMetadata> segments) {
            .restoreRemoteStore(new RestoreRemoteStoreRequest().indices(INDEX_NAME).restoreAllShards(true), PlainActionFuture.newFuture());
     * Asserts that every file from the upload map exists on the recovered shard's local disk.
            .setTimeout(TimeValue.timeValueSeconds(timeoutSeconds))
                continue; // segments_N generation may differ
    }
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(0)).get();
    }
        // Stop data node, start new one
    public void testRemoteStoreRecoveryPreservesFormatMetadata() throws Exception {
                String format = originalName.substring(0, sep);
            .setWaitForEvents(Priority.LANGUID)
        client().admin()
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(relocated);
        ClusterHealthResponse health = client().admin()
            RemoteSegmentMetadata meta = relocated.getRemoteDirectory().readLatestMetadataFile();
    /**
            .put("index.pluggable.dataformat.enabled", false)
            assertFalse("Lucene-only index must not contain parquet files: " + formats, formats.contains("parquet"));
                }
            .prepareReroute()
    }
        ensureGreen(INDEX_NAME);
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
     * - parquet-only: only segments_N (commit metadata)
        indexDocs(randomIntBetween(20, 40));
            IndexShard shard = getIndexShard(primaryNodeName(), INDEX_NAME);
import org.opensearch.test.OpenSearchIntegTestCase;
            )
        assertBusy(() -> {
     */
    // data format and verifies the tests still hold — this ensures the relocation contract on
            assertEquals("primary/replica catalogs must match after replica relocation", primaryCatalogAfter, replicaCatalogAfter);
    }
            IndexShard replica = getIndexShard(targetNode, INDEX_NAME);
     * recovery. Validates all generation files are recovered to disk.
        Map<String, UploadedSegmentMetadata> uploadMapBefore = assertBusyAndReturn(() -> {
        assertBusy(() -> {
            // Catalog file set must match what was there before
        // Sanity: the node we just picked must actually host the replica.
            assertNotNull(meta);
        Set<String> catalogBefore = DataFormatAwareITUtils.catalogFilesExcludingSegments(getIndexShard(primaryNodeName(), INDEX_NAME));
    }
        ClusterHealthResponse joined = client().admin()
/**
        ensureGreen(INDEX_NAME);
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(recovered);
    }
 * <p>Recovery tests cover the full restore-from-remote-store path: stop data node, start new node,
            "Translog replay must NOT duplicate rows already committed to Parquet. "
import java.nio.file.Path;
        assertTrue("index/ directory must exist", java.nio.file.Files.exists(indexDir));
            RemoteSegmentMetadata meta = relocated.getRemoteDirectory().readLatestMetadataFile();
        for (int i = 0; i < count; i++) {
        internalCluster().startClusterManagerOnlyNode();
        client().admin().indices().prepareFlush(INDEX_NAME).get();
                + ". If actual > expected, translog replayed ops that were already in committed Parquet files.",
        int docCount = randomIntBetween(10, 30);
            }
        int totalDocs = 0;
        Set<String> catalogBefore = DataFormatAwareITUtils.catalogFilesExcludingSegments(getIndexShard(primaryNodeName(), INDEX_NAME));
        T get() throws Exception;
        // No flush — data only in translog
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            assertTrue("formats must include parquet after relocation", formatsOf(meta.getMetadata()).contains("parquet"));
        assertBusy(() -> {
    // DFA-enabled clusters does not regress the Lucene-only path.
     * exercises the peer-recovery source path instead of the remote-store restore path.
        // Start the relocation target and wait for the cluster to see it.
        internalCluster().startClusterManagerOnlyNode();
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(0)).get();
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
import org.opensearch.arrow.allocator.ArrowBasePlugin;
            .prepareHealth()
        assertBusy(() -> {
     * Restart primary node (not full restore), verify it recovers with all format files
    }
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).setWaitIfOngoing(true).get();
     * Helper that runs an assertion block with assertBusy semantics but returns a value.
        indexDocs(randomIntBetween(20, 40));
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import java.util.concurrent.TimeUnit;
            .prepareHealth()
            assertEquals("catalog files must match before/after relocation", catalogBefore, catalogAfter);
                    randomAlphaOfLength(10),
            .put("index.pluggable.dataformat.enabled", true)
            assertNotNull("metadata must exist after relocation", meta);
    /**
            );
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
            assertEquals("primary catalog must be stable across replica relocation", primaryCatalogBefore, primaryCatalogAfter);
            try (var snapshotRef = recovered.getCatalogSnapshot()) {
        for (String originalName : uploadMap.keySet()) {
     * writing in the correct format, uploading new files, and maintaining catalog consistency.
    protected Settings nodeSettings(int nodeOrdinal) {
        internalCluster().startDataOnlyNode();
        }, 30, TimeUnit.SECONDS);
            "doc count must match after translog-only recovery",
                    "field_text",
        // Validate cross-shard invariants: primary-uploaded files on the relocated replica's disk,
    }
        return Settings.builder()
import org.opensearch.index.store.remote.metadata.RemoteSegmentMetadata;
            assertFalse("upload map must not be empty", map.isEmpty());
            RemoteSegmentMetadata meta = shard.getRemoteDirectory().readLatestMetadataFile();
    //
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(luceneSettings).get();
            client().admin().indices().prepareStats(INDEX_NAME).clear().setDocs(true).get().getTotal().getDocs().getCount()
            Map<String, UploadedSegmentMetadata> map = shard.getRemoteDirectory().getSegmentsUploadedToRemoteStore();
                DataFusionPlugin.class
public class DataFormatAwareRemoteStoreRecoveryIT extends RemoteStoreBaseIntegTestCase {
    //
                .setSource(
        ensureGreen(INDEX_NAME);
        client().admin().indices().prepareClose(INDEX_NAME).get();
    }
        for (String nodeName : internalCluster().getNodeNames()) {
        client().admin().indices().prepareFlush(INDEX_NAME).get();
    // Relocation is a distinct code path from recovery. The source shard stays live throughout;
        ClusterHealthResponse joined = client().admin()
import java.util.Collection;
        return nodeNameFromId(nodeId);
 */
        assertBusy(() -> {
        String sourceNode = internalCluster().startDataOnlyNode();
    public void testPrimaryRelocationThenNewWrites() throws Exception {
            .execute()
    }
            assertTrue(
            client().prepareIndex(INDEX_NAME)
import org.opensearch.action.support.PlainActionFuture;
import java.util.List;
            assertTrue("formats must include parquet", formatsOf(meta.getMetadata()).contains("parquet"));
    // * catalog files excluding segments_N are equal on source (before) and target (after);
            .build();
     */
 * <p>SEGMENT replication, {@code Scope.TEST} per test. Requires {@code -Dsandbox.enabled=true}.
            // Primary catalog should not regress across the relocation.
            Set<String> catalogAfter = DataFormatAwareITUtils.catalogFilesExcludingSegments(recovered);
            Set<String> primaryCatalogAfter = DataFormatAwareITUtils.catalogFilesExcludingSegments(primary);
        }
                )
                nonSegmentsFiles.isEmpty()
            IndexShard recovered = getIndexShard(primaryNodeName(), INDEX_NAME);
            .setTimeout(TimeValue.timeValueSeconds(60))
            // Every file from every generation must be on disk.
    /**
            IndexShard relocated = getIndexShard(targetNode, INDEX_NAME);
        ensureGreen(INDEX_NAME);
     * {@link #INDEX_NAME}. Throws {@link IllegalStateException} if no such replica exists.
    // * catalog ⊆ local-store-listing and catalog ⊆ remote-directory-listing on the target;
            IndexShard relocated = getIndexShard(targetNode, INDEX_NAME);
        Map<String, UploadedSegmentMetadata> uploadMapBefore = assertBusyAndReturn(() -> {
        ensureRed(INDEX_NAME);
        }
    /**
        return segments.keySet().stream().map(file -> new FileMetadata(file).dataFormat()).collect(Collectors.toSet());
        String sourceNodeId = internalCluster().clusterService(sourceNode).localNode().getId();
                    continue;
        for (int i = 0; i < count; i++) {
        String sourceReplicaNode = null;
        client().admin().indices().prepareFlush(INDEX_NAME).get();
     */
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
        int secondBatch = randomIntBetween(5, 15);
     *
        // Capture state before recovery: upload map + catalog
                ArrowBasePlugin.class,
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(replica);
    // plugin automatically slots into these checks without test-side changes.
        ensureGreen(INDEX_NAME);
            Map<String, UploadedSegmentMetadata> map = shard.getRemoteDirectory().getSegmentsUploadedToRemoteStore();
        // Verify doc count survived translog replay.
        }, 30, TimeUnit.SECONDS);
        return (T) holder[0];
 * this file be licensed under the Apache-2.0 license or a
            // The relocated primary's upload map must retain every pre-relocation file
            if (sep < 0) {
    }
            assertNotNull(meta);
import org.opensearch.common.unit.TimeValue;
        // Capture upload map before recovery
        } else {
            long parquetAfter = uploadMapAfter.keySet().stream().filter(f -> new FileMetadata(f).dataFormat().equals("parquet")).count();
        ensureGreen(INDEX_NAME);
        internalCluster().startClusterManagerOnlyNode();
        throw new IllegalStateException("node not found for id " + nodeId);
            assertTrue("formats must include parquet", formatsOf(meta.getMetadata()).contains("parquet"));
            assertTrue("formats must include parquet after recovery", formatsOf(meta.getMetadata()).contains("parquet"));
    }
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            .cluster()
     * Asserts that the shard's data path has no format-specific data files (parquet directory
    }
            assertNotNull("remote metadata must exist after flush", meta);
        assertEquals("primary must be on target node after relocation", targetNode, primaryNodeName());
            IndexShard recovered = getIndexShard(primaryNodeName(), INDEX_NAME);
            RemoteSegmentMetadata meta = recovered.getRemoteDirectory().readLatestMetadataFile();
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        assertEquals(
            assertNotNull(meta);
            RemoteSegmentMetadata meta = recovered.getRemoteDirectory().readLatestMetadataFile();
            RemoteSegmentMetadata meta = shard.getRemoteDirectory().readLatestMetadataFile();
        client().admin()
                .setRefreshPolicy(org.opensearch.action.support.WriteRequest.RefreshPolicy.NONE)
            } else {
        String primaryNode = primaryNodeName();
        Map<String, UploadedSegmentMetadata> uploadMapBefore = assertBusyAndReturn(() -> {
     * - parquet+lucene: segments_N plus additional segment data files (.si, .cfs, etc.)
            assertLuceneIndexDirContents(primary);
     */
    /** Whether lucene is configured as a secondary data format (produces searchable segment files). */
        // After recovery: all files from all generations must be on disk
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(0)).get();
     * receiving a partial segment set when the catalog references several flushed generations.
                + " but got "
        }, 60, TimeUnit.SECONDS);
        internalCluster().startClusterManagerOnlyNode();
                + expectedTotal
     *       store and replays the remote translog.</li>
    // ---------------------------------------------------------------------------------------
    }
        }
            assertNotNull(pMeta);
 * segments from the remote store and must end up with every format-specific file (Lucene +
                assertTrue("parquet directory must have files", entries.findAny().isPresent());
            // Every file from the original upload map must exist on the recovered shard's disk
        internalCluster().startClusterManagerOnlyNode();
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
        client().admin().indices().prepareClose(INDEX_NAME).get();
            IndexShard shard = getIndexShard(primaryNodeName(), INDEX_NAME);
    }
        internalCluster().restartNode(nodeName);
            // Catalog ⊆ local, catalog ⊆ remote.
            .build();
    // These tests validate the DFA invariants that must hold after a successful relocation:
        }, 60, TimeUnit.SECONDS);
            // Catalog must match local and remote
 * after recovery has all files matching the original.
            int docs = randomIntBetween(10, 25);
        internalCluster().stopRandomNode(s -> dataNode.equals(s));
            client().admin().indices().prepareFlush(INDEX_NAME).get();
            .execute()
        ensureGreen(INDEX_NAME);
     * started, {@link MoveAllocationCommand} moves the primary, and after relocation every
        internalCluster().startDataOnlyNodes(2);
            IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);
        // Use stats API: DFA's standard search path is not wired through IndexShard.acquireSearcherSupplier.
            assertUploadMapFilesOnDisk(uploadMapBefore, relocated);
        }, 60, TimeUnit.SECONDS);
        return Settings.builder()
        }, 60, TimeUnit.SECONDS);
        ensureGreen(INDEX_NAME);
        try (var stream = java.nio.file.Files.list(indexDir)) {
        // Capture state before relocation: upload map + catalog on the source primary.
        ensureGreen(INDEX_NAME);
            assertLuceneIndexDirContents(replica);
                LucenePlugin.class,
            .execute()
            Set<String> formats = formatsOf(meta.getMetadata());
    // (assertUploadMapFilesOnDisk, formatsOf, FileMetadata) that route any format prefix to the
     * Basic recovery with full file validation: verifies the new shard starts without format
        Set<String> catalogBefore = DataFormatAwareITUtils.catalogFilesExcludingSegments(getIndexShard(sourceNode, INDEX_NAME));
 * ({@code RemoteStorePeerRecoverySourceHandler}) with a catalog snapshot — the target downloads
                "parquet-only: index/ must have only segments_N (and write.lock), got extra: " + nonSegmentsFiles,
        String sourceNode = internalCluster().startDataOnlyNode();
            .prepareHealth()
            .put(remoteStoreIndexSettings(0, 1))
     * Primary relocation after multiple flush cycles. Multiple parquet generations must all be
        ).collect(Collectors.toList());
                }
        }, 30, TimeUnit.SECONDS);
            assertTrue("formats must include parquet", formatsOf(meta.getMetadata()).contains("parquet"));
        if (hasLuceneSecondary()) {
        String sourceNode = internalCluster().startDataOnlyNode();
     */
                if (originalFile.startsWith("segments_")) {
        ensureRed(INDEX_NAME);
            Map<String, UploadedSegmentMetadata> uploadMapAfter = relocated.getRemoteDirectory().getSegmentsUploadedToRemoteStore();
                .setRefreshPolicy(org.opensearch.action.support.WriteRequest.RefreshPolicy.NONE)
     * (modulo segments_N), new parquet files appear, and catalog/local/remote tiers stay in sync.
        client().admin().indices().prepareClose(INDEX_NAME).get();
        String dataNode = internalCluster().startDataOnlyNode();
        long parquetFilesBefore = uploadMapBefore.keySet().stream().filter(f -> new FileMetadata(f).dataFormat().equals("parquet")).count();
     * recovery path can correctly bound the replay range.
            // On a Lucene-only index the only format must be "lucene" — no parquet files.
    public void testPrimaryRelocationPreservesFormatMetadata() throws Exception {
            RemoteSegmentMetadata meta = relocated.getRemoteDirectory().readLatestMetadataFile();
        return getClusterState().routingTable()
            try (Stream<Path> entries = Files.list(parquetDir)) {
    /** Set of formats this index variant uses. Override in subclasses to add more formats. */
            int docs = randomIntBetween(10, 25);
            .actionGet();
            }
            assertFalse("upload map must not be empty", map.isEmpty());
            assertTrue("formats must include parquet", formatsOf(meta.getMetadata()).contains("parquet"));
import org.opensearch.indices.replication.common.ReplicationType;
        }, 60, TimeUnit.SECONDS);
        String dataNode = internalCluster().startDataOnlyNode();
            .put(remoteStoreIndexSettings(replicaCount, 1))
        }, 30, TimeUnit.SECONDS);
        // Phase 2: indexed but NOT committed — lives only in translog + remote translog
            // Upload map after new writes should be a superset of the original
            }
 * parquet) on local disk, a catalog equal to the source's pre-relocation catalog, and tier
    }
     * Fails the test if the relocation does not complete within {@code timeoutSeconds}.
        assertBusy(() -> {
    @Override
            assertFalse("upload map must not be empty", map.isEmpty());
import java.util.Map;
        client().admin().indices().prepareFlush(INDEX_NAME).get();
            RemoteSegmentMetadata meta = shard.getRemoteDirectory().readLatestMetadataFile();
                Files.isRegularFile(onDisk)
            RemoteSegmentMetadata meta = shard.getRemoteDirectory().readLatestMetadataFile();
            files = stream.map(p -> p.getFileName().toString()).collect(java.util.stream.Collectors.toSet());
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
    // present on the target's local disk in the correct format-specific subdirectory;
        client().admin().indices().prepareFlush(INDEX_NAME).get();
        ensureGreen(INDEX_NAME);
        ClusterHealthResponse health = client().admin()
     */
     * primary's uploaded files on disk and a catalog matching the primary's.
            assertNotNull("metadata must exist after relocation", meta);
        Map<String, UploadedSegmentMetadata> uploadMapBefore = assertBusyAndReturn(() -> {
            .prepareReroute()
                assertTrue(
        Map<String, UploadedSegmentMetadata> uploadMapBefore = assertBusyAndReturn(() -> {
        // Relocate primary source -> target.
        indexDocs(randomIntBetween(20, 50));
        assertFalse("upload map must not be empty", uploadMap.isEmpty());
            assertFalse("upload map must not be empty", map.isEmpty());
        ensureGreen(INDEX_NAME);
        indexDocs(randomIntBetween(10, 30));
            .actionGet();
        internalCluster().startClusterManagerOnlyNode();
            .cluster()
        }, 60, TimeUnit.SECONDS);
        internalCluster().startDataOnlyNode();
    private <T> T assertBusyAndReturn(CheckedSupplierWithReturn<T> supplier, long timeout, TimeUnit unit) throws Exception {
            // Every Lucene file on the source must be on the target's disk. assertUploadMapFilesOnDisk
            IndexShard recovered = getIndexShard(primaryNodeName(), INDEX_NAME);
        internalCluster().startClusterManagerOnlyNode();
            .actionGet();
            .add(new MoveAllocationCommand(INDEX_NAME, 0, sourceReplicaNodeId, targetNodeId))
            assertUploadMapFilesOnDisk(uploadMapBefore, recovered);
            .orElseThrow(() -> new IllegalStateException("no replica of " + INDEX_NAME + " found on node " + nodeName));
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(primary);
        ensureRed(INDEX_NAME);
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(relocated);
                formatsOf(meta.getMetadata()).contains("parquet")
     */
        internalCluster().startDataOnlyNode();
     */
import org.opensearch.be.lucene.LucenePlugin;
            assertTrue("formats must include parquet after restart", formatsOf(meta.getMetadata()).contains("parquet"));
            }
        );
            .cluster()
            .setWaitForNoRelocatingShards(true)
        // Capture upload map and catalog before recovery
            .cluster()
        // Start the relocation target.
        assertNotNull("chosen source node must host the replica", replicaNodeIdOn(sourceReplicaNode));
            .add(new MoveAllocationCommand(INDEX_NAME, 0, sourceNodeId, targetNodeId))
 * compatible open source license.
     */
import java.util.Set;
            // Catalog file set must equal the pre-relocation catalog (segments_N excluded).
            parquetFilesBefore > 1
                sourceReplicaNode = n;
    /**
        }, 60, TimeUnit.SECONDS);
            client().admin().indices().prepareRefresh(INDEX_NAME).get();
    protected void indexDocs(int count) {
        long parquetFilesBefore = uploadMapBefore.keySet().stream().filter(f -> new FileMetadata(f).dataFormat().equals("parquet")).count();
            Map<String, UploadedSegmentMetadata> map = shard.getRemoteDirectory().getSegmentsUploadedToRemoteStore();
            .replicaShards()
        if (Files.exists(parquetDir)) {
            assertUploadMapFilesOnDisk(uploadMapBefore, recovered);
        // Flush to materialize format files, then verify catalog + disk + remote upload
                parquetAfter > parquetBefore
            .setWaitForNodes("3")
     * matching catalog and format metadata.
            assertLuceneIndexDirContents(recovered);
        assertBusy(() -> {
     * data format module loaded), an index with no secondary formats — i.e. Lucene-only —
            assertNotNull(meta);
            indexDocsWithOffset(totalDocs, docs);
     */
        client().admin().indices().prepareFlush(INDEX_NAME).get();
        String targetNodeId = internalCluster().clusterService(targetNode).localNode().getId();
        }
     * transferred to the target, not just the latest one. Regression guard against the target
    // DataFormatAwareStoreDirectory, which routes Lucene files under <shard>/index/ and each
            int sep = originalName.indexOf('/');
        ensureGreen(INDEX_NAME);
        Map<String, UploadedSegmentMetadata> uploadMapBefore = assertBusyAndReturn(() -> {
    }
        // replica catalog equals primary catalog, replica tier agreement.
    }
     * intact on disk and catalog matching.
            IndexShard shard = getIndexShard(sourceNode, INDEX_NAME);
            for (String originalFile : uploadMapBefore.keySet()) {
        // Move replica from sourceReplicaNode to targetNode.
        assertEquals("primary must be on target node after relocation", targetNode, primaryNodeName());
            IndexShard relocated = getIndexShard(targetNode, INDEX_NAME);
            assertNotNull("metadata must exist after new writes", meta);
import org.opensearch.plugins.Plugin;
        internalCluster().startDataOnlyNode();
    public void testPrimaryRelocationWithMultipleFlushGenerations() throws Exception {
        internalCluster().startClusterManagerOnlyNode();
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(relocated);
import org.opensearch.parquet.ParquetDataFormatPlugin;
        String sourceNode = internalCluster().startDataOnlyNode();
            assertTrue("formats must include parquet after recovery", formatsOf(meta.getMetadata()).contains("parquet"));
                return nodeName;
            client().admin().indices().prepareFlush(INDEX_NAME).get();
        assertFalse("timed out waiting for target data node to join", joined.isTimedOut());
        }, 30, TimeUnit.SECONDS);
    public void testPrimaryRelocationPureLuceneBackwardCompatible() throws Exception {
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
                ParquetDataFormatPlugin.class,
        assertEquals(
            RemoteSegmentMetadata meta = recovered.getRemoteDirectory().readLatestMetadataFile();
        return Set.of("parquet", "lucene");
            );
            assertNotNull("metadata must exist after recovery", meta);
        assertBusy(() -> {
        java.util.Set<String> files;
            indexDocsWithOffset(totalDocs, docs);
     * <p>If the translog-replay path fails to skip operations whose seq_no is already covered by
            .stream()
            .put(super.nodeSettings(nodeOrdinal))
        internalCluster().fullRestart();
    /**
            }
            assertLuceneIndexDirContents(relocated);
                );
            .findFirst()
            assertEquals("catalog files must match before/after relocation", catalogBefore, catalogAfter);
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            assertTrue(
                String file = originalName.substring(sep + 1);
            assertFalse("upload map must not be empty", map.isEmpty());
        ensureGreen(INDEX_NAME);
        );
     * should not exist or be empty). This validates the shard starts clean before recovery.
                    randomAlphaOfLength(10),
/*
        assertBusy(() -> {
     * Basic primary relocation on a DFA index: source node holds the primary, a target node is
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(recovered);
        assertEquals("primary must be on target node after relocation", targetNode, primaryNodeName());
            assertFalse("parquet+lucene: index/ must have segment data files beyond segments_N, got " + files, nonSegmentsFiles.isEmpty());
            RemoteSegmentMetadata meta = shard.getRemoteDirectory().readLatestMetadataFile();
        for (int cycle = 0; cycle < 3; cycle++) {
            .setWaitForEvents(Priority.LANGUID)
     * Any value above that indicates a duplication regression.
            return map;
        }, 30, TimeUnit.SECONDS);
        assertTrue("should have multiple parquet files from multiple generations", parquetFilesBefore > 1);
            assertTrue("parquet must be in uploaded formats", formatsOf(meta.getMetadata()).contains("parquet"));
                + "Expected "
        java.nio.file.Path indexDir = shard.shardPath().resolveIndex();
    // * the relocated shard can continue writing and re-uploading format-aware files.
     */
        client().admin().indices().prepareFlush(INDEX_NAME).get();
            assertTrue("formats must include parquet", formatsOf(meta.getMetadata()).contains("parquet"));
    /**
     * {@link MoveAllocationCommand} and blocks until the cluster reports no relocating shards.
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
        // After recovery: all uploaded files must be on disk, catalog must match
            return map;
     * Full recovery, then write new docs and flush. Verifies the recovered shard can continue
            .setWaitForNodes("4")
    }
            .filter(expectedNodeId::equals)
     *   <li>Full cluster restart — the data node downloads durable files from the remote segment
        // Validate DFA invariants on the relocated primary.
            .actionGet();
            IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);
        internalCluster().stopRandomNode(s -> dataNode.equals(s));
        relocatePrimaryTo(sourceNode, targetNode, 60);
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
        // Intentionally NO flush — second batch must remain in translog only
        ensureGreen(INDEX_NAME);
        // Find the replica's current node by elimination: data node that is not the primary's.
        String targetNodeId = internalCluster().clusterService(targetNode).localNode().getId();
            .filter(f -> f.startsWith("segments_") == false && f.equals("write.lock") == false)
            Set<String> catalogAfter = DataFormatAwareITUtils.catalogFilesExcludingSegments(relocated);
            assertTrue(
    /**
            assertNotNull(meta);
    // (RemoteStorePeerRecoverySourceHandler), which takes a catalog snapshot on the source and
     *   <li>Index batch 2 → refresh only (resides in translog + remote translog only, NOT yet in
    protected void assertLuceneIndexDirContents(IndexShard shard) throws java.io.IOException {
            return map;
            .cluster()
    protected void indexDocsWithOffset(int offset, int count) {
        // Primary must actually be on the target node now.
    }
                .get();
            assertFalse("upload map must not be empty", map.isEmpty());
        ensureGreen(INDEX_NAME);
            // Every file the source had uploaded must exist on the target's disk.
        Settings luceneSettings = Settings.builder()
            expectedTotal,
 * ITs for DFA remote store RECOVERY and SHARD RELOCATION flows.
    public void testRemoteStoreRecoveryWithMultipleFlushGenerations() throws Exception {
     * Index docs WITHOUT flush (translog only), stop node, restore, verify the shard
            Set<String> replicaCatalogAfter = DataFormatAwareITUtils.catalogFilesExcludingSegments(replica);
 * <p>Shard relocation tests cover moving a live shard between nodes via {@link MoveAllocationCommand}.
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreRequest;
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
            assertLuceneIndexDirContents(shard);
            Map<String, UploadedSegmentMetadata> map = shard.getRemoteDirectory().getSegmentsUploadedToRemoteStore();
        assertEquals("primary must be on target node after relocation", targetNode, primaryNodeName());
        return Stream.concat(
        ensureGreen(INDEX_NAME);
            assertFalse("upload map must not be empty", map.isEmpty());
    // non-default format (e.g. parquet) under <shard>/<format>/.
        String dataNode = internalCluster().startDataOnlyNode();
        indexDocs(docCount);
        relocatePrimaryTo(sourceNode, targetNode, 60);
import org.opensearch.common.util.FeatureFlags;
package org.opensearch.composite;
            return map;
            .cluster()
    // {@link #testPrimaryRelocationPureLuceneBackwardCompatible}, which disables the pluggable
        // Phase 1: indexed AND committed (durable in Parquet/Lucene; uploaded to remote segment store)
        int firstBatch = randomIntBetween(10, 30);
                    "original file must still be in upload map after new writes: " + originalFile,
                    continue;
        assertNotNull("replica must be on target node after relocation", replicaNodeIdOn(targetNode));
        }
            assertFalse("upload map must not be empty", map.isEmpty());
        client().admin()
            assertNotNull("metadata must exist after relocation", meta);
    public void testTranslogReplayDoesNotDuplicateRowsWithRemoteStore() throws Exception {
        return true;
     * matching the invariants of {@link DataFormatAwareReplicationIT}.
        Map<String, UploadedSegmentMetadata> uploadMapBefore = assertBusyAndReturn(() -> {
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(recovered);
        assertTrue(
            IndexShard shard = getIndexShard(primaryNodeName(), INDEX_NAME);
     * Multiple flush cycles creating multiple parquet generations, then full remote store
     * Asserts that the index/ directory on the shard contains the expected Lucene files:
            assertLuceneIndexDirContents(shard);
        // Write new docs after recovery
            RemoteSegmentMetadata meta = shard.getRemoteDirectory().readLatestMetadataFile();
     * Moves the primary of {@link #INDEX_NAME} from {@code sourceNode} to {@code targetNode} via a
        // Wait for initial replication to converge so the replica has a full catalog to carry.
            assertLuceneIndexDirContents(relocated);
            .cluster()
        Map<String, UploadedSegmentMetadata> uploadMapBefore = assertBusyAndReturn(() -> {
