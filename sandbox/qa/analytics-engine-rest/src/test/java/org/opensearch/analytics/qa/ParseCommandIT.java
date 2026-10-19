        // Parse adds new fields but does not strip the source — verify the projection
    public void testParseExtractsSingleNamedGroup() throws IOException {
        // Pattern requires "key" prefix; str1 is "CLAMP ON LAMPS" which doesn't
        // "CLAMP ON LAMPS" contains "CLAMP" but the full pattern requires more
    private void assertRowCount(String ppl, int expectedCount) throws IOException {
 * repository so the analytics-engine path can be verified inside core without a  
    // ── no-match semantics ─────────────────────────────────────────────────────
        return Arrays.asList(values);  
        assertRowCount(  
        // because PARSE itself isn't called. Document the contract here so a
            dataProvisioned = true;
 * this file be licensed under the Apache-2.0 license or a
     */  
    }
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
        } catch (IOException e) {  
            "source=" + DATASET.indexName + " | parse key 'key(?<num>\\d+)' | fields num",
        );
    }
    public void testParseExtractsTwoNamedGroupsFromString() throws IOException {  
            row("")  
            assertEquals(
                body = e.getMessage();  
import org.opensearch.client.ResponseException;  
package org.opensearch.analytics.qa;
        // can still see the source field alongside parsed groups in the same row.
    private void assertErrorContains(String ppl, String expectedSubstring) {  
                );  
 *
            row("")  
            "grok"  
        // only captures the digits.
    public void testParseNoMatchReturnsEmptyStringForGroup() throws IOException {
    private static boolean dataProvisioned = false;
        assertRows(
                    want.get(j),
                body = org.apache.hc.core5.http.io.entity.EntityUtils.toString(e.getResponse().getEntity());
        // Onboarding scope is regex-only today; grok and patterns must surface a
            String body;
import org.opensearch.client.Response;
            "source=" + DATASET.indexName + " | where str1='CLAMP ON LAMPS'"
        if (dataProvisioned == false) {  
        assertEquals("Row count mismatch for query: " + ppl, expectedCount, actualRows.size());  
            row("CLAMP", "ON LAMPS")
import java.util.List;
            assertTrue(
 * {@code patterns} methods too; the analytics backend currently rejects those
 * Self-contained integration test for the PPL {@code parse} command on the
            row("00")
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,  
 * at plan time via {@link org.opensearch.be.datafusion.ParseAdapter}. Tests in
 * the {@code parse} UDF returns a {@code map<utf8, utf8>} of all named groups,
     * Send a PPL query and assert the response's {@code rows} count matches
                + " | parse str1 'key(?<num>\\d+)'"
 * <p>The legacy / non-analytics PPL path supports {@code grok} and  
        // PPL's frontend short-circuits a parse with zero named groups: it adds
    }
            DatasetProvisioner.provision(client(), DATASET);
 * which runs the {@code UnifiedQueryPlanner} → {@code CalciteRelNodeVisitor} →  
                "Column count mismatch at row " + i + " for query: " + ppl,  
import java.util.Map;
        // Every row's key matches → every row's `num` field is non-empty. Cardinality  
    public void testParseLeavesOriginalFieldsUntouched() throws IOException {  
 * Rust side of the analytics backend.
    }  
            for (int j = 0; j < want.size(); j++) {
    }
 * is a deliberate flip rather than a silent semantics change.
                + " | fields word, rest",
        // source scan. The Rust UDF's "no named groups" guard never fires  
        // through to the legacy engine.  
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
            }
    public void testParseGrokMethodRejectedAtPlanTime() {  
        );
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
        );
                "Expected response body to contain [" + expectedSubstring + "] but was: " + body,  
 * and {@code item} extracts each value at projection time. Both UDFs sit on the  
        // count would still be 17, so we additionally assert a known value below).  
        // so the prefix "key" must be in the pattern even though the named group  
        // alone proves the map carried the expected key on each row (a missing
    // ── happy path: multiple named groups, single ITEM each ────────────────────
    }  
            }
        for (int i = 0; i < expected.length; i++) {
    private static List<Object> row(Object... values) {
    // ── error path: unsupported method ─────────────────────────────────────────
        // the entire string (whole-string anchoring); without the trailing `.+`
        );  
import org.opensearch.client.Request;
                + " | fields num",
 * Substrait → DataFusion pipeline.
            17
            "source=" + DATASET.indexName + " | parse str1 '%{WORD:w}' grok",
    @Override
            17  
     * Send a PPL query and assert each returned row equals the expected positional row.
 * The OpenSearch Contributors require contributions made to  
    }
    /**
 * SPDX-License-Identifier: Apache-2.0
     * {@code expectedCount}. Use this when only the cardinality matters.
    // ── pattern without named groups (no-op) ──────────────────────────────────
        Map<String, Object> response = executePpl(ppl);
                + " | fields key, num",  
            "source=" + DATASET.indexName + " | parse str1 '\\\\w+' | fields str1",
/**
                got.size()
        assertErrorContains(
    public void testParseWithoutNamedGroupsIsANoOp() throws IOException {  
        // than "(?<x>\\w+)" at the end — the rest of the input is unmatched, so  
        assertRowCount(
    @SuppressWarnings("varargs")
        // matches() fails and the group becomes "".
 * <p>Mirrors {@code CalciteParseCommandIT} from the {@code opensearch-project/sql}
import java.util.Arrays;  
                + " | parse str1 '(?<x>\\w+)'"
     * Send a PPL query expecting the planner to reject it; assert the error body  
        // the row would not match and both groups would be "".  
            } catch (Exception ioe) {
        }
     * {@link RegexCommandIT}'s pattern — {@code client()} is unavailable at static init.
        // extracts the trailing digits; verify we get the right value for one row.
        // clear plan-time error rather than reach the Rust UDF or silently fall
}
                    got.get(j)
        // Whole-string anchoring is enforced by the Rust UDF (Java matches() parity)
     */
        // calcs `key` is "key00".."key16". `(?<num>\d+)` after the literal "key"  
    public void testParsePartialMatchTreatedAsNoMatchUnderAnchor() throws IOException {
 */  
    public void testParseAcrossAllRowsProducesUniformSchema() throws IOException {
 */
 *
    /**  
 *
    private final void assertRows(String ppl, List<Object>... expected) throws IOException {
        assertRows(  
     */  
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
            List<Object> got = actualRows.get(i);
        }
    }  
 * <p>{@code parse <field> '<regex>'} lowers to one  
    /**  
        Map<String, Object> response = executePpl(ppl);  
        );
        }  
    }  
     */
     * contains {@code expectedSubstring}.
    }
 * compatible open source license.
            "source=" + DATASET.indexName + " | where key='key00'"  
                want.size(),
