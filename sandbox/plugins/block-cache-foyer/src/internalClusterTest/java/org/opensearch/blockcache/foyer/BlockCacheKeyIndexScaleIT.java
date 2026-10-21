        logger.info("[scale-04] recovery complete, key_index.json exists");
     * <p>Use {@link #findFoyerMetadataCacheDir()} for the metadata-tier subdir.
/**
        );
     * Locates the Foyer block cache directory that holds {@code key_index.json}.
            .nodesStats(new NodesStatsRequest().addMetric(NodesStatsRequest.Metric.FILE_CACHE_STATS.metricName()).fileCacheDetailed(true))
        assertTrue("key_index.json must contain version:1", content.contains("\"version\":1"));
import java.nio.file.Path;
        return String.format(java.util.Locale.ROOT, "idx-%04d", i);
        // Delete all originals.
import org.opensearch.node.Node;
    /**
            .put("location", randomRepoPath())
    }
     *
 * this file be licensed under the Apache-2.0 license or a
        @Override
        internalCluster().restartNode(getWarmNodeName());
        ensureGreen();
        PlainActionFuture<PruneBlockCacheResponse> future = new PlainActionFuture<>();
                assertThat("block_cache stats must be present on warm node", blockCacheStats, notNullValue());
                }
    private static final String KEY_INDEX_FILENAME = "key_index.json";
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, SHARDS_PER_IDX)
            "metadata-tier cache directory must exist on warm node after restart "
        // Index 1 doc into each index to make the snapshot non-trivial.
        for (int i = 0; i < NUM_INDICES; i++) {
     * subdir in that case. In single-cache mode the file lives directly under
        assertThat("used_bytes must be 0 after prune", usedAfterPrune, equalTo(0L));
                foundWarmNode = true;
 * The OpenSearch Contributors require contributions made to
            String name = indexName(i);
    public void testKeyIndexJsonForBothTiersWrittenOnShutdown() throws Exception {
        Path root = findFoyerCacheRoot();
            client.prepareIndex(name).setSource("field", "value").get();
        PruneBlockCacheResponse pruneResponse = future.actionGet();
@ThreadLeakFilters(filters = BlockCacheKeyIndexScaleIT.IndexInputCleanerFilter.class)
            .put("compress", randomBoolean())
            .cluster()
    /**
            () -> assertTrue("key_index.json must be written by periodic persist task", Files.exists(cacheDir.resolve(KEY_INDEX_FILENAME))),
        // Metadata tier
                client().admin().indices().prepareDelete(indexName).get();
     * Creates {@value NUM_INDICES} indices × {@value SHARDS_PER_IDX} shards each,
     * exists, then restores all as REMOTE_SNAPSHOT indices on the warm node.
     */
     *
        );
        // Delete half the indices to trigger evict_prefix for each.
        String dataContent = Files.readString(dataKeyIndex);
        // Snapshot all indices at once.
        NodesStatsResponse response = client().admin()
    /**
        internalCluster().ensureAtLeastNumDataNodes(1);
    /**
    private static final String SNAP_NAME = "snap-scale";
            var nodesInfoResponse = client().admin().cluster().prepareNodesInfo().get();
            .setRenamePattern("(.+)")
            .cluster()
        }
        ensureGreen();
import java.util.List;
        Path metaDir = findFoyerMetadataCacheDir();
        NodesStatsResponse statsResponse = client().admin()
        logger.warn("foyer-block-cache directory not found under warm node '{}'", warmName);
        for (String name : indexNames) {
        assertNotNull("foyer-block-cache directory must exist after restart", cacheDir);
        String[] names = internalCluster().getNodeNames();
        assertTrue("Warm node must still be present and healthy after bulk evict_prefix", foundWarm);
        String metaContent = Files.readString(metaKeyIndex);
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
        internalCluster().ensureAtLeastNumWarmNodes(1);
    /**
            .nodesStats(new NodesStatsRequest().addMetric(NodesStatsRequest.Metric.FILE_CACHE_STATS.metricName()).fileCacheDetailed(true))
            .put(FsRepository.BASE_PATH_SETTING.getKey(), "key_index_10k_it");
            Path candidate = dataPath.resolve("foyer-block-cache");
        // Data tier
        assertTrue("data-tier key_index.json must exist after restart", Files.exists(dataKeyIndex));
        Path metaKeyIndex = metaDir.resolve(KEY_INDEX_FILENAME);
import java.util.Collection;
    protected Settings.Builder randomRepositorySettings() {
        if (root == null) {
    private Path findFoyerCacheRoot() {
                    return blockCacheStats.diskBytesUsed();
        assertEquals("Prune should have no failures", 0, pruneResponse.failures().size());
                .get();
        return false;
        assertTrue("metadata-tier key_index.json must contain version:1", metaContent.contains("\"version\":1"));
        client().execute(PruneBlockCacheAction.INSTANCE, new PruneBlockCacheRequest(), future);
        assertEquals("Should target 1 warm node", 1, pruneResponse.getNodes().size());
    /**
        } catch (Exception ignored) {}
        logger.info("[scale-01] restarting warm node '{}'", getWarmNodeName());
            }
 * @opensearch.internal
     * {@code foyer-block-cache/}, which is what gets returned then.
            .setRenameReplacement("$1-copy")
import org.opensearch.common.settings.Settings;
            // the security manager that blocks System.getProperty in internalClusterTests).
        }
        if (root == null) {
        createRepository(REPO_NAME, FsRepository.TYPE);
        }
        String content = Files.readString(cacheDir.resolve(KEY_INDEX_FILENAME));
        assertTrue("key_index.json must contain version:1", content.contains("\"version\":1"));
        return 0L;
    }
            }
     * cluster is GREEN, and block_cache stats are accessible.
    }
import org.opensearch.snapshots.AbstractSnapshotIntegTestCase;
     * each subdir has its own {@code key_index.json}. This helper returns the data
        setupScaleShards();
    public void testEvictPrefixAfterRecovery() throws Exception {
     * the cache is in tiered mode, or {@code null} in single-cache mode.
            }
            .execute()
            NUM_INDICES,
     * Validates that {@code clear()} + key_index wipe + file deletion does not time out.
     * snapshots them into a single repo, deletes the originals, ensures a warm node
    /**
import static org.hamcrest.Matchers.greaterThan;
 * Integration tests for the Foyer block cache key_index with many remote-snapshot indices.
        final Client client = client();
        assertNotNull("A warm node must be present in the cluster", warmName);
        logger.info("[scale-04] deleting {} indices to trigger bulk evict_prefix", NUM_INDICES / 2);
        setupScaleShards();
        assertThat(snapResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
        assertFalse("key_index.json must not be empty", content.isBlank());
        assertNotNull("data-tier cache directory must exist on warm node after restart", dataDir);
        assertFalse("metadata-tier key_index.json must not be empty", metaContent.isBlank());
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
            return null;
     */
                BlockCacheStats blockCacheStats = stats.getBlockCacheOnlyStats();
