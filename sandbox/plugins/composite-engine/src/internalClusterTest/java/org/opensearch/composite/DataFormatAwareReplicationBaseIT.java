    public static class NativeAwareMockFsRepositoryPlugin extends Plugin implements org.opensearch.plugins.RepositoryPlugin {
        return getClusterState().routingTable()
        }  
import java.util.stream.Stream;
            if (segmentRepoPath != null) java.nio.file.Files.createDirectories(segmentRepoPath);
                    assertLuceneIndexDirContents(replica);
     * Wait for the BackgroundIndexer's acknowledged doc count to reach {@code numDocs}.
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
 * SPDX-License-Identifier: Apache-2.0
        public boolean reject(Thread t) {
    protected void crashNode(String nodeName) throws Exception {  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.store.RemoteSegmentStoreDirectory.UploadedSegmentMetadata;
     */
     */
    protected void assertGenerationMonotonic(long reference, long current) {  
     * secondary format have the same expected set.  
@ThreadLeakFilters(filters = DataFormatAwareReplicationBaseIT.CleanerThreadFilter.class)
            .map(s -> nodeNameFromId(s.currentNodeId()))
        // can linger in the routing table for a moment after the node leaves; throw an AssertionError
import java.util.concurrent.TimeUnit;  
    }
            NamedXContentRegistry namedXContentRegistry,
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            assertTrue(  
     * <p>Lucene is always present (it underlies every DFA index regardless of secondary format
     */
                "parquet-only: index/ must have only segments_N (and write.lock), got extra: " + nonSegmentsFiles,
    @Override
import org.opensearch.be.lucene.LucenePlugin;
            }
            files = stream.map(p -> p.getFileName().toString()).collect(java.util.stream.Collectors.toSet());  
    }
        assertBusy(() -> {
import org.opensearch.common.concurrent.GatedCloseable;
    /**  
                FsNativeObjectStorePlugin.class,
        java.util.Set<String> files;
            java.nio.file.Path dir = shard.shardPath().getDataPath().resolve(format);
        }
            60,  
import org.opensearch.test.OpenSearchIntegTestCase;
     *
     * Asserts that the index/ directory on the shard contains the expected Lucene files:  
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
 * Abstract base class for DFA replication integration tests. Centralizes boilerplate
            .shard(0)
        return Settings.builder()
import org.opensearch.remotestore.mocks.MockFsMetadataSupportedRepositoryPlugin;
 * compatible open source license.
     * writes, which remote store fencing requires. Substituting {@code FsRepository} here made every
     * <p>We cannot rely on per-doc counting on DFA indices: {@code DataformatAwareCatalogSnapshot.getNumDocs()}
            () -> assertTrue(
import org.opensearch.repositories.Repository;
    }  
            IndexResponse indexResponse = client().prepareIndex(INDEX_NAME)  
        ).collect(Collectors.toList());  
import org.opensearch.common.util.FeatureFlags;
     * allocation via {@code _cluster/reroute}. The replica is promoted to primary while both  
import java.util.Set;
     * Asserts that for every format in {@link #expectedFormats()} (excluding lucene which lives
    }  
                NativeAwareMockFsMetadataSupportedRepositoryPlugin.class,  
        return segments.keySet().stream().map(file -> new FileMetadata(file).dataFormat()).collect(Collectors.toSet());
                .setSource("field_text", randomAlphaOfLength(10), "field_keyword", randomAlphaOfLength(10), "field_number", (long) i)
            } catch (org.apache.lucene.store.AlreadyClosedException e) {  
        java.util.Set<String> nonSegmentsFiles = files.stream()  
        client().admin()  
            .prepareReroute()
        return Stream.concat(
                metadata -> new ReloadableFsRepository(
 * shared across promotion and peer-recovery ITs.  
     * Trigger primary promotion WITHOUT stopping the host node, by cancelling the primary's
import org.opensearch.arrow.allocator.ArrowBasePlugin;
import org.opensearch.core.xcontent.NamedXContentRegistry;
    }
    /** Graceful stop with handshake. */
    }  
     */
    }
     * Replaces {@code waitForDocs(long, BackgroundIndexer)} which issues a Lucene search  
    /**
            ids.add(indexResponse.getId());
        internalCluster().startDataOnlyNodes(2);
    protected static final String INDEX_NAME = "dfa-replication-base-idx";  
            if ("lucene".equals(format)) continue;  
}  
                .filter(p -> p != MockFsMetadataSupportedRepositoryPlugin.class)  
     * a different format combination. Used by tests for format-aware assertions.
import org.opensearch.common.unit.TimeValue;  
    }
            String currentPrimaryNode = primaryNodeName();
            ClusterService clusterService,  
        }
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;  
    protected static Set<String> formatsOf(Map<String, UploadedSegmentMetadata> segments) {  
import org.opensearch.indices.recovery.RecoverySettings;
import java.util.List;  
            Environment env,
        ensureGreen(INDEX_NAME);
        indexer.assertNoFailures();
            ClusterService clusterService,
    protected void createDfaIndex(int replicaCount) throws Exception {  
        @Override  
    public static class NativeAwareMockFsMetadataSupportedRepositoryPlugin extends Plugin
import org.opensearch.be.datafusion.DataFusionPlugin;  
        assertTrue("index/ directory must exist", java.nio.file.Files.exists(indexDir));  
        } catch (java.io.IOException e) {
        return nodeNameFromId(nodeId);  
                assertTrue("format directory must have files: " + format, stream.findAny().isPresent());
     *   <li>Convergence of the catalog file set between primary and replica.</li>
                    assertEquals("primary/replica catalog files must converge on node " + replicaNode, primaryFiles, replicaFiles);
            .filter(f -> f.startsWith("segments_") == false && f.equals("write.lock") == false)
        @Override
            org.opensearch.plugins.RepositoryPlugin {
    protected Settings nodeSettings(int nodeOrdinal) {
     * - parquet+lucene: segments_N plus additional segment data files (.si, .cfs, etc.)
            ),
        public Map<String, Repository.Factory> getRepositories(
     * the mock's blob container is the only one of the two that reports store-enforced conditional  
        // so that callers under assertBusy() retry rather than fail hard.  
     * (promotion losing commits, recovery dropping files, orphan files on replica).
        }
        if (hasLuceneSecondary()) {  
    }
        for (int i = 0; i < count; i++) {
    }  
            throw new AssertionError("node with id " + nodeId + " not present in cluster state yet");  
        java.nio.file.Path indexDir = shard.shardPath().resolveIndex();
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
    /** Suppresses index-input-cleaner threads leaked by MMapDirectory / SwitchableIndexInput. */
            try (var stream = java.nio.file.Files.list(dir)) {  
        }
            .add(new org.opensearch.cluster.routing.allocation.command.CancelAllocationCommand(index, shardId, nodeName, true))  
import org.opensearch.test.InternalTestCluster;  
        return ids;  
            // lucene files live in index/, not in a sibling format directory
            return Collections.singletonMap(
    protected void waitForPrimaryTerm(String index, int shardId, long expectedTerm, TimeValue timeout) throws Exception {  
            .put("index.pluggable.dataformat", "composite")  
                MockFsMetadataSupportedRepositoryPlugin.TYPE_MD,
        return true;
        internalCluster().startClusterManagerOnlyNode();
    /** Wires FsNativeObjectStorePlugin into "fs_metadata_supported_repository" repos. */
    }
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeName));  
        try {
     * nodes remain alive. Avoids tearing down node-scoped native resources (e.g. the shared
                "expected at least " + numDocs + " acked docs, got " + indexer.totalIndexedDocs(),  
import java.util.stream.Collectors;
            );  
import org.opensearch.index.shard.IndexShard;
        );
    /**
            return Collections.singletonMap(  
    protected Set<String> expectedFormats() {
        private final FsNativeObjectStorePlugin nativeProvider = new FsNativeObjectStorePlugin();  
    }
/*  
        // Use the authoritative cluster-state node map. During a failover the old primary's node id
            .put(remoteStoreIndexSettings(replicaCount, 1))  
            );
import org.opensearch.cluster.metadata.IndexMetadata;
        // RemoteStoreBaseIntegTestCase randomly picks (metadataSupportedType = randomBoolean()).  
    /** Replica node names. */  
            .stream()  
import java.util.Collections;
     * <ul>
            .cluster()
    /** Assert the new generation is strictly greater than the reference. */
        assertTrue("catalog generation must advance: reference=" + reference + ", current=" + current, current > reference);
    }  
        ) {  
import org.opensearch.repositories.fs.ReloadableFsRepository;  
import org.opensearch.plugins.Plugin;
     * currently returns {@code 0L} (stub), and the Lucene search path is rejected for DFA engines via  
    /**
        client().admin().indices().prepareFlush(index).get();
                )  
        try (GatedCloseable<CatalogSnapshot> closeable = shard.getCatalogSnapshot()) {
            if (translogRepoPath != null) java.nio.file.Files.createDirectories(translogRepoPath);  
        return Settings.builder().put(settings).put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true).build();
import org.opensearch.env.Environment;  
            )
        assertTrue("index/ must contain segments_N, got " + files, files.stream().anyMatch(f -> f.startsWith("segments_")));
            .putList("index.composite.secondary_data_formats", List.of("lucene"))
        org.opensearch.cluster.node.DiscoveryNode node = getClusterState().nodes().get(nodeId);
            assertFalse("parquet+lucene: index/ must have segment data files beyond segments_N, got " + files, nonSegmentsFiles.isEmpty());
    }
            Stream.<Class<? extends Plugin>>of(
    protected boolean hasLuceneSecondary() {
            IndexShard shard = getIndexShard(currentPrimaryNode, index);  
                LucenePlugin.class,  
    protected void assertAllFormatDirsHaveFiles(IndexShard shard) throws java.io.IOException {  
            NamedXContentRegistry namedXContentRegistry,  
        // Flush so every ack'd write lives in a persisted catalog snapshot.  
    @Override  
        return node.getName();
        @Override
        final Settings settings = super.nodeSettings(nodeOrdinal);  
    }  
            .build();  
    }
    }  
    protected void waitForIndexerDocs(long numDocs, BackgroundIndexer indexer) throws Exception {  
import org.opensearch.index.store.FileMetadata;  
                // Engine can be transiently closed while a shard is being re-assigned after a
     */  
    }  
    }  
                    recoverySettings,
            assertEquals("primary term did not reach expected value", expectedTerm, shard.getOperationPrimaryTerm());
     * under {@code index/}), a non-empty directory exists on the shard's data path. Validates  
