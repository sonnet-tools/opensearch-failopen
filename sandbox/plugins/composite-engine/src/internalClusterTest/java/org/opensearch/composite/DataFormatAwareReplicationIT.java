        Files.write(orphan, new byte[] { 0x50, 0x41, 0x52, 0x31 });  // "PAR1" magic — irrelevant to the test
import org.opensearch.common.util.FeatureFlags;  
                    "primary/replica versions must match at cycle " + iteration,  
            );  
                    DataFormatAwareITUtils.catalogFilesExcludingSegments(primary),  
            assertEquals(
                .readLatestMetadataFile()  
            RemoteSegmentMetadata rMeta = recoveredReplica.getRemoteDirectory().readLatestMetadataFile();  
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(replicaCount)).get();
                DataFusionPlugin.class  
            assertEquals("expected 2 replicas, got " + replicaNodes, 2, replicaNodes.size());
        assertBusy(() -> {
     * are <em>not</em> referenced by the restored catalog snapshot must be physically removed by  
     * Asserts that the index/ directory on the shard contains the expected Lucene files:
                    rMeta.getReplicationCheckpoint().getSegmentInfosVersion()
     * (wired through {@code DataFormatAwareNRTReplicationEngine}).
        return segments.keySet().stream().map(file -> new FileMetadata(file).dataFormat()).collect(Collectors.toSet());
            assertEquals(  
            if (internalCluster().clusterService(nodeName).localNode().getId().equals(nodeId)) {
        assertTrue("index/ must contain segments_N, got " + files, files.stream().anyMatch(f -> f.startsWith("segments_")));
            for (String catalogFile : catalogAfter) {
        java.nio.file.Path indexDir = shard.shardPath().resolveIndex();
    public void testMultipleRefreshCyclesWithReplication() throws Exception {  
        }, 60, TimeUnit.SECONDS);
            assertEquals(
     * catalog file set, and the catalog↔local↔remote tier agreement on each node.
import org.opensearch.test.OpenSearchIntegTestCase;  
            }, 60, TimeUnit.SECONDS);  
                assertTrue(
                    "replica " + replicaNode + " catalog must match primary",  
     * With multiple replicas, all replicas must converge to the primary's checkpoint and expose  
            assertLuceneIndexDirContents(primary);
        internalCluster().restartNode(replicaNode);  
            )
        startClusterAndCreateIndex(2, 1);  
            // Validate index/ directory contents match format configuration.
            super.nodePlugins().stream(),  
            .map(s -> nodeNameFromId(s.currentNodeId()))
import org.opensearch.index.store.remote.metadata.RemoteSegmentMetadata;
     * On replica restart, any non-Lucene files sitting in the shard's format subdirectory that
                pMeta.getSegmentInfosBytes() != null && pMeta.getSegmentInfosBytes().length > 0
        IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);  
        assertBusy(() -> {
                long primaryVersion = pMeta.getReplicationCheckpoint().getSegmentInfosVersion();
 */  
        startClusterAndCreateIndex(3, 2);
        return Stream.concat(
    public void testReplicaStartupCleansOrphanFiles() throws Exception {
        throw new IllegalStateException("node not found for id " + nodeId);  
                ParquetDataFormatPlugin.class,  
                );
                "replica SegmentInfos bytes non-empty",
            files = stream.map(p -> p.getFileName().toString()).collect(Collectors.toSet());
                rMeta.getReplicationCheckpoint().getSegmentInfosVersion()  
            RemoteSegmentMetadata rMeta = replicaBefore.getRemoteDirectory().readLatestMetadataFile();
     */
 */  
                DataFormatAwareITUtils.catalogFilesExcludingSegments(primary),
        Path parquetDir = replica.shardPath().getDataPath().resolve("parquet");
            // Every catalog-referenced file must still be on disk (Lucene secondary files live
     * the startup orphan sweep in {@link org.opensearch.index.engine.exec.coord.IndexFileDeleter}
                RemoteSegmentMetadata rMeta = replica.getRemoteDirectory().readLatestMetadataFile();
import org.opensearch.be.datafusion.DataFusionPlugin;
            assertNotNull(rMeta);
                "primary SegmentInfos bytes non-empty",
    public void testReplicaRecoveryWithRemoteStore() throws Exception {
                    "primary/replica catalog files must agree at cycle " + iteration,
            client().admin().indices().prepareFlush(INDEX_NAME).get();  
                rMeta.getSegmentInfosBytes() != null && rMeta.getSegmentInfosBytes().length > 0  
            );
        // Plant an orphan file in the replica's parquet directory. The filename must not match
import org.opensearch.index.shard.IndexShard;
                assertLuceneIndexDirContents(replica);
                RemoteSegmentMetadata pMeta = primary.getRemoteDirectory().readLatestMetadataFile();  
    private String nodeNameFromId(String nodeId) {  
import java.util.Map;  
    }
            assertEquals(  
                DataFormatAwareITUtils.catalogFilesExcludingSegments(recoveredReplica)
import java.nio.file.Files;
    }
        return Settings.builder()
                DataFormatAwareITUtils.catalogFilesExcludingSegments(replica)
            }
            .build();
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)  
        }, 60, TimeUnit.SECONDS);
        internalCluster().startClusterManagerOnlyNode();  
            // Data-format set must agree and include all expected formats.  
                    DataFormatAwareITUtils.catalogFilesExcludingSegments(replica)
    /**
        startClusterAndCreateIndex(2, 1);
    public void testReplicationWithMultipleReplicas() throws Exception {  
            assertNotNull(pMeta);
                IndexShard replica = getIndexShard(replicaNode, INDEX_NAME);  
            final long capturedPrev = previousVersion;
                    DataFormatAwareITUtils.catalogFilesExcludingSegments(replica)
            // Every data file the primary uploaded must be present on the replica's disk.
        IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);
        indexDocs(randomIntBetween(20, 50));
            .put("index.composite.primary_data_format", "parquet")
    }
    protected String primaryNodeName() {  
    @Override  
            List<String> replicaNodes = replicaNodeNames();  
        startClusterAndCreateIndex(2, 1);
    }  
        ensureGreen(INDEX_NAME);  
        for (int i = 0; i < 3; i++) {
import java.util.Collection;
import java.util.stream.Collectors;  
            RemoteSegmentMetadata pMeta = primary.getRemoteDirectory().readLatestMetadataFile();
                DataFormatAwareITUtils.assertPrimaryUploadMapOnReplicaDisk(primary, replica);  
    }
                pMeta.getReplicationCheckpoint().getSegmentInfosVersion(),
        }
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
import java.util.concurrent.TimeUnit;
public class DataFormatAwareReplicationIT extends RemoteStoreBaseIntegTestCase {
}
        client().admin().indices().prepareFlush(INDEX_NAME).get();
    }  
                "parquet-only: index/ must have only segments_N (and write.lock), got extra: " + nonSegmentsFiles,
            assertLuceneIndexDirContents(recoveredReplica);
            assertNotNull("replica metadata", rMeta);
                    ? recoveredReplica.shardPath().resolveIndex()
    }
    /**  
        assertBusy(() -> {
import java.util.Set;
        }, 90, TimeUnit.SECONDS);
                assertEquals(  
     * recovery while every catalog-referenced file survives.  
            assertNotNull(pMeta);
                rMeta.getReplicationCheckpoint().getSegmentInfosVersion()
        indexDocs(randomIntBetween(20, 40));
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
 * this file be licensed under the Apache-2.0 license or a
                    primaryVersion,
     */
     * the same catalog file set — validating fan-out segment replication on DFA shards.
        ensureGreen(INDEX_NAME);
            Set<String> primaryCatalog = DataFormatAwareITUtils.catalogFilesExcludingSegments(primary);
                CompositeDataFormatPlugin.class,
import org.opensearch.be.lucene.LucenePlugin;  
            for (String replicaNode : replicaNodes) {
        String replicaNode = replicaNodeNames().get(0);  
        ensureGreen(INDEX_NAME);
        assertTrue("planted orphan must exist before restart", Files.exists(orphan));
     * checkpoint with strictly-advancing version and matching catalog file set.
            assertBusy(() -> {  
            assertLuceneIndexDirContents(primary);
    /**
                pMeta.getReplicationCheckpoint().getSegmentInfosVersion(),
    }
            RemoteSegmentMetadata pMeta = primary.getRemoteDirectory().readLatestMetadataFile();
     * - parquet+lucene: segments_N plus additional segment data files (.si, .cfs, etc.)
    public void testReplicationConvergesAcrossAllInvariants() throws Exception {
        String replicaNode = replicaNodeNames().get(0);
                    "version must strictly advance at cycle " + iteration + ": previous=" + capturedPrev + ", current=" + primaryVersion,
            IndexShard replicaBefore = getIndexShard(replicaNode, INDEX_NAME);
                DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(replica);  
        assertBusy(() -> {
 *
            RemoteSegmentMetadata pMeta = primary.getRemoteDirectory().readLatestMetadataFile();
     * Consolidates what were individual single-invariant tests.
     * segment replication and converge to the primary's latest checkpoint with matching catalog.
                assertEquals(
        Path orphan = parquetDir.resolve("orphan-from-previous-session.parquet");
            );
        }, 90, TimeUnit.SECONDS);
    protected void startClusterAndCreateIndex(int dataNodes, int replicaCount) throws Exception {
    /**
                DataFormatAwareITUtils.catalogFilesExcludingSegments(recoveredReplica)  
                    : recoveredReplica.shardPath().getDataPath().resolve(fm.dataFormat());
            // Checkpoint version + non-empty SegmentInfos bytes.  
            DataFormatAwareITUtils.assertPrimaryUploadMapOnReplicaDisk(primary, replica);  
            RemoteSegmentMetadata pMeta = primary.getRemoteDirectory().readLatestMetadataFile();  
        Set<String> files;  
                Path dir = "lucene".equals(fm.dataFormat())  
import org.opensearch.common.settings.Settings;
            Set<String> rFormats = formatsOf(rMeta.getMetadata());
        assertBusy(() -> {  
            .filter(f -> f.startsWith("segments_") == false && f.equals("write.lock") == false)
    protected static Set<String> formatsOf(Map<String, UploadedSegmentMetadata> segments) {  
    }
        assertBusy(() -> {  
            assertEquals("primary/replica formats must agree", pFormats, rFormats);  
        ensureGreen(INDEX_NAME);
        try (var stream = java.nio.file.Files.list(indexDir)) {
            long primaryVersion = primary.getRemoteDirectory().readLatestMetadataFile().getReplicationCheckpoint().getSegmentInfosVersion();
                "primary/replica catalog files must agree",  
            DataFormatAwareITUtils.assertPrimaryUploadMapOnReplicaDisk(primary, recoveredReplica);
            );  
                RemoteSegmentMetadata rMeta = replica.getRemoteDirectory().readLatestMetadataFile();
    protected void assertLuceneIndexDirContents(IndexShard shard) throws java.io.IOException {  
 * SEGMENT replication, {@code Scope.TEST} per test. Requires {@code -Dsandbox.enabled=true}.
            IndexShard replicaBefore = getIndexShard(replicaNode, INDEX_NAME);
            assertNotNull(pMeta);
            // in <shard>/index/; non-default formats in <shard>/<format>/).
    }  
        // Wait for initial replication to settle so the replica has state to lose + recover.
 * ITs for DFA segment replication between a DFA primary and replica(s) on remote store.
    protected Set<String> expectedFormats() {
                );
                assertNotNull("replica metadata cycle " + iteration, rMeta);  
            assertFalse("parquet+lucene: index/ must have segment data files beyond segments_N, got " + files, nonSegmentsFiles.isEmpty());
                DataFormatAwareITUtils.catalogFilesExcludingSegments(primary),
        ensureYellowAndNoInitializingShards(INDEX_NAME);  
                DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(primary);
        // RefreshPolicy.NONE so per-doc background refreshes don't fire; a single explicit
                    primaryCatalog,
                DataFormatAwareITUtils.assertPrimaryUploadMapOnReplicaDisk(primary, replica);
        }, 60, TimeUnit.SECONDS);
 * SPDX-License-Identifier: Apache-2.0
        return true;
            );  
        client().admin().indices().prepareFlush(INDEX_NAME).get();
        client().admin().indices().prepareRefresh(INDEX_NAME).get();  
            indexDocs(randomIntBetween(10, 25));
        return nodeNameFromId(nodeId);
        IndexShard replica = getIndexShard(replicaNode, INDEX_NAME);  
                nonSegmentsFiles.isEmpty()
            .index(INDEX_NAME)
            .put(remoteStoreIndexSettings(replicaCount, 1))  
            );
     * <p>  
                .get();
                assertNotNull("primary metadata cycle " + iteration, pMeta);
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
import org.opensearch.index.store.FileMetadata;
            .put("index.pluggable.dataformat", "composite")  
     */
    protected Settings dfaIndexSettings(int replicaCount) {
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
     */  
        }  
    /**
        ensureGreen(INDEX_NAME);
                DataFormatAwareITUtils.catalogFilesExcludingSegments(primary),
                FileMetadata fm = new FileMetadata(catalogFile);
        }
                pMeta.getReplicationCheckpoint().getSegmentInfosVersion(),  
            );
package org.opensearch.composite;
        indexDocs(randomIntBetween(20, 40));
                .setSource("field_text", randomAlphaOfLength(10), "field_keyword", randomAlphaOfLength(10), "field_number", (long) i)
            DataFormatAwareITUtils.assertPrimaryUploadMapOnReplicaDisk(primary, recoveredReplica);
                    rMeta.getReplicationCheckpoint().getSegmentInfosVersion()  
/*  
import java.util.List;
            RemoteSegmentMetadata rMeta = replica.getRemoteDirectory().readLatestMetadataFile();
        }, 90, TimeUnit.SECONDS);  
    }
        long previousVersion = -1L;  
     * Multiple index + flush cycles. After each cycle the replica must converge to the primary's  
            Path parquetDirAfter = recoveredReplica.shardPath().getDataPath().resolve("parquet");  
                .getReplicationCheckpoint()
    protected List<String> replicaNodeNames() {
    protected boolean hasLuceneSecondary() {  
            // Catalog↔local↔remote tier agreement on each node.  
            // Catalog file sets agree across nodes.
        String nodeId = getClusterState().routingTable().index(INDEX_NAME).shard(0).primaryShard().currentNodeId();
                "primary/replica catalog files must agree after recovery",
        }  
            Set<String> pFormats = formatsOf(pMeta.getMetadata());
            assertFalse("startup orphan sweep must delete " + orphanAfter, Files.exists(orphanAfter));
                assertTrue("catalog-referenced file must survive sweep: " + onDisk, Files.exists(onDisk));
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            }
        internalCluster().restartNode(replicaNode);
import java.util.stream.Stream;
            assertEquals(
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(primary);
            .put(super.nodeSettings(nodeOrdinal))
            assertNotNull("primary metadata", pMeta);  
            assertLuceneIndexDirContents(recoveredReplica);  
     * After the replica data node is restarted, it must rehydrate from the remote store via
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
     * This exercises the remote-store path end-to-end: the primary uploads a new catalog, the
            .putList("index.composite.secondary_data_formats", List.of("lucene"))
                Path onDisk = dir.resolve(fm.file());  
            }
import java.nio.file.Path;  
            IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);  
                assertEquals(
                rMeta.getReplicationCheckpoint().getSegmentInfosVersion()
     * replica restarts, a planted orphan file in the parquet directory must be gone after
                .setRefreshPolicy(org.opensearch.action.support.WriteRequest.RefreshPolicy.NONE)  
        IndexShard recoveredReplica = getIndexShard(replicaNodeNames().get(0), INDEX_NAME);  
    }
                assertLuceneIndexDirContents(replica);  
            .replicaShards()  
        if (hasLuceneSecondary()) {  
    @Override
                .getSegmentInfosVersion();
                IndexShard replica = getIndexShard(replicaNodeNames().get(0), INDEX_NAME);
            assertLuceneIndexDirContents(primary);  
        assertTrue("index/ directory must exist", java.nio.file.Files.exists(indexDir));
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(replica);
        IndexShard recoveredReplica = getIndexShard(replicaNodeNames().get(0), INDEX_NAME);
 * compatible open source license.
                );  
        client().admin().indices().prepareFlush(INDEX_NAME).get();  
import org.opensearch.indices.replication.common.ReplicationType;
            assertEquals(  
            IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);
                return nodeName;  
            assertEquals("primary formats must match expected", expectedFormats(), pFormats);
    }  
 * The OpenSearch Contributors require contributions made to  
     * checkpoint version, uploaded SegmentInfos bytes (non-empty), the set of data formats,  
        for (String nodeName : internalCluster().getNodeNames()) {
    }
            assertTrue(  
            .put("index.pluggable.dataformat.enabled", true)
    protected static final String INDEX_NAME = "dfa-replication-test-idx";
            assertLuceneIndexDirContents(primary);  
            Set<String> catalogAfter = DataFormatAwareITUtils.catalogFiles(recoveredReplica);  
     * - parquet-only: only segments_N (commit metadata)  
     */
        Set<String> nonSegmentsFiles = files.stream()  
                "primary/replica checkpoint versions must match",
import org.opensearch.cluster.metadata.IndexMetadata;
            client().prepareIndex(INDEX_NAME)
            );
    /** Set of formats this index variant uses. Override in subclasses to add more formats. */  
            assertTrue(
        }  
import org.opensearch.plugins.Plugin;
                rMeta.getReplicationCheckpoint().getSegmentInfosVersion()  
                );
    /** Starts 1 cluster-manager + {@code dataNodes} data nodes and creates the DFA index. */
        return getClusterState().routingTable()  
            IndexShard replica = getIndexShard(replicaNodeNames().get(0), INDEX_NAME);
        startClusterAndCreateIndex(2, 1);
            ensureGreen(INDEX_NAME);
            assertNotNull(rMeta);
                    "replica " + replicaNode + " version must match primary",
    }
                );  
            RemoteSegmentMetadata rMeta = replicaBefore.getRemoteDirectory().readLatestMetadataFile();  
            assertEquals(
    }  
            );  
                assertEquals(
        internalCluster().startDataOnlyNodes(dataNodes);
            previousVersion = getIndexShard(primaryNodeName(), INDEX_NAME).getRemoteDirectory()
import org.opensearch.parquet.ParquetDataFormatPlugin;  
    }