import org.opensearch.cluster.metadata.IndexMetadata;
    public void testKeyIndexJsonWrittenOnShutdown() throws Exception {
import static org.hamcrest.Matchers.notNullValue;
        try {
 * compatible open source license.
    }
        assertTrue("metadata-tier key_index.json must exist after restart", Files.exists(metaKeyIndex));
            .cluster()
        public boolean reject(Thread t) {
        PruneBlockCacheResponse pruneResponse = future.actionGet();
        Path cacheDir = findFoyerCacheDir();
import org.opensearch.plugins.Plugin;
     */
    }
        long usedAfter = getWarmNodeUsedBytes();
            .cluster()
        }
        ensureGreen();
    /** Locates the {@code foyer-block-cache} parent directory on the warm node. */
    @Override
            .setWaitForCompletion(true)
        logger.info(
            .setIndices(indexNames.toArray(new String[0]))
    }
     * the layout is {@code foyer-block-cache/data/} and {@code foyer-block-cache/metadata/};
        // Ensure warm node exists.
import org.opensearch.action.support.PlainActionFuture;
        ensureGreen(TimeValue.timeValueSeconds(120));
        return root;                 // single-cache mode
            TimeUnit.SECONDS
        assertTrue("Block cache should be cleared", pruneResponse.getNodes().get(0).isCleared());
        assertNotNull(pruneResponse);
    private Path findFoyerCacheDir() {
                    Settings.builder()
        client().execute(PruneBlockCacheAction.INSTANCE, new PruneBlockCacheRequest(), future);
        assertEquals("Prune should have no failures", 0, pruneResponse.failures().size());
        for (int i = 0; i < NUM_INDICES / 2; i++) {
            // Short persist interval so tests don't wait 60 seconds.
        assertFalse("data-tier key_index.json must not be empty", dataContent.isBlank());
        NodesStatsResponse response = client().admin()
 */
    private static final int NUM_INDICES = 5;
 * correctness, and warm-node health at scale.
        assertNotNull("foyer-block-cache directory must exist on warm node after restart", cacheDir);
    public void testPruneCompletes() throws Exception {
        ensureGreen();
        // Use an extended timeout: after restart, 25 REMOTE_SNAPSHOT shards (5 indices × 5 shards)
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
            .setWaitForCompletion(true)
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
import org.opensearch.env.Environment;
     * Verifies that the warm node remains healthy after restoring all indices,
 *
     * its own Drop impl, and its own periodic-persist task. A regression in either
        internalCluster().restartNode(getWarmNodeName());
import org.opensearch.common.util.FeatureFlags;
                .prepareCreate(name)
/*
        assertBusy(
    /**
    private static final String REPO_NAME = "repo-scale";
        // Extended timeout: 25 REMOTE_SNAPSHOT shards must re-open after warm node restart.
            metaDir
                .indices()
        setupScaleShards();
            NUM_INDICES * SHARDS_PER_IDX
        ensureGreen();
            .prepareRestoreSnapshot(REPO_NAME, SNAP_NAME)
        assertTrue("key_index.json must exist after restart", Files.exists(cacheDir.resolve(KEY_INDEX_FILENAME)));
     * Validates that bulk {@code evict_prefix()} on recovered prefix buckets completes
            .nodesStats(new NodesStatsRequest().addMetric(NodesStatsRequest.Metric.FILE_CACHE_STATS.metricName()).fileCacheDetailed(true))
    public void testPeriodicPersistFires() throws Exception {
        logger.info(
    /**
        Path root = findFoyerCacheRoot();
    }
     * Restart the warm node after restoring all indices. Verifies that {@code key_index.json}
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
        for (NodeStats stats : response.getNodes()) {
            return null;
     */
        String content = Files.readString(cacheDir.resolve(KEY_INDEX_FILENAME));
    @Override
            client.admin()
        }
import org.opensearch.action.admin.cluster.blockcache.PruneBlockCacheAction;
                BlockCacheStats blockCacheStats = stats.getBlockCacheOnlyStats();
     * Verifies that the periodic persist task writes {@code key_index.json} within the
                if (nodeInfo.getNode().isWarmNode()) {
    }
        List<String> indexNames = new ArrayList<>(NUM_INDICES);
            }
     * 5 indices × 5 shards each = 25 total shards.
import org.opensearch.repositories.fs.FsRepository;
     * is written by the {@code Drop} impl on shutdown and is valid JSON.
        assertTrue("key_index.json must contain an index object", content.contains("\"index\":{"));
package org.opensearch.blockcache.foyer;
    @Override
    }
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 *
    protected Settings nodeSettings(int nodeOrdinal) {
        }
        assertTrue("Expected at least one warm node to be present", foundWarmNode);
     */
     * {@code foyer-block-cache/metadata}. Each tier owns its own key_index.json,
        client.admin()
        // Warm node must still be responsive.
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
                        .build()
            .put("block_cache.foyer.key_index_sweep_interval_seconds", 0)
    // ── Helpers ───────────────────────────────────────────────────────────────
     * Large enough to exercise multi-index key_index serialization, periodic persist, and
        ensureGreen(TimeValue.timeValueSeconds(120));
     */
     * <p>In tiered mode (default — {@code block_cache.foyer.metadata_cache_ratio > 0})
        // Create all indices.
}
     * configured interval (5s) without being starved when the key_index is large.
        setupScaleShards();
        client.admin().indices().prepareDelete(indexNames.toArray(new String[0])).get();
            SHARDS_PER_IDX,
