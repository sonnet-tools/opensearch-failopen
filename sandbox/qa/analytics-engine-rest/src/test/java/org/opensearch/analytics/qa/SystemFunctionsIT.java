    /**  
    public void testTypeofTimestamp() throws IOException {
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.analytics.qa;
    /** {@code typeof(int0)} where int0 is an INTEGER column → "INT". */
    public void testTypeofDouble() throws IOException {
        assertFirstRowString(oneRow("key00") + "| eval t = typeof(bool0) | fields t", "BOOLEAN");
     *  PPL's {@code typeof} resolves it to "TIMESTAMP" (not "DATE"). */
    /** {@code typeof(num0)} where num0 is a DOUBLE column → "DOUBLE". */
        assertEquals("Value mismatch for query: " + ppl, expected, cell);
            dataProvisioned = true;  
    }  
        assertFirstRowString(oneRow("key00") + "| eval t = typeof(date0) | fields t", "TIMESTAMP");
    @Override
        assertTrue("Expected at least one row for query: " + ppl, rows.size() >= 1);
        }
        assertFirstRowString(oneRow("key00") + "| eval t = typeof(num0) | fields t", "DOUBLE");  
/*  
}
     * {@code typeof} on an integer arithmetic expression. Narrow integer operands are widened
 */  
 *
    }
        Object cell = firstRowFirstCell(ppl);  
 */
 *
 * projection — no function call to route. These tests verify the  
        assertNotNull("Response missing 'rows' for query: " + ppl, rows);  
    }
    }
        return "source=" + DATASET.indexName + " | where key='" + key + "' | head 1 ";
        assertFirstRowString(oneRow("key00") + "| eval t = typeof(int0) | fields t", "INT");
public class SystemFunctionsIT extends AnalyticsRestTestCase {
        @SuppressWarnings("unchecked")
        if (dataProvisioned == false) {
 * <p>Fixture: single row {@code key00} from the {@code calcs} dataset.  
    /** {@code typeof(str0)} — PPL renders strings as "STRING". */  
import org.opensearch.client.Request;
    public void testTypeofInteger() throws IOException {  
     * opensearch-project/sql#5603), so {@code int0 * 2} is BIGINT rather than INT.  
    /** {@code typeof(bool0)} → "BOOLEAN". */
 * this file be licensed under the Apache-2.0 license or a
 * End-to-end coverage for PPL system functions.  
 * {@code FunctionImp1} that emits a VARCHAR literal ({@code  
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
    private String oneRow(String key) {
    /** {@code typeof(datetime0)} — explicit datetime column resolves to "TIMESTAMP". */
        assertNotNull("Expected non-null result for query [" + ppl + "]", cell);
    private static boolean dataProvisioned = false;  
            DatasetProvisioner.provision(client(), DATASET);
    // ── helpers ─────────────────────────────────────────────────────────────  
    }
 * contract holds end-to-end against the DataFusion backend.
 *
 * <p>{@code typeof(expr)} — PPL's {@code PPLFuncImpTable} registers this as a
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
    public void testTypeofDateField() throws IOException {  
     */
    }
 * compatible open source license.
    /** {@code typeof(date0)} — the calcs dataset maps {@code date0} as a timestamp field, so
    }  
    protected void onBeforeQuery() throws IOException {  
        assertFirstRowString(oneRow("key00") + "| eval t = typeof(int0 * 2) | fields t", "BIGINT");  
    }  
    public void testTypeofArithmetic() throws IOException {
import org.opensearch.client.Response;
    }  
    private Object firstRowFirstCell(String ppl) throws IOException {
        return rows.get(0).get(0);
    public void testTypeofString() throws IOException {
 * builder.makeLiteral(getLegacyTypeName(arg.getType(), QueryType.PPL))}) at plan-build
/**
    public void testTypeofBoolean() throws IOException {  
     * before {@code +}/{@code -}/{@code *} so the result cannot overflow the inferred type (see
    }
import java.util.Map;  
 * time, so the RelNode that reaches any backend already has a string literal in the
    }
        assertFirstRowString(oneRow("key00") + "| eval t = typeof(datetime0) | fields t", "TIMESTAMP");  
    private void assertFirstRowString(String ppl, String expected) throws IOException {
        Map<String, Object> response = executePpl(ppl);  
        assertFirstRowString(oneRow("key00") + "| eval t = typeof(str0) | fields t", "STRING");
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
import java.io.IOException;
