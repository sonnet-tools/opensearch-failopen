        assertTrue("expected to contain [" + needle + "] but was: " + haystack, haystack.contains(needle));  
            {"@timestamp":"2026-05-01T00:00:00Z","v":1,"category":"alpha"}
            {"@timestamp":"2026-05-01T00:00:01Z","v":2}  
            """);  
    }
                + "\"v\":{\"type\":\"long\"},"
     * Comma-separated source expression mixing a data stream with a plain index:  
        ensureCleanup();
            {"@timestamp":"2026-05-01T00:00:00Z","v":1}
import org.opensearch.client.ResponseException;  
            client().performRequest(new Request("DELETE", "/_index_template/" + TEMPLATE));
     * If a backing index's mapping has been manually amended such that a field type conflicts
                + "\"index.pluggable.dataformat.enabled\":true,"
        bulkIntoStream(STREAM, """  
        );  
        gen1Map.setJsonEntity("{\"properties\":{\"divergent\":{\"type\":\"long\"}}}");
        createPlain.setJsonEntity(
            return ""; // unreachable  
        request.addParameter("refresh", "true");  
     */
        // add to gen 1. This still trips validateSchemaCompatibility because the field appears in
            if (doc.isBlank()) continue;  
        long count = singleCount("source=" + STREAM + "," + plain + " | stats count() as c");
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
    /**  
        assertEquals("wildcard matching a data stream must fan out across all open backings", 3L, count);
        createDataStreamTemplate();
 * still applies in case a backing's mapping was manually amended after rollover.
        createDataStreamTemplate();
        client().performRequest(gen2Map);
                + "}}"
                + "\"index.composite.secondary_data_formats\":\"lucene\","
        bulkPlain.addParameter("refresh", "true");
     * the latest generation's rows.
            {"@timestamp":"2026-05-02T00:00:00Z","v":3}  
        createDataStreamTemplate();
     * creates a second. The planner must fan out across both — a missing fan-out would only see
        ensureCleanup();
        StringBuilder bulk = new StringBuilder();
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
            {"@timestamp":"2026-05-02T00:00:02Z","v":6,"category":"beta"}
        try {  
    private static final String TEMPLATE = "logs_ds_template";  
    private void bulkIntoStream(String name, String ndjsonDocs) throws IOException {  
    public void testDataStreamRejectsConflictingBackingMappings() throws IOException {  
        // Close the older generation; only generation 2's rows (3 docs) should be visible.
    }  
        createDataStreamTemplateWithCategory();
    private void ensureCleanup() throws IOException {
    public void testDataStreamMatchedByWildcardFansOut() throws IOException {  
                + "}}"
     * with another generation, planning must fail at resolution with a schema-incompatible error.  
     * the coordinator-reduce stage for data streams (different code path than single-column  
        rolloverStream(STREAM);
                + "\"index.pluggable.dataformat.enabled\":true,"
 */  
            "{\"index_patterns\":[\"" + STREAM + "\"],"
        bulkIntoStream(STREAM, """
package org.opensearch.analytics.qa;
        bulkPlain.setOptions(bulkPlain.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
    private static final String STREAM = "logs_ds";
    }
                + "\"settings\":{"
                + "\"index.composite.secondary_data_formats\":\"lucene\","
        assertTrue("expected numeric: " + cell, cell instanceof Number);
                + "\"mappings\":{\"properties\":{"  
            "{\"index\":{}}\n{\"@timestamp\":\"2026-05-01T00:00:00Z\",\"v\":10}\n"  
        Request rollover = new Request("POST", "/" + name + "/_rollover");
        rolloverStream(STREAM);  
    }
                + "\"index.number_of_replicas\":0"
 */
        @SuppressWarnings("unchecked")  
        assertEquals("closed gen-1 backing excluded: only gen-2's 3 rows", 3L, count);
    }  
     * the row count is the sum of both sides.  
    }
    }
    public void testDataStreamFansOutAcrossRolledOverBackings() throws IOException {
        Request request = new Request("POST", "/_plugins/_ppl");
            client().performRequest(new Request("DELETE", "/_data_stream/" + STREAM));
        } catch (ResponseException ignored) {}
    /** Template variant that also maps a {@code category} keyword field for group-by tests. */  
        try {  
            "/.ds-" + STREAM + "-000002/_mapping?write_index_only=false"
    /**
        client().performRequest(put);
    private void createDataStreamTemplate() throws IOException {
     */
    /**
        request.setOptions(request.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
        @SuppressWarnings("unchecked")
        long sum = singleLongAgg("source=" + STREAM + " | stats sum(v) as s");  
        // DELETE first to keep this test self-contained across re-runs.
        );
        Object cell = rows.get(0).get(0);  
        createDataStreamTemplate();  
     */  
            """);
     * required timestamp field and {@code v} as a long. Backings inherit the composite/parquet
        ensureCleanup();
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");  
     * Creates an index template that backs the data stream. Maps {@code @timestamp} as the  
                + "\"index.number_of_shards\":1,"  
        // Sanity: aggregation over the v column also fans out. Sum is 1+2+3+4 = 10.
    }
            }
        rolloverStream(STREAM);
        );  
            {"@timestamp":"2026-05-01T00:00:01Z","v":2}
        client().performRequest(createPlain);  
                + "\"index.composite.primary_data_format\":\"parquet\","
