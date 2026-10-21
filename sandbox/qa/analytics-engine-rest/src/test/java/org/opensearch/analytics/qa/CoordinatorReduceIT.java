package org.opensearch.analytics.qa;
    /**
        Object cell = rows.get(0).get(columns.indexOf("f"));
     */
        java.util.Set<Integer> expected = new java.util.HashSet<>();
            + "}"
        indexStringGroupDocs();
        assertNotNull("cell for 't' must not be null — coordinator-reduce returned no value", cell);
        createIndex.setJsonEntity(body);
    public void testPercentileApproxAcrossShards() throws Exception {
    }
        createParquetBackedIndex(index);
        health.addParameter("timeout", "30s");
        Map<String, Object> result = executePpl("source = " + index + " | stats take(value, 3) as t");
        assertTrue("columns must contain 'v', got " + columns, columns.contains("v"));
            actual >= distinct - 2 && actual <= distinct + 2
 *       (Binary intermediate, reducer == self; HLL merge inside the backend)</li>
        assertEquals("values(value) must return exactly 5 distinct elements", 5, got.size());
    public void testValuesSingleShard() throws Exception {
        @SuppressWarnings("unchecked")
        assertOkAndParse(client().performRequest(create), "create " + index);
        bulkAndRefresh(index, bulk.toString());
     * {@code stats count() as cnt} — function-swap at FINAL. PARTIAL emits COUNT(*) as Int64;
        String index = "coord_reduce_first_single";
     * Control for {@link #testGroupByCountMultiShard_allRowsFilteredByWhere}: same query
    }
    private static final String INDEX = "coord_reduce_e2e";
            + "  \"index.composite.secondary_data_formats\": \"lucene\""
        double expected = (totalDocs + 1) / 2.0;
        StringBuilder bulk = new StringBuilder();
     * Shape: {@code WHERE <pred> | stats count() as c by <string-key> | sort - c | head N}
        StringBuilder bulk = new StringBuilder();
import org.opensearch.client.Request;
            + "\"settings\": {"
        List<String> columns = extractColumnNames(result);
            + "}";
    }
        for (int i = 0; i < total; i++) {
        }
        assertTrue("columns must contain 't', got " + columns, columns.contains("t"));
        List<List<Object>> groupRows = (List<List<Object>>) grouped.get("datarows");
    private void indexDuplicateValueDocs(String indexName) throws Exception {
        );
        createSingleShardParquetBackedIndex(index);
        int distinct = 10;
            bulk.append("{\"value\": ").append((i % 10) + 1).append("}\n");
    }
        }
    /**
        createParquetBackedIndex(index);
        @SuppressWarnings("unchecked")
        @SuppressWarnings("unchecked")
            + "  \"index.pluggable.dataformat.enabled\": true,"
            + "  \"properties\": {"
    private void indexDuplicateValueDocsSingleShard(String indexName) throws Exception {
    }
        Map<String, Object> response = assertOkAndParse(client().performRequest(createIndex), "Create index " + indexName);
     * Indexes {@link #NUM_SHARDS} × {@link #DOCS_PER_SHARD} docs where {@code value}
        List<Object> listed = (List<Object>) cell;
        @SuppressWarnings("unchecked")
        );
import org.opensearch.client.Response;
        String body = "{"
    public void testListSingleShard() throws Exception {
        assertNotNull("cell for 'v' must not be null — coordinator-reduce returned no value", cell);
        bulkAndRefresh(index, bulk.toString());
        Request health = new Request("GET", "/_cluster/health/" + indexName);
     * Indexes {@link #NUM_SHARDS} × {@link #DOCS_PER_SHARD} docs with {@code value = i+1},
        assertNotNull("rows must not be null", rows);
        assertNotNull("cell for 'l' must not be null — coordinator-reduce returned no value", cell);
 *
     * approx_distinct Final merges sketches in-place. Tolerance is 10% (standard HLL
            int iv = ((Number) v).intValue();
        Request bulkRequest = new Request("POST", "/" + indexName + "/_bulk");
        }
            "source = " + STRING_GROUP_INDEX + " | where category != '' | stats count() as c by category | sort - c | head 5"
        health.addParameter("wait_for_status", "green");
    }
        int exactDistinct = groupRows.size();
            bulk.append("{\"index\": {}}\n");
        java.util.Set<Integer> seen = new java.util.HashSet<>();
        Map<String, Object> result = executePpl("source = " + index + " | stats dc(value) as dc");
        String index = "coord_reduce_first_multi";
    /**
        assertTrue("values() must return a List, got " + cell.getClass(), cell instanceof List);
 *   <li>{@link #testQ10ShapeAcrossShards()} — all four families in one query, grouped</li>
            + "  }"
 * End-to-end tests for the distributed partial/final aggregate path:
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
            + "  \"index.composite.primary_data_format\": \"parquet\","
            bulk.append("{\"category\": \"\", \"value\": ").append(i + 1).append("}\n");
        long actual = ((Number) scalarRows(result, "dc").get(0).get(0)).longValue();
    }
        assertNotNull("schema must not be null", columns);
        Object cell = rows.get(0).get(columns.indexOf("f"));
        assertTrue("take() must return a List, got " + cell.getClass(), cell instanceof List);
            bulk.append("{\"value\": ").append(i + 1).append("}\n");
        } catch (Exception ignored) {}
            + "\"mappings\": {"
        assertEquals("scalar agg must return exactly 1 row", 1, rows.size());
 *
        indexVaryingValueDocs(index);
            + "  \"index.composite.primary_data_format\": \"parquet\","
        assertNotNull("rows must not be null", rows);
            + "  \"index.pluggable.dataformat\": \"composite\","
    public void testTakeAcrossShards() throws Exception {
        @SuppressWarnings("unchecked")
/*
    /** Single-shard {@code first(value)} — arrival order depends on parquet read; assert membership only. */
        String body = "{\"settings\": {"
     * Indexes {@link #DOCS_PER_SHARD} docs with {@code value = i+1} into a single-shard
        Map<String, Object> result = executePpl("source = " + index + " | stats list(value) as l");
     * giving a distinct value per doc — required for the DC test to have a meaningful
        client().performRequest(bulkRequest);
    public void testGroupByCountMultiShard_noWhereClause() throws Exception {
        String body = "{\"settings\": {"
        createSingleShardParquetBackedIndex(index);
        // All docs share category='' — makes "WHERE category != ''" filter every row on
        for (int i = 0; i < total; i++) {
        long expected = (long) NUM_SHARDS * DOCS_PER_SHARD;
    }
        List<String> columns = extractColumnNames(result);
    /**
        indexVaryingValueDocs(index);
        List<List<Object>> rows = scalarRows(result, "f");
        }
        assertTrue("columns must contain 'l', got " + columns, columns.contains("l"));
    public void testDistinctCountAcrossShards() throws Exception {
        health.addParameter("timeout", "30s");
            + "\"settings\": {"
                + " — a value near " + (distinct * shards) + " means per-shard distinct counts were summed across shards",
        int actual = ((Number) cell).intValue();
        }
        Map<String, Object> grouped = executePpl("source = " + index + " | stats count() as c by value");
            assertNotNull("values(value) elements must not be null", v);
            + "  \"properties\": {"
    /** Cross-shard {@code last(value)} — arrival order non-deterministic; assert membership only. */
 * The OpenSearch Contributors require contributions made to
        int totalDocs = NUM_SHARDS * DOCS_PER_SHARD;
            + "  \"number_of_replicas\": 0,"
            + "    \"value\": { \"type\": \"integer\" }"
}
 *   <li>{@link #testGroupedSumAcrossShards()} — group keys propagate through
        Object cell = rows.get(0).get(0);
    /** Cross-shard {@code take(value, 5)} — coordinator unions per-shard arrays and truncates to 5. */
     * accumulator path with cross-shard label overlap. Same shape: 8 shards, every shard sees the
     */
    /**
        List<String> columns = extractColumnNames(result);
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
        createParquetBackedIndex(index);
        int exactDistinct = groupRows.size();
    /**
     */
        @SuppressWarnings("unchecked")
        }
    public void testGroupedSumAcrossShards() throws Exception {
            "percentile_approx(value, 50) should be approximately " + expected + " (±2.0), got " + actual,
        StringBuilder bulk = new StringBuilder();
        double actual = ((Number) cell).doubleValue();
        assertEquals("SUM", (long) VALUE * totalDocs, ((Number) row.get(columns.indexOf("s"))).longValue());
            seen.add(Integer.parseInt((String) v));
        List<List<Object>> rows = scalarRows(result, "dc");
            actual >= distinct - 2 && actual <= distinct + 2
    public void testAvgAcrossShards() throws Exception {
            expected.add(i);
            + "  \"index.composite.primary_data_format\": \"parquet\", \"index.composite.secondary_data_formats\": \"lucene\""
        } catch (Exception ignored) {}
        assertEquals("COUNT() across shards", expected, actual);
        @SuppressWarnings("unchecked")
        int total = NUM_SHARDS * DOCS_PER_SHARD;
    private static final int NUM_SHARDS = 2;
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
    }
        );
            + "  \"index.composite.secondary_data_formats\": \"lucene\""
     * accuracy).
    }
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
     * Returns the {@code rows} list from a scalar-aggregate PPL response, asserting that
        for (Object v : taken) {
        int totalDocs = NUM_SHARDS * DOCS_PER_SHARD;
    /** Single-shard {@code take(value, 3)} — bounded array of up to 3 values. */
            bulk.append("{\"index\": {}}\n");
        indexConstantValueDocs(INDEX);
        for (int i = 0; i < DOCS_PER_SHARD; i++) {
        java.util.Set<Integer> seen = new java.util.HashSet<>();
        }
        assertEquals("values(value) must return exactly 10 distinct elements", 10, got.size());
        bulkRequest.addParameter("refresh", "true");
            seen.add(Integer.parseInt((String) v));
        Map<String, Object> result = executePpl("source = " + index + " | stats list(value) as l");
     * wrapper produced for AVG. Covers the case where the aggregate decomposition has to
     * doesn't repeat the null/empty checks.
    private void bulkAndRefresh(String indexName, String bulkBody) throws Exception {
    }
            + "\"mappings\": {"
        assertEquals("index creation must be acknowledged", true, response.get("acknowledged"));
    /**
        String index = "coord_reduce_values_single";
        // 800 docs, label cycles lbl0..lbl9 → every shard sees all 10 labels.
        Map<String, Object> result = executePpl("source = " + index + " | stats last(value) as l");
        assertNotNull("cell for 'v' must not be null — coordinator-reduce returned no value", cell);
     */
        assertNotNull("schema must not be null", columns);
        Request health = new Request("GET", "/_cluster/health/" + index);
    private void createParquetBackedIndex(String indexName) throws Exception {
     */
     */
 */
     * the single row contains the requested named column. Parameterised so each test
            + "}"
                + " — a value near " + (distinct * shards) + " means per-shard distinct counts were summed across shards",
            + "}";
        for (Object v : listed) {
        health.addParameter("wait_for_status", "green");
        indexConstantValueDocs(INDEX);
 *   PPL → planner (AggregateDecompositionResolver) → multi-shard SHARD_FRAGMENT dispatch
 * <p>Each test exercises a distinct branch of the resolver's four-case decomposition:
        assertNotNull("cell for 't' must not be null — coordinator-reduce returned no value", cell);
        StringBuilder bulk = new StringBuilder();
        assertEquals("Q10-shape on a single-valued column must return exactly 1 group", 1, rows.size());
        long actual = ((Number) rows.get(0).get(0)).longValue();
 *
        @SuppressWarnings("unchecked")
        List<Object> got = (List<Object>) cell;
    // ─── Multi-shard GROUP BY on string columns ─────────────────────────────────
        client().performRequest(health);
            bulk.append("{\"index\": {}}\n");
 * </pre>
     * Keyword-field counterpart to {@link #testDistinctCountCrossShardOverlap()} — the StringHLL
            + "  \"number_of_shards\": 1,"
        long actual = ((Number) scalarRows(result, "dc").get(0).get(0)).longValue();
        executePpl(
        assertTrue(
        int actual = ((Number) cell).intValue();
        long dcValue = ((Number) row.get(columns.indexOf("d"))).longValue();
        Map<String, Object> result = executePpl("source = " + INDEX + " | stats count() as cnt");
     * {@code 1..5} twice — so 10 docs but only 5 distinct values. Used by
            assertTrue("take(value, 3) element " + iv + " must be in {1.." + DOCS_PER_SHARD + "}", iv >= 1 && iv <= DOCS_PER_SHARD);
        }
        Map<String, Object> grouped = executePpl("source = " + index + " | stats count() as c by label");
        assertEquals("scalar agg must return exactly 1 row", 1, rows.size());
    public void testFirstSingleShard() throws Exception {
        assertTrue("first(value) must be in {1.." + DOCS_PER_SHARD + "}, got " + actual, actual >= 1 && actual <= DOCS_PER_SHARD);
     * → coordinator-reduce path runs the final SUM via DatafusionReduceSink
        Map<String, Object> result = executePpl("source = " + index + " | stats percentile_approx(value, 50) as p");
    }
        Object cell = rows.get(0).get(columns.indexOf("v"));
        java.util.Set<Integer> expected = new java.util.HashSet<>();
            + "}, \"mappings\": {\"properties\": {\"value\": {\"type\": \"integer\"}}}}";
    public void testValuesAcrossShards() throws Exception {
     * single-shard {@code take()} test.
        assertTrue("first(value) must be in {1.." + totalDocs + "}, got " + actual, actual >= 1 && actual <= totalDocs);
        String index = "coord_reduce_dc";
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
     * <p>All docs have {@code category=''} so {@code WHERE category != ''} filters
        }
        create.setJsonEntity(body);
        indexSequentialValueDocsSingleShard(index);
        Request createIndex = new Request("PUT", "/" + STRING_GROUP_INDEX);
    }
        indexSequentialValueDocsSingleShard(index);
            expected.add(i);
        assertNotNull("schema must not be null", columns);
        long actual = ((Number) rows.get(0).get(0)).longValue();
        Map<String, Object> result = executePpl("source = " + index + " | stats last(value) as l");
        int total = NUM_SHARDS * DOCS_PER_SHARD;
            + "\"settings\": {"
     * {@link #testValuesSingleShard()} to validate that {@code values()} de-duplicates.
        Object cell = rows.get(0).get(columns.indexOf("t"));
     * Indexes 10 docs into a single-shard index where {@code value} cycles through
    }
     * Q10 shape: SUM + COUNT + AVG + DC together, grouped. Exercises all four resolver
        assertOkAndParse(client().performRequest(create), "create " + index);
    /**
 *       → shard-side partial aggregate → ExchangeSink.feed → coordinator reduce
     * Creates a 2-shard parquet-backed composite index with a single integer field {@code value}.
        @SuppressWarnings("unchecked")
     */
        indexSequentialValueDocsSingleShard(index);
        StringBuilder bulk = new StringBuilder();
        );
        List<List<Object>> groupRows = (List<List<Object>>) grouped.get("datarows");
            bulk.append("{\"index\": {}}\n");
        try {
        List<Object> got = (List<Object>) cell;
        assertTrue("columns must contain '" + columnName + "', got " + columns, columns.contains(columnName));
    /** Cross-shard {@code list(value)} — coordinator concatenates per-shard lists via list_merge UDAF. */
        // 800 docs, value cycles 1..10 → every shard sees all 10 values (heavy cross-shard overlap).
     * {@code value}. Mirrors {@link #createParquetBackedIndex(String)} but with
    public void testListAcrossShards() throws Exception {
        for (int i = 0; i < total; i++) {
        List<List<Object>> rows = scalarRows(result, "total");
    /** Single-shard {@code list(value)} — preserves duplicates; result must contain every input. */
        client().performRequest(health);
        assertTrue("columns must contain 't', got " + columns, columns.contains("t"));
        String index = "coord_reduce_last_single";
    /**
        assertEquals("AVG", (double) VALUE, ((Number) row.get(columns.indexOf("a"))).doubleValue(), 0.001);
        List<Object> listed = (List<Object>) cell;
    private void createStringGroupIndex() throws Exception {
 * compatible open source license.
     * coordinator's final aggregate must still report an empty result without erroring —
        List<List<Object>> rows = scalarRows(result, "f");
        assertNotNull("rows must not be null", rows);
    private static final String STRING_GROUP_INDEX = "coord_reduce_string_group";
        java.util.Set<Integer> expected = new java.util.HashSet<>();
        int total = 800;
    }
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
    }
        bulkAndRefresh(indexName, bulk.toString());
            "dc(value) should be approximately " + totalDocs + " (±10%), got " + actual,
        StringBuilder bulk = new StringBuilder();
        List<String> columns = extractColumnNames(result);
    }
     * by {@link #testValuesAcrossShards()} to validate that {@code values()}
     */
     * {@code stats percentile_approx(value, 50) as p} — t-digest approximate median.
        @SuppressWarnings("unchecked")
     * {@code stats dc(value) as dc} — engine-native merge. PARTIAL emits a single Binary
    // ─── Helpers ────────────────────────────────────────────────────────────────
     */
    /** Indexes {@link #NUM_SHARDS} × {@link #DOCS_PER_SHARD} docs, each with {@code value=VALUE}. */
        int totalDocs = NUM_SHARDS * DOCS_PER_SHARD;
        createParquetBackedIndex(INDEX);
            + "  \"index.pluggable.dataformat.enabled\": true,"
        indexVaryingValueDocs(index);
        Object cell = rows.get(0).get(columns.indexOf("l"));
            "dc(value) with cross-shard overlap should be ~" + distinct + " (±2), got " + actual
        for (int i = 0; i < total; i++) {
        Map<String, Object> response = assertOkAndParse(client().performRequest(createIndex), "Create index " + indexName);
    public void testFirstAcrossShards() throws Exception {
        assertNotNull("rows must not be null", rows);
        createParquetBackedIndex(INDEX);
        @SuppressWarnings("unchecked")
            expected,
        Map<String, Object> result = executePpl("source = " + index + " | stats first(value) as f");
        double actual = ((Number) rows.get(0).get(0)).doubleValue();
            client().performRequest(new Request("DELETE", "/" + indexName));
            "source = " + INDEX + " | stats sum(value) as s, count() as c, avg(value) as a, dc(value) as d by value"
    /**
     * Multi-shard GROUP BY with a string key where WHERE filters every row on every shard.
        assertNotNull("rows must not be null", rows);
        String index = "coord_reduce_values_multi";
        createSingleShardParquetBackedIndex(index);
        assertTrue("dc on single-valued column should be 1 (±small HLL error), got " + dcValue, dcValue >= 1 && dcValue <= 2);
        Map<String, Object> result = executePpl("source = " + index + " | stats dc(label) as dc");
     * branches in a single query and validates column positions in the final Project
            client().performRequest(new Request("DELETE", "/" + index));
            + "  \"number_of_shards\": " + shards + ", \"number_of_replicas\": 0,"
    /**
        assertEquals("scalar agg must return exactly 1 row", 1, rows.size());
     * sees the full value set. A correct cross-shard reduce must NOT sum per-shard distinct counts.
    /**
    private void indexStringGroupDocs() throws Exception {
            + "  }"
            client().performRequest(new Request("DELETE", "/" + STRING_GROUP_INDEX));
     * {@code stats avg(value) as a} — primitive decomposition. PARTIAL emits
        createParquetBackedIndex(index);
     * {@code number_of_shards=1} so tests can exercise the trivial pass-through merge path
    /**
        Map<String, Object> result = executePpl("source = " + index + " | stats values(value) as v");
        StringBuilder bulk = new StringBuilder();
        health.addParameter("timeout", "30s");
    /** Single-shard {@code values(value)} — de-duplicates; result must equal the distinct input set. */
        List<List<Object>> rows = scalarRows(result, "a");
        @SuppressWarnings("unchecked")
     * cycles through {@code 1..10} twice — so 20 docs but only 10 distinct values. Used
    private void indexVaryingValueDocs(String indexName) throws Exception {
        client().performRequest(health);
        createParquetBackedIndex(INDEX);
            + "},"
        List<String> columns = extractColumnNames(result);
     * HLL sketch; resolver rebinds FINAL's arg to the sketch column and DataFusion's
 *       partial/final without affecting the aggregate-call decomposition path</li>
 * <ul>
        List<List<Object>> rows = scalarRows(result, "p");
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
    private static final int VALUE = 7;
        }
        assertTrue("columns must contain 'l', got " + columns, columns.contains("l"));
    /** Cross-shard {@code values(value)} — coordinator concatenates and re-deduplicates via list_merge_distinct UDAF. */
    /** Cross-shard {@code first(value)} — arrival order non-deterministic; assert membership only. */
        @SuppressWarnings("unchecked")
        assertEquals("exact distinct (group count) must be " + distinct, distinct, exactDistinct);
        assertNotNull("schema must not be null", columns);
        assertNotNull("cell for 'p' must not be null — coordinator-reduce returned no value", cell);
        assertTrue(
 *   <li>{@link #testAvgAcrossShards()} — primitive decomposition
            assertNotNull("take(value, 3) elements must not be null", v);
        @SuppressWarnings("unchecked")
        for (int i = 1; i <= DOCS_PER_SHARD; i++) {
        health.addParameter("timeout", "30s");
     */
        Object cell = rows.get(0).get(columns.indexOf("l"));
    public void testDistinctCountCrossShardOverlapKeyword() throws Exception {
     * STATE_EXPANDING, so the split rule gathers to coordinator + single-stage. Maps to
            + "  \"index.pluggable.dataformat.enabled\": true, \"index.pluggable.dataformat\": \"composite\","
        assertTrue(
        assertTrue("last(value) must be in {1.." + totalDocs + "}, got " + actual, actual >= 1 && actual <= totalDocs);
        Request create = new Request("PUT", "/" + index);
        );
        assertNotNull("rows must not be null", rows);
     * SearchPhrase}.)
public class CoordinatorReduceIT extends AnalyticsRestTestCase {
    }
            + "  \"number_of_shards\": " + NUM_SHARDS + ","
     * never overlap and even a naive additive reduce is coincidentally right), here every shard
            + "  \"index.composite.primary_data_format\": \"parquet\","
            seen.add(Integer.parseInt((String) v));
 */
        List<String> columns = extractColumnNames(result);
        assertFalse("should return at least one group", rows.isEmpty());
            seen.add(Integer.parseInt((String) v));
        List<String> columns = extractColumnNames(result);
        List<Object> row = rows.get(0);
    private static List<List<Object>> scalarRows(Map<String, Object> result, String columnName) {
            bulk.append("{\"value\": ").append((i % 5) + 1).append("}\n");
     * {@link #testDistinctCountAcrossShards()} (globally-unique values, so per-shard distinct sets
            actual
        indexVaryingValueDocs(index);
        java.util.Set<Integer> seen = new java.util.HashSet<>();
    /**
 * </ul>
        @SuppressWarnings("unchecked")
        bulkAndRefresh(STRING_GROUP_INDEX, bulk.toString());
            assertNotNull("list(value) elements must not be null", v);
        for (int i = 1; i <= 10; i++) {
        assertTrue("last(value) must be in {1.." + DOCS_PER_SHARD + "}, got " + actual, actual >= 1 && actual <= DOCS_PER_SHARD);
    /**
        Map<String, Object> result = executePpl("source = " + index + " | stats take(value, 5) as t");
        assertEquals("scalar agg must return exactly 1 row", 1, rows.size());
    public void testQ10ShapeAcrossShards() throws Exception {
    private static final int DOCS_PER_SHARD = 10;
        @SuppressWarnings("unchecked")
        List<List<Object>> rows = scalarRows(result, "cnt");
     * live in the same JVM without the bulk indexing steps colliding.
    public void testDistinctCountCrossShardOverlap() throws Exception {
 * <p>Requires a 2-node cluster (configured in build.gradle) so that shards
        Map<String, Object> result = executePpl("source = " + index + " | stats dc(value) as dc");
            + "  \"number_of_shards\": " + NUM_SHARDS + ","
        Map<String, Object> result = executePpl("source = " + INDEX + " | stats sum(value) as total by value");
        bulkAndRefresh(indexName, bulk.toString());
            + "  \"number_of_replicas\": 0,"
     * group, so the shard's partial emits one non-empty batch and the final aggregate
    }
            + "  \"number_of_replicas\": 0,"
        indexConstantValueDocs(INDEX);
 *   <li>{@link #testScalarCountAcrossShards()} — function-swap
    public void testScalarCountAcrossShards() throws Exception {
     * index — yielding values {@code 1..DOCS_PER_SHARD} (i.e. {@code 1..10}). Used by the
     */
        }
    public void testLastAcrossShards() throws Exception {
        assertNotNull("schema must not be null", columns);
        String index = "coord_reduce_percentile_approx";
            + "  \"properties\": {"
     * have something to project from.
        client().performRequest(health);
        List<String> columns = extractColumnNames(result);
        @SuppressWarnings("unchecked")
        List<String> columns = extractColumnNames(result);
            assertTrue("take(value, 5) element " + iv + " must be in {1.." + totalDocs + "}", iv >= 1 && iv <= totalDocs);
        List<Object> taken = (List<Object>) cell;
     * resolver rewrites FINAL's COUNT to SUM over the partial-count column.
     */
        assertEquals("values(value) must contain exactly {1..5}", expected, seen);
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
        }
        int actual = ((Number) cell).intValue();
        int totalDocs = NUM_SHARDS * DOCS_PER_SHARD;
        String index = "coord_reduce_dc_overlap_kw";
        assertEquals("values(value) must contain exactly {1..10}", expected, seen);
        String body = "{"
        java.util.Set<Integer> seen = new java.util.HashSet<>();
        assertEquals("scalar agg must return exactly 1 row", 1, rows.size());
            + "}"
/**
        assertTrue("columns must contain 'v', got " + columns, columns.contains("v"));
            + "  }"
     * {@code source = T | stats sum(value) as total} on a 2-shard parquet-backed index
    }
        } catch (Exception ignored) {}
import java.util.List;
        );
     * Multi-shard dc correctness with heavy cross-shard value overlap. Unlike
            bulk.append("{\"index\": {}}\n");
        createParquetBackedIndex(index);
    }
        java.util.Set<Integer> expected = new java.util.HashSet<>();
            Math.abs(actual - expected) <= 2.0
    }
        health.addParameter("wait_for_status", "green");
        String index = "coord_reduce_dc_overlap";
            expected.add(i);
    }
     * without interacting with the aggregate-call decomposition (key columns sit at the
            bulk.append("{\"index\": {}}\n");
            + "  \"number_of_shards\": " + shards + ", \"number_of_replicas\": 0,"
        List<List<Object>> rows = scalarRows(result, "l");
        String body = "{"
        String index = "coord_reduce_list_multi";
        Map<String, Object> result = executePpl(
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
        for (Object v : got) {
        }
        health.addParameter("timeout", "30s");
    /**
        for (int i = 0; i < total; i++) {
        @SuppressWarnings("unchecked")
        assertEquals("index creation must be acknowledged", true, response.get("acknowledged"));
        Object cell = rows.get(0).get(columns.indexOf("v"));
            + "}";
        assertNotNull("rows must not be null", rows);
    public void testLastSingleShard() throws Exception {
        create.setJsonEntity(body);
            client().performRequest(new Request("DELETE", "/" + index));
        createSingleShardParquetBackedIndex(index);
        for (Object v : got) {
            + "\"mappings\": {"
        );
    public void testScalarSumAcrossShards() throws Exception {
     * full label set, so a naive additive reduce would yield ~{@code distinct × shards}.
        List<Object> taken = (List<Object>) cell;
        assertEquals("take(value, 5) must return exactly 5 elements", 5, taken.size());
        indexStringGroupDocs();
        StringBuilder bulk = new StringBuilder();
    /**
     * {@code finalExpression = sum/count}. Exercises the multi-field intermediate path.
    }
        }
        }
        int actual = ((Number) cell).intValue();
        Request createIndex = new Request("PUT", "/" + indexName);
    }
        @SuppressWarnings("unchecked")
        assertTrue("list() must return a List, got " + cell.getClass(), cell instanceof List);
     *
        @SuppressWarnings("unchecked")
     * the wire-format has to carry the schema on an empty batch so downstream operators
            + "  \"index.pluggable.dataformat.enabled\": true,"
    }
        assertEquals("list(value) must contain every integer in {1.." + DOCS_PER_SHARD + "}", expected, seen);
     * everything, causing each shard's partial aggregate to produce zero rows. The
    }
        createParquetBackedIndex(INDEX);
        for (int i = 0; i < total; i++) {
            + "  \"index.composite.primary_data_format\": \"parquet\", \"index.composite.secondary_data_formats\": \"lucene\""
        assertTrue("values() must return a List, got " + cell.getClass(), cell instanceof List);
     * returns a single row. Validates the non-empty path with the same data shape.
            bulk.append("{\"value\": ").append((i % distinct) + 1).append("}\n");
        Request health = new Request("GET", "/_cluster/health/" + STRING_GROUP_INDEX);
        @SuppressWarnings("unchecked")
        // every shard, exercising the empty-partial path.
        int totalDocs = NUM_SHARDS * DOCS_PER_SHARD;
        return rows;
 *       (multi-field intermediate + {@code finalExpression} wrap)</li>
        Map<String, Object> result = executePpl("source = " + index + " | stats first(value) as f");
import java.util.Map;
    /**
            bulk.append("{\"index\": {}}\n");
        assertNotNull("schema must not be null", columns);
        Map<String, Object> result = executePpl("source = " + INDEX + " | stats sum(value) as total");
            bulk.append("{\"value\": ").append(i + 1).append("}\n");
        Request health = new Request("GET", "/_cluster/health/" + index);
     * and returns the deterministic total.
     */
            + "  \"index.pluggable.dataformat\": \"composite\","
        createIndex.setJsonEntity(body);
        // Exact distinct = number of groups returned by GROUP BY value (same engine).
     * Uses a per-call name so DC (varying values) and the other tests (constant value) can
     * front of the row type).
     * shape without the WHERE clause. Every doc lands in the single {@code category=''}
        long actual = ((Number) rows.get(0).get(0)).longValue();
     * Constant value used for {@link #INDEX}: every doc has {@code value=VALUE}. Makes the
        String index = "coord_reduce_list_single";
            + "    \"value\": { \"type\": \"integer\" }"
        assertNotNull("rows must not be null", rows);
        @SuppressWarnings("unchecked")
        assertNotNull("cell for 'l' must not be null — coordinator-reduce returned no value", cell);
        int total = 800;
        }
            bulk.append("{\"index\": {}}\n");
        bulkRequest.setJsonEntity(bulkBody);
     * Creates a single-shard parquet-backed composite index with a single integer field
        assertTrue("list() must return a List, got " + cell.getClass(), cell instanceof List);
        );
        assertEquals("grouped agg on a single-valued column must return exactly 1 group", 1, rows.size());
        createSingleShardParquetBackedIndex(index);
        for (int i = 1; i <= totalDocs; i++) {
        client().performRequest(health);
     * (mirrors ClickBench Q13 {@code where SearchPhrase != '' | stats count() by
        assertEquals("COUNT", totalDocs, ((Number) row.get(columns.indexOf("c"))).longValue());
        List<List<Object>> rows = scalarRows(result, "l");
            + "},"
 *       ({@code AggregateFunction.intermediateFields == null})</li>
        assertTrue("take() must return a List, got " + cell.getClass(), cell instanceof List);
     */
        } catch (Exception ignored) {}
 * SPDX-License-Identifier: Apache-2.0
        Object cell = rows.get(0).get(columns.indexOf("l"));
        health.addParameter("wait_for_status", "green");
    }
        assertNotNull("rows must not be null", rows);
     */
        bulkAndRefresh(indexName, bulk.toString());
 * <pre>
        Object cell = rows.get(0).get(columns.indexOf("t"));
        int totalDocs = NUM_SHARDS * DOCS_PER_SHARD;
        createStringGroupIndex();
        Request health = new Request("GET", "/_cluster/health/" + indexName);
     * {@code [count:Int64, sum:Float64]}; FINAL reduces each with SUM and a Project wraps
 *   <li>{@link #testDistinctCountAcrossShards()} — engine-native merge
 * are distributed across nodes, exercising the coordinator-reduce path.
    private void indexConstantValueDocs(String indexName) throws Exception {
     * cardinality to approximate.
        int shards = 8;
        assertEquals("list(value) must contain every integer in {1.." + totalDocs + "}", expected, seen);
        @SuppressWarnings("unchecked")
        Map<String, Object> result = executePpl(
        for (int i = 0; i < DOCS_PER_SHARD; i++) {
        @SuppressWarnings("unchecked")
    public void testTakeSingleShard() throws Exception {
        indexVaryingValueDocs(index);
        @SuppressWarnings("unchecked")
            expected.add(i);
        @SuppressWarnings("unchecked")
        assertNotNull("rows must not be null", rows);
 *
        assertEquals("take(value, 3) must return exactly 3 elements", 3, taken.size());
     * rewrite the parent Project's expressions to reference the rebuilt exchange columns.
        assertEquals("AVG(value) across shards should be " + VALUE, (double) VALUE, actual, 0.001);
     */
        List<String> columns = extractColumnNames(result);
     * deterministic SUM / AVG predictable regardless of which shard a doc lands on.
        assertEquals("index creation must be acknowledged", true, response.get("acknowledged"));
        assertNotNull("cell for '" + columnName + "' must not be null — coordinator-reduce returned no value", cell);
        assertEquals("scalar agg must return exactly 1 row", 1, rows.size());
        int distinct = 10;
        Request create = new Request("PUT", "/" + index);
        List<String> columns = extractColumnNames(result);
        assertEquals("list(value) must return exactly " + DOCS_PER_SHARD + " elements", DOCS_PER_SHARD, listed.size());
 *       → drain → downstream → assembled PPLResponse
        indexVaryingValueDocs(index);
     * de-duplicates across the partial/final boundary.
            int iv = ((Number) v).intValue();
        assertEquals("scalar agg must return exactly 1 row", 1, rows.size());
        Map<String, Object> result = executePpl("source = " + INDEX + " | stats avg(value) as a");
            + "}, \"mappings\": {\"properties\": {\"label\": {\"type\": \"keyword\"}}}}";
    public void testGroupByCountMultiShard_allRowsFilteredByWhere() throws Exception {
            assertNotNull("list(value) elements must not be null", v);
     * without distributed coordination.
        int shards = 8;
        List<String> columns = extractColumnNames(result);
        } catch (Exception ignored) {}
            + "  \"index.pluggable.dataformat\": \"composite\","
        }
            "dc(label) with cross-shard overlap should be ~" + distinct + " (±2), got " + actual
        String index = "coord_reduce_take_multi";
            + "    \"category\": { \"type\": \"keyword\" },"
        java.util.Set<Integer> seen = new java.util.HashSet<>();
        bulkAndRefresh(indexName, bulk.toString());
     * org.opensearch.be.datafusion.PplAggregateCallRewriter}.
        bulkAndRefresh(indexName, bulk.toString());
        Object cell = rows.get(0).get(columns.indexOf(columnName));
        Object cell = rows.get(0).get(columns.indexOf("l"));
     * {@code stats sum(value) as total by value} — group-by flows through partial/final
            "SUM(value) across " + NUM_SHARDS + " shards × " + DOCS_PER_SHARD + " docs × value=" + VALUE + " = " + expected,
        createParquetBackedIndex(index);
     */
        }
    /**
 *   <li>{@link #testScalarSumAcrossShards()} — pass-through
            bulk.append("{\"value\": ").append(VALUE).append("}\n");
            assertNotNull("take(value, 5) elements must not be null", v);
            bulk.append("{\"label\": \"lbl").append(i % distinct).append("\"}\n");
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
        @SuppressWarnings("unchecked")
        @SuppressWarnings("unchecked")
        indexConstantValueDocs(INDEX);
        // DC on a single-valued column: exact result is 1.
     * DataFusion's {@code approx_percentile_cont} via {@link
        long expected = (long) VALUE * NUM_SHARDS * DOCS_PER_SHARD;
            + "  \"index.pluggable.dataformat.enabled\": true, \"index.pluggable.dataformat\": \"composite\","
        assertEquals("exact distinct (group count) must be " + distinct, distinct, exactDistinct);
            + "  \"index.composite.secondary_data_formats\": \"lucene\""
        try {
            assertTrue("take(value, 5) elements must be distinct, duplicate=" + iv, seen.add(iv));
        for (int i = 1; i <= 5; i++) {
        client().performRequest(new Request("POST", "/" + indexName + "/_flush?force=true"));
        String index = "coord_reduce_take_single";
        assertEquals("list(value) must return exactly " + totalDocs + " elements", totalDocs, listed.size());
    private void createSingleShardParquetBackedIndex(String indexName) throws Exception {
        health.addParameter("wait_for_status", "green");
        int total = NUM_SHARDS * DOCS_PER_SHARD;
     */
            assertNotNull("values(value) elements must not be null", v);
        Request createIndex = new Request("PUT", "/" + indexName);
        long totalDocs = (long) NUM_SHARDS * DOCS_PER_SHARD;
        indexDuplicateValueDocs(index);
        assertNotNull("schema must not be null", columns);
        @SuppressWarnings("unchecked")
        createParquetBackedIndex(index);
     */
    /** Single-shard {@code last(value)} — arrival order depends on parquet read; assert membership only. */
            client().performRequest(new Request("DELETE", "/" + indexName));
        indexConstantValueDocs(INDEX);
        for (Object v : taken) {
        String index = "coord_reduce_last_multi";
        int total = NUM_SHARDS * DOCS_PER_SHARD;
 * this file be licensed under the Apache-2.0 license or a
        createIndex.setJsonEntity(body);
        indexSequentialValueDocsSingleShard(index);
        Map<String, Object> response = assertOkAndParse(client().performRequest(createIndex), "Create index " + STRING_GROUP_INDEX);
        indexDuplicateValueDocsSingleShard(index);
        for (Object v : listed) {
    }
        createStringGroupIndex();
        @SuppressWarnings("unchecked")
            "source = " + STRING_GROUP_INDEX + " | stats count() as c by category | sort - c | head 5"
        try {
            actual >= totalDocs * 0.9 && actual <= totalDocs * 1.1
        Map<String, Object> result = executePpl("source = " + index + " | stats values(value) as v");
    private void indexSequentialValueDocsSingleShard(String indexName) throws Exception {
    }
            + "},"
        assertEquals(
        assertNotNull("schema must not be null", columns);
        assertTrue(
        createParquetBackedIndex(INDEX);
 *       (COUNT → SUM at FINAL over a single-field intermediate)</li>
    }
        try {
        try {
    }
            + "    \"value\": { \"type\": \"integer\" }"
