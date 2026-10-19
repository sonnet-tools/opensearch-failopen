        if (dataProvisioned == false) {
        // `fields - num0, num1, num2, num3, num4` removes those five columns from the  
        @SuppressWarnings("unchecked")
        @SuppressWarnings("unchecked")
        List<String> columns = extractColumnNames(response);  
        }
    public void testFieldsExclusion() throws IOException {
                "Column count mismatch at row " + i + " for query: " + ppl,
    public void testFieldsBasic() throws IOException {
        assertNotNull("Response missing 'rows' for query: " + ppl, actualRows);
        for (String name : columns) {
}
        assertNotNull("Response missing 'columns' for query: " + ppl, columns);
        Map<String, Object> response = executePpl(
        );  
 */  
        assertRowsEqual(
                want.size(),
    @SafeVarargs
                assertEquals(  
import java.util.Arrays;
 * compatible open source license.
        java.util.Set<String> actual = new java.util.HashSet<>(columns);
                got.size()  
 * lists, wildcard include patterns, and field exclusion. Wildcard suffix/prefix patterns
            "Column count for query: " + ppl,
        @SuppressWarnings("unchecked")
        assertEquals(  
            for (int j = 0; j < want.size(); j++) {
 * delegate to {@code CalciteRelNodeVisitor.visitProject} which expands them at plan time;
import org.opensearch.client.Response;
        assertNotNull("Response missing 'schema'", columns);  
        }
 * → DataFusion pipeline as the SQL plugin's force-routed analytics path.
        );  
    }  
package org.opensearch.analytics.qa;
        // *0 expands to all columns ending in '0' — {num0, str0, int0, bool0, date0, time0,
 */
            "str2"
 *
    @SuppressWarnings("varargs")
    }
        assertColumns("source=" + DATASET.indexName + " | fields str2, num0 | head 3", "str2", "num0");
        java.util.Set<String> expected = new java.util.HashSet<>(
            "source=" + DATASET.indexName + " | fields *0 | head 1"
    /** Assert the response has the expected column names in order. */  
                );
            assertEquals(  
        // path reads from parquet which preserves that.  
 * Self-contained integration test for PPL {@code fields} on the analytics-engine route.
    }
            );
                expectedColumns[i],
 * The OpenSearch Contributors require contributions made to  
        assertColumns(
    public void testFieldsExplicitOrder() throws IOException {  
            Arrays.asList("num0", "str0", "int0", "bool0", "date0", "time0", "datetime0")  
            assertEquals(  
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
    private void assertColumns(String ppl, String... expectedColumns) throws IOException {
    }
            List<Object> got = actualRows.get(i);
        for (int i = 0; i < expectedColumns.length; i++) {
            row("three"),  
            List<Object> want = expected[i];
            row("one"),
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");  
    }
    }  
        return Arrays.asList(values);
            "source=" + DATASET.indexName + " | fields num0, str2 | head 1",  
 * the exclusion form (`fields - x, y`) goes through the same code path with `exclude=true`.  
        );  
    protected void onBeforeQuery() throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
            row((Object) null),
            "source=" + DATASET.indexName + " | fields str2 | head 5",  
                "Column at position " + i + " for query: " + ppl,
 * <p>Mirrors {@code CalciteFieldsCommandIT} from the {@code opensearch-project/sql}  
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
            );
                columns.get(i)  
        }
/**  
 * dependencies. Each test sends a PPL query through {@code POST /_plugins/_ppl}, which
 * <p>Covers the field-projection surface this PR cares about: explicit single/multi-field  
    @Override
/*  
        List<String> columns = extractColumnNames(response);
    }
        // order, which is alphabetical here). Verify the set rather than the sequence.  
        // projection. Validate the result no longer contains num*.
        // datetime0}. Order isn't guaranteed (analyzer resolves wildcards by mapping iteration
    public void testFieldsSingleColumn() throws IOException {
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
        Map<String, Object> response = executePpl(
            columns.size()  
 *
 * repository so the analytics-engine path can be verified inside core without cross-plugin
        );
    private static List<Object> row(Object... values) {  
                    got.get(j)  
        }  
 * runs the same {@code UnifiedQueryPlanner} → {@code CalciteRelNodeVisitor} → Substrait  
 *
            DatasetProvisioner.provision(client(), DATASET);
        @SuppressWarnings("unchecked")  
            row("five")
        );
        assertNotNull("Response missing 'schema'", columns);
    private static boolean dataProvisioned = false;  
public class FieldsCommandIT extends AnalyticsRestTestCase {
            dataProvisioned = true;  
        List<String> columns = extractColumnNames(response);
    public void testFieldsSuffixWildcard() throws IOException {  
        for (int i = 0; i < expected.length; i++) {  
        // Column order must match the | fields list, not the document/storage order.
            }
        assertEquals("Wildcard *0 column set", expected, actual);
                    want.get(j),
            "source=" + DATASET.indexName + " | fields - num0, num1, num2, num3, num4 | head 1"  
            expectedColumns.length,
    }
import java.util.Map;
import org.opensearch.client.Request;
import java.util.List;  
        );
        Map<String, Object> response = executePpl(ppl);
            "num0",
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
    // ── helpers ─────────────────────────────────────────────────────────────────
    private final void assertRowsEqual(String ppl, List<Object>... expected) throws IOException {  
    }
        Map<String, Object> response = executePpl(ppl);
        // Two-column projection. Row order is the document insertion order; the analytics
            assertFalse("Excluded column should not appear: " + name, name.startsWith("num"));  
            row("two"),
