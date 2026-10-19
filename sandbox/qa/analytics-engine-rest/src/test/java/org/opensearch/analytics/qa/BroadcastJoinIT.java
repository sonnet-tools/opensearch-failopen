        client().performRequest(health);
            + DIM_INDEX
    /**
     */
     * The probe-side fragment is {@code Sort+Limit + Scan} — a sort-aware producer feeding the
    }
        create.setJsonEntity(body);
            + "\"settings\": {"
        if (dataProvisioned) {
            if (i > 0) sb.append('|');
        return Arrays.asList(values);
        health.addParameter("wait_for_status", "yellow");
        request.setJsonEntity("{\"transient\": {\"" + key + "\": null}}");
        for (int i = 0; i < row.size(); i++) {
 * <p>Cluster settings are reset to {@code null} (default) between tests so a failure in one
        Request request = new Request("PUT", "/_cluster/settings");
            + "  \"number_of_replicas\": 0,"
 * replicating the small side over shuffling both sides). Row multisets must match across the
        return 30;
    private void bulkAndRefresh(String indexName, String bulkBody) throws IOException {
        ensureDataProvisioned();
        // Use transient so a test failure doesn't leave a persistent setting on the cluster.
        // Flush so doc counts are committed and IndicesStats sees them.
 *
            + FACT_INDEX
        createParquetIndex(DIM_INDEX, DIM_SHARDS, "{\"id\": {\"type\": \"integer\"}, \"category\": {\"type\": \"keyword\"}}");
        applySetting("analytics.mpp.distribute.min_rows", "1");
     * broadcast — the assertion is row-multiset parity, not BROADCAST specifically.
        }
            + FACT_INDEX
        assertEquals(
    /**
    private void ensureDataProvisioned() throws IOException {
        Request create = new Request("PUT", "/" + name);
        // Strategy assertions — without this the IT would pass for ANY two M0 runs even with
 * SPDX-License-Identifier: Apache-2.0
            + " | inner join left=F right=D on F.id = D.id "
import org.opensearch.client.Request;
        bulkAndRefresh(DIM_INDEX, dimBulk.toString());
    // ─── data provisioning ─────────────────────────────────────────────────────
    public void testInnerEquiJoin_smallDimWithLargeFact_broadcastMatchesBaseline() throws IOException {
        @SuppressWarnings("unchecked")
     */
    public void tearDown() throws Exception {
    private static final Map<Integer, String> DIM_CATEGORIES = Map.of(
        StrategyDelta mppOnDelta = runWithMppAndStrategyDelta(ppl, true);
            factBulk.append("{\"id\":").append(id).append(",\"amount\":").append(amount).append("}\n");
    }
import java.util.Map;
    private static final int FACT_SHARDS = 5;
        );
            client().performRequest(new Request("DELETE", "/" + name));
        request.setJsonEntity("{\"transient\": {\"" + key + "\": " + value + "}}");
        assertCounterAdvanced("BROADCAST fires on at least one node when MPP is enabled", broadcastDelta.broadcastDelta);
            factBulk.append("{\"index\":{}}\n");
            + " | inner join left=F right=D on F.id = D.id "
     * collapses to one row; only ids 1..5 join through. Output cardinality drops from 25 (plain
import java.util.Arrays;
     * Reads {@code GET /_analytics/_strategies} from each node in the cluster and returns the
        StrategyDelta baselineDelta = runWithMppAndStrategyDelta(ppl, false);
    /**
    /** Maps {@code id} → category — used to assert join correctness deterministically. */
 */
     * Aggregate DOWNSTREAM of the join: {@code source=fact | join dim | stats sum(amount) by category}.
        // is enabled (and crucially, NOT when MPP is disabled).
     * <p>The aggregate shrinks the probe to ~6 rows, which makes broadcast no longer the
        // The first 10 fact rows by (id, amount) are: id=1×2, id=2×2, id=3×2, id=4×2, id=5×2.
public class BroadcastJoinIT extends AnalyticsRestTestCase {
            mppOnDelta.rows
            + " | inner join left=F right=D on F.id = D.id "
            + DIM_INDEX
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
                Map<String, Object> strategies = (Map<String, Object>) body.get("strategies");
 *       cost since it has more rows.</li>
        assertEquals("5 grouped fact rows × 1 dim match each = 5 output rows", 5, baselineDelta.rows.size());
            }
        assertEquals("first 10 sorted fact rows × matching dim = 10 output rows", 10, baselineDelta.rows.size());
            sb.append(normalizeCell(row.get(i)));
            baselineDelta.rows,
    }
        createParquetIndex(FACT_INDEX, FACT_SHARDS, "{\"id\": {\"type\": \"integer\"}, \"amount\": {\"type\": \"integer\"}}");
    private static final String FACT_INDEX = "bcast_fact";
        // results must match exactly.
            + "  \"index.composite.secondary_data_formats\": [\"lucene\"]"
     * inadvertently broken. The test asserts row-multiset parity between MPP off and MPP on
    /** Helper used by the runnable theta test. */
    /** Bundles a query's row output with the BROADCAST-counter delta observed around it. */
    }
 * this file be licensed under the Apache-2.0 license or a
     * obvious winner — CBO may pick coord-centric for the join itself. The assertion is
     * distribution traits only, and DataFusion picks {@code NestedLoopJoinExec} for the
     * deterministic (no joins under the sort, and the (id, amount) pair is unique across the
     * (kill-switch parity), and checks that BROADCAST does NOT fire (theta is ineligible).
    /**
        dataProvisioned = true;
        // BROADCAST silently broken. We require the BROADCAST counter to advance only when MPP
import java.io.IOException;
        assertRowMultisetEquals("INNER smallDim×largeFact: BROADCAST must match M0 baseline", baselineDelta.rows, broadcastDelta.rows);
            "INNER join-then-stats: BROADCAST must match coord-centric baseline",
 *   <li>{@code bcast_fact} — 5 shards, ~30 rows. Probe side; would dominate any hash-shuffle
            + " | sort F.id, D.id, F.amount | head 200";
     * INNER) to 5 — five {@code (id, total, category)} rows.
     * Apply MPP setting, snapshot the cluster-wide BROADCAST counter, run the PPL query, and
        // on two equally-broken runs (e.g. cartesian product).
        for (org.apache.hc.core5.http.HttpHost host : getClusterHosts()) {
        String ppl = "source = "
        // Small IT data sits below the production distribute floor (1M); lower it so the join actually
        health.addParameter("timeout", "60s");
        assertRowMultisetEquals("MPP kill switch must not change query results", killSwitchOff.rows, killSwitchOn.rows);
        client().performRequest(new Request("POST", "/" + indexName + "/_flush?force=true"));
     */
            + DIM_INDEX
     * BROADCAST to be eligible. Both runs must return the same rows including the LEFT-side
        List<List<Object>> rows = (List<List<Object>>) body.get("rows");
     * trivially pass for any pair of identical M0 runs.
        StrategyDelta mppOnDelta = runWithMppAndStrategyDelta(ppl, true);
     * across-nodes snapshot keeps the helper agnostic to which node the test client routes to.
        assertCounterAdvanced("MPP=true must dispatch BROADCAST for this eligible query", killSwitchOn.broadcastDelta);
        StrategyDelta broadcastDelta = runWithMppAndStrategyDelta(ppl, true);
 * <ul>
                Request request = new Request("GET", "/_analytics/_strategies");
        Map<String, Object> response = assertOkAndParse(client().performRequest(create), "Create index " + name);
    }
        long before = readBroadcastCounter();
        assertRowMultisetEquals(
    private void resetSetting(String key) throws IOException {
            mppOnDelta.rows
        assertRowMultisetEquals(
        String ppl = "source = "
     * rule no longer gates on {@code JoinInfo.isEqui()}, the split rule operates on
            + " | sort F.id, F.amount | head 100";
            + " | sort F.id, F.amount";
            + FACT_INDEX
        assertEquals("BROADCAST must not advance for theta with MPP on", 0L, mppOnDelta.broadcastDelta);
        }
        List<List<Object>> rows = executePplRows(ppl);
    private static int expectedFactRowCount() {
            dimBulk.append("{\"id\":").append(entry.getKey()).append(",\"category\":\"").append(entry.getValue()).append("\"}\n");
        client().performRequest(request);
    private static boolean dataProvisioned = false;
            "BROADCAST counter must NOT advance when MPP is disabled (kill switch path)",
                assertNotNull("BROADCAST counter must be present on " + host, value);
        bulkRequest.addParameter("refresh", "true");
    }
            + DIM_INDEX
     * the {@code AnalyticsSettings.MPP_ENABLED} wiring in {@code DefaultPlanExecutor}.
 */
     *
        // Theta is ineligible for any MPP strategy — both runs hit the coord-centric path,
            int id = (i % 6) + 1;
        return executePplRows(ppl);
     * <p>Pre-join sizes are unchanged from the hero test (30-row probe, 5-row dim) so BROADCAST
            baselineDelta.rows,
     * The probe-side fragment is now {@code Aggregate + Scan}, not just {@code Scan} — exercises
     */
    private static void assertCounterAdvanced(String message, long delta) {
        }
        if (cell instanceof Number) return Double.toString(((Number) cell).doubleValue());
                Map<String, Object> body = assertOkAndParse(nodeClient.performRequest(request), "GET /_analytics/_strategies on " + host);
        Request bulkRequest = new Request("POST", "/" + indexName + "/_bulk");
            + " | inner join left=F right=D on F.id = D.id "
    public void testThetaJoinRoutesToCoordinatorCentric() throws IOException {
    );
        Request request = new Request("PUT", "/_cluster/settings");
     *
     * Adds a final aggregate at the coordinator post-join. Validates that the broadcast-probe
    /**
        ensureDataProvisioned();
        // Same query, same data, just a different routing decision.
    public void testLeftOuterJoin_factWithDim_broadcastMatchesBaseline() throws IOException {
            return;
        assertEquals("BROADCAST must not advance for theta with MPP off", 0L, baselineDelta.broadcastDelta);
        return new StrategyDelta(rows, after - before);
     */
     */
        Request request = new Request("POST", "/_analytics/ppl");
    }
    private static List<Object> row(Object... values) {
        String ppl = "source = "
 * {@code GET /_analytics/_strategies} to prove the dispatcher actually ran the broadcast path
    }
    public void testMppKillSwitchProducesSameRowsAsBaseline() throws IOException {
        StringBuilder sb = new StringBuilder("[");
    private static void assertRowMultisetEquals(String message, List<List<Object>> expected, List<List<Object>> actual) {
        String ppl = "source = "
        try {
}
        applySetting("analytics.mpp.enabled", String.valueOf(mppEnabled));
 * The OpenSearch Contributors require contributions made to
    public void testInnerJoin_statsAfterJoin_broadcastMatchesBaseline() throws IOException {
     */
     * id=6 fact rows drop out, ids 1..5 each appear {@code (30 / 6) = 5} times.
        resetSetting("analytics.mpp.distribute.min_rows");
    private List<List<Object>> runWithMpp(String ppl, boolean mppEnabled) throws IOException {
    // ─── PPL + cluster-setting helpers ─────────────────────────────────────────
    }
    }
    }
                org.opensearch.client.RestClient nodeClient = org.opensearch.client.RestClient.builder(host).build()
     * LEFT OUTER preserves the left side, so the build MUST be the right (small dim) for
 * {@code analytics.mpp.enabled=true} (Volcano CBO picks BROADCAST when its cost model favors
    }
        // Small IT data sits below the production distribute floor (1M); lower it so the join actually
 *
 *       broadcasting it over hash-shuffling both sides.</li>
        client().performRequest(request);
        StrategyDelta baselineDelta = runWithMppAndStrategyDelta(ppl, false);
            + FACT_INDEX
     * counter advances by 1 per BROADCAST query regardless of node count, but using a sum-
            "INNER sortHead-then-join: MPP path must match coord-centric baseline",
     * return both the rows and the counter delta. The delta is summed across all data nodes
        assertEquals("baseline row count", expectedInnerJoinRowCount(), baselineDelta.rows.size());
     * Theta (non-equi) joins route to coordinator-centric execution under M2 — the marker
/**
            + " | left join left=F right=D on F.id = D.id "
     * 30-row dataset).
        // Every fact row appears at least once.
    private long readBroadcastCounter() throws IOException {
 * case can't leak state into the next.
        );
    /**
    }
        StrategyDelta mppOnDelta = runWithMppAndStrategyDelta(ppl, true);
        client().performRequest(bulkRequest);
     * Hero test: small dim × large fact INNER equi-join, parity between M0 (kill switch off)
     * MPP kill-switch regression: flipping {@code analytics.mpp.enabled} between runs of an
    /**
        // 5 fact ids match dim (id=6 has no dim row and is dropped).
            0L,
        assertCounterAdvanced("BROADCAST fires for LEFT OUTER when MPP is enabled", broadcastDelta.broadcastDelta);
    @SuppressWarnings("unused")
        assertCounterAdvanced("BROADCAST fires when MPP is enabled for join-then-stats", broadcastDelta.broadcastDelta);
import java.util.List;
    }
 * <p>The strategy here is A/B parity: every join query is executed twice on the same data,
        assertEquals("LEFT OUTER preserves all fact rows", expectedFactRowCount(), baselineDelta.rows.size());
            + " | sort F.id";
        bulkAndRefresh(FACT_INDEX, factBulk.toString());
 *
        // BROADCAST must NOT fire for theta in either run (broadcast requires equi).
import org.opensearch.client.Response;
        return cell.toString();
    /**
        assertEquals("MPP=false must route via coord-centric (BROADCAST counter = 0)", 0L, killSwitchOff.broadcastDelta);
                assertNotNull("strategies must be present on " + host, strategies);
        assertEquals(message, expectedNorm, actualNorm);
        // Independently sanity-check the baseline so the parity assertion can't trivially pass
        bulkRequest.setJsonEntity(bulkBody);
        // Kill-switch off forces COORDINATOR_CENTRIC dispatch even though the advisor would
     * {@code DefaultPlanExecutor} at the coordinator that handled the query); since the REST
    }
     */
                Object value = strategies.get("BROADCAST");
            + " | sort category";
        List<String> expectedNorm = expected.stream().map(BroadcastJoinIT::normalizeRow).sorted().toList();
        super.tearDown();
            + "  \"index.pluggable.dataformat\": \"composite\","
     * <p>Sort+head=10 reduces the probe input to 10 rows, so CBO may pick coord-centric over
        List<String> actualNorm = actual.stream().map(BroadcastJoinIT::normalizeRow).sorted().toList();
        1, "FURNITURE",
            baselineDelta.rows,
            + " | inner join left=F right=D on F.id = D.id "
            ) {
        StrategyDelta baselineDelta = runWithMppAndStrategyDelta(ppl, false);
            + FACT_INDEX
     * broadcast probe. Sort+head is a stable invariant here because the underlying fact data is
     * stage's output (joined rows) flows correctly into a downstream stats stage. Five categories
     * INNER joining a 30-row fact (ids cycle 1..6) with a 5-row dim (ids 1..5):
     *
/*
    private void applySetting(String key, String value) throws IOException {
        ensureDataProvisioned();
                @SuppressWarnings("unchecked")
 * two runs. The broadcast-fired tests additionally read the BROADCAST counter delta via
 * <p>Data shape:
        // 5 dim categories survive (id=6 fact rows drop because dim has no id=6 entry).
        // 5 dim ids × 5 fact rows per id (ids 1..5 each occur 5 times in the 30-row cycle).
            "INNER agg-then-join: MPP path must match coord-centric baseline",
        return rows;
        );
     * actually fired (via the strategy counter delta) — without this the parity check would
            + "}";
    /**
        5, "BOOKS"
    }
        // pick BROADCAST otherwise — the BROADCAST counter must remain at zero.
        } catch (Exception ignored) {}
        bulkRequest.setOptions(bulkRequest.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
    private static int expectedInnerJoinRowCount() {
    private static final int DIM_SHARDS = 1;
 * </ul>
     * Sort + head UPSTREAM of the join: {@code source=fact | sort id, amount | head 10 | join dim}.
        assertNotNull("Response missing 'rows' field for query: " + ppl, rows);
        // Reset MPP gate to default after every test so a failure doesn't leak state.
 *   <li>{@code bcast_dim} — 1 shard, ~5 rows. Tiny build side; the cost model strongly favors
            baselineDelta.broadcastDelta
        }
     * non-equi predicate at the coordinator. This restores the M0 path that PR #21639 had
            + " | sort id, amount | head 10"
     * to a single node. Summing across nodes gives a stable cluster-wide delta.
 * (and didn't silently fall through to coord-centric).
        Request health = new Request("GET", "/_cluster/health/" + name);
        ensureDataProvisioned();
        assertRowMultisetEquals(
     * remains the cost-model winner — the post-join agg doesn't change CBO's input estimates.
            + " | stats sum(amount) as total by id"
    public void testInnerJoin_aggOnFactBeforeJoin_mppMatchesBaseline() throws IOException {
    }
        assertTrue(message + " (BROADCAST counter delta was " + delta + ")", delta > 0);
 * once with {@code analytics.mpp.enabled=false} (broadcast and hash-shuffle split rules
            broadcastDelta.rows
    private List<List<Object>> executePplRows(String ppl) throws IOException {
     * the partial+final aggregate split inside a broadcast-probe fragment. Each {@code id} (1..6)
        StrategyDelta broadcastDelta = runWithMppAndStrategyDelta(ppl, true);
        assertEquals("index creation must be acknowledged", true, response.get("acknowledged"));
            + " | sort F.id, F.amount | head 100";
 * disabled, forcing the coordinator-centric baseline) and once with
            int amount = (i + 1) * 10;
 * End-to-end tests for the BROADCAST join path on a 2-node cluster.
        StrategyDelta baselineDelta = runWithMppAndStrategyDelta(ppl, false);
        String body = "{"
 *
     * row-multiset parity (the framework handles the agg-then-join shape correctly under MPP),
        StrategyDelta baselineDelta = runWithMppAndStrategyDelta(ppl, false);
    private static String normalizeRow(List<Object> row) {
        for (int i = 0; i < expectedFactRowCount(); i++) {
        StrategyDelta baselineDelta = runWithMppAndStrategyDelta(ppl, false);
            + "  \"index.composite.primary_data_format\": \"parquet\","
        2, "OFFICE",
            + "},"
        assertEquals("5 categories grouped from joined rows", 5, baselineDelta.rows.size());
    }
 * compatible open source license.
    private record StrategyDelta(List<List<Object>> rows, long broadcastDelta) {}
    }
    private void createParquetIndex(String name, int shards, String mappingProperties) throws IOException {
        ensureDataProvisioned();
            + " | sort F.id, F.amount | head 100";
        long total = 0L;
        ensureDataProvisioned();
        if (cell == null) return "<NULL>";
            + DIM_INDEX
    private static String normalizeCell(Object cell) {
     * test client round-robins across hosts, neither the PPL nor the stats request are pinned
        applySetting("analytics.mpp.distribute.min_rows", "1");
     * remain (FURNITURE/OFFICE/TECH/GROCERY/BOOKS); each gets the sum of its fact rows.
     * Aggregate UPSTREAM of the join: {@code source=fact | stats sum(amount) by id | join dim}.
     * INNER equi-join must yield identical row multisets. This is the load-bearing guard for
    /**
            + " | inner join left=F right=D on F.id < D.id "
    private StrategyDelta runWithMppAndStrategyDelta(String ppl, boolean mppEnabled) throws IOException {
            try (
                total += ((Number) value).longValue();
     * not a specific strategy.
    }
    }
        assertRowMultisetEquals("Theta join: kill-switch parity", baselineDelta.rows, mppOnDelta.rows);
    private static final String DIM_INDEX = "bcast_dim";
            + DIM_INDEX
            + "  \"number_of_shards\": " + shards + ","
        ensureDataProvisioned();
        String ppl = "source = "
    public void testInnerJoin_sortHeadOnFactBeforeJoin_mppMatchesBaseline() throws IOException {
            + FACT_INDEX
        StrategyDelta killSwitchOn = runWithMppAndStrategyDelta(ppl, true);
        return 5 * 5;
     * rows whose join key has no match in the dim (those produce NULL on the right columns).
            + DIM_INDEX
     * — BROADCAST executes on the coordinator only (the advisor + dispatch sit there), so the
        return sb.append(']').toString();
        assertRowMultisetEquals("LEFT OUTER fact×dim: BROADCAST must match M0 baseline", baselineDelta.rows, broadcastDelta.rows);
        // distributes and the BROADCAST/HASH_SHUFFLE strategy fires (matches GeneralSchedulerJoinIT).
        StringBuilder factBulk = new StringBuilder();
     * and BROADCAST (kill switch on, eligible by shards + rows). Also asserts that BROADCAST
        );
        String ppl = "source = "
    @Override
            + "  \"index.pluggable.dataformat.enabled\": true,"
        Response response = client().performRequest(request);
     */
     */
        }
    }
        StrategyDelta broadcastDelta = runWithMppAndStrategyDelta(ppl, true);
        // 30 fact rows: ids cycle through 1..6 (so id=6 has no dim match — exercises LEFT OUTER NULL fill).
        for (Map.Entry<Integer, String> entry : DIM_CATEGORIES.entrySet()) {
            + "\"mappings\": { \"properties\": " + mappingProperties + " }"
            + FACT_INDEX
        // distributes and the BROADCAST/HASH_SHUFFLE strategy fires (matches GeneralSchedulerJoinIT).
        String ppl = "source = "
        Map<String, Object> body = assertOkAndParse(response, "PPL: " + ppl);
    }
            dimBulk.append("{\"index\":{}}\n");
        applySetting("analytics.mpp.enabled", String.valueOf(mppEnabled));
        StringBuilder dimBulk = new StringBuilder();
            + " | stats sum(amount) as total by category"
     * SUM of every node's BROADCAST counter. The counter is per-node (incremented in
        return total;
        // All 10 join through (none have id=6), producing 10 output rows.
        3, "TECH",
        long after = readBroadcastCounter();
        4, "GROCERY",
        resetSetting("analytics.mpp.enabled");
        StrategyDelta killSwitchOff = runWithMppAndStrategyDelta(ppl, false);
    }
package org.opensearch.analytics.qa;
