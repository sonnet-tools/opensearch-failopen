        assertNotNull("A warm node must be present in the cluster", warmName);
 */  
        assertTrue("data-tier key_index.json must exist after restart", Files.exists(dataKeyIndex));  
    /**
        Path root = findFoyerCacheRoot();
     */
        for (NodeStats stats : response.getNodes()) {  
import org.opensearch.cluster.metadata.IndexMetadata;  
    }
        assertTrue("Block cache should be cleared", pruneResponse.getNodes().get(0).isCleared());  
        );  
            }
    public void testEvictPrefixAfterRecovery() throws Exception {
     */
        assertTrue("data-tier key_index.json must contain version:1", dataContent.contains("\"version\":1"));  
    private Path findFoyerMetadataCacheDir() {
        Path metaSubdir = root.resolve("metadata");  
        logger.info("[scale-01] restarting warm node '{}'", getWarmNodeName());
            // Short persist interval so tests don't wait 60 seconds.
            if (client().admin().indices().prepareExists(indexName).get().isExists()) {
        logger.info(  
     * their own {@code key_index.json} on graceful warm-node shutdown.  
    }
        if (root == null) {  
        ensureGreen();
import org.opensearch.snapshots.AbstractSnapshotIntegTestCase;  
        client().execute(PruneBlockCacheAction.INSTANCE, new PruneBlockCacheRequest(), future);  
        ensureGreen();
        Path dataKeyIndex = dataDir.resolve(KEY_INDEX_FILENAME);
        ensureGreen();
        );
     */
    @Override
        final var snapResponse = client.admin()
            return dataSubdir;       // tiered mode
 *
        assertNotNull(
        // Ensure warm node exists.
            return null;  
        client.admin().indices().prepareDelete(indexNames.toArray(new String[0])).get();
        }
     * each subdir has its own {@code key_index.json}. This helper returns the data  
        PlainActionFuture<PruneBlockCacheResponse> future = new PlainActionFuture<>();
     * True scale (10k-entry key_index) is covered by the Rust integration tests in tests.rs.  
        setupScaleShards();  
import java.util.concurrent.TimeUnit;
    /**  
    private long getWarmNodeUsedBytes() {  
        assertThat("used_bytes must be 0 after prune", usedAfterPrune, equalTo(0L));  
}  
                return candidate;  
            // the security manager that blocks System.getProperty in internalClusterTests).
    }  
    private static final String KEY_INDEX_FILENAME = "key_index.json";  
 */
        return null;
            .get();  
        setupScaleShards();
        );
     */
            }  
            .actionGet();
            NUM_INDICES * SHARDS_PER_IDX
            .setIndices(indexNames.toArray(new String[0]))
        ensureGreen();  
     * Validates that bulk {@code evict_prefix()} on recovered prefix buckets completes
     */
import org.opensearch.plugins.Plugin;
        PruneBlockCacheResponse pruneResponse = future.actionGet();
        final Client client = client();
            Path candidate = dataPath.resolve("foyer-block-cache");
 * The OpenSearch Contributors require contributions made to  
            .actionGet();
        }  
        );
        Environment environment = internalCluster().getInstance(Environment.class, warmName);
import org.opensearch.action.admin.cluster.blockcache.PruneBlockCacheAction;
        setupScaleShards();
                assertThat("block_cache stats must be present on warm node", blockCacheStats, notNullValue());
     * snapshots them into a single repo, deletes the originals, ensures a warm node  
            .prepareRestoreSnapshot(REPO_NAME, SNAP_NAME)
    }  
        internalCluster().restartNode(getWarmNodeName());
                        .build()
    }
            TimeUnit.SECONDS
