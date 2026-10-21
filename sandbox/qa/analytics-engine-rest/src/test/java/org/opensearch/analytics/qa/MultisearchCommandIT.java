        // Each branch projects to (str0, bucket) so the union row type is scalar-only.
        // calcs int0 distribution: 1×{1, 3, 7, 10, 11}, 3×{4, 8}, 6×null.
 * <p>Reuses the {@code calcs} dataset; no new fixtures.
        }
            );
import org.opensearch.client.Response;
 * Self-contained integration test for PPL {@code multisearch} on the analytics-engine route.
                body = org.apache.hc.core5.http.io.entity.EntityUtils.toString(e.getResponse().getEntity());
        return Arrays.asList(values);
    public void testMultisearchCountEvalConditionalCount() throws IOException {
    private static List<Object> row(Object... values) {
import org.opensearch.client.Request;
                assertCellEquals(
            row(9L, "T")
            row(5L, "low"),
        for (int i = 0; i < expected.length; i++) {
        if (expected instanceof Number && actual instanceof Number) {
        } catch (ResponseException e) {
        // project capability set, isthmus translates SqlKind.CASE structurally to a
            row(6L, "rest")
 * the analytics path lowers is
        // attachFragmentOnTop(Aggregate, convertFragment(Union))).
        }
 * The OpenSearch Contributors require contributions made to
    }
                "Expected response body to contain [" + expectedSubstring + "] but was: " + body,
        // — it never reaches CalciteRelNodeVisitor / SchemaUnifier / substrait emission, so
                + " | stats count by bucket | sort bucket",
        }
        if (dataProvisioned == false) {
        // Branch 1 keeps rows with int0 < 5 and labels them "low" via eval; branch 2 keeps
            try {
                + " | eval bucket = case(int0 < 5, \"low\" else \"rest\")"
 * {@code SchemaUnifier} reconciling per-branch schemas. The coordinator stage shape
 * <p>{@code multisearch} produces a Calcite {@code LogicalUnion} of N branches with
    private final void assertRows(String ppl, List<Object>... expected) throws IOException {
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");
import org.opensearch.client.ResponseException;
        // 11 rows feed the count-eval. `count(eval(class = "low"))` matches 5 (the low-bucketed
                + "    [search source=" + DATASET.indexName + " | where int0 >= 5 | eval class = \"high\" | fields int0, class]"
            List<Object> want = expected[i];
            double e = ((Number) expected).doubleValue();
    // subsearch must carry its own `source=`; placing `source=... | multisearch …` is a
            assertEquals(message, expected, actual);
    // ── CASE on the eval side — explicit case() expression lowers to CASE WHEN ──
        }
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
 *
import java.util.List;
    }
        // `COUNT(CASE WHEN predicate THEN <projected> END)`, where the implicit ELSE arm
        // The {@link UntypedNullPreprocessor} pass added in this PR rewrites every
    @SuppressWarnings("varargs")
            if (Double.compare(e, a) != 0) {
                + "    [search source=" + DATASET.indexName + " | where int0 >= 5 | eval class = \"high\" | fields int0, class]"
        try {
}
                + "         count() as grand_count",
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
        // wrapper aggregate's [count, bucket] names propagate end-to-end, plan deserializes,
                body.contains(expectedSubstring)
    private void assertErrorContains(String ppl, String expectedSubstring) throws IOException {
        // no extension lookup or adapter required.
        // int0 >= 5 and labels them "high". After Union, stats counts per `class` bucket.
    // syntax error.
        // itself is registered in the project capability set so the planner doesn't reject
        // ("low", 5), rest (the high branch's contribution) to ("rest", 6).
        // DataFusion executes the Union+Aggregate.
 * this file be licensed under the Apache-2.0 license or a
    }
        // rows), `count(eval(class = "high"))` matches 6, and `count()` totals 11.
            for (int j = 0; j < want.size(); j++) {
            } catch (Exception ioe) {
import java.io.IOException;
                + "    [search source=" + DATASET.indexName + " | where str0 = \"FURNITURE\"       | eval bucket = \"F\" | fields str0, bucket]"
    // ── CASE with implicit ELSE NULL — `count(eval(predicate))` shape ──────────
            }
            dataProvisioned = true;
    // `pplCommands` alternation, not the mid-pipeline `commands` alternation). Each
        // analytics planner used to reject with "No backend supports scalar function
            return;
import java.util.Map;
    }
            Map<String, Object> response = executePpl(ppl);
        // Pre-fix: 500 with "Names list ... 2 uses for {row-type-width} names". Post-fix: the
    // ── 3-way multisearch — the shape that triggered the substrait names bug ───
 * already supports end-to-end (basic 2-way, 3-way, and the arity-check error).
        //
        assertEquals(message, expected, actual);
                want.size(),
            "| multisearch"
    public void testMultisearchEvalCaseProjection() throws IOException {
    }
                body = e.getMessage();
    private static void assertCellEquals(String message, Object expected, Object actual) {
        // `Unable to convert the type NULL` on that, tracked separately.
 * (this PR's substrait `Plan.Root.names` repair) targets.
            return;
            List<Object> got = actualRows.get(i);
        );
 * compatible open source license.
    @Override
    // ── helpers ─────────────────────────────────────────────────────────────────
        }
                + "    [search source=" + DATASET.indexName + " | where int0 >= 5 | fields int0]"
        // 6 rows >= 5; the union below feeds 11 rows total to the case-eval. low maps to
        // PPL `eval x = case(cond, val, …)` lowers to a Calcite SqlKind.CASE which the
            double a = ((Number) actual).doubleValue();
                    want.get(j),
                + "    [search source=" + DATASET.indexName + " | where int0 < 5  | eval class = \"low\"  | fields int0, class]"
        assertRows(
                );
                + "    [search source=" + DATASET.indexName + " | where str0 = \"TECHNOLOGY\"      | eval bucket = \"T\" | fields str0, bucket]"
        // Three string-equality branches over the calcs str0 column. `str0` distribution is
    public void testMultisearchSingleSubsearchRejected() throws IOException {
    }
        // becomes a `RexLiteral` with `SqlTypeName.NULL`. Isthmus' TypeConverter rejects
 */
 */
    }
                + " | stats count by bucket | sort bucket",
            row(5L, 6L, 11L)
 * shape the {@code DataFusionFragmentConvertor.rewire} fix
    public void testMultisearchThreeBranchesByStr0() throws IOException {
    }
        // Verifies: Union over two same-schema projections + Aggregate(count by) on top —
 * <p>Mirrors the simplest passing shapes from the SQL plugin's
        assertRows(
        assertRows(
    @SafeVarargs
            }
        // calcs int0 distribution (see testMultisearchTwoBranchesByCategory): 5 rows < 5,
        // Mirror of the v2-side `CalciteMultisearchCommandIT.testMultisearchSuccessRatePattern`:
                got.size()
            DatasetProvisioner.provision(client(), DATASET);
        );
        // int0 < 5 → 5 rows (1 + 1 + 3 = low); int0 >= 5 → 6 rows (3 + 1 + 1 + 1 = high);
                    got.get(j)
        // both arms VARCHAR. The `count(eval(predicate))` idiom (the v2-side
                + "    [search source=" + DATASET.indexName + " | where str0 = \"OFFICE SUPPLIES\" | eval bucket = \"O\" | fields str0, bucket]"
            "| multisearch"
        // calcs int0 distribution (see testMultisearchTwoBranchesByCategory): 5 rows < 5,
            row(6L, "O"),
                + "         count(eval(class = \"high\")) as high_count,"
        );
        // whose type is SqlTypeName.NULL; isthmus' TypeConverter throws
 * {@code Sort(Aggregate(Union(StageInputScan, …, StageInputScan)))} — the same
            "| multisearch"
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
        //
        // [CASE] among [datafusion]" (capability not registered). With CASE in the
        // Each branch projects to (int0, class) so the union row type is scalar-only.
        assertRows(
        assertNotNull("Response missing 'rows' for query: " + ppl, actualRows);
 *
        // NULL with "Unable to convert the type NULL".
    // ── arity check — caught at parse, never reaches the analytics path ────────
        // exact coordinator shape the DataFusionFragmentConvertor.rewire fix targets.
        // analytics-path correctness check.
        );
import java.util.Arrays;
            row(6L, "high"),
    public void testMultisearchTwoBranchesByCategory() throws IOException {
                + "    [search source=" + DATASET.indexName + " | where int0 < 5  | fields int0]"
        // throws a SyntaxCheckException eagerly. This case exercises the parser-side guard
            fail("Expected query to fail with [" + expectedSubstring + "] but got response: " + response);
            String body;
            "Multisearch command requires at least two subsearches"
 *
        assertErrorContains(
        );
            row(5L, "low")
        //
 * {@code CalciteMultisearchCommandIT}, narrowed to surfaces the analytics path
            }
        // CASE's resolved return type before the SubstraitRelVisitor sees the plan. CASE
        // testMultisearchSuccessRatePattern shape) generates an implicit `else NULL`
        // the operator before substrait emission either.
            "| multisearch [search source=" + DATASET.indexName + " | head 1]",
    private static boolean dataProvisioned = false;
public class MultisearchCommandIT extends AnalyticsRestTestCase {
    // multisearch is a *statement-leading* command in the PPL grammar (it lives in the
package org.opensearch.analytics.qa;
    @AwaitsFix(bugUrl = "Real opensearch-sql plugin: multisearch 3-branch union | stats count by bucket returns wrong counts (expected 6, got 2) - union branch results are under-aggregated. Separate correctness bug; delegation_possible (the prior failure) is fixed.")
        // FURNITURE=2, OFFICE SUPPLIES=6, TECHNOLOGY=9. The 3-way Union(ER, ER, ER) is the
                + " | stats count by class | sort class",
/*
        // 6 null rows excluded by both predicates (5 + 6 + 6 = 17 total).
        // Substrait IfThen rel that DataFusion's substrait consumer handles natively —
            assertTrue(
        @SuppressWarnings("unchecked")
    protected void onBeforeQuery() throws IOException {
        // `count(eval(predicate))` is PPL's conditional-count idiom. Calcite lowers it to
        if (expected == null || actual == null) {
                "Column count mismatch at row " + i + " for query: " + ppl,
    // ── basic 2-way multisearch with stats+sort ────────────────────────────────
            );
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
    }
        // SqlTypeName.NULL operand in a CASE call to a typed null literal matching the
            row(2L, "F"),
                + "    [search source=" + DATASET.indexName + " | where int0 < 5  | eval class = \"low\"  | fields int0, class]"
            assertEquals(
        // Each branch uses an explicit `else` arm so isthmus doesn't have to convert an
                + " | stats count(eval(class = \"low\"))  as low_count,"
/**
        // it's a regression-pin against accidental relaxation of the arity check, not an
 *
        // The PPL parser's AstBuilder.visitMultisearchCommand requires ≥2 subsearches and
        //
        Map<String, Object> response = executePpl(ppl);
        // the convertReduceFragment chain attachFragmentOnTop(Sort,
        // untyped NULL literal — `eval bucket = case(int0 < 5, "low" else "rest")` keeps
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
        // 6 rows >= 5; 6 nulls excluded by both branch predicates. After multisearch,
            "| multisearch"
    }
 * SPDX-License-Identifier: Apache-2.0
