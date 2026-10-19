        String ppl = "source = "  
        client().performRequest(bulkRequest);
            + "  \"number_of_shards\": "
     * the worker tier at all.
            bBulk.append("{\"index\":{}}\n");
        assertNotNull("Response missing 'rows' field for query: " + ppl, rows);
    }
    }
        assertTrue(message + " (counter delta was " + delta + ")", delta > 0);
    /**
    }  
    }
        client().performRequest(health);
            + " | sort category";  
     * Three-way INNER equi-join on a shared key ({@code A ⋈ B ⋈ C on id}). The general scheduler lowers
     *  this 5000-row data clears it; 5000 each makes shuffle clearly win over coord-centric for the
        return sb.append(']').toString();  
        StringBuilder bBulk = new StringBuilder();
 * <p>Where the JVM tests assert DAG/promotion SHAPE against a mock backend (no fragment convertor), this  
    /** Large enough that the cost model + the pass's row floor distribute the join. The pass's size floor
        assertEquals("baseline LEFT-outer 3-way preserves all A rows", ROW_COUNT, baseline.rows.size());
    public void testThreeWayInnerJoin_generalMatchesBaseline() throws IOException {  
        health.addParameter("wait_for_status", "yellow");  
            + "  \"number_of_replicas\": 0,"
        applySetting("analytics.mpp.enabled", "false");
     * Aggregate over a three-way join ({@code A ⋈ B ⋈ C | stats sum(amount) by category}) — the q5/q10
        if (cell instanceof Number) return Double.toString(((Number) cell).doubleValue());
import java.util.List;
        return rows;  
        assertEquals(message, expectedNorm, actualNorm);  
        assertRowMultisetEquals("general (mpp on) vs baseline (mpp off) must produce identical rows", baseline.rows, general.rows);
    private long readStrategyCounter(String strategyName) throws IOException {
     */
        );
        // C: id + category (the group key for the agg-over-join shape).  
    /**
                @SuppressWarnings("unchecked")
                assertNotNull(strategyName + " counter must be present on " + host, value);
                Map<String, Object> body = assertOkAndParse(nodeClient.performRequest(request), "GET /_analytics/_strategies on " + host);  
            + C_INDEX;
        bulkAndRefresh(C_INDEX, cBulk.toString());
            + shards
    private static final String C_INDEX = "gen_c";  
    private static final String A_INDEX = "gen_a";
                Object value = strategies.get(strategyName);
     */  
        ensureDataProvisioned();  
            "LEFT-outer 3-way: GENERAL scheduler must match coord-centric baseline (cascade is INNER-only — general closes this gap)",
        // B: id + label.  
            + A_INDEX
            + " | inner join left=A right=B on A.id = B.id "
            + B_INDEX
 * The OpenSearch Contributors require contributions made to  
     * this to two binary worker tiers: bottom A⋈B worker, top (A⋈B)⋈C worker.  
        Run baseline = runBaseline(ppl);
            + A_INDEX
        } catch (Exception ignored) {}  
 * worker promotion (binary tiers), and PARTIAL-aggregate-on-worker → coordinator-FINAL. The contract is
     *  multi-way shape, matching {@link HashShuffleJoinIT}'s sizing. */
}
    private void ensureDataProvisioned() throws IOException {
            + " | stats sum(amount) as total by category"
    }
    }  
        applySetting("analytics.mpp.enabled", "true");
            + "},"  
    private static void assertRowMultisetEquals(String message, List<List<Object>> expected, List<List<Object>> actual) {  
    private void bulkAndRefresh(String indexName, String bulkBody) throws IOException {
    }
        createParquetIndex(B_INDEX, SHARDS, "{\"id\": {\"type\": \"integer\"}, \"label\": {\"type\": \"keyword\"}}");
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.analytics.qa;
    private void createParquetIndex(String name, int shards, String mappingProperties) throws IOException {  
    private static void assertCounterAdvanced(String message, long delta) {  
        resetSetting("analytics.mpp.enabled");
        client().performRequest(request);  
        bulkRequest.addParameter("refresh", "true");
            sb.append(normalizeCell(row.get(i)));
            + ","  
        assertRowMultisetEquals(
 * ({@code DistributionEnforcementPass} + {@code GeneralShuffleDAGRewriter} + {@code UnifiedDispatch}).
        resetSetting("analytics.mpp.broadcast.probe_estimate");  
        Map<String, Object> body = assertOkAndParse(response, "PPL: " + ppl);
        for (int i = 0; i < ROW_COUNT; i++) {  
        for (int i = 0; i < ROW_COUNT; i++) {  
    }
 * compatible open source license.
/*  
        Request request = new Request("PUT", "/_cluster/settings");
        Run baseline = runBaseline(ppl);
            + mappingProperties
        createParquetIndex(C_INDEX, SHARDS, "{\"id\": {\"type\": \"integer\"}, \"category\": {\"type\": \"keyword\"}}");
    private Run execute(String ppl) throws IOException {  
    public void tearDown() throws Exception {  
        StringBuilder sb = new StringBuilder("[");
        List<List<Object>> rows = executePplRows(ppl);
        assertCounterAdvanced("general scheduler distributes the agg-over-join (HASH_SHUFFLE)", general.hashShuffleDelta);  
 * exercises the ACTUAL execution: the DataFusion native backend, the hash-shuffle transport, in-place
 */
    }
        applySetting("analytics.mpp.broadcast.probe_estimate", "20");
        ensureDataProvisioned();
            general.rows
        Run general = runGeneral(ppl);  
    }
 * strategy counter (it distributes via worker tiers).  
    }
            + C_INDEX
    /** Coord-centric baseline: MPP off. */  
 * End-to-end tests for the GENERAL post-CBO scheduler on a real multi-data-node cluster  
            + "}";
    private static String normalizeCell(Object cell) {  
        @SuppressWarnings("unchecked")  
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");  
            + B_INDEX  
     */
    }  
        long total = 0L;
            cBulk.append("{\"index\":{}}\n");
            + "\"settings\": {"  
 * row-multiset PARITY between two runs of every shape:  
            aBulk.append("{\"index\":{}}\n");
    private static boolean dataProvisioned = false;  
    private static final int CATEGORIES = 4;
 * Both must produce identical row multisets. The general run additionally must advance the HASH_SHUFFLE
            client().performRequest(new Request("DELETE", "/" + name));
            cBulk.append("{\"id\":").append(i).append(",\"category\":\"cat-").append(i % CATEGORIES).append("\"}\n");
        long hashAfter = readStrategyCounter("HASH_SHUFFLE");  
     * this data, but parity is multiset-strict — and it proves a multi-way LEFT-outer runs end-to-end on
            aBulk.append("{\"id\":").append(i).append(",\"amount\":").append((i % 100) + 1).append("}\n");
     * (on the coordinator). Parity baseline vs general.  
 * <ol>
 * a LEFT-outer multi-way join (outer joins co-partition; null-fill is partition-local).  
            bBulk.append("{\"id\":").append(i).append(",\"label\":\"lbl-").append(i % 7).append("\"}\n");
            + C_INDEX;
        return execute(ppl);  
            return;
     * Parity across baseline / legacy-MPP / general; general advances HASH_SHUFFLE.
        String body = "{"
     *  dataset (5000 rows/index) clears it and the join actually distributes — the production default is 1M
 * SPDX-License-Identifier: Apache-2.0
        if (dataProvisioned) {  
        super.tearDown();
        Run general = runGeneral(ppl);
    // ─── run helpers (each sets the gates, snapshots the HASH_SHUFFLE counter, runs) ────────────
import org.opensearch.client.Response;
        Run baseline = runBaseline(ppl);
        applySetting("analytics.mpp.broadcast.probe_estimate", "20");  
        bulkAndRefresh(B_INDEX, bBulk.toString());
    public void testMppEnabledKillSwitchParity() throws IOException {  
    private static String normalizeRow(List<Object> row) {  
    /**
    }
        applySetting("analytics.mpp.distribute.min_rows", "1");
/**
    }
 * <p>Data: three parquet indices keyed on {@code id}, each multi-shard, each large enough that the size
 *
            baseline.rows,  
     * rows. Guards the MPP_ENABLED gate as a clean emergency revert to coordinator-centric.
        createParquetIndex(A_INDEX, SHARDS, "{\"id\": {\"type\": \"integer\"}, \"amount\": {\"type\": \"integer\"}}");
        Response response = client().performRequest(request);
            + A_INDEX
            + " | inner join left=A right=C on A.id = C.id "
    /**  
            + B_INDEX
        create.setJsonEntity(body);
import java.util.Map;  
    }
            + "  \"index.pluggable.dataformat.enabled\": true,"
        }
            + "\"mappings\": { \"properties\": "
        String ppl = "source = "  
     */
        Map<String, Object> response = assertOkAndParse(client().performRequest(create), "Create index " + name);
            + " | left join left=A right=B on A.id = B.id "  
 *
        bulkRequest.setJsonEntity(bulkBody);
        List<String> expectedNorm = expected.stream().map(GeneralSchedulerJoinIT::normalizeRow).sorted().toList();
    }
        Request request = new Request("POST", "/_analytics/ppl");
 * floor distributes the join (partitionCount = data nodes &gt; 1).  
                Request request = new Request("GET", "/_analytics/_strategies");
    // ─── data provisioning ──────────────────────────────────────────────────────  
        request.setJsonEntity("{\"transient\": {\"" + key + "\": " + value + "}}");
            + " }"  
     * LEFT-outer three-way join. The general scheduler co-partitions outer joins too (null-fill is
    private static final String B_INDEX = "gen_b";
        try {
            + " | left join left=A right=C on A.id = C.id "
            + " | inner join left=A right=C on A.id = C.id "
        assertCounterAdvanced("general scheduler distributes the LEFT-outer 3-way join (HASH_SHUFFLE)", general.hashShuffleDelta);  
        assertEquals("baseline agg-over-3-way: one row per category", CATEGORIES, baseline.rows.size());
    public void testLeftOuterThreeWayJoin_generalMatchesBaseline() throws IOException {
    private Run runBaseline(String ppl) throws IOException {
        Request request = new Request("PUT", "/_cluster/settings");
    public void testAggOverThreeWayJoin_generalMatchesBaseline() throws IOException {
        List<List<Object>> rows = (List<List<Object>>) body.get("rows");
        Request bulkRequest = new Request("POST", "/" + indexName + "/_bulk");  
        applySetting("analytics.mpp.broadcast.probe_estimate", "20");
        dataProvisioned = true;  
        client().performRequest(request);  
 *
        applySetting("analytics.mpp.broadcast.probe_estimate", "20");
        return total;  
        Run general = runGeneral(ppl);
public class GeneralSchedulerJoinIT extends AnalyticsRestTestCase {
        }  
            }
    private Run runGeneral(String ppl) throws IOException {  
        resetSetting("analytics.mpp.distribute.min_rows");
 */  
        assertCounterAdvanced("general scheduler distributes the 3-way join (HASH_SHUFFLE)", general.hashShuffleDelta);
            + C_INDEX;  
            + B_INDEX  
    // ─── PPL + cluster-setting helpers (mirror HashShuffleJoinIT) ────────────────
                assertNotNull("strategies must be present on " + host, strategies);  
    private static final int ROW_COUNT = 5_000;  
            + "  \"index.composite.secondary_data_formats\": [\"lucene\"]"
 * </ol>
        }
        }
     * partition-local). With matching ids on all sides the LEFT-outer output equals the INNER output for  
    private record Run(List<List<Object>> rows, long hashShuffleDelta) {}
        assertRowMultisetEquals("agg-over-3-way: GENERAL scheduler must match baseline", baseline.rows, general.rows);
        assertEquals("index creation must be acknowledged", true, response.get("acknowledged"));  
 *
                Map<String, Object> strategies = (Map<String, Object>) body.get("strategies");
            if (i > 0) sb.append('|');  
        return cell.toString();  
     * class. The general pass splits the aggregate into PARTIAL (on the top worker, per-partition) + FINAL
        client().performRequest(new Request("POST", "/" + indexName + "/_flush?force=true"));
        ensureDataProvisioned();
            try (org.opensearch.client.RestClient nodeClient = org.opensearch.client.RestClient.builder(host).build()) {
            + A_INDEX  
        }  
import org.opensearch.client.Request;
        return execute(ppl);  
        String ppl = "source = "
        health.addParameter("timeout", "60s");
        bulkAndRefresh(A_INDEX, aBulk.toString());
 *   <li><b>baseline</b> — {@code analytics.mpp.enabled=false} (every join coordinator-centric);</li>
 * <p>The shapes: a multi-way INNER cascade, an aggregate over a multi-way join (PARTIAL on the worker), and
    private void resetSetting(String key) throws IOException {  
        Run baseline = runBaseline(ppl);
            + " | inner join left=A right=B on A.id = B.id "
    private static final int SHARDS = 3;
        ensureDataProvisioned();
        }  
     *  (sized for sf=10 fact tables), far above this test data. */
            + "  \"index.composite.primary_data_format\": \"parquet\","
    private List<List<Object>> executePplRows(String ppl) throws IOException {
import java.io.IOException;
        request.setJsonEntity("{\"transient\": {\"" + key + "\": null}}");
        for (int i = 0; i < ROW_COUNT; i++) {  
        // A: id + amount (the fact-ish side carrying the measure).  
            + " | inner join left=A right=B on A.id = B.id "
    private void applySetting(String key, String value) throws IOException {  
        Request create = new Request("PUT", "/" + name);  
    /** General post-CBO scheduler: MPP on (the only MPP path). Lower the row floor to 1 so the small IT  
        for (org.apache.hc.core5.http.HttpHost host : getClusterHosts()) {  
    }
            + " | inner join left=A right=C on A.id = C.id "  
        return new Run(rows, hashAfter - hashBefore);
    }
    }
        if (cell == null) return "<NULL>";
     *  (analytics.mpp.distribute.min_rows) defaults to 1M, but each test lowers it to 1 via runGeneral so  
        Request health = new Request("GET", "/_cluster/health/" + name);
            + "  \"index.pluggable.dataformat\": \"composite\","  
        StringBuilder cBulk = new StringBuilder();
     * Kill-switch parity: flipping {@code analytics.mpp.enabled} on a multi-way join must yield identical  
        Run general = runGeneral(ppl);  
        List<String> actualNorm = actual.stream().map(GeneralSchedulerJoinIT::normalizeRow).sorted().toList();
        StringBuilder aBulk = new StringBuilder();
 *   <li><b>general</b> — {@code mpp.enabled=true} (the only MPP scheduler — the general post-CBO pass).</li>  
        assertRowMultisetEquals("3-way INNER: GENERAL scheduler must match coord-centric baseline", baseline.rows, general.rows);  
        long hashBefore = readStrategyCounter("HASH_SHUFFLE");
        for (int i = 0; i < row.size(); i++) {
        assertEquals("baseline 3-way INNER: N matching ids", ROW_COUNT, baseline.rows.size());
        String ppl = "source = "
        bulkRequest.setOptions(bulkRequest.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());  
                total += ((Number) value).longValue();  
    @Override
