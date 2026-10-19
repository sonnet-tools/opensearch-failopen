    /** Top {@code n} of {@code total} ascending ids, taken descending: {@code total-1 … total-n}. */
    private void applySetting(String key, String value) throws IOException {
        return bulk.toString();
        resetSetting("analytics.mpp.enabled");
        client().performRequest(health);
    private PplResult executePplRows(String ppl) throws IOException {
    /** Column names + rows from the {@code /_analytics/ppl} shim. */
    private static List<Integer> expectedSuffixDescending(int total, int n) {
import java.util.Map;
     * shard. Sweeps shard count × fetch size — the answer must be the exact prefix in every cell.
            for (int fetch : List.of(1, 4, 100)) {
            ids.add(((Number) row.get(column)).intValue());
        bulkAndRefresh(index, bulkBodyFor(500));
        health.addParameter("wait_for_status", "yellow");
            "fields after head: projection pushdown narrows the scan, still the exact prefix",
    // ─── helpers ──────────────────────────────────────────────────────────────
                );
        return out;
        assertEquals("run1 == run2 (determinism)", runs.get(1), runs.get(2));
        );
        }
 * ({@code SortPushdownIT}, {@code LateMaterializationDateNanosIT}) never caught it.
            return i >= 0 ? i : 0;
    private static final String JOIN = "source = " + LEFT_INDEX + " | inner join left=L right=R on L.id = R.id " + RIGHT_INDEX;
import java.util.List;
 *
        for (List<Object> row : result.rows()) {
            client().performRequest(new Request("DELETE", "/" + name));
                    idsOf(executePplRows(ppl))
        client().performRequest(request);
            }
        createParquetIndex(RIGHT_INDEX, SHARDS, "{\"id\": {\"type\": \"integer\"}, \"category\": {\"type\": \"keyword\"}}");
    }
    // ─── regression 2: join | sort | head ─────────────────────────────────────
    public void tearDown() throws Exception {
        Map<String, Object> response = assertOkAndParse(client().performRequest(create), "Create index " + name);
        } catch (Exception ignored) {}
    }
    private static List<Integer> expectedPrefix(int n) {
 * fixed.
        health.addParameter("timeout", "60s");
            "descending: the exact suffix, reversed",
    }
        ensureJoinDataProvisioned();
 * {@code DataFusionFragmentConvertor.replaceInput} rewired {@code Fetch.input = newInput} and
        List<Integer> out = new ArrayList<>(n);
/*
 *
            + "  \"index.pluggable.dataformat.enabled\": true,"
        for (int i = 0; i < 3; i++) {
        List<Integer> shuffle = idsOf(executePplRows(JOIN + " | sort L.id | head " + ROW_COUNT));
        List<Integer> coord = idsOf(executePplRows(JOIN + " | sort L.id | head " + ROW_COUNT));
        applySetting("analytics.mpp.distribute.min_rows", "1");
                    columns.add(String.valueOf(m.get("name")));
 * correct answer: ids {@code 0..N-1} in ascending order. Tests assert that exact prefix rather than
    public void testSortHeadNeighbourShapes_multiShard() throws IOException {
    }
    /**
        assertEquals(
        resetSetting("analytics.mpp.distribute.min_rows");
            String index = "sh_corr_qtf_s" + shards;
    }
 * coordinator-centric path, so this was never an MPP defect.
 * {@code parentSink}, which for a root stage is the {@code RowProducingSink} holding the answer:
        assertEquals("coord fully sorted 0..4999", expectedPrefix(ROW_COUNT), coord);
        Request request = new Request("POST", "/_analytics/ppl");
    @Override
 * 0 rows (HTTP 200, no error). That shape makes the QTF / late-materialization rewriter fire — it
     * pin the neighbours of the failing shape and would catch a fix that broke them.
        try {
            createParquetIndex(index, shards, TWO_COL_MAPPING);
        StringBuilder bulk = new StringBuilder();
        bulkRequest.setJsonEntity(bulkBody);
        request.setJsonEntity("{\"transient\": {\"" + key + "\": null}}");
            + "  \"index.composite.primary_data_format\": \"parquet\","
            expectedSuffixDescending(500, 10),
        assertEquals(
        assertEquals("coord list == shuffle list", coord, shuffle);
     * The bug: unprojected {@code sort id | head N} returned 0 rows on any index with more than one
 *
        List<List<Integer>> runs = new ArrayList<>();
 * The OpenSearch Contributors require contributions made to
        Request request = new Request("PUT", "/_cluster/settings");
            }
        setMpp(false);
        assertNotNull("Response missing 'rows' field for query: " + ppl, rows);
    /** Shard counts swept by the QTF test: 1 proves the no-exchange path, >1 exercises QTF. */
    /** The same coord-centric query must give the same exact prefix on every run. */
    public void testJoinSortHead_coordAndShuffleAgree() throws IOException {
 * <h2>Regression 2 — Sort dropped under a Fetch</h2>
        List<Integer> shuffle = idsOf(executePplRows(JOIN + " | sort L.id"));
 * fetch lowers to {@code Fetch(Sort(input))}), so {@code head N} returned N arrival-order rows and
 * End-to-end correctness of PPL {@code sort <col> | head N} — the shape whose lowering has been
        assertEquals("coord-centric top-100 must be ids 0..99 ascending", expectedPrefix(100), runs.get(0));
