    }
    public void testDc_keyword_BrowserCountry() throws Exception {
        assertDcAccurate("RefererHash");
        );
    protected void onBeforeQuery() throws IOException {
/*  
        }
        }
    }  
    private static final String IDX = CLICKBENCH.indexName;  
    }
        assertDcAccurate("IsMobile");
    private static volatile boolean provisioned = false;
    }
import java.util.List;
    }
    // ── integer fields ──────────────────────────────────────────────────────────
 * SPDX-License-Identifier: Apache-2.0
    }
    public void testDc_keyword_withFilter() throws Exception {  
        if (provisioned == false) {
    // ── short (tinyint/smallint) fields ─────────────────────────────────────────
        assertDcAccurate("Age");
        assertDcWithFilterAccurate("RegionID", "GoodEvent = 1");  
/**
        int truth = ((List<List<Object>>) grouped.get("datarows")).size();  
        logger.info("dc({}) with filter '{}': result={}, truth={}", field, filter, dcVal, truth);
    public void testDc_integer_RegionID() throws Exception {  
 */  
            assertTrue("per-group dc must be > 0", dc > 0);
        assertDcWithFilterAccurate("OS", "Age > 0");
        int truth = ((List<List<Object>>) grouped.get("datarows")).size();
        assertDcAccurate("Title");
    public void testDc_short_IsMobile() throws Exception {  
 *
        assertDcAccurate("BrowserCountry");  
            double error = Math.abs(dcVal - truth) / (double) truth;  
    public void testDc_integer_withFilter() throws Exception {
        @SuppressWarnings("unchecked")
    public void testDc_short_OS() throws Exception {  
        assertNotNull(rows);  
    }
    public void testDc_short_Income() throws Exception {
    }  
 * The OpenSearch Contributors require contributions made to  
    @SuppressWarnings("unchecked")
        Map<String, Object> dc = executePpl("source=" + IDX + " | stats distinct_count(" + field + ") as dc");  
        );
    public void testDc_long_RefererHash() throws Exception {  
                "dc(" + label + ") error " + String.format(java.util.Locale.ROOT, "%.1f%%", error * 100)
            DatasetProvisioner.provision(client(), CLICKBENCH, 2);  
        assertDcWithFilterAccurate("Title", "GoodEvent = 1");
    // ── helpers ─────────────────────────────────────────────────────────────────
    // ── keyword fields ──────────────────────────────────────────────────────────
        } else {
    @SuppressWarnings("unchecked")
        logger.info("dc({}): result={}, truth={}", field, dcVal, truth);  
        if (truth <= 20) {  
        Map<String, Object> result = executePpl(
    // ── with filter (exercises delegation + partial aggregate interaction) ───────
 */
        assertFalse("grouped dc must return rows", rows.isEmpty());
            );
        }  
    // ── grouped dc ──────────────────────────────────────────────────────────────  
        for (List<Object> row : rows) {
            assertTrue(
 * this file be licensed under the Apache-2.0 license or a
        );  
}
    }
 * dc()/distinct_count() correctness across all field types on a 2-shard clickbench index.  
    }  
    public void testDc_keyword_Title() throws Exception {
        assertDcAccurate("RegionID");
    @Override  
            provisioned = true;
import java.util.Map;  
    }  
import java.io.IOException;
            "source=" + IDX + " | where " + filter + " | stats distinct_count(" + field + ") as dc"  
    public void testDc_short_withFilter() throws Exception {
    }  
    private void assertDcWithFilterAccurate(String field, String filter) throws Exception {
 * Compares HLL result against GROUP BY count (ground truth) with 5% tolerance.
            "source=" + IDX + " | stats distinct_count(Title) as dc by OS"
        Map<String, Object> grouped = executePpl(  
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
package org.opensearch.analytics.qa;
 * compatible open source license.
            int dc = ((Number) row.get(0)).intValue();  
        Map<String, Object> dc = executePpl(
        assertWithinTolerance(field + " (filtered)", dcVal, truth);
    }
    }
        assertDcAccurate("BrowserLanguage");
    }  
    public void testDc_short_Age() throws Exception {
    public void testDc_keyword_BrowserLanguage() throws Exception {  
        assertWithinTolerance(field, dcVal, truth);
        Map<String, Object> grouped = executePpl("source=" + IDX + " | stats count() by " + field);  
            assertEquals("dc(" + label + ") must be exact at low cardinality", truth, dcVal);
                error <= 0.05
        int dcVal = ((Number) ((List<List<Object>>) dc.get("datarows")).get(0).get(0)).intValue();
public class DistinctCountIT extends AnalyticsRestTestCase {  
    private void assertWithinTolerance(String label, int dcVal, int truth) {
    // ── long fields ─────────────────────────────────────────────────────────────
    private static final Dataset CLICKBENCH = ClickBenchTestHelper.DATASET;
        assertDcAccurate("OS");
            "source=" + IDX + " | where " + filter + " | stats count() by " + field
        assertDcAccurate("Income");  
    }
    public void testDc_grouped() throws Exception {
                    + " exceeds 5% (dc=" + dcVal + ", truth=" + truth + ")",  
        int dcVal = ((Number) ((List<List<Object>>) dc.get("datarows")).get(0).get(0)).intValue();
    private void assertDcAccurate(String field) throws Exception {
    }
        @SuppressWarnings("unchecked")  