import org.opensearch.action.admin.cluster.blockcache.PruneBlockCacheResponse;
        return Files.isDirectory(metaSubdir) ? metaSubdir : null;
            .get();
            for (var nodeInfo : nodesInfoResponse.getNodes()) {
import org.opensearch.plugins.BlockCacheStats;
        assertThat("used_bytes must be 0 after bulk evict_prefix + prune", usedAfter, equalTo(0L));
     * bulk evict_prefix code paths without exhausting resources on a dev/CI machine.
        internalCluster().restartNode(getWarmNodeName());
        Path metaSubdir = root.resolve("metadata");
            // 2GB is small enough to pass disk validation on any dev/CI machine.
        return null;
        assertTrue("data-tier key_index.json must contain version:1", dataContent.contains("\"version\":1"));
import static org.hamcrest.Matchers.equalTo;
        Path cacheDir = findFoyerCacheDir();
    }
 * SPDX-License-Identifier: Apache-2.0
            .actionGet();
        // must re-open before the cluster goes GREEN. The default 60s is insufficient under load.
        Path dataKeyIndex = dataDir.resolve(KEY_INDEX_FILENAME);
            .cluster()
        logger.info("[scale-04] restarting warm node to trigger key_index recovery");
        for (Path dataPath : environment.dataFiles()) {
     * Calls {@code /_blockcache/prune} and verifies it completes with no failures.
            .actionGet();
                return candidate;
     * Returns the metadata-tier subdir ({@code foyer-block-cache/metadata}) when
        ensureGreen(TimeValue.timeValueSeconds(120));
 */
    public void testWarmNodeRemainsHealthy() throws Exception {
    }
            if (stats.getNode().isWarmNode()) {
        Environment environment = internalCluster().getInstance(Environment.class, warmName);
    }
import com.carrotsearch.randomizedtesting.ThreadFilter;
        );
                    return nodeInfo.getNode().getName();
