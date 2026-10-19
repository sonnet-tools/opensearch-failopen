            + "  \"number_of_shards\": 1,"
                bulk.append("{\"proto\": \"TCP\", \"common\": ").append(i).append(", \"sparse_field\": 999}\n");
    }
    /** Phase 1 doc: name + age only */
        bulkIndex(docs(  
        Map<String, Object> mappings = (Map<String, Object>) indexMap.get("mappings");  
        assertMappingContains(FIELD_NAME, FIELD_AGE);  
        createTwoShardIndex(index, "{\"proto\": { \"type\": \"keyword\" }, \"common\": { \"type\": \"integer\" }}");
        health.addParameter("wait_for_status", "green");
    }
    private void assertCountIn(String index, String pplSuffix, int expected) throws IOException {  
            client().performRequest(new Request("DELETE", "/" + INDEX));  
    /** Phase 2 doc: name + age + city + points */
        }
        assertValueIn(index, "where common = 5 | fields sparse_field", "sparse_field", 999.0);
     */
    private static final String FIELD_POINTS = "points";  
            doc("leo", 38, "portland", 78, 2),
    private static final String INDEX = "dynamic_mapping_search_e2e";  
            + ", \"" + FIELD_CITY + "\": \"" + city + "\", \"" + FIELD_POINTS + "\": " + points + "}";
     * Filtered query against an index whose shards are all empty (zero docs / zero parquet files).
 * this file be licensed under the Apache-2.0 license or a
     * "No field named ...". Regression test for the indexed-path widening fix.
            } else {
    private static String doc(String name, int age) {  
        assertValue("where match(" + FIELD_NAME + ", 'frank') | stats sum(" + FIELD_POINTS + ") as total", "total", 95.0);  
    private void flush() throws Exception {  
        long actual = ((Number) rows.get(0).get(0)).longValue();  
     * The empty-shard guard derives the scan schema from the plan rather than from segments, so a
    }  
import java.util.List;  
    // ── Helpers ─────────────────────────────────────────────────────────────
        req.setOptions(req.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
     * Full end-to-end test: 3-phase ingestion with progressive schema evolution,
        // city and points now in mapping; priority still absent  
    }
        ));
        Map<String, Object> result = executePpl(ppl);
            + "},"  
 * compatible open source license.
            doc("mia", 31, "seattle", 94, 1)  
     */
        health.addParameter("timeout", "30s");  
        assertNotNull("Response missing 'datarows' for: " + ppl, rows);
            + "  \"number_of_replicas\": 0,"
            doc("grace", 22, "portland", 88),
    // ── Field name constants ────────────────────────────────────────────────
            + "  \"index.composite.primary_data_format\": \"parquet\","
        health.addParameter("timeout", "30s");  
            + "  \"index.pluggable.dataformat\": \"composite\","  
        Map<String, Object> result = executePpl(ppl);  
        req.setOptions(req.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());  
        int idx = columns.indexOf(column);
    @SuppressWarnings("unchecked")
            + "  \"number_of_replicas\": 0,"  
            + "  \"index.composite.secondary_data_formats\": \"lucene\""
            + "  \"index.pluggable.dataformat.enabled\": true,"
