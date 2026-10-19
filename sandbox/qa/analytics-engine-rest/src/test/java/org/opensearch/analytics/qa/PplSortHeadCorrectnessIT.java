            expectedPrefix(500),
        return out;
        assertEquals("coord fully sorted 0..4999", expectedPrefix(ROW_COUNT), coord);
        Request bulkRequest = new Request("POST", "/" + indexName + "/_bulk");
 * dropped the {@code Sort} beneath it (a Calcite {@code LogicalSort} carrying both a collation and a
     * The bug: unprojected {@code sort id | head N} returned 0 rows on any index with more than one
    }
        setMpp(false);
        String body = "{"  
        assertEquals("index creation must be acknowledged", true, response.get("acknowledged"));
 */  
 * <h2>Regression 1 — QTF root stage returned zero rows</h2>
        List<Integer> shuffle = idsOf(executePplRows(JOIN + " | sort L.id | head 100"));
        assertEquals("coord-centric top-100 must be ids 0..99 ascending", expectedPrefix(100), runs.get(0));  
        List<Integer> coord = idsOf(executePplRows(JOIN + " | sort L.id | head " + ROW_COUNT));
 *
        assertEquals("fully sorted 0..4999", expectedPrefix(ROW_COUNT), coord);  
        resetSetting("analytics.mpp.broadcast.probe_estimate");  
 *  
        Response response = client().performRequest(request);
        int idColumn() {
            + "},"
        assertNotNull("Response missing 'rows' field for query: " + ppl, rows);
 * mere run-to-run stability — a stable-but-wrong answer is still a bug.  
            for (Object entry : entries) {  
        Request request = new Request("PUT", "/_cluster/settings");  
    /** The original cross-path failure — top-100 must match on coord-centric and hash-shuffle. */
    public void testSortHeadNeighbourShapes_multiShard() throws IOException {
        /** Index of the {@code id} column — the join/sort key the assertions read. */  
        if (rawColumns instanceof List<?> entries) {
     */  
        applySetting("analytics.mpp.enabled", String.valueOf(enabled));
 *
        try {
 * {@code | fields …} anywhere makes the skip predicate decline, which is why the pre-existing ITs
        return out;  
                } else {  
        resetSetting("analytics.mpp.enabled");
        ensureJoinDataProvisioned();
        super.tearDown();
import java.util.ArrayList;
    }
 * which rows arrived first varied with shard scheduling. Fixed by #21912; kept here so it stays
    }
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
        StringBuilder bulk = new StringBuilder();
        List<Integer> shuffle = idsOf(executePplRows(JOIN + " | sort L.id"));  
 * coordinator-centric path, so this was never an MPP defect.  
            ids.add(((Number) row.get(column)).intValue());  
            rightBulk.append("{\"id\":").append(i).append(",\"category\":\"cat-").append(i % 4).append("\"}\n");
        setMpp(false);
        request.setJsonEntity("{\"transient\": {\"" + key + "\": null}}");
        for (int shards : SHARD_COUNTS) {  
            + "  \"number_of_shards\": " + shards + ","
    }
    /**  
package org.opensearch.analytics.qa;
    public void tearDown() throws Exception {  
    }  
        assertEquals("run0 == run1 (determinism)", runs.get(0), runs.get(1));
        setMpp(true);
        setMpp(false);  
        for (int i = 0; i < ROW_COUNT; i++) {
    public void testJoinSortHead_coordCentricIsExactPrefixEveryRun() throws IOException {  
    private void ensureJoinDataProvisioned() throws IOException {
        setMpp(true);
    private void applySetting(String key, String value) throws IOException {
    private static final int SHARDS = 5;
     * MPP gate plus the two overrides the join steps need: the IT dataset sits below the production
        assertEquals(
            idsOf(executePplRows("source = " + index + " | sort id | head 1000"))
    @SuppressWarnings("unchecked")
 * ({@code SortPushdownIT}, {@code LateMaterializationDateNanosIT}) never caught it.
    public void testUnprojectedSortHead_isExactPrefixAtEveryShardCount() throws IOException {
        client().performRequest(bulkRequest);  
    private record PplResult(List<String> columns, List<List<Object>> rows) {
        for (int i = 0; i < n; i++) out.add(total - 1 - i);  
/*  
            "descending: the exact suffix, reversed",
import java.util.List;  
    private static String bulkBodyFor(int n) {  
        client().performRequest(request);
            idsOf(executePplRows("source = " + index + " | sort id | head 10 | fields id"))
            return i >= 0 ? i : 0;  
    private static List<Integer> expectedSuffixDescending(int total, int n) {
 * this file be licensed under the Apache-2.0 license or a
            + "  \"number_of_replicas\": 0,"  
            + "\"settings\": {"
        );  
    /**  
        }
            }  
        String index = "sh_corr_neighbours";
    private static final List<Integer> SHARD_COUNTS = List.of(1, 2, 3, 5);  
/**  
        assertEquals("coord list == shuffle list", coord, shuffle);
    }
            rightBulk.append("{\"index\":{}}\n");  
    }
    @Override
        return new PplResult(columns, rows);
        setMpp(false);
    // ─── regression 1: QTF / late-materialization root stage ──────────────────
                );
     * shard. Sweeps shard count × fetch size — the answer must be the exact prefix in every cell.
        List<Integer> coord = idsOf(executePplRows(JOIN + " | sort L.id"));
     * pin the neighbours of the failing shape and would catch a fix that broke them.  
        Request request = new Request("POST", "/_analytics/ppl");  
    private static boolean dataProvisioned = false;
            bulk.append("{\"index\":{}}\n");  
            + "\"mappings\": { \"properties\": " + mappingProperties + " }"  
        Object rawColumns = body.get("columns") != null ? body.get("columns") : body.get("schema");
     */
 * <p>Every dataset here has distinct ascending ids, so {@code sort id | head N} has exactly ONE
        setMpp(false);  
    }
        bulkAndRefresh(index, bulkBodyFor(500));  
 * fixed.
            createParquetIndex(index, shards, TWO_COL_MAPPING);
        health.addParameter("timeout", "60s");  
                    columns.add(String.valueOf(entry));
        List<List<Object>> rows = (List<List<Object>>) body.get("rows");
 * SPDX-License-Identifier: Apache-2.0
 * An <em>unprojected</em> {@code source = idx | sort <col> | head N} on a multi-shard index returned  
        Map<String, Object> response = assertOkAndParse(client().performRequest(create), "Create index " + name);
        ensureJoinDataProvisioned();
    private static final String RIGHT_INDEX = "sh_corr_right";
            + "  \"index.composite.primary_data_format\": \"parquet\","  
        setMpp(true);
    private static final String JOIN = "source = " + LEFT_INDEX + " | inner join left=L right=R on L.id = R.id " + RIGHT_INDEX;  
        List<Integer> out = new ArrayList<>(n);
    public void testJoinSortHeadEqualToTotal_preservesOrderOnBothPaths() throws IOException {
        create.setJsonEntity(body);  
    /** Projects the {@code id} column (the sort key) out of a PPL result. */
        List<Integer> out = new ArrayList<>(n);
        client().performRequest(request);
    /** Top {@code n} of {@code total} ascending ids, taken descending: {@code total-1 … total-n}. */  
                if (entry instanceof Map<?, ?> m) {
 * The OpenSearch Contributors require contributions made to  
    private static final int ROW_COUNT = 5_000;  
    }
        Map<String, Object> body = assertOkAndParse(response, "PPL: " + ppl);  
                    "shards=" + shards + " fetch=" + fetch + ": `" + ppl + "` must return ids 0.." + (fetch - 1),
 * correct answer: ids {@code 0..N-1} in ascending order. Tests assert that exact prefix rather than
        assertEquals("coord list == shuffle list", coord, shuffle);
 * fetch lowers to {@code Fetch(Sort(input))}), so {@code head N} returned N arrival-order rows and  
        for (int i = 0; i < 3; i++) {
            for (int fetch : List.of(1, 4, 100)) {
        assertEquals("top-100 must be ids 0..99 ascending", expectedPrefix(100), coord);
        ensureJoinDataProvisioned();
    private static final String TWO_COL_MAPPING = "{\"id\": {\"type\": \"integer\"}, \"amount\": {\"type\": \"integer\"}}";
    }  
            "fields before sort: QTF declines, still the exact prefix",  
    }  
        createParquetIndex(LEFT_INDEX, SHARDS, TWO_COL_MAPPING);  
        List<String> columns = new ArrayList<>();  
        int column = result.idColumn();  
        assertEquals("coord list == shuffle list", coord, shuffle);  
            bulk.append("{\"id\":").append(i).append(",\"amount\":").append((i + 1) * 10).append("}\n");
    /** Bulk body of {@code n} docs with distinct ascending ids. */
            bulkAndRefresh(index, bulkBodyFor(500));  
        for (List<Object> row : result.rows()) {
        List<Integer> ids = new ArrayList<>(result.rows().size());
 * End-to-end correctness of PPL {@code sort <col> | head N} — the shape whose lowering has been
import java.io.IOException;
        applySetting("analytics.mpp.distribute.min_rows", "1");  
            String index = "sh_corr_qtf_s" + shards;
        }  
     * distribute floor, and a 2-node cluster makes broadcast cheap enough to beat hash-shuffle.
        createParquetIndex(index, SHARDS, TWO_COL_MAPPING);
        List<List<Integer>> runs = new ArrayList<>();  
}
    private void setMpp(boolean enabled) throws IOException {
    /** Shard counts swept by the QTF test: 1 proves the no-exchange path, >1 exercises QTF. */
        assertEquals(
        return bulk.toString();  
            }
    private void bulkAndRefresh(String indexName, String bulkBody) throws IOException {
        }
        );
        List<Integer> coord = idsOf(executePplRows(JOIN + " | sort L.id | head 100"));  
    }
        bulkRequest.setJsonEntity(bulkBody);  
