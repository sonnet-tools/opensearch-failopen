        // distributes and the BROADCAST/HASH_SHUFFLE strategy fires (matches GeneralSchedulerJoinIT).  
        resetSetting("analytics.mpp.distribute.min_rows");  
     * not a specific strategy.  
 * once with {@code analytics.mpp.enabled=false} (broadcast and hash-shuffle split rules
            try (  
            + "  \"index.pluggable.dataformat\": \"composite\","
        StrategyDelta broadcastDelta = runWithMppAndStrategyDelta(ppl, true);  
     * — BROADCAST executes on the coordinator only (the advisor + dispatch sit there), so the
        );
            + FACT_INDEX
        // Theta is ineligible for any MPP strategy — both runs hit the coord-centric path,  
        StrategyDelta baselineDelta = runWithMppAndStrategyDelta(ppl, false);
        String ppl = "source = "
        assertEquals("5 grouped fact rows × 1 dim match each = 5 output rows", 5, baselineDelta.rows.size());
     * rule no longer gates on {@code JoinInfo.isEqui()}, the split rule operates on
    }  
 * this file be licensed under the Apache-2.0 license or a
                assertNotNull("strategies must be present on " + host, strategies);
        dataProvisioned = true;  
            + "  \"index.composite.primary_data_format\": \"parquet\","
        // 5 dim categories survive (id=6 fact rows drop because dim has no id=6 entry).  
            + " | sort category";
        ensureDataProvisioned();
    }
     */  
        return executePplRows(ppl);
        // Flush so doc counts are committed and IndicesStats sees them.
 * <p>The strategy here is A/B parity: every join query is executed twice on the same data,  
    private static final int DIM_SHARDS = 1;  
        assertRowMultisetEquals("LEFT OUTER fact×dim: BROADCAST must match M0 baseline", baselineDelta.rows, broadcastDelta.rows);
        for (int i = 0; i < expectedFactRowCount(); i++) {
     * 30-row dataset).
            + " | inner join left=F right=D on F.id = D.id "
        // pick BROADCAST otherwise — the BROADCAST counter must remain at zero.  
 * two runs. The broadcast-fired tests additionally read the BROADCAST counter delta via
 * case can't leak state into the next.  
        bulkRequest.setOptions(bulkRequest.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
                Map<String, Object> body = assertOkAndParse(nodeClient.performRequest(request), "GET /_analytics/_strategies on " + host);
     * return both the rows and the counter delta. The delta is summed across all data nodes
     * remain (FURNITURE/OFFICE/TECH/GROCERY/BOOKS); each gets the sum of its fact rows.
            baselineDelta.broadcastDelta  
        }
    private static void assertCounterAdvanced(String message, long delta) {
     *
        applySetting("analytics.mpp.distribute.min_rows", "1");
                assertNotNull("BROADCAST counter must be present on " + host, value);  
        StrategyDelta mppOnDelta = runWithMppAndStrategyDelta(ppl, true);
        request.setJsonEntity("{\"transient\": {\"" + key + "\": " + value + "}}");
    }  
        String ppl = "source = "  
        Request request = new Request("POST", "/_analytics/ppl");  
        @SuppressWarnings("unchecked")
        create.setJsonEntity(body);  
        if (dataProvisioned) {
        assertTrue(message + " (BROADCAST counter delta was " + delta + ")", delta > 0);
        } catch (Exception ignored) {}  
        health.addParameter("timeout", "60s");  
            + "},"
 * <p>Cluster settings are reset to {@code null} (default) between tests so a failure in one
     * Adds a final aggregate at the coordinator post-join. Validates that the broadcast-probe  