import org.opensearch.client.Request;
        Map<String, Object> response = assertOkAndParse(client().performRequest(req), "Bulk index " + index);
        createIndex();
    public void testCrossShardDriftFilteredQuery() throws Exception {  
     * materializes rows. The coordinator's substrait base_schema names the field (it's in the
    private void bulkIndexInto(String index, String ndjson) throws Exception {
    }
    public void testFilteredQueryOnEmptyShards() throws Exception {
            + "  \"number_of_shards\": 2,"  
        for (String field : fields) {
    }
    /**  
        assertValue("where match(" + FIELD_NAME + ", 'mia') | stats sum(" + FIELD_PRIORITY + ") as total", "total", 1.0);
            sb.append("{\"index\": {}}\n").append(doc).append("\n");  
            doc("carol", 35),
    /**  
    private void createTwoShardIndex(String index, String propertiesJson) throws Exception {
        Map<String, Object> properties = getMappingProperties();  
            client().performRequest(new Request("DELETE", "/" + index));
        bulkIndexInto(index, bulk.toString());  
        assertEquals("Expected 1 row for count query: " + ppl, 1, rows.size());
        Request health = new Request("GET", "/_cluster/health/" + index);
            doc("jack", 33, "seattle", 85)
        }
        + "segments returns empty bitsets that get incorrectly AND'd into DataFusion's candidates. "
        assertEquals("Value mismatch for: " + ppl, expected, ((Number) rows.get(0).get(idx)).doubleValue(), 0.01);  
        // ── Phase 1: Initial schema (name, age) ─────────────────────────────
        String ppl = "source = " + index + " | " + pplSuffix;  
            + "  \"index.composite.secondary_data_formats\": \"lucene\""
        assertCount("stats count() as cnt", 5);  
        assertNotNull("Response missing 'datarows' for: " + ppl, rows);
        for (String doc : documents) {
        client().performRequest(new Request("POST", "/" + INDEX + "/_flush?force=true"));
        flush();  
        assertCountIn(index, "stats count() as cnt", 0);  
 * Run with:
        String ppl = "source = " + index + " | " + pplSuffix;
        double actual = ((Number) rows.get(0).get(idx)).doubleValue();  
            }
        ));  
    private void assertMappingContains(String... fields) throws IOException {
            doc("frank", 40, "seattle", 95),
        String body = "{"
        assertEquals("Bulk indexing should have no errors", false, response.get("errors"));  
    }  
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");  
        Map<String, Object> map = assertOkAndParse(response, "Get mapping");
    private void assertCount(String pplSuffix, int expected) throws IOException {
    /**
    private void bulkIndex(String ndjson) throws Exception {  
    }
        // 10 docs across 2 shards (natural _id hashing); exactly one carries the sparse field, so
        bulkIndex(docs(  
public class DynamicMappingSearchIT extends AnalyticsRestTestCase {
        // Sanity: the sparse field is dynamically mapped and present on exactly one doc.
     */  
        assertEquals("filtered query on an empty index should return zero rows", 0, rows.size());
/**  
        Map<String, Object> result = executePpl(ppl);
            + ", \"" + FIELD_PRIORITY + "\": " + priority + "}";
        try {
        assertCount("stats count() as cnt", 10);
        Request health = new Request("GET", "/_cluster/health/" + INDEX);
            + "}"
 * are correctly indexed into a composite parquet index AND are searchable via PPL
        Map<String, Object> result = executePpl(ppl);
        assertEquals("Count mismatch for: " + ppl, expected, actual);
        // ── Phase 3: Another new field (priority) ───────────────────────────
        return (Map<String, Object>) mappings.get("properties");
        assertEquals("Expected 1 row for count query: " + ppl, 1, rows.size());  
        assertMappingNotContains(FIELD_CITY, FIELD_POINTS, FIELD_PRIORITY);
        Request req = new Request("PUT", "/" + index);  
        assertValue("stats sum(" + FIELD_POINTS + ") as total", "total", 693.0);
        @SuppressWarnings("unchecked")
        String ppl = "source = " + INDEX + " | " + pplSuffix;
    }
        req.setJsonEntity(body);
        @SuppressWarnings("unchecked")
        assertMappingContains(FIELD_NAME, FIELD_AGE, FIELD_CITY, FIELD_POINTS, FIELD_PRIORITY);
            assertTrue("Mapping should contain field '" + field + "'", properties.containsKey(field));
     * verifying search works correctly at each stage via both vanilla and indexed paths.
 * through both the vanilla scan path and the indexed executor (filter delegation) path.
            + "  }"
    }
        for (String field : fields) {  
            + "\"settings\": {"
            + "  \"index.pluggable.dataformat.enabled\": true,"
        assertCount("where match(" + FIELD_NAME + ", 'alice') | stats count() as cnt", 1);  
 *
        // it lands in only one shard's parquet. The dynamic field enters the merged index mapping.
    /** single-value assertion against an arbitrary index. */
    }
            + "\"settings\": {"
        + "delegation for dynamically-mapped fields.")  
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
        assertTrue("Column '" + column + "' not found in: " + columns, idx >= 0);
