    }
 *
    }
        assertFirstRowString(
    }
            DatasetProvisioner.provision(client(), DATASET);
     * PPL (ConvertTZFunctionIT#nullToFieldOver).  
        @SuppressWarnings("unchecked")  
     */
    private static boolean dataProvisioned = false;
     * Out-of-range {@code from} offset ({@code -17:00}, well below the negative cap) → NULL, matching  
 * The OpenSearch Contributors require contributions made to  
        assertFirstRowNull(oneRow() + "| eval v = convert_tz('2021-05-12 11:34:50', '-12:00', '+14:01') | fields v");
 * {@code ConvertTzAdapter}. Pins the SAFE-cast paths in identity short-circuit
    }
    public void testNullOnJustBelowNegativeCap() throws IOException {
            "2021-05-12 11:34:50"
/**
        assertEquals("Value mismatch for query: " + ppl, expected, firstRowFirstCell(ppl));  
     */  
        assertTrue("Expected at least one row for query: " + ppl, rows.size() >= 1);  
    /**
            "2021-05-12 15:00:00"
            oneRow() + "| eval v = convert_tz('2021-05-12 00:00:00', '+00:00', '+14:00') | fields v",  
        }  
    }  
            oneRow() + "| eval v = convert_tz('2021-05-12 15:00:00', '-13:59', '-13:59') | fields v",  
        assertNotNull("Response missing 'datarows' for query: " + ppl, rows);
            dataProvisioned = true;
     * Negative-cap boundary ({@code -13:59}) is in-band on both sides → identity short-circuit  
        assertFirstRowNull(oneRow() + "| eval v = convert_tz('2021-05-12 11:34:50', '-12:00', '+15:00') | fields v");  
    protected void onBeforeQuery() throws IOException {
        assertFirstRowString(
     * {@code ConvertTZFunctionIT#nullField3Over} — the boundary the original adapter missed.
    public void testNullOnJustAbovePositiveCap() throws IOException {
        if (dataProvisioned == false) {  
        assertFirstRowNull(oneRow() + "| eval v = convert_tz('2021-05-30 11:34:50', '-14:00', '+08:00') | fields v");  
 * this file be licensed under the Apache-2.0 license or a
}  
        assertFirstRowString(
     */
        Map<String, Object> response = executePpl(ppl);
 * compatible open source license.
    public void testInBandNegativeCapShortCircuits() throws IOException {
    public void testUdfFallbackWithVarcharOperand() throws IOException {
    }  
    }
/*  
    }
    public void testIdentityShortCircuitWithVarcharOperand() throws IOException {
     * Pre-fix this passed because the bound was {@code hours <= 14}; post-fix the explicit
    public void testInBandPositiveCapAppliesOffset() throws IOException {
        assertFirstRowNull(oneRow() + "| eval v = convert_tz('2021-05-30 11:34:50', '-17:00', '+08:00') | fields v");
    /** Different from/to tz with VARCHAR operand → UDF fallback applies the offset. */  
        assertNull("Expected NULL result for query: " + ppl, firstRowFirstCell(ppl));
    private void assertFirstRowString(String ppl, String expected) throws IOException {
 * (same from/to tz) and UDF fallback (different tzs).
import java.util.List;
    private String oneRow() {  
            "2021-05-12 14:00:00"
    /** Same from/to tz with VARCHAR operand → identity short-circuit returns the timestamp unchanged. */
    /**
     * regression guard against the boundary-tightening accidentally rejecting the cap itself.
    private static final Dataset DATASET = new Dataset("calcs", "calcs");  
            "2021-05-12 03:34:50"
    }  
     * returns the timestamp unchanged. Mirrors {@code ConvertTZFunctionIT#inRangeMinOnPoint};
    }
        );  
     * Just below the negative cap ({@code -14:00}) → NULL. MySQL's CONVERT_TZ band is
            oneRow() + "| eval v = convert_tz('2021-05-12 11:34:50', '+00:00', '-08:00') | fields v",  
 */  
    public void testNullOnOutOfRangeToOffset() throws IOException {
     * and returned a shifted timestamp. Mirrors {@code ConvertTZFunctionIT#nullField2Under}.  
     * Positive-cap boundary ({@code +14:00}) is in-band → UDF fallback applies the offset.  
 * SPDX-License-Identifier: Apache-2.0
     */
     */  
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
    /**  
package org.opensearch.analytics.qa;
import java.io.IOException;
import java.util.Map;  
            oneRow() + "| eval v = convert_tz('2021-05-12 11:34:50', '+00:00', '+00:00') | fields v",
    /**
    private void assertFirstRowNull(String ppl) throws IOException {  
        return "source=" + DATASET.indexName + " | where key='key00' | head 1 ";
        );
        );
 */  
    public void testNullOnOutOfRangeFromOffset() throws IOException {  
     * Just above the positive cap ({@code +14:01}) → NULL. Mirrors
    }
    }
     * band check still admits {@code +14:00} exactly.
        assertFirstRowString(  
    }  
    /**
    @Override
     * {@code [-13:59, +14:00]}; pre-fix the adapter accepted any {@code hours <= 14}
    /**  
        return rows.get(0).get(0);
    private Object firstRowFirstCell(String ppl) throws IOException {
 * End-to-end coverage for PPL {@code convert_tz(<varchar>, ...)} routed through  
     * reference PPL (ConvertTZFunctionIT#nullFromFieldUnder).
public class ConvertTzFunctionIT extends AnalyticsRestTestCase {
     */  
        );
     * Out-of-range {@code to} offset ({@code +15:00}, above the positive cap) → NULL, matching reference
