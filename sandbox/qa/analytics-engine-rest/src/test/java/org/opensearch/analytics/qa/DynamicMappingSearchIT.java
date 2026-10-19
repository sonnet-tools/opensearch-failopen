    // ── Helpers ─────────────────────────────────────────────────────────────
        health.addParameter("wait_for_status", "green");
        @SuppressWarnings("unchecked")
            + "  \"index.pluggable.dataformat\": \"composite\","
        String index = "empty_shard_filter_e2e";
        Map<String, Object> indexMap = (Map<String, Object>) map.get(INDEX);
        for (int i = 1; i <= 10; i++) {
        String body = "{"
    private void assertValueIn(String index, String pplSuffix, String column, double expected) throws IOException {
 * The OpenSearch Contributors require contributions made to
    /** single-value assertion against an arbitrary index. */
        assertValue("stats sum(" + FIELD_POINTS + ") as total", "total", 431.0);
 * <p>
    private static String doc(String name, int age, String city, int points) {
    }
        Map<String, Object> response = assertOkAndParse(client().performRequest(req), "Create index");
        createIndex();
    }
        assertCount("where " + FIELD_CITY + " = 'seattle' | stats count() as cnt", 5);
    }
        long actual = ((Number) rows.get(0).get(0)).longValue();
            doc("leo", 38, "portland", 78, 2),
            doc("kate", 27, "seattle", 90, 1),
        bulkIndexInto(index, bulk.toString());
    private void flush() throws Exception {
        String ppl = "source = " + index + " | " + pplSuffix;
    private static String docs(String... documents) {
        // ── Phase 3: Another new field (priority) ───────────────────────────
    }
        // 10 docs across 2 shards (natural _id hashing); exactly one carries the sparse field, so
            + "}";
     */
            doc("carol", 35),
            + ", \"" + FIELD_PRIORITY + "\": " + priority + "}";
        ));
        Map<String, Object> result = executePpl("source = " + index + " | where proto = 'TCP' | fields common | head 2");
        @SuppressWarnings("unchecked")
            if (i == 5) {
        int idx = columns.indexOf(column);
    /** Bulk-index NDJSON into the named index with refresh. */
            doc("bob", 25),
        assertCount("where isnull(" + FIELD_CITY + ") | stats count() as cnt", 5);
public class DynamicMappingSearchIT extends AnalyticsRestTestCase {
    @SuppressWarnings("unchecked")
        assertTrue("Column '" + column + "' not found in: " + columns, idx >= 0);
     * (hence in only one shard's parquet segments) must not break a filtered query that
            + ", \"" + FIELD_CITY + "\": \"" + city + "\", \"" + FIELD_POINTS + "\": " + points
        assertCount("where match(" + FIELD_NAME + ", 'alice') | stats count() as cnt", 1);
    }
        assertCount("where " + FIELD_AGE + " > 30 | stats count() as cnt", 5);
        // The drifted column reads back as its real value where present, NULL where absent.
    }
            + "    \"" + FIELD_AGE + "\": { \"type\": \"integer\" }"
import java.util.Map;
        StringBuilder bulk = new StringBuilder();
            + ", \"" + FIELD_CITY + "\": \"" + city + "\", \"" + FIELD_POINTS + "\": " + points + "}";
        StringBuilder sb = new StringBuilder();
import org.opensearch.client.Response;
     * "No field named ...". Regression test for the indexed-path widening fix.
            client().performRequest(new Request("DELETE", "/" + index));
import java.io.IOException;
    public void testFilteredQueryOnEmptyShards() throws Exception {
        for (String field : fields) {
     * materializes rows. The coordinator's substrait base_schema names the field (it's in the
        Request req = new Request("POST", "/" + index + "/_bulk");
    }
        Map<String, Object> result = executePpl("source = " + index + " | where proto = 'TCP' | fields common | sort common");
        assertCountIn(index, "where isnull(sparse_field) | stats count() as cnt", 9);
        assertNotNull("Response missing 'datarows' for: " + ppl, rows);
        assertValue("stats sum(" + FIELD_POINTS + ") as total", "total", 693.0);
        assertMappingNotContains(FIELD_CITY, FIELD_POINTS, FIELD_PRIORITY);
 * Run with:
        assertNotNull("Response missing 'rows' for: " + ppl, rows);
        assertMappingContains(FIELD_CITY, FIELD_POINTS);
        req.setJsonEntity(body);
            doc("dave", 28),
            + "}";
     * merged index mapping), so the indexed-executor scan path must widen each shard's schema to
        Map<String, Object> result = executePpl(ppl);
     * row-materializing filtered query must return zero rows cleanly rather than erroring.
        // Dynamic fields should NOT be in mapping yet
            sb.append("{\"index\": {}}\n").append(doc).append("\n");
            assertTrue("Mapping should contain field '" + field + "'", properties.containsKey(field));
    private void bulkIndexInto(String index, String ndjson) throws Exception {
    }
        // Before the fix this failed on the shard lacking sparse_field with "No field named".
            doc("alice", 30),
        client().performRequest(new Request("POST", "/" + INDEX + "/_flush?force=true"));
        assertCount("where " + FIELD_CITY + " = 'seattle' | stats count() as cnt", 3);
            } else {
        assertEquals("Bulk indexing should have no errors", false, response.get("errors"));
            + "},"
            + "  }"
        assertCount("where " + FIELD_PRIORITY + " = 1 | stats count() as cnt", 2);
        int idx = columns.indexOf(column);
            + "  \"index.composite.primary_data_format\": \"parquet\","
     */
        return "{\"" + FIELD_NAME + "\": \"" + name + "\", \"" + FIELD_AGE + "\": " + age
        Map<String, Object> properties = getMappingProperties();
            + "\"mappings\": { \"properties\": " + propertiesJson + " }"
        assertCount("where match(" + FIELD_NAME + ", 'kate') | stats count() as cnt", 1);
        return "{\"" + FIELD_NAME + "\": \"" + name + "\", \"" + FIELD_AGE + "\": " + age
            doc("hank", 45, "seattle", 72),
        Request req = new Request("POST", "/" + INDEX + "/_bulk");
        bulkIndex(docs(
        ));
        assertNotNull("Response missing 'datarows' for: " + ppl, rows);
/**
        createTwoShardIndex(index, "{\"proto\": { \"type\": \"keyword\" }, \"common\": { \"type\": \"integer\" }}");
        }
        assertMappingContains(FIELD_NAME, FIELD_AGE, FIELD_CITY, FIELD_POINTS, FIELD_PRIORITY);
}
    private static String doc(String name, int age) {
        assertCount("where match(" + FIELD_CITY + ", 'seattle') | stats count() as cnt", 5);
    /** Phase 3 doc: name + age + city + points + priority */
import java.util.List;
    private void assertMappingNotContains(String... fields) throws IOException {
            doc("grace", 22, "portland", 88),
    private void bulkIndex(String ndjson) throws Exception {
            + "  \"number_of_replicas\": 0,"
    }
        @SuppressWarnings("unchecked")
    private void assertCountIn(String index, String pplSuffix, int expected) throws IOException {
        assertEquals("Value mismatch for: " + ppl, expected, actual, 0.01);
        Response response = client().performRequest(new Request("GET", "/" + INDEX + "/_mapping"));
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/pull/21701 — performance "
        assertEquals("Count mismatch for: " + ppl, expected, actual);
    private void assertCount(String pplSuffix, int expected) throws IOException {
        + "FieldInfos differ across segments, and a query against a field absent from older "
    }
        // All fields now present in mapping
        // ── Phase 2: Dynamic fields (city, points) ──────────────────────────
        // it lands in only one shard's parquet. The dynamic field enters the merged index mapping.
            bulk.append("{\"index\": {}}\n");
        double actual = ((Number) rows.get(0).get(idx)).doubleValue();
        assertValueIn(index, "where common = 5 | fields sparse_field", "sparse_field", 999.0);
            + "\"settings\": {"
        assertNotNull("empty-shard query returned no datarows", rows);
        req.setOptions(req.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
            + "  \"index.composite.secondary_data_formats\": \"lucene\""
            }
        String ppl = "source = " + INDEX + " | " + pplSuffix;
        req.setOptions(req.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
            + "}"
        // city and points now in mapping; priority still absent
    private void assertMappingContains(String... fields) throws IOException {
    }
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
 * compatible open source license.
            doc("frank", 40, "seattle", 95),
        assertEquals(true, response.get("acknowledged"));
        for (String field : fields) {
        Map<String, Object> properties = getMappingProperties();
            + "  \"number_of_replicas\": 0,"
        String ppl = "source = " + INDEX + " | " + pplSuffix;
        assertTrue("Column '" + column + "' not found in: " + columns, idx >= 0);
            + "  \"index.composite.secondary_data_formats\": \"lucene\""
            + "  \"index.pluggable.dataformat.enabled\": true,"
        } catch (Exception ignored) {}
        for (String doc : documents) {
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
        assertEquals(1, rows.size());
        Request req = new Request("PUT", "/" + index);
            + "  \"index.pluggable.dataformat.enabled\": true,"
            + "    \"" + FIELD_NAME + "\": { \"type\": \"keyword\" },"
        Map<String, Object> mappings = (Map<String, Object>) indexMap.get("mappings");
        health.addParameter("timeout", "30s");
 *
        client().performRequest(health);
 * through both the vanilla scan path and the indexed executor (filter delegation) path.
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
            + "  \"properties\": {"
    }
     */
        }
 */
    private static final String FIELD_POINTS = "points";
    }
        // ── Indexed executor path (filter delegation via match()) ────────────
    }
        @SuppressWarnings("unchecked")
    private static String doc(String name, int age, String city, int points, int priority) {
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
        List<String> columns = extractColumnNames(result);
 * ./gradlew :sandbox:qa:analytics-engine-rest:integTest --tests "*.DynamicMappingSearchIT" -Dsandbox.enabled=true
    }
    public void testSearchOnDynamicallyAddedFields() throws Exception {
        assertNotNull("drift query returned no datarows", rows);
    }
    }
        ));
     * Cross-shard schema drift: a sparse dynamically-mapped field that exists in only one doc
    /** count-query assertion against an arbitrary index. */
        assertCount("where " + FIELD_POINTS + " >= 90 | stats count() as cnt", 2);
        @SuppressWarnings("unchecked")
        + "segments returns empty bitsets that get incorrectly AND'd into DataFusion's candidates. "
        flush();
        assertValue("where match(" + FIELD_NAME + ", 'hank') | stats sum(" + FIELD_POINTS + ") as total", "total", 72.0);
