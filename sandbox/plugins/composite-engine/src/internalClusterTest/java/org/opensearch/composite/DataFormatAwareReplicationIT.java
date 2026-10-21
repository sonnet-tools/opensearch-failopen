            .build();
        assertTrue("planted orphan must exist before restart", Files.exists(orphan));
                DataFormatAwareITUtils.catalogFilesExcludingSegments(recoveredReplica)
    protected void startClusterAndCreateIndex(int dataNodes, int replicaCount) throws Exception {
        Set<String> nonSegmentsFiles = files.stream()
    /**
            assertEquals(
            client().prepareIndex(INDEX_NAME)
    public void testReplicationConvergesAcrossAllInvariants() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            assertTrue(
    protected String primaryNodeName() {
            .putList("index.composite.secondary_data_formats", List.of("lucene"))
        }, 90, TimeUnit.SECONDS);
        String nodeId = getClusterState().routingTable().index(INDEX_NAME).shard(0).primaryShard().currentNodeId();
import org.opensearch.cluster.metadata.IndexMetadata;
            IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);
        String replicaNode = replicaNodeNames().get(0);
     * - parquet+lucene: segments_N plus additional segment data files (.si, .cfs, etc.)
        }, 60, TimeUnit.SECONDS);
            assertNotNull("replica metadata", rMeta);
                .get();
        ensureGreen(INDEX_NAME);
        throw new IllegalStateException("node not found for id " + nodeId);
            RemoteSegmentMetadata pMeta = primary.getRemoteDirectory().readLatestMetadataFile();
     * Consolidates what were individual single-invariant tests.
            assertFalse("startup orphan sweep must delete " + orphanAfter, Files.exists(orphanAfter));
     * checkpoint version, uploaded SegmentInfos bytes (non-empty), the set of data formats,
        assertBusy(() -> {
            // Catalog file sets agree across nodes.
    }
                "primary/replica catalog files must agree",
        internalCluster().restartNode(replicaNode);
            .filter(f -> f.startsWith("segments_") == false && f.equals("write.lock") == false)
                rMeta.getReplicationCheckpoint().getSegmentInfosVersion()
import org.opensearch.index.shard.IndexShard;
            super.nodePlugins().stream(),
                assertEquals(
    }
                "primary/replica catalog files must agree after recovery",
        return true;
            .index(INDEX_NAME)
                DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(primary);
                .setRefreshPolicy(org.opensearch.action.support.WriteRequest.RefreshPolicy.NONE)
                assertLuceneIndexDirContents(primary);
    }
        startClusterAndCreateIndex(2, 1);
import java.util.stream.Stream;
            );
    /**
            RemoteSegmentMetadata rMeta = replicaBefore.getRemoteDirectory().readLatestMetadataFile();
            assertEquals(
        ensureGreen(INDEX_NAME);
        IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);
        }, 60, TimeUnit.SECONDS);
package org.opensearch.composite;
                rMeta.getReplicationCheckpoint().getSegmentInfosVersion()
import org.opensearch.be.datafusion.DataFusionPlugin;
                long primaryVersion = pMeta.getReplicationCheckpoint().getSegmentInfosVersion();
                .getReplicationCheckpoint()
                Path onDisk = dir.resolve(fm.file());
                    primaryCatalog,
            assertLuceneIndexDirContents(primary);
            );
            if (internalCluster().clusterService(nodeName).localNode().getId().equals(nodeId)) {
     * catalog file set, and the catalog↔local↔remote tier agreement on each node.
                assertEquals(
    }
        // Wait for initial replication to settle so the replica has state to lose + recover.
            .collect(Collectors.toSet());
        }, 60, TimeUnit.SECONDS);
                DataFormatAwareITUtils.catalogFilesExcludingSegments(recoveredReplica)
    protected Set<String> expectedFormats() {
        for (int i = 0; i < 3; i++) {
                assertNotNull("replica metadata cycle " + iteration, rMeta);
    }
            .collect(Collectors.toList());
import java.util.stream.Collectors;
import java.nio.file.Files;
        ).collect(Collectors.toList());
        }, 90, TimeUnit.SECONDS);
            assertLuceneIndexDirContents(recoveredReplica);
     * Asserts that the index/ directory on the shard contains the expected Lucene files:
        client().admin().indices().prepareFlush(INDEX_NAME).get();
    /** Set of formats this index variant uses. Override in subclasses to add more formats. */
import org.opensearch.test.OpenSearchIntegTestCase;
                DataFormatAwareITUtils.catalogFilesExcludingSegments(primary),
                    rMeta.getReplicationCheckpoint().getSegmentInfosVersion()
            // Catalog↔local↔remote tier agreement on each node.
    /**
                DataFormatAwareITUtils.assertPrimaryUploadMapOnReplicaDisk(primary, replica);
            Path parquetDirAfter = recoveredReplica.shardPath().getDataPath().resolve("parquet");
            // Data-format set must agree and include all expected formats.
            assertEquals("primary formats must match expected", expectedFormats(), pFormats);
                    "replica " + replicaNode + " catalog must match primary",
        Set<String> files;
    protected List<String> replicaNodeNames() {
                IndexShard replica = getIndexShard(replicaNode, INDEX_NAME);
            assertLuceneIndexDirContents(primary);
            assertEquals(
            );
     */
                    primaryVersion,
            .build();
        }, 90, TimeUnit.SECONDS);
        assertBusy(() -> {
import org.opensearch.common.settings.Settings;
     */
            assertLuceneIndexDirContents(recoveredReplica);
                );
        return getClusterState().routingTable()
            assertNotNull(rMeta);
import org.opensearch.index.store.remote.metadata.RemoteSegmentMetadata;
        indexDocs(randomIntBetween(20, 40));
            );
