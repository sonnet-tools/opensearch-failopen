        assertTrue("catalog generation must advance: reference=" + reference + ", current=" + current, current > reference);
     * configuration), so it's included by default. Subclasses with explicit Lucene as a
        java.util.Set<String> files;
     * Asserts that the index/ directory on the shard contains the expected Lucene files:
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
     * seed that picked {@code asyncUploadMockFsRepo=true}, {@code metadataSupportedType=false} and
import org.opensearch.test.OpenSearchIntegTestCase;
        return Settings.builder()
import org.opensearch.parquet.ParquetDataFormatPlugin;
    protected List<String> indexDocs(int count) {
    }
            } catch (org.apache.lucene.store.AlreadyClosedException e) {
     * Wires FsNativeObjectStorePlugin into "fs_multipart_repository" repos.
     */
     * fencing-enabled fail shard recovery outright.
@ThreadLeakFilters(filters = DataFormatAwareReplicationBaseIT.CleanerThreadFilter.class)
    protected void waitForPrimaryTerm(String index, int shardId, long expectedTerm, TimeValue timeout) throws Exception {
        }, timeout.seconds(), TimeUnit.SECONDS);
import org.opensearch.arrow.allocator.ArrowBasePlugin;
        assertBusy(() -> {
            () -> assertTrue(
    private String nodeNameFromId(String nodeId) {
        }
        List<String> ids = new ArrayList<>();
     */
            String currentPrimaryNode = primaryNodeName();
                NativeAwareMockFsRepositoryPlugin.class
import org.opensearch.remotestore.multipart.mocks.MockFsRepository;
                assertLuceneIndexDirContents(primary);
    }
    /** Whether lucene is configured as a secondary data format (produces searchable segment files). */
     */
     * writes, which remote store fencing requires. Substituting {@code FsRepository} here made every
        return Settings.builder().put(settings).put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true).build();
        } else {
import java.util.Collections;
    }
import org.opensearch.cluster.metadata.IndexMetadata;
            .index(INDEX_NAME)
    /** Index N docs with RefreshPolicy.NONE. */
    }
     * Together these catch the common correctness regressions this test suite targets
        public Map<String, Repository.Factory> getRepositories(
                .get();
    protected long readCatalogGeneration(String nodeName, String index) throws Exception {
import org.opensearch.action.index.IndexResponse;
            return Collections.singletonMap(
            .filter(s -> s.started())
import java.util.Set;
    public static class NativeAwareMockFsRepositoryPlugin extends Plugin implements org.opensearch.plugins.RepositoryPlugin {
        client().admin()
                assertTrue("format directory must have files: " + format, stream.findAny().isPresent());
        org.opensearch.cluster.node.DiscoveryNode node = getClusterState().nodes().get(nodeId);
        try (GatedCloseable<CatalogSnapshot> closeable = shard.getCatalogSnapshot()) {
                IndexShard primary = getIndexShard(primaryNodeName(), index);
            );
import org.opensearch.repositories.fs.native_store.FsNativeObjectStorePlugin;
     *
            .filter(f -> f.startsWith("segments_") == false && f.equals("write.lock") == false)
                NativeAwareMockFsMetadataSupportedRepositoryPlugin.class,
            assertTrue("format directory must exist: " + format, java.nio.file.Files.exists(dir));
        return Stream.concat(
        if (node == null) {
    }
        return segments.keySet().stream().map(file -> new FileMetadata(file).dataFormat()).collect(Collectors.toSet());
        private final FsNativeObjectStorePlugin nativeProvider = new FsNativeObjectStorePlugin();
            assertTrue(
        java.nio.file.Path indexDir = shard.shardPath().resolveIndex();
        return true;
import java.util.stream.Stream;
            .put(remoteStoreIndexSettings(replicaCount, 1))
    /** Read the current catalog generation of a specific node's copy of the shard. */
            ids.add(indexResponse.getId());
            org.opensearch.plugins.RepositoryPlugin {
    }
            if (segmentRepoPath != null) java.nio.file.Files.createDirectories(segmentRepoPath);
        indexer.assertNoFailures();
                indexer.totalIndexedDocs() >= numDocs
    protected String primaryNodeName() {
        IndexShard shard = getIndexShard(nodeName, index);
            .replicaShards()
        @Override
    protected void waitForIndexerDocs(long numDocs, BackgroundIndexer indexer) throws Exception {
                "expected at least " + numDocs + " acked docs, got " + indexer.totalIndexedDocs(),
import org.opensearch.remotestore.multipart.mocks.MockFsRepositoryPlugin;
import java.util.Collection;
        }
    }
        }
    }
        assertCatalogSnapshotsConverged(index);
            .execute()
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeName));
            NamedXContentRegistry namedXContentRegistry,
        // shards can obtain a live NativeStoreRepository regardless of which repo type
                Set<String> primaryFiles = DataFormatAwareITUtils.catalogFilesExcludingSegments(primary);
            .putList("index.composite.secondary_data_formats", List.of("lucene"))
            ),
    }
     */
        return node.getName();
