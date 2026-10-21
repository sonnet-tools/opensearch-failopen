    public void testDataStreamMatchedByWildcardFansOut() throws IOException {
            {"@timestamp":"2026-05-01T00:00:00Z","v":1,"category":"alpha"}
        return singleLongAgg(ppl);
                + "\"index.composite.secondary_data_formats\":\"lucene\","
                + "\"data_stream\":{},"
                + "},"
package org.opensearch.analytics.qa;
        bulkIntoStream(STREAM, """
        );
    public void testDataStreamGroupByAcrossBackings() throws IOException {
     */
    }
        // multiple backings with divergent types.
    private static final String TEMPLATE = "logs_ds_template";
            return ""; // unreachable
        client().performRequest(gen2Map);
    /**
        rolloverStream(STREAM);
                + "\"v\":{\"type\":\"long\"}"
 * End-to-end IT for data stream support on the analytics-engine route. A data stream is a single
    }
        gen2Map.setJsonEntity("{\"properties\":{\"divergent\":{\"type\":\"keyword\"}}}");
 * still applies in case a backing's mapping was manually amended after rollover.
    private String executePplExpectingFailure(String ppl) throws IOException {
        // Close the older generation; only generation 2's rows (3 docs) should be visible.
        bulkIntoStream(STREAM, """
        Map<String, Object> body = executePpl(ppl);
        assertEquals("alpha", rows.get(0).get(1));
        assertEquals("bulk into " + name + " had errors", false, response.get("errors"));
                + "\"settings\":{"
                + "\"index.composite.secondary_data_formats\":\"lucene\","
        Object cell = rows.get(0).get(0);
    }
        assertEquals("comma-list across data stream (2) + plain index (3) must fan out", 5L, count);
    public void testCommaListMixingDataStreamAndConcreteIndex() throws IOException {
            """);
                + "\"template\":{"
     */
}
        assertEquals("sum must aggregate across backings", 10L, sum);
            {"@timestamp":"2026-05-02T00:00:00Z","v":3}
        // Diverge generation 2's mapping: PUT a `v` field as keyword (template says long).
        Map<String, Object> body = executePpl("source=" + STREAM + " | stats count() as c by category | sort category");
        Request request = new Request("POST", "/_plugins/_ppl");
    private long singleLongAgg(String ppl) throws IOException {
        long sum = singleLongAgg("source=" + STREAM + " | stats sum(v) as s");
        String plain = "plain_logs";
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.client.Request;
    private void ensureCleanup() throws IOException {
            client().performRequest(new Request("DELETE", "/" + plain));
        Request request = new Request("POST", "/_bulk");
        } catch (ResponseException ignored) {}
        assertEquals("two distinct categories", 2, rows.size());
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
        assertEquals("beta", rows.get(1).get(1));
        createDataStreamTemplateWithCategory();
     * required timestamp field and {@code v} as a long. Backings inherit the composite/parquet
import java.util.Map;
     * which must include the data stream's hidden backings — not just the plain index. Asserts
                + "\"index.pluggable.dataformat.enabled\":true,"
    }
            {"@timestamp":"2026-05-02T00:00:01Z","v":4}
            "PUT",
            {"@timestamp":"2026-05-01T00:00:01Z","v":2}
            {"@timestamp":"2026-05-02T00:00:02Z","v":5}
        Request createPlain = new Request("PUT", "/" + plain);
                + "\"index.number_of_replicas\":0"
/**
            fail("Expected failure but got: " + assertOkAndParse(response, ppl));
            "{\"settings\":{\"index.pluggable.dataformat.enabled\":true,"
    /**
     * If a backing index's mapping has been manually amended such that a field type conflicts
    }
     * IndexResolution paths correctly expand hidden backings for data stream patterns.
     * the latest generation's rows.
    /** Removes any leftover data stream + template from a prior run. */
        } catch (ResponseException ignored) {}
     * Comma-separated source expression mixing a data stream with a plain index:
        client().performRequest(bulkPlain);
     * the coordinator-reduce stage for data streams (different code path than single-column
        }
    /**
        @SuppressWarnings("unchecked")
        // a *new* field instead: present in gen 2 only, with a type that conflicts with one we'll
 * compatible open source license.
        bulkIntoStream(STREAM, """
            "/.ds-" + STREAM + "-000002/_mapping?write_index_only=false"
        rolloverStream(STREAM);
    /**
            {"@timestamp":"2026-05-01T00:00:01Z","v":2,"category":"alpha"}
     */
        ensureCleanup();
    /**
            {"@timestamp":"2026-05-01T00:00:00Z","v":1}
        );
        bulkIntoStream(STREAM, """
        client().performRequest(put);
 *
            client().performRequest(new Request("DELETE", "/_index_template/" + TEMPLATE));
                + "\"index.composite.secondary_data_formats\":\"lucene\","
        );
        createDataStreamTemplate();
                + "}}"
        assertEquals("wildcard matching a data stream must fan out across all open backings", 3L, count);
        assertContains(error, "divergent");
            bulk.append("{\"create\":{\"_index\":\"").append(name).append("\"}}\n");
    public void testDataStreamRejectsConflictingBackingMappings() throws IOException {
        try {
        rolloverStream(STREAM);
        client().performRequest(new Request("POST", "/.ds-" + STREAM + "-000001/_close"));
            bulk.append(doc).append("\n");
     * The schema's literal-name short-circuit only fires for exact matches, so this exercises the
     * A closed older-generation backing must be silently filtered (matching the alias path's
     * with another generation, planning must fail at resolution with a schema-incompatible error.
                + "\"index.composite.primary_data_format\":\"parquet\","
            """);
        request.setJsonEntity(bulk.toString());
        bulkIntoStream(STREAM, """
        bulkPlain.setOptions(bulkPlain.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
            "{\"index\":{}}\n{\"@timestamp\":\"2026-05-01T00:00:00Z\",\"v\":10}\n"
                + "\"index.number_of_replicas\":0"
                + "},"
     * Multi-bucket group-by spanning rollover boundaries: each generation has rows tagged with a
    /**
/*
                + "}}"
        ensureCleanup();
 * The planner must fan out across the backings exactly like the alias path — schema-compatibility
            {"@timestamp":"2026-05-01T00:00:00Z","v":1}
import java.util.List;
     * dataformat settings so the scan goes through the analytics-engine native path.
    }
                + "\"@timestamp\":{\"type\":\"date\"},"
        Map<String, Object> response = assertOkAndParse(client().performRequest(request), "bulk " + name);
        bulkPlain.setJsonEntity(
    }
import java.io.IOException;
            """);
        );
     */
        } catch (ResponseException re) {
        createDataStreamTemplate();
            """);
        // add to gen 1. This still trips validateSchemaCompatibility because the field appears in
     * lenientExpandOpen behavior). Asserts the query returns only the open generation's rows
    }
            {"@timestamp":"2026-05-02T00:00:01Z","v":4}
        long count = singleCount("source=" + STREAM + " | stats count() as c");
                + "}}"
            """);
            "{\"index_patterns\":[\"" + STREAM + "\"],"
        String error = executePplExpectingFailure("source=" + STREAM + " | fields divergent");
        // Sanity: aggregation over the v column also fans out. Sum is 1+2+3+4 = 10.
                + "\"template\":{"
    private void rolloverStream(String name) throws IOException {
    private void createDataStreamTemplate() throws IOException {
import org.opensearch.client.ResponseException;
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
    }
        try {
    public void testDataStreamFansOutAcrossRolledOverBackings() throws IOException {
        client().performRequest(gen1Map);
                + "{\"index\":{}}\n{\"@timestamp\":\"2026-05-01T00:00:02Z\",\"v\":12}\n"
import org.opensearch.client.Response;
        StringBuilder bulk = new StringBuilder();
                + "\"index.pluggable.dataformat\":\"composite\","
            {"@timestamp":"2026-05-01T00:00:00Z","v":1}
            if (doc.isBlank()) continue;
 */
    public void testDataStreamSkipsClosedBackingGeneration() throws IOException {
            """);
            {"@timestamp":"2026-05-01T00:00:01Z","v":2}
                + "\"index.pluggable.dataformat.enabled\":true,"
     * — a regression that surfaces the closed backing into shard routing would fail at search.
        bulkIntoStream(STREAM, """
     * resolver path. The data stream backings are hidden indices, so this asserts the schema /
     * creates a second. The planner must fan out across both — a missing fan-out would only see
        put.setJsonEntity(
    }
        );
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
        assertContains(error, "incompatible field types");
     * Happy path: indexing into a data stream auto-creates one backing index; a single rollover
                + "\"settings\":{"
        long count = singleCount("source=" + STREAM + "," + plain + " | stats count() as c");
        client().performRequest(rollover);
        rolloverStream(STREAM);
    private void bulkIntoStream(String name, String ndjsonDocs) throws IOException {
            """);
        Request gen1Map = new Request(
        // Generation 1: 2× "alpha", 1× "beta".
            "{\"index_patterns\":[\"" + STREAM + "\"],"
        rolloverStream(STREAM);
        bulkIntoStream(STREAM, """
        client().performRequest(put);
        client().performRequest(createPlain);
            {"@timestamp":"2026-05-01T00:00:00Z","v":1}
     * Creates an index template that backs the data stream. Maps {@code @timestamp} as the
     * scalar aggregates like sum/count).
            """);
    private void createDataStreamTemplateWithCategory() throws IOException {
        assertTrue("expected to contain [" + needle + "] but was: " + haystack, haystack.contains(needle));
                + "\"index.number_of_shards\":1,"
    }
        // Generation 2: 1× "alpha", 2× "beta".
        ensureCleanup();
    }
                + "\"index.composite.primary_data_format\":\"parquet\","
            {"@timestamp":"2026-05-01T00:00:01Z","v":2}
            {"@timestamp":"2026-05-01T00:00:02Z","v":3,"category":"beta"}
                + "\"mappings\":{\"properties\":{"
        bulkPlain.addParameter("refresh", "true");
        assertNotNull("missing 'rows' for: " + ppl, rows);
        assertEquals(3L, ((Number) rows.get(0).get(0)).longValue());
        ensureCleanup();
            client().performRequest(new Request("DELETE", "/_data_stream/" + STREAM));
    // ── setup helpers ────────────────────────────────────────────────────
            {"@timestamp":"2026-05-02T00:00:00Z","v":3}
                + "\"data_stream\":{},"
        assertTrue("expected numeric: " + cell, cell instanceof Number);
 * logical name fronting a chain of rolled-over backing indices ({@code .ds-<name>-<date>-<gen>}).
            {"@timestamp":"2026-05-02T00:00:00Z","v":4,"category":"alpha"}
        @SuppressWarnings("unchecked")
            """);
                + "\"category\":{\"type\":\"keyword\"}"
    /**
        assertEquals("single row expected: " + ppl, 1, rows.size());
            {"@timestamp":"2026-05-01T00:00:00Z","v":1}
        createDataStreamTemplate();
        ensureCleanup();
    private static final String STREAM = "logs_ds";
            {"@timestamp":"2026-05-02T00:00:02Z","v":6,"category":"beta"}
 */
        assertEquals("data stream must fan out across both backings: 2 + 2", 4L, count);
        // DELETE first to keep this test self-contained across re-runs.
                + "{\"index\":{}}\n{\"@timestamp\":\"2026-05-01T00:00:01Z\",\"v\":11}\n"
        bulkIntoStream(STREAM, """
            "PUT",
        }
        long count = singleCount("source=logs* | stats count() as c");
     */
            {"@timestamp":"2026-05-02T00:00:01Z","v":5,"category":"beta"}
        createDataStreamTemplate();
                + "\"index.composite.primary_data_format\":\"parquet\","
     * Wildcard expression that matches a data stream name (e.g. {@code logs*} → {@code logs_ds}).
    private static void assertContains(String haystack, String needle) {
        bulkIntoStream(STREAM, """
        Request put = new Request("PUT", "/_index_template/" + TEMPLATE);
     * category field, and the aggregation must reduce correctly across both backings. Exercises
        gen1Map.setJsonEntity("{\"properties\":{\"divergent\":{\"type\":\"long\"}}}");
                + "\"mappings\":{\"properties\":{"
        long count = singleCount("source=" + STREAM + " | stats count() as c");
                + "\"index.pluggable.dataformat\":\"composite\","
    /** Template variant that also maps a {@code category} keyword field for group-by tests. */
     * {@code source = logs_ds,plain_index}. Comma splitting routes through the resolver path,
    // ── query helpers (mirrored from AliasIT) ────────────────────────────
        createDataStreamTemplate();
        try {
    }
                + "\"index.number_of_shards\":1,"
        return ((Number) cell).longValue();
public class DataStreamIT extends AnalyticsRestTestCase {
        ensureCleanup();
            {"@timestamp":"2026-05-01T00:00:01Z","v":2}
        Request put = new Request("PUT", "/_index_template/" + TEMPLATE);
                + "\"@timestamp\":{\"type\":\"date\"},"
        request.setOptions(request.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
        List<List<Object>> rows = (List<List<Object>>) body.get("datarows");
        assertEquals("closed gen-1 backing excluded: only gen-2's 3 rows", 3L, count);
     * Same contract as alias-spanning-mismatched-mappings, just exercised through a data stream.
     */
     */
        bulkIntoStream(STREAM, """
        put.setJsonEntity(
        for (String doc : ndjsonDocs.split("\n")) {
                + "\"mappings\":{\"properties\":{\"@timestamp\":{\"type\":\"date\"},\"v\":{\"type\":\"long\"}}}}"
        request.addParameter("refresh", "true");
                + "}}"
                + "\"v\":{\"type\":\"long\"},"
            """);
                + "\"index.pluggable.dataformat\":\"composite\","
    }
    private long singleCount(String ppl) throws IOException {
        Request gen2Map = new Request(
        try {
            {"@timestamp":"2026-05-02T00:00:00Z","v":3}
        );
        } catch (ResponseException ignored) {}
        // The update-mapping API on a backing index will reject incompatible adds, so we drift on
                + "\"index.number_of_shards\":1,\"index.number_of_replicas\":0},"
            Response response = client().performRequest(request);
                return new String(is.readAllBytes(), java.nio.charset.StandardCharsets.UTF_8);
            "/.ds-" + STREAM + "-000001/_mapping?write_index_only=false"
     * the row count is the sum of both sides.
        // After sort by category: alpha (3), beta (3).
        assertEquals(3L, ((Number) rows.get(1).get(0)).longValue());
    }
        createPlain.setJsonEntity(
        assertNotNull(rows);
            }
        Request rollover = new Request("POST", "/" + name + "/_rollover");
        Request bulkPlain = new Request("POST", "/" + plain + "/_bulk");
            try (var is = re.getResponse().getEntity().getContent()) {
