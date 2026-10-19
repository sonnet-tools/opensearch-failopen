    private static final String PQONLY_B = "multi_pq_b";
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
            "source=" + EMPTY_DC_ALIAS + " | where phrase != '' | stats dc(user_id) as u by phrase"
        bulk(PQONLY_A, "{\"status\":200,\"message\":\"ok\"}\n{\"status\":500,\"message\":\"error\"}\n{\"status\":200,\"message\":\"hello\"}\n");  
        } catch (ResponseException re) {
import org.opensearch.client.ResponseException;  
        createIndexWithSettings(MSHARD_A, "{\"properties\":{\"val\":{\"type\":\"long\"},\"tag\":{\"type\":\"keyword\"}}}", false, 2);  
        assertScalarDc(
    public void testEmptySiblingDcWithNonDelegatedFilter() throws IOException {
        }
        assertEquals("timeout matches: 2 in A + 1 in B", 3L, count);  
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
        }  
        assertEquals("status=200: 2 from A + 1 from B = 3", 3L, count);
        Map<String, Object> body = executePpl(ppl);
public class MultiIndexQueryShapesIT extends AnalyticsRestTestCase {
        ensureEmptyDcProvisioned();  
    /** dc() with no WHERE → populated shards take the non-indexed path. */
        String secondaryFormats = ",\"index.composite.secondary_data_formats\":\"lucene\"";
    //    service/trace so match() delegates to Lucene across multiple indices. ──
        bulk(MSHARD_A, docsA.toString());  
        ensureProvisioned();  
 * compatible open source license.
        for (List<Object> row : rows) {  
        }  
        long count = singleCount("source=" + FT_ALIAS + " | where match(body, 'exception') | stats count() as c");
 * Each test verifies correct fan-out, null-fill for differing field sets, and result correctness.
    // ── Parquet+Lucene (delegation): alias scan ──  
        );  
            "source=" + FT_A + "," + FT_B + " | where match(body, 'timeout') | stats count() as c by service | sort -c");  
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");  
        assertEquals("dynB rows have null city", 2, nullCities);
        @SuppressWarnings("unchecked")
    }
 * End-to-end integration tests exercising multi-index queries (aliases, wildcard patterns)
    public void testAliasScanFanOut() throws IOException {
        ensureTypesProvisioned();  
        int nullCount = 0;
        long total = ((Number) rows.get(0).get(0)).longValue();
 * <p>Tests run against parquet-only indices AND parquet+lucene indices (for filter delegation).
        String secondEmpty = "multi_empty_dc_empty_second";  
    public void testMatchDelegationAcrossAlias() throws IOException {  
        ensureProvisioned();
        String ftMapping = "{\"properties\":{\"service\":{\"type\":\"keyword\"},\"trace\":{\"type\":\"keyword\"},\"body\":{\"type\":\"text\"}}}";
    // ── Multi-shard: verifies reduce handles null-filled batches from different shards ──  
    }  
    public void testMatchDelegationWildcardDistinctCount() throws IOException {  
    }
        for (List<Object> row : rows) {
        ensureProvisioned();  
        List<String> columns = extractColumnNames(body);  
        assertScalarDc("source=" + EMPTY_DC_ALIAS + " | stats dc(user_id)", 4L);
    // ── Full-text delegation across multiple indices ──
            "source=" + FT_A + "," + FT_B
import java.util.Map;
            if (row.get(sourceCol) == null) nullCount++;  
            + "{\"service\":\"checkout\",\"trace\":\"a2\",\"body\":\"timeout while reading\"}\n"  
    }
    }  
        }  
        assertEquals("sum(1+2+3+4)", 10L, total);
        int nullLabels = 0, nullScores = 0;
        putAlias(mismatchAlias, List.of(mismatchA, mismatchB));
    /** All-empty union: every shard hits the empty-guard. */  
            return "";  
        Map<String, Object> body = executePpl("source=" + dynAlias + " | fields id, city, country");
        assertEquals(1, rows.size());  
    }
        @SuppressWarnings("unchecked")  
