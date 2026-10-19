            DatasetProvisioner.provision(client(), DATASET);
    @SafeVarargs
        // SqlTypeName.NULL operand in a CASE call to a typed null literal matching the  
    // ── CASE on the eval side — explicit case() expression lowers to CASE WHEN ──
        }  
            "| multisearch"
 *  
import java.io.IOException;
        // Three string-equality branches over the calcs str0 column. `str0` distribution is  
import org.opensearch.client.ResponseException;
import org.opensearch.client.Request;  
 *
        //
            }
 * {@code CalciteMultisearchCommandIT}, narrowed to surfaces the analytics path
    }  
        // analytics-path correctness check.  
        for (int i = 0; i < expected.length; i++) {  
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
        // Substrait IfThen rel that DataFusion's substrait consumer handles natively —
                );
        // Branch 1 keeps rows with int0 < 5 and labels them "low" via eval; branch 2 keeps
        // Each branch projects to (str0, bucket) so the union row type is scalar-only.  
        // DataFusion executes the Union+Aggregate.
                + "    [search source=" + DATASET.indexName + " | where str0 = \"TECHNOLOGY\"      | eval bucket = \"T\" | fields str0, bucket]"
    private static List<Object> row(Object... values) {  
    }
                    got.get(j)  
    public void testMultisearchSingleSubsearchRejected() throws IOException {
                got.size()  
        // `Unable to convert the type NULL` on that, tracked separately.
                + "    [search source=" + DATASET.indexName + " | where str0 = \"FURNITURE\"       | eval bucket = \"F\" | fields str0, bucket]"  
        );
        // itself is registered in the project capability set so the planner doesn't reject
        // — it never reaches CalciteRelNodeVisitor / SchemaUnifier / substrait emission, so
                body.contains(expectedSubstring)
        // int0 < 5 → 5 rows (1 + 1 + 3 = low); int0 >= 5 → 6 rows (3 + 1 + 1 + 1 = high);
        );
    // multisearch is a *statement-leading* command in the PPL grammar (it lives in the
        // attachFragmentOnTop(Aggregate, convertFragment(Union))).
    private static void assertCellEquals(String message, Object expected, Object actual) {
                + " | stats count by bucket | sort bucket",
            "| multisearch"
                + "    [search source=" + DATASET.indexName + " | where int0 < 5  | eval class = \"low\"  | fields int0, class]"  
            if (Double.compare(e, a) != 0) {  
            for (int j = 0; j < want.size(); j++) {
        // exact coordinator shape the DataFusionFragmentConvertor.rewire fix targets.
            } catch (Exception ioe) {
        // untyped NULL literal — `eval bucket = case(int0 < 5, "low" else "rest")` keeps  
            assertTrue(
package org.opensearch.analytics.qa;
 * The OpenSearch Contributors require contributions made to  
        // Each branch projects to (int0, class) so the union row type is scalar-only.  
        if (expected == null || actual == null) {
        // it's a regression-pin against accidental relaxation of the arity check, not an
        //
import java.util.Arrays;
        }  
        // calcs int0 distribution: 1×{1, 3, 7, 10, 11}, 3×{4, 8}, 6×null.  
        if (expected instanceof Number && actual instanceof Number) {  
        // calcs int0 distribution (see testMultisearchTwoBranchesByCategory): 5 rows < 5,  
        // the convertReduceFragment chain attachFragmentOnTop(Sort,
                "Expected response body to contain [" + expectedSubstring + "] but was: " + body,  
        // both arms VARCHAR. The `count(eval(predicate))` idiom (the v2-side
    }  
        // 6 rows >= 5; the union below feeds 11 rows total to the case-eval. low maps to
        assertRows(  
            row(2L, "F"),
 */  
        // wrapper aggregate's [count, bucket] names propagate end-to-end, plan deserializes,
                + " | stats count by class | sort class",
                + "    [search source=" + DATASET.indexName + " | where str0 = \"OFFICE SUPPLIES\" | eval bucket = \"O\" | fields str0, bucket]"
 * {@code Sort(Aggregate(Union(StageInputScan, …, StageInputScan)))} — the same
 *
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
                assertCellEquals(  
    public void testMultisearchTwoBranchesByCategory() throws IOException {  
        assertRows(  
    private static boolean dataProvisioned = false;
                + "    [search source=" + DATASET.indexName + " | where int0 < 5  | fields int0]"
    public void testMultisearchCountEvalConditionalCount() throws IOException {
        // 11 rows feed the count-eval. `count(eval(class = "low"))` matches 5 (the low-bucketed
        // PPL `eval x = case(cond, val, …)` lowers to a Calcite SqlKind.CASE which the
                want.size(),
        }
    }  
            double e = ((Number) expected).doubleValue();
        }  
                + " | stats count by bucket | sort bucket",  
 *
        // Verifies: Union over two same-schema projections + Aggregate(count by) on top —  
        @SuppressWarnings("unchecked")
                + "    [search source=" + DATASET.indexName + " | where int0 >= 5 | fields int0]"  
/*  
    }
        }
            "| multisearch"
            );
 * <p>Reuses the {@code calcs} dataset; no new fixtures.
 * (this PR's substrait `Plan.Root.names` repair) targets.  
                body = e.getMessage();  
 * this file be licensed under the Apache-2.0 license or a
            Map<String, Object> response = executePpl(ppl);
 * Self-contained integration test for PPL {@code multisearch} on the analytics-engine route.
        );
            "| multisearch [search source=" + DATASET.indexName + " | head 1]",
 */  
    // ── 3-way multisearch — the shape that triggered the substrait names bug ───
    // ── arity check — caught at parse, never reaches the analytics path ────────
        Map<String, Object> response = executePpl(ppl);
            fail("Expected query to fail with [" + expectedSubstring + "] but got response: " + response);  
        // rows), `count(eval(class = "high"))` matches 6, and `count()` totals 11.
        assertRows(
            );
            row(5L, "low"),  
import java.util.List;  
            List<Object> got = actualRows.get(i);
    public void testMultisearchEvalCaseProjection() throws IOException {  
        // NULL with "Unable to convert the type NULL".  
        } catch (ResponseException e) {
        // [CASE] among [datafusion]" (capability not registered). With CASE in the  
        // whose type is SqlTypeName.NULL; isthmus' TypeConverter throws  
            assertEquals(message, expected, actual);  
        // 6 rows >= 5; 6 nulls excluded by both branch predicates. After multisearch,  
        // analytics planner used to reject with "No backend supports scalar function
import java.util.Map;
            row(6L, "rest")
            assertEquals(  
    }  
        try {
        // CASE's resolved return type before the SubstraitRelVisitor sees the plan. CASE
        // The PPL parser's AstBuilder.visitMultisearchCommand requires ≥2 subsearches and
    private static final Dataset DATASET = new Dataset("calcs", "calcs");  
        // Pre-fix: 500 with "Names list ... 2 uses for {row-type-width} names". Post-fix: the  
            }
    // ── basic 2-way multisearch with stats+sort ────────────────────────────────  
}
        assertEquals(message, expected, actual);
        return Arrays.asList(values);
public class MultisearchCommandIT extends AnalyticsRestTestCase {
        // no extension lookup or adapter required.  
        if (dataProvisioned == false) {  
            row(5L, "low")
            row(6L, "O"),
    }
                + " | stats count(eval(class = \"low\"))  as low_count,"
        // int0 >= 5 and labels them "high". After Union, stats counts per `class` bucket.
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");
 * <p>{@code multisearch} produces a Calcite {@code LogicalUnion} of N branches with
            row(9L, "T")  
    private final void assertRows(String ppl, List<Object>... expected) throws IOException {  
                    want.get(j),
        );
            return;
        // calcs int0 distribution (see testMultisearchTwoBranchesByCategory): 5 rows < 5,
        // the operator before substrait emission either.  
                + " | eval bucket = case(int0 < 5, \"low\" else \"rest\")"
    // ── CASE with implicit ELSE NULL — `count(eval(predicate))` shape ──────────
                + "         count(eval(class = \"high\")) as high_count,"
    // ── helpers ─────────────────────────────────────────────────────────────────
    private void assertErrorContains(String ppl, String expectedSubstring) throws IOException {  
import org.opensearch.client.Response;
            dataProvisioned = true;
        //
            String body;
        //
        assertNotNull("Response missing 'rows' for query: " + ppl, actualRows);
 * <p>Mirrors the simplest passing shapes from the SQL plugin's  
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
    }
    // subsearch must carry its own `source=`; placing `source=... | multisearch …` is a  
            List<Object> want = expected[i];
        // 6 null rows excluded by both predicates (5 + 6 + 6 = 17 total).
    @SuppressWarnings("varargs")
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");  
        // throws a SyntaxCheckException eagerly. This case exercises the parser-side guard  
        // project capability set, isthmus translates SqlKind.CASE structurally to a
    @Override
                body = org.apache.hc.core5.http.io.entity.EntityUtils.toString(e.getResponse().getEntity());
    // syntax error.
                + "    [search source=" + DATASET.indexName + " | where int0 >= 5 | eval class = \"high\" | fields int0, class]"  
 * {@code SchemaUnifier} reconciling per-branch schemas. The coordinator stage shape
        // testMultisearchSuccessRatePattern shape) generates an implicit `else NULL`
        assertErrorContains(
        // `count(eval(predicate))` is PPL's conditional-count idiom. Calcite lowers it to  
    }
/**  
        assertRows(
            double a = ((Number) actual).doubleValue();
        // Mirror of the v2-side `CalciteMultisearchCommandIT.testMultisearchSuccessRatePattern`:
 * already supports end-to-end (basic 2-way, 3-way, and the arity-check error).
    }
            "Multisearch command requires at least two subsearches"  
            return;  
        // ("low", 5), rest (the high branch's contribution) to ("rest", 6).
            row(6L, "high"),  
        // Each branch uses an explicit `else` arm so isthmus doesn't have to convert an
    // `pplCommands` alternation, not the mid-pipeline `commands` alternation). Each
                + "    [search source=" + DATASET.indexName + " | where int0 >= 5 | eval class = \"high\" | fields int0, class]"
            try {  
            row(5L, 6L, 11L)
 * SPDX-License-Identifier: Apache-2.0
    public void testMultisearchThreeBranchesByStr0() throws IOException {
                + "         count() as grand_count",  
 * compatible open source license.
                "Column count mismatch at row " + i + " for query: " + ppl,
                + "    [search source=" + DATASET.indexName + " | where int0 < 5  | eval class = \"low\"  | fields int0, class]"
            }
        // FURNITURE=2, OFFICE SUPPLIES=6, TECHNOLOGY=9. The 3-way Union(ER, ER, ER) is the
 * shape the {@code DataFusionFragmentConvertor.rewire} fix
        // becomes a `RexLiteral` with `SqlTypeName.NULL`. Isthmus' TypeConverter rejects
        // The {@link UntypedNullPreprocessor} pass added in this PR rewrites every
    protected void onBeforeQuery() throws IOException {
        );
 * the analytics path lowers is  
            "| multisearch"
    @AwaitsFix(bugUrl = "Real opensearch-sql plugin: multisearch 3-branch union | stats count by bucket returns wrong counts (expected 6, got 2) - union branch results are under-aggregated. Separate correctness bug; delegation_possible (the prior failure) is fixed.")
        // `COUNT(CASE WHEN predicate THEN <projected> END)`, where the implicit ELSE arm