/*  
    /**  
        );  
        );
        @SuppressWarnings("unchecked")  
    }
            List<Object> want = expected[i];  
            "source=" + DATASET.indexName + " | where key='key01'"
    }
            "source=" + DATASET.indexName + " | where key='key00' | parse key 'key(?<num>\\d+)' | fields num",  
        assertRows(
    // ── helpers ────────────────────────────────────────────────────────────────  
        assertRows(
            row("key01", "01")
        // "CLAMP ON LAMPS" → word="CLAMP", rest="ON LAMPS". Pattern must match
 *
        // Rust UDF mirrors this — no_match → "" for every named group.
            "source=" + DATASET.indexName + " | where str1='CLAMP ON LAMPS'"  
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);  
        try {
    @SafeVarargs  
 * analytics-engine route.  
                body.contains(expectedSubstring)
    protected void onBeforeQuery() throws IOException {
        // match. Java RegexExpression behaviour: matches() fails → ExprStringValue("").  
            fail("Unexpected IOException: " + e);
 * the {@code rejects_*} cluster pin that contract so a future grok onboarding  
        @SuppressWarnings("unchecked")
    }
import java.io.IOException;
                + " | parse key 'key(?<num>\\d+)'"
                assertEquals(
            );  
    /** Send {@code POST /_plugins/_ppl} and return the parsed JSON body. */
public class ParseCommandIT extends AnalyticsRestTestCase {  
            try {  
 * {@code ITEM(PARSE(field, regex, "regex"), "<group>")} call per named group:
        // no per-group ITEM projections, so the query degenerates into a plain
            );
                + " | fields x",
        // future PPL-side change to invoke parse anyway is caught explicitly.
 * cross-plugin dependency on the SQL plugin. Each test sends a PPL query through
    // ── happy path: single named group, key field ──────────────────────────────  
 * {@code POST /_plugins/_ppl} (exposed by the {@code opensearch-sql} plugin),
            Map<String, Object> response = executePpl(ppl);
            fail("Expected query to fail with [" + expectedSubstring + "] but got response: " + response);  
        // `num` group would produce "" via the parse UDF's no-match branch and the
     * Lazily provision the calcs dataset on first invocation. Mirrors
                + " | parse str1 '(?<word>\\w+)\\s+(?<rest>.+)'"  
        );
        assertRows(
        } catch (ResponseException e) {
