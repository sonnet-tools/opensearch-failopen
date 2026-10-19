    }  
    protected Settings nodeSettings(int nodeOrdinal) {
     * Locates the Foyer block cache directory ({@code <data-path>/foyer-block-cache}) on the  
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)  
        assertDocCount(restoredIndexName, 50L);
     * appears healthy — the previous helper would only see the data tier and miss
            metaDir  
            TimeUnit.SECONDS
}
        indexRandomDocs(indexName, 50);  
 * compatible open source license.
        Path cacheDir = findFoyerCacheDir();
            .put("location", randomRepoPath())
        assertDocCount(indexName + "-copy", 50L);  
        logger.info("[tiered-periodic-01] waiting up to 30s for periodic persist (interval=5s) on data and metadata tiers");  
@ThreadLeakFilters(filters = BlockCacheKeyIndexRecoveryIT.IndexInputCleanerFilter.class)
        );
        // Verify content is valid JSON with non-empty index.  
            content.length() > 200 ? content.substring(0, 200) + "…" : content  
     */  
    private Path findFoyerCacheRoot() {  
    public void testCleanStartupUsedBytesIsZero() throws Exception {  
    private Path findFoyerMetadataCacheDir() {
        for (Path dataPath : environment.dataFiles()) {
 *   <li>PP-01/PP-02/PP-03: periodic persist task writes key_index.json within the configured interval</li>
        }
    public void testWrongVersionKeyIndexFileResultsInCleanStartup() throws Exception {
        }
        // Cluster healthy after restart.  
        // Poll for key_index.json to appear (written by the periodic persist task, not Drop).  
        assertEquals("Prune should have no failures", 0, pruneResponse.failures().size());  
        String content = Files.readString(cacheDir.resolve(KEY_INDEX_FILENAME));
            ".key_index.json.tmp must not exist after successful periodic persist",  
    }
     * Tiered mode: the periodic persist task fires independently on both tiers
        }, 30, TimeUnit.SECONDS);  
    public void testPeriodicPersistWritesKeyIndexWithinInterval() throws Exception {
        );
        // CL-02: usedBytes must be 0 after prune (was already 0; verifies clear() succeeded).
        // Warm node must be healthy and serve queries correctly after recovery.
            .actionGet();
        final Client client = client();  
 * Integration tests for Foyer block cache key_index persistence and recovery.
            .get();  
            if (stats.getNode().isWarmNode()) {
     * the cache is in tiered mode, or {@code null} in single-cache mode.  
    public void testPruneClearsUsedBytesAndNextRestartIsEmpty() throws Exception {
            .put("block_cache.foyer.key_index_persist_interval_seconds", 5)
    private Path findFoyerCacheDir() {
                return candidate;
     * tolerated — the node starts healthy with used_bytes = 0 and queries work.
        internalCluster().restartNode(getWarmNodeName());
        setupWarmNodeWithIndex(client, indexName);  
    }
        final String indexName = "test-prune";
            Path candidate = dataPath.resolve("foyer-block-cache");  
        // key_index.json must exist after restart.
    /** File names written by key_index_store.rs. Must match the Rust constants. */
        assertFalse("key_index.json must not be empty", content.isBlank());
        // Restart warm node — Drop writes key_index.json.  
        }  
        } catch (Exception ignored) {}
        );
        PruneBlockCacheRequest pruneRequest = new PruneBlockCacheRequest();  
     * persistence tests therefore verify the key_index file lifecycle rather than
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;  
        assertDocCount(indexName + "-copy", 50L);  
