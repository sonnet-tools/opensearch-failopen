    public void testTableSuffixWildcard() throws IOException {
            "num0"
    public void testTableSpaceDelimited() throws IOException {  
        List<String> columns = extractColumnNames(response);
 * are not duplicated here.
 * code path {@code fields} dispatches to) once {@code plugins.calcite.enabled=true} is
 * SPDX-License-Identifier: Apache-2.0
        // Project) is caught here.  
        // minus form is unique to `table`; `fields` uses `fields - a, b, ...` with a  
        // future divergence (e.g. `table` accidentally adds a Sort or rewires the
    }  
 * {@code AstBuilder.visitTableCommand} reuses {@code buildProjectCommand} (the same  
            "source=" + DATASET.indexName + " | table str0, num0, int0 | head 3"
                columns.get(i)
        for (String name : columns) {  
 * <a href="https://github.com/opensearch-project/sql/pull/5413">opensearch-project/sql#5413</a>).  
            );  
        java.util.Set<String> actual = new java.util.HashSet<>(columns);  
/**
        // keyword reaches buildProjectCommand without falling back to the v2-only error.
}
        assertNotNull("Response missing 'columns' for query: " + ppl, columns);
    // ── helpers ─────────────────────────────────────────────────────────────────
import java.util.Map;  
        @SuppressWarnings("unchecked")  
        // comma-separated list (no space-delimiting). Validates analytics path retains
 * space-delimited field lists, leading-{@code -} exclusion forms, and mixes those with
    }
        assertNotNull("Response missing 'schema'", columns);
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Object> response = executePpl(  
import java.io.IOException;
            dataProvisioned = true;
    private void assertColumns(String ppl, String... expectedColumns) throws IOException {
    }  
    }  
                expectedColumns[i],
        }
            DatasetProvisioner.provision(client(), DATASET);  
        // for the `table` lowering specifically. Order is analyzer-dependent, so set-equality.
package org.opensearch.analytics.qa;
        );  
        // *0 expands at parse time to all columns ending in '0'. Identical to  
        // Comma-delimited form — same shape as `fields a, b`. Sanity check that the table  
 * Calcite path does. Plain projection semantics (already covered by {@code FieldsCommandIT})
                "Column at position " + i + " for query: " + ppl,  
        }
    @Override  
    }  
        );  
        assertColumns(
        // exclusion semantics.
        );
    private static boolean dataProvisioned = false;
        @SuppressWarnings("unchecked")  
        assertNotNull("Response missing 'schema'", columns);
        Map<String, Object> response = executePpl(ppl);
            "int0"
    protected void onBeforeQuery() throws IOException {
 * The added value of {@code table} is a more permissive token shape: it accepts
        List<String> columns = extractColumnNames(response);
        );
 *
            java.util.Arrays.asList("num0", "str0", "int0", "bool0", "date0", "time0", "datetime0")
 * <p>Reuses the {@code calcs} parquet-backed dataset.
        );
        java.util.Set<String> expected = new java.util.HashSet<>(
 * Self-contained integration test for PPL {@code table} on the analytics-engine route.  
        Map<String, Object> fieldsResp = executePpl(
            "str0",
 */  
        );  
        // schema + rows. Makes the alias claim explicit at the response level so a
            "str0",
        // Space-delimited form — unique to `table`. Validates the lexer accepts whitespace as
 *
        // a separator and the AstBuilder folds the multi-token list into a single Project.
            "source=" + DATASET.indexName + " | table str0 num0 int0 | head 3",
        @SuppressWarnings("unchecked")  
public class TableCommandIT extends AnalyticsRestTestCase {  
            "source=" + DATASET.indexName + " | table *0 | head 1"
            "source=" + DATASET.indexName + " | fields str0, num0, int0 | head 3"
 */
        // `table - num0, num1, num2, num3, num4` removes those five columns. The leading
            assertFalse("Excluded column should not appear: " + name, name.startsWith("num"));
        // FieldsCommandIT.testFieldsSuffixWildcard on the analytics path; pinned here
        if (dataProvisioned == false) {
        assertEquals("columns from fields vs table", fieldsResp.get("columns"), tableResp.get("columns"));
        // Cross-check that `fields a, b, c` and `table a, b, c` produce identical  
        }
 * <p>This IT covers the surfaces specific to the {@code table} keyword to lock in that
    public void testFieldsAndTableEquivalence() throws IOException {
        Map<String, Object> response = executePpl(  
    public void testTableCommaDelimited() throws IOException {
            "source=" + DATASET.indexName + " | table str0, num0 | head 3",  
        assertEquals("Column count for query: " + ppl, expectedColumns.length, columns.size());  
 * compatible open source license.
 *
 * The OpenSearch Contributors require contributions made to  
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
 * <p>{@code table} is a syntactic alias of {@code fields} — the SQL plugin's
 * commas — surfaces {@code fields} doesn't expose.  
    }
            "source=" + DATASET.indexName + " | table - num0, num1, num2, num3, num4 | head 1"
    }
import java.util.List;
        assertColumns(  
 * propagated through the {@code UnifiedQueryContext} (see
/*  
        );  
import org.opensearch.client.Response;
        List<String> columns = extractColumnNames(response);
    public void testTableMinusExclusion() throws IOException {
import org.opensearch.client.Request;
        Map<String, Object> tableResp = executePpl(
 * the analytics path lowers them to the same Calcite {@code Project} RelNode as the v2 /  
        assertEquals("rows from fields vs table", fieldsResp.get("datarows"), tableResp.get("datarows"));
            "num0",  
        for (int i = 0; i < expectedColumns.length; i++) {
        assertEquals("Wildcard *0 column set", expected, actual);
 *  
            assertEquals(
