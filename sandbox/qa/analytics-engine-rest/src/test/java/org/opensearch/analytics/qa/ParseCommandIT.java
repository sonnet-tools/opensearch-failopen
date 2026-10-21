     * contains {@code expectedSubstring}.
package org.opensearch.analytics.qa;
    public void testParseLeavesOriginalFieldsUntouched() throws IOException {
                body = e.getMessage();
 * the {@code parse} UDF returns a {@code map<utf8, utf8>} of all named groups,
        // "CLAMP ON LAMPS" → word="CLAMP", rest="ON LAMPS". Pattern must match
        // clear plan-time error rather than reach the Rust UDF or silently fall
        // source scan. The Rust UDF's "no named groups" guard never fires
        );
                want.size(),
 * Self-contained integration test for the PPL {@code parse} command on the
        );
                    got.get(j)
        // count would still be 17, so we additionally assert a known value below).
    }
                "Expected response body to contain [" + expectedSubstring + "] but was: " + body,
    public void testParseWithoutNamedGroupsIsANoOp() throws IOException {
            DatasetProvisioner.provision(client(), DATASET);
        );
        );
            "source=" + DATASET.indexName + " | where key='key00' | parse key 'key(?<num>\\d+)' | fields num",
        }
        // through to the legacy engine.
 * is a deliberate flip rather than a silent semantics change.
        Map<String, Object> response = executePpl(ppl);
            );
     */
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
        return Arrays.asList(values);
    public void testParseExtractsTwoNamedGroupsFromString() throws IOException {
     */
            }
}
        );
        @SuppressWarnings("unchecked")
        // Parse adds new fields but does not strip the source — verify the projection
    // ── error path: unsupported method ─────────────────────────────────────────
        // match. Java RegexExpression behaviour: matches() fails → ExprStringValue("").
    }
            row("00")
    }
            String body;
 * compatible open source license.
                + " | parse str1 '(?<x>\\w+)'"
        // calcs `key` is "key00".."key16". `(?<num>\d+)` after the literal "key"
    /** Send {@code POST /_plugins/_ppl} and return the parsed JSON body. */
 *
            Map<String, Object> response = executePpl(ppl);
        assertRows(
            );
        assertRows(
                + " | fields word, rest",
        // so the prefix "key" must be in the pattern even though the named group
 * this file be licensed under the Apache-2.0 license or a
    // ── happy path: multiple named groups, single ITEM each ────────────────────
    }
    // ── helpers ────────────────────────────────────────────────────────────────
        assertEquals("Row count mismatch for query: " + ppl, expectedCount, actualRows.size());
import java.util.Arrays;
            "source=" + DATASET.indexName + " | where key='key00'"
        // only captures the digits.
    // ── happy path: single named group, key field ──────────────────────────────
        assertRows(
 */
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
import org.opensearch.client.Request;
    public void testParseAcrossAllRowsProducesUniformSchema() throws IOException {
import java.util.List;
     * Send a PPL query and assert the response's {@code rows} count matches
                + " | fields num",
    @SafeVarargs
    }
    }
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
    }
 * analytics-engine route.
 * at plan time via {@link org.opensearch.be.datafusion.ParseAdapter}. Tests in
    }
        // Onboarding scope is regex-only today; grok and patterns must surface a
 * SPDX-License-Identifier: Apache-2.0
                + " | parse key 'key(?<num>\\d+)'"
    public void testParseGrokMethodRejectedAtPlanTime() {
 * The OpenSearch Contributors require contributions made to
 * Substrait → DataFusion pipeline.
            "source=" + DATASET.indexName + " | where str1='CLAMP ON LAMPS'"
                body = org.apache.hc.core5.http.io.entity.EntityUtils.toString(e.getResponse().getEntity());
    }
    /**
     * {@code expectedCount}. Use this when only the cardinality matters.
    @Override
 *
            List<Object> got = actualRows.get(i);
        // extracts the trailing digits; verify we get the right value for one row.
     */
    }
 * <p>{@code parse <field> '<regex>'} lowers to one
            fail("Unexpected IOException: " + e);
    public void testParseExtractsSingleNamedGroup() throws IOException {
        );
     * Send a PPL query and assert each returned row equals the expected positional row.
    }