/**  
        assertTrue("key_index.json must contain an index object", content.contains("\"index\":{"));
     * <p>Each tier owns its own persist task, so this test catches the case where
        }
            .cluster()
    }  
        assertEquals("Prune should have no failures", 0, pruneResponse.failures().size());
        PlainActionFuture<PruneBlockCacheResponse> future = new PlainActionFuture<>();
    }  
        // Cluster must be healthy and warm node must report clean used_bytes = 0.  
        Files.writeString(cacheDir.resolve(KEY_INDEX_FILENAME), "{{{invalid_json}}}", StandardCharsets.UTF_8);
        String dataContent = Files.readString(dataDir.resolve(KEY_INDEX_FILENAME));
    @Override
        Path metaDir = findFoyerMetadataCacheDir();
    }  
            .put(super.nodeSettings(nodeOrdinal))  
     * No key_index.json exists before any queries — the cache is empty.
                + "(check block_cache.foyer.metadata_cache_ratio is > 0)",
        logger.info("[GR-03] index ready; restarting warm node '{}'", getWarmNodeName());
        setupWarmNodeWithIndex(client, indexName);  
        PruneBlockCacheResponse pruneResponse = future.actionGet();
        // are unexpected in this test suite and callers must handle null gracefully.  
        assertTrue(client.admin().indices().prepareDelete(indexName).get().isAcknowledged());
                .put(SETTING_NUMBER_OF_SHARDS, 1)
        assertTrue("metadata-tier key_index.json must exist after restart", Files.exists(metaKeyIndex));
        createRepository(repoName, FsRepository.TYPE);  
        return Files.isDirectory(metaSubdir) ? metaSubdir : null;
            .nodesStats(new NodesStatsRequest().addMetric(NodesStatsRequest.Metric.FILE_CACHE_STATS.metricName()).fileCacheDetailed(true))
            metaDir  
        return Settings.builder()
    }  
        assertTrue("key_index.json must exist after recovery", Files.exists(recoveryCheck.resolve(KEY_INDEX_FILENAME)));
        assertThat("used_bytes must be 0 after prune", usedAfterPrune, equalTo(0L));  
    /**
        String dataContent = Files.readString(dataKeyIndex);
        if (root == null) {  
        assertDocCount(indexName + "-copy", 50L);  
import static org.hamcrest.Matchers.equalTo;
            ),
    }
        assertTrue("data-tier key_index.json must contain version:1", dataContent.contains("\"version\":1"));  
            }
        );
     * path is used even in a multi-node cluster where the cluster manager and data nodes have
     * GS-01/GS-02: Warm node restart writes {@code key_index.json} on shutdown and the file
     */
        Path recoveryCheck = findFoyerCacheDir();
            .put("compress", randomBoolean())
     *
        // Restart the warm node — load_or_empty() must return empty on corrupt JSON.
        assertEquals("Should target 1 warm node", 1, pruneResponse.getNodes().size());  
     * their own {@code key_index.json} on graceful warm-node restart.  
        assertTrue("key_index.json must exist after graceful warm node restart", Files.exists(cacheDir.resolve(KEY_INDEX_FILENAME)));
        // Cluster must be healthy and queries must still work.
    }
 * SPDX-License-Identifier: Apache-2.0
        // The persist interval is 5 seconds (set in nodeSettings); we wait up to 30 seconds.
        logger.info("[VM-01] restarting warm node '{}' with wrong-version key_index.json", getWarmNodeName());
    /**
        );
import static org.hamcrest.Matchers.greaterThan;  
import java.util.Collection;
     * survives across restarts.  
                Files.exists(dataDir.resolve(KEY_INDEX_FILENAME))  
            .cluster()  
    public void testEvictPrefixWorksOnRecoveredKeysAfterRestart() throws Exception {
        final Client client = client();
     */
        setupWarmNodeWithIndex(client, indexName);
        ensureGreen();  
