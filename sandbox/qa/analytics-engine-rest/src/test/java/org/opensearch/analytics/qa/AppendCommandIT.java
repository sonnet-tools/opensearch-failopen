    }
 * runs the same {@code UnifiedQueryPlanner} → {@code CalciteRelNodeVisitor} → Substrait
                + " | append [ | cross join left=L right=R on L.str0 = R.str0 "  
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
                + " | stats sum(int0) as sum_int0_by_str0 by str0 | sort str0"
        assertEmptyAppendOnlyFirstBranch(
                + CALCS.indexName
                + CALCS.indexName
                + CALCS.indexName
    }  
    // ── type-incompatibility error raised in SchemaUnifier ─────────────────────
    }
     * (the unioned multiset is stable), so we can use {@link #assertRows} instead of  
        // and PPL `sort` defaults to nulls-first for ASC, so the null-sum branch precedes
     */  
 *
    public void testAppendEmptySearchCommandBareBrackets() throws IOException {  
     * deterministic. Substrait's {@code Set} (Union) rel preserves order within a  
     * even when their boxed types differ. Rows are then compared as a sorted multiset.
                + CALCS.indexName
    /**
    private static String normalizeRow(List<Object> row) {
                + " | stats sum(int0) as sum by str0 | sort str0"  
            row(49, "TECHNOLOGY", null),
 *   <li>cross-index union (a second copy of the same dataset under a different index name)</li>
    }  
        }  
            row(49, "TECHNOLOGY", null),  
            row(18, "OFFICE SUPPLIES", null),
                + CALCS.indexName
            if (Double.compare(e, a) != 0) {
                + " ]"  
            "source="
        );
     * order depending on shard scheduling timing, so a {@code | head N} on top of  
     * comparator (Java JSON parsing returns Integer/Long/Double interchangeably).
                + CALCS.indexName
    public void testAppendEmptySearchWithCrossJoin() throws IOException {
            row(null, null, -22)
            dataProvisioned = true;  
 * SPDX-License-Identifier: Apache-2.0
import java.util.Map;
        assertRowsAnyOrder(  
        assertRowsAnyOrder(
    }
            row(18, "OFFICE SUPPLIES", null),
     * {@code rows} match the expected list element-by-element using a numeric-tolerant
        // to LogicalValues(empty), which OpenSearchUnionRule then drops.
    // ── helpers ─────────────────────────────────────────────────────────────────
                + " | append [ source="
            row(1, "FURNITURE", null, null),
            double e = ((Number) expected).doubleValue();  
        );  
            "source="
    public void testAppend() throws IOException {  
        );  
                + " | stats count() as cnt by str0 | sort str0 ] ]",
 * The OpenSearch Contributors require contributions made to  
        // error before execution.  
    }
     * The four empty-subsearch shapes share the same expected first-branch-only output;
import java.io.IOException;
                + " | stats sum(int0) as sum_int0_by_str0 by str0 | sort str0"
            DatasetProvisioner.provision(client(), CALCS);
            "source="
        }
 *   <li>{@code | append [ … | <right|full> join … ]} — joins where the right side  
            row(null, "TECHNOLOGY", 9)
    }
        assertErrorContains(
        assertEmptyAppendOnlyFirstBranch(  
                + " | append [ | semi join left=L right=R on L.str0 = R.str0 "
        // Branch 1 produces "sum" as BIGINT; branch 2 casts "sum" to DOUBLE. Schema
        );
        // source is the empty Values relation; the inner stats produces no rows.  
    private void assertEmptyAppendOnlyFirstBranch(String ppl) throws IOException {
        try {  
                body.contains(expectedSubstring)  
    /** Construct an expected row from positional values matching the PPL output column order. */
            "source="
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");  
 * once into {@code calcs_alt} — so {@code testAppendDifferentIndex} can union across
 *   <li>type-incompatibility error path raised in {@code SchemaUnifier}</li>  
            if (i > 0) sb.append('|');
 *       contributes additional rows under the merged schema even though the left
        if (cell instanceof Number) return Double.toString(((Number) cell).doubleValue());  
                + " | stats sum(int1) as sum_int1_by_str3 by str3 | sort sum_int1_by_str3 ]"
    }  
     */  
import java.util.List;
 * compatible open source license.
}  
    }
 *
            DatasetProvisioner.provision(client(), CALCS_ALT);
        @SuppressWarnings("unchecked")
        // leaves the other null. Inter-branch order is non-deterministic; head 5 keeps
    // ── two stats branches → sort → head ────────────────────────────────────────
            );
            row(18, "OFFICE SUPPLIES", null, null),
            row(null, null, -14, null),
            "source="  
                + " | append [ | stats sum(int1) as alt_sum by bool0 ]"
     * Send a PPL query to {@code POST /_plugins/_ppl} and assert the response's  
        for (int i = 0; i < row.size(); i++) {  
            row(49, "TECHNOLOGY", null),
            assertTrue(
     * Compare two cells with numeric tolerance — JSON parsing produces
        @SuppressWarnings("unchecked")
        assertEmptyAppendOnlyFirstBranch(
        assertEquals("Row multisets differ for query: " + ppl, expectedNormalized, actualNormalized);  
     * Mirrors {@code PlanShapeTests.testUnionThenSort_2shard}: union two arms then sort
    private void assertErrorContains(String ppl, String expectedSubstring) {
            row(18, "OFFICE SUPPLIES", null),
    public void testAppendEmptySearchCommandStatsWithoutSource() throws IOException {
                + " | stats sum(int0) as sum by str0 | sort str0"
     * the unioned result. With an outer Sort the row order is deterministic across runs
    @SafeVarargs
        // Branch 1: sum(int0) grouped by str0 (3 rows). Branch 2: sum(int1) grouped
                + CALCS.indexName
 * <p>Mirrors {@code CalcitePPLAppendCommandIT} from the {@code opensearch-project/sql}
        // Same shape as right join — the empty left side has no rows to match, so
            row(null, "OFFICE SUPPLIES", 6),
    public void testAppendEmptySearchWithLeftJoin() throws IOException {  
                + " | append [ | where int0 > 5 | lookup "  
            "source="  
        }
        StringBuilder sb = new StringBuilder("[");
            try {
            "source="  
                + CALCS.indexName  
                + " | stats count() as cnt by str0 | sort str0 ] ]",  
                + " str0 as istr0 ]"
            }  
                + " | append [ source="
                + CALCS.indexName  
            row(null, "TECHNOLOGY", 9)  
                + " | append [ | where str0 = 'OFFICE SUPPLIES' | right join on str0 = str0 [source="  
 *   <li>{@code | append [ ]} with several empty-subsearch shapes that all collapse to
                + " | stats sum(int0) as sum_int0_by_str0 by str0 | sort str0"  
            Map<String, Object> response = executePpl(ppl);
     */
    // ── empty subsearch with right/full join — adds rows from the right side ───
            "source="
                + " | stats sum(int0) as sum_int0_by_str0 by str0 | sort str0"
                + CALCS_ALT.indexName
        if (dataProvisioned == false) {  
    }
 * <p>Provisions the {@code calcs} dataset twice — once into the {@code calcs} index and  
            row(1, "FURNITURE", null),  
                + " | head 5",  
            for (int j = 0; j < want.size(); j++) {
                + " | stats sum(int0) as sum_int0_by_str0 by str0 | sort str0"
    /**
    private static final Dataset CALCS = new Dataset("calcs", "calcs");
            row(49, "TECHNOLOGY", null),  
    public void testAppendEmptySearchCommandLookup() throws IOException {
 * {@code POST /_plugins/_ppl} (exposed by the {@code opensearch-sql} plugin), which
    @SafeVarargs  
                + " | head 5",
    }
        } catch (ResponseException e) {  
            "source="
package org.opensearch.analytics.qa;
 * indices without pulling in a second dataset. Both indices are parquet-backed via
 * Self-contained integration test for PPL {@code append} on the analytics-engine route.
     * {@code Integer}/{@code Long}/{@code Double} compare equal across the Java side  
     * factored to keep the four test methods readable.
 *   <li>shared output column name across branches (no auto-rename)</li>  
            }
                + " | append [ source="  
    public void testAppendEmptySearchWithRightJoin() throws IOException {  
        assertEmptyAppendOnlyFirstBranch(  
                + CALCS.indexName  
 * {@link DatasetProvisioner}; {@link AnalyticsRestTestCase#preserveIndicesUponCompletion()}  
            row(36, null, "e")  
import java.util.Arrays;  
     * <p>Cell values are normalised to a canonical string form before comparison —
import org.opensearch.client.ResponseException;  
import org.opensearch.client.Request;
        return cell.toString();
        // The second branch produces sum=null for every row (its own column is sum_alt),  
    }
                + " | append [ source="
                + CALCS.indexName
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);  
            "source="  
            row(1, "FURNITURE", null, null),
                + " | stats sum(int0) as sum_int0_by_str0 by str0 | sort str0"
            row(32, null, null),
    }
        // empty implicit source. EmptySourcePropagateVisitor collapses the subsearch  
 */
        for (int i = 0; i < expected.length; i++) {  
            "source="  
     * reliably available inside test bodies.
        // Nested empty append inside a where-only subsearch.
        // assert as a multiset within the head-5 window.
                + " | append [ | where str0 = 'OFFICE SUPPLIES' | full join on str0 = str0 [source="
     * a Union may pick different rows across runs (or the same rows in different
    }
    }  
    }
            row(null, "FURNITURE", 2),
        assertRowsAnyOrder(
    // ── cross-index union ───────────────────────────────────────────────────────  
        assertRowsAnyOrder(  
                + " | eval sum = cast(sum as double) ]"
            List<Object> got = actualRows.get(i);
     * the multiset-comparing {@link #assertRowsAnyOrder}.
    public void testAppendEmptySearchWithSemiJoin() throws IOException {
        // between the two child-stage streams isn't deterministic, so compare as a  
        Map<String, Object> response = executePpl(ppl);
                + " | append [ | where int0 > 5 | append [ ] ]"  
 */  
    }
                + " ]"
 *       that also collapse to the first branch</li>
        // multiset.
        List<String> expectedNormalized = Arrays.stream(expected).map(AppendCommandIT::normalizeRow).sorted().toList();
        assertRowsAnyOrder(  
        // Branch 1: calcs grouped by str0 (3 rows). Branch 2: calcs_alt total sum(int1)  
            row(49, "TECHNOLOGY", null, null),  
     * error body contains {@code expectedSubstring} (typically the validation message).  
        // RIGHT JOIN of (empty filtered subset, real subquery) → still emits every
        // every row (3 + 2 = 5) so multiset comparison is exact.
        return sb.append(']').toString();
            return;  
    private final void assertRows(String ppl, List<Object>... expected) throws IOException {  
                + CALCS.indexName
 *       the first branch (bare brackets, inner stats with no source, nested
        // right-side row with NULL on the left columns. The append therefore yields
        // `| append [ | stats ... ]` — subsearch starts with a pipe, so the implicit
        );  
            row(1, "FURNITURE", null),
                assertCellEquals("Cell mismatch at row " + i + ", col " + j + " for query: " + ppl, want.get(j), got.get(j));
     * Multiset variant of {@link #assertRows} for queries whose row order is not
                + " | sort sum"  
        if (cell == null) return "<NULL>";
            row(18, "OFFICE SUPPLIES", null, null),
    private static final Dataset CALCS_ALT = new Dataset("calcs", "calcs_alt");  
    }
            row(1, "FURNITURE", null),
    // ── shared output column name across branches (no auto-rename) ──────────────
    // ── Union followed by Sort ─────────────────────────────────────────────────
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
    private final void assertRowsAnyOrder(String ppl, List<Object>... expected) throws IOException {
        );
                + " | stats sum(int0) as sum by str3 | sort sum"
    /** Renders one row to a stable canonical string for multiset comparison. */  
     * Integer/Long/Double values that may not match {@code .equals()} across types  
                + CALCS.indexName
            }  
        List<String> actualNormalized = actualRows.stream().map(AppendCommandIT::normalizeRow).sorted().toList();
    /**  
                + " | stats sum(int0) as sum_int0_by_str0 by str0 | sort str0"
     * numeric types collapse to a {@code Double} so JSON-parsed
    /** Send {@code POST /_plugins/_ppl} and return the parsed JSON body. */
    // ── empty subsearch — collapses to first branch ────────────────────────────
        // unification refuses to merge the diverging types and surfaces a planner
                + " | append [ | join left=L right=R on L.str0 = R.str0 "
                + CALCS.indexName
            "source="
        );
            double a = ((Number) actual).doubleValue();
        // the first branch's rows plus the right-subquery's rows under the merged  
                + " ]"  
     * even when numerically equal.
     *  
                + " | stats sum(int0) as sum_int0_by_str0 by str0 | sort str0"  
        // outer | sort that makes the merged stream deterministic. Sort by sum ASC.
        // FULL JOIN reduces to RIGHT JOIN here. Inter-branch order is non-deterministic.
     * single input partition but not between partitions: the two child stages of
        );
 * </ul>
                + " | append [ | left join left=L right=R on L.str0 = R.str0 "
                + " | stats sum(int0) as sum by str0"
            assertEquals(message, expected, actual);
                + CALCS.indexName
 * <p>Covers the Append surface forms that exercise:
 *   <li>two stats branches sorted + truncated by {@code head N}</li>
            row(18, "OFFICE SUPPLIES", null),  
     * orders).
                + CALCS.indexName
                + " | stats sum(int0) as sum_int0_by_str0 by str0 | sort str0"  
                + " | stats sum(int0) as sum by str3 | sort sum ]"  
            String body;
            fail("Expected query to fail with [" + expectedSubstring + "] but got response: " + response);
                + CALCS.indexName
        );
        assertEmptyAppendOnlyFirstBranch(
        // streams arrive at the coordinator's Union in non-deterministic order.
/*  
    @SuppressWarnings("varargs")
    protected void onBeforeQuery() throws IOException {
            row(49, "TECHNOLOGY", null, null)  
            sb.append(normalizeCell(row.get(i)));
    }
import org.opensearch.client.Response;
     * an {@code | append} pipeline can stream into the coordinator sink in either
    public void testAppendThenSort() throws IOException {  
                + " | stats sum(int1) as alt_sum_int1 ]",  
    public void testAppendEmptySearchWithFullJoin() throws IOException {  
    /**
        // but Calcite's stable-sort isn't guaranteed across two streams in a Union, so we  
                + " | stats sum(int0) as sum_int0_by_str0 by str0 | sort str0"
                + CALCS.indexName
        assertRowsAnyOrder(
 * cross-plugin dependencies on the SQL plugin. Each test sends a PPL query through  
        );
    public void testAppendWithConflictTypeColumn() {  
    private static void assertCellEquals(String message, Object expected, Object actual) {  
        } catch (IOException e) {
     */
        );  
                + CALCS.indexName  
        Map<String, Object> response = executePpl(ppl);  
            row(null, null, -8, "e")
        assertEmptyAppendOnlyFirstBranch(
        // `| append [ ]` — fully empty subsearch.
        // the integer-sum branch. Within the null-sum group, ties on `sum` are stable —
        // (1 row). Each branch is its own data-node stage on its own shard set; the two
                + " | append [ ]"  
    public void testAppendWithMergedColumn() throws IOException {
                + " | stats sum(int1) as sum_alt by str3 ]"
        );
            assertEquals("Column count mismatch at row " + i + " for query: " + ppl, want.size(), got.size());  
    }
                + CALCS.indexName
            return;
            "source="
        );  
            "Unable to process column 'sum' due to incompatible types"
            } catch (Exception ioe) {
    // ── empty subsearch with join (5 join types; 4 collapse to first branch) ───  
            row(1, "FURNITURE", null),
            "source="  
        }
                + " | head 5",  
     * {@code client()} is not initialized until after {@code @BeforeClass} but is
 *   <li>{@code | append [ | <inner|cross|left|semi> join … ]} — empty-left-side joins
            row(null, null, -14, null),
                + " | stats sum(int0) as sum by str0 | sort str0"  
    @Override
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");  
            row(null, "FURNITURE", 2),  
 * repository so that the analytics-engine path can be verified inside core without
                + CALCS.indexName
        assertEmptyAppendOnlyFirstBranch(
     */  
                + " ]"
        // schema (sum_int0_by_str0 / str0 / cnt). Inter-branch order is non-deterministic.
 *
                + CALCS.indexName  
 *  
    }
        assertEmptyAppendOnlyFirstBranch(
    private static boolean dataProvisioned = false;
 * <ul>  
     */
 *       side is empty</li>
                + CALCS.indexName
     * Send a PPL query expecting the planner to reject it; assert the resulting HTTP
                + " | stats sum(int0) as sum_int0_by_str0 by str0 | sort str0"
public class AppendCommandIT extends AnalyticsRestTestCase {  
    /**
    }
        // Both branches produce a column named "sum"; SchemaUnifier merges the column
        assertRows(ppl, row(1, "FURNITURE"), row(18, "OFFICE SUPPLIES"), row(49, "TECHNOLOGY"));
        if (expected instanceof Number && actual instanceof Number) {
                + " | head 5",
            row(null, "OFFICE SUPPLIES", 6),
        assertEquals(message, expected, actual);
        }  
     */
    private static String normalizeCell(Object cell) {
        // Same shape as testAppend (sum(int0) by str0 ⊎ sum(int1) by str3) but with an
                + " | append [ source="  
            List<Object> want = expected[i];
                + CALCS.indexName
        );
                + CALCS.indexName
        );
     * Lazily provision both calcs indices on first invocation. Must be called inside a
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
    private static List<Object> row(Object... values) {
        if (expected == null || actual == null) {
    /**
/**
 * → DataFusion pipeline as the SQL plugin's force-routed analytics path.  
        }
                "Expected response body to contain [" + expectedSubstring + "] but was: " + body,
    public void testAppendEmptySearchWithInnerJoin() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
 *       {@code | append [ ]}, inner {@code | lookup})</li>  
 * keeps them across test methods.
            "source="  
    }
        // by str3 (2 rows). Union all + head 5 keeps every row, but the order
                body = e.getMessage();
            row(null, null, -8, "e"),  
            fail("Unexpected IOException: " + e);  
        // by name. Group columns differ (str0 vs str3) so each row populates one and  
    public void testAppendEmptySearchCommandNestedAppend() throws IOException {  
    }
                body = org.apache.hc.core5.http.io.entity.EntityUtils.toString(e.getResponse().getEntity());  
    /**  
        // `| append [ | where … | lookup INDEX field as alias ]` — lookup against an
    @SuppressWarnings("varargs")
    public void testAppendDifferentIndex() throws IOException {
     * test method (not {@code setUp()}) — {@code OpenSearchRestTestCase}'s static  
        return Arrays.asList(values);  
                + CALCS.indexName
