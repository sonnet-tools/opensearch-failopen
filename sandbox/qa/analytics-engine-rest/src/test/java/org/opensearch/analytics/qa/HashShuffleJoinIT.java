        // Counter assertions guard the JVM-side dispatch decision: mpp.enabled steers CBO toward
        long hashBefore = readStrategyCounter("HASH_SHUFFLE");
    // ─── data provisioning ─────────────────────────────────────────────────────
     * should advance.
            + "  \"number_of_shards\": " + shards + ","
            shuffleDelta.rows
        resetSetting("analytics.mpp.broadcast.probe_estimate");
     * HASH_SHUFFLE (broadcast cost grows as O(rows × probeNodes), hash as O(total_rows)),
     * MPP kill-switch regression for the hash-shuffle locale: flipping
            + LEFT_INDEX
 * The OpenSearch Contributors require contributions made to
     * gates every MPP split rule.
        StrategyDelta shuffleDelta = runWithMppAndCounters(ppl, /* mpp */ true);
    private record StrategyDelta(List<List<Object>> rows, long broadcastDelta, long hashShuffleDelta) {}
            baselineDelta.rows,
            shuffleDelta.rows
        StringBuilder rightBulk = new StringBuilder();
 * this file be licensed under the Apache-2.0 license or a
     * NULL on the build side. We assert row-multiset parity against the coord-centric baseline
        if (cell == null) return "<NULL>";
 * <p>Data shape:
            try (org.opensearch.client.RestClient nodeClient = org.opensearch.client.RestClient.builder(host).build()) {
    public void testFullOuterJoin_largeLeftWithLargeRight_picksHashShuffle() throws IOException {
    private List<List<Object>> executePplRows(String ppl) throws IOException {
        assertEquals("HASH_SHUFFLE counter must NOT advance when mpp.enabled=false", 0L, baselineDelta.hashShuffleDelta);
        String ppl = "source = "
    }
 *
     * for that locale. Parity against the coord-centric baseline + counter advancement.
    private StrategyDelta runWithMppAndCounters(String ppl, boolean mppEnabled) throws IOException {
        StrategyDelta baselineDelta = runWithMppAndCounters(ppl, /* mpp */ false);
        StrategyDelta shuffleDelta = runWithMppAndCounters(ppl, /* mpp */ true);
    /**
    }
    }
     * — this inflates broadcast's perceived cost (rows×N) past hash-shuffle's (rows + setup×N)
     * gives us a stable read independent of routing.
            "HASH_SHUFFLE counter must NOT advance when mpp.enabled=false",
     */
    public void testInnerEquiJoin_statsAfterJoin_picksHashShuffle() throws IOException {
/*
 * compatible open source license.
    }
     */
        for (org.apache.hc.core5.http.HttpHost host : getClusterHosts()) {
        assertEquals(
        StrategyDelta shuffleDelta = runWithMppAndCounters(ppl, /* mpp */ true);
        assertEquals("head 100 returns at most 100 rows", 100, shuffleDelta.rows.size());
        assertEquals("RIGHT OUTER preserves all right rows", RIGHT_ROW_COUNT, baselineDelta.rows.size());
            + "},"
            + "\"mappings\": { \"properties\": " + mappingProperties + " }"
    private static final String LEFT_INDEX = "shuf_left";
    public void testInnerEquiJoin_sortHeadAfterJoin_picksHashShuffle() throws IOException {
        assertEquals("HASH_SHUFFLE counter must NOT advance when mpp.enabled=false", 0L, mppOff.hashShuffleDelta);
        assertEquals("HASH_SHUFFLE counter must NOT advance when mpp.enabled=false", 0L, delta.hashShuffleDelta);
            leftBulk.append("{\"index\":{}}\n");
        );
        StringBuilder leftBulk = new StringBuilder();
            + RIGHT_INDEX
        assertNotNull("Response missing 'rows' field for query: " + ppl, rows);
     * override; broadcast loses naturally on real-sized data + larger clusters.
    /** Sort + head DOWNSTREAM of a hash-shuffle join. */
    /** Both sides large enough that broadcast cost (~rows × probeNodes) clearly loses to
 * advances only when MPP is on and the cost gate picks hash-shuffle.
    /**
        client().performRequest(request);
            expectedInnerJoinRowCount(),
        long total = 0L;
        bulkAndRefresh(LEFT_INDEX, leftBulk.toString());
            + " | inner join left=L right=R on L.id = R.id "
            leftBulk.append("{\"id\":").append(i).append(",\"amount\":").append((i + 1) * 10).append("}\n");
     * which side hosts the hash table for RIGHT vs LEFT). Same multiset-parity contract.
        assertCounterAdvanced("HASH_SHUFFLE fires for join-then-sort-head large×large", shuffleDelta.hashShuffleDelta);
        bulkRequest.addParameter("refresh", "true");
    }
 *   <li>{@code shuf_left} — 5 shards, ~5000 rows. Both sides "large" so the broadcast cost
        client().performRequest(new Request("POST", "/" + indexName + "/_flush?force=true"));
        // Small IT data sits below the production distribute floor (1M); lower it so the join/agg
 */
            "join-then-stats large×large: HASH_SHUFFLE must match coord-centric baseline",
        assertCounterAdvanced("HASH_SHUFFLE fires when mpp.enabled=true for large×large", shuffleDelta.hashShuffleDelta);
        // Reset settings to default so a failure in one test doesn't leak into the next. The
        Request health = new Request("GET", "/_cluster/health/" + name);
        ensureDataProvisioned();
        return sb.append(']').toString();
/**
    }
 * <p>Mirrors {@link BroadcastJoinIT} but exercises the cost-model branch where both join inputs
        ensureDataProvisioned();
     * natively — the build side hosts the hash table and unmatched probe rows are preserved with
        // Full multiset comparison: every row produced by coord-centric must also be
    /**
        // finishes inside ~10s even when the producer-side stub leaves the consumer waiting.
        Response response = client().performRequest(request);
            baselineDelta.hashShuffleDelta
        assertRowMultisetEquals(
        StrategyDelta baselineDelta = runWithMppAndCounters(ppl, /* mpp */ false);
            shuffleDelta.rows
 * are large enough that broadcast loses to hash-shuffle. The IT toggles
    }
    }
        super.tearDown();
     */
        bulkRequest.setJsonEntity(bulkBody);
    private static int expectedInnerJoinRowCount() {
            return;
     * the dispatcher should route through HashShuffleDispatch, and the HASH_SHUFFLE counter
            rightBulk.append("{\"id\":").append(i).append(",\"category\":\"cat-").append(i % 4).append("\"}\n");
        applySetting("analytics.mpp.broadcast.probe_estimate", "20");
     */
        // check available here — `sort L.id | head N` would only pin a 100-row prefix.
    }
        assertEquals(
    }
    /**
        try {
     * <p>The IT cluster has 2 data nodes, which makes broadcast cheap (rows×2) for symmetric
import org.opensearch.client.Response;
    private void applySetting(String key, String value) throws IOException {
    /** Bundles a query's row output with both BROADCAST and HASH_SHUFFLE counter deltas. */
    private static void assertCounterAdvanced(String message, long delta) {
    private static final String RIGHT_INDEX = "shuf_right";
            expectedInnerJoinRowCount(),
        List<String> actualNorm = actual.stream().map(HashShuffleJoinIT::normalizeRow).sorted().toList();
        ensureDataProvisioned();
        String ppl = "source = "
        // Both sides have ids 0..LEFT_ROW_COUNT-1 so an INNER equi-join produces N matches.
        assertEquals(
    /**
        // pass on two equally-broken runs (e.g. each returning a Cartesian product).
        assertRowMultisetEquals(
            baselineDelta.rows,
        applySetting("analytics.mpp.broadcast.probe_estimate", "20");
        client().performRequest(health);
    // ─── PPL + cluster-setting helpers ─────────────────────────────────────────
     * semantics — see {@code OpenSearchBroadcastJoinSplitRule}). Hash-shuffle is the **only** MPP
 *
        assertRowMultisetEquals(
        // handler-side awaitReady timeout (5s default) caps wall-clock so each test method
        }
        String body = "{"
        assertCounterAdvanced("HASH_SHUFFLE fires for RIGHT OUTER large×large", shuffleDelta.hashShuffleDelta);
}
            + "  \"number_of_replicas\": 0,"
 */
     * probe-node estimate to a much larger value via {@code analytics.mpp.broadcast.probe_estimate}
        assertCounterAdvanced("HASH_SHUFFLE fires when mpp.enabled=true for large×large", mppOn.hashShuffleDelta);
    }
            baselineDelta.rows,
        }
     */
        );
    public void testMppDisabled_keepsAllMppCountersAtZero() throws IOException {
     */
        assertRowMultisetEquals(
        assertRowMultisetEquals(
     * {@code BroadcastJoinIT.testMppKillSwitchProducesSameRowsAsBaseline} for the
        health.addParameter("timeout", "60s");
    }
        resetSetting("analytics.mpp.distribute.min_rows");
            shuffleDelta.rows
    public void testMppKillSwitchProducesSameRowsAsBaseline() throws IOException {
            baselineDelta.rows,
        request.setJsonEntity("{\"transient\": {\"" + key + "\": null}}");
            "FULL OUTER large×large: HASH_SHUFFLE must match coord-centric baseline",
        StrategyDelta shuffleDelta = runWithMppAndCounters(ppl, /* mpp */ true);
 *       (~{@code rows × probeNodes}) loses to hash-shuffle (~{@code rows + N × setup}).</li>
     *  reliably picks HASH_SHUFFLE for this query shape. */
    }
        // Both sides have ids 0..N-1; INNER produces N matches.
            + "  \"index.pluggable.dataformat\": \"composite\","
    }
     * LEFT OUTER large × large with shuffle enabled. Hash-shuffle's HashJoinExec runs LEFT OUTER
            shuffleDelta.rows.size()
 *
     * yield identical row multisets. The mpp-on run takes the hash-shuffle path (counter
     * RIGHT OUTER mirror of {@link #testLeftOuterJoin_largeLeftWithLargeRight_picksHashShuffle}.
     * without changing the actual cluster topology. Production deployments don't need this
        // Compare the FULL join output as multisets between coord-centric and hash-shuffle:
            + " | stats sum(amount) as total by category"
        assertRowMultisetEquals(
     * {@code analytics.mpp.enabled} between two runs of an INNER large × large equi-join must
    private static boolean dataProvisioned = false;
        long broadcastAfter = readStrategyCounter("BROADCAST");
     * advances); the mpp-off run takes coord-centric. Sibling of
    private static String normalizeCell(Object cell) {
        long broadcastBefore = readStrategyCounter("BROADCAST");
        String ppl = "source = " + LEFT_INDEX + " | inner join left=L right=R on L.id = R.id " + RIGHT_INDEX;
        );
        // Force CBO to favor hash by inflating the broadcast probe-node estimate. With a
            mppOff.rows,
        Request request = new Request("POST", "/_analytics/ppl");
    public void testInnerEquiJoin_largeLeftWithLargeRight_picksHashShuffle() throws IOException {
        // Independently sanity-check the baseline so the parity assertion can't trivially
        bulkAndRefresh(RIGHT_INDEX, rightBulk.toString());
 * SPDX-License-Identifier: Apache-2.0
            + "\"settings\": {"
    private void createParquetIndex(String name, int shards, String mappingProperties) throws IOException {
        applySetting("analytics.mpp.broadcast.probe_estimate", "20");
        long hashAfter = readStrategyCounter("HASH_SHUFFLE");
        List<List<Object>> rows = executePplRows(ppl);
        assertTrue(message + " (counter delta was " + delta + ")", delta > 0);
    }
            "INNER large×large: HASH_SHUFFLE must match coord-centric baseline (full row set)",
     */
        return Math.min(LEFT_ROW_COUNT, RIGHT_ROW_COUNT);
    /**
        client().performRequest(bulkRequest);
        Map<String, Object> response = assertOkAndParse(client().performRequest(create), "Create index " + name);
                @SuppressWarnings("unchecked")
        create.setJsonEntity(body);
        bulkRequest.setOptions(bulkRequest.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
        }
                Object value = strategies.get(strategyName);
            shuffleDelta.rows
package org.opensearch.analytics.qa;
    /**
import java.io.IOException;
 *   <li>{@code shuf_right} — 5 shards, ~5000 rows. Same shape; both sides shuffle-eligible.</li>
        );
        Request create = new Request("PUT", "/" + name);
            sb.append(normalizeCell(row.get(i)));
    private static void assertRowMultisetEquals(String message, List<List<Object>> expected, List<List<Object>> actual) {
 * {@code analytics.mpp.enabled} across cases and asserts that the cluster's HASH_SHUFFLE counter
     * "MPP path produces different result than baseline" because parity is multiset-strict.
        // 2-node cluster, default probeNodes=2 and broadcast cost ~rows×2 ties hash on
            "HASH_SHUFFLE counter must NOT advance when mpp.enabled=false",
     * The join executes in parallel on the worker tier (HASH_SHUFFLE); its output flows up to a
        StrategyDelta delta = runWithMppAndCounters(ppl, /* mpp */ false);
        assertEquals("4 categories grouped from joined rows", 4, baselineDelta.rows.size());
    public void testRightOuterJoin_largeLeftWithLargeRight_picksHashShuffle() throws IOException {
        Request request = new Request("PUT", "/_cluster/settings");
     * coordinator that handled the query; the test client round-robins so the sum is what
    public void tearDown() throws Exception {
    private void bulkAndRefresh(String indexName, String bulkBody) throws IOException {
        // any row dropped, duplicated, or mis-joined by the shuffle path shows up as a
        StrategyDelta mppOff = runWithMppAndCounters(ppl, /* mpp */ false);
    }
        ensureDataProvisioned();
    }
        @SuppressWarnings("unchecked")
        StrategyDelta baselineDelta = runWithMppAndCounters(ppl, /* mpp */ false);
                assertNotNull(strategyName + " counter must be present on " + host, value);
    private long readStrategyCounter(String strategyName) throws IOException {
            "baseline INNER large×large: matching ids occur once each",
        applySetting("analytics.mpp.broadcast.probe_estimate", "20");
        );
        applySetting("analytics.mpp.enabled", String.valueOf(mppEnabled));
    /**
        // 4 categories ('cat-0'..'cat-3') in the right side; each receives 1250 fact rows.
        assertEquals("BROADCAST must not advance for FULL OUTER with MPP on (FULL is broadcast-ineligible)", 0L, shuffleDelta.broadcastDelta);
    /**
            + "  \"index.composite.secondary_data_formats\": [\"lucene\"]"
     * strategy that handles FULL on the data-node engine; this test is the load-bearing guard
     * Hero test: large × large INNER equi-join with shuffle enabled. CBO should pick
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
        // distributes and the HASH_SHUFFLE strategy fires (matches GeneralSchedulerJoinIT).
    @Override
        Request request = new Request("PUT", "/_cluster/settings");
        return total;
     * large×large data. To deterministically force HASH_SHUFFLE we override the broadcast
            }
                Map<String, Object> strategies = (Map<String, Object>) body.get("strategies");
        // partitions, duplicated rows, and join-key mismatches.
     * Catches build/probe role bugs from the opposite side (DataFusion's HashJoinExec swaps
    private void resetSetting(String key) throws IOException {
            if (i > 0) sb.append('|');
     *  costs were close enough that broadcast won; 5000 makes the cost gap obvious so CBO
        resetSetting("analytics.mpp.enabled");
            baselineDelta.rows,
        ensureDataProvisioned();
                Map<String, Object> body = assertOkAndParse(nodeClient.performRequest(request), "GET /_analytics/_strategies on " + host);
 * End-to-end tests for the HASH_SHUFFLE join path on a 2-node cluster.
        // produced by hash-shuffle, and vice versa. Catches dropped rows, mis-routed hash
        for (int i = 0; i < RIGHT_ROW_COUNT; i++) {
        if (cell instanceof Number) return Double.toString(((Number) cell).doubleValue());
        applySetting("analytics.mpp.broadcast.probe_estimate", "20");
        }
        dataProvisioned = true;
        List<String> expectedNorm = expected.stream().map(HashShuffleJoinIT::normalizeRow).sorted().toList();
        Map<String, Object> body = assertOkAndParse(response, "PPL: " + ppl);
        if (dataProvisioned) {
        for (int i = 0; i < LEFT_ROW_COUNT; i++) {
     * Stats DOWNSTREAM of a hash-shuffle join: {@code source=L | join R | stats sum(amount) by category}.
        );
        List<List<Object>> rows = (List<List<Object>>) body.get("rows");
     *  hash-shuffle (~rows + N × setup) and to coord-centric (~2 × rows). At 30 each, the
        StrategyDelta baselineDelta = runWithMppAndCounters(ppl, /* mpp */ false);
        StrategyDelta baselineDelta = runWithMppAndCounters(ppl, /* mpp */ false);
            baselineDelta.hashShuffleDelta
            "shuffle INNER large×large: matching ids occur once each",
            "LEFT OUTER large×large: HASH_SHUFFLE must match coord-centric baseline",
    private static final int LEFT_ROW_COUNT = 5_000;
            0L,
public class HashShuffleJoinIT extends AnalyticsRestTestCase {
            + " | inner join left=L right=R on L.id = R.id "
        String ppl = "source = " + LEFT_INDEX + " | left join left=L right=R on L.id = R.id " + RIGHT_INDEX;
        // HASH_SHUFFLE for this query shape; mpp.enabled=false routes through coord-centric.
            "RIGHT OUTER large×large: HASH_SHUFFLE must match coord-centric baseline",
        assertCounterAdvanced("HASH_SHUFFLE fires for LEFT OUTER large×large", shuffleDelta.hashShuffleDelta);
        health.addParameter("wait_for_status", "yellow");
     * shuffle strategy.
        // Broadcast must not fire for FULL OUTER under either run — split rule rejects FULL.
     *
    private static final int RIGHT_ROW_COUNT = 5_000;
        }
    private static final int RIGHT_SHARDS = 5;
        Request bulkRequest = new Request("POST", "/" + indexName + "/_bulk");
import java.util.Map;
        ensureDataProvisioned();
 * </ul>
            + RIGHT_INDEX
    }
 * <ul>
            mppOn.rows
            client().performRequest(new Request("DELETE", "/" + name));
    private static String normalizeRow(List<Object> row) {
            + "}";
        String ppl = "source = " + LEFT_INDEX + " | inner join left=L right=R on L.id = R.id " + RIGHT_INDEX;
     */
    }
     * Sums a single strategy counter across all cluster nodes. The dispatcher records on the
        assertEquals("LEFT OUTER preserves all left rows", LEFT_ROW_COUNT, baselineDelta.rows.size());
     * preserves both halves so neither side can be replicated without breaking row-preservation
        StrategyDelta shuffleDelta = runWithMppAndCounters(ppl, /* mpp */ true);
import org.opensearch.client.Request;
        String ppl = "source = " + LEFT_INDEX + " | right join left=L right=R on L.id = R.id " + RIGHT_INDEX;
    public void testLeftOuterJoin_largeLeftWithLargeRight_picksHashShuffle() throws IOException {
        } catch (Exception ignored) {}
        // multiset mismatch. Kept as a full-multiset comparison because it is the strictest
        ensureDataProvisioned();
        applySetting("analytics.mpp.broadcast.probe_estimate", "20");
        StrategyDelta shuffleDelta = runWithMppAndCounters(ppl, /* mpp */ true);
            + " | sort L.id | head 100";
        );
        assertEquals("index creation must be acknowledged", true, response.get("acknowledged"));
        assertEquals(
        StringBuilder sb = new StringBuilder("[");
     * output, not just a plain TableScan.
        StrategyDelta mppOn = runWithMppAndCounters(ppl, /* mpp */ true);
    private void ensureDataProvisioned() throws IOException {
        // small-medium data. probeEstimate=20 forces broadcast ~rows×20, well above hash.
        applySetting("analytics.mpp.broadcast.probe_estimate", "20");
            "INNER large×large: kill-switch parity (mpp on vs off must produce identical rows)",
                Request request = new Request("GET", "/_analytics/_strategies");
        return cell.toString();
        ensureDataProvisioned();
    private static final int LEFT_SHARDS = 5;
            + "  \"index.composite.primary_data_format\": \"parquet\","
     * consumer-reduce → root-agg pipeline composes — agg can sit on top of a HASH_SHUFFLE join's
        );
        assertCounterAdvanced("HASH_SHUFFLE fires for join-then-stats large×large", shuffleDelta.hashShuffleDelta);
        for (int i = 0; i < row.size(); i++) {
            + LEFT_INDEX
     * FULL OUTER large × large. Broadcast deliberately rejects FULL (no eligible build side: full
        assertEquals(message, expectedNorm, actualNorm);
        );
     * Apply the MPP gate, snapshot per-strategy counters, run the PPL, return rows + deltas for
     * coordinator-side stats stage that re-aggregates per category. Validates that the worker →
        request.setJsonEntity("{\"transient\": {\"" + key + "\": " + value + "}}");
                total += ((Number) value).longValue();
        assertEquals("HASH_SHUFFLE counter must NOT advance when mpp.enabled=false", 0L, baselineDelta.hashShuffleDelta);
        assertEquals("HASH_SHUFFLE counter must NOT advance when mpp.enabled=false", 0L, baselineDelta.hashShuffleDelta);
            rightBulk.append("{\"index\":{}}\n");
        return new StrategyDelta(rows, broadcastAfter - broadcastBefore, hashAfter - hashBefore);
        assertEquals("BROADCAST counter must also stay at zero when mpp.enabled=false", 0L, delta.broadcastDelta);
        assertCounterAdvanced("HASH_SHUFFLE fires for FULL OUTER large×large", shuffleDelta.hashShuffleDelta);
     */
            + "  \"index.pluggable.dataformat.enabled\": true,"
        String ppl = "source = " + LEFT_INDEX + " | full join left=L right=R on L.id = R.id " + RIGHT_INDEX;
        createParquetIndex(RIGHT_INDEX, RIGHT_SHARDS, "{\"id\": {\"type\": \"integer\"}, \"category\": {\"type\": \"keyword\"}}");
     * (the ground truth) and check the HASH_SHUFFLE counter advances. With matching ids on both
        createParquetIndex(LEFT_INDEX, LEFT_SHARDS, "{\"id\": {\"type\": \"integer\"}, \"amount\": {\"type\": \"integer\"}}");
    }
     * both BROADCAST and HASH_SHUFFLE so each test can assert on whichever it cares about.
        );
            baselineDelta.rows.size()
     * sides the LEFT OUTER output is identical to INNER for this dataset; the test still catches
        client().performRequest(request);
                assertNotNull("strategies must be present on " + host, strategies);
    }
        return rows;
        String ppl = "source = " + LEFT_INDEX + " | inner join left=L right=R on L.id = R.id " + RIGHT_INDEX;
            + " | sort category";
    }
        assertEquals("BROADCAST must not advance for FULL OUTER with MPP off", 0L, baselineDelta.broadcastDelta);
            0L,
import java.util.List;
     * Negative: with mpp off, neither BROADCAST nor HASH_SHUFFLE fires; the master kill switch
        applySetting("analytics.mpp.distribute.min_rows", "1");
