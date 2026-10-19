                "Column count mismatch at row " + i + " for query: " + ppl,  
    }  
            row((Object) null), row((Object) null), row((Object) null)
            return;  
            );  
/*  
                "Sort order violation at row " + i + ": " + prev + " > " + curr,  
    public void testSortBySubstringExpression() throws IOException {  
    @Override  
        }
        // DESC nulls-last (the analytics path follows Calcite's default DESC = NULLS LAST).
        );
            assertNull("Top-3 nulls-first: int0 at row " + i + " should be null", rows.get(i).get(1));
    private static List<Object> row(Object... values) {
        assertEquals("Row count", 9, rows.size());
     * landmine in {@code OpenSearchDistributionTraitDef.convert()}: a collated Sort  
        // "No backend supports scalar function [SUBSTRING] among [datafusion]".  
     *  sort/project/head planner path. Kept separate from {@link #DATASET} so the abs/substring  
        for (int i = 0; i < expected.length; i++) {
    private static final Dataset DATASET = new Dataset("calcs", "calcs");  
import java.util.Map;
        for (int i = 0; i < 9; i++) {
        // `substring(str2, 1, 3)` lowers to SUBSTRING($N, 1, 3) inside a LogicalProject child of
        // int0 across the 17 calcs rows: [1, null, null, null, 7, 3, 8, null, null, 8, 4, 10,  
        }  
        return Arrays.asList(values);  
        // Calcs str2 first 3 chars (where non-null): one, two, thr, fiv, six, eig, nin, ten,
            assertNull("Expected null at row " + i + " (sorted ASC nulls-first)", rows.get(i).get(0));
        // "No backend supports scalar function [ABS] among [datafusion]".
        }
        // First 4 rows must be nulls (4 null str2 values in calcs).
                "abs(num0) sorted value at row " + i,
            multiProvisioned = true;
        }  
     * default ASC nulls-first).
            List<Object> got = actualRows.get(i);
        Map<String, Object> response = executePpl(
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
            assertNull("Row " + i + " should be null", rows.get(i).get(0));  
     * The planner has to place an ER under the collated Sort (concat gather + global
    public void testSortAscByInt() throws IOException {
        Map<String, Object> response = executePpl(  
    public void testSortByAbsExpression() throws IOException {
        }
 *
        if (multiProvisioned == false) {  
        }  
    private static void assertCellEquals(String message, Object expected, Object actual) {  
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");  
        Map<String, Object> response = executePpl(ppl);  
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
            String curr = (String) rows.get(i).get(0);  
 * collation field on the same RelNode. Push-down sort by an expression (`sort abs(num0)`)
        assertEquals("Row count after 9 nulls", 8, rows.size());
            }
 *
     * explores a SINGLETON→RANDOM scatter path in the resulting RelSets, convert()
            double a = ((Number) actual).doubleValue();
                ((Number) v).doubleValue(),
 * exercises the new project-side capabilities for {@link org.opensearch.analytics.spi.ScalarFunction#ABS}
            assertEquals(
            if (Double.compare(e, a) != 0) {
 * The OpenSearch Contributors require contributions made to  
     * throws "HASH/RANGE exchange not yet implemented [toTrait=RANDOM]".
        @SuppressWarnings("unchecked")  
 * compatible open source license.
                prev.compareTo(curr) <= 0
            double e = ((Number) expected).doubleValue();  
        assertNotNull("Response missing 'rows'", rows);
            "source=" + DATASET.indexName + " | eval n = abs(num0) | sort n | fields n | head 9"
                want.size(),
    public void testSortThenProjectThenHead() throws IOException {
        assertEquals(message, expected, actual);
        if (expected instanceof Number && actual instanceof Number) {
            dataProvisioned = true;
                    want.get(j),
     * <p>Asserts top-3 int0 values from calcs: [null, null, null] (6 nulls total,
        assertNotNull("Response missing 'rows'", rows);  
    /** Provision a multi-shard calcs index for tests that need to exercise the multi-shard
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");  
    // ── helpers ─────────────────────────────────────────────────────────────────  
            "source="
        @SuppressWarnings("unchecked")
            List<Object> want = expected[i];  
    }
 * to {@code LogicalSort}; the asc / desc / nulls-first / nulls-last variants set the
        // Calcs num0: [12.3, -12.3, 15.7, -15.7, 3.5, -3.5, 0, null, 10, null x8] — 9 nulls
            row((Object) null), row((Object) null), row((Object) null),
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
        );  
    public void testSortByAbsTakesNonNullsFromTail() throws IOException {
            row(1), row(3), row(4), row(4), row(4), row(7), row(8), row(8), row(8), row(10), row(11)  
            "source=" + DATASET.indexName + " | sort -int0 | fields int0",
import java.util.List;  
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
        for (int i = 0; i < expectedSorted.length; i++) {
        // the sort. Without SUBSTRING in STANDARD_PROJECT_OPS, the planner rejects it with
 * <p>Mirrors {@code CalciteSortCommandIT} / {@code CalcitePPLSortIT}. {@code sort} lowers  
    @SuppressWarnings("varargs")
 */  
        //  
        // Skip past the 9 nulls and verify the 8 non-null abs values appear in ASC order.
        );  
                    got.get(j)
     */  
            for (int j = 0; j < want.size(); j++) {
        // ABS in STANDARD_PROJECT_OPS, the analytics planner rejects the projection with
        }
            row((Object) null), row((Object) null), row((Object) null),
            "source=" + DATASET_MULTI.indexName + " | sort int0 | fields str0, int0 | head 3"
        // ASC nulls-first over calcs int0 ([1, null×3, 7, 3, 8, null×2, 8, 4, 10,
    protected void onBeforeQuery() throws IOException {
        for (int i = 5; i < rows.size(); i++) {
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,  
                got.size()
        @SuppressWarnings("unchecked")
        assertNotNull("Response missing 'rows'", rows);
    }
                expectedSorted[i],  
package org.opensearch.analytics.qa;
        double[] expectedSorted = { 0, 3.5, 3.5, 10, 12.3, 12.3, 15.7, 15.7 };  
    }
        //