import java.util.List;  
        createCompositeIndex(PQLUC_A, "{\"properties\":{\"status\":{\"type\":\"integer\"},\"message\":{\"type\":\"keyword\"}}}");
            return entityAsString(re.getResponse());
        createParquetIndex(mismatchB, "{\"properties\":{\"score\":{\"type\":\"keyword\"}}}");
        long dc = singleCount("source=" + FT_A + "," + FT_B + " | where match(body, 'timeout') | stats dc(trace) as ut");
        assertContains(error, "incompatible field types");
        String mismatchA = "multi_aliasmm_a";  
                + "\"index.number_of_shards\":" + shards + ",\"index.number_of_replicas\":0"
            String body = entityAsString(re.getResponse());
    private void ensureMshardProvisioned() throws IOException {
        Map<String, Object> body = executePpl(ppl);
        @SuppressWarnings("unchecked")
        assertEquals("index B rows have null label", 2, nullLabels);  
    // and DataFusion executed the marker UDF). Single-index match() always worked; these  
    private static boolean emptyDcProvisioned = false;  
        StringBuilder docsB = new StringBuilder();
        for (List<Object> row : rows) {
        assertEquals("reset matches: 0 in A + 1 in B", 1L, count);  
        // sum(0..9) + sum(10..19) = 45 + 145 = 190
        }
            if (row.get(tagCol) == null) nullTags++;
    }
            docsA.append("{\"val\":").append(i).append(",\"tag\":\"t").append(i).append("\"}\n");  
        String mismatchAlias = "multi_aliasmm";
 * SPDX-License-Identifier: Apache-2.0
        createIndexWithSettings(name, mappingJson, false, 1);
        long count = singleCount("source=" + PQLUC_ALIAS + " | stats count() as c");
            + "{\"user_id\":3,\"phrase\":\"beta\"}\n"  
    // exercise the comma-list and alias multi-index shapes with every row-materializing op.
    }
        // Index A: integer, keyword, boolean
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
            if (!body.contains("resource_already_exists_exception")) {  
        bulk(dynA, "{\"id\":1,\"city\":\"Seattle\"}\n{\"id\":2,\"city\":\"Portland\"}\n");  
        @SuppressWarnings("unchecked")
    // ── Parquet-only indices (non-indexed path) ──  
        ensureEmptyDcProvisioned();
        String dynA = "multi_dyn_a";
        assertEquals("index A rows have null source", 3, nullCount);
    public void testTypeCoverageAggregateOnSharedField() throws IOException {
    public void testMultiShardReduceWithNullFill() throws IOException {  
        int countryCol = columns.indexOf("country");
    private static final String EMPTY_DC_ALIAS = "multi_empty_dc_alias";  
        int sourceCol = columns.indexOf("source");  
    /** dc() with a non-delegable WHERE (arithmetic) → populated shards stay on the non-indexed path. */
        try (var is = response.getEntity().getContent()) {  
        createIndexWithSettings(EMPTY_DC_EMPTY, EMPTY_DC_FIELDS, true, 2);
        // 10 docs per index spread across 2 shards each = 4 shards total feeding the reduce
        Map<String, Object> body = executePpl("source=" + PQONLY_ALIAS + " | stats sum(status) as total");
            + "{\"service\":\"frontend\",\"trace\":\"b2\",\"body\":\"connection reset\"}\n");  
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
    }  
        createIndexWithSettings(name, mappingJson, withLuceneSecondary, 1);  
        ensureProvisioned();
        assertTrue("must have country", columns.contains("country"));
            actions.append("{\"add\":{\"index\":\"").append(indices.get(i)).append("\",\"alias\":\"").append(alias).append("\"}}");  
        Map<String, Object> body = executePpl(
    public void testAliasNullFillForDifferingFields() throws IOException {  
    public void testWildcardScanFanOut() throws IOException {
    }
    private static final String PQLUC_B = "multi_pqluc_b";
    }
        // EMPTY_DC_EMPTY is intentionally never bulk-loaded.
    }
        putAlias(MSHARD_ALIAS, List.of(MSHARD_A, MSHARD_B));
/**  
    public void testMatchDelegationOneIndexTrimmedToZeroCount() throws IOException {  
    }  
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");  
/*  
        assertEquals("distinct traces", 3L, ((Number) rows.get(0).get(1)).longValue());
    private void putAlias(String alias, List<String> indices) throws IOException {
    // ── Empty-sibling multi-index dc(): regression for engine-native-merge empty-shard schema ──
import org.opensearch.client.Response;
        @SuppressWarnings("unchecked")
        assertEquals(4L, total);  
        Map<String, Object> body = executePpl(
        assertTrue("must have tag", columns.contains("tag"));
    private long singleCount(String ppl) throws IOException {  
        assertEquals("exception matches: 1 in A + 1 in B", 2L, count);  
        createIndexWithSettings(EMPTY_DC_DATA, EMPTY_DC_FIELDS, true, 2);
        assertEquals("checkout", rows.get(0).get(2));  
        putAlias(EMPTY_DC_ALIAS, List.of(EMPTY_DC_DATA, EMPTY_DC_EMPTY));  
        assertEquals(1, rows.size());
    }
        assertEquals(1, rows.size());  
        @SuppressWarnings("unchecked")
        assertEquals(1, rows.size());  
 */  
        int nullCities = 0, nullCountries = 0;
    private void ensureEmptyDcProvisioned() throws IOException {
        assertNotNull("missing 'rows' for: " + ppl, rows);
    public void testEmptySiblingDcGroupedWithDelegatedFilter() throws IOException {
    }
            if (row.get(scoreCol) == null) nullScores++;
    public void testAllEmptyDc() throws IOException {
        assertEquals("delegation alias fan-out: 3 + 2 = 5", 5L, count);
                throw re;
    }
        emptyDcProvisioned = true;
        StringBuilder docsA = new StringBuilder();  
    }  
    }
            "{\"user_id\":1,\"phrase\":\"alpha\"}\n"
    private static void assertContains(String haystack, String needle) {  
        Map<String, Object> body = executePpl("source=" + MSHARD_ALIAS + " | fields val, tag, extra");
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
    private void createIndexWithSettings(String name, String mappingJson, boolean withLuceneSecondary) throws IOException {
        } catch (ResponseException re) {
        Map<String, Object> body = executePpl(
    private void createCompositeIndex(String name, String mappingJson) throws IOException {
        request.setJsonEntity(bulkBody.toString());
        long count = singleCount("source=" + FT_A + "," + FT_B + " | where match(body, 'timeout') | stats count() as c");
    }  
        List<String> columns = extractColumnNames(body);
        assertEquals("single count row expected: " + ppl, 1, rows.size());
        request.addParameter("refresh", "true");
    public void testTypeCoverageUnionFanOut() throws IOException {
    }  
    }
    public void testWildcardTypeMismatchIsRejected() throws IOException {
    }  
        assertEquals("sum(200+500+200+200+404)", 1504L, total);  
        assertEquals("checkout", rows.get(0).get(1));
        for (List<Object> row : rows) {
        // Parquet-only: index A has {status, message}, index B has {status, message, source}  
        ensureProvisioned();  
        Map<String, Object> body = executePpl("source=" + PQLUC_ALIAS + " | stats sum(status) as total");
        @SuppressWarnings("unchecked")  
        List<String> columns = extractColumnNames(body);  
                + secondaryFormats
        ensureProvisioned();
        createParquetIndex(mismatchA, "{\"properties\":{\"val\":{\"type\":\"long\"}}}");
    private static final String FT_A = "multi_ft_a";  
        assertEquals("index A rows have null score", 2, nullScores);
        Request request = new Request("POST", "/_plugins/_ppl");
    }
        bulk(PQLUC_B, "{\"status\":200,\"message\":\"world\",\"source\":\"app1\"}\n{\"status\":404,\"message\":\"not found\",\"source\":\"app2\"}\n");
        int sourceCol = columns.indexOf("source");  
        bulk(EMPTY_DC_DATA,  
        @SuppressWarnings("unchecked")  
        long count = singleCount("source=multi_pqluc_* | stats count() as c");
            0L);
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");  
            if (doc.isBlank()) continue;  
        createParquetIndex(TYPES_A,
        @SuppressWarnings("unchecked")
    /** Grouped dc() with a delegated WHERE → exercises FinalPartitioned/Partial on data shards + EmptyExec on empties. */
                + "},\"mappings\":" + mappingJson + "}"  
    }
        createIndexWithSettings(MSHARD_B, "{\"properties\":{\"val\":{\"type\":\"long\"},\"extra\":{\"type\":\"double\"}}}", false, 2);
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
        assertTrue("must have city", columns.contains("city"));
                + " | where match(body, 'timeout') | stats count() as c, dc(trace) as ut by service | sort -c");  
        bulk(PQLUC_A, "{\"status\":200,\"message\":\"ok\"}\n{\"status\":500,\"message\":\"error\"}\n{\"status\":200,\"message\":\"hello\"}\n");
    public void testEmptySiblingDcScalar() throws IOException {
        createIndexWithSettings(name, mappingJson, true, 1);
            }
    // ── Type coverage: verifies the Substrait→Arrow round-trip for various field types ──
        List<String> columns = extractColumnNames(body);  
    // ── Parquet+Lucene: wildcard ──
 * The OpenSearch Contributors require contributions made to  
        ensureProvisioned();
    }  
        ensureMshardProvisioned();
        bulk(FT_B, "{\"service\":\"checkout\",\"trace\":\"b1\",\"body\":\"timeout exception\"}\n"
        assertEquals("3 rows match timeout", 3, rows.size());  
        assertEquals("wildcard fan-out: 3 + 2 = 5", 5L, count);
        StringBuilder actions = new StringBuilder("{\"actions\":[");  
        }
    }  
        @SuppressWarnings("unchecked")  
        @SuppressWarnings("unchecked")  
        assertEquals(1, rows.size());
        String error = executePplExpectingFailure("source=multi_mismatch_* | stats count() as c");  
        assertEquals(3, rows.size());  
    }  
        long count = singleCount("source=" + PQONLY_ALIAS + " | where status = 200 | stats count() as c");
    public void testWildcardFilterAggregation() throws IOException {
        assertEquals("20 total rows", 20, rows.size());
    }
        typesProvisioned = true;
            "{\"properties\":{\"id\":{\"type\":\"integer\"},\"label\":{\"type\":\"keyword\"},\"active\":{\"type\":\"boolean\"}}}");
        for (List<Object> row : rows) total += ((Number) row.get(0)).longValue();
    public void testDynamicMappingUnionAcrossIndices() throws IOException {
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
        assertEquals("type coverage: 2 + 2 = 4", 4L, count);
        String mismatchA = "multi_mismatch_a";
        ensureProvisioned();  
        putAlias(dynAlias, List.of(dynA, dynB));
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
        bulk(TYPES_A, "{\"id\":1,\"label\":\"foo\",\"active\":true}\n{\"id\":2,\"label\":\"bar\",\"active\":false}\n");
    }  
        ensureProvisioned();  
    }
    private static final String TYPES_A = "multi_types_a";
        assertEquals(1, rows.size());
        assertEquals(5, rows.size());
        int cityCol = columns.indexOf("city");  
        int nullCount = 0;
    private static final String EMPTY_DC_EMPTY = "multi_empty_dc_empty";
        assertTrue("must have all union columns", columns.containsAll(List.of("id", "label", "active", "score", "count")));
    // ── Helpers ──
    }
        int nullTags = 0, nullExtras = 0;
        ensureEmptyDcProvisioned();  
        return ((Number) cell).longValue();
        createParquetIndex(PQONLY_A, "{\"properties\":{\"status\":{\"type\":\"integer\"},\"message\":{\"type\":\"keyword\"}}}");
    public void testMultiShardNullFillFieldsPresent() throws IOException {
package org.opensearch.analytics.qa;
        assertEquals("1 distinct trace matches reset (B only, A trimmed to zero)", 1L, dc);  
        ensureProvisioned();
        assertEquals("delegation wildcard fan-out: 3 + 2 = 5", 5L, count);  
 *  
        assertEquals(3L, ((Number) rows.get(0).get(0)).longValue());
        assertEquals("bulk into " + index + " had errors", false, response.get("errors"));
        ensureEmptyDcProvisioned();  
            docsB.append("{\"val\":").append(i + 10).append(",\"extra\":").append(i * 1.5).append("}\n");
    /** dc() with a lucene-delegated WHERE → populated shards take the indexed path (the regression case). */
        createParquetIndex(PQONLY_B, "{\"properties\":{\"status\":{\"type\":\"integer\"},\"message\":{\"type\":\"keyword\"},\"source\":{\"type\":\"keyword\"}}}");
        int labelCol = columns.indexOf("label");
            if (row.get(labelCol) == null) nullLabels++;  
        assertEquals("4 total rows", 4, rows.size());
            if (i > 0) actions.append(",");
        if (mshardProvisioned) return;
        }
    }  
        assertScalarDc("source=" + EMPTY_DC_ALIAS + " | where phrase != '' | stats dc(user_id)", 4L);
    public void testTypeCoverageNullFillAcrossTypes() throws IOException {
        );
        // Create indices with minimal explicit mapping; let dynamic mapping add fields from docs
    }  
        assertEquals("sum across multi-shard union", 190L, total);
            return new String(is.readAllBytes(), java.nio.charset.StandardCharsets.UTF_8);
        // Parquet+Lucene: same field layout, enables filter delegation
        createIndexWithSettings(FT_B, ftMapping, true, 2);
 * this file be licensed under the Apache-2.0 license or a
    private static final String PQONLY_ALIAS = "multi_pq_alias";  
        try {
        assertContains(error, "val");
        createIndexWithSettings(secondEmpty, EMPTY_DC_FIELDS, true, 2);
    private static final String PQONLY_A = "multi_pq_a";
        assertTrue("must have source column", columns.contains("source"));
        ensureProvisioned();
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
    // ── Failure tests: type mismatch rejection ──
        ensureTypesProvisioned();
        create.setJsonEntity(  
            if (row.get(countryCol) == null) nullCountries++;
        // Index docs with different dynamic fields — dynA gets "city", dynB gets "country"
        long dc = singleCount("source=" + FT_A + "," + FT_B + " | where match(body, 'reset') | stats dc(trace) as ut");
        createParquetIndex(mismatchA, "{\"properties\":{\"score\":{\"type\":\"double\"}}}");  
        assertTrue("expected to contain [" + needle + "] but was: " + haystack, haystack.contains(needle));
    }
    private void createParquetIndex(String name, String mappingJson) throws IOException {  
        mshardProvisioned = true;  
        putAlias(TYPES_ALIAS, List.of(TYPES_A, TYPES_B));
        @SuppressWarnings("unchecked")
        assertEquals("total rows: 3 + 2 = 5", 5, rows.size());
    public void testDelegationAliasScanFanOut() throws IOException {
        bulk(mismatchA, "{\"val\":1}\n");  
    }
    public void testDelegationAliasNullFill() throws IOException {  
    private static final String EMPTY_DC_DATA = "multi_empty_dc_data";
        if (emptyDcProvisioned) return;  
        createParquetIndex(dynA, "{\"properties\":{\"id\":{\"type\":\"integer\"}}}");  
    }  
        long count = singleCount("source=" + MSHARD_ALIAS + " | stats count() as c");
    private void ensureTypesProvisioned() throws IOException {  
        if (provisioned) return;
    public void testDelegationWildcardFanOut() throws IOException {  
    // ── Parquet+Lucene indices (indexed/delegation path) ──
            if (row.get(extraCol) == null) nullExtras++;
        // Index B: integer, double, long (keyword/boolean absent → null-filled)  
        assertContains(error, "score");
    private static final String TYPES_ALIAS = "multi_types_alias";  
            Response response = client().performRequest(request);
        @SuppressWarnings("unchecked")
    private static String entityAsString(Response response) throws IOException {
        }
    }
    private static final String PQLUC_ALIAS = "multi_pqluc_alias";
    public void testMatchDelegationDistinctCount() throws IOException {
        ensureProvisioned();
    }  
        Map<String, Object> body = executePpl("source=" + MSHARD_ALIAS + " | stats sum(val) as total");
        assertEquals("3 distinct traces match timeout across both indices", 3L, dc);
        long total = ((Number) rows.get(0).get(0)).longValue();
    }
    }
    private static boolean mshardProvisioned = false;
        @SuppressWarnings("unchecked")
        ensureProvisioned();  
        assertEquals("status > 200: 500 from A + 404 from B = 2", 2L, count);
            + "{\"user_id\":4,\"phrase\":\"gamma\"}\n");
        String error = executePplExpectingFailure("source=" + mismatchAlias + " | stats count() as c");  
    }
    public void testDelegationAliasAggregation() throws IOException {
                + "\"index.pluggable.dataformat\":\"composite\","
    // ── Parquet-only: alias scan ──  
    private void ensureProvisioned() throws IOException {  
    }
        long count = singleCount("source=" + dynAlias + " | stats count() as c");
        @SuppressWarnings("unchecked")
        Request request = new Request("POST", "/" + index + "/_bulk");  
        provisioned = true;  
        "{\"properties\":{\"user_id\":{\"type\":\"long\"},\"phrase\":{\"type\":\"keyword\"}}}";
    private void createIndexWithSettings(String name, String mappingJson, boolean withLuceneSecondary, int shards) throws IOException {  
    }  
            if (row.get(sourceCol) == null) nullCount++;  
        bulk(FT_A, "{\"service\":\"checkout\",\"trace\":\"a1\",\"body\":\"exception timeout failed\"}\n"
        long count = singleCount("source=multi_pq_* | where status > 200 | stats count() as c");  
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
        Map<String, Object> response = assertOkAndParse(client().performRequest(request), "bulk " + index);
 *
        Map<String, Object> body = executePpl("source=" + PQONLY_ALIAS + " | fields message, source");
            + "{\"service\":\"frontend\",\"trace\":\"a3\",\"body\":\"all good\"}\n");
        assertEquals("count", 3L, ((Number) rows.get(0).get(0)).longValue());
        if (typesProvisioned) return;
        ensureProvisioned();
    public void testMatchDelegationCommaListCount() throws IOException {  
    // so A's shards run the filter and emit nothing while B returns data. Exercises the  
        Request create = new Request("PUT", "/" + name);
    // delegated_predicate FilterExec (the IndexedTableProvider was registered under the
            "source=" + FT_A + "," + FT_B + " | where match(body, 'timeout') | fields trace, service | head 20");  
    private static final String EMPTY_DC_FIELDS =
        String dynB = "multi_dyn_b";  
    }  
    private static final String PQLUC_A = "multi_pqluc_a";  
        putAlias(PQONLY_ALIAS, List.of(PQONLY_A, PQONLY_B));
        @SuppressWarnings("unchecked")  
        Map<String, Object> body = executePpl("source=" + PQLUC_ALIAS + " | fields message, source");
        ensureProvisioned();
