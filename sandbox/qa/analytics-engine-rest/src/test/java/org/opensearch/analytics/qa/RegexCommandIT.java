        // 17 total rows, 2 are FURNITURE → 15 pass when negated.
    }
        );
        @SuppressWarnings("unchecked")
     * many rows whose ordering would be brittle to assert exhaustively).
                assertEquals(
     */
                want.size(),
    public void testRegexpMatchInEvalAllTrue() throws IOException {
 * function on the analytics-engine route.
        );
    private void assertRowCount(String ppl, int expectedCount) throws IOException {
        Map<String, Object> response = executePpl(ppl);
        }
        }
    /**
    public void testRegexContainsSubstring() throws IOException {
    @SafeVarargs
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
            row("CLAMP ON LAMPS", true),
     * {@code FillNullCommandIT} pattern — {@code client()} is unavailable at static init.
    public void testRegexAnchoredStart() throws IOException {
    }
    }
    @SuppressWarnings("varargs")
 *       (negated form: wrapped in {@code NOT})</li>
import org.opensearch.client.Request;
        @SuppressWarnings("unchecked")
        // Project the boolean result alongside the source field — verifies REGEXP_CONTAINS
    private void assertErrorContains(String ppl, String expectedSubstring) {
    }
                    got.get(j)
        assertRowCount(
        } catch (IOException e) {
    // ── error path: regex on non-string field ──────────────────────────────────
        // str0 has 2 rows with "FURNITURE", 6 with "OFFICE SUPPLIES", 9 with "TECHNOLOGY".
     * Send a PPL query expecting the planner to reject it; assert the error body contains
    public void testRegexWildcardPattern() throws IOException {
    }
    // ── helpers ────────────────────────────────────────────────────────────────
            "Regex command requires field of string type"
        // ^TECH anchors to start: only TECHNOLOGY (×9), not strings containing TECH elsewhere.
import java.util.Map;
 */
            "source=" + DATASET.indexName + " | regex num0='1.*'",
            );
                body = org.apache.hc.core5.http.io.entity.EntityUtils.toString(e.getResponse().getEntity());
    private static boolean dataProvisioned = false;
        }
                body.contains(expectedSubstring)
        assertRows(
    public void testRegexNegated() throws IOException {
            Map<String, Object> response = executePpl(ppl);
        );
    }
 * {@code CalciteRelNodeVisitor} → Substrait → DataFusion pipeline.
import org.opensearch.client.ResponseException;
        assertRowCount("source=" + DATASET.indexName + " | regex str0='FURNITURE' | fields str0", 2);
 * the SQL plugin. Each test sends a PPL query through {@code POST /_plugins/_ppl} (exposed by the
            }
 *   <li>{@code eval m = regexp_match(field, pat)} — emits a project-side
 * {@code opensearch-sql} plugin), which runs the same {@code UnifiedQueryPlanner} →
 * <p>Mirrors {@code CalciteRegexCommandIT} from the {@code opensearch-project/sql} repository so
        return Arrays.asList(values);
 *
     * Use this when only the cardinality matters (e.g. matching against a regex that returns
     */
package org.opensearch.analytics.qa;
 * that the analytics-engine path can be verified inside core without cross-plugin dependencies on
        assertRowCount("source=" + DATASET.indexName + " | regex str0!='FURNITURE' | fields str0", 15);
            }
                + " | eval m = regexp_match(str0, 'TECH') | where m=true | fields str0",
    }
    }
    /**
 * <p>Provisions the {@code calcs} dataset (parquet-backed) once per class via
            assertEquals(
        assertRowCount("source=" + DATASET.indexName + " | regex str0!='^OFFICE' | fields str0", 11);
    public void testRegexpMatchProducesBooleanColumn() throws IOException {
    }
        assertErrorContains(
        assertRowCount("source=" + DATASET.indexName + " | regex str0='OGY$' | fields str0", 9);
    // ── command form: full row content check ────────────────────────────────────
 * this file be licensed under the Apache-2.0 license or a
    }
 * <p>Both surfaces lower to Calcite {@code SqlLibraryOperators.REGEXP_CONTAINS}:
 * <ul>
        assertRowCount("source=" + DATASET.indexName + " | regex str1='BINDER' | fields str1", 2);
            "source=" + DATASET.indexName
    public void testRegexOnNumericFieldErrors() {
    private static List<Object> row(Object... values) {
                "Column count mismatch at row " + i + " for query: " + ppl,
    private final void assertRows(String ppl, List<Object>... expected) throws IOException {
 *
            row("CLOCKS", false)
            row("FURNITURE", "CLOCKS")
    protected void onBeforeQuery() throws IOException {
 * compatible open source license.
            DatasetProvisioner.provision(client(), DATASET);
    public void testRegexAnchoredEnd() throws IOException {
        // round-trips through Substrait → DataFusion as a project-side BOOLEAN expression.
/**
    public void testRegexpMatchInEvalSelective() throws IOException {
}
            String body;
import org.opensearch.client.Response;
        // Verify the actual matched values, not just count, for the FURNITURE selection.
            List<Object> got = actualRows.get(i);
 * keeps it across test methods.
        assertRowCount("source=" + DATASET.indexName + " | regex str0='OFFICE' | fields str0", 6);
import java.util.List;
            fail("Unexpected IOException: " + e);
    }
     */
        try {
    }