package org.opensearch.blockcache.foyer;
                foundWarmNode = true;
                }
     * instances rooted at {@code foyer-block-cache/data} and
     * <p>With the default {@code block_cache.foyer.metadata_cache_ratio} (5%) the
            .nodesStats(new NodesStatsRequest().addMetric(NodesStatsRequest.Metric.FILE_CACHE_STATS.metricName()).fileCacheDetailed(true))
            .actionGet();  
     * {@code foyer-block-cache/metadata}. Each tier owns its own key_index.json,
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
     * and the warm node remains healthy.  
     * Foyer block cache runs in tiered mode and creates two independent Foyer  
        return String.format(java.util.Locale.ROOT, "idx-%04d", i);
    /**
        for (int i = 0; i < NUM_INDICES / 2; i++) {
@ThreadLeakFilters(filters = BlockCacheKeyIndexScaleIT.IndexInputCleanerFilter.class)
        // Data tier
    protected Settings.Builder randomRepositorySettings() {  
        setupScaleShards();
    private static final String REPO_NAME = "repo-scale";
        assertTrue("key_index.json must contain version:1", content.contains("\"version\":1"));
    // ── Tests ─────────────────────────────────────────────────────────────────
            // 2GB is small enough to pass disk validation on any dev/CI machine.  
    private static String indexName(int i) {
            .setStorageType(RestoreSnapshotRequest.StorageType.REMOTE_SNAPSHOT)
        assertTrue("key_index.json must exist after restart", Files.exists(cacheDir.resolve(KEY_INDEX_FILENAME)));  
            // Raise shards-per-node limit.
        logger.info("[scale-tiered-01] restarting warm node '{}'", getWarmNodeName());  
            .put(super.nodeSettings(nodeOrdinal))  
        String content = Files.readString(cacheDir.resolve(KEY_INDEX_FILENAME));
            .put("block_cache.foyer.key_index_sweep_interval_seconds", 0)
    }
        assertNotNull("foyer-block-cache directory must exist on warm node after restart", cacheDir);
     * 5 indices × 5 shards each = 25 total shards.  
        long usedAfter = getWarmNodeUsedBytes();
import com.carrotsearch.randomizedtesting.ThreadFilter;
import org.opensearch.common.unit.TimeValue;
            NUM_INDICES * SHARDS_PER_IDX  
    }
                .indices()
                + "(check block_cache.foyer.metadata_cache_ratio is > 0)",  
        // must re-open before the cluster goes GREEN. The default 60s is insufficient under load.
        Path root = findFoyerCacheRoot();
                }
    /**  
/*  
        setupScaleShards();
                if (blockCacheStats != null) {
        Path dataDir = findFoyerCacheDir();
        assertTrue("metadata-tier key_index.json must exist after restart", Files.exists(metaKeyIndex));
     * Restart (triggering key_index recovery), delete half the indices, then prune.
        return 0L;
            if (Files.isDirectory(candidate)) {
    private static final int NUM_INDICES = 5;
            return null;
            .cluster()  
        // Extended timeout: 25 REMOTE_SNAPSHOT shards must re-open after warm node restart.
        for (Path dataPath : environment.dataFiles()) {  
import static org.hamcrest.Matchers.greaterThan;
     * cluster is GREEN, and block_cache stats are accessible.  
            .prepareCreateSnapshot(REPO_NAME, SNAP_NAME)  
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
        }
        }
        assertEquals("Should target 1 warm node", 1, pruneResponse.getNodes().size());
     * bulk evict_prefix code paths without exhausting resources on a dev/CI machine.
            .setWaitForCompletion(true)
            .nodesStats(new NodesStatsRequest().addMetric(NodesStatsRequest.Metric.FILE_CACHE_STATS.metricName()).fileCacheDetailed(true))  
        String metaContent = Files.readString(metaKeyIndex);
        internalCluster().restartNode(getWarmNodeName());
 *
        // Snapshot all indices at once.
            if (stats.getNode().isWarmNode()) {  
                .prepareCreate(name)  
    }
        for (String name : indexNames) {  
import org.opensearch.plugins.BlockCacheStats;  
    public void testWarmNodeRemainsHealthy() throws Exception {
            indexNames.add(name);  
        }
        logger.info("[scale-04] recovery complete, key_index.json exists");
     * <p>Use {@link #findFoyerMetadataCacheDir()} for the metadata-tier subdir.
import org.opensearch.common.util.FeatureFlags;  
import org.opensearch.action.support.PlainActionFuture;
        internalCluster().ensureAtLeastNumWarmNodes(1);
        if (root == null) {
    // ── Helpers ───────────────────────────────────────────────────────────────
        // Warm node must still be responsive.
    private void setupScaleShards() throws Exception {  
        internalCluster().restartNode(getWarmNodeName());  
        Path metaKeyIndex = metaDir.resolve(KEY_INDEX_FILENAME);  
     * Returns the metadata-tier subdir ({@code foyer-block-cache/metadata}) when
public class BlockCacheKeyIndexScaleIT extends AbstractSnapshotIntegTestCase {  
        assertTrue("key_index.json must contain an index object", content.contains("\"index\":{"));
    }
     * Verifies that the warm node remains healthy after restoring all indices,
    }
            if (stats.getNode().isWarmNode()) {
        return Files.isDirectory(metaSubdir) ? metaSubdir : null;
        long usedAfterPrune = getWarmNodeUsedBytes();
     * the cache is in tiered mode, or {@code null} in single-cache mode.
        // Restore all as REMOTE_SNAPSHOT with "-copy" suffix.
        logger.warn("foyer-block-cache directory not found under warm node '{}'", warmName);  
            client.prepareIndex(name).setSource("field", "value").get();
import org.opensearch.transport.client.Client;
    /** Locates the {@code foyer-block-cache} parent directory on the warm node. */
        client().execute(PruneBlockCacheAction.INSTANCE, new PruneBlockCacheRequest(), future);  
