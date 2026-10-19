import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
        ensureGreen(INDEX_NAME);  
                formatsOf(meta.getMetadata()).contains("parquet")
    //
    }  
    }  
     * <p>This exercises the replica-target peer-recovery path for DFA: the relocated replica is
            assertFalse("upload map must not be empty", map.isEmpty());
            Map<String, UploadedSegmentMetadata> map = shard.getRemoteDirectory().getSegmentsUploadedToRemoteStore();  
            assertTrue("formats must include parquet after new writes", formatsOf(meta.getMetadata()).contains("parquet"));
            Map<String, UploadedSegmentMetadata> map = shard.getRemoteDirectory().getSegmentsUploadedToRemoteStore();  
    // {@link #testPrimaryRelocationPureLuceneBackwardCompatible}, which disables the pluggable
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreRequest;
            // Catalog must match local and remote
     */
        Set<String> catalogBefore = DataFormatAwareITUtils.catalogFilesExcludingSegments(getIndexShard(primaryNodeName(), INDEX_NAME));
            client().prepareIndex(INDEX_NAME)
     * intact on disk and catalog matching.  
     * should not exist or be empty). This validates the shard starts clean before recovery.  
     * Asserts that the shard's data path has no format-specific data files (parquet directory
            assertNotNull("metadata must exist after new writes", meta);  
     * Asserts that the index/ directory on the shard contains the expected Lucene files:
            // All current files must be on disk  
        // Stop data node, start new one
            assertNotNull("remote metadata must exist after flush", meta);
        long expectedTotal = firstBatch + secondBatch;
        String dataNode = internalCluster().startDataOnlyNode();  
    protected static final String INDEX_NAME = "dfa-recovery-test-idx";
    // (RemoteStorePeerRecoverySourceHandler), which takes a catalog snapshot on the source and  
        String dataNode = internalCluster().startDataOnlyNode();
        client().admin().indices().prepareRefresh(INDEX_NAME).get();  
        String nodeName = primaryNodeName();
            assertTrue("formats must include parquet", formatsOf(meta.getMetadata()).contains("parquet"));
    public void testPrimaryRelocationPreservesFormatMetadata() throws Exception {  
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(recovered);  
        ensureGreen(INDEX_NAME);  
            IndexShard relocated = getIndexShard(targetNode, INDEX_NAME);
        client().admin().indices().prepareClose(INDEX_NAME).get();  
        String sourceNode = internalCluster().startDataOnlyNode();
            .setWaitForEvents(Priority.LANGUID)  
            .put(remoteStoreIndexSettings(0, 1))
     * translog without re-applying operations already committed to durable Parquet/Lucene files.
 * SPDX-License-Identifier: Apache-2.0
        Set<String> catalogBefore = DataFormatAwareITUtils.catalogFilesExcludingSegments(getIndexShard(primaryNodeName(), INDEX_NAME));
            assertTrue("formats must include parquet after relocation", formatsOf(meta.getMetadata()).contains("parquet"));  
     */
    }
            RemoteSegmentMetadata meta = shard.getRemoteDirectory().readLatestMetadataFile();  
            assertFalse("parquet+lucene: index/ must have segment data files beyond segments_N, got " + files, nonSegmentsFiles.isEmpty());  
     *
     */
    protected static Set<String> formatsOf(Map<String, UploadedSegmentMetadata> segments) {  
        return getClusterState().routingTable()  
            RemoteSegmentMetadata meta = recovered.getRemoteDirectory().readLatestMetadataFile();
                    "original file must still be in upload map after new writes: " + originalFile,
            RemoteSegmentMetadata meta = shard.getRemoteDirectory().readLatestMetadataFile();  
            // The relocated primary's upload map must retain every pre-relocation file
            IndexShard shard = getIndexShard(sourceNode, INDEX_NAME);
        if (hasLuceneSecondary()) {
        internalCluster().startClusterManagerOnlyNode();  
            for (String originalFile : uploadMapBefore.keySet()) {
     * - parquet-only: only segments_N (commit metadata)  
        indexDocs(firstBatch);  
            assertUploadMapFilesOnDisk(uploadMapAfter, recovered);
                + ". If actual > expected, translog replayed ops that were already in committed Parquet files.",
            assertNotNull("recovered shard must not be null", recovered);
        ensureGreen(INDEX_NAME);  
            // Catalog file set must match what was there before  
            assertFalse("upload map must not be empty", map.isEmpty());
import java.util.List;
                    "field_number",  
            Map<String, UploadedSegmentMetadata> map = shard.getRemoteDirectory().getSegmentsUploadedToRemoteStore();  
import java.util.Collection;
        assertNotNull("could not find replica's source node", sourceReplicaNode);  
        Set<String> catalogBefore = DataFormatAwareITUtils.catalogFilesExcludingSegments(getIndexShard(primaryNodeName(), INDEX_NAME));  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
     * Relocate the primary, then index + flush on the new primary. Verifies the relocated shard
    // Extensibility: all relocation assertions go through format-agnostic helpers
     * Uses the same file layout convention as {@link DataFormatAwareITUtils#assertPrimaryUploadMapOnReplicaDisk}:  
        String targetNodeId = internalCluster().clusterService(targetNode).localNode().getId();
        }
            assertTrue("formats must include parquet", formatsOf(meta.getMetadata()).contains("parquet"));
            assertFalse("upload map must not be empty", map.isEmpty());
            actualRows  
     *   <li>Index batch 1 → refresh + flush (writes durable Parquet/Lucene files; uploads to  
        ensureRed(INDEX_NAME);
            .execute()
        // Start the relocation target.  
    }
    @Override
    private String nodeNameFromId(String nodeId) {  
            .execute()
        indexDocs(randomIntBetween(20, 50));  
    @SuppressWarnings("unchecked")  
     * must still relocate cleanly. Every file the source uploaded (all under the Lucene default
                );  
 */  
            assertUploadMapFilesOnDisk(uploadMapBefore, recovered);
        // Use stats API: DFA's standard search path is not wired through IndexShard.acquireSearcherSupplier.
                CompositeDataFormatPlugin.class,
    private String replicaNodeIdOn(String nodeName) {
                assertTrue(  
        internalCluster().fullRestart();
        Map<String, UploadedSegmentMetadata> uploadMapBefore = assertBusyAndReturn(() -> {
        String sourceReplicaNodeId = internalCluster().clusterService(sourceReplicaNode).localNode().getId();  
        indexDocsWithOffset(firstBatch, secondBatch);  
            .shard(0)
            .prepareHealth()  
        }, 30, TimeUnit.SECONDS);  
            assertNotNull(meta);
                Files.isRegularFile(onDisk)
    //
import java.util.concurrent.TimeUnit;
        client().admin().indices().prepareFlush(INDEX_NAME).get();  
            assertLuceneIndexDirContents(shard);
        String dataNode = internalCluster().startDataOnlyNode();
     *   <li>Full cluster restart — the data node downloads durable files from the remote segment
            assertEquals("catalog files must match before/after restart", catalogBefore, catalogAfter);
        long parquetFilesBefore = uploadMapBefore.keySet().stream().filter(f -> new FileMetadata(f).dataFormat().equals("parquet")).count();
            // On a Lucene-only index the only format must be "lucene" — no parquet files.
        String dataNode = internalCluster().startDataOnlyNode();
        ClusterHealthResponse joined = client().admin()
        client().admin()
            .filter(expectedNodeId::equals)  
    public void testRemoteStoreRecoveryFromTranslogOnly() throws Exception {
        internalCluster().startClusterManagerOnlyNode();
            );
        // Start the relocation target and wait for the cluster to see it.
            .actionGet();
                if (originalFile.startsWith("segments_")) {  
            .put("index.pluggable.dataformat", "composite")  
            .build();  
            .setWaitForNodes("3")
     * {@link MoveAllocationCommand} and blocks until the cluster reports no relocating shards.
            .setWaitForNoRelocatingShards(true)
                    uploadMapAfter.containsKey(originalFile)
    /** Set of formats this index variant uses. Override in subclasses to add more formats. */  
    // ---------------------------------------------------------------------------------------  
            assertNotNull("metadata must exist after relocation", meta);  
                }
        assertBusy(() -> {  
 * close index, restore from remote store. They validate that the recovered shard starts empty and
    }
            IndexShard relocated = getIndexShard(targetNode, INDEX_NAME);
            assertFalse("upload map must not be empty", map.isEmpty());
        }
            .collect(java.util.stream.Collectors.toSet());
     *
            }
            RemoteSegmentMetadata meta = shard.getRemoteDirectory().readLatestMetadataFile();  
        return Settings.builder()
            assertNotNull("metadata must exist after relocation", meta);  
        // After relocation the replica must be on targetNode.
        relocatePrimaryTo(sourceNode, targetNode, 60);
            assertTrue("formats must include parquet", formatsOf(meta.getMetadata()).contains("parquet"));  
        ensureRed(INDEX_NAME);
        for (int i = 0; i < count; i++) {
            assertFalse("upload map must not be empty", map.isEmpty());
 * <p>Recovery tests cover the full restore-from-remote-store path: stop data node, start new node,  
            .stream()
    /**
            RemoteSegmentMetadata meta = relocated.getRemoteDirectory().readLatestMetadataFile();
            .cluster()  
        ensureGreen(INDEX_NAME);
    /**  
            assertLuceneIndexDirContents(replica);  
    /**  
        String nodeId = getClusterState().routingTable().index(INDEX_NAME).shard(0).primaryShard().currentNodeId();
                continue; // segments_N generation may differ
        assertFalse("timed out waiting for relocation target to join", joined.isTimedOut());  
                .setSource("field_text", randomAlphaOfLength(10), "field_keyword", randomAlphaOfLength(10), "field_number", (long) i)
            .actionGet();
            .putList("index.composite.secondary_data_formats", List.of("lucene"))
        // Validate DFA invariants on the relocated primary.
    protected Collection<Class<? extends Plugin>> nodePlugins() {
     */  
            assertTrue("formats must include parquet", formatsOf(pMeta.getMetadata()).contains("parquet"));
        assertEquals("primary must be on target node after relocation", targetNode, primaryNodeName());
            IndexShard recovered = getIndexShard(primaryNodeName(), INDEX_NAME);
    // present on the target's local disk in the correct format-specific subdirectory;
import org.opensearch.be.lucene.LucenePlugin;  
     * Fails the test if the relocation does not complete within {@code timeoutSeconds}.
            RemoteSegmentMetadata meta = relocated.getRemoteDirectory().readLatestMetadataFile();
                );  
        assertNotNull("replica must be on target node after relocation", replicaNodeIdOn(targetNode));  
        return Set.of("parquet", "lucene");
     * started, {@link MoveAllocationCommand} moves the primary, and after relocation every
            assertUploadMapFilesOnDisk(uploadMapBefore, relocated);  
        // After recovery: all files from all generations must be on disk  
        int firstBatch = randomIntBetween(10, 30);
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForNodes("3").get();  
        }, 30, TimeUnit.SECONDS);
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(1)).get();
        indexDocs(docCount);  
     * Moves the primary of {@link #INDEX_NAME} from {@code sourceNode} to {@code targetNode} via a  
        internalCluster().startDataOnlyNode();
            return map;  
        client().admin().indices().prepareFlush(INDEX_NAME).get();
        // Capture upload map and catalog before recovery
            RemoteSegmentMetadata meta = shard.getRemoteDirectory().readLatestMetadataFile();
            client().admin().indices().prepareFlush(INDEX_NAME).get();
            }  
        assertFalse("timed out waiting for target data node to join", joined.isTimedOut());
        return segments.keySet().stream().map(file -> new FileMetadata(file).dataFormat()).collect(Collectors.toSet());
            IndexShard recovered = getIndexShard(primaryNodeName(), INDEX_NAME);  
    protected Settings dfaIndexSettings(int replicaCount) {
        }, 60, TimeUnit.SECONDS);  
        ensureGreen(INDEX_NAME);
        }, 30, TimeUnit.SECONDS);
        internalCluster().restartNode(nodeName);
        String sourceNodeId = internalCluster().clusterService(sourceNode).localNode().getId();
                    "field_keyword",
        ensureGreen(INDEX_NAME);  
    // * catalog files excluding segments_N are equal on source (before) and target (after);
            long parquetBefore = uploadMapBefore.keySet().stream().filter(f -> new FileMetadata(f).dataFormat().equals("parquet")).count();
            .map(s -> s.currentNodeId())
            .restoreRemoteStore(new RestoreRemoteStoreRequest().indices(INDEX_NAME).restoreAllShards(true), PlainActionFuture.newFuture());
        client().admin()
    }
        }, 60, TimeUnit.SECONDS);  
                + "Expected "  
            assertUploadMapFilesOnDisk(uploadMapBefore, recovered);  
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
     */  
        // replica catalog equals primary catalog, replica tier agreement.  
        client().admin().indices().prepareClose(INDEX_NAME).get();  
        String targetNode = internalCluster().startDataOnlyNode();
            RemoteSegmentMetadata meta = shard.getRemoteDirectory().readLatestMetadataFile();
            } else {
            Stream.of(
     */
                    "field_text",
     */
 */  
    }
        indexDocs(randomIntBetween(20, 40));  
        internalCluster().stopRandomNode(s -> dataNode.equals(s));  
        assertBusy(() -> {
                if (originalFile.startsWith("segments_")) {  
    /**
            assertFalse("upload map must not be empty", map.isEmpty());
     * (modulo segments_N), new parquet files appear, and catalog/local/remote tiers stay in sync.
            Path parquetDir = recovered.shardPath().getDataPath().resolve("parquet");
            );  
                    continue;
            client().admin().indices().prepareStats(INDEX_NAME).clear().setDocs(true).get().getTotal().getDocs().getCount()
        client().admin().indices().prepareFlush(INDEX_NAME).get();
        assertNotNull("chosen source node must host the replica", replicaNodeIdOn(sourceReplicaNode));
        int totalDocs = 0;
        assertFalse("timed out waiting for relocation of " + INDEX_NAME + " from " + sourceNode + " to " + targetNode, health.isTimedOut());  
    /**
            // Remote store upload after recovery
    protected void assertLuceneIndexDirContents(IndexShard shard) throws java.io.IOException {  
            Map<String, UploadedSegmentMetadata> map = shard.getRemoteDirectory().getSegmentsUploadedToRemoteStore();  
            assertFalse("upload map must not be empty", map.isEmpty());
        Object[] holder = new Object[1];
            assertFalse("Lucene-only index must not contain parquet files: " + formats, formats.contains("parquet"));
            .cluster()
    }
    }  
     * uploaded file (across every format) must be on the target's disk with a matching catalog.
            assertUploadMapFilesOnDisk(uploadMapAfter, relocated);  
            if (sep < 0) {
     * recovery path can correctly bound the replay range.
            }
                ParquetDataFormatPlugin.class,  
        // Capture upload map before recovery
        String targetNode = internalCluster().startDataOnlyNode();
    protected void indexDocsWithOffset(int offset, int count) {  
        }  
        ClusterHealthResponse joined = client().admin()  
        assertBusy(() -> {
            Set<String> catalogAfter = DataFormatAwareITUtils.catalogFilesExcludingSegments(recovered);
/**  
        // Lucene-only index: same remote-store + segment replication setup, pluggable dataformat disabled.  
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(0)).get();
            Set<String> catalogAfter = DataFormatAwareITUtils.catalogFilesExcludingSegments(relocated);
            .prepareHealth()
        }
        ensureGreen(INDEX_NAME);
        assertBusy(() -> {
        internalCluster().startDataOnlyNodes(2);  
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(0)).get();  
        assertEquals("primary must be on target node after relocation", targetNode, primaryNodeName());
            assertNotNull(meta);
 * compatible open source license.
        // After recovery: all uploaded files must be on disk, catalog must match
                + actualRows  
        }  
    }
    private <T> T assertBusyAndReturn(CheckedSupplierWithReturn<T> supplier, long timeout, TimeUnit unit) throws Exception {
            .cluster()
            .prepareHealth()
     */
            // Upload map after new writes should be a superset of the original  
            assertTrue("formats must include parquet after recovery", formatsOf(meta.getMetadata()).contains("parquet"));  
    protected boolean hasLuceneSecondary() {  
            // Primary catalog should not regress across the relocation.  
            .restoreRemoteStore(new RestoreRemoteStoreRequest().indices(INDEX_NAME).restoreAllShards(true), PlainActionFuture.newFuture());  
        java.util.Set<String> files;  
            IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);
            .actionGet();
        assertEquals(
     * <p>Asserts that the post-restart doc count equals exactly {@code firstBatch + secondBatch}.  
        // downloads committed files from remote segment store, then replays the remote translog.
            int docs = randomIntBetween(10, 25);  
import org.opensearch.plugins.Plugin;
     * <p>This ensures the DFA relocation machinery degrades to a no-op for non-DFA indices.  
            indexDocsWithOffset(totalDocs, docs);
            assertTrue("parquet must be in uploaded formats", formatsOf(meta.getMetadata()).contains("parquet"));
            files = stream.map(p -> p.getFileName().toString()).collect(java.util.stream.Collectors.toSet());
        return (T) holder[0];
                .setRefreshPolicy(org.opensearch.action.support.WriteRequest.RefreshPolicy.NONE)  
     * </ol>  
        Map<String, UploadedSegmentMetadata> uploadMapBefore = assertBusyAndReturn(() -> {
        }, 30, TimeUnit.SECONDS);  
        internalCluster().stopRandomNode(s -> dataNode.equals(s));
    protected Set<String> expectedFormats() {
                return nodeName;  
            .setTimeout(TimeValue.timeValueSeconds(timeoutSeconds))  
            assertTrue("formats must include parquet", formatsOf(meta.getMetadata()).contains("parquet"));  
    public void testRemoteStoreRecoveryWithMultipleFlushGenerations() throws Exception {
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
            return map;
            assertUploadMapFilesOnDisk(uploadMapBefore, recovered);
                "formats must include parquet after new writes on relocated primary",
    //
        String primaryNode = primaryNodeName();
        assertBusy(() -> {  
        client().admin().indices().prepareFlush(INDEX_NAME).get();  
     * recovers and the engine opens successfully with translog replay.  
            client().admin().indices().prepareFlush(INDEX_NAME).get();  
    public void testPrimaryRestartRecoveryPreservesFormats() throws Exception {
            RemoteSegmentMetadata meta = recovered.getRemoteDirectory().readLatestMetadataFile();
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForNodes("3").get();  
            .setWaitForEvents(Priority.LANGUID)
        // Phase 1: indexed AND committed (durable in Parquet/Lucene; uploaded to remote segment store)
        internalCluster().startDataOnlyNode();
            assertLuceneIndexDirContents(recovered);
        // Verify doc count survived translog replay.  
 * parquet) on local disk, a catalog equal to the source's pre-relocation catalog, and tier
            .cluster()  
        client().admin().indices().prepareFlush(INDEX_NAME).get();
    public void testRemoteStoreRecoveryPreservesFormatMetadata() throws Exception {  
            Set<String> catalogAfter = DataFormatAwareITUtils.catalogFilesExcludingSegments(recovered);
    private interface CheckedSupplierWithReturn<T> {
                String format = originalName.substring(0, sep);
        String sourceNode = internalCluster().startDataOnlyNode();
            // Every file the source had uploaded must exist on the target's disk.
            RemoteSegmentMetadata meta = recovered.getRemoteDirectory().readLatestMetadataFile();
            // routes Lucene files (no "/" in the name) under <shard>/index/, exactly the path the  
    // DFA-enabled clusters does not regress the Lucene-only path.  
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(relocated);
        // Write new docs + flush on the relocated primary.  
            IndexShard recovered = getIndexShard(primaryNodeName(), INDEX_NAME);
        // Wait for initial replication to converge so the replica has a full catalog to carry.
    @FunctionalInterface
            assertTrue("shard must be started", recovered.routingEntry().started());  
 * after recovery has all files matching the original.
import org.opensearch.index.store.RemoteSegmentStoreDirectory.UploadedSegmentMetadata;  
            RemoteSegmentMetadata meta = shard.getRemoteDirectory().readLatestMetadataFile();
            .put("index.composite.primary_data_format", "parquet")
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(0)).get();  
            assertLuceneIndexDirContents(shard);
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(luceneSettings).get();  
            IndexShard shard = getIndexShard(primaryNodeName(), INDEX_NAME);  
        String sourceReplicaNode = null;
            assertFalse("upload map must not be empty", map.isEmpty());
    public void testPrimaryRelocationPureLuceneBackwardCompatible() throws Exception {
        internalCluster().startClusterManagerOnlyNode();  
        // Validate cross-shard invariants: primary-uploaded files on the relocated replica's disk,
            .put("index.pluggable.dataformat.enabled", true)
        assertBusy(() -> { holder[0] = supplier.get(); }, timeout, unit);  
        ensureGreen(INDEX_NAME);
        // Primary must actually be on the target node now.
public class DataFormatAwareRemoteStoreRecoveryIT extends RemoteStoreBaseIntegTestCase {
        }, 30, TimeUnit.SECONDS);
        }  
        internalCluster().startDataOnlyNode();
     *
        internalCluster().startClusterManagerOnlyNode();
            assertLuceneIndexDirContents(relocated);
import org.opensearch.common.util.FeatureFlags;  
                .get();  
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
import java.util.Set;
    protected void indexDocs(int count) {  
        return true;
    private void assertUploadMapFilesOnDisk(Map<String, UploadedSegmentMetadata> uploadMap, IndexShard shard) {  
            assertLuceneIndexDirContents(primary);  
            assertNotNull(meta);
 *
            .index(INDEX_NAME)
        assertBusy(() -> {
            .put(super.nodeSettings(nodeOrdinal))
            Set<String> formats = formatsOf(meta.getMetadata());  
        ensureGreen(INDEX_NAME);  
            "doc count must match after translog-only recovery",  
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(recovered);
        // Before restore: verify the new shard has no format data files  
        }  
            .restoreRemoteStore(new RestoreRemoteStoreRequest().indices(INDEX_NAME).restoreAllShards(true), PlainActionFuture.newFuture());  
import org.opensearch.cluster.metadata.IndexMetadata;
        ClusterHealthResponse health = client().admin()  
    }
import org.opensearch.action.support.PlainActionFuture;  
        internalCluster().startClusterManagerOnlyNode();
        client().admin()
        // Sanity: the node we just picked must actually host the replica.
        }
        // No flush — data only in translog
 *  
            return map;
    /** Whether lucene is configured as a secondary data format (produces searchable segment files). */
            assertTrue("formats must include parquet after recovery", formatsOf(meta.getMetadata()).contains("parquet"));
 * Unlike recovery, relocation uses the peer-recovery source path
            assertNotNull("metadata must exist after relocation", meta);
            .cluster()  
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(0)).get();  
    }
        for (String nodeName : internalCluster().getNodeNames()) {
                .get();
    // Shard relocation tests
        ensureGreen(INDEX_NAME);
        internalCluster().startClusterManagerOnlyNode();
        // Write new docs after recovery
            assertEquals("catalog files must match before/after recovery", catalogBefore, catalogAfter);  
            if (originalName.startsWith("segments_")) {  
            assertNotNull(meta);
            assertNotNull(pMeta);  
        assertTrue("should have multiple parquet files from multiple generations", parquetFilesBefore > 1);  
            .build();
    // non-default format (e.g. parquet) under <shard>/<format>/.  
            assertEquals("catalog files must match before/after recovery", catalogBefore, catalogAfter);
import org.opensearch.arrow.allocator.ArrowBasePlugin;
            assertNotNull("metadata must exist after recovery", meta);
            }
            .setWaitForNodes("4")  
        ensureRed(INDEX_NAME);  
            .put("index.pluggable.dataformat.enabled", false)
        // Find the replica's current node by elimination: data node that is not the primary's.  
    }
                DataFusionPlugin.class  
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
     * Resolves the id of the replica currently assigned to {@code nodeName} for shard 0 of
            IndexShard shard = getIndexShard(sourceNode, INDEX_NAME);  
     * Primary relocation after multiple flush cycles. Multiple parquet generations must all be
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).setWaitIfOngoing(true).get();
            assertNotNull("metadata must exist after recovery", meta);
    // * every file the source uploaded to remote (across Lucene + non-default formats) is  
    public void testRemoteStoreRecoveryThenNewWrites() throws Exception {  
            .cluster()  
            DataFormatAwareITUtils.assertPrimaryUploadMapOnReplicaDisk(primary, replica);
        assertEquals(
            .cluster()
            .cluster()
import java.util.stream.Collectors;  
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(0)).get();
     * {@link #INDEX_NAME}. Throws {@link IllegalStateException} if no such replica exists.
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
    // * catalog ⊆ local-store-listing and catalog ⊆ remote-directory-listing on the target;  
    /**
            assertTrue("parquet directory must exist after flush", Files.exists(parquetDir));  
            for (String originalFile : uploadMapBefore.keySet()) {
                )
     * Index docs WITHOUT flush (translog only), stop node, restore, verify the shard
            Set<String> catalogAfter = DataFormatAwareITUtils.catalogFilesExcludingSegments(relocated);
            .prepareReroute()  
            // target's DataFormatAwareStoreDirectory (or plain FSDirectory if DFA is off) will use.
                    uploadMapAfter.containsKey(originalFile)
            IndexShard shard = getIndexShard(primaryNodeName(), INDEX_NAME);  
            Set<String> replicaCatalogAfter = DataFormatAwareITUtils.catalogFilesExcludingSegments(replica);
            // Every file from every generation must be on disk.  
            RemoteSegmentMetadata meta = relocated.getRemoteDirectory().readLatestMetadataFile();
            assertEquals("primary catalog must be stable across replica relocation", primaryCatalogBefore, primaryCatalogAfter);
     * Helper that runs an assertion block with assertBusy semantics but returns a value.
            assertLuceneIndexDirContents(recovered);  
import java.util.stream.Stream;
     * Backward-compatibility guard: on the same plugin + cluster configuration (pluggable  
            // Format files on disk
            .prepareReroute()
    // ---------------------------------------------------------------------------------------
import org.opensearch.indices.replication.common.ReplicationType;
 * <p>Shard relocation tests cover moving a live shard between nodes via {@link MoveAllocationCommand}.
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(replica);
            assertTrue(  
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(0)).get();
    }  
        return Stream.concat(
            .execute()
            assertNotNull(meta);
    }
        internalCluster().stopRandomNode(s -> dataNode.equals(s));
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
        ensureGreen(INDEX_NAME);
            assertNotNull(meta);
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(relocated);
            .actionGet();  
        for (int i = 0; i < count; i++) {
 * ITs for DFA remote store RECOVERY and SHARD RELOCATION flows.
        client().admin().indices().prepareClose(INDEX_NAME).get();
        String targetNode = internalCluster().startDataOnlyNode();
        client().admin().indices().prepareClose(INDEX_NAME).get();
        assertEquals("primary must be on target node after relocation", targetNode, primaryNodeName());
            assertTrue(
     *
            assertEquals("catalog files must match before/after relocation", catalogBefore, catalogAfter);
                onDisk = shard.shardPath().getDataPath().resolve(format).resolve(file);
        // Flush to materialize format files, then verify catalog + disk + remote upload
                parquetAfter > parquetBefore  
            .put(remoteStoreIndexSettings(replicaCount, 1))  
        // Full cluster restart — exercises the realistic disaster-recovery path: data node restarts,  
     * Restart primary node (not full restore), verify it recovers with all format files
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(0)).get();
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(0)).get();
            IndexShard shard = getIndexShard(primaryNodeName(), INDEX_NAME);  
            assertTrue("formats must include parquet before relocation", formatsOf(meta.getMetadata()).contains("parquet"));  
            assertUploadMapFilesOnDisk(uploadMapBefore, relocated);
            int docs = randomIntBetween(10, 25);
 * The OpenSearch Contributors require contributions made to  
            RemoteSegmentMetadata meta = shard.getRemoteDirectory().readLatestMetadataFile();
            int sep = originalName.indexOf('/');
        long parquetFilesBefore = uploadMapBefore.keySet().stream().filter(f -> new FileMetadata(f).dataFormat().equals("parquet")).count();
            client().prepareIndex(INDEX_NAME)
        }, 60, TimeUnit.SECONDS);
            IndexShard recovered = getIndexShard(primaryNodeName(), INDEX_NAME);  
    }
 * this file be licensed under the Apache-2.0 license or a
    /**
                break;  
            assertLuceneIndexDirContents(relocated);
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)  
    }
        if (Files.exists(parquetDir)) {
 *
                .setSource(
            RemoteSegmentMetadata pMeta = primary.getRemoteDirectory().readLatestMetadataFile();
     * {@code max_seq_no} tracking in commit user-data; for DFA the {@link
    }
            try (Stream<Path> entries = Files.list(parquetDir)) {
    private void assertNoFormatFilesOnDisk(IndexShard shard) throws Exception {
            .build();
     * org.opensearch.index.engine.exec.coord.CatalogSnapshot} must carry the equivalent so the  
    }
            // Catalog ⊆ local, catalog ⊆ remote.
            Map<String, UploadedSegmentMetadata> uploadMapAfter = recovered.getRemoteDirectory().getSegmentsUploadedToRemoteStore();
            assertTrue("Lucene-only index must have lucene format present: " + formats, formats.contains("lucene"));
                assertTrue("parquet directory must have files", entries.findAny().isPresent());
     * This is the DFA analogue of {@link #testRemoteStoreRecoveryPreservesFormatMetadata} but  
        internalCluster().startClusterManagerOnlyNode();
        );
        // Phase 2: indexed but NOT committed — lives only in translog + remote translog
    // drives phase1 — the target downloads segments from the remote store into its local
        Path parquetDir = shard.shardPath().getDataPath().resolve("parquet");  
        // Move replica from sourceReplicaNode to targetNode.
            }
     * can continue producing format-aware writes: the new upload map is a superset of the original  
        internalCluster().startClusterManagerOnlyNode();  
            Map<String, UploadedSegmentMetadata> uploadMapAfter = relocated.getRemoteDirectory().getSegmentsUploadedToRemoteStore();
        client().admin()
            .execute()
        Set<String> primaryCatalogBefore = DataFormatAwareITUtils.catalogFilesExcludingSegments(getIndexShard(primaryNode, INDEX_NAME));
            .setWaitForEvents(Priority.LANGUID)
 * ({@code RemoteStorePeerRecoverySourceHandler}) with a catalog snapshot — the target downloads  
import org.opensearch.index.shard.IndexShard;
     * data format module loaded), an index with no secondary formats — i.e. Lucene-only —
            Set<String> primaryCatalogAfter = DataFormatAwareITUtils.catalogFilesExcludingSegments(primary);  
    public void testPrimaryRelocationWithMultipleFlushGenerations() throws Exception {
        String targetNode = internalCluster().startDataOnlyNode();
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shard);
     * relocates the replica onto the third node, and validates the replica ends up with the
        }, 60, TimeUnit.SECONDS);  
     */
            IndexShard shard = getIndexShard(primaryNodeName(), INDEX_NAME);
        ensureGreen(INDEX_NAME);
     * transferred to the target, not just the latest one. Regression guard against the target
            // Every file from the original upload map must exist on the recovered shard's disk
        internalCluster().startClusterManagerOnlyNode();
        assertBusy(() -> {
     * receiving a partial segment set when the catalog references several flushed generations.  
package org.opensearch.composite;
        internalCluster().startClusterManagerOnlyNode();
    /**
            assertEquals("primary/replica catalogs must match after replica relocation", primaryCatalogAfter, replicaCatalogAfter);
            try (var snapshotRef = recovered.getCatalogSnapshot()) {  
import java.nio.file.Path;  
            Map<String, UploadedSegmentMetadata> map = shard.getRemoteDirectory().getSegmentsUploadedToRemoteStore();
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
    /**  
        }, 60, TimeUnit.SECONDS);
        ensureRed(INDEX_NAME);
            assertUploadMapFilesOnDisk(uploadMapBefore, relocated);
            )
    /**
            return map;
            long parquetAfter = uploadMapAfter.keySet().stream().filter(f -> new FileMetadata(f).dataFormat().equals("parquet")).count();  
            IndexShard recovered = getIndexShard(primaryNodeName(), INDEX_NAME);
        );  
        Map<String, UploadedSegmentMetadata> uploadMapBefore = assertBusyAndReturn(() -> {
        ensureGreen(INDEX_NAME);
import org.opensearch.index.store.remote.metadata.RemoteSegmentMetadata;
        Settings luceneSettings = Settings.builder()
        );  
            .execute()  
        relocatePrimaryTo(sourceNode, targetNode, 60);
        indexDocs(randomIntBetween(10, 30));  
        Map<String, UploadedSegmentMetadata> uploadMapBefore = assertBusyAndReturn(() -> {
     * Full recovery, then write new docs and flush. Verifies the recovered shard can continue  
            if (internalCluster().clusterService(nodeName).localNode().getId().equals(nodeId)) {
     */
        internalCluster().startClusterManagerOnlyNode();  
            .setWaitForNoRelocatingShards(true)
        assertFalse("timed out waiting for replica relocation", health.isTimedOut());
        }, 30, TimeUnit.SECONDS);  
    /**
            assertTrue("formats must include parquet after relocation", formatsOf(meta.getMetadata()).contains("parquet"));
        ClusterHealthResponse health = client().admin()
 *
            super.nodePlugins().stream(),  
     * <ol>
     * recovery. Validates all generation files are recovered to disk.
            .add(new MoveAllocationCommand(INDEX_NAME, 0, sourceNodeId, targetNodeId))
import org.opensearch.common.unit.TimeValue;
        Set<String> catalogBefore = DataFormatAwareITUtils.catalogFilesExcludingSegments(getIndexShard(sourceNode, INDEX_NAME));
        String targetNodeId = internalCluster().clusterService(targetNode).localNode().getId();  
        int totalDocs = 0;
}
                + expectedTotal
        client().admin().indices().prepareFlush(INDEX_NAME).get();  
                    randomAlphaOfLength(10),  
    // Backward compatibility: a pure-Lucene (no secondary format) relocation is exercised by  
        for (String n : internalCluster().getNodeNames()) {  
     * Basic primary relocation on a DFA index: source node holds the primary, a target node is  
        return nodeNameFromId(nodeId);  
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
            .add(new MoveAllocationCommand(INDEX_NAME, 0, sourceReplicaNodeId, targetNodeId))
     * bootstrapped from the remote store via {@code RemoteStoreReplicationSource}; after  
    public void testReplicaRelocationPreservesFormatMetadata() throws Exception {
            if (!n.equals(primaryNode) && !n.equals(internalCluster().getClusterManagerName())) {
        throw new IllegalStateException("node not found for id " + nodeId);  
            assertNotNull(meta);
        }, 30, TimeUnit.SECONDS);
        client().admin()
import org.opensearch.common.settings.Settings;
    /**
            Map<String, UploadedSegmentMetadata> map = shard.getRemoteDirectory().getSegmentsUploadedToRemoteStore();
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
    //  
            assertEquals("catalog files must match before/after relocation", catalogBefore, catalogAfter);  
            .prepareHealth()
        internalCluster().startDataOnlyNode();
     * Replica shard relocation. Creates a primary + 1 replica on two nodes, starts a third node,
        client().admin().indices().prepareFlush(INDEX_NAME).get();
    // These tests validate the DFA invariants that must hold after a successful relocation:
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(recovered);
            docCount,
            .actionGet();  
            IndexShard shard = getIndexShard(sourceNode, INDEX_NAME);  
            Map<String, UploadedSegmentMetadata> map = shard.getRemoteDirectory().getSegmentsUploadedToRemoteStore();
            // Every Lucene file on the source must be on the target's disk. assertUploadMapFilesOnDisk
        relocatePrimaryTo(sourceNode, targetNode, 60);
        }, 30, TimeUnit.SECONDS);  
            assertEquals("parquet directory should be empty before recovery, found " + fileCount + " files", 0, fileCount);  
            return map;  
     *   <li>Index batch 2 → refresh only (resides in translog + remote translog only, NOT yet in
        // Capture state before recovery: upload map + catalog
        }, 60, TimeUnit.SECONDS);  
            totalDocs += docs;
            final Path onDisk;  
     * exercises the peer-recovery source path instead of the remote-store restore path.
    /**  
                LucenePlugin.class,
        // Capture state before relocation: upload map + catalog on the source primary.
            assertNotNull("metadata must exist after restart", meta);
        assertTrue(  
                    continue;
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(0)).get();  
    }
        }, 60, TimeUnit.SECONDS);  
            // Catalog file set must equal the pre-relocation catalog (segments_N excluded).  
     * <p>If the translog-replay path fails to skip operations whose seq_no is already covered by
            .cluster()
    }
     * already-restored Parquet files → duplicate rows. The standard Lucene engine handles this via
 * <p>SEGMENT replication, {@code Scope.TEST} per test. Requires {@code -Dsandbox.enabled=true}.
        ensureGreen(INDEX_NAME);
            .setTimeout(TimeValue.timeValueSeconds(60))
        assertTrue("index/ must contain segments_N, got " + files, files.stream().anyMatch(f -> f.startsWith("segments_")));
                assertFalse("catalog snapshot must have segments after flush", snapshotRef.get().getSegments().isEmpty());
     * catalog must match.
        client().admin().indices().prepareRefresh(INDEX_NAME).get();  
    }
                ArrowBasePlugin.class,
        indexDocsWithOffset(1000, randomIntBetween(10, 25));
        internalCluster().startDataOnlyNode();
     *       store and replays the remote translog.</li>
            return map;
    // Relocation is a distinct code path from recovery. The source shard stays live throughout;
     */
    private void relocatePrimaryTo(String sourceNode, String targetNode, int timeoutSeconds) {
            IndexShard relocated = getIndexShard(targetNode, INDEX_NAME);  
        for (String originalName : uploadMap.keySet()) {
        // Relocate primary source -> target.  
            client().admin().indices().prepareRefresh(INDEX_NAME).get();
            }
            Map<String, UploadedSegmentMetadata> map = shard.getRemoteDirectory().getSegmentsUploadedToRemoteStore();  
        java.util.Set<String> nonSegmentsFiles = files.stream()
     * Any value above that indicates a duplication regression.
        internalCluster().stopRandomNode(s -> dataNode.equals(s));  
                "parquet-only: index/ must have only segments_N (and write.lock), got extra: " + nonSegmentsFiles,  
    }
        }
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
    /**  
        Map<String, UploadedSegmentMetadata> uploadMapBefore = assertBusyAndReturn(() -> {
                "file from upload map must exist on recovered shard disk: " + onDisk + " (originalName=" + originalName + ")",
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
        Map<String, UploadedSegmentMetadata> uploadMapBefore = assertBusyAndReturn(() -> {
            IndexShard shard = getIndexShard(sourceNode, INDEX_NAME);
        assertBusy(() -> {  
    // correct shard subdirectory via FileMetadata's delimiter convention. A new DataFormat
                onDisk = shard.shardPath().resolveIndex().resolve(originalName);  
        T get() throws Exception;  
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForNodes("3").get();  
            );
            .cluster()
     * <strong>DFA correctness regression guard:</strong> recovery from remote store must replay
        String expectedNodeId = internalCluster().clusterService(nodeName).localNode().getId();
        long actualRows = client().admin().indices().prepareStats(INDEX_NAME).clear().setDocs(true).get().getTotal().getDocs().getCount();
            RemoteSegmentMetadata meta = recovered.getRemoteDirectory().readLatestMetadataFile();  
        return Settings.builder()
                nonSegmentsFiles.isEmpty()
            parquetFilesBefore > 1
        client().admin().indices().prepareFlush(INDEX_NAME).get();
        assertBusy(() -> {  
        relocatePrimaryTo(sourceNode, targetNode, 60);
                    "pre-relocation file must still be in upload map after new writes: " + originalFile,
    }
        indexDocs(randomIntBetween(10, 30));  
        indexDocs(randomIntBetween(20, 50));  
        }, 30, TimeUnit.SECONDS);  
            .findFirst()
            assertNotNull("metadata must exist after new writes on relocated primary", meta);
    // the target is bootstrapped via the peer-recovery source handler
            .restoreRemoteStore(new RestoreRemoteStoreRequest().indices(INDEX_NAME).restoreAllShards(true), PlainActionFuture.newFuture());
    }
     */  
import org.opensearch.index.store.FileMetadata;
        Set<String> catalogBefore = DataFormatAwareITUtils.catalogFilesExcludingSegments(getIndexShard(sourceNode, INDEX_NAME));  
        ensureGreen(INDEX_NAME);
        }, 60, TimeUnit.SECONDS);
        for (int cycle = 0; cycle < 3; cycle++) {  
    /**
     * writing in the correct format, uploading new files, and maintaining catalog consistency.
            assertTrue("formats must include parquet", formatsOf(meta.getMetadata()).contains("parquet"));  
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
     * primary's uploaded files on disk and a catalog matching the primary's.  
        assertBusy(() -> {
        client().admin().indices().prepareFlush(INDEX_NAME).get();
        ensureGreen(INDEX_NAME);
    public void testTranslogReplayDoesNotDuplicateRowsWithRemoteStore() throws Exception {  
import org.opensearch.be.datafusion.DataFusionPlugin;
            assertTrue("formats must include parquet after restart", formatsOf(meta.getMetadata()).contains("parquet"));  
        // Full remote store recovery  
                assertTrue(  
     */
        int docCount = randomIntBetween(10, 30);
            expectedTotal,
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(shard);
            }
 * agreement between catalog, local disk, and remote directory.  
     * format, living under {@code <shard>/index/}) must land on the target's disk and the  
        Map<String, UploadedSegmentMetadata> uploadMapBefore = assertBusyAndReturn(() -> {
                }
            assertLuceneIndexDirContents(recovered);  
import org.opensearch.test.OpenSearchIntegTestCase;  
    // (assertUploadMapFilesOnDisk, formatsOf, FileMetadata) that route any format prefix to the  
     * the recovered commit's local checkpoint, batch 1 ops would be re-applied on top of the  
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(relocated);  
            IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);
     */
     *  
        assertEquals("primary must be on target node after relocation", targetNode, primaryNodeName());
    }  
        for (int cycle = 0; cycle < 3; cycle++) {
        ensureGreen(INDEX_NAME);
            .filter(f -> f.startsWith("segments_") == false && f.equals("write.lock") == false)  
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(primary);
import java.nio.file.Files;
     * - parquet+lucene: segments_N plus additional segment data files (.si, .cfs, etc.)
     * Lucene files under {@code <shard>/index/}, non-default format files under {@code <shard>/<format>/}.
        } else {
 * segments from the remote store and must end up with every format-specific file (Lucene +
        // Full remote store recovery
        }, 60, TimeUnit.SECONDS);
        indexDocs(randomIntBetween(20, 40));
     * matching catalog and format metadata.
        assertTrue("index/ directory must exist", java.nio.file.Files.exists(indexDir));
     * files, and after remote store recovery all uploaded files are present on disk with  
    }
        int secondBatch = randomIntBetween(5, 15);
            "Translog replay must NOT duplicate rows already committed to Parquet. "
    /**
    @Override  
        internalCluster().startDataOnlyNode();  
        ).collect(Collectors.toList());
     */
    // * the relocated shard can continue writing and re-uploading format-aware files.
    // DataFormatAwareStoreDirectory, which routes Lucene files under <shard>/index/ and each
            indexDocsWithOffset(totalDocs, docs);
        client().admin()
            return map;  
    // data format and verifies the tests still hold — this ensures the relocation contract on
            .actionGet();
            RemoteSegmentMetadata meta = relocated.getRemoteDirectory().readLatestMetadataFile();
    public void testPrimaryRelocationThenNewWrites() throws Exception {  
        ensureGreen(INDEX_NAME);  
        }, 60, TimeUnit.SECONDS);
            IndexShard replica = getIndexShard(targetNode, INDEX_NAME);  
            IndexShard relocated = getIndexShard(targetNode, INDEX_NAME);  
            }
            // Catalog snapshot state: non-empty, has segments
import org.opensearch.parquet.ParquetDataFormatPlugin;  
                sourceReplicaNode = n;
     * Asserts that every file from the upload map exists on the recovered shard's local disk.
            .setWaitForEvents(Priority.LANGUID)  
            assertTrue(
                .setRefreshPolicy(org.opensearch.action.support.WriteRequest.RefreshPolicy.NONE)  
        indexDocs(randomIntBetween(20, 50));
            // (segments_N excluded) and gain at least one new parquet file from the post-relocation flush.  
        ensureGreen(INDEX_NAME);  
     * <p>Scenario:
            RemoteSegmentMetadata meta = recovered.getRemoteDirectory().readLatestMetadataFile();  
import org.opensearch.common.Priority;  
            assertTrue("formats must include parquet", formatsOf(meta.getMetadata()).contains("parquet"));  
            long fileCount = Files.list(parquetDir).count();
            assertNotNull(meta);
            .orElseThrow(() -> new IllegalStateException("no replica of " + INDEX_NAME + " found on node " + nodeName));
        ensureGreen(INDEX_NAME);  
        String sourceNode = internalCluster().startDataOnlyNode();
            assertTrue(  
        // Capture state before restart  
        // Intentionally NO flush — second batch must remain in translog only
     *       remote segment store).</li>
        indexDocsWithOffset(1000, randomIntBetween(10, 25));
    }
    protected Settings nodeSettings(int nodeOrdinal) {  
    // plugin automatically slots into these checks without test-side changes.
            "precondition: should have multiple parquet files from multiple generations, got " + parquetFilesBefore,
            assertLuceneIndexDirContents(relocated);  
            return map;
                String file = originalName.substring(sep + 1);  
        java.nio.file.Path indexDir = shard.shardPath().resolveIndex();
/*  
            totalDocs += docs;  
     */  
        assertBusy(() -> {  
import java.util.Map;  
        String sourceNode = internalCluster().startDataOnlyNode();
                    (long) (offset + i)
            Set<String> catalogAfter = DataFormatAwareITUtils.catalogFilesExcludingSegments(recovered);  
            assertLuceneIndexDirContents(recovered);
                    randomAlphaOfLength(10),
     * relocation it must converge with the primary on catalog and format-specific files on disk,
    /**  
        client().admin().indices().prepareFlush(INDEX_NAME).get();
            .replicaShards()  
     *       any committed format file).</li>  
        ensureGreen(INDEX_NAME);
            RemoteSegmentMetadata meta = shard.getRemoteDirectory().readLatestMetadataFile();
     * Basic recovery with full file validation: verifies the new shard starts without format
     * matching the invariants of {@link DataFormatAwareReplicationIT}.
        assertFalse("upload map must not be empty", uploadMap.isEmpty());
                + " but got "
            );  
    protected String primaryNodeName() {
            .execute()  
        Map<String, UploadedSegmentMetadata> uploadMapBefore = assertBusyAndReturn(() -> {
     * Multiple flush cycles creating multiple parquet generations, then full remote store
     */
                "relocated primary must produce new parquet files (before=" + parquetBefore + ", after=" + parquetAfter + ")",
        try (var stream = java.nio.file.Files.list(indexDir)) {
        ensureGreen(INDEX_NAME);  
        String targetNode = internalCluster().startDataOnlyNode();
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(recovered);  
        }
            client().admin().indices().prepareRefresh(INDEX_NAME).get();