import org.opensearch.arrow.allocator.ArrowBasePlugin;
        assertTrue("index/ must contain segments_N, got " + files, files.stream().anyMatch(f -> f.startsWith("segments_")));
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(replicaCount)).get();
    }
                    "replica " + replicaNode + " version must match primary",
     */
            assertEquals(
    }
            assertNotNull(rMeta);
                );
 * The OpenSearch Contributors require contributions made to
            // Validate index/ directory contents match format configuration.
 * SEGMENT replication, {@code Scope.TEST} per test. Requires {@code -Dsandbox.enabled=true}.
            assertEquals(
     * (wired through {@code DataFormatAwareNRTReplicationEngine}).
                .getSegmentInfosVersion();
            assertNotNull(pMeta);
    }
            IndexShard replica = getIndexShard(replicaNodeNames().get(0), INDEX_NAME);
        startClusterAndCreateIndex(2, 1);
            for (String catalogFile : catalogAfter) {
    private String nodeNameFromId(String nodeId) {
                "primary SegmentInfos bytes non-empty",
import org.opensearch.index.store.RemoteSegmentStoreDirectory.UploadedSegmentMetadata;
        } else {
 * ITs for DFA segment replication between a DFA primary and replica(s) on remote store.
                LucenePlugin.class,
    }
                    : recoveredReplica.shardPath().getDataPath().resolve(fm.dataFormat());
            }
        ensureGreen(INDEX_NAME);
            .put(super.nodeSettings(nodeOrdinal))
        client().admin().indices().prepareFlush(INDEX_NAME).get();
     * On replica restart, any non-Lucene files sitting in the shard's format subdirectory that
            );
    @Override
            IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);
        IndexShard replica = getIndexShard(replicaNode, INDEX_NAME);
                assertTrue("catalog-referenced file must survive sweep: " + onDisk, Files.exists(onDisk));
            client().admin().indices().prepareFlush(INDEX_NAME).get();
     * checkpoint with strictly-advancing version and matching catalog file set.
            assertNotNull(pMeta);
        IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);
                assertLuceneIndexDirContents(replica);
    }
import java.util.Collection;
        return Settings.builder()
        return Set.of("parquet", "lucene");
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(replica);
            .replicaShards()
