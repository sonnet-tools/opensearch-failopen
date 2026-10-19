import java.util.concurrent.CompletableFuture;  
    }
        assertNotNull(response);
    /**  
        Set<Integer> seenKeys = new HashSet<>();
 * this file be licensed under the Apache-2.0 license or a
        indexUnique(t1, "v", 1, 30, k -> k * 11);  
        assertEquals("rows = overlap × DUPES", overlapSize * DUPES, response.getRows().size());  
            client().admin().indices().prepareDelete("join_mn_*").get();
        assertColumns(response, "k", "v", "w");
        }  
        }
import java.util.List;  
import org.opensearch.ppl.action.PPLRequest;  
     */  
        String t1 = "join_mn_large_t1";  
        indexUnique(t2, "w", 1, NUM_KEYS, k -> k * 113);
     * to cut the child stage.
public class CoordinatorJoinMultiNodeIT extends OpenSearchIntegTestCase {
                "bulk index batch [" + batchStart + ", " + batchEnd + "] had failures: " + response.buildFailureMessage(),
        }
            "1.8",
    // ── Edge case #6: single-shard side ──────────────────────────────────  
 * replica to fail allocation with {@code RecoveryFailedException} and the
        assertEquals("disjoint ranges must produce 0 rows", 0, response.getRows().size());
            // STREAM_TRANSPORT intentionally OFF — see CoordinatorReduceIT for rationale.  
    /** {@code dupes} documents per key in {@code [keyLo, keyHi]}, distinct payloads. */
import org.opensearch.analytics.AnalyticsPlugin;  
        int overlapSize = overlapHi - overlapLo + 1;
        indexUnique(t2, "w", 1000, 1030, k -> k * 113);
        int overlapHi = NUM_KEYS;
    private PPLResponse executePPL(String ppl) {
        assertColumns(response, "k", "v", "w");
            pluginClass.getName(),
        client().admin().indices().prepareRefresh(indexName).get();  
     * Both sides populated but with disjoint key ranges. Inner equi-join must  
     * Self-join on the same physical table. Two distinct registered inputs
import org.opensearch.common.util.FeatureFlags;  
import java.util.Collections;  
        String t2 = "join_mn_large_t2";
    /** See class javadoc — composite engine doesn't implement acquireSafeIndexCommit
            assertTrue("executor must terminate", pool.awaitTermination(10, TimeUnit.SECONDS));
import org.opensearch.be.lucene.LucenePlugin;
        }  
import org.opensearch.cluster.metadata.IndexMetadata;  
    public void testSelfJoin() throws Exception {
     * Fires N joins simultaneously against the same indices. Each query must
            Version.CURRENT,
            .put("index.pluggable.dataformat.enabled", true)  
        final int NUM_KEYS = 60;
                client().prepareIndex(indexName).setSource("k", key, payloadField, payload).get();  
        PPLResponse response = executePPL("source=" + t1 + " | join on " + t1 + ".k = " + t2 + ".k " + t2);  
            @SuppressWarnings("unchecked")  
 *       inputs.</li>
        // matches.
        // PPL self-join via aliases. Both sides reference the same table; the
        client().admin().indices().prepareFlush(indexName).get();
import org.opensearch.Version;
     *   <li>Every joined key lies in the overlap range (filters out non-overlap).</li>  
            "classpath plugin",
            .put(super.nodeSettings(nodeOrdinal))
            for (int d = 0; d < dupes; d++) {
     * level), the other is multi-shard (RANDOM). Catches a bug where the planner
        String t2 = "join_mn_conc_t2";
            );
                response.getColumns().contains(column)  
    public void testLargeDataInnerJoin() throws Exception {
            CompletableFuture<PPLResponse>[] futures = new CompletableFuture[N_QUERIES];
        final int batchSize = 500;
            }
    private void createParquetIndex(String indexName, int numShards, String payloadField) {
    }
        for (int key = keyLo; key <= keyHi; key++) {
        ExecutorService pool = Executors.newFixedThreadPool(N_QUERIES);
    }
/*  
        createParquetIndex(t1, NUM_SHARDS, "v");
        assertTrue("index creation must be acknowledged for " + indexName, response.isAcknowledged());
        createParquetIndex(t2, NUM_SHARDS, "w");        // 5 shards
        createParquetIndex(t1, 1, "v");                 // 1 shard  
        indexUnique(t1, "v", 1, 30, k -> k * 11);
    public void testSingleShardOneSide() throws Exception {  
        createParquetIndex(t1, NUM_SHARDS, "v");
 *       concurrent shard responses fanning into the two input channels.</li>  
import org.opensearch.test.OpenSearchIntegTestCase;  
                );  
                PPLResponse response;  
                assertEquals("query " + i + " row count", NUM_KEYS, response.getRows().size());
                    throw new AssertionError("query " + i + " threw", e.getCause());
                    response = futures[i].get(60, TimeUnit.SECONDS);
     * shards on 3 data nodes. Asserts:  
    public void testConcurrentJoinsAreIsolated() throws Exception {  
            null,
                    () -> executePPL("source=" + t1 + " | join on " + t1 + ".k = " + t2 + ".k " + t2),
        String t2 = "join_mn_1shard_t2";
        assertNotNull("PPLResponse must not be null", response);
        return new PluginInfo(  
    }  
import org.opensearch.common.settings.Settings;
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(ppl)).actionGet();  
 * 5 primary shards per index. Exercises the multi-input reduce sink under heavier  
import java.util.concurrent.Executors;  
        String t1 = "join_mn_self_t1";  
}
    /** Bulk-indexed equivalent of {@link #indexUnique} for large datasets. */  
    @Override
 *
        indexUnique(t1, "v", 1, 20, k -> k * 11);
        Settings indexSettings = Settings.builder()  
        assertEquals("1×5-shard symmetric join: every key matches", 30, response.getRows().size());
     * the result row count equals the input row count for unique keys.  
            for (int key = batchStart; key <= batchEnd; key++) {  
        createParquetIndex(t1, NUM_SHARDS, "v");
 * <p>What this stresses that the small-cluster IT doesn't:  
        assertEquals("every key appears exactly once", NUM_KEYS, seenKeys.size());  
        bulkIndexUnique(t1, "v", 1, NUM_KEYS, k -> k * 11);
 *   <li>Concurrent queries (session-level isolation).</li>
        // accumulate shard copies across tests. Wildcard delete is cheap when nothing
     */
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
        }
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
     * ({@code "input-0"} and {@code "input-1"}) must point at independent  
 */  
                    pool
                try {
 *       not hang the drain thread).</li>
        createParquetIndex(t2, NUM_SHARDS, "w");
                response.hasFailures()  
    // ── Edge case: no key overlap ────────────────────────────────────────  
    /** One document per key in {@code [keyLo, keyHi]}. Sequential — fine for small N. */  
        );
        client().admin().indices().prepareFlush(indexName).get();  
            pluginClass.getName(),  
