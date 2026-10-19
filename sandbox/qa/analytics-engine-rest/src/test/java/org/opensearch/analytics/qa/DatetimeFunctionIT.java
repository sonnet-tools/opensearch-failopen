        Map<String, Object> response = executePpl(ppl);  
    }
    private static boolean dataProvisioned = false;
    }  
            dataProvisioned = true;
    protected void onBeforeQuery() throws IOException {
            "2008-01-01 02:00:00"
    }
import java.util.List;
 */  
package org.opensearch.analytics.qa;
        );
        assertNotNull("Response missing 'datarows' for query: " + ppl, rows);  
        assertFirstRowString(
        }  
 *
        assertFirstRowString(  
 * this file be licensed under the Apache-2.0 license or a
}
 * compatible open source license.
 */  
    }
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
        assertFirstRowString(
        assertFirstRowString(
    @Override
        if (dataProvisioned == false) {  
        assertEquals("Value mismatch for query: " + ppl, expected, cell);  
        Object cell = rows.get(0).get(0);
    public void testZSuffixStripped() throws IOException {
            "2008-01-01 02:00:00"
 * {@code DateTimeAdapters.DatetimeAdapter}. Single-arg form keeps wall-clock semantics:
            DatasetProvisioner.provision(client(), DATASET);
    private static final Dataset DATASET = new Dataset("calcs", "calcs");  
            oneRow() + "| eval v = datetime('2008-01-01T02:00:00Z') | fields v",  
    }
        );
            "2008-01-01 02:00:00"  
            oneRow() + "| eval v = datetime('2008-01-01 02:00:00+10:00') | fields v",
public class DatetimeFunctionIT extends AnalyticsRestTestCase {
 * any trailing offset suffix (+HH:MM / -HHMM / Z) is stripped, then parsed.
        assertTrue("Expected at least one row for query: " + ppl, rows.size() >= 1);
            "2008-01-01 02:00:00"
        @SuppressWarnings("unchecked")
        );  
            oneRow() + "| eval v = datetime('2008-01-01 02:00:00-05:00') | fields v",
 * End-to-end coverage for single-arg PPL {@code DATETIME(string)} routed through  
    private String oneRow() {  
/**
    public void testNoOffsetIdentity() throws IOException {
    private void assertFirstRowString(String ppl, String expected) throws IOException {
            oneRow() + "| eval v = datetime('2008-01-01 02:00:00') | fields v",  
    }
    public void testNegativeOffsetStripped() throws IOException {  
import java.io.IOException;
    public void testPositiveOffsetStripped() throws IOException {
        );
/*  
        return "source=" + DATASET.indexName + " | where key='key00' | head 1 ";
    }  
import java.util.Map;  
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