import org.opensearch.client.Request;
    }  
        resetSetting("analytics.mpp.distribute.min_rows");
 * {@code close()} freed and cleared every batch before {@code QueryExecution} read it. Adding  
                    idsOf(executePplRows(ppl))  
        if (dataProvisioned) return;
            client().performRequest(new Request("DELETE", "/" + name));  
                    columns.add(String.valueOf(m.get("name")));
        Request request = new Request("PUT", "/_cluster/settings");  
        Request create = new Request("PUT", "/" + name);
    }
    /** {@code sort} with no {@code head} must agree on both paths and be fully ordered. */  
        for (int i = 0; i < n; i++) out.add(i);
     * (an explicit projection makes the QTF skip predicate decline, or reverses the prefix), so they
    /** {@code head N} where N == total is a no-op fetch and must not perturb the order. */  
            expectedPrefix(10),  
        bulkAndRefresh(RIGHT_INDEX, rightBulk.toString());  
        assertEquals(
        ensureJoinDataProvisioned();
    }
 * ExchangeReducer to anchor on, hence multi-shard only — and leaves  
    // ─── helpers ──────────────────────────────────────────────────────────────
        health.addParameter("wait_for_status", "yellow");
public class PplSortHeadCorrectnessIT extends AnalyticsRestTestCase {
        }
            idsOf(executePplRows("source = " + index + " | sort - id | head 10"))  
    /** The same coord-centric query must give the same exact prefix on every run. */
    private static final String LEFT_INDEX = "sh_corr_left";  
            "fields after head: projection pushdown narrows the scan, still the exact prefix",
        applySetting("analytics.mpp.broadcast.probe_estimate", "20");
    private void resetSetting(String key) throws IOException {
    private static List<Integer> idsOf(PplResult result) {
    private PplResult executePplRows(String ppl) throws IOException {
            idsOf(executePplRows("source = " + index + " | fields id | sort id | head 10"))
 * 0 rows (HTTP 200, no error). That shape makes the QTF / late-materialization rewriter fire — it
                }
        StringBuilder rightBulk = new StringBuilder();
    private void createParquetIndex(String name, int shards, String mappingProperties) throws IOException {
        Request health = new Request("GET", "/_cluster/health/" + name);
import org.opensearch.client.Response;
        }
    public void testJoinSortHead_coordAndShuffleAgree() throws IOException {  
        );  
        assertEquals(  
 * compatible open source license.
        client().performRequest(health);
    private static List<Integer> expectedPrefix(int n) {  
    // ─── regression 2: join | sort | head ─────────────────────────────────────  
        bulkAndRefresh(LEFT_INDEX, bulkBodyFor(ROW_COUNT));
    }  
            int i = columns.indexOf("id");
        return ids;
                String ppl = "source = " + index + " | sort id | head " + fetch;
            runs.add(idsOf(executePplRows(JOIN + " | sort L.id | head 100")));
        createParquetIndex(RIGHT_INDEX, SHARDS, "{\"id\": {\"type\": \"integer\"}, \"category\": {\"type\": \"keyword\"}}");  
                    expectedPrefix(fetch),
 *  
        request.setJsonEntity("{\"transient\": {\"" + key + "\": " + value + "}}");
        for (int i = 0; i < n; i++) {
        );
        }  
import java.util.Map;
            + "  \"index.pluggable.dataformat.enabled\": true,"
            + "}";
    }
        assertEquals("run1 == run2 (determinism)", runs.get(1), runs.get(2));
                assertEquals(  
 * <h2>Regression 2 — Sort dropped under a Fetch</h2>
 * {@code OpenSearchLateMaterialization} as the plan ROOT. {@code Stitcher.finish} then closed its
 * fires only when a projected column is absent from the sort key, and only when there is an
    }
        assertEquals("coord returns all rows", ROW_COUNT, coord.size());
    public void testJoinSortWithoutHead_coordAndShuffleAgree() throws IOException {
 */  
            expectedSuffixDescending(500, 10),
    /**  
 * {@code join | sort L.id | head 100} returned a different 100 rows on every run — even on a single
        client().performRequest(new Request("POST", "/" + indexName + "/_flush?force=true"));
        } catch (Exception ignored) {}
            + "  \"index.composite.secondary_data_formats\": [\"lucene\"]"
    }
    /** Column names + rows from the {@code /_analytics/ppl} shim. */
        }
            expectedPrefix(10),
 * wrong twice, in two independent places.
        setMpp(false);  
        bulkRequest.addParameter("refresh", "true");
 * {@code DataFusionFragmentConvertor.replaceInput} rewired {@code Fetch.input = newInput} and
            + "  \"index.pluggable.dataformat\": \"composite\","
        dataProvisioned = true;
        bulkRequest.setOptions(bulkRequest.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
     * Descending mirror plus the two {@code fields} placements. These already passed before the fix
 * {@code parentSink}, which for a root stage is the {@code RowProducingSink} holding the answer:
     */  
        List<Integer> shuffle = idsOf(executePplRows(JOIN + " | sort L.id | head " + ROW_COUNT));  
            "head larger than the dataset returns every row, fully sorted",  