import org.opensearch.common.util.FeatureFlags;
    /**
 *
    /**
            var nodesInfoResponse = client().admin().cluster().prepareNodesInfo().get();
        if (root == null) {
        assertThat("used_bytes must be 0 after recovery of empty key_index", stats.diskBytesUsed(), equalTo(0L));  
        // used_bytes is 0 because Lucene REMOTE_SNAPSHOT reads do not populate the Foyer block
            // 2GB is small enough to pass disk validation on any dev/CI machine.
        assertFalse(  
        // Cluster must be healthy and queries must work (cache fills from scratch).  
        // Cluster must still be healthy.  
        assertTrue("key_index.json must contain version:1", content.contains("\"version\":1"));  
        final String indexName = "test-hits";  
            }  
    // ── Tiered-mode coverage ─────────────────────────────────────────────────
     * a regression where one tier's persistence wiring is broken while the other  
     * one tier's task is starved or never spawned — symptoms that would otherwise  
    // ── VM-01/VM-02: Corrupt or wrong-version snapshot → clean startup ────────
        logger.info("[CL-04] restarting warm node '{}' after prune", getWarmNodeName());  
     *
        // Both snapshots are valid JSON with version=1.
            "data-tier .key_index.json.tmp must not exist after successful rename",
                }  
    }
import java.nio.file.Path;
        assertThat(snapResponse.getSnapshotInfo().successfulShards(), equalTo(snapResponse.getSnapshotInfo().totalShards()));
        assertDocCount(restoredIndexName, 50L);  
            "metadata-tier cache directory must exist on warm node after restart "
        PlainActionFuture<PruneBlockCacheResponse> future = new PlainActionFuture<>();  
            .prepareRestoreSnapshot(repoName, snapshotName)
import org.opensearch.action.admin.cluster.blockcache.NodePruneBlockCacheResponse;
    /**
     * <p>In tiered mode (default — {@code block_cache.foyer.metadata_cache_ratio > 0})
     *   <li>usedBytes drops to 0 on the warm node.</li>
        logger.info("[GR-04] index ready; restarting warm node '{}' to trigger recovery", getWarmNodeName());
     *
        final String indexName = "test-version";
        public boolean reject(Thread t) {
     */
 *   <li>VM-01/VM-02: corrupt/wrong-version key_index.json → node starts healthy with empty key_index</li>
        logger.info("[VM-01] key_index.json exists; overwriting with version=999 at {}", cacheDir.resolve(KEY_INDEX_FILENAME));
     * tier has its own Drop impl writing its own snapshot. This test guards against
        long usedAfterCorruptRestart = getWarmNodeUsedBytes(client);  
 * </ul>
    /**
        // Both tiers' content is valid JSON with version=1.  
        internalCluster().restartNode(getWarmNodeName());  
     * (5 seconds in this test's nodeSettings) after cache population, WITHOUT a node restart.  
    public void testKeyIndexWrittenOnShutdownAndRecoveredOnRestart() throws Exception {
            content.length(),  
    @Override
        ensureGreen();  
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
            "[GS-04] key_index.json content ({} bytes): {}",
     * <p>The Foyer block cache is populated exclusively by the native tiered-object-store
    /** Suppresses the JVM Cleaner daemon thread spawned by OnDemandBlockSnapshotIndexInput. */
        // a partial write that left garbage on disk.
     * {@code used_bytes}. A warm node graceful restart always writes {@code key_index.json}
    @Override
        for (NodeStats stats : response.getNodes()) {  
        // CL-01: POST /_blockcache/prune
        assertFalse(".key_index.json.tmp must not exist after successful rename", Files.exists(cacheDir.resolve(KEY_INDEX_TMP_FILENAME)));  
import org.opensearch.plugins.BlockCacheStats;
        assertTrue("metadata-tier key_index.json must contain version:1", metaContent.contains("\"version\":1"));
        final Client client = client();  
        internalCluster().restartNode(getWarmNodeName());  
        assertNotNull("foyer-block-cache directory must exist on warm node after restart", recoveryCheck);  
        assertThat("used_bytes must be 0 after restart with corrupt key_index.json", usedAfterCorruptRestart, equalTo(0L));
        Path dataSubdir = root.resolve("data");  
        ensureGreen();  
        ensureGreen();
    /**
     */
    // ── GR-04: evict_prefix works on recovered keys ───────────────────────────
        Path cacheDir = findFoyerCacheDir();
    }  
     * Returns the usedBytes from the first warm node's block_cache stats.  
        if (Files.isDirectory(dataSubdir)) {
        ensureGreen();
        return List.<Class<? extends Plugin>>of(BlockCacheFoyerPlugin.class);
        // CL-04: Restart — must start empty (clear() deleted the key_index snapshot).
import org.opensearch.action.admin.cluster.blockcache.PruneBlockCacheAction;
    }
import org.opensearch.node.Node;
        // cache (only native ts_get/ts_put does). We still verify the prune action completes  
    }
