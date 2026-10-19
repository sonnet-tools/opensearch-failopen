        }
        bulkRequest.setJsonEntity(bulkBody);
        applySetting("analytics.mpp.broadcast.probe_estimate", "20");
/*  
        // multiset mismatch. Kept as a full-multiset comparison because it is the strictest
            shuffleDelta.rows.size()
    private record StrategyDelta(List<List<Object>> rows, long broadcastDelta, long hashShuffleDelta) {}  
        String ppl = "source = " + LEFT_INDEX + " | full join left=L right=R on L.id = R.id " + RIGHT_INDEX;
        StrategyDelta baselineDelta = runWithMppAndCounters(ppl, /* mpp */ false);
            + "}";
        request.setJsonEntity("{\"transient\": {\"" + key + "\": null}}");  
        resetSetting("analytics.mpp.distribute.min_rows");  
    public void testInnerEquiJoin_largeLeftWithLargeRight_picksHashShuffle() throws IOException {  
    }
package org.opensearch.analytics.qa;
            0L,
    /**
        client().performRequest(bulkRequest);
        assertEquals(
            "HASH_SHUFFLE counter must NOT advance when mpp.enabled=false",  
        applySetting("analytics.mpp.broadcast.probe_estimate", "20");
     * MPP kill-switch regression for the hash-shuffle locale: flipping
        // Both sides have ids 0..N-1; INNER produces N matches.
        try {  
        bulkAndRefresh(LEFT_INDEX, leftBulk.toString());
    private static boolean dataProvisioned = false;
        applySetting("analytics.mpp.broadcast.probe_estimate", "20");
            expectedInnerJoinRowCount(),
    }  
            expectedInnerJoinRowCount(),  
            leftBulk.append("{\"id\":").append(i).append(",\"amount\":").append((i + 1) * 10).append("}\n");
            return;
            "LEFT OUTER large×large: HASH_SHUFFLE must match coord-centric baseline",
            + LEFT_INDEX  
    }  
 * SPDX-License-Identifier: Apache-2.0
 * advances only when MPP is on and the cost gate picks hash-shuffle.  
        applySetting("analytics.mpp.broadcast.probe_estimate", "20");
 * {@code analytics.mpp.enabled} across cases and asserts that the cluster's HASH_SHUFFLE counter
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
            }
     */
        assertCounterAdvanced("HASH_SHUFFLE fires when mpp.enabled=true for large×large", mppOn.hashShuffleDelta);
     * coordinator that handled the query; the test client round-robins so the sum is what
 */
     *  hash-shuffle (~rows + N × setup) and to coord-centric (~2 × rows). At 30 each, the
        applySetting("analytics.mpp.broadcast.probe_estimate", "20");
        return sb.append(']').toString();
 *
 * End-to-end tests for the HASH_SHUFFLE join path on a 2-node cluster.  
    }
     */
        assertCounterAdvanced("HASH_SHUFFLE fires for join-then-sort-head large×large", shuffleDelta.hashShuffleDelta);
 * this file be licensed under the Apache-2.0 license or a
                Object value = strategies.get(strategyName);
        long total = 0L;  
        );  
    /** Sort + head DOWNSTREAM of a hash-shuffle join. */
        assertEquals(
        request.setJsonEntity("{\"transient\": {\"" + key + "\": " + value + "}}");  
    }
    private void resetSetting(String key) throws IOException {
        StrategyDelta shuffleDelta = runWithMppAndCounters(ppl, /* mpp */ true);
        assertEquals("head 100 returns at most 100 rows", 100, shuffleDelta.rows.size());
        long broadcastBefore = readStrategyCounter("BROADCAST");
        String ppl = "source = " + LEFT_INDEX + " | inner join left=L right=R on L.id = R.id " + RIGHT_INDEX;
        return Math.min(LEFT_ROW_COUNT, RIGHT_ROW_COUNT);
    /**
    }
        StrategyDelta mppOff = runWithMppAndCounters(ppl, /* mpp */ false);
                total += ((Number) value).longValue();
        health.addParameter("timeout", "60s");
 *   <li>{@code shuf_left} — 5 shards, ~5000 rows. Both sides "large" so the broadcast cost
        assertRowMultisetEquals(
    private void ensureDataProvisioned() throws IOException {
        assertEquals("HASH_SHUFFLE counter must NOT advance when mpp.enabled=false", 0L, baselineDelta.hashShuffleDelta);
        );  
 *
        ensureDataProvisioned();
            rightBulk.append("{\"index\":{}}\n");  
        }  
        );
    public void testInnerEquiJoin_statsAfterJoin_picksHashShuffle() throws IOException {  
        // handler-side awaitReady timeout (5s default) caps wall-clock so each test method  
        long hashBefore = readStrategyCounter("HASH_SHUFFLE");
    }
        List<String> expectedNorm = expected.stream().map(HashShuffleJoinIT::normalizeRow).sorted().toList();
                Map<String, Object> strategies = (Map<String, Object>) body.get("strategies");  
     * — this inflates broadcast's perceived cost (rows×N) past hash-shuffle's (rows + setup×N)
        assertEquals(
            shuffleDelta.rows  
        // small-medium data. probeEstimate=20 forces broadcast ~rows×20, well above hash.
        StrategyDelta shuffleDelta = runWithMppAndCounters(ppl, /* mpp */ true);
        StrategyDelta delta = runWithMppAndCounters(ppl, /* mpp */ false);
    private StrategyDelta runWithMppAndCounters(String ppl, boolean mppEnabled) throws IOException {
                Request request = new Request("GET", "/_analytics/_strategies");  
        // 2-node cluster, default probeNodes=2 and broadcast cost ~rows×2 ties hash on  
     * {@code analytics.mpp.enabled} between two runs of an INNER large × large equi-join must
            baselineDelta.hashShuffleDelta
        // any row dropped, duplicated, or mis-joined by the shuffle path shows up as a
        // Force CBO to favor hash by inflating the broadcast probe-node estimate. With a
            sb.append(normalizeCell(row.get(i)));
        Map<String, Object> response = assertOkAndParse(client().performRequest(create), "Create index " + name);  
        StrategyDelta shuffleDelta = runWithMppAndCounters(ppl, /* mpp */ true);  
     * advances); the mpp-off run takes coord-centric. Sibling of
            + "},"  
     * LEFT OUTER large × large with shuffle enabled. Hash-shuffle's HashJoinExec runs LEFT OUTER
            "baseline INNER large×large: matching ids occur once each",  
            baselineDelta.rows,
     * "MPP path produces different result than baseline" because parity is multiset-strict.
        if (cell instanceof Number) return Double.toString(((Number) cell).doubleValue());  
        Map<String, Object> body = assertOkAndParse(response, "PPL: " + ppl);  
    public void testFullOuterJoin_largeLeftWithLargeRight_picksHashShuffle() throws IOException {
     * shuffle strategy.  
        resetSetting("analytics.mpp.enabled");
    }
        );
     */
            + " | stats sum(amount) as total by category"
        return rows;
        List<String> actualNorm = actual.stream().map(HashShuffleJoinIT::normalizeRow).sorted().toList();  
        client().performRequest(health);  
    private static final int RIGHT_SHARDS = 5;
        create.setJsonEntity(body);
        // Small IT data sits below the production distribute floor (1M); lower it so the join/agg
            try (org.opensearch.client.RestClient nodeClient = org.opensearch.client.RestClient.builder(host).build()) {
            + "  \"number_of_replicas\": 0,"
     * yield identical row multisets. The mpp-on run takes the hash-shuffle path (counter  
    /**
    /**
        }  
        StrategyDelta shuffleDelta = runWithMppAndCounters(ppl, /* mpp */ true);  
        );
        assertCounterAdvanced("HASH_SHUFFLE fires for RIGHT OUTER large×large", shuffleDelta.hashShuffleDelta);  
        );
    private static final int RIGHT_ROW_COUNT = 5_000;
        assertTrue(message + " (counter delta was " + delta + ")", delta > 0);
    private static final String RIGHT_INDEX = "shuf_right";  
    public void testLeftOuterJoin_largeLeftWithLargeRight_picksHashShuffle() throws IOException {  
        assertCounterAdvanced("HASH_SHUFFLE fires when mpp.enabled=true for large×large", shuffleDelta.hashShuffleDelta);
        applySetting("analytics.mpp.broadcast.probe_estimate", "20");
     */
     */
        health.addParameter("wait_for_status", "yellow");
    // ─── PPL + cluster-setting helpers ─────────────────────────────────────────
            "INNER large×large: HASH_SHUFFLE must match coord-centric baseline (full row set)",
        client().performRequest(request);
            + "  \"number_of_shards\": " + shards + ","  
        return total;
     * Apply the MPP gate, snapshot per-strategy counters, run the PPL, return rows + deltas for
        String ppl = "source = "
        dataProvisioned = true;
        assertEquals(message, expectedNorm, actualNorm);
                assertNotNull(strategyName + " counter must be present on " + host, value);  
    /**
        assertEquals("HASH_SHUFFLE counter must NOT advance when mpp.enabled=false", 0L, baselineDelta.hashShuffleDelta);
        ensureDataProvisioned();
    }  
     * both BROADCAST and HASH_SHUFFLE so each test can assert on whichever it cares about.  
 * are large enough that broadcast loses to hash-shuffle. The IT toggles
            + LEFT_INDEX
            + "  \"index.pluggable.dataformat\": \"composite\","  
    private static void assertCounterAdvanced(String message, long delta) {
            + RIGHT_INDEX
        // produced by hash-shuffle, and vice versa. Catches dropped rows, mis-routed hash
        );
    }
    }
        resetSetting("analytics.mpp.broadcast.probe_estimate");
            shuffleDelta.rows  
        // HASH_SHUFFLE for this query shape; mpp.enabled=false routes through coord-centric.
            if (i > 0) sb.append('|');
        createParquetIndex(RIGHT_INDEX, RIGHT_SHARDS, "{\"id\": {\"type\": \"integer\"}, \"category\": {\"type\": \"keyword\"}}");  
        }
    }
        client().performRequest(request);
    private static final int LEFT_SHARDS = 5;
        if (dataProvisioned) {  
    private void applySetting(String key, String value) throws IOException {
            mppOff.rows,  
            + "  \"index.pluggable.dataformat.enabled\": true,"
    private static final int LEFT_ROW_COUNT = 5_000;
            "FULL OUTER large×large: HASH_SHUFFLE must match coord-centric baseline",  
        );
            0L,  
 * <ul>  
        super.tearDown();
        // 4 categories ('cat-0'..'cat-3') in the right side; each receives 1250 fact rows.
     * override; broadcast loses naturally on real-sized data + larger clusters.
 *   <li>{@code shuf_right} — 5 shards, ~5000 rows. Same shape; both sides shuffle-eligible.</li>  
        applySetting("analytics.mpp.distribute.min_rows", "1");  
        ensureDataProvisioned();  
        ensureDataProvisioned();
     * (the ground truth) and check the HASH_SHUFFLE counter advances. With matching ids on both
        assertCounterAdvanced("HASH_SHUFFLE fires for LEFT OUTER large×large", shuffleDelta.hashShuffleDelta);  
import org.opensearch.client.Response;
        bulkAndRefresh(RIGHT_INDEX, rightBulk.toString());  
        assertEquals("HASH_SHUFFLE counter must NOT advance when mpp.enabled=false", 0L, baselineDelta.hashShuffleDelta);
     * HASH_SHUFFLE (broadcast cost grows as O(rows × probeNodes), hash as O(total_rows)),
    /** Both sides large enough that broadcast cost (~rows × probeNodes) clearly loses to  
            + RIGHT_INDEX  
        client().performRequest(new Request("POST", "/" + indexName + "/_flush?force=true"));  
        StrategyDelta baselineDelta = runWithMppAndCounters(ppl, /* mpp */ false);
     * preserves both halves so neither side can be replicated without breaking row-preservation  
    public void testInnerEquiJoin_sortHeadAfterJoin_picksHashShuffle() throws IOException {
    /**  
    /** Bundles a query's row output with both BROADCAST and HASH_SHUFFLE counter deltas. */
        Request request = new Request("PUT", "/_cluster/settings");
            + " | sort L.id | head 100";  
/**
        for (org.apache.hc.core5.http.HttpHost host : getClusterHosts()) {
     * <p>The IT cluster has 2 data nodes, which makes broadcast cheap (rows×2) for symmetric
        assertEquals("BROADCAST must not advance for FULL OUTER with MPP off", 0L, baselineDelta.broadcastDelta);
        applySetting("analytics.mpp.enabled", String.valueOf(mppEnabled));  
     */
                assertNotNull("strategies must be present on " + host, strategies);
        assertCounterAdvanced("HASH_SHUFFLE fires for FULL OUTER large×large", shuffleDelta.hashShuffleDelta);  
     * the dispatcher should route through HashShuffleDispatch, and the HASH_SHUFFLE counter
        if (cell == null) return "<NULL>";
        StringBuilder rightBulk = new StringBuilder();
        // finishes inside ~10s even when the producer-side stub leaves the consumer waiting.
     * for that locale. Parity against the coord-centric baseline + counter advancement.  
        applySetting("analytics.mpp.broadcast.probe_estimate", "20");
        assertRowMultisetEquals(  
     * output, not just a plain TableScan.
        return cell.toString();
        assertEquals("4 categories grouped from joined rows", 4, baselineDelta.rows.size());
            "INNER large×large: kill-switch parity (mpp on vs off must produce identical rows)",
        // distributes and the HASH_SHUFFLE strategy fires (matches GeneralSchedulerJoinIT).
        StrategyDelta shuffleDelta = runWithMppAndCounters(ppl, /* mpp */ true);
     * NULL on the build side. We assert row-multiset parity against the coord-centric baseline
     * gives us a stable read independent of routing.  
    private void createParquetIndex(String name, int shards, String mappingProperties) throws IOException {
        long hashAfter = readStrategyCounter("HASH_SHUFFLE");
    private long readStrategyCounter(String strategyName) throws IOException {
    }
        List<List<Object>> rows = (List<List<Object>>) body.get("rows");
     * which side hosts the hash table for RIGHT vs LEFT). Same multiset-parity contract.
        }  
     * coordinator-side stats stage that re-aggregates per category. Validates that the worker →
        Request request = new Request("POST", "/_analytics/ppl");  
     * natively — the build side hosts the hash table and unmatched probe rows are preserved with  
            baselineDelta.rows,
        return new StrategyDelta(rows, broadcastAfter - broadcastBefore, hashAfter - hashBefore);  
    }
     * {@code BroadcastJoinIT.testMppKillSwitchProducesSameRowsAsBaseline} for the
        @SuppressWarnings("unchecked")
        String ppl = "source = "  
        assertEquals("HASH_SHUFFLE counter must NOT advance when mpp.enabled=false", 0L, delta.hashShuffleDelta);
    /**
        // check available here — `sort L.id | head N` would only pin a 100-row prefix.  
    private void bulkAndRefresh(String indexName, String bulkBody) throws IOException {  
    private List<List<Object>> executePplRows(String ppl) throws IOException {
     */
            shuffleDelta.rows  
        Request health = new Request("GET", "/_cluster/health/" + name);  
        assertRowMultisetEquals(  
        // pass on two equally-broken runs (e.g. each returning a Cartesian product).
     * sides the LEFT OUTER output is identical to INNER for this dataset; the test still catches  
            "RIGHT OUTER large×large: HASH_SHUFFLE must match coord-centric baseline",
            leftBulk.append("{\"index\":{}}\n");
        // Counter assertions guard the JVM-side dispatch decision: mpp.enabled steers CBO toward  
import java.util.Map;  
 * compatible open source license.
        ensureDataProvisioned();  
     * Negative: with mpp off, neither BROADCAST nor HASH_SHUFFLE fires; the master kill switch  
     * The join executes in parallel on the worker tier (HASH_SHUFFLE); its output flows up to a
import java.io.IOException;
        bulkRequest.addParameter("refresh", "true");  
        assertEquals("index creation must be acknowledged", true, response.get("acknowledged"));
        createParquetIndex(LEFT_INDEX, LEFT_SHARDS, "{\"id\": {\"type\": \"integer\"}, \"amount\": {\"type\": \"integer\"}}");  
    }
        StrategyDelta baselineDelta = runWithMppAndCounters(ppl, /* mpp */ false);
     * Stats DOWNSTREAM of a hash-shuffle join: {@code source=L | join R | stats sum(amount) by category}.  
            + "  \"index.composite.primary_data_format\": \"parquet\","
     * FULL OUTER large × large. Broadcast deliberately rejects FULL (no eligible build side: full
        assertEquals("HASH_SHUFFLE counter must NOT advance when mpp.enabled=false", 0L, mppOff.hashShuffleDelta);
        StrategyDelta mppOn = runWithMppAndCounters(ppl, /* mpp */ true);
            + "  \"index.composite.secondary_data_formats\": [\"lucene\"]"
     * consumer-reduce → root-agg pipeline composes — agg can sit on top of a HASH_SHUFFLE join's  
        // Independently sanity-check the baseline so the parity assertion can't trivially  
     * should advance.  
        assertEquals("BROADCAST must not advance for FULL OUTER with MPP on (FULL is broadcast-ineligible)", 0L, shuffleDelta.broadcastDelta);  
    private static void assertRowMultisetEquals(String message, List<List<Object>> expected, List<List<Object>> actual) {
    /**
            client().performRequest(new Request("DELETE", "/" + name));
     * RIGHT OUTER mirror of {@link #testLeftOuterJoin_largeLeftWithLargeRight_picksHashShuffle}.
            + " | inner join left=L right=R on L.id = R.id "
     *  costs were close enough that broadcast won; 5000 makes the cost gap obvious so CBO
        StrategyDelta shuffleDelta = runWithMppAndCounters(ppl, /* mpp */ true);
}  
     * probe-node estimate to a much larger value via {@code analytics.mpp.broadcast.probe_estimate}
        assertEquals("RIGHT OUTER preserves all right rows", RIGHT_ROW_COUNT, baselineDelta.rows.size());
    }
        String body = "{"
        assertRowMultisetEquals(  
            baselineDelta.hashShuffleDelta
        String ppl = "source = " + LEFT_INDEX + " | inner join left=L right=R on L.id = R.id " + RIGHT_INDEX;
    }
        String ppl = "source = " + LEFT_INDEX + " | inner join left=L right=R on L.id = R.id " + RIGHT_INDEX;