import java.util.Map;
    }
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
                got.size()
        // the row would not match and both groups would be "".
            17
 *
        assertErrorContains(
    @SuppressWarnings("varargs")
/*
import java.io.IOException;
    public void testParsePartialMatchTreatedAsNoMatchUnderAnchor() throws IOException {
    private static List<Object> row(Object... values) {
            "source=" + DATASET.indexName + " | where key='key01'"
        // because PARSE itself isn't called. Document the contract here so a
 * Rust side of the analytics backend.
            }
    private void assertErrorContains(String ppl, String expectedSubstring) {
    }
    /**
            "source=" + DATASET.indexName + " | parse key 'key(?<num>\\d+)' | fields num",
        assertRows(
        // Rust UDF mirrors this — no_match → "" for every named group.
                + " | parse str1 'key(?<num>\\d+)'"
        assertRowCount(
        // `num` group would produce "" via the parse UDF's no-match branch and the
 * the {@code rejects_*} cluster pin that contract so a future grok onboarding
    public void testParseNoMatchReturnsEmptyStringForGroup() throws IOException {
 * {@code POST /_plugins/_ppl} (exposed by the {@code opensearch-sql} plugin),
        // can still see the source field alongside parsed groups in the same row.
        }
            dataProvisioned = true;
    private void assertRowCount(String ppl, int expectedCount) throws IOException {
/**
    private final void assertRows(String ppl, List<Object>... expected) throws IOException {
                + " | fields key, num",
 *
 * {@code ITEM(PARSE(field, regex, "regex"), "<group>")} call per named group:
        // Whole-string anchoring is enforced by the Rust UDF (Java matches() parity)
            row("")
        // Pattern requires "key" prefix; str1 is "CLAMP ON LAMPS" which doesn't
        for (int i = 0; i < expected.length; i++) {
            "source=" + DATASET.indexName + " | where str1='CLAMP ON LAMPS'"
        try {
        assertRowCount(
                assertEquals(
            "source=" + DATASET.indexName + " | parse str1 '%{WORD:w}' grok",
    private static boolean dataProvisioned = false;
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
                "Column count mismatch at row " + i + " for query: " + ppl,
                + " | parse str1 '(?<word>\\w+)\\s+(?<rest>.+)'"
    // ── no-match semantics ─────────────────────────────────────────────────────
        );
import org.opensearch.client.ResponseException;
            row("")
        // than "(?<x>\\w+)" at the end — the rest of the input is unmatched, so
                    want.get(j),
            "grok"
        );
            row("key01", "01")
                );
     */
            for (int j = 0; j < want.size(); j++) {
 * <p>Mirrors {@code CalciteParseCommandIT} from the {@code opensearch-project/sql}
 * and {@code item} extracts each value at projection time. Both UDFs sit on the
                body.contains(expectedSubstring)
 */
        // the entire string (whole-string anchoring); without the trailing `.+`
        }
        // future PPL-side change to invoke parse anyway is caught explicitly.
    /**
public class ParseCommandIT extends AnalyticsRestTestCase {
 * cross-plugin dependency on the SQL plugin. Each test sends a PPL query through
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
        // "CLAMP ON LAMPS" contains "CLAMP" but the full pattern requires more
     * Lazily provision the calcs dataset on first invocation. Mirrors
            assertTrue(
        // matches() fails and the group becomes "".
            fail("Expected query to fail with [" + expectedSubstring + "] but got response: " + response);
     * Send a PPL query expecting the planner to reject it; assert the error body
import org.opensearch.client.Response;
 * {@code patterns} methods too; the analytics backend currently rejects those
     * {@link RegexCommandIT}'s pattern — {@code client()} is unavailable at static init.
        Map<String, Object> response = executePpl(ppl);
        // no per-group ITEM projections, so the query degenerates into a plain
        @SuppressWarnings("unchecked")
            List<Object> want = expected[i];
 * repository so the analytics-engine path can be verified inside core without a
            17
        // PPL's frontend short-circuits a parse with zero named groups: it adds
        // alone proves the map carried the expected key on each row (a missing
        assertRows(
        // Every row's key matches → every row's `num` field is non-empty. Cardinality
        } catch (ResponseException e) {
            row("CLAMP", "ON LAMPS")
    /**
            } catch (Exception ioe) {
 * which runs the {@code UnifiedQueryPlanner} → {@code CalciteRelNodeVisitor} →
        } catch (IOException e) {
 * <p>The legacy / non-analytics PPL path supports {@code grok} and
            assertEquals(
    protected void onBeforeQuery() throws IOException {
            "source=" + DATASET.indexName + " | parse str1 '\\\\w+' | fields str1",
        if (dataProvisioned == false) {
                + " | fields x",
            try {
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
    // ── pattern without named groups (no-op) ──────────────────────────────────
