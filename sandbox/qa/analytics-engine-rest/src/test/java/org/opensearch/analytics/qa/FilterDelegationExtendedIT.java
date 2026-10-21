        }
        assertEquals("expected 1 agg row for [" + pplSuffix + "]", 1, rows.size());
    @Override
        // ===== Comparisons (GT/GTE/LT/LTE on integer field) =====
    );
        new Case("where isnull(str1) | stats min(num0) as c", 30, false),
                String ppl = "source = " + DATASET.indexName + " | " + dc.pplSuffix;
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
 *
        new Case("where str0 != 'date' | stats dc(str0) as c", 3, false),
        new Case("where isnull(str1) | stats count() as c", 4, false),
        // ===== AVG — additional exact-integer cases =====
    // str0 != 'apple' → banana×3 + cherry×2 + date×2 = 7 docs
        new Case("where str0 != 'apple' | stats dc(str0) as c", 3, false),
        new Case("where str0 != 'date' | stats avg(num0) as c", 45, false),
        // ===== PERCENTILE =====
package org.opensearch.analytics.qa;
        new Case("where str0 != 'cherry' | stats avg(num0) as c", 50, false),
            dataProvisioned = true;
                Map<String, Object> result = executePpl(ppl);
        new StatisticalCase("where str0 != 'apple' | stats stddev_samp(num0) as c", 21.602469),
        new Case("where num0 < 40 | stats count() as c", 3, false),
    }
        String ppl = "source = " + DATASET.indexName + " | " + pplSuffix;
        new Case("where str0 != 'banana' | stats dc(str0) as c", 3, false),
    private record StatisticalCase(String pplSuffix, double expected) {}
    private static final List<Case> CASES = List.of(
    private static final Dataset DATASET = new Dataset("filter_delegation_extended", "filter_delegation_extended");
        new Case("where isnotnull(str1) | stats sum(num0) as c", 280, false),
        // ===== NOT_EQUALS with various aggregates =====
            fail("Filter delegation failures (" + failures.size() + " of " + CASES.size() + "):\n"
 */
            try {
 * compatible open source license.
 * Table-driven filter delegation IT for extended predicate shapes. Each case is a
        new StatisticalCase("where str0 != 'apple' | stats stddev_pop(num0) as c", 20.0),
            }
        List<String> failures = new java.util.ArrayList<>();
        new Case("where str0 != 'apple' | stats percentile(num0, 50) as c", 70, false),
        new Case("where isnull(str1) | stats percentile(num0, 50) as c", 70, false)
                assertEquals("expected 1 agg row for [" + dc.pplSuffix + "]", 1, rows.size());
    // str0 != 'date' → apple×3 + banana×3 + cherry×2 = 8 docs
                + String.join("\n", failures));
    private static boolean dataProvisioned = false;
        new Case("where str0 != 'apple' | fields str0", 7, true),
        assertEquals("[" + pplSuffix + "] row count", expected, rows.size());
 * this file be licensed under the Apache-2.0 license or a
 * <p>Dataset: str0 ∈ apple×3, banana×3, cherry×2, date×2 (10 docs).
 * (PPL suffix, expected value) pair — add new predicates by appending to {@link #CASES}.
        for (Case c : CASES) {
import java.io.IOException;
        new StatisticalCase("where isnotnull(str1) | stats stddev_samp(num0) as c", 30.110906)
        new Case("where str0 like '%e%' | stats count() as c", 7, false),
        new Case("where str0 like 'ban%' | stats sum(num0) as c", 150, false),
                failures.add(c.pplSuffix + " → " + e.getMessage());
/**
 */
        new Case("where num0 >= 50 | stats count() as c", 6, false),
        new Case("where num0 > 50 | stats dc(str0) as c", 3, false),
    // str0 != 'banana' → apple×3 + cherry×2 + date×2 = 7 docs
        new Case("where str0 != 'apple' | stats sum(num0) as c", 490, false),
        new Case("where str0 like 'app%' | stats count() as c", 3, false),
    public void testStatisticalAggregatesWithDelegation() throws Exception {
    protected void onBeforeQuery() throws IOException {
        new Case("where isnull(str1) | stats max(num0) as c", 100, false),
 * SPDX-License-Identifier: Apache-2.0
        new Case("where isnotnull(str1) | stats count() as c", 6, false),
    private static final List<StatisticalCase> STATISTICAL_CASES = List.of(
        Map<String, Object> result = executePpl(ppl);
                double actual = ((Number) rows.get(0).get(0)).doubleValue();
        }
        new Case("where isnull(str1) | fields str0", 4, true),
    public void testFilterDelegationExtended() throws Exception {
 *
        new StatisticalCase("where isnull(str1) | stats stddev_samp(num0) as c", 29.860788),
        String ppl = "source = " + DATASET.indexName + " | " + pplSuffix;
        // ===== IS_NULL with various aggregates =====
                List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
        // ===== IS_NOT_NULL with various aggregates =====
        new Case("where str0 in ('apple', 'cherry') | stats sum(num0) as c", 210, false),
import java.util.Map;
        assertNotNull("datarows null for [" + pplSuffix + "]", rows);
        new Case("where isnull(str1) | stats dc(num0) as c", 4, false),
                if (c.isRowCount) {
        // ===== dc() across more predicate shapes =====
        assertNotNull("datarows null for [" + pplSuffix + "]", rows);
 * The OpenSearch Contributors require contributions made to
        for (StatisticalCase dc : STATISTICAL_CASES) {
                assertEquals("[" + dc.pplSuffix + "]", dc.expected, actual, 0.1);
        if (!dataProvisioned) {
        new StatisticalCase("where isnull(str1) | stats stddev_pop(num0) as c", 25.860201),
        new StatisticalCase("where isnotnull(str1) | stats stddev_pop(num0) as c", 27.487371),
    // --- NOT_EQUALS cases ---
        List<String> failures = new java.util.ArrayList<>();
        new Case("where isnotnull(str1) | stats min(num0) as c", 10, false),
                assertNotNull("datarows null for [" + dc.pplSuffix + "]", rows);
        new Case("where isnotnull(str1) | stats dc(str0) as c", 4, false),
        new Case("where str0 != 'apple' | stats count() as c", 7, false),
 *
    // isnull(str1) → 4 docs (apple×1, banana×1, cherry×1, date×1)
 * <p>Uses the {@code filter_delegation_extended} dataset (2 shards, keyword + nullable keyword
    }
    // --- IS_NULL cases ---
public class FilterDelegationExtendedIT extends AnalyticsRestTestCase {
    @SuppressWarnings("unchecked")
    // --- IS_NOT_NULL cases ---
        if (!failures.isEmpty()) {
    );
        // ===== IN =====
    }
        new Case("where isnotnull(str1) | fields str0, str1", 6, true),
}
            DatasetProvisioner.provision(client(), DATASET);
        Map<String, Object> result = executePpl(ppl);
    @SuppressWarnings("unchecked")
        new Case("where num0 > 50 | stats sum(num0) as c", 400, false),
 * + integer fields) provisioned via {@link DatasetProvisioner}. The dataset is designed so
            fail("Statistical aggregate failures (" + failures.size() + " of " + STATISTICAL_CASES.size() + "):\n"
                    assertAggCount(c.pplSuffix, c.expected);
        // ===== LIKE (keyword field only) =====
        new Case("where isnull(str1) | stats dc(str0) as c", 4, false),
                + String.join("\n", failures));
        new Case("where isnotnull(str1) | stats max(num0) as c", 90, false),
        }
        new Case("where isnull(str1) | stats sum(num0) as c", 270, false),
    private record Case(String pplSuffix, long expected, boolean isRowCount) {}
        new Case("where num0 <= 40 | stats count() as c", 4, false),
        new Case("where str0 in ('apple', 'cherry') | stats count() as c", 5, false),
        }
        new Case("where str0 != 'apple' | stats max(num0) as c", 100, false),
        List<List<Object>> rows = (List<List<Object>>) result.get("datarows");
            } catch (AssertionError | Exception e) {
            try {
                    assertRowCount(c.pplSuffix, (int) c.expected);
    private void assertRowCount(String pplSuffix, int expected) throws Exception {
    }
 * expected counts.
                }
    @SuppressWarnings("unchecked")
/*
            }
        new Case("where str0 != 'apple' | stats min(num0) as c", 40, false),
        if (!failures.isEmpty()) {
        assertEquals("[" + pplSuffix + "]", expected, ((Number) rows.get(0).get(0)).longValue());
 * IS_NULL, IS_NOT_NULL, NOT_EQUALS, and future comparisons/IN/RANGE all have unambiguous
                failures.add(dc.pplSuffix + " → " + e.getMessage());
    }
 * str1 present for 6, missing for 4. num0 ∈ 10,20,...,100.
        new Case("where num0 > 50 | stats count() as c", 5, false),
import java.util.List;
            } catch (AssertionError | Exception e) {
        new Case("where isnotnull(str1) | stats dc(num0) as c", 6, false),
                } else {
        }
        new Case("where str0 != 'apple' | stats avg(num0) as c", 70, false),
    private void assertAggCount(String pplSuffix, long expected) throws Exception {
    // isnotnull(str1) → 6 docs (apple×2, banana×2, cherry×1, date×1)
