import java.util.Collection;
    // Helpers: index settings & indexing
                .indices()
        }
        // allocator, so inject it everywhere.
import org.opensearch.plugins.Plugin;
            .prepareCreate(INDEX_NAME)
        }
        ForceMergeResponse response = client().admin().indices().prepareForceMerge(INDEX_NAME).setMaxNumSegments(1).setFlush(true).get();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        // Force merge to a single segment. The 2-byte merge pool rejects the native merge's
                + " shardFailures="
package org.opensearch.composite;
     * With the same 2-byte merge pool but the over-commit fallback enabled and node native-memory
        ensureGreen(INDEX_NAME);
    // ══════════════════════════════════════════════════════════════════════
        // row-id mapping reservation, so the merge fails. The failure surfaces either as a
        String nodeName = getClusterState().nodes().get(nodeId).getName();
            ForceMergeResponse response = client().admin()
        indexAndRefresh(10);
public class CompositeMergePoolExhaustionIT extends OpenSearchIntegTestCase {
     */
            .indices()
    }
        assertEquals(RestStatus.OK, refreshResponse.getStatus());
    // Helpers: shard/catalog accessors
            "force merge should fail when native pressure exceeds the over-commit threshold; detail=" + failureDetail,
import org.opensearch.be.datafusion.DataFusionPlugin;
    private int getSegmentCount() throws IOException {
 *
    // ══════════════════════════════════════════════════════════════════════
    }
        indexAndRefresh(10);
        assertTrue("force merge should fail when the merge pool is exhausted; detail=" + failureDetail, forceMergeFailed);