package org.opensearch.blockcache.foyer;
    }
        final Client client = client();
            Settings.builder()
                    return nodeInfo.getNode().getName();
        return null;
        final Client client = client();  
            .actionGet();  
        final String snapshotName = indexName + "-snap";  
        assertBusy(() -> assertTrue(Files.exists(cacheDir.resolve(KEY_INDEX_FILENAME))), 30, TimeUnit.SECONDS);
        }
    /**
 *   <li>GS-01/GS-02: key_index.json written after a warm node restart (graceful shutdown)</li>
        assertDocCount(indexName + "-copy", 50L);
    /**
            assertTrue(
 *   <li>CL-02/CL-04: clear() (prune) resets used_bytes to 0; next restart starts empty</li>  
    /**
     * a metadata-tier failure entirely.
        assertNotNull("foyer-block-cache directory must exist on warm node", cacheDir);
        assertDocCount(indexName + "-copy", 50L);
        assertNotNull("foyer-block-cache directory must exist on warm node after restart", cacheDir);
     * Lucene REMOTE_SNAPSHOT reads do not call {@code put()}. This test therefore verifies
     * different node ordinals. Fails the test with a descriptive message if the directory is
     */  
                "key_index.json must be written by periodic persist task within interval",  
                Files.exists(cacheDir.resolve(KEY_INDEX_FILENAME))
        logger.info(  
            .nodesStats(new NodesStatsRequest().addMetric(NodesStatsRequest.Metric.FILE_CACHE_STATS.metricName()).fileCacheDetailed(true))
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), new ByteSizeValue(2, ByteSizeUnit.GB).toString())
    }
    /**
        assertThat(snapResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
    private BlockCacheStats getWarmNodeBlockCacheStats(Client client) {
                if (nodeInfo.getNode().isWarmNode()) {
import java.util.List;  
     * each subdir has its own {@code key_index.json}. This helper returns the data
        logger.info("[GS-01] index '{}' restored to warm node; restarting warm node '{}'", restoredIndexName, getWarmNodeName());  
    protected boolean addMockInternalEngine() {
        final String indexName = "test-evict";
        // Both tiers wrote a key_index.json.  
            content.length(),
    /**
     * GR-04: After recovery, deleting a remote-snapshot index triggers evict_prefix() for
        // node and diskCapacityBytes > 0. Returning null here means either the plugin was
        return false;  
     * <p>The Foyer block cache is populated only by the native tiered-object-store path;  
 */  
        // After restart key_index.json must exist on disk.  
        internalCluster().restartNode(getWarmNodeName());
            .actionGet();
