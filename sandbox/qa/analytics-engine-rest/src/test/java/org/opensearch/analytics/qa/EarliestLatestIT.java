import java.util.Arrays;
    }
        @SuppressWarnings("unchecked")
        assertNotNull("Response missing 'datarows' for query: " + ppl, actualRows);
 * nullability differs Calcite's `Filter.isValid` rejects the pure-nullability cast —
            row(13L)
}
/*  
            assertEquals("Column count mismatch at row " + i + " for query: " + ppl, want.size(), got.size());  
                } else {
            List<Object> want = expected[i];
            for (int j = 0; j < want.size(); j++) {
    private static boolean dataProvisioned = false;
                        ((Number) g).longValue()  
    @SuppressWarnings("varargs")
                + " | where earliest('07/28/2004:12:34:27', datetime0) | stats count() as cnt",
        assertRowsEqual(
package org.opensearch.analytics.qa;
        for (int i = 0; i < expected.length; i++) {  
import java.util.List;  
 */  
                        "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
    @Override
        );  
 * End-to-end coverage for PPL {@code where earliest('absolute-literal', ts)} and
        );  
/**  
        // calcs has 17 datetime0 rows spanning 2004-07-04 → 2004-08-02. 4 rows are ≥ the pivot.
 *
                Object w = want.get(j);
                + " | where latest('07/28/2004:12:34:27', datetime0) | stats count() as cnt",
    }
        }  
            row(4L)
 * {@code where latest(...)} over the shared `calcs` dataset. The adapter pins the
                }
    }
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");  
        if (dataProvisioned == false) {  
        Map<String, Object> response = executePpl(ppl);
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
 * rewritten comparison's result type back to the call's declared type; when only  
                if (w instanceof Number && g instanceof Number) {
 * The OpenSearch Contributors require contributions made to  
    }
    }
    public void testEarliestAbsoluteLiteral() throws IOException {  
            dataProvisioned = true;
                        ((Number) w).longValue(),
            List<Object> got = actualRows.get(i);
                // Numeric cells deserialize as Integer when they fit in 32 bits; compare by longValue.
        // 13 rows are ≤ the same pivot.
            DatasetProvisioner.provision(client(), DATASET);
import java.io.IOException;
                    assertEquals("Cell mismatch at row " + i + ", col " + j + " for query: " + ppl, w, g);  
public class EarliestLatestIT extends AnalyticsRestTestCase {
 */  
import java.util.Map;
 * SPDX-License-Identifier: Apache-2.0
    protected void onBeforeQuery() throws IOException {
                    assertEquals(  
 * compatible open source license.
            "source=" + DATASET.indexName  
    private static final Dataset DATASET = new Dataset("calcs", "calcs");  
    private final void assertRowsEqual(String ppl, List<Object>... expected) throws IOException {  
    public void testLatestAbsoluteLiteral() throws IOException {  
                    );
 * covered by the short-circuit on the equality check.
                Object g = got.get(j);  
        }  
            }
 * this file be licensed under the Apache-2.0 license or a
            "source=" + DATASET.indexName  
    @SafeVarargs
        return Arrays.asList(values);
    private static List<Object> row(Object... values) {  
        assertRowsEqual(
