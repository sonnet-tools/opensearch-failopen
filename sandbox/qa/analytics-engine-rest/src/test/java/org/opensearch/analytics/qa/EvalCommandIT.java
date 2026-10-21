            row("FURNITURE", "one", "FURNITURE one"),
            row("fifteen", 11, "Int: 11"),
            row("FURNITURE", "two", "FURNITURE two"),
            row("TECHNOLOGY", "nine", "TECHNOLOGY nine"),
 * Substrait → DataFusion pipeline as the SQL plugin's force-routed analytics path.
            row("TECHNOLOGY", "ten", "A=TECHNOLOGY, B=ten"),
    protected void onBeforeQuery() throws IOException {
        // 'Hello ' + str2 — Calcite emits || (CONCAT). Null str2 propagates through CONCAT,
            dataProvisioned = true;
            row(null, null),
            row("TECHNOLOGY", "sixteen", "A=TECHNOLOGY, B=sixteen"),
            "source=" + DATASET.indexName + " | eval label = 'Int: ' + CAST(int0 AS STRING) | fields str2, int0, label",
            row("eight", null, null),
        // propagates through the chain to make the whole row's full_label null.
        // Chains four CONCAT calls — exercises the recursive AnnotatedProjectExpression strip
 * is a {@code SqlBinaryOperator} (not a {@code SqlFunction}) with {@code SqlKind.OTHER}.
            return;
            row("TECHNOLOGY", "fourteen", "TECHNOLOGY fourteen"),
            row("OFFICE SUPPLIES", "six", "OFFICE SUPPLIES six"),
import java.io.IOException;
            row("OFFICE SUPPLIES", null, null),
            row(null, 8, "Int: 8"),
    /**
 * {@link DatasetProvisioner}; {@link AnalyticsRestTestCase#preserveIndicesUponCompletion()}
            List<Object> want = expected[i];
            row("TECHNOLOGY", "eleven", "A=TECHNOLOGY, B=eleven"),
            row(null, null, null),
 * branch of {@link org.opensearch.analytics.spi.ScalarFunction#fromSqlOperatorWithFallback} since it
package org.opensearch.analytics.qa;
            if (Double.compare(e, a) != 0) {
    @SafeVarargs
        assertRows(
            row("OFFICE SUPPLIES", "five", "A=OFFICE SUPPLIES, B=five"),
            row("two", "Hello two"),
        // RexInputRef inputs (hasFieldRef=true path in resolveScalarViableBackends).
    }
            row("sixteen", 4, "Int: 4"),
            row("FURNITURE", "two", "A=FURNITURE, B=two"),
    // ── helpers ─────────────────────────────────────────────────────────────────
        @SuppressWarnings("unchecked")
        // Pure field-to-field concat through two || calls (str0 + ' ' + str2).
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
        );
        // CAST(null AS STRING) is null; concat with null propagates → label is null.
            row("fifteen", "Hello fifteen"),
    /**
            row("OFFICE SUPPLIES", "six", "A=OFFICE SUPPLIES, B=six"),
import java.util.Arrays;
            row("OFFICE SUPPLIES", "eight", "OFFICE SUPPLIES eight"),
import java.util.Map;
    private final void assertRows(String ppl, List<Object>... expected) throws IOException {
            }
            for (int j = 0; j < want.size(); j++) {
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
            row("one", 1, "Int: 1"),
 * operator (lowered to Calcite's {@code SqlStdOperatorTable.CONCAT}, i.e. the {@code ||}
            row("OFFICE SUPPLIES", "three", "OFFICE SUPPLIES three"),
/*
            return;
            row("TECHNOLOGY", null, null),
            row("TECHNOLOGY", "twelve", "A=TECHNOLOGY, B=twelve"),
            row("eleven", "Hello eleven"),
 *
            row("OFFICE SUPPLIES", null, null),
        );
        // int0 has nulls at rows 1, 2, 3, 7, 8, 12 (per FillNullCommandIT row data).
            double a = ((Number) actual).doubleValue();
        // producing a null greeting (e.g. row index 3 has str2 = null → greeting = null).
 * SPDX-License-Identifier: Apache-2.0
    }
    }
        // for nested project calls (same pattern that fillnull surfaced for ceil(num1)).
        );
            row("OFFICE SUPPLIES", "five", "OFFICE SUPPLIES five"),
     * Numeric-tolerant cell comparison — JSON parsing returns {@code Integer}/{@code Long}/{@code Double}
            row("fourteen", 4, "Int: 4"),
    public void testEvalStringConcatMultipleLiteralsAndFields() throws IOException {
public class EvalCommandIT extends AnalyticsRestTestCase {
     * Lazily provision the calcs dataset on first invocation. Must be called inside a test
    public void testEvalStringConcatLiteralPlusField() throws IOException {
            row("OFFICE SUPPLIES", null, null),
            row("TECHNOLOGY", "sixteen", "TECHNOLOGY sixteen"),
            row("nine", "Hello nine"),
            row("TECHNOLOGY", null, null),
        assertRows(
        assertRows(
            row("TECHNOLOGY", "fifteen", "A=TECHNOLOGY, B=fifteen"),
            "source=" + DATASET.indexName + " | fields str2 | eval greeting = 'Hello ' + str2",
    }
 * <p>Mirrors {@code CalciteEvalCommandIT} from the {@code opensearch-project/sql}
            row("TECHNOLOGY", "fifteen", "TECHNOLOGY fifteen"),
            assertEquals("Column count mismatch at row " + i + " for query: " + ppl, want.size(), got.size());
    public void testEvalStringConcatWithCastIntField() throws IOException {
 * {@link org.opensearch.analytics.spi.ScalarFunction#CONCAT} and
            row("eleven", 4, "Int: 4"),
     * interchangeably. PPL doesn't preserve the distinction at the API surface, so cross-type numeric
        );
        }
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");
            row("TECHNOLOGY", "fourteen", "A=TECHNOLOGY, B=fourteen"),
            row(null, 8, "Int: 8")
            row("eight", "Hello eight"),
    }
            row("nine", null, null),
 *
     */
            row(null, null)
     */
/**
        assertRows(
        Map<String, Object> response = executePpl(ppl);
            row("twelve", "Hello twelve"),
    public void testEvalStringConcatTwoFields() throws IOException {
        for (int i = 0; i < expected.length; i++) {
            row(null, null),
            row("TECHNOLOGY", null, null)
                assertCellEquals("Cell mismatch at row " + i + ", col " + j + " for query: " + ppl, want.get(j), got.get(j));
    // ── chained concat: 'a' + str + 'b' + str' ────────────────────────────────
 * compatible open source license.
     * equality must be measured by {@code double} values rather than {@link Object#equals(Object)}.
            row("twelve", 10, "Int: 10"),
            row("fourteen", "Hello fourteen"),
        // str0 ("FURNITURE"-style) is non-null in calcs; str2 has nulls — null str2
            row("six", "Hello six"),
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
import org.opensearch.client.Response;
            row("FURNITURE", "one", "A=FURNITURE, B=one"),
            row("ten", "Hello ten"),
            row(null, null),
            row("TECHNOLOGY", "nine", "A=TECHNOLOGY, B=nine"),
    private static boolean dataProvisioned = false;
            row("five", "Hello five"),
        assertEquals(message, expected, actual);
    }
import org.opensearch.client.Request;
 * {@code POST /_plugins/_ppl} (exposed by the {@code opensearch-sql} plugin),
    // ── concat between two field references ───────────────────────────────────
    // ── string concat: 'literal' + str_field ──────────────────────────────────
    }
        if (expected == null || actual == null) {
        }
            row("TECHNOLOGY", "eleven", "TECHNOLOGY eleven"),
            row("one", "Hello one"),
 *
            }
            row("two", null, null),
        if (expected instanceof Number && actual instanceof Number) {
            assertEquals(message, expected, actual);
import java.util.List;
}
        if (dataProvisioned == false) {
            row("sixteen", "Hello sixteen"),
 * Self-contained integration test for PPL {@code eval} on the analytics-engine route.
     * reliably available inside test bodies.
 * {@link org.opensearch.analytics.spi.ScalarFunction#CAST} entries in the DataFusion
 * <p>Provisions the {@code calcs} dataset (parquet-backed) once per class via
            row("three", null, null),
        }
 * keeps it across test methods.
            "source=" + DATASET.indexName + " | eval full_label = 'A=' + str0 + ', B=' + str2 | fields str0, str2, full_label",
     * static {@code client()} is not initialized until after {@code @BeforeClass}, but is
 * binary operator) and {@code CAST(... AS STRING)}, both routed through the
     * method (not {@code setUp()}) — {@link org.opensearch.test.rest.OpenSearchRestTestCase}'s
 * <p>The eval surface this test exercises is string concatenation via PPL's {@code +}
            row("OFFICE SUPPLIES", "eight", "A=OFFICE SUPPLIES, B=eight"),
            row("OFFICE SUPPLIES", "three", "A=OFFICE SUPPLIES, B=three"),
 * backend's {@code STANDARD_PROJECT_OPS}. {@code ||} resolves through the symbolic-name
            row("OFFICE SUPPLIES", null, null),
        // No literal-only operands — the planner must accept CONCAT with both
        }
            row("three", "Hello three"),
    @Override
            List<Object> got = actualRows.get(i);
            row("ten", 8, "Int: 8"),
 * repository so that the analytics-engine path can be verified inside core without
            row("TECHNOLOGY", "ten", "TECHNOLOGY ten"),
    private static void assertCellEquals(String message, Object expected, Object actual) {
        return Arrays.asList(values);
            row("TECHNOLOGY", "twelve", "TECHNOLOGY twelve"),
 * cross-plugin dependencies on the SQL plugin. Each test sends a PPL query through
 * this file be licensed under the Apache-2.0 license or a
            row("five", 7, "Int: 7"),
    }
            row("six", 3, "Int: 3"),
 * which runs the same {@code UnifiedQueryPlanner} → {@code CalciteRelNodeVisitor} →
 * The OpenSearch Contributors require contributions made to
    private static List<Object> row(Object... values) {
            DatasetProvisioner.provision(client(), DATASET);
            double e = ((Number) expected).doubleValue();
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
 *
            row(null, null, null),
 */
    @SuppressWarnings("varargs")
    // ── CAST + concat: 'literal' + CAST(int AS STRING) ────────────────────────
            "source=" + DATASET.indexName + " | eval combo = str0 + ' ' + str2 | fields str0, str2, combo",
            row("TECHNOLOGY", null, null)
 */
