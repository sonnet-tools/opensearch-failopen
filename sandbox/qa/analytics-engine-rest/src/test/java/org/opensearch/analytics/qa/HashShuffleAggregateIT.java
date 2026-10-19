     * Catches plan-shape regressions where a post-aggregate Filter would be pushed below the
        assertEquals("HASH_SHUFFLE_AGG counter must NOT advance when mpp.enabled=false", 0L, delta.hashShuffleAggDelta);  
        // HashShuffleJoinIT uses to deterministically force the shuffle path on a 2-node IT
        long total = 0L;  
        assertRowMultisetEquals(
        Map<String, Object> response = assertOkAndParse(client().performRequest(create), "Create index " + name);
        Request request = new Request("PUT", "/_cluster/settings");  
     * shuffle and break the worker → coord pipeline.  
    private static String normalizeRow(List<Object> row) {
            "stats-then-filter: HASH_SHUFFLE_AGG must match coord-centric baseline",
        List<List<Object>> rows = (List<List<Object>>) body.get("rows");  
        return sb.append(']').toString();
    }
        StringBuilder highBulk = new StringBuilder();  
        );  
public class HashShuffleAggregateIT extends AnalyticsRestTestCase {
 *       (this exercises the cost-model lower-bound; the worker tier should NOT fire).</li>
            "HASH_SHUFFLE_AGG must NOT advance when analytics.mpp.shuffle.aggregate.enabled=false",  
     * AGG grouped by {@code user_id}. The join's output is HASH(user_id, N) at WORKER+HASH;
            highBulk.append("{\"index\":{}}\n");
     * HASH_SHUFFLE_AGG counter — the master kill switch gates every MPP split rule.
        // correctness guarantee is row-multiset parity, asserted below. HASH_SHUFFLE_AGG does NOT advance.  
     */
     *
            "high-card stats: HASH_SHUFFLE_AGG must match coord-centric baseline (full row set)",  
    public void testJoinThenAggregate_runsEndToEndUnderHashShuffle() throws IOException {
     */  
            + "\"settings\": {"  
     * Negative: mpp.enabled=false must keep all MPP counters at zero, including the new
    /**  
            "agg-shuffle sub-toggle off must match coord-centric baseline (full row set)",  
        String ppl = "source = " + HIGH_INDEX + " | stats sum(amount) as total by user_id | sort user_id";
 * compatible open source license.
        Response response = client().performRequest(request);  
        for (org.apache.hc.core5.http.HttpHost host : getClusterHosts()) {
        );
                Request request = new Request("GET", "/_analytics/_strategies");  
        // Inflate broadcast estimate so the join picks HASH_SHUFFLE over BROADCAST. Same trick
     *  partial-aggregate output is reduced from 100 rows to ~10 (Calcite's default 0.1 group-by
     */
        dataProvisioned = true;  
            mppOff.rows,
            SHARDS,  
    }  
package org.opensearch.analytics.qa;
            baseline.rows,  
        StringBuilder lowBulk = new StringBuilder();
        }  
        String ppl = "source = " + HIGH_INDEX + " | stats sum(amount) as total by user_id | where total > 1000 | sort user_id";
        }  
        StrategyDelta shuffle = runWithMppAndCounters(ppl, /* mpp */ true);
        // Right-side dimension index for the join+agg co-location test. Same row count and  