import org.opensearch.common.unit.TimeValue;
                "response columns must include '" + column + "', got " + response.getColumns(),
        super.tearDown();
    private static final int NUM_REPLICAS = 0;
        }
            int batchEnd = Math.min(batchStart + batchSize - 1, keyHi);
        indexUnique(t1, "v", 1, NUM_KEYS, k -> k * 11);  
        }
                bulk.add(client().prepareIndex(indexName).setSource("k", key, payloadField, keyToPayload.applyAsInt(key)));
        createParquetIndex(t2, NUM_SHARDS, "w");  
     */
    /**
    private void indexWithDuplicates(String indexName, String payloadField, int keyLo, int keyHi, int dupes) {
    // ── Edge case #8: concurrent queries ─────────────────────────────────
        int kIdx = response.getColumns().indexOf("k");
            for (int i = 0; i < N_QUERIES; i++) {
import org.opensearch.parquet.ParquetDataFormatPlugin;
     * in-flight barrier in {@code closeUnderLock} mishandle longer queries.
 *
 * compatible open source license.
 *   <li>Lock-free {@code feed(int inputIndex, batch)} contention from many
 * {@code join_mn_*} so the SUITE-scoped cluster never accumulates more than the
        assertColumns(response, "k", "v", "w");
        String t1 = "join_mn_conc_t1";  
        indexUnique(t2, "w", 1, 30, k -> k * 113);  
    protected Settings nodeSettings(int nodeOrdinal) {
            .setSettings(indexSettings)
        ensureGreen(TimeValue.timeValueSeconds(60), indexName);  
        createParquetIndex(t2, NUM_SHARDS, "w");
     */
            assertEquals("key " + entry.getKey() + " × " + DUPES, DUPES, entry.getValue().intValue());
        final int N_QUERIES = 4;
    public void tearDown() throws Exception {
        createParquetIndex(t1, NUM_SHARDS, "v");
        String t1 = "join_mn_disjoint_t1";
     * Large symmetric inner join exercising sustained streaming-feed throughput
            }
    }  
        final int NUM_KEYS = 30;
                } catch (ExecutionException e) {  
package org.opensearch.be.datafusion;
        int kIdx = response.getColumns().indexOf("k");
    }
            }