public class PplSortHeadCorrectnessIT extends AnalyticsRestTestCase {
            expectedPrefix(10),
        client().performRequest(bulkRequest);
                }
                } else {
        List<Integer> coord = idsOf(executePplRows(JOIN + " | sort L.id | head 100"));
    @SuppressWarnings("unchecked")
    }
            + "},"
            idsOf(executePplRows("source = " + index + " | sort - id | head 10"))
 * <h2>Regression 1 — QTF root stage returned zero rows</h2>
    // ─── regression 1: QTF / late-materialization root stage ──────────────────
        dataProvisioned = true;
            + "  \"number_of_shards\": " + shards + ","
     */
        setMpp(true);
        }
}
    }
            idsOf(executePplRows("source = " + index + " | sort id | head 1000"))
            for (Object entry : entries) {
        int column = result.idColumn();
 * which rows arrived first varied with shard scheduling. Fixed by #21912; kept here so it stays
        assertEquals("coord returns all rows", ROW_COUNT, coord.size());
        StringBuilder rightBulk = new StringBuilder();
            expectedPrefix(500),
        Map<String, Object> body = assertOkAndParse(response, "PPL: " + ppl);
        List<Integer> out = new ArrayList<>(n);
                    expectedPrefix(fetch),
        client().performRequest(request);
            bulkAndRefresh(index, bulkBodyFor(500));
    }
        setMpp(false);
        Object rawColumns = body.get("columns") != null ? body.get("columns") : body.get("schema");
            idsOf(executePplRows("source = " + index + " | fields id | sort id | head 10"))
    private static List<Integer> idsOf(PplResult result) {
        assertEquals("top-100 must be ids 0..99 ascending", expectedPrefix(100), coord);
 * {@code close()} freed and cleared every batch before {@code QueryExecution} read it. Adding
 * {@code | fields …} anywhere makes the skip predicate decline, which is why the pre-existing ITs
    private void setMpp(boolean enabled) throws IOException {
import org.opensearch.client.Request;
        String index = "sh_corr_neighbours";
        );
     * (an explicit projection makes the QTF skip predicate decline, or reverses the prefix), so they
    private static final int SHARDS = 5;
    }
        }
            + "\"mappings\": { \"properties\": " + mappingProperties + " }"
        client().performRequest(new Request("POST", "/" + indexName + "/_flush?force=true"));
            + "  \"index.composite.secondary_data_formats\": [\"lucene\"]"
        );
 * {@code OpenSearchLateMaterialization} as the plan ROOT. {@code Stitcher.finish} then closed its
    }
    /** Bulk body of {@code n} docs with distinct ascending ids. */
            "fields before sort: QTF declines, still the exact prefix",
        create.setJsonEntity(body);
        ensureJoinDataProvisioned();
        bulkRequest.setOptions(bulkRequest.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
            rightBulk.append("{\"index\":{}}\n");
    public void testJoinSortHead_coordCentricIsExactPrefixEveryRun() throws IOException {
    private static final List<Integer> SHARD_COUNTS = List.of(1, 2, 3, 5);
            rightBulk.append("{\"id\":").append(i).append(",\"category\":\"cat-").append(i % 4).append("\"}\n");
        return new PplResult(columns, rows);
        List<Integer> coord = idsOf(executePplRows(JOIN + " | sort L.id"));
    /** {@code head N} where N == total is a no-op fetch and must not perturb the order. */
import org.opensearch.client.Response;
    /** {@code sort} with no {@code head} must agree on both paths and be fully ordered. */
        String body = "{"
        super.tearDown();
    private static String bulkBodyFor(int n) {
    private static final int ROW_COUNT = 5_000;
        createParquetIndex(index, SHARDS, TWO_COL_MAPPING);
 * <p>Every dataset here has distinct ascending ids, so {@code sort id | head N} has exactly ONE
        );
import java.io.IOException;
    private void bulkAndRefresh(String indexName, String bulkBody) throws IOException {
                    "shards=" + shards + " fetch=" + fetch + ": `" + ppl + "` must return ids 0.." + (fetch - 1),
            + "\"settings\": {"
    }
        if (dataProvisioned) return;
    }
    }
        request.setJsonEntity("{\"transient\": {\"" + key + "\": " + value + "}}");
            runs.add(idsOf(executePplRows(JOIN + " | sort L.id | head 100")));
    private void ensureJoinDataProvisioned() throws IOException {
        assertEquals("fully sorted 0..4999", expectedPrefix(ROW_COUNT), coord);
    private void resetSetting(String key) throws IOException {
            expectedPrefix(10),
        }
 * SPDX-License-Identifier: Apache-2.0
        applySetting("analytics.mpp.broadcast.probe_estimate", "20");
        Request bulkRequest = new Request("POST", "/" + indexName + "/_bulk");
 * wrong twice, in two independent places.
            int i = columns.indexOf("id");
        applySetting("analytics.mpp.enabled", String.valueOf(enabled));
     * distribute floor, and a 2-node cluster makes broadcast cheap enough to beat hash-shuffle.
    public void testJoinSortHeadEqualToTotal_preservesOrderOnBothPaths() throws IOException {
        for (int i = 0; i < n; i++) out.add(i);
        return out;
        assertEquals(
            "head larger than the dataset returns every row, fully sorted",
    private static boolean dataProvisioned = false;
        resetSetting("analytics.mpp.broadcast.probe_estimate");
        assertEquals("run0 == run1 (determinism)", runs.get(0), runs.get(1));
    public void testJoinSortWithoutHead_coordAndShuffleAgree() throws IOException {
        /** Index of the {@code id} column — the join/sort key the assertions read. */
package org.opensearch.analytics.qa;
 * mere run-to-run stability — a stable-but-wrong answer is still a bug.
        ensureJoinDataProvisioned();
        assertEquals("coord list == shuffle list", coord, shuffle);
        List<Integer> ids = new ArrayList<>(result.rows().size());
        if (rawColumns instanceof List<?> entries) {
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
    /** The original cross-path failure — top-100 must match on coord-centric and hash-shuffle. */
    private void createParquetIndex(String name, int shards, String mappingProperties) throws IOException {
    }
            + "  \"number_of_replicas\": 0,"
        for (int shards : SHARD_COUNTS) {
        setMpp(true);
     * Descending mirror plus the two {@code fields} placements. These already passed before the fix
 * ExchangeReducer to anchor on, hence multi-shard only — and leaves
        bulkAndRefresh(RIGHT_INDEX, rightBulk.toString());
    private record PplResult(List<String> columns, List<List<Object>> rows) {
    /** Projects the {@code id} column (the sort key) out of a PPL result. */
        bulkRequest.addParameter("refresh", "true");
 * {@code join | sort L.id | head 100} returned a different 100 rows on every run — even on a single
        setMpp(false);
    }
            bulk.append("{\"index\":{}}\n");
                    columns.add(String.valueOf(entry));
        Request request = new Request("PUT", "/_cluster/settings");
            + "  \"index.pluggable.dataformat\": \"composite\","
                assertEquals(
    private static final String RIGHT_INDEX = "sh_corr_right";
        for (int i = 0; i < n; i++) out.add(total - 1 - i);
    }
    private static final String LEFT_INDEX = "sh_corr_left";
 */
        createParquetIndex(LEFT_INDEX, SHARDS, TWO_COL_MAPPING);
 * compatible open source license.
        }
        List<Integer> shuffle = idsOf(executePplRows(JOIN + " | sort L.id | head 100"));
        for (int i = 0; i < n; i++) {
     */
        Response response = client().performRequest(request);
        List<String> columns = new ArrayList<>();
        }
        bulkAndRefresh(LEFT_INDEX, bulkBodyFor(ROW_COUNT));
    /**
        for (int i = 0; i < ROW_COUNT; i++) {
 * An <em>unprojected</em> {@code source = idx | sort <col> | head N} on a multi-shard index returned
     * MPP gate plus the two overrides the join steps need: the IT dataset sits below the production
 * this file be licensed under the Apache-2.0 license or a
    public void testUnprojectedSortHead_isExactPrefixAtEveryShardCount() throws IOException {
    /**
        assertEquals(
    }
        List<List<Object>> rows = (List<List<Object>>) body.get("rows");
        setMpp(false);
        setMpp(false);
        }
 * fires only when a projected column is absent from the sort key, and only when there is an
        assertEquals("coord list == shuffle list", coord, shuffle);
        Request create = new Request("PUT", "/" + name);
                String ppl = "source = " + index + " | sort id | head " + fetch;
            + "}";
/**
    }
            bulk.append("{\"id\":").append(i).append(",\"amount\":").append((i + 1) * 10).append("}\n");
 * dropped the {@code Sort} beneath it (a Calcite {@code LogicalSort} carrying both a collation and a
                if (entry instanceof Map<?, ?> m) {
        return ids;
     */
    private static final String TWO_COL_MAPPING = "{\"id\": {\"type\": \"integer\"}, \"amount\": {\"type\": \"integer\"}}";
        ensureJoinDataProvisioned();
import java.util.ArrayList;
        int idColumn() {
        setMpp(true);
        Request health = new Request("GET", "/_cluster/health/" + name);
 */
        setMpp(false);
 *
        assertEquals("index creation must be acknowledged", true, response.get("acknowledged"));
            idsOf(executePplRows("source = " + index + " | sort id | head 10 | fields id"))
    }