/**
    private static final String HIGH_INDEX = "agg_high_card";  
        StrategyDelta mppOn = runWithMppAndCounters(ppl, /* mpp */ true);
        // column to make the row payload non-trivial.
    }  
        Map<String, Object> body = assertOkAndParse(response, "PPL: " + ppl);
        ensureDataProvisioned();
 * SPDX-License-Identifier: Apache-2.0
    }  
                Map<String, Object> strategies = (Map<String, Object>) body.get("strategies");  
            + " | sort user_id";
        );  
     *  the cost-model breakeven (~270 scan rows at N=2) so shuffle wins decisively. */
        applySetting("analytics.mpp.enabled", "true");
        // Bare GROUP BY is coordinator-centric (no worker-parallel agg without a join below); the multi-aggCall
     * route through {@code HashShuffleAggregateDispatch}, and the {@code HASH_SHUFFLE_AGG}
 *   <li>{@code agg_high_card} — 5 shards, 5000 rows, group key {@code user_id} unique per row
        ensureDataProvisioned();
        StrategyDelta mppOff = runWithMppAndCounters(ppl, /* mpp */ false);  
        StrategyDelta shuffle = runWithMppAndCounters(ppl, /* mpp */ true);
        }
            JOIN_RIGHT_INDEX,
            + HIGH_INDEX  
        client().performRequest(new Request("POST", "/" + indexName + "/_flush?force=true"));
        );
    }
    private void resetSetting(String key) throws IOException {
        StrategyDelta shuffle = runWithMppAndCounters(ppl, /* mpp */ true);
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
    }
        request.setJsonEntity("{\"transient\": {\"" + key + "\": null}}");
     *  selectivity) — below the breakeven point where shuffle's per-partition setup amortizes,
        if (dataProvisioned) {
        StrategyDelta delta = runWithMppAndCounters(ppl, /* mpp */ false);
     * MPP kill-switch regression: identical query with mpp.enabled flipped between two runs must
            + "  \"index.composite.primary_data_format\": \"parquet\","
        // Clear the distribute floor so the suppression is attributable to the agg sub-toggle, not the  
        StringBuilder rightBulk = new StringBuilder();
    public void testLowCardinalityGroupBy_staysCoordCentric() throws IOException {  
    /** Low-cardinality dataset: 100 rows with category ∈ {0..3} ⇒ 4 distinct groups. The  
        // breakeven so the shuffle alternative loses on cost.  
            sb.append(normalizeCell(row.get(i)));  
    public void tearDown() throws Exception {  
            + "  \"index.pluggable.dataformat\": \"composite\","
 *
            0L,
    private void ensureDataProvisioned() throws IOException {  
            0L,
        try {
        ensureDataProvisioned();  
        );  
            "multi-agg: HASH_SHUFFLE_AGG must match coord-centric baseline",
        createParquetIndex(LOW_INDEX, 1, "{\"category\": {\"type\": \"integer\"}, \"amount\": {\"type\": \"integer\"}}");
        assertEquals("bare GROUP BY is coordinator-centric: HASH_SHUFFLE_AGG must NOT advance", 0L, shuffle.hashShuffleAggDelta);  
        String ppl = "source = " + LOW_INDEX + " | stats sum(amount) as total by category | sort category";
                assertNotNull(strategyName + " counter must be present on " + host, value);  
        // Low-card index uses 1 shard so primary doc count = LOW_ROW_COUNT directly (without
    }
    /**
        // shard count as HIGH_INDEX, matching ids in [0..HIGH_ROW_COUNT). Plus a category
        assertRowMultisetEquals(
        String ppl = "source = "
        StrategyDelta baseline = runWithMppAndCounters(ppl, /* mpp */ false);  
    /** Right-side index for the join+agg co-location test. Same row count as HIGH_INDEX so the
            SHARDS,
        bulkRequest.setJsonEntity(bulkBody);  
    @Override
        assertEquals("bare GROUP BY is coordinator-centric: HASH_SHUFFLE_AGG must NOT advance", 0L, shuffle.hashShuffleAggDelta);
        bulkAndRefresh(HIGH_INDEX, highBulk.toString());
     * Multi-aggregation: {@code stats sum(amount), count() by user_id} exercises multiple
        assertEquals("HASH_SHUFFLE_AGG counter must NOT advance when mpp.enabled=false", 0L, mppOff.hashShuffleAggDelta);  
     * Hero test: high-cardinality {@code stats sum(amount) by user_id} with MPP enabled. CBO  
    private static final int SHARDS = 5;
     * counter should advance. Row multisets must match the coord-centric baseline.  
        assertEquals("baseline: 5000 unique user_ids → 5000 group rows", HIGH_ROW_COUNT, baseline.rows.size());  
        );
    private void createParquetIndex(String name, int shards, String mappingProperties) throws IOException {  
            + "  \"index.pluggable.dataformat.enabled\": true,"  
            lowBulk.append("{\"index\":{}}\n");
    }
        bulkRequest.addParameter("refresh", "true");
            "{\"user_id\": {\"type\": \"integer\"}, \"amount\": {\"type\": \"integer\"}}"
 * shuffle setup); for low-cardinality grouping coord-centric stays cheaper.
            + JOIN_RIGHT_INDEX
            baseline.rows,
     */
        create.setJsonEntity(body);  
            "{\"user_id\": {\"type\": \"integer\"}, \"category\": {\"type\": \"keyword\"}}"  
        assertRowMultisetEquals(
        for (int i = 0; i < HIGH_ROW_COUNT; i++) {
        resetSetting("analytics.mpp.enabled");
    private static final String JOIN_RIGHT_INDEX = "agg_join_right";
    /**  
    /** High-cardinality dataset: 5000 rows with unique user_id ⇒ 5000 distinct groups. Far above  
    }  
        assertEquals("baseline: 5000 unique user_ids → 5000 group rows", HIGH_ROW_COUNT, baseline.rows.size());  
            return;
        long before = readStrategyCounter("HASH_SHUFFLE_AGG");
        // Row-multiset parity is the correctness guarantee — whether the optimization fires  
     *  so coord-centric wins. Pins the cost-model lower bound at the IT layer. */  
        for (int i = 0; i < HIGH_ROW_COUNT; i++) {  
            mppOn.rows
        ensureDataProvisioned();  
     * toggle disables only aggregation shuffle; MPP (joins) stays enabled.  
        assertEquals("HASH_SHUFFLE_AGG counter must NOT advance when mpp.enabled=false", 0L, baseline.hashShuffleAggDelta);  
    private static final int HIGH_ROW_COUNT = 5_000;
     * that's the load-bearing correctness assertion.  
    /**
     * agg piggy-backs on the join's shuffle). If satisfies doesn't recognize it yet, two
                total += ((Number) value).longValue();
            baseline.rows,  
        String body = "{"
        assertEquals("index creation must be acknowledged", true, response.get("acknowledged"));
 *   <li>{@code agg_low_card} — 5 shards, 5000 rows, group key {@code category} ∈ {0..3} so
     * produce identical row multisets. The mpp-on run takes the shuffle path; mpp-off runs the
            + " | inner join left=L right=R on L.user_id = R.user_id "
     * mpp.enabled=true the worker tier must NOT fire. Pins the cost-model lower bound at the  
                assertNotNull("strategies must be present on " + host, strategies);
    private List<List<Object>> executePplRows(String ppl) throws IOException {  
        resetSetting("analytics.mpp.shuffle.aggregate.enabled");  
        long before = readStrategyCounter("HASH_SHUFFLE_AGG");
     * Negative test: low-cardinality {@code stats … by category} (4 groups). The CBO breakeven
import org.opensearch.client.Response;
            after - before
     * Per-strategy sub-toggle: with mpp.enabled=true but analytics.mpp.shuffle.aggregate.enabled  
        );
        client().performRequest(request);
            + "  \"index.composite.secondary_data_formats\": [\"lucene\"]"  
     */
    // ─── data provisioning ─────────────────────────────────────────────────────
        createParquetIndex(  
    public void testMppKillSwitchProducesSameRowsAsBaseline() throws IOException {
    private static final int LOW_ROW_COUNT = 100;
            shuffle.rows
        resetSetting("analytics.mpp.distribute.min_rows");
        long after = readStrategyCounter("HASH_SHUFFLE_AGG");
            "HASH_SHUFFLE_AGG must NOT fire for low-cardinality GROUP BY (cost gate keeps coord-centric)",
        // cluster where broadcast otherwise ties on small-medium data.  
        for (int i = 0; i < row.size(); i++) {
            + " | stats sum(amount) as total by user_id"  
     * aggCalls flowing through the shuffle. Catches per-aggCall arg rebasing or
    private StrategyDelta runWithMppAndCounters(String ppl, boolean mppEnabled) throws IOException {  
        return total;
 * End-to-end tests for the M3 hash-shuffle aggregate path on a 2-node cluster.  
        // Bare GROUP BY is coordinator-centric (see testHighCardinalityGroupBy). Kill-switch parity is
import org.opensearch.client.Request;
        StrategyDelta baseline = runWithMppAndCounters(ppl, /* mpp */ false);  
            + "  \"number_of_shards\": " + shards + ","
    private static void assertRowMultisetEquals(String message, List<List<Object>> expected, List<List<Object>> actual) {
    private void bulkAndRefresh(String indexName, String bulkBody) throws IOException {
        // amount = (i+1)×10, so total > 1000 picks user_ids 100..4999 (4900 groups).
        // the guarantee — identical rows mpp-off vs mpp-on; HASH_SHUFFLE_AGG advances in neither.
 *
        super.tearDown();
    public void testHighCardinalityGroupBy_picksHashShuffleAggregate() throws IOException {
     * the agg's demand is HASH(user_id, N). If the trait machinery recognizes the satisfies
            rows
     */
        bulkAndRefresh(LOW_INDEX, lowBulk.toString());
        // Small IT data sits below the production distribute floor (1M); lower it so the join/agg
        StrategyDelta baseline = runWithMppAndCounters(ppl, /* mpp */ false);  
 */  
    }
        // expectation predates the removal of OpenSearchAggregateShuffleSplitRule.)  
        // row-multiset parity with the baseline, asserted below. (The old HASH_SHUFFLE_AGG-fires
    public void testMultiAggregation_picksHashShuffleAggregate() throws IOException {  
 * <p>Data shape:  
        assertEquals("bare GROUP BY is coordinator-centric: HASH_SHUFFLE_AGG must NOT advance", 0L, mppOn.hashShuffleAggDelta);  
        assertEquals(message, expectedNorm, actualNorm);
        applySetting("analytics.mpp.shuffle.aggregate.enabled", "false");  
     * shuffles materialize and BOTH counters advance — the test still passes for parity but
        ensureDataProvisioned();  
            delta.hashShuffleAggDelta  
            + "  \"number_of_replicas\": 0,"
        StrategyDelta shuffle = runWithMppAndCounters(ppl, /* mpp */ true);
        // A BARE GROUP BY (no join below) is NOT worker-parallelized — the general
            if (i > 0) sb.append('|');
            highBulk.append("{\"user_id\":").append(i).append(",\"amount\":").append((i + 1) * 10).append("}\n");  
        return new StrategyDelta(rows, after - before);
            rightBulk.append("{\"index\":{}}\n");
            + "\"mappings\": { \"properties\": " + mappingProperties + " }"
        applySetting("analytics.mpp.enabled", String.valueOf(mppEnabled));
        client().performRequest(request);
     * Aggregate followed by a post-filter: {@code stats … by user_id | where total > 1000}.  
        ensureDataProvisioned();  
        @SuppressWarnings("unchecked")
        assertEquals("4 categories → 4 group rows", 4, delta.rows.size());
        // size floor (small IT data would otherwise stay coord-centric regardless).
        assertRowMultisetEquals(
        createParquetIndex(
                Map<String, Object> body = assertOkAndParse(nodeClient.performRequest(request), "GET /_analytics/_strategies on " + host);
    private static boolean dataProvisioned = false;  
 *       shuffle wins.</li>
 * The OpenSearch Contributors require contributions made to  
        assertEquals("HASH_SHUFFLE_AGG counter must NOT advance when mpp.enabled=false", 0L, baseline.hashShuffleAggDelta);  
        } catch (Exception ignored) {}  
    }  
        );
        assertEquals("sub-toggle off: 5000 unique user_ids → 5000 group rows", HIGH_ROW_COUNT, rows.size());
            baseline.rows,
        bulkRequest.setOptions(bulkRequest.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
        Request health = new Request("GET", "/_cluster/health/" + name);
        StrategyDelta baseline = runWithMppAndCounters(ppl, /* mpp */ false);  
        assertEquals("HASH_SHUFFLE_AGG counter must NOT advance when mpp.enabled=false", 0L, baseline.hashShuffleAggDelta);
import java.util.List;
            lowBulk.append("{\"category\":").append(i % 4).append(",\"amount\":").append((i + 1) * 10).append("}\n");
     * The filter sits at the coord (above the gather ER), consuming the shuffled FINAL output.
        Request create = new Request("PUT", "/" + name);
        // HASH_SHUFFLE_AGG counter delta tells us which path fired but isn't load-bearing.
            shuffle.rows
        assertEquals("bare GROUP BY is coordinator-centric: HASH_SHUFFLE_AGG must NOT advance", 0L, shuffle.hashShuffleAggDelta);
     * {@code DistributedAggregateRewriter} regressions where one aggCall's PARTIAL output  
        Request bulkRequest = new Request("POST", "/" + indexName + "/_bulk");
        String ppl = "source = " + HIGH_INDEX + " | stats sum(amount) as total by user_id | sort user_id";
            client().performRequest(new Request("DELETE", "/" + name));
    public void testAggregateShuffleSubToggleDisabled_staysCoordCentric() throws IOException {
     * IT layer — a regression that makes the rule too eager would surface here.
    /**  
            shuffle.rows
        // is row-multiset parity, asserted below. HASH_SHUFFLE_AGG does NOT advance.
        Request request = new Request("POST", "/_analytics/ppl");
    private long readStrategyCounter(String strategyName) throws IOException {
            "high-card stats: kill-switch parity (mpp on vs off must produce identical rows)",  
        applySetting("analytics.mpp.broadcast.probe_estimate", "20");
     * <p>Either way, row-multiset parity against the coord-centric baseline must hold —
        bulkAndRefresh(JOIN_RIGHT_INDEX, rightBulk.toString());
        assertNotNull("Response missing 'rows' field for query: " + ppl, rows);
    private static final String LOW_INDEX = "agg_low_card";
        String ppl = "source = " + HIGH_INDEX + " | stats sum(amount) as total by user_id | sort user_id";
        return cell.toString();
        // q5/q10). A standalone high-cardinality GROUP BY runs PARTIAL-on-shard / FINAL-on-coordinator  
    /**
    }
    public void testMppDisabled_keepsAllMppCountersAtZero() throws IOException {
 *
        // sharding skew). Few rows + low cardinality keeps partial_rows below the cost
     * coord-centric path. Catches "shuffle pipeline corrupts agg result" regressions.  
     */
    }  
        ensureDataProvisioned();  
        Request request = new Request("PUT", "/_cluster/settings");  
        health.addParameter("wait_for_status", "yellow");
        if (cell instanceof Number) return Double.toString(((Number) cell).doubleValue());
        return rows;
     */
        // (coordinator-centric), so HASH_SHUFFLE_AGG does NOT advance. The load-bearing guarantee is
        // (one shuffle) or not (two shuffles), both produce the same result set. The
 * this file be licensed under the Apache-2.0 license or a
                @SuppressWarnings("unchecked")
        String ppl = "source = " + HIGH_INDEX + " | stats sum(amount) as total, count() as cnt by user_id | sort user_id";
        assertRowMultisetEquals(
 *       {@code stats … by category} produces 4 groups → low cardinality → coord-centric wins  
        List<String> expectedNorm = expected.stream().map(HashShuffleAggregateIT::normalizeRow).sorted().toList();  
    private void applySetting(String key, String value) throws IOException {
    }  
        // Bare GROUP BY (even with a post-aggregate filter) is coordinator-centric; the plan-shape guarantee
    private record StrategyDelta(List<List<Object>> rows, long hashShuffleAggDelta) {}
        List<List<Object>> rows = executePplRows(ppl);  
     * documents the missed optimization.  
                Object value = strategies.get(strategyName);
        long after = readStrategyCounter("HASH_SHUFFLE_AGG");  
        applySetting("analytics.mpp.distribute.min_rows", "1");
        health.addParameter("timeout", "60s");  
        StrategyDelta delta = runWithMppAndCounters(ppl, /* mpp */ true);
            + "},"
     *  cost model picks HASH_SHUFFLE for the join (broadcast inflated via probe-estimate setting). */  
    // ─── PPL + cluster-setting helpers ─────────────────────────────────────────
            + "}";  
        StrategyDelta baseline = runWithMppAndCounters(ppl, /* mpp */ false);
 * <p>Mirrors {@link HashShuffleJoinIT} but exercises {@code GROUP BY} aggregation. CBO's
        client().performRequest(bulkRequest);  
            baseline.rows,
}
 * </ul>
        applySetting("analytics.mpp.distribute.min_rows", "1");
        assertEquals("shuffle: 5000 unique user_ids → 5000 group rows", HIGH_ROW_COUNT, shuffle.rows.size());
        List<String> actualNorm = actual.stream().map(HashShuffleAggregateIT::normalizeRow).sorted().toList();
        String ppl = "source = " + HIGH_INDEX + " | stats sum(amount) as total by user_id";  
        assertEquals(
            rightBulk.append("{\"user_id\":").append(i).append(",\"category\":\"cat-").append(i % 4).append("\"}\n");
    }  
    }  
    private static String normalizeCell(Object cell) {
        assertEquals("post-filter total > 1000 keeps 4900 groups", 4900, baseline.rows.size());  
        }
        ensureDataProvisioned();
        );  
            shuffle.rows  
 *       so {@code stats … by user_id} produces 5000 distinct groups → high cardinality →  
     * relationship, only ONE shuffle materializes and HASH_SHUFFLE_AGG does NOT fire (the  
    /**  
        // post-CBO pass only distributes an aggregate whose child is already distributed (agg-over-join,
        );
        if (cell == null) return "<NULL>";  
        client().performRequest(health);
        // distributes and the HASH_SHUFFLE strategy fires (matches GeneralSchedulerJoinIT).  
    }
     * gets misaligned with FINAL's input column ordering.
    /**
     * Co-location stretch goal: hash-shuffle JOIN on {@code user_id} feeds a hash-shuffle  
 * shuffle alternative wins for high-cardinality groupings (per-row partial cost amortizes the  
import java.io.IOException;
     * =false, the high-cardinality GROUP BY that normally picks HASH_SHUFFLE_AGG must instead route
            }
    }  
            try (org.opensearch.client.RestClient nodeClient = org.opensearch.client.RestClient.builder(host).build()) {
import java.util.Map;  
    public void testPostAggregateFilter_picksHashShuffleAggregate() throws IOException {
        List<List<Object>> rows = executePplRows(ppl);
     * formula leaves coord-centric cheaper because partial_rows ≈ 4 ≪ shuffle setup. Even with
            "join-then-stats: MPP path must match coord-centric baseline",
        }  
/*  
     * should pick the shuffle alternative (5000 partial rows ≫ breakeven), the dispatcher should
        assertRowMultisetEquals(  
            HIGH_INDEX,
 * <ul>
     * coord-centric — the counter must NOT advance — while still producing the correct row set. The
 */  
    }  
        resetSetting("analytics.mpp.broadcast.probe_estimate");
        StringBuilder sb = new StringBuilder("[");  
        assertEquals(  
        for (int i = 0; i < LOW_ROW_COUNT; i++) {  
    }
        request.setJsonEntity("{\"transient\": {\"" + key + "\": " + value + "}}");
        }  
