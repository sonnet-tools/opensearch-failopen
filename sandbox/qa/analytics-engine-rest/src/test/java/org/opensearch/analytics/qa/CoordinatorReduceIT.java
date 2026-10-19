            + "  \"number_of_shards\": " + shards + ", \"number_of_replicas\": 0,"
        String index = "coord_reduce_take_multi";
            bulk.append("{\"index\": {}}\n");
    }  
     * returns a single row. Validates the non-empty path with the same data shape.  
    }  
        assertEquals("exact distinct (group count) must be " + distinct, distinct, exactDistinct);
        indexVaryingValueDocs(index);
        List<String> columns = extractColumnNames(result);
            "source = " + INDEX + " | stats sum(value) as s, count() as c, avg(value) as a, dc(value) as d by value"
        }  
    }
            + "\"mappings\": {"
    /**  
        double expected = (totalDocs + 1) / 2.0;  
    private static final int DOCS_PER_SHARD = 10;
 *       (multi-field intermediate + {@code finalExpression} wrap)</li>
     * everything, causing each shard's partial aggregate to produce zero rows. The  
            + "    \"value\": { \"type\": \"integer\" }"  
        createParquetBackedIndex(index);
     * Creates a single-shard parquet-backed composite index with a single integer field
        assertNotNull("schema must not be null", columns);
        createParquetBackedIndex(index);
        }
        Object cell = rows.get(0).get(columns.indexOf("f"));
        Request health = new Request("GET", "/_cluster/health/" + indexName);
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
        assertEquals("index creation must be acknowledged", true, response.get("acknowledged"));
        indexVaryingValueDocs(index);
     * (mirrors ClickBench Q13 {@code where SearchPhrase != '' | stats count() by
 * End-to-end tests for the distributed partial/final aggregate path:
     * resolver rewrites FINAL's COUNT to SUM over the partial-count column.
        java.util.Set<Integer> seen = new java.util.HashSet<>();
        @SuppressWarnings("unchecked")  
    }  
        assertTrue("values() must return a List, got " + cell.getClass(), cell instanceof List);  
        assertEquals(
        executePpl(  
            bulk.append("{\"value\": ").append((i % 10) + 1).append("}\n");
        for (Object v : listed) {  
        List<String> columns = extractColumnNames(result);
    public void testLastAcrossShards() throws Exception {
 *  
     * coordinator's final aggregate must still report an empty result without erroring —
            assertNotNull("list(value) elements must not be null", v);
        StringBuilder bulk = new StringBuilder();
        assertEquals("list(value) must return exactly " + DOCS_PER_SHARD + " elements", DOCS_PER_SHARD, listed.size());  
        for (int i = 0; i < total; i++) {  
            + "}, \"mappings\": {\"properties\": {\"label\": {\"type\": \"keyword\"}}}}";
        java.util.Set<Integer> expected = new java.util.HashSet<>();
            seen.add(Integer.parseInt((String) v));
        }  
    }
        @SuppressWarnings("unchecked")
     * Indexes {@link #DOCS_PER_SHARD} docs with {@code value = i+1} into a single-shard  
 */  
    /**
            + "\"mappings\": {"  
        java.util.Set<Integer> expected = new java.util.HashSet<>();
        client().performRequest(health);
        }  
            + "  \"number_of_shards\": 1,"
        health.addParameter("timeout", "30s");
        String index = "coord_reduce_dc_overlap_kw";
        for (Object v : taken) {
            assertNotNull("list(value) elements must not be null", v);
 *  
            + "  \"index.composite.secondary_data_formats\": \"lucene\""  
    private void createStringGroupIndex() throws Exception {
        assertEquals("scalar agg must return exactly 1 row", 1, rows.size());
        Map<String, Object> result = executePpl("source = " + index + " | stats percentile_approx(value, 50) as p");
    private void createSingleShardParquetBackedIndex(String indexName) throws Exception {  
            client().performRequest(new Request("DELETE", "/" + index));
        String body = "{"
        int distinct = 10;
            + "  \"index.pluggable.dataformat\": \"composite\","  
     * {@link #testValuesSingleShard()} to validate that {@code values()} de-duplicates.
    public void testTakeSingleShard() throws Exception {
        createIndex.setJsonEntity(body);  
    /**
        long dcValue = ((Number) row.get(columns.indexOf("d"))).longValue();  
        List<String> columns = extractColumnNames(result);
        @SuppressWarnings("unchecked")
        Map<String, Object> result = executePpl("source = " + index + " | stats take(value, 3) as t");
            assertNotNull("values(value) elements must not be null", v);
        assertFalse("should return at least one group", rows.isEmpty());
            + "  \"index.pluggable.dataformat.enabled\": true,"
        );  
        // 800 docs, label cycles lbl0..lbl9 → every shard sees all 10 labels.
    /** Cross-shard {@code take(value, 5)} — coordinator unions per-shard arrays and truncates to 5. */  
        Object cell = rows.get(0).get(columns.indexOf("v"));
        String index = "coord_reduce_list_multi";
            bulk.append("{\"index\": {}}\n");
            + "  \"index.pluggable.dataformat.enabled\": true, \"index.pluggable.dataformat\": \"composite\","
        String index = "coord_reduce_last_multi";  
        String index = "coord_reduce_percentile_approx";
        createParquetBackedIndex(index);  
        health.addParameter("wait_for_status", "green");  
        assertTrue("last(value) must be in {1.." + totalDocs + "}, got " + actual, actual >= 1 && actual <= totalDocs);  
        assertNotNull("cell for 'l' must not be null — coordinator-reduce returned no value", cell);
    private static final String STRING_GROUP_INDEX = "coord_reduce_string_group";  
        Map<String, Object> result = executePpl("source = " + INDEX + " | stats sum(value) as total");  
        assertTrue("columns must contain 'l', got " + columns, columns.contains("l"));
    }
        assertTrue("columns must contain '" + columnName + "', got " + columns, columns.contains(columnName));  
        assertTrue("columns must contain 't', got " + columns, columns.contains("t"));
        int total = NUM_SHARDS * DOCS_PER_SHARD;
        Request health = new Request("GET", "/_cluster/health/" + STRING_GROUP_INDEX);
        int total = NUM_SHARDS * DOCS_PER_SHARD;
                + " — a value near " + (distinct * shards) + " means per-shard distinct counts were summed across shards",
     * full label set, so a naive additive reduce would yield ~{@code distinct × shards}.
     * Indexes {@link #NUM_SHARDS} × {@link #DOCS_PER_SHARD} docs with {@code value = i+1},
    }
        long actual = ((Number) rows.get(0).get(0)).longValue();  
        int totalDocs = NUM_SHARDS * DOCS_PER_SHARD;
        int total = 800;  
}  
        Request health = new Request("GET", "/_cluster/health/" + indexName);
        indexStringGroupDocs();
        );
        Map<String, Object> result = executePpl("source = " + index + " | stats values(value) as v");
        indexVaryingValueDocs(index);  
            "dc(value) should be approximately " + totalDocs + " (±10%), got " + actual,
    public void testFirstAcrossShards() throws Exception {
     * cardinality to approximate.
        }  
 *   <li>{@link #testScalarCountAcrossShards()} — function-swap
        bulkAndRefresh(indexName, bulk.toString());
     * Indexes 10 docs into a single-shard index where {@code value} cycles through
            assertNotNull("values(value) elements must not be null", v);  
        Map<String, Object> grouped = executePpl("source = " + index + " | stats count() as c by value");  
    }
    }
        String body = "{\"settings\": {"  
        assertOkAndParse(client().performRequest(create), "create " + index);
            client().performRequest(new Request("DELETE", "/" + indexName));
    }
        assertNotNull("schema must not be null", columns);  
     */  
        @SuppressWarnings("unchecked")
        List<String> columns = extractColumnNames(result);
        @SuppressWarnings("unchecked")  
    public void testQ10ShapeAcrossShards() throws Exception {
    }
        assertNotNull("schema must not be null", columns);
     */
     * {@code stats count() as cnt} — function-swap at FINAL. PARTIAL emits COUNT(*) as Int64;
    }
     */
     */
        String index = "coord_reduce_values_multi";  
     * Multi-shard dc correctness with heavy cross-shard value overlap. Unlike
        for (int i = 0; i < total; i++) {  
        assertTrue("values() must return a List, got " + cell.getClass(), cell instanceof List);
        health.addParameter("wait_for_status", "green");  
        int actual = ((Number) cell).intValue();
        int shards = 8;
     */
     * giving a distinct value per doc — required for the DC test to have a meaningful  
        Request create = new Request("PUT", "/" + index);
     * org.opensearch.be.datafusion.PplAggregateCallRewriter}.
        createStringGroupIndex();  
        int shards = 8;
    private void indexSequentialValueDocsSingleShard(String indexName) throws Exception {
        java.util.Set<Integer> seen = new java.util.HashSet<>();
     * <p>All docs have {@code category=''} so {@code WHERE category != ''} filters
        List<List<Object>> rows = scalarRows(result, "f");
     *
import org.opensearch.client.Request;
        indexConstantValueDocs(INDEX);
        java.util.Set<Integer> expected = new java.util.HashSet<>();
            "source = " + STRING_GROUP_INDEX + " | stats count() as c by category | sort - c | head 5"
        indexDuplicateValueDocsSingleShard(index);  
    }
            + "  \"index.pluggable.dataformat\": \"composite\","
        List<String> columns = extractColumnNames(result);  
        indexConstantValueDocs(INDEX);  
     * live in the same JVM without the bulk indexing steps colliding.  
    /**  
            "SUM(value) across " + NUM_SHARDS + " shards × " + DOCS_PER_SHARD + " docs × value=" + VALUE + " = " + expected,  
        assertEquals("Q10-shape on a single-valued column must return exactly 1 group", 1, rows.size());
    /**  
        @SuppressWarnings("unchecked")  
        int exactDistinct = groupRows.size();  
        java.util.Set<Integer> seen = new java.util.HashSet<>();  
        // DC on a single-valued column: exact result is 1.
        createParquetBackedIndex(INDEX);  
        }
        // 800 docs, value cycles 1..10 → every shard sees all 10 values (heavy cross-shard overlap).
     * DataFusion's {@code approx_percentile_cont} via {@link  
    }  
        assertEquals("COUNT() across shards", expected, actual);
        assertEquals("values(value) must contain exactly {1..5}", expected, seen);
        @SuppressWarnings("unchecked")
        Request createIndex = new Request("PUT", "/" + indexName);
        return rows;  
        assertTrue("first(value) must be in {1.." + totalDocs + "}, got " + actual, actual >= 1 && actual <= totalDocs);  
    public void testValuesAcrossShards() throws Exception {
        StringBuilder bulk = new StringBuilder();
                + " — a value near " + (distinct * shards) + " means per-shard distinct counts were summed across shards",
        createIndex.setJsonEntity(body);  
            + "  \"index.composite.primary_data_format\": \"parquet\","  
        @SuppressWarnings("unchecked")
        indexVaryingValueDocs(index);  
     */
    private void indexDuplicateValueDocs(String indexName) throws Exception {  
            client().performRequest(new Request("DELETE", "/" + index));
            expected.add(i);
        assertNotNull("cell for 'v' must not be null — coordinator-reduce returned no value", cell);  
     * never overlap and even a naive additive reduce is coincidentally right), here every shard  
        // Exact distinct = number of groups returned by GROUP BY value (same engine).
        createParquetBackedIndex(INDEX);
            expected.add(i);  
    }
     * Keyword-field counterpart to {@link #testDistinctCountCrossShardOverlap()} — the StringHLL
            bulk.append("{\"value\": ").append(i + 1).append("}\n");
            int iv = ((Number) v).intValue();  
    public void testDistinctCountAcrossShards() throws Exception {
     * have something to project from.  
        health.addParameter("timeout", "30s");
        Request health = new Request("GET", "/_cluster/health/" + index);
            + "},"
        assertEquals("take(value, 3) must return exactly 3 elements", 3, taken.size());
            "percentile_approx(value, 50) should be approximately " + expected + " (±2.0), got " + actual,
    /** Cross-shard {@code list(value)} — coordinator concatenates per-shard lists via list_merge UDAF. */
            expected.add(i);  
        assertNotNull("rows must not be null", rows);
        assertOkAndParse(client().performRequest(create), "create " + index);
    public void testListAcrossShards() throws Exception {  
 *       (Binary intermediate, reducer == self; HLL merge inside the backend)</li>
 * <p>Each test exercises a distinct branch of the resolver's four-case decomposition:
        assertEquals("exact distinct (group count) must be " + distinct, distinct, exactDistinct);
    /** Single-shard {@code first(value)} — arrival order depends on parquet read; assert membership only. */  
        assertNotNull("schema must not be null", columns);
            + "\"settings\": {"
        for (int i = 0; i < total; i++) {
 * <pre>
            + "  }"
     * branches in a single query and validates column positions in the final Project
            bulk.append("{\"index\": {}}\n");  
        assertNotNull("cell for 't' must not be null — coordinator-reduce returned no value", cell);
        Object cell = rows.get(0).get(columns.indexOf("v"));
            assertNotNull("take(value, 3) elements must not be null", v);  
        @SuppressWarnings("unchecked")
        List<Object> taken = (List<Object>) cell;
     * Uses a per-call name so DC (varying values) and the other tests (constant value) can
        int totalDocs = NUM_SHARDS * DOCS_PER_SHARD;  
     * {@code stats dc(value) as dc} — engine-native merge. PARTIAL emits a single Binary  
        @SuppressWarnings("unchecked")
        createParquetBackedIndex(index);
            + "    \"category\": { \"type\": \"keyword\" },"
 * are distributed across nodes, exercising the coordinator-reduce path.
        int totalDocs = NUM_SHARDS * DOCS_PER_SHARD;
        List<String> columns = extractColumnNames(result);
        assertNotNull("rows must not be null", rows);  
            actual
    /**
        StringBuilder bulk = new StringBuilder();
        assertNotNull("rows must not be null", rows);
    /**
        assertEquals("index creation must be acknowledged", true, response.get("acknowledged"));
    /**  
        Object cell = rows.get(0).get(0);
     * deterministic SUM / AVG predictable regardless of which shard a doc lands on.
            assertTrue("take(value, 5) elements must be distinct, duplicate=" + iv, seen.add(iv));
     * SearchPhrase}.)  
    }
            + "  \"index.composite.primary_data_format\": \"parquet\", \"index.composite.secondary_data_formats\": \"lucene\""  
        client().performRequest(new Request("POST", "/" + indexName + "/_flush?force=true"));  
 * compatible open source license.
        }  
    private static final int VALUE = 7;
    /** Single-shard {@code values(value)} — de-duplicates; result must equal the distinct input set. */
            + "  \"index.composite.secondary_data_formats\": \"lucene\""
        bulkAndRefresh(index, bulk.toString());  
     * Constant value used for {@link #INDEX}: every doc has {@code value=VALUE}. Makes the
        @SuppressWarnings("unchecked")
     * sees the full value set. A correct cross-shard reduce must NOT sum per-shard distinct counts.
        try {
            + "  \"number_of_shards\": " + NUM_SHARDS + ","  
        assertEquals("scalar agg must return exactly 1 row", 1, rows.size());  
        @SuppressWarnings("unchecked")
        }
    /**  
        long expected = (long) NUM_SHARDS * DOCS_PER_SHARD;  
    /**  
        );
        bulkAndRefresh(index, bulk.toString());  
        assertEquals("list(value) must contain every integer in {1.." + DOCS_PER_SHARD + "}", expected, seen);
        } catch (Exception ignored) {}
        String index = "coord_reduce_values_single";
        indexSequentialValueDocsSingleShard(index);
        Request bulkRequest = new Request("POST", "/" + indexName + "/_bulk");
    /**  
     */
 *   <li>{@link #testQ10ShapeAcrossShards()} — all four families in one query, grouped</li>
        Map<String, Object> result = executePpl("source = " + INDEX + " | stats sum(value) as total by value");  
        assertEquals("take(value, 5) must return exactly 5 elements", 5, taken.size());  
        try {  
        );  
     */
        Map<String, Object> response = assertOkAndParse(client().performRequest(createIndex), "Create index " + STRING_GROUP_INDEX);
        List<List<Object>> rows = scalarRows(result, "p");  
        createParquetBackedIndex(INDEX);
     * approx_distinct Final merges sketches in-place. Tolerance is 10% (standard HLL
    private static final String INDEX = "coord_reduce_e2e";  
        }  
 * </ul>
            + "\"mappings\": {"
     * Multi-shard GROUP BY with a string key where WHERE filters every row on every shard.  
        List<Object> listed = (List<Object>) cell;
     * without distributed coordination.
        );  
        int totalDocs = NUM_SHARDS * DOCS_PER_SHARD;
        }  
        assertEquals("AVG(value) across shards should be " + VALUE, (double) VALUE, actual, 0.001);
    }
            + "  \"index.pluggable.dataformat.enabled\": true,"
        List<List<Object>> groupRows = (List<List<Object>>) grouped.get("datarows");
        java.util.Set<Integer> seen = new java.util.HashSet<>();
        @SuppressWarnings("unchecked")  
        String index = "coord_reduce_last_single";
     * accuracy).  
        Map<String, Object> response = assertOkAndParse(client().performRequest(createIndex), "Create index " + indexName);
            bulk.append("{\"value\": ").append(i + 1).append("}\n");
        Map<String, Object> result = executePpl("source = " + index + " | stats last(value) as l");  
    public void testGroupedSumAcrossShards() throws Exception {
 *   <li>{@link #testGroupedSumAcrossShards()} — group keys propagate through
        try {  
    private static List<List<Object>> scalarRows(Map<String, Object> result, String columnName) {
        int totalDocs = NUM_SHARDS * DOCS_PER_SHARD;
        assertEquals("values(value) must return exactly 5 distinct elements", 5, got.size());
        int distinct = 10;
 *   <li>{@link #testScalarSumAcrossShards()} — pass-through  
            seen.add(Integer.parseInt((String) v));  
 *
        bulkAndRefresh(STRING_GROUP_INDEX, bulk.toString());
     * the wire-format has to carry the schema on an empty batch so downstream operators
        try {
    /** Cross-shard {@code last(value)} — arrival order non-deterministic; assert membership only. */
        }
            actual >= distinct - 2 && actual <= distinct + 2
        assertNotNull("cell for 'l' must not be null — coordinator-reduce returned no value", cell);  
        assertNotNull("rows must not be null", rows);  
     */
        String index = "coord_reduce_list_single";
        Map<String, Object> result = executePpl("source = " + index + " | stats dc(value) as dc");
 * The OpenSearch Contributors require contributions made to  
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");  
    private void createParquetBackedIndex(String indexName) throws Exception {
        createParquetBackedIndex(INDEX);  
    /** Indexes {@link #NUM_SHARDS} × {@link #DOCS_PER_SHARD} docs, each with {@code value=VALUE}. */
        for (int i = 1; i <= 10; i++) {  
        String index = "coord_reduce_first_single";
     */
            bulk.append("{\"value\": ").append(VALUE).append("}\n");
        health.addParameter("timeout", "30s");  
    public void testFirstSingleShard() throws Exception {
    }
        );
        assertNotNull("schema must not be null", columns);
        Object cell = rows.get(0).get(columns.indexOf(columnName));
    }
        assertNotNull("cell for 'v' must not be null — coordinator-reduce returned no value", cell);
        assertEquals("scalar agg must return exactly 1 row", 1, rows.size());
        }
        String index = "coord_reduce_dc_overlap";
            + "  \"properties\": {"
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
            expected.add(i);
     * STATE_EXPANDING, so the split rule gathers to coordinator + single-stage. Maps to
        for (int i = 0; i < total; i++) {
    private static final int NUM_SHARDS = 2;
            assertNotNull("take(value, 5) elements must not be null", v);
        int actual = ((Number) cell).intValue();  
        Map<String, Object> result = executePpl("source = " + index + " | stats dc(value) as dc");
    }
     */
 * <ul>
     * {@link #testDistinctCountAcrossShards()} (globally-unique values, so per-shard distinct sets
        StringBuilder bulk = new StringBuilder();  
        for (Object v : listed) {  
        @SuppressWarnings("unchecked")  
    /** Single-shard {@code list(value)} — preserves duplicates; result must contain every input. */  
        assertNotNull("rows must not be null", rows);
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
            assertTrue("take(value, 5) element " + iv + " must be in {1.." + totalDocs + "}", iv >= 1 && iv <= totalDocs);
        create.setJsonEntity(body);  
    public void testValuesSingleShard() throws Exception {  
        assertNotNull("schema must not be null", columns);  
        assertNotNull("schema must not be null", columns);
    }  
            + "}"
        } catch (Exception ignored) {}
     * {@code value}. Mirrors {@link #createParquetBackedIndex(String)} but with
        int total = NUM_SHARDS * DOCS_PER_SHARD;
        List<Object> got = (List<Object>) cell;  
     * group, so the shard's partial emits one non-empty batch and the final aggregate
            + "  \"index.composite.secondary_data_formats\": \"lucene\""
        Object cell = rows.get(0).get(columns.indexOf("l"));  
            bulk.append("{\"value\": ").append((i % distinct) + 1).append("}\n");
        for (int i = 0; i < total; i++) {  
    /**  
        @SuppressWarnings("unchecked")
        List<Object> row = rows.get(0);  
        assertEquals("scalar agg must return exactly 1 row", 1, rows.size());
        int actual = ((Number) cell).intValue();
    }
        indexConstantValueDocs(INDEX);
    /** Single-shard {@code last(value)} — arrival order depends on parquet read; assert membership only. */  
 *       partial/final without affecting the aggregate-call decomposition path</li>  
        @SuppressWarnings("unchecked")  
        double actual = ((Number) rows.get(0).get(0)).doubleValue();
            + "  \"number_of_replicas\": 0,"
 *       → shard-side partial aggregate → ExchangeSink.feed → coordinator reduce  
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
        for (int i = 0; i < total; i++) {
        assertTrue(  
 * this file be licensed under the Apache-2.0 license or a
        assertTrue("columns must contain 'v', got " + columns, columns.contains("v"));  
        int exactDistinct = groupRows.size();
     * single-shard {@code take()} test.
        assertNotNull("schema must not be null", columns);  
        @SuppressWarnings("unchecked")
        for (int i = 1; i <= DOCS_PER_SHARD; i++) {
     * the single row contains the requested named column. Parameterised so each test
        assertTrue("dc on single-valued column should be 1 (±small HLL error), got " + dcValue, dcValue >= 1 && dcValue <= 2);
    public void testAvgAcrossShards() throws Exception {  
        @SuppressWarnings("unchecked")
            int iv = ((Number) v).intValue();
            "dc(value) with cross-shard overlap should be ~" + distinct + " (±2), got " + actual
     */
        assertTrue(
            + "  \"number_of_shards\": " + NUM_SHARDS + ","
 */  
    }
            + "    \"value\": { \"type\": \"integer\" }"  
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");  
            + "  }"
        String index = "coord_reduce_take_single";  
import org.opensearch.client.Response;
        StringBuilder bulk = new StringBuilder();
            + "  \"number_of_shards\": " + shards + ", \"number_of_replicas\": 0,"
        Map<String, Object> response = assertOkAndParse(client().performRequest(createIndex), "Create index " + indexName);
 * </pre>
        Object cell = rows.get(0).get(columns.indexOf("t"));
        long expected = (long) VALUE * NUM_SHARDS * DOCS_PER_SHARD;
        @SuppressWarnings("unchecked")
            bulk.append("{\"category\": \"\", \"value\": ").append(i + 1).append("}\n");
        assertNotNull("rows must not be null", rows);  
        assertNotNull("rows must not be null", rows);
     */
    /**  
        bulkAndRefresh(indexName, bulk.toString());
 * SPDX-License-Identifier: Apache-2.0
        indexSequentialValueDocsSingleShard(index);
    private void indexVaryingValueDocs(String indexName) throws Exception {  
            actual >= totalDocs * 0.9 && actual <= totalDocs * 1.1
            + "}"
        Map<String, Object> result = executePpl("source = " + index + " | stats take(value, 5) as t");  
        assertEquals("scalar agg must return exactly 1 row", 1, rows.size());  
        String index = "coord_reduce_first_multi";  
        List<List<Object>> rows = scalarRows(result, "f");
        } catch (Exception ignored) {}  
        @SuppressWarnings("unchecked")
        List<String> columns = extractColumnNames(result);  
            bulk.append("{\"value\": ").append((i % 5) + 1).append("}\n");
     * {@code stats avg(value) as a} — primitive decomposition. PARTIAL emits
     * doesn't repeat the null/empty checks.  
    private void indexDuplicateValueDocsSingleShard(String indexName) throws Exception {  
        client().performRequest(health);
    }
        long actual = ((Number) scalarRows(result, "dc").get(0).get(0)).longValue();
        int total = NUM_SHARDS * DOCS_PER_SHARD;
    /**
            + "    \"value\": { \"type\": \"integer\" }"
        assertNotNull("cell for 't' must not be null — coordinator-reduce returned no value", cell);
        Map<String, Object> result = executePpl("source = " + index + " | stats last(value) as l");
            + "}"  
        @SuppressWarnings("unchecked")
    public void testLastSingleShard() throws Exception {
    /** Single-shard {@code take(value, 3)} — bounded array of up to 3 values. */
    public void testDistinctCountCrossShardOverlap() throws Exception {  
        List<List<Object>> groupRows = (List<List<Object>>) grouped.get("datarows");
        List<List<Object>> rows = scalarRows(result, "cnt");  
        Request createIndex = new Request("PUT", "/" + indexName);  
        client().performRequest(health);
        client().performRequest(health);
        assertTrue(
        @SuppressWarnings("unchecked")
        indexVaryingValueDocs(index);
        createParquetBackedIndex(INDEX);  
     * Creates a 2-shard parquet-backed composite index with a single integer field {@code value}.
        health.addParameter("timeout", "30s");  
     * by {@link #testValuesAcrossShards()} to validate that {@code values()}  
     * Indexes {@link #NUM_SHARDS} × {@link #DOCS_PER_SHARD} docs where {@code value}
        assertEquals("grouped agg on a single-valued column must return exactly 1 group", 1, rows.size());
        List<String> columns = extractColumnNames(result);
        List<List<Object>> rows = scalarRows(result, "a");
     * Control for {@link #testGroupByCountMultiShard_allRowsFilteredByWhere}: same query  
            + "}, \"mappings\": {\"properties\": {\"value\": {\"type\": \"integer\"}}}}";
        assertEquals("scalar agg must return exactly 1 row", 1, rows.size());
        assertEquals("SUM", (long) VALUE * totalDocs, ((Number) row.get(columns.indexOf("s"))).longValue());
        for (Object v : got) {
     * accumulator path with cross-shard label overlap. Same shape: 8 shards, every shard sees the  
     * {@code [count:Int64, sum:Float64]}; FINAL reduces each with SUM and a Project wraps  
     */  
    // ─── Multi-shard GROUP BY on string columns ─────────────────────────────────
        StringBuilder bulk = new StringBuilder();
        long actual = ((Number) rows.get(0).get(0)).longValue();
        Map<String, Object> grouped = executePpl("source = " + index + " | stats count() as c by label");
        assertEquals("AVG", (double) VALUE, ((Number) row.get(columns.indexOf("a"))).doubleValue(), 0.001);
        );
    }
        String body = "{"  
        Map<String, Object> result = executePpl("source = " + index + " | stats list(value) as l");
 *  
 *   <li>{@link #testDistinctCountAcrossShards()} — engine-native merge  
        assertTrue("list() must return a List, got " + cell.getClass(), cell instanceof List);
            "source = " + STRING_GROUP_INDEX + " | where category != '' | stats count() as c by category | sort - c | head 5"
 *       (COUNT → SUM at FINAL over a single-field intermediate)</li>  
     * {@code 1..5} twice — so 10 docs but only 5 distinct values. Used by  
        assertTrue("columns must contain 'l', got " + columns, columns.contains("l"));
        StringBuilder bulk = new StringBuilder();
            + "\"settings\": {"
        indexStringGroupDocs();
/**
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");  
    public void testPercentileApproxAcrossShards() throws Exception {  
        for (int i = 1; i <= totalDocs; i++) {
    public void testGroupByCountMultiShard_noWhereClause() throws Exception {
        @SuppressWarnings("unchecked")
        createSingleShardParquetBackedIndex(index);  
        );
        bulkAndRefresh(indexName, bulk.toString());  
        List<Object> got = (List<Object>) cell;
        Map<String, Object> result = executePpl("source = " + index + " | stats list(value) as l");  
        String body = "{\"settings\": {"  
    }
        createSingleShardParquetBackedIndex(index);
        Map<String, Object> result = executePpl("source = " + index + " | stats first(value) as f");  
        @SuppressWarnings("unchecked")  
        createIndex.setJsonEntity(body);
            + "  \"index.composite.primary_data_format\": \"parquet\","
            seen.add(Integer.parseInt((String) v));
        String index = "coord_reduce_dc";  
        List<String> columns = extractColumnNames(result);
    /**
        java.util.Set<Integer> expected = new java.util.HashSet<>();  
            + "}";  
        indexConstantValueDocs(INDEX);
            assertTrue("take(value, 3) element " + iv + " must be in {1.." + DOCS_PER_SHARD + "}", iv >= 1 && iv <= DOCS_PER_SHARD);
        Request createIndex = new Request("PUT", "/" + STRING_GROUP_INDEX);
        indexDuplicateValueDocs(index);
        java.util.Set<Integer> seen = new java.util.HashSet<>();  
        indexVaryingValueDocs(index);
        indexSequentialValueDocsSingleShard(index);
        bulkRequest.addParameter("refresh", "true");
        createStringGroupIndex();  
        StringBuilder bulk = new StringBuilder();
        assertTrue("first(value) must be in {1.." + DOCS_PER_SHARD + "}, got " + actual, actual >= 1 && actual <= DOCS_PER_SHARD);
            + "}";
     * → coordinator-reduce path runs the final SUM via DatafusionReduceSink
 * <p>Requires a 2-node cluster (configured in build.gradle) so that shards
            + "  \"properties\": {"
        for (int i = 1; i <= 5; i++) {
        Map<String, Object> result = executePpl(  
        @SuppressWarnings("unchecked")  
        @SuppressWarnings("unchecked")
     * {@code source = T | stats sum(value) as total} on a 2-shard parquet-backed index
            client().performRequest(new Request("DELETE", "/" + STRING_GROUP_INDEX));  
 *   PPL → planner (AggregateDecompositionResolver) → multi-shard SHARD_FRAGMENT dispatch
        }  
        List<String> columns = extractColumnNames(result);
     * {@code finalExpression = sum/count}. Exercises the multi-field intermediate path.
        assertTrue("take() must return a List, got " + cell.getClass(), cell instanceof List);
 *   <li>{@link #testAvgAcrossShards()} — primitive decomposition
    private void indexConstantValueDocs(String indexName) throws Exception {
        @SuppressWarnings("unchecked")
            "dc(label) with cross-shard overlap should be ~" + distinct + " (±2), got " + actual  
            + "  \"number_of_replicas\": 0,"  
        assertNotNull("rows must not be null", rows);
    private void bulkAndRefresh(String indexName, String bulkBody) throws Exception {
        for (int i = 0; i < DOCS_PER_SHARD; i++) {
        assertTrue(  
    /**
            bulk.append("{\"index\": {}}\n");
        double actual = ((Number) cell).doubleValue();
        health.addParameter("wait_for_status", "green");
        Request health = new Request("GET", "/_cluster/health/" + index);
            bulk.append("{\"index\": {}}\n");  
     * Returns the {@code rows} list from a scalar-aggregate PPL response, asserting that
        }
     * de-duplicates across the partial/final boundary.
        client().performRequest(health);
    }
        assertEquals("values(value) must return exactly 10 distinct elements", 10, got.size());
            + "}";  
        assertNotNull("rows must not be null", rows);  
    /**
    // ─── Helpers ────────────────────────────────────────────────────────────────
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
    }
        assertEquals("index creation must be acknowledged", true, response.get("acknowledged"));  
        for (Object v : taken) {
        @SuppressWarnings("unchecked")  
        List<List<Object>> rows = scalarRows(result, "l");
        Map<String, Object> result = executePpl("source = " + index + " | stats values(value) as v");
     * front of the row type).  
        }
        long actual = ((Number) scalarRows(result, "dc").get(0).get(0)).longValue();  
        bulkAndRefresh(indexName, bulk.toString());  
            + "  \"index.pluggable.dataformat\": \"composite\","
        long totalDocs = (long) NUM_SHARDS * DOCS_PER_SHARD;
     * {@code stats percentile_approx(value, 50) as p} — t-digest approximate median.
import java.util.Map;
            + "  \"index.pluggable.dataformat.enabled\": true,"  
     * and returns the deterministic total.  
        Request create = new Request("PUT", "/" + index);
            bulk.append("{\"index\": {}}\n");  
     * {@code number_of_shards=1} so tests can exercise the trivial pass-through merge path  
        Object cell = rows.get(0).get(columns.indexOf("f"));  
        assertTrue("list() must return a List, got " + cell.getClass(), cell instanceof List);
        List<List<Object>> rows = scalarRows(result, "l");
    /**
            client().performRequest(new Request("DELETE", "/" + indexName));
        Map<String, Object> result = executePpl("source = " + INDEX + " | stats count() as cnt");
        assertTrue("columns must contain 't', got " + columns, columns.contains("t"));  
        int total = 800;  
     * Q10 shape: SUM + COUNT + AVG + DC together, grouped. Exercises all four resolver  
        assertTrue("take() must return a List, got " + cell.getClass(), cell instanceof List);  
        assertNotNull("rows must not be null", rows);
        createSingleShardParquetBackedIndex(index);
            + "  \"number_of_replicas\": 0,"
            expected,
            bulk.append("{\"label\": \"lbl").append(i % distinct).append("\"}\n");
            + "},"
        Map<String, Object> result = executePpl("source = " + index + " | stats dc(label) as dc");
            + "  \"index.composite.primary_data_format\": \"parquet\", \"index.composite.secondary_data_formats\": \"lucene\""  
     */
        for (int i = 0; i < DOCS_PER_SHARD; i++) {  
    public void testGroupByCountMultiShard_allRowsFilteredByWhere() throws Exception {
public class CoordinatorReduceIT extends AnalyticsRestTestCase {
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");  
            + "  \"index.pluggable.dataformat.enabled\": true, \"index.pluggable.dataformat\": \"composite\","
        health.addParameter("wait_for_status", "green");  
        List<List<Object>> rows = scalarRows(result, "dc");
        int totalDocs = NUM_SHARDS * DOCS_PER_SHARD;
    }  
        assertEquals("values(value) must contain exactly {1..10}", expected, seen);  
        assertEquals("scalar agg must return exactly 1 row", 1, rows.size());
        assertEquals("list(value) must contain every integer in {1.." + totalDocs + "}", expected, seen);
        List<String> columns = extractColumnNames(result);
        } catch (Exception ignored) {}
        }  
    }
        createParquetBackedIndex(index);
     * rewrite the parent Project's expressions to reference the rebuilt exchange columns.  
        createParquetBackedIndex(index);
        assertEquals("COUNT", totalDocs, ((Number) row.get(columns.indexOf("c"))).longValue());  
/*  
        assertNotNull("cell for 'p' must not be null — coordinator-reduce returned no value", cell);  
     * cycles through {@code 1..10} twice — so 20 docs but only 10 distinct values. Used
     */
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
        Map<String, Object> result = executePpl(  
     * index — yielding values {@code 1..DOCS_PER_SHARD} (i.e. {@code 1..10}). Used by the
        bulkAndRefresh(indexName, bulk.toString());
     */
 *       ({@code AggregateFunction.intermediateFields == null})</li>
        indexSequentialValueDocsSingleShard(index);
     * shape without the WHERE clause. Every doc lands in the single {@code category=''}
        try {  
     * without interacting with the aggregate-call decomposition (key columns sit at the
        String body = "{"
        Object cell = rows.get(0).get(columns.indexOf("l"));
        client().performRequest(bulkRequest);
    public void testScalarCountAcrossShards() throws Exception {
        createParquetBackedIndex(index);
     */  
        } catch (Exception ignored) {}
        int actual = ((Number) cell).intValue();  
        Object cell = rows.get(0).get(columns.indexOf("l"));  
     * wrapper produced for AVG. Covers the case where the aggregate decomposition has to
        List<Object> listed = (List<Object>) cell;
        bulkRequest.setJsonEntity(bulkBody);  
 *       → drain → downstream → assembled PPLResponse
    public void testDistinctCountCrossShardOverlapKeyword() throws Exception {  
            seen.add(Integer.parseInt((String) v));
    }
    /**  
            + "  \"properties\": {"  
        assertEquals("list(value) must return exactly " + totalDocs + " elements", totalDocs, listed.size());  
        List<List<Object>> rows = scalarRows(result, "total");
        create.setJsonEntity(body);  
        long actual = ((Number) rows.get(0).get(0)).longValue();
        health.addParameter("timeout", "30s");
        }
    }
        createSingleShardParquetBackedIndex(index);  
            + "  }"
package org.opensearch.analytics.qa;
        createSingleShardParquetBackedIndex(index);  
     * Shape: {@code WHERE <pred> | stats count() as c by <string-key> | sort - c | head N}
            actual >= distinct - 2 && actual <= distinct + 2  
        @SuppressWarnings("unchecked")
            + "},"  
    /** Cross-shard {@code first(value)} — arrival order non-deterministic; assert membership only. */
     * {@code stats sum(value) as total by value} — group-by flows through partial/final
        Object cell = rows.get(0).get(columns.indexOf("t"));  
    /** Cross-shard {@code values(value)} — coordinator concatenates and re-deduplicates via list_merge_distinct UDAF. */
            bulk.append("{\"index\": {}}\n");
    public void testTakeAcrossShards() throws Exception {
        List<Object> taken = (List<Object>) cell;  
    private void indexStringGroupDocs() throws Exception {
        assertTrue("columns must contain 'v', got " + columns, columns.contains("v"));
        Map<String, Object> result = executePpl("source = " + INDEX + " | stats avg(value) as a");
        // All docs share category='' — makes "WHERE category != ''" filter every row on
            bulk.append("{\"index\": {}}\n");  
        indexConstantValueDocs(INDEX);
    public void testScalarSumAcrossShards() throws Exception {
        List<String> columns = extractColumnNames(result);
            + "  \"index.composite.primary_data_format\": \"parquet\","
        health.addParameter("wait_for_status", "green");
            Math.abs(actual - expected) <= 2.0  
        @SuppressWarnings("unchecked")
        Map<String, Object> result = executePpl("source = " + index + " | stats first(value) as f");
     * HLL sketch; resolver rebinds FINAL's arg to the sketch column and DataFusion's
        for (Object v : got) {
     */
    public void testListSingleShard() throws Exception {
        }
            + "\"settings\": {"  
        Object cell = rows.get(0).get(columns.indexOf("l"));
        assertTrue("last(value) must be in {1.." + DOCS_PER_SHARD + "}, got " + actual, actual >= 1 && actual <= DOCS_PER_SHARD);
        // every shard, exercising the empty-partial path.  
        assertNotNull("cell for '" + columnName + "' must not be null — coordinator-reduce returned no value", cell);
import java.util.List;
