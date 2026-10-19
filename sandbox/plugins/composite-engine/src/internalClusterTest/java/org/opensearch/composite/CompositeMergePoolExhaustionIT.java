                    .anyMatch(f -> f.reason() != null && f.reason().toLowerCase(Locale.ROOT).contains("merge pool"));  
                .get();
                .setSource("name", randomAlphaOfLength(10), "age", randomIntBetween(1, 1000))
            .prepareCreate(INDEX_NAME)
            .prepareUpdateSettings()
            failureDetail = Arrays.toString(response.getShardFailures());
        indexAndRefresh(10);
 * Reproduces the merge-pool starvation problem for the composite data format
            .put("parquet.native.pool.merge.max", 2L)  
            forceMergeFailed = response.getFailedShards() >= 1 && response.getSuccessfulShards() == 0;
 * never raises the pool's observed utilization, the rebalancer never grows the pool, so the
    // Helpers: shard/catalog accessors
                .prepareForceMerge(INDEX_NAME)
        indexAndRefresh(10);
            response.getFailedShards()  
        assertBusy(() -> assertEquals("segments should be merged to one", 1, getSegmentCount()), 30, java.util.concurrent.TimeUnit.SECONDS);
            .put(super.nodeSettings(nodeOrdinal))
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
 *
            .put("parquet.native.pool.merge.min", 1L)
        assertTrue("segments should not have been merged when the merge pool is exhausted", getSegmentCount() > 1);
        // injected node signal, so no per-instance stubbing is needed. With the fallback active, the
            .setMapping("name", "type=keyword", "age", "type=integer")  
                + " shardFailures="
            .indices()
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
package org.opensearch.composite;
        // Two ingest + refresh cycles → at least two committed segments to merge.  
            }
        // allocator, so inject it everywhere.
    }
    private DataformatAwareCatalogSnapshot getCatalogSnapshot() throws IOException {
            .get();
            failureDetail = e.toString();
import org.opensearch.core.rest.RestStatus;
            LucenePlugin.class,
                assertTrue("force merge failure should reference the merge pool; detail=" + failureDetail, mentionsPool);
import org.opensearch.index.shard.IndexShard;  
        boolean forceMergeFailed;
            .put("index.composite.primary_data_format", "parquet")
                + response.getSuccessfulShards()  
            // Starve the merge pool: 1-byte floor, 2-byte ceiling. Any real merge's row-id  
    private static final String INDEX_NAME = "test-composite-merge-pool-exhaustion";
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
            ArrowBasePlugin.class,
        assertTrue("expected multiple segments before force merge", getSegmentCount() > 1);  
            // never registers utilization, so this reproduces the starvation deterministically.
     */  
        // signal has no cluster setting, and the shared-JVM decider may resolve to any node's
        indexAndRefresh(10);
import org.opensearch.action.index.IndexResponse;
        return Settings.builder()  
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;  
            .get();
     * Indexes {@code numDocs} documents sequentially, then refreshes once. Sequential indexing
import org.opensearch.be.lucene.LucenePlugin;  
                .setMaxNumSegments(1)
        String nodeId = getClusterState().routingTable().index(INDEX_NAME).shard(0).primaryShard().currentNodeId();  
            .setMapping("name", "type=keyword", "age", "type=integer")
                .indices()  
                .setFlush(false)
            .indices()  
 * (parquet primary + lucene secondary).
 *  
        );
import org.opensearch.test.OpenSearchIntegTestCase;
        // merge's row-id mapping reservation is granted an over-commit instead of being rejected.  
        for (int i = 0; i < numDocs; i++) {
            internalCluster().getInstance(ArrowNativeAllocator.class, node).setNativeMemoryPressureSupplier(() -> 95.0);
}
import org.opensearch.parquet.ParquetDataFormatPlugin;
        assertTrue("force merge should fail when the merge pool is exhausted; detail=" + failureDetail, forceMergeFailed);
        return Settings.builder()
    }  
            if (forceMergeFailed) {
        indexAndRefresh(10);
            "no shard should fail the merge once over-commit is enabled; shardFailures=" + Arrays.toString(response.getShardFailures()),
import org.opensearch.index.IndexService;  
            forceMergeFailed = true;
import java.util.Locale;  
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
// that persists after tests complete (mirrors CompositeMergeIT).  
        RefreshResponse refreshResponse = client().admin().indices().prepareRefresh(INDEX_NAME).get();
        client().admin()
        // row-id mapping reservation, so the merge fails. The failure surfaces either as a  
        assertTrue("segments should not have been merged when over-commit is refused", getSegmentCount() > 1);  
    }
