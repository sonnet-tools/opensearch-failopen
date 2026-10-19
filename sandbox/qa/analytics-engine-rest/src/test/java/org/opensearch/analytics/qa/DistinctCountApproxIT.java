        assertRowsEqual(
        }
    @SafeVarargs  
            List<Object> want = expected[i];  
            row(2L, "FURNITURE"),  
/*  
        assertRowsEqual(
            row(9L, "TECHNOLOGY")
        // calcs has 17 rows with str0 ∈ {FURNITURE: 2, OFFICE SUPPLIES: 6, TECHNOLOGY: 9}
        for (int i = 0; i < expected.length; i++) {
 */  
            }
        @SuppressWarnings("unchecked")
    }  
        // distinct str1 values per group.  
                Object wantCell = want.get(j);
            row(6L, "OFFICE SUPPLIES"),
    @Override
    }
        }
            row(9L, "TECHNOLOGY")
    private static boolean dataProvisioned = false;  
 * `SqlUserDefinedAggFunction` named {@code "APPROX_COUNT_DISTINCT"}; substrait  
 * `calcs` dataset. The PPL parser registers `distinct_count_approx` as a
        assertRowsEqual(
                if (wantCell instanceof Number && gotCell instanceof Number) {
import java.util.Map;
            assertEquals("Column count mismatch at row " + i + " for query: " + ppl, want.size(), got.size());
        );  
 * SPDX-License-Identifier: Apache-2.0
        // `key` is the 17 distinct row identifiers (key00..key16).
            for (int j = 0; j < want.size(); j++) {  
        return Arrays.asList(values);  
            row(2L, "FURNITURE"),  
            dataProvisioned = true;  
                } else {
                    assertEquals(label, ((Number) wantCell).longValue(), ((Number) gotCell).longValue());  
    private static List<Object> row(Object... values) {
public class DistinctCountApproxIT extends AnalyticsRestTestCase {
 * emission keys off operator identity, so without `OpenSearchDistinctCountRule`
 * End-to-end coverage for PPL `stats distinct_count_approx(field)` over the shared
}
import java.io.IOException;
            "source=" + DATASET.indexName + " | stats distinct_count_approx(key) as dca",  
            List<Object> got = actualRows.get(i);
    @SuppressWarnings("varargs")
        Map<String, Object> response = executePpl(ppl);  
        );
        if (dataProvisioned == false) {
 * The OpenSearch Contributors require contributions made to  
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
 * rewriting the UDF marker to Calcite's stdop the call falls through with
 */
    protected void onBeforeQuery() throws IOException {  
 *
            "source=" + DATASET.indexName + " | stats distinct_count_approx(str1) as dca by str0 | sort str0",
                    assertEquals(label, wantCell, gotCell);
 * "Unable to find binding for call APPROX_COUNT_DISTINCT($N)".  
    }  
        );  
    public void testDistinctCountApproxByGroup() throws IOException {
    }
            row(17L)
 * this file be licensed under the Apache-2.0 license or a
            "source=" + DATASET.indexName + " | stats distinct_count_approx(str1) by str0 | sort str0",
                Object gotCell = got.get(j);
    public void testDistinctCountApproxByGroupWithAlias() throws IOException {  
    public void testDistinctCountApproxGlobal() throws IOException {  
    private final void assertRowsEqual(String ppl, List<Object>... expected) throws IOException {
                String label = "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl;  
    }
                    // Jackson boxes counts as Integer when they fit in 32 bits; compare numerically.
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
/**  
            row(6L, "OFFICE SUPPLIES"),
                }  
import java.util.Arrays;
package org.opensearch.analytics.qa;
import java.util.List;  
        assertNotNull("Response missing 'datarows' for query: " + ppl, actualRows);  
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
 * compatible open source license.
    }
            DatasetProvisioner.provision(client(), DATASET);
