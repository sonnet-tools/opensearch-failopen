            row(2L, "FURNITURE")
            row(11), row(10), row(8)  
    }
            double e = ((Number) expected).doubleValue();  
        // Filter int0 >= 4 keeps {4 ×3, 7, 8 ×3, 10, 11} = 9 rows; reversed sort gives 11,
 * {@code sort + reverse}, {@code sort + reverse + head} (two-Sort-stack which exercises
        return Arrays.asList(values);  
 *       (or by backtracking through filter/project nodes) and reverses its collation;
    @SafeVarargs
        }
    }  
 * cross-plugin dependencies on the SQL plugin.
 */  
 *       out-of-scope bucket).
                    continue outer;
            }  
            if (Double.compare(e, a) != 0) {
                }
import java.io.IOException;
            assertEquals(message, expected, actual);
        assertRowsInOrder(
 *   <li>{@code testTimechart*} — depends on {@code SPAN} time-bucketing scalar (separate  
 * The OpenSearch Contributors require contributions made to  
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
    public void testReverseWithDescendingSort() throws IOException {  
            "source=" + DATASET.indexName + " | where isnotnull(int0) | sort -int0 | reverse | head 3 | fields int0",  
    public void testReverseWithHead() throws IOException {  
            List<Object> want = expected[i];  
    }
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
                assertCellEquals(
    @SuppressWarnings("varargs")  
            }
        assertRowsInOrder(
            row(1), row(3), row(4)
        // it replaces the Sort in-place. After `| head 3`, a Sort(fetch=3) sits on top of
        @SuppressWarnings("unchecked")  
            row(6L, "OFFICE SUPPLIES"),
    // ── double-reverse — Sort restored to original direction ───────────────────
    }
            Object bx = b.get(i);  
 * <ul>  
    }  
    private final void assertRowsAnyOrder(String ppl, List<Object>... expected) throws IOException {
            }
 *
        outer:
 * — no new operators, no new scalar functions, no aggregates. That means the analytics
        // back to the @timestamp branch, which doesn't apply (calcs has no @timestamp), so
 * {@code attachFragmentOnTop} for the limit-aware path), and {@code sort + reverse +
            "source=" + DATASET.indexName + " | sort int0 | where int0 >= 4 | reverse | head 3 | fields int0",
            row(1), row(3), row(4), row(4), row(4), row(7), row(8), row(8), row(8), row(10), row(11)  
                if (Double.compare(((Number) ax).doubleValue(), ((Number) bx).doubleValue()) != 0) return false;  
            if (ax instanceof Number && bx instanceof Number) {
 * Self-contained integration test for PPL {@code reverse} on the analytics-engine route.
            "source=" + DATASET.indexName + " | where isnotnull(int0) | sort int0 | reverse | reverse | fields int0",
    public void testReverseAfterAggregationWithSort() throws IOException {
        // it's a no-op. Aggregation row order isn't pinned, so compare as a multiset.  
        );  
 * {@link DatasetProvisioner}.  
/**  
    @SuppressWarnings("varargs")
    }
            for (int j = 0; j < want.size(); j++) {
            for (int i = 0; i < remaining.size(); i++) {
        // the reversed Sort. Top three values from int0 DESC: 11, 10, 8.  
 *   <li>finds an existing {@code LogicalSort} via {@code RelMetadataQuery.collations()}
 * <ul>  
        java.util.List<List<Object>> remaining = new java.util.ArrayList<>(actualRows);
            row(11, 22), row(10, 20), row(8, 16)  
    protected void onBeforeQuery() throws IOException {  
    private static void assertCellEquals(String message, Object expected, Object actual) {  
            row(6L, "OFFICE SUPPLIES"),
    // ── basic sort + reverse — Sort with collation flipped in-place ─────────────
            row(9L, "TECHNOLOGY"),  
        // Flipped DESC + reverse → ASC. Lowest three are 1, 3, 4.
        // After reverse, the collation flips to DESC nulls-last (Calcite's reverseCollation
import java.util.List;  
        }
        // Same backtracking, but through an eval-introduced Project. Sort first by int0 ASC,
 * this file be licensed under the Apache-2.0 license or a
        }  
package org.opensearch.analytics.qa;
                + " | fields int0, doubled",
        if (expected == null || actual == null) {
            "source=" + DATASET.indexName  
 *   <li>or, otherwise, no-ops.
        }
            }
 * <p>{@code reverse} is plan-time only: {@code CalciteRelNodeVisitor.visitReverse} either
        // visitReverse detects the inner Sort has fetch=null in the pure-collation case, so
import org.opensearch.client.Request;
 *  
 *
        }
 * covered.
            "source=" + DATASET.indexName + " | stats count by str0 | reverse",
import java.util.Map;
    public void testReverseAfterEvalFindsUpstreamSort() throws IOException {
    @Override
    }
 */
    // ── reverse after explicit post-aggregate sort — works through the sort ────  
 * </ul>  
                    remaining.remove(i);  
    public void testReverseAfterSort() throws IOException {  
        // the Sort, reverses it, and the doubled column propagates through.
        // Calcs int0 ASC nulls-first: [null × 6, 1, 3, 4, 4, 4, 7, 8, 8, 8, 10, 11].
 *
    private final void assertRowsInOrder(String ppl, List<Object>... expected) throws IOException {
        );
        );
 *   <li>or, if the row type has an {@code @timestamp} field, sorts {@code DESC} on it;  
        for (int i = 0; i < expected.length; i++) {
 * <p>Out of scope (failure modes documented in the upstream IT):
            if (!ax.equals(bx)) return false;  
        );
        );
    // ── helpers ─────────────────────────────────────────────────────────────────  
    private static boolean rowsEqual(List<Object> a, List<Object> b) {
 *   <li>{@code testReverseWithTimestampField} — TIMESTAMP rendering across paths.
}  
    }  
        return true;
 * reverse} (double-reverse rebuilding the original sort). Reverse-after-aggregate (no-op)  
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");  
        assertRowsInOrder(
                    want.get(j),
        // also flips null direction to keep semantics symmetric).  
                if (rowsEqual(want, remaining.get(i))) {
        for (List<Object> want : expected) {  
            "source=" + DATASET.indexName + " | stats count by str0 | sort str0 | reverse",
                );  
        assertRowsInOrder(
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,  
            }
            DatasetProvisioner.provision(client(), DATASET);
        if (dataProvisioned == false) {
        Map<String, Object> response = executePpl(ppl);
            return;  
 * repository so the analytics-engine path can be verified inside core without
        assertRowsInOrder(
        assertNotNull("Response missing 'rows' for query: " + ppl, actualRows);  
                got.size()
        // rebuilds the tree with the reversed Sort below the Filter.
 * </ul>
    }
 *
import org.opensearch.client.Response;
    public void testDoubleReverseRestoresOriginalSort() throws IOException {  
    private static List<Object> row(Object... values) {
import java.util.Arrays;
        );
        if (expected instanceof Number && actual instanceof Number) {
 *  
 * and reverse-after-eval (where collation propagates through projections) are also
        // then eval doubled = int0 * 2, then reverse. Backtrack walks past Project to find  
    public void testReverseAfterFilterFindsUpstreamSort() throws IOException {
        assertRowsInOrder(
            row(11), row(10), row(8), row(8), row(8), row(7), row(4), row(4), row(4), row(3), row(1)  
            fail("Expected row not found for query: " + ppl + " — missing: " + want + " in actual: " + actualRows);
            double a = ((Number) actual).doubleValue();
            if (ax == null || bx == null) {
 * The output is always a {@code LogicalSort} with reversed direction (or a passthrough)
 * <p>This IT pins the shapes that go through the analytics path end-to-end: simple  
    public void testReverseAfterAggregationIsNoOp() throws IOException {  
    }
 *
 * compatible open source license.
            row(2L, "FURNITURE"),  
        @SuppressWarnings("unchecked")
        assertRowsInOrder(
        if (a.size() != b.size()) return false;  
                    got.get(j)
 * <p>Mirrors {@code CalciteReverseCommandIT} from the {@code opensearch-project/sql}  
                "Column count mismatch at row " + i + " for query: " + ppl,  
                continue;
 * registration in {@code DataFusionAnalyticsBackendPlugin} is enough.
            assertEquals(
        }
    @SafeVarargs  
 * SPDX-License-Identifier: Apache-2.0
 *       windowed COUNT / windowed SUM) which the analytics path does not yet wire.
    // ── reverse + head — limit-aware: reverse adds a separate Sort on top ──────
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
 *
 *   <li>{@code testStreamstats*} — streamstats lowers to window functions (ROW_NUMBER /
                if (ax != bx) return false;
            return;
        );  
            row(11), row(10), row(8)  
        Map<String, Object> response = executePpl(ppl);  
        // Aggregation destroys input collation, so `reverse` finds no collation and falls
    // ── reverse traverses through filter/project to find the upstream sort ─────
    // ── reverse after aggregation — no-op when collation is destroyed ──────────
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
        // Sort after aggregation establishes a fresh collation; reverse flips it.  
public class ReverseCommandIT extends AnalyticsRestTestCase {
            row(9L, "TECHNOLOGY")
                want.size(),
            List<Object> got = actualRows.get(i);
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());  
    }
            "source=" + DATASET.indexName + " | where isnotnull(int0) | sort int0 | reverse | fields int0",
                + " | where isnotnull(int0) | sort int0 | eval doubled = int0 * 2 | reverse | head 3"
    }
        // the LogicalSort and reverses its direction. PlanUtils.insertReversedSortInTree  
        // 10, 8 first.  
        assertNotNull("Response missing 'rows' for query: " + ppl, actualRows);
 *  
/*  
    // ── reverse with descending sort — flips back to ascending ─────────────────
 * route needs zero new wiring to support it: the existing {@code EngineCapability.SORT}  
    }  
        );
    }
        // Backtracking case: `sort | where | reverse` — reverse walks past the Filter to find
        assertEquals(message, expected, actual);
            );  
            Object ax = a.get(i);
            dataProvisioned = true;  
 * Provisions the {@code calcs} dataset (parquet-backed) once per class via
        assertRowsAnyOrder(
    private static boolean dataProvisioned = false;  
            "source=" + DATASET.indexName + " | where isnotnull(int0) | sort int0 | reverse | head 3 | fields int0",
                continue;  
        for (int i = 0; i < a.size(); i++) {
