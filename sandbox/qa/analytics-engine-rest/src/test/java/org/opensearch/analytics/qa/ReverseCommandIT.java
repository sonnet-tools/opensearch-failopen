        }
    // ── basic sort + reverse — Sort with collation flipped in-place ─────────────
            for (int i = 0; i < remaining.size(); i++) {
            if (ax == null || bx == null) {
            "source=" + DATASET.indexName + " | stats count by str0 | reverse",
            List<Object> want = expected[i];
        assertEquals(message, expected, actual);
        @SuppressWarnings("unchecked")
        assertRowsInOrder(
    public void testReverseAfterFilterFindsUpstreamSort() throws IOException {
        return Arrays.asList(values);
                "Column count mismatch at row " + i + " for query: " + ppl,
            row(11, 22), row(10, 20), row(8, 16)
import java.util.Arrays;
/*
 *
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
        if (dataProvisioned == false) {
        );
        java.util.List<List<Object>> remaining = new java.util.ArrayList<>(actualRows);
import java.util.Map;
    }
            row(1), row(3), row(4)
 * <p>Out of scope (failure modes documented in the upstream IT):
            "source=" + DATASET.indexName + " | stats count by str0 | sort str0 | reverse",
        Map<String, Object> response = executePpl(ppl);
        assertRowsAnyOrder(
        @SuppressWarnings("unchecked")
 * registration in {@code DataFusionAnalyticsBackendPlugin} is enough.
        // Calcs int0 ASC nulls-first: [null × 6, 1, 3, 4, 4, 4, 7, 8, 8, 8, 10, 11].
 */
        assertNotNull("Response missing 'rows' for query: " + ppl, actualRows);
            return;
        // visitReverse detects the inner Sort has fetch=null in the pure-collation case, so
 * </ul>
 *
import java.util.List;
                if (ax != bx) return false;
 *
    public void testReverseAfterAggregationIsNoOp() throws IOException {
        if (expected == null || actual == null) {
                );
 *
 *
 *
        }
 * {@link DatasetProvisioner}.
                    continue outer;
            return;
            "source=" + DATASET.indexName
            row(11), row(10), row(8)
    }
                got.size()
    public void testReverseWithDescendingSort() throws IOException {
                }
        // Sort after aggregation establishes a fresh collation; reverse flips it.
            Object ax = a.get(i);
    @SafeVarargs
            double e = ((Number) expected).doubleValue();
    private final void assertRowsInOrder(String ppl, List<Object>... expected) throws IOException {
    public void testReverseAfterEvalFindsUpstreamSort() throws IOException {
                if (rowsEqual(want, remaining.get(i))) {
    }
 * </ul>
            );
    public void testReverseAfterSort() throws IOException {
 * and reverse-after-eval (where collation propagates through projections) are also
        for (int i = 0; i < expected.length; i++) {
        }
        // rebuilds the tree with the reversed Sort below the Filter.
        assertNotNull("Response missing 'rows' for query: " + ppl, actualRows);
        // 10, 8 first.
 * repository so the analytics-engine path can be verified inside core without
            double a = ((Number) actual).doubleValue();
    }
    private static boolean dataProvisioned = false;
        }
        );
    @Override
            row(11), row(10), row(8)
                + " | where isnotnull(int0) | sort int0 | eval doubled = int0 * 2 | reverse | head 3"
                if (Double.compare(((Number) ax).doubleValue(), ((Number) bx).doubleValue()) != 0) return false;
            "source=" + DATASET.indexName + " | where isnotnull(int0) | sort int0 | reverse | fields int0",
 * <ul>
    // ── reverse after explicit post-aggregate sort — works through the sort ────
 * SPDX-License-Identifier: Apache-2.0
    public void testReverseWithHead() throws IOException {
        }
 * The OpenSearch Contributors require contributions made to
    private static void assertCellEquals(String message, Object expected, Object actual) {
 * {@code sort + reverse}, {@code sort + reverse + head} (two-Sort-stack which exercises
 * cross-plugin dependencies on the SQL plugin.
    }
/**
 * <p>This IT pins the shapes that go through the analytics path end-to-end: simple
            row(9L, "TECHNOLOGY"),
            }
            "source=" + DATASET.indexName + " | where isnotnull(int0) | sort int0 | reverse | head 3 | fields int0",
        // the Sort, reverses it, and the doubled column propagates through.
    protected void onBeforeQuery() throws IOException {
 *       windowed COUNT / windowed SUM) which the analytics path does not yet wire.
        outer:
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
 * compatible open source license.
            }
    }
 * <p>Mirrors {@code CalciteReverseCommandIT} from the {@code opensearch-project/sql}
            row(2L, "FURNITURE"),
                continue;
            row(11), row(10), row(8), row(8), row(8), row(7), row(4), row(4), row(4), row(3), row(1)
    // ── reverse after aggregation — no-op when collation is destroyed ──────────
            Object bx = b.get(i);
            if (!ax.equals(bx)) return false;
            DatasetProvisioner.provision(client(), DATASET);
        assertRowsInOrder(
 * Self-contained integration test for PPL {@code reverse} on the analytics-engine route.
 *   <li>{@code testTimechart*} — depends on {@code SPAN} time-bucketing scalar (separate
                assertCellEquals(
import org.opensearch.client.Request;
    }
            "source=" + DATASET.indexName + " | sort int0 | where int0 >= 4 | reverse | head 3 | fields int0",
            row(9L, "TECHNOLOGY")
    public void testDoubleReverseRestoresOriginalSort() throws IOException {
                + " | fields int0, doubled",
 *
        );
    }
 * this file be licensed under the Apache-2.0 license or a
        assertRowsInOrder(
 *   <li>finds an existing {@code LogicalSort} via {@code RelMetadataQuery.collations()}
        // it's a no-op. Aggregation row order isn't pinned, so compare as a multiset.
    }
        if (expected instanceof Number && actual instanceof Number) {
 * reverse} (double-reverse rebuilding the original sort). Reverse-after-aggregate (no-op)
        Map<String, Object> response = executePpl(ppl);
                    got.get(j)
    // ── reverse traverses through filter/project to find the upstream sort ─────
 *   <li>or, otherwise, no-ops.
        // also flips null direction to keep semantics symmetric).
        // After reverse, the collation flips to DESC nulls-last (Calcite's reverseCollation
            row(1), row(3), row(4), row(4), row(4), row(7), row(8), row(8), row(8), row(10), row(11)
            row(6L, "OFFICE SUPPLIES"),
    private final void assertRowsAnyOrder(String ppl, List<Object>... expected) throws IOException {
            }
                    remaining.remove(i);
            }
 *   <li>or, if the row type has an {@code @timestamp} field, sorts {@code DESC} on it;
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
        // it replaces the Sort in-place. After `| head 3`, a Sort(fetch=3) sits on top of
        );
 * The output is always a {@code LogicalSort} with reversed direction (or a passthrough)
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
    @SafeVarargs
                continue;
    @SuppressWarnings("varargs")
 * Provisions the {@code calcs} dataset (parquet-backed) once per class via
            assertEquals(
            dataProvisioned = true;
            fail("Expected row not found for query: " + ppl + " — missing: " + want + " in actual: " + actualRows);
    // ── double-reverse — Sort restored to original direction ───────────────────
    @SuppressWarnings("varargs")
                want.size(),
        assertRowsInOrder(
        if (a.size() != b.size()) return false;
            "source=" + DATASET.indexName + " | where isnotnull(int0) | sort int0 | reverse | reverse | fields int0",
    }
 *
                    want.get(j),
        assertRowsInOrder(
        // the LogicalSort and reverses its direction. PlanUtils.insertReversedSortInTree
            if (ax instanceof Number && bx instanceof Number) {
    private static boolean rowsEqual(List<Object> a, List<Object> b) {
 * <ul>
            if (Double.compare(e, a) != 0) {
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");
            row(6L, "OFFICE SUPPLIES"),
    // ── helpers ─────────────────────────────────────────────────────────────────
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
 *       (or by backtracking through filter/project nodes) and reverses its collation;
 * <p>{@code reverse} is plan-time only: {@code CalciteRelNodeVisitor.visitReverse} either
    private static List<Object> row(Object... values) {
            List<Object> got = actualRows.get(i);
import java.io.IOException;
 *       out-of-scope bucket).
    }
        );
        // Filter int0 >= 4 keeps {4 ×3, 7, 8 ×3, 10, 11} = 9 rows; reversed sort gives 11,
    }
 * covered.
}
    // ── reverse + head — limit-aware: reverse adds a separate Sort on top ──────
        // Backtracking case: `sort | where | reverse` — reverse walks past the Filter to find
    // ── reverse with descending sort — flips back to ascending ─────────────────
        // back to the @timestamp branch, which doesn't apply (calcs has no @timestamp), so
    }
            "source=" + DATASET.indexName + " | where isnotnull(int0) | sort -int0 | reverse | head 3 | fields int0",
        );
        }
            row(2L, "FURNITURE")
package org.opensearch.analytics.qa;
            for (int j = 0; j < want.size(); j++) {
        assertRowsInOrder(
            assertEquals(message, expected, actual);
 * — no new operators, no new scalar functions, no aggregates. That means the analytics
        // Aggregation destroys input collation, so `reverse` finds no collation and falls
        for (List<Object> want : expected) {
        assertRowsInOrder(
        // Same backtracking, but through an eval-introduced Project. Sort first by int0 ASC,
 *   <li>{@code testReverseWithTimestampField} — TIMESTAMP rendering across paths.
 *   <li>{@code testStreamstats*} — streamstats lowers to window functions (ROW_NUMBER /
            }
        // the reversed Sort. Top three values from int0 DESC: 11, 10, 8.
 * route needs zero new wiring to support it: the existing {@code EngineCapability.SORT}
    public void testReverseAfterAggregationWithSort() throws IOException {
    }
        // Flipped DESC + reverse → ASC. Lowest three are 1, 3, 4.
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
import org.opensearch.client.Response;
        return true;
        );
        // then eval doubled = int0 * 2, then reverse. Backtrack walks past Project to find
 * {@code attachFragmentOnTop} for the limit-aware path), and {@code sort + reverse +
 */
 *
        );
        for (int i = 0; i < a.size(); i++) {
public class ReverseCommandIT extends AnalyticsRestTestCase {
