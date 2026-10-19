    // --- IS_NOT_NULL cases ---
 * str1 present for 6, missing for 4. num0 ∈ 10,20,...,100.  
                assertNotNull("datarows null for [" + dc.pplSuffix + "]", rows);
    );  
                assertEquals("[" + dc.pplSuffix + "]", dc.expected, actual, 0.1);
        new Case("where num0 < 40 | stats count() as c", 3, false),
    // --- IS_NULL cases ---
        assertEquals("[" + pplSuffix + "] row count", expected, rows.size());
        new Case("where str0 like '%e%' | stats count() as c", 7, false),
 * <p>Dataset: str0 ∈ apple×3, banana×3, cherry×2, date×2 (10 docs).
        new Case("where str0 != 'apple' | stats avg(num0) as c", 70, false),
    // isnull(str1) → 4 docs (apple×1, banana×1, cherry×1, date×1)
            } catch (AssertionError | Exception e) {
    // str0 != 'apple' → banana×3 + cherry×2 + date×2 = 7 docs  
        // ===== PERCENTILE =====  
        new Case("where isnull(str1) | stats dc(num0) as c", 4, false),  
 * (PPL suffix, expected value) pair — add new predicates by appending to {@link #CASES}.
        new Case("where str0 != 'apple' | fields str0", 7, true),  
        new Case("where isnull(str1) | fields str0", 4, true),  
        new Case("where isnull(str1) | stats count() as c", 4, false),
        if (!failures.isEmpty()) {  
                assertEquals("expected 1 agg row for [" + dc.pplSuffix + "]", 1, rows.size());  
 * IS_NULL, IS_NOT_NULL, NOT_EQUALS, and future comparisons/IN/RANGE all have unambiguous
        new Case("where str0 != 'banana' | stats dc(str0) as c", 3, false),
    private static boolean dataProvisioned = false;
            try {
        new StatisticalCase("where isnull(str1) | stats stddev_pop(num0) as c", 25.860201),
        assertEquals("expected 1 agg row for [" + pplSuffix + "]", 1, rows.size());
        }
    }
    @Override  
        new Case("where str0 != 'cherry' | stats avg(num0) as c", 50, false),
        if (!failures.isEmpty()) {
    @SuppressWarnings("unchecked")  
            }
import java.util.Map;  
 *
        Map<String, Object> result = executePpl(ppl);
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
/*  
            DatasetProvisioner.provision(client(), DATASET);  
        new Case("where num0 > 50 | stats sum(num0) as c", 400, false),  
        new Case("where isnotnull(str1) | stats sum(num0) as c", 280, false),  
    }
                Map<String, Object> result = executePpl(ppl);  
    private record Case(String pplSuffix, long expected, boolean isRowCount) {}  
    private static final List<Case> CASES = List.of(
        new StatisticalCase("where str0 != 'apple' | stats stddev_samp(num0) as c", 21.602469),  
    private record StatisticalCase(String pplSuffix, double expected) {}
                List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
        // ===== AVG — additional exact-integer cases =====
            dataProvisioned = true;
 * Table-driven filter delegation IT for extended predicate shapes. Each case is a  
        new Case("where str0 != 'apple' | stats min(num0) as c", 40, false),  
        new Case("where isnull(str1) | stats max(num0) as c", 100, false),
                failures.add(c.pplSuffix + " → " + e.getMessage());  
        new Case("where isnotnull(str1) | stats max(num0) as c", 90, false),
    protected void onBeforeQuery() throws IOException {
        new Case("where str0 in ('apple', 'cherry') | stats sum(num0) as c", 210, false),
            fail("Statistical aggregate failures (" + failures.size() + " of " + STATISTICAL_CASES.size() + "):\n"
    @SuppressWarnings("unchecked")
        new Case("where isnull(str1) | stats dc(str0) as c", 4, false),
                + String.join("\n", failures));
                + String.join("\n", failures));  
        assertEquals("[" + pplSuffix + "]", expected, ((Number) rows.get(0).get(0)).longValue());
    // --- NOT_EQUALS cases ---
        new Case("where num0 > 50 | stats count() as c", 5, false),
        new StatisticalCase("where isnotnull(str1) | stats stddev_pop(num0) as c", 27.487371),  
        // ===== IS_NULL with various aggregates =====  
        new Case("where isnotnull(str1) | stats min(num0) as c", 10, false),
        if (!dataProvisioned) {
 */  
package org.opensearch.analytics.qa;
        new Case("where isnull(str1) | stats sum(num0) as c", 270, false),
        new Case("where isnull(str1) | stats min(num0) as c", 30, false),  
        }  
        String ppl = "source = " + DATASET.indexName + " | " + pplSuffix;
    // isnotnull(str1) → 6 docs (apple×2, banana×2, cherry×1, date×1)
        new Case("where str0 in ('apple', 'cherry') | stats count() as c", 5, false),
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
/**
        new Case("where str0 like 'app%' | stats count() as c", 3, false),  
                if (c.isRowCount) {  
        new StatisticalCase("where isnull(str1) | stats stddev_samp(num0) as c", 29.860788),
    private static final Dataset DATASET = new Dataset("filter_delegation_extended", "filter_delegation_extended");
 * <p>Uses the {@code filter_delegation_extended} dataset (2 shards, keyword + nullable keyword  
        String ppl = "source = " + DATASET.indexName + " | " + pplSuffix;  
        new Case("where str0 != 'apple' | stats max(num0) as c", 100, false),
        // ===== dc() across more predicate shapes =====
        new Case("where num0 <= 40 | stats count() as c", 4, false),
    @SuppressWarnings("unchecked")
 */
        new Case("where isnotnull(str1) | stats dc(str0) as c", 4, false),  
        }
        List<String> failures = new java.util.ArrayList<>();
}
            }
    public void testStatisticalAggregatesWithDelegation() throws Exception {
    }  
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");  
import java.io.IOException;
                    assertRowCount(c.pplSuffix, (int) c.expected);
        List<String> failures = new java.util.ArrayList<>();  
    private void assertAggCount(String pplSuffix, long expected) throws Exception {
                double actual = ((Number) rows.get(0).get(0)).doubleValue();
    private void assertRowCount(String pplSuffix, int expected) throws Exception {  
        }  
        new Case("where str0 != 'apple' | stats sum(num0) as c", 490, false),
    // str0 != 'banana' → apple×3 + cherry×2 + date×2 = 7 docs
 *
        new Case("where str0 != 'apple' | stats dc(str0) as c", 3, false),
        assertNotNull("datarows null for [" + pplSuffix + "]", rows);
        new Case("where isnotnull(str1) | stats count() as c", 6, false),
    // str0 != 'date' → apple×3 + banana×3 + cherry×2 = 8 docs
        new Case("where isnull(str1) | stats percentile(num0, 50) as c", 70, false)
        for (StatisticalCase dc : STATISTICAL_CASES) {  
        new Case("where str0 like 'ban%' | stats sum(num0) as c", 150, false),
 * The OpenSearch Contributors require contributions made to  
    }  
        for (Case c : CASES) {
        // ===== NOT_EQUALS with various aggregates =====
        // ===== IN =====  
public class FilterDelegationExtendedIT extends AnalyticsRestTestCase {
 * + integer fields) provisioned via {@link DatasetProvisioner}. The dataset is designed so
            } catch (AssertionError | Exception e) {  
        new Case("where str0 != 'apple' | stats count() as c", 7, false),  
 * compatible open source license.
            try {
        new Case("where num0 > 50 | stats dc(str0) as c", 3, false),
        new Case("where isnotnull(str1) | stats dc(num0) as c", 6, false),
        new StatisticalCase("where isnotnull(str1) | stats stddev_samp(num0) as c", 30.110906)
        // ===== IS_NOT_NULL with various aggregates =====
        }
                } else {
                String ppl = "source = " + DATASET.indexName + " | " + dc.pplSuffix;
 * expected counts.  
    public void testFilterDelegationExtended() throws Exception {
        assertNotNull("datarows null for [" + pplSuffix + "]", rows);  
        Map<String, Object> result = executePpl(ppl);
        // ===== LIKE (keyword field only) =====
        new StatisticalCase("where str0 != 'apple' | stats stddev_pop(num0) as c", 20.0),
        new Case("where isnotnull(str1) | fields str0, str1", 6, true),
                    assertAggCount(c.pplSuffix, c.expected);  
        new Case("where str0 != 'date' | stats avg(num0) as c", 45, false),
            fail("Filter delegation failures (" + failures.size() + " of " + CASES.size() + "):\n"
    );
    }  
                }
    private static final List<StatisticalCase> STATISTICAL_CASES = List.of(
 *
 * this file be licensed under the Apache-2.0 license or a
        new Case("where str0 != 'date' | stats dc(str0) as c", 3, false),
        // ===== Comparisons (GT/GTE/LT/LTE on integer field) =====
        new Case("where str0 != 'apple' | stats percentile(num0, 50) as c", 70, false),
        new Case("where num0 >= 50 | stats count() as c", 6, false),  
                failures.add(dc.pplSuffix + " → " + e.getMessage());