public class RegexCommandIT extends AnalyticsRestTestCase {
        assertEquals("Row count mismatch for query: " + ppl, expectedCount, actualRows.size());
            } catch (Exception ioe) {
        assertRowCount("source=" + DATASET.indexName + " | regex str1='BINDING' | fields str1", 2);
        );
        assertRowCount(
        if (dataProvisioned == false) {
    public void testRegexNegatedAnchored() throws IOException {
    /**
    @Override
 * Self-contained integration test for the PPL {@code regex} command and {@code regexp_match()}
        Map<String, Object> response = executePpl(ppl);
            fail("Expected query to fail with [" + expectedSubstring + "] but got response: " + response);
        // a numeric field must fail the preflight type check, not reach DataFusion.
 *
     * Lazily provision the calcs dataset on first invocation. Mirrors the
 *
    }
            try {
        for (int i = 0; i < expected.length; i++) {
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
        );
    // ── command form: negated match ─────────────────────────────────────────────
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
     * Send a PPL query and assert the response's {@code rows} count matches {@code expectedCount}.
            dataProvisioned = true;
 *       {@code REGEXP_CONTAINS(field, pat)} returning BOOLEAN</li>
        // regexp_match returns BOOLEAN. Pattern that matches every str0 value.
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
            );
 *   <li>{@code | regex field='pat'} — emits {@code Filter(REGEXP_CONTAINS(field, pat))}
    // ── command form: positive match ────────────────────────────────────────────
        // BINDER appears in BINDER ACCESSORIES + BINDER CLIPS (2 rows).
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
    }
    public void testRegexCharacterClass() throws IOException {
            "source=" + DATASET.indexName
        } catch (ResponseException e) {
 * The OpenSearch Contributors require contributions made to
/*
        // CalciteRelNodeVisitor.visitRegex enforces SqlTypeFamily.CHARACTER on the field —
 */
                body = e.getMessage();
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
    }
        assertRows(
                + " | eval m = regexp_match(str0, '.*') | where m=true | fields str0",
     * Send a PPL query and assert each returned row equals the expected positional row.
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
        // regexp_match selects rows whose str0 contains 'TECH' — TECHNOLOGY ×9.
     * {@code expectedSubstring}.
    }
     */
        // REGEXP_CONTAINS — pattern matches anywhere in the field, not anchored.
            9
 * SPDX-License-Identifier: Apache-2.0
    }
        // OGY$ anchors to end: TECHNOLOGY (×9).
            assertTrue(
import java.io.IOException;
    public void testRegexExactMatchOnKeyword() throws IOException {
 * {@link DatasetProvisioner}; {@link AnalyticsRestTestCase#preserveIndicesUponCompletion()}
            List<Object> want = expected[i];
            "source=" + DATASET.indexName
                );
    }
    public void testRegexExpectedRowsForFurniture() throws IOException {
            for (int j = 0; j < want.size(); j++) {
        // Negate ^OFFICE: 17 - 6 = 11 rows.
 * </ul>
import java.util.Arrays;
            17
        // [BC]INDING matches BINDING (BINDING MACHINES, BINDING SUPPLIES) but not BUSINESS.
            row("FURNITURE", "CLAMP ON LAMPS"),
            "source=" + DATASET.indexName + " | regex str0='FURNITURE' | fields str0, str1 | sort str1",
    // ── function form: regexp_match in eval projection (BOOLEAN result) ────────
        assertRowCount("source=" + DATASET.indexName + " | regex str0='^TECH' | fields str0", 9);
                got.size()
                + " | regex str0='FURNITURE' | eval m = regexp_match(str1, 'CLAMP') | fields str1, m | sort str1",
                    want.get(j),
    /** Send {@code POST /_plugins/_ppl} and return the parsed JSON body. */
                "Expected response body to contain [" + expectedSubstring + "] but was: " + body,
    /**