import java.nio.file.Files;  
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
     *
        // Wait for the periodic persist to write key_index.json.
            .setRenamePattern("(.+)")
     *   <li>After a subsequent restart, used_bytes is still 0 (clear() deleted the snapshot).</li>
            .cluster()
        Environment environment = internalCluster().getInstance(Environment.class, warmName);
        );
        for (NodeStats stats : response.getNodes()) {  
        Path metaDir = findFoyerMetadataCacheDir();
        );
    }
        assertThat("used_bytes must be 0 after restart with wrong-version key_index.json", usedAfterWrongVersion, equalTo(0L));
        logger.info("[VM-02] key_index.json exists; overwriting with corrupt JSON at {}", cacheDir.resolve(KEY_INDEX_FILENAME));  
                assertThat("usedBytes must be 0 on clean startup", blockCacheStats.diskBytesUsed(), equalTo(0L));
     * <ol>  
 *
     * and writes {@code key_index.json} within the configured interval.  
    /** Locates the {@code foyer-block-cache} parent directory on the warm node. */
    public void testTieredBothTiersWriteKeyIndexOnShutdown() throws Exception {
            "data-tier .key_index.json.tmp must not exist after successful periodic persist",
            .setStorageType(RestoreSnapshotRequest.StorageType.REMOTE_SNAPSHOT)
            }  
        client.execute(PruneBlockCacheAction.INSTANCE, pruneRequest, future);
        // GS-01: Restart the warm node — Drop impl writes key_index.json before the JVM exits.
                return stats.getBlockCacheOnlyStats();
        // Prune to force eviction of any remaining entries.
     */
            );
            Files.exists(metaDir.resolve(KEY_INDEX_TMP_FILENAME))
        Path cacheDir = findFoyerCacheDir();  
     * CL-02/CL-04: After a prune (POST /_blockcache/prune = clear()):
     * only surface on shutdown.
        internalCluster().restartNode(getWarmNodeName());
     * not only on graceful shutdown.  
        assertFalse(
        assertThat("used_bytes must decrease after index deletion + prune (evict_prefix on recovered keys)", usedAfterEvict, equalTo(0L));
        setupWarmNodeWithIndex(client, indexName);  
        return null;
            "[PP-02] key_index.json content ({} bytes): {}",
     *
     * not found — this ensures file-level assertions are never silently skipped.  
    /**  
        String[] names = internalCluster().getNodeNames();  
        Path root = findFoyerCacheRoot();  
            Files.exists(metaDir.resolve(KEY_INDEX_TMP_FILENAME))  
    /**
     * {@code foyer-block-cache/}, which is what gets returned then.  
            .put(FsRepository.BASE_PATH_SETTING.getKey(), "key_index_recovery_it");  
        assertFalse(
        setupWarmNodeWithIndex(client, indexName);
            // the security manager that blocks System.getProperty in internalClusterTests).
        ensureGreen();
        assertDocCount(indexName + "-copy", 50L);
        assertNotNull("data-tier cache directory must exist on warm node", dataDir);  
                .put(SETTING_NUMBER_OF_REPLICAS, 0)  
     * GR-03: After a warm node restart the key_index.json is written, recovered on the  
            );
 * this file be licensed under the Apache-2.0 license or a
                "metadata-tier key_index.json must be written by periodic persist task within interval",  
        String warmName = getWarmNodeName();
    public void testCacheHitsAfterRestartDemonstrateRecovery() throws Exception {
    }  
        final var snapResponse = client.admin()
        client.execute(PruneBlockCacheAction.INSTANCE, new PruneBlockCacheRequest(), future);
        ensureGreen();
 * @opensearch.internal  
        // and the cache is healthy.
            content.length() > 200 ? content.substring(0, 200) + "…" : content
            assertTrue(
            "metadata-tier cache directory must exist on warm node " + "(check block_cache.foyer.metadata_cache_ratio is > 0)",
            if (stats.getNode().isWarmNode()) {
    /**  
        assertNotNull(pruneResponse);
        // Cluster must be healthy and queries must work.
 * <p>Covers the scenarios from the manual test plan:  
        ensureGreen();
        boolean foundWarmNode = false;
    private String getWarmNodeName() {  
            return t.getName().startsWith("index-input-cleaner");  
     * warm node.
    }  
        logger.info("[ST-01] warm node '{}' started; querying block_cache stats", getWarmNodeName());  
        final Client client = client();  
        // No leftover .tmp files after successful rename on either tier.
 *   <li>GR-01/GR-02: key_index.json present after restart; used_bytes &gt; 0 without cold queries</li>  
                "data-tier key_index.json must be written by periodic persist task within interval",
        assertFalse("metadata-tier key_index.json must not be empty", metaContent.isBlank());
        // Overwrite with corrupt JSON while the node is about to restart.
        // Delete the remote-snapshot index — this should trigger evict_prefix() for all
        long usedAfterWrongVersion = getWarmNodeUsedBytes(client);
    private long getWarmNodeUsedBytes(Client client) {  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
    // ── ST-01: First-ever startup ────────────────────────────────────────────  
        );
        assertTrue("metadata-tier key_index.json must contain version:1", metaContent.contains("\"version\":1"));
        ensureGreen();
     * with used_bytes = 0.  
    // ── CL-02/CL-04: Prune (clear) resets cache state ────────────────────────
    }  
        // disabled (diskCapacityBytes = 0) or the directory has not been created yet — both
        assertTrue(client.admin().indices().prepareDelete(indexName + "-copy").get().isAcknowledged());
    /**
 *   <li>GR-04: evict_prefix (shard deletion + prune) reduces usedBytes after recovery</li>
    public void testCorruptKeyIndexFileResultsInCleanStartup() throws Exception {
import org.opensearch.common.settings.Settings;
     * Sets up a warm node cluster with a remote-snapshot index named {@code indexName + "-copy"}.
        // Query stats immediately — no queries have been run, so used_bytes should be 0.
        internalCluster().ensureAtLeastNumWarmNodes(1);
        assertNotNull("data-tier cache directory must exist on warm node after restart", dataDir);
        assertBusy(() -> assertTrue(Files.exists(cacheDir.resolve(KEY_INDEX_FILENAME))), 30, TimeUnit.SECONDS);  
     * <p>Specifically queries the warm node's {@link Environment} so that the correct data  
        BlockCacheStats s = getWarmNodeBlockCacheStats(client);
        setupWarmNodeWithIndex(client, indexName);  
        // Queries must still work after restart.
 *   <li>GR-03: cache hits (usedBytes still non-zero) after node restart proving recovery worked</li>
        return s != null ? s.diskBytesUsed() : 0L;
        String metaContent = Files.readString(metaDir.resolve(KEY_INDEX_FILENAME));
import org.opensearch.snapshots.AbstractSnapshotIntegTestCase;
                .build()  
     * </ol>  
        return root;                 // single-cache mode
        Path cacheDir = findFoyerCacheDir();  
     * Tiered mode (default): both the data tier and the metadata tier each persist
        assertDocCount(indexName + "-copy", 50L);
            .setWaitForCompletion(true)
        @Override
        assertDocCount(indexName + "-copy", 50L);
import org.opensearch.plugins.Plugin;  
            Files.exists(dataDir.resolve(KEY_INDEX_TMP_FILENAME))
        Files.writeString(cacheDir.resolve(KEY_INDEX_FILENAME), "{\"version\":999,\"index\":{}}", StandardCharsets.UTF_8);
import org.opensearch.action.admin.cluster.blockcache.PruneBlockCacheResponse;
     */
                BlockCacheStats blockCacheStats = stats.getBlockCacheOnlyStats();  
        // VM-04: used_bytes must be 0 (corrupt file treated as clean startup).
        long usedBeforePrune = getWarmNodeUsedBytes(client);
import org.opensearch.core.common.unit.ByteSizeUnit;  
            .build();
 *   <li>ST-01: first-ever startup (fresh cache dir) → used_bytes = 0, node healthy</li>  
        );
        NodePruneBlockCacheResponse nodeResponse = pruneResponse.getNodes().get(0);
     * <p>With {@code block_cache.foyer.metadata_cache_ratio > 0} (5% by default) the
     * Foyer block cache splits into two independent instances under  
     * file-level recovery and query correctness, not {@code used_bytes}.
        final String indexName = "test-tiered-shutdown";  
        assertNotNull(  
     */
        }
    }
        assertThat("used_bytes must be 0 after restart following prune (no stale snapshot)", usedAfterRestartPostPrune, equalTo(0L));
            .setIndices(indexName)
        logger.warn("foyer-block-cache directory not found under warm node '{}' data paths: {}", warmName, environment.dataFiles());
    // ── GS-01/GS-02: Graceful shutdown persists key_index ────────────────────