import java.util.Map;
import org.opensearch.common.util.FeatureFlags;
        return nodeNameFromId(nodeId);
                    primaryVersion > capturedPrev
        Path orphan = parquetDir.resolve("orphan-from-previous-session.parquet");
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                rMeta.getReplicationCheckpoint().getSegmentInfosVersion()
            assertNotNull(pMeta);
        // refresh/flush at the end gives deterministic replication rounds.
            for (String replicaNode : replicaNodes) {
        startClusterAndCreateIndex(2, 1);
        startClusterAndCreateIndex(2, 1);
                ParquetDataFormatPlugin.class,
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            client().admin().indices().prepareRefresh(INDEX_NAME).get();
            .stream()
            assertNotNull("primary metadata", pMeta);
                CompositeDataFormatPlugin.class,
            Set<String> pFormats = formatsOf(pMeta.getMetadata());
            assertBusy(() -> {
import org.opensearch.indices.replication.common.ReplicationType;
            );
                assertTrue(
     * - parquet-only: only segments_N (commit metadata)
     * the startup orphan sweep in {@link org.opensearch.index.engine.exec.coord.IndexFileDeleter}
import org.opensearch.index.store.FileMetadata;
     * replica restarts, a planted orphan file in the parquet directory must be gone after
            .shard(0)
            .put("index.pluggable.dataformat", "composite")
            Set<String> primaryCatalog = DataFormatAwareITUtils.catalogFilesExcludingSegments(primary);
            );
                );
            .put("index.pluggable.dataformat.enabled", true)
            assertTrue(
                .readLatestMetadataFile()
                return nodeName;
        long previousVersion = -1L;
            }
     * With multiple replicas, all replicas must converge to the primary's checkpoint and expose
                IndexShard replica = getIndexShard(replicaNodeNames().get(0), INDEX_NAME);
        ensureGreen(INDEX_NAME);
            assertEquals("expected 2 replicas, got " + replicaNodes, 2, replicaNodes.size());
        client().admin().indices().prepareFlush(INDEX_NAME).get();
                assertEquals(
     * are <em>not</em> referenced by the restored catalog snapshot must be physically removed by
        indexDocs(randomIntBetween(20, 40));
    protected void indexDocs(int count) {
     */
    protected static Set<String> formatsOf(Map<String, UploadedSegmentMetadata> segments) {
public class DataFormatAwareReplicationIT extends RemoteStoreBaseIntegTestCase {
            Path orphanAfter = parquetDirAfter.resolve("orphan-from-previous-session.parquet");
                RemoteSegmentMetadata rMeta = replica.getRemoteDirectory().readLatestMetadataFile();
    }
        assertTrue("index/ directory must exist", java.nio.file.Files.exists(indexDir));
            DataFormatAwareITUtils.assertPrimaryUploadMapOnReplicaDisk(primary, replica);
import java.util.Set;
        startClusterAndCreateIndex(3, 2);
            RemoteSegmentMetadata pMeta = primary.getRemoteDirectory().readLatestMetadataFile();
            RemoteSegmentMetadata pMeta = primary.getRemoteDirectory().readLatestMetadataFile();
                FileMetadata fm = new FileMetadata(catalogFile);
 * this file be licensed under the Apache-2.0 license or a
     */
    protected boolean hasLuceneSecondary() {
            }, 60, TimeUnit.SECONDS);
        // RefreshPolicy.NONE so per-doc background refreshes don't fire; a single explicit
    /** Whether lucene is configured as a secondary data format (produces searchable segment files). */
            )
    protected Settings dfaIndexSettings(int replicaCount) {
}
                nonSegmentsFiles.isEmpty()
    }
        // segments_N must always be present
        // any catalog-referenced file — use a name unlike anything the writer produces.
            ensureGreen(INDEX_NAME);
            assertNotNull(rMeta);
                pMeta.getReplicationCheckpoint().getSegmentInfosVersion(),
 * compatible open source license.
                "primary/replica checkpoint versions must match",
/*
    /**
        return Stream.concat(
            .put("index.composite.primary_data_format", "parquet")
                    "version must strictly advance at cycle " + iteration + ": previous=" + capturedPrev + ", current=" + primaryVersion,
            .put(remoteStoreIndexSettings(replicaCount, 1))
import java.nio.file.Path;
     * After a single flush, primary and each replica agree on every observable invariant:
                pMeta.getReplicationCheckpoint().getSegmentInfosVersion(),
                assertNotNull("primary metadata cycle " + iteration, pMeta);
        if (hasLuceneSecondary()) {
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        java.nio.file.Path indexDir = shard.shardPath().resolveIndex();
                    DataFormatAwareITUtils.catalogFilesExcludingSegments(replica)
            RemoteSegmentMetadata pMeta = primary.getRemoteDirectory().readLatestMetadataFile();
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
                ArrowBasePlugin.class,
        assertBusy(() -> {
                "replica SegmentInfos bytes non-empty",
            indexDocs(randomIntBetween(10, 25));
            // in <shard>/index/; non-default formats in <shard>/<format>/).
            assertEquals(
        IndexShard recoveredReplica = getIndexShard(replicaNodeNames().get(0), INDEX_NAME);
                DataFormatAwareITUtils.assertPrimaryUploadMapOnReplicaDisk(primary, replica);
            Stream.of(
                pMeta.getReplicationCheckpoint().getSegmentInfosVersion(),
                DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(replica);
            previousVersion = getIndexShard(primaryNodeName(), INDEX_NAME).getRemoteDirectory()
            DataFormatAwareITUtils.assertPrimaryUploadMapOnReplicaDisk(primary, recoveredReplica);
        return segments.keySet().stream().map(file -> new FileMetadata(file).dataFormat()).collect(Collectors.toSet());
                DataFormatAwareITUtils.catalogFilesExcludingSegments(replica)
            );
            Set<String> rFormats = formatsOf(rMeta.getMetadata());
        }
    @Override
                    "primary/replica versions must match at cycle " + iteration,
    public void testReplicaRecoveryWithRemoteStore() throws Exception {
 */
     * segment replication and converge to the primary's latest checkpoint with matching catalog.
                DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(replica);
        indexDocs(randomIntBetween(20, 40));
                "parquet-only: index/ must have only segments_N (and write.lock), got extra: " + nonSegmentsFiles,
                    ? recoveredReplica.shardPath().resolveIndex()
        String replicaNode = replicaNodeNames().get(0);
        Files.write(orphan, new byte[] { 0x50, 0x41, 0x52, 0x31 });  // "PAR1" magic — irrelevant to the test
                .setSource("field_text", randomAlphaOfLength(10), "field_keyword", randomAlphaOfLength(10), "field_number", (long) i)
/**
        }
                RemoteSegmentMetadata rMeta = replica.getRemoteDirectory().readLatestMetadataFile();
import org.opensearch.plugins.Plugin;
            RemoteSegmentMetadata rMeta = replica.getRemoteDirectory().readLatestMetadataFile();
    /**
            );
     * the same catalog file set — validating fan-out segment replication on DFA shards.
        client().admin().indices().prepareFlush(INDEX_NAME).get();
            assertLuceneIndexDirContents(primary);
                DataFormatAwareITUtils.catalogFilesExcludingSegments(primary),
            IndexShard replicaBefore = getIndexShard(replicaNode, INDEX_NAME);
                assertNotNull("replica " + replicaNode + " metadata", rMeta);
                rMeta.getReplicationCheckpoint().getSegmentInfosVersion()
                );
        Path parquetDir = replica.shardPath().getDataPath().resolve("parquet");
            // Every catalog-referenced file must still be on disk (Lucene secondary files live
     * recovery while every catalog-referenced file survives.
                );
                rMeta.getSegmentInfosBytes() != null && rMeta.getSegmentInfosBytes().length > 0
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
                    rMeta.getReplicationCheckpoint().getSegmentInfosVersion()
    /**
            Set<String> catalogAfter = DataFormatAwareITUtils.catalogFiles(recoveredReplica);
        try (var stream = java.nio.file.Files.list(indexDir)) {
        assertBusy(() -> {
            assertTrue(
            final long capturedPrev = previousVersion;
                IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);
            .map(s -> nodeNameFromId(s.currentNodeId()))
     * <p>
        }
import java.util.List;
    }
                    DataFormatAwareITUtils.catalogFilesExcludingSegments(primary),
        for (int i = 0; i < count; i++) {
                    primaryVersion,
            // Checkpoint version + non-empty SegmentInfos bytes.
import org.opensearch.be.lucene.LucenePlugin;
        assertBusy(() -> {
        }
            assertLuceneIndexDirContents(primary);
        for (String nodeName : internalCluster().getNodeNames()) {
            RemoteSegmentMetadata rMeta = recoveredReplica.getRemoteDirectory().readLatestMetadataFile();
    }
        // Wait for replication to converge so the replica has a committed snapshot on disk.
    }
            long primaryVersion = primary.getRemoteDirectory().readLatestMetadataFile().getReplicationCheckpoint().getSegmentInfosVersion();
                RemoteSegmentMetadata pMeta = primary.getRemoteDirectory().readLatestMetadataFile();
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(primary);
        IndexShard recoveredReplica = getIndexShard(replicaNodeNames().get(0), INDEX_NAME);
            // Every data file the primary uploaded must be present on the replica's disk.
        indexDocs(randomIntBetween(20, 50));
                DataFusionPlugin.class
            List<String> replicaNodes = replicaNodeNames();
                pMeta.getReplicationCheckpoint().getSegmentInfosVersion(),
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
    protected void assertLuceneIndexDirContents(IndexShard shard) throws java.io.IOException {
    protected static final String INDEX_NAME = "dfa-replication-test-idx";
            );
    }
        internalCluster().startClusterManagerOnlyNode();
                DataFormatAwareITUtils.catalogFilesExcludingSegments(primary),
        // Plant an orphan file in the replica's parquet directory. The filename must not match
                "primary/replica catalog files must agree after recovery",
                pMeta.getSegmentInfosBytes() != null && pMeta.getSegmentInfosBytes().length > 0
        internalCluster().restartNode(replicaNode);
        ensureGreen(INDEX_NAME);
            assertEquals(
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
     * This exercises the remote-store path end-to-end: the primary uploads a new catalog, the
     * Multiple index + flush cycles. After each cycle the replica must converge to the primary's
        internalCluster().startDataOnlyNodes(dataNodes);
                "replica version must match primary after recovery",
        assertBusy(() -> {
            RemoteSegmentMetadata rMeta = replicaBefore.getRemoteDirectory().readLatestMetadataFile();
    }
            final int iteration = i;
            IndexShard replicaBefore = getIndexShard(replicaNode, INDEX_NAME);
                assertEquals(
import org.opensearch.parquet.ParquetDataFormatPlugin;
                    "primary/replica catalog files must agree at cycle " + iteration,
 */
            assertFalse("parquet+lucene: index/ must have segment data files beyond segments_N, got " + files, nonSegmentsFiles.isEmpty());
    protected Settings nodeSettings(int nodeOrdinal) {
     * After the replica data node is restarted, it must rehydrate from the remote store via
                assertLuceneIndexDirContents(replica);
        Files.createDirectories(parquetDir);
import java.util.concurrent.TimeUnit;
        }
        return Settings.builder()
            assertLuceneIndexDirContents(replica);
    public void testReplicationWithMultipleReplicas() throws Exception {
            files = stream.map(p -> p.getFileName().toString()).collect(Collectors.toSet());
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
 *
     */
                    DataFormatAwareITUtils.catalogFilesExcludingSegments(replica)
            DataFormatAwareITUtils.assertPrimaryUploadMapOnReplicaDisk(primary, recoveredReplica);
    /** Starts 1 cluster-manager + {@code dataNodes} data nodes and creates the DFA index. */
    public void testReplicaStartupCleansOrphanFiles() throws Exception {
            assertEquals("primary/replica formats must agree", pFormats, rFormats);
            }
                Path dir = "lucene".equals(fm.dataFormat())
    public void testMultipleRefreshCyclesWithReplication() throws Exception {
