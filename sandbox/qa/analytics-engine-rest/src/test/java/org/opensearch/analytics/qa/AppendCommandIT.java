    private final void assertRowsAnyOrder(String ppl, List<Object>... expected) throws IOException {
                + " | stats sum(int0) as sum by str3 | sort sum ]"
 * cross-plugin dependencies on the SQL plugin. Each test sends a PPL query through
                + CALCS.indexName
        );
        // The second branch produces sum=null for every row (its own column is sum_alt),
    // ── two stats branches → sort → head ────────────────────────────────────────
                + CALCS.indexName
        StringBuilder sb = new StringBuilder("[");
     * {@code client()} is not initialized until after {@code @BeforeClass} but is
                + " | stats sum(int0) as sum_int0_by_str0 by str0 | sort str0"
                + CALCS_ALT.indexName
    }
import org.opensearch.client.Request;
                + " | stats count() as cnt by str0 | sort str0 ] ]",
    @Override
                + CALCS.indexName
                + " | stats sum(int1) as sum_alt by str3 ]"
    /**
        // (1 row). Each branch is its own data-node stage on its own shard set; the two
        try {
            row(49, "TECHNOLOGY", null),
    public void testAppendEmptySearchWithFullJoin() throws IOException {
        }
        );
 * keeps them across test methods.
 * → DataFusion pipeline as the SQL plugin's force-routed analytics path.
        );
                + " | append [ | where int0 > 5 | append [ ] ]"
     * The four empty-subsearch shapes share the same expected first-branch-only output;
            fail("Unexpected IOException: " + e);
    public void testAppendEmptySearchWithInnerJoin() throws IOException {
    }
    private static final Dataset CALCS_ALT = new Dataset("calcs", "calcs_alt");
                + CALCS.indexName
                + " | stats sum(int0) as sum_int0_by_str0 by str0 | sort str0"
                + " | eval sum = cast(sum as double) ]"
            return;
 * Self-contained integration test for PPL {@code append} on the analytics-engine route.
 * compatible open source license.
        List<String> actualNormalized = actualRows.stream().map(AppendCommandIT::normalizeRow).sorted().toList();
            dataProvisioned = true;
    private static void assertCellEquals(String message, Object expected, Object actual) {
            assertTrue(
                + CALCS.indexName
 * <p>Mirrors {@code CalcitePPLAppendCommandIT} from the {@code opensearch-project/sql}
            row(18, "OFFICE SUPPLIES", null),
    @SafeVarargs
                + CALCS.indexName
                + CALCS.indexName
                + " | head 5",
            } catch (Exception ioe) {
            row(null, "TECHNOLOGY", 9)
        // Branch 1: sum(int0) grouped by str0 (3 rows). Branch 2: sum(int1) grouped
        Map<String, Object> response = executePpl(ppl);
                body = org.apache.hc.core5.http.io.entity.EntityUtils.toString(e.getResponse().getEntity());
                + " | stats sum(int0) as sum by str0 | sort str0"
    private void assertEmptyAppendOnlyFirstBranch(String ppl) throws IOException {
    /**
                + CALCS.indexName
 *   <li>{@code | append [ | <inner|cross|left|semi> join … ]} — empty-left-side joins
                + " | stats sum(int0) as sum_int0_by_str0 by str0 | sort str0"
    }
                + " | append [ source="
    // ── type-incompatibility error raised in SchemaUnifier ─────────────────────
    public void testAppendEmptySearchWithRightJoin() throws IOException {
import org.opensearch.client.Response;
        if (dataProvisioned == false) {
    }
        // right-side row with NULL on the left columns. The append therefore yields
    }
        // FULL JOIN reduces to RIGHT JOIN here. Inter-branch order is non-deterministic.
 * <p>Covers the Append surface forms that exercise:
    public void testAppendEmptySearchWithCrossJoin() throws IOException {
        return sb.append(']').toString();
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
                + CALCS.indexName
            row(null, "OFFICE SUPPLIES", 6),
        if (expected == null || actual == null) {
    public void testAppendWithMergedColumn() throws IOException {
    public void testAppendEmptySearchWithSemiJoin() throws IOException {
    }
                + " | stats sum(int0) as sum by str3 | sort sum"
                + " | append [ source="
            "source="
            String body;
    public void testAppendEmptySearchCommandBareBrackets() throws IOException {
        );
        // RIGHT JOIN of (empty filtered subset, real subquery) → still emits every
        @SuppressWarnings("unchecked")
     * Mirrors {@code PlanShapeTests.testUnionThenSort_2shard}: union two arms then sort
    }
        );
                + " | append [ | where str0 = 'OFFICE SUPPLIES' | full join on str0 = str0 [source="
     *
    }
            row(null, null, -14, null),
            row(1, "FURNITURE", null),
                + CALCS.indexName
                + " | stats sum(int0) as sum by str0 | sort str0"
            Map<String, Object> response = executePpl(ppl);
        // to LogicalValues(empty), which OpenSearchUnionRule then drops.
            sb.append(normalizeCell(row.get(i)));
        assertRowsAnyOrder(
     */
     * Send a PPL query expecting the planner to reject it; assert the resulting HTTP
        assertEmptyAppendOnlyFirstBranch(
        // Branch 1: calcs grouped by str0 (3 rows). Branch 2: calcs_alt total sum(int1)
            "source="
        );
    }
            row(null, "OFFICE SUPPLIES", 6),
    protected void onBeforeQuery() throws IOException {
 * <p>Provisions the {@code calcs} dataset twice — once into the {@code calcs} index and
                + " | append [ source="
 * {@link DatasetProvisioner}; {@link AnalyticsRestTestCase#preserveIndicesUponCompletion()}
    private static List<Object> row(Object... values) {
                + CALCS.indexName
     * (the unioned multiset is stable), so we can use {@link #assertRows} instead of
    /**
        );
    // ── helpers ─────────────────────────────────────────────────────────────────
     */
            }
        if (cell instanceof Number) return Double.toString(((Number) cell).doubleValue());
                + " | append [ | left join left=L right=R on L.str0 = R.str0 "
     * {@code Integer}/{@code Long}/{@code Double} compare equal across the Java side
        } catch (ResponseException e) {
                "Expected response body to contain [" + expectedSubstring + "] but was: " + body,
    private final void assertRows(String ppl, List<Object>... expected) throws IOException {
 * {@code POST /_plugins/_ppl} (exposed by the {@code opensearch-sql} plugin), which
    }
     * deterministic. Substrait's {@code Set} (Union) rel preserves order within a
        // error before execution.
     * numeric types collapse to a {@code Double} so JSON-parsed
    /**
import java.util.List;
    public void testAppendEmptySearchCommandStatsWithoutSource() throws IOException {
            assertEquals("Column count mismatch at row " + i + " for query: " + ppl, want.size(), got.size());
            DatasetProvisioner.provision(client(), CALCS_ALT);
            "source="
            row(null, "FURNITURE", 2),
    }
                + " | sort sum"
        );
        );
 *       that also collapse to the first branch</li>
            List<Object> got = actualRows.get(i);
 * SPDX-License-Identifier: Apache-2.0
                + " | stats sum(int1) as sum_int1_by_str3 by str3 | sort sum_int1_by_str3 ]"
 *   <li>type-incompatibility error path raised in {@code SchemaUnifier}</li>
        // source is the empty Values relation; the inner stats produces no rows.
        }
            row(null, null, -8, "e"),
                + " | head 5",
     * {@code rows} match the expected list element-by-element using a numeric-tolerant
    @SafeVarargs
            "source="
                + CALCS.indexName
        // the first branch's rows plus the right-subquery's rows under the merged
/**
public class AppendCommandIT extends AnalyticsRestTestCase {
                + " | head 5",
     */
            row(18, "OFFICE SUPPLIES", null, null),
            if (Double.compare(e, a) != 0) {
    // ── empty subsearch — collapses to first branch ────────────────────────────
 *   <li>{@code | append [ ]} with several empty-subsearch shapes that all collapse to
        assertErrorContains(
            assertEquals(message, expected, actual);
 *   <li>two stats branches sorted + truncated by {@code head N}</li>
            "source="
        }
    /**
        // Same shape as right join — the empty left side has no rows to match, so
        // but Calcite's stable-sort isn't guaranteed across two streams in a Union, so we
        );
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
        // Same shape as testAppend (sum(int0) by str0 ⊎ sum(int1) by str3) but with an
                assertCellEquals("Cell mismatch at row " + i + ", col " + j + " for query: " + ppl, want.get(j), got.get(j));
    }
                + " | append [ source="
                + " | stats sum(int0) as sum by str0"
    /**
    public void testAppendEmptySearchWithLeftJoin() throws IOException {
    }
        if (expected instanceof Number && actual instanceof Number) {
 *
    public void testAppendEmptySearchCommandLookup() throws IOException {
 */
     * the unioned result. With an outer Sort the row order is deterministic across runs
    public void testAppendThenSort() throws IOException {
        );
            "source="
 * once into {@code calcs_alt} — so {@code testAppendDifferentIndex} can union across
     * orders).
        // the integer-sum branch. Within the null-sum group, ties on `sum` are stable —
            double e = ((Number) expected).doubleValue();
        assertEmptyAppendOnlyFirstBranch(
        // and PPL `sort` defaults to nulls-first for ASC, so the null-sum branch precedes
        assertEquals(message, expected, actual);
            List<Object> want = expected[i];
            "source="
                + CALCS.indexName
            row(1, "FURNITURE", null, null),
 *   <li>shared output column name across branches (no auto-rename)</li>
     */
            row(36, null, "e")
            "Unable to process column 'sum' due to incompatible types"
            );
        assertRows(ppl, row(1, "FURNITURE"), row(18, "OFFICE SUPPLIES"), row(49, "TECHNOLOGY"));
    public void testAppendDifferentIndex() throws IOException {
                + " | append [ | where int0 > 5 | lookup "
        Map<String, Object> response = executePpl(ppl);
        // between the two child-stage streams isn't deterministic, so compare as a
    }
    // ── empty subsearch with join (5 join types; 4 collapse to first branch) ───
 */
            "source="
        // schema (sum_int0_by_str0 / str0 / cnt). Inter-branch order is non-deterministic.
     */
    }
            }
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");
                + CALCS.indexName
            fail("Expected query to fail with [" + expectedSubstring + "] but got response: " + response);
    private static String normalizeRow(List<Object> row) {
import java.util.Arrays;
     * single input partition but not between partitions: the two child stages of
     * an {@code | append} pipeline can stream into the coordinator sink in either
            row(1, "FURNITURE", null),
    }
    // ── empty subsearch with right/full join — adds rows from the right side ───
                + CALCS.indexName
     * the multiset-comparing {@link #assertRowsAnyOrder}.
            row(18, "OFFICE SUPPLIES", null),
    /** Renders one row to a stable canonical string for multiset comparison. */
            row(32, null, null),
        assertRowsAnyOrder(
 *
    private void assertErrorContains(String ppl, String expectedSubstring) {
        assertRowsAnyOrder(
    }
            try {
        assertEmptyAppendOnlyFirstBranch(
            "source="
            "source="
        // assert as a multiset within the head-5 window.
        assertEmptyAppendOnlyFirstBranch(
                + CALCS.indexName
    }
                + CALCS.indexName
        // Both branches produce a column named "sum"; SchemaUnifier merges the column
    }
            DatasetProvisioner.provision(client(), CALCS);
                + " | stats sum(int0) as sum_int0_by_str0 by str0 | sort str0"
    }
                + CALCS.indexName
    /** Send {@code POST /_plugins/_ppl} and return the parsed JSON body. */
            return;
/*
        return cell.toString();
        @SuppressWarnings("unchecked")
                + " | append [ | semi join left=L right=R on L.str0 = R.str0 "
                + CALCS.indexName
    private static String normalizeCell(Object cell) {
                + " | stats sum(int0) as sum_int0_by_str0 by str0 | sort str0"
        }
     * order depending on shard scheduling timing, so a {@code | head N} on top of
 *   <li>{@code | append [ … | <right|full> join … ]} — joins where the right side
        );
    public void testAppendEmptySearchCommandNestedAppend() throws IOException {
                + " ]"
import org.opensearch.client.ResponseException;
                + " | stats sum(int0) as sum_int0_by_str0 by str0 | sort str0"
 *       side is empty</li>
                + " ]"
                + " | stats sum(int0) as sum_int0_by_str0 by str0 | sort str0"
 * runs the same {@code UnifiedQueryPlanner} → {@code CalciteRelNodeVisitor} → Substrait
    @SuppressWarnings("varargs")
     */
        }
     * Integer/Long/Double values that may not match {@code .equals()} across types
     * comparator (Java JSON parsing returns Integer/Long/Double interchangeably).
        assertRowsAnyOrder(
        // `| append [ | stats ... ]` — subsearch starts with a pipe, so the implicit
     * Send a PPL query to {@code POST /_plugins/_ppl} and assert the response's
            row(null, null, -22)
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
                + " | stats count() as cnt by str0 | sort str0 ] ]",
    private static boolean dataProvisioned = false;
    }
        return Arrays.asList(values);
     */
            row(49, "TECHNOLOGY", null),
            row(49, "TECHNOLOGY", null, null),
            "source="
        // Branch 1 produces "sum" as BIGINT; branch 2 casts "sum" to DOUBLE. Schema
     * reliably available inside test bodies.
        // by str3 (2 rows). Union all + head 5 keeps every row, but the order
    public void testAppend() throws IOException {
                + " | append [ | where str0 = 'OFFICE SUPPLIES' | right join on str0 = str0 [source="
        // `| append [ ]` — fully empty subsearch.
            "source="
                + CALCS.indexName
 *       contributes additional rows under the merged schema even though the left
 *       {@code | append [ ]}, inner {@code | lookup})</li>
        if (cell == null) return "<NULL>";
     * Multiset variant of {@link #assertRows} for queries whose row order is not
                + " | append [ | cross join left=L right=R on L.str0 = R.str0 "
                + " str0 as istr0 ]"
    // ── Union followed by Sort ─────────────────────────────────────────────────
                body.contains(expectedSubstring)
        );
            "source="
            row(49, "TECHNOLOGY", null),
            row(null, "FURNITURE", 2),
        // multiset.
 *
                + CALCS.indexName
 * <ul>
        assertEmptyAppendOnlyFirstBranch(
     * test method (not {@code setUp()}) — {@code OpenSearchRestTestCase}'s static
        // leaves the other null. Inter-branch order is non-deterministic; head 5 keeps
     * <p>Cell values are normalised to a canonical string form before comparison —
                + CALCS.indexName
    // ── cross-index union ───────────────────────────────────────────────────────
     * even when their boxed types differ. Rows are then compared as a sorted multiset.
        // Nested empty append inside a where-only subsearch.
        );
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
        assertRowsAnyOrder(
                + " | head 5",
            row(null, null, -8, "e")
 * </ul>
                + " | stats sum(int0) as sum by str0 | sort str0"
 *       the first branch (bare brackets, inner stats with no source, nested
            for (int j = 0; j < want.size(); j++) {
 *
                + " | stats sum(int1) as alt_sum_int1 ]",
    public void testAppendWithConflictTypeColumn() {
     * error body contains {@code expectedSubstring} (typically the validation message).
        } catch (IOException e) {
    /**
                + " | stats sum(int0) as sum_int0_by_str0 by str0 | sort str0"
        // streams arrive at the coordinator's Union in non-deterministic order.
 *   <li>cross-index union (a second copy of the same dataset under a different index name)</li>
                body = e.getMessage();
 * repository so that the analytics-engine path can be verified inside core without
                + CALCS.indexName
            row(1, "FURNITURE", null),
                + " | append [ source="
}
    @SuppressWarnings("varargs")
import java.io.IOException;
                + CALCS.indexName
     * a Union may pick different rows across runs (or the same rows in different
                + CALCS.indexName
        assertRowsAnyOrder(
        List<String> expectedNormalized = Arrays.stream(expected).map(AppendCommandIT::normalizeRow).sorted().toList();
            "source="
        }
            row(1, "FURNITURE", null),
            }
    private static final Dataset CALCS = new Dataset("calcs", "calcs");
                + " | append [ ]"
        );
        // by name. Group columns differ (str0 vs str3) so each row populates one and
     * factored to keep the four test methods readable.
        // outer | sort that makes the merged stream deterministic. Sort by sum ASC.
    }
            row(null, "TECHNOLOGY", 9)
                + " | stats sum(int0) as sum_int0_by_str0 by str0 | sort str0"
     * Lazily provision both calcs indices on first invocation. Must be called inside a
 * The OpenSearch Contributors require contributions made to
                + " | stats sum(int0) as sum_int0_by_str0 by str0 | sort str0"
package org.opensearch.analytics.qa;
    /** Construct an expected row from positional values matching the PPL output column order. */
            row(null, null, -14, null),
        // empty implicit source. EmptySourcePropagateVisitor collapses the subsearch
        // `| append [ | where … | lookup INDEX field as alias ]` — lookup against an
            double a = ((Number) actual).doubleValue();
            row(18, "OFFICE SUPPLIES", null, null),
                + " ]"
            row(49, "TECHNOLOGY", null, null)
        assertEmptyAppendOnlyFirstBranch(
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
 * this file be licensed under the Apache-2.0 license or a
                + " | append [ | join left=L right=R on L.str0 = R.str0 "
        for (int i = 0; i < expected.length; i++) {
                + " | append [ | stats sum(int1) as alt_sum by bool0 ]"
     * even when numerically equal.
                + CALCS.indexName
                + " ]"
        for (int i = 0; i < row.size(); i++) {
            row(18, "OFFICE SUPPLIES", null),
            row(49, "TECHNOLOGY", null),
            row(1, "FURNITURE", null, null),
        assertEmptyAppendOnlyFirstBranch(
        assertEmptyAppendOnlyFirstBranch(
    }
    // ── shared output column name across branches (no auto-rename) ──────────────
 * indices without pulling in a second dataset. Both indices are parquet-backed via
            row(18, "OFFICE SUPPLIES", null),
        // every row (3 + 2 = 5) so multiset comparison is exact.
            "source="
    }
                + " | stats sum(int0) as sum_int0_by_str0 by str0 | sort str0"
        assertEquals("Row multisets differ for query: " + ppl, expectedNormalized, actualNormalized);
        // unification refuses to merge the diverging types and surfaces a planner
import java.util.Map;
     * Compare two cells with numeric tolerance — JSON parsing produces
            if (i > 0) sb.append('|');
