import org.opensearch.client.Response;
 * <p>Provisions the {@code calcs} dataset (parquet-backed) once per class via
            row("OFFICE SUPPLIES", "three", "A=OFFICE SUPPLIES, B=three"),  
            row("TECHNOLOGY", "eleven", "TECHNOLOGY eleven"),  
            row("OFFICE SUPPLIES", "five", "A=OFFICE SUPPLIES, B=five"),
            row("five", "Hello five"),  
 * Self-contained integration test for PPL {@code eval} on the analytics-engine route.
            "source=" + DATASET.indexName + " | fields str2 | eval greeting = 'Hello ' + str2",
    /**
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
            row("OFFICE SUPPLIES", null, null),
 *  
            row("one", 1, "Int: 1"),
     */
            row("six", 3, "Int: 3"),
            assertEquals(message, expected, actual);  
            double a = ((Number) actual).doubleValue();
 * {@link org.opensearch.analytics.spi.ScalarFunction#CONCAT} and
            if (Double.compare(e, a) != 0) {  
            row(null, null),
        // Chains four CONCAT calls — exercises the recursive AnnotatedProjectExpression strip
 * Substrait → DataFusion pipeline as the SQL plugin's force-routed analytics path.
 * repository so that the analytics-engine path can be verified inside core without
            List<Object> want = expected[i];
/*  
            row("ten", "Hello ten"),
    public void testEvalStringConcatTwoFields() throws IOException {
 *  
     * static {@code client()} is not initialized until after {@code @BeforeClass}, but is
    private static boolean dataProvisioned = false;  
    }
    private static void assertCellEquals(String message, Object expected, Object actual) {
            row("OFFICE SUPPLIES", "five", "OFFICE SUPPLIES five"),  
            row("TECHNOLOGY", "fourteen", "TECHNOLOGY fourteen"),  
        }
 * branch of {@link org.opensearch.analytics.spi.ScalarFunction#fromSqlOperatorWithFallback} since it
            row("three", "Hello three"),
        );
            row("six", "Hello six"),
 * which runs the same {@code UnifiedQueryPlanner} → {@code CalciteRelNodeVisitor} →
        assertRows(  
        if (expected == null || actual == null) {
    }
            row(null, null, null),
            row("TECHNOLOGY", null, null),
            for (int j = 0; j < want.size(); j++) {
            row("fourteen", 4, "Int: 4"),  
        );
 * cross-plugin dependencies on the SQL plugin. Each test sends a PPL query through
        }
 * {@code POST /_plugins/_ppl} (exposed by the {@code opensearch-sql} plugin),  
            row("eight", "Hello eight"),  
            }
        if (expected instanceof Number && actual instanceof Number) {  
        }
            row("TECHNOLOGY", "ten", "A=TECHNOLOGY, B=ten"),
            row("ten", 8, "Int: 8"),
            row("TECHNOLOGY", "fifteen", "A=TECHNOLOGY, B=fifteen"),  
 * this file be licensed under the Apache-2.0 license or a
            row("TECHNOLOGY", "nine", "A=TECHNOLOGY, B=nine"),  
 * {@link DatasetProvisioner}; {@link AnalyticsRestTestCase#preserveIndicesUponCompletion()}
 * keeps it across test methods.  
            assertEquals("Column count mismatch at row " + i + " for query: " + ppl, want.size(), got.size());  
    protected void onBeforeQuery() throws IOException {  
            row("fifteen", 11, "Int: 11"),
        // 'Hello ' + str2 — Calcite emits || (CONCAT). Null str2 propagates through CONCAT,
            row("FURNITURE", "one", "A=FURNITURE, B=one"),
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
        // CAST(null AS STRING) is null; concat with null propagates → label is null.
            row("five", 7, "Int: 7"),  
            row("OFFICE SUPPLIES", "six", "A=OFFICE SUPPLIES, B=six"),  
            row("twelve", "Hello twelve"),
        assertRows(  
import java.util.Arrays;
            row("two", null, null),  
        // Pure field-to-field concat through two || calls (str0 + ' ' + str2).  
            row("three", null, null),
            }  
            row("FURNITURE", "one", "FURNITURE one"),
        @SuppressWarnings("unchecked")
    // ── string concat: 'literal' + str_field ──────────────────────────────────
 * backend's {@code STANDARD_PROJECT_OPS}. {@code ||} resolves through the symbolic-name  
            row("OFFICE SUPPLIES", "six", "OFFICE SUPPLIES six"),
            row("TECHNOLOGY", null, null),
            row("fifteen", "Hello fifteen"),
            "source=" + DATASET.indexName + " | eval label = 'Int: ' + CAST(int0 AS STRING) | fields str2, int0, label",
            row(null, 8, "Int: 8")  
    }
            row("fourteen", "Hello fourteen"),  
    public void testEvalStringConcatLiteralPlusField() throws IOException {  
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
            row("TECHNOLOGY", "fifteen", "TECHNOLOGY fifteen"),
     * interchangeably. PPL doesn't preserve the distinction at the API surface, so cross-type numeric
     * reliably available inside test bodies.  
            row(null, null)  
            "source=" + DATASET.indexName + " | eval full_label = 'A=' + str0 + ', B=' + str2 | fields str0, str2, full_label",  
 * compatible open source license.
        for (int i = 0; i < expected.length; i++) {  
    }
        }
     * Lazily provision the calcs dataset on first invocation. Must be called inside a test  
import java.io.IOException;
        assertRows(
        Map<String, Object> response = executePpl(ppl);
    private final void assertRows(String ppl, List<Object>... expected) throws IOException {  
            row("OFFICE SUPPLIES", "eight", "OFFICE SUPPLIES eight"),  
    @Override
 * The OpenSearch Contributors require contributions made to  
            row("OFFICE SUPPLIES", null, null),
    }
 */  
            row("OFFICE SUPPLIES", null, null),
        // producing a null greeting (e.g. row index 3 has str2 = null → greeting = null).
            double e = ((Number) expected).doubleValue();
            row("eleven", 4, "Int: 4"),  
            row("nine", null, null),
            return;  
    private static List<Object> row(Object... values) {  
        if (dataProvisioned == false) {
            row("two", "Hello two"),  
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");  
        // int0 has nulls at rows 1, 2, 3, 7, 8, 12 (per FillNullCommandIT row data).
package org.opensearch.analytics.qa;
        );  
            row("OFFICE SUPPLIES", null, null),
            row(null, null, null),
 * <p>Mirrors {@code CalciteEvalCommandIT} from the {@code opensearch-project/sql}  
    public void testEvalStringConcatMultipleLiteralsAndFields() throws IOException {  
            row("OFFICE SUPPLIES", "eight", "A=OFFICE SUPPLIES, B=eight"),
            row("TECHNOLOGY", "ten", "TECHNOLOGY ten"),
 *
            row(null, null),
            row("TECHNOLOGY", "sixteen", "TECHNOLOGY sixteen"),
            row("TECHNOLOGY", "twelve", "TECHNOLOGY twelve"),
            DatasetProvisioner.provision(client(), DATASET);
            row("TECHNOLOGY", "sixteen", "A=TECHNOLOGY, B=sixteen"),
            row("eight", null, null),  
     */  
    public void testEvalStringConcatWithCastIntField() throws IOException {  
import org.opensearch.client.Request;
            row(null, 8, "Int: 8"),
 *
            row("one", "Hello one"),
    @SuppressWarnings("varargs")
        );
            row("TECHNOLOGY", "nine", "TECHNOLOGY nine"),
        // str0 ("FURNITURE"-style) is non-null in calcs; str2 has nulls — null str2  
            row("TECHNOLOGY", "fourteen", "A=TECHNOLOGY, B=fourteen"),
    /**
            row("TECHNOLOGY", null, null)
            row("FURNITURE", "two", "A=FURNITURE, B=two"),
        // No literal-only operands — the planner must accept CONCAT with both
 * is a {@code SqlBinaryOperator} (not a {@code SqlFunction}) with {@code SqlKind.OTHER}.
        // RexInputRef inputs (hasFieldRef=true path in resolveScalarViableBackends).
        // for nested project calls (same pattern that fillnull surfaced for ceil(num1)).
            dataProvisioned = true;  
            row("FURNITURE", "two", "FURNITURE two"),  
    // ── chained concat: 'a' + str + 'b' + str' ────────────────────────────────
/**  
 * SPDX-License-Identifier: Apache-2.0
            row("TECHNOLOGY", null, null)  
 * <p>The eval surface this test exercises is string concatenation via PPL's {@code +}
     * method (not {@code setUp()}) — {@link org.opensearch.test.rest.OpenSearchRestTestCase}'s
            return;
                assertCellEquals("Cell mismatch at row " + i + ", col " + j + " for query: " + ppl, want.get(j), got.get(j));
            row("sixteen", "Hello sixteen"),
    // ── concat between two field references ───────────────────────────────────  
            row("twelve", 10, "Int: 10"),
import java.util.List;  
            row(null, null),
     * Numeric-tolerant cell comparison — JSON parsing returns {@code Integer}/{@code Long}/{@code Double}  
    // ── CAST + concat: 'literal' + CAST(int AS STRING) ────────────────────────
        return Arrays.asList(values);
public class EvalCommandIT extends AnalyticsRestTestCase {
 * {@link org.opensearch.analytics.spi.ScalarFunction#CAST} entries in the DataFusion
    // ── helpers ─────────────────────────────────────────────────────────────────
 */
 * operator (lowered to Calcite's {@code SqlStdOperatorTable.CONCAT}, i.e. the {@code ||}
            List<Object> got = actualRows.get(i);
            row("TECHNOLOGY", "eleven", "A=TECHNOLOGY, B=eleven"),
     * equality must be measured by {@code double} values rather than {@link Object#equals(Object)}.
        // propagates through the chain to make the whole row's full_label null.
    }
    }
            row("eleven", "Hello eleven"),  
}
        assertEquals(message, expected, actual);
        assertRows(  
    @SafeVarargs
            row("OFFICE SUPPLIES", "three", "OFFICE SUPPLIES three"),
    }  
            row("TECHNOLOGY", "twelve", "A=TECHNOLOGY, B=twelve"),  
 * binary operator) and {@code CAST(... AS STRING)}, both routed through the  
            row("sixteen", 4, "Int: 4"),
            "source=" + DATASET.indexName + " | eval combo = str0 + ' ' + str2 | fields str0, str2, combo",
import java.util.Map;
            row("nine", "Hello nine"),
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");
