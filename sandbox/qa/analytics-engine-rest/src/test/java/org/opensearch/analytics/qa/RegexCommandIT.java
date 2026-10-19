 * <p>Both surfaces lower to Calcite {@code SqlLibraryOperators.REGEXP_CONTAINS}:
    // ── command form: positive match ────────────────────────────────────────────
import java.io.IOException;
    // ── function form: regexp_match in eval projection (BOOLEAN result) ────────  
import org.opensearch.client.Request;
        assertEquals("Row count mismatch for query: " + ppl, expectedCount, actualRows.size());
    }
                + " | eval m = regexp_match(str0, 'TECH') | where m=true | fields str0",  
            assertEquals(  
import java.util.Arrays;  
        // Verify the actual matched values, not just count, for the FURNITURE selection.
 * {@code CalciteRelNodeVisitor} → Substrait → DataFusion pipeline.  
 *
    }  
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
 */
 * SPDX-License-Identifier: Apache-2.0
        assertRowCount("source=" + DATASET.indexName + " | regex str1='BINDER' | fields str1", 2);
        } catch (ResponseException e) {
    /**  
/*  
    public void testRegexWildcardPattern() throws IOException {  
        return Arrays.asList(values);  
    public void testRegexNegatedAnchored() throws IOException {
 *       (negated form: wrapped in {@code NOT})</li>
            DatasetProvisioner.provision(client(), DATASET);  
                got.size()  
     */
                want.size(),
    protected void onBeforeQuery() throws IOException {
    @SuppressWarnings("varargs")
    }
import org.opensearch.client.ResponseException;  
 *  
import org.opensearch.client.Response;
    // ── helpers ────────────────────────────────────────────────────────────────  
    public void testRegexNegated() throws IOException {  
            }
    }  
 *   <li>{@code | regex field='pat'} — emits {@code Filter(REGEXP_CONTAINS(field, pat))}
                body = e.getMessage();
 * compatible open source license.
        assertRowCount("source=" + DATASET.indexName + " | regex str0!='FURNITURE' | fields str0", 15);
        // str0 has 2 rows with "FURNITURE", 6 with "OFFICE SUPPLIES", 9 with "TECHNOLOGY".
        // Project the boolean result alongside the source field — verifies REGEXP_CONTAINS  
    public void testRegexpMatchProducesBooleanColumn() throws IOException {
    }  