import java.io.IOException;
        ensureTypesProvisioned();  
        bulk(mismatchB, "{\"score\":\"high\"}\n");  
        assertEquals(1, rows.size());  
        String mismatchB = "multi_aliasmm_b";
        createParquetIndex(TYPES_B,  
    // Regression for the bug where a delegated match() on a multi-index source kept the  
        }  
        int tagCol = columns.indexOf("tag");  
        bulk(TYPES_B, "{\"id\":3,\"score\":9.5,\"count\":100}\n{\"id\":4,\"score\":3.2,\"count\":200}\n");  
    private static final String MSHARD_A = "multi_mshard_a";
        bulk(mismatchA, "{\"score\":1.5}\n");
        createParquetIndex(mismatchB, "{\"properties\":{\"val\":{\"type\":\"keyword\"}}}");
        long count = singleCount("source=" + PQONLY_ALIAS + " | stats count() as c");
        assertTrue("must have source column", columns.contains("source"));
    }  
    }  
    public void testAliasTypeMismatchIsRejected() throws IOException {
        try {  
        assertTrue("must have extra", columns.contains("extra"));
        assertEquals("dynA rows have null country", 2, nullCountries);
    }
        bulk(dynB, "{\"id\":3,\"country\":\"US\"}\n{\"id\":4,\"country\":\"CA\"}\n");
        int extraCol = columns.indexOf("extra");
        putAlias(PQLUC_ALIAS, List.of(PQLUC_A, PQLUC_B));  
        for (String doc : ndjsonDocs.split("\n")) {
        long total = 0;
    private String executePplExpectingFailure(String ppl) throws IOException {  
 * across different query shapes: plain scan, filter, aggregation, and filter delegation.
        createParquetIndex(dynB, "{\"properties\":{\"id\":{\"type\":\"integer\"}}}");
        createIndexWithSettings(FT_A, ftMapping, true, 2);  
        actions.append("]}");
    private void assertScalarDc(String ppl, long expected) throws IOException {
    // runtime-empty path on a populated shard (distinct from the zero-doc EmptyExec guard).
            bulkBody.append("{\"index\": {}}\n").append(doc).append("\n");
        StringBuilder bulkBody = new StringBuilder();
    private static boolean provisioned = false;
        }
        assertContains(error, "incompatible field types");
    // ── Parquet-only: wildcard scan ──
            "source=multi_ft_* | where match(body, 'timeout') | stats dc(trace) as ut by service | sort -ut");  
        assertEquals("index B rows have null tag", 10, nullTags);
    // ── Full-text delegation indices: composite, multi-shard, with a text body + keyword
    private static final String MSHARD_ALIAS = "multi_mshard_alias";
            client().performRequest(create);  
            if (row.get(cityCol) == null) nullCities++;
        @SuppressWarnings("unchecked")
    public void testEmptySiblingDcWithDelegatedFilter() throws IOException {
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
    private static boolean typesProvisioned = false;
    private void bulk(String index, String ndjsonDocs) throws IOException {  
        Map<String, Object> body = executePpl(
        assertEquals("multi-shard: 10 + 10 = 20", 20L, count);  
    public void testMultiShardAggregationAcrossUnion() throws IOException {  
            + "{\"user_id\":2,\"phrase\":\"alpha\"}\n"
        for (int i = 0; i < 10; i++) {
        assertEquals("index A rows have null extra", 10, nullExtras);
        Request put = new Request("POST", "/_aliases");  
    }  
}
        int scoreCol = columns.indexOf("score");  
        assertEquals("sum(200+500+200+200+404)", 1504L, total);  
 */  
        put.setJsonEntity(actions.toString());
        ensureMshardProvisioned();  
        String dynAlias = "multi_dyn_alias";
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");  
        for (List<Object> row : rows) {  
        createCompositeIndex(PQLUC_B, "{\"properties\":{\"status\":{\"type\":\"integer\"},\"message\":{\"type\":\"keyword\"},\"source\":{\"type\":\"keyword\"}}}");  
        @SuppressWarnings("unchecked")  
        Map<String, Object> body = executePpl("source=" + TYPES_ALIAS + " | stats sum(id) as total");  
        List<String> columns = extractColumnNames(body);
        assertEquals("checkout", rows.get(0).get(1));
            "{\"properties\":{\"id\":{\"type\":\"integer\"},\"score\":{\"type\":\"double\"},\"count\":{\"type\":\"long\"}}}");
        client().performRequest(put);
        assertEquals("dynamic mapping union: 2 + 2 = 4", 4L, count);
        ensureMshardProvisioned();
        assertEquals(1, rows.size());
        String mismatchB = "multi_mismatch_b";  
        }
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
        assertEquals("index A rows have null source", 3, nullCount);
        assertTrue("expected numeric count: " + cell, cell instanceof Number);
        assertEquals(4, rows.size());
            "source=" + EMPTY_DC_EMPTY + "," + secondEmpty + " | where phrase != '' | stats dc(user_id)",  
        @SuppressWarnings("unchecked")
    private static final String MSHARD_B = "multi_mshard_b";  
        assertEquals(expected, ((Number) rows.get(0).get(0)).longValue());  
    public void testAliasFilter() throws IOException {
        assertEquals("checkout has 3 distinct timeout traces", 3L, ((Number) rows.get(0).get(0)).longValue());
import org.opensearch.client.Request;
        assertScalarDc("source=" + EMPTY_DC_ALIAS + " | where user_id + 1 > 2 | stats dc(user_id)", 3L);
        @SuppressWarnings("unchecked")
    // ── Dynamic mapping: fields added by indexing without explicit mapping ──
        @SuppressWarnings("unchecked")  
        ensureEmptyDcProvisioned();  
    private static final String TYPES_B = "multi_types_b";
        for (int i = 0; i < indices.size(); i++) {
        bulk(mismatchB, "{\"val\":\"hello\"}\n");
        Object cell = rows.get(0).get(0);  
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
        ensureProvisioned();  
        long total = ((Number) rows.get(0).get(0)).longValue();  
        bulk(PQONLY_B, "{\"status\":200,\"message\":\"world\",\"source\":\"app1\"}\n{\"status\":404,\"message\":\"not found\",\"source\":\"app2\"}\n");
        putAlias(FT_ALIAS, List.of(FT_A, FT_B));
            "{\"settings\":{\"index.pluggable.dataformat.enabled\":true,"
            fail("Expected failure but got: " + assertOkAndParse(response, ppl));
        Map<String, Object> body = executePpl("source=" + TYPES_ALIAS + " | fields id, label, active, score, count");
    public void testMatchDelegationCommaListGroupBy() throws IOException {  
        long count = singleCount("source=multi_pq_* | stats count() as c");  
        long count = singleCount("source=" + FT_A + "," + FT_B + " | where match(body, 'reset') | stats count() as c");
        assertEquals("alias fan-out: 3 + 2 = 5", 5L, count);
    public void testMatchDelegationFieldsMaterialization() throws IOException {  
    // per-shard name, not the plan's multi-index NamedTable, so the scan never bound to it
    private static final String FT_B = "multi_ft_b";
        ensureProvisioned();
        bulk(MSHARD_B, docsB.toString());
        long count = singleCount("source=" + TYPES_ALIAS + " | stats count() as c");
    public void testMatchDelegationCountAndDistinctCountGroupBy() throws IOException {
        ensureProvisioned();
        request.setOptions(request.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());  
    private static final String FT_ALIAS = "multi_ft_alias";
    // A delegated match() that trims one populated index to zero rows: 'reset' is only in B,
        ensureProvisioned();
    public void testAliasAggregation() throws IOException {
                + "\"index.composite.primary_data_format\":\"parquet\","  
    public void testMatchDelegationOneIndexTrimmedToZeroDistinctCount() throws IOException {  
        long total = ((Number) rows.get(0).get(0)).longValue();
        Map<String, Object> body = executePpl(
