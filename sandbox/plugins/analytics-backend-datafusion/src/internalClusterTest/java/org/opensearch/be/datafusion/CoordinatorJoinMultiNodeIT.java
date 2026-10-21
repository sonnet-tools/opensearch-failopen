                PPLResponse response;
        for (Map.Entry<Integer, Integer> entry : perKeyCount.entrySet()) {
        assertColumns(response, "k", "v", "w");
     * <ul>
    }
            .put("index.pluggable.dataformat", "composite")
    private void indexUnique(String indexName, String payloadField, int keyLo, int keyHi, IntUnaryOperator keyToPayload) {
                futures[i] = CompletableFuture.supplyAsync(
 * replica to fail allocation with {@code RecoveryFailedException} and the
     * treats the SINGLETON side differently — e.g., skips the
            );
        return new PluginInfo(
        final int N_QUERIES = 4;
import java.util.Set;
 * The OpenSearch Contributors require contributions made to
            .setMapping("k", "type=integer", payloadField, "type=integer")
 * <p>What this stresses that the small-cluster IT doesn't:
    /** {@code dupes} documents per key in {@code [keyLo, keyHi]}, distinct payloads. */
                    pool
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, NUM_REPLICAS)
import org.opensearch.be.lucene.LucenePlugin;
                assertColumns(response, "k", "v", "w");
        createParquetIndex(t2, NUM_SHARDS, "w");
        Set<Integer> seenKeys = new HashSet<>();
import java.util.HashSet;
        // Drop every test index between methods so the SUITE-scoped cluster doesn't
 *   <li>Self-join: same physical table on both sides, two distinct registered
import org.opensearch.common.util.FeatureFlags;
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
import java.util.concurrent.Executors;
import java.util.Collections;
        for (int batchStart = keyLo; batchStart <= keyHi; batchStart += batchSize) {
                bulk.add(client().prepareIndex(indexName).setSource("k", key, payloadField, keyToPayload.applyAsInt(key)));
    public void testJoinAcrossManyShardsAndNodes() throws Exception {
            "classpath plugin",
                }
     */
 * into two registered partition streams) plus a battery of correctness edge cases
        createParquetIndex(t1, NUM_SHARDS, "v");
        PPLResponse response = executePPL("source=" + t1 + " | join on " + t1 + ".k = " + t2 + ".k " + t2);
    @Override
        String t2 = "join_mn_large_t2";
            classpathPlugin(ParquetDataFormatPlugin.class, Collections.emptyList()),
                assertEquals("query " + i + " row count", NUM_KEYS, response.getRows().size());
 *
            pluginClass.getName(),
 *   <li>{@code DatafusionReduceSink#closeUnderLock}'s in-flight-feeds barrier
 * <p>Each test method creates its own pair of indices with names of the form
        // PPL self-join via aliases. Both sides reference the same table; the
            int batchEnd = Math.min(batchStart + batchSize - 1, keyHi);
            "NA",
        assertEquals("disjoint ranges must produce 0 rows", 0, response.getRows().size());
    private void indexWithDuplicates(String indexName, String payloadField, int keyLo, int keyHi, int dupes) {
 *       under realistic shutdown timing.</li>
                    throw new AssertionError("query " + i + " threw", e.getCause());
        createParquetIndex(t2, NUM_SHARDS, "w");
        );
     * level), the other is multi-shard (RANDOM). Catches a bug where the planner
        indexUnique(t2, "w", 1000, 1030, k -> k * 113);
        assertNotNull("PPLResponse must not be null", response);
    }
            // STREAM_TRANSPORT intentionally OFF — see CoordinatorReduceIT for rationale.
        String t2 = "join_mn_base_t2";
    private PPLResponse executePPL(String ppl) {
                int payload = key * 1000 + d;
    private void bulkIndexUnique(String indexName, String payloadField, int keyLo, int keyHi, IntUnaryOperator keyToPayload) {
        assertEquals("every key appears exactly once", NUM_KEYS, seenKeys.size());
        int kIdx = response.getColumns().indexOf("k");
    }
        final int NUM_KEYS = 2000;
        bulkIndexUnique(t1, "v", 1, NUM_KEYS, k -> k * 11);
 * 5 primary shards per index. Exercises the multi-input reduce sink under heavier
            "1.8",
        for (Object[] row : response.getRows()) {
        assertEquals("every overlap key appears", overlapSize, perKeyCount.size());
            .setSettings(indexSettings)
            .indices()
        PPLResponse response = executePPL("source=" + t1 + " as a | join on a.k = b.k " + t1 + " as b");
        assertColumns(response, "k", "v", "w");
    }
     */
 * this IT should be expanded to validate replica-aware shard-target resolution.
        return List.of(TestPPLPlugin.class, FlightStreamPlugin.class, CompositeDataFormatPlugin.class, LucenePlugin.class);
        indexUnique(t1, "v", 1, 30, k -> k * 11);
        int overlapHi = NUM_KEYS;
}
     * </ul>
        String t2 = "join_mn_conc_t2";
     * regressions where the lock-free {@code feed(int, batch)} path or the
     * <p>Each row joins with itself (k = k always holds for same-key rows), so
        assertEquals("rows = overlap × DUPES", overlapSize * DUPES, response.getRows().size());
 * {@code join_mn_<scenario>_*}; {@link #tearDown()} deletes everything matching
                try {
        try {
     *
     */
            null,
    }
    public void testSelfJoin() throws Exception {
            CompletableFuture<PPLResponse>[] futures = new CompletableFuture[N_QUERIES];
    /** One document per key in {@code [keyLo, keyHi]}. Sequential — fine for small N. */
     * child shard-fragment stages, not alias a single one.
 * <p><b>Replicas are intentionally disabled.</b> The parquet-backed composite
        CreateIndexResponse response = client().admin()
            client().admin().indices().prepareDelete("join_mn_*").get();
     * in-flight barrier in {@code closeUnderLock} mishandle longer queries.
import java.util.concurrent.CompletableFuture;
    }
 * that the small-cluster IT can't easily reach.
        assertEquals("symmetric large join: every key matches once", NUM_KEYS, response.getRows().size());
        // aliases let PPL disambiguate the field references in the join condition.
 * cluster never reaches green. Once the composite engine adds replica support,
        indexUnique(t1, "v", 1, NUM_KEYS, k -> k * 11);
        // matches.
        String t1 = "join_mn_disjoint_t1";
     *   <li>Each overlap key appears exactly DUPES times.</li>
            seenKeys.add(((Number) row[kIdx]).intValue());
 *   <li>Single-shard degenerate case (one side SINGLETON, the other RANDOM).</li>
     * Large symmetric inner join exercising sustained streaming-feed throughput
        for (int key = keyLo; key <= keyHi; key++) {
            for (int d = 0; d < dupes; d++) {
 *   <li>Concurrent queries (session-level isolation).</li>
                "response columns must include '" + column + "', got " + response.getColumns(),
        indexUnique(t1, "v", 1, NUM_KEYS, k -> k * 11);
    /** See class javadoc — composite engine doesn't implement acquireSafeIndexCommit
    // ── Edge case #6: single-shard side ──────────────────────────────────
        String t1 = "join_mn_1shard_t1";
 * for replica recovery; setting {@code number_of_replicas > 0} causes every
            .build();
        ExecutorService pool = Executors.newFixedThreadPool(N_QUERIES);
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        createParquetIndex(t1, NUM_SHARDS, "v");
            org.opensearch.action.bulk.BulkResponse response = bulk.get();
 *       inputs.</li>
 *   <li>Lock-free {@code feed(int inputIndex, batch)} contention from many
        assertColumns(response, "k", "v", "w");
        }
        for (String column : expected) {
        return Settings.builder()
    public void testConcurrentJoinsAreIsolated() throws Exception {
        indexUnique(t2, "w", 1, NUM_KEYS, k -> k * 113);
     * One side is single-shard (SINGLETON distribution at the OpenSearchTableScan
    private void createParquetIndex(String indexName, int numShards, String payloadField) {
    /**
import java.util.List;
            .put(super.nodeSettings(nodeOrdinal))
        int overlapSize = overlapHi - overlapLo + 1;
 *
    // ── Edge case: self-join ─────────────────────────────────────────────
        int overlapLo = OFFSET + 1;
        createParquetIndex(t1, NUM_SHARDS, "v");
                response.getColumns().contains(column)
            assertTrue("joined key in overlap [" + overlapLo + ", " + overlapHi + "], got " + key, key >= overlapLo && key <= overlapHi);
        createParquetIndex(t2, NUM_SHARDS, "w");
import org.opensearch.ppl.action.PPLResponse;
        }
import org.opensearch.plugins.PluginInfo;
 * SPDX-License-Identifier: Apache-2.0
        createParquetIndex(t1, NUM_SHARDS, "v");
     *   <li>Every joined key lies in the overlap range (filters out non-overlap).</li>
 *   <li>NULL key semantics ({@code NULL = NULL} is unknown, must filter out).</li>
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
        assertTrue("index creation must be acknowledged for " + indexName, response.isAcknowledged());
                );
    private static void assertColumns(PPLResponse response, String... expected) {
    @Override
    }
     * partition streams even though the underlying {@code OpenSearchTableScan}
        }
     * and the drain thread under prolonged build/probe windows. Catches
        String t2 = "join_mn_disjoint_t2";
                } catch (ExecutionException e) {
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
            .get();
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 3)
            );
        assertEquals("self-join with unique keys: each row matches itself once", 20, response.getRows().size());
     * columns across responses.
 * this file be licensed under the Apache-2.0 license or a
        indexUnique(t1, "v", 1, 30, k -> k * 11);
     * cross-query state leaks would manifest as wrong row counts or mixed
        assertColumns(response, "k", "v", "w");
    // ── Edge case #8: concurrent queries ─────────────────────────────────
    }
        String t2 = "join_mn_1shard_t2";
        } finally {
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(ppl)).actionGet();
 * {@code join_mn_*} so the SUITE-scoped cluster never accumulates more than the
import org.opensearch.Version;
            pluginClass.getName(),
        String t1 = "join_mn_base_t1";
        client().admin().indices().prepareFlush(indexName).get();
import java.util.HashMap;
                response.hasFailures()
        }
        }
        String t1 = "join_mn_conc_t1";
        PPLResponse response = executePPL("source=" + t1 + " | join on " + t1 + ".k = " + t2 + ".k " + t2);
import java.util.concurrent.TimeUnit;
public class CoordinatorJoinMultiNodeIT extends OpenSearchIntegTestCase {
            assertTrue(
 *   <li>Large data with sustained streaming throughput.</li>
import org.opensearch.common.unit.TimeValue;
import org.opensearch.cluster.metadata.IndexMetadata;
    }
    }
        super.tearDown();
    }
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
        createParquetIndex(t2, NUM_SHARDS, "w");        // 5 shards
                    () -> executePPL("source=" + t1 + " | join on " + t1 + ".k = " + t2 + ".k " + t2),
 * <ul>
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
     * shards on 3 data nodes. Asserts:
    @Override
            client().prepareIndex(indexName).setSource("k", key, payloadField, keyToPayload.applyAsInt(key)).get();
        PPLResponse response = executePPL("source=" + t1 + " | join on " + t1 + ".k = " + t2 + ".k " + t2);
            assertFalse(
            .put("index.pluggable.dataformat.enabled", true)
        final int DUPES = 4;
        return List.of(
    // ── Edge case #5: large data with sustained streaming ────────────────
     * {@code OpenSearchExchangeReducer} insertion that the DAG builder relies on
        final int OFFSET = NUM_KEYS / 3;
        createParquetIndex(t2, NUM_SHARDS, "w");
    protected Collection<PluginInfo> additionalNodePlugins() {
        client().admin().indices().prepareFlush(indexName).get();
    @Override
        String t1 = "join_mn_large_t1";
     * Asymmetric inner equi-join with right-side duplicates across 5+5 primary
 * compatible open source license.
 * Scale + edge-case suite for the coordinator-side hash join path: 3 data nodes,
 *       concurrent shard responses fanning into the two input channels.</li>
        final int NUM_KEYS = 60;
            for (int i = 0; i < N_QUERIES; i++) {
            int key = ((Number) row[kIdx]).intValue();
    }
     *  yet, so replicas can't be recovered. Fixed at 0 until that lands. */
import java.util.concurrent.ExecutorService;
        try {
            perKeyCount.merge(key, 1, Integer::sum);
        assertEquals("1×5-shard symmetric join: every key matches", 30, response.getRows().size());
                    response = futures[i].get(60, TimeUnit.SECONDS);
            Version.CURRENT,
 */
        client().admin().indices().prepareRefresh(indexName).get();
        createParquetIndex(t1, 1, "v");                 // 1 shard
     * resolves the same index — i.e., the planner must produce two separate
        } catch (Exception ignore) {
    /** Bulk-indexed equivalent of {@link #indexUnique} for large datasets. */
        final int NUM_KEYS = 30;
            }
 * fan-in than {@link CoordinatorJoinIT}'s 2×2 baseline (10 child shard tasks fan
    public void testLargeDataInnerJoin() throws Exception {
package org.opensearch.be.datafusion;
     * Both sides populated but with disjoint key ranges. Inner equi-join must
        }
     * the result row count equals the input row count for unique keys.
    }
                client().prepareIndex(indexName).setSource("k", key, payloadField, payload).get();
/**
            for (int key = batchStart; key <= batchEnd; key++) {
 *
 */
            .put("index.composite.primary_data_format", "parquet")
        for (Object[] row : response.getRows()) {
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
import java.util.Collection;
     * return 0 rows. Catches a bug where the HashJoin's empty-result path fails
        assertNotNull(response);
 * current test's shards.
        indexUnique(t1, "v", 1, 20, k -> k * 11);
        Map<Integer, Integer> perKeyCount = new HashMap<>();
import org.opensearch.analytics.AnalyticsPlugin;
            .prepareCreate(indexName)
            .build();
    }
            }
    /**
    }
import org.opensearch.ppl.action.PPLRequest;
    }
    /**
    /**
    private static final int NUM_SHARDS = 5;
 *
    private static final int NUM_REPLICAS = 0;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
            .putList("index.composite.secondary_data_formats", List.of("lucene"))
import java.util.function.IntUnaryOperator;
import java.util.Map;
            extendedPlugins,
/*
            assertEquals("key " + entry.getKey() + " × " + DUPES, DUPES, entry.getValue().intValue());
            pool.shutdown();
     * ({@code "input-0"} and {@code "input-1"}) must point at independent
     * get its own {@link DatafusionLocalSession} and {@link DatafusionReduceSink};
 * </ul>
     */
            }
    public void testSingleShardOneSide() throws Exception {
            @SuppressWarnings("unchecked")
    protected Settings nodeSettings(int nodeOrdinal) {
        for (int key = keyLo; key <= keyHi; key++) {
        Settings indexSettings = Settings.builder()
        }
        // accumulate shard copies across tests. Wildcard delete is cheap when nothing
        PPLResponse response = executePPL("source=" + t1 + " | join on " + t1 + ".k = " + t2 + ".k " + t2);
import org.opensearch.common.settings.Settings;
        ensureGreen(TimeValue.timeValueSeconds(60), indexName);
     * Fires N joins simultaneously against the same indices. Each query must
import org.opensearch.plugins.Plugin;
    }
import java.util.concurrent.ExecutionException;
            for (int i = 0; i < N_QUERIES; i++) {
        );
        bulkIndexUnique(t2, "w", 1, NUM_KEYS, k -> k * 113);
        }
    // ── Helpers ──────────────────────────────────────────────────────────
        }
                "bulk index batch [" + batchStart + ", " + batchEnd + "] had failures: " + response.buildFailureMessage(),
     * to cut the child stage.
            false
        final int batchSize = 500;
     * to flush through the drain thread.
        indexWithDuplicates(t2, "w", OFFSET + 1, NUM_KEYS + OFFSET, DUPES);
    /**
 *   <li>Asymmetric per-side cardinality + many-to-many fan-out on duplicates.</li>
    public void tearDown() throws Exception {
 *   <li>Empty-side and no-overlap edge cases (build or probe side empty must
        createParquetIndex(t1, NUM_SHARDS, "v");
        int kIdx = response.getColumns().indexOf("k");
import org.opensearch.test.OpenSearchIntegTestCase;
        String t1 = "join_mn_self_t1";
        client().admin().indices().prepareFlush(indexName).get();
import org.opensearch.composite.CompositeDataFormatPlugin;
     * Self-join on the same physical table. Two distinct registered inputs
            }
    /**
     */
    // ── Edge case: no key overlap ────────────────────────────────────────
    public void testNoKeyOverlap() throws Exception {
    // ── Baseline scale + asymmetric overlap + duplicates ────────────────
import org.opensearch.ppl.TestPPLPlugin;
 * engine does not implement {@code acquireSafeIndexCommit}, which is required
            org.opensearch.action.bulk.BulkRequestBuilder bulk = client().prepareBulk();
 *       not hang the drain thread).</li>
     *   <li>Row count equals overlap × DUPES.</li>
            assertTrue("executor must terminate", pool.awaitTermination(10, TimeUnit.SECONDS));
import org.opensearch.parquet.ParquetDataFormatPlugin;
        client().admin().indices().prepareRefresh(indexName).get();
     */
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
        client().admin().indices().prepareRefresh(indexName).get();
        indexUnique(t2, "w", 1, 30, k -> k * 113);
            // Best-effort cleanup; some scenarios may have already deleted their indices.
