        }
        assertNotNull("foyer-block-cache directory must exist on warm node after restart", recoveryCheck);
        logger.info("[PP-01] index ready; waiting up to 30s for periodic persist (interval=5s) to write key_index.json");
                return candidate;
            .execute()
    /**
    }
    /**
        }
            "data-tier .key_index.json.tmp must not exist after successful rename",
        String metaContent = Files.readString(metaDir.resolve(KEY_INDEX_FILENAME));
    }
        return Settings.builder()
            content.length() > 200 ? content.substring(0, 200) + "…" : content
            Files.exists(dataDir.resolve(KEY_INDEX_TMP_FILENAME))
            ".key_index.json.tmp must not exist after successful periodic persist",
        logger.info("[GS-01] index '{}' restored to warm node; restarting warm node '{}'", restoredIndexName, getWarmNodeName());
    }
            return null;
        long usedAfterPrune = getWarmNodeUsedBytes(client);
     * <p>Each tier owns its own persist task, so this test catches the case where
            // Enable Foyer via node settings (FeatureFlags.initFromSettings bypasses
        @Override
        assertNotNull("A warm node must be present in the cluster", warmName);
        // key_index.json must exist after restart.
            .setStorageType(RestoreSnapshotRequest.StorageType.REMOTE_SNAPSHOT)
        Path cacheDir = findFoyerCacheDir();
            if (stats.getNode().isWarmNode()) {
        final String indexName = "test-tiered-shutdown";
            .put(FsRepository.BASE_PATH_SETTING.getKey(), "key_index_recovery_it");
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
    /** Returns the name of the first warm node in the cluster. Falls back to a random node. */
            .nodesStats(new NodesStatsRequest().addMetric(NodesStatsRequest.Metric.FILE_CACHE_STATS.metricName()).fileCacheDetailed(true))
        return null;
        assertEquals("Prune should have no failures", 0, pruneResponse.failures().size());
        assertTrue("key_index.json must exist after recovery", Files.exists(recoveryCheck.resolve(KEY_INDEX_FILENAME)));
        assertDocCount(indexName + "-copy", 50L);
     * CL-02/CL-04: After a prune (POST /_blockcache/prune = clear()):
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
            }
        return null;
                Files.exists(metaDir.resolve(KEY_INDEX_FILENAME))
     */
    public void testCleanStartupUsedBytesIsZero() throws Exception {
import org.opensearch.repositories.fs.FsRepository;
        for (NodeStats stats : response.getNodes()) {
     * survives across restarts.
    // ── GR-04: evict_prefix works on recovered keys ───────────────────────────
                foundWarmNode = true;
        // Restart — parse_and_validate() rejects version mismatch → clean startup.
     * Returns the {@link BlockCacheStats} from the first warm node, or {@code null} if absent.
        // GS-02: key_index.json must exist after graceful restart.
            Path candidate = dataPath.resolve("foyer-block-cache");
        assertNotNull("foyer-block-cache directory must exist on warm node after restart", cacheDir);
    private Path findFoyerMetadataCacheDir() {
        Files.writeString(cacheDir.resolve(KEY_INDEX_FILENAME), "{\"version\":999,\"index\":{}}", StandardCharsets.UTF_8);
            30,
     * <p>Specifically queries the warm node's {@link Environment} so that the correct data
        createRepository(repoName, FsRepository.TYPE);
        assertDocCount(indexName + "-copy", 50L);
/*
    private void setupWarmNodeWithIndex(Client client, String indexName) throws Exception {
        if (Files.isDirectory(dataSubdir)) {
     * and writes {@code key_index.json} within the configured interval.
     * Foyer block cache splits into two independent instances under
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
     * GS-01/GS-02: Warm node restart writes {@code key_index.json} on shutdown and the file
                .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.FS.getSettingsKey())
    public void testKeyIndexWrittenOnShutdownAndRecoveredOnRestart() throws Exception {
     * <p>Use {@link #findFoyerMetadataCacheDir()} for the metadata-tier subdir.
        // Overwrite with corrupt JSON while the node is about to restart.
        return List.<Class<? extends Plugin>>of(BlockCacheFoyerPlugin.class);
     * file-level recovery and query correctness, not {@code used_bytes}.
    // ── CL-02/CL-04: Prune (clear) resets cache state ────────────────────────
                "data-tier key_index.json must be written by periodic persist task within interval",
                    return nodeInfo.getNode().getName();
        Path root = findFoyerCacheRoot();
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), new ByteSizeValue(2, ByteSizeUnit.GB).toString())
            "metadata-tier cache directory must exist on warm node after restart "
        String dataContent = Files.readString(dataDir.resolve(KEY_INDEX_FILENAME));
     * PP-01/PP-02/PP-03: key_index.json must appear within the configured persist interval
        boolean foundWarmNode = false;
            metaDir
            }
        return root;                 // single-cache mode
            .put(super.nodeSettings(nodeOrdinal))
        final String indexName = "test-periodic";
        ensureGreen();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
     *   <li>After a subsequent restart, used_bytes is still 0 (clear() deleted the snapshot).</li>
        // Wait for the periodic persist to write key_index.json.
            .cluster()
        setupWarmNodeWithIndex(client, indexName);
                BlockCacheStats blockCacheStats = stats.getBlockCacheOnlyStats();
        final Client client = client();
            .actionGet();
     * Locates the Foyer block cache directory ({@code <data-path>/foyer-block-cache}) on the
        }
        // Wait for key_index.json to appear from periodic persist.
            .setRenamePattern("(.+)")
     * only surface on shutdown.
    /** File names written by key_index_store.rs. Must match the Rust constants. */
        }
 * SPDX-License-Identifier: Apache-2.0
        );
    /**
        assertNotNull("foyer-block-cache directory must exist on warm node after restart", cacheDir);
/**
        for (Path dataPath : environment.dataFiles()) {
import org.opensearch.env.Environment;
        assertFalse(
        Path metaKeyIndex = metaDir.resolve(KEY_INDEX_FILENAME);
        );
        internalCluster().restartNode(getWarmNodeName());
import org.opensearch.common.util.FeatureFlags;
import org.opensearch.action.admin.cluster.blockcache.PruneBlockCacheRequest;
import org.opensearch.action.support.PlainActionFuture;
 *   <li>GR-01/GR-02: key_index.json present after restart; used_bytes &gt; 0 without cold queries</li>
import static org.hamcrest.Matchers.notNullValue;
     * No key_index.json exists before any queries — the cache is empty.
        // Both tiers' content is valid JSON with version=1.
    }
        PlainActionFuture<PruneBlockCacheResponse> future = new PlainActionFuture<>();
        );
 */
        client.execute(PruneBlockCacheAction.INSTANCE, pruneRequest, future);
        BlockCacheStats stats = getWarmNodeBlockCacheStats(client);
     * {@code used_bytes}. A warm node graceful restart always writes {@code key_index.json}
        ensureGreen();
     * appears healthy — the previous helper would only see the data tier and miss
        assertNotNull("foyer-block-cache directory must exist on warm node", cacheDir);
    }
            content.length(),
            Files.exists(cacheDir.resolve(KEY_INDEX_TMP_FILENAME))
        assertDocCount(indexName + "-copy", 50L);
            assertTrue(
    public void testPeriodicPersistWritesKeyIndexWithinInterval() throws Exception {
        setupWarmNodeWithIndex(client, indexName);
        // Cluster healthy after restart.
    // ── GR-03: Cache hits after restart ──────────────────────────────────────
    }
    @Override
     *
        assertNotNull(pruneResponse);
        assertTrue("Block cache should be cleared", nodeResponse.isCleared());
                assertThat("usedBytes must be 0 on clean startup", blockCacheStats.diskBytesUsed(), equalTo(0L));
        assertDocCount(restoredIndexName, 50L);
        // No .tmp file should be left behind.
        // a partial write that left garbage on disk.
        // Cluster must still be healthy.
        assertThat("used_bytes must be 0 after restart following prune (no stale snapshot)", usedAfterRestartPostPrune, equalTo(0L));
        // Write a snapshot with wrong version (999 instead of 1).
    }
        final Client client = client();
        final Client client = client();
        // CL-01: POST /_blockcache/prune
        final String indexName = "test-hits";
        assertNotNull("block_cache stats must be present on warm node", stats);
        // and the cache is healthy.
            "metadata-tier .key_index.json.tmp must not exist after successful rename",
            Files.exists(dataDir.resolve(KEY_INDEX_TMP_FILENAME))
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
     */
     * {@code foyer-block-cache/}, which is what gets returned then.
        assertFalse(".key_index.json.tmp must not exist after successful rename", Files.exists(cacheDir.resolve(KEY_INDEX_TMP_FILENAME)));
        // Delete the remote-snapshot index — this should trigger evict_prefix() for all
 * <ul>
        internalCluster().ensureAtLeastNumWarmNodes(1);
        final String indexName = "test-version";
            for (var nodeInfo : nodesInfoResponse.getNodes()) {
        setupWarmNodeWithIndex(client, indexName);
        String content = Files.readString(cacheDir.resolve(KEY_INDEX_FILENAME));
import java.util.List;
            }
    /**
     */
        final String snapshotName = indexName + "-snap";
        logger.info(
                .build()
        assertTrue("metadata-tier key_index.json must contain version:1", metaContent.contains("\"version\":1"));
        assertThat(snapResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
        }
    }
        long usedAfterWrongVersion = getWarmNodeUsedBytes(client);
 *   <li>VM-01/VM-02: corrupt/wrong-version key_index.json → node starts healthy with empty key_index</li>
 */
            Files.exists(metaDir.resolve(KEY_INDEX_TMP_FILENAME))
            "[PP-02] key_index.json content ({} bytes): {}",
        return s != null ? s.diskBytesUsed() : 0L;
        assertTrue("data-tier key_index.json must exist after restart", Files.exists(dataKeyIndex));
        final String restoredIndexName = indexName + "-copy";
