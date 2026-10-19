        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
        // Calcs str2 first 3 chars (where non-null): one, two, thr, fiv, six, eig, nin, ten,
            row(3), row(1),
            assertNull("Expected null at row " + i + " (sorted ASC nulls-first)", rows.get(i).get(0));
    private static void assertCellEquals(String message, Object expected, Object actual) {
import java.util.List;
        }
 * collation field on the same RelNode. Push-down sort by an expression (`sort abs(num0)`)
            assertNull("Top-3 nulls-first: int0 at row " + i + " should be null", rows.get(i).get(1));
                + " | eval n = abs(num0) | sort n | fields n | head 8 from 9"
                want.size(),
    // ── helpers ─────────────────────────────────────────────────────────────────
 * this file be licensed under the Apache-2.0 license or a
    private static boolean dataProvisioned = false;
            assertEquals(
    protected void onBeforeQuery() throws IOException {
    }
    public void testSortAscByInt() throws IOException {
            double a = ((Number) actual).doubleValue();
 */
        // ele, twe, fou, fif, six. Sort ASC nulls-first puts the 4 nulls first.
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");
        }
import org.opensearch.client.Request;
                    got.get(j)
import java.util.Map;
    public void testSortByAbsExpression() throws IOException {
        // First 4 rows must be nulls (4 null str2 values in calcs).
                expectedSorted[i],
        assertEquals("Row count", 9, rows.size());
    }
            "source=" + DATASET.indexName + " | eval n = abs(num0) | sort n | fields n | head 9"
        // DESC nulls-last (the analytics path follows Calcite's default DESC = NULLS LAST).
        // Skip past the 9 nulls and verify the 8 non-null abs values appear in ASC order.
    /** Numeric-tolerant cell comparator (Jackson returns Integer/Long/Double interchangeably). */
        for (int i = 0; i < 4; i++) {
        @SuppressWarnings("unchecked")
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
 */
    }
     * under a LIMIT with a narrowing Project in between, over a multi-shard-ish scan.
     *
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
            assertNotNull("Row " + i + " unexpectedly null", v);
        }
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
        // ASC nulls-first over calcs int0 ([1, null×3, 7, 3, 8, null×2, 8, 4, 10,
        Map<String, Object> response = executePpl(
        );
            assertEquals("Row " + i + " has 2 columns", 2, rows.get(i).size());
            assertNull("Row " + i + " should be null", rows.get(i).get(0));
     * throws "HASH/RANGE exchange not yet implemented [toTrait=RANDOM]".
        assertEquals("Row count == calcs row count", 17, rows.size());
        return Arrays.asList(values);
        }
    }
            assertTrue(
        for (int i = 5; i < rows.size(); i++) {
        assertNotNull("Response missing 'rows' for query: " + ppl, actualRows);
    }
        }
        // null, 4, 11, 4, 8]): top 3 are all null.
            row((Object) null), row((Object) null), row((Object) null)
    }
        @SuppressWarnings("unchecked")
            DatasetProvisioner.provision(client(), DATASET);
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
                got.size()
            List<Object> want = expected[i];
}
    @Override
            assertNotNull("Non-null after null block", curr);
        assertNotNull("Response missing 'rows'", rows);
            dataProvisioned = true;
     *  runtime-flake tests that only pass at single-shard aren't destabilized. */
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
        for (int i = 0; i < expectedSorted.length; i++) {
        Map<String, Object> response = executePpl(
     * The planner has to place an ER under the collated Sort (concat gather + global
 * Self-contained integration test for PPL {@code sort} on the analytics-engine route.
            "source="
            for (int j = 0; j < want.size(); j++) {
        );
        }
    }
        Map<String, Object> response = executePpl(
 *
 * compatible open source license.
import java.util.Arrays;
                    want.get(j),
        for (int i = 0; i < 3; i++) {
        // `substring(str2, 1, 3)` lowers to SUBSTRING($N, 1, 3) inside a LogicalProject child of
        @SuppressWarnings("unchecked")
    private final void assertRowsEqual(String ppl, List<Object>... expected) throws IOException {
    }
    private void ensureMultiShardProvisioned() throws IOException {
public class SortCommandIT extends AnalyticsRestTestCase {
            );
    }
        );
    private static List<Object> row(Object... values) {
    // ── push-down sort by scalar expression — exercises ABS / SUBSTRING capabilities ──
     *  sort/project/head planner path. Kept separate from {@link #DATASET} so the abs/substring
            "source=" + DATASET.indexName + " | eval s = substring(str2, 1, 3) | sort s | fields s"
        );
        }
        // 15.7, 15.7} for the non-null tail. Sorted ASC nulls-first puts the 9 nulls first.
                ((Number) v).doubleValue(),
        @SuppressWarnings("unchecked")
     * explores a SINGLETON→RANDOM scatter path in the resulting RelSets, convert()
            multiProvisioned = true;
            );
            String curr = (String) rows.get(i).get(0);
            );
            return;
 * lifts the expression into a {@code LogicalProject} child of the sort, which is what
     * landmine in {@code OpenSearchDistributionTraitDef.convert()}: a collated Sort
            "source=" + DATASET.indexName + " | sort -int0 | fields int0",
        // "No backend supports scalar function [SUBSTRING] among [datafusion]".
                assertCellEquals(
        assertEquals("Row count after 9 nulls", 8, rows.size());
        }
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
package org.opensearch.analytics.qa;
        double[] expectedSorted = { 0, 3.5, 3.5, 10, 12.3, 12.3, 15.7, 15.7 };
        ensureMultiShardProvisioned();
 * The OpenSearch Contributors require contributions made to
     * default ASC nulls-first).
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
     * Sort → Project → head pipeline. Exercises the exact shape flagged as a planner
        assertEquals("head 3 returns 3 rows", 3, rows.size());
        // and 8 non-nulls. abs(num0) preserves null and yields {0, 3.5, 3.5, 10, 12.3, 12.3,
        Map<String, Object> response = executePpl(ppl);
            row((Object) null), row((Object) null), row((Object) null),
 * SPDX-License-Identifier: Apache-2.0
        @SuppressWarnings("unchecked")
 * <p>Mirrors {@code CalciteSortCommandIT} / {@code CalcitePPLSortIT}. {@code sort} lowers
        );
            row((Object) null), row((Object) null), row((Object) null),
    private static boolean multiProvisioned = false;
            return;
    public void testSortBySubstringExpression() throws IOException {
import org.opensearch.client.Response;
 * to {@code LogicalSort}; the asc / desc / nulls-first / nulls-last variants set the
    private static final Dataset DATASET_MULTI = new Dataset("calcs", "calcs_multi_sort");
        // "No backend supports scalar function [ABS] among [datafusion]".
    public void testSortThenProjectThenHead() throws IOException {
            row(11), row(10), row(8), row(8), row(8), row(7), row(4), row(4), row(4),
                "abs(num0) sorted value at row " + i,
     * <p>Asserts top-3 int0 values from calcs: [null, null, null] (6 nulls total,
                + DATASET.indexName
        assertNotNull("Response missing 'rows'", rows);
    }
        // null, 4, 11, 4, 8] — 6 nulls and 11 integers. Default sort is ASC nulls-first.
            "source=" + DATASET.indexName + " | sort int0 | fields int0",
        for (int i = 0; i < expected.length; i++) {
            double e = ((Number) expected).doubleValue();
    /** Provision a multi-shard calcs index for tests that need to exercise the multi-shard
        // int0 across the 17 calcs rows: [1, null, null, null, 7, 3, 8, null, null, 8, 4, 10,
                );
        //
        }
     */
    // ── plain field sort ───────────────────────────────────────────────────────
            }
        if (dataProvisioned == false) {
            assertEquals(
    public void testSortDescByInt() throws IOException {
        // the sort. Without SUBSTRING in STANDARD_PROJECT_OPS, the planner rejects it with
            }
        //
        assertNotNull("Response missing 'rows'", rows);
            Object v = rows.get(i).get(0);
        for (int i = 0; i < 9; i++) {
 * and {@link org.opensearch.analytics.spi.ScalarFunction#SUBSTRING} added in this PR.
                1e-9
        // ABS in STANDARD_PROJECT_OPS, the analytics planner rejects the projection with
        // Calcs num0: [12.3, -12.3, 15.7, -15.7, 3.5, -3.5, 0, null, 10, null x8] — 9 nulls
    public void testSortByAbsTakesNonNullsFromTail() throws IOException {
    @SafeVarargs
        // `abs(num0)` lowers to ABS($N) inside a LogicalProject child of the sort. Without
                prev.compareTo(curr) <= 0
                "Column count mismatch at row " + i + " for query: " + ppl,
        if (expected == null || actual == null) {
            String prev = (String) rows.get(i - 1).get(0);
            "source=" + DATASET_MULTI.indexName + " | sort int0 | fields str0, int0 | head 3"
        assertEquals(message, expected, actual);
            DatasetProvisioner.provision(client(), DATASET_MULTI, 3);
/*
    }
/**
                "Sort order violation at row " + i + ": " + prev + " > " + curr,
            if (Double.compare(e, a) != 0) {
        // The remaining 13 must be sorted alphabetically.
        Map<String, Object> response = executePpl(
    /**
            row(1), row(3), row(4), row(4), row(4), row(7), row(8), row(8), row(8), row(10), row(11)
            row((Object) null), row((Object) null), row((Object) null),
        assertNotNull("Response missing 'rows'", rows);
 * exercises the new project-side capabilities for {@link org.opensearch.analytics.spi.ScalarFunction#ABS}
        if (multiProvisioned == false) {
     * sort) and leave the outer LIMIT without an additional ER — if Volcano ever
        assertRowsEqual(
        if (expected instanceof Number && actual instanceof Number) {
        );
            assertEquals(message, expected, actual);
 *
        assertRowsEqual(
import java.io.IOException;
            List<Object> got = actualRows.get(i);
        }
    @SuppressWarnings("varargs")