/*  
    private static final String FIELD_CITY = "city";
            + "\"mappings\": {"  
        assertCount("where " + FIELD_CITY + " = 'seattle' | stats count() as cnt", 3);
        req.addParameter("refresh", "true");  
     * (hence in only one shard's parquet segments) must not break a filtered query that  
        client().performRequest(health);
        // Dynamic fields should NOT be in mapping yet
            + "    \"" + FIELD_NAME + "\": { \"type\": \"keyword\" },"
    private void createIndex() throws Exception {
 * Validates that documents with dynamically added fields (not in the original mapping)  
        Map<String, Object> response = assertOkAndParse(client().performRequest(req), "Create index");
        Response response = client().performRequest(new Request("GET", "/" + INDEX + "/_mapping"));  
        return "{\"" + FIELD_NAME + "\": \"" + name + "\", \"" + FIELD_AGE + "\": " + age  
        String index = "cross_shard_drift_e2e";
        @SuppressWarnings("unchecked")  
            + "}";
        assertNotNull("drift query returned no datarows", rows);
            assertFalse("Mapping should NOT contain field '" + field + "' yet", properties.containsKey(field));
        assertValue("where match(" + FIELD_NAME + ", 'hank') | stats sum(" + FIELD_POINTS + ") as total", "total", 72.0);
        String index = "empty_shard_filter_e2e";  
}
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
    }
        req.setJsonEntity(ndjson);
        // The drift trigger: a filtered query that materializes rows (indexed-executor path).
        assertMappingContains(FIELD_CITY, FIELD_POINTS);
     * row-materializing filtered query must return zero rows cleanly rather than erroring.  
        }
            doc("bob", 25),
        assertCount("stats count() as cnt", 13);
        Map<String, Object> indexMap = (Map<String, Object>) map.get(INDEX);
import org.opensearch.client.Response;  
        StringBuilder bulk = new StringBuilder();  
    private static final String FIELD_AGE = "age";
        Map<String, Object> result = executePpl("source = " + index + " | where proto = 'TCP' | fields common | head 2");  
            doc("dave", 28),  
            doc("hank", 45, "seattle", 72),  
    }
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
import java.util.Map;
        assertNotNull("Response missing 'rows' for: " + ppl, rows);
    private static final String FIELD_PRIORITY = "priority";
        assertEquals(1, rows.size());  
        Map<String, Object> properties = getMappingProperties();
                bulk.append("{\"proto\": \"TCP\", \"common\": ").append(i).append("}\n");  
        List<String> columns = extractColumnNames(result);
 * <p>
        List<String> columns = extractColumnNames(result);
        assertEquals("Bulk indexing should have no errors", false, response.get("errors"));
     * base_schema and null-fill the absent column — otherwise shards lacking it fail with  
        assertValue("stats sum(" + FIELD_POINTS + ") as total", "total", 431.0);
        Map<String, Object> result = executePpl("source = " + index + " | where proto = 'TCP' | fields common | sort common");
        + "Either propagate per-segment field-presence as a 'skip' signal or disable perf "
    public void testSearchOnDynamicallyAddedFields() throws Exception {
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
    private static final String FIELD_NAME = "name";  
        // All fields now present in mapping
        assertTrue("Column '" + column + "' not found in: " + columns, idx >= 0);
    private void assertMappingNotContains(String... fields) throws IOException {
            + "  \"index.composite.primary_data_format\": \"parquet\","  
 */  
        Request req = new Request("POST", "/" + INDEX + "/_bulk");
        ));
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");  
        // ── Phase 2: Dynamic fields (city, points) ──────────────────────────
        for (int i = 1; i <= 10; i++) {
            + "},"
        StringBuilder sb = new StringBuilder();
        // ── Indexed executor path (filter delegation via match()) ────────────
            doc("eve", 32)
        assertCountIn(index, "where isnull(sparse_field) | stats count() as cnt", 9);  
        return sb.toString();
        assertEquals(true, response.get("acknowledged"));
            + "    \"" + FIELD_AGE + "\": { \"type\": \"integer\" }"  
        assertCountIn(index, "where isnotnull(sparse_field) | stats count() as cnt", 1);  
 * <p>  
        @SuppressWarnings("unchecked")
            + "}";  
    private void assertValueIn(String index, String pplSuffix, String column, double expected) throws IOException {
     * merged index mapping), so the indexed-executor scan path must widen each shard's schema to
        }  
    /** Phase 3 doc: name + age + city + points + priority */
            + ", \"" + FIELD_CITY + "\": \"" + city + "\", \"" + FIELD_POINTS + "\": " + points
        assertCount("where " + FIELD_POINTS + " >= 90 | stats count() as cnt", 2);  
        assertCount("where isnull(" + FIELD_CITY + ") | stats count() as cnt", 5);
        assertEquals("Value mismatch for: " + ppl, expected, actual, 0.01);
        @SuppressWarnings("unchecked")  
    }