/*  
        setupWarmNodeWithIndex(client, indexName);
        final Client client = client();  
     * Returns 0 if no warm node is found or if block_cache stats are absent.
     * Locates the Foyer block cache directory that holds {@code key_index.json}.  
                Files.exists(metaDir.resolve(KEY_INDEX_FILENAME))
     *
     * subdir in that case. In single-cache mode the file lives directly under
import org.opensearch.action.admin.cluster.blockcache.PruneBlockCacheRequest;  
        assertBusy(() -> {  
            "metadata-tier .key_index.json.tmp must not exist after successful rename",  
        long usedAfterRestartPostPrune = getWarmNodeUsedBytes(client);
        long usedAfterEvict = getWarmNodeUsedBytes(client);  
     */
        String metaContent = Files.readString(metaKeyIndex);  
            // Disable sweep task — not relevant for persistence ITs and avoids noise.
     *
    protected Settings.Builder randomRepositorySettings() {
        Path root = findFoyerCacheRoot();
        assertNotNull(
import java.util.concurrent.TimeUnit;
 * <ul>
        // We write it and then restart immediately — simulates an admin corruption or  
        assertFalse(
        assertTrue("Block cache should be cleared", nodeResponse.isCleared());
        internalCluster().restartNode(getWarmNodeName());  
        // Persist interval is 5s (set in nodeSettings); allow up to 30s for both tiers.
        Path metaKeyIndex = metaDir.resolve(KEY_INDEX_FILENAME);
    }  
     * <p>This verifies the periodic persist task is running and writing to disk proactively,
        // Trigger cache population.
        // cache entries belonging to this index.  
            .cluster()  
            .prepareCreateSnapshot(repoName, snapshotName)  
import org.opensearch.action.support.PlainActionFuture;  
        internalCluster().restartNode(getWarmNodeName());
        assertTrue("key_index.json must contain version:1", content.contains("\"version\":1"));
        return names.length > 0 ? names[0] : null;
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
 */
        // Write a snapshot with wrong version (999 instead of 1).  
                .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.FS.getSettingsKey())
        ensureGreen();
            .execute()  
        ensureGreen();
import java.nio.charset.StandardCharsets;
    /** Returns the name of the first warm node in the cluster. Falls back to a random node. */
        // GS-04: content check — key_index.json must be valid JSON with version=1.
            .setRenameReplacement("$1-copy")  
     * (even with an empty key_index) and the node must start healthy afterwards.  
        assertNotNull("A warm node must be present in the cluster", warmName);
        assertTrue("data-tier key_index.json must exist after restart", Files.exists(dataKeyIndex));  
     * VM-01: A wrong-version key_index.json is rejected on startup — node starts healthy
        final String restoredIndexName = indexName + "-copy";
        final Client client = client();
public class BlockCacheKeyIndexRecoveryIT extends AbstractSnapshotIntegTestCase {  
        }  
     */  
        PruneBlockCacheResponse pruneResponse = future.actionGet();  
    private static final String KEY_INDEX_FILENAME = "key_index.json";
            }  
        client.admin()
    }
        assertFalse("key_index.json must not be empty", content.isBlank());  
