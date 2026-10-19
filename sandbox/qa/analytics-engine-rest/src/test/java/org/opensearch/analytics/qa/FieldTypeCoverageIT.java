        assertScanSucceeds("ft_byte", 3);
        StringBuilder body = new StringBuilder();
        assertScanSucceeds("ft_boolean", 3);
        createIndex(index, createBody(index, mapping));  
 * The OpenSearch Contributors require contributions made to  
        assertFilterRowCount("source=ft_binary_project | eval is_alice=if(val='YWxpY2U=','y','n')", 3);
    public void testLong() throws IOException {
            + "  \"properties\": {"  
        // Be forgiving of leftover state from previous runs (preserveIndicesUponCompletion = true).  
    private void assertBulkSucceeded(Map<String, Object> bulkResponse, String index) throws IOException {
    private void assertHalfFloatProjectedValues(String index, double[] expectedSorted) throws IOException {  
        do {
    /**  
    public void testIpFilters() throws IOException {
        assertBulkSucceeded(binBulk, "ft_binary_project");  
    public void testUnsignedLong() throws IOException {
        assertScanSucceeds("ft_float", 3);  
        assertFilterRowCount(
    private Map<String, Object> ingest(String index, String type, Object... values) throws IOException {
        @SuppressWarnings("unchecked")  
        assertFilterRowCount(  
        assertBulkSucceeded(bulk, "ft_short");  
            + "    \"name\": { \"type\": \"keyword\" },"
 * PPL read path. One test method per OpenSearch mapping type the sandbox targets.
        req.setJsonEntity("{\"query\": \"source=" + index + "\"}");
        Map<String, Object> resp = executePpl(ppl);  
    private void assertScanFails(String index) {  
     * Each predicate shape exercises a different code path:
        assertScanSucceeds("ft_date_nanos", 3);
            }
        try {
    }
        Map<String, Object> bulk = ingest("ft_keyword", "keyword", "alice", "bob", "carol");
        flush(index);  
    }
    public void testScaledFloat() throws IOException {  
        // Scan binds as BIGINT (storage is Int64). Projections / predicates / aggregates
        StringBuilder sb = new StringBuilder();
            + "  \"index.composite.primary_data_format\": \"parquet\","
        assertScanSucceeds("ft_ip", 3);  
        Map<String, Object> bulk = ingest("ft_text", "text", "connection refused", "host unreachable", "peer reset");
        assertBulkSucceeded(bulk, "ft_keyword");  
        // Calcite TIMESTAMP is millisecond-precision.
    public void testDate() throws IOException {  
            body.append("{\"index\":{}}\n");
        return sb.toString();  
import java.util.Map;
            if (v instanceof String) {
            + "  \"index.composite.secondary_data_formats\": [\"lucene\"]"  
    }
        final double tolerance = 0.05;
            + "  \"index.pluggable.dataformat.enabled\": true,"  
            "timeout on socket",
     * {@code ParquetField} throws (byte, half_float).
            "\"1995-05-20T11:00:00.987654321Z\"",
        Map<String, Object> resp = executePpl("source=" + index);
     * {@code BINARY('lit':VARCHAR)} placeholder inside a {@code LogicalProject} (or a CASE in
    private void createIndex(String index, String body) throws IOException {
            "dns lookup failed",  
        Map<String, Object> bulk = ingest("ft_ip", "ip", "\"192.168.1.1\"", "\"10.0.0.1\"", "\"172.16.0.1\"");
        }  
    private void assertScanSucceeds(String index, int expected) throws IOException {
    }
import java.util.List;  
        // BINARY(varchar) placeholder (BinaryFunctionAdapter rewrites it into a VARBINARY
        );  
     *       {@code OpenSearchFilter.stripAnnotations}.</li>
            + "},"
    public void testDouble() throws IOException {  
        Map<String, Object> bulk = ingest("ft_boolean", "boolean", true, false, true);
                "Expected source=" + index + " to fail, got status "  
 *   </li>  
        assertFilterRowCount("source=ft_ip_filters | where val between '10.0.0.0' and '10.255.255.255'", 1);  
        for (int i = 0; i < jsonValues.length; i++) {  
        String[] out = new String[values.length];
    /**
     * the project tree above an aggregate).
        );  
            body.append("{\"name\":\"").append(rowName(i)).append("\",\"val\":").append(jsonValues[i]).append("}\n");
        // Test values stay below 2^63 - 1 because BIGINT is signed; values above wrap.
    }
        }
        assertFilterRowCount("source=ft_ip_project | where val='192.168.1.1' | fields val", 1);  
    /**  
            Boolean.TRUE,
        assertBulkSucceeded(bulk, "ft_integer");  
        client().performRequest(new Request("POST", "/" + index + "/_flush?force=true"));
    /** Convert each value to its JSON literal form. Strings get wrapped in quotes unless already pre-quoted. */  
        assertEquals(Boolean.TRUE, resp.get("acknowledged"));  
 * <p>Each test is a two-phase script:
        // Scan binds as TIMESTAMP. Sub-millisecond precision is silently truncated because
    private void assertFilterRowCount(String ppl, int expected) throws IOException {
        @SuppressWarnings("unchecked")
        Request bulk = new Request("POST", "/" + index + "/_bulk");
    }
        // bytes. Filter / aggregation coverage on `ip` columns is in testIpFilters.  
        assertBulkSucceeded(bulk, "ft_ip");
        assertFilterRowCount("source=ft_ip_filters | where val > '10.0.0.50'", 2);  
        }
        assertScanSucceeds("ft_date", 3);  
        assertHalfFloatProjectedValues("ft_half_float", new double[] { 45.5, 47.6, 52.1 });  
import org.opensearch.client.Response;
        } catch (ResponseException ignored) {  
            fail(
    // ── Lower-level helpers ──────────────────────────────────────────────────────
    }
            Response resp = client().performRequest(req);
        assertBulkSucceeded(bulk, "ft_binary");
        Map<String, Object> bulk = ingest("ft_long", "long", 100000000L, 200000000L, 300000000L);
        assertBulkSucceeded(bulk, "ft_scaled_float");
     * row count is the meaningful signal.  
     * Bare {@code source=<index>} scan must throw. Known-bug guard for types where the
        assertScanSucceeds("ft_text", 3);
        Map<String, Object> bulk = ingest("ft_ip_filters", "ip", "\"192.168.1.1\"", "\"10.0.0.1\"", "\"172.16.0.1\"");  
    // ── Temporal ─────────────────────────────────────────────────────────────────
        assertScanSucceeds("ft_long", 3);
    }
    public void testHalfFloat() throws IOException {
     * the underlying gap is closed and the scan starts succeeding, this assertion will  
 *     <ul>  
     * Variant of {@link #ingest} that lets the caller inject extra mapping properties into  
        List<List<Object>> rows = (List<List<Object>>) resp.get("datarows");
    /** Generate a stable row name for index i: a, b, …, z, aa, ab, … */
     * Fire an N-doc bulk with sequential names {@code a, b, c, …} and {@code val=jsonValues[i]},
    private Map<String, Object> ingestWithMapping(String index, String type, String extraMappingJson, Object... values)  
        }  
     */
     *   <li>{@code =} — comparator with VARBINARY column + VARCHAR literal, expanded via
        for (int i = 0; i < values.length; i++) {  
        bulk.setOptions(bulk.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());  
        // (>= 4 conjuncts after SARG/cidr expansion).
            // expected on first run
            );
            + "    " + valMappingFragment
        assertBulkSucceeded(bulk, "ft_long");  
        assertScanSucceeds("ft_integer", 3);
    /**  
    /**  
     */
     */  
        assertBulkSucceeded(bulk, "ft_ip_filters");
        assertFilterRowCount("source=ft_ip_filters | where cidrmatch(val, '192.168.0.0/16')", 1);
    private void assertBulkErrored(Map<String, Object> bulkResponse, String type) {
        assertEquals(expectedSorted.length, rows.size());
            sb.insert(0, (char) ('a' + (i % 26)));  
            i = i / 26 - 1;
        } while (i >= 0);
            + "  \"number_of_shards\": 1,"
import org.opensearch.client.Request;
        assertBulkSucceeded(bulk, "ft_boolean");  
 *
    /**
     * {@code expectedSorted} within fp16 precision (~3 decimal digits). {@code expectedSorted}  
     *   <li>{@code !=}, {@code >} — same path, different comparator.</li>
            + "  \"number_of_replicas\": 0,"
        Map<String, Object> bulk = ingestWithMapping("ft_binary", "binary", ", \"store\": true", "\"YWxpY2U=\"", "\"Ym9i\"", "\"Y2Fyb2w=\"");
    private static String createBody(String index, String valMappingFragment) {
     * {@code case(col=lit, …)}, and {@code count(eval(col=lit))} all lower to a  
 * SPDX-License-Identifier: Apache-2.0
    }
        assertNotNull("source=" + index + " response missing rows", rows);
    }
        assertFilterRowCount("source=ft_ip_filters | where cidrmatch(val, '0.0.0.0/0')", 3);
        Request req = new Request("POST", "/_plugins/_ppl");
        assertBulkSucceeded(bulk, "ft_double");
    /**
 *   <li><b>Ingest phase</b> — {@link #ingest} creates the index, posts N docs, and returns  
        Map<String, Object> bulk = ingest("ft_half_float", "half_float", 47.6, 45.5, 52.1);  
     */
            Object v = values[i];
        // schema_coerce::coerce_for_substrait. Predicates on binary columns now work via the  
        bulk.setJsonEntity(body.toString());
        assertFilterRowCount("source=ft_ip_filters | where val = '192.168.1.1'", 1);
            "date_nanos",
     * bulk response without asserting on it — the caller decides whether to expect
        assertScanSucceeds("ft_match_only_text", 3);
        assertScanSucceeds("ft_scaled_float", 3);
        );
        Map<String, Object> ipBulk = ingest("ft_ip_project", "ip", "\"192.168.1.1\"", "\"10.0.0.1\"", "\"172.16.0.1\"");
    public void testDateNanos() throws IOException {  
        Map<String, Object> resp = executePpl("source=" + index + " | sort val | fields val");
            + "}"
        } catch (ResponseException expected) {
        assertBulkSucceeded(bulk, "ft_date_nanos");
                    + resp.getStatusLine().getStatusCode()
     *       {@code BinaryFunctionAdapter}.</li>  
            "unsigned_long",
            bulkResponse.get("errors")
        Map<String, Object> bulk = ingest("ft_double", "double", 47.6, 45.5, 52.1);
package org.opensearch.analytics.qa;
        assertFilterRowCount("source=ft_ip_filters | where val < '172.16.0.1'", 1);
        // Scan binds as VARBINARY; the BinaryView → Binary rewrite happens in
            // Transport-level error — also counts as "scan failed".
 */  
    public void testShort() throws IOException {
    // ── Text / keyword ────────────────────────────────────────────────────────────
    }
    private static String rowName(int i) {  
     * End-to-end coverage of filter / aggregation shapes against an {@code ip} column.
 * Per-type coverage test for composite-engine + parquet indexing and the analytics-engine
        assertFilterRowCount("source=ft_ip_filters | where val in ('192.168.1.1', '10.0.0.1')", 2);
     * Project a {@code half_float} column, sort numerically, and assert each value matches
 *       <li>{@link #assertScanFails} — bare scan must throw. Known-bug guard for types DataFusion can't materialize.</li>
     * <p>Distinct method name (rather than another {@code ingest} overload) because
        assertFilterRowCount("source=ft_ip_filters | where cidrmatch(val, '10.0.0.0/8')", 1);  
}
     *   <li>{@code cidrmatch} — exercised the inline expansion in
    public void testIp() throws IOException {  
        Map<String, Object> bulk = ingest(  
        assertScanSucceeds("ft_unsigned_long", 3);
            "tls handshake error"
    }
        // expose the *scaled* long, not the original float.
                out[i] = s.startsWith("\"") ? s : "\"" + s + "\"";
        Map<String, Object> binBulk = ingestWithMapping("ft_binary_project", "binary", ", \"store\": true", "\"YWxpY2U=\"", "\"Ym9i\"", "\"Y2Fyb2w=\"");
 * this file be licensed under the Apache-2.0 license or a
 *   <li><b>Assertion phase</b> — one or more of:
     * Create a single-field index and post N docs (named a/b/c/...). Returns the parsed  
        assertBulkSucceeded(bulk, "ft_byte");  
 *  
            "ft_unsigned_long",
    }
     * Project-side coverage of {@code BinaryFunctionAdapter}. PPL {@code eval if(col=lit, …)},
            "source=ft_ip_filters | where val > '10.0.0.0' AND val < '200.0.0.0'"
        assertScanSucceeds("ft_double", 3);  
        // schema_coerce::coerce_for_substrait. Projections return raw 16-byte IPv6-mapped
    private void flush(String index) throws IOException {  
     * success ({@link #assertBulkSucceeded}) or failure ({@link #assertBulkErrored}).
        } catch (IOException io) {  
     * sealed before any subsequent scan assertion runs.
 *       <li>{@link #assertBulkSucceeded} — {@code errors=false} and flush. Use first when ingest is expected to succeed.</li>
        return bulkRaw(index, asJsonArray(values));
public class FieldTypeCoverageIT extends AnalyticsRestTestCase {  
        );  
    }  
    public void testMatchOnlyText() throws IOException {
    }  
        assertFilterRowCount("source=ft_ip_filters | where val != '192.168.1.1'", 2);
            34567890123456789L
        assertBulkSucceeded(bulk, "ft_half_float");
        assertFilterRowCount("source=ft_ip_project | eval is_local=if(val='192.168.1.1','y','n')", 3);
        return assertOkAndParse(client().performRequest(bulk), "Bulk " + index);
        // inserts the IEEE half→single cast per batch on read.
 *       the raw bulk response without asserting on it.</li>
     * — silently eating the first row value as a mapping fragment.
        List<List<Object>> rows = (List<List<Object>>) resp.get("datarows");
            3  
    }
            double got = ((Number) rows.get(i).get(0)).doubleValue();
    }  
        );
        String mapping = "\"val\": { \"type\": \"" + type + "\"" + extraMappingJson + " }";
     *       {@code ExtendedRexBuilder.makeCast} to {@code BINARY(varchar)} and resolved by
            "match_only_text",
            } else {
     */
 *     </ul>
     */  
        Request create = new Request("PUT", "/" + index);  
        return out;  
            + "}";
    public void testByte() throws IOException {
            );  
        create.setJsonEntity(body);
 */
    }
            "\"1988-03-10T12:00:00.111222333Z\""
        assertEquals("source=" + index + " row count", expected, rows.size());  
 *       <li>{@link #assertScanSucceeds} — bare {@code source=<index>} scan; materializes every column.</li>  
     */  
        assertBulkSucceeded(bulk, "ft_unsigned_long");
        assertScanSucceeds("ft_half_float", 3);
        }
    public void testBinary() throws IOException {
            + "  \"index.pluggable.dataformat\": \"composite\","
                String s = (String) v;  
            3
    }
                out[i] = String.valueOf(v);  
    public void testBoolean() throws IOException {
    public void testKeyword() throws IOException {
     * that exercise filter / aggregation shapes (e.g. {@link #testIpFilters}) where the
        @SuppressWarnings("unchecked")  
        Map<String, Object> bulk = ingest("ft_float", "float", 47.6, 45.5, 52.1);
        assertEquals(
     * must be in ascending order to match the {@code | sort val} we issue.
            client().performRequest(new Request("DELETE", "/" + index));
    /**  
        assertNotNull("[" + ppl + "] response missing rows", rows);  
        List<List<Object>> rows = (List<List<Object>>) resp.get("datarows");
     */  
            12345678901234567L,  
    // ── Other ────────────────────────────────────────────────────────────────────
     *   <li>{@code IN} — exercised the {@code OpenSearchTypeFactory.leastRestrictive} override
     */  
    public void testText() throws IOException {
        assertFilterRowCount("source=ft_binary_project | stats count(eval(val='YWxpY2U=')) as c", 1);
                expected.getResponse().getStatusLine().getStatusCode() >= 500
        assertEquals("[" + ppl + "] row count", expected, rows.size());
        try {  
            "ft_match_only_text",  
        assertScanSucceeds("ft_short", 3);
        return ingestWithMapping(index, type, "", values);
        Map<String, Object> bulk = ingest("ft_short", "short", 100, 200, 300);
    public void testFloat() throws IOException {  
        );
 * </ol>
     * The fragment must be a leading-comma-prefixed JSON snippet or empty.
            23456789012345678L,
     * Bulk response must report {@code errors=true}. For types where the primary writer's
     * column, so this catches per-column read-path bugs that {@code count()} misses.
import java.io.IOException;
    }  
        assertBulkSucceeded(bulk, "ft_match_only_text");  
     * extra-mapping overload — Java picks {@code String} over {@code Object} as more specific  
     *       {@code PPLFuncImpTable.populate} that rewrites cidr literals into byte-range AND.</li>  
    }
    public void testInteger() throws IOException {
        assertFilterRowCount("source=ft_ip_filters | where NOT cidrmatch(val, '192.168.0.0/16')", 2);
        assertEquals("Expected bulk ingest to succeed for [" + index + "]", Boolean.FALSE, bulkResponse.get("errors"));
     * Bulk response must report {@code errors=false}. Flushes so the parquet rowgroup is
    }  
     *       for VARBINARY ⇄ VARCHAR.</li>  
        // schema_coerce widens Float16 → Float32 before substrait binds; SchemaAdapter
        assertScanSucceeds("ft_binary", 3);  
        // — binary columns share the same code path.  
     * Bare {@code source=<index>} scan must return {@code expected} rows. Materializes every
    }
        Map<String, Object> bulk = ingest("ft_byte", "byte", 1, 2, 3);
     * <ul>  
     * column never lands in parquet (e.g. match_only_text has no parquet writer). When
            + "\"settings\": {"  
        assertBulkSucceeded(ipBulk, "ft_ip_project");  
/**  
     *   <li>{@code AND}-combination — exercised the {@code RexUtil.flatten} guard in
        assertBulkSucceeded(bulk, "ft_text");  
        assertScanSucceeds("ft_keyword", 3);
        // Scan binds as VARBINARY; the BinaryView → Binary rewrite happens in
 * compatible open source license.
        return "{"
        bulk.addParameter("refresh", "true");
        assertBulkSucceeded(bulk, "ft_date");
            assertEquals("row " + i, expectedSorted[i], got, tolerance);
     * {@code ingest(idx, type, "...string-value...", ...)} would otherwise bind to the
     *   <li>{@code BETWEEN} — same {@code leastRestrictive} path with a 3-arg shape.</li>
        Map<String, Object> bulk = ingest(
        assertFilterRowCount("source=ft_ip_project | stats count(eval(val='192.168.1.1')) as cnt", 1);  
    /**  
     * </ul>  
 * <ol>
     * Runs a PPL query and asserts the row count matches {@code expected}. Used by tests
        Map<String, Object> bulk = ingest(  
                "Expected 5xx for source=" + index + ", got " + expected.getResponse().getStatusLine().getStatusCode(),  
                    + ". Known-bug guard: update the test if this is now fixed."
    // ── Numeric ───────────────────────────────────────────────────────────────────
        assertScanSucceeds("ft_ip_filters", 3);
        Map<String, Object> bulk = ingest("ft_date", "date", "\"1990-01-15\"", "\"1995-05-20\"", "\"1988-03-10\"");
        Map<String, Object> bulk = ingestWithMapping("ft_scaled_float", "scaled_float", ", \"scaling_factor\": 100", 19.99, 25.50, 99.00);  
        Map<String, Object> resp = assertOkAndParse(client().performRequest(create), "Create index " + index);
    }  
                + " AND cidrmatch(val, '0.0.0.0/0')",
    private static String[] asJsonArray(Object... values) {
        // half_float lands as Arrow Float16. OpenSearchSchemaBuilder maps it to REAL and  
    private Map<String, Object> bulkRaw(String index, String[] jsonValues) throws IOException {
            + "\"mappings\": {"
            assertTrue(
     */  
    // ── Phase 1: Ingest ──────────────────────────────────────────────────────────  
    }
            "source=ft_ip_project | eval cls=case(val='192.168.1.1','a',val='10.0.0.1','b',true,'c')",  
    /**  
            + "  }"  
        Map<String, Object> bulk = ingest("ft_integer", "integer", 1000, 2000, 3000);
    }
import org.opensearch.client.ResponseException;  
        // AND-combination exercises the flatten guard in OpenSearchFilter.stripAnnotations
     *  
            "\"1990-01-15T10:00:00.123456789Z\"",  
            "Type [" + type + "] unexpectedly succeeded at ingest. Known-bug guard: update the test if this is now fixed.",  
/*  
     * fail and prompt the test to be flipped to {@link #assertScanSucceeds}.
    }
    }
    /**
    }  
     * returning the parsed response.
        for (int i = 0; i < expectedSorted.length; i++) {  
            "ft_date_nanos",
    // ── Phase 2: Query assertions ────────────────────────────────────────────────
     * the field definition (e.g. {@code ", \"scaling_factor\": 100"} for {@code scaled_float}).
        assertBulkSucceeded(bulk, "ft_float");
    }
    }
    }
        throws IOException {
        // literal that DataFusion compares natively). Filter coverage lives in testIpFilters
    }
 *       <li>{@link #assertBulkErrored} — {@code errors=true}. For types whose parquet writer throws.</li>
     */
    public void testIpAndBinaryProjectExpressions() throws IOException {
