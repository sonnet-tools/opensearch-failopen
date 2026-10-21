            row("CLOCKS"),
                assertEquals(
    @SafeVarargs
 * SPDX-License-Identifier: Apache-2.0
    // parse. RegexpReplaceAdapter (in DataFusionAnalyticsBackendPlugin.scalarFunctionAdapters)
import org.opensearch.client.ResponseException;
        );
        // str0 has 2 → renamed to FURN.
import java.util.Map;
        );
                    got.get(j)
            for (int j = 0; j < want.size(); j++) {
 * <p>Multi-pair replacements ({@code | replace 'A' WITH 'X', 'B' WITH 'Y' IN f}) lower to nested
        return Arrays.asList(values);
        // FURNITURE → FURN in str0; 2 rows affected, others unchanged.
        // empty — no-op for these string values, exercises the function-form code path.
        assertRowCount(
            row("FURN", "CLAMP ON LAMPS"),
 * <p>Mirrors {@code CalciteReplaceCommandIT} from the {@code opensearch-project/sql} repository so
import org.opensearch.client.Response;
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
            "source=" + DATASET.indexName + " | replace 'FURNITURE' WITH 'FURN' IN str0 | where str0='FURN' | fields str0",
 *
import org.opensearch.client.Request;
        try {
        // '*BOARDS' matches strings ending in BOARDS — CORDED KEYBOARDS, CORDLESS KEYBOARDS (×2).
                want.size(),
        // Pattern matches no value — every row passes through unchanged. 17 rows total in calcs.
    @SuppressWarnings("varargs")
        // Verify the actual replaced values (not just counts) for the FURNITURE rows.
    }
    public void testReplaceLiteralAcrossMultipleFields() throws IOException {
 * keeps it across test methods.
 *       {@code SqlLibraryOperators.REGEXP_REPLACE_3}. Mapped to Substrait extension
        // PPL replace() function in eval also lowers to REGEXP_REPLACE_3 (per
            } catch (Exception ioe) {
    @Override
            }
 *       Substrait extension {@code "replace"} → DataFusion's {@code replace} UDF.</li>
            "source=" + DATASET.indexName + " | replace 'FURNITURE' WITH 'FURN' IN str0 | where str0='FURN' | fields str0, str1 | sort str1",
 *
            2
            row("GRIP ON LAMPS")
    }
    }
    // ── function form: regexp_replace() in eval projection ─────────────────────
    // with `\Q…\E` quoted-literal blocks (e.g. `^\Q\E(.*?)\QBOARDS\E$`). Rust's regex crate
        assertRowCount(
        // Nested REPLACE in projection: REPLACE(REPLACE(str0, 'FURNITURE', 'F'), 'TECHNOLOGY', 'T').
        );
            "source=" + DATASET.indexName + " | replace 'FURNITURE' WITH 'F', 'TECHNOLOGY' WITH 'T' IN str0 | where str0='T' | fields str0",
        // Check the actual output value, confirming round-trip through Substrait → DataFusion.
 * this file be licensed under the Apache-2.0 license or a
                body = org.apache.hc.core5.http.io.entity.EntityUtils.toString(e.getResponse().getEntity());
        // PPLFuncImpTable.register for BuiltinFunctionName.REPLACE).
    // ── command form: literal pattern (SqlStdOperatorTable.REPLACE) ─────────────
    public void testReplaceWildcardSuffix() throws IOException {
 * {@code regexp_replace()} functions on the analytics-engine route.
 */
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
    public void testReplaceLiteralExpectedRows() throws IOException {
 *       {@code eval x = replace(field, ...)} / {@code regexp_replace(...)} — emit Calcite
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
 * {@code opensearch-sql} plugin), which runs the same {@code UnifiedQueryPlanner} →
            );
 *
    }
    }
 * Self-contained integration test for the PPL {@code replace} command and {@code replace()} /
            2
            );
        if (dataProvisioned == false) {
            "source=" + DATASET.indexName + " | eval x = regexp_replace(str0, 'OFFICE ', '') | where x='SUPPLIES' | fields x",
 * </ul>
            fail("Unexpected IOException: " + e);
    // The SQL plugin's WildcardUtils.convertWildcardPatternToRegex() emits Java-style regex
    public void testReplaceFunctionInEval() throws IOException {
        );
            "source=" + DATASET.indexName + " | replace '*BOARDS' WITH 'KBD' IN str1 | where str1='KBD' | fields str1",
        assertRowCount(
 *       {@code SqlStdOperatorTable.REPLACE} (substring replacement, no regex). Mapped to
        );
        assertEquals("Row count mismatch for query: " + ppl, expectedCount, actualRows.size());
    protected void onBeforeQuery() throws IOException {
 * the SQL plugin. Each test sends a PPL query through {@code POST /_plugins/_ppl} (exposed by the
    // (used by DataFusion) does not support `\Q…\E`, so the pattern would otherwise fail to
                "Column count mismatch at row " + i + " for query: " + ppl,
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
            List<Object> want = expected[i];
    public void testReplaceLiteralNoMatch() throws IOException {
        for (int i = 0; i < expected.length; i++) {
 * <p>Two distinct lowering targets are exercised:
            List<Object> got = actualRows.get(i);
                body = e.getMessage();
        assertRowCount(
        }
        );
 * {@code CalciteRelNodeVisitor} → Substrait → DataFusion pipeline.
        Map<String, Object> response = executePpl(ppl);
        }
    private void assertRowCount(String ppl, int expectedCount) throws IOException {
        );
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
 *
            2
import java.io.IOException;
        // Better: replace 'OFFICE' in str0 — produces 'OFFICE SUPPLIES' → ' SUPPLIES'.
    }
            DatasetProvisioner.provision(client(), DATASET);
        );
        );
            9
    }
                body.contains(expectedSubstring)
            "source=" + DATASET.indexName + " | eval x = replace(str0, 'TECHNOLOGY', 'TECH') | where x='TECH' | fields x",
            dataProvisioned = true;
 */
    }
        assertRowCount(
        assertRows(
    private static List<Object> row(Object... values) {
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
    public void testReplaceLiteralMultiplePairs() throws IOException {
 *
        );
 *   <li>{@code | replace 'pat*' WITH 'new' IN field} (wildcard) and
            6
            assertTrue(
    }
            row("FURN", "CLOCKS")
    }
    // ── command form: wildcard pattern (REGEXP_REPLACE_3) ──────────────────────
import java.util.List;
        // FURNITURE (×2) → 'F', TECHNOLOGY (×9) → 'T', OFFICE SUPPLIES (×6) → unchanged.
    }
 *       {@code "regexp_replace"} → DataFusion's {@code regexp_replace} UDF.</li>
        // eval-side regexp_replace lowers to REGEXP_REPLACE_3. Replace any digit run in str0 with
            9
 *   <li>{@code | replace 'literal' WITH 'new' IN field} — emits Calcite
    public void testReplaceWildcardPrefix() throws IOException {
    public void testRegexpReplaceInEval() throws IOException {
 * {@link DatasetProvisioner}; {@link AnalyticsRestTestCase#preserveIndicesUponCompletion()}
            Map<String, Object> response = executePpl(ppl);
 * <p>Provisions the {@code calcs} dataset (parquet-backed) once per class via
 * The OpenSearch Contributors require contributions made to
            assertEquals(
        assertRowCount(
        );
/**
            }
        assertRowCount(
        assertRowCount(
        assertRowCount(
            "source=" + DATASET.indexName + " | replace 'BUSINESS*' WITH 'BIZ' IN str1 | where str1='BIZ' | fields str1",
    }
 * that the analytics-engine path can be verified inside core without cross-plugin dependencies on
                got.size()
            "source=" + DATASET.indexName + " | replace 'NOSUCHVALUE' WITH 'X' IN str0 | fields str0",
                );
        // assertContainsRow uses substring/contains — order-independent.
 * <ul>
        // Whole-string replacement: matched values become 'KBD'.
        // 'BUSINESS*' matches BUSINESS ENVELOPES, BUSINESS COPIERS (×2).
}
            fail("Expected query to fail with [" + expectedSubstring + "] but got response: " + response);
import java.util.Arrays;
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
    public void testRegexpReplaceProducesProjectedColumn() throws IOException {
        }
        @SuppressWarnings("unchecked")
            "source=" + DATASET.indexName + " | replace 'FURNITURE' WITH 'FURN' IN str0, str1 | where str0='FURN' | fields str0",
    // ── helpers ────────────────────────────────────────────────────────────────
            String body;
    }
/*
package org.opensearch.analytics.qa;
        Map<String, Object> response = executePpl(ppl);
        } catch (ResponseException e) {
    private void assertErrorContains(String ppl, String expectedSubstring) {
    }
        // Replace value 'FURNITURE' in BOTH str0 and str1. str1 has no FURNITURE → unaffected.
        assertRows(
 * {@code REPLACE(REPLACE(field, ...), ...)} calls — exercises sequential project-side application.
                    want.get(j),
    public void testReplaceLiteralSinglePair() throws IOException {
    //
 * compatible open source license.
            2
public class ReplaceCommandIT extends AnalyticsRestTestCase {
    }
            2
                "Expected response body to contain [" + expectedSubstring + "] but was: " + body,
            try {
            "source=" + DATASET.indexName + " | replace 'FURNITURE' WITH 'F', 'TECHNOLOGY' WITH 'T' IN str0 | where str0='F' | fields str0",
    // rewrites `\Q…\E` blocks to per-char-escaped literals before substrait serialization.
        } catch (IOException e) {
    private static boolean dataProvisioned = false;
        @SuppressWarnings("unchecked")
    private final void assertRows(String ppl, List<Object>... expected) throws IOException {
            17
            "source=" + DATASET.indexName + " | where str0='FURNITURE' | eval s = replace(str1, 'CLAMP', 'GRIP') | fields s | sort s",