import java.util.concurrent.TimeUnit;
            .get();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        assertEquals("every overlap key appears", overlapSize, perKeyCount.size());  
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
import java.util.HashMap;
        int overlapLo = OFFSET + 1;  
    /**
 *   <li>NULL key semantics ({@code NULL = NULL} is unknown, must filter out).</li>  
    }
                futures[i] = CompletableFuture.supplyAsync(  
        PPLResponse response = executePPL("source=" + t1 + " as a | join on a.k = b.k " + t1 + " as b");  
            assertTrue("joined key in overlap [" + overlapLo + ", " + overlapHi + "], got " + key, key >= overlapLo && key <= overlapHi);  
    @Override
     * One side is single-shard (SINGLETON distribution at the OpenSearchTableScan  
        bulkIndexUnique(t2, "w", 1, NUM_KEYS, k -> k * 113);
            pool.shutdown();
     * treats the SINGLETON side differently — e.g., skips the
            .build();
 *       under realistic shutdown timing.</li>
import org.opensearch.ppl.action.PPLResponse;
        } catch (Exception ignore) {
import java.util.HashSet;
        // aliases let PPL disambiguate the field references in the join condition.
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
        for (String column : expected) {  
            classpathPlugin(ParquetDataFormatPlugin.class, Collections.emptyList()),  
 * that the small-cluster IT can't easily reach.  
 * <p>Each test method creates its own pair of indices with names of the form
import org.opensearch.plugins.Plugin;  
            "NA",  
        client().admin().indices().prepareRefresh(indexName).get();
            .put("index.pluggable.dataformat", "composite")
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 3)
    @Override
            .put("index.composite.primary_data_format", "parquet")
    private void bulkIndexUnique(String indexName, String payloadField, int keyLo, int keyHi, IntUnaryOperator keyToPayload) {
 *
        indexUnique(t1, "v", 1, NUM_KEYS, k -> k * 11);
     * to flush through the drain thread.
        for (Map.Entry<Integer, Integer> entry : perKeyCount.entrySet()) {
 *   <li>Empty-side and no-overlap edge cases (build or probe side empty must
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, NUM_REPLICAS)
 *   <li>Self-join: same physical table on both sides, two distinct registered
     * resolves the same index — i.e., the planner must produce two separate
    }
            org.opensearch.action.bulk.BulkRequestBuilder bulk = client().prepareBulk();
     */  
     *
        final int NUM_KEYS = 2000;