import org.opensearch.node.Node;
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), "2gb")
            .cluster()
        assertNotNull("data-tier cache directory must exist on warm node after restart", dataDir);  
        assertNotNull("foyer-block-cache directory must exist on warm node", cacheDir);
     * tier's persistence wiring would leak state across restarts.
            .cluster()
            var nodesInfoResponse = client().admin().cluster().prepareNodesInfo().get();
     *  
        logger.info(
                client().admin().indices().prepareDelete(indexName).get();
            String indexName = indexName(i) + "-copy";  
        NodesStatsResponse response = client().admin()
        // Metadata tier
import java.nio.file.Files;  
        ensureGreen(TimeValue.timeValueSeconds(120));
        assertEquals("Prune should have no failures", 0, pruneResponse.failures().size());
            .put("cluster.max_shards_per_node", 200)
            .cluster()
        setupScaleShards();  
        // Index 1 doc into each index to make the snapshot non-trivial.
            client.admin()
        return Settings.builder()
            NUM_INDICES,  
        assertEquals("Prune should have no failures", 0, pruneResponse.failures().size());
        Path dataSubdir = root.resolve("data");
            "[setup-shards] creating {} indices × {} shards each = {} total shards",
     * Restart the warm node after restoring all indices. Verifies that {@code key_index.json}
        NodesStatsResponse response = client().admin()  
        ensureGreen(TimeValue.timeValueSeconds(120));
        PruneBlockCacheResponse pruneResponse = future.actionGet();
        // Delete half the indices to trigger evict_prefix for each.  
    public void testKeyIndexJsonWrittenOnShutdown() throws Exception {
import org.opensearch.action.admin.cluster.blockcache.PruneBlockCacheRequest;
     * is written by the {@code Drop} impl on shutdown and is valid JSON.
     * Calls {@code /_blockcache/prune} and verifies it completes with no failures.
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;  
        logger.info("[scale-04] deleting {} indices to trigger bulk evict_prefix", NUM_INDICES / 2);
            30,  
            "[setup-shards] {} remote-snapshot indices ({} total shards) ready on warm node",
        Path cacheDir = findFoyerCacheDir();
        client.admin()
    public void testPruneCompletes() throws Exception {
        assertFalse("key_index.json must not be empty", content.isBlank());
    }
            .setWaitForCompletion(true)
        for (int i = 0; i < NUM_INDICES; i++) {
        return false;  
        try {  
import java.util.ArrayList;
    public static final class IndexInputCleanerFilter implements ThreadFilter {
            () -> assertTrue("key_index.json must be written by periodic persist task", Files.exists(cacheDir.resolve(KEY_INDEX_FILENAME))),
    public void testKeyIndexJsonForBothTiersWrittenOnShutdown() throws Exception {  
        assertTrue("Warm node must still be present and healthy after bulk evict_prefix", foundWarm);
        assertThat("used_bytes must be 0 after bulk evict_prefix + prune", usedAfter, equalTo(0L));
    private Path findFoyerCacheDir() {  
        Path cacheDir = findFoyerCacheDir();
            metaDir
            .put(FsRepository.BASE_PATH_SETTING.getKey(), "key_index_10k_it");
            .nodesStats(new NodesStatsRequest().addMetric(NodesStatsRequest.Metric.FILE_CACHE_STATS.metricName()).fileCacheDetailed(true))
        return Settings.builder()
     * Large enough to exercise multi-index key_index serialization, periodic persist, and
        // Use an extended timeout: after restart, 25 REMOTE_SNAPSHOT shards (5 indices × 5 shards)  
     */  
        internalCluster().ensureAtLeastNumDataNodes(1);  
    /**
    }
        }
 * @opensearch.internal  
        assertTrue("key_index.json must exist after recovery", Files.exists(cacheDir.resolve(KEY_INDEX_FILENAME)));  
                BlockCacheStats blockCacheStats = stats.getBlockCacheOnlyStats();  
            SHARDS_PER_IDX,
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
     * subdir in that case. In single-cache mode the file lives directly under
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)  
 * SPDX-License-Identifier: Apache-2.0
     * {@code foyer-block-cache/}, which is what gets returned then.
                )  
            .build();
                    return nodeInfo.getNode().getName();
                assertThat("used_bytes must be >= 0", blockCacheStats.diskBytesUsed(), greaterThan(-1L));
        assertTrue("key_index.json must contain version:1", content.contains("\"version\":1"));  
        assertBusy(
import org.opensearch.env.Environment;
        if (Files.isDirectory(dataSubdir)) {  
            }  
import java.util.List;
     */  
                    return blockCacheStats.diskBytesUsed();  
        assertFalse("key_index.json must not be empty", content.isBlank());  
        }
            return t.getName().startsWith("index-input-cleaner");
            "metadata-tier cache directory must exist on warm node after restart "
        for (NodeStats stats : response.getNodes()) {
    /**
            .put("compress", randomBoolean())  
     * Validates that {@code clear()} + key_index wipe + file deletion does not time out.
        logger.info("[scale-02] waiting for periodic persist (interval=5s)");  
            }  
     */
        // Create all indices.
        } catch (Exception ignored) {}
import static org.hamcrest.Matchers.equalTo;
            .put("location", randomRepoPath())
        List<String> indexNames = new ArrayList<>(NUM_INDICES);  
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        assertFalse("metadata-tier key_index.json must not be empty", metaContent.isBlank());  
     * Creates {@value NUM_INDICES} indices × {@value SHARDS_PER_IDX} shards each,
        ensureGreen();
    }  
     * its own Drop impl, and its own periodic-persist task. A regression in either  
        }  
import org.opensearch.common.settings.Settings;
 * serialization correctness, periodic-persist stability, prune completion, bulk evict_prefix  
            .setRenamePattern("(.+)")
        assertNotNull("foyer-block-cache directory must exist after restart", cacheDir);
        public boolean reject(Thread t) {
            .execute()  
        assertFalse("data-tier key_index.json must not be empty", dataContent.isBlank());
        }
    }  
    /**  
        @Override  
        // Delete all originals.  
import java.nio.file.Path;
        // Prune to flush any remaining evictions.
     */  
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, SHARDS_PER_IDX)
 * correctness, and warm-node health at scale.
    @Override
        assertNotNull(pruneResponse);  
            .setRenameReplacement("$1-copy")  
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
    private static final int SHARDS_PER_IDX = 5;  
        String content = Files.readString(cacheDir.resolve(KEY_INDEX_FILENAME));
    /**
            }
        assertTrue("Expected at least one warm node to be present", foundWarmNode);
        logger.info("[scale-03] pruning on warm node '{}'", getWarmNodeName());
    }
     * <p>In tiered mode (default — {@code block_cache.foyer.metadata_cache_ratio > 0})
    @Override  
        assertTrue("metadata-tier key_index.json must contain version:1", metaContent.contains("\"version\":1"));
    public void testPeriodicPersistFires() throws Exception {  
    /**
 * Integration tests for the Foyer block cache key_index with many remote-snapshot indices.  
                    Settings.builder()
 * this file be licensed under the Apache-2.0 license or a
     */
        NodesStatsResponse statsResponse = client().admin()
     * exists, then restores all as REMOTE_SNAPSHOT indices on the warm node.
import org.opensearch.action.admin.cluster.blockcache.PruneBlockCacheResponse;  
    /**  
     *
        }
     * Verifies that the periodic persist task writes {@code key_index.json} within the  
            // Enable Foyer via node settings (FeatureFlags.initFromSettings bypasses
        return names.length > 0 ? names[0] : null;  
import java.util.Collection;  
            .cluster()  
     * the layout is {@code foyer-block-cache/data/} and {@code foyer-block-cache/metadata/};
    }
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
            String name = indexName(i);
            .put("block_cache.foyer.key_index_persist_interval_seconds", 5)  
    private Path findFoyerCacheRoot() {
 * <p>Uses 20 indices × 25 shards each = 500 total shards on the warm node. Tests verify
        ensureGreen(TimeValue.timeValueSeconds(120));
/**
            for (var nodeInfo : nodesInfoResponse.getNodes()) {
    protected boolean addMockInternalEngine() {
        return root;                 // single-cache mode  
    protected Settings nodeSettings(int nodeOrdinal) {
        String warmName = getWarmNodeName();  
 * compatible open source license.
        logger.info("[scale-04] restarting warm node to trigger key_index recovery");
        PlainActionFuture<PruneBlockCacheResponse> future = new PlainActionFuture<>();
        createRepository(REPO_NAME, FsRepository.TYPE);  
                if (nodeInfo.getNode().isWarmNode()) {  
                BlockCacheStats blockCacheStats = stats.getBlockCacheOnlyStats();
        Path cacheDir = findFoyerCacheDir();
import static org.hamcrest.Matchers.notNullValue;  
     * configured interval (5s) without being starved when the key_index is large.
                .get();
        return List.<Class<? extends Plugin>>of(BlockCacheFoyerPlugin.class);
            .actionGet();
        Path metaDir = findFoyerMetadataCacheDir();
    private String getWarmNodeName() {
            NUM_INDICES,
    private static final String SNAP_NAME = "snap-scale";  
        ensureGreen();  
        boolean foundWarm = statsResponse.getNodes().stream().anyMatch(n -> n.getNode().isWarmNode());  
    }
        String[] names = internalCluster().getNodeNames();
import org.opensearch.repositories.fs.FsRepository;
    }
     *  
                .setSettings(
     * Tiered mode: verify that BOTH the data tier and the metadata tier write
        boolean foundWarmNode = false;
        String dataContent = Files.readString(dataKeyIndex);
 *
        assertThat(snapResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
    @Override
     * Locates the Foyer block cache directory that holds {@code key_index.json}.
