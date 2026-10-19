 * The OpenSearch Contributors require contributions made to  
    private void ingest() throws IOException {
            "source=" + INDEX + " | stats min(enabled) as min_e, max(enabled) as max_e by grp"
        assertEquals("max(enabled)", Boolean.TRUE, row.get(3));
        health.addParameter("timeout", "30s");
     */
            } else {
 * analytics-engine route, against the production {@code /_plugins/_ppl} surface.  
 * support {@code Boolean}. The added boolean overload lets isthmus bind the call.
        try {  
    public void testMinMaxBooleanGrouped() throws IOException {
 *
}  
import org.opensearch.client.Request;
            + "  \"index.pluggable.dataformat\": \"composite\","  
        assertNotNull("missing datarows", rows);
import java.util.List;
    /**
     * Mirrors the cross-type binding (string overload already existed; boolean is the new one).  
     * max=true); {@code version} is a string (for the mixed-type min/max(string) case);  
        new Doc("g1", true, "rust"),
        @SuppressWarnings("unchecked")
            }  
        throw new AssertionError("column not found in schema: " + name);
        return rows.get(0);
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
        Request req = new Request("PUT", "/" + INDEX);  
        for (Doc d : DOCS) {
     * Mixed-type aggregation: min/max over both a boolean and a string column in one stats.
 * compatible open source license.
 * {@code functions_arithmetic.yaml} only defines min/max for {@code i8..fp64}, and  
 * <p>Regression guard for the boolean min/max binding. Substrait's stock
        String body = "{"
    }  
 * {@code "Unable to find binding for call MIN($0)"} even though DataFusion's native min/max  
    }  
            client().performRequest(new Request("DELETE", "/" + INDEX));
        } catch (Exception ignored) {}
        Map<String, Object> response = assertOkAndParse(client().performRequest(req), "Create index");
     */
        assertEquals("bulk must not report errors", Boolean.FALSE, response.get("errors"));
        // _bulk requires NDJSON; setJsonEntity defaults to application/json which the bulk  
        int minCol = colIndex(schema, "min_e");
                assertEquals("g0 min", Boolean.FALSE, row.get(minCol));
            bulk.append("{\"grp\":\"").append(d.grp()).append("\",\"enabled\":").append(d.enabled())  
    );  
            + "  \"index.composite.secondary_data_formats\": \"lucene\""
            + "  }"  
                assertEquals("g1 min (all true)", Boolean.TRUE, row.get(minCol));
        client().performRequest(health);
        int maxCol = colIndex(schema, "max_e");  
public class MinMaxBooleanAggregationIT extends AnalyticsRestTestCase {  
 */
 * SPDX-License-Identifier: Apache-2.0
    private record Doc(String grp, boolean enabled, String version) {}
            if (name.equals(schema.get(i).get("name"))) {
            + "  \"number_of_shards\": 1,"  
        new Doc("g0", false, "go"),  
        new Doc("g0", true, "python"),
        @SuppressWarnings("unchecked")  
     */
     * (min=false,max=true); g1 is all-true (min=true,max=true).  
 * this file be licensed under the Apache-2.0 license or a
import java.util.Map;
            ingest();
    private void createParquetIndex() throws IOException {
        int grpCol = colIndex(schema, "grp");
            + "}";
                .append(",\"version\":\"").append(d.version()).append("\"}\n");
        assertEquals("two groups", 2, rows.size());
        assertEquals("min(enabled) over all rows", Boolean.FALSE, row.get(0));  
        req.setOptions(req.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
 * Without a boolean overload, {@code stats min(bool_field)} fails on the DataFusion route with
            indexReady = true;
            + "  \"number_of_replicas\": 0,"
        Request req = new Request("POST", "/" + INDEX + "/_bulk");  
    @SuppressWarnings("unchecked")
    private static final String INDEX = "minmax_boolean_e2e";
        assertEquals(true, response.get("acknowledged"));  
        assertEquals("max(enabled) over all rows", Boolean.TRUE, row.get(1));
        for (List<Object> row : rows) {
        }  
        );
        }
    }
            + "  \"index.composite.primary_data_format\": \"parquet\","
        StringBuilder bulk = new StringBuilder();  
    @Override  
        req.setJsonEntity(body);
        for (int i = 0; i < schema.size(); i++) {  
                + " | stats min(version) as min_v, max(version) as max_v, min(enabled) as min_e, max(enabled) as max_e"  
        Map<String, Object> response = assertOkAndParse(client().performRequest(req), "Bulk ingest");  
 * <p>Run with:  
    }  
        assertEquals("min(enabled)", Boolean.FALSE, row.get(2));
            }  
        List<Object> row = singleRow("source=" + INDEX + " | stats min(enabled) as min_e, max(enabled) as max_e");
            + "  \"index.pluggable.dataformat.enabled\": true,"
            + "    \"version\": { \"type\": \"keyword\" }"
            + "},"  
        // endpoint rejects (mirrors the existing CountFastPathIT pattern).
import java.io.IOException;  
        if (indexReady == false) {
    public void testMinMaxMixedBooleanAndString() throws IOException {  
        );
        assertEquals("max(version)", "rust", row.get(1));  
    private static int colIndex(List<Map<String, Object>> schema, String name) {
        health.addParameter("wait_for_status", "green");  
    private boolean indexReady = false;
    private static final List<Doc> DOCS = List.of(  
        assertNotNull("missing datarows for: " + ppl, rows);  
     * Single source of truth. {@code enabled} mixes true/false across rows (so min=false,
        Map<String, Object> result = executePpl(  
        Request health = new Request("GET", "/_cluster/health/" + INDEX);
                assertEquals("g1 max (all true)", Boolean.TRUE, row.get(maxCol));  
     * version min="go", max="rust"; enabled min=false, max=true.
            + "    \"grp\": { \"type\": \"keyword\" },"  
/**
    }
        List<Object> row = singleRow(
    }
        }
 * {@code opensearch_aggregate_functions.yaml} previously extended them only to {@code string}.
            + "  \"properties\": {"
        req.setJsonEntity(bulk.toString());
            + "    \"enabled\": { \"type\": \"boolean\" },"
    }  
        req.addParameter("refresh", "true");
 * End-to-end coverage for PPL {@code min}/{@code max} over a {@code boolean} column on the
            if ("g0".equals(grp)) {
        new Doc("g1", true, "java")
    /**
    private List<Object> singleRow(String ppl) throws IOException {  
     * Grouped {@code min(bool)} / {@code max(bool)} by a keyword. g0 has both true and false
        }
            "source=" + INDEX
/*  
        assertEquals("expected exactly one summary row for: " + ppl, 1, rows.size());
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");  
        assertEquals("min(version)", "go", row.get(0));
    protected void onBeforeQuery() throws IOException {
 *
                assertEquals("g0 max", Boolean.TRUE, row.get(maxCol));  
    /** {@code min(bool)} / {@code max(bool)} over all rows — min=false, max=true. */  
            + "}"
            + "\"mappings\": {"
     * {@code grp} groups rows for the grouped variant.
            } else if ("g1".equals(grp)) {
                fail("unexpected group: " + grp);
            bulk.append("{\"index\": {}}\n");
    public void testMinMaxBooleanUngrouped() throws IOException {
    }
            createParquetIndex();  
            + "\"settings\": {"
package org.opensearch.analytics.qa;
 * {@code ./gradlew :sandbox:qa:analytics-engine-rest:integTest --tests "*.MinMaxBooleanAggregationIT" -Dsandbox.enabled=true}
 */  
 *
            String grp = (String) row.get(grpCol);  
        new Doc("g0", false, "java"),
        List<Map<String, Object>> schema = (List<Map<String, Object>>) result.get("schema");
                return i;
        Map<String, Object> result = executePpl(ppl);
    /**