/*  
     */
        }
            + DIM_INDEX  
     * stage's output (joined rows) flows correctly into a downstream stats stage. Five categories
     * <p>Pre-join sizes are unchanged from the hero test (30-row probe, 5-row dim) so BROADCAST
    public void testLeftOuterJoin_factWithDim_broadcastMatchesBaseline() throws IOException {  
    @SuppressWarnings("unused")
        assertRowMultisetEquals(
        bulkAndRefresh(DIM_INDEX, dimBulk.toString());
        StringBuilder dimBulk = new StringBuilder();  
        client().performRequest(bulkRequest);  
        return 5 * 5;  
        ensureDataProvisioned();
            "INNER join-then-stats: BROADCAST must match coord-centric baseline",
    /**
     * and BROADCAST (kill switch on, eligible by shards + rows). Also asserts that BROADCAST  
     */
            + FACT_INDEX  
        List<String> expectedNorm = expected.stream().map(BroadcastJoinIT::normalizeRow).sorted().toList();  
        List<List<Object>> rows = (List<List<Object>>) body.get("rows");
        for (Map.Entry<Integer, String> entry : DIM_CATEGORIES.entrySet()) {
 * (and didn't silently fall through to coord-centric).
import java.util.Arrays;
        Request create = new Request("PUT", "/" + name);
     * across-nodes snapshot keeps the helper agnostic to which node the test client routes to.
    private static String normalizeRow(List<Object> row) {
    }  
     *
            broadcastDelta.rows
    private static final String DIM_INDEX = "bcast_dim";
            sb.append(normalizeCell(row.get(i)));  
     * inadvertently broken. The test asserts row-multiset parity between MPP off and MPP on
                Map<String, Object> strategies = (Map<String, Object>) body.get("strategies");  
 * <p>Data shape:  
 * The OpenSearch Contributors require contributions made to  
     * {@code DefaultPlanExecutor} at the coordinator that handled the query); since the REST
                @SuppressWarnings("unchecked")
    private void createParquetIndex(String name, int shards, String mappingProperties) throws IOException {  
        request.setJsonEntity("{\"transient\": {\"" + key + "\": null}}");
     * MPP kill-switch regression: flipping {@code analytics.mpp.enabled} between runs of an
     * Aggregate DOWNSTREAM of the join: {@code source=fact | join dim | stats sum(amount) by category}.
        assertCounterAdvanced("BROADCAST fires when MPP is enabled for join-then-stats", broadcastDelta.broadcastDelta);
            + FACT_INDEX
     * (kill-switch parity), and checks that BROADCAST does NOT fire (theta is ineligible).
            + " | inner join left=F right=D on F.id = D.id "
        return 30;  
            "INNER agg-then-join: MPP path must match coord-centric baseline",  
 *       broadcasting it over hash-shuffling both sides.</li>  
        return cell.toString();
        ensureDataProvisioned();
        assertRowMultisetEquals("Theta join: kill-switch parity", baselineDelta.rows, mppOnDelta.rows);
        Request request = new Request("PUT", "/_cluster/settings");
        ensureDataProvisioned();
     * actually fired (via the strategy counter delta) — without this the parity check would
     * INNER joining a 30-row fact (ids cycle 1..6) with a 5-row dim (ids 1..5):
     * The probe-side fragment is now {@code Aggregate + Scan}, not just {@code Scan} — exercises
     * Aggregate UPSTREAM of the join: {@code source=fact | stats sum(amount) by id | join dim}.  
            mppOnDelta.rows  
            client().performRequest(new Request("DELETE", "/" + name));
            + DIM_INDEX
     * INNER equi-join must yield identical row multisets. This is the load-bearing guard for
 * compatible open source license.
            "INNER sortHead-then-join: MPP path must match coord-centric baseline",
import java.util.List;  
     * BROADCAST to be eligible. Both runs must return the same rows including the LEFT-side  
    }  
            + " | stats sum(amount) as total by category"
        assertRowMultisetEquals("INNER smallDim×largeFact: BROADCAST must match M0 baseline", baselineDelta.rows, broadcastDelta.rows);  
        // Strategy assertions — without this the IT would pass for ANY two M0 runs even with
            + "\"settings\": {"  
        bulkAndRefresh(FACT_INDEX, factBulk.toString());
     */  
    }  
    /**
        // Same query, same data, just a different routing decision.  
     * Sort + head UPSTREAM of the join: {@code source=fact | sort id, amount | head 10 | join dim}.  
    public void testInnerEquiJoin_smallDimWithLargeFact_broadcastMatchesBaseline() throws IOException {
        applySetting("analytics.mpp.enabled", String.valueOf(mppEnabled));
        String ppl = "source = "
        // Kill-switch off forces COORDINATOR_CENTRIC dispatch even though the advisor would
        return sb.append(']').toString();
 * disabled, forcing the coordinator-centric baseline) and once with
     */
        }  
    }
        }  
    private StrategyDelta runWithMppAndStrategyDelta(String ppl, boolean mppEnabled) throws IOException {  
        if (cell == null) return "<NULL>";  
package org.opensearch.analytics.qa;
            + FACT_INDEX  
            baselineDelta.rows,  
    /**
            + "  \"index.pluggable.dataformat.enabled\": true,"  
        // Every fact row appears at least once.  
        assertEquals("BROADCAST must not advance for theta with MPP on", 0L, mppOnDelta.broadcastDelta);  
        // Small IT data sits below the production distribute floor (1M); lower it so the join actually
            + " | sort F.id, F.amount | head 100";  
        }
            + DIM_INDEX  
            }
 * {@code GET /_analytics/_strategies} to prove the dispatcher actually ran the broadcast path  
     * <p>The aggregate shrinks the probe to ~6 rows, which makes broadcast no longer the  
        assertEquals("baseline row count", expectedInnerJoinRowCount(), baselineDelta.rows.size());  
        // BROADCAST silently broken. We require the BROADCAST counter to advance only when MPP  
        health.addParameter("wait_for_status", "yellow");
     */  
        // is enabled (and crucially, NOT when MPP is disabled).
        StrategyDelta killSwitchOff = runWithMppAndStrategyDelta(ppl, false);
 *
    private static int expectedInnerJoinRowCount() {
    }
        1, "FURNITURE",
        5, "BOOKS"  
 *   <li>{@code bcast_dim} — 1 shard, ~5 rows. Tiny build side; the cost model strongly favors
    /**
        // The first 10 fact rows by (id, amount) are: id=1×2, id=2×2, id=3×2, id=4×2, id=5×2.
            + " | inner join left=F right=D on F.id = D.id "
    }
     * remains the cost-model winner — the post-join agg doesn't change CBO's input estimates.
    }  
    private long readBroadcastCounter() throws IOException {  
 * replicating the small side over shuffling both sides). Row multisets must match across the
    /** Maps {@code id} → category — used to assert join correctness deterministically. */  
        resetSetting("analytics.mpp.enabled");
     * the {@code AnalyticsSettings.MPP_ENABLED} wiring in {@code DefaultPlanExecutor}.  
        );
    private List<List<Object>> executePplRows(String ppl) throws IOException {
        client().performRequest(health);
        for (org.apache.hc.core5.http.HttpHost host : getClusterHosts()) {
    private void applySetting(String key, String value) throws IOException {
        long total = 0L;
 *   <li>{@code bcast_fact} — 5 shards, ~30 rows. Probe side; would dominate any hash-shuffle
        applySetting("analytics.mpp.enabled", String.valueOf(mppEnabled));
    private static String normalizeCell(Object cell) {
import org.opensearch.client.Response;
     * test client round-robins across hosts, neither the PPL nor the stats request are pinned  
            + " | sort F.id, F.amount";
        assertCounterAdvanced("BROADCAST fires for LEFT OUTER when MPP is enabled", broadcastDelta.broadcastDelta);
    // ─── PPL + cluster-setting helpers ─────────────────────────────────────────  
    }
        StrategyDelta baselineDelta = runWithMppAndStrategyDelta(ppl, false);  
            + " | inner join left=F right=D on F.id < D.id "
    /**
        applySetting("analytics.mpp.distribute.min_rows", "1");
     * LEFT OUTER preserves the left side, so the build MUST be the right (small dim) for
     * Apply MPP setting, snapshot the cluster-wide BROADCAST counter, run the PPL query, and  
            + FACT_INDEX
    }
            return;  
        Response response = client().performRequest(request);
     * broadcast — the assertion is row-multiset parity, not BROADCAST specifically.
    public void testMppKillSwitchProducesSameRowsAsBaseline() throws IOException {
        String ppl = "source = "  
        return rows;
        for (int i = 0; i < row.size(); i++) {
     * counter advances by 1 per BROADCAST query regardless of node count, but using a sum-  
        StrategyDelta mppOnDelta = runWithMppAndStrategyDelta(ppl, true);  
    private static final String FACT_INDEX = "bcast_fact";
            baselineDelta.rows,
     * collapses to one row; only ids 1..5 join through. Output cardinality drops from 25 (plain  
        // 5 fact ids match dim (id=6 has no dim row and is dropped).
                total += ((Number) value).longValue();
        long before = readBroadcastCounter();
 */
        Request request = new Request("PUT", "/_cluster/settings");  
     * The probe-side fragment is {@code Sort+Limit + Scan} — a sort-aware producer feeding the
        return total;
        StrategyDelta broadcastDelta = runWithMppAndStrategyDelta(ppl, true);
    }
    public void testThetaJoinRoutesToCoordinatorCentric() throws IOException {
    /**
            + DIM_INDEX  
        Request bulkRequest = new Request("POST", "/" + indexName + "/_bulk");
        2, "OFFICE",  
    public void testInnerJoin_aggOnFactBeforeJoin_mppMatchesBaseline() throws IOException {
     * to a single node. Summing across nodes gives a stable cluster-wide delta.
    /**
        ensureDataProvisioned();
    /** Helper used by the runnable theta test. */
public class BroadcastJoinIT extends AnalyticsRestTestCase {
        return new StrategyDelta(rows, after - before);
     * the partial+final aggregate split inside a broadcast-probe fragment. Each {@code id} (1..6)
        // results must match exactly.
    private static boolean dataProvisioned = false;  
        Map<String, Object> body = assertOkAndParse(response, "PPL: " + ppl);  
        assertEquals("BROADCAST must not advance for theta with MPP off", 0L, baselineDelta.broadcastDelta);
 * {@code analytics.mpp.enabled=true} (Volcano CBO picks BROADCAST when its cost model favors  
        StringBuilder factBulk = new StringBuilder();
            + "  \"number_of_replicas\": 0,"
        String ppl = "source = "
                Request request = new Request("GET", "/_analytics/_strategies");  
        Map<String, Object> response = assertOkAndParse(client().performRequest(create), "Create index " + name);
        Request health = new Request("GET", "/_cluster/health/" + name);
        client().performRequest(request);
     * trivially pass for any pair of identical M0 runs.
    }  
        StrategyDelta broadcastDelta = runWithMppAndStrategyDelta(ppl, true);
    }  
        assertCounterAdvanced("MPP=true must dispatch BROADCAST for this eligible query", killSwitchOn.broadcastDelta);
    // ─── data provisioning ─────────────────────────────────────────────────────
        assertCounterAdvanced("BROADCAST fires on at least one node when MPP is enabled", broadcastDelta.broadcastDelta);
     */  
        // 30 fact rows: ids cycle through 1..6 (so id=6 has no dim match — exercises LEFT OUTER NULL fill).  
     * deterministic (no joins under the sort, and the (id, amount) pair is unique across the  
    private static void assertRowMultisetEquals(String message, List<List<Object>> expected, List<List<Object>> actual) {
    }  
            if (i > 0) sb.append('|');
     * Hero test: small dim × large fact INNER equi-join, parity between M0 (kill switch off)
        client().performRequest(request);
import org.opensearch.client.Request;
        // Small IT data sits below the production distribute floor (1M); lower it so the join actually
        StrategyDelta baselineDelta = runWithMppAndStrategyDelta(ppl, false);  
     * INNER) to 5 — five {@code (id, total, category)} rows.
        assertRowMultisetEquals(
        assertNotNull("Response missing 'rows' field for query: " + ppl, rows);  
    }
        );  
    }  
    private static List<Object> row(Object... values) {  
 *
    }
            dimBulk.append("{\"id\":").append(entry.getKey()).append(",\"category\":\"").append(entry.getValue()).append("\"}\n");  
    /**  
        createParquetIndex(FACT_INDEX, FACT_SHARDS, "{\"id\": {\"type\": \"integer\"}, \"amount\": {\"type\": \"integer\"}}");
     * distribution traits only, and DataFusion picks {@code NestedLoopJoinExec} for the
    }  
}  
        List<List<Object>> rows = executePplRows(ppl);  
import java.util.Map;
        // BROADCAST must NOT fire for theta in either run (broadcast requires equi).
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
 */  
     * non-equi predicate at the coordinator. This restores the M0 path that PR #21639 had  
    public void tearDown() throws Exception {  
                org.opensearch.client.RestClient nodeClient = org.opensearch.client.RestClient.builder(host).build()
     * broadcast probe. Sort+head is a stable invariant here because the underlying fact data is
        super.tearDown();
    private void resetSetting(String key) throws IOException {
            + "}";  
     */
        assertEquals("5 categories grouped from joined rows", 5, baselineDelta.rows.size());
 * SPDX-License-Identifier: Apache-2.0
            + "  \"number_of_shards\": " + shards + ","
        bulkRequest.setJsonEntity(bulkBody);  
            + "  \"index.composite.secondary_data_formats\": [\"lucene\"]"  
            + " | sort F.id, D.id, F.amount | head 200";
            + " | sort F.id, F.amount | head 100";
        return Arrays.asList(values);
            + " | left join left=F right=D on F.id = D.id "
     */
     * row-multiset parity (the framework handles the agg-then-join shape correctly under MPP),
    public void testInnerJoin_statsAfterJoin_broadcastMatchesBaseline() throws IOException {
            + "\"mappings\": { \"properties\": " + mappingProperties + " }"
        assertEquals("first 10 sorted fact rows × matching dim = 10 output rows", 10, baselineDelta.rows.size());
        StrategyDelta baselineDelta = runWithMppAndStrategyDelta(ppl, false);
    private void ensureDataProvisioned() throws IOException {
 * </ul>  
 *
    /**
        );
    @Override
/**  
            + DIM_INDEX
        ensureDataProvisioned();  
    }  
        // All 10 join through (none have id=6), producing 10 output rows.  
            + " | inner join left=F right=D on F.id = D.id "
     * Theta (non-equi) joins route to coordinator-centric execution under M2 — the marker  
    );
            mppOnDelta.rows
        // Reset MPP gate to default after every test so a failure doesn't leak state.
        assertEquals("MPP=false must route via coord-centric (BROADCAST counter = 0)", 0L, killSwitchOff.broadcastDelta);
        StrategyDelta killSwitchOn = runWithMppAndStrategyDelta(ppl, true);
    private record StrategyDelta(List<List<Object>> rows, long broadcastDelta) {}  
    }
            + FACT_INDEX
        String ppl = "source = "  
        4, "GROCERY",
    private List<List<Object>> runWithMpp(String ppl, boolean mppEnabled) throws IOException {  
            int id = (i % 6) + 1;
     * <p>Sort+head=10 reduces the probe input to 10 rows, so CBO may pick coord-centric over  
            "BROADCAST counter must NOT advance when MPP is disabled (kill switch path)",
     * SUM of every node's BROADCAST counter. The counter is per-node (incremented in
        List<String> actualNorm = actual.stream().map(BroadcastJoinIT::normalizeRow).sorted().toList();
    /** Bundles a query's row output with the BROADCAST-counter delta observed around it. */
        assertEquals("index creation must be acknowledged", true, response.get("acknowledged"));
 * <ul>
 * End-to-end tests for the BROADCAST join path on a 2-node cluster.
            + " | stats sum(amount) as total by id"  
            factBulk.append("{\"id\":").append(id).append(",\"amount\":").append(amount).append("}\n");
    public void testInnerJoin_sortHeadOnFactBeforeJoin_mppMatchesBaseline() throws IOException {  
    private static final Map<Integer, String> DIM_CATEGORIES = Map.of(
            + " | inner join left=F right=D on F.id = D.id "  
            + " | sort F.id, F.amount | head 100";
        String ppl = "source = "
     */
        if (cell instanceof Number) return Double.toString(((Number) cell).doubleValue());
        createParquetIndex(DIM_INDEX, DIM_SHARDS, "{\"id\": {\"type\": \"integer\"}, \"category\": {\"type\": \"keyword\"}}");
    private void bulkAndRefresh(String indexName, String bulkBody) throws IOException {
        StrategyDelta mppOnDelta = runWithMppAndStrategyDelta(ppl, true);
            int amount = (i + 1) * 10;  
        assertEquals(message, expectedNorm, actualNorm);
        assertEquals("LEFT OUTER preserves all fact rows", expectedFactRowCount(), baselineDelta.rows.size());
     * obvious winner — CBO may pick coord-centric for the join itself. The assertion is
            + FACT_INDEX
            ) {
            factBulk.append("{\"index\":{}}\n");
        assertRowMultisetEquals(  
            + DIM_INDEX
        client().performRequest(new Request("POST", "/" + indexName + "/_flush?force=true"));
    private static final int FACT_SHARDS = 5;
        StrategyDelta baselineDelta = runWithMppAndStrategyDelta(ppl, false);
     * rows whose join key has no match in the dim (those produce NULL on the right columns).
    private static int expectedFactRowCount() {
            dimBulk.append("{\"index\":{}}\n");
        3, "TECH",
        String body = "{"
        // distributes and the BROADCAST/HASH_SHUFFLE strategy fires (matches GeneralSchedulerJoinIT).  
            0L,
        // Independently sanity-check the baseline so the parity assertion can't trivially pass
            + " | sort F.id";  
import java.io.IOException;
    }  
        ensureDataProvisioned();  
        assertRowMultisetEquals("MPP kill switch must not change query results", killSwitchOff.rows, killSwitchOn.rows);
        StrategyDelta baselineDelta = runWithMppAndStrategyDelta(ppl, false);  
        // Use transient so a test failure doesn't leave a persistent setting on the cluster.  
                Object value = strategies.get("BROADCAST");
     * id=6 fact rows drop out, ids 1..5 each appear {@code (30 / 6) = 5} times.
        // 5 dim ids × 5 fact rows per id (ids 1..5 each occur 5 times in the 30-row cycle).
 *       cost since it has more rows.</li>
     * Reads {@code GET /_analytics/_strategies} from each node in the cluster and returns the  
            + DIM_INDEX  
        long after = readBroadcastCounter();
    /**  
            baselineDelta.rows,
            + " | sort id, amount | head 10"
     *  
        bulkRequest.addParameter("refresh", "true");
        try {
        assertEquals(  
    }
        StringBuilder sb = new StringBuilder("[");  
        // on two equally-broken runs (e.g. cartesian product).
 *
