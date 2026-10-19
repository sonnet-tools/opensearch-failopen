            assertEquals("Column count mismatch at row " + i + " for query: " + ppl, want.size(), got.size());  
    public void testRegexpInEvalReturnsBoolean() throws IOException {
 * compatible open source license.
                // Numeric cells deserialize as Integer when they fit in 32 bits; compare by longValue.
    protected void onBeforeQuery() throws IOException {
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
        assertRowsEqual(
            "source=" + DATASET.indexName + " | where str0 regexp '.*' | stats count() as cnt",
import java.io.IOException;
}
        assertRowsEqual(  
        );  
                if (w instanceof Number && g instanceof Number) {
    }  
            }
    @Override
        assertNotNull("Response missing 'datarows' for query: " + ppl, actualRows);
        );
                        ((Number) g).longValue()  
            row(true),
import java.util.Map;
    public void testRegexpInWhereLiteral() throws IOException {  
        );
package org.opensearch.analytics.qa;
        }  
                Object w = want.get(j);
            dataProvisioned = true;
    public void testRegexpWildcardMatchesEverything() throws IOException {
                    );
            "source=" + DATASET.indexName + " | eval f = str1 regexp 'CL.*' | fields f | head 3",  
            DatasetProvisioner.provision(client(), DATASET);
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");  
                    assertEquals(  
    private static List<Object> row(Object... values) {  
    private static final Dataset DATASET = new Dataset("calcs", "calcs");  
                }
    @SafeVarargs
        // calcs has 2 rows with str0 = "FURNITURE" matching the substring `FUR`.
                } else {
    }
        // Pattern `.*` matches every non-null str0 row — calcs has 17 such rows.
            row(17L)
 * this file be licensed under the Apache-2.0 license or a
    }
public class RegexpIT extends AnalyticsRestTestCase {
                    assertEquals("Cell mismatch at row " + i + ", col " + j + " for query: " + ppl, w, g);  
 *
/*  
                        "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
    }
    @SuppressWarnings("varargs")
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        }  
            row(true),
        @SuppressWarnings("unchecked")
                Object g = got.get(j);  
    private final void assertRowsEqual(String ppl, List<Object>... expected) throws IOException {  
        assertRowsEqual(
        if (dataProvisioned == false) {  
            row(false)  
        // first two match `CL.*`.
import java.util.List;  
import java.util.Arrays;
            List<Object> got = actualRows.get(i);
            List<Object> want = expected[i];
                        ((Number) w).longValue(),
 */  
        Map<String, Object> response = executePpl(ppl);
            for (int j = 0; j < want.size(); j++) {
    private static boolean dataProvisioned = false;
            "source=" + DATASET.indexName + " | where str0 regexp 'FUR' | stats count() as cnt",  
    }
            row(2L)
    }
        // First three str1 values: "CLAMP ON LAMPS", "CLOCKS", "AIR PURIFIERS" — only the  
        return Arrays.asList(values);
        for (int i = 0; i < expected.length; i++) {  
/** End-to-end coverage for PPL {@code <field> regexp '<pattern>'} routed to DataFusion's regexp_like. */  