public class RegexCommandIT extends AnalyticsRestTestCase {
    /**  
        // regexp_match returns BOOLEAN. Pattern that matches every str0 value.  
    }
 * that the analytics-engine path can be verified inside core without cross-plugin dependencies on  
    }
        assertErrorContains(  
        assertRowCount("source=" + DATASET.indexName + " | regex str0='^TECH' | fields str0", 9);
        // Negate ^OFFICE: 17 - 6 = 11 rows.  
     * {@code FillNullCommandIT} pattern — {@code client()} is unavailable at static init.
            dataProvisioned = true;
            fail("Unexpected IOException: " + e);
        assertRowCount("source=" + DATASET.indexName + " | regex str0='OGY$' | fields str0", 9);  
     * Use this when only the cardinality matters (e.g. matching against a regex that returns
 *       {@code REGEXP_CONTAINS(field, pat)} returning BOOLEAN</li>
                body = org.apache.hc.core5.http.io.entity.EntityUtils.toString(e.getResponse().getEntity());
    public void testRegexExactMatchOnKeyword() throws IOException {
            row("CLAMP ON LAMPS", true),
package org.opensearch.analytics.qa;
        assertRowCount("source=" + DATASET.indexName + " | regex str0='OFFICE' | fields str0", 6);
 *
 * {@link DatasetProvisioner}; {@link AnalyticsRestTestCase#preserveIndicesUponCompletion()}
    public void testRegexExpectedRowsForFurniture() throws IOException {  
 * function on the analytics-engine route.  
import java.util.List;
/**
     * {@code expectedSubstring}.
        } catch (IOException e) {
            row("CLOCKS", false)  
            "source=" + DATASET.indexName
            }
        try {
     * Lazily provision the calcs dataset on first invocation. Mirrors the  
     */
    }
    }
                + " | regex str0='FURNITURE' | eval m = regexp_match(str1, 'CLAMP') | fields str1, m | sort str1",
 * <ul>  
    private void assertRowCount(String ppl, int expectedCount) throws IOException {
                assertEquals(  
 */  
    }  
        );
 * keeps it across test methods.  
    /** Send {@code POST /_plugins/_ppl} and return the parsed JSON body. */  
            } catch (Exception ioe) {  
            "source=" + DATASET.indexName  
    // ── error path: regex on non-string field ──────────────────────────────────
 * <p>Provisions the {@code calcs} dataset (parquet-backed) once per class via
        // BINDER appears in BINDER ACCESSORIES + BINDER CLIPS (2 rows).
        // CalciteRelNodeVisitor.visitRegex enforces SqlTypeFamily.CHARACTER on the field —
                );
 *   <li>{@code eval m = regexp_match(field, pat)} — emits a project-side  
    private static boolean dataProvisioned = false;  
        @SuppressWarnings("unchecked")
        }
            String body;  
    }  
    }
    }
 * The OpenSearch Contributors require contributions made to  
        // a numeric field must fail the preflight type check, not reach DataFusion.
            row("FURNITURE", "CLOCKS")
            9
                + " | eval m = regexp_match(str0, '.*') | where m=true | fields str0",  
    }
        }  
 *
        assertRowCount(
        );
}
    @Override  
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");  
    public void testRegexCharacterClass() throws IOException {
import java.util.Map;
    public void testRegexContainsSubstring() throws IOException {  
    public void testRegexpMatchInEvalAllTrue() throws IOException {
            );
            fail("Expected query to fail with [" + expectedSubstring + "] but got response: " + response);
            row("FURNITURE", "CLAMP ON LAMPS"),
        @SuppressWarnings("unchecked")
                    got.get(j)  
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
 * <p>Mirrors {@code CalciteRegexCommandIT} from the {@code opensearch-project/sql} repository so
                    want.get(j),
    private static List<Object> row(Object... values) {
    private final void assertRows(String ppl, List<Object>... expected) throws IOException {  
        if (dataProvisioned == false) {
    public void testRegexAnchoredStart() throws IOException {
        Map<String, Object> response = executePpl(ppl);  
            List<Object> got = actualRows.get(i);
        }  
            "source=" + DATASET.indexName
            "Regex command requires field of string type"
        // regexp_match selects rows whose str0 contains 'TECH' — TECHNOLOGY ×9.  
            List<Object> want = expected[i];
        for (int i = 0; i < expected.length; i++) {  
     * Send a PPL query expecting the planner to reject it; assert the error body contains
 * the SQL plugin. Each test sends a PPL query through {@code POST /_plugins/_ppl} (exposed by the
    public void testRegexpMatchInEvalSelective() throws IOException {
        assertRowCount("source=" + DATASET.indexName + " | regex str0='FURNITURE' | fields str0", 2);  
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
    /**
            assertTrue(  
 * this file be licensed under the Apache-2.0 license or a
     */  
    }
    }
        );  
    @SafeVarargs
        assertRows(
    public void testRegexAnchoredEnd() throws IOException {
 * {@code opensearch-sql} plugin), which runs the same {@code UnifiedQueryPlanner} →
            Map<String, Object> response = executePpl(ppl);  
    private void assertErrorContains(String ppl, String expectedSubstring) {
        // 17 total rows, 2 are FURNITURE → 15 pass when negated.
        // ^TECH anchors to start: only TECHNOLOGY (×9), not strings containing TECH elsewhere.  
    // ── command form: full row content check ────────────────────────────────────
        );
    }  
        // round-trips through Substrait → DataFusion as a project-side BOOLEAN expression.
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
            "source=" + DATASET.indexName + " | regex num0='1.*'",
    /**
                body.contains(expectedSubstring)
        assertRows(
            );  
        assertRowCount("source=" + DATASET.indexName + " | regex str1='BINDING' | fields str1", 2);
            17
    // ── command form: negated match ─────────────────────────────────────────────
            try {
        Map<String, Object> response = executePpl(ppl);
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
        assertRowCount("source=" + DATASET.indexName + " | regex str0!='^OFFICE' | fields str0", 11);
        // OGY$ anchors to end: TECHNOLOGY (×9).
     */  
        // REGEXP_CONTAINS — pattern matches anywhere in the field, not anchored.
     * Send a PPL query and assert the response's {@code rows} count matches {@code expectedCount}.
                "Expected response body to contain [" + expectedSubstring + "] but was: " + body,
 * </ul>
        );  
    public void testRegexOnNumericFieldErrors() {  
            "source=" + DATASET.indexName + " | regex str0='FURNITURE' | fields str0, str1 | sort str1",  
 * Self-contained integration test for the PPL {@code regex} command and {@code regexp_match()}
        assertRowCount(
     * Send a PPL query and assert each returned row equals the expected positional row.
            for (int j = 0; j < want.size(); j++) {
    }
        // [BC]INDING matches BINDING (BINDING MACHINES, BINDING SUPPLIES) but not BUSINESS.  
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);  
     * many rows whose ordering would be brittle to assert exhaustively).  
                "Column count mismatch at row " + i + " for query: " + ppl,
