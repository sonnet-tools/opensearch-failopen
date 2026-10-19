        // Pattern matches no value — every row passes through unchanged. 17 rows total in calcs.  
        // Whole-string replacement: matched values become 'KBD'.
import java.util.Map;  
    }
    public void testReplaceLiteralMultiplePairs() throws IOException {
    public void testReplaceLiteralExpectedRows() throws IOException {
    }
        // FURNITURE (×2) → 'F', TECHNOLOGY (×9) → 'T', OFFICE SUPPLIES (×6) → unchanged.  
        // 'BUSINESS*' matches BUSINESS ENVELOPES, BUSINESS COPIERS (×2).
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");  
                    want.get(j),
        );
 * <p>Two distinct lowering targets are exercised:  
        } catch (ResponseException e) {
            }
            try {  
            fail("Unexpected IOException: " + e);
        assertRowCount(
    // ── helpers ────────────────────────────────────────────────────────────────
        assertRowCount(
 * </ul>  
        assertRows(  
            2  
    @SafeVarargs
                "Column count mismatch at row " + i + " for query: " + ppl,
    @Override  
    @SuppressWarnings("varargs")
 *       {@code SqlStdOperatorTable.REPLACE} (substring replacement, no regex). Mapped to  
    // The SQL plugin's WildcardUtils.convertWildcardPatternToRegex() emits Java-style regex  
    }  
 * {@code opensearch-sql} plugin), which runs the same {@code UnifiedQueryPlanner} →  
 * <p>Mirrors {@code CalciteReplaceCommandIT} from the {@code opensearch-project/sql} repository so  
        @SuppressWarnings("unchecked")
            );
import java.util.Arrays;
        return Arrays.asList(values);
                body = org.apache.hc.core5.http.io.entity.EntityUtils.toString(e.getResponse().getEntity());
            6
                assertEquals(  
    private void assertErrorContains(String ppl, String expectedSubstring) {  
    public void testRegexpReplaceInEval() throws IOException {
 *
            for (int j = 0; j < want.size(); j++) {
            9
            String body;
        assertRowCount(
        // eval-side regexp_replace lowers to REGEXP_REPLACE_3. Replace any digit run in str0 with
        // Check the actual output value, confirming round-trip through Substrait → DataFusion.  
import org.opensearch.client.ResponseException;
 * that the analytics-engine path can be verified inside core without cross-plugin dependencies on
            row("FURN", "CLAMP ON LAMPS"),
    // (used by DataFusion) does not support `\Q…\E`, so the pattern would otherwise fail to
 * {@code regexp_replace()} functions on the analytics-engine route.
        // empty — no-op for these string values, exercises the function-form code path.  
            "source=" + DATASET.indexName + " | replace '*BOARDS' WITH 'KBD' IN str1 | where str1='KBD' | fields str1",
    }  
        }
        assertRowCount(
 *       {@code eval x = replace(field, ...)} / {@code regexp_replace(...)} — emit Calcite  
            9
import java.io.IOException;  
        assertEquals("Row count mismatch for query: " + ppl, expectedCount, actualRows.size());
public class ReplaceCommandIT extends AnalyticsRestTestCase {  
    private static List<Object> row(Object... values) {
            "source=" + DATASET.indexName + " | replace 'FURNITURE' WITH 'F', 'TECHNOLOGY' WITH 'T' IN str0 | where str0='T' | fields str0",  
            2
        );
    }  
    }
 * {@code CalciteRelNodeVisitor} → Substrait → DataFusion pipeline.
import org.opensearch.client.Request;
    // ── function form: regexp_replace() in eval projection ─────────────────────
            } catch (Exception ioe) {
    // ── command form: literal pattern (SqlStdOperatorTable.REPLACE) ─────────────
        );  
        );
        assertRowCount(
 * <p>Provisions the {@code calcs} dataset (parquet-backed) once per class via
/*  
    private static boolean dataProvisioned = false;
            fail("Expected query to fail with [" + expectedSubstring + "] but got response: " + response);  
    }  
        // Verify the actual replaced values (not just counts) for the FURNITURE rows.
                body.contains(expectedSubstring)
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
    public void testReplaceWildcardSuffix() throws IOException {  
 */  
    }  
        // FURNITURE → FURN in str0; 2 rows affected, others unchanged.
        // Replace value 'FURNITURE' in BOTH str0 and str1. str1 has no FURNITURE → unaffected.
    }  
            "source=" + DATASET.indexName + " | replace 'BUSINESS*' WITH 'BIZ' IN str1 | where str1='BIZ' | fields str1",  
        try {
            List<Object> want = expected[i];
import org.opensearch.client.Response;  
 *
                body = e.getMessage();  
            "source=" + DATASET.indexName + " | replace 'FURNITURE' WITH 'FURN' IN str0 | where str0='FURN' | fields str0, str1 | sort str1",
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);  
        }  
            "source=" + DATASET.indexName + " | where str0='FURNITURE' | eval s = replace(str1, 'CLAMP', 'GRIP') | fields s | sort s",
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
        // PPL replace() function in eval also lowers to REGEXP_REPLACE_3 (per  
        Map<String, Object> response = executePpl(ppl);  
            row("FURN", "CLOCKS")  
            2  
        assertRowCount(  
        assertRowCount(
    public void testReplaceLiteralSinglePair() throws IOException {
    protected void onBeforeQuery() throws IOException {
    public void testReplaceFunctionInEval() throws IOException {
}
            Map<String, Object> response = executePpl(ppl);
            "source=" + DATASET.indexName + " | replace 'FURNITURE' WITH 'FURN' IN str0 | where str0='FURN' | fields str0",
 * compatible open source license.
 *   <li>{@code | replace 'pat*' WITH 'new' IN field} (wildcard) and
 *
    public void testReplaceLiteralAcrossMultipleFields() throws IOException {
                "Expected response body to contain [" + expectedSubstring + "] but was: " + body,  
    public void testReplaceLiteralNoMatch() throws IOException {
        );
    }  
                );
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
 *       {@code "regexp_replace"} → DataFusion's {@code regexp_replace} UDF.</li>
    }
    //
 *       {@code SqlLibraryOperators.REGEXP_REPLACE_3}. Mapped to Substrait extension
        if (dataProvisioned == false) {
            "source=" + DATASET.indexName + " | replace 'FURNITURE' WITH 'FURN' IN str0, str1 | where str0='FURN' | fields str0",
 * SPDX-License-Identifier: Apache-2.0
        }
    public void testReplaceWildcardPrefix() throws IOException {  
        );
                    got.get(j)  
    }
    // with `\Q…\E` quoted-literal blocks (e.g. `^\Q\E(.*?)\QBOARDS\E$`). Rust's regex crate
            "source=" + DATASET.indexName + " | replace 'NOSUCHVALUE' WITH 'X' IN str0 | fields str0",
            dataProvisioned = true;
    private final void assertRows(String ppl, List<Object>... expected) throws IOException {  
    }
                got.size()  
        );
        assertRows(
        // '*BOARDS' matches strings ending in BOARDS — CORDED KEYBOARDS, CORDLESS KEYBOARDS (×2).
        // Better: replace 'OFFICE' in str0 — produces 'OFFICE SUPPLIES' → ' SUPPLIES'.
        // str0 has 2 → renamed to FURN.  
        assertRowCount(
            "source=" + DATASET.indexName + " | replace 'FURNITURE' WITH 'F', 'TECHNOLOGY' WITH 'T' IN str0 | where str0='F' | fields str0",
 * Self-contained integration test for the PPL {@code replace} command and {@code replace()} /  
 *       Substrait extension {@code "replace"} → DataFusion's {@code replace} UDF.</li>
 *
    // parse. RegexpReplaceAdapter (in DataFusionAnalyticsBackendPlugin.scalarFunctionAdapters)  
            }
 * this file be licensed under the Apache-2.0 license or a
            row("CLOCKS"),  
        );
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
 * <p>Multi-pair replacements ({@code | replace 'A' WITH 'X', 'B' WITH 'Y' IN f}) lower to nested
            17  
        );
        Map<String, Object> response = executePpl(ppl);
 * The OpenSearch Contributors require contributions made to  
    public void testRegexpReplaceProducesProjectedColumn() throws IOException {
        // PPLFuncImpTable.register for BuiltinFunctionName.REPLACE).
            "source=" + DATASET.indexName + " | eval x = replace(str0, 'TECHNOLOGY', 'TECH') | where x='TECH' | fields x",  
 *   <li>{@code | replace 'literal' WITH 'new' IN field} — emits Calcite
                want.size(),
            "source=" + DATASET.indexName + " | eval x = regexp_replace(str0, 'OFFICE ', '') | where x='SUPPLIES' | fields x",  
 * keeps it across test methods.
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
import java.util.List;
package org.opensearch.analytics.qa;
    // rewrites `\Q…\E` blocks to per-char-escaped literals before substrait serialization.
        for (int i = 0; i < expected.length; i++) {  
 * <ul>
 * {@link DatasetProvisioner}; {@link AnalyticsRestTestCase#preserveIndicesUponCompletion()}  
            2
            assertEquals(  
        );
 */
    private void assertRowCount(String ppl, int expectedCount) throws IOException {
            assertTrue(
        assertRowCount(
        // Nested REPLACE in projection: REPLACE(REPLACE(str0, 'FURNITURE', 'F'), 'TECHNOLOGY', 'T').
        );
            List<Object> got = actualRows.get(i);
    }
 *
    }  
        } catch (IOException e) {  
            DatasetProvisioner.provision(client(), DATASET);  
        @SuppressWarnings("unchecked")
 * the SQL plugin. Each test sends a PPL query through {@code POST /_plugins/_ppl} (exposed by the
    // ── command form: wildcard pattern (REGEXP_REPLACE_3) ──────────────────────
        // assertContainsRow uses substring/contains — order-independent.  
            2  
 * {@code REPLACE(REPLACE(field, ...), ...)} calls — exercises sequential project-side application.  
/**
            );
            row("GRIP ON LAMPS")