import java.util.stream.Collectors;
    /**
            TimeUnit.SECONDS
            IndexShard shard = getIndexShard(currentPrimaryNode, index);
        assertTrue("index/ must contain segments_N, got " + files, files.stream().anyMatch(f -> f.startsWith("segments_")));
     *
            .build();
        // can linger in the routing table for a moment after the node leaves; throw an AssertionError
            )
    /** Wires FsNativeObjectStorePlugin into "fs_metadata_supported_repository" repos. */
            );
     */
        for (int i = 0; i < count; i++) {
     * {@link #gracefulStopNode}/{@link #crashNode} for promotion scenarios.
import org.opensearch.indices.recovery.RecoverySettings;
            .map(s -> nodeNameFromId(s.currentNodeId()))
                    metadata,
     * under {@code index/}), a non-empty directory exists on the shard's data path. Validates
     * (promotion losing commits, recovery dropping files, orphan files on replica).
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
    protected Settings nodeSettings(int nodeOrdinal) {
public abstract class DataFormatAwareReplicationBaseIT extends RemoteStoreBaseIntegTestCase {
    }
    protected void gracefulStopNode(String nodeName) throws Exception {
    public static class CleanerThreadFilter implements ThreadFilter {
        return Set.of("parquet", "lucene");
            .actionGet();
     * - parquet+lucene: segments_N plus additional segment data files (.si, .cfs, etc.)
import java.util.concurrent.TimeUnit;
            RecoverySettings recoverySettings
        java.util.Set<String> nonSegmentsFiles = files.stream()
        // Pre-create repo dirs so FsNativeObjectStorePlugin's canonicalize() succeeds at startup.
                DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(primary);
            .add(new org.opensearch.cluster.routing.allocation.command.CancelAllocationCommand(index, shardId, nodeName, true))
    }
        } catch (java.io.IOException e) {
            return Collections.singletonMap(
        if (hasLuceneSecondary()) {
                    env,
        }
import org.opensearch.common.settings.Settings;
     * that DFA engines reject (see {@link #assertNoDataLoss}).
        @Override
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        ).collect(Collectors.toList());
                }
        }
                "parquet-only: index/ must have only segments_N (and write.lock), got extra: " + nonSegmentsFiles,
 *
    /**
            return t.getName().startsWith("index-input-cleaner");
import org.opensearch.index.store.FileMetadata;
import org.opensearch.test.BackgroundIndexer;
    /** Graceful stop with handshake. */
                    recoverySettings,
        try {
                for (String replicaNode : replicaNodeNames()) {
            throw new AssertionError("node with id " + nodeId + " not present in cluster state yet");
import org.opensearch.common.unit.TimeValue;
import com.carrotsearch.randomizedtesting.ThreadFilter;
     * currently returns {@code 0L} (stub), and the Lucene search path is rejected for DFA engines via
import org.opensearch.cluster.service.ClusterService;
    protected void cancelPrimaryAllocation(String index, int shardId, String nodeName) throws Exception {
    /**
        // Flush so every ack'd write lives in a persisted catalog snapshot.
            RecoverySettings recoverySettings
     * Asserts that for every format in {@link #expectedFormats()} (excluding lucene which lives
            .prepareReroute()
            assertFalse("parquet+lucene: index/ must have segment data files beyond segments_N, got " + files, nonSegmentsFiles.isEmpty());
     * the mock's blob container is the only one of the two that reports store-enforced conditional
        }
        // so that callers under assertBusy() retry rather than fail hard.
                metadata -> new ReloadableFsRepository(
import org.opensearch.common.concurrent.GatedCloseable;
        internalCluster().startClusterManagerOnlyNode();
        assertBusy(() -> {
                    IndexShard replica = getIndexShard(replicaNode, index);
    }
    }
            try {
    protected static Set<String> formatsOf(Map<String, UploadedSegmentMetadata> segments) {
        try (var stream = java.nio.file.Files.list(indexDir)) {
        ensureYellowAndNoInitializingShards(INDEX_NAME);
    }
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
                    nativeProvider
            );
                .setRefreshPolicy(org.opensearch.action.support.WriteRequest.RefreshPolicy.NONE)
            ClusterService clusterService,
     *   <li>Convergence of the catalog file set between primary and replica.</li>
package org.opensearch.composite;
    }
    }
     * secondary format have the same expected set.
    protected void assertAllFormatDirsHaveFiles(IndexShard shard) throws java.io.IOException {
    /**
/*
                )
        }
     *
import java.util.ArrayList;
import java.util.Map;
            throw new java.io.UncheckedIOException("Failed to pre-create remote store repo directories", e);
        implements
        private final FsNativeObjectStorePlugin nativeProvider = new FsNativeObjectStorePlugin();
            .put("index.composite.primary_data_format", "parquet")
    protected void assertGenerationMonotonic(long reference, long current) {
        return ids;
     * <ul>
import org.opensearch.common.util.FeatureFlags;
                DataFusionPlugin.class,
import org.opensearch.repositories.Repository;
    /**
                .setSource("field_text", randomAlphaOfLength(10), "field_keyword", randomAlphaOfLength(10), "field_number", (long) i)
     * a different format combination. Used by tests for format-aware assertions.
                    Set<String> replicaFiles = DataFormatAwareITUtils.catalogFilesExcludingSegments(replica);
     * DataFusion Tokio runtime manager in test clusters), which is why we prefer this over
    protected List<String> replicaNodeNames() {
 */
     * - parquet-only: only segments_N (commit metadata)
            .collect(Collectors.toList());
    protected void crashNode(String nodeName) throws Exception {
                FsNativeObjectStorePlugin.class,
                CompositeDataFormatPlugin.class,
 */
        );
     *   <li>The BackgroundIndexer's own accounting of acknowledged writes.</li>
        return nodeNameFromId(nodeId);
        ensureGreen(INDEX_NAME);
        public boolean reject(Thread t) {
    /** Replica node names. */
        }
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeName));
 * The OpenSearch Contributors require contributions made to
            ClusterService clusterService,
            Environment env,
     * Replaces {@code waitForDocs(long, BackgroundIndexer)} which issues a Lucene search
import org.opensearch.repositories.fs.FsRepository;
            }
        for (String format : expectedFormats()) {
    /**
    protected Set<String> expectedFormats() {
            .cluster()
    }
     * {@code applyOnEngine}. The two signals available are:
import org.opensearch.index.shard.IndexShard;
                metadata -> new MockFsRepository(metadata, env, namedXContentRegistry, clusterService, recoverySettings, nativeProvider)
        ) {
     * <p>Lucene is always present (it underlies every DFA index regardless of secondary format
        // RemoteStoreBaseIntegTestCase randomly picks (metadataSupportedType = randomBoolean()).
            Environment env,
            files = stream.map(p -> p.getFileName().toString()).collect(java.util.stream.Collectors.toSet());
    protected Settings dfaIndexSettings(int replicaCount) {
    }
    protected void assertNoDataLoss(BackgroundIndexer indexer, String index) throws Exception {
            return closeable.get().getGeneration();
     */
}
                MockFsMetadataSupportedRepositoryPlugin.TYPE_MD,
        return getClusterState().routingTable()
        assertBusy(
                nonSegmentsFiles.isEmpty()
            IndexResponse indexResponse = client().prepareIndex(INDEX_NAME)
        }, 60, TimeUnit.SECONDS);
            NamedXContentRegistry namedXContentRegistry,
    /** Primary's node name. */
        // Use the authoritative cluster-state node map. During a failover the old primary's node id
    }
     * that all configured formats actually produced files on disk.
import org.opensearch.be.lucene.LucenePlugin;
    /** Hard-kill a node with no graceful handshake. */
import org.opensearch.repositories.fs.ReloadableFsRepository;
    /** Assert the new generation is strictly greater than the reference. */
            .put("index.pluggable.dataformat", "composite")
                .filter(p -> p != MockFsMetadataSupportedRepositoryPlugin.class)
                throw new AssertionError("engine transiently closed during reassignment; will retry", e);
    protected void assertLuceneIndexDirContents(IndexShard shard) throws java.io.IOException {
 * compatible open source license.
        }
            }
            60,
    }
            // lucene files live in index/, not in a sibling format directory
                LucenePlugin.class,
            if ("lucene".equals(format)) continue;
    public static class NativeAwareMockFsMetadataSupportedRepositoryPlugin extends Plugin
    /** Suppresses index-input-cleaner threads leaked by MMapDirectory / SwitchableIndexInput. */
                    assertLuceneIndexDirContents(replica);
    }
     * Wait for the BackgroundIndexer's acknowledged doc count to reach {@code numDocs}.
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            assertEquals("primary term did not reach expected value", expectedTerm, shard.getOperationPrimaryTerm());
            .stream()
