            + "{\"user_id\":2,\"phrase\":\"alpha\"}\n"
        String ftMapping = "{\"properties\":{\"service\":{\"type\":\"keyword\"},\"trace\":{\"type\":\"keyword\"},\"body\":{\"type\":\"text\"}}}";
        ensureEmptyDcProvisioned();
        assertEquals(4, rows.size());
        assertEquals("1 distinct trace matches reset (B only, A trimmed to zero)", 1L, dc);
        createParquetIndex(PQONLY_B, "{\"properties\":{\"status\":{\"type\":\"integer\"},\"message\":{\"type\":\"keyword\"},\"source\":{\"type\":\"keyword\"}}}");
        bulk(MSHARD_B, docsB.toString());
        ensureMshardProvisioned();
        long count = singleCount("source=" + PQLUC_ALIAS + " | stats count() as c");
        String secondEmpty = "multi_empty_dc_empty_second";
        bulk(mismatchB, "{\"val\":\"hello\"}\n");
    }
        ensureEmptyDcProvisioned();
    }
    }
    }
        List<String> columns = extractColumnNames(body);
        int extraCol = columns.indexOf("extra");
        long total = ((Number) rows.get(0).get(0)).longValue();
        assertEquals("alias fan-out: 3 + 2 = 5", 5L, count);
        assertContains(error, "incompatible field types");
        StringBuilder docsA = new StringBuilder();
    public void testWildcardFilterAggregation() throws IOException {
    // and DataFusion executed the marker UDF). Single-index match() always worked; these
        createIndexWithSettings(FT_B, ftMapping, true, 2);
        Map<String, Object> body = executePpl(
        String mismatchA = "multi_aliasmm_a";
    public void testMatchDelegationCommaListCount() throws IOException {
    }
        Map<String, Object> response = assertOkAndParse(client().performRequest(request), "bulk " + index);
    private static final String EMPTY_DC_DATA = "multi_empty_dc_data";
        String secondaryFormats = ",\"index.composite.secondary_data_formats\":\"lucene\"";
        String mismatchA = "multi_mismatch_a";
        List<String> columns = extractColumnNames(body);
    // ── Type coverage: verifies the Substrait→Arrow round-trip for various field types ──
        createIndexWithSettings(name, mappingJson, false, 1);
        @SuppressWarnings("unchecked")
    public void testMultiShardAggregationAcrossUnion() throws IOException {
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
        assertEquals("index A rows have null score", 2, nullScores);
        for (List<Object> row : rows) {
        ensureMshardProvisioned();
        bulk(EMPTY_DC_DATA,
        @SuppressWarnings("unchecked")
    // ── Full-text delegation across multiple indices ──
        createCompositeIndex(PQLUC_B, "{\"properties\":{\"status\":{\"type\":\"integer\"},\"message\":{\"type\":\"keyword\"},\"source\":{\"type\":\"keyword\"}}}");
        assertEquals("distinct traces", 3L, ((Number) rows.get(0).get(1)).longValue());
        request.setJsonEntity(bulkBody.toString());
    }
    }
        createParquetIndex(dynB, "{\"properties\":{\"id\":{\"type\":\"integer\"}}}");
 */
            "source=" + FT_A + "," + FT_B + " | where match(body, 'timeout') | fields trace, service | head 20");
        long dc = singleCount("source=" + FT_A + "," + FT_B + " | where match(body, 'reset') | stats dc(trace) as ut");
            if (row.get(labelCol) == null) nullLabels++;
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
        ensureProvisioned();
        Map<String, Object> body = executePpl(
    }
 * compatible open source license.
        assertTrue("must have extra", columns.contains("extra"));
        assertEquals(3, rows.size());
    }
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
        putAlias(TYPES_ALIAS, List.of(TYPES_A, TYPES_B));
        assertEquals("sum(1+2+3+4)", 10L, total);
    }
    private void createIndexWithSettings(String name, String mappingJson, boolean withLuceneSecondary) throws IOException {
            bulkBody.append("{\"index\": {}}\n").append(doc).append("\n");
        ensureProvisioned();
        return ((Number) cell).longValue();
    }
        assertEquals("type coverage: 2 + 2 = 4", 4L, count);
        long total = ((Number) rows.get(0).get(0)).longValue();
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
            return new String(is.readAllBytes(), java.nio.charset.StandardCharsets.UTF_8);
        assertScalarDc("source=" + EMPTY_DC_ALIAS + " | where user_id + 1 > 2 | stats dc(user_id)", 3L);
        long dc = singleCount("source=" + FT_A + "," + FT_B + " | where match(body, 'timeout') | stats dc(trace) as ut");
        assertEquals("sum(200+500+200+200+404)", 1504L, total);
    public void testMatchDelegationDistinctCount() throws IOException {
    public void testEmptySiblingDcWithDelegatedFilter() throws IOException {
    }
        ensureEmptyDcProvisioned();
    }
        ensureProvisioned();
    private static final String PQONLY_ALIAS = "multi_pq_alias";
        ensureProvisioned();
        Map<String, Object> body = executePpl("source=" + PQONLY_ALIAS + " | stats sum(status) as total");
    // delegated_predicate FilterExec (the IndexedTableProvider was registered under the
        long count = singleCount("source=" + FT_A + "," + FT_B + " | where match(body, 'reset') | stats count() as c");
    }
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
        String dynB = "multi_dyn_b";
    public void testEmptySiblingDcWithNonDelegatedFilter() throws IOException {
        for (String doc : ndjsonDocs.split("\n")) {
    public void testMultiShardNullFillFieldsPresent() throws IOException {
        assertEquals("checkout has 3 distinct timeout traces", 3L, ((Number) rows.get(0).get(0)).longValue());
    private void ensureMshardProvisioned() throws IOException {
/**
        Map<String, Object> body = executePpl("source=" + PQLUC_ALIAS + " | stats sum(status) as total");
        String dynAlias = "multi_dyn_alias";
        ensureProvisioned();
    }
    }
                + "\"index.pluggable.dataformat\":\"composite\","
        assertContains(error, "incompatible field types");
            "source=" + EMPTY_DC_ALIAS + " | where phrase != '' | stats dc(user_id) as u by phrase"
        // Parquet-only: index A has {status, message}, index B has {status, message, source}
        @SuppressWarnings("unchecked")
        createParquetIndex(dynA, "{\"properties\":{\"id\":{\"type\":\"integer\"}}}");
        createIndexWithSettings(MSHARD_A, "{\"properties\":{\"val\":{\"type\":\"long\"},\"tag\":{\"type\":\"keyword\"}}}", false, 2);
                + "\"index.number_of_shards\":" + shards + ",\"index.number_of_replicas\":0"
            "source=" + FT_A + "," + FT_B + " | where match(body, 'timeout') | stats count() as c by service | sort -c");
        if (mshardProvisioned) return;
        putAlias(dynAlias, List.of(dynA, dynB));
        assertTrue("must have tag", columns.contains("tag"));
        // Parquet+Lucene: same field layout, enables filter delegation
    private static final String FT_B = "multi_ft_b";
        provisioned = true;
    }
        createParquetIndex(mismatchB, "{\"properties\":{\"score\":{\"type\":\"keyword\"}}}");
        request.setOptions(request.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
    private static final String PQLUC_ALIAS = "multi_pqluc_alias";
        long count = singleCount("source=" + MSHARD_ALIAS + " | stats count() as c");
        ensureProvisioned();
        for (List<Object> row : rows) total += ((Number) row.get(0)).longValue();
        long count = singleCount("source=" + FT_ALIAS + " | where match(body, 'exception') | stats count() as c");
        assertTrue("must have source column", columns.contains("source"));
        assertEquals("dynA rows have null country", 2, nullCountries);
    }
    }
    // per-shard name, not the plan's multi-index NamedTable, so the scan never bound to it
        put.setJsonEntity(actions.toString());
    private void bulk(String index, String ndjsonDocs) throws IOException {
        String mismatchB = "multi_mismatch_b";
    public void testAliasAggregation() throws IOException {
    public void testDelegationAliasAggregation() throws IOException {
        // sum(0..9) + sum(10..19) = 45 + 145 = 190
        Map<String, Object> body = executePpl("source=" + PQONLY_ALIAS + " | fields message, source");
            "{\"properties\":{\"id\":{\"type\":\"integer\"},\"label\":{\"type\":\"keyword\"},\"active\":{\"type\":\"boolean\"}}}");
        create.setJsonEntity(
        }
        long total = ((Number) rows.get(0).get(0)).longValue();
        assertScalarDc("source=" + EMPTY_DC_ALIAS + " | where phrase != '' | stats dc(user_id)", 4L);
        List<String> columns = extractColumnNames(body);
    }
    /** dc() with a non-delegable WHERE (arithmetic) → populated shards stay on the non-indexed path. */
        Request request = new Request("POST", "/" + index + "/_bulk");
        @SuppressWarnings("unchecked")
    }
        createIndexWithSettings(MSHARD_B, "{\"properties\":{\"val\":{\"type\":\"long\"},\"extra\":{\"type\":\"double\"}}}", false, 2);
        if (typesProvisioned) return;
        ensureEmptyDcProvisioned();
        try {
        ensureProvisioned();
        assertTrue("expected numeric count: " + cell, cell instanceof Number);
        createCompositeIndex(PQLUC_A, "{\"properties\":{\"status\":{\"type\":\"integer\"},\"message\":{\"type\":\"keyword\"}}}");
    }
    private static final String MSHARD_A = "multi_mshard_a";
        assertNotNull("missing 'rows' for: " + ppl, rows);
    public void testEmptySiblingDcScalar() throws IOException {
    // runtime-empty path on a populated shard (distinct from the zero-doc EmptyExec guard).
        assertScalarDc(
        @SuppressWarnings("unchecked")
        int nullCount = 0;
        assertEquals("index A rows have null source", 3, nullCount);
    public void testDelegationAliasNullFill() throws IOException {
        assertEquals(1, rows.size());
        assertEquals("3 distinct traces match timeout across both indices", 3L, dc);
    private static final String TYPES_ALIAS = "multi_types_alias";
        long count = singleCount("source=" + PQONLY_ALIAS + " | where status = 200 | stats count() as c");
        assertEquals("dynamic mapping union: 2 + 2 = 4", 4L, count);
    private static final String PQONLY_B = "multi_pq_b";
        ensureProvisioned();
        assertEquals("checkout", rows.get(0).get(1));
        Map<String, Object> body = executePpl("source=" + MSHARD_ALIAS + " | fields val, tag, extra");
                + "},\"mappings\":" + mappingJson + "}"
import java.util.List;
    private static final String MSHARD_ALIAS = "multi_mshard_alias";
        @SuppressWarnings("unchecked")
    public void testTypeCoverageUnionFanOut() throws IOException {
        String mismatchAlias = "multi_aliasmm";
        } catch (ResponseException re) {
        ensureProvisioned();
        bulk(mismatchA, "{\"val\":1}\n");
    public void testMatchDelegationOneIndexTrimmedToZeroCount() throws IOException {
        // 10 docs per index spread across 2 shards each = 4 shards total feeding the reduce
        assertEquals("4 total rows", 4, rows.size());
        assertEquals("sum across multi-shard union", 190L, total);
    // ── Parquet-only: alias scan ──
            }
        if (emptyDcProvisioned) return;
        Map<String, Object> body = executePpl("source=" + MSHARD_ALIAS + " | stats sum(val) as total");
    }
        assertEquals("index A rows have null source", 3, nullCount);
    private static final String FT_ALIAS = "multi_ft_alias";
    /** All-empty union: every shard hits the empty-guard. */
        bulk(FT_A, "{\"service\":\"checkout\",\"trace\":\"a1\",\"body\":\"exception timeout failed\"}\n"
    private long singleCount(String ppl) throws IOException {
        assertEquals("status=200: 2 from A + 1 from B = 3", 3L, count);
        for (List<Object> row : rows) {
        createParquetIndex(mismatchA, "{\"properties\":{\"score\":{\"type\":\"double\"}}}");
            + "{\"user_id\":4,\"phrase\":\"gamma\"}\n");
        }
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
        int labelCol = columns.indexOf("label");
            Response response = client().performRequest(request);
        @SuppressWarnings("unchecked")
            + "{\"service\":\"frontend\",\"trace\":\"b2\",\"body\":\"connection reset\"}\n");
            + "{\"service\":\"frontend\",\"trace\":\"a3\",\"body\":\"all good\"}\n");
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
    // ── Dynamic mapping: fields added by indexing without explicit mapping ──
        assertContains(error, "score");
        String error = executePplExpectingFailure("source=" + mismatchAlias + " | stats count() as c");
    public void testAliasScanFanOut() throws IOException {
        // EMPTY_DC_EMPTY is intentionally never bulk-loaded.
    }
        assertTrue("must have country", columns.contains("country"));
        bulk(TYPES_A, "{\"id\":1,\"label\":\"foo\",\"active\":true}\n{\"id\":2,\"label\":\"bar\",\"active\":false}\n");
    }
        assertTrue("must have all union columns", columns.containsAll(List.of("id", "label", "active", "score", "count")));
        createIndexWithSettings(EMPTY_DC_EMPTY, EMPTY_DC_FIELDS, true, 2);
    // A delegated match() that trims one populated index to zero rows: 'reset' is only in B,
        long total = ((Number) rows.get(0).get(0)).longValue();
        } catch (ResponseException re) {
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
        assertTrue("must have city", columns.contains("city"));
        }
import java.util.Map;
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
        Map<String, Object> body = executePpl("source=" + PQLUC_ALIAS + " | fields message, source");
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
 * <p>Tests run against parquet-only indices AND parquet+lucene indices (for filter delegation).
        assertEquals("index B rows have null label", 2, nullLabels);
            0L);
        createParquetIndex(mismatchA, "{\"properties\":{\"val\":{\"type\":\"long\"}}}");
            + "{\"service\":\"checkout\",\"trace\":\"a2\",\"body\":\"timeout while reading\"}\n"
        bulk(PQONLY_A, "{\"status\":200,\"message\":\"ok\"}\n{\"status\":500,\"message\":\"error\"}\n{\"status\":200,\"message\":\"hello\"}\n");
        assertEquals(1, rows.size());
        @SuppressWarnings("unchecked")
    private static boolean mshardProvisioned = false;
        ensureTypesProvisioned();
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
    // so A's shards run the filter and emit nothing while B returns data. Exercises the
    private String executePplExpectingFailure(String ppl) throws IOException {
    private static final String EMPTY_DC_EMPTY = "multi_empty_dc_empty";
            actions.append("{\"add\":{\"index\":\"").append(indices.get(i)).append("\",\"alias\":\"").append(alias).append("\"}}");
        actions.append("]}");
            if (doc.isBlank()) continue;
        }
        assertEquals("timeout matches: 2 in A + 1 in B", 3L, count);
    }
        assertEquals("delegation wildcard fan-out: 3 + 2 = 5", 5L, count);
        assertEquals(4L, total);
    // ── Parquet+Lucene: wildcard ──
 *
        @SuppressWarnings("unchecked")
        Map<String, Object> body = executePpl(
    private static final String PQLUC_A = "multi_pqluc_a";
 * across different query shapes: plain scan, filter, aggregation, and filter delegation.
        bulk(FT_B, "{\"service\":\"checkout\",\"trace\":\"b1\",\"body\":\"timeout exception\"}\n"
        putAlias(EMPTY_DC_ALIAS, List.of(EMPTY_DC_DATA, EMPTY_DC_EMPTY));
        bulk(PQLUC_A, "{\"status\":200,\"message\":\"ok\"}\n{\"status\":500,\"message\":\"error\"}\n{\"status\":200,\"message\":\"hello\"}\n");
        long count = singleCount("source=multi_pqluc_* | stats count() as c");
        assertEquals(1, rows.size());
        request.addParameter("refresh", "true");
            if (row.get(countryCol) == null) nullCountries++;
        assertEquals(3L, ((Number) rows.get(0).get(0)).longValue());
        // Create indices with minimal explicit mapping; let dynamic mapping add fields from docs
            if (row.get(scoreCol) == null) nullScores++;
    public void testDelegationWildcardFanOut() throws IOException {
    }
            if (row.get(cityCol) == null) nullCities++;
    }
        ensureTypesProvisioned();
    //    service/trace so match() delegates to Lucene across multiple indices. ──
 * End-to-end integration tests exercising multi-index queries (aliases, wildcard patterns)
        assertTrue("must have source column", columns.contains("source"));
        assertEquals(1, rows.size());
        assertEquals("exception matches: 1 in A + 1 in B", 2L, count);
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
    /** Grouped dc() with a delegated WHERE → exercises FinalPartitioned/Partial on data shards + EmptyExec on empties. */
        ensureProvisioned();
        bulk(PQONLY_B, "{\"status\":200,\"message\":\"world\",\"source\":\"app1\"}\n{\"status\":404,\"message\":\"not found\",\"source\":\"app2\"}\n");
            docsB.append("{\"val\":").append(i + 10).append(",\"extra\":").append(i * 1.5).append("}\n");
        client().performRequest(put);
        createIndexWithSettings(name, mappingJson, withLuceneSecondary, 1);
    // ── Parquet-only indices (non-indexed path) ──
import org.opensearch.client.Request;
        bulk(mismatchA, "{\"score\":1.5}\n");
public class MultiIndexQueryShapesIT extends AnalyticsRestTestCase {
    private void assertScalarDc(String ppl, long expected) throws IOException {
        createIndexWithSettings(EMPTY_DC_DATA, EMPTY_DC_FIELDS, true, 2);
        try (var is = response.getEntity().getContent()) {
        @SuppressWarnings("unchecked")
    }
                + "\"index.composite.primary_data_format\":\"parquet\","
    public void testDelegationAliasScanFanOut() throws IOException {
            if (i > 0) actions.append(",");
        // Index B: integer, double, long (keyword/boolean absent → null-filled)
        List<String> columns = extractColumnNames(body);
    }
        int scoreCol = columns.indexOf("score");
                + " | where match(body, 'timeout') | stats count() as c, dc(trace) as ut by service | sort -c");
        }
        createIndexWithSettings(secondEmpty, EMPTY_DC_FIELDS, true, 2);
        ensureProvisioned();
    /** dc() with no WHERE → populated shards take the non-indexed path. */
        String mismatchB = "multi_aliasmm_b";
        assertEquals("checkout", rows.get(0).get(1));
        int nullCities = 0, nullCountries = 0;
        @SuppressWarnings("unchecked")
        int nullLabels = 0, nullScores = 0;
        createParquetIndex(TYPES_B,
package org.opensearch.analytics.qa;
        long count = singleCount("source=" + FT_A + "," + FT_B + " | where match(body, 'timeout') | stats count() as c");
            "source=" + EMPTY_DC_EMPTY + "," + secondEmpty + " | where phrase != '' | stats dc(user_id)",
    }
    private void createIndexWithSettings(String name, String mappingJson, boolean withLuceneSecondary, int shards) throws IOException {
        assertEquals("status > 200: 500 from A + 404 from B = 2", 2L, count);
            if (row.get(sourceCol) == null) nullCount++;
        assertEquals("sum(200+500+200+200+404)", 1504L, total);
    }
        String error = executePplExpectingFailure("source=multi_mismatch_* | stats count() as c");
        ensureEmptyDcProvisioned();
                + secondaryFormats
    public void testMatchDelegationWildcardDistinctCount() throws IOException {
        for (List<Object> row : rows) {
    }
        ensureProvisioned();
        bulk(TYPES_B, "{\"id\":3,\"score\":9.5,\"count\":100}\n{\"id\":4,\"score\":3.2,\"count\":200}\n");
        assertEquals("delegation alias fan-out: 3 + 2 = 5", 5L, count);
    public void testTypeCoverageAggregateOnSharedField() throws IOException {
        int sourceCol = columns.indexOf("source");
        for (List<Object> row : rows) {
        @SuppressWarnings("unchecked")
    private static final String PQONLY_A = "multi_pq_a";
    public void testTypeCoverageNullFillAcrossTypes() throws IOException {
        long count = singleCount("source=" + dynAlias + " | stats count() as c");
    // ── Parquet+Lucene (delegation): alias scan ──
        Request request = new Request("POST", "/_plugins/_ppl");
                throw re;
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
    public void testWildcardTypeMismatchIsRejected() throws IOException {
    public void testEmptySiblingDcGroupedWithDelegatedFilter() throws IOException {
        Map<String, Object> body = executePpl("source=" + TYPES_ALIAS + " | fields id, label, active, score, count");
            fail("Expected failure but got: " + assertOkAndParse(response, ppl));
    private static String entityAsString(Response response) throws IOException {
        int nullTags = 0, nullExtras = 0;
    private static final String PQLUC_B = "multi_pqluc_b";
        "{\"properties\":{\"user_id\":{\"type\":\"long\"},\"phrase\":{\"type\":\"keyword\"}}}";
    private void createCompositeIndex(String name, String mappingJson) throws IOException {
    private void ensureTypesProvisioned() throws IOException {
        ensureTypesProvisioned();
        assertEquals(1, rows.size());
    // ── Failure tests: type mismatch rejection ──
        typesProvisioned = true;
        );
        createParquetIndex(mismatchB, "{\"properties\":{\"val\":{\"type\":\"keyword\"}}}");
        }
 * this file be licensed under the Apache-2.0 license or a
    private static final String FT_A = "multi_ft_a";
        ensureProvisioned();
        );
        Map<String, Object> body = executePpl("source=" + dynAlias + " | fields id, city, country");
        assertEquals(1, rows.size());
        @SuppressWarnings("unchecked")
            "{\"settings\":{\"index.pluggable.dataformat.enabled\":true,"
    }
    }
    }
        assertEquals("dynB rows have null city", 2, nullCities);
        ensureProvisioned();
    }
    }
        @SuppressWarnings("unchecked")
        Request create = new Request("PUT", "/" + name);
    // Regression for the bug where a delegated match() on a multi-index source kept the
    // ── Parquet+Lucene indices (indexed/delegation path) ──
import org.opensearch.client.ResponseException;
    }
            if (!body.contains("resource_already_exists_exception")) {
        int nullCount = 0;
    // exercise the comma-list and alias multi-index shapes with every row-materializing op.
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
        @SuppressWarnings("unchecked")
            return entityAsString(re.getResponse());
    public void testMatchDelegationCountAndDistinctCountGroupBy() throws IOException {
import org.opensearch.client.Response;
    // ── Helpers ──
        int tagCol = columns.indexOf("tag");
        // Index A: integer, keyword, boolean
    private static void assertContains(String haystack, String needle) {
    private void createParquetIndex(String name, String mappingJson) throws IOException {
        assertEquals("single count row expected: " + ppl, 1, rows.size());
    }
    private static final String EMPTY_DC_ALIAS = "multi_empty_dc_alias";
    public void testMatchDelegationFieldsMaterialization() throws IOException {
        }
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
    }
            + "{\"user_id\":3,\"phrase\":\"beta\"}\n"
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
    public void testAliasNullFillForDifferingFields() throws IOException {
}
        assertEquals("multi-shard: 10 + 10 = 20", 20L, count);
        int sourceCol = columns.indexOf("source");
        bulk(dynB, "{\"id\":3,\"country\":\"US\"}\n{\"id\":4,\"country\":\"CA\"}\n");
        Map<String, Object> body = executePpl(ppl);
 * Each test verifies correct fan-out, null-fill for differing field sets, and result correctness.
        }
        assertTrue("expected to contain [" + needle + "] but was: " + haystack, haystack.contains(needle));
        assertScalarDc("source=" + EMPTY_DC_ALIAS + " | stats dc(user_id)", 4L);
            String body = entityAsString(re.getResponse());
    private void ensureEmptyDcProvisioned() throws IOException {
    private static final String MSHARD_B = "multi_mshard_b";
    public void testMatchDelegationAcrossAlias() throws IOException {
        ensureProvisioned();
        putAlias(PQONLY_ALIAS, List.of(PQONLY_A, PQONLY_B));
        long count = singleCount("source=multi_pq_* | stats count() as c");
        long total = 0;
    }
            return "";
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
        try {
    public void testMatchDelegationOneIndexTrimmedToZeroDistinctCount() throws IOException {
        long count = singleCount("source=multi_pq_* | where status > 200 | stats count() as c");
            "source=" + FT_A + "," + FT_B
    // ── Multi-shard: verifies reduce handles null-filled batches from different shards ──
        ensureProvisioned();
        StringBuilder actions = new StringBuilder("{\"actions\":[");
    public void testDynamicMappingUnionAcrossIndices() throws IOException {
        assertEquals("count", 3L, ((Number) rows.get(0).get(0)).longValue());
        for (int i = 0; i < indices.size(); i++) {
        Map<String, Object> body = executePpl(
            client().performRequest(create);
    }
        assertEquals(5, rows.size());
        StringBuilder bulkBody = new StringBuilder();
            if (row.get(tagCol) == null) nullTags++;
        emptyDcProvisioned = true;
    private static final String TYPES_A = "multi_types_a";
        }
        assertEquals(1, rows.size());
        @SuppressWarnings("unchecked")
        StringBuilder docsB = new StringBuilder();
    }
 * The OpenSearch Contributors require contributions made to
    private void ensureProvisioned() throws IOException {
        Request put = new Request("POST", "/_aliases");
        createParquetIndex(PQONLY_A, "{\"properties\":{\"status\":{\"type\":\"integer\"},\"message\":{\"type\":\"keyword\"}}}");
        @SuppressWarnings("unchecked")
    }
    // ── Parquet-only: wildcard scan ──
        @SuppressWarnings("unchecked")
        assertEquals("3 rows match timeout", 3, rows.size());
        assertEquals(expected, ((Number) rows.get(0).get(0)).longValue());
        createParquetIndex(TYPES_A,
    public void testMatchDelegationCommaListGroupBy() throws IOException {
        // Index docs with different dynamic fields — dynA gets "city", dynB gets "country"
    // ── Empty-sibling multi-index dc(): regression for engine-native-merge empty-shard schema ──
        assertEquals("wildcard fan-out: 3 + 2 = 5", 5L, count);
        }
            docsA.append("{\"val\":").append(i).append(",\"tag\":\"t").append(i).append("\"}\n");
        bulk(mismatchB, "{\"score\":\"high\"}\n");
        ensureProvisioned();
        Map<String, Object> body = executePpl(
        if (provisioned) return;
        assertEquals("total rows: 3 + 2 = 5", 5, rows.size());
        @SuppressWarnings("unchecked")
        int cityCol = columns.indexOf("city");
        assertEquals("20 total rows", 20, rows.size());
    private static boolean emptyDcProvisioned = false;
        assertEquals("index B rows have null tag", 10, nullTags);
            if (row.get(sourceCol) == null) nullCount++;
        createIndexWithSettings(FT_A, ftMapping, true, 2);
        @SuppressWarnings("unchecked")
        List<String> columns = extractColumnNames(body);
        Map<String, Object> body = executePpl("source=" + TYPES_ALIAS + " | stats sum(id) as total");
    public void testAliasFilter() throws IOException {
        Object cell = rows.get(0).get(0);
    public void testAliasTypeMismatchIsRejected() throws IOException {
        assertEquals("checkout", rows.get(0).get(2));
        }
import java.io.IOException;
        bulk(MSHARD_A, docsA.toString());
        assertContains(error, "val");
        mshardProvisioned = true;
        @SuppressWarnings("unchecked")
        ensureMshardProvisioned();
        ensureProvisioned();
            "{\"properties\":{\"id\":{\"type\":\"integer\"},\"score\":{\"type\":\"double\"},\"count\":{\"type\":\"long\"}}}");
        putAlias(mismatchAlias, List.of(mismatchA, mismatchB));
        int countryCol = columns.indexOf("country");
            "source=multi_ft_* | where match(body, 'timeout') | stats dc(trace) as ut by service | sort -ut");
    private static final String EMPTY_DC_FIELDS =
        long count = singleCount("source=" + PQONLY_ALIAS + " | stats count() as c");
 *
        putAlias(MSHARD_ALIAS, List.of(MSHARD_A, MSHARD_B));
        Map<String, Object> body = executePpl(ppl);
        for (int i = 0; i < 10; i++) {
        bulk(PQLUC_B, "{\"status\":200,\"message\":\"world\",\"source\":\"app1\"}\n{\"status\":404,\"message\":\"not found\",\"source\":\"app2\"}\n");
    // ── Full-text delegation indices: composite, multi-shard, with a text body + keyword
        long count = singleCount("source=" + TYPES_ALIAS + " | stats count() as c");
    private static final String TYPES_B = "multi_types_b";
    }
    }
 */
/*
        assertEquals("reset matches: 0 in A + 1 in B", 1L, count);
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("bulk into " + index + " had errors", false, response.get("errors"));
    public void testWildcardScanFanOut() throws IOException {
    private static boolean typesProvisioned = false;
        bulk(dynA, "{\"id\":1,\"city\":\"Seattle\"}\n{\"id\":2,\"city\":\"Portland\"}\n");
            if (row.get(extraCol) == null) nullExtras++;
            "{\"user_id\":1,\"phrase\":\"alpha\"}\n"
        ensureProvisioned();
    private void putAlias(String alias, List<String> indices) throws IOException {
        putAlias(PQLUC_ALIAS, List.of(PQLUC_A, PQLUC_B));
        putAlias(FT_ALIAS, List.of(FT_A, FT_B));
    }
        assertEquals("index A rows have null extra", 10, nullExtras);
    public void testAllEmptyDc() throws IOException {
    /** dc() with a lucene-delegated WHERE → populated shards take the indexed path (the regression case). */
        String dynA = "multi_dyn_a";
    public void testMultiShardReduceWithNullFill() throws IOException {
        assertEquals(1, rows.size());
    private static boolean provisioned = false;
        for (List<Object> row : rows) {
        createIndexWithSettings(name, mappingJson, true, 1);
