        }  
            return;  
    }
    }
 *
        assertNumOfRows("source=" + DATASET.indexName + " | rare str3 by str0", 5);
        @SuppressWarnings("unchecked")  
    private static boolean dataProvisioned = false;
            double a = ((Number) actual).doubleValue();
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
    public void testRareCommandUseNullFalse() throws IOException {  
        if (expected == null || actual == null) {
        return Arrays.asList(values);
            List<Object> want = expected[i];
        //   TECHNOLOGY      → {null: 5, e: 4}         → 2 rows
                );
    public void testRareCommandUseNull() throws IOException {  
        Map<String, Object> response = executePpl(ppl);
import java.util.Arrays;
    }
            dataProvisioned = true;
    protected void onBeforeQuery() throws IOException {
    /** Numeric-tolerant cell comparator (Jackson returns Integer/Long/Double interchangeably). */  
 * {@code opensearch-project/sql} repository. {@code rare} lowers the same way as
        // Total: 5 distinct (str0, str3) pairs under the default rare limit.  
 *
    // ── helpers ─────────────────────────────────────────────────────────────────
    // ── rare without group ─────────────────────────────────────────────────────  
import java.io.IOException;
            DatasetProvisioner.provision(client(), DATASET);
import java.util.Map;
            row("FURNITURE", 2),
        // rare str3 per str0 group. calcs.str3 distribution by str0:
            assertEquals(
    private void assertNumOfRows(String ppl, int expectedRows) throws IOException {
            return;
                    want.get(j),  
        @SuppressWarnings("unchecked")  
    @SuppressWarnings("varargs")  
    }  
    private static final Dataset DATASET = new Dataset("calcs", "calcs");  
    @SafeVarargs
            row("TECHNOLOGY", 9)  
    }  
        }
    }
import org.opensearch.client.Response;
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");
    private final void assertRowsEqual(String ppl, List<Object>... expected) throws IOException {
import org.opensearch.client.Request;
        assertNotNull("Response missing 'rows' for query: " + ppl, actualRows);
import java.util.List;  
            row("OFFICE SUPPLIES", 6),
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());  
package org.opensearch.analytics.qa;
 * {@code LogicalProject} containing {@code ROW_NUMBER() OVER (PARTITION BY ... ORDER BY count ASC)} —  
            );
 * The OpenSearch Contributors require contributions made to  
        for (int i = 0; i < expected.length; i++) {
                    got.get(j)
                got.size()
            if (Double.compare(e, a) != 0) {  
    public void testRareWithGroup() throws IOException {
        if (expected instanceof Number && actual instanceof Number) {  
        //   FURNITURE       → {e: 2}                  → 1 row  
        //   OFFICE SUPPLIES → {e: 4, null: 2}         → 2 rows
public class RareCommandIT extends AnalyticsRestTestCase {
    private static void assertCellEquals(String message, Object expected, Object actual) {
 * Self-contained integration test for PPL {@code rare} on the analytics-engine route.
        assertEquals(message, expected, actual);
/*  
        // calcs.str0 has 3 distinct values with distinct counts → rare order is  
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
            }
        assertNotNull("Response missing 'rows' for query: " + ppl, actualRows);
        if (dataProvisioned == false) {  
        // usenull=false drops the null bucket → 7 result rows.
 * <p>Mirrors {@code CalciteRareCommandIT} / {@code RareCommandIT} from the  
    }
        assertNumOfRows("source=" + DATASET.indexName + " | rare usenull=false int0", 7);
            for (int j = 0; j < want.size(); j++) {  
            double e = ((Number) expected).doubleValue();
        assertRowsEqual(
    public void testRareWithoutGroup() throws IOException {
                assertCellEquals(
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
        assertNumOfRows("source=" + DATASET.indexName + " | rare int0", 8);  
                "Column count mismatch at row " + i + " for query: " + ppl,
 */  
            "source=" + DATASET.indexName + " | rare str0",  
    }  
    // ── usenull behaviour ──────────────────────────────────────────────────────
        }
    @Override
        // deterministic ASC by count: {FURNITURE: 2, OFFICE SUPPLIES: 6, TECHNOLOGY: 9}.
        // 7, 8 (×3), 10, 11}. Default usenull=true → 8 bucket categories (7 + null).
        // calcs.int0 distribution: 6 nulls; 7 distinct non-null values {1, 3, 4 (×3),
    private static List<Object> row(Object... values) {
/**  
 * so it exercises the same {@code EngineCapability.WINDOW} flag in
        assertEquals("Row count mismatch for query: " + ppl, expectedRows, actualRows.size());  
        );
 */  
            }  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
                want.size(),  
        Map<String, Object> response = executePpl(ppl);
    }
        }
 * {@code top} via {@code CalciteRelNodeVisitor#visitRareTopN} — a
}
 * compatible open source license.
 * {@code OpenSearchProjectRule} that this PR introduces.
            List<Object> got = actualRows.get(i);  
            assertEquals(message, expected, actual);  