/**
package org.opensearch.composite;
    }
     * that DFA engines reject (see {@link #assertNoDataLoss}).
        // Replace both mock repo plugins with native-provider-aware versions so that warm Parquet
    /**
import org.opensearch.test.BackgroundIndexer;
        // Pre-create repo dirs so FsNativeObjectStorePlugin's canonicalize() succeeds at startup.
                .filter(p -> p != MockFsRepositoryPlugin.class),
    /** Hard-kill a node with no graceful handshake. */
        }
    private String nodeNameFromId(String nodeId) {  
    public static class CleanerThreadFilter implements ThreadFilter {  
     * fencing-enabled fail shard recovery outright.  
        ensureYellowAndNoInitializingShards(INDEX_NAME);
    protected Settings dfaIndexSettings(int replicaCount) {
import java.util.ArrayList;  
        // shards can obtain a live NativeStoreRepository regardless of which repo type
                nonSegmentsFiles.isEmpty()
                for (String replicaNode : replicaNodeNames()) {
     *   <li>The BackgroundIndexer's own accounting of acknowledged writes.</li>  
     * configuration), so it's included by default. Subclasses with explicit Lucene as a
     * Verify that indexing acknowledged writes and that primary/replica catalogs converge.  
                }  
     * that all configured formats actually produced files on disk.
                    Set<String> replicaFiles = DataFormatAwareITUtils.catalogFilesExcludingSegments(replica);  
import org.opensearch.repositories.fs.FsRepository;
                ArrowBasePlugin.class,  
import org.opensearch.repositories.fs.native_store.FsNativeObjectStorePlugin;
        }, 60, TimeUnit.SECONDS);
