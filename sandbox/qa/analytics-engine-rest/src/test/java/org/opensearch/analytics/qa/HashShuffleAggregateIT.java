                @SuppressWarnings("unchecked")
    }
     *  partial-aggregate output is reduced from 100 rows to ~10 (Calcite's default 0.1 group-by
        assertEquals("4 categories → 4 group rows", 4, delta.rows.size());
            baseline.rows,
        if (dataProvisioned) {
 * End-to-end tests for the M3 hash-shuffle aggregate path on a 2-node cluster.
    public void testJoinThenAggregate_runsEndToEndUnderHashShuffle() throws IOException {
}
    private static final String LOW_INDEX = "agg_low_card";
        assertEquals("HASH_SHUFFLE_AGG counter must NOT advance when mpp.enabled=false", 0L, baseline.hashShuffleAggDelta);
        }
     *  selectivity) — below the breakeven point where shuffle's per-partition setup amortizes,
    }
            highBulk.append("{\"user_id\":").append(i).append(",\"amount\":").append((i + 1) * 10).append("}\n");
        applySetting("analytics.mpp.shuffle.aggregate.enabled", "false");
        List<String> expectedNorm = expected.stream().map(HashShuffleAggregateIT::normalizeRow).sorted().toList();
        bulkRequest.setOptions(bulkRequest.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
        Map<String, Object> response = assertOkAndParse(client().performRequest(create), "Create index " + name);
        // correctness guarantee is row-multiset parity, asserted below. HASH_SHUFFLE_AGG does NOT advance.
     */
            shuffle.rows
    }
        assertEquals("baseline: 5000 unique user_ids → 5000 group rows", HIGH_ROW_COUNT, baseline.rows.size());
        bulkRequest.addParameter("refresh", "true");
            "high-card stats: HASH_SHUFFLE_AGG must match coord-centric baseline (full row set)",
    private static final int SHARDS = 5;
        // post-CBO pass only distributes an aggregate whose child is already distributed (agg-over-join,
        @SuppressWarnings("unchecked")
        StringBuilder lowBulk = new StringBuilder();
        List<List<Object>> rows = (List<List<Object>>) body.get("rows");
        ensureDataProvisioned();
        // HASH_SHUFFLE_AGG counter delta tells us which path fired but isn't load-bearing.
            0L,
     * route through {@code HashShuffleAggregateDispatch}, and the {@code HASH_SHUFFLE_AGG}
        Map<String, Object> body = assertOkAndParse(response, "PPL: " + ppl);
    public void testPostAggregateFilter_picksHashShuffleAggregate() throws IOException {
        request.setJsonEntity("{\"transient\": {\"" + key + "\": " + value + "}}");
        return rows;
            mppOff.rows,
    private List<List<Object>> executePplRows(String ppl) throws IOException {
 *       (this exercises the cost-model lower-bound; the worker tier should NOT fire).</li>
    /**
    public void testMppDisabled_keepsAllMppCountersAtZero() throws IOException {
        String ppl = "source = "
        assertEquals("index creation must be acknowledged", true, response.get("acknowledged"));
    private void ensureDataProvisioned() throws IOException {
        assertEquals(
        Response response = client().performRequest(request);
        assertEquals("HASH_SHUFFLE_AGG counter must NOT advance when mpp.enabled=false", 0L, mppOff.hashShuffleAggDelta);
     *  so coord-centric wins. Pins the cost-model lower bound at the IT layer. */
     * that's the load-bearing correctness assertion.
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
 * <ul>
 *       {@code stats … by category} produces 4 groups → low cardinality → coord-centric wins
        ensureDataProvisioned();
/**
 */
        assertRowMultisetEquals(
 * <p>Mirrors {@link HashShuffleJoinIT} but exercises {@code GROUP BY} aggregation. CBO's
        }
        for (org.apache.hc.core5.http.HttpHost host : getClusterHosts()) {
            HIGH_INDEX,
    }
        assertEquals("shuffle: 5000 unique user_ids → 5000 group rows", HIGH_ROW_COUNT, shuffle.rows.size());
            SHARDS,
     */
     * {@code DistributedAggregateRewriter} regressions where one aggCall's PARTIAL output
        applySetting("analytics.mpp.broadcast.probe_estimate", "20");
                Map<String, Object> strategies = (Map<String, Object>) body.get("strategies");
    }
        assertEquals("HASH_SHUFFLE_AGG counter must NOT advance when mpp.enabled=false", 0L, baseline.hashShuffleAggDelta);
 * The OpenSearch Contributors require contributions made to
            baseline.rows,
        StrategyDelta baseline = runWithMppAndCounters(ppl, /* mpp */ false);
        Request bulkRequest = new Request("POST", "/" + indexName + "/_bulk");
 *   <li>{@code agg_low_card} — 5 shards, 5000 rows, group key {@code category} ∈ {0..3} so
     */
        for (int i = 0; i < LOW_ROW_COUNT; i++) {
    }
 * compatible open source license.
    private static boolean dataProvisioned = false;
    // ─── data provisioning ─────────────────────────────────────────────────────
    public void testLowCardinalityGroupBy_staysCoordCentric() throws IOException {
        String ppl = "source = " + HIGH_INDEX + " | stats sum(amount) as total by user_id | sort user_id";
        return total;
        // Low-card index uses 1 shard so primary doc count = LOW_ROW_COUNT directly (without
        String ppl = "source = " + HIGH_INDEX + " | stats sum(amount) as total by user_id | where total > 1000 | sort user_id";
        );
            "high-card stats: kill-switch parity (mpp on vs off must produce identical rows)",
        ensureDataProvisioned();
        // (coordinator-centric), so HASH_SHUFFLE_AGG does NOT advance. The load-bearing guarantee is
            rightBulk.append("{\"user_id\":").append(i).append(",\"category\":\"cat-").append(i % 4).append("\"}\n");
        assertEquals("post-filter total > 1000 keeps 4900 groups", 4900, baseline.rows.size());
        // shard count as HIGH_INDEX, matching ids in [0..HIGH_ROW_COUNT). Plus a category
        applySetting("analytics.mpp.distribute.min_rows", "1");
        StringBuilder sb = new StringBuilder("[");
            + " | sort user_id";
                Object value = strategies.get(strategyName);
        assertRowMultisetEquals(
        List<String> actualNorm = actual.stream().map(HashShuffleAggregateIT::normalizeRow).sorted().toList();
            + "  \"number_of_shards\": " + shards + ","
        ensureDataProvisioned();
            + "}";
        StrategyDelta shuffle = runWithMppAndCounters(ppl, /* mpp */ true);
        // expectation predates the removal of OpenSearchAggregateShuffleSplitRule.)
    public void testMppKillSwitchProducesSameRowsAsBaseline() throws IOException {
        long before = readStrategyCounter("HASH_SHUFFLE_AGG");
            "{\"user_id\": {\"type\": \"integer\"}, \"amount\": {\"type\": \"integer\"}}"
        long after = readStrategyCounter("HASH_SHUFFLE_AGG");
    /**
    /** High-cardinality dataset: 5000 rows with unique user_id ⇒ 5000 distinct groups. Far above
            SHARDS,
        String ppl = "source = " + HIGH_INDEX + " | stats sum(amount) as total, count() as cnt by user_id | sort user_id";
        );
        assertEquals("bare GROUP BY is coordinator-centric: HASH_SHUFFLE_AGG must NOT advance", 0L, mppOn.hashShuffleAggDelta);
import java.util.List;
     * formula leaves coord-centric cheaper because partial_rows ≈ 4 ≪ shuffle setup. Even with
        applySetting("analytics.mpp.distribute.min_rows", "1");
    private void applySetting(String key, String value) throws IOException {
        assertEquals("baseline: 5000 unique user_ids → 5000 group rows", HIGH_ROW_COUNT, baseline.rows.size());
        } catch (Exception ignored) {}
        ensureDataProvisioned();
     */
     * mpp.enabled=true the worker tier must NOT fire. Pins the cost-model lower bound at the
        );
        client().performRequest(new Request("POST", "/" + indexName + "/_flush?force=true"));
        bulkAndRefresh(JOIN_RIGHT_INDEX, rightBulk.toString());
            }
        if (cell instanceof Number) return Double.toString(((Number) cell).doubleValue());
    private static final int HIGH_ROW_COUNT = 5_000;
                total += ((Number) value).longValue();
        assertEquals("bare GROUP BY is coordinator-centric: HASH_SHUFFLE_AGG must NOT advance", 0L, shuffle.hashShuffleAggDelta);
 *   <li>{@code agg_high_card} — 5 shards, 5000 rows, group key {@code user_id} unique per row
            "{\"user_id\": {\"type\": \"integer\"}, \"category\": {\"type\": \"keyword\"}}"
        // HashShuffleJoinIT uses to deterministically force the shuffle path on a 2-node IT
        client().performRequest(bulkRequest);
    private static final String JOIN_RIGHT_INDEX = "agg_join_right";
     * Aggregate followed by a post-filter: {@code stats … by user_id | where total > 1000}.
            "HASH_SHUFFLE_AGG must NOT advance when analytics.mpp.shuffle.aggregate.enabled=false",
            baseline.rows,
        StrategyDelta baseline = runWithMppAndCounters(ppl, /* mpp */ false);
            "multi-agg: HASH_SHUFFLE_AGG must match coord-centric baseline",
        }
            + "\"settings\": {"
     * shuffles materialize and BOTH counters advance — the test still passes for parity but
    }
            + "  \"index.pluggable.dataformat\": \"composite\","
     * the agg's demand is HASH(user_id, N). If the trait machinery recognizes the satisfies
    public void tearDown() throws Exception {
 *       shuffle wins.</li>
        client().performRequest(health);
     * =false, the high-cardinality GROUP BY that normally picks HASH_SHUFFLE_AGG must instead route
 * this file be licensed under the Apache-2.0 license or a
            mppOn.rows
        StringBuilder rightBulk = new StringBuilder();
    private long readStrategyCounter(String strategyName) throws IOException {
        Request health = new Request("GET", "/_cluster/health/" + name);
package org.opensearch.analytics.qa;
        String ppl = "source = " + HIGH_INDEX + " | stats sum(amount) as total by user_id | sort user_id";
        String ppl = "source = " + LOW_INDEX + " | stats sum(amount) as total by category | sort category";
        }
        createParquetIndex(
     *  cost model picks HASH_SHUFFLE for the join (broadcast inflated via probe-estimate setting). */
            "join-then-stats: MPP path must match coord-centric baseline",
     * aggCalls flowing through the shuffle. Catches per-aggCall arg rebasing or
        // cluster where broadcast otherwise ties on small-medium data.
    private static void assertRowMultisetEquals(String message, List<List<Object>> expected, List<List<Object>> actual) {
     * HASH_SHUFFLE_AGG counter — the master kill switch gates every MPP split rule.
        StrategyDelta baseline = runWithMppAndCounters(ppl, /* mpp */ false);
        createParquetIndex(
        ensureDataProvisioned();
     * AGG grouped by {@code user_id}. The join's output is HASH(user_id, N) at WORKER+HASH;
            highBulk.append("{\"index\":{}}\n");
     * MPP kill-switch regression: identical query with mpp.enabled flipped between two runs must
import org.opensearch.client.Response;
    /**
        // distributes and the HASH_SHUFFLE strategy fires (matches GeneralSchedulerJoinIT).
        return new StrategyDelta(rows, after - before);
    private static final int LOW_ROW_COUNT = 100;
        // A BARE GROUP BY (no join below) is NOT worker-parallelized — the general
        ensureDataProvisioned();
        assertRowMultisetEquals(
    }
        assertNotNull("Response missing 'rows' field for query: " + ppl, rows);
        String ppl = "source = " + HIGH_INDEX + " | stats sum(amount) as total by user_id";
            + JOIN_RIGHT_INDEX
        Request create = new Request("PUT", "/" + name);
        List<List<Object>> rows = executePplRows(ppl);
        // Row-multiset parity is the correctness guarantee — whether the optimization fires
            delta.hashShuffleAggDelta
        }
        bulkAndRefresh(HIGH_INDEX, highBulk.toString());
            + " | stats sum(amount) as total by user_id"
        // column to make the row payload non-trivial.
            shuffle.rows
        StrategyDelta delta = runWithMppAndCounters(ppl, /* mpp */ false);
        // Bare GROUP BY (even with a post-aggregate filter) is coordinator-centric; the plan-shape guarantee
        StrategyDelta mppOn = runWithMppAndCounters(ppl, /* mpp */ true);
        applySetting("analytics.mpp.enabled", "true");
    /**
public class HashShuffleAggregateIT extends AnalyticsRestTestCase {
 */
        long after = readStrategyCounter("HASH_SHUFFLE_AGG");
            + "\"mappings\": { \"properties\": " + mappingProperties + " }"
    private StrategyDelta runWithMppAndCounters(String ppl, boolean mppEnabled) throws IOException {
        for (int i = 0; i < HIGH_ROW_COUNT; i++) {
     * Multi-aggregation: {@code stats sum(amount), count() by user_id} exercises multiple
            + "  \"number_of_replicas\": 0,"
 *
    }
 * <p>Data shape:
     *
    private record StrategyDelta(List<List<Object>> rows, long hashShuffleAggDelta) {}
            "stats-then-filter: HASH_SHUFFLE_AGG must match coord-centric baseline",
    /**
 *
        List<List<Object>> rows = executePplRows(ppl);
        assertEquals(message, expectedNorm, actualNorm);
        resetSetting("analytics.mpp.distribute.min_rows");
            rightBulk.append("{\"index\":{}}\n");
        // Inflate broadcast estimate so the join picks HASH_SHUFFLE over BROADCAST. Same trick
     * Catches plan-shape regressions where a post-aggregate Filter would be pushed below the
            + " | inner join left=L right=R on L.user_id = R.user_id "
        assertRowMultisetEquals(
        StrategyDelta shuffle = runWithMppAndCounters(ppl, /* mpp */ true);
    private void resetSetting(String key) throws IOException {
    }
        );
        // size floor (small IT data would otherwise stay coord-centric regardless).
import org.opensearch.client.Request;
        resetSetting("analytics.mpp.shuffle.aggregate.enabled");
     * <p>Either way, row-multiset parity against the coord-centric baseline must hold —
 * shuffle alternative wins for high-cardinality groupings (per-row partial cost amortizes the
/*
            + "  \"index.composite.primary_data_format\": \"parquet\","
        long total = 0L;
    }
    }
                Request request = new Request("GET", "/_analytics/_strategies");
        StrategyDelta baseline = runWithMppAndCounters(ppl, /* mpp */ false);
        // Clear the distribute floor so the suppression is attributable to the agg sub-toggle, not the
    /** Right-side index for the join+agg co-location test. Same row count as HIGH_INDEX so the
    }
        ensureDataProvisioned();
     * Per-strategy sub-toggle: with mpp.enabled=true but analytics.mpp.shuffle.aggregate.enabled
        resetSetting("analytics.mpp.broadcast.probe_estimate");
            shuffle.rows
     * Negative test: low-cardinality {@code stats … by category} (4 groups). The CBO breakeven
        assertEquals("bare GROUP BY is coordinator-centric: HASH_SHUFFLE_AGG must NOT advance", 0L, shuffle.hashShuffleAggDelta);
     * toggle disables only aggregation shuffle; MPP (joins) stays enabled.
            lowBulk.append("{\"index\":{}}\n");
    private static String normalizeRow(List<Object> row) {
        assertRowMultisetEquals(
import java.io.IOException;
 * shuffle setup); for low-cardinality grouping coord-centric stays cheaper.
                assertNotNull(strategyName + " counter must be present on " + host, value);
            + "  \"index.pluggable.dataformat.enabled\": true,"
 *
        long before = readStrategyCounter("HASH_SHUFFLE_AGG");
        createParquetIndex(LOW_INDEX, 1, "{\"category\": {\"type\": \"integer\"}, \"amount\": {\"type\": \"integer\"}}");
     */
    }
    /** Low-cardinality dataset: 100 rows with category ∈ {0..3} ⇒ 4 distinct groups. The
        client().performRequest(request);
     * gets misaligned with FINAL's input column ordering.
        assertEquals(
        health.addParameter("wait_for_status", "yellow");
        StrategyDelta shuffle = runWithMppAndCounters(ppl, /* mpp */ true);
            + "  \"index.composite.secondary_data_formats\": [\"lucene\"]"
     * Negative: mpp.enabled=false must keep all MPP counters at zero, including the new
        // is row-multiset parity, asserted below. HASH_SHUFFLE_AGG does NOT advance.
        // Right-side dimension index for the join+agg co-location test. Same row count and
        StrategyDelta shuffle = runWithMppAndCounters(ppl, /* mpp */ true);
    private void createParquetIndex(String name, int shards, String mappingProperties) throws IOException {
        );
    // ─── PPL + cluster-setting helpers ─────────────────────────────────────────
        resetSetting("analytics.mpp.enabled");
                assertNotNull("strategies must be present on " + host, strategies);
        );
        StrategyDelta delta = runWithMppAndCounters(ppl, /* mpp */ true);
    }
    }
        bulkAndRefresh(LOW_INDEX, lowBulk.toString());
 *       so {@code stats … by user_id} produces 5000 distinct groups → high cardinality →
        // breakeven so the shuffle alternative loses on cost.
            shuffle.rows
            rows
     * counter should advance. Row multisets must match the coord-centric baseline.
            JOIN_RIGHT_INDEX,
        StrategyDelta baseline = runWithMppAndCounters(ppl, /* mpp */ false);
        // row-multiset parity with the baseline, asserted below. (The old HASH_SHUFFLE_AGG-fires
        Request request = new Request("PUT", "/_cluster/settings");
 * </ul>
    public void testHighCardinalityGroupBy_picksHashShuffleAggregate() throws IOException {
        // q5/q10). A standalone high-cardinality GROUP BY runs PARTIAL-on-shard / FINAL-on-coordinator
    private static final String HIGH_INDEX = "agg_high_card";
            try (org.opensearch.client.RestClient nodeClient = org.opensearch.client.RestClient.builder(host).build()) {
     * Hero test: high-cardinality {@code stats sum(amount) by user_id} with MPP enabled. CBO
        assertEquals("bare GROUP BY is coordinator-centric: HASH_SHUFFLE_AGG must NOT advance", 0L, shuffle.hashShuffleAggDelta);
     * coord-centric — the counter must NOT advance — while still producing the correct row set. The
     */
        applySetting("analytics.mpp.enabled", String.valueOf(mppEnabled));
    public void testMultiAggregation_picksHashShuffleAggregate() throws IOException {
        dataProvisioned = true;
     * shuffle and break the worker → coord pipeline.
     * coord-centric path. Catches "shuffle pipeline corrupts agg result" regressions.
     * IT layer — a regression that makes the rule too eager would surface here.
        if (cell == null) return "<NULL>";
        client().performRequest(request);
        for (int i = 0; i < row.size(); i++) {
            "HASH_SHUFFLE_AGG must NOT fire for low-cardinality GROUP BY (cost gate keeps coord-centric)",
        );
        assertEquals("sub-toggle off: 5000 unique user_ids → 5000 group rows", HIGH_ROW_COUNT, rows.size());
        }
     * agg piggy-backs on the join's shuffle). If satisfies doesn't recognize it yet, two
            "agg-shuffle sub-toggle off must match coord-centric baseline (full row set)",
    /**
            + "},"
    /**
     * produce identical row multisets. The mpp-on run takes the shuffle path; mpp-off runs the
    }
        for (int i = 0; i < HIGH_ROW_COUNT; i++) {
            0L,
        // (one shuffle) or not (two shuffles), both produce the same result set. The
        bulkRequest.setJsonEntity(bulkBody);
        // amount = (i+1)×10, so total > 1000 picks user_ids 100..4999 (4900 groups).
    }
            after - before
     * documents the missed optimization.
        assertRowMultisetEquals(
     * should pick the shuffle alternative (5000 partial rows ≫ breakeven), the dispatcher should
            return;
        // the guarantee — identical rows mpp-off vs mpp-on; HASH_SHUFFLE_AGG advances in neither.
     * relationship, only ONE shuffle materializes and HASH_SHUFFLE_AGG does NOT fire (the
     * Co-location stretch goal: hash-shuffle JOIN on {@code user_id} feeds a hash-shuffle
        // Bare GROUP BY is coordinator-centric (see testHighCardinalityGroupBy). Kill-switch parity is
     * The filter sits at the coord (above the gather ER), consuming the shuffled FINAL output.
        // sharding skew). Few rows + low cardinality keeps partial_rows below the cost
    private void bulkAndRefresh(String indexName, String bulkBody) throws IOException {
    }
    }
        // Bare GROUP BY is coordinator-centric (no worker-parallel agg without a join below); the multi-aggCall
     */
        try {
        Request request = new Request("POST", "/_analytics/ppl");
        );
        request.setJsonEntity("{\"transient\": {\"" + key + "\": null}}");
        StrategyDelta mppOff = runWithMppAndCounters(ppl, /* mpp */ false);
        StringBuilder highBulk = new StringBuilder();
        String body = "{"
        super.tearDown();
        );
        Request request = new Request("PUT", "/_cluster/settings");
            baseline.rows,
            if (i > 0) sb.append('|');
        assertEquals("HASH_SHUFFLE_AGG counter must NOT advance when mpp.enabled=false", 0L, baseline.hashShuffleAggDelta);
    public void testAggregateShuffleSubToggleDisabled_staysCoordCentric() throws IOException {
        create.setJsonEntity(body);
        health.addParameter("timeout", "60s");
        assertEquals("HASH_SHUFFLE_AGG counter must NOT advance when mpp.enabled=false", 0L, delta.hashShuffleAggDelta);
            client().performRequest(new Request("DELETE", "/" + name));
     *  the cost-model breakeven (~270 scan rows at N=2) so shuffle wins decisively. */
        // Small IT data sits below the production distribute floor (1M); lower it so the join/agg
            sb.append(normalizeCell(row.get(i)));
        return cell.toString();
import java.util.Map;
            lowBulk.append("{\"category\":").append(i % 4).append(",\"amount\":").append((i + 1) * 10).append("}\n");
    /**
        return sb.append(']').toString();
            baseline.rows,
                Map<String, Object> body = assertOkAndParse(nodeClient.performRequest(request), "GET /_analytics/_strategies on " + host);
     */
            + HIGH_INDEX
        );
    private static String normalizeCell(Object cell) {
    @Override
        String ppl = "source = " + HIGH_INDEX + " | stats sum(amount) as total by user_id | sort user_id";
 * SPDX-License-Identifier: Apache-2.0
