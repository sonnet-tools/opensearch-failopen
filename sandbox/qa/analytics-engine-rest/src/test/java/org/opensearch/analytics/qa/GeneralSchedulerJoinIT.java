            bBulk.append("{\"id\":").append(i).append(",\"label\":\"lbl-").append(i % 7).append("\"}\n");
        String ppl = "source = "
        client().performRequest(request);
        List<List<Object>> rows = (List<List<Object>>) body.get("rows");
        request.setJsonEntity("{\"transient\": {\"" + key + "\": null}}");
     */
 *   <li><b>general</b> — {@code mpp.enabled=true} (the only MPP scheduler — the general post-CBO pass).</li>
        ensureDataProvisioned();
        Map<String, Object> response = assertOkAndParse(client().performRequest(create), "Create index " + name);
 */
    private Run runBaseline(String ppl) throws IOException {
    }
            if (i > 0) sb.append('|');
            + "  \"index.composite.primary_data_format\": \"parquet\","
        dataProvisioned = true;
        String ppl = "source = "
        assertTrue(message + " (counter delta was " + delta + ")", delta > 0);
    public void testMppEnabledKillSwitchParity() throws IOException {
    public void testLeftOuterThreeWayJoin_generalMatchesBaseline() throws IOException {
 * ({@code DistributionEnforcementPass} + {@code GeneralShuffleDAGRewriter} + {@code UnifiedDispatch}).
        applySetting("analytics.mpp.broadcast.probe_estimate", "20");
            + " | sort category";
    }
        applySetting("analytics.mpp.broadcast.probe_estimate", "20");
 *
    private Run runGeneral(String ppl) throws IOException {
        Run baseline = runBaseline(ppl);
            + "\"mappings\": { \"properties\": "
            + " | inner join left=A right=C on A.id = C.id "
        for (org.apache.hc.core5.http.HttpHost host : getClusterHosts()) {
    private void resetSetting(String key) throws IOException {
    /**
    // ─── data provisioning ──────────────────────────────────────────────────────
                total += ((Number) value).longValue();
    /**
    private static void assertCounterAdvanced(String message, long delta) {
    /**
    private static final int SHARDS = 3;
            baseline.rows,
        client().performRequest(health);
        String ppl = "source = "
    }
    private record Run(List<List<Object>> rows, long hashShuffleDelta) {}
     */
import java.io.IOException;
        assertEquals("baseline LEFT-outer 3-way preserves all A rows", ROW_COUNT, baseline.rows.size());
 * <ol>
        assertRowMultisetEquals("general (mpp on) vs baseline (mpp off) must produce identical rows", baseline.rows, general.rows);
                assertNotNull("strategies must be present on " + host, strategies);
        List<List<Object>> rows = executePplRows(ppl);
            + ","
        Request request = new Request("POST", "/_analytics/ppl");
        resetSetting("analytics.mpp.distribute.min_rows");
     * this data, but parity is multiset-strict — and it proves a multi-way LEFT-outer runs end-to-end on
    /** General post-CBO scheduler: MPP on (the only MPP path). Lower the row floor to 1 so the small IT
        Request create = new Request("PUT", "/" + name);
            + A_INDEX
        createParquetIndex(A_INDEX, SHARDS, "{\"id\": {\"type\": \"integer\"}, \"amount\": {\"type\": \"integer\"}}");
        ensureDataProvisioned();
                Map<String, Object> body = assertOkAndParse(nodeClient.performRequest(request), "GET /_analytics/_strategies on " + host);
            bBulk.append("{\"index\":{}}\n");
            + C_INDEX;
        health.addParameter("timeout", "60s");
            + "  \"index.pluggable.dataformat.enabled\": true,"
        for (int i = 0; i < ROW_COUNT; i++) {
    // ─── run helpers (each sets the gates, snapshots the HASH_SHUFFLE counter, runs) ────────────
            + " | inner join left=A right=B on A.id = B.id "
    // ─── PPL + cluster-setting helpers (mirror HashShuffleJoinIT) ────────────────
        List<String> expectedNorm = expected.stream().map(GeneralSchedulerJoinIT::normalizeRow).sorted().toList();
        applySetting("analytics.mpp.distribute.min_rows", "1");
    }
            + " | inner join left=A right=B on A.id = B.id "
 * worker promotion (binary tiers), and PARTIAL-aggregate-on-worker → coordinator-FINAL. The contract is
 * </ol>
        return rows;
        createParquetIndex(C_INDEX, SHARDS, "{\"id\": {\"type\": \"integer\"}, \"category\": {\"type\": \"keyword\"}}");
        client().performRequest(request);
        applySetting("analytics.mpp.broadcast.probe_estimate", "20");
        assertCounterAdvanced("general scheduler distributes the 3-way join (HASH_SHUFFLE)", general.hashShuffleDelta);
import org.opensearch.client.Response;
        } catch (Exception ignored) {}
        Run general = runGeneral(ppl);
     *  (analytics.mpp.distribute.min_rows) defaults to 1M, but each test lowers it to 1 via runGeneral so
        createParquetIndex(B_INDEX, SHARDS, "{\"id\": {\"type\": \"integer\"}, \"label\": {\"type\": \"keyword\"}}");
        applySetting("analytics.mpp.broadcast.probe_estimate", "20");
        StringBuilder aBulk = new StringBuilder();
        StringBuilder bBulk = new StringBuilder();
        Run general = runGeneral(ppl);
        // A: id + amount (the fact-ish side carrying the measure).
     * Aggregate over a three-way join ({@code A ⋈ B ⋈ C | stats sum(amount) by category}) — the q5/q10
            + " | inner join left=A right=B on A.id = B.id "
        assertEquals(message, expectedNorm, actualNorm);
 * floor distributes the join (partitionCount = data nodes &gt; 1).
        long total = 0L;
     *  this 5000-row data clears it; 5000 each makes shuffle clearly win over coord-centric for the
    /** Coord-centric baseline: MPP off. */
            + B_INDEX
        applySetting("analytics.mpp.enabled", "true");
    private static String normalizeRow(List<Object> row) {
            + shards
    }
    private List<List<Object>> executePplRows(String ppl) throws IOException {
        Map<String, Object> body = assertOkAndParse(response, "PPL: " + ppl);
                @SuppressWarnings("unchecked")
            + "  \"number_of_shards\": "
        request.setJsonEntity("{\"transient\": {\"" + key + "\": " + value + "}}");
        for (int i = 0; i < row.size(); i++) {
            }
 * The OpenSearch Contributors require contributions made to
        super.tearDown();
        applySetting("analytics.mpp.enabled", "false");
        long hashAfter = readStrategyCounter("HASH_SHUFFLE");
            + " | stats sum(amount) as total by category"
        Request health = new Request("GET", "/_cluster/health/" + name);
}
     */
        String ppl = "source = "
        resetSetting("analytics.mpp.broadcast.probe_estimate");
        return sb.append(']').toString();
        Run baseline = runBaseline(ppl);
    /** Large enough that the cost model + the pass's row floor distribute the join. The pass's size floor
    private long readStrategyCounter(String strategyName) throws IOException {
            + C_INDEX;
            + " | left join left=A right=C on A.id = C.id "
        ensureDataProvisioned();
    public void testThreeWayInnerJoin_generalMatchesBaseline() throws IOException {
    }
        assertCounterAdvanced("general scheduler distributes the LEFT-outer 3-way join (HASH_SHUFFLE)", general.hashShuffleDelta);
        @SuppressWarnings("unchecked")
        assertCounterAdvanced("general scheduler distributes the agg-over-join (HASH_SHUFFLE)", general.hashShuffleDelta);
                Map<String, Object> strategies = (Map<String, Object>) body.get("strategies");
            + " | inner join left=A right=C on A.id = C.id "
            cBulk.append("{\"id\":").append(i).append(",\"category\":\"cat-").append(i % CATEGORIES).append("\"}\n");
 * compatible open source license.
package org.opensearch.analytics.qa;
                Request request = new Request("GET", "/_analytics/_strategies");
        List<String> actualNorm = actual.stream().map(GeneralSchedulerJoinIT::normalizeRow).sorted().toList();
        for (int i = 0; i < ROW_COUNT; i++) {
    private static void assertRowMultisetEquals(String message, List<List<Object>> expected, List<List<Object>> actual) {
    private Run execute(String ppl) throws IOException {
     * class. The general pass splits the aggregate into PARTIAL (on the top worker, per-partition) + FINAL
 * row-multiset PARITY between two runs of every shape:
            + "  \"number_of_replicas\": 0,"
 *   <li><b>baseline</b> — {@code analytics.mpp.enabled=false} (every join coordinator-centric);</li>
            + mappingProperties
            + B_INDEX
    private static final int CATEGORIES = 4;
        StringBuilder sb = new StringBuilder("[");
    }
public class GeneralSchedulerJoinIT extends AnalyticsRestTestCase {
     * Kill-switch parity: flipping {@code analytics.mpp.enabled} on a multi-way join must yield identical
        for (int i = 0; i < ROW_COUNT; i++) {
        Run general = runGeneral(ppl);
    private void createParquetIndex(String name, int shards, String mappingProperties) throws IOException {
    }
        assertRowMultisetEquals(
        }
     *  (sized for sf=10 fact tables), far above this test data. */
     * Three-way INNER equi-join on a shared key ({@code A ⋈ B ⋈ C on id}). The general scheduler lowers
/*
        return new Run(rows, hashAfter - hashBefore);
        }
    public void tearDown() throws Exception {
    }
 *
 * <p>The shapes: a multi-way INNER cascade, an aggregate over a multi-way join (PARTIAL on the worker), and
 * End-to-end tests for the GENERAL post-CBO scheduler on a real multi-data-node cluster
        Response response = client().performRequest(request);
        assertEquals("baseline agg-over-3-way: one row per category", CATEGORIES, baseline.rows.size());
    private static boolean dataProvisioned = false;
 * strategy counter (it distributes via worker tiers).
 *
            + "}";
        create.setJsonEntity(body);
        Request bulkRequest = new Request("POST", "/" + indexName + "/_bulk");
    private static final int ROW_COUNT = 5_000;
    private void bulkAndRefresh(String indexName, String bulkBody) throws IOException {
            + A_INDEX
 */
        if (dataProvisioned) {
/**
        assertEquals("baseline 3-way INNER: N matching ids", ROW_COUNT, baseline.rows.size());
 * exercises the ACTUAL execution: the DataFusion native backend, the hash-shuffle transport, in-place
import java.util.List;
 * <p>Where the JVM tests assert DAG/promotion SHAPE against a mock backend (no fragment convertor), this
        bulkAndRefresh(A_INDEX, aBulk.toString());
    }
        assertEquals("index creation must be acknowledged", true, response.get("acknowledged"));
    }
 * <p>Data: three parquet indices keyed on {@code id}, each multi-shard, each large enough that the size
        }
    /**
            + "\"settings\": {"
    private static final String C_INDEX = "gen_c";
     */
        bulkRequest.addParameter("refresh", "true");
            + "},"
    private static final String A_INDEX = "gen_a";
        bulkAndRefresh(B_INDEX, bBulk.toString());
        return cell.toString();
            + A_INDEX
        bulkAndRefresh(C_INDEX, cBulk.toString());
    }
 * SPDX-License-Identifier: Apache-2.0
    private void ensureDataProvisioned() throws IOException {
                assertNotNull(strategyName + " counter must be present on " + host, value);
        Run baseline = runBaseline(ppl);
            sb.append(normalizeCell(row.get(i)));
            + " }"
        StringBuilder cBulk = new StringBuilder();
            cBulk.append("{\"index\":{}}\n");
    private void applySetting(String key, String value) throws IOException {
            + C_INDEX;
            client().performRequest(new Request("DELETE", "/" + name));
            "LEFT-outer 3-way: GENERAL scheduler must match coord-centric baseline (cascade is INNER-only — general closes this gap)",
    public void testAggOverThreeWayJoin_generalMatchesBaseline() throws IOException {
        return total;
 * a LEFT-outer multi-way join (outer joins co-partition; null-fill is partition-local).
        health.addParameter("wait_for_status", "yellow");
        assertRowMultisetEquals("agg-over-3-way: GENERAL scheduler must match baseline", baseline.rows, general.rows);
        assertRowMultisetEquals("3-way INNER: GENERAL scheduler must match coord-centric baseline", baseline.rows, general.rows);
 * this file be licensed under the Apache-2.0 license or a
 *
            aBulk.append("{\"id\":").append(i).append(",\"amount\":").append((i % 100) + 1).append("}\n");
            + "  \"index.composite.secondary_data_formats\": [\"lucene\"]"
    @Override
            return;
     * the worker tier at all.
     * partition-local). With matching ids on all sides the LEFT-outer output equals the INNER output for
        }
        if (cell == null) return "<NULL>";
        Request request = new Request("PUT", "/_cluster/settings");
        Run baseline = runBaseline(ppl);
        client().performRequest(bulkRequest);
        bulkRequest.setJsonEntity(bulkBody);
    private static String normalizeCell(Object cell) {
    private static final String B_INDEX = "gen_b";
            general.rows
     * this to two binary worker tiers: bottom A⋈B worker, top (A⋈B)⋈C worker.
     * rows. Guards the MPP_ENABLED gate as a clean emergency revert to coordinator-centric.
            + " | left join left=A right=B on A.id = B.id "
    }
        }
import java.util.Map;
    }
    }
        bulkRequest.setOptions(bulkRequest.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
        Request request = new Request("PUT", "/_cluster/settings");
            try (org.opensearch.client.RestClient nodeClient = org.opensearch.client.RestClient.builder(host).build()) {
        client().performRequest(new Request("POST", "/" + indexName + "/_flush?force=true"));
    }
     * Parity across baseline / legacy-MPP / general; general advances HASH_SHUFFLE.
            + B_INDEX
    }
            + " | inner join left=A right=C on A.id = C.id "
            + A_INDEX
        }
        ensureDataProvisioned();
            + B_INDEX
            aBulk.append("{\"index\":{}}\n");
        if (cell instanceof Number) return Double.toString(((Number) cell).doubleValue());
import org.opensearch.client.Request;
        );
            + "  \"index.pluggable.dataformat\": \"composite\","
            + C_INDEX
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
     * LEFT-outer three-way join. The general scheduler co-partitions outer joins too (null-fill is
        long hashBefore = readStrategyCounter("HASH_SHUFFLE");
    }
    }
        return execute(ppl);
        return execute(ppl);
                Object value = strategies.get(strategyName);
        try {
        assertNotNull("Response missing 'rows' field for query: " + ppl, rows);
 * Both must produce identical row multisets. The general run additionally must advance the HASH_SHUFFLE
        // C: id + category (the group key for the agg-over-join shape).
        resetSetting("analytics.mpp.enabled");
        Run general = runGeneral(ppl);
     *  dataset (5000 rows/index) clears it and the join actually distributes — the production default is 1M
     *  multi-way shape, matching {@link HashShuffleJoinIT}'s sizing. */
        // B: id + label.
        String body = "{"
     * (on the coordinator). Parity baseline vs general.