/**  
                "primary/replica catalog files must agree after recovery",  
        Files.createDirectories(parquetDir);  
        indexDocs(randomIntBetween(20, 40));  
            assertTrue(  
            assertNotNull(rMeta);  
            );  
            Stream.of(
                ArrowBasePlugin.class,
    protected void indexDocs(int count) {
import org.opensearch.index.store.RemoteSegmentStoreDirectory.UploadedSegmentMetadata;  
                assertNotNull("replica " + replicaNode + " metadata", rMeta);
                assertLuceneIndexDirContents(primary);
                IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);
            .collect(Collectors.toSet());
            assertLuceneIndexDirContents(replica);
        return Set.of("parquet", "lucene");
            .collect(Collectors.toList());  
        return Settings.builder()
        for (int i = 0; i < count; i++) {
            .stream()
                    primaryVersion > capturedPrev  
            .shard(0)
            final int iteration = i;
                LucenePlugin.class,
        // refresh/flush at the end gives deterministic replication rounds.  
        client().admin().indices().prepareRefresh(INDEX_NAME).get();  
        client().admin().indices().prepareFlush(INDEX_NAME).get();
        // Wait for replication to converge so the replica has a committed snapshot on disk.  
        ).collect(Collectors.toList());
        // segments_N must always be present
                "replica version must match primary after recovery",
    /** Whether lucene is configured as a secondary data format (produces searchable segment files). */
import org.opensearch.arrow.allocator.ArrowBasePlugin;
                DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(replica);
                pMeta.getReplicationCheckpoint().getSegmentInfosVersion(),
     * After a single flush, primary and each replica agree on every observable invariant:
    /**
    protected Settings nodeSettings(int nodeOrdinal) {  
            client().admin().indices().prepareRefresh(INDEX_NAME).get();
        } else {
                    primaryVersion,
        // any catalog-referenced file — use a name unlike anything the writer produces.
            Path orphanAfter = parquetDirAfter.resolve("orphan-from-previous-session.parquet");
            .build();  
     */  