import java.io.IOException;
    private Map<String, Object> getMappingProperties() throws IOException {
 */  
    private static String docs(String... documents) {  
        int idx = columns.indexOf(column);
            + "  \"properties\": {"
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
        try {  
        Request req = new Request("POST", "/" + index + "/_bulk");  
        // Before the fix this failed on the shard lacking sparse_field with "No field named".  
            + "\"mappings\": { \"properties\": " + propertiesJson + " }"
        assertEquals("filtered query over a drifted multi-shard index should return all matching rows", 10, rows.size());
        assertEquals(1, rows.size());  
        flush();
    }
            doc("iris", 29, "portland", 91),
        assertCount("where " + FIELD_CITY + " = 'seattle' | stats count() as cnt", 5);
        flush();
            doc("alice", 30),  
        } catch (Exception ignored) {}
        createTwoShardIndex(index, "{\"proto\": { \"type\": \"keyword\" }, \"common\": { \"type\": \"integer\" }}");
        // The drifted column reads back as its real value where present, NULL where absent.
    // ── Document builders ───────────────────────────────────────────────────  
        } catch (Exception ignored) {}
        String body = "{"  
        @SuppressWarnings("unchecked")  
    /** Combine docs into bulk NDJSON */
        + "FieldInfos differ across segments, and a query against a field absent from older "  
 * The OpenSearch Contributors require contributions made to  
        @SuppressWarnings("unchecked")
        return "{\"" + FIELD_NAME + "\": \"" + name + "\", \"" + FIELD_AGE + "\": " + age + "}";
    private static String doc(String name, int age, String city, int points, int priority) {
        assertMappingNotContains(FIELD_PRIORITY);
package org.opensearch.analytics.qa;
        assertNotNull("empty-shard query returned no datarows", rows);  
 * SPDX-License-Identifier: Apache-2.0
 * ./gradlew :sandbox:qa:analytics-engine-rest:integTest --tests "*.DynamicMappingSearchIT" -Dsandbox.enabled=true
        assertCount("where match(" + FIELD_CITY + ", 'seattle') | stats count() as cnt", 5);
            bulk.append("{\"index\": {}}\n");
            if (i == 5) {  
        String ppl = "source = " + INDEX + " | " + pplSuffix;  
    }
        health.addParameter("wait_for_status", "green");
    }
        assertNotNull("Response missing 'rows' for: " + ppl, rows);
    private void assertValue(String pplSuffix, String column, double expected) throws IOException {
        assertCount("where match(" + FIELD_NAME + ", 'kate') | stats count() as cnt", 1);
        Request req = new Request("PUT", "/" + INDEX);
        assertCount("where isnotnull(" + FIELD_PRIORITY + ") | stats count() as cnt", 3);
    /** Bulk-index NDJSON into the named index with refresh. */
    }  
    /** Creates a 2-shard composite/parquet index (lucene secondary) with the given mapping properties. */
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/pull/21701 — performance "
        bulkIndex(docs(
        req.setJsonEntity(ndjson);
        assertCount("where " + FIELD_AGE + " > 30 | stats count() as cnt", 5);  
            doc("kate", 27, "seattle", 90, 1),
     * Cross-shard schema drift: a sparse dynamically-mapped field that exists in only one doc
 * End-to-end integration test for dynamic mapping with search verification.
        req.setJsonEntity(body);  
        client().performRequest(health);
    /** count-query assertion against an arbitrary index. */
        Map<String, Object> response = assertOkAndParse(client().performRequest(req), "Bulk index");
        req.addParameter("refresh", "true");
        return "{\"" + FIELD_NAME + "\": \"" + name + "\", \"" + FIELD_AGE + "\": " + age  
    }  
        + "filter delegation needs handling for dynamically added fields. Lucene's per-segment "
        assertCount("where " + FIELD_PRIORITY + " = 1 | stats count() as cnt", 2);  
        assertEquals("Count mismatch for: " + ppl, expected, ((Number) rows.get(0).get(0)).longValue());
    private static String doc(String name, int age, String city, int points) {
        assertEquals(true, assertOkAndParse(client().performRequest(req), "Create index " + index).get("acknowledged"));
            + "  \"index.pluggable.dataformat\": \"composite\","
