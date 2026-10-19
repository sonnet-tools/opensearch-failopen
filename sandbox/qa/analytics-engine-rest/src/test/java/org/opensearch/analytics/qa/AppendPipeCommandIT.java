    /**
        assertRowsAnyOrder(
        // `sum` column; the inner row is null-padded for the missing `str0`. The two branches
 * keeps it across test methods.
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
 *
                + " | stats sum(int0) as sum by str0 | sort str0"  
import java.util.HashMap;
    @SuppressWarnings("unchecked")
        // row depending on which branch arrives first. Assert the shape instead:  
        assertEquals(
    private final void assertRows(String ppl, List<Object>... expected) throws IOException {
        }  
        // Outer stats: sum(int0) by str0 → 3 rows. `appendpipe [stats sum(sum) as sum]` runs an inner
    private static boolean dataProvisioned = false;
    public void testAppendPipeSort() throws IOException {
import org.opensearch.client.Response;
        // The concrete invariant: the distinct buckets FURNITURE/OFFICE SUPPLIES/TECHNOLOGY all  
            }  
                if (ax != bx) return false;  
 * compatible open source license.
    }
                    got.get(j)
            dataProvisioned = true;
            fail("Expected row not found for query: " + ppl + " — missing: " + want + " in actual: " + actualRows);
                + " | appendpipe [ sort -sum_int0_by_str0 ]"
                + DATASET.indexName
        Map<String, Object> response = executePpl(ppl);  
 * <p>Provisions the {@code calcs} dataset once. {@link AnalyticsRestTestCase#preserveIndicesUponCompletion()}  
 * starting a fresh {@code source=...}.
    }
                body = org.apache.hc.core5.http.io.entity.EntityUtils.toString(e.getResponse().getEntity());  
        }
    private static void assertCellEquals(String message, Object expected, Object actual) {
 *
                + " | head 5"
        assertNotNull("Response missing 'rows' for query: " + ppl, actualRows);  
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,  
 * Self-contained integration test for PPL {@code appendpipe} on the analytics-engine route.
 * inline {@code [pipeline]} to the duplicate, and appends the duplicate's output to the  
        // Branch: stats sum(int0) by str0 → 3 rows (FURNITURE=1, OFFICE SUPPLIES=18, TECHNOLOGY=49).
            bucketCounts.keySet()
    @Override  
        }  
            "source="
        Map<String, Object> response = executePpl(ppl);
                    remaining.remove(i);
    private void assertErrorContains(String ppl, String expectedSubstring) {
            fail("Expected query to fail with [" + expectedSubstring + "] but got response: " + response);
            return;
        // appear, and the two branches' rows are identical modulo ordering, so the multiset
            List<Object> want = expected[i];  
            }
        return Arrays.asList(values);
            );
            );  
    }  
    // ── duplicate + inline stats producing a smaller schema (merged column) ─────
                + " | stats sum(int0) as sum by str0 | sort str0"
            }
 * by the {@code opensearch-sql} plugin), which runs the same {@code UnifiedQueryPlanner}  
    }
            "source="  
     */
        // `appendpipe [eval sum = cast(sum as double)]` rewrites the same-named column to  
        // `appendpipe [sort -sum_int0_by_str0]` duplicates them desc-sorted and appends. `head 5`  
        );
        // Branch 1 produces `sum` as BIGINT (sum over int0). The inner pipeline of
        @SuppressWarnings("unchecked")
    @SafeVarargs  
    }
                assertCellEquals(
            assertEquals(message, expected, actual);
        if (expected == null || actual == null) {  
            Object bx = b.get(i);
    }
            double e = ((Number) expected).doubleValue();
            row(68, null)
import java.util.Set;
        return (List<List<Object>>) response.get("datarows");
                }  
 * force-routed analytics path.
    public void testAppendPipeWithConflictTypeColumn() {
import java.io.IOException;
package org.opensearch.analytics.qa;
        }
    private static List<Object> row(Object... values) {  
            assertEquals(
    // ── duplicate + inline sort, then head ──────────────────────────────────────
        if (a.size() != b.size()) return false;
                "Column count mismatch at row " + i + " for query: " + ppl,  
    @SuppressWarnings("varargs")
                + DATASET.indexName
    }  
    }  
            row(49, "TECHNOLOGY"),  
            String body;
        try {  
        // stats over the duplicate, collapsing it to a single row carrying only the `sum` column.  
            if (Double.compare(e, a) != 0) {
                    want.get(j),
        assertNotNull("Response missing 'rows' for query: " + ppl, actualRows);  
            DatasetProvisioner.provision(client(), DATASET);  
                + " | head 5",
            }  
        assertEquals(message, expected, actual);  
        //  - total 5 rows
            fail("Unexpected IOException: " + e);  
        //  - at least one asc branch is fully represented (3 rows) and the other contributes 2.
            row(18, "OFFICE SUPPLIES"),
import java.util.Map;  
                    continue outer;
                continue;
            Set.of("FURNITURE", "OFFICE SUPPLIES", "TECHNOLOGY"),  
 * The OpenSearch Contributors require contributions made to  
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
import org.opensearch.client.ResponseException;  
 * dependencies. Each test sends a PPL query through {@code POST /_plugins/_ppl} (exposed
 * {@code appendpipe [pipeline]} duplicates the current intermediate result, applies the
            List<Object> got = actualRows.get(i);
        for (Map.Entry<String, Integer> e : bucketCounts.entrySet()) {  
 * → {@code CalciteRelNodeVisitor} → Substrait → DataFusion pipeline as the SQL plugin's
            assertTrue("bucket " + e.getKey() + " count out of range: " + e.getValue(), e.getValue() >= 1 && e.getValue() <= 2);
     * Multiset comparison — branch ordering at the coordinator's Union is non-deterministic.
                if (rowsEqual(want, remaining.get(i))) {  
        // Schema unification keeps both the original branch's `str0` and the inner branch's
        return true;  
        List<List<Object>> actual = getRows(  
    public void testAppendPipeWithMergedColumn() throws IOException {
            row(1, "FURNITURE"),
    // ── helpers ─────────────────────────────────────────────────────────────────
 * because {@code appendpipe} reuses the original's row stream as its input rather than  
        }
    }  
                + DATASET.indexName
            } catch (Exception ioe) {
                + " | stats sum(int0) as sum_int0_by_str0 by str0 | sort str0"  
 * this file be licensed under the Apache-2.0 license or a
    private static boolean rowsEqual(List<Object> a, List<Object> b) {  
        }  
                body.contains(expectedSubstring)  
            }
            "all three buckets must appear",
        if (expected instanceof Number && actual instanceof Number) {
                if (Double.compare(((Number) ax).doubleValue(), ((Number) bx).doubleValue()) != 0) return false;
                body = e.getMessage();
            String bucket = (String) r.get(1);
            Object ax = a.get(i);  
    @SafeVarargs  
        java.util.List<List<Object>> remaining = new java.util.ArrayList<>(actualRows);
 * output. Both lower to a Calcite {@code LogicalUnion} but the upper-stage shape differs
        // DOUBLE. SchemaUnifier refuses to merge the diverging types and surfaces a
 *  
            "source="
        for (int i = 0; i < expected.length; i++) {
    protected void onBeforeQuery() throws IOException {
            if (ax == null || bx == null) {
                + " | appendpipe [ stats sum(sum) as sum ]",  
        );
        for (List<Object> want : expected) {
        @SuppressWarnings("unchecked")
        assertEquals("head 5 must return 5 rows", 5, actual.size());
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
/**  
                want.size(),
        // non-deterministic (each is its own streaming stage), so `head 5` drops a different
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
import org.opensearch.client.Request;
        }
                "Expected response body to contain [" + expectedSubstring + "] but was: " + body,
                continue;
 * <p>{@code appendpipe} differs from {@code append} (covered by {@link AppendCommandIT}):
    }  
            Map<String, Object> response = executePpl(ppl);
/*  
import java.util.List;
        } catch (ResponseException e) {  
        // keeps the first 5 of the 6 total rows. Branch arrival order at the union is
        Map<String, Integer> bucketCounts = new HashMap<>();
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");
                );  
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
        }
 * repository so the analytics-engine path can be verified inside core without cross-plugin
                + " | appendpipe [ eval sum = cast(sum as double) ]"
    private List<List<Object>> getRows(String ppl) throws IOException {  
            for (int i = 0; i < remaining.size(); i++) {
            try {
     * (3 rows) and the inner-branch collapsed-sum (1 row) can arrive in either order.
        // stage), so compare as a multiset rather than positionally.
        assertErrorContains(  
        Map<String, Object> response = executePpl(ppl);  
        // planner-side validation error before execution.
    // ── duplicate + inline cast that clashes with the original's column type ───
            bucketCounts.merge(bucket, 1, Integer::sum);
        );
            if (!ax.equals(bx)) return false;
            assertTrue(
            for (int j = 0; j < want.size(); j++) {
        // count of each bucket is at least 1 and no bucket count exceeds 2.
            }  
 *
 * <p>Mirrors {@code CalcitePPLAppendPipeCommandIT} from the {@code opensearch-project/sql}  
        for (int i = 0; i < a.size(); i++) {
            return;
 */
        } catch (IOException e) {
        // arrive at the coordinator's union in non-deterministic order (each is its own data-node  
            "due to incompatible types"  
        }
                got.size()
     * Used by {@link #testAppendPipeWithMergedColumn} where the original-branch stats output  
        );  
 * SPDX-License-Identifier: Apache-2.0
        if (dataProvisioned == false) {
public class AppendPipeCommandIT extends AnalyticsRestTestCase {  
        for (List<Object> r : actual) {  
    @SuppressWarnings("varargs")
import java.util.Arrays;  
            if (ax instanceof Number && bx instanceof Number) {  
        outer:  
 * original. {@code append [search]} runs an entirely separate sub-query and unions its
    private final void assertRowsAnyOrder(String ppl, List<Object>... expected) throws IOException {
    }
}
            double a = ((Number) actual).doubleValue();  
 */  
