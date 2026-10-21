        }
            assertTrue(
            return;
    @SuppressWarnings("varargs")
/*
            List<Object> got = actualRows.get(i);
            fail("Expected row not found for query: " + ppl + " — missing: " + want + " in actual: " + actualRows);
        // appear, and the two branches' rows are identical modulo ordering, so the multiset
            }
                continue;
            String bucket = (String) r.get(1);
            }
            }
        );
     * (3 rows) and the inner-branch collapsed-sum (1 row) can arrive in either order.
            Set.of("FURNITURE", "OFFICE SUPPLIES", "TECHNOLOGY"),
            if (!ax.equals(bx)) return false;
            double a = ((Number) actual).doubleValue();
        // stats over the duplicate, collapsing it to a single row carrying only the `sum` column.
                body.contains(expectedSubstring)
    }
                    want.get(j),
        assertEquals("head 5 must return 5 rows", 5, actual.size());
        return Arrays.asList(values);
                + " | stats sum(int0) as sum_int0_by_str0 by str0 | sort str0"
    // ── duplicate + inline stats producing a smaller schema (merged column) ─────
     * Multiset comparison — branch ordering at the coordinator's Union is non-deterministic.
    }
        Map<String, Object> response = executePpl(ppl);
        );
 * starting a fresh {@code source=...}.
        for (int i = 0; i < a.size(); i++) {
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
package org.opensearch.analytics.qa;
            assertEquals(message, expected, actual);
            } catch (Exception ioe) {
        }
 * SPDX-License-Identifier: Apache-2.0
 */
        @SuppressWarnings("unchecked")
public class AppendPipeCommandIT extends AnalyticsRestTestCase {
 * The OpenSearch Contributors require contributions made to
        assertEquals(
 *
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
                want.size(),
 * <p>Mirrors {@code CalcitePPLAppendPipeCommandIT} from the {@code opensearch-project/sql}
        for (int i = 0; i < expected.length; i++) {
        } catch (ResponseException e) {
    private void assertErrorContains(String ppl, String expectedSubstring) {
import java.util.List;
        try {
        );
        }
    // ── duplicate + inline cast that clashes with the original's column type ───
                "Expected response body to contain [" + expectedSubstring + "] but was: " + body,
 * {@code appendpipe [pipeline]} duplicates the current intermediate result, applies the
 *
        Map<String, Object> response = executePpl(ppl);
                + DATASET.indexName
                "Column count mismatch at row " + i + " for query: " + ppl,
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");
        // `appendpipe [sort -sum_int0_by_str0]` duplicates them desc-sorted and appends. `head 5`
        return (List<List<Object>>) response.get("datarows");
            DatasetProvisioner.provision(client(), DATASET);
}
import java.util.Arrays;
    }
            Object ax = a.get(i);
        // keeps the first 5 of the 6 total rows. Branch arrival order at the union is
        // Branch: stats sum(int0) by str0 → 3 rows (FURNITURE=1, OFFICE SUPPLIES=18, TECHNOLOGY=49).
 *
        // Schema unification keeps both the original branch's `str0` and the inner branch's
 *
 * keeps it across test methods.
 * force-routed analytics path.
            "source="
            if (ax instanceof Number && bx instanceof Number) {
        // non-deterministic (each is its own streaming stage), so `head 5` drops a different
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
            }
    }
        }
    }
    public void testAppendPipeWithMergedColumn() throws IOException {
    // ── helpers ─────────────────────────────────────────────────────────────────
                assertCellEquals(
    public void testAppendPipeSort() throws IOException {
                + " | appendpipe [ eval sum = cast(sum as double) ]"
        }
        // arrive at the coordinator's union in non-deterministic order (each is its own data-node
            "source="
            );
 * by the {@code opensearch-sql} plugin), which runs the same {@code UnifiedQueryPlanner}
    /**
                got.size()
                + DATASET.indexName
        );
        return true;
            "all three buckets must appear",
            }
            Map<String, Object> response = executePpl(ppl);
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
        if (dataProvisioned == false) {
 * original. {@code append [search]} runs an entirely separate sub-query and unions its
                }
            );
            row(68, null)
    }
        // Branch 1 produces `sum` as BIGINT (sum over int0). The inner pipeline of
    }
        }
            bucketCounts.keySet()
    private List<List<Object>> getRows(String ppl) throws IOException {
            assertTrue("bucket " + e.getKey() + " count out of range: " + e.getValue(), e.getValue() >= 1 && e.getValue() <= 2);
                body = e.getMessage();
                + DATASET.indexName
        if (expected == null || actual == null) {
        Map<String, Integer> bucketCounts = new HashMap<>();
        java.util.List<List<Object>> remaining = new java.util.ArrayList<>(actualRows);
                continue;
                + " | stats sum(int0) as sum by str0 | sort str0"
        assertNotNull("Response missing 'rows' for query: " + ppl, actualRows);
 * inline {@code [pipeline]} to the duplicate, and appends the duplicate's output to the
            List<Object> want = expected[i];
 * because {@code appendpipe} reuses the original's row stream as its input rather than
        Map<String, Object> response = executePpl(ppl);
            if (Double.compare(e, a) != 0) {
        // row depending on which branch arrives first. Assert the shape instead:
        // stage), so compare as a multiset rather than positionally.
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
    }
                + " | appendpipe [ stats sum(sum) as sum ]",
        // planner-side validation error before execution.
            row(49, "TECHNOLOGY"),
        List<List<Object>> actual = getRows(
 * compatible open source license.
        outer:
        for (List<Object> r : actual) {
                );
    }
import java.util.Set;
        @SuppressWarnings("unchecked")
        // Outer stats: sum(int0) by str0 → 3 rows. `appendpipe [stats sum(sum) as sum]` runs an inner
        // `sum` column; the inner row is null-padded for the missing `str0`. The two branches
            String body;
    private static void assertCellEquals(String message, Object expected, Object actual) {
    public void testAppendPipeWithConflictTypeColumn() {
            dataProvisioned = true;
            if (ax == null || bx == null) {
        assertErrorContains(
            bucketCounts.merge(bucket, 1, Integer::sum);
            for (int i = 0; i < remaining.size(); i++) {
import java.util.HashMap;
        assertEquals(message, expected, actual);
            "source="
                    remaining.remove(i);
        for (Map.Entry<String, Integer> e : bucketCounts.entrySet()) {
     */
    @Override
    private static boolean dataProvisioned = false;
    private static boolean rowsEqual(List<Object> a, List<Object> b) {
    private static List<Object> row(Object... values) {
        // `appendpipe [eval sum = cast(sum as double)]` rewrites the same-named column to
    }
                + " | head 5"
        } catch (IOException e) {
        if (expected instanceof Number && actual instanceof Number) {
                if (ax != bx) return false;
    // ── duplicate + inline sort, then head ──────────────────────────────────────
            row(18, "OFFICE SUPPLIES"),
                if (rowsEqual(want, remaining.get(i))) {
import org.opensearch.client.ResponseException;
            fail("Unexpected IOException: " + e);
 * this file be licensed under the Apache-2.0 license or a
            double e = ((Number) expected).doubleValue();
            return;
    @SafeVarargs
        // count of each bucket is at least 1 and no bucket count exceeds 2.
                + " | appendpipe [ sort -sum_int0_by_str0 ]"
                    got.get(j)
    }
     * Used by {@link #testAppendPipeWithMergedColumn} where the original-branch stats output
        }
 * repository so the analytics-engine path can be verified inside core without cross-plugin
        }
    protected void onBeforeQuery() throws IOException {
import java.util.Map;
 * <p>Provisions the {@code calcs} dataset once. {@link AnalyticsRestTestCase#preserveIndicesUponCompletion()}
            row(1, "FURNITURE"),
            assertEquals(
    private final void assertRows(String ppl, List<Object>... expected) throws IOException {
            }
            for (int j = 0; j < want.size(); j++) {
        if (a.size() != b.size()) return false;
        assertRowsAnyOrder(
                + " | stats sum(int0) as sum by str0 | sort str0"
    private final void assertRowsAnyOrder(String ppl, List<Object>... expected) throws IOException {
 * dependencies. Each test sends a PPL query through {@code POST /_plugins/_ppl} (exposed
import org.opensearch.client.Response;
            "due to incompatible types"
            fail("Expected query to fail with [" + expectedSubstring + "] but got response: " + response);
    @SuppressWarnings("unchecked")
import java.io.IOException;
        for (List<Object> want : expected) {
    @SafeVarargs
        // The concrete invariant: the distinct buckets FURNITURE/OFFICE SUPPLIES/TECHNOLOGY all
 * Self-contained integration test for PPL {@code appendpipe} on the analytics-engine route.
        }
            try {
 * <p>{@code appendpipe} differs from {@code append} (covered by {@link AppendCommandIT}):
        //  - total 5 rows
 * output. Both lower to a Calcite {@code LogicalUnion} but the upper-stage shape differs
                + " | head 5",
 * → {@code CalciteRelNodeVisitor} → Substrait → DataFusion pipeline as the SQL plugin's
        // DOUBLE. SchemaUnifier refuses to merge the diverging types and surfaces a
                if (Double.compare(((Number) ax).doubleValue(), ((Number) bx).doubleValue()) != 0) return false;
                    continue outer;
/**
                body = org.apache.hc.core5.http.io.entity.EntityUtils.toString(e.getResponse().getEntity());
        assertNotNull("Response missing 'rows' for query: " + ppl, actualRows);
        //  - at least one asc branch is fully represented (3 rows) and the other contributes 2.
import org.opensearch.client.Request;
 */
            Object bx = b.get(i);
    @SuppressWarnings("varargs")