/**
     * Returns the set of data formats this index variant uses. Override in subclasses that use
 * this file be licensed under the Apache-2.0 license or a
    @Override
            .collect(java.util.stream.Collectors.toSet());
                    assertEquals("primary/replica catalog files must converge on node " + replicaNode, primaryFiles, replicaFiles);
 * shared across promotion and peer-recovery ITs.
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(replicaCount)).get();
     */
        final Settings settings = super.nodeSettings(nodeOrdinal);
                // Engine can be transiently closed while a shard is being re-assigned after a
import org.opensearch.index.store.RemoteSegmentStoreDirectory.UploadedSegmentMetadata;
                    clusterService,
        // Replace both mock repo plugins with native-provider-aware versions so that warm Parquet
     * </ul>
    protected boolean hasLuceneSecondary() {
        assertTrue("BackgroundIndexer acknowledged zero docs — indexing never made progress", indexer.totalIndexedDocs() > 0);
import org.opensearch.be.datafusion.DataFusionPlugin;
                MockFsRepositoryPlugin.TYPE,
 * Abstract base class for DFA replication integration tests. Centralizes boilerplate
            .shard(0)
        public Map<String, Repository.Factory> getRepositories(
            .put("index.pluggable.dataformat.enabled", true)
 * SPDX-License-Identifier: Apache-2.0
     * Trigger primary promotion WITHOUT stopping the host node, by cancelling the primary's
    }
import org.opensearch.indices.replication.common.ReplicationType;
import org.opensearch.env.Environment;
                // promotion (old primary → new replica). Treat as assertBusy-retryable.
        @Override
                ArrowBasePlugin.class,
import org.opensearch.remotestore.mocks.MockFsMetadataSupportedRepositoryPlugin;
import java.util.List;
import org.opensearch.test.InternalTestCluster;
     * Verify that indexing acknowledged writes and that primary/replica catalogs converge.
                    namedXContentRegistry,
    protected static final String INDEX_NAME = "dfa-replication-base-idx";
    protected void createDfaIndex(int replicaCount) throws Exception {
     * allocation via {@code _cluster/reroute}. The replica is promoted to primary while both
     * nodes remain alive. Avoids tearing down node-scoped native resources (e.g. the shared
    /**
        String nodeId = getClusterState().routingTable().index(INDEX_NAME).shard(0).primaryShard().currentNodeId();
    protected void assertCatalogSnapshotsConverged(String index) throws Exception {
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
            super.nodePlugins().stream()
    /** Wait for the given shard's primary term to reach expected. */
        }
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
    }
            if (translogRepoPath != null) java.nio.file.Files.createDirectories(translogRepoPath);
    /** Assert post-test convergence: primary and replica have equal catalog files (excluding segments_N). */
     * <p>Keeps {@link MockFsRepository} as the implementation rather than a plain {@link FsRepository}:
                ParquetDataFormatPlugin.class,
        client().admin().indices().prepareFlush(index).get();
    /** Extract the set of distinct data formats from an uploaded-segments map. */
     * <p>We cannot rely on per-doc counting on DFA indices: {@code DataformatAwareCatalogSnapshot.getNumDocs()}
import org.opensearch.plugins.Plugin;
import org.opensearch.core.xcontent.NamedXContentRegistry;
            java.nio.file.Path dir = shard.shardPath().getDataPath().resolve(format);
            Stream.<Class<? extends Plugin>>of(
        assertTrue("index/ directory must exist", java.nio.file.Files.exists(indexDir));
        ) {
    }
    }
    @Override
                .filter(p -> p != MockFsRepositoryPlugin.class),
            try (var stream = java.nio.file.Files.list(dir)) {
        internalCluster().startDataOnlyNodes(2);