import org.opensearch.client.Request;
    /** Creates a 2-shard composite/parquet index (lucene secondary) with the given mapping properties. */
        Request req = new Request("PUT", "/" + INDEX);
 * End-to-end integration test for dynamic mapping with search verification.
        assertCount("stats count() as cnt", 10);
    private void createIndex() throws Exception {
        assertEquals("Value mismatch for: " + ppl, expected, ((Number) rows.get(0).get(idx)).doubleValue(), 0.01);
     * Filtered query against an index whose shards are all empty (zero docs / zero parquet files).
        try {
            doc("iris", 29, "portland", 91),
            doc("jack", 33, "seattle", 85)
        flush();
        // ── Phase 1: Initial schema (name, age) ─────────────────────────────
     * base_schema and null-fill the absent column — otherwise shards lacking it fail with
 * Validates that documents with dynamically added fields (not in the original mapping)
 * <p>
        Map<String, Object> result = executePpl(ppl);
    private void createTwoShardIndex(String index, String propertiesJson) throws Exception {
            doc("eve", 32)
        createTwoShardIndex(index, "{\"proto\": { \"type\": \"keyword\" }, \"common\": { \"type\": \"integer\" }}");
        // Sanity: the sparse field is dynamically mapped and present on exactly one doc.
        + "filter delegation needs handling for dynamically added fields. Lucene's per-segment "
        assertMappingContains(FIELD_NAME, FIELD_AGE);
    /** Combine docs into bulk NDJSON */
                bulk.append("{\"proto\": \"TCP\", \"common\": ").append(i).append("}\n");
    }
            + "  \"index.pluggable.dataformat\": \"composite\","
        Request health = new Request("GET", "/_cluster/health/" + INDEX);
    private static final String FIELD_PRIORITY = "priority";
package org.opensearch.analytics.qa;
        Map<String, Object> map = assertOkAndParse(response, "Get mapping");
     * verifying search works correctly at each stage via both vanilla and indexed paths.
        + "Either propagate per-segment field-presence as a 'skip' signal or disable perf "
        health.addParameter("timeout", "30s");
    private Map<String, Object> getMappingProperties() throws IOException {
        try {
            + "\"settings\": {"
    /** Phase 2 doc: name + age + city + points */
            + "},"
    private static final String FIELD_AGE = "age";
    private static final String INDEX = "dynamic_mapping_search_e2e";
        } catch (Exception ignored) {}
                bulk.append("{\"proto\": \"TCP\", \"common\": ").append(i).append(", \"sparse_field\": 999}\n");
    /**
        assertMappingNotContains(FIELD_PRIORITY);
        List<String> columns = extractColumnNames(result);
    private void assertValue(String pplSuffix, String column, double expected) throws IOException {
        assertEquals("Count mismatch for: " + ppl, expected, ((Number) rows.get(0).get(0)).longValue());
        }
        assertNotNull("Response missing 'rows' for: " + ppl, rows);
        assertEquals(1, rows.size());
            + "  \"number_of_shards\": 2,"
     * Full end-to-end test: 3-phase ingestion with progressive schema evolution,
        req.addParameter("refresh", "true");
 * this file be licensed under the Apache-2.0 license or a
        + "delegation for dynamically-mapped fields.")
        req.setJsonEntity(ndjson);
        return "{\"" + FIELD_NAME + "\": \"" + name + "\", \"" + FIELD_AGE + "\": " + age + "}";
        Map<String, Object> result = executePpl(ppl);
    }
        }
    // ── Field name constants ────────────────────────────────────────────────
        return (Map<String, Object>) mappings.get("properties");
        assertValue("where match(" + FIELD_NAME + ", 'frank') | stats sum(" + FIELD_POINTS + ") as total", "total", 95.0);
        @SuppressWarnings("unchecked")
        Request health = new Request("GET", "/_cluster/health/" + index);
        assertEquals(true, assertOkAndParse(client().performRequest(req), "Create index " + index).get("acknowledged"));
     * The empty-shard guard derives the scan schema from the plan rather than from segments, so a
/*
        // The drift trigger: a filtered query that materializes rows (indexed-executor path).
        String ppl = "source = " + index + " | " + pplSuffix;
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
        @SuppressWarnings("unchecked")
        assertEquals("Bulk indexing should have no errors", false, response.get("errors"));
 * are correctly indexed into a composite parquet index AND are searchable via PPL
            assertFalse("Mapping should NOT contain field '" + field + "' yet", properties.containsKey(field));
        bulkIndex(docs(
 */
    /** Phase 1 doc: name + age only */
            + "  \"number_of_shards\": 1,"
    public void testCrossShardDriftFilteredQuery() throws Exception {
        flush();
        assertCount("stats count() as cnt", 13);
        assertEquals("Expected 1 row for count query: " + ppl, 1, rows.size());
        assertEquals("filtered query over a drifted multi-shard index should return all matching rows", 10, rows.size());
        req.setJsonEntity(body);
            client().performRequest(new Request("DELETE", "/" + INDEX));
            + "  \"index.composite.primary_data_format\": \"parquet\","
        assertCountIn(index, "where isnotnull(sparse_field) | stats count() as cnt", 1);
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
    /**
        req.addParameter("refresh", "true");
    private static final String FIELD_CITY = "city";
        assertCountIn(index, "stats count() as cnt", 0);
    /**
        Map<String, Object> result = executePpl(ppl);
        assertCount("where isnotnull(" + FIELD_PRIORITY + ") | stats count() as cnt", 3);
            doc("mia", 31, "seattle", 94, 1)
        assertValue("where match(" + FIELD_NAME + ", 'mia') | stats sum(" + FIELD_PRIORITY + ") as total", "total", 1.0);
 * SPDX-License-Identifier: Apache-2.0
    // ── Document builders ───────────────────────────────────────────────────
        assertEquals("Expected 1 row for count query: " + ppl, 1, rows.size());
        req.setJsonEntity(ndjson);
        String body = "{"
        bulkIndex(docs(
        assertEquals("filtered query on an empty index should return zero rows", 0, rows.size());
            + "\"mappings\": {"
        health.addParameter("wait_for_status", "green");
        assertCount("stats count() as cnt", 5);
    private static final String FIELD_NAME = "name";
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
        return sb.toString();
        Map<String, Object> response = assertOkAndParse(client().performRequest(req), "Bulk index " + index);
        String index = "cross_shard_drift_e2e";
        Map<String, Object> response = assertOkAndParse(client().performRequest(req), "Bulk index");
        client().performRequest(health);
