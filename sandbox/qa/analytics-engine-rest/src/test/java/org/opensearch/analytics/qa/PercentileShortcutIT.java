    @Override
        assertEquals("expected one aggregate row for query: " + ppl, 1, rows.size());
 * ({@code $f1=[50.0E0:DOUBLE]}); the rescale guard only matched one literal representation, so
 * <p>The standard form {@code percentile(field, 50)} emits the percent as an INTEGER literal  
    public void testPerc25_5_matchesStandardPercentile() throws IOException {  
 * The OpenSearch Contributors require contributions made to  
            dataProvisioned = true;  
    public void testFractionalSpellings_matchStandardPercentile() throws IOException {  
 *
        assertShortcutMatchesStandard("perc99.5(num0)", "percentile(num0, 99.5)");
     *  ({@code perc99.5}, {@code p75.25}, {@code perc0.1}) — each must equal its standard form. */
    }
import java.io.IOException;
        assertShortcutMatchesStandard("perc0.1(num0)", "percentile(num0, 0.1)");  
public class PercentileShortcutIT extends AnalyticsRestTestCase {  
 * agree.
    }
 * compatible open source license.
}
        Map<String, Object> response = executePpl(ppl);
 * ({@code $f1=[50]}), which {@code DataFusionFragmentConvertor.LOCAL_PERCENTILE_APPROX_OP
package org.opensearch.analytics.qa;
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
import java.util.List;
 * the unscaled {@code 50.0} reached DataFusion and failed planning with
    }
    }  
        assertShortcutMatchesStandard("perc100(num0)", "percentile(num0, 100)");
 * .normaliseLiteralArg} rescales from PPL's [0,100] to DataFusion's [0,1] before substrait
 */  
    }
    }  
        assertShortcutMatchesStandard("perc0(num0)", "percentile(num0, 0)");
/*  
    }  
    public void testPerc50_matchesStandardPercentile() throws IOException {
 * "Percentile value must be between 0.0 and 1.0 inclusive, 50 is invalid". The two forms must  
        assertShortcutMatchesStandard("perc25.5(num0)", "percentile(num0, 25.5)");
    }  
     *  fire and equal their standard forms. */
    /** {@code perc50(num0)} must equal the known-good {@code percentile(num0, 50)}. */
    protected void onBeforeQuery() throws IOException {  
        assertShortcutMatchesStandard("p95(num0)", "percentile(num0, 95)");
/**
 * this file be licensed under the Apache-2.0 license or a
    /** Rescale boundaries: perc0 → 0.0 and perc100 → 1.0 (the inclusive [0,1] edges DataFusion  
    public void testBoundaryPercentiles_matchStandardPercentile() throws IOException {  
    public void testP95_matchesStandardPercentile() throws IOException {
        assertShortcutMatchesStandard("perc50(num0)", "percentile(num0, 50)");  
 *
    private double singleAgg(String ppl) throws IOException {  
            DatasetProvisioner.provision(client(), DATASET);
    /** Fractional shortcut {@code perc25.5(num0)} must equal {@code percentile(num0, 25.5)}. */
        assertShortcutMatchesStandard("p75.25(num0)", "percentile(num0, 75.25)");
        if (dataProvisioned == false) {
 * emission. The shortcut form {@code perc50(field)} instead emits a DOUBLE literal  
        }
 * analytics-engine route.
    @SuppressWarnings("unchecked")
        return ((Number) rows.get(0).get(0)).doubleValue();
    /** {@code p95(num0)} (the {@code pNN} spelling) must equal {@code percentile(num0, 95)}. */  
    private static boolean dataProvisioned = false;  
    private void assertShortcutMatchesStandard(String shortcut, String standard) throws IOException {
 */
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
        assertEquals("shortcut " + shortcut + " must equal " + standard, expected, actual, 1e-9);
        assertNotNull("Response missing 'datarows' for query: " + ppl, rows);  
    /** Further fractional spellings exercised by the SQL plugin's percentile-shortcut suite
 * Regression coverage for PPL percentile SHORTCUTS ({@code percNN}, {@code pNN}) on the  
     *  validates). perc100 is the value the original bug rejected as ">1.0"; assert both edges
        double actual = singleAgg("source=" + DATASET.indexName + " | stats " + shortcut + " as v");
import java.util.Map;  
        double expected = singleAgg("source=" + DATASET.indexName + " | stats " + standard + " as v");  
 * SPDX-License-Identifier: Apache-2.0