/*  
        Request put = new Request("PUT", "/_index_template/" + TEMPLATE);
    // ── query helpers (mirrored from AliasIT) ────────────────────────────  
    /**
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.client.Request;
     * {@code source = logs_ds,plain_index}. Comma splitting routes through the resolver path,
                return new String(is.readAllBytes(), java.nio.charset.StandardCharsets.UTF_8);  
        assertContains(error, "incompatible field types");
        );
        client().performRequest(rollover);  
        rolloverStream(STREAM);
        );  
        } catch (ResponseException ignored) {}
        assertEquals("single row expected: " + ppl, 1, rows.size());
        ensureCleanup();  
/**  
        // The update-mapping API on a backing index will reject incompatible adds, so we drift on
        bulkIntoStream(STREAM, """
            {"@timestamp":"2026-05-01T00:00:00Z","v":1}
        assertEquals("bulk into " + name + " had errors", false, response.get("errors"));  
            {"@timestamp":"2026-05-01T00:00:01Z","v":2,"category":"alpha"}  
    private long singleLongAgg(String ppl) throws IOException {  
     * — a regression that surfaces the closed backing into shard routing would fail at search.
     * The schema's literal-name short-circuit only fires for exact matches, so this exercises the
        assertEquals("sum must aggregate across backings", 10L, sum);
        client().performRequest(put);  
        return ((Number) cell).longValue();
        assertEquals(3L, ((Number) rows.get(1).get(0)).longValue());
            {"@timestamp":"2026-05-01T00:00:00Z","v":1}
        assertEquals("alpha", rows.get(0).get(1));
 * End-to-end IT for data stream support on the analytics-engine route. A data stream is a single
    private String executePplExpectingFailure(String ppl) throws IOException {  
            {"@timestamp":"2026-05-01T00:00:01Z","v":2}
    private void rolloverStream(String name) throws IOException {
        assertEquals("beta", rows.get(1).get(1));
    }  
        // Diverge generation 2's mapping: PUT a `v` field as keyword (template says long).
            {"@timestamp":"2026-05-02T00:00:01Z","v":4}
     * Wildcard expression that matches a data stream name (e.g. {@code logs*} → {@code logs_ds}).
        assertEquals("data stream must fan out across both backings: 2 + 2", 4L, count);  
     * lenientExpandOpen behavior). Asserts the query returns only the open generation's rows  
    /** Removes any leftover data stream + template from a prior run. */
        bulkIntoStream(STREAM, """
import java.io.IOException;
            """);
        } catch (ResponseException re) {
        Map<String, Object> response = assertOkAndParse(client().performRequest(request), "bulk " + name);
                + "}}"  
        request.setJsonEntity(bulk.toString());
        long count = singleCount("source=" + STREAM + " | stats count() as c");
        bulkIntoStream(STREAM, """  
                + "\"template\":{"  
            """);  
            {"@timestamp":"2026-05-01T00:00:00Z","v":1}  
        // multiple backings with divergent types.
                + "\"index.pluggable.dataformat\":\"composite\","  
            {"@timestamp":"2026-05-01T00:00:01Z","v":2}
            bulk.append("{\"create\":{\"_index\":\"").append(name).append("\"}}\n");
                + "\"category\":{\"type\":\"keyword\"}"  
    }
     */
    }  
        Request request = new Request("POST", "/_bulk");
     * IndexResolution paths correctly expand hidden backings for data stream patterns.
                + "\"@timestamp\":{\"type\":\"date\"},"
     * Same contract as alias-spanning-mismatched-mappings, just exercised through a data stream.
     * Multi-bucket group-by spanning rollover boundaries: each generation has rows tagged with a
    }
    /**  
     * dataformat settings so the scan goes through the analytics-engine native path.
        bulkIntoStream(STREAM, """
 * logical name fronting a chain of rolled-over backing indices ({@code .ds-<name>-<date>-<gen>}).
        for (String doc : ndjsonDocs.split("\n")) {
        return singleLongAgg(ppl);  
            try (var is = re.getResponse().getEntity().getContent()) {
     * which must include the data stream's hidden backings — not just the plain index. Asserts
        Map<String, Object> body = executePpl("source=" + STREAM + " | stats count() as c by category | sort category");
    }
            bulk.append(doc).append("\n");
     * A closed older-generation backing must be silently filtered (matching the alias path's
    }
            client().performRequest(new Request("DELETE", "/" + plain));
            """);  
        assertContains(error, "divergent");  
        }  
            {"@timestamp":"2026-05-01T00:00:02Z","v":3,"category":"beta"}
                + "\"settings\":{"
        // After sort by category: alpha (3), beta (3).
                + "\"mappings\":{\"properties\":{"  
        try {  
        // Generation 2: 1× "alpha", 2× "beta".
        Request gen1Map = new Request(  
        assertEquals("comma-list across data stream (2) + plain index (3) must fan out", 5L, count);  
    }  
import java.util.List;  
public class DataStreamIT extends AnalyticsRestTestCase {  
        } catch (ResponseException ignored) {}
        put.setJsonEntity(  
        // a *new* field instead: present in gen 2 only, with a type that conflicts with one we'll  
            {"@timestamp":"2026-05-02T00:00:01Z","v":4}
                + "},"
    public void testDataStreamGroupByAcrossBackings() throws IOException {  
        long count = singleCount("source=logs* | stats count() as c");  
                + "{\"index\":{}}\n{\"@timestamp\":\"2026-05-01T00:00:01Z\",\"v\":11}\n"
 * this file be licensed under the Apache-2.0 license or a
        }
            """);
        long count = singleCount("source=" + STREAM + " | stats count() as c");
        Request gen2Map = new Request(  
 *
        put.setJsonEntity(  
                + "\"template\":{"  
            {"@timestamp":"2026-05-02T00:00:02Z","v":5}
    /**
    /**
                + "\"index.number_of_shards\":1,"  
            {"@timestamp":"2026-05-02T00:00:00Z","v":4,"category":"alpha"}  
                + "\"mappings\":{\"properties\":{\"@timestamp\":{\"type\":\"date\"},\"v\":{\"type\":\"long\"}}}}"
            "/.ds-" + STREAM + "-000001/_mapping?write_index_only=false"
    // ── setup helpers ────────────────────────────────────────────────────
            """);
                + "\"index.number_of_replicas\":0"
                + "\"data_stream\":{},"
        bulkIntoStream(STREAM, """  
        // Generation 1: 2× "alpha", 1× "beta".  
                + "\"index.number_of_shards\":1,\"index.number_of_replicas\":0},"  
            "{\"index_patterns\":[\"" + STREAM + "\"],"
            {"@timestamp":"2026-05-01T00:00:00Z","v":1}
                + "\"data_stream\":{},"
        bulkPlain.setJsonEntity(
     */  
        client().performRequest(new Request("POST", "/.ds-" + STREAM + "-000001/_close"));
    public void testDataStreamSkipsClosedBackingGeneration() throws IOException {  
                + "\"index.composite.primary_data_format\":\"parquet\","
     * category field, and the aggregation must reduce correctly across both backings. Exercises
        String error = executePplExpectingFailure("source=" + STREAM + " | fields divergent");
 * The OpenSearch Contributors require contributions made to  
     * scalar aggregates like sum/count).
        bulkIntoStream(STREAM, """
                + "\"index.composite.primary_data_format\":\"parquet\","
        assertNotNull("missing 'rows' for: " + ppl, rows);
        assertEquals(3L, ((Number) rows.get(0).get(0)).longValue());  
}
                + "\"@timestamp\":{\"type\":\"date\"},"
                + "\"v\":{\"type\":\"long\"}"
        assertEquals("two distinct categories", 2, rows.size());  
                + "{\"index\":{}}\n{\"@timestamp\":\"2026-05-01T00:00:02Z\",\"v\":12}\n"
            """);  
     */
            """);
        client().performRequest(bulkPlain);  
                + "\"index.composite.secondary_data_formats\":\"lucene\","
        Request bulkPlain = new Request("POST", "/" + plain + "/_bulk");
                + "},"
        Request put = new Request("PUT", "/_index_template/" + TEMPLATE);
        rolloverStream(STREAM);  
     * resolver path. The data stream backings are hidden indices, so this asserts the schema /  
            {"@timestamp":"2026-05-02T00:00:01Z","v":5,"category":"beta"}
        ensureCleanup();
import org.opensearch.client.Response;
        client().performRequest(gen1Map);
        createDataStreamTemplate();
    private void createDataStreamTemplateWithCategory() throws IOException {
        assertNotNull(rows);
     */
        bulkIntoStream(STREAM, """
        Map<String, Object> body = executePpl(ppl);
        bulkIntoStream(STREAM, """  
        );  
            {"@timestamp":"2026-05-02T00:00:00Z","v":3}  
                + "\"index.pluggable.dataformat\":\"composite\","  
    public void testCommaListMixingDataStreamAndConcreteIndex() throws IOException {
        gen2Map.setJsonEntity("{\"properties\":{\"divergent\":{\"type\":\"keyword\"}}}");
    private static void assertContains(String haystack, String needle) {
            """);  
            "PUT",
            Response response = client().performRequest(request);
import java.util.Map;
    private long singleCount(String ppl) throws IOException {
        ensureCleanup();
                + "}}"
            fail("Expected failure but got: " + assertOkAndParse(response, ppl));
        try {  
 * The planner must fan out across the backings exactly like the alias path — schema-compatibility  
            {"@timestamp":"2026-05-02T00:00:00Z","v":3}
     * Happy path: indexing into a data stream auto-creates one backing index; a single rollover  
        Request createPlain = new Request("PUT", "/" + plain);  
 * compatible open source license.
            "PUT",
                + "\"index.pluggable.dataformat\":\"composite\","  
            "{\"settings\":{\"index.pluggable.dataformat.enabled\":true,"
        String plain = "plain_logs";