import com.carrotsearch.randomizedtesting.ThreadFilter;
import org.opensearch.env.Environment;
     * PP-01/PP-02/PP-03: key_index.json must appear within the configured persist interval
        logger.info("[tiered-shutdown-01] restarting warm node '{}'", getWarmNodeName());
     */  
    // ── Helper methods ────────────────────────────────────────────────────────
    private void setupWarmNodeWithIndex(Client client, String indexName) throws Exception {
     * the layout is {@code foyer-block-cache/data/} and {@code foyer-block-cache/metadata/};  
        final String indexName = "test-tiered-periodic";
     * path ({@code ts_get}/{@code ts_put}), not by Lucene REMOTE_SNAPSHOT reads. The  
        createIndex(  
import org.opensearch.repositories.fs.FsRepository;
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
        BlockCacheStats stats = getWarmNodeBlockCacheStats(client);
import org.opensearch.index.IndexModule;  
     * VM-02: A corrupt key_index.json (invalid JSON) on a warm node's cache dir is
        logger.info("[PP-01] index ready; waiting up to 30s for periodic persist (interval=5s) to write key_index.json");
        assertDocCount(indexName + "-copy", 50L);
            Files.exists(dataDir.resolve(KEY_INDEX_TMP_FILENAME))  
            Files.exists(cacheDir.resolve(KEY_INDEX_TMP_FILENAME))
        internalCluster().ensureAtLeastNumWarmNodes(1);
        NodesStatsResponse response = client.admin()
        assertTrue("data-tier key_index.json must contain version:1", dataContent.contains("\"version\":1"));  
        NodesStatsResponse response = client().admin()  
     * next startup, and the cluster returns correct query results.
        // usedBytes must have decreased (entries for the deleted index were evicted).
        assertDocCount(indexName + "-copy", 50L);  
            "metadata-tier .key_index.json.tmp must not exist after successful periodic persist",
import org.opensearch.transport.client.Client;  
            () -> assertTrue(
        assertDocCount(indexName + "-copy", 50L);
    public void testTieredBothTiersPeriodicPersistFires() throws Exception {  
 *
        Path dataDir = findFoyerCacheDir();  
        // Wait for key_index.json to appear from periodic persist.
     */
        final String repoName = indexName + "-repo";
            // Enable Foyer via node settings (FeatureFlags.initFromSettings bypasses
            .put("block_cache.foyer.key_index_sweep_interval_seconds", 0)  
        );  
        // No .tmp file should be left behind.
        Path dataKeyIndex = dataDir.resolve(KEY_INDEX_FILENAME);
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
                foundWarmNode = true;
        Path dataDir = findFoyerCacheDir();
        assertDocCount(indexName + "-copy", 50L);
                assertThat("block_cache stats must be present on warm node", blockCacheStats, notNullValue());
        ensureGreen();
        return Settings.builder()  
            return null;
        assertNotNull("foyer-block-cache directory must exist on warm node after restart", cacheDir);
        // The cache directory is always created when the Foyer plugin is active on a warm  
        String content = Files.readString(cacheDir.resolve(KEY_INDEX_FILENAME));
        assertNotNull("block_cache stats must be present on warm node", stats);
            30,  
        final String indexName = "test-periodic";
     * Returns the {@link BlockCacheStats} from the first warm node, or {@code null} if absent.
            return null;
     * ST-01/ST-02: Fresh warm node with no prior cache data starts healthy and has usedBytes=0.  
        Path cacheDir = findFoyerCacheDir();  
     * Creates a snapshot, deletes the original index, and restores it as a remote snapshot.
        ensureGreen();
        assertBusy(
        // Restart warm node — Drop writes key_index.json; next startup recovers it.
            return dataSubdir;       // tiered mode
        final String indexName = "test-corrupt";  
        assertFalse("data-tier key_index.json must not be empty", dataContent.isBlank());
        // No leftover .tmp files on either tier.  
        assertFalse(
import org.opensearch.core.common.unit.ByteSizeValue;
        try {
     * that index's path prefix. usedBytes must decrease after the deletion + prune.  
        assertNotNull("foyer-block-cache directory must exist on warm node", cacheDir);
        final String indexName = "test-idx";
        logger.info(
        final Client client = client();
    public static final class IndexInputCleanerFilter implements ThreadFilter {  
            for (var nodeInfo : nodesInfoResponse.getNodes()) {  
    private static final String KEY_INDEX_TMP_FILENAME = ".key_index.json.tmp";  
    // ── PP-01/PP-02/PP-03: Periodic persist ──────────────────────────────────
        // Restart — parse_and_validate() rejects version mismatch → clean startup.  
        assertTrue("Expected at least one warm node", foundWarmNode);
        assertDocCount(indexName + "-copy", 50L);
        assertNotNull("foyer-block-cache directory must exist on warm node", cacheDir);  
        logger.info("[GR-04] deleting index '{}-copy' to trigger evict_prefix()", indexName);
     */  
        );
 * The OpenSearch Contributors require contributions made to  
     *
        long usedAfterPrune = getWarmNodeUsedBytes(client);
            .setWaitForCompletion(true)
        Path metaSubdir = root.resolve("metadata");
     * <p>Use {@link #findFoyerMetadataCacheDir()} for the metadata-tier subdir.
        setupWarmNodeWithIndex(client, indexName);
            indexName,
        assertTrue("key_index.json must exist after restart", Files.exists(cacheDir.resolve(KEY_INDEX_FILENAME)));  
            if (Files.isDirectory(candidate)) {
import static org.hamcrest.Matchers.notNullValue;
            // Short persist interval so IT tests don't have to wait 60 seconds.  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;  
     */  
     * {@code foyer-block-cache/data} and {@code foyer-block-cache/metadata}. Each
        // GS-02: key_index.json must exist after graceful restart.
        ensureGreen();
        internalCluster().ensureAtLeastNumDataNodes(1);
     */
        setupWarmNodeWithIndex(client, indexName);
        logger.info("[VM-02] restarting warm node '{}' with corrupt key_index.json", getWarmNodeName());
    @Override  
     * Returns the metadata-tier subdir ({@code foyer-block-cache/metadata}) when
    // ── GR-03: Cache hits after restart ──────────────────────────────────────  
