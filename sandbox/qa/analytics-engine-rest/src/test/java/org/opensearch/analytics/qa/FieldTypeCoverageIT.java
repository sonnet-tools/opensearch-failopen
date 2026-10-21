            + "  }"
    public void testByte() throws IOException {
        // Test values stay below 2^63 - 1 because BIGINT is signed; values above wrap.
            } else {
    public void testIp() throws IOException {
        return sb.toString();
        // half_float lands as Arrow Float16. OpenSearchSchemaBuilder maps it to REAL and
            + "    \"name\": { \"type\": \"keyword\" },"
        Map<String, Object> ipBulk = ingest("ft_ip_project", "ip", "\"192.168.1.1\"", "\"10.0.0.1\"", "\"172.16.0.1\"");
 * compatible open source license.
            + "  \"index.pluggable.dataformat.enabled\": true,"
        assertBulkSucceeded(bulk, "ft_match_only_text");
     */
    /**
     * {@code ingest(idx, type, "...string-value...", ...)} would otherwise bind to the
        assertFilterRowCount("source=ft_ip_filters | where val > '10.0.0.50'", 2);
            + "  \"index.composite.primary_data_format\": \"parquet\","
        for (int i = 0; i < jsonValues.length; i++) {
    private Map<String, Object> ingest(String index, String type, Object... values) throws IOException {
    }
        return "{"
     */
    }
public class FieldTypeCoverageIT extends AnalyticsRestTestCase {
        bulk.setJsonEntity(body.toString());
    }
        Map<String, Object> resp = executePpl(ppl);
        Map<String, Object> bulk = ingest("ft_double", "double", 47.6, 45.5, 52.1);
     * success ({@link #assertBulkSucceeded}) or failure ({@link #assertBulkErrored}).
    }
/**
     * column never lands in parquet (e.g. match_only_text has no parquet writer). When
            "ft_match_only_text",
    public void testDate() throws IOException {
        assertFilterRowCount("source=ft_ip_filters | where val between '10.0.0.0' and '10.255.255.255'", 1);
    public void testMatchOnlyText() throws IOException {
    }
     */
    }
/*
            + "},"
        String mapping = "\"val\": { \"type\": \"" + type + "\"" + extraMappingJson + " }";
        assertBulkSucceeded(bulk, "ft_ip");
        assertBulkSucceeded(bulk, "ft_date");
    /**
    // ── Text / keyword ────────────────────────────────────────────────────────────
            "source=ft_ip_filters | where val > '10.0.0.0' AND val < '200.0.0.0'"
    }
        assertBulkSucceeded(bulk, "ft_integer");
        assertBulkSucceeded(bulk, "ft_half_float");
            "ft_date_nanos",
        List<List<Object>> rows = (List<List<Object>>) resp.get("datarows");
            "date_nanos",
     * that exercise filter / aggregation shapes (e.g. {@link #testIpFilters}) where the
        assertBulkSucceeded(bulk, "ft_binary");
        assertScanSucceeds("ft_date", 3);
    private static String rowName(int i) {
            "\"1988-03-10T12:00:00.111222333Z\""
     * must be in ascending order to match the {@code | sort val} we issue.
            client().performRequest(new Request("DELETE", "/" + index));
        }
        assertBulkSucceeded(bulk, "ft_text");
        @SuppressWarnings("unchecked")
        Map<String, Object> bulk = ingest("ft_integer", "integer", 1000, 2000, 3000);
    }
    /**
        StringBuilder sb = new StringBuilder();
            "ft_unsigned_long",
        return assertOkAndParse(client().performRequest(bulk), "Bulk " + index);
    public void testInteger() throws IOException {
    private static String createBody(String index, String valMappingFragment) {
            }
            Response resp = client().performRequest(req);
     *   <li>{@code cidrmatch} — exercised the inline expansion in
        return bulkRaw(index, asJsonArray(values));
    /**
        assertEquals(
            + "  \"index.composite.secondary_data_formats\": [\"lucene\"]"
    }
        // — binary columns share the same code path.
        assertScanSucceeds("ft_ip_filters", 3);
    // ── Temporal ─────────────────────────────────────────────────────────────────
            + "  \"index.pluggable.dataformat\": \"composite\","
            "Type [" + type + "] unexpectedly succeeded at ingest. Known-bug guard: update the test if this is now fixed.",
            + "  \"number_of_replicas\": 0,"
    private Map<String, Object> bulkRaw(String index, String[] jsonValues) throws IOException {
        }
        assertFilterRowCount("source=ft_ip_project | eval is_local=if(val='192.168.1.1','y','n')", 3);
        );
        assertFilterRowCount("source=ft_ip_filters | where cidrmatch(val, '10.0.0.0/8')", 1);
            body.append("{\"name\":\"").append(rowName(i)).append("\",\"val\":").append(jsonValues[i]).append("}\n");
        assertFilterRowCount("source=ft_ip_project | stats count(eval(val='192.168.1.1')) as cnt", 1);
     * End-to-end coverage of filter / aggregation shapes against an {@code ip} column.
    public void testText() throws IOException {
        List<List<Object>> rows = (List<List<Object>>) resp.get("datarows");
     * column, so this catches per-column read-path bugs that {@code count()} misses.
            fail(
    // ── Phase 2: Query assertions ────────────────────────────────────────────────
        );
    /** Convert each value to its JSON literal form. Strings get wrapped in quotes unless already pre-quoted. */
            assertTrue(
            + "  \"number_of_shards\": 1,"
        }
     *       for VARBINARY ⇄ VARCHAR.</li>
        assertEquals(expectedSorted.length, rows.size());
}
                    + resp.getStatusLine().getStatusCode()
        Map<String, Object> bulk = ingestWithMapping("ft_binary", "binary", ", \"store\": true", "\"YWxpY2U=\"", "\"Ym9i\"", "\"Y2Fyb2w=\"");
        assertScanSucceeds("ft_date_nanos", 3);
        assertBulkSucceeded(ipBulk, "ft_ip_project");
        try {
        for (int i = 0; i < values.length; i++) {
     * the field definition (e.g. {@code ", \"scaling_factor\": 100"} for {@code scaled_float}).
        assertFilterRowCount(
    /**
 *       <li>{@link #assertBulkSucceeded} — {@code errors=false} and flush. Use first when ingest is expected to succeed.</li>
        do {
        assertScanSucceeds("ft_scaled_float", 3);
 * PPL read path. One test method per OpenSearch mapping type the sandbox targets.
        assertFilterRowCount("source=ft_ip_filters | where val != '192.168.1.1'", 2);
                    + ". Known-bug guard: update the test if this is now fixed."
 */
    public void testLong() throws IOException {
    }
     * {@code expectedSorted} within fp16 precision (~3 decimal digits). {@code expectedSorted}
        // inserts the IEEE half→single cast per batch on read.
        Map<String, Object> bulk = ingest("ft_short", "short", 100, 200, 300);
            "tls handshake error"
        Map<String, Object> bulk = ingest("ft_float", "float", 47.6, 45.5, 52.1);
     *       {@code BinaryFunctionAdapter}.</li>
     *       {@code OpenSearchFilter.stripAnnotations}.</li>
     * Project a {@code half_float} column, sort numerically, and assert each value matches
 * Per-type coverage test for composite-engine + parquet indexing and the analytics-engine
     * extra-mapping overload — Java picks {@code String} over {@code Object} as more specific
        final double tolerance = 0.05;
        assertFilterRowCount("source=ft_ip_filters | where cidrmatch(val, '0.0.0.0/0')", 3);
            Object v = values[i];
        // Calcite TIMESTAMP is millisecond-precision.
            );
            // Transport-level error — also counts as "scan failed".
        assertScanSucceeds("ft_match_only_text", 3);
        assertNotNull("source=" + index + " response missing rows", rows);
        @SuppressWarnings("unchecked")
package org.opensearch.analytics.qa;
        assertBulkSucceeded(bulk, "ft_double");
    // ── Numeric ───────────────────────────────────────────────────────────────────
            sb.insert(0, (char) ('a' + (i % 26)));
    }
     * bulk response without asserting on it — the caller decides whether to expect
            + "}"
        assertScanSucceeds("ft_short", 3);
import org.opensearch.client.Request;
     */
 *     </ul>
            i = i / 26 - 1;
    }
        );
    /** Generate a stable row name for index i: a, b, …, z, aa, ab, … */
    private void assertBulkErrored(Map<String, Object> bulkResponse, String type) {
        assertBulkSucceeded(bulk, "ft_ip_filters");
    private void flush(String index) throws IOException {
        Map<String, Object> bulk = ingest("ft_ip", "ip", "\"192.168.1.1\"", "\"10.0.0.1\"", "\"172.16.0.1\"");
 * The OpenSearch Contributors require contributions made to
     * </ul>
            double got = ((Number) rows.get(i).get(0)).doubleValue();
import java.io.IOException;
    }
        Map<String, Object> resp = executePpl("source=" + index + " | sort val | fields val");
        assertFilterRowCount("source=ft_ip_filters | where NOT cidrmatch(val, '192.168.0.0/16')", 2);
            "match_only_text",
        assertBulkSucceeded(bulk, "ft_long");
     * {@code case(col=lit, …)}, and {@code count(eval(col=lit))} all lower to a
     * Bare {@code source=<index>} scan must return {@code expected} rows. Materializes every
        assertScanSucceeds("ft_keyword", 3);
        // bytes. Filter / aggregation coverage on `ip` columns is in testIpFilters.
        // schema_coerce widens Float16 → Float32 before substrait binds; SchemaAdapter
import java.util.List;
 *   </li>
        Map<String, Object> resp = assertOkAndParse(client().performRequest(create), "Create index " + index);
        assertBulkSucceeded(bulk, "ft_date_nanos");
     */
        assertFilterRowCount("source=ft_binary_project | stats count(eval(val='YWxpY2U=')) as c", 1);
        assertEquals(Boolean.TRUE, resp.get("acknowledged"));
        Map<String, Object> bulk = ingest("ft_boolean", "boolean", true, false, true);
            bulkResponse.get("errors")
        // Scan binds as TIMESTAMP. Sub-millisecond precision is silently truncated because
        assertScanSucceeds("ft_unsigned_long", 3);
            23456789012345678L,
    public void testShort() throws IOException {
    }
    /**
            "dns lookup failed",
                expected.getResponse().getStatusLine().getStatusCode() >= 500
        assertFilterRowCount(
    // ── Other ────────────────────────────────────────────────────────────────────
        // schema_coerce::coerce_for_substrait. Predicates on binary columns now work via the
        assertBulkSucceeded(bulk, "ft_float");
        Map<String, Object> bulk = ingest("ft_byte", "byte", 1, 2, 3);
     * Project-side coverage of {@code BinaryFunctionAdapter}. PPL {@code eval if(col=lit, …)},
    }
        // literal that DataFusion compares natively). Filter coverage lives in testIpFilters
    private void assertBulkSucceeded(Map<String, Object> bulkResponse, String index) throws IOException {
        assertScanSucceeds("ft_text", 3);
    }
        return out;
     *   <li>{@code =} — comparator with VARBINARY column + VARCHAR literal, expanded via
        Map<String, Object> binBulk = ingestWithMapping("ft_binary_project", "binary", ", \"store\": true", "\"YWxpY2U=\"", "\"Ym9i\"", "\"Y2Fyb2w=\"");
     */
                "Expected source=" + index + " to fail, got status "
        Request req = new Request("POST", "/_plugins/_ppl");
    private void assertScanSucceeds(String index, int expected) throws IOException {
            "source=ft_ip_project | eval cls=case(val='192.168.1.1','a',val='10.0.0.1','b',true,'c')",
        assertFilterRowCount("source=ft_ip_filters | where val in ('192.168.1.1', '10.0.0.1')", 2);
            body.append("{\"index\":{}}\n");
        Map<String, Object> bulk = ingest("ft_keyword", "keyword", "alice", "bob", "carol");
                String s = (String) v;
        Map<String, Object> resp = executePpl("source=" + index);
    public void testKeyword() throws IOException {
    }
        );
        Map<String, Object> bulk = ingest(
    }
    private void assertScanFails(String index) {
        assertScanSucceeds("ft_binary", 3);
    private void createIndex(String index, String body) throws IOException {
import org.opensearch.client.ResponseException;
        assertFilterRowCount("source=ft_ip_filters | where val < '172.16.0.1'", 1);
 * this file be licensed under the Apache-2.0 license or a
        assertFilterRowCount("source=ft_ip_filters | where cidrmatch(val, '192.168.0.0/16')", 1);
    // ── Phase 1: Ingest ──────────────────────────────────────────────────────────
        assertFilterRowCount("source=ft_ip_project | where val='192.168.1.1' | fields val", 1);
        } catch (ResponseException ignored) {
        Map<String, Object> bulk = ingest(
        );
    public void testBinary() throws IOException {
    }
        assertScanSucceeds("ft_long", 3);
     * The fragment must be a leading-comma-prefixed JSON snippet or empty.
     *   <li>{@code BETWEEN} — same {@code leastRestrictive} path with a 3-arg shape.</li>
 *     <ul>
        Map<String, Object> bulk = ingestWithMapping("ft_scaled_float", "scaled_float", ", \"scaling_factor\": 100", 19.99, 25.50, 99.00);
        assertEquals("Expected bulk ingest to succeed for [" + index + "]", Boolean.FALSE, bulkResponse.get("errors"));
            "\"1990-01-15T10:00:00.123456789Z\"",
            "\"1995-05-20T11:00:00.987654321Z\"",
    }
    public void testIpFilters() throws IOException {
        // expose the *scaled* long, not the original float.
        Map<String, Object> bulk = ingest("ft_ip_filters", "ip", "\"192.168.1.1\"", "\"10.0.0.1\"", "\"172.16.0.1\"");
        // Be forgiving of leftover state from previous runs (preserveIndicesUponCompletion = true).
    /**
 *       <li>{@link #assertScanSucceeds} — bare {@code source=<index>} scan; materializes every column.</li>
     */
     *       {@code ExtendedRexBuilder.makeCast} to {@code BINARY(varchar)} and resolved by
    /**
    }
     * Runs a PPL query and asserts the row count matches {@code expected}. Used by tests
        assertBulkSucceeded(binBulk, "ft_binary_project");
        create.setJsonEntity(body);
 * <p>Each test is a two-phase script:
 * SPDX-License-Identifier: Apache-2.0
                + " AND cidrmatch(val, '0.0.0.0/0')",
            assertEquals("row " + i, expectedSorted[i], got, tolerance);
    /**
        // Scan binds as BIGINT (storage is Int64). Projections / predicates / aggregates
        bulk.setOptions(bulk.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
        // schema_coerce::coerce_for_substrait. Projections return raw 16-byte IPv6-mapped
 *       the raw bulk response without asserting on it.</li>
     * <p>Distinct method name (rather than another {@code ingest} overload) because
    public void testDateNanos() throws IOException {
        assertBulkSucceeded(bulk, "ft_keyword");
    }
        assertScanSucceeds("ft_ip", 3);
 * <ol>
     * Variant of {@link #ingest} that lets the caller inject extra mapping properties into
     * row count is the meaningful signal.
     *       {@code PPLFuncImpTable.populate} that rewrites cidr literals into byte-range AND.</li>
        assertFilterRowCount("source=ft_ip_filters | where val = '192.168.1.1'", 1);
    public void testBoolean() throws IOException {
        assertBulkSucceeded(bulk, "ft_scaled_float");
 *
        List<List<Object>> rows = (List<List<Object>>) resp.get("datarows");
        assertBulkSucceeded(bulk, "ft_short");
            );
    }
        Map<String, Object> bulk = ingest(
        Map<String, Object> bulk = ingest("ft_long", "long", 100000000L, 200000000L, 300000000L);
    private static String[] asJsonArray(Object... values) {
    public void testIpAndBinaryProjectExpressions() throws IOException {
            + "    " + valMappingFragment
     * Bulk response must report {@code errors=true}. For types where the primary writer's
        assertBulkSucceeded(bulk, "ft_boolean");
        );
            3
    public void testUnsignedLong() throws IOException {
    }
            Boolean.TRUE,
     * Each predicate shape exercises a different code path:
        Map<String, Object> bulk = ingest("ft_half_float", "half_float", 47.6, 45.5, 52.1);
        // Scan binds as VARBINARY; the BinaryView → Binary rewrite happens in
     */
     */
    public void testScaledFloat() throws IOException {
        bulk.addParameter("refresh", "true");
 *       <li>{@link #assertScanFails} — bare scan must throw. Known-bug guard for types DataFusion can't materialize.</li>
     *
        assertScanSucceeds("ft_half_float", 3);
        flush(index);
        assertHalfFloatProjectedValues("ft_half_float", new double[] { 45.5, 47.6, 52.1 });
        // BINARY(varchar) placeholder (BinaryFunctionAdapter rewrites it into a VARBINARY
     * returning the parsed response.
        @SuppressWarnings("unchecked")
     * sealed before any subsequent scan assertion runs.
     * <ul>
     * the project tree above an aggregate).
        for (int i = 0; i < expectedSorted.length; i++) {
        req.setJsonEntity("{\"query\": \"source=" + index + "\"}");
        assertBulkSucceeded(bulk, "ft_unsigned_long");
        String[] out = new String[values.length];
    private void assertHalfFloatProjectedValues(String index, double[] expectedSorted) throws IOException {
            3
     * — silently eating the first row value as a mapping fragment.
                "Expected 5xx for source=" + index + ", got " + expected.getResponse().getStatusLine().getStatusCode(),
        Map<String, Object> bulk = ingest("ft_date", "date", "\"1990-01-15\"", "\"1995-05-20\"", "\"1988-03-10\"");
        } while (i >= 0);
    }
     * {@code BINARY('lit':VARCHAR)} placeholder inside a {@code LogicalProject} (or a CASE in
     * {@code ParquetField} throws (byte, half_float).
     */
        assertBulkSucceeded(bulk, "ft_byte");
    // ── Lower-level helpers ──────────────────────────────────────────────────────
            if (v instanceof String) {
        assertScanSucceeds("ft_byte", 3);
     * Fire an N-doc bulk with sequential names {@code a, b, c, …} and {@code val=jsonValues[i]},
     */
     * Bulk response must report {@code errors=false}. Flushes so the parquet rowgroup is
        client().performRequest(new Request("POST", "/" + index + "/_flush?force=true"));
        // (>= 4 conjuncts after SARG/cidr expansion).
 *   <li><b>Assertion phase</b> — one or more of:
        assertScanSucceeds("ft_boolean", 3);
     * Create a single-field index and post N docs (named a/b/c/...). Returns the parsed
    public void testDouble() throws IOException {
    }
 *       <li>{@link #assertBulkErrored} — {@code errors=true}. For types whose parquet writer throws.</li>
 */
import org.opensearch.client.Response;
        }
        // AND-combination exercises the flatten guard in OpenSearchFilter.stripAnnotations
            "timeout on socket",
    public void testHalfFloat() throws IOException {
        Request bulk = new Request("POST", "/" + index + "/_bulk");
        assertFilterRowCount("source=ft_binary_project | eval is_alice=if(val='YWxpY2U=','y','n')", 3);
            // expected on first run
        }
        assertEquals("source=" + index + " row count", expected, rows.size());
        } catch (ResponseException expected) {
    }
    /**
        try {
    }
        return ingestWithMapping(index, type, "", values);
    }
     *   <li>{@code AND}-combination — exercised the {@code RexUtil.flatten} guard in
        // Scan binds as VARBINARY; the BinaryView → Binary rewrite happens in
            + "}";
        } catch (IOException io) {
     * fail and prompt the test to be flipped to {@link #assertScanSucceeds}.
    }
    }
    }
                out[i] = s.startsWith("\"") ? s : "\"" + s + "\"";
        assertScanSucceeds("ft_float", 3);
        assertScanSucceeds("ft_double", 3);
            + "\"settings\": {"
        createIndex(index, createBody(index, mapping));
        Request create = new Request("PUT", "/" + index);
        assertScanSucceeds("ft_integer", 3);
 *
        StringBuilder body = new StringBuilder();
        Map<String, Object> bulk = ingest("ft_text", "text", "connection refused", "host unreachable", "peer reset");
            + "  \"properties\": {"
    public void testFloat() throws IOException {
            "unsigned_long",
            + "\"mappings\": {"
     *   <li>{@code IN} — exercised the {@code OpenSearchTypeFactory.leastRestrictive} override
     * the underlying gap is closed and the scan starts succeeding, this assertion will
    private Map<String, Object> ingestWithMapping(String index, String type, String extraMappingJson, Object... values)
            12345678901234567L,
                out[i] = String.valueOf(v);
     * Bare {@code source=<index>} scan must throw. Known-bug guard for types where the
    }
 *   <li><b>Ingest phase</b> — {@link #ingest} creates the index, posts N docs, and returns
    private void assertFilterRowCount(String ppl, int expected) throws IOException {
import java.util.Map;
     *   <li>{@code !=}, {@code >} — same path, different comparator.</li>
 * </ol>
            34567890123456789L
        assertEquals("[" + ppl + "] row count", expected, rows.size());
        throws IOException {
        assertNotNull("[" + ppl + "] response missing rows", rows);
    /**