import org.opensearch.plugins.Plugin;  
        String nodeName = getClusterState().nodes().get(nodeId).getName();
 *  
        return indexService.getShard(0);
        ensureGreen(INDEX_NAME);
    }  
        assertTrue("expected multiple segments before force merge", getSegmentCount() > 1);
        } catch (Exception e) {  
     * configured threshold. The allocator's decider must refuse the over-commit, so the force merge
        try {  
                boolean mentionsPool = Arrays.stream(response.getShardFailures())
    @Override
                + response.getFailedShards()
        assertTrue("at least one shard should have merged", response.getSuccessfulShards() >= 1);
    // ══════════════════════════════════════════════════════════════════════  
        ensureGreen(INDEX_NAME);  
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, nodeName);
            .build();
            ForceMergeResponse response = client().admin()
        ForceMergeResponse response = client().admin().indices().prepareForceMerge(INDEX_NAME).setMaxNumSegments(1).setFlush(true).get();
        return getCatalogSnapshot().getSegments().size();
            .put("index.pluggable.dataformat", "composite")
            .put("index.pluggable.dataformat.enabled", true)  
                .setIndex(INDEX_NAME)  
            .cluster()
        // failed shard in the response or as a thrown exception — accept both.
        IndexShard shard = getPrimaryShard();
        assertEquals(RestStatus.OK, refreshResponse.getStatus());  
    // ══════════════════════════════════════════════════════════════════════
            // mapping reservation (total_rows * 8 bytes) exceeds this and is rejected.
        }
    private void indexAndRefresh(int numDocs) {  
     * segment.  
        // rejects the reservation, reproducing the force-merge-fails-forever behavior.
import org.opensearch.be.datafusion.DataFusionPlugin;
import org.opensearch.index.engine.exec.coord.DataformatAwareCatalogSnapshot;
    // ══════════════════════════════════════════════════════════════════════
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
            .get();  
            .put("index.refresh_interval", "-1")
    // Test
        // Force merge to a single segment. The 2-byte merge pool rejects the native merge's
import org.opensearch.common.util.FeatureFlags;
    @Override
        indexAndRefresh(10);
    }  
    protected Settings nodeSettings(int nodeOrdinal) {
        return Arrays.asList(
public class CompositeMergePoolExhaustionIT extends OpenSearchIntegTestCase {  
            .putList("index.composite.secondary_data_formats", "lucene")  
        client().admin()  
    private int getSegmentCount() throws IOException {
import java.util.function.Function;
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
    // ══════════════════════════════════════════════════════════════════════  
 */
            .prepareUpdateSettings()
import org.opensearch.common.concurrent.GatedCloseable;
        String failureDetail;  
 */  
     * because the native merge's row-id mapping reservation is rejected.
        boolean forceMergeFailed;
            .setSettings(compositeSettings())  
        ensureGreen(INDEX_NAME);
                .indices()
     * keeps each refresh cycle to a single writer (one committed segment), and avoids triggering  
 * <p>The native merge reserves its row-id mapping ({@code total_rows * 8} bytes) from the
    private IndexShard getPrimaryShard() {
            forceMergeFailed
import org.opensearch.arrow.allocator.ArrowBasePlugin;  
            .cluster()
        client().admin()
            .setPersistentSettings(Settings.builder().put("native.allocator.overcommit.pressure_threshold", 80.0))  
        // native-memory pressure is comfortably below it; the pressure signal itself is the real
                .prepareForceMerge(INDEX_NAME)  
        client().admin()  
import org.opensearch.common.settings.Settings;  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
            0,
    }  
            IndexResponse response = client().prepareIndex()
 * <p>This test pins the merge pool to a 1–2 byte window and disables the rebalancer so the
            DataFusionPlugin.class  
     * reservation is granted an over-commit by the allocator, and the merge consolidates to a single
        // Over-commit is enabled by default; set a threshold below the pressure we will inject.
            .prepareCreate(INDEX_NAME)  
            "force merge should fail when native pressure exceeds the over-commit threshold; detail=" + failureDetail,  
     * still fails on the exhausted merge pool.
            // When surfaced via the response, the reason should reference the exhausted merge pool.  
    // ══════════════════════════════════════════════════════════════════════  
            .setPersistentSettings(Settings.builder().put("native.allocator.overcommit.enabled", false))
 * must turn green.  
            .prepareUpdateSettings()  
            .get();  
    private Settings compositeSettings() {
/**  
    }
     */
 * compatible open source license.
                .setFlush(false)  
 * The OpenSearch Contributors require contributions made to  
            .cluster()  
        } catch (Exception e) {  
    // ══════════════════════════════════════════════════════════════════════
        for (String node : internalCluster().getNodeNames()) {  
 * merge can never succeed on retry — a force merge fails permanently.
            // Disable the rebalancer so the merge pool cannot be grown back. A rejected merge
    public void testForceMergeSucceedsWithOverCommitEnabled() throws Exception {
        client().admin()
     * merge-on-refresh so the segment count is deterministic.
            forceMergeFailed = response.getFailedShards() >= 1 && response.getSuccessfulShards() == 0;
        String failureDetail;
            ForceMergeResponse response = client().admin()
                .get();  
import java.util.Collection;
                .setMaxNumSegments(1)
        assertTrue("expected multiple segments before force merge", getSegmentCount() > 1);
    // Helpers: index settings & indexing
            failureDetail = "failedShards="  
        }  
        // The segments must not have been consolidated to a single segment.
    public void testForceMergeRejectedWhenNativePressureAboveThreshold() throws Exception {
        indexAndRefresh(10);  
            .put("native.allocator.rebalancer.enabled", false)  
            .get();
     * Over-commit is enabled, but the node native-memory pressure is manually driven above the  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
 * failure is deterministic. It is the baseline that the planned soft-limit / over-commit fix
    }
import org.opensearch.indices.IndicesService;
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
    public void testForceMergeFailsWhenMergePoolExhausted() throws Exception {  
        // Drive native-memory pressure above the threshold on every node's allocator. The pressure  
            .setSettings(compositeSettings())
        );
    // ══════════════════════════════════════════════════════════════════════
            .prepareCreate(INDEX_NAME)
    }
        assertEquals(  
            .setMapping("name", "type=keyword", "age", "type=integer")
        // Segments consolidated to a single segment.
            CompositeDataFormatPlugin.class,
        try (GatedCloseable<CatalogSnapshot> snapshot = shard.getCatalogSnapshot()) {  
            assertEquals(RestStatus.CREATED, response.status());  
        assertTrue(
            ParquetDataFormatPlugin.class,  
                .get();
                + Arrays.toString(response.getShardFailures());
    /**
 * this file be licensed under the Apache-2.0 license or a
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
    /**
     */
        // Over-commit is enabled by default; disable it explicitly so the exhausted merge pool  
/*  
            return DataformatAwareCatalogSnapshot.deserializeFromString(snapshot.get().serializeToString(), Function.identity());
     */
            .build();
            .setPersistentSettings(Settings.builder().put("native.allocator.overcommit.pressure_threshold", 100.0))
import org.opensearch.cluster.metadata.IndexMetadata;
        // Over-commit is enabled by default. Raise the pressure threshold so the node's (low)  
     * With the merge pool pinned to 2 bytes, a force merge of multiple segments must fail  
        }  
 * merge pool with {@code PoolBehavior::Reject}. When the merge pool limit is smaller than
    }
import java.io.IOException;  
        }
            failureDetail = e.toString();
            forceMergeFailed = true;
            .indices()
        client().admin()
            .get();
    // Framework lifecycle & configuration
        }
 * the mapping, {@code try_grow} fails and the merge is rejected. Because a rejected merge  
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex(INDEX_NAME));  
    /**
    /**
import java.util.Arrays;
                + " successfulShards="
     * pressure below the threshold, the force merge must now succeed: the rejected row-id mapping
        );
     * With the same 2-byte merge pool but the over-commit fallback enabled and node native-memory  
            .setSettings(compositeSettings())
    // ══════════════════════════════════════════════════════════════════════  
        try {
 * SPDX-License-Identifier: Apache-2.0
// The Tokio IO runtime worker thread used by the Rust merge is a process-lifetime singleton