import org.opensearch.core.rest.RestStatus;
        } catch (Exception e) {
            DataFusionPlugin.class
import org.opensearch.cluster.metadata.IndexMetadata;
            .prepareUpdateSettings()
 * <p>The native merge reserves its row-id mapping ({@code total_rows * 8} bytes) from the
        String failureDetail;
            if (forceMergeFailed) {
            forceMergeFailed = response.getFailedShards() >= 1 && response.getSuccessfulShards() == 0;
        // Drive native-memory pressure above the threshold on every node's allocator. The pressure
 * (parquet primary + lucene secondary).
            .setSettings(compositeSettings())
    // ══════════════════════════════════════════════════════════════════════
            LucenePlugin.class,
        client().admin()
import org.opensearch.parquet.ParquetDataFormatPlugin;
            .setSettings(compositeSettings())
        String failureDetail;
    }
            .get();
                .prepareForceMerge(INDEX_NAME)
    protected Settings nodeSettings(int nodeOrdinal) {
            .setMapping("name", "type=keyword", "age", "type=integer")
                + " successfulShards="
 */
            .cluster()
import java.util.function.Function;
                .prepareForceMerge(INDEX_NAME)
            failureDetail = Arrays.toString(response.getShardFailures());
import java.util.Locale;
    @Override
import org.opensearch.arrow.allocator.ArrowBasePlugin;
import org.opensearch.indices.IndicesService;
                + Arrays.toString(response.getShardFailures());
            .setPersistentSettings(Settings.builder().put("native.allocator.overcommit.pressure_threshold", 100.0))
                    .anyMatch(f -> f.reason() != null && f.reason().toLowerCase(Locale.ROOT).contains("merge pool"));
            IndexResponse response = client().prepareIndex()
 * Reproduces the merge-pool starvation problem for the composite data format
 *
    private DataformatAwareCatalogSnapshot getCatalogSnapshot() throws IOException {
import org.opensearch.index.engine.exec.coord.DataformatAwareCatalogSnapshot;
        ensureGreen(INDEX_NAME);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
        client().admin()
        // native-memory pressure is comfortably below it; the pressure signal itself is the real
        // failed shard in the response or as a thrown exception — accept both.
        }
            assertEquals(RestStatus.CREATED, response.status());
                .setIndex(INDEX_NAME)
        try {
    // ══════════════════════════════════════════════════════════════════════
 */
        assertTrue("segments should not have been merged when over-commit is refused", getSegmentCount() > 1);
            ForceMergeResponse response = client().admin()
            failureDetail = e.toString();
            .prepareUpdateSettings()
     * because the native merge's row-id mapping reservation is rejected.
    }
                .get();
        return getCatalogSnapshot().getSegments().size();
     */
        for (String node : internalCluster().getNodeNames()) {
    // Framework lifecycle & configuration
import org.opensearch.action.index.IndexResponse;
        // signal has no cluster setting, and the shared-JVM decider may resolve to any node's
        return Settings.builder()
     * Over-commit is enabled, but the node native-memory pressure is manually driven above the
        assertTrue(
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            failureDetail = e.toString();
        client().admin()
        // injected node signal, so no per-instance stubbing is needed. With the fallback active, the
        String nodeId = getClusterState().routingTable().index(INDEX_NAME).shard(0).primaryShard().currentNodeId();
                .get();
     */
                .get();
            .setMapping("name", "type=keyword", "age", "type=integer")
                .indices()
import org.opensearch.test.OpenSearchIntegTestCase;
            .build();
        client().admin()
// The Tokio IO runtime worker thread used by the Rust merge is a process-lifetime singleton
        } catch (Exception e) {
     * configured threshold. The allocator's decider must refuse the over-commit, so the force merge
        return Settings.builder()
 * failure is deterministic. It is the baseline that the planned soft-limit / over-commit fix
            .indices()
            // mapping reservation (total_rows * 8 bytes) exceeds this and is rejected.
            .put("index.pluggable.dataformat.enabled", true)
 * must turn green.
    public void testForceMergeSucceedsWithOverCommitEnabled() throws Exception {
            "no shard should fail the merge once over-commit is enabled; shardFailures=" + Arrays.toString(response.getShardFailures()),
 * merge pool with {@code PoolBehavior::Reject}. When the merge pool limit is smaller than
        try {
    }
import org.opensearch.common.settings.Settings;
            ArrowBasePlugin.class,
 * <p>This test pins the merge pool to a 1–2 byte window and disables the rebalancer so the
        boolean forceMergeFailed;
            ParquetDataFormatPlugin.class,
        }
            return DataformatAwareCatalogSnapshot.deserializeFromString(snapshot.get().serializeToString(), Function.identity());
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
            .cluster()
            .put(super.nodeSettings(nodeOrdinal))
     */
     * keeps each refresh cycle to a single writer (one committed segment), and avoids triggering
            .setMapping("name", "type=keyword", "age", "type=integer")
                .setFlush(false)
 *
            .put("index.pluggable.dataformat", "composite")
                .setMaxNumSegments(1)
     * Indexes {@code numDocs} documents sequentially, then refreshes once. Sequential indexing
            // Starve the merge pool: 1-byte floor, 2-byte ceiling. Any real merge's row-id
            .putList("index.composite.secondary_data_formats", "lucene")
import org.opensearch.common.concurrent.GatedCloseable;
            .get();
            .get();
 * SPDX-License-Identifier: Apache-2.0
// that persists after tests complete (mirrors CompositeMergeIT).
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
    /**
        );
     * segment.
        // The segments must not have been consolidated to a single segment.
            CompositeDataFormatPlugin.class,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
 * never raises the pool's observed utilization, the rebalancer never grows the pool, so the
        assertEquals(
            failureDetail = "failedShards="
     * With the merge pool pinned to 2 bytes, a force merge of multiple segments must fail
    /**
import org.opensearch.be.lucene.LucenePlugin;
 * The OpenSearch Contributors require contributions made to
            // Disable the rebalancer so the merge pool cannot be grown back. A rejected merge
     * merge-on-refresh so the segment count is deterministic.
            .indices()
        assertTrue("at least one shard should have merged", response.getSuccessfulShards() >= 1);
        indexAndRefresh(10);
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
        RefreshResponse refreshResponse = client().admin().indices().prepareRefresh(INDEX_NAME).get();
        try (GatedCloseable<CatalogSnapshot> snapshot = shard.getCatalogSnapshot()) {
 * compatible open source license.
    private IndexShard getPrimaryShard() {
        assertBusy(() -> assertEquals("segments should be merged to one", 1, getSegmentCount()), 30, java.util.concurrent.TimeUnit.SECONDS);
        return Arrays.asList(
    }
                assertTrue("force merge failure should reference the merge pool; detail=" + failureDetail, mentionsPool);
            .get();
 * merge can never succeed on retry — a force merge fails permanently.
            internalCluster().getInstance(ArrowNativeAllocator.class, node).setNativeMemoryPressureSupplier(() -> 95.0);
        client().admin()
/*
            forceMergeFailed = true;
            // When surfaced via the response, the reason should reference the exhausted merge pool.
import org.opensearch.common.util.FeatureFlags;
import java.io.IOException;
import org.opensearch.index.IndexService;
                + response.getFailedShards()
                .setFlush(false)
            .put("index.composite.primary_data_format", "parquet")
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
import org.opensearch.index.shard.IndexShard;
        boolean forceMergeFailed;
    }
            // never registers utilization, so this reproduces the starvation deterministically.
            0,
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex(INDEX_NAME));
        // Over-commit is enabled by default; disable it explicitly so the exhausted merge pool
        IndexShard shard = getPrimaryShard();
        }
            .setSettings(compositeSettings())
                boolean mentionsPool = Arrays.stream(response.getShardFailures())
            }
        // merge's row-id mapping reservation is granted an over-commit instead of being rejected.
    }
            .prepareCreate(INDEX_NAME)
        indexAndRefresh(10);
            .get();
    }
 * this file be licensed under the Apache-2.0 license or a
                + response.getSuccessfulShards()
        for (int i = 0; i < numDocs; i++) {
            forceMergeFailed = true;
     * still fails on the exhausted merge pool.
        return indexService.getShard(0);
            .put("native.allocator.rebalancer.enabled", false)
            .build();
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
     * pressure below the threshold, the force merge must now succeed: the rejected row-id mapping
 * the mapping, {@code try_grow} fails and the merge is rejected. Because a rejected merge
                .setMaxNumSegments(1)
        assertTrue("expected multiple segments before force merge", getSegmentCount() > 1);
    private static final String INDEX_NAME = "test-composite-merge-pool-exhaustion";
            .get();
    // Test
        indexAndRefresh(10);
        );
        assertTrue("expected multiple segments before force merge", getSegmentCount() > 1);
        );
        indexAndRefresh(10);
    // ══════════════════════════════════════════════════════════════════════
        // Over-commit is enabled by default; set a threshold below the pressure we will inject.
            .put("index.refresh_interval", "-1")
    /**
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
            .cluster()
            response.getFailedShards()
    public void testForceMergeRejectedWhenNativePressureAboveThreshold() throws Exception {
            forceMergeFailed = response.getFailedShards() >= 1 && response.getSuccessfulShards() == 0;
        // Two ingest + refresh cycles → at least two committed segments to merge.
        // Segments consolidated to a single segment.
                .setSource("name", randomAlphaOfLength(10), "age", randomIntBetween(1, 1000))
     * reservation is granted an over-commit by the allocator, and the merge consolidates to a single
            .put("parquet.native.pool.merge.max", 2L)
        // Over-commit is enabled by default. Raise the pressure threshold so the node's (low)
            .prepareUpdateSettings()
    /**
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, nodeName);
}
            .put("parquet.native.pool.merge.min", 1L)
        client().admin()
    // ══════════════════════════════════════════════════════════════════════
            .setPersistentSettings(Settings.builder().put("native.allocator.overcommit.pressure_threshold", 80.0))
    }
    private Settings compositeSettings() {
/**
            .prepareCreate(INDEX_NAME)
        assertTrue("expected multiple segments before force merge", getSegmentCount() > 1);
import java.util.Arrays;
    // ══════════════════════════════════════════════════════════════════════
    private void indexAndRefresh(int numDocs) {
            forceMergeFailed
    public void testForceMergeFailsWhenMergePoolExhausted() throws Exception {
    @Override
        ensureGreen(INDEX_NAME);
        assertTrue("segments should not have been merged when the merge pool is exhausted", getSegmentCount() > 1);
        // rejects the reservation, reproducing the force-merge-fails-forever behavior.
    // ══════════════════════════════════════════════════════════════════════
            .setPersistentSettings(Settings.builder().put("native.allocator.overcommit.enabled", false))