package org.opensearch.blockcache.foyer;
        // Restart warm node — Drop writes key_index.json.
            if (stats.getNode().isWarmNode()) {
            return t.getName().startsWith("index-input-cleaner");
        final Client client = client();
        String[] names = internalCluster().getNodeNames();
        logger.info("[GR-04] deleting index '{}-copy' to trigger evict_prefix()", indexName);
            .prepareRestoreSnapshot(repoName, snapshotName)
     * VM-02: A corrupt key_index.json (invalid JSON) on a warm node's cache dir is
     *
        assertFalse("data-tier key_index.json must not be empty", dataContent.isBlank());
            content.length() > 200 ? content.substring(0, 200) + "…" : content
     * (5 seconds in this test's nodeSettings) after cache population, WITHOUT a node restart.
     * </ol>
        logger.info("[tiered-periodic-01] waiting up to 30s for periodic persist (interval=5s) on data and metadata tiers");
    // ── VM-01/VM-02: Corrupt or wrong-version snapshot → clean startup ────────
        // disabled (diskCapacityBytes = 0) or the directory has not been created yet — both
        String content = Files.readString(cacheDir.resolve(KEY_INDEX_FILENAME));
        ensureGreen();
     *
            metaDir
import static org.hamcrest.Matchers.greaterThan;
     * GR-03: After a warm node restart the key_index.json is written, recovered on the
        assertDocCount(indexName + "-copy", 50L);
    @Override
     * not found — this ensures file-level assertions are never silently skipped.
        assertThat("used_bytes must decrease after index deletion + prune (evict_prefix on recovered keys)", usedAfterEvict, equalTo(0L));
        assertDocCount(indexName + "-copy", 50L);
        indexRandomDocs(indexName, 50);
import org.opensearch.plugins.BlockCacheStats;
            indexName,
 *
                if (nodeInfo.getNode().isWarmNode()) {
        internalCluster().restartNode(getWarmNodeName());
        // VM-04: used_bytes must be 0 (corrupt file treated as clean startup).
        ensureGreen();
     */
import org.opensearch.transport.client.Client;
    }
     * their own {@code key_index.json} on graceful warm-node restart.
        assertTrue("Expected at least one warm node", foundWarmNode);
                assertThat("block_cache stats must be present on warm node", blockCacheStats, notNullValue());
     */
    /**
public class BlockCacheKeyIndexRecoveryIT extends AbstractSnapshotIntegTestCase {
     * (even with an empty key_index) and the node must start healthy afterwards.
    public void testCorruptKeyIndexFileResultsInCleanStartup() throws Exception {
    }
 * this file be licensed under the Apache-2.0 license or a
        );
        logger.info("[VM-01] key_index.json exists; overwriting with version=999 at {}", cacheDir.resolve(KEY_INDEX_FILENAME));
        setupWarmNodeWithIndex(client, indexName);
        // Both tiers wrote a key_index.json.
        client.admin()
        // The persist interval is 5 seconds (set in nodeSettings); we wait up to 30 seconds.
        // Prune to force eviction of any remaining entries.
            return dataSubdir;       // tiered mode
        Path recoveryCheck = findFoyerCacheDir();
 * The OpenSearch Contributors require contributions made to
}
    private Path findFoyerCacheDir() {
        assertDocCount(indexName + "-copy", 50L);
     * a regression where one tier's persistence wiring is broken while the other
     * next startup, and the cluster returns correct query results.
        long usedAfterCorruptRestart = getWarmNodeUsedBytes(client);
import java.nio.charset.StandardCharsets;
                "metadata-tier key_index.json must be written by periodic persist task within interval",
            TimeUnit.SECONDS
        internalCluster().restartNode(getWarmNodeName());
        setupWarmNodeWithIndex(client, indexName);
    }
 * Integration tests for Foyer block cache key_index persistence and recovery.
    protected Settings nodeSettings(int nodeOrdinal) {
        for (NodeStats stats : response.getNodes()) {
        assertDocCount(indexName + "-copy", 50L);
        );
        assertTrue(client.admin().indices().prepareDelete(indexName + "-copy").get().isAcknowledged());
        ensureGreen();
        // No leftover .tmp files after successful rename on either tier.
     * persistence tests therefore verify the key_index file lifecycle rather than
        createIndex(
        assertThat("used_bytes must be 0 after restart with wrong-version key_index.json", usedAfterWrongVersion, equalTo(0L));
        // The cache directory is always created when the Foyer plugin is active on a warm
    /**
        assertTrue("key_index.json must contain version:1", content.contains("\"version\":1"));
        Path root = findFoyerCacheRoot();
    }
     *
        assertThat("used_bytes must be 0 after restart with corrupt key_index.json", usedAfterCorruptRestart, equalTo(0L));
        // cache (only native ts_get/ts_put does). We still verify the prune action completes
        assertBusy(() -> {
                + "(check block_cache.foyer.metadata_cache_ratio is > 0)",
        ensureGreen();
        Path metaDir = findFoyerMetadataCacheDir();
     *
        long usedAfterRestartPostPrune = getWarmNodeUsedBytes(client);
        logger.info("[GR-03] index ready; restarting warm node '{}'", getWarmNodeName());
        long usedAfterEvict = getWarmNodeUsedBytes(client);
            .actionGet();
        // Cluster must be healthy and queries must work (cache fills from scratch).
        Path metaSubdir = root.resolve("metadata");
            if (Files.isDirectory(candidate)) {
                Files.exists(cacheDir.resolve(KEY_INDEX_FILENAME))
     * Sets up a warm node cluster with a remote-snapshot index named {@code indexName + "-copy"}.
            "data-tier .key_index.json.tmp must not exist after successful periodic persist",
        assertFalse(
    // ── GS-01/GS-02: Graceful shutdown persists key_index ────────────────────
     * <p>This verifies the periodic persist task is running and writing to disk proactively,
            Settings.builder()
        assertDocCount(indexName + "-copy", 50L);
        // Query stats immediately — no queries have been run, so used_bytes should be 0.
        ensureGreen();
        assertDocCount(indexName + "-copy", 50L);
    }
        assertTrue(client.admin().indices().prepareDelete(indexName).get().isAcknowledged());
    public static final class IndexInputCleanerFilter implements ThreadFilter {
        final String indexName = "test-evict";
        Path dataDir = findFoyerCacheDir();
        PruneBlockCacheResponse pruneResponse = future.actionGet();
            "metadata-tier cache directory must exist on warm node " + "(check block_cache.foyer.metadata_cache_ratio is > 0)",
    }
        assertEquals("Prune should have no failures", 0, pruneResponse.failures().size());
    /**
        assertEquals("Should target 1 warm node", 1, pruneResponse.getNodes().size());
 * <p>Covers the scenarios from the manual test plan:
        assertDocCount(indexName + "-copy", 50L);
                return stats.getBlockCacheOnlyStats();
        assertBusy(() -> assertTrue(Files.exists(cacheDir.resolve(KEY_INDEX_FILENAME))), 30, TimeUnit.SECONDS);
        assertTrue("key_index.json must exist after graceful warm node restart", Files.exists(cacheDir.resolve(KEY_INDEX_FILENAME)));
    }
import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.equalTo;
        public boolean reject(Thread t) {
    private Path findFoyerCacheRoot() {
    /**
        return names.length > 0 ? names[0] : null;
        internalCluster().ensureAtLeastNumWarmNodes(1);
    public void testPruneClearsUsedBytesAndNextRestartIsEmpty() throws Exception {
            );
        }, 30, TimeUnit.SECONDS);
     * not only on graceful shutdown.
        // Restart the warm node — load_or_empty() must return empty on corrupt JSON.
     *
                "key_index.json must be written by periodic persist task within interval",
        }
        logger.info("[tiered-shutdown-01] restarting warm node '{}'", getWarmNodeName());
 *   <li>GR-03: cache hits (usedBytes still non-zero) after node restart proving recovery worked</li>
        logger.info(
@ThreadLeakFilters(filters = BlockCacheKeyIndexRecoveryIT.IndexInputCleanerFilter.class)
        assertNotNull(
     */
    /**
        ensureGreen();
     */
     * with used_bytes = 0.
    /** Locates the {@code foyer-block-cache} parent directory on the warm node. */
        String warmName = getWarmNodeName();
    }
                Files.exists(dataDir.resolve(KEY_INDEX_FILENAME))
     * the cache is in tiered mode, or {@code null} in single-cache mode.
                .put(SETTING_NUMBER_OF_SHARDS, 1)
        Path dataDir = findFoyerCacheDir();
    /**
    protected Settings.Builder randomRepositorySettings() {
        // used_bytes is 0 because Lucene REMOTE_SNAPSHOT reads do not populate the Foyer block
    public void testTieredBothTiersWriteKeyIndexOnShutdown() throws Exception {
     * Tiered mode: the periodic persist task fires independently on both tiers
     */
            // the security manager that blocks System.getProperty in internalClusterTests).
import com.carrotsearch.randomizedtesting.ThreadFilter;
    /**
        // are unexpected in this test suite and callers must handle null gracefully.
import org.opensearch.common.settings.Settings;
        ensureGreen();
     */
import org.opensearch.action.admin.cluster.blockcache.PruneBlockCacheAction;
     * <p>In tiered mode (default — {@code block_cache.foyer.metadata_cache_ratio > 0})
     * path ({@code ts_get}/{@code ts_put}), not by Lucene REMOTE_SNAPSHOT reads. The
     * warm node.
        if (root == null) {
        logger.warn("foyer-block-cache directory not found under warm node '{}' data paths: {}", warmName, environment.dataFiles());
        );
            .cluster()
        PruneBlockCacheResponse pruneResponse = future.actionGet();
     */
        logger.info("[VM-02] restarting warm node '{}' with corrupt key_index.json", getWarmNodeName());
    @Override
        // cache entries belonging to this index.
import org.opensearch.snapshots.AbstractSnapshotIntegTestCase;
    public void testWrongVersionKeyIndexFileResultsInCleanStartup() throws Exception {
        assertDocCount(restoredIndexName, 50L);
        // Poll for key_index.json to appear (written by the periodic persist task, not Drop).
        assertNotNull("data-tier cache directory must exist on warm node", dataDir);
import org.opensearch.core.common.unit.ByteSizeValue;
        assertFalse(
     *   <li>usedBytes drops to 0 on the warm node.</li>
    }
     * Lucene REMOTE_SNAPSHOT reads do not call {@code put()}. This test therefore verifies
        assertFalse(
        logger.info("[ST-01] warm node '{}' started; querying block_cache stats", getWarmNodeName());
            .put("block_cache.foyer.key_index_persist_interval_seconds", 5)
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
 *   <li>PP-01/PP-02/PP-03: periodic persist task writes key_index.json within the configured interval</li>
        logger.info("[VM-01] restarting warm node '{}' with wrong-version key_index.json", getWarmNodeName());
                }
            .put("location", randomRepoPath())
        // Restart warm node — Drop writes key_index.json; next startup recovers it.
        return Settings.builder()
     * GR-04: After recovery, deleting a remote-snapshot index triggers evict_prefix() for
            .setIndices(indexName)
        assertTrue("metadata-tier key_index.json must exist after restart", Files.exists(metaKeyIndex));
        );
        assertDocCount(indexName + "-copy", 50L);
        Environment environment = internalCluster().getInstance(Environment.class, warmName);
        assertThat("used_bytes must be 0 after prune", usedAfterPrune, equalTo(0L));
    /**
    /**
     * different node ordinals. Fails the test with a descriptive message if the directory is
        try {
            Files.exists(metaDir.resolve(KEY_INDEX_TMP_FILENAME))
        final var snapResponse = client.admin()
 *   <li>GS-01/GS-02: key_index.json written after a warm node restart (graceful shutdown)</li>
        // We write it and then restart immediately — simulates an admin corruption or
        // CL-04: Restart — must start empty (clear() deleted the key_index snapshot).
     * Tiered mode (default): both the data tier and the metadata tier each persist
    // ── Helper methods ────────────────────────────────────────────────────────
     *
        setupWarmNodeWithIndex(client, indexName);
 * </ul>
        internalCluster().restartNode(getWarmNodeName());
    public void testCacheHitsAfterRestartDemonstrateRecovery() throws Exception {
        // Warm node must be healthy and serve queries correctly after recovery.
            .build();
     * <p>With {@code block_cache.foyer.metadata_cache_ratio > 0} (5% by default) the
        // node and diskCapacityBytes > 0. Returning null here means either the plugin was
     * that index's path prefix. usedBytes must decrease after the deletion + prune.
        // Both snapshots are valid JSON with version=1.
     * <p>The Foyer block cache is populated exclusively by the native tiered-object-store
        Path metaDir = findFoyerMetadataCacheDir();
    // ── Tiered-mode coverage ─────────────────────────────────────────────────
    private String getWarmNodeName() {
        logger.info("[VM-02] key_index.json exists; overwriting with corrupt JSON at {}", cacheDir.resolve(KEY_INDEX_FILENAME));
        // Persist interval is 5s (set in nodeSettings); allow up to 30s for both tiers.
        setupWarmNodeWithIndex(client, indexName);
            () -> assertTrue(
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
        // Trigger cache population.
        return false;
            assertTrue(
     * the layout is {@code foyer-block-cache/data/} and {@code foyer-block-cache/metadata/};
     */
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
    /**
        ensureGreen();
        setupWarmNodeWithIndex(client, indexName);
     *
            .cluster()
        // Cluster must be healthy and queries must work.
        assertFalse("key_index.json must not be empty", content.isBlank());
        Path dataSubdir = root.resolve("data");
     */
     * each subdir has its own {@code key_index.json}. This helper returns the data
            .prepareCreateSnapshot(repoName, snapshotName)
        final Client client = client();
import java.nio.file.Files;
            .put("compress", randomBoolean())
     * <p>The Foyer block cache is populated only by the native tiered-object-store path;
            // 2GB is small enough to pass disk validation on any dev/CI machine.
     * Returns 0 if no warm node is found or if block_cache stats are absent.
    private long getWarmNodeUsedBytes(Client client) {
        assertTrue("data-tier key_index.json must contain version:1", dataContent.contains("\"version\":1"));
    private static final String KEY_INDEX_FILENAME = "key_index.json";
     * one tier's task is starved or never spawned — symptoms that would otherwise
        internalCluster().ensureAtLeastNumDataNodes(1);
import org.opensearch.action.admin.cluster.blockcache.NodePruneBlockCacheResponse;
    private BlockCacheStats getWarmNodeBlockCacheStats(Client client) {
        }
        Path cacheDir = findFoyerCacheDir();
        );
     */
    public void testEvictPrefixWorksOnRecoveredKeysAfterRestart() throws Exception {
import java.util.Collection;
 *
     * tier has its own Drop impl writing its own snapshot. This test guards against
import org.opensearch.core.common.unit.ByteSizeUnit;
     */
import org.opensearch.node.Node;
        assertNotNull("foyer-block-cache directory must exist on warm node", cacheDir);
            .put("block_cache.foyer.key_index_sweep_interval_seconds", 0)
                .put(SETTING_NUMBER_OF_REPLICAS, 0)
        assertThat("used_bytes must be 0 after recovery of empty key_index", stats.diskBytesUsed(), equalTo(0L));
            return null;
    }
     * path is used even in a multi-node cluster where the cluster manager and data nodes have
        );
        internalCluster().restartNode(getWarmNodeName());
        Path cacheDir = findFoyerCacheDir();
        return Files.isDirectory(metaSubdir) ? metaSubdir : null;
        // Verify content is valid JSON with non-empty index.
        internalCluster().restartNode(getWarmNodeName());
            );
        // CL-02: usedBytes must be 0 after prune (was already 0; verifies clear() succeeded).
     * Locates the Foyer block cache directory that holds {@code key_index.json}.
            .setWaitForCompletion(true)
        // Queries must still work after restart.
    }
        assertTrue("key_index.json must contain an index object", content.contains("\"index\":{"));
        // GS-01: Restart the warm node — Drop impl writes key_index.json before the JVM exits.
            // Short persist interval so IT tests don't have to wait 60 seconds.
        NodesStatsResponse response = client().admin()
 * compatible open source license.
        PlainActionFuture<PruneBlockCacheResponse> future = new PlainActionFuture<>();
        assertFalse("metadata-tier key_index.json must not be empty", metaContent.isBlank());
    }
        String metaContent = Files.readString(metaKeyIndex);
    }
     * Returns the usedBytes from the first warm node's block_cache stats.
        final String indexName = "test-prune";
     * tolerated — the node starts healthy with used_bytes = 0 and queries work.
        logger.info("[GR-04] index ready; restarting warm node '{}' to trigger recovery", getWarmNodeName());
        String dataContent = Files.readString(dataKeyIndex);
     * Returns the metadata-tier subdir ({@code foyer-block-cache/metadata}) when
        assertThat(snapResponse.getSnapshotInfo().successfulShards(), equalTo(snapResponse.getSnapshotInfo().totalShards()));
        BlockCacheStats s = getWarmNodeBlockCacheStats(client);
        setupWarmNodeWithIndex(client, indexName);
        assertBusy(
        final Client client = client();
import org.opensearch.action.admin.cluster.blockcache.PruneBlockCacheResponse;
            .get();
        client.execute(PruneBlockCacheAction.INSTANCE, new PruneBlockCacheRequest(), future);
import org.opensearch.index.IndexModule;
        // Cluster must be healthy and queries must still work.
        PruneBlockCacheRequest pruneRequest = new PruneBlockCacheRequest();
            ),
    /** Suppresses the JVM Cleaner daemon thread spawned by OnDemandBlockSnapshotIndexInput. */
            "[GS-04] key_index.json content ({} bytes): {}",
        assertTrue("key_index.json must contain version:1", content.contains("\"version\":1"));
 * @opensearch.internal
 *
        assertFalse("key_index.json must not be empty", content.isBlank());
     */
            "metadata-tier .key_index.json.tmp must not exist after successful periodic persist",
        final String indexName = "test-corrupt";
        assertNotNull(
        if (root == null) {
        ensureGreen();
        assertDocCount(indexName + "-copy", 50L);
     * {@code foyer-block-cache/data} and {@code foyer-block-cache/metadata}. Each
            var nodesInfoResponse = client().admin().cluster().prepareNodesInfo().get();
        // No leftover .tmp files on either tier.
     * subdir in that case. In single-cache mode the file lives directly under
        Path dataKeyIndex = dataDir.resolve(KEY_INDEX_FILENAME);
     * ST-01/ST-02: Fresh warm node with no prior cache data starts healthy and has usedBytes=0.
        assertNotNull("foyer-block-cache directory must exist on warm node", cacheDir);
    /**
        assertTrue("metadata-tier key_index.json must contain version:1", metaContent.contains("\"version\":1"));
        // GS-04: content check — key_index.json must be valid JSON with version=1.
     * Creates a snapshot, deletes the original index, and restores it as a remote snapshot.
            .actionGet();
        final String indexName = "test-idx";
        Path cacheDir = findFoyerCacheDir();
     * <ol>
            content.length(),
        long usedBeforePrune = getWarmNodeUsedBytes(client);
        // Cluster must be healthy and warm node must report clean used_bytes = 0.
     * a metadata-tier failure entirely.
        ensureGreen();
 *   <li>GR-04: evict_prefix (shard deletion + prune) reduces usedBytes after recovery</li>
        );
            .nodesStats(new NodesStatsRequest().addMetric(NodesStatsRequest.Metric.FILE_CACHE_STATS.metricName()).fileCacheDetailed(true))
        logger.info("[CL-04] restarting warm node '{}' after prune", getWarmNodeName());
    protected boolean addMockInternalEngine() {
        NodesStatsResponse response = client.admin()
    // ── ST-01: First-ever startup ────────────────────────────────────────────
    /**
        // usedBytes must have decreased (entries for the deleted index were evicted).
    private static final String KEY_INDEX_TMP_FILENAME = ".key_index.json.tmp";
        internalCluster().restartNode(getWarmNodeName());
        // After restart key_index.json must exist on disk.
 *   <li>ST-01: first-ever startup (fresh cache dir) → used_bytes = 0, node healthy</li>
        assertFalse(
        );
    @Override
        ensureGreen();
        assertDocCount(indexName + "-copy", 50L);
import java.nio.file.Path;
        final Client client = client();
     */
        Files.writeString(cacheDir.resolve(KEY_INDEX_FILENAME), "{{{invalid_json}}}", StandardCharsets.UTF_8);
        } catch (Exception ignored) {}
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        final String indexName = "test-tiered-periodic";
 *   <li>CL-02/CL-04: clear() (prune) resets used_bytes to 0; next restart starts empty</li>
            // Disable sweep task — not relevant for persistence ITs and avoids noise.
    public void testTieredBothTiersPeriodicPersistFires() throws Exception {
        assertBusy(() -> assertTrue(Files.exists(cacheDir.resolve(KEY_INDEX_FILENAME))), 30, TimeUnit.SECONDS);
        assertNotNull("data-tier cache directory must exist on warm node after restart", dataDir);
        Path cacheDir = findFoyerCacheDir();
        final String repoName = indexName + "-repo";
    // ── PP-01/PP-02/PP-03: Periodic persist ──────────────────────────────────
import org.opensearch.plugins.Plugin;
     * VM-01: A wrong-version key_index.json is rejected on startup — node starts healthy
            .setRenameReplacement("$1-copy")
            .setWaitForCompletion(true)
        final Client client = client();
        final Client client = client();
        NodePruneBlockCacheResponse nodeResponse = pruneResponse.getNodes().get(0);
            .cluster()
        assertTrue("data-tier key_index.json must contain version:1", dataContent.contains("\"version\":1"));
            }
    }
        ensureGreen();
        assertTrue("key_index.json must exist after restart", Files.exists(cacheDir.resolve(KEY_INDEX_FILENAME)));
