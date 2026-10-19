    }
            row("TECHNOLOGY", 9)
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
            return;
            "source=" + DATASET.indexName + " | top str0",
    }  
import org.opensearch.client.Request;
    public void testTopWithoutGroup() throws IOException {
        assertNumOfRows("source=" + DATASET.indexName + " | top usenull=false int0", 7);
 *
        }
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
package org.opensearch.analytics.qa;
        }
            row("FURNITURE", 2)
    }  
import org.opensearch.client.Response;
import java.io.IOException;
        // 7, 8 (×3), 10, 11}. Default usenull=true (legacy) → top surfaces 8 bucket
        if (expected == null || actual == null) {
                "Column count mismatch at row " + i + " for query: " + ppl,
    private static boolean dataProvisioned = false;
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
            if (Double.compare(e, a) != 0) {  
 * keeps it across test methods.
    }  
    public void testTopCommandUseNull() throws IOException {
 * {@code EngineCapability.WINDOW} flag in {@code OpenSearchProjectRule} is what lets
        // categories (7 distinct non-null + 1 null bucket).
        assertNotNull("Response missing 'rows' for query: " + ppl, actualRows);
    private void assertNumOfRows(String ppl, int expectedRows) throws IOException {
/*  
 * The OpenSearch Contributors require contributions made to  
 */
        assertNumOfRows("source=" + DATASET.indexName + " | top int0", 8);  
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");
 * {@code ROW_NUMBER() OVER (PARTITION BY ... ORDER BY ...)}. This PR's  
public class TopCommandIT extends AnalyticsRestTestCase {  
        // calcs.str0 has 3 distinct values with distinct counts → order is deterministic.
                    want.get(j),  
    }  
    }
 */  
 * <p>Provisions the {@code calcs} dataset (parquet-backed) once per class via
    private final void assertRowsEqual(String ppl, List<Object>... expected) throws IOException {
        // calcs.int0 distribution: 6 nulls; 7 distinct non-null values {1, 3, 4 (×3),  
    @Override  
 * {@code CalciteRelNodeVisitor#visitRareTopN}) to a {@code LogicalProject} containing
        // usenull=false drops the null bucket → 7 distinct non-null values.
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
    private static List<Object> row(Object... values) {
 *
        assertRowsEqual(
 *
 * SPDX-License-Identifier: Apache-2.0
            assertEquals(
    }
        return Arrays.asList(values);
                assertCellEquals(
    // ── helpers ─────────────────────────────────────────────────────────────────
        // top 1: the single highest-count str0.
import java.util.Map;
    @SafeVarargs
}
        // calcs has 3 str0 groups, so 3 result rows.
 * <p>Mirrors {@code CalciteTopCommandIT} / {@code TopCommandIT} from the  
    public void testTopNWithoutGroup() throws IOException {  
    /** Numeric-tolerant cell comparator (Jackson returns Integer/Long/Double interchangeably). */  
            row("OFFICE SUPPLIES", 6),
        );  
            for (int j = 0; j < want.size(); j++) {  
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());  
import java.util.Arrays;
 * {@code opensearch-project/sql} repository. {@code top} lowers (via
 * compatible open source license.
 * the planner accept the {@code RexOver} and emit an inline substrait
 * this file be licensed under the Apache-2.0 license or a
            double a = ((Number) actual).doubleValue();
    // ── top without group ──────────────────────────────────────────────────────
            return;  
            }
 * {@code WindowFunctionInvocation} that DataFusion's substrait consumer decodes natively.  
        }
    @SuppressWarnings("varargs")  
            List<Object> want = expected[i];
        // top 1 str3 per str0 group. Each str0 bucket gets its own ROW_NUMBER() OVER  
            );
        assertNotNull("Response missing 'rows' for query: " + ppl, actualRows);
        if (dataProvisioned == false) {
    protected void onBeforeQuery() throws IOException {
        assertRowsEqual(
            double e = ((Number) expected).doubleValue();
        }
        assertNumOfRows("source=" + DATASET.indexName + " | top 1 str3 by str0", 3);  
        // {TECHNOLOGY: 9, OFFICE SUPPLIES: 6, FURNITURE: 2}.  
        assertEquals(message, expected, actual);
    }
            List<Object> got = actualRows.get(i);  
        for (int i = 0; i < expected.length; i++) {
        @SuppressWarnings("unchecked")  
        );
 * Self-contained integration test for PPL {@code top} on the analytics-engine route.
        Map<String, Object> response = executePpl(ppl);
            }  
            "source=" + DATASET.indexName + " | top 1 str0",  
            assertEquals(message, expected, actual);  
    }  
        // (PARTITION BY str0 ORDER BY count DESC) window; the row_number=1 row wins.
                want.size(),  
    // ── usenull behaviour ──────────────────────────────────────────────────────  
    public void testTopCommandUseNullFalse() throws IOException {  
/**  
                got.size()
            dataProvisioned = true;
            DatasetProvisioner.provision(client(), DATASET);  
    public void testTopNWithGroup() throws IOException {
import java.util.List;  
    private static void assertCellEquals(String message, Object expected, Object actual) {
        Map<String, Object> response = executePpl(ppl);
 * {@link DatasetProvisioner}; {@link AnalyticsRestTestCase#preserveIndicesUponCompletion()}  
    }
                );
                    got.get(j)
        if (expected instanceof Number && actual instanceof Number) {  
            row("TECHNOLOGY", 9),  
        @SuppressWarnings("unchecked")  
        assertEquals("Row count mismatch for query: " + ppl, expectedRows, actualRows.size());  