import java.util.Arrays;
        for (int i = 0; i < 3; i++) {  
            Object v = rows.get(i).get(0);
            DatasetProvisioner.provision(client(), DATASET);  
            return;
        if (expected == null || actual == null) {
        // null, 4, 11, 4, 8] — 6 nulls and 11 integers. Default sort is ASC nulls-first.
public class SortCommandIT extends AnalyticsRestTestCase {
    // ── push-down sort by scalar expression — exercises ABS / SUBSTRING capabilities ──  
            row(3), row(1),  
            );  
     *  runtime-flake tests that only pass at single-shard aren't destabilized. */
            assertEquals(
    @SafeVarargs  
    // ── plain field sort ───────────────────────────────────────────────────────  
        }
        );
        assertNotNull("Response missing 'rows' for query: " + ppl, actualRows);  
        for (int i = 0; i < 4; i++) {  
                assertCellEquals(
        // 15.7, 15.7} for the non-null tail. Sorted ASC nulls-first puts the 9 nulls first.  
    /** Numeric-tolerant cell comparator (Jackson returns Integer/Long/Double interchangeably). */
    private static boolean multiProvisioned = false;
        // ele, twe, fou, fif, six. Sort ASC nulls-first puts the 4 nulls first.  
/**  
        Map<String, Object> response = executePpl(  
        // The remaining 13 must be sorted alphabetically.  
        // and 8 non-nulls. abs(num0) preserves null and yields {0, 3.5, 3.5, 10, 12.3, 12.3,
            assertNotNull("Non-null after null block", curr);
        );
            "source=" + DATASET.indexName + " | eval s = substring(str2, 1, 3) | sort s | fields s"
import org.opensearch.client.Request;
        // null, 4, 11, 4, 8]): top 3 are all null.
            assertNotNull("Row " + i + " unexpectedly null", v);  
            }
    }
    }
}
    private void ensureMultiShardProvisioned() throws IOException {
        assertRowsEqual(
            row(11), row(10), row(8), row(8), row(8), row(7), row(4), row(4), row(4),
    private static final Dataset DATASET_MULTI = new Dataset("calcs", "calcs_multi_sort");
 * lifts the expression into a {@code LogicalProject} child of the sort, which is what  
 * and {@link org.opensearch.analytics.spi.ScalarFunction#SUBSTRING} added in this PR.
    }
            assertEquals("Row " + i + " has 2 columns", 2, rows.get(i).size());
        }
    }
        assertNotNull("Response missing 'rows'", rows);  
 * this file be licensed under the Apache-2.0 license or a
        @SuppressWarnings("unchecked")
import org.opensearch.client.Response;
        // `abs(num0)` lowers to ABS($N) inside a LogicalProject child of the sort. Without  
            "source=" + DATASET.indexName + " | sort int0 | fields int0",  
     * sort) and leave the outer LIMIT without an additional ER — if Volcano ever  
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
            assertEquals(message, expected, actual);
            );
        if (dataProvisioned == false) {
    public void testSortDescByInt() throws IOException {
     * Sort → Project → head pipeline. Exercises the exact shape flagged as a planner
        @SuppressWarnings("unchecked")
        assertEquals("head 3 returns 3 rows", 3, rows.size());  
     * under a LIMIT with a narrowing Project in between, over a multi-shard-ish scan.
                1e-9
            assertTrue(
        }  
 * Self-contained integration test for PPL {@code sort} on the analytics-engine route.
        );  
        Map<String, Object> response = executePpl(
                + " | eval n = abs(num0) | sort n | fields n | head 8 from 9"  
     *  
                );  
            String prev = (String) rows.get(i - 1).get(0);
        assertRowsEqual(  
 */  
        assertEquals("Row count == calcs row count", 17, rows.size());
            DatasetProvisioner.provision(client(), DATASET_MULTI, 3);
                + DATASET.indexName
    private final void assertRowsEqual(String ppl, List<Object>... expected) throws IOException {
    }
 * SPDX-License-Identifier: Apache-2.0
        ensureMultiShardProvisioned();
    }
            row((Object) null), row((Object) null), row((Object) null),
    /**
    }  
    private static boolean dataProvisioned = false;  
import java.io.IOException;
