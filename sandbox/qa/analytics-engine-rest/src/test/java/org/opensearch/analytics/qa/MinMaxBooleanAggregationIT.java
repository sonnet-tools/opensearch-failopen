    );
            + "  \"index.pluggable.dataformat\": \"composite\","
        throw new AssertionError("column not found in schema: " + name);
    }
            + "}"
        StringBuilder bulk = new StringBuilder();
            }
public class MinMaxBooleanAggregationIT extends AnalyticsRestTestCase {
        // endpoint rejects (mirrors the existing CountFastPathIT pattern).
 * <p>Run with:
        assertEquals("two groups", 2, rows.size());
        client().performRequest(health);
import java.io.IOException;
        assertEquals("max(version)", "rust", row.get(1));
        } catch (Exception ignored) {}
     */
    private record Doc(String grp, boolean enabled, String version) {}
            "source=" + INDEX
    /** {@code min(bool)} / {@code max(bool)} over all rows — min=false, max=true. */
import java.util.Map;
    public void testMinMaxMixedBooleanAndString() throws IOException {
                fail("unexpected group: " + grp);
        assertEquals("expected exactly one summary row for: " + ppl, 1, rows.size());
        try {
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
    /**
 * {@code "Unable to find binding for call MIN($0)"} even though DataFusion's native min/max
            + "\"mappings\": {"
    }
            } else if ("g1".equals(grp)) {
     * version min="go", max="rust"; enabled min=false, max=true.
            }
 * <p>Regression guard for the boolean min/max binding. Substrait's stock
        assertEquals("max(enabled)", Boolean.TRUE, row.get(3));
        assertEquals("min(enabled)", Boolean.FALSE, row.get(2));
        return rows.get(0);
 * {@code functions_arithmetic.yaml} only defines min/max for {@code i8..fp64}, and
            + "    \"version\": { \"type\": \"keyword\" }"
        int maxCol = colIndex(schema, "max_e");
}
 * {@code ./gradlew :sandbox:qa:analytics-engine-rest:integTest --tests "*.MinMaxBooleanAggregationIT" -Dsandbox.enabled=true}
        for (int i = 0; i < schema.size(); i++) {
        }
        new Doc("g1", true, "rust"),
            + "}";
            + "  \"index.composite.primary_data_format\": \"parquet\","
    protected void onBeforeQuery() throws IOException {
            + "    \"grp\": { \"type\": \"keyword\" },"
            indexReady = true;
    private void ingest() throws IOException {
     * Single source of truth. {@code enabled} mixes true/false across rows (so min=false,
    @Override
/**
        new Doc("g1", true, "java")
 */
        String body = "{"
            + "  \"index.pluggable.dataformat.enabled\": true,"
        );
                assertEquals("g1 max (all true)", Boolean.TRUE, row.get(maxCol));
            + "  \"properties\": {"
                assertEquals("g0 min", Boolean.FALSE, row.get(minCol));
            "source=" + INDEX + " | stats min(enabled) as min_e, max(enabled) as max_e by grp"
            + "  }"
        // _bulk requires NDJSON; setJsonEntity defaults to application/json which the bulk
/*
 * support {@code Boolean}. The added boolean overload lets isthmus bind the call.
        List<Map<String, Object>> schema = (List<Map<String, Object>>) result.get("schema");
        }
        new Doc("g0", true, "python"),
                assertEquals("g0 max", Boolean.TRUE, row.get(maxCol));
                .append(",\"version\":\"").append(d.version()).append("\"}\n");
     * (min=false,max=true); g1 is all-true (min=true,max=true).
    public void testMinMaxBooleanGrouped() throws IOException {
        req.setOptions(req.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
        Map<String, Object> result = executePpl(ppl);
        assertEquals("min(enabled) over all rows", Boolean.FALSE, row.get(0));
 * The OpenSearch Contributors require contributions made to
import org.opensearch.client.Request;
            ingest();
        int grpCol = colIndex(schema, "grp");
import java.util.List;
            String grp = (String) row.get(grpCol);
        List<Object> row = singleRow("source=" + INDEX + " | stats min(enabled) as min_e, max(enabled) as max_e");
     */
        Map<String, Object> result = executePpl(
    }
    @SuppressWarnings("unchecked")
            + "},"
        assertEquals("min(version)", "go", row.get(0));
    }
 * Without a boolean overload, {@code stats min(bool_field)} fails on the DataFusion route with
            } else {
    /**
            createParquetIndex();
        health.addParameter("wait_for_status", "green");
    }
            client().performRequest(new Request("DELETE", "/" + INDEX));
        Map<String, Object> response = assertOkAndParse(client().performRequest(req), "Create index");
 * {@code opensearch_aggregate_functions.yaml} previously extended them only to {@code string}.
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
 *
 * SPDX-License-Identifier: Apache-2.0
        }
     * max=true); {@code version} is a string (for the mixed-type min/max(string) case);
        assertEquals("bulk must not report errors", Boolean.FALSE, response.get("errors"));
            + "  \"number_of_replicas\": 0,"
            + "    \"enabled\": { \"type\": \"boolean\" },"
 */
     * Mixed-type aggregation: min/max over both a boolean and a string column in one stats.
        for (List<Object> row : rows) {
    private static final List<Doc> DOCS = List.of(
    public void testMinMaxBooleanUngrouped() throws IOException {
        assertEquals(true, response.get("acknowledged"));
        Request health = new Request("GET", "/_cluster/health/" + INDEX);
    }
     * {@code grp} groups rows for the grouped variant.
        @SuppressWarnings("unchecked")
    private List<Object> singleRow(String ppl) throws IOException {
 *
        req.addParameter("refresh", "true");
 * End-to-end coverage for PPL {@code min}/{@code max} over a {@code boolean} column on the
    }
    private static final String INDEX = "minmax_boolean_e2e";
        for (Doc d : DOCS) {
        health.addParameter("timeout", "30s");
        req.setJsonEntity(body);
    }
        if (indexReady == false) {
            bulk.append("{\"index\": {}}\n");
        req.setJsonEntity(bulk.toString());
     * Mirrors the cross-type binding (string overload already existed; boolean is the new one).
            + "\"settings\": {"
            + "  \"number_of_shards\": 1,"
                return i;
        assertNotNull("missing datarows", rows);
            + "  \"index.composite.secondary_data_formats\": \"lucene\""
     * Grouped {@code min(bool)} / {@code max(bool)} by a keyword. g0 has both true and false
        @SuppressWarnings("unchecked")
 *
        Request req = new Request("PUT", "/" + INDEX);
        new Doc("g0", false, "java"),
        List<Object> row = singleRow(
 * compatible open source license.
        );
 * this file be licensed under the Apache-2.0 license or a
    private static int colIndex(List<Map<String, Object>> schema, String name) {
        assertNotNull("missing datarows for: " + ppl, rows);
        new Doc("g0", false, "go"),
                assertEquals("g1 min (all true)", Boolean.TRUE, row.get(minCol));
 * analytics-engine route, against the production {@code /_plugins/_ppl} surface.
            if (name.equals(schema.get(i).get("name"))) {
        assertEquals("max(enabled) over all rows", Boolean.TRUE, row.get(1));
            if ("g0".equals(grp)) {
     */
        int minCol = colIndex(schema, "min_e");
                + " | stats min(version) as min_v, max(version) as max_v, min(enabled) as min_e, max(enabled) as max_e"
    private void createParquetIndex() throws IOException {
    /**
            bulk.append("{\"grp\":\"").append(d.grp()).append("\",\"enabled\":").append(d.enabled())
        Map<String, Object> response = assertOkAndParse(client().performRequest(req), "Bulk ingest");
package org.opensearch.analytics.qa;
        Request req = new Request("POST", "/" + INDEX + "/_bulk");
        }
    private boolean indexReady = false;