import java.util.Map;
    }
     * Asymmetric inner equi-join with right-side duplicates across 5+5 primary
 * fan-in than {@link CoordinatorJoinIT}'s 2×2 baseline (10 child shard tasks fan
        indexWithDuplicates(t2, "w", OFFSET + 1, NUM_KEYS + OFFSET, DUPES);
     * columns across responses.
            seenKeys.add(((Number) row[kIdx]).intValue());
        String t1 = "join_mn_base_t1";
    protected Collection<PluginInfo> additionalNodePlugins() {  
        assertEquals("self-join with unique keys: each row matches itself once", 20, response.getRows().size());
import org.opensearch.ppl.TestPPLPlugin;
        createParquetIndex(t2, NUM_SHARDS, "w");  
 *   <li>{@code DatafusionReduceSink#closeUnderLock}'s in-flight-feeds barrier
    /**
        );
     * partition streams even though the underlying {@code OpenSearchTableScan}
     * get its own {@link DatafusionLocalSession} and {@link DatafusionReduceSink};
        client().admin().indices().prepareFlush(indexName).get();
        return List.of(
     *   <li>Row count equals overlap × DUPES.</li>
        PPLResponse response = executePPL("source=" + t1 + " | join on " + t1 + ".k = " + t2 + ".k " + t2);  
        PPLResponse response = executePPL("source=" + t1 + " | join on " + t1 + ".k = " + t2 + ".k " + t2);
            client().prepareIndex(indexName).setSource("k", key, payloadField, keyToPayload.applyAsInt(key)).get();  
    public void testNoKeyOverlap() throws Exception {
        String t2 = "join_mn_disjoint_t2";  
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
            }
        assertEquals("symmetric large join: every key matches once", NUM_KEYS, response.getRows().size());  
    }
    @Override  
            .putList("index.composite.secondary_data_formats", List.of("lucene"))  
            perKeyCount.merge(key, 1, Integer::sum);
            extendedPlugins,
     * <p>Each row joins with itself (k = k always holds for same-key rows), so
    private void indexUnique(String indexName, String payloadField, int keyLo, int keyHi, IntUnaryOperator keyToPayload) {
        CreateIndexResponse response = client().admin()
     */  
 * this IT should be expanded to validate replica-aware shard-target resolution.
 * for replica recovery; setting {@code number_of_replicas > 0} causes every
        // Drop every test index between methods so the SUITE-scoped cluster doesn't  
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
 * engine does not implement {@code acquireSafeIndexCommit}, which is required  
import java.util.function.IntUnaryOperator;
    }
                int payload = key * 1000 + d;
        String t2 = "join_mn_base_t2";  
import java.util.Collection;
            assertTrue(
     * </ul>
    }  
        return Settings.builder()  
import java.util.concurrent.ExecutionException;
import org.opensearch.plugins.PluginInfo;
                assertColumns(response, "k", "v", "w");  
     * return 0 rows. Catches a bug where the HashJoin's empty-result path fails
     * child shard-fragment stages, not alias a single one.  
    }
 * <p><b>Replicas are intentionally disabled.</b> The parquet-backed composite
 * cluster never reaches green. Once the composite engine adds replica support,  
 * {@code join_mn_<scenario>_*}; {@link #tearDown()} deletes everything matching  
        try {  
    }
    // ── Helpers ──────────────────────────────────────────────────────────  
        assertColumns(response, "k", "v", "w");  
    private static final int NUM_SHARDS = 5;
    /**
        final int DUPES = 4;
                }
/**
        }
 *   <li>Asymmetric per-side cardinality + many-to-many fan-out on duplicates.</li>  
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
        }
        for (Object[] row : response.getRows()) {  
     * and the drain thread under prolonged build/probe windows. Catches  
    // ── Baseline scale + asymmetric overlap + duplicates ────────────────
 *
        for (int batchStart = keyLo; batchStart <= keyHi; batchStart += batchSize) {  
 * current test's shards.
     * cross-query state leaks would manifest as wrong row counts or mixed  
import java.util.concurrent.ExecutorService;
    }  
            .setMapping("k", "type=integer", payloadField, "type=integer")  
    /**
        createParquetIndex(t1, NUM_SHARDS, "v");
        Map<Integer, Integer> perKeyCount = new HashMap<>();  
        PPLResponse response = executePPL("source=" + t1 + " | join on " + t1 + ".k = " + t2 + ".k " + t2);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
 * SPDX-License-Identifier: Apache-2.0
    public void testJoinAcrossManyShardsAndNodes() throws Exception {
            );
    private static void assertColumns(PPLResponse response, String... expected) {
     * <ul>
     *   <li>Each overlap key appears exactly DUPES times.</li>
        for (Object[] row : response.getRows()) {
            org.opensearch.action.bulk.BulkResponse response = bulk.get();  
import org.opensearch.composite.CompositeDataFormatPlugin;
    }  
            int key = ((Number) row[kIdx]).intValue();
            .prepareCreate(indexName)
 *   <li>Single-shard degenerate case (one side SINGLETON, the other RANDOM).</li>
            .indices()  
 * <ul>
        for (int key = keyLo; key <= keyHi; key++) {  
 */  
    }  
        try {
        } finally {  
 * Scale + edge-case suite for the coordinator-side hash join path: 3 data nodes,
     * regressions where the lock-free {@code feed(int, batch)} path or the
    // ── Edge case #5: large data with sustained streaming ────────────────
        return List.of(TestPPLPlugin.class, FlightStreamPlugin.class, CompositeDataFormatPlugin.class, LucenePlugin.class);
            assertFalse(
import java.util.Set;
     *  yet, so replicas can't be recovered. Fixed at 0 until that lands. */  
            for (int i = 0; i < N_QUERIES; i++) {
    // ── Edge case: self-join ─────────────────────────────────────────────
        final int OFFSET = NUM_KEYS / 3;  
 *   <li>Large data with sustained streaming throughput.</li>  
        String t1 = "join_mn_1shard_t1";
 * </ul>  
            false  
            // Best-effort cleanup; some scenarios may have already deleted their indices.  
            .build();
        client().admin().indices().prepareRefresh(indexName).get();  
 * into two registered partition streams) plus a battery of correctness edge cases
     * {@code OpenSearchExchangeReducer} insertion that the DAG builder relies on  
