    public void testMinMaxMixedBooleanAndNumeric() throws IOException {
                assertEquals("Cell mismatch at row " + i + ", col " + j + " for query: " + ppl, want.get(j), got.get(j));
 * this file be licensed under the Apache-2.0 license or a
        // bool1 has 6 true + 6 false rows (5 nulls are skipped by min/max).
    }  
    public void testMinMaxBoolean() throws IOException {  
 * over the shared `calcs` dataset. Substrait core's {@code functions_arithmetic.yaml}
    private static List<Object> row(Object... values) {
import java.util.Arrays;
        );
    protected void onBeforeQuery() throws IOException {
        }  
            dataProvisioned = true;
        assertRowsEqual(  
    private final void assertRowsEqual(String ppl, List<Object>... expected) throws IOException {
    }
        return Arrays.asList(values);  
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
            DatasetProvisioner.provision(client(), DATASET);
        // int0 ranges 1..11 across non-null rows; bool1 covers both polarities.
        if (dataProvisioned == false) {  
 * declares min/max only for i8..fp64; the sandbox extension adds a boolean overload so  
        Map<String, Object> response = executePpl(ppl);  
    private static final Dataset DATASET = new Dataset("calcs", "calcs");  
 */  
    }
                + " min(bool1) as min_b, max(bool1) as max_b",  
        // false and max to true within every group.
/*  
        // Each str0 group contains both true and false bool0 rows, so min collapses to  
            List<Object> got = actualRows.get(i);
}
    }  
    @Override
    }
 * SPDX-License-Identifier: Apache-2.0
        assertRowsEqual(
/**  
        for (int i = 0; i < expected.length; i++) {
            "source=" + DATASET.indexName + " | stats min(bool0) as min_b, max(bool0) as max_b by str0 | sort str0",  
            row(false, true, "FURNITURE"),
    @SafeVarargs  
        assertRowsEqual(
        );
 * The OpenSearch Contributors require contributions made to  
        );
    public void testMinMaxBooleanGroupedByKeyword() throws IOException {
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
 * compatible open source license.
            row(false, true)
            for (int j = 0; j < want.size(); j++) {  
            }
                + " | stats min(int0) as min_i, max(int0) as max_i,"
 * End-to-end coverage for {@code stats min(bool_field)} / {@code stats max(bool_field)}
public class MinMaxBooleanIT extends AnalyticsRestTestCase {
import java.util.Map;
 */  
            row(false, true, "OFFICE SUPPLIES"),
        assertNotNull("Response missing 'datarows' for query: " + ppl, actualRows);  
            assertEquals("Column count mismatch at row " + i + " for query: " + ppl, want.size(), got.size());
package org.opensearch.analytics.qa;
 * DataFusion's native min/max.
    }
 *
        @SuppressWarnings("unchecked")
    @SuppressWarnings("varargs")
            "source=" + DATASET.indexName
 * isthmus' {@code AggregateFunctionConverter} can bind these calls and route them to
import java.io.IOException;
import java.util.List;  
    private static boolean dataProvisioned = false;
            row(1, 11, false, true)
            "source=" + DATASET.indexName + " | stats min(bool1) as min_b, max(bool1) as max_b",  
            row(false, true, "TECHNOLOGY")  
            List<Object> want = expected[i];  
        }  