import com.carrotsearch.randomizedtesting.ThreadFilter;
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(replicaCount)).get();  
            .put("index.pluggable.dataformat.enabled", true)
            RecoverySettings recoverySettings
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
            try {
    /** Primary's node name. */  
    protected List<String> replicaNodeNames() {
import java.util.Map;
    /**
import org.opensearch.cluster.service.ClusterService;  
            );
import org.opensearch.remotestore.multipart.mocks.MockFsRepositoryPlugin;  
                    IndexShard replica = getIndexShard(replicaNode, index);
                assertLuceneIndexDirContents(primary);
    protected String primaryNodeName() {
     * seed that picked {@code asyncUploadMockFsRepo=true}, {@code metadataSupportedType=false} and
            .filter(s -> s.started())
 *
     *
                IndexShard primary = getIndexShard(primaryNodeName(), index);
    protected void gracefulStopNode(String nodeName) throws Exception {
     * <p>Keeps {@link MockFsRepository} as the implementation rather than a plain {@link FsRepository}:
    /** Wait for the given shard's primary term to reach expected. */
        public Map<String, Repository.Factory> getRepositories(  
            }
     * {@link #gracefulStopNode}/{@link #crashNode} for promotion scenarios.  
     * DataFusion Tokio runtime manager in test clusters), which is why we prefer this over
            TimeUnit.SECONDS
            return closeable.get().getGeneration();  
        }
     *  
                ParquetDataFormatPlugin.class,
            .replicaShards()
     * {@code applyOnEngine}. The two signals available are:
 */
        List<String> ids = new ArrayList<>();
            .actionGet();
     * </ul>
public abstract class DataFormatAwareReplicationBaseIT extends RemoteStoreBaseIntegTestCase {
     */
        assertTrue("BackgroundIndexer acknowledged zero docs — indexing never made progress", indexer.totalIndexedDocs() > 0);
        if (node == null) {
        String nodeId = getClusterState().routingTable().index(INDEX_NAME).shard(0).primaryShard().currentNodeId();
    protected void assertNoDataLoss(BackgroundIndexer indexer, String index) throws Exception {  
    /** Index N docs with RefreshPolicy.NONE. */
    /** Read the current catalog generation of a specific node's copy of the shard. */
                indexer.totalIndexedDocs() >= numDocs
                // promotion (old primary → new replica). Treat as assertBusy-retryable.
        IndexShard shard = getIndexShard(nodeName, index);
import org.opensearch.action.index.IndexResponse;
                Set<String> primaryFiles = DataFormatAwareITUtils.catalogFilesExcludingSegments(primary);  
     * Wires FsNativeObjectStorePlugin into "fs_multipart_repository" repos.  
import org.opensearch.parquet.ParquetDataFormatPlugin;
        }
                    clusterService,  
        assertBusy(
        for (String format : expectedFormats()) {
            Environment env,
    }
    protected List<String> indexDocs(int count) {  
                    metadata,  
    protected long readCatalogGeneration(String nodeName, String index) throws Exception {  
    protected void assertCatalogSnapshotsConverged(String index) throws Exception {
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        try (var stream = java.nio.file.Files.list(indexDir)) {
            throw new java.io.UncheckedIOException("Failed to pre-create remote store repo directories", e);
    }  
                DataFusionPlugin.class,
    /** Assert post-test convergence: primary and replica have equal catalog files (excluding segments_N). */
    /** Extract the set of distinct data formats from an uploaded-segments map. */
     */
        assertBusy(() -> {  
        ) {
            .put("index.composite.primary_data_format", "parquet")
            RecoverySettings recoverySettings
                metadata -> new MockFsRepository(metadata, env, namedXContentRegistry, clusterService, recoverySettings, nativeProvider)  
    }
        }  
            .index(INDEX_NAME)  
import org.opensearch.common.settings.Settings;
                .setRefreshPolicy(org.opensearch.action.support.WriteRequest.RefreshPolicy.NONE)
     * - parquet-only: only segments_N (commit metadata)
    protected void cancelPrimaryAllocation(String index, int shardId, String nodeName) throws Exception {
     * Together these catch the common correctness regressions this test suite targets  
                    nativeProvider
            return t.getName().startsWith("index-input-cleaner");  
        assertCatalogSnapshotsConverged(index);
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeName));
    /** Whether lucene is configured as a secondary data format (produces searchable segment files). */  
                    env,
        }, timeout.seconds(), TimeUnit.SECONDS);
    /**
    }
                MockFsRepositoryPlugin.TYPE,
        private final FsNativeObjectStorePlugin nativeProvider = new FsNativeObjectStorePlugin();
            .collect(Collectors.toList());  
 * The OpenSearch Contributors require contributions made to  
                throw new AssertionError("engine transiently closed during reassignment; will retry", e);  
        implements  
import org.opensearch.remotestore.multipart.mocks.MockFsRepository;
        return Set.of("parquet", "lucene");  
import java.util.Collection;
                .get();  
     * Returns the set of data formats this index variant uses. Override in subclasses that use
            .collect(java.util.stream.Collectors.toSet());
            .execute()
    }
                    namedXContentRegistry,
                CompositeDataFormatPlugin.class,
                NativeAwareMockFsRepositoryPlugin.class
            assertTrue("format directory must exist: " + format, java.nio.file.Files.exists(dir));
    protected void assertLuceneIndexDirContents(IndexShard shard) throws java.io.IOException {
 */  
import org.opensearch.indices.replication.common.ReplicationType;  
            super.nodePlugins().stream()
        }
        } else {
                DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(primary);