import java.util.List;
 *
    }  
    private static String normalizeCell(Object cell) {
        assertRowMultisetEquals(  
        StrategyDelta baselineDelta = runWithMppAndCounters(ppl, /* mpp */ false);
            shuffleDelta.rows  
            baselineDelta.rows,
     * Sums a single strategy counter across all cluster nodes. The dispatcher records on the
            baselineDelta.rows.size()
    public void tearDown() throws Exception {
        Request create = new Request("PUT", "/" + name);
        );
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < row.size(); i++) {  
 */  
        long broadcastAfter = readStrategyCounter("BROADCAST");
     *  reliably picks HASH_SHUFFLE for this query shape. */  
        StrategyDelta baselineDelta = runWithMppAndCounters(ppl, /* mpp */ false);  
        assertEquals("BROADCAST counter must also stay at zero when mpp.enabled=false", 0L, delta.broadcastDelta);  
    public void testMppDisabled_keepsAllMppCountersAtZero() throws IOException {  
            "HASH_SHUFFLE counter must NOT advance when mpp.enabled=false",
        // Compare the FULL join output as multisets between coord-centric and hash-shuffle:  
        ensureDataProvisioned();
    public void testRightOuterJoin_largeLeftWithLargeRight_picksHashShuffle() throws IOException {  
public class HashShuffleJoinIT extends AnalyticsRestTestCase {  
        } catch (Exception ignored) {}
            "shuffle INNER large×large: matching ids occur once each",
                Map<String, Object> body = assertOkAndParse(nodeClient.performRequest(request), "GET /_analytics/_strategies on " + host);
     * Catches build/probe role bugs from the opposite side (DataFusion's HashJoinExec swaps  
            mppOn.rows
            baselineDelta.rows,
        assertEquals(
        String ppl = "source = " + LEFT_INDEX + " | right join left=L right=R on L.id = R.id " + RIGHT_INDEX;  
        Response response = client().performRequest(request);
            "join-then-stats large×large: HASH_SHUFFLE must match coord-centric baseline",
 * </ul>
    }
        );  
     * strategy that handles FULL on the data-node engine; this test is the load-bearing guard
 * The OpenSearch Contributors require contributions made to  
        bulkRequest.setOptions(bulkRequest.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
     */
            rightBulk.append("{\"id\":").append(i).append(",\"category\":\"cat-").append(i % 4).append("\"}\n");
    }  
        // partitions, duplicated rows, and join-key mismatches.
    private static int expectedInnerJoinRowCount() {  
 *       (~{@code rows × probeNodes}) loses to hash-shuffle (~{@code rows + N × setup}).</li>
        // Broadcast must not fire for FULL OUTER under either run — split rule rejects FULL.
            + " | inner join left=L right=R on L.id = R.id "
                @SuppressWarnings("unchecked")
     * semantics — see {@code OpenSearchBroadcastJoinSplitRule}). Hash-shuffle is the **only** MPP
     */
import org.opensearch.client.Request;
        // Reset settings to default so a failure in one test doesn't leak into the next. The
    // ─── data provisioning ─────────────────────────────────────────────────────  
        // Full multiset comparison: every row produced by coord-centric must also be  
    }
     * gates every MPP split rule.
    public void testMppKillSwitchProducesSameRowsAsBaseline() throws IOException {
     * without changing the actual cluster topology. Production deployments don't need this  
        String ppl = "source = " + LEFT_INDEX + " | left join left=L right=R on L.id = R.id " + RIGHT_INDEX;  
        ensureDataProvisioned();
    }  
    private static final String LEFT_INDEX = "shuf_left";
        Request request = new Request("PUT", "/_cluster/settings");
        assertCounterAdvanced("HASH_SHUFFLE fires for join-then-stats large×large", shuffleDelta.hashShuffleDelta);
            baselineDelta.rows,
        assertNotNull("Response missing 'rows' field for query: " + ppl, rows);  
        List<List<Object>> rows = executePplRows(ppl);  
 * <p>Data shape:
    private static String normalizeRow(List<Object> row) {
            + "\"mappings\": { \"properties\": " + mappingProperties + " }"
 * <p>Mirrors {@link BroadcastJoinIT} but exercises the cost-model branch where both join inputs  
     * Hero test: large × large INNER equi-join with shuffle enabled. CBO should pick  
        StringBuilder leftBulk = new StringBuilder();
    /**  
        Request bulkRequest = new Request("POST", "/" + indexName + "/_bulk");
        // Both sides have ids 0..LEFT_ROW_COUNT-1 so an INNER equi-join produces N matches.
        ensureDataProvisioned();  
            + "\"settings\": {"
        for (int i = 0; i < RIGHT_ROW_COUNT; i++) {
     *
            shuffleDelta.rows
        assertRowMultisetEquals(
    @Override  
            + " | sort category";
        for (int i = 0; i < LEFT_ROW_COUNT; i++) {  
        assertEquals("LEFT OUTER preserves all left rows", LEFT_ROW_COUNT, baselineDelta.rows.size());
     * large×large data. To deterministically force HASH_SHUFFLE we override the broadcast  