import java.util.concurrent.TimeUnit;
            if (stats.getNode().isWarmNode()) {
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
     * Tiered mode: verify that BOTH the data tier and the metadata tier write
        String warmName = getWarmNodeName();
                if (blockCacheStats != null) {
        return List.<Class<? extends Plugin>>of(BlockCacheFoyerPlugin.class);
        }
            .actionGet();
            return t.getName().startsWith("index-input-cleaner");
        logger.info("[scale-03] pruning on warm node '{}'", getWarmNodeName());
 * <p>Uses 20 indices × 25 shards each = 500 total shards on the warm node. Tests verify
     * their own {@code key_index.json} on graceful warm-node shutdown.
    @Override
    }
import org.opensearch.common.unit.TimeValue;
public class BlockCacheKeyIndexScaleIT extends AbstractSnapshotIntegTestCase {
     * and the warm node remains healthy.
    private long getWarmNodeUsedBytes() {
    private Path findFoyerMetadataCacheDir() {
        if (Files.isDirectory(dataSubdir)) {
    }
            "[setup-shards] {} remote-snapshot indices ({} total shards) ready on warm node",
 * serialization correctness, periodic-persist stability, prune completion, bulk evict_prefix
            .put(super.nodeSettings(nodeOrdinal))
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), "2gb")
    private String getWarmNodeName() {
        );
        assertNotNull("foyer-block-cache directory must exist on warm node", cacheDir);
        logger.info("[scale-02] waiting for periodic persist (interval=5s)");
            if (Files.isDirectory(candidate)) {
            .actionGet();
    private static String indexName(int i) {
import java.nio.file.Files;
     * True scale (10k-entry key_index) is covered by the Rust integration tests in tests.rs.
        // Prune to flush any remaining evictions.
        setupScaleShards();
    /**
            return dataSubdir;       // tiered mode
        // Restore all as REMOTE_SNAPSHOT with "-copy" suffix.
        Path dataSubdir = root.resolve("data");
        setupScaleShards();
     */
 *
        Path dataDir = findFoyerCacheDir();
        return names.length > 0 ? names[0] : null;
     * <p>With the default {@code block_cache.foyer.metadata_cache_ratio} (5%) the
    }
                )
            30,
    protected boolean addMockInternalEngine() {
     * Foyer block cache runs in tiered mode and creates two independent Foyer
            NUM_INDICES,
        ensureGreen();
        long usedAfterPrune = getWarmNodeUsedBytes();
    }
            .prepareCreateSnapshot(REPO_NAME, SNAP_NAME)
            // Enable Foyer via node settings (FeatureFlags.initFromSettings bypasses
            // Raise shards-per-node limit.
            indexNames.add(name);
import org.opensearch.transport.client.Client;
                }
     * tier's persistence wiring would leak state across restarts.
                assertThat("used_bytes must be >= 0", blockCacheStats.diskBytesUsed(), greaterThan(-1L));
        assertNotNull(
            .build();
    public static final class IndexInputCleanerFilter implements ThreadFilter {
import org.opensearch.action.admin.cluster.blockcache.PruneBlockCacheRequest;
    }
        boolean foundWarmNode = false;
            .put("cluster.max_shards_per_node", 200)
                .setSettings(
        boolean foundWarm = statsResponse.getNodes().stream().anyMatch(n -> n.getNode().isWarmNode());
import java.util.ArrayList;
    private static final int SHARDS_PER_IDX = 5;
        final var snapResponse = client.admin()
        return Settings.builder()
    // ── Tests ─────────────────────────────────────────────────────────────────
     */
        logger.info("[scale-tiered-01] restarting warm node '{}'", getWarmNodeName());
     *
     */
            }
            .setStorageType(RestoreSnapshotRequest.StorageType.REMOTE_SNAPSHOT)
        PlainActionFuture<PruneBlockCacheResponse> future = new PlainActionFuture<>();
     * Restart (triggering key_index recovery), delete half the indices, then prune.
        }
        return Settings.builder()
            String indexName = indexName(i) + "-copy";
            .put("block_cache.foyer.key_index_persist_interval_seconds", 5)
        assertFalse("key_index.json must not be empty", content.isBlank());
        for (NodeStats stats : response.getNodes()) {
    }
        }
    private void setupScaleShards() throws Exception {
        }
        Path cacheDir = findFoyerCacheDir();
            if (client().admin().indices().prepareExists(indexName).get().isExists()) {
                + "(check block_cache.foyer.metadata_cache_ratio is > 0)",
     * instances rooted at {@code foyer-block-cache/data} and
            NUM_INDICES * SHARDS_PER_IDX
            "[setup-shards] creating {} indices × {} shards each = {} total shards",
     */
        assertTrue("key_index.json must exist after recovery", Files.exists(cacheDir.resolve(KEY_INDEX_FILENAME)));
